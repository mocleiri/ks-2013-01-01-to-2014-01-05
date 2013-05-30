
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for additionalAllowanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="additionalAllowanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TuitionAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MedicalDentalAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherIncomeAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherAssetAllowance" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OtherAssets" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "additionalAllowanceType", propOrder = {
    "tuitionAllowance",
    "medicalDentalAllowance",
    "otherIncomeAllowance",
    "otherAssetAllowance",
    "otherAssets"
})
public class AdditionalAllowanceType {

    @XmlElement(name = "TuitionAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long tuitionAllowance;
    @XmlElement(name = "MedicalDentalAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long medicalDentalAllowance;
    @XmlElement(name = "OtherIncomeAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherIncomeAllowance;
    @XmlElement(name = "OtherAssetAllowance", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherAssetAllowance;
    @XmlElement(name = "OtherAssets", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long otherAssets;

    /**
     * Gets the value of the tuitionAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTuitionAllowance() {
        return tuitionAllowance;
    }

    /**
     * Sets the value of the tuitionAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTuitionAllowance(Long value) {
        this.tuitionAllowance = value;
    }

    /**
     * Gets the value of the medicalDentalAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMedicalDentalAllowance() {
        return medicalDentalAllowance;
    }

    /**
     * Sets the value of the medicalDentalAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMedicalDentalAllowance(Long value) {
        this.medicalDentalAllowance = value;
    }

    /**
     * Gets the value of the otherIncomeAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherIncomeAllowance() {
        return otherIncomeAllowance;
    }

    /**
     * Sets the value of the otherIncomeAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherIncomeAllowance(Long value) {
        this.otherIncomeAllowance = value;
    }

    /**
     * Gets the value of the otherAssetAllowance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherAssetAllowance() {
        return otherAssetAllowance;
    }

    /**
     * Sets the value of the otherAssetAllowance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherAssetAllowance(Long value) {
        this.otherAssetAllowance = value;
    }

    /**
     * Gets the value of the otherAssets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOtherAssets() {
        return otherAssets;
    }

    /**
     * Sets the value of the otherAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOtherAssets(Long value) {
        this.otherAssets = value;
    }

}
