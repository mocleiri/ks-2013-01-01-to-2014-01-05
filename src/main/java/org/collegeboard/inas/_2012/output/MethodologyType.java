
package org.collegeboard.inas._2012.output;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for methodologyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="methodologyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="R"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "methodologyType")
@XmlEnum
public enum MethodologyType {

    B,
    S,
    R;

    public String value() {
        return name();
    }

    public static MethodologyType fromValue(String v) {
        return valueOf(v);
    }

}
