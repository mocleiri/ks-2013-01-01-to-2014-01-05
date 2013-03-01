//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.18 at 09:08:39 PM GMT-05:00 
//


package com.sigmasys.kuali.ksa.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statement" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}external-statement"/>
 *                   &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="statement-remove" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}external-statement-remove"/>
 *                   &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "statement",
    "statementRemove"
})
@XmlRootElement(name = "external-statement-batch-response")
public class ExternalStatementBatchResponse {

    @XmlElement(required = true)
    protected List<ExternalStatementBatchResponse.Statement> statement;
    @XmlElement(name = "statement-remove", required = true)
    protected List<ExternalStatementBatchResponse.StatementRemove> statementRemove;

    /**
     * Gets the value of the statement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalStatementBatchResponse.Statement }
     * 
     * 
     */
    public List<ExternalStatementBatchResponse.Statement> getStatement() {
        if (statement == null) {
            statement = new ArrayList<ExternalStatementBatchResponse.Statement>();
        }
        return this.statement;
    }

    /**
     * Gets the value of the statementRemove property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statementRemove property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatementRemove().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalStatementBatchResponse.StatementRemove }
     * 
     * 
     */
    public List<ExternalStatementBatchResponse.StatementRemove> getStatementRemove() {
        if (statementRemove == null) {
            statementRemove = new ArrayList<ExternalStatementBatchResponse.StatementRemove>();
        }
        return this.statementRemove;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{}external-statement"/>
     *         &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "externalStatement",
        "response"
    })
    public static class Statement {

        @XmlElement(name = "external-statement", required = true)
        protected ExternalStatement externalStatement;
        @XmlElement(required = true)
        protected Object response;

        /**
         * Gets the value of the externalStatement property.
         * 
         * @return
         *     possible object is
         *     {@link ExternalStatement }
         *     
         */
        public ExternalStatement getExternalStatement() {
            return externalStatement;
        }

        /**
         * Sets the value of the externalStatement property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExternalStatement }
         *     
         */
        public void setExternalStatement(ExternalStatement value) {
            this.externalStatement = value;
        }

        /**
         * Gets the value of the response property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getResponse() {
            return response;
        }

        /**
         * Sets the value of the response property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setResponse(Object value) {
            this.response = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{}external-statement-remove"/>
     *         &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "externalStatementRemove",
        "response"
    })
    public static class StatementRemove {

        @XmlElement(name = "external-statement-remove", required = true)
        protected ExternalStatementRemove externalStatementRemove;
        @XmlElement(required = true)
        protected Object response;

        /**
         * Gets the value of the externalStatementRemove property.
         * 
         * @return
         *     possible object is
         *     {@link ExternalStatementRemove }
         *     
         */
        public ExternalStatementRemove getExternalStatementRemove() {
            return externalStatementRemove;
        }

        /**
         * Sets the value of the externalStatementRemove property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExternalStatementRemove }
         *     
         */
        public void setExternalStatementRemove(ExternalStatementRemove value) {
            this.externalStatementRemove = value;
        }

        /**
         * Gets the value of the response property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getResponse() {
            return response;
        }

        /**
         * Sets the value of the response property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setResponse(Object value) {
            this.response = value;
        }

    }

}
