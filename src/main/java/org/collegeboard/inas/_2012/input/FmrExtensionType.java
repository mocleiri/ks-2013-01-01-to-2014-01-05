
package org.collegeboard.inas._2012.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmrExtensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmrExtensionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BudgetDuration" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ForceStudentToIndependentStatus" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="StudentCalculateUsTax" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ParentCalculateUsTax" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CalculateParentContributionForIndependent" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ParentNumberInCollegeOverride" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectRStudentSsnMatchOverride" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectSDependentAndFathersBirthDateOverride" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectTDependentAndMotherBirthDateOverride" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectDFirstAndLastNameMatchOverride" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectEDependentAndFathersNameOverride" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="RejectFDependentAndMotherNameDateOverride" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="StudentAllowance" type="{http://INAS.collegeboard.org/2012/Input/}additionalAllowanceType"/>
 *         &lt;element name="ParentAllowance" type="{http://INAS.collegeboard.org/2012/Input/}additionalAllowanceType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmrExtensionType", propOrder = {
    "budgetDuration",
    "forceStudentToIndependentStatus",
    "studentCalculateUsTax",
    "parentCalculateUsTax",
    "calculateParentContributionForIndependent",
    "parentNumberInCollegeOverride",
    "rejectRStudentSsnMatchOverride",
    "rejectSDependentAndFathersBirthDateOverride",
    "rejectTDependentAndMotherBirthDateOverride",
    "rejectDFirstAndLastNameMatchOverride",
    "rejectEDependentAndFathersNameOverride",
    "rejectFDependentAndMotherNameDateOverride",
    "studentAllowance",
    "parentAllowance"
})
public class FmrExtensionType {

