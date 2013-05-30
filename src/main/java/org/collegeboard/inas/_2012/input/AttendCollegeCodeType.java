
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for attendCollegeCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="attendCollegeCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="H"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "attendCollegeCodeType")
@XmlEnum
public enum AttendCollegeCodeType {

    N,
    F,
    H;

    public String value() {
        return name();
    }

    public static AttendCollegeCodeType fromValue(String v) {
        return valueOf(v);
    }

}
