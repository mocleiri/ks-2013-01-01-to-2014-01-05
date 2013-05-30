
package org.collegeboard.inas._2012.output;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for custodialParentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="custodialParentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="M"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "custodialParentType")
@XmlEnum
public enum CustodialParentType {

    F,
    M;

    public String value() {
        return name();
    }

    public static CustodialParentType fromValue(String v) {
        return valueOf(v);
    }

}
