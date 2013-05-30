
package org.collegeboard.inas._2013.input;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmRejectsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmRejectsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RejectCode" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Reject3StudentTaxPaidOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="Reject12ParentTaxPaidOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="Reject20NonTaxFilerOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="Reject21StudentCorrectedMaritalStatusDateOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectADateOfBirthOldOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectBDateOfBirthYoungOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectCParentIndepedentTaxPaidComplexOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectGDependentTaxPaidComplexOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectJFatherSsnOveride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectKMotherSsnOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectNIncompleteNameOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectWHighFamilyMemberOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmRejectsType", propOrder = {
    "rejectCode",
    "reject3StudentTaxPaidOverride",
    "reject12ParentTaxPaidOverride",
    "reject20NonTaxFilerOverride",
    "reject21StudentCorrectedMaritalStatusDateOverride",
    "rejectADateOfBirthOldOverride",
    "rejectBDateOfBirthYoungOverride",
    "rejectCParentIndepedentTaxPaidComplexOverride",
    "rejectGDependentTaxPaidComplexOverride",
    "rejectJFatherSsnOveride",
    "rejectKMotherSsnOverride",
    "rejectNIncompleteNameOverride",
    "rejectWHighFamilyMemberOverride"
})
public class FmRejectsType {

    @XmlElement(name = "RejectCode", nillable = true)
    protected List<String> rejectCode;
    @XmlElementRef(name = "Reject3StudentTaxPaidOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> reject3StudentTaxPaidOverride;
    @XmlElementRef(name = "Reject12ParentTaxPaidOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> reject12ParentTaxPaidOverride;
    @XmlElementRef(name = "Reject20NonTaxFilerOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> reject20NonTaxFilerOverride;
    @XmlElementRef(name = "Reject21StudentCorrectedMaritalStatusDateOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> reject21StudentCorrectedMaritalStatusDateOverride;
    @XmlElementRef(name = "RejectADateOfBirthOldOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectADateOfBirthOldOverride;
    @XmlElementRef(name = "RejectBDateOfBirthYoungOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectBDateOfBirthYoungOverride;
    @XmlElementRef(name = "RejectCParentIndepedentTaxPaidComplexOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectCParentIndepedentTaxPaidComplexOverride;
    @XmlElementRef(name = "RejectGDependentTaxPaidComplexOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectGDependentTaxPaidComplexOverride;
    @XmlElementRef(name = "RejectJFatherSsnOveride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectJFatherSsnOveride;
    @XmlElementRef(name = "RejectKMotherSsnOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectKMotherSsnOverride;
    @XmlElementRef(name = "RejectNIncompleteNameOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectNIncompleteNameOverride;
    @XmlElementRef(name = "RejectWHighFamilyMemberOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectWHighFamilyMemberOverride;

    /**
     * Gets the value of the rejectCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rejectCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRejectCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRejectCode() {
        if (rejectCode == null) {
            rejectCode = new ArrayList<String>();
        }
        return this.rejectCode;
    }

    /**
     * Gets the value of the reject3StudentTaxPaidOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getReject3StudentTaxPaidOverride() {
        return reject3StudentTaxPaidOverride;
    }

    /**
     * Sets the value of the reject3StudentTaxPaidOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setReject3StudentTaxPaidOverride(JAXBElement<YesNoType> value) {
        this.reject3StudentTaxPaidOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the reject12ParentTaxPaidOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getReject12ParentTaxPaidOverride() {
        return reject12ParentTaxPaidOverride;
    }

    /**
     * Sets the value of the reject12ParentTaxPaidOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setReject12ParentTaxPaidOverride(JAXBElement<YesNoType> value) {
        this.reject12ParentTaxPaidOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the reject20NonTaxFilerOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getReject20NonTaxFilerOverride() {
        return reject20NonTaxFilerOverride;
    }

    /**
     * Sets the value of the reject20NonTaxFilerOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setReject20NonTaxFilerOverride(JAXBElement<YesNoType> value) {
        this.reject20NonTaxFilerOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the reject21StudentCorrectedMaritalStatusDateOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getReject21StudentCorrectedMaritalStatusDateOverride() {
        return reject21StudentCorrectedMaritalStatusDateOverride;
    }

    /**
     * Sets the value of the reject21StudentCorrectedMaritalStatusDateOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setReject21StudentCorrectedMaritalStatusDateOverride(JAXBElement<YesNoType> value) {
        this.reject21StudentCorrectedMaritalStatusDateOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectADateOfBirthOldOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectADateOfBirthOldOverride() {
        return rejectADateOfBirthOldOverride;
    }

    /**
     * Sets the value of the rejectADateOfBirthOldOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectADateOfBirthOldOverride(JAXBElement<YesNoType> value) {
        this.rejectADateOfBirthOldOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectBDateOfBirthYoungOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectBDateOfBirthYoungOverride() {
        return rejectBDateOfBirthYoungOverride;
    }

    /**
     * Sets the value of the rejectBDateOfBirthYoungOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectBDateOfBirthYoungOverride(JAXBElement<YesNoType> value) {
        this.rejectBDateOfBirthYoungOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectCParentIndepedentTaxPaidComplexOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectCParentIndepedentTaxPaidComplexOverride() {
        return rejectCParentIndepedentTaxPaidComplexOverride;
    }

    /**
     * Sets the value of the rejectCParentIndepedentTaxPaidComplexOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectCParentIndepedentTaxPaidComplexOverride(JAXBElement<YesNoType> value) {
        this.rejectCParentIndepedentTaxPaidComplexOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectGDependentTaxPaidComplexOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectGDependentTaxPaidComplexOverride() {
        return rejectGDependentTaxPaidComplexOverride;
    }

    /**
     * Sets the value of the rejectGDependentTaxPaidComplexOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectGDependentTaxPaidComplexOverride(JAXBElement<YesNoType> value) {
        this.rejectGDependentTaxPaidComplexOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectJFatherSsnOveride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectJFatherSsnOveride() {
        return rejectJFatherSsnOveride;
    }

    /**
     * Sets the value of the rejectJFatherSsnOveride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectJFatherSsnOveride(JAXBElement<YesNoType> value) {
        this.rejectJFatherSsnOveride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectKMotherSsnOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectKMotherSsnOverride() {
        return rejectKMotherSsnOverride;
    }

    /**
     * Sets the value of the rejectKMotherSsnOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectKMotherSsnOverride(JAXBElement<YesNoType> value) {
        this.rejectKMotherSsnOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectNIncompleteNameOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectNIncompleteNameOverride() {
        return rejectNIncompleteNameOverride;
    }

    /**
     * Sets the value of the rejectNIncompleteNameOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectNIncompleteNameOverride(JAXBElement<YesNoType> value) {
        this.rejectNIncompleteNameOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectWHighFamilyMemberOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectWHighFamilyMemberOverride() {
        return rejectWHighFamilyMemberOverride;
    }

    /**
     * Sets the value of the rejectWHighFamilyMemberOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectWHighFamilyMemberOverride(JAXBElement<YesNoType> value) {
        this.rejectWHighFamilyMemberOverride = ((JAXBElement<YesNoType> ) value);
    }

}
