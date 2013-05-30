
package org.collegeboard.inas._2013.input;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for parentsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parentsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NaturalParentsMaritalStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentLivesWith" type="{http://INAS.collegeboard.org/2013/Input/}studentLivesWithType" minOccurs="0"/>
 *         &lt;element name="StudentReceivesSupportFrom" type="{http://INAS.collegeboard.org/2013/Input/}fatherMotherType" minOccurs="0"/>
 *         &lt;element name="MaritalStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="Parent1Type" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="Parent1BirthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Parent2Type" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="Parent2BirthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ResidencyStateProvinceCode" type="{http://INAS.collegeboard.org/2013/Input/}stateProvinceType" minOccurs="0"/>
 *         &lt;element name="CountryOfResidenceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CountryCoefficient" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DislocatedWorker" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveTANF" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveSSI" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveFoodStamps" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveFreeLunch" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveWIC" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MembersInFamily" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxReturnStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxFormTypeCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExemptionsClaimed" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="WagesSalariesTips" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InterestIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="DividendIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="BusinessFarmIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="OtherTaxableIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AdjustmentsToIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AdjustedGrossIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IncomeTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="EducationCredits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ItemizedDeductions" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FathersEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MothersEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CombatPay" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SocialSecurityBenefits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TANF" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ChildSupportReceived" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="IRAKeoghDeductions" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="UntaxedIRADistribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PensionSavingsDeductions" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TuitionFeeDeduction" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="EarnedIncomeCredit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AdditionalChildTaxCredit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="LivingAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MilitaryHousingAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxExemptInterestIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ForeignIncomeExclusion" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="IMOtherUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FamilySupportIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="UntaxedPensionDistribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="VaNonEducationalBenefits" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FSAHealthCare" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FSADependentCare" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="HealthSavingsAccount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CashSavingsChecking" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AssetsInSiblingsNames" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InvestmentValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InvestmentDebt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="HomeValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="HomeDebt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="HomePurchaseYear" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="HomePurchasePrice" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherRealEstateValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherRealEstateDebt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherRealEstatePurchaseYear" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherRealEstatePurchasePrice" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="BusinessValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="BusinessDebt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="LiveOnFarmIndicator" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="FarmValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FarmDebt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberOfEmployeesIndicator" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ChildSupportPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MedicalDentalExpenses" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PrivateTuitionPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberOfChildrenTuitionPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExpectedChildSupportPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExpectedMedicalDentalExpenses" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExpectedPrivateTuitionPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExpectedNumberOfChildrenTuitionPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PriorAdjustedGrossIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PriorIncomeTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PriorItemizedDeductions" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PriorOtherUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExpectedFathersEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExpectedMothersEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExpectedOtherTaxableIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ExpectedOtherUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parentsType", propOrder = {
    "naturalParentsMaritalStatus",
    "studentLivesWith",
    "studentReceivesSupportFrom",
    "maritalStatusCode",
    "parent1Type",
    "parent1BirthDate",
    "parent2Type",
    "parent2BirthDate",
    "residencyStateProvinceCode",
    "countryOfResidenceCode",
    "countryCoefficient",
    "dislocatedWorker",
    "receiveTANF",
    "receiveSSI",
    "receiveFoodStamps",
    "receiveFreeLunch",
    "receiveWIC",
    "membersInFamily",
    "numberInCollege",
    "taxReturnStatusCode",
    "taxFormTypeCode",
    "exemptionsClaimed",
    "wagesSalariesTips",
    "interestIncome",
    "dividendIncome",
    "businessFarmIncome",
    "otherTaxableIncome",
    "adjustmentsToIncome",
    "adjustedGrossIncome",
    "incomeTaxPaid",
    "educationCredits",
    "itemizedDeductions",
    "fathersEarnedIncome",
    "mothersEarnedIncome",
    "combatPay",
    "socialSecurityBenefits",
    "tanf",
    "childSupportReceived",
    "iraKeoghDeductions",
    "untaxedIRADistribution",
    "pensionSavingsDeductions",
    "tuitionFeeDeduction",
    "earnedIncomeCredit",
    "additionalChildTaxCredit",
    "livingAllowance",
    "militaryHousingAllowance",
    "taxExemptInterestIncome",
    "foreignIncomeExclusion",
    "otherUntaxedIncome",
    "imOtherUntaxedIncome",
    "familySupportIncome",
    "untaxedPensionDistribution",
    "vaNonEducationalBenefits",
    "fsaHealthCare",
    "fsaDependentCare",
    "healthSavingsAccount",
    "cashSavingsChecking",
    "assetsInSiblingsNames",
    "investmentValue",
    "investmentDebt",
    "homeValue",
    "homeDebt",
    "homePurchaseYear",
    "homePurchasePrice",
    "otherRealEstateValue",
    "otherRealEstateDebt",
    "otherRealEstatePurchaseYear",
    "otherRealEstatePurchasePrice",
    "businessValue",
    "businessDebt",
    "liveOnFarmIndicator",
    "farmValue",
    "farmDebt",
    "numberOfEmployeesIndicator",
    "childSupportPaid",
    "medicalDentalExpenses",
    "privateTuitionPaid",
    "numberOfChildrenTuitionPaid",
    "expectedChildSupportPaid",
    "expectedMedicalDentalExpenses",
    "expectedPrivateTuitionPaid",
    "expectedNumberOfChildrenTuitionPaid",
    "priorAdjustedGrossIncome",
    "priorIncomeTaxPaid",
    "priorItemizedDeductions",
    "priorOtherUntaxedIncome",
    "expectedFathersEarnedIncome",
    "expectedMothersEarnedIncome",
    "expectedOtherTaxableIncome",
    "expectedOtherUntaxedIncome"
})
public class ParentsType {

