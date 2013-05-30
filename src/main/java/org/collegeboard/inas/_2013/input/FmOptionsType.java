
package org.collegeboard.inas._2013.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmOptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmOptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CalculateStudentEstimatedIncomeTax" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CalculateParentEstimatedIncomeTax" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="FmIndependentBudgetDuration" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FmDependentBudgetDuration" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FmCalculateParentContributionForIndependents" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmOptionsType", propOrder = {
    "calculateStudentEstimatedIncomeTax",
    "calculateParentEstimatedIncomeTax",
    "fmIndependentBudgetDuration",
    "fmDependentBudgetDuration",
    "fmCalculateParentContributionForIndependents"
})
public class FmOptionsType {

    @XmlElementRef(name = "CalculateStudentEstimatedIncomeTax", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> calculateStudentEstimatedIncomeTax;
    @XmlElementRef(name = "CalculateParentEstimatedIncomeTax", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> calculateParentEstimatedIncomeTax;
    @XmlElement(name = "FmIndependentBudgetDuration", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long fmIndependentBudgetDuration;
    @XmlElement(name = "FmDependentBudgetDuration", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long fmDependentBudgetDuration;
    @XmlElementRef(name = "FmCalculateParentContributionForIndependents", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> fmCalculateParentContributionForIndependents;

    /**
     * Gets the value of the calculateStudentEstimatedIncomeTax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCalculateStudentEstimatedIncomeTax() {
        return calculateStudentEstimatedIncomeTax;
    }

    /**
     * Sets the value of the calculateStudentEstimatedIncomeTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCalculateStudentEstimatedIncomeTax(JAXBElement<YesNoType> value) {
        this.calculateStudentEstimatedIncomeTax = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the calculateParentEstimatedIncomeTax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCalculateParentEstimatedIncomeTax() {
        return calculateParentEstimatedIncomeTax;
    }

    /**
     * Sets the value of the calculateParentEstimatedIncomeTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCalculateParentEstimatedIncomeTax(JAXBElement<YesNoType> value) {
        this.calculateParentEstimatedIncomeTax = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the fmIndependentBudgetDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFmIndependentBudgetDuration() {
        return fmIndependentBudgetDuration;
    }

    /**
     * Sets the value of the fmIndependentBudgetDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFmIndependentBudgetDuration(Long value) {
        this.fmIndependentBudgetDuration = value;
    }

    /**
     * Gets the value of the fmDependentBudgetDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFmDependentBudgetDuration() {
        return fmDependentBudgetDuration;
    }

    /**
     * Sets the value of the fmDependentBudgetDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFmDependentBudgetDuration(Long value) {
        this.fmDependentBudgetDuration = value;
    }

    /**
     * Gets the value of the fmCalculateParentContributionForIndependents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getFmCalculateParentContributionForIndependents() {
        return fmCalculateParentContributionForIndependents;
    }

    /**
     * Sets the value of the fmCalculateParentContributionForIndependents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setFmCalculateParentContributionForIndependents(JAXBElement<YesNoType> value) {
        this.fmCalculateParentContributionForIndependents = ((JAXBElement<YesNoType> ) value);
    }

}
