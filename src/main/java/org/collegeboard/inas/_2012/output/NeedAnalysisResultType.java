
package org.collegeboard.inas._2012.output;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for needAnalysisResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="needAnalysisResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultType" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="Methodology" type="{http://INAS.collegeboard.org/2012/Output/}methodologyType" minOccurs="0"/>
 *         &lt;element name="AdjustedGrossIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UntaxedIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IncomeAdjustments" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TotalIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="USIncomeTax" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="StateIncomeTax" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FICA" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MedicalDentalExpenses" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrivateTuitionPaid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EmploymentAllowance" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IncomeProtectionAllowance" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OtherAllowance" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TotalAllowances" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CalculatedAvailableIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AvailableIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CashSavingsChecking" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IRAKeogh" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="HomeEquity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RealEstateInvestmentEquity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AdjustedBusinessFarmEquity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ValueOfTrusts" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ValueOfOtherAssets" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NetWorth" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssetProtectionAllowance" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OtherAssetAllowance" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DiscretionaryNetWorth" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ConversionPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IncomeSupplement" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AdjustedAvailableIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TotalContribution" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ImAllocationPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FmNumberInCollegeAllocation" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ContributionForStudent" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ContributionFromIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ContributionFromAssets" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AesaAllowance" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssetsInSiblingsNames" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EmergencyReserveAllowance" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CesaAllowance" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LowIncomeAllowance" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "needAnalysisResultType", propOrder = {
    "resultType",
    "methodology",
    "adjustedGrossIncome",
    "untaxedIncome",
    "incomeAdjustments",
    "totalIncome",
    "usIncomeTax",
    "stateIncomeTax",
    "fica",
    "medicalDentalExpenses",
    "privateTuitionPaid",
    "employmentAllowance",
    "incomeProtectionAllowance",
    "otherAllowance",
    "totalAllowances",
    "calculatedAvailableIncome",
    "availableIncome",
    "cashSavingsChecking",
    "iraKeogh",
    "homeEquity",
    "realEstateInvestmentEquity",
    "adjustedBusinessFarmEquity",
    "valueOfTrusts",
    "valueOfOtherAssets",
    "netWorth",
    "assetProtectionAllowance",
    "otherAssetAllowance",
    "discretionaryNetWorth",
    "conversionPercent",
    "incomeSupplement",
    "adjustedAvailableIncome",
    "totalContribution",
    "imAllocationPercent",
    "fmNumberInCollegeAllocation",
    "contributionForStudent",
    "contributionFromIncome",
    "contributionFromAssets",
    "aesaAllowance",
    "assetsInSiblingsNames",
    "emergencyReserveAllowance",
    "cesaAllowance",
    "lowIncomeAllowance"
})
public class NeedAnalysisResultType {

