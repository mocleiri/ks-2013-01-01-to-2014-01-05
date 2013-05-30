
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmrDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmrDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FMR" type="{http://INAS.collegeboard.org/2012/Input/}fmrType" minOccurs="0"/>
 *         &lt;element name="FMRExtension" type="{http://INAS.collegeboard.org/2012/Input/}fmrExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmrDataType", propOrder = {
    "fmr",
    "fmrExtension"
})
public class FmrDataType {

    @XmlElement(name = "FMR")
    protected FmrType fmr;
    @XmlElement(name = "FMRExtension")
    protected FmrExtensionType fmrExtension;

    /**
     * Gets the value of the fmr property.
     * 
     * @return
     *     possible object is
     *     {@link FmrType }
     *     
     */
    public FmrType getFMR() {
        return fmr;
    }

    /**
     * Sets the value of the fmr property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmrType }
     *     
     */
    public void setFMR(FmrType value) {
        this.fmr = value;
    }

    /**
     * Gets the value of the fmrExtension property.
     * 
     * @return
     *     possible object is
     *     {@link FmrExtensionType }
     *     
     */
    public FmrExtensionType getFMRExtension() {
        return fmrExtension;
    }

    /**
     * Sets the value of the fmrExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmrExtensionType }
     *     
     */
    public void setFMRExtension(FmrExtensionType value) {
        this.fmrExtension = value;
    }

}
