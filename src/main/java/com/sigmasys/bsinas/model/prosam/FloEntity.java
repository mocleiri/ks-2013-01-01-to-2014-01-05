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
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "FLO", schema = "SIGMA", catalog = "")
@Entity
public class FloEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getFlokey();
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

    private String flokey;

    @javax.persistence.Column(name = "FLOKEY")
    @Id
    public String getFlokey() {
        return flokey;
    }

    public void setFlokey(String flokey) {
        this.flokey = flokey;
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

    private String procyr;

    @javax.persistence.Column(name = "PROCYR")
    @Basic
    public String getProcyr() {
        return procyr;
    }

    public void setProcyr(String procyr) {
        this.procyr = procyr;
    }

    private String aidid;

    @javax.persistence.Column(name = "AIDID")
    @Basic
    public String getAidid() {
        return aidid;
    }

    public void setAidid(String aidid) {
        this.aidid = aidid;
    }

    private String ptype;

    @javax.persistence.Column(name = "PTYPE")
    @Basic
    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    private String unusedd;

    @javax.persistence.Column(name = "UNUSEDD")
    @Basic
    public String getUnusedd() {
        return unusedd;
    }

    public void setUnusedd(String unusedd) {
        this.unusedd = unusedd;
    }

    private String bsid;

    @javax.persistence.Column(name = "BSID")
    @Basic
    public String getBsid() {
        return bsid;
    }

    public void setBsid(String bsid) {
        this.bsid = bsid;
    }

    private String bprocyr;

    @javax.persistence.Column(name = "BPROCYR")
    @Basic
    public String getBprocyr() {
        return bprocyr;
    }

    public void setBprocyr(String bprocyr) {
        this.bprocyr = bprocyr;
    }

    private String blntype;

    @javax.persistence.Column(name = "BLNTYPE")
    @Basic
    public String getBlntype() {
        return blntype;
    }

    public void setBlntype(String blntype) {
        this.blntype = blntype;
    }

    private String baidid;

    @javax.persistence.Column(name = "BAIDID")
    @Basic
    public String getBaidid() {
        return baidid;
    }

    public void setBaidid(String baidid) {
        this.baidid = baidid;
    }

    private String bptype;

    @javax.persistence.Column(name = "BPTYPE")
    @Basic
    public String getBptype() {
        return bptype;
    }

    public void setBptype(String bptype) {
        this.bptype = bptype;
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

    private String crtpgm;

    @javax.persistence.Column(name = "CRTPGM")
    @Basic
    public String getCrtpgm() {
        return crtpgm;
    }

    public void setCrtpgm(String crtpgm) {
        this.crtpgm = crtpgm;
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

    private int revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public int getRevlev() {
        return revlev;
    }

    public void setRevlev(int revlev) {
        this.revlev = revlev;
    }

    private String revpgm;

    @javax.persistence.Column(name = "REVPGM")
    @Basic
    public String getRevpgm() {
        return revpgm;
    }

    public void setRevpgm(String revpgm) {
        this.revpgm = revpgm;
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

    private String vendor;

    @javax.persistence.Column(name = "VENDOR")
    @Basic
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    private String loanstat;

    @javax.persistence.Column(name = "LOANSTAT")
    @Basic
    public String getLoanstat() {
        return loanstat;
    }

    public void setLoanstat(String loanstat) {
        this.loanstat = loanstat;
    }

    private String origdate;

    @javax.persistence.Column(name = "ORIGDATE")
    @Basic
    public String getOrigdate() {
        return origdate;
    }

    public void setOrigdate(String origdate) {
        this.origdate = origdate;
    }

    private String unuseda;

    @javax.persistence.Column(name = "UNUSEDA")
    @Basic
    public String getUnuseda() {
        return unuseda;
    }

    public void setUnuseda(String unuseda) {
        this.unuseda = unuseda;
    }

    private String defaultr;

    @javax.persistence.Column(name = "DEFAULTR")
    @Basic
    public String getDefaultr() {
        return defaultr;
    }

    public void setDefaultr(String defaultr) {
        this.defaultr = defaultr;
    }

    private String glacnt;

    @javax.persistence.Column(name = "GLACNT")
    @Basic
    public String getGlacnt() {
        return glacnt;
    }

    public void setGlacnt(String glacnt) {
        this.glacnt = glacnt;
    }

    private String proctyp;

    @javax.persistence.Column(name = "PROCTYP")
    @Basic
    public String getProctyp() {
        return proctyp;
    }

    public void setProctyp(String proctyp) {
        this.proctyp = proctyp;
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

    private String statcd;

    @javax.persistence.Column(name = "STATCD")
    @Basic
    public String getStatcd() {
        return statcd;
    }

    public void setStatcd(String statcd) {
        this.statcd = statcd;
    }

    private String depst;

    @javax.persistence.Column(name = "DEPST")
    @Basic
    public String getDepst() {
        return depst;
    }

    public void setDepst(String depst) {
        this.depst = depst;
    }

    private String depst2;

    @javax.persistence.Column(name = "DEPST2")
    @Basic
    public String getDepst2() {
        return depst2;
    }

    public void setDepst2(String depst2) {
        this.depst2 = depst2;
    }

    private String depst3;

    @javax.persistence.Column(name = "DEPST3")
    @Basic
    public String getDepst3() {
        return depst3;
    }

    public void setDepst3(String depst3) {
        this.depst3 = depst3;
    }

    private BigInteger pnseqno;

    @javax.persistence.Column(name = "PNSEQNO")
    @Basic
    public BigInteger getPnseqno() {
        return pnseqno;
    }

    public void setPnseqno(BigInteger pnseqno) {
        this.pnseqno = pnseqno;
    }

    private String phasecd;

    @javax.persistence.Column(name = "PHASECD")
    @Basic
    public String getPhasecd() {
        return phasecd;
    }

    public void setPhasecd(String phasecd) {
        this.phasecd = phasecd;
    }

    private String aidid2;

    @javax.persistence.Column(name = "AIDID2")
    @Basic
    public String getAidid2() {
        return aidid2;
    }

    public void setAidid2(String aidid2) {
        this.aidid2 = aidid2;
    }

    private String creditck;

    @javax.persistence.Column(name = "CREDITCK")
    @Basic
    public String getCreditck() {
        return creditck;
    }

    public void setCreditck(String creditck) {
        this.creditck = creditck;
    }

    private String credreq;

    @javax.persistence.Column(name = "CREDREQ")
    @Basic
    public String getCredreq() {
        return credreq;
    }

    public void setCredreq(String credreq) {
        this.credreq = credreq;
    }

    private String credrec;

    @javax.persistence.Column(name = "CREDREC")
    @Basic
    public String getCredrec() {
        return credrec;
    }

    public void setCredrec(String credrec) {
        this.credrec = credrec;
    }

    private String credupd;

    @javax.persistence.Column(name = "CREDUPD")
    @Basic
    public String getCredupd() {
        return credupd;
    }

    public void setCredupd(String credupd) {
        this.credupd = credupd;
    }

    private String progdate;

    @javax.persistence.Column(name = "PROGDATE")
    @Basic
    public String getProgdate() {
        return progdate;
    }

    public void setProgdate(String progdate) {
        this.progdate = progdate;
    }

    private String strtdate;

    @javax.persistence.Column(name = "STRTDATE")
    @Basic
    public String getStrtdate() {
        return strtdate;
    }

    public void setStrtdate(String strtdate) {
        this.strtdate = strtdate;
    }

    private String perbeg;

    @javax.persistence.Column(name = "PERBEG")
    @Basic
    public String getPerbeg() {
        return perbeg;
    }

    public void setPerbeg(String perbeg) {
        this.perbeg = perbeg;
    }

    private String perend;

    @javax.persistence.Column(name = "PEREND")
    @Basic
    public String getPerend() {
        return perend;
    }

    public void setPerend(String perend) {
        this.perend = perend;
    }

    private String senrsdt;

    @javax.persistence.Column(name = "SENRSDT")
    @Basic
    public String getSenrsdt() {
        return senrsdt;
    }

    public void setSenrsdt(String senrsdt) {
        this.senrsdt = senrsdt;
    }

    private String servdate;

    @javax.persistence.Column(name = "SERVDATE")
    @Basic
    public String getServdate() {
        return servdate;
    }

    public void setServdate(String servdate) {
        this.servdate = servdate;
    }

    private String loanclr;

    @javax.persistence.Column(name = "LOANCLR")
    @Basic
    public String getLoanclr() {
        return loanclr;
    }

    public void setLoanclr(String loanclr) {
        this.loanclr = loanclr;
    }

    private int chgcnt;

    @javax.persistence.Column(name = "CHGCNT")
    @Basic
    public int getChgcnt() {
        return chgcnt;
    }

    public void setChgcnt(int chgcnt) {
        this.chgcnt = chgcnt;
    }

    private String plusrq2;

    @javax.persistence.Column(name = "PLUSRQ2")
    @Basic
    public String getPlusrq2() {
        return plusrq2;
    }

    public void setPlusrq2(String plusrq2) {
        this.plusrq2 = plusrq2;
    }

    private BigInteger pnseqn2;

    @javax.persistence.Column(name = "PNSEQN2")
    @Basic
    public BigInteger getPnseqn2() {
        return pnseqn2;
    }

    public void setPnseqn2(BigInteger pnseqn2) {
        this.pnseqn2 = pnseqn2;
    }

    private BigDecimal feerate;

    @javax.persistence.Column(name = "FEERATE")
    @Basic
    public BigDecimal getFeerate() {
        return feerate;
    }

    public void setFeerate(BigDecimal feerate) {
        this.feerate = feerate;
    }

    private BigDecimal feeamt;

    @javax.persistence.Column(name = "FEEAMT")
    @Basic
    public BigDecimal getFeeamt() {
        return feeamt;
    }

    public void setFeeamt(BigDecimal feeamt) {
        this.feeamt = feeamt;
    }

    private BigDecimal netamt;

    @javax.persistence.Column(name = "NETAMT")
    @Basic
    public BigDecimal getNetamt() {
        return netamt;
    }

    public void setNetamt(BigDecimal netamt) {
        this.netamt = netamt;
    }

    private BigDecimal grossamt;

    @javax.persistence.Column(name = "GROSSAMT")
    @Basic
    public BigDecimal getGrossamt() {
        return grossamt;
    }

    public void setGrossamt(BigDecimal grossamt) {
        this.grossamt = grossamt;
    }

    private BigDecimal afeeamt;

    @javax.persistence.Column(name = "AFEEAMT")
    @Basic
    public BigDecimal getAfeeamt() {
        return afeeamt;
    }

    public void setAfeeamt(BigDecimal afeeamt) {
        this.afeeamt = afeeamt;
    }

    private BigDecimal agrosamt;

    @javax.persistence.Column(name = "AGROSAMT")
    @Basic
    public BigDecimal getAgrosamt() {
        return agrosamt;
    }

    public void setAgrosamt(BigDecimal agrosamt) {
        this.agrosamt = agrosamt;
    }

    private BigDecimal anetamt;

    @javax.persistence.Column(name = "ANETAMT")
    @Basic
    public BigDecimal getAnetamt() {
        return anetamt;
    }

    public void setAnetamt(BigDecimal anetamt) {
        this.anetamt = anetamt;
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

    private String usercd5;

    @javax.persistence.Column(name = "USERCD5")
    @Basic
    public String getUsercd5() {
        return usercd5;
    }

    public void setUsercd5(String usercd5) {
        this.usercd5 = usercd5;
    }

    private String usercd6;

    @javax.persistence.Column(name = "USERCD6")
    @Basic
    public String getUsercd6() {
        return usercd6;
    }

    public void setUsercd6(String usercd6) {
        this.usercd6 = usercd6;
    }

    private String usercd7;

    @javax.persistence.Column(name = "USERCD7")
    @Basic
    public String getUsercd7() {
        return usercd7;
    }

    public void setUsercd7(String usercd7) {
        this.usercd7 = usercd7;
    }

    private String usercd8;

    @javax.persistence.Column(name = "USERCD8")
    @Basic
    public String getUsercd8() {
        return usercd8;
    }

    public void setUsercd8(String usercd8) {
        this.usercd8 = usercd8;
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

    private BigDecimal usernr3;

    @javax.persistence.Column(name = "USERNR3")
    @Basic
    public BigDecimal getUsernr3() {
        return usernr3;
    }

    public void setUsernr3(BigDecimal usernr3) {
        this.usernr3 = usernr3;
    }

    private BigDecimal usernr4;

    @javax.persistence.Column(name = "USERNR4")
    @Basic
    public BigDecimal getUsernr4() {
        return usernr4;
    }

    public void setUsernr4(BigDecimal usernr4) {
        this.usernr4 = usernr4;
    }

    private String pndtes;

    @javax.persistence.Column(name = "PNDTES")
    @Basic
    public String getPndtes() {
        return pndtes;
    }

    public void setPndtes(String pndtes) {
        this.pndtes = pndtes;
    }

    private String promstat;

    @javax.persistence.Column(name = "PROMSTAT")
    @Basic
    public String getPromstat() {
        return promstat;
    }

    public void setPromstat(String promstat) {
        this.promstat = promstat;
    }

    private String pnoteind;

    @javax.persistence.Column(name = "PNOTEIND")
    @Basic
    public String getPnoteind() {
        return pnoteind;
    }

    public void setPnoteind(String pnoteind) {
        this.pnoteind = pnoteind;
    }

    private String pnoteprt;

    @javax.persistence.Column(name = "PNOTEPRT")
    @Basic
    public String getPnoteprt() {
        return pnoteprt;
    }

    public void setPnoteprt(String pnoteprt) {
        this.pnoteprt = pnoteprt;
    }

    private String pnoterec;

    @javax.persistence.Column(name = "PNOTEREC")
    @Basic
    public String getPnoterec() {
        return pnoterec;
    }

    public void setPnoterec(String pnoterec) {
        this.pnoterec = pnoterec;
    }

    private String pnotesnt;

    @javax.persistence.Column(name = "PNOTESNT")
    @Basic
    public String getPnotesnt() {
        return pnotesnt;
    }

    public void setPnotesnt(String pnotesnt) {
        this.pnotesnt = pnotesnt;
    }

    private String unusedb;

    @javax.persistence.Column(name = "UNUSEDB")
    @Basic
    public String getUnusedb() {
        return unusedb;
    }

    public void setUnusedb(String unusedb) {
        this.unusedb = unusedb;
    }

    private String pnotecnf;

    @javax.persistence.Column(name = "PNOTECNF")
    @Basic
    public String getPnotecnf() {
        return pnotecnf;
    }

    public void setPnotecnf(String pnotecnf) {
        this.pnotecnf = pnotecnf;
    }

    private String cancode;

    @javax.persistence.Column(name = "CANCODE")
    @Basic
    public String getCancode() {
        return cancode;
    }

    public void setCancode(String cancode) {
        this.cancode = cancode;
    }

    private String candate;

    @javax.persistence.Column(name = "CANDATE")
    @Basic
    public String getCandate() {
        return candate;
    }

    public void setCandate(String candate) {
        this.candate = candate;
    }

    private String transmit;

    @javax.persistence.Column(name = "TRANSMIT")
    @Basic
    public String getTransmit() {
        return transmit;
    }

    public void setTransmit(String transmit) {
        this.transmit = transmit;
    }

    private String transdte;

    @javax.persistence.Column(name = "TRANSDTE")
    @Basic
    public String getTransdte() {
        return transdte;
    }

    public void setTransdte(String transdte) {
        this.transdte = transdte;
    }

    private String transno;

    @javax.persistence.Column(name = "TRANSNO")
    @Basic
    public String getTransno() {
        return transno;
    }

    public void setTransno(String transno) {
        this.transno = transno;
    }

    private String disdtcd;

    @javax.persistence.Column(name = "DISDTCD")
    @Basic
    public String getDisdtcd() {
        return disdtcd;
    }

    public void setDisdtcd(String disdtcd) {
        this.disdtcd = disdtcd;
    }

    private String holdflg;

    @javax.persistence.Column(name = "HOLDFLG")
    @Basic
    public String getHoldflg() {
        return holdflg;
    }

    public void setHoldflg(String holdflg) {
        this.holdflg = holdflg;
    }

    private String suprind;

    @javax.persistence.Column(name = "SUPRIND")
    @Basic
    public String getSuprind() {
        return suprind;
    }

    public void setSuprind(String suprind) {
        this.suprind = suprind;
    }

    private String typeaid;

    @javax.persistence.Column(name = "TYPEAID")
    @Basic
    public String getTypeaid() {
        return typeaid;
    }

    public void setTypeaid(String typeaid) {
        this.typeaid = typeaid;
    }

    private String dtmflag;

    @javax.persistence.Column(name = "DTMFLAG")
    @Basic
    public String getDtmflag() {
        return dtmflag;
    }

    public void setDtmflag(String dtmflag) {
        this.dtmflag = dtmflag;
    }

    private String dishd01;

    @javax.persistence.Column(name = "DISHD01")
    @Basic
    public String getDishd01() {
        return dishd01;
    }

    public void setDishd01(String dishd01) {
        this.dishd01 = dishd01;
    }

    private String dishd02;

    @javax.persistence.Column(name = "DISHD02")
    @Basic
    public String getDishd02() {
        return dishd02;
    }

    public void setDishd02(String dishd02) {
        this.dishd02 = dishd02;
    }

    private String dishd03;

    @javax.persistence.Column(name = "DISHD03")
    @Basic
    public String getDishd03() {
        return dishd03;
    }

    public void setDishd03(String dishd03) {
        this.dishd03 = dishd03;
    }

    private String dishd04;

    @javax.persistence.Column(name = "DISHD04")
    @Basic
    public String getDishd04() {
        return dishd04;
    }

    public void setDishd04(String dishd04) {
        this.dishd04 = dishd04;
    }

    private String dishd05;

    @javax.persistence.Column(name = "DISHD05")
    @Basic
    public String getDishd05() {
        return dishd05;
    }

    public void setDishd05(String dishd05) {
        this.dishd05 = dishd05;
    }

    private String dishd06;

    @javax.persistence.Column(name = "DISHD06")
    @Basic
    public String getDishd06() {
        return dishd06;
    }

    public void setDishd06(String dishd06) {
        this.dishd06 = dishd06;
    }

    private String dishd07;

    @javax.persistence.Column(name = "DISHD07")
    @Basic
    public String getDishd07() {
        return dishd07;
    }

    public void setDishd07(String dishd07) {
        this.dishd07 = dishd07;
    }

    private String dishd08;

    @javax.persistence.Column(name = "DISHD08")
    @Basic
    public String getDishd08() {
        return dishd08;
    }

    public void setDishd08(String dishd08) {
        this.dishd08 = dishd08;
    }

    private String dishd09;

    @javax.persistence.Column(name = "DISHD09")
    @Basic
    public String getDishd09() {
        return dishd09;
    }

    public void setDishd09(String dishd09) {
        this.dishd09 = dishd09;
    }

    private String dishd10;

    @javax.persistence.Column(name = "DISHD10")
    @Basic
    public String getDishd10() {
        return dishd10;
    }

    public void setDishd10(String dishd10) {
        this.dishd10 = dishd10;
    }

    private String dishd11;

    @javax.persistence.Column(name = "DISHD11")
    @Basic
    public String getDishd11() {
        return dishd11;
    }

    public void setDishd11(String dishd11) {
        this.dishd11 = dishd11;
    }

    private String dishd12;

    @javax.persistence.Column(name = "DISHD12")
    @Basic
    public String getDishd12() {
        return dishd12;
    }

    public void setDishd12(String dishd12) {
        this.dishd12 = dishd12;
    }

    private String dishd13;

    @javax.persistence.Column(name = "DISHD13")
    @Basic
    public String getDishd13() {
        return dishd13;
    }

    public void setDishd13(String dishd13) {
        this.dishd13 = dishd13;
    }

    private String dishd14;

    @javax.persistence.Column(name = "DISHD14")
    @Basic
    public String getDishd14() {
        return dishd14;
    }

    public void setDishd14(String dishd14) {
        this.dishd14 = dishd14;
    }

    private String dishd15;

    @javax.persistence.Column(name = "DISHD15")
    @Basic
    public String getDishd15() {
        return dishd15;
    }

    public void setDishd15(String dishd15) {
        this.dishd15 = dishd15;
    }

    private String dishd16;

    @javax.persistence.Column(name = "DISHD16")
    @Basic
    public String getDishd16() {
        return dishd16;
    }

    public void setDishd16(String dishd16) {
        this.dishd16 = dishd16;
    }

    private String dishd17;

    @javax.persistence.Column(name = "DISHD17")
    @Basic
    public String getDishd17() {
        return dishd17;
    }

    public void setDishd17(String dishd17) {
        this.dishd17 = dishd17;
    }

    private String dishd18;

    @javax.persistence.Column(name = "DISHD18")
    @Basic
    public String getDishd18() {
        return dishd18;
    }

    public void setDishd18(String dishd18) {
        this.dishd18 = dishd18;
    }

    private String dishd19;

    @javax.persistence.Column(name = "DISHD19")
    @Basic
    public String getDishd19() {
        return dishd19;
    }

    public void setDishd19(String dishd19) {
        this.dishd19 = dishd19;
    }

    private String dishd20;

    @javax.persistence.Column(name = "DISHD20")
    @Basic
    public String getDishd20() {
        return dishd20;
    }

    public void setDishd20(String dishd20) {
        this.dishd20 = dishd20;
    }

    private String chgtyp1;

    @javax.persistence.Column(name = "CHGTYP1")
    @Basic
    public String getChgtyp1() {
        return chgtyp1;
    }

    public void setChgtyp1(String chgtyp1) {
        this.chgtyp1 = chgtyp1;
    }

    private String chgdis1;

    @javax.persistence.Column(name = "CHGDIS1")
    @Basic
    public String getChgdis1() {
        return chgdis1;
    }

    public void setChgdis1(String chgdis1) {
        this.chgdis1 = chgdis1;
    }

    private String chgtyp2;

    @javax.persistence.Column(name = "CHGTYP2")
    @Basic
    public String getChgtyp2() {
        return chgtyp2;
    }

    public void setChgtyp2(String chgtyp2) {
        this.chgtyp2 = chgtyp2;
    }

    private String chgdis2;

    @javax.persistence.Column(name = "CHGDIS2")
    @Basic
    public String getChgdis2() {
        return chgdis2;
    }

    public void setChgdis2(String chgdis2) {
        this.chgdis2 = chgdis2;
    }

    private String chgtyp3;

    @javax.persistence.Column(name = "CHGTYP3")
    @Basic
    public String getChgtyp3() {
        return chgtyp3;
    }

    public void setChgtyp3(String chgtyp3) {
        this.chgtyp3 = chgtyp3;
    }

    private String chgdis3;

    @javax.persistence.Column(name = "CHGDIS3")
    @Basic
    public String getChgdis3() {
        return chgdis3;
    }

    public void setChgdis3(String chgdis3) {
        this.chgdis3 = chgdis3;
    }

    private String chgtyp4;

    @javax.persistence.Column(name = "CHGTYP4")
    @Basic
    public String getChgtyp4() {
        return chgtyp4;
    }

    public void setChgtyp4(String chgtyp4) {
        this.chgtyp4 = chgtyp4;
    }

    private String chgdis4;

    @javax.persistence.Column(name = "CHGDIS4")
    @Basic
    public String getChgdis4() {
        return chgdis4;
    }

    public void setChgdis4(String chgdis4) {
        this.chgdis4 = chgdis4;
    }

    private String crefdte;

    @javax.persistence.Column(name = "CREFDTE")
    @Basic
    public String getCrefdte() {
        return crefdte;
    }

    public void setCrefdte(String crefdte) {
        this.crefdte = crefdte;
    }

    private BigDecimal crefamt;

    @javax.persistence.Column(name = "CREFAMT")
    @Basic
    public BigDecimal getCrefamt() {
        return crefamt;
    }

    public void setCrefamt(BigDecimal crefamt) {
        this.crefamt = crefamt;
    }

    private String prefdte;

    @javax.persistence.Column(name = "PREFDTE")
    @Basic
    public String getPrefdte() {
        return prefdte;
    }

    public void setPrefdte(String prefdte) {
        this.prefdte = prefdte;
    }

    private BigDecimal prefamt;

    @javax.persistence.Column(name = "PREFAMT")
    @Basic
    public BigDecimal getPrefamt() {
        return prefamt;
    }

    public void setPrefamt(BigDecimal prefamt) {
        this.prefamt = prefamt;
    }

    private String lcity;

    @javax.persistence.Column(name = "LCITY")
    @Basic
    public String getLcity() {
        return lcity;
    }

    public void setLcity(String lcity) {
        this.lcity = lcity;
    }

    private String lcity2;

    @javax.persistence.Column(name = "LCITY2")
    @Basic
    public String getLcity2() {
        return lcity2;
    }

    public void setLcity2(String lcity2) {
        this.lcity2 = lcity2;
    }

    private String lcity3;

    @javax.persistence.Column(name = "LCITY3")
    @Basic
    public String getLcity3() {
        return lcity3;
    }

    public void setLcity3(String lcity3) {
        this.lcity3 = lcity3;
    }

    private String lstate2;

    @javax.persistence.Column(name = "LSTATE2")
    @Basic
    public String getLstate2() {
        return lstate2;
    }

    public void setLstate2(String lstate2) {
        this.lstate2 = lstate2;
    }

    private String lstate3;

    @javax.persistence.Column(name = "LSTATE3")
    @Basic
    public String getLstate3() {
        return lstate3;
    }

    public void setLstate3(String lstate3) {
        this.lstate3 = lstate3;
    }

    private String lzip;

    @javax.persistence.Column(name = "LZIP")
    @Basic
    public String getLzip() {
        return lzip;
    }

    public void setLzip(String lzip) {
        this.lzip = lzip;
    }

    private String lzip2;

    @javax.persistence.Column(name = "LZIP2")
    @Basic
    public String getLzip2() {
        return lzip2;
    }

    public void setLzip2(String lzip2) {
        this.lzip2 = lzip2;
    }

    private String lzip3;

    @javax.persistence.Column(name = "LZIP3")
    @Basic
    public String getLzip3() {
        return lzip3;
    }

    public void setLzip3(String lzip3) {
        this.lzip3 = lzip3;
    }

    private String mpnind;

    @javax.persistence.Column(name = "MPNIND")
    @Basic
    public String getMpnind() {
        return mpnind;
    }

    public void setMpnind(String mpnind) {
        this.mpnind = mpnind;
    }

    private String product;

    @javax.persistence.Column(name = "PRODUCT")
    @Basic
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    private String unqueid;

    @javax.persistence.Column(name = "UNQUEID")
    @Basic
    public String getUnqueid() {
        return unqueid;
    }

    public void setUnqueid(String unqueid) {
        this.unqueid = unqueid;
    }

    private BigDecimal gfeerte;

    @javax.persistence.Column(name = "GFEERTE")
    @Basic
    public BigDecimal getGfeerte() {
        return gfeerte;
    }

    public void setGfeerte(BigDecimal gfeerte) {
        this.gfeerte = gfeerte;
    }

    private BigDecimal gfeeamt;

    @javax.persistence.Column(name = "GFEEAMT")
    @Basic
    public BigDecimal getGfeeamt() {
        return gfeeamt;
    }

    public void setGfeeamt(BigDecimal gfeeamt) {
        this.gfeeamt = gfeeamt;
    }

    private BigDecimal lfeerte;

    @javax.persistence.Column(name = "LFEERTE")
    @Basic
    public BigDecimal getLfeerte() {
        return lfeerte;
    }

    public void setLfeerte(BigDecimal lfeerte) {
        this.lfeerte = lfeerte;
    }

    private BigDecimal lfeeamt;

    @javax.persistence.Column(name = "LFEEAMT")
    @Basic
    public BigDecimal getLfeeamt() {
        return lfeeamt;
    }

    public void setLfeeamt(BigDecimal lfeeamt) {
        this.lfeeamt = lfeeamt;
    }

    private BigDecimal intrate;

    @javax.persistence.Column(name = "INTRATE")
    @Basic
    public BigDecimal getIntrate() {
        return intrate;
    }

    public void setIntrate(BigDecimal intrate) {
        this.intrate = intrate;
    }

    private BigDecimal rebrate;

    @javax.persistence.Column(name = "REBRATE")
    @Basic
    public BigDecimal getRebrate() {
        return rebrate;
    }

    public void setRebrate(BigDecimal rebrate) {
        this.rebrate = rebrate;
    }

    private BigDecimal rebamt;

    @javax.persistence.Column(name = "REBAMT")
    @Basic
    public BigDecimal getRebamt() {
        return rebamt;
    }

    public void setRebamt(BigDecimal rebamt) {
        this.rebamt = rebamt;
    }

    private BigDecimal arebamt;

    @javax.persistence.Column(name = "AREBAMT")
    @Basic
    public BigDecimal getArebamt() {
        return arebamt;
    }

    public void setArebamt(BigDecimal arebamt) {
        this.arebamt = arebamt;
    }

    private BigDecimal amtapp;

    @javax.persistence.Column(name = "AMTAPP")
    @Basic
    public BigDecimal getAmtapp() {
        return amtapp;
    }

    public void setAmtapp(BigDecimal amtapp) {
        this.amtapp = amtapp;
    }

    private BigDecimal reqloan;

    @javax.persistence.Column(name = "REQLOAN")
    @Basic
    public BigDecimal getReqloan() {
        return reqloan;
    }

    public void setReqloan(BigDecimal reqloan) {
        this.reqloan = reqloan;
    }

    private String sdob;

    @javax.persistence.Column(name = "SDOB")
    @Basic
    public String getSdob() {
        return sdob;
    }

    public void setSdob(String sdob) {
        this.sdob = sdob;
    }

    private String sdob2;

    @javax.persistence.Column(name = "SDOB2")
    @Basic
    public String getSdob2() {
        return sdob2;
    }

    public void setSdob2(String sdob2) {
        this.sdob2 = sdob2;
    }

    private String sdob3;

    @javax.persistence.Column(name = "SDOB3")
    @Basic
    public String getSdob3() {
        return sdob3;
    }

    public void setSdob3(String sdob3) {
        this.sdob3 = sdob3;
    }

    private String origdte;

    @javax.persistence.Column(name = "ORIGDTE")
    @Basic
    public String getOrigdte() {
        return origdte;
    }

    public void setOrigdte(String origdte) {
        this.origdte = origdte;
    }

    private String unusedc;

    @javax.persistence.Column(name = "UNUSEDC")
    @Basic
    public String getUnusedc() {
        return unusedc;
    }

    public void setUnusedc(String unusedc) {
        this.unusedc = unusedc;
    }

    private String ssncdte;

    @javax.persistence.Column(name = "SSNCDTE")
    @Basic
    public String getSsncdte() {
        return ssncdte;
    }

    public void setSsncdte(String ssncdte) {
        this.ssncdte = ssncdte;
    }

    private String dobcdte;

    @javax.persistence.Column(name = "DOBCDTE")
    @Basic
    public String getDobcdte() {
        return dobcdte;
    }

    public void setDobcdte(String dobcdte) {
        this.dobcdte = dobcdte;
    }

    private String lacdte;

    @javax.persistence.Column(name = "LACDTE")
    @Basic
    public String getLacdte() {
        return lacdte;
    }

    public void setLacdte(String lacdte) {
        this.lacdte = lacdte;
    }

    private String pluserq;

    @javax.persistence.Column(name = "PLUSERQ")
    @Basic
    public String getPluserq() {
        return pluserq;
    }

    public void setPluserq(String pluserq) {
        this.pluserq = pluserq;
    }

    private String plusbch;

    @javax.persistence.Column(name = "PLUSBCH")
    @Basic
    public String getPlusbch() {
        return plusbch;
    }

    public void setPlusbch(String plusbch) {
        this.plusbch = plusbch;
    }

    private String plusrq3;

    @javax.persistence.Column(name = "PLUSRQ3")
    @Basic
    public String getPlusrq3() {
        return plusrq3;
    }

    public void setPlusrq3(String plusrq3) {
        this.plusrq3 = plusrq3;
    }

    private BigInteger pnseqn3;

    @javax.persistence.Column(name = "PNSEQN3")
    @Basic
    public BigInteger getPnseqn3() {
        return pnseqn3;
    }

    public void setPnseqn3(BigInteger pnseqn3) {
        this.pnseqn3 = pnseqn3;
    }

    private String srcode;

    @javax.persistence.Column(name = "SRCODE")
    @Basic
    public String getSrcode() {
        return srcode;
    }

    public void setSrcode(String srcode) {
        this.srcode = srcode;
    }

    private String healfl;

    @javax.persistence.Column(name = "HEALFL")
    @Basic
    public String getHealfl() {
        return healfl;
    }

    public void setHealfl(String healfl) {
        this.healfl = healfl;
    }

    private String bkstat;

    @javax.persistence.Column(name = "BKSTAT")
    @Basic
    public String getBkstat() {
        return bkstat;
    }

    public void setBkstat(String bkstat) {
        this.bkstat = bkstat;
    }

    private String bkdate;

    @javax.persistence.Column(name = "BKDATE")
    @Basic
    public String getBkdate() {
        return bkdate;
    }

    public void setBkdate(String bkdate) {
        this.bkdate = bkdate;
    }

    private String orgcbth;

    @javax.persistence.Column(name = "ORGCBTH")
    @Basic
    public String getOrgcbth() {
        return orgcbth;
    }

    public void setOrgcbth(String orgcbth) {
        this.orgcbth = orgcbth;
    }

    private String senrst;

    @javax.persistence.Column(name = "SENRST")
    @Basic
    public String getSenrst() {
        return senrst;
    }

    public void setSenrst(String senrst) {
        this.senrst = senrst;
    }

    private String senrst2;

    @javax.persistence.Column(name = "SENRST2")
    @Basic
    public String getSenrst2() {
        return senrst2;
    }

    public void setSenrst2(String senrst2) {
        this.senrst2 = senrst2;
    }

    private String senrst3;

    @javax.persistence.Column(name = "SENRST3")
    @Basic
    public String getSenrst3() {
        return senrst3;
    }

    public void setSenrst3(String senrst3) {
        this.senrst3 = senrst3;
    }

    private String errcd1;

    @javax.persistence.Column(name = "ERRCD1")
    @Basic
    public String getErrcd1() {
        return errcd1;
    }

    public void setErrcd1(String errcd1) {
        this.errcd1 = errcd1;
    }

    private String errcd2;

    @javax.persistence.Column(name = "ERRCD2")
    @Basic
    public String getErrcd2() {
        return errcd2;
    }

    public void setErrcd2(String errcd2) {
        this.errcd2 = errcd2;
    }

    private String errcd3;

    @javax.persistence.Column(name = "ERRCD3")
    @Basic
    public String getErrcd3() {
        return errcd3;
    }

    public void setErrcd3(String errcd3) {
        this.errcd3 = errcd3;
    }

    private String errcd4;

    @javax.persistence.Column(name = "ERRCD4")
    @Basic
    public String getErrcd4() {
        return errcd4;
    }

    public void setErrcd4(String errcd4) {
        this.errcd4 = errcd4;
    }

    private String errcd5;

    @javax.persistence.Column(name = "ERRCD5")
    @Basic
    public String getErrcd5() {
        return errcd5;
    }

    public void setErrcd5(String errcd5) {
        this.errcd5 = errcd5;
    }

    private String lendid;

    @javax.persistence.Column(name = "LENDID")
    @Basic
    public String getLendid() {
        return lendid;
    }

    public void setLendid(String lendid) {
        this.lendid = lendid;
    }

    private String guarid;

    @javax.persistence.Column(name = "GUARID")
    @Basic
    public String getGuarid() {
        return guarid;
    }

    public void setGuarid(String guarid) {
        this.guarid = guarid;
    }

    private String pcity2;

    @javax.persistence.Column(name = "PCITY2")
    @Basic
    public String getPcity2() {
        return pcity2;
    }

    public void setPcity2(String pcity2) {
        this.pcity2 = pcity2;
    }

    private String pcity3;

    @javax.persistence.Column(name = "PCITY3")
    @Basic
    public String getPcity3() {
        return pcity3;
    }

    public void setPcity3(String pcity3) {
        this.pcity3 = pcity3;
    }

    private String samexp;

    @javax.persistence.Column(name = "SAMEXP")
    @Basic
    public String getSamexp() {
        return samexp;
    }

    public void setSamexp(String samexp) {
        this.samexp = samexp;
    }

    private String paddrst;

    @javax.persistence.Column(name = "PADDRST")
    @Basic
    public String getPaddrst() {
        return paddrst;
    }

    public void setPaddrst(String paddrst) {
        this.paddrst = paddrst;
    }

    private String paddr2S;

    @javax.persistence.Column(name = "PADDR2S")
    @Basic
    public String getPaddr2S() {
        return paddr2S;
    }

    public void setPaddr2S(String paddr2S) {
        this.paddr2S = paddr2S;
    }

    private String pcityst;

    @javax.persistence.Column(name = "PCITYST")
    @Basic
    public String getPcityst() {
        return pcityst;
    }

    public void setPcityst(String pcityst) {
        this.pcityst = pcityst;
    }

    private String pstates;

    @javax.persistence.Column(name = "PSTATES")
    @Basic
    public String getPstates() {
        return pstates;
    }

    public void setPstates(String pstates) {
        this.pstates = pstates;
    }

    private String pzipst;

    @javax.persistence.Column(name = "PZIPST")
    @Basic
    public String getPzipst() {
        return pzipst;
    }

    public void setPzipst(String pzipst) {
        this.pzipst = pzipst;
    }

    private String pphones;

    @javax.persistence.Column(name = "PPHONES")
    @Basic
    public String getPphones() {
        return pphones;
    }

    public void setPphones(String pphones) {
        this.pphones = pphones;
    }

    private String pdtlst;

    @javax.persistence.Column(name = "PDTLST")
    @Basic
    public String getPdtlst() {
        return pdtlst;
    }

    public void setPdtlst(String pdtlst) {
        this.pdtlst = pdtlst;
    }

    private String pndlst;

    @javax.persistence.Column(name = "PNDLST")
    @Basic
    public String getPndlst() {
        return pndlst;
    }

    public void setPndlst(String pndlst) {
        this.pndlst = pndlst;
    }

    private String pnamel;

    @javax.persistence.Column(name = "PNAMEL")
    @Basic
    public String getPnamel() {
        return pnamel;
    }

    public void setPnamel(String pnamel) {
        this.pnamel = pnamel;
    }

    private String pnamef;

    @javax.persistence.Column(name = "PNAMEF")
    @Basic
    public String getPnamef() {
        return pnamef;
    }

    public void setPnamef(String pnamef) {
        this.pnamef = pnamef;
    }

    private String pnamem;

    @javax.persistence.Column(name = "PNAMEM")
    @Basic
    public String getPnamem() {
        return pnamem;
    }

    public void setPnamem(String pnamem) {
        this.pnamem = pnamem;
    }

    private String pcity;

    @javax.persistence.Column(name = "PCITY")
    @Basic
    public String getPcity() {
        return pcity;
    }

    public void setPcity(String pcity) {
        this.pcity = pcity;
    }

    private String pstate;

    @javax.persistence.Column(name = "PSTATE")
    @Basic
    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    private String pzip;

    @javax.persistence.Column(name = "PZIP")
    @Basic
    public String getPzip() {
        return pzip;
    }

    public void setPzip(String pzip) {
        this.pzip = pzip;
    }

    private String pphone;

    @javax.persistence.Column(name = "PPHONE")
    @Basic
    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    private String pdtl;

    @javax.persistence.Column(name = "PDTL")
    @Basic
    public String getPdtl() {
        return pdtl;
    }

    public void setPdtl(String pdtl) {
        this.pdtl = pdtl;
    }

    private String pnumdl;

    @javax.persistence.Column(name = "PNUMDL")
    @Basic
    public String getPnumdl() {
        return pnumdl;
    }

    public void setPnumdl(String pnumdl) {
        this.pnumdl = pnumdl;
    }

    private String borwid;

    @javax.persistence.Column(name = "BORWID")
    @Basic
    public String getBorwid() {
        return borwid;
    }

    public void setBorwid(String borwid) {
        this.borwid = borwid;
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

    private String class2;

    @javax.persistence.Column(name = "CLASS2")
    @Basic
    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    private String class3;

    @javax.persistence.Column(name = "CLASS3")
    @Basic
    public String getClass3() {
        return class3;
    }

    public void setClass3(String class3) {
        this.class3 = class3;
    }

    private String pnsign;

    @javax.persistence.Column(name = "PNSIGN")
    @Basic
    public String getPnsign() {
        return pnsign;
    }

    public void setPnsign(String pnsign) {
        this.pnsign = pnsign;
    }

    private String pnsign2;

    @javax.persistence.Column(name = "PNSIGN2")
    @Basic
    public String getPnsign2() {
        return pnsign2;
    }

    public void setPnsign2(String pnsign2) {
        this.pnsign2 = pnsign2;
    }

    private String pnsign3;

    @javax.persistence.Column(name = "PNSIGN3")
    @Basic
    public String getPnsign3() {
        return pnsign3;
    }

    public void setPnsign3(String pnsign3) {
        this.pnsign3 = pnsign3;
    }

    private String alpnmt;

    @javax.persistence.Column(name = "ALPNMT")
    @Basic
    public String getAlpnmt() {
        return alpnmt;
    }

    public void setAlpnmt(String alpnmt) {
        this.alpnmt = alpnmt;
    }

    private String alpnmt2;

    @javax.persistence.Column(name = "ALPNMT2")
    @Basic
    public String getAlpnmt2() {
        return alpnmt2;
    }

    public void setAlpnmt2(String alpnmt2) {
        this.alpnmt2 = alpnmt2;
    }

    private String alpnmt3;

    @javax.persistence.Column(name = "ALPNMT3")
    @Basic
    public String getAlpnmt3() {
        return alpnmt3;
    }

    public void setAlpnmt3(String alpnmt3) {
        this.alpnmt3 = alpnmt3;
    }

    private String percd;

    @javax.persistence.Column(name = "PERCD")
    @Basic
    public String getPercd() {
        return percd;
    }

    public void setPercd(String percd) {
        this.percd = percd;
    }

    private String percd2;

    @javax.persistence.Column(name = "PERCD2")
    @Basic
    public String getPercd2() {
        return percd2;
    }

    public void setPercd2(String percd2) {
        this.percd2 = percd2;
    }

    private String percd3;

    @javax.persistence.Column(name = "PERCD3")
    @Basic
    public String getPercd3() {
        return percd3;
    }

    public void setPercd3(String percd3) {
        this.percd3 = percd3;
    }

    private String spnsg;

    @javax.persistence.Column(name = "SPNSG")
    @Basic
    public String getSpnsg() {
        return spnsg;
    }

    public void setSpnsg(String spnsg) {
        this.spnsg = spnsg;
    }

    private String spnsg2;

    @javax.persistence.Column(name = "SPNSG2")
    @Basic
    public String getSpnsg2() {
        return spnsg2;
    }

    public void setSpnsg2(String spnsg2) {
        this.spnsg2 = spnsg2;
    }

    private String spnsg3;

    @javax.persistence.Column(name = "SPNSG3")
    @Basic
    public String getSpnsg3() {
        return spnsg3;
    }

    public void setSpnsg3(String spnsg3) {
        this.spnsg3 = spnsg3;
    }

    private String lstate;

    @javax.persistence.Column(name = "LSTATE")
    @Basic
    public String getLstate() {
        return lstate;
    }

    public void setLstate(String lstate) {
        this.lstate = lstate;
    }

    private String pacdte;

    @javax.persistence.Column(name = "PACDTE")
    @Basic
    public String getPacdte() {
        return pacdte;
    }

    public void setPacdte(String pacdte) {
        this.pacdte = pacdte;
    }

    private String vendor2;

    @javax.persistence.Column(name = "VENDOR2")
    @Basic
    public String getVendor2() {
        return vendor2;
    }

    public void setVendor2(String vendor2) {
        this.vendor2 = vendor2;
    }

    private String default2;

    @javax.persistence.Column(name = "DEFAULT2")
    @Basic
    public String getDefault2() {
        return default2;
    }

    public void setDefault2(String default2) {
        this.default2 = default2;
    }

    private String prodte2;

    @javax.persistence.Column(name = "PRODTE2")
    @Basic
    public String getProdte2() {
        return prodte2;
    }

    public void setProdte2(String prodte2) {
        this.prodte2 = prodte2;
    }

    private String strdte2;

    @javax.persistence.Column(name = "STRDTE2")
    @Basic
    public String getStrdte2() {
        return strdte2;
    }

    public void setStrdte2(String strdte2) {
        this.strdte2 = strdte2;
    }

    private String perbeg2;

    @javax.persistence.Column(name = "PERBEG2")
    @Basic
    public String getPerbeg2() {
        return perbeg2;
    }

    public void setPerbeg2(String perbeg2) {
        this.perbeg2 = perbeg2;
    }

    private String perend2;

    @javax.persistence.Column(name = "PEREND2")
    @Basic
    public String getPerend2() {
        return perend2;
    }

    public void setPerend2(String perend2) {
        this.perend2 = perend2;
    }

    private String senrsdt2;

    @javax.persistence.Column(name = "SENRSDT2")
    @Basic
    public String getSenrsdt2() {
        return senrsdt2;
    }

    public void setSenrsdt2(String senrsdt2) {
        this.senrsdt2 = senrsdt2;
    }

    private String pndtes2;

    @javax.persistence.Column(name = "PNDTES2")
    @Basic
    public String getPndtes2() {
        return pndtes2;
    }

    public void setPndtes2(String pndtes2) {
        this.pndtes2 = pndtes2;
    }

    private String pnotend2;

    @javax.persistence.Column(name = "PNOTEND2")
    @Basic
    public String getPnotend2() {
        return pnotend2;
    }

    public void setPnotend2(String pnotend2) {
        this.pnotend2 = pnotend2;
    }

    private String pnotrec2;

    @javax.persistence.Column(name = "PNOTREC2")
    @Basic
    public String getPnotrec2() {
        return pnotrec2;
    }

    public void setPnotrec2(String pnotrec2) {
        this.pnotrec2 = pnotrec2;
    }

    private String lcancde2;

    @javax.persistence.Column(name = "LCANCDE2")
    @Basic
    public String getLcancde2() {
        return lcancde2;
    }

    public void setLcancde2(String lcancde2) {
        this.lcancde2 = lcancde2;
    }

    private String lcandte2;

    @javax.persistence.Column(name = "LCANDTE2")
    @Basic
    public String getLcandte2() {
        return lcandte2;
    }

    public void setLcandte2(String lcandte2) {
        this.lcandte2 = lcandte2;
    }

    private String parssn2;

    @javax.persistence.Column(name = "PARSSN2")
    @Basic
    public String getParssn2() {
        return parssn2;
    }

    public void setParssn2(String parssn2) {
        this.parssn2 = parssn2;
    }

    private BigDecimal amtapp2;

    @javax.persistence.Column(name = "AMTAPP2")
    @Basic
    public BigDecimal getAmtapp2() {
        return amtapp2;
    }

    public void setAmtapp2(BigDecimal amtapp2) {
        this.amtapp2 = amtapp2;
    }

    private BigDecimal reqln2;

    @javax.persistence.Column(name = "REQLN2")
    @Basic
    public BigDecimal getReqln2() {
        return reqln2;
    }

    public void setReqln2(BigDecimal reqln2) {
        this.reqln2 = reqln2;
    }

    private String pdob2;

    @javax.persistence.Column(name = "PDOB2")
    @Basic
    public String getPdob2() {
        return pdob2;
    }

    public void setPdob2(String pdob2) {
        this.pdob2 = pdob2;
    }

    private String pcitzen2;

    @javax.persistence.Column(name = "PCITZEN2")
    @Basic
    public String getPcitzen2() {
        return pcitzen2;
    }

    public void setPcitzen2(String pcitzen2) {
        this.pcitzen2 = pcitzen2;
    }

    private String parn2;

    @javax.persistence.Column(name = "PARN2")
    @Basic
    public String getParn2() {
        return parn2;
    }

    public void setParn2(String parn2) {
        this.parn2 = parn2;
    }

    private String pdefalt2;

    @javax.persistence.Column(name = "PDEFALT2")
    @Basic
    public String getPdefalt2() {
        return pdefalt2;
    }

    public void setPdefalt2(String pdefalt2) {
        this.pdefalt2 = pdefalt2;
    }

    private String pdtesgn2;

    @javax.persistence.Column(name = "PDTESGN2")
    @Basic
    public String getPdtesgn2() {
        return pdtesgn2;
    }

    public void setPdtesgn2(String pdtesgn2) {
        this.pdtesgn2 = pdtesgn2;
    }

    private String pnotprt2;

    @javax.persistence.Column(name = "PNOTPRT2")
    @Basic
    public String getPnotprt2() {
        return pnotprt2;
    }

    public void setPnotprt2(String pnotprt2) {
        this.pnotprt2 = pnotprt2;
    }

    private String borwid2;

    @javax.persistence.Column(name = "BORWID2")
    @Basic
    public String getBorwid2() {
        return borwid2;
    }

    public void setBorwid2(String borwid2) {
        this.borwid2 = borwid2;
    }

    private String pstate2;

    @javax.persistence.Column(name = "PSTATE2")
    @Basic
    public String getPstate2() {
        return pstate2;
    }

    public void setPstate2(String pstate2) {
        this.pstate2 = pstate2;
    }

    private String pzip2;

    @javax.persistence.Column(name = "PZIP2")
    @Basic
    public String getPzip2() {
        return pzip2;
    }

    public void setPzip2(String pzip2) {
        this.pzip2 = pzip2;
    }

    private String pphone2;

    @javax.persistence.Column(name = "PPHONE2")
    @Basic
    public String getPphone2() {
        return pphone2;
    }

    public void setPphone2(String pphone2) {
        this.pphone2 = pphone2;
    }

    private String pdtl2;

    @javax.persistence.Column(name = "PDTL2")
    @Basic
    public String getPdtl2() {
        return pdtl2;
    }

    public void setPdtl2(String pdtl2) {
        this.pdtl2 = pdtl2;
    }

    private String pnumdl2;

    @javax.persistence.Column(name = "PNUMDL2")
    @Basic
    public String getPnumdl2() {
        return pnumdl2;
    }

    public void setPnumdl2(String pnumdl2) {
        this.pnumdl2 = pnumdl2;
    }

    private String sarn2;

    @javax.persistence.Column(name = "SARN2")
    @Basic
    public String getSarn2() {
        return sarn2;
    }

    public void setSarn2(String sarn2) {
        this.sarn2 = sarn2;
    }

    private String sctzen2;

    @javax.persistence.Column(name = "SCTZEN2")
    @Basic
    public String getSctzen2() {
        return sctzen2;
    }

    public void setSctzen2(String sctzen2) {
        this.sctzen2 = sctzen2;
    }

    private String pnotind2;

    @javax.persistence.Column(name = "PNOTIND2")
    @Basic
    public String getPnotind2() {
        return pnotind2;
    }

    public void setPnotind2(String pnotind2) {
        this.pnotind2 = pnotind2;
    }

    private String vendor3;

    @javax.persistence.Column(name = "VENDOR3")
    @Basic
    public String getVendor3() {
        return vendor3;
    }

    public void setVendor3(String vendor3) {
        this.vendor3 = vendor3;
    }

    private String default3;

    @javax.persistence.Column(name = "DEFAULT3")
    @Basic
    public String getDefault3() {
        return default3;
    }

    public void setDefault3(String default3) {
        this.default3 = default3;
    }

    private String prodte3;

    @javax.persistence.Column(name = "PRODTE3")
    @Basic
    public String getProdte3() {
        return prodte3;
    }

    public void setProdte3(String prodte3) {
        this.prodte3 = prodte3;
    }

    private String strdte3;

    @javax.persistence.Column(name = "STRDTE3")
    @Basic
    public String getStrdte3() {
        return strdte3;
    }

    public void setStrdte3(String strdte3) {
        this.strdte3 = strdte3;
    }

    private String perbeg3;

    @javax.persistence.Column(name = "PERBEG3")
    @Basic
    public String getPerbeg3() {
        return perbeg3;
    }

    public void setPerbeg3(String perbeg3) {
        this.perbeg3 = perbeg3;
    }

    private String perend3;

    @javax.persistence.Column(name = "PEREND3")
    @Basic
    public String getPerend3() {
        return perend3;
    }

    public void setPerend3(String perend3) {
        this.perend3 = perend3;
    }

    private String senrsdt3;

    @javax.persistence.Column(name = "SENRSDT3")
    @Basic
    public String getSenrsdt3() {
        return senrsdt3;
    }

    public void setSenrsdt3(String senrsdt3) {
        this.senrsdt3 = senrsdt3;
    }

    private String pndtes3;

    @javax.persistence.Column(name = "PNDTES3")
    @Basic
    public String getPndtes3() {
        return pndtes3;
    }

    public void setPndtes3(String pndtes3) {
        this.pndtes3 = pndtes3;
    }

    private String pnotend3;

    @javax.persistence.Column(name = "PNOTEND3")
    @Basic
    public String getPnotend3() {
        return pnotend3;
    }

    public void setPnotend3(String pnotend3) {
        this.pnotend3 = pnotend3;
    }

    private String pnotrec3;

    @javax.persistence.Column(name = "PNOTREC3")
    @Basic
    public String getPnotrec3() {
        return pnotrec3;
    }

    public void setPnotrec3(String pnotrec3) {
        this.pnotrec3 = pnotrec3;
    }

    private String lcancde3;

    @javax.persistence.Column(name = "LCANCDE3")
    @Basic
    public String getLcancde3() {
        return lcancde3;
    }

    public void setLcancde3(String lcancde3) {
        this.lcancde3 = lcancde3;
    }

    private String lcandte3;

    @javax.persistence.Column(name = "LCANDTE3")
    @Basic
    public String getLcandte3() {
        return lcandte3;
    }

    public void setLcandte3(String lcandte3) {
        this.lcandte3 = lcandte3;
    }

    private String parssn3;

    @javax.persistence.Column(name = "PARSSN3")
    @Basic
    public String getParssn3() {
        return parssn3;
    }

    public void setParssn3(String parssn3) {
        this.parssn3 = parssn3;
    }

    private BigDecimal amtapp3;

    @javax.persistence.Column(name = "AMTAPP3")
    @Basic
    public BigDecimal getAmtapp3() {
        return amtapp3;
    }

    public void setAmtapp3(BigDecimal amtapp3) {
        this.amtapp3 = amtapp3;
    }

    private BigDecimal reqln3;

    @javax.persistence.Column(name = "REQLN3")
    @Basic
    public BigDecimal getReqln3() {
        return reqln3;
    }

    public void setReqln3(BigDecimal reqln3) {
        this.reqln3 = reqln3;
    }

    private String pdob3;

    @javax.persistence.Column(name = "PDOB3")
    @Basic
    public String getPdob3() {
        return pdob3;
    }

    public void setPdob3(String pdob3) {
        this.pdob3 = pdob3;
    }

    private String pcitzen3;

    @javax.persistence.Column(name = "PCITZEN3")
    @Basic
    public String getPcitzen3() {
        return pcitzen3;
    }

    public void setPcitzen3(String pcitzen3) {
        this.pcitzen3 = pcitzen3;
    }

    private String parn3;

    @javax.persistence.Column(name = "PARN3")
    @Basic
    public String getParn3() {
        return parn3;
    }

    public void setParn3(String parn3) {
        this.parn3 = parn3;
    }

    private String pdefalt3;

    @javax.persistence.Column(name = "PDEFALT3")
    @Basic
    public String getPdefalt3() {
        return pdefalt3;
    }

    public void setPdefalt3(String pdefalt3) {
        this.pdefalt3 = pdefalt3;
    }

    private String pdtesgn3;

    @javax.persistence.Column(name = "PDTESGN3")
    @Basic
    public String getPdtesgn3() {
        return pdtesgn3;
    }

    public void setPdtesgn3(String pdtesgn3) {
        this.pdtesgn3 = pdtesgn3;
    }

    private String pnotprt3;

    @javax.persistence.Column(name = "PNOTPRT3")
    @Basic
    public String getPnotprt3() {
        return pnotprt3;
    }

    public void setPnotprt3(String pnotprt3) {
        this.pnotprt3 = pnotprt3;
    }

    private String borwid3;

    @javax.persistence.Column(name = "BORWID3")
    @Basic
    public String getBorwid3() {
        return borwid3;
    }

    public void setBorwid3(String borwid3) {
        this.borwid3 = borwid3;
    }

    private String pstate3;

    @javax.persistence.Column(name = "PSTATE3")
    @Basic
    public String getPstate3() {
        return pstate3;
    }

    public void setPstate3(String pstate3) {
        this.pstate3 = pstate3;
    }

    private String pzip3;

    @javax.persistence.Column(name = "PZIP3")
    @Basic
    public String getPzip3() {
        return pzip3;
    }

    public void setPzip3(String pzip3) {
        this.pzip3 = pzip3;
    }

    private String pphone3;

    @javax.persistence.Column(name = "PPHONE3")
    @Basic
    public String getPphone3() {
        return pphone3;
    }

    public void setPphone3(String pphone3) {
        this.pphone3 = pphone3;
    }

    private String pdtl3;

    @javax.persistence.Column(name = "PDTL3")
    @Basic
    public String getPdtl3() {
        return pdtl3;
    }

    public void setPdtl3(String pdtl3) {
        this.pdtl3 = pdtl3;
    }

    private String pnumdl3;

    @javax.persistence.Column(name = "PNUMDL3")
    @Basic
    public String getPnumdl3() {
        return pnumdl3;
    }

    public void setPnumdl3(String pnumdl3) {
        this.pnumdl3 = pnumdl3;
    }

    private String sarn3;

    @javax.persistence.Column(name = "SARN3")
    @Basic
    public String getSarn3() {
        return sarn3;
    }

    public void setSarn3(String sarn3) {
        this.sarn3 = sarn3;
    }

    private String sctzen3;

    @javax.persistence.Column(name = "SCTZEN3")
    @Basic
    public String getSctzen3() {
        return sctzen3;
    }

    public void setSctzen3(String sctzen3) {
        this.sctzen3 = sctzen3;
    }

    private String pnotind3;

    @javax.persistence.Column(name = "PNOTIND3")
    @Basic
    public String getPnotind3() {
        return pnotind3;
    }

    public void setPnotind3(String pnotind3) {
        this.pnotind3 = pnotind3;
    }

    private String parssn;

    @javax.persistence.Column(name = "PARSSN")
    @Basic
    public String getParssn() {
        return parssn;
    }

    public void setParssn(String parssn) {
        this.parssn = parssn;
    }

    private String pdob;

    @javax.persistence.Column(name = "PDOB")
    @Basic
    public String getPdob() {
        return pdob;
    }

    public void setPdob(String pdob) {
        this.pdob = pdob;
    }

    private String pcitizen;

    @javax.persistence.Column(name = "PCITIZEN")
    @Basic
    public String getPcitizen() {
        return pcitizen;
    }

    public void setPcitizen(String pcitizen) {
        this.pcitizen = pcitizen;
    }

    private String parn;

    @javax.persistence.Column(name = "PARN")
    @Basic
    public String getParn() {
        return parn;
    }

    public void setParn(String parn) {
        this.parn = parn;
    }

    private String pdefault;

    @javax.persistence.Column(name = "PDEFAULT")
    @Basic
    public String getPdefault() {
        return pdefault;
    }

    public void setPdefault(String pdefault) {
        this.pdefault = pdefault;
    }

    private String pdtesign;

    @javax.persistence.Column(name = "PDTESIGN")
    @Basic
    public String getPdtesign() {
        return pdtesign;
    }

    public void setPdtesign(String pdtesign) {
        this.pdtesign = pdtesign;
    }

    private String sarn;

    @javax.persistence.Column(name = "SARN")
    @Basic
    public String getSarn() {
        return sarn;
    }

    public void setSarn(String sarn) {
        this.sarn = sarn;
    }

    private String sctzen;

    @javax.persistence.Column(name = "SCTZEN")
    @Basic
    public String getSctzen() {
        return sctzen;
    }

    public void setSctzen(String sctzen) {
        this.sctzen = sctzen;
    }

    private String lcoment;

    @javax.persistence.Column(name = "LCOMENT")
    @Basic
    public String getLcoment() {
        return lcoment;
    }

    public void setLcoment(String lcoment) {
        this.lcoment = lcoment;
    }

    private String usubamt;

    @javax.persistence.Column(name = "USUBAMT")
    @Basic
    public String getUsubamt() {
        return usubamt;
    }

    public void setUsubamt(String usubamt) {
        this.usubamt = usubamt;
    }

    private String usubamt2;

    @javax.persistence.Column(name = "USUBAMT2")
    @Basic
    public String getUsubamt2() {
        return usubamt2;
    }

    public void setUsubamt2(String usubamt2) {
        this.usubamt2 = usubamt2;
    }

    private String usubamt3;

    @javax.persistence.Column(name = "USUBAMT3")
    @Basic
    public String getUsubamt3() {
        return usubamt3;
    }

    public void setUsubamt3(String usubamt3) {
        this.usubamt3 = usubamt3;
    }

    private String origbtch;

    @javax.persistence.Column(name = "ORIGBTCH")
    @Basic
    public String getOrigbtch() {
        return origbtch;
    }

    public void setOrigbtch(String origbtch) {
        this.origbtch = origbtch;
    }

    private String pnotebth;

    @javax.persistence.Column(name = "PNOTEBTH")
    @Basic
    public String getPnotebth() {
        return pnotebth;
    }

    public void setPnotebth(String pnotebth) {
        this.pnotebth = pnotebth;
    }

    private String enddat;

    @javax.persistence.Column(name = "ENDDAT")
    @Basic
    public String getEnddat() {
        return enddat;
    }

    public void setEnddat(String enddat) {
        this.enddat = enddat;
    }

    private String enddat2;

    @javax.persistence.Column(name = "ENDDAT2")
    @Basic
    public String getEnddat2() {
        return enddat2;
    }

    public void setEnddat2(String enddat2) {
        this.enddat2 = enddat2;
    }

    private String enddat3;

    @javax.persistence.Column(name = "ENDDAT3")
    @Basic
    public String getEnddat3() {
        return enddat3;
    }

    public void setEnddat3(String enddat3) {
        this.enddat3 = enddat3;
    }

    private String apgsid;

    @javax.persistence.Column(name = "APGSID")
    @Basic
    public String getApgsid() {
        return apgsid;
    }

    public void setApgsid(String apgsid) {
        this.apgsid = apgsid;
    }

    private String alntype;

    @javax.persistence.Column(name = "ALNTYPE")
    @Basic
    public String getAlntype() {
        return alntype;
    }

    public void setAlntype(String alntype) {
        this.alntype = alntype;
    }

    private String aprocyr;

    @javax.persistence.Column(name = "APROCYR")
    @Basic
    public String getAprocyr() {
        return aprocyr;
    }

    public void setAprocyr(String aprocyr) {
        this.aprocyr = aprocyr;
    }

    private String aschcode;

    @javax.persistence.Column(name = "ASCHCODE")
    @Basic
    public String getAschcode() {
        return aschcode;
    }

    public void setAschcode(String aschcode) {
        this.aschcode = aschcode;
    }

    private String aseqno2;

    @javax.persistence.Column(name = "ASEQNO2")
    @Basic
    public String getAseqno2() {
        return aseqno2;
    }

    public void setAseqno2(String aseqno2) {
        this.aseqno2 = aseqno2;
    }

    private String unused1;

    @javax.persistence.Column(name = "UNUSED1")
    @Basic
    public String getUnused1() {
        return unused1;
    }

    public void setUnused1(String unused1) {
        this.unused1 = unused1;
    }

    private String mpnstat;

    @javax.persistence.Column(name = "MPNSTAT")
    @Basic
    public String getMpnstat() {
        return mpnstat;
    }

    public void setMpnstat(String mpnstat) {
        this.mpnstat = mpnstat;
    }

    private BigDecimal mpnamt;

    @javax.persistence.Column(name = "MPNAMT")
    @Basic
    public BigDecimal getMpnamt() {
        return mpnamt;
    }

    public void setMpnamt(BigDecimal mpnamt) {
        this.mpnamt = mpnamt;
    }

    private String mpnid;

    @javax.persistence.Column(name = "MPNID")
    @Basic
    public String getMpnid() {
        return mpnid;
    }

    public void setMpnid(String mpnid) {
        this.mpnid = mpnid;
    }

    private BigDecimal mpnrqat;

    @javax.persistence.Column(name = "MPNRQAT")
    @Basic
    public BigDecimal getMpnrqat() {
        return mpnrqat;
    }

    public void setMpnrqat(BigDecimal mpnrqat) {
        this.mpnrqat = mpnrqat;
    }

    private String change1;

    @javax.persistence.Column(name = "CHANGE1")
    @Basic
    public String getChange1() {
        return change1;
    }

    public void setChange1(String change1) {
        this.change1 = change1;
    }

    private String change2;

    @javax.persistence.Column(name = "CHANGE2")
    @Basic
    public String getChange2() {
        return change2;
    }

    public void setChange2(String change2) {
        this.change2 = change2;
    }

    private String change3;

    @javax.persistence.Column(name = "CHANGE3")
    @Basic
    public String getChange3() {
        return change3;
    }

    public void setChange3(String change3) {
        this.change3 = change3;
    }

    private String snamel;

    @javax.persistence.Column(name = "SNAMEL")
    @Basic
    public String getSnamel() {
        return snamel;
    }

    public void setSnamel(String snamel) {
        this.snamel = snamel;
    }

    private String snamef;

    @javax.persistence.Column(name = "SNAMEF")
    @Basic
    public String getSnamef() {
        return snamef;
    }

    public void setSnamef(String snamef) {
        this.snamef = snamef;
    }

    private String snamem;

    @javax.persistence.Column(name = "SNAMEM")
    @Basic
    public String getSnamem() {
        return snamem;
    }

    public void setSnamem(String snamem) {
        this.snamem = snamem;
    }

    private String snamel2;

    @javax.persistence.Column(name = "SNAMEL2")
    @Basic
    public String getSnamel2() {
        return snamel2;
    }

    public void setSnamel2(String snamel2) {
        this.snamel2 = snamel2;
    }

    private String snamef2;

    @javax.persistence.Column(name = "SNAMEF2")
    @Basic
    public String getSnamef2() {
        return snamef2;
    }

    public void setSnamef2(String snamef2) {
        this.snamef2 = snamef2;
    }

    private String snamem2;

    @javax.persistence.Column(name = "SNAMEM2")
    @Basic
    public String getSnamem2() {
        return snamem2;
    }

    public void setSnamem2(String snamem2) {
        this.snamem2 = snamem2;
    }

    private String snamel3;

    @javax.persistence.Column(name = "SNAMEL3")
    @Basic
    public String getSnamel3() {
        return snamel3;
    }

    public void setSnamel3(String snamel3) {
        this.snamel3 = snamel3;
    }

    private String snamef3;

    @javax.persistence.Column(name = "SNAMEF3")
    @Basic
    public String getSnamef3() {
        return snamef3;
    }

    public void setSnamef3(String snamef3) {
        this.snamef3 = snamef3;
    }

    private String snamem3;

    @javax.persistence.Column(name = "SNAMEM3")
    @Basic
    public String getSnamem3() {
        return snamem3;
    }

    public void setSnamem3(String snamem3) {
        this.snamem3 = snamem3;
    }

    private String pnamel2;

    @javax.persistence.Column(name = "PNAMEL2")
    @Basic
    public String getPnamel2() {
        return pnamel2;
    }

    public void setPnamel2(String pnamel2) {
        this.pnamel2 = pnamel2;
    }

    private String pnamef2;

    @javax.persistence.Column(name = "PNAMEF2")
    @Basic
    public String getPnamef2() {
        return pnamef2;
    }

    public void setPnamef2(String pnamef2) {
        this.pnamef2 = pnamef2;
    }

    private String pnamem2;

    @javax.persistence.Column(name = "PNAMEM2")
    @Basic
    public String getPnamem2() {
        return pnamem2;
    }

    public void setPnamem2(String pnamem2) {
        this.pnamem2 = pnamem2;
    }

    private String pnamel3;

    @javax.persistence.Column(name = "PNAMEL3")
    @Basic
    public String getPnamel3() {
        return pnamel3;
    }

    public void setPnamel3(String pnamel3) {
        this.pnamel3 = pnamel3;
    }

    private String pnamef3;

    @javax.persistence.Column(name = "PNAMEF3")
    @Basic
    public String getPnamef3() {
        return pnamef3;
    }

    public void setPnamef3(String pnamef3) {
        this.pnamef3 = pnamef3;
    }

    private String pnamem3;

    @javax.persistence.Column(name = "PNAMEM3")
    @Basic
    public String getPnamem3() {
        return pnamem3;
    }

    public void setPnamem3(String pnamem3) {
        this.pnamem3 = pnamem3;
    }

    private String laddr;

    @javax.persistence.Column(name = "LADDR")
    @Basic
    public String getLaddr() {
        return laddr;
    }

    public void setLaddr(String laddr) {
        this.laddr = laddr;
    }

    private String laddr2;

    @javax.persistence.Column(name = "LADDR2")
    @Basic
    public String getLaddr2() {
        return laddr2;
    }

    public void setLaddr2(String laddr2) {
        this.laddr2 = laddr2;
    }

    private String laddr3;

    @javax.persistence.Column(name = "LADDR3")
    @Basic
    public String getLaddr3() {
        return laddr3;
    }

    public void setLaddr3(String laddr3) {
        this.laddr3 = laddr3;
    }

    private String paddr;

    @javax.persistence.Column(name = "PADDR")
    @Basic
    public String getPaddr() {
        return paddr;
    }

    public void setPaddr(String paddr) {
        this.paddr = paddr;
    }

    private String paddr2;

    @javax.persistence.Column(name = "PADDR2")
    @Basic
    public String getPaddr2() {
        return paddr2;
    }

    public void setPaddr2(String paddr2) {
        this.paddr2 = paddr2;
    }

    private String padr2;

    @javax.persistence.Column(name = "PADR2")
    @Basic
    public String getPadr2() {
        return padr2;
    }

    public void setPadr2(String padr2) {
        this.padr2 = padr2;
    }

    private String padr22;

    @javax.persistence.Column(name = "PADR22")
    @Basic
    public String getPadr22() {
        return padr22;
    }

    public void setPadr22(String padr22) {
        this.padr22 = padr22;
    }

    private String padr3;

    @javax.persistence.Column(name = "PADR3")
    @Basic
    public String getPadr3() {
        return padr3;
    }

    public void setPadr3(String padr3) {
        this.padr3 = padr3;
    }

    private String padr23;

    @javax.persistence.Column(name = "PADR23")
    @Basic
    public String getPadr23() {
        return padr23;
    }

    public void setPadr23(String padr23) {
        this.padr23 = padr23;
    }

    private String promtyp;

    @javax.persistence.Column(name = "PROMTYP")
    @Basic
    public String getPromtyp() {
        return promtyp;
    }

    public void setPromtyp(String promtyp) {
        this.promtyp = promtyp;
    }

    private String borind;

    @javax.persistence.Column(name = "BORIND")
    @Basic
    public String getBorind() {
        return borind;
    }

    public void setBorind(String borind) {
        this.borind = borind;
    }

    private String borind2;

    @javax.persistence.Column(name = "BORIND2")
    @Basic
    public String getBorind2() {
        return borind2;
    }

    public void setBorind2(String borind2) {
        this.borind2 = borind2;
    }

    private String borind3;

    @javax.persistence.Column(name = "BORIND3")
    @Basic
    public String getBorind3() {
        return borind3;
    }

    public void setBorind3(String borind3) {
        this.borind3 = borind3;
    }

    private String pgmtcd;

    @javax.persistence.Column(name = "PGMTCD")
    @Basic
    public String getPgmtcd() {
        return pgmtcd;
    }

    public void setPgmtcd(String pgmtcd) {
        this.pgmtcd = pgmtcd;
    }

    private String pgmtcd2;

    @javax.persistence.Column(name = "PGMTCD2")
    @Basic
    public String getPgmtcd2() {
        return pgmtcd2;
    }

    public void setPgmtcd2(String pgmtcd2) {
        this.pgmtcd2 = pgmtcd2;
    }

    private String pgmtcd3;

    @javax.persistence.Column(name = "PGMTCD3")
    @Basic
    public String getPgmtcd3() {
        return pgmtcd3;
    }

    public void setPgmtcd3(String pgmtcd3) {
        this.pgmtcd3 = pgmtcd3;
    }

    private BigDecimal tbdebt;

    @javax.persistence.Column(name = "TBDEBT")
    @Basic
    public BigDecimal getTbdebt() {
        return tbdebt;
    }

    public void setTbdebt(BigDecimal tbdebt) {
        this.tbdebt = tbdebt;
    }

    private BigDecimal tbdebt2;

    @javax.persistence.Column(name = "TBDEBT2")
    @Basic
    public BigDecimal getTbdebt2() {
        return tbdebt2;
    }

    public void setTbdebt2(BigDecimal tbdebt2) {
        this.tbdebt2 = tbdebt2;
    }

    private BigDecimal tbdebt3;

    @javax.persistence.Column(name = "TBDEBT3")
    @Basic
    public BigDecimal getTbdebt3() {
        return tbdebt3;
    }

    public void setTbdebt3(BigDecimal tbdebt3) {
        this.tbdebt3 = tbdebt3;
    }

    private BigDecimal feespd;

    @javax.persistence.Column(name = "FEESPD")
    @Basic
    public BigDecimal getFeespd() {
        return feespd;
    }

    public void setFeespd(BigDecimal feespd) {
        this.feespd = feespd;
    }

    private String adtype;

    @javax.persistence.Column(name = "ADTYPE")
    @Basic
    public String getAdtype() {
        return adtype;
    }

    public void setAdtype(String adtype) {
        this.adtype = adtype;
    }

    private String psntyp;

    @javax.persistence.Column(name = "PSNTYP")
    @Basic
    public String getPsntyp() {
        return psntyp;
    }

    public void setPsntyp(String psntyp) {
        this.psntyp = psntyp;
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

    private String docido;

    @javax.persistence.Column(name = "DOCIDO")
    @Basic
    public String getDocido() {
        return docido;
    }

    public void setDocido(String docido) {
        this.docido = docido;
    }

    private String docidc;

    @javax.persistence.Column(name = "DOCIDC")
    @Basic
    public String getDocidc() {
        return docidc;
    }

    public void setDocidc(String docidc) {
        this.docidc = docidc;
    }

    private String instn;

    @javax.persistence.Column(name = "INSTN")
    @Basic
    public String getInstn() {
        return instn;
    }

    public void setInstn(String instn) {
        this.instn = instn;
    }

    private String ainstn;

    @javax.persistence.Column(name = "AINSTN")
    @Basic
    public String getAinstn() {
        return ainstn;
    }

    public void setAinstn(String ainstn) {
        this.ainstn = ainstn;
    }

    private String rinstn;

    @javax.persistence.Column(name = "RINSTN")
    @Basic
    public String getRinstn() {
        return rinstn;
    }

    public void setRinstn(String rinstn) {
        this.rinstn = rinstn;
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

    private String aaccal;

    @javax.persistence.Column(name = "AACCAL")
    @Basic
    public String getAaccal() {
        return aaccal;
    }

    public void setAaccal(String aaccal) {
        this.aaccal = aaccal;
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

    private String pmeth;

    @javax.persistence.Column(name = "PMETH")
    @Basic
    public String getPmeth() {
        return pmeth;
    }

    public void setPmeth(String pmeth) {
        this.pmeth = pmeth;
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

    private String rpmeth;

    @javax.persistence.Column(name = "RPMETH")
    @Basic
    public String getRpmeth() {
        return rpmeth;
    }

    public void setRpmeth(String rpmeth) {
        this.rpmeth = rpmeth;
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

    private String awicp;

    @javax.persistence.Column(name = "AWICP")
    @Basic
    public String getAwicp() {
        return awicp;
    }

    public void setAwicp(String awicp) {
        this.awicp = awicp;
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

    private String wpacy;

    @javax.persistence.Column(name = "WPACY")
    @Basic
    public String getWpacy() {
        return wpacy;
    }

    public void setWpacy(String wpacy) {
        this.wpacy = wpacy;
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

    private String rwpacy;

    @javax.persistence.Column(name = "RWPACY")
    @Basic
    public String getRwpacy() {
        return rwpacy;
    }

    public void setRwpacy(String rwpacy) {
        this.rwpacy = rwpacy;
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

    private int apgawch;

    @javax.persistence.Column(name = "APGAWCH")
    @Basic
    public int getApgawch() {
        return apgawch;
    }

    public void setApgawch(int apgawch) {
        this.apgawch = apgawch;
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

    private int pgacch;

    @javax.persistence.Column(name = "PGACCH")
    @Basic
    public int getPgacch() {
        return pgacch;
    }

    public void setPgacch(int pgacch) {
        this.pgacch = pgacch;
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

    private int rpgacch;

    @javax.persistence.Column(name = "RPGACCH")
    @Basic
    public int getRpgacch() {
        return rpgacch;
    }

    public void setRpgacch(int rpgacch) {
        this.rpgacch = rpgacch;
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

    private String altuit;

    @javax.persistence.Column(name = "ALTUIT")
    @Basic
    public String getAltuit() {
        return altuit;
    }

    public void setAltuit(String altuit) {
        this.altuit = altuit;
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

    private String incar;

    @javax.persistence.Column(name = "INCAR")
    @Basic
    public String getIncar() {
        return incar;
    }

    public void setIncar(String incar) {
        this.incar = incar;
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

    private String pgvalst;

    @javax.persistence.Column(name = "PGVALST")
    @Basic
    public String getPgvalst() {
        return pgvalst;
    }

    public void setPgvalst(String pgvalst) {
        this.pgvalst = pgvalst;
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

    private String sefefcf;

    @javax.persistence.Column(name = "SEFEFCF")
    @Basic
    public String getSefefcf() {
        return sefefcf;
    }

    public void setSefefcf(String sefefcf) {
        this.sefefcf = sefefcf;
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

    private int beogbud;

    @javax.persistence.Column(name = "BEOGBUD")
    @Basic
    public int getBeogbud() {
        return beogbud;
    }

    public void setBeogbud(int beogbud) {
        this.beogbud = beogbud;
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

    private BigDecimal ngpamt;

    @javax.persistence.Column(name = "NGPAMT")
    @Basic
    public BigDecimal getNgpamt() {
        return ngpamt;
    }

    public void setNgpamt(BigDecimal ngpamt) {
        this.ngpamt = ngpamt;
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

    private String delcode;

    @javax.persistence.Column(name = "DELCODE")
    @Basic
    public String getDelcode() {
        return delcode;
    }

    public void setDelcode(String delcode) {
        this.delcode = delcode;
    }

    private BigDecimal endramt;

    @javax.persistence.Column(name = "ENDRAMT")
    @Basic
    public BigDecimal getEndramt() {
        return endramt;
    }

    public void setEndramt(BigDecimal endramt) {
        this.endramt = endramt;
    }

    private BigDecimal ytdamt;

    @javax.persistence.Column(name = "YTDAMT")
    @Basic
    public BigDecimal getYtdamt() {
        return ytdamt;
    }

    public void setYtdamt(BigDecimal ytdamt) {
        this.ytdamt = ytdamt;
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

    private BigDecimal telgusd;

    @javax.persistence.Column(name = "TELGUSD")
    @Basic
    public BigDecimal getTelgusd() {
        return telgusd;
    }

    public void setTelgusd(BigDecimal telgusd) {
        this.telgusd = telgusd;
    }

    private String sfaind;

    @javax.persistence.Column(name = "SFAIND")
    @Basic
    public String getSfaind() {
        return sfaind;
    }

    public void setSfaind(String sfaind) {
        this.sfaind = sfaind;
    }

    private String defreq;

    @javax.persistence.Column(name = "DEFREQ")
    @Basic
    public String getDefreq() {
        return defreq;
    }

    public void setDefreq(String defreq) {
        this.defreq = defreq;
    }

    private String borint;

    @javax.persistence.Column(name = "BORINT")
    @Basic
    public String getBorint() {
        return borint;
    }

    public void setBorint(String borint) {
        this.borint = borint;
    }

    private String eftath;

    @javax.persistence.Column(name = "EFTATH")
    @Basic
    public String getEftath() {
        return eftath;
    }

    public void setEftath(String eftath) {
        this.eftath = eftath;
    }

    private String outsln;

    @javax.persistence.Column(name = "OUTSLN")
    @Basic
    public String getOutsln() {
        return outsln;
    }

    public void setOutsln(String outsln) {
        this.outsln = outsln;
    }

    private String guardt;

    @javax.persistence.Column(name = "GUARDT")
    @Basic
    public String getGuardt() {
        return guardt;
    }

    public void setGuardt(String guardt) {
        this.guardt = guardt;
    }

    private String pgvalvi;

    @javax.persistence.Column(name = "PGVALVI")
    @Basic
    public String getPgvalvi() {
        return pgvalvi;
    }

    public void setPgvalvi(String pgvalvi) {
        this.pgvalvi = pgvalvi;
    }

    private BigInteger pgtrnhi;

    @javax.persistence.Column(name = "PGTRNHI")
    @Basic
    public BigInteger getPgtrnhi() {
        return pgtrnhi;
    }

    public void setPgtrnhi(BigInteger pgtrnhi) {
        this.pgtrnhi = pgtrnhi;
    }

    private String credtm;

    @javax.persistence.Column(name = "CREDTM")
    @Basic
    public String getCredtm() {
        return credtm;
    }

    public void setCredtm(String credtm) {
        this.credtm = credtm;
    }

    private String frspcd;

    @javax.persistence.Column(name = "FRSPCD")
    @Basic
    public String getFrspcd() {
        return frspcd;
    }

    public void setFrspcd(String frspcd) {
        this.frspcd = frspcd;
    }

    private String error1;

    @javax.persistence.Column(name = "ERROR1")
    @Basic
    public String getError1() {
        return error1;
    }

    public void setError1(String error1) {
        this.error1 = error1;
    }

    private String error2;

    @javax.persistence.Column(name = "ERROR2")
    @Basic
    public String getError2() {
        return error2;
    }

    public void setError2(String error2) {
        this.error2 = error2;
    }

    private String error3;

    @javax.persistence.Column(name = "ERROR3")
    @Basic
    public String getError3() {
        return error3;
    }

    public void setError3(String error3) {
        this.error3 = error3;
    }

    private String error4;

    @javax.persistence.Column(name = "ERROR4")
    @Basic
    public String getError4() {
        return error4;
    }

    public void setError4(String error4) {
        this.error4 = error4;
    }

    private String error5;

    @javax.persistence.Column(name = "ERROR5")
    @Basic
    public String getError5() {
        return error5;
    }

    public void setError5(String error5) {
        this.error5 = error5;
    }

    private String error6;

    @javax.persistence.Column(name = "ERROR6")
    @Basic
    public String getError6() {
        return error6;
    }

    public void setError6(String error6) {
        this.error6 = error6;
    }

    private String error7;

    @javax.persistence.Column(name = "ERROR7")
    @Basic
    public String getError7() {
        return error7;
    }

    public void setError7(String error7) {
        this.error7 = error7;
    }

    private String error8;

    @javax.persistence.Column(name = "ERROR8")
    @Basic
    public String getError8() {
        return error8;
    }

    public void setError8(String error8) {
        this.error8 = error8;
    }

    private String error9;

    @javax.persistence.Column(name = "ERROR9")
    @Basic
    public String getError9() {
        return error9;
    }

    public void setError9(String error9) {
        this.error9 = error9;
    }

    private String errora;

    @javax.persistence.Column(name = "ERRORA")
    @Basic
    public String getErrora() {
        return errora;
    }

    public void setErrora(String errora) {
        this.errora = errora;
    }

    private String acdpgm;

    @javax.persistence.Column(name = "ACDPGM")
    @Basic
    public String getAcdpgm() {
        return acdpgm;
    }

    public void setAcdpgm(String acdpgm) {
        this.acdpgm = acdpgm;
    }

    private String lendnm;

    @javax.persistence.Column(name = "LENDNM")
    @Basic
    public String getLendnm() {
        return lendnm;
    }

    public void setLendnm(String lendnm) {
        this.lendnm = lendnm;
    }

    private String guarnm;

    @javax.persistence.Column(name = "GUARNM")
    @Basic
    public String getGuarnm() {
        return guarnm;
    }

    public void setGuarnm(String guarnm) {
        this.guarnm = guarnm;
    }

    private BigDecimal amtapp0;

    @javax.persistence.Column(name = "AMTAPP0")
    @Basic
    public BigDecimal getAmtapp0() {
        return amtapp0;
    }

    public void setAmtapp0(BigDecimal amtapp0) {
        this.amtapp0 = amtapp0;
    }

    private BigDecimal reqln0;

    @javax.persistence.Column(name = "REQLN0")
    @Basic
    public BigDecimal getReqln0() {
        return reqln0;
    }

    public void setReqln0(BigDecimal reqln0) {
        this.reqln0 = reqln0;
    }

    private String perbeg0;

    @javax.persistence.Column(name = "PERBEG0")
    @Basic
    public String getPerbeg0() {
        return perbeg0;
    }

    public void setPerbeg0(String perbeg0) {
        this.perbeg0 = perbeg0;
    }

    private String perend0;

    @javax.persistence.Column(name = "PEREND0")
    @Basic
    public String getPerend0() {
        return perend0;
    }

    public void setPerend0(String perend0) {
        this.perend0 = perend0;
    }

    private String depsts;

    @javax.persistence.Column(name = "DEPSTS")
    @Basic
    public String getDepsts() {
        return depsts;
    }

    public void setDepsts(String depsts) {
        this.depsts = depsts;
    }

    private String classs;

    @javax.persistence.Column(name = "CLASSS")
    @Basic
    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    private String senrss;

    @javax.persistence.Column(name = "SENRSS")
    @Basic
    public String getSenrss() {
        return senrss;
    }

    public void setSenrss(String senrss) {
        this.senrss = senrss;
    }

    private String senrds;

    @javax.persistence.Column(name = "SENRDS")
    @Basic
    public String getSenrds() {
        return senrds;
    }

    public void setSenrds(String senrds) {
        this.senrds = senrds;
    }

    private String deflts;

    @javax.persistence.Column(name = "DEFLTS")
    @Basic
    public String getDeflts() {
        return deflts;
    }

    public void setDeflts(String deflts) {
        this.deflts = deflts;
    }

    private String pdflts;

    @javax.persistence.Column(name = "PDFLTS")
    @Basic
    public String getPdflts() {
        return pdflts;
    }

    public void setPdflts(String pdflts) {
        this.pdflts = pdflts;
    }

    private String prodts;

    @javax.persistence.Column(name = "PRODTS")
    @Basic
    public String getProdts() {
        return prodts;
    }

    public void setProdts(String prodts) {
        this.prodts = prodts;
    }

    private String strdts;

    @javax.persistence.Column(name = "STRDTS")
    @Basic
    public String getStrdts() {
        return strdts;
    }

    public void setStrdts(String strdts) {
        this.strdts = strdts;
    }

    private String enddts;

    @javax.persistence.Column(name = "ENDDTS")
    @Basic
    public String getEnddts() {
        return enddts;
    }

    public void setEnddts(String enddts) {
        this.enddts = enddts;
    }

    private String perbes;

    @javax.persistence.Column(name = "PERBES")
    @Basic
    public String getPerbes() {
        return perbes;
    }

    public void setPerbes(String perbes) {
        this.perbes = perbes;
    }

    private String perens;

    @javax.persistence.Column(name = "PERENS")
    @Basic
    public String getPerens() {
        return perens;
    }

    public void setPerens(String perens) {
        this.perens = perens;
    }

    private String lcancs;

    @javax.persistence.Column(name = "LCANCS")
    @Basic
    public String getLcancs() {
        return lcancs;
    }

    public void setLcancs(String lcancs) {
        this.lcancs = lcancs;
    }

    private String lcands;

    @javax.persistence.Column(name = "LCANDS")
    @Basic
    public String getLcands() {
        return lcands;
    }

    public void setLcands(String lcands) {
        this.lcands = lcands;
    }

    private String amtaps;

    @javax.persistence.Column(name = "AMTAPS")
    @Basic
    public String getAmtaps() {
        return amtaps;
    }

    public void setAmtaps(String amtaps) {
        this.amtaps = amtaps;
    }

    private String reqlns;

    @javax.persistence.Column(name = "REQLNS")
    @Basic
    public String getReqlns() {
        return reqlns;
    }

    public void setReqlns(String reqlns) {
        this.reqlns = reqlns;
    }

    private String pnprts;

    @javax.persistence.Column(name = "PNPRTS")
    @Basic
    public String getPnprts() {
        return pnprts;
    }

    public void setPnprts(String pnprts) {
        this.pnprts = pnprts;
    }

    private String pninds;

    @javax.persistence.Column(name = "PNINDS")
    @Basic
    public String getPninds() {
        return pninds;
    }

    public void setPninds(String pninds) {
        this.pninds = pninds;
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

    private String incars;

    @javax.persistence.Column(name = "INCARS")
    @Basic
    public String getIncars() {
        return incars;
    }

    public void setIncars(String incars) {
        this.incars = incars;
    }

    private String valsts;

    @javax.persistence.Column(name = "VALSTS")
    @Basic
    public String getValsts() {
        return valsts;
    }

    public void setValsts(String valsts) {
        this.valsts = valsts;
    }

    private String sefcs;

    @javax.persistence.Column(name = "SEFCS")
    @Basic
    public String getSefcs() {
        return sefcs;
    }

    public void setSefcs(String sefcs) {
        this.sefcs = sefcs;
    }

    private String coas;

    @javax.persistence.Column(name = "COAS")
    @Basic
    public String getCoas() {
        return coas;
    }

    public void setCoas(String coas) {
        this.coas = coas;
    }

    private String cpsncd;

    @javax.persistence.Column(name = "CPSNCD")
    @Basic
    public String getCpsncd() {
        return cpsncd;
    }

    public void setCpsncd(String cpsncd) {
        this.cpsncd = cpsncd;
    }

    private String pellelg;

    @javax.persistence.Column(name = "PELLELG")
    @Basic
    public String getPellelg() {
        return pellelg;
    }

    public void setPellelg(String pellelg) {
        this.pellelg = pellelg;
    }

    private String pmnid;

    @javax.persistence.Column(name = "PMNID")
    @Basic
    public String getPmnid() {
        return pmnid;
    }

    public void setPmnid(String pmnid) {
        this.pmnid = pmnid;
    }

    private BigDecimal tpelgus;

    @javax.persistence.Column(name = "TPELGUS")
    @Basic
    public BigDecimal getTpelgus() {
        return tpelgus;
    }

    public void setTpelgus(BigDecimal tpelgus) {
        this.tpelgus = tpelgus;
    }

    private String tchexpi;

    @javax.persistence.Column(name = "TCHEXPI")
    @Basic
    public String getTchexpi() {
        return tchexpi;
    }

    public void setTchexpi(String tchexpi) {
        this.tchexpi = tchexpi;
    }

    private String adelin;

    @javax.persistence.Column(name = "ADELIN")
    @Basic
    public String getAdelin() {
        return adelin;
    }

    public void setAdelin(String adelin) {
        this.adelin = adelin;
    }

    private String cncmdt;

    @javax.persistence.Column(name = "CNCMDT")
    @Basic
    public String getCncmdt() {
        return cncmdt;
    }

    public void setCncmdt(String cncmdt) {
        this.cncmdt = cncmdt;
    }

    private String lrrdte;

    @javax.persistence.Column(name = "LRRDTE")
    @Basic
    public String getLrrdte() {
        return lrrdte;
    }

    public void setLrrdte(String lrrdte) {
        this.lrrdte = lrrdte;
    }

    private String apcmpdt;

    @javax.persistence.Column(name = "APCMPDT")
    @Basic
    public String getApcmpdt() {
        return apcmpdt;
    }

    public void setApcmpdt(String apcmpdt) {
        this.apcmpdt = apcmpdt;
    }

    private String crbalop;

    @javax.persistence.Column(name = "CRBALOP")
    @Basic
    public String getCrbalop() {
        return crbalop;
    }

    public void setCrbalop(String crbalop) {
        this.crbalop = crbalop;
    }

    private String cractch;

    @javax.persistence.Column(name = "CRACTCH")
    @Basic
    public String getCractch() {
        return cractch;
    }

    public void setCractch(String cractch) {
        this.cractch = cractch;
    }

    private String crappls;

    @javax.persistence.Column(name = "CRAPPLS")
    @Basic
    public String getCrappls() {
        return crappls;
    }

    public void setCrappls(String crappls) {
        this.crappls = crappls;
    }

    private BigDecimal mxlnamt;

    @javax.persistence.Column(name = "MXLNAMT")
    @Basic
    public BigDecimal getMxlnamt() {
        return mxlnamt;
    }

    public void setMxlnamt(BigDecimal mxlnamt) {
        this.mxlnamt = mxlnamt;
    }

    private String crdcexd;

    @javax.persistence.Column(name = "CRDCEXD")
    @Basic
    public String getCrdcexd() {
        return crdcexd;
    }

    public void setCrdcexd(String crdcexd) {
        this.crdcexd = crdcexd;
    }

    private String ocrdcst;

    @javax.persistence.Column(name = "OCRDCST")
    @Basic
    public String getOcrdcst() {
        return ocrdcst;
    }

    public void setOcrdcst(String ocrdcst) {
        this.ocrdcst = ocrdcst;
    }

    private String defopt;

    @javax.persistence.Column(name = "DEFOPT")
    @Basic
    public String getDefopt() {
        return defopt;
    }

    public void setDefopt(String defopt) {
        this.defopt = defopt;
    }

    private BigDecimal ltelgus;

    @javax.persistence.Column(name = "LTELGUS")
    @Basic
    public BigDecimal getLtelgus() {
        return ltelgus;
    }

    public void setLtelgus(BigDecimal ltelgus) {
        this.ltelgus = ltelgus;
    }

    private String crdecst;

    @javax.persistence.Column(name = "CRDECST")
    @Basic
    public String getCrdecst() {
        return crdecst;
    }

    public void setCrdecst(String crdecst) {
        this.crdecst = crdecst;
    }

    private String servid;

    @javax.persistence.Column(name = "SERVID")
    @Basic
    public String getServid() {
        return servid;
    }

    public void setServid(String servid) {
        this.servid = servid;
    }

    private String grelgo;

    @javax.persistence.Column(name = "GRELGO")
    @Basic
    public String getGrelgo() {
        return grelgo;
    }

    public void setGrelgo(String grelgo) {
        this.grelgo = grelgo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FloEntity floEntity = (FloEntity) o;

        if (acoa != floEntity.acoa) return false;
        if (apgacch != floEntity.apgacch) return false;
        if (apgawch != floEntity.apgawch) return false;
        if (beogbud != floEntity.beogbud) return false;
        if (chgcnt != floEntity.chgcnt) return false;
        if (pgacch != floEntity.pgacch) return false;
        if (pgawdch != floEntity.pgawdch) return false;
        if (revlev != floEntity.revlev) return false;
        if (rpgacch != floEntity.rpgacch) return false;
        if (rpgawch != floEntity.rpgawch) return false;
        if (usernr1 != floEntity.usernr1) return false;
        if (usernr2 != floEntity.usernr2) return false;
        if (aaccal != null ? !aaccal.equals(floEntity.aaccal) : floEntity.aaccal != null) return false;
        if (acdpgm != null ? !acdpgm.equals(floEntity.acdpgm) : floEntity.acdpgm != null) return false;
        if (adelin != null ? !adelin.equals(floEntity.adelin) : floEntity.adelin != null) return false;
        if (adtype != null ? !adtype.equals(floEntity.adtype) : floEntity.adtype != null) return false;
        if (afeeamt != null ? !afeeamt.equals(floEntity.afeeamt) : floEntity.afeeamt != null) return false;
        if (agrosamt != null ? !agrosamt.equals(floEntity.agrosamt) : floEntity.agrosamt != null) return false;
        if (aidid != null ? !aidid.equals(floEntity.aidid) : floEntity.aidid != null) return false;
        if (aidid2 != null ? !aidid2.equals(floEntity.aidid2) : floEntity.aidid2 != null) return false;
        if (aincar != null ? !aincar.equals(floEntity.aincar) : floEntity.aincar != null) return false;
        if (ainstn != null ? !ainstn.equals(floEntity.ainstn) : floEntity.ainstn != null) return false;
        if (alntype != null ? !alntype.equals(floEntity.alntype) : floEntity.alntype != null) return false;
        if (alpnmt != null ? !alpnmt.equals(floEntity.alpnmt) : floEntity.alpnmt != null) return false;
        if (alpnmt2 != null ? !alpnmt2.equals(floEntity.alpnmt2) : floEntity.alpnmt2 != null) return false;
        if (alpnmt3 != null ? !alpnmt3.equals(floEntity.alpnmt3) : floEntity.alpnmt3 != null) return false;
        if (altuit != null ? !altuit.equals(floEntity.altuit) : floEntity.altuit != null) return false;
        if (amtapp != null ? !amtapp.equals(floEntity.amtapp) : floEntity.amtapp != null) return false;
        if (amtapp0 != null ? !amtapp0.equals(floEntity.amtapp0) : floEntity.amtapp0 != null) return false;
        if (amtapp2 != null ? !amtapp2.equals(floEntity.amtapp2) : floEntity.amtapp2 != null) return false;
        if (amtapp3 != null ? !amtapp3.equals(floEntity.amtapp3) : floEntity.amtapp3 != null) return false;
        if (amtaps != null ? !amtaps.equals(floEntity.amtaps) : floEntity.amtaps != null) return false;
        if (anetamt != null ? !anetamt.equals(floEntity.anetamt) : floEntity.anetamt != null) return false;
        if (apcmpdt != null ? !apcmpdt.equals(floEntity.apcmpdt) : floEntity.apcmpdt != null) return false;
        if (apgsid != null ? !apgsid.equals(floEntity.apgsid) : floEntity.apgsid != null) return false;
        if (apmeth != null ? !apmeth.equals(floEntity.apmeth) : floEntity.apmeth != null) return false;
        if (aprocyr != null ? !aprocyr.equals(floEntity.aprocyr) : floEntity.aprocyr != null) return false;
        if (apvalst != null ? !apvalst.equals(floEntity.apvalst) : floEntity.apvalst != null) return false;
        if (arebamt != null ? !arebamt.equals(floEntity.arebamt) : floEntity.arebamt != null) return false;
        if (aschcode != null ? !aschcode.equals(floEntity.aschcode) : floEntity.aschcode != null) return false;
        if (asefcf != null ? !asefcf.equals(floEntity.asefcf) : floEntity.asefcf != null) return false;
        if (aseqno2 != null ? !aseqno2.equals(floEntity.aseqno2) : floEntity.aseqno2 != null) return false;
        if (awicp != null ? !awicp.equals(floEntity.awicp) : floEntity.awicp != null) return false;
        if (awpacy != null ? !awpacy.equals(floEntity.awpacy) : floEntity.awpacy != null) return false;
        if (baidid != null ? !baidid.equals(floEntity.baidid) : floEntity.baidid != null) return false;
        if (bkdate != null ? !bkdate.equals(floEntity.bkdate) : floEntity.bkdate != null) return false;
        if (bkstat != null ? !bkstat.equals(floEntity.bkstat) : floEntity.bkstat != null) return false;
        if (blntype != null ? !blntype.equals(floEntity.blntype) : floEntity.blntype != null) return false;
        if (borind != null ? !borind.equals(floEntity.borind) : floEntity.borind != null) return false;
        if (borind2 != null ? !borind2.equals(floEntity.borind2) : floEntity.borind2 != null) return false;
        if (borind3 != null ? !borind3.equals(floEntity.borind3) : floEntity.borind3 != null) return false;
        if (borint != null ? !borint.equals(floEntity.borint) : floEntity.borint != null) return false;
        if (borwid != null ? !borwid.equals(floEntity.borwid) : floEntity.borwid != null) return false;
        if (borwid2 != null ? !borwid2.equals(floEntity.borwid2) : floEntity.borwid2 != null) return false;
        if (borwid3 != null ? !borwid3.equals(floEntity.borwid3) : floEntity.borwid3 != null) return false;
        if (bprocyr != null ? !bprocyr.equals(floEntity.bprocyr) : floEntity.bprocyr != null) return false;
        if (bptype != null ? !bptype.equals(floEntity.bptype) : floEntity.bptype != null) return false;
        if (bsid != null ? !bsid.equals(floEntity.bsid) : floEntity.bsid != null) return false;
        if (cancode != null ? !cancode.equals(floEntity.cancode) : floEntity.cancode != null) return false;
        if (candate != null ? !candate.equals(floEntity.candate) : floEntity.candate != null) return false;
        if (change1 != null ? !change1.equals(floEntity.change1) : floEntity.change1 != null) return false;
        if (change2 != null ? !change2.equals(floEntity.change2) : floEntity.change2 != null) return false;
        if (change3 != null ? !change3.equals(floEntity.change3) : floEntity.change3 != null) return false;
        if (chgdis1 != null ? !chgdis1.equals(floEntity.chgdis1) : floEntity.chgdis1 != null) return false;
        if (chgdis2 != null ? !chgdis2.equals(floEntity.chgdis2) : floEntity.chgdis2 != null) return false;
        if (chgdis3 != null ? !chgdis3.equals(floEntity.chgdis3) : floEntity.chgdis3 != null) return false;
        if (chgdis4 != null ? !chgdis4.equals(floEntity.chgdis4) : floEntity.chgdis4 != null) return false;
        if (chgtyp1 != null ? !chgtyp1.equals(floEntity.chgtyp1) : floEntity.chgtyp1 != null) return false;
        if (chgtyp2 != null ? !chgtyp2.equals(floEntity.chgtyp2) : floEntity.chgtyp2 != null) return false;
        if (chgtyp3 != null ? !chgtyp3.equals(floEntity.chgtyp3) : floEntity.chgtyp3 != null) return false;
        if (chgtyp4 != null ? !chgtyp4.equals(floEntity.chgtyp4) : floEntity.chgtyp4 != null) return false;
        if (class2 != null ? !class2.equals(floEntity.class2) : floEntity.class2 != null) return false;
        if (class3 != null ? !class3.equals(floEntity.class3) : floEntity.class3 != null) return false;
        if (classs != null ? !classs.equals(floEntity.classs) : floEntity.classs != null) return false;
        if (clazz != null ? !clazz.equals(floEntity.clazz) : floEntity.clazz != null) return false;
        if (cncmdt != null ? !cncmdt.equals(floEntity.cncmdt) : floEntity.cncmdt != null) return false;
        if (coas != null ? !coas.equals(floEntity.coas) : floEntity.coas != null) return false;
        if (cpsncd != null ? !cpsncd.equals(floEntity.cpsncd) : floEntity.cpsncd != null) return false;
        if (cractch != null ? !cractch.equals(floEntity.cractch) : floEntity.cractch != null) return false;
        if (crappls != null ? !crappls.equals(floEntity.crappls) : floEntity.crappls != null) return false;
        if (crbalop != null ? !crbalop.equals(floEntity.crbalop) : floEntity.crbalop != null) return false;
        if (crdcexd != null ? !crdcexd.equals(floEntity.crdcexd) : floEntity.crdcexd != null) return false;
        if (crdecst != null ? !crdecst.equals(floEntity.crdecst) : floEntity.crdecst != null) return false;
        if (creditck != null ? !creditck.equals(floEntity.creditck) : floEntity.creditck != null) return false;
        if (credrec != null ? !credrec.equals(floEntity.credrec) : floEntity.credrec != null) return false;
        if (credreq != null ? !credreq.equals(floEntity.credreq) : floEntity.credreq != null) return false;
        if (credtm != null ? !credtm.equals(floEntity.credtm) : floEntity.credtm != null) return false;
        if (credupd != null ? !credupd.equals(floEntity.credupd) : floEntity.credupd != null) return false;
        if (crefamt != null ? !crefamt.equals(floEntity.crefamt) : floEntity.crefamt != null) return false;
        if (crefdte != null ? !crefdte.equals(floEntity.crefdte) : floEntity.crefdte != null) return false;
        if (crtdate != null ? !crtdate.equals(floEntity.crtdate) : floEntity.crtdate != null) return false;
        if (crtpgm != null ? !crtpgm.equals(floEntity.crtpgm) : floEntity.crtpgm != null) return false;
        if (crttime != null ? !crttime.equals(floEntity.crttime) : floEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(floEntity.crtuser) : floEntity.crtuser != null) return false;
        if (default2 != null ? !default2.equals(floEntity.default2) : floEntity.default2 != null) return false;
        if (default3 != null ? !default3.equals(floEntity.default3) : floEntity.default3 != null) return false;
        if (defaultr != null ? !defaultr.equals(floEntity.defaultr) : floEntity.defaultr != null) return false;
        if (deflts != null ? !deflts.equals(floEntity.deflts) : floEntity.deflts != null) return false;
        if (defopt != null ? !defopt.equals(floEntity.defopt) : floEntity.defopt != null) return false;
        if (defreq != null ? !defreq.equals(floEntity.defreq) : floEntity.defreq != null) return false;
        if (delcode != null ? !delcode.equals(floEntity.delcode) : floEntity.delcode != null) return false;
        if (depst != null ? !depst.equals(floEntity.depst) : floEntity.depst != null) return false;
        if (depst2 != null ? !depst2.equals(floEntity.depst2) : floEntity.depst2 != null) return false;
        if (depst3 != null ? !depst3.equals(floEntity.depst3) : floEntity.depst3 != null) return false;
        if (depsts != null ? !depsts.equals(floEntity.depsts) : floEntity.depsts != null) return false;
        if (disdtcd != null ? !disdtcd.equals(floEntity.disdtcd) : floEntity.disdtcd != null) return false;
        if (dishd01 != null ? !dishd01.equals(floEntity.dishd01) : floEntity.dishd01 != null) return false;
        if (dishd02 != null ? !dishd02.equals(floEntity.dishd02) : floEntity.dishd02 != null) return false;
        if (dishd03 != null ? !dishd03.equals(floEntity.dishd03) : floEntity.dishd03 != null) return false;
        if (dishd04 != null ? !dishd04.equals(floEntity.dishd04) : floEntity.dishd04 != null) return false;
        if (dishd05 != null ? !dishd05.equals(floEntity.dishd05) : floEntity.dishd05 != null) return false;
        if (dishd06 != null ? !dishd06.equals(floEntity.dishd06) : floEntity.dishd06 != null) return false;
        if (dishd07 != null ? !dishd07.equals(floEntity.dishd07) : floEntity.dishd07 != null) return false;
        if (dishd08 != null ? !dishd08.equals(floEntity.dishd08) : floEntity.dishd08 != null) return false;
        if (dishd09 != null ? !dishd09.equals(floEntity.dishd09) : floEntity.dishd09 != null) return false;
        if (dishd10 != null ? !dishd10.equals(floEntity.dishd10) : floEntity.dishd10 != null) return false;
        if (dishd11 != null ? !dishd11.equals(floEntity.dishd11) : floEntity.dishd11 != null) return false;
        if (dishd12 != null ? !dishd12.equals(floEntity.dishd12) : floEntity.dishd12 != null) return false;
        if (dishd13 != null ? !dishd13.equals(floEntity.dishd13) : floEntity.dishd13 != null) return false;
        if (dishd14 != null ? !dishd14.equals(floEntity.dishd14) : floEntity.dishd14 != null) return false;
        if (dishd15 != null ? !dishd15.equals(floEntity.dishd15) : floEntity.dishd15 != null) return false;
        if (dishd16 != null ? !dishd16.equals(floEntity.dishd16) : floEntity.dishd16 != null) return false;
        if (dishd17 != null ? !dishd17.equals(floEntity.dishd17) : floEntity.dishd17 != null) return false;
        if (dishd18 != null ? !dishd18.equals(floEntity.dishd18) : floEntity.dishd18 != null) return false;
        if (dishd19 != null ? !dishd19.equals(floEntity.dishd19) : floEntity.dishd19 != null) return false;
        if (dishd20 != null ? !dishd20.equals(floEntity.dishd20) : floEntity.dishd20 != null) return false;
        if (dobcdte != null ? !dobcdte.equals(floEntity.dobcdte) : floEntity.dobcdte != null) return false;
        if (docidc != null ? !docidc.equals(floEntity.docidc) : floEntity.docidc != null) return false;
        if (docido != null ? !docido.equals(floEntity.docido) : floEntity.docido != null) return false;
        if (dtmflag != null ? !dtmflag.equals(floEntity.dtmflag) : floEntity.dtmflag != null) return false;
        if (eftath != null ? !eftath.equals(floEntity.eftath) : floEntity.eftath != null) return false;
        if (enddat != null ? !enddat.equals(floEntity.enddat) : floEntity.enddat != null) return false;
        if (enddat2 != null ? !enddat2.equals(floEntity.enddat2) : floEntity.enddat2 != null) return false;
        if (enddat3 != null ? !enddat3.equals(floEntity.enddat3) : floEntity.enddat3 != null) return false;
        if (enddts != null ? !enddts.equals(floEntity.enddts) : floEntity.enddts != null) return false;
        if (endramt != null ? !endramt.equals(floEntity.endramt) : floEntity.endramt != null) return false;
        if (errcd1 != null ? !errcd1.equals(floEntity.errcd1) : floEntity.errcd1 != null) return false;
        if (errcd2 != null ? !errcd2.equals(floEntity.errcd2) : floEntity.errcd2 != null) return false;
        if (errcd3 != null ? !errcd3.equals(floEntity.errcd3) : floEntity.errcd3 != null) return false;
        if (errcd4 != null ? !errcd4.equals(floEntity.errcd4) : floEntity.errcd4 != null) return false;
        if (errcd5 != null ? !errcd5.equals(floEntity.errcd5) : floEntity.errcd5 != null) return false;
        if (error1 != null ? !error1.equals(floEntity.error1) : floEntity.error1 != null) return false;
        if (error2 != null ? !error2.equals(floEntity.error2) : floEntity.error2 != null) return false;
        if (error3 != null ? !error3.equals(floEntity.error3) : floEntity.error3 != null) return false;
        if (error4 != null ? !error4.equals(floEntity.error4) : floEntity.error4 != null) return false;
        if (error5 != null ? !error5.equals(floEntity.error5) : floEntity.error5 != null) return false;
        if (error6 != null ? !error6.equals(floEntity.error6) : floEntity.error6 != null) return false;
        if (error7 != null ? !error7.equals(floEntity.error7) : floEntity.error7 != null) return false;
        if (error8 != null ? !error8.equals(floEntity.error8) : floEntity.error8 != null) return false;
        if (error9 != null ? !error9.equals(floEntity.error9) : floEntity.error9 != null) return false;
        if (errora != null ? !errora.equals(floEntity.errora) : floEntity.errora != null) return false;
        if (feeamt != null ? !feeamt.equals(floEntity.feeamt) : floEntity.feeamt != null) return false;
        if (feerate != null ? !feerate.equals(floEntity.feerate) : floEntity.feerate != null) return false;
        if (feespd != null ? !feespd.equals(floEntity.feespd) : floEntity.feespd != null) return false;
        if (flokey != null ? !flokey.equals(floEntity.flokey) : floEntity.flokey != null) return false;
        if (frspcd != null ? !frspcd.equals(floEntity.frspcd) : floEntity.frspcd != null) return false;
        if (gfeeamt != null ? !gfeeamt.equals(floEntity.gfeeamt) : floEntity.gfeeamt != null) return false;
        if (gfeerte != null ? !gfeerte.equals(floEntity.gfeerte) : floEntity.gfeerte != null) return false;
        if (glacnt != null ? !glacnt.equals(floEntity.glacnt) : floEntity.glacnt != null) return false;
        if (grelgo != null ? !grelgo.equals(floEntity.grelgo) : floEntity.grelgo != null) return false;
        if (grossamt != null ? !grossamt.equals(floEntity.grossamt) : floEntity.grossamt != null) return false;
        if (guardt != null ? !guardt.equals(floEntity.guardt) : floEntity.guardt != null) return false;
        if (guarid != null ? !guarid.equals(floEntity.guarid) : floEntity.guarid != null) return false;
        if (guarnm != null ? !guarnm.equals(floEntity.guarnm) : floEntity.guarnm != null) return false;
        if (healfl != null ? !healfl.equals(floEntity.healfl) : floEntity.healfl != null) return false;
        if (holdflg != null ? !holdflg.equals(floEntity.holdflg) : floEntity.holdflg != null) return false;
        if (incar != null ? !incar.equals(floEntity.incar) : floEntity.incar != null) return false;
        if (incars != null ? !incars.equals(floEntity.incars) : floEntity.incars != null) return false;
        if (instn != null ? !instn.equals(floEntity.instn) : floEntity.instn != null) return false;
        if (intrate != null ? !intrate.equals(floEntity.intrate) : floEntity.intrate != null) return false;
        if (lacdte != null ? !lacdte.equals(floEntity.lacdte) : floEntity.lacdte != null) return false;
        if (laddr != null ? !laddr.equals(floEntity.laddr) : floEntity.laddr != null) return false;
        if (laddr2 != null ? !laddr2.equals(floEntity.laddr2) : floEntity.laddr2 != null) return false;
        if (laddr3 != null ? !laddr3.equals(floEntity.laddr3) : floEntity.laddr3 != null) return false;
        if (lcancde2 != null ? !lcancde2.equals(floEntity.lcancde2) : floEntity.lcancde2 != null) return false;
        if (lcancde3 != null ? !lcancde3.equals(floEntity.lcancde3) : floEntity.lcancde3 != null) return false;
        if (lcancs != null ? !lcancs.equals(floEntity.lcancs) : floEntity.lcancs != null) return false;
        if (lcands != null ? !lcands.equals(floEntity.lcands) : floEntity.lcands != null) return false;
        if (lcandte2 != null ? !lcandte2.equals(floEntity.lcandte2) : floEntity.lcandte2 != null) return false;
        if (lcandte3 != null ? !lcandte3.equals(floEntity.lcandte3) : floEntity.lcandte3 != null) return false;
        if (lcity != null ? !lcity.equals(floEntity.lcity) : floEntity.lcity != null) return false;
        if (lcity2 != null ? !lcity2.equals(floEntity.lcity2) : floEntity.lcity2 != null) return false;
        if (lcity3 != null ? !lcity3.equals(floEntity.lcity3) : floEntity.lcity3 != null) return false;
        if (lcoment != null ? !lcoment.equals(floEntity.lcoment) : floEntity.lcoment != null) return false;
        if (lendid != null ? !lendid.equals(floEntity.lendid) : floEntity.lendid != null) return false;
        if (lendnm != null ? !lendnm.equals(floEntity.lendnm) : floEntity.lendnm != null) return false;
        if (lfeeamt != null ? !lfeeamt.equals(floEntity.lfeeamt) : floEntity.lfeeamt != null) return false;
        if (lfeerte != null ? !lfeerte.equals(floEntity.lfeerte) : floEntity.lfeerte != null) return false;
        if (loanclr != null ? !loanclr.equals(floEntity.loanclr) : floEntity.loanclr != null) return false;
        if (loanstat != null ? !loanstat.equals(floEntity.loanstat) : floEntity.loanstat != null) return false;
        if (lrrdte != null ? !lrrdte.equals(floEntity.lrrdte) : floEntity.lrrdte != null) return false;
        if (lstate != null ? !lstate.equals(floEntity.lstate) : floEntity.lstate != null) return false;
        if (lstate2 != null ? !lstate2.equals(floEntity.lstate2) : floEntity.lstate2 != null) return false;
        if (lstate3 != null ? !lstate3.equals(floEntity.lstate3) : floEntity.lstate3 != null) return false;
        if (ltelgus != null ? !ltelgus.equals(floEntity.ltelgus) : floEntity.ltelgus != null) return false;
        if (ltuit != null ? !ltuit.equals(floEntity.ltuit) : floEntity.ltuit != null) return false;
        if (ltuits != null ? !ltuits.equals(floEntity.ltuits) : floEntity.ltuits != null) return false;
        if (lzip != null ? !lzip.equals(floEntity.lzip) : floEntity.lzip != null) return false;
        if (lzip2 != null ? !lzip2.equals(floEntity.lzip2) : floEntity.lzip2 != null) return false;
        if (lzip3 != null ? !lzip3.equals(floEntity.lzip3) : floEntity.lzip3 != null) return false;
        if (mpnamt != null ? !mpnamt.equals(floEntity.mpnamt) : floEntity.mpnamt != null) return false;
        if (mpnid != null ? !mpnid.equals(floEntity.mpnid) : floEntity.mpnid != null) return false;
        if (mpnind != null ? !mpnind.equals(floEntity.mpnind) : floEntity.mpnind != null) return false;
        if (mpnrqat != null ? !mpnrqat.equals(floEntity.mpnrqat) : floEntity.mpnrqat != null) return false;
        if (mpnstat != null ? !mpnstat.equals(floEntity.mpnstat) : floEntity.mpnstat != null) return false;
        if (mxlnamt != null ? !mxlnamt.equals(floEntity.mxlnamt) : floEntity.mxlnamt != null) return false;
        if (netamt != null ? !netamt.equals(floEntity.netamt) : floEntity.netamt != null) return false;
        if (ngpamt != null ? !ngpamt.equals(floEntity.ngpamt) : floEntity.ngpamt != null) return false;
        if (ocrdcst != null ? !ocrdcst.equals(floEntity.ocrdcst) : floEntity.ocrdcst != null) return false;
        if (orgcbth != null ? !orgcbth.equals(floEntity.orgcbth) : floEntity.orgcbth != null) return false;
        if (origbtch != null ? !origbtch.equals(floEntity.origbtch) : floEntity.origbtch != null) return false;
        if (origdate != null ? !origdate.equals(floEntity.origdate) : floEntity.origdate != null) return false;
        if (origdte != null ? !origdte.equals(floEntity.origdte) : floEntity.origdte != null) return false;
        if (outsln != null ? !outsln.equals(floEntity.outsln) : floEntity.outsln != null) return false;
        if (pacdte != null ? !pacdte.equals(floEntity.pacdte) : floEntity.pacdte != null) return false;
        if (paddr != null ? !paddr.equals(floEntity.paddr) : floEntity.paddr != null) return false;
        if (paddr2 != null ? !paddr2.equals(floEntity.paddr2) : floEntity.paddr2 != null) return false;
        if (paddr2S != null ? !paddr2S.equals(floEntity.paddr2S) : floEntity.paddr2S != null) return false;
        if (paddrst != null ? !paddrst.equals(floEntity.paddrst) : floEntity.paddrst != null) return false;
        if (padr2 != null ? !padr2.equals(floEntity.padr2) : floEntity.padr2 != null) return false;
        if (padr22 != null ? !padr22.equals(floEntity.padr22) : floEntity.padr22 != null) return false;
        if (padr23 != null ? !padr23.equals(floEntity.padr23) : floEntity.padr23 != null) return false;
        if (padr3 != null ? !padr3.equals(floEntity.padr3) : floEntity.padr3 != null) return false;
        if (parn != null ? !parn.equals(floEntity.parn) : floEntity.parn != null) return false;
        if (parn2 != null ? !parn2.equals(floEntity.parn2) : floEntity.parn2 != null) return false;
        if (parn3 != null ? !parn3.equals(floEntity.parn3) : floEntity.parn3 != null) return false;
        if (parssn != null ? !parssn.equals(floEntity.parssn) : floEntity.parssn != null) return false;
        if (parssn2 != null ? !parssn2.equals(floEntity.parssn2) : floEntity.parssn2 != null) return false;
        if (parssn3 != null ? !parssn3.equals(floEntity.parssn3) : floEntity.parssn3 != null) return false;
        if (pcitizen != null ? !pcitizen.equals(floEntity.pcitizen) : floEntity.pcitizen != null) return false;
        if (pcity != null ? !pcity.equals(floEntity.pcity) : floEntity.pcity != null) return false;
        if (pcity2 != null ? !pcity2.equals(floEntity.pcity2) : floEntity.pcity2 != null) return false;
        if (pcity3 != null ? !pcity3.equals(floEntity.pcity3) : floEntity.pcity3 != null) return false;
        if (pcityst != null ? !pcityst.equals(floEntity.pcityst) : floEntity.pcityst != null) return false;
        if (pcitzen2 != null ? !pcitzen2.equals(floEntity.pcitzen2) : floEntity.pcitzen2 != null) return false;
        if (pcitzen3 != null ? !pcitzen3.equals(floEntity.pcitzen3) : floEntity.pcitzen3 != null) return false;
        if (pdefalt2 != null ? !pdefalt2.equals(floEntity.pdefalt2) : floEntity.pdefalt2 != null) return false;
        if (pdefalt3 != null ? !pdefalt3.equals(floEntity.pdefalt3) : floEntity.pdefalt3 != null) return false;
        if (pdefault != null ? !pdefault.equals(floEntity.pdefault) : floEntity.pdefault != null) return false;
        if (pdflts != null ? !pdflts.equals(floEntity.pdflts) : floEntity.pdflts != null) return false;
        if (pdob != null ? !pdob.equals(floEntity.pdob) : floEntity.pdob != null) return false;
        if (pdob2 != null ? !pdob2.equals(floEntity.pdob2) : floEntity.pdob2 != null) return false;
        if (pdob3 != null ? !pdob3.equals(floEntity.pdob3) : floEntity.pdob3 != null) return false;
        if (pdtesgn2 != null ? !pdtesgn2.equals(floEntity.pdtesgn2) : floEntity.pdtesgn2 != null) return false;
        if (pdtesgn3 != null ? !pdtesgn3.equals(floEntity.pdtesgn3) : floEntity.pdtesgn3 != null) return false;
        if (pdtesign != null ? !pdtesign.equals(floEntity.pdtesign) : floEntity.pdtesign != null) return false;
        if (pdtl != null ? !pdtl.equals(floEntity.pdtl) : floEntity.pdtl != null) return false;
        if (pdtl2 != null ? !pdtl2.equals(floEntity.pdtl2) : floEntity.pdtl2 != null) return false;
        if (pdtl3 != null ? !pdtl3.equals(floEntity.pdtl3) : floEntity.pdtl3 != null) return false;
        if (pdtlst != null ? !pdtlst.equals(floEntity.pdtlst) : floEntity.pdtlst != null) return false;
        if (pellelg != null ? !pellelg.equals(floEntity.pellelg) : floEntity.pellelg != null) return false;
        if (perbeg != null ? !perbeg.equals(floEntity.perbeg) : floEntity.perbeg != null) return false;
        if (perbeg0 != null ? !perbeg0.equals(floEntity.perbeg0) : floEntity.perbeg0 != null) return false;
        if (perbeg2 != null ? !perbeg2.equals(floEntity.perbeg2) : floEntity.perbeg2 != null) return false;
        if (perbeg3 != null ? !perbeg3.equals(floEntity.perbeg3) : floEntity.perbeg3 != null) return false;
        if (perbes != null ? !perbes.equals(floEntity.perbes) : floEntity.perbes != null) return false;
        if (percd != null ? !percd.equals(floEntity.percd) : floEntity.percd != null) return false;
        if (percd2 != null ? !percd2.equals(floEntity.percd2) : floEntity.percd2 != null) return false;
        if (percd3 != null ? !percd3.equals(floEntity.percd3) : floEntity.percd3 != null) return false;
        if (perend != null ? !perend.equals(floEntity.perend) : floEntity.perend != null) return false;
        if (perend0 != null ? !perend0.equals(floEntity.perend0) : floEntity.perend0 != null) return false;
        if (perend2 != null ? !perend2.equals(floEntity.perend2) : floEntity.perend2 != null) return false;
        if (perend3 != null ? !perend3.equals(floEntity.perend3) : floEntity.perend3 != null) return false;
        if (perens != null ? !perens.equals(floEntity.perens) : floEntity.perens != null) return false;
        if (pgmtcd != null ? !pgmtcd.equals(floEntity.pgmtcd) : floEntity.pgmtcd != null) return false;
        if (pgmtcd2 != null ? !pgmtcd2.equals(floEntity.pgmtcd2) : floEntity.pgmtcd2 != null) return false;
        if (pgmtcd3 != null ? !pgmtcd3.equals(floEntity.pgmtcd3) : floEntity.pgmtcd3 != null) return false;
        if (pgtrnhi != null ? !pgtrnhi.equals(floEntity.pgtrnhi) : floEntity.pgtrnhi != null) return false;
        if (pgtrnnr != null ? !pgtrnnr.equals(floEntity.pgtrnnr) : floEntity.pgtrnnr != null) return false;
        if (pgvalst != null ? !pgvalst.equals(floEntity.pgvalst) : floEntity.pgvalst != null) return false;
        if (pgvalvi != null ? !pgvalvi.equals(floEntity.pgvalvi) : floEntity.pgvalvi != null) return false;
        if (phasecd != null ? !phasecd.equals(floEntity.phasecd) : floEntity.phasecd != null) return false;
        if (plusbch != null ? !plusbch.equals(floEntity.plusbch) : floEntity.plusbch != null) return false;
        if (pluserq != null ? !pluserq.equals(floEntity.pluserq) : floEntity.pluserq != null) return false;
        if (plusrq2 != null ? !plusrq2.equals(floEntity.plusrq2) : floEntity.plusrq2 != null) return false;
        if (plusrq3 != null ? !plusrq3.equals(floEntity.plusrq3) : floEntity.plusrq3 != null) return false;
        if (pmeth != null ? !pmeth.equals(floEntity.pmeth) : floEntity.pmeth != null) return false;
        if (pmnid != null ? !pmnid.equals(floEntity.pmnid) : floEntity.pmnid != null) return false;
        if (pnamef != null ? !pnamef.equals(floEntity.pnamef) : floEntity.pnamef != null) return false;
        if (pnamef2 != null ? !pnamef2.equals(floEntity.pnamef2) : floEntity.pnamef2 != null) return false;
        if (pnamef3 != null ? !pnamef3.equals(floEntity.pnamef3) : floEntity.pnamef3 != null) return false;
        if (pnamel != null ? !pnamel.equals(floEntity.pnamel) : floEntity.pnamel != null) return false;
        if (pnamel2 != null ? !pnamel2.equals(floEntity.pnamel2) : floEntity.pnamel2 != null) return false;
        if (pnamel3 != null ? !pnamel3.equals(floEntity.pnamel3) : floEntity.pnamel3 != null) return false;
        if (pnamem != null ? !pnamem.equals(floEntity.pnamem) : floEntity.pnamem != null) return false;
        if (pnamem2 != null ? !pnamem2.equals(floEntity.pnamem2) : floEntity.pnamem2 != null) return false;
        if (pnamem3 != null ? !pnamem3.equals(floEntity.pnamem3) : floEntity.pnamem3 != null) return false;
        if (pndlst != null ? !pndlst.equals(floEntity.pndlst) : floEntity.pndlst != null) return false;
        if (pndtes != null ? !pndtes.equals(floEntity.pndtes) : floEntity.pndtes != null) return false;
        if (pndtes2 != null ? !pndtes2.equals(floEntity.pndtes2) : floEntity.pndtes2 != null) return false;
        if (pndtes3 != null ? !pndtes3.equals(floEntity.pndtes3) : floEntity.pndtes3 != null) return false;
        if (pninds != null ? !pninds.equals(floEntity.pninds) : floEntity.pninds != null) return false;
        if (pnotebth != null ? !pnotebth.equals(floEntity.pnotebth) : floEntity.pnotebth != null) return false;
        if (pnotecnf != null ? !pnotecnf.equals(floEntity.pnotecnf) : floEntity.pnotecnf != null) return false;
        if (pnoteind != null ? !pnoteind.equals(floEntity.pnoteind) : floEntity.pnoteind != null) return false;
        if (pnotend2 != null ? !pnotend2.equals(floEntity.pnotend2) : floEntity.pnotend2 != null) return false;
        if (pnotend3 != null ? !pnotend3.equals(floEntity.pnotend3) : floEntity.pnotend3 != null) return false;
        if (pnoteprt != null ? !pnoteprt.equals(floEntity.pnoteprt) : floEntity.pnoteprt != null) return false;
        if (pnoterec != null ? !pnoterec.equals(floEntity.pnoterec) : floEntity.pnoterec != null) return false;
        if (pnotesnt != null ? !pnotesnt.equals(floEntity.pnotesnt) : floEntity.pnotesnt != null) return false;
        if (pnotind2 != null ? !pnotind2.equals(floEntity.pnotind2) : floEntity.pnotind2 != null) return false;
        if (pnotind3 != null ? !pnotind3.equals(floEntity.pnotind3) : floEntity.pnotind3 != null) return false;
        if (pnotprt2 != null ? !pnotprt2.equals(floEntity.pnotprt2) : floEntity.pnotprt2 != null) return false;
        if (pnotprt3 != null ? !pnotprt3.equals(floEntity.pnotprt3) : floEntity.pnotprt3 != null) return false;
        if (pnotrec2 != null ? !pnotrec2.equals(floEntity.pnotrec2) : floEntity.pnotrec2 != null) return false;
        if (pnotrec3 != null ? !pnotrec3.equals(floEntity.pnotrec3) : floEntity.pnotrec3 != null) return false;
        if (pnprts != null ? !pnprts.equals(floEntity.pnprts) : floEntity.pnprts != null) return false;
        if (pnseqn2 != null ? !pnseqn2.equals(floEntity.pnseqn2) : floEntity.pnseqn2 != null) return false;
        if (pnseqn3 != null ? !pnseqn3.equals(floEntity.pnseqn3) : floEntity.pnseqn3 != null) return false;
        if (pnseqno != null ? !pnseqno.equals(floEntity.pnseqno) : floEntity.pnseqno != null) return false;
        if (pnsign != null ? !pnsign.equals(floEntity.pnsign) : floEntity.pnsign != null) return false;
        if (pnsign2 != null ? !pnsign2.equals(floEntity.pnsign2) : floEntity.pnsign2 != null) return false;
        if (pnsign3 != null ? !pnsign3.equals(floEntity.pnsign3) : floEntity.pnsign3 != null) return false;
        if (pnumdl != null ? !pnumdl.equals(floEntity.pnumdl) : floEntity.pnumdl != null) return false;
        if (pnumdl2 != null ? !pnumdl2.equals(floEntity.pnumdl2) : floEntity.pnumdl2 != null) return false;
        if (pnumdl3 != null ? !pnumdl3.equals(floEntity.pnumdl3) : floEntity.pnumdl3 != null) return false;
        if (popflag != null ? !popflag.equals(floEntity.popflag) : floEntity.popflag != null) return false;
        if (pphone != null ? !pphone.equals(floEntity.pphone) : floEntity.pphone != null) return false;
        if (pphone2 != null ? !pphone2.equals(floEntity.pphone2) : floEntity.pphone2 != null) return false;
        if (pphone3 != null ? !pphone3.equals(floEntity.pphone3) : floEntity.pphone3 != null) return false;
        if (pphones != null ? !pphones.equals(floEntity.pphones) : floEntity.pphones != null) return false;
        if (prefamt != null ? !prefamt.equals(floEntity.prefamt) : floEntity.prefamt != null) return false;
        if (prefdte != null ? !prefdte.equals(floEntity.prefdte) : floEntity.prefdte != null) return false;
        if (proctyp != null ? !proctyp.equals(floEntity.proctyp) : floEntity.proctyp != null) return false;
        if (procyr != null ? !procyr.equals(floEntity.procyr) : floEntity.procyr != null) return false;
        if (prodte2 != null ? !prodte2.equals(floEntity.prodte2) : floEntity.prodte2 != null) return false;
        if (prodte3 != null ? !prodte3.equals(floEntity.prodte3) : floEntity.prodte3 != null) return false;
        if (prodts != null ? !prodts.equals(floEntity.prodts) : floEntity.prodts != null) return false;
        if (product != null ? !product.equals(floEntity.product) : floEntity.product != null) return false;
        if (progdate != null ? !progdate.equals(floEntity.progdate) : floEntity.progdate != null) return false;
        if (promstat != null ? !promstat.equals(floEntity.promstat) : floEntity.promstat != null) return false;
        if (promtyp != null ? !promtyp.equals(floEntity.promtyp) : floEntity.promtyp != null) return false;
        if (psntyp != null ? !psntyp.equals(floEntity.psntyp) : floEntity.psntyp != null) return false;
        if (pstate != null ? !pstate.equals(floEntity.pstate) : floEntity.pstate != null) return false;
        if (pstate2 != null ? !pstate2.equals(floEntity.pstate2) : floEntity.pstate2 != null) return false;
        if (pstate3 != null ? !pstate3.equals(floEntity.pstate3) : floEntity.pstate3 != null) return false;
        if (pstates != null ? !pstates.equals(floEntity.pstates) : floEntity.pstates != null) return false;
        if (ptype != null ? !ptype.equals(floEntity.ptype) : floEntity.ptype != null) return false;
        if (pzip != null ? !pzip.equals(floEntity.pzip) : floEntity.pzip != null) return false;
        if (pzip2 != null ? !pzip2.equals(floEntity.pzip2) : floEntity.pzip2 != null) return false;
        if (pzip3 != null ? !pzip3.equals(floEntity.pzip3) : floEntity.pzip3 != null) return false;
        if (pzipst != null ? !pzipst.equals(floEntity.pzipst) : floEntity.pzipst != null) return false;
        if (raccal != null ? !raccal.equals(floEntity.raccal) : floEntity.raccal != null) return false;
        if (rebamt != null ? !rebamt.equals(floEntity.rebamt) : floEntity.rebamt != null) return false;
        if (rebrate != null ? !rebrate.equals(floEntity.rebrate) : floEntity.rebrate != null) return false;
        if (recstat != null ? !recstat.equals(floEntity.recstat) : floEntity.recstat != null) return false;
        if (rectype != null ? !rectype.equals(floEntity.rectype) : floEntity.rectype != null) return false;
        if (reqln0 != null ? !reqln0.equals(floEntity.reqln0) : floEntity.reqln0 != null) return false;
        if (reqln2 != null ? !reqln2.equals(floEntity.reqln2) : floEntity.reqln2 != null) return false;
        if (reqln3 != null ? !reqln3.equals(floEntity.reqln3) : floEntity.reqln3 != null) return false;
        if (reqlns != null ? !reqlns.equals(floEntity.reqlns) : floEntity.reqlns != null) return false;
        if (reqloan != null ? !reqloan.equals(floEntity.reqloan) : floEntity.reqloan != null) return false;
        if (revdate != null ? !revdate.equals(floEntity.revdate) : floEntity.revdate != null) return false;
        if (revpgm != null ? !revpgm.equals(floEntity.revpgm) : floEntity.revpgm != null) return false;
        if (revtime != null ? !revtime.equals(floEntity.revtime) : floEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(floEntity.revuser) : floEntity.revuser != null) return false;
        if (rinstn != null ? !rinstn.equals(floEntity.rinstn) : floEntity.rinstn != null) return false;
        if (rltuit != null ? !rltuit.equals(floEntity.rltuit) : floEntity.rltuit != null) return false;
        if (rpmeth != null ? !rpmeth.equals(floEntity.rpmeth) : floEntity.rpmeth != null) return false;
        if (rwicp != null ? !rwicp.equals(floEntity.rwicp) : floEntity.rwicp != null) return false;
        if (rwpacy != null ? !rwpacy.equals(floEntity.rwpacy) : floEntity.rwpacy != null) return false;
        if (samexp != null ? !samexp.equals(floEntity.samexp) : floEntity.samexp != null) return false;
        if (sarn != null ? !sarn.equals(floEntity.sarn) : floEntity.sarn != null) return false;
        if (sarn2 != null ? !sarn2.equals(floEntity.sarn2) : floEntity.sarn2 != null) return false;
        if (sarn3 != null ? !sarn3.equals(floEntity.sarn3) : floEntity.sarn3 != null) return false;
        if (schpell != null ? !schpell.equals(floEntity.schpell) : floEntity.schpell != null) return false;
        if (sctzen != null ? !sctzen.equals(floEntity.sctzen) : floEntity.sctzen != null) return false;
        if (sctzen2 != null ? !sctzen2.equals(floEntity.sctzen2) : floEntity.sctzen2 != null) return false;
        if (sctzen3 != null ? !sctzen3.equals(floEntity.sctzen3) : floEntity.sctzen3 != null) return false;
        if (sdob != null ? !sdob.equals(floEntity.sdob) : floEntity.sdob != null) return false;
        if (sdob2 != null ? !sdob2.equals(floEntity.sdob2) : floEntity.sdob2 != null) return false;
        if (sdob3 != null ? !sdob3.equals(floEntity.sdob3) : floEntity.sdob3 != null) return false;
        if (sefcs != null ? !sefcs.equals(floEntity.sefcs) : floEntity.sefcs != null) return false;
        if (sefefcf != null ? !sefefcf.equals(floEntity.sefefcf) : floEntity.sefefcf != null) return false;
        if (senrds != null ? !senrds.equals(floEntity.senrds) : floEntity.senrds != null) return false;
        if (senrsdt != null ? !senrsdt.equals(floEntity.senrsdt) : floEntity.senrsdt != null) return false;
        if (senrsdt2 != null ? !senrsdt2.equals(floEntity.senrsdt2) : floEntity.senrsdt2 != null) return false;
        if (senrsdt3 != null ? !senrsdt3.equals(floEntity.senrsdt3) : floEntity.senrsdt3 != null) return false;
        if (senrss != null ? !senrss.equals(floEntity.senrss) : floEntity.senrss != null) return false;
        if (senrst != null ? !senrst.equals(floEntity.senrst) : floEntity.senrst != null) return false;
        if (senrst2 != null ? !senrst2.equals(floEntity.senrst2) : floEntity.senrst2 != null) return false;
        if (senrst3 != null ? !senrst3.equals(floEntity.senrst3) : floEntity.senrst3 != null) return false;
        if (servdate != null ? !servdate.equals(floEntity.servdate) : floEntity.servdate != null) return false;
        if (servid != null ? !servid.equals(floEntity.servid) : floEntity.servid != null) return false;
        if (sfaind != null ? !sfaind.equals(floEntity.sfaind) : floEntity.sfaind != null) return false;
        if (sid != null ? !sid.equals(floEntity.sid) : floEntity.sid != null) return false;
        if (snamef != null ? !snamef.equals(floEntity.snamef) : floEntity.snamef != null) return false;
        if (snamef2 != null ? !snamef2.equals(floEntity.snamef2) : floEntity.snamef2 != null) return false;
        if (snamef3 != null ? !snamef3.equals(floEntity.snamef3) : floEntity.snamef3 != null) return false;
        if (snamel != null ? !snamel.equals(floEntity.snamel) : floEntity.snamel != null) return false;
        if (snamel2 != null ? !snamel2.equals(floEntity.snamel2) : floEntity.snamel2 != null) return false;
        if (snamel3 != null ? !snamel3.equals(floEntity.snamel3) : floEntity.snamel3 != null) return false;
        if (snamem != null ? !snamem.equals(floEntity.snamem) : floEntity.snamem != null) return false;
        if (snamem2 != null ? !snamem2.equals(floEntity.snamem2) : floEntity.snamem2 != null) return false;
        if (snamem3 != null ? !snamem3.equals(floEntity.snamem3) : floEntity.snamem3 != null) return false;
        if (spnsg != null ? !spnsg.equals(floEntity.spnsg) : floEntity.spnsg != null) return false;
        if (spnsg2 != null ? !spnsg2.equals(floEntity.spnsg2) : floEntity.spnsg2 != null) return false;
        if (spnsg3 != null ? !spnsg3.equals(floEntity.spnsg3) : floEntity.spnsg3 != null) return false;
        if (srcode != null ? !srcode.equals(floEntity.srcode) : floEntity.srcode != null) return false;
        if (ssncdte != null ? !ssncdte.equals(floEntity.ssncdte) : floEntity.ssncdte != null) return false;
        if (statcd != null ? !statcd.equals(floEntity.statcd) : floEntity.statcd != null) return false;
        if (strdte2 != null ? !strdte2.equals(floEntity.strdte2) : floEntity.strdte2 != null) return false;
        if (strdte3 != null ? !strdte3.equals(floEntity.strdte3) : floEntity.strdte3 != null) return false;
        if (strdts != null ? !strdts.equals(floEntity.strdts) : floEntity.strdts != null) return false;
        if (strtdate != null ? !strtdate.equals(floEntity.strtdate) : floEntity.strtdate != null) return false;
        if (suprind != null ? !suprind.equals(floEntity.suprind) : floEntity.suprind != null) return false;
        if (tbdebt != null ? !tbdebt.equals(floEntity.tbdebt) : floEntity.tbdebt != null) return false;
        if (tbdebt2 != null ? !tbdebt2.equals(floEntity.tbdebt2) : floEntity.tbdebt2 != null) return false;
        if (tbdebt3 != null ? !tbdebt3.equals(floEntity.tbdebt3) : floEntity.tbdebt3 != null) return false;
        if (tchexpi != null ? !tchexpi.equals(floEntity.tchexpi) : floEntity.tchexpi != null) return false;
        if (telgusd != null ? !telgusd.equals(floEntity.telgusd) : floEntity.telgusd != null) return false;
        if (term != null ? !term.equals(floEntity.term) : floEntity.term != null) return false;
        if (tpelgus != null ? !tpelgus.equals(floEntity.tpelgus) : floEntity.tpelgus != null) return false;
        if (transdte != null ? !transdte.equals(floEntity.transdte) : floEntity.transdte != null) return false;
        if (transmit != null ? !transmit.equals(floEntity.transmit) : floEntity.transmit != null) return false;
        if (transno != null ? !transno.equals(floEntity.transno) : floEntity.transno != null) return false;
        if (typeaid != null ? !typeaid.equals(floEntity.typeaid) : floEntity.typeaid != null) return false;
        if (ucode != null ? !ucode.equals(floEntity.ucode) : floEntity.ucode != null) return false;
        if (unqueid != null ? !unqueid.equals(floEntity.unqueid) : floEntity.unqueid != null) return false;
        if (unused1 != null ? !unused1.equals(floEntity.unused1) : floEntity.unused1 != null) return false;
        if (unuseda != null ? !unuseda.equals(floEntity.unuseda) : floEntity.unuseda != null) return false;
        if (unusedb != null ? !unusedb.equals(floEntity.unusedb) : floEntity.unusedb != null) return false;
        if (unusedc != null ? !unusedc.equals(floEntity.unusedc) : floEntity.unusedc != null) return false;
        if (unusedd != null ? !unusedd.equals(floEntity.unusedd) : floEntity.unusedd != null) return false;
        if (usercd1 != null ? !usercd1.equals(floEntity.usercd1) : floEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(floEntity.usercd2) : floEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(floEntity.usercd3) : floEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(floEntity.usercd4) : floEntity.usercd4 != null) return false;
        if (usercd5 != null ? !usercd5.equals(floEntity.usercd5) : floEntity.usercd5 != null) return false;
        if (usercd6 != null ? !usercd6.equals(floEntity.usercd6) : floEntity.usercd6 != null) return false;
        if (usercd7 != null ? !usercd7.equals(floEntity.usercd7) : floEntity.usercd7 != null) return false;
        if (usercd8 != null ? !usercd8.equals(floEntity.usercd8) : floEntity.usercd8 != null) return false;
        if (usernr3 != null ? !usernr3.equals(floEntity.usernr3) : floEntity.usernr3 != null) return false;
        if (usernr4 != null ? !usernr4.equals(floEntity.usernr4) : floEntity.usernr4 != null) return false;
        if (usubamt != null ? !usubamt.equals(floEntity.usubamt) : floEntity.usubamt != null) return false;
        if (usubamt2 != null ? !usubamt2.equals(floEntity.usubamt2) : floEntity.usubamt2 != null) return false;
        if (usubamt3 != null ? !usubamt3.equals(floEntity.usubamt3) : floEntity.usubamt3 != null) return false;
        if (valsts != null ? !valsts.equals(floEntity.valsts) : floEntity.valsts != null) return false;
        if (vendor != null ? !vendor.equals(floEntity.vendor) : floEntity.vendor != null) return false;
        if (vendor2 != null ? !vendor2.equals(floEntity.vendor2) : floEntity.vendor2 != null) return false;
        if (vendor3 != null ? !vendor3.equals(floEntity.vendor3) : floEntity.vendor3 != null) return false;
        if (wicp != null ? !wicp.equals(floEntity.wicp) : floEntity.wicp != null) return false;
        if (wpacy != null ? !wpacy.equals(floEntity.wpacy) : floEntity.wpacy != null) return false;
        if (ytdamt != null ? !ytdamt.equals(floEntity.ytdamt) : floEntity.ytdamt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (flokey != null ? flokey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (aidid != null ? aidid.hashCode() : 0);
        result = 31 * result + (ptype != null ? ptype.hashCode() : 0);
        result = 31 * result + (unusedd != null ? unusedd.hashCode() : 0);
        result = 31 * result + (bsid != null ? bsid.hashCode() : 0);
        result = 31 * result + (bprocyr != null ? bprocyr.hashCode() : 0);
        result = 31 * result + (blntype != null ? blntype.hashCode() : 0);
        result = 31 * result + (baidid != null ? baidid.hashCode() : 0);
        result = 31 * result + (bptype != null ? bptype.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtpgm != null ? crtpgm.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revpgm != null ? revpgm.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
        result = 31 * result + (loanstat != null ? loanstat.hashCode() : 0);
        result = 31 * result + (origdate != null ? origdate.hashCode() : 0);
        result = 31 * result + (unuseda != null ? unuseda.hashCode() : 0);
        result = 31 * result + (defaultr != null ? defaultr.hashCode() : 0);
        result = 31 * result + (glacnt != null ? glacnt.hashCode() : 0);
        result = 31 * result + (proctyp != null ? proctyp.hashCode() : 0);
        result = 31 * result + (rectype != null ? rectype.hashCode() : 0);
        result = 31 * result + (statcd != null ? statcd.hashCode() : 0);
        result = 31 * result + (depst != null ? depst.hashCode() : 0);
        result = 31 * result + (depst2 != null ? depst2.hashCode() : 0);
        result = 31 * result + (depst3 != null ? depst3.hashCode() : 0);
        result = 31 * result + (pnseqno != null ? pnseqno.hashCode() : 0);
        result = 31 * result + (phasecd != null ? phasecd.hashCode() : 0);
        result = 31 * result + (aidid2 != null ? aidid2.hashCode() : 0);
        result = 31 * result + (creditck != null ? creditck.hashCode() : 0);
        result = 31 * result + (credreq != null ? credreq.hashCode() : 0);
        result = 31 * result + (credrec != null ? credrec.hashCode() : 0);
        result = 31 * result + (credupd != null ? credupd.hashCode() : 0);
        result = 31 * result + (progdate != null ? progdate.hashCode() : 0);
        result = 31 * result + (strtdate != null ? strtdate.hashCode() : 0);
        result = 31 * result + (perbeg != null ? perbeg.hashCode() : 0);
        result = 31 * result + (perend != null ? perend.hashCode() : 0);
        result = 31 * result + (senrsdt != null ? senrsdt.hashCode() : 0);
        result = 31 * result + (servdate != null ? servdate.hashCode() : 0);
        result = 31 * result + (loanclr != null ? loanclr.hashCode() : 0);
        result = 31 * result + chgcnt;
        result = 31 * result + (plusrq2 != null ? plusrq2.hashCode() : 0);
        result = 31 * result + (pnseqn2 != null ? pnseqn2.hashCode() : 0);
        result = 31 * result + (feerate != null ? feerate.hashCode() : 0);
        result = 31 * result + (feeamt != null ? feeamt.hashCode() : 0);
        result = 31 * result + (netamt != null ? netamt.hashCode() : 0);
        result = 31 * result + (grossamt != null ? grossamt.hashCode() : 0);
        result = 31 * result + (afeeamt != null ? afeeamt.hashCode() : 0);
        result = 31 * result + (agrosamt != null ? agrosamt.hashCode() : 0);
        result = 31 * result + (anetamt != null ? anetamt.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + (usercd5 != null ? usercd5.hashCode() : 0);
        result = 31 * result + (usercd6 != null ? usercd6.hashCode() : 0);
        result = 31 * result + (usercd7 != null ? usercd7.hashCode() : 0);
        result = 31 * result + (usercd8 != null ? usercd8.hashCode() : 0);
        result = 31 * result + usernr1;
        result = 31 * result + usernr2;
        result = 31 * result + (usernr3 != null ? usernr3.hashCode() : 0);
        result = 31 * result + (usernr4 != null ? usernr4.hashCode() : 0);
        result = 31 * result + (pndtes != null ? pndtes.hashCode() : 0);
        result = 31 * result + (promstat != null ? promstat.hashCode() : 0);
        result = 31 * result + (pnoteind != null ? pnoteind.hashCode() : 0);
        result = 31 * result + (pnoteprt != null ? pnoteprt.hashCode() : 0);
        result = 31 * result + (pnoterec != null ? pnoterec.hashCode() : 0);
        result = 31 * result + (pnotesnt != null ? pnotesnt.hashCode() : 0);
        result = 31 * result + (unusedb != null ? unusedb.hashCode() : 0);
        result = 31 * result + (pnotecnf != null ? pnotecnf.hashCode() : 0);
        result = 31 * result + (cancode != null ? cancode.hashCode() : 0);
        result = 31 * result + (candate != null ? candate.hashCode() : 0);
        result = 31 * result + (transmit != null ? transmit.hashCode() : 0);
        result = 31 * result + (transdte != null ? transdte.hashCode() : 0);
        result = 31 * result + (transno != null ? transno.hashCode() : 0);
        result = 31 * result + (disdtcd != null ? disdtcd.hashCode() : 0);
        result = 31 * result + (holdflg != null ? holdflg.hashCode() : 0);
        result = 31 * result + (suprind != null ? suprind.hashCode() : 0);
        result = 31 * result + (typeaid != null ? typeaid.hashCode() : 0);
        result = 31 * result + (dtmflag != null ? dtmflag.hashCode() : 0);
        result = 31 * result + (dishd01 != null ? dishd01.hashCode() : 0);
        result = 31 * result + (dishd02 != null ? dishd02.hashCode() : 0);
        result = 31 * result + (dishd03 != null ? dishd03.hashCode() : 0);
        result = 31 * result + (dishd04 != null ? dishd04.hashCode() : 0);
        result = 31 * result + (dishd05 != null ? dishd05.hashCode() : 0);
        result = 31 * result + (dishd06 != null ? dishd06.hashCode() : 0);
        result = 31 * result + (dishd07 != null ? dishd07.hashCode() : 0);
        result = 31 * result + (dishd08 != null ? dishd08.hashCode() : 0);
        result = 31 * result + (dishd09 != null ? dishd09.hashCode() : 0);
        result = 31 * result + (dishd10 != null ? dishd10.hashCode() : 0);
        result = 31 * result + (dishd11 != null ? dishd11.hashCode() : 0);
        result = 31 * result + (dishd12 != null ? dishd12.hashCode() : 0);
        result = 31 * result + (dishd13 != null ? dishd13.hashCode() : 0);
        result = 31 * result + (dishd14 != null ? dishd14.hashCode() : 0);
        result = 31 * result + (dishd15 != null ? dishd15.hashCode() : 0);
        result = 31 * result + (dishd16 != null ? dishd16.hashCode() : 0);
        result = 31 * result + (dishd17 != null ? dishd17.hashCode() : 0);
        result = 31 * result + (dishd18 != null ? dishd18.hashCode() : 0);
        result = 31 * result + (dishd19 != null ? dishd19.hashCode() : 0);
        result = 31 * result + (dishd20 != null ? dishd20.hashCode() : 0);
        result = 31 * result + (chgtyp1 != null ? chgtyp1.hashCode() : 0);
        result = 31 * result + (chgdis1 != null ? chgdis1.hashCode() : 0);
        result = 31 * result + (chgtyp2 != null ? chgtyp2.hashCode() : 0);
        result = 31 * result + (chgdis2 != null ? chgdis2.hashCode() : 0);
        result = 31 * result + (chgtyp3 != null ? chgtyp3.hashCode() : 0);
        result = 31 * result + (chgdis3 != null ? chgdis3.hashCode() : 0);
        result = 31 * result + (chgtyp4 != null ? chgtyp4.hashCode() : 0);
        result = 31 * result + (chgdis4 != null ? chgdis4.hashCode() : 0);
        result = 31 * result + (crefdte != null ? crefdte.hashCode() : 0);
        result = 31 * result + (crefamt != null ? crefamt.hashCode() : 0);
        result = 31 * result + (prefdte != null ? prefdte.hashCode() : 0);
        result = 31 * result + (prefamt != null ? prefamt.hashCode() : 0);
        result = 31 * result + (lcity != null ? lcity.hashCode() : 0);
        result = 31 * result + (lcity2 != null ? lcity2.hashCode() : 0);
        result = 31 * result + (lcity3 != null ? lcity3.hashCode() : 0);
        result = 31 * result + (lstate2 != null ? lstate2.hashCode() : 0);
        result = 31 * result + (lstate3 != null ? lstate3.hashCode() : 0);
        result = 31 * result + (lzip != null ? lzip.hashCode() : 0);
        result = 31 * result + (lzip2 != null ? lzip2.hashCode() : 0);
        result = 31 * result + (lzip3 != null ? lzip3.hashCode() : 0);
        result = 31 * result + (mpnind != null ? mpnind.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (unqueid != null ? unqueid.hashCode() : 0);
        result = 31 * result + (gfeerte != null ? gfeerte.hashCode() : 0);
        result = 31 * result + (gfeeamt != null ? gfeeamt.hashCode() : 0);
        result = 31 * result + (lfeerte != null ? lfeerte.hashCode() : 0);
        result = 31 * result + (lfeeamt != null ? lfeeamt.hashCode() : 0);
        result = 31 * result + (intrate != null ? intrate.hashCode() : 0);
        result = 31 * result + (rebrate != null ? rebrate.hashCode() : 0);
        result = 31 * result + (rebamt != null ? rebamt.hashCode() : 0);
        result = 31 * result + (arebamt != null ? arebamt.hashCode() : 0);
        result = 31 * result + (amtapp != null ? amtapp.hashCode() : 0);
        result = 31 * result + (reqloan != null ? reqloan.hashCode() : 0);
        result = 31 * result + (sdob != null ? sdob.hashCode() : 0);
        result = 31 * result + (sdob2 != null ? sdob2.hashCode() : 0);
        result = 31 * result + (sdob3 != null ? sdob3.hashCode() : 0);
        result = 31 * result + (origdte != null ? origdte.hashCode() : 0);
        result = 31 * result + (unusedc != null ? unusedc.hashCode() : 0);
        result = 31 * result + (ssncdte != null ? ssncdte.hashCode() : 0);
        result = 31 * result + (dobcdte != null ? dobcdte.hashCode() : 0);
        result = 31 * result + (lacdte != null ? lacdte.hashCode() : 0);
        result = 31 * result + (pluserq != null ? pluserq.hashCode() : 0);
        result = 31 * result + (plusbch != null ? plusbch.hashCode() : 0);
        result = 31 * result + (plusrq3 != null ? plusrq3.hashCode() : 0);
        result = 31 * result + (pnseqn3 != null ? pnseqn3.hashCode() : 0);
        result = 31 * result + (srcode != null ? srcode.hashCode() : 0);
        result = 31 * result + (healfl != null ? healfl.hashCode() : 0);
        result = 31 * result + (bkstat != null ? bkstat.hashCode() : 0);
        result = 31 * result + (bkdate != null ? bkdate.hashCode() : 0);
        result = 31 * result + (orgcbth != null ? orgcbth.hashCode() : 0);
        result = 31 * result + (senrst != null ? senrst.hashCode() : 0);
        result = 31 * result + (senrst2 != null ? senrst2.hashCode() : 0);
        result = 31 * result + (senrst3 != null ? senrst3.hashCode() : 0);
        result = 31 * result + (errcd1 != null ? errcd1.hashCode() : 0);
        result = 31 * result + (errcd2 != null ? errcd2.hashCode() : 0);
        result = 31 * result + (errcd3 != null ? errcd3.hashCode() : 0);
        result = 31 * result + (errcd4 != null ? errcd4.hashCode() : 0);
        result = 31 * result + (errcd5 != null ? errcd5.hashCode() : 0);
        result = 31 * result + (lendid != null ? lendid.hashCode() : 0);
        result = 31 * result + (guarid != null ? guarid.hashCode() : 0);
        result = 31 * result + (pcity2 != null ? pcity2.hashCode() : 0);
        result = 31 * result + (pcity3 != null ? pcity3.hashCode() : 0);
        result = 31 * result + (samexp != null ? samexp.hashCode() : 0);
        result = 31 * result + (paddrst != null ? paddrst.hashCode() : 0);
        result = 31 * result + (paddr2S != null ? paddr2S.hashCode() : 0);
        result = 31 * result + (pcityst != null ? pcityst.hashCode() : 0);
        result = 31 * result + (pstates != null ? pstates.hashCode() : 0);
        result = 31 * result + (pzipst != null ? pzipst.hashCode() : 0);
        result = 31 * result + (pphones != null ? pphones.hashCode() : 0);
        result = 31 * result + (pdtlst != null ? pdtlst.hashCode() : 0);
        result = 31 * result + (pndlst != null ? pndlst.hashCode() : 0);
        result = 31 * result + (pnamel != null ? pnamel.hashCode() : 0);
        result = 31 * result + (pnamef != null ? pnamef.hashCode() : 0);
        result = 31 * result + (pnamem != null ? pnamem.hashCode() : 0);
        result = 31 * result + (pcity != null ? pcity.hashCode() : 0);
        result = 31 * result + (pstate != null ? pstate.hashCode() : 0);
        result = 31 * result + (pzip != null ? pzip.hashCode() : 0);
        result = 31 * result + (pphone != null ? pphone.hashCode() : 0);
        result = 31 * result + (pdtl != null ? pdtl.hashCode() : 0);
        result = 31 * result + (pnumdl != null ? pnumdl.hashCode() : 0);
        result = 31 * result + (borwid != null ? borwid.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (class2 != null ? class2.hashCode() : 0);
        result = 31 * result + (class3 != null ? class3.hashCode() : 0);
        result = 31 * result + (pnsign != null ? pnsign.hashCode() : 0);
        result = 31 * result + (pnsign2 != null ? pnsign2.hashCode() : 0);
        result = 31 * result + (pnsign3 != null ? pnsign3.hashCode() : 0);
        result = 31 * result + (alpnmt != null ? alpnmt.hashCode() : 0);
        result = 31 * result + (alpnmt2 != null ? alpnmt2.hashCode() : 0);
        result = 31 * result + (alpnmt3 != null ? alpnmt3.hashCode() : 0);
        result = 31 * result + (percd != null ? percd.hashCode() : 0);
        result = 31 * result + (percd2 != null ? percd2.hashCode() : 0);
        result = 31 * result + (percd3 != null ? percd3.hashCode() : 0);
        result = 31 * result + (spnsg != null ? spnsg.hashCode() : 0);
        result = 31 * result + (spnsg2 != null ? spnsg2.hashCode() : 0);
        result = 31 * result + (spnsg3 != null ? spnsg3.hashCode() : 0);
        result = 31 * result + (lstate != null ? lstate.hashCode() : 0);
        result = 31 * result + (pacdte != null ? pacdte.hashCode() : 0);
        result = 31 * result + (vendor2 != null ? vendor2.hashCode() : 0);
        result = 31 * result + (default2 != null ? default2.hashCode() : 0);
        result = 31 * result + (prodte2 != null ? prodte2.hashCode() : 0);
        result = 31 * result + (strdte2 != null ? strdte2.hashCode() : 0);
        result = 31 * result + (perbeg2 != null ? perbeg2.hashCode() : 0);
        result = 31 * result + (perend2 != null ? perend2.hashCode() : 0);
        result = 31 * result + (senrsdt2 != null ? senrsdt2.hashCode() : 0);
        result = 31 * result + (pndtes2 != null ? pndtes2.hashCode() : 0);
        result = 31 * result + (pnotend2 != null ? pnotend2.hashCode() : 0);
        result = 31 * result + (pnotrec2 != null ? pnotrec2.hashCode() : 0);
        result = 31 * result + (lcancde2 != null ? lcancde2.hashCode() : 0);
        result = 31 * result + (lcandte2 != null ? lcandte2.hashCode() : 0);
        result = 31 * result + (parssn2 != null ? parssn2.hashCode() : 0);
        result = 31 * result + (amtapp2 != null ? amtapp2.hashCode() : 0);
        result = 31 * result + (reqln2 != null ? reqln2.hashCode() : 0);
        result = 31 * result + (pdob2 != null ? pdob2.hashCode() : 0);
        result = 31 * result + (pcitzen2 != null ? pcitzen2.hashCode() : 0);
        result = 31 * result + (parn2 != null ? parn2.hashCode() : 0);
        result = 31 * result + (pdefalt2 != null ? pdefalt2.hashCode() : 0);
        result = 31 * result + (pdtesgn2 != null ? pdtesgn2.hashCode() : 0);
        result = 31 * result + (pnotprt2 != null ? pnotprt2.hashCode() : 0);
        result = 31 * result + (borwid2 != null ? borwid2.hashCode() : 0);
        result = 31 * result + (pstate2 != null ? pstate2.hashCode() : 0);
        result = 31 * result + (pzip2 != null ? pzip2.hashCode() : 0);
        result = 31 * result + (pphone2 != null ? pphone2.hashCode() : 0);
        result = 31 * result + (pdtl2 != null ? pdtl2.hashCode() : 0);
        result = 31 * result + (pnumdl2 != null ? pnumdl2.hashCode() : 0);
        result = 31 * result + (sarn2 != null ? sarn2.hashCode() : 0);
        result = 31 * result + (sctzen2 != null ? sctzen2.hashCode() : 0);
        result = 31 * result + (pnotind2 != null ? pnotind2.hashCode() : 0);
        result = 31 * result + (vendor3 != null ? vendor3.hashCode() : 0);
        result = 31 * result + (default3 != null ? default3.hashCode() : 0);
        result = 31 * result + (prodte3 != null ? prodte3.hashCode() : 0);
        result = 31 * result + (strdte3 != null ? strdte3.hashCode() : 0);
        result = 31 * result + (perbeg3 != null ? perbeg3.hashCode() : 0);
        result = 31 * result + (perend3 != null ? perend3.hashCode() : 0);
        result = 31 * result + (senrsdt3 != null ? senrsdt3.hashCode() : 0);
        result = 31 * result + (pndtes3 != null ? pndtes3.hashCode() : 0);
        result = 31 * result + (pnotend3 != null ? pnotend3.hashCode() : 0);
        result = 31 * result + (pnotrec3 != null ? pnotrec3.hashCode() : 0);
        result = 31 * result + (lcancde3 != null ? lcancde3.hashCode() : 0);
        result = 31 * result + (lcandte3 != null ? lcandte3.hashCode() : 0);
        result = 31 * result + (parssn3 != null ? parssn3.hashCode() : 0);
        result = 31 * result + (amtapp3 != null ? amtapp3.hashCode() : 0);
        result = 31 * result + (reqln3 != null ? reqln3.hashCode() : 0);
        result = 31 * result + (pdob3 != null ? pdob3.hashCode() : 0);
        result = 31 * result + (pcitzen3 != null ? pcitzen3.hashCode() : 0);
        result = 31 * result + (parn3 != null ? parn3.hashCode() : 0);
        result = 31 * result + (pdefalt3 != null ? pdefalt3.hashCode() : 0);
        result = 31 * result + (pdtesgn3 != null ? pdtesgn3.hashCode() : 0);
        result = 31 * result + (pnotprt3 != null ? pnotprt3.hashCode() : 0);
        result = 31 * result + (borwid3 != null ? borwid3.hashCode() : 0);
        result = 31 * result + (pstate3 != null ? pstate3.hashCode() : 0);
        result = 31 * result + (pzip3 != null ? pzip3.hashCode() : 0);
        result = 31 * result + (pphone3 != null ? pphone3.hashCode() : 0);
        result = 31 * result + (pdtl3 != null ? pdtl3.hashCode() : 0);
        result = 31 * result + (pnumdl3 != null ? pnumdl3.hashCode() : 0);
        result = 31 * result + (sarn3 != null ? sarn3.hashCode() : 0);
        result = 31 * result + (sctzen3 != null ? sctzen3.hashCode() : 0);
        result = 31 * result + (pnotind3 != null ? pnotind3.hashCode() : 0);
        result = 31 * result + (parssn != null ? parssn.hashCode() : 0);
        result = 31 * result + (pdob != null ? pdob.hashCode() : 0);
        result = 31 * result + (pcitizen != null ? pcitizen.hashCode() : 0);
        result = 31 * result + (parn != null ? parn.hashCode() : 0);
        result = 31 * result + (pdefault != null ? pdefault.hashCode() : 0);
        result = 31 * result + (pdtesign != null ? pdtesign.hashCode() : 0);
        result = 31 * result + (sarn != null ? sarn.hashCode() : 0);
        result = 31 * result + (sctzen != null ? sctzen.hashCode() : 0);
        result = 31 * result + (lcoment != null ? lcoment.hashCode() : 0);
        result = 31 * result + (usubamt != null ? usubamt.hashCode() : 0);
        result = 31 * result + (usubamt2 != null ? usubamt2.hashCode() : 0);
        result = 31 * result + (usubamt3 != null ? usubamt3.hashCode() : 0);
        result = 31 * result + (origbtch != null ? origbtch.hashCode() : 0);
        result = 31 * result + (pnotebth != null ? pnotebth.hashCode() : 0);
        result = 31 * result + (enddat != null ? enddat.hashCode() : 0);
        result = 31 * result + (enddat2 != null ? enddat2.hashCode() : 0);
        result = 31 * result + (enddat3 != null ? enddat3.hashCode() : 0);
        result = 31 * result + (apgsid != null ? apgsid.hashCode() : 0);
        result = 31 * result + (alntype != null ? alntype.hashCode() : 0);
        result = 31 * result + (aprocyr != null ? aprocyr.hashCode() : 0);
        result = 31 * result + (aschcode != null ? aschcode.hashCode() : 0);
        result = 31 * result + (aseqno2 != null ? aseqno2.hashCode() : 0);
        result = 31 * result + (unused1 != null ? unused1.hashCode() : 0);
        result = 31 * result + (mpnstat != null ? mpnstat.hashCode() : 0);
        result = 31 * result + (mpnamt != null ? mpnamt.hashCode() : 0);
        result = 31 * result + (mpnid != null ? mpnid.hashCode() : 0);
        result = 31 * result + (mpnrqat != null ? mpnrqat.hashCode() : 0);
        result = 31 * result + (change1 != null ? change1.hashCode() : 0);
        result = 31 * result + (change2 != null ? change2.hashCode() : 0);
        result = 31 * result + (change3 != null ? change3.hashCode() : 0);
        result = 31 * result + (snamel != null ? snamel.hashCode() : 0);
        result = 31 * result + (snamef != null ? snamef.hashCode() : 0);
        result = 31 * result + (snamem != null ? snamem.hashCode() : 0);
        result = 31 * result + (snamel2 != null ? snamel2.hashCode() : 0);
        result = 31 * result + (snamef2 != null ? snamef2.hashCode() : 0);
        result = 31 * result + (snamem2 != null ? snamem2.hashCode() : 0);
        result = 31 * result + (snamel3 != null ? snamel3.hashCode() : 0);
        result = 31 * result + (snamef3 != null ? snamef3.hashCode() : 0);
        result = 31 * result + (snamem3 != null ? snamem3.hashCode() : 0);
        result = 31 * result + (pnamel2 != null ? pnamel2.hashCode() : 0);
        result = 31 * result + (pnamef2 != null ? pnamef2.hashCode() : 0);
        result = 31 * result + (pnamem2 != null ? pnamem2.hashCode() : 0);
        result = 31 * result + (pnamel3 != null ? pnamel3.hashCode() : 0);
        result = 31 * result + (pnamef3 != null ? pnamef3.hashCode() : 0);
        result = 31 * result + (pnamem3 != null ? pnamem3.hashCode() : 0);
        result = 31 * result + (laddr != null ? laddr.hashCode() : 0);
        result = 31 * result + (laddr2 != null ? laddr2.hashCode() : 0);
        result = 31 * result + (laddr3 != null ? laddr3.hashCode() : 0);
        result = 31 * result + (paddr != null ? paddr.hashCode() : 0);
        result = 31 * result + (paddr2 != null ? paddr2.hashCode() : 0);
        result = 31 * result + (padr2 != null ? padr2.hashCode() : 0);
        result = 31 * result + (padr22 != null ? padr22.hashCode() : 0);
        result = 31 * result + (padr3 != null ? padr3.hashCode() : 0);
        result = 31 * result + (padr23 != null ? padr23.hashCode() : 0);
        result = 31 * result + (promtyp != null ? promtyp.hashCode() : 0);
        result = 31 * result + (borind != null ? borind.hashCode() : 0);
        result = 31 * result + (borind2 != null ? borind2.hashCode() : 0);
        result = 31 * result + (borind3 != null ? borind3.hashCode() : 0);
        result = 31 * result + (pgmtcd != null ? pgmtcd.hashCode() : 0);
        result = 31 * result + (pgmtcd2 != null ? pgmtcd2.hashCode() : 0);
        result = 31 * result + (pgmtcd3 != null ? pgmtcd3.hashCode() : 0);
        result = 31 * result + (tbdebt != null ? tbdebt.hashCode() : 0);
        result = 31 * result + (tbdebt2 != null ? tbdebt2.hashCode() : 0);
        result = 31 * result + (tbdebt3 != null ? tbdebt3.hashCode() : 0);
        result = 31 * result + (feespd != null ? feespd.hashCode() : 0);
        result = 31 * result + (adtype != null ? adtype.hashCode() : 0);
        result = 31 * result + (psntyp != null ? psntyp.hashCode() : 0);
        result = 31 * result + (pgtrnnr != null ? pgtrnnr.hashCode() : 0);
        result = 31 * result + (docido != null ? docido.hashCode() : 0);
        result = 31 * result + (docidc != null ? docidc.hashCode() : 0);
        result = 31 * result + (instn != null ? instn.hashCode() : 0);
        result = 31 * result + (ainstn != null ? ainstn.hashCode() : 0);
        result = 31 * result + (rinstn != null ? rinstn.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (aaccal != null ? aaccal.hashCode() : 0);
        result = 31 * result + (raccal != null ? raccal.hashCode() : 0);
        result = 31 * result + (pmeth != null ? pmeth.hashCode() : 0);
        result = 31 * result + (apmeth != null ? apmeth.hashCode() : 0);
        result = 31 * result + (rpmeth != null ? rpmeth.hashCode() : 0);
        result = 31 * result + (wicp != null ? wicp.hashCode() : 0);
        result = 31 * result + (awicp != null ? awicp.hashCode() : 0);
        result = 31 * result + (rwicp != null ? rwicp.hashCode() : 0);
        result = 31 * result + (wpacy != null ? wpacy.hashCode() : 0);
        result = 31 * result + (awpacy != null ? awpacy.hashCode() : 0);
        result = 31 * result + (rwpacy != null ? rwpacy.hashCode() : 0);
        result = 31 * result + pgawdch;
        result = 31 * result + apgawch;
        result = 31 * result + rpgawch;
        result = 31 * result + pgacch;
        result = 31 * result + apgacch;
        result = 31 * result + rpgacch;
        result = 31 * result + (ltuit != null ? ltuit.hashCode() : 0);
        result = 31 * result + (altuit != null ? altuit.hashCode() : 0);
        result = 31 * result + (rltuit != null ? rltuit.hashCode() : 0);
        result = 31 * result + (incar != null ? incar.hashCode() : 0);
        result = 31 * result + (aincar != null ? aincar.hashCode() : 0);
        result = 31 * result + (pgvalst != null ? pgvalst.hashCode() : 0);
        result = 31 * result + (apvalst != null ? apvalst.hashCode() : 0);
        result = 31 * result + (sefefcf != null ? sefefcf.hashCode() : 0);
        result = 31 * result + (asefcf != null ? asefcf.hashCode() : 0);
        result = 31 * result + beogbud;
        result = 31 * result + acoa;
        result = 31 * result + (ngpamt != null ? ngpamt.hashCode() : 0);
        result = 31 * result + (popflag != null ? popflag.hashCode() : 0);
        result = 31 * result + (delcode != null ? delcode.hashCode() : 0);
        result = 31 * result + (endramt != null ? endramt.hashCode() : 0);
        result = 31 * result + (ytdamt != null ? ytdamt.hashCode() : 0);
        result = 31 * result + (schpell != null ? schpell.hashCode() : 0);
        result = 31 * result + (telgusd != null ? telgusd.hashCode() : 0);
        result = 31 * result + (sfaind != null ? sfaind.hashCode() : 0);
        result = 31 * result + (defreq != null ? defreq.hashCode() : 0);
        result = 31 * result + (borint != null ? borint.hashCode() : 0);
        result = 31 * result + (eftath != null ? eftath.hashCode() : 0);
        result = 31 * result + (outsln != null ? outsln.hashCode() : 0);
        result = 31 * result + (guardt != null ? guardt.hashCode() : 0);
        result = 31 * result + (pgvalvi != null ? pgvalvi.hashCode() : 0);
        result = 31 * result + (pgtrnhi != null ? pgtrnhi.hashCode() : 0);
        result = 31 * result + (credtm != null ? credtm.hashCode() : 0);
        result = 31 * result + (frspcd != null ? frspcd.hashCode() : 0);
        result = 31 * result + (error1 != null ? error1.hashCode() : 0);
        result = 31 * result + (error2 != null ? error2.hashCode() : 0);
        result = 31 * result + (error3 != null ? error3.hashCode() : 0);
        result = 31 * result + (error4 != null ? error4.hashCode() : 0);
        result = 31 * result + (error5 != null ? error5.hashCode() : 0);
        result = 31 * result + (error6 != null ? error6.hashCode() : 0);
        result = 31 * result + (error7 != null ? error7.hashCode() : 0);
        result = 31 * result + (error8 != null ? error8.hashCode() : 0);
        result = 31 * result + (error9 != null ? error9.hashCode() : 0);
        result = 31 * result + (errora != null ? errora.hashCode() : 0);
        result = 31 * result + (acdpgm != null ? acdpgm.hashCode() : 0);
        result = 31 * result + (lendnm != null ? lendnm.hashCode() : 0);
        result = 31 * result + (guarnm != null ? guarnm.hashCode() : 0);
        result = 31 * result + (amtapp0 != null ? amtapp0.hashCode() : 0);
        result = 31 * result + (reqln0 != null ? reqln0.hashCode() : 0);
        result = 31 * result + (perbeg0 != null ? perbeg0.hashCode() : 0);
        result = 31 * result + (perend0 != null ? perend0.hashCode() : 0);
        result = 31 * result + (depsts != null ? depsts.hashCode() : 0);
        result = 31 * result + (classs != null ? classs.hashCode() : 0);
        result = 31 * result + (senrss != null ? senrss.hashCode() : 0);
        result = 31 * result + (senrds != null ? senrds.hashCode() : 0);
        result = 31 * result + (deflts != null ? deflts.hashCode() : 0);
        result = 31 * result + (pdflts != null ? pdflts.hashCode() : 0);
        result = 31 * result + (prodts != null ? prodts.hashCode() : 0);
        result = 31 * result + (strdts != null ? strdts.hashCode() : 0);
        result = 31 * result + (enddts != null ? enddts.hashCode() : 0);
        result = 31 * result + (perbes != null ? perbes.hashCode() : 0);
        result = 31 * result + (perens != null ? perens.hashCode() : 0);
        result = 31 * result + (lcancs != null ? lcancs.hashCode() : 0);
        result = 31 * result + (lcands != null ? lcands.hashCode() : 0);
        result = 31 * result + (amtaps != null ? amtaps.hashCode() : 0);
        result = 31 * result + (reqlns != null ? reqlns.hashCode() : 0);
        result = 31 * result + (pnprts != null ? pnprts.hashCode() : 0);
        result = 31 * result + (pninds != null ? pninds.hashCode() : 0);
        result = 31 * result + (ltuits != null ? ltuits.hashCode() : 0);
        result = 31 * result + (incars != null ? incars.hashCode() : 0);
        result = 31 * result + (valsts != null ? valsts.hashCode() : 0);
        result = 31 * result + (sefcs != null ? sefcs.hashCode() : 0);
        result = 31 * result + (coas != null ? coas.hashCode() : 0);
        result = 31 * result + (cpsncd != null ? cpsncd.hashCode() : 0);
        result = 31 * result + (pellelg != null ? pellelg.hashCode() : 0);
        result = 31 * result + (pmnid != null ? pmnid.hashCode() : 0);
        result = 31 * result + (tpelgus != null ? tpelgus.hashCode() : 0);
        result = 31 * result + (tchexpi != null ? tchexpi.hashCode() : 0);
        result = 31 * result + (adelin != null ? adelin.hashCode() : 0);
        result = 31 * result + (cncmdt != null ? cncmdt.hashCode() : 0);
        result = 31 * result + (lrrdte != null ? lrrdte.hashCode() : 0);
        result = 31 * result + (apcmpdt != null ? apcmpdt.hashCode() : 0);
        result = 31 * result + (crbalop != null ? crbalop.hashCode() : 0);
        result = 31 * result + (cractch != null ? cractch.hashCode() : 0);
        result = 31 * result + (crappls != null ? crappls.hashCode() : 0);
        result = 31 * result + (mxlnamt != null ? mxlnamt.hashCode() : 0);
        result = 31 * result + (crdcexd != null ? crdcexd.hashCode() : 0);
        result = 31 * result + (ocrdcst != null ? ocrdcst.hashCode() : 0);
        result = 31 * result + (defopt != null ? defopt.hashCode() : 0);
        result = 31 * result + (ltelgus != null ? ltelgus.hashCode() : 0);
        result = 31 * result + (crdecst != null ? crdecst.hashCode() : 0);
        result = 31 * result + (servid != null ? servid.hashCode() : 0);
        result = 31 * result + (grelgo != null ? grelgo.hashCode() : 0);
        return result;
    }
}
