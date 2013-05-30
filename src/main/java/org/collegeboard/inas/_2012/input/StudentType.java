
package org.collegeboard.inas._2012.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for studentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApplicationType" type="{http://INAS.collegeboard.org/2012/Input/}applicationTypeType" minOccurs="0"/>
 *         &lt;element name="ApplicationReceiptDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="StateProvinceCode" type="{http://INAS.collegeboard.org/2012/Input/}stateProvinceType" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ResidencyStateProvinceCode" type="{http://INAS.collegeboard.org/2012/Input/}stateProvinceType" minOccurs="0"/>
 *         &lt;element name="ForeignAddressIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="YearInCollegeCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CitizenshipStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MaritalStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="VeteranIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="OrphanWardOfCourtIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="OrphanFosterWardAfter13Indicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="HomelessIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="LegalDependentsIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MeansTestedBenefits" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="DislocatedWorker" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MembersInFamily" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxReturnStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxFormTypeCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExemptionsClaimed" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AdjustedGrossIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IncomeTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="EducationCredits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ItemizedDeductions" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SpouseEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CombatPay" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InterestDividendIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SocialSecurityBenefits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TANF" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ChildSupportReceived" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="EarnedIncomeCredit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxableFinancialAid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ChildSupportPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MedicalDentalExpenses" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="VeteransBenefitsMonthlyAmount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberMonthsReceiveVABenefits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SummerEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SchoolYearEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SpouseSummerEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SpouseSchoolYearEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SummerOtherTaxedIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SchoolYearOtherTaxedIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SummerUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SchoolYearUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="GrantsScholarshipsResources" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TuitionBenefits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentContributionOffer" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="RelativesContributionOffer" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CashSavingsChecking" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="IRAKeogh" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InvestmentValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InvestmentDebt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TrustFund" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="HomeValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="HomeDebt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="HomePurchaseYear" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="HomePurchasePrice" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherRealEstateValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherRealEstateDebt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="LargeBusinessIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="LiveOnFarmIndicator" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="BusinessFarmValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="BusinessFarmDebt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentType", propOrder = {
    "applicationType",
    "applicationReceiptDate",
    "birthDate",
    "stateProvinceCode",
    "postalCode",
    "residencyStateProvinceCode",
    "foreignAddressIndicator",
    "countryCode",
    "yearInCollegeCode",
    "citizenshipStatusCode",
    "maritalStatusCode",
    "veteranIndicator",
    "orphanWardOfCourtIndicator",
    "orphanFosterWardAfter13Indicator",
    "homelessIndicator",
    "legalDependentsIndicator",
    "meansTestedBenefits",
    "dislocatedWorker",
    "membersInFamily",
    "numberInCollege",
    "taxReturnStatusCode",
    "taxFormTypeCode",
    "exemptionsClaimed",
    "adjustedGrossIncome",
    "incomeTaxPaid",
    "educationCredits",
    "itemizedDeductions",
    "studentEarnedIncome",
    "spouseEarnedIncome",
    "combatPay",
    "interestDividendIncome",
    "socialSecurityBenefits",
    "tanf",
    "childSupportReceived",
    "earnedIncomeCredit",
    "otherUntaxedIncome",
    "taxableFinancialAid",
    "childSupportPaid",
    "medicalDentalExpenses",
    "veteransBenefitsMonthlyAmount",
    "numberMonthsReceiveVABenefits",
    "summerEarnedIncome",
    "schoolYearEarnedIncome",
    "spouseSummerEarnedIncome",
    "spouseSchoolYearEarnedIncome",
    "summerOtherTaxedIncome",
    "schoolYearOtherTaxedIncome",
    "summerUntaxedIncome",
    "schoolYearUntaxedIncome",
    "grantsScholarshipsResources",
    "tuitionBenefits",
    "parentContributionOffer",
    "relativesContributionOffer",
    "cashSavingsChecking",
    "iraKeogh",
    "investmentValue",
    "investmentDebt",
    "trustFund",
    "homeValue",
    "homeDebt",
    "homePurchaseYear",
    "homePurchasePrice",
    "otherRealEstateValue",
    "otherRealEstateDebt",
    "largeBusinessIndicator",
    "liveOnFarmIndicator",
    "businessFarmValue",
    "businessFarmDebt"
})
public class StudentType {

