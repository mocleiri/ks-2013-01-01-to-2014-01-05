
package org.collegeboard.inas._2013.input;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for imOptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="imOptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IndependentBudgetDuration" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DependentBudgetDuration" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CalculateParentContributionForIndependents" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MaximumHouseholdAgeLimit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MaximumAgeInCollegeLimit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="UseImStudentProjectedYearIncome" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseImParentProjectedYearIncome" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseNewAvailableIncomeTable" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="IncludeParentFSAHealthCare" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="IncludeParentFSADependentCare" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ExcludeTuitionFeeDeduction" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseParentStateTaxAllowance" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MaximumTuitionAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentMedicalAllowancePercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentMedicalAllowancePercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="StudentEmploymentAllowancePercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="StudentEmploymentAllowanceLimit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentEmploymentAllowancePercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentEmploymentAllowanceLimit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentCalculateUSTaxesPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentCalculateUSTaxesPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="UseFmStudentLocalTaxTable" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseFmParentLocalTaxTable" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="IndependentStudentAssessmentRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AdjustIpaByCostOfLiving" type="{http://INAS.collegeboard.org/2013/Input/}adjustByCostOfLivingType" minOccurs="0"/>
 *         &lt;element name="AllowBusinessFarmLosses" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AllowOtherLosses" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AdjustedGrossIncomeUsage" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AvailableIncomeAssessmentRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UseStudentLifetimeLearningCredit" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseParentLifetimeLearningCredit" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseAnnualSavingsGoal" type="{http://INAS.collegeboard.org/2013/Input/}annualSavingsGoalType" minOccurs="0"/>
 *         &lt;element name="UseLowIncomeAssetAllowance" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AdjustEraByCostOfLiving" type="{http://INAS.collegeboard.org/2013/Input/}adjustByCostOfLivingType" minOccurs="0"/>
 *         &lt;element name="HomeProjectionParents" type="{http://INAS.collegeboard.org/2013/Input/}homeProjectionType" minOccurs="0"/>
 *         &lt;element name="HomeProjectionIndependent" type="{http://INAS.collegeboard.org/2013/Input/}homeProjectionType" minOccurs="0"/>
 *         &lt;element name="StudentCapHomeEquityFactor" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentCapHomeEquityFactor" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AssetProjectionParents" type="{http://INAS.collegeboard.org/2013/Input/}assetProjectionType" minOccurs="0"/>
 *         &lt;element name="AssetProjectionIndependent" type="{http://INAS.collegeboard.org/2013/Input/}assetProjectionType" minOccurs="0"/>
 *         &lt;element name="AssetProjectionDependents" type="{http://INAS.collegeboard.org/2013/Input/}assetProjectionType" minOccurs="0"/>
 *         &lt;element name="AdjustAssetsForIraKeogh" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AddStudentAssetsToParent" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AssetAssessmentRateDependentStudent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AssetAssessmentRateIndependentNoDependentsSingle" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AssetAssessmentRateIndependentNoDependentsMarried" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AssetAssessmentRateIndependentWithDependents" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AssetAssessmentRateParents" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentMinimumAssetContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentMinimumAssetContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FirstYearNeverAttendedStudentMinimumContribution" type="{http://INAS.collegeboard.org/2013/Input/}depIndMinContributionType" minOccurs="0"/>
 *         &lt;element name="FirstYearPreviousAttendedStudentMinimumContribution" type="{http://INAS.collegeboard.org/2013/Input/}depIndMinContributionType" minOccurs="0"/>
 *         &lt;element name="SecondYearStudentMinimumContribution" type="{http://INAS.collegeboard.org/2013/Input/}depIndMinContributionType" minOccurs="0"/>
 *         &lt;element name="ThirdYearStudentMinimumContribution" type="{http://INAS.collegeboard.org/2013/Input/}depIndMinContributionType" minOccurs="0"/>
 *         &lt;element name="FourthYearStudentMinimumContribution" type="{http://INAS.collegeboard.org/2013/Input/}depIndMinContributionType" minOccurs="0"/>
 *         &lt;element name="FifthYearStudentMinimumContribution" type="{http://INAS.collegeboard.org/2013/Input/}depIndMinContributionType" minOccurs="0"/>
 *         &lt;element name="IndependentGraduateFirstYearStudentMinimumContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="IndependentGraduateSecondYearStudentMinimumContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="IndependentGraduateThirdYearStudentMinimumContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="IndependentGraduateFourthYearStudentMinimumContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MinimumParentContributionList" type="{http://INAS.collegeboard.org/2013/Input/}ArrayOfMinimumParentContributionSetType" minOccurs="0"/>
 *         &lt;element name="ImputeStudentContributionIncreasePercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ImputeParentContributionIncreasePercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UseNonCustodialParentContribution" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MinimumStudentContributionFromIncomeCalculation" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="TwoInCollegeAdjustment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ThreeInCollegeAdjustment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FourOrMoreInCollegeAdjustment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PreventStudentImLowerThanFm" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="PreventParentImLowerThanFm" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseVolunteeredParentContribution" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MultipleChildrenCollegesAllocationPercentages" type="{http://INAS.collegeboard.org/2013/Input/}sOType" minOccurs="0"/>
 *         &lt;element name="UseBusinessFarmNetWorthList" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="BusinessFarmNetWorthList" type="{http://INAS.collegeboard.org/2013/Input/}ArrayOfBusinessFarmNetWorthEntryType" minOccurs="0"/>
 *         &lt;element name="FirstAlternativeMcpaTable" type="{http://INAS.collegeboard.org/2013/Input/}multipleChildProtectionAllocationType" minOccurs="0"/>
 *         &lt;element name="YearInCollegeToApplySecondMcpaTable" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SecondAlternativeMcpaTable" type="{http://INAS.collegeboard.org/2013/Input/}multipleChildProtectionAllocationType" minOccurs="0"/>
 *         &lt;element name="UseIncomeProtectionAllowanceTable" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="FamilySize1" type="{http://INAS.collegeboard.org/2013/Input/}incomeProtectionAllowanceTableType" minOccurs="0"/>
 *         &lt;element name="FamilySize2" type="{http://INAS.collegeboard.org/2013/Input/}incomeProtectionAllowanceTableType" minOccurs="0"/>
 *         &lt;element name="FamilySize3" type="{http://INAS.collegeboard.org/2013/Input/}incomeProtectionAllowanceTableType" minOccurs="0"/>
 *         &lt;element name="FamilySize4" type="{http://INAS.collegeboard.org/2013/Input/}incomeProtectionAllowanceTableType" minOccurs="0"/>
 *         &lt;element name="FamilySize5" type="{http://INAS.collegeboard.org/2013/Input/}incomeProtectionAllowanceTableType" minOccurs="0"/>
 *         &lt;element name="AdditionalIncomeProtectionAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AdjustedIncomeProtectionAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MonthlyAdjustmentForIndependentNonEnrollmentPeriod" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MonthlyAdjustmentForSingleStudentNonEnrollmentPeriod" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MonthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AvailableIncomeBudgetDurationAdjustment" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="LimitOtherSiblingsShareOfParentalContribution" type="{http://INAS.collegeboard.org/2013/Input/}limitOtherSiblingsShareOfParentalContributionType" minOccurs="0"/>
 *         &lt;element name="AverageBudget2YearPublic" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AverageBudget2YearPrivate" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AverageBudget4YearPublic" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AverageBudget4YearPrivate" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AverageBudgetGraduateProfessional" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AverageBudgetProprietary" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="BudgetPercentForHalfTimeAttendance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="InStateUndergraduateAverageBudget" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OutStateUndergraduateAverageBudget" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InStateGraduateAverageBudget" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OutStateGraduateAverageBudget" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ForceHousingProjection" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imOptionsType", propOrder = {
    "independentBudgetDuration",
    "dependentBudgetDuration",
    "calculateParentContributionForIndependents",
    "maximumHouseholdAgeLimit",
    "maximumAgeInCollegeLimit",
    "useImStudentProjectedYearIncome",
    "useImParentProjectedYearIncome",
    "useNewAvailableIncomeTable",
    "includeParentFSAHealthCare",
    "includeParentFSADependentCare",
    "excludeTuitionFeeDeduction",
    "useParentStateTaxAllowance",
    "maximumTuitionAllowance",
    "studentMedicalAllowancePercent",
    "parentMedicalAllowancePercent",
    "studentEmploymentAllowancePercent",
    "studentEmploymentAllowanceLimit",
    "parentEmploymentAllowancePercent",
    "parentEmploymentAllowanceLimit",
    "studentCalculateUSTaxesPaid",
    "parentCalculateUSTaxesPaid",
    "useFmStudentLocalTaxTable",
    "useFmParentLocalTaxTable",
    "independentStudentAssessmentRate",
    "adjustIpaByCostOfLiving",
    "allowBusinessFarmLosses",
    "allowOtherLosses",
    "adjustedGrossIncomeUsage",
    "availableIncomeAssessmentRate",
    "useStudentLifetimeLearningCredit",
    "useParentLifetimeLearningCredit",
    "useAnnualSavingsGoal",
    "useLowIncomeAssetAllowance",
    "adjustEraByCostOfLiving",
    "homeProjectionParents",
    "homeProjectionIndependent",
    "studentCapHomeEquityFactor",
    "parentCapHomeEquityFactor",
    "assetProjectionParents",
    "assetProjectionIndependent",
    "assetProjectionDependents",
    "adjustAssetsForIraKeogh",
    "addStudentAssetsToParent",
    "assetAssessmentRateDependentStudent",
    "assetAssessmentRateIndependentNoDependentsSingle",
    "assetAssessmentRateIndependentNoDependentsMarried",
    "assetAssessmentRateIndependentWithDependents",
    "assetAssessmentRateParents",
    "parentMinimumAssetContribution",
    "studentMinimumAssetContribution",
    "firstYearNeverAttendedStudentMinimumContribution",
    "firstYearPreviousAttendedStudentMinimumContribution",
    "secondYearStudentMinimumContribution",
    "thirdYearStudentMinimumContribution",
    "fourthYearStudentMinimumContribution",
    "fifthYearStudentMinimumContribution",
    "independentGraduateFirstYearStudentMinimumContribution",
    "independentGraduateSecondYearStudentMinimumContribution",
    "independentGraduateThirdYearStudentMinimumContribution",
    "independentGraduateFourthYearStudentMinimumContribution",
    "minimumParentContributionList",
    "imputeStudentContributionIncreasePercent",
    "imputeParentContributionIncreasePercent",
    "useNonCustodialParentContribution",
    "minimumStudentContributionFromIncomeCalculation",
    "twoInCollegeAdjustment",
    "threeInCollegeAdjustment",
    "fourOrMoreInCollegeAdjustment",
    "preventStudentImLowerThanFm",
    "preventParentImLowerThanFm",
    "useVolunteeredParentContribution",
    "multipleChildrenCollegesAllocationPercentages",
    "useBusinessFarmNetWorthList",
    "businessFarmNetWorthList",
    "firstAlternativeMcpaTable",
    "yearInCollegeToApplySecondMcpaTable",
    "secondAlternativeMcpaTable",
    "useIncomeProtectionAllowanceTable",
    "familySize1",
    "familySize2",
    "familySize3",
    "familySize4",
    "familySize5",
    "additionalIncomeProtectionAllowance",
    "adjustedIncomeProtectionAllowance",
    "monthlyAdjustmentForIndependentNonEnrollmentPeriod",
    "monthlyAdjustmentForSingleStudentNonEnrollmentPeriod",
    "monthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod",
    "availableIncomeBudgetDurationAdjustment",
    "limitOtherSiblingsShareOfParentalContribution",
    "averageBudget2YearPublic",
    "averageBudget2YearPrivate",
    "averageBudget4YearPublic",
    "averageBudget4YearPrivate",
    "averageBudgetGraduateProfessional",
    "averageBudgetProprietary",
    "budgetPercentForHalfTimeAttendance",
    "inStateUndergraduateAverageBudget",
    "outStateUndergraduateAverageBudget",
    "inStateGraduateAverageBudget",
    "outStateGraduateAverageBudget",
    "forceHousingProjection"
})
public class ImOptionsType {

    @XmlElementRef(name = "IndependentBudgetDuration", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> independentBudgetDuration;
    @XmlElementRef(name = "DependentBudgetDuration", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> dependentBudgetDuration;
    @XmlElementRef(name = "CalculateParentContributionForIndependents", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> calculateParentContributionForIndependents;
    @XmlElement(name = "MaximumHouseholdAgeLimit", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maximumHouseholdAgeLimit;
    @XmlElement(name = "MaximumAgeInCollegeLimit", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maximumAgeInCollegeLimit;
    @XmlElementRef(name = "UseImStudentProjectedYearIncome", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useImStudentProjectedYearIncome;
    @XmlElementRef(name = "UseImParentProjectedYearIncome", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useImParentProjectedYearIncome;
    @XmlElementRef(name = "UseNewAvailableIncomeTable", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useNewAvailableIncomeTable;
    @XmlElementRef(name = "IncludeParentFSAHealthCare", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> includeParentFSAHealthCare;
    @XmlElementRef(name = "IncludeParentFSADependentCare", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> includeParentFSADependentCare;
    @XmlElementRef(name = "ExcludeTuitionFeeDeduction", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> excludeTuitionFeeDeduction;
    @XmlElementRef(name = "UseParentStateTaxAllowance", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useParentStateTaxAllowance;
    @XmlElement(name = "MaximumTuitionAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maximumTuitionAllowance;
    @XmlElementRef(name = "StudentMedicalAllowancePercent", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentMedicalAllowancePercent;
    @XmlElementRef(name = "ParentMedicalAllowancePercent", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentMedicalAllowancePercent;
    @XmlElementRef(name = "StudentEmploymentAllowancePercent", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentEmploymentAllowancePercent;
    @XmlElement(name = "StudentEmploymentAllowanceLimit", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentEmploymentAllowanceLimit;
    @XmlElementRef(name = "ParentEmploymentAllowancePercent", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentEmploymentAllowancePercent;
    @XmlElement(name = "ParentEmploymentAllowanceLimit", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentEmploymentAllowanceLimit;
    @XmlElement(name = "StudentCalculateUSTaxesPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentCalculateUSTaxesPaid;
    @XmlElement(name = "ParentCalculateUSTaxesPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentCalculateUSTaxesPaid;
    @XmlElementRef(name = "UseFmStudentLocalTaxTable", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useFmStudentLocalTaxTable;
    @XmlElementRef(name = "UseFmParentLocalTaxTable", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useFmParentLocalTaxTable;
    @XmlElementRef(name = "IndependentStudentAssessmentRate", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> independentStudentAssessmentRate;
    @XmlElementRef(name = "AdjustIpaByCostOfLiving", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<AdjustByCostOfLivingType> adjustIpaByCostOfLiving;
    @XmlElementRef(name = "AllowBusinessFarmLosses", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> allowBusinessFarmLosses;
    @XmlElementRef(name = "AllowOtherLosses", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> allowOtherLosses;
    @XmlElement(name = "AdjustedGrossIncomeUsage", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long adjustedGrossIncomeUsage;
    @XmlElementRef(name = "AvailableIncomeAssessmentRate", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> availableIncomeAssessmentRate;
    @XmlElementRef(name = "UseStudentLifetimeLearningCredit", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useStudentLifetimeLearningCredit;
    @XmlElementRef(name = "UseParentLifetimeLearningCredit", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useParentLifetimeLearningCredit;
    @XmlElementRef(name = "UseAnnualSavingsGoal", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<String> useAnnualSavingsGoal;
    @XmlElementRef(name = "UseLowIncomeAssetAllowance", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useLowIncomeAssetAllowance;
    @XmlElementRef(name = "AdjustEraByCostOfLiving", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<AdjustByCostOfLivingType> adjustEraByCostOfLiving;
    @XmlElement(name = "HomeProjectionParents")
    protected HomeProjectionType homeProjectionParents;
    @XmlElement(name = "HomeProjectionIndependent")
    protected HomeProjectionType homeProjectionIndependent;
    @XmlElementRef(name = "StudentCapHomeEquityFactor", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentCapHomeEquityFactor;
    @XmlElementRef(name = "ParentCapHomeEquityFactor", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentCapHomeEquityFactor;
    @XmlElement(name = "AssetProjectionParents")
    protected AssetProjectionType assetProjectionParents;
    @XmlElement(name = "AssetProjectionIndependent")
    protected AssetProjectionType assetProjectionIndependent;
    @XmlElement(name = "AssetProjectionDependents")
    protected AssetProjectionType assetProjectionDependents;
    @XmlElementRef(name = "AdjustAssetsForIraKeogh", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> adjustAssetsForIraKeogh;
    @XmlElement(name = "AddStudentAssetsToParent", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long addStudentAssetsToParent;
    @XmlElementRef(name = "AssetAssessmentRateDependentStudent", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> assetAssessmentRateDependentStudent;
    @XmlElementRef(name = "AssetAssessmentRateIndependentNoDependentsSingle", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> assetAssessmentRateIndependentNoDependentsSingle;
    @XmlElementRef(name = "AssetAssessmentRateIndependentNoDependentsMarried", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> assetAssessmentRateIndependentNoDependentsMarried;
    @XmlElementRef(name = "AssetAssessmentRateIndependentWithDependents", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> assetAssessmentRateIndependentWithDependents;
    @XmlElementRef(name = "AssetAssessmentRateParents", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> assetAssessmentRateParents;
    @XmlElement(name = "ParentMinimumAssetContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentMinimumAssetContribution;
    @XmlElement(name = "StudentMinimumAssetContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentMinimumAssetContribution;
    @XmlElement(name = "FirstYearNeverAttendedStudentMinimumContribution")
    protected DepIndMinContributionType firstYearNeverAttendedStudentMinimumContribution;
    @XmlElement(name = "FirstYearPreviousAttendedStudentMinimumContribution")
    protected DepIndMinContributionType firstYearPreviousAttendedStudentMinimumContribution;
    @XmlElement(name = "SecondYearStudentMinimumContribution")
    protected DepIndMinContributionType secondYearStudentMinimumContribution;
    @XmlElement(name = "ThirdYearStudentMinimumContribution")
    protected DepIndMinContributionType thirdYearStudentMinimumContribution;
    @XmlElement(name = "FourthYearStudentMinimumContribution")
    protected DepIndMinContributionType fourthYearStudentMinimumContribution;
    @XmlElement(name = "FifthYearStudentMinimumContribution")
    protected DepIndMinContributionType fifthYearStudentMinimumContribution;
    @XmlElement(name = "IndependentGraduateFirstYearStudentMinimumContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long independentGraduateFirstYearStudentMinimumContribution;
    @XmlElement(name = "IndependentGraduateSecondYearStudentMinimumContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long independentGraduateSecondYearStudentMinimumContribution;
    @XmlElement(name = "IndependentGraduateThirdYearStudentMinimumContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long independentGraduateThirdYearStudentMinimumContribution;
    @XmlElement(name = "IndependentGraduateFourthYearStudentMinimumContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long independentGraduateFourthYearStudentMinimumContribution;
    @XmlElement(name = "MinimumParentContributionList")
    protected ArrayOfMinimumParentContributionSetType minimumParentContributionList;
    @XmlElementRef(name = "ImputeStudentContributionIncreasePercent", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> imputeStudentContributionIncreasePercent;
    @XmlElementRef(name = "ImputeParentContributionIncreasePercent", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> imputeParentContributionIncreasePercent;
    @XmlElementRef(name = "UseNonCustodialParentContribution", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useNonCustodialParentContribution;
    @XmlElementRef(name = "MinimumStudentContributionFromIncomeCalculation", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> minimumStudentContributionFromIncomeCalculation;
    @XmlElementRef(name = "TwoInCollegeAdjustment", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> twoInCollegeAdjustment;
    @XmlElementRef(name = "ThreeInCollegeAdjustment", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> threeInCollegeAdjustment;
    @XmlElementRef(name = "FourOrMoreInCollegeAdjustment", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> fourOrMoreInCollegeAdjustment;
    @XmlElementRef(name = "PreventStudentImLowerThanFm", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> preventStudentImLowerThanFm;
    @XmlElementRef(name = "PreventParentImLowerThanFm", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> preventParentImLowerThanFm;
    @XmlElementRef(name = "UseVolunteeredParentContribution", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useVolunteeredParentContribution;
    @XmlElementRef(name = "MultipleChildrenCollegesAllocationPercentages", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<SOType> multipleChildrenCollegesAllocationPercentages;
    @XmlElementRef(name = "UseBusinessFarmNetWorthList", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useBusinessFarmNetWorthList;
    @XmlElement(name = "BusinessFarmNetWorthList")
    protected ArrayOfBusinessFarmNetWorthEntryType businessFarmNetWorthList;
    @XmlElement(name = "FirstAlternativeMcpaTable")
    protected MultipleChildProtectionAllocationType firstAlternativeMcpaTable;
    @XmlElement(name = "YearInCollegeToApplySecondMcpaTable", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long yearInCollegeToApplySecondMcpaTable;
    @XmlElement(name = "SecondAlternativeMcpaTable")
    protected MultipleChildProtectionAllocationType secondAlternativeMcpaTable;
    @XmlElementRef(name = "UseIncomeProtectionAllowanceTable", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useIncomeProtectionAllowanceTable;
    @XmlElement(name = "FamilySize1")
    protected IncomeProtectionAllowanceTableType familySize1;
    @XmlElement(name = "FamilySize2")
    protected IncomeProtectionAllowanceTableType familySize2;
    @XmlElement(name = "FamilySize3")
    protected IncomeProtectionAllowanceTableType familySize3;
    @XmlElement(name = "FamilySize4")
    protected IncomeProtectionAllowanceTableType familySize4;
    @XmlElement(name = "FamilySize5")
    protected IncomeProtectionAllowanceTableType familySize5;
    @XmlElement(name = "AdditionalIncomeProtectionAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long additionalIncomeProtectionAllowance;
    @XmlElement(name = "AdjustedIncomeProtectionAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long adjustedIncomeProtectionAllowance;
    @XmlElement(name = "MonthlyAdjustmentForIndependentNonEnrollmentPeriod", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long monthlyAdjustmentForIndependentNonEnrollmentPeriod;
    @XmlElement(name = "MonthlyAdjustmentForSingleStudentNonEnrollmentPeriod", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long monthlyAdjustmentForSingleStudentNonEnrollmentPeriod;
    @XmlElement(name = "MonthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long monthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod;
    @XmlElement(name = "AvailableIncomeBudgetDurationAdjustment", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long availableIncomeBudgetDurationAdjustment;
    @XmlElementRef(name = "LimitOtherSiblingsShareOfParentalContribution", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<String> limitOtherSiblingsShareOfParentalContribution;
    @XmlElement(name = "AverageBudget2YearPublic", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long averageBudget2YearPublic;
    @XmlElement(name = "AverageBudget2YearPrivate", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long averageBudget2YearPrivate;
    @XmlElement(name = "AverageBudget4YearPublic", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long averageBudget4YearPublic;
    @XmlElement(name = "AverageBudget4YearPrivate", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long averageBudget4YearPrivate;
    @XmlElement(name = "AverageBudgetGraduateProfessional", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long averageBudgetGraduateProfessional;
    @XmlElement(name = "AverageBudgetProprietary", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long averageBudgetProprietary;
    @XmlElementRef(name = "BudgetPercentForHalfTimeAttendance", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> budgetPercentForHalfTimeAttendance;
    @XmlElement(name = "InStateUndergraduateAverageBudget", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long inStateUndergraduateAverageBudget;
    @XmlElement(name = "OutStateUndergraduateAverageBudget", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long outStateUndergraduateAverageBudget;
    @XmlElement(name = "InStateGraduateAverageBudget", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long inStateGraduateAverageBudget;
    @XmlElement(name = "OutStateGraduateAverageBudget", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long outStateGraduateAverageBudget;
    @XmlElementRef(name = "ForceHousingProjection", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> forceHousingProjection;

    /**
     * Gets the value of the independentBudgetDuration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getIndependentBudgetDuration() {
        return independentBudgetDuration;
    }

    /**
     * Sets the value of the independentBudgetDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setIndependentBudgetDuration(JAXBElement<BigDecimal> value) {
        this.independentBudgetDuration = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the dependentBudgetDuration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDependentBudgetDuration() {
        return dependentBudgetDuration;
    }

    /**
     * Sets the value of the dependentBudgetDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDependentBudgetDuration(JAXBElement<BigDecimal> value) {
        this.dependentBudgetDuration = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the calculateParentContributionForIndependents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCalculateParentContributionForIndependents() {
        return calculateParentContributionForIndependents;
    }

    /**
     * Sets the value of the calculateParentContributionForIndependents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCalculateParentContributionForIndependents(JAXBElement<YesNoType> value) {
        this.calculateParentContributionForIndependents = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the maximumHouseholdAgeLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaximumHouseholdAgeLimit() {
        return maximumHouseholdAgeLimit;
    }

    /**
     * Sets the value of the maximumHouseholdAgeLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaximumHouseholdAgeLimit(Long value) {
        this.maximumHouseholdAgeLimit = value;
    }

    /**
     * Gets the value of the maximumAgeInCollegeLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaximumAgeInCollegeLimit() {
        return maximumAgeInCollegeLimit;
    }

    /**
     * Sets the value of the maximumAgeInCollegeLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaximumAgeInCollegeLimit(Long value) {
        this.maximumAgeInCollegeLimit = value;
    }

    /**
     * Gets the value of the useImStudentProjectedYearIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseImStudentProjectedYearIncome() {
        return useImStudentProjectedYearIncome;
    }

    /**
     * Sets the value of the useImStudentProjectedYearIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseImStudentProjectedYearIncome(JAXBElement<YesNoType> value) {
        this.useImStudentProjectedYearIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useImParentProjectedYearIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseImParentProjectedYearIncome() {
        return useImParentProjectedYearIncome;
    }

    /**
     * Sets the value of the useImParentProjectedYearIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseImParentProjectedYearIncome(JAXBElement<YesNoType> value) {
        this.useImParentProjectedYearIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useNewAvailableIncomeTable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseNewAvailableIncomeTable() {
        return useNewAvailableIncomeTable;
    }

    /**
     * Sets the value of the useNewAvailableIncomeTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseNewAvailableIncomeTable(JAXBElement<YesNoType> value) {
        this.useNewAvailableIncomeTable = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the includeParentFSAHealthCare property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getIncludeParentFSAHealthCare() {
        return includeParentFSAHealthCare;
    }

    /**
     * Sets the value of the includeParentFSAHealthCare property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setIncludeParentFSAHealthCare(JAXBElement<YesNoType> value) {
        this.includeParentFSAHealthCare = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the includeParentFSADependentCare property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getIncludeParentFSADependentCare() {
        return includeParentFSADependentCare;
    }

    /**
     * Sets the value of the includeParentFSADependentCare property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setIncludeParentFSADependentCare(JAXBElement<YesNoType> value) {
        this.includeParentFSADependentCare = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the excludeTuitionFeeDeduction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getExcludeTuitionFeeDeduction() {
        return excludeTuitionFeeDeduction;
    }

    /**
     * Sets the value of the excludeTuitionFeeDeduction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setExcludeTuitionFeeDeduction(JAXBElement<YesNoType> value) {
        this.excludeTuitionFeeDeduction = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useParentStateTaxAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseParentStateTaxAllowance() {
        return useParentStateTaxAllowance;
    }

    /**
     * Sets the value of the useParentStateTaxAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseParentStateTaxAllowance(JAXBElement<YesNoType> value) {
        this.useParentStateTaxAllowance = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the maximumTuitionAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaximumTuitionAllowance() {
        return maximumTuitionAllowance;
    }

    /**
     * Sets the value of the maximumTuitionAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaximumTuitionAllowance(Long value) {
        this.maximumTuitionAllowance = value;
    }

    /**
     * Gets the value of the studentMedicalAllowancePercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentMedicalAllowancePercent() {
        return studentMedicalAllowancePercent;
    }

    /**
     * Sets the value of the studentMedicalAllowancePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentMedicalAllowancePercent(JAXBElement<BigDecimal> value) {
        this.studentMedicalAllowancePercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentMedicalAllowancePercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentMedicalAllowancePercent() {
        return parentMedicalAllowancePercent;
    }

    /**
     * Sets the value of the parentMedicalAllowancePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentMedicalAllowancePercent(JAXBElement<BigDecimal> value) {
        this.parentMedicalAllowancePercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the studentEmploymentAllowancePercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentEmploymentAllowancePercent() {
        return studentEmploymentAllowancePercent;
    }

    /**
     * Sets the value of the studentEmploymentAllowancePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentEmploymentAllowancePercent(JAXBElement<BigDecimal> value) {
        this.studentEmploymentAllowancePercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the studentEmploymentAllowanceLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentEmploymentAllowanceLimit() {
        return studentEmploymentAllowanceLimit;
    }

    /**
     * Sets the value of the studentEmploymentAllowanceLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentEmploymentAllowanceLimit(Long value) {
        this.studentEmploymentAllowanceLimit = value;
    }

    /**
     * Gets the value of the parentEmploymentAllowancePercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentEmploymentAllowancePercent() {
        return parentEmploymentAllowancePercent;
    }

    /**
     * Sets the value of the parentEmploymentAllowancePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentEmploymentAllowancePercent(JAXBElement<BigDecimal> value) {
        this.parentEmploymentAllowancePercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentEmploymentAllowanceLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentEmploymentAllowanceLimit() {
        return parentEmploymentAllowanceLimit;
    }

    /**
     * Sets the value of the parentEmploymentAllowanceLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentEmploymentAllowanceLimit(Long value) {
        this.parentEmploymentAllowanceLimit = value;
    }

    /**
     * Gets the value of the studentCalculateUSTaxesPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentCalculateUSTaxesPaid() {
        return studentCalculateUSTaxesPaid;
    }

    /**
     * Sets the value of the studentCalculateUSTaxesPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentCalculateUSTaxesPaid(Long value) {
        this.studentCalculateUSTaxesPaid = value;
    }

    /**
     * Gets the value of the parentCalculateUSTaxesPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentCalculateUSTaxesPaid() {
        return parentCalculateUSTaxesPaid;
    }

    /**
     * Sets the value of the parentCalculateUSTaxesPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentCalculateUSTaxesPaid(Long value) {
        this.parentCalculateUSTaxesPaid = value;
    }

    /**
     * Gets the value of the useFmStudentLocalTaxTable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseFmStudentLocalTaxTable() {
        return useFmStudentLocalTaxTable;
    }

    /**
     * Sets the value of the useFmStudentLocalTaxTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseFmStudentLocalTaxTable(JAXBElement<YesNoType> value) {
        this.useFmStudentLocalTaxTable = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useFmParentLocalTaxTable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseFmParentLocalTaxTable() {
        return useFmParentLocalTaxTable;
    }

    /**
     * Sets the value of the useFmParentLocalTaxTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseFmParentLocalTaxTable(JAXBElement<YesNoType> value) {
        this.useFmParentLocalTaxTable = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the independentStudentAssessmentRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getIndependentStudentAssessmentRate() {
        return independentStudentAssessmentRate;
    }

    /**
     * Sets the value of the independentStudentAssessmentRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setIndependentStudentAssessmentRate(JAXBElement<BigDecimal> value) {
        this.independentStudentAssessmentRate = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the adjustIpaByCostOfLiving property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AdjustByCostOfLivingType }{@code >}
     *     
     */
    public JAXBElement<AdjustByCostOfLivingType> getAdjustIpaByCostOfLiving() {
        return adjustIpaByCostOfLiving;
    }

    /**
     * Sets the value of the adjustIpaByCostOfLiving property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AdjustByCostOfLivingType }{@code >}
     *     
     */
    public void setAdjustIpaByCostOfLiving(JAXBElement<AdjustByCostOfLivingType> value) {
        this.adjustIpaByCostOfLiving = ((JAXBElement<AdjustByCostOfLivingType> ) value);
    }

    /**
     * Gets the value of the allowBusinessFarmLosses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAllowBusinessFarmLosses() {
        return allowBusinessFarmLosses;
    }

    /**
     * Sets the value of the allowBusinessFarmLosses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAllowBusinessFarmLosses(JAXBElement<YesNoType> value) {
        this.allowBusinessFarmLosses = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the allowOtherLosses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAllowOtherLosses() {
        return allowOtherLosses;
    }

    /**
     * Sets the value of the allowOtherLosses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAllowOtherLosses(JAXBElement<YesNoType> value) {
        this.allowOtherLosses = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the adjustedGrossIncomeUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdjustedGrossIncomeUsage() {
        return adjustedGrossIncomeUsage;
    }

    /**
     * Sets the value of the adjustedGrossIncomeUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdjustedGrossIncomeUsage(Long value) {
        this.adjustedGrossIncomeUsage = value;
    }

    /**
     * Gets the value of the availableIncomeAssessmentRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAvailableIncomeAssessmentRate() {
        return availableIncomeAssessmentRate;
    }

    /**
     * Sets the value of the availableIncomeAssessmentRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAvailableIncomeAssessmentRate(JAXBElement<BigDecimal> value) {
        this.availableIncomeAssessmentRate = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the useStudentLifetimeLearningCredit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseStudentLifetimeLearningCredit() {
        return useStudentLifetimeLearningCredit;
    }

    /**
     * Sets the value of the useStudentLifetimeLearningCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseStudentLifetimeLearningCredit(JAXBElement<YesNoType> value) {
        this.useStudentLifetimeLearningCredit = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useParentLifetimeLearningCredit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseParentLifetimeLearningCredit() {
        return useParentLifetimeLearningCredit;
    }

    /**
     * Sets the value of the useParentLifetimeLearningCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseParentLifetimeLearningCredit(JAXBElement<YesNoType> value) {
        this.useParentLifetimeLearningCredit = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useAnnualSavingsGoal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUseAnnualSavingsGoal() {
        return useAnnualSavingsGoal;
    }

    /**
     * Sets the value of the useAnnualSavingsGoal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUseAnnualSavingsGoal(JAXBElement<String> value) {
        this.useAnnualSavingsGoal = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the useLowIncomeAssetAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseLowIncomeAssetAllowance() {
        return useLowIncomeAssetAllowance;
    }

    /**
     * Sets the value of the useLowIncomeAssetAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseLowIncomeAssetAllowance(JAXBElement<YesNoType> value) {
        this.useLowIncomeAssetAllowance = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the adjustEraByCostOfLiving property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AdjustByCostOfLivingType }{@code >}
     *     
     */
    public JAXBElement<AdjustByCostOfLivingType> getAdjustEraByCostOfLiving() {
        return adjustEraByCostOfLiving;
    }

    /**
     * Sets the value of the adjustEraByCostOfLiving property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AdjustByCostOfLivingType }{@code >}
     *     
     */
    public void setAdjustEraByCostOfLiving(JAXBElement<AdjustByCostOfLivingType> value) {
        this.adjustEraByCostOfLiving = ((JAXBElement<AdjustByCostOfLivingType> ) value);
    }

    /**
     * Gets the value of the homeProjectionParents property.
     * 
     * @return
     *     possible object is
     *     {@link HomeProjectionType }
     *     
     */
    public HomeProjectionType getHomeProjectionParents() {
        return homeProjectionParents;
    }

    /**
     * Sets the value of the homeProjectionParents property.
     * 
     * @param value
     *     allowed object is
     *     {@link HomeProjectionType }
     *     
     */
    public void setHomeProjectionParents(HomeProjectionType value) {
        this.homeProjectionParents = value;
    }

    /**
     * Gets the value of the homeProjectionIndependent property.
     * 
     * @return
     *     possible object is
     *     {@link HomeProjectionType }
     *     
     */
    public HomeProjectionType getHomeProjectionIndependent() {
        return homeProjectionIndependent;
    }

    /**
     * Sets the value of the homeProjectionIndependent property.
     * 
     * @param value
     *     allowed object is
     *     {@link HomeProjectionType }
     *     
     */
    public void setHomeProjectionIndependent(HomeProjectionType value) {
        this.homeProjectionIndependent = value;
    }

    /**
     * Gets the value of the studentCapHomeEquityFactor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentCapHomeEquityFactor() {
        return studentCapHomeEquityFactor;
    }

    /**
     * Sets the value of the studentCapHomeEquityFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentCapHomeEquityFactor(JAXBElement<BigDecimal> value) {
        this.studentCapHomeEquityFactor = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentCapHomeEquityFactor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentCapHomeEquityFactor() {
        return parentCapHomeEquityFactor;
    }

    /**
     * Sets the value of the parentCapHomeEquityFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentCapHomeEquityFactor(JAXBElement<BigDecimal> value) {
        this.parentCapHomeEquityFactor = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the assetProjectionParents property.
     * 
     * @return
     *     possible object is
     *     {@link AssetProjectionType }
     *     
     */
    public AssetProjectionType getAssetProjectionParents() {
        return assetProjectionParents;
    }

    /**
     * Sets the value of the assetProjectionParents property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetProjectionType }
     *     
     */
    public void setAssetProjectionParents(AssetProjectionType value) {
        this.assetProjectionParents = value;
    }

    /**
     * Gets the value of the assetProjectionIndependent property.
     * 
     * @return
     *     possible object is
     *     {@link AssetProjectionType }
     *     
     */
    public AssetProjectionType getAssetProjectionIndependent() {
        return assetProjectionIndependent;
    }

    /**
     * Sets the value of the assetProjectionIndependent property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetProjectionType }
     *     
     */
    public void setAssetProjectionIndependent(AssetProjectionType value) {
        this.assetProjectionIndependent = value;
    }

    /**
     * Gets the value of the assetProjectionDependents property.
     * 
     * @return
     *     possible object is
     *     {@link AssetProjectionType }
     *     
     */
    public AssetProjectionType getAssetProjectionDependents() {
        return assetProjectionDependents;
    }

    /**
     * Sets the value of the assetProjectionDependents property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetProjectionType }
     *     
     */
    public void setAssetProjectionDependents(AssetProjectionType value) {
        this.assetProjectionDependents = value;
    }

    /**
     * Gets the value of the adjustAssetsForIraKeogh property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAdjustAssetsForIraKeogh() {
        return adjustAssetsForIraKeogh;
    }

    /**
     * Sets the value of the adjustAssetsForIraKeogh property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAdjustAssetsForIraKeogh(JAXBElement<BigDecimal> value) {
        this.adjustAssetsForIraKeogh = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the addStudentAssetsToParent property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAddStudentAssetsToParent() {
        return addStudentAssetsToParent;
    }

    /**
     * Sets the value of the addStudentAssetsToParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAddStudentAssetsToParent(Long value) {
        this.addStudentAssetsToParent = value;
    }

    /**
     * Gets the value of the assetAssessmentRateDependentStudent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAssetAssessmentRateDependentStudent() {
        return assetAssessmentRateDependentStudent;
    }

    /**
     * Sets the value of the assetAssessmentRateDependentStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAssetAssessmentRateDependentStudent(JAXBElement<BigDecimal> value) {
        this.assetAssessmentRateDependentStudent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the assetAssessmentRateIndependentNoDependentsSingle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAssetAssessmentRateIndependentNoDependentsSingle() {
        return assetAssessmentRateIndependentNoDependentsSingle;
    }

    /**
     * Sets the value of the assetAssessmentRateIndependentNoDependentsSingle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAssetAssessmentRateIndependentNoDependentsSingle(JAXBElement<BigDecimal> value) {
        this.assetAssessmentRateIndependentNoDependentsSingle = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the assetAssessmentRateIndependentNoDependentsMarried property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAssetAssessmentRateIndependentNoDependentsMarried() {
        return assetAssessmentRateIndependentNoDependentsMarried;
    }

    /**
     * Sets the value of the assetAssessmentRateIndependentNoDependentsMarried property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAssetAssessmentRateIndependentNoDependentsMarried(JAXBElement<BigDecimal> value) {
        this.assetAssessmentRateIndependentNoDependentsMarried = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the assetAssessmentRateIndependentWithDependents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAssetAssessmentRateIndependentWithDependents() {
        return assetAssessmentRateIndependentWithDependents;
    }

    /**
     * Sets the value of the assetAssessmentRateIndependentWithDependents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAssetAssessmentRateIndependentWithDependents(JAXBElement<BigDecimal> value) {
        this.assetAssessmentRateIndependentWithDependents = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the assetAssessmentRateParents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAssetAssessmentRateParents() {
        return assetAssessmentRateParents;
    }

    /**
     * Sets the value of the assetAssessmentRateParents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAssetAssessmentRateParents(JAXBElement<BigDecimal> value) {
        this.assetAssessmentRateParents = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentMinimumAssetContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentMinimumAssetContribution() {
        return parentMinimumAssetContribution;
    }

    /**
     * Sets the value of the parentMinimumAssetContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentMinimumAssetContribution(Long value) {
        this.parentMinimumAssetContribution = value;
    }

    /**
     * Gets the value of the studentMinimumAssetContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentMinimumAssetContribution() {
        return studentMinimumAssetContribution;
    }

    /**
     * Sets the value of the studentMinimumAssetContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentMinimumAssetContribution(Long value) {
        this.studentMinimumAssetContribution = value;
    }

    /**
     * Gets the value of the firstYearNeverAttendedStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public DepIndMinContributionType getFirstYearNeverAttendedStudentMinimumContribution() {
        return firstYearNeverAttendedStudentMinimumContribution;
    }

    /**
     * Sets the value of the firstYearNeverAttendedStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public void setFirstYearNeverAttendedStudentMinimumContribution(DepIndMinContributionType value) {
        this.firstYearNeverAttendedStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the firstYearPreviousAttendedStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public DepIndMinContributionType getFirstYearPreviousAttendedStudentMinimumContribution() {
        return firstYearPreviousAttendedStudentMinimumContribution;
    }

    /**
     * Sets the value of the firstYearPreviousAttendedStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public void setFirstYearPreviousAttendedStudentMinimumContribution(DepIndMinContributionType value) {
        this.firstYearPreviousAttendedStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the secondYearStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public DepIndMinContributionType getSecondYearStudentMinimumContribution() {
        return secondYearStudentMinimumContribution;
    }

    /**
     * Sets the value of the secondYearStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public void setSecondYearStudentMinimumContribution(DepIndMinContributionType value) {
        this.secondYearStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the thirdYearStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public DepIndMinContributionType getThirdYearStudentMinimumContribution() {
        return thirdYearStudentMinimumContribution;
    }

    /**
     * Sets the value of the thirdYearStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public void setThirdYearStudentMinimumContribution(DepIndMinContributionType value) {
        this.thirdYearStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the fourthYearStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public DepIndMinContributionType getFourthYearStudentMinimumContribution() {
        return fourthYearStudentMinimumContribution;
    }

    /**
     * Sets the value of the fourthYearStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public void setFourthYearStudentMinimumContribution(DepIndMinContributionType value) {
        this.fourthYearStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the fifthYearStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public DepIndMinContributionType getFifthYearStudentMinimumContribution() {
        return fifthYearStudentMinimumContribution;
    }

    /**
     * Sets the value of the fifthYearStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepIndMinContributionType }
     *     
     */
    public void setFifthYearStudentMinimumContribution(DepIndMinContributionType value) {
        this.fifthYearStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the independentGraduateFirstYearStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIndependentGraduateFirstYearStudentMinimumContribution() {
        return independentGraduateFirstYearStudentMinimumContribution;
    }

    /**
     * Sets the value of the independentGraduateFirstYearStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIndependentGraduateFirstYearStudentMinimumContribution(Long value) {
        this.independentGraduateFirstYearStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the independentGraduateSecondYearStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIndependentGraduateSecondYearStudentMinimumContribution() {
        return independentGraduateSecondYearStudentMinimumContribution;
    }

    /**
     * Sets the value of the independentGraduateSecondYearStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIndependentGraduateSecondYearStudentMinimumContribution(Long value) {
        this.independentGraduateSecondYearStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the independentGraduateThirdYearStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIndependentGraduateThirdYearStudentMinimumContribution() {
        return independentGraduateThirdYearStudentMinimumContribution;
    }

    /**
     * Sets the value of the independentGraduateThirdYearStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIndependentGraduateThirdYearStudentMinimumContribution(Long value) {
        this.independentGraduateThirdYearStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the independentGraduateFourthYearStudentMinimumContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIndependentGraduateFourthYearStudentMinimumContribution() {
        return independentGraduateFourthYearStudentMinimumContribution;
    }

    /**
     * Sets the value of the independentGraduateFourthYearStudentMinimumContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIndependentGraduateFourthYearStudentMinimumContribution(Long value) {
        this.independentGraduateFourthYearStudentMinimumContribution = value;
    }

    /**
     * Gets the value of the minimumParentContributionList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMinimumParentContributionSetType }
     *     
     */
    public ArrayOfMinimumParentContributionSetType getMinimumParentContributionList() {
        return minimumParentContributionList;
    }

    /**
     * Sets the value of the minimumParentContributionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMinimumParentContributionSetType }
     *     
     */
    public void setMinimumParentContributionList(ArrayOfMinimumParentContributionSetType value) {
        this.minimumParentContributionList = value;
    }

    /**
     * Gets the value of the imputeStudentContributionIncreasePercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getImputeStudentContributionIncreasePercent() {
        return imputeStudentContributionIncreasePercent;
    }

    /**
     * Sets the value of the imputeStudentContributionIncreasePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setImputeStudentContributionIncreasePercent(JAXBElement<BigDecimal> value) {
        this.imputeStudentContributionIncreasePercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the imputeParentContributionIncreasePercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getImputeParentContributionIncreasePercent() {
        return imputeParentContributionIncreasePercent;
    }

    /**
     * Sets the value of the imputeParentContributionIncreasePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setImputeParentContributionIncreasePercent(JAXBElement<BigDecimal> value) {
        this.imputeParentContributionIncreasePercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the useNonCustodialParentContribution property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseNonCustodialParentContribution() {
        return useNonCustodialParentContribution;
    }

    /**
     * Sets the value of the useNonCustodialParentContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseNonCustodialParentContribution(JAXBElement<YesNoType> value) {
        this.useNonCustodialParentContribution = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the minimumStudentContributionFromIncomeCalculation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMinimumStudentContributionFromIncomeCalculation() {
        return minimumStudentContributionFromIncomeCalculation;
    }

    /**
     * Sets the value of the minimumStudentContributionFromIncomeCalculation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMinimumStudentContributionFromIncomeCalculation(JAXBElement<YesNoType> value) {
        this.minimumStudentContributionFromIncomeCalculation = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the twoInCollegeAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTwoInCollegeAdjustment() {
        return twoInCollegeAdjustment;
    }

    /**
     * Sets the value of the twoInCollegeAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTwoInCollegeAdjustment(JAXBElement<BigDecimal> value) {
        this.twoInCollegeAdjustment = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the threeInCollegeAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getThreeInCollegeAdjustment() {
        return threeInCollegeAdjustment;
    }

    /**
     * Sets the value of the threeInCollegeAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setThreeInCollegeAdjustment(JAXBElement<BigDecimal> value) {
        this.threeInCollegeAdjustment = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the fourOrMoreInCollegeAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFourOrMoreInCollegeAdjustment() {
        return fourOrMoreInCollegeAdjustment;
    }

    /**
     * Sets the value of the fourOrMoreInCollegeAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFourOrMoreInCollegeAdjustment(JAXBElement<BigDecimal> value) {
        this.fourOrMoreInCollegeAdjustment = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the preventStudentImLowerThanFm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getPreventStudentImLowerThanFm() {
        return preventStudentImLowerThanFm;
    }

    /**
     * Sets the value of the preventStudentImLowerThanFm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setPreventStudentImLowerThanFm(JAXBElement<YesNoType> value) {
        this.preventStudentImLowerThanFm = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the preventParentImLowerThanFm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getPreventParentImLowerThanFm() {
        return preventParentImLowerThanFm;
    }

    /**
     * Sets the value of the preventParentImLowerThanFm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setPreventParentImLowerThanFm(JAXBElement<YesNoType> value) {
        this.preventParentImLowerThanFm = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useVolunteeredParentContribution property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseVolunteeredParentContribution() {
        return useVolunteeredParentContribution;
    }

    /**
     * Sets the value of the useVolunteeredParentContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseVolunteeredParentContribution(JAXBElement<YesNoType> value) {
        this.useVolunteeredParentContribution = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the multipleChildrenCollegesAllocationPercentages property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SOType }{@code >}
     *     
     */
    public JAXBElement<SOType> getMultipleChildrenCollegesAllocationPercentages() {
        return multipleChildrenCollegesAllocationPercentages;
    }

    /**
     * Sets the value of the multipleChildrenCollegesAllocationPercentages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SOType }{@code >}
     *     
     */
    public void setMultipleChildrenCollegesAllocationPercentages(JAXBElement<SOType> value) {
        this.multipleChildrenCollegesAllocationPercentages = ((JAXBElement<SOType> ) value);
    }

    /**
     * Gets the value of the useBusinessFarmNetWorthList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseBusinessFarmNetWorthList() {
        return useBusinessFarmNetWorthList;
    }

    /**
     * Sets the value of the useBusinessFarmNetWorthList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseBusinessFarmNetWorthList(JAXBElement<YesNoType> value) {
        this.useBusinessFarmNetWorthList = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the businessFarmNetWorthList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBusinessFarmNetWorthEntryType }
     *     
     */
    public ArrayOfBusinessFarmNetWorthEntryType getBusinessFarmNetWorthList() {
        return businessFarmNetWorthList;
    }

    /**
     * Sets the value of the businessFarmNetWorthList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBusinessFarmNetWorthEntryType }
     *     
     */
    public void setBusinessFarmNetWorthList(ArrayOfBusinessFarmNetWorthEntryType value) {
        this.businessFarmNetWorthList = value;
    }

    /**
     * Gets the value of the firstAlternativeMcpaTable property.
     * 
     * @return
     *     possible object is
     *     {@link MultipleChildProtectionAllocationType }
     *     
     */
    public MultipleChildProtectionAllocationType getFirstAlternativeMcpaTable() {
        return firstAlternativeMcpaTable;
    }

    /**
     * Sets the value of the firstAlternativeMcpaTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultipleChildProtectionAllocationType }
     *     
     */
    public void setFirstAlternativeMcpaTable(MultipleChildProtectionAllocationType value) {
        this.firstAlternativeMcpaTable = value;
    }

    /**
     * Gets the value of the yearInCollegeToApplySecondMcpaTable property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getYearInCollegeToApplySecondMcpaTable() {
        return yearInCollegeToApplySecondMcpaTable;
    }

    /**
     * Sets the value of the yearInCollegeToApplySecondMcpaTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setYearInCollegeToApplySecondMcpaTable(Long value) {
        this.yearInCollegeToApplySecondMcpaTable = value;
    }

    /**
     * Gets the value of the secondAlternativeMcpaTable property.
     * 
     * @return
     *     possible object is
     *     {@link MultipleChildProtectionAllocationType }
     *     
     */
    public MultipleChildProtectionAllocationType getSecondAlternativeMcpaTable() {
        return secondAlternativeMcpaTable;
    }

    /**
     * Sets the value of the secondAlternativeMcpaTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultipleChildProtectionAllocationType }
     *     
     */
    public void setSecondAlternativeMcpaTable(MultipleChildProtectionAllocationType value) {
        this.secondAlternativeMcpaTable = value;
    }

    /**
     * Gets the value of the useIncomeProtectionAllowanceTable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseIncomeProtectionAllowanceTable() {
        return useIncomeProtectionAllowanceTable;
    }

    /**
     * Sets the value of the useIncomeProtectionAllowanceTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseIncomeProtectionAllowanceTable(JAXBElement<YesNoType> value) {
        this.useIncomeProtectionAllowanceTable = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the familySize1 property.
     * 
     * @return
     *     possible object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public IncomeProtectionAllowanceTableType getFamilySize1() {
        return familySize1;
    }

    /**
     * Sets the value of the familySize1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public void setFamilySize1(IncomeProtectionAllowanceTableType value) {
        this.familySize1 = value;
    }

    /**
     * Gets the value of the familySize2 property.
     * 
     * @return
     *     possible object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public IncomeProtectionAllowanceTableType getFamilySize2() {
        return familySize2;
    }

    /**
     * Sets the value of the familySize2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public void setFamilySize2(IncomeProtectionAllowanceTableType value) {
        this.familySize2 = value;
    }

    /**
     * Gets the value of the familySize3 property.
     * 
     * @return
     *     possible object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public IncomeProtectionAllowanceTableType getFamilySize3() {
        return familySize3;
    }

    /**
     * Sets the value of the familySize3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public void setFamilySize3(IncomeProtectionAllowanceTableType value) {
        this.familySize3 = value;
    }

    /**
     * Gets the value of the familySize4 property.
     * 
     * @return
     *     possible object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public IncomeProtectionAllowanceTableType getFamilySize4() {
        return familySize4;
    }

    /**
     * Sets the value of the familySize4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public void setFamilySize4(IncomeProtectionAllowanceTableType value) {
        this.familySize4 = value;
    }

    /**
     * Gets the value of the familySize5 property.
     * 
     * @return
     *     possible object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public IncomeProtectionAllowanceTableType getFamilySize5() {
        return familySize5;
    }

    /**
     * Sets the value of the familySize5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncomeProtectionAllowanceTableType }
     *     
     */
    public void setFamilySize5(IncomeProtectionAllowanceTableType value) {
        this.familySize5 = value;
    }

    /**
     * Gets the value of the additionalIncomeProtectionAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdditionalIncomeProtectionAllowance() {
        return additionalIncomeProtectionAllowance;
    }

    /**
     * Sets the value of the additionalIncomeProtectionAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdditionalIncomeProtectionAllowance(Long value) {
        this.additionalIncomeProtectionAllowance = value;
    }

    /**
     * Gets the value of the adjustedIncomeProtectionAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdjustedIncomeProtectionAllowance() {
        return adjustedIncomeProtectionAllowance;
    }

    /**
     * Sets the value of the adjustedIncomeProtectionAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdjustedIncomeProtectionAllowance(Long value) {
        this.adjustedIncomeProtectionAllowance = value;
    }

    /**
     * Gets the value of the monthlyAdjustmentForIndependentNonEnrollmentPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMonthlyAdjustmentForIndependentNonEnrollmentPeriod() {
        return monthlyAdjustmentForIndependentNonEnrollmentPeriod;
    }

    /**
     * Sets the value of the monthlyAdjustmentForIndependentNonEnrollmentPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMonthlyAdjustmentForIndependentNonEnrollmentPeriod(Long value) {
        this.monthlyAdjustmentForIndependentNonEnrollmentPeriod = value;
    }

    /**
     * Gets the value of the monthlyAdjustmentForSingleStudentNonEnrollmentPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMonthlyAdjustmentForSingleStudentNonEnrollmentPeriod() {
        return monthlyAdjustmentForSingleStudentNonEnrollmentPeriod;
    }

    /**
     * Sets the value of the monthlyAdjustmentForSingleStudentNonEnrollmentPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMonthlyAdjustmentForSingleStudentNonEnrollmentPeriod(Long value) {
        this.monthlyAdjustmentForSingleStudentNonEnrollmentPeriod = value;
    }

    /**
     * Gets the value of the monthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMonthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod() {
        return monthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod;
    }

    /**
     * Sets the value of the monthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMonthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod(Long value) {
        this.monthlyAdjustmentForIndependentStudentChildNonEnrollmentPeriod = value;
    }

    /**
     * Gets the value of the availableIncomeBudgetDurationAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAvailableIncomeBudgetDurationAdjustment() {
        return availableIncomeBudgetDurationAdjustment;
    }

    /**
     * Sets the value of the availableIncomeBudgetDurationAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAvailableIncomeBudgetDurationAdjustment(Long value) {
        this.availableIncomeBudgetDurationAdjustment = value;
    }

    /**
     * Gets the value of the limitOtherSiblingsShareOfParentalContribution property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLimitOtherSiblingsShareOfParentalContribution() {
        return limitOtherSiblingsShareOfParentalContribution;
    }

    /**
     * Sets the value of the limitOtherSiblingsShareOfParentalContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLimitOtherSiblingsShareOfParentalContribution(JAXBElement<String> value) {
        this.limitOtherSiblingsShareOfParentalContribution = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the averageBudget2YearPublic property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAverageBudget2YearPublic() {
        return averageBudget2YearPublic;
    }

    /**
     * Sets the value of the averageBudget2YearPublic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAverageBudget2YearPublic(Long value) {
        this.averageBudget2YearPublic = value;
    }

    /**
     * Gets the value of the averageBudget2YearPrivate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAverageBudget2YearPrivate() {
        return averageBudget2YearPrivate;
    }

    /**
     * Sets the value of the averageBudget2YearPrivate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAverageBudget2YearPrivate(Long value) {
        this.averageBudget2YearPrivate = value;
    }

    /**
     * Gets the value of the averageBudget4YearPublic property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAverageBudget4YearPublic() {
        return averageBudget4YearPublic;
    }

    /**
     * Sets the value of the averageBudget4YearPublic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAverageBudget4YearPublic(Long value) {
        this.averageBudget4YearPublic = value;
    }

    /**
     * Gets the value of the averageBudget4YearPrivate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAverageBudget4YearPrivate() {
        return averageBudget4YearPrivate;
    }

    /**
     * Sets the value of the averageBudget4YearPrivate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAverageBudget4YearPrivate(Long value) {
        this.averageBudget4YearPrivate = value;
    }

    /**
     * Gets the value of the averageBudgetGraduateProfessional property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAverageBudgetGraduateProfessional() {
        return averageBudgetGraduateProfessional;
    }

    /**
     * Sets the value of the averageBudgetGraduateProfessional property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAverageBudgetGraduateProfessional(Long value) {
        this.averageBudgetGraduateProfessional = value;
    }

    /**
     * Gets the value of the averageBudgetProprietary property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAverageBudgetProprietary() {
        return averageBudgetProprietary;
    }

    /**
     * Sets the value of the averageBudgetProprietary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAverageBudgetProprietary(Long value) {
        this.averageBudgetProprietary = value;
    }

    /**
     * Gets the value of the budgetPercentForHalfTimeAttendance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getBudgetPercentForHalfTimeAttendance() {
        return budgetPercentForHalfTimeAttendance;
    }

    /**
     * Sets the value of the budgetPercentForHalfTimeAttendance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setBudgetPercentForHalfTimeAttendance(JAXBElement<BigDecimal> value) {
        this.budgetPercentForHalfTimeAttendance = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the inStateUndergraduateAverageBudget property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInStateUndergraduateAverageBudget() {
        return inStateUndergraduateAverageBudget;
    }

    /**
     * Sets the value of the inStateUndergraduateAverageBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInStateUndergraduateAverageBudget(Long value) {
        this.inStateUndergraduateAverageBudget = value;
    }

    /**
     * Gets the value of the outStateUndergraduateAverageBudget property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOutStateUndergraduateAverageBudget() {
        return outStateUndergraduateAverageBudget;
    }

    /**
     * Sets the value of the outStateUndergraduateAverageBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOutStateUndergraduateAverageBudget(Long value) {
        this.outStateUndergraduateAverageBudget = value;
    }

    /**
     * Gets the value of the inStateGraduateAverageBudget property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInStateGraduateAverageBudget() {
        return inStateGraduateAverageBudget;
    }

    /**
     * Sets the value of the inStateGraduateAverageBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInStateGraduateAverageBudget(Long value) {
        this.inStateGraduateAverageBudget = value;
    }

    /**
     * Gets the value of the outStateGraduateAverageBudget property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOutStateGraduateAverageBudget() {
        return outStateGraduateAverageBudget;
    }

    /**
     * Sets the value of the outStateGraduateAverageBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOutStateGraduateAverageBudget(Long value) {
        this.outStateGraduateAverageBudget = value;
    }

    /**
     * Gets the value of the forceHousingProjection property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getForceHousingProjection() {
        return forceHousingProjection;
    }

    /**
     * Sets the value of the forceHousingProjection property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setForceHousingProjection(JAXBElement<YesNoType> value) {
        this.forceHousingProjection = ((JAXBElement<YesNoType> ) value);
    }

}
