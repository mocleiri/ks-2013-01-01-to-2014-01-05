
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for yesNoType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="yesNoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Y"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "yesNoType")
@XmlEnum
public enum YesNoType {

    Y,
    N;

    public String value() {
        return name();
    }

    public static YesNoType fromValue(String v) {
        return valueOf(v);
    }

}
