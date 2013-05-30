
package org.collegeboard.inas._2012.output;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmParentsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmParentsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MaritalStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MembersInFamily" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxFilerIndicator" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ResidencyStateProvinceCode" type="{http://INAS.collegeboard.org/2012/Output/}stateProvinceType" minOccurs="0"/>
 *         &lt;element name="DataSufficient" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmParentsType", propOrder = {
    "maritalStatusCode",
    "membersInFamily",
    "numberInCollege",
    "taxFilerIndicator",
    "residencyStateProvinceCode",
    "dataSufficient"
})
public class FmParentsType {

    @XmlElement(name = "MaritalStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maritalStatusCode;
    @XmlElement(name = "MembersInFamily", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long membersInFamily;
    @XmlElement(name = "NumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long numberInCollege;
    @XmlElementRef(name = "TaxFilerIndicator", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> taxFilerIndicator;
    @XmlElementRef(name = "ResidencyStateProvinceCode", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<String> residencyStateProvinceCode;
    @XmlElementRef(name = "DataSufficient", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> dataSufficient;

    /**
     * Gets the value of the maritalStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaritalStatusCode() {
        return maritalStatusCode;
    }

    /**
     * Sets the value of the maritalStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaritalStatusCode(Long value) {
        this.maritalStatusCode = value;
    }

    /**
     * Gets the value of the membersInFamily property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMembersInFamily() {
        return membersInFamily;
    }

    /**
     * Sets the value of the membersInFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMembersInFamily(Long value) {
        this.membersInFamily = value;
    }

    /**
     * Gets the value of the numberInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumberInCollege() {
        return numberInCollege;
    }

    /**
     * Sets the value of the numberInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumberInCollege(Long value) {
        this.numberInCollege = value;
    }

    /**
     * Gets the value of the taxFilerIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getTaxFilerIndicator() {
        return taxFilerIndicator;
    }

    /**
     * Sets the value of the taxFilerIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setTaxFilerIndicator(JAXBElement<YesNoType> value) {
        this.taxFilerIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the residencyStateProvinceCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResidencyStateProvinceCode() {
        return residencyStateProvinceCode;
    }

    /**
     * Sets the value of the residencyStateProvinceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResidencyStateProvinceCode(JAXBElement<String> value) {
        this.residencyStateProvinceCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dataSufficient property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getDataSufficient() {
        return dataSufficient;
    }

    /**
     * Sets the value of the dataSufficient property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setDataSufficient(JAXBElement<YesNoType> value) {
        this.dataSufficient = ((JAXBElement<YesNoType> ) value);
    }

}
