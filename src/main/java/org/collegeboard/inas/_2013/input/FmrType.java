
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fmrType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmrType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Student" type="{http://INAS.collegeboard.org/2013/Input/}fmStudentType" minOccurs="0"/>
 *         &lt;element name="Parents" type="{http://INAS.collegeboard.org/2013/Input/}fmParentsType" minOccurs="0"/>
 *         &lt;element name="Other" type="{http://INAS.collegeboard.org/2013/Input/}fmOtherType" minOccurs="0"/>
 *         &lt;element name="Assumptions" type="{http://INAS.collegeboard.org/2013/Input/}fmAssumptionsType" minOccurs="0"/>
 *         &lt;element name="Rejects" type="{http://INAS.collegeboard.org/2013/Input/}fmRejectsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmrType", propOrder = {
    "student",
    "parents",
    "other",
    "assumptions",
    "rejects"
})
public class FmrType {

    @XmlElement(name = "Student")
    protected FmStudentType student;
    @XmlElement(name = "Parents")
    protected FmParentsType parents;
    @XmlElement(name = "Other")
    protected FmOtherType other;
    @XmlElement(name = "Assumptions")
    protected FmAssumptionsType assumptions;
    @XmlElement(name = "Rejects")
    protected FmRejectsType rejects;

    /**
     * Gets the value of the student property.
     * 
     * @return
     *     possible object is
     *     {@link FmStudentType }
     *     
     */
    public FmStudentType getStudent() {
        return student;
    }

    /**
     * Sets the value of the student property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmStudentType }
     *     
     */
    public void setStudent(FmStudentType value) {
        this.student = value;
    }

    /**
     * Gets the value of the parents property.
     * 
     * @return
     *     possible object is
     *     {@link FmParentsType }
     *     
     */
    public FmParentsType getParents() {
        return parents;
    }

    /**
     * Sets the value of the parents property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmParentsType }
     *     
     */
    public void setParents(FmParentsType value) {
        this.parents = value;
    }

    /**
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link FmOtherType }
     *     
     */
    public FmOtherType getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmOtherType }
     *     
     */
    public void setOther(FmOtherType value) {
        this.other = value;
    }

    /**
     * Gets the value of the assumptions property.
     * 
     * @return
     *     possible object is
     *     {@link FmAssumptionsType }
     *     
     */
    public FmAssumptionsType getAssumptions() {
        return assumptions;
    }

    /**
     * Sets the value of the assumptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmAssumptionsType }
     *     
     */
    public void setAssumptions(FmAssumptionsType value) {
        this.assumptions = value;
    }

    /**
     * Gets the value of the rejects property.
     * 
     * @return
     *     possible object is
     *     {@link FmRejectsType }
     *     
     */
    public FmRejectsType getRejects() {
        return rejects;
    }

    /**
     * Sets the value of the rejects property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmRejectsType }
     *     
     */
    public void setRejects(FmRejectsType value) {
        this.rejects = value;
    }

}
