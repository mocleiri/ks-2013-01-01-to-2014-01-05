package org.kuali.student.enrollment.registration.ui.impl;

import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.student.enrollment.courseregistration.dto.RegistrationRequestInfo;
import org.kuali.student.enrollment.courseregistration.dto.RegistrationRequestItemInfo;
import org.kuali.student.enrollment.courseregistration.dto.RegistrationResponseInfo;
import org.kuali.student.enrollment.courseregistration.service.CourseRegistrationService;
import org.kuali.student.enrollment.registration.ui.CourseRegistrationUiService;
import org.kuali.student.enrollment.ui.registration.ScheduleOfClassesService;
import org.kuali.student.enrollment.ui.registration.ScheduleOfClassesServiceConstants;
import org.kuali.student.enrollment.ui.registration.dto.RegGroupSearchResult;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.util.ContextUtils;
import org.kuali.student.r2.common.util.constants.CourseRegistrationServiceConstants;
import org.kuali.student.r2.common.util.constants.LprServiceConstants;

import javax.security.auth.login.LoginException;
import javax.ws.rs.PathParam;
import javax.xml.namespace.QName;

/**
 * Created by swedev on 1/3/14.
 */
public class CourseRegistrationUiServiceImpl implements CourseRegistrationUiService {

    ScheduleOfClassesService scheduleOfClassesService;
    private CourseRegistrationService courseRegistrationService;

    @Override
    public RegistrationResponseInfo RegisterForRegistrationGroupByTermCodeAndCourseCodeAndRegGroupName(@PathParam("termCode") String termCode, @PathParam("courseCode") String courseCode, @PathParam("regGroupName") String regGroupName) throws Exception {
        ContextInfo contextInfo = ContextUtils.createDefaultContextInfo();

        if(contextInfo.getPrincipalId() == null || "".equals(contextInfo.getPrincipalId())){
            throw new LoginException("User must be logged in to access this service");
        }

        RegGroupSearchResult regGroupSearchResult = getScheduleOfClassesService().loadRegistrationGroupByTermCodeAndCourseCodeAndRegGroupName(termCode, courseCode, regGroupName);

        RegistrationRequestInfo regReqInfo = new RegistrationRequestInfo();
        regReqInfo.setRequestorId(contextInfo.getPrincipalId());
        regReqInfo.setTermId(getScheduleOfClassesService().getAtpIdByAtpCode(termCode)); // bad bc we have it from the load call above
        regReqInfo.setStateKey("reggroup.enroll.persist"); // making this up for poc
        regReqInfo.setTypeKey(LprServiceConstants.LPRTRANS_REGISTER_TYPE_KEY);

        RegistrationRequestItemInfo registrationRequestItem = new RegistrationRequestItemInfo();
        registrationRequestItem.setTypeKey("registration.request.item");
        registrationRequestItem.setStateKey("registration.request.item.active");
        registrationRequestItem.setExistingRegistrationGroupId(regGroupSearchResult.getRegGroupId());
        registrationRequestItem.setStudentId(contextInfo.getPrincipalId());


        regReqInfo.getRegistrationRequestItems().add(registrationRequestItem);

        RegistrationRequestInfo newRegReq = getCourseRegistrationService().createRegistrationRequest(LprServiceConstants.LPRTRANS_REGISTER_TYPE_KEY, regReqInfo, contextInfo);

        RegistrationResponseInfo registrationResponseInfo = getCourseRegistrationService().submitRegistrationRequest(newRegReq.getId(), contextInfo);

        return registrationResponseInfo;
    }

    public ScheduleOfClassesService getScheduleOfClassesService() {

        if (scheduleOfClassesService == null){
            scheduleOfClassesService = (ScheduleOfClassesService) GlobalResourceLoader.getService(new QName(ScheduleOfClassesServiceConstants.NAMESPACE, ScheduleOfClassesServiceConstants.SERVICE_NAME_LOCAL_PART));
        }
        return scheduleOfClassesService;
    }

    public void setScheduleOfClassesService(ScheduleOfClassesService scheduleOfClassesService) {
        this.scheduleOfClassesService = scheduleOfClassesService;
    }

    public CourseRegistrationService getCourseRegistrationService() {
        if (courseRegistrationService == null){
            courseRegistrationService = (CourseRegistrationService) GlobalResourceLoader.getService(new QName(CourseRegistrationServiceConstants.NAMESPACE, CourseRegistrationServiceConstants.SERVICE_NAME_LOCAL_PART));
        }

        return courseRegistrationService;
    }

    public void setCourseRegistrationService(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService = courseRegistrationService;
    }
}
