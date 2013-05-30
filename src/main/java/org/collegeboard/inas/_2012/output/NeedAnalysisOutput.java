
package org.collegeboard.inas._2012.output;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for NeedAnalysisOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NeedAnalysisOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NeedAnalysisData" type="{http://INAS.collegeboard.org/2012/Output/}needAnalysisDataType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CollegeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AwardYear" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="CreatedDate" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NeedAnalysisOutput", propOrder = {
    "needAnalysisData"
})
@XmlRootElement
public class NeedAnalysisOutput {

    @XmlElement(name = "NeedAnalysisData")
    protected List<NeedAnalysisDataType> needAnalysisData;
    @XmlAttribute(name = "CollegeCode")
    protected String collegeCode;
    @XmlAttribute(name = "AwardYear", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long awardYear;
    @XmlAttribute(name = "CreatedDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar createdDate;

    /**
     * Gets the value of the needAnalysisData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the needAnalysisData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNeedAnalysisData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NeedAnalysisDataType }
     * 
     * 
     */
    public List<NeedAnalysisDataType> getNeedAnalysisData() {
        if (needAnalysisData == null) {
            needAnalysisData = new ArrayList<NeedAnalysisDataType>();
        }
        return this.needAnalysisData;
    }

    /**
     * Gets the value of the collegeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollegeCode() {
        return collegeCode;
    }

    /**
     * Sets the value of the collegeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollegeCode(String value) {
        this.collegeCode = value;
    }

    /**
     * Gets the value of the awardYear property.
     * 
     */
    public long getAwardYear() {
        return awardYear;
    }

    /**
     * Sets the value of the awardYear property.
     * 
     */
    public void setAwardYear(long value) {
        this.awardYear = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

}