    @XmlElementRef(name = "ApplicationType", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<ApplicationTypeType> applicationType;
    @XmlElementRef(name = "ApplicationReceiptDate", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> applicationReceiptDate;
    @XmlElementRef(name = "BirthDate", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> birthDate;
    @XmlElementRef(name = "StateProvinceCode", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<StateProvinceType> stateProvinceCode;
    @XmlElement(name = "PostalCode", required = true, nillable = true)
    protected String postalCode;
    @XmlElementRef(name = "ResidencyStateProvinceCode", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<StateProvinceType> residencyStateProvinceCode;
    @XmlElementRef(name = "ForeignAddressIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> foreignAddressIndicator;
    @XmlElement(name = "CountryCode", required = true, nillable = true)
    protected String countryCode;
    @XmlElement(name = "YearInCollegeCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long yearInCollegeCode;
    @XmlElement(name = "CitizenshipStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long citizenshipStatusCode;
    @XmlElement(name = "MaritalStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maritalStatusCode;
    @XmlElementRef(name = "VeteranIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> veteranIndicator;
    @XmlElementRef(name = "OrphanWardOfCourtIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> orphanWardOfCourtIndicator;
    @XmlElementRef(name = "OrphanFosterWardAfter13Indicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> orphanFosterWardAfter13Indicator;
    @XmlElementRef(name = "HomelessIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> homelessIndicator;
    @XmlElementRef(name = "LegalDependentsIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> legalDependentsIndicator;
    @XmlElementRef(name = "MeansTestedBenefits", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> meansTestedBenefits;
    @XmlElementRef(name = "DislocatedWorker", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> dislocatedWorker;
    @XmlElement(name = "MembersInFamily", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long membersInFamily;
    @XmlElement(name = "NumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long numberInCollege;
    @XmlElement(name = "TaxReturnStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long taxReturnStatusCode;
    @XmlElement(name = "TaxFormTypeCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long taxFormTypeCode;
    @XmlElement(name = "ExemptionsClaimed", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long exemptionsClaimed;
    @XmlElement(name = "AdjustedGrossIncome", required = true, type = Integer.class, nillable = true)
    protected Integer adjustedGrossIncome;
    @XmlElement(name = "IncomeTaxPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long incomeTaxPaid;
    @XmlElement(name = "EducationCredits", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long educationCredits;
    @XmlElement(name = "ItemizedDeductions", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long itemizedDeductions;
    @XmlElement(name = "StudentEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentEarnedIncome;
    @XmlElement(name = "SpouseEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long spouseEarnedIncome;
    @XmlElement(name = "CombatPay", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long combatPay;
    @XmlElement(name = "InterestDividendIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long interestDividendIncome;
    @XmlElement(name = "SocialSecurityBenefits", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long socialSecurityBenefits;
    @XmlElement(name = "TANF", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long tanf;
    @XmlElement(name = "ChildSupportReceived", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long childSupportReceived;
    @XmlElement(name = "EarnedIncomeCredit", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long earnedIncomeCredit;
    @XmlElement(name = "OtherUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherUntaxedIncome;
    @XmlElement(name = "TaxableFinancialAid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long taxableFinancialAid;
    @XmlElement(name = "ChildSupportPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long childSupportPaid;
    @XmlElement(name = "MedicalDentalExpenses", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long medicalDentalExpenses;
    @XmlElement(name = "VeteransBenefitsMonthlyAmount", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long veteransBenefitsMonthlyAmount;
    @XmlElement(name = "NumberMonthsReceiveVABenefits", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long numberMonthsReceiveVABenefits;
    @XmlElement(name = "SummerEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long summerEarnedIncome;
    @XmlElement(name = "SchoolYearEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long schoolYearEarnedIncome;
    @XmlElement(name = "SpouseSummerEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long spouseSummerEarnedIncome;
    @XmlElement(name = "SpouseSchoolYearEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long spouseSchoolYearEarnedIncome;
    @XmlElement(name = "SummerOtherTaxedIncome", required = true, type = Integer.class, nillable = true)
    protected Integer summerOtherTaxedIncome;
    @XmlElement(name = "SchoolYearOtherTaxedIncome", required = true, type = Integer.class, nillable = true)
    protected Integer schoolYearOtherTaxedIncome;
    @XmlElement(name = "SummerUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long summerUntaxedIncome;
    @XmlElement(name = "SchoolYearUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long schoolYearUntaxedIncome;
    @XmlElement(name = "GrantsScholarshipsResources", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long grantsScholarshipsResources;
    @XmlElement(name = "TuitionBenefits", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long tuitionBenefits;
    @XmlElement(name = "ParentContributionOffer", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentContributionOffer;
    @XmlElement(name = "RelativesContributionOffer", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long relativesContributionOffer;
    @XmlElement(name = "CashSavingsChecking", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long cashSavingsChecking;
    @XmlElement(name = "IRAKeogh", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long iraKeogh;
    @XmlElement(name = "InvestmentValue", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long investmentValue;
    @XmlElement(name = "InvestmentDebt", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long investmentDebt;
    @XmlElement(name = "TrustFund", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long trustFund;
    @XmlElement(name = "HomeValue", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long homeValue;
    @XmlElement(name = "HomeDebt", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long homeDebt;
    @XmlElement(name = "HomePurchaseYear", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long homePurchaseYear;
    @XmlElement(name = "HomePurchasePrice", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long homePurchasePrice;
    @XmlElement(name = "OtherRealEstateValue", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherRealEstateValue;
    @XmlElement(name = "OtherRealEstateDebt", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherRealEstateDebt;
    @XmlElementRef(name = "LargeBusinessIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> largeBusinessIndicator;
    @XmlElementRef(name = "LiveOnFarmIndicator", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> liveOnFarmIndicator;
    @XmlElement(name = "BusinessFarmValue", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long businessFarmValue;
    @XmlElement(name = "BusinessFarmDebt", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long businessFarmDebt;

    /**
     * Gets the value of the applicationType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ApplicationTypeType }{@code >}
     *     
     */
    public JAXBElement<ApplicationTypeType> getApplicationType() {
        return applicationType;
    }

    /**
     * Sets the value of the applicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ApplicationTypeType }{@code >}
     *     
     */
    public void setApplicationType(JAXBElement<ApplicationTypeType> value) {
        this.applicationType = ((JAXBElement<ApplicationTypeType> ) value);
    }

    /**
     * Gets the value of the applicationReceiptDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getApplicationReceiptDate() {
        return applicationReceiptDate;
    }

    /**
     * Sets the value of the applicationReceiptDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setApplicationReceiptDate(JAXBElement<XMLGregorianCalendar> value) {
        this.applicationReceiptDate = ((JAXBElement<XMLGregorianCalendar> ) value);
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
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
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
     * Gets the value of the foreignAddressIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getForeignAddressIndicator() {
        return foreignAddressIndicator;
    }

    /**
     * Sets the value of the foreignAddressIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setForeignAddressIndicator(JAXBElement<YesNoType> value) {
        this.foreignAddressIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the yearInCollegeCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getYearInCollegeCode() {
        return yearInCollegeCode;
    }

    /**
     * Sets the value of the yearInCollegeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setYearInCollegeCode(Long value) {
        this.yearInCollegeCode = value;
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
     * Gets the value of the orphanFosterWardAfter13Indicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getOrphanFosterWardAfter13Indicator() {
        return orphanFosterWardAfter13Indicator;
    }

    /**
     * Sets the value of the orphanFosterWardAfter13Indicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setOrphanFosterWardAfter13Indicator(JAXBElement<YesNoType> value) {
        this.orphanFosterWardAfter13Indicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the homelessIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getHomelessIndicator() {
        return homelessIndicator;
    }

    /**
     * Sets the value of the homelessIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setHomelessIndicator(JAXBElement<YesNoType> value) {
        this.homelessIndicator = ((JAXBElement<YesNoType> ) value);
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
     * Gets the value of the meansTestedBenefits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMeansTestedBenefits() {
        return meansTestedBenefits;
    }

    /**
     * Sets the value of the meansTestedBenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMeansTestedBenefits(JAXBElement<YesNoType> value) {
        this.meansTestedBenefits = ((JAXBElement<YesNoType> ) value);
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
     * Gets the value of the itemizedDeductions property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemizedDeductions() {
        return itemizedDeductions;
    }

    /**
     * Sets the value of the itemizedDeductions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemizedDeductions(Long value) {
        this.itemizedDeductions = value;
    }

    /**
     * Gets the value of the studentEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentEarnedIncome() {
        return studentEarnedIncome;
    }

    /**
     * Sets the value of the studentEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentEarnedIncome(Long value) {
        this.studentEarnedIncome = value;
    }

    /**
     * Gets the value of the spouseEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSpouseEarnedIncome() {
        return spouseEarnedIncome;
    }

    /**
     * Sets the value of the spouseEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSpouseEarnedIncome(Long value) {
        this.spouseEarnedIncome = value;
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
     * Gets the value of the socialSecurityBenefits property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSocialSecurityBenefits() {
        return socialSecurityBenefits;
    }

    /**
     * Sets the value of the socialSecurityBenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSocialSecurityBenefits(Long value) {
        this.socialSecurityBenefits = value;
    }

    /**
     * Gets the value of the tanf property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTANF() {
        return tanf;
    }

    /**
     * Sets the value of the tanf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTANF(Long value) {
        this.tanf = value;
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
     * Gets the value of the earnedIncomeCredit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEarnedIncomeCredit() {
        return earnedIncomeCredit;
    }

    /**
     * Sets the value of the earnedIncomeCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEarnedIncomeCredit(Long value) {
        this.earnedIncomeCredit = value;
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
     * Gets the value of the taxableFinancialAid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTaxableFinancialAid() {
        return taxableFinancialAid;
    }

    /**
     * Sets the value of the taxableFinancialAid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTaxableFinancialAid(Long value) {
        this.taxableFinancialAid = value;
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
     * Gets the value of the medicalDentalExpenses property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMedicalDentalExpenses() {
        return medicalDentalExpenses;
    }

    /**
     * Sets the value of the medicalDentalExpenses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMedicalDentalExpenses(Long value) {
        this.medicalDentalExpenses = value;
    }

    /**
     * Gets the value of the veteransBenefitsMonthlyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVeteransBenefitsMonthlyAmount() {
        return veteransBenefitsMonthlyAmount;
    }

    /**
     * Sets the value of the veteransBenefitsMonthlyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVeteransBenefitsMonthlyAmount(Long value) {
        this.veteransBenefitsMonthlyAmount = value;
    }

    /**
     * Gets the value of the numberMonthsReceiveVABenefits property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumberMonthsReceiveVABenefits() {
        return numberMonthsReceiveVABenefits;
    }

    /**
     * Sets the value of the numberMonthsReceiveVABenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumberMonthsReceiveVABenefits(Long value) {
        this.numberMonthsReceiveVABenefits = value;
    }

    /**
     * Gets the value of the summerEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSummerEarnedIncome() {
        return summerEarnedIncome;
    }

    /**
     * Sets the value of the summerEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSummerEarnedIncome(Long value) {
        this.summerEarnedIncome = value;
    }

    /**
     * Gets the value of the schoolYearEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSchoolYearEarnedIncome() {
        return schoolYearEarnedIncome;
    }

    /**
     * Sets the value of the schoolYearEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSchoolYearEarnedIncome(Long value) {
        this.schoolYearEarnedIncome = value;
    }

    /**
     * Gets the value of the spouseSummerEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSpouseSummerEarnedIncome() {
        return spouseSummerEarnedIncome;
    }

    /**
     * Sets the value of the spouseSummerEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSpouseSummerEarnedIncome(Long value) {
        this.spouseSummerEarnedIncome = value;
    }

    /**
     * Gets the value of the spouseSchoolYearEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSpouseSchoolYearEarnedIncome() {
        return spouseSchoolYearEarnedIncome;
    }

    /**
     * Sets the value of the spouseSchoolYearEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSpouseSchoolYearEarnedIncome(Long value) {
        this.spouseSchoolYearEarnedIncome = value;
    }

    /**
     * Gets the value of the summerOtherTaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSummerOtherTaxedIncome() {
        return summerOtherTaxedIncome;
    }

    /**
     * Sets the value of the summerOtherTaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSummerOtherTaxedIncome(Integer value) {
        this.summerOtherTaxedIncome = value;
    }

    /**
     * Gets the value of the schoolYearOtherTaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSchoolYearOtherTaxedIncome() {
        return schoolYearOtherTaxedIncome;
    }

    /**
     * Sets the value of the schoolYearOtherTaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSchoolYearOtherTaxedIncome(Integer value) {
        this.schoolYearOtherTaxedIncome = value;
    }

    /**
     * Gets the value of the summerUntaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSummerUntaxedIncome() {
        return summerUntaxedIncome;
    }

    /**
     * Sets the value of the summerUntaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSummerUntaxedIncome(Long value) {
        this.summerUntaxedIncome = value;
    }

    /**
     * Gets the value of the schoolYearUntaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSchoolYearUntaxedIncome() {
        return schoolYearUntaxedIncome;
    }

    /**
     * Sets the value of the schoolYearUntaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSchoolYearUntaxedIncome(Long value) {
        this.schoolYearUntaxedIncome = value;
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
     * Gets the value of the tuitionBenefits property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTuitionBenefits() {
        return tuitionBenefits;
    }

    /**
     * Sets the value of the tuitionBenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTuitionBenefits(Long value) {
        this.tuitionBenefits = value;
    }

    /**
     * Gets the value of the parentContributionOffer property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentContributionOffer() {
        return parentContributionOffer;
    }

    /**
     * Sets the value of the parentContributionOffer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentContributionOffer(Long value) {
        this.parentContributionOffer = value;
    }

    /**
     * Gets the value of the relativesContributionOffer property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRelativesContributionOffer() {
        return relativesContributionOffer;
    }

    /**
     * Sets the value of the relativesContributionOffer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRelativesContributionOffer(Long value) {
        this.relativesContributionOffer = value;
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
     * Gets the value of the iraKeogh property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIRAKeogh() {
        return iraKeogh;
    }

    /**
     * Sets the value of the iraKeogh property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIRAKeogh(Long value) {
        this.iraKeogh = value;
    }

    /**
     * Gets the value of the investmentValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvestmentValue() {
        return investmentValue;
    }

    /**
     * Sets the value of the investmentValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvestmentValue(Long value) {
        this.investmentValue = value;
    }

    /**
     * Gets the value of the investmentDebt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvestmentDebt() {
        return investmentDebt;
    }

    /**
     * Sets the value of the investmentDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvestmentDebt(Long value) {
        this.investmentDebt = value;
    }

    /**
     * Gets the value of the trustFund property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTrustFund() {
        return trustFund;
    }

    /**
     * Sets the value of the trustFund property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTrustFund(Long value) {
        this.trustFund = value;
    }

    /**
     * Gets the value of the homeValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHomeValue() {
        return homeValue;
    }

    /**
     * Sets the value of the homeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHomeValue(Long value) {
        this.homeValue = value;
    }

    /**
     * Gets the value of the homeDebt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHomeDebt() {
        return homeDebt;
    }

    /**
     * Sets the value of the homeDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHomeDebt(Long value) {
        this.homeDebt = value;
    }

    /**
     * Gets the value of the homePurchaseYear property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHomePurchaseYear() {
        return homePurchaseYear;
    }

    /**
     * Sets the value of the homePurchaseYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHomePurchaseYear(Long value) {
        this.homePurchaseYear = value;
    }

    /**
     * Gets the value of the homePurchasePrice property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHomePurchasePrice() {
        return homePurchasePrice;
    }

    /**
     * Sets the value of the homePurchasePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHomePurchasePrice(Long value) {
        this.homePurchasePrice = value;
    }

    /**
     * Gets the value of the otherRealEstateValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherRealEstateValue() {
        return otherRealEstateValue;
    }

    /**
     * Sets the value of the otherRealEstateValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherRealEstateValue(Long value) {
        this.otherRealEstateValue = value;
    }

    /**
     * Gets the value of the otherRealEstateDebt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherRealEstateDebt() {
        return otherRealEstateDebt;
    }

    /**
     * Sets the value of the otherRealEstateDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherRealEstateDebt(Long value) {
        this.otherRealEstateDebt = value;
    }

    /**
     * Gets the value of the largeBusinessIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getLargeBusinessIndicator() {
        return largeBusinessIndicator;
    }

    /**
     * Sets the value of the largeBusinessIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setLargeBusinessIndicator(JAXBElement<YesNoType> value) {
        this.largeBusinessIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the liveOnFarmIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getLiveOnFarmIndicator() {
        return liveOnFarmIndicator;
    }

    /**
     * Sets the value of the liveOnFarmIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setLiveOnFarmIndicator(JAXBElement<YesNoType> value) {
        this.liveOnFarmIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the businessFarmValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessFarmValue() {
        return businessFarmValue;
    }

    /**
     * Sets the value of the businessFarmValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessFarmValue(Long value) {
        this.businessFarmValue = value;
    }

    /**
     * Gets the value of the businessFarmDebt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessFarmDebt() {
        return businessFarmDebt;
    }

    /**
     * Sets the value of the businessFarmDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessFarmDebt(Long value) {
        this.businessFarmDebt = value;
    }

}
