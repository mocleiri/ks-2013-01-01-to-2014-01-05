
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for activateDataMigrationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="activateDataMigrationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "activateDataMigrationType")
@XmlEnum
public enum ActivateDataMigrationType {

    P,
    F,
    N;

    public String value() {
        return name();
    }

    public static ActivateDataMigrationType fromValue(String v) {
        return valueOf(v);
    }

}
