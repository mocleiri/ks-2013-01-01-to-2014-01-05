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

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.rice.krms.impl.type.KrmsTypeResolver;
import org.kuali.student.common.util.krms.RulesExecutionConstants;
import org.kuali.student.enrollment.courseregistration.dto.CourseRegistrationInfo;
import org.kuali.student.enrollment.courseregistration.service.CourseRegistrationService;
import org.kuali.student.krms.util.KSKRMSExecutionConstants;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.LocaleInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ks-krms-test-context-mock.xml"})
@Ignore
public class TestEnrolledEffectiveDateFromTermResolver {
    private KrmsTypeResolver typeResolver;

    public ContextInfo callContext = null;
    @Resource(name = "courseRegistrationService")
    private CourseRegistrationService courseRegistrationService;
    private String studentID = "12020303";
    private String TermId = "1001";

    @Before
    public void setUp() {
        callContext = new ContextInfo();
    }


    @Test
    public void testCourseRegistrationServiceNotNull() {
        assertNotNull(courseRegistrationService);
    }

    @Test
    public void testResolve() {
        EnrolledEffectiveDateFromTermResolver termResolver = new EnrolledEffectiveDateFromTermResolver();
        termResolver.setCourseRegistrationService(courseRegistrationService);
        Map<String, Object> resolvedPrereqs = new HashMap<String, Object>();
        Map<String, String> parameters = new HashMap<String, String>();

        ContextInfo context = new ContextInfo();
        context.setLocale(new LocaleInfo());
        context.setPrincipalId("nina");

        resolvedPrereqs.put(RulesExecutionConstants.CONTEXT_INFO_TERM_NAME, context);
        parameters.put(KSKRMSExecutionConstants.PERSON_ID_TERM_PROPERTY, studentID);
        parameters.put(KSKRMSExecutionConstants.TERM_ID_TERM_PROPERTY, TermId);

        List<CourseRegistrationInfo> courseRegistrationRecords = termResolver.resolve(resolvedPrereqs, parameters);
        // TODO Do some assert statements on the expected returned list.
        assertNotNull(courseRegistrationRecords);

    }

}