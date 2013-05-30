package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/25/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "EOR", schema = "SIGMA", catalog = "")
@Entity
public class EorEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getEorkey();
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

    private String eorkey;

    @javax.persistence.Column(name = "EORKEY")
    @Id
    public String getEorkey() {
        return eorkey;
    }

    public void setEorkey(String eorkey) {
        this.eorkey = eorkey;
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

    private String pgsid;

    @javax.persistence.Column(name = "PGSID")
    @Basic
    public String getPgsid() {
        return pgsid;
    }

    public void setPgsid(String pgsid) {
        this.pgsid = pgsid;
    }

    private String pgidsf;

    @javax.persistence.Column(name = "PGIDSF")
    @Basic
    public String getPgidsf() {
        return pgidsf;
    }

    public void setPgidsf(String pgidsf) {
        this.pgidsf = pgidsf;
    }

    private BigInteger pgtrnnr;

    @javax.persistence.Column(name = "PGTRNNR")
    @Basic
    public BigInteger getPgtrnnr() {
        return pgtrnnr;
    }

    public void setPgtrnnr(BigInteger pgtrnnr) {
        this.pgtrnnr = pgtrnnr;
    }

    private int obeogi;

    @javax.persistence.Column(name = "OBEOGI")
    @Basic
    public int getObeogi() {
        return obeogi;
    }

    public void setObeogi(int obeogi) {
        this.obeogi = obeogi;
    }

    private String secefcf;

    @javax.persistence.Column(name = "SECEFCF")
    @Basic
    public String getSecefcf() {
        return secefcf;
    }

    public void setSecefcf(String secefcf) {
        this.secefcf = secefcf;
    }

    private int instn;

    @javax.persistence.Column(name = "INSTN")
    @Basic
    public int getInstn() {
        return instn;
    }

    public void setInstn(int instn) {
        this.instn = instn;
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

    private int beogbud;

    @javax.persistence.Column(name = "BEOGBUD")
    @Basic
    public int getBeogbud() {
        return beogbud;
    }

    public void setBeogbud(int beogbud) {
        this.beogbud = beogbud;
    }

    private String pgvalst;

    @javax.persistence.Column(name = "PGVALST")
    @Basic
    public String getPgvalst() {
        return pgvalst;
    }

    public void setPgvalst(String pgvalst) {
        this.pgvalst = pgvalst;
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

    private int pgawdch;

    @javax.persistence.Column(name = "PGAWDCH")
    @Basic
    public int getPgawdch() {
        return pgawdch;
    }

    public void setPgawdch(int pgawdch) {
        this.pgawdch = pgawdch;
    }

    private int pgacch;

    @javax.persistence.Column(name = "PGACCH")
    @Basic
    public int getPgacch() {
        return pgacch;
    }

    public void setPgacch(int pgacch) {
        this.pgacch = pgacch;
    }

    private BigDecimal aamtyr;

    @javax.persistence.Column(name = "AAMTYR")
    @Basic
    public BigDecimal getAamtyr() {
        return aamtyr;
    }

    public void setAamtyr(BigDecimal aamtyr) {
        this.aamtyr = aamtyr;
    }

    private String disdt01;

    @javax.persistence.Column(name = "DISDT01")
    @Basic
    public String getDisdt01() {
        return disdt01;
    }

    public void setDisdt01(String disdt01) {
        this.disdt01 = disdt01;
    }

    private String disdt02;

    @javax.persistence.Column(name = "DISDT02")
    @Basic
    public String getDisdt02() {
        return disdt02;
    }

    public void setDisdt02(String disdt02) {
        this.disdt02 = disdt02;
    }

    private String disdt03;

    @javax.persistence.Column(name = "DISDT03")
    @Basic
    public String getDisdt03() {
        return disdt03;
    }

    public void setDisdt03(String disdt03) {
        this.disdt03 = disdt03;
    }

    private String disdt04;

    @javax.persistence.Column(name = "DISDT04")
    @Basic
    public String getDisdt04() {
        return disdt04;
    }

    public void setDisdt04(String disdt04) {
        this.disdt04 = disdt04;
    }

    private String disdt05;

    @javax.persistence.Column(name = "DISDT05")
    @Basic
    public String getDisdt05() {
        return disdt05;
    }

    public void setDisdt05(String disdt05) {
        this.disdt05 = disdt05;
    }

    private String disdt06;

    @javax.persistence.Column(name = "DISDT06")
    @Basic
    public String getDisdt06() {
        return disdt06;
    }

    public void setDisdt06(String disdt06) {
        this.disdt06 = disdt06;
    }

    private String disdt07;

    @javax.persistence.Column(name = "DISDT07")
    @Basic
    public String getDisdt07() {
        return disdt07;
    }

    public void setDisdt07(String disdt07) {
        this.disdt07 = disdt07;
    }

    private String disdt08;

    @javax.persistence.Column(name = "DISDT08")
    @Basic
    public String getDisdt08() {
        return disdt08;
    }

    public void setDisdt08(String disdt08) {
        this.disdt08 = disdt08;
    }

    private String disdt09;

    @javax.persistence.Column(name = "DISDT09")
    @Basic
    public String getDisdt09() {
        return disdt09;
    }

    public void setDisdt09(String disdt09) {
        this.disdt09 = disdt09;
    }

    private String disdt10;

    @javax.persistence.Column(name = "DISDT10")
    @Basic
    public String getDisdt10() {
        return disdt10;
    }

    public void setDisdt10(String disdt10) {
        this.disdt10 = disdt10;
    }

    private String disdt11;

    @javax.persistence.Column(name = "DISDT11")
    @Basic
    public String getDisdt11() {
        return disdt11;
    }

    public void setDisdt11(String disdt11) {
        this.disdt11 = disdt11;
    }

    private String disdt12;

    @javax.persistence.Column(name = "DISDT12")
    @Basic
    public String getDisdt12() {
        return disdt12;
    }

    public void setDisdt12(String disdt12) {
        this.disdt12 = disdt12;
    }

    private String disdt13;

    @javax.persistence.Column(name = "DISDT13")
    @Basic
    public String getDisdt13() {
        return disdt13;
    }

    public void setDisdt13(String disdt13) {
        this.disdt13 = disdt13;
    }

    private String disdt14;

    @javax.persistence.Column(name = "DISDT14")
    @Basic
    public String getDisdt14() {
        return disdt14;
    }

    public void setDisdt14(String disdt14) {
        this.disdt14 = disdt14;
    }

    private String disdt15;

    @javax.persistence.Column(name = "DISDT15")
    @Basic
    public String getDisdt15() {
        return disdt15;
    }

    public void setDisdt15(String disdt15) {
        this.disdt15 = disdt15;
    }

    private String pmeth;

    @javax.persistence.Column(name = "PMETH")
    @Basic
    public String getPmeth() {
        return pmeth;
    }

    public void setPmeth(String pmeth) {
        this.pmeth = pmeth;
    }

    private String incar;

    @javax.persistence.Column(name = "INCAR")
    @Basic
    public String getIncar() {
        return incar;
    }

    public void setIncar(String incar) {
        this.incar = incar;
    }

    private String begdate;

    @javax.persistence.Column(name = "BEGDATE")
    @Basic
    public String getBegdate() {
        return begdate;
    }

    public void setBegdate(String begdate) {
        this.begdate = begdate;
    }

    private String action;

    @javax.persistence.Column(name = "ACTION")
    @Basic
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    private String wicp;

    @javax.persistence.Column(name = "WICP")
    @Basic
    public String getWicp() {
        return wicp;
    }

    public void setWicp(String wicp) {
        this.wicp = wicp;
    }

    private String wpacy;

    @javax.persistence.Column(name = "WPACY")
    @Basic
    public String getWpacy() {
        return wpacy;
    }

    public void setWpacy(String wpacy) {
        this.wpacy = wpacy;
    }

    private String ltuit;

    @javax.persistence.Column(name = "LTUIT")
    @Basic
    public String getLtuit() {
        return ltuit;
    }

    public void setLtuit(String ltuit) {
        this.ltuit = ltuit;
    }

    private BigDecimal aaamt;

    @javax.persistence.Column(name = "AAAMT")
    @Basic
    public BigDecimal getAaamt() {
        return aaamt;
    }

    public void setAaamt(BigDecimal aaamt) {
        this.aaamt = aaamt;
    }

    private String adisd01;

    @javax.persistence.Column(name = "ADISD01")
    @Basic
    public String getAdisd01() {
        return adisd01;
    }

    public void setAdisd01(String adisd01) {
        this.adisd01 = adisd01;
    }

    private String adisd02;

    @javax.persistence.Column(name = "ADISD02")
    @Basic
    public String getAdisd02() {
        return adisd02;
    }

    public void setAdisd02(String adisd02) {
        this.adisd02 = adisd02;
    }

    private String adisd03;

    @javax.persistence.Column(name = "ADISD03")
    @Basic
    public String getAdisd03() {
        return adisd03;
    }

    public void setAdisd03(String adisd03) {
        this.adisd03 = adisd03;
    }

    private String adisd04;

    @javax.persistence.Column(name = "ADISD04")
    @Basic
    public String getAdisd04() {
        return adisd04;
    }

    public void setAdisd04(String adisd04) {
        this.adisd04 = adisd04;
    }

    private String adisd05;

    @javax.persistence.Column(name = "ADISD05")
    @Basic
    public String getAdisd05() {
        return adisd05;
    }

    public void setAdisd05(String adisd05) {
        this.adisd05 = adisd05;
    }

    private String adisd06;

    @javax.persistence.Column(name = "ADISD06")
    @Basic
    public String getAdisd06() {
        return adisd06;
    }

    public void setAdisd06(String adisd06) {
        this.adisd06 = adisd06;
    }

    private String adisd07;

    @javax.persistence.Column(name = "ADISD07")
    @Basic
    public String getAdisd07() {
        return adisd07;
    }

    public void setAdisd07(String adisd07) {
        this.adisd07 = adisd07;
    }

    private String adisd08;

    @javax.persistence.Column(name = "ADISD08")
    @Basic
    public String getAdisd08() {
        return adisd08;
    }

    public void setAdisd08(String adisd08) {
        this.adisd08 = adisd08;
    }

    private String adisd09;

    @javax.persistence.Column(name = "ADISD09")
    @Basic
    public String getAdisd09() {
        return adisd09;
    }

    public void setAdisd09(String adisd09) {
        this.adisd09 = adisd09;
    }

    private String adisd10;

    @javax.persistence.Column(name = "ADISD10")
    @Basic
    public String getAdisd10() {
        return adisd10;
    }

    public void setAdisd10(String adisd10) {
        this.adisd10 = adisd10;
    }

    private String adisd11;

    @javax.persistence.Column(name = "ADISD11")
    @Basic
    public String getAdisd11() {
        return adisd11;
    }

    public void setAdisd11(String adisd11) {
        this.adisd11 = adisd11;
    }

    private String adisd12;

    @javax.persistence.Column(name = "ADISD12")
    @Basic
    public String getAdisd12() {
        return adisd12;
    }

    public void setAdisd12(String adisd12) {
        this.adisd12 = adisd12;
    }

    private String adisd13;

    @javax.persistence.Column(name = "ADISD13")
    @Basic
    public String getAdisd13() {
        return adisd13;
    }

    public void setAdisd13(String adisd13) {
        this.adisd13 = adisd13;
    }

    private String adisd14;

    @javax.persistence.Column(name = "ADISD14")
    @Basic
    public String getAdisd14() {
        return adisd14;
    }

    public void setAdisd14(String adisd14) {
        this.adisd14 = adisd14;
    }

    private String adisd15;

    @javax.persistence.Column(name = "ADISD15")
    @Basic
    public String getAdisd15() {
        return adisd15;
    }

    public void setAdisd15(String adisd15) {
        this.adisd15 = adisd15;
    }

    private String aenrdt;

    @javax.persistence.Column(name = "AENRDT")
    @Basic
    public String getAenrdt() {
        return aenrdt;
    }

    public void setAenrdt(String aenrdt) {
        this.aenrdt = aenrdt;
    }

    private String altuit;

    @javax.persistence.Column(name = "ALTUIT")
    @Basic
    public String getAltuit() {
        return altuit;
    }

    public void setAltuit(String altuit) {
        this.altuit = altuit;
    }

    private String apvalst;

    @javax.persistence.Column(name = "APVALST")
    @Basic
    public String getApvalst() {
        return apvalst;
    }

    public void setApvalst(String apvalst) {
        this.apvalst = apvalst;
    }

    private String aincar;

    @javax.persistence.Column(name = "AINCAR")
    @Basic
    public String getAincar() {
        return aincar;
    }

    public void setAincar(String aincar) {
        this.aincar = aincar;
    }

    private BigInteger aptrnnr;

    @javax.persistence.Column(name = "APTRNNR")
    @Basic
    public BigInteger getAptrnnr() {
        return aptrnnr;
    }

    public void setAptrnnr(BigInteger aptrnnr) {
        this.aptrnnr = aptrnnr;
    }

    private int aefc;

    @javax.persistence.Column(name = "AEFC")
    @Basic
    public int getAefc() {
        return aefc;
    }

    public void setAefc(int aefc) {
        this.aefc = aefc;
    }

    private String asefcf;

    @javax.persistence.Column(name = "ASEFCF")
    @Basic
    public String getAsefcf() {
        return asefcf;
    }

    public void setAsefcf(String asefcf) {
        this.asefcf = asefcf;
    }

    private String aaccal;

    @javax.persistence.Column(name = "AACCAL")
    @Basic
    public String getAaccal() {
        return aaccal;
    }

    public void setAaccal(String aaccal) {
        this.aaccal = aaccal;
    }

    private String apmeth;

    @javax.persistence.Column(name = "APMETH")
    @Basic
    public String getApmeth() {
        return apmeth;
    }

    public void setApmeth(String apmeth) {
        this.apmeth = apmeth;
    }

    private int acoa;

    @javax.persistence.Column(name = "ACOA")
    @Basic
    public int getAcoa() {
        return acoa;
    }

    public void setAcoa(int acoa) {
        this.acoa = acoa;
    }

    private String aenrst;

    @javax.persistence.Column(name = "AENRST")
    @Basic
    public String getAenrst() {
        return aenrst;
    }

    public void setAenrst(String aenrst) {
        this.aenrst = aenrst;
    }

    private String awicp;

    @javax.persistence.Column(name = "AWICP")
    @Basic
    public String getAwicp() {
        return awicp;
    }

    public void setAwicp(String awicp) {
        this.awicp = awicp;
    }

    private String awpacy;

    @javax.persistence.Column(name = "AWPACY")
    @Basic
    public String getAwpacy() {
        return awpacy;
    }

    public void setAwpacy(String awpacy) {
        this.awpacy = awpacy;
    }

    private int apgawch;

    @javax.persistence.Column(name = "APGAWCH")
    @Basic
    public int getApgawch() {
        return apgawch;
    }

    public void setApgawch(int apgawch) {
        this.apgawch = apgawch;
    }

    private int apgacch;

    @javax.persistence.Column(name = "APGACCH")
    @Basic
    public int getApgacch() {
        return apgacch;
    }

    public void setApgacch(int apgacch) {
        this.apgacch = apgacch;
    }

    private BigDecimal schpell;

    @javax.persistence.Column(name = "SCHPELL")
    @Basic
    public BigDecimal getSchpell() {
        return schpell;
    }

    public void setSchpell(BigDecimal schpell) {
        this.schpell = schpell;
    }

    private int patrnnr;

    @javax.persistence.Column(name = "PATRNNR")
    @Basic
    public int getPatrnnr() {
        return patrnnr;
    }

    public void setPatrnnr(int patrnnr) {
        this.patrnnr = patrnnr;
    }

    private int paefc;

    @javax.persistence.Column(name = "PAEFC")
    @Basic
    public int getPaefc() {
        return paefc;
    }

    public void setPaefc(int paefc) {
        this.paefc = paefc;
    }

    private String pasefc;

    @javax.persistence.Column(name = "PASEFC")
    @Basic
    public String getPasefc() {
        return pasefc;
    }

    public void setPasefc(String pasefc) {
        this.pasefc = pasefc;
    }

    private int pacoa;

    @javax.persistence.Column(name = "PACOA")
    @Basic
    public int getPacoa() {
        return pacoa;
    }

    public void setPacoa(int pacoa) {
        this.pacoa = pacoa;
    }

    private String edrej;

    @javax.persistence.Column(name = "EDREJ")
    @Basic
    public String getEdrej() {
        return edrej;
    }

    public void setEdrej(String edrej) {
        this.edrej = edrej;
    }

    private String aedflag;

    @javax.persistence.Column(name = "AEDFLAG")
    @Basic
    public String getAedflag() {
        return aedflag;
    }

    public void setAedflag(String aedflag) {
        this.aedflag = aedflag;
    }

    private int drefn;

    @javax.persistence.Column(name = "DREFN")
    @Basic
    public int getDrefn() {
        return drefn;
    }

    public void setDrefn(int drefn) {
        this.drefn = drefn;
    }

    private BigDecimal damt;

    @javax.persistence.Column(name = "DAMT")
    @Basic
    public BigDecimal getDamt() {
        return damt;
    }

    public void setDamt(BigDecimal damt) {
        this.damt = damt;
    }

    private String ddate;

    @javax.persistence.Column(name = "DDATE")
    @Basic
    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    private int adrefn;

    @javax.persistence.Column(name = "ADREFN")
    @Basic
    public int getAdrefn() {
        return adrefn;
    }

    public void setAdrefn(int adrefn) {
        this.adrefn = adrefn;
    }

    private BigDecimal adamt;

    @javax.persistence.Column(name = "ADAMT")
    @Basic
    public BigDecimal getAdamt() {
        return adamt;
    }

    public void setAdamt(BigDecimal adamt) {
        this.adamt = adamt;
    }

    private String addate;

    @javax.persistence.Column(name = "ADDATE")
    @Basic
    public String getAddate() {
        return addate;
    }

    public void setAddate(String addate) {
        this.addate = addate;
    }

    private BigDecimal ytddamt;

    @javax.persistence.Column(name = "YTDDAMT")
    @Basic
    public BigDecimal getYtddamt() {
        return ytddamt;
    }

    public void setYtddamt(BigDecimal ytddamt) {
        this.ytddamt = ytddamt;
    }

    private String adedref;

    @javax.persistence.Column(name = "ADEDREF")
    @Basic
    public String getAdedref() {
        return adedref;
    }

    public void setAdedref(String adedref) {
        this.adedref = adedref;
    }

    private String adedflag;

    @javax.persistence.Column(name = "ADEDFLAG")
    @Basic
    public String getAdedflag() {
        return adedflag;
    }

    public void setAdedflag(String adedflag) {
        this.adedflag = adedflag;
    }

    private String pgsids;

    @javax.persistence.Column(name = "PGSIDS")
    @Basic
    public String getPgsids() {
        return pgsids;
    }

    public void setPgsids(String pgsids) {
        this.pgsids = pgsids;
    }

    private String pgidsfs;

    @javax.persistence.Column(name = "PGIDSFS")
    @Basic
    public String getPgidsfs() {
        return pgidsfs;
    }

    public void setPgidsfs(String pgidsfs) {
        this.pgidsfs = pgidsfs;
    }

    private String pgtrnrs;

    @javax.persistence.Column(name = "PGTRNRS")
    @Basic
    public String getPgtrnrs() {
        return pgtrnrs;
    }

    public void setPgtrnrs(String pgtrnrs) {
        this.pgtrnrs = pgtrnrs;
    }

    private String obeogis;

    @javax.persistence.Column(name = "OBEOGIS")
    @Basic
    public String getObeogis() {
        return obeogis;
    }

    public void setObeogis(String obeogis) {
        this.obeogis = obeogis;
    }

    private String seefcfs;

    @javax.persistence.Column(name = "SEEFCFS")
    @Basic
    public String getSeefcfs() {
        return seefcfs;
    }

    public void setSeefcfs(String seefcfs) {
        this.seefcfs = seefcfs;
    }

    private String instns;

    @javax.persistence.Column(name = "INSTNS")
    @Basic
    public String getInstns() {
        return instns;
    }

    public void setInstns(String instns) {
        this.instns = instns;
    }

    private String terms;

    @javax.persistence.Column(name = "TERMS")
    @Basic
    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    private String beobuds;

    @javax.persistence.Column(name = "BEOBUDS")
    @Basic
    public String getBeobuds() {
        return beobuds;
    }

    public void setBeobuds(String beobuds) {
        this.beobuds = beobuds;
    }

    private String pgvasts;

    @javax.persistence.Column(name = "PGVASTS")
    @Basic
    public String getPgvasts() {
        return pgvasts;
    }

    public void setPgvasts(String pgvasts) {
        this.pgvasts = pgvasts;
    }

    private String aenrlts;

    @javax.persistence.Column(name = "AENRLTS")
    @Basic
    public String getAenrlts() {
        return aenrlts;
    }

    public void setAenrlts(String aenrlts) {
        this.aenrlts = aenrlts;
    }

    private String pgawdcs;

    @javax.persistence.Column(name = "PGAWDCS")
    @Basic
    public String getPgawdcs() {
        return pgawdcs;
    }

    public void setPgawdcs(String pgawdcs) {
        this.pgawdcs = pgawdcs;
    }

    private String pgacchs;

    @javax.persistence.Column(name = "PGACCHS")
    @Basic
    public String getPgacchs() {
        return pgacchs;
    }

    public void setPgacchs(String pgacchs) {
        this.pgacchs = pgacchs;
    }

    private String aamtyrs;

    @javax.persistence.Column(name = "AAMTYRS")
    @Basic
    public String getAamtyrs() {
        return aamtyrs;
    }

    public void setAamtyrs(String aamtyrs) {
        this.aamtyrs = aamtyrs;
    }

    private String didt01S;

    @javax.persistence.Column(name = "DIDT01S")
    @Basic
    public String getDidt01S() {
        return didt01S;
    }

    public void setDidt01S(String didt01S) {
        this.didt01S = didt01S;
    }

    private String didt02S;

    @javax.persistence.Column(name = "DIDT02S")
    @Basic
    public String getDidt02S() {
        return didt02S;
    }

    public void setDidt02S(String didt02S) {
        this.didt02S = didt02S;
    }

    private String didt03S;

    @javax.persistence.Column(name = "DIDT03S")
    @Basic
    public String getDidt03S() {
        return didt03S;
    }

    public void setDidt03S(String didt03S) {
        this.didt03S = didt03S;
    }

    private String didt04S;

    @javax.persistence.Column(name = "DIDT04S")
    @Basic
    public String getDidt04S() {
        return didt04S;
    }

    public void setDidt04S(String didt04S) {
        this.didt04S = didt04S;
    }

    private String didt05S;

    @javax.persistence.Column(name = "DIDT05S")
    @Basic
    public String getDidt05S() {
        return didt05S;
    }

    public void setDidt05S(String didt05S) {
        this.didt05S = didt05S;
    }

    private String didt06S;

    @javax.persistence.Column(name = "DIDT06S")
    @Basic
    public String getDidt06S() {
        return didt06S;
    }

    public void setDidt06S(String didt06S) {
        this.didt06S = didt06S;
    }

    private String didt07S;

    @javax.persistence.Column(name = "DIDT07S")
    @Basic
    public String getDidt07S() {
        return didt07S;
    }

    public void setDidt07S(String didt07S) {
        this.didt07S = didt07S;
    }

    private String didt08S;

    @javax.persistence.Column(name = "DIDT08S")
    @Basic
    public String getDidt08S() {
        return didt08S;
    }

    public void setDidt08S(String didt08S) {
        this.didt08S = didt08S;
    }

    private String didt09S;

    @javax.persistence.Column(name = "DIDT09S")
    @Basic
    public String getDidt09S() {
        return didt09S;
    }

    public void setDidt09S(String didt09S) {
        this.didt09S = didt09S;
    }

    private String didt10S;

    @javax.persistence.Column(name = "DIDT10S")
    @Basic
    public String getDidt10S() {
        return didt10S;
    }

    public void setDidt10S(String didt10S) {
        this.didt10S = didt10S;
    }

    private String didt11S;

    @javax.persistence.Column(name = "DIDT11S")
    @Basic
    public String getDidt11S() {
        return didt11S;
    }

    public void setDidt11S(String didt11S) {
        this.didt11S = didt11S;
    }

    private String didt12S;

    @javax.persistence.Column(name = "DIDT12S")
    @Basic
    public String getDidt12S() {
        return didt12S;
    }

    public void setDidt12S(String didt12S) {
        this.didt12S = didt12S;
    }

    private String didt13S;

    @javax.persistence.Column(name = "DIDT13S")
    @Basic
    public String getDidt13S() {
        return didt13S;
    }

    public void setDidt13S(String didt13S) {
        this.didt13S = didt13S;
    }

    private String didt14S;

    @javax.persistence.Column(name = "DIDT14S")
    @Basic
    public String getDidt14S() {
        return didt14S;
    }

    public void setDidt14S(String didt14S) {
        this.didt14S = didt14S;
    }

    private String didt15S;

    @javax.persistence.Column(name = "DIDT15S")
    @Basic
    public String getDidt15S() {
        return didt15S;
    }

    public void setDidt15S(String didt15S) {
        this.didt15S = didt15S;
    }

    private String pmeths;

    @javax.persistence.Column(name = "PMETHS")
    @Basic
    public String getPmeths() {
        return pmeths;
    }

    public void setPmeths(String pmeths) {
        this.pmeths = pmeths;
    }

    private String incars;

    @javax.persistence.Column(name = "INCARS")
    @Basic
    public String getIncars() {
        return incars;
    }

    public void setIncars(String incars) {
        this.incars = incars;
    }

    private String begdtes;

    @javax.persistence.Column(name = "BEGDTES")
    @Basic
    public String getBegdtes() {
        return begdtes;
    }

    public void setBegdtes(String begdtes) {
        this.begdtes = begdtes;
    }

    private String wicps;

    @javax.persistence.Column(name = "WICPS")
    @Basic
    public String getWicps() {
        return wicps;
    }

    public void setWicps(String wicps) {
        this.wicps = wicps;
    }

    private String wpacys;

    @javax.persistence.Column(name = "WPACYS")
    @Basic
    public String getWpacys() {
        return wpacys;
    }

    public void setWpacys(String wpacys) {
        this.wpacys = wpacys;
    }

    private String ltuits;

    @javax.persistence.Column(name = "LTUITS")
    @Basic
    public String getLtuits() {
        return ltuits;
    }

    public void setLtuits(String ltuits) {
        this.ltuits = ltuits;
    }

    private String bthref;

    @javax.persistence.Column(name = "BTHREF")
    @Basic
    public String getBthref() {
        return bthref;
    }

    public void setBthref(String bthref) {
        this.bthref = bthref;
    }

    private String dactf;

    @javax.persistence.Column(name = "DACTF")
    @Basic
    public String getDactf() {
        return dactf;
    }

    public void setDactf(String dactf) {
        this.dactf = dactf;
    }

    private String lackdo;

    @javax.persistence.Column(name = "LACKDO")
    @Basic
    public String getLackdo() {
        return lackdo;
    }

    public void setLackdo(String lackdo) {
        this.lackdo = lackdo;
    }

    private String lchgdto;

    @javax.persistence.Column(name = "LCHGDTO")
    @Basic
    public String getLchgdto() {
        return lchgdto;
    }

    public void setLchgdto(String lchgdto) {
        this.lchgdto = lchgdto;
    }

    private String expf;

    @javax.persistence.Column(name = "EXPF")
    @Basic
    public String getExpf() {
        return expf;
    }

    public void setExpf(String expf) {
        this.expf = expf;
    }

    private String orgdate;

    @javax.persistence.Column(name = "ORGDATE")
    @Basic
    public String getOrgdate() {
        return orgdate;
    }

    public void setOrgdate(String orgdate) {
        this.orgdate = orgdate;
    }

    private int ainstn;

    @javax.persistence.Column(name = "AINSTN")
    @Basic
    public int getAinstn() {
        return ainstn;
    }

    public void setAinstn(int ainstn) {
        this.ainstn = ainstn;
    }

    private String rltuit;

    @javax.persistence.Column(name = "RLTUIT")
    @Basic
    public String getRltuit() {
        return rltuit;
    }

    public void setRltuit(String rltuit) {
        this.rltuit = rltuit;
    }

    private String raccal;

    @javax.persistence.Column(name = "RACCAL")
    @Basic
    public String getRaccal() {
        return raccal;
    }

    public void setRaccal(String raccal) {
        this.raccal = raccal;
    }

    private String rwicp;

    @javax.persistence.Column(name = "RWICP")
    @Basic
    public String getRwicp() {
        return rwicp;
    }

    public void setRwicp(String rwicp) {
        this.rwicp = rwicp;
    }

    private String rwpacy;

    @javax.persistence.Column(name = "RWPACY")
    @Basic
    public String getRwpacy() {
        return rwpacy;
    }

    public void setRwpacy(String rwpacy) {
        this.rwpacy = rwpacy;
    }

    private int rpgawch;

    @javax.persistence.Column(name = "RPGAWCH")
    @Basic
    public int getRpgawch() {
        return rpgawch;
    }

    public void setRpgawch(int rpgawch) {
        this.rpgawch = rpgawch;
    }

    private int rpgacch;

    @javax.persistence.Column(name = "RPGACCH")
    @Basic
    public int getRpgacch() {
        return rpgacch;
    }

    public void setRpgacch(int rpgacch) {
        this.rpgacch = rpgacch;
    }

    private int rinstn;

    @javax.persistence.Column(name = "RINSTN")
    @Basic
    public int getRinstn() {
        return rinstn;
    }

    public void setRinstn(int rinstn) {
        this.rinstn = rinstn;
    }

    private String rpmeth;

    @javax.persistence.Column(name = "RPMETH")
    @Basic
    public String getRpmeth() {
        return rpmeth;
    }

    public void setRpmeth(String rpmeth) {
        this.rpmeth = rpmeth;
    }

    private String rcnstat;

    @javax.persistence.Column(name = "RCNSTAT")
    @Basic
    public String getRcnstat() {
        return rcnstat;
    }

    public void setRcnstat(String rcnstat) {
        this.rcnstat = rcnstat;
    }

    private String rcndte;

    @javax.persistence.Column(name = "RCNDTE")
    @Basic
    public String getRcndte() {
        return rcndte;
    }

    public void setRcndte(String rcndte) {
        this.rcndte = rcndte;
    }

    private String rcnbtch;

    @javax.persistence.Column(name = "RCNBTCH")
    @Basic
    public String getRcnbtch() {
        return rcnbtch;
    }

    public void setRcnbtch(String rcnbtch) {
        this.rcnbtch = rcnbtch;
    }

    private String insseqn;

    @javax.persistence.Column(name = "INSSEQN")
    @Basic
    public String getInsseqn() {
        return insseqn;
    }

    public void setInsseqn(String insseqn) {
        this.insseqn = insseqn;
    }

    private String popflag;

    @javax.persistence.Column(name = "POPFLAG")
    @Basic
    public String getPopflag() {
        return popflag;
    }

    public void setPopflag(String popflag) {
        this.popflag = popflag;
    }

    private BigDecimal ngpamt;

    @javax.persistence.Column(name = "NGPAMT")
    @Basic
    public BigDecimal getNgpamt() {
        return ngpamt;
    }

    public void setNgpamt(BigDecimal ngpamt) {
        this.ngpamt = ngpamt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EorEntity eorEntity = (EorEntity) o;

        if (acoa != eorEntity.acoa) return false;
        if (adrefn != eorEntity.adrefn) return false;
        if (aefc != eorEntity.aefc) return false;
        if (ainstn != eorEntity.ainstn) return false;
        if (apgacch != eorEntity.apgacch) return false;
        if (apgawch != eorEntity.apgawch) return false;
        if (beogbud != eorEntity.beogbud) return false;
        if (drefn != eorEntity.drefn) return false;
        if (instn != eorEntity.instn) return false;
        if (obeogi != eorEntity.obeogi) return false;
        if (pacoa != eorEntity.pacoa) return false;
        if (paefc != eorEntity.paefc) return false;
        if (patrnnr != eorEntity.patrnnr) return false;
        if (pgacch != eorEntity.pgacch) return false;
        if (pgawdch != eorEntity.pgawdch) return false;
        if (revlev != eorEntity.revlev) return false;
        if (rinstn != eorEntity.rinstn) return false;
        if (rpgacch != eorEntity.rpgacch) return false;
        if (rpgawch != eorEntity.rpgawch) return false;
        if (aaamt != null ? !aaamt.equals(eorEntity.aaamt) : eorEntity.aaamt != null) return false;
        if (aaccal != null ? !aaccal.equals(eorEntity.aaccal) : eorEntity.aaccal != null) return false;
        if (aamtyr != null ? !aamtyr.equals(eorEntity.aamtyr) : eorEntity.aamtyr != null) return false;
        if (aamtyrs != null ? !aamtyrs.equals(eorEntity.aamtyrs) : eorEntity.aamtyrs != null) return false;
        if (action != null ? !action.equals(eorEntity.action) : eorEntity.action != null) return false;
        if (adamt != null ? !adamt.equals(eorEntity.adamt) : eorEntity.adamt != null) return false;
        if (addate != null ? !addate.equals(eorEntity.addate) : eorEntity.addate != null) return false;
        if (adedflag != null ? !adedflag.equals(eorEntity.adedflag) : eorEntity.adedflag != null) return false;
        if (adedref != null ? !adedref.equals(eorEntity.adedref) : eorEntity.adedref != null) return false;
        if (adisd01 != null ? !adisd01.equals(eorEntity.adisd01) : eorEntity.adisd01 != null) return false;
        if (adisd02 != null ? !adisd02.equals(eorEntity.adisd02) : eorEntity.adisd02 != null) return false;
        if (adisd03 != null ? !adisd03.equals(eorEntity.adisd03) : eorEntity.adisd03 != null) return false;
        if (adisd04 != null ? !adisd04.equals(eorEntity.adisd04) : eorEntity.adisd04 != null) return false;
        if (adisd05 != null ? !adisd05.equals(eorEntity.adisd05) : eorEntity.adisd05 != null) return false;
        if (adisd06 != null ? !adisd06.equals(eorEntity.adisd06) : eorEntity.adisd06 != null) return false;
        if (adisd07 != null ? !adisd07.equals(eorEntity.adisd07) : eorEntity.adisd07 != null) return false;
        if (adisd08 != null ? !adisd08.equals(eorEntity.adisd08) : eorEntity.adisd08 != null) return false;
        if (adisd09 != null ? !adisd09.equals(eorEntity.adisd09) : eorEntity.adisd09 != null) return false;
        if (adisd10 != null ? !adisd10.equals(eorEntity.adisd10) : eorEntity.adisd10 != null) return false;
        if (adisd11 != null ? !adisd11.equals(eorEntity.adisd11) : eorEntity.adisd11 != null) return false;
        if (adisd12 != null ? !adisd12.equals(eorEntity.adisd12) : eorEntity.adisd12 != null) return false;
        if (adisd13 != null ? !adisd13.equals(eorEntity.adisd13) : eorEntity.adisd13 != null) return false;
        if (adisd14 != null ? !adisd14.equals(eorEntity.adisd14) : eorEntity.adisd14 != null) return false;
        if (adisd15 != null ? !adisd15.equals(eorEntity.adisd15) : eorEntity.adisd15 != null) return false;
        if (aedflag != null ? !aedflag.equals(eorEntity.aedflag) : eorEntity.aedflag != null) return false;
        if (aenrdt != null ? !aenrdt.equals(eorEntity.aenrdt) : eorEntity.aenrdt != null) return false;
        if (aenrlt != null ? !aenrlt.equals(eorEntity.aenrlt) : eorEntity.aenrlt != null) return false;
        if (aenrlts != null ? !aenrlts.equals(eorEntity.aenrlts) : eorEntity.aenrlts != null) return false;
        if (aenrst != null ? !aenrst.equals(eorEntity.aenrst) : eorEntity.aenrst != null) return false;
        if (aidyr != null ? !aidyr.equals(eorEntity.aidyr) : eorEntity.aidyr != null) return false;
        if (aincar != null ? !aincar.equals(eorEntity.aincar) : eorEntity.aincar != null) return false;
        if (altuit != null ? !altuit.equals(eorEntity.altuit) : eorEntity.altuit != null) return false;
        if (apmeth != null ? !apmeth.equals(eorEntity.apmeth) : eorEntity.apmeth != null) return false;
        if (aptrnnr != null ? !aptrnnr.equals(eorEntity.aptrnnr) : eorEntity.aptrnnr != null) return false;
        if (apvalst != null ? !apvalst.equals(eorEntity.apvalst) : eorEntity.apvalst != null) return false;
        if (asefcf != null ? !asefcf.equals(eorEntity.asefcf) : eorEntity.asefcf != null) return false;
        if (awicp != null ? !awicp.equals(eorEntity.awicp) : eorEntity.awicp != null) return false;
        if (awpacy != null ? !awpacy.equals(eorEntity.awpacy) : eorEntity.awpacy != null) return false;
        if (begdate != null ? !begdate.equals(eorEntity.begdate) : eorEntity.begdate != null) return false;
        if (begdtes != null ? !begdtes.equals(eorEntity.begdtes) : eorEntity.begdtes != null) return false;
        if (beobuds != null ? !beobuds.equals(eorEntity.beobuds) : eorEntity.beobuds != null) return false;
        if (bthref != null ? !bthref.equals(eorEntity.bthref) : eorEntity.bthref != null) return false;
        if (crtdate != null ? !crtdate.equals(eorEntity.crtdate) : eorEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(eorEntity.crtmod) : eorEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(eorEntity.crttime) : eorEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(eorEntity.crtuser) : eorEntity.crtuser != null) return false;
        if (dactf != null ? !dactf.equals(eorEntity.dactf) : eorEntity.dactf != null) return false;
        if (damt != null ? !damt.equals(eorEntity.damt) : eorEntity.damt != null) return false;
        if (ddate != null ? !ddate.equals(eorEntity.ddate) : eorEntity.ddate != null) return false;
        if (didt01S != null ? !didt01S.equals(eorEntity.didt01S) : eorEntity.didt01S != null) return false;
        if (didt02S != null ? !didt02S.equals(eorEntity.didt02S) : eorEntity.didt02S != null) return false;
        if (didt03S != null ? !didt03S.equals(eorEntity.didt03S) : eorEntity.didt03S != null) return false;
        if (didt04S != null ? !didt04S.equals(eorEntity.didt04S) : eorEntity.didt04S != null) return false;
        if (didt05S != null ? !didt05S.equals(eorEntity.didt05S) : eorEntity.didt05S != null) return false;
        if (didt06S != null ? !didt06S.equals(eorEntity.didt06S) : eorEntity.didt06S != null) return false;
        if (didt07S != null ? !didt07S.equals(eorEntity.didt07S) : eorEntity.didt07S != null) return false;
        if (didt08S != null ? !didt08S.equals(eorEntity.didt08S) : eorEntity.didt08S != null) return false;
        if (didt09S != null ? !didt09S.equals(eorEntity.didt09S) : eorEntity.didt09S != null) return false;
        if (didt10S != null ? !didt10S.equals(eorEntity.didt10S) : eorEntity.didt10S != null) return false;
        if (didt11S != null ? !didt11S.equals(eorEntity.didt11S) : eorEntity.didt11S != null) return false;
        if (didt12S != null ? !didt12S.equals(eorEntity.didt12S) : eorEntity.didt12S != null) return false;
        if (didt13S != null ? !didt13S.equals(eorEntity.didt13S) : eorEntity.didt13S != null) return false;
        if (didt14S != null ? !didt14S.equals(eorEntity.didt14S) : eorEntity.didt14S != null) return false;
        if (didt15S != null ? !didt15S.equals(eorEntity.didt15S) : eorEntity.didt15S != null) return false;
        if (disdt01 != null ? !disdt01.equals(eorEntity.disdt01) : eorEntity.disdt01 != null) return false;
        if (disdt02 != null ? !disdt02.equals(eorEntity.disdt02) : eorEntity.disdt02 != null) return false;
        if (disdt03 != null ? !disdt03.equals(eorEntity.disdt03) : eorEntity.disdt03 != null) return false;
        if (disdt04 != null ? !disdt04.equals(eorEntity.disdt04) : eorEntity.disdt04 != null) return false;
        if (disdt05 != null ? !disdt05.equals(eorEntity.disdt05) : eorEntity.disdt05 != null) return false;
        if (disdt06 != null ? !disdt06.equals(eorEntity.disdt06) : eorEntity.disdt06 != null) return false;
        if (disdt07 != null ? !disdt07.equals(eorEntity.disdt07) : eorEntity.disdt07 != null) return false;
        if (disdt08 != null ? !disdt08.equals(eorEntity.disdt08) : eorEntity.disdt08 != null) return false;
        if (disdt09 != null ? !disdt09.equals(eorEntity.disdt09) : eorEntity.disdt09 != null) return false;
        if (disdt10 != null ? !disdt10.equals(eorEntity.disdt10) : eorEntity.disdt10 != null) return false;
        if (disdt11 != null ? !disdt11.equals(eorEntity.disdt11) : eorEntity.disdt11 != null) return false;
        if (disdt12 != null ? !disdt12.equals(eorEntity.disdt12) : eorEntity.disdt12 != null) return false;
        if (disdt13 != null ? !disdt13.equals(eorEntity.disdt13) : eorEntity.disdt13 != null) return false;
        if (disdt14 != null ? !disdt14.equals(eorEntity.disdt14) : eorEntity.disdt14 != null) return false;
        if (disdt15 != null ? !disdt15.equals(eorEntity.disdt15) : eorEntity.disdt15 != null) return false;
        if (edrej != null ? !edrej.equals(eorEntity.edrej) : eorEntity.edrej != null) return false;
        if (eorkey != null ? !eorkey.equals(eorEntity.eorkey) : eorEntity.eorkey != null) return false;
        if (expf != null ? !expf.equals(eorEntity.expf) : eorEntity.expf != null) return false;
        if (incar != null ? !incar.equals(eorEntity.incar) : eorEntity.incar != null) return false;
        if (incars != null ? !incars.equals(eorEntity.incars) : eorEntity.incars != null) return false;
        if (insseqn != null ? !insseqn.equals(eorEntity.insseqn) : eorEntity.insseqn != null) return false;
        if (instid != null ? !instid.equals(eorEntity.instid) : eorEntity.instid != null) return false;
        if (instns != null ? !instns.equals(eorEntity.instns) : eorEntity.instns != null) return false;
        if (lackdo != null ? !lackdo.equals(eorEntity.lackdo) : eorEntity.lackdo != null) return false;
        if (lchgdto != null ? !lchgdto.equals(eorEntity.lchgdto) : eorEntity.lchgdto != null) return false;
        if (ltuit != null ? !ltuit.equals(eorEntity.ltuit) : eorEntity.ltuit != null) return false;
        if (ltuits != null ? !ltuits.equals(eorEntity.ltuits) : eorEntity.ltuits != null) return false;
        if (ngpamt != null ? !ngpamt.equals(eorEntity.ngpamt) : eorEntity.ngpamt != null) return false;
        if (obeogis != null ? !obeogis.equals(eorEntity.obeogis) : eorEntity.obeogis != null) return false;
        if (orgdate != null ? !orgdate.equals(eorEntity.orgdate) : eorEntity.orgdate != null) return false;
        if (pasefc != null ? !pasefc.equals(eorEntity.pasefc) : eorEntity.pasefc != null) return false;
        if (pgacchs != null ? !pgacchs.equals(eorEntity.pgacchs) : eorEntity.pgacchs != null) return false;
        if (pgawdcs != null ? !pgawdcs.equals(eorEntity.pgawdcs) : eorEntity.pgawdcs != null) return false;
        if (pgidsf != null ? !pgidsf.equals(eorEntity.pgidsf) : eorEntity.pgidsf != null) return false;
        if (pgidsfs != null ? !pgidsfs.equals(eorEntity.pgidsfs) : eorEntity.pgidsfs != null) return false;
        if (pgsid != null ? !pgsid.equals(eorEntity.pgsid) : eorEntity.pgsid != null) return false;
        if (pgsids != null ? !pgsids.equals(eorEntity.pgsids) : eorEntity.pgsids != null) return false;
        if (pgtrnnr != null ? !pgtrnnr.equals(eorEntity.pgtrnnr) : eorEntity.pgtrnnr != null) return false;
        if (pgtrnrs != null ? !pgtrnrs.equals(eorEntity.pgtrnrs) : eorEntity.pgtrnrs != null) return false;
        if (pgvalst != null ? !pgvalst.equals(eorEntity.pgvalst) : eorEntity.pgvalst != null) return false;
        if (pgvasts != null ? !pgvasts.equals(eorEntity.pgvasts) : eorEntity.pgvasts != null) return false;
        if (pmeth != null ? !pmeth.equals(eorEntity.pmeth) : eorEntity.pmeth != null) return false;
        if (pmeths != null ? !pmeths.equals(eorEntity.pmeths) : eorEntity.pmeths != null) return false;
        if (popflag != null ? !popflag.equals(eorEntity.popflag) : eorEntity.popflag != null) return false;
        if (raccal != null ? !raccal.equals(eorEntity.raccal) : eorEntity.raccal != null) return false;
        if (rcnbtch != null ? !rcnbtch.equals(eorEntity.rcnbtch) : eorEntity.rcnbtch != null) return false;
        if (rcndte != null ? !rcndte.equals(eorEntity.rcndte) : eorEntity.rcndte != null) return false;
        if (rcnstat != null ? !rcnstat.equals(eorEntity.rcnstat) : eorEntity.rcnstat != null) return false;
        if (recstat != null ? !recstat.equals(eorEntity.recstat) : eorEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(eorEntity.revdate) : eorEntity.revdate != null) return false;
        if (revmod != null ? !revmod.equals(eorEntity.revmod) : eorEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(eorEntity.revtime) : eorEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(eorEntity.revuser) : eorEntity.revuser != null) return false;
        if (rltuit != null ? !rltuit.equals(eorEntity.rltuit) : eorEntity.rltuit != null) return false;
        if (rpmeth != null ? !rpmeth.equals(eorEntity.rpmeth) : eorEntity.rpmeth != null) return false;
        if (rwicp != null ? !rwicp.equals(eorEntity.rwicp) : eorEntity.rwicp != null) return false;
        if (rwpacy != null ? !rwpacy.equals(eorEntity.rwpacy) : eorEntity.rwpacy != null) return false;
        if (schpell != null ? !schpell.equals(eorEntity.schpell) : eorEntity.schpell != null) return false;
        if (secefcf != null ? !secefcf.equals(eorEntity.secefcf) : eorEntity.secefcf != null) return false;
        if (seefcfs != null ? !seefcfs.equals(eorEntity.seefcfs) : eorEntity.seefcfs != null) return false;
        if (sid != null ? !sid.equals(eorEntity.sid) : eorEntity.sid != null) return false;
        if (term != null ? !term.equals(eorEntity.term) : eorEntity.term != null) return false;
        if (terms != null ? !terms.equals(eorEntity.terms) : eorEntity.terms != null) return false;
        if (ucode != null ? !ucode.equals(eorEntity.ucode) : eorEntity.ucode != null) return false;
        if (wicp != null ? !wicp.equals(eorEntity.wicp) : eorEntity.wicp != null) return false;
        if (wicps != null ? !wicps.equals(eorEntity.wicps) : eorEntity.wicps != null) return false;
        if (wpacy != null ? !wpacy.equals(eorEntity.wpacy) : eorEntity.wpacy != null) return false;
        if (wpacys != null ? !wpacys.equals(eorEntity.wpacys) : eorEntity.wpacys != null) return false;
        if (ytddamt != null ? !ytddamt.equals(eorEntity.ytddamt) : eorEntity.ytddamt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (eorkey != null ? eorkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
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
        result = 31 * result + (pgsid != null ? pgsid.hashCode() : 0);
        result = 31 * result + (pgidsf != null ? pgidsf.hashCode() : 0);
        result = 31 * result + (pgtrnnr != null ? pgtrnnr.hashCode() : 0);
        result = 31 * result + obeogi;
        result = 31 * result + (secefcf != null ? secefcf.hashCode() : 0);
        result = 31 * result + instn;
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + beogbud;
        result = 31 * result + (pgvalst != null ? pgvalst.hashCode() : 0);
        result = 31 * result + (aenrlt != null ? aenrlt.hashCode() : 0);
        result = 31 * result + pgawdch;
        result = 31 * result + pgacch;
        result = 31 * result + (aamtyr != null ? aamtyr.hashCode() : 0);
        result = 31 * result + (disdt01 != null ? disdt01.hashCode() : 0);
        result = 31 * result + (disdt02 != null ? disdt02.hashCode() : 0);
        result = 31 * result + (disdt03 != null ? disdt03.hashCode() : 0);
        result = 31 * result + (disdt04 != null ? disdt04.hashCode() : 0);
        result = 31 * result + (disdt05 != null ? disdt05.hashCode() : 0);
        result = 31 * result + (disdt06 != null ? disdt06.hashCode() : 0);
        result = 31 * result + (disdt07 != null ? disdt07.hashCode() : 0);
        result = 31 * result + (disdt08 != null ? disdt08.hashCode() : 0);
        result = 31 * result + (disdt09 != null ? disdt09.hashCode() : 0);
        result = 31 * result + (disdt10 != null ? disdt10.hashCode() : 0);
        result = 31 * result + (disdt11 != null ? disdt11.hashCode() : 0);
        result = 31 * result + (disdt12 != null ? disdt12.hashCode() : 0);
        result = 31 * result + (disdt13 != null ? disdt13.hashCode() : 0);
        result = 31 * result + (disdt14 != null ? disdt14.hashCode() : 0);
        result = 31 * result + (disdt15 != null ? disdt15.hashCode() : 0);
        result = 31 * result + (pmeth != null ? pmeth.hashCode() : 0);
        result = 31 * result + (incar != null ? incar.hashCode() : 0);
        result = 31 * result + (begdate != null ? begdate.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (wicp != null ? wicp.hashCode() : 0);
        result = 31 * result + (wpacy != null ? wpacy.hashCode() : 0);
        result = 31 * result + (ltuit != null ? ltuit.hashCode() : 0);
        result = 31 * result + (aaamt != null ? aaamt.hashCode() : 0);
        result = 31 * result + (adisd01 != null ? adisd01.hashCode() : 0);
        result = 31 * result + (adisd02 != null ? adisd02.hashCode() : 0);
        result = 31 * result + (adisd03 != null ? adisd03.hashCode() : 0);
        result = 31 * result + (adisd04 != null ? adisd04.hashCode() : 0);
        result = 31 * result + (adisd05 != null ? adisd05.hashCode() : 0);
        result = 31 * result + (adisd06 != null ? adisd06.hashCode() : 0);
        result = 31 * result + (adisd07 != null ? adisd07.hashCode() : 0);
        result = 31 * result + (adisd08 != null ? adisd08.hashCode() : 0);
        result = 31 * result + (adisd09 != null ? adisd09.hashCode() : 0);
        result = 31 * result + (adisd10 != null ? adisd10.hashCode() : 0);
        result = 31 * result + (adisd11 != null ? adisd11.hashCode() : 0);
        result = 31 * result + (adisd12 != null ? adisd12.hashCode() : 0);
        result = 31 * result + (adisd13 != null ? adisd13.hashCode() : 0);
        result = 31 * result + (adisd14 != null ? adisd14.hashCode() : 0);
        result = 31 * result + (adisd15 != null ? adisd15.hashCode() : 0);
        result = 31 * result + (aenrdt != null ? aenrdt.hashCode() : 0);
        result = 31 * result + (altuit != null ? altuit.hashCode() : 0);
        result = 31 * result + (apvalst != null ? apvalst.hashCode() : 0);
        result = 31 * result + (aincar != null ? aincar.hashCode() : 0);
        result = 31 * result + (aptrnnr != null ? aptrnnr.hashCode() : 0);
        result = 31 * result + aefc;
        result = 31 * result + (asefcf != null ? asefcf.hashCode() : 0);
        result = 31 * result + (aaccal != null ? aaccal.hashCode() : 0);
        result = 31 * result + (apmeth != null ? apmeth.hashCode() : 0);
        result = 31 * result + acoa;
        result = 31 * result + (aenrst != null ? aenrst.hashCode() : 0);
        result = 31 * result + (awicp != null ? awicp.hashCode() : 0);
        result = 31 * result + (awpacy != null ? awpacy.hashCode() : 0);
        result = 31 * result + apgawch;
        result = 31 * result + apgacch;
        result = 31 * result + (schpell != null ? schpell.hashCode() : 0);
        result = 31 * result + patrnnr;
        result = 31 * result + paefc;
        result = 31 * result + (pasefc != null ? pasefc.hashCode() : 0);
        result = 31 * result + pacoa;
        result = 31 * result + (edrej != null ? edrej.hashCode() : 0);
        result = 31 * result + (aedflag != null ? aedflag.hashCode() : 0);
        result = 31 * result + drefn;
        result = 31 * result + (damt != null ? damt.hashCode() : 0);
        result = 31 * result + (ddate != null ? ddate.hashCode() : 0);
        result = 31 * result + adrefn;
        result = 31 * result + (adamt != null ? adamt.hashCode() : 0);
        result = 31 * result + (addate != null ? addate.hashCode() : 0);
        result = 31 * result + (ytddamt != null ? ytddamt.hashCode() : 0);
        result = 31 * result + (adedref != null ? adedref.hashCode() : 0);
        result = 31 * result + (adedflag != null ? adedflag.hashCode() : 0);
        result = 31 * result + (pgsids != null ? pgsids.hashCode() : 0);
        result = 31 * result + (pgidsfs != null ? pgidsfs.hashCode() : 0);
        result = 31 * result + (pgtrnrs != null ? pgtrnrs.hashCode() : 0);
        result = 31 * result + (obeogis != null ? obeogis.hashCode() : 0);
        result = 31 * result + (seefcfs != null ? seefcfs.hashCode() : 0);
        result = 31 * result + (instns != null ? instns.hashCode() : 0);
        result = 31 * result + (terms != null ? terms.hashCode() : 0);
        result = 31 * result + (beobuds != null ? beobuds.hashCode() : 0);
        result = 31 * result + (pgvasts != null ? pgvasts.hashCode() : 0);
        result = 31 * result + (aenrlts != null ? aenrlts.hashCode() : 0);
        result = 31 * result + (pgawdcs != null ? pgawdcs.hashCode() : 0);
        result = 31 * result + (pgacchs != null ? pgacchs.hashCode() : 0);
        result = 31 * result + (aamtyrs != null ? aamtyrs.hashCode() : 0);
        result = 31 * result + (didt01S != null ? didt01S.hashCode() : 0);
        result = 31 * result + (didt02S != null ? didt02S.hashCode() : 0);
        result = 31 * result + (didt03S != null ? didt03S.hashCode() : 0);
        result = 31 * result + (didt04S != null ? didt04S.hashCode() : 0);
        result = 31 * result + (didt05S != null ? didt05S.hashCode() : 0);
        result = 31 * result + (didt06S != null ? didt06S.hashCode() : 0);
        result = 31 * result + (didt07S != null ? didt07S.hashCode() : 0);
        result = 31 * result + (didt08S != null ? didt08S.hashCode() : 0);
        result = 31 * result + (didt09S != null ? didt09S.hashCode() : 0);
        result = 31 * result + (didt10S != null ? didt10S.hashCode() : 0);
        result = 31 * result + (didt11S != null ? didt11S.hashCode() : 0);
        result = 31 * result + (didt12S != null ? didt12S.hashCode() : 0);
        result = 31 * result + (didt13S != null ? didt13S.hashCode() : 0);
        result = 31 * result + (didt14S != null ? didt14S.hashCode() : 0);
        result = 31 * result + (didt15S != null ? didt15S.hashCode() : 0);
        result = 31 * result + (pmeths != null ? pmeths.hashCode() : 0);
        result = 31 * result + (incars != null ? incars.hashCode() : 0);
        result = 31 * result + (begdtes != null ? begdtes.hashCode() : 0);
        result = 31 * result + (wicps != null ? wicps.hashCode() : 0);
        result = 31 * result + (wpacys != null ? wpacys.hashCode() : 0);
        result = 31 * result + (ltuits != null ? ltuits.hashCode() : 0);
        result = 31 * result + (bthref != null ? bthref.hashCode() : 0);
        result = 31 * result + (dactf != null ? dactf.hashCode() : 0);
        result = 31 * result + (lackdo != null ? lackdo.hashCode() : 0);
        result = 31 * result + (lchgdto != null ? lchgdto.hashCode() : 0);
        result = 31 * result + (expf != null ? expf.hashCode() : 0);
        result = 31 * result + (orgdate != null ? orgdate.hashCode() : 0);
        result = 31 * result + ainstn;
        result = 31 * result + (rltuit != null ? rltuit.hashCode() : 0);
        result = 31 * result + (raccal != null ? raccal.hashCode() : 0);
        result = 31 * result + (rwicp != null ? rwicp.hashCode() : 0);
        result = 31 * result + (rwpacy != null ? rwpacy.hashCode() : 0);
        result = 31 * result + rpgawch;
        result = 31 * result + rpgacch;
        result = 31 * result + rinstn;
        result = 31 * result + (rpmeth != null ? rpmeth.hashCode() : 0);
        result = 31 * result + (rcnstat != null ? rcnstat.hashCode() : 0);
        result = 31 * result + (rcndte != null ? rcndte.hashCode() : 0);
        result = 31 * result + (rcnbtch != null ? rcnbtch.hashCode() : 0);
        result = 31 * result + (insseqn != null ? insseqn.hashCode() : 0);
        result = 31 * result + (popflag != null ? popflag.hashCode() : 0);
        result = 31 * result + (ngpamt != null ? ngpamt.hashCode() : 0);
        return result;
    }
}
