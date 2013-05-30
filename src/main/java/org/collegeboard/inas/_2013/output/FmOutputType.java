
package org.collegeboard.inas._2013.output;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmOutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrimaryEfc" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TotalIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="StudentTotalIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ParentContribution" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssumedCitizenship" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="AssumedStudentsMaritalStatus" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="AssumedStudentAdjustedGrossIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssumedStudentIncomeTaxPaid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssumedStudentEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssumedSpouseEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssumedStudentBornPriorIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AssumedStudentMarriedIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AssumedStudentChildYouSupportIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AssumedStudentLegalDependentsIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AssumedStudentMembersInFamily" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AssumedStudentNumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AssumedStudentHomelessYouthBySchoolIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AssumedStudentHomelessYouthByHUDIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AssumedStudentAtRiskHomelessIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AssumedStudentThresholdExceeded" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="AssumedParentsMaritalStatus" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="AssumedParentMembersInFamily" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AssumedParentNumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AssumedParentAdjustedGrossIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssumedParentIncomeTaxPaid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssumedFatherEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssumedMotherEarnedIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssumedParentThresholdExceeded" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth1" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth2" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth3" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth4" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth5" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth6" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth7" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth8" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth10" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth11" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryAlternativeEfcMonth12" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmOutputType", propOrder = {
    "primaryEfc",
    "totalIncome",
    "studentTotalIncome",
    "parentContribution",
    "assumedCitizenship",
    "assumedStudentsMaritalStatus",
    "assumedStudentAdjustedGrossIncome",
    "assumedStudentIncomeTaxPaid",
    "assumedStudentEarnedIncome",
    "assumedSpouseEarnedIncome",
    "assumedStudentBornPriorIndicator",
    "assumedStudentMarriedIndicator",
    "assumedStudentChildYouSupportIndicator",
    "assumedStudentLegalDependentsIndicator",
    "assumedStudentMembersInFamily",
    "assumedStudentNumberInCollege",
    "assumedStudentHomelessYouthBySchoolIndicator",
    "assumedStudentHomelessYouthByHUDIndicator",
    "assumedStudentAtRiskHomelessIndicator",
    "assumedStudentThresholdExceeded",
    "assumedParentsMaritalStatus",
    "assumedParentMembersInFamily",
    "assumedParentNumberInCollege",
    "assumedParentAdjustedGrossIncome",
    "assumedParentIncomeTaxPaid",
    "assumedFatherEarnedIncome",
    "assumedMotherEarnedIncome",
    "assumedParentThresholdExceeded",
    "primaryAlternativeEfcMonth1",
    "primaryAlternativeEfcMonth2",
    "primaryAlternativeEfcMonth3",
    "primaryAlternativeEfcMonth4",
    "primaryAlternativeEfcMonth5",
    "primaryAlternativeEfcMonth6",
    "primaryAlternativeEfcMonth7",
    "primaryAlternativeEfcMonth8",
    "primaryAlternativeEfcMonth10",
    "primaryAlternativeEfcMonth11",
    "primaryAlternativeEfcMonth12"
})
public class FmOutputType {

