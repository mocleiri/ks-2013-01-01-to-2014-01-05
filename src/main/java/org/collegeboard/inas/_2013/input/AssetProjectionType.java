
package org.collegeboard.inas._2013.input;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for assetProjectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="assetProjectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Option" type="{http://INAS.collegeboard.org/2013/Input/}assetProjectionOptionType" minOccurs="0"/>
 *         &lt;element name="CashYield1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CashLimit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CashYield2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CashTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InvestmentYield1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="InvestmentLimit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="InvestmentYield2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="InvestmentTolerance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assetProjectionType", propOrder = {
    "option",
    "cashYield1",
    "cashLimit",
    "cashYield2",
    "cashTolerance",
    "investmentYield1",
    "investmentLimit",
    "investmentYield2",
    "investmentTolerance"
})
public class AssetProjectionType {

    @XmlElementRef(name = "Option", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<AssetProjectionOptionType> option;
    @XmlElementRef(name = "CashYield1", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> cashYield1;
    @XmlElement(name = "CashLimit", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long cashLimit;
    @XmlElementRef(name = "CashYield2", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> cashYield2;
    @XmlElement(name = "CashTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long cashTolerance;
    @XmlElementRef(name = "InvestmentYield1", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> investmentYield1;
    @XmlElement(name = "InvestmentLimit", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long investmentLimit;
    @XmlElementRef(name = "InvestmentYield2", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> investmentYield2;
    @XmlElement(name = "InvestmentTolerance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long investmentTolerance;

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AssetProjectionOptionType }{@code >}
     *     
     */
    public JAXBElement<AssetProjectionOptionType> getOption() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AssetProjectionOptionType }{@code >}
     *     
     */
    public void setOption(JAXBElement<AssetProjectionOptionType> value) {
        this.option = ((JAXBElement<AssetProjectionOptionType> ) value);
    }

    /**
     * Gets the value of the cashYield1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCashYield1() {
        return cashYield1;
    }

    /**
     * Sets the value of the cashYield1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCashYield1(JAXBElement<BigDecimal> value) {
        this.cashYield1 = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the cashLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCashLimit() {
        return cashLimit;
    }

    /**
     * Sets the value of the cashLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCashLimit(Long value) {
        this.cashLimit = value;
    }

    /**
     * Gets the value of the cashYield2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCashYield2() {
        return cashYield2;
    }

    /**
     * Sets the value of the cashYield2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCashYield2(JAXBElement<BigDecimal> value) {
        this.cashYield2 = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the cashTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCashTolerance() {
        return cashTolerance;
    }

    /**
     * Sets the value of the cashTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCashTolerance(Long value) {
        this.cashTolerance = value;
    }

    /**
     * Gets the value of the investmentYield1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInvestmentYield1() {
        return investmentYield1;
    }

    /**
     * Sets the value of the investmentYield1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInvestmentYield1(JAXBElement<BigDecimal> value) {
        this.investmentYield1 = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the investmentLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvestmentLimit() {
        return investmentLimit;
    }

    /**
     * Sets the value of the investmentLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvestmentLimit(Long value) {
        this.investmentLimit = value;
    }

    /**
     * Gets the value of the investmentYield2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInvestmentYield2() {
        return investmentYield2;
    }

    /**
     * Sets the value of the investmentYield2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInvestmentYield2(JAXBElement<BigDecimal> value) {
        this.investmentYield2 = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the investmentTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvestmentTolerance() {
        return investmentTolerance;
    }

    /**
     * Sets the value of the investmentTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvestmentTolerance(Long value) {
        this.investmentTolerance = value;
    }

}