    @XmlElement(name = "BudgetDuration", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long budgetDuration;
    @XmlElementRef(name = "ForceStudentToIndependentStatus", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> forceStudentToIndependentStatus;
    @XmlElementRef(name = "StudentCalculateUsTax", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> studentCalculateUsTax;
    @XmlElementRef(name = "ParentCalculateUsTax", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> parentCalculateUsTax;
    @XmlElementRef(name = "CalculateParentContributionForIndependent", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> calculateParentContributionForIndependent;
    @XmlElementRef(name = "ParentNumberInCollegeOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> parentNumberInCollegeOverride;
    @XmlElementRef(name = "RejectRStudentSsnMatchOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectRStudentSsnMatchOverride;
    @XmlElementRef(name = "RejectSDependentAndFathersBirthDateOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectSDependentAndFathersBirthDateOverride;
    @XmlElementRef(name = "RejectTDependentAndMotherBirthDateOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectTDependentAndMotherBirthDateOverride;
    @XmlElementRef(name = "RejectDFirstAndLastNameMatchOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectDFirstAndLastNameMatchOverride;
    @XmlElementRef(name = "RejectEDependentAndFathersNameOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectEDependentAndFathersNameOverride;
    @XmlElementRef(name = "RejectFDependentAndMotherNameDateOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> rejectFDependentAndMotherNameDateOverride;
    @XmlElement(name = "StudentAllowance", required = true, nillable = true)
    protected AdditionalAllowanceType studentAllowance;
    @XmlElement(name = "ParentAllowance", required = true, nillable = true)
    protected AdditionalAllowanceType parentAllowance;

    /**
     * Gets the value of the budgetDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBudgetDuration() {
        return budgetDuration;
    }

    /**
     * Sets the value of the budgetDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBudgetDuration(Long value) {
        this.budgetDuration = value;
    }

    /**
     * Gets the value of the forceStudentToIndependentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getForceStudentToIndependentStatus() {
        return forceStudentToIndependentStatus;
    }

    /**
     * Sets the value of the forceStudentToIndependentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setForceStudentToIndependentStatus(JAXBElement<YesNoType> value) {
        this.forceStudentToIndependentStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the studentCalculateUsTax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getStudentCalculateUsTax() {
        return studentCalculateUsTax;
    }

    /**
     * Sets the value of the studentCalculateUsTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setStudentCalculateUsTax(JAXBElement<YesNoType> value) {
        this.studentCalculateUsTax = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the parentCalculateUsTax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getParentCalculateUsTax() {
        return parentCalculateUsTax;
    }

    /**
     * Sets the value of the parentCalculateUsTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setParentCalculateUsTax(JAXBElement<YesNoType> value) {
        this.parentCalculateUsTax = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the calculateParentContributionForIndependent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCalculateParentContributionForIndependent() {
        return calculateParentContributionForIndependent;
    }

    /**
     * Sets the value of the calculateParentContributionForIndependent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCalculateParentContributionForIndependent(JAXBElement<YesNoType> value) {
        this.calculateParentContributionForIndependent = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the parentNumberInCollegeOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getParentNumberInCollegeOverride() {
        return parentNumberInCollegeOverride;
    }

    /**
     * Sets the value of the parentNumberInCollegeOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setParentNumberInCollegeOverride(JAXBElement<YesNoType> value) {
        this.parentNumberInCollegeOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectRStudentSsnMatchOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectRStudentSsnMatchOverride() {
        return rejectRStudentSsnMatchOverride;
    }

    /**
     * Sets the value of the rejectRStudentSsnMatchOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectRStudentSsnMatchOverride(JAXBElement<YesNoType> value) {
        this.rejectRStudentSsnMatchOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectSDependentAndFathersBirthDateOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectSDependentAndFathersBirthDateOverride() {
        return rejectSDependentAndFathersBirthDateOverride;
    }

    /**
     * Sets the value of the rejectSDependentAndFathersBirthDateOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectSDependentAndFathersBirthDateOverride(JAXBElement<YesNoType> value) {
        this.rejectSDependentAndFathersBirthDateOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectTDependentAndMotherBirthDateOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectTDependentAndMotherBirthDateOverride() {
        return rejectTDependentAndMotherBirthDateOverride;
    }

    /**
     * Sets the value of the rejectTDependentAndMotherBirthDateOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectTDependentAndMotherBirthDateOverride(JAXBElement<YesNoType> value) {
        this.rejectTDependentAndMotherBirthDateOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectDFirstAndLastNameMatchOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectDFirstAndLastNameMatchOverride() {
        return rejectDFirstAndLastNameMatchOverride;
    }

    /**
     * Sets the value of the rejectDFirstAndLastNameMatchOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectDFirstAndLastNameMatchOverride(JAXBElement<YesNoType> value) {
        this.rejectDFirstAndLastNameMatchOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectEDependentAndFathersNameOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectEDependentAndFathersNameOverride() {
        return rejectEDependentAndFathersNameOverride;
    }

    /**
     * Sets the value of the rejectEDependentAndFathersNameOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectEDependentAndFathersNameOverride(JAXBElement<YesNoType> value) {
        this.rejectEDependentAndFathersNameOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the rejectFDependentAndMotherNameDateOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getRejectFDependentAndMotherNameDateOverride() {
        return rejectFDependentAndMotherNameDateOverride;
    }

    /**
     * Sets the value of the rejectFDependentAndMotherNameDateOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setRejectFDependentAndMotherNameDateOverride(JAXBElement<YesNoType> value) {
        this.rejectFDependentAndMotherNameDateOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the studentAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalAllowanceType }
     *     
     */
    public AdditionalAllowanceType getStudentAllowance() {
        return studentAllowance;
    }

    /**
     * Sets the value of the studentAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalAllowanceType }
     *     
     */
    public void setStudentAllowance(AdditionalAllowanceType value) {
        this.studentAllowance = value;
    }

    /**
     * Gets the value of the parentAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalAllowanceType }
     *     
     */
    public AdditionalAllowanceType getParentAllowance() {
        return parentAllowance;
    }

    /**
     * Sets the value of the parentAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalAllowanceType }
     *     
     */
    public void setParentAllowance(AdditionalAllowanceType value) {
        this.parentAllowance = value;
    }

}
