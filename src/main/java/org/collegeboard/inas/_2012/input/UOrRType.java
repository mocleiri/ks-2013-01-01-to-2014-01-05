
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uOrRType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="uOrRType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="U"/>
 *     &lt;enumeration value="R"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "uOrRType")
@XmlEnum
public enum UOrRType {

    U,
    R;

    public String value() {
        return name();
    }

    public static UOrRType fromValue(String v) {
        return valueOf(v);
    }

}
