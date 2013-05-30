
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentInputDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentInputDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecordIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FMRData" type="{http://INAS.collegeboard.org/2012/Input/}fmrDataType" minOccurs="0"/>
 *         &lt;element name="IMRData" type="{http://INAS.collegeboard.org/2012/Input/}imrDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentInputDataType", propOrder = {
    "recordIdentifier",
    "fmrData",
    "imrData"
})
public class StudentInputDataType {

    @XmlElement(name = "RecordIdentifier")
    protected String recordIdentifier;
    @XmlElement(name = "FMRData")
    protected FmrDataType fmrData;
    @XmlElement(name = "IMRData")
    protected ImrDataType imrData;

    /**
     * Gets the value of the recordIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordIdentifier() {
        return recordIdentifier;
    }

    /**
     * Sets the value of the recordIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordIdentifier(String value) {
        this.recordIdentifier = value;
    }

    /**
     * Gets the value of the fmrData property.
     * 
     * @return
     *     possible object is
     *     {@link FmrDataType }
     *     
     */
    public FmrDataType getFMRData() {
        return fmrData;
    }

    /**
     * Sets the value of the fmrData property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmrDataType }
     *     
     */
    public void setFMRData(FmrDataType value) {
        this.fmrData = value;
    }

    /**
     * Gets the value of the imrData property.
     * 
     * @return
     *     possible object is
     *     {@link ImrDataType }
     *     
     */
    public ImrDataType getIMRData() {
        return imrData;
    }

    /**
     * Sets the value of the imrData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImrDataType }
     *     
     */
    public void setIMRData(ImrDataType value) {
        this.imrData = value;
    }

}
