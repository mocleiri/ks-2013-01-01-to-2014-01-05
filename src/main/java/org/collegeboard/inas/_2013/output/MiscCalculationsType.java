
package org.collegeboard.inas._2013.output;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for miscCalculationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="miscCalculationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustodialParent" type="{http://INAS.collegeboard.org/2013/Output/}custodialParentType" minOccurs="0"/>
 *         &lt;element name="SiblingCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PercentOfIncomeAdjustment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AdjustedContributionFromIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AdjustedContributionFromAssets" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TotalAdjustedContribution" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NumberInCollegeAllocationPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TotalAssetAllowanceBeforeAdjustment" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="StudentTotalAssetContributionBeforeAdjustment" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="StudentTotalIncomeContributionBeforeAdjustment" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ParentTotalAssetContributionBeforeAdjustment" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ParentTotalIncomeContributionBeforeAdjustment" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FisapTotalIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ParentImStateTaxRateUsed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentEfmStateTaxRateUsed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="StudentImStateTaxRateUsed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="StudentEfmStateTaxRateUsed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="NumberOfChildrenTuitionPaid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ParentColaRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ParentHomeValueEquityOptionUsage" type="{http://INAS.collegeboard.org/2013/Output/}homeValueEquityOptionUsageType" minOccurs="0"/>
 *         &lt;element name="StudentHomeValueEquityOptionUsage" type="{http://INAS.collegeboard.org/2013/Output/}homeValueEquityOptionUsageType" minOccurs="0"/>
 *         &lt;element name="StudentEducationCreditAmountAppliedUsed" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ParentEducationCreditAmountAppliedUsed" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DiagnosticMessages" type="{http://INAS.collegeboard.org/2013/Output/}ArrayOfMessageType" minOccurs="0"/>
 *         &lt;element name="UniqueProcessingIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InasVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InasReturnCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "miscCalculationsType", propOrder = {
    "custodialParent",
    "siblingCount",
    "percentOfIncomeAdjustment",
    "adjustedContributionFromIncome",
    "adjustedContributionFromAssets",
    "totalAdjustedContribution",
    "numberInCollegeAllocationPercent",
    "totalAssetAllowanceBeforeAdjustment",
    "studentTotalAssetContributionBeforeAdjustment",
    "studentTotalIncomeContributionBeforeAdjustment",
    "parentTotalAssetContributionBeforeAdjustment",
    "parentTotalIncomeContributionBeforeAdjustment",
    "fisapTotalIncome",
    "parentImStateTaxRateUsed",
    "parentEfmStateTaxRateUsed",
    "studentImStateTaxRateUsed",
    "studentEfmStateTaxRateUsed",
    "numberOfChildrenTuitionPaid",
    "parentColaRate",
    "parentHomeValueEquityOptionUsage",
    "studentHomeValueEquityOptionUsage",
    "studentEducationCreditAmountAppliedUsed",
    "parentEducationCreditAmountAppliedUsed",
    "diagnosticMessages",
    "uniqueProcessingIdentifier",
    "inasVersion",
    "inasReturnCode"
})
public class MiscCalculationsType {

