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
 * Time: 12:04 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNF2", schema = "SIGMA", catalog = "")
@Entity
public class Snf2Entity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnfkey();
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

    private String snfkey;

    @javax.persistence.Column(name = "SNFKEY")
    @Id
    public String getSnfkey() {
        return snfkey;
    }

    public void setSnfkey(String snfkey) {
        this.snfkey = snfkey;
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

    private BigInteger fpincol;

    @javax.persistence.Column(name = "FPINCOL")
    @Basic
    public BigInteger getFpincol() {
        return fpincol;
    }

    public void setFpincol(BigInteger fpincol) {
        this.fpincol = fpincol;
    }

    private String fpmartl;

    @javax.persistence.Column(name = "FPMARTL")
    @Basic
    public String getFpmartl() {
        return fpmartl;
    }

    public void setFpmartl(String fpmartl) {
        this.fpmartl = fpmartl;
    }

    private String fpres;

    @javax.persistence.Column(name = "FPRES")
    @Basic
    public String getFpres() {
        return fpres;
    }

    public void setFpres(String fpres) {
        this.fpres = fpres;
    }

    private String fpfedlvl;

    @javax.persistence.Column(name = "FPFEDLVL")
    @Basic
    public String getFpfedlvl() {
        return fpfedlvl;
    }

    public void setFpfedlvl(String fpfedlvl) {
        this.fpfedlvl = fpfedlvl;
    }

    private String fpmedlvl;

    @javax.persistence.Column(name = "FPMEDLVL")
    @Basic
    public String getFpmedlvl() {
        return fpmedlvl;
    }

    public void setFpmedlvl(String fpmedlvl) {
        this.fpmedlvl = fpmedlvl;
    }

    private BigInteger fpszhhd;

    @javax.persistence.Column(name = "FPSZHHD")
    @Basic
    public BigInteger getFpszhhd() {
        return fpszhhd;
    }

    public void setFpszhhd(BigInteger fpszhhd) {
        this.fpszhhd = fpszhhd;
    }

    private BigInteger fpnrps;

    @javax.persistence.Column(name = "FPNRPS")
    @Basic
    public BigInteger getFpnrps() {
        return fpnrps;
    }

    public void setFpnrps(BigInteger fpnrps) {
        this.fpnrps = fpnrps;
    }

    private String fptrfil;

    @javax.persistence.Column(name = "FPTRFIL")
    @Basic
    public String getFptrfil() {
        return fptrfil;
    }

    public void setFptrfil(String fptrfil) {
        this.fptrfil = fptrfil;
    }

    private BigInteger fpexemp;

    @javax.persistence.Column(name = "FPEXEMP")
    @Basic
    public BigInteger getFpexemp() {
        return fpexemp;
    }

    public void setFpexemp(BigInteger fpexemp) {
        this.fpexemp = fpexemp;
    }

    private int fpagi;

    @javax.persistence.Column(name = "FPAGI")
    @Basic
    public int getFpagi() {
        return fpagi;
    }

    public void setFpagi(int fpagi) {
        this.fpagi = fpagi;
    }

    private int fpitx;

    @javax.persistence.Column(name = "FPITX")
    @Basic
    public int getFpitx() {
        return fpitx;
    }

    public void setFpitx(int fpitx) {
        this.fpitx = fpitx;
    }

    private int fpded;

    @javax.persistence.Column(name = "FPDED")
    @Basic
    public int getFpded() {
        return fpded;
    }

    public void setFpded(int fpded) {
        this.fpded = fpded;
    }

    private int fpfwag;

    @javax.persistence.Column(name = "FPFWAG")
    @Basic
    public int getFpfwag() {
        return fpfwag;
    }

    public void setFpfwag(int fpfwag) {
        this.fpfwag = fpfwag;
    }

    private int fpmwag;

    @javax.persistence.Column(name = "FPMWAG")
    @Basic
    public int getFpmwag() {
        return fpmwag;
    }

    public void setFpmwag(int fpmwag) {
        this.fpmwag = fpmwag;
    }

    private int fpss;

    @javax.persistence.Column(name = "FPSS")
    @Basic
    public int getFpss() {
        return fpss;
    }

    public void setFpss(int fpss) {
        this.fpss = fpss;
    }

    private int fpadc;

    @javax.persistence.Column(name = "FPADC")
    @Basic
    public int getFpadc() {
        return fpadc;
    }

    public void setFpadc(int fpadc) {
        this.fpadc = fpadc;
    }

    private int fpcs;

    @javax.persistence.Column(name = "FPCS")
    @Basic
    public int getFpcs() {
        return fpcs;
    }

    public void setFpcs(int fpcs) {
        this.fpcs = fpcs;
    }

    private int fponti;

    @javax.persistence.Column(name = "FPONTI")
    @Basic
    public int getFponti() {
        return fponti;
    }

    public void setFponti(int fponti) {
        this.fponti = fponti;
    }

    private int fpnti;

    @javax.persistence.Column(name = "FPNTI")
    @Basic
    public int getFpnti() {
        return fpnti;
    }

    public void setFpnti(int fpnti) {
        this.fpnti = fpnti;
    }

    private int fpsttx;

    @javax.persistence.Column(name = "FPSTTX")
    @Basic
    public int getFpsttx() {
        return fpsttx;
    }

    public void setFpsttx(int fpsttx) {
        this.fpsttx = fpsttx;
    }

    private int fpmed;

    @javax.persistence.Column(name = "FPMED")
    @Basic
    public int getFpmed() {
        return fpmed;
    }

    public void setFpmed(int fpmed) {
        this.fpmed = fpmed;
    }

    private int fpmeda;

    @javax.persistence.Column(name = "FPMEDA")
    @Basic
    public int getFpmeda() {
        return fpmeda;
    }

    public void setFpmeda(int fpmeda) {
        this.fpmeda = fpmeda;
    }

    private int fptuit;

    @javax.persistence.Column(name = "FPTUIT")
    @Basic
    public int getFptuit() {
        return fptuit;
    }

    public void setFptuit(int fptuit) {
        this.fptuit = fptuit;
    }

    private BigInteger fpntuit;

    @javax.persistence.Column(name = "FPNTUIT")
    @Basic
    public BigInteger getFpntuit() {
        return fpntuit;
    }

    public void setFpntuit(BigInteger fpntuit) {
        this.fpntuit = fpntuit;
    }

    private int fptuita;

    @javax.persistence.Column(name = "FPTUITA")
    @Basic
    public int getFptuita() {
        return fptuita;
    }

    public void setFptuita(int fptuita) {
        this.fptuita = fptuita;
    }

    private String fpdiswk;

    @javax.persistence.Column(name = "FPDISWK")
    @Basic
    public String getFpdiswk() {
        return fpdiswk;
    }

    public void setFpdiswk(String fpdiswk) {
        this.fpdiswk = fpdiswk;
    }

    private int fpbfwag;

    @javax.persistence.Column(name = "FPBFWAG")
    @Basic
    public int getFpbfwag() {
        return fpbfwag;
    }

    public void setFpbfwag(int fpbfwag) {
        this.fpbfwag = fpbfwag;
    }

    private int fpbmwag;

    @javax.persistence.Column(name = "FPBMWAG")
    @Basic
    public int getFpbmwag() {
        return fpbmwag;
    }

    public void setFpbmwag(int fpbmwag) {
        this.fpbmwag = fpbmwag;
    }

    private int fpboti;

    @javax.persistence.Column(name = "FPBOTI")
    @Basic
    public int getFpboti() {
        return fpboti;
    }

    public void setFpboti(int fpboti) {
        this.fpboti = fpboti;
    }

    private int fpbonti;

    @javax.persistence.Column(name = "FPBONTI")
    @Basic
    public int getFpbonti() {
        return fpbonti;
    }

    public void setFpbonti(int fpbonti) {
        this.fpbonti = fpbonti;
    }

    private String fpdishm;

    @javax.persistence.Column(name = "FPDISHM")
    @Basic
    public String getFpdishm() {
        return fpdishm;
    }

    public void setFpdishm(String fpdishm) {
        this.fpdishm = fpdishm;
    }

    private BigInteger fpage;

    @javax.persistence.Column(name = "FPAGE")
    @Basic
    public BigInteger getFpage() {
        return fpage;
    }

    public void setFpage(BigInteger fpage) {
        this.fpage = fpage;
    }

    private int fpcash;

    @javax.persistence.Column(name = "FPCASH")
    @Basic
    public int getFpcash() {
        return fpcash;
    }

    public void setFpcash(int fpcash) {
        this.fpcash = fpcash;
    }

    private int fphomv;

    @javax.persistence.Column(name = "FPHOMV")
    @Basic
    public int getFphomv() {
        return fphomv;
    }

    public void setFphomv(int fphomv) {
        this.fphomv = fphomv;
    }

    private int fphomd;

    @javax.persistence.Column(name = "FPHOMD")
    @Basic
    public int getFphomd() {
        return fphomd;
    }

    public void setFphomd(int fphomd) {
        this.fphomd = fphomd;
    }

    private int fpfarmv;

    @javax.persistence.Column(name = "FPFARMV")
    @Basic
    public int getFpfarmv() {
        return fpfarmv;
    }

    public void setFpfarmv(int fpfarmv) {
        this.fpfarmv = fpfarmv;
    }

    private int fpfarmd;

    @javax.persistence.Column(name = "FPFARMD")
    @Basic
    public int getFpfarmd() {
        return fpfarmd;
    }

    public void setFpfarmd(int fpfarmd) {
        this.fpfarmd = fpfarmd;
    }

    private int fporiv;

    @javax.persistence.Column(name = "FPORIV")
    @Basic
    public int getFporiv() {
        return fporiv;
    }

    public void setFporiv(int fporiv) {
        this.fporiv = fporiv;
    }

    private int fporid;

    @javax.persistence.Column(name = "FPORID")
    @Basic
    public int getFporid() {
        return fporid;
    }

    public void setFporid(int fporid) {
        this.fporid = fporid;
    }

    private int fpbusv;

    @javax.persistence.Column(name = "FPBUSV")
    @Basic
    public int getFpbusv() {
        return fpbusv;
    }

    public void setFpbusv(int fpbusv) {
        this.fpbusv = fpbusv;
    }

    private int fpbusd;

    @javax.persistence.Column(name = "FPBUSD")
    @Basic
    public int getFpbusd() {
        return fpbusd;
    }

    public void setFpbusd(int fpbusd) {
        this.fpbusd = fpbusd;
    }

    private String fpfarm;

    @javax.persistence.Column(name = "FPFARM")
    @Basic
    public String getFpfarm() {
        return fpfarm;
    }

    public void setFpfarm(String fpfarm) {
        this.fpfarm = fpfarm;
    }

    private int fpafi;

    @javax.persistence.Column(name = "FPAFI")
    @Basic
    public int getFpafi() {
        return fpafi;
    }

    public void setFpafi(int fpafi) {
        this.fpafi = fpafi;
    }

    private int fpefi;

    @javax.persistence.Column(name = "FPEFI")
    @Basic
    public int getFpefi() {
        return fpefi;
    }

    public void setFpefi(int fpefi) {
        this.fpefi = fpefi;
    }

    private int fpfso;

    @javax.persistence.Column(name = "FPFSO")
    @Basic
    public int getFpfso() {
        return fpfso;
    }

    public void setFpfso(int fpfso) {
        this.fpfso = fpfso;
    }

    private int fpeea;

    @javax.persistence.Column(name = "FPEEA")
    @Basic
    public int getFpeea() {
        return fpeea;
    }

    public void setFpeea(int fpeea) {
        this.fpeea = fpeea;
    }

    private int fpdfi;

    @javax.persistence.Column(name = "FPDFI")
    @Basic
    public int getFpdfi() {
        return fpdfi;
    }

    public void setFpdfi(int fpdfi) {
        this.fpdfi = fpdfi;
    }

    private int fppconi;

    @javax.persistence.Column(name = "FPPCONI")
    @Basic
    public int getFppconi() {
        return fppconi;
    }

    public void setFppconi(int fppconi) {
        this.fppconi = fppconi;
    }

    private int fphar;

    @javax.persistence.Column(name = "FPHAR")
    @Basic
    public int getFphar() {
        return fphar;
    }

    public void setFphar(int fphar) {
        this.fphar = fphar;
    }

    private int fpoar;

    @javax.persistence.Column(name = "FPOAR")
    @Basic
    public int getFpoar() {
        return fpoar;
    }

    public void setFpoar(int fpoar) {
        this.fpoar = fpoar;
    }

    private int fpbar;

    @javax.persistence.Column(name = "FPBAR")
    @Basic
    public int getFpbar() {
        return fpbar;
    }

    public void setFpbar(int fpbar) {
        this.fpbar = fpbar;
    }

    private int fppca;

    @javax.persistence.Column(name = "FPPCA")
    @Basic
    public int getFppca() {
        return fppca;
    }

    public void setFppca(int fppca) {
        this.fppca = fppca;
    }

    private int fptpc;

    @javax.persistence.Column(name = "FPTPC")
    @Basic
    public int getFptpc() {
        return fptpc;
    }

    public void setFptpc(int fptpc) {
        this.fptpc = fptpc;
    }

    private int fpapc;

    @javax.persistence.Column(name = "FPAPC")
    @Basic
    public int getFpapc() {
        return fpapc;
    }

    public void setFpapc(int fpapc) {
        this.fpapc = fpapc;
    }

    private int fpbdfi;

    @javax.persistence.Column(name = "FPBDFI")
    @Basic
    public int getFpbdfi() {
        return fpbdfi;
    }

    public void setFpbdfi(int fpbdfi) {
        this.fpbdfi = fpbdfi;
    }

    private int fpdtuita;

    @javax.persistence.Column(name = "FPDTUITA")
    @Basic
    public int getFpdtuita() {
        return fpdtuita;
    }

    public void setFpdtuita(int fpdtuita) {
        this.fpdtuita = fpdtuita;
    }

    private int fsdafi;

    @javax.persistence.Column(name = "FSDAFI")
    @Basic
    public int getFsdafi() {
        return fsdafi;
    }

    public void setFsdafi(int fsdafi) {
        this.fsdafi = fsdafi;
    }

    private int fsdefi;

    @javax.persistence.Column(name = "FSDEFI")
    @Basic
    public int getFsdefi() {
        return fsdefi;
    }

    public void setFsdefi(int fsdefi) {
        this.fsdefi = fsdefi;
    }

    private int fpbitx;

    @javax.persistence.Column(name = "FPBITX")
    @Basic
    public int getFpbitx() {
        return fpbitx;
    }

    public void setFpbitx(int fpbitx) {
        this.fpbitx = fpbitx;
    }

    private int fpdsttx;

    @javax.persistence.Column(name = "FPDSTTX")
    @Basic
    public int getFpdsttx() {
        return fpdsttx;
    }

    public void setFpdsttx(int fpdsttx) {
        this.fpdsttx = fpdsttx;
    }

    private int fpdmeda;

    @javax.persistence.Column(name = "FPDMEDA")
    @Basic
    public int getFpdmeda() {
        return fpdmeda;
    }

    public void setFpdmeda(int fpdmeda) {
        this.fpdmeda = fpdmeda;
    }

    private int fpdea;

    @javax.persistence.Column(name = "FPDEA")
    @Basic
    public int getFpdea() {
        return fpdea;
    }

    public void setFpdea(int fpdea) {
        this.fpdea = fpdea;
    }

    private int fpdfso;

    @javax.persistence.Column(name = "FPDFSO")
    @Basic
    public int getFpdfso() {
        return fpdfso;
    }

    public void setFpdfso(int fpdfso) {
        this.fpdfso = fpdfso;
    }

    private int fpbafi;

    @javax.persistence.Column(name = "FPBAFI")
    @Basic
    public int getFpbafi() {
        return fpbafi;
    }

    public void setFpbafi(int fpbafi) {
        this.fpbafi = fpbafi;
    }

    private int fphome;

    @javax.persistence.Column(name = "FPHOME")
    @Basic
    public int getFphome() {
        return fphome;
    }

    public void setFphome(int fphome) {
        this.fphome = fphome;
    }

    private int fporie;

    @javax.persistence.Column(name = "FPORIE")
    @Basic
    public int getFporie() {
        return fporie;
    }

    public void setFporie(int fporie) {
        this.fporie = fporie;
    }

    private int tpexemp;

    @javax.persistence.Column(name = "TPEXEMP")
    @Basic
    public int getTpexemp() {
        return tpexemp;
    }

    public void setTpexemp(int tpexemp) {
        this.tpexemp = tpexemp;
    }

    private int tpdivex;

    @javax.persistence.Column(name = "TPDIVEX")
    @Basic
    public int getTpdivex() {
        return tpdivex;
    }

    public void setTpdivex(int tpdivex) {
        this.tpdivex = tpdivex;
    }

    private int tpfwag;

    @javax.persistence.Column(name = "TPFWAG")
    @Basic
    public int getTpfwag() {
        return tpfwag;
    }

    public void setTpfwag(int tpfwag) {
        this.tpfwag = tpfwag;
    }

    private int tpmwag;

    @javax.persistence.Column(name = "TPMWAG")
    @Basic
    public int getTpmwag() {
        return tpmwag;
    }

    public void setTpmwag(int tpmwag) {
        this.tpmwag = tpmwag;
    }

    private int tpwag;

    @javax.persistence.Column(name = "TPWAG")
    @Basic
    public int getTpwag() {
        return tpwag;
    }

    public void setTpwag(int tpwag) {
        this.tpwag = tpwag;
    }

    private int tpint;

    @javax.persistence.Column(name = "TPINT")
    @Basic
    public int getTpint() {
        return tpint;
    }

    public void setTpint(int tpint) {
        this.tpint = tpint;
    }

    private int tpdivn;

    @javax.persistence.Column(name = "TPDIVN")
    @Basic
    public int getTpdivn() {
        return tpdivn;
    }

    public void setTpdivn(int tpdivn) {
        this.tpdivn = tpdivn;
    }

    private int tpdiv;

    @javax.persistence.Column(name = "TPDIV")
    @Basic
    public int getTpdiv() {
        return tpdiv;
    }

    public void setTpdiv(int tpdiv) {
        this.tpdiv = tpdiv;
    }

    private int tprfsl;

    @javax.persistence.Column(name = "TPRFSL")
    @Basic
    public int getTprfsl() {
        return tprfsl;
    }

    public void setTprfsl(int tprfsl) {
        this.tprfsl = tprfsl;
    }

    private int tpalim;

    @javax.persistence.Column(name = "TPALIM")
    @Basic
    public int getTpalim() {
        return tpalim;
    }

    public void setTpalim(int tpalim) {
        this.tpalim = tpalim;
    }

    private int tpbus;

    @javax.persistence.Column(name = "TPBUS")
    @Basic
    public int getTpbus() {
        return tpbus;
    }

    public void setTpbus(int tpbus) {
        this.tpbus = tpbus;
    }

    private int tpfiex;

    @javax.persistence.Column(name = "TPFIEX")
    @Basic
    public int getTpfiex() {
        return tpfiex;
    }

    public void setTpfiex(int tpfiex) {
        this.tpfiex = tpfiex;
    }

    private int tppeno;

    @javax.persistence.Column(name = "TPPENO")
    @Basic
    public int getTppeno() {
        return tppeno;
    }

    public void setTppeno(int tppeno) {
        this.tppeno = tppeno;
    }

    private int tppent;

    @javax.persistence.Column(name = "TPPENT")
    @Basic
    public int getTppent() {
        return tppent;
    }

    public void setTppent(int tppent) {
        this.tppent = tppent;
    }

    private int tprent;

    @javax.persistence.Column(name = "TPRENT")
    @Basic
    public int getTprent() {
        return tprent;
    }

    public void setTprent(int tprent) {
        this.tprent = tprent;
    }

    private int tpfarm;

    @javax.persistence.Column(name = "TPFARM")
    @Basic
    public int getTpfarm() {
        return tpfarm;
    }

    public void setTpfarm(int tpfarm) {
        this.tpfarm = tpfarm;
    }

    private int tpiradt;

    @javax.persistence.Column(name = "TPIRADT")
    @Basic
    public int getTpiradt() {
        return tpiradt;
    }

    public void setTpiradt(int tpiradt) {
        this.tpiradt = tpiradt;
    }

    private int tpunemt;

    @javax.persistence.Column(name = "TPUNEMT")
    @Basic
    public int getTpunemt() {
        return tpunemt;
    }

    public void setTpunemt(int tpunemt) {
        this.tpunemt = tpunemt;
    }

    private int tpss;

    @javax.persistence.Column(name = "TPSS")
    @Basic
    public int getTpss() {
        return tpss;
    }

    public void setTpss(int tpss) {
        this.tpss = tpss;
    }

    private int tpsstp;

    @javax.persistence.Column(name = "TPSSTP")
    @Basic
    public int getTpsstp() {
        return tpsstp;
    }

    public void setTpsstp(int tpsstp) {
        this.tpsstp = tpsstp;
    }

    private int tpoti;

    @javax.persistence.Column(name = "TPOTI")
    @Basic
    public int getTpoti() {
        return tpoti;
    }

    public void setTpoti(int tpoti) {
        this.tpoti = tpoti;
    }

    private int tpebex;

    @javax.persistence.Column(name = "TPEBEX")
    @Basic
    public int getTpebex() {
        return tpebex;
    }

    public void setTpebex(int tpebex) {
        this.tpebex = tpebex;
    }

    private int tpira;

    @javax.persistence.Column(name = "TPIRA")
    @Basic
    public int getTpira() {
        return tpira;
    }

    public void setTpira(int tpira) {
        this.tpira = tpira;
    }

    private int tpkeogh;

    @javax.persistence.Column(name = "TPKEOGH")
    @Basic
    public int getTpkeogh() {
        return tpkeogh;
    }

    public void setTpkeogh(int tpkeogh) {
        this.tpkeogh = tpkeogh;
    }

    private int tpalmpd;

    @javax.persistence.Column(name = "TPALMPD")
    @Basic
    public int getTpalmpd() {
        return tpalmpd;
    }

    public void setTpalmpd(int tpalmpd) {
        this.tpalmpd = tpalmpd;
    }

    private int tptirad;

    @javax.persistence.Column(name = "TPTIRAD")
    @Basic
    public int getTptirad() {
        return tptirad;
    }

    public void setTptirad(int tptirad) {
        this.tptirad = tptirad;
    }

    private int tpadji;

    @javax.persistence.Column(name = "TPADJI")
    @Basic
    public int getTpadji() {
        return tpadji;
    }

    public void setTpadji(int tpadji) {
        this.tpadji = tpadji;
    }

    private int tpagi;

    @javax.persistence.Column(name = "TPAGI")
    @Basic
    public int getTpagi() {
        return tpagi;
    }

    public void setTpagi(int tpagi) {
        this.tpagi = tpagi;
    }

    private int tpfitx;

    @javax.persistence.Column(name = "TPFITX")
    @Basic
    public int getTpfitx() {
        return tpfitx;
    }

    public void setTpfitx(int tpfitx) {
        this.tpfitx = tpfitx;
    }

    private int tpfuel;

    @javax.persistence.Column(name = "TPFUEL")
    @Basic
    public int getTpfuel() {
        return tpfuel;
    }

    public void setTpfuel(int tpfuel) {
        this.tpfuel = tpfuel;
    }

    private int tpmed;

    @javax.persistence.Column(name = "TPMED")
    @Basic
    public int getTpmed() {
        return tpmed;
    }

    public void setTpmed(int tpmed) {
        this.tpmed = tpmed;
    }

    private int tpstx;

    @javax.persistence.Column(name = "TPSTX")
    @Basic
    public int getTpstx() {
        return tpstx;
    }

    public void setTpstx(int tpstx) {
        this.tpstx = tpstx;
    }

    private int tpsira;

    @javax.persistence.Column(name = "TPSIRA")
    @Basic
    public int getTpsira() {
        return tpsira;
    }

    public void setTpsira(int tpsira) {
        this.tpsira = tpsira;
    }

    private int tpeic;

    @javax.persistence.Column(name = "TPEIC")
    @Basic
    public int getTpeic() {
        return tpeic;
    }

    public void setTpeic(int tpeic) {
        this.tpeic = tpeic;
    }

    private int tpcapg;

    @javax.persistence.Column(name = "TPCAPG")
    @Basic
    public int getTpcapg() {
        return tpcapg;
    }

    public void setTpcapg(int tpcapg) {
        this.tpcapg = tpcapg;
    }

    private int tpcapg4;

    @javax.persistence.Column(name = "TPCAPG4")
    @Basic
    public int getTpcapg4() {
        return tpcapg4;
    }

    public void setTpcapg4(int tpcapg4) {
        this.tpcapg4 = tpcapg4;
    }

    private int tpmonti;

    @javax.persistence.Column(name = "TPMONTI")
    @Basic
    public int getTpmonti() {
        return tpmonti;
    }

    public void setTpmonti(int tpmonti) {
        this.tpmonti = tpmonti;
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

        Snf2Entity that = (Snf2Entity) o;

        if (fpadc != that.fpadc) return false;
        if (fpafi != that.fpafi) return false;
        if (fpagi != that.fpagi) return false;
        if (fpapc != that.fpapc) return false;
        if (fpbafi != that.fpbafi) return false;
        if (fpbar != that.fpbar) return false;
        if (fpbdfi != that.fpbdfi) return false;
        if (fpbfwag != that.fpbfwag) return false;
        if (fpbitx != that.fpbitx) return false;
        if (fpbmwag != that.fpbmwag) return false;
        if (fpbonti != that.fpbonti) return false;
        if (fpboti != that.fpboti) return false;
        if (fpbusd != that.fpbusd) return false;
        if (fpbusv != that.fpbusv) return false;
        if (fpcash != that.fpcash) return false;
        if (fpcs != that.fpcs) return false;
        if (fpdea != that.fpdea) return false;
        if (fpded != that.fpded) return false;
        if (fpdfi != that.fpdfi) return false;
        if (fpdfso != that.fpdfso) return false;
        if (fpdmeda != that.fpdmeda) return false;
        if (fpdsttx != that.fpdsttx) return false;
        if (fpdtuita != that.fpdtuita) return false;
        if (fpeea != that.fpeea) return false;
        if (fpefi != that.fpefi) return false;
        if (fpfarmd != that.fpfarmd) return false;
        if (fpfarmv != that.fpfarmv) return false;
        if (fpfso != that.fpfso) return false;
        if (fpfwag != that.fpfwag) return false;
        if (fphar != that.fphar) return false;
        if (fphomd != that.fphomd) return false;
        if (fphome != that.fphome) return false;
        if (fphomv != that.fphomv) return false;
        if (fpitx != that.fpitx) return false;
        if (fpmed != that.fpmed) return false;
        if (fpmeda != that.fpmeda) return false;
        if (fpmwag != that.fpmwag) return false;
        if (fpnti != that.fpnti) return false;
        if (fpoar != that.fpoar) return false;
        if (fponti != that.fponti) return false;
        if (fporid != that.fporid) return false;
        if (fporie != that.fporie) return false;
        if (fporiv != that.fporiv) return false;
        if (fppca != that.fppca) return false;
        if (fppconi != that.fppconi) return false;
        if (fpss != that.fpss) return false;
        if (fpsttx != that.fpsttx) return false;
        if (fptpc != that.fptpc) return false;
        if (fptuit != that.fptuit) return false;
        if (fptuita != that.fptuita) return false;
        if (fsdafi != that.fsdafi) return false;
        if (fsdefi != that.fsdefi) return false;
        if (tpadji != that.tpadji) return false;
        if (tpagi != that.tpagi) return false;
        if (tpalim != that.tpalim) return false;
        if (tpalmpd != that.tpalmpd) return false;
        if (tpbus != that.tpbus) return false;
        if (tpcapg != that.tpcapg) return false;
        if (tpcapg4 != that.tpcapg4) return false;
        if (tpdiv != that.tpdiv) return false;
        if (tpdivex != that.tpdivex) return false;
        if (tpdivn != that.tpdivn) return false;
        if (tpebex != that.tpebex) return false;
        if (tpeic != that.tpeic) return false;
        if (tpexemp != that.tpexemp) return false;
        if (tpfarm != that.tpfarm) return false;
        if (tpfiex != that.tpfiex) return false;
        if (tpfitx != that.tpfitx) return false;
        if (tpfuel != that.tpfuel) return false;
        if (tpfwag != that.tpfwag) return false;
        if (tpint != that.tpint) return false;
        if (tpira != that.tpira) return false;
        if (tpiradt != that.tpiradt) return false;
        if (tpkeogh != that.tpkeogh) return false;
        if (tpmed != that.tpmed) return false;
        if (tpmonti != that.tpmonti) return false;
        if (tpmwag != that.tpmwag) return false;
        if (tpoti != that.tpoti) return false;
        if (tppeno != that.tppeno) return false;
        if (tppent != that.tppent) return false;
        if (tprent != that.tprent) return false;
        if (tprfsl != that.tprfsl) return false;
        if (tpsira != that.tpsira) return false;
        if (tpss != that.tpss) return false;
        if (tpsstp != that.tpsstp) return false;
        if (tpstx != that.tpstx) return false;
        if (tptirad != that.tptirad) return false;
        if (tpunemt != that.tpunemt) return false;
        if (tpwag != that.tpwag) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (fpage != null ? !fpage.equals(that.fpage) : that.fpage != null) return false;
        if (fpdishm != null ? !fpdishm.equals(that.fpdishm) : that.fpdishm != null) return false;
        if (fpdiswk != null ? !fpdiswk.equals(that.fpdiswk) : that.fpdiswk != null) return false;
        if (fpexemp != null ? !fpexemp.equals(that.fpexemp) : that.fpexemp != null) return false;
        if (fpfarm != null ? !fpfarm.equals(that.fpfarm) : that.fpfarm != null) return false;
        if (fpfedlvl != null ? !fpfedlvl.equals(that.fpfedlvl) : that.fpfedlvl != null) return false;
        if (fpincol != null ? !fpincol.equals(that.fpincol) : that.fpincol != null) return false;
        if (fpmartl != null ? !fpmartl.equals(that.fpmartl) : that.fpmartl != null) return false;
        if (fpmedlvl != null ? !fpmedlvl.equals(that.fpmedlvl) : that.fpmedlvl != null) return false;
        if (fpnrps != null ? !fpnrps.equals(that.fpnrps) : that.fpnrps != null) return false;
        if (fpntuit != null ? !fpntuit.equals(that.fpntuit) : that.fpntuit != null) return false;
        if (fpres != null ? !fpres.equals(that.fpres) : that.fpres != null) return false;
        if (fpszhhd != null ? !fpszhhd.equals(that.fpszhhd) : that.fpszhhd != null) return false;
        if (fptrfil != null ? !fptrfil.equals(that.fptrfil) : that.fptrfil != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snfkey != null ? !snfkey.equals(that.snfkey) : that.snfkey != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snfkey != null ? snfkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cmptype != null ? cmptype.hashCode() : 0);
        result = 31 * result + (versnr != null ? versnr.hashCode() : 0);
        result = 31 * result + (fpincol != null ? fpincol.hashCode() : 0);
        result = 31 * result + (fpmartl != null ? fpmartl.hashCode() : 0);
        result = 31 * result + (fpres != null ? fpres.hashCode() : 0);
        result = 31 * result + (fpfedlvl != null ? fpfedlvl.hashCode() : 0);
        result = 31 * result + (fpmedlvl != null ? fpmedlvl.hashCode() : 0);
        result = 31 * result + (fpszhhd != null ? fpszhhd.hashCode() : 0);
        result = 31 * result + (fpnrps != null ? fpnrps.hashCode() : 0);
        result = 31 * result + (fptrfil != null ? fptrfil.hashCode() : 0);
        result = 31 * result + (fpexemp != null ? fpexemp.hashCode() : 0);
        result = 31 * result + fpagi;
        result = 31 * result + fpitx;
        result = 31 * result + fpded;
        result = 31 * result + fpfwag;
        result = 31 * result + fpmwag;
        result = 31 * result + fpss;
        result = 31 * result + fpadc;
        result = 31 * result + fpcs;
        result = 31 * result + fponti;
        result = 31 * result + fpnti;
        result = 31 * result + fpsttx;
        result = 31 * result + fpmed;
        result = 31 * result + fpmeda;
        result = 31 * result + fptuit;
        result = 31 * result + (fpntuit != null ? fpntuit.hashCode() : 0);
        result = 31 * result + fptuita;
        result = 31 * result + (fpdiswk != null ? fpdiswk.hashCode() : 0);
        result = 31 * result + fpbfwag;
        result = 31 * result + fpbmwag;
        result = 31 * result + fpboti;
        result = 31 * result + fpbonti;
        result = 31 * result + (fpdishm != null ? fpdishm.hashCode() : 0);
        result = 31 * result + (fpage != null ? fpage.hashCode() : 0);
        result = 31 * result + fpcash;
        result = 31 * result + fphomv;
        result = 31 * result + fphomd;
        result = 31 * result + fpfarmv;
        result = 31 * result + fpfarmd;
        result = 31 * result + fporiv;
        result = 31 * result + fporid;
        result = 31 * result + fpbusv;
        result = 31 * result + fpbusd;
        result = 31 * result + (fpfarm != null ? fpfarm.hashCode() : 0);
        result = 31 * result + fpafi;
        result = 31 * result + fpefi;
        result = 31 * result + fpfso;
        result = 31 * result + fpeea;
        result = 31 * result + fpdfi;
        result = 31 * result + fppconi;
        result = 31 * result + fphar;
        result = 31 * result + fpoar;
        result = 31 * result + fpbar;
        result = 31 * result + fppca;
        result = 31 * result + fptpc;
        result = 31 * result + fpapc;
        result = 31 * result + fpbdfi;
        result = 31 * result + fpdtuita;
        result = 31 * result + fsdafi;
        result = 31 * result + fsdefi;
        result = 31 * result + fpbitx;
        result = 31 * result + fpdsttx;
        result = 31 * result + fpdmeda;
        result = 31 * result + fpdea;
        result = 31 * result + fpdfso;
        result = 31 * result + fpbafi;
        result = 31 * result + fphome;
        result = 31 * result + fporie;
        result = 31 * result + tpexemp;
        result = 31 * result + tpdivex;
        result = 31 * result + tpfwag;
        result = 31 * result + tpmwag;
        result = 31 * result + tpwag;
        result = 31 * result + tpint;
        result = 31 * result + tpdivn;
        result = 31 * result + tpdiv;
        result = 31 * result + tprfsl;
        result = 31 * result + tpalim;
        result = 31 * result + tpbus;
        result = 31 * result + tpfiex;
        result = 31 * result + tppeno;
        result = 31 * result + tppent;
        result = 31 * result + tprent;
        result = 31 * result + tpfarm;
        result = 31 * result + tpiradt;
        result = 31 * result + tpunemt;
        result = 31 * result + tpss;
        result = 31 * result + tpsstp;
        result = 31 * result + tpoti;
        result = 31 * result + tpebex;
        result = 31 * result + tpira;
        result = 31 * result + tpkeogh;
        result = 31 * result + tpalmpd;
        result = 31 * result + tptirad;
        result = 31 * result + tpadji;
        result = 31 * result + tpagi;
        result = 31 * result + tpfitx;
        result = 31 * result + tpfuel;
        result = 31 * result + tpmed;
        result = 31 * result + tpstx;
        result = 31 * result + tpsira;
        result = 31 * result + tpeic;
        result = 31 * result + tpcapg;
        result = 31 * result + tpcapg4;
        result = 31 * result + tpmonti;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
