
package org.collegeboard.inas._2012.input;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for familyMemberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="familyMemberType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RelationshipCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AttendCollegeCode" type="{http://INAS.collegeboard.org/2012/Input/}attendCollegeCodeType" minOccurs="0"/>
 *         &lt;element name="CollegeTypeCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "familyMemberType", propOrder = {
    "relationshipCode",
    "age",
    "attendCollegeCode",
    "collegeTypeCode"
})
public class FamilyMemberType {

    @XmlElement(name = "RelationshipCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long relationshipCode;
    @XmlElement(name = "Age", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long age;
    @XmlElementRef(name = "AttendCollegeCode", namespace = "http://INAS.collegeboard.org/2012/Input/", type = JAXBElement.class)
    protected JAXBElement<AttendCollegeCodeType> attendCollegeCode;
    @XmlElement(name = "CollegeTypeCode", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long collegeTypeCode;

    /**
     * Gets the value of the relationshipCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRelationshipCode() {
        return relationshipCode;
    }

    /**
     * Sets the value of the relationshipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRelationshipCode(Long value) {
        this.relationshipCode = value;
    }

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAge(Long value) {
        this.age = value;
    }

    /**
     * Gets the value of the attendCollegeCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AttendCollegeCodeType }{@code >}
     *     
     */
    public JAXBElement<AttendCollegeCodeType> getAttendCollegeCode() {
        return attendCollegeCode;
    }

    /**
     * Sets the value of the attendCollegeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AttendCollegeCodeType }{@code >}
     *     
     */
    public void setAttendCollegeCode(JAXBElement<AttendCollegeCodeType> value) {
        this.attendCollegeCode = ((JAXBElement<AttendCollegeCodeType> ) value);
    }

    /**
     * Gets the value of the collegeTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCollegeTypeCode() {
        return collegeTypeCode;
    }

    /**
     * Sets the value of the collegeTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCollegeTypeCode(Long value) {
        this.collegeTypeCode = value;
    }

}
