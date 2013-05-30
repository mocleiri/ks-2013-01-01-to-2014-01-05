
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataToMigrateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dataToMigrateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="B"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dataToMigrateType")
@XmlEnum
public enum DataToMigrateType {

    P,
    S,
    B;

    public String value() {
        return name();
    }

    public static DataToMigrateType fromValue(String v) {
        return valueOf(v);
    }

}
