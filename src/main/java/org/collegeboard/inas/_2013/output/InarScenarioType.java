
package org.collegeboard.inas._2013.output;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for inarScenarioType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="inarScenarioType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="B"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "inarScenarioType")
@XmlEnum
public enum InarScenarioType {

    F,
    P,
    B;

    public String value() {
        return name();
    }

    public static InarScenarioType fromValue(String v) {
        return valueOf(v);
    }

}
