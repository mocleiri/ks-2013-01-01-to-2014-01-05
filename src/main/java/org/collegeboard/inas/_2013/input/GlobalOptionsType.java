
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for globalOptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="globalOptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperationalOptions" type="{http://INAS.collegeboard.org/2013/Input/}operationalOptionsType" minOccurs="0"/>
 *         &lt;element name="FmOptions" type="{http://INAS.collegeboard.org/2013/Input/}fmOptionsType" minOccurs="0"/>
 *         &lt;element name="EfmOptions" type="{http://INAS.collegeboard.org/2013/Input/}efmOptionsType" minOccurs="0"/>
 *         &lt;element name="ImOptions" type="{http://INAS.collegeboard.org/2013/Input/}imOptionsType" minOccurs="0"/>
 *         &lt;element name="CompareOptions" type="{http://INAS.collegeboard.org/2013/Input/}compareOptionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "globalOptionsType", propOrder = {
    "operationalOptions",
    "fmOptions",
    "efmOptions",
    "imOptions",
    "compareOptions"
})
public class GlobalOptionsType {

    @XmlElement(name = "OperationalOptions")
    protected OperationalOptionsType operationalOptions;
    @XmlElement(name = "FmOptions")
    protected FmOptionsType fmOptions;
    @XmlElement(name = "EfmOptions")
    protected EfmOptionsType efmOptions;
    @XmlElement(name = "ImOptions")
    protected ImOptionsType imOptions;
    @XmlElement(name = "CompareOptions")
    protected CompareOptionsType compareOptions;

    /**
     * Gets the value of the operationalOptions property.
     * 
     * @return
     *     possible object is
     *     {@link OperationalOptionsType }
     *     
     */
    public OperationalOptionsType getOperationalOptions() {
        return operationalOptions;
    }

    /**
     * Sets the value of the operationalOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationalOptionsType }
     *     
     */
    public void setOperationalOptions(OperationalOptionsType value) {
        this.operationalOptions = value;
    }

    /**
     * Gets the value of the fmOptions property.
     * 
     * @return
     *     possible object is
     *     {@link FmOptionsType }
     *     
     */
    public FmOptionsType getFmOptions() {
        return fmOptions;
    }

    /**
     * Sets the value of the fmOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmOptionsType }
     *     
     */
    public void setFmOptions(FmOptionsType value) {
        this.fmOptions = value;
    }

    /**
     * Gets the value of the efmOptions property.
     * 
     * @return
     *     possible object is
     *     {@link EfmOptionsType }
     *     
     */
    public EfmOptionsType getEfmOptions() {
        return efmOptions;
    }

    /**
     * Sets the value of the efmOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link EfmOptionsType }
     *     
     */
    public void setEfmOptions(EfmOptionsType value) {
        this.efmOptions = value;
    }

    /**
     * Gets the value of the imOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ImOptionsType }
     *     
     */
    public ImOptionsType getImOptions() {
        return imOptions;
    }

    /**
     * Sets the value of the imOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImOptionsType }
     *     
     */
    public void setImOptions(ImOptionsType value) {
        this.imOptions = value;
    }

    /**
     * Gets the value of the compareOptions property.
     * 
     * @return
     *     possible object is
     *     {@link CompareOptionsType }
     *     
     */
    public CompareOptionsType getCompareOptions() {
        return compareOptions;
    }

    /**
     * Sets the value of the compareOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompareOptionsType }
     *     
     */
    public void setCompareOptions(CompareOptionsType value) {
        this.compareOptions = value;
    }

}
