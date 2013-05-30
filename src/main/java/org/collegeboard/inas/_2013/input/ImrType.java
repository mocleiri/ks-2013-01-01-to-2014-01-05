
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for imrType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="imrType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Student" type="{http://INAS.collegeboard.org/2013/Input/}studentType" minOccurs="0"/>
 *         &lt;element name="Parents" type="{http://INAS.collegeboard.org/2013/Input/}parentsType" minOccurs="0"/>
 *         &lt;element name="FamilyMemberList" type="{http://INAS.collegeboard.org/2013/Input/}ArrayOfFamilyMemberType" minOccurs="0"/>
 *         &lt;element name="NonCustodialParentInformation" type="{http://INAS.collegeboard.org/2013/Input/}noncustodialParentInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imrType", propOrder = {
    "student",
    "parents",
    "familyMemberList",
    "nonCustodialParentInformation"
})
public class ImrType {

    @XmlElement(name = "Student")
    protected StudentType student;
    @XmlElement(name = "Parents")
    protected ParentsType parents;
    @XmlElement(name = "FamilyMemberList")
    protected ArrayOfFamilyMemberType familyMemberList;
    @XmlElement(name = "NonCustodialParentInformation")
    protected NoncustodialParentInfoType nonCustodialParentInformation;

    /**
     * Gets the value of the student property.
     * 
     * @return
     *     possible object is
     *     {@link StudentType }
     *     
     */
    public StudentType getStudent() {
        return student;
    }

    /**
     * Sets the value of the student property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentType }
     *     
     */
    public void setStudent(StudentType value) {
        this.student = value;
    }

    /**
     * Gets the value of the parents property.
     * 
     * @return
     *     possible object is
     *     {@link ParentsType }
     *     
     */
    public ParentsType getParents() {
        return parents;
    }

    /**
     * Sets the value of the parents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentsType }
     *     
     */
    public void setParents(ParentsType value) {
        this.parents = value;
    }

    /**
     * Gets the value of the familyMemberList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFamilyMemberType }
     *     
     */
    public ArrayOfFamilyMemberType getFamilyMemberList() {
        return familyMemberList;
    }

    /**
     * Sets the value of the familyMemberList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFamilyMemberType }
     *     
     */
    public void setFamilyMemberList(ArrayOfFamilyMemberType value) {
        this.familyMemberList = value;
    }

    /**
     * Gets the value of the nonCustodialParentInformation property.
     * 
     * @return
     *     possible object is
     *     {@link NoncustodialParentInfoType }
     *     
     */
    public NoncustodialParentInfoType getNonCustodialParentInformation() {
        return nonCustodialParentInformation;
    }

    /**
     * Sets the value of the nonCustodialParentInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoncustodialParentInfoType }
     *     
     */
    public void setNonCustodialParentInformation(NoncustodialParentInfoType value) {
        this.nonCustodialParentInformation = value;
    }

}
