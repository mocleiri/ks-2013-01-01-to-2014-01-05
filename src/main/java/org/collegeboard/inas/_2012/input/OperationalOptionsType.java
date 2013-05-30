
package org.collegeboard.inas._2012.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operationalOptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operationalOptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActivateStudentImrIsirComparison" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ActivateParentImrIsirComparison" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ActivateDataMigration" type="{http://INAS.collegeboard.org/2012/Input/}activateDataMigrationType" minOccurs="0"/>
 *         &lt;element name="DataToMigrate" type="{http://INAS.collegeboard.org/2012/Input/}dataToMigrateType" minOccurs="0"/>
 *         &lt;element name="LimitReportingBasedOnToleranceLimits" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="GenerateProfileEditMessages" type="{http://INAS.collegeboard.org/2012/Input/}yesNoType" minOccurs="0"/>
 *         &lt;element name="InstDefaultResidencyState" type="{http://INAS.collegeboard.org/2012/Input/}stateProvinceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operationalOptionsType", propOrder = {
    "activateStudentImrIsirComparison",
    "activateParentImrIsirComparison",
    "activateDataMigration",
    "dataToMigrate",
    "limitReportingBasedOnToleranceLimits",
    "generateProfileEditMessages",
    "instDefaultResidencyState"
})
public class OperationalOptionsType {

    @XmlElementRef(name = "ActivateStudentImrIsirComparison", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> activateStudentImrIsirComparison;
    @XmlElementRef(name = "ActivateParentImrIsirComparison", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> activateParentImrIsirComparison;
    @XmlElementRef(name = "ActivateDataMigration", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<ActivateDataMigrationType> activateDataMigration;
    @XmlElementRef(name = "DataToMigrate", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<DataToMigrateType> dataToMigrate;
    @XmlElementRef(name = "LimitReportingBasedOnToleranceLimits", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> limitReportingBasedOnToleranceLimits;
    @XmlElementRef(name = "GenerateProfileEditMessages", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> generateProfileEditMessages;
    @XmlElementRef(name = "InstDefaultResidencyState", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<StateProvinceType> instDefaultResidencyState;

    /**
     * Gets the value of the activateStudentImrIsirComparison property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getActivateStudentImrIsirComparison() {
        return activateStudentImrIsirComparison;
    }

    /**
     * Sets the value of the activateStudentImrIsirComparison property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setActivateStudentImrIsirComparison(JAXBElement<YesNoType> value) {
        this.activateStudentImrIsirComparison = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the activateParentImrIsirComparison property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getActivateParentImrIsirComparison() {
        return activateParentImrIsirComparison;
    }

    /**
     * Sets the value of the activateParentImrIsirComparison property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setActivateParentImrIsirComparison(JAXBElement<YesNoType> value) {
        this.activateParentImrIsirComparison = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the activateDataMigration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ActivateDataMigrationType }{@code >}
     *     
     */
    public JAXBElement<ActivateDataMigrationType> getActivateDataMigration() {
        return activateDataMigration;
    }

    /**
     * Sets the value of the activateDataMigration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ActivateDataMigrationType }{@code >}
     *     
     */
    public void setActivateDataMigration(JAXBElement<ActivateDataMigrationType> value) {
        this.activateDataMigration = ((JAXBElement<ActivateDataMigrationType> ) value);
    }

    /**
     * Gets the value of the dataToMigrate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DataToMigrateType }{@code >}
     *     
     */
    public JAXBElement<DataToMigrateType> getDataToMigrate() {
        return dataToMigrate;
    }

    /**
     * Sets the value of the dataToMigrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DataToMigrateType }{@code >}
     *     
     */
    public void setDataToMigrate(JAXBElement<DataToMigrateType> value) {
        this.dataToMigrate = ((JAXBElement<DataToMigrateType> ) value);
    }

    /**
     * Gets the value of the limitReportingBasedOnToleranceLimits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getLimitReportingBasedOnToleranceLimits() {
        return limitReportingBasedOnToleranceLimits;
    }

    /**
     * Sets the value of the limitReportingBasedOnToleranceLimits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setLimitReportingBasedOnToleranceLimits(JAXBElement<YesNoType> value) {
        this.limitReportingBasedOnToleranceLimits = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the generateProfileEditMessages property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getGenerateProfileEditMessages() {
        return generateProfileEditMessages;
    }

    /**
     * Sets the value of the generateProfileEditMessages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setGenerateProfileEditMessages(JAXBElement<YesNoType> value) {
        this.generateProfileEditMessages = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the instDefaultResidencyState property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}
     *     
     */
    public JAXBElement<StateProvinceType> getInstDefaultResidencyState() {
        return instDefaultResidencyState;
    }

    /**
     * Sets the value of the instDefaultResidencyState property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StateProvinceType }{@code >}
     *     
     */
    public void setInstDefaultResidencyState(JAXBElement<StateProvinceType> value) {
        this.instDefaultResidencyState = ((JAXBElement<StateProvinceType> ) value);
    }

}
