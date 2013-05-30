
package org.collegeboard.inas._2012.output;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="ComparisonReport" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MigrationIndicator" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentYearInSchool" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentWardOfCourt" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentLegalDependents" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentDateOfBirth" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentMaritalStatus" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentHouseholdSize" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentNumberInCollegeSize" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentStateOfResidence" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentTaxReturnType" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentNumberOfExemptions" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentAgi" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentFedTaxPaid" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentIncome" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentSpouseIncome" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentCombatPay" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentTaxableAidt" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentCash" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentInvestmentNetWorth" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentBusinessFarmNetWorth" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentVeteranStatus" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentCitizenStatus" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentFederalTaxReturnStatus" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentChildSupportReceived" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentChildSupportPaid" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentSpouseDislocatedWorker" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentEducationCredits" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentHomelessRisk" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedStudentOrphanFosterWardAfter13" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentMaritalStatus" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentHouseholdSize" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentNumberInCollege" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentStateOfResidence" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentTaxReturnType" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentNumberOfExemptions" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentAgi" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentFedTaxPaid" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedFatherIncome" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedMotherIncome" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentUntaxedIraDistribution" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentUntaxedPensionDistribution" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentCash" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentInvestmentNetWorth" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentBusinessFarmNetWorth" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentFederalTaxReturnStatus" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentDateOfBirth" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentChildSupportReceived" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentChildSupportPaid" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentIraPayments" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentPensionPayments" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentMilitaryClergyAllowances" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedInterestIncome" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentEducationCredits" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentDislocatedWorker" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedParentCombatPay" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedVeteranNonEducationBenefits" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="MigratedOtherUntaxedIncome" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
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
    "comparisonReport",
    "migrationIndicator",
    "migratedStudentYearInSchool",
    "migratedStudentWardOfCourt",
    "migratedStudentLegalDependents",
    "migratedStudentDateOfBirth",
    "migratedStudentMaritalStatus",
    "migratedStudentHouseholdSize",
    "migratedStudentNumberInCollegeSize",
    "migratedStudentStateOfResidence",
    "migratedStudentTaxReturnType",
    "migratedStudentNumberOfExemptions",
    "migratedStudentAgi",
    "migratedStudentFedTaxPaid",
    "migratedStudentIncome",
    "migratedStudentSpouseIncome",
    "migratedStudentCombatPay",
    "migratedStudentTaxableAidt",
    "migratedStudentCash",
    "migratedStudentInvestmentNetWorth",
    "migratedStudentBusinessFarmNetWorth",
    "migratedStudentVeteranStatus",
    "migratedStudentCitizenStatus",
    "migratedStudentFederalTaxReturnStatus",
    "migratedStudentChildSupportReceived",
    "migratedStudentChildSupportPaid",
    "migratedStudentSpouseDislocatedWorker",
    "migratedStudentEducationCredits",
    "migratedStudentHomelessRisk",
    "migratedStudentOrphanFosterWardAfter13",
    "migratedParentMaritalStatus",
    "migratedParentHouseholdSize",
    "migratedParentNumberInCollege",
    "migratedParentStateOfResidence",
    "migratedParentTaxReturnType",
    "migratedParentNumberOfExemptions",
    "migratedParentAgi",
    "migratedParentFedTaxPaid",
    "migratedFatherIncome",
    "migratedMotherIncome",
    "migratedParentUntaxedIraDistribution",
    "migratedParentUntaxedPensionDistribution",
    "migratedParentCash",
    "migratedParentInvestmentNetWorth",
    "migratedParentBusinessFarmNetWorth",
    "migratedParentFederalTaxReturnStatus",
    "migratedParentDateOfBirth",
    "migratedParentChildSupportReceived",
    "migratedParentChildSupportPaid",
    "migratedParentIraPayments",
    "migratedParentPensionPayments",
    "migratedParentMilitaryClergyAllowances",
    "migratedInterestIncome",
    "migratedParentEducationCredits",
    "migratedParentDislocatedWorker",
    "migratedParentCombatPay",
    "migratedVeteranNonEducationBenefits",
    "migratedOtherUntaxedIncome"
})
public class ImrExtensionType {

