
package org.kuali.student.security.policy.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for OperatorContentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperatorContentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://schemas.xmlsoap.org/ws/2004/09/policy}Policy"/>
 *           &lt;element ref="{http://schemas.xmlsoap.org/ws/2004/09/policy}All"/>
 *           &lt;element ref="{http://schemas.xmlsoap.org/ws/2004/09/policy}ExactlyOne"/>
 *           &lt;element ref="{http://schemas.xmlsoap.org/ws/2004/09/policy}PolicyReference"/>
 *           &lt;any processContents='lax' namespace='##other'/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperatorContentType", propOrder = {
    "policyOrAllOrExactlyOne"
})
@XmlSeeAlso({
    Policy.class
})
public class OperatorContentType {

    @XmlElementRefs({
        @XmlElementRef(name = "PolicyReference", namespace = "http://schemas.xmlsoap.org/ws/2004/09/policy", type = PolicyReference.class),
        @XmlElementRef(name = "All", namespace = "http://schemas.xmlsoap.org/ws/2004/09/policy", type = JAXBElement.class),
        @XmlElementRef(name = "Policy", namespace = "http://schemas.xmlsoap.org/ws/2004/09/policy", type = Policy.class),
        @XmlElementRef(name = "ExactlyOne", namespace = "http://schemas.xmlsoap.org/ws/2004/09/policy", type = JAXBElement.class)
    })
    @XmlAnyElement(lax = true)
    protected List<Object> policyOrAllOrExactlyOne;

    /**
     * Gets the value of the policyOrAllOrExactlyOne property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the policyOrAllOrExactlyOne property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolicyOrAllOrExactlyOne().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link PolicyReference }
     * {@link JAXBElement }{@code <}{@link OperatorContentType }{@code >}
     * {@link Element }
     * {@link JAXBElement }{@code <}{@link OperatorContentType }{@code >}
     * {@link Policy }
     * 
     * 
     */
    public List<Object> getPolicyOrAllOrExactlyOne() {
        if (policyOrAllOrExactlyOne == null) {
            policyOrAllOrExactlyOne = new ArrayList<Object>();
        }
        return this.policyOrAllOrExactlyOne;
    }

}
