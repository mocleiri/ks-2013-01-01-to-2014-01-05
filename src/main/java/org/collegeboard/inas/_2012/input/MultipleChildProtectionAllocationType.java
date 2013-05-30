
package org.collegeboard.inas._2012.input;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for multipleChildProtectionAllocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="multipleChildProtectionAllocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AllocationPercent1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AllocationPercent2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AllocationPercent3" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multipleChildProtectionAllocationType", propOrder = {
    "allocationPercent1",
    "allocationPercent2",
    "allocationPercent3"
})
public class MultipleChildProtectionAllocationType {

    @XmlElementRef(name = "AllocationPercent1", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> allocationPercent1;
    @XmlElementRef(name = "AllocationPercent2", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> allocationPercent2;
    @XmlElementRef(name = "AllocationPercent3", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> allocationPercent3;

    /**
     * Gets the value of the allocationPercent1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAllocationPercent1() {
        return allocationPercent1;
    }

    /**
     * Sets the value of the allocationPercent1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAllocationPercent1(JAXBElement<BigDecimal> value) {
        this.allocationPercent1 = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the allocationPercent2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAllocationPercent2() {
        return allocationPercent2;
    }

    /**
     * Sets the value of the allocationPercent2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAllocationPercent2(JAXBElement<BigDecimal> value) {
        this.allocationPercent2 = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the allocationPercent3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAllocationPercent3() {
        return allocationPercent3;
    }

    /**
     * Sets the value of the allocationPercent3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAllocationPercent3(JAXBElement<BigDecimal> value) {
        this.allocationPercent3 = ((JAXBElement<BigDecimal> ) value);
    }

}
