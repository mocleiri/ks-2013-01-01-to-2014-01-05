//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.15 at 04:57:41 PM EST 
//


package com.sigmasys.kuali.ksa.model.export;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for batchType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="batchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header" type="{http://www.kuali.org/kfs/gl/collector}headerType"/>
 *         &lt;sequence maxOccurs="unbounded">
 *           &lt;element name="glEntry" type="{http://www.kuali.org/kfs/gl/collector}glEntryType" minOccurs="0"/>
 *           &lt;element name="detail" type="{http://www.kuali.org/kfs/gl/collector}detailType" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="trailer" type="{http://www.kuali.org/kfs/gl/collector}trailerType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "batchType", propOrder = {
        "header",
        "glEntryAndDetail",
        "trailer"
})
@XmlRootElement(name = "batch")
public class BatchType {

    @XmlElement(required = true)
    protected HeaderType header;

    @XmlElements({
            @XmlElement(name = "detail", type = DetailType.class),
            @XmlElement(name = "glEntry", type = GlEntryType.class)
    })
    protected List<Object> glEntryAndDetail;

    @XmlElement(required = true)
    protected TrailerType trailer;

    /**
     * Gets the value of the header property.
     *
     * @return possible object is
     *         {@link HeaderType }
     */
    public HeaderType getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value allowed object is
     *              {@link HeaderType }
     */
    public void setHeader(HeaderType value) {
        this.header = value;
    }

    /**
     * Gets the value of the glEntryAndDetail property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the glEntryAndDetail property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlEntryAndDetail().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link DetailType }
     * {@link GlEntryType }
     */
    public List<Object> getGlEntryAndDetail() {
        if (glEntryAndDetail == null) {
            glEntryAndDetail = new ArrayList<Object>();
        }
        return this.glEntryAndDetail;
    }

    /**
     * Gets the value of the trailer property.
     *
     * @return possible object is
     *         {@link TrailerType }
     */
    public TrailerType getTrailer() {
        return trailer;
    }

    /**
     * Sets the value of the trailer property.
     *
     * @param value allowed object is
     *              {@link TrailerType }
     */
    public void setTrailer(TrailerType value) {
        this.trailer = value;
    }

}
