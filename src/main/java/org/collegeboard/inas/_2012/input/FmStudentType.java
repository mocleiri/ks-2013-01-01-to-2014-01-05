
package org.collegeboard.inas._2012.input;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for fmStudentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmStudentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MiddleInitial" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ResidencyStateProvinceCode" type="{http://INAS.collegeboard.org/2012/Input/}stateProvinceType" minOccurs="0"/>
 *         &lt;element name="StateProvinceCode" type="{http://INAS.collegeboard.org/2012/Input/}stateProvinceType" minOccurs="0"/>
 *         &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CitizenshipStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CitizenshipSsaFlag" type="{http://INAS.collegeboard.org/2012/Input/}citizenshipSsaFlagType" minOccurs="0"/>
 *         &lt;element name="AlienRegistrationId" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="SsnMatchIndicator" type="{http://INAS.collegeboard.org/2012/Input/}ssnMatchIndicatorType" minOccurs="0"/>
 *         &lt;element name="MaritalStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MaritalStatusDate" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
 *         &lt;element name="YearInCollegeCode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="MembersInFamily" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="BornPriorIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="WorkOnGraduateDegreeInd" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MarriedIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="HaveChildrenYouSupportIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="LegalDependentsIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="OrphanWardOfCourtIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="VeteranIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ActiveDutyIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="EmancipatedMinorIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="InLegalGuardianshipIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UnaccompaniedYouthBySchoolIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UnaccompaniedYouthByHUDIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AtRiskHomelessIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="TaxReturnStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxFormTypeCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="EligibleToFile1040AOr1040EZ" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ReceiveSSI" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveFoodStamps" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveFreeLunch" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveTANF" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveWIC" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="DislocatedWorker" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AssetThresholdExceeded" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AdjustedGrossIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IncomeTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExemptionsClaimed" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SpouseEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CashSavingsChecking" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InvestmentNetworth" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="BusinessFarmNetworth" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="EducationCredits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ChildSupportPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NeedBasedEmployment" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="GrantsScholarshipsResources" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CombatPay" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CoOpEarnings" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PensionPayments" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="IraPayments" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ChildSupportReceived" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InterestDividendIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="IraDistributions" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="UntaxedPensionPayments" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MilitaryClergyAllowances" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="VeteranNonEducationBenefits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherNonReportedMoney" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmStudentType", propOrder = {
    "lastName",
    "firstName",
    "middleInitial",
    "residencyStateProvinceCode",
    "stateProvinceCode",
    "zipCode",
    "birthDate",
    "citizenshipStatusCode",
    "citizenshipSsaFlag",
    "alienRegistrationId",
    "ssnMatchIndicator",
    "maritalStatusCode",
    "maritalStatusDate",
    "yearInCollegeCode",
    "membersInFamily",
    "numberInCollege",
    "bornPriorIndicator",
    "workOnGraduateDegreeInd",
    "marriedIndicator",
    "haveChildrenYouSupportIndicator",
    "legalDependentsIndicator",
    "orphanWardOfCourtIndicator",
    "veteranIndicator",
    "activeDutyIndicator",
    "emancipatedMinorIndicator",
    "inLegalGuardianshipIndicator",
    "unaccompaniedYouthBySchoolIndicator",
    "unaccompaniedYouthByHUDIndicator",
    "atRiskHomelessIndicator",
    "taxReturnStatusCode",
    "taxFormTypeCode",
    "eligibleToFile1040AOr1040EZ",
    "receiveSSI",
    "receiveFoodStamps",
    "receiveFreeLunch",
    "receiveTANF",
    "receiveWIC",
    "dislocatedWorker",
    "assetThresholdExceeded",
    "adjustedGrossIncome",
    "incomeTaxPaid",
    "exemptionsClaimed",
    "studentEarnedIncome",
    "spouseEarnedIncome",
    "cashSavingsChecking",
    "investmentNetworth",
    "businessFarmNetworth",
    "educationCredits",
    "childSupportPaid",
    "needBasedEmployment",
    "grantsScholarshipsResources",
    "combatPay",
    "coOpEarnings",
    "pensionPayments",
    "iraPayments",
    "childSupportReceived",
    "interestDividendIncome",
    "iraDistributions",
    "untaxedPensionPayments",
    "militaryClergyAllowances",
    "veteranNonEducationBenefits",
    "otherUntaxedIncome",
    "otherNonReportedMoney"
})
public class FmStudentType {

