
package org.collegeboard.inas._2012.output;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for needAnalysisDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="needAnalysisDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CalculationOverview" type="{http://INAS.collegeboard.org/2012/Output/}calculationOverviewType" minOccurs="0"/>
 *         &lt;element name="StudentIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ImStudent" type="{http://INAS.collegeboard.org/2012/Output/}imStudentType" minOccurs="0"/>
 *         &lt;element name="FmStudent" type="{http://INAS.collegeboard.org/2012/Output/}fmStudentType" minOccurs="0"/>
 *         &lt;element name="ImParents" type="{http://INAS.collegeboard.org/2012/Output/}imParentsType" minOccurs="0"/>
 *         &lt;element name="FmParents" type="{http://INAS.collegeboard.org/2012/Output/}fmParentsType" minOccurs="0"/>
 *         &lt;element name="NeedAnalysisResultSet" type="{http://INAS.collegeboard.org/2012/Output/}ArrayOfNeedAnalysisResultType" minOccurs="0"/>
 *         &lt;element name="MessageList" type="{http://INAS.collegeboard.org/2012/Output/}ArrayOfMessageType" minOccurs="0"/>
 *         &lt;element name="MiscCalculations" type="{http://INAS.collegeboard.org/2012/Output/}miscCalculationsType" minOccurs="0"/>
 *         &lt;element name="ImrExtension" type="{http://INAS.collegeboard.org/2012/Output/}imrExtensionType" minOccurs="0"/>
 *         &lt;element name="FmOutput" type="{http://INAS.collegeboard.org/2012/Output/}fmOutputType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "needAnalysisDataType", propOrder = {
    "calculationOverview",
    "studentIdentifier",
    "imStudent",
    "fmStudent",
    "imParents",
    "fmParents",
    "needAnalysisResultSet",
    "messageList",
    "miscCalculations",
    "imrExtension",
    "fmOutput"
})
public class NeedAnalysisDataType {

    @XmlElement(name = "CalculationOverview")
    protected CalculationOverviewType calculationOverview;
    @XmlElement(name = "StudentIdentifier", required = true, nillable = true)
    protected String studentIdentifier;
    @XmlElement(name = "ImStudent")
    protected ImStudentType imStudent;
    @XmlElement(name = "FmStudent")
    protected FmStudentType fmStudent;
    @XmlElement(name = "ImParents")
    protected ImParentsType imParents;
    @XmlElement(name = "FmParents")
    protected FmParentsType fmParents;
    @XmlElement(name = "NeedAnalysisResultSet")
    protected ArrayOfNeedAnalysisResultType needAnalysisResultSet;
    @XmlElement(name = "MessageList")
    protected ArrayOfMessageType messageList;
    @XmlElement(name = "MiscCalculations")
    protected MiscCalculationsType miscCalculations;
    @XmlElement(name = "ImrExtension")
    protected ImrExtensionType imrExtension;
    @XmlElement(name = "FmOutput")
    protected FmOutputType fmOutput;

    /**
     * Gets the value of the calculationOverview property.
     * 
     * @return
     *     possible object is
     *     {@link CalculationOverviewType }
     *     
     */
    public CalculationOverviewType getCalculationOverview() {
        return calculationOverview;
    }

    /**
     * Sets the value of the calculationOverview property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculationOverviewType }
     *     
     */
    public void setCalculationOverview(CalculationOverviewType value) {
        this.calculationOverview = value;
    }

    /**
     * Gets the value of the studentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    /**
     * Sets the value of the studentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStudentIdentifier(String value) {
        this.studentIdentifier = value;
    }

    /**
     * Gets the value of the imStudent property.
     * 
     * @return
     *     possible object is
     *     {@link ImStudentType }
     *     
     */
    public ImStudentType getImStudent() {
        return imStudent;
    }

    /**
     * Sets the value of the imStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImStudentType }
     *     
     */
    public void setImStudent(ImStudentType value) {
        this.imStudent = value;
    }

    /**
     * Gets the value of the fmStudent property.
     * 
     * @return
     *     possible object is
     *     {@link FmStudentType }
     *     
     */
    public FmStudentType getFmStudent() {
        return fmStudent;
    }

    /**
     * Sets the value of the fmStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmStudentType }
     *     
     */
    public void setFmStudent(FmStudentType value) {
        this.fmStudent = value;
    }

    /**
     * Gets the value of the imParents property.
     * 
     * @return
     *     possible object is
     *     {@link ImParentsType }
     *     
     */
    public ImParentsType getImParents() {
        return imParents;
    }

    /**
     * Sets the value of the imParents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImParentsType }
     *     
     */
    public void setImParents(ImParentsType value) {
        this.imParents = value;
    }

    /**
     * Gets the value of the fmParents property.
     * 
     * @return
     *     possible object is
     *     {@link FmParentsType }
     *     
     */
    public FmParentsType getFmParents() {
        return fmParents;
    }

    /**
     * Sets the value of the fmParents property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmParentsType }
     *     
     */
    public void setFmParents(FmParentsType value) {
        this.fmParents = value;
    }

    /**
     * Gets the value of the needAnalysisResultSet property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfNeedAnalysisResultType }
     *     
     */
    public ArrayOfNeedAnalysisResultType getNeedAnalysisResultSet() {
        return needAnalysisResultSet;
    }

    /**
     * Sets the value of the needAnalysisResultSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfNeedAnalysisResultType }
     *     
     */
    public void setNeedAnalysisResultSet(ArrayOfNeedAnalysisResultType value) {
        this.needAnalysisResultSet = value;
    }

    /**
     * Gets the value of the messageList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMessageType }
     *     
     */
    public ArrayOfMessageType getMessageList() {
        return messageList;
    }

    /**
     * Sets the value of the messageList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMessageType }
     *     
     */
    public void setMessageList(ArrayOfMessageType value) {
        this.messageList = value;
    }

    /**
     * Gets the value of the miscCalculations property.
     * 
     * @return
     *     possible object is
     *     {@link MiscCalculationsType }
     *     
     */
    public MiscCalculationsType getMiscCalculations() {
        return miscCalculations;
    }

    /**
     * Sets the value of the miscCalculations property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiscCalculationsType }
     *     
     */
    public void setMiscCalculations(MiscCalculationsType value) {
        this.miscCalculations = value;
    }

    /**
     * Gets the value of the imrExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ImrExtensionType }
     *     
     */
    public ImrExtensionType getImrExtension() {
        return imrExtension;
    }

    /**
     * Sets the value of the imrExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImrExtensionType }
     *     
     */
    public void setImrExtension(ImrExtensionType value) {
        this.imrExtension = value;
    }

    /**
     * Gets the value of the fmOutput property.
     * 
     * @return
     *     possible object is
     *     {@link FmOutputType }
     *     
     */
    public FmOutputType getFmOutput() {
        return fmOutput;
    }

    /**
     * Sets the value of the fmOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link FmOutputType }
     *     
     */
    public void setFmOutput(FmOutputType value) {
        this.fmOutput = value;
    }

}
