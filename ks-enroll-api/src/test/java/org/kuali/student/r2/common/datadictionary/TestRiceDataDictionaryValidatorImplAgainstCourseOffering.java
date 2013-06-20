/*
 * Copyright 2011 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.r2.common.datadictionary;

import org.junit.Test;
import org.kuali.student.enrollment.courseoffering.dto.CourseOfferingInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.infc.ValidationResult;
import org.kuali.student.r2.common.util.constants.LuiServiceConstants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author nwright
 */
public class TestRiceDataDictionaryValidatorImplAgainstCourseOffering {

    public TestRiceDataDictionaryValidatorImplAgainstCourseOffering() {
    }

    private Date parseDate(String str) {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = df.parse(str);
        } catch (ParseException ex) {
            throw new IllegalArgumentException(str, ex);
        }
        return date;
    }

    private ContextInfo getContext1() {
        return ContextInfo.getInstance("principalId.1", "en", "us");
    }
    private static DataDictionaryValidator validator;

    public DataDictionaryValidator getValidator() {
        if (validator == null) {
            ApplicationContext appContext =
                    new ClassPathXmlApplicationContext(new String[]{"classpath:testContext.xml"});
            validator = (DataDictionaryValidator) appContext.getBean("testValidator");
        }
        return validator;
    }
   

    private CourseOfferingInfo getDefaultCourseOfferingInfo() {
        CourseOfferingInfo co = new CourseOfferingInfo();
        co.setTypeKey(LuiServiceConstants.COURSE_OFFERING_TYPE_KEY);
        co.setStateKey(LuiServiceConstants.LUI_DRAFT_STATE_KEY);
        co.setCourseId("fake-course-id");
        co.setTermId("fake-term-key");
//        co.setEffectiveDate(this.parseDate("2011-01-01"));
        return co;
    }

    /**
     * Test of validate method, of class RiceValidatorImpl.
     */
    @Test
    public void testValidate1() throws Exception {
        System.out.println("tests basic validation");
        DataDictionaryValidator.ValidationType validationType = null;
        CourseOfferingInfo co = null;
        ContextInfo context = null;

        DataDictionaryValidator intstance = this.getValidator();
        List<ValidationResultInfo> result = null;

        validationType = DataDictionaryValidator.ValidationType.FULL_VALIDATION;
        co = this.getDefaultCourseOfferingInfo();
        context = getContext1();
        result = intstance.validate(validationType, co, context);
        for (ValidationResult vri : result) {
            System.out.println(vri.getElement() + " " + vri.getLevel() + " " + vri.getMessage());
        }
        assertEquals(0, result.size());
    }

}
