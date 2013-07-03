/**
 * Copyright 2011 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kuali.student.krms.termresolver;

import org.kuali.rice.krms.api.engine.TermResolutionException;
import org.kuali.rice.krms.api.engine.TermResolver;
import org.kuali.student.enrollment.courseregistration.dto.CourseRegistrationInfo;
import org.kuali.student.enrollment.courseregistration.service.CourseRegistrationService;
import org.kuali.student.krms.util.KSKRMSExecutionUtil;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.util.constants.KSKRMSServiceConstants;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EnrolledCourseTermResolver implements TermResolver<Boolean> {

    private CourseRegistrationService courseRegistrationService;

    @Override
    public Set<String> getPrerequisites() {
        Set<String> temp = new HashSet<String>(2);
        temp.add(KSKRMSServiceConstants.TERM_PREREQUISITE_PERSON_ID);
        temp.add(KSKRMSServiceConstants.TERM_PREREQUISITE_CONTEXTINFO);
        return Collections.unmodifiableSet(temp);
    }

    @Override
    public String getOutput() {
        return KSKRMSServiceConstants.TERM_RESOLVER_ENROLLEDCOURSE;
    }

    @Override
    public Set<String> getParameterNames() {
        return Collections.singleton(KSKRMSServiceConstants.TERM_PARAMETER_TYPE_CLU_KEY);
    }

    @Override
    public int getCost() {
        // TODO Analyze, though probably not much to check here
        return 1;
    }

    @Override
    public Boolean resolve(Map<String, Object> resolvedPrereqs, Map<String, String> parameters) throws TermResolutionException {

        String courseOfferingIds = parameters.get(KSKRMSServiceConstants.TERM_PARAMETER_TYPE_CLU_KEY);
        Boolean result = false;

        courseOfferingIds = courseOfferingIds.trim();
        String[] courseOfferingId = courseOfferingIds.split(",");
        int testNumber = 0;

        List<CourseRegistrationInfo> registrationInfos = this.getCourseRegistrationsForStudent(resolvedPrereqs, parameters);

        if(courseOfferingIds.contains(",")) {
            for(CourseRegistrationInfo cri : registrationInfos) {
                for(String cc : courseOfferingId) {
                    if(cc.equals(cri.getCourseOfferingId())){
                        testNumber++;
                    }
                }
            }
            if(courseOfferingId.length == testNumber){
                result = true;
            }
        } else {
            for(CourseRegistrationInfo temp : registrationInfos) {
                if(temp.getCourseOfferingId().equals(courseOfferingIds)){
                    result = true;
                }
            }
        }

        return result;
    }

    private List<CourseRegistrationInfo> getCourseRegistrationsForStudent(Map<String, Object> resolvedPrereqs, Map<String, String> parameters){

        ContextInfo context = (ContextInfo) resolvedPrereqs.get(KSKRMSServiceConstants.TERM_PREREQUISITE_CONTEXTINFO);
        String personId = (String) resolvedPrereqs.get(KSKRMSServiceConstants.TERM_PREREQUISITE_PERSON_ID);

        List<CourseRegistrationInfo> registrationInfos = null;
        try {
            registrationInfos = this.getCourseRegistrationService().getCourseRegistrationsByStudent(personId, context);
        } catch (Exception e) {
            KSKRMSExecutionUtil.convertExceptionsToTermResolutionException(parameters, e, this);
        }

        return registrationInfos;
    }

    public CourseRegistrationService getCourseRegistrationService() {
        return courseRegistrationService;
    }

    public void setCourseRegistrationService(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService = courseRegistrationService;
    }

}
