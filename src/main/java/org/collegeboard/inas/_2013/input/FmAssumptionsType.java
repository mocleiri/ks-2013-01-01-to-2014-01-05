
package org.collegeboard.inas._2013.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmAssumptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmAssumptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Assumption1ParentNumberInCollegeOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="Assumption2ParentAdjustedGrossIncomeOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="Assumption3StudentNumberInCollegeOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="Assumption4StudentAdjustedGrossIncomeOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="Assumption5ParentAdditionalDataOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="Assumption6StudentAdditonalDataOverride" type="{http://INAS.collegeboard.org/2013/Input/}yesNoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmAssumptionsType", propOrder = {
    "assumption1ParentNumberInCollegeOverride",
    "assumption2ParentAdjustedGrossIncomeOverride",
    "assumption3StudentNumberInCollegeOverride",
    "assumption4StudentAdjustedGrossIncomeOverride",
    "assumption5ParentAdditionalDataOverride",
    "assumption6StudentAdditonalDataOverride"
})
public class FmAssumptionsType {

    @XmlElementRef(name = "Assumption1ParentNumberInCollegeOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumption1ParentNumberInCollegeOverride;
    @XmlElementRef(name = "Assumption2ParentAdjustedGrossIncomeOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumption2ParentAdjustedGrossIncomeOverride;
    @XmlElementRef(name = "Assumption3StudentNumberInCollegeOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumption3StudentNumberInCollegeOverride;
    @XmlElementRef(name = "Assumption4StudentAdjustedGrossIncomeOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumption4StudentAdjustedGrossIncomeOverride;
    @XmlElementRef(name = "Assumption5ParentAdditionalDataOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumption5ParentAdditionalDataOverride;
    @XmlElementRef(name = "Assumption6StudentAdditonalDataOverride", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> assumption6StudentAdditonalDataOverride;

    /**
     * Gets the value of the assumption1ParentNumberInCollegeOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumption1ParentNumberInCollegeOverride() {
        return assumption1ParentNumberInCollegeOverride;
    }

    /**
     * Sets the value of the assumption1ParentNumberInCollegeOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumption1ParentNumberInCollegeOverride(JAXBElement<YesNoType> value) {
        this.assumption1ParentNumberInCollegeOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumption2ParentAdjustedGrossIncomeOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumption2ParentAdjustedGrossIncomeOverride() {
        return assumption2ParentAdjustedGrossIncomeOverride;
    }

    /**
     * Sets the value of the assumption2ParentAdjustedGrossIncomeOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumption2ParentAdjustedGrossIncomeOverride(JAXBElement<YesNoType> value) {
        this.assumption2ParentAdjustedGrossIncomeOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumption3StudentNumberInCollegeOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumption3StudentNumberInCollegeOverride() {
        return assumption3StudentNumberInCollegeOverride;
    }

    /**
     * Sets the value of the assumption3StudentNumberInCollegeOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumption3StudentNumberInCollegeOverride(JAXBElement<YesNoType> value) {
        this.assumption3StudentNumberInCollegeOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumption4StudentAdjustedGrossIncomeOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumption4StudentAdjustedGrossIncomeOverride() {
        return assumption4StudentAdjustedGrossIncomeOverride;
    }

    /**
     * Sets the value of the assumption4StudentAdjustedGrossIncomeOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumption4StudentAdjustedGrossIncomeOverride(JAXBElement<YesNoType> value) {
        this.assumption4StudentAdjustedGrossIncomeOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumption5ParentAdditionalDataOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumption5ParentAdditionalDataOverride() {
        return assumption5ParentAdditionalDataOverride;
    }

    /**
     * Sets the value of the assumption5ParentAdditionalDataOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumption5ParentAdditionalDataOverride(JAXBElement<YesNoType> value) {
        this.assumption5ParentAdditionalDataOverride = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the assumption6StudentAdditonalDataOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getAssumption6StudentAdditonalDataOverride() {
        return assumption6StudentAdditonalDataOverride;
    }

    /**
     * Sets the value of the assumption6StudentAdditonalDataOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setAssumption6StudentAdditonalDataOverride(JAXBElement<YesNoType> value) {
        this.assumption6StudentAdditonalDataOverride = ((JAXBElement<YesNoType> ) value);
    }

}
