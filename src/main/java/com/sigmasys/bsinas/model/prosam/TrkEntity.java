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
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "TRK", schema = "SIGMA", catalog = "")
@Entity
public class TrkEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getTrkkey();
    }

    private String trkkey;

    @javax.persistence.Column(name = "TRKKEY")
    @Id
    public String getTrkkey() {
        return trkkey;
    }

    public void setTrkkey(String trkkey) {
        this.trkkey = trkkey;
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

    private String rectype;

    @javax.persistence.Column(name = "RECTYPE")
    @Basic
    public String getRectype() {
        return rectype;
    }

    public void setRectype(String rectype) {
        this.rectype = rectype;
    }

    private String stype;

    @javax.persistence.Column(name = "STYPE")
    @Basic
    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    private String sfaappc;

    @javax.persistence.Column(name = "SFAAPPC")
    @Basic
    public String getSfaappc() {
        return sfaappc;
    }

    public void setSfaappc(String sfaappc) {
        this.sfaappc = sfaappc;
    }

    private String folow1C;

    @javax.persistence.Column(name = "FOLOW1C")
    @Basic
    public String getFolow1C() {
        return folow1C;
    }

    public void setFolow1C(String folow1C) {
        this.folow1C = folow1C;
    }

    private String folow2C;

    @javax.persistence.Column(name = "FOLOW2C")
    @Basic
    public String getFolow2C() {
        return folow2C;
    }

    public void setFolow2C(String folow2C) {
        this.folow2C = folow2C;
    }

    private String folow3C;

    @javax.persistence.Column(name = "FOLOW3C")
    @Basic
    public String getFolow3C() {
        return folow3C;
    }

    public void setFolow3C(String folow3C) {
        this.folow3C = folow3C;
    }

    private String screndc;

    @javax.persistence.Column(name = "SCRENDC")
    @Basic
    public String getScrendc() {
        return screndc;
    }

    public void setScrendc(String screndc) {
        this.screndc = screndc;
    }

    private String track;

    @javax.persistence.Column(name = "TRACK")
    @Basic
    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    private String ttype;

    @javax.persistence.Column(name = "TTYPE")
    @Basic
    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    private String htrack;

    @javax.persistence.Column(name = "HTRACK")
    @Basic
    public String getHtrack() {
        return htrack;
    }

    public void setHtrack(String htrack) {
        this.htrack = htrack;
    }

    private String appcmpc;

    @javax.persistence.Column(name = "APPCMPC")
    @Basic
    public String getAppcmpc() {
        return appcmpc;
    }

    public void setAppcmpc(String appcmpc) {
        this.appcmpc = appcmpc;
    }

    private String filcmpc;

    @javax.persistence.Column(name = "FILCMPC")
    @Basic
    public String getFilcmpc() {
        return filcmpc;
    }

    public void setFilcmpc(String filcmpc) {
        this.filcmpc = filcmpc;
    }

    private String actstat;

    @javax.persistence.Column(name = "ACTSTAT")
    @Basic
    public String getActstat() {
        return actstat;
    }

    public void setActstat(String actstat) {
        this.actstat = actstat;
    }

    private String admstat;

    @javax.persistence.Column(name = "ADMSTAT")
    @Basic
    public String getAdmstat() {
        return admstat;
    }

    public void setAdmstat(String admstat) {
        this.admstat = admstat;
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

    private String appbegc;

    @javax.persistence.Column(name = "APPBEGC")
    @Basic
    public String getAppbegc() {
        return appbegc;
    }

    public void setAppbegc(String appbegc) {
        this.appbegc = appbegc;
    }

    private String appendc;

    @javax.persistence.Column(name = "APPENDC")
    @Basic
    public String getAppendc() {
        return appendc;
    }

    public void setAppendc(String appendc) {
        this.appendc = appendc;
    }

    private String campus1;

    @javax.persistence.Column(name = "CAMPUS1")
    @Basic
    public String getCampus1() {
        return campus1;
    }

    public void setCampus1(String campus1) {
        this.campus1 = campus1;
    }

    private String campus2;

    @javax.persistence.Column(name = "CAMPUS2")
    @Basic
    public String getCampus2() {
        return campus2;
    }

    public void setCampus2(String campus2) {
        this.campus2 = campus2;
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

    private String pschool;

    @javax.persistence.Column(name = "PSCHOOL")
    @Basic
    public String getPschool() {
        return pschool;
    }

    public void setPschool(String pschool) {
        this.pschool = pschool;
    }

    private String yrinsch;

    @javax.persistence.Column(name = "YRINSCH")
    @Basic
    public String getYrinsch() {
        return yrinsch;
    }

    public void setYrinsch(String yrinsch) {
        this.yrinsch = yrinsch;
    }

    private String aidpre1;

    @javax.persistence.Column(name = "AIDPRE1")
    @Basic
    public String getAidpre1() {
        return aidpre1;
    }

    public void setAidpre1(String aidpre1) {
        this.aidpre1 = aidpre1;
    }

    private String aidpre2;

    @javax.persistence.Column(name = "AIDPRE2")
    @Basic
    public String getAidpre2() {
        return aidpre2;
    }

    public void setAidpre2(String aidpre2) {
        this.aidpre2 = aidpre2;
    }

    private String aidpre3;

    @javax.persistence.Column(name = "AIDPRE3")
    @Basic
    public String getAidpre3() {
        return aidpre3;
    }

    public void setAidpre3(String aidpre3) {
        this.aidpre3 = aidpre3;
    }

    private BigInteger sexempt;

    @javax.persistence.Column(name = "SEXEMPT")
    @Basic
    public BigInteger getSexempt() {
        return sexempt;
    }

    public void setSexempt(BigInteger sexempt) {
        this.sexempt = sexempt;
    }

    private int sadjgro;

    @javax.persistence.Column(name = "SADJGRO")
    @Basic
    public int getSadjgro() {
        return sadjgro;
    }

    public void setSadjgro(int sadjgro) {
        this.sadjgro = sadjgro;
    }

    private BigInteger pexempt;

    @javax.persistence.Column(name = "PEXEMPT")
    @Basic
    public BigInteger getPexempt() {
        return pexempt;
    }

    public void setPexempt(BigInteger pexempt) {
        this.pexempt = pexempt;
    }

    private int padjgro;

    @javax.persistence.Column(name = "PADJGRO")
    @Basic
    public int getPadjgro() {
        return padjgro;
    }

    public void setPadjgro(int padjgro) {
        this.padjgro = padjgro;
    }

    private String tdte01C;

    @javax.persistence.Column(name = "TDTE01C")
    @Basic
    public String getTdte01C() {
        return tdte01C;
    }

    public void setTdte01C(String tdte01C) {
        this.tdte01C = tdte01C;
    }

    private String tdte02C;

    @javax.persistence.Column(name = "TDTE02C")
    @Basic
    public String getTdte02C() {
        return tdte02C;
    }

    public void setTdte02C(String tdte02C) {
        this.tdte02C = tdte02C;
    }

    private String tdte03C;

    @javax.persistence.Column(name = "TDTE03C")
    @Basic
    public String getTdte03C() {
        return tdte03C;
    }

    public void setTdte03C(String tdte03C) {
        this.tdte03C = tdte03C;
    }

    private String tdte04C;

    @javax.persistence.Column(name = "TDTE04C")
    @Basic
    public String getTdte04C() {
        return tdte04C;
    }

    public void setTdte04C(String tdte04C) {
        this.tdte04C = tdte04C;
    }

    private String tdte05C;

    @javax.persistence.Column(name = "TDTE05C")
    @Basic
    public String getTdte05C() {
        return tdte05C;
    }

    public void setTdte05C(String tdte05C) {
        this.tdte05C = tdte05C;
    }

    private String tdte06C;

    @javax.persistence.Column(name = "TDTE06C")
    @Basic
    public String getTdte06C() {
        return tdte06C;
    }

    public void setTdte06C(String tdte06C) {
        this.tdte06C = tdte06C;
    }

    private String tdte07C;

    @javax.persistence.Column(name = "TDTE07C")
    @Basic
    public String getTdte07C() {
        return tdte07C;
    }

    public void setTdte07C(String tdte07C) {
        this.tdte07C = tdte07C;
    }

    private String tdte08C;

    @javax.persistence.Column(name = "TDTE08C")
    @Basic
    public String getTdte08C() {
        return tdte08C;
    }

    public void setTdte08C(String tdte08C) {
        this.tdte08C = tdte08C;
    }

    private String tdte09C;

    @javax.persistence.Column(name = "TDTE09C")
    @Basic
    public String getTdte09C() {
        return tdte09C;
    }

    public void setTdte09C(String tdte09C) {
        this.tdte09C = tdte09C;
    }

    private String tdte10C;

    @javax.persistence.Column(name = "TDTE10C")
    @Basic
    public String getTdte10C() {
        return tdte10C;
    }

    public void setTdte10C(String tdte10C) {
        this.tdte10C = tdte10C;
    }

    private String tdte11C;

    @javax.persistence.Column(name = "TDTE11C")
    @Basic
    public String getTdte11C() {
        return tdte11C;
    }

    public void setTdte11C(String tdte11C) {
        this.tdte11C = tdte11C;
    }

    private String tdte12C;

    @javax.persistence.Column(name = "TDTE12C")
    @Basic
    public String getTdte12C() {
        return tdte12C;
    }

    public void setTdte12C(String tdte12C) {
        this.tdte12C = tdte12C;
    }

    private String tdte13C;

    @javax.persistence.Column(name = "TDTE13C")
    @Basic
    public String getTdte13C() {
        return tdte13C;
    }

    public void setTdte13C(String tdte13C) {
        this.tdte13C = tdte13C;
    }

    private String tdte14C;

    @javax.persistence.Column(name = "TDTE14C")
    @Basic
    public String getTdte14C() {
        return tdte14C;
    }

    public void setTdte14C(String tdte14C) {
        this.tdte14C = tdte14C;
    }

    private String tdte15C;

    @javax.persistence.Column(name = "TDTE15C")
    @Basic
    public String getTdte15C() {
        return tdte15C;
    }

    public void setTdte15C(String tdte15C) {
        this.tdte15C = tdte15C;
    }

    private String atype1;

    @javax.persistence.Column(name = "ATYPE1")
    @Basic
    public String getAtype1() {
        return atype1;
    }

    public void setAtype1(String atype1) {
        this.atype1 = atype1;
    }

    private String adate1C;

    @javax.persistence.Column(name = "ADATE1C")
    @Basic
    public String getAdate1C() {
        return adate1C;
    }

    public void setAdate1C(String adate1C) {
        this.adate1C = adate1C;
    }

    private String atype2;

    @javax.persistence.Column(name = "ATYPE2")
    @Basic
    public String getAtype2() {
        return atype2;
    }

    public void setAtype2(String atype2) {
        this.atype2 = atype2;
    }

    private String adate2C;

    @javax.persistence.Column(name = "ADATE2C")
    @Basic
    public String getAdate2C() {
        return adate2C;
    }

    public void setAdate2C(String adate2C) {
        this.adate2C = adate2C;
    }

    private String atype3;

    @javax.persistence.Column(name = "ATYPE3")
    @Basic
    public String getAtype3() {
        return atype3;
    }

    public void setAtype3(String atype3) {
        this.atype3 = atype3;
    }

    private String adate3C;

    @javax.persistence.Column(name = "ADATE3C")
    @Basic
    public String getAdate3C() {
        return adate3C;
    }

    public void setAdate3C(String adate3C) {
        this.adate3C = adate3C;
    }

    private String atype4;

    @javax.persistence.Column(name = "ATYPE4")
    @Basic
    public String getAtype4() {
        return atype4;
    }

    public void setAtype4(String atype4) {
        this.atype4 = atype4;
    }

    private String adate4C;

    @javax.persistence.Column(name = "ADATE4C")
    @Basic
    public String getAdate4C() {
        return adate4C;
    }

    public void setAdate4C(String adate4C) {
        this.adate4C = adate4C;
    }

    private String atype5;

    @javax.persistence.Column(name = "ATYPE5")
    @Basic
    public String getAtype5() {
        return atype5;
    }

    public void setAtype5(String atype5) {
        this.atype5 = atype5;
    }

    private String adate5C;

    @javax.persistence.Column(name = "ADATE5C")
    @Basic
    public String getAdate5C() {
        return adate5C;
    }

    public void setAdate5C(String adate5C) {
        this.adate5C = adate5C;
    }

    private String procntr;

    @javax.persistence.Column(name = "PROCNTR")
    @Basic
    public String getProcntr() {
        return procntr;
    }

    public void setProcntr(String procntr) {
        this.procntr = procntr;
    }

    private String sam;

    @javax.persistence.Column(name = "SAM")
    @Basic
    public String getSam() {
        return sam;
    }

    public void setSam(String sam) {
        this.sam = sam;
    }

    private String trckclr;

    @javax.persistence.Column(name = "TRCKCLR")
    @Basic
    public String getTrckclr() {
        return trckclr;
    }

    public void setTrckclr(String trckclr) {
        this.trckclr = trckclr;
    }

    private String revdtec;

    @javax.persistence.Column(name = "REVDTEC")
    @Basic
    public String getRevdtec() {
        return revdtec;
    }

    public void setRevdtec(String revdtec) {
        this.revdtec = revdtec;
    }

    private BigInteger revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public BigInteger getRevlev() {
        return revlev;
    }

    public void setRevlev(BigInteger revlev) {
        this.revlev = revlev;
    }

    private String syscode;

    @javax.persistence.Column(name = "SYSCODE")
    @Basic
    public String getSyscode() {
        return syscode;
    }

    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }

    private String sitime;

    @javax.persistence.Column(name = "SITIME")
    @Basic
    public String getSitime() {
        return sitime;
    }

    public void setSitime(String sitime) {
        this.sitime = sitime;
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

    private String yrpurhm;

    @javax.persistence.Column(name = "YRPURHM")
    @Basic
    public String getYrpurhm() {
        return yrpurhm;
    }

    public void setYrpurhm(String yrpurhm) {
        this.yrpurhm = yrpurhm;
    }

    private String intcode1;

    @javax.persistence.Column(name = "INTCODE1")
    @Basic
    public String getIntcode1() {
        return intcode1;
    }

    public void setIntcode1(String intcode1) {
        this.intcode1 = intcode1;
    }

    private String intcode2;

    @javax.persistence.Column(name = "INTCODE2")
    @Basic
    public String getIntcode2() {
        return intcode2;
    }

    public void setIntcode2(String intcode2) {
        this.intcode2 = intcode2;
    }

    private String intcode3;

    @javax.persistence.Column(name = "INTCODE3")
    @Basic
    public String getIntcode3() {
        return intcode3;
    }

    public void setIntcode3(String intcode3) {
        this.intcode3 = intcode3;
    }

    private String intcode4;

    @javax.persistence.Column(name = "INTCODE4")
    @Basic
    public String getIntcode4() {
        return intcode4;
    }

    public void setIntcode4(String intcode4) {
        this.intcode4 = intcode4;
    }

    private String intcode5;

    @javax.persistence.Column(name = "INTCODE5")
    @Basic
    public String getIntcode5() {
        return intcode5;
    }

    public void setIntcode5(String intcode5) {
        this.intcode5 = intcode5;
    }

    private String intcode6;

    @javax.persistence.Column(name = "INTCODE6")
    @Basic
    public String getIntcode6() {
        return intcode6;
    }

    public void setIntcode6(String intcode6) {
        this.intcode6 = intcode6;
    }

    private BigInteger nospec;

    @javax.persistence.Column(name = "NOSPEC")
    @Basic
    public BigInteger getNospec() {
        return nospec;
    }

    public void setNospec(BigInteger nospec) {
        this.nospec = nospec;
    }

    private BigInteger nospecr;

    @javax.persistence.Column(name = "NOSPECR")
    @Basic
    public BigInteger getNospecr() {
        return nospecr;
    }

    public void setNospecr(BigInteger nospecr) {
        this.nospecr = nospecr;
    }

    private String initals;

    @javax.persistence.Column(name = "INITALS")
    @Basic
    public String getInitals() {
        return initals;
    }

    public void setInitals(String initals) {
        this.initals = initals;
    }

    private String module;

    @javax.persistence.Column(name = "MODULE")
    @Basic
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    private String usercd1;

    @javax.persistence.Column(name = "USERCD1")
    @Basic
    public String getUsercd1() {
        return usercd1;
    }

    public void setUsercd1(String usercd1) {
        this.usercd1 = usercd1;
    }

    private String usercd2;

    @javax.persistence.Column(name = "USERCD2")
    @Basic
    public String getUsercd2() {
        return usercd2;
    }

    public void setUsercd2(String usercd2) {
        this.usercd2 = usercd2;
    }

    private String usercd3;

    @javax.persistence.Column(name = "USERCD3")
    @Basic
    public String getUsercd3() {
        return usercd3;
    }

    public void setUsercd3(String usercd3) {
        this.usercd3 = usercd3;
    }

    private String usercd4;

    @javax.persistence.Column(name = "USERCD4")
    @Basic
    public String getUsercd4() {
        return usercd4;
    }

    public void setUsercd4(String usercd4) {
        this.usercd4 = usercd4;
    }

    private BigInteger nospea;

    @javax.persistence.Column(name = "NOSPEA")
    @Basic
    public BigInteger getNospea() {
        return nospea;
    }

    public void setNospea(BigInteger nospea) {
        this.nospea = nospea;
    }

    private BigInteger nospear;

    @javax.persistence.Column(name = "NOSPEAR")
    @Basic
    public BigInteger getNospear() {
        return nospear;
    }

    public void setNospear(BigInteger nospear) {
        this.nospear = nospear;
    }

    private String sdatec;

    @javax.persistence.Column(name = "SDATEC")
    @Basic
    public String getSdatec() {
        return sdatec;
    }

    public void setSdatec(String sdatec) {
        this.sdatec = sdatec;
    }

    private String sdesc;

    @javax.persistence.Column(name = "SDESC")
    @Basic
    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    private String asnstat;

    @javax.persistence.Column(name = "ASNSTAT")
    @Basic
    public String getAsnstat() {
        return asnstat;
    }

    public void setAsnstat(String asnstat) {
        this.asnstat = asnstat;
    }

    private String asndtec;

    @javax.persistence.Column(name = "ASNDTEC")
    @Basic
    public String getAsndtec() {
        return asndtec;
    }

    public void setAsndtec(String asndtec) {
        this.asndtec = asndtec;
    }

    private String sstat01;

    @javax.persistence.Column(name = "SSTAT01")
    @Basic
    public String getSstat01() {
        return sstat01;
    }

    public void setSstat01(String sstat01) {
        this.sstat01 = sstat01;
    }

    private String sstat02;

    @javax.persistence.Column(name = "SSTAT02")
    @Basic
    public String getSstat02() {
        return sstat02;
    }

    public void setSstat02(String sstat02) {
        this.sstat02 = sstat02;
    }

    private String sstat03;

    @javax.persistence.Column(name = "SSTAT03")
    @Basic
    public String getSstat03() {
        return sstat03;
    }

    public void setSstat03(String sstat03) {
        this.sstat03 = sstat03;
    }

    private String sstat04;

    @javax.persistence.Column(name = "SSTAT04")
    @Basic
    public String getSstat04() {
        return sstat04;
    }

    public void setSstat04(String sstat04) {
        this.sstat04 = sstat04;
    }

    private String sstat05;

    @javax.persistence.Column(name = "SSTAT05")
    @Basic
    public String getSstat05() {
        return sstat05;
    }

    public void setSstat05(String sstat05) {
        this.sstat05 = sstat05;
    }

    private String sstat06;

    @javax.persistence.Column(name = "SSTAT06")
    @Basic
    public String getSstat06() {
        return sstat06;
    }

    public void setSstat06(String sstat06) {
        this.sstat06 = sstat06;
    }

    private String sstat07;

    @javax.persistence.Column(name = "SSTAT07")
    @Basic
    public String getSstat07() {
        return sstat07;
    }

    public void setSstat07(String sstat07) {
        this.sstat07 = sstat07;
    }

    private String sstat08;

    @javax.persistence.Column(name = "SSTAT08")
    @Basic
    public String getSstat08() {
        return sstat08;
    }

    public void setSstat08(String sstat08) {
        this.sstat08 = sstat08;
    }

    private String sstat09;

    @javax.persistence.Column(name = "SSTAT09")
    @Basic
    public String getSstat09() {
        return sstat09;
    }

    public void setSstat09(String sstat09) {
        this.sstat09 = sstat09;
    }

    private String sstat10;

    @javax.persistence.Column(name = "SSTAT10")
    @Basic
    public String getSstat10() {
        return sstat10;
    }

    public void setSstat10(String sstat10) {
        this.sstat10 = sstat10;
    }

    private String sstat11;

    @javax.persistence.Column(name = "SSTAT11")
    @Basic
    public String getSstat11() {
        return sstat11;
    }

    public void setSstat11(String sstat11) {
        this.sstat11 = sstat11;
    }

    private String sstat12;

    @javax.persistence.Column(name = "SSTAT12")
    @Basic
    public String getSstat12() {
        return sstat12;
    }

    public void setSstat12(String sstat12) {
        this.sstat12 = sstat12;
    }

    private String sstat13;

    @javax.persistence.Column(name = "SSTAT13")
    @Basic
    public String getSstat13() {
        return sstat13;
    }

    public void setSstat13(String sstat13) {
        this.sstat13 = sstat13;
    }

    private String sstat14;

    @javax.persistence.Column(name = "SSTAT14")
    @Basic
    public String getSstat14() {
        return sstat14;
    }

    public void setSstat14(String sstat14) {
        this.sstat14 = sstat14;
    }

    private String sstat15;

    @javax.persistence.Column(name = "SSTAT15")
    @Basic
    public String getSstat15() {
        return sstat15;
    }

    public void setSstat15(String sstat15) {
        this.sstat15 = sstat15;
    }

    private String astat1;

    @javax.persistence.Column(name = "ASTAT1")
    @Basic
    public String getAstat1() {
        return astat1;
    }

    public void setAstat1(String astat1) {
        this.astat1 = astat1;
    }

    private String astat2;

    @javax.persistence.Column(name = "ASTAT2")
    @Basic
    public String getAstat2() {
        return astat2;
    }

    public void setAstat2(String astat2) {
        this.astat2 = astat2;
    }

    private String astat3;

    @javax.persistence.Column(name = "ASTAT3")
    @Basic
    public String getAstat3() {
        return astat3;
    }

    public void setAstat3(String astat3) {
        this.astat3 = astat3;
    }

    private String astat4;

    @javax.persistence.Column(name = "ASTAT4")
    @Basic
    public String getAstat4() {
        return astat4;
    }

    public void setAstat4(String astat4) {
        this.astat4 = astat4;
    }

    private String astat5;

    @javax.persistence.Column(name = "ASTAT5")
    @Basic
    public String getAstat5() {
        return astat5;
    }

    public void setAstat5(String astat5) {
        this.astat5 = astat5;
    }

    private String comptyp;

    @javax.persistence.Column(name = "COMPTYP")
    @Basic
    public String getComptyp() {
        return comptyp;
    }

    public void setComptyp(String comptyp) {
        this.comptyp = comptyp;
    }

    private String dstat;

    @javax.persistence.Column(name = "DSTAT")
    @Basic
    public String getDstat() {
        return dstat;
    }

    public void setDstat(String dstat) {
        this.dstat = dstat;
    }

    private String favisor;

    @javax.persistence.Column(name = "FAVISOR")
    @Basic
    public String getFavisor() {
        return favisor;
    }

    public void setFavisor(String favisor) {
        this.favisor = favisor;
    }

    private String rhsprog;

    @javax.persistence.Column(name = "RHSPROG")
    @Basic
    public String getRhsprog() {
        return rhsprog;
    }

    public void setRhsprog(String rhsprog) {
        this.rhsprog = rhsprog;
    }

    private String acgcrs;

    @javax.persistence.Column(name = "ACGCRS")
    @Basic
    public String getAcgcrs() {
        return acgcrs;
    }

    public void setAcgcrs(String acgcrs) {
        this.acgcrs = acgcrs;
    }

    private String acgbac;

    @javax.persistence.Column(name = "ACGBAC")
    @Basic
    public String getAcgbac() {
        return acgbac;
    }

    public void setAcgbac(String acgbac) {
        this.acgbac = acgbac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrkEntity trkEntity = (TrkEntity) o;

        if (padjgro != trkEntity.padjgro) return false;
        if (sadjgro != trkEntity.sadjgro) return false;
        if (acgbac != null ? !acgbac.equals(trkEntity.acgbac) : trkEntity.acgbac != null) return false;
        if (acgcrs != null ? !acgcrs.equals(trkEntity.acgcrs) : trkEntity.acgcrs != null) return false;
        if (actstat != null ? !actstat.equals(trkEntity.actstat) : trkEntity.actstat != null) return false;
        if (adate1C != null ? !adate1C.equals(trkEntity.adate1C) : trkEntity.adate1C != null) return false;
        if (adate2C != null ? !adate2C.equals(trkEntity.adate2C) : trkEntity.adate2C != null) return false;
        if (adate3C != null ? !adate3C.equals(trkEntity.adate3C) : trkEntity.adate3C != null) return false;
        if (adate4C != null ? !adate4C.equals(trkEntity.adate4C) : trkEntity.adate4C != null) return false;
        if (adate5C != null ? !adate5C.equals(trkEntity.adate5C) : trkEntity.adate5C != null) return false;
        if (admstat != null ? !admstat.equals(trkEntity.admstat) : trkEntity.admstat != null) return false;
        if (aidpre1 != null ? !aidpre1.equals(trkEntity.aidpre1) : trkEntity.aidpre1 != null) return false;
        if (aidpre2 != null ? !aidpre2.equals(trkEntity.aidpre2) : trkEntity.aidpre2 != null) return false;
        if (aidpre3 != null ? !aidpre3.equals(trkEntity.aidpre3) : trkEntity.aidpre3 != null) return false;
        if (aidyr != null ? !aidyr.equals(trkEntity.aidyr) : trkEntity.aidyr != null) return false;
        if (appbegc != null ? !appbegc.equals(trkEntity.appbegc) : trkEntity.appbegc != null) return false;
        if (appcmpc != null ? !appcmpc.equals(trkEntity.appcmpc) : trkEntity.appcmpc != null) return false;
        if (appendc != null ? !appendc.equals(trkEntity.appendc) : trkEntity.appendc != null) return false;
        if (asndtec != null ? !asndtec.equals(trkEntity.asndtec) : trkEntity.asndtec != null) return false;
        if (asnstat != null ? !asnstat.equals(trkEntity.asnstat) : trkEntity.asnstat != null) return false;
        if (astat1 != null ? !astat1.equals(trkEntity.astat1) : trkEntity.astat1 != null) return false;
        if (astat2 != null ? !astat2.equals(trkEntity.astat2) : trkEntity.astat2 != null) return false;
        if (astat3 != null ? !astat3.equals(trkEntity.astat3) : trkEntity.astat3 != null) return false;
        if (astat4 != null ? !astat4.equals(trkEntity.astat4) : trkEntity.astat4 != null) return false;
        if (astat5 != null ? !astat5.equals(trkEntity.astat5) : trkEntity.astat5 != null) return false;
        if (atype1 != null ? !atype1.equals(trkEntity.atype1) : trkEntity.atype1 != null) return false;
        if (atype2 != null ? !atype2.equals(trkEntity.atype2) : trkEntity.atype2 != null) return false;
        if (atype3 != null ? !atype3.equals(trkEntity.atype3) : trkEntity.atype3 != null) return false;
        if (atype4 != null ? !atype4.equals(trkEntity.atype4) : trkEntity.atype4 != null) return false;
        if (atype5 != null ? !atype5.equals(trkEntity.atype5) : trkEntity.atype5 != null) return false;
        if (campus1 != null ? !campus1.equals(trkEntity.campus1) : trkEntity.campus1 != null) return false;
        if (campus2 != null ? !campus2.equals(trkEntity.campus2) : trkEntity.campus2 != null) return false;
        if (comptyp != null ? !comptyp.equals(trkEntity.comptyp) : trkEntity.comptyp != null) return false;
        if (dstat != null ? !dstat.equals(trkEntity.dstat) : trkEntity.dstat != null) return false;
        if (favisor != null ? !favisor.equals(trkEntity.favisor) : trkEntity.favisor != null) return false;
        if (filcmpc != null ? !filcmpc.equals(trkEntity.filcmpc) : trkEntity.filcmpc != null) return false;
        if (folow1C != null ? !folow1C.equals(trkEntity.folow1C) : trkEntity.folow1C != null) return false;
        if (folow2C != null ? !folow2C.equals(trkEntity.folow2C) : trkEntity.folow2C != null) return false;
        if (folow3C != null ? !folow3C.equals(trkEntity.folow3C) : trkEntity.folow3C != null) return false;
        if (htrack != null ? !htrack.equals(trkEntity.htrack) : trkEntity.htrack != null) return false;
        if (initals != null ? !initals.equals(trkEntity.initals) : trkEntity.initals != null) return false;
        if (intcode1 != null ? !intcode1.equals(trkEntity.intcode1) : trkEntity.intcode1 != null) return false;
        if (intcode2 != null ? !intcode2.equals(trkEntity.intcode2) : trkEntity.intcode2 != null) return false;
        if (intcode3 != null ? !intcode3.equals(trkEntity.intcode3) : trkEntity.intcode3 != null) return false;
        if (intcode4 != null ? !intcode4.equals(trkEntity.intcode4) : trkEntity.intcode4 != null) return false;
        if (intcode5 != null ? !intcode5.equals(trkEntity.intcode5) : trkEntity.intcode5 != null) return false;
        if (intcode6 != null ? !intcode6.equals(trkEntity.intcode6) : trkEntity.intcode6 != null) return false;
        if (module != null ? !module.equals(trkEntity.module) : trkEntity.module != null) return false;
        if (nospea != null ? !nospea.equals(trkEntity.nospea) : trkEntity.nospea != null) return false;
        if (nospear != null ? !nospear.equals(trkEntity.nospear) : trkEntity.nospear != null) return false;
        if (nospec != null ? !nospec.equals(trkEntity.nospec) : trkEntity.nospec != null) return false;
        if (nospecr != null ? !nospecr.equals(trkEntity.nospecr) : trkEntity.nospecr != null) return false;
        if (pexempt != null ? !pexempt.equals(trkEntity.pexempt) : trkEntity.pexempt != null) return false;
        if (pmajor != null ? !pmajor.equals(trkEntity.pmajor) : trkEntity.pmajor != null) return false;
        if (procntr != null ? !procntr.equals(trkEntity.procntr) : trkEntity.procntr != null) return false;
        if (pschool != null ? !pschool.equals(trkEntity.pschool) : trkEntity.pschool != null) return false;
        if (rectype != null ? !rectype.equals(trkEntity.rectype) : trkEntity.rectype != null) return false;
        if (revdtec != null ? !revdtec.equals(trkEntity.revdtec) : trkEntity.revdtec != null) return false;
        if (revlev != null ? !revlev.equals(trkEntity.revlev) : trkEntity.revlev != null) return false;
        if (rhsprog != null ? !rhsprog.equals(trkEntity.rhsprog) : trkEntity.rhsprog != null) return false;
        if (sam != null ? !sam.equals(trkEntity.sam) : trkEntity.sam != null) return false;
        if (screndc != null ? !screndc.equals(trkEntity.screndc) : trkEntity.screndc != null) return false;
        if (sdatec != null ? !sdatec.equals(trkEntity.sdatec) : trkEntity.sdatec != null) return false;
        if (sdesc != null ? !sdesc.equals(trkEntity.sdesc) : trkEntity.sdesc != null) return false;
        if (sexempt != null ? !sexempt.equals(trkEntity.sexempt) : trkEntity.sexempt != null) return false;
        if (sfaappc != null ? !sfaappc.equals(trkEntity.sfaappc) : trkEntity.sfaappc != null) return false;
        if (sid != null ? !sid.equals(trkEntity.sid) : trkEntity.sid != null) return false;
        if (sitime != null ? !sitime.equals(trkEntity.sitime) : trkEntity.sitime != null) return false;
        if (sstat01 != null ? !sstat01.equals(trkEntity.sstat01) : trkEntity.sstat01 != null) return false;
        if (sstat02 != null ? !sstat02.equals(trkEntity.sstat02) : trkEntity.sstat02 != null) return false;
        if (sstat03 != null ? !sstat03.equals(trkEntity.sstat03) : trkEntity.sstat03 != null) return false;
        if (sstat04 != null ? !sstat04.equals(trkEntity.sstat04) : trkEntity.sstat04 != null) return false;
        if (sstat05 != null ? !sstat05.equals(trkEntity.sstat05) : trkEntity.sstat05 != null) return false;
        if (sstat06 != null ? !sstat06.equals(trkEntity.sstat06) : trkEntity.sstat06 != null) return false;
        if (sstat07 != null ? !sstat07.equals(trkEntity.sstat07) : trkEntity.sstat07 != null) return false;
        if (sstat08 != null ? !sstat08.equals(trkEntity.sstat08) : trkEntity.sstat08 != null) return false;
        if (sstat09 != null ? !sstat09.equals(trkEntity.sstat09) : trkEntity.sstat09 != null) return false;
        if (sstat10 != null ? !sstat10.equals(trkEntity.sstat10) : trkEntity.sstat10 != null) return false;
        if (sstat11 != null ? !sstat11.equals(trkEntity.sstat11) : trkEntity.sstat11 != null) return false;
        if (sstat12 != null ? !sstat12.equals(trkEntity.sstat12) : trkEntity.sstat12 != null) return false;
        if (sstat13 != null ? !sstat13.equals(trkEntity.sstat13) : trkEntity.sstat13 != null) return false;
        if (sstat14 != null ? !sstat14.equals(trkEntity.sstat14) : trkEntity.sstat14 != null) return false;
        if (sstat15 != null ? !sstat15.equals(trkEntity.sstat15) : trkEntity.sstat15 != null) return false;
        if (stype != null ? !stype.equals(trkEntity.stype) : trkEntity.stype != null) return false;
        if (syscode != null ? !syscode.equals(trkEntity.syscode) : trkEntity.syscode != null) return false;
        if (tdte01C != null ? !tdte01C.equals(trkEntity.tdte01C) : trkEntity.tdte01C != null) return false;
        if (tdte02C != null ? !tdte02C.equals(trkEntity.tdte02C) : trkEntity.tdte02C != null) return false;
        if (tdte03C != null ? !tdte03C.equals(trkEntity.tdte03C) : trkEntity.tdte03C != null) return false;
        if (tdte04C != null ? !tdte04C.equals(trkEntity.tdte04C) : trkEntity.tdte04C != null) return false;
        if (tdte05C != null ? !tdte05C.equals(trkEntity.tdte05C) : trkEntity.tdte05C != null) return false;
        if (tdte06C != null ? !tdte06C.equals(trkEntity.tdte06C) : trkEntity.tdte06C != null) return false;
        if (tdte07C != null ? !tdte07C.equals(trkEntity.tdte07C) : trkEntity.tdte07C != null) return false;
        if (tdte08C != null ? !tdte08C.equals(trkEntity.tdte08C) : trkEntity.tdte08C != null) return false;
        if (tdte09C != null ? !tdte09C.equals(trkEntity.tdte09C) : trkEntity.tdte09C != null) return false;
        if (tdte10C != null ? !tdte10C.equals(trkEntity.tdte10C) : trkEntity.tdte10C != null) return false;
        if (tdte11C != null ? !tdte11C.equals(trkEntity.tdte11C) : trkEntity.tdte11C != null) return false;
        if (tdte12C != null ? !tdte12C.equals(trkEntity.tdte12C) : trkEntity.tdte12C != null) return false;
        if (tdte13C != null ? !tdte13C.equals(trkEntity.tdte13C) : trkEntity.tdte13C != null) return false;
        if (tdte14C != null ? !tdte14C.equals(trkEntity.tdte14C) : trkEntity.tdte14C != null) return false;
        if (tdte15C != null ? !tdte15C.equals(trkEntity.tdte15C) : trkEntity.tdte15C != null) return false;
        if (term != null ? !term.equals(trkEntity.term) : trkEntity.term != null) return false;
        if (track != null ? !track.equals(trkEntity.track) : trkEntity.track != null) return false;
        if (trckclr != null ? !trckclr.equals(trkEntity.trckclr) : trkEntity.trckclr != null) return false;
        if (trkkey != null ? !trkkey.equals(trkEntity.trkkey) : trkEntity.trkkey != null) return false;
        if (ttype != null ? !ttype.equals(trkEntity.ttype) : trkEntity.ttype != null) return false;
        if (ucode != null ? !ucode.equals(trkEntity.ucode) : trkEntity.ucode != null) return false;
        if (usercd1 != null ? !usercd1.equals(trkEntity.usercd1) : trkEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(trkEntity.usercd2) : trkEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(trkEntity.usercd3) : trkEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(trkEntity.usercd4) : trkEntity.usercd4 != null) return false;
        if (yrinsch != null ? !yrinsch.equals(trkEntity.yrinsch) : trkEntity.yrinsch != null) return false;
        if (yrpurhm != null ? !yrpurhm.equals(trkEntity.yrpurhm) : trkEntity.yrpurhm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trkkey != null ? trkkey.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (rectype != null ? rectype.hashCode() : 0);
        result = 31 * result + (stype != null ? stype.hashCode() : 0);
        result = 31 * result + (sfaappc != null ? sfaappc.hashCode() : 0);
        result = 31 * result + (folow1C != null ? folow1C.hashCode() : 0);
        result = 31 * result + (folow2C != null ? folow2C.hashCode() : 0);
        result = 31 * result + (folow3C != null ? folow3C.hashCode() : 0);
        result = 31 * result + (screndc != null ? screndc.hashCode() : 0);
        result = 31 * result + (track != null ? track.hashCode() : 0);
        result = 31 * result + (ttype != null ? ttype.hashCode() : 0);
        result = 31 * result + (htrack != null ? htrack.hashCode() : 0);
        result = 31 * result + (appcmpc != null ? appcmpc.hashCode() : 0);
        result = 31 * result + (filcmpc != null ? filcmpc.hashCode() : 0);
        result = 31 * result + (actstat != null ? actstat.hashCode() : 0);
        result = 31 * result + (admstat != null ? admstat.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (appbegc != null ? appbegc.hashCode() : 0);
        result = 31 * result + (appendc != null ? appendc.hashCode() : 0);
        result = 31 * result + (campus1 != null ? campus1.hashCode() : 0);
        result = 31 * result + (campus2 != null ? campus2.hashCode() : 0);
        result = 31 * result + (pmajor != null ? pmajor.hashCode() : 0);
        result = 31 * result + (pschool != null ? pschool.hashCode() : 0);
        result = 31 * result + (yrinsch != null ? yrinsch.hashCode() : 0);
        result = 31 * result + (aidpre1 != null ? aidpre1.hashCode() : 0);
        result = 31 * result + (aidpre2 != null ? aidpre2.hashCode() : 0);
        result = 31 * result + (aidpre3 != null ? aidpre3.hashCode() : 0);
        result = 31 * result + (sexempt != null ? sexempt.hashCode() : 0);
        result = 31 * result + sadjgro;
        result = 31 * result + (pexempt != null ? pexempt.hashCode() : 0);
        result = 31 * result + padjgro;
        result = 31 * result + (tdte01C != null ? tdte01C.hashCode() : 0);
        result = 31 * result + (tdte02C != null ? tdte02C.hashCode() : 0);
        result = 31 * result + (tdte03C != null ? tdte03C.hashCode() : 0);
        result = 31 * result + (tdte04C != null ? tdte04C.hashCode() : 0);
        result = 31 * result + (tdte05C != null ? tdte05C.hashCode() : 0);
        result = 31 * result + (tdte06C != null ? tdte06C.hashCode() : 0);
        result = 31 * result + (tdte07C != null ? tdte07C.hashCode() : 0);
        result = 31 * result + (tdte08C != null ? tdte08C.hashCode() : 0);
        result = 31 * result + (tdte09C != null ? tdte09C.hashCode() : 0);
        result = 31 * result + (tdte10C != null ? tdte10C.hashCode() : 0);
        result = 31 * result + (tdte11C != null ? tdte11C.hashCode() : 0);
        result = 31 * result + (tdte12C != null ? tdte12C.hashCode() : 0);
        result = 31 * result + (tdte13C != null ? tdte13C.hashCode() : 0);
        result = 31 * result + (tdte14C != null ? tdte14C.hashCode() : 0);
        result = 31 * result + (tdte15C != null ? tdte15C.hashCode() : 0);
        result = 31 * result + (atype1 != null ? atype1.hashCode() : 0);
        result = 31 * result + (adate1C != null ? adate1C.hashCode() : 0);
        result = 31 * result + (atype2 != null ? atype2.hashCode() : 0);
        result = 31 * result + (adate2C != null ? adate2C.hashCode() : 0);
        result = 31 * result + (atype3 != null ? atype3.hashCode() : 0);
        result = 31 * result + (adate3C != null ? adate3C.hashCode() : 0);
        result = 31 * result + (atype4 != null ? atype4.hashCode() : 0);
        result = 31 * result + (adate4C != null ? adate4C.hashCode() : 0);
        result = 31 * result + (atype5 != null ? atype5.hashCode() : 0);
        result = 31 * result + (adate5C != null ? adate5C.hashCode() : 0);
        result = 31 * result + (procntr != null ? procntr.hashCode() : 0);
        result = 31 * result + (sam != null ? sam.hashCode() : 0);
        result = 31 * result + (trckclr != null ? trckclr.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (syscode != null ? syscode.hashCode() : 0);
        result = 31 * result + (sitime != null ? sitime.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (yrpurhm != null ? yrpurhm.hashCode() : 0);
        result = 31 * result + (intcode1 != null ? intcode1.hashCode() : 0);
        result = 31 * result + (intcode2 != null ? intcode2.hashCode() : 0);
        result = 31 * result + (intcode3 != null ? intcode3.hashCode() : 0);
        result = 31 * result + (intcode4 != null ? intcode4.hashCode() : 0);
        result = 31 * result + (intcode5 != null ? intcode5.hashCode() : 0);
        result = 31 * result + (intcode6 != null ? intcode6.hashCode() : 0);
        result = 31 * result + (nospec != null ? nospec.hashCode() : 0);
        result = 31 * result + (nospecr != null ? nospecr.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + (nospea != null ? nospea.hashCode() : 0);
        result = 31 * result + (nospear != null ? nospear.hashCode() : 0);
        result = 31 * result + (sdatec != null ? sdatec.hashCode() : 0);
        result = 31 * result + (sdesc != null ? sdesc.hashCode() : 0);
        result = 31 * result + (asnstat != null ? asnstat.hashCode() : 0);
        result = 31 * result + (asndtec != null ? asndtec.hashCode() : 0);
        result = 31 * result + (sstat01 != null ? sstat01.hashCode() : 0);
        result = 31 * result + (sstat02 != null ? sstat02.hashCode() : 0);
        result = 31 * result + (sstat03 != null ? sstat03.hashCode() : 0);
        result = 31 * result + (sstat04 != null ? sstat04.hashCode() : 0);
        result = 31 * result + (sstat05 != null ? sstat05.hashCode() : 0);
        result = 31 * result + (sstat06 != null ? sstat06.hashCode() : 0);
        result = 31 * result + (sstat07 != null ? sstat07.hashCode() : 0);
        result = 31 * result + (sstat08 != null ? sstat08.hashCode() : 0);
        result = 31 * result + (sstat09 != null ? sstat09.hashCode() : 0);
        result = 31 * result + (sstat10 != null ? sstat10.hashCode() : 0);
        result = 31 * result + (sstat11 != null ? sstat11.hashCode() : 0);
        result = 31 * result + (sstat12 != null ? sstat12.hashCode() : 0);
        result = 31 * result + (sstat13 != null ? sstat13.hashCode() : 0);
        result = 31 * result + (sstat14 != null ? sstat14.hashCode() : 0);
        result = 31 * result + (sstat15 != null ? sstat15.hashCode() : 0);
        result = 31 * result + (astat1 != null ? astat1.hashCode() : 0);
        result = 31 * result + (astat2 != null ? astat2.hashCode() : 0);
        result = 31 * result + (astat3 != null ? astat3.hashCode() : 0);
        result = 31 * result + (astat4 != null ? astat4.hashCode() : 0);
        result = 31 * result + (astat5 != null ? astat5.hashCode() : 0);
        result = 31 * result + (comptyp != null ? comptyp.hashCode() : 0);
        result = 31 * result + (dstat != null ? dstat.hashCode() : 0);
        result = 31 * result + (favisor != null ? favisor.hashCode() : 0);
        result = 31 * result + (rhsprog != null ? rhsprog.hashCode() : 0);
        result = 31 * result + (acgcrs != null ? acgcrs.hashCode() : 0);
        result = 31 * result + (acgbac != null ? acgbac.hashCode() : 0);
        return result;
    }
}
