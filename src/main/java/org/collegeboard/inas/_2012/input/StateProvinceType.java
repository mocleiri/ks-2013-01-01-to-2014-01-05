
package org.collegeboard.inas._2012.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stateProvinceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stateProvinceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="AB"/>
 *     &lt;enumeration value="AE"/>
 *     &lt;enumeration value="AL"/>
 *     &lt;enumeration value="AK"/>
 *     &lt;enumeration value="AP"/>
 *     &lt;enumeration value="AR"/>
 *     &lt;enumeration value="AS"/>
 *     &lt;enumeration value="AZ"/>
 *     &lt;enumeration value="BC"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="CN"/>
 *     &lt;enumeration value="CO"/>
 *     &lt;enumeration value="CT"/>
 *     &lt;enumeration value="DC"/>
 *     &lt;enumeration value="DE"/>
 *     &lt;enumeration value="FC"/>
 *     &lt;enumeration value="FL"/>
 *     &lt;enumeration value="FM"/>
 *     &lt;enumeration value="GA"/>
 *     &lt;enumeration value="GU"/>
 *     &lt;enumeration value="HI"/>
 *     &lt;enumeration value="IA"/>
 *     &lt;enumeration value="ID"/>
 *     &lt;enumeration value="IL"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="KS"/>
 *     &lt;enumeration value="KY"/>
 *     &lt;enumeration value="LA"/>
 *     &lt;enumeration value="MA"/>
 *     &lt;enumeration value="MB"/>
 *     &lt;enumeration value="MD"/>
 *     &lt;enumeration value="ME"/>
 *     &lt;enumeration value="MH"/>
 *     &lt;enumeration value="MI"/>
 *     &lt;enumeration value="MN"/>
 *     &lt;enumeration value="MO"/>
 *     &lt;enumeration value="MP"/>
 *     &lt;enumeration value="MS"/>
 *     &lt;enumeration value="MT"/>
 *     &lt;enumeration value="MX"/>
 *     &lt;enumeration value="NB"/>
 *     &lt;enumeration value="NC"/>
 *     &lt;enumeration value="ND"/>
 *     &lt;enumeration value="NE"/>
 *     &lt;enumeration value="NF"/>
 *     &lt;enumeration value="NV"/>
 *     &lt;enumeration value="NH"/>
 *     &lt;enumeration value="NJ"/>
 *     &lt;enumeration value="NL"/>
 *     &lt;enumeration value="NM"/>
 *     &lt;enumeration value="NS"/>
 *     &lt;enumeration value="NT"/>
 *     &lt;enumeration value="NU"/>
 *     &lt;enumeration value="NY"/>
 *     &lt;enumeration value="OH"/>
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="ON"/>
 *     &lt;enumeration value="OR"/>
 *     &lt;enumeration value="PA"/>
 *     &lt;enumeration value="PE"/>
 *     &lt;enumeration value="PQ"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="PW"/>
 *     &lt;enumeration value="QC"/>
 *     &lt;enumeration value="RI"/>
 *     &lt;enumeration value="SC"/>
 *     &lt;enumeration value="SD"/>
 *     &lt;enumeration value="SK"/>
 *     &lt;enumeration value="TN"/>
 *     &lt;enumeration value="TX"/>
 *     &lt;enumeration value="UT"/>
 *     &lt;enumeration value="VA"/>
 *     &lt;enumeration value="VI"/>
 *     &lt;enumeration value="VT"/>
 *     &lt;enumeration value="WA"/>
 *     &lt;enumeration value="WI"/>
 *     &lt;enumeration value="WV"/>
 *     &lt;enumeration value="WY"/>
 *     &lt;enumeration value="YT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "stateProvinceType")
@XmlEnum
public enum StateProvinceType {

    AA,
    AB,
    AE,
    AL,
    AK,
    AP,
    AR,
    AS,
    AZ,
    BC,
    CA,
    CN,
    CO,
    CT,
    DC,
    DE,
    FC,
    FL,
    FM,
    GA,
    GU,
    HI,
    IA,
    ID,
    IL,
    IN,
    KS,
    KY,
    LA,
    MA,
    MB,
    MD,
    ME,
    MH,
    MI,
    MN,
    MO,
    MP,
    MS,
    MT,
    MX,
    NB,
    NC,
    ND,
    NE,
    NF,
    NV,
    NH,
    NJ,
    NL,
    NM,
    NS,
    NT,
    NU,
    NY,
    OH,
    OK,
    ON,
    OR,
    PA,
    PE,
    PQ,
    PR,
    PW,
    QC,
    RI,
    SC,
    SD,
    SK,
    TN,
    TX,
    UT,
    VA,
    VI,
    VT,
    WA,
    WI,
    WV,
    WY,
    YT;

    public String value() {
        return name();
    }

    public static StateProvinceType fromValue(String v) {
        return valueOf(v);
    }

}