    @XmlElementRef(name = "CustodialParent", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<CustodialParentType> custodialParent;
    @XmlElement(name = "SiblingCount", required = true, type = Long.class, nillable = true)
    protected Long siblingCount;
    @XmlElementRef(name = "PercentOfIncomeAdjustment", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> percentOfIncomeAdjustment;
    @XmlElement(name = "AdjustedContributionFromIncome", required = true, type = Long.class, nillable = true)
    protected Long adjustedContributionFromIncome;
    @XmlElement(name = "AdjustedContributionFromAssets", required = true, type = Long.class, nillable = true)
    protected Long adjustedContributionFromAssets;
    @XmlElement(name = "TotalAdjustedContribution", required = true, type = Long.class, nillable = true)
    protected Long totalAdjustedContribution;
    @XmlElementRef(name = "NumberInCollegeAllocationPercent", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> numberInCollegeAllocationPercent;
    @XmlElement(name = "TotalAssetAllowanceBeforeAdjustment", required = true, type = Long.class, nillable = true)
    protected Long totalAssetAllowanceBeforeAdjustment;
    @XmlElement(name = "StudentTotalAssetContributionBeforeAdjustment", required = true, type = Long.class, nillable = true)
    protected Long studentTotalAssetContributionBeforeAdjustment;
    @XmlElement(name = "StudentTotalIncomeContributionBeforeAdjustment", required = true, type = Long.class, nillable = true)
    protected Long studentTotalIncomeContributionBeforeAdjustment;
    @XmlElement(name = "ParentTotalAssetContributionBeforeAdjustment", required = true, type = Long.class, nillable = true)
    protected Long parentTotalAssetContributionBeforeAdjustment;
    @XmlElement(name = "ParentTotalIncomeContributionBeforeAdjustment", required = true, type = Long.class, nillable = true)
    protected Long parentTotalIncomeContributionBeforeAdjustment;
    @XmlElement(name = "FisapTotalIncome", required = true, type = Long.class, nillable = true)
    protected Long fisapTotalIncome;
    @XmlElementRef(name = "ParentImStateTaxRateUsed", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentImStateTaxRateUsed;
    @XmlElementRef(name = "ParentEfmStateTaxRateUsed", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentEfmStateTaxRateUsed;
    @XmlElementRef(name = "StudentImStateTaxRateUsed", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentImStateTaxRateUsed;
    @XmlElementRef(name = "StudentEfmStateTaxRateUsed", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> studentEfmStateTaxRateUsed;
    @XmlElement(name = "NumberOfChildrenTuitionPaid", required = true, type = Long.class, nillable = true)
    protected Long numberOfChildrenTuitionPaid;
    @XmlElementRef(name = "ParentColaRate", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> parentColaRate;
    @XmlElementRef(name = "ParentHomeValueEquityOptionUsage", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<HomeValueEquityOptionUsageType> parentHomeValueEquityOptionUsage;
    @XmlElementRef(name = "StudentHomeValueEquityOptionUsage", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<HomeValueEquityOptionUsageType> studentHomeValueEquityOptionUsage;
    @XmlElement(name = "StudentEducationCreditAmountAppliedUsed", required = true, type = Long.class, nillable = true)
    protected Long studentEducationCreditAmountAppliedUsed;
    @XmlElement(name = "ParentEducationCreditAmountAppliedUsed", required = true, type = Long.class, nillable = true)
    protected Long parentEducationCreditAmountAppliedUsed;
    @XmlElement(name = "DiagnosticMessages")
    protected ArrayOfMessageType diagnosticMessages;
    @XmlElement(name = "UniqueProcessingIdentifier")
    protected String uniqueProcessingIdentifier;
    @XmlElement(name = "InasVersion")
    protected String inasVersion;
    @XmlElement(name = "InasReturnCode", required = true, nillable = true)
    protected String inasReturnCode;

    /**
     * Gets the value of the custodialParent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CustodialParentType }{@code >}
     *     
     */
    public JAXBElement<CustodialParentType> getCustodialParent() {
        return custodialParent;
    }

    /**
     * Sets the value of the custodialParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CustodialParentType }{@code >}
     *     
     */
    public void setCustodialParent(JAXBElement<CustodialParentType> value) {
        this.custodialParent = ((JAXBElement<CustodialParentType> ) value);
    }

    /**
     * Gets the value of the siblingCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSiblingCount() {
        return siblingCount;
    }

    /**
     * Sets the value of the siblingCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSiblingCount(Long value) {
        this.siblingCount = value;
    }

    /**
     * Gets the value of the percentOfIncomeAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPercentOfIncomeAdjustment() {
        return percentOfIncomeAdjustment;
    }

    /**
     * Sets the value of the percentOfIncomeAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPercentOfIncomeAdjustment(JAXBElement<BigDecimal> value) {
        this.percentOfIncomeAdjustment = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the adjustedContributionFromIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdjustedContributionFromIncome() {
        return adjustedContributionFromIncome;
    }

    /**
     * Sets the value of the adjustedContributionFromIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdjustedContributionFromIncome(Long value) {
        this.adjustedContributionFromIncome = value;
    }

    /**
     * Gets the value of the adjustedContributionFromAssets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdjustedContributionFromAssets() {
        return adjustedContributionFromAssets;
    }

    /**
     * Sets the value of the adjustedContributionFromAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdjustedContributionFromAssets(Long value) {
        this.adjustedContributionFromAssets = value;
    }

    /**
     * Gets the value of the totalAdjustedContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalAdjustedContribution() {
        return totalAdjustedContribution;
    }

    /**
     * Sets the value of the totalAdjustedContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalAdjustedContribution(Long value) {
        this.totalAdjustedContribution = value;
    }

    /**
     * Gets the value of the numberInCollegeAllocationPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNumberInCollegeAllocationPercent() {
        return numberInCollegeAllocationPercent;
    }

    /**
     * Sets the value of the numberInCollegeAllocationPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNumberInCollegeAllocationPercent(JAXBElement<BigDecimal> value) {
        this.numberInCollegeAllocationPercent = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the totalAssetAllowanceBeforeAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalAssetAllowanceBeforeAdjustment() {
        return totalAssetAllowanceBeforeAdjustment;
    }

    /**
     * Sets the value of the totalAssetAllowanceBeforeAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalAssetAllowanceBeforeAdjustment(Long value) {
        this.totalAssetAllowanceBeforeAdjustment = value;
    }

    /**
     * Gets the value of the studentTotalAssetContributionBeforeAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentTotalAssetContributionBeforeAdjustment() {
        return studentTotalAssetContributionBeforeAdjustment;
    }

    /**
     * Sets the value of the studentTotalAssetContributionBeforeAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentTotalAssetContributionBeforeAdjustment(Long value) {
        this.studentTotalAssetContributionBeforeAdjustment = value;
    }

    /**
     * Gets the value of the studentTotalIncomeContributionBeforeAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentTotalIncomeContributionBeforeAdjustment() {
        return studentTotalIncomeContributionBeforeAdjustment;
    }

    /**
     * Sets the value of the studentTotalIncomeContributionBeforeAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentTotalIncomeContributionBeforeAdjustment(Long value) {
        this.studentTotalIncomeContributionBeforeAdjustment = value;
    }

    /**
     * Gets the value of the parentTotalAssetContributionBeforeAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentTotalAssetContributionBeforeAdjustment() {
        return parentTotalAssetContributionBeforeAdjustment;
    }

    /**
     * Sets the value of the parentTotalAssetContributionBeforeAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentTotalAssetContributionBeforeAdjustment(Long value) {
        this.parentTotalAssetContributionBeforeAdjustment = value;
    }

    /**
     * Gets the value of the parentTotalIncomeContributionBeforeAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentTotalIncomeContributionBeforeAdjustment() {
        return parentTotalIncomeContributionBeforeAdjustment;
    }

    /**
     * Sets the value of the parentTotalIncomeContributionBeforeAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentTotalIncomeContributionBeforeAdjustment(Long value) {
        this.parentTotalIncomeContributionBeforeAdjustment = value;
    }

    /**
     * Gets the value of the fisapTotalIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFisapTotalIncome() {
        return fisapTotalIncome;
    }

    /**
     * Sets the value of the fisapTotalIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFisapTotalIncome(Long value) {
        this.fisapTotalIncome = value;
    }

    /**
     * Gets the value of the parentImStateTaxRateUsed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentImStateTaxRateUsed() {
        return parentImStateTaxRateUsed;
    }

    /**
     * Sets the value of the parentImStateTaxRateUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentImStateTaxRateUsed(JAXBElement<BigDecimal> value) {
        this.parentImStateTaxRateUsed = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentEfmStateTaxRateUsed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentEfmStateTaxRateUsed() {
        return parentEfmStateTaxRateUsed;
    }

    /**
     * Sets the value of the parentEfmStateTaxRateUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentEfmStateTaxRateUsed(JAXBElement<BigDecimal> value) {
        this.parentEfmStateTaxRateUsed = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the studentImStateTaxRateUsed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentImStateTaxRateUsed() {
        return studentImStateTaxRateUsed;
    }

    /**
     * Sets the value of the studentImStateTaxRateUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentImStateTaxRateUsed(JAXBElement<BigDecimal> value) {
        this.studentImStateTaxRateUsed = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the studentEfmStateTaxRateUsed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStudentEfmStateTaxRateUsed() {
        return studentEfmStateTaxRateUsed;
    }

    /**
     * Sets the value of the studentEfmStateTaxRateUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStudentEfmStateTaxRateUsed(JAXBElement<BigDecimal> value) {
        this.studentEfmStateTaxRateUsed = ((JAXBElement<BigDecimal> ) value);
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
     * Gets the value of the parentColaRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getParentColaRate() {
        return parentColaRate;
    }

    /**
     * Sets the value of the parentColaRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setParentColaRate(JAXBElement<BigDecimal> value) {
        this.parentColaRate = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the parentHomeValueEquityOptionUsage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HomeValueEquityOptionUsageType }{@code >}
     *     
     */
    public JAXBElement<HomeValueEquityOptionUsageType> getParentHomeValueEquityOptionUsage() {
        return parentHomeValueEquityOptionUsage;
    }

    /**
     * Sets the value of the parentHomeValueEquityOptionUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HomeValueEquityOptionUsageType }{@code >}
     *     
     */
    public void setParentHomeValueEquityOptionUsage(JAXBElement<HomeValueEquityOptionUsageType> value) {
        this.parentHomeValueEquityOptionUsage = ((JAXBElement<HomeValueEquityOptionUsageType> ) value);
    }

    /**
     * Gets the value of the studentHomeValueEquityOptionUsage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HomeValueEquityOptionUsageType }{@code >}
     *     
     */
    public JAXBElement<HomeValueEquityOptionUsageType> getStudentHomeValueEquityOptionUsage() {
        return studentHomeValueEquityOptionUsage;
    }

    /**
     * Sets the value of the studentHomeValueEquityOptionUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HomeValueEquityOptionUsageType }{@code >}
     *     
     */
    public void setStudentHomeValueEquityOptionUsage(JAXBElement<HomeValueEquityOptionUsageType> value) {
        this.studentHomeValueEquityOptionUsage = ((JAXBElement<HomeValueEquityOptionUsageType> ) value);
    }

    /**
     * Gets the value of the studentEducationCreditAmountAppliedUsed property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentEducationCreditAmountAppliedUsed() {
        return studentEducationCreditAmountAppliedUsed;
    }

    /**
     * Sets the value of the studentEducationCreditAmountAppliedUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentEducationCreditAmountAppliedUsed(Long value) {
        this.studentEducationCreditAmountAppliedUsed = value;
    }

    /**
     * Gets the value of the parentEducationCreditAmountAppliedUsed property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentEducationCreditAmountAppliedUsed() {
        return parentEducationCreditAmountAppliedUsed;
    }

    /**
     * Sets the value of the parentEducationCreditAmountAppliedUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentEducationCreditAmountAppliedUsed(Long value) {
        this.parentEducationCreditAmountAppliedUsed = value;
    }

    /**
     * Gets the value of the diagnosticMessages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMessageType }
     *     
     */
    public ArrayOfMessageType getDiagnosticMessages() {
        return diagnosticMessages;
    }

    /**
     * Sets the value of the diagnosticMessages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMessageType }
     *     
     */
    public void setDiagnosticMessages(ArrayOfMessageType value) {
        this.diagnosticMessages = value;
    }

    /**
     * Gets the value of the uniqueProcessingIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueProcessingIdentifier() {
        return uniqueProcessingIdentifier;
    }

    /**
     * Sets the value of the uniqueProcessingIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueProcessingIdentifier(String value) {
        this.uniqueProcessingIdentifier = value;
    }

    /**
     * Gets the value of the inasVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInasVersion() {
        return inasVersion;
    }

    /**
     * Sets the value of the inasVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInasVersion(String value) {
        this.inasVersion = value;
    }

    /**
     * Gets the value of the inasReturnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInasReturnCode() {
        return inasReturnCode;
    }

    /**
     * Sets the value of the inasReturnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInasReturnCode(String value) {
        this.inasReturnCode = value;
    }

}