    @XmlElement(name = "NaturalParentsMaritalStatus", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long naturalParentsMaritalStatus;
    @XmlElementRef(name = "StudentLivesWith", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<StudentLivesWithType> studentLivesWith;
    @XmlElementRef(name = "StudentReceivesSupportFrom", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<FatherMotherType> studentReceivesSupportFrom;
    @XmlElement(name = "MaritalStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maritalStatusCode;
    @XmlElement(name = "Parent1Type", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parent1Type;
    @XmlElementRef(name = "Parent1BirthDate", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> parent1BirthDate;
    @XmlElement(name = "Parent2Type", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parent2Type;
    @XmlElementRef(name = "Parent2BirthDate", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> parent2BirthDate;
    @XmlElementRef(name = "ResidencyStateProvinceCode", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<StateProvinceType> residencyStateProvinceCode;
    @XmlElement(name = "CountryOfResidenceCode", required = true, nillable = true)
    protected String countryOfResidenceCode;
    @XmlElementRef(name = "CountryCoefficient", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> countryCoefficient;
    @XmlElementRef(name = "DislocatedWorker", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> dislocatedWorker;
    @XmlElementRef(name = "ReceiveTANF", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveTANF;
    @XmlElementRef(name = "ReceiveSSI", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveSSI;
    @XmlElementRef(name = "ReceiveFoodStamps", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveFoodStamps;
    @XmlElementRef(name = "ReceiveFreeLunch", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveFreeLunch;
    @XmlElementRef(name = "ReceiveWIC", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> receiveWIC;
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
    @XmlElement(name = "WagesSalariesTips", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long wagesSalariesTips;
    @XmlElement(name = "InterestIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long interestIncome;
    @XmlElement(name = "DividendIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long dividendIncome;
    @XmlElement(name = "BusinessFarmIncome", required = true, type = Integer.class, nillable = true)
    protected Integer businessFarmIncome;
    @XmlElement(name = "OtherTaxableIncome", required = true, type = Integer.class, nillable = true)
    protected Integer otherTaxableIncome;
    @XmlElement(name = "AdjustmentsToIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long adjustmentsToIncome;
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
    @XmlElement(name = "FathersEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long fathersEarnedIncome;
    @XmlElement(name = "MothersEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long mothersEarnedIncome;
    @XmlElement(name = "CombatPay", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long combatPay;
    @XmlElement(name = "SocialSecurityBenefits", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long socialSecurityBenefits;
    @XmlElement(name = "TANF", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long tanf;
    @XmlElement(name = "ChildSupportReceived", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long childSupportReceived;
    @XmlElement(name = "IRAKeoghDeductions", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long iraKeoghDeductions;
    @XmlElement(name = "UntaxedIRADistribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long untaxedIRADistribution;
    @XmlElement(name = "PensionSavingsDeductions", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long pensionSavingsDeductions;
    @XmlElement(name = "TuitionFeeDeduction", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long tuitionFeeDeduction;
    @XmlElement(name = "EarnedIncomeCredit", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long earnedIncomeCredit;
    @XmlElement(name = "AdditionalChildTaxCredit", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long additionalChildTaxCredit;
    @XmlElement(name = "LivingAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long livingAllowance;
    @XmlElement(name = "MilitaryHousingAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long militaryHousingAllowance;
    @XmlElement(name = "TaxExemptInterestIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long taxExemptInterestIncome;
    @XmlElement(name = "ForeignIncomeExclusion", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long foreignIncomeExclusion;
    @XmlElement(name = "OtherUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherUntaxedIncome;
    @XmlElement(name = "IMOtherUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long imOtherUntaxedIncome;
    @XmlElement(name = "FamilySupportIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long familySupportIncome;
    @XmlElement(name = "UntaxedPensionDistribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long untaxedPensionDistribution;
    @XmlElement(name = "VaNonEducationalBenefits", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long vaNonEducationalBenefits;
    @XmlElement(name = "FSAHealthCare", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long fsaHealthCare;
    @XmlElement(name = "FSADependentCare", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long fsaDependentCare;
    @XmlElement(name = "HealthSavingsAccount", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long healthSavingsAccount;
    @XmlElement(name = "CashSavingsChecking", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long cashSavingsChecking;
    @XmlElement(name = "AssetsInSiblingsNames", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long assetsInSiblingsNames;
    @XmlElement(name = "InvestmentValue", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long investmentValue;
    @XmlElement(name = "InvestmentDebt", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long investmentDebt;
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
    @XmlElement(name = "OtherRealEstatePurchaseYear", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherRealEstatePurchaseYear;
    @XmlElement(name = "OtherRealEstatePurchasePrice", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherRealEstatePurchasePrice;
    @XmlElement(name = "BusinessValue", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long businessValue;
    @XmlElement(name = "BusinessDebt", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long businessDebt;
    @XmlElementRef(name = "LiveOnFarmIndicator", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> liveOnFarmIndicator;
    @XmlElement(name = "FarmValue", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long farmValue;
    @XmlElement(name = "FarmDebt", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long farmDebt;
    @XmlElementRef(name = "NumberOfEmployeesIndicator", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> numberOfEmployeesIndicator;
    @XmlElement(name = "ChildSupportPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long childSupportPaid;
    @XmlElement(name = "MedicalDentalExpenses", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long medicalDentalExpenses;
    @XmlElement(name = "PrivateTuitionPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long privateTuitionPaid;
    @XmlElement(name = "NumberOfChildrenTuitionPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long numberOfChildrenTuitionPaid;
    @XmlElement(name = "ExpectedChildSupportPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long expectedChildSupportPaid;
    @XmlElement(name = "ExpectedMedicalDentalExpenses", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long expectedMedicalDentalExpenses;
    @XmlElement(name = "ExpectedPrivateTuitionPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long expectedPrivateTuitionPaid;
    @XmlElement(name = "ExpectedNumberOfChildrenTuitionPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long expectedNumberOfChildrenTuitionPaid;
    @XmlElement(name = "PriorAdjustedGrossIncome", required = true, type = Integer.class, nillable = true)
    protected Integer priorAdjustedGrossIncome;
    @XmlElement(name = "PriorIncomeTaxPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long priorIncomeTaxPaid;
    @XmlElement(name = "PriorItemizedDeductions", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long priorItemizedDeductions;
    @XmlElement(name = "PriorOtherUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long priorOtherUntaxedIncome;
    @XmlElement(name = "ExpectedFathersEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long expectedFathersEarnedIncome;
    @XmlElement(name = "ExpectedMothersEarnedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long expectedMothersEarnedIncome;
    @XmlElement(name = "ExpectedOtherTaxableIncome", required = true, type = Integer.class, nillable = true)
    protected Integer expectedOtherTaxableIncome;
    @XmlElement(name = "ExpectedOtherUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long expectedOtherUntaxedIncome;

    /**
     * Gets the value of the naturalParentsMaritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNaturalParentsMaritalStatus() {
        return naturalParentsMaritalStatus;
    }

    /**
     * Sets the value of the naturalParentsMaritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNaturalParentsMaritalStatus(Long value) {
        this.naturalParentsMaritalStatus = value;
    }

    /**
     * Gets the value of the studentLivesWith property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StudentLivesWithType }{@code >}
     *     
     */
    public JAXBElement<StudentLivesWithType> getStudentLivesWith() {
        return studentLivesWith;
    }

    /**
     * Sets the value of the studentLivesWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StudentLivesWithType }{@code >}
     *     
     */
    public void setStudentLivesWith(JAXBElement<StudentLivesWithType> value) {
        this.studentLivesWith = ((JAXBElement<StudentLivesWithType> ) value);
    }

    /**
     * Gets the value of the studentReceivesSupportFrom property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FatherMotherType }{@code >}
     *     
     */
    public JAXBElement<FatherMotherType> getStudentReceivesSupportFrom() {
        return studentReceivesSupportFrom;
    }

    /**
     * Sets the value of the studentReceivesSupportFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FatherMotherType }{@code >}
     *     
     */
    public void setStudentReceivesSupportFrom(JAXBElement<FatherMotherType> value) {
        this.studentReceivesSupportFrom = ((JAXBElement<FatherMotherType> ) value);
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
     * Gets the value of the parent1Type property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParent1Type() {
        return parent1Type;
    }

    /**
     * Sets the value of the parent1Type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParent1Type(Long value) {
        this.parent1Type = value;
    }

    /**
     * Gets the value of the parent1BirthDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getParent1BirthDate() {
        return parent1BirthDate;
    }

    /**
     * Sets the value of the parent1BirthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setParent1BirthDate(JAXBElement<XMLGregorianCalendar> value) {
        this.parent1BirthDate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the parent2Type property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParent2Type() {
        return parent2Type;
    }

    /**
     * Sets the value of the parent2Type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParent2Type(Long value) {
        this.parent2Type = value;
    }

    /**
     * Gets the value of the parent2BirthDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getParent2BirthDate() {
        return parent2BirthDate;
    }

    /**
     * Sets the value of the parent2BirthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setParent2BirthDate(JAXBElement<XMLGregorianCalendar> value) {
        this.parent2BirthDate = ((JAXBElement<XMLGregorianCalendar> ) value);
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
     * Gets the value of the countryOfResidenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfResidenceCode() {
        return countryOfResidenceCode;
    }

    /**
     * Sets the value of the countryOfResidenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfResidenceCode(String value) {
        this.countryOfResidenceCode = value;
    }

    /**
     * Gets the value of the countryCoefficient property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCountryCoefficient() {
        return countryCoefficient;
    }

    /**
     * Sets the value of the countryCoefficient property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCountryCoefficient(JAXBElement<BigDecimal> value) {
        this.countryCoefficient = ((JAXBElement<BigDecimal> ) value);
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
     * Gets the value of the wagesSalariesTips property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWagesSalariesTips() {
        return wagesSalariesTips;
    }

    /**
     * Sets the value of the wagesSalariesTips property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWagesSalariesTips(Long value) {
        this.wagesSalariesTips = value;
    }

    /**
     * Gets the value of the interestIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterestIncome() {
        return interestIncome;
    }

    /**
     * Sets the value of the interestIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterestIncome(Long value) {
        this.interestIncome = value;
    }

    /**
     * Gets the value of the dividendIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDividendIncome() {
        return dividendIncome;
    }

    /**
     * Sets the value of the dividendIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDividendIncome(Long value) {
        this.dividendIncome = value;
    }

    /**
     * Gets the value of the businessFarmIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBusinessFarmIncome() {
        return businessFarmIncome;
    }

    /**
     * Sets the value of the businessFarmIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBusinessFarmIncome(Integer value) {
        this.businessFarmIncome = value;
    }

    /**
     * Gets the value of the otherTaxableIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOtherTaxableIncome() {
        return otherTaxableIncome;
    }

    /**
     * Sets the value of the otherTaxableIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOtherTaxableIncome(Integer value) {
        this.otherTaxableIncome = value;
    }

    /**
     * Gets the value of the adjustmentsToIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdjustmentsToIncome() {
        return adjustmentsToIncome;
    }

    /**
     * Sets the value of the adjustmentsToIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdjustmentsToIncome(Long value) {
        this.adjustmentsToIncome = value;
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
     * Gets the value of the fathersEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFathersEarnedIncome() {
        return fathersEarnedIncome;
    }

    /**
     * Sets the value of the fathersEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFathersEarnedIncome(Long value) {
        this.fathersEarnedIncome = value;
    }

    /**
     * Gets the value of the mothersEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMothersEarnedIncome() {
        return mothersEarnedIncome;
    }

    /**
     * Sets the value of the mothersEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMothersEarnedIncome(Long value) {
        this.mothersEarnedIncome = value;
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
     * Gets the value of the iraKeoghDeductions property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIRAKeoghDeductions() {
        return iraKeoghDeductions;
    }

    /**
     * Sets the value of the iraKeoghDeductions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIRAKeoghDeductions(Long value) {
        this.iraKeoghDeductions = value;
    }

    /**
     * Gets the value of the untaxedIRADistribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUntaxedIRADistribution() {
        return untaxedIRADistribution;
    }

    /**
     * Sets the value of the untaxedIRADistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUntaxedIRADistribution(Long value) {
        this.untaxedIRADistribution = value;
    }

    /**
     * Gets the value of the pensionSavingsDeductions property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPensionSavingsDeductions() {
        return pensionSavingsDeductions;
    }

    /**
     * Sets the value of the pensionSavingsDeductions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPensionSavingsDeductions(Long value) {
        this.pensionSavingsDeductions = value;
    }

    /**
     * Gets the value of the tuitionFeeDeduction property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTuitionFeeDeduction() {
        return tuitionFeeDeduction;
    }

    /**
     * Sets the value of the tuitionFeeDeduction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTuitionFeeDeduction(Long value) {
        this.tuitionFeeDeduction = value;
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
     * Gets the value of the additionalChildTaxCredit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdditionalChildTaxCredit() {
        return additionalChildTaxCredit;
    }

    /**
     * Sets the value of the additionalChildTaxCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdditionalChildTaxCredit(Long value) {
        this.additionalChildTaxCredit = value;
    }

    /**
     * Gets the value of the livingAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLivingAllowance() {
        return livingAllowance;
    }

    /**
     * Sets the value of the livingAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLivingAllowance(Long value) {
        this.livingAllowance = value;
    }

    /**
     * Gets the value of the militaryHousingAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMilitaryHousingAllowance() {
        return militaryHousingAllowance;
    }

    /**
     * Sets the value of the militaryHousingAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMilitaryHousingAllowance(Long value) {
        this.militaryHousingAllowance = value;
    }

    /**
     * Gets the value of the taxExemptInterestIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTaxExemptInterestIncome() {
        return taxExemptInterestIncome;
    }

    /**
     * Sets the value of the taxExemptInterestIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTaxExemptInterestIncome(Long value) {
        this.taxExemptInterestIncome = value;
    }

    /**
     * Gets the value of the foreignIncomeExclusion property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getForeignIncomeExclusion() {
        return foreignIncomeExclusion;
    }

    /**
     * Sets the value of the foreignIncomeExclusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setForeignIncomeExclusion(Long value) {
        this.foreignIncomeExclusion = value;
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
     * Gets the value of the imOtherUntaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIMOtherUntaxedIncome() {
        return imOtherUntaxedIncome;
    }

    /**
     * Sets the value of the imOtherUntaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIMOtherUntaxedIncome(Long value) {
        this.imOtherUntaxedIncome = value;
    }

    /**
     * Gets the value of the familySupportIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFamilySupportIncome() {
        return familySupportIncome;
    }

    /**
     * Sets the value of the familySupportIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFamilySupportIncome(Long value) {
        this.familySupportIncome = value;
    }

    /**
     * Gets the value of the untaxedPensionDistribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUntaxedPensionDistribution() {
        return untaxedPensionDistribution;
    }

    /**
     * Sets the value of the untaxedPensionDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUntaxedPensionDistribution(Long value) {
        this.untaxedPensionDistribution = value;
    }

    /**
     * Gets the value of the vaNonEducationalBenefits property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVaNonEducationalBenefits() {
        return vaNonEducationalBenefits;
    }

    /**
     * Sets the value of the vaNonEducationalBenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVaNonEducationalBenefits(Long value) {
        this.vaNonEducationalBenefits = value;
    }

    /**
     * Gets the value of the fsaHealthCare property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFSAHealthCare() {
        return fsaHealthCare;
    }

    /**
     * Sets the value of the fsaHealthCare property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFSAHealthCare(Long value) {
        this.fsaHealthCare = value;
    }

    /**
     * Gets the value of the fsaDependentCare property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFSADependentCare() {
        return fsaDependentCare;
    }

    /**
     * Sets the value of the fsaDependentCare property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFSADependentCare(Long value) {
        this.fsaDependentCare = value;
    }

    /**
     * Gets the value of the healthSavingsAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHealthSavingsAccount() {
        return healthSavingsAccount;
    }

    /**
     * Sets the value of the healthSavingsAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHealthSavingsAccount(Long value) {
        this.healthSavingsAccount = value;
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
     * Gets the value of the assetsInSiblingsNames property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssetsInSiblingsNames() {
        return assetsInSiblingsNames;
    }

    /**
     * Sets the value of the assetsInSiblingsNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssetsInSiblingsNames(Long value) {
        this.assetsInSiblingsNames = value;
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
     * Gets the value of the otherRealEstatePurchaseYear property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherRealEstatePurchaseYear() {
        return otherRealEstatePurchaseYear;
    }

    /**
     * Sets the value of the otherRealEstatePurchaseYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherRealEstatePurchaseYear(Long value) {
        this.otherRealEstatePurchaseYear = value;
    }

    /**
     * Gets the value of the otherRealEstatePurchasePrice property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherRealEstatePurchasePrice() {
        return otherRealEstatePurchasePrice;
    }

    /**
     * Sets the value of the otherRealEstatePurchasePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherRealEstatePurchasePrice(Long value) {
        this.otherRealEstatePurchasePrice = value;
    }

    /**
     * Gets the value of the businessValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessValue() {
        return businessValue;
    }

    /**
     * Sets the value of the businessValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessValue(Long value) {
        this.businessValue = value;
    }

    /**
     * Gets the value of the businessDebt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessDebt() {
        return businessDebt;
    }

    /**
     * Sets the value of the businessDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessDebt(Long value) {
        this.businessDebt = value;
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
     * Gets the value of the farmValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFarmValue() {
        return farmValue;
    }

    /**
     * Sets the value of the farmValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFarmValue(Long value) {
        this.farmValue = value;
    }

    /**
     * Gets the value of the farmDebt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFarmDebt() {
        return farmDebt;
    }

    /**
     * Sets the value of the farmDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFarmDebt(Long value) {
        this.farmDebt = value;
    }

    /**
     * Gets the value of the numberOfEmployeesIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getNumberOfEmployeesIndicator() {
        return numberOfEmployeesIndicator;
    }

    /**
     * Sets the value of the numberOfEmployeesIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setNumberOfEmployeesIndicator(JAXBElement<YesNoType> value) {
        this.numberOfEmployeesIndicator = ((JAXBElement<YesNoType> ) value);
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
     * Gets the value of the privateTuitionPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrivateTuitionPaid() {
        return privateTuitionPaid;
    }

    /**
     * Sets the value of the privateTuitionPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrivateTuitionPaid(Long value) {
        this.privateTuitionPaid = value;
    }

    /**
     * Gets the value of the numberOfChildrenTuitionPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumberOfChildrenTuitionPaid() {
        return numberOfChildrenTuitionPaid;
    }

    /**
     * Sets the value of the numberOfChildrenTuitionPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumberOfChildrenTuitionPaid(Long value) {
        this.numberOfChildrenTuitionPaid = value;
    }

    /**
     * Gets the value of the expectedChildSupportPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpectedChildSupportPaid() {
        return expectedChildSupportPaid;
    }

    /**
     * Sets the value of the expectedChildSupportPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpectedChildSupportPaid(Long value) {
        this.expectedChildSupportPaid = value;
    }

    /**
     * Gets the value of the expectedMedicalDentalExpenses property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpectedMedicalDentalExpenses() {
        return expectedMedicalDentalExpenses;
    }

    /**
     * Sets the value of the expectedMedicalDentalExpenses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpectedMedicalDentalExpenses(Long value) {
        this.expectedMedicalDentalExpenses = value;
    }

    /**
     * Gets the value of the expectedPrivateTuitionPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpectedPrivateTuitionPaid() {
        return expectedPrivateTuitionPaid;
    }

    /**
     * Sets the value of the expectedPrivateTuitionPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpectedPrivateTuitionPaid(Long value) {
        this.expectedPrivateTuitionPaid = value;
    }

    /**
     * Gets the value of the expectedNumberOfChildrenTuitionPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpectedNumberOfChildrenTuitionPaid() {
        return expectedNumberOfChildrenTuitionPaid;
    }

    /**
     * Sets the value of the expectedNumberOfChildrenTuitionPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpectedNumberOfChildrenTuitionPaid(Long value) {
        this.expectedNumberOfChildrenTuitionPaid = value;
    }

    /**
     * Gets the value of the priorAdjustedGrossIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriorAdjustedGrossIncome() {
        return priorAdjustedGrossIncome;
    }

    /**
     * Sets the value of the priorAdjustedGrossIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriorAdjustedGrossIncome(Integer value) {
        this.priorAdjustedGrossIncome = value;
    }

    /**
     * Gets the value of the priorIncomeTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriorIncomeTaxPaid() {
        return priorIncomeTaxPaid;
    }

    /**
     * Sets the value of the priorIncomeTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriorIncomeTaxPaid(Long value) {
        this.priorIncomeTaxPaid = value;
    }

    /**
     * Gets the value of the priorItemizedDeductions property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriorItemizedDeductions() {
        return priorItemizedDeductions;
    }

    /**
     * Sets the value of the priorItemizedDeductions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriorItemizedDeductions(Long value) {
        this.priorItemizedDeductions = value;
    }

    /**
     * Gets the value of the priorOtherUntaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriorOtherUntaxedIncome() {
        return priorOtherUntaxedIncome;
    }

    /**
     * Sets the value of the priorOtherUntaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriorOtherUntaxedIncome(Long value) {
        this.priorOtherUntaxedIncome = value;
    }

    /**
     * Gets the value of the expectedFathersEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpectedFathersEarnedIncome() {
        return expectedFathersEarnedIncome;
    }

    /**
     * Sets the value of the expectedFathersEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpectedFathersEarnedIncome(Long value) {
        this.expectedFathersEarnedIncome = value;
    }

    /**
     * Gets the value of the expectedMothersEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpectedMothersEarnedIncome() {
        return expectedMothersEarnedIncome;
    }

    /**
     * Sets the value of the expectedMothersEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpectedMothersEarnedIncome(Long value) {
        this.expectedMothersEarnedIncome = value;
    }

    /**
     * Gets the value of the expectedOtherTaxableIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExpectedOtherTaxableIncome() {
        return expectedOtherTaxableIncome;
    }

    /**
     * Sets the value of the expectedOtherTaxableIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExpectedOtherTaxableIncome(Integer value) {
        this.expectedOtherTaxableIncome = value;
    }

    /**
     * Gets the value of the expectedOtherUntaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpectedOtherUntaxedIncome() {
        return expectedOtherUntaxedIncome;
    }

    /**
     * Sets the value of the expectedOtherUntaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpectedOtherUntaxedIncome(Long value) {
        this.expectedOtherUntaxedIncome = value;
    }

}
