
package org.collegeboard.inas._2013.output;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for homeValueEquityOptionUsageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="homeValueEquityOptionUsageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="V"/>
 *     &lt;enumeration value="E"/>
 *     &lt;enumeration value="B"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "homeValueEquityOptionUsageType")
@XmlEnum
public enum HomeValueEquityOptionUsageType {

    V,
    E,
    B;

    public String value() {
        return name();
    }

    public static HomeValueEquityOptionUsageType fromValue(String v) {
        return valueOf(v);
    }

}
