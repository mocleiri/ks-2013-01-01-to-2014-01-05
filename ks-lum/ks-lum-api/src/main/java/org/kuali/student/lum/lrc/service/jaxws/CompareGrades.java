/**
 * Copyright 2010 The Kuali Foundation Licensed under the
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

package org.kuali.student.lum.lrc.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Wed Apr 22 09:59:25 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "compareGrades", namespace = "http://student.kuali.org/wsdl/lrc")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compareGrades", namespace = "http://student.kuali.org/wsdl/lrc", propOrder = {"gradeKey","scaleKey","compareGradeKey","compareScaleKey"})

public class CompareGrades {

    @XmlElement(name = "gradeKey")
    private java.lang.String gradeKey;
    @XmlElement(name = "scaleKey")
    private java.lang.String scaleKey;
    @XmlElement(name = "compareGradeKey")
    private java.lang.String compareGradeKey;
    @XmlElement(name = "compareScaleKey")
    private java.lang.String compareScaleKey;

    public java.lang.String getGradeKey() {
        return this.gradeKey;
    }

    public void setGradeKey(java.lang.String newGradeKey)  {
        this.gradeKey = newGradeKey;
    }

    public java.lang.String getScaleKey() {
        return this.scaleKey;
    }

    public void setScaleKey(java.lang.String newScaleKey)  {
        this.scaleKey = newScaleKey;
    }

    public java.lang.String getCompareGradeKey() {
        return this.compareGradeKey;
    }

    public void setCompareGradeKey(java.lang.String newCompareGradeKey)  {
        this.compareGradeKey = newCompareGradeKey;
    }

    public java.lang.String getCompareScaleKey() {
        return this.compareScaleKey;
    }

    public void setCompareScaleKey(java.lang.String newCompareScaleKey)  {
        this.compareScaleKey = newCompareScaleKey;
    }

}

