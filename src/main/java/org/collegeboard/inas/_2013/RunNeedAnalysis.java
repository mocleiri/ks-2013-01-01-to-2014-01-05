
package org.collegeboard.inas._2013;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.collegeboard.inas._2013.input.NeedAnalysisInput;


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
 *         &lt;element name="input" type="{http://INAS.collegeboard.org/2013/Input/}NeedAnalysisInput"/>
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
    "input"
})
@XmlRootElement(name = "RunNeedAnalysis")
public class RunNeedAnalysis {

    @XmlElement(required = true)
    protected NeedAnalysisInput input;

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link NeedAnalysisInput }
     *     
     */
    public NeedAnalysisInput getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link NeedAnalysisInput }
     *     
     */
    public void setInput(NeedAnalysisInput value) {
        this.input = value;
    }

}
