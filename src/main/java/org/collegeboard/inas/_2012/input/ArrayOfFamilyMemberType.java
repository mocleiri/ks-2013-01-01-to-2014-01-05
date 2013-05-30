
package org.collegeboard.inas._2012.input;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFamilyMemberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFamilyMemberType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FamilyMember" type="{http://INAS.collegeboard.org/2012/Input/}familyMemberType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFamilyMemberType", propOrder = {
    "familyMember"
})
public class ArrayOfFamilyMemberType {

    @XmlElement(name = "FamilyMember")
    protected List<FamilyMemberType> familyMember;

    /**
     * Gets the value of the familyMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the familyMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFamilyMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FamilyMemberType }
     * 
     * 
     */
    public List<FamilyMemberType> getFamilyMember() {
        if (familyMember == null) {
            familyMember = new ArrayList<FamilyMemberType>();
        }
        return this.familyMember;
    }

}
