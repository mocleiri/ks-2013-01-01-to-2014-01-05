
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parentImputeAssetsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="parentImputeAssetsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="C"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "parentImputeAssetsType")
@XmlEnum
public enum ParentImputeAssetsType {

    N,
    I,
    C;

    public String value() {
        return name();
    }

    public static ParentImputeAssetsType fromValue(String v) {
        return valueOf(v);
    }

}
