
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for depIndMinContributionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="depIndMinContributionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DependentContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="IndependentContribution" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "depIndMinContributionType", propOrder = {
    "dependentContribution",
    "independentContribution"
})
public class DepIndMinContributionType {

    @XmlElement(name = "DependentContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long dependentContribution;
    @XmlElement(name = "IndependentContribution", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long independentContribution;

    /**
     * Gets the value of the dependentContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDependentContribution() {
        return dependentContribution;
    }

    /**
     * Sets the value of the dependentContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDependentContribution(Long value) {
        this.dependentContribution = value;
    }

    /**
     * Gets the value of the independentContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIndependentContribution() {
        return independentContribution;
    }

    /**
     * Sets the value of the independentContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIndependentContribution(Long value) {
        this.independentContribution = value;
    }

}
