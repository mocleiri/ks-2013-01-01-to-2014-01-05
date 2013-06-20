
package org.kuali.student.security.addressing.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for EndpointReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EndpointReferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://schemas.xmlsoap.org/ws/2004/08/addressing}AttributedURI"/>
 *         &lt;element name="ReferenceProperties" type="{http://schemas.xmlsoap.org/ws/2004/08/addressing}ReferencePropertiesType" minOccurs="0"/>
 *         &lt;element name="ReferenceParameters" type="{http://schemas.xmlsoap.org/ws/2004/08/addressing}ReferenceParametersType" minOccurs="0"/>
 *         &lt;element name="PortType" type="{http://schemas.xmlsoap.org/ws/2004/08/addressing}AttributedQName" minOccurs="0"/>
 *         &lt;element name="ServiceName" type="{http://schemas.xmlsoap.org/ws/2004/08/addressing}ServiceNameType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndpointReferenceType", propOrder = {
    "address",
    "referenceProperties",
    "referenceParameters",
    "portType",
    "serviceName",
    "any"
})
public class EndpointReferenceType {

    @XmlElement(name = "Address", required = true)
    protected AttributedURI address;
    @XmlElement(name = "ReferenceProperties")
    protected ReferencePropertiesType referenceProperties;
    @XmlElement(name = "ReferenceParameters")
    protected ReferenceParametersType referenceParameters;
    @XmlElement(name = "PortType")
    protected AttributedQName portType;
    @XmlElement(name = "ServiceName")
    protected ServiceNameType serviceName;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AttributedURI }
     *     
     */
    public AttributedURI getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributedURI }
     *     
     */
    public void setAddress(AttributedURI value) {
        this.address = value;
    }

    /**
     * Gets the value of the referenceProperties property.
     * 
     * @return
     *     possible object is
     *     {@link ReferencePropertiesType }
     *     
     */
    public ReferencePropertiesType getReferenceProperties() {
        return referenceProperties;
    }

    /**
     * Sets the value of the referenceProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencePropertiesType }
     *     
     */
    public void setReferenceProperties(ReferencePropertiesType value) {
        this.referenceProperties = value;
    }

    /**
     * Gets the value of the referenceParameters property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceParametersType }
     *     
     */
    public ReferenceParametersType getReferenceParameters() {
        return referenceParameters;
    }

    /**
     * Sets the value of the referenceParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceParametersType }
     *     
     */
    public void setReferenceParameters(ReferenceParametersType value) {
        this.referenceParameters = value;
    }

    /**
     * Gets the value of the portType property.
     * 
     * @return
     *     possible object is
     *     {@link AttributedQName }
     *     
     */
    public AttributedQName getPortType() {
        return portType;
    }

    /**
     * Sets the value of the portType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributedQName }
     *     
     */
    public void setPortType(AttributedQName value) {
        this.portType = value;
    }

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceNameType }
     *     
     */
    public ServiceNameType getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceNameType }
     *     
     */
    public void setServiceName(ServiceNameType value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
