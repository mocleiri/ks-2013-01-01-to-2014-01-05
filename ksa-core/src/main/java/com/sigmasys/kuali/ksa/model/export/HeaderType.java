//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.15 at 04:57:41 PM EST 
//


package com.sigmasys.kuali.ksa.model.export;

import java.math.BigInteger;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for headerType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="headerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}chartOfAccountsCode"/>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}organizationCode"/>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}transmissionDate"/>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}batchSequenceNumber"/>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}personUserId"/>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}emailAddress"/>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}campusCode"/>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}phoneNumber"/>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}mailingAddress"/>
 *         &lt;element ref="{http://www.kuali.org/kfs/gl/collector}departmentName"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "headerType", propOrder = {

})
public class HeaderType {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String chartOfAccountsCode;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String organizationCode;

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar transmissionDate;

    @XmlElement(required = true)
    protected BigInteger batchSequenceNumber;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String personUserId;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String emailAddress;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String campusCode;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String phoneNumber;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mailingAddress;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String departmentName;

    /**
     * Gets the value of the chartOfAccountsCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getChartOfAccountsCode() {
        return chartOfAccountsCode;
    }

    /**
     * Sets the value of the chartOfAccountsCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChartOfAccountsCode(String value) {
        this.chartOfAccountsCode = value;
    }

    /**
     * Gets the value of the organizationCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * Sets the value of the organizationCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOrganizationCode(String value) {
        this.organizationCode = value;
    }

    /**
     * Gets the value of the transmissionDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTransmissionDate() {
        return transmissionDate;
    }

    /**
     * Sets the value of the transmissionDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setTransmissionDate(XMLGregorianCalendar value) {
        this.transmissionDate = value;
    }

    /**
     * Gets the value of the batchSequenceNumber property.
     *
     * @return possible object is
     *         {@link BigInteger }
     */
    public BigInteger getBatchSequenceNumber() {
        return batchSequenceNumber;
    }

    /**
     * Sets the value of the batchSequenceNumber property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setBatchSequenceNumber(BigInteger value) {
        this.batchSequenceNumber = value;
    }

    /**
     * Gets the value of the personUserId property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPersonUserId() {
        return personUserId;
    }

    /**
     * Sets the value of the personUserId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPersonUserId(String value) {
        this.personUserId = value;
    }

    /**
     * Gets the value of the emailAddress property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the campusCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCampusCode() {
        return campusCode;
    }

    /**
     * Sets the value of the campusCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCampusCode(String value) {
        this.campusCode = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the mailingAddress property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Sets the value of the mailingAddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMailingAddress(String value) {
        this.mailingAddress = value;
    }

    /**
     * Gets the value of the departmentName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Sets the value of the departmentName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDepartmentName(String value) {
        this.departmentName = value;
    }

}
