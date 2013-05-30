
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for imrDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="imrDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IMR" type="{http://INAS.collegeboard.org/2012/Input/}imrType" minOccurs="0"/>
 *         &lt;element name="IMRExtension" type="{http://INAS.collegeboard.org/2012/Input/}imrExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imrDataType", propOrder = {
    "imr",
    "imrExtension"
})
public class ImrDataType {

    @XmlElement(name = "IMR")
    protected ImrType imr;
    @XmlElement(name = "IMRExtension")
    protected ImrExtensionType imrExtension;

    /**
     * Gets the value of the imr property.
     * 
     * @return
     *     possible object is
     *     {@link ImrType }
     *     
     */
    public ImrType getIMR() {
        return imr;
    }

    /**
     * Sets the value of the imr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImrType }
     *     
     */
    public void setIMR(ImrType value) {
        this.imr = value;
    }

    /**
     * Gets the value of the imrExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ImrExtensionType }
     *     
     */
    public ImrExtensionType getIMRExtension() {
        return imrExtension;
    }

    /**
     * Sets the value of the imrExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImrExtensionType }
     *     
     */
    public void setIMRExtension(ImrExtensionType value) {
        this.imrExtension = value;
    }

}
