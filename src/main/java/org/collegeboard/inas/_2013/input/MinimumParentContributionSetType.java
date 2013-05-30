
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for minimumParentContributionSetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="minimumParentContributionSetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpperIncomeLevel" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="MinimumParentContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "minimumParentContributionSetType", propOrder = {
    "upperIncomeLevel",
    "minimumParentContribution"
})
public class MinimumParentContributionSetType {

    @XmlElement(name = "UpperIncomeLevel", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long upperIncomeLevel;
    @XmlElement(name = "MinimumParentContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long minimumParentContribution;

    /**
     * Gets the value of the upperIncomeLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUpperIncomeLevel() {
        return upperIncomeLevel;
    }

    /**
     * Sets the value of the upperIncomeLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUpperIncomeLevel(Long value) {
        this.upperIncomeLevel = value;
    }

    /**
     * Gets the value of the minimumParentContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinimumParentContribution() {
        return minimumParentContribution;
    }

    /**
     * Sets the value of the minimumParentContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinimumParentContribution(Long value) {
        this.minimumParentContribution = value;
    }

}
