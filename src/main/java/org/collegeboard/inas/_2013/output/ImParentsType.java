
package org.collegeboard.inas._2013.output;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for imParentsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="imParentsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MaritalStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MembersInFamily" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AesaChildren" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="CesaAges" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxFilerIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ResidencyStateProvinceCode" type="{http://INAS.collegeboard.org/2013/Output/}stateProvinceType" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CountryOfResidenceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ForeignAddressIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="DataSufficient" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CalculationIndicator" type="{http://INAS.collegeboard.org/2013/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="CountryCoefficient" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imParentsType", propOrder = {
    "maritalStatusCode",
    "membersInFamily",
    "numberInCollege",
    "aesaChildren",
    "cesaAges",
    "taxFilerIndicator",
    "residencyStateProvinceCode",
    "postalCode",
    "countryOfResidenceCode",
    "foreignAddressIndicator",
    "dataSufficient",
    "calculationIndicator",
    "countryCoefficient"
})
public class ImParentsType {

    @XmlElement(name = "MaritalStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maritalStatusCode;
    @XmlElement(name = "MembersInFamily", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long membersInFamily;
    @XmlElement(name = "NumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long numberInCollege;
    @XmlElement(name = "AesaChildren", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long aesaChildren;
    @XmlElement(name = "CesaAges", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long cesaAges;
    @XmlElementRef(name = "TaxFilerIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> taxFilerIndicator;
    @XmlElementRef(name = "ResidencyStateProvinceCode", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<String> residencyStateProvinceCode;
    @XmlElement(name = "PostalCode", required = true, nillable = true)
    protected String postalCode;
    @XmlElement(name = "CountryOfResidenceCode", required = true, nillable = true)
    protected String countryOfResidenceCode;
    @XmlElementRef(name = "ForeignAddressIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> foreignAddressIndicator;
    @XmlElementRef(name = "DataSufficient", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> dataSufficient;
    @XmlElementRef(name = "CalculationIndicator", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> calculationIndicator;
    @XmlElementRef(name = "CountryCoefficient", namespace = "http://INAS.collegeboard.org/2013/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> countryCoefficient;

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
     * Gets the value of the aesaChildren property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAesaChildren() {
        return aesaChildren;
    }

    /**
     * Sets the value of the aesaChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAesaChildren(Long value) {
        this.aesaChildren = value;
    }

    /**
     * Gets the value of the cesaAges property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCesaAges() {
        return cesaAges;
    }

    /**
     * Sets the value of the cesaAges property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCesaAges(Long value) {
        this.cesaAges = value;
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
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the countryOfResidenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfResidenceCode() {
        return countryOfResidenceCode;
    }

    /**
     * Sets the value of the countryOfResidenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfResidenceCode(String value) {
        this.countryOfResidenceCode = value;
    }

    /**
     * Gets the value of the foreignAddressIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getForeignAddressIndicator() {
        return foreignAddressIndicator;
    }

    /**
     * Sets the value of the foreignAddressIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setForeignAddressIndicator(JAXBElement<YesNoType> value) {
        this.foreignAddressIndicator = ((JAXBElement<YesNoType> ) value);
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

    /**
     * Gets the value of the calculationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getCalculationIndicator() {
        return calculationIndicator;
    }

    /**
     * Sets the value of the calculationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setCalculationIndicator(JAXBElement<YesNoType> value) {
        this.calculationIndicator = ((JAXBElement<YesNoType> ) value);
    }

    /**
     * Gets the value of the countryCoefficient property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCountryCoefficient() {
        return countryCoefficient;
    }

    /**
     * Sets the value of the countryCoefficient property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCountryCoefficient(JAXBElement<BigDecimal> value) {
        this.countryCoefficient = ((JAXBElement<BigDecimal> ) value);
    }

}
