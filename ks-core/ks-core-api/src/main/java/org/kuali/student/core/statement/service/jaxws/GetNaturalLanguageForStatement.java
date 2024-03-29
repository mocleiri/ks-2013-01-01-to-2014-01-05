
package org.kuali.student.core.statement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Wed May 12 12:54:47 PDT 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getNaturalLanguageForStatement", namespace = "http://student.kuali.org/wsdl/statement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNaturalLanguageForStatement", namespace = "http://student.kuali.org/wsdl/statement", propOrder = {"statementId","nlUsageTypeKey","language"})

public class GetNaturalLanguageForStatement {

    @XmlElement(name = "statementId")
    private java.lang.String statementId;
    @XmlElement(name = "nlUsageTypeKey")
    private java.lang.String nlUsageTypeKey;
    @XmlElement(name = "language")
    private java.lang.String language;

    public java.lang.String getStatementId() {
        return this.statementId;
    }

    public void setStatementId(java.lang.String newStatementId)  {
        this.statementId = newStatementId;
    }

    public java.lang.String getNlUsageTypeKey() {
        return this.nlUsageTypeKey;
    }

    public void setNlUsageTypeKey(java.lang.String newNlUsageTypeKey)  {
        this.nlUsageTypeKey = newNlUsageTypeKey;
    }

    public java.lang.String getLanguage() {
        return this.language;
    }

    public void setLanguage(java.lang.String newLanguage)  {
        this.language = newLanguage;
    }

}

