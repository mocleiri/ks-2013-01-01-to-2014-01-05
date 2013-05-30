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
 * Time: 12:22 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SUT", schema = "SIGMA", catalog = "")
@Entity
public class SutEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSutkey();
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

    private String sutkey;

    @javax.persistence.Column(name = "SUTKEY")
    @Id
    public String getSutkey() {
        return sutkey;
    }

    public void setSutkey(String sutkey) {
        this.sutkey = sutkey;
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

    private String ecampus;

    @javax.persistence.Column(name = "ECAMPUS")
    @Basic
    public String getEcampus() {
        return ecampus;
    }

    public void setEcampus(String ecampus) {
        this.ecampus = ecampus;
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

    private String dept;

    @javax.persistence.Column(name = "DEPT")
    @Basic
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    private String acprog;

    @javax.persistence.Column(name = "ACPROG")
    @Basic
    public String getAcprog() {
        return acprog;
    }

    public void setAcprog(String acprog) {
        this.acprog = acprog;
    }

    private String acprre;

    @javax.persistence.Column(name = "ACPRRE")
    @Basic
    public String getAcprre() {
        return acprre;
    }

    public void setAcprre(String acprre) {
        this.acprre = acprre;
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

    private String btrack;

    @javax.persistence.Column(name = "BTRACK")
    @Basic
    public String getBtrack() {
        return btrack;
    }

    public void setBtrack(String btrack) {
        this.btrack = btrack;
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

    private String aenrlt;

    @javax.persistence.Column(name = "AENRLT")
    @Basic
    public String getAenrlt() {
        return aenrlt;
    }

    public void setAenrlt(String aenrlt) {
        this.aenrlt = aenrlt;
    }

    private String pkenrl;

    @javax.persistence.Column(name = "PKENRL")
    @Basic
    public String getPkenrl() {
        return pkenrl;
    }

    public void setPkenrl(String pkenrl) {
        this.pkenrl = pkenrl;
    }

    private String dsenrl;

    @javax.persistence.Column(name = "DSENRL")
    @Basic
    public String getDsenrl() {
        return dsenrl;
    }

    public void setDsenrl(String dsenrl) {
        this.dsenrl = dsenrl;
    }

    private BigDecimal sbudget;

    @javax.persistence.Column(name = "SBUDGET")
    @Basic
    public BigDecimal getSbudget() {
        return sbudget;
    }

    public void setSbudget(BigDecimal sbudget) {
        this.sbudget = sbudget;
    }

    private BigDecimal overbud;

    @javax.persistence.Column(name = "OVERBUD")
    @Basic
    public BigDecimal getOverbud() {
        return overbud;
    }

    public void setOverbud(BigDecimal overbud) {
        this.overbud = overbud;
    }

    private BigDecimal pellbud;

    @javax.persistence.Column(name = "PELLBUD")
    @Basic
    public BigDecimal getPellbud() {
        return pellbud;
    }

    public void setPellbud(BigDecimal pellbud) {
        this.pellbud = pellbud;
    }

    private BigDecimal ovrpell;

    @javax.persistence.Column(name = "OVRPELL")
    @Basic
    public BigDecimal getOvrpell() {
        return ovrpell;
    }

    public void setOvrpell(BigDecimal ovrpell) {
        this.ovrpell = ovrpell;
    }

    private BigDecimal gslbud;

    @javax.persistence.Column(name = "GSLBUD")
    @Basic
    public BigDecimal getGslbud() {
        return gslbud;
    }

    public void setGslbud(BigDecimal gslbud) {
        this.gslbud = gslbud;
    }

    private BigDecimal overgsl;

    @javax.persistence.Column(name = "OVERGSL")
    @Basic
    public BigDecimal getOvergsl() {
        return overgsl;
    }

    public void setOvergsl(BigDecimal overgsl) {
        this.overgsl = overgsl;
    }

    private BigDecimal toffr;

    @javax.persistence.Column(name = "TOFFR")
    @Basic
    public BigDecimal getToffr() {
        return toffr;
    }

    public void setToffr(BigDecimal toffr) {
        this.toffr = toffr;
    }

    private BigDecimal tacpt;

    @javax.persistence.Column(name = "TACPT")
    @Basic
    public BigDecimal getTacpt() {
        return tacpt;
    }

    public void setTacpt(BigDecimal tacpt) {
        this.tacpt = tacpt;
    }

    private BigDecimal tpaid;

    @javax.persistence.Column(name = "TPAID")
    @Basic
    public BigDecimal getTpaid() {
        return tpaid;
    }

    public void setTpaid(BigDecimal tpaid) {
        this.tpaid = tpaid;
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

    private String pacdlvl;

    @javax.persistence.Column(name = "PACDLVL")
    @Basic
    public String getPacdlvl() {
        return pacdlvl;
    }

    public void setPacdlvl(String pacdlvl) {
        this.pacdlvl = pacdlvl;
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

    private String packgrp;

    @javax.persistence.Column(name = "PACKGRP")
    @Basic
    public String getPackgrp() {
        return packgrp;
    }

    public void setPackgrp(String packgrp) {
        this.packgrp = packgrp;
    }

    private String appbeg;

    @javax.persistence.Column(name = "APPBEG")
    @Basic
    public String getAppbeg() {
        return appbeg;
    }

    public void setAppbeg(String appbeg) {
        this.appbeg = appbeg;
    }

    private String append;

    @javax.persistence.Column(name = "APPEND")
    @Basic
    public String getAppend() {
        return append;
    }

    public void setAppend(String append) {
        this.append = append;
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

    private String needdte;

    @javax.persistence.Column(name = "NEEDDTE")
    @Basic
    public String getNeeddte() {
        return needdte;
    }

    public void setNeeddte(String needdte) {
        this.needdte = needdte;
    }

    private String evaldte;

    @javax.persistence.Column(name = "EVALDTE")
    @Basic
    public String getEvaldte() {
        return evaldte;
    }

    public void setEvaldte(String evaldte) {
        this.evaldte = evaldte;
    }

    private String packdte;

    @javax.persistence.Column(name = "PACKDTE")
    @Basic
    public String getPackdte() {
        return packdte;
    }

    public void setPackdte(String packdte) {
        this.packdte = packdte;
    }

    private String notfdte;

    @javax.persistence.Column(name = "NOTFDTE")
    @Basic
    public String getNotfdte() {
        return notfdte;
    }

    public void setNotfdte(String notfdte) {
        this.notfdte = notfdte;
    }

    private String acptdte;

    @javax.persistence.Column(name = "ACPTDTE")
    @Basic
    public String getAcptdte() {
        return acptdte;
    }

    public void setAcptdte(String acptdte) {
        this.acptdte = acptdte;
    }

    private String commdte;

    @javax.persistence.Column(name = "COMMDTE")
    @Basic
    public String getCommdte() {
        return commdte;
    }

    public void setCommdte(String commdte) {
        this.commdte = commdte;
    }

    private String disbdte;

    @javax.persistence.Column(name = "DISBDTE")
    @Basic
    public String getDisbdte() {
        return disbdte;
    }

    public void setDisbdte(String disbdte) {
        this.disbdte = disbdte;
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

    private BigDecimal cumgpa;

    @javax.persistence.Column(name = "CUMGPA")
    @Basic
    public BigDecimal getCumgpa() {
        return cumgpa;
    }

    public void setCumgpa(BigDecimal cumgpa) {
        this.cumgpa = cumgpa;
    }

    private BigDecimal gpa;

    @javax.persistence.Column(name = "GPA")
    @Basic
    public BigDecimal getGpa() {
        return gpa;
    }

    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    private BigDecimal cmhrsdf;

    @javax.persistence.Column(name = "CMHRSDF")
    @Basic
    public BigDecimal getCmhrsdf() {
        return cmhrsdf;
    }

    public void setCmhrsdf(BigDecimal cmhrsdf) {
        this.cmhrsdf = cmhrsdf;
    }

    private BigDecimal cmhrsco;

    @javax.persistence.Column(name = "CMHRSCO")
    @Basic
    public BigDecimal getCmhrsco() {
        return cmhrsco;
    }

    public void setCmhrsco(BigDecimal cmhrsco) {
        this.cmhrsco = cmhrsco;
    }

    private BigDecimal cmhrsca;

    @javax.persistence.Column(name = "CMHRSCA")
    @Basic
    public BigDecimal getCmhrsca() {
        return cmhrsca;
    }

    public void setCmhrsca(BigDecimal cmhrsca) {
        this.cmhrsca = cmhrsca;
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

    private BigDecimal cuhrsca;

    @javax.persistence.Column(name = "CUHRSCA")
    @Basic
    public BigDecimal getCuhrsca() {
        return cuhrsca;
    }

    public void setCuhrsca(BigDecimal cuhrsca) {
        this.cuhrsca = cuhrsca;
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

    private String hrstyp1;

    @javax.persistence.Column(name = "HRSTYP1")
    @Basic
    public String getHrstyp1() {
        return hrstyp1;
    }

    public void setHrstyp1(String hrstyp1) {
        this.hrstyp1 = hrstyp1;
    }

    private String hrstyp2;

    @javax.persistence.Column(name = "HRSTYP2")
    @Basic
    public String getHrstyp2() {
        return hrstyp2;
    }

    public void setHrstyp2(String hrstyp2) {
        this.hrstyp2 = hrstyp2;
    }

    private String hrstyp3;

    @javax.persistence.Column(name = "HRSTYP3")
    @Basic
    public String getHrstyp3() {
        return hrstyp3;
    }

    public void setHrstyp3(String hrstyp3) {
        this.hrstyp3 = hrstyp3;
    }

    private String hrstyp4;

    @javax.persistence.Column(name = "HRSTYP4")
    @Basic
    public String getHrstyp4() {
        return hrstyp4;
    }

    public void setHrstyp4(String hrstyp4) {
        this.hrstyp4 = hrstyp4;
    }

    private String hrstyp5;

    @javax.persistence.Column(name = "HRSTYP5")
    @Basic
    public String getHrstyp5() {
        return hrstyp5;
    }

    public void setHrstyp5(String hrstyp5) {
        this.hrstyp5 = hrstyp5;
    }

    private String hrstyp6;

    @javax.persistence.Column(name = "HRSTYP6")
    @Basic
    public String getHrstyp6() {
        return hrstyp6;
    }

    public void setHrstyp6(String hrstyp6) {
        this.hrstyp6 = hrstyp6;
    }

    private String enrlst1;

    @javax.persistence.Column(name = "ENRLST1")
    @Basic
    public String getEnrlst1() {
        return enrlst1;
    }

    public void setEnrlst1(String enrlst1) {
        this.enrlst1 = enrlst1;
    }

    private String enrlst2;

    @javax.persistence.Column(name = "ENRLST2")
    @Basic
    public String getEnrlst2() {
        return enrlst2;
    }

    public void setEnrlst2(String enrlst2) {
        this.enrlst2 = enrlst2;
    }

    private String enrlst3;

    @javax.persistence.Column(name = "ENRLST3")
    @Basic
    public String getEnrlst3() {
        return enrlst3;
    }

    public void setEnrlst3(String enrlst3) {
        this.enrlst3 = enrlst3;
    }

    private String enrlst4;

    @javax.persistence.Column(name = "ENRLST4")
    @Basic
    public String getEnrlst4() {
        return enrlst4;
    }

    public void setEnrlst4(String enrlst4) {
        this.enrlst4 = enrlst4;
    }

    private String enrlst5;

    @javax.persistence.Column(name = "ENRLST5")
    @Basic
    public String getEnrlst5() {
        return enrlst5;
    }

    public void setEnrlst5(String enrlst5) {
        this.enrlst5 = enrlst5;
    }

    private String enrlst6;

    @javax.persistence.Column(name = "ENRLST6")
    @Basic
    public String getEnrlst6() {
        return enrlst6;
    }

    public void setEnrlst6(String enrlst6) {
        this.enrlst6 = enrlst6;
    }

    private BigDecimal hrsnum1;

    @javax.persistence.Column(name = "HRSNUM1")
    @Basic
    public BigDecimal getHrsnum1() {
        return hrsnum1;
    }

    public void setHrsnum1(BigDecimal hrsnum1) {
        this.hrsnum1 = hrsnum1;
    }

    private BigDecimal hrsnum2;

    @javax.persistence.Column(name = "HRSNUM2")
    @Basic
    public BigDecimal getHrsnum2() {
        return hrsnum2;
    }

    public void setHrsnum2(BigDecimal hrsnum2) {
        this.hrsnum2 = hrsnum2;
    }

    private BigDecimal hrsnum3;

    @javax.persistence.Column(name = "HRSNUM3")
    @Basic
    public BigDecimal getHrsnum3() {
        return hrsnum3;
    }

    public void setHrsnum3(BigDecimal hrsnum3) {
        this.hrsnum3 = hrsnum3;
    }

    private BigDecimal hrsnum4;

    @javax.persistence.Column(name = "HRSNUM4")
    @Basic
    public BigDecimal getHrsnum4() {
        return hrsnum4;
    }

    public void setHrsnum4(BigDecimal hrsnum4) {
        this.hrsnum4 = hrsnum4;
    }

    private BigDecimal hrsnum5;

    @javax.persistence.Column(name = "HRSNUM5")
    @Basic
    public BigDecimal getHrsnum5() {
        return hrsnum5;
    }

    public void setHrsnum5(BigDecimal hrsnum5) {
        this.hrsnum5 = hrsnum5;
    }

    private BigDecimal hrsnum6;

    @javax.persistence.Column(name = "HRSNUM6")
    @Basic
    public BigDecimal getHrsnum6() {
        return hrsnum6;
    }

    public void setHrsnum6(BigDecimal hrsnum6) {
        this.hrsnum6 = hrsnum6;
    }

    private String disbs1;

    @javax.persistence.Column(name = "DISBS1")
    @Basic
    public String getDisbs1() {
        return disbs1;
    }

    public void setDisbs1(String disbs1) {
        this.disbs1 = disbs1;
    }

    private String disbs2;

    @javax.persistence.Column(name = "DISBS2")
    @Basic
    public String getDisbs2() {
        return disbs2;
    }

    public void setDisbs2(String disbs2) {
        this.disbs2 = disbs2;
    }

    private String disbs3;

    @javax.persistence.Column(name = "DISBS3")
    @Basic
    public String getDisbs3() {
        return disbs3;
    }

    public void setDisbs3(String disbs3) {
        this.disbs3 = disbs3;
    }

    private String disbs4;

    @javax.persistence.Column(name = "DISBS4")
    @Basic
    public String getDisbs4() {
        return disbs4;
    }

    public void setDisbs4(String disbs4) {
        this.disbs4 = disbs4;
    }

    private String disbs5;

    @javax.persistence.Column(name = "DISBS5")
    @Basic
    public String getDisbs5() {
        return disbs5;
    }

    public void setDisbs5(String disbs5) {
        this.disbs5 = disbs5;
    }

    private String disbs6;

    @javax.persistence.Column(name = "DISBS6")
    @Basic
    public String getDisbs6() {
        return disbs6;
    }

    public void setDisbs6(String disbs6) {
        this.disbs6 = disbs6;
    }

    private String disbs7;

    @javax.persistence.Column(name = "DISBS7")
    @Basic
    public String getDisbs7() {
        return disbs7;
    }

    public void setDisbs7(String disbs7) {
        this.disbs7 = disbs7;
    }

    private String disbs8;

    @javax.persistence.Column(name = "DISBS8")
    @Basic
    public String getDisbs8() {
        return disbs8;
    }

    public void setDisbs8(String disbs8) {
        this.disbs8 = disbs8;
    }

    private String disbs9;

    @javax.persistence.Column(name = "DISBS9")
    @Basic
    public String getDisbs9() {
        return disbs9;
    }

    public void setDisbs9(String disbs9) {
        this.disbs9 = disbs9;
    }

    private String disbs10;

    @javax.persistence.Column(name = "DISBS10")
    @Basic
    public String getDisbs10() {
        return disbs10;
    }

    public void setDisbs10(String disbs10) {
        this.disbs10 = disbs10;
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

    private String disst6;

    @javax.persistence.Column(name = "DISST6")
    @Basic
    public String getDisst6() {
        return disst6;
    }

    public void setDisst6(String disst6) {
        this.disst6 = disst6;
    }

    private String disst7;

    @javax.persistence.Column(name = "DISST7")
    @Basic
    public String getDisst7() {
        return disst7;
    }

    public void setDisst7(String disst7) {
        this.disst7 = disst7;
    }

    private String disst8;

    @javax.persistence.Column(name = "DISST8")
    @Basic
    public String getDisst8() {
        return disst8;
    }

    public void setDisst8(String disst8) {
        this.disst8 = disst8;
    }

    private String disst9;

    @javax.persistence.Column(name = "DISST9")
    @Basic
    public String getDisst9() {
        return disst9;
    }

    public void setDisst9(String disst9) {
        this.disst9 = disst9;
    }

    private String disst10;

    @javax.persistence.Column(name = "DISST10")
    @Basic
    public String getDisst10() {
        return disst10;
    }

    public void setDisst10(String disst10) {
        this.disst10 = disst10;
    }

    private String enrstat;

    @javax.persistence.Column(name = "ENRSTAT")
    @Basic
    public String getEnrstat() {
        return enrstat;
    }

    public void setEnrstat(String enrstat) {
        this.enrstat = enrstat;
    }

    private String resstat;

    @javax.persistence.Column(name = "RESSTAT")
    @Basic
    public String getResstat() {
        return resstat;
    }

    public void setResstat(String resstat) {
        this.resstat = resstat;
    }

    private int tchrg;

    @javax.persistence.Column(name = "TCHRG")
    @Basic
    public int getTchrg() {
        return tchrg;
    }

    public void setTchrg(int tchrg) {
        this.tchrg = tchrg;
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

    private BigDecimal taidnb;

    @javax.persistence.Column(name = "TAIDNB")
    @Basic
    public BigDecimal getTaidnb() {
        return taidnb;
    }

    public void setTaidnb(BigDecimal taidnb) {
        this.taidnb = taidnb;
    }

    private BigDecimal taidnnb;

    @javax.persistence.Column(name = "TAIDNNB")
    @Basic
    public BigDecimal getTaidnnb() {
        return taidnnb;
    }

    public void setTaidnnb(BigDecimal taidnnb) {
        this.taidnnb = taidnnb;
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

    private String r2T4;

    @javax.persistence.Column(name = "R2T4")
    @Basic
    public String getR2T4() {
        return r2T4;
    }

    public void setR2T4(String r2T4) {
        this.r2T4 = r2T4;
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

    private String cmajor;

    @javax.persistence.Column(name = "CMAJOR")
    @Basic
    public String getCmajor() {
        return cmajor;
    }

    public void setCmajor(String cmajor) {
        this.cmajor = cmajor;
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

    private String divisn;

    @javax.persistence.Column(name = "DIVISN")
    @Basic
    public String getDivisn() {
        return divisn;
    }

    public void setDivisn(String divisn) {
        this.divisn = divisn;
    }

    private String enratt;

    @javax.persistence.Column(name = "ENRATT")
    @Basic
    public String getEnratt() {
        return enratt;
    }

    public void setEnratt(String enratt) {
        this.enratt = enratt;
    }

    private String regapty;

    @javax.persistence.Column(name = "REGAPTY")
    @Basic
    public String getRegapty() {
        return regapty;
    }

    public void setRegapty(String regapty) {
        this.regapty = regapty;
    }

    private String admapty;

    @javax.persistence.Column(name = "ADMAPTY")
    @Basic
    public String getAdmapty() {
        return admapty;
    }

    public void setAdmapty(String admapty) {
        this.admapty = admapty;
    }

    private String admapst;

    @javax.persistence.Column(name = "ADMAPST")
    @Basic
    public String getAdmapst() {
        return admapst;
    }

    public void setAdmapst(String admapst) {
        this.admapst = admapst;
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

    private BigDecimal cmhrstr;

    @javax.persistence.Column(name = "CMHRSTR")
    @Basic
    public BigDecimal getCmhrstr() {
        return cmhrstr;
    }

    public void setCmhrstr(BigDecimal cmhrstr) {
        this.cmhrstr = cmhrstr;
    }

    private String recprty;

    @javax.persistence.Column(name = "RECPRTY")
    @Basic
    public String getRecprty() {
        return recprty;
    }

    public void setRecprty(String recprty) {
        this.recprty = recprty;
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

    private String userdt1;

    @javax.persistence.Column(name = "USERDT1")
    @Basic
    public String getUserdt1() {
        return userdt1;
    }

    public void setUserdt1(String userdt1) {
        this.userdt1 = userdt1;
    }

    private String userdt2;

    @javax.persistence.Column(name = "USERDT2")
    @Basic
    public String getUserdt2() {
        return userdt2;
    }

    public void setUserdt2(String userdt2) {
        this.userdt2 = userdt2;
    }

    private String userdt3;

    @javax.persistence.Column(name = "USERDT3")
    @Basic
    public String getUserdt3() {
        return userdt3;
    }

    public void setUserdt3(String userdt3) {
        this.userdt3 = userdt3;
    }

    private String userdt4;

    @javax.persistence.Column(name = "USERDT4")
    @Basic
    public String getUserdt4() {
        return userdt4;
    }

    public void setUserdt4(String userdt4) {
        this.userdt4 = userdt4;
    }

    private BigDecimal fcmth;

    @javax.persistence.Column(name = "FCMTH")
    @Basic
    public BigDecimal getFcmth() {
        return fcmth;
    }

    public void setFcmth(BigDecimal fcmth) {
        this.fcmth = fcmth;
    }

    private BigDecimal fcmtho;

    @javax.persistence.Column(name = "FCMTHO")
    @Basic
    public BigDecimal getFcmtho() {
        return fcmtho;
    }

    public void setFcmtho(BigDecimal fcmtho) {
        this.fcmtho = fcmtho;
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

    private String hold1;

    @javax.persistence.Column(name = "HOLD1")
    @Basic
    public String getHold1() {
        return hold1;
    }

    public void setHold1(String hold1) {
        this.hold1 = hold1;
    }

    private BigDecimal efc;

    @javax.persistence.Column(name = "EFC")
    @Basic
    public BigDecimal getEfc() {
        return efc;
    }

    public void setEfc(BigDecimal efc) {
        this.efc = efc;
    }

    private BigDecimal ovrefc;

    @javax.persistence.Column(name = "OVREFC")
    @Basic
    public BigDecimal getOvrefc() {
        return ovrefc;
    }

    public void setOvrefc(BigDecimal ovrefc) {
        this.ovrefc = ovrefc;
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

    private String teach;

    @javax.persistence.Column(name = "TEACH")
    @Basic
    public String getTeach() {
        return teach;
    }

    public void setTeach(String teach) {
        this.teach = teach;
    }

    private String budenr;

    @javax.persistence.Column(name = "BUDENR")
    @Basic
    public String getBudenr() {
        return budenr;
    }

    public void setBudenr(String budenr) {
        this.budenr = budenr;
    }

    private String budlck;

    @javax.persistence.Column(name = "BUDLCK")
    @Basic
    public String getBudlck() {
        return budlck;
    }

    public void setBudlck(String budlck) {
        this.budlck = budlck;
    }

    private int dircost;

    @javax.persistence.Column(name = "DIRCOST")
    @Basic
    public int getDircost() {
        return dircost;
    }

    public void setDircost(int dircost) {
        this.dircost = dircost;
    }

    private String ahrstp1;

    @javax.persistence.Column(name = "AHRSTP1")
    @Basic
    public String getAhrstp1() {
        return ahrstp1;
    }

    public void setAhrstp1(String ahrstp1) {
        this.ahrstp1 = ahrstp1;
    }

    private String ahrstp2;

    @javax.persistence.Column(name = "AHRSTP2")
    @Basic
    public String getAhrstp2() {
        return ahrstp2;
    }

    public void setAhrstp2(String ahrstp2) {
        this.ahrstp2 = ahrstp2;
    }

    private String ahrstp3;

    @javax.persistence.Column(name = "AHRSTP3")
    @Basic
    public String getAhrstp3() {
        return ahrstp3;
    }

    public void setAhrstp3(String ahrstp3) {
        this.ahrstp3 = ahrstp3;
    }

    private String ahrstp4;

    @javax.persistence.Column(name = "AHRSTP4")
    @Basic
    public String getAhrstp4() {
        return ahrstp4;
    }

    public void setAhrstp4(String ahrstp4) {
        this.ahrstp4 = ahrstp4;
    }

    private String ahrstp5;

    @javax.persistence.Column(name = "AHRSTP5")
    @Basic
    public String getAhrstp5() {
        return ahrstp5;
    }

    public void setAhrstp5(String ahrstp5) {
        this.ahrstp5 = ahrstp5;
    }

    private String ahrstp6;

    @javax.persistence.Column(name = "AHRSTP6")
    @Basic
    public String getAhrstp6() {
        return ahrstp6;
    }

    public void setAhrstp6(String ahrstp6) {
        this.ahrstp6 = ahrstp6;
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

    private String stgel01;

    @javax.persistence.Column(name = "STGEL01")
    @Basic
    public String getStgel01() {
        return stgel01;
    }

    public void setStgel01(String stgel01) {
        this.stgel01 = stgel01;
    }

    private String sgucd01;

    @javax.persistence.Column(name = "SGUCD01")
    @Basic
    public String getSgucd01() {
        return sgucd01;
    }

    public void setSgucd01(String sgucd01) {
        this.sgucd01 = sgucd01;
    }

    private BigDecimal sguno01;

    @javax.persistence.Column(name = "SGUNO01")
    @Basic
    public BigDecimal getSguno01() {
        return sguno01;
    }

    public void setSguno01(BigDecimal sguno01) {
        this.sguno01 = sguno01;
    }

    private String stgel02;

    @javax.persistence.Column(name = "STGEL02")
    @Basic
    public String getStgel02() {
        return stgel02;
    }

    public void setStgel02(String stgel02) {
        this.stgel02 = stgel02;
    }

    private String sgucd02;

    @javax.persistence.Column(name = "SGUCD02")
    @Basic
    public String getSgucd02() {
        return sgucd02;
    }

    public void setSgucd02(String sgucd02) {
        this.sgucd02 = sgucd02;
    }

    private BigDecimal sguno02;

    @javax.persistence.Column(name = "SGUNO02")
    @Basic
    public BigDecimal getSguno02() {
        return sguno02;
    }

    public void setSguno02(BigDecimal sguno02) {
        this.sguno02 = sguno02;
    }

    private String stgel03;

    @javax.persistence.Column(name = "STGEL03")
    @Basic
    public String getStgel03() {
        return stgel03;
    }

    public void setStgel03(String stgel03) {
        this.stgel03 = stgel03;
    }

    private String sgucd03;

    @javax.persistence.Column(name = "SGUCD03")
    @Basic
    public String getSgucd03() {
        return sgucd03;
    }

    public void setSgucd03(String sgucd03) {
        this.sgucd03 = sgucd03;
    }

    private BigDecimal sguno03;

    @javax.persistence.Column(name = "SGUNO03")
    @Basic
    public BigDecimal getSguno03() {
        return sguno03;
    }

    public void setSguno03(BigDecimal sguno03) {
        this.sguno03 = sguno03;
    }

    private String stgel04;

    @javax.persistence.Column(name = "STGEL04")
    @Basic
    public String getStgel04() {
        return stgel04;
    }

    public void setStgel04(String stgel04) {
        this.stgel04 = stgel04;
    }

    private String sgucd04;

    @javax.persistence.Column(name = "SGUCD04")
    @Basic
    public String getSgucd04() {
        return sgucd04;
    }

    public void setSgucd04(String sgucd04) {
        this.sgucd04 = sgucd04;
    }

    private BigDecimal sguno04;

    @javax.persistence.Column(name = "SGUNO04")
    @Basic
    public BigDecimal getSguno04() {
        return sguno04;
    }

    public void setSguno04(BigDecimal sguno04) {
        this.sguno04 = sguno04;
    }

    private String stgel05;

    @javax.persistence.Column(name = "STGEL05")
    @Basic
    public String getStgel05() {
        return stgel05;
    }

    public void setStgel05(String stgel05) {
        this.stgel05 = stgel05;
    }

    private String sgucd05;

    @javax.persistence.Column(name = "SGUCD05")
    @Basic
    public String getSgucd05() {
        return sgucd05;
    }

    public void setSgucd05(String sgucd05) {
        this.sgucd05 = sgucd05;
    }

    private BigDecimal sguno05;

    @javax.persistence.Column(name = "SGUNO05")
    @Basic
    public BigDecimal getSguno05() {
        return sguno05;
    }

    public void setSguno05(BigDecimal sguno05) {
        this.sguno05 = sguno05;
    }

    private String stgel06;

    @javax.persistence.Column(name = "STGEL06")
    @Basic
    public String getStgel06() {
        return stgel06;
    }

    public void setStgel06(String stgel06) {
        this.stgel06 = stgel06;
    }

    private String sgucd06;

    @javax.persistence.Column(name = "SGUCD06")
    @Basic
    public String getSgucd06() {
        return sgucd06;
    }

    public void setSgucd06(String sgucd06) {
        this.sgucd06 = sgucd06;
    }

    private BigDecimal sguno06;

    @javax.persistence.Column(name = "SGUNO06")
    @Basic
    public BigDecimal getSguno06() {
        return sguno06;
    }

    public void setSguno06(BigDecimal sguno06) {
        this.sguno06 = sguno06;
    }

    private String stgel07;

    @javax.persistence.Column(name = "STGEL07")
    @Basic
    public String getStgel07() {
        return stgel07;
    }

    public void setStgel07(String stgel07) {
        this.stgel07 = stgel07;
    }

    private String sgucd07;

    @javax.persistence.Column(name = "SGUCD07")
    @Basic
    public String getSgucd07() {
        return sgucd07;
    }

    public void setSgucd07(String sgucd07) {
        this.sgucd07 = sgucd07;
    }

    private BigDecimal sguno07;

    @javax.persistence.Column(name = "SGUNO07")
    @Basic
    public BigDecimal getSguno07() {
        return sguno07;
    }

    public void setSguno07(BigDecimal sguno07) {
        this.sguno07 = sguno07;
    }

    private String stgel08;

    @javax.persistence.Column(name = "STGEL08")
    @Basic
    public String getStgel08() {
        return stgel08;
    }

    public void setStgel08(String stgel08) {
        this.stgel08 = stgel08;
    }

    private String sgucd08;

    @javax.persistence.Column(name = "SGUCD08")
    @Basic
    public String getSgucd08() {
        return sgucd08;
    }

    public void setSgucd08(String sgucd08) {
        this.sgucd08 = sgucd08;
    }

    private BigDecimal sguno08;

    @javax.persistence.Column(name = "SGUNO08")
    @Basic
    public BigDecimal getSguno08() {
        return sguno08;
    }

    public void setSguno08(BigDecimal sguno08) {
        this.sguno08 = sguno08;
    }

    private String stgel09;

    @javax.persistence.Column(name = "STGEL09")
    @Basic
    public String getStgel09() {
        return stgel09;
    }

    public void setStgel09(String stgel09) {
        this.stgel09 = stgel09;
    }

    private String sgucd09;

    @javax.persistence.Column(name = "SGUCD09")
    @Basic
    public String getSgucd09() {
        return sgucd09;
    }

    public void setSgucd09(String sgucd09) {
        this.sgucd09 = sgucd09;
    }

    private BigDecimal sguno09;

    @javax.persistence.Column(name = "SGUNO09")
    @Basic
    public BigDecimal getSguno09() {
        return sguno09;
    }

    public void setSguno09(BigDecimal sguno09) {
        this.sguno09 = sguno09;
    }

    private String stgel10;

    @javax.persistence.Column(name = "STGEL10")
    @Basic
    public String getStgel10() {
        return stgel10;
    }

    public void setStgel10(String stgel10) {
        this.stgel10 = stgel10;
    }

    private String sgucd10;

    @javax.persistence.Column(name = "SGUCD10")
    @Basic
    public String getSgucd10() {
        return sgucd10;
    }

    public void setSgucd10(String sgucd10) {
        this.sgucd10 = sgucd10;
    }

    private BigDecimal sguno10;

    @javax.persistence.Column(name = "SGUNO10")
    @Basic
    public BigDecimal getSguno10() {
        return sguno10;
    }

    public void setSguno10(BigDecimal sguno10) {
        this.sguno10 = sguno10;
    }

    private String stgel11;

    @javax.persistence.Column(name = "STGEL11")
    @Basic
    public String getStgel11() {
        return stgel11;
    }

    public void setStgel11(String stgel11) {
        this.stgel11 = stgel11;
    }

    private String sgucd11;

    @javax.persistence.Column(name = "SGUCD11")
    @Basic
    public String getSgucd11() {
        return sgucd11;
    }

    public void setSgucd11(String sgucd11) {
        this.sgucd11 = sgucd11;
    }

    private BigDecimal sguno11;

    @javax.persistence.Column(name = "SGUNO11")
    @Basic
    public BigDecimal getSguno11() {
        return sguno11;
    }

    public void setSguno11(BigDecimal sguno11) {
        this.sguno11 = sguno11;
    }

    private String stgel12;

    @javax.persistence.Column(name = "STGEL12")
    @Basic
    public String getStgel12() {
        return stgel12;
    }

    public void setStgel12(String stgel12) {
        this.stgel12 = stgel12;
    }

    private String sgucd12;

    @javax.persistence.Column(name = "SGUCD12")
    @Basic
    public String getSgucd12() {
        return sgucd12;
    }

    public void setSgucd12(String sgucd12) {
        this.sgucd12 = sgucd12;
    }

    private BigDecimal sguno12;

    @javax.persistence.Column(name = "SGUNO12")
    @Basic
    public BigDecimal getSguno12() {
        return sguno12;
    }

    public void setSguno12(BigDecimal sguno12) {
        this.sguno12 = sguno12;
    }

    private String stgel13;

    @javax.persistence.Column(name = "STGEL13")
    @Basic
    public String getStgel13() {
        return stgel13;
    }

    public void setStgel13(String stgel13) {
        this.stgel13 = stgel13;
    }

    private String sgucd13;

    @javax.persistence.Column(name = "SGUCD13")
    @Basic
    public String getSgucd13() {
        return sgucd13;
    }

    public void setSgucd13(String sgucd13) {
        this.sgucd13 = sgucd13;
    }

    private BigDecimal sguno13;

    @javax.persistence.Column(name = "SGUNO13")
    @Basic
    public BigDecimal getSguno13() {
        return sguno13;
    }

    public void setSguno13(BigDecimal sguno13) {
        this.sguno13 = sguno13;
    }

    private String stgel14;

    @javax.persistence.Column(name = "STGEL14")
    @Basic
    public String getStgel14() {
        return stgel14;
    }

    public void setStgel14(String stgel14) {
        this.stgel14 = stgel14;
    }

    private String sgucd14;

    @javax.persistence.Column(name = "SGUCD14")
    @Basic
    public String getSgucd14() {
        return sgucd14;
    }

    public void setSgucd14(String sgucd14) {
        this.sgucd14 = sgucd14;
    }

    private BigDecimal sguno14;

    @javax.persistence.Column(name = "SGUNO14")
    @Basic
    public BigDecimal getSguno14() {
        return sguno14;
    }

    public void setSguno14(BigDecimal sguno14) {
        this.sguno14 = sguno14;
    }

    private String stgel15;

    @javax.persistence.Column(name = "STGEL15")
    @Basic
    public String getStgel15() {
        return stgel15;
    }

    public void setStgel15(String stgel15) {
        this.stgel15 = stgel15;
    }

    private String sgucd15;

    @javax.persistence.Column(name = "SGUCD15")
    @Basic
    public String getSgucd15() {
        return sgucd15;
    }

    public void setSgucd15(String sgucd15) {
        this.sgucd15 = sgucd15;
    }

    private BigDecimal sguno15;

    @javax.persistence.Column(name = "SGUNO15")
    @Basic
    public BigDecimal getSguno15() {
        return sguno15;
    }

    public void setSguno15(BigDecimal sguno15) {
        this.sguno15 = sguno15;
    }

    private String stgel16;

    @javax.persistence.Column(name = "STGEL16")
    @Basic
    public String getStgel16() {
        return stgel16;
    }

    public void setStgel16(String stgel16) {
        this.stgel16 = stgel16;
    }

    private String sgucd16;

    @javax.persistence.Column(name = "SGUCD16")
    @Basic
    public String getSgucd16() {
        return sgucd16;
    }

    public void setSgucd16(String sgucd16) {
        this.sgucd16 = sgucd16;
    }

    private BigDecimal sguno16;

    @javax.persistence.Column(name = "SGUNO16")
    @Basic
    public BigDecimal getSguno16() {
        return sguno16;
    }

    public void setSguno16(BigDecimal sguno16) {
        this.sguno16 = sguno16;
    }

    private String stgel17;

    @javax.persistence.Column(name = "STGEL17")
    @Basic
    public String getStgel17() {
        return stgel17;
    }

    public void setStgel17(String stgel17) {
        this.stgel17 = stgel17;
    }

    private String sgucd17;

    @javax.persistence.Column(name = "SGUCD17")
    @Basic
    public String getSgucd17() {
        return sgucd17;
    }

    public void setSgucd17(String sgucd17) {
        this.sgucd17 = sgucd17;
    }

    private BigDecimal sguno17;

    @javax.persistence.Column(name = "SGUNO17")
    @Basic
    public BigDecimal getSguno17() {
        return sguno17;
    }

    public void setSguno17(BigDecimal sguno17) {
        this.sguno17 = sguno17;
    }

    private String stgel18;

    @javax.persistence.Column(name = "STGEL18")
    @Basic
    public String getStgel18() {
        return stgel18;
    }

    public void setStgel18(String stgel18) {
        this.stgel18 = stgel18;
    }

    private String sgucd18;

    @javax.persistence.Column(name = "SGUCD18")
    @Basic
    public String getSgucd18() {
        return sgucd18;
    }

    public void setSgucd18(String sgucd18) {
        this.sgucd18 = sgucd18;
    }

    private BigDecimal sguno18;

    @javax.persistence.Column(name = "SGUNO18")
    @Basic
    public BigDecimal getSguno18() {
        return sguno18;
    }

    public void setSguno18(BigDecimal sguno18) {
        this.sguno18 = sguno18;
    }

    private String stgel19;

    @javax.persistence.Column(name = "STGEL19")
    @Basic
    public String getStgel19() {
        return stgel19;
    }

    public void setStgel19(String stgel19) {
        this.stgel19 = stgel19;
    }

    private String sgucd19;

    @javax.persistence.Column(name = "SGUCD19")
    @Basic
    public String getSgucd19() {
        return sgucd19;
    }

    public void setSgucd19(String sgucd19) {
        this.sgucd19 = sgucd19;
    }

    private BigDecimal sguno19;

    @javax.persistence.Column(name = "SGUNO19")
    @Basic
    public BigDecimal getSguno19() {
        return sguno19;
    }

    public void setSguno19(BigDecimal sguno19) {
        this.sguno19 = sguno19;
    }

    private String stgel20;

    @javax.persistence.Column(name = "STGEL20")
    @Basic
    public String getStgel20() {
        return stgel20;
    }

    public void setStgel20(String stgel20) {
        this.stgel20 = stgel20;
    }

    private String sgucd20;

    @javax.persistence.Column(name = "SGUCD20")
    @Basic
    public String getSgucd20() {
        return sgucd20;
    }

    public void setSgucd20(String sgucd20) {
        this.sgucd20 = sgucd20;
    }

    private BigDecimal sguno20;

    @javax.persistence.Column(name = "SGUNO20")
    @Basic
    public BigDecimal getSguno20() {
        return sguno20;
    }

    public void setSguno20(BigDecimal sguno20) {
        this.sguno20 = sguno20;
    }

    private BigDecimal caacar;

    @javax.persistence.Column(name = "CAACAR")
    @Basic
    public BigDecimal getCaacar() {
        return caacar;
    }

    public void setCaacar(BigDecimal caacar) {
        this.caacar = caacar;
    }

    private String caacpr;

    @javax.persistence.Column(name = "CAACPR")
    @Basic
    public String getCaacpr() {
        return caacpr;
    }

    public void setCaacpr(String caacpr) {
        this.caacpr = caacpr;
    }

    private BigDecimal catfar;

    @javax.persistence.Column(name = "CATFAR")
    @Basic
    public BigDecimal getCatfar() {
        return catfar;
    }

    public void setCatfar(BigDecimal catfar) {
        this.catfar = catfar;
    }

    private String catfpr;

    @javax.persistence.Column(name = "CATFPR")
    @Basic
    public String getCatfpr() {
        return catfpr;
    }

    public void setCatfpr(String catfpr) {
        this.catfpr = catfpr;
    }

    private BigDecimal cattar;

    @javax.persistence.Column(name = "CATTAR")
    @Basic
    public BigDecimal getCattar() {
        return cattar;
    }

    public void setCattar(BigDecimal cattar) {
        this.cattar = cattar;
    }

    private int totstaf;

    @javax.persistence.Column(name = "TOTSTAF")
    @Basic
    public int getTotstaf() {
        return totstaf;
    }

    public void setTotstaf(int totstaf) {
        this.totstaf = totstaf;
    }

    private int totusub;

    @javax.persistence.Column(name = "TOTUSUB")
    @Basic
    public int getTotusub() {
        return totusub;
    }

    public void setTotusub(int totusub) {
        this.totusub = totusub;
    }

    private int totperk;

    @javax.persistence.Column(name = "TOTPERK")
    @Basic
    public int getTotperk() {
        return totperk;
    }

    public void setTotperk(int totperk) {
        this.totperk = totperk;
    }

    private int totplus;

    @javax.persistence.Column(name = "TOTPLUS")
    @Basic
    public int getTotplus() {
        return totplus;
    }

    public void setTotplus(int totplus) {
        this.totplus = totplus;
    }

    private String budfrz;

    @javax.persistence.Column(name = "BUDFRZ")
    @Basic
    public String getBudfrz() {
        return budfrz;
    }

    public void setBudfrz(String budfrz) {
        this.budfrz = budfrz;
    }

    private String hold2;

    @javax.persistence.Column(name = "HOLD2")
    @Basic
    public String getHold2() {
        return hold2;
    }

    public void setHold2(String hold2) {
        this.hold2 = hold2;
    }

    private String hold3;

    @javax.persistence.Column(name = "HOLD3")
    @Basic
    public String getHold3() {
        return hold3;
    }

    public void setHold3(String hold3) {
        this.hold3 = hold3;
    }

    private String hold4;

    @javax.persistence.Column(name = "HOLD4")
    @Basic
    public String getHold4() {
        return hold4;
    }

    public void setHold4(String hold4) {
        this.hold4 = hold4;
    }

    private String hold5;

    @javax.persistence.Column(name = "HOLD5")
    @Basic
    public String getHold5() {
        return hold5;
    }

    public void setHold5(String hold5) {
        this.hold5 = hold5;
    }

    private String hold6;

    @javax.persistence.Column(name = "HOLD6")
    @Basic
    public String getHold6() {
        return hold6;
    }

    public void setHold6(String hold6) {
        this.hold6 = hold6;
    }

    private String prgchk;

    @javax.persistence.Column(name = "PRGCHK")
    @Basic
    public String getPrgchk() {
        return prgchk;
    }

    public void setPrgchk(String prgchk) {
        this.prgchk = prgchk;
    }

    private String hrsdt1;

    @javax.persistence.Column(name = "HRSDT1")
    @Basic
    public String getHrsdt1() {
        return hrsdt1;
    }

    public void setHrsdt1(String hrsdt1) {
        this.hrsdt1 = hrsdt1;
    }

    private String hrsdt2;

    @javax.persistence.Column(name = "HRSDT2")
    @Basic
    public String getHrsdt2() {
        return hrsdt2;
    }

    public void setHrsdt2(String hrsdt2) {
        this.hrsdt2 = hrsdt2;
    }

    private String hrsdt3;

    @javax.persistence.Column(name = "HRSDT3")
    @Basic
    public String getHrsdt3() {
        return hrsdt3;
    }

    public void setHrsdt3(String hrsdt3) {
        this.hrsdt3 = hrsdt3;
    }

    private String hrsdt4;

    @javax.persistence.Column(name = "HRSDT4")
    @Basic
    public String getHrsdt4() {
        return hrsdt4;
    }

    public void setHrsdt4(String hrsdt4) {
        this.hrsdt4 = hrsdt4;
    }

    private String hrsdt5;

    @javax.persistence.Column(name = "HRSDT5")
    @Basic
    public String getHrsdt5() {
        return hrsdt5;
    }

    public void setHrsdt5(String hrsdt5) {
        this.hrsdt5 = hrsdt5;
    }

    private String hrsdt6;

    @javax.persistence.Column(name = "HRSDT6")
    @Basic
    public String getHrsdt6() {
        return hrsdt6;
    }

    public void setHrsdt6(String hrsdt6) {
        this.hrsdt6 = hrsdt6;
    }

    private BigDecimal tcrsfee;

    @javax.persistence.Column(name = "TCRSFEE")
    @Basic
    public BigDecimal getTcrsfee() {
        return tcrsfee;
    }

    public void setTcrsfee(BigDecimal tcrsfee) {
        this.tcrsfee = tcrsfee;
    }

    private BigDecimal tcmpfee;

    @javax.persistence.Column(name = "TCMPFEE")
    @Basic
    public BigDecimal getTcmpfee() {
        return tcmpfee;
    }

    public void setTcmpfee(BigDecimal tcmpfee) {
        this.tcmpfee = tcmpfee;
    }

    private BigDecimal tprgfee;

    @javax.persistence.Column(name = "TPRGFEE")
    @Basic
    public BigDecimal getTprgfee() {
        return tprgfee;
    }

    public void setTprgfee(BigDecimal tprgfee) {
        this.tprgfee = tprgfee;
    }

    private BigDecimal tothfee;

    @javax.persistence.Column(name = "TOTHFEE")
    @Basic
    public BigDecimal getTothfee() {
        return tothfee;
    }

    public void setTothfee(BigDecimal tothfee) {
        this.tothfee = tothfee;
    }

    private BigDecimal tallfee;

    @javax.persistence.Column(name = "TALLFEE")
    @Basic
    public BigDecimal getTallfee() {
        return tallfee;
    }

    public void setTallfee(BigDecimal tallfee) {
        this.tallfee = tallfee;
    }

    private BigDecimal tugcfee;

    @javax.persistence.Column(name = "TUGCFEE")
    @Basic
    public BigDecimal getTugcfee() {
        return tugcfee;
    }

    public void setTugcfee(BigDecimal tugcfee) {
        this.tugcfee = tugcfee;
    }

    private BigDecimal tgrcfee;

    @javax.persistence.Column(name = "TGRCFEE")
    @Basic
    public BigDecimal getTgrcfee() {
        return tgrcfee;
    }

    public void setTgrcfee(BigDecimal tgrcfee) {
        this.tgrcfee = tgrcfee;
    }

    private BigDecimal tuglexp;

    @javax.persistence.Column(name = "TUGLEXP")
    @Basic
    public BigDecimal getTuglexp() {
        return tuglexp;
    }

    public void setTuglexp(BigDecimal tuglexp) {
        this.tuglexp = tuglexp;
    }

    private BigDecimal tgrlexp;

    @javax.persistence.Column(name = "TGRLEXP")
    @Basic
    public BigDecimal getTgrlexp() {
        return tgrlexp;
    }

    public void setTgrlexp(BigDecimal tgrlexp) {
        this.tgrlexp = tgrlexp;
    }

    private BigDecimal cmprte;

    @javax.persistence.Column(name = "CMPRTE")
    @Basic
    public BigDecimal getCmprte() {
        return cmprte;
    }

    public void setCmprte(BigDecimal cmprte) {
        this.cmprte = cmprte;
    }

    private BigDecimal cumahrs;

    @javax.persistence.Column(name = "CUMAHRS")
    @Basic
    public BigDecimal getCumahrs() {
        return cumahrs;
    }

    public void setCumahrs(BigDecimal cumahrs) {
        this.cumahrs = cumahrs;
    }

    private String exgdrq;

    @javax.persistence.Column(name = "EXGDRQ")
    @Basic
    public String getExgdrq() {
        return exgdrq;
    }

    public void setExgdrq(String exgdrq) {
        this.exgdrq = exgdrq;
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

    private BigDecimal taidcb;

    @javax.persistence.Column(name = "TAIDCB")
    @Basic
    public BigDecimal getTaidcb() {
        return taidcb;
    }

    public void setTaidcb(BigDecimal taidcb) {
        this.taidcb = taidcb;
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

    private BigDecimal punneed;

    @javax.persistence.Column(name = "PUNNEED")
    @Basic
    public BigDecimal getPunneed() {
        return punneed;
    }

    public void setPunneed(BigDecimal punneed) {
        this.punneed = punneed;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SutEntity sutEntity = (SutEntity) o;

        if (dircost != sutEntity.dircost) return false;
        if (groneed != sutEntity.groneed) return false;
        if (instefc != sutEntity.instefc) return false;
        if (instpc != sutEntity.instpc) return false;
        if (instsc != sutEntity.instsc) return false;
        if (revlev != sutEntity.revlev) return false;
        if (tchrg != sutEntity.tchrg) return false;
        if (totperk != sutEntity.totperk) return false;
        if (totplus != sutEntity.totplus) return false;
        if (totstaf != sutEntity.totstaf) return false;
        if (totusub != sutEntity.totusub) return false;
        if (usernr1 != sutEntity.usernr1) return false;
        if (usernr2 != sutEntity.usernr2) return false;
        if (usernr3 != sutEntity.usernr3) return false;
        if (usernr4 != sutEntity.usernr4) return false;
        if (usernr5 != sutEntity.usernr5) return false;
        if (acprog != null ? !acprog.equals(sutEntity.acprog) : sutEntity.acprog != null) return false;
        if (acprre != null ? !acprre.equals(sutEntity.acprre) : sutEntity.acprre != null) return false;
        if (acptdte != null ? !acptdte.equals(sutEntity.acptdte) : sutEntity.acptdte != null) return false;
        if (admapst != null ? !admapst.equals(sutEntity.admapst) : sutEntity.admapst != null) return false;
        if (admapty != null ? !admapty.equals(sutEntity.admapty) : sutEntity.admapty != null) return false;
        if (admstat != null ? !admstat.equals(sutEntity.admstat) : sutEntity.admstat != null) return false;
        if (aenrlt != null ? !aenrlt.equals(sutEntity.aenrlt) : sutEntity.aenrlt != null) return false;
        if (agncysp != null ? !agncysp.equals(sutEntity.agncysp) : sutEntity.agncysp != null) return false;
        if (ahrstp1 != null ? !ahrstp1.equals(sutEntity.ahrstp1) : sutEntity.ahrstp1 != null) return false;
        if (ahrstp2 != null ? !ahrstp2.equals(sutEntity.ahrstp2) : sutEntity.ahrstp2 != null) return false;
        if (ahrstp3 != null ? !ahrstp3.equals(sutEntity.ahrstp3) : sutEntity.ahrstp3 != null) return false;
        if (ahrstp4 != null ? !ahrstp4.equals(sutEntity.ahrstp4) : sutEntity.ahrstp4 != null) return false;
        if (ahrstp5 != null ? !ahrstp5.equals(sutEntity.ahrstp5) : sutEntity.ahrstp5 != null) return false;
        if (ahrstp6 != null ? !ahrstp6.equals(sutEntity.ahrstp6) : sutEntity.ahrstp6 != null) return false;
        if (aidyr != null ? !aidyr.equals(sutEntity.aidyr) : sutEntity.aidyr != null) return false;
        if (appbeg != null ? !appbeg.equals(sutEntity.appbeg) : sutEntity.appbeg != null) return false;
        if (append != null ? !append.equals(sutEntity.append) : sutEntity.append != null) return false;
        if (athlet1 != null ? !athlet1.equals(sutEntity.athlet1) : sutEntity.athlet1 != null) return false;
        if (athlet2 != null ? !athlet2.equals(sutEntity.athlet2) : sutEntity.athlet2 != null) return false;
        if (atmhrs != null ? !atmhrs.equals(sutEntity.atmhrs) : sutEntity.atmhrs != null) return false;
        if (btrack != null ? !btrack.equals(sutEntity.btrack) : sutEntity.btrack != null) return false;
        if (budenr != null ? !budenr.equals(sutEntity.budenr) : sutEntity.budenr != null) return false;
        if (budfrz != null ? !budfrz.equals(sutEntity.budfrz) : sutEntity.budfrz != null) return false;
        if (budlck != null ? !budlck.equals(sutEntity.budlck) : sutEntity.budlck != null) return false;
        if (caacar != null ? !caacar.equals(sutEntity.caacar) : sutEntity.caacar != null) return false;
        if (caacpr != null ? !caacpr.equals(sutEntity.caacpr) : sutEntity.caacpr != null) return false;
        if (catfar != null ? !catfar.equals(sutEntity.catfar) : sutEntity.catfar != null) return false;
        if (catfpr != null ? !catfpr.equals(sutEntity.catfpr) : sutEntity.catfpr != null) return false;
        if (cattar != null ? !cattar.equals(sutEntity.cattar) : sutEntity.cattar != null) return false;
        if (classiv != null ? !classiv.equals(sutEntity.classiv) : sutEntity.classiv != null) return false;
        if (clazz != null ? !clazz.equals(sutEntity.clazz) : sutEntity.clazz != null) return false;
        if (cmajor != null ? !cmajor.equals(sutEntity.cmajor) : sutEntity.cmajor != null) return false;
        if (cmhrsca != null ? !cmhrsca.equals(sutEntity.cmhrsca) : sutEntity.cmhrsca != null) return false;
        if (cmhrsco != null ? !cmhrsco.equals(sutEntity.cmhrsco) : sutEntity.cmhrsco != null) return false;
        if (cmhrsdf != null ? !cmhrsdf.equals(sutEntity.cmhrsdf) : sutEntity.cmhrsdf != null) return false;
        if (cmhrstr != null ? !cmhrstr.equals(sutEntity.cmhrstr) : sutEntity.cmhrstr != null) return false;
        if (cmprte != null ? !cmprte.equals(sutEntity.cmprte) : sutEntity.cmprte != null) return false;
        if (commdte != null ? !commdte.equals(sutEntity.commdte) : sutEntity.commdte != null) return false;
        if (crtdate != null ? !crtdate.equals(sutEntity.crtdate) : sutEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(sutEntity.crtmod) : sutEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(sutEntity.crttime) : sutEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(sutEntity.crtuser) : sutEntity.crtuser != null) return false;
        if (cstat != null ? !cstat.equals(sutEntity.cstat) : sutEntity.cstat != null) return false;
        if (cuhrsca != null ? !cuhrsca.equals(sutEntity.cuhrsca) : sutEntity.cuhrsca != null) return false;
        if (cuhrsco != null ? !cuhrsco.equals(sutEntity.cuhrsco) : sutEntity.cuhrsco != null) return false;
        if (cumahrs != null ? !cumahrs.equals(sutEntity.cumahrs) : sutEntity.cumahrs != null) return false;
        if (cumgpa != null ? !cumgpa.equals(sutEntity.cumgpa) : sutEntity.cumgpa != null) return false;
        if (currfst != null ? !currfst.equals(sutEntity.currfst) : sutEntity.currfst != null) return false;
        if (depst != null ? !depst.equals(sutEntity.depst) : sutEntity.depst != null) return false;
        if (dept != null ? !dept.equals(sutEntity.dept) : sutEntity.dept != null) return false;
        if (disbdte != null ? !disbdte.equals(sutEntity.disbdte) : sutEntity.disbdte != null) return false;
        if (disbs1 != null ? !disbs1.equals(sutEntity.disbs1) : sutEntity.disbs1 != null) return false;
        if (disbs10 != null ? !disbs10.equals(sutEntity.disbs10) : sutEntity.disbs10 != null) return false;
        if (disbs2 != null ? !disbs2.equals(sutEntity.disbs2) : sutEntity.disbs2 != null) return false;
        if (disbs3 != null ? !disbs3.equals(sutEntity.disbs3) : sutEntity.disbs3 != null) return false;
        if (disbs4 != null ? !disbs4.equals(sutEntity.disbs4) : sutEntity.disbs4 != null) return false;
        if (disbs5 != null ? !disbs5.equals(sutEntity.disbs5) : sutEntity.disbs5 != null) return false;
        if (disbs6 != null ? !disbs6.equals(sutEntity.disbs6) : sutEntity.disbs6 != null) return false;
        if (disbs7 != null ? !disbs7.equals(sutEntity.disbs7) : sutEntity.disbs7 != null) return false;
        if (disbs8 != null ? !disbs8.equals(sutEntity.disbs8) : sutEntity.disbs8 != null) return false;
        if (disbs9 != null ? !disbs9.equals(sutEntity.disbs9) : sutEntity.disbs9 != null) return false;
        if (disst1 != null ? !disst1.equals(sutEntity.disst1) : sutEntity.disst1 != null) return false;
        if (disst10 != null ? !disst10.equals(sutEntity.disst10) : sutEntity.disst10 != null) return false;
        if (disst2 != null ? !disst2.equals(sutEntity.disst2) : sutEntity.disst2 != null) return false;
        if (disst3 != null ? !disst3.equals(sutEntity.disst3) : sutEntity.disst3 != null) return false;
        if (disst4 != null ? !disst4.equals(sutEntity.disst4) : sutEntity.disst4 != null) return false;
        if (disst5 != null ? !disst5.equals(sutEntity.disst5) : sutEntity.disst5 != null) return false;
        if (disst6 != null ? !disst6.equals(sutEntity.disst6) : sutEntity.disst6 != null) return false;
        if (disst7 != null ? !disst7.equals(sutEntity.disst7) : sutEntity.disst7 != null) return false;
        if (disst8 != null ? !disst8.equals(sutEntity.disst8) : sutEntity.disst8 != null) return false;
        if (disst9 != null ? !disst9.equals(sutEntity.disst9) : sutEntity.disst9 != null) return false;
        if (divisn != null ? !divisn.equals(sutEntity.divisn) : sutEntity.divisn != null) return false;
        if (dsenrl != null ? !dsenrl.equals(sutEntity.dsenrl) : sutEntity.dsenrl != null) return false;
        if (dstat != null ? !dstat.equals(sutEntity.dstat) : sutEntity.dstat != null) return false;
        if (ecampus != null ? !ecampus.equals(sutEntity.ecampus) : sutEntity.ecampus != null) return false;
        if (efc != null ? !efc.equals(sutEntity.efc) : sutEntity.efc != null) return false;
        if (enratt != null ? !enratt.equals(sutEntity.enratt) : sutEntity.enratt != null) return false;
        if (enrlst1 != null ? !enrlst1.equals(sutEntity.enrlst1) : sutEntity.enrlst1 != null) return false;
        if (enrlst2 != null ? !enrlst2.equals(sutEntity.enrlst2) : sutEntity.enrlst2 != null) return false;
        if (enrlst3 != null ? !enrlst3.equals(sutEntity.enrlst3) : sutEntity.enrlst3 != null) return false;
        if (enrlst4 != null ? !enrlst4.equals(sutEntity.enrlst4) : sutEntity.enrlst4 != null) return false;
        if (enrlst5 != null ? !enrlst5.equals(sutEntity.enrlst5) : sutEntity.enrlst5 != null) return false;
        if (enrlst6 != null ? !enrlst6.equals(sutEntity.enrlst6) : sutEntity.enrlst6 != null) return false;
        if (enrscd != null ? !enrscd.equals(sutEntity.enrscd) : sutEntity.enrscd != null) return false;
        if (enrstat != null ? !enrstat.equals(sutEntity.enrstat) : sutEntity.enrstat != null) return false;
        if (enrtyp != null ? !enrtyp.equals(sutEntity.enrtyp) : sutEntity.enrtyp != null) return false;
        if (enrtyp1 != null ? !enrtyp1.equals(sutEntity.enrtyp1) : sutEntity.enrtyp1 != null) return false;
        if (enrtyp2 != null ? !enrtyp2.equals(sutEntity.enrtyp2) : sutEntity.enrtyp2 != null) return false;
        if (enrtyp3 != null ? !enrtyp3.equals(sutEntity.enrtyp3) : sutEntity.enrtyp3 != null) return false;
        if (enrtyp4 != null ? !enrtyp4.equals(sutEntity.enrtyp4) : sutEntity.enrtyp4 != null) return false;
        if (enrtyp5 != null ? !enrtyp5.equals(sutEntity.enrtyp5) : sutEntity.enrtyp5 != null) return false;
        if (enrtyp6 != null ? !enrtyp6.equals(sutEntity.enrtyp6) : sutEntity.enrtyp6 != null) return false;
        if (estat != null ? !estat.equals(sutEntity.estat) : sutEntity.estat != null) return false;
        if (evalclr != null ? !evalclr.equals(sutEntity.evalclr) : sutEntity.evalclr != null) return false;
        if (evaldte != null ? !evaldte.equals(sutEntity.evaldte) : sutEntity.evaldte != null) return false;
        if (exgdrq != null ? !exgdrq.equals(sutEntity.exgdrq) : sutEntity.exgdrq != null) return false;
        if (fcmth != null ? !fcmth.equals(sutEntity.fcmth) : sutEntity.fcmth != null) return false;
        if (fcmtho != null ? !fcmtho.equals(sutEntity.fcmtho) : sutEntity.fcmtho != null) return false;
        if (feecat1 != null ? !feecat1.equals(sutEntity.feecat1) : sutEntity.feecat1 != null) return false;
        if (feecat2 != null ? !feecat2.equals(sutEntity.feecat2) : sutEntity.feecat2 != null) return false;
        if (feecat3 != null ? !feecat3.equals(sutEntity.feecat3) : sutEntity.feecat3 != null) return false;
        if (feecat4 != null ? !feecat4.equals(sutEntity.feecat4) : sutEntity.feecat4 != null) return false;
        if (feecat5 != null ? !feecat5.equals(sutEntity.feecat5) : sutEntity.feecat5 != null) return false;
        if (gpa != null ? !gpa.equals(sutEntity.gpa) : sutEntity.gpa != null) return false;
        if (gslbud != null ? !gslbud.equals(sutEntity.gslbud) : sutEntity.gslbud != null) return false;
        if (hold1 != null ? !hold1.equals(sutEntity.hold1) : sutEntity.hold1 != null) return false;
        if (hold2 != null ? !hold2.equals(sutEntity.hold2) : sutEntity.hold2 != null) return false;
        if (hold3 != null ? !hold3.equals(sutEntity.hold3) : sutEntity.hold3 != null) return false;
        if (hold4 != null ? !hold4.equals(sutEntity.hold4) : sutEntity.hold4 != null) return false;
        if (hold5 != null ? !hold5.equals(sutEntity.hold5) : sutEntity.hold5 != null) return false;
        if (hold6 != null ? !hold6.equals(sutEntity.hold6) : sutEntity.hold6 != null) return false;
        if (hrsdt1 != null ? !hrsdt1.equals(sutEntity.hrsdt1) : sutEntity.hrsdt1 != null) return false;
        if (hrsdt2 != null ? !hrsdt2.equals(sutEntity.hrsdt2) : sutEntity.hrsdt2 != null) return false;
        if (hrsdt3 != null ? !hrsdt3.equals(sutEntity.hrsdt3) : sutEntity.hrsdt3 != null) return false;
        if (hrsdt4 != null ? !hrsdt4.equals(sutEntity.hrsdt4) : sutEntity.hrsdt4 != null) return false;
        if (hrsdt5 != null ? !hrsdt5.equals(sutEntity.hrsdt5) : sutEntity.hrsdt5 != null) return false;
        if (hrsdt6 != null ? !hrsdt6.equals(sutEntity.hrsdt6) : sutEntity.hrsdt6 != null) return false;
        if (hrsnum1 != null ? !hrsnum1.equals(sutEntity.hrsnum1) : sutEntity.hrsnum1 != null) return false;
        if (hrsnum2 != null ? !hrsnum2.equals(sutEntity.hrsnum2) : sutEntity.hrsnum2 != null) return false;
        if (hrsnum3 != null ? !hrsnum3.equals(sutEntity.hrsnum3) : sutEntity.hrsnum3 != null) return false;
        if (hrsnum4 != null ? !hrsnum4.equals(sutEntity.hrsnum4) : sutEntity.hrsnum4 != null) return false;
        if (hrsnum5 != null ? !hrsnum5.equals(sutEntity.hrsnum5) : sutEntity.hrsnum5 != null) return false;
        if (hrsnum6 != null ? !hrsnum6.equals(sutEntity.hrsnum6) : sutEntity.hrsnum6 != null) return false;
        if (hrstyp1 != null ? !hrstyp1.equals(sutEntity.hrstyp1) : sutEntity.hrstyp1 != null) return false;
        if (hrstyp2 != null ? !hrstyp2.equals(sutEntity.hrstyp2) : sutEntity.hrstyp2 != null) return false;
        if (hrstyp3 != null ? !hrstyp3.equals(sutEntity.hrstyp3) : sutEntity.hrstyp3 != null) return false;
        if (hrstyp4 != null ? !hrstyp4.equals(sutEntity.hrstyp4) : sutEntity.hrstyp4 != null) return false;
        if (hrstyp5 != null ? !hrstyp5.equals(sutEntity.hrstyp5) : sutEntity.hrstyp5 != null) return false;
        if (hrstyp6 != null ? !hrstyp6.equals(sutEntity.hrstyp6) : sutEntity.hrstyp6 != null) return false;
        if (incflag != null ? !incflag.equals(sutEntity.incflag) : sutEntity.incflag != null) return false;
        if (needdte != null ? !needdte.equals(sutEntity.needdte) : sutEntity.needdte != null) return false;
        if (netneed != null ? !netneed.equals(sutEntity.netneed) : sutEntity.netneed != null) return false;
        if (notfdte != null ? !notfdte.equals(sutEntity.notfdte) : sutEntity.notfdte != null) return false;
        if (nstat != null ? !nstat.equals(sutEntity.nstat) : sutEntity.nstat != null) return false;
        if (overbud != null ? !overbud.equals(sutEntity.overbud) : sutEntity.overbud != null) return false;
        if (overgsl != null ? !overgsl.equals(sutEntity.overgsl) : sutEntity.overgsl != null) return false;
        if (ovrefc != null ? !ovrefc.equals(sutEntity.ovrefc) : sutEntity.ovrefc != null) return false;
        if (ovrpell != null ? !ovrpell.equals(sutEntity.ovrpell) : sutEntity.ovrpell != null) return false;
        if (pacdlvl != null ? !pacdlvl.equals(sutEntity.pacdlvl) : sutEntity.pacdlvl != null) return false;
        if (packdte != null ? !packdte.equals(sutEntity.packdte) : sutEntity.packdte != null) return false;
        if (packgrp != null ? !packgrp.equals(sutEntity.packgrp) : sutEntity.packgrp != null) return false;
        if (pdegree != null ? !pdegree.equals(sutEntity.pdegree) : sutEntity.pdegree != null) return false;
        if (pellbud != null ? !pellbud.equals(sutEntity.pellbud) : sutEntity.pellbud != null) return false;
        if (penrlt != null ? !penrlt.equals(sutEntity.penrlt) : sutEntity.penrlt != null) return false;
        if (pkenrl != null ? !pkenrl.equals(sutEntity.pkenrl) : sutEntity.pkenrl != null) return false;
        if (pmajor != null ? !pmajor.equals(sutEntity.pmajor) : sutEntity.pmajor != null) return false;
        if (prgchk != null ? !prgchk.equals(sutEntity.prgchk) : sutEntity.prgchk != null) return false;
        if (procno != null ? !procno.equals(sutEntity.procno) : sutEntity.procno != null) return false;
        if (pschool != null ? !pschool.equals(sutEntity.pschool) : sutEntity.pschool != null) return false;
        if (pstat != null ? !pstat.equals(sutEntity.pstat) : sutEntity.pstat != null) return false;
        if (punneed != null ? !punneed.equals(sutEntity.punneed) : sutEntity.punneed != null) return false;
        if (r2T4 != null ? !r2T4.equals(sutEntity.r2T4) : sutEntity.r2T4 != null) return false;
        if (recprty != null ? !recprty.equals(sutEntity.recprty) : sutEntity.recprty != null) return false;
        if (recstat != null ? !recstat.equals(sutEntity.recstat) : sutEntity.recstat != null) return false;
        if (regapty != null ? !regapty.equals(sutEntity.regapty) : sutEntity.regapty != null) return false;
        if (resstat != null ? !resstat.equals(sutEntity.resstat) : sutEntity.resstat != null) return false;
        if (revdate != null ? !revdate.equals(sutEntity.revdate) : sutEntity.revdate != null) return false;
        if (revmod != null ? !revmod.equals(sutEntity.revmod) : sutEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(sutEntity.revtime) : sutEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(sutEntity.revuser) : sutEntity.revuser != null) return false;
        if (sbudget != null ? !sbudget.equals(sutEntity.sbudget) : sutEntity.sbudget != null) return false;
        if (sgucd01 != null ? !sgucd01.equals(sutEntity.sgucd01) : sutEntity.sgucd01 != null) return false;
        if (sgucd02 != null ? !sgucd02.equals(sutEntity.sgucd02) : sutEntity.sgucd02 != null) return false;
        if (sgucd03 != null ? !sgucd03.equals(sutEntity.sgucd03) : sutEntity.sgucd03 != null) return false;
        if (sgucd04 != null ? !sgucd04.equals(sutEntity.sgucd04) : sutEntity.sgucd04 != null) return false;
        if (sgucd05 != null ? !sgucd05.equals(sutEntity.sgucd05) : sutEntity.sgucd05 != null) return false;
        if (sgucd06 != null ? !sgucd06.equals(sutEntity.sgucd06) : sutEntity.sgucd06 != null) return false;
        if (sgucd07 != null ? !sgucd07.equals(sutEntity.sgucd07) : sutEntity.sgucd07 != null) return false;
        if (sgucd08 != null ? !sgucd08.equals(sutEntity.sgucd08) : sutEntity.sgucd08 != null) return false;
        if (sgucd09 != null ? !sgucd09.equals(sutEntity.sgucd09) : sutEntity.sgucd09 != null) return false;
        if (sgucd10 != null ? !sgucd10.equals(sutEntity.sgucd10) : sutEntity.sgucd10 != null) return false;
        if (sgucd11 != null ? !sgucd11.equals(sutEntity.sgucd11) : sutEntity.sgucd11 != null) return false;
        if (sgucd12 != null ? !sgucd12.equals(sutEntity.sgucd12) : sutEntity.sgucd12 != null) return false;
        if (sgucd13 != null ? !sgucd13.equals(sutEntity.sgucd13) : sutEntity.sgucd13 != null) return false;
        if (sgucd14 != null ? !sgucd14.equals(sutEntity.sgucd14) : sutEntity.sgucd14 != null) return false;
        if (sgucd15 != null ? !sgucd15.equals(sutEntity.sgucd15) : sutEntity.sgucd15 != null) return false;
        if (sgucd16 != null ? !sgucd16.equals(sutEntity.sgucd16) : sutEntity.sgucd16 != null) return false;
        if (sgucd17 != null ? !sgucd17.equals(sutEntity.sgucd17) : sutEntity.sgucd17 != null) return false;
        if (sgucd18 != null ? !sgucd18.equals(sutEntity.sgucd18) : sutEntity.sgucd18 != null) return false;
        if (sgucd19 != null ? !sgucd19.equals(sutEntity.sgucd19) : sutEntity.sgucd19 != null) return false;
        if (sgucd20 != null ? !sgucd20.equals(sutEntity.sgucd20) : sutEntity.sgucd20 != null) return false;
        if (sguno01 != null ? !sguno01.equals(sutEntity.sguno01) : sutEntity.sguno01 != null) return false;
        if (sguno02 != null ? !sguno02.equals(sutEntity.sguno02) : sutEntity.sguno02 != null) return false;
        if (sguno03 != null ? !sguno03.equals(sutEntity.sguno03) : sutEntity.sguno03 != null) return false;
        if (sguno04 != null ? !sguno04.equals(sutEntity.sguno04) : sutEntity.sguno04 != null) return false;
        if (sguno05 != null ? !sguno05.equals(sutEntity.sguno05) : sutEntity.sguno05 != null) return false;
        if (sguno06 != null ? !sguno06.equals(sutEntity.sguno06) : sutEntity.sguno06 != null) return false;
        if (sguno07 != null ? !sguno07.equals(sutEntity.sguno07) : sutEntity.sguno07 != null) return false;
        if (sguno08 != null ? !sguno08.equals(sutEntity.sguno08) : sutEntity.sguno08 != null) return false;
        if (sguno09 != null ? !sguno09.equals(sutEntity.sguno09) : sutEntity.sguno09 != null) return false;
        if (sguno10 != null ? !sguno10.equals(sutEntity.sguno10) : sutEntity.sguno10 != null) return false;
        if (sguno11 != null ? !sguno11.equals(sutEntity.sguno11) : sutEntity.sguno11 != null) return false;
        if (sguno12 != null ? !sguno12.equals(sutEntity.sguno12) : sutEntity.sguno12 != null) return false;
        if (sguno13 != null ? !sguno13.equals(sutEntity.sguno13) : sutEntity.sguno13 != null) return false;
        if (sguno14 != null ? !sguno14.equals(sutEntity.sguno14) : sutEntity.sguno14 != null) return false;
        if (sguno15 != null ? !sguno15.equals(sutEntity.sguno15) : sutEntity.sguno15 != null) return false;
        if (sguno16 != null ? !sguno16.equals(sutEntity.sguno16) : sutEntity.sguno16 != null) return false;
        if (sguno17 != null ? !sguno17.equals(sutEntity.sguno17) : sutEntity.sguno17 != null) return false;
        if (sguno18 != null ? !sguno18.equals(sutEntity.sguno18) : sutEntity.sguno18 != null) return false;
        if (sguno19 != null ? !sguno19.equals(sutEntity.sguno19) : sutEntity.sguno19 != null) return false;
        if (sguno20 != null ? !sguno20.equals(sutEntity.sguno20) : sutEntity.sguno20 != null) return false;
        if (shsetyp != null ? !shsetyp.equals(sutEntity.shsetyp) : sutEntity.shsetyp != null) return false;
        if (sid != null ? !sid.equals(sutEntity.sid) : sutEntity.sid != null) return false;
        if (snatype != null ? !snatype.equals(sutEntity.snatype) : sutEntity.snatype != null) return false;
        if (sphandl != null ? !sphandl.equals(sutEntity.sphandl) : sutEntity.sphandl != null) return false;
        if (stgel01 != null ? !stgel01.equals(sutEntity.stgel01) : sutEntity.stgel01 != null) return false;
        if (stgel02 != null ? !stgel02.equals(sutEntity.stgel02) : sutEntity.stgel02 != null) return false;
        if (stgel03 != null ? !stgel03.equals(sutEntity.stgel03) : sutEntity.stgel03 != null) return false;
        if (stgel04 != null ? !stgel04.equals(sutEntity.stgel04) : sutEntity.stgel04 != null) return false;
        if (stgel05 != null ? !stgel05.equals(sutEntity.stgel05) : sutEntity.stgel05 != null) return false;
        if (stgel06 != null ? !stgel06.equals(sutEntity.stgel06) : sutEntity.stgel06 != null) return false;
        if (stgel07 != null ? !stgel07.equals(sutEntity.stgel07) : sutEntity.stgel07 != null) return false;
        if (stgel08 != null ? !stgel08.equals(sutEntity.stgel08) : sutEntity.stgel08 != null) return false;
        if (stgel09 != null ? !stgel09.equals(sutEntity.stgel09) : sutEntity.stgel09 != null) return false;
        if (stgel10 != null ? !stgel10.equals(sutEntity.stgel10) : sutEntity.stgel10 != null) return false;
        if (stgel11 != null ? !stgel11.equals(sutEntity.stgel11) : sutEntity.stgel11 != null) return false;
        if (stgel12 != null ? !stgel12.equals(sutEntity.stgel12) : sutEntity.stgel12 != null) return false;
        if (stgel13 != null ? !stgel13.equals(sutEntity.stgel13) : sutEntity.stgel13 != null) return false;
        if (stgel14 != null ? !stgel14.equals(sutEntity.stgel14) : sutEntity.stgel14 != null) return false;
        if (stgel15 != null ? !stgel15.equals(sutEntity.stgel15) : sutEntity.stgel15 != null) return false;
        if (stgel16 != null ? !stgel16.equals(sutEntity.stgel16) : sutEntity.stgel16 != null) return false;
        if (stgel17 != null ? !stgel17.equals(sutEntity.stgel17) : sutEntity.stgel17 != null) return false;
        if (stgel18 != null ? !stgel18.equals(sutEntity.stgel18) : sutEntity.stgel18 != null) return false;
        if (stgel19 != null ? !stgel19.equals(sutEntity.stgel19) : sutEntity.stgel19 != null) return false;
        if (stgel20 != null ? !stgel20.equals(sutEntity.stgel20) : sutEntity.stgel20 != null) return false;
        if (sutkey != null ? !sutkey.equals(sutEntity.sutkey) : sutEntity.sutkey != null) return false;
        if (tacpt != null ? !tacpt.equals(sutEntity.tacpt) : sutEntity.tacpt != null) return false;
        if (taid != null ? !taid.equals(sutEntity.taid) : sutEntity.taid != null) return false;
        if (taidcb != null ? !taidcb.equals(sutEntity.taidcb) : sutEntity.taidcb != null) return false;
        if (taidnb != null ? !taidnb.equals(sutEntity.taidnb) : sutEntity.taidnb != null) return false;
        if (taidnnb != null ? !taidnnb.equals(sutEntity.taidnnb) : sutEntity.taidnnb != null) return false;
        if (taidor != null ? !taidor.equals(sutEntity.taidor) : sutEntity.taidor != null) return false;
        if (tallfee != null ? !tallfee.equals(sutEntity.tallfee) : sutEntity.tallfee != null) return false;
        if (tcmpfee != null ? !tcmpfee.equals(sutEntity.tcmpfee) : sutEntity.tcmpfee != null) return false;
        if (tcrsfee != null ? !tcrsfee.equals(sutEntity.tcrsfee) : sutEntity.tcrsfee != null) return false;
        if (teach != null ? !teach.equals(sutEntity.teach) : sutEntity.teach != null) return false;
        if (term != null ? !term.equals(sutEntity.term) : sutEntity.term != null) return false;
        if (tgrcfee != null ? !tgrcfee.equals(sutEntity.tgrcfee) : sutEntity.tgrcfee != null) return false;
        if (tgrlexp != null ? !tgrlexp.equals(sutEntity.tgrlexp) : sutEntity.tgrlexp != null) return false;
        if (toffr != null ? !toffr.equals(sutEntity.toffr) : sutEntity.toffr != null) return false;
        if (tothfee != null ? !tothfee.equals(sutEntity.tothfee) : sutEntity.tothfee != null) return false;
        if (tpaid != null ? !tpaid.equals(sutEntity.tpaid) : sutEntity.tpaid != null) return false;
        if (tprgfee != null ? !tprgfee.equals(sutEntity.tprgfee) : sutEntity.tprgfee != null) return false;
        if (tugcfee != null ? !tugcfee.equals(sutEntity.tugcfee) : sutEntity.tugcfee != null) return false;
        if (tuglexp != null ? !tuglexp.equals(sutEntity.tuglexp) : sutEntity.tuglexp != null) return false;
        if (ucode != null ? !ucode.equals(sutEntity.ucode) : sutEntity.ucode != null) return false;
        if (unneed != null ? !unneed.equals(sutEntity.unneed) : sutEntity.unneed != null) return false;
        if (user1 != null ? !user1.equals(sutEntity.user1) : sutEntity.user1 != null) return false;
        if (user10 != null ? !user10.equals(sutEntity.user10) : sutEntity.user10 != null) return false;
        if (user11 != null ? !user11.equals(sutEntity.user11) : sutEntity.user11 != null) return false;
        if (user12 != null ? !user12.equals(sutEntity.user12) : sutEntity.user12 != null) return false;
        if (user13 != null ? !user13.equals(sutEntity.user13) : sutEntity.user13 != null) return false;
        if (user14 != null ? !user14.equals(sutEntity.user14) : sutEntity.user14 != null) return false;
        if (user15 != null ? !user15.equals(sutEntity.user15) : sutEntity.user15 != null) return false;
        if (user16 != null ? !user16.equals(sutEntity.user16) : sutEntity.user16 != null) return false;
        if (user17 != null ? !user17.equals(sutEntity.user17) : sutEntity.user17 != null) return false;
        if (user18 != null ? !user18.equals(sutEntity.user18) : sutEntity.user18 != null) return false;
        if (user19 != null ? !user19.equals(sutEntity.user19) : sutEntity.user19 != null) return false;
        if (user2 != null ? !user2.equals(sutEntity.user2) : sutEntity.user2 != null) return false;
        if (user20 != null ? !user20.equals(sutEntity.user20) : sutEntity.user20 != null) return false;
        if (user3 != null ? !user3.equals(sutEntity.user3) : sutEntity.user3 != null) return false;
        if (user4 != null ? !user4.equals(sutEntity.user4) : sutEntity.user4 != null) return false;
        if (user5 != null ? !user5.equals(sutEntity.user5) : sutEntity.user5 != null) return false;
        if (user6 != null ? !user6.equals(sutEntity.user6) : sutEntity.user6 != null) return false;
        if (user7 != null ? !user7.equals(sutEntity.user7) : sutEntity.user7 != null) return false;
        if (user8 != null ? !user8.equals(sutEntity.user8) : sutEntity.user8 != null) return false;
        if (user9 != null ? !user9.equals(sutEntity.user9) : sutEntity.user9 != null) return false;
        if (userdt1 != null ? !userdt1.equals(sutEntity.userdt1) : sutEntity.userdt1 != null) return false;
        if (userdt2 != null ? !userdt2.equals(sutEntity.userdt2) : sutEntity.userdt2 != null) return false;
        if (userdt3 != null ? !userdt3.equals(sutEntity.userdt3) : sutEntity.userdt3 != null) return false;
        if (userdt4 != null ? !userdt4.equals(sutEntity.userdt4) : sutEntity.userdt4 != null) return false;
        if (usernr6 != null ? !usernr6.equals(sutEntity.usernr6) : sutEntity.usernr6 != null) return false;
        if (usernr7 != null ? !usernr7.equals(sutEntity.usernr7) : sutEntity.usernr7 != null) return false;
        if (usernr8 != null ? !usernr8.equals(sutEntity.usernr8) : sutEntity.usernr8 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (sutkey != null ? sutkey.hashCode() : 0);
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
        result = 31 * result + (ecampus != null ? ecampus.hashCode() : 0);
        result = 31 * result + (pmajor != null ? pmajor.hashCode() : 0);
        result = 31 * result + (pschool != null ? pschool.hashCode() : 0);
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        result = 31 * result + (pdegree != null ? pdegree.hashCode() : 0);
        result = 31 * result + (acprog != null ? acprog.hashCode() : 0);
        result = 31 * result + (acprre != null ? acprre.hashCode() : 0);
        result = 31 * result + (depst != null ? depst.hashCode() : 0);
        result = 31 * result + (btrack != null ? btrack.hashCode() : 0);
        result = 31 * result + (penrlt != null ? penrlt.hashCode() : 0);
        result = 31 * result + (aenrlt != null ? aenrlt.hashCode() : 0);
        result = 31 * result + (pkenrl != null ? pkenrl.hashCode() : 0);
        result = 31 * result + (dsenrl != null ? dsenrl.hashCode() : 0);
        result = 31 * result + (sbudget != null ? sbudget.hashCode() : 0);
        result = 31 * result + (overbud != null ? overbud.hashCode() : 0);
        result = 31 * result + (pellbud != null ? pellbud.hashCode() : 0);
        result = 31 * result + (ovrpell != null ? ovrpell.hashCode() : 0);
        result = 31 * result + (gslbud != null ? gslbud.hashCode() : 0);
        result = 31 * result + (overgsl != null ? overgsl.hashCode() : 0);
        result = 31 * result + (toffr != null ? toffr.hashCode() : 0);
        result = 31 * result + (tacpt != null ? tacpt.hashCode() : 0);
        result = 31 * result + (tpaid != null ? tpaid.hashCode() : 0);
        result = 31 * result + (admstat != null ? admstat.hashCode() : 0);
        result = 31 * result + (pacdlvl != null ? pacdlvl.hashCode() : 0);
        result = 31 * result + (shsetyp != null ? shsetyp.hashCode() : 0);
        result = 31 * result + (procno != null ? procno.hashCode() : 0);
        result = 31 * result + (snatype != null ? snatype.hashCode() : 0);
        result = 31 * result + (athlet1 != null ? athlet1.hashCode() : 0);
        result = 31 * result + (athlet2 != null ? athlet2.hashCode() : 0);
        result = 31 * result + (currfst != null ? currfst.hashCode() : 0);
        result = 31 * result + (sphandl != null ? sphandl.hashCode() : 0);
        result = 31 * result + (packgrp != null ? packgrp.hashCode() : 0);
        result = 31 * result + (appbeg != null ? appbeg.hashCode() : 0);
        result = 31 * result + (append != null ? append.hashCode() : 0);
        result = 31 * result + (estat != null ? estat.hashCode() : 0);
        result = 31 * result + (pstat != null ? pstat.hashCode() : 0);
        result = 31 * result + (nstat != null ? nstat.hashCode() : 0);
        result = 31 * result + (cstat != null ? cstat.hashCode() : 0);
        result = 31 * result + (dstat != null ? dstat.hashCode() : 0);
        result = 31 * result + (needdte != null ? needdte.hashCode() : 0);
        result = 31 * result + (evaldte != null ? evaldte.hashCode() : 0);
        result = 31 * result + (packdte != null ? packdte.hashCode() : 0);
        result = 31 * result + (notfdte != null ? notfdte.hashCode() : 0);
        result = 31 * result + (acptdte != null ? acptdte.hashCode() : 0);
        result = 31 * result + (commdte != null ? commdte.hashCode() : 0);
        result = 31 * result + (disbdte != null ? disbdte.hashCode() : 0);
        result = 31 * result + (evalclr != null ? evalclr.hashCode() : 0);
        result = 31 * result + (user1 != null ? user1.hashCode() : 0);
        result = 31 * result + (user2 != null ? user2.hashCode() : 0);
        result = 31 * result + (user3 != null ? user3.hashCode() : 0);
        result = 31 * result + (user4 != null ? user4.hashCode() : 0);
        result = 31 * result + (user5 != null ? user5.hashCode() : 0);
        result = 31 * result + (user6 != null ? user6.hashCode() : 0);
        result = 31 * result + (user7 != null ? user7.hashCode() : 0);
        result = 31 * result + (user8 != null ? user8.hashCode() : 0);
        result = 31 * result + usernr1;
        result = 31 * result + usernr2;
        result = 31 * result + (cumgpa != null ? cumgpa.hashCode() : 0);
        result = 31 * result + (gpa != null ? gpa.hashCode() : 0);
        result = 31 * result + (cmhrsdf != null ? cmhrsdf.hashCode() : 0);
        result = 31 * result + (cmhrsco != null ? cmhrsco.hashCode() : 0);
        result = 31 * result + (cmhrsca != null ? cmhrsca.hashCode() : 0);
        result = 31 * result + (cuhrsco != null ? cuhrsco.hashCode() : 0);
        result = 31 * result + (cuhrsca != null ? cuhrsca.hashCode() : 0);
        result = 31 * result + (agncysp != null ? agncysp.hashCode() : 0);
        result = 31 * result + (hrstyp1 != null ? hrstyp1.hashCode() : 0);
        result = 31 * result + (hrstyp2 != null ? hrstyp2.hashCode() : 0);
        result = 31 * result + (hrstyp3 != null ? hrstyp3.hashCode() : 0);
        result = 31 * result + (hrstyp4 != null ? hrstyp4.hashCode() : 0);
        result = 31 * result + (hrstyp5 != null ? hrstyp5.hashCode() : 0);
        result = 31 * result + (hrstyp6 != null ? hrstyp6.hashCode() : 0);
        result = 31 * result + (enrlst1 != null ? enrlst1.hashCode() : 0);
        result = 31 * result + (enrlst2 != null ? enrlst2.hashCode() : 0);
        result = 31 * result + (enrlst3 != null ? enrlst3.hashCode() : 0);
        result = 31 * result + (enrlst4 != null ? enrlst4.hashCode() : 0);
        result = 31 * result + (enrlst5 != null ? enrlst5.hashCode() : 0);
        result = 31 * result + (enrlst6 != null ? enrlst6.hashCode() : 0);
        result = 31 * result + (hrsnum1 != null ? hrsnum1.hashCode() : 0);
        result = 31 * result + (hrsnum2 != null ? hrsnum2.hashCode() : 0);
        result = 31 * result + (hrsnum3 != null ? hrsnum3.hashCode() : 0);
        result = 31 * result + (hrsnum4 != null ? hrsnum4.hashCode() : 0);
        result = 31 * result + (hrsnum5 != null ? hrsnum5.hashCode() : 0);
        result = 31 * result + (hrsnum6 != null ? hrsnum6.hashCode() : 0);
        result = 31 * result + (disbs1 != null ? disbs1.hashCode() : 0);
        result = 31 * result + (disbs2 != null ? disbs2.hashCode() : 0);
        result = 31 * result + (disbs3 != null ? disbs3.hashCode() : 0);
        result = 31 * result + (disbs4 != null ? disbs4.hashCode() : 0);
        result = 31 * result + (disbs5 != null ? disbs5.hashCode() : 0);
        result = 31 * result + (disbs6 != null ? disbs6.hashCode() : 0);
        result = 31 * result + (disbs7 != null ? disbs7.hashCode() : 0);
        result = 31 * result + (disbs8 != null ? disbs8.hashCode() : 0);
        result = 31 * result + (disbs9 != null ? disbs9.hashCode() : 0);
        result = 31 * result + (disbs10 != null ? disbs10.hashCode() : 0);
        result = 31 * result + (disst1 != null ? disst1.hashCode() : 0);
        result = 31 * result + (disst2 != null ? disst2.hashCode() : 0);
        result = 31 * result + (disst3 != null ? disst3.hashCode() : 0);
        result = 31 * result + (disst4 != null ? disst4.hashCode() : 0);
        result = 31 * result + (disst5 != null ? disst5.hashCode() : 0);
        result = 31 * result + (disst6 != null ? disst6.hashCode() : 0);
        result = 31 * result + (disst7 != null ? disst7.hashCode() : 0);
        result = 31 * result + (disst8 != null ? disst8.hashCode() : 0);
        result = 31 * result + (disst9 != null ? disst9.hashCode() : 0);
        result = 31 * result + (disst10 != null ? disst10.hashCode() : 0);
        result = 31 * result + (enrstat != null ? enrstat.hashCode() : 0);
        result = 31 * result + (resstat != null ? resstat.hashCode() : 0);
        result = 31 * result + tchrg;
        result = 31 * result + (taid != null ? taid.hashCode() : 0);
        result = 31 * result + (taidnb != null ? taidnb.hashCode() : 0);
        result = 31 * result + (taidnnb != null ? taidnnb.hashCode() : 0);
        result = 31 * result + (unneed != null ? unneed.hashCode() : 0);
        result = 31 * result + (r2T4 != null ? r2T4.hashCode() : 0);
        result = 31 * result + (enrtyp1 != null ? enrtyp1.hashCode() : 0);
        result = 31 * result + (enrtyp2 != null ? enrtyp2.hashCode() : 0);
        result = 31 * result + (enrtyp3 != null ? enrtyp3.hashCode() : 0);
        result = 31 * result + (enrtyp4 != null ? enrtyp4.hashCode() : 0);
        result = 31 * result + (enrtyp5 != null ? enrtyp5.hashCode() : 0);
        result = 31 * result + (enrtyp6 != null ? enrtyp6.hashCode() : 0);
        result = 31 * result + (cmajor != null ? cmajor.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (classiv != null ? classiv.hashCode() : 0);
        result = 31 * result + (feecat1 != null ? feecat1.hashCode() : 0);
        result = 31 * result + (feecat2 != null ? feecat2.hashCode() : 0);
        result = 31 * result + (feecat3 != null ? feecat3.hashCode() : 0);
        result = 31 * result + (feecat4 != null ? feecat4.hashCode() : 0);
        result = 31 * result + (feecat5 != null ? feecat5.hashCode() : 0);
        result = 31 * result + (divisn != null ? divisn.hashCode() : 0);
        result = 31 * result + (enratt != null ? enratt.hashCode() : 0);
        result = 31 * result + (regapty != null ? regapty.hashCode() : 0);
        result = 31 * result + (admapty != null ? admapty.hashCode() : 0);
        result = 31 * result + (admapst != null ? admapst.hashCode() : 0);
        result = 31 * result + (atmhrs != null ? atmhrs.hashCode() : 0);
        result = 31 * result + (cmhrstr != null ? cmhrstr.hashCode() : 0);
        result = 31 * result + (recprty != null ? recprty.hashCode() : 0);
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
        result = 31 * result + (userdt1 != null ? userdt1.hashCode() : 0);
        result = 31 * result + (userdt2 != null ? userdt2.hashCode() : 0);
        result = 31 * result + (userdt3 != null ? userdt3.hashCode() : 0);
        result = 31 * result + (userdt4 != null ? userdt4.hashCode() : 0);
        result = 31 * result + (fcmth != null ? fcmth.hashCode() : 0);
        result = 31 * result + (fcmtho != null ? fcmtho.hashCode() : 0);
        result = 31 * result + (enrtyp != null ? enrtyp.hashCode() : 0);
        result = 31 * result + (hold1 != null ? hold1.hashCode() : 0);
        result = 31 * result + (efc != null ? efc.hashCode() : 0);
        result = 31 * result + (ovrefc != null ? ovrefc.hashCode() : 0);
        result = 31 * result + groneed;
        result = 31 * result + (netneed != null ? netneed.hashCode() : 0);
        result = 31 * result + (teach != null ? teach.hashCode() : 0);
        result = 31 * result + (budenr != null ? budenr.hashCode() : 0);
        result = 31 * result + (budlck != null ? budlck.hashCode() : 0);
        result = 31 * result + dircost;
        result = 31 * result + (ahrstp1 != null ? ahrstp1.hashCode() : 0);
        result = 31 * result + (ahrstp2 != null ? ahrstp2.hashCode() : 0);
        result = 31 * result + (ahrstp3 != null ? ahrstp3.hashCode() : 0);
        result = 31 * result + (ahrstp4 != null ? ahrstp4.hashCode() : 0);
        result = 31 * result + (ahrstp5 != null ? ahrstp5.hashCode() : 0);
        result = 31 * result + (ahrstp6 != null ? ahrstp6.hashCode() : 0);
        result = 31 * result + instefc;
        result = 31 * result + instpc;
        result = 31 * result + instsc;
        result = 31 * result + (stgel01 != null ? stgel01.hashCode() : 0);
        result = 31 * result + (sgucd01 != null ? sgucd01.hashCode() : 0);
        result = 31 * result + (sguno01 != null ? sguno01.hashCode() : 0);
        result = 31 * result + (stgel02 != null ? stgel02.hashCode() : 0);
        result = 31 * result + (sgucd02 != null ? sgucd02.hashCode() : 0);
        result = 31 * result + (sguno02 != null ? sguno02.hashCode() : 0);
        result = 31 * result + (stgel03 != null ? stgel03.hashCode() : 0);
        result = 31 * result + (sgucd03 != null ? sgucd03.hashCode() : 0);
        result = 31 * result + (sguno03 != null ? sguno03.hashCode() : 0);
        result = 31 * result + (stgel04 != null ? stgel04.hashCode() : 0);
        result = 31 * result + (sgucd04 != null ? sgucd04.hashCode() : 0);
        result = 31 * result + (sguno04 != null ? sguno04.hashCode() : 0);
        result = 31 * result + (stgel05 != null ? stgel05.hashCode() : 0);
        result = 31 * result + (sgucd05 != null ? sgucd05.hashCode() : 0);
        result = 31 * result + (sguno05 != null ? sguno05.hashCode() : 0);
        result = 31 * result + (stgel06 != null ? stgel06.hashCode() : 0);
        result = 31 * result + (sgucd06 != null ? sgucd06.hashCode() : 0);
        result = 31 * result + (sguno06 != null ? sguno06.hashCode() : 0);
        result = 31 * result + (stgel07 != null ? stgel07.hashCode() : 0);
        result = 31 * result + (sgucd07 != null ? sgucd07.hashCode() : 0);
        result = 31 * result + (sguno07 != null ? sguno07.hashCode() : 0);
        result = 31 * result + (stgel08 != null ? stgel08.hashCode() : 0);
        result = 31 * result + (sgucd08 != null ? sgucd08.hashCode() : 0);
        result = 31 * result + (sguno08 != null ? sguno08.hashCode() : 0);
        result = 31 * result + (stgel09 != null ? stgel09.hashCode() : 0);
        result = 31 * result + (sgucd09 != null ? sgucd09.hashCode() : 0);
        result = 31 * result + (sguno09 != null ? sguno09.hashCode() : 0);
        result = 31 * result + (stgel10 != null ? stgel10.hashCode() : 0);
        result = 31 * result + (sgucd10 != null ? sgucd10.hashCode() : 0);
        result = 31 * result + (sguno10 != null ? sguno10.hashCode() : 0);
        result = 31 * result + (stgel11 != null ? stgel11.hashCode() : 0);
        result = 31 * result + (sgucd11 != null ? sgucd11.hashCode() : 0);
        result = 31 * result + (sguno11 != null ? sguno11.hashCode() : 0);
        result = 31 * result + (stgel12 != null ? stgel12.hashCode() : 0);
        result = 31 * result + (sgucd12 != null ? sgucd12.hashCode() : 0);
        result = 31 * result + (sguno12 != null ? sguno12.hashCode() : 0);
        result = 31 * result + (stgel13 != null ? stgel13.hashCode() : 0);
        result = 31 * result + (sgucd13 != null ? sgucd13.hashCode() : 0);
        result = 31 * result + (sguno13 != null ? sguno13.hashCode() : 0);
        result = 31 * result + (stgel14 != null ? stgel14.hashCode() : 0);
        result = 31 * result + (sgucd14 != null ? sgucd14.hashCode() : 0);
        result = 31 * result + (sguno14 != null ? sguno14.hashCode() : 0);
        result = 31 * result + (stgel15 != null ? stgel15.hashCode() : 0);
        result = 31 * result + (sgucd15 != null ? sgucd15.hashCode() : 0);
        result = 31 * result + (sguno15 != null ? sguno15.hashCode() : 0);
        result = 31 * result + (stgel16 != null ? stgel16.hashCode() : 0);
        result = 31 * result + (sgucd16 != null ? sgucd16.hashCode() : 0);
        result = 31 * result + (sguno16 != null ? sguno16.hashCode() : 0);
        result = 31 * result + (stgel17 != null ? stgel17.hashCode() : 0);
        result = 31 * result + (sgucd17 != null ? sgucd17.hashCode() : 0);
        result = 31 * result + (sguno17 != null ? sguno17.hashCode() : 0);
        result = 31 * result + (stgel18 != null ? stgel18.hashCode() : 0);
        result = 31 * result + (sgucd18 != null ? sgucd18.hashCode() : 0);
        result = 31 * result + (sguno18 != null ? sguno18.hashCode() : 0);
        result = 31 * result + (stgel19 != null ? stgel19.hashCode() : 0);
        result = 31 * result + (sgucd19 != null ? sgucd19.hashCode() : 0);
        result = 31 * result + (sguno19 != null ? sguno19.hashCode() : 0);
        result = 31 * result + (stgel20 != null ? stgel20.hashCode() : 0);
        result = 31 * result + (sgucd20 != null ? sgucd20.hashCode() : 0);
        result = 31 * result + (sguno20 != null ? sguno20.hashCode() : 0);
        result = 31 * result + (caacar != null ? caacar.hashCode() : 0);
        result = 31 * result + (caacpr != null ? caacpr.hashCode() : 0);
        result = 31 * result + (catfar != null ? catfar.hashCode() : 0);
        result = 31 * result + (catfpr != null ? catfpr.hashCode() : 0);
        result = 31 * result + (cattar != null ? cattar.hashCode() : 0);
        result = 31 * result + totstaf;
        result = 31 * result + totusub;
        result = 31 * result + totperk;
        result = 31 * result + totplus;
        result = 31 * result + (budfrz != null ? budfrz.hashCode() : 0);
        result = 31 * result + (hold2 != null ? hold2.hashCode() : 0);
        result = 31 * result + (hold3 != null ? hold3.hashCode() : 0);
        result = 31 * result + (hold4 != null ? hold4.hashCode() : 0);
        result = 31 * result + (hold5 != null ? hold5.hashCode() : 0);
        result = 31 * result + (hold6 != null ? hold6.hashCode() : 0);
        result = 31 * result + (prgchk != null ? prgchk.hashCode() : 0);
        result = 31 * result + (hrsdt1 != null ? hrsdt1.hashCode() : 0);
        result = 31 * result + (hrsdt2 != null ? hrsdt2.hashCode() : 0);
        result = 31 * result + (hrsdt3 != null ? hrsdt3.hashCode() : 0);
        result = 31 * result + (hrsdt4 != null ? hrsdt4.hashCode() : 0);
        result = 31 * result + (hrsdt5 != null ? hrsdt5.hashCode() : 0);
        result = 31 * result + (hrsdt6 != null ? hrsdt6.hashCode() : 0);
        result = 31 * result + (tcrsfee != null ? tcrsfee.hashCode() : 0);
        result = 31 * result + (tcmpfee != null ? tcmpfee.hashCode() : 0);
        result = 31 * result + (tprgfee != null ? tprgfee.hashCode() : 0);
        result = 31 * result + (tothfee != null ? tothfee.hashCode() : 0);
        result = 31 * result + (tallfee != null ? tallfee.hashCode() : 0);
        result = 31 * result + (tugcfee != null ? tugcfee.hashCode() : 0);
        result = 31 * result + (tgrcfee != null ? tgrcfee.hashCode() : 0);
        result = 31 * result + (tuglexp != null ? tuglexp.hashCode() : 0);
        result = 31 * result + (tgrlexp != null ? tgrlexp.hashCode() : 0);
        result = 31 * result + (cmprte != null ? cmprte.hashCode() : 0);
        result = 31 * result + (cumahrs != null ? cumahrs.hashCode() : 0);
        result = 31 * result + (exgdrq != null ? exgdrq.hashCode() : 0);
        result = 31 * result + (enrscd != null ? enrscd.hashCode() : 0);
        result = 31 * result + (taidcb != null ? taidcb.hashCode() : 0);
        result = 31 * result + (taidor != null ? taidor.hashCode() : 0);
        result = 31 * result + (punneed != null ? punneed.hashCode() : 0);
        result = 31 * result + (incflag != null ? incflag.hashCode() : 0);
        return result;
    }
}
