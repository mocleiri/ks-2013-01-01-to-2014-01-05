
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for noncustodialParentInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="noncustodialParentInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NCPContributionOffer" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "noncustodialParentInfoType", propOrder = {
    "ncpContributionOffer"
})
public class NoncustodialParentInfoType {

    @XmlElement(name = "NCPContributionOffer", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long ncpContributionOffer;

    /**
     * Gets the value of the ncpContributionOffer property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNCPContributionOffer() {
        return ncpContributionOffer;
    }

    /**
     * Sets the value of the ncpContributionOffer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNCPContributionOffer(Long value) {
        this.ncpContributionOffer = value;
    }

}
