
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentImputeAssetsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="studentImputeAssetsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="C"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "studentImputeAssetsType")
@XmlEnum
public enum StudentImputeAssetsType {

    N,
    C;

    public String value() {
        return name();
    }

    public static StudentImputeAssetsType fromValue(String v) {
        return valueOf(v);
    }

}
