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
 * Date: 11/26/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SAM", schema = "SIGMA", catalog = "")
@Entity
public class SamEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSamkey();
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

    private String samkey;

    @javax.persistence.Column(name = "SAMKEY")
    @Id
    public String getSamkey() {
        return samkey;
    }

    public void setSamkey(String samkey) {
        this.samkey = samkey;
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

    private String ecampus;

    @javax.persistence.Column(name = "ECAMPUS")
    @Basic
    public String getEcampus() {
        return ecampus;
    }

    public void setEcampus(String ecampus) {
        this.ecampus = ecampus;
    }

    private String depstf;

    @javax.persistence.Column(name = "DEPSTF")
    @Basic
    public String getDepstf() {
        return depstf;
    }

    public void setDepstf(String depstf) {
        this.depstf = depstf;
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

    private String depsti;

    @javax.persistence.Column(name = "DEPSTI")
    @Basic
    public String getDepsti() {
        return depsti;
    }

    public void setDepsti(String depsti) {
        this.depsti = depsti;
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

    private String pdegree;

    @javax.persistence.Column(name = "PDEGREE")
    @Basic
    public String getPdegree() {
        return pdegree;
    }

    public void setPdegree(String pdegree) {
        this.pdegree = pdegree;
    }

    private String pdeg;

    @javax.persistence.Column(name = "PDEG")
    @Basic
    public String getPdeg() {
        return pdeg;
    }

    public void setPdeg(String pdeg) {
        this.pdeg = pdeg;
    }

    private String pacdlvl;

    @javax.persistence.Column(name = "PACDLVL")
    @Basic
    public String getPacdlvl() {
        return pacdlvl;
    }

    public void setPacdlvl(String pacdlvl) {
        this.pacdlvl = pacdlvl;
    }

    private BigInteger ssizehs;

    @javax.persistence.Column(name = "SSIZEHS")
    @Basic
    public BigInteger getSsizehs() {
        return ssizehs;
    }

    public void setSsizehs(BigInteger ssizehs) {
        this.ssizehs = ssizehs;
    }

    private BigInteger psizehs;

    @javax.persistence.Column(name = "PSIZEHS")
    @Basic
    public BigInteger getPsizehs() {
        return psizehs;
    }

    public void setPsizehs(BigInteger psizehs) {
        this.psizehs = psizehs;
    }

    private String shsetyp;

    @javax.persistence.Column(name = "SHSETYP")
    @Basic
    public String getShsetyp() {
        return shsetyp;
    }

    public void setShsetyp(String shsetyp) {
        this.shsetyp = shsetyp;
    }

    private String procno;

    @javax.persistence.Column(name = "PROCNO")
    @Basic
    public String getProcno() {
        return procno;
    }

    public void setProcno(String procno) {
        this.procno = procno;
    }

    private String snatype;

    @javax.persistence.Column(name = "SNATYPE")
    @Basic
    public String getSnatype() {
        return snatype;
    }

    public void setSnatype(String snatype) {
        this.snatype = snatype;
    }

    private String athlet1;

    @javax.persistence.Column(name = "ATHLET1")
    @Basic
    public String getAthlet1() {
        return athlet1;
    }

    public void setAthlet1(String athlet1) {
        this.athlet1 = athlet1;
    }

    private String athlet2;

    @javax.persistence.Column(name = "ATHLET2")
    @Basic
    public String getAthlet2() {
        return athlet2;
    }

    public void setAthlet2(String athlet2) {
        this.athlet2 = athlet2;
    }

    private String currfst;

    @javax.persistence.Column(name = "CURRFST")
    @Basic
    public String getCurrfst() {
        return currfst;
    }

    public void setCurrfst(String currfst) {
        this.currfst = currfst;
    }

    private String sphandl;

    @javax.persistence.Column(name = "SPHANDL")
    @Basic
    public String getSphandl() {
        return sphandl;
    }

    public void setSphandl(String sphandl) {
        this.sphandl = sphandl;
    }

    private String sptal1;

    @javax.persistence.Column(name = "SPTAL1")
    @Basic
    public String getSptal1() {
        return sptal1;
    }

    public void setSptal1(String sptal1) {
        this.sptal1 = sptal1;
    }

    private String sptal2;

    @javax.persistence.Column(name = "SPTAL2")
    @Basic
    public String getSptal2() {
        return sptal2;
    }

    public void setSptal2(String sptal2) {
        this.sptal2 = sptal2;
    }

    private String sptal3;

    @javax.persistence.Column(name = "SPTAL3")
    @Basic
    public String getSptal3() {
        return sptal3;
    }

    public void setSptal3(String sptal3) {
        this.sptal3 = sptal3;
    }

    private String sptal4;

    @javax.persistence.Column(name = "SPTAL4")
    @Basic
    public String getSptal4() {
        return sptal4;
    }

    public void setSptal4(String sptal4) {
        this.sptal4 = sptal4;
    }

    private String packgrp;

    @javax.persistence.Column(name = "PACKGRP")
    @Basic
    public String getPackgrp() {
        return packgrp;
    }

    public void setPackgrp(String packgrp) {
        this.packgrp = packgrp;
    }

    private String penrlt1;

    @javax.persistence.Column(name = "PENRLT1")
    @Basic
    public String getPenrlt1() {
        return penrlt1;
    }

    public void setPenrlt1(String penrlt1) {
        this.penrlt1 = penrlt1;
    }

    private String penrlt2;

    @javax.persistence.Column(name = "PENRLT2")
    @Basic
    public String getPenrlt2() {
        return penrlt2;
    }

    public void setPenrlt2(String penrlt2) {
        this.penrlt2 = penrlt2;
    }

    private String penrlt3;

    @javax.persistence.Column(name = "PENRLT3")
    @Basic
    public String getPenrlt3() {
        return penrlt3;
    }

    public void setPenrlt3(String penrlt3) {
        this.penrlt3 = penrlt3;
    }

    private String penrlt4;

    @javax.persistence.Column(name = "PENRLT4")
    @Basic
    public String getPenrlt4() {
        return penrlt4;
    }

    public void setPenrlt4(String penrlt4) {
        this.penrlt4 = penrlt4;
    }

    private String penrlt5;

    @javax.persistence.Column(name = "PENRLT5")
    @Basic
    public String getPenrlt5() {
        return penrlt5;
    }

    public void setPenrlt5(String penrlt5) {
        this.penrlt5 = penrlt5;
    }

    private String penrlt6;

    @javax.persistence.Column(name = "PENRLT6")
    @Basic
    public String getPenrlt6() {
        return penrlt6;
    }

    public void setPenrlt6(String penrlt6) {
        this.penrlt6 = penrlt6;
    }

    private String aenrlt1;

    @javax.persistence.Column(name = "AENRLT1")
    @Basic
    public String getAenrlt1() {
        return aenrlt1;
    }

    public void setAenrlt1(String aenrlt1) {
        this.aenrlt1 = aenrlt1;
    }

    private String aenrlt2;

    @javax.persistence.Column(name = "AENRLT2")
    @Basic
    public String getAenrlt2() {
        return aenrlt2;
    }

    public void setAenrlt2(String aenrlt2) {
        this.aenrlt2 = aenrlt2;
    }

    private String aenrlt3;

    @javax.persistence.Column(name = "AENRLT3")
    @Basic
    public String getAenrlt3() {
        return aenrlt3;
    }

    public void setAenrlt3(String aenrlt3) {
        this.aenrlt3 = aenrlt3;
    }

    private String aenrlt4;

    @javax.persistence.Column(name = "AENRLT4")
    @Basic
    public String getAenrlt4() {
        return aenrlt4;
    }

    public void setAenrlt4(String aenrlt4) {
        this.aenrlt4 = aenrlt4;
    }

    private String aenrlt5;

    @javax.persistence.Column(name = "AENRLT5")
    @Basic
    public String getAenrlt5() {
        return aenrlt5;
    }

    public void setAenrlt5(String aenrlt5) {
        this.aenrlt5 = aenrlt5;
    }

    private String aenrlt6;

    @javax.persistence.Column(name = "AENRLT6")
    @Basic
    public String getAenrlt6() {
        return aenrlt6;
    }

    public void setAenrlt6(String aenrlt6) {
        this.aenrlt6 = aenrlt6;
    }

    private String estat;

    @javax.persistence.Column(name = "ESTAT")
    @Basic
    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    private String pstat;

    @javax.persistence.Column(name = "PSTAT")
    @Basic
    public String getPstat() {
        return pstat;
    }

    public void setPstat(String pstat) {
        this.pstat = pstat;
    }

    private String nstat;

    @javax.persistence.Column(name = "NSTAT")
    @Basic
    public String getNstat() {
        return nstat;
    }

    public void setNstat(String nstat) {
        this.nstat = nstat;
    }

    private String cstat;

    @javax.persistence.Column(name = "CSTAT")
    @Basic
    public String getCstat() {
        return cstat;
    }

    public void setCstat(String cstat) {
        this.cstat = cstat;
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

    private int sumsave;

    @javax.persistence.Column(name = "SUMSAVE")
    @Basic
    public int getSumsave() {
        return sumsave;
    }

    public void setSumsave(int sumsave) {
        this.sumsave = sumsave;
    }

    private int ntaxinc;

    @javax.persistence.Column(name = "NTAXINC")
    @Basic
    public int getNtaxinc() {
        return ntaxinc;
    }

    public void setNtaxinc(int ntaxinc) {
        this.ntaxinc = ntaxinc;
    }

    private int taxinc;

    @javax.persistence.Column(name = "TAXINC")
    @Basic
    public int getTaxinc() {
        return taxinc;
    }

    public void setTaxinc(int taxinc) {
        this.taxinc = taxinc;
    }

    private int nassets;

    @javax.persistence.Column(name = "NASSETS")
    @Basic
    public int getNassets() {
        return nassets;
    }

    public void setNassets(int nassets) {
        this.nassets = nassets;
    }

    private BigDecimal adjfact;

    @javax.persistence.Column(name = "ADJFACT")
    @Basic
    public BigDecimal getAdjfact() {
        return adjfact;
    }

    public void setAdjfact(BigDecimal adjfact) {
        this.adjfact = adjfact;
    }

    private int efc;

    @javax.persistence.Column(name = "EFC")
    @Basic
    public int getEfc() {
        return efc;
    }

    public void setEfc(int efc) {
        this.efc = efc;
    }

    private int pc;

    @javax.persistence.Column(name = "PC")
    @Basic
    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    private int sc;

    @javax.persistence.Column(name = "SC")
    @Basic
    public int getSc() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    private int sbudget;

    @javax.persistence.Column(name = "SBUDGET")
    @Basic
    public int getSbudget() {
        return sbudget;
    }

    public void setSbudget(int sbudget) {
        this.sbudget = sbudget;
    }

    private int overbud;

    @javax.persistence.Column(name = "OVERBUD")
    @Basic
    public int getOverbud() {
        return overbud;
    }

    public void setOverbud(int overbud) {
        this.overbud = overbud;
    }

    private int overpc;

    @javax.persistence.Column(name = "OVERPC")
    @Basic
    public int getOverpc() {
        return overpc;
    }

    public void setOverpc(int overpc) {
        this.overpc = overpc;
    }

    private int oversc;

    @javax.persistence.Column(name = "OVERSC")
    @Basic
    public int getOversc() {
        return oversc;
    }

    public void setOversc(int oversc) {
        this.oversc = oversc;
    }

    private String budtype;

    @javax.persistence.Column(name = "BUDTYPE")
    @Basic
    public String getBudtype() {
        return budtype;
    }

    public void setBudtype(String budtype) {
        this.budtype = budtype;
    }

    private String btype01;

    @javax.persistence.Column(name = "BTYPE01")
    @Basic
    public String getBtype01() {
        return btype01;
    }

    public void setBtype01(String btype01) {
        this.btype01 = btype01;
    }

    private String btype02;

    @javax.persistence.Column(name = "BTYPE02")
    @Basic
    public String getBtype02() {
        return btype02;
    }

    public void setBtype02(String btype02) {
        this.btype02 = btype02;
    }

    private String btype03;

    @javax.persistence.Column(name = "BTYPE03")
    @Basic
    public String getBtype03() {
        return btype03;
    }

    public void setBtype03(String btype03) {
        this.btype03 = btype03;
    }

    private String btype04;

    @javax.persistence.Column(name = "BTYPE04")
    @Basic
    public String getBtype04() {
        return btype04;
    }

    public void setBtype04(String btype04) {
        this.btype04 = btype04;
    }

    private String btype05;

    @javax.persistence.Column(name = "BTYPE05")
    @Basic
    public String getBtype05() {
        return btype05;
    }

    public void setBtype05(String btype05) {
        this.btype05 = btype05;
    }

    private String btype06;

    @javax.persistence.Column(name = "BTYPE06")
    @Basic
    public String getBtype06() {
        return btype06;
    }

    public void setBtype06(String btype06) {
        this.btype06 = btype06;
    }

    private String btype07;

    @javax.persistence.Column(name = "BTYPE07")
    @Basic
    public String getBtype07() {
        return btype07;
    }

    public void setBtype07(String btype07) {
        this.btype07 = btype07;
    }

    private String btype08;

    @javax.persistence.Column(name = "BTYPE08")
    @Basic
    public String getBtype08() {
        return btype08;
    }

    public void setBtype08(String btype08) {
        this.btype08 = btype08;
    }

    private String btype09;

    @javax.persistence.Column(name = "BTYPE09")
    @Basic
    public String getBtype09() {
        return btype09;
    }

    public void setBtype09(String btype09) {
        this.btype09 = btype09;
    }

    private String btype10;

    @javax.persistence.Column(name = "BTYPE10")
    @Basic
    public String getBtype10() {
        return btype10;
    }

    public void setBtype10(String btype10) {
        this.btype10 = btype10;
    }

    private int bud01;

    @javax.persistence.Column(name = "BUD01")
    @Basic
    public int getBud01() {
        return bud01;
    }

    public void setBud01(int bud01) {
        this.bud01 = bud01;
    }

    private int bud02;

    @javax.persistence.Column(name = "BUD02")
    @Basic
    public int getBud02() {
        return bud02;
    }

    public void setBud02(int bud02) {
        this.bud02 = bud02;
    }

    private int bud03;

    @javax.persistence.Column(name = "BUD03")
    @Basic
    public int getBud03() {
        return bud03;
    }

    public void setBud03(int bud03) {
        this.bud03 = bud03;
    }

    private int bud04;

    @javax.persistence.Column(name = "BUD04")
    @Basic
    public int getBud04() {
        return bud04;
    }

    public void setBud04(int bud04) {
        this.bud04 = bud04;
    }

    private int bud05;

    @javax.persistence.Column(name = "BUD05")
    @Basic
    public int getBud05() {
        return bud05;
    }

    public void setBud05(int bud05) {
        this.bud05 = bud05;
    }

    private int bud06;

    @javax.persistence.Column(name = "BUD06")
    @Basic
    public int getBud06() {
        return bud06;
    }

    public void setBud06(int bud06) {
        this.bud06 = bud06;
    }

    private int bud07;

    @javax.persistence.Column(name = "BUD07")
    @Basic
    public int getBud07() {
        return bud07;
    }

    public void setBud07(int bud07) {
        this.bud07 = bud07;
    }

    private int bud08;

    @javax.persistence.Column(name = "BUD08")
    @Basic
    public int getBud08() {
        return bud08;
    }

    public void setBud08(int bud08) {
        this.bud08 = bud08;
    }

    private int bud09;

    @javax.persistence.Column(name = "BUD09")
    @Basic
    public int getBud09() {
        return bud09;
    }

    public void setBud09(int bud09) {
        this.bud09 = bud09;
    }

    private int bud10;

    @javax.persistence.Column(name = "BUD10")
    @Basic
    public int getBud10() {
        return bud10;
    }

    public void setBud10(int bud10) {
        this.bud10 = bud10;
    }

    private int groneed;

    @javax.persistence.Column(name = "GRONEED")
    @Basic
    public int getGroneed() {
        return groneed;
    }

    public void setGroneed(int groneed) {
        this.groneed = groneed;
    }

    private BigDecimal netneed;

    @javax.persistence.Column(name = "NETNEED")
    @Basic
    public BigDecimal getNetneed() {
        return netneed;
    }

    public void setNetneed(BigDecimal netneed) {
        this.netneed = netneed;
    }

    private BigDecimal unneed;

    @javax.persistence.Column(name = "UNNEED")
    @Basic
    public BigDecimal getUnneed() {
        return unneed;
    }

    public void setUnneed(BigDecimal unneed) {
        this.unneed = unneed;
    }

    private BigDecimal taid;

    @javax.persistence.Column(name = "TAID")
    @Basic
    public BigDecimal getTaid() {
        return taid;
    }

    public void setTaid(BigDecimal taid) {
        this.taid = taid;
    }

    private BigDecimal taidor;

    @javax.persistence.Column(name = "TAIDOR")
    @Basic
    public BigDecimal getTaidor() {
        return taidor;
    }

    public void setTaidor(BigDecimal taidor) {
        this.taidor = taidor;
    }

    private BigDecimal taidcb;

    @javax.persistence.Column(name = "TAIDCB")
    @Basic
    public BigDecimal getTaidcb() {
        return taidcb;
    }

    public void setTaidcb(BigDecimal taidcb) {
        this.taidcb = taidcb;
    }

    private int ebeogi;

    @javax.persistence.Column(name = "EBEOGI")
    @Basic
    public int getEbeogi() {
        return ebeogi;
    }

    public void setEbeogi(int ebeogi) {
        this.ebeogi = ebeogi;
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

    private int beogbud;

    @javax.persistence.Column(name = "BEOGBUD")
    @Basic
    public int getBeogbud() {
        return beogbud;
    }

    public void setBeogbud(int beogbud) {
        this.beogbud = beogbud;
    }

    private int ovrbeog;

    @javax.persistence.Column(name = "OVRBEOG")
    @Basic
    public int getOvrbeog() {
        return ovrbeog;
    }

    public void setOvrbeog(int ovrbeog) {
        this.ovrbeog = ovrbeog;
    }

    private int beogsch;

    @javax.persistence.Column(name = "BEOGSCH")
    @Basic
    public int getBeogsch() {
        return beogsch;
    }

    public void setBeogsch(int beogsch) {
        this.beogsch = beogsch;
    }

    private int beogexp;

    @javax.persistence.Column(name = "BEOGEXP")
    @Basic
    public int getBeogexp() {
        return beogexp;
    }

    public void setBeogexp(int beogexp) {
        this.beogexp = beogexp;
    }

    private String beogflg;

    @javax.persistence.Column(name = "BEOGFLG")
    @Basic
    public String getBeogflg() {
        return beogflg;
    }

    public void setBeogflg(String beogflg) {
        this.beogflg = beogflg;
    }

    private String userflg;

    @javax.persistence.Column(name = "USERFLG")
    @Basic
    public String getUserflg() {
        return userflg;
    }

    public void setUserflg(String userflg) {
        this.userflg = userflg;
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

    private String hold01;

    @javax.persistence.Column(name = "HOLD01")
    @Basic
    public String getHold01() {
        return hold01;
    }

    public void setHold01(String hold01) {
        this.hold01 = hold01;
    }

    private String hold02;

    @javax.persistence.Column(name = "HOLD02")
    @Basic
    public String getHold02() {
        return hold02;
    }

    public void setHold02(String hold02) {
        this.hold02 = hold02;
    }

    private String hold03;

    @javax.persistence.Column(name = "HOLD03")
    @Basic
    public String getHold03() {
        return hold03;
    }

    public void setHold03(String hold03) {
        this.hold03 = hold03;
    }

    private String hold04;

    @javax.persistence.Column(name = "HOLD04")
    @Basic
    public String getHold04() {
        return hold04;
    }

    public void setHold04(String hold04) {
        this.hold04 = hold04;
    }

    private String hold05;

    @javax.persistence.Column(name = "HOLD05")
    @Basic
    public String getHold05() {
        return hold05;
    }

    public void setHold05(String hold05) {
        this.hold05 = hold05;
    }

    private String hold06;

    @javax.persistence.Column(name = "HOLD06")
    @Basic
    public String getHold06() {
        return hold06;
    }

    public void setHold06(String hold06) {
        this.hold06 = hold06;
    }

    private int elgamt;

    @javax.persistence.Column(name = "ELGAMT")
    @Basic
    public int getElgamt() {
        return elgamt;
    }

    public void setElgamt(int elgamt) {
        this.elgamt = elgamt;
    }

    private int reqamt;

    @javax.persistence.Column(name = "REQAMT")
    @Basic
    public int getReqamt() {
        return reqamt;
    }

    public void setReqamt(int reqamt) {
        this.reqamt = reqamt;
    }

    private String agncysp;

    @javax.persistence.Column(name = "AGNCYSP")
    @Basic
    public String getAgncysp() {
        return agncysp;
    }

    public void setAgncysp(String agncysp) {
        this.agncysp = agncysp;
    }

    private String evalclr;

    @javax.persistence.Column(name = "EVALCLR")
    @Basic
    public String getEvalclr() {
        return evalclr;
    }

    public void setEvalclr(String evalclr) {
        this.evalclr = evalclr;
    }

    private int totsat;

    @javax.persistence.Column(name = "TOTSAT")
    @Basic
    public int getTotsat() {
        return totsat;
    }

    public void setTotsat(int totsat) {
        this.totsat = totsat;
    }

    private int totach;

    @javax.persistence.Column(name = "TOTACH")
    @Basic
    public int getTotach() {
        return totach;
    }

    public void setTotach(int totach) {
        this.totach = totach;
    }

    private String chgdawd;

    @javax.persistence.Column(name = "CHGDAWD")
    @Basic
    public String getChgdawd() {
        return chgdawd;
    }

    public void setChgdawd(String chgdawd) {
        this.chgdawd = chgdawd;
    }

    private int punneed;

    @javax.persistence.Column(name = "PUNNEED")
    @Basic
    public int getPunneed() {
        return punneed;
    }

    public void setPunneed(int punneed) {
        this.punneed = punneed;
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

    private String pgprst;

    @javax.persistence.Column(name = "PGPRST")
    @Basic
    public String getPgprst() {
        return pgprst;
    }

    public void setPgprst(String pgprst) {
        this.pgprst = pgprst;
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

    private int gslagi;

    @javax.persistence.Column(name = "GSLAGI")
    @Basic
    public int getGslagi() {
        return gslagi;
    }

    public void setGslagi(int gslagi) {
        this.gslagi = gslagi;
    }

    private int frepagi;

    @javax.persistence.Column(name = "FREPAGI")
    @Basic
    public int getFrepagi() {
        return frepagi;
    }

    public void setFrepagi(int frepagi) {
        this.frepagi = frepagi;
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

    private int gslbud;

    @javax.persistence.Column(name = "GSLBUD")
    @Basic
    public int getGslbud() {
        return gslbud;
    }

    public void setGslbud(int gslbud) {
        this.gslbud = gslbud;
    }

    private int overgsl;

    @javax.persistence.Column(name = "OVERGSL")
    @Basic
    public int getOvergsl() {
        return overgsl;
    }

    public void setOvergsl(int overgsl) {
        this.overgsl = overgsl;
    }

    private String incflag;

    @javax.persistence.Column(name = "INCFLAG")
    @Basic
    public String getIncflag() {
        return incflag;
    }

    public void setIncflag(String incflag) {
        this.incflag = incflag;
    }

    private int saiadj;

    @javax.persistence.Column(name = "SAIADJ")
    @Basic
    public int getSaiadj() {
        return saiadj;
    }

    public void setSaiadj(int saiadj) {
        this.saiadj = saiadj;
    }

    private String faasai;

    @javax.persistence.Column(name = "FAASAI")
    @Basic
    public String getFaasai() {
        return faasai;
    }

    public void setFaasai(String faasai) {
        this.faasai = faasai;
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

    private int padjgro;

    @javax.persistence.Column(name = "PADJGRO")
    @Basic
    public int getPadjgro() {
        return padjgro;
    }

    public void setPadjgro(int padjgro) {
        this.padjgro = padjgro;
    }

    private int estpc;

    @javax.persistence.Column(name = "ESTPC")
    @Basic
    public int getEstpc() {
        return estpc;
    }

    public void setEstpc(int estpc) {
        this.estpc = estpc;
    }

    private int estsc;

    @javax.persistence.Column(name = "ESTSC")
    @Basic
    public int getEstsc() {
        return estsc;
    }

    public void setEstsc(int estsc) {
        this.estsc = estsc;
    }

    private int estefc;

    @javax.persistence.Column(name = "ESTEFC")
    @Basic
    public int getEstefc() {
        return estefc;
    }

    public void setEstefc(int estefc) {
        this.estefc = estefc;
    }

    private BigInteger enrlgh;

    @javax.persistence.Column(name = "ENRLGH")
    @Basic
    public BigInteger getEnrlgh() {
        return enrlgh;
    }

    public void setEnrlgh(BigInteger enrlgh) {
        this.enrlgh = enrlgh;
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

    private String sincar;

    @javax.persistence.Column(name = "SINCAR")
    @Basic
    public String getSincar() {
        return sincar;
    }

    public void setSincar(String sincar) {
        this.sincar = sincar;
    }

    private String class1;

    @javax.persistence.Column(name = "CLASS1")
    @Basic
    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
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

    private String class4;

    @javax.persistence.Column(name = "CLASS4")
    @Basic
    public String getClass4() {
        return class4;
    }

    public void setClass4(String class4) {
        this.class4 = class4;
    }

    private String class5;

    @javax.persistence.Column(name = "CLASS5")
    @Basic
    public String getClass5() {
        return class5;
    }

    public void setClass5(String class5) {
        this.class5 = class5;
    }

    private String class6;

    @javax.persistence.Column(name = "CLASS6")
    @Basic
    public String getClass6() {
        return class6;
    }

    public void setClass6(String class6) {
        this.class6 = class6;
    }

    private String pelflg;

    @javax.persistence.Column(name = "PELFLG")
    @Basic
    public String getPelflg() {
        return pelflg;
    }

    public void setPelflg(String pelflg) {
        this.pelflg = pelflg;
    }

    private String sumses1;

    @javax.persistence.Column(name = "SUMSES1")
    @Basic
    public String getSumses1() {
        return sumses1;
    }

    public void setSumses1(String sumses1) {
        this.sumses1 = sumses1;
    }

    private String sumses2;

    @javax.persistence.Column(name = "SUMSES2")
    @Basic
    public String getSumses2() {
        return sumses2;
    }

    public void setSumses2(String sumses2) {
        this.sumses2 = sumses2;
    }

    private String sumses3;

    @javax.persistence.Column(name = "SUMSES3")
    @Basic
    public String getSumses3() {
        return sumses3;
    }

    public void setSumses3(String sumses3) {
        this.sumses3 = sumses3;
    }

    private String sumses4;

    @javax.persistence.Column(name = "SUMSES4")
    @Basic
    public String getSumses4() {
        return sumses4;
    }

    public void setSumses4(String sumses4) {
        this.sumses4 = sumses4;
    }

    private String sumses5;

    @javax.persistence.Column(name = "SUMSES5")
    @Basic
    public String getSumses5() {
        return sumses5;
    }

    public void setSumses5(String sumses5) {
        this.sumses5 = sumses5;
    }

    private String sumses6;

    @javax.persistence.Column(name = "SUMSES6")
    @Basic
    public String getSumses6() {
        return sumses6;
    }

    public void setSumses6(String sumses6) {
        this.sumses6 = sumses6;
    }

    private String sumses7;

    @javax.persistence.Column(name = "SUMSES7")
    @Basic
    public String getSumses7() {
        return sumses7;
    }

    public void setSumses7(String sumses7) {
        this.sumses7 = sumses7;
    }

    private String sumses8;

    @javax.persistence.Column(name = "SUMSES8")
    @Basic
    public String getSumses8() {
        return sumses8;
    }

    public void setSumses8(String sumses8) {
        this.sumses8 = sumses8;
    }

    private String sumsesa;

    @javax.persistence.Column(name = "SUMSESA")
    @Basic
    public String getSumsesa() {
        return sumsesa;
    }

    public void setSumsesa(String sumsesa) {
        this.sumsesa = sumsesa;
    }

    private String sumsesb;

    @javax.persistence.Column(name = "SUMSESB")
    @Basic
    public String getSumsesb() {
        return sumsesb;
    }

    public void setSumsesb(String sumsesb) {
        this.sumsesb = sumsesb;
    }

    private String sumsesc;

    @javax.persistence.Column(name = "SUMSESC")
    @Basic
    public String getSumsesc() {
        return sumsesc;
    }

    public void setSumsesc(String sumsesc) {
        this.sumsesc = sumsesc;
    }

    private String sumsesd;

    @javax.persistence.Column(name = "SUMSESD")
    @Basic
    public String getSumsesd() {
        return sumsesd;
    }

    public void setSumsesd(String sumsesd) {
        this.sumsesd = sumsesd;
    }

    private String sumsese;

    @javax.persistence.Column(name = "SUMSESE")
    @Basic
    public String getSumsese() {
        return sumsese;
    }

    public void setSumsese(String sumsese) {
        this.sumsese = sumsese;
    }

    private String sumsesf;

    @javax.persistence.Column(name = "SUMSESF")
    @Basic
    public String getSumsesf() {
        return sumsesf;
    }

    public void setSumsesf(String sumsesf) {
        this.sumsesf = sumsesf;
    }

    private String sumsesg;

    @javax.persistence.Column(name = "SUMSESG")
    @Basic
    public String getSumsesg() {
        return sumsesg;
    }

    public void setSumsesg(String sumsesg) {
        this.sumsesg = sumsesg;
    }

    private String sumsesh;

    @javax.persistence.Column(name = "SUMSESH")
    @Basic
    public String getSumsesh() {
        return sumsesh;
    }

    public void setSumsesh(String sumsesh) {
        this.sumsesh = sumsesh;
    }

    private String unused9;

    @javax.persistence.Column(name = "UNUSED9")
    @Basic
    public String getUnused9() {
        return unused9;
    }

    public void setUnused9(String unused9) {
        this.unused9 = unused9;
    }

    private String acprog1;

    @javax.persistence.Column(name = "ACPROG1")
    @Basic
    public String getAcprog1() {
        return acprog1;
    }

    public void setAcprog1(String acprog1) {
        this.acprog1 = acprog1;
    }

    private String acprog2;

    @javax.persistence.Column(name = "ACPROG2")
    @Basic
    public String getAcprog2() {
        return acprog2;
    }

    public void setAcprog2(String acprog2) {
        this.acprog2 = acprog2;
    }

    private String acprog3;

    @javax.persistence.Column(name = "ACPROG3")
    @Basic
    public String getAcprog3() {
        return acprog3;
    }

    public void setAcprog3(String acprog3) {
        this.acprog3 = acprog3;
    }

    private String acprog4;

    @javax.persistence.Column(name = "ACPROG4")
    @Basic
    public String getAcprog4() {
        return acprog4;
    }

    public void setAcprog4(String acprog4) {
        this.acprog4 = acprog4;
    }

    private String acprog5;

    @javax.persistence.Column(name = "ACPROG5")
    @Basic
    public String getAcprog5() {
        return acprog5;
    }

    public void setAcprog5(String acprog5) {
        this.acprog5 = acprog5;
    }

    private String acprog6;

    @javax.persistence.Column(name = "ACPROG6")
    @Basic
    public String getAcprog6() {
        return acprog6;
    }

    public void setAcprog6(String acprog6) {
        this.acprog6 = acprog6;
    }

    private int tfcgsl;

    @javax.persistence.Column(name = "TFCGSL")
    @Basic
    public int getTfcgsl() {
        return tfcgsl;
    }

    public void setTfcgsl(int tfcgsl) {
        this.tfcgsl = tfcgsl;
    }

    private int ovrfpc;

    @javax.persistence.Column(name = "OVRFPC")
    @Basic
    public int getOvrfpc() {
        return ovrfpc;
    }

    public void setOvrfpc(int ovrfpc) {
        this.ovrfpc = ovrfpc;
    }

    private int fedpc;

    @javax.persistence.Column(name = "FEDPC")
    @Basic
    public int getFedpc() {
        return fedpc;
    }

    public void setFedpc(int fedpc) {
        this.fedpc = fedpc;
    }

    private int ovrfefc;

    @javax.persistence.Column(name = "OVRFEFC")
    @Basic
    public int getOvrfefc() {
        return ovrfefc;
    }

    public void setOvrfefc(int ovrfefc) {
        this.ovrfefc = ovrfefc;
    }

    private int fedefc;

    @javax.persistence.Column(name = "FEDEFC")
    @Basic
    public int getFedefc() {
        return fedefc;
    }

    public void setFedefc(int fedefc) {
        this.fedefc = fedefc;
    }

    private int stbud;

    @javax.persistence.Column(name = "STBUD")
    @Basic
    public int getStbud() {
        return stbud;
    }

    public void setStbud(int stbud) {
        this.stbud = stbud;
    }

    private int instpc;

    @javax.persistence.Column(name = "INSTPC")
    @Basic
    public int getInstpc() {
        return instpc;
    }

    public void setInstpc(int instpc) {
        this.instpc = instpc;
    }

    private int instsc;

    @javax.persistence.Column(name = "INSTSC")
    @Basic
    public int getInstsc() {
        return instsc;
    }

    public void setInstsc(int instsc) {
        this.instsc = instsc;
    }

    private int instefc;

    @javax.persistence.Column(name = "INSTEFC")
    @Basic
    public int getInstefc() {
        return instefc;
    }

    public void setInstefc(int instefc) {
        this.instefc = instefc;
    }

    private int statepc;

    @javax.persistence.Column(name = "STATEPC")
    @Basic
    public int getStatepc() {
        return statepc;
    }

    public void setStatepc(int statepc) {
        this.statepc = statepc;
    }

    private int statesc;

    @javax.persistence.Column(name = "STATESC")
    @Basic
    public int getStatesc() {
        return statesc;
    }

    public void setStatesc(int statesc) {
        this.statesc = statesc;
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

    private int stindex;

    @javax.persistence.Column(name = "STINDEX")
    @Basic
    public int getStindex() {
        return stindex;
    }

    public void setStindex(int stindex) {
        this.stindex = stindex;
    }

    private int sdrcost;

    @javax.persistence.Column(name = "SDRCOST")
    @Basic
    public int getSdrcost() {
        return sdrcost;
    }

    public void setSdrcost(int sdrcost) {
        this.sdrcost = sdrcost;
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

    private String time;

    @javax.persistence.Column(name = "TIME")
    @Basic
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    private String ucode;

    @javax.persistence.Column(name = "UCODE")
    @Basic
    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
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

    private String aac;

    @javax.persistence.Column(name = "AAC")
    @Basic
    public String getAac() {
        return aac;
    }

    public void setAac(String aac) {
        this.aac = aac;
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

    private String fafdtec;

    @javax.persistence.Column(name = "FAFDTEC")
    @Basic
    public String getFafdtec() {
        return fafdtec;
    }

    public void setFafdtec(String fafdtec) {
        this.fafdtec = fafdtec;
    }

    private String needtec;

    @javax.persistence.Column(name = "NEEDTEC")
    @Basic
    public String getNeedtec() {
        return needtec;
    }

    public void setNeedtec(String needtec) {
        this.needtec = needtec;
    }

    private String evldtec;

    @javax.persistence.Column(name = "EVLDTEC")
    @Basic
    public String getEvldtec() {
        return evldtec;
    }

    public void setEvldtec(String evldtec) {
        this.evldtec = evldtec;
    }

    private String pckdtec;

    @javax.persistence.Column(name = "PCKDTEC")
    @Basic
    public String getPckdtec() {
        return pckdtec;
    }

    public void setPckdtec(String pckdtec) {
        this.pckdtec = pckdtec;
    }

    private String notdtec;

    @javax.persistence.Column(name = "NOTDTEC")
    @Basic
    public String getNotdtec() {
        return notdtec;
    }

    public void setNotdtec(String notdtec) {
        this.notdtec = notdtec;
    }

    private String acpdtec;

    @javax.persistence.Column(name = "ACPDTEC")
    @Basic
    public String getAcpdtec() {
        return acpdtec;
    }

    public void setAcpdtec(String acpdtec) {
        this.acpdtec = acpdtec;
    }

    private String comdtec;

    @javax.persistence.Column(name = "COMDTEC")
    @Basic
    public String getComdtec() {
        return comdtec;
    }

    public void setComdtec(String comdtec) {
        this.comdtec = comdtec;
    }

    private String disdtec;

    @javax.persistence.Column(name = "DISDTEC")
    @Basic
    public String getDisdtec() {
        return disdtec;
    }

    public void setDisdtec(String disdtec) {
        this.disdtec = disdtec;
    }

    private String irsreqc;

    @javax.persistence.Column(name = "IRSREQC")
    @Basic
    public String getIrsreqc() {
        return irsreqc;
    }

    public void setIrsreqc(String irsreqc) {
        this.irsreqc = irsreqc;
    }

    private String irsverc;

    @javax.persistence.Column(name = "IRSVERC")
    @Basic
    public String getIrsverc() {
        return irsverc;
    }

    public void setIrsverc(String irsverc) {
        this.irsverc = irsverc;
    }

    private String lcode01;

    @javax.persistence.Column(name = "LCODE01")
    @Basic
    public String getLcode01() {
        return lcode01;
    }

    public void setLcode01(String lcode01) {
        this.lcode01 = lcode01;
    }

    private String ldate1C;

    @javax.persistence.Column(name = "LDATE1C")
    @Basic
    public String getLdate1C() {
        return ldate1C;
    }

    public void setLdate1C(String ldate1C) {
        this.ldate1C = ldate1C;
    }

    private String lcode02;

    @javax.persistence.Column(name = "LCODE02")
    @Basic
    public String getLcode02() {
        return lcode02;
    }

    public void setLcode02(String lcode02) {
        this.lcode02 = lcode02;
    }

    private String ldate2C;

    @javax.persistence.Column(name = "LDATE2C")
    @Basic
    public String getLdate2C() {
        return ldate2C;
    }

    public void setLdate2C(String ldate2C) {
        this.ldate2C = ldate2C;
    }

    private String lcode03;

    @javax.persistence.Column(name = "LCODE03")
    @Basic
    public String getLcode03() {
        return lcode03;
    }

    public void setLcode03(String lcode03) {
        this.lcode03 = lcode03;
    }

    private String ldate3C;

    @javax.persistence.Column(name = "LDATE3C")
    @Basic
    public String getLdate3C() {
        return ldate3C;
    }

    public void setLdate3C(String ldate3C) {
        this.ldate3C = ldate3C;
    }

    private String lcode04;

    @javax.persistence.Column(name = "LCODE04")
    @Basic
    public String getLcode04() {
        return lcode04;
    }

    public void setLcode04(String lcode04) {
        this.lcode04 = lcode04;
    }

    private String ldate4C;

    @javax.persistence.Column(name = "LDATE4C")
    @Basic
    public String getLdate4C() {
        return ldate4C;
    }

    public void setLdate4C(String ldate4C) {
        this.ldate4C = ldate4C;
    }

    private String lcode05;

    @javax.persistence.Column(name = "LCODE05")
    @Basic
    public String getLcode05() {
        return lcode05;
    }

    public void setLcode05(String lcode05) {
        this.lcode05 = lcode05;
    }

    private String ldate5C;

    @javax.persistence.Column(name = "LDATE5C")
    @Basic
    public String getLdate5C() {
        return ldate5C;
    }

    public void setLdate5C(String ldate5C) {
        this.ldate5C = ldate5C;
    }

    private String lcode06;

    @javax.persistence.Column(name = "LCODE06")
    @Basic
    public String getLcode06() {
        return lcode06;
    }

    public void setLcode06(String lcode06) {
        this.lcode06 = lcode06;
    }

    private String ldate6C;

    @javax.persistence.Column(name = "LDATE6C")
    @Basic
    public String getLdate6C() {
        return ldate6C;
    }

    public void setLdate6C(String ldate6C) {
        this.ldate6C = ldate6C;
    }

    private String lcode07;

    @javax.persistence.Column(name = "LCODE07")
    @Basic
    public String getLcode07() {
        return lcode07;
    }

    public void setLcode07(String lcode07) {
        this.lcode07 = lcode07;
    }

    private String ldate7C;

    @javax.persistence.Column(name = "LDATE7C")
    @Basic
    public String getLdate7C() {
        return ldate7C;
    }

    public void setLdate7C(String ldate7C) {
        this.ldate7C = ldate7C;
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

    private BigDecimal taidnb;

    @javax.persistence.Column(name = "TAIDNB")
    @Basic
    public BigDecimal getTaidnb() {
        return taidnb;
    }

    public void setTaidnb(BigDecimal taidnb) {
        this.taidnb = taidnb;
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

    private String tmrind;

    @javax.persistence.Column(name = "TMRIND")
    @Basic
    public String getTmrind() {
        return tmrind;
    }

    public void setTmrind(String tmrind) {
        this.tmrind = tmrind;
    }

    private int ldbnum;

    @javax.persistence.Column(name = "LDBNUM")
    @Basic
    public int getLdbnum() {
        return ldbnum;
    }

    public void setLdbnum(int ldbnum) {
        this.ldbnum = ldbnum;
    }

    private String cmajor;

    @javax.persistence.Column(name = "CMAJOR")
    @Basic
    public String getCmajor() {
        return cmajor;
    }

    public void setCmajor(String cmajor) {
        this.cmajor = cmajor;
    }

    private String eltrdte;

    @javax.persistence.Column(name = "ELTRDTE")
    @Basic
    public String getEltrdte() {
        return eltrdte;
    }

    public void setEltrdte(String eltrdte) {
        this.eltrdte = eltrdte;
    }

    private String eltrcod;

    @javax.persistence.Column(name = "ELTRCOD")
    @Basic
    public String getEltrcod() {
        return eltrcod;
    }

    public void setEltrcod(String eltrcod) {
        this.eltrcod = eltrcod;
    }

    private String eltrst;

    @javax.persistence.Column(name = "ELTRST")
    @Basic
    public String getEltrst() {
        return eltrst;
    }

    public void setEltrst(String eltrst) {
        this.eltrst = eltrst;
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

    private String enrtyp1;

    @javax.persistence.Column(name = "ENRTYP1")
    @Basic
    public String getEnrtyp1() {
        return enrtyp1;
    }

    public void setEnrtyp1(String enrtyp1) {
        this.enrtyp1 = enrtyp1;
    }

    private String enrtyp2;

    @javax.persistence.Column(name = "ENRTYP2")
    @Basic
    public String getEnrtyp2() {
        return enrtyp2;
    }

    public void setEnrtyp2(String enrtyp2) {
        this.enrtyp2 = enrtyp2;
    }

    private String enrtyp3;

    @javax.persistence.Column(name = "ENRTYP3")
    @Basic
    public String getEnrtyp3() {
        return enrtyp3;
    }

    public void setEnrtyp3(String enrtyp3) {
        this.enrtyp3 = enrtyp3;
    }

    private String enrtyp4;

    @javax.persistence.Column(name = "ENRTYP4")
    @Basic
    public String getEnrtyp4() {
        return enrtyp4;
    }

    public void setEnrtyp4(String enrtyp4) {
        this.enrtyp4 = enrtyp4;
    }

    private String enrtyp5;

    @javax.persistence.Column(name = "ENRTYP5")
    @Basic
    public String getEnrtyp5() {
        return enrtyp5;
    }

    public void setEnrtyp5(String enrtyp5) {
        this.enrtyp5 = enrtyp5;
    }

    private String enrtyp6;

    @javax.persistence.Column(name = "ENRTYP6")
    @Basic
    public String getEnrtyp6() {
        return enrtyp6;
    }

    public void setEnrtyp6(String enrtyp6) {
        this.enrtyp6 = enrtyp6;
    }

    private String except;

    @javax.persistence.Column(name = "EXCEPT")
    @Basic
    public String getExcept() {
        return except;
    }

    public void setExcept(String except) {
        this.except = except;
    }

    private String trmcon;

    @javax.persistence.Column(name = "TRMCON")
    @Basic
    public String getTrmcon() {
        return trmcon;
    }

    public void setTrmcon(String trmcon) {
        this.trmcon = trmcon;
    }

    private BigDecimal pryrgpa;

    @javax.persistence.Column(name = "PRYRGPA")
    @Basic
    public BigDecimal getPryrgpa() {
        return pryrgpa;
    }

    public void setPryrgpa(BigDecimal pryrgpa) {
        this.pryrgpa = pryrgpa;
    }

    private String admterm;

    @javax.persistence.Column(name = "ADMTERM")
    @Basic
    public String getAdmterm() {
        return admterm;
    }

    public void setAdmterm(String admterm) {
        this.admterm = admterm;
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

    private String acgelg;

    @javax.persistence.Column(name = "ACGELG")
    @Basic
    public String getAcgelg() {
        return acgelg;
    }

    public void setAcgelg(String acgelg) {
        this.acgelg = acgelg;
    }

    private String trmdtec;

    @javax.persistence.Column(name = "TRMDTEC")
    @Basic
    public String getTrmdtec() {
        return trmdtec;
    }

    public void setTrmdtec(String trmdtec) {
        this.trmdtec = trmdtec;
    }

    private int efcsrej;

    @javax.persistence.Column(name = "EFCSREJ")
    @Basic
    public int getEfcsrej() {
        return efcsrej;
    }

    public void setEfcsrej(int efcsrej) {
        this.efcsrej = efcsrej;
    }

    private String wspref;

    @javax.persistence.Column(name = "WSPREF")
    @Basic
    public String getWspref() {
        return wspref;
    }

    public void setWspref(String wspref) {
        this.wspref = wspref;
    }

    private BigDecimal workmax;

    @javax.persistence.Column(name = "WORKMAX")
    @Basic
    public BigDecimal getWorkmax() {
        return workmax;
    }

    public void setWorkmax(BigDecimal workmax) {
        this.workmax = workmax;
    }

    private String lisirup;

    @javax.persistence.Column(name = "LISIRUP")
    @Basic
    public String getLisirup() {
        return lisirup;
    }

    public void setLisirup(String lisirup) {
        this.lisirup = lisirup;
    }

    private int prscpe;

    @javax.persistence.Column(name = "PRSCPE")
    @Basic
    public int getPrscpe() {
        return prscpe;
    }

    public void setPrscpe(int prscpe) {
        this.prscpe = prscpe;
    }

    private String scycle;

    @javax.persistence.Column(name = "SCYCLE")
    @Basic
    public String getScycle() {
        return scycle;
    }

    public void setScycle(String scycle) {
        this.scycle = scycle;
    }

    private String iissue;

    @javax.persistence.Column(name = "IISSUE")
    @Basic
    public String getIissue() {
        return iissue;
    }

    public void setIissue(String iissue) {
        this.iissue = iissue;
    }

    private String nastat;

    @javax.persistence.Column(name = "NASTAT")
    @Basic
    public String getNastat() {
        return nastat;
    }

    public void setNastat(String nastat) {
        this.nastat = nastat;
    }

    private String fisapst;

    @javax.persistence.Column(name = "FISAPST")
    @Basic
    public String getFisapst() {
        return fisapst;
    }

    public void setFisapst(String fisapst) {
        this.fisapst = fisapst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SamEntity samEntity = (SamEntity) o;

        if (beogbud != samEntity.beogbud) return false;
        if (beogexp != samEntity.beogexp) return false;
        if (beogsch != samEntity.beogsch) return false;
        if (bud01 != samEntity.bud01) return false;
        if (bud02 != samEntity.bud02) return false;
        if (bud03 != samEntity.bud03) return false;
        if (bud04 != samEntity.bud04) return false;
        if (bud05 != samEntity.bud05) return false;
        if (bud06 != samEntity.bud06) return false;
        if (bud07 != samEntity.bud07) return false;
        if (bud08 != samEntity.bud08) return false;
        if (bud09 != samEntity.bud09) return false;
        if (bud10 != samEntity.bud10) return false;
        if (ebeogi != samEntity.ebeogi) return false;
        if (efc != samEntity.efc) return false;
        if (efcsrej != samEntity.efcsrej) return false;
        if (elgamt != samEntity.elgamt) return false;
        if (estefc != samEntity.estefc) return false;
        if (estpc != samEntity.estpc) return false;
        if (estsc != samEntity.estsc) return false;
        if (fedefc != samEntity.fedefc) return false;
        if (fedpc != samEntity.fedpc) return false;
        if (frepagi != samEntity.frepagi) return false;
        if (groneed != samEntity.groneed) return false;
        if (gslagi != samEntity.gslagi) return false;
        if (gslbud != samEntity.gslbud) return false;
        if (instefc != samEntity.instefc) return false;
        if (instpc != samEntity.instpc) return false;
        if (instsc != samEntity.instsc) return false;
        if (ldbnum != samEntity.ldbnum) return false;
        if (nassets != samEntity.nassets) return false;
        if (ntaxinc != samEntity.ntaxinc) return false;
        if (obeogi != samEntity.obeogi) return false;
        if (overbud != samEntity.overbud) return false;
        if (overgsl != samEntity.overgsl) return false;
        if (overpc != samEntity.overpc) return false;
        if (oversc != samEntity.oversc) return false;
        if (ovrbeog != samEntity.ovrbeog) return false;
        if (ovrfefc != samEntity.ovrfefc) return false;
        if (ovrfpc != samEntity.ovrfpc) return false;
        if (padjgro != samEntity.padjgro) return false;
        if (pc != samEntity.pc) return false;
        if (pgacch != samEntity.pgacch) return false;
        if (pgawdch != samEntity.pgawdch) return false;
        if (prscpe != samEntity.prscpe) return false;
        if (punneed != samEntity.punneed) return false;
        if (reqamt != samEntity.reqamt) return false;
        if (sadjgro != samEntity.sadjgro) return false;
        if (saiadj != samEntity.saiadj) return false;
        if (sbudget != samEntity.sbudget) return false;
        if (sc != samEntity.sc) return false;
        if (sdrcost != samEntity.sdrcost) return false;
        if (statepc != samEntity.statepc) return false;
        if (statesc != samEntity.statesc) return false;
        if (stbud != samEntity.stbud) return false;
        if (stindex != samEntity.stindex) return false;
        if (sumsave != samEntity.sumsave) return false;
        if (taxinc != samEntity.taxinc) return false;
        if (tfcgsl != samEntity.tfcgsl) return false;
        if (totach != samEntity.totach) return false;
        if (totsat != samEntity.totsat) return false;
        if (usernr1 != samEntity.usernr1) return false;
        if (usernr2 != samEntity.usernr2) return false;
        if (usernr3 != samEntity.usernr3) return false;
        if (usernr4 != samEntity.usernr4) return false;
        if (usernr5 != samEntity.usernr5) return false;
        if (aac != null ? !aac.equals(samEntity.aac) : samEntity.aac != null) return false;
        if (acgelg != null ? !acgelg.equals(samEntity.acgelg) : samEntity.acgelg != null) return false;
        if (acpdtec != null ? !acpdtec.equals(samEntity.acpdtec) : samEntity.acpdtec != null) return false;
        if (acprog1 != null ? !acprog1.equals(samEntity.acprog1) : samEntity.acprog1 != null) return false;
        if (acprog2 != null ? !acprog2.equals(samEntity.acprog2) : samEntity.acprog2 != null) return false;
        if (acprog3 != null ? !acprog3.equals(samEntity.acprog3) : samEntity.acprog3 != null) return false;
        if (acprog4 != null ? !acprog4.equals(samEntity.acprog4) : samEntity.acprog4 != null) return false;
        if (acprog5 != null ? !acprog5.equals(samEntity.acprog5) : samEntity.acprog5 != null) return false;
        if (acprog6 != null ? !acprog6.equals(samEntity.acprog6) : samEntity.acprog6 != null) return false;
        if (adjfact != null ? !adjfact.equals(samEntity.adjfact) : samEntity.adjfact != null) return false;
        if (admstat != null ? !admstat.equals(samEntity.admstat) : samEntity.admstat != null) return false;
        if (admterm != null ? !admterm.equals(samEntity.admterm) : samEntity.admterm != null) return false;
        if (aenrlt1 != null ? !aenrlt1.equals(samEntity.aenrlt1) : samEntity.aenrlt1 != null) return false;
        if (aenrlt2 != null ? !aenrlt2.equals(samEntity.aenrlt2) : samEntity.aenrlt2 != null) return false;
        if (aenrlt3 != null ? !aenrlt3.equals(samEntity.aenrlt3) : samEntity.aenrlt3 != null) return false;
        if (aenrlt4 != null ? !aenrlt4.equals(samEntity.aenrlt4) : samEntity.aenrlt4 != null) return false;
        if (aenrlt5 != null ? !aenrlt5.equals(samEntity.aenrlt5) : samEntity.aenrlt5 != null) return false;
        if (aenrlt6 != null ? !aenrlt6.equals(samEntity.aenrlt6) : samEntity.aenrlt6 != null) return false;
        if (agncysp != null ? !agncysp.equals(samEntity.agncysp) : samEntity.agncysp != null) return false;
        if (aidyr != null ? !aidyr.equals(samEntity.aidyr) : samEntity.aidyr != null) return false;
        if (appbegc != null ? !appbegc.equals(samEntity.appbegc) : samEntity.appbegc != null) return false;
        if (appcmpc != null ? !appcmpc.equals(samEntity.appcmpc) : samEntity.appcmpc != null) return false;
        if (appendc != null ? !appendc.equals(samEntity.appendc) : samEntity.appendc != null) return false;
        if (athlet1 != null ? !athlet1.equals(samEntity.athlet1) : samEntity.athlet1 != null) return false;
        if (athlet2 != null ? !athlet2.equals(samEntity.athlet2) : samEntity.athlet2 != null) return false;
        if (beogflg != null ? !beogflg.equals(samEntity.beogflg) : samEntity.beogflg != null) return false;
        if (btype01 != null ? !btype01.equals(samEntity.btype01) : samEntity.btype01 != null) return false;
        if (btype02 != null ? !btype02.equals(samEntity.btype02) : samEntity.btype02 != null) return false;
        if (btype03 != null ? !btype03.equals(samEntity.btype03) : samEntity.btype03 != null) return false;
        if (btype04 != null ? !btype04.equals(samEntity.btype04) : samEntity.btype04 != null) return false;
        if (btype05 != null ? !btype05.equals(samEntity.btype05) : samEntity.btype05 != null) return false;
        if (btype06 != null ? !btype06.equals(samEntity.btype06) : samEntity.btype06 != null) return false;
        if (btype07 != null ? !btype07.equals(samEntity.btype07) : samEntity.btype07 != null) return false;
        if (btype08 != null ? !btype08.equals(samEntity.btype08) : samEntity.btype08 != null) return false;
        if (btype09 != null ? !btype09.equals(samEntity.btype09) : samEntity.btype09 != null) return false;
        if (btype10 != null ? !btype10.equals(samEntity.btype10) : samEntity.btype10 != null) return false;
        if (budtype != null ? !budtype.equals(samEntity.budtype) : samEntity.budtype != null) return false;
        if (chgdawd != null ? !chgdawd.equals(samEntity.chgdawd) : samEntity.chgdawd != null) return false;
        if (class1 != null ? !class1.equals(samEntity.class1) : samEntity.class1 != null) return false;
        if (class2 != null ? !class2.equals(samEntity.class2) : samEntity.class2 != null) return false;
        if (class3 != null ? !class3.equals(samEntity.class3) : samEntity.class3 != null) return false;
        if (class4 != null ? !class4.equals(samEntity.class4) : samEntity.class4 != null) return false;
        if (class5 != null ? !class5.equals(samEntity.class5) : samEntity.class5 != null) return false;
        if (class6 != null ? !class6.equals(samEntity.class6) : samEntity.class6 != null) return false;
        if (cmajor != null ? !cmajor.equals(samEntity.cmajor) : samEntity.cmajor != null) return false;
        if (comdtec != null ? !comdtec.equals(samEntity.comdtec) : samEntity.comdtec != null) return false;
        if (cstat != null ? !cstat.equals(samEntity.cstat) : samEntity.cstat != null) return false;
        if (currfst != null ? !currfst.equals(samEntity.currfst) : samEntity.currfst != null) return false;
        if (depstf != null ? !depstf.equals(samEntity.depstf) : samEntity.depstf != null) return false;
        if (depsti != null ? !depsti.equals(samEntity.depsti) : samEntity.depsti != null) return false;
        if (depsts != null ? !depsts.equals(samEntity.depsts) : samEntity.depsts != null) return false;
        if (disdtec != null ? !disdtec.equals(samEntity.disdtec) : samEntity.disdtec != null) return false;
        if (dstat != null ? !dstat.equals(samEntity.dstat) : samEntity.dstat != null) return false;
        if (ecampus != null ? !ecampus.equals(samEntity.ecampus) : samEntity.ecampus != null) return false;
        if (eltrcod != null ? !eltrcod.equals(samEntity.eltrcod) : samEntity.eltrcod != null) return false;
        if (eltrdte != null ? !eltrdte.equals(samEntity.eltrdte) : samEntity.eltrdte != null) return false;
        if (eltrst != null ? !eltrst.equals(samEntity.eltrst) : samEntity.eltrst != null) return false;
        if (enrlgh != null ? !enrlgh.equals(samEntity.enrlgh) : samEntity.enrlgh != null) return false;
        if (enrtyp1 != null ? !enrtyp1.equals(samEntity.enrtyp1) : samEntity.enrtyp1 != null) return false;
        if (enrtyp2 != null ? !enrtyp2.equals(samEntity.enrtyp2) : samEntity.enrtyp2 != null) return false;
        if (enrtyp3 != null ? !enrtyp3.equals(samEntity.enrtyp3) : samEntity.enrtyp3 != null) return false;
        if (enrtyp4 != null ? !enrtyp4.equals(samEntity.enrtyp4) : samEntity.enrtyp4 != null) return false;
        if (enrtyp5 != null ? !enrtyp5.equals(samEntity.enrtyp5) : samEntity.enrtyp5 != null) return false;
        if (enrtyp6 != null ? !enrtyp6.equals(samEntity.enrtyp6) : samEntity.enrtyp6 != null) return false;
        if (estat != null ? !estat.equals(samEntity.estat) : samEntity.estat != null) return false;
        if (evalclr != null ? !evalclr.equals(samEntity.evalclr) : samEntity.evalclr != null) return false;
        if (evldtec != null ? !evldtec.equals(samEntity.evldtec) : samEntity.evldtec != null) return false;
        if (except != null ? !except.equals(samEntity.except) : samEntity.except != null) return false;
        if (faasai != null ? !faasai.equals(samEntity.faasai) : samEntity.faasai != null) return false;
        if (fafdtec != null ? !fafdtec.equals(samEntity.fafdtec) : samEntity.fafdtec != null) return false;
        if (filcmpc != null ? !filcmpc.equals(samEntity.filcmpc) : samEntity.filcmpc != null) return false;
        if (fisapst != null ? !fisapst.equals(samEntity.fisapst) : samEntity.fisapst != null) return false;
        if (hold01 != null ? !hold01.equals(samEntity.hold01) : samEntity.hold01 != null) return false;
        if (hold02 != null ? !hold02.equals(samEntity.hold02) : samEntity.hold02 != null) return false;
        if (hold03 != null ? !hold03.equals(samEntity.hold03) : samEntity.hold03 != null) return false;
        if (hold04 != null ? !hold04.equals(samEntity.hold04) : samEntity.hold04 != null) return false;
        if (hold05 != null ? !hold05.equals(samEntity.hold05) : samEntity.hold05 != null) return false;
        if (hold06 != null ? !hold06.equals(samEntity.hold06) : samEntity.hold06 != null) return false;
        if (iissue != null ? !iissue.equals(samEntity.iissue) : samEntity.iissue != null) return false;
        if (incar != null ? !incar.equals(samEntity.incar) : samEntity.incar != null) return false;
        if (incflag != null ? !incflag.equals(samEntity.incflag) : samEntity.incflag != null) return false;
        if (initals != null ? !initals.equals(samEntity.initals) : samEntity.initals != null) return false;
        if (irsreqc != null ? !irsreqc.equals(samEntity.irsreqc) : samEntity.irsreqc != null) return false;
        if (irsverc != null ? !irsverc.equals(samEntity.irsverc) : samEntity.irsverc != null) return false;
        if (lcode01 != null ? !lcode01.equals(samEntity.lcode01) : samEntity.lcode01 != null) return false;
        if (lcode02 != null ? !lcode02.equals(samEntity.lcode02) : samEntity.lcode02 != null) return false;
        if (lcode03 != null ? !lcode03.equals(samEntity.lcode03) : samEntity.lcode03 != null) return false;
        if (lcode04 != null ? !lcode04.equals(samEntity.lcode04) : samEntity.lcode04 != null) return false;
        if (lcode05 != null ? !lcode05.equals(samEntity.lcode05) : samEntity.lcode05 != null) return false;
        if (lcode06 != null ? !lcode06.equals(samEntity.lcode06) : samEntity.lcode06 != null) return false;
        if (lcode07 != null ? !lcode07.equals(samEntity.lcode07) : samEntity.lcode07 != null) return false;
        if (ldate1C != null ? !ldate1C.equals(samEntity.ldate1C) : samEntity.ldate1C != null) return false;
        if (ldate2C != null ? !ldate2C.equals(samEntity.ldate2C) : samEntity.ldate2C != null) return false;
        if (ldate3C != null ? !ldate3C.equals(samEntity.ldate3C) : samEntity.ldate3C != null) return false;
        if (ldate4C != null ? !ldate4C.equals(samEntity.ldate4C) : samEntity.ldate4C != null) return false;
        if (ldate5C != null ? !ldate5C.equals(samEntity.ldate5C) : samEntity.ldate5C != null) return false;
        if (ldate6C != null ? !ldate6C.equals(samEntity.ldate6C) : samEntity.ldate6C != null) return false;
        if (ldate7C != null ? !ldate7C.equals(samEntity.ldate7C) : samEntity.ldate7C != null) return false;
        if (lisirup != null ? !lisirup.equals(samEntity.lisirup) : samEntity.lisirup != null) return false;
        if (module != null ? !module.equals(samEntity.module) : samEntity.module != null) return false;
        if (nastat != null ? !nastat.equals(samEntity.nastat) : samEntity.nastat != null) return false;
        if (needtec != null ? !needtec.equals(samEntity.needtec) : samEntity.needtec != null) return false;
        if (netneed != null ? !netneed.equals(samEntity.netneed) : samEntity.netneed != null) return false;
        if (notdtec != null ? !notdtec.equals(samEntity.notdtec) : samEntity.notdtec != null) return false;
        if (nstat != null ? !nstat.equals(samEntity.nstat) : samEntity.nstat != null) return false;
        if (pacdlvl != null ? !pacdlvl.equals(samEntity.pacdlvl) : samEntity.pacdlvl != null) return false;
        if (packgrp != null ? !packgrp.equals(samEntity.packgrp) : samEntity.packgrp != null) return false;
        if (pckdtec != null ? !pckdtec.equals(samEntity.pckdtec) : samEntity.pckdtec != null) return false;
        if (pdeg != null ? !pdeg.equals(samEntity.pdeg) : samEntity.pdeg != null) return false;
        if (pdegree != null ? !pdegree.equals(samEntity.pdegree) : samEntity.pdegree != null) return false;
        if (pelflg != null ? !pelflg.equals(samEntity.pelflg) : samEntity.pelflg != null) return false;
        if (pellelg != null ? !pellelg.equals(samEntity.pellelg) : samEntity.pellelg != null) return false;
        if (penrlt1 != null ? !penrlt1.equals(samEntity.penrlt1) : samEntity.penrlt1 != null) return false;
        if (penrlt2 != null ? !penrlt2.equals(samEntity.penrlt2) : samEntity.penrlt2 != null) return false;
        if (penrlt3 != null ? !penrlt3.equals(samEntity.penrlt3) : samEntity.penrlt3 != null) return false;
        if (penrlt4 != null ? !penrlt4.equals(samEntity.penrlt4) : samEntity.penrlt4 != null) return false;
        if (penrlt5 != null ? !penrlt5.equals(samEntity.penrlt5) : samEntity.penrlt5 != null) return false;
        if (penrlt6 != null ? !penrlt6.equals(samEntity.penrlt6) : samEntity.penrlt6 != null) return false;
        if (pgidsf != null ? !pgidsf.equals(samEntity.pgidsf) : samEntity.pgidsf != null) return false;
        if (pgprst != null ? !pgprst.equals(samEntity.pgprst) : samEntity.pgprst != null) return false;
        if (pgsid != null ? !pgsid.equals(samEntity.pgsid) : samEntity.pgsid != null) return false;
        if (pgtrnnr != null ? !pgtrnnr.equals(samEntity.pgtrnnr) : samEntity.pgtrnnr != null) return false;
        if (pgvalst != null ? !pgvalst.equals(samEntity.pgvalst) : samEntity.pgvalst != null) return false;
        if (pmajor != null ? !pmajor.equals(samEntity.pmajor) : samEntity.pmajor != null) return false;
        if (procno != null ? !procno.equals(samEntity.procno) : samEntity.procno != null) return false;
        if (pryrgpa != null ? !pryrgpa.equals(samEntity.pryrgpa) : samEntity.pryrgpa != null) return false;
        if (pschool != null ? !pschool.equals(samEntity.pschool) : samEntity.pschool != null) return false;
        if (psizehs != null ? !psizehs.equals(samEntity.psizehs) : samEntity.psizehs != null) return false;
        if (pstat != null ? !pstat.equals(samEntity.pstat) : samEntity.pstat != null) return false;
        if (recstat != null ? !recstat.equals(samEntity.recstat) : samEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(samEntity.revdtec) : samEntity.revdtec != null) return false;
        if (revlev != null ? !revlev.equals(samEntity.revlev) : samEntity.revlev != null) return false;
        if (rhsprog != null ? !rhsprog.equals(samEntity.rhsprog) : samEntity.rhsprog != null) return false;
        if (samkey != null ? !samkey.equals(samEntity.samkey) : samEntity.samkey != null) return false;
        if (scycle != null ? !scycle.equals(samEntity.scycle) : samEntity.scycle != null) return false;
        if (shsetyp != null ? !shsetyp.equals(samEntity.shsetyp) : samEntity.shsetyp != null) return false;
        if (sid != null ? !sid.equals(samEntity.sid) : samEntity.sid != null) return false;
        if (sincar != null ? !sincar.equals(samEntity.sincar) : samEntity.sincar != null) return false;
        if (snatype != null ? !snatype.equals(samEntity.snatype) : samEntity.snatype != null) return false;
        if (sphandl != null ? !sphandl.equals(samEntity.sphandl) : samEntity.sphandl != null) return false;
        if (sptal1 != null ? !sptal1.equals(samEntity.sptal1) : samEntity.sptal1 != null) return false;
        if (sptal2 != null ? !sptal2.equals(samEntity.sptal2) : samEntity.sptal2 != null) return false;
        if (sptal3 != null ? !sptal3.equals(samEntity.sptal3) : samEntity.sptal3 != null) return false;
        if (sptal4 != null ? !sptal4.equals(samEntity.sptal4) : samEntity.sptal4 != null) return false;
        if (ssizehs != null ? !ssizehs.equals(samEntity.ssizehs) : samEntity.ssizehs != null) return false;
        if (stateso != null ? !stateso.equals(samEntity.stateso) : samEntity.stateso != null) return false;
        if (sumses1 != null ? !sumses1.equals(samEntity.sumses1) : samEntity.sumses1 != null) return false;
        if (sumses2 != null ? !sumses2.equals(samEntity.sumses2) : samEntity.sumses2 != null) return false;
        if (sumses3 != null ? !sumses3.equals(samEntity.sumses3) : samEntity.sumses3 != null) return false;
        if (sumses4 != null ? !sumses4.equals(samEntity.sumses4) : samEntity.sumses4 != null) return false;
        if (sumses5 != null ? !sumses5.equals(samEntity.sumses5) : samEntity.sumses5 != null) return false;
        if (sumses6 != null ? !sumses6.equals(samEntity.sumses6) : samEntity.sumses6 != null) return false;
        if (sumses7 != null ? !sumses7.equals(samEntity.sumses7) : samEntity.sumses7 != null) return false;
        if (sumses8 != null ? !sumses8.equals(samEntity.sumses8) : samEntity.sumses8 != null) return false;
        if (sumsesa != null ? !sumsesa.equals(samEntity.sumsesa) : samEntity.sumsesa != null) return false;
        if (sumsesb != null ? !sumsesb.equals(samEntity.sumsesb) : samEntity.sumsesb != null) return false;
        if (sumsesc != null ? !sumsesc.equals(samEntity.sumsesc) : samEntity.sumsesc != null) return false;
        if (sumsesd != null ? !sumsesd.equals(samEntity.sumsesd) : samEntity.sumsesd != null) return false;
        if (sumsese != null ? !sumsese.equals(samEntity.sumsese) : samEntity.sumsese != null) return false;
        if (sumsesf != null ? !sumsesf.equals(samEntity.sumsesf) : samEntity.sumsesf != null) return false;
        if (sumsesg != null ? !sumsesg.equals(samEntity.sumsesg) : samEntity.sumsesg != null) return false;
        if (sumsesh != null ? !sumsesh.equals(samEntity.sumsesh) : samEntity.sumsesh != null) return false;
        if (taid != null ? !taid.equals(samEntity.taid) : samEntity.taid != null) return false;
        if (taidcb != null ? !taidcb.equals(samEntity.taidcb) : samEntity.taidcb != null) return false;
        if (taidnb != null ? !taidnb.equals(samEntity.taidnb) : samEntity.taidnb != null) return false;
        if (taidor != null ? !taidor.equals(samEntity.taidor) : samEntity.taidor != null) return false;
        if (time != null ? !time.equals(samEntity.time) : samEntity.time != null) return false;
        if (tmrind != null ? !tmrind.equals(samEntity.tmrind) : samEntity.tmrind != null) return false;
        if (trmcon != null ? !trmcon.equals(samEntity.trmcon) : samEntity.trmcon != null) return false;
        if (trmdtec != null ? !trmdtec.equals(samEntity.trmdtec) : samEntity.trmdtec != null) return false;
        if (ucode != null ? !ucode.equals(samEntity.ucode) : samEntity.ucode != null) return false;
        if (unneed != null ? !unneed.equals(samEntity.unneed) : samEntity.unneed != null) return false;
        if (unused9 != null ? !unused9.equals(samEntity.unused9) : samEntity.unused9 != null) return false;
        if (user1 != null ? !user1.equals(samEntity.user1) : samEntity.user1 != null) return false;
        if (user10 != null ? !user10.equals(samEntity.user10) : samEntity.user10 != null) return false;
        if (user11 != null ? !user11.equals(samEntity.user11) : samEntity.user11 != null) return false;
        if (user12 != null ? !user12.equals(samEntity.user12) : samEntity.user12 != null) return false;
        if (user13 != null ? !user13.equals(samEntity.user13) : samEntity.user13 != null) return false;
        if (user14 != null ? !user14.equals(samEntity.user14) : samEntity.user14 != null) return false;
        if (user15 != null ? !user15.equals(samEntity.user15) : samEntity.user15 != null) return false;
        if (user16 != null ? !user16.equals(samEntity.user16) : samEntity.user16 != null) return false;
        if (user17 != null ? !user17.equals(samEntity.user17) : samEntity.user17 != null) return false;
        if (user18 != null ? !user18.equals(samEntity.user18) : samEntity.user18 != null) return false;
        if (user19 != null ? !user19.equals(samEntity.user19) : samEntity.user19 != null) return false;
        if (user2 != null ? !user2.equals(samEntity.user2) : samEntity.user2 != null) return false;
        if (user20 != null ? !user20.equals(samEntity.user20) : samEntity.user20 != null) return false;
        if (user3 != null ? !user3.equals(samEntity.user3) : samEntity.user3 != null) return false;
        if (user4 != null ? !user4.equals(samEntity.user4) : samEntity.user4 != null) return false;
        if (user5 != null ? !user5.equals(samEntity.user5) : samEntity.user5 != null) return false;
        if (user6 != null ? !user6.equals(samEntity.user6) : samEntity.user6 != null) return false;
        if (user7 != null ? !user7.equals(samEntity.user7) : samEntity.user7 != null) return false;
        if (user8 != null ? !user8.equals(samEntity.user8) : samEntity.user8 != null) return false;
        if (user9 != null ? !user9.equals(samEntity.user9) : samEntity.user9 != null) return false;
        if (userflg != null ? !userflg.equals(samEntity.userflg) : samEntity.userflg != null) return false;
        if (usernr6 != null ? !usernr6.equals(samEntity.usernr6) : samEntity.usernr6 != null) return false;
        if (usernr7 != null ? !usernr7.equals(samEntity.usernr7) : samEntity.usernr7 != null) return false;
        if (usernr8 != null ? !usernr8.equals(samEntity.usernr8) : samEntity.usernr8 != null) return false;
        if (workmax != null ? !workmax.equals(samEntity.workmax) : samEntity.workmax != null) return false;
        if (wspref != null ? !wspref.equals(samEntity.wspref) : samEntity.wspref != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (samkey != null ? samkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (ecampus != null ? ecampus.hashCode() : 0);
        result = 31 * result + (depstf != null ? depstf.hashCode() : 0);
        result = 31 * result + (depsts != null ? depsts.hashCode() : 0);
        result = 31 * result + (depsti != null ? depsti.hashCode() : 0);
        result = 31 * result + (admstat != null ? admstat.hashCode() : 0);
        result = 31 * result + (pmajor != null ? pmajor.hashCode() : 0);
        result = 31 * result + (pschool != null ? pschool.hashCode() : 0);
        result = 31 * result + (pdegree != null ? pdegree.hashCode() : 0);
        result = 31 * result + (pdeg != null ? pdeg.hashCode() : 0);
        result = 31 * result + (pacdlvl != null ? pacdlvl.hashCode() : 0);
        result = 31 * result + (ssizehs != null ? ssizehs.hashCode() : 0);
        result = 31 * result + (psizehs != null ? psizehs.hashCode() : 0);
        result = 31 * result + (shsetyp != null ? shsetyp.hashCode() : 0);
        result = 31 * result + (procno != null ? procno.hashCode() : 0);
        result = 31 * result + (snatype != null ? snatype.hashCode() : 0);
        result = 31 * result + (athlet1 != null ? athlet1.hashCode() : 0);
        result = 31 * result + (athlet2 != null ? athlet2.hashCode() : 0);
        result = 31 * result + (currfst != null ? currfst.hashCode() : 0);
        result = 31 * result + (sphandl != null ? sphandl.hashCode() : 0);
        result = 31 * result + (sptal1 != null ? sptal1.hashCode() : 0);
        result = 31 * result + (sptal2 != null ? sptal2.hashCode() : 0);
        result = 31 * result + (sptal3 != null ? sptal3.hashCode() : 0);
        result = 31 * result + (sptal4 != null ? sptal4.hashCode() : 0);
        result = 31 * result + (packgrp != null ? packgrp.hashCode() : 0);
        result = 31 * result + (penrlt1 != null ? penrlt1.hashCode() : 0);
        result = 31 * result + (penrlt2 != null ? penrlt2.hashCode() : 0);
        result = 31 * result + (penrlt3 != null ? penrlt3.hashCode() : 0);
        result = 31 * result + (penrlt4 != null ? penrlt4.hashCode() : 0);
        result = 31 * result + (penrlt5 != null ? penrlt5.hashCode() : 0);
        result = 31 * result + (penrlt6 != null ? penrlt6.hashCode() : 0);
        result = 31 * result + (aenrlt1 != null ? aenrlt1.hashCode() : 0);
        result = 31 * result + (aenrlt2 != null ? aenrlt2.hashCode() : 0);
        result = 31 * result + (aenrlt3 != null ? aenrlt3.hashCode() : 0);
        result = 31 * result + (aenrlt4 != null ? aenrlt4.hashCode() : 0);
        result = 31 * result + (aenrlt5 != null ? aenrlt5.hashCode() : 0);
        result = 31 * result + (aenrlt6 != null ? aenrlt6.hashCode() : 0);
        result = 31 * result + (estat != null ? estat.hashCode() : 0);
        result = 31 * result + (pstat != null ? pstat.hashCode() : 0);
        result = 31 * result + (nstat != null ? nstat.hashCode() : 0);
        result = 31 * result + (cstat != null ? cstat.hashCode() : 0);
        result = 31 * result + (dstat != null ? dstat.hashCode() : 0);
        result = 31 * result + sumsave;
        result = 31 * result + ntaxinc;
        result = 31 * result + taxinc;
        result = 31 * result + nassets;
        result = 31 * result + (adjfact != null ? adjfact.hashCode() : 0);
        result = 31 * result + efc;
        result = 31 * result + pc;
        result = 31 * result + sc;
        result = 31 * result + sbudget;
        result = 31 * result + overbud;
        result = 31 * result + overpc;
        result = 31 * result + oversc;
        result = 31 * result + (budtype != null ? budtype.hashCode() : 0);
        result = 31 * result + (btype01 != null ? btype01.hashCode() : 0);
        result = 31 * result + (btype02 != null ? btype02.hashCode() : 0);
        result = 31 * result + (btype03 != null ? btype03.hashCode() : 0);
        result = 31 * result + (btype04 != null ? btype04.hashCode() : 0);
        result = 31 * result + (btype05 != null ? btype05.hashCode() : 0);
        result = 31 * result + (btype06 != null ? btype06.hashCode() : 0);
        result = 31 * result + (btype07 != null ? btype07.hashCode() : 0);
        result = 31 * result + (btype08 != null ? btype08.hashCode() : 0);
        result = 31 * result + (btype09 != null ? btype09.hashCode() : 0);
        result = 31 * result + (btype10 != null ? btype10.hashCode() : 0);
        result = 31 * result + bud01;
        result = 31 * result + bud02;
        result = 31 * result + bud03;
        result = 31 * result + bud04;
        result = 31 * result + bud05;
        result = 31 * result + bud06;
        result = 31 * result + bud07;
        result = 31 * result + bud08;
        result = 31 * result + bud09;
        result = 31 * result + bud10;
        result = 31 * result + groneed;
        result = 31 * result + (netneed != null ? netneed.hashCode() : 0);
        result = 31 * result + (unneed != null ? unneed.hashCode() : 0);
        result = 31 * result + (taid != null ? taid.hashCode() : 0);
        result = 31 * result + (taidor != null ? taidor.hashCode() : 0);
        result = 31 * result + (taidcb != null ? taidcb.hashCode() : 0);
        result = 31 * result + ebeogi;
        result = 31 * result + obeogi;
        result = 31 * result + beogbud;
        result = 31 * result + ovrbeog;
        result = 31 * result + beogsch;
        result = 31 * result + beogexp;
        result = 31 * result + (beogflg != null ? beogflg.hashCode() : 0);
        result = 31 * result + (userflg != null ? userflg.hashCode() : 0);
        result = 31 * result + (user1 != null ? user1.hashCode() : 0);
        result = 31 * result + (user2 != null ? user2.hashCode() : 0);
        result = 31 * result + (user3 != null ? user3.hashCode() : 0);
        result = 31 * result + (user4 != null ? user4.hashCode() : 0);
        result = 31 * result + (user5 != null ? user5.hashCode() : 0);
        result = 31 * result + (user6 != null ? user6.hashCode() : 0);
        result = 31 * result + (user7 != null ? user7.hashCode() : 0);
        result = 31 * result + (user8 != null ? user8.hashCode() : 0);
        result = 31 * result + (hold01 != null ? hold01.hashCode() : 0);
        result = 31 * result + (hold02 != null ? hold02.hashCode() : 0);
        result = 31 * result + (hold03 != null ? hold03.hashCode() : 0);
        result = 31 * result + (hold04 != null ? hold04.hashCode() : 0);
        result = 31 * result + (hold05 != null ? hold05.hashCode() : 0);
        result = 31 * result + (hold06 != null ? hold06.hashCode() : 0);
        result = 31 * result + elgamt;
        result = 31 * result + reqamt;
        result = 31 * result + (agncysp != null ? agncysp.hashCode() : 0);
        result = 31 * result + (evalclr != null ? evalclr.hashCode() : 0);
        result = 31 * result + totsat;
        result = 31 * result + totach;
        result = 31 * result + (chgdawd != null ? chgdawd.hashCode() : 0);
        result = 31 * result + punneed;
        result = 31 * result + usernr1;
        result = 31 * result + usernr2;
        result = 31 * result + (pgsid != null ? pgsid.hashCode() : 0);
        result = 31 * result + (pgidsf != null ? pgidsf.hashCode() : 0);
        result = 31 * result + (pgtrnnr != null ? pgtrnnr.hashCode() : 0);
        result = 31 * result + (pgprst != null ? pgprst.hashCode() : 0);
        result = 31 * result + pgawdch;
        result = 31 * result + pgacch;
        result = 31 * result + gslagi;
        result = 31 * result + frepagi;
        result = 31 * result + (pgvalst != null ? pgvalst.hashCode() : 0);
        result = 31 * result + gslbud;
        result = 31 * result + overgsl;
        result = 31 * result + (incflag != null ? incflag.hashCode() : 0);
        result = 31 * result + saiadj;
        result = 31 * result + (faasai != null ? faasai.hashCode() : 0);
        result = 31 * result + sadjgro;
        result = 31 * result + padjgro;
        result = 31 * result + estpc;
        result = 31 * result + estsc;
        result = 31 * result + estefc;
        result = 31 * result + (enrlgh != null ? enrlgh.hashCode() : 0);
        result = 31 * result + (incar != null ? incar.hashCode() : 0);
        result = 31 * result + (sincar != null ? sincar.hashCode() : 0);
        result = 31 * result + (class1 != null ? class1.hashCode() : 0);
        result = 31 * result + (class2 != null ? class2.hashCode() : 0);
        result = 31 * result + (class3 != null ? class3.hashCode() : 0);
        result = 31 * result + (class4 != null ? class4.hashCode() : 0);
        result = 31 * result + (class5 != null ? class5.hashCode() : 0);
        result = 31 * result + (class6 != null ? class6.hashCode() : 0);
        result = 31 * result + (pelflg != null ? pelflg.hashCode() : 0);
        result = 31 * result + (sumses1 != null ? sumses1.hashCode() : 0);
        result = 31 * result + (sumses2 != null ? sumses2.hashCode() : 0);
        result = 31 * result + (sumses3 != null ? sumses3.hashCode() : 0);
        result = 31 * result + (sumses4 != null ? sumses4.hashCode() : 0);
        result = 31 * result + (sumses5 != null ? sumses5.hashCode() : 0);
        result = 31 * result + (sumses6 != null ? sumses6.hashCode() : 0);
        result = 31 * result + (sumses7 != null ? sumses7.hashCode() : 0);
        result = 31 * result + (sumses8 != null ? sumses8.hashCode() : 0);
        result = 31 * result + (sumsesa != null ? sumsesa.hashCode() : 0);
        result = 31 * result + (sumsesb != null ? sumsesb.hashCode() : 0);
        result = 31 * result + (sumsesc != null ? sumsesc.hashCode() : 0);
        result = 31 * result + (sumsesd != null ? sumsesd.hashCode() : 0);
        result = 31 * result + (sumsese != null ? sumsese.hashCode() : 0);
        result = 31 * result + (sumsesf != null ? sumsesf.hashCode() : 0);
        result = 31 * result + (sumsesg != null ? sumsesg.hashCode() : 0);
        result = 31 * result + (sumsesh != null ? sumsesh.hashCode() : 0);
        result = 31 * result + (unused9 != null ? unused9.hashCode() : 0);
        result = 31 * result + (acprog1 != null ? acprog1.hashCode() : 0);
        result = 31 * result + (acprog2 != null ? acprog2.hashCode() : 0);
        result = 31 * result + (acprog3 != null ? acprog3.hashCode() : 0);
        result = 31 * result + (acprog4 != null ? acprog4.hashCode() : 0);
        result = 31 * result + (acprog5 != null ? acprog5.hashCode() : 0);
        result = 31 * result + (acprog6 != null ? acprog6.hashCode() : 0);
        result = 31 * result + tfcgsl;
        result = 31 * result + ovrfpc;
        result = 31 * result + fedpc;
        result = 31 * result + ovrfefc;
        result = 31 * result + fedefc;
        result = 31 * result + stbud;
        result = 31 * result + instpc;
        result = 31 * result + instsc;
        result = 31 * result + instefc;
        result = 31 * result + statepc;
        result = 31 * result + statesc;
        result = 31 * result + (stateso != null ? stateso.hashCode() : 0);
        result = 31 * result + stindex;
        result = 31 * result + sdrcost;
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (appbegc != null ? appbegc.hashCode() : 0);
        result = 31 * result + (appendc != null ? appendc.hashCode() : 0);
        result = 31 * result + (aac != null ? aac.hashCode() : 0);
        result = 31 * result + (appcmpc != null ? appcmpc.hashCode() : 0);
        result = 31 * result + (filcmpc != null ? filcmpc.hashCode() : 0);
        result = 31 * result + (fafdtec != null ? fafdtec.hashCode() : 0);
        result = 31 * result + (needtec != null ? needtec.hashCode() : 0);
        result = 31 * result + (evldtec != null ? evldtec.hashCode() : 0);
        result = 31 * result + (pckdtec != null ? pckdtec.hashCode() : 0);
        result = 31 * result + (notdtec != null ? notdtec.hashCode() : 0);
        result = 31 * result + (acpdtec != null ? acpdtec.hashCode() : 0);
        result = 31 * result + (comdtec != null ? comdtec.hashCode() : 0);
        result = 31 * result + (disdtec != null ? disdtec.hashCode() : 0);
        result = 31 * result + (irsreqc != null ? irsreqc.hashCode() : 0);
        result = 31 * result + (irsverc != null ? irsverc.hashCode() : 0);
        result = 31 * result + (lcode01 != null ? lcode01.hashCode() : 0);
        result = 31 * result + (ldate1C != null ? ldate1C.hashCode() : 0);
        result = 31 * result + (lcode02 != null ? lcode02.hashCode() : 0);
        result = 31 * result + (ldate2C != null ? ldate2C.hashCode() : 0);
        result = 31 * result + (lcode03 != null ? lcode03.hashCode() : 0);
        result = 31 * result + (ldate3C != null ? ldate3C.hashCode() : 0);
        result = 31 * result + (lcode04 != null ? lcode04.hashCode() : 0);
        result = 31 * result + (ldate4C != null ? ldate4C.hashCode() : 0);
        result = 31 * result + (lcode05 != null ? lcode05.hashCode() : 0);
        result = 31 * result + (ldate5C != null ? ldate5C.hashCode() : 0);
        result = 31 * result + (lcode06 != null ? lcode06.hashCode() : 0);
        result = 31 * result + (ldate6C != null ? ldate6C.hashCode() : 0);
        result = 31 * result + (lcode07 != null ? lcode07.hashCode() : 0);
        result = 31 * result + (ldate7C != null ? ldate7C.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (taidnb != null ? taidnb.hashCode() : 0);
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
        result = 31 * result + usernr3;
        result = 31 * result + usernr4;
        result = 31 * result + usernr5;
        result = 31 * result + (usernr6 != null ? usernr6.hashCode() : 0);
        result = 31 * result + (usernr7 != null ? usernr7.hashCode() : 0);
        result = 31 * result + (usernr8 != null ? usernr8.hashCode() : 0);
        result = 31 * result + (tmrind != null ? tmrind.hashCode() : 0);
        result = 31 * result + ldbnum;
        result = 31 * result + (cmajor != null ? cmajor.hashCode() : 0);
        result = 31 * result + (eltrdte != null ? eltrdte.hashCode() : 0);
        result = 31 * result + (eltrcod != null ? eltrcod.hashCode() : 0);
        result = 31 * result + (eltrst != null ? eltrst.hashCode() : 0);
        result = 31 * result + (pellelg != null ? pellelg.hashCode() : 0);
        result = 31 * result + (enrtyp1 != null ? enrtyp1.hashCode() : 0);
        result = 31 * result + (enrtyp2 != null ? enrtyp2.hashCode() : 0);
        result = 31 * result + (enrtyp3 != null ? enrtyp3.hashCode() : 0);
        result = 31 * result + (enrtyp4 != null ? enrtyp4.hashCode() : 0);
        result = 31 * result + (enrtyp5 != null ? enrtyp5.hashCode() : 0);
        result = 31 * result + (enrtyp6 != null ? enrtyp6.hashCode() : 0);
        result = 31 * result + (except != null ? except.hashCode() : 0);
        result = 31 * result + (trmcon != null ? trmcon.hashCode() : 0);
        result = 31 * result + (pryrgpa != null ? pryrgpa.hashCode() : 0);
        result = 31 * result + (admterm != null ? admterm.hashCode() : 0);
        result = 31 * result + (rhsprog != null ? rhsprog.hashCode() : 0);
        result = 31 * result + (acgelg != null ? acgelg.hashCode() : 0);
        result = 31 * result + (trmdtec != null ? trmdtec.hashCode() : 0);
        result = 31 * result + efcsrej;
        result = 31 * result + (wspref != null ? wspref.hashCode() : 0);
        result = 31 * result + (workmax != null ? workmax.hashCode() : 0);
        result = 31 * result + (lisirup != null ? lisirup.hashCode() : 0);
        result = 31 * result + prscpe;
        result = 31 * result + (scycle != null ? scycle.hashCode() : 0);
        result = 31 * result + (iissue != null ? iissue.hashCode() : 0);
        result = 31 * result + (nastat != null ? nastat.hashCode() : 0);
        result = 31 * result + (fisapst != null ? fisapst.hashCode() : 0);
        return result;
    }
}
