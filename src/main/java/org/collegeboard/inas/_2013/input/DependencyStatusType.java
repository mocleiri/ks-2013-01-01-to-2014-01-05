
package org.collegeboard.inas._2013.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dependencyStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dependencyStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="X"/>
 *     &lt;enumeration value="Y"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dependencyStatusType")
@XmlEnum
public enum DependencyStatusType {

    D,
    I,
    X,
    Y;

    public String value() {
        return name();
    }

    public static DependencyStatusType fromValue(String v) {
        return valueOf(v);
    }

}
