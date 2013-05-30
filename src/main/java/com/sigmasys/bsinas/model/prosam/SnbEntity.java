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
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNB", schema = "SIGMA", catalog = "")
@Entity
public class SnbEntity implements Identifiable {

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

    private String crttime;

    @javax.persistence.Column(name = "CRTTIME")
    @Basic
    public String getCrttime() {
        return crttime;
    }

    public void setCrttime(String crttime) {
        this.crttime = crttime;
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

    private int revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public int getRevlev() {
        return revlev;
    }

    public void setRevlev(int revlev) {
        this.revlev = revlev;
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

    private String sarcflag;

    @javax.persistence.Column(name = "SARCFLAG")
    @Basic
    public String getSarcflag() {
        return sarcflag;
    }

    public void setSarcflag(String sarcflag) {
        this.sarcflag = sarcflag;
    }

    private String sitecode;

    @javax.persistence.Column(name = "SITECODE")
    @Basic
    public String getSitecode() {
        return sitecode;
    }

    public void setSitecode(String sitecode) {
        this.sitecode = sitecode;
    }

    private String ritflag;

    @javax.persistence.Column(name = "RITFLAG")
    @Basic
    public String getRitflag() {
        return ritflag;
    }

    public void setRitflag(String ritflag) {
        this.ritflag = ritflag;
    }

    private String holdflag;

    @javax.persistence.Column(name = "HOLDFLAG")
    @Basic
    public String getHoldflag() {
        return holdflag;
    }

    public void setHoldflag(String holdflag) {
        this.holdflag = holdflag;
    }

    private String autoflag;

    @javax.persistence.Column(name = "AUTOFLAG")
    @Basic
    public String getAutoflag() {
        return autoflag;
    }

    public void setAutoflag(String autoflag) {
        this.autoflag = autoflag;
    }

    private int btchnum;

    @javax.persistence.Column(name = "BTCHNUM")
    @Basic
    public int getBtchnum() {
        return btchnum;
    }

    public void setBtchnum(int btchnum) {
        this.btchnum = btchnum;
    }

    private String trantype;

    @javax.persistence.Column(name = "TRANTYPE")
    @Basic
    public String getTrantype() {
        return trantype;
    }

    public void setTrantype(String trantype) {
        this.trantype = trantype;
    }

    private String instcode;

    @javax.persistence.Column(name = "INSTCODE")
    @Basic
    public String getInstcode() {
        return instcode;
    }

    public void setInstcode(String instcode) {
        this.instcode = instcode;
    }

    private String appflg;

    @javax.persistence.Column(name = "APPFLG")
    @Basic
    public String getAppflg() {
        return appflg;
    }

    public void setAppflg(String appflg) {
        this.appflg = appflg;
    }

    private String fulpart;

    @javax.persistence.Column(name = "FULPART")
    @Basic
    public String getFulpart() {
        return fulpart;
    }

    public void setFulpart(String fulpart) {
        this.fulpart = fulpart;
    }

    private String mulpart;

    @javax.persistence.Column(name = "MULPART")
    @Basic
    public String getMulpart() {
        return mulpart;
    }

    public void setMulpart(String mulpart) {
        this.mulpart = mulpart;
    }

    private String sid2;

    @javax.persistence.Column(name = "SID2")
    @Basic
    public String getSid2() {
        return sid2;
    }

    public void setSid2(String sid2) {
        this.sid2 = sid2;
    }

    private String sid3;

    @javax.persistence.Column(name = "SID3")
    @Basic
    public String getSid3() {
        return sid3;
    }

    public void setSid3(String sid3) {
        this.sid3 = sid3;
    }

    private String sssn;

    @javax.persistence.Column(name = "SSSN")
    @Basic
    public String getSssn() {
        return sssn;
    }

    public void setSssn(String sssn) {
        this.sssn = sssn;
    }

    private String sssn2;

    @javax.persistence.Column(name = "SSSN2")
    @Basic
    public String getSssn2() {
        return sssn2;
    }

    public void setSssn2(String sssn2) {
        this.sssn2 = sssn2;
    }

    private int pin;

    @javax.persistence.Column(name = "PIN")
    @Basic
    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    private int pin2;

    @javax.persistence.Column(name = "PIN2")
    @Basic
    public int getPin2() {
        return pin2;
    }

    public void setPin2(int pin2) {
        this.pin2 = pin2;
    }

    private String sidflag;

    @javax.persistence.Column(name = "SIDFLAG")
    @Basic
    public String getSidflag() {
        return sidflag;
    }

    public void setSidflag(String sidflag) {
        this.sidflag = sidflag;
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

    private String sname;

    @javax.persistence.Column(name = "SNAME")
    @Basic
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    private String cmpstat;

    @javax.persistence.Column(name = "CMPSTAT")
    @Basic
    public String getCmpstat() {
        return cmpstat;
    }

    public void setCmpstat(String cmpstat) {
        this.cmpstat = cmpstat;
    }

    private String samstat;

    @javax.persistence.Column(name = "SAMSTAT")
    @Basic
    public String getSamstat() {
        return samstat;
    }

    public void setSamstat(String samstat) {
        this.samstat = samstat;
    }

    private String illgble;

    @javax.persistence.Column(name = "ILLGBLE")
    @Basic
    public String getIllgble() {
        return illgble;
    }

    public void setIllgble(String illgble) {
        this.illgble = illgble;
    }

    private String verpri;

    @javax.persistence.Column(name = "VERPRI")
    @Basic
    public String getVerpri() {
        return verpri;
    }

    public void setVerpri(String verpri) {
        this.verpri = verpri;
    }

    private String sillgble;

    @javax.persistence.Column(name = "SILLGBLE")
    @Basic
    public String getSillgble() {
        return sillgble;
    }

    public void setSillgble(String sillgble) {
        this.sillgble = sillgble;
    }

    private String typepf;

    @javax.persistence.Column(name = "TYPEPF")
    @Basic
    public String getTypepf() {
        return typepf;
    }

    public void setTypepf(String typepf) {
        this.typepf = typepf;
    }

    private String typesf;

    @javax.persistence.Column(name = "TYPESF")
    @Basic
    public String getTypesf() {
        return typesf;
    }

    public void setTypesf(String typesf) {
        this.typesf = typesf;
    }

    private String typeps;

    @javax.persistence.Column(name = "TYPEPS")
    @Basic
    public String getTypeps() {
        return typeps;
    }

    public void setTypeps(String typeps) {
        this.typeps = typeps;
    }

    private String typess;

    @javax.persistence.Column(name = "TYPESS")
    @Basic
    public String getTypess() {
        return typess;
    }

    public void setTypess(String typess) {
        this.typess = typess;
    }

    private String dfltmch;

    @javax.persistence.Column(name = "DFLTMCH")
    @Basic
    public String getDfltmch() {
        return dfltmch;
    }

    public void setDfltmch(String dfltmch) {
        this.dfltmch = dfltmch;
    }

    private String verprist;

    @javax.persistence.Column(name = "VERPRIST")
    @Basic
    public String getVerprist() {
        return verprist;
    }

    public void setVerprist(String verprist) {
        this.verprist = verprist;
    }

    private String sphone;

    @javax.persistence.Column(name = "SPHONE")
    @Basic
    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    private String sphone2;

    @javax.persistence.Column(name = "SPHONE2")
    @Basic
    public String getSphone2() {
        return sphone2;
    }

    public void setSphone2(String sphone2) {
        this.sphone2 = sphone2;
    }

    private String sres;

    @javax.persistence.Column(name = "SRES")
    @Basic
    public String getSres() {
        return sres;
    }

    public void setSres(String sres) {
        this.sres = sres;
    }

    private String sres2;

    @javax.persistence.Column(name = "SRES2")
    @Basic
    public String getSres2() {
        return sres2;
    }

    public void setSres2(String sres2) {
        this.sres2 = sres2;
    }

    private String sress;

    @javax.persistence.Column(name = "SRESS")
    @Basic
    public String getSress() {
        return sress;
    }

    public void setSress(String sress) {
        this.sress = sress;
    }

    private String incudr0;

    @javax.persistence.Column(name = "INCUDR0")
    @Basic
    public String getIncudr0() {
        return incudr0;
    }

    public void setIncudr0(String incudr0) {
        this.incudr0 = incudr0;
    }

    private String incudr1;

    @javax.persistence.Column(name = "INCUDR1")
    @Basic
    public String getIncudr1() {
        return incudr1;
    }

    public void setIncudr1(String incudr1) {
        this.incudr1 = incudr1;
    }

    private String incudrx;

    @javax.persistence.Column(name = "INCUDRX")
    @Basic
    public String getIncudrx() {
        return incudrx;
    }

    public void setIncudrx(String incudrx) {
        this.incudrx = incudrx;
    }

    private String incudr2;

    @javax.persistence.Column(name = "INCUDR2")
    @Basic
    public String getIncudr2() {
        return incudr2;
    }

    public void setIncudr2(String incudr2) {
        this.incudr2 = incudr2;
    }

    private String incudr3;

    @javax.persistence.Column(name = "INCUDR3")
    @Basic
    public String getIncudr3() {
        return incudr3;
    }

    public void setIncudr3(String incudr3) {
        this.incudr3 = incudr3;
    }

    private String resgt3C;

    @javax.persistence.Column(name = "RESGT3C")
    @Basic
    public String getResgt3C() {
        return resgt3C;
    }

    public void setResgt3C(String resgt3C) {
        this.resgt3C = resgt3C;
    }

    private String resgt4C;

    @javax.persistence.Column(name = "RESGT4C")
    @Basic
    public String getResgt4C() {
        return resgt4C;
    }

    public void setResgt4C(String resgt4C) {
        this.resgt4C = resgt4C;
    }

    private String resgt4D;

    @javax.persistence.Column(name = "RESGT4D")
    @Basic
    public String getResgt4D() {
        return resgt4D;
    }

    public void setResgt4D(String resgt4D) {
        this.resgt4D = resgt4D;
    }

    private String resgt5D;

    @javax.persistence.Column(name = "RESGT5D")
    @Basic
    public String getResgt5D() {
        return resgt5D;
    }

    public void setResgt5D(String resgt5D) {
        this.resgt5D = resgt5D;
    }

    private String resgt5E;

    @javax.persistence.Column(name = "RESGT5E")
    @Basic
    public String getResgt5E() {
        return resgt5E;
    }

    public void setResgt5E(String resgt5E) {
        this.resgt5E = resgt5E;
    }

    private String resgt6E;

    @javax.persistence.Column(name = "RESGT6E")
    @Basic
    public String getResgt6E() {
        return resgt6E;
    }

    public void setResgt6E(String resgt6E) {
        this.resgt6E = resgt6E;
    }

    private String resgt6F;

    @javax.persistence.Column(name = "RESGT6F")
    @Basic
    public String getResgt6F() {
        return resgt6F;
    }

    public void setResgt6F(String resgt6F) {
        this.resgt6F = resgt6F;
    }

    private String resgt7F;

    @javax.persistence.Column(name = "RESGT7F")
    @Basic
    public String getResgt7F() {
        return resgt7F;
    }

    public void setResgt7F(String resgt7F) {
        this.resgt7F = resgt7F;
    }

    private String pres;

    @javax.persistence.Column(name = "PRES")
    @Basic
    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    private String pres2;

    @javax.persistence.Column(name = "PRES2")
    @Basic
    public String getPres2() {
        return pres2;
    }

    public void setPres2(String pres2) {
        this.pres2 = pres2;
    }

    private String scitizn;

    @javax.persistence.Column(name = "SCITIZN")
    @Basic
    public String getScitizn() {
        return scitizn;
    }

    public void setScitizn(String scitizn) {
        this.scitizn = scitizn;
    }

    private String scitizn2;

    @javax.persistence.Column(name = "SCITIZN2")
    @Basic
    public String getScitizn2() {
        return scitizn2;
    }

    public void setScitizn2(String scitizn2) {
        this.scitizn2 = scitizn2;
    }

    private String scitizns;

    @javax.persistence.Column(name = "SCITIZNS")
    @Basic
    public String getScitizns() {
        return scitizns;
    }

    public void setScitizns(String scitizns) {
        this.scitizns = scitizns;
    }

    private String salnr;

    @javax.persistence.Column(name = "SALNR")
    @Basic
    public String getSalnr() {
        return salnr;
    }

    public void setSalnr(String salnr) {
        this.salnr = salnr;
    }

    private String salnr2;

    @javax.persistence.Column(name = "SALNR2")
    @Basic
    public String getSalnr2() {
        return salnr2;
    }

    public void setSalnr2(String salnr2) {
        this.salnr2 = salnr2;
    }

    private String shsetp;

    @javax.persistence.Column(name = "SHSETP")
    @Basic
    public String getShsetp() {
        return shsetp;
    }

    public void setShsetp(String shsetp) {
        this.shsetp = shsetp;
    }

    private String shsetp2;

    @javax.persistence.Column(name = "SHSETP2")
    @Basic
    public String getShsetp2() {
        return shsetp2;
    }

    public void setShsetp2(String shsetp2) {
        this.shsetp2 = shsetp2;
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

    private String pdeg2;

    @javax.persistence.Column(name = "PDEG2")
    @Basic
    public String getPdeg2() {
        return pdeg2;
    }

    public void setPdeg2(String pdeg2) {
        this.pdeg2 = pdeg2;
    }

    private String spse;

    @javax.persistence.Column(name = "SPSE")
    @Basic
    public String getSpse() {
        return spse;
    }

    public void setSpse(String spse) {
        this.spse = spse;
    }

    private String syrinc;

    @javax.persistence.Column(name = "SYRINC")
    @Basic
    public String getSyrinc() {
        return syrinc;
    }

    public void setSyrinc(String syrinc) {
        this.syrinc = syrinc;
    }

    private String syrinc2;

    @javax.persistence.Column(name = "SYRINC2")
    @Basic
    public String getSyrinc2() {
        return syrinc2;
    }

    public void setSyrinc2(String syrinc2) {
        this.syrinc2 = syrinc2;
    }

    private String senrlst;

    @javax.persistence.Column(name = "SENRLST")
    @Basic
    public String getSenrlst() {
        return senrlst;
    }

    public void setSenrlst(String senrlst) {
        this.senrlst = senrlst;
    }

    private String inrctp;

    @javax.persistence.Column(name = "INRCTP")
    @Basic
    public String getInrctp() {
        return inrctp;
    }

    public void setInrctp(String inrctp) {
        this.inrctp = inrctp;
    }

    private String inrctp2;

    @javax.persistence.Column(name = "INRCTP2")
    @Basic
    public String getInrctp2() {
        return inrctp2;
    }

    public void setInrctp2(String inrctp2) {
        this.inrctp2 = inrctp2;
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

    private BigInteger enrlgh;

    @javax.persistence.Column(name = "ENRLGH")
    @Basic
    public BigInteger getEnrlgh() {
        return enrlgh;
    }

    public void setEnrlgh(BigInteger enrlgh) {
        this.enrlgh = enrlgh;
    }

    private BigInteger ovrenrl;

    @javax.persistence.Column(name = "OVRENRL")
    @Basic
    public BigInteger getOvrenrl() {
        return ovrenrl;
    }

    public void setOvrenrl(BigInteger ovrenrl) {
        this.ovrenrl = ovrenrl;
    }

    private String born0;

    @javax.persistence.Column(name = "BORN0")
    @Basic
    public String getBorn0() {
        return born0;
    }

    public void setBorn0(String born0) {
        this.born0 = born0;
    }

    private String svet;

    @javax.persistence.Column(name = "SVET")
    @Basic
    public String getSvet() {
        return svet;
    }

    public void setSvet(String svet) {
        this.svet = svet;
    }

    private String svet2;

    @javax.persistence.Column(name = "SVET2")
    @Basic
    public String getSvet2() {
        return svet2;
    }

    public void setSvet2(String svet2) {
        this.svet2 = svet2;
    }

    private String orphwd;

    @javax.persistence.Column(name = "ORPHWD")
    @Basic
    public String getOrphwd() {
        return orphwd;
    }

    public void setOrphwd(String orphwd) {
        this.orphwd = orphwd;
    }

    private String lgldep;

    @javax.persistence.Column(name = "LGLDEP")
    @Basic
    public String getLgldep() {
        return lgldep;
    }

    public void setLgldep(String lgldep) {
        this.lgldep = lgldep;
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

    private String refund;

    @javax.persistence.Column(name = "REFUND")
    @Basic
    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }

    private String sapref;

    @javax.persistence.Column(name = "SAPREF")
    @Basic
    public String getSapref() {
        return sapref;
    }

    public void setSapref(String sapref) {
        this.sapref = sapref;
    }

    private String exemp3;

    @javax.persistence.Column(name = "EXEMP3")
    @Basic
    public String getExemp3() {
        return exemp3;
    }

    public void setExemp3(String exemp3) {
        this.exemp3 = exemp3;
    }

    private String exemp2;

    @javax.persistence.Column(name = "EXEMP2")
    @Basic
    public String getExemp2() {
        return exemp2;
    }

    public void setExemp2(String exemp2) {
        this.exemp2 = exemp2;
    }

    private String exemp1;

    @javax.persistence.Column(name = "EXEMP1")
    @Basic
    public String getExemp1() {
        return exemp1;
    }

    public void setExemp1(String exemp1) {
        this.exemp1 = exemp1;
    }

    private String exemp0;

    @javax.persistence.Column(name = "EXEMP0")
    @Basic
    public String getExemp0() {
        return exemp0;
    }

    public void setExemp0(String exemp0) {
        this.exemp0 = exemp0;
    }

    private String fiscyr;

    @javax.persistence.Column(name = "FISCYR")
    @Basic
    public String getFiscyr() {
        return fiscyr;
    }

    public void setFiscyr(String fiscyr) {
        this.fiscyr = fiscyr;
    }

    private String typcomp;

    @javax.persistence.Column(name = "TYPCOMP")
    @Basic
    public String getTypcomp() {
        return typcomp;
    }

    public void setTypcomp(String typcomp) {
        this.typcomp = typcomp;
    }

    private String fedaid3;

    @javax.persistence.Column(name = "FEDAID3")
    @Basic
    public String getFedaid3() {
        return fedaid3;
    }

    public void setFedaid3(String fedaid3) {
        this.fedaid3 = fedaid3;
    }

    private String fedaid2;

    @javax.persistence.Column(name = "FEDAID2")
    @Basic
    public String getFedaid2() {
        return fedaid2;
    }

    public void setFedaid2(String fedaid2) {
        this.fedaid2 = fedaid2;
    }

    private String fedaid1;

    @javax.persistence.Column(name = "FEDAID1")
    @Basic
    public String getFedaid1() {
        return fedaid1;
    }

    public void setFedaid1(String fedaid1) {
        this.fedaid1 = fedaid1;
    }

    private String fedaid0;

    @javax.persistence.Column(name = "FEDAID0")
    @Basic
    public String getFedaid0() {
        return fedaid0;
    }

    public void setFedaid0(String fedaid0) {
        this.fedaid0 = fedaid0;
    }

    private String airstat;

    @javax.persistence.Column(name = "AIRSTAT")
    @Basic
    public String getAirstat() {
        return airstat;
    }

    public void setAirstat(String airstat) {
        this.airstat = airstat;
    }

    private String farstat;

    @javax.persistence.Column(name = "FARSTAT")
    @Basic
    public String getFarstat() {
        return farstat;
    }

    public void setFarstat(String farstat) {
        this.farstat = farstat;
    }

    private String esarstat;

    @javax.persistence.Column(name = "ESARSTAT")
    @Basic
    public String getEsarstat() {
        return esarstat;
    }

    public void setEsarstat(String esarstat) {
        this.esarstat = esarstat;
    }

    private String reqfar;

    @javax.persistence.Column(name = "REQFAR")
    @Basic
    public String getReqfar() {
        return reqfar;
    }

    public void setReqfar(String reqfar) {
        this.reqfar = reqfar;
    }

    private String reqesar;

    @javax.persistence.Column(name = "REQESAR")
    @Basic
    public String getReqesar() {
        return reqesar;
    }

    public void setReqesar(String reqesar) {
        this.reqesar = reqesar;
    }

    private String explain;

    @javax.persistence.Column(name = "EXPLAIN")
    @Basic
    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    private String divsep;

    @javax.persistence.Column(name = "DIVSEP")
    @Basic
    public String getDivsep() {
        return divsep;
    }

    public void setDivsep(String divsep) {
        this.divsep = divsep;
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

    private String relfed;

    @javax.persistence.Column(name = "RELFED")
    @Basic
    public String getRelfed() {
        return relfed;
    }

    public void setRelfed(String relfed) {
        this.relfed = relfed;
    }

    private String relst;

    @javax.persistence.Column(name = "RELST")
    @Basic
    public String getRelst() {
        return relst;
    }

    public void setRelst(String relst) {
        this.relst = relst;
    }

    private String relst2;

    @javax.persistence.Column(name = "RELST2")
    @Basic
    public String getRelst2() {
        return relst2;
    }

    public void setRelst2(String relst2) {
        this.relst2 = relst2;
    }

    private String relinst;

    @javax.persistence.Column(name = "RELINST")
    @Basic
    public String getRelinst() {
        return relinst;
    }

    public void setRelinst(String relinst) {
        this.relinst = relinst;
    }

    private String fdepdoc;

    @javax.persistence.Column(name = "FDEPDOC")
    @Basic
    public String getFdepdoc() {
        return fdepdoc;
    }

    public void setFdepdoc(String fdepdoc) {
        this.fdepdoc = fdepdoc;
    }

    private String sdepdoc;

    @javax.persistence.Column(name = "SDEPDOC")
    @Basic
    public String getSdepdoc() {
        return sdepdoc;
    }

    public void setSdepdoc(String sdepdoc) {
        this.sdepdoc = sdepdoc;
    }

    private String sigs;

    @javax.persistence.Column(name = "SIGS")
    @Basic
    public String getSigs() {
        return sigs;
    }

    public void setSigs(String sigs) {
        this.sigs = sigs;
    }

    private String sigsp;

    @javax.persistence.Column(name = "SIGSP")
    @Basic
    public String getSigsp() {
        return sigsp;
    }

    public void setSigsp(String sigsp) {
        this.sigsp = sigsp;
    }

    private String sigf;

    @javax.persistence.Column(name = "SIGF")
    @Basic
    public String getSigf() {
        return sigf;
    }

    public void setSigf(String sigf) {
        this.sigf = sigf;
    }

    private String sigm;

    @javax.persistence.Column(name = "SIGM")
    @Basic
    public String getSigm() {
        return sigm;
    }

    public void setSigm(String sigm) {
        this.sigm = sigm;
    }

    private String shscd;

    @javax.persistence.Column(name = "SHSCD")
    @Basic
    public String getShscd() {
        return shscd;
    }

    public void setShscd(String shscd) {
        this.shscd = shscd;
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

    private String campus3;

    @javax.persistence.Column(name = "CAMPUS3")
    @Basic
    public String getCampus3() {
        return campus3;
    }

    public void setCampus3(String campus3) {
        this.campus3 = campus3;
    }

    private String campus4;

    @javax.persistence.Column(name = "CAMPUS4")
    @Basic
    public String getCampus4() {
        return campus4;
    }

    public void setCampus4(String campus4) {
        this.campus4 = campus4;
    }

    private String campus5;

    @javax.persistence.Column(name = "CAMPUS5")
    @Basic
    public String getCampus5() {
        return campus5;
    }

    public void setCampus5(String campus5) {
        this.campus5 = campus5;
    }

    private String campus6;

    @javax.persistence.Column(name = "CAMPUS6")
    @Basic
    public String getCampus6() {
        return campus6;
    }

    public void setCampus6(String campus6) {
        this.campus6 = campus6;
    }

    private String campus21;

    @javax.persistence.Column(name = "CAMPUS21")
    @Basic
    public String getCampus21() {
        return campus21;
    }

    public void setCampus21(String campus21) {
        this.campus21 = campus21;
    }

    private String campus22;

    @javax.persistence.Column(name = "CAMPUS22")
    @Basic
    public String getCampus22() {
        return campus22;
    }

    public void setCampus22(String campus22) {
        this.campus22 = campus22;
    }

    private String campus23;

    @javax.persistence.Column(name = "CAMPUS23")
    @Basic
    public String getCampus23() {
        return campus23;
    }

    public void setCampus23(String campus23) {
        this.campus23 = campus23;
    }

    private String campus24;

    @javax.persistence.Column(name = "CAMPUS24")
    @Basic
    public String getCampus24() {
        return campus24;
    }

    public void setCampus24(String campus24) {
        this.campus24 = campus24;
    }

    private String campus25;

    @javax.persistence.Column(name = "CAMPUS25")
    @Basic
    public String getCampus25() {
        return campus25;
    }

    public void setCampus25(String campus25) {
        this.campus25 = campus25;
    }

    private String campus26;

    @javax.persistence.Column(name = "CAMPUS26")
    @Basic
    public String getCampus26() {
        return campus26;
    }

    public void setCampus26(String campus26) {
        this.campus26 = campus26;
    }

    private int pprssn;

    @javax.persistence.Column(name = "PPRSSN")
    @Basic
    public int getPprssn() {
        return pprssn;
    }

    public void setPprssn(int pprssn) {
        this.pprssn = pprssn;
    }

    private int pprssn2;

    @javax.persistence.Column(name = "PPRSSN2")
    @Basic
    public int getPprssn2() {
        return pprssn2;
    }

    public void setPprssn2(int pprssn2) {
        this.pprssn2 = pprssn2;
    }

    private int pprein;

    @javax.persistence.Column(name = "PPREIN")
    @Basic
    public int getPprein() {
        return pprein;
    }

    public void setPprein(int pprein) {
        this.pprein = pprein;
    }

    private int pprein2;

    @javax.persistence.Column(name = "PPREIN2")
    @Basic
    public int getPprein2() {
        return pprein2;
    }

    public void setPprein2(int pprein2) {
        this.pprein2 = pprein2;
    }

    private String pprsig;

    @javax.persistence.Column(name = "PPRSIG")
    @Basic
    public String getPprsig() {
        return pprsig;
    }

    public void setPprsig(String pprsig) {
        this.pprsig = pprsig;
    }

    private String pprsig2;

    @javax.persistence.Column(name = "PPRSIG2")
    @Basic
    public String getPprsig2() {
        return pprsig2;
    }

    public void setPprsig2(String pprsig2) {
        this.pprsig2 = pprsig2;
    }

    private String prcol1;

    @javax.persistence.Column(name = "PRCOL1")
    @Basic
    public String getPrcol1() {
        return prcol1;
    }

    public void setPrcol1(String prcol1) {
        this.prcol1 = prcol1;
    }

    private String prcol2;

    @javax.persistence.Column(name = "PRCOL2")
    @Basic
    public String getPrcol2() {
        return prcol2;
    }

    public void setPrcol2(String prcol2) {
        this.prcol2 = prcol2;
    }

    private String prcol3;

    @javax.persistence.Column(name = "PRCOL3")
    @Basic
    public String getPrcol3() {
        return prcol3;
    }

    public void setPrcol3(String prcol3) {
        this.prcol3 = prcol3;
    }

    private String prcol4;

    @javax.persistence.Column(name = "PRCOL4")
    @Basic
    public String getPrcol4() {
        return prcol4;
    }

    public void setPrcol4(String prcol4) {
        this.prcol4 = prcol4;
    }

    private String prcol5;

    @javax.persistence.Column(name = "PRCOL5")
    @Basic
    public String getPrcol5() {
        return prcol5;
    }

    public void setPrcol5(String prcol5) {
        this.prcol5 = prcol5;
    }

    private String prcol6;

    @javax.persistence.Column(name = "PRCOL6")
    @Basic
    public String getPrcol6() {
        return prcol6;
    }

    public void setPrcol6(String prcol6) {
        this.prcol6 = prcol6;
    }

    private String nprcol;

    @javax.persistence.Column(name = "NPRCOL")
    @Basic
    public String getNprcol() {
        return nprcol;
    }

    public void setNprcol(String nprcol) {
        this.nprcol = nprcol;
    }

    private String samecol;

    @javax.persistence.Column(name = "SAMECOL")
    @Basic
    public String getSamecol() {
        return samecol;
    }

    public void setSamecol(String samecol) {
        this.samecol = samecol;
    }

    private String major;

    @javax.persistence.Column(name = "MAJOR")
    @Basic
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    private String sgradpro;

    @javax.persistence.Column(name = "SGRADPRO")
    @Basic
    public String getSgradpro() {
        return sgradpro;
    }

    public void setSgradpro(String sgradpro) {
        this.sgradpro = sgradpro;
    }

    private String degobj;

    @javax.persistence.Column(name = "DEGOBJ")
    @Basic
    public String getDegobj() {
        return degobj;
    }

    public void setDegobj(String degobj) {
        this.degobj = degobj;
    }

    private String degobj2;

    @javax.persistence.Column(name = "DEGOBJ2")
    @Basic
    public String getDegobj2() {
        return degobj2;
    }

    public void setDegobj2(String degobj2) {
        this.degobj2 = degobj2;
    }

    private int savbua;

    @javax.persistence.Column(name = "SAVBUA")
    @Basic
    public int getSavbua() {
        return savbua;
    }

    public void setSavbua(int savbua) {
        this.savbua = savbua;
    }

    private int pcons;

    @javax.persistence.Column(name = "PCONS")
    @Basic
    public int getPcons() {
        return pcons;
    }

    public void setPcons(int pcons) {
        this.pcons = pcons;
    }

    private int scons;

    @javax.persistence.Column(name = "SCONS")
    @Basic
    public int getScons() {
        return scons;
    }

    public void setScons(int scons) {
        this.scons = scons;
    }

    private int tfcs;

    @javax.persistence.Column(name = "TFCS")
    @Basic
    public int getTfcs() {
        return tfcs;
    }

    public void setTfcs(int tfcs) {
        this.tfcs = tfcs;
    }

    private String typsais;

    @javax.persistence.Column(name = "TYPSAIS")
    @Basic
    public String getTypsais() {
        return typsais;
    }

    public void setTypsais(String typsais) {
        this.typsais = typsais;
    }

    private String typfcs;

    @javax.persistence.Column(name = "TYPFCS")
    @Basic
    public String getTypfcs() {
        return typfcs;
    }

    public void setTypfcs(String typfcs) {
        this.typfcs = typfcs;
    }

    private String pricmps;

    @javax.persistence.Column(name = "PRICMPS")
    @Basic
    public String getPricmps() {
        return pricmps;
    }

    public void setPricmps(String pricmps) {
        this.pricmps = pricmps;
    }

    private String seccmps;

    @javax.persistence.Column(name = "SECCMPS")
    @Basic
    public String getSeccmps() {
        return seccmps;
    }

    public void setSeccmps(String seccmps) {
        this.seccmps = seccmps;
    }

    private String typesai;

    @javax.persistence.Column(name = "TYPESAI")
    @Basic
    public String getTypesai() {
        return typesai;
    }

    public void setTypesai(String typesai) {
        this.typesai = typesai;
    }

    private String typefc;

    @javax.persistence.Column(name = "TYPEFC")
    @Basic
    public String getTypefc() {
        return typefc;
    }

    public void setTypefc(String typefc) {
        this.typefc = typefc;
    }

    private String pricmpp;

    @javax.persistence.Column(name = "PRICMPP")
    @Basic
    public String getPricmpp() {
        return pricmpp;
    }

    public void setPricmpp(String pricmpp) {
        this.pricmpp = pricmpp;
    }

    private String seccmpp;

    @javax.persistence.Column(name = "SECCMPP")
    @Basic
    public String getSeccmpp() {
        return seccmpp;
    }

    public void setSeccmpp(String seccmpp) {
        this.seccmpp = seccmpp;
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

        SnbEntity snbEntity = (SnbEntity) o;

        if (btchnum != snbEntity.btchnum) return false;
        if (pcons != snbEntity.pcons) return false;
        if (pin != snbEntity.pin) return false;
        if (pin2 != snbEntity.pin2) return false;
        if (pprein != snbEntity.pprein) return false;
        if (pprein2 != snbEntity.pprein2) return false;
        if (pprssn != snbEntity.pprssn) return false;
        if (pprssn2 != snbEntity.pprssn2) return false;
        if (revlev != snbEntity.revlev) return false;
        if (savbua != snbEntity.savbua) return false;
        if (scons != snbEntity.scons) return false;
        if (tfcs != snbEntity.tfcs) return false;
        if (aidyr != null ? !aidyr.equals(snbEntity.aidyr) : snbEntity.aidyr != null) return false;
        if (airstat != null ? !airstat.equals(snbEntity.airstat) : snbEntity.airstat != null) return false;
        if (appflg != null ? !appflg.equals(snbEntity.appflg) : snbEntity.appflg != null) return false;
        if (autoflag != null ? !autoflag.equals(snbEntity.autoflag) : snbEntity.autoflag != null) return false;
        if (born0 != null ? !born0.equals(snbEntity.born0) : snbEntity.born0 != null) return false;
        if (campus1 != null ? !campus1.equals(snbEntity.campus1) : snbEntity.campus1 != null) return false;
        if (campus2 != null ? !campus2.equals(snbEntity.campus2) : snbEntity.campus2 != null) return false;
        if (campus21 != null ? !campus21.equals(snbEntity.campus21) : snbEntity.campus21 != null) return false;
        if (campus22 != null ? !campus22.equals(snbEntity.campus22) : snbEntity.campus22 != null) return false;
        if (campus23 != null ? !campus23.equals(snbEntity.campus23) : snbEntity.campus23 != null) return false;
        if (campus24 != null ? !campus24.equals(snbEntity.campus24) : snbEntity.campus24 != null) return false;
        if (campus25 != null ? !campus25.equals(snbEntity.campus25) : snbEntity.campus25 != null) return false;
        if (campus26 != null ? !campus26.equals(snbEntity.campus26) : snbEntity.campus26 != null) return false;
        if (campus3 != null ? !campus3.equals(snbEntity.campus3) : snbEntity.campus3 != null) return false;
        if (campus4 != null ? !campus4.equals(snbEntity.campus4) : snbEntity.campus4 != null) return false;
        if (campus5 != null ? !campus5.equals(snbEntity.campus5) : snbEntity.campus5 != null) return false;
        if (campus6 != null ? !campus6.equals(snbEntity.campus6) : snbEntity.campus6 != null) return false;
        if (cmpstat != null ? !cmpstat.equals(snbEntity.cmpstat) : snbEntity.cmpstat != null) return false;
        if (cmptype != null ? !cmptype.equals(snbEntity.cmptype) : snbEntity.cmptype != null) return false;
        if (createc != null ? !createc.equals(snbEntity.createc) : snbEntity.createc != null) return false;
        if (crttime != null ? !crttime.equals(snbEntity.crttime) : snbEntity.crttime != null) return false;
        if (defaultr != null ? !defaultr.equals(snbEntity.defaultr) : snbEntity.defaultr != null) return false;
        if (degobj != null ? !degobj.equals(snbEntity.degobj) : snbEntity.degobj != null) return false;
        if (degobj2 != null ? !degobj2.equals(snbEntity.degobj2) : snbEntity.degobj2 != null) return false;
        if (depstf != null ? !depstf.equals(snbEntity.depstf) : snbEntity.depstf != null) return false;
        if (depsti != null ? !depsti.equals(snbEntity.depsti) : snbEntity.depsti != null) return false;
        if (depsts != null ? !depsts.equals(snbEntity.depsts) : snbEntity.depsts != null) return false;
        if (dfltmch != null ? !dfltmch.equals(snbEntity.dfltmch) : snbEntity.dfltmch != null) return false;
        if (divsep != null ? !divsep.equals(snbEntity.divsep) : snbEntity.divsep != null) return false;
        if (enrlgh != null ? !enrlgh.equals(snbEntity.enrlgh) : snbEntity.enrlgh != null) return false;
        if (esarstat != null ? !esarstat.equals(snbEntity.esarstat) : snbEntity.esarstat != null) return false;
        if (exemp0 != null ? !exemp0.equals(snbEntity.exemp0) : snbEntity.exemp0 != null) return false;
        if (exemp1 != null ? !exemp1.equals(snbEntity.exemp1) : snbEntity.exemp1 != null) return false;
        if (exemp2 != null ? !exemp2.equals(snbEntity.exemp2) : snbEntity.exemp2 != null) return false;
        if (exemp3 != null ? !exemp3.equals(snbEntity.exemp3) : snbEntity.exemp3 != null) return false;
        if (explain != null ? !explain.equals(snbEntity.explain) : snbEntity.explain != null) return false;
        if (farstat != null ? !farstat.equals(snbEntity.farstat) : snbEntity.farstat != null) return false;
        if (fdepdoc != null ? !fdepdoc.equals(snbEntity.fdepdoc) : snbEntity.fdepdoc != null) return false;
        if (fedaid0 != null ? !fedaid0.equals(snbEntity.fedaid0) : snbEntity.fedaid0 != null) return false;
        if (fedaid1 != null ? !fedaid1.equals(snbEntity.fedaid1) : snbEntity.fedaid1 != null) return false;
        if (fedaid2 != null ? !fedaid2.equals(snbEntity.fedaid2) : snbEntity.fedaid2 != null) return false;
        if (fedaid3 != null ? !fedaid3.equals(snbEntity.fedaid3) : snbEntity.fedaid3 != null) return false;
        if (fiscyr != null ? !fiscyr.equals(snbEntity.fiscyr) : snbEntity.fiscyr != null) return false;
        if (fulpart != null ? !fulpart.equals(snbEntity.fulpart) : snbEntity.fulpart != null) return false;
        if (holdflag != null ? !holdflag.equals(snbEntity.holdflag) : snbEntity.holdflag != null) return false;
        if (illgble != null ? !illgble.equals(snbEntity.illgble) : snbEntity.illgble != null) return false;
        if (incudr0 != null ? !incudr0.equals(snbEntity.incudr0) : snbEntity.incudr0 != null) return false;
        if (incudr1 != null ? !incudr1.equals(snbEntity.incudr1) : snbEntity.incudr1 != null) return false;
        if (incudr2 != null ? !incudr2.equals(snbEntity.incudr2) : snbEntity.incudr2 != null) return false;
        if (incudr3 != null ? !incudr3.equals(snbEntity.incudr3) : snbEntity.incudr3 != null) return false;
        if (incudrx != null ? !incudrx.equals(snbEntity.incudrx) : snbEntity.incudrx != null) return false;
        if (initals != null ? !initals.equals(snbEntity.initals) : snbEntity.initals != null) return false;
        if (inrctp != null ? !inrctp.equals(snbEntity.inrctp) : snbEntity.inrctp != null) return false;
        if (inrctp2 != null ? !inrctp2.equals(snbEntity.inrctp2) : snbEntity.inrctp2 != null) return false;
        if (instcode != null ? !instcode.equals(snbEntity.instcode) : snbEntity.instcode != null) return false;
        if (instid != null ? !instid.equals(snbEntity.instid) : snbEntity.instid != null) return false;
        if (lgldep != null ? !lgldep.equals(snbEntity.lgldep) : snbEntity.lgldep != null) return false;
        if (major != null ? !major.equals(snbEntity.major) : snbEntity.major != null) return false;
        if (module != null ? !module.equals(snbEntity.module) : snbEntity.module != null) return false;
        if (mulpart != null ? !mulpart.equals(snbEntity.mulpart) : snbEntity.mulpart != null) return false;
        if (nprcol != null ? !nprcol.equals(snbEntity.nprcol) : snbEntity.nprcol != null) return false;
        if (orphwd != null ? !orphwd.equals(snbEntity.orphwd) : snbEntity.orphwd != null) return false;
        if (ovrenrl != null ? !ovrenrl.equals(snbEntity.ovrenrl) : snbEntity.ovrenrl != null) return false;
        if (pdeg != null ? !pdeg.equals(snbEntity.pdeg) : snbEntity.pdeg != null) return false;
        if (pdeg2 != null ? !pdeg2.equals(snbEntity.pdeg2) : snbEntity.pdeg2 != null) return false;
        if (penrlt1 != null ? !penrlt1.equals(snbEntity.penrlt1) : snbEntity.penrlt1 != null) return false;
        if (penrlt2 != null ? !penrlt2.equals(snbEntity.penrlt2) : snbEntity.penrlt2 != null) return false;
        if (penrlt3 != null ? !penrlt3.equals(snbEntity.penrlt3) : snbEntity.penrlt3 != null) return false;
        if (penrlt4 != null ? !penrlt4.equals(snbEntity.penrlt4) : snbEntity.penrlt4 != null) return false;
        if (penrlt5 != null ? !penrlt5.equals(snbEntity.penrlt5) : snbEntity.penrlt5 != null) return false;
        if (penrlt6 != null ? !penrlt6.equals(snbEntity.penrlt6) : snbEntity.penrlt6 != null) return false;
        if (pprsig != null ? !pprsig.equals(snbEntity.pprsig) : snbEntity.pprsig != null) return false;
        if (pprsig2 != null ? !pprsig2.equals(snbEntity.pprsig2) : snbEntity.pprsig2 != null) return false;
        if (prcol1 != null ? !prcol1.equals(snbEntity.prcol1) : snbEntity.prcol1 != null) return false;
        if (prcol2 != null ? !prcol2.equals(snbEntity.prcol2) : snbEntity.prcol2 != null) return false;
        if (prcol3 != null ? !prcol3.equals(snbEntity.prcol3) : snbEntity.prcol3 != null) return false;
        if (prcol4 != null ? !prcol4.equals(snbEntity.prcol4) : snbEntity.prcol4 != null) return false;
        if (prcol5 != null ? !prcol5.equals(snbEntity.prcol5) : snbEntity.prcol5 != null) return false;
        if (prcol6 != null ? !prcol6.equals(snbEntity.prcol6) : snbEntity.prcol6 != null) return false;
        if (pres != null ? !pres.equals(snbEntity.pres) : snbEntity.pres != null) return false;
        if (pres2 != null ? !pres2.equals(snbEntity.pres2) : snbEntity.pres2 != null) return false;
        if (pricmpp != null ? !pricmpp.equals(snbEntity.pricmpp) : snbEntity.pricmpp != null) return false;
        if (pricmps != null ? !pricmps.equals(snbEntity.pricmps) : snbEntity.pricmps != null) return false;
        if (procno != null ? !procno.equals(snbEntity.procno) : snbEntity.procno != null) return false;
        if (recstat != null ? !recstat.equals(snbEntity.recstat) : snbEntity.recstat != null) return false;
        if (refund != null ? !refund.equals(snbEntity.refund) : snbEntity.refund != null) return false;
        if (relfed != null ? !relfed.equals(snbEntity.relfed) : snbEntity.relfed != null) return false;
        if (relinst != null ? !relinst.equals(snbEntity.relinst) : snbEntity.relinst != null) return false;
        if (relst != null ? !relst.equals(snbEntity.relst) : snbEntity.relst != null) return false;
        if (relst2 != null ? !relst2.equals(snbEntity.relst2) : snbEntity.relst2 != null) return false;
        if (reqesar != null ? !reqesar.equals(snbEntity.reqesar) : snbEntity.reqesar != null) return false;
        if (reqfar != null ? !reqfar.equals(snbEntity.reqfar) : snbEntity.reqfar != null) return false;
        if (resgt3C != null ? !resgt3C.equals(snbEntity.resgt3C) : snbEntity.resgt3C != null) return false;
        if (resgt4C != null ? !resgt4C.equals(snbEntity.resgt4C) : snbEntity.resgt4C != null) return false;
        if (resgt4D != null ? !resgt4D.equals(snbEntity.resgt4D) : snbEntity.resgt4D != null) return false;
        if (resgt5D != null ? !resgt5D.equals(snbEntity.resgt5D) : snbEntity.resgt5D != null) return false;
        if (resgt5E != null ? !resgt5E.equals(snbEntity.resgt5E) : snbEntity.resgt5E != null) return false;
        if (resgt6E != null ? !resgt6E.equals(snbEntity.resgt6E) : snbEntity.resgt6E != null) return false;
        if (resgt6F != null ? !resgt6F.equals(snbEntity.resgt6F) : snbEntity.resgt6F != null) return false;
        if (resgt7F != null ? !resgt7F.equals(snbEntity.resgt7F) : snbEntity.resgt7F != null) return false;
        if (revdtc != null ? !revdtc.equals(snbEntity.revdtc) : snbEntity.revdtc != null) return false;
        if (revtime != null ? !revtime.equals(snbEntity.revtime) : snbEntity.revtime != null) return false;
        if (ritflag != null ? !ritflag.equals(snbEntity.ritflag) : snbEntity.ritflag != null) return false;
        if (salnr != null ? !salnr.equals(snbEntity.salnr) : snbEntity.salnr != null) return false;
        if (salnr2 != null ? !salnr2.equals(snbEntity.salnr2) : snbEntity.salnr2 != null) return false;
        if (samecol != null ? !samecol.equals(snbEntity.samecol) : snbEntity.samecol != null) return false;
        if (samstat != null ? !samstat.equals(snbEntity.samstat) : snbEntity.samstat != null) return false;
        if (sapref != null ? !sapref.equals(snbEntity.sapref) : snbEntity.sapref != null) return false;
        if (sarcflag != null ? !sarcflag.equals(snbEntity.sarcflag) : snbEntity.sarcflag != null) return false;
        if (scitizn != null ? !scitizn.equals(snbEntity.scitizn) : snbEntity.scitizn != null) return false;
        if (scitizn2 != null ? !scitizn2.equals(snbEntity.scitizn2) : snbEntity.scitizn2 != null) return false;
        if (scitizns != null ? !scitizns.equals(snbEntity.scitizns) : snbEntity.scitizns != null) return false;
        if (sdepdoc != null ? !sdepdoc.equals(snbEntity.sdepdoc) : snbEntity.sdepdoc != null) return false;
        if (seccmpp != null ? !seccmpp.equals(snbEntity.seccmpp) : snbEntity.seccmpp != null) return false;
        if (seccmps != null ? !seccmps.equals(snbEntity.seccmps) : snbEntity.seccmps != null) return false;
        if (senrlst != null ? !senrlst.equals(snbEntity.senrlst) : snbEntity.senrlst != null) return false;
        if (sgradpro != null ? !sgradpro.equals(snbEntity.sgradpro) : snbEntity.sgradpro != null) return false;
        if (shscd != null ? !shscd.equals(snbEntity.shscd) : snbEntity.shscd != null) return false;
        if (shsetp != null ? !shsetp.equals(snbEntity.shsetp) : snbEntity.shsetp != null) return false;
        if (shsetp2 != null ? !shsetp2.equals(snbEntity.shsetp2) : snbEntity.shsetp2 != null) return false;
        if (sid != null ? !sid.equals(snbEntity.sid) : snbEntity.sid != null) return false;
        if (sid2 != null ? !sid2.equals(snbEntity.sid2) : snbEntity.sid2 != null) return false;
        if (sid3 != null ? !sid3.equals(snbEntity.sid3) : snbEntity.sid3 != null) return false;
        if (sidflag != null ? !sidflag.equals(snbEntity.sidflag) : snbEntity.sidflag != null) return false;
        if (sigf != null ? !sigf.equals(snbEntity.sigf) : snbEntity.sigf != null) return false;
        if (sigm != null ? !sigm.equals(snbEntity.sigm) : snbEntity.sigm != null) return false;
        if (sigs != null ? !sigs.equals(snbEntity.sigs) : snbEntity.sigs != null) return false;
        if (sigsp != null ? !sigsp.equals(snbEntity.sigsp) : snbEntity.sigsp != null) return false;
        if (sillgble != null ? !sillgble.equals(snbEntity.sillgble) : snbEntity.sillgble != null) return false;
        if (sitecode != null ? !sitecode.equals(snbEntity.sitecode) : snbEntity.sitecode != null) return false;
        if (sname != null ? !sname.equals(snbEntity.sname) : snbEntity.sname != null) return false;
        if (snbkey != null ? !snbkey.equals(snbEntity.snbkey) : snbEntity.snbkey != null) return false;
        if (sphone != null ? !sphone.equals(snbEntity.sphone) : snbEntity.sphone != null) return false;
        if (sphone2 != null ? !sphone2.equals(snbEntity.sphone2) : snbEntity.sphone2 != null) return false;
        if (spse != null ? !spse.equals(snbEntity.spse) : snbEntity.spse != null) return false;
        if (sres != null ? !sres.equals(snbEntity.sres) : snbEntity.sres != null) return false;
        if (sres2 != null ? !sres2.equals(snbEntity.sres2) : snbEntity.sres2 != null) return false;
        if (sress != null ? !sress.equals(snbEntity.sress) : snbEntity.sress != null) return false;
        if (sssn != null ? !sssn.equals(snbEntity.sssn) : snbEntity.sssn != null) return false;
        if (sssn2 != null ? !sssn2.equals(snbEntity.sssn2) : snbEntity.sssn2 != null) return false;
        if (svet != null ? !svet.equals(snbEntity.svet) : snbEntity.svet != null) return false;
        if (svet2 != null ? !svet2.equals(snbEntity.svet2) : snbEntity.svet2 != null) return false;
        if (syrinc != null ? !syrinc.equals(snbEntity.syrinc) : snbEntity.syrinc != null) return false;
        if (syrinc2 != null ? !syrinc2.equals(snbEntity.syrinc2) : snbEntity.syrinc2 != null) return false;
        if (trantype != null ? !trantype.equals(snbEntity.trantype) : snbEntity.trantype != null) return false;
        if (typcomp != null ? !typcomp.equals(snbEntity.typcomp) : snbEntity.typcomp != null) return false;
        if (typefc != null ? !typefc.equals(snbEntity.typefc) : snbEntity.typefc != null) return false;
        if (typepf != null ? !typepf.equals(snbEntity.typepf) : snbEntity.typepf != null) return false;
        if (typeps != null ? !typeps.equals(snbEntity.typeps) : snbEntity.typeps != null) return false;
        if (typesai != null ? !typesai.equals(snbEntity.typesai) : snbEntity.typesai != null) return false;
        if (typesf != null ? !typesf.equals(snbEntity.typesf) : snbEntity.typesf != null) return false;
        if (typess != null ? !typess.equals(snbEntity.typess) : snbEntity.typess != null) return false;
        if (typfcs != null ? !typfcs.equals(snbEntity.typfcs) : snbEntity.typfcs != null) return false;
        if (typsais != null ? !typsais.equals(snbEntity.typsais) : snbEntity.typsais != null) return false;
        if (ucode != null ? !ucode.equals(snbEntity.ucode) : snbEntity.ucode != null) return false;
        if (verpri != null ? !verpri.equals(snbEntity.verpri) : snbEntity.verpri != null) return false;
        if (verprist != null ? !verprist.equals(snbEntity.verprist) : snbEntity.verprist != null) return false;
        if (versnr != null ? !versnr.equals(snbEntity.versnr) : snbEntity.versnr != null) return false;

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
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (sarcflag != null ? sarcflag.hashCode() : 0);
        result = 31 * result + (sitecode != null ? sitecode.hashCode() : 0);
        result = 31 * result + (ritflag != null ? ritflag.hashCode() : 0);
        result = 31 * result + (holdflag != null ? holdflag.hashCode() : 0);
        result = 31 * result + (autoflag != null ? autoflag.hashCode() : 0);
        result = 31 * result + btchnum;
        result = 31 * result + (trantype != null ? trantype.hashCode() : 0);
        result = 31 * result + (instcode != null ? instcode.hashCode() : 0);
        result = 31 * result + (appflg != null ? appflg.hashCode() : 0);
        result = 31 * result + (fulpart != null ? fulpart.hashCode() : 0);
        result = 31 * result + (mulpart != null ? mulpart.hashCode() : 0);
        result = 31 * result + (sid2 != null ? sid2.hashCode() : 0);
        result = 31 * result + (sid3 != null ? sid3.hashCode() : 0);
        result = 31 * result + (sssn != null ? sssn.hashCode() : 0);
        result = 31 * result + (sssn2 != null ? sssn2.hashCode() : 0);
        result = 31 * result + pin;
        result = 31 * result + pin2;
        result = 31 * result + (sidflag != null ? sidflag.hashCode() : 0);
        result = 31 * result + (procno != null ? procno.hashCode() : 0);
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (cmpstat != null ? cmpstat.hashCode() : 0);
        result = 31 * result + (samstat != null ? samstat.hashCode() : 0);
        result = 31 * result + (illgble != null ? illgble.hashCode() : 0);
        result = 31 * result + (verpri != null ? verpri.hashCode() : 0);
        result = 31 * result + (sillgble != null ? sillgble.hashCode() : 0);
        result = 31 * result + (typepf != null ? typepf.hashCode() : 0);
        result = 31 * result + (typesf != null ? typesf.hashCode() : 0);
        result = 31 * result + (typeps != null ? typeps.hashCode() : 0);
        result = 31 * result + (typess != null ? typess.hashCode() : 0);
        result = 31 * result + (dfltmch != null ? dfltmch.hashCode() : 0);
        result = 31 * result + (verprist != null ? verprist.hashCode() : 0);
        result = 31 * result + (sphone != null ? sphone.hashCode() : 0);
        result = 31 * result + (sphone2 != null ? sphone2.hashCode() : 0);
        result = 31 * result + (sres != null ? sres.hashCode() : 0);
        result = 31 * result + (sres2 != null ? sres2.hashCode() : 0);
        result = 31 * result + (sress != null ? sress.hashCode() : 0);
        result = 31 * result + (incudr0 != null ? incudr0.hashCode() : 0);
        result = 31 * result + (incudr1 != null ? incudr1.hashCode() : 0);
        result = 31 * result + (incudrx != null ? incudrx.hashCode() : 0);
        result = 31 * result + (incudr2 != null ? incudr2.hashCode() : 0);
        result = 31 * result + (incudr3 != null ? incudr3.hashCode() : 0);
        result = 31 * result + (resgt3C != null ? resgt3C.hashCode() : 0);
        result = 31 * result + (resgt4C != null ? resgt4C.hashCode() : 0);
        result = 31 * result + (resgt4D != null ? resgt4D.hashCode() : 0);
        result = 31 * result + (resgt5D != null ? resgt5D.hashCode() : 0);
        result = 31 * result + (resgt5E != null ? resgt5E.hashCode() : 0);
        result = 31 * result + (resgt6E != null ? resgt6E.hashCode() : 0);
        result = 31 * result + (resgt6F != null ? resgt6F.hashCode() : 0);
        result = 31 * result + (resgt7F != null ? resgt7F.hashCode() : 0);
        result = 31 * result + (pres != null ? pres.hashCode() : 0);
        result = 31 * result + (pres2 != null ? pres2.hashCode() : 0);
        result = 31 * result + (scitizn != null ? scitizn.hashCode() : 0);
        result = 31 * result + (scitizn2 != null ? scitizn2.hashCode() : 0);
        result = 31 * result + (scitizns != null ? scitizns.hashCode() : 0);
        result = 31 * result + (salnr != null ? salnr.hashCode() : 0);
        result = 31 * result + (salnr2 != null ? salnr2.hashCode() : 0);
        result = 31 * result + (shsetp != null ? shsetp.hashCode() : 0);
        result = 31 * result + (shsetp2 != null ? shsetp2.hashCode() : 0);
        result = 31 * result + (pdeg != null ? pdeg.hashCode() : 0);
        result = 31 * result + (pdeg2 != null ? pdeg2.hashCode() : 0);
        result = 31 * result + (spse != null ? spse.hashCode() : 0);
        result = 31 * result + (syrinc != null ? syrinc.hashCode() : 0);
        result = 31 * result + (syrinc2 != null ? syrinc2.hashCode() : 0);
        result = 31 * result + (senrlst != null ? senrlst.hashCode() : 0);
        result = 31 * result + (inrctp != null ? inrctp.hashCode() : 0);
        result = 31 * result + (inrctp2 != null ? inrctp2.hashCode() : 0);
        result = 31 * result + (penrlt1 != null ? penrlt1.hashCode() : 0);
        result = 31 * result + (penrlt2 != null ? penrlt2.hashCode() : 0);
        result = 31 * result + (penrlt3 != null ? penrlt3.hashCode() : 0);
        result = 31 * result + (penrlt4 != null ? penrlt4.hashCode() : 0);
        result = 31 * result + (penrlt5 != null ? penrlt5.hashCode() : 0);
        result = 31 * result + (penrlt6 != null ? penrlt6.hashCode() : 0);
        result = 31 * result + (enrlgh != null ? enrlgh.hashCode() : 0);
        result = 31 * result + (ovrenrl != null ? ovrenrl.hashCode() : 0);
        result = 31 * result + (born0 != null ? born0.hashCode() : 0);
        result = 31 * result + (svet != null ? svet.hashCode() : 0);
        result = 31 * result + (svet2 != null ? svet2.hashCode() : 0);
        result = 31 * result + (orphwd != null ? orphwd.hashCode() : 0);
        result = 31 * result + (lgldep != null ? lgldep.hashCode() : 0);
        result = 31 * result + (defaultr != null ? defaultr.hashCode() : 0);
        result = 31 * result + (refund != null ? refund.hashCode() : 0);
        result = 31 * result + (sapref != null ? sapref.hashCode() : 0);
        result = 31 * result + (exemp3 != null ? exemp3.hashCode() : 0);
        result = 31 * result + (exemp2 != null ? exemp2.hashCode() : 0);
        result = 31 * result + (exemp1 != null ? exemp1.hashCode() : 0);
        result = 31 * result + (exemp0 != null ? exemp0.hashCode() : 0);
        result = 31 * result + (fiscyr != null ? fiscyr.hashCode() : 0);
        result = 31 * result + (typcomp != null ? typcomp.hashCode() : 0);
        result = 31 * result + (fedaid3 != null ? fedaid3.hashCode() : 0);
        result = 31 * result + (fedaid2 != null ? fedaid2.hashCode() : 0);
        result = 31 * result + (fedaid1 != null ? fedaid1.hashCode() : 0);
        result = 31 * result + (fedaid0 != null ? fedaid0.hashCode() : 0);
        result = 31 * result + (airstat != null ? airstat.hashCode() : 0);
        result = 31 * result + (farstat != null ? farstat.hashCode() : 0);
        result = 31 * result + (esarstat != null ? esarstat.hashCode() : 0);
        result = 31 * result + (reqfar != null ? reqfar.hashCode() : 0);
        result = 31 * result + (reqesar != null ? reqesar.hashCode() : 0);
        result = 31 * result + (explain != null ? explain.hashCode() : 0);
        result = 31 * result + (divsep != null ? divsep.hashCode() : 0);
        result = 31 * result + (depstf != null ? depstf.hashCode() : 0);
        result = 31 * result + (depsts != null ? depsts.hashCode() : 0);
        result = 31 * result + (depsti != null ? depsti.hashCode() : 0);
        result = 31 * result + (relfed != null ? relfed.hashCode() : 0);
        result = 31 * result + (relst != null ? relst.hashCode() : 0);
        result = 31 * result + (relst2 != null ? relst2.hashCode() : 0);
        result = 31 * result + (relinst != null ? relinst.hashCode() : 0);
        result = 31 * result + (fdepdoc != null ? fdepdoc.hashCode() : 0);
        result = 31 * result + (sdepdoc != null ? sdepdoc.hashCode() : 0);
        result = 31 * result + (sigs != null ? sigs.hashCode() : 0);
        result = 31 * result + (sigsp != null ? sigsp.hashCode() : 0);
        result = 31 * result + (sigf != null ? sigf.hashCode() : 0);
        result = 31 * result + (sigm != null ? sigm.hashCode() : 0);
        result = 31 * result + (shscd != null ? shscd.hashCode() : 0);
        result = 31 * result + (campus1 != null ? campus1.hashCode() : 0);
        result = 31 * result + (campus2 != null ? campus2.hashCode() : 0);
        result = 31 * result + (campus3 != null ? campus3.hashCode() : 0);
        result = 31 * result + (campus4 != null ? campus4.hashCode() : 0);
        result = 31 * result + (campus5 != null ? campus5.hashCode() : 0);
        result = 31 * result + (campus6 != null ? campus6.hashCode() : 0);
        result = 31 * result + (campus21 != null ? campus21.hashCode() : 0);
        result = 31 * result + (campus22 != null ? campus22.hashCode() : 0);
        result = 31 * result + (campus23 != null ? campus23.hashCode() : 0);
        result = 31 * result + (campus24 != null ? campus24.hashCode() : 0);
        result = 31 * result + (campus25 != null ? campus25.hashCode() : 0);
        result = 31 * result + (campus26 != null ? campus26.hashCode() : 0);
        result = 31 * result + pprssn;
        result = 31 * result + pprssn2;
        result = 31 * result + pprein;
        result = 31 * result + pprein2;
        result = 31 * result + (pprsig != null ? pprsig.hashCode() : 0);
        result = 31 * result + (pprsig2 != null ? pprsig2.hashCode() : 0);
        result = 31 * result + (prcol1 != null ? prcol1.hashCode() : 0);
        result = 31 * result + (prcol2 != null ? prcol2.hashCode() : 0);
        result = 31 * result + (prcol3 != null ? prcol3.hashCode() : 0);
        result = 31 * result + (prcol4 != null ? prcol4.hashCode() : 0);
        result = 31 * result + (prcol5 != null ? prcol5.hashCode() : 0);
        result = 31 * result + (prcol6 != null ? prcol6.hashCode() : 0);
        result = 31 * result + (nprcol != null ? nprcol.hashCode() : 0);
        result = 31 * result + (samecol != null ? samecol.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (sgradpro != null ? sgradpro.hashCode() : 0);
        result = 31 * result + (degobj != null ? degobj.hashCode() : 0);
        result = 31 * result + (degobj2 != null ? degobj2.hashCode() : 0);
        result = 31 * result + savbua;
        result = 31 * result + pcons;
        result = 31 * result + scons;
        result = 31 * result + tfcs;
        result = 31 * result + (typsais != null ? typsais.hashCode() : 0);
        result = 31 * result + (typfcs != null ? typfcs.hashCode() : 0);
        result = 31 * result + (pricmps != null ? pricmps.hashCode() : 0);
        result = 31 * result + (seccmps != null ? seccmps.hashCode() : 0);
        result = 31 * result + (typesai != null ? typesai.hashCode() : 0);
        result = 31 * result + (typefc != null ? typefc.hashCode() : 0);
        result = 31 * result + (pricmpp != null ? pricmpp.hashCode() : 0);
        result = 31 * result + (seccmpp != null ? seccmpp.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
