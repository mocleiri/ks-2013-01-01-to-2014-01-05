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

import org.kuali.rice.krad.datadictionary.validation.constraint.ValidCharactersConstraint;
import org.kuali.student.r2.common.datadictionary.infc.ValidCharactersConstraintInfc;

/**
 *
 * @author nwright
 */
public class Student2RiceValidCharactersConstraintConverter {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Student2RiceValidCharactersConstraintConverter.class);

    public ValidCharactersConstraint convert(ValidCharactersConstraintInfc student) {
       ValidCharactersConstraint rice = new ValidCharactersConstraint ();
       rice.setApplyClientSide(student.getIsApplyClientSide());
//       rice.setJsValue(student.getJsValue());
//       rice.setLabelKey(student.getLabelKey());
       rice.setValue (student.getValue());
       return rice;
    }
}
