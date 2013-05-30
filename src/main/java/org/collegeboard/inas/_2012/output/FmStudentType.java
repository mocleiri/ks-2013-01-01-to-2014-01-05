
package org.collegeboard.inas._2012.output;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmStudentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmStudentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AwardYearCalculatedAge" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SystemCalculatedAge" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="YearInCollegeCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MembersInFamily" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MaritalStatusCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="NumberInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TaxFilerIndicator" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="ResidencyStateProvinceCode" type="{http://INAS.collegeboard.org/2012/Output/}stateProvinceType" minOccurs="0"/>
 *         &lt;element name="DataSufficient" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *         &lt;element name="BudgetDuration" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IndependentViaProfessionalJudgment" type="{http://INAS.collegeboard.org/2012/Output/}yesNoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmStudentType", propOrder = {
    "awardYearCalculatedAge",
    "systemCalculatedAge",
    "yearInCollegeCode",
    "membersInFamily",
    "maritalStatusCode",
    "numberInCollege",
    "taxFilerIndicator",
    "residencyStateProvinceCode",
    "dataSufficient",
    "budgetDuration",
    "independentViaProfessionalJudgment"
})
public class FmStudentType {

    @XmlElement(name = "AwardYearCalculatedAge", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long awardYearCalculatedAge;
    @XmlElement(name = "SystemCalculatedAge", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long systemCalculatedAge;
    @XmlElement(name = "YearInCollegeCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long yearInCollegeCode;
    @XmlElement(name = "MembersInFamily", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long membersInFamily;
    @XmlElement(name = "MaritalStatusCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maritalStatusCode;
    @XmlElement(name = "NumberInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long numberInCollege;
    @XmlElementRef(name = "TaxFilerIndicator", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> taxFilerIndicator;
    @XmlElementRef(name = "ResidencyStateProvinceCode", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<String> residencyStateProvinceCode;
    @XmlElementRef(name = "DataSufficient", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> dataSufficient;
    @XmlElementRef(name = "BudgetDuration", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> budgetDuration;
    @XmlElementRef(name = "IndependentViaProfessionalJudgment", namespace = "http://INAS.collegeboard.org/2012/Output/", type = JAXBElement.class)
    protected JAXBElement<YesNoType> independentViaProfessionalJudgment;

    /**
     * Gets the value of the awardYearCalculatedAge property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAwardYearCalculatedAge() {
        return awardYearCalculatedAge;
    }

    /**
     * Sets the value of the awardYearCalculatedAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAwardYearCalculatedAge(Long value) {
        this.awardYearCalculatedAge = value;
    }

    /**
     * Gets the value of the systemCalculatedAge property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSystemCalculatedAge() {
        return systemCalculatedAge;
    }

    /**
     * Sets the value of the systemCalculatedAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSystemCalculatedAge(Long value) {
        this.systemCalculatedAge = value;
    }

    /**
     * Gets the value of the yearInCollegeCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getYearInCollegeCode() {
        return yearInCollegeCode;
    }

    /**
     * Sets the value of the yearInCollegeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setYearInCollegeCode(Long value) {
        this.yearInCollegeCode = value;
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

    /**
     * Gets the value of the budgetDuration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getBudgetDuration() {
        return budgetDuration;
    }

    /**
     * Sets the value of the budgetDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setBudgetDuration(JAXBElement<BigDecimal> value) {
        this.budgetDuration = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the independentViaProfessionalJudgment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public JAXBElement<YesNoType> getIndependentViaProfessionalJudgment() {
        return independentViaProfessionalJudgment;
    }

    /**
     * Sets the value of the independentViaProfessionalJudgment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoType }{@code >}
     *     
     */
    public void setIndependentViaProfessionalJudgment(JAXBElement<YesNoType> value) {
        this.independentViaProfessionalJudgment = ((JAXBElement<YesNoType> ) value);
    }

}
