package org.kuali.student.enrollment.class2.courseoffering.service.impl;

import org.apache.commons.lang.StringUtils;
import org.kuali.student.enrollment.class2.courseoffering.dto.ActivityOfferingWrapper;
import org.kuali.student.enrollment.class2.courseoffering.service.CO_AO_RG_ViewHelperService;
import org.kuali.student.enrollment.class2.courseoffering.util.CourseOfferingResourceLoader;
import org.kuali.student.enrollment.class2.courseoffering.util.CourseOfferingViewHelperUtil;
import org.kuali.student.enrollment.courseoffering.dto.ActivityOfferingInfo;
import org.kuali.student.enrollment.courseoffering.dto.FormatOfferingInfo;
import org.kuali.student.enrollment.courseoffering.dto.OfferingInstructorInfo;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingService;
import org.kuali.student.common.uif.service.impl.KSViewHelperServiceImpl;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.TimeOfDayInfo;
import org.kuali.student.r2.common.util.ContextUtils;
import org.kuali.student.r2.common.util.constants.CourseOfferingServiceConstants;
import org.kuali.student.r2.common.util.constants.LuiServiceConstants;
import org.kuali.student.r2.common.util.date.DateFormatters;
import org.kuali.student.r2.core.class1.state.dto.StateInfo;
import org.kuali.student.r2.core.class1.state.service.StateService;
import org.kuali.student.r2.core.class1.type.dto.TypeInfo;
import org.kuali.student.r2.core.class1.type.service.TypeService;
import org.kuali.student.r2.core.room.dto.BuildingInfo;
import org.kuali.student.r2.core.room.dto.RoomInfo;
import org.kuali.student.r2.core.room.service.RoomService;
import org.kuali.student.r2.core.scheduling.constants.SchedulingServiceConstants;
import org.kuali.student.r2.core.scheduling.dto.ScheduleComponentInfo;
import org.kuali.student.r2.core.scheduling.dto.ScheduleInfo;
import org.kuali.student.r2.core.scheduling.dto.ScheduleRequestComponentInfo;
import org.kuali.student.r2.core.scheduling.dto.ScheduleRequestInfo;
import org.kuali.student.r2.core.scheduling.dto.ScheduleRequestSetInfo;
import org.kuali.student.r2.core.scheduling.dto.TimeSlotInfo;
import org.kuali.student.r2.core.scheduling.service.SchedulingService;
import org.kuali.student.r2.lum.course.service.CourseService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CO_AO_RG_ViewHelperServiceImpl extends KSViewHelperServiceImpl implements CO_AO_RG_ViewHelperService{

    protected CourseService courseService;
    protected TypeService typeService;
    protected StateService stateService;
    protected SchedulingService schedulingService;
    protected RoomService roomService;

    public ActivityOfferingWrapper convertAOInfoToWrapper(ActivityOfferingInfo aoInfo) throws Exception{

        ActivityOfferingWrapper aoWrapper = new ActivityOfferingWrapper(aoInfo);

        int firstValue = 0;

        ContextInfo contextInfo = createContextInfo();

        StateInfo state = getStateInfo(aoInfo.getStateKey());
        aoWrapper.setStateName(state.getName());

        TypeInfo typeInfo = getTypeInfo(aoInfo.getTypeKey());
        aoWrapper.setTypeName(typeInfo.getName());

        List<ScheduleRequestSetInfo>  scheduleRequestSetInfoList = getSchedulingService().getScheduleRequestSetsByRefObject(CourseOfferingServiceConstants.REF_OBJECT_URI_ACTIVITY_OFFERING,
                aoInfo.getId(), contextInfo);

        if(scheduleRequestSetInfoList != null && scheduleRequestSetInfoList.size() > 0) {

            StringBuffer buffer = new StringBuffer();
            buffer.append(" ");
            CourseOfferingService coService = CourseOfferingResourceLoader.loadCourseOfferingService();

            if (!scheduleRequestSetInfoList.isEmpty()){
                for(ScheduleRequestSetInfo coloSet : scheduleRequestSetInfoList) {
                    List<ActivityOfferingInfo> aoList = coService.getActivityOfferingsByIds(coloSet.getRefObjectIds(), createContextInfo());
                    for(ActivityOfferingInfo coloActivity : aoList) {
                        if (!StringUtils.equals(coloActivity.getId(),aoInfo.getId())){
                            buffer.append(coloActivity.getCourseOfferingCode() + " " + coloActivity.getActivityCode() + "<br>");
                        }
                    }
                }
                aoWrapper.setColocatedAoInfo(buffer.toString());
            }
         }

        FormatOfferingInfo fo = getCourseOfferingService().getFormatOffering(aoInfo.getFormatOfferingId(), contextInfo);
        aoWrapper.setFormatOffering(fo);

        OfferingInstructorInfo displayInstructor = CourseOfferingViewHelperUtil.findDisplayInstructor(aoInfo.getInstructors());

        if(displayInstructor != null) {
            aoWrapper.setFirstInstructorDisplayName(displayInstructor.getPersonName());
        }

        //for multiple instructor display
        List<OfferingInstructorInfo> instructorInfos = aoInfo.getInstructors();
        if (instructorInfos != null) {
            for (OfferingInstructorInfo offeringInstructorInfo : instructorInfos) {
                aoWrapper.setInstructorDisplayNames(offeringInstructorInfo.getPersonName(), true);
            }
        }

        //This section is to display either schedule request or actuals. If actuals available, display that instead of request
        if (aoInfo.getScheduleIds() != null && aoInfo.getScheduleIds().size() > 0) {
            //FIXME: Use display object once we get the TBA with ScheduleComponentDisplay

            /*ScheduleDisplayInfo displayInfo = getSchedulingService().getScheduleDisplay(aoInfo.getScheduleId(),contextInfo);
            if (!displayInfo.getScheduleComponentDisplays().isEmpty()){
                ScheduleComponentDisplay componentDisplay = displayInfo.getScheduleComponentDisplays().get(0);
                updateScheduleToAOWrapperForDisplay(aoWrapper,Boolean.FALSE,componentDisplay.getRoom(),componentDisplay.getTimeSlots().get(0));

            }*/

            List<ScheduleInfo> scheduleInfoList = getSchedulingService().getSchedulesByIds(aoInfo.getScheduleIds(), contextInfo);

            if (!scheduleInfoList.isEmpty()) {
                for (ScheduleInfo scheduleInfo : scheduleInfoList) {
                    if (!scheduleInfo.getScheduleComponents().isEmpty()) {

                        boolean appendScheduleRowDisplay = false;

                        for (ScheduleComponentInfo scheduleComponentInfo : scheduleInfo.getScheduleComponents()) {

                            String roomId = scheduleComponentInfo.getRoomId();
                            // JIRA Fix : KSENROLL-8726. Added isEmpty check
                            TimeSlotInfo timeSlotInfo = getSchedulingService().getTimeSlot(scheduleComponentInfo.getTimeSlotIds().isEmpty() ? StringUtils.EMPTY : scheduleComponentInfo.getTimeSlotIds().get(firstValue), contextInfo);

                            updateScheduleToAOWrapperForDisplay(aoWrapper, scheduleComponentInfo.getIsTBA(), roomId, timeSlotInfo, appendScheduleRowDisplay);

                            if (!appendScheduleRowDisplay) {
                                appendScheduleRowDisplay = true;
                            }
                        }

                    }
                }
            }

        }else{

            List<ScheduleRequestInfo> scheduleRequestInfoList;

            scheduleRequestInfoList = getSchedulingService().getScheduleRequestsByRefObject(CourseOfferingServiceConstants.REF_OBJECT_URI_ACTIVITY_OFFERING, aoInfo.getId(), contextInfo);

            if (!scheduleRequestInfoList.isEmpty()){

                boolean appendScheduleRowDisplay = false;

                for (ScheduleRequestComponentInfo componentInfo : scheduleRequestInfoList.get(firstValue).getScheduleRequestComponents()) {
                    String roomId = componentInfo.getRoomIds().isEmpty() ? StringUtils.EMPTY : componentInfo.getRoomIds().get(firstValue);
                    // Changes made as part of KSENROLL-8726. Added isEmpty check
                    TimeSlotInfo timeSlotInfo =  getSchedulingService().getTimeSlot(componentInfo.getTimeSlotIds().isEmpty() ? StringUtils.EMPTY : componentInfo.getTimeSlotIds().get(firstValue),contextInfo);

                    updateScheduleToAOWrapperForDisplay(aoWrapper,componentInfo.getIsTBA(),roomId,timeSlotInfo,appendScheduleRowDisplay);

                    if (!appendScheduleRowDisplay){
                        appendScheduleRowDisplay = true;
                    }
                }
            }

        }

        return aoWrapper;
    }

    private void updateScheduleToAOWrapperForDisplay(ActivityOfferingWrapper aoWrapper, Boolean isTBA,String roomId,TimeSlotInfo timeSlot,boolean append) throws Exception{
        RoomInfo roomInfo = null;
        if (StringUtils.isNotBlank(roomId)){
            roomInfo = getRoomService().getRoom(roomId, ContextUtils.createDefaultContextInfo());
        }
        updateScheduleToAOWrapperForDisplay(aoWrapper,isTBA,roomInfo,timeSlot,append);
    }

    private void updateScheduleToAOWrapperForDisplay(ActivityOfferingWrapper aoWrapper, Boolean isTBA, RoomInfo roomInfo,TimeSlotInfo timeSlot,boolean append) throws Exception{

        Calendar calendar = new GregorianCalendar();

        aoWrapper.setTbaDisplayName(isTBA,append);

        if (timeSlot != null) {

            TimeOfDayInfo startTime = timeSlot.getStartTime();
            TimeOfDayInfo endTime = timeSlot.getEndTime();
            List<Integer> days = timeSlot.getWeekdays();

            if (startTime != null && startTime.getMilliSeconds() != null) {
                calendar.setTimeInMillis(startTime.getMilliSeconds());
                aoWrapper.setStartTimeDisplay(DateFormatters.HOUR_MINUTE_AM_PM_TIME_FORMATTER.format(calendar.getTime()),append);
            }

            if (endTime != null && endTime.getMilliSeconds() != null) {
                calendar.setTimeInMillis(endTime.getMilliSeconds());
                aoWrapper.setEndTimeDisplay(DateFormatters.HOUR_MINUTE_AM_PM_TIME_FORMATTER.format(calendar.getTime()),append);
            }

            if (days != null && days.size() > 0) {
                aoWrapper.setDaysDisplayName(getDays(days),append);
            }
        }

        if (roomInfo != null && StringUtils.isNotBlank(roomInfo.getBuildingId())) {
            BuildingInfo buildingInfo = getRoomService().getBuilding(roomInfo.getBuildingId(), ContextUtils.createDefaultContextInfo());
            aoWrapper.setBuildingName(buildingInfo.getName(),append);
            aoWrapper.setRoomName(roomInfo.getRoomCode(),append);
        }
    }

    private String getDays(List<Integer> intList) {

        StringBuilder sb = new StringBuilder();
        if(intList == null) return sb.toString();

        for(Integer d : intList) {
            sb.append(convertIntoDays(d));
        }
        return sb.toString();
    }

    private String convertIntoDays(int day) {
        String dayOfWeek;
        switch (day) {
            case 1:
                dayOfWeek = SchedulingServiceConstants.SUNDAY_TIMESLOT_DAY_CODE;
                break;
            case 2:
                dayOfWeek = SchedulingServiceConstants.MONDAY_TIMESLOT_DAY_CODE;
                break;
            case 3:
                dayOfWeek = SchedulingServiceConstants.TUESDAY_TIMESLOT_DAY_CODE;
                break;
            case 4:
                dayOfWeek = SchedulingServiceConstants.WEDNESDAY_TIMESLOT_DAY_CODE;
                break;
            case 5:
                dayOfWeek = SchedulingServiceConstants.THURSDAY_TIMESLOT_DAY_CODE;
                break;
            case 6:
                dayOfWeek = SchedulingServiceConstants.FRIDAY_TIMESLOT_DAY_CODE;
                break;
            case 7:
                dayOfWeek = SchedulingServiceConstants.SATURDAY_TIMESLOT_DAY_CODE;
                break;
            default:
                dayOfWeek = StringUtils.EMPTY;
        }
        // TODO implement TBA when service stores it.
        return dayOfWeek;
    }

    public CourseOfferingService getCourseOfferingService() {
        return CourseOfferingResourceLoader.loadCourseOfferingService();
    }

    public SchedulingService getSchedulingService() {
        if(schedulingService == null)  {
            schedulingService = CourseOfferingResourceLoader.loadSchedulingService();
        }
        return schedulingService;
    }

    public RoomService getRoomService(){
        if (roomService == null){
            roomService = CourseOfferingResourceLoader.loadRoomService();
        }
        return roomService;
    }

}
