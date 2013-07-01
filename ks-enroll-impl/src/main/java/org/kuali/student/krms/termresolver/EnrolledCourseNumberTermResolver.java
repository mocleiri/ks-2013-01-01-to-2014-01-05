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
import org.kuali.student.common.util.krms.RulesExecutionConstants;
import org.kuali.student.enrollment.academicrecord.dto.StudentCourseRecordInfo;
import org.kuali.student.enrollment.academicrecord.service.AcademicRecordService;
import org.kuali.student.enrollment.courseregistration.dto.CourseRegistrationInfo;
import org.kuali.student.enrollment.courseregistration.service.CourseRegistrationService;
import org.kuali.student.krms.util.KSKRMSExecutionUtil;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.util.constants.KSKRMSServiceConstants;
import org.kuali.student.r2.core.atp.dto.MilestoneInfo;
import org.kuali.student.r2.core.atp.service.AtpService;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EnrolledCourseNumberTermResolver implements TermResolver<Integer> {

    private CourseRegistrationService courseRegistrationService;

    private final static Set<String> prerequisites = new HashSet<String>(2);

    static {
        prerequisites.add(KSKRMSServiceConstants.PERSON_ID_TERM_PROPERTY);
        prerequisites.add(KSKRMSServiceConstants.CONTEXT_INFO_TERM_NAME);
    }
    
    public CourseRegistrationService getCourseRegistrationService() {
        return courseRegistrationService;
    }

    public void setCourseRegistrationService(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService = courseRegistrationService;
    }

    @Override
    public Set<String> getPrerequisites() {
        return prerequisites;
    }

    @Override
    public String getOutput() {
        return KSKRMSServiceConstants.ENROLLED_COURSE_NUMBER_TERM_NAME;
    }

    @Override
    public Set<String> getParameterNames() {
        return Collections.singleton(KSKRMSServiceConstants.COURSE_ID_TERM_PROPERTY);
    }

    @Override
    public int getCost() {
        // TODO Analyze, though probably not much to check here
        return 5;
    }

    @Override
    public Integer resolve(Map<String, Object> resolvedPrereqs, Map<String, String> parameters) throws TermResolutionException {
        ContextInfo context = (ContextInfo) resolvedPrereqs.get(KSKRMSServiceConstants.CONTEXT_INFO_TERM_NAME);
        String personId = (String) resolvedPrereqs.get(KSKRMSServiceConstants.PERSON_ID_TERM_PROPERTY);
        String courseOfferingIds = parameters.get(KSKRMSServiceConstants.COURSE_ID_TERM_PROPERTY);
        
        List<CourseRegistrationInfo> recordInfoList = null;
        Integer result = 0;
        try {
            recordInfoList = courseRegistrationService.getCourseRegistrationsByStudent(personId, context);
        } catch (InvalidParameterException e) {
            throw new TermResolutionException(e.getMessage(), this, parameters);
        } catch (MissingParameterException e) {
            throw new TermResolutionException(e.getMessage(), this, parameters);
        } catch (OperationFailedException e) {
            throw new TermResolutionException(e.getMessage(), this, parameters);
        } catch (PermissionDeniedException e) {
            throw new TermResolutionException(e.getMessage(), this, parameters);
        }

        courseOfferingIds = courseOfferingIds.trim();
        String[] courseOfferingId = courseOfferingIds.split(",");

        if(courseOfferingIds.contains(",")) {
            for(CourseRegistrationInfo cri : recordInfoList) {
                for(String cc : courseOfferingId) {
                    if(cc.equals(cri.getCourseOfferingId())){
                        result++;
                    }
                }
            }
        } else {
            for(CourseRegistrationInfo temp : recordInfoList) {
                if(temp.getCourseOfferingId().equals(courseOfferingIds)){
                    result++;
                }
            }
        }

        return result;
    }
}
