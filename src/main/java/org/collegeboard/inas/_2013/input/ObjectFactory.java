
package org.collegeboard.inas._2013.input;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.collegeboard.inas._2013.input package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AssetProjectionTypeInvestmentYield2_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "InvestmentYield2");
    private final static QName _AssetProjectionTypeCashYield1_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CashYield1");
    private final static QName _AssetProjectionTypeCashYield2_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CashYield2");
    private final static QName _AssetProjectionTypeInvestmentYield1_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "InvestmentYield1");
    private final static QName _AssetProjectionTypeOption_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Option");
    private final static QName _ImOptionsTypeMinimumStudentContributionFromIncomeCalculation_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "MinimumStudentContributionFromIncomeCalculation");
    private final static QName _ImOptionsTypeUseFmStudentLocalTaxTable_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseFmStudentLocalTaxTable");
    private final static QName _ImOptionsTypeCalculateParentContributionForIndependents_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CalculateParentContributionForIndependents");
    private final static QName _ImOptionsTypeIncludeParentFSADependentCare_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "IncludeParentFSADependentCare");
    private final static QName _ImOptionsTypeDependentBudgetDuration_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "DependentBudgetDuration");
    private final static QName _ImOptionsTypeAdjustAssetsForIraKeogh_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AdjustAssetsForIraKeogh");
    private final static QName _ImOptionsTypeUseIncomeProtectionAllowanceTable_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseIncomeProtectionAllowanceTable");
    private final static QName _ImOptionsTypeBudgetPercentForHalfTimeAttendance_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "BudgetPercentForHalfTimeAttendance");
    private final static QName _ImOptionsTypeIndependentStudentAssessmentRate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "IndependentStudentAssessmentRate");
    private final static QName _ImOptionsTypeExcludeTuitionFeeDeduction_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ExcludeTuitionFeeDeduction");
    private final static QName _ImOptionsTypePreventStudentImLowerThanFm_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "PreventStudentImLowerThanFm");
    private final static QName _ImOptionsTypeUseNewAvailableIncomeTable_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseNewAvailableIncomeTable");
    private final static QName _ImOptionsTypeImputeParentContributionIncreasePercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ImputeParentContributionIncreasePercent");
    private final static QName _ImOptionsTypeIndependentBudgetDuration_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "IndependentBudgetDuration");
    private final static QName _ImOptionsTypeParentCapHomeEquityFactor_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentCapHomeEquityFactor");
    private final static QName _ImOptionsTypeUseFmParentLocalTaxTable_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseFmParentLocalTaxTable");
    private final static QName _ImOptionsTypeForceHousingProjection_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ForceHousingProjection");
    private final static QName _ImOptionsTypeUseImParentProjectedYearIncome_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseImParentProjectedYearIncome");
    private final static QName _ImOptionsTypeAssetAssessmentRateIndependentWithDependents_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AssetAssessmentRateIndependentWithDependents");
    private final static QName _ImOptionsTypeLimitOtherSiblingsShareOfParentalContribution_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LimitOtherSiblingsShareOfParentalContribution");
    private final static QName _ImOptionsTypeParentMedicalAllowancePercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentMedicalAllowancePercent");
    private final static QName _ImOptionsTypeAdjustIpaByCostOfLiving_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AdjustIpaByCostOfLiving");
    private final static QName _ImOptionsTypeStudentEmploymentAllowancePercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentEmploymentAllowancePercent");
    private final static QName _ImOptionsTypeUseAnnualSavingsGoal_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseAnnualSavingsGoal");
    private final static QName _ImOptionsTypeUseLowIncomeAssetAllowance_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseLowIncomeAssetAllowance");
    private final static QName _ImOptionsTypeAssetAssessmentRateIndependentNoDependentsMarried_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AssetAssessmentRateIndependentNoDependentsMarried");
    private final static QName _ImOptionsTypeStudentMedicalAllowancePercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentMedicalAllowancePercent");
    private final static QName _ImOptionsTypeAllowOtherLosses_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AllowOtherLosses");
    private final static QName _ImOptionsTypeAssetAssessmentRateParents_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AssetAssessmentRateParents");
    private final static QName _ImOptionsTypeParentEmploymentAllowancePercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentEmploymentAllowancePercent");
    private final static QName _ImOptionsTypeUseParentLifetimeLearningCredit_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseParentLifetimeLearningCredit");
    private final static QName _ImOptionsTypeUseImStudentProjectedYearIncome_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseImStudentProjectedYearIncome");
    private final static QName _ImOptionsTypeAssetAssessmentRateDependentStudent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AssetAssessmentRateDependentStudent");
    private final static QName _ImOptionsTypeAssetAssessmentRateIndependentNoDependentsSingle_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AssetAssessmentRateIndependentNoDependentsSingle");
    private final static QName _ImOptionsTypeIncludeParentFSAHealthCare_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "IncludeParentFSAHealthCare");
    private final static QName _ImOptionsTypeAdjustEraByCostOfLiving_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AdjustEraByCostOfLiving");
    private final static QName _ImOptionsTypeThreeInCollegeAdjustment_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ThreeInCollegeAdjustment");
    private final static QName _ImOptionsTypeMultipleChildrenCollegesAllocationPercentages_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "MultipleChildrenCollegesAllocationPercentages");
    private final static QName _ImOptionsTypeStudentCapHomeEquityFactor_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentCapHomeEquityFactor");
    private final static QName _ImOptionsTypeAvailableIncomeAssessmentRate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AvailableIncomeAssessmentRate");
    private final static QName _ImOptionsTypeUseBusinessFarmNetWorthList_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseBusinessFarmNetWorthList");
    private final static QName _ImOptionsTypeFourOrMoreInCollegeAdjustment_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "FourOrMoreInCollegeAdjustment");
    private final static QName _ImOptionsTypeTwoInCollegeAdjustment_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "TwoInCollegeAdjustment");
    private final static QName _ImOptionsTypeUseStudentLifetimeLearningCredit_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseStudentLifetimeLearningCredit");
    private final static QName _ImOptionsTypeUseParentStateTaxAllowance_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseParentStateTaxAllowance");
    private final static QName _ImOptionsTypeUseNonCustodialParentContribution_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseNonCustodialParentContribution");
    private final static QName _ImOptionsTypeAllowBusinessFarmLosses_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AllowBusinessFarmLosses");
    private final static QName _ImOptionsTypePreventParentImLowerThanFm_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "PreventParentImLowerThanFm");
    private final static QName _ImOptionsTypeImputeStudentContributionIncreasePercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ImputeStudentContributionIncreasePercent");
    private final static QName _ImOptionsTypeUseVolunteeredParentContribution_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseVolunteeredParentContribution");
    private final static QName _FmrExtensionTypeForceStudentToIndependentStatus_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ForceStudentToIndependentStatus");
    private final static QName _FmrExtensionTypeRejectSDependentAndFathersBirthDateOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectSDependentAndFathersBirthDateOverride");
    private final static QName _FmrExtensionTypeParentNumberInCollegeOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentNumberInCollegeOverride");
    private final static QName _FmrExtensionTypeRejectFDependentAndMotherNameDateOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectFDependentAndMotherNameDateOverride");
    private final static QName _FmrExtensionTypeRejectDFirstAndLastNameMatchOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectDFirstAndLastNameMatchOverride");
    private final static QName _FmrExtensionTypeStudentCalculateUsTax_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentCalculateUsTax");
    private final static QName _FmrExtensionTypeRejectRStudentSsnMatchOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectRStudentSsnMatchOverride");
    private final static QName _FmrExtensionTypeRejectTDependentAndMotherBirthDateOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectTDependentAndMotherBirthDateOverride");
    private final static QName _FmrExtensionTypeRejectEDependentAndFathersNameOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectEDependentAndFathersNameOverride");
    private final static QName _FmrExtensionTypeParentCalculateUsTax_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentCalculateUsTax");
    private final static QName _FmrExtensionTypeCalculateParentContributionForIndependent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CalculateParentContributionForIndependent");
    private final static QName _CompareOptionsTypeCompareStudentMaritalStatus_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentMaritalStatus");
    private final static QName _CompareOptionsTypeCompareParentDislocatedWorker_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareParentDislocatedWorker");
    private final static QName _CompareOptionsTypeCompareStudentOrphanAfter13_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentOrphanAfter13");
    private final static QName _CompareOptionsTypeCompareStudentStateOfResidency_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentStateOfResidency");
    private final static QName _CompareOptionsTypeCompareParentStateOfResidency_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareParentStateOfResidency");
    private final static QName _CompareOptionsTypeCompareStudentDateOfBirth_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentDateOfBirth");
    private final static QName _CompareOptionsTypeCompareParentTaxForm_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareParentTaxForm");
    private final static QName _CompareOptionsTypeCompareStudentYearInCollege_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentYearInCollege");
    private final static QName _CompareOptionsTypeCompareOldestParentDateOfBirth_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareOldestParentDateOfBirth");
    private final static QName _CompareOptionsTypeCompareStudentDislocatedWorker_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentDislocatedWorker");
    private final static QName _CompareOptionsTypeCompareParentMaritalStatus_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareParentMaritalStatus");
    private final static QName _CompareOptionsTypeCompareStudentTaxForm_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentTaxForm");
    private final static QName _CompareOptionsTypeCompareStudentHomelessStatus_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentHomelessStatus");
    private final static QName _CompareOptionsTypeCompareStudentWardOfCourt_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentWardOfCourt");
    private final static QName _CompareOptionsTypeCompareStudentCitizenStatus_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CompareStudentCitizenStatus");
    private final static QName _ImrExtensionTypeLockStudentFederalTaxReturnStatusImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentFederalTaxReturnStatusImr");
    private final static QName _ImrExtensionTypeLockParentDislocatedWorkerIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentDislocatedWorkerIsir");
    private final static QName _ImrExtensionTypeLockParentNumberOfExemptionsIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentNumberOfExemptionsIsir");
    private final static QName _ImrExtensionTypeUseStudentProjectedYearIncome_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseStudentProjectedYearIncome");
    private final static QName _ImrExtensionTypeDefaultBudgetDuration_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "DefaultBudgetDuration");
    private final static QName _ImrExtensionTypeDependencyOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "DependencyOverride");
    private final static QName _ImrExtensionTypeParentLocalTaxPercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentLocalTaxPercent");
    private final static QName _ImrExtensionTypeLockStudentEducationCreditsIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentEducationCreditsIsir");
    private final static QName _ImrExtensionTypeLockStudentLegalDependentsIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentLegalDependentsIsir");
    private final static QName _ImrExtensionTypeStudentLocalTaxPercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentLocalTaxPercent");
    private final static QName _ImrExtensionTypeLockStudentFedTaxPaidIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentFedTaxPaidIsir");
    private final static QName _ImrExtensionTypeLockParentVaNonEducationalBenefitsImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentVaNonEducationalBenefitsImr");
    private final static QName _ImrExtensionTypeUseParentEfmProjectedYearIncome_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseParentEfmProjectedYearIncome");
    private final static QName _ImrExtensionTypeLockParentCombatPayImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentCombatPayImr");
    private final static QName _ImrExtensionTypeLockParentBusinessFarmNetWorthImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentBusinessFarmNetWorthImr");
    private final static QName _ImrExtensionTypeCanStudentImFallBelowFm_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CanStudentImFallBelowFm");
    private final static QName _ImrExtensionTypeLockStudentEducationCreditsImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentEducationCreditsImr");
    private final static QName _ImrExtensionTypeAddStudentEducationCredit_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AddStudentEducationCredit");
    private final static QName _ImrExtensionTypeImputeStudentContributionPercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ImputeStudentContributionPercent");
    private final static QName _ImrExtensionTypeStudentAssetAssessmentRate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentAssetAssessmentRate");
    private final static QName _ImrExtensionTypeLockStudentIncomeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentIncomeIsir");
    private final static QName _ImrExtensionTypeLockStudentSpouseIncomeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentSpouseIncomeImr");
    private final static QName _ImrExtensionTypeLockStudentCitizenStatusImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentCitizenStatusImr");
    private final static QName _ImrExtensionTypeLockParentPensionPaymentsIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentPensionPaymentsIsir");
    private final static QName _ImrExtensionTypeLockStudentNumberInCollegeSizeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentNumberInCollegeSizeImr");
    private final static QName _ImrExtensionTypeStudentHousingMultiplierOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentHousingMultiplierOverride");
    private final static QName _ImrExtensionTypeExcludeWorkstudyEarnings_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ExcludeWorkstudyEarnings");
    private final static QName _ImrExtensionTypeLockParentMilitaryClergyAllowancesImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentMilitaryClergyAllowancesImr");
    private final static QName _ImrExtensionTypeLockStudentTaxReturnTypeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentTaxReturnTypeImr");
    private final static QName _ImrExtensionTypeLockStudentHomelessRiskImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentHomelessRiskImr");
    private final static QName _ImrExtensionTypeLockStudentSpouseDislocatedWorkerImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentSpouseDislocatedWorkerImr");
    private final static QName _ImrExtensionTypeLockStudentYearInSchoolImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentYearInSchoolImr");
    private final static QName _ImrExtensionTypeLockMotherIncomeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockMotherIncomeIsir");
    private final static QName _ImrExtensionTypeCalculateContributionsFromAssetsUsingCountryCoefficient_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CalculateContributionsFromAssetsUsingCountryCoefficient");
    private final static QName _ImrExtensionTypeLockParentStateOfResidenceImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentStateOfResidenceImr");
    private final static QName _ImrExtensionTypeLockStudentCombatPayImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentCombatPayImr");
    private final static QName _ImrExtensionTypeLockStudentTaxableAidtIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentTaxableAidtIsir");
    private final static QName _ImrExtensionTypeLockInterestIncomeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockInterestIncomeIsir");
    private final static QName _ImrExtensionTypeLockStudentCombatPayIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentCombatPayIsir");
    private final static QName _ImrExtensionTypeLockParentEducationCreditsImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentEducationCreditsImr");
    private final static QName _ImrExtensionTypeLockStudentBusinessFarmNetWorthIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentBusinessFarmNetWorthIsir");
    private final static QName _ImrExtensionTypeLockStudentMaritalStatusIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentMaritalStatusIsir");
    private final static QName _ImrExtensionTypeLockStudentChildSupportPaidImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentChildSupportPaidImr");
    private final static QName _ImrExtensionTypeLockStudentOrphanFosterWardAfter13Isir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentOrphanFosterWardAfter13Isir");
    private final static QName _ImrExtensionTypeLockParentHouseholdSizeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentHouseholdSizeImr");
    private final static QName _ImrExtensionTypeLockStudentYearInSchoolIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentYearInSchoolIsir");
    private final static QName _ImrExtensionTypeLockStudentTaxableAidImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentTaxableAidImr");
    private final static QName _ImrExtensionTypeCapStudentHomeEquity_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CapStudentHomeEquity");
    private final static QName _ImrExtensionTypeLockStudentCashImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentCashImr");
    private final static QName _ImrExtensionTypeLockParentNumberOfExemptionsImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentNumberOfExemptionsImr");
    private final static QName _ImrExtensionTypeLockParentPensionPaymentsImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentPensionPaymentsImr");
    private final static QName _ImrExtensionTypeOperationalControl_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "OperationalControl");
    private final static QName _ImrExtensionTypeLockStudentNumberInCollegeSizeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentNumberInCollegeSizeIsir");
    private final static QName _ImrExtensionTypeLockStudentSpouseIncomeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentSpouseIncomeIsir");
    private final static QName _ImrExtensionTypeUseStudentEfmProjectedYearIncome_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseStudentEfmProjectedYearIncome");
    private final static QName _ImrExtensionTypeLockStudentAgiIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentAgiIsir");
    private final static QName _ImrExtensionTypeLockStudentDateOfBirthIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentDateOfBirthIsir");
    private final static QName _ImrExtensionTypeLockStudentFederalTaxReturnStatusIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentFederalTaxReturnStatusIsir");
    private final static QName _ImrExtensionTypeCapParentHomeEquity_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CapParentHomeEquity");
    private final static QName _ImrExtensionTypeLockStudentNumberOfExemptionsIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentNumberOfExemptionsIsir");
    private final static QName _ImrExtensionTypeLockParentTaxReturnTypeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentTaxReturnTypeIsir");
    private final static QName _ImrExtensionTypeLockParentFederalTaxReturnStatusImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentFederalTaxReturnStatusImr");
    private final static QName _ImrExtensionTypeLockParentOtherUntaxedIncomeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentOtherUntaxedIncomeIsir");
    private final static QName _ImrExtensionTypeLockStudentOrphanFosterWardAfter13Imr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentOrphanFosterWardAfter13Imr");
    private final static QName _ImrExtensionTypeLockStudentWardOfCourtIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentWardOfCourtIsir");
    private final static QName _ImrExtensionTypeLockParentCashImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentCashImr");
    private final static QName _ImrExtensionTypeLockStudentDateOfBirthImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentDateOfBirthImr");
    private final static QName _ImrExtensionTypeLockStudentTaxReturnTypeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentTaxReturnTypeIsir");
    private final static QName _ImrExtensionTypePerformStudentContributionUsingNewMethodology_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "PerformStudentContributionUsingNewMethodology");
    private final static QName _ImrExtensionTypeLockStudentInvestmentNetWorthImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentInvestmentNetWorthImr");
    private final static QName _ImrExtensionTypeStudentImputeAssets_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentImputeAssets");
    private final static QName _ImrExtensionTypeLockStudentChildSupportReceivedIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentChildSupportReceivedIsir");
    private final static QName _ImrExtensionTypeLockStudentHomelessRiskIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentHomelessRiskIsir");
    private final static QName _ImrExtensionTypeLockParentDateOfBirthImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentDateOfBirthImr");
    private final static QName _ImrExtensionTypeLockParentAgiImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentAgiImr");
    private final static QName _ImrExtensionTypeLimitSiblingShareOfParentContribution_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LimitSiblingShareOfParentContribution");
    private final static QName _ImrExtensionTypeLockStudentHouseholdSizeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentHouseholdSizeImr");
    private final static QName _ImrExtensionTypeLockStudentMaritalStatusImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentMaritalStatusImr");
    private final static QName _ImrExtensionTypeLockParentUntaxedIraDistributionIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentUntaxedIraDistributionIsir");
    private final static QName _ImrExtensionTypeLockParentChildSupportReceivedIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentChildSupportReceivedIsir");
    private final static QName _ImrExtensionTypeLockParentFedTaxPaidIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentFedTaxPaidIsir");
    private final static QName _ImrExtensionTypeReleaseIsirToImrMigration_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ReleaseIsirToImrMigration");
    private final static QName _ImrExtensionTypeStudentIraKeoghPercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentIraKeoghPercent");
    private final static QName _ImrExtensionTypeLockParentBusinessFarmNetWorthIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentBusinessFarmNetWorthIsir");
    private final static QName _ImrExtensionTypeLockParentUntaxedIraDistributionImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentUntaxedIraDistributionImr");
    private final static QName _ImrExtensionTypeLockFatherIncomeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockFatherIncomeIsir");
    private final static QName _ImrExtensionTypeParentAssetAssessmentRate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentAssetAssessmentRate");
    private final static QName _ImrExtensionTypeLockParentEducationCreditsIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentEducationCreditsIsir");
    private final static QName _ImrExtensionTypeLockParentIraPaymentsIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentIraPaymentsIsir");
    private final static QName _ImrExtensionTypeLockParentNumberInCollegeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentNumberInCollegeImr");
    private final static QName _ImrExtensionTypeLockParentIraPaymentsImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentIraPaymentsImr");
    private final static QName _ImrExtensionTypeExcludeTuitionDeduction_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ExcludeTuitionDeduction");
    private final static QName _ImrExtensionTypeLockStudentHouseholdSizeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentHouseholdSizeIsir");
    private final static QName _ImrExtensionTypeIndependentStudentIncomeAssessmentPercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "IndependentStudentIncomeAssessmentPercent");
    private final static QName _ImrExtensionTypeLockStudentSpouseDislocatedWorkerIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentSpouseDislocatedWorkerIsir");
    private final static QName _ImrExtensionTypeLockParentHouseholdSizeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentHouseholdSizeIsir");
    private final static QName _ImrExtensionTypeLockParentNumberInCollegeIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentNumberInCollegeIsir");
    private final static QName _ImrExtensionTypeLockParentMilitaryClergyAllowancesIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentMilitaryClergyAllowancesIsir");
    private final static QName _ImrExtensionTypeAddParentEducationCredit_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AddParentEducationCredit");
    private final static QName _ImrExtensionTypeLockStudentAgiImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentAgiImr");
    private final static QName _ImrExtensionTypeLockStudentFedTaxPaidImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentFedTaxPaidImr");
    private final static QName _ImrExtensionTypeLockIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockIsir");
    private final static QName _ImrExtensionTypeLockStudentVeteranStatusImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentVeteranStatusImr");
    private final static QName _ImrExtensionTypeLockParentDateOfBirthIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentDateOfBirthIsir");
    private final static QName _ImrExtensionTypeStudentCapHomeValue_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentCapHomeValue");
    private final static QName _ImrExtensionTypeLockImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockImr");
    private final static QName _ImrExtensionTypeImputeParentContributionPercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ImputeParentContributionPercent");
    private final static QName _ImrExtensionTypeParentColaIndex_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentColaIndex");
    private final static QName _ImrExtensionTypeLockStudentCashIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentCashIsir");
    private final static QName _ImrExtensionTypeLockStudentInvestmentNetWorthIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentInvestmentNetWorthIsir");
    private final static QName _ImrExtensionTypeLockParentAgiIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentAgiIsir");
    private final static QName _ImrExtensionTypeLimitInternationalParentIncomeProtectionAllowance_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LimitInternationalParentIncomeProtectionAllowance");
    private final static QName _ImrExtensionTypeLockStudentLegalDependentsImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentLegalDependentsImr");
    private final static QName _ImrExtensionTypeLockMotherIncomeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockMotherIncomeImr");
    private final static QName _ImrExtensionTypeLockStudentChildSupportPaidIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentChildSupportPaidIsir");
    private final static QName _ImrExtensionTypeLockParentCombatPayIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentCombatPayIsir");
    private final static QName _ImrExtensionTypeParentHousingMultiplierOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentHousingMultiplierOverride");
    private final static QName _ImrExtensionTypeLockParentChildSupportReceivedImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentChildSupportReceivedImr");
    private final static QName _ImrExtensionTypeLockParentStateOfResidenceIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentStateOfResidenceIsir");
    private final static QName _ImrExtensionTypeLockParentOtherUntaxedIncomeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentOtherUntaxedIncomeImr");
    private final static QName _ImrExtensionTypeLockParentVaNonEducationalBenefitsIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentVaNonEducationalBenefitsIsir");
    private final static QName _ImrExtensionTypeLockParentUntaxedPensionDistributionIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentUntaxedPensionDistributionIsir");
    private final static QName _ImrExtensionTypeUseStateTaxAllowance_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseStateTaxAllowance");
    private final static QName _ImrExtensionTypeLockParentMaritalStatusIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentMaritalStatusIsir");
    private final static QName _ImrExtensionTypeLockStudentStateOfResidenceImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentStateOfResidenceImr");
    private final static QName _ImrExtensionTypeLockInterestIncomeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockInterestIncomeImr");
    private final static QName _ImrExtensionTypeLockParentChildSupportPaidIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentChildSupportPaidIsir");
    private final static QName _ImrExtensionTypeLockStudentNumberOfExemptionsImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentNumberOfExemptionsImr");
    private final static QName _ImrExtensionTypeLockParentFedTaxPaidImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentFedTaxPaidImr");
    private final static QName _ImrExtensionTypeLockParentDislocatedWorkerImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentDislocatedWorkerImr");
    private final static QName _ImrExtensionTypeMigrationDirection_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "MigrationDirection");
    private final static QName _ImrExtensionTypeLockParentChildSupportPaidImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentChildSupportPaidImr");
    private final static QName _ImrExtensionTypeReleaseImrToIsirMigration_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ReleaseImrToIsirMigration");
    private final static QName _ImrExtensionTypeCanParentImFallBelowFm_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CanParentImFallBelowFm");
    private final static QName _ImrExtensionTypeLockStudentCitizenStatusIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentCitizenStatusIsir");
    private final static QName _ImrExtensionTypeParentCapHomeValue_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentCapHomeValue");
    private final static QName _ImrExtensionTypeParentImputeAssets_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ParentImputeAssets");
    private final static QName _ImrExtensionTypeLockStudentVeteranStatusIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentVeteranStatusIsir");
    private final static QName _ImrExtensionTypeSkipFamilyMembersOnAge_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "SkipFamilyMembersOnAge");
    private final static QName _ImrExtensionTypeLockFatherIncomeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockFatherIncomeImr");
    private final static QName _ImrExtensionTypeLockStudentIncomeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentIncomeImr");
    private final static QName _ImrExtensionTypeLockStudentStateOfResidenceIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentStateOfResidenceIsir");
    private final static QName _ImrExtensionTypeLockParentCashIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentCashIsir");
    private final static QName _ImrExtensionTypeLockParentMaritalStatusImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentMaritalStatusImr");
    private final static QName _ImrExtensionTypeLockStudentChildSupportReceivedImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentChildSupportReceivedImr");
    private final static QName _ImrExtensionTypeLockParentUntaxedPensionDistributionImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentUntaxedPensionDistributionImr");
    private final static QName _ImrExtensionTypeLockParentInvestmentNetWorthImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentInvestmentNetWorthImr");
    private final static QName _ImrExtensionTypeUseParentProjectedYearIncome_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseParentProjectedYearIncome");
    private final static QName _ImrExtensionTypeLockStudentWardOfCourtImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockStudentWardOfCourtImr");
    private final static QName _ImrExtensionTypeLockParentFederalTaxReturnStatusIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentFederalTaxReturnStatusIsir");
    private final static QName _ImrExtensionTypeLockParentInvestmentNetWorthIsir_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentInvestmentNetWorthIsir");
    private final static QName _ImrExtensionTypeLockParentTaxReturnTypeImr_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LockParentTaxReturnTypeImr");
    private final static QName _FmStudentTypeUnaccompaniedYouthBySchoolIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UnaccompaniedYouthBySchoolIndicator");
    private final static QName _FmStudentTypeEmancipatedMinorIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "EmancipatedMinorIndicator");
    private final static QName _FmStudentTypeLegalDependentsIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LegalDependentsIndicator");
    private final static QName _FmStudentTypeSsnMatchIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "SsnMatchIndicator");
    private final static QName _FmStudentTypeBirthDate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "BirthDate");
    private final static QName _FmStudentTypeZipCode_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ZipCode");
    private final static QName _FmStudentTypeResidencyStateProvinceCode_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ResidencyStateProvinceCode");
    private final static QName _FmStudentTypeInLegalGuardianshipIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "InLegalGuardianshipIndicator");
    private final static QName _FmStudentTypeBornPriorIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "BornPriorIndicator");
    private final static QName _FmStudentTypeCitizenshipSsaFlag_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CitizenshipSsaFlag");
    private final static QName _FmStudentTypeUnaccompaniedYouthByHUDIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UnaccompaniedYouthByHUDIndicator");
    private final static QName _FmStudentTypeReceiveFoodStamps_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ReceiveFoodStamps");
    private final static QName _FmStudentTypeActiveDutyIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ActiveDutyIndicator");
    private final static QName _FmStudentTypeHaveChildrenYouSupportIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "HaveChildrenYouSupportIndicator");
    private final static QName _FmStudentTypeAssetThresholdExceeded_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AssetThresholdExceeded");
    private final static QName _FmStudentTypeVeteranIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "VeteranIndicator");
    private final static QName _FmStudentTypeReceiveTANF_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ReceiveTANF");
    private final static QName _FmStudentTypeReceiveFreeLunch_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ReceiveFreeLunch");
    private final static QName _FmStudentTypeStateProvinceCode_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StateProvinceCode");
    private final static QName _FmStudentTypeOrphanWardOfCourtIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "OrphanWardOfCourtIndicator");
    private final static QName _FmStudentTypeWorkOnGraduateDegreeInd_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "WorkOnGraduateDegreeInd");
    private final static QName _FmStudentTypeMarriedIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "MarriedIndicator");
    private final static QName _FmStudentTypeDislocatedWorker_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "DislocatedWorker");
    private final static QName _FmStudentTypeAtRiskHomelessIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AtRiskHomelessIndicator");
    private final static QName _FmStudentTypeReceiveSSI_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ReceiveSSI");
    private final static QName _FmStudentTypeReceiveWIC_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ReceiveWIC");
    private final static QName _FmOptionsTypeCalculateStudentEstimatedIncomeTax_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CalculateStudentEstimatedIncomeTax");
    private final static QName _FmOptionsTypeFmCalculateParentContributionForIndependents_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "FmCalculateParentContributionForIndependents");
    private final static QName _FmOptionsTypeCalculateParentEstimatedIncomeTax_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CalculateParentEstimatedIncomeTax");
    private final static QName _BusinessFarmNetWorthEntryTypePercentToApply_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "PercentToApply");
    private final static QName _MultipleChildProtectionAllocationTypeAllocationPercent3_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AllocationPercent3");
    private final static QName _MultipleChildProtectionAllocationTypeAllocationPercent1_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AllocationPercent1");
    private final static QName _MultipleChildProtectionAllocationTypeAllocationPercent2_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AllocationPercent2");
    private final static QName _FamilyMemberTypeAttendCollegeCode_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "AttendCollegeCode");
    private final static QName _FmAssumptionsTypeAssumption6StudentAdditonalDataOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Assumption6StudentAdditonalDataOverride");
    private final static QName _FmAssumptionsTypeAssumption3StudentNumberInCollegeOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Assumption3StudentNumberInCollegeOverride");
    private final static QName _FmAssumptionsTypeAssumption2ParentAdjustedGrossIncomeOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Assumption2ParentAdjustedGrossIncomeOverride");
    private final static QName _FmAssumptionsTypeAssumption5ParentAdditionalDataOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Assumption5ParentAdditionalDataOverride");
    private final static QName _FmAssumptionsTypeAssumption4StudentAdjustedGrossIncomeOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Assumption4StudentAdjustedGrossIncomeOverride");
    private final static QName _FmAssumptionsTypeAssumption1ParentNumberInCollegeOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Assumption1ParentNumberInCollegeOverride");
    private final static QName _OperationalOptionsTypeGenerateProfileEditMessages_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "GenerateProfileEditMessages");
    private final static QName _OperationalOptionsTypeInstDefaultResidencyState_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "InstDefaultResidencyState");
    private final static QName _OperationalOptionsTypeDataToMigrate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "DataToMigrate");
    private final static QName _OperationalOptionsTypeLimitReportingBasedOnToleranceLimits_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LimitReportingBasedOnToleranceLimits");
    private final static QName _OperationalOptionsTypeActivateDataMigration_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ActivateDataMigration");
    private final static QName _OperationalOptionsTypeActivateParentImrIsirComparison_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ActivateParentImrIsirComparison");
    private final static QName _OperationalOptionsTypeActivateStudentImrIsirComparison_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ActivateStudentImrIsirComparison");
    private final static QName _ParentsTypeNumberOfEmployeesIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "NumberOfEmployeesIndicator");
    private final static QName _ParentsTypeLiveOnFarmIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LiveOnFarmIndicator");
    private final static QName _ParentsTypeParent1BirthDate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Parent1BirthDate");
    private final static QName _ParentsTypeCountryCoefficient_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CountryCoefficient");
    private final static QName _ParentsTypeParent2BirthDate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Parent2BirthDate");
    private final static QName _ParentsTypeStudentReceivesSupportFrom_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentReceivesSupportFrom");
    private final static QName _ParentsTypeStudentLivesWith_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "StudentLivesWith");
    private final static QName _EfmOptionsTypeUseParentIncomeOverrides_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseParentIncomeOverrides");
    private final static QName _EfmOptionsTypeUseStudentIncomeOverrides_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseStudentIncomeOverrides");
    private final static QName _EfmOptionsTypeUseStudentImputedAssets_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseStudentImputedAssets");
    private final static QName _EfmOptionsTypeUseParentImputedAssets_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseParentImputedAssets");
    private final static QName _EfmOptionsTypeUseProfileAssumptions_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "UseProfileAssumptions");
    private final static QName _HomeProjectionTypeCapHousingPercent_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "CapHousingPercent");
    private final static QName _FmRejectsTypeRejectKMotherSsnOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectKMotherSsnOverride");
    private final static QName _FmRejectsTypeReject21StudentCorrectedMaritalStatusDateOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Reject21StudentCorrectedMaritalStatusDateOverride");
    private final static QName _FmRejectsTypeRejectNIncompleteNameOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectNIncompleteNameOverride");
    private final static QName _FmRejectsTypeReject20NonTaxFilerOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Reject20NonTaxFilerOverride");
    private final static QName _FmRejectsTypeRejectWHighFamilyMemberOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectWHighFamilyMemberOverride");
    private final static QName _FmRejectsTypeReject12ParentTaxPaidOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Reject12ParentTaxPaidOverride");
    private final static QName _FmRejectsTypeRejectBDateOfBirthYoungOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectBDateOfBirthYoungOverride");
    private final static QName _FmRejectsTypeRejectJFatherSsnOveride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectJFatherSsnOveride");
    private final static QName _FmRejectsTypeRejectGDependentTaxPaidComplexOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectGDependentTaxPaidComplexOverride");
    private final static QName _FmRejectsTypeReject3StudentTaxPaidOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "Reject3StudentTaxPaidOverride");
    private final static QName _FmRejectsTypeRejectCParentIndepedentTaxPaidComplexOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectCParentIndepedentTaxPaidComplexOverride");
    private final static QName _FmRejectsTypeRejectADateOfBirthOldOverride_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "RejectADateOfBirthOldOverride");
    private final static QName _ParentIdentityDataTypeSSNMatchFlag_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "SSNMatchFlag");
    private final static QName _ParentIdentityDataTypeSSN_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "SSN");
    private final static QName _StudentTypeHomelessIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "HomelessIndicator");
    private final static QName _StudentTypeApplicationType_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ApplicationType");
    private final static QName _StudentTypeForeignAddressIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ForeignAddressIndicator");
    private final static QName _StudentTypeApplicationReceiptDate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ApplicationReceiptDate");
    private final static QName _StudentTypeLargeBusinessIndicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "LargeBusinessIndicator");
    private final static QName _StudentTypeOrphanFosterWardAfter13Indicator_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "OrphanFosterWardAfter13Indicator");
    private final static QName _FmOtherTypeApplicationCompleteDate_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ApplicationCompleteDate");
    private final static QName _FmOtherTypeDependencyStatus_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "DependencyStatus");
    private final static QName _FmOtherTypeApplicationSignedBy_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ApplicationSignedBy");
    private final static QName _FmOtherTypeProfessionalJudgment_QNAME = new QName("http://INAS.collegeboard.org/2013/Input/", "ProfessionalJudgment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.collegeboard.inas._2013.input
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImrType }
     * 
     */
    public ImrType createImrType() {
        return new ImrType();
    }

    /**
     * Create an instance of {@link ImOptionsType }
     * 
     */
    public ImOptionsType createImOptionsType() {
        return new ImOptionsType();
    }

    /**
     * Create an instance of {@link FmrExtensionType }
     * 
     */
    public FmrExtensionType createFmrExtensionType() {
        return new FmrExtensionType();
    }

    /**
     * Create an instance of {@link CompareOptionsType }
     * 
     */
    public CompareOptionsType createCompareOptionsType() {
        return new CompareOptionsType();
    }

    /**
     * Create an instance of {@link ImrExtensionType }
     * 
     */
    public ImrExtensionType createImrExtensionType() {
        return new ImrExtensionType();
    }

    /**
     * Create an instance of {@link FmStudentType }
     * 
     */
    public FmStudentType createFmStudentType() {
        return new FmStudentType();
    }

    /**
     * Create an instance of {@link DepIndMinContributionType }
     * 
     */
    public DepIndMinContributionType createDepIndMinContributionType() {
        return new DepIndMinContributionType();
    }

    /**
     * Create an instance of {@link MultipleChildProtectionAllocationType }
     * 
     */
    public MultipleChildProtectionAllocationType createMultipleChildProtectionAllocationType() {
        return new MultipleChildProtectionAllocationType();
    }

    /**
     * Create an instance of {@link BusinessFarmNetWorthEntryType }
     * 
     */
    public BusinessFarmNetWorthEntryType createBusinessFarmNetWorthEntryType() {
        return new BusinessFarmNetWorthEntryType();
    }

    /**
     * Create an instance of {@link OperationalOptionsType }
     * 
     */
    public OperationalOptionsType createOperationalOptionsType() {
        return new OperationalOptionsType();
    }

    /**
     * Create an instance of {@link NoncustodialParentInfoType }
     * 
     */
    public NoncustodialParentInfoType createNoncustodialParentInfoType() {
        return new NoncustodialParentInfoType();
    }

    /**
     * Create an instance of {@link ParentsType }
     * 
     */
    public ParentsType createParentsType() {
        return new ParentsType();
    }

    /**
     * Create an instance of {@link FmrDataType }
     * 
     */
    public FmrDataType createFmrDataType() {
        return new FmrDataType();
    }

    /**
     * Create an instance of {@link EfmOptionsType }
     * 
     */
    public EfmOptionsType createEfmOptionsType() {
        return new EfmOptionsType();
    }

    /**
     * Create an instance of {@link GlobalOptionsType }
     * 
     */
    public GlobalOptionsType createGlobalOptionsType() {
        return new GlobalOptionsType();
    }

    /**
     * Create an instance of {@link AssetProjectionType }
     * 
     */
    public AssetProjectionType createAssetProjectionType() {
        return new AssetProjectionType();
    }

    /**
     * Create an instance of {@link ArrayOfMinimumParentContributionSetType }
     * 
     */
    public ArrayOfMinimumParentContributionSetType createArrayOfMinimumParentContributionSetType() {
        return new ArrayOfMinimumParentContributionSetType();
    }

    /**
     * Create an instance of {@link IncomeProtectionAllowanceTableType }
     * 
     */
    public IncomeProtectionAllowanceTableType createIncomeProtectionAllowanceTableType() {
        return new IncomeProtectionAllowanceTableType();
    }

    /**
     * Create an instance of {@link FmOptionsType }
     * 
     */
    public FmOptionsType createFmOptionsType() {
        return new FmOptionsType();
    }

    /**
     * Create an instance of {@link ArrayOfBusinessFarmNetWorthEntryType }
     * 
     */
    public ArrayOfBusinessFarmNetWorthEntryType createArrayOfBusinessFarmNetWorthEntryType() {
        return new ArrayOfBusinessFarmNetWorthEntryType();
    }

    /**
     * Create an instance of {@link ImrDataType }
     * 
     */
    public ImrDataType createImrDataType() {
        return new ImrDataType();
    }

    /**
     * Create an instance of {@link NeedAnalysisInput }
     * 
     */
    public NeedAnalysisInput createNeedAnalysisInput() {
        return new NeedAnalysisInput();
    }

    /**
     * Create an instance of {@link FamilyMemberType }
     * 
     */
    public FamilyMemberType createFamilyMemberType() {
        return new FamilyMemberType();
    }

    /**
     * Create an instance of {@link FmrType }
     * 
     */
    public FmrType createFmrType() {
        return new FmrType();
    }

    /**
     * Create an instance of {@link FmAssumptionsType }
     * 
     */
    public FmAssumptionsType createFmAssumptionsType() {
        return new FmAssumptionsType();
    }

    /**
     * Create an instance of {@link AdditionalAllowanceType }
     * 
     */
    public AdditionalAllowanceType createAdditionalAllowanceType() {
        return new AdditionalAllowanceType();
    }

    /**
     * Create an instance of {@link StudentInputDataType }
     * 
     */
    public StudentInputDataType createStudentInputDataType() {
        return new StudentInputDataType();
    }

    /**
     * Create an instance of {@link MinimumParentContributionSetType }
     * 
     */
    public MinimumParentContributionSetType createMinimumParentContributionSetType() {
        return new MinimumParentContributionSetType();
    }

    /**
     * Create an instance of {@link HomeProjectionType }
     * 
     */
    public HomeProjectionType createHomeProjectionType() {
        return new HomeProjectionType();
    }

    /**
     * Create an instance of {@link FmRejectsType }
     * 
     */
    public FmRejectsType createFmRejectsType() {
        return new FmRejectsType();
    }

    /**
     * Create an instance of {@link ArrayOfFamilyMemberType }
     * 
     */
    public ArrayOfFamilyMemberType createArrayOfFamilyMemberType() {
        return new ArrayOfFamilyMemberType();
    }

    /**
     * Create an instance of {@link ParentIdentityDataType }
     * 
     */
    public ParentIdentityDataType createParentIdentityDataType() {
        return new ParentIdentityDataType();
    }

    /**
     * Create an instance of {@link StudentType }
     * 
     */
    public StudentType createStudentType() {
        return new StudentType();
    }

    /**
     * Create an instance of {@link NeedsAnalysisRecordType }
     * 
     */
    public NeedsAnalysisRecordType createNeedsAnalysisRecordType() {
        return new NeedsAnalysisRecordType();
    }

    /**
     * Create an instance of {@link FmParentsType }
     * 
     */
    public FmParentsType createFmParentsType() {
        return new FmParentsType();
    }

    /**
     * Create an instance of {@link FmOtherType }
     * 
     */
    public FmOtherType createFmOtherType() {
        return new FmOtherType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "InvestmentYield2", scope = AssetProjectionType.class)
    public JAXBElement<BigDecimal> createAssetProjectionTypeInvestmentYield2(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AssetProjectionTypeInvestmentYield2_QNAME, BigDecimal.class, AssetProjectionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CashYield1", scope = AssetProjectionType.class)
    public JAXBElement<BigDecimal> createAssetProjectionTypeCashYield1(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AssetProjectionTypeCashYield1_QNAME, BigDecimal.class, AssetProjectionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CashYield2", scope = AssetProjectionType.class)
    public JAXBElement<BigDecimal> createAssetProjectionTypeCashYield2(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AssetProjectionTypeCashYield2_QNAME, BigDecimal.class, AssetProjectionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "InvestmentYield1", scope = AssetProjectionType.class)
    public JAXBElement<BigDecimal> createAssetProjectionTypeInvestmentYield1(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AssetProjectionTypeInvestmentYield1_QNAME, BigDecimal.class, AssetProjectionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssetProjectionOptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Option", scope = AssetProjectionType.class)
    public JAXBElement<AssetProjectionOptionType> createAssetProjectionTypeOption(AssetProjectionOptionType value) {
        return new JAXBElement<AssetProjectionOptionType>(_AssetProjectionTypeOption_QNAME, AssetProjectionOptionType.class, AssetProjectionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "MinimumStudentContributionFromIncomeCalculation", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeMinimumStudentContributionFromIncomeCalculation(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeMinimumStudentContributionFromIncomeCalculation_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseFmStudentLocalTaxTable", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseFmStudentLocalTaxTable(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseFmStudentLocalTaxTable_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CalculateParentContributionForIndependents", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeCalculateParentContributionForIndependents(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeCalculateParentContributionForIndependents_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "IncludeParentFSADependentCare", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeIncludeParentFSADependentCare(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeIncludeParentFSADependentCare_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "DependentBudgetDuration", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeDependentBudgetDuration(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeDependentBudgetDuration_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AdjustAssetsForIraKeogh", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeAdjustAssetsForIraKeogh(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeAdjustAssetsForIraKeogh_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseIncomeProtectionAllowanceTable", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseIncomeProtectionAllowanceTable(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseIncomeProtectionAllowanceTable_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "BudgetPercentForHalfTimeAttendance", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeBudgetPercentForHalfTimeAttendance(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeBudgetPercentForHalfTimeAttendance_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "IndependentStudentAssessmentRate", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeIndependentStudentAssessmentRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeIndependentStudentAssessmentRate_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ExcludeTuitionFeeDeduction", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeExcludeTuitionFeeDeduction(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeExcludeTuitionFeeDeduction_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "PreventStudentImLowerThanFm", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypePreventStudentImLowerThanFm(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypePreventStudentImLowerThanFm_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseNewAvailableIncomeTable", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseNewAvailableIncomeTable(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseNewAvailableIncomeTable_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ImputeParentContributionIncreasePercent", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeImputeParentContributionIncreasePercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeImputeParentContributionIncreasePercent_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "IndependentBudgetDuration", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeIndependentBudgetDuration(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeIndependentBudgetDuration_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentCapHomeEquityFactor", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeParentCapHomeEquityFactor(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeParentCapHomeEquityFactor_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseFmParentLocalTaxTable", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseFmParentLocalTaxTable(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseFmParentLocalTaxTable_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ForceHousingProjection", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeForceHousingProjection(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeForceHousingProjection_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseImParentProjectedYearIncome", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseImParentProjectedYearIncome(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseImParentProjectedYearIncome_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AssetAssessmentRateIndependentWithDependents", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeAssetAssessmentRateIndependentWithDependents(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeAssetAssessmentRateIndependentWithDependents_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LimitOtherSiblingsShareOfParentalContribution", scope = ImOptionsType.class)
    public JAXBElement<String> createImOptionsTypeLimitOtherSiblingsShareOfParentalContribution(String value) {
        return new JAXBElement<String>(_ImOptionsTypeLimitOtherSiblingsShareOfParentalContribution_QNAME, String.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentMedicalAllowancePercent", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeParentMedicalAllowancePercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeParentMedicalAllowancePercent_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdjustByCostOfLivingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AdjustIpaByCostOfLiving", scope = ImOptionsType.class)
    public JAXBElement<AdjustByCostOfLivingType> createImOptionsTypeAdjustIpaByCostOfLiving(AdjustByCostOfLivingType value) {
        return new JAXBElement<AdjustByCostOfLivingType>(_ImOptionsTypeAdjustIpaByCostOfLiving_QNAME, AdjustByCostOfLivingType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentEmploymentAllowancePercent", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeStudentEmploymentAllowancePercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeStudentEmploymentAllowancePercent_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseAnnualSavingsGoal", scope = ImOptionsType.class)
    public JAXBElement<String> createImOptionsTypeUseAnnualSavingsGoal(String value) {
        return new JAXBElement<String>(_ImOptionsTypeUseAnnualSavingsGoal_QNAME, String.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseLowIncomeAssetAllowance", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseLowIncomeAssetAllowance(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseLowIncomeAssetAllowance_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AssetAssessmentRateIndependentNoDependentsMarried", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeAssetAssessmentRateIndependentNoDependentsMarried(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeAssetAssessmentRateIndependentNoDependentsMarried_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentMedicalAllowancePercent", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeStudentMedicalAllowancePercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeStudentMedicalAllowancePercent_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AllowOtherLosses", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeAllowOtherLosses(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeAllowOtherLosses_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AssetAssessmentRateParents", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeAssetAssessmentRateParents(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeAssetAssessmentRateParents_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentEmploymentAllowancePercent", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeParentEmploymentAllowancePercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeParentEmploymentAllowancePercent_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseParentLifetimeLearningCredit", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseParentLifetimeLearningCredit(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseParentLifetimeLearningCredit_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseImStudentProjectedYearIncome", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseImStudentProjectedYearIncome(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseImStudentProjectedYearIncome_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AssetAssessmentRateDependentStudent", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeAssetAssessmentRateDependentStudent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeAssetAssessmentRateDependentStudent_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AssetAssessmentRateIndependentNoDependentsSingle", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeAssetAssessmentRateIndependentNoDependentsSingle(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeAssetAssessmentRateIndependentNoDependentsSingle_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "IncludeParentFSAHealthCare", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeIncludeParentFSAHealthCare(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeIncludeParentFSAHealthCare_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdjustByCostOfLivingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AdjustEraByCostOfLiving", scope = ImOptionsType.class)
    public JAXBElement<AdjustByCostOfLivingType> createImOptionsTypeAdjustEraByCostOfLiving(AdjustByCostOfLivingType value) {
        return new JAXBElement<AdjustByCostOfLivingType>(_ImOptionsTypeAdjustEraByCostOfLiving_QNAME, AdjustByCostOfLivingType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ThreeInCollegeAdjustment", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeThreeInCollegeAdjustment(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeThreeInCollegeAdjustment_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "MultipleChildrenCollegesAllocationPercentages", scope = ImOptionsType.class)
    public JAXBElement<SOType> createImOptionsTypeMultipleChildrenCollegesAllocationPercentages(SOType value) {
        return new JAXBElement<SOType>(_ImOptionsTypeMultipleChildrenCollegesAllocationPercentages_QNAME, SOType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentCapHomeEquityFactor", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeStudentCapHomeEquityFactor(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeStudentCapHomeEquityFactor_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AvailableIncomeAssessmentRate", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeAvailableIncomeAssessmentRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeAvailableIncomeAssessmentRate_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseBusinessFarmNetWorthList", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseBusinessFarmNetWorthList(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseBusinessFarmNetWorthList_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "FourOrMoreInCollegeAdjustment", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeFourOrMoreInCollegeAdjustment(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeFourOrMoreInCollegeAdjustment_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "TwoInCollegeAdjustment", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeTwoInCollegeAdjustment(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeTwoInCollegeAdjustment_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseStudentLifetimeLearningCredit", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseStudentLifetimeLearningCredit(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseStudentLifetimeLearningCredit_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseParentStateTaxAllowance", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseParentStateTaxAllowance(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseParentStateTaxAllowance_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseNonCustodialParentContribution", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseNonCustodialParentContribution(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseNonCustodialParentContribution_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AllowBusinessFarmLosses", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeAllowBusinessFarmLosses(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeAllowBusinessFarmLosses_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "PreventParentImLowerThanFm", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypePreventParentImLowerThanFm(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypePreventParentImLowerThanFm_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ImputeStudentContributionIncreasePercent", scope = ImOptionsType.class)
    public JAXBElement<BigDecimal> createImOptionsTypeImputeStudentContributionIncreasePercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImOptionsTypeImputeStudentContributionIncreasePercent_QNAME, BigDecimal.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseVolunteeredParentContribution", scope = ImOptionsType.class)
    public JAXBElement<YesNoType> createImOptionsTypeUseVolunteeredParentContribution(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseVolunteeredParentContribution_QNAME, YesNoType.class, ImOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ForceStudentToIndependentStatus", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeForceStudentToIndependentStatus(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeForceStudentToIndependentStatus_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectSDependentAndFathersBirthDateOverride", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeRejectSDependentAndFathersBirthDateOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeRejectSDependentAndFathersBirthDateOverride_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentNumberInCollegeOverride", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeParentNumberInCollegeOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeParentNumberInCollegeOverride_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectFDependentAndMotherNameDateOverride", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeRejectFDependentAndMotherNameDateOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeRejectFDependentAndMotherNameDateOverride_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectDFirstAndLastNameMatchOverride", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeRejectDFirstAndLastNameMatchOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeRejectDFirstAndLastNameMatchOverride_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentCalculateUsTax", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeStudentCalculateUsTax(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeStudentCalculateUsTax_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectRStudentSsnMatchOverride", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeRejectRStudentSsnMatchOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeRejectRStudentSsnMatchOverride_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectTDependentAndMotherBirthDateOverride", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeRejectTDependentAndMotherBirthDateOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeRejectTDependentAndMotherBirthDateOverride_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectEDependentAndFathersNameOverride", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeRejectEDependentAndFathersNameOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeRejectEDependentAndFathersNameOverride_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentCalculateUsTax", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeParentCalculateUsTax(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeParentCalculateUsTax_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CalculateParentContributionForIndependent", scope = FmrExtensionType.class)
    public JAXBElement<YesNoType> createFmrExtensionTypeCalculateParentContributionForIndependent(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmrExtensionTypeCalculateParentContributionForIndependent_QNAME, YesNoType.class, FmrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentMaritalStatus", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentMaritalStatus(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentMaritalStatus_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareParentDislocatedWorker", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareParentDislocatedWorker(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareParentDislocatedWorker_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentOrphanAfter13", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentOrphanAfter13(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentOrphanAfter13_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentStateOfResidency", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentStateOfResidency(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentStateOfResidency_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareParentStateOfResidency", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareParentStateOfResidency(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareParentStateOfResidency_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentDateOfBirth", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentDateOfBirth(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentDateOfBirth_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareParentTaxForm", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareParentTaxForm(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareParentTaxForm_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentYearInCollege", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentYearInCollege(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentYearInCollege_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareOldestParentDateOfBirth", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareOldestParentDateOfBirth(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareOldestParentDateOfBirth_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentDislocatedWorker", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentDislocatedWorker(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentDislocatedWorker_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareParentMaritalStatus", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareParentMaritalStatus(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareParentMaritalStatus_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentTaxForm", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentTaxForm(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentTaxForm_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentHomelessStatus", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentHomelessStatus(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentHomelessStatus_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentWardOfCourt", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentWardOfCourt(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentWardOfCourt_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CompareStudentCitizenStatus", scope = CompareOptionsType.class)
    public JAXBElement<YesNoType> createCompareOptionsTypeCompareStudentCitizenStatus(YesNoType value) {
        return new JAXBElement<YesNoType>(_CompareOptionsTypeCompareStudentCitizenStatus_QNAME, YesNoType.class, CompareOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentFederalTaxReturnStatusImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentFederalTaxReturnStatusImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentFederalTaxReturnStatusImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentDislocatedWorkerIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentDislocatedWorkerIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentDislocatedWorkerIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentNumberOfExemptionsIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentNumberOfExemptionsIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentNumberOfExemptionsIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseStudentProjectedYearIncome", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeUseStudentProjectedYearIncome(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeUseStudentProjectedYearIncome_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CalculateParentContributionForIndependents", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeCalculateParentContributionForIndependents(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeCalculateParentContributionForIndependents_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "DefaultBudgetDuration", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeDefaultBudgetDuration(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeDefaultBudgetDuration_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DependencyOverrideType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "DependencyOverride", scope = ImrExtensionType.class)
    public JAXBElement<DependencyOverrideType> createImrExtensionTypeDependencyOverride(DependencyOverrideType value) {
        return new JAXBElement<DependencyOverrideType>(_ImrExtensionTypeDependencyOverride_QNAME, DependencyOverrideType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentLocalTaxPercent", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeParentLocalTaxPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeParentLocalTaxPercent_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentEducationCreditsIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentEducationCreditsIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentEducationCreditsIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentLegalDependentsIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentLegalDependentsIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentLegalDependentsIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentLocalTaxPercent", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeStudentLocalTaxPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeStudentLocalTaxPercent_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentFedTaxPaidIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentFedTaxPaidIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentFedTaxPaidIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentVaNonEducationalBenefitsImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentVaNonEducationalBenefitsImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentVaNonEducationalBenefitsImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseParentEfmProjectedYearIncome", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeUseParentEfmProjectedYearIncome(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeUseParentEfmProjectedYearIncome_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentCombatPayImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentCombatPayImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentCombatPayImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentBusinessFarmNetWorthImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentBusinessFarmNetWorthImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentBusinessFarmNetWorthImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CanStudentImFallBelowFm", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeCanStudentImFallBelowFm(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeCanStudentImFallBelowFm_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentEducationCreditsImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentEducationCreditsImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentEducationCreditsImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AddStudentEducationCredit", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeAddStudentEducationCredit(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeAddStudentEducationCredit_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ImputeStudentContributionPercent", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeImputeStudentContributionPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeImputeStudentContributionPercent_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentAssetAssessmentRate", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeStudentAssetAssessmentRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeStudentAssetAssessmentRate_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentIncomeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentIncomeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentIncomeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentSpouseIncomeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentSpouseIncomeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentSpouseIncomeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentCitizenStatusImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentCitizenStatusImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentCitizenStatusImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentPensionPaymentsIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentPensionPaymentsIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentPensionPaymentsIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentNumberInCollegeSizeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentNumberInCollegeSizeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentNumberInCollegeSizeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentHousingMultiplierOverride", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeStudentHousingMultiplierOverride(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeStudentHousingMultiplierOverride_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ExcludeWorkstudyEarnings", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeExcludeWorkstudyEarnings(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeExcludeWorkstudyEarnings_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentMilitaryClergyAllowancesImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentMilitaryClergyAllowancesImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentMilitaryClergyAllowancesImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentTaxReturnTypeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentTaxReturnTypeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentTaxReturnTypeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentHomelessRiskImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentHomelessRiskImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentHomelessRiskImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentSpouseDislocatedWorkerImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentSpouseDislocatedWorkerImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentSpouseDislocatedWorkerImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AllowOtherLosses", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeAllowOtherLosses(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeAllowOtherLosses_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentYearInSchoolImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentYearInSchoolImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentYearInSchoolImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockMotherIncomeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockMotherIncomeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockMotherIncomeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CalculateContributionsFromAssetsUsingCountryCoefficient", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeCalculateContributionsFromAssetsUsingCountryCoefficient(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeCalculateContributionsFromAssetsUsingCountryCoefficient_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentStateOfResidenceImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentStateOfResidenceImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentStateOfResidenceImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentCombatPayImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentCombatPayImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentCombatPayImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentTaxableAidtIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentTaxableAidtIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentTaxableAidtIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockInterestIncomeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockInterestIncomeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockInterestIncomeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentCombatPayIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentCombatPayIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentCombatPayIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentEducationCreditsImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentEducationCreditsImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentEducationCreditsImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentBusinessFarmNetWorthIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentBusinessFarmNetWorthIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentBusinessFarmNetWorthIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentMaritalStatusIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentMaritalStatusIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentMaritalStatusIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentChildSupportPaidImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentChildSupportPaidImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentChildSupportPaidImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentOrphanFosterWardAfter13Isir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentOrphanFosterWardAfter13Isir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentOrphanFosterWardAfter13Isir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentHouseholdSizeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentHouseholdSizeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentHouseholdSizeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentYearInSchoolIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentYearInSchoolIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentYearInSchoolIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentTaxableAidImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentTaxableAidImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentTaxableAidImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CapStudentHomeEquity", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeCapStudentHomeEquity(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeCapStudentHomeEquity_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "IncludeParentFSAHealthCare", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeIncludeParentFSAHealthCare(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeIncludeParentFSAHealthCare_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentCashImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentCashImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentCashImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentNumberOfExemptionsImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentNumberOfExemptionsImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentNumberOfExemptionsImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentPensionPaymentsImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentPensionPaymentsImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentPensionPaymentsImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationalControlType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "OperationalControl", scope = ImrExtensionType.class)
    public JAXBElement<OperationalControlType> createImrExtensionTypeOperationalControl(OperationalControlType value) {
        return new JAXBElement<OperationalControlType>(_ImrExtensionTypeOperationalControl_QNAME, OperationalControlType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentNumberInCollegeSizeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentNumberInCollegeSizeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentNumberInCollegeSizeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentSpouseIncomeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentSpouseIncomeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentSpouseIncomeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseStudentEfmProjectedYearIncome", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeUseStudentEfmProjectedYearIncome(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeUseStudentEfmProjectedYearIncome_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentAgiIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentAgiIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentAgiIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentDateOfBirthIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentDateOfBirthIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentDateOfBirthIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentFederalTaxReturnStatusIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentFederalTaxReturnStatusIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentFederalTaxReturnStatusIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CapParentHomeEquity", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeCapParentHomeEquity(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeCapParentHomeEquity_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentNumberOfExemptionsIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentNumberOfExemptionsIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentNumberOfExemptionsIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentTaxReturnTypeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentTaxReturnTypeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentTaxReturnTypeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentFederalTaxReturnStatusImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentFederalTaxReturnStatusImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentFederalTaxReturnStatusImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentOtherUntaxedIncomeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentOtherUntaxedIncomeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentOtherUntaxedIncomeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentOrphanFosterWardAfter13Imr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentOrphanFosterWardAfter13Imr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentOrphanFosterWardAfter13Imr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentWardOfCourtIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentWardOfCourtIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentWardOfCourtIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentCashImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentCashImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentCashImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentDateOfBirthImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentDateOfBirthImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentDateOfBirthImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentTaxReturnTypeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentTaxReturnTypeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentTaxReturnTypeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "PerformStudentContributionUsingNewMethodology", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypePerformStudentContributionUsingNewMethodology(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypePerformStudentContributionUsingNewMethodology_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentInvestmentNetWorthImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentInvestmentNetWorthImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentInvestmentNetWorthImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentImputeAssetsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentImputeAssets", scope = ImrExtensionType.class)
    public JAXBElement<StudentImputeAssetsType> createImrExtensionTypeStudentImputeAssets(StudentImputeAssetsType value) {
        return new JAXBElement<StudentImputeAssetsType>(_ImrExtensionTypeStudentImputeAssets_QNAME, StudentImputeAssetsType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentChildSupportReceivedIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentChildSupportReceivedIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentChildSupportReceivedIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentHomelessRiskIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentHomelessRiskIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentHomelessRiskIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentDateOfBirthImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentDateOfBirthImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentDateOfBirthImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentAgiImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentAgiImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentAgiImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LimitSiblingShareOfParentContribution", scope = ImrExtensionType.class)
    public JAXBElement<String> createImrExtensionTypeLimitSiblingShareOfParentContribution(String value) {
        return new JAXBElement<String>(_ImrExtensionTypeLimitSiblingShareOfParentContribution_QNAME, String.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentHouseholdSizeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentHouseholdSizeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentHouseholdSizeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "IncludeParentFSADependentCare", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeIncludeParentFSADependentCare(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeIncludeParentFSADependentCare_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentMaritalStatusImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentMaritalStatusImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentMaritalStatusImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentUntaxedIraDistributionIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentUntaxedIraDistributionIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentUntaxedIraDistributionIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentChildSupportReceivedIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentChildSupportReceivedIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentChildSupportReceivedIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentFedTaxPaidIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentFedTaxPaidIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentFedTaxPaidIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UOrRType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReleaseIsirToImrMigration", scope = ImrExtensionType.class)
    public JAXBElement<UOrRType> createImrExtensionTypeReleaseIsirToImrMigration(UOrRType value) {
        return new JAXBElement<UOrRType>(_ImrExtensionTypeReleaseIsirToImrMigration_QNAME, UOrRType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentIraKeoghPercent", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeStudentIraKeoghPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeStudentIraKeoghPercent_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentBusinessFarmNetWorthIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentBusinessFarmNetWorthIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentBusinessFarmNetWorthIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentUntaxedIraDistributionImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentUntaxedIraDistributionImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentUntaxedIraDistributionImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockFatherIncomeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockFatherIncomeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockFatherIncomeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentAssetAssessmentRate", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeParentAssetAssessmentRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeParentAssetAssessmentRate_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentEducationCreditsIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentEducationCreditsIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentEducationCreditsIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentIraPaymentsIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentIraPaymentsIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentIraPaymentsIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentNumberInCollegeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentNumberInCollegeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentNumberInCollegeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentIraPaymentsImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentIraPaymentsImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentIraPaymentsImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ExcludeTuitionDeduction", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeExcludeTuitionDeduction(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeExcludeTuitionDeduction_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentHouseholdSizeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentHouseholdSizeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentHouseholdSizeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "IndependentStudentIncomeAssessmentPercent", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeIndependentStudentIncomeAssessmentPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeIndependentStudentIncomeAssessmentPercent_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentSpouseDislocatedWorkerIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentSpouseDislocatedWorkerIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentSpouseDislocatedWorkerIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentHouseholdSizeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentHouseholdSizeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentHouseholdSizeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentNumberInCollegeIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentNumberInCollegeIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentNumberInCollegeIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentMilitaryClergyAllowancesIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentMilitaryClergyAllowancesIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentMilitaryClergyAllowancesIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AddParentEducationCredit", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeAddParentEducationCredit(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeAddParentEducationCredit_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentAgiImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentAgiImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentAgiImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentFedTaxPaidImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentFedTaxPaidImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentFedTaxPaidImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentVeteranStatusImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentVeteranStatusImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentVeteranStatusImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentDateOfBirthIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentDateOfBirthIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentDateOfBirthIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentCapHomeValue", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeStudentCapHomeValue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeStudentCapHomeValue_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ImputeParentContributionPercent", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeImputeParentContributionPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeImputeParentContributionPercent_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentColaIndex", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeParentColaIndex(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeParentColaIndex_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentCashIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentCashIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentCashIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentInvestmentNetWorthIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentInvestmentNetWorthIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentInvestmentNetWorthIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentAgiIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentAgiIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentAgiIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LimitInternationalParentIncomeProtectionAllowance", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeLimitInternationalParentIncomeProtectionAllowance(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeLimitInternationalParentIncomeProtectionAllowance_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentLegalDependentsImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentLegalDependentsImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentLegalDependentsImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockMotherIncomeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockMotherIncomeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockMotherIncomeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentChildSupportPaidIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentChildSupportPaidIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentChildSupportPaidIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentCombatPayIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentCombatPayIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentCombatPayIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentHousingMultiplierOverride", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeParentHousingMultiplierOverride(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeParentHousingMultiplierOverride_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentChildSupportReceivedImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentChildSupportReceivedImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentChildSupportReceivedImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentStateOfResidenceIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentStateOfResidenceIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentStateOfResidenceIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentOtherUntaxedIncomeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentOtherUntaxedIncomeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentOtherUntaxedIncomeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentVaNonEducationalBenefitsIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentVaNonEducationalBenefitsIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentVaNonEducationalBenefitsIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentUntaxedPensionDistributionIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentUntaxedPensionDistributionIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentUntaxedPensionDistributionIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseStateTaxAllowance", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeUseStateTaxAllowance(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeUseStateTaxAllowance_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentMaritalStatusIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentMaritalStatusIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentMaritalStatusIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentStateOfResidenceImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentStateOfResidenceImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentStateOfResidenceImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockInterestIncomeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockInterestIncomeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockInterestIncomeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentChildSupportPaidIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentChildSupportPaidIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentChildSupportPaidIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentNumberOfExemptionsImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentNumberOfExemptionsImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentNumberOfExemptionsImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentFedTaxPaidImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentFedTaxPaidImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentFedTaxPaidImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentDislocatedWorkerImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentDislocatedWorkerImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentDislocatedWorkerImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MigrationDirectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "MigrationDirection", scope = ImrExtensionType.class)
    public JAXBElement<MigrationDirectionType> createImrExtensionTypeMigrationDirection(MigrationDirectionType value) {
        return new JAXBElement<MigrationDirectionType>(_ImrExtensionTypeMigrationDirection_QNAME, MigrationDirectionType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentChildSupportPaidImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentChildSupportPaidImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentChildSupportPaidImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UOrRType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReleaseImrToIsirMigration", scope = ImrExtensionType.class)
    public JAXBElement<UOrRType> createImrExtensionTypeReleaseImrToIsirMigration(UOrRType value) {
        return new JAXBElement<UOrRType>(_ImrExtensionTypeReleaseImrToIsirMigration_QNAME, UOrRType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CanParentImFallBelowFm", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeCanParentImFallBelowFm(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeCanParentImFallBelowFm_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentCitizenStatusIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentCitizenStatusIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentCitizenStatusIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentCapHomeValue", scope = ImrExtensionType.class)
    public JAXBElement<BigDecimal> createImrExtensionTypeParentCapHomeValue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ImrExtensionTypeParentCapHomeValue_QNAME, BigDecimal.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParentImputeAssetsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ParentImputeAssets", scope = ImrExtensionType.class)
    public JAXBElement<ParentImputeAssetsType> createImrExtensionTypeParentImputeAssets(ParentImputeAssetsType value) {
        return new JAXBElement<ParentImputeAssetsType>(_ImrExtensionTypeParentImputeAssets_QNAME, ParentImputeAssetsType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentVeteranStatusIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentVeteranStatusIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentVeteranStatusIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "SkipFamilyMembersOnAge", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeSkipFamilyMembersOnAge(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeSkipFamilyMembersOnAge_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockFatherIncomeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockFatherIncomeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockFatherIncomeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentIncomeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentIncomeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentIncomeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentStateOfResidenceIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentStateOfResidenceIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentStateOfResidenceIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentCashIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentCashIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentCashIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentMaritalStatusImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentMaritalStatusImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentMaritalStatusImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentChildSupportReceivedImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentChildSupportReceivedImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentChildSupportReceivedImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentUntaxedPensionDistributionImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentUntaxedPensionDistributionImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentUntaxedPensionDistributionImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentInvestmentNetWorthImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentInvestmentNetWorthImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentInvestmentNetWorthImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseNonCustodialParentContribution", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeUseNonCustodialParentContribution(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeUseNonCustodialParentContribution_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AllowBusinessFarmLosses", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeAllowBusinessFarmLosses(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImOptionsTypeAllowBusinessFarmLosses_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseParentProjectedYearIncome", scope = ImrExtensionType.class)
    public JAXBElement<YesNoType> createImrExtensionTypeUseParentProjectedYearIncome(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeUseParentProjectedYearIncome_QNAME, YesNoType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockStudentWardOfCourtImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockStudentWardOfCourtImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockStudentWardOfCourtImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentFederalTaxReturnStatusIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentFederalTaxReturnStatusIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentFederalTaxReturnStatusIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentInvestmentNetWorthIsir", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentInvestmentNetWorthIsir(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentInvestmentNetWorthIsir_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LockParentTaxReturnTypeImr", scope = ImrExtensionType.class)
    public JAXBElement<LockType> createImrExtensionTypeLockParentTaxReturnTypeImr(LockType value) {
        return new JAXBElement<LockType>(_ImrExtensionTypeLockParentTaxReturnTypeImr_QNAME, LockType.class, ImrExtensionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UnaccompaniedYouthBySchoolIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeUnaccompaniedYouthBySchoolIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeUnaccompaniedYouthBySchoolIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "EmancipatedMinorIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeEmancipatedMinorIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeEmancipatedMinorIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LegalDependentsIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeLegalDependentsIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeLegalDependentsIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "SsnMatchIndicator", scope = FmStudentType.class)
    public JAXBElement<String> createFmStudentTypeSsnMatchIndicator(String value) {
        return new JAXBElement<String>(_FmStudentTypeSsnMatchIndicator_QNAME, String.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "BirthDate", scope = FmStudentType.class)
    public JAXBElement<XMLGregorianCalendar> createFmStudentTypeBirthDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_FmStudentTypeBirthDate_QNAME, XMLGregorianCalendar.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ZipCode", scope = FmStudentType.class)
    public JAXBElement<BigDecimal> createFmStudentTypeZipCode(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_FmStudentTypeZipCode_QNAME, BigDecimal.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ResidencyStateProvinceCode", scope = FmStudentType.class)
    public JAXBElement<StateProvinceType> createFmStudentTypeResidencyStateProvinceCode(StateProvinceType value) {
        return new JAXBElement<StateProvinceType>(_FmStudentTypeResidencyStateProvinceCode_QNAME, StateProvinceType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "InLegalGuardianshipIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeInLegalGuardianshipIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeInLegalGuardianshipIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "BornPriorIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeBornPriorIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeBornPriorIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CitizenshipSsaFlag", scope = FmStudentType.class)
    public JAXBElement<String> createFmStudentTypeCitizenshipSsaFlag(String value) {
        return new JAXBElement<String>(_FmStudentTypeCitizenshipSsaFlag_QNAME, String.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UnaccompaniedYouthByHUDIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeUnaccompaniedYouthByHUDIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeUnaccompaniedYouthByHUDIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveFoodStamps", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeReceiveFoodStamps(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveFoodStamps_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ActiveDutyIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeActiveDutyIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeActiveDutyIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "HaveChildrenYouSupportIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeHaveChildrenYouSupportIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeHaveChildrenYouSupportIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AssetThresholdExceeded", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeAssetThresholdExceeded(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeAssetThresholdExceeded_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "VeteranIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeVeteranIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeVeteranIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveTANF", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeReceiveTANF(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveTANF_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveFreeLunch", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeReceiveFreeLunch(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveFreeLunch_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StateProvinceCode", scope = FmStudentType.class)
    public JAXBElement<StateProvinceType> createFmStudentTypeStateProvinceCode(StateProvinceType value) {
        return new JAXBElement<StateProvinceType>(_FmStudentTypeStateProvinceCode_QNAME, StateProvinceType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "OrphanWardOfCourtIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeOrphanWardOfCourtIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeOrphanWardOfCourtIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "WorkOnGraduateDegreeInd", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeWorkOnGraduateDegreeInd(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeWorkOnGraduateDegreeInd_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "MarriedIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeMarriedIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeMarriedIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "DislocatedWorker", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeDislocatedWorker(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeDislocatedWorker_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AtRiskHomelessIndicator", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeAtRiskHomelessIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeAtRiskHomelessIndicator_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveSSI", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeReceiveSSI(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveSSI_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveWIC", scope = FmStudentType.class)
    public JAXBElement<YesNoType> createFmStudentTypeReceiveWIC(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveWIC_QNAME, YesNoType.class, FmStudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CalculateStudentEstimatedIncomeTax", scope = FmOptionsType.class)
    public JAXBElement<YesNoType> createFmOptionsTypeCalculateStudentEstimatedIncomeTax(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmOptionsTypeCalculateStudentEstimatedIncomeTax_QNAME, YesNoType.class, FmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "FmCalculateParentContributionForIndependents", scope = FmOptionsType.class)
    public JAXBElement<YesNoType> createFmOptionsTypeFmCalculateParentContributionForIndependents(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmOptionsTypeFmCalculateParentContributionForIndependents_QNAME, YesNoType.class, FmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CalculateParentEstimatedIncomeTax", scope = FmOptionsType.class)
    public JAXBElement<YesNoType> createFmOptionsTypeCalculateParentEstimatedIncomeTax(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmOptionsTypeCalculateParentEstimatedIncomeTax_QNAME, YesNoType.class, FmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "PercentToApply", scope = BusinessFarmNetWorthEntryType.class)
    public JAXBElement<BigDecimal> createBusinessFarmNetWorthEntryTypePercentToApply(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_BusinessFarmNetWorthEntryTypePercentToApply_QNAME, BigDecimal.class, BusinessFarmNetWorthEntryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AllocationPercent3", scope = MultipleChildProtectionAllocationType.class)
    public JAXBElement<BigDecimal> createMultipleChildProtectionAllocationTypeAllocationPercent3(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MultipleChildProtectionAllocationTypeAllocationPercent3_QNAME, BigDecimal.class, MultipleChildProtectionAllocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AllocationPercent1", scope = MultipleChildProtectionAllocationType.class)
    public JAXBElement<BigDecimal> createMultipleChildProtectionAllocationTypeAllocationPercent1(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MultipleChildProtectionAllocationTypeAllocationPercent1_QNAME, BigDecimal.class, MultipleChildProtectionAllocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AllocationPercent2", scope = MultipleChildProtectionAllocationType.class)
    public JAXBElement<BigDecimal> createMultipleChildProtectionAllocationTypeAllocationPercent2(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MultipleChildProtectionAllocationTypeAllocationPercent2_QNAME, BigDecimal.class, MultipleChildProtectionAllocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttendCollegeCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AttendCollegeCode", scope = FamilyMemberType.class)
    public JAXBElement<AttendCollegeCodeType> createFamilyMemberTypeAttendCollegeCode(AttendCollegeCodeType value) {
        return new JAXBElement<AttendCollegeCodeType>(_FamilyMemberTypeAttendCollegeCode_QNAME, AttendCollegeCodeType.class, FamilyMemberType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Assumption6StudentAdditonalDataOverride", scope = FmAssumptionsType.class)
    public JAXBElement<YesNoType> createFmAssumptionsTypeAssumption6StudentAdditonalDataOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmAssumptionsTypeAssumption6StudentAdditonalDataOverride_QNAME, YesNoType.class, FmAssumptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Assumption3StudentNumberInCollegeOverride", scope = FmAssumptionsType.class)
    public JAXBElement<YesNoType> createFmAssumptionsTypeAssumption3StudentNumberInCollegeOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmAssumptionsTypeAssumption3StudentNumberInCollegeOverride_QNAME, YesNoType.class, FmAssumptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Assumption2ParentAdjustedGrossIncomeOverride", scope = FmAssumptionsType.class)
    public JAXBElement<YesNoType> createFmAssumptionsTypeAssumption2ParentAdjustedGrossIncomeOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmAssumptionsTypeAssumption2ParentAdjustedGrossIncomeOverride_QNAME, YesNoType.class, FmAssumptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Assumption5ParentAdditionalDataOverride", scope = FmAssumptionsType.class)
    public JAXBElement<YesNoType> createFmAssumptionsTypeAssumption5ParentAdditionalDataOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmAssumptionsTypeAssumption5ParentAdditionalDataOverride_QNAME, YesNoType.class, FmAssumptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Assumption4StudentAdjustedGrossIncomeOverride", scope = FmAssumptionsType.class)
    public JAXBElement<YesNoType> createFmAssumptionsTypeAssumption4StudentAdjustedGrossIncomeOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmAssumptionsTypeAssumption4StudentAdjustedGrossIncomeOverride_QNAME, YesNoType.class, FmAssumptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Assumption1ParentNumberInCollegeOverride", scope = FmAssumptionsType.class)
    public JAXBElement<YesNoType> createFmAssumptionsTypeAssumption1ParentNumberInCollegeOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmAssumptionsTypeAssumption1ParentNumberInCollegeOverride_QNAME, YesNoType.class, FmAssumptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "GenerateProfileEditMessages", scope = OperationalOptionsType.class)
    public JAXBElement<YesNoType> createOperationalOptionsTypeGenerateProfileEditMessages(YesNoType value) {
        return new JAXBElement<YesNoType>(_OperationalOptionsTypeGenerateProfileEditMessages_QNAME, YesNoType.class, OperationalOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "InstDefaultResidencyState", scope = OperationalOptionsType.class)
    public JAXBElement<StateProvinceType> createOperationalOptionsTypeInstDefaultResidencyState(StateProvinceType value) {
        return new JAXBElement<StateProvinceType>(_OperationalOptionsTypeInstDefaultResidencyState_QNAME, StateProvinceType.class, OperationalOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataToMigrateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "DataToMigrate", scope = OperationalOptionsType.class)
    public JAXBElement<DataToMigrateType> createOperationalOptionsTypeDataToMigrate(DataToMigrateType value) {
        return new JAXBElement<DataToMigrateType>(_OperationalOptionsTypeDataToMigrate_QNAME, DataToMigrateType.class, OperationalOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LimitReportingBasedOnToleranceLimits", scope = OperationalOptionsType.class)
    public JAXBElement<YesNoType> createOperationalOptionsTypeLimitReportingBasedOnToleranceLimits(YesNoType value) {
        return new JAXBElement<YesNoType>(_OperationalOptionsTypeLimitReportingBasedOnToleranceLimits_QNAME, YesNoType.class, OperationalOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateDataMigrationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ActivateDataMigration", scope = OperationalOptionsType.class)
    public JAXBElement<ActivateDataMigrationType> createOperationalOptionsTypeActivateDataMigration(ActivateDataMigrationType value) {
        return new JAXBElement<ActivateDataMigrationType>(_OperationalOptionsTypeActivateDataMigration_QNAME, ActivateDataMigrationType.class, OperationalOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ActivateParentImrIsirComparison", scope = OperationalOptionsType.class)
    public JAXBElement<YesNoType> createOperationalOptionsTypeActivateParentImrIsirComparison(YesNoType value) {
        return new JAXBElement<YesNoType>(_OperationalOptionsTypeActivateParentImrIsirComparison_QNAME, YesNoType.class, OperationalOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ActivateStudentImrIsirComparison", scope = OperationalOptionsType.class)
    public JAXBElement<YesNoType> createOperationalOptionsTypeActivateStudentImrIsirComparison(YesNoType value) {
        return new JAXBElement<YesNoType>(_OperationalOptionsTypeActivateStudentImrIsirComparison_QNAME, YesNoType.class, OperationalOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "NumberOfEmployeesIndicator", scope = ParentsType.class)
    public JAXBElement<YesNoType> createParentsTypeNumberOfEmployeesIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_ParentsTypeNumberOfEmployeesIndicator_QNAME, YesNoType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ResidencyStateProvinceCode", scope = ParentsType.class)
    public JAXBElement<StateProvinceType> createParentsTypeResidencyStateProvinceCode(StateProvinceType value) {
        return new JAXBElement<StateProvinceType>(_FmStudentTypeResidencyStateProvinceCode_QNAME, StateProvinceType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LiveOnFarmIndicator", scope = ParentsType.class)
    public JAXBElement<YesNoType> createParentsTypeLiveOnFarmIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_ParentsTypeLiveOnFarmIndicator_QNAME, YesNoType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Parent1BirthDate", scope = ParentsType.class)
    public JAXBElement<XMLGregorianCalendar> createParentsTypeParent1BirthDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ParentsTypeParent1BirthDate_QNAME, XMLGregorianCalendar.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CountryCoefficient", scope = ParentsType.class)
    public JAXBElement<BigDecimal> createParentsTypeCountryCoefficient(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ParentsTypeCountryCoefficient_QNAME, BigDecimal.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveFoodStamps", scope = ParentsType.class)
    public JAXBElement<YesNoType> createParentsTypeReceiveFoodStamps(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveFoodStamps_QNAME, YesNoType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Parent2BirthDate", scope = ParentsType.class)
    public JAXBElement<XMLGregorianCalendar> createParentsTypeParent2BirthDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ParentsTypeParent2BirthDate_QNAME, XMLGregorianCalendar.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FatherMotherType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentReceivesSupportFrom", scope = ParentsType.class)
    public JAXBElement<FatherMotherType> createParentsTypeStudentReceivesSupportFrom(FatherMotherType value) {
        return new JAXBElement<FatherMotherType>(_ParentsTypeStudentReceivesSupportFrom_QNAME, FatherMotherType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentLivesWithType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StudentLivesWith", scope = ParentsType.class)
    public JAXBElement<StudentLivesWithType> createParentsTypeStudentLivesWith(StudentLivesWithType value) {
        return new JAXBElement<StudentLivesWithType>(_ParentsTypeStudentLivesWith_QNAME, StudentLivesWithType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "DislocatedWorker", scope = ParentsType.class)
    public JAXBElement<YesNoType> createParentsTypeDislocatedWorker(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeDislocatedWorker_QNAME, YesNoType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveSSI", scope = ParentsType.class)
    public JAXBElement<YesNoType> createParentsTypeReceiveSSI(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveSSI_QNAME, YesNoType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveTANF", scope = ParentsType.class)
    public JAXBElement<YesNoType> createParentsTypeReceiveTANF(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveTANF_QNAME, YesNoType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveFreeLunch", scope = ParentsType.class)
    public JAXBElement<YesNoType> createParentsTypeReceiveFreeLunch(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveFreeLunch_QNAME, YesNoType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveWIC", scope = ParentsType.class)
    public JAXBElement<YesNoType> createParentsTypeReceiveWIC(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveWIC_QNAME, YesNoType.class, ParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseStudentProjectedYearIncome", scope = EfmOptionsType.class)
    public JAXBElement<YesNoType> createEfmOptionsTypeUseStudentProjectedYearIncome(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeUseStudentProjectedYearIncome_QNAME, YesNoType.class, EfmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseParentIncomeOverrides", scope = EfmOptionsType.class)
    public JAXBElement<YesNoType> createEfmOptionsTypeUseParentIncomeOverrides(YesNoType value) {
        return new JAXBElement<YesNoType>(_EfmOptionsTypeUseParentIncomeOverrides_QNAME, YesNoType.class, EfmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseParentProjectedYearIncome", scope = EfmOptionsType.class)
    public JAXBElement<YesNoType> createEfmOptionsTypeUseParentProjectedYearIncome(YesNoType value) {
        return new JAXBElement<YesNoType>(_ImrExtensionTypeUseParentProjectedYearIncome_QNAME, YesNoType.class, EfmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseStudentIncomeOverrides", scope = EfmOptionsType.class)
    public JAXBElement<YesNoType> createEfmOptionsTypeUseStudentIncomeOverrides(YesNoType value) {
        return new JAXBElement<YesNoType>(_EfmOptionsTypeUseStudentIncomeOverrides_QNAME, YesNoType.class, EfmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseStudentImputedAssets", scope = EfmOptionsType.class)
    public JAXBElement<YesNoType> createEfmOptionsTypeUseStudentImputedAssets(YesNoType value) {
        return new JAXBElement<YesNoType>(_EfmOptionsTypeUseStudentImputedAssets_QNAME, YesNoType.class, EfmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseParentImputedAssets", scope = EfmOptionsType.class)
    public JAXBElement<YesNoType> createEfmOptionsTypeUseParentImputedAssets(YesNoType value) {
        return new JAXBElement<YesNoType>(_EfmOptionsTypeUseParentImputedAssets_QNAME, YesNoType.class, EfmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "UseProfileAssumptions", scope = EfmOptionsType.class)
    public JAXBElement<YesNoType> createEfmOptionsTypeUseProfileAssumptions(YesNoType value) {
        return new JAXBElement<YesNoType>(_EfmOptionsTypeUseProfileAssumptions_QNAME, YesNoType.class, EfmOptionsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "CapHousingPercent", scope = HomeProjectionType.class)
    public JAXBElement<BigDecimal> createHomeProjectionTypeCapHousingPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_HomeProjectionTypeCapHousingPercent_QNAME, BigDecimal.class, HomeProjectionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectKMotherSsnOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeRejectKMotherSsnOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeRejectKMotherSsnOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Reject21StudentCorrectedMaritalStatusDateOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeReject21StudentCorrectedMaritalStatusDateOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeReject21StudentCorrectedMaritalStatusDateOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectNIncompleteNameOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeRejectNIncompleteNameOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeRejectNIncompleteNameOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Reject20NonTaxFilerOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeReject20NonTaxFilerOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeReject20NonTaxFilerOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectWHighFamilyMemberOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeRejectWHighFamilyMemberOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeRejectWHighFamilyMemberOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Reject12ParentTaxPaidOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeReject12ParentTaxPaidOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeReject12ParentTaxPaidOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectBDateOfBirthYoungOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeRejectBDateOfBirthYoungOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeRejectBDateOfBirthYoungOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectJFatherSsnOveride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeRejectJFatherSsnOveride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeRejectJFatherSsnOveride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectGDependentTaxPaidComplexOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeRejectGDependentTaxPaidComplexOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeRejectGDependentTaxPaidComplexOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "Reject3StudentTaxPaidOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeReject3StudentTaxPaidOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeReject3StudentTaxPaidOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectCParentIndepedentTaxPaidComplexOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeRejectCParentIndepedentTaxPaidComplexOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeRejectCParentIndepedentTaxPaidComplexOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "RejectADateOfBirthOldOverride", scope = FmRejectsType.class)
    public JAXBElement<YesNoType> createFmRejectsTypeRejectADateOfBirthOldOverride(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmRejectsTypeRejectADateOfBirthOldOverride_QNAME, YesNoType.class, FmRejectsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "BirthDate", scope = ParentIdentityDataType.class)
    public JAXBElement<XMLGregorianCalendar> createParentIdentityDataTypeBirthDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_FmStudentTypeBirthDate_QNAME, XMLGregorianCalendar.class, ParentIdentityDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "SSNMatchFlag", scope = ParentIdentityDataType.class)
    public JAXBElement<String> createParentIdentityDataTypeSSNMatchFlag(String value) {
        return new JAXBElement<String>(_ParentIdentityDataTypeSSNMatchFlag_QNAME, String.class, ParentIdentityDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "SSN", scope = ParentIdentityDataType.class)
    public JAXBElement<BigDecimal> createParentIdentityDataTypeSSN(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ParentIdentityDataTypeSSN_QNAME, BigDecimal.class, ParentIdentityDataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LegalDependentsIndicator", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeLegalDependentsIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeLegalDependentsIndicator_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "BirthDate", scope = StudentType.class)
    public JAXBElement<XMLGregorianCalendar> createStudentTypeBirthDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_FmStudentTypeBirthDate_QNAME, XMLGregorianCalendar.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "StateProvinceCode", scope = StudentType.class)
    public JAXBElement<StateProvinceType> createStudentTypeStateProvinceCode(StateProvinceType value) {
        return new JAXBElement<StateProvinceType>(_FmStudentTypeStateProvinceCode_QNAME, StateProvinceType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ResidencyStateProvinceCode", scope = StudentType.class)
    public JAXBElement<StateProvinceType> createStudentTypeResidencyStateProvinceCode(StateProvinceType value) {
        return new JAXBElement<StateProvinceType>(_FmStudentTypeResidencyStateProvinceCode_QNAME, StateProvinceType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "HomelessIndicator", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeHomelessIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_StudentTypeHomelessIndicator_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LiveOnFarmIndicator", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeLiveOnFarmIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_ParentsTypeLiveOnFarmIndicator_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationTypeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ApplicationType", scope = StudentType.class)
    public JAXBElement<ApplicationTypeType> createStudentTypeApplicationType(ApplicationTypeType value) {
        return new JAXBElement<ApplicationTypeType>(_StudentTypeApplicationType_QNAME, ApplicationTypeType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "OrphanWardOfCourtIndicator", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeOrphanWardOfCourtIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeOrphanWardOfCourtIndicator_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ForeignAddressIndicator", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeForeignAddressIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_StudentTypeForeignAddressIndicator_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveFoodStamps", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeReceiveFoodStamps(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveFoodStamps_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ApplicationReceiptDate", scope = StudentType.class)
    public JAXBElement<XMLGregorianCalendar> createStudentTypeApplicationReceiptDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StudentTypeApplicationReceiptDate_QNAME, XMLGregorianCalendar.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "LargeBusinessIndicator", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeLargeBusinessIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_StudentTypeLargeBusinessIndicator_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "DislocatedWorker", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeDislocatedWorker(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeDislocatedWorker_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "VeteranIndicator", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeVeteranIndicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeVeteranIndicator_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "OrphanFosterWardAfter13Indicator", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeOrphanFosterWardAfter13Indicator(YesNoType value) {
        return new JAXBElement<YesNoType>(_StudentTypeOrphanFosterWardAfter13Indicator_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveSSI", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeReceiveSSI(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveSSI_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveTANF", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeReceiveTANF(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveTANF_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveWIC", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeReceiveWIC(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveWIC_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveFreeLunch", scope = StudentType.class)
    public JAXBElement<YesNoType> createStudentTypeReceiveFreeLunch(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveFreeLunch_QNAME, YesNoType.class, StudentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveFoodStamps", scope = FmParentsType.class)
    public JAXBElement<YesNoType> createFmParentsTypeReceiveFoodStamps(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveFoodStamps_QNAME, YesNoType.class, FmParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "AssetThresholdExceeded", scope = FmParentsType.class)
    public JAXBElement<YesNoType> createFmParentsTypeAssetThresholdExceeded(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeAssetThresholdExceeded_QNAME, YesNoType.class, FmParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ResidencyStateProvinceCode", scope = FmParentsType.class)
    public JAXBElement<StateProvinceType> createFmParentsTypeResidencyStateProvinceCode(StateProvinceType value) {
        return new JAXBElement<StateProvinceType>(_FmStudentTypeResidencyStateProvinceCode_QNAME, StateProvinceType.class, FmParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveSSI", scope = FmParentsType.class)
    public JAXBElement<YesNoType> createFmParentsTypeReceiveSSI(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveSSI_QNAME, YesNoType.class, FmParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveTANF", scope = FmParentsType.class)
    public JAXBElement<YesNoType> createFmParentsTypeReceiveTANF(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveTANF_QNAME, YesNoType.class, FmParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveWIC", scope = FmParentsType.class)
    public JAXBElement<YesNoType> createFmParentsTypeReceiveWIC(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveWIC_QNAME, YesNoType.class, FmParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YesNoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ReceiveFreeLunch", scope = FmParentsType.class)
    public JAXBElement<YesNoType> createFmParentsTypeReceiveFreeLunch(YesNoType value) {
        return new JAXBElement<YesNoType>(_FmStudentTypeReceiveFreeLunch_QNAME, YesNoType.class, FmParentsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ApplicationCompleteDate", scope = FmOtherType.class)
    public JAXBElement<XMLGregorianCalendar> createFmOtherTypeApplicationCompleteDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_FmOtherTypeApplicationCompleteDate_QNAME, XMLGregorianCalendar.class, FmOtherType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ApplicationReceiptDate", scope = FmOtherType.class)
    public JAXBElement<XMLGregorianCalendar> createFmOtherTypeApplicationReceiptDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StudentTypeApplicationReceiptDate_QNAME, XMLGregorianCalendar.class, FmOtherType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DependencyStatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "DependencyStatus", scope = FmOtherType.class)
    public JAXBElement<DependencyStatusType> createFmOtherTypeDependencyStatus(DependencyStatusType value) {
        return new JAXBElement<DependencyStatusType>(_FmOtherTypeDependencyStatus_QNAME, DependencyStatusType.class, FmOtherType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppSignedByType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ApplicationSignedBy", scope = FmOtherType.class)
    public JAXBElement<AppSignedByType> createFmOtherTypeApplicationSignedBy(AppSignedByType value) {
        return new JAXBElement<AppSignedByType>(_FmOtherTypeApplicationSignedBy_QNAME, AppSignedByType.class, FmOtherType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://INAS.collegeboard.org/2013/Input/", name = "ProfessionalJudgment", scope = FmOtherType.class)
    public JAXBElement<String> createFmOtherTypeProfessionalJudgment(String value) {
        return new JAXBElement<String>(_FmOtherTypeProfessionalJudgment_QNAME, String.class, FmOtherType.class, value);
    }

}
