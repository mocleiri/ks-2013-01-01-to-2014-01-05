package org.kuali.student.enrollment.class2.coursewaitlist.service.facade;

import org.kuali.student.enrollment.courseoffering.dto.ActivityOfferingInfo;
import org.kuali.student.enrollment.courseoffering.dto.CourseOfferingInfo;
import org.kuali.student.enrollment.courseoffering.dto.FormatOfferingInfo;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingService;
import org.kuali.student.enrollment.coursewaitlist.dto.CourseWaitListInfo;
import org.kuali.student.enrollment.coursewaitlist.service.CourseWaitListService;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.exceptions.ReadOnlyException;
import org.kuali.student.r2.common.exceptions.VersionMismatchException;
import org.kuali.student.r2.common.util.constants.CourseWaitListServiceConstants;
import org.kuali.student.r2.common.dto.ContextInfo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class CourseWaitListServiceFacadeImpl implements CourseWaitListServiceFacade{
    @Resource(name="coService")
    private CourseOfferingService coService;
    
    @Resource(name="courseWaitListService")
    private CourseWaitListService courseWaitListService;

    @Resource(name="automaticallyProcessed")
    private Boolean automaticallyProcessed;

    @Resource(name="confirmationRequired")
    private Boolean confirmationRequired;

    @Resource(name="allowHoldUntilEntries")
    private Boolean allowHoldUntilEntries;

    @Resource(name="checkInRequired")
    private Boolean checkInRequired;



    /**
     *
     * This method creates/updates new waitListInfo with inactive state for AO from CO.
     * <p>
     *     when activate waitlist in CO level, we want to automatically activate all waitlists in associated AO level.
     * </p>
     *
     * @param coId input Course Offering id
     * @Param context
     */
    public void activateActivityOfferingWaitlistsByCourseOffering(String coId, ContextInfo context) throws PermissionDeniedException, MissingParameterException, InvalidParameterException, OperationFailedException, DoesNotExistException, ReadOnlyException, DataValidationErrorException, VersionMismatchException {
        List<ActivityOfferingInfo> aoInfos = coService.getActivityOfferingsByCourseOffering(coId, context) ;
        if (null == aoInfos || aoInfos.isEmpty()){
            return;
        }
        for (ActivityOfferingInfo aoInfo : aoInfos) {
            List<CourseWaitListInfo> waitListInfos = courseWaitListService.getCourseWaitListsByActivityOffering(aoInfo.getId(), context);
            if (waitListInfos.isEmpty()){
                //create a new waitListInfo with default setting
                CourseWaitListInfo theWaitListInfo = new CourseWaitListInfo();
                theWaitListInfo.getActivityOfferingIds().add(aoInfo.getId());
                theWaitListInfo.getFormatOfferingIds().add(aoInfo.getFormatOfferingId());
                theWaitListInfo = setCourseWaitListWithDefaultValues(theWaitListInfo);
                courseWaitListService.createCourseWaitList(CourseWaitListServiceConstants.COURSE_WAIT_LIST_WAIT_TYPE_KEY,
                        theWaitListInfo, context);
            }
            else{
                for (CourseWaitListInfo waitListInfo : waitListInfos){
                    waitListInfo = setCourseWaitListWithDefaultValues(waitListInfo);
                    courseWaitListService.updateCourseWaitList(waitListInfo.getId(), waitListInfo, context);
                }
            }
        }
    }

    /**
     *
     * This method creates/updates new waitListInfo for AO from CO.
     * <p>
     *     when activate waitlist(with inactive state) in CO level, we want to automatically activate all waitlists (with inactive state) in associated AO level.
     * </p>
     *
     * @param coId input Course Offering id
     * @Param context
     */

    public void deactivateActivityOfferingWaitlistsByCourseOffering(String coId, ContextInfo context) throws PermissionDeniedException, MissingParameterException, InvalidParameterException, OperationFailedException, DoesNotExistException, ReadOnlyException, DataValidationErrorException, VersionMismatchException {
        List<ActivityOfferingInfo> aoInfos = coService.getActivityOfferingsByCourseOffering(coId, context) ;
        if (aoInfos == null || aoInfos.isEmpty()){
            return;
        }
        for (ActivityOfferingInfo aoInfo : aoInfos) {
            List<CourseWaitListInfo> waitListInfos = courseWaitListService.getCourseWaitListsByActivityOffering(aoInfo.getId(), context);

            if(waitListInfos == null)    {
                return;
            }
            if (waitListInfos.isEmpty()){
                //create a new waitListInfo with the inactive state
                CourseWaitListInfo theWaitListInfo = new CourseWaitListInfo();
                theWaitListInfo.getActivityOfferingIds().add(aoInfo.getId());
                theWaitListInfo.getFormatOfferingIds().add(aoInfo.getFormatOfferingId());
                theWaitListInfo.setStateKey(CourseWaitListServiceConstants.COURSE_WAIT_LIST_INACTIVE_STATE_KEY);
                courseWaitListService.createCourseWaitList(CourseWaitListServiceConstants.COURSE_WAIT_LIST_WAIT_TYPE_KEY,
                        theWaitListInfo, context);
            }
            else {
                for (CourseWaitListInfo waitListInfo : waitListInfos){
                    waitListInfo.setStateKey(CourseWaitListServiceConstants.COURSE_WAIT_LIST_INACTIVE_STATE_KEY);
                    courseWaitListService.updateCourseWaitList(waitListInfo.getId(), waitListInfo, context);
                }
            }
        }
    }

    /* Create a new CourseWaitListInfo (CWLI) for a specified AO and persist it in DB
       1)set AOInfo.id to courseWaitListInfo.activityOfferingIds
       2)set AOInfo.formatOfferingId to courseWaitListInfo.formatOfferingIds
       3)if COInfo.hasWaitList = true, set courseWaitListInfo.stateKey to active and set automaticallyProcessed,
            confirmationRequired, checkInRequired, and allowHoldUntilEntries in courseWaitListInfo to true
       4)if COInfo.hasWaitList = false, set courseWaitListInfo.stateKey to inactive and set automaticallyProcessed,
            confirmationRequired, checkInRequired, and allowHoldUntilEntries in courseWaitListInfo to false
    */
    public CourseWaitListInfo createDefaultCourseWaitlist(ActivityOfferingInfo aoInfo, ContextInfo context)
            throws InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException, DoesNotExistException, DataValidationErrorException, ReadOnlyException {

        //need to get the value of coInfo.hasWaitList to set stateKey and other default values
        FormatOfferingInfo foInfo = coService.getFormatOffering(aoInfo.getFormatOfferingId(), context);
        CourseOfferingInfo coInfo = coService.getCourseOffering(foInfo.getCourseOfferingId(), context);

        return createDefaultCourseWaitlist(aoInfo.getFormatOfferingId(), aoInfo.getId(), coInfo.getHasWaitlist(), context);


    }

    /* Create a new CourseWaitListInfo (CWLI) for a specified AO and persist it in DB

        If possible, use this method. The other Method is MUCH less efficient.

       1)set AOInfo.id to courseWaitListInfo.activityOfferingIds
       2)set AOInfo.formatOfferingId to courseWaitListInfo.formatOfferingIds
       3)if COInfo.hasWaitList = true, set courseWaitListInfo.stateKey to active and set automaticallyProcessed,
            confirmationRequired, checkInRequired, and allowHoldUntilEntries in courseWaitListInfo to true
       4)if COInfo.hasWaitList = false, set courseWaitListInfo.stateKey to inactive and set automaticallyProcessed,
            confirmationRequired, checkInRequired, and allowHoldUntilEntries in courseWaitListInfo to false
    */
    public CourseWaitListInfo createDefaultCourseWaitlist(String foId, String aoId, boolean coHasWaitlist, ContextInfo context)
            throws InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException, DoesNotExistException, DataValidationErrorException, ReadOnlyException {
        CourseWaitListInfo courseWaitListInfo = new CourseWaitListInfo();
        List<String> aoIds = new ArrayList<String>();
        aoIds.add(aoId);
        courseWaitListInfo.setActivityOfferingIds(aoIds);
        List<String> foIds = new ArrayList<String> ();
        foIds.add(foId);
        courseWaitListInfo.setFormatOfferingIds(foIds);
        courseWaitListInfo.setTypeKey(CourseWaitListServiceConstants.COURSE_WAIT_LIST_WAIT_TYPE_KEY);

        //need to get the value of coInfo.hasWaitList to set stateKey and other default values

        if (coHasWaitlist){
            courseWaitListInfo.setStateKey(CourseWaitListServiceConstants.COURSE_WAIT_LIST_ACTIVE_STATE_KEY);
            //default setting is semi-automatic
            courseWaitListInfo = setCourseWaitListWithDefaultValues(courseWaitListInfo);
        }
        else{
            courseWaitListInfo.setStateKey(CourseWaitListServiceConstants.COURSE_WAIT_LIST_INACTIVE_STATE_KEY);
            courseWaitListInfo.setAllowHoldUntilEntries(false);
            courseWaitListInfo.setAutomaticallyProcessed(false);
            courseWaitListInfo.setConfirmationRequired(false);
            courseWaitListInfo.setCheckInRequired(false);
        }
        courseWaitListInfo = courseWaitListService.createCourseWaitList(CourseWaitListServiceConstants.COURSE_WAIT_LIST_WAIT_TYPE_KEY,
                courseWaitListInfo, context);
        return courseWaitListInfo;
    }



    /*
     * automatic -> automaticallyProcessed = true, confirmationRequired = false
     * semi-automatic -> automaticallyProcessed = true, confirmationRequired = true
     * manual -> automaticallyProcessed = false, confirmationRequired = false 
     */
    private CourseWaitListInfo setCourseWaitListWithDefaultValues(CourseWaitListInfo courseWaitListInfo) {
        courseWaitListInfo.setStateKey(CourseWaitListServiceConstants.COURSE_WAIT_LIST_ACTIVE_STATE_KEY);
        //default setting is semi-automatic
        courseWaitListInfo.setAutomaticallyProcessed(automaticallyProcessed);
        courseWaitListInfo.setConfirmationRequired(confirmationRequired);

        courseWaitListInfo.setAllowHoldUntilEntries(allowHoldUntilEntries);
        courseWaitListInfo.setCheckInRequired(checkInRequired);
        return courseWaitListInfo;
    }

    public void setCoService(CourseOfferingService coService) {
        this.coService = coService;
    }

    public void setCourseWaitListService(CourseWaitListService courseWaitListService) {
        this.courseWaitListService = courseWaitListService;
    }

    public void setAutomaticallyProcessed(Boolean automaticallyProcessed) {
        this.automaticallyProcessed = automaticallyProcessed;
    }

    public void setConfirmationRequired (Boolean confirmationRequired) {
        this.confirmationRequired = confirmationRequired;
    }

    public void setAllowHoldUntilEntries (Boolean allowHoldUntilEntries) {
        this.allowHoldUntilEntries = allowHoldUntilEntries;
    }

    public void setCheckInRequired (boolean checkInRequired) {
        this.checkInRequired = checkInRequired;
    }

}
