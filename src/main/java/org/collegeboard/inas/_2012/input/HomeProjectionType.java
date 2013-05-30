
package org.collegeboard.inas._2012.input;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for homeProjectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="homeProjectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Option" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="Tolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CapHousingPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "homeProjectionType", propOrder = {
    "option",
    "tolerance",
    "capHousingPercent"
})
public class HomeProjectionType {

    @XmlElement(name = "Option", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long option;
    @XmlElement(name = "Tolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long tolerance;
    @XmlElementRef(name = "CapHousingPercent", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> capHousingPercent;

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOption() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOption(Long value) {
        this.option = value;
    }

    /**
     * Gets the value of the tolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTolerance() {
        return tolerance;
    }

    /**
     * Sets the value of the tolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTolerance(Long value) {
        this.tolerance = value;
    }

    /**
     * Gets the value of the capHousingPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCapHousingPercent() {
        return capHousingPercent;
    }

    /**
     * Sets the value of the capHousingPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCapHousingPercent(JAXBElement<BigDecimal> value) {
        this.capHousingPercent = ((JAXBElement<BigDecimal> ) value);
    }

}
