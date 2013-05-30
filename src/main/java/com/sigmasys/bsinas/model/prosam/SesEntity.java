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
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SES", schema = "SIGMA", catalog = "")
@Entity
public class SesEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSeskey();
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

    private String seskey;

    @javax.persistence.Column(name = "SESKEY")
    @Id
    public String getSeskey() {
        return seskey;
    }

    public void setSeskey(String seskey) {
        this.seskey = seskey;
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

    private String sessid;

    @javax.persistence.Column(name = "SESSID")
    @Basic
    public String getSessid() {
        return sessid;
    }

    public void setSessid(String sessid) {
        this.sessid = sessid;
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

    private String pmajor;

    @javax.persistence.Column(name = "PMAJOR")
    @Basic
    public String getPmajor() {
        return pmajor;
    }

    public void setPmajor(String pmajor) {
        this.pmajor = pmajor;
    }

    private String pdegree;

    @javax.persistence.Column(name = "PDEGREE")
    @Basic
    public String getPdegree() {
        return pdegree;
    }

    public void setPdegree(String pdegree) {
        this.pdegree = pdegree;
    }

    private String ecampus;

    @javax.persistence.Column(name = "ECAMPUS")
    @Basic
    public String getEcampus() {
        return ecampus;
    }

    public void setEcampus(String ecampus) {
        this.ecampus = ecampus;
    }

    private String feecat1;

    @javax.persistence.Column(name = "FEECAT1")
    @Basic
    public String getFeecat1() {
        return feecat1;
    }

    public void setFeecat1(String feecat1) {
        this.feecat1 = feecat1;
    }

    private String feecat2;

    @javax.persistence.Column(name = "FEECAT2")
    @Basic
    public String getFeecat2() {
        return feecat2;
    }

    public void setFeecat2(String feecat2) {
        this.feecat2 = feecat2;
    }

    private String feecat3;

    @javax.persistence.Column(name = "FEECAT3")
    @Basic
    public String getFeecat3() {
        return feecat3;
    }

    public void setFeecat3(String feecat3) {
        this.feecat3 = feecat3;
    }

    private String feecat4;

    @javax.persistence.Column(name = "FEECAT4")
    @Basic
    public String getFeecat4() {
        return feecat4;
    }

    public void setFeecat4(String feecat4) {
        this.feecat4 = feecat4;
    }

    private String feecat5;

    @javax.persistence.Column(name = "FEECAT5")
    @Basic
    public String getFeecat5() {
        return feecat5;
    }

    public void setFeecat5(String feecat5) {
        this.feecat5 = feecat5;
    }

    private String pschool;

    @javax.persistence.Column(name = "PSCHOOL")
    @Basic
    public String getPschool() {
        return pschool;
    }

    public void setPschool(String pschool) {
        this.pschool = pschool;
    }

    private String clazz;

    @javax.persistence.Column(name = "CLASS")
    @Basic
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    private String classiv;

    @javax.persistence.Column(name = "CLASSIV")
    @Basic
    public String getClassiv() {
        return classiv;
    }

    public void setClassiv(String classiv) {
        this.classiv = classiv;
    }

    private String divisn;

    @javax.persistence.Column(name = "DIVISN")
    @Basic
    public String getDivisn() {
        return divisn;
    }

    public void setDivisn(String divisn) {
        this.divisn = divisn;
    }

    private String aenrlt;

    @javax.persistence.Column(name = "AENRLT")
    @Basic
    public String getAenrlt() {
        return aenrlt;
    }

    public void setAenrlt(String aenrlt) {
        this.aenrlt = aenrlt;
    }

    private String penrlt;

    @javax.persistence.Column(name = "PENRLT")
    @Basic
    public String getPenrlt() {
        return penrlt;
    }

    public void setPenrlt(String penrlt) {
        this.penrlt = penrlt;
    }

    private String enrtyp;

    @javax.persistence.Column(name = "ENRTYP")
    @Basic
    public String getEnrtyp() {
        return enrtyp;
    }

    public void setEnrtyp(String enrtyp) {
        this.enrtyp = enrtyp;
    }

    private BigDecimal atmhrs;

    @javax.persistence.Column(name = "ATMHRS")
    @Basic
    public BigDecimal getAtmhrs() {
        return atmhrs;
    }

    public void setAtmhrs(BigDecimal atmhrs) {
        this.atmhrs = atmhrs;
    }

    private BigDecimal cuhrsca;

    @javax.persistence.Column(name = "CUHRSCA")
    @Basic
    public BigDecimal getCuhrsca() {
        return cuhrsca;
    }

    public void setCuhrsca(BigDecimal cuhrsca) {
        this.cuhrsca = cuhrsca;
    }

    private BigDecimal cuhrsco;

    @javax.persistence.Column(name = "CUHRSCO")
    @Basic
    public BigDecimal getCuhrsco() {
        return cuhrsco;
    }

    public void setCuhrsco(BigDecimal cuhrsco) {
        this.cuhrsco = cuhrsco;
    }

    private String wdrldt;

    @javax.persistence.Column(name = "WDRLDT")
    @Basic
    public String getWdrldt() {
        return wdrldt;
    }

    public void setWdrldt(String wdrldt) {
        this.wdrldt = wdrldt;
    }

    private String lcdd;

    @javax.persistence.Column(name = "LCDD")
    @Basic
    public String getLcdd() {
        return lcdd;
    }

    public void setLcdd(String lcdd) {
        this.lcdd = lcdd;
    }

    private String lda;

    @javax.persistence.Column(name = "LDA")
    @Basic
    public String getLda() {
        return lda;
    }

    public void setLda(String lda) {
        this.lda = lda;
    }

    private String wird;

    @javax.persistence.Column(name = "WIRD")
    @Basic
    public String getWird() {
        return wird;
    }

    public void setWird(String wird) {
        this.wird = wird;
    }

    private String sownd;

    @javax.persistence.Column(name = "SOWND")
    @Basic
    public String getSownd() {
        return sownd;
    }

    public void setSownd(String sownd) {
        this.sownd = sownd;
    }

    private String user1;

    @javax.persistence.Column(name = "USER1")
    @Basic
    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    private String user2;

    @javax.persistence.Column(name = "USER2")
    @Basic
    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    private String user3;

    @javax.persistence.Column(name = "USER3")
    @Basic
    public String getUser3() {
        return user3;
    }

    public void setUser3(String user3) {
        this.user3 = user3;
    }

    private String user4;

    @javax.persistence.Column(name = "USER4")
    @Basic
    public String getUser4() {
        return user4;
    }

    public void setUser4(String user4) {
        this.user4 = user4;
    }

    private String user5;

    @javax.persistence.Column(name = "USER5")
    @Basic
    public String getUser5() {
        return user5;
    }

    public void setUser5(String user5) {
        this.user5 = user5;
    }

    private String user6;

    @javax.persistence.Column(name = "USER6")
    @Basic
    public String getUser6() {
        return user6;
    }

    public void setUser6(String user6) {
        this.user6 = user6;
    }

    private String user7;

    @javax.persistence.Column(name = "USER7")
    @Basic
    public String getUser7() {
        return user7;
    }

    public void setUser7(String user7) {
        this.user7 = user7;
    }

    private String user8;

    @javax.persistence.Column(name = "USER8")
    @Basic
    public String getUser8() {
        return user8;
    }

    public void setUser8(String user8) {
        this.user8 = user8;
    }

    private String user9;

    @javax.persistence.Column(name = "USER9")
    @Basic
    public String getUser9() {
        return user9;
    }

    public void setUser9(String user9) {
        this.user9 = user9;
    }

    private String user10;

    @javax.persistence.Column(name = "USER10")
    @Basic
    public String getUser10() {
        return user10;
    }

    public void setUser10(String user10) {
        this.user10 = user10;
    }

    private String user11;

    @javax.persistence.Column(name = "USER11")
    @Basic
    public String getUser11() {
        return user11;
    }

    public void setUser11(String user11) {
        this.user11 = user11;
    }

    private String user12;

    @javax.persistence.Column(name = "USER12")
    @Basic
    public String getUser12() {
        return user12;
    }

    public void setUser12(String user12) {
        this.user12 = user12;
    }

    private String user13;

    @javax.persistence.Column(name = "USER13")
    @Basic
    public String getUser13() {
        return user13;
    }

    public void setUser13(String user13) {
        this.user13 = user13;
    }

    private String user14;

    @javax.persistence.Column(name = "USER14")
    @Basic
    public String getUser14() {
        return user14;
    }

    public void setUser14(String user14) {
        this.user14 = user14;
    }

    private String user15;

    @javax.persistence.Column(name = "USER15")
    @Basic
    public String getUser15() {
        return user15;
    }

    public void setUser15(String user15) {
        this.user15 = user15;
    }

    private String user16;

    @javax.persistence.Column(name = "USER16")
    @Basic
    public String getUser16() {
        return user16;
    }

    public void setUser16(String user16) {
        this.user16 = user16;
    }

    private String user17;

    @javax.persistence.Column(name = "USER17")
    @Basic
    public String getUser17() {
        return user17;
    }

    public void setUser17(String user17) {
        this.user17 = user17;
    }

    private String user18;

    @javax.persistence.Column(name = "USER18")
    @Basic
    public String getUser18() {
        return user18;
    }

    public void setUser18(String user18) {
        this.user18 = user18;
    }

    private String user19;

    @javax.persistence.Column(name = "USER19")
    @Basic
    public String getUser19() {
        return user19;
    }

    public void setUser19(String user19) {
        this.user19 = user19;
    }

    private String user20;

    @javax.persistence.Column(name = "USER20")
    @Basic
    public String getUser20() {
        return user20;
    }

    public void setUser20(String user20) {
        this.user20 = user20;
    }

    private int usernr1;

    @javax.persistence.Column(name = "USERNR1")
    @Basic
    public int getUsernr1() {
        return usernr1;
    }

    public void setUsernr1(int usernr1) {
        this.usernr1 = usernr1;
    }

    private int usernr2;

    @javax.persistence.Column(name = "USERNR2")
    @Basic
    public int getUsernr2() {
        return usernr2;
    }

    public void setUsernr2(int usernr2) {
        this.usernr2 = usernr2;
    }

    private int usernr3;

    @javax.persistence.Column(name = "USERNR3")
    @Basic
    public int getUsernr3() {
        return usernr3;
    }

    public void setUsernr3(int usernr3) {
        this.usernr3 = usernr3;
    }

    private int usernr4;

    @javax.persistence.Column(name = "USERNR4")
    @Basic
    public int getUsernr4() {
        return usernr4;
    }

    public void setUsernr4(int usernr4) {
        this.usernr4 = usernr4;
    }

    private int usernr5;

    @javax.persistence.Column(name = "USERNR5")
    @Basic
    public int getUsernr5() {
        return usernr5;
    }

    public void setUsernr5(int usernr5) {
        this.usernr5 = usernr5;
    }

    private BigDecimal usernr6;

    @javax.persistence.Column(name = "USERNR6")
    @Basic
    public BigDecimal getUsernr6() {
        return usernr6;
    }

    public void setUsernr6(BigDecimal usernr6) {
        this.usernr6 = usernr6;
    }

    private BigDecimal usernr7;

    @javax.persistence.Column(name = "USERNR7")
    @Basic
    public BigDecimal getUsernr7() {
        return usernr7;
    }

    public void setUsernr7(BigDecimal usernr7) {
        this.usernr7 = usernr7;
    }

    private BigDecimal usernr8;

    @javax.persistence.Column(name = "USERNR8")
    @Basic
    public BigDecimal getUsernr8() {
        return usernr8;
    }

    public void setUsernr8(BigDecimal usernr8) {
        this.usernr8 = usernr8;
    }

    private String udt01;

    @javax.persistence.Column(name = "UDT01")
    @Basic
    public String getUdt01() {
        return udt01;
    }

    public void setUdt01(String udt01) {
        this.udt01 = udt01;
    }

    private String udt02;

    @javax.persistence.Column(name = "UDT02")
    @Basic
    public String getUdt02() {
        return udt02;
    }

    public void setUdt02(String udt02) {
        this.udt02 = udt02;
    }

    private String udt03;

    @javax.persistence.Column(name = "UDT03")
    @Basic
    public String getUdt03() {
        return udt03;
    }

    public void setUdt03(String udt03) {
        this.udt03 = udt03;
    }

    private String udt04;

    @javax.persistence.Column(name = "UDT04")
    @Basic
    public String getUdt04() {
        return udt04;
    }

    public void setUdt04(String udt04) {
        this.udt04 = udt04;
    }

    private String udt05;

    @javax.persistence.Column(name = "UDT05")
    @Basic
    public String getUdt05() {
        return udt05;
    }

    public void setUdt05(String udt05) {
        this.udt05 = udt05;
    }

    private String udt06;

    @javax.persistence.Column(name = "UDT06")
    @Basic
    public String getUdt06() {
        return udt06;
    }

    public void setUdt06(String udt06) {
        this.udt06 = udt06;
    }

    private String udt07;

    @javax.persistence.Column(name = "UDT07")
    @Basic
    public String getUdt07() {
        return udt07;
    }

    public void setUdt07(String udt07) {
        this.udt07 = udt07;
    }

    private String udt08;

    @javax.persistence.Column(name = "UDT08")
    @Basic
    public String getUdt08() {
        return udt08;
    }

    public void setUdt08(String udt08) {
        this.udt08 = udt08;
    }

    private String udt09;

    @javax.persistence.Column(name = "UDT09")
    @Basic
    public String getUdt09() {
        return udt09;
    }

    public void setUdt09(String udt09) {
        this.udt09 = udt09;
    }

    private String udt10;

    @javax.persistence.Column(name = "UDT10")
    @Basic
    public String getUdt10() {
        return udt10;
    }

    public void setUdt10(String udt10) {
        this.udt10 = udt10;
    }

    private String udt11;

    @javax.persistence.Column(name = "UDT11")
    @Basic
    public String getUdt11() {
        return udt11;
    }

    public void setUdt11(String udt11) {
        this.udt11 = udt11;
    }

    private String udt12;

    @javax.persistence.Column(name = "UDT12")
    @Basic
    public String getUdt12() {
        return udt12;
    }

    public void setUdt12(String udt12) {
        this.udt12 = udt12;
    }

    private String udt13;

    @javax.persistence.Column(name = "UDT13")
    @Basic
    public String getUdt13() {
        return udt13;
    }

    public void setUdt13(String udt13) {
        this.udt13 = udt13;
    }

    private String udt14;

    @javax.persistence.Column(name = "UDT14")
    @Basic
    public String getUdt14() {
        return udt14;
    }

    public void setUdt14(String udt14) {
        this.udt14 = udt14;
    }

    private String udt15;

    @javax.persistence.Column(name = "UDT15")
    @Basic
    public String getUdt15() {
        return udt15;
    }

    public void setUdt15(String udt15) {
        this.udt15 = udt15;
    }

    private String udt16;

    @javax.persistence.Column(name = "UDT16")
    @Basic
    public String getUdt16() {
        return udt16;
    }

    public void setUdt16(String udt16) {
        this.udt16 = udt16;
    }

    private String udt17;

    @javax.persistence.Column(name = "UDT17")
    @Basic
    public String getUdt17() {
        return udt17;
    }

    public void setUdt17(String udt17) {
        this.udt17 = udt17;
    }

    private String udt18;

    @javax.persistence.Column(name = "UDT18")
    @Basic
    public String getUdt18() {
        return udt18;
    }

    public void setUdt18(String udt18) {
        this.udt18 = udt18;
    }

    private String udt19;

    @javax.persistence.Column(name = "UDT19")
    @Basic
    public String getUdt19() {
        return udt19;
    }

    public void setUdt19(String udt19) {
        this.udt19 = udt19;
    }

    private String udt20;

    @javax.persistence.Column(name = "UDT20")
    @Basic
    public String getUdt20() {
        return udt20;
    }

    public void setUdt20(String udt20) {
        this.udt20 = udt20;
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

    private String enrscd;

    @javax.persistence.Column(name = "ENRSCD")
    @Basic
    public String getEnrscd() {
        return enrscd;
    }

    public void setEnrscd(String enrscd) {
        this.enrscd = enrscd;
    }

    private BigDecimal cumgpa;

    @javax.persistence.Column(name = "CUMGPA")
    @Basic
    public BigDecimal getCumgpa() {
        return cumgpa;
    }

    public void setCumgpa(BigDecimal cumgpa) {
        this.cumgpa = cumgpa;
    }

    private BigDecimal trmgpa;

    @javax.persistence.Column(name = "TRMGPA")
    @Basic
    public BigDecimal getTrmgpa() {
        return trmgpa;
    }

    public void setTrmgpa(BigDecimal trmgpa) {
        this.trmgpa = trmgpa;
    }

    private BigDecimal cmhrsd;

    @javax.persistence.Column(name = "CMHRSD")
    @Basic
    public BigDecimal getCmhrsd() {
        return cmhrsd;
    }

    public void setCmhrsd(BigDecimal cmhrsd) {
        this.cmhrsd = cmhrsd;
    }

    private String disst1;

    @javax.persistence.Column(name = "DISST1")
    @Basic
    public String getDisst1() {
        return disst1;
    }

    public void setDisst1(String disst1) {
        this.disst1 = disst1;
    }

    private String disst2;

    @javax.persistence.Column(name = "DISST2")
    @Basic
    public String getDisst2() {
        return disst2;
    }

    public void setDisst2(String disst2) {
        this.disst2 = disst2;
    }

    private String disst3;

    @javax.persistence.Column(name = "DISST3")
    @Basic
    public String getDisst3() {
        return disst3;
    }

    public void setDisst3(String disst3) {
        this.disst3 = disst3;
    }

    private String disst4;

    @javax.persistence.Column(name = "DISST4")
    @Basic
    public String getDisst4() {
        return disst4;
    }

    public void setDisst4(String disst4) {
        this.disst4 = disst4;
    }

    private String disst5;

    @javax.persistence.Column(name = "DISST5")
    @Basic
    public String getDisst5() {
        return disst5;
    }

    public void setDisst5(String disst5) {
        this.disst5 = disst5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SesEntity sesEntity = (SesEntity) o;

        if (revlev != sesEntity.revlev) return false;
        if (usernr1 != sesEntity.usernr1) return false;
        if (usernr2 != sesEntity.usernr2) return false;
        if (usernr3 != sesEntity.usernr3) return false;
        if (usernr4 != sesEntity.usernr4) return false;
        if (usernr5 != sesEntity.usernr5) return false;
        if (aenrlt != null ? !aenrlt.equals(sesEntity.aenrlt) : sesEntity.aenrlt != null) return false;
        if (aidyr != null ? !aidyr.equals(sesEntity.aidyr) : sesEntity.aidyr != null) return false;
        if (atmhrs != null ? !atmhrs.equals(sesEntity.atmhrs) : sesEntity.atmhrs != null) return false;
        if (classiv != null ? !classiv.equals(sesEntity.classiv) : sesEntity.classiv != null) return false;
        if (clazz != null ? !clazz.equals(sesEntity.clazz) : sesEntity.clazz != null) return false;
        if (cmhrsd != null ? !cmhrsd.equals(sesEntity.cmhrsd) : sesEntity.cmhrsd != null) return false;
        if (crtdate != null ? !crtdate.equals(sesEntity.crtdate) : sesEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(sesEntity.crtmod) : sesEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(sesEntity.crttime) : sesEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(sesEntity.crtuser) : sesEntity.crtuser != null) return false;
        if (cuhrsca != null ? !cuhrsca.equals(sesEntity.cuhrsca) : sesEntity.cuhrsca != null) return false;
        if (cuhrsco != null ? !cuhrsco.equals(sesEntity.cuhrsco) : sesEntity.cuhrsco != null) return false;
        if (cumgpa != null ? !cumgpa.equals(sesEntity.cumgpa) : sesEntity.cumgpa != null) return false;
        if (disst1 != null ? !disst1.equals(sesEntity.disst1) : sesEntity.disst1 != null) return false;
        if (disst2 != null ? !disst2.equals(sesEntity.disst2) : sesEntity.disst2 != null) return false;
        if (disst3 != null ? !disst3.equals(sesEntity.disst3) : sesEntity.disst3 != null) return false;
        if (disst4 != null ? !disst4.equals(sesEntity.disst4) : sesEntity.disst4 != null) return false;
        if (disst5 != null ? !disst5.equals(sesEntity.disst5) : sesEntity.disst5 != null) return false;
        if (divisn != null ? !divisn.equals(sesEntity.divisn) : sesEntity.divisn != null) return false;
        if (ecampus != null ? !ecampus.equals(sesEntity.ecampus) : sesEntity.ecampus != null) return false;
        if (enrscd != null ? !enrscd.equals(sesEntity.enrscd) : sesEntity.enrscd != null) return false;
        if (enrtyp != null ? !enrtyp.equals(sesEntity.enrtyp) : sesEntity.enrtyp != null) return false;
        if (feecat1 != null ? !feecat1.equals(sesEntity.feecat1) : sesEntity.feecat1 != null) return false;
        if (feecat2 != null ? !feecat2.equals(sesEntity.feecat2) : sesEntity.feecat2 != null) return false;
        if (feecat3 != null ? !feecat3.equals(sesEntity.feecat3) : sesEntity.feecat3 != null) return false;
        if (feecat4 != null ? !feecat4.equals(sesEntity.feecat4) : sesEntity.feecat4 != null) return false;
        if (feecat5 != null ? !feecat5.equals(sesEntity.feecat5) : sesEntity.feecat5 != null) return false;
        if (lcdd != null ? !lcdd.equals(sesEntity.lcdd) : sesEntity.lcdd != null) return false;
        if (lda != null ? !lda.equals(sesEntity.lda) : sesEntity.lda != null) return false;
        if (pdegree != null ? !pdegree.equals(sesEntity.pdegree) : sesEntity.pdegree != null) return false;
        if (penrlt != null ? !penrlt.equals(sesEntity.penrlt) : sesEntity.penrlt != null) return false;
        if (pmajor != null ? !pmajor.equals(sesEntity.pmajor) : sesEntity.pmajor != null) return false;
        if (pschool != null ? !pschool.equals(sesEntity.pschool) : sesEntity.pschool != null) return false;
        if (recstat != null ? !recstat.equals(sesEntity.recstat) : sesEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(sesEntity.revdate) : sesEntity.revdate != null) return false;
        if (revmod != null ? !revmod.equals(sesEntity.revmod) : sesEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(sesEntity.revtime) : sesEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(sesEntity.revuser) : sesEntity.revuser != null) return false;
        if (seskey != null ? !seskey.equals(sesEntity.seskey) : sesEntity.seskey != null) return false;
        if (sessid != null ? !sessid.equals(sesEntity.sessid) : sesEntity.sessid != null) return false;
        if (sid != null ? !sid.equals(sesEntity.sid) : sesEntity.sid != null) return false;
        if (sownd != null ? !sownd.equals(sesEntity.sownd) : sesEntity.sownd != null) return false;
        if (term != null ? !term.equals(sesEntity.term) : sesEntity.term != null) return false;
        if (trmgpa != null ? !trmgpa.equals(sesEntity.trmgpa) : sesEntity.trmgpa != null) return false;
        if (ucode != null ? !ucode.equals(sesEntity.ucode) : sesEntity.ucode != null) return false;
        if (udt01 != null ? !udt01.equals(sesEntity.udt01) : sesEntity.udt01 != null) return false;
        if (udt02 != null ? !udt02.equals(sesEntity.udt02) : sesEntity.udt02 != null) return false;
        if (udt03 != null ? !udt03.equals(sesEntity.udt03) : sesEntity.udt03 != null) return false;
        if (udt04 != null ? !udt04.equals(sesEntity.udt04) : sesEntity.udt04 != null) return false;
        if (udt05 != null ? !udt05.equals(sesEntity.udt05) : sesEntity.udt05 != null) return false;
        if (udt06 != null ? !udt06.equals(sesEntity.udt06) : sesEntity.udt06 != null) return false;
        if (udt07 != null ? !udt07.equals(sesEntity.udt07) : sesEntity.udt07 != null) return false;
        if (udt08 != null ? !udt08.equals(sesEntity.udt08) : sesEntity.udt08 != null) return false;
        if (udt09 != null ? !udt09.equals(sesEntity.udt09) : sesEntity.udt09 != null) return false;
        if (udt10 != null ? !udt10.equals(sesEntity.udt10) : sesEntity.udt10 != null) return false;
        if (udt11 != null ? !udt11.equals(sesEntity.udt11) : sesEntity.udt11 != null) return false;
        if (udt12 != null ? !udt12.equals(sesEntity.udt12) : sesEntity.udt12 != null) return false;
        if (udt13 != null ? !udt13.equals(sesEntity.udt13) : sesEntity.udt13 != null) return false;
        if (udt14 != null ? !udt14.equals(sesEntity.udt14) : sesEntity.udt14 != null) return false;
        if (udt15 != null ? !udt15.equals(sesEntity.udt15) : sesEntity.udt15 != null) return false;
        if (udt16 != null ? !udt16.equals(sesEntity.udt16) : sesEntity.udt16 != null) return false;
        if (udt17 != null ? !udt17.equals(sesEntity.udt17) : sesEntity.udt17 != null) return false;
        if (udt18 != null ? !udt18.equals(sesEntity.udt18) : sesEntity.udt18 != null) return false;
        if (udt19 != null ? !udt19.equals(sesEntity.udt19) : sesEntity.udt19 != null) return false;
        if (udt20 != null ? !udt20.equals(sesEntity.udt20) : sesEntity.udt20 != null) return false;
        if (user1 != null ? !user1.equals(sesEntity.user1) : sesEntity.user1 != null) return false;
        if (user10 != null ? !user10.equals(sesEntity.user10) : sesEntity.user10 != null) return false;
        if (user11 != null ? !user11.equals(sesEntity.user11) : sesEntity.user11 != null) return false;
        if (user12 != null ? !user12.equals(sesEntity.user12) : sesEntity.user12 != null) return false;
        if (user13 != null ? !user13.equals(sesEntity.user13) : sesEntity.user13 != null) return false;
        if (user14 != null ? !user14.equals(sesEntity.user14) : sesEntity.user14 != null) return false;
        if (user15 != null ? !user15.equals(sesEntity.user15) : sesEntity.user15 != null) return false;
        if (user16 != null ? !user16.equals(sesEntity.user16) : sesEntity.user16 != null) return false;
        if (user17 != null ? !user17.equals(sesEntity.user17) : sesEntity.user17 != null) return false;
        if (user18 != null ? !user18.equals(sesEntity.user18) : sesEntity.user18 != null) return false;
        if (user19 != null ? !user19.equals(sesEntity.user19) : sesEntity.user19 != null) return false;
        if (user2 != null ? !user2.equals(sesEntity.user2) : sesEntity.user2 != null) return false;
        if (user20 != null ? !user20.equals(sesEntity.user20) : sesEntity.user20 != null) return false;
        if (user3 != null ? !user3.equals(sesEntity.user3) : sesEntity.user3 != null) return false;
        if (user4 != null ? !user4.equals(sesEntity.user4) : sesEntity.user4 != null) return false;
        if (user5 != null ? !user5.equals(sesEntity.user5) : sesEntity.user5 != null) return false;
        if (user6 != null ? !user6.equals(sesEntity.user6) : sesEntity.user6 != null) return false;
        if (user7 != null ? !user7.equals(sesEntity.user7) : sesEntity.user7 != null) return false;
        if (user8 != null ? !user8.equals(sesEntity.user8) : sesEntity.user8 != null) return false;
        if (user9 != null ? !user9.equals(sesEntity.user9) : sesEntity.user9 != null) return false;
        if (usernr6 != null ? !usernr6.equals(sesEntity.usernr6) : sesEntity.usernr6 != null) return false;
        if (usernr7 != null ? !usernr7.equals(sesEntity.usernr7) : sesEntity.usernr7 != null) return false;
        if (usernr8 != null ? !usernr8.equals(sesEntity.usernr8) : sesEntity.usernr8 != null) return false;
        if (wdrldt != null ? !wdrldt.equals(sesEntity.wdrldt) : sesEntity.wdrldt != null) return false;
        if (wird != null ? !wird.equals(sesEntity.wird) : sesEntity.wird != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (seskey != null ? seskey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (sessid != null ? sessid.hashCode() : 0);
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
        result = 31 * result + (pmajor != null ? pmajor.hashCode() : 0);
        result = 31 * result + (pdegree != null ? pdegree.hashCode() : 0);
        result = 31 * result + (ecampus != null ? ecampus.hashCode() : 0);
        result = 31 * result + (feecat1 != null ? feecat1.hashCode() : 0);
        result = 31 * result + (feecat2 != null ? feecat2.hashCode() : 0);
        result = 31 * result + (feecat3 != null ? feecat3.hashCode() : 0);
        result = 31 * result + (feecat4 != null ? feecat4.hashCode() : 0);
        result = 31 * result + (feecat5 != null ? feecat5.hashCode() : 0);
        result = 31 * result + (pschool != null ? pschool.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (classiv != null ? classiv.hashCode() : 0);
        result = 31 * result + (divisn != null ? divisn.hashCode() : 0);
        result = 31 * result + (aenrlt != null ? aenrlt.hashCode() : 0);
        result = 31 * result + (penrlt != null ? penrlt.hashCode() : 0);
        result = 31 * result + (enrtyp != null ? enrtyp.hashCode() : 0);
        result = 31 * result + (atmhrs != null ? atmhrs.hashCode() : 0);
        result = 31 * result + (cuhrsca != null ? cuhrsca.hashCode() : 0);
        result = 31 * result + (cuhrsco != null ? cuhrsco.hashCode() : 0);
        result = 31 * result + (wdrldt != null ? wdrldt.hashCode() : 0);
        result = 31 * result + (lcdd != null ? lcdd.hashCode() : 0);
        result = 31 * result + (lda != null ? lda.hashCode() : 0);
        result = 31 * result + (wird != null ? wird.hashCode() : 0);
        result = 31 * result + (sownd != null ? sownd.hashCode() : 0);
        result = 31 * result + (user1 != null ? user1.hashCode() : 0);
        result = 31 * result + (user2 != null ? user2.hashCode() : 0);
        result = 31 * result + (user3 != null ? user3.hashCode() : 0);
        result = 31 * result + (user4 != null ? user4.hashCode() : 0);
        result = 31 * result + (user5 != null ? user5.hashCode() : 0);
        result = 31 * result + (user6 != null ? user6.hashCode() : 0);
        result = 31 * result + (user7 != null ? user7.hashCode() : 0);
        result = 31 * result + (user8 != null ? user8.hashCode() : 0);
        result = 31 * result + (user9 != null ? user9.hashCode() : 0);
        result = 31 * result + (user10 != null ? user10.hashCode() : 0);
        result = 31 * result + (user11 != null ? user11.hashCode() : 0);
        result = 31 * result + (user12 != null ? user12.hashCode() : 0);
        result = 31 * result + (user13 != null ? user13.hashCode() : 0);
        result = 31 * result + (user14 != null ? user14.hashCode() : 0);
        result = 31 * result + (user15 != null ? user15.hashCode() : 0);
        result = 31 * result + (user16 != null ? user16.hashCode() : 0);
        result = 31 * result + (user17 != null ? user17.hashCode() : 0);
        result = 31 * result + (user18 != null ? user18.hashCode() : 0);
        result = 31 * result + (user19 != null ? user19.hashCode() : 0);
        result = 31 * result + (user20 != null ? user20.hashCode() : 0);
        result = 31 * result + usernr1;
        result = 31 * result + usernr2;
        result = 31 * result + usernr3;
        result = 31 * result + usernr4;
        result = 31 * result + usernr5;
        result = 31 * result + (usernr6 != null ? usernr6.hashCode() : 0);
        result = 31 * result + (usernr7 != null ? usernr7.hashCode() : 0);
        result = 31 * result + (usernr8 != null ? usernr8.hashCode() : 0);
        result = 31 * result + (udt01 != null ? udt01.hashCode() : 0);
        result = 31 * result + (udt02 != null ? udt02.hashCode() : 0);
        result = 31 * result + (udt03 != null ? udt03.hashCode() : 0);
        result = 31 * result + (udt04 != null ? udt04.hashCode() : 0);
        result = 31 * result + (udt05 != null ? udt05.hashCode() : 0);
        result = 31 * result + (udt06 != null ? udt06.hashCode() : 0);
        result = 31 * result + (udt07 != null ? udt07.hashCode() : 0);
        result = 31 * result + (udt08 != null ? udt08.hashCode() : 0);
        result = 31 * result + (udt09 != null ? udt09.hashCode() : 0);
        result = 31 * result + (udt10 != null ? udt10.hashCode() : 0);
        result = 31 * result + (udt11 != null ? udt11.hashCode() : 0);
        result = 31 * result + (udt12 != null ? udt12.hashCode() : 0);
        result = 31 * result + (udt13 != null ? udt13.hashCode() : 0);
        result = 31 * result + (udt14 != null ? udt14.hashCode() : 0);
        result = 31 * result + (udt15 != null ? udt15.hashCode() : 0);
        result = 31 * result + (udt16 != null ? udt16.hashCode() : 0);
        result = 31 * result + (udt17 != null ? udt17.hashCode() : 0);
        result = 31 * result + (udt18 != null ? udt18.hashCode() : 0);
        result = 31 * result + (udt19 != null ? udt19.hashCode() : 0);
        result = 31 * result + (udt20 != null ? udt20.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (enrscd != null ? enrscd.hashCode() : 0);
        result = 31 * result + (cumgpa != null ? cumgpa.hashCode() : 0);
        result = 31 * result + (trmgpa != null ? trmgpa.hashCode() : 0);
        result = 31 * result + (cmhrsd != null ? cmhrsd.hashCode() : 0);
        result = 31 * result + (disst1 != null ? disst1.hashCode() : 0);
        result = 31 * result + (disst2 != null ? disst2.hashCode() : 0);
        result = 31 * result + (disst3 != null ? disst3.hashCode() : 0);
        result = 31 * result + (disst4 != null ? disst4.hashCode() : 0);
        result = 31 * result + (disst5 != null ? disst5.hashCode() : 0);
        return result;
    }
}