    @XmlElement(name = "LastName", required = true, nillable = true)
    protected String lastName;
    @XmlElement(name = "FirstName", required = true, nillable = true)
    protected String firstName;
    @XmlElement(name = "MiddleInitial", required = true, nillable = true)
    protected String middleInitial;
    @XmlElementRef(name = "ResidencyStateProvinceCode", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<StateProvinceType> residencyStateProvinceCode;
    @XmlElementRef(name = "StateProvinceCode", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<StateProvinceType> stateProvinceCode;
    @XmlElementRef(name = "ZipCode", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> zipCode;
    @XmlElementRef(name = "BirthDate", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> birthDate;
    @XmlElement(name = "CitizenshipStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long citizenshipStatusCode;
    @XmlElementRef(name = "CitizenshipSsaFlag", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<String> citizenshipSsaFlag;
    @XmlElement(name = "AlienRegistrationId", required = true, nillable = true)
    protected BigInteger alienRegistrationId;
    @XmlElementRef(name = "SsnMatchIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<String> ssnMatchIndicator;
    @XmlElement(name = "MaritalStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maritalStatusCode;
    @XmlElement(name = "MaritalStatusDate", required = true, nillable = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar maritalStatusDate;
    @XmlElement(name = "YearInCollegeCode", required = true, nillable = true)
    protected BigInteger yearInCollegeCode;
    @XmlElement(name = "MembersInFamily", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long membersInFamily;
    @XmlElement(name = "NumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long numberInCollege;
    @XmlElementRef(name = "BornPriorIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> bornPriorIndicator;
    @XmlElementRef(name = "WorkOnGraduateDegreeInd", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> workOnGraduateDegreeInd;
    @XmlElementRef(name = "MarriedIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> marriedIndicator;
    @XmlElementRef(name = "HaveChildrenYouSupportIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> haveChildrenYouSupportIndicator;
    @XmlElementRef(name = "LegalDependentsIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> legalDependentsIndicator;
    @XmlElementRef(name = "OrphanWardOfCourtIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> orphanWardOfCourtIndicator;
    @XmlElementRef(name = "VeteranIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> veteranIndicator;
    @XmlElementRef(name = "ActiveDutyIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> activeDutyIndicator;
    @XmlElementRef(name = "EmancipatedMinorIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> emancipatedMinorIndicator;
    @XmlElementRef(name = "InLegalGuardianshipIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> inLegalGuardianshipIndicator;
    @XmlElementRef(name = "UnaccompaniedYouthBySchoolIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> unaccompaniedYouthBySchoolIndicator;
    @XmlElementRef(name = "UnaccompaniedYouthByHUDIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> unaccompaniedYouthByHUDIndicator;
    @XmlElementRef(name = "AtRiskHomelessIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> atRiskHomelessIndicator;
    @XmlElement(name = "TaxReturnStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long taxReturnStatusCode;
    @XmlElement(name = "TaxFormTypeCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long taxFormTypeCode;
    @XmlElement(name = "EligibleToFile1040AOr1040EZ", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long eligibleToFile1040AOr1040EZ;
    @XmlElementRef(name = "ReceiveSSI", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveSSI;
    @XmlElementRef(name = "ReceiveFoodStamps", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveFoodStamps;
    @XmlElementRef(name = "ReceiveFreeLunch", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveFreeLunch;
    @XmlElementRef(name = "ReceiveTANF", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveTANF;
    @XmlElementRef(name = "ReceiveWIC", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveWIC;
    @XmlElementRef(name = "DislocatedWorker", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> dislocatedWorker;
    @XmlElementRef(name = "AssetThresholdExceeded", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assetThresholdExceeded;
    @XmlElement(name = "AdjustedGrossIncome", required = true, type = Integer.class, nillable = true)
    protected Integer adjustedGrossIncome;
    @XmlElement(name = "IncomeTaxPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long incomeTaxPaid;
    @XmlElement(name = "ExemptionsClaimed", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long exemptionsClaimed;
    @XmlElement(name = "StudentEarnedIncome", required = true, type = Integer.class, nillable = true)
    protected Integer studentEarnedIncome;
    @XmlElement(name = "SpouseEarnedIncome", required = true, type = Integer.class, nillable = true)
    protected Integer spouseEarnedIncome;
    @XmlElement(name = "CashSavingsChecking", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long cashSavingsChecking;
    @XmlElement(name = "InvestmentNetworth", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long investmentNetworth;
    @XmlElement(name = "BusinessFarmNetworth", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long businessFarmNetworth;
    @XmlElement(name = "EducationCredits", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long educationCredits;
    @XmlElement(name = "ChildSupportPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long childSupportPaid;
    @XmlElement(name = "NeedBasedEmployment", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long needBasedEmployment;
    @XmlElement(name = "GrantsScholarshipsResources", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long grantsScholarshipsResources;
    @XmlElement(name = "CombatPay", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long combatPay;
    @XmlElement(name = "CoOpEarnings", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long coOpEarnings;
    @XmlElement(name = "PensionPayments", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long pensionPayments;
    @XmlElement(name = "IraPayments", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long iraPayments;
    @XmlElement(name = "ChildSupportReceived", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long childSupportReceived;
    @XmlElement(name = "InterestDividendIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long interestDividendIncome;
    @XmlElement(name = "IraDistributions", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long iraDistributions;
    @XmlElement(name = "UntaxedPensionPayments", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long untaxedPensionPayments;
    @XmlElement(name = "MilitaryClergyAllowances", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long militaryClergyAllowances;
    @XmlElement(name = "VeteranNonEducationBenefits", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long veteranNonEducationBenefits;
    @XmlElement(name = "OtherUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherUntaxedIncome;
    @XmlElement(name = "OtherNonReportedMoney", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherNonReportedMoney;

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the middleInitial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * Sets the value of the middleInitial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleInitial(String value) {
        this.middleInitial = value;
    }

    /**
     * Gets the value of the residencyStateProvinceCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}
     *     
     */
    public JAXBElement<StateProvinceType> getResidencyStateProvinceCode() {
        return residencyStateProvinceCode;
    }

    /**
     * Sets the value of the residencyStateProvinceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}
     *     
     */
    public void setResidencyStateProvinceCode(JAXBElement<StateProvinceType> value) {
        this.residencyStateProvinceCode = ((JAXBElement<StateProvinceType> ) value);
    }

    /**
     * Gets the value of the stateProvinceCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}
     *     
     */
    public JAXBElement<StateProvinceType> getStateProvinceCode() {
        return stateProvinceCode;
    }

    /**
     * Sets the value of the stateProvinceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}
     *     
     */
    public void setStateProvinceCode(JAXBElement<StateProvinceType> value) {
        this.stateProvinceCode = ((JAXBElement<StateProvinceType> ) value);
    }

    /**
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setZipCode(JAXBElement<BigDecimal> value) {
        this.zipCode = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setBirthDate(JAXBElement<XMLGregorianCalendar> value) {
        this.birthDate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the citizenshipStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCitizenshipStatusCode() {
        return citizenshipStatusCode;
    }

    /**
     * Sets the value of the citizenshipStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCitizenshipStatusCode(Long value) {
        this.citizenshipStatusCode = value;
    }

    /**
     * Gets the value of the citizenshipSsaFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCitizenshipSsaFlag() {
        return citizenshipSsaFlag;
    }

    /**
     * Sets the value of the citizenshipSsaFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCitizenshipSsaFlag(JAXBElement<String> value) {
        this.citizenshipSsaFlag = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the alienRegistrationId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAlienRegistrationId() {
        return alienRegistrationId;
    }

    /**
     * Sets the value of the alienRegistrationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAlienRegistrationId(BigInteger value) {
        this.alienRegistrationId = value;
    }

    /**
     * Gets the value of the ssnMatchIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSsnMatchIndicator() {
        return ssnMatchIndicator;
    }

    /**
     * Sets the value of the ssnMatchIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSsnMatchIndicator(JAXBElement<String> value) {
        this.ssnMatchIndicator = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the maritalStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaritalStatusCode() {
        return maritalStatusCode;
    }

    /**
     * Sets the value of the maritalStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaritalStatusCode(Long value) {
        this.maritalStatusCode = value;
    }

    /**
     * Gets the value of the maritalStatusDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMaritalStatusDate() {
        return maritalStatusDate;
    }

    /**
     * Sets the value of the maritalStatusDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMaritalStatusDate(XMLGregorianCalendar value) {
        this.maritalStatusDate = value;
    }

    /**
     * Gets the value of the yearInCollegeCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYearInCollegeCode() {
        return yearInCollegeCode;
    }

    /**
     * Sets the value of the yearInCollegeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYearInCollegeCode(BigInteger value) {
        this.yearInCollegeCode = value;
    }

    /**
     * Gets the value of the membersInFamily property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMembersInFamily() {
        return membersInFamily;
    }

    /**
     * Sets the value of the membersInFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMembersInFamily(Long value) {
        this.membersInFamily = value;
    }

    /**
     * Gets the value of the numberInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumberInCollege() {
        return numberInCollege;
    }

    /**
     * Sets the value of the numberInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumberInCollege(Long value) {
        this.numberInCollege = value;
    }

    /**
     * Gets the value of the bornPriorIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getBornPriorIndicator() {
        return bornPriorIndicator;
    }

    /**
     * Sets the value of the bornPriorIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setBornPriorIndicator(JAXBElement<YesNoType> value) {
        this.bornPriorIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the workOnGraduateDegreeInd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getWorkOnGraduateDegreeInd() {
        return workOnGraduateDegreeInd;
    }

    /**
     * Sets the value of the workOnGraduateDegreeInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setWorkOnGraduateDegreeInd(JAXBElement<YesNoType> value) {
        this.workOnGraduateDegreeInd = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the marriedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMarriedIndicator() {
        return marriedIndicator;
    }

    /**
     * Sets the value of the marriedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMarriedIndicator(JAXBElement<YesNoType> value) {
        this.marriedIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the haveChildrenYouSupportIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getHaveChildrenYouSupportIndicator() {
        return haveChildrenYouSupportIndicator;
    }

    /**
     * Sets the value of the haveChildrenYouSupportIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setHaveChildrenYouSupportIndicator(JAXBElement<YesNoType> value) {
        this.haveChildrenYouSupportIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the legalDependentsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getLegalDependentsIndicator() {
        return legalDependentsIndicator;
    }

    /**
     * Sets the value of the legalDependentsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setLegalDependentsIndicator(JAXBElement<YesNoType> value) {
        this.legalDependentsIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the orphanWardOfCourtIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getOrphanWardOfCourtIndicator() {
        return orphanWardOfCourtIndicator;
    }

    /**
     * Sets the value of the orphanWardOfCourtIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setOrphanWardOfCourtIndicator(JAXBElement<YesNoType> value) {
        this.orphanWardOfCourtIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the veteranIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getVeteranIndicator() {
        return veteranIndicator;
    }

    /**
     * Sets the value of the veteranIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setVeteranIndicator(JAXBElement<YesNoType> value) {
        this.veteranIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the activeDutyIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getActiveDutyIndicator() {
        return activeDutyIndicator;
    }

    /**
     * Sets the value of the activeDutyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setActiveDutyIndicator(JAXBElement<YesNoType> value) {
        this.activeDutyIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the emancipatedMinorIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getEmancipatedMinorIndicator() {
        return emancipatedMinorIndicator;
    }

    /**
     * Sets the value of the emancipatedMinorIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setEmancipatedMinorIndicator(JAXBElement<YesNoType> value) {
        this.emancipatedMinorIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the inLegalGuardianshipIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getInLegalGuardianshipIndicator() {
        return inLegalGuardianshipIndicator;
    }

    /**
     * Sets the value of the inLegalGuardianshipIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setInLegalGuardianshipIndicator(JAXBElement<YesNoType> value) {
        this.inLegalGuardianshipIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the unaccompaniedYouthBySchoolIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUnaccompaniedYouthBySchoolIndicator() {
        return unaccompaniedYouthBySchoolIndicator;
    }

    /**
     * Sets the value of the unaccompaniedYouthBySchoolIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUnaccompaniedYouthBySchoolIndicator(JAXBElement<YesNoType> value) {
        this.unaccompaniedYouthBySchoolIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the unaccompaniedYouthByHUDIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUnaccompaniedYouthByHUDIndicator() {
        return unaccompaniedYouthByHUDIndicator;
    }

    /**
     * Sets the value of the unaccompaniedYouthByHUDIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUnaccompaniedYouthByHUDIndicator(JAXBElement<YesNoType> value) {
        this.unaccompaniedYouthByHUDIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the atRiskHomelessIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAtRiskHomelessIndicator() {
        return atRiskHomelessIndicator;
    }

    /**
     * Sets the value of the atRiskHomelessIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAtRiskHomelessIndicator(JAXBElement<YesNoType> value) {
        this.atRiskHomelessIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the taxReturnStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTaxReturnStatusCode() {
        return taxReturnStatusCode;
    }

    /**
     * Sets the value of the taxReturnStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTaxReturnStatusCode(Long value) {
        this.taxReturnStatusCode = value;
    }

    /**
     * Gets the value of the taxFormTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTaxFormTypeCode() {
        return taxFormTypeCode;
    }

    /**
     * Sets the value of the taxFormTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTaxFormTypeCode(Long value) {
        this.taxFormTypeCode = value;
    }

    /**
     * Gets the value of the eligibleToFile1040AOr1040EZ property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEligibleToFile1040AOr1040EZ() {
        return eligibleToFile1040AOr1040EZ;
    }

    /**
     * Sets the value of the eligibleToFile1040AOr1040EZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEligibleToFile1040AOr1040EZ(Long value) {
        this.eligibleToFile1040AOr1040EZ = value;
    }

    /**
     * Gets the value of the receiveSSI property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getReceiveSSI() {
        return receiveSSI;
    }

    /**
     * Sets the value of the receiveSSI property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setReceiveSSI(JAXBElement<YesNoType> value) {
        this.receiveSSI = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the receiveFoodStamps property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getReceiveFoodStamps() {
        return receiveFoodStamps;
    }

    /**
     * Sets the value of the receiveFoodStamps property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setReceiveFoodStamps(JAXBElement<YesNoType> value) {
        this.receiveFoodStamps = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the receiveFreeLunch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getReceiveFreeLunch() {
        return receiveFreeLunch;
    }

    /**
     * Sets the value of the receiveFreeLunch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setReceiveFreeLunch(JAXBElement<YesNoType> value) {
        this.receiveFreeLunch = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the receiveTANF property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getReceiveTANF() {
        return receiveTANF;
    }

    /**
     * Sets the value of the receiveTANF property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setReceiveTANF(JAXBElement<YesNoType> value) {
        this.receiveTANF = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the receiveWIC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getReceiveWIC() {
        return receiveWIC;
    }

    /**
     * Sets the value of the receiveWIC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setReceiveWIC(JAXBElement<YesNoType> value) {
        this.receiveWIC = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the dislocatedWorker property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getDislocatedWorker() {
        return dislocatedWorker;
    }

    /**
     * Sets the value of the dislocatedWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setDislocatedWorker(JAXBElement<YesNoType> value) {
        this.dislocatedWorker = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assetThresholdExceeded property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssetThresholdExceeded() {
        return assetThresholdExceeded;
    }

    /**
     * Sets the value of the assetThresholdExceeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssetThresholdExceeded(JAXBElement<YesNoType> value) {
        this.assetThresholdExceeded = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the adjustedGrossIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAdjustedGrossIncome() {
        return adjustedGrossIncome;
    }

    /**
     * Sets the value of the adjustedGrossIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAdjustedGrossIncome(Integer value) {
        this.adjustedGrossIncome = value;
    }

    /**
     * Gets the value of the incomeTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIncomeTaxPaid() {
        return incomeTaxPaid;
    }

    /**
     * Sets the value of the incomeTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIncomeTaxPaid(Long value) {
        this.incomeTaxPaid = value;
    }

    /**
     * Gets the value of the exemptionsClaimed property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExemptionsClaimed() {
        return exemptionsClaimed;
    }

    /**
     * Sets the value of the exemptionsClaimed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExemptionsClaimed(Long value) {
        this.exemptionsClaimed = value;
    }

    /**
     * Gets the value of the studentEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStudentEarnedIncome() {
        return studentEarnedIncome;
    }

    /**
     * Sets the value of the studentEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStudentEarnedIncome(Integer value) {
        this.studentEarnedIncome = value;
    }

    /**
     * Gets the value of the spouseEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSpouseEarnedIncome() {
        return spouseEarnedIncome;
    }

    /**
     * Sets the value of the spouseEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpouseEarnedIncome(Integer value) {
        this.spouseEarnedIncome = value;
    }

    /**
     * Gets the value of the cashSavingsChecking property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCashSavingsChecking() {
        return cashSavingsChecking;
    }

    /**
     * Sets the value of the cashSavingsChecking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCashSavingsChecking(Long value) {
        this.cashSavingsChecking = value;
    }

    /**
     * Gets the value of the investmentNetworth property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvestmentNetworth() {
        return investmentNetworth;
    }

    /**
     * Sets the value of the investmentNetworth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvestmentNetworth(Long value) {
        this.investmentNetworth = value;
    }

    /**
     * Gets the value of the businessFarmNetworth property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessFarmNetworth() {
        return businessFarmNetworth;
    }

    /**
     * Sets the value of the businessFarmNetworth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessFarmNetworth(Long value) {
        this.businessFarmNetworth = value;
    }

    /**
     * Gets the value of the educationCredits property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEducationCredits() {
        return educationCredits;
    }

    /**
     * Sets the value of the educationCredits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEducationCredits(Long value) {
        this.educationCredits = value;
    }

    /**
     * Gets the value of the childSupportPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChildSupportPaid() {
        return childSupportPaid;
    }

    /**
     * Sets the value of the childSupportPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChildSupportPaid(Long value) {
        this.childSupportPaid = value;
    }

    /**
     * Gets the value of the needBasedEmployment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNeedBasedEmployment() {
        return needBasedEmployment;
    }

    /**
     * Sets the value of the needBasedEmployment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNeedBasedEmployment(Long value) {
        this.needBasedEmployment = value;
    }

    /**
     * Gets the value of the grantsScholarshipsResources property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGrantsScholarshipsResources() {
        return grantsScholarshipsResources;
    }

    /**
     * Sets the value of the grantsScholarshipsResources property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGrantsScholarshipsResources(Long value) {
        this.grantsScholarshipsResources = value;
    }

    /**
     * Gets the value of the combatPay property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCombatPay() {
        return combatPay;
    }

    /**
     * Sets the value of the combatPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCombatPay(Long value) {
        this.combatPay = value;
    }

    /**
     * Gets the value of the coOpEarnings property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCoOpEarnings() {
        return coOpEarnings;
    }

    /**
     * Sets the value of the coOpEarnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCoOpEarnings(Long value) {
        this.coOpEarnings = value;
    }

    /**
     * Gets the value of the pensionPayments property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPensionPayments() {
        return pensionPayments;
    }

    /**
     * Sets the value of the pensionPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPensionPayments(Long value) {
        this.pensionPayments = value;
    }

    /**
     * Gets the value of the iraPayments property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIraPayments() {
        return iraPayments;
    }

    /**
     * Sets the value of the iraPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIraPayments(Long value) {
        this.iraPayments = value;
    }

    /**
     * Gets the value of the childSupportReceived property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChildSupportReceived() {
        return childSupportReceived;
    }

    /**
     * Sets the value of the childSupportReceived property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChildSupportReceived(Long value) {
        this.childSupportReceived = value;
    }

    /**
     * Gets the value of the interestDividendIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterestDividendIncome() {
        return interestDividendIncome;
    }

    /**
     * Sets the value of the interestDividendIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterestDividendIncome(Long value) {
        this.interestDividendIncome = value;
    }

    /**
     * Gets the value of the iraDistributions property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIraDistributions() {
        return iraDistributions;
    }

    /**
     * Sets the value of the iraDistributions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIraDistributions(Long value) {
        this.iraDistributions = value;
    }

    /**
     * Gets the value of the untaxedPensionPayments property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUntaxedPensionPayments() {
        return untaxedPensionPayments;
    }

    /**
     * Sets the value of the untaxedPensionPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUntaxedPensionPayments(Long value) {
        this.untaxedPensionPayments = value;
    }

    /**
     * Gets the value of the militaryClergyAllowances property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMilitaryClergyAllowances() {
        return militaryClergyAllowances;
    }

    /**
     * Sets the value of the militaryClergyAllowances property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMilitaryClergyAllowances(Long value) {
        this.militaryClergyAllowances = value;
    }

    /**
     * Gets the value of the veteranNonEducationBenefits property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVeteranNonEducationBenefits() {
        return veteranNonEducationBenefits;
    }

    /**
     * Sets the value of the veteranNonEducationBenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVeteranNonEducationBenefits(Long value) {
        this.veteranNonEducationBenefits = value;
    }

    /**
     * Gets the value of the otherUntaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherUntaxedIncome() {
        return otherUntaxedIncome;
    }

    /**
     * Sets the value of the otherUntaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherUntaxedIncome(Long value) {
        this.otherUntaxedIncome = value;
    }

    /**
     * Gets the value of the otherNonReportedMoney property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherNonReportedMoney() {
        return otherNonReportedMoney;
    }

    /**
     * Sets the value of the otherNonReportedMoney property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherNonReportedMoney(Long value) {
        this.otherNonReportedMoney = value;
    }

}