    @XmlElement(name = "ResultType")
    @XmlSchemaType(name = "unsignedInt")
    protected long resultType;
    @XmlElementRef(name = "Methodology", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<MethodologyType> methodology;
    @XmlElement(name = "AdjustedGrossIncome", required = true, type = Long.class, nillable = true)
    protected Long adjustedGrossIncome;
    @XmlElement(name = "UntaxedIncome", required = true, type = Long.class, nillable = true)
    protected Long untaxedIncome;
    @XmlElement(name = "IncomeAdjustments", required = true, type = Long.class, nillable = true)
    protected Long incomeAdjustments;
    @XmlElement(name = "TotalIncome", required = true, type = Long.class, nillable = true)
    protected Long totalIncome;
    @XmlElement(name = "USIncomeTax", required = true, type = Long.class, nillable = true)
    protected Long usIncomeTax;
    @XmlElement(name = "StateIncomeTax", required = true, type = Long.class, nillable = true)
    protected Long stateIncomeTax;
    @XmlElement(name = "FICA", required = true, type = Long.class, nillable = true)
    protected Long fica;
    @XmlElement(name = "MedicalDentalExpenses", required = true, type = Long.class, nillable = true)
    protected Long medicalDentalExpenses;
    @XmlElement(name = "PrivateTuitionPaid", required = true, type = Long.class, nillable = true)
    protected Long privateTuitionPaid;
    @XmlElement(name = "EmploymentAllowance", required = true, type = Long.class, nillable = true)
    protected Long employmentAllowance;
    @XmlElement(name = "IncomeProtectionAllowance", required = true, type = Long.class, nillable = true)
    protected Long incomeProtectionAllowance;
    @XmlElement(name = "OtherAllowance", required = true, type = Long.class, nillable = true)
    protected Long otherAllowance;
    @XmlElement(name = "TotalAllowances", required = true, type = Long.class, nillable = true)
    protected Long totalAllowances;
    @XmlElement(name = "CalculatedAvailableIncome", required = true, type = Long.class, nillable = true)
    protected Long calculatedAvailableIncome;
    @XmlElement(name = "AvailableIncome", required = true, type = Long.class, nillable = true)
    protected Long availableIncome;
    @XmlElement(name = "CashSavingsChecking", required = true, type = Long.class, nillable = true)
    protected Long cashSavingsChecking;
    @XmlElement(name = "IRAKeogh", required = true, type = Long.class, nillable = true)
    protected Long iraKeogh;
    @XmlElement(name = "HomeEquity", required = true, type = Long.class, nillable = true)
    protected Long homeEquity;
    @XmlElement(name = "RealEstateInvestmentEquity", required = true, type = Long.class, nillable = true)
    protected Long realEstateInvestmentEquity;
    @XmlElement(name = "AdjustedBusinessFarmEquity", required = true, type = Long.class, nillable = true)
    protected Long adjustedBusinessFarmEquity;
    @XmlElement(name = "ValueOfTrusts", required = true, type = Long.class, nillable = true)
    protected Long valueOfTrusts;
    @XmlElement(name = "ValueOfOtherAssets", required = true, type = Long.class, nillable = true)
    protected Long valueOfOtherAssets;
    @XmlElement(name = "NetWorth", required = true, type = Long.class, nillable = true)
    protected Long netWorth;
    @XmlElement(name = "AssetProtectionAllowance", required = true, type = Long.class, nillable = true)
    protected Long assetProtectionAllowance;
    @XmlElement(name = "OtherAssetAllowance", required = true, type = Long.class, nillable = true)
    protected Long otherAssetAllowance;
    @XmlElement(name = "DiscretionaryNetWorth", required = true, type = Long.class, nillable = true)
    protected Long discretionaryNetWorth;
    @XmlElementRef(name = "ConversionPercent", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> conversionPercent;
    @XmlElement(name = "IncomeSupplement", required = true, type = Long.class, nillable = true)
    protected Long incomeSupplement;
    @XmlElement(name = "AdjustedAvailableIncome", required = true, type = Long.class, nillable = true)
    protected Long adjustedAvailableIncome;
    @XmlElement(name = "TotalContribution", required = true, type = Long.class, nillable = true)
    protected Long totalContribution;
    @XmlElementRef(name = "ImAllocationPercent", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> imAllocationPercent;
    @XmlElement(name = "FmNumberInCollegeAllocation", required = true, type = Long.class, nillable = true)
    protected Long fmNumberInCollegeAllocation;
    @XmlElement(name = "ContributionForStudent", required = true, type = Long.class, nillable = true)
    protected Long contributionForStudent;
    @XmlElement(name = "ContributionFromIncome", required = true, type = Long.class, nillable = true)
    protected Long contributionFromIncome;
    @XmlElement(name = "ContributionFromAssets", required = true, type = Long.class, nillable = true)
    protected Long contributionFromAssets;
    @XmlElement(name = "AesaAllowance", required = true, type = Long.class, nillable = true)
    protected Long aesaAllowance;
    @XmlElement(name = "AssetsInSiblingsNames", required = true, type = Long.class, nillable = true)
    protected Long assetsInSiblingsNames;
    @XmlElement(name = "EmergencyReserveAllowance", required = true, type = Long.class, nillable = true)
    protected Long emergencyReserveAllowance;
    @XmlElement(name = "CesaAllowance", required = true, type = Long.class, nillable = true)
    protected Long cesaAllowance;
    @XmlElement(name = "LowIncomeAllowance", required = true, type = Long.class, nillable = true)
    protected Long lowIncomeAllowance;

    /**
     * Gets the value of the resultType property.
     * 
     */
    public long getResultType() {
        return resultType;
    }

    /**
     * Sets the value of the resultType property.
     * 
     */
    public void setResultType(long value) {
        this.resultType = value;
    }

    /**
     * Gets the value of the methodology property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MethodologyType }{@code >}
     *     
     */
    public JAXBElement<MethodologyType> getMethodology() {
        return methodology;
    }

    /**
     * Sets the value of the methodology property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MethodologyType }{@code >}
     *     
     */
    public void setMethodology(JAXBElement<MethodologyType> value) {
        this.methodology = ((JAXBElement<MethodologyType> ) value);
    }

    /**
     * Gets the value of the adjustedGrossIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdjustedGrossIncome() {
        return adjustedGrossIncome;
    }

    /**
     * Sets the value of the adjustedGrossIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdjustedGrossIncome(Long value) {
        this.adjustedGrossIncome = value;
    }

    /**
     * Gets the value of the untaxedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUntaxedIncome() {
        return untaxedIncome;
    }

    /**
     * Sets the value of the untaxedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUntaxedIncome(Long value) {
        this.untaxedIncome = value;
    }

    /**
     * Gets the value of the incomeAdjustments property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIncomeAdjustments() {
        return incomeAdjustments;
    }

    /**
     * Sets the value of the incomeAdjustments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIncomeAdjustments(Long value) {
        this.incomeAdjustments = value;
    }

    /**
     * Gets the value of the totalIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalIncome() {
        return totalIncome;
    }

    /**
     * Sets the value of the totalIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalIncome(Long value) {
        this.totalIncome = value;
    }

    /**
     * Gets the value of the usIncomeTax property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUSIncomeTax() {
        return usIncomeTax;
    }

    /**
     * Sets the value of the usIncomeTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUSIncomeTax(Long value) {
        this.usIncomeTax = value;
    }

    /**
     * Gets the value of the stateIncomeTax property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStateIncomeTax() {
        return stateIncomeTax;
    }

    /**
     * Sets the value of the stateIncomeTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStateIncomeTax(Long value) {
        this.stateIncomeTax = value;
    }

    /**
     * Gets the value of the fica property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFICA() {
        return fica;
    }

    /**
     * Sets the value of the fica property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFICA(Long value) {
        this.fica = value;
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
     * Gets the value of the employmentAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEmploymentAllowance() {
        return employmentAllowance;
    }

    /**
     * Sets the value of the employmentAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEmploymentAllowance(Long value) {
        this.employmentAllowance = value;
    }

    /**
     * Gets the value of the incomeProtectionAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIncomeProtectionAllowance() {
        return incomeProtectionAllowance;
    }

    /**
     * Sets the value of the incomeProtectionAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIncomeProtectionAllowance(Long value) {
        this.incomeProtectionAllowance = value;
    }

    /**
     * Gets the value of the otherAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherAllowance() {
        return otherAllowance;
    }

    /**
     * Sets the value of the otherAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherAllowance(Long value) {
        this.otherAllowance = value;
    }

    /**
     * Gets the value of the totalAllowances property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalAllowances() {
        return totalAllowances;
    }

    /**
     * Sets the value of the totalAllowances property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalAllowances(Long value) {
        this.totalAllowances = value;
    }

    /**
     * Gets the value of the calculatedAvailableIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCalculatedAvailableIncome() {
        return calculatedAvailableIncome;
    }

    /**
     * Sets the value of the calculatedAvailableIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCalculatedAvailableIncome(Long value) {
        this.calculatedAvailableIncome = value;
    }

    /**
     * Gets the value of the availableIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAvailableIncome() {
        return availableIncome;
    }

    /**
     * Sets the value of the availableIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAvailableIncome(Long value) {
        this.availableIncome = value;
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
     * Gets the value of the homeEquity property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHomeEquity() {
        return homeEquity;
    }

    /**
     * Sets the value of the homeEquity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHomeEquity(Long value) {
        this.homeEquity = value;
    }

    /**
     * Gets the value of the realEstateInvestmentEquity property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRealEstateInvestmentEquity() {
        return realEstateInvestmentEquity;
    }

    /**
     * Sets the value of the realEstateInvestmentEquity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRealEstateInvestmentEquity(Long value) {
        this.realEstateInvestmentEquity = value;
    }

    /**
     * Gets the value of the adjustedBusinessFarmEquity property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdjustedBusinessFarmEquity() {
        return adjustedBusinessFarmEquity;
    }

    /**
     * Sets the value of the adjustedBusinessFarmEquity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdjustedBusinessFarmEquity(Long value) {
        this.adjustedBusinessFarmEquity = value;
    }

    /**
     * Gets the value of the valueOfTrusts property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getValueOfTrusts() {
        return valueOfTrusts;
    }

    /**
     * Sets the value of the valueOfTrusts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setValueOfTrusts(Long value) {
        this.valueOfTrusts = value;
    }

    /**
     * Gets the value of the valueOfOtherAssets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getValueOfOtherAssets() {
        return valueOfOtherAssets;
    }

    /**
     * Sets the value of the valueOfOtherAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setValueOfOtherAssets(Long value) {
        this.valueOfOtherAssets = value;
    }

    /**
     * Gets the value of the netWorth property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNetWorth() {
        return netWorth;
    }

    /**
     * Sets the value of the netWorth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNetWorth(Long value) {
        this.netWorth = value;
    }

    /**
     * Gets the value of the assetProtectionAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssetProtectionAllowance() {
        return assetProtectionAllowance;
    }

    /**
     * Sets the value of the assetProtectionAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssetProtectionAllowance(Long value) {
        this.assetProtectionAllowance = value;
    }

    /**
     * Gets the value of the otherAssetAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherAssetAllowance() {
        return otherAssetAllowance;
    }

    /**
     * Sets the value of the otherAssetAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherAssetAllowance(Long value) {
        this.otherAssetAllowance = value;
    }

    /**
     * Gets the value of the discretionaryNetWorth property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDiscretionaryNetWorth() {
        return discretionaryNetWorth;
    }

    /**
     * Sets the value of the discretionaryNetWorth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDiscretionaryNetWorth(Long value) {
        this.discretionaryNetWorth = value;
    }

    /**
     * Gets the value of the conversionPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getConversionPercent() {
        return conversionPercent;
    }

    /**
     * Sets the value of the conversionPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setConversionPercent(JAXBElement<BigDecimal> value) {
        this.conversionPercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the incomeSupplement property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIncomeSupplement() {
        return incomeSupplement;
    }

    /**
     * Sets the value of the incomeSupplement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIncomeSupplement(Long value) {
        this.incomeSupplement = value;
    }

    /**
     * Gets the value of the adjustedAvailableIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdjustedAvailableIncome() {
        return adjustedAvailableIncome;
    }

    /**
     * Sets the value of the adjustedAvailableIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdjustedAvailableIncome(Long value) {
        this.adjustedAvailableIncome = value;
    }

    /**
     * Gets the value of the totalContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalContribution() {
        return totalContribution;
    }

    /**
     * Sets the value of the totalContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalContribution(Long value) {
        this.totalContribution = value;
    }

    /**
     * Gets the value of the imAllocationPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getImAllocationPercent() {
        return imAllocationPercent;
    }

    /**
     * Sets the value of the imAllocationPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setImAllocationPercent(JAXBElement<BigDecimal> value) {
        this.imAllocationPercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the fmNumberInCollegeAllocation property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFmNumberInCollegeAllocation() {
        return fmNumberInCollegeAllocation;
    }

    /**
     * Sets the value of the fmNumberInCollegeAllocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFmNumberInCollegeAllocation(Long value) {
        this.fmNumberInCollegeAllocation = value;
    }

    /**
     * Gets the value of the contributionForStudent property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContributionForStudent() {
        return contributionForStudent;
    }

    /**
     * Sets the value of the contributionForStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContributionForStudent(Long value) {
        this.contributionForStudent = value;
    }

    /**
     * Gets the value of the contributionFromIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContributionFromIncome() {
        return contributionFromIncome;
    }

    /**
     * Sets the value of the contributionFromIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContributionFromIncome(Long value) {
        this.contributionFromIncome = value;
    }

    /**
     * Gets the value of the contributionFromAssets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContributionFromAssets() {
        return contributionFromAssets;
    }

    /**
     * Sets the value of the contributionFromAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContributionFromAssets(Long value) {
        this.contributionFromAssets = value;
    }

    /**
     * Gets the value of the aesaAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAesaAllowance() {
        return aesaAllowance;
    }

    /**
     * Sets the value of the aesaAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAesaAllowance(Long value) {
        this.aesaAllowance = value;
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
     * Gets the value of the emergencyReserveAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEmergencyReserveAllowance() {
        return emergencyReserveAllowance;
    }

    /**
     * Sets the value of the emergencyReserveAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEmergencyReserveAllowance(Long value) {
        this.emergencyReserveAllowance = value;
    }

    /**
     * Gets the value of the cesaAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCesaAllowance() {
        return cesaAllowance;
    }

    /**
     * Sets the value of the cesaAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCesaAllowance(Long value) {
        this.cesaAllowance = value;
    }

    /**
     * Gets the value of the lowIncomeAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLowIncomeAllowance() {
        return lowIncomeAllowance;
    }

    /**
     * Sets the value of the lowIncomeAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLowIncomeAllowance(Long value) {
        this.lowIncomeAllowance = value;
    }

}
