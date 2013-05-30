
package org.collegeboard.inas._2013.input;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for needsAnalysisRecordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="needsAnalysisRecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StudentInputData" type="{http://INAS.collegeboard.org/2013/Input/}studentInputDataType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GlobalOptions" type="{http://INAS.collegeboard.org/2013/Input/}globalOptionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "needsAnalysisRecordType", propOrder = {
    "studentInputData",
    "globalOptions"
})
public class NeedsAnalysisRecordType {

    @XmlElement(name = "StudentInputData")
    protected List<StudentInputDataType> studentInputData;
    @XmlElement(name = "GlobalOptions")
    protected GlobalOptionsType globalOptions;

    /**
     * Gets the value of the studentInputData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentInputData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentInputData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StudentInputDataType }
     * 
     * 
     */
    public List<StudentInputDataType> getStudentInputData() {
        if (studentInputData == null) {
            studentInputData = new ArrayList<StudentInputDataType>();
        }
        return this.studentInputData;
    }

    /**
     * Gets the value of the globalOptions property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalOptionsType }
     *     
     */
    public GlobalOptionsType getGlobalOptions() {
        return globalOptions;
    }

    /**
     * Sets the value of the globalOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalOptionsType }
     *     
     */
    public void setGlobalOptions(GlobalOptionsType value) {
        this.globalOptions = value;
    }

}
