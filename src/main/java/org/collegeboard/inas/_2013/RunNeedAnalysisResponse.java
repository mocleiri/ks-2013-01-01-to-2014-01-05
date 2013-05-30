
package org.collegeboard.inas._2013;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.collegeboard.inas._2013.output.NeedAnalysisOutput;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RunNeedAnalysisResult" type="{http://INAS.collegeboard.org/2013/Output/}NeedAnalysisOutput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "runNeedAnalysisResult"
})
@XmlRootElement(name = "RunNeedAnalysisResponse")
public class RunNeedAnalysisResponse {

    @XmlElement(name = "RunNeedAnalysisResult")
    protected NeedAnalysisOutput runNeedAnalysisResult;

    /**
     * Gets the value of the runNeedAnalysisResult property.
     * 
     * @return
     *     possible object is
     *     {@link NeedAnalysisOutput }
     *     
     */
    public NeedAnalysisOutput getRunNeedAnalysisResult() {
        return runNeedAnalysisResult;
    }

    /**
     * Sets the value of the runNeedAnalysisResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NeedAnalysisOutput }
     *     
     */
    public void setRunNeedAnalysisResult(NeedAnalysisOutput value) {
        this.runNeedAnalysisResult = value;
    }

}
