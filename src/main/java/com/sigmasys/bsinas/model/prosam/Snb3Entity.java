package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/26/12
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNB3", schema = "SIGMA", catalog = "")
@Entity
public class Snb3Entity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnbkey();
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

    private String snbkey;

    @javax.persistence.Column(name = "SNBKEY")
    @Id
    public String getSnbkey() {
        return snbkey;
    }

    public void setSnbkey(String snbkey) {
        this.snbkey = snbkey;
    }

    private String instid;

    @javax.persistence.Column(name = "INSTID")
    @Basic
    public String getInstid() {
        return instid;
    }

    public void setInstid(String instid) {
        this.instid = instid;
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

    private String cmptype;

    @javax.persistence.Column(name = "CMPTYPE")
    @Basic
    public String getCmptype() {
        return cmptype;
    }

    public void setCmptype(String cmptype) {
        this.cmptype = cmptype;
    }

    private String versnr;

    @javax.persistence.Column(name = "VERSNR")
    @Basic
    public String getVersnr() {
        return versnr;
    }

    public void setVersnr(String versnr) {
        this.versnr = versnr;
    }

    private String rr01;

    @javax.persistence.Column(name = "RR01")
    @Basic
    public String getRr01() {
        return rr01;
    }

    public void setRr01(String rr01) {
        this.rr01 = rr01;
    }

    private String rr02;

    @javax.persistence.Column(name = "RR02")
    @Basic
    public String getRr02() {
        return rr02;
    }

    public void setRr02(String rr02) {
        this.rr02 = rr02;
    }

    private String rr03;

    @javax.persistence.Column(name = "RR03")
    @Basic
    public String getRr03() {
        return rr03;
    }

    public void setRr03(String rr03) {
        this.rr03 = rr03;
    }

    private String rr04;

    @javax.persistence.Column(name = "RR04")
    @Basic
    public String getRr04() {
        return rr04;
    }

    public void setRr04(String rr04) {
        this.rr04 = rr04;
    }

    private String rr05;

    @javax.persistence.Column(name = "RR05")
    @Basic
    public String getRr05() {
        return rr05;
    }

    public void setRr05(String rr05) {
        this.rr05 = rr05;
    }

    private String rr06;

    @javax.persistence.Column(name = "RR06")
    @Basic
    public String getRr06() {
        return rr06;
    }

    public void setRr06(String rr06) {
        this.rr06 = rr06;
    }

    private String rr07;

    @javax.persistence.Column(name = "RR07")
    @Basic
    public String getRr07() {
        return rr07;
    }

    public void setRr07(String rr07) {
        this.rr07 = rr07;
    }

    private String rr08;

    @javax.persistence.Column(name = "RR08")
    @Basic
    public String getRr08() {
        return rr08;
    }

    public void setRr08(String rr08) {
        this.rr08 = rr08;
    }

    private String rr09;

    @javax.persistence.Column(name = "RR09")
    @Basic
    public String getRr09() {
        return rr09;
    }

    public void setRr09(String rr09) {
        this.rr09 = rr09;
    }

    private String rr10;

    @javax.persistence.Column(name = "RR10")
    @Basic
    public String getRr10() {
        return rr10;
    }

    public void setRr10(String rr10) {
        this.rr10 = rr10;
    }

    private String rr11;

    @javax.persistence.Column(name = "RR11")
    @Basic
    public String getRr11() {
        return rr11;
    }

    public void setRr11(String rr11) {
        this.rr11 = rr11;
    }

    private String rr12;

    @javax.persistence.Column(name = "RR12")
    @Basic
    public String getRr12() {
        return rr12;
    }

    public void setRr12(String rr12) {
        this.rr12 = rr12;
    }

    private String rr13;

    @javax.persistence.Column(name = "RR13")
    @Basic
    public String getRr13() {
        return rr13;
    }

    public void setRr13(String rr13) {
        this.rr13 = rr13;
    }

    private String rr14;

    @javax.persistence.Column(name = "RR14")
    @Basic
    public String getRr14() {
        return rr14;
    }

    public void setRr14(String rr14) {
        this.rr14 = rr14;
    }

    private String rr15;

    @javax.persistence.Column(name = "RR15")
    @Basic
    public String getRr15() {
        return rr15;
    }

    public void setRr15(String rr15) {
        this.rr15 = rr15;
    }

    private String rr16;

    @javax.persistence.Column(name = "RR16")
    @Basic
    public String getRr16() {
        return rr16;
    }

    public void setRr16(String rr16) {
        this.rr16 = rr16;
    }

    private String rr17;

    @javax.persistence.Column(name = "RR17")
    @Basic
    public String getRr17() {
        return rr17;
    }

    public void setRr17(String rr17) {
        this.rr17 = rr17;
    }

    private String rr18;

    @javax.persistence.Column(name = "RR18")
    @Basic
    public String getRr18() {
        return rr18;
    }

    public void setRr18(String rr18) {
        this.rr18 = rr18;
    }

    private String rr19;

    @javax.persistence.Column(name = "RR19")
    @Basic
    public String getRr19() {
        return rr19;
    }

    public void setRr19(String rr19) {
        this.rr19 = rr19;
    }

    private String rr20;

    @javax.persistence.Column(name = "RR20")
    @Basic
    public String getRr20() {
        return rr20;
    }

    public void setRr20(String rr20) {
        this.rr20 = rr20;
    }

    private String rr21;

    @javax.persistence.Column(name = "RR21")
    @Basic
    public String getRr21() {
        return rr21;
    }

    public void setRr21(String rr21) {
        this.rr21 = rr21;
    }

    private String rr22;

    @javax.persistence.Column(name = "RR22")
    @Basic
    public String getRr22() {
        return rr22;
    }

    public void setRr22(String rr22) {
        this.rr22 = rr22;
    }

    private String rr23;

    @javax.persistence.Column(name = "RR23")
    @Basic
    public String getRr23() {
        return rr23;
    }

    public void setRr23(String rr23) {
        this.rr23 = rr23;
    }

    private String rr24;

    @javax.persistence.Column(name = "RR24")
    @Basic
    public String getRr24() {
        return rr24;
    }

    public void setRr24(String rr24) {
        this.rr24 = rr24;
    }

    private String rr25;

    @javax.persistence.Column(name = "RR25")
    @Basic
    public String getRr25() {
        return rr25;
    }

    public void setRr25(String rr25) {
        this.rr25 = rr25;
    }

    private String rr26;

    @javax.persistence.Column(name = "RR26")
    @Basic
    public String getRr26() {
        return rr26;
    }

    public void setRr26(String rr26) {
        this.rr26 = rr26;
    }

    private String rr27;

    @javax.persistence.Column(name = "RR27")
    @Basic
    public String getRr27() {
        return rr27;
    }

    public void setRr27(String rr27) {
        this.rr27 = rr27;
    }

    private String rr28;

    @javax.persistence.Column(name = "RR28")
    @Basic
    public String getRr28() {
        return rr28;
    }

    public void setRr28(String rr28) {
        this.rr28 = rr28;
    }

    private String rr29;

    @javax.persistence.Column(name = "RR29")
    @Basic
    public String getRr29() {
        return rr29;
    }

    public void setRr29(String rr29) {
        this.rr29 = rr29;
    }

    private String rr30;

    @javax.persistence.Column(name = "RR30")
    @Basic
    public String getRr30() {
        return rr30;
    }

    public void setRr30(String rr30) {
        this.rr30 = rr30;
    }

    private String rr31;

    @javax.persistence.Column(name = "RR31")
    @Basic
    public String getRr31() {
        return rr31;
    }

    public void setRr31(String rr31) {
        this.rr31 = rr31;
    }

    private String rr32;

    @javax.persistence.Column(name = "RR32")
    @Basic
    public String getRr32() {
        return rr32;
    }

    public void setRr32(String rr32) {
        this.rr32 = rr32;
    }

    private String rr33;

    @javax.persistence.Column(name = "RR33")
    @Basic
    public String getRr33() {
        return rr33;
    }

    public void setRr33(String rr33) {
        this.rr33 = rr33;
    }

    private String rr34;

    @javax.persistence.Column(name = "RR34")
    @Basic
    public String getRr34() {
        return rr34;
    }

    public void setRr34(String rr34) {
        this.rr34 = rr34;
    }

    private String rr35;

    @javax.persistence.Column(name = "RR35")
    @Basic
    public String getRr35() {
        return rr35;
    }

    public void setRr35(String rr35) {
        this.rr35 = rr35;
    }

    private String rr36;

    @javax.persistence.Column(name = "RR36")
    @Basic
    public String getRr36() {
        return rr36;
    }

    public void setRr36(String rr36) {
        this.rr36 = rr36;
    }

    private String rr37;

    @javax.persistence.Column(name = "RR37")
    @Basic
    public String getRr37() {
        return rr37;
    }

    public void setRr37(String rr37) {
        this.rr37 = rr37;
    }

    private String rr38;

    @javax.persistence.Column(name = "RR38")
    @Basic
    public String getRr38() {
        return rr38;
    }

    public void setRr38(String rr38) {
        this.rr38 = rr38;
    }

    private String rr39;

    @javax.persistence.Column(name = "RR39")
    @Basic
    public String getRr39() {
        return rr39;
    }

    public void setRr39(String rr39) {
        this.rr39 = rr39;
    }

    private String rr40;

    @javax.persistence.Column(name = "RR40")
    @Basic
    public String getRr40() {
        return rr40;
    }

    public void setRr40(String rr40) {
        this.rr40 = rr40;
    }

    private String rr41;

    @javax.persistence.Column(name = "RR41")
    @Basic
    public String getRr41() {
        return rr41;
    }

    public void setRr41(String rr41) {
        this.rr41 = rr41;
    }

    private String rr42;

    @javax.persistence.Column(name = "RR42")
    @Basic
    public String getRr42() {
        return rr42;
    }

    public void setRr42(String rr42) {
        this.rr42 = rr42;
    }

    private String rr43;

    @javax.persistence.Column(name = "RR43")
    @Basic
    public String getRr43() {
        return rr43;
    }

    public void setRr43(String rr43) {
        this.rr43 = rr43;
    }

    private String rr44;

    @javax.persistence.Column(name = "RR44")
    @Basic
    public String getRr44() {
        return rr44;
    }

    public void setRr44(String rr44) {
        this.rr44 = rr44;
    }

    private String rr45;

    @javax.persistence.Column(name = "RR45")
    @Basic
    public String getRr45() {
        return rr45;
    }

    public void setRr45(String rr45) {
        this.rr45 = rr45;
    }

    private String rr46;

    @javax.persistence.Column(name = "RR46")
    @Basic
    public String getRr46() {
        return rr46;
    }

    public void setRr46(String rr46) {
        this.rr46 = rr46;
    }

    private String rr47;

    @javax.persistence.Column(name = "RR47")
    @Basic
    public String getRr47() {
        return rr47;
    }

    public void setRr47(String rr47) {
        this.rr47 = rr47;
    }

    private String rr48;

    @javax.persistence.Column(name = "RR48")
    @Basic
    public String getRr48() {
        return rr48;
    }

    public void setRr48(String rr48) {
        this.rr48 = rr48;
    }

    private String rrovera;

    @javax.persistence.Column(name = "RROVERA")
    @Basic
    public String getRrovera() {
        return rrovera;
    }

    public void setRrovera(String rrovera) {
        this.rrovera = rrovera;
    }

    private String rroverb;

    @javax.persistence.Column(name = "RROVERB")
    @Basic
    public String getRroverb() {
        return rroverb;
    }

    public void setRroverb(String rroverb) {
        this.rroverb = rroverb;
    }

    private String rroverd;

    @javax.persistence.Column(name = "RROVERD")
    @Basic
    public String getRroverd() {
        return rroverd;
    }

    public void setRroverd(String rroverd) {
        this.rroverd = rroverd;
    }

    private String rroverg;

    @javax.persistence.Column(name = "RROVERG")
    @Basic
    public String getRroverg() {
        return rroverg;
    }

    public void setRroverg(String rroverg) {
        this.rroverg = rroverg;
    }

    private String rrovern;

    @javax.persistence.Column(name = "RROVERN")
    @Basic
    public String getRrovern() {
        return rrovern;
    }

    public void setRrovern(String rrovern) {
        this.rrovern = rrovern;
    }

    private String rroveru;

    @javax.persistence.Column(name = "RROVERU")
    @Basic
    public String getRroveru() {
        return rroveru;
    }

    public void setRroveru(String rroveru) {
        this.rroveru = rroveru;
    }

    private String rroverw;

    @javax.persistence.Column(name = "RROVERW")
    @Basic
    public String getRroverw() {
        return rroverw;
    }

    public void setRroverw(String rroverw) {
        this.rroverw = rroverw;
    }

    private int phcredt;

    @javax.persistence.Column(name = "PHCREDT")
    @Basic
    public int getPhcredt() {
        return phcredt;
    }

    public void setPhcredt(int phcredt) {
        this.phcredt = phcredt;
    }

    private String asmovr1;

    @javax.persistence.Column(name = "ASMOVR1")
    @Basic
    public String getAsmovr1() {
        return asmovr1;
    }

    public void setAsmovr1(String asmovr1) {
        this.asmovr1 = asmovr1;
    }

    private String asmovr2;

    @javax.persistence.Column(name = "ASMOVR2")
    @Basic
    public String getAsmovr2() {
        return asmovr2;
    }

    public void setAsmovr2(String asmovr2) {
        this.asmovr2 = asmovr2;
    }

    private String asmovr3;

    @javax.persistence.Column(name = "ASMOVR3")
    @Basic
    public String getAsmovr3() {
        return asmovr3;
    }

    public void setAsmovr3(String asmovr3) {
        this.asmovr3 = asmovr3;
    }

    private String asmovr4;

    @javax.persistence.Column(name = "ASMOVR4")
    @Basic
    public String getAsmovr4() {
        return asmovr4;
    }

    public void setAsmovr4(String asmovr4) {
        this.asmovr4 = asmovr4;
    }

    private String asmovr5;

    @javax.persistence.Column(name = "ASMOVR5")
    @Basic
    public String getAsmovr5() {
        return asmovr5;
    }

    public void setAsmovr5(String asmovr5) {
        this.asmovr5 = asmovr5;
    }

    private String asmovr6;

    @javax.persistence.Column(name = "ASMOVR6")
    @Basic
    public String getAsmovr6() {
        return asmovr6;
    }

    public void setAsmovr6(String asmovr6) {
        this.asmovr6 = asmovr6;
    }

    private String asmovr7;

    @javax.persistence.Column(name = "ASMOVR7")
    @Basic
    public String getAsmovr7() {
        return asmovr7;
    }

    public void setAsmovr7(String asmovr7) {
        this.asmovr7 = asmovr7;
    }

    private String asmovr8;

    @javax.persistence.Column(name = "ASMOVR8")
    @Basic
    public String getAsmovr8() {
        return asmovr8;
    }

    public void setAsmovr8(String asmovr8) {
        this.asmovr8 = asmovr8;
    }

    private String asmovr9;

    @javax.persistence.Column(name = "ASMOVR9")
    @Basic
    public String getAsmovr9() {
        return asmovr9;
    }

    public void setAsmovr9(String asmovr9) {
        this.asmovr9 = asmovr9;
    }

    private int ptdpens;

    @javax.persistence.Column(name = "PTDPENS")
    @Basic
    public int getPtdpens() {
        return ptdpens;
    }

    public void setPtdpens(int ptdpens) {
        this.ptdpens = ptdpens;
    }

    private String spclcond;

    @javax.persistence.Column(name = "SPCLCOND")
    @Basic
    public String getSpclcond() {
        return spclcond;
    }

    public void setSpclcond(String spclcond) {
        this.spclcond = spclcond;
    }

    private int spclpefc;

    @javax.persistence.Column(name = "SPCLPEFC")
    @Basic
    public int getSpclpefc() {
        return spclpefc;
    }

    public void setSpclpefc(int spclpefc) {
        this.spclpefc = spclpefc;
    }

    private int spclsefc;

    @javax.persistence.Column(name = "SPCLSEFC")
    @Basic
    public int getSpclsefc() {
        return spclsefc;
    }

    public void setSpclsefc(int spclsefc) {
        this.spclsefc = spclsefc;
    }

    private String depover;

    @javax.persistence.Column(name = "DEPOVER")
    @Basic
    public String getDepover() {
        return depover;
    }

    public void setDepover(String depover) {
        this.depover = depover;
    }

    private String pgitype;

    @javax.persistence.Column(name = "PGITYPE")
    @Basic
    public String getPgitype() {
        return pgitype;
    }

    public void setPgitype(String pgitype) {
        this.pgitype = pgitype;
    }

    private int ossai;

    @javax.persistence.Column(name = "OSSAI")
    @Basic
    public int getOssai() {
        return ossai;
    }

    public void setOssai(int ossai) {
        this.ossai = ossai;
    }

    private int ptfcf1M;

    @javax.persistence.Column(name = "PTFCF1M")
    @Basic
    public int getPtfcf1M() {
        return ptfcf1M;
    }

    public void setPtfcf1M(int ptfcf1M) {
        this.ptfcf1M = ptfcf1M;
    }

    private int ptfcf2M;

    @javax.persistence.Column(name = "PTFCF2M")
    @Basic
    public int getPtfcf2M() {
        return ptfcf2M;
    }

    public void setPtfcf2M(int ptfcf2M) {
        this.ptfcf2M = ptfcf2M;
    }

    private int ptfcf3M;

    @javax.persistence.Column(name = "PTFCF3M")
    @Basic
    public int getPtfcf3M() {
        return ptfcf3M;
    }

    public void setPtfcf3M(int ptfcf3M) {
        this.ptfcf3M = ptfcf3M;
    }

    private int ptfcf4M;

    @javax.persistence.Column(name = "PTFCF4M")
    @Basic
    public int getPtfcf4M() {
        return ptfcf4M;
    }

    public void setPtfcf4M(int ptfcf4M) {
        this.ptfcf4M = ptfcf4M;
    }

    private int ptfcf5M;

    @javax.persistence.Column(name = "PTFCF5M")
    @Basic
    public int getPtfcf5M() {
        return ptfcf5M;
    }

    public void setPtfcf5M(int ptfcf5M) {
        this.ptfcf5M = ptfcf5M;
    }

    private int ptfcf6M;

    @javax.persistence.Column(name = "PTFCF6M")
    @Basic
    public int getPtfcf6M() {
        return ptfcf6M;
    }

    public void setPtfcf6M(int ptfcf6M) {
        this.ptfcf6M = ptfcf6M;
    }

    private int ptfcf7M;

    @javax.persistence.Column(name = "PTFCF7M")
    @Basic
    public int getPtfcf7M() {
        return ptfcf7M;
    }

    public void setPtfcf7M(int ptfcf7M) {
        this.ptfcf7M = ptfcf7M;
    }

    private int ptfcf8M;

    @javax.persistence.Column(name = "PTFCF8M")
    @Basic
    public int getPtfcf8M() {
        return ptfcf8M;
    }

    public void setPtfcf8M(int ptfcf8M) {
        this.ptfcf8M = ptfcf8M;
    }

    private int ptfcf9M;

    @javax.persistence.Column(name = "PTFCF9M")
    @Basic
    public int getPtfcf9M() {
        return ptfcf9M;
    }

    public void setPtfcf9M(int ptfcf9M) {
        this.ptfcf9M = ptfcf9M;
    }

    private int ptfcf10M;

    @javax.persistence.Column(name = "PTFCF10M")
    @Basic
    public int getPtfcf10M() {
        return ptfcf10M;
    }

    public void setPtfcf10M(int ptfcf10M) {
        this.ptfcf10M = ptfcf10M;
    }

    private int ptfcf11M;

    @javax.persistence.Column(name = "PTFCF11M")
    @Basic
    public int getPtfcf11M() {
        return ptfcf11M;
    }

    public void setPtfcf11M(int ptfcf11M) {
        this.ptfcf11M = ptfcf11M;
    }

    private int ptfcf12M;

    @javax.persistence.Column(name = "PTFCF12M")
    @Basic
    public int getPtfcf12M() {
        return ptfcf12M;
    }

    public void setPtfcf12M(int ptfcf12M) {
        this.ptfcf12M = ptfcf12M;
    }

    private int stfcf1M;

    @javax.persistence.Column(name = "STFCF1M")
    @Basic
    public int getStfcf1M() {
        return stfcf1M;
    }

    public void setStfcf1M(int stfcf1M) {
        this.stfcf1M = stfcf1M;
    }

    private int stfcf2M;

    @javax.persistence.Column(name = "STFCF2M")
    @Basic
    public int getStfcf2M() {
        return stfcf2M;
    }

    public void setStfcf2M(int stfcf2M) {
        this.stfcf2M = stfcf2M;
    }

    private int stfcf3M;

    @javax.persistence.Column(name = "STFCF3M")
    @Basic
    public int getStfcf3M() {
        return stfcf3M;
    }

    public void setStfcf3M(int stfcf3M) {
        this.stfcf3M = stfcf3M;
    }

    private int stfcf4M;

    @javax.persistence.Column(name = "STFCF4M")
    @Basic
    public int getStfcf4M() {
        return stfcf4M;
    }

    public void setStfcf4M(int stfcf4M) {
        this.stfcf4M = stfcf4M;
    }

    private int stfcf5M;

    @javax.persistence.Column(name = "STFCF5M")
    @Basic
    public int getStfcf5M() {
        return stfcf5M;
    }

    public void setStfcf5M(int stfcf5M) {
        this.stfcf5M = stfcf5M;
    }

    private int stfcf6M;

    @javax.persistence.Column(name = "STFCF6M")
    @Basic
    public int getStfcf6M() {
        return stfcf6M;
    }

    public void setStfcf6M(int stfcf6M) {
        this.stfcf6M = stfcf6M;
    }

    private int stfcf7M;

    @javax.persistence.Column(name = "STFCF7M")
    @Basic
    public int getStfcf7M() {
        return stfcf7M;
    }

    public void setStfcf7M(int stfcf7M) {
        this.stfcf7M = stfcf7M;
    }

    private int stfcf8M;

    @javax.persistence.Column(name = "STFCF8M")
    @Basic
    public int getStfcf8M() {
        return stfcf8M;
    }

    public void setStfcf8M(int stfcf8M) {
        this.stfcf8M = stfcf8M;
    }

    private int stfcf9M;

    @javax.persistence.Column(name = "STFCF9M")
    @Basic
    public int getStfcf9M() {
        return stfcf9M;
    }

    public void setStfcf9M(int stfcf9M) {
        this.stfcf9M = stfcf9M;
    }

    private int stfcf10M;

    @javax.persistence.Column(name = "STFCF10M")
    @Basic
    public int getStfcf10M() {
        return stfcf10M;
    }

    public void setStfcf10M(int stfcf10M) {
        this.stfcf10M = stfcf10M;
    }

    private int stfcf11M;

    @javax.persistence.Column(name = "STFCF11M")
    @Basic
    public int getStfcf11M() {
        return stfcf11M;
    }

    public void setStfcf11M(int stfcf11M) {
        this.stfcf11M = stfcf11M;
    }

    private int stfcf12M;

    @javax.persistence.Column(name = "STFCF12M")
    @Basic
    public int getStfcf12M() {
        return stfcf12M;
    }

    public void setStfcf12M(int stfcf12M) {
        this.stfcf12M = stfcf12M;
    }

    private int adjefc;

    @javax.persistence.Column(name = "ADJEFC")
    @Basic
    public int getAdjefc() {
        return adjefc;
    }

    public void setAdjefc(int adjefc) {
        this.adjefc = adjefc;
    }

    private String rqadefc;

    @javax.persistence.Column(name = "RQADEFC")
    @Basic
    public String getRqadefc() {
        return rqadefc;
    }

    public void setRqadefc(String rqadefc) {
        this.rqadefc = rqadefc;
    }

    private String rqadefc2;

    @javax.persistence.Column(name = "RQADEFC2")
    @Basic
    public String getRqadefc2() {
        return rqadefc2;
    }

    public void setRqadefc2(String rqadefc2) {
        this.rqadefc2 = rqadefc2;
    }

    private String ascitzn;

    @javax.persistence.Column(name = "ASCITZN")
    @Basic
    public String getAscitzn() {
        return ascitzn;
    }

    public void setAscitzn(String ascitzn) {
        this.ascitzn = ascitzn;
    }

    private String asmartl;

    @javax.persistence.Column(name = "ASMARTL")
    @Basic
    public String getAsmartl() {
        return asmartl;
    }

    public void setAsmartl(String asmartl) {
        this.asmartl = asmartl;
    }

    private String asmarsts;

    @javax.persistence.Column(name = "ASMARSTS")
    @Basic
    public String getAsmarsts() {
        return asmarsts;
    }

    public void setAsmarsts(String asmarsts) {
        this.asmarsts = asmarsts;
    }

    private String asborn0;

    @javax.persistence.Column(name = "ASBORN0")
    @Basic
    public String getAsborn0() {
        return asborn0;
    }

    public void setAsborn0(String asborn0) {
        this.asborn0 = asborn0;
    }

    private BigInteger asszhhd;

    @javax.persistence.Column(name = "ASSZHHD")
    @Basic
    public BigInteger getAsszhhd() {
        return asszhhd;
    }

    public void setAsszhhd(BigInteger asszhhd) {
        this.asszhhd = asszhhd;
    }

    private BigInteger asnrps;

    @javax.persistence.Column(name = "ASNRPS")
    @Basic
    public BigInteger getAsnrps() {
        return asnrps;
    }

    public void setAsnrps(BigInteger asnrps) {
        this.asnrps = asnrps;
    }

    private String cstrfil;

    @javax.persistence.Column(name = "CSTRFIL")
    @Basic
    public String getCstrfil() {
        return cstrfil;
    }

    public void setCstrfil(String cstrfil) {
        this.cstrfil = cstrfil;
    }

    private String csdtrflr;

    @javax.persistence.Column(name = "CSDTRFLR")
    @Basic
    public String getCsdtrflr() {
        return csdtrflr;
    }

    public void setCsdtrflr(String csdtrflr) {
        this.csdtrflr = csdtrflr;
    }

    private int asaagi;

    @javax.persistence.Column(name = "ASAAGI")
    @Basic
    public int getAsaagi() {
        return asaagi;
    }

    public void setAsaagi(int asaagi) {
        this.asaagi = asaagi;
    }

    private String asaitx;

    @javax.persistence.Column(name = "ASAITX")
    @Basic
    public String getAsaitx() {
        return asaitx;
    }

    public void setAsaitx(String asaitx) {
        this.asaitx = asaitx;
    }

    private String asditx;

    @javax.persistence.Column(name = "ASDITX")
    @Basic
    public String getAsditx() {
        return asditx;
    }

    public void setAsditx(String asditx) {
        this.asditx = asditx;
    }

    private int asawag;

    @javax.persistence.Column(name = "ASAWAG")
    @Basic
    public int getAsawag() {
        return asawag;
    }

    public void setAsawag(int asawag) {
        this.asawag = asawag;
    }

    private int asaspsw;

    @javax.persistence.Column(name = "ASASPSW")
    @Basic
    public int getAsaspsw() {
        return asaspsw;
    }

    public void setAsaspsw(int asaspsw) {
        this.asaspsw = asaspsw;
    }

    private String asass;

    @javax.persistence.Column(name = "ASASS")
    @Basic
    public String getAsass() {
        return asass;
    }

    public void setAsass(String asass) {
        this.asass = asass;
    }

    private String asaadc;

    @javax.persistence.Column(name = "ASAADC")
    @Basic
    public String getAsaadc() {
        return asaadc;
    }

    public void setAsaadc(String asaadc) {
        this.asaadc = asaadc;
    }

    private String asacs;

    @javax.persistence.Column(name = "ASACS")
    @Basic
    public String getAsacs() {
        return asacs;
    }

    public void setAsacs(String asacs) {
        this.asacs = asacs;
    }

    private String asdwag;

    @javax.persistence.Column(name = "ASDWAG")
    @Basic
    public String getAsdwag() {
        return asdwag;
    }

    public void setAsdwag(String asdwag) {
        this.asdwag = asdwag;
    }

    private int asdspsw;

    @javax.persistence.Column(name = "ASDSPSW")
    @Basic
    public int getAsdspsw() {
        return asdspsw;
    }

    public void setAsdspsw(int asdspsw) {
        this.asdspsw = asdspsw;
    }

    private String asoriv;

    @javax.persistence.Column(name = "ASORIV")
    @Basic
    public String getAsoriv() {
        return asoriv;
    }

    public void setAsoriv(String asoriv) {
        this.asoriv = asoriv;
    }

    private String asorid;

    @javax.persistence.Column(name = "ASORID")
    @Basic
    public String getAsorid() {
        return asorid;
    }

    public void setAsorid(String asorid) {
        this.asorid = asorid;
    }

    private String asbfv;

    @javax.persistence.Column(name = "ASBFV")
    @Basic
    public String getAsbfv() {
        return asbfv;
    }

    public void setAsbfv(String asbfv) {
        this.asbfv = asbfv;
    }

    private String asbfd;

    @javax.persistence.Column(name = "ASBFD")
    @Basic
    public String getAsbfd() {
        return asbfd;
    }

    public void setAsbfd(String asbfd) {
        this.asbfd = asbfd;
    }

    private String asfarmv;

    @javax.persistence.Column(name = "ASFARMV")
    @Basic
    public String getAsfarmv() {
        return asfarmv;
    }

    public void setAsfarmv(String asfarmv) {
        this.asfarmv = asfarmv;
    }

    private String asfarmd;

    @javax.persistence.Column(name = "ASFARMD")
    @Basic
    public String getAsfarmd() {
        return asfarmd;
    }

    public void setAsfarmd(String asfarmd) {
        this.asfarmd = asfarmd;
    }

    private String asfarm;

    @javax.persistence.Column(name = "ASFARM")
    @Basic
    public String getAsfarm() {
        return asfarm;
    }

    public void setAsfarm(String asfarm) {
        this.asfarm = asfarm;
    }

    private String aunpdstf;

    @javax.persistence.Column(name = "AUNPDSTF")
    @Basic
    public String getAunpdstf() {
        return aunpdstf;
    }

    public void setAunpdstf(String aunpdstf) {
        this.aunpdstf = aunpdstf;
    }

    private String astotstf;

    @javax.persistence.Column(name = "ASTOTSTF")
    @Basic
    public String getAstotstf() {
        return astotstf;
    }

    public void setAstotstf(String astotstf) {
        this.astotstf = astotstf;
    }

    private String apmartl;

    @javax.persistence.Column(name = "APMARTL")
    @Basic
    public String getApmartl() {
        return apmartl;
    }

    public void setApmartl(String apmartl) {
        this.apmartl = apmartl;
    }

    private BigInteger apszhhd;

    @javax.persistence.Column(name = "APSZHHD")
    @Basic
    public BigInteger getApszhhd() {
        return apszhhd;
    }

    public void setApszhhd(BigInteger apszhhd) {
        this.apszhhd = apszhhd;
    }

    private BigInteger apnrps;

    @javax.persistence.Column(name = "APNRPS")
    @Basic
    public BigInteger getApnrps() {
        return apnrps;
    }

    public void setApnrps(BigInteger apnrps) {
        this.apnrps = apnrps;
    }

    private String aptrfil;

    @javax.persistence.Column(name = "APTRFIL")
    @Basic
    public String getAptrfil() {
        return aptrfil;
    }

    public void setAptrfil(String aptrfil) {
        this.aptrfil = aptrfil;
    }

    private String apbtrfil;

    @javax.persistence.Column(name = "APBTRFIL")
    @Basic
    public String getApbtrfil() {
        return apbtrfil;
    }

    public void setApbtrfil(String apbtrfil) {
        this.apbtrfil = apbtrfil;
    }

    private int apagi;

    @javax.persistence.Column(name = "APAGI")
    @Basic
    public int getApagi() {
        return apagi;
    }

    public void setApagi(int apagi) {
        this.apagi = apagi;
    }

    private String apitx;

    @javax.persistence.Column(name = "APITX")
    @Basic
    public String getApitx() {
        return apitx;
    }

    public void setApitx(String apitx) {
        this.apitx = apitx;
    }

    private String apbitx;

    @javax.persistence.Column(name = "APBITX")
    @Basic
    public String getApbitx() {
        return apbitx;
    }

    public void setApbitx(String apbitx) {
        this.apbitx = apbitx;
    }

    private int apfwag;

    @javax.persistence.Column(name = "APFWAG")
    @Basic
    public int getApfwag() {
        return apfwag;
    }

    public void setApfwag(int apfwag) {
        this.apfwag = apfwag;
    }

    private int apmwag;

    @javax.persistence.Column(name = "APMWAG")
    @Basic
    public int getApmwag() {
        return apmwag;
    }

    public void setApmwag(int apmwag) {
        this.apmwag = apmwag;
    }

    private String apfarm;

    @javax.persistence.Column(name = "APFARM")
    @Basic
    public String getApfarm() {
        return apfarm;
    }

    public void setApfarm(String apfarm) {
        this.apfarm = apfarm;
    }

    private String aditx;

    @javax.persistence.Column(name = "ADITX")
    @Basic
    public String getAditx() {
        return aditx;
    }

    public void setAditx(String aditx) {
        this.aditx = aditx;
    }

    private String coment;

    @javax.persistence.Column(name = "COMENT")
    @Basic
    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    private String agency;

    @javax.persistence.Column(name = "AGENCY")
    @Basic
    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    private String apbfwag;

    @javax.persistence.Column(name = "APBFWAG")
    @Basic
    public String getApbfwag() {
        return apbfwag;
    }

    public void setApbfwag(String apbfwag) {
        this.apbfwag = apbfwag;
    }

    private int apbmwag;

    @javax.persistence.Column(name = "APBMWAG")
    @Basic
    public int getApbmwag() {
        return apbmwag;
    }

    public void setApbmwag(int apbmwag) {
        this.apbmwag = apbmwag;
    }

    private int adjefc2;

    @javax.persistence.Column(name = "ADJEFC2")
    @Basic
    public int getAdjefc2() {
        return adjefc2;
    }

    public void setAdjefc2(int adjefc2) {
        this.adjefc2 = adjefc2;
    }

    private int offpc;

    @javax.persistence.Column(name = "OFFPC")
    @Basic
    public int getOffpc() {
        return offpc;
    }

    public void setOffpc(int offpc) {
        this.offpc = offpc;
    }

    private int offsc;

    @javax.persistence.Column(name = "OFFSC")
    @Basic
    public int getOffsc() {
        return offsc;
    }

    public void setOffsc(int offsc) {
        this.offsc = offsc;
    }

    private int indpc;

    @javax.persistence.Column(name = "INDPC")
    @Basic
    public int getIndpc() {
        return indpc;
    }

    public void setIndpc(int indpc) {
        this.indpc = indpc;
    }

    private String sdupesar;

    @javax.persistence.Column(name = "SDUPESAR")
    @Basic
    public String getSdupesar() {
        return sdupesar;
    }

    public void setSdupesar(String sdupesar) {
        this.sdupesar = sdupesar;
    }

    private int exexcld;

    @javax.persistence.Column(name = "EXEXCLD")
    @Basic
    public int getExexcld() {
        return exexcld;
    }

    public void setExexcld(int exexcld) {
        this.exexcld = exexcld;
    }

    private int exexcld2;

    @javax.persistence.Column(name = "EXEXCLD2")
    @Basic
    public int getExexcld2() {
        return exexcld2;
    }

    public void setExexcld2(int exexcld2) {
        this.exexcld2 = exexcld2;
    }

    private int aexexc;

    @javax.persistence.Column(name = "AEXEXC")
    @Basic
    public int getAexexc() {
        return aexexc;
    }

    public void setAexexc(int aexexc) {
        this.aexexc = aexexc;
    }

    private int aexexc2;

    @javax.persistence.Column(name = "AEXEXC2")
    @Basic
    public int getAexexc2() {
        return aexexc2;
    }

    public void setAexexc2(int aexexc2) {
        this.aexexc2 = aexexc2;
    }

    private int efcsti;

    @javax.persistence.Column(name = "EFCSTI")
    @Basic
    public int getEfcsti() {
        return efcsti;
    }

    public void setEfcsti(int efcsti) {
        this.efcsti = efcsti;
    }

    private int efcsti2;

    @javax.persistence.Column(name = "EFCSTI2")
    @Basic
    public int getEfcsti2() {
        return efcsti2;
    }

    public void setEfcsti2(int efcsti2) {
        this.efcsti2 = efcsti2;
    }

    private String indpcs;

    @javax.persistence.Column(name = "INDPCS")
    @Basic
    public String getIndpcs() {
        return indpcs;
    }

    public void setIndpcs(String indpcs) {
        this.indpcs = indpcs;
    }

    private int shcredt;

    @javax.persistence.Column(name = "SHCREDT")
    @Basic
    public int getShcredt() {
        return shcredt;
    }

    public void setShcredt(int shcredt) {
        this.shcredt = shcredt;
    }

    private int keogh;

    @javax.persistence.Column(name = "KEOGH")
    @Basic
    public int getKeogh() {
        return keogh;
    }

    public void setKeogh(int keogh) {
        this.keogh = keogh;
    }

    private String stateso;

    @javax.persistence.Column(name = "STATESO")
    @Basic
    public String getStateso() {
        return stateso;
    }

    public void setStateso(String stateso) {
        this.stateso = stateso;
    }

    private String stated;

    @javax.persistence.Column(name = "STATED")
    @Basic
    public String getStated() {
        return stated;
    }

    public void setStated(String stated) {
        this.stated = stated;
    }

    private String createc;

    @javax.persistence.Column(name = "CREATEC")
    @Basic
    public String getCreatec() {
        return createc;
    }

    public void setCreatec(String createc) {
        this.createc = createc;
    }

    private String revdtc;

    @javax.persistence.Column(name = "REVDTC")
    @Basic
    public String getRevdtc() {
        return revdtc;
    }

    public void setRevdtc(String revdtc) {
        this.revdtc = revdtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snb3Entity that = (Snb3Entity) o;

        if (adjefc != that.adjefc) return false;
        if (adjefc2 != that.adjefc2) return false;
        if (aexexc != that.aexexc) return false;
        if (aexexc2 != that.aexexc2) return false;
        if (apagi != that.apagi) return false;
        if (apbmwag != that.apbmwag) return false;
        if (apfwag != that.apfwag) return false;
        if (apmwag != that.apmwag) return false;
        if (asaagi != that.asaagi) return false;
        if (asaspsw != that.asaspsw) return false;
        if (asawag != that.asawag) return false;
        if (asdspsw != that.asdspsw) return false;
        if (efcsti != that.efcsti) return false;
        if (efcsti2 != that.efcsti2) return false;
        if (exexcld != that.exexcld) return false;
        if (exexcld2 != that.exexcld2) return false;
        if (indpc != that.indpc) return false;
        if (keogh != that.keogh) return false;
        if (offpc != that.offpc) return false;
        if (offsc != that.offsc) return false;
        if (ossai != that.ossai) return false;
        if (phcredt != that.phcredt) return false;
        if (ptdpens != that.ptdpens) return false;
        if (ptfcf10M != that.ptfcf10M) return false;
        if (ptfcf11M != that.ptfcf11M) return false;
        if (ptfcf12M != that.ptfcf12M) return false;
        if (ptfcf1M != that.ptfcf1M) return false;
        if (ptfcf2M != that.ptfcf2M) return false;
        if (ptfcf3M != that.ptfcf3M) return false;
        if (ptfcf4M != that.ptfcf4M) return false;
        if (ptfcf5M != that.ptfcf5M) return false;
        if (ptfcf6M != that.ptfcf6M) return false;
        if (ptfcf7M != that.ptfcf7M) return false;
        if (ptfcf8M != that.ptfcf8M) return false;
        if (ptfcf9M != that.ptfcf9M) return false;
        if (shcredt != that.shcredt) return false;
        if (spclpefc != that.spclpefc) return false;
        if (spclsefc != that.spclsefc) return false;
        if (stfcf10M != that.stfcf10M) return false;
        if (stfcf11M != that.stfcf11M) return false;
        if (stfcf12M != that.stfcf12M) return false;
        if (stfcf1M != that.stfcf1M) return false;
        if (stfcf2M != that.stfcf2M) return false;
        if (stfcf3M != that.stfcf3M) return false;
        if (stfcf4M != that.stfcf4M) return false;
        if (stfcf5M != that.stfcf5M) return false;
        if (stfcf6M != that.stfcf6M) return false;
        if (stfcf7M != that.stfcf7M) return false;
        if (stfcf8M != that.stfcf8M) return false;
        if (stfcf9M != that.stfcf9M) return false;
        if (aditx != null ? !aditx.equals(that.aditx) : that.aditx != null) return false;
        if (agency != null ? !agency.equals(that.agency) : that.agency != null) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (apbfwag != null ? !apbfwag.equals(that.apbfwag) : that.apbfwag != null) return false;
        if (apbitx != null ? !apbitx.equals(that.apbitx) : that.apbitx != null) return false;
        if (apbtrfil != null ? !apbtrfil.equals(that.apbtrfil) : that.apbtrfil != null) return false;
        if (apfarm != null ? !apfarm.equals(that.apfarm) : that.apfarm != null) return false;
        if (apitx != null ? !apitx.equals(that.apitx) : that.apitx != null) return false;
        if (apmartl != null ? !apmartl.equals(that.apmartl) : that.apmartl != null) return false;
        if (apnrps != null ? !apnrps.equals(that.apnrps) : that.apnrps != null) return false;
        if (apszhhd != null ? !apszhhd.equals(that.apszhhd) : that.apszhhd != null) return false;
        if (aptrfil != null ? !aptrfil.equals(that.aptrfil) : that.aptrfil != null) return false;
        if (asaadc != null ? !asaadc.equals(that.asaadc) : that.asaadc != null) return false;
        if (asacs != null ? !asacs.equals(that.asacs) : that.asacs != null) return false;
        if (asaitx != null ? !asaitx.equals(that.asaitx) : that.asaitx != null) return false;
        if (asass != null ? !asass.equals(that.asass) : that.asass != null) return false;
        if (asbfd != null ? !asbfd.equals(that.asbfd) : that.asbfd != null) return false;
        if (asbfv != null ? !asbfv.equals(that.asbfv) : that.asbfv != null) return false;
        if (asborn0 != null ? !asborn0.equals(that.asborn0) : that.asborn0 != null) return false;
        if (ascitzn != null ? !ascitzn.equals(that.ascitzn) : that.ascitzn != null) return false;
        if (asditx != null ? !asditx.equals(that.asditx) : that.asditx != null) return false;
        if (asdwag != null ? !asdwag.equals(that.asdwag) : that.asdwag != null) return false;
        if (asfarm != null ? !asfarm.equals(that.asfarm) : that.asfarm != null) return false;
        if (asfarmd != null ? !asfarmd.equals(that.asfarmd) : that.asfarmd != null) return false;
        if (asfarmv != null ? !asfarmv.equals(that.asfarmv) : that.asfarmv != null) return false;
        if (asmarsts != null ? !asmarsts.equals(that.asmarsts) : that.asmarsts != null) return false;
        if (asmartl != null ? !asmartl.equals(that.asmartl) : that.asmartl != null) return false;
        if (asmovr1 != null ? !asmovr1.equals(that.asmovr1) : that.asmovr1 != null) return false;
        if (asmovr2 != null ? !asmovr2.equals(that.asmovr2) : that.asmovr2 != null) return false;
        if (asmovr3 != null ? !asmovr3.equals(that.asmovr3) : that.asmovr3 != null) return false;
        if (asmovr4 != null ? !asmovr4.equals(that.asmovr4) : that.asmovr4 != null) return false;
        if (asmovr5 != null ? !asmovr5.equals(that.asmovr5) : that.asmovr5 != null) return false;
        if (asmovr6 != null ? !asmovr6.equals(that.asmovr6) : that.asmovr6 != null) return false;
        if (asmovr7 != null ? !asmovr7.equals(that.asmovr7) : that.asmovr7 != null) return false;
        if (asmovr8 != null ? !asmovr8.equals(that.asmovr8) : that.asmovr8 != null) return false;
        if (asmovr9 != null ? !asmovr9.equals(that.asmovr9) : that.asmovr9 != null) return false;
        if (asnrps != null ? !asnrps.equals(that.asnrps) : that.asnrps != null) return false;
        if (asorid != null ? !asorid.equals(that.asorid) : that.asorid != null) return false;
        if (asoriv != null ? !asoriv.equals(that.asoriv) : that.asoriv != null) return false;
        if (asszhhd != null ? !asszhhd.equals(that.asszhhd) : that.asszhhd != null) return false;
        if (astotstf != null ? !astotstf.equals(that.astotstf) : that.astotstf != null) return false;
        if (aunpdstf != null ? !aunpdstf.equals(that.aunpdstf) : that.aunpdstf != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (coment != null ? !coment.equals(that.coment) : that.coment != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (csdtrflr != null ? !csdtrflr.equals(that.csdtrflr) : that.csdtrflr != null) return false;
        if (cstrfil != null ? !cstrfil.equals(that.cstrfil) : that.cstrfil != null) return false;
        if (depover != null ? !depover.equals(that.depover) : that.depover != null) return false;
        if (indpcs != null ? !indpcs.equals(that.indpcs) : that.indpcs != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (pgitype != null ? !pgitype.equals(that.pgitype) : that.pgitype != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (rqadefc != null ? !rqadefc.equals(that.rqadefc) : that.rqadefc != null) return false;
        if (rqadefc2 != null ? !rqadefc2.equals(that.rqadefc2) : that.rqadefc2 != null) return false;
        if (rr01 != null ? !rr01.equals(that.rr01) : that.rr01 != null) return false;
        if (rr02 != null ? !rr02.equals(that.rr02) : that.rr02 != null) return false;
        if (rr03 != null ? !rr03.equals(that.rr03) : that.rr03 != null) return false;
        if (rr04 != null ? !rr04.equals(that.rr04) : that.rr04 != null) return false;
        if (rr05 != null ? !rr05.equals(that.rr05) : that.rr05 != null) return false;
        if (rr06 != null ? !rr06.equals(that.rr06) : that.rr06 != null) return false;
        if (rr07 != null ? !rr07.equals(that.rr07) : that.rr07 != null) return false;
        if (rr08 != null ? !rr08.equals(that.rr08) : that.rr08 != null) return false;
        if (rr09 != null ? !rr09.equals(that.rr09) : that.rr09 != null) return false;
        if (rr10 != null ? !rr10.equals(that.rr10) : that.rr10 != null) return false;
        if (rr11 != null ? !rr11.equals(that.rr11) : that.rr11 != null) return false;
        if (rr12 != null ? !rr12.equals(that.rr12) : that.rr12 != null) return false;
        if (rr13 != null ? !rr13.equals(that.rr13) : that.rr13 != null) return false;
        if (rr14 != null ? !rr14.equals(that.rr14) : that.rr14 != null) return false;
        if (rr15 != null ? !rr15.equals(that.rr15) : that.rr15 != null) return false;
        if (rr16 != null ? !rr16.equals(that.rr16) : that.rr16 != null) return false;
        if (rr17 != null ? !rr17.equals(that.rr17) : that.rr17 != null) return false;
        if (rr18 != null ? !rr18.equals(that.rr18) : that.rr18 != null) return false;
        if (rr19 != null ? !rr19.equals(that.rr19) : that.rr19 != null) return false;
        if (rr20 != null ? !rr20.equals(that.rr20) : that.rr20 != null) return false;
        if (rr21 != null ? !rr21.equals(that.rr21) : that.rr21 != null) return false;
        if (rr22 != null ? !rr22.equals(that.rr22) : that.rr22 != null) return false;
        if (rr23 != null ? !rr23.equals(that.rr23) : that.rr23 != null) return false;
        if (rr24 != null ? !rr24.equals(that.rr24) : that.rr24 != null) return false;
        if (rr25 != null ? !rr25.equals(that.rr25) : that.rr25 != null) return false;
        if (rr26 != null ? !rr26.equals(that.rr26) : that.rr26 != null) return false;
        if (rr27 != null ? !rr27.equals(that.rr27) : that.rr27 != null) return false;
        if (rr28 != null ? !rr28.equals(that.rr28) : that.rr28 != null) return false;
        if (rr29 != null ? !rr29.equals(that.rr29) : that.rr29 != null) return false;
        if (rr30 != null ? !rr30.equals(that.rr30) : that.rr30 != null) return false;
        if (rr31 != null ? !rr31.equals(that.rr31) : that.rr31 != null) return false;
        if (rr32 != null ? !rr32.equals(that.rr32) : that.rr32 != null) return false;
        if (rr33 != null ? !rr33.equals(that.rr33) : that.rr33 != null) return false;
        if (rr34 != null ? !rr34.equals(that.rr34) : that.rr34 != null) return false;
        if (rr35 != null ? !rr35.equals(that.rr35) : that.rr35 != null) return false;
        if (rr36 != null ? !rr36.equals(that.rr36) : that.rr36 != null) return false;
        if (rr37 != null ? !rr37.equals(that.rr37) : that.rr37 != null) return false;
        if (rr38 != null ? !rr38.equals(that.rr38) : that.rr38 != null) return false;
        if (rr39 != null ? !rr39.equals(that.rr39) : that.rr39 != null) return false;
        if (rr40 != null ? !rr40.equals(that.rr40) : that.rr40 != null) return false;
        if (rr41 != null ? !rr41.equals(that.rr41) : that.rr41 != null) return false;
        if (rr42 != null ? !rr42.equals(that.rr42) : that.rr42 != null) return false;
        if (rr43 != null ? !rr43.equals(that.rr43) : that.rr43 != null) return false;
        if (rr44 != null ? !rr44.equals(that.rr44) : that.rr44 != null) return false;
        if (rr45 != null ? !rr45.equals(that.rr45) : that.rr45 != null) return false;
        if (rr46 != null ? !rr46.equals(that.rr46) : that.rr46 != null) return false;
        if (rr47 != null ? !rr47.equals(that.rr47) : that.rr47 != null) return false;
        if (rr48 != null ? !rr48.equals(that.rr48) : that.rr48 != null) return false;
        if (rrovera != null ? !rrovera.equals(that.rrovera) : that.rrovera != null) return false;
        if (rroverb != null ? !rroverb.equals(that.rroverb) : that.rroverb != null) return false;
        if (rroverd != null ? !rroverd.equals(that.rroverd) : that.rroverd != null) return false;
        if (rroverg != null ? !rroverg.equals(that.rroverg) : that.rroverg != null) return false;
        if (rrovern != null ? !rrovern.equals(that.rrovern) : that.rrovern != null) return false;
        if (rroveru != null ? !rroveru.equals(that.rroveru) : that.rroveru != null) return false;
        if (rroverw != null ? !rroverw.equals(that.rroverw) : that.rroverw != null) return false;
        if (sdupesar != null ? !sdupesar.equals(that.sdupesar) : that.sdupesar != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snbkey != null ? !snbkey.equals(that.snbkey) : that.snbkey != null) return false;
        if (spclcond != null ? !spclcond.equals(that.spclcond) : that.spclcond != null) return false;
        if (stated != null ? !stated.equals(that.stated) : that.stated != null) return false;
        if (stateso != null ? !stateso.equals(that.stateso) : that.stateso != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snbkey != null ? snbkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cmptype != null ? cmptype.hashCode() : 0);
        result = 31 * result + (versnr != null ? versnr.hashCode() : 0);
        result = 31 * result + (rr01 != null ? rr01.hashCode() : 0);
        result = 31 * result + (rr02 != null ? rr02.hashCode() : 0);
        result = 31 * result + (rr03 != null ? rr03.hashCode() : 0);
        result = 31 * result + (rr04 != null ? rr04.hashCode() : 0);
        result = 31 * result + (rr05 != null ? rr05.hashCode() : 0);
        result = 31 * result + (rr06 != null ? rr06.hashCode() : 0);
        result = 31 * result + (rr07 != null ? rr07.hashCode() : 0);
        result = 31 * result + (rr08 != null ? rr08.hashCode() : 0);
        result = 31 * result + (rr09 != null ? rr09.hashCode() : 0);
        result = 31 * result + (rr10 != null ? rr10.hashCode() : 0);
        result = 31 * result + (rr11 != null ? rr11.hashCode() : 0);
        result = 31 * result + (rr12 != null ? rr12.hashCode() : 0);
        result = 31 * result + (rr13 != null ? rr13.hashCode() : 0);
        result = 31 * result + (rr14 != null ? rr14.hashCode() : 0);
        result = 31 * result + (rr15 != null ? rr15.hashCode() : 0);
        result = 31 * result + (rr16 != null ? rr16.hashCode() : 0);
        result = 31 * result + (rr17 != null ? rr17.hashCode() : 0);
        result = 31 * result + (rr18 != null ? rr18.hashCode() : 0);
        result = 31 * result + (rr19 != null ? rr19.hashCode() : 0);
        result = 31 * result + (rr20 != null ? rr20.hashCode() : 0);
        result = 31 * result + (rr21 != null ? rr21.hashCode() : 0);
        result = 31 * result + (rr22 != null ? rr22.hashCode() : 0);
        result = 31 * result + (rr23 != null ? rr23.hashCode() : 0);
        result = 31 * result + (rr24 != null ? rr24.hashCode() : 0);
        result = 31 * result + (rr25 != null ? rr25.hashCode() : 0);
        result = 31 * result + (rr26 != null ? rr26.hashCode() : 0);
        result = 31 * result + (rr27 != null ? rr27.hashCode() : 0);
        result = 31 * result + (rr28 != null ? rr28.hashCode() : 0);
        result = 31 * result + (rr29 != null ? rr29.hashCode() : 0);
        result = 31 * result + (rr30 != null ? rr30.hashCode() : 0);
        result = 31 * result + (rr31 != null ? rr31.hashCode() : 0);
        result = 31 * result + (rr32 != null ? rr32.hashCode() : 0);
        result = 31 * result + (rr33 != null ? rr33.hashCode() : 0);
        result = 31 * result + (rr34 != null ? rr34.hashCode() : 0);
        result = 31 * result + (rr35 != null ? rr35.hashCode() : 0);
        result = 31 * result + (rr36 != null ? rr36.hashCode() : 0);
        result = 31 * result + (rr37 != null ? rr37.hashCode() : 0);
        result = 31 * result + (rr38 != null ? rr38.hashCode() : 0);
        result = 31 * result + (rr39 != null ? rr39.hashCode() : 0);
        result = 31 * result + (rr40 != null ? rr40.hashCode() : 0);
        result = 31 * result + (rr41 != null ? rr41.hashCode() : 0);
        result = 31 * result + (rr42 != null ? rr42.hashCode() : 0);
        result = 31 * result + (rr43 != null ? rr43.hashCode() : 0);
        result = 31 * result + (rr44 != null ? rr44.hashCode() : 0);
        result = 31 * result + (rr45 != null ? rr45.hashCode() : 0);
        result = 31 * result + (rr46 != null ? rr46.hashCode() : 0);
        result = 31 * result + (rr47 != null ? rr47.hashCode() : 0);
        result = 31 * result + (rr48 != null ? rr48.hashCode() : 0);
        result = 31 * result + (rrovera != null ? rrovera.hashCode() : 0);
        result = 31 * result + (rroverb != null ? rroverb.hashCode() : 0);
        result = 31 * result + (rroverd != null ? rroverd.hashCode() : 0);
        result = 31 * result + (rroverg != null ? rroverg.hashCode() : 0);
        result = 31 * result + (rrovern != null ? rrovern.hashCode() : 0);
        result = 31 * result + (rroveru != null ? rroveru.hashCode() : 0);
        result = 31 * result + (rroverw != null ? rroverw.hashCode() : 0);
        result = 31 * result + phcredt;
        result = 31 * result + (asmovr1 != null ? asmovr1.hashCode() : 0);
        result = 31 * result + (asmovr2 != null ? asmovr2.hashCode() : 0);
        result = 31 * result + (asmovr3 != null ? asmovr3.hashCode() : 0);
        result = 31 * result + (asmovr4 != null ? asmovr4.hashCode() : 0);
        result = 31 * result + (asmovr5 != null ? asmovr5.hashCode() : 0);
        result = 31 * result + (asmovr6 != null ? asmovr6.hashCode() : 0);
        result = 31 * result + (asmovr7 != null ? asmovr7.hashCode() : 0);
        result = 31 * result + (asmovr8 != null ? asmovr8.hashCode() : 0);
        result = 31 * result + (asmovr9 != null ? asmovr9.hashCode() : 0);
        result = 31 * result + ptdpens;
        result = 31 * result + (spclcond != null ? spclcond.hashCode() : 0);
        result = 31 * result + spclpefc;
        result = 31 * result + spclsefc;
        result = 31 * result + (depover != null ? depover.hashCode() : 0);
        result = 31 * result + (pgitype != null ? pgitype.hashCode() : 0);
        result = 31 * result + ossai;
        result = 31 * result + ptfcf1M;
        result = 31 * result + ptfcf2M;
        result = 31 * result + ptfcf3M;
        result = 31 * result + ptfcf4M;
        result = 31 * result + ptfcf5M;
        result = 31 * result + ptfcf6M;
        result = 31 * result + ptfcf7M;
        result = 31 * result + ptfcf8M;
        result = 31 * result + ptfcf9M;
        result = 31 * result + ptfcf10M;
        result = 31 * result + ptfcf11M;
        result = 31 * result + ptfcf12M;
        result = 31 * result + stfcf1M;
        result = 31 * result + stfcf2M;
        result = 31 * result + stfcf3M;
        result = 31 * result + stfcf4M;
        result = 31 * result + stfcf5M;
        result = 31 * result + stfcf6M;
        result = 31 * result + stfcf7M;
        result = 31 * result + stfcf8M;
        result = 31 * result + stfcf9M;
        result = 31 * result + stfcf10M;
        result = 31 * result + stfcf11M;
        result = 31 * result + stfcf12M;
        result = 31 * result + adjefc;
        result = 31 * result + (rqadefc != null ? rqadefc.hashCode() : 0);
        result = 31 * result + (rqadefc2 != null ? rqadefc2.hashCode() : 0);
        result = 31 * result + (ascitzn != null ? ascitzn.hashCode() : 0);
        result = 31 * result + (asmartl != null ? asmartl.hashCode() : 0);
        result = 31 * result + (asmarsts != null ? asmarsts.hashCode() : 0);
        result = 31 * result + (asborn0 != null ? asborn0.hashCode() : 0);
        result = 31 * result + (asszhhd != null ? asszhhd.hashCode() : 0);
        result = 31 * result + (asnrps != null ? asnrps.hashCode() : 0);
        result = 31 * result + (cstrfil != null ? cstrfil.hashCode() : 0);
        result = 31 * result + (csdtrflr != null ? csdtrflr.hashCode() : 0);
        result = 31 * result + asaagi;
        result = 31 * result + (asaitx != null ? asaitx.hashCode() : 0);
        result = 31 * result + (asditx != null ? asditx.hashCode() : 0);
        result = 31 * result + asawag;
        result = 31 * result + asaspsw;
        result = 31 * result + (asass != null ? asass.hashCode() : 0);
        result = 31 * result + (asaadc != null ? asaadc.hashCode() : 0);
        result = 31 * result + (asacs != null ? asacs.hashCode() : 0);
        result = 31 * result + (asdwag != null ? asdwag.hashCode() : 0);
        result = 31 * result + asdspsw;
        result = 31 * result + (asoriv != null ? asoriv.hashCode() : 0);
        result = 31 * result + (asorid != null ? asorid.hashCode() : 0);
        result = 31 * result + (asbfv != null ? asbfv.hashCode() : 0);
        result = 31 * result + (asbfd != null ? asbfd.hashCode() : 0);
        result = 31 * result + (asfarmv != null ? asfarmv.hashCode() : 0);
        result = 31 * result + (asfarmd != null ? asfarmd.hashCode() : 0);
        result = 31 * result + (asfarm != null ? asfarm.hashCode() : 0);
        result = 31 * result + (aunpdstf != null ? aunpdstf.hashCode() : 0);
        result = 31 * result + (astotstf != null ? astotstf.hashCode() : 0);
        result = 31 * result + (apmartl != null ? apmartl.hashCode() : 0);
        result = 31 * result + (apszhhd != null ? apszhhd.hashCode() : 0);
        result = 31 * result + (apnrps != null ? apnrps.hashCode() : 0);
        result = 31 * result + (aptrfil != null ? aptrfil.hashCode() : 0);
        result = 31 * result + (apbtrfil != null ? apbtrfil.hashCode() : 0);
        result = 31 * result + apagi;
        result = 31 * result + (apitx != null ? apitx.hashCode() : 0);
        result = 31 * result + (apbitx != null ? apbitx.hashCode() : 0);
        result = 31 * result + apfwag;
        result = 31 * result + apmwag;
        result = 31 * result + (apfarm != null ? apfarm.hashCode() : 0);
        result = 31 * result + (aditx != null ? aditx.hashCode() : 0);
        result = 31 * result + (coment != null ? coment.hashCode() : 0);
        result = 31 * result + (agency != null ? agency.hashCode() : 0);
        result = 31 * result + (apbfwag != null ? apbfwag.hashCode() : 0);
        result = 31 * result + apbmwag;
        result = 31 * result + adjefc2;
        result = 31 * result + offpc;
        result = 31 * result + offsc;
        result = 31 * result + indpc;
        result = 31 * result + (sdupesar != null ? sdupesar.hashCode() : 0);
        result = 31 * result + exexcld;
        result = 31 * result + exexcld2;
        result = 31 * result + aexexc;
        result = 31 * result + aexexc2;
        result = 31 * result + efcsti;
        result = 31 * result + efcsti2;
        result = 31 * result + (indpcs != null ? indpcs.hashCode() : 0);
        result = 31 * result + shcredt;
        result = 31 * result + keogh;
        result = 31 * result + (stateso != null ? stateso.hashCode() : 0);
        result = 31 * result + (stated != null ? stated.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
