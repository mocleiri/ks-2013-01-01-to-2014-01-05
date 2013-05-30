
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for adjustByCostOfLivingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="adjustByCostOfLivingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "adjustByCostOfLivingType")
@XmlEnum
public enum AdjustByCostOfLivingType {

    P,
    S,
    B,
    N;

    public String value() {
        return name();
    }

    public static AdjustByCostOfLivingType fromValue(String v) {
        return valueOf(v);
    }

}
