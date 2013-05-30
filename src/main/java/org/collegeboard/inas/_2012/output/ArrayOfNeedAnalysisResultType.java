
package org.collegeboard.inas._2012.output;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfNeedAnalysisResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfNeedAnalysisResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NeedAnalysisResult" type="{http://INAS.collegeboard.org/2012/Output/}needAnalysisResultType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfNeedAnalysisResultType", propOrder = {
    "needAnalysisResult"
})
public class ArrayOfNeedAnalysisResultType {

    @XmlElement(name = "NeedAnalysisResult")
    protected List<NeedAnalysisResultType> needAnalysisResult;

    /**
     * Gets the value of the needAnalysisResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the needAnalysisResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNeedAnalysisResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NeedAnalysisResultType }
     * 
     * 
     */
    public List<NeedAnalysisResultType> getNeedAnalysisResult() {
        if (needAnalysisResult == null) {
            needAnalysisResult = new ArrayList<NeedAnalysisResultType>();
        }
        return this.needAnalysisResult;
    }

}
