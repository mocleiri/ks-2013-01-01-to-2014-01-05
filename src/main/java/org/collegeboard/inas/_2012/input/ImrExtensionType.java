
package org.collegeboard.inas._2012.input;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for imrExtensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="imrExtensionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DependencyOverride" type="{http://INAS.collegeboard.org/2012/Input/}dependencyOverrideType" minOccurs="0"/>
 *         &lt;element name="DefaultBudgetDuration" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CalculateParentContributionForIndependents" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="SkipFamilyMembersOnAge" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseStudentProjectedYearIncome" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseParentProjectedYearIncome" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseStateTaxAllowance" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ExcludeWorkstudyEarnings" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ExcludeTuitionDeduction" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MaximumTuitionAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentMedicalAllowancePercent" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentMedicalAllowanceAmount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentMedicalAllowancePercent" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentMedicalAllowanceAmount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentEmploymentAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentEmploymentAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentFicaAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentFicaAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentAdditionalIncomeAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentAdditionalIncomeAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentColaIndex" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LimitInternationalParentIncomeProtectionAllowance" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ParentIncomeProtectionAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentFederalTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentFederalTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentCalculatedFederalTaxPaidBehavior" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentCalculatedFederalTaxPaidBehavior" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentProjectedFederalTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentProjectedFederalTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentLocalTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentLocalTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentLocalTaxPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentLocalTaxPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AddStudentEducationCredit" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AddParentEducationCredit" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="IndependentStudentIncomeAssessmentPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AllowBusinessFarmLosses" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AllowOtherLosses" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="StudentAdditionalAssets" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentAdditionalAssets" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentAdditionalAssetAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentAdditionalAssetAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentProjectHomeValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentProjectHomeValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentCapHomeValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentCapHomeValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="StudentImputeAssets" type="{http://INAS.collegeboard.org/2012/Input/}studentImputeAssetsType" minOccurs="0"/>
 *         &lt;element name="ParentImputeAssets" type="{http://INAS.collegeboard.org/2012/Input/}parentImputeAssetsType" minOccurs="0"/>
 *         &lt;element name="StudentIraKeoghPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CalculateContributionsFromAssetsUsingCountryCoefficient" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="StudentAssetAssessmentRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentAssetAssessmentRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AddStudentAssetsToParentAssets" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CapStudentHomeEquity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CapParentHomeEquity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MinimumStudentContributionFromIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MinimumParentContributionFromIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MinimumStudentContributionFromAssets" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MinimumParentContributionFromAssets" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PriorYearStudentContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PriorYearParentContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ImputeStudentContributionPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ImputeParentContributionPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PerformStudentContributionUsingNewMethodology" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="LimitSiblingShareOfParentContribution" type="{http://INAS.collegeboard.org/2012/Input/}siblingContributionType" minOccurs="0"/>
 *         &lt;element name="CanStudentImFallBelowFm" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CanParentImFallBelowFm" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseNonCustodialParentContribution" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="StudentTotalBudget" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentNumberInCollegeOverride" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentNumberInCollegeOverride" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentHousingMultiplierOverride" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentHousingMultiplierOverride" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ReleaseIsirToImrMigration" type="{http://INAS.collegeboard.org/2012/Input/}uOrRType" minOccurs="0"/>
 *         &lt;element name="ReleaseImrToIsirMigration" type="{http://INAS.collegeboard.org/2012/Input/}uOrRType" minOccurs="0"/>
 *         &lt;element name="LockIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentYearInSchoolIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentYearInSchoolImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentWardOfCourtIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentWardOfCourtImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentLegalDependentsIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentLegalDependentsImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentDateOfBirthIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentDateOfBirthImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentMaritalStatusIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentMaritalStatusImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentHouseholdSizeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentHouseholdSizeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentNumberInCollegeSizeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentNumberInCollegeSizeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentStateOfResidenceIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentStateOfResidenceImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentTaxReturnTypeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentTaxReturnTypeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentNumberOfExemptionsIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentNumberOfExemptionsImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentAgiIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentAgiImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentFedTaxPaidIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentFedTaxPaidImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentIncomeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentIncomeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentSpouseIncomeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentSpouseIncomeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentCombatPayIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentCombatPayImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentTaxableAidtIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentTaxableAidImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentCashIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentCashImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentInvestmentNetWorthIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentInvestmentNetWorthImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentBusinessFarmNetWorthIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentVeteranStatusIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentVeteranStatusImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentCitizenStatusIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentCitizenStatusImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentFederalTaxReturnStatusIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentFederalTaxReturnStatusImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentChildSupportReceivedIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentChildSupportReceivedImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentChildSupportPaidIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentChildSupportPaidImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentSpouseDislocatedWorkerIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentSpouseDislocatedWorkerImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentEducationCreditsIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentEducationCreditsImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentHomelessRiskIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentHomelessRiskImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentOrphanFosterWardAfter13Isir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockStudentOrphanFosterWardAfter13Imr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentMaritalStatusIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentMaritalStatusImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentHouseholdSizeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentHouseholdSizeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentNumberInCollegeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentNumberInCollegeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentStateOfResidenceIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentStateOfResidenceImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentTaxReturnTypeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentTaxReturnTypeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentNumberOfExemptionsIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentNumberOfExemptionsImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentAgiIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentAgiImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentFedTaxPaidIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentFedTaxPaidImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockFatherIncomeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockFatherIncomeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockMotherIncomeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockMotherIncomeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentUntaxedIraDistributionIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentUntaxedIraDistributionImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentUntaxedPensionDistributionIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentUntaxedPensionDistributionImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentCashIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentCashImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentInvestmentNetWorthIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentInvestmentNetWorthImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentBusinessFarmNetWorthIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentBusinessFarmNetWorthImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentFederalTaxReturnStatusIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentFederalTaxReturnStatusImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentDateOfBirthIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentDateOfBirthImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentChildSupportReceivedIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentChildSupportReceivedImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentChildSupportPaidIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentChildSupportPaidImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentIraPaymentsIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentIraPaymentsImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentPensionPaymentsIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentPensionPaymentsImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentMilitaryClergyAllowancesIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentMilitaryClergyAllowancesImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockInterestIncomeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockInterestIncomeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentEducationCreditsIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentEducationCreditsImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentDislocatedWorkerIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentDislocatedWorkerImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentCombatPayIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentCombatPayImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentVaNonEducationalBenefitsIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentVaNonEducationalBenefitsImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentOtherUntaxedIncomeIsir" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="LockParentOtherUntaxedIncomeImr" type="{http://INAS.collegeboard.org/2012/Input/}lockType" minOccurs="0"/>
 *         &lt;element name="MigrationDirection" type="{http://INAS.collegeboard.org/2012/Input/}migrationDirectionType" minOccurs="0"/>
 *         &lt;element name="ActualStudentAgi" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ActualParentAgi" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ActualStudentUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ActualParentUntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentAgiUsage" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="UseStudentEfmProjectedYearIncome" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseParentEfmProjectedYearIncome" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="StudentEfmHouseholdSize" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentEfmHouseholdSize" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="StudentEfmNumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ParentEfmNumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OperationalControl" type="{http://INAS.collegeboard.org/2012/Input/}operationalControlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imrExtensionType", propOrder = {
    "dependencyOverride",
    "defaultBudgetDuration",
    "calculateParentContributionForIndependents",
    "skipFamilyMembersOnAge",
    "useStudentProjectedYearIncome",
    "useParentProjectedYearIncome",
    "useStateTaxAllowance",
    "excludeWorkstudyEarnings",
    "excludeTuitionDeduction",
    "maximumTuitionAllowance",
    "studentMedicalAllowancePercent",
    "studentMedicalAllowanceAmount",
    "parentMedicalAllowancePercent",
    "parentMedicalAllowanceAmount",
    "studentEmploymentAllowance",
    "parentEmploymentAllowance",
    "studentFicaAllowance",
    "parentFicaAllowance",
    "studentAdditionalIncomeAllowance",
    "parentAdditionalIncomeAllowance",
    "parentColaIndex",
    "limitInternationalParentIncomeProtectionAllowance",
    "parentIncomeProtectionAllowance",
    "studentFederalTaxPaid",
    "parentFederalTaxPaid",
    "studentCalculatedFederalTaxPaidBehavior",
    "parentCalculatedFederalTaxPaidBehavior",
    "studentProjectedFederalTaxPaid",
    "parentProjectedFederalTaxPaid",
    "studentLocalTaxPaid",
    "parentLocalTaxPaid",
    "studentLocalTaxPercent",
    "parentLocalTaxPercent",
    "addStudentEducationCredit",
    "addParentEducationCredit",
    "independentStudentIncomeAssessmentPercent",
    "allowBusinessFarmLosses",
    "allowOtherLosses",
    "studentAdditionalAssets",
    "parentAdditionalAssets",
    "studentAdditionalAssetAllowance",
    "parentAdditionalAssetAllowance",
    "studentProjectHomeValue",
    "parentProjectHomeValue",
    "studentCapHomeValue",
    "parentCapHomeValue",
    "studentImputeAssets",
    "parentImputeAssets",
    "studentIraKeoghPercent",
    "calculateContributionsFromAssetsUsingCountryCoefficient",
    "studentAssetAssessmentRate",
    "parentAssetAssessmentRate",
    "addStudentAssetsToParentAssets",
    "capStudentHomeEquity",
    "capParentHomeEquity",
    "minimumStudentContributionFromIncome",
    "minimumParentContributionFromIncome",
    "minimumStudentContributionFromAssets",
    "minimumParentContributionFromAssets",
    "priorYearStudentContribution",
    "priorYearParentContribution",
    "imputeStudentContributionPercent",
    "imputeParentContributionPercent",
    "performStudentContributionUsingNewMethodology",
    "limitSiblingShareOfParentContribution",
    "canStudentImFallBelowFm",
    "canParentImFallBelowFm",
    "useNonCustodialParentContribution",
    "studentTotalBudget",
    "studentNumberInCollegeOverride",
    "parentNumberInCollegeOverride",
    "studentHousingMultiplierOverride",
    "parentHousingMultiplierOverride",
    "releaseIsirToImrMigration",
    "releaseImrToIsirMigration",
    "lockIsir",
    "lockImr",
    "lockStudentYearInSchoolIsir",
    "lockStudentYearInSchoolImr",
    "lockStudentWardOfCourtIsir",
    "lockStudentWardOfCourtImr",
    "lockStudentLegalDependentsIsir",
    "lockStudentLegalDependentsImr",
    "lockStudentDateOfBirthIsir",
    "lockStudentDateOfBirthImr",
    "lockStudentMaritalStatusIsir",
    "lockStudentMaritalStatusImr",
    "lockStudentHouseholdSizeIsir",
    "lockStudentHouseholdSizeImr",
    "lockStudentNumberInCollegeSizeIsir",
    "lockStudentNumberInCollegeSizeImr",
    "lockStudentStateOfResidenceIsir",
    "lockStudentStateOfResidenceImr",
    "lockStudentTaxReturnTypeIsir",
    "lockStudentTaxReturnTypeImr",
    "lockStudentNumberOfExemptionsIsir",
    "lockStudentNumberOfExemptionsImr",
    "lockStudentAgiIsir",
    "lockStudentAgiImr",
    "lockStudentFedTaxPaidIsir",
    "lockStudentFedTaxPaidImr",
    "lockStudentIncomeIsir",
    "lockStudentIncomeImr",
    "lockStudentSpouseIncomeIsir",
    "lockStudentSpouseIncomeImr",
    "lockStudentCombatPayIsir",
    "lockStudentCombatPayImr",
    "lockStudentTaxableAidtIsir",
    "lockStudentTaxableAidImr",
    "lockStudentCashIsir",
    "lockStudentCashImr",
    "lockStudentInvestmentNetWorthIsir",
    "lockStudentInvestmentNetWorthImr",
    "lockStudentBusinessFarmNetWorthIsir",
    "lockStudentVeteranStatusIsir",
    "lockStudentVeteranStatusImr",
    "lockStudentCitizenStatusIsir",
    "lockStudentCitizenStatusImr",
    "lockStudentFederalTaxReturnStatusIsir",
    "lockStudentFederalTaxReturnStatusImr",
    "lockStudentChildSupportReceivedIsir",
    "lockStudentChildSupportReceivedImr",
    "lockStudentChildSupportPaidIsir",
    "lockStudentChildSupportPaidImr",
    "lockStudentSpouseDislocatedWorkerIsir",
    "lockStudentSpouseDislocatedWorkerImr",
    "lockStudentEducationCreditsIsir",
    "lockStudentEducationCreditsImr",
    "lockStudentHomelessRiskIsir",
    "lockStudentHomelessRiskImr",
    "lockStudentOrphanFosterWardAfter13Isir",
    "lockStudentOrphanFosterWardAfter13Imr",
    "lockParentMaritalStatusIsir",
    "lockParentMaritalStatusImr",
    "lockParentHouseholdSizeIsir",
    "lockParentHouseholdSizeImr",
    "lockParentNumberInCollegeIsir",
    "lockParentNumberInCollegeImr",
    "lockParentStateOfResidenceIsir",
    "lockParentStateOfResidenceImr",
    "lockParentTaxReturnTypeIsir",
    "lockParentTaxReturnTypeImr",
    "lockParentNumberOfExemptionsIsir",
    "lockParentNumberOfExemptionsImr",
    "lockParentAgiIsir",
    "lockParentAgiImr",
    "lockParentFedTaxPaidIsir",
    "lockParentFedTaxPaidImr",
    "lockFatherIncomeIsir",
    "lockFatherIncomeImr",
    "lockMotherIncomeIsir",
    "lockMotherIncomeImr",
    "lockParentUntaxedIraDistributionIsir",
    "lockParentUntaxedIraDistributionImr",
    "lockParentUntaxedPensionDistributionIsir",
    "lockParentUntaxedPensionDistributionImr",
    "lockParentCashIsir",
    "lockParentCashImr",
    "lockParentInvestmentNetWorthIsir",
    "lockParentInvestmentNetWorthImr",
    "lockParentBusinessFarmNetWorthIsir",
    "lockParentBusinessFarmNetWorthImr",
    "lockParentFederalTaxReturnStatusIsir",
    "lockParentFederalTaxReturnStatusImr",
    "lockParentDateOfBirthIsir",
    "lockParentDateOfBirthImr",
    "lockParentChildSupportReceivedIsir",
    "lockParentChildSupportReceivedImr",
    "lockParentChildSupportPaidIsir",
    "lockParentChildSupportPaidImr",
    "lockParentIraPaymentsIsir",
    "lockParentIraPaymentsImr",
    "lockParentPensionPaymentsIsir",
    "lockParentPensionPaymentsImr",
    "lockParentMilitaryClergyAllowancesIsir",
    "lockParentMilitaryClergyAllowancesImr",
    "lockInterestIncomeIsir",
    "lockInterestIncomeImr",
    "lockParentEducationCreditsIsir",
    "lockParentEducationCreditsImr",
    "lockParentDislocatedWorkerIsir",
    "lockParentDislocatedWorkerImr",
    "lockParentCombatPayIsir",
    "lockParentCombatPayImr",
    "lockParentVaNonEducationalBenefitsIsir",
    "lockParentVaNonEducationalBenefitsImr",
    "lockParentOtherUntaxedIncomeIsir",
    "lockParentOtherUntaxedIncomeImr",
    "migrationDirection",
    "actualStudentAgi",
    "actualParentAgi",
    "actualStudentUntaxedIncome",
    "actualParentUntaxedIncome",
    "parentAgiUsage",
    "useStudentEfmProjectedYearIncome",
    "useParentEfmProjectedYearIncome",
    "studentEfmHouseholdSize",
    "parentEfmHouseholdSize",
    "studentEfmNumberInCollege",
    "parentEfmNumberInCollege",
    "operationalControl"
})
public class ImrExtensionType {

    @XmlElementRef(name = "DependencyOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<DependencyOverrideType> dependencyOverride;
    @XmlElementRef(name = "DefaultBudgetDuration", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> defaultBudgetDuration;
    @XmlElementRef(name = "CalculateParentContributionForIndependents", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> calculateParentContributionForIndependents;
    @XmlElementRef(name = "SkipFamilyMembersOnAge", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> skipFamilyMembersOnAge;
    @XmlElementRef(name = "UseStudentProjectedYearIncome", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useStudentProjectedYearIncome;
    @XmlElementRef(name = "UseParentProjectedYearIncome", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useParentProjectedYearIncome;
    @XmlElementRef(name = "UseStateTaxAllowance", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useStateTaxAllowance;
    @XmlElementRef(name = "ExcludeWorkstudyEarnings", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> excludeWorkstudyEarnings;
    @XmlElementRef(name = "ExcludeTuitionDeduction", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> excludeTuitionDeduction;
    @XmlElement(name = "MaximumTuitionAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maximumTuitionAllowance;
    @XmlElement(name = "StudentMedicalAllowancePercent", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentMedicalAllowancePercent;
    @XmlElement(name = "StudentMedicalAllowanceAmount", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentMedicalAllowanceAmount;
    @XmlElement(name = "ParentMedicalAllowancePercent", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentMedicalAllowancePercent;
    @XmlElement(name = "ParentMedicalAllowanceAmount", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentMedicalAllowanceAmount;
    @XmlElement(name = "StudentEmploymentAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentEmploymentAllowance;
    @XmlElement(name = "ParentEmploymentAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentEmploymentAllowance;
    @XmlElement(name = "StudentFicaAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentFicaAllowance;
    @XmlElement(name = "ParentFicaAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentFicaAllowance;
    @XmlElement(name = "StudentAdditionalIncomeAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentAdditionalIncomeAllowance;
    @XmlElement(name = "ParentAdditionalIncomeAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentAdditionalIncomeAllowance;
    @XmlElementRef(name = "ParentColaIndex", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentColaIndex;
    @XmlElementRef(name = "LimitInternationalParentIncomeProtectionAllowance", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> limitInternationalParentIncomeProtectionAllowance;
    @XmlElement(name = "ParentIncomeProtectionAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentIncomeProtectionAllowance;
    @XmlElement(name = "StudentFederalTaxPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentFederalTaxPaid;
    @XmlElement(name = "ParentFederalTaxPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentFederalTaxPaid;
    @XmlElement(name = "StudentCalculatedFederalTaxPaidBehavior", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentCalculatedFederalTaxPaidBehavior;
    @XmlElement(name = "ParentCalculatedFederalTaxPaidBehavior", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentCalculatedFederalTaxPaidBehavior;
    @XmlElement(name = "StudentProjectedFederalTaxPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentProjectedFederalTaxPaid;
    @XmlElement(name = "ParentProjectedFederalTaxPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentProjectedFederalTaxPaid;
    @XmlElement(name = "StudentLocalTaxPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentLocalTaxPaid;
    @XmlElement(name = "ParentLocalTaxPaid", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentLocalTaxPaid;
    @XmlElementRef(name = "StudentLocalTaxPercent", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentLocalTaxPercent;
    @XmlElementRef(name = "ParentLocalTaxPercent", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentLocalTaxPercent;
    @XmlElementRef(name = "AddStudentEducationCredit", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> addStudentEducationCredit;
    @XmlElementRef(name = "AddParentEducationCredit", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> addParentEducationCredit;
    @XmlElementRef(name = "IndependentStudentIncomeAssessmentPercent", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> independentStudentIncomeAssessmentPercent;
    @XmlElementRef(name = "AllowBusinessFarmLosses", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> allowBusinessFarmLosses;
    @XmlElementRef(name = "AllowOtherLosses", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> allowOtherLosses;
    @XmlElement(name = "StudentAdditionalAssets", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentAdditionalAssets;
    @XmlElement(name = "ParentAdditionalAssets", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentAdditionalAssets;
    @XmlElement(name = "StudentAdditionalAssetAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentAdditionalAssetAllowance;
    @XmlElement(name = "ParentAdditionalAssetAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentAdditionalAssetAllowance;
    @XmlElement(name = "StudentProjectHomeValue", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentProjectHomeValue;
    @XmlElement(name = "ParentProjectHomeValue", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentProjectHomeValue;
    @XmlElementRef(name = "StudentCapHomeValue", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentCapHomeValue;
    @XmlElementRef(name = "ParentCapHomeValue", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentCapHomeValue;
    @XmlElementRef(name = "StudentImputeAssets", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<StudentImputeAssetsType> studentImputeAssets;
    @XmlElementRef(name = "ParentImputeAssets", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<ParentImputeAssetsType> parentImputeAssets;
    @XmlElementRef(name = "StudentIraKeoghPercent", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentIraKeoghPercent;
    @XmlElementRef(name = "CalculateContributionsFromAssetsUsingCountryCoefficient", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> calculateContributionsFromAssetsUsingCountryCoefficient;
    @XmlElementRef(name = "StudentAssetAssessmentRate", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentAssetAssessmentRate;
    @XmlElementRef(name = "ParentAssetAssessmentRate", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentAssetAssessmentRate;
    @XmlElement(name = "AddStudentAssetsToParentAssets", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long addStudentAssetsToParentAssets;
    @XmlElementRef(name = "CapStudentHomeEquity", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> capStudentHomeEquity;
    @XmlElementRef(name = "CapParentHomeEquity", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> capParentHomeEquity;
    @XmlElement(name = "MinimumStudentContributionFromIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long minimumStudentContributionFromIncome;
    @XmlElement(name = "MinimumParentContributionFromIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long minimumParentContributionFromIncome;
    @XmlElement(name = "MinimumStudentContributionFromAssets", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long minimumStudentContributionFromAssets;
    @XmlElement(name = "MinimumParentContributionFromAssets", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long minimumParentContributionFromAssets;
    @XmlElement(name = "PriorYearStudentContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long priorYearStudentContribution;
    @XmlElement(name = "PriorYearParentContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long priorYearParentContribution;
    @XmlElementRef(name = "ImputeStudentContributionPercent", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> imputeStudentContributionPercent;
    @XmlElementRef(name = "ImputeParentContributionPercent", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> imputeParentContributionPercent;
    @XmlElementRef(name = "PerformStudentContributionUsingNewMethodology", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> performStudentContributionUsingNewMethodology;
    @XmlElementRef(name = "LimitSiblingShareOfParentContribution", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<String> limitSiblingShareOfParentContribution;
    @XmlElementRef(name = "CanStudentImFallBelowFm", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> canStudentImFallBelowFm;
    @XmlElementRef(name = "CanParentImFallBelowFm", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> canParentImFallBelowFm;
    @XmlElementRef(name = "UseNonCustodialParentContribution", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useNonCustodialParentContribution;
    @XmlElement(name = "StudentTotalBudget", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentTotalBudget;
    @XmlElement(name = "StudentNumberInCollegeOverride", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentNumberInCollegeOverride;
    @XmlElement(name = "ParentNumberInCollegeOverride", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentNumberInCollegeOverride;
    @XmlElementRef(name = "StudentHousingMultiplierOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentHousingMultiplierOverride;
    @XmlElementRef(name = "ParentHousingMultiplierOverride", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentHousingMultiplierOverride;
    @XmlElementRef(name = "ReleaseIsirToImrMigration", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<UOrRType> releaseIsirToImrMigration;
    @XmlElementRef(name = "ReleaseImrToIsirMigration", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<UOrRType> releaseImrToIsirMigration;
    @XmlElementRef(name = "LockIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockIsir;
    @XmlElementRef(name = "LockImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockImr;
    @XmlElementRef(name = "LockStudentYearInSchoolIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentYearInSchoolIsir;
    @XmlElementRef(name = "LockStudentYearInSchoolImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentYearInSchoolImr;
    @XmlElementRef(name = "LockStudentWardOfCourtIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentWardOfCourtIsir;
    @XmlElementRef(name = "LockStudentWardOfCourtImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentWardOfCourtImr;
    @XmlElementRef(name = "LockStudentLegalDependentsIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentLegalDependentsIsir;
    @XmlElementRef(name = "LockStudentLegalDependentsImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentLegalDependentsImr;
    @XmlElementRef(name = "LockStudentDateOfBirthIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentDateOfBirthIsir;
    @XmlElementRef(name = "LockStudentDateOfBirthImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentDateOfBirthImr;
    @XmlElementRef(name = "LockStudentMaritalStatusIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentMaritalStatusIsir;
    @XmlElementRef(name = "LockStudentMaritalStatusImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentMaritalStatusImr;
    @XmlElementRef(name = "LockStudentHouseholdSizeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentHouseholdSizeIsir;
    @XmlElementRef(name = "LockStudentHouseholdSizeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentHouseholdSizeImr;
    @XmlElementRef(name = "LockStudentNumberInCollegeSizeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentNumberInCollegeSizeIsir;
    @XmlElementRef(name = "LockStudentNumberInCollegeSizeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentNumberInCollegeSizeImr;
    @XmlElementRef(name = "LockStudentStateOfResidenceIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentStateOfResidenceIsir;
    @XmlElementRef(name = "LockStudentStateOfResidenceImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentStateOfResidenceImr;
    @XmlElementRef(name = "LockStudentTaxReturnTypeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentTaxReturnTypeIsir;
    @XmlElementRef(name = "LockStudentTaxReturnTypeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentTaxReturnTypeImr;
    @XmlElementRef(name = "LockStudentNumberOfExemptionsIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentNumberOfExemptionsIsir;
    @XmlElementRef(name = "LockStudentNumberOfExemptionsImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentNumberOfExemptionsImr;
    @XmlElementRef(name = "LockStudentAgiIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentAgiIsir;
    @XmlElementRef(name = "LockStudentAgiImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentAgiImr;
    @XmlElementRef(name = "LockStudentFedTaxPaidIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentFedTaxPaidIsir;
    @XmlElementRef(name = "LockStudentFedTaxPaidImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentFedTaxPaidImr;
    @XmlElementRef(name = "LockStudentIncomeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentIncomeIsir;
    @XmlElementRef(name = "LockStudentIncomeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentIncomeImr;
    @XmlElementRef(name = "LockStudentSpouseIncomeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentSpouseIncomeIsir;
    @XmlElementRef(name = "LockStudentSpouseIncomeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentSpouseIncomeImr;
    @XmlElementRef(name = "LockStudentCombatPayIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentCombatPayIsir;
    @XmlElementRef(name = "LockStudentCombatPayImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentCombatPayImr;
    @XmlElementRef(name = "LockStudentTaxableAidtIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentTaxableAidtIsir;
    @XmlElementRef(name = "LockStudentTaxableAidImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentTaxableAidImr;
    @XmlElementRef(name = "LockStudentCashIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentCashIsir;
    @XmlElementRef(name = "LockStudentCashImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentCashImr;
    @XmlElementRef(name = "LockStudentInvestmentNetWorthIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentInvestmentNetWorthIsir;
    @XmlElementRef(name = "LockStudentInvestmentNetWorthImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentInvestmentNetWorthImr;
    @XmlElementRef(name = "LockStudentBusinessFarmNetWorthIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentBusinessFarmNetWorthIsir;
    @XmlElementRef(name = "LockStudentVeteranStatusIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentVeteranStatusIsir;
    @XmlElementRef(name = "LockStudentVeteranStatusImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentVeteranStatusImr;
    @XmlElementRef(name = "LockStudentCitizenStatusIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentCitizenStatusIsir;
    @XmlElementRef(name = "LockStudentCitizenStatusImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentCitizenStatusImr;
    @XmlElementRef(name = "LockStudentFederalTaxReturnStatusIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentFederalTaxReturnStatusIsir;
    @XmlElementRef(name = "LockStudentFederalTaxReturnStatusImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentFederalTaxReturnStatusImr;
    @XmlElementRef(name = "LockStudentChildSupportReceivedIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentChildSupportReceivedIsir;
    @XmlElementRef(name = "LockStudentChildSupportReceivedImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentChildSupportReceivedImr;
    @XmlElementRef(name = "LockStudentChildSupportPaidIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentChildSupportPaidIsir;
    @XmlElementRef(name = "LockStudentChildSupportPaidImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentChildSupportPaidImr;
    @XmlElementRef(name = "LockStudentSpouseDislocatedWorkerIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentSpouseDislocatedWorkerIsir;
    @XmlElementRef(name = "LockStudentSpouseDislocatedWorkerImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentSpouseDislocatedWorkerImr;
    @XmlElementRef(name = "LockStudentEducationCreditsIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentEducationCreditsIsir;
    @XmlElementRef(name = "LockStudentEducationCreditsImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentEducationCreditsImr;
    @XmlElementRef(name = "LockStudentHomelessRiskIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentHomelessRiskIsir;
    @XmlElementRef(name = "LockStudentHomelessRiskImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentHomelessRiskImr;
    @XmlElementRef(name = "LockStudentOrphanFosterWardAfter13Isir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentOrphanFosterWardAfter13Isir;
    @XmlElementRef(name = "LockStudentOrphanFosterWardAfter13Imr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockStudentOrphanFosterWardAfter13Imr;
    @XmlElementRef(name = "LockParentMaritalStatusIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentMaritalStatusIsir;
    @XmlElementRef(name = "LockParentMaritalStatusImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentMaritalStatusImr;
    @XmlElementRef(name = "LockParentHouseholdSizeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentHouseholdSizeIsir;
    @XmlElementRef(name = "LockParentHouseholdSizeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentHouseholdSizeImr;
    @XmlElementRef(name = "LockParentNumberInCollegeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentNumberInCollegeIsir;
    @XmlElementRef(name = "LockParentNumberInCollegeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentNumberInCollegeImr;
    @XmlElementRef(name = "LockParentStateOfResidenceIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentStateOfResidenceIsir;
    @XmlElementRef(name = "LockParentStateOfResidenceImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentStateOfResidenceImr;
    @XmlElementRef(name = "LockParentTaxReturnTypeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentTaxReturnTypeIsir;
    @XmlElementRef(name = "LockParentTaxReturnTypeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentTaxReturnTypeImr;
    @XmlElementRef(name = "LockParentNumberOfExemptionsIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentNumberOfExemptionsIsir;
    @XmlElementRef(name = "LockParentNumberOfExemptionsImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentNumberOfExemptionsImr;
    @XmlElementRef(name = "LockParentAgiIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentAgiIsir;
    @XmlElementRef(name = "LockParentAgiImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentAgiImr;
    @XmlElementRef(name = "LockParentFedTaxPaidIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentFedTaxPaidIsir;
    @XmlElementRef(name = "LockParentFedTaxPaidImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentFedTaxPaidImr;
    @XmlElementRef(name = "LockFatherIncomeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockFatherIncomeIsir;
    @XmlElementRef(name = "LockFatherIncomeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockFatherIncomeImr;
    @XmlElementRef(name = "LockMotherIncomeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockMotherIncomeIsir;
    @XmlElementRef(name = "LockMotherIncomeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockMotherIncomeImr;
    @XmlElementRef(name = "LockParentUntaxedIraDistributionIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentUntaxedIraDistributionIsir;
    @XmlElementRef(name = "LockParentUntaxedIraDistributionImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentUntaxedIraDistributionImr;
    @XmlElementRef(name = "LockParentUntaxedPensionDistributionIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentUntaxedPensionDistributionIsir;
    @XmlElementRef(name = "LockParentUntaxedPensionDistributionImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentUntaxedPensionDistributionImr;
    @XmlElementRef(name = "LockParentCashIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentCashIsir;
    @XmlElementRef(name = "LockParentCashImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentCashImr;
    @XmlElementRef(name = "LockParentInvestmentNetWorthIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentInvestmentNetWorthIsir;
    @XmlElementRef(name = "LockParentInvestmentNetWorthImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentInvestmentNetWorthImr;
    @XmlElementRef(name = "LockParentBusinessFarmNetWorthIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentBusinessFarmNetWorthIsir;
    @XmlElementRef(name = "LockParentBusinessFarmNetWorthImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentBusinessFarmNetWorthImr;
    @XmlElementRef(name = "LockParentFederalTaxReturnStatusIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentFederalTaxReturnStatusIsir;
    @XmlElementRef(name = "LockParentFederalTaxReturnStatusImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentFederalTaxReturnStatusImr;
    @XmlElementRef(name = "LockParentDateOfBirthIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentDateOfBirthIsir;
    @XmlElementRef(name = "LockParentDateOfBirthImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentDateOfBirthImr;
    @XmlElementRef(name = "LockParentChildSupportReceivedIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentChildSupportReceivedIsir;
    @XmlElementRef(name = "LockParentChildSupportReceivedImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentChildSupportReceivedImr;
    @XmlElementRef(name = "LockParentChildSupportPaidIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentChildSupportPaidIsir;
    @XmlElementRef(name = "LockParentChildSupportPaidImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentChildSupportPaidImr;
    @XmlElementRef(name = "LockParentIraPaymentsIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentIraPaymentsIsir;
    @XmlElementRef(name = "LockParentIraPaymentsImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentIraPaymentsImr;
    @XmlElementRef(name = "LockParentPensionPaymentsIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentPensionPaymentsIsir;
    @XmlElementRef(name = "LockParentPensionPaymentsImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentPensionPaymentsImr;
    @XmlElementRef(name = "LockParentMilitaryClergyAllowancesIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentMilitaryClergyAllowancesIsir;
    @XmlElementRef(name = "LockParentMilitaryClergyAllowancesImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentMilitaryClergyAllowancesImr;
    @XmlElementRef(name = "LockInterestIncomeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockInterestIncomeIsir;
    @XmlElementRef(name = "LockInterestIncomeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockInterestIncomeImr;
    @XmlElementRef(name = "LockParentEducationCreditsIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentEducationCreditsIsir;
    @XmlElementRef(name = "LockParentEducationCreditsImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentEducationCreditsImr;
    @XmlElementRef(name = "LockParentDislocatedWorkerIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentDislocatedWorkerIsir;
    @XmlElementRef(name = "LockParentDislocatedWorkerImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentDislocatedWorkerImr;
    @XmlElementRef(name = "LockParentCombatPayIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentCombatPayIsir;
    @XmlElementRef(name = "LockParentCombatPayImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentCombatPayImr;
    @XmlElementRef(name = "LockParentVaNonEducationalBenefitsIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentVaNonEducationalBenefitsIsir;
    @XmlElementRef(name = "LockParentVaNonEducationalBenefitsImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentVaNonEducationalBenefitsImr;
    @XmlElementRef(name = "LockParentOtherUntaxedIncomeIsir", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentOtherUntaxedIncomeIsir;
    @XmlElementRef(name = "LockParentOtherUntaxedIncomeImr", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<LockType> lockParentOtherUntaxedIncomeImr;
    @XmlElementRef(name = "MigrationDirection", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<MigrationDirectionType> migrationDirection;
    @XmlElement(name = "ActualStudentAgi", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long actualStudentAgi;
    @XmlElement(name = "ActualParentAgi", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long actualParentAgi;
    @XmlElement(name = "ActualStudentUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long actualStudentUntaxedIncome;
    @XmlElement(name = "ActualParentUntaxedIncome", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long actualParentUntaxedIncome;
    @XmlElement(name = "ParentAgiUsage", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentAgiUsage;
    @XmlElementRef(name = "UseStudentEfmProjectedYearIncome", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useStudentEfmProjectedYearIncome;
    @XmlElementRef(name = "UseParentEfmProjectedYearIncome", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useParentEfmProjectedYearIncome;
    @XmlElement(name = "StudentEfmHouseholdSize", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentEfmHouseholdSize;
    @XmlElement(name = "ParentEfmHouseholdSize", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentEfmHouseholdSize;
    @XmlElement(name = "StudentEfmNumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long studentEfmNumberInCollege;
    @XmlElement(name = "ParentEfmNumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long parentEfmNumberInCollege;
    @XmlElementRef(name = "OperationalControl", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<OperationalControlType> operationalControl;

    /**
     * Gets the value of the dependencyOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DependencyOverrideType }{@code >}
     *     
     */
    public JAXBElement<DependencyOverrideType> getDependencyOverride() {
        return dependencyOverride;
    }

    /**
     * Sets the value of the dependencyOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DependencyOverrideType }{@code >}
     *     
     */
    public void setDependencyOverride(JAXBElement<DependencyOverrideType> value) {
        this.dependencyOverride = ((JAXBElement<DependencyOverrideType> ) value);
    }

    /**
     * Gets the value of the defaultBudgetDuration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDefaultBudgetDuration() {
        return defaultBudgetDuration;
    }

    /**
     * Sets the value of the defaultBudgetDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDefaultBudgetDuration(JAXBElement<BigDecimal> value) {
        this.defaultBudgetDuration = ((JAXBElement<BigDecimal> ) value);
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
     * Gets the value of the skipFamilyMembersOnAge property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getSkipFamilyMembersOnAge() {
        return skipFamilyMembersOnAge;
    }

    /**
     * Sets the value of the skipFamilyMembersOnAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setSkipFamilyMembersOnAge(JAXBElement<YesNoType> value) {
        this.skipFamilyMembersOnAge = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useStudentProjectedYearIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseStudentProjectedYearIncome() {
        return useStudentProjectedYearIncome;
    }

    /**
     * Sets the value of the useStudentProjectedYearIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseStudentProjectedYearIncome(JAXBElement<YesNoType> value) {
        this.useStudentProjectedYearIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useParentProjectedYearIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseParentProjectedYearIncome() {
        return useParentProjectedYearIncome;
    }

    /**
     * Sets the value of the useParentProjectedYearIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseParentProjectedYearIncome(JAXBElement<YesNoType> value) {
        this.useParentProjectedYearIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useStateTaxAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseStateTaxAllowance() {
        return useStateTaxAllowance;
    }

    /**
     * Sets the value of the useStateTaxAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseStateTaxAllowance(JAXBElement<YesNoType> value) {
        this.useStateTaxAllowance = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the excludeWorkstudyEarnings property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getExcludeWorkstudyEarnings() {
        return excludeWorkstudyEarnings;
    }

    /**
     * Sets the value of the excludeWorkstudyEarnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setExcludeWorkstudyEarnings(JAXBElement<YesNoType> value) {
        this.excludeWorkstudyEarnings = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the excludeTuitionDeduction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getExcludeTuitionDeduction() {
        return excludeTuitionDeduction;
    }

    /**
     * Sets the value of the excludeTuitionDeduction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setExcludeTuitionDeduction(JAXBElement<YesNoType> value) {
        this.excludeTuitionDeduction = ((JAXBElement<YesNoType> ) value);
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
     *     {@link Long }
     *     
     */
    public Long getStudentMedicalAllowancePercent() {
        return studentMedicalAllowancePercent;
    }

    /**
     * Sets the value of the studentMedicalAllowancePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentMedicalAllowancePercent(Long value) {
        this.studentMedicalAllowancePercent = value;
    }

    /**
     * Gets the value of the studentMedicalAllowanceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentMedicalAllowanceAmount() {
        return studentMedicalAllowanceAmount;
    }

    /**
     * Sets the value of the studentMedicalAllowanceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentMedicalAllowanceAmount(Long value) {
        this.studentMedicalAllowanceAmount = value;
    }

    /**
     * Gets the value of the parentMedicalAllowancePercent property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentMedicalAllowancePercent() {
        return parentMedicalAllowancePercent;
    }

    /**
     * Sets the value of the parentMedicalAllowancePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentMedicalAllowancePercent(Long value) {
        this.parentMedicalAllowancePercent = value;
    }

    /**
     * Gets the value of the parentMedicalAllowanceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentMedicalAllowanceAmount() {
        return parentMedicalAllowanceAmount;
    }

    /**
     * Sets the value of the parentMedicalAllowanceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentMedicalAllowanceAmount(Long value) {
        this.parentMedicalAllowanceAmount = value;
    }

    /**
     * Gets the value of the studentEmploymentAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentEmploymentAllowance() {
        return studentEmploymentAllowance;
    }

    /**
     * Sets the value of the studentEmploymentAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentEmploymentAllowance(Long value) {
        this.studentEmploymentAllowance = value;
    }

    /**
     * Gets the value of the parentEmploymentAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentEmploymentAllowance() {
        return parentEmploymentAllowance;
    }

    /**
     * Sets the value of the parentEmploymentAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentEmploymentAllowance(Long value) {
        this.parentEmploymentAllowance = value;
    }

    /**
     * Gets the value of the studentFicaAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentFicaAllowance() {
        return studentFicaAllowance;
    }

    /**
     * Sets the value of the studentFicaAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentFicaAllowance(Long value) {
        this.studentFicaAllowance = value;
    }

    /**
     * Gets the value of the parentFicaAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentFicaAllowance() {
        return parentFicaAllowance;
    }

    /**
     * Sets the value of the parentFicaAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentFicaAllowance(Long value) {
        this.parentFicaAllowance = value;
    }

    /**
     * Gets the value of the studentAdditionalIncomeAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentAdditionalIncomeAllowance() {
        return studentAdditionalIncomeAllowance;
    }

    /**
     * Sets the value of the studentAdditionalIncomeAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentAdditionalIncomeAllowance(Long value) {
        this.studentAdditionalIncomeAllowance = value;
    }

    /**
     * Gets the value of the parentAdditionalIncomeAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentAdditionalIncomeAllowance() {
        return parentAdditionalIncomeAllowance;
    }

    /**
     * Sets the value of the parentAdditionalIncomeAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentAdditionalIncomeAllowance(Long value) {
        this.parentAdditionalIncomeAllowance = value;
    }

    /**
     * Gets the value of the parentColaIndex property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentColaIndex() {
        return parentColaIndex;
    }

    /**
     * Sets the value of the parentColaIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentColaIndex(JAXBElement<BigDecimal> value) {
        this.parentColaIndex = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the limitInternationalParentIncomeProtectionAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getLimitInternationalParentIncomeProtectionAllowance() {
        return limitInternationalParentIncomeProtectionAllowance;
    }

    /**
     * Sets the value of the limitInternationalParentIncomeProtectionAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setLimitInternationalParentIncomeProtectionAllowance(JAXBElement<YesNoType> value) {
        this.limitInternationalParentIncomeProtectionAllowance = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the parentIncomeProtectionAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentIncomeProtectionAllowance() {
        return parentIncomeProtectionAllowance;
    }

    /**
     * Sets the value of the parentIncomeProtectionAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentIncomeProtectionAllowance(Long value) {
        this.parentIncomeProtectionAllowance = value;
    }

    /**
     * Gets the value of the studentFederalTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentFederalTaxPaid() {
        return studentFederalTaxPaid;
    }

    /**
     * Sets the value of the studentFederalTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentFederalTaxPaid(Long value) {
        this.studentFederalTaxPaid = value;
    }

    /**
     * Gets the value of the parentFederalTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentFederalTaxPaid() {
        return parentFederalTaxPaid;
    }

    /**
     * Sets the value of the parentFederalTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentFederalTaxPaid(Long value) {
        this.parentFederalTaxPaid = value;
    }

    /**
     * Gets the value of the studentCalculatedFederalTaxPaidBehavior property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentCalculatedFederalTaxPaidBehavior() {
        return studentCalculatedFederalTaxPaidBehavior;
    }

    /**
     * Sets the value of the studentCalculatedFederalTaxPaidBehavior property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentCalculatedFederalTaxPaidBehavior(Long value) {
        this.studentCalculatedFederalTaxPaidBehavior = value;
    }

    /**
     * Gets the value of the parentCalculatedFederalTaxPaidBehavior property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentCalculatedFederalTaxPaidBehavior() {
        return parentCalculatedFederalTaxPaidBehavior;
    }

    /**
     * Sets the value of the parentCalculatedFederalTaxPaidBehavior property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentCalculatedFederalTaxPaidBehavior(Long value) {
        this.parentCalculatedFederalTaxPaidBehavior = value;
    }

    /**
     * Gets the value of the studentProjectedFederalTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentProjectedFederalTaxPaid() {
        return studentProjectedFederalTaxPaid;
    }

    /**
     * Sets the value of the studentProjectedFederalTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentProjectedFederalTaxPaid(Long value) {
        this.studentProjectedFederalTaxPaid = value;
    }

    /**
     * Gets the value of the parentProjectedFederalTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentProjectedFederalTaxPaid() {
        return parentProjectedFederalTaxPaid;
    }

    /**
     * Sets the value of the parentProjectedFederalTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentProjectedFederalTaxPaid(Long value) {
        this.parentProjectedFederalTaxPaid = value;
    }

    /**
     * Gets the value of the studentLocalTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentLocalTaxPaid() {
        return studentLocalTaxPaid;
    }

    /**
     * Sets the value of the studentLocalTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentLocalTaxPaid(Long value) {
        this.studentLocalTaxPaid = value;
    }

    /**
     * Gets the value of the parentLocalTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentLocalTaxPaid() {
        return parentLocalTaxPaid;
    }

    /**
     * Sets the value of the parentLocalTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentLocalTaxPaid(Long value) {
        this.parentLocalTaxPaid = value;
    }

    /**
     * Gets the value of the studentLocalTaxPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentLocalTaxPercent() {
        return studentLocalTaxPercent;
    }

    /**
     * Sets the value of the studentLocalTaxPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentLocalTaxPercent(JAXBElement<BigDecimal> value) {
        this.studentLocalTaxPercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentLocalTaxPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentLocalTaxPercent() {
        return parentLocalTaxPercent;
    }

    /**
     * Sets the value of the parentLocalTaxPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentLocalTaxPercent(JAXBElement<BigDecimal> value) {
        this.parentLocalTaxPercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the addStudentEducationCredit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAddStudentEducationCredit() {
        return addStudentEducationCredit;
    }

    /**
     * Sets the value of the addStudentEducationCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAddStudentEducationCredit(JAXBElement<YesNoType> value) {
        this.addStudentEducationCredit = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the addParentEducationCredit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAddParentEducationCredit() {
        return addParentEducationCredit;
    }

    /**
     * Sets the value of the addParentEducationCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAddParentEducationCredit(JAXBElement<YesNoType> value) {
        this.addParentEducationCredit = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the independentStudentIncomeAssessmentPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getIndependentStudentIncomeAssessmentPercent() {
        return independentStudentIncomeAssessmentPercent;
    }

    /**
     * Sets the value of the independentStudentIncomeAssessmentPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setIndependentStudentIncomeAssessmentPercent(JAXBElement<BigDecimal> value) {
        this.independentStudentIncomeAssessmentPercent = ((JAXBElement<BigDecimal> ) value);
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
     * Gets the value of the studentAdditionalAssets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentAdditionalAssets() {
        return studentAdditionalAssets;
    }

    /**
     * Sets the value of the studentAdditionalAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentAdditionalAssets(Long value) {
        this.studentAdditionalAssets = value;
    }

    /**
     * Gets the value of the parentAdditionalAssets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentAdditionalAssets() {
        return parentAdditionalAssets;
    }

    /**
     * Sets the value of the parentAdditionalAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentAdditionalAssets(Long value) {
        this.parentAdditionalAssets = value;
    }

    /**
     * Gets the value of the studentAdditionalAssetAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentAdditionalAssetAllowance() {
        return studentAdditionalAssetAllowance;
    }

    /**
     * Sets the value of the studentAdditionalAssetAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentAdditionalAssetAllowance(Long value) {
        this.studentAdditionalAssetAllowance = value;
    }

    /**
     * Gets the value of the parentAdditionalAssetAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentAdditionalAssetAllowance() {
        return parentAdditionalAssetAllowance;
    }

    /**
     * Sets the value of the parentAdditionalAssetAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentAdditionalAssetAllowance(Long value) {
        this.parentAdditionalAssetAllowance = value;
    }

    /**
     * Gets the value of the studentProjectHomeValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentProjectHomeValue() {
        return studentProjectHomeValue;
    }

    /**
     * Sets the value of the studentProjectHomeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentProjectHomeValue(Long value) {
        this.studentProjectHomeValue = value;
    }

    /**
     * Gets the value of the parentProjectHomeValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentProjectHomeValue() {
        return parentProjectHomeValue;
    }

    /**
     * Sets the value of the parentProjectHomeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentProjectHomeValue(Long value) {
        this.parentProjectHomeValue = value;
    }

    /**
     * Gets the value of the studentCapHomeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentCapHomeValue() {
        return studentCapHomeValue;
    }

    /**
     * Sets the value of the studentCapHomeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentCapHomeValue(JAXBElement<BigDecimal> value) {
        this.studentCapHomeValue = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentCapHomeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentCapHomeValue() {
        return parentCapHomeValue;
    }

    /**
     * Sets the value of the parentCapHomeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentCapHomeValue(JAXBElement<BigDecimal> value) {
        this.parentCapHomeValue = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the studentImputeAssets property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StudentImputeAssetsType }{@code >}
     *     
     */
    public JAXBElement<StudentImputeAssetsType> getStudentImputeAssets() {
        return studentImputeAssets;
    }

    /**
     * Sets the value of the studentImputeAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StudentImputeAssetsType }{@code >}
     *     
     */
    public void setStudentImputeAssets(JAXBElement<StudentImputeAssetsType> value) {
        this.studentImputeAssets = ((JAXBElement<StudentImputeAssetsType> ) value);
    }

    /**
     * Gets the value of the parentImputeAssets property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ParentImputeAssetsType }{@code >}
     *     
     */
    public JAXBElement<ParentImputeAssetsType> getParentImputeAssets() {
        return parentImputeAssets;
    }

    /**
     * Sets the value of the parentImputeAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ParentImputeAssetsType }{@code >}
     *     
     */
    public void setParentImputeAssets(JAXBElement<ParentImputeAssetsType> value) {
        this.parentImputeAssets = ((JAXBElement<ParentImputeAssetsType> ) value);
    }

    /**
     * Gets the value of the studentIraKeoghPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentIraKeoghPercent() {
        return studentIraKeoghPercent;
    }

    /**
     * Sets the value of the studentIraKeoghPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentIraKeoghPercent(JAXBElement<BigDecimal> value) {
        this.studentIraKeoghPercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the calculateContributionsFromAssetsUsingCountryCoefficient property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCalculateContributionsFromAssetsUsingCountryCoefficient() {
        return calculateContributionsFromAssetsUsingCountryCoefficient;
    }

    /**
     * Sets the value of the calculateContributionsFromAssetsUsingCountryCoefficient property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCalculateContributionsFromAssetsUsingCountryCoefficient(JAXBElement<YesNoType> value) {
        this.calculateContributionsFromAssetsUsingCountryCoefficient = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the studentAssetAssessmentRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentAssetAssessmentRate() {
        return studentAssetAssessmentRate;
    }

    /**
     * Sets the value of the studentAssetAssessmentRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentAssetAssessmentRate(JAXBElement<BigDecimal> value) {
        this.studentAssetAssessmentRate = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentAssetAssessmentRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentAssetAssessmentRate() {
        return parentAssetAssessmentRate;
    }

    /**
     * Sets the value of the parentAssetAssessmentRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentAssetAssessmentRate(JAXBElement<BigDecimal> value) {
        this.parentAssetAssessmentRate = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the addStudentAssetsToParentAssets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAddStudentAssetsToParentAssets() {
        return addStudentAssetsToParentAssets;
    }

    /**
     * Sets the value of the addStudentAssetsToParentAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAddStudentAssetsToParentAssets(Long value) {
        this.addStudentAssetsToParentAssets = value;
    }

    /**
     * Gets the value of the capStudentHomeEquity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCapStudentHomeEquity() {
        return capStudentHomeEquity;
    }

    /**
     * Sets the value of the capStudentHomeEquity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCapStudentHomeEquity(JAXBElement<BigDecimal> value) {
        this.capStudentHomeEquity = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the capParentHomeEquity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCapParentHomeEquity() {
        return capParentHomeEquity;
    }

    /**
     * Sets the value of the capParentHomeEquity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCapParentHomeEquity(JAXBElement<BigDecimal> value) {
        this.capParentHomeEquity = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the minimumStudentContributionFromIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinimumStudentContributionFromIncome() {
        return minimumStudentContributionFromIncome;
    }

    /**
     * Sets the value of the minimumStudentContributionFromIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinimumStudentContributionFromIncome(Long value) {
        this.minimumStudentContributionFromIncome = value;
    }

    /**
     * Gets the value of the minimumParentContributionFromIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinimumParentContributionFromIncome() {
        return minimumParentContributionFromIncome;
    }

    /**
     * Sets the value of the minimumParentContributionFromIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinimumParentContributionFromIncome(Long value) {
        this.minimumParentContributionFromIncome = value;
    }

    /**
     * Gets the value of the minimumStudentContributionFromAssets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinimumStudentContributionFromAssets() {
        return minimumStudentContributionFromAssets;
    }

    /**
     * Sets the value of the minimumStudentContributionFromAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinimumStudentContributionFromAssets(Long value) {
        this.minimumStudentContributionFromAssets = value;
    }

    /**
     * Gets the value of the minimumParentContributionFromAssets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinimumParentContributionFromAssets() {
        return minimumParentContributionFromAssets;
    }

    /**
     * Sets the value of the minimumParentContributionFromAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinimumParentContributionFromAssets(Long value) {
        this.minimumParentContributionFromAssets = value;
    }

    /**
     * Gets the value of the priorYearStudentContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriorYearStudentContribution() {
        return priorYearStudentContribution;
    }

    /**
     * Sets the value of the priorYearStudentContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriorYearStudentContribution(Long value) {
        this.priorYearStudentContribution = value;
    }

    /**
     * Gets the value of the priorYearParentContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriorYearParentContribution() {
        return priorYearParentContribution;
    }

    /**
     * Sets the value of the priorYearParentContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriorYearParentContribution(Long value) {
        this.priorYearParentContribution = value;
    }

    /**
     * Gets the value of the imputeStudentContributionPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getImputeStudentContributionPercent() {
        return imputeStudentContributionPercent;
    }

    /**
     * Sets the value of the imputeStudentContributionPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setImputeStudentContributionPercent(JAXBElement<BigDecimal> value) {
        this.imputeStudentContributionPercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the imputeParentContributionPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getImputeParentContributionPercent() {
        return imputeParentContributionPercent;
    }

    /**
     * Sets the value of the imputeParentContributionPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setImputeParentContributionPercent(JAXBElement<BigDecimal> value) {
        this.imputeParentContributionPercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the performStudentContributionUsingNewMethodology property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getPerformStudentContributionUsingNewMethodology() {
        return performStudentContributionUsingNewMethodology;
    }

    /**
     * Sets the value of the performStudentContributionUsingNewMethodology property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setPerformStudentContributionUsingNewMethodology(JAXBElement<YesNoType> value) {
        this.performStudentContributionUsingNewMethodology = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the limitSiblingShareOfParentContribution property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLimitSiblingShareOfParentContribution() {
        return limitSiblingShareOfParentContribution;
    }

    /**
     * Sets the value of the limitSiblingShareOfParentContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLimitSiblingShareOfParentContribution(JAXBElement<String> value) {
        this.limitSiblingShareOfParentContribution = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the canStudentImFallBelowFm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCanStudentImFallBelowFm() {
        return canStudentImFallBelowFm;
    }

    /**
     * Sets the value of the canStudentImFallBelowFm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCanStudentImFallBelowFm(JAXBElement<YesNoType> value) {
        this.canStudentImFallBelowFm = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the canParentImFallBelowFm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCanParentImFallBelowFm() {
        return canParentImFallBelowFm;
    }

    /**
     * Sets the value of the canParentImFallBelowFm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCanParentImFallBelowFm(JAXBElement<YesNoType> value) {
        this.canParentImFallBelowFm = ((JAXBElement<YesNoType> ) value);
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
     * Gets the value of the studentTotalBudget property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentTotalBudget() {
        return studentTotalBudget;
    }

    /**
     * Sets the value of the studentTotalBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentTotalBudget(Long value) {
        this.studentTotalBudget = value;
    }

    /**
     * Gets the value of the studentNumberInCollegeOverride property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentNumberInCollegeOverride() {
        return studentNumberInCollegeOverride;
    }

    /**
     * Sets the value of the studentNumberInCollegeOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentNumberInCollegeOverride(Long value) {
        this.studentNumberInCollegeOverride = value;
    }

    /**
     * Gets the value of the parentNumberInCollegeOverride property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentNumberInCollegeOverride() {
        return parentNumberInCollegeOverride;
    }

    /**
     * Sets the value of the parentNumberInCollegeOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentNumberInCollegeOverride(Long value) {
        this.parentNumberInCollegeOverride = value;
    }

    /**
     * Gets the value of the studentHousingMultiplierOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentHousingMultiplierOverride() {
        return studentHousingMultiplierOverride;
    }

    /**
     * Sets the value of the studentHousingMultiplierOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentHousingMultiplierOverride(JAXBElement<BigDecimal> value) {
        this.studentHousingMultiplierOverride = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentHousingMultiplierOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentHousingMultiplierOverride() {
        return parentHousingMultiplierOverride;
    }

    /**
     * Sets the value of the parentHousingMultiplierOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentHousingMultiplierOverride(JAXBElement<BigDecimal> value) {
        this.parentHousingMultiplierOverride = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the releaseIsirToImrMigration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UOrRType }{@code >}
     *     
     */
    public JAXBElement<UOrRType> getReleaseIsirToImrMigration() {
        return releaseIsirToImrMigration;
    }

    /**
     * Sets the value of the releaseIsirToImrMigration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UOrRType }{@code >}
     *     
     */
    public void setReleaseIsirToImrMigration(JAXBElement<UOrRType> value) {
        this.releaseIsirToImrMigration = ((JAXBElement<UOrRType> ) value);
    }

    /**
     * Gets the value of the releaseImrToIsirMigration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UOrRType }{@code >}
     *     
     */
    public JAXBElement<UOrRType> getReleaseImrToIsirMigration() {
        return releaseImrToIsirMigration;
    }

    /**
     * Sets the value of the releaseImrToIsirMigration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UOrRType }{@code >}
     *     
     */
    public void setReleaseImrToIsirMigration(JAXBElement<UOrRType> value) {
        this.releaseImrToIsirMigration = ((JAXBElement<UOrRType> ) value);
    }

    /**
     * Gets the value of the lockIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockIsir() {
        return lockIsir;
    }

    /**
     * Sets the value of the lockIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockIsir(JAXBElement<LockType> value) {
        this.lockIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockImr() {
        return lockImr;
    }

    /**
     * Sets the value of the lockImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockImr(JAXBElement<LockType> value) {
        this.lockImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentYearInSchoolIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentYearInSchoolIsir() {
        return lockStudentYearInSchoolIsir;
    }

    /**
     * Sets the value of the lockStudentYearInSchoolIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentYearInSchoolIsir(JAXBElement<LockType> value) {
        this.lockStudentYearInSchoolIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentYearInSchoolImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentYearInSchoolImr() {
        return lockStudentYearInSchoolImr;
    }

    /**
     * Sets the value of the lockStudentYearInSchoolImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentYearInSchoolImr(JAXBElement<LockType> value) {
        this.lockStudentYearInSchoolImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentWardOfCourtIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentWardOfCourtIsir() {
        return lockStudentWardOfCourtIsir;
    }

    /**
     * Sets the value of the lockStudentWardOfCourtIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentWardOfCourtIsir(JAXBElement<LockType> value) {
        this.lockStudentWardOfCourtIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentWardOfCourtImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentWardOfCourtImr() {
        return lockStudentWardOfCourtImr;
    }

    /**
     * Sets the value of the lockStudentWardOfCourtImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentWardOfCourtImr(JAXBElement<LockType> value) {
        this.lockStudentWardOfCourtImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentLegalDependentsIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentLegalDependentsIsir() {
        return lockStudentLegalDependentsIsir;
    }

    /**
     * Sets the value of the lockStudentLegalDependentsIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentLegalDependentsIsir(JAXBElement<LockType> value) {
        this.lockStudentLegalDependentsIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentLegalDependentsImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentLegalDependentsImr() {
        return lockStudentLegalDependentsImr;
    }

    /**
     * Sets the value of the lockStudentLegalDependentsImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentLegalDependentsImr(JAXBElement<LockType> value) {
        this.lockStudentLegalDependentsImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentDateOfBirthIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentDateOfBirthIsir() {
        return lockStudentDateOfBirthIsir;
    }

    /**
     * Sets the value of the lockStudentDateOfBirthIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentDateOfBirthIsir(JAXBElement<LockType> value) {
        this.lockStudentDateOfBirthIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentDateOfBirthImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentDateOfBirthImr() {
        return lockStudentDateOfBirthImr;
    }

    /**
     * Sets the value of the lockStudentDateOfBirthImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentDateOfBirthImr(JAXBElement<LockType> value) {
        this.lockStudentDateOfBirthImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentMaritalStatusIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentMaritalStatusIsir() {
        return lockStudentMaritalStatusIsir;
    }

    /**
     * Sets the value of the lockStudentMaritalStatusIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentMaritalStatusIsir(JAXBElement<LockType> value) {
        this.lockStudentMaritalStatusIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentMaritalStatusImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentMaritalStatusImr() {
        return lockStudentMaritalStatusImr;
    }

    /**
     * Sets the value of the lockStudentMaritalStatusImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentMaritalStatusImr(JAXBElement<LockType> value) {
        this.lockStudentMaritalStatusImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentHouseholdSizeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentHouseholdSizeIsir() {
        return lockStudentHouseholdSizeIsir;
    }

    /**
     * Sets the value of the lockStudentHouseholdSizeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentHouseholdSizeIsir(JAXBElement<LockType> value) {
        this.lockStudentHouseholdSizeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentHouseholdSizeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentHouseholdSizeImr() {
        return lockStudentHouseholdSizeImr;
    }

    /**
     * Sets the value of the lockStudentHouseholdSizeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentHouseholdSizeImr(JAXBElement<LockType> value) {
        this.lockStudentHouseholdSizeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentNumberInCollegeSizeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentNumberInCollegeSizeIsir() {
        return lockStudentNumberInCollegeSizeIsir;
    }

    /**
     * Sets the value of the lockStudentNumberInCollegeSizeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentNumberInCollegeSizeIsir(JAXBElement<LockType> value) {
        this.lockStudentNumberInCollegeSizeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentNumberInCollegeSizeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentNumberInCollegeSizeImr() {
        return lockStudentNumberInCollegeSizeImr;
    }

    /**
     * Sets the value of the lockStudentNumberInCollegeSizeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentNumberInCollegeSizeImr(JAXBElement<LockType> value) {
        this.lockStudentNumberInCollegeSizeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentStateOfResidenceIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentStateOfResidenceIsir() {
        return lockStudentStateOfResidenceIsir;
    }

    /**
     * Sets the value of the lockStudentStateOfResidenceIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentStateOfResidenceIsir(JAXBElement<LockType> value) {
        this.lockStudentStateOfResidenceIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentStateOfResidenceImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentStateOfResidenceImr() {
        return lockStudentStateOfResidenceImr;
    }

    /**
     * Sets the value of the lockStudentStateOfResidenceImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentStateOfResidenceImr(JAXBElement<LockType> value) {
        this.lockStudentStateOfResidenceImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentTaxReturnTypeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentTaxReturnTypeIsir() {
        return lockStudentTaxReturnTypeIsir;
    }

    /**
     * Sets the value of the lockStudentTaxReturnTypeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentTaxReturnTypeIsir(JAXBElement<LockType> value) {
        this.lockStudentTaxReturnTypeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentTaxReturnTypeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentTaxReturnTypeImr() {
        return lockStudentTaxReturnTypeImr;
    }

    /**
     * Sets the value of the lockStudentTaxReturnTypeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentTaxReturnTypeImr(JAXBElement<LockType> value) {
        this.lockStudentTaxReturnTypeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentNumberOfExemptionsIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentNumberOfExemptionsIsir() {
        return lockStudentNumberOfExemptionsIsir;
    }

    /**
     * Sets the value of the lockStudentNumberOfExemptionsIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentNumberOfExemptionsIsir(JAXBElement<LockType> value) {
        this.lockStudentNumberOfExemptionsIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentNumberOfExemptionsImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentNumberOfExemptionsImr() {
        return lockStudentNumberOfExemptionsImr;
    }

    /**
     * Sets the value of the lockStudentNumberOfExemptionsImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentNumberOfExemptionsImr(JAXBElement<LockType> value) {
        this.lockStudentNumberOfExemptionsImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentAgiIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentAgiIsir() {
        return lockStudentAgiIsir;
    }

    /**
     * Sets the value of the lockStudentAgiIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentAgiIsir(JAXBElement<LockType> value) {
        this.lockStudentAgiIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentAgiImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentAgiImr() {
        return lockStudentAgiImr;
    }

    /**
     * Sets the value of the lockStudentAgiImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentAgiImr(JAXBElement<LockType> value) {
        this.lockStudentAgiImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentFedTaxPaidIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentFedTaxPaidIsir() {
        return lockStudentFedTaxPaidIsir;
    }

    /**
     * Sets the value of the lockStudentFedTaxPaidIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentFedTaxPaidIsir(JAXBElement<LockType> value) {
        this.lockStudentFedTaxPaidIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentFedTaxPaidImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentFedTaxPaidImr() {
        return lockStudentFedTaxPaidImr;
    }

    /**
     * Sets the value of the lockStudentFedTaxPaidImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentFedTaxPaidImr(JAXBElement<LockType> value) {
        this.lockStudentFedTaxPaidImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentIncomeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentIncomeIsir() {
        return lockStudentIncomeIsir;
    }

    /**
     * Sets the value of the lockStudentIncomeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentIncomeIsir(JAXBElement<LockType> value) {
        this.lockStudentIncomeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentIncomeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentIncomeImr() {
        return lockStudentIncomeImr;
    }

    /**
     * Sets the value of the lockStudentIncomeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentIncomeImr(JAXBElement<LockType> value) {
        this.lockStudentIncomeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentSpouseIncomeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentSpouseIncomeIsir() {
        return lockStudentSpouseIncomeIsir;
    }

    /**
     * Sets the value of the lockStudentSpouseIncomeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentSpouseIncomeIsir(JAXBElement<LockType> value) {
        this.lockStudentSpouseIncomeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentSpouseIncomeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentSpouseIncomeImr() {
        return lockStudentSpouseIncomeImr;
    }

    /**
     * Sets the value of the lockStudentSpouseIncomeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentSpouseIncomeImr(JAXBElement<LockType> value) {
        this.lockStudentSpouseIncomeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentCombatPayIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentCombatPayIsir() {
        return lockStudentCombatPayIsir;
    }

    /**
     * Sets the value of the lockStudentCombatPayIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentCombatPayIsir(JAXBElement<LockType> value) {
        this.lockStudentCombatPayIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentCombatPayImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentCombatPayImr() {
        return lockStudentCombatPayImr;
    }

    /**
     * Sets the value of the lockStudentCombatPayImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentCombatPayImr(JAXBElement<LockType> value) {
        this.lockStudentCombatPayImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentTaxableAidtIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentTaxableAidtIsir() {
        return lockStudentTaxableAidtIsir;
    }

    /**
     * Sets the value of the lockStudentTaxableAidtIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentTaxableAidtIsir(JAXBElement<LockType> value) {
        this.lockStudentTaxableAidtIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentTaxableAidImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentTaxableAidImr() {
        return lockStudentTaxableAidImr;
    }

    /**
     * Sets the value of the lockStudentTaxableAidImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentTaxableAidImr(JAXBElement<LockType> value) {
        this.lockStudentTaxableAidImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentCashIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentCashIsir() {
        return lockStudentCashIsir;
    }

    /**
     * Sets the value of the lockStudentCashIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentCashIsir(JAXBElement<LockType> value) {
        this.lockStudentCashIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentCashImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentCashImr() {
        return lockStudentCashImr;
    }

    /**
     * Sets the value of the lockStudentCashImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentCashImr(JAXBElement<LockType> value) {
        this.lockStudentCashImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentInvestmentNetWorthIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentInvestmentNetWorthIsir() {
        return lockStudentInvestmentNetWorthIsir;
    }

    /**
     * Sets the value of the lockStudentInvestmentNetWorthIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentInvestmentNetWorthIsir(JAXBElement<LockType> value) {
        this.lockStudentInvestmentNetWorthIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentInvestmentNetWorthImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentInvestmentNetWorthImr() {
        return lockStudentInvestmentNetWorthImr;
    }

    /**
     * Sets the value of the lockStudentInvestmentNetWorthImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentInvestmentNetWorthImr(JAXBElement<LockType> value) {
        this.lockStudentInvestmentNetWorthImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentBusinessFarmNetWorthIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentBusinessFarmNetWorthIsir() {
        return lockStudentBusinessFarmNetWorthIsir;
    }

    /**
     * Sets the value of the lockStudentBusinessFarmNetWorthIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentBusinessFarmNetWorthIsir(JAXBElement<LockType> value) {
        this.lockStudentBusinessFarmNetWorthIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentVeteranStatusIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentVeteranStatusIsir() {
        return lockStudentVeteranStatusIsir;
    }

    /**
     * Sets the value of the lockStudentVeteranStatusIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentVeteranStatusIsir(JAXBElement<LockType> value) {
        this.lockStudentVeteranStatusIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentVeteranStatusImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentVeteranStatusImr() {
        return lockStudentVeteranStatusImr;
    }

    /**
     * Sets the value of the lockStudentVeteranStatusImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentVeteranStatusImr(JAXBElement<LockType> value) {
        this.lockStudentVeteranStatusImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentCitizenStatusIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentCitizenStatusIsir() {
        return lockStudentCitizenStatusIsir;
    }

    /**
     * Sets the value of the lockStudentCitizenStatusIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentCitizenStatusIsir(JAXBElement<LockType> value) {
        this.lockStudentCitizenStatusIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentCitizenStatusImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentCitizenStatusImr() {
        return lockStudentCitizenStatusImr;
    }

    /**
     * Sets the value of the lockStudentCitizenStatusImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentCitizenStatusImr(JAXBElement<LockType> value) {
        this.lockStudentCitizenStatusImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentFederalTaxReturnStatusIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentFederalTaxReturnStatusIsir() {
        return lockStudentFederalTaxReturnStatusIsir;
    }

    /**
     * Sets the value of the lockStudentFederalTaxReturnStatusIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentFederalTaxReturnStatusIsir(JAXBElement<LockType> value) {
        this.lockStudentFederalTaxReturnStatusIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentFederalTaxReturnStatusImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentFederalTaxReturnStatusImr() {
        return lockStudentFederalTaxReturnStatusImr;
    }

    /**
     * Sets the value of the lockStudentFederalTaxReturnStatusImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentFederalTaxReturnStatusImr(JAXBElement<LockType> value) {
        this.lockStudentFederalTaxReturnStatusImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentChildSupportReceivedIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentChildSupportReceivedIsir() {
        return lockStudentChildSupportReceivedIsir;
    }

    /**
     * Sets the value of the lockStudentChildSupportReceivedIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentChildSupportReceivedIsir(JAXBElement<LockType> value) {
        this.lockStudentChildSupportReceivedIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentChildSupportReceivedImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentChildSupportReceivedImr() {
        return lockStudentChildSupportReceivedImr;
    }

    /**
     * Sets the value of the lockStudentChildSupportReceivedImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentChildSupportReceivedImr(JAXBElement<LockType> value) {
        this.lockStudentChildSupportReceivedImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentChildSupportPaidIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentChildSupportPaidIsir() {
        return lockStudentChildSupportPaidIsir;
    }

    /**
     * Sets the value of the lockStudentChildSupportPaidIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentChildSupportPaidIsir(JAXBElement<LockType> value) {
        this.lockStudentChildSupportPaidIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentChildSupportPaidImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentChildSupportPaidImr() {
        return lockStudentChildSupportPaidImr;
    }

    /**
     * Sets the value of the lockStudentChildSupportPaidImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentChildSupportPaidImr(JAXBElement<LockType> value) {
        this.lockStudentChildSupportPaidImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentSpouseDislocatedWorkerIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentSpouseDislocatedWorkerIsir() {
        return lockStudentSpouseDislocatedWorkerIsir;
    }

    /**
     * Sets the value of the lockStudentSpouseDislocatedWorkerIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentSpouseDislocatedWorkerIsir(JAXBElement<LockType> value) {
        this.lockStudentSpouseDislocatedWorkerIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentSpouseDislocatedWorkerImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentSpouseDislocatedWorkerImr() {
        return lockStudentSpouseDislocatedWorkerImr;
    }

    /**
     * Sets the value of the lockStudentSpouseDislocatedWorkerImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentSpouseDislocatedWorkerImr(JAXBElement<LockType> value) {
        this.lockStudentSpouseDislocatedWorkerImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentEducationCreditsIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentEducationCreditsIsir() {
        return lockStudentEducationCreditsIsir;
    }

    /**
     * Sets the value of the lockStudentEducationCreditsIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentEducationCreditsIsir(JAXBElement<LockType> value) {
        this.lockStudentEducationCreditsIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentEducationCreditsImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentEducationCreditsImr() {
        return lockStudentEducationCreditsImr;
    }

    /**
     * Sets the value of the lockStudentEducationCreditsImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentEducationCreditsImr(JAXBElement<LockType> value) {
        this.lockStudentEducationCreditsImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentHomelessRiskIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentHomelessRiskIsir() {
        return lockStudentHomelessRiskIsir;
    }

    /**
     * Sets the value of the lockStudentHomelessRiskIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentHomelessRiskIsir(JAXBElement<LockType> value) {
        this.lockStudentHomelessRiskIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentHomelessRiskImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentHomelessRiskImr() {
        return lockStudentHomelessRiskImr;
    }

    /**
     * Sets the value of the lockStudentHomelessRiskImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentHomelessRiskImr(JAXBElement<LockType> value) {
        this.lockStudentHomelessRiskImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentOrphanFosterWardAfter13Isir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentOrphanFosterWardAfter13Isir() {
        return lockStudentOrphanFosterWardAfter13Isir;
    }

    /**
     * Sets the value of the lockStudentOrphanFosterWardAfter13Isir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentOrphanFosterWardAfter13Isir(JAXBElement<LockType> value) {
        this.lockStudentOrphanFosterWardAfter13Isir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockStudentOrphanFosterWardAfter13Imr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockStudentOrphanFosterWardAfter13Imr() {
        return lockStudentOrphanFosterWardAfter13Imr;
    }

    /**
     * Sets the value of the lockStudentOrphanFosterWardAfter13Imr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockStudentOrphanFosterWardAfter13Imr(JAXBElement<LockType> value) {
        this.lockStudentOrphanFosterWardAfter13Imr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentMaritalStatusIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentMaritalStatusIsir() {
        return lockParentMaritalStatusIsir;
    }

    /**
     * Sets the value of the lockParentMaritalStatusIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentMaritalStatusIsir(JAXBElement<LockType> value) {
        this.lockParentMaritalStatusIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentMaritalStatusImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentMaritalStatusImr() {
        return lockParentMaritalStatusImr;
    }

    /**
     * Sets the value of the lockParentMaritalStatusImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentMaritalStatusImr(JAXBElement<LockType> value) {
        this.lockParentMaritalStatusImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentHouseholdSizeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentHouseholdSizeIsir() {
        return lockParentHouseholdSizeIsir;
    }

    /**
     * Sets the value of the lockParentHouseholdSizeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentHouseholdSizeIsir(JAXBElement<LockType> value) {
        this.lockParentHouseholdSizeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentHouseholdSizeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentHouseholdSizeImr() {
        return lockParentHouseholdSizeImr;
    }

    /**
     * Sets the value of the lockParentHouseholdSizeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentHouseholdSizeImr(JAXBElement<LockType> value) {
        this.lockParentHouseholdSizeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentNumberInCollegeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentNumberInCollegeIsir() {
        return lockParentNumberInCollegeIsir;
    }

    /**
     * Sets the value of the lockParentNumberInCollegeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentNumberInCollegeIsir(JAXBElement<LockType> value) {
        this.lockParentNumberInCollegeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentNumberInCollegeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentNumberInCollegeImr() {
        return lockParentNumberInCollegeImr;
    }

    /**
     * Sets the value of the lockParentNumberInCollegeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentNumberInCollegeImr(JAXBElement<LockType> value) {
        this.lockParentNumberInCollegeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentStateOfResidenceIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentStateOfResidenceIsir() {
        return lockParentStateOfResidenceIsir;
    }

    /**
     * Sets the value of the lockParentStateOfResidenceIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentStateOfResidenceIsir(JAXBElement<LockType> value) {
        this.lockParentStateOfResidenceIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentStateOfResidenceImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentStateOfResidenceImr() {
        return lockParentStateOfResidenceImr;
    }

    /**
     * Sets the value of the lockParentStateOfResidenceImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentStateOfResidenceImr(JAXBElement<LockType> value) {
        this.lockParentStateOfResidenceImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentTaxReturnTypeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentTaxReturnTypeIsir() {
        return lockParentTaxReturnTypeIsir;
    }

    /**
     * Sets the value of the lockParentTaxReturnTypeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentTaxReturnTypeIsir(JAXBElement<LockType> value) {
        this.lockParentTaxReturnTypeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentTaxReturnTypeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentTaxReturnTypeImr() {
        return lockParentTaxReturnTypeImr;
    }

    /**
     * Sets the value of the lockParentTaxReturnTypeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentTaxReturnTypeImr(JAXBElement<LockType> value) {
        this.lockParentTaxReturnTypeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentNumberOfExemptionsIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentNumberOfExemptionsIsir() {
        return lockParentNumberOfExemptionsIsir;
    }

    /**
     * Sets the value of the lockParentNumberOfExemptionsIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentNumberOfExemptionsIsir(JAXBElement<LockType> value) {
        this.lockParentNumberOfExemptionsIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentNumberOfExemptionsImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentNumberOfExemptionsImr() {
        return lockParentNumberOfExemptionsImr;
    }

    /**
     * Sets the value of the lockParentNumberOfExemptionsImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentNumberOfExemptionsImr(JAXBElement<LockType> value) {
        this.lockParentNumberOfExemptionsImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentAgiIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentAgiIsir() {
        return lockParentAgiIsir;
    }

    /**
     * Sets the value of the lockParentAgiIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentAgiIsir(JAXBElement<LockType> value) {
        this.lockParentAgiIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentAgiImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentAgiImr() {
        return lockParentAgiImr;
    }

    /**
     * Sets the value of the lockParentAgiImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentAgiImr(JAXBElement<LockType> value) {
        this.lockParentAgiImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentFedTaxPaidIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentFedTaxPaidIsir() {
        return lockParentFedTaxPaidIsir;
    }

    /**
     * Sets the value of the lockParentFedTaxPaidIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentFedTaxPaidIsir(JAXBElement<LockType> value) {
        this.lockParentFedTaxPaidIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentFedTaxPaidImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentFedTaxPaidImr() {
        return lockParentFedTaxPaidImr;
    }

    /**
     * Sets the value of the lockParentFedTaxPaidImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentFedTaxPaidImr(JAXBElement<LockType> value) {
        this.lockParentFedTaxPaidImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockFatherIncomeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockFatherIncomeIsir() {
        return lockFatherIncomeIsir;
    }

    /**
     * Sets the value of the lockFatherIncomeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockFatherIncomeIsir(JAXBElement<LockType> value) {
        this.lockFatherIncomeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockFatherIncomeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockFatherIncomeImr() {
        return lockFatherIncomeImr;
    }

    /**
     * Sets the value of the lockFatherIncomeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockFatherIncomeImr(JAXBElement<LockType> value) {
        this.lockFatherIncomeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockMotherIncomeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockMotherIncomeIsir() {
        return lockMotherIncomeIsir;
    }

    /**
     * Sets the value of the lockMotherIncomeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockMotherIncomeIsir(JAXBElement<LockType> value) {
        this.lockMotherIncomeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockMotherIncomeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockMotherIncomeImr() {
        return lockMotherIncomeImr;
    }

    /**
     * Sets the value of the lockMotherIncomeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockMotherIncomeImr(JAXBElement<LockType> value) {
        this.lockMotherIncomeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentUntaxedIraDistributionIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentUntaxedIraDistributionIsir() {
        return lockParentUntaxedIraDistributionIsir;
    }

    /**
     * Sets the value of the lockParentUntaxedIraDistributionIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentUntaxedIraDistributionIsir(JAXBElement<LockType> value) {
        this.lockParentUntaxedIraDistributionIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentUntaxedIraDistributionImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentUntaxedIraDistributionImr() {
        return lockParentUntaxedIraDistributionImr;
    }

    /**
     * Sets the value of the lockParentUntaxedIraDistributionImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentUntaxedIraDistributionImr(JAXBElement<LockType> value) {
        this.lockParentUntaxedIraDistributionImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentUntaxedPensionDistributionIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentUntaxedPensionDistributionIsir() {
        return lockParentUntaxedPensionDistributionIsir;
    }

    /**
     * Sets the value of the lockParentUntaxedPensionDistributionIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentUntaxedPensionDistributionIsir(JAXBElement<LockType> value) {
        this.lockParentUntaxedPensionDistributionIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentUntaxedPensionDistributionImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentUntaxedPensionDistributionImr() {
        return lockParentUntaxedPensionDistributionImr;
    }

    /**
     * Sets the value of the lockParentUntaxedPensionDistributionImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentUntaxedPensionDistributionImr(JAXBElement<LockType> value) {
        this.lockParentUntaxedPensionDistributionImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentCashIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentCashIsir() {
        return lockParentCashIsir;
    }

    /**
     * Sets the value of the lockParentCashIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentCashIsir(JAXBElement<LockType> value) {
        this.lockParentCashIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentCashImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentCashImr() {
        return lockParentCashImr;
    }

    /**
     * Sets the value of the lockParentCashImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentCashImr(JAXBElement<LockType> value) {
        this.lockParentCashImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentInvestmentNetWorthIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentInvestmentNetWorthIsir() {
        return lockParentInvestmentNetWorthIsir;
    }

    /**
     * Sets the value of the lockParentInvestmentNetWorthIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentInvestmentNetWorthIsir(JAXBElement<LockType> value) {
        this.lockParentInvestmentNetWorthIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentInvestmentNetWorthImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentInvestmentNetWorthImr() {
        return lockParentInvestmentNetWorthImr;
    }

    /**
     * Sets the value of the lockParentInvestmentNetWorthImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentInvestmentNetWorthImr(JAXBElement<LockType> value) {
        this.lockParentInvestmentNetWorthImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentBusinessFarmNetWorthIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentBusinessFarmNetWorthIsir() {
        return lockParentBusinessFarmNetWorthIsir;
    }

    /**
     * Sets the value of the lockParentBusinessFarmNetWorthIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentBusinessFarmNetWorthIsir(JAXBElement<LockType> value) {
        this.lockParentBusinessFarmNetWorthIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentBusinessFarmNetWorthImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentBusinessFarmNetWorthImr() {
        return lockParentBusinessFarmNetWorthImr;
    }

    /**
     * Sets the value of the lockParentBusinessFarmNetWorthImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentBusinessFarmNetWorthImr(JAXBElement<LockType> value) {
        this.lockParentBusinessFarmNetWorthImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentFederalTaxReturnStatusIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentFederalTaxReturnStatusIsir() {
        return lockParentFederalTaxReturnStatusIsir;
    }

    /**
     * Sets the value of the lockParentFederalTaxReturnStatusIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentFederalTaxReturnStatusIsir(JAXBElement<LockType> value) {
        this.lockParentFederalTaxReturnStatusIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentFederalTaxReturnStatusImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentFederalTaxReturnStatusImr() {
        return lockParentFederalTaxReturnStatusImr;
    }

    /**
     * Sets the value of the lockParentFederalTaxReturnStatusImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentFederalTaxReturnStatusImr(JAXBElement<LockType> value) {
        this.lockParentFederalTaxReturnStatusImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentDateOfBirthIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentDateOfBirthIsir() {
        return lockParentDateOfBirthIsir;
    }

    /**
     * Sets the value of the lockParentDateOfBirthIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentDateOfBirthIsir(JAXBElement<LockType> value) {
        this.lockParentDateOfBirthIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentDateOfBirthImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentDateOfBirthImr() {
        return lockParentDateOfBirthImr;
    }

    /**
     * Sets the value of the lockParentDateOfBirthImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentDateOfBirthImr(JAXBElement<LockType> value) {
        this.lockParentDateOfBirthImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentChildSupportReceivedIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentChildSupportReceivedIsir() {
        return lockParentChildSupportReceivedIsir;
    }

    /**
     * Sets the value of the lockParentChildSupportReceivedIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentChildSupportReceivedIsir(JAXBElement<LockType> value) {
        this.lockParentChildSupportReceivedIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentChildSupportReceivedImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentChildSupportReceivedImr() {
        return lockParentChildSupportReceivedImr;
    }

    /**
     * Sets the value of the lockParentChildSupportReceivedImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentChildSupportReceivedImr(JAXBElement<LockType> value) {
        this.lockParentChildSupportReceivedImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentChildSupportPaidIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentChildSupportPaidIsir() {
        return lockParentChildSupportPaidIsir;
    }

    /**
     * Sets the value of the lockParentChildSupportPaidIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentChildSupportPaidIsir(JAXBElement<LockType> value) {
        this.lockParentChildSupportPaidIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentChildSupportPaidImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentChildSupportPaidImr() {
        return lockParentChildSupportPaidImr;
    }

    /**
     * Sets the value of the lockParentChildSupportPaidImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentChildSupportPaidImr(JAXBElement<LockType> value) {
        this.lockParentChildSupportPaidImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentIraPaymentsIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentIraPaymentsIsir() {
        return lockParentIraPaymentsIsir;
    }

    /**
     * Sets the value of the lockParentIraPaymentsIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentIraPaymentsIsir(JAXBElement<LockType> value) {
        this.lockParentIraPaymentsIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentIraPaymentsImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentIraPaymentsImr() {
        return lockParentIraPaymentsImr;
    }

    /**
     * Sets the value of the lockParentIraPaymentsImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentIraPaymentsImr(JAXBElement<LockType> value) {
        this.lockParentIraPaymentsImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentPensionPaymentsIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentPensionPaymentsIsir() {
        return lockParentPensionPaymentsIsir;
    }

    /**
     * Sets the value of the lockParentPensionPaymentsIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentPensionPaymentsIsir(JAXBElement<LockType> value) {
        this.lockParentPensionPaymentsIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentPensionPaymentsImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentPensionPaymentsImr() {
        return lockParentPensionPaymentsImr;
    }

    /**
     * Sets the value of the lockParentPensionPaymentsImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentPensionPaymentsImr(JAXBElement<LockType> value) {
        this.lockParentPensionPaymentsImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentMilitaryClergyAllowancesIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentMilitaryClergyAllowancesIsir() {
        return lockParentMilitaryClergyAllowancesIsir;
    }

    /**
     * Sets the value of the lockParentMilitaryClergyAllowancesIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentMilitaryClergyAllowancesIsir(JAXBElement<LockType> value) {
        this.lockParentMilitaryClergyAllowancesIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentMilitaryClergyAllowancesImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentMilitaryClergyAllowancesImr() {
        return lockParentMilitaryClergyAllowancesImr;
    }

    /**
     * Sets the value of the lockParentMilitaryClergyAllowancesImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentMilitaryClergyAllowancesImr(JAXBElement<LockType> value) {
        this.lockParentMilitaryClergyAllowancesImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockInterestIncomeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockInterestIncomeIsir() {
        return lockInterestIncomeIsir;
    }

    /**
     * Sets the value of the lockInterestIncomeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockInterestIncomeIsir(JAXBElement<LockType> value) {
        this.lockInterestIncomeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockInterestIncomeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockInterestIncomeImr() {
        return lockInterestIncomeImr;
    }

    /**
     * Sets the value of the lockInterestIncomeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockInterestIncomeImr(JAXBElement<LockType> value) {
        this.lockInterestIncomeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentEducationCreditsIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentEducationCreditsIsir() {
        return lockParentEducationCreditsIsir;
    }

    /**
     * Sets the value of the lockParentEducationCreditsIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentEducationCreditsIsir(JAXBElement<LockType> value) {
        this.lockParentEducationCreditsIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentEducationCreditsImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentEducationCreditsImr() {
        return lockParentEducationCreditsImr;
    }

    /**
     * Sets the value of the lockParentEducationCreditsImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentEducationCreditsImr(JAXBElement<LockType> value) {
        this.lockParentEducationCreditsImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentDislocatedWorkerIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentDislocatedWorkerIsir() {
        return lockParentDislocatedWorkerIsir;
    }

    /**
     * Sets the value of the lockParentDislocatedWorkerIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentDislocatedWorkerIsir(JAXBElement<LockType> value) {
        this.lockParentDislocatedWorkerIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentDislocatedWorkerImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentDislocatedWorkerImr() {
        return lockParentDislocatedWorkerImr;
    }

    /**
     * Sets the value of the lockParentDislocatedWorkerImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentDislocatedWorkerImr(JAXBElement<LockType> value) {
        this.lockParentDislocatedWorkerImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentCombatPayIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentCombatPayIsir() {
        return lockParentCombatPayIsir;
    }

    /**
     * Sets the value of the lockParentCombatPayIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentCombatPayIsir(JAXBElement<LockType> value) {
        this.lockParentCombatPayIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentCombatPayImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentCombatPayImr() {
        return lockParentCombatPayImr;
    }

    /**
     * Sets the value of the lockParentCombatPayImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentCombatPayImr(JAXBElement<LockType> value) {
        this.lockParentCombatPayImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentVaNonEducationalBenefitsIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentVaNonEducationalBenefitsIsir() {
        return lockParentVaNonEducationalBenefitsIsir;
    }

    /**
     * Sets the value of the lockParentVaNonEducationalBenefitsIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentVaNonEducationalBenefitsIsir(JAXBElement<LockType> value) {
        this.lockParentVaNonEducationalBenefitsIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentVaNonEducationalBenefitsImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentVaNonEducationalBenefitsImr() {
        return lockParentVaNonEducationalBenefitsImr;
    }

    /**
     * Sets the value of the lockParentVaNonEducationalBenefitsImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentVaNonEducationalBenefitsImr(JAXBElement<LockType> value) {
        this.lockParentVaNonEducationalBenefitsImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentOtherUntaxedIncomeIsir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentOtherUntaxedIncomeIsir() {
        return lockParentOtherUntaxedIncomeIsir;
    }

    /**
     * Sets the value of the lockParentOtherUntaxedIncomeIsir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentOtherUntaxedIncomeIsir(JAXBElement<LockType> value) {
        this.lockParentOtherUntaxedIncomeIsir = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the lockParentOtherUntaxedIncomeImr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public JAXBElement<LockType> getLockParentOtherUntaxedIncomeImr() {
        return lockParentOtherUntaxedIncomeImr;
    }

    /**
     * Sets the value of the lockParentOtherUntaxedIncomeImr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LockType }{@code >}
     *     
     */
    public void setLockParentOtherUntaxedIncomeImr(JAXBElement<LockType> value) {
        this.lockParentOtherUntaxedIncomeImr = ((JAXBElement<LockType> ) value);
    }

    /**
     * Gets the value of the migrationDirection property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MigrationDirectionType }{@code >}
     *     
     */
    public JAXBElement<MigrationDirectionType> getMigrationDirection() {
        return migrationDirection;
    }

    /**
     * Sets the value of the migrationDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MigrationDirectionType }{@code >}
     *     
     */
    public void setMigrationDirection(JAXBElement<MigrationDirectionType> value) {
        this.migrationDirection = ((JAXBElement<MigrationDirectionType> ) value);
    }

    /**
     * Gets the value of the actualStudentAgi property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getActualStudentAgi() {
        return actualStudentAgi;
    }

    /**
     * Sets the value of the actualStudentAgi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setActualStudentAgi(Long value) {
        this.actualStudentAgi = value;
    }

    /**
     * Gets the value of the actualParentAgi property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getActualParentAgi() {
        return actualParentAgi;
    }

    /**
     * Sets the value of the actualParentAgi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setActualParentAgi(Long value) {
        this.actualParentAgi = value;
    }

    /**
     * Gets the value of the actualStudentUntaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getActualStudentUntaxedIncome() {
        return actualStudentUntaxedIncome;
    }

    /**
     * Sets the value of the actualStudentUntaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setActualStudentUntaxedIncome(Long value) {
        this.actualStudentUntaxedIncome = value;
    }

    /**
     * Gets the value of the actualParentUntaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getActualParentUntaxedIncome() {
        return actualParentUntaxedIncome;
    }

    /**
     * Sets the value of the actualParentUntaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setActualParentUntaxedIncome(Long value) {
        this.actualParentUntaxedIncome = value;
    }

    /**
     * Gets the value of the parentAgiUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentAgiUsage() {
        return parentAgiUsage;
    }

    /**
     * Sets the value of the parentAgiUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentAgiUsage(Long value) {
        this.parentAgiUsage = value;
    }

    /**
     * Gets the value of the useStudentEfmProjectedYearIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseStudentEfmProjectedYearIncome() {
        return useStudentEfmProjectedYearIncome;
    }

    /**
     * Sets the value of the useStudentEfmProjectedYearIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseStudentEfmProjectedYearIncome(JAXBElement<YesNoType> value) {
        this.useStudentEfmProjectedYearIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useParentEfmProjectedYearIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseParentEfmProjectedYearIncome() {
        return useParentEfmProjectedYearIncome;
    }

    /**
     * Sets the value of the useParentEfmProjectedYearIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseParentEfmProjectedYearIncome(JAXBElement<YesNoType> value) {
        this.useParentEfmProjectedYearIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the studentEfmHouseholdSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentEfmHouseholdSize() {
        return studentEfmHouseholdSize;
    }

    /**
     * Sets the value of the studentEfmHouseholdSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentEfmHouseholdSize(Long value) {
        this.studentEfmHouseholdSize = value;
    }

    /**
     * Gets the value of the parentEfmHouseholdSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentEfmHouseholdSize() {
        return parentEfmHouseholdSize;
    }

    /**
     * Sets the value of the parentEfmHouseholdSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentEfmHouseholdSize(Long value) {
        this.parentEfmHouseholdSize = value;
    }

    /**
     * Gets the value of the studentEfmNumberInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentEfmNumberInCollege() {
        return studentEfmNumberInCollege;
    }

    /**
     * Sets the value of the studentEfmNumberInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentEfmNumberInCollege(Long value) {
        this.studentEfmNumberInCollege = value;
    }

    /**
     * Gets the value of the parentEfmNumberInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentEfmNumberInCollege() {
        return parentEfmNumberInCollege;
    }

    /**
     * Sets the value of the parentEfmNumberInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentEfmNumberInCollege(Long value) {
        this.parentEfmNumberInCollege = value;
    }

    /**
     * Gets the value of the operationalControl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OperationalControlType }{@code >}
     *     
     */
    public JAXBElement<OperationalControlType> getOperationalControl() {
        return operationalControl;
    }

    /**
     * Sets the value of the operationalControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OperationalControlType }{@code >}
     *     
     */
    public void setOperationalControl(JAXBElement<OperationalControlType> value) {
        this.operationalControl = ((JAXBElement<OperationalControlType> ) value);
    }

}
