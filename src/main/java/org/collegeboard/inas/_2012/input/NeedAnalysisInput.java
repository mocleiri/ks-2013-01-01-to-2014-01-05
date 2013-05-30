
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for NeedAnalysisInput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NeedAnalysisInput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NeedAnalysisData" type="{http://INAS.collegeboard.org/2012/Input/}needsAnalysisRecordType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CollegeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AwardYear" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="CreatedDate" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="TransmissionId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Source" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NeedAnalysisInput", propOrder = {
    "needAnalysisData"
})
@XmlRootElement
public class NeedAnalysisInput {

    @XmlElement(name = "NeedAnalysisData")
    protected NeedsAnalysisRecordType needAnalysisData;
    @XmlAttribute(name = "CollegeCode")
    protected String collegeCode;
    @XmlAttribute(name = "AwardYear", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long awardYear;
    @XmlAttribute(name = "CreatedDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar createdDate;
    @XmlAttribute(name = "TransmissionId")
    protected String transmissionId;
    @XmlAttribute(name = "Source")
    protected String source;

    /**
     * Gets the value of the needAnalysisData property.
     * 
     * @return
     *     possible object is
     *     {@link NeedsAnalysisRecordType }
     *     
     */
    public NeedsAnalysisRecordType getNeedAnalysisData() {
        return needAnalysisData;
    }

    /**
     * Sets the value of the needAnalysisData property.
     * 
     * @param value
     *     allowed object is
     *     {@link NeedsAnalysisRecordType }
     *     
     */
    public void setNeedAnalysisData(NeedsAnalysisRecordType value) {
        this.needAnalysisData = value;
    }

    /**
     * Gets the value of the collegeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollegeCode() {
        return collegeCode;
    }

    /**
     * Sets the value of the collegeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollegeCode(String value) {
        this.collegeCode = value;
    }

    /**
     * Gets the value of the awardYear property.
     * 
     */
    public long getAwardYear() {
        return awardYear;
    }

    /**
     * Sets the value of the awardYear property.
     * 
     */
    public void setAwardYear(long value) {
        this.awardYear = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the transmissionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransmissionId() {
        return transmissionId;
    }

    /**
     * Sets the value of the transmissionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransmissionId(String value) {
        this.transmissionId = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

}
