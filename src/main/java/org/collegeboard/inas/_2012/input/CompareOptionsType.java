
package org.collegeboard.inas._2012.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for compareOptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="compareOptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompareStudentMaritalStatus" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareParentMaritalStatus" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareStudentStateOfResidency" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareParentStateOfResidency" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareStudentTaxForm" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareParentTaxForm" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareStudentYearInCollege" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareStudentWardOfCourt" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareStudentCitizenStatus" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareOldestParentDateOfBirth" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareStudentDateOfBirth" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareStudentHomelessStatus" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareStudentDislocatedWorker" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareParentDislocatedWorker" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CompareStudentOrphanAfter13" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="StudentNumberInCollegeTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentNumberInCollegeTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentFamilySizeTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentFamilySizeTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentNumberOfExemptionsTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentNumberOfExemptionsTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentAgiTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentAgiTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentFederalTaxesPaidTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentFederalTaxesPaidTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentWageTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FatherWageTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentSpouseWageTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MotherWageTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentCashTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentCashTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentInvestmentNetWorthTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentInvestmentNetWorthTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentBusinessFarmNetWorthTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentBusinessFarmNetWorthTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentOtherUntaxedIncomeTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentOtherUntaxedIncomeTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentChildSupportPaidTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentChildSupportPaidTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentChildSupportReceivedTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentChildSupportReceivedTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentEducationCreditsTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentEducationCreditsTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentIraPaymentsTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentPensionPaymentsTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentLivingAllowanceTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentInterestIncomeTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentCombatPayTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentCombatPayTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentUntaxedIraDistributionTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentUntaxedPensionDistributionTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentVeteranNonEducationalBenefits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compareOptionsType", propOrder = {
    "compareStudentMaritalStatus",
    "compareParentMaritalStatus",
    "compareStudentStateOfResidency",
    "compareParentStateOfResidency",
    "compareStudentTaxForm",
    "compareParentTaxForm",
    "compareStudentYearInCollege",
    "compareStudentWardOfCourt",
    "compareStudentCitizenStatus",
    "compareOldestParentDateOfBirth",
    "compareStudentDateOfBirth",
    "compareStudentHomelessStatus",
    "compareStudentDislocatedWorker",
    "compareParentDislocatedWorker",
    "compareStudentOrphanAfter13",
    "studentNumberInCollegeTolerance",
    "parentNumberInCollegeTolerance",
    "studentFamilySizeTolerance",
    "parentFamilySizeTolerance",
    "studentNumberOfExemptionsTolerance",
    "parentNumberOfExemptionsTolerance",
    "studentAgiTolerance",
    "parentAgiTolerance",
    "studentFederalTaxesPaidTolerance",
    "parentFederalTaxesPaidTolerance",
    "studentWageTolerance",
    "fatherWageTolerance",
    "studentSpouseWageTolerance",
    "motherWageTolerance",
    "studentCashTolerance",
    "parentCashTolerance",
    "studentInvestmentNetWorthTolerance",
    "parentInvestmentNetWorthTolerance",
    "studentBusinessFarmNetWorthTolerance",
    "parentBusinessFarmNetWorthTolerance",
    "studentOtherUntaxedIncomeTolerance",
    "parentOtherUntaxedIncomeTolerance",
    "studentChildSupportPaidTolerance",
    "parentChildSupportPaidTolerance",
    "studentChildSupportReceivedTolerance",
    "parentChildSupportReceivedTolerance",
    "studentEducationCreditsTolerance",
    "parentEducationCreditsTolerance",
    "parentIraPaymentsTolerance",
    "parentPensionPaymentsTolerance",
    "parentLivingAllowanceTolerance",
    "parentInterestIncomeTolerance",
    "studentCombatPayTolerance",
    "parentCombatPayTolerance",
    "parentUntaxedIraDistributionTolerance",
    "parentUntaxedPensionDistributionTolerance",
    "parentVeteranNonEducationalBenefits"
})
public class CompareOptionsType {

