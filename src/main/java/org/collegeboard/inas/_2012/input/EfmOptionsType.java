
package org.collegeboard.inas._2012.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for efmOptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="efmOptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UseStudentImputedAssets" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseParentImputedAssets" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseStudentProjectedYearIncome" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseParentProjectedYearIncome" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseStudentIncomeOverrides" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseParentIncomeOverrides" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="UseProfileAssumptions" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "efmOptionsType", propOrder = {
    "useStudentImputedAssets",
    "useParentImputedAssets",
    "useStudentProjectedYearIncome",
    "useParentProjectedYearIncome",
    "useStudentIncomeOverrides",
    "useParentIncomeOverrides",
    "useProfileAssumptions"
})
public class EfmOptionsType {

    @XmlElementRef(name = "UseStudentImputedAssets", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useStudentImputedAssets;
    @XmlElementRef(name = "UseParentImputedAssets", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useParentImputedAssets;
    @XmlElementRef(name = "UseStudentProjectedYearIncome", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useStudentProjectedYearIncome;
    @XmlElementRef(name = "UseParentProjectedYearIncome", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useParentProjectedYearIncome;
    @XmlElementRef(name = "UseStudentIncomeOverrides", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useStudentIncomeOverrides;
    @XmlElementRef(name = "UseParentIncomeOverrides", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useParentIncomeOverrides;
    @XmlElementRef(name = "UseProfileAssumptions", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> useProfileAssumptions;

    /**
     * Gets the value of the useStudentImputedAssets property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseStudentImputedAssets() {
        return useStudentImputedAssets;
    }

    /**
     * Sets the value of the useStudentImputedAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseStudentImputedAssets(JAXBElement<YesNoType> value) {
        this.useStudentImputedAssets = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useParentImputedAssets property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseParentImputedAssets() {
        return useParentImputedAssets;
    }

    /**
     * Sets the value of the useParentImputedAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseParentImputedAssets(JAXBElement<YesNoType> value) {
        this.useParentImputedAssets = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useStudentProjectedYearIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseStudentProjectedYearIncome() {
        return useStudentProjectedYearIncome;
    }

    /**
     * Sets the value of the useStudentProjectedYearIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseStudentProjectedYearIncome(JAXBElement<YesNoType> value) {
        this.useStudentProjectedYearIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useParentProjectedYearIncome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseParentProjectedYearIncome() {
        return useParentProjectedYearIncome;
    }

    /**
     * Sets the value of the useParentProjectedYearIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseParentProjectedYearIncome(JAXBElement<YesNoType> value) {
        this.useParentProjectedYearIncome = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useStudentIncomeOverrides property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseStudentIncomeOverrides() {
        return useStudentIncomeOverrides;
    }

    /**
     * Sets the value of the useStudentIncomeOverrides property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseStudentIncomeOverrides(JAXBElement<YesNoType> value) {
        this.useStudentIncomeOverrides = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useParentIncomeOverrides property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseParentIncomeOverrides() {
        return useParentIncomeOverrides;
    }

    /**
     * Sets the value of the useParentIncomeOverrides property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseParentIncomeOverrides(JAXBElement<YesNoType> value) {
        this.useParentIncomeOverrides = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the useProfileAssumptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getUseProfileAssumptions() {
        return useProfileAssumptions;
    }

    /**
     * Sets the value of the useProfileAssumptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setUseProfileAssumptions(JAXBElement<YesNoType> value) {
        this.useProfileAssumptions = ((JAXBElement<YesNoType> ) value);
    }

}
