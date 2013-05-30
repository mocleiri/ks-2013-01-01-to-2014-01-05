
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentLivesWithType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="studentLivesWithType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "studentLivesWithType")
@XmlEnum
public enum StudentLivesWithType {

    F,
    M,
    N;

    public String value() {
        return name();
    }

    public static StudentLivesWithType fromValue(String v) {
        return valueOf(v);
    }

}
