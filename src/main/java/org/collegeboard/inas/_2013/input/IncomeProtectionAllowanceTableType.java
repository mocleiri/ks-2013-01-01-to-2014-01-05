
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for incomeProtectionAllowanceTableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="incomeProtectionAllowanceTableType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OneInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TwoInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ThreeInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FourInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FiveInCollege" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "incomeProtectionAllowanceTableType", propOrder = {
    "oneInCollege",
    "twoInCollege",
    "threeInCollege",
    "fourInCollege",
    "fiveInCollege"
})
public class IncomeProtectionAllowanceTableType {

    @XmlElement(name = "OneInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long oneInCollege;
    @XmlElement(name = "TwoInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long twoInCollege;
    @XmlElement(name = "ThreeInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long threeInCollege;
    @XmlElement(name = "FourInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long fourInCollege;
    @XmlElement(name = "FiveInCollege", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long fiveInCollege;

    /**
     * Gets the value of the oneInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOneInCollege() {
        return oneInCollege;
    }

    /**
     * Sets the value of the oneInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOneInCollege(Long value) {
        this.oneInCollege = value;
    }

    /**
     * Gets the value of the twoInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTwoInCollege() {
        return twoInCollege;
    }

    /**
     * Sets the value of the twoInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTwoInCollege(Long value) {
        this.twoInCollege = value;
    }

    /**
     * Gets the value of the threeInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getThreeInCollege() {
        return threeInCollege;
    }

    /**
     * Sets the value of the threeInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setThreeInCollege(Long value) {
        this.threeInCollege = value;
    }

    /**
     * Gets the value of the fourInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFourInCollege() {
        return fourInCollege;
    }

    /**
     * Sets the value of the fourInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFourInCollege(Long value) {
        this.fourInCollege = value;
    }

    /**
     * Gets the value of the fiveInCollege property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFiveInCollege() {
        return fiveInCollege;
    }

    /**
     * Sets the value of the fiveInCollege property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFiveInCollege(Long value) {
        this.fiveInCollege = value;
    }

}
