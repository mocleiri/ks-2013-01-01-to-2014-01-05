
package org.collegeboard.inas._2012.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmParentsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmParentsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FatherData" type="{http://INAS.collegeboard.org/2012/Input/}parentIdentityDataType" minOccurs="0"/>
 *         &lt;element name="MotherData" type="{http://INAS.collegeboard.org/2012/Input/}parentIdentityDataType" minOccurs="0"/>
 *         &lt;element name="MaritalStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ResidencyStateProvinceCode" type="{http://INAS.collegeboard.org/2012/Input/}stateProvinceType" minOccurs="0"/>
 *         &lt;element name="MembersInFamily" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ReceiveSSI" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveFoodStamps" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveFreeLunch" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveTANF" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ReceiveWIC" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="TaxReturnStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxFormTypeCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="EligibleToFile1040AOr1040EZ" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="DislocatedWorker" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AssetThresholdExceeded" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AdjustedGrossIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IncomeTaxPaid" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ExemptionsClaimed" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FatherEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MotherEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmParentsType", propOrder = {
    "fatherData",
    "motherData",
    "maritalStatusCode",
    "residencyStateProvinceCode",
    "membersInFamily",
    "numberInCollege",
    "receiveSSI",
    "receiveFoodStamps",
    "receiveFreeLunch",
    "receiveTANF",
    "receiveWIC",
    "taxReturnStatusCode",
    "taxFormTypeCode",
    "eligibleToFile1040AOr1040EZ",
    "dislocatedWorker",
    "assetThresholdExceeded",
    "adjustedGrossIncome",
    "incomeTaxPaid",
    "exemptionsClaimed",
    "fatherEarnedIncome",
    "motherEarnedIncome",
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
    "otherUntaxedIncome"
})
public class FmParentsType {

    @XmlElement(name = "FatherData")
    protected ParentIdentityDataType fatherData;
    @XmlElement(name = "MotherData")
    protected ParentIdentityDataType motherData;
    @XmlElement(name = "MaritalStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maritalStatusCode;
    @XmlElementRef(name = "ResidencyStateProvinceCode", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<StateProvinceType> residencyStateProvinceCode;
    @XmlElement(name = "MembersInFamily", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long membersInFamily;
    @XmlElement(name = "NumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long numberInCollege;
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
    @XmlElement(name = "TaxReturnStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long taxReturnStatusCode;
    @XmlElement(name = "TaxFormTypeCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long taxFormTypeCode;
    @XmlElement(name = "EligibleToFile1040AOr1040EZ", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long eligibleToFile1040AOr1040EZ;
    @XmlElement(name = "DislocatedWorker", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long dislocatedWorker;
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
    @XmlElement(name = "FatherEarnedIncome", required = true, type = Integer.class, nillable = true)
    protected Integer fatherEarnedIncome;
    @XmlElement(name = "MotherEarnedIncome", required = true, type = Integer.class, nillable = true)
    protected Integer motherEarnedIncome;
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

    /**
     * Gets the value of the fatherData property.
     * 
     * @return
     *     possible object is
     *     {@link ParentIdentityDataType }
     *     
     */
    public ParentIdentityDataType getFatherData() {
        return fatherData;
    }

    /**
     * Sets the value of the fatherData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentIdentityDataType }
     *     
     */
    public void setFatherData(ParentIdentityDataType value) {
        this.fatherData = value;
    }

    /**
     * Gets the value of the motherData property.
     * 
     * @return
     *     possible object is
     *     {@link ParentIdentityDataType }
     *     
     */
    public ParentIdentityDataType getMotherData() {
        return motherData;
    }

    /**
     * Sets the value of the motherData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentIdentityDataType }
     *     
     */
    public void setMotherData(ParentIdentityDataType value) {
        this.motherData = value;
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
     * Gets the value of the dislocatedWorker property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDislocatedWorker() {
        return dislocatedWorker;
    }

    /**
     * Sets the value of the dislocatedWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDislocatedWorker(Long value) {
        this.dislocatedWorker = value;
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
     * Gets the value of the fatherEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFatherEarnedIncome() {
        return fatherEarnedIncome;
    }

    /**
     * Sets the value of the fatherEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFatherEarnedIncome(Integer value) {
        this.fatherEarnedIncome = value;
    }

    /**
     * Gets the value of the motherEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMotherEarnedIncome() {
        return motherEarnedIncome;
    }

    /**
     * Sets the value of the motherEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMotherEarnedIncome(Integer value) {
        this.motherEarnedIncome = value;
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

}