    @XmlElement(name = "ComparisonReport", nillable = true)
    protected List<String> comparisonReport;
    @XmlElementRef(name = "MigrationIndicator", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migrationIndicator;
    @XmlElementRef(name = "MigratedStudentYearInSchool", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentYearInSchool;
    @XmlElementRef(name = "MigratedStudentWardOfCourt", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentWardOfCourt;
    @XmlElementRef(name = "MigratedStudentLegalDependents", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentLegalDependents;
    @XmlElementRef(name = "MigratedStudentDateOfBirth", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentDateOfBirth;
    @XmlElementRef(name = "MigratedStudentMaritalStatus", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentMaritalStatus;
    @XmlElementRef(name = "MigratedStudentHouseholdSize", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentHouseholdSize;
    @XmlElementRef(name = "MigratedStudentNumberInCollegeSize", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentNumberInCollegeSize;
    @XmlElementRef(name = "MigratedStudentStateOfResidence", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentStateOfResidence;
    @XmlElementRef(name = "MigratedStudentTaxReturnType", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentTaxReturnType;
    @XmlElementRef(name = "MigratedStudentNumberOfExemptions", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentNumberOfExemptions;
    @XmlElementRef(name = "MigratedStudentAgi", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentAgi;
    @XmlElementRef(name = "MigratedStudentFedTaxPaid", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentFedTaxPaid;
    @XmlElementRef(name = "MigratedStudentIncome", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentIncome;
    @XmlElementRef(name = "MigratedStudentSpouseIncome", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentSpouseIncome;
    @XmlElementRef(name = "MigratedStudentCombatPay", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentCombatPay;
    @XmlElementRef(name = "MigratedStudentTaxableAidt", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentTaxableAidt;
    @XmlElementRef(name = "MigratedStudentCash", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentCash;
    @XmlElementRef(name = "MigratedStudentInvestmentNetWorth", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentInvestmentNetWorth;
    @XmlElementRef(name = "MigratedStudentBusinessFarmNetWorth", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentBusinessFarmNetWorth;
    @XmlElementRef(name = "MigratedStudentVeteranStatus", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentVeteranStatus;
    @XmlElementRef(name = "MigratedStudentCitizenStatus", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentCitizenStatus;
    @XmlElementRef(name = "MigratedStudentFederalTaxReturnStatus", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentFederalTaxReturnStatus;
    @XmlElementRef(name = "MigratedStudentChildSupportReceived", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentChildSupportReceived;
    @XmlElementRef(name = "MigratedStudentChildSupportPaid", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentChildSupportPaid;
    @XmlElementRef(name = "MigratedStudentSpouseDislocatedWorker", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentSpouseDislocatedWorker;
    @XmlElementRef(name = "MigratedStudentEducationCredits", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentEducationCredits;
    @XmlElementRef(name = "MigratedStudentHomelessRisk", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentHomelessRisk;
    @XmlElementRef(name = "MigratedStudentOrphanFosterWardAfter13", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedStudentOrphanFosterWardAfter13;
    @XmlElementRef(name = "MigratedParentMaritalStatus", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentMaritalStatus;
    @XmlElementRef(name = "MigratedParentHouseholdSize", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentHouseholdSize;
    @XmlElementRef(name = "MigratedParentNumberInCollege", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentNumberInCollege;
    @XmlElementRef(name = "MigratedParentStateOfResidence", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentStateOfResidence;
    @XmlElementRef(name = "MigratedParentTaxReturnType", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentTaxReturnType;
    @XmlElementRef(name = "MigratedParentNumberOfExemptions", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentNumberOfExemptions;
    @XmlElementRef(name = "MigratedParentAgi", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentAgi;
    @XmlElementRef(name = "MigratedParentFedTaxPaid", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentFedTaxPaid;
    @XmlElementRef(name = "MigratedFatherIncome", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedFatherIncome;
    @XmlElementRef(name = "MigratedMotherIncome", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedMotherIncome;
    @XmlElementRef(name = "MigratedParentUntaxedIraDistribution", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentUntaxedIraDistribution;
    @XmlElementRef(name = "MigratedParentUntaxedPensionDistribution", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentUntaxedPensionDistribution;
    @XmlElementRef(name = "MigratedParentCash", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentCash;
    @XmlElementRef(name = "MigratedParentInvestmentNetWorth", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentInvestmentNetWorth;
    @XmlElementRef(name = "MigratedParentBusinessFarmNetWorth", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentBusinessFarmNetWorth;
    @XmlElementRef(name = "MigratedParentFederalTaxReturnStatus", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentFederalTaxReturnStatus;
    @XmlElementRef(name = "MigratedParentDateOfBirth", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentDateOfBirth;
    @XmlElementRef(name = "MigratedParentChildSupportReceived", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentChildSupportReceived;
    @XmlElementRef(name = "MigratedParentChildSupportPaid", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentChildSupportPaid;
    @XmlElementRef(name = "MigratedParentIraPayments", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentIraPayments;
    @XmlElementRef(name = "MigratedParentPensionPayments", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentPensionPayments;
    @XmlElementRef(name = "MigratedParentMilitaryClergyAllowances", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentMilitaryClergyAllowances;
    @XmlElementRef(name = "MigratedInterestIncome", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedInterestIncome;
    @XmlElementRef(name = "MigratedParentEducationCredits", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentEducationCredits;
    @XmlElementRef(name = "MigratedParentDislocatedWorker", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentDislocatedWorker;
    @XmlElementRef(name = "MigratedParentCombatPay", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedParentCombatPay;
    @XmlElementRef(name = "MigratedVeteranNonEducationBenefits", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedVeteranNonEducationBenefits;
    @XmlElementRef(name = "MigratedOtherUntaxedIncome", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> migratedOtherUntaxedIncome;

    /**
     * Gets the value of the comparisonReport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comparisonReport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComparisonReport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getComparisonReport() {
        if (comparisonReport == null) {
            comparisonReport = new ArrayList<String>();
        }
        return this.comparisonReport;
    }

    /**
     * Gets the value of the migrationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigrationIndicator() {
        return migrationIndicator;
    }

    /**
     * Sets the value of the migrationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigrationIndicator(JAXBElement<YesNoType> value) {
        this.migrationIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentYearInSchool property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentYearInSchool() {
        return migratedStudentYearInSchool;
    }

    /**
     * Sets the value of the migratedStudentYearInSchool property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentYearInSchool(JAXBElement<YesNoType> value) {
        this.migratedStudentYearInSchool = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentWardOfCourt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentWardOfCourt() {
        return migratedStudentWardOfCourt;
    }

    /**
     * Sets the value of the migratedStudentWardOfCourt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentWardOfCourt(JAXBElement<YesNoType> value) {
        this.migratedStudentWardOfCourt = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentLegalDependents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentLegalDependents() {
        return migratedStudentLegalDependents;
    }

    /**
     * Sets the value of the migratedStudentLegalDependents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentLegalDependents(JAXBElement<YesNoType> value) {
        this.migratedStudentLegalDependents = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentDateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentDateOfBirth() {
        return migratedStudentDateOfBirth;
    }

    /**
     * Sets the value of the migratedStudentDateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentDateOfBirth(JAXBElement<YesNoType> value) {
        this.migratedStudentDateOfBirth = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentMaritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentMaritalStatus() {
        return migratedStudentMaritalStatus;
    }

    /**
     * Sets the value of the migratedStudentMaritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentMaritalStatus(JAXBElement<YesNoType> value) {
        this.migratedStudentMaritalStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentHouseholdSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentHouseholdSize() {
        return migratedStudentHouseholdSize;
    }

    /**
     * Sets the value of the migratedStudentHouseholdSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentHouseholdSize(JAXBElement<YesNoType> value) {
        this.migratedStudentHouseholdSize = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentNumberInCollegeSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentNumberInCollegeSize() {
        return migratedStudentNumberInCollegeSize;
    }

    /**
     * Sets the value of the migratedStudentNumberInCollegeSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentNumberInCollegeSize(JAXBElement<YesNoType> value) {
        this.migratedStudentNumberInCollegeSize = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentStateOfResidence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentStateOfResidence() {
        return migratedStudentStateOfResidence;
    }

    /**
     * Sets the value of the migratedStudentStateOfResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentStateOfResidence(JAXBElement<YesNoType> value) {
        this.migratedStudentStateOfResidence = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentTaxReturnType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentTaxReturnType() {
        return migratedStudentTaxReturnType;
    }

    /**
     * Sets the value of the migratedStudentTaxReturnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentTaxReturnType(JAXBElement<YesNoType> value) {
        this.migratedStudentTaxReturnType = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentNumberOfExemptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentNumberOfExemptions() {
        return migratedStudentNumberOfExemptions;
    }

    /**
     * Sets the value of the migratedStudentNumberOfExemptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentNumberOfExemptions(JAXBElement<YesNoType> value) {
        this.migratedStudentNumberOfExemptions = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentAgi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentAgi() {
        return migratedStudentAgi;
    }

    /**
     * Sets the value of the migratedStudentAgi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentAgi(JAXBElement<YesNoType> value) {
        this.migratedStudentAgi = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentFedTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentFedTaxPaid() {
        return migratedStudentFedTaxPaid;
    }

    /**
     * Sets the value of the migratedStudentFedTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentFedTaxPaid(JAXBElement<YesNoType> value) {
        this.migratedStudentFedTaxPaid = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentIncome() {
        return migratedStudentIncome;
    }

    /**
     * Sets the value of the migratedStudentIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentIncome(JAXBElement<YesNoType> value) {
        this.migratedStudentIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentSpouseIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentSpouseIncome() {
        return migratedStudentSpouseIncome;
    }

    /**
     * Sets the value of the migratedStudentSpouseIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentSpouseIncome(JAXBElement<YesNoType> value) {
        this.migratedStudentSpouseIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentCombatPay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentCombatPay() {
        return migratedStudentCombatPay;
    }

    /**
     * Sets the value of the migratedStudentCombatPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentCombatPay(JAXBElement<YesNoType> value) {
        this.migratedStudentCombatPay = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentTaxableAidt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentTaxableAidt() {
        return migratedStudentTaxableAidt;
    }

    /**
     * Sets the value of the migratedStudentTaxableAidt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentTaxableAidt(JAXBElement<YesNoType> value) {
        this.migratedStudentTaxableAidt = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentCash property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentCash() {
        return migratedStudentCash;
    }

    /**
     * Sets the value of the migratedStudentCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentCash(JAXBElement<YesNoType> value) {
        this.migratedStudentCash = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentInvestmentNetWorth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentInvestmentNetWorth() {
        return migratedStudentInvestmentNetWorth;
    }

    /**
     * Sets the value of the migratedStudentInvestmentNetWorth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentInvestmentNetWorth(JAXBElement<YesNoType> value) {
        this.migratedStudentInvestmentNetWorth = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentBusinessFarmNetWorth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentBusinessFarmNetWorth() {
        return migratedStudentBusinessFarmNetWorth;
    }

    /**
     * Sets the value of the migratedStudentBusinessFarmNetWorth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentBusinessFarmNetWorth(JAXBElement<YesNoType> value) {
        this.migratedStudentBusinessFarmNetWorth = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentVeteranStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentVeteranStatus() {
        return migratedStudentVeteranStatus;
    }

    /**
     * Sets the value of the migratedStudentVeteranStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentVeteranStatus(JAXBElement<YesNoType> value) {
        this.migratedStudentVeteranStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentCitizenStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentCitizenStatus() {
        return migratedStudentCitizenStatus;
    }

    /**
     * Sets the value of the migratedStudentCitizenStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentCitizenStatus(JAXBElement<YesNoType> value) {
        this.migratedStudentCitizenStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentFederalTaxReturnStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentFederalTaxReturnStatus() {
        return migratedStudentFederalTaxReturnStatus;
    }

    /**
     * Sets the value of the migratedStudentFederalTaxReturnStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentFederalTaxReturnStatus(JAXBElement<YesNoType> value) {
        this.migratedStudentFederalTaxReturnStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentChildSupportReceived property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentChildSupportReceived() {
        return migratedStudentChildSupportReceived;
    }

    /**
     * Sets the value of the migratedStudentChildSupportReceived property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentChildSupportReceived(JAXBElement<YesNoType> value) {
        this.migratedStudentChildSupportReceived = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentChildSupportPaid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentChildSupportPaid() {
        return migratedStudentChildSupportPaid;
    }

    /**
     * Sets the value of the migratedStudentChildSupportPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentChildSupportPaid(JAXBElement<YesNoType> value) {
        this.migratedStudentChildSupportPaid = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentSpouseDislocatedWorker property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentSpouseDislocatedWorker() {
        return migratedStudentSpouseDislocatedWorker;
    }

    /**
     * Sets the value of the migratedStudentSpouseDislocatedWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentSpouseDislocatedWorker(JAXBElement<YesNoType> value) {
        this.migratedStudentSpouseDislocatedWorker = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentEducationCredits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentEducationCredits() {
        return migratedStudentEducationCredits;
    }

    /**
     * Sets the value of the migratedStudentEducationCredits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentEducationCredits(JAXBElement<YesNoType> value) {
        this.migratedStudentEducationCredits = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentHomelessRisk property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentHomelessRisk() {
        return migratedStudentHomelessRisk;
    }

    /**
     * Sets the value of the migratedStudentHomelessRisk property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentHomelessRisk(JAXBElement<YesNoType> value) {
        this.migratedStudentHomelessRisk = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedStudentOrphanFosterWardAfter13 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedStudentOrphanFosterWardAfter13() {
        return migratedStudentOrphanFosterWardAfter13;
    }

    /**
     * Sets the value of the migratedStudentOrphanFosterWardAfter13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedStudentOrphanFosterWardAfter13(JAXBElement<YesNoType> value) {
        this.migratedStudentOrphanFosterWardAfter13 = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentMaritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentMaritalStatus() {
        return migratedParentMaritalStatus;
    }

    /**
     * Sets the value of the migratedParentMaritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentMaritalStatus(JAXBElement<YesNoType> value) {
        this.migratedParentMaritalStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentHouseholdSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentHouseholdSize() {
        return migratedParentHouseholdSize;
    }

    /**
     * Sets the value of the migratedParentHouseholdSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentHouseholdSize(JAXBElement<YesNoType> value) {
        this.migratedParentHouseholdSize = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentNumberInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentNumberInCollege() {
        return migratedParentNumberInCollege;
    }

    /**
     * Sets the value of the migratedParentNumberInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentNumberInCollege(JAXBElement<YesNoType> value) {
        this.migratedParentNumberInCollege = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentStateOfResidence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentStateOfResidence() {
        return migratedParentStateOfResidence;
    }

    /**
     * Sets the value of the migratedParentStateOfResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentStateOfResidence(JAXBElement<YesNoType> value) {
        this.migratedParentStateOfResidence = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentTaxReturnType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentTaxReturnType() {
        return migratedParentTaxReturnType;
    }

    /**
     * Sets the value of the migratedParentTaxReturnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentTaxReturnType(JAXBElement<YesNoType> value) {
        this.migratedParentTaxReturnType = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentNumberOfExemptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentNumberOfExemptions() {
        return migratedParentNumberOfExemptions;
    }

    /**
     * Sets the value of the migratedParentNumberOfExemptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentNumberOfExemptions(JAXBElement<YesNoType> value) {
        this.migratedParentNumberOfExemptions = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentAgi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentAgi() {
        return migratedParentAgi;
    }

    /**
     * Sets the value of the migratedParentAgi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentAgi(JAXBElement<YesNoType> value) {
        this.migratedParentAgi = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentFedTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentFedTaxPaid() {
        return migratedParentFedTaxPaid;
    }

    /**
     * Sets the value of the migratedParentFedTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentFedTaxPaid(JAXBElement<YesNoType> value) {
        this.migratedParentFedTaxPaid = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedFatherIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedFatherIncome() {
        return migratedFatherIncome;
    }

    /**
     * Sets the value of the migratedFatherIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedFatherIncome(JAXBElement<YesNoType> value) {
        this.migratedFatherIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedMotherIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedMotherIncome() {
        return migratedMotherIncome;
    }

    /**
     * Sets the value of the migratedMotherIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedMotherIncome(JAXBElement<YesNoType> value) {
        this.migratedMotherIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentUntaxedIraDistribution property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentUntaxedIraDistribution() {
        return migratedParentUntaxedIraDistribution;
    }

    /**
     * Sets the value of the migratedParentUntaxedIraDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentUntaxedIraDistribution(JAXBElement<YesNoType> value) {
        this.migratedParentUntaxedIraDistribution = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentUntaxedPensionDistribution property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentUntaxedPensionDistribution() {
        return migratedParentUntaxedPensionDistribution;
    }

    /**
     * Sets the value of the migratedParentUntaxedPensionDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentUntaxedPensionDistribution(JAXBElement<YesNoType> value) {
        this.migratedParentUntaxedPensionDistribution = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentCash property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentCash() {
        return migratedParentCash;
    }

    /**
     * Sets the value of the migratedParentCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentCash(JAXBElement<YesNoType> value) {
        this.migratedParentCash = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentInvestmentNetWorth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentInvestmentNetWorth() {
        return migratedParentInvestmentNetWorth;
    }

    /**
     * Sets the value of the migratedParentInvestmentNetWorth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentInvestmentNetWorth(JAXBElement<YesNoType> value) {
        this.migratedParentInvestmentNetWorth = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentBusinessFarmNetWorth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentBusinessFarmNetWorth() {
        return migratedParentBusinessFarmNetWorth;
    }

    /**
     * Sets the value of the migratedParentBusinessFarmNetWorth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentBusinessFarmNetWorth(JAXBElement<YesNoType> value) {
        this.migratedParentBusinessFarmNetWorth = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentFederalTaxReturnStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentFederalTaxReturnStatus() {
        return migratedParentFederalTaxReturnStatus;
    }

    /**
     * Sets the value of the migratedParentFederalTaxReturnStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentFederalTaxReturnStatus(JAXBElement<YesNoType> value) {
        this.migratedParentFederalTaxReturnStatus = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentDateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentDateOfBirth() {
        return migratedParentDateOfBirth;
    }

    /**
     * Sets the value of the migratedParentDateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentDateOfBirth(JAXBElement<YesNoType> value) {
        this.migratedParentDateOfBirth = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentChildSupportReceived property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentChildSupportReceived() {
        return migratedParentChildSupportReceived;
    }

    /**
     * Sets the value of the migratedParentChildSupportReceived property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentChildSupportReceived(JAXBElement<YesNoType> value) {
        this.migratedParentChildSupportReceived = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentChildSupportPaid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentChildSupportPaid() {
        return migratedParentChildSupportPaid;
    }

    /**
     * Sets the value of the migratedParentChildSupportPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentChildSupportPaid(JAXBElement<YesNoType> value) {
        this.migratedParentChildSupportPaid = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentIraPayments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentIraPayments() {
        return migratedParentIraPayments;
    }

    /**
     * Sets the value of the migratedParentIraPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentIraPayments(JAXBElement<YesNoType> value) {
        this.migratedParentIraPayments = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentPensionPayments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentPensionPayments() {
        return migratedParentPensionPayments;
    }

    /**
     * Sets the value of the migratedParentPensionPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentPensionPayments(JAXBElement<YesNoType> value) {
        this.migratedParentPensionPayments = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentMilitaryClergyAllowances property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentMilitaryClergyAllowances() {
        return migratedParentMilitaryClergyAllowances;
    }

    /**
     * Sets the value of the migratedParentMilitaryClergyAllowances property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentMilitaryClergyAllowances(JAXBElement<YesNoType> value) {
        this.migratedParentMilitaryClergyAllowances = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedInterestIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedInterestIncome() {
        return migratedInterestIncome;
    }

    /**
     * Sets the value of the migratedInterestIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedInterestIncome(JAXBElement<YesNoType> value) {
        this.migratedInterestIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentEducationCredits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentEducationCredits() {
        return migratedParentEducationCredits;
    }

    /**
     * Sets the value of the migratedParentEducationCredits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentEducationCredits(JAXBElement<YesNoType> value) {
        this.migratedParentEducationCredits = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentDislocatedWorker property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentDislocatedWorker() {
        return migratedParentDislocatedWorker;
    }

    /**
     * Sets the value of the migratedParentDislocatedWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentDislocatedWorker(JAXBElement<YesNoType> value) {
        this.migratedParentDislocatedWorker = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedParentCombatPay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedParentCombatPay() {
        return migratedParentCombatPay;
    }

    /**
     * Sets the value of the migratedParentCombatPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedParentCombatPay(JAXBElement<YesNoType> value) {
        this.migratedParentCombatPay = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedVeteranNonEducationBenefits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedVeteranNonEducationBenefits() {
        return migratedVeteranNonEducationBenefits;
    }

    /**
     * Sets the value of the migratedVeteranNonEducationBenefits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedVeteranNonEducationBenefits(JAXBElement<YesNoType> value) {
        this.migratedVeteranNonEducationBenefits = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the migratedOtherUntaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getMigratedOtherUntaxedIncome() {
        return migratedOtherUntaxedIncome;
    }

    /**
     * Sets the value of the migratedOtherUntaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setMigratedOtherUntaxedIncome(JAXBElement<YesNoType> value) {
        this.migratedOtherUntaxedIncome = ((JAXBElement<YesNoType> ) value);
    }

}
