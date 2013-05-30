package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/26/12
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "UCT", schema = "SIGMA", catalog = "")
@Entity
public class UctEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getUctkey();
    }

    private String recstat;

    @javax.persistence.Column(name = "RECSTAT")
    @Basic
    public String getRecstat() {
        return recstat;
    }

    public void setRecstat(String recstat) {
        this.recstat = recstat;
    }

    private String uctkey;

    @javax.persistence.Column(name = "UCTKEY")
    @Id
    public String getUctkey() {
        return uctkey;
    }

    public void setUctkey(String uctkey) {
        this.uctkey = uctkey;
    }

    private String sid;

    @javax.persistence.Column(name = "SID")
    @Basic
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    private String aidyr;

    @javax.persistence.Column(name = "AIDYR")
    @Basic
    public String getAidyr() {
        return aidyr;
    }

    public void setAidyr(String aidyr) {
        this.aidyr = aidyr;
    }

    private String term;

    @javax.persistence.Column(name = "TERM")
    @Basic
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    private String crtdate;

    @javax.persistence.Column(name = "CRTDATE")
    @Basic
    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
    }

    private String crttime;

    @javax.persistence.Column(name = "CRTTIME")
    @Basic
    public String getCrttime() {
        return crttime;
    }

    public void setCrttime(String crttime) {
        this.crttime = crttime;
    }

    private String crtuser;

    @javax.persistence.Column(name = "CRTUSER")
    @Basic
    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
    }

    private String crtmod;

    @javax.persistence.Column(name = "CRTMOD")
    @Basic
    public String getCrtmod() {
        return crtmod;
    }

    public void setCrtmod(String crtmod) {
        this.crtmod = crtmod;
    }

    private String revdate;

    @javax.persistence.Column(name = "REVDATE")
    @Basic
    public String getRevdate() {
        return revdate;
    }

    public void setRevdate(String revdate) {
        this.revdate = revdate;
    }

    private int revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public int getRevlev() {
        return revlev;
    }

    public void setRevlev(int revlev) {
        this.revlev = revlev;
    }

    private String revtime;

    @javax.persistence.Column(name = "REVTIME")
    @Basic
    public String getRevtime() {
        return revtime;
    }

    public void setRevtime(String revtime) {
        this.revtime = revtime;
    }

    private String revuser;

    @javax.persistence.Column(name = "REVUSER")
    @Basic
    public String getRevuser() {
        return revuser;
    }

    public void setRevuser(String revuser) {
        this.revuser = revuser;
    }

    private String revmod;

    @javax.persistence.Column(name = "REVMOD")
    @Basic
    public String getRevmod() {
        return revmod;
    }

    public void setRevmod(String revmod) {
        this.revmod = revmod;
    }

    private String ucode;

    @javax.persistence.Column(name = "UCODE")
    @Basic
    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    private String uc1F01;

    @javax.persistence.Column(name = "UC1F01")
    @Basic
    public String getUc1F01() {
        return uc1F01;
    }

    public void setUc1F01(String uc1F01) {
        this.uc1F01 = uc1F01;
    }

    private String uc1F02;

    @javax.persistence.Column(name = "UC1F02")
    @Basic
    public String getUc1F02() {
        return uc1F02;
    }

    public void setUc1F02(String uc1F02) {
        this.uc1F02 = uc1F02;
    }

    private String uc1F03;

    @javax.persistence.Column(name = "UC1F03")
    @Basic
    public String getUc1F03() {
        return uc1F03;
    }

    public void setUc1F03(String uc1F03) {
        this.uc1F03 = uc1F03;
    }

    private String uc1F04;

    @javax.persistence.Column(name = "UC1F04")
    @Basic
    public String getUc1F04() {
        return uc1F04;
    }

    public void setUc1F04(String uc1F04) {
        this.uc1F04 = uc1F04;
    }

    private String uc1F05;

    @javax.persistence.Column(name = "UC1F05")
    @Basic
    public String getUc1F05() {
        return uc1F05;
    }

    public void setUc1F05(String uc1F05) {
        this.uc1F05 = uc1F05;
    }

    private String uc1F06;

    @javax.persistence.Column(name = "UC1F06")
    @Basic
    public String getUc1F06() {
        return uc1F06;
    }

    public void setUc1F06(String uc1F06) {
        this.uc1F06 = uc1F06;
    }

    private String uc1F07;

    @javax.persistence.Column(name = "UC1F07")
    @Basic
    public String getUc1F07() {
        return uc1F07;
    }

    public void setUc1F07(String uc1F07) {
        this.uc1F07 = uc1F07;
    }

    private String uc1F08;

    @javax.persistence.Column(name = "UC1F08")
    @Basic
    public String getUc1F08() {
        return uc1F08;
    }

    public void setUc1F08(String uc1F08) {
        this.uc1F08 = uc1F08;
    }

    private String uc1F09;

    @javax.persistence.Column(name = "UC1F09")
    @Basic
    public String getUc1F09() {
        return uc1F09;
    }

    public void setUc1F09(String uc1F09) {
        this.uc1F09 = uc1F09;
    }

    private String uc1F10;

    @javax.persistence.Column(name = "UC1F10")
    @Basic
    public String getUc1F10() {
        return uc1F10;
    }

    public void setUc1F10(String uc1F10) {
        this.uc1F10 = uc1F10;
    }

    private String uc1F11;

    @javax.persistence.Column(name = "UC1F11")
    @Basic
    public String getUc1F11() {
        return uc1F11;
    }

    public void setUc1F11(String uc1F11) {
        this.uc1F11 = uc1F11;
    }

    private String uc1F12;

    @javax.persistence.Column(name = "UC1F12")
    @Basic
    public String getUc1F12() {
        return uc1F12;
    }

    public void setUc1F12(String uc1F12) {
        this.uc1F12 = uc1F12;
    }

    private String uc1F13;

    @javax.persistence.Column(name = "UC1F13")
    @Basic
    public String getUc1F13() {
        return uc1F13;
    }

    public void setUc1F13(String uc1F13) {
        this.uc1F13 = uc1F13;
    }

    private String uc1F14;

    @javax.persistence.Column(name = "UC1F14")
    @Basic
    public String getUc1F14() {
        return uc1F14;
    }

    public void setUc1F14(String uc1F14) {
        this.uc1F14 = uc1F14;
    }

    private String uc1F15;

    @javax.persistence.Column(name = "UC1F15")
    @Basic
    public String getUc1F15() {
        return uc1F15;
    }

    public void setUc1F15(String uc1F15) {
        this.uc1F15 = uc1F15;
    }

    private String uc1F16;

    @javax.persistence.Column(name = "UC1F16")
    @Basic
    public String getUc1F16() {
        return uc1F16;
    }

    public void setUc1F16(String uc1F16) {
        this.uc1F16 = uc1F16;
    }

    private String uc1F17;

    @javax.persistence.Column(name = "UC1F17")
    @Basic
    public String getUc1F17() {
        return uc1F17;
    }

    public void setUc1F17(String uc1F17) {
        this.uc1F17 = uc1F17;
    }

    private String uc1F18;

    @javax.persistence.Column(name = "UC1F18")
    @Basic
    public String getUc1F18() {
        return uc1F18;
    }

    public void setUc1F18(String uc1F18) {
        this.uc1F18 = uc1F18;
    }

    private String uc1F19;

    @javax.persistence.Column(name = "UC1F19")
    @Basic
    public String getUc1F19() {
        return uc1F19;
    }

    public void setUc1F19(String uc1F19) {
        this.uc1F19 = uc1F19;
    }

    private String uc1F20;

    @javax.persistence.Column(name = "UC1F20")
    @Basic
    public String getUc1F20() {
        return uc1F20;
    }

    public void setUc1F20(String uc1F20) {
        this.uc1F20 = uc1F20;
    }

    private String uc1F21;

    @javax.persistence.Column(name = "UC1F21")
    @Basic
    public String getUc1F21() {
        return uc1F21;
    }

    public void setUc1F21(String uc1F21) {
        this.uc1F21 = uc1F21;
    }

    private String uc1F22;

    @javax.persistence.Column(name = "UC1F22")
    @Basic
    public String getUc1F22() {
        return uc1F22;
    }

    public void setUc1F22(String uc1F22) {
        this.uc1F22 = uc1F22;
    }

    private String uc1F23;

    @javax.persistence.Column(name = "UC1F23")
    @Basic
    public String getUc1F23() {
        return uc1F23;
    }

    public void setUc1F23(String uc1F23) {
        this.uc1F23 = uc1F23;
    }

    private String uc1F24;

    @javax.persistence.Column(name = "UC1F24")
    @Basic
    public String getUc1F24() {
        return uc1F24;
    }

    public void setUc1F24(String uc1F24) {
        this.uc1F24 = uc1F24;
    }

    private String uc1F25;

    @javax.persistence.Column(name = "UC1F25")
    @Basic
    public String getUc1F25() {
        return uc1F25;
    }

    public void setUc1F25(String uc1F25) {
        this.uc1F25 = uc1F25;
    }

    private String uc1F26;

    @javax.persistence.Column(name = "UC1F26")
    @Basic
    public String getUc1F26() {
        return uc1F26;
    }

    public void setUc1F26(String uc1F26) {
        this.uc1F26 = uc1F26;
    }

    private String uc1F27;

    @javax.persistence.Column(name = "UC1F27")
    @Basic
    public String getUc1F27() {
        return uc1F27;
    }

    public void setUc1F27(String uc1F27) {
        this.uc1F27 = uc1F27;
    }

    private String uc1F28;

    @javax.persistence.Column(name = "UC1F28")
    @Basic
    public String getUc1F28() {
        return uc1F28;
    }

    public void setUc1F28(String uc1F28) {
        this.uc1F28 = uc1F28;
    }

    private String uc1F29;

    @javax.persistence.Column(name = "UC1F29")
    @Basic
    public String getUc1F29() {
        return uc1F29;
    }

    public void setUc1F29(String uc1F29) {
        this.uc1F29 = uc1F29;
    }

    private String uc1F30;

    @javax.persistence.Column(name = "UC1F30")
    @Basic
    public String getUc1F30() {
        return uc1F30;
    }

    public void setUc1F30(String uc1F30) {
        this.uc1F30 = uc1F30;
    }

    private String uc1F31;

    @javax.persistence.Column(name = "UC1F31")
    @Basic
    public String getUc1F31() {
        return uc1F31;
    }

    public void setUc1F31(String uc1F31) {
        this.uc1F31 = uc1F31;
    }

    private String uc1F32;

    @javax.persistence.Column(name = "UC1F32")
    @Basic
    public String getUc1F32() {
        return uc1F32;
    }

    public void setUc1F32(String uc1F32) {
        this.uc1F32 = uc1F32;
    }

    private String uc1F33;

    @javax.persistence.Column(name = "UC1F33")
    @Basic
    public String getUc1F33() {
        return uc1F33;
    }

    public void setUc1F33(String uc1F33) {
        this.uc1F33 = uc1F33;
    }

    private String uc1F34;

    @javax.persistence.Column(name = "UC1F34")
    @Basic
    public String getUc1F34() {
        return uc1F34;
    }

    public void setUc1F34(String uc1F34) {
        this.uc1F34 = uc1F34;
    }

    private String uc1F35;

    @javax.persistence.Column(name = "UC1F35")
    @Basic
    public String getUc1F35() {
        return uc1F35;
    }

    public void setUc1F35(String uc1F35) {
        this.uc1F35 = uc1F35;
    }

    private String uc1F36;

    @javax.persistence.Column(name = "UC1F36")
    @Basic
    public String getUc1F36() {
        return uc1F36;
    }

    public void setUc1F36(String uc1F36) {
        this.uc1F36 = uc1F36;
    }

    private String uc1F37;

    @javax.persistence.Column(name = "UC1F37")
    @Basic
    public String getUc1F37() {
        return uc1F37;
    }

    public void setUc1F37(String uc1F37) {
        this.uc1F37 = uc1F37;
    }

    private String uc1F38;

    @javax.persistence.Column(name = "UC1F38")
    @Basic
    public String getUc1F38() {
        return uc1F38;
    }

    public void setUc1F38(String uc1F38) {
        this.uc1F38 = uc1F38;
    }

    private String uc1F39;

    @javax.persistence.Column(name = "UC1F39")
    @Basic
    public String getUc1F39() {
        return uc1F39;
    }

    public void setUc1F39(String uc1F39) {
        this.uc1F39 = uc1F39;
    }

    private String uc1F40;

    @javax.persistence.Column(name = "UC1F40")
    @Basic
    public String getUc1F40() {
        return uc1F40;
    }

    public void setUc1F40(String uc1F40) {
        this.uc1F40 = uc1F40;
    }

    private String uc2F01;

    @javax.persistence.Column(name = "UC2F01")
    @Basic
    public String getUc2F01() {
        return uc2F01;
    }

    public void setUc2F01(String uc2F01) {
        this.uc2F01 = uc2F01;
    }

    private String uc2F02;

    @javax.persistence.Column(name = "UC2F02")
    @Basic
    public String getUc2F02() {
        return uc2F02;
    }

    public void setUc2F02(String uc2F02) {
        this.uc2F02 = uc2F02;
    }

    private String uc2F03;

    @javax.persistence.Column(name = "UC2F03")
    @Basic
    public String getUc2F03() {
        return uc2F03;
    }

    public void setUc2F03(String uc2F03) {
        this.uc2F03 = uc2F03;
    }

    private String uc2F04;

    @javax.persistence.Column(name = "UC2F04")
    @Basic
    public String getUc2F04() {
        return uc2F04;
    }

    public void setUc2F04(String uc2F04) {
        this.uc2F04 = uc2F04;
    }

    private String uc2F05;

    @javax.persistence.Column(name = "UC2F05")
    @Basic
    public String getUc2F05() {
        return uc2F05;
    }

    public void setUc2F05(String uc2F05) {
        this.uc2F05 = uc2F05;
    }

    private String uc2F06;

    @javax.persistence.Column(name = "UC2F06")
    @Basic
    public String getUc2F06() {
        return uc2F06;
    }

    public void setUc2F06(String uc2F06) {
        this.uc2F06 = uc2F06;
    }

    private String uc2F07;

    @javax.persistence.Column(name = "UC2F07")
    @Basic
    public String getUc2F07() {
        return uc2F07;
    }

    public void setUc2F07(String uc2F07) {
        this.uc2F07 = uc2F07;
    }

    private String uc2F08;

    @javax.persistence.Column(name = "UC2F08")
    @Basic
    public String getUc2F08() {
        return uc2F08;
    }

    public void setUc2F08(String uc2F08) {
        this.uc2F08 = uc2F08;
    }

    private String uc2F09;

    @javax.persistence.Column(name = "UC2F09")
    @Basic
    public String getUc2F09() {
        return uc2F09;
    }

    public void setUc2F09(String uc2F09) {
        this.uc2F09 = uc2F09;
    }

    private String uc2F10;

    @javax.persistence.Column(name = "UC2F10")
    @Basic
    public String getUc2F10() {
        return uc2F10;
    }

    public void setUc2F10(String uc2F10) {
        this.uc2F10 = uc2F10;
    }

    private String uc2F11;

    @javax.persistence.Column(name = "UC2F11")
    @Basic
    public String getUc2F11() {
        return uc2F11;
    }

    public void setUc2F11(String uc2F11) {
        this.uc2F11 = uc2F11;
    }

    private String uc2F12;

    @javax.persistence.Column(name = "UC2F12")
    @Basic
    public String getUc2F12() {
        return uc2F12;
    }

    public void setUc2F12(String uc2F12) {
        this.uc2F12 = uc2F12;
    }

    private String uc2F13;

    @javax.persistence.Column(name = "UC2F13")
    @Basic
    public String getUc2F13() {
        return uc2F13;
    }

    public void setUc2F13(String uc2F13) {
        this.uc2F13 = uc2F13;
    }

    private String uc2F14;

    @javax.persistence.Column(name = "UC2F14")
    @Basic
    public String getUc2F14() {
        return uc2F14;
    }

    public void setUc2F14(String uc2F14) {
        this.uc2F14 = uc2F14;
    }

    private String uc2F15;

    @javax.persistence.Column(name = "UC2F15")
    @Basic
    public String getUc2F15() {
        return uc2F15;
    }

    public void setUc2F15(String uc2F15) {
        this.uc2F15 = uc2F15;
    }

    private String uc2F16;

    @javax.persistence.Column(name = "UC2F16")
    @Basic
    public String getUc2F16() {
        return uc2F16;
    }

    public void setUc2F16(String uc2F16) {
        this.uc2F16 = uc2F16;
    }

    private String uc2F17;

    @javax.persistence.Column(name = "UC2F17")
    @Basic
    public String getUc2F17() {
        return uc2F17;
    }

    public void setUc2F17(String uc2F17) {
        this.uc2F17 = uc2F17;
    }

    private String uc2F18;

    @javax.persistence.Column(name = "UC2F18")
    @Basic
    public String getUc2F18() {
        return uc2F18;
    }

    public void setUc2F18(String uc2F18) {
        this.uc2F18 = uc2F18;
    }

    private String uc2F19;

    @javax.persistence.Column(name = "UC2F19")
    @Basic
    public String getUc2F19() {
        return uc2F19;
    }

    public void setUc2F19(String uc2F19) {
        this.uc2F19 = uc2F19;
    }

    private String uc2F20;

    @javax.persistence.Column(name = "UC2F20")
    @Basic
    public String getUc2F20() {
        return uc2F20;
    }

    public void setUc2F20(String uc2F20) {
        this.uc2F20 = uc2F20;
    }

    private String uc4F01;

    @javax.persistence.Column(name = "UC4F01")
    @Basic
    public String getUc4F01() {
        return uc4F01;
    }

    public void setUc4F01(String uc4F01) {
        this.uc4F01 = uc4F01;
    }

    private String uc4F02;

    @javax.persistence.Column(name = "UC4F02")
    @Basic
    public String getUc4F02() {
        return uc4F02;
    }

    public void setUc4F02(String uc4F02) {
        this.uc4F02 = uc4F02;
    }

    private String uc4F03;

    @javax.persistence.Column(name = "UC4F03")
    @Basic
    public String getUc4F03() {
        return uc4F03;
    }

    public void setUc4F03(String uc4F03) {
        this.uc4F03 = uc4F03;
    }

    private String uc4F04;

    @javax.persistence.Column(name = "UC4F04")
    @Basic
    public String getUc4F04() {
        return uc4F04;
    }

    public void setUc4F04(String uc4F04) {
        this.uc4F04 = uc4F04;
    }

    private String uc4F05;

    @javax.persistence.Column(name = "UC4F05")
    @Basic
    public String getUc4F05() {
        return uc4F05;
    }

    public void setUc4F05(String uc4F05) {
        this.uc4F05 = uc4F05;
    }

    private String uc4F06;

    @javax.persistence.Column(name = "UC4F06")
    @Basic
    public String getUc4F06() {
        return uc4F06;
    }

    public void setUc4F06(String uc4F06) {
        this.uc4F06 = uc4F06;
    }

    private String uc4F07;

    @javax.persistence.Column(name = "UC4F07")
    @Basic
    public String getUc4F07() {
        return uc4F07;
    }

    public void setUc4F07(String uc4F07) {
        this.uc4F07 = uc4F07;
    }

    private String uc4F08;

    @javax.persistence.Column(name = "UC4F08")
    @Basic
    public String getUc4F08() {
        return uc4F08;
    }

    public void setUc4F08(String uc4F08) {
        this.uc4F08 = uc4F08;
    }

    private String uc4F09;

    @javax.persistence.Column(name = "UC4F09")
    @Basic
    public String getUc4F09() {
        return uc4F09;
    }

    public void setUc4F09(String uc4F09) {
        this.uc4F09 = uc4F09;
    }

    private String uc4F10;

    @javax.persistence.Column(name = "UC4F10")
    @Basic
    public String getUc4F10() {
        return uc4F10;
    }

    public void setUc4F10(String uc4F10) {
        this.uc4F10 = uc4F10;
    }

    private String uc4F11;

    @javax.persistence.Column(name = "UC4F11")
    @Basic
    public String getUc4F11() {
        return uc4F11;
    }

    public void setUc4F11(String uc4F11) {
        this.uc4F11 = uc4F11;
    }

    private String uc4F12;

    @javax.persistence.Column(name = "UC4F12")
    @Basic
    public String getUc4F12() {
        return uc4F12;
    }

    public void setUc4F12(String uc4F12) {
        this.uc4F12 = uc4F12;
    }

    private String uc4F13;

    @javax.persistence.Column(name = "UC4F13")
    @Basic
    public String getUc4F13() {
        return uc4F13;
    }

    public void setUc4F13(String uc4F13) {
        this.uc4F13 = uc4F13;
    }

    private String uc4F14;

    @javax.persistence.Column(name = "UC4F14")
    @Basic
    public String getUc4F14() {
        return uc4F14;
    }

    public void setUc4F14(String uc4F14) {
        this.uc4F14 = uc4F14;
    }

    private String uc4F15;

    @javax.persistence.Column(name = "UC4F15")
    @Basic
    public String getUc4F15() {
        return uc4F15;
    }

    public void setUc4F15(String uc4F15) {
        this.uc4F15 = uc4F15;
    }

    private String uc4F16;

    @javax.persistence.Column(name = "UC4F16")
    @Basic
    public String getUc4F16() {
        return uc4F16;
    }

    public void setUc4F16(String uc4F16) {
        this.uc4F16 = uc4F16;
    }

    private String uc4F17;

    @javax.persistence.Column(name = "UC4F17")
    @Basic
    public String getUc4F17() {
        return uc4F17;
    }

    public void setUc4F17(String uc4F17) {
        this.uc4F17 = uc4F17;
    }

    private String uc4F18;

    @javax.persistence.Column(name = "UC4F18")
    @Basic
    public String getUc4F18() {
        return uc4F18;
    }

    public void setUc4F18(String uc4F18) {
        this.uc4F18 = uc4F18;
    }

    private String uc4F19;

    @javax.persistence.Column(name = "UC4F19")
    @Basic
    public String getUc4F19() {
        return uc4F19;
    }

    public void setUc4F19(String uc4F19) {
        this.uc4F19 = uc4F19;
    }

    private String uc4F20;

    @javax.persistence.Column(name = "UC4F20")
    @Basic
    public String getUc4F20() {
        return uc4F20;
    }

    public void setUc4F20(String uc4F20) {
        this.uc4F20 = uc4F20;
    }

    private String uc6F01;

    @javax.persistence.Column(name = "UC6F01")
    @Basic
    public String getUc6F01() {
        return uc6F01;
    }

    public void setUc6F01(String uc6F01) {
        this.uc6F01 = uc6F01;
    }

    private String uc6F02;

    @javax.persistence.Column(name = "UC6F02")
    @Basic
    public String getUc6F02() {
        return uc6F02;
    }

    public void setUc6F02(String uc6F02) {
        this.uc6F02 = uc6F02;
    }

    private String uc6F03;

    @javax.persistence.Column(name = "UC6F03")
    @Basic
    public String getUc6F03() {
        return uc6F03;
    }

    public void setUc6F03(String uc6F03) {
        this.uc6F03 = uc6F03;
    }

    private String uc6F04;

    @javax.persistence.Column(name = "UC6F04")
    @Basic
    public String getUc6F04() {
        return uc6F04;
    }

    public void setUc6F04(String uc6F04) {
        this.uc6F04 = uc6F04;
    }

    private String uc6F05;

    @javax.persistence.Column(name = "UC6F05")
    @Basic
    public String getUc6F05() {
        return uc6F05;
    }

    public void setUc6F05(String uc6F05) {
        this.uc6F05 = uc6F05;
    }

    private String uc6F06;

    @javax.persistence.Column(name = "UC6F06")
    @Basic
    public String getUc6F06() {
        return uc6F06;
    }

    public void setUc6F06(String uc6F06) {
        this.uc6F06 = uc6F06;
    }

    private String uc6F07;

    @javax.persistence.Column(name = "UC6F07")
    @Basic
    public String getUc6F07() {
        return uc6F07;
    }

    public void setUc6F07(String uc6F07) {
        this.uc6F07 = uc6F07;
    }

    private String uc6F08;

    @javax.persistence.Column(name = "UC6F08")
    @Basic
    public String getUc6F08() {
        return uc6F08;
    }

    public void setUc6F08(String uc6F08) {
        this.uc6F08 = uc6F08;
    }

    private String uc6F09;

    @javax.persistence.Column(name = "UC6F09")
    @Basic
    public String getUc6F09() {
        return uc6F09;
    }

    public void setUc6F09(String uc6F09) {
        this.uc6F09 = uc6F09;
    }

    private String uc6F10;

    @javax.persistence.Column(name = "UC6F10")
    @Basic
    public String getUc6F10() {
        return uc6F10;
    }

    public void setUc6F10(String uc6F10) {
        this.uc6F10 = uc6F10;
    }

    private String uc12F1;

    @javax.persistence.Column(name = "UC12F1")
    @Basic
    public String getUc12F1() {
        return uc12F1;
    }

    public void setUc12F1(String uc12F1) {
        this.uc12F1 = uc12F1;
    }

    private String uc12F2;

    @javax.persistence.Column(name = "UC12F2")
    @Basic
    public String getUc12F2() {
        return uc12F2;
    }

    public void setUc12F2(String uc12F2) {
        this.uc12F2 = uc12F2;
    }

    private String uc12F3;

    @javax.persistence.Column(name = "UC12F3")
    @Basic
    public String getUc12F3() {
        return uc12F3;
    }

    public void setUc12F3(String uc12F3) {
        this.uc12F3 = uc12F3;
    }

    private int usnr1;

    @javax.persistence.Column(name = "USNR1")
    @Basic
    public int getUsnr1() {
        return usnr1;
    }

    public void setUsnr1(int usnr1) {
        this.usnr1 = usnr1;
    }

    private int usnr2;

    @javax.persistence.Column(name = "USNR2")
    @Basic
    public int getUsnr2() {
        return usnr2;
    }

    public void setUsnr2(int usnr2) {
        this.usnr2 = usnr2;
    }

    private int usnr3;

    @javax.persistence.Column(name = "USNR3")
    @Basic
    public int getUsnr3() {
        return usnr3;
    }

    public void setUsnr3(int usnr3) {
        this.usnr3 = usnr3;
    }

    private int usnr4;

    @javax.persistence.Column(name = "USNR4")
    @Basic
    public int getUsnr4() {
        return usnr4;
    }

    public void setUsnr4(int usnr4) {
        this.usnr4 = usnr4;
    }

    private int usnr5;

    @javax.persistence.Column(name = "USNR5")
    @Basic
    public int getUsnr5() {
        return usnr5;
    }

    public void setUsnr5(int usnr5) {
        this.usnr5 = usnr5;
    }

    private BigDecimal usnr6;

    @javax.persistence.Column(name = "USNR6")
    @Basic
    public BigDecimal getUsnr6() {
        return usnr6;
    }

    public void setUsnr6(BigDecimal usnr6) {
        this.usnr6 = usnr6;
    }

    private BigDecimal usnr7;

    @javax.persistence.Column(name = "USNR7")
    @Basic
    public BigDecimal getUsnr7() {
        return usnr7;
    }

    public void setUsnr7(BigDecimal usnr7) {
        this.usnr7 = usnr7;
    }

    private BigDecimal usnr8;

    @javax.persistence.Column(name = "USNR8")
    @Basic
    public BigDecimal getUsnr8() {
        return usnr8;
    }

    public void setUsnr8(BigDecimal usnr8) {
        this.usnr8 = usnr8;
    }

    private BigDecimal usnr9;

    @javax.persistence.Column(name = "USNR9")
    @Basic
    public BigDecimal getUsnr9() {
        return usnr9;
    }

    public void setUsnr9(BigDecimal usnr9) {
        this.usnr9 = usnr9;
    }

    private BigDecimal usnr10;

    @javax.persistence.Column(name = "USNR10")
    @Basic
    public BigDecimal getUsnr10() {
        return usnr10;
    }

    public void setUsnr10(BigDecimal usnr10) {
        this.usnr10 = usnr10;
    }

    private int usnr11;

    @javax.persistence.Column(name = "USNR11")
    @Basic
    public int getUsnr11() {
        return usnr11;
    }

    public void setUsnr11(int usnr11) {
        this.usnr11 = usnr11;
    }

    private int usnr12;

    @javax.persistence.Column(name = "USNR12")
    @Basic
    public int getUsnr12() {
        return usnr12;
    }

    public void setUsnr12(int usnr12) {
        this.usnr12 = usnr12;
    }

    private int usnr13;

    @javax.persistence.Column(name = "USNR13")
    @Basic
    public int getUsnr13() {
        return usnr13;
    }

    public void setUsnr13(int usnr13) {
        this.usnr13 = usnr13;
    }

    private int usnr14;

    @javax.persistence.Column(name = "USNR14")
    @Basic
    public int getUsnr14() {
        return usnr14;
    }

    public void setUsnr14(int usnr14) {
        this.usnr14 = usnr14;
    }

    private int usnr15;

    @javax.persistence.Column(name = "USNR15")
    @Basic
    public int getUsnr15() {
        return usnr15;
    }

    public void setUsnr15(int usnr15) {
        this.usnr15 = usnr15;
    }

    private BigDecimal usnr16;

    @javax.persistence.Column(name = "USNR16")
    @Basic
    public BigDecimal getUsnr16() {
        return usnr16;
    }

    public void setUsnr16(BigDecimal usnr16) {
        this.usnr16 = usnr16;
    }

    private BigDecimal usnr17;

    @javax.persistence.Column(name = "USNR17")
    @Basic
    public BigDecimal getUsnr17() {
        return usnr17;
    }

    public void setUsnr17(BigDecimal usnr17) {
        this.usnr17 = usnr17;
    }

    private BigDecimal usnr18;

    @javax.persistence.Column(name = "USNR18")
    @Basic
    public BigDecimal getUsnr18() {
        return usnr18;
    }

    public void setUsnr18(BigDecimal usnr18) {
        this.usnr18 = usnr18;
    }

    private BigDecimal usnr19;

    @javax.persistence.Column(name = "USNR19")
    @Basic
    public BigDecimal getUsnr19() {
        return usnr19;
    }

    public void setUsnr19(BigDecimal usnr19) {
        this.usnr19 = usnr19;
    }

    private BigDecimal usnr20;

    @javax.persistence.Column(name = "USNR20")
    @Basic
    public BigDecimal getUsnr20() {
        return usnr20;
    }

    public void setUsnr20(BigDecimal usnr20) {
        this.usnr20 = usnr20;
    }

    private String usrdt1;

    @javax.persistence.Column(name = "USRDT1")
    @Basic
    public String getUsrdt1() {
        return usrdt1;
    }

    public void setUsrdt1(String usrdt1) {
        this.usrdt1 = usrdt1;
    }

    private String usrdt2;

    @javax.persistence.Column(name = "USRDT2")
    @Basic
    public String getUsrdt2() {
        return usrdt2;
    }

    public void setUsrdt2(String usrdt2) {
        this.usrdt2 = usrdt2;
    }

    private String usrdt3;

    @javax.persistence.Column(name = "USRDT3")
    @Basic
    public String getUsrdt3() {
        return usrdt3;
    }

    public void setUsrdt3(String usrdt3) {
        this.usrdt3 = usrdt3;
    }

    private String usrdt4;

    @javax.persistence.Column(name = "USRDT4")
    @Basic
    public String getUsrdt4() {
        return usrdt4;
    }

    public void setUsrdt4(String usrdt4) {
        this.usrdt4 = usrdt4;
    }

    private String usrdt5;

    @javax.persistence.Column(name = "USRDT5")
    @Basic
    public String getUsrdt5() {
        return usrdt5;
    }

    public void setUsrdt5(String usrdt5) {
        this.usrdt5 = usrdt5;
    }

    private String usrdt6;

    @javax.persistence.Column(name = "USRDT6")
    @Basic
    public String getUsrdt6() {
        return usrdt6;
    }

    public void setUsrdt6(String usrdt6) {
        this.usrdt6 = usrdt6;
    }

    private String usrdt7;

    @javax.persistence.Column(name = "USRDT7")
    @Basic
    public String getUsrdt7() {
        return usrdt7;
    }

    public void setUsrdt7(String usrdt7) {
        this.usrdt7 = usrdt7;
    }

    private String usrdt8;

    @javax.persistence.Column(name = "USRDT8")
    @Basic
    public String getUsrdt8() {
        return usrdt8;
    }

    public void setUsrdt8(String usrdt8) {
        this.usrdt8 = usrdt8;
    }

    private String usrdt9;

    @javax.persistence.Column(name = "USRDT9")
    @Basic
    public String getUsrdt9() {
        return usrdt9;
    }

    public void setUsrdt9(String usrdt9) {
        this.usrdt9 = usrdt9;
    }

    private String usrdta;

    @javax.persistence.Column(name = "USRDTA")
    @Basic
    public String getUsrdta() {
        return usrdta;
    }

    public void setUsrdta(String usrdta) {
        this.usrdta = usrdta;
    }

    private String usrdtb;

    @javax.persistence.Column(name = "USRDTB")
    @Basic
    public String getUsrdtb() {
        return usrdtb;
    }

    public void setUsrdtb(String usrdtb) {
        this.usrdtb = usrdtb;
    }

    private String usrdtc;

    @javax.persistence.Column(name = "USRDTC")
    @Basic
    public String getUsrdtc() {
        return usrdtc;
    }

    public void setUsrdtc(String usrdtc) {
        this.usrdtc = usrdtc;
    }

    private String usrdtd;

    @javax.persistence.Column(name = "USRDTD")
    @Basic
    public String getUsrdtd() {
        return usrdtd;
    }

    public void setUsrdtd(String usrdtd) {
        this.usrdtd = usrdtd;
    }

    private String usrdte;

    @javax.persistence.Column(name = "USRDTE")
    @Basic
    public String getUsrdte() {
        return usrdte;
    }

    public void setUsrdte(String usrdte) {
        this.usrdte = usrdte;
    }

    private String usrdtf;

    @javax.persistence.Column(name = "USRDTF")
    @Basic
    public String getUsrdtf() {
        return usrdtf;
    }

    public void setUsrdtf(String usrdtf) {
        this.usrdtf = usrdtf;
    }

    private String usrdtg;

    @javax.persistence.Column(name = "USRDTG")
    @Basic
    public String getUsrdtg() {
        return usrdtg;
    }

    public void setUsrdtg(String usrdtg) {
        this.usrdtg = usrdtg;
    }

    private String usrdth;

    @javax.persistence.Column(name = "USRDTH")
    @Basic
    public String getUsrdth() {
        return usrdth;
    }

    public void setUsrdth(String usrdth) {
        this.usrdth = usrdth;
    }

    private String usrdti;

    @javax.persistence.Column(name = "USRDTI")
    @Basic
    public String getUsrdti() {
        return usrdti;
    }

    public void setUsrdti(String usrdti) {
        this.usrdti = usrdti;
    }

    private String usrdtj;

    @javax.persistence.Column(name = "USRDTJ")
    @Basic
    public String getUsrdtj() {
        return usrdtj;
    }

    public void setUsrdtj(String usrdtj) {
        this.usrdtj = usrdtj;
    }

    private String usrdtk;

    @javax.persistence.Column(name = "USRDTK")
    @Basic
    public String getUsrdtk() {
        return usrdtk;
    }

    public void setUsrdtk(String usrdtk) {
        this.usrdtk = usrdtk;
    }

    private String uc1L01;

    @javax.persistence.Column(name = "UC1L01")
    @Basic
    public String getUc1L01() {
        return uc1L01;
    }

    public void setUc1L01(String uc1L01) {
        this.uc1L01 = uc1L01;
    }

    private String uc1L02;

    @javax.persistence.Column(name = "UC1L02")
    @Basic
    public String getUc1L02() {
        return uc1L02;
    }

    public void setUc1L02(String uc1L02) {
        this.uc1L02 = uc1L02;
    }

    private String uc1L03;

    @javax.persistence.Column(name = "UC1L03")
    @Basic
    public String getUc1L03() {
        return uc1L03;
    }

    public void setUc1L03(String uc1L03) {
        this.uc1L03 = uc1L03;
    }

    private String uc1L04;

    @javax.persistence.Column(name = "UC1L04")
    @Basic
    public String getUc1L04() {
        return uc1L04;
    }

    public void setUc1L04(String uc1L04) {
        this.uc1L04 = uc1L04;
    }

    private String uc1L05;

    @javax.persistence.Column(name = "UC1L05")
    @Basic
    public String getUc1L05() {
        return uc1L05;
    }

    public void setUc1L05(String uc1L05) {
        this.uc1L05 = uc1L05;
    }

    private String uc1L06;

    @javax.persistence.Column(name = "UC1L06")
    @Basic
    public String getUc1L06() {
        return uc1L06;
    }

    public void setUc1L06(String uc1L06) {
        this.uc1L06 = uc1L06;
    }

    private String uc1L07;

    @javax.persistence.Column(name = "UC1L07")
    @Basic
    public String getUc1L07() {
        return uc1L07;
    }

    public void setUc1L07(String uc1L07) {
        this.uc1L07 = uc1L07;
    }

    private String uc1L08;

    @javax.persistence.Column(name = "UC1L08")
    @Basic
    public String getUc1L08() {
        return uc1L08;
    }

    public void setUc1L08(String uc1L08) {
        this.uc1L08 = uc1L08;
    }

    private String uc1L09;

    @javax.persistence.Column(name = "UC1L09")
    @Basic
    public String getUc1L09() {
        return uc1L09;
    }

    public void setUc1L09(String uc1L09) {
        this.uc1L09 = uc1L09;
    }

    private String uc1L10;

    @javax.persistence.Column(name = "UC1L10")
    @Basic
    public String getUc1L10() {
        return uc1L10;
    }

    public void setUc1L10(String uc1L10) {
        this.uc1L10 = uc1L10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UctEntity uctEntity = (UctEntity) o;

        if (revlev != uctEntity.revlev) return false;
        if (usnr1 != uctEntity.usnr1) return false;
        if (usnr11 != uctEntity.usnr11) return false;
        if (usnr12 != uctEntity.usnr12) return false;
        if (usnr13 != uctEntity.usnr13) return false;
        if (usnr14 != uctEntity.usnr14) return false;
        if (usnr15 != uctEntity.usnr15) return false;
        if (usnr2 != uctEntity.usnr2) return false;
        if (usnr3 != uctEntity.usnr3) return false;
        if (usnr4 != uctEntity.usnr4) return false;
        if (usnr5 != uctEntity.usnr5) return false;
        if (aidyr != null ? !aidyr.equals(uctEntity.aidyr) : uctEntity.aidyr != null) return false;
        if (crtdate != null ? !crtdate.equals(uctEntity.crtdate) : uctEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(uctEntity.crtmod) : uctEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(uctEntity.crttime) : uctEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(uctEntity.crtuser) : uctEntity.crtuser != null) return false;
        if (recstat != null ? !recstat.equals(uctEntity.recstat) : uctEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(uctEntity.revdate) : uctEntity.revdate != null) return false;
        if (revmod != null ? !revmod.equals(uctEntity.revmod) : uctEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(uctEntity.revtime) : uctEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(uctEntity.revuser) : uctEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(uctEntity.sid) : uctEntity.sid != null) return false;
        if (term != null ? !term.equals(uctEntity.term) : uctEntity.term != null) return false;
        if (uc12F1 != null ? !uc12F1.equals(uctEntity.uc12F1) : uctEntity.uc12F1 != null) return false;
        if (uc12F2 != null ? !uc12F2.equals(uctEntity.uc12F2) : uctEntity.uc12F2 != null) return false;
        if (uc12F3 != null ? !uc12F3.equals(uctEntity.uc12F3) : uctEntity.uc12F3 != null) return false;
        if (uc1F01 != null ? !uc1F01.equals(uctEntity.uc1F01) : uctEntity.uc1F01 != null) return false;
        if (uc1F02 != null ? !uc1F02.equals(uctEntity.uc1F02) : uctEntity.uc1F02 != null) return false;
        if (uc1F03 != null ? !uc1F03.equals(uctEntity.uc1F03) : uctEntity.uc1F03 != null) return false;
        if (uc1F04 != null ? !uc1F04.equals(uctEntity.uc1F04) : uctEntity.uc1F04 != null) return false;
        if (uc1F05 != null ? !uc1F05.equals(uctEntity.uc1F05) : uctEntity.uc1F05 != null) return false;
        if (uc1F06 != null ? !uc1F06.equals(uctEntity.uc1F06) : uctEntity.uc1F06 != null) return false;
        if (uc1F07 != null ? !uc1F07.equals(uctEntity.uc1F07) : uctEntity.uc1F07 != null) return false;
        if (uc1F08 != null ? !uc1F08.equals(uctEntity.uc1F08) : uctEntity.uc1F08 != null) return false;
        if (uc1F09 != null ? !uc1F09.equals(uctEntity.uc1F09) : uctEntity.uc1F09 != null) return false;
        if (uc1F10 != null ? !uc1F10.equals(uctEntity.uc1F10) : uctEntity.uc1F10 != null) return false;
        if (uc1F11 != null ? !uc1F11.equals(uctEntity.uc1F11) : uctEntity.uc1F11 != null) return false;
        if (uc1F12 != null ? !uc1F12.equals(uctEntity.uc1F12) : uctEntity.uc1F12 != null) return false;
        if (uc1F13 != null ? !uc1F13.equals(uctEntity.uc1F13) : uctEntity.uc1F13 != null) return false;
        if (uc1F14 != null ? !uc1F14.equals(uctEntity.uc1F14) : uctEntity.uc1F14 != null) return false;
        if (uc1F15 != null ? !uc1F15.equals(uctEntity.uc1F15) : uctEntity.uc1F15 != null) return false;
        if (uc1F16 != null ? !uc1F16.equals(uctEntity.uc1F16) : uctEntity.uc1F16 != null) return false;
        if (uc1F17 != null ? !uc1F17.equals(uctEntity.uc1F17) : uctEntity.uc1F17 != null) return false;
        if (uc1F18 != null ? !uc1F18.equals(uctEntity.uc1F18) : uctEntity.uc1F18 != null) return false;
        if (uc1F19 != null ? !uc1F19.equals(uctEntity.uc1F19) : uctEntity.uc1F19 != null) return false;
        if (uc1F20 != null ? !uc1F20.equals(uctEntity.uc1F20) : uctEntity.uc1F20 != null) return false;
        if (uc1F21 != null ? !uc1F21.equals(uctEntity.uc1F21) : uctEntity.uc1F21 != null) return false;
        if (uc1F22 != null ? !uc1F22.equals(uctEntity.uc1F22) : uctEntity.uc1F22 != null) return false;
        if (uc1F23 != null ? !uc1F23.equals(uctEntity.uc1F23) : uctEntity.uc1F23 != null) return false;
        if (uc1F24 != null ? !uc1F24.equals(uctEntity.uc1F24) : uctEntity.uc1F24 != null) return false;
        if (uc1F25 != null ? !uc1F25.equals(uctEntity.uc1F25) : uctEntity.uc1F25 != null) return false;
        if (uc1F26 != null ? !uc1F26.equals(uctEntity.uc1F26) : uctEntity.uc1F26 != null) return false;
        if (uc1F27 != null ? !uc1F27.equals(uctEntity.uc1F27) : uctEntity.uc1F27 != null) return false;
        if (uc1F28 != null ? !uc1F28.equals(uctEntity.uc1F28) : uctEntity.uc1F28 != null) return false;
        if (uc1F29 != null ? !uc1F29.equals(uctEntity.uc1F29) : uctEntity.uc1F29 != null) return false;
        if (uc1F30 != null ? !uc1F30.equals(uctEntity.uc1F30) : uctEntity.uc1F30 != null) return false;
        if (uc1F31 != null ? !uc1F31.equals(uctEntity.uc1F31) : uctEntity.uc1F31 != null) return false;
        if (uc1F32 != null ? !uc1F32.equals(uctEntity.uc1F32) : uctEntity.uc1F32 != null) return false;
        if (uc1F33 != null ? !uc1F33.equals(uctEntity.uc1F33) : uctEntity.uc1F33 != null) return false;
        if (uc1F34 != null ? !uc1F34.equals(uctEntity.uc1F34) : uctEntity.uc1F34 != null) return false;
        if (uc1F35 != null ? !uc1F35.equals(uctEntity.uc1F35) : uctEntity.uc1F35 != null) return false;
        if (uc1F36 != null ? !uc1F36.equals(uctEntity.uc1F36) : uctEntity.uc1F36 != null) return false;
        if (uc1F37 != null ? !uc1F37.equals(uctEntity.uc1F37) : uctEntity.uc1F37 != null) return false;
        if (uc1F38 != null ? !uc1F38.equals(uctEntity.uc1F38) : uctEntity.uc1F38 != null) return false;
        if (uc1F39 != null ? !uc1F39.equals(uctEntity.uc1F39) : uctEntity.uc1F39 != null) return false;
        if (uc1F40 != null ? !uc1F40.equals(uctEntity.uc1F40) : uctEntity.uc1F40 != null) return false;
        if (uc1L01 != null ? !uc1L01.equals(uctEntity.uc1L01) : uctEntity.uc1L01 != null) return false;
        if (uc1L02 != null ? !uc1L02.equals(uctEntity.uc1L02) : uctEntity.uc1L02 != null) return false;
        if (uc1L03 != null ? !uc1L03.equals(uctEntity.uc1L03) : uctEntity.uc1L03 != null) return false;
        if (uc1L04 != null ? !uc1L04.equals(uctEntity.uc1L04) : uctEntity.uc1L04 != null) return false;
        if (uc1L05 != null ? !uc1L05.equals(uctEntity.uc1L05) : uctEntity.uc1L05 != null) return false;
        if (uc1L06 != null ? !uc1L06.equals(uctEntity.uc1L06) : uctEntity.uc1L06 != null) return false;
        if (uc1L07 != null ? !uc1L07.equals(uctEntity.uc1L07) : uctEntity.uc1L07 != null) return false;
        if (uc1L08 != null ? !uc1L08.equals(uctEntity.uc1L08) : uctEntity.uc1L08 != null) return false;
        if (uc1L09 != null ? !uc1L09.equals(uctEntity.uc1L09) : uctEntity.uc1L09 != null) return false;
        if (uc1L10 != null ? !uc1L10.equals(uctEntity.uc1L10) : uctEntity.uc1L10 != null) return false;
        if (uc2F01 != null ? !uc2F01.equals(uctEntity.uc2F01) : uctEntity.uc2F01 != null) return false;
        if (uc2F02 != null ? !uc2F02.equals(uctEntity.uc2F02) : uctEntity.uc2F02 != null) return false;
        if (uc2F03 != null ? !uc2F03.equals(uctEntity.uc2F03) : uctEntity.uc2F03 != null) return false;
        if (uc2F04 != null ? !uc2F04.equals(uctEntity.uc2F04) : uctEntity.uc2F04 != null) return false;
        if (uc2F05 != null ? !uc2F05.equals(uctEntity.uc2F05) : uctEntity.uc2F05 != null) return false;
        if (uc2F06 != null ? !uc2F06.equals(uctEntity.uc2F06) : uctEntity.uc2F06 != null) return false;
        if (uc2F07 != null ? !uc2F07.equals(uctEntity.uc2F07) : uctEntity.uc2F07 != null) return false;
        if (uc2F08 != null ? !uc2F08.equals(uctEntity.uc2F08) : uctEntity.uc2F08 != null) return false;
        if (uc2F09 != null ? !uc2F09.equals(uctEntity.uc2F09) : uctEntity.uc2F09 != null) return false;
        if (uc2F10 != null ? !uc2F10.equals(uctEntity.uc2F10) : uctEntity.uc2F10 != null) return false;
        if (uc2F11 != null ? !uc2F11.equals(uctEntity.uc2F11) : uctEntity.uc2F11 != null) return false;
        if (uc2F12 != null ? !uc2F12.equals(uctEntity.uc2F12) : uctEntity.uc2F12 != null) return false;
        if (uc2F13 != null ? !uc2F13.equals(uctEntity.uc2F13) : uctEntity.uc2F13 != null) return false;
        if (uc2F14 != null ? !uc2F14.equals(uctEntity.uc2F14) : uctEntity.uc2F14 != null) return false;
        if (uc2F15 != null ? !uc2F15.equals(uctEntity.uc2F15) : uctEntity.uc2F15 != null) return false;
        if (uc2F16 != null ? !uc2F16.equals(uctEntity.uc2F16) : uctEntity.uc2F16 != null) return false;
        if (uc2F17 != null ? !uc2F17.equals(uctEntity.uc2F17) : uctEntity.uc2F17 != null) return false;
        if (uc2F18 != null ? !uc2F18.equals(uctEntity.uc2F18) : uctEntity.uc2F18 != null) return false;
        if (uc2F19 != null ? !uc2F19.equals(uctEntity.uc2F19) : uctEntity.uc2F19 != null) return false;
        if (uc2F20 != null ? !uc2F20.equals(uctEntity.uc2F20) : uctEntity.uc2F20 != null) return false;
        if (uc4F01 != null ? !uc4F01.equals(uctEntity.uc4F01) : uctEntity.uc4F01 != null) return false;
        if (uc4F02 != null ? !uc4F02.equals(uctEntity.uc4F02) : uctEntity.uc4F02 != null) return false;
        if (uc4F03 != null ? !uc4F03.equals(uctEntity.uc4F03) : uctEntity.uc4F03 != null) return false;
        if (uc4F04 != null ? !uc4F04.equals(uctEntity.uc4F04) : uctEntity.uc4F04 != null) return false;
        if (uc4F05 != null ? !uc4F05.equals(uctEntity.uc4F05) : uctEntity.uc4F05 != null) return false;
        if (uc4F06 != null ? !uc4F06.equals(uctEntity.uc4F06) : uctEntity.uc4F06 != null) return false;
        if (uc4F07 != null ? !uc4F07.equals(uctEntity.uc4F07) : uctEntity.uc4F07 != null) return false;
        if (uc4F08 != null ? !uc4F08.equals(uctEntity.uc4F08) : uctEntity.uc4F08 != null) return false;
        if (uc4F09 != null ? !uc4F09.equals(uctEntity.uc4F09) : uctEntity.uc4F09 != null) return false;
        if (uc4F10 != null ? !uc4F10.equals(uctEntity.uc4F10) : uctEntity.uc4F10 != null) return false;
        if (uc4F11 != null ? !uc4F11.equals(uctEntity.uc4F11) : uctEntity.uc4F11 != null) return false;
        if (uc4F12 != null ? !uc4F12.equals(uctEntity.uc4F12) : uctEntity.uc4F12 != null) return false;
        if (uc4F13 != null ? !uc4F13.equals(uctEntity.uc4F13) : uctEntity.uc4F13 != null) return false;
        if (uc4F14 != null ? !uc4F14.equals(uctEntity.uc4F14) : uctEntity.uc4F14 != null) return false;
        if (uc4F15 != null ? !uc4F15.equals(uctEntity.uc4F15) : uctEntity.uc4F15 != null) return false;
        if (uc4F16 != null ? !uc4F16.equals(uctEntity.uc4F16) : uctEntity.uc4F16 != null) return false;
        if (uc4F17 != null ? !uc4F17.equals(uctEntity.uc4F17) : uctEntity.uc4F17 != null) return false;
        if (uc4F18 != null ? !uc4F18.equals(uctEntity.uc4F18) : uctEntity.uc4F18 != null) return false;
        if (uc4F19 != null ? !uc4F19.equals(uctEntity.uc4F19) : uctEntity.uc4F19 != null) return false;
        if (uc4F20 != null ? !uc4F20.equals(uctEntity.uc4F20) : uctEntity.uc4F20 != null) return false;
        if (uc6F01 != null ? !uc6F01.equals(uctEntity.uc6F01) : uctEntity.uc6F01 != null) return false;
        if (uc6F02 != null ? !uc6F02.equals(uctEntity.uc6F02) : uctEntity.uc6F02 != null) return false;
        if (uc6F03 != null ? !uc6F03.equals(uctEntity.uc6F03) : uctEntity.uc6F03 != null) return false;
        if (uc6F04 != null ? !uc6F04.equals(uctEntity.uc6F04) : uctEntity.uc6F04 != null) return false;
        if (uc6F05 != null ? !uc6F05.equals(uctEntity.uc6F05) : uctEntity.uc6F05 != null) return false;
        if (uc6F06 != null ? !uc6F06.equals(uctEntity.uc6F06) : uctEntity.uc6F06 != null) return false;
        if (uc6F07 != null ? !uc6F07.equals(uctEntity.uc6F07) : uctEntity.uc6F07 != null) return false;
        if (uc6F08 != null ? !uc6F08.equals(uctEntity.uc6F08) : uctEntity.uc6F08 != null) return false;
        if (uc6F09 != null ? !uc6F09.equals(uctEntity.uc6F09) : uctEntity.uc6F09 != null) return false;
        if (uc6F10 != null ? !uc6F10.equals(uctEntity.uc6F10) : uctEntity.uc6F10 != null) return false;
        if (ucode != null ? !ucode.equals(uctEntity.ucode) : uctEntity.ucode != null) return false;
        if (uctkey != null ? !uctkey.equals(uctEntity.uctkey) : uctEntity.uctkey != null) return false;
        if (usnr10 != null ? !usnr10.equals(uctEntity.usnr10) : uctEntity.usnr10 != null) return false;
        if (usnr16 != null ? !usnr16.equals(uctEntity.usnr16) : uctEntity.usnr16 != null) return false;
        if (usnr17 != null ? !usnr17.equals(uctEntity.usnr17) : uctEntity.usnr17 != null) return false;
        if (usnr18 != null ? !usnr18.equals(uctEntity.usnr18) : uctEntity.usnr18 != null) return false;
        if (usnr19 != null ? !usnr19.equals(uctEntity.usnr19) : uctEntity.usnr19 != null) return false;
        if (usnr20 != null ? !usnr20.equals(uctEntity.usnr20) : uctEntity.usnr20 != null) return false;
        if (usnr6 != null ? !usnr6.equals(uctEntity.usnr6) : uctEntity.usnr6 != null) return false;
        if (usnr7 != null ? !usnr7.equals(uctEntity.usnr7) : uctEntity.usnr7 != null) return false;
        if (usnr8 != null ? !usnr8.equals(uctEntity.usnr8) : uctEntity.usnr8 != null) return false;
        if (usnr9 != null ? !usnr9.equals(uctEntity.usnr9) : uctEntity.usnr9 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(uctEntity.usrdt1) : uctEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(uctEntity.usrdt2) : uctEntity.usrdt2 != null) return false;
        if (usrdt3 != null ? !usrdt3.equals(uctEntity.usrdt3) : uctEntity.usrdt3 != null) return false;
        if (usrdt4 != null ? !usrdt4.equals(uctEntity.usrdt4) : uctEntity.usrdt4 != null) return false;
        if (usrdt5 != null ? !usrdt5.equals(uctEntity.usrdt5) : uctEntity.usrdt5 != null) return false;
        if (usrdt6 != null ? !usrdt6.equals(uctEntity.usrdt6) : uctEntity.usrdt6 != null) return false;
        if (usrdt7 != null ? !usrdt7.equals(uctEntity.usrdt7) : uctEntity.usrdt7 != null) return false;
        if (usrdt8 != null ? !usrdt8.equals(uctEntity.usrdt8) : uctEntity.usrdt8 != null) return false;
        if (usrdt9 != null ? !usrdt9.equals(uctEntity.usrdt9) : uctEntity.usrdt9 != null) return false;
        if (usrdta != null ? !usrdta.equals(uctEntity.usrdta) : uctEntity.usrdta != null) return false;
        if (usrdtb != null ? !usrdtb.equals(uctEntity.usrdtb) : uctEntity.usrdtb != null) return false;
        if (usrdtc != null ? !usrdtc.equals(uctEntity.usrdtc) : uctEntity.usrdtc != null) return false;
        if (usrdtd != null ? !usrdtd.equals(uctEntity.usrdtd) : uctEntity.usrdtd != null) return false;
        if (usrdte != null ? !usrdte.equals(uctEntity.usrdte) : uctEntity.usrdte != null) return false;
        if (usrdtf != null ? !usrdtf.equals(uctEntity.usrdtf) : uctEntity.usrdtf != null) return false;
        if (usrdtg != null ? !usrdtg.equals(uctEntity.usrdtg) : uctEntity.usrdtg != null) return false;
        if (usrdth != null ? !usrdth.equals(uctEntity.usrdth) : uctEntity.usrdth != null) return false;
        if (usrdti != null ? !usrdti.equals(uctEntity.usrdti) : uctEntity.usrdti != null) return false;
        if (usrdtj != null ? !usrdtj.equals(uctEntity.usrdtj) : uctEntity.usrdtj != null) return false;
        if (usrdtk != null ? !usrdtk.equals(uctEntity.usrdtk) : uctEntity.usrdtk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (uctkey != null ? uctkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (uc1F01 != null ? uc1F01.hashCode() : 0);
        result = 31 * result + (uc1F02 != null ? uc1F02.hashCode() : 0);
        result = 31 * result + (uc1F03 != null ? uc1F03.hashCode() : 0);
        result = 31 * result + (uc1F04 != null ? uc1F04.hashCode() : 0);
        result = 31 * result + (uc1F05 != null ? uc1F05.hashCode() : 0);
        result = 31 * result + (uc1F06 != null ? uc1F06.hashCode() : 0);
        result = 31 * result + (uc1F07 != null ? uc1F07.hashCode() : 0);
        result = 31 * result + (uc1F08 != null ? uc1F08.hashCode() : 0);
        result = 31 * result + (uc1F09 != null ? uc1F09.hashCode() : 0);
        result = 31 * result + (uc1F10 != null ? uc1F10.hashCode() : 0);
        result = 31 * result + (uc1F11 != null ? uc1F11.hashCode() : 0);
        result = 31 * result + (uc1F12 != null ? uc1F12.hashCode() : 0);
        result = 31 * result + (uc1F13 != null ? uc1F13.hashCode() : 0);
        result = 31 * result + (uc1F14 != null ? uc1F14.hashCode() : 0);
        result = 31 * result + (uc1F15 != null ? uc1F15.hashCode() : 0);
        result = 31 * result + (uc1F16 != null ? uc1F16.hashCode() : 0);
        result = 31 * result + (uc1F17 != null ? uc1F17.hashCode() : 0);
        result = 31 * result + (uc1F18 != null ? uc1F18.hashCode() : 0);
        result = 31 * result + (uc1F19 != null ? uc1F19.hashCode() : 0);
        result = 31 * result + (uc1F20 != null ? uc1F20.hashCode() : 0);
        result = 31 * result + (uc1F21 != null ? uc1F21.hashCode() : 0);
        result = 31 * result + (uc1F22 != null ? uc1F22.hashCode() : 0);
        result = 31 * result + (uc1F23 != null ? uc1F23.hashCode() : 0);
        result = 31 * result + (uc1F24 != null ? uc1F24.hashCode() : 0);
        result = 31 * result + (uc1F25 != null ? uc1F25.hashCode() : 0);
        result = 31 * result + (uc1F26 != null ? uc1F26.hashCode() : 0);
        result = 31 * result + (uc1F27 != null ? uc1F27.hashCode() : 0);
        result = 31 * result + (uc1F28 != null ? uc1F28.hashCode() : 0);
        result = 31 * result + (uc1F29 != null ? uc1F29.hashCode() : 0);
        result = 31 * result + (uc1F30 != null ? uc1F30.hashCode() : 0);
        result = 31 * result + (uc1F31 != null ? uc1F31.hashCode() : 0);
        result = 31 * result + (uc1F32 != null ? uc1F32.hashCode() : 0);
        result = 31 * result + (uc1F33 != null ? uc1F33.hashCode() : 0);
        result = 31 * result + (uc1F34 != null ? uc1F34.hashCode() : 0);
        result = 31 * result + (uc1F35 != null ? uc1F35.hashCode() : 0);
        result = 31 * result + (uc1F36 != null ? uc1F36.hashCode() : 0);
        result = 31 * result + (uc1F37 != null ? uc1F37.hashCode() : 0);
        result = 31 * result + (uc1F38 != null ? uc1F38.hashCode() : 0);
        result = 31 * result + (uc1F39 != null ? uc1F39.hashCode() : 0);
        result = 31 * result + (uc1F40 != null ? uc1F40.hashCode() : 0);
        result = 31 * result + (uc2F01 != null ? uc2F01.hashCode() : 0);
        result = 31 * result + (uc2F02 != null ? uc2F02.hashCode() : 0);
        result = 31 * result + (uc2F03 != null ? uc2F03.hashCode() : 0);
        result = 31 * result + (uc2F04 != null ? uc2F04.hashCode() : 0);
        result = 31 * result + (uc2F05 != null ? uc2F05.hashCode() : 0);
        result = 31 * result + (uc2F06 != null ? uc2F06.hashCode() : 0);
        result = 31 * result + (uc2F07 != null ? uc2F07.hashCode() : 0);
        result = 31 * result + (uc2F08 != null ? uc2F08.hashCode() : 0);
        result = 31 * result + (uc2F09 != null ? uc2F09.hashCode() : 0);
        result = 31 * result + (uc2F10 != null ? uc2F10.hashCode() : 0);
        result = 31 * result + (uc2F11 != null ? uc2F11.hashCode() : 0);
        result = 31 * result + (uc2F12 != null ? uc2F12.hashCode() : 0);
        result = 31 * result + (uc2F13 != null ? uc2F13.hashCode() : 0);
        result = 31 * result + (uc2F14 != null ? uc2F14.hashCode() : 0);
        result = 31 * result + (uc2F15 != null ? uc2F15.hashCode() : 0);
        result = 31 * result + (uc2F16 != null ? uc2F16.hashCode() : 0);
        result = 31 * result + (uc2F17 != null ? uc2F17.hashCode() : 0);
        result = 31 * result + (uc2F18 != null ? uc2F18.hashCode() : 0);
        result = 31 * result + (uc2F19 != null ? uc2F19.hashCode() : 0);
        result = 31 * result + (uc2F20 != null ? uc2F20.hashCode() : 0);
        result = 31 * result + (uc4F01 != null ? uc4F01.hashCode() : 0);
        result = 31 * result + (uc4F02 != null ? uc4F02.hashCode() : 0);
        result = 31 * result + (uc4F03 != null ? uc4F03.hashCode() : 0);
        result = 31 * result + (uc4F04 != null ? uc4F04.hashCode() : 0);
        result = 31 * result + (uc4F05 != null ? uc4F05.hashCode() : 0);
        result = 31 * result + (uc4F06 != null ? uc4F06.hashCode() : 0);
        result = 31 * result + (uc4F07 != null ? uc4F07.hashCode() : 0);
        result = 31 * result + (uc4F08 != null ? uc4F08.hashCode() : 0);
        result = 31 * result + (uc4F09 != null ? uc4F09.hashCode() : 0);
        result = 31 * result + (uc4F10 != null ? uc4F10.hashCode() : 0);
        result = 31 * result + (uc4F11 != null ? uc4F11.hashCode() : 0);
        result = 31 * result + (uc4F12 != null ? uc4F12.hashCode() : 0);
        result = 31 * result + (uc4F13 != null ? uc4F13.hashCode() : 0);
        result = 31 * result + (uc4F14 != null ? uc4F14.hashCode() : 0);
        result = 31 * result + (uc4F15 != null ? uc4F15.hashCode() : 0);
        result = 31 * result + (uc4F16 != null ? uc4F16.hashCode() : 0);
        result = 31 * result + (uc4F17 != null ? uc4F17.hashCode() : 0);
        result = 31 * result + (uc4F18 != null ? uc4F18.hashCode() : 0);
        result = 31 * result + (uc4F19 != null ? uc4F19.hashCode() : 0);
        result = 31 * result + (uc4F20 != null ? uc4F20.hashCode() : 0);
        result = 31 * result + (uc6F01 != null ? uc6F01.hashCode() : 0);
        result = 31 * result + (uc6F02 != null ? uc6F02.hashCode() : 0);
        result = 31 * result + (uc6F03 != null ? uc6F03.hashCode() : 0);
        result = 31 * result + (uc6F04 != null ? uc6F04.hashCode() : 0);
        result = 31 * result + (uc6F05 != null ? uc6F05.hashCode() : 0);
        result = 31 * result + (uc6F06 != null ? uc6F06.hashCode() : 0);
        result = 31 * result + (uc6F07 != null ? uc6F07.hashCode() : 0);
        result = 31 * result + (uc6F08 != null ? uc6F08.hashCode() : 0);
        result = 31 * result + (uc6F09 != null ? uc6F09.hashCode() : 0);
        result = 31 * result + (uc6F10 != null ? uc6F10.hashCode() : 0);
        result = 31 * result + (uc12F1 != null ? uc12F1.hashCode() : 0);
        result = 31 * result + (uc12F2 != null ? uc12F2.hashCode() : 0);
        result = 31 * result + (uc12F3 != null ? uc12F3.hashCode() : 0);
        result = 31 * result + usnr1;
        result = 31 * result + usnr2;
        result = 31 * result + usnr3;
        result = 31 * result + usnr4;
        result = 31 * result + usnr5;
        result = 31 * result + (usnr6 != null ? usnr6.hashCode() : 0);
        result = 31 * result + (usnr7 != null ? usnr7.hashCode() : 0);
        result = 31 * result + (usnr8 != null ? usnr8.hashCode() : 0);
        result = 31 * result + (usnr9 != null ? usnr9.hashCode() : 0);
        result = 31 * result + (usnr10 != null ? usnr10.hashCode() : 0);
        result = 31 * result + usnr11;
        result = 31 * result + usnr12;
        result = 31 * result + usnr13;
        result = 31 * result + usnr14;
        result = 31 * result + usnr15;
        result = 31 * result + (usnr16 != null ? usnr16.hashCode() : 0);
        result = 31 * result + (usnr17 != null ? usnr17.hashCode() : 0);
        result = 31 * result + (usnr18 != null ? usnr18.hashCode() : 0);
        result = 31 * result + (usnr19 != null ? usnr19.hashCode() : 0);
        result = 31 * result + (usnr20 != null ? usnr20.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (usrdt2 != null ? usrdt2.hashCode() : 0);
        result = 31 * result + (usrdt3 != null ? usrdt3.hashCode() : 0);
        result = 31 * result + (usrdt4 != null ? usrdt4.hashCode() : 0);
        result = 31 * result + (usrdt5 != null ? usrdt5.hashCode() : 0);
        result = 31 * result + (usrdt6 != null ? usrdt6.hashCode() : 0);
        result = 31 * result + (usrdt7 != null ? usrdt7.hashCode() : 0);
        result = 31 * result + (usrdt8 != null ? usrdt8.hashCode() : 0);
        result = 31 * result + (usrdt9 != null ? usrdt9.hashCode() : 0);
        result = 31 * result + (usrdta != null ? usrdta.hashCode() : 0);
        result = 31 * result + (usrdtb != null ? usrdtb.hashCode() : 0);
        result = 31 * result + (usrdtc != null ? usrdtc.hashCode() : 0);
        result = 31 * result + (usrdtd != null ? usrdtd.hashCode() : 0);
        result = 31 * result + (usrdte != null ? usrdte.hashCode() : 0);
        result = 31 * result + (usrdtf != null ? usrdtf.hashCode() : 0);
        result = 31 * result + (usrdtg != null ? usrdtg.hashCode() : 0);
        result = 31 * result + (usrdth != null ? usrdth.hashCode() : 0);
        result = 31 * result + (usrdti != null ? usrdti.hashCode() : 0);
        result = 31 * result + (usrdtj != null ? usrdtj.hashCode() : 0);
        result = 31 * result + (usrdtk != null ? usrdtk.hashCode() : 0);
        result = 31 * result + (uc1L01 != null ? uc1L01.hashCode() : 0);
        result = 31 * result + (uc1L02 != null ? uc1L02.hashCode() : 0);
        result = 31 * result + (uc1L03 != null ? uc1L03.hashCode() : 0);
        result = 31 * result + (uc1L04 != null ? uc1L04.hashCode() : 0);
        result = 31 * result + (uc1L05 != null ? uc1L05.hashCode() : 0);
        result = 31 * result + (uc1L06 != null ? uc1L06.hashCode() : 0);
        result = 31 * result + (uc1L07 != null ? uc1L07.hashCode() : 0);
        result = 31 * result + (uc1L08 != null ? uc1L08.hashCode() : 0);
        result = 31 * result + (uc1L09 != null ? uc1L09.hashCode() : 0);
        result = 31 * result + (uc1L10 != null ? uc1L10.hashCode() : 0);
        return result;
    }
}
