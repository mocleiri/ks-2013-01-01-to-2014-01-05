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
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNP", schema = "SIGMA", catalog = "")
@Entity
public class SnpEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnpkey();
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

    private String snpkey;

    @javax.persistence.Column(name = "SNPKEY")
    @Id
    public String getSnpkey() {
        return snpkey;
    }

    public void setSnpkey(String snpkey) {
        this.snpkey = snpkey;
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

    private String pmaritl;

    @javax.persistence.Column(name = "PMARITL")
    @Basic
    public String getPmaritl() {
        return pmaritl;
    }

    public void setPmaritl(String pmaritl) {
        this.pmaritl = pmaritl;
    }

    private String pfedlvl;

    @javax.persistence.Column(name = "PFEDLVL")
    @Basic
    public String getPfedlvl() {
        return pfedlvl;
    }

    public void setPfedlvl(String pfedlvl) {
        this.pfedlvl = pfedlvl;
    }

    private String pmedlvl;

    @javax.persistence.Column(name = "PMEDLVL")
    @Basic
    public String getPmedlvl() {
        return pmedlvl;
    }

    public void setPmedlvl(String pmedlvl) {
        this.pmedlvl = pmedlvl;
    }

    private BigInteger page;

    @javax.persistence.Column(name = "PAGE")
    @Basic
    public BigInteger getPage() {
        return page;
    }

    public void setPage(BigInteger page) {
        this.page = page;
    }

    private BigInteger psizhhd;

    @javax.persistence.Column(name = "PSIZHHD")
    @Basic
    public BigInteger getPsizhhd() {
        return psizhhd;
    }

    public void setPsizhhd(BigInteger psizhhd) {
        this.psizhhd = psizhhd;
    }

    private BigInteger pexemp;

    @javax.persistence.Column(name = "PEXEMP")
    @Basic
    public BigInteger getPexemp() {
        return pexemp;
    }

    public void setPexemp(BigInteger pexemp) {
        this.pexemp = pexemp;
    }

    private BigInteger pnrps;

    @javax.persistence.Column(name = "PNRPS")
    @Basic
    public BigInteger getPnrps() {
        return pnrps;
    }

    public void setPnrps(BigInteger pnrps) {
        this.pnrps = pnrps;
    }

    private BigInteger pincoll;

    @javax.persistence.Column(name = "PINCOLL")
    @Basic
    public BigInteger getPincoll() {
        return pincoll;
    }

    public void setPincoll(BigInteger pincoll) {
        this.pincoll = pincoll;
    }

    private String pdiswk;

    @javax.persistence.Column(name = "PDISWK")
    @Basic
    public String getPdiswk() {
        return pdiswk;
    }

    public void setPdiswk(String pdiswk) {
        this.pdiswk = pdiswk;
    }

    private String pdishm;

    @javax.persistence.Column(name = "PDISHM")
    @Basic
    public String getPdishm() {
        return pdishm;
    }

    public void setPdishm(String pdishm) {
        this.pdishm = pdishm;
    }

    private String ptrfil;

    @javax.persistence.Column(name = "PTRFIL")
    @Basic
    public String getPtrfil() {
        return ptrfil;
    }

    public void setPtrfil(String ptrfil) {
        this.ptrfil = ptrfil;
    }

    private int pfwag;

    @javax.persistence.Column(name = "PFWAG")
    @Basic
    public int getPfwag() {
        return pfwag;
    }

    public void setPfwag(int pfwag) {
        this.pfwag = pfwag;
    }

    private int pmwag;

    @javax.persistence.Column(name = "PMWAG")
    @Basic
    public int getPmwag() {
        return pmwag;
    }

    public void setPmwag(int pmwag) {
        this.pmwag = pmwag;
    }

    private int padjw;

    @javax.persistence.Column(name = "PADJW")
    @Basic
    public int getPadjw() {
        return padjw;
    }

    public void setPadjw(int padjw) {
        this.padjw = padjw;
    }

    private int pwag;

    @javax.persistence.Column(name = "PWAG")
    @Basic
    public int getPwag() {
        return pwag;
    }

    public void setPwag(int pwag) {
        this.pwag = pwag;
    }

    private int pint;

    @javax.persistence.Column(name = "PINT")
    @Basic
    public int getPint() {
        return pint;
    }

    public void setPint(int pint) {
        this.pint = pint;
    }

    private int pdiv;

    @javax.persistence.Column(name = "PDIV")
    @Basic
    public int getPdiv() {
        return pdiv;
    }

    public void setPdiv(int pdiv) {
        this.pdiv = pdiv;
    }

    private int pbfri;

    @javax.persistence.Column(name = "PBFRI")
    @Basic
    public int getPbfri() {
        return pbfri;
    }

    public void setPbfri(int pbfri) {
        this.pbfri = pbfri;
    }

    private int poti;

    @javax.persistence.Column(name = "POTI")
    @Basic
    public int getPoti() {
        return poti;
    }

    public void setPoti(int poti) {
        this.poti = poti;
    }

    private int pbex;

    @javax.persistence.Column(name = "PBEX")
    @Basic
    public int getPbex() {
        return pbex;
    }

    public void setPbex(int pbex) {
        this.pbex = pbex;
    }

    private int padj;

    @javax.persistence.Column(name = "PADJ")
    @Basic
    public int getPadj() {
        return padj;
    }

    public void setPadj(int padj) {
        this.padj = padj;
    }

    private int pttinc;

    @javax.persistence.Column(name = "PTTINC")
    @Basic
    public int getPttinc() {
        return pttinc;
    }

    public void setPttinc(int pttinc) {
        this.pttinc = pttinc;
    }

    private int pagir;

    @javax.persistence.Column(name = "PAGIR")
    @Basic
    public int getPagir() {
        return pagir;
    }

    public void setPagir(int pagir) {
        this.pagir = pagir;
    }

    private int pss;

    @javax.persistence.Column(name = "PSS")
    @Basic
    public int getPss() {
        return pss;
    }

    public void setPss(int pss) {
        this.pss = pss;
    }

    private int padc;

    @javax.persistence.Column(name = "PADC")
    @Basic
    public int getPadc() {
        return padc;
    }

    public void setPadc(int padc) {
        this.padc = padc;
    }

    private int pntcs;

    @javax.persistence.Column(name = "PNTCS")
    @Basic
    public int getPntcs() {
        return pntcs;
    }

    public void setPntcs(int pntcs) {
        this.pntcs = pntcs;
    }

    private int ponti;

    @javax.persistence.Column(name = "PONTI")
    @Basic
    public int getPonti() {
        return ponti;
    }

    public void setPonti(int ponti) {
        this.ponti = ponti;
    }

    private int pinca1;

    @javax.persistence.Column(name = "PINCA1")
    @Basic
    public int getPinca1() {
        return pinca1;
    }

    public void setPinca1(int pinca1) {
        this.pinca1 = pinca1;
    }

    private int pinca2;

    @javax.persistence.Column(name = "PINCA2")
    @Basic
    public int getPinca2() {
        return pinca2;
    }

    public void setPinca2(int pinca2) {
        this.pinca2 = pinca2;
    }

    private int ptinc;

    @javax.persistence.Column(name = "PTINC")
    @Basic
    public int getPtinc() {
        return ptinc;
    }

    public void setPtinc(int ptinc) {
        this.ptinc = ptinc;
    }

    private int pded;

    @javax.persistence.Column(name = "PDED")
    @Basic
    public int getPded() {
        return pded;
    }

    public void setPded(int pded) {
        this.pded = pded;
    }

    private int pitxp;

    @javax.persistence.Column(name = "PITXP")
    @Basic
    public int getPitxp() {
        return pitxp;
    }

    public void setPitxp(int pitxp) {
        this.pitxp = pitxp;
    }

    private int pitxc;

    @javax.persistence.Column(name = "PITXC")
    @Basic
    public int getPitxc() {
        return pitxc;
    }

    public void setPitxc(int pitxc) {
        this.pitxc = pitxc;
    }

    private int pitx;

    @javax.persistence.Column(name = "PITX")
    @Basic
    public int getPitx() {
        return pitx;
    }

    public void setPitx(int pitx) {
        this.pitx = pitx;
    }

    private int pfica;

    @javax.persistence.Column(name = "PFICA")
    @Basic
    public int getPfica() {
        return pfica;
    }

    public void setPfica(int pfica) {
        this.pfica = pfica;
    }

    private int psttx;

    @javax.persistence.Column(name = "PSTTX")
    @Basic
    public int getPsttx() {
        return psttx;
    }

    public void setPsttx(int psttx) {
        this.psttx = psttx;
    }

    private int pmed;

    @javax.persistence.Column(name = "PMED")
    @Basic
    public int getPmed() {
        return pmed;
    }

    public void setPmed(int pmed) {
        this.pmed = pmed;
    }

    private int pmeda;

    @javax.persistence.Column(name = "PMEDA")
    @Basic
    public int getPmeda() {
        return pmeda;
    }

    public void setPmeda(int pmeda) {
        this.pmeda = pmeda;
    }

    private int ptuit;

    @javax.persistence.Column(name = "PTUIT")
    @Basic
    public int getPtuit() {
        return ptuit;
    }

    public void setPtuit(int ptuit) {
        this.ptuit = ptuit;
    }

    private BigInteger pntuit;

    @javax.persistence.Column(name = "PNTUIT")
    @Basic
    public BigInteger getPntuit() {
        return pntuit;
    }

    public void setPntuit(BigInteger pntuit) {
        this.pntuit = pntuit;
    }

    private int ptuita;

    @javax.persistence.Column(name = "PTUITA")
    @Basic
    public int getPtuita() {
        return ptuita;
    }

    public void setPtuita(int ptuita) {
        this.ptuita = ptuita;
    }

    private int pemalo;

    @javax.persistence.Column(name = "PEMALO")
    @Basic
    public int getPemalo() {
        return pemalo;
    }

    public void setPemalo(int pemalo) {
        this.pemalo = pemalo;
    }

    private int psma;

    @javax.persistence.Column(name = "PSMA")
    @Basic
    public int getPsma() {
        return psma;
    }

    public void setPsma(int psma) {
        this.psma = psma;
    }

    private int pialo1;

    @javax.persistence.Column(name = "PIALO1")
    @Basic
    public int getPialo1() {
        return pialo1;
    }

    public void setPialo1(int pialo1) {
        this.pialo1 = pialo1;
    }

    private int pialo2;

    @javax.persistence.Column(name = "PIALO2")
    @Basic
    public int getPialo2() {
        return pialo2;
    }

    public void setPialo2(int pialo2) {
        this.pialo2 = pialo2;
    }

    private int ptotalo;

    @javax.persistence.Column(name = "PTOTALO")
    @Basic
    public int getPtotalo() {
        return ptotalo;
    }

    public void setPtotalo(int ptotalo) {
        this.ptotalo = ptotalo;
    }

    private int pefinc;

    @javax.persistence.Column(name = "PEFINC")
    @Basic
    public int getPefinc() {
        return pefinc;
    }

    public void setPefinc(int pefinc) {
        this.pefinc = pefinc;
    }

    private int pcash;

    @javax.persistence.Column(name = "PCASH")
    @Basic
    public int getPcash() {
        return pcash;
    }

    public void setPcash(int pcash) {
        this.pcash = pcash;
    }

    private int pinvv;

    @javax.persistence.Column(name = "PINVV")
    @Basic
    public int getPinvv() {
        return pinvv;
    }

    public void setPinvv(int pinvv) {
        this.pinvv = pinvv;
    }

    private int pinvd;

    @javax.persistence.Column(name = "PINVD")
    @Basic
    public int getPinvd() {
        return pinvd;
    }

    public void setPinvd(int pinvd) {
        this.pinvd = pinvd;
    }

    private int pinve;

    @javax.persistence.Column(name = "PINVE")
    @Basic
    public int getPinve() {
        return pinve;
    }

    public void setPinve(int pinve) {
        this.pinve = pinve;
    }

    private int porv;

    @javax.persistence.Column(name = "PORV")
    @Basic
    public int getPorv() {
        return porv;
    }

    public void setPorv(int porv) {
        this.porv = porv;
    }

    private int pord;

    @javax.persistence.Column(name = "PORD")
    @Basic
    public int getPord() {
        return pord;
    }

    public void setPord(int pord) {
        this.pord = pord;
    }

    private int pore;

    @javax.persistence.Column(name = "PORE")
    @Basic
    public int getPore() {
        return pore;
    }

    public void setPore(int pore) {
        this.pore = pore;
    }

    private int pdass;

    @javax.persistence.Column(name = "PDASS")
    @Basic
    public int getPdass() {
        return pdass;
    }

    public void setPdass(int pdass) {
        this.pdass = pdass;
    }

    private int phompv;

    @javax.persistence.Column(name = "PHOMPV")
    @Basic
    public int getPhompv() {
        return phompv;
    }

    public void setPhompv(int phompv) {
        this.phompv = phompv;
    }

    private int phomc;

    @javax.persistence.Column(name = "PHOMC")
    @Basic
    public int getPhomc() {
        return phomc;
    }

    public void setPhomc(int phomc) {
        this.phomc = phomc;
    }

    private int phomv;

    @javax.persistence.Column(name = "PHOMV")
    @Basic
    public int getPhomv() {
        return phomv;
    }

    public void setPhomv(int phomv) {
        this.phomv = phomv;
    }

    private int phomd;

    @javax.persistence.Column(name = "PHOMD")
    @Basic
    public int getPhomd() {
        return phomd;
    }

    public void setPhomd(int phomd) {
        this.phomd = phomd;
    }

    private int phome;

    @javax.persistence.Column(name = "PHOME")
    @Basic
    public int getPhome() {
        return phome;
    }

    public void setPhome(int phome) {
        this.phome = phome;
    }

    private int pfarmv;

    @javax.persistence.Column(name = "PFARMV")
    @Basic
    public int getPfarmv() {
        return pfarmv;
    }

    public void setPfarmv(int pfarmv) {
        this.pfarmv = pfarmv;
    }

    private int pfarmd;

    @javax.persistence.Column(name = "PFARMD")
    @Basic
    public int getPfarmd() {
        return pfarmd;
    }

    public void setPfarmd(int pfarmd) {
        this.pfarmd = pfarmd;
    }

    private int pfarme;

    @javax.persistence.Column(name = "PFARME")
    @Basic
    public int getPfarme() {
        return pfarme;
    }

    public void setPfarme(int pfarme) {
        this.pfarme = pfarme;
    }

    private int pbfv;

    @javax.persistence.Column(name = "PBFV")
    @Basic
    public int getPbfv() {
        return pbfv;
    }

    public void setPbfv(int pbfv) {
        this.pbfv = pbfv;
    }

    private int pbfd;

    @javax.persistence.Column(name = "PBFD")
    @Basic
    public int getPbfd() {
        return pbfd;
    }

    public void setPbfd(int pbfd) {
        this.pbfd = pbfd;
    }

    private int pbfe;

    @javax.persistence.Column(name = "PBFE")
    @Basic
    public int getPbfe() {
        return pbfe;
    }

    public void setPbfe(int pbfe) {
        this.pbfe = pbfe;
    }

    private String pfarm;

    @javax.persistence.Column(name = "PFARM")
    @Basic
    public String getPfarm() {
        return pfarm;
    }

    public void setPfarm(String pfarm) {
        this.pfarm = pfarm;
    }

    private int pabfw;

    @javax.persistence.Column(name = "PABFW")
    @Basic
    public int getPabfw() {
        return pabfw;
    }

    public void setPabfw(int pabfw) {
        this.pabfw = pabfw;
    }

    private int passadj;

    @javax.persistence.Column(name = "PASSADJ")
    @Basic
    public int getPassadj() {
        return passadj;
    }

    public void setPassadj(int passadj) {
        this.passadj = passadj;
    }

    private int ptass;

    @javax.persistence.Column(name = "PTASS")
    @Basic
    public int getPtass() {
        return ptass;
    }

    public void setPtass(int ptass) {
        this.ptass = ptass;
    }

    private int pothd;

    @javax.persistence.Column(name = "POTHD")
    @Basic
    public int getPothd() {
        return pothd;
    }

    public void setPothd(int pothd) {
        this.pothd = pothd;
    }

    private int pnwrth;

    @javax.persistence.Column(name = "PNWRTH")
    @Basic
    public int getPnwrth() {
        return pnwrth;
    }

    public void setPnwrth(int pnwrth) {
        this.pnwrth = pnwrth;
    }

    private int papa;

    @javax.persistence.Column(name = "PAPA")
    @Basic
    public int getPapa() {
        return papa;
    }

    public void setPapa(int papa) {
        this.papa = papa;
    }

    private int pdnet;

    @javax.persistence.Column(name = "PDNET")
    @Basic
    public int getPdnet() {
        return pdnet;
    }

    public void setPdnet(int pdnet) {
        this.pdnet = pdnet;
    }

    private BigDecimal passcr;

    @javax.persistence.Column(name = "PASSCR")
    @Basic
    public BigDecimal getPasscr() {
        return passcr;
    }

    public void setPasscr(BigDecimal passcr) {
        this.passcr = passcr;
    }

    private int pincsu;

    @javax.persistence.Column(name = "PINCSU")
    @Basic
    public int getPincsu() {
        return pincsu;
    }

    public void setPincsu(int pincsu) {
        this.pincsu = pincsu;
    }

    private int paavli;

    @javax.persistence.Column(name = "PAAVLI")
    @Basic
    public int getPaavli() {
        return paavli;
    }

    public void setPaavli(int paavli) {
        this.paavli = paavli;
    }

    private BigDecimal pcola;

    @javax.persistence.Column(name = "PCOLA")
    @Basic
    public BigDecimal getPcola() {
        return pcola;
    }

    public void setPcola(BigDecimal pcola) {
        this.pcola = pcola;
    }

    private int praavli;

    @javax.persistence.Column(name = "PRAAVLI")
    @Basic
    public int getPraavli() {
        return praavli;
    }

    public void setPraavli(int praavli) {
        this.praavli = praavli;
    }

    private int ptconf;

    @javax.persistence.Column(name = "PTCONF")
    @Basic
    public int getPtconf() {
        return ptconf;
    }

    public void setPtconf(int ptconf) {
        this.ptconf = ptconf;
    }

    private int pconfn;

    @javax.persistence.Column(name = "PCONFN")
    @Basic
    public int getPconfn() {
        return pconfn;
    }

    public void setPconfn(int pconfn) {
        this.pconfn = pconfn;
    }

    private int pconf;

    @javax.persistence.Column(name = "PCONF")
    @Basic
    public int getPconf() {
        return pconf;
    }

    public void setPconf(int pconf) {
        this.pconf = pconf;
    }

    private int pbfwag;

    @javax.persistence.Column(name = "PBFWAG")
    @Basic
    public int getPbfwag() {
        return pbfwag;
    }

    public void setPbfwag(int pbfwag) {
        this.pbfwag = pbfwag;
    }

    private int pbmwag;

    @javax.persistence.Column(name = "PBMWAG")
    @Basic
    public int getPbmwag() {
        return pbmwag;
    }

    public void setPbmwag(int pbmwag) {
        this.pbmwag = pbmwag;
    }

    private int pboti;

    @javax.persistence.Column(name = "PBOTI")
    @Basic
    public int getPboti() {
        return pboti;
    }

    public void setPboti(int pboti) {
        this.pboti = pboti;
    }

    private int pbtti;

    @javax.persistence.Column(name = "PBTTI")
    @Basic
    public int getPbtti() {
        return pbtti;
    }

    public void setPbtti(int pbtti) {
        this.pbtti = pbtti;
    }

    private int pbagir;

    @javax.persistence.Column(name = "PBAGIR")
    @Basic
    public int getPbagir() {
        return pbagir;
    }

    public void setPbagir(int pbagir) {
        this.pbagir = pbagir;
    }

    private int pbss;

    @javax.persistence.Column(name = "PBSS")
    @Basic
    public int getPbss() {
        return pbss;
    }

    public void setPbss(int pbss) {
        this.pbss = pbss;
    }

    private int pbadc;

    @javax.persistence.Column(name = "PBADC")
    @Basic
    public int getPbadc() {
        return pbadc;
    }

    public void setPbadc(int pbadc) {
        this.pbadc = pbadc;
    }

    private int pbntcs;

    @javax.persistence.Column(name = "PBNTCS")
    @Basic
    public int getPbntcs() {
        return pbntcs;
    }

    public void setPbntcs(int pbntcs) {
        this.pbntcs = pbntcs;
    }

    private int pbonti;

    @javax.persistence.Column(name = "PBONTI")
    @Basic
    public int getPbonti() {
        return pbonti;
    }

    public void setPbonti(int pbonti) {
        this.pbonti = pbonti;
    }

    private int pbinca;

    @javax.persistence.Column(name = "PBINCA")
    @Basic
    public int getPbinca() {
        return pbinca;
    }

    public void setPbinca(int pbinca) {
        this.pbinca = pbinca;
    }

    private int pbnti;

    @javax.persistence.Column(name = "PBNTI")
    @Basic
    public int getPbnti() {
        return pbnti;
    }

    public void setPbnti(int pbnti) {
        this.pbnti = pbnti;
    }

    private int pbti;

    @javax.persistence.Column(name = "PBTI")
    @Basic
    public int getPbti() {
        return pbti;
    }

    public void setPbti(int pbti) {
        this.pbti = pbti;
    }

    private int pbitx;

    @javax.persistence.Column(name = "PBITX")
    @Basic
    public int getPbitx() {
        return pbitx;
    }

    public void setPbitx(int pbitx) {
        this.pbitx = pbitx;
    }

    private int pbfica;

    @javax.persistence.Column(name = "PBFICA")
    @Basic
    public int getPbfica() {
        return pbfica;
    }

    public void setPbfica(int pbfica) {
        this.pbfica = pbfica;
    }

    private int pbsttx;

    @javax.persistence.Column(name = "PBSTTX")
    @Basic
    public int getPbsttx() {
        return pbsttx;
    }

    public void setPbsttx(int pbsttx) {
        this.pbsttx = pbsttx;
    }

    private int pbmeda;

    @javax.persistence.Column(name = "PBMEDA")
    @Basic
    public int getPbmeda() {
        return pbmeda;
    }

    public void setPbmeda(int pbmeda) {
        this.pbmeda = pbmeda;
    }

    private int pbtuit;

    @javax.persistence.Column(name = "PBTUIT")
    @Basic
    public int getPbtuit() {
        return pbtuit;
    }

    public void setPbtuit(int pbtuit) {
        this.pbtuit = pbtuit;
    }

    private int pbemal;

    @javax.persistence.Column(name = "PBEMAL")
    @Basic
    public int getPbemal() {
        return pbemal;
    }

    public void setPbemal(int pbemal) {
        this.pbemal = pbemal;
    }

    private int pbsma;

    @javax.persistence.Column(name = "PBSMA")
    @Basic
    public int getPbsma() {
        return pbsma;
    }

    public void setPbsma(int pbsma) {
        this.pbsma = pbsma;
    }

    private int pbial1;

    @javax.persistence.Column(name = "PBIAL1")
    @Basic
    public int getPbial1() {
        return pbial1;
    }

    public void setPbial1(int pbial1) {
        this.pbial1 = pbial1;
    }

    private int pbial2;

    @javax.persistence.Column(name = "PBIAL2")
    @Basic
    public int getPbial2() {
        return pbial2;
    }

    public void setPbial2(int pbial2) {
        this.pbial2 = pbial2;
    }

    private int pbtalo;

    @javax.persistence.Column(name = "PBTALO")
    @Basic
    public int getPbtalo() {
        return pbtalo;
    }

    public void setPbtalo(int pbtalo) {
        this.pbtalo = pbtalo;
    }

    private int pbefin;

    @javax.persistence.Column(name = "PBEFIN")
    @Basic
    public int getPbefin() {
        return pbefin;
    }

    public void setPbefin(int pbefin) {
        this.pbefin = pbefin;
    }

    private int ptnti;

    @javax.persistence.Column(name = "PTNTI")
    @Basic
    public int getPtnti() {
        return ptnti;
    }

    public void setPtnti(int ptnti) {
        this.ptnti = ptnti;
    }

    private int pbtuita;

    @javax.persistence.Column(name = "PBTUITA")
    @Basic
    public int getPbtuita() {
        return pbtuita;
    }

    public void setPbtuita(int pbtuita) {
        this.pbtuita = pbtuita;
    }

    private int pbnwrth;

    @javax.persistence.Column(name = "PBNWRTH")
    @Basic
    public int getPbnwrth() {
        return pbnwrth;
    }

    public void setPbnwrth(int pbnwrth) {
        this.pbnwrth = pbnwrth;
    }

    private int pbapa;

    @javax.persistence.Column(name = "PBAPA")
    @Basic
    public int getPbapa() {
        return pbapa;
    }

    public void setPbapa(int pbapa) {
        this.pbapa = pbapa;
    }

    private int pbdnet;

    @javax.persistence.Column(name = "PBDNET")
    @Basic
    public int getPbdnet() {
        return pbdnet;
    }

    public void setPbdnet(int pbdnet) {
        this.pbdnet = pbdnet;
    }

    private BigDecimal pbasscr;

    @javax.persistence.Column(name = "PBASSCR")
    @Basic
    public BigDecimal getPbasscr() {
        return pbasscr;
    }

    public void setPbasscr(BigDecimal pbasscr) {
        this.pbasscr = pbasscr;
    }

    private int pbincsu;

    @javax.persistence.Column(name = "PBINCSU")
    @Basic
    public int getPbincsu() {
        return pbincsu;
    }

    public void setPbincsu(int pbincsu) {
        this.pbincsu = pbincsu;
    }

    private int pbaavli;

    @javax.persistence.Column(name = "PBAAVLI")
    @Basic
    public int getPbaavli() {
        return pbaavli;
    }

    public void setPbaavli(int pbaavli) {
        this.pbaavli = pbaavli;
    }

    private int pbhome;

    @javax.persistence.Column(name = "PBHOME")
    @Basic
    public int getPbhome() {
        return pbhome;
    }

    public void setPbhome(int pbhome) {
        this.pbhome = pbhome;
    }

    private int pbabfw;

    @javax.persistence.Column(name = "PBABFW")
    @Basic
    public int getPbabfw() {
        return pbabfw;
    }

    public void setPbabfw(int pbabfw) {
        this.pbabfw = pbabfw;
    }

    private int pbconf;

    @javax.persistence.Column(name = "PBCONF")
    @Basic
    public int getPbconf() {
        return pbconf;
    }

    public void setPbconf(int pbconf) {
        this.pbconf = pbconf;
    }

    private int pexcld;

    @javax.persistence.Column(name = "PEXCLD")
    @Basic
    public int getPexcld() {
        return pexcld;
    }

    public void setPexcld(int pexcld) {
        this.pexcld = pexcld;
    }

    private String phvplus;

    @javax.persistence.Column(name = "PHVPLUS")
    @Basic
    public String getPhvplus() {
        return phvplus;
    }

    public void setPhvplus(String phvplus) {
        this.phvplus = phvplus;
    }

    private int apexcld;

    @javax.persistence.Column(name = "APEXCLD")
    @Basic
    public int getApexcld() {
        return apexcld;
    }

    public void setApexcld(int apexcld) {
        this.apexcld = apexcld;
    }

    private int pinccr;

    @javax.persistence.Column(name = "PINCCR")
    @Basic
    public int getPinccr() {
        return pinccr;
    }

    public void setPinccr(int pinccr) {
        this.pinccr = pinccr;
    }

    private int apinccr;

    @javax.persistence.Column(name = "APINCCR")
    @Basic
    public int getApinccr() {
        return apinccr;
    }

    public void setApinccr(int apinccr) {
        this.apinccr = apinccr;
    }

    private int aponti;

    @javax.persistence.Column(name = "APONTI")
    @Basic
    public int getAponti() {
        return aponti;
    }

    public void setAponti(int aponti) {
        this.aponti = aponti;
    }

    private int apadc;

    @javax.persistence.Column(name = "APADC")
    @Basic
    public int getApadc() {
        return apadc;
    }

    public void setApadc(int apadc) {
        this.apadc = apadc;
    }

    private int apntcs;

    @javax.persistence.Column(name = "APNTCS")
    @Basic
    public int getApntcs() {
        return apntcs;
    }

    public void setApntcs(int apntcs) {
        this.apntcs = apntcs;
    }

    private BigInteger phmyrz;

    @javax.persistence.Column(name = "PHMYRZ")
    @Basic
    public BigInteger getPhmyrz() {
        return phmyrz;
    }

    public void setPhmyrz(BigInteger phmyrz) {
        this.phmyrz = phmyrz;
    }

    private BigInteger phomyr;

    @javax.persistence.Column(name = "PHOMYR")
    @Basic
    public BigInteger getPhomyr() {
        return phomyr;
    }

    public void setPhomyr(BigInteger phomyr) {
        this.phomyr = phomyr;
    }

    private int sbasset;

    @javax.persistence.Column(name = "SBASSET")
    @Basic
    public int getSbasset() {
        return sbasset;
    }

    public void setSbasset(int sbasset) {
        this.sbasset = sbasset;
    }

    private String pfilrtn;

    @javax.persistence.Column(name = "PFILRTN")
    @Basic
    public String getPfilrtn() {
        return pfilrtn;
    }

    public void setPfilrtn(String pfilrtn) {
        this.pfilrtn = pfilrtn;
    }

    private String pelgfil;

    @javax.persistence.Column(name = "PELGFIL")
    @Basic
    public String getPelgfil() {
        return pelgfil;
    }

    public void setPelgfil(String pelgfil) {
        this.pelgfil = pelgfil;
    }

    private String presbfr;

    @javax.persistence.Column(name = "PRESBFR")
    @Basic
    public String getPresbfr() {
        return presbfr;
    }

    public void setPresbfr(String presbfr) {
        this.presbfr = presbfr;
    }

    private String grdlvl1;

    @javax.persistence.Column(name = "GRDLVL1")
    @Basic
    public String getGrdlvl1() {
        return grdlvl1;
    }

    public void setGrdlvl1(String grdlvl1) {
        this.grdlvl1 = grdlvl1;
    }

    private String grdlvl2;

    @javax.persistence.Column(name = "GRDLVL2")
    @Basic
    public String getGrdlvl2() {
        return grdlvl2;
    }

    public void setGrdlvl2(String grdlvl2) {
        this.grdlvl2 = grdlvl2;
    }

    private String grdlvl3;

    @javax.persistence.Column(name = "GRDLVL3")
    @Basic
    public String getGrdlvl3() {
        return grdlvl3;
    }

    public void setGrdlvl3(String grdlvl3) {
        this.grdlvl3 = grdlvl3;
    }

    private String grdlvl4;

    @javax.persistence.Column(name = "GRDLVL4")
    @Basic
    public String getGrdlvl4() {
        return grdlvl4;
    }

    public void setGrdlvl4(String grdlvl4) {
        this.grdlvl4 = grdlvl4;
    }

    private String grdlvl5;

    @javax.persistence.Column(name = "GRDLVL5")
    @Basic
    public String getGrdlvl5() {
        return grdlvl5;
    }

    public void setGrdlvl5(String grdlvl5) {
        this.grdlvl5 = grdlvl5;
    }

    private String grdlvl6;

    @javax.persistence.Column(name = "GRDLVL6")
    @Basic
    public String getGrdlvl6() {
        return grdlvl6;
    }

    public void setGrdlvl6(String grdlvl6) {
        this.grdlvl6 = grdlvl6;
    }

    private String grdlvl7;

    @javax.persistence.Column(name = "GRDLVL7")
    @Basic
    public String getGrdlvl7() {
        return grdlvl7;
    }

    public void setGrdlvl7(String grdlvl7) {
        this.grdlvl7 = grdlvl7;
    }

    private String grdlvl8;

    @javax.persistence.Column(name = "GRDLVL8")
    @Basic
    public String getGrdlvl8() {
        return grdlvl8;
    }

    public void setGrdlvl8(String grdlvl8) {
        this.grdlvl8 = grdlvl8;
    }

    private String grdlvl9;

    @javax.persistence.Column(name = "GRDLVL9")
    @Basic
    public String getGrdlvl9() {
        return grdlvl9;
    }

    public void setGrdlvl9(String grdlvl9) {
        this.grdlvl9 = grdlvl9;
    }

    private String grdlvla;

    @javax.persistence.Column(name = "GRDLVLA")
    @Basic
    public String getGrdlvla() {
        return grdlvla;
    }

    public void setGrdlvla(String grdlvla) {
        this.grdlvla = grdlvla;
    }

    private String grdlvlb;

    @javax.persistence.Column(name = "GRDLVLB")
    @Basic
    public String getGrdlvlb() {
        return grdlvlb;
    }

    public void setGrdlvlb(String grdlvlb) {
        this.grdlvlb = grdlvlb;
    }

    private String grdlvlc;

    @javax.persistence.Column(name = "GRDLVLC")
    @Basic
    public String getGrdlvlc() {
        return grdlvlc;
    }

    public void setGrdlvlc(String grdlvlc) {
        this.grdlvlc = grdlvlc;
    }

    private String namefl;

    @javax.persistence.Column(name = "NAMEFL")
    @Basic
    public String getNamefl() {
        return namefl;
    }

    public void setNamefl(String namefl) {
        this.namefl = namefl;
    }

    private String ssnfat;

    @javax.persistence.Column(name = "SSNFAT")
    @Basic
    public String getSsnfat() {
        return ssnfat;
    }

    public void setSsnfat(String ssnfat) {
        this.ssnfat = ssnfat;
    }

    private String assnfat;

    @javax.persistence.Column(name = "ASSNFAT")
    @Basic
    public String getAssnfat() {
        return assnfat;
    }

    public void setAssnfat(String assnfat) {
        this.assnfat = assnfat;
    }

    private String nameml;

    @javax.persistence.Column(name = "NAMEML")
    @Basic
    public String getNameml() {
        return nameml;
    }

    public void setNameml(String nameml) {
        this.nameml = nameml;
    }

    private String ssnmot;

    @javax.persistence.Column(name = "SSNMOT")
    @Basic
    public String getSsnmot() {
        return ssnmot;
    }

    public void setSsnmot(String ssnmot) {
        this.ssnmot = ssnmot;
    }

    private String assnmot;

    @javax.persistence.Column(name = "ASSNMOT")
    @Basic
    public String getAssnmot() {
        return assnmot;
    }

    public void setAssnmot(String assnmot) {
        this.assnmot = assnmot;
    }

    private int aesamt;

    @javax.persistence.Column(name = "AESAMT")
    @Basic
    public int getAesamt() {
        return aesamt;
    }

    public void setAesamt(int aesamt) {
        this.aesamt = aesamt;
    }

    private int cesamt;

    @javax.persistence.Column(name = "CESAMT")
    @Basic
    public int getCesamt() {
        return cesamt;
    }

    public void setCesamt(int cesamt) {
        this.cesamt = cesamt;
    }

    private String cssncol;

    @javax.persistence.Column(name = "CSSNCOL")
    @Basic
    public String getCssncol() {
        return cssncol;
    }

    public void setCssncol(String cssncol) {
        this.cssncol = cssncol;
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

        SnpEntity snpEntity = (SnpEntity) o;

        if (aesamt != snpEntity.aesamt) return false;
        if (apadc != snpEntity.apadc) return false;
        if (apexcld != snpEntity.apexcld) return false;
        if (apinccr != snpEntity.apinccr) return false;
        if (apntcs != snpEntity.apntcs) return false;
        if (aponti != snpEntity.aponti) return false;
        if (cesamt != snpEntity.cesamt) return false;
        if (paavli != snpEntity.paavli) return false;
        if (pabfw != snpEntity.pabfw) return false;
        if (padc != snpEntity.padc) return false;
        if (padj != snpEntity.padj) return false;
        if (padjw != snpEntity.padjw) return false;
        if (pagir != snpEntity.pagir) return false;
        if (papa != snpEntity.papa) return false;
        if (passadj != snpEntity.passadj) return false;
        if (pbaavli != snpEntity.pbaavli) return false;
        if (pbabfw != snpEntity.pbabfw) return false;
        if (pbadc != snpEntity.pbadc) return false;
        if (pbagir != snpEntity.pbagir) return false;
        if (pbapa != snpEntity.pbapa) return false;
        if (pbconf != snpEntity.pbconf) return false;
        if (pbdnet != snpEntity.pbdnet) return false;
        if (pbefin != snpEntity.pbefin) return false;
        if (pbemal != snpEntity.pbemal) return false;
        if (pbex != snpEntity.pbex) return false;
        if (pbfd != snpEntity.pbfd) return false;
        if (pbfe != snpEntity.pbfe) return false;
        if (pbfica != snpEntity.pbfica) return false;
        if (pbfri != snpEntity.pbfri) return false;
        if (pbfv != snpEntity.pbfv) return false;
        if (pbfwag != snpEntity.pbfwag) return false;
        if (pbhome != snpEntity.pbhome) return false;
        if (pbial1 != snpEntity.pbial1) return false;
        if (pbial2 != snpEntity.pbial2) return false;
        if (pbinca != snpEntity.pbinca) return false;
        if (pbincsu != snpEntity.pbincsu) return false;
        if (pbitx != snpEntity.pbitx) return false;
        if (pbmeda != snpEntity.pbmeda) return false;
        if (pbmwag != snpEntity.pbmwag) return false;
        if (pbntcs != snpEntity.pbntcs) return false;
        if (pbnti != snpEntity.pbnti) return false;
        if (pbnwrth != snpEntity.pbnwrth) return false;
        if (pbonti != snpEntity.pbonti) return false;
        if (pboti != snpEntity.pboti) return false;
        if (pbsma != snpEntity.pbsma) return false;
        if (pbss != snpEntity.pbss) return false;
        if (pbsttx != snpEntity.pbsttx) return false;
        if (pbtalo != snpEntity.pbtalo) return false;
        if (pbti != snpEntity.pbti) return false;
        if (pbtti != snpEntity.pbtti) return false;
        if (pbtuit != snpEntity.pbtuit) return false;
        if (pbtuita != snpEntity.pbtuita) return false;
        if (pcash != snpEntity.pcash) return false;
        if (pconf != snpEntity.pconf) return false;
        if (pconfn != snpEntity.pconfn) return false;
        if (pdass != snpEntity.pdass) return false;
        if (pded != snpEntity.pded) return false;
        if (pdiv != snpEntity.pdiv) return false;
        if (pdnet != snpEntity.pdnet) return false;
        if (pefinc != snpEntity.pefinc) return false;
        if (pemalo != snpEntity.pemalo) return false;
        if (pexcld != snpEntity.pexcld) return false;
        if (pfarmd != snpEntity.pfarmd) return false;
        if (pfarme != snpEntity.pfarme) return false;
        if (pfarmv != snpEntity.pfarmv) return false;
        if (pfica != snpEntity.pfica) return false;
        if (pfwag != snpEntity.pfwag) return false;
        if (phomc != snpEntity.phomc) return false;
        if (phomd != snpEntity.phomd) return false;
        if (phome != snpEntity.phome) return false;
        if (phompv != snpEntity.phompv) return false;
        if (phomv != snpEntity.phomv) return false;
        if (pialo1 != snpEntity.pialo1) return false;
        if (pialo2 != snpEntity.pialo2) return false;
        if (pinca1 != snpEntity.pinca1) return false;
        if (pinca2 != snpEntity.pinca2) return false;
        if (pinccr != snpEntity.pinccr) return false;
        if (pincsu != snpEntity.pincsu) return false;
        if (pint != snpEntity.pint) return false;
        if (pinvd != snpEntity.pinvd) return false;
        if (pinve != snpEntity.pinve) return false;
        if (pinvv != snpEntity.pinvv) return false;
        if (pitx != snpEntity.pitx) return false;
        if (pitxc != snpEntity.pitxc) return false;
        if (pitxp != snpEntity.pitxp) return false;
        if (pmed != snpEntity.pmed) return false;
        if (pmeda != snpEntity.pmeda) return false;
        if (pmwag != snpEntity.pmwag) return false;
        if (pntcs != snpEntity.pntcs) return false;
        if (pnwrth != snpEntity.pnwrth) return false;
        if (ponti != snpEntity.ponti) return false;
        if (pord != snpEntity.pord) return false;
        if (pore != snpEntity.pore) return false;
        if (porv != snpEntity.porv) return false;
        if (pothd != snpEntity.pothd) return false;
        if (poti != snpEntity.poti) return false;
        if (praavli != snpEntity.praavli) return false;
        if (psma != snpEntity.psma) return false;
        if (pss != snpEntity.pss) return false;
        if (psttx != snpEntity.psttx) return false;
        if (ptass != snpEntity.ptass) return false;
        if (ptconf != snpEntity.ptconf) return false;
        if (ptinc != snpEntity.ptinc) return false;
        if (ptnti != snpEntity.ptnti) return false;
        if (ptotalo != snpEntity.ptotalo) return false;
        if (pttinc != snpEntity.pttinc) return false;
        if (ptuit != snpEntity.ptuit) return false;
        if (ptuita != snpEntity.ptuita) return false;
        if (pwag != snpEntity.pwag) return false;
        if (revlev != snpEntity.revlev) return false;
        if (sbasset != snpEntity.sbasset) return false;
        if (aidyr != null ? !aidyr.equals(snpEntity.aidyr) : snpEntity.aidyr != null) return false;
        if (assnfat != null ? !assnfat.equals(snpEntity.assnfat) : snpEntity.assnfat != null) return false;
        if (assnmot != null ? !assnmot.equals(snpEntity.assnmot) : snpEntity.assnmot != null) return false;
        if (cmptype != null ? !cmptype.equals(snpEntity.cmptype) : snpEntity.cmptype != null) return false;
        if (createc != null ? !createc.equals(snpEntity.createc) : snpEntity.createc != null) return false;
        if (crttime != null ? !crttime.equals(snpEntity.crttime) : snpEntity.crttime != null) return false;
        if (cssncol != null ? !cssncol.equals(snpEntity.cssncol) : snpEntity.cssncol != null) return false;
        if (grdlvl1 != null ? !grdlvl1.equals(snpEntity.grdlvl1) : snpEntity.grdlvl1 != null) return false;
        if (grdlvl2 != null ? !grdlvl2.equals(snpEntity.grdlvl2) : snpEntity.grdlvl2 != null) return false;
        if (grdlvl3 != null ? !grdlvl3.equals(snpEntity.grdlvl3) : snpEntity.grdlvl3 != null) return false;
        if (grdlvl4 != null ? !grdlvl4.equals(snpEntity.grdlvl4) : snpEntity.grdlvl4 != null) return false;
        if (grdlvl5 != null ? !grdlvl5.equals(snpEntity.grdlvl5) : snpEntity.grdlvl5 != null) return false;
        if (grdlvl6 != null ? !grdlvl6.equals(snpEntity.grdlvl6) : snpEntity.grdlvl6 != null) return false;
        if (grdlvl7 != null ? !grdlvl7.equals(snpEntity.grdlvl7) : snpEntity.grdlvl7 != null) return false;
        if (grdlvl8 != null ? !grdlvl8.equals(snpEntity.grdlvl8) : snpEntity.grdlvl8 != null) return false;
        if (grdlvl9 != null ? !grdlvl9.equals(snpEntity.grdlvl9) : snpEntity.grdlvl9 != null) return false;
        if (grdlvla != null ? !grdlvla.equals(snpEntity.grdlvla) : snpEntity.grdlvla != null) return false;
        if (grdlvlb != null ? !grdlvlb.equals(snpEntity.grdlvlb) : snpEntity.grdlvlb != null) return false;
        if (grdlvlc != null ? !grdlvlc.equals(snpEntity.grdlvlc) : snpEntity.grdlvlc != null) return false;
        if (initals != null ? !initals.equals(snpEntity.initals) : snpEntity.initals != null) return false;
        if (instid != null ? !instid.equals(snpEntity.instid) : snpEntity.instid != null) return false;
        if (module != null ? !module.equals(snpEntity.module) : snpEntity.module != null) return false;
        if (namefl != null ? !namefl.equals(snpEntity.namefl) : snpEntity.namefl != null) return false;
        if (nameml != null ? !nameml.equals(snpEntity.nameml) : snpEntity.nameml != null) return false;
        if (page != null ? !page.equals(snpEntity.page) : snpEntity.page != null) return false;
        if (passcr != null ? !passcr.equals(snpEntity.passcr) : snpEntity.passcr != null) return false;
        if (pbasscr != null ? !pbasscr.equals(snpEntity.pbasscr) : snpEntity.pbasscr != null) return false;
        if (pcola != null ? !pcola.equals(snpEntity.pcola) : snpEntity.pcola != null) return false;
        if (pdishm != null ? !pdishm.equals(snpEntity.pdishm) : snpEntity.pdishm != null) return false;
        if (pdiswk != null ? !pdiswk.equals(snpEntity.pdiswk) : snpEntity.pdiswk != null) return false;
        if (pelgfil != null ? !pelgfil.equals(snpEntity.pelgfil) : snpEntity.pelgfil != null) return false;
        if (pexemp != null ? !pexemp.equals(snpEntity.pexemp) : snpEntity.pexemp != null) return false;
        if (pfarm != null ? !pfarm.equals(snpEntity.pfarm) : snpEntity.pfarm != null) return false;
        if (pfedlvl != null ? !pfedlvl.equals(snpEntity.pfedlvl) : snpEntity.pfedlvl != null) return false;
        if (pfilrtn != null ? !pfilrtn.equals(snpEntity.pfilrtn) : snpEntity.pfilrtn != null) return false;
        if (phmyrz != null ? !phmyrz.equals(snpEntity.phmyrz) : snpEntity.phmyrz != null) return false;
        if (phomyr != null ? !phomyr.equals(snpEntity.phomyr) : snpEntity.phomyr != null) return false;
        if (phvplus != null ? !phvplus.equals(snpEntity.phvplus) : snpEntity.phvplus != null) return false;
        if (pincoll != null ? !pincoll.equals(snpEntity.pincoll) : snpEntity.pincoll != null) return false;
        if (pmaritl != null ? !pmaritl.equals(snpEntity.pmaritl) : snpEntity.pmaritl != null) return false;
        if (pmedlvl != null ? !pmedlvl.equals(snpEntity.pmedlvl) : snpEntity.pmedlvl != null) return false;
        if (pnrps != null ? !pnrps.equals(snpEntity.pnrps) : snpEntity.pnrps != null) return false;
        if (pntuit != null ? !pntuit.equals(snpEntity.pntuit) : snpEntity.pntuit != null) return false;
        if (presbfr != null ? !presbfr.equals(snpEntity.presbfr) : snpEntity.presbfr != null) return false;
        if (psizhhd != null ? !psizhhd.equals(snpEntity.psizhhd) : snpEntity.psizhhd != null) return false;
        if (ptrfil != null ? !ptrfil.equals(snpEntity.ptrfil) : snpEntity.ptrfil != null) return false;
        if (recstat != null ? !recstat.equals(snpEntity.recstat) : snpEntity.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(snpEntity.revdtc) : snpEntity.revdtc != null) return false;
        if (revtime != null ? !revtime.equals(snpEntity.revtime) : snpEntity.revtime != null) return false;
        if (sid != null ? !sid.equals(snpEntity.sid) : snpEntity.sid != null) return false;
        if (snpkey != null ? !snpkey.equals(snpEntity.snpkey) : snpEntity.snpkey != null) return false;
        if (ssnfat != null ? !ssnfat.equals(snpEntity.ssnfat) : snpEntity.ssnfat != null) return false;
        if (ssnmot != null ? !ssnmot.equals(snpEntity.ssnmot) : snpEntity.ssnmot != null) return false;
        if (ucode != null ? !ucode.equals(snpEntity.ucode) : snpEntity.ucode != null) return false;
        if (versnr != null ? !versnr.equals(snpEntity.versnr) : snpEntity.versnr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snpkey != null ? snpkey.hashCode() : 0);
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
        result = 31 * result + (pmaritl != null ? pmaritl.hashCode() : 0);
        result = 31 * result + (pfedlvl != null ? pfedlvl.hashCode() : 0);
        result = 31 * result + (pmedlvl != null ? pmedlvl.hashCode() : 0);
        result = 31 * result + (page != null ? page.hashCode() : 0);
        result = 31 * result + (psizhhd != null ? psizhhd.hashCode() : 0);
        result = 31 * result + (pexemp != null ? pexemp.hashCode() : 0);
        result = 31 * result + (pnrps != null ? pnrps.hashCode() : 0);
        result = 31 * result + (pincoll != null ? pincoll.hashCode() : 0);
        result = 31 * result + (pdiswk != null ? pdiswk.hashCode() : 0);
        result = 31 * result + (pdishm != null ? pdishm.hashCode() : 0);
        result = 31 * result + (ptrfil != null ? ptrfil.hashCode() : 0);
        result = 31 * result + pfwag;
        result = 31 * result + pmwag;
        result = 31 * result + padjw;
        result = 31 * result + pwag;
        result = 31 * result + pint;
        result = 31 * result + pdiv;
        result = 31 * result + pbfri;
        result = 31 * result + poti;
        result = 31 * result + pbex;
        result = 31 * result + padj;
        result = 31 * result + pttinc;
        result = 31 * result + pagir;
        result = 31 * result + pss;
        result = 31 * result + padc;
        result = 31 * result + pntcs;
        result = 31 * result + ponti;
        result = 31 * result + pinca1;
        result = 31 * result + pinca2;
        result = 31 * result + ptinc;
        result = 31 * result + pded;
        result = 31 * result + pitxp;
        result = 31 * result + pitxc;
        result = 31 * result + pitx;
        result = 31 * result + pfica;
        result = 31 * result + psttx;
        result = 31 * result + pmed;
        result = 31 * result + pmeda;
        result = 31 * result + ptuit;
        result = 31 * result + (pntuit != null ? pntuit.hashCode() : 0);
        result = 31 * result + ptuita;
        result = 31 * result + pemalo;
        result = 31 * result + psma;
        result = 31 * result + pialo1;
        result = 31 * result + pialo2;
        result = 31 * result + ptotalo;
        result = 31 * result + pefinc;
        result = 31 * result + pcash;
        result = 31 * result + pinvv;
        result = 31 * result + pinvd;
        result = 31 * result + pinve;
        result = 31 * result + porv;
        result = 31 * result + pord;
        result = 31 * result + pore;
        result = 31 * result + pdass;
        result = 31 * result + phompv;
        result = 31 * result + phomc;
        result = 31 * result + phomv;
        result = 31 * result + phomd;
        result = 31 * result + phome;
        result = 31 * result + pfarmv;
        result = 31 * result + pfarmd;
        result = 31 * result + pfarme;
        result = 31 * result + pbfv;
        result = 31 * result + pbfd;
        result = 31 * result + pbfe;
        result = 31 * result + (pfarm != null ? pfarm.hashCode() : 0);
        result = 31 * result + pabfw;
        result = 31 * result + passadj;
        result = 31 * result + ptass;
        result = 31 * result + pothd;
        result = 31 * result + pnwrth;
        result = 31 * result + papa;
        result = 31 * result + pdnet;
        result = 31 * result + (passcr != null ? passcr.hashCode() : 0);
        result = 31 * result + pincsu;
        result = 31 * result + paavli;
        result = 31 * result + (pcola != null ? pcola.hashCode() : 0);
        result = 31 * result + praavli;
        result = 31 * result + ptconf;
        result = 31 * result + pconfn;
        result = 31 * result + pconf;
        result = 31 * result + pbfwag;
        result = 31 * result + pbmwag;
        result = 31 * result + pboti;
        result = 31 * result + pbtti;
        result = 31 * result + pbagir;
        result = 31 * result + pbss;
        result = 31 * result + pbadc;
        result = 31 * result + pbntcs;
        result = 31 * result + pbonti;
        result = 31 * result + pbinca;
        result = 31 * result + pbnti;
        result = 31 * result + pbti;
        result = 31 * result + pbitx;
        result = 31 * result + pbfica;
        result = 31 * result + pbsttx;
        result = 31 * result + pbmeda;
        result = 31 * result + pbtuit;
        result = 31 * result + pbemal;
        result = 31 * result + pbsma;
        result = 31 * result + pbial1;
        result = 31 * result + pbial2;
        result = 31 * result + pbtalo;
        result = 31 * result + pbefin;
        result = 31 * result + ptnti;
        result = 31 * result + pbtuita;
        result = 31 * result + pbnwrth;
        result = 31 * result + pbapa;
        result = 31 * result + pbdnet;
        result = 31 * result + (pbasscr != null ? pbasscr.hashCode() : 0);
        result = 31 * result + pbincsu;
        result = 31 * result + pbaavli;
        result = 31 * result + pbhome;
        result = 31 * result + pbabfw;
        result = 31 * result + pbconf;
        result = 31 * result + pexcld;
        result = 31 * result + (phvplus != null ? phvplus.hashCode() : 0);
        result = 31 * result + apexcld;
        result = 31 * result + pinccr;
        result = 31 * result + apinccr;
        result = 31 * result + aponti;
        result = 31 * result + apadc;
        result = 31 * result + apntcs;
        result = 31 * result + (phmyrz != null ? phmyrz.hashCode() : 0);
        result = 31 * result + (phomyr != null ? phomyr.hashCode() : 0);
        result = 31 * result + sbasset;
        result = 31 * result + (pfilrtn != null ? pfilrtn.hashCode() : 0);
        result = 31 * result + (pelgfil != null ? pelgfil.hashCode() : 0);
        result = 31 * result + (presbfr != null ? presbfr.hashCode() : 0);
        result = 31 * result + (grdlvl1 != null ? grdlvl1.hashCode() : 0);
        result = 31 * result + (grdlvl2 != null ? grdlvl2.hashCode() : 0);
        result = 31 * result + (grdlvl3 != null ? grdlvl3.hashCode() : 0);
        result = 31 * result + (grdlvl4 != null ? grdlvl4.hashCode() : 0);
        result = 31 * result + (grdlvl5 != null ? grdlvl5.hashCode() : 0);
        result = 31 * result + (grdlvl6 != null ? grdlvl6.hashCode() : 0);
        result = 31 * result + (grdlvl7 != null ? grdlvl7.hashCode() : 0);
        result = 31 * result + (grdlvl8 != null ? grdlvl8.hashCode() : 0);
        result = 31 * result + (grdlvl9 != null ? grdlvl9.hashCode() : 0);
        result = 31 * result + (grdlvla != null ? grdlvla.hashCode() : 0);
        result = 31 * result + (grdlvlb != null ? grdlvlb.hashCode() : 0);
        result = 31 * result + (grdlvlc != null ? grdlvlc.hashCode() : 0);
        result = 31 * result + (namefl != null ? namefl.hashCode() : 0);
        result = 31 * result + (ssnfat != null ? ssnfat.hashCode() : 0);
        result = 31 * result + (assnfat != null ? assnfat.hashCode() : 0);
        result = 31 * result + (nameml != null ? nameml.hashCode() : 0);
        result = 31 * result + (ssnmot != null ? ssnmot.hashCode() : 0);
        result = 31 * result + (assnmot != null ? assnmot.hashCode() : 0);
        result = 31 * result + aesamt;
        result = 31 * result + cesamt;
        result = 31 * result + (cssncol != null ? cssncol.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
