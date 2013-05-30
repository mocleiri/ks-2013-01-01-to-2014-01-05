
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
 * <p>Java class for businessFarmNetWorthEntryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="businessFarmNetWorthEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NetWorthFrom" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NetWorthTo" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="BaseAmount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PercentToApply" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "businessFarmNetWorthEntryType", propOrder = {
    "netWorthFrom",
    "netWorthTo",
    "baseAmount",
    "percentToApply"
})
public class BusinessFarmNetWorthEntryType {

    @XmlElement(name = "NetWorthFrom", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long netWorthFrom;
    @XmlElement(name = "NetWorthTo", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long netWorthTo;
    @XmlElement(name = "BaseAmount", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long baseAmount;
    @XmlElementRef(name = "PercentToApply", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> percentToApply;

    /**
     * Gets the value of the netWorthFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNetWorthFrom() {
        return netWorthFrom;
    }

    /**
     * Sets the value of the netWorthFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNetWorthFrom(Long value) {
        this.netWorthFrom = value;
    }

    /**
     * Gets the value of the netWorthTo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNetWorthTo() {
        return netWorthTo;
    }

    /**
     * Sets the value of the netWorthTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNetWorthTo(Long value) {
        this.netWorthTo = value;
    }

    /**
     * Gets the value of the baseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBaseAmount() {
        return baseAmount;
    }

    /**
     * Sets the value of the baseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBaseAmount(Long value) {
        this.baseAmount = value;
    }

    /**
     * Gets the value of the percentToApply property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPercentToApply() {
        return percentToApply;
    }

    /**
     * Sets the value of the percentToApply property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPercentToApply(JAXBElement<BigDecimal> value) {
        this.percentToApply = ((JAXBElement<BigDecimal> ) value);
    }

}
