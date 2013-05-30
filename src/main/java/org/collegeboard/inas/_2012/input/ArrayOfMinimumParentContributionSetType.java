
package org.collegeboard.inas._2012.input;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMinimumParentContributionSetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMinimumParentContributionSetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MinimumParentContributionSet" type="{http://INAS.collegeboard.org/2012/Input/}minimumParentContributionSetType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMinimumParentContributionSetType", propOrder = {
    "minimumParentContributionSet"
})
public class ArrayOfMinimumParentContributionSetType {

    @XmlElement(name = "MinimumParentContributionSet")
    protected List<MinimumParentContributionSetType> minimumParentContributionSet;

    /**
     * Gets the value of the minimumParentContributionSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the minimumParentContributionSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMinimumParentContributionSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MinimumParentContributionSetType }
     * 
     * 
     */
    public List<MinimumParentContributionSetType> getMinimumParentContributionSet() {
        if (minimumParentContributionSet == null) {
            minimumParentContributionSet = new ArrayList<MinimumParentContributionSetType>();
        }
        return this.minimumParentContributionSet;
    }

}