    @XmlElement(name = "PrimaryEfc", required = true, type = Long.class, nillable = true)
    protected Long primaryEfc;
    @XmlElement(name = "TotalIncome", required = true, type = Long.class, nillable = true)
    protected Long totalIncome;
    @XmlElement(name = "StudentTotalIncome", required = true, type = Long.class, nillable = true)
    protected Long studentTotalIncome;
    @XmlElement(name = "ParentContribution", required = true, type = Long.class, nillable = true)
    protected Long parentContribution;
    @XmlElement(name = "AssumedCitizenship", required = true, nillable = true)
    protected BigInteger assumedCitizenship;
    @XmlElement(name = "AssumedStudentsMaritalStatus", required = true, nillable = true)
    protected BigInteger assumedStudentsMaritalStatus;
    @XmlElement(name = "AssumedStudentAdjustedGrossIncome", required = true, type = Long.class, nillable = true)
    protected Long assumedStudentAdjustedGrossIncome;
    @XmlElement(name = "AssumedStudentIncomeTaxPaid", required = true, type = Long.class, nillable = true)
    protected Long assumedStudentIncomeTaxPaid;
    @XmlElement(name = "AssumedStudentEarnedIncome", required = true, type = Long.class, nillable = true)
    protected Long assumedStudentEarnedIncome;
    @XmlElement(name = "AssumedSpouseEarnedIncome", required = true, type = Long.class, nillable = true)
    protected Long assumedSpouseEarnedIncome;
    @XmlElementRef(name = "AssumedStudentBornPriorIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumedStudentBornPriorIndicator;
    @XmlElementRef(name = "AssumedStudentMarriedIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumedStudentMarriedIndicator;
    @XmlElementRef(name = "AssumedStudentChildYouSupportIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumedStudentChildYouSupportIndicator;
    @XmlElementRef(name = "AssumedStudentLegalDependentsIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumedStudentLegalDependentsIndicator;
    @XmlElement(name = "AssumedStudentMembersInFamily", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long assumedStudentMembersInFamily;
    @XmlElement(name = "AssumedStudentNumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long assumedStudentNumberInCollege;
    @XmlElementRef(name = "AssumedStudentHomelessYouthBySchoolIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumedStudentHomelessYouthBySchoolIndicator;
    @XmlElementRef(name = "AssumedStudentHomelessYouthByHUDIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumedStudentHomelessYouthByHUDIndicator;
    @XmlElementRef(name = "AssumedStudentAtRiskHomelessIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumedStudentAtRiskHomelessIndicator;
    @XmlElementRef(name = "AssumedStudentThresholdExceeded", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumedStudentThresholdExceeded;
    @XmlElement(name = "AssumedParentsMaritalStatus", required = true, nillable = true)
    protected BigInteger assumedParentsMaritalStatus;
    @XmlElement(name = "AssumedParentMembersInFamily", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long assumedParentMembersInFamily;
    @XmlElement(name = "AssumedParentNumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long assumedParentNumberInCollege;
    @XmlElement(name = "AssumedParentAdjustedGrossIncome", required = true, type = Long.class, nillable = true)
    protected Long assumedParentAdjustedGrossIncome;
    @XmlElement(name = "AssumedParentIncomeTaxPaid", required = true, type = Long.class, nillable = true)
    protected Long assumedParentIncomeTaxPaid;
    @XmlElement(name = "AssumedFatherEarnedIncome", required = true, type = Long.class, nillable = true)
    protected Long assumedFatherEarnedIncome;
    @XmlElement(name = "AssumedMotherEarnedIncome", required = true, type = Long.class, nillable = true)
    protected Long assumedMotherEarnedIncome;
    @XmlElementRef(name = "AssumedParentThresholdExceeded", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumedParentThresholdExceeded;
    @XmlElement(name = "PrimaryAlternativeEfcMonth1", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth1;
    @XmlElement(name = "PrimaryAlternativeEfcMonth2", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth2;
    @XmlElement(name = "PrimaryAlternativeEfcMonth3", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth3;
    @XmlElement(name = "PrimaryAlternativeEfcMonth4", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth4;
    @XmlElement(name = "PrimaryAlternativeEfcMonth5", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth5;
    @XmlElement(name = "PrimaryAlternativeEfcMonth6", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth6;
    @XmlElement(name = "PrimaryAlternativeEfcMonth7", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth7;
    @XmlElement(name = "PrimaryAlternativeEfcMonth8", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth8;
    @XmlElement(name = "PrimaryAlternativeEfcMonth10", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth10;
    @XmlElement(name = "PrimaryAlternativeEfcMonth11", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth11;
    @XmlElement(name = "PrimaryAlternativeEfcMonth12", required = true, type = Long.class, nillable = true)
    protected Long primaryAlternativeEfcMonth12;

    /**
     * Gets the value of the primaryEfc property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryEfc() {
        return primaryEfc;
    }

    /**
     * Sets the value of the primaryEfc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryEfc(Long value) {
        this.primaryEfc = value;
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
     * Gets the value of the studentTotalIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStudentTotalIncome() {
        return studentTotalIncome;
    }

    /**
     * Sets the value of the studentTotalIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStudentTotalIncome(Long value) {
        this.studentTotalIncome = value;
    }

    /**
     * Gets the value of the parentContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentContribution() {
        return parentContribution;
    }

    /**
     * Sets the value of the parentContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentContribution(Long value) {
        this.parentContribution = value;
    }

    /**
     * Gets the value of the assumedCitizenship property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAssumedCitizenship() {
        return assumedCitizenship;
    }

    /**
     * Sets the value of the assumedCitizenship property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAssumedCitizenship(BigInteger value) {
        this.assumedCitizenship = value;
    }

    /**
     * Gets the value of the assumedStudentsMaritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAssumedStudentsMaritalStatus() {
        return assumedStudentsMaritalStatus;
    }

    /**
     * Sets the value of the assumedStudentsMaritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAssumedStudentsMaritalStatus(BigInteger value) {
        this.assumedStudentsMaritalStatus = value;
    }

    /**
     * Gets the value of the assumedStudentAdjustedGrossIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedStudentAdjustedGrossIncome() {
        return assumedStudentAdjustedGrossIncome;
    }

    /**
     * Sets the value of the assumedStudentAdjustedGrossIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedStudentAdjustedGrossIncome(Long value) {
        this.assumedStudentAdjustedGrossIncome = value;
    }

    /**
     * Gets the value of the assumedStudentIncomeTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedStudentIncomeTaxPaid() {
        return assumedStudentIncomeTaxPaid;
    }

    /**
     * Sets the value of the assumedStudentIncomeTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedStudentIncomeTaxPaid(Long value) {
        this.assumedStudentIncomeTaxPaid = value;
    }

    /**
     * Gets the value of the assumedStudentEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedStudentEarnedIncome() {
        return assumedStudentEarnedIncome;
    }

    /**
     * Sets the value of the assumedStudentEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedStudentEarnedIncome(Long value) {
        this.assumedStudentEarnedIncome = value;
    }

    /**
     * Gets the value of the assumedSpouseEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedSpouseEarnedIncome() {
        return assumedSpouseEarnedIncome;
    }

    /**
     * Sets the value of the assumedSpouseEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedSpouseEarnedIncome(Long value) {
        this.assumedSpouseEarnedIncome = value;
    }

    /**
     * Gets the value of the assumedStudentBornPriorIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumedStudentBornPriorIndicator() {
        return assumedStudentBornPriorIndicator;
    }

    /**
     * Sets the value of the assumedStudentBornPriorIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumedStudentBornPriorIndicator(JAXBElement<YesNoType> value) {
        this.assumedStudentBornPriorIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumedStudentMarriedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumedStudentMarriedIndicator() {
        return assumedStudentMarriedIndicator;
    }

    /**
     * Sets the value of the assumedStudentMarriedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumedStudentMarriedIndicator(JAXBElement<YesNoType> value) {
        this.assumedStudentMarriedIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumedStudentChildYouSupportIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumedStudentChildYouSupportIndicator() {
        return assumedStudentChildYouSupportIndicator;
    }

    /**
     * Sets the value of the assumedStudentChildYouSupportIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumedStudentChildYouSupportIndicator(JAXBElement<YesNoType> value) {
        this.assumedStudentChildYouSupportIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumedStudentLegalDependentsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumedStudentLegalDependentsIndicator() {
        return assumedStudentLegalDependentsIndicator;
    }

    /**
     * Sets the value of the assumedStudentLegalDependentsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumedStudentLegalDependentsIndicator(JAXBElement<YesNoType> value) {
        this.assumedStudentLegalDependentsIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumedStudentMembersInFamily property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedStudentMembersInFamily() {
        return assumedStudentMembersInFamily;
    }

    /**
     * Sets the value of the assumedStudentMembersInFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedStudentMembersInFamily(Long value) {
        this.assumedStudentMembersInFamily = value;
    }

    /**
     * Gets the value of the assumedStudentNumberInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedStudentNumberInCollege() {
        return assumedStudentNumberInCollege;
    }

    /**
     * Sets the value of the assumedStudentNumberInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedStudentNumberInCollege(Long value) {
        this.assumedStudentNumberInCollege = value;
    }

    /**
     * Gets the value of the assumedStudentHomelessYouthBySchoolIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumedStudentHomelessYouthBySchoolIndicator() {
        return assumedStudentHomelessYouthBySchoolIndicator;
    }

    /**
     * Sets the value of the assumedStudentHomelessYouthBySchoolIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumedStudentHomelessYouthBySchoolIndicator(JAXBElement<YesNoType> value) {
        this.assumedStudentHomelessYouthBySchoolIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumedStudentHomelessYouthByHUDIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumedStudentHomelessYouthByHUDIndicator() {
        return assumedStudentHomelessYouthByHUDIndicator;
    }

    /**
     * Sets the value of the assumedStudentHomelessYouthByHUDIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumedStudentHomelessYouthByHUDIndicator(JAXBElement<YesNoType> value) {
        this.assumedStudentHomelessYouthByHUDIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumedStudentAtRiskHomelessIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumedStudentAtRiskHomelessIndicator() {
        return assumedStudentAtRiskHomelessIndicator;
    }

    /**
     * Sets the value of the assumedStudentAtRiskHomelessIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumedStudentAtRiskHomelessIndicator(JAXBElement<YesNoType> value) {
        this.assumedStudentAtRiskHomelessIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumedStudentThresholdExceeded property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumedStudentThresholdExceeded() {
        return assumedStudentThresholdExceeded;
    }

    /**
     * Sets the value of the assumedStudentThresholdExceeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumedStudentThresholdExceeded(JAXBElement<YesNoType> value) {
        this.assumedStudentThresholdExceeded = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumedParentsMaritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAssumedParentsMaritalStatus() {
        return assumedParentsMaritalStatus;
    }

    /**
     * Sets the value of the assumedParentsMaritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAssumedParentsMaritalStatus(BigInteger value) {
        this.assumedParentsMaritalStatus = value;
    }

    /**
     * Gets the value of the assumedParentMembersInFamily property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedParentMembersInFamily() {
        return assumedParentMembersInFamily;
    }

    /**
     * Sets the value of the assumedParentMembersInFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedParentMembersInFamily(Long value) {
        this.assumedParentMembersInFamily = value;
    }

    /**
     * Gets the value of the assumedParentNumberInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedParentNumberInCollege() {
        return assumedParentNumberInCollege;
    }

    /**
     * Sets the value of the assumedParentNumberInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedParentNumberInCollege(Long value) {
        this.assumedParentNumberInCollege = value;
    }

    /**
     * Gets the value of the assumedParentAdjustedGrossIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedParentAdjustedGrossIncome() {
        return assumedParentAdjustedGrossIncome;
    }

    /**
     * Sets the value of the assumedParentAdjustedGrossIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedParentAdjustedGrossIncome(Long value) {
        this.assumedParentAdjustedGrossIncome = value;
    }

    /**
     * Gets the value of the assumedParentIncomeTaxPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedParentIncomeTaxPaid() {
        return assumedParentIncomeTaxPaid;
    }

    /**
     * Sets the value of the assumedParentIncomeTaxPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedParentIncomeTaxPaid(Long value) {
        this.assumedParentIncomeTaxPaid = value;
    }

    /**
     * Gets the value of the assumedFatherEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedFatherEarnedIncome() {
        return assumedFatherEarnedIncome;
    }

    /**
     * Sets the value of the assumedFatherEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedFatherEarnedIncome(Long value) {
        this.assumedFatherEarnedIncome = value;
    }

    /**
     * Gets the value of the assumedMotherEarnedIncome property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssumedMotherEarnedIncome() {
        return assumedMotherEarnedIncome;
    }

    /**
     * Sets the value of the assumedMotherEarnedIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssumedMotherEarnedIncome(Long value) {
        this.assumedMotherEarnedIncome = value;
    }

    /**
     * Gets the value of the assumedParentThresholdExceeded property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumedParentThresholdExceeded() {
        return assumedParentThresholdExceeded;
    }

    /**
     * Sets the value of the assumedParentThresholdExceeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumedParentThresholdExceeded(JAXBElement<YesNoType> value) {
        this.assumedParentThresholdExceeded = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth1 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth1() {
        return primaryAlternativeEfcMonth1;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth1(Long value) {
        this.primaryAlternativeEfcMonth1 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth2 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth2() {
        return primaryAlternativeEfcMonth2;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth2(Long value) {
        this.primaryAlternativeEfcMonth2 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth3 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth3() {
        return primaryAlternativeEfcMonth3;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth3(Long value) {
        this.primaryAlternativeEfcMonth3 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth4 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth4() {
        return primaryAlternativeEfcMonth4;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth4(Long value) {
        this.primaryAlternativeEfcMonth4 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth5 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth5() {
        return primaryAlternativeEfcMonth5;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth5(Long value) {
        this.primaryAlternativeEfcMonth5 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth6 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth6() {
        return primaryAlternativeEfcMonth6;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth6(Long value) {
        this.primaryAlternativeEfcMonth6 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth7 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth7() {
        return primaryAlternativeEfcMonth7;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth7(Long value) {
        this.primaryAlternativeEfcMonth7 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth8 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth8() {
        return primaryAlternativeEfcMonth8;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth8(Long value) {
        this.primaryAlternativeEfcMonth8 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth10 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth10() {
        return primaryAlternativeEfcMonth10;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth10(Long value) {
        this.primaryAlternativeEfcMonth10 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth11 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth11() {
        return primaryAlternativeEfcMonth11;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth11(Long value) {
        this.primaryAlternativeEfcMonth11 = value;
    }

    /**
     * Gets the value of the primaryAlternativeEfcMonth12 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryAlternativeEfcMonth12() {
        return primaryAlternativeEfcMonth12;
    }

    /**
     * Sets the value of the primaryAlternativeEfcMonth12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryAlternativeEfcMonth12(Long value) {
        this.primaryAlternativeEfcMonth12 = value;
    }

}