    @XmlElementRef(name = "CompareStudentMaritalStatus", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentMaritalStatus;
    @XmlElementRef(name = "CompareParentMaritalStatus", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareParentMaritalStatus;
    @XmlElementRef(name = "CompareStudentStateOfResidency", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentStateOfResidency;
    @XmlElementRef(name = "CompareParentStateOfResidency", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareParentStateOfResidency;
    @XmlElementRef(name = "CompareStudentTaxForm", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentTaxForm;
    @XmlElementRef(name = "CompareParentTaxForm", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareParentTaxForm;
    @XmlElementRef(name = "CompareStudentYearInCollege", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentYearInCollege;
    @XmlElementRef(name = "CompareStudentWardOfCourt", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentWardOfCourt;
    @XmlElementRef(name = "CompareStudentCitizenStatus", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentCitizenStatus;
    @XmlElementRef(name = "CompareOldestParentDateOfBirth", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareOldestParentDateOfBirth;
    @XmlElementRef(name = "CompareStudentDateOfBirth", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentDateOfBirth;
    @XmlElementRef(name = "CompareStudentHomelessStatus", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentHomelessStatus;
    @XmlElementRef(name = "CompareStudentDislocatedWorker", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentDislocatedWorker;
    @XmlElementRef(name = "CompareParentDislocatedWorker", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareParentDislocatedWorker;
    @XmlElementRef(name = "CompareStudentOrphanAfter13", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> compareStudentOrphanAfter13;
    @XmlElement(name = "StudentNumberInCollegeTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentNumberInCollegeTolerance;
    @XmlElement(name = "ParentNumberInCollegeTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentNumberInCollegeTolerance;
    @XmlElement(name = "StudentFamilySizeTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentFamilySizeTolerance;
    @XmlElement(name = "ParentFamilySizeTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentFamilySizeTolerance;
    @XmlElement(name = "StudentNumberOfExemptionsTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentNumberOfExemptionsTolerance;
    @XmlElement(name = "ParentNumberOfExemptionsTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentNumberOfExemptionsTolerance;
    @XmlElement(name = "StudentAgiTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentAgiTolerance;
    @XmlElement(name = "ParentAgiTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentAgiTolerance;
    @XmlElement(name = "StudentFederalTaxesPaidTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentFederalTaxesPaidTolerance;
    @XmlElement(name = "ParentFederalTaxesPaidTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentFederalTaxesPaidTolerance;
    @XmlElement(name = "StudentWageTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentWageTolerance;
    @XmlElement(name = "FatherWageTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long fatherWageTolerance;
    @XmlElement(name = "StudentSpouseWageTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentSpouseWageTolerance;
    @XmlElement(name = "MotherWageTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long motherWageTolerance;
    @XmlElement(name = "StudentCashTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentCashTolerance;
    @XmlElement(name = "ParentCashTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentCashTolerance;
    @XmlElement(name = "StudentInvestmentNetWorthTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentInvestmentNetWorthTolerance;
    @XmlElement(name = "ParentInvestmentNetWorthTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentInvestmentNetWorthTolerance;
    @XmlElement(name = "StudentBusinessFarmNetWorthTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentBusinessFarmNetWorthTolerance;
    @XmlElement(name = "ParentBusinessFarmNetWorthTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentBusinessFarmNetWorthTolerance;
    @XmlElement(name = "StudentOtherUntaxedIncomeTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentOtherUntaxedIncomeTolerance;
    @XmlElement(name = "ParentOtherUntaxedIncomeTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentOtherUntaxedIncomeTolerance;
    @XmlElement(name = "StudentChildSupportPaidTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentChildSupportPaidTolerance;
    @XmlElement(name = "ParentChildSupportPaidTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentChildSupportPaidTolerance;
    @XmlElement(name = "StudentChildSupportReceivedTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentChildSupportReceivedTolerance;
    @XmlElement(name = "ParentChildSupportReceivedTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentChildSupportReceivedTolerance;
    @XmlElement(name = "StudentEducationCreditsTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentEducationCreditsTolerance;
    @XmlElement(name = "ParentEducationCreditsTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentEducationCreditsTolerance;
    @XmlElement(name = "ParentIraPaymentsTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentIraPaymentsTolerance;
    @XmlElement(name = "ParentPensionPaymentsTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentPensionPaymentsTolerance;
    @XmlElement(name = "ParentLivingAllowanceTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentLivingAllowanceTolerance;
    @XmlElement(name = "ParentInterestIncomeTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentInterestIncomeTolerance;
    @XmlElement(name = "StudentCombatPayTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentCombatPayTolerance;
    @XmlElement(name = "ParentCombatPayTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentCombatPayTolerance;
    @XmlElement(name = "ParentUntaxedIraDistributionTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentUntaxedIraDistributionTolerance;
    @XmlElement(name = "ParentUntaxedPensionDistributionTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentUntaxedPensionDistributionTolerance;
    @XmlElement(name = "ParentVeteranNonEducationalBenefits", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentVeteranNonEducationalBenefits;

    /**
     * Gets the value of the compareStudentMaritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentMaritalStatus() {
        return compareStudentMaritalStatus;
    }

    /**
     * Sets the value of the compareStudentMaritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentMaritalStatus(JAXBElement<YesNoType> value) {
        this.compareStudentMaritalStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareParentMaritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareParentMaritalStatus() {
        return compareParentMaritalStatus;
    }

    /**
     * Sets the value of the compareParentMaritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareParentMaritalStatus(JAXBElement<YesNoType> value) {
        this.compareParentMaritalStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareStudentStateOfResidency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentStateOfResidency() {
        return compareStudentStateOfResidency;
    }

    /**
     * Sets the value of the compareStudentStateOfResidency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentStateOfResidency(JAXBElement<YesNoType> value) {
        this.compareStudentStateOfResidency = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareParentStateOfResidency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareParentStateOfResidency() {
        return compareParentStateOfResidency;
    }

    /**
     * Sets the value of the compareParentStateOfResidency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareParentStateOfResidency(JAXBElement<YesNoType> value) {
        this.compareParentStateOfResidency = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareStudentTaxForm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentTaxForm() {
        return compareStudentTaxForm;
    }

    /**
     * Sets the value of the compareStudentTaxForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentTaxForm(JAXBElement<YesNoType> value) {
        this.compareStudentTaxForm = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareParentTaxForm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareParentTaxForm() {
        return compareParentTaxForm;
    }

    /**
     * Sets the value of the compareParentTaxForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareParentTaxForm(JAXBElement<YesNoType> value) {
        this.compareParentTaxForm = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareStudentYearInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentYearInCollege() {
        return compareStudentYearInCollege;
    }

    /**
     * Sets the value of the compareStudentYearInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentYearInCollege(JAXBElement<YesNoType> value) {
        this.compareStudentYearInCollege = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareStudentWardOfCourt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentWardOfCourt() {
        return compareStudentWardOfCourt;
    }

    /**
     * Sets the value of the compareStudentWardOfCourt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentWardOfCourt(JAXBElement<YesNoType> value) {
        this.compareStudentWardOfCourt = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareStudentCitizenStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentCitizenStatus() {
        return compareStudentCitizenStatus;
    }

    /**
     * Sets the value of the compareStudentCitizenStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentCitizenStatus(JAXBElement<YesNoType> value) {
        this.compareStudentCitizenStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareOldestParentDateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareOldestParentDateOfBirth() {
        return compareOldestParentDateOfBirth;
    }

    /**
     * Sets the value of the compareOldestParentDateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareOldestParentDateOfBirth(JAXBElement<YesNoType> value) {
        this.compareOldestParentDateOfBirth = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareStudentDateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentDateOfBirth() {
        return compareStudentDateOfBirth;
    }

    /**
     * Sets the value of the compareStudentDateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentDateOfBirth(JAXBElement<YesNoType> value) {
        this.compareStudentDateOfBirth = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareStudentHomelessStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentHomelessStatus() {
        return compareStudentHomelessStatus;
    }

    /**
     * Sets the value of the compareStudentHomelessStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentHomelessStatus(JAXBElement<YesNoType> value) {
        this.compareStudentHomelessStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareStudentDislocatedWorker property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentDislocatedWorker() {
        return compareStudentDislocatedWorker;
    }

    /**
     * Sets the value of the compareStudentDislocatedWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentDislocatedWorker(JAXBElement<YesNoType> value) {
        this.compareStudentDislocatedWorker = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareParentDislocatedWorker property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareParentDislocatedWorker() {
        return compareParentDislocatedWorker;
    }

    /**
     * Sets the value of the compareParentDislocatedWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareParentDislocatedWorker(JAXBElement<YesNoType> value) {
        this.compareParentDislocatedWorker = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the compareStudentOrphanAfter13 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCompareStudentOrphanAfter13() {
        return compareStudentOrphanAfter13;
    }

    /**
     * Sets the value of the compareStudentOrphanAfter13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCompareStudentOrphanAfter13(JAXBElement<YesNoType> value) {
        this.compareStudentOrphanAfter13 = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the studentNumberInCollegeTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentNumberInCollegeTolerance() {
        return studentNumberInCollegeTolerance;
    }

    /**
     * Sets the value of the studentNumberInCollegeTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentNumberInCollegeTolerance(Long value) {
        this.studentNumberInCollegeTolerance = value;
    }

    /**
     * Gets the value of the parentNumberInCollegeTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentNumberInCollegeTolerance() {
        return parentNumberInCollegeTolerance;
    }

    /**
     * Sets the value of the parentNumberInCollegeTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentNumberInCollegeTolerance(Long value) {
        this.parentNumberInCollegeTolerance = value;
    }

    /**
     * Gets the value of the studentFamilySizeTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentFamilySizeTolerance() {
        return studentFamilySizeTolerance;
    }

    /**
     * Sets the value of the studentFamilySizeTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentFamilySizeTolerance(Long value) {
        this.studentFamilySizeTolerance = value;
    }

    /**
     * Gets the value of the parentFamilySizeTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentFamilySizeTolerance() {
        return parentFamilySizeTolerance;
    }

    /**
     * Sets the value of the parentFamilySizeTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentFamilySizeTolerance(Long value) {
        this.parentFamilySizeTolerance = value;
    }

    /**
     * Gets the value of the studentNumberOfExemptionsTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentNumberOfExemptionsTolerance() {
        return studentNumberOfExemptionsTolerance;
    }

    /**
     * Sets the value of the studentNumberOfExemptionsTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentNumberOfExemptionsTolerance(Long value) {
        this.studentNumberOfExemptionsTolerance = value;
    }

    /**
     * Gets the value of the parentNumberOfExemptionsTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentNumberOfExemptionsTolerance() {
        return parentNumberOfExemptionsTolerance;
    }

    /**
     * Sets the value of the parentNumberOfExemptionsTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentNumberOfExemptionsTolerance(Long value) {
        this.parentNumberOfExemptionsTolerance = value;
    }

    /**
     * Gets the value of the studentAgiTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentAgiTolerance() {
        return studentAgiTolerance;
    }

    /**
     * Sets the value of the studentAgiTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentAgiTolerance(Long value) {
        this.studentAgiTolerance = value;
    }

    /**
     * Gets the value of the parentAgiTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentAgiTolerance() {
        return parentAgiTolerance;
    }

    /**
     * Sets the value of the parentAgiTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentAgiTolerance(Long value) {
        this.parentAgiTolerance = value;
    }

    /**
     * Gets the value of the studentFederalTaxesPaidTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentFederalTaxesPaidTolerance() {
        return studentFederalTaxesPaidTolerance;
    }

    /**
     * Sets the value of the studentFederalTaxesPaidTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentFederalTaxesPaidTolerance(Long value) {
        this.studentFederalTaxesPaidTolerance = value;
    }

    /**
     * Gets the value of the parentFederalTaxesPaidTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentFederalTaxesPaidTolerance() {
        return parentFederalTaxesPaidTolerance;
    }

    /**
     * Sets the value of the parentFederalTaxesPaidTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentFederalTaxesPaidTolerance(Long value) {
        this.parentFederalTaxesPaidTolerance = value;
    }

    /**
     * Gets the value of the studentWageTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentWageTolerance() {
        return studentWageTolerance;
    }

    /**
     * Sets the value of the studentWageTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentWageTolerance(Long value) {
        this.studentWageTolerance = value;
    }

    /**
     * Gets the value of the fatherWageTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFatherWageTolerance() {
        return fatherWageTolerance;
    }

    /**
     * Sets the value of the fatherWageTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFatherWageTolerance(Long value) {
        this.fatherWageTolerance = value;
    }

    /**
     * Gets the value of the studentSpouseWageTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentSpouseWageTolerance() {
        return studentSpouseWageTolerance;
    }

    /**
     * Sets the value of the studentSpouseWageTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentSpouseWageTolerance(Long value) {
        this.studentSpouseWageTolerance = value;
    }

    /**
     * Gets the value of the motherWageTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMotherWageTolerance() {
        return motherWageTolerance;
    }

    /**
     * Sets the value of the motherWageTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMotherWageTolerance(Long value) {
        this.motherWageTolerance = value;
    }

    /**
     * Gets the value of the studentCashTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentCashTolerance() {
        return studentCashTolerance;
    }

    /**
     * Sets the value of the studentCashTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentCashTolerance(Long value) {
        this.studentCashTolerance = value;
    }

    /**
     * Gets the value of the parentCashTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentCashTolerance() {
        return parentCashTolerance;
    }

    /**
     * Sets the value of the parentCashTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentCashTolerance(Long value) {
        this.parentCashTolerance = value;
    }

    /**
     * Gets the value of the studentInvestmentNetWorthTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentInvestmentNetWorthTolerance() {
        return studentInvestmentNetWorthTolerance;
    }

    /**
     * Sets the value of the studentInvestmentNetWorthTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentInvestmentNetWorthTolerance(Long value) {
        this.studentInvestmentNetWorthTolerance = value;
    }

    /**
     * Gets the value of the parentInvestmentNetWorthTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentInvestmentNetWorthTolerance() {
        return parentInvestmentNetWorthTolerance;
    }

    /**
     * Sets the value of the parentInvestmentNetWorthTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentInvestmentNetWorthTolerance(Long value) {
        this.parentInvestmentNetWorthTolerance = value;
    }

    /**
     * Gets the value of the studentBusinessFarmNetWorthTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentBusinessFarmNetWorthTolerance() {
        return studentBusinessFarmNetWorthTolerance;
    }

    /**
     * Sets the value of the studentBusinessFarmNetWorthTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentBusinessFarmNetWorthTolerance(Long value) {
        this.studentBusinessFarmNetWorthTolerance = value;
    }

    /**
     * Gets the value of the parentBusinessFarmNetWorthTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentBusinessFarmNetWorthTolerance() {
        return parentBusinessFarmNetWorthTolerance;
    }

    /**
     * Sets the value of the parentBusinessFarmNetWorthTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentBusinessFarmNetWorthTolerance(Long value) {
        this.parentBusinessFarmNetWorthTolerance = value;
    }

    /**
     * Gets the value of the studentOtherUntaxedIncomeTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentOtherUntaxedIncomeTolerance() {
        return studentOtherUntaxedIncomeTolerance;
    }

    /**
     * Sets the value of the studentOtherUntaxedIncomeTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentOtherUntaxedIncomeTolerance(Long value) {
        this.studentOtherUntaxedIncomeTolerance = value;
    }

    /**
     * Gets the value of the parentOtherUntaxedIncomeTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentOtherUntaxedIncomeTolerance() {
        return parentOtherUntaxedIncomeTolerance;
    }

    /**
     * Sets the value of the parentOtherUntaxedIncomeTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentOtherUntaxedIncomeTolerance(Long value) {
        this.parentOtherUntaxedIncomeTolerance = value;
    }

    /**
     * Gets the value of the studentChildSupportPaidTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentChildSupportPaidTolerance() {
        return studentChildSupportPaidTolerance;
    }

    /**
     * Sets the value of the studentChildSupportPaidTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentChildSupportPaidTolerance(Long value) {
        this.studentChildSupportPaidTolerance = value;
    }

    /**
     * Gets the value of the parentChildSupportPaidTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentChildSupportPaidTolerance() {
        return parentChildSupportPaidTolerance;
    }

    /**
     * Sets the value of the parentChildSupportPaidTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentChildSupportPaidTolerance(Long value) {
        this.parentChildSupportPaidTolerance = value;
    }

    /**
     * Gets the value of the studentChildSupportReceivedTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentChildSupportReceivedTolerance() {
        return studentChildSupportReceivedTolerance;
    }

    /**
     * Sets the value of the studentChildSupportReceivedTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentChildSupportReceivedTolerance(Long value) {
        this.studentChildSupportReceivedTolerance = value;
    }

    /**
     * Gets the value of the parentChildSupportReceivedTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentChildSupportReceivedTolerance() {
        return parentChildSupportReceivedTolerance;
    }

    /**
     * Sets the value of the parentChildSupportReceivedTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentChildSupportReceivedTolerance(Long value) {
        this.parentChildSupportReceivedTolerance = value;
    }

    /**
     * Gets the value of the studentEducationCreditsTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentEducationCreditsTolerance() {
        return studentEducationCreditsTolerance;
    }

    /**
     * Sets the value of the studentEducationCreditsTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentEducationCreditsTolerance(Long value) {
        this.studentEducationCreditsTolerance = value;
    }

    /**
     * Gets the value of the parentEducationCreditsTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentEducationCreditsTolerance() {
        return parentEducationCreditsTolerance;
    }

    /**
     * Sets the value of the parentEducationCreditsTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentEducationCreditsTolerance(Long value) {
        this.parentEducationCreditsTolerance = value;
    }

    /**
     * Gets the value of the parentIraPaymentsTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentIraPaymentsTolerance() {
        return parentIraPaymentsTolerance;
    }

    /**
     * Sets the value of the parentIraPaymentsTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentIraPaymentsTolerance(Long value) {
        this.parentIraPaymentsTolerance = value;
    }

    /**
     * Gets the value of the parentPensionPaymentsTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentPensionPaymentsTolerance() {
        return parentPensionPaymentsTolerance;
    }

    /**
     * Sets the value of the parentPensionPaymentsTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentPensionPaymentsTolerance(Long value) {
        this.parentPensionPaymentsTolerance = value;
    }

    /**
     * Gets the value of the parentLivingAllowanceTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentLivingAllowanceTolerance() {
        return parentLivingAllowanceTolerance;
    }

    /**
     * Sets the value of the parentLivingAllowanceTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentLivingAllowanceTolerance(Long value) {
        this.parentLivingAllowanceTolerance = value;
    }

    /**
     * Gets the value of the parentInterestIncomeTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentInterestIncomeTolerance() {
        return parentInterestIncomeTolerance;
    }

    /**
     * Sets the value of the parentInterestIncomeTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentInterestIncomeTolerance(Long value) {
        this.parentInterestIncomeTolerance = value;
    }

    /**
     * Gets the value of the studentCombatPayTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentCombatPayTolerance() {
        return studentCombatPayTolerance;
    }

    /**
     * Sets the value of the studentCombatPayTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentCombatPayTolerance(Long value) {
        this.studentCombatPayTolerance = value;
    }

    /**
     * Gets the value of the parentCombatPayTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentCombatPayTolerance() {
        return parentCombatPayTolerance;
    }

    /**
     * Sets the value of the parentCombatPayTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentCombatPayTolerance(Long value) {
        this.parentCombatPayTolerance = value;
    }

    /**
     * Gets the value of the parentUntaxedIraDistributionTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentUntaxedIraDistributionTolerance() {
        return parentUntaxedIraDistributionTolerance;
    }

    /**
     * Sets the value of the parentUntaxedIraDistributionTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentUntaxedIraDistributionTolerance(Long value) {
        this.parentUntaxedIraDistributionTolerance = value;
    }

    /**
     * Gets the value of the parentUntaxedPensionDistributionTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentUntaxedPensionDistributionTolerance() {
        return parentUntaxedPensionDistributionTolerance;
    }

    /**
     * Sets the value of the parentUntaxedPensionDistributionTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentUntaxedPensionDistributionTolerance(Long value) {
        this.parentUntaxedPensionDistributionTolerance = value;
    }

    /**
     * Gets the value of the parentVeteranNonEducationalBenefits property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentVeteranNonEducationalBenefits() {
        return parentVeteranNonEducationalBenefits;
    }

    /**
     * Sets the value of the parentVeteranNonEducationalBenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentVeteranNonEducationalBenefits(Long value) {
        this.parentVeteranNonEducationalBenefits = value;
    }

}
