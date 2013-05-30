
package org.collegeboard.inas._2013.output;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculationOverviewType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculationOverviewType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InarScenario" type="{http://INAS.collegeboard.org/2013/Output/}inarScenarioType" minOccurs="0"/>
 *         &lt;element name="ImFormula" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="EfmFormula" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FmFormula" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculationOverviewType", propOrder = {
    "inarScenario",
    "imFormula",
    "efmFormula",
    "fmFormula"
})
public class CalculationOverviewType {

    @XmlElementRef(name = "InarScenario", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<InarScenarioType> inarScenario;
    @XmlElement(name = "ImFormula", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long imFormula;
    @XmlElement(name = "EfmFormula", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long efmFormula;
    @XmlElement(name = "FmFormula", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long fmFormula;

    /**
     * Gets the value of the inarScenario property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InarScenarioType }{@code >}
     *     
     */
    public JAXBElement<InarScenarioType> getInarScenario() {
        return inarScenario;
    }

    /**
     * Sets the value of the inarScenario property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InarScenarioType }{@code >}
     *     
     */
    public void setInarScenario(JAXBElement<InarScenarioType> value) {
        this.inarScenario = ((JAXBElement<InarScenarioType> ) value);
    }

    /**
     * Gets the value of the imFormula property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getImFormula() {
        return imFormula;
    }

    /**
     * Sets the value of the imFormula property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setImFormula(Long value) {
        this.imFormula = value;
    }

    /**
     * Gets the value of the efmFormula property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEfmFormula() {
        return efmFormula;
    }

    /**
     * Sets the value of the efmFormula property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEfmFormula(Long value) {
        this.efmFormula = value;
    }

    /**
     * Gets the value of the fmFormula property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFmFormula() {
        return fmFormula;
    }

    /**
     * Sets the value of the fmFormula property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFmFormula(Long value) {
        this.fmFormula = value;
    }

}
