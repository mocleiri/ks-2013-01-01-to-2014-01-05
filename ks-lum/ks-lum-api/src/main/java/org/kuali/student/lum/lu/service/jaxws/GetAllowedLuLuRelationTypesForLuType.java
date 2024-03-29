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


package org.kuali.student.lum.lu.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Thu Jan 21 10:05:23 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getAllowedLuLuRelationTypesForLuType", namespace = "http://student.kuali.org/wsdl/lu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllowedLuLuRelationTypesForLuType", namespace = "http://student.kuali.org/wsdl/lu", propOrder = {"luTypeKey","relatedLuTypeKey"})

public class GetAllowedLuLuRelationTypesForLuType {

    @XmlElement(name = "luTypeKey")
    private java.lang.String luTypeKey;
    @XmlElement(name = "relatedLuTypeKey")
    private java.lang.String relatedLuTypeKey;

    public java.lang.String getLuTypeKey() {
        return this.luTypeKey;
    }

    public void setLuTypeKey(java.lang.String newLuTypeKey)  {
        this.luTypeKey = newLuTypeKey;
    }

    public java.lang.String getRelatedLuTypeKey() {
        return this.relatedLuTypeKey;
    }

    public void setRelatedLuTypeKey(java.lang.String newRelatedLuTypeKey)  {
        this.relatedLuTypeKey = newRelatedLuTypeKey;
    }

}

