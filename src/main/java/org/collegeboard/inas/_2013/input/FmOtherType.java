
package org.collegeboard.inas._2013.input;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for fmOtherType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fmOtherType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DependencyStatus" type="{http://INAS.collegeboard.org/2013/Input/}dependencyStatusType" minOccurs="0"/>
 *         &lt;element name="DependencyStatusOverride" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ProfessionalJudgment" type="{http://INAS.collegeboard.org/2013/Input/}professionalJudgmentType" minOccurs="0"/>
 *         &lt;element name="StudentAidReportComments" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ApplicationReceiptDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ApplicationCompleteDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ApplicationSignedBy" type="{http://INAS.collegeboard.org/2013/Input/}appSignedByType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fmOtherType", propOrder = {
    "dependencyStatus",
    "dependencyStatusOverride",
    "professionalJudgment",
    "studentAidReportComments",
    "applicationReceiptDate",
    "applicationCompleteDate",
    "applicationSignedBy"
})
public class FmOtherType {

    @XmlElementRef(name = "DependencyStatus", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<DependencyStatusType> dependencyStatus;
    @XmlElement(name = "DependencyStatusOverride", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long dependencyStatusOverride;
    @XmlElementRef(name = "ProfessionalJudgment", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<String> professionalJudgment;
    @XmlElement(name = "StudentAidReportComments", nillable = true)
    protected List<String> studentAidReportComments;
    @XmlElementRef(name = "ApplicationReceiptDate", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> applicationReceiptDate;
    @XmlElementRef(name = "ApplicationCompleteDate", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> applicationCompleteDate;
    @XmlElementRef(name = "ApplicationSignedBy", namespace = "http://INAS.collegeboard.org/2013/Input/", type = JAXBElement.class)
    protected JAXBElement<AppSignedByType> applicationSignedBy;

    /**
     * Gets the value of the dependencyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DependencyStatusType }{@code >}
     *     
     */
    public JAXBElement<DependencyStatusType> getDependencyStatus() {
        return dependencyStatus;
    }

    /**
     * Sets the value of the dependencyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DependencyStatusType }{@code >}
     *     
     */
    public void setDependencyStatus(JAXBElement<DependencyStatusType> value) {
        this.dependencyStatus = ((JAXBElement<DependencyStatusType> ) value);
    }

    /**
     * Gets the value of the dependencyStatusOverride property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDependencyStatusOverride() {
        return dependencyStatusOverride;
    }

    /**
     * Sets the value of the dependencyStatusOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDependencyStatusOverride(Long value) {
        this.dependencyStatusOverride = value;
    }

    /**
     * Gets the value of the professionalJudgment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProfessionalJudgment() {
        return professionalJudgment;
    }

    /**
     * Sets the value of the professionalJudgment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProfessionalJudgment(JAXBElement<String> value) {
        this.professionalJudgment = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the studentAidReportComments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentAidReportComments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentAidReportComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getStudentAidReportComments() {
        if (studentAidReportComments == null) {
            studentAidReportComments = new ArrayList<String>();
        }
        return this.studentAidReportComments;
    }

    /**
     * Gets the value of the applicationReceiptDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getApplicationReceiptDate() {
        return applicationReceiptDate;
    }

    /**
     * Sets the value of the applicationReceiptDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setApplicationReceiptDate(JAXBElement<XMLGregorianCalendar> value) {
        this.applicationReceiptDate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the applicationCompleteDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getApplicationCompleteDate() {
        return applicationCompleteDate;
    }

    /**
     * Sets the value of the applicationCompleteDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setApplicationCompleteDate(JAXBElement<XMLGregorianCalendar> value) {
        this.applicationCompleteDate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the applicationSignedBy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AppSignedByType }{@code >}
     *     
     */
    public JAXBElement<AppSignedByType> getApplicationSignedBy() {
        return applicationSignedBy;
    }

    /**
     * Sets the value of the applicationSignedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AppSignedByType }{@code >}
     *     
     */
    public void setApplicationSignedBy(JAXBElement<AppSignedByType> value) {
        this.applicationSignedBy = ((JAXBElement<AppSignedByType> ) value);
    }

}
