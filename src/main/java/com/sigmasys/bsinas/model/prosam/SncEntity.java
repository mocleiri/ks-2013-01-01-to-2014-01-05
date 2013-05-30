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
 * Time: 12:03 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNC", schema = "SIGMA", catalog = "")
@Entity
public class SncEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnckey();
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

    private String snckey;

    @javax.persistence.Column(name = "SNCKEY")
    @Id
    public String getSnckey() {
        return snckey;
    }

    public void setSnckey(String snckey) {
        this.snckey = snckey;
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

    private int l41Lev;

    @javax.persistence.Column(name = "L41LEV")
    @Basic
    public int getL41Lev() {
        return l41Lev;
    }

    public void setL41Lev(int l41Lev) {
        this.l41Lev = l41Lev;
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

    private String ftrcswk;

    @javax.persistence.Column(name = "FTRCSWK")
    @Basic
    public String getFtrcswk() {
        return ftrcswk;
    }

    public void setFtrcswk(String ftrcswk) {
        this.ftrcswk = ftrcswk;
    }

    private int fsedcrd;

    @javax.persistence.Column(name = "FSEDCRD")
    @Basic
    public int getFsedcrd() {
        return fsedcrd;
    }

    public void setFsedcrd(int fsedcrd) {
        this.fsedcrd = fsedcrd;
    }

    private int fsnbemp;

    @javax.persistence.Column(name = "FSNBEMP")
    @Basic
    public int getFsnbemp() {
        return fsnbemp;
    }

    public void setFsnbemp(int fsnbemp) {
        this.fsnbemp = fsnbemp;
    }

    private int fspenpy;

    @javax.persistence.Column(name = "FSPENPY")
    @Basic
    public int getFspenpy() {
        return fspenpy;
    }

    public void setFspenpy(int fspenpy) {
        this.fspenpy = fspenpy;
    }

    private int fsirapy;

    @javax.persistence.Column(name = "FSIRAPY")
    @Basic
    public int getFsirapy() {
        return fsirapy;
    }

    public void setFsirapy(int fsirapy) {
        this.fsirapy = fsirapy;
    }

    private int fsdivin;

    @javax.persistence.Column(name = "FSDIVIN")
    @Basic
    public int getFsdivin() {
        return fsdivin;
    }

    public void setFsdivin(int fsdivin) {
        this.fsdivin = fsdivin;
    }

    private int fsirads;

    @javax.persistence.Column(name = "FSIRADS")
    @Basic
    public int getFsirads() {
        return fsirads;
    }

    public void setFsirads(int fsirads) {
        this.fsirads = fsirads;
    }

    private int fsutxpn;

    @javax.persistence.Column(name = "FSUTXPN")
    @Basic
    public int getFsutxpn() {
        return fsutxpn;
    }

    public void setFsutxpn(int fsutxpn) {
        this.fsutxpn = fsutxpn;
    }

    private int fsmcall;

    @javax.persistence.Column(name = "FSMCALL")
    @Basic
    public int getFsmcall() {
        return fsmcall;
    }

    public void setFsmcall(int fsmcall) {
        this.fsmcall = fsmcall;
    }

    private int fsornrm;

    @javax.persistence.Column(name = "FSORNRM")
    @Basic
    public int getFsornrm() {
        return fsornrm;
    }

    public void setFsornrm(int fsornrm) {
        this.fsornrm = fsornrm;
    }

    private String femancd;

    @javax.persistence.Column(name = "FEMANCD")
    @Basic
    public String getFemancd() {
        return femancd;
    }

    public void setFemancd(String femancd) {
        this.femancd = femancd;
    }

    private String flggusp;

    @javax.persistence.Column(name = "FLGGUSP")
    @Basic
    public String getFlggusp() {
        return flggusp;
    }

    public void setFlggusp(String flggusp) {
        this.flggusp = flggusp;
    }

    private String fuaccsh;

    @javax.persistence.Column(name = "FUACCSH")
    @Basic
    public String getFuaccsh() {
        return fuaccsh;
    }

    public void setFuaccsh(String fuaccsh) {
        this.fuaccsh = fuaccsh;
    }

    private String fuacchd;

    @javax.persistence.Column(name = "FUACCHD")
    @Basic
    public String getFuacchd() {
        return fuacchd;
    }

    public void setFuacchd(String fuacchd) {
        this.fuacchd = fuacchd;
    }

    private int fpedcrd;

    @javax.persistence.Column(name = "FPEDCRD")
    @Basic
    public int getFpedcrd() {
        return fpedcrd;
    }

    public void setFpedcrd(int fpedcrd) {
        this.fpedcrd = fpedcrd;
    }

    private int fpnbemp;

    @javax.persistence.Column(name = "FPNBEMP")
    @Basic
    public int getFpnbemp() {
        return fpnbemp;
    }

    public void setFpnbemp(int fpnbemp) {
        this.fpnbemp = fpnbemp;
    }

    private int fpgtsad;

    @javax.persistence.Column(name = "FPGTSAD")
    @Basic
    public int getFpgtsad() {
        return fpgtsad;
    }

    public void setFpgtsad(int fpgtsad) {
        this.fpgtsad = fpgtsad;
    }

    private int fppenpy;

    @javax.persistence.Column(name = "FPPENPY")
    @Basic
    public int getFppenpy() {
        return fppenpy;
    }

    public void setFppenpy(int fppenpy) {
        this.fppenpy = fppenpy;
    }

    private int fpirapy;

    @javax.persistence.Column(name = "FPIRAPY")
    @Basic
    public int getFpirapy() {
        return fpirapy;
    }

    public void setFpirapy(int fpirapy) {
        this.fpirapy = fpirapy;
    }

    private int fpirads;

    @javax.persistence.Column(name = "FPIRADS")
    @Basic
    public int getFpirads() {
        return fpirads;
    }

    public void setFpirads(int fpirads) {
        this.fpirads = fpirads;
    }

    private int fputxpn;

    @javax.persistence.Column(name = "FPUTXPN")
    @Basic
    public int getFputxpn() {
        return fputxpn;
    }

    public void setFputxpn(int fputxpn) {
        this.fputxpn = fputxpn;
    }

    private int fpmcall;

    @javax.persistence.Column(name = "FPMCALL")
    @Basic
    public int getFpmcall() {
        return fpmcall;
    }

    public void setFpmcall(int fpmcall) {
        this.fpmcall = fpmcall;
    }

    private int fpvnebn;

    @javax.persistence.Column(name = "FPVNEBN")
    @Basic
    public int getFpvnebn() {
        return fpvnebn;
    }

    public void setFpvnebn(int fpvnebn) {
        this.fpvnebn = fpvnebn;
    }

    private String fhlght3;

    @javax.persistence.Column(name = "FHLGHT3")
    @Basic
    public String getFhlght3() {
        return fhlght3;
    }

    public void setFhlght3(String fhlght3) {
        this.fhlght3 = fhlght3;
    }

    private String teovflg;

    @javax.persistence.Column(name = "TEOVFLG")
    @Basic
    public String getTeovflg() {
        return teovflg;
    }

    public void setTeovflg(String teovflg) {
        this.teovflg = teovflg;
    }

    private String teovcnt;

    @javax.persistence.Column(name = "TEOVCNT")
    @Basic
    public String getTeovcnt() {
        return teovcnt;
    }

    public void setTeovcnt(String teovcnt) {
        this.teovcnt = teovcnt;
    }

    private String telncnf;

    @javax.persistence.Column(name = "TELNCNF")
    @Basic
    public String getTelncnf() {
        return telncnf;
    }

    public void setTelncnf(String telncnf) {
        this.telncnf = telncnf;
    }

    private int teagpbl;

    @javax.persistence.Column(name = "TEAGPBL")
    @Basic
    public int getTeagpbl() {
        return teagpbl;
    }

    public void setTeagpbl(int teagpbl) {
        this.teagpbl = teagpbl;
    }

    private int telntot;

    @javax.persistence.Column(name = "TELNTOT")
    @Basic
    public int getTelntot() {
        return telntot;
    }

    public void setTelntot(int telntot) {
        this.telntot = telntot;
    }

    private int teugdat;

    @javax.persistence.Column(name = "TEUGDAT")
    @Basic
    public int getTeugdat() {
        return teugdat;
    }

    public void setTeugdat(int teugdat) {
        this.teugdat = teugdat;
    }

    private int tegdamt;

    @javax.persistence.Column(name = "TEGDAMT")
    @Basic
    public int getTegdamt() {
        return tegdamt;
    }

    public void setTegdamt(int tegdamt) {
        this.tegdamt = tegdamt;
    }

    private String tecchfg;

    @javax.persistence.Column(name = "TECCHFG")
    @Basic
    public String getTecchfg() {
        return tecchfg;
    }

    public void setTecchfg(String tecchfg) {
        this.tecchfg = tecchfg;
    }

    private String techgfg;

    @javax.persistence.Column(name = "TECHGFG")
    @Basic
    public String getTechgfg() {
        return techgfg;
    }

    public void setTechgfg(String techgfg) {
        this.techgfg = techgfg;
    }

    private String teaddfg;

    @javax.persistence.Column(name = "TEADDFG")
    @Basic
    public String getTeaddfg() {
        return teaddfg;
    }

    public void setTeaddfg(String teaddfg) {
        this.teaddfg = teaddfg;
    }

    private String tcnflg;

    @javax.persistence.Column(name = "TCNFLG")
    @Basic
    public String getTcnflg() {
        return tcnflg;
    }

    public void setTcnflg(String tcnflg) {
        this.tcnflg = tcnflg;
    }

    private String fsvarec;

    @javax.persistence.Column(name = "FSVAREC")
    @Basic
    public String getFsvarec() {
        return fsvarec;
    }

    public void setFsvarec(String fsvarec) {
        this.fsvarec = fsvarec;
    }

    private String fsvatyp;

    @javax.persistence.Column(name = "FSVATYP")
    @Basic
    public String getFsvatyp() {
        return fsvatyp;
    }

    public void setFsvatyp(String fsvatyp) {
        this.fsvatyp = fsvatyp;
    }

    private int tscspd;

    @javax.persistence.Column(name = "TSCSPD")
    @Basic
    public int getTscspd() {
        return tscspd;
    }

    public void setTscspd(int tscspd) {
        this.tscspd = tscspd;
    }

    private int tpcspd;

    @javax.persistence.Column(name = "TPCSPD")
    @Basic
    public int getTpcspd() {
        return tpcspd;
    }

    public void setTpcspd(int tpcspd) {
        this.tpcspd = tpcspd;
    }

    private int tncspd;

    @javax.persistence.Column(name = "TNCSPD")
    @Basic
    public int getTncspd() {
        return tncspd;
    }

    public void setTncspd(int tncspd) {
        this.tncspd = tncspd;
    }

    private String tsinex;

    @javax.persistence.Column(name = "TSINEX")
    @Basic
    public String getTsinex() {
        return tsinex;
    }

    public void setTsinex(String tsinex) {
        this.tsinex = tsinex;
    }

    private String tpinex;

    @javax.persistence.Column(name = "TPINEX")
    @Basic
    public String getTpinex() {
        return tpinex;
    }

    public void setTpinex(String tpinex) {
        this.tpinex = tpinex;
    }

    private String tninex;

    @javax.persistence.Column(name = "TNINEX")
    @Basic
    public String getTninex() {
        return tninex;
    }

    public void setTninex(String tninex) {
        this.tninex = tninex;
    }

    private String tsssn;

    @javax.persistence.Column(name = "TSSSN")
    @Basic
    public String getTsssn() {
        return tsssn;
    }

    public void setTsssn(String tsssn) {
        this.tsssn = tsssn;
    }

    private String tpfssn;

    @javax.persistence.Column(name = "TPFSSN")
    @Basic
    public String getTpfssn() {
        return tpfssn;
    }

    public void setTpfssn(String tpfssn) {
        this.tpfssn = tpfssn;
    }

    private String tpmssn;

    @javax.persistence.Column(name = "TPMSSN")
    @Basic
    public String getTpmssn() {
        return tpmssn;
    }

    public void setTpmssn(String tpmssn) {
        this.tpmssn = tpmssn;
    }

    private String tnssn;

    @javax.persistence.Column(name = "TNSSN")
    @Basic
    public String getTnssn() {
        return tnssn;
    }

    public void setTnssn(String tnssn) {
        this.tnssn = tnssn;
    }

    private String tsdobc;

    @javax.persistence.Column(name = "TSDOBC")
    @Basic
    public String getTsdobc() {
        return tsdobc;
    }

    public void setTsdobc(String tsdobc) {
        this.tsdobc = tsdobc;
    }

    private String tpfdobc;

    @javax.persistence.Column(name = "TPFDOBC")
    @Basic
    public String getTpfdobc() {
        return tpfdobc;
    }

    public void setTpfdobc(String tpfdobc) {
        this.tpfdobc = tpfdobc;
    }

    private String tpmdobc;

    @javax.persistence.Column(name = "TPMDOBC")
    @Basic
    public String getTpmdobc() {
        return tpmdobc;
    }

    public void setTpmdobc(String tpmdobc) {
        this.tpmdobc = tpmdobc;
    }

    private String tndobc;

    @javax.persistence.Column(name = "TNDOBC")
    @Basic
    public String getTndobc() {
        return tndobc;
    }

    public void setTndobc(String tndobc) {
        this.tndobc = tndobc;
    }

    private String tsnamel;

    @javax.persistence.Column(name = "TSNAMEL")
    @Basic
    public String getTsnamel() {
        return tsnamel;
    }

    public void setTsnamel(String tsnamel) {
        this.tsnamel = tsnamel;
    }

    private String tpfnaml;

    @javax.persistence.Column(name = "TPFNAML")
    @Basic
    public String getTpfnaml() {
        return tpfnaml;
    }

    public void setTpfnaml(String tpfnaml) {
        this.tpfnaml = tpfnaml;
    }

    private String tnnamel;

    @javax.persistence.Column(name = "TNNAMEL")
    @Basic
    public String getTnnamel() {
        return tnnamel;
    }

    public void setTnnamel(String tnnamel) {
        this.tnnamel = tnnamel;
    }

    private String tsnamef;

    @javax.persistence.Column(name = "TSNAMEF")
    @Basic
    public String getTsnamef() {
        return tsnamef;
    }

    public void setTsnamef(String tsnamef) {
        this.tsnamef = tsnamef;
    }

    private String tpfnamf;

    @javax.persistence.Column(name = "TPFNAMF")
    @Basic
    public String getTpfnamf() {
        return tpfnamf;
    }

    public void setTpfnamf(String tpfnamf) {
        this.tpfnamf = tpfnamf;
    }

    private String tpmnamf;

    @javax.persistence.Column(name = "TPMNAMF")
    @Basic
    public String getTpmnamf() {
        return tpmnamf;
    }

    public void setTpmnamf(String tpmnamf) {
        this.tpmnamf = tpmnamf;
    }

    private String tnnamef;

    @javax.persistence.Column(name = "TNNAMEF")
    @Basic
    public String getTnnamef() {
        return tnnamef;
    }

    public void setTnnamef(String tnnamef) {
        this.tnnamef = tnnamef;
    }

    private String tselgez;

    @javax.persistence.Column(name = "TSELGEZ")
    @Basic
    public String getTselgez() {
        return tselgez;
    }

    public void setTselgez(String tselgez) {
        this.tselgez = tselgez;
    }

    private String tpelgez;

    @javax.persistence.Column(name = "TPELGEZ")
    @Basic
    public String getTpelgez() {
        return tpelgez;
    }

    public void setTpelgez(String tpelgez) {
        this.tpelgez = tpelgez;
    }

    private String tnelgez;

    @javax.persistence.Column(name = "TNELGEZ")
    @Basic
    public String getTnelgez() {
        return tnelgez;
    }

    public void setTnelgez(String tnelgez) {
        this.tnelgez = tnelgez;
    }

    private String tsmrtls;

    @javax.persistence.Column(name = "TSMRTLS")
    @Basic
    public String getTsmrtls() {
        return tsmrtls;
    }

    public void setTsmrtls(String tsmrtls) {
        this.tsmrtls = tsmrtls;
    }

    private String tpmrtls;

    @javax.persistence.Column(name = "TPMRTLS")
    @Basic
    public String getTpmrtls() {
        return tpmrtls;
    }

    public void setTpmrtls(String tpmrtls) {
        this.tpmrtls = tpmrtls;
    }

    private String tnmrtls;

    @javax.persistence.Column(name = "TNMRTLS")
    @Basic
    public String getTnmrtls() {
        return tnmrtls;
    }

    public void setTnmrtls(String tnmrtls) {
        this.tnmrtls = tnmrtls;
    }

    private String tsmrtdc;

    @javax.persistence.Column(name = "TSMRTDC")
    @Basic
    public String getTsmrtdc() {
        return tsmrtdc;
    }

    public void setTsmrtdc(String tsmrtdc) {
        this.tsmrtdc = tsmrtdc;
    }

    private String tpmrtdc;

    @javax.persistence.Column(name = "TPMRTDC")
    @Basic
    public String getTpmrtdc() {
        return tpmrtdc;
    }

    public void setTpmrtdc(String tpmrtdc) {
        this.tpmrtdc = tpmrtdc;
    }

    private String tnmrtdc;

    @javax.persistence.Column(name = "TNMRTDC")
    @Basic
    public String getTnmrtdc() {
        return tnmrtdc;
    }

    public void setTnmrtdc(String tnmrtdc) {
        this.tnmrtdc = tnmrtdc;
    }

    private int tscomby;

    @javax.persistence.Column(name = "TSCOMBY")
    @Basic
    public int getTscomby() {
        return tscomby;
    }

    public void setTscomby(int tscomby) {
        this.tscomby = tscomby;
    }

    private int tpcomby;

    @javax.persistence.Column(name = "TPCOMBY")
    @Basic
    public int getTpcomby() {
        return tpcomby;
    }

    public void setTpcomby(int tpcomby) {
        this.tpcomby = tpcomby;
    }

    private int tncomby;

    @javax.persistence.Column(name = "TNCOMBY")
    @Basic
    public int getTncomby() {
        return tncomby;
    }

    public void setTncomby(int tncomby) {
        this.tncomby = tncomby;
    }

    private String tsdislw;

    @javax.persistence.Column(name = "TSDISLW")
    @Basic
    public String getTsdislw() {
        return tsdislw;
    }

    public void setTsdislw(String tsdislw) {
        this.tsdislw = tsdislw;
    }

    private String tpdislw;

    @javax.persistence.Column(name = "TPDISLW")
    @Basic
    public String getTpdislw() {
        return tpdislw;
    }

    public void setTpdislw(String tpdislw) {
        this.tpdislw = tpdislw;
    }

    private String tndislw;

    @javax.persistence.Column(name = "TNDISLW")
    @Basic
    public String getTndislw() {
        return tndislw;
    }

    public void setTndislw(String tndislw) {
        this.tndislw = tndislw;
    }

    private int tsmrpd;

    @javax.persistence.Column(name = "TSMRPD")
    @Basic
    public int getTsmrpd() {
        return tsmrpd;
    }

    public void setTsmrpd(int tsmrpd) {
        this.tsmrpd = tsmrpd;
    }

    private int tpmrpd;

    @javax.persistence.Column(name = "TPMRPD")
    @Basic
    public int getTpmrpd() {
        return tpmrpd;
    }

    public void setTpmrpd(int tpmrpd) {
        this.tpmrpd = tpmrpd;
    }

    private int tnmrpd;

    @javax.persistence.Column(name = "TNMRPD")
    @Basic
    public int getTnmrpd() {
        return tnmrpd;
    }

    public void setTnmrpd(int tnmrpd) {
        this.tnmrpd = tnmrpd;
    }

    private int tsttxi;

    @javax.persistence.Column(name = "TSTTXI")
    @Basic
    public int getTsttxi() {
        return tsttxi;
    }

    public void setTsttxi(int tsttxi) {
        this.tsttxi = tsttxi;
    }

    private int tpttxi;

    @javax.persistence.Column(name = "TPTTXI")
    @Basic
    public int getTpttxi() {
        return tpttxi;
    }

    public void setTpttxi(int tpttxi) {
        this.tpttxi = tpttxi;
    }

    private int tnttxi;

    @javax.persistence.Column(name = "TNTTXI")
    @Basic
    public int getTnttxi() {
        return tnttxi;
    }

    public void setTnttxi(int tnttxi) {
        this.tnttxi = tnttxi;
    }

    private String tssided;

    @javax.persistence.Column(name = "TSSIDED")
    @Basic
    public String getTssided() {
        return tssided;
    }

    public void setTssided(String tssided) {
        this.tssided = tssided;
    }

    private String tpsided;

    @javax.persistence.Column(name = "TPSIDED")
    @Basic
    public String getTpsided() {
        return tpsided;
    }

    public void setTpsided(String tpsided) {
        this.tpsided = tpsided;
    }

    private String tnsided;

    @javax.persistence.Column(name = "TNSIDED")
    @Basic
    public String getTnsided() {
        return tnsided;
    }

    public void setTnsided(String tnsided) {
        this.tnsided = tnsided;
    }

    private int tsalrec;

    @javax.persistence.Column(name = "TSALREC")
    @Basic
    public int getTsalrec() {
        return tsalrec;
    }

    public void setTsalrec(int tsalrec) {
        this.tsalrec = tsalrec;
    }

    private int tpalrec;

    @javax.persistence.Column(name = "TPALREC")
    @Basic
    public int getTpalrec() {
        return tpalrec;
    }

    public void setTpalrec(int tpalrec) {
        this.tpalrec = tpalrec;
    }

    private int tnalrec;

    @javax.persistence.Column(name = "TNALREC")
    @Basic
    public int getTnalrec() {
        return tnalrec;
    }

    public void setTnalrec(int tnalrec) {
        this.tnalrec = tnalrec;
    }

    private int tsothgn;

    @javax.persistence.Column(name = "TSOTHGN")
    @Basic
    public int getTsothgn() {
        return tsothgn;
    }

    public void setTsothgn(int tsothgn) {
        this.tsothgn = tsothgn;
    }

    private int tpothgn;

    @javax.persistence.Column(name = "TPOTHGN")
    @Basic
    public int getTpothgn() {
        return tpothgn;
    }

    public void setTpothgn(int tpothgn) {
        this.tpothgn = tpothgn;
    }

    private int tnothgn;

    @javax.persistence.Column(name = "TNOTHGN")
    @Basic
    public int getTnothgn() {
        return tnothgn;
    }

    public void setTnothgn(int tnothgn) {
        this.tnothgn = tnothgn;
    }

    private int tsedexp;

    @javax.persistence.Column(name = "TSEDEXP")
    @Basic
    public int getTsedexp() {
        return tsedexp;
    }

    public void setTsedexp(int tsedexp) {
        this.tsedexp = tsedexp;
    }

    private int tpedexp;

    @javax.persistence.Column(name = "TPEDEXP")
    @Basic
    public int getTpedexp() {
        return tpedexp;
    }

    public void setTpedexp(int tpedexp) {
        this.tpedexp = tpedexp;
    }

    private int tnedexp;

    @javax.persistence.Column(name = "TNEDEXP")
    @Basic
    public int getTnedexp() {
        return tnedexp;
    }

    public void setTnedexp(int tnedexp) {
        this.tnedexp = tnedexp;
    }

    private int tsreexp;

    @javax.persistence.Column(name = "TSREEXP")
    @Basic
    public int getTsreexp() {
        return tsreexp;
    }

    public void setTsreexp(int tsreexp) {
        this.tsreexp = tsreexp;
    }

    private int tpreexp;

    @javax.persistence.Column(name = "TPREEXP")
    @Basic
    public int getTpreexp() {
        return tpreexp;
    }

    public void setTpreexp(int tpreexp) {
        this.tpreexp = tpreexp;
    }

    private int tnreexp;

    @javax.persistence.Column(name = "TNREEXP")
    @Basic
    public int getTnreexp() {
        return tnreexp;
    }

    public void setTnreexp(int tnreexp) {
        this.tnreexp = tnreexp;
    }

    private int tshlths;

    @javax.persistence.Column(name = "TSHLTHS")
    @Basic
    public int getTshlths() {
        return tshlths;
    }

    public void setTshlths(int tshlths) {
        this.tshlths = tshlths;
    }

    private int tphlths;

    @javax.persistence.Column(name = "TPHLTHS")
    @Basic
    public int getTphlths() {
        return tphlths;
    }

    public void setTphlths(int tphlths) {
        this.tphlths = tphlths;
    }

    private int tnhlths;

    @javax.persistence.Column(name = "TNHLTHS")
    @Basic
    public int getTnhlths() {
        return tnhlths;
    }

    public void setTnhlths(int tnhlths) {
        this.tnhlths = tnhlths;
    }

    private int tsmvexp;

    @javax.persistence.Column(name = "TSMVEXP")
    @Basic
    public int getTsmvexp() {
        return tsmvexp;
    }

    public void setTsmvexp(int tsmvexp) {
        this.tsmvexp = tsmvexp;
    }

    private int tpmvexp;

    @javax.persistence.Column(name = "TPMVEXP")
    @Basic
    public int getTpmvexp() {
        return tpmvexp;
    }

    public void setTpmvexp(int tpmvexp) {
        this.tpmvexp = tpmvexp;
    }

    private int tnmvexp;

    @javax.persistence.Column(name = "TNMVEXP")
    @Basic
    public int getTnmvexp() {
        return tnmvexp;
    }

    public void setTnmvexp(int tnmvexp) {
        this.tnmvexp = tnmvexp;
    }

    private int tssempt;

    @javax.persistence.Column(name = "TSSEMPT")
    @Basic
    public int getTssempt() {
        return tssempt;
    }

    public void setTssempt(int tssempt) {
        this.tssempt = tssempt;
    }

    private int tpsempt;

    @javax.persistence.Column(name = "TPSEMPT")
    @Basic
    public int getTpsempt() {
        return tpsempt;
    }

    public void setTpsempt(int tpsempt) {
        this.tpsempt = tpsempt;
    }

    private int tnsempt;

    @javax.persistence.Column(name = "TNSEMPT")
    @Basic
    public int getTnsempt() {
        return tnsempt;
    }

    public void setTnsempt(int tnsempt) {
        this.tnsempt = tnsempt;
    }

    private int tssemph;

    @javax.persistence.Column(name = "TSSEMPH")
    @Basic
    public int getTssemph() {
        return tssemph;
    }

    public void setTssemph(int tssemph) {
        this.tssemph = tssemph;
    }

    private int tpsemph;

    @javax.persistence.Column(name = "TPSEMPH")
    @Basic
    public int getTpsemph() {
        return tpsemph;
    }

    public void setTpsemph(int tpsemph) {
        this.tpsemph = tpsemph;
    }

    private int tnsemph;

    @javax.persistence.Column(name = "TNSEMPH")
    @Basic
    public int getTnsemph() {
        return tnsemph;
    }

    public void setTnsemph(int tnsemph) {
        this.tnsemph = tnsemph;
    }

    private int tspenew;

    @javax.persistence.Column(name = "TSPENEW")
    @Basic
    public int getTspenew() {
        return tspenew;
    }

    public void setTspenew(int tspenew) {
        this.tspenew = tspenew;
    }

    private int tppenew;

    @javax.persistence.Column(name = "TPPENEW")
    @Basic
    public int getTppenew() {
        return tppenew;
    }

    public void setTppenew(int tppenew) {
        this.tppenew = tppenew;
    }

    private int tnpenew;

    @javax.persistence.Column(name = "TNPENEW")
    @Basic
    public int getTnpenew() {
        return tnpenew;
    }

    public void setTnpenew(int tnpenew) {
        this.tnpenew = tnpenew;
    }

    private int tslnint;

    @javax.persistence.Column(name = "TSLNINT")
    @Basic
    public int getTslnint() {
        return tslnint;
    }

    public void setTslnint(int tslnint) {
        this.tslnint = tslnint;
    }

    private int tplnint;

    @javax.persistence.Column(name = "TPLNINT")
    @Basic
    public int getTplnint() {
        return tplnint;
    }

    public void setTplnint(int tplnint) {
        this.tplnint = tplnint;
    }

    private int tnlnint;

    @javax.persistence.Column(name = "TNLNINT")
    @Basic
    public int getTnlnint() {
        return tnlnint;
    }

    public void setTnlnint(int tnlnint) {
        this.tnlnint = tnlnint;
    }

    private int tstufd;

    @javax.persistence.Column(name = "TSTUFD")
    @Basic
    public int getTstufd() {
        return tstufd;
    }

    public void setTstufd(int tstufd) {
        this.tstufd = tstufd;
    }

    private int tptufd;

    @javax.persistence.Column(name = "TPTUFD")
    @Basic
    public int getTptufd() {
        return tptufd;
    }

    public void setTptufd(int tptufd) {
        this.tptufd = tptufd;
    }

    private int tntupd;

    @javax.persistence.Column(name = "TNTUPD")
    @Basic
    public int getTntupd() {
        return tntupd;
    }

    public void setTntupd(int tntupd) {
        this.tntupd = tntupd;
    }

    private int tsdprdd;

    @javax.persistence.Column(name = "TSDPRDD")
    @Basic
    public int getTsdprdd() {
        return tsdprdd;
    }

    public void setTsdprdd(int tsdprdd) {
        this.tsdprdd = tsdprdd;
    }

    private int tpdprdd;

    @javax.persistence.Column(name = "TPDPRDD")
    @Basic
    public int getTpdprdd() {
        return tpdprdd;
    }

    public void setTpdprdd(int tpdprdd) {
        this.tpdprdd = tpdprdd;
    }

    private int tndprdd;

    @javax.persistence.Column(name = "TNDPRDD")
    @Basic
    public int getTndprdd() {
        return tndprdd;
    }

    public void setTndprdd(int tndprdd) {
        this.tndprdd = tndprdd;
    }

    private int fpint;

    @javax.persistence.Column(name = "FPINT")
    @Basic
    public int getFpint() {
        return fpint;
    }

    public void setFpint(int fpint) {
        this.fpint = fpint;
    }

    private int fsoutx;

    @javax.persistence.Column(name = "FSOUTX")
    @Basic
    public int getFsoutx() {
        return fsoutx;
    }

    public void setFsoutx(int fsoutx) {
        this.fsoutx = fsoutx;
    }

    private int fpoutx;

    @javax.persistence.Column(name = "FPOUTX")
    @Basic
    public int getFpoutx() {
        return fpoutx;
    }

    public void setFpoutx(int fpoutx) {
        this.fpoutx = fpoutx;
    }

    private int tnmexp;

    @javax.persistence.Column(name = "TNMEXP")
    @Basic
    public int getTnmexp() {
        return tnmexp;
    }

    public void setTnmexp(int tnmexp) {
        this.tnmexp = tnmexp;
    }

    private String vercd1;

    @javax.persistence.Column(name = "VERCD1")
    @Basic
    public String getVercd1() {
        return vercd1;
    }

    public void setVercd1(String vercd1) {
        this.vercd1 = vercd1;
    }

    private String vercd2;

    @javax.persistence.Column(name = "VERCD2")
    @Basic
    public String getVercd2() {
        return vercd2;
    }

    public void setVercd2(String vercd2) {
        this.vercd2 = vercd2;
    }

    private String vercd3;

    @javax.persistence.Column(name = "VERCD3")
    @Basic
    public String getVercd3() {
        return vercd3;
    }

    public void setVercd3(String vercd3) {
        this.vercd3 = vercd3;
    }

    private String vercd4;

    @javax.persistence.Column(name = "VERCD4")
    @Basic
    public String getVercd4() {
        return vercd4;
    }

    public void setVercd4(String vercd4) {
        this.vercd4 = vercd4;
    }

    private String vercd5;

    @javax.persistence.Column(name = "VERCD5")
    @Basic
    public String getVercd5() {
        return vercd5;
    }

    public void setVercd5(String vercd5) {
        this.vercd5 = vercd5;
    }

    private String vercd6;

    @javax.persistence.Column(name = "VERCD6")
    @Basic
    public String getVercd6() {
        return vercd6;
    }

    public void setVercd6(String vercd6) {
        this.vercd6 = vercd6;
    }

    private String vercd7;

    @javax.persistence.Column(name = "VERCD7")
    @Basic
    public String getVercd7() {
        return vercd7;
    }

    public void setVercd7(String vercd7) {
        this.vercd7 = vercd7;
    }

    private String vercd8;

    @javax.persistence.Column(name = "VERCD8")
    @Basic
    public String getVercd8() {
        return vercd8;
    }

    public void setVercd8(String vercd8) {
        this.vercd8 = vercd8;
    }

    private String vercd9;

    @javax.persistence.Column(name = "VERCD9")
    @Basic
    public String getVercd9() {
        return vercd9;
    }

    public void setVercd9(String vercd9) {
        this.vercd9 = vercd9;
    }

    private String vercd10;

    @javax.persistence.Column(name = "VERCD10")
    @Basic
    public String getVercd10() {
        return vercd10;
    }

    public void setVercd10(String vercd10) {
        this.vercd10 = vercd10;
    }

    private String verdte;

    @javax.persistence.Column(name = "VERDTE")
    @Basic
    public String getVerdte() {
        return verdte;
    }

    public void setVerdte(String verdte) {
        this.verdte = verdte;
    }

    private String faowner;

    @javax.persistence.Column(name = "FAOWNER")
    @Basic
    public String getFaowner() {
        return faowner;
    }

    public void setFaowner(String faowner) {
        this.faowner = faowner;
    }

    private String schcedf;

    @javax.persistence.Column(name = "SCHCEDF")
    @Basic
    public String getSchcedf() {
        return schcedf;
    }

    public void setSchcedf(String schcedf) {
        this.schcedf = schcedf;
    }

    private String sblind;

    @javax.persistence.Column(name = "SBLIND")
    @Basic
    public String getSblind() {
        return sblind;
    }

    public void setSblind(String sblind) {
        this.sblind = sblind;
    }

    private String pblind;

    @javax.persistence.Column(name = "PBLIND")
    @Basic
    public String getPblind() {
        return pblind;
    }

    public void setPblind(String pblind) {
        this.pblind = pblind;
    }

    private String strust;

    @javax.persistence.Column(name = "STRUST")
    @Basic
    public String getStrust() {
        return strust;
    }

    public void setStrust(String strust) {
        this.strust = strust;
    }

    private String ptrust;

    @javax.persistence.Column(name = "PTRUST")
    @Basic
    public String getPtrust() {
        return ptrust;
    }

    public void setPtrust(String ptrust) {
        this.ptrust = ptrust;
    }

    private String ovsmrtl;

    @javax.persistence.Column(name = "OVSMRTL")
    @Basic
    public String getOvsmrtl() {
        return ovsmrtl;
    }

    public void setOvsmrtl(String ovsmrtl) {
        this.ovsmrtl = ovsmrtl;
    }

    private String ovpmrtl;

    @javax.persistence.Column(name = "OVPMRTL")
    @Basic
    public String getOvpmrtl() {
        return ovpmrtl;
    }

    public void setOvpmrtl(String ovpmrtl) {
        this.ovpmrtl = ovpmrtl;
    }

    private String ovsflst;

    @javax.persistence.Column(name = "OVSFLST")
    @Basic
    public String getOvsflst() {
        return ovsflst;
    }

    public void setOvsflst(String ovsflst) {
        this.ovsflst = ovsflst;
    }

    private String ovpflst;

    @javax.persistence.Column(name = "OVPFLST")
    @Basic
    public String getOvpflst() {
        return ovpflst;
    }

    public void setOvpflst(String ovpflst) {
        this.ovpflst = ovpflst;
    }

    private String ovstxrt;

    @javax.persistence.Column(name = "OVSTXRT")
    @Basic
    public String getOvstxrt() {
        return ovstxrt;
    }

    public void setOvstxrt(String ovstxrt) {
        this.ovstxrt = ovstxrt;
    }

    private String ovptxrt;

    @javax.persistence.Column(name = "OVPTXRT")
    @Basic
    public String getOvptxrt() {
        return ovptxrt;
    }

    public void setOvptxrt(String ovptxrt) {
        this.ovptxrt = ovptxrt;
    }

    private BigInteger numpar;

    @javax.persistence.Column(name = "NUMPAR")
    @Basic
    public BigInteger getNumpar() {
        return numpar;
    }

    public void setNumpar(BigInteger numpar) {
        this.numpar = numpar;
    }

    private BigDecimal uia;

    @javax.persistence.Column(name = "UIA")
    @Basic
    public BigDecimal getUia() {
        return uia;
    }

    public void setUia(BigDecimal uia) {
        this.uia = uia;
    }

    private BigDecimal suati;

    @javax.persistence.Column(name = "SUATI")
    @Basic
    public BigDecimal getSuati() {
        return suati;
    }

    public void setSuati(BigDecimal suati) {
        this.suati = suati;
    }

    private BigDecimal puati;

    @javax.persistence.Column(name = "PUATI")
    @Basic
    public BigDecimal getPuati() {
        return puati;
    }

    public void setPuati(BigDecimal puati) {
        this.puati = puati;
    }

    private BigDecimal suata;

    @javax.persistence.Column(name = "SUATA")
    @Basic
    public BigDecimal getSuata() {
        return suata;
    }

    public void setSuata(BigDecimal suata) {
        this.suata = suata;
    }

    private BigDecimal puata;

    @javax.persistence.Column(name = "PUATA")
    @Basic
    public BigDecimal getPuata() {
        return puata;
    }

    public void setPuata(BigDecimal puata) {
        this.puata = puata;
    }

    private BigDecimal sogladj;

    @javax.persistence.Column(name = "SOGLADJ")
    @Basic
    public BigDecimal getSogladj() {
        return sogladj;
    }

    public void setSogladj(BigDecimal sogladj) {
        this.sogladj = sogladj;
    }

    private BigDecimal pogladj;

    @javax.persistence.Column(name = "POGLADJ")
    @Basic
    public BigDecimal getPogladj() {
        return pogladj;
    }

    public void setPogladj(BigDecimal pogladj) {
        this.pogladj = pogladj;
    }

    private BigDecimal seduexp;

    @javax.persistence.Column(name = "SEDUEXP")
    @Basic
    public BigDecimal getSeduexp() {
        return seduexp;
    }

    public void setSeduexp(BigDecimal seduexp) {
        this.seduexp = seduexp;
    }

    private BigDecimal peduexp;

    @javax.persistence.Column(name = "PEDUEXP")
    @Basic
    public BigDecimal getPeduexp() {
        return peduexp;
    }

    public void setPeduexp(BigDecimal peduexp) {
        this.peduexp = peduexp;
    }

    private BigDecimal sslded;

    @javax.persistence.Column(name = "SSLDED")
    @Basic
    public BigDecimal getSslded() {
        return sslded;
    }

    public void setSslded(BigDecimal sslded) {
        this.sslded = sslded;
    }

    private BigDecimal pslded;

    @javax.persistence.Column(name = "PSLDED")
    @Basic
    public BigDecimal getPslded() {
        return pslded;
    }

    public void setPslded(BigDecimal pslded) {
        this.pslded = pslded;
    }

    private BigDecimal stufeed;

    @javax.persistence.Column(name = "STUFEED")
    @Basic
    public BigDecimal getStufeed() {
        return stufeed;
    }

    public void setStufeed(BigDecimal stufeed) {
        this.stufeed = stufeed;
    }

    private BigDecimal ptufeed;

    @javax.persistence.Column(name = "PTUFEED")
    @Basic
    public BigDecimal getPtufeed() {
        return ptufeed;
    }

    public void setPtufeed(BigDecimal ptufeed) {
        this.ptufeed = ptufeed;
    }

    private BigDecimal sdeduct;

    @javax.persistence.Column(name = "SDEDUCT")
    @Basic
    public BigDecimal getSdeduct() {
        return sdeduct;
    }

    public void setSdeduct(BigDecimal sdeduct) {
        this.sdeduct = sdeduct;
    }

    private BigDecimal pdeduct;

    @javax.persistence.Column(name = "PDEDUCT")
    @Basic
    public BigDecimal getPdeduct() {
        return pdeduct;
    }

    public void setPdeduct(BigDecimal pdeduct) {
        this.pdeduct = pdeduct;
    }

    private BigDecimal svcash;

    @javax.persistence.Column(name = "SVCASH")
    @Basic
    public BigDecimal getSvcash() {
        return svcash;
    }

    public void setSvcash(BigDecimal svcash) {
        this.svcash = svcash;
    }

    private BigDecimal pvcash;

    @javax.persistence.Column(name = "PVCASH")
    @Basic
    public BigDecimal getPvcash() {
        return pvcash;
    }

    public void setPvcash(BigDecimal pvcash) {
        this.pvcash = pvcash;
    }

    private BigDecimal svinv;

    @javax.persistence.Column(name = "SVINV")
    @Basic
    public BigDecimal getSvinv() {
        return svinv;
    }

    public void setSvinv(BigDecimal svinv) {
        this.svinv = svinv;
    }

    private BigDecimal pvinv;

    @javax.persistence.Column(name = "PVINV")
    @Basic
    public BigDecimal getPvinv() {
        return pvinv;
    }

    public void setPvinv(BigDecimal pvinv) {
        this.pvinv = pvinv;
    }

    private BigDecimal svrest;

    @javax.persistence.Column(name = "SVREST")
    @Basic
    public BigDecimal getSvrest() {
        return svrest;
    }

    public void setSvrest(BigDecimal svrest) {
        this.svrest = svrest;
    }

    private BigDecimal pvrest;

    @javax.persistence.Column(name = "PVREST")
    @Basic
    public BigDecimal getPvrest() {
        return pvrest;
    }

    public void setPvrest(BigDecimal pvrest) {
        this.pvrest = pvrest;
    }

    private BigDecimal svmort;

    @javax.persistence.Column(name = "SVMORT")
    @Basic
    public BigDecimal getSvmort() {
        return svmort;
    }

    public void setSvmort(BigDecimal svmort) {
        this.svmort = svmort;
    }

    private BigDecimal pvmort;

    @javax.persistence.Column(name = "PVMORT")
    @Basic
    public BigDecimal getPvmort() {
        return pvmort;
    }

    public void setPvmort(BigDecimal pvmort) {
        this.pvmort = pvmort;
    }

    private BigDecimal svbfnet;

    @javax.persistence.Column(name = "SVBFNET")
    @Basic
    public BigDecimal getSvbfnet() {
        return svbfnet;
    }

    public void setSvbfnet(BigDecimal svbfnet) {
        this.svbfnet = svbfnet;
    }

    private BigDecimal pvbfnet;

    @javax.persistence.Column(name = "PVBFNET")
    @Basic
    public BigDecimal getPvbfnet() {
        return pvbfnet;
    }

    public void setPvbfnet(BigDecimal pvbfnet) {
        this.pvbfnet = pvbfnet;
    }

    private BigDecimal svedsv;

    @javax.persistence.Column(name = "SVEDSV")
    @Basic
    public BigDecimal getSvedsv() {
        return svedsv;
    }

    public void setSvedsv(BigDecimal svedsv) {
        this.svedsv = svedsv;
    }

    private BigDecimal pvedsv;

    @javax.persistence.Column(name = "PVEDSV")
    @Basic
    public BigDecimal getPvedsv() {
        return pvedsv;
    }

    public void setPvedsv(BigDecimal pvedsv) {
        this.pvedsv = pvedsv;
    }

    private BigDecimal stottax;

    @javax.persistence.Column(name = "STOTTAX")
    @Basic
    public BigDecimal getStottax() {
        return stottax;
    }

    public void setStottax(BigDecimal stottax) {
        this.stottax = stottax;
    }

    private BigDecimal ptottax;

    @javax.persistence.Column(name = "PTOTTAX")
    @Basic
    public BigDecimal getPtottax() {
        return ptottax;
    }

    public void setPtottax(BigDecimal ptottax) {
        this.ptottax = ptottax;
    }

    private BigDecimal stotint;

    @javax.persistence.Column(name = "STOTINT")
    @Basic
    public BigDecimal getStotint() {
        return stotint;
    }

    public void setStotint(BigDecimal stotint) {
        this.stotint = stotint;
    }

    private BigDecimal ptotint;

    @javax.persistence.Column(name = "PTOTINT")
    @Basic
    public BigDecimal getPtotint() {
        return ptotint;
    }

    public void setPtotint(BigDecimal ptotint) {
        this.ptotint = ptotint;
    }

    private BigDecimal sdeplet;

    @javax.persistence.Column(name = "SDEPLET")
    @Basic
    public BigDecimal getSdeplet() {
        return sdeplet;
    }

    public void setSdeplet(BigDecimal sdeplet) {
        this.sdeplet = sdeplet;
    }

    private BigDecimal pdeplet;

    @javax.persistence.Column(name = "PDEPLET")
    @Basic
    public BigDecimal getPdeplet() {
        return pdeplet;
    }

    public void setPdeplet(BigDecimal pdeplet) {
        this.pdeplet = pdeplet;
    }

    private BigDecimal sdeprec;

    @javax.persistence.Column(name = "SDEPREC")
    @Basic
    public BigDecimal getSdeprec() {
        return sdeprec;
    }

    public void setSdeprec(BigDecimal sdeprec) {
        this.sdeprec = sdeprec;
    }

    private BigDecimal pdeprec;

    @javax.persistence.Column(name = "PDEPREC")
    @Basic
    public BigDecimal getPdeprec() {
        return pdeprec;
    }

    public void setPdeprec(BigDecimal pdeprec) {
        this.pdeprec = pdeprec;
    }

    private BigDecimal shombus;

    @javax.persistence.Column(name = "SHOMBUS")
    @Basic
    public BigDecimal getShombus() {
        return shombus;
    }

    public void setShombus(BigDecimal shombus) {
        this.shombus = shombus;
    }

    private BigDecimal phombus;

    @javax.persistence.Column(name = "PHOMBUS")
    @Basic
    public BigDecimal getPhombus() {
        return phombus;
    }

    public void setPhombus(BigDecimal phombus) {
        this.phombus = phombus;
    }

    private BigDecimal scostl;

    @javax.persistence.Column(name = "SCOSTL")
    @Basic
    public BigDecimal getScostl() {
        return scostl;
    }

    public void setScostl(BigDecimal scostl) {
        this.scostl = scostl;
    }

    private BigDecimal pcostl;

    @javax.persistence.Column(name = "PCOSTL")
    @Basic
    public BigDecimal getPcostl() {
        return pcostl;
    }

    public void setPcostl(BigDecimal pcostl) {
        this.pcostl = pcostl;
    }

    private BigDecimal stlts;

    @javax.persistence.Column(name = "STLTS")
    @Basic
    public BigDecimal getStlts() {
        return stlts;
    }

    public void setStlts(BigDecimal stlts) {
        this.stlts = stlts;
    }

    private BigDecimal ptlts;

    @javax.persistence.Column(name = "PTLTS")
    @Basic
    public BigDecimal getPtlts() {
        return ptlts;
    }

    public void setPtlts(BigDecimal ptlts) {
        this.ptlts = ptlts;
    }

    private BigDecimal sdprdpl;

    @javax.persistence.Column(name = "SDPRDPL")
    @Basic
    public BigDecimal getSdprdpl() {
        return sdprdpl;
    }

    public void setSdprdpl(BigDecimal sdprdpl) {
        this.sdprdpl = sdprdpl;
    }

    private BigDecimal pdprdpl;

    @javax.persistence.Column(name = "PDPRDPL")
    @Basic
    public BigDecimal getPdprdpl() {
        return pdprdpl;
    }

    public void setPdprdpl(BigDecimal pdprdpl) {
        this.pdprdpl = pdprdpl;
    }

    private BigDecimal sdep179;

    @javax.persistence.Column(name = "SDEP179")
    @Basic
    public BigDecimal getSdep179() {
        return sdep179;
    }

    public void setSdep179(BigDecimal sdep179) {
        this.sdep179 = sdep179;
    }

    private BigDecimal pdep179;

    @javax.persistence.Column(name = "PDEP179")
    @Basic
    public BigDecimal getPdep179() {
        return pdep179;
    }

    public void setPdep179(BigDecimal pdep179) {
        this.pdep179 = pdep179;
    }

    private BigInteger ovpgtrn;

    @javax.persistence.Column(name = "OVPGTRN")
    @Basic
    public BigInteger getOvpgtrn() {
        return ovpgtrn;
    }

    public void setOvpgtrn(BigInteger ovpgtrn) {
        this.ovpgtrn = ovpgtrn;
    }

    private BigDecimal ovstxpd;

    @javax.persistence.Column(name = "OVSTXPD")
    @Basic
    public BigDecimal getOvstxpd() {
        return ovstxpd;
    }

    public void setOvstxpd(BigDecimal ovstxpd) {
        this.ovstxpd = ovstxpd;
    }

    private BigDecimal ovptxpd;

    @javax.persistence.Column(name = "OVPTXPD")
    @Basic
    public BigDecimal getOvptxpd() {
        return ovptxpd;
    }

    public void setOvptxpd(BigDecimal ovptxpd) {
        this.ovptxpd = ovptxpd;
    }

    private BigDecimal ovsc;

    @javax.persistence.Column(name = "OVSC")
    @Basic
    public BigDecimal getOvsc() {
        return ovsc;
    }

    public void setOvsc(BigDecimal ovsc) {
        this.ovsc = ovsc;
    }

    private BigDecimal ovpc;

    @javax.persistence.Column(name = "OVPC")
    @Basic
    public BigDecimal getOvpc() {
        return ovpc;
    }

    public void setOvpc(BigDecimal ovpc) {
        this.ovpc = ovpc;
    }

    private BigDecimal ovsexcl;

    @javax.persistence.Column(name = "OVSEXCL")
    @Basic
    public BigDecimal getOvsexcl() {
        return ovsexcl;
    }

    public void setOvsexcl(BigDecimal ovsexcl) {
        this.ovsexcl = ovsexcl;
    }

    private BigDecimal ovpexcl;

    @javax.persistence.Column(name = "OVPEXCL")
    @Basic
    public BigDecimal getOvpexcl() {
        return ovpexcl;
    }

    public void setOvpexcl(BigDecimal ovpexcl) {
        this.ovpexcl = ovpexcl;
    }

    private BigDecimal ovsasst;

    @javax.persistence.Column(name = "OVSASST")
    @Basic
    public BigDecimal getOvsasst() {
        return ovsasst;
    }

    public void setOvsasst(BigDecimal ovsasst) {
        this.ovsasst = ovsasst;
    }

    private BigDecimal ovpasst;

    @javax.persistence.Column(name = "OVPASST")
    @Basic
    public BigDecimal getOvpasst() {
        return ovpasst;
    }

    public void setOvpasst(BigDecimal ovpasst) {
        this.ovpasst = ovpasst;
    }

    private BigDecimal ovsagi;

    @javax.persistence.Column(name = "OVSAGI")
    @Basic
    public BigDecimal getOvsagi() {
        return ovsagi;
    }

    public void setOvsagi(BigDecimal ovsagi) {
        this.ovsagi = ovsagi;
    }

    private BigDecimal ovpagi;

    @javax.persistence.Column(name = "OVPAGI")
    @Basic
    public BigDecimal getOvpagi() {
        return ovpagi;
    }

    public void setOvpagi(BigDecimal ovpagi) {
        this.ovpagi = ovpagi;
    }

    private BigDecimal ovsinc;

    @javax.persistence.Column(name = "OVSINC")
    @Basic
    public BigDecimal getOvsinc() {
        return ovsinc;
    }

    public void setOvsinc(BigDecimal ovsinc) {
        this.ovsinc = ovsinc;
    }

    private BigDecimal ovpinc;

    @javax.persistence.Column(name = "OVPINC")
    @Basic
    public BigDecimal getOvpinc() {
        return ovpinc;
    }

    public void setOvpinc(BigDecimal ovpinc) {
        this.ovpinc = ovpinc;
    }

    private BigDecimal ovswag;

    @javax.persistence.Column(name = "OVSWAG")
    @Basic
    public BigDecimal getOvswag() {
        return ovswag;
    }

    public void setOvswag(BigDecimal ovswag) {
        this.ovswag = ovswag;
    }

    private BigDecimal ovpwag;

    @javax.persistence.Column(name = "OVPWAG")
    @Basic
    public BigDecimal getOvpwag() {
        return ovpwag;
    }

    public void setOvpwag(BigDecimal ovpwag) {
        this.ovpwag = ovpwag;
    }

    private BigInteger ovsszhh;

    @javax.persistence.Column(name = "OVSSZHH")
    @Basic
    public BigInteger getOvsszhh() {
        return ovsszhh;
    }

    public void setOvsszhh(BigInteger ovsszhh) {
        this.ovsszhh = ovsszhh;
    }

    private BigInteger ovpszhh;

    @javax.persistence.Column(name = "OVPSZHH")
    @Basic
    public BigInteger getOvpszhh() {
        return ovpszhh;
    }

    public void setOvpszhh(BigInteger ovpszhh) {
        this.ovpszhh = ovpszhh;
    }

    private int tfwage;

    @javax.persistence.Column(name = "TFWAGE")
    @Basic
    public int getTfwage() {
        return tfwage;
    }

    public void setTfwage(int tfwage) {
        this.tfwage = tfwage;
    }

    private int tmwage;

    @javax.persistence.Column(name = "TMWAGE")
    @Basic
    public int getTmwage() {
        return tmwage;
    }

    public void setTmwage(int tmwage) {
        this.tmwage = tmwage;
    }

    private int tpmbus;

    @javax.persistence.Column(name = "TPMBUS")
    @Basic
    public int getTpmbus() {
        return tpmbus;
    }

    public void setTpmbus(int tpmbus) {
        this.tpmbus = tpmbus;
    }

    private int tpmfrm;

    @javax.persistence.Column(name = "TPMFRM")
    @Basic
    public int getTpmfrm() {
        return tpmfrm;
    }

    public void setTpmfrm(int tpmfrm) {
        this.tpmfrm = tpmfrm;
    }

    private int tspbus;

    @javax.persistence.Column(name = "TSPBUS")
    @Basic
    public int getTspbus() {
        return tspbus;
    }

    public void setTspbus(int tspbus) {
        this.tspbus = tspbus;
    }

    private int tspfrm;

    @javax.persistence.Column(name = "TSPFRM")
    @Basic
    public int getTspfrm() {
        return tspfrm;
    }

    public void setTspfrm(int tspfrm) {
        this.tspfrm = tspfrm;
    }

    private int tspwge;

    @javax.persistence.Column(name = "TSPWGE")
    @Basic
    public int getTspwge() {
        return tspwge;
    }

    public void setTspwge(int tspwge) {
        this.tspwge = tspwge;
    }

    private String smarst;

    @javax.persistence.Column(name = "SMARST")
    @Basic
    public String getSmarst() {
        return smarst;
    }

    public void setSmarst(String smarst) {
        this.smarst = smarst;
    }

    private String pmarst;

    @javax.persistence.Column(name = "PMARST")
    @Basic
    public String getPmarst() {
        return pmarst;
    }

    public void setPmarst(String pmarst) {
        this.pmarst = pmarst;
    }

    private int fscoop;

    @javax.persistence.Column(name = "FSCOOP")
    @Basic
    public int getFscoop() {
        return fscoop;
    }

    public void setFscoop(int fscoop) {
        this.fscoop = fscoop;
    }

    private int fpcoop;

    @javax.persistence.Column(name = "FPCOOP")
    @Basic
    public int getFpcoop() {
        return fpcoop;
    }

    public void setFpcoop(int fpcoop) {
        this.fpcoop = fpcoop;
    }

    private int vscoop;

    @javax.persistence.Column(name = "VSCOOP")
    @Basic
    public int getVscoop() {
        return vscoop;
    }

    public void setVscoop(int vscoop) {
        this.vscoop = vscoop;
    }

    private int vpcoop;

    @javax.persistence.Column(name = "VPCOOP")
    @Basic
    public int getVpcoop() {
        return vpcoop;
    }

    public void setVpcoop(int vpcoop) {
        this.vpcoop = vpcoop;
    }

    private int vncoop;

    @javax.persistence.Column(name = "VNCOOP")
    @Basic
    public int getVncoop() {
        return vncoop;
    }

    public void setVncoop(int vncoop) {
        this.vncoop = vncoop;
    }

    private int fsint;

    @javax.persistence.Column(name = "FSINT")
    @Basic
    public int getFsint() {
        return fsint;
    }

    public void setFsint(int fsint) {
        this.fsint = fsint;
    }

    private String iqafsf;

    @javax.persistence.Column(name = "IQAFSF")
    @Basic
    public String getIqafsf() {
        return iqafsf;
    }

    public void setIqafsf(String iqafsf) {
        this.iqafsf = iqafsf;
    }

    private String iqafsc;

    @javax.persistence.Column(name = "IQAFSC")
    @Basic
    public String getIqafsc() {
        return iqafsc;
    }

    public void setIqafsc(String iqafsc) {
        this.iqafsc = iqafsc;
    }

    private String fsathex;

    @javax.persistence.Column(name = "FSATHEX")
    @Basic
    public String getFsathex() {
        return fsathex;
    }

    public void setFsathex(String fsathex) {
        this.fsathex = fsathex;
    }

    private String fpathex;

    @javax.persistence.Column(name = "FPATHEX")
    @Basic
    public String getFpathex() {
        return fpathex;
    }

    public void setFpathex(String fpathex) {
        this.fpathex = fpathex;
    }

    private String tsfsb;

    @javax.persistence.Column(name = "TSFSB")
    @Basic
    public String getTsfsb() {
        return tsfsb;
    }

    public void setTsfsb(String tsfsb) {
        this.tsfsb = tsfsb;
    }

    private String tspfsb;

    @javax.persistence.Column(name = "TSPFSB")
    @Basic
    public String getTspfsb() {
        return tspfsb;
    }

    public void setTspfsb(String tspfsb) {
        this.tspfsb = tspfsb;
    }

    private String tffsb;

    @javax.persistence.Column(name = "TFFSB")
    @Basic
    public String getTffsb() {
        return tffsb;
    }

    public void setTffsb(String tffsb) {
        this.tffsb = tffsb;
    }

    private String tmfsb;

    @javax.persistence.Column(name = "TMFSB")
    @Basic
    public String getTmfsb() {
        return tmfsb;
    }

    public void setTmfsb(String tmfsb) {
        this.tmfsb = tmfsb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SncEntity sncEntity = (SncEntity) o;

        if (fpcoop != sncEntity.fpcoop) return false;
        if (fpedcrd != sncEntity.fpedcrd) return false;
        if (fpgtsad != sncEntity.fpgtsad) return false;
        if (fpint != sncEntity.fpint) return false;
        if (fpirads != sncEntity.fpirads) return false;
        if (fpirapy != sncEntity.fpirapy) return false;
        if (fpmcall != sncEntity.fpmcall) return false;
        if (fpnbemp != sncEntity.fpnbemp) return false;
        if (fpoutx != sncEntity.fpoutx) return false;
        if (fppenpy != sncEntity.fppenpy) return false;
        if (fputxpn != sncEntity.fputxpn) return false;
        if (fpvnebn != sncEntity.fpvnebn) return false;
        if (fscoop != sncEntity.fscoop) return false;
        if (fsdivin != sncEntity.fsdivin) return false;
        if (fsedcrd != sncEntity.fsedcrd) return false;
        if (fsint != sncEntity.fsint) return false;
        if (fsirads != sncEntity.fsirads) return false;
        if (fsirapy != sncEntity.fsirapy) return false;
        if (fsmcall != sncEntity.fsmcall) return false;
        if (fsnbemp != sncEntity.fsnbemp) return false;
        if (fsornrm != sncEntity.fsornrm) return false;
        if (fsoutx != sncEntity.fsoutx) return false;
        if (fspenpy != sncEntity.fspenpy) return false;
        if (fsutxpn != sncEntity.fsutxpn) return false;
        if (l41Lev != sncEntity.l41Lev) return false;
        if (revlev != sncEntity.revlev) return false;
        if (teagpbl != sncEntity.teagpbl) return false;
        if (tegdamt != sncEntity.tegdamt) return false;
        if (telntot != sncEntity.telntot) return false;
        if (teugdat != sncEntity.teugdat) return false;
        if (tfwage != sncEntity.tfwage) return false;
        if (tmwage != sncEntity.tmwage) return false;
        if (tnalrec != sncEntity.tnalrec) return false;
        if (tncomby != sncEntity.tncomby) return false;
        if (tncspd != sncEntity.tncspd) return false;
        if (tndprdd != sncEntity.tndprdd) return false;
        if (tnedexp != sncEntity.tnedexp) return false;
        if (tnhlths != sncEntity.tnhlths) return false;
        if (tnlnint != sncEntity.tnlnint) return false;
        if (tnmexp != sncEntity.tnmexp) return false;
        if (tnmrpd != sncEntity.tnmrpd) return false;
        if (tnmvexp != sncEntity.tnmvexp) return false;
        if (tnothgn != sncEntity.tnothgn) return false;
        if (tnpenew != sncEntity.tnpenew) return false;
        if (tnreexp != sncEntity.tnreexp) return false;
        if (tnsemph != sncEntity.tnsemph) return false;
        if (tnsempt != sncEntity.tnsempt) return false;
        if (tnttxi != sncEntity.tnttxi) return false;
        if (tntupd != sncEntity.tntupd) return false;
        if (tpalrec != sncEntity.tpalrec) return false;
        if (tpcomby != sncEntity.tpcomby) return false;
        if (tpcspd != sncEntity.tpcspd) return false;
        if (tpdprdd != sncEntity.tpdprdd) return false;
        if (tpedexp != sncEntity.tpedexp) return false;
        if (tphlths != sncEntity.tphlths) return false;
        if (tplnint != sncEntity.tplnint) return false;
        if (tpmbus != sncEntity.tpmbus) return false;
        if (tpmfrm != sncEntity.tpmfrm) return false;
        if (tpmrpd != sncEntity.tpmrpd) return false;
        if (tpmvexp != sncEntity.tpmvexp) return false;
        if (tpothgn != sncEntity.tpothgn) return false;
        if (tppenew != sncEntity.tppenew) return false;
        if (tpreexp != sncEntity.tpreexp) return false;
        if (tpsemph != sncEntity.tpsemph) return false;
        if (tpsempt != sncEntity.tpsempt) return false;
        if (tpttxi != sncEntity.tpttxi) return false;
        if (tptufd != sncEntity.tptufd) return false;
        if (tsalrec != sncEntity.tsalrec) return false;
        if (tscomby != sncEntity.tscomby) return false;
        if (tscspd != sncEntity.tscspd) return false;
        if (tsdprdd != sncEntity.tsdprdd) return false;
        if (tsedexp != sncEntity.tsedexp) return false;
        if (tshlths != sncEntity.tshlths) return false;
        if (tslnint != sncEntity.tslnint) return false;
        if (tsmrpd != sncEntity.tsmrpd) return false;
        if (tsmvexp != sncEntity.tsmvexp) return false;
        if (tsothgn != sncEntity.tsothgn) return false;
        if (tspbus != sncEntity.tspbus) return false;
        if (tspenew != sncEntity.tspenew) return false;
        if (tspfrm != sncEntity.tspfrm) return false;
        if (tspwge != sncEntity.tspwge) return false;
        if (tsreexp != sncEntity.tsreexp) return false;
        if (tssemph != sncEntity.tssemph) return false;
        if (tssempt != sncEntity.tssempt) return false;
        if (tsttxi != sncEntity.tsttxi) return false;
        if (tstufd != sncEntity.tstufd) return false;
        if (vncoop != sncEntity.vncoop) return false;
        if (vpcoop != sncEntity.vpcoop) return false;
        if (vscoop != sncEntity.vscoop) return false;
        if (aidyr != null ? !aidyr.equals(sncEntity.aidyr) : sncEntity.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(sncEntity.cmptype) : sncEntity.cmptype != null) return false;
        if (crtdate != null ? !crtdate.equals(sncEntity.crtdate) : sncEntity.crtdate != null) return false;
        if (crttime != null ? !crttime.equals(sncEntity.crttime) : sncEntity.crttime != null) return false;
        if (faowner != null ? !faowner.equals(sncEntity.faowner) : sncEntity.faowner != null) return false;
        if (femancd != null ? !femancd.equals(sncEntity.femancd) : sncEntity.femancd != null) return false;
        if (fhlght3 != null ? !fhlght3.equals(sncEntity.fhlght3) : sncEntity.fhlght3 != null) return false;
        if (flggusp != null ? !flggusp.equals(sncEntity.flggusp) : sncEntity.flggusp != null) return false;
        if (fpathex != null ? !fpathex.equals(sncEntity.fpathex) : sncEntity.fpathex != null) return false;
        if (fsathex != null ? !fsathex.equals(sncEntity.fsathex) : sncEntity.fsathex != null) return false;
        if (fsvarec != null ? !fsvarec.equals(sncEntity.fsvarec) : sncEntity.fsvarec != null) return false;
        if (fsvatyp != null ? !fsvatyp.equals(sncEntity.fsvatyp) : sncEntity.fsvatyp != null) return false;
        if (ftrcswk != null ? !ftrcswk.equals(sncEntity.ftrcswk) : sncEntity.ftrcswk != null) return false;
        if (fuacchd != null ? !fuacchd.equals(sncEntity.fuacchd) : sncEntity.fuacchd != null) return false;
        if (fuaccsh != null ? !fuaccsh.equals(sncEntity.fuaccsh) : sncEntity.fuaccsh != null) return false;
        if (initals != null ? !initals.equals(sncEntity.initals) : sncEntity.initals != null) return false;
        if (instid != null ? !instid.equals(sncEntity.instid) : sncEntity.instid != null) return false;
        if (iqafsc != null ? !iqafsc.equals(sncEntity.iqafsc) : sncEntity.iqafsc != null) return false;
        if (iqafsf != null ? !iqafsf.equals(sncEntity.iqafsf) : sncEntity.iqafsf != null) return false;
        if (module != null ? !module.equals(sncEntity.module) : sncEntity.module != null) return false;
        if (numpar != null ? !numpar.equals(sncEntity.numpar) : sncEntity.numpar != null) return false;
        if (ovpagi != null ? !ovpagi.equals(sncEntity.ovpagi) : sncEntity.ovpagi != null) return false;
        if (ovpasst != null ? !ovpasst.equals(sncEntity.ovpasst) : sncEntity.ovpasst != null) return false;
        if (ovpc != null ? !ovpc.equals(sncEntity.ovpc) : sncEntity.ovpc != null) return false;
        if (ovpexcl != null ? !ovpexcl.equals(sncEntity.ovpexcl) : sncEntity.ovpexcl != null) return false;
        if (ovpflst != null ? !ovpflst.equals(sncEntity.ovpflst) : sncEntity.ovpflst != null) return false;
        if (ovpgtrn != null ? !ovpgtrn.equals(sncEntity.ovpgtrn) : sncEntity.ovpgtrn != null) return false;
        if (ovpinc != null ? !ovpinc.equals(sncEntity.ovpinc) : sncEntity.ovpinc != null) return false;
        if (ovpmrtl != null ? !ovpmrtl.equals(sncEntity.ovpmrtl) : sncEntity.ovpmrtl != null) return false;
        if (ovpszhh != null ? !ovpszhh.equals(sncEntity.ovpszhh) : sncEntity.ovpszhh != null) return false;
        if (ovptxpd != null ? !ovptxpd.equals(sncEntity.ovptxpd) : sncEntity.ovptxpd != null) return false;
        if (ovptxrt != null ? !ovptxrt.equals(sncEntity.ovptxrt) : sncEntity.ovptxrt != null) return false;
        if (ovpwag != null ? !ovpwag.equals(sncEntity.ovpwag) : sncEntity.ovpwag != null) return false;
        if (ovsagi != null ? !ovsagi.equals(sncEntity.ovsagi) : sncEntity.ovsagi != null) return false;
        if (ovsasst != null ? !ovsasst.equals(sncEntity.ovsasst) : sncEntity.ovsasst != null) return false;
        if (ovsc != null ? !ovsc.equals(sncEntity.ovsc) : sncEntity.ovsc != null) return false;
        if (ovsexcl != null ? !ovsexcl.equals(sncEntity.ovsexcl) : sncEntity.ovsexcl != null) return false;
        if (ovsflst != null ? !ovsflst.equals(sncEntity.ovsflst) : sncEntity.ovsflst != null) return false;
        if (ovsinc != null ? !ovsinc.equals(sncEntity.ovsinc) : sncEntity.ovsinc != null) return false;
        if (ovsmrtl != null ? !ovsmrtl.equals(sncEntity.ovsmrtl) : sncEntity.ovsmrtl != null) return false;
        if (ovsszhh != null ? !ovsszhh.equals(sncEntity.ovsszhh) : sncEntity.ovsszhh != null) return false;
        if (ovstxpd != null ? !ovstxpd.equals(sncEntity.ovstxpd) : sncEntity.ovstxpd != null) return false;
        if (ovstxrt != null ? !ovstxrt.equals(sncEntity.ovstxrt) : sncEntity.ovstxrt != null) return false;
        if (ovswag != null ? !ovswag.equals(sncEntity.ovswag) : sncEntity.ovswag != null) return false;
        if (pblind != null ? !pblind.equals(sncEntity.pblind) : sncEntity.pblind != null) return false;
        if (pcostl != null ? !pcostl.equals(sncEntity.pcostl) : sncEntity.pcostl != null) return false;
        if (pdeduct != null ? !pdeduct.equals(sncEntity.pdeduct) : sncEntity.pdeduct != null) return false;
        if (pdep179 != null ? !pdep179.equals(sncEntity.pdep179) : sncEntity.pdep179 != null) return false;
        if (pdeplet != null ? !pdeplet.equals(sncEntity.pdeplet) : sncEntity.pdeplet != null) return false;
        if (pdeprec != null ? !pdeprec.equals(sncEntity.pdeprec) : sncEntity.pdeprec != null) return false;
        if (pdprdpl != null ? !pdprdpl.equals(sncEntity.pdprdpl) : sncEntity.pdprdpl != null) return false;
        if (peduexp != null ? !peduexp.equals(sncEntity.peduexp) : sncEntity.peduexp != null) return false;
        if (phombus != null ? !phombus.equals(sncEntity.phombus) : sncEntity.phombus != null) return false;
        if (pmarst != null ? !pmarst.equals(sncEntity.pmarst) : sncEntity.pmarst != null) return false;
        if (pogladj != null ? !pogladj.equals(sncEntity.pogladj) : sncEntity.pogladj != null) return false;
        if (pslded != null ? !pslded.equals(sncEntity.pslded) : sncEntity.pslded != null) return false;
        if (ptlts != null ? !ptlts.equals(sncEntity.ptlts) : sncEntity.ptlts != null) return false;
        if (ptotint != null ? !ptotint.equals(sncEntity.ptotint) : sncEntity.ptotint != null) return false;
        if (ptottax != null ? !ptottax.equals(sncEntity.ptottax) : sncEntity.ptottax != null) return false;
        if (ptrust != null ? !ptrust.equals(sncEntity.ptrust) : sncEntity.ptrust != null) return false;
        if (ptufeed != null ? !ptufeed.equals(sncEntity.ptufeed) : sncEntity.ptufeed != null) return false;
        if (puata != null ? !puata.equals(sncEntity.puata) : sncEntity.puata != null) return false;
        if (puati != null ? !puati.equals(sncEntity.puati) : sncEntity.puati != null) return false;
        if (pvbfnet != null ? !pvbfnet.equals(sncEntity.pvbfnet) : sncEntity.pvbfnet != null) return false;
        if (pvcash != null ? !pvcash.equals(sncEntity.pvcash) : sncEntity.pvcash != null) return false;
        if (pvedsv != null ? !pvedsv.equals(sncEntity.pvedsv) : sncEntity.pvedsv != null) return false;
        if (pvinv != null ? !pvinv.equals(sncEntity.pvinv) : sncEntity.pvinv != null) return false;
        if (pvmort != null ? !pvmort.equals(sncEntity.pvmort) : sncEntity.pvmort != null) return false;
        if (pvrest != null ? !pvrest.equals(sncEntity.pvrest) : sncEntity.pvrest != null) return false;
        if (recstat != null ? !recstat.equals(sncEntity.recstat) : sncEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(sncEntity.revdate) : sncEntity.revdate != null) return false;
        if (revtime != null ? !revtime.equals(sncEntity.revtime) : sncEntity.revtime != null) return false;
        if (sblind != null ? !sblind.equals(sncEntity.sblind) : sncEntity.sblind != null) return false;
        if (schcedf != null ? !schcedf.equals(sncEntity.schcedf) : sncEntity.schcedf != null) return false;
        if (scostl != null ? !scostl.equals(sncEntity.scostl) : sncEntity.scostl != null) return false;
        if (sdeduct != null ? !sdeduct.equals(sncEntity.sdeduct) : sncEntity.sdeduct != null) return false;
        if (sdep179 != null ? !sdep179.equals(sncEntity.sdep179) : sncEntity.sdep179 != null) return false;
        if (sdeplet != null ? !sdeplet.equals(sncEntity.sdeplet) : sncEntity.sdeplet != null) return false;
        if (sdeprec != null ? !sdeprec.equals(sncEntity.sdeprec) : sncEntity.sdeprec != null) return false;
        if (sdprdpl != null ? !sdprdpl.equals(sncEntity.sdprdpl) : sncEntity.sdprdpl != null) return false;
        if (seduexp != null ? !seduexp.equals(sncEntity.seduexp) : sncEntity.seduexp != null) return false;
        if (shombus != null ? !shombus.equals(sncEntity.shombus) : sncEntity.shombus != null) return false;
        if (sid != null ? !sid.equals(sncEntity.sid) : sncEntity.sid != null) return false;
        if (smarst != null ? !smarst.equals(sncEntity.smarst) : sncEntity.smarst != null) return false;
        if (snckey != null ? !snckey.equals(sncEntity.snckey) : sncEntity.snckey != null) return false;
        if (sogladj != null ? !sogladj.equals(sncEntity.sogladj) : sncEntity.sogladj != null) return false;
        if (sslded != null ? !sslded.equals(sncEntity.sslded) : sncEntity.sslded != null) return false;
        if (stlts != null ? !stlts.equals(sncEntity.stlts) : sncEntity.stlts != null) return false;
        if (stotint != null ? !stotint.equals(sncEntity.stotint) : sncEntity.stotint != null) return false;
        if (stottax != null ? !stottax.equals(sncEntity.stottax) : sncEntity.stottax != null) return false;
        if (strust != null ? !strust.equals(sncEntity.strust) : sncEntity.strust != null) return false;
        if (stufeed != null ? !stufeed.equals(sncEntity.stufeed) : sncEntity.stufeed != null) return false;
        if (suata != null ? !suata.equals(sncEntity.suata) : sncEntity.suata != null) return false;
        if (suati != null ? !suati.equals(sncEntity.suati) : sncEntity.suati != null) return false;
        if (svbfnet != null ? !svbfnet.equals(sncEntity.svbfnet) : sncEntity.svbfnet != null) return false;
        if (svcash != null ? !svcash.equals(sncEntity.svcash) : sncEntity.svcash != null) return false;
        if (svedsv != null ? !svedsv.equals(sncEntity.svedsv) : sncEntity.svedsv != null) return false;
        if (svinv != null ? !svinv.equals(sncEntity.svinv) : sncEntity.svinv != null) return false;
        if (svmort != null ? !svmort.equals(sncEntity.svmort) : sncEntity.svmort != null) return false;
        if (svrest != null ? !svrest.equals(sncEntity.svrest) : sncEntity.svrest != null) return false;
        if (tcnflg != null ? !tcnflg.equals(sncEntity.tcnflg) : sncEntity.tcnflg != null) return false;
        if (teaddfg != null ? !teaddfg.equals(sncEntity.teaddfg) : sncEntity.teaddfg != null) return false;
        if (tecchfg != null ? !tecchfg.equals(sncEntity.tecchfg) : sncEntity.tecchfg != null) return false;
        if (techgfg != null ? !techgfg.equals(sncEntity.techgfg) : sncEntity.techgfg != null) return false;
        if (telncnf != null ? !telncnf.equals(sncEntity.telncnf) : sncEntity.telncnf != null) return false;
        if (teovcnt != null ? !teovcnt.equals(sncEntity.teovcnt) : sncEntity.teovcnt != null) return false;
        if (teovflg != null ? !teovflg.equals(sncEntity.teovflg) : sncEntity.teovflg != null) return false;
        if (tffsb != null ? !tffsb.equals(sncEntity.tffsb) : sncEntity.tffsb != null) return false;
        if (tmfsb != null ? !tmfsb.equals(sncEntity.tmfsb) : sncEntity.tmfsb != null) return false;
        if (tndislw != null ? !tndislw.equals(sncEntity.tndislw) : sncEntity.tndislw != null) return false;
        if (tndobc != null ? !tndobc.equals(sncEntity.tndobc) : sncEntity.tndobc != null) return false;
        if (tnelgez != null ? !tnelgez.equals(sncEntity.tnelgez) : sncEntity.tnelgez != null) return false;
        if (tninex != null ? !tninex.equals(sncEntity.tninex) : sncEntity.tninex != null) return false;
        if (tnmrtdc != null ? !tnmrtdc.equals(sncEntity.tnmrtdc) : sncEntity.tnmrtdc != null) return false;
        if (tnmrtls != null ? !tnmrtls.equals(sncEntity.tnmrtls) : sncEntity.tnmrtls != null) return false;
        if (tnnamef != null ? !tnnamef.equals(sncEntity.tnnamef) : sncEntity.tnnamef != null) return false;
        if (tnnamel != null ? !tnnamel.equals(sncEntity.tnnamel) : sncEntity.tnnamel != null) return false;
        if (tnsided != null ? !tnsided.equals(sncEntity.tnsided) : sncEntity.tnsided != null) return false;
        if (tnssn != null ? !tnssn.equals(sncEntity.tnssn) : sncEntity.tnssn != null) return false;
        if (tpdislw != null ? !tpdislw.equals(sncEntity.tpdislw) : sncEntity.tpdislw != null) return false;
        if (tpelgez != null ? !tpelgez.equals(sncEntity.tpelgez) : sncEntity.tpelgez != null) return false;
        if (tpfdobc != null ? !tpfdobc.equals(sncEntity.tpfdobc) : sncEntity.tpfdobc != null) return false;
        if (tpfnamf != null ? !tpfnamf.equals(sncEntity.tpfnamf) : sncEntity.tpfnamf != null) return false;
        if (tpfnaml != null ? !tpfnaml.equals(sncEntity.tpfnaml) : sncEntity.tpfnaml != null) return false;
        if (tpfssn != null ? !tpfssn.equals(sncEntity.tpfssn) : sncEntity.tpfssn != null) return false;
        if (tpinex != null ? !tpinex.equals(sncEntity.tpinex) : sncEntity.tpinex != null) return false;
        if (tpmdobc != null ? !tpmdobc.equals(sncEntity.tpmdobc) : sncEntity.tpmdobc != null) return false;
        if (tpmnamf != null ? !tpmnamf.equals(sncEntity.tpmnamf) : sncEntity.tpmnamf != null) return false;
        if (tpmrtdc != null ? !tpmrtdc.equals(sncEntity.tpmrtdc) : sncEntity.tpmrtdc != null) return false;
        if (tpmrtls != null ? !tpmrtls.equals(sncEntity.tpmrtls) : sncEntity.tpmrtls != null) return false;
        if (tpmssn != null ? !tpmssn.equals(sncEntity.tpmssn) : sncEntity.tpmssn != null) return false;
        if (tpsided != null ? !tpsided.equals(sncEntity.tpsided) : sncEntity.tpsided != null) return false;
        if (tsdislw != null ? !tsdislw.equals(sncEntity.tsdislw) : sncEntity.tsdislw != null) return false;
        if (tsdobc != null ? !tsdobc.equals(sncEntity.tsdobc) : sncEntity.tsdobc != null) return false;
        if (tselgez != null ? !tselgez.equals(sncEntity.tselgez) : sncEntity.tselgez != null) return false;
        if (tsfsb != null ? !tsfsb.equals(sncEntity.tsfsb) : sncEntity.tsfsb != null) return false;
        if (tsinex != null ? !tsinex.equals(sncEntity.tsinex) : sncEntity.tsinex != null) return false;
        if (tsmrtdc != null ? !tsmrtdc.equals(sncEntity.tsmrtdc) : sncEntity.tsmrtdc != null) return false;
        if (tsmrtls != null ? !tsmrtls.equals(sncEntity.tsmrtls) : sncEntity.tsmrtls != null) return false;
        if (tsnamef != null ? !tsnamef.equals(sncEntity.tsnamef) : sncEntity.tsnamef != null) return false;
        if (tsnamel != null ? !tsnamel.equals(sncEntity.tsnamel) : sncEntity.tsnamel != null) return false;
        if (tspfsb != null ? !tspfsb.equals(sncEntity.tspfsb) : sncEntity.tspfsb != null) return false;
        if (tssided != null ? !tssided.equals(sncEntity.tssided) : sncEntity.tssided != null) return false;
        if (tsssn != null ? !tsssn.equals(sncEntity.tsssn) : sncEntity.tsssn != null) return false;
        if (ucode != null ? !ucode.equals(sncEntity.ucode) : sncEntity.ucode != null) return false;
        if (uia != null ? !uia.equals(sncEntity.uia) : sncEntity.uia != null) return false;
        if (vercd1 != null ? !vercd1.equals(sncEntity.vercd1) : sncEntity.vercd1 != null) return false;
        if (vercd10 != null ? !vercd10.equals(sncEntity.vercd10) : sncEntity.vercd10 != null) return false;
        if (vercd2 != null ? !vercd2.equals(sncEntity.vercd2) : sncEntity.vercd2 != null) return false;
        if (vercd3 != null ? !vercd3.equals(sncEntity.vercd3) : sncEntity.vercd3 != null) return false;
        if (vercd4 != null ? !vercd4.equals(sncEntity.vercd4) : sncEntity.vercd4 != null) return false;
        if (vercd5 != null ? !vercd5.equals(sncEntity.vercd5) : sncEntity.vercd5 != null) return false;
        if (vercd6 != null ? !vercd6.equals(sncEntity.vercd6) : sncEntity.vercd6 != null) return false;
        if (vercd7 != null ? !vercd7.equals(sncEntity.vercd7) : sncEntity.vercd7 != null) return false;
        if (vercd8 != null ? !vercd8.equals(sncEntity.vercd8) : sncEntity.vercd8 != null) return false;
        if (vercd9 != null ? !vercd9.equals(sncEntity.vercd9) : sncEntity.vercd9 != null) return false;
        if (verdte != null ? !verdte.equals(sncEntity.verdte) : sncEntity.verdte != null) return false;
        if (versnr != null ? !versnr.equals(sncEntity.versnr) : sncEntity.versnr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snckey != null ? snckey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cmptype != null ? cmptype.hashCode() : 0);
        result = 31 * result + (versnr != null ? versnr.hashCode() : 0);
        result = 31 * result + l41Lev;
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (ftrcswk != null ? ftrcswk.hashCode() : 0);
        result = 31 * result + fsedcrd;
        result = 31 * result + fsnbemp;
        result = 31 * result + fspenpy;
        result = 31 * result + fsirapy;
        result = 31 * result + fsdivin;
        result = 31 * result + fsirads;
        result = 31 * result + fsutxpn;
        result = 31 * result + fsmcall;
        result = 31 * result + fsornrm;
        result = 31 * result + (femancd != null ? femancd.hashCode() : 0);
        result = 31 * result + (flggusp != null ? flggusp.hashCode() : 0);
        result = 31 * result + (fuaccsh != null ? fuaccsh.hashCode() : 0);
        result = 31 * result + (fuacchd != null ? fuacchd.hashCode() : 0);
        result = 31 * result + fpedcrd;
        result = 31 * result + fpnbemp;
        result = 31 * result + fpgtsad;
        result = 31 * result + fppenpy;
        result = 31 * result + fpirapy;
        result = 31 * result + fpirads;
        result = 31 * result + fputxpn;
        result = 31 * result + fpmcall;
        result = 31 * result + fpvnebn;
        result = 31 * result + (fhlght3 != null ? fhlght3.hashCode() : 0);
        result = 31 * result + (teovflg != null ? teovflg.hashCode() : 0);
        result = 31 * result + (teovcnt != null ? teovcnt.hashCode() : 0);
        result = 31 * result + (telncnf != null ? telncnf.hashCode() : 0);
        result = 31 * result + teagpbl;
        result = 31 * result + telntot;
        result = 31 * result + teugdat;
        result = 31 * result + tegdamt;
        result = 31 * result + (tecchfg != null ? tecchfg.hashCode() : 0);
        result = 31 * result + (techgfg != null ? techgfg.hashCode() : 0);
        result = 31 * result + (teaddfg != null ? teaddfg.hashCode() : 0);
        result = 31 * result + (tcnflg != null ? tcnflg.hashCode() : 0);
        result = 31 * result + (fsvarec != null ? fsvarec.hashCode() : 0);
        result = 31 * result + (fsvatyp != null ? fsvatyp.hashCode() : 0);
        result = 31 * result + tscspd;
        result = 31 * result + tpcspd;
        result = 31 * result + tncspd;
        result = 31 * result + (tsinex != null ? tsinex.hashCode() : 0);
        result = 31 * result + (tpinex != null ? tpinex.hashCode() : 0);
        result = 31 * result + (tninex != null ? tninex.hashCode() : 0);
        result = 31 * result + (tsssn != null ? tsssn.hashCode() : 0);
        result = 31 * result + (tpfssn != null ? tpfssn.hashCode() : 0);
        result = 31 * result + (tpmssn != null ? tpmssn.hashCode() : 0);
        result = 31 * result + (tnssn != null ? tnssn.hashCode() : 0);
        result = 31 * result + (tsdobc != null ? tsdobc.hashCode() : 0);
        result = 31 * result + (tpfdobc != null ? tpfdobc.hashCode() : 0);
        result = 31 * result + (tpmdobc != null ? tpmdobc.hashCode() : 0);
        result = 31 * result + (tndobc != null ? tndobc.hashCode() : 0);
        result = 31 * result + (tsnamel != null ? tsnamel.hashCode() : 0);
        result = 31 * result + (tpfnaml != null ? tpfnaml.hashCode() : 0);
        result = 31 * result + (tnnamel != null ? tnnamel.hashCode() : 0);
        result = 31 * result + (tsnamef != null ? tsnamef.hashCode() : 0);
        result = 31 * result + (tpfnamf != null ? tpfnamf.hashCode() : 0);
        result = 31 * result + (tpmnamf != null ? tpmnamf.hashCode() : 0);
        result = 31 * result + (tnnamef != null ? tnnamef.hashCode() : 0);
        result = 31 * result + (tselgez != null ? tselgez.hashCode() : 0);
        result = 31 * result + (tpelgez != null ? tpelgez.hashCode() : 0);
        result = 31 * result + (tnelgez != null ? tnelgez.hashCode() : 0);
        result = 31 * result + (tsmrtls != null ? tsmrtls.hashCode() : 0);
        result = 31 * result + (tpmrtls != null ? tpmrtls.hashCode() : 0);
        result = 31 * result + (tnmrtls != null ? tnmrtls.hashCode() : 0);
        result = 31 * result + (tsmrtdc != null ? tsmrtdc.hashCode() : 0);
        result = 31 * result + (tpmrtdc != null ? tpmrtdc.hashCode() : 0);
        result = 31 * result + (tnmrtdc != null ? tnmrtdc.hashCode() : 0);
        result = 31 * result + tscomby;
        result = 31 * result + tpcomby;
        result = 31 * result + tncomby;
        result = 31 * result + (tsdislw != null ? tsdislw.hashCode() : 0);
        result = 31 * result + (tpdislw != null ? tpdislw.hashCode() : 0);
        result = 31 * result + (tndislw != null ? tndislw.hashCode() : 0);
        result = 31 * result + tsmrpd;
        result = 31 * result + tpmrpd;
        result = 31 * result + tnmrpd;
        result = 31 * result + tsttxi;
        result = 31 * result + tpttxi;
        result = 31 * result + tnttxi;
        result = 31 * result + (tssided != null ? tssided.hashCode() : 0);
        result = 31 * result + (tpsided != null ? tpsided.hashCode() : 0);
        result = 31 * result + (tnsided != null ? tnsided.hashCode() : 0);
        result = 31 * result + tsalrec;
        result = 31 * result + tpalrec;
        result = 31 * result + tnalrec;
        result = 31 * result + tsothgn;
        result = 31 * result + tpothgn;
        result = 31 * result + tnothgn;
        result = 31 * result + tsedexp;
        result = 31 * result + tpedexp;
        result = 31 * result + tnedexp;
        result = 31 * result + tsreexp;
        result = 31 * result + tpreexp;
        result = 31 * result + tnreexp;
        result = 31 * result + tshlths;
        result = 31 * result + tphlths;
        result = 31 * result + tnhlths;
        result = 31 * result + tsmvexp;
        result = 31 * result + tpmvexp;
        result = 31 * result + tnmvexp;
        result = 31 * result + tssempt;
        result = 31 * result + tpsempt;
        result = 31 * result + tnsempt;
        result = 31 * result + tssemph;
        result = 31 * result + tpsemph;
        result = 31 * result + tnsemph;
        result = 31 * result + tspenew;
        result = 31 * result + tppenew;
        result = 31 * result + tnpenew;
        result = 31 * result + tslnint;
        result = 31 * result + tplnint;
        result = 31 * result + tnlnint;
        result = 31 * result + tstufd;
        result = 31 * result + tptufd;
        result = 31 * result + tntupd;
        result = 31 * result + tsdprdd;
        result = 31 * result + tpdprdd;
        result = 31 * result + tndprdd;
        result = 31 * result + fpint;
        result = 31 * result + fsoutx;
        result = 31 * result + fpoutx;
        result = 31 * result + tnmexp;
        result = 31 * result + (vercd1 != null ? vercd1.hashCode() : 0);
        result = 31 * result + (vercd2 != null ? vercd2.hashCode() : 0);
        result = 31 * result + (vercd3 != null ? vercd3.hashCode() : 0);
        result = 31 * result + (vercd4 != null ? vercd4.hashCode() : 0);
        result = 31 * result + (vercd5 != null ? vercd5.hashCode() : 0);
        result = 31 * result + (vercd6 != null ? vercd6.hashCode() : 0);
        result = 31 * result + (vercd7 != null ? vercd7.hashCode() : 0);
        result = 31 * result + (vercd8 != null ? vercd8.hashCode() : 0);
        result = 31 * result + (vercd9 != null ? vercd9.hashCode() : 0);
        result = 31 * result + (vercd10 != null ? vercd10.hashCode() : 0);
        result = 31 * result + (verdte != null ? verdte.hashCode() : 0);
        result = 31 * result + (faowner != null ? faowner.hashCode() : 0);
        result = 31 * result + (schcedf != null ? schcedf.hashCode() : 0);
        result = 31 * result + (sblind != null ? sblind.hashCode() : 0);
        result = 31 * result + (pblind != null ? pblind.hashCode() : 0);
        result = 31 * result + (strust != null ? strust.hashCode() : 0);
        result = 31 * result + (ptrust != null ? ptrust.hashCode() : 0);
        result = 31 * result + (ovsmrtl != null ? ovsmrtl.hashCode() : 0);
        result = 31 * result + (ovpmrtl != null ? ovpmrtl.hashCode() : 0);
        result = 31 * result + (ovsflst != null ? ovsflst.hashCode() : 0);
        result = 31 * result + (ovpflst != null ? ovpflst.hashCode() : 0);
        result = 31 * result + (ovstxrt != null ? ovstxrt.hashCode() : 0);
        result = 31 * result + (ovptxrt != null ? ovptxrt.hashCode() : 0);
        result = 31 * result + (numpar != null ? numpar.hashCode() : 0);
        result = 31 * result + (uia != null ? uia.hashCode() : 0);
        result = 31 * result + (suati != null ? suati.hashCode() : 0);
        result = 31 * result + (puati != null ? puati.hashCode() : 0);
        result = 31 * result + (suata != null ? suata.hashCode() : 0);
        result = 31 * result + (puata != null ? puata.hashCode() : 0);
        result = 31 * result + (sogladj != null ? sogladj.hashCode() : 0);
        result = 31 * result + (pogladj != null ? pogladj.hashCode() : 0);
        result = 31 * result + (seduexp != null ? seduexp.hashCode() : 0);
        result = 31 * result + (peduexp != null ? peduexp.hashCode() : 0);
        result = 31 * result + (sslded != null ? sslded.hashCode() : 0);
        result = 31 * result + (pslded != null ? pslded.hashCode() : 0);
        result = 31 * result + (stufeed != null ? stufeed.hashCode() : 0);
        result = 31 * result + (ptufeed != null ? ptufeed.hashCode() : 0);
        result = 31 * result + (sdeduct != null ? sdeduct.hashCode() : 0);
        result = 31 * result + (pdeduct != null ? pdeduct.hashCode() : 0);
        result = 31 * result + (svcash != null ? svcash.hashCode() : 0);
        result = 31 * result + (pvcash != null ? pvcash.hashCode() : 0);
        result = 31 * result + (svinv != null ? svinv.hashCode() : 0);
        result = 31 * result + (pvinv != null ? pvinv.hashCode() : 0);
        result = 31 * result + (svrest != null ? svrest.hashCode() : 0);
        result = 31 * result + (pvrest != null ? pvrest.hashCode() : 0);
        result = 31 * result + (svmort != null ? svmort.hashCode() : 0);
        result = 31 * result + (pvmort != null ? pvmort.hashCode() : 0);
        result = 31 * result + (svbfnet != null ? svbfnet.hashCode() : 0);
        result = 31 * result + (pvbfnet != null ? pvbfnet.hashCode() : 0);
        result = 31 * result + (svedsv != null ? svedsv.hashCode() : 0);
        result = 31 * result + (pvedsv != null ? pvedsv.hashCode() : 0);
        result = 31 * result + (stottax != null ? stottax.hashCode() : 0);
        result = 31 * result + (ptottax != null ? ptottax.hashCode() : 0);
        result = 31 * result + (stotint != null ? stotint.hashCode() : 0);
        result = 31 * result + (ptotint != null ? ptotint.hashCode() : 0);
        result = 31 * result + (sdeplet != null ? sdeplet.hashCode() : 0);
        result = 31 * result + (pdeplet != null ? pdeplet.hashCode() : 0);
        result = 31 * result + (sdeprec != null ? sdeprec.hashCode() : 0);
        result = 31 * result + (pdeprec != null ? pdeprec.hashCode() : 0);
        result = 31 * result + (shombus != null ? shombus.hashCode() : 0);
        result = 31 * result + (phombus != null ? phombus.hashCode() : 0);
        result = 31 * result + (scostl != null ? scostl.hashCode() : 0);
        result = 31 * result + (pcostl != null ? pcostl.hashCode() : 0);
        result = 31 * result + (stlts != null ? stlts.hashCode() : 0);
        result = 31 * result + (ptlts != null ? ptlts.hashCode() : 0);
        result = 31 * result + (sdprdpl != null ? sdprdpl.hashCode() : 0);
        result = 31 * result + (pdprdpl != null ? pdprdpl.hashCode() : 0);
        result = 31 * result + (sdep179 != null ? sdep179.hashCode() : 0);
        result = 31 * result + (pdep179 != null ? pdep179.hashCode() : 0);
        result = 31 * result + (ovpgtrn != null ? ovpgtrn.hashCode() : 0);
        result = 31 * result + (ovstxpd != null ? ovstxpd.hashCode() : 0);
        result = 31 * result + (ovptxpd != null ? ovptxpd.hashCode() : 0);
        result = 31 * result + (ovsc != null ? ovsc.hashCode() : 0);
        result = 31 * result + (ovpc != null ? ovpc.hashCode() : 0);
        result = 31 * result + (ovsexcl != null ? ovsexcl.hashCode() : 0);
        result = 31 * result + (ovpexcl != null ? ovpexcl.hashCode() : 0);
        result = 31 * result + (ovsasst != null ? ovsasst.hashCode() : 0);
        result = 31 * result + (ovpasst != null ? ovpasst.hashCode() : 0);
        result = 31 * result + (ovsagi != null ? ovsagi.hashCode() : 0);
        result = 31 * result + (ovpagi != null ? ovpagi.hashCode() : 0);
        result = 31 * result + (ovsinc != null ? ovsinc.hashCode() : 0);
        result = 31 * result + (ovpinc != null ? ovpinc.hashCode() : 0);
        result = 31 * result + (ovswag != null ? ovswag.hashCode() : 0);
        result = 31 * result + (ovpwag != null ? ovpwag.hashCode() : 0);
        result = 31 * result + (ovsszhh != null ? ovsszhh.hashCode() : 0);
        result = 31 * result + (ovpszhh != null ? ovpszhh.hashCode() : 0);
        result = 31 * result + tfwage;
        result = 31 * result + tmwage;
        result = 31 * result + tpmbus;
        result = 31 * result + tpmfrm;
        result = 31 * result + tspbus;
        result = 31 * result + tspfrm;
        result = 31 * result + tspwge;
        result = 31 * result + (smarst != null ? smarst.hashCode() : 0);
        result = 31 * result + (pmarst != null ? pmarst.hashCode() : 0);
        result = 31 * result + fscoop;
        result = 31 * result + fpcoop;
        result = 31 * result + vscoop;
        result = 31 * result + vpcoop;
        result = 31 * result + vncoop;
        result = 31 * result + fsint;
        result = 31 * result + (iqafsf != null ? iqafsf.hashCode() : 0);
        result = 31 * result + (iqafsc != null ? iqafsc.hashCode() : 0);
        result = 31 * result + (fsathex != null ? fsathex.hashCode() : 0);
        result = 31 * result + (fpathex != null ? fpathex.hashCode() : 0);
        result = 31 * result + (tsfsb != null ? tsfsb.hashCode() : 0);
        result = 31 * result + (tspfsb != null ? tspfsb.hashCode() : 0);
        result = 31 * result + (tffsb != null ? tffsb.hashCode() : 0);
        result = 31 * result + (tmfsb != null ? tmfsb.hashCode() : 0);
        return result;
    }
}
