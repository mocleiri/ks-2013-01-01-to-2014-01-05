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
 * Time: 12:14 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNS", schema = "SIGMA", catalog = "")
@Entity
public class SnsEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnskey();
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

    private String snskey;

    @javax.persistence.Column(name = "SNSKEY")
    @Id
    public String getSnskey() {
        return snskey;
    }

    public void setSnskey(String snskey) {
        this.snskey = snskey;
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

    private String snamei;

    @javax.persistence.Column(name = "SNAMEI")
    @Basic
    public String getSnamei() {
        return snamei;
    }

    public void setSnamei(String snamei) {
        this.snamei = snamei;
    }

    private String saddr;

    @javax.persistence.Column(name = "SADDR")
    @Basic
    public String getSaddr() {
        return saddr;
    }

    public void setSaddr(String saddr) {
        this.saddr = saddr;
    }

    private String sstate;

    @javax.persistence.Column(name = "SSTATE")
    @Basic
    public String getSstate() {
        return sstate;
    }

    public void setSstate(String sstate) {
        this.sstate = sstate;
    }

    private String szip;

    @javax.persistence.Column(name = "SZIP")
    @Basic
    public String getSzip() {
        return szip;
    }

    public void setSzip(String szip) {
        this.szip = szip;
    }

    private String smaritl;

    @javax.persistence.Column(name = "SMARITL")
    @Basic
    public String getSmaritl() {
        return smaritl;
    }

    public void setSmaritl(String smaritl) {
        this.smaritl = smaritl;
    }

    private String stitle;

    @javax.persistence.Column(name = "STITLE")
    @Basic
    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    private String snumdl;

    @javax.persistence.Column(name = "SNUMDL")
    @Basic
    public String getSnumdl() {
        return snumdl;
    }

    public void setSnumdl(String snumdl) {
        this.snumdl = snumdl;
    }

    private String sstdl;

    @javax.persistence.Column(name = "SSTDL")
    @Basic
    public String getSstdl() {
        return sstdl;
    }

    public void setSstdl(String sstdl) {
        this.sstdl = sstdl;
    }

    private String senrsum;

    @javax.persistence.Column(name = "SENRSUM")
    @Basic
    public String getSenrsum() {
        return senrsum;
    }

    public void setSenrsum(String senrsum) {
        this.senrsum = senrsum;
    }

    private String senrfal;

    @javax.persistence.Column(name = "SENRFAL")
    @Basic
    public String getSenrfal() {
        return senrfal;
    }

    public void setSenrfal(String senrfal) {
        this.senrfal = senrfal;
    }

    private String senrwin;

    @javax.persistence.Column(name = "SENRWIN")
    @Basic
    public String getSenrwin() {
        return senrwin;
    }

    public void setSenrwin(String senrwin) {
        this.senrwin = senrwin;
    }

    private String senrspr;

    @javax.persistence.Column(name = "SENRSPR")
    @Basic
    public String getSenrspr() {
        return senrspr;
    }

    public void setSenrspr(String senrspr) {
        this.senrspr = senrspr;
    }

    private BigInteger sage;

    @javax.persistence.Column(name = "SAGE")
    @Basic
    public BigInteger getSage() {
        return sage;
    }

    public void setSage(BigInteger sage) {
        this.sage = sage;
    }

    private BigInteger ssizhhd;

    @javax.persistence.Column(name = "SSIZHHD")
    @Basic
    public BigInteger getSsizhhd() {
        return ssizhhd;
    }

    public void setSsizhhd(BigInteger ssizhhd) {
        this.ssizhhd = ssizhhd;
    }

    private BigInteger sexemp;

    @javax.persistence.Column(name = "SEXEMP")
    @Basic
    public BigInteger getSexemp() {
        return sexemp;
    }

    public void setSexemp(BigInteger sexemp) {
        this.sexemp = sexemp;
    }

    private BigInteger snrps;

    @javax.persistence.Column(name = "SNRPS")
    @Basic
    public BigInteger getSnrps() {
        return snrps;
    }

    public void setSnrps(BigInteger snrps) {
        this.snrps = snrps;
    }

    private String sdiswk;

    @javax.persistence.Column(name = "SDISWK")
    @Basic
    public String getSdiswk() {
        return sdiswk;
    }

    public void setSdiswk(String sdiswk) {
        this.sdiswk = sdiswk;
    }

    private String sdishm;

    @javax.persistence.Column(name = "SDISHM")
    @Basic
    public String getSdishm() {
        return sdishm;
    }

    public void setSdishm(String sdishm) {
        this.sdishm = sdishm;
    }

    private String strfil;

    @javax.persistence.Column(name = "STRFIL")
    @Basic
    public String getStrfil() {
        return strfil;
    }

    public void setStrfil(String strfil) {
        this.strfil = strfil;
    }

    private String sselsrv;

    @javax.persistence.Column(name = "SSELSRV")
    @Basic
    public String getSselsrv() {
        return sselsrv;
    }

    public void setSselsrv(String sselsrv) {
        this.sselsrv = sselsrv;
    }

    private String sselsrvm;

    @javax.persistence.Column(name = "SSELSRVM")
    @Basic
    public String getSselsrvm() {
        return sselsrvm;
    }

    public void setSselsrvm(String sselsrvm) {
        this.sselsrvm = sselsrvm;
    }

    private String sinsflag;

    @javax.persistence.Column(name = "SINSFLAG")
    @Basic
    public String getSinsflag() {
        return sinsflag;
    }

    public void setSinsflag(String sinsflag) {
        this.sinsflag = sinsflag;
    }

    private BigInteger sadage1;

    @javax.persistence.Column(name = "SADAGE1")
    @Basic
    public BigInteger getSadage1() {
        return sadage1;
    }

    public void setSadage1(BigInteger sadage1) {
        this.sadage1 = sadage1;
    }

    private BigInteger sadage2;

    @javax.persistence.Column(name = "SADAGE2")
    @Basic
    public BigInteger getSadage2() {
        return sadage2;
    }

    public void setSadage2(BigInteger sadage2) {
        this.sadage2 = sadage2;
    }

    private BigInteger sadage3;

    @javax.persistence.Column(name = "SADAGE3")
    @Basic
    public BigInteger getSadage3() {
        return sadage3;
    }

    public void setSadage3(BigInteger sadage3) {
        this.sadage3 = sadage3;
    }

    private BigInteger sccaren;

    @javax.persistence.Column(name = "SCCAREN")
    @Basic
    public BigInteger getSccaren() {
        return sccaren;
    }

    public void setSccaren(BigInteger sccaren) {
        this.sccaren = sccaren;
    }

    private String sfarm;

    @javax.persistence.Column(name = "SFARM")
    @Basic
    public String getSfarm() {
        return sfarm;
    }

    public void setSfarm(String sfarm) {
        this.sfarm = sfarm;
    }

    private String sintstf;

    @javax.persistence.Column(name = "SINTSTF")
    @Basic
    public String getSintstf() {
        return sintstf;
    }

    public void setSintstf(String sintstf) {
        this.sintstf = sintstf;
    }

    private String slvlstf;

    @javax.persistence.Column(name = "SLVLSTF")
    @Basic
    public String getSlvlstf() {
        return slvlstf;
    }

    public void setSlvlstf(String slvlstf) {
        this.slvlstf = slvlstf;
    }

    private int stotstf;

    @javax.persistence.Column(name = "STOTSTF")
    @Basic
    public int getStotstf() {
        return stotstf;
    }

    public void setStotstf(int stotstf) {
        this.stotstf = stotstf;
    }

    private int srctstf;

    @javax.persistence.Column(name = "SRCTSTF")
    @Basic
    public int getSrctstf() {
        return srctstf;
    }

    public void setSrctstf(int srctstf) {
        this.srctstf = srctstf;
    }

    private int sagim;

    @javax.persistence.Column(name = "SAGIM")
    @Basic
    public int getSagim() {
        return sagim;
    }

    public void setSagim(int sagim) {
        this.sagim = sagim;
    }

    private int sagia;

    @javax.persistence.Column(name = "SAGIA")
    @Basic
    public int getSagia() {
        return sagia;
    }

    public void setSagia(int sagia) {
        this.sagia = sagia;
    }

    private int sagi;

    @javax.persistence.Column(name = "SAGI")
    @Basic
    public int getSagi() {
        return sagi;
    }

    public void setSagi(int sagi) {
        this.sagi = sagi;
    }

    private int savcm;

    @javax.persistence.Column(name = "SAVCM")
    @Basic
    public int getSavcm() {
        return savcm;
    }

    public void setSavcm(int savcm) {
        this.savcm = savcm;
    }

    private int savca;

    @javax.persistence.Column(name = "SAVCA")
    @Basic
    public int getSavca() {
        return savca;
    }

    public void setSavca(int savca) {
        this.savca = savca;
    }

    private int savc;

    @javax.persistence.Column(name = "SAVC")
    @Basic
    public int getSavc() {
        return savc;
    }

    public void setSavc(int savc) {
        this.savc = savc;
    }

    private int savom;

    @javax.persistence.Column(name = "SAVOM")
    @Basic
    public int getSavom() {
        return savom;
    }

    public void setSavom(int savom) {
        this.savom = savom;
    }

    private int savoa;

    @javax.persistence.Column(name = "SAVOA")
    @Basic
    public int getSavoa() {
        return savoa;
    }

    public void setSavoa(int savoa) {
        this.savoa = savoa;
    }

    private int savo;

    @javax.persistence.Column(name = "SAVO")
    @Basic
    public int getSavo() {
        return savo;
    }

    public void setSavo(int savo) {
        this.savo = savo;
    }

    private int savabu;

    @javax.persistence.Column(name = "SAVABU")
    @Basic
    public int getSavabu() {
        return savabu;
    }

    public void setSavabu(int savabu) {
        this.savabu = savabu;
    }

    private int savabn;

    @javax.persistence.Column(name = "SAVABN")
    @Basic
    public int getSavabn() {
        return savabn;
    }

    public void setSavabn(int savabn) {
        this.savabn = savabn;
    }

    private int savaba;

    @javax.persistence.Column(name = "SAVABA")
    @Basic
    public int getSavaba() {
        return savaba;
    }

    public void setSavaba(int savaba) {
        this.savaba = savaba;
    }

    private int sawag;

    @javax.persistence.Column(name = "SAWAG")
    @Basic
    public int getSawag() {
        return sawag;
    }

    public void setSawag(int sawag) {
        this.sawag = sawag;
    }

    private int saspsw;

    @javax.persistence.Column(name = "SASPSW")
    @Basic
    public int getSaspsw() {
        return saspsw;
    }

    public void setSaspsw(int saspsw) {
        this.saspsw = saspsw;
    }

    private int saadj;

    @javax.persistence.Column(name = "SAADJ")
    @Basic
    public int getSaadj() {
        return saadj;
    }

    public void setSaadj(int saadj) {
        this.saadj = saadj;
    }

    private int saoti;

    @javax.persistence.Column(name = "SAOTI")
    @Basic
    public int getSaoti() {
        return saoti;
    }

    public void setSaoti(int saoti) {
        this.saoti = saoti;
    }

    private int satti;

    @javax.persistence.Column(name = "SATTI")
    @Basic
    public int getSatti() {
        return satti;
    }

    public void setSatti(int satti) {
        this.satti = satti;
    }

    private int saagi;

    @javax.persistence.Column(name = "SAAGI")
    @Basic
    public int getSaagi() {
        return saagi;
    }

    public void setSaagi(int saagi) {
        this.saagi = saagi;
    }

    private int sass;

    @javax.persistence.Column(name = "SASS")
    @Basic
    public int getSass() {
        return sass;
    }

    public void setSass(int sass) {
        this.sass = sass;
    }

    private int saadc;

    @javax.persistence.Column(name = "SAADC")
    @Basic
    public int getSaadc() {
        return saadc;
    }

    public void setSaadc(int saadc) {
        this.saadc = saadc;
    }

    private int sacs;

    @javax.persistence.Column(name = "SACS")
    @Basic
    public int getSacs() {
        return sacs;
    }

    public void setSacs(int sacs) {
        this.sacs = sacs;
    }

    private int saonti;

    @javax.persistence.Column(name = "SAONTI")
    @Basic
    public int getSaonti() {
        return saonti;
    }

    public void setSaonti(int saonti) {
        this.saonti = saonti;
    }

    private int santx1;

    @javax.persistence.Column(name = "SANTX1")
    @Basic
    public int getSantx1() {
        return santx1;
    }

    public void setSantx1(int santx1) {
        this.santx1 = santx1;
    }

    private int santx2;

    @javax.persistence.Column(name = "SANTX2")
    @Basic
    public int getSantx2() {
        return santx2;
    }

    public void setSantx2(int santx2) {
        this.santx2 = santx2;
    }

    private int satnti;

    @javax.persistence.Column(name = "SATNTI")
    @Basic
    public int getSatnti() {
        return satnti;
    }

    public void setSatnti(int satnti) {
        this.satnti = satnti;
    }

    private int satinc;

    @javax.persistence.Column(name = "SATINC")
    @Basic
    public int getSatinc() {
        return satinc;
    }

    public void setSatinc(int satinc) {
        this.satinc = satinc;
    }

    private int saded;

    @javax.persistence.Column(name = "SADED")
    @Basic
    public int getSaded() {
        return saded;
    }

    public void setSaded(int saded) {
        this.saded = saded;
    }

    private int saitx;

    @javax.persistence.Column(name = "SAITX")
    @Basic
    public int getSaitx() {
        return saitx;
    }

    public void setSaitx(int saitx) {
        this.saitx = saitx;
    }

    private int saitxc;

    @javax.persistence.Column(name = "SAITXC")
    @Basic
    public int getSaitxc() {
        return saitxc;
    }

    public void setSaitxc(int saitxc) {
        this.saitxc = saitxc;
    }

    private int saitxu;

    @javax.persistence.Column(name = "SAITXU")
    @Basic
    public int getSaitxu() {
        return saitxu;
    }

    public void setSaitxu(int saitxu) {
        this.saitxu = saitxu;
    }

    private int safica;

    @javax.persistence.Column(name = "SAFICA")
    @Basic
    public int getSafica() {
        return safica;
    }

    public void setSafica(int safica) {
        this.safica = safica;
    }

    private int sasttx;

    @javax.persistence.Column(name = "SASTTX")
    @Basic
    public int getSasttx() {
        return sasttx;
    }

    public void setSasttx(int sasttx) {
        this.sasttx = sasttx;
    }

    private int samed;

    @javax.persistence.Column(name = "SAMED")
    @Basic
    public int getSamed() {
        return samed;
    }

    public void setSamed(int samed) {
        this.samed = samed;
    }

    private int sameda;

    @javax.persistence.Column(name = "SAMEDA")
    @Basic
    public int getSameda() {
        return sameda;
    }

    public void setSameda(int sameda) {
        this.sameda = sameda;
    }

    private int satuit;

    @javax.persistence.Column(name = "SATUIT")
    @Basic
    public int getSatuit() {
        return satuit;
    }

    public void setSatuit(int satuit) {
        this.satuit = satuit;
    }

    private BigInteger satutn;

    @javax.persistence.Column(name = "SATUTN")
    @Basic
    public BigInteger getSatutn() {
        return satutn;
    }

    public void setSatutn(BigInteger satutn) {
        this.satutn = satutn;
    }

    private int satuta;

    @javax.persistence.Column(name = "SATUTA")
    @Basic
    public int getSatuta() {
        return satuta;
    }

    public void setSatuta(int satuta) {
        this.satuta = satuta;
    }

    private int saemal;

    @javax.persistence.Column(name = "SAEMAL")
    @Basic
    public int getSaemal() {
        return saemal;
    }

    public void setSaemal(int saemal) {
        this.saemal = saemal;
    }

    private int sasma;

    @javax.persistence.Column(name = "SASMA")
    @Basic
    public int getSasma() {
        return sasma;
    }

    public void setSasma(int sasma) {
        this.sasma = sasma;
    }

    private int saial1;

    @javax.persistence.Column(name = "SAIAL1")
    @Basic
    public int getSaial1() {
        return saial1;
    }

    public void setSaial1(int saial1) {
        this.saial1 = saial1;
    }

    private int saial2;

    @javax.persistence.Column(name = "SAIAL2")
    @Basic
    public int getSaial2() {
        return saial2;
    }

    public void setSaial2(int saial2) {
        this.saial2 = saial2;
    }

    private int satalo;

    @javax.persistence.Column(name = "SATALO")
    @Basic
    public int getSatalo() {
        return satalo;
    }

    public void setSatalo(int satalo) {
        this.satalo = satalo;
    }

    private int saefinc;

    @javax.persistence.Column(name = "SAEFINC")
    @Basic
    public int getSaefinc() {
        return saefinc;
    }

    public void setSaefinc(int saefinc) {
        this.saefinc = saefinc;
    }

    private int scash;

    @javax.persistence.Column(name = "SCASH")
    @Basic
    public int getScash() {
        return scash;
    }

    public void setScash(int scash) {
        this.scash = scash;
    }

    private int shomv;

    @javax.persistence.Column(name = "SHOMV")
    @Basic
    public int getShomv() {
        return shomv;
    }

    public void setShomv(int shomv) {
        this.shomv = shomv;
    }

    private int shomd;

    @javax.persistence.Column(name = "SHOMD")
    @Basic
    public int getShomd() {
        return shomd;
    }

    public void setShomd(int shomd) {
        this.shomd = shomd;
    }

    private int shome;

    @javax.persistence.Column(name = "SHOME")
    @Basic
    public int getShome() {
        return shome;
    }

    public void setShome(int shome) {
        this.shome = shome;
    }

    private int sfarmv;

    @javax.persistence.Column(name = "SFARMV")
    @Basic
    public int getSfarmv() {
        return sfarmv;
    }

    public void setSfarmv(int sfarmv) {
        this.sfarmv = sfarmv;
    }

    private int sfarmd;

    @javax.persistence.Column(name = "SFARMD")
    @Basic
    public int getSfarmd() {
        return sfarmd;
    }

    public void setSfarmd(int sfarmd) {
        this.sfarmd = sfarmd;
    }

    private int sfarme;

    @javax.persistence.Column(name = "SFARME")
    @Basic
    public int getSfarme() {
        return sfarme;
    }

    public void setSfarme(int sfarme) {
        this.sfarme = sfarme;
    }

    private int soriv;

    @javax.persistence.Column(name = "SORIV")
    @Basic
    public int getSoriv() {
        return soriv;
    }

    public void setSoriv(int soriv) {
        this.soriv = soriv;
    }

    private int sorid;

    @javax.persistence.Column(name = "SORID")
    @Basic
    public int getSorid() {
        return sorid;
    }

    public void setSorid(int sorid) {
        this.sorid = sorid;
    }

    private int sorie;

    @javax.persistence.Column(name = "SORIE")
    @Basic
    public int getSorie() {
        return sorie;
    }

    public void setSorie(int sorie) {
        this.sorie = sorie;
    }

    private int sbfv;

    @javax.persistence.Column(name = "SBFV")
    @Basic
    public int getSbfv() {
        return sbfv;
    }

    public void setSbfv(int sbfv) {
        this.sbfv = sbfv;
    }

    private int sbfd;

    @javax.persistence.Column(name = "SBFD")
    @Basic
    public int getSbfd() {
        return sbfd;
    }

    public void setSbfd(int sbfd) {
        this.sbfd = sbfd;
    }

    private int sbfe;

    @javax.persistence.Column(name = "SBFE")
    @Basic
    public int getSbfe() {
        return sbfe;
    }

    public void setSbfe(int sbfe) {
        this.sbfe = sbfe;
    }

    private int sbfav;

    @javax.persistence.Column(name = "SBFAV")
    @Basic
    public int getSbfav() {
        return sbfav;
    }

    public void setSbfav(int sbfav) {
        this.sbfav = sbfav;
    }

    private int sassadj;

    @javax.persistence.Column(name = "SASSADJ")
    @Basic
    public int getSassadj() {
        return sassadj;
    }

    public void setSassadj(int sassadj) {
        this.sassadj = sassadj;
    }

    private int stass;

    @javax.persistence.Column(name = "STASS")
    @Basic
    public int getStass() {
        return stass;
    }

    public void setStass(int stass) {
        this.stass = stass;
    }

    private int sothd;

    @javax.persistence.Column(name = "SOTHD")
    @Basic
    public int getSothd() {
        return sothd;
    }

    public void setSothd(int sothd) {
        this.sothd = sothd;
    }

    private int snwrth;

    @javax.persistence.Column(name = "SNWRTH")
    @Basic
    public int getSnwrth() {
        return snwrth;
    }

    public void setSnwrth(int snwrth) {
        this.snwrth = snwrth;
    }

    private int sapa;

    @javax.persistence.Column(name = "SAPA")
    @Basic
    public int getSapa() {
        return sapa;
    }

    public void setSapa(int sapa) {
        this.sapa = sapa;
    }

    private int sdnet;

    @javax.persistence.Column(name = "SDNET")
    @Basic
    public int getSdnet() {
        return sdnet;
    }

    public void setSdnet(int sdnet) {
        this.sdnet = sdnet;
    }

    private BigDecimal scacp;

    @javax.persistence.Column(name = "SCACP")
    @Basic
    public BigDecimal getScacp() {
        return scacp;
    }

    public void setScacp(BigDecimal scacp) {
        this.scacp = scacp;
    }

    private int scona;

    @javax.persistence.Column(name = "SCONA")
    @Basic
    public int getScona() {
        return scona;
    }

    public void setScona(int scona) {
        this.scona = scona;
    }

    private int saaavi;

    @javax.persistence.Column(name = "SAAAVI")
    @Basic
    public int getSaaavi() {
        return saaavi;
    }

    public void setSaaavi(int saaavi) {
        this.saaavi = saaavi;
    }

    private int savba;

    @javax.persistence.Column(name = "SAVBA")
    @Basic
    public int getSavba() {
        return savba;
    }

    public void setSavba(int savba) {
        this.savba = savba;
    }

    private int sconft;

    @javax.persistence.Column(name = "SCONFT")
    @Basic
    public int getSconft() {
        return sconft;
    }

    public void setSconft(int sconft) {
        this.sconft = sconft;
    }

    private int sconfn;

    @javax.persistence.Column(name = "SCONFN")
    @Basic
    public int getSconfn() {
        return sconfn;
    }

    public void setSconfn(int sconfn) {
        this.sconfn = sconfn;
    }

    private int sconf;

    @javax.persistence.Column(name = "SCONF")
    @Basic
    public int getSconf() {
        return sconf;
    }

    public void setSconf(int sconf) {
        this.sconf = sconf;
    }

    private int sdwag;

    @javax.persistence.Column(name = "SDWAG")
    @Basic
    public int getSdwag() {
        return sdwag;
    }

    public void setSdwag(int sdwag) {
        this.sdwag = sdwag;
    }

    private int sdspsw;

    @javax.persistence.Column(name = "SDSPSW")
    @Basic
    public int getSdspsw() {
        return sdspsw;
    }

    public void setSdspsw(int sdspsw) {
        this.sdspsw = sdspsw;
    }

    private int sdoti;

    @javax.persistence.Column(name = "SDOTI")
    @Basic
    public int getSdoti() {
        return sdoti;
    }

    public void setSdoti(int sdoti) {
        this.sdoti = sdoti;
    }

    private int sdnti;

    @javax.persistence.Column(name = "SDNTI")
    @Basic
    public int getSdnti() {
        return sdnti;
    }

    public void setSdnti(int sdnti) {
        this.sdnti = sdnti;
    }

    private int sdvabn;

    @javax.persistence.Column(name = "SDVABN")
    @Basic
    public int getSdvabn() {
        return sdvabn;
    }

    public void setSdvabn(int sdvabn) {
        this.sdvabn = sdvabn;
    }

    private int sdtinc;

    @javax.persistence.Column(name = "SDTINC")
    @Basic
    public int getSdtinc() {
        return sdtinc;
    }

    public void setSdtinc(int sdtinc) {
        this.sdtinc = sdtinc;
    }

    private int sbwag;

    @javax.persistence.Column(name = "SBWAG")
    @Basic
    public int getSbwag() {
        return sbwag;
    }

    public void setSbwag(int sbwag) {
        this.sbwag = sbwag;
    }

    private int scwag;

    @javax.persistence.Column(name = "SCWAG")
    @Basic
    public int getScwag() {
        return scwag;
    }

    public void setScwag(int scwag) {
        this.scwag = scwag;
    }

    private int sbspsw;

    @javax.persistence.Column(name = "SBSPSW")
    @Basic
    public int getSbspsw() {
        return sbspsw;
    }

    public void setSbspsw(int sbspsw) {
        this.sbspsw = sbspsw;
    }

    private int scspsw;

    @javax.persistence.Column(name = "SCSPSW")
    @Basic
    public int getScspsw() {
        return scspsw;
    }

    public void setScspsw(int scspsw) {
        this.scspsw = scspsw;
    }

    private int sboti;

    @javax.persistence.Column(name = "SBOTI")
    @Basic
    public int getSboti() {
        return sboti;
    }

    public void setSboti(int sboti) {
        this.sboti = sboti;
    }

    private int scoti;

    @javax.persistence.Column(name = "SCOTI")
    @Basic
    public int getScoti() {
        return scoti;
    }

    public void setScoti(int scoti) {
        this.scoti = scoti;
    }

    private int sbnti;

    @javax.persistence.Column(name = "SBNTI")
    @Basic
    public int getSbnti() {
        return sbnti;
    }

    public void setSbnti(int sbnti) {
        this.sbnti = sbnti;
    }

    private int scnti;

    @javax.persistence.Column(name = "SCNTI")
    @Basic
    public int getScnti() {
        return scnti;
    }

    public void setScnti(int scnti) {
        this.scnti = scnti;
    }

    private int sctinc;

    @javax.persistence.Column(name = "SCTINC")
    @Basic
    public int getSctinc() {
        return sctinc;
    }

    public void setSctinc(int sctinc) {
        this.sctinc = sctinc;
    }

    private int sdded;

    @javax.persistence.Column(name = "SDDED")
    @Basic
    public int getSdded() {
        return sdded;
    }

    public void setSdded(int sdded) {
        this.sdded = sdded;
    }

    private int sditx;

    @javax.persistence.Column(name = "SDITX")
    @Basic
    public int getSditx() {
        return sditx;
    }

    public void setSditx(int sditx) {
        this.sditx = sditx;
    }

    private int sditxc;

    @javax.persistence.Column(name = "SDITXC")
    @Basic
    public int getSditxc() {
        return sditxc;
    }

    public void setSditxc(int sditxc) {
        this.sditxc = sditxc;
    }

    private int sditxu;

    @javax.persistence.Column(name = "SDITXU")
    @Basic
    public int getSditxu() {
        return sditxu;
    }

    public void setSditxu(int sditxu) {
        this.sditxu = sditxu;
    }

    private int sdfica;

    @javax.persistence.Column(name = "SDFICA")
    @Basic
    public int getSdfica() {
        return sdfica;
    }

    public void setSdfica(int sdfica) {
        this.sdfica = sdfica;
    }

    private int sdsttx;

    @javax.persistence.Column(name = "SDSTTX")
    @Basic
    public int getSdsttx() {
        return sdsttx;
    }

    public void setSdsttx(int sdsttx) {
        this.sdsttx = sdsttx;
    }

    private int sdmed;

    @javax.persistence.Column(name = "SDMED")
    @Basic
    public int getSdmed() {
        return sdmed;
    }

    public void setSdmed(int sdmed) {
        this.sdmed = sdmed;
    }

    private int sdmedc;

    @javax.persistence.Column(name = "SDMEDC")
    @Basic
    public int getSdmedc() {
        return sdmedc;
    }

    public void setSdmedc(int sdmedc) {
        this.sdmedc = sdmedc;
    }

    private int sdtuta;

    @javax.persistence.Column(name = "SDTUTA")
    @Basic
    public int getSdtuta() {
        return sdtuta;
    }

    public void setSdtuta(int sdtuta) {
        this.sdtuta = sdtuta;
    }

    private int sdemal;

    @javax.persistence.Column(name = "SDEMAL")
    @Basic
    public int getSdemal() {
        return sdemal;
    }

    public void setSdemal(int sdemal) {
        this.sdemal = sdemal;
    }

    private int sdsma;

    @javax.persistence.Column(name = "SDSMA")
    @Basic
    public int getSdsma() {
        return sdsma;
    }

    public void setSdsma(int sdsma) {
        this.sdsma = sdsma;
    }

    private int sdial1;

    @javax.persistence.Column(name = "SDIAL1")
    @Basic
    public int getSdial1() {
        return sdial1;
    }

    public void setSdial1(int sdial1) {
        this.sdial1 = sdial1;
    }

    private int sdial2;

    @javax.persistence.Column(name = "SDIAL2")
    @Basic
    public int getSdial2() {
        return sdial2;
    }

    public void setSdial2(int sdial2) {
        this.sdial2 = sdial2;
    }

    private int sdtalo;

    @javax.persistence.Column(name = "SDTALO")
    @Basic
    public int getSdtalo() {
        return sdtalo;
    }

    public void setSdtalo(int sdtalo) {
        this.sdtalo = sdtalo;
    }

    private int sdefin;

    @javax.persistence.Column(name = "SDEFIN")
    @Basic
    public int getSdefin() {
        return sdefin;
    }

    public void setSdefin(int sdefin) {
        this.sdefin = sdefin;
    }

    private String scity;

    @javax.persistence.Column(name = "SCITY")
    @Basic
    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    private int sexcld;

    @javax.persistence.Column(name = "SEXCLD")
    @Basic
    public int getSexcld() {
        return sexcld;
    }

    public void setSexcld(int sexcld) {
        this.sexcld = sexcld;
    }

    private String shvcon;

    @javax.persistence.Column(name = "SHVCON")
    @Basic
    public String getShvcon() {
        return shvcon;
    }

    public void setShvcon(String shvcon) {
        this.shvcon = shvcon;
    }

    private int asexcld;

    @javax.persistence.Column(name = "ASEXCLD")
    @Basic
    public int getAsexcld() {
        return asexcld;
    }

    public void setAsexcld(int asexcld) {
        this.asexcld = asexcld;
    }

    private String senrsu2;

    @javax.persistence.Column(name = "SENRSU2")
    @Basic
    public String getSenrsu2() {
        return senrsu2;
    }

    public void setSenrsu2(String senrsu2) {
        this.senrsu2 = senrsu2;
    }

    private int sinccr;

    @javax.persistence.Column(name = "SINCCR")
    @Basic
    public int getSinccr() {
        return sinccr;
    }

    public void setSinccr(int sinccr) {
        this.sinccr = sinccr;
    }

    private int asinccr;

    @javax.persistence.Column(name = "ASINCCR")
    @Basic
    public int getAsinccr() {
        return asinccr;
    }

    public void setAsinccr(int asinccr) {
        this.asinccr = asinccr;
    }

    private int asaonti;

    @javax.persistence.Column(name = "ASAONTI")
    @Basic
    public int getAsaonti() {
        return asaonti;
    }

    public void setAsaonti(int asaonti) {
        this.asaonti = asaonti;
    }

    private String smrtldc;

    @javax.persistence.Column(name = "SMRTLDC")
    @Basic
    public String getSmrtldc() {
        return smrtldc;
    }

    public void setSmrtldc(String smrtldc) {
        this.smrtldc = smrtldc;
    }

    private String shsdtc;

    @javax.persistence.Column(name = "SHSDTC")
    @Basic
    public String getShsdtc() {
        return shsdtc;
    }

    public void setShsdtc(String shsdtc) {
        this.shsdtc = shsdtc;
    }

    private String sgeddtc;

    @javax.persistence.Column(name = "SGEDDTC")
    @Basic
    public String getSgeddtc() {
        return sgeddtc;
    }

    public void setSgeddtc(String sgeddtc) {
        this.sgeddtc = sgeddtc;
    }

    private String sdtstsc;

    @javax.persistence.Column(name = "SDTSTSC")
    @Basic
    public String getSdtstsc() {
        return sdtstsc;
    }

    public void setSdtstsc(String sdtstsc) {
        this.sdtstsc = sdtstsc;
    }

    private String sdtstec;

    @javax.persistence.Column(name = "SDTSTEC")
    @Basic
    public String getSdtstec() {
        return sdtstec;
    }

    public void setSdtstec(String sdtstec) {
        this.sdtstec = sdtstec;
    }

    private String hsgedf;

    @javax.persistence.Column(name = "HSGEDF")
    @Basic
    public String getHsgedf() {
        return hsgedf;
    }

    public void setHsgedf(String hsgedf) {
        this.hsgedf = hsgedf;
    }

    private String hlcnse;

    @javax.persistence.Column(name = "HLCNSE")
    @Basic
    public String getHlcnse() {
        return hlcnse;
    }

    public void setHlcnse(String hlcnse) {
        this.hlcnse = hlcnse;
    }

    private String sresbfr;

    @javax.persistence.Column(name = "SRESBFR")
    @Basic
    public String getSresbfr() {
        return sresbfr;
    }

    public void setSresbfr(String sresbfr) {
        this.sresbfr = sresbfr;
    }

    private String smale;

    @javax.persistence.Column(name = "SMALE")
    @Basic
    public String getSmale() {
        return smale;
    }

    public void setSmale(String smale) {
        this.smale = smale;
    }

    private String sfilrtn;

    @javax.persistence.Column(name = "SFILRTN")
    @Basic
    public String getSfilrtn() {
        return sfilrtn;
    }

    public void setSfilrtn(String sfilrtn) {
        this.sfilrtn = sfilrtn;
    }

    private String selgfil;

    @javax.persistence.Column(name = "SELGFIL")
    @Basic
    public String getSelgfil() {
        return selgfil;
    }

    public void setSelgfil(String selgfil) {
        this.selgfil = selgfil;
    }

    private String sasvast;

    @javax.persistence.Column(name = "SASVAST")
    @Basic
    public String getSasvast() {
        return sasvast;
    }

    public void setSasvast(String sasvast) {
        this.sasvast = sasvast;
    }

    private String p1Verfg;

    @javax.persistence.Column(name = "P1VERFG")
    @Basic
    public String getP1Verfg() {
        return p1Verfg;
    }

    public void setP1Verfg(String p1Verfg) {
        this.p1Verfg = p1Verfg;
    }

    private int p1Nefc;

    @javax.persistence.Column(name = "P1NEFC")
    @Basic
    public int getP1Nefc() {
        return p1Nefc;
    }

    public void setP1Nefc(int p1Nefc) {
        this.p1Nefc = p1Nefc;
    }

    private String p2Verfg;

    @javax.persistence.Column(name = "P2VERFG")
    @Basic
    public String getP2Verfg() {
        return p2Verfg;
    }

    public void setP2Verfg(String p2Verfg) {
        this.p2Verfg = p2Verfg;
    }

    private int p2Nefc;

    @javax.persistence.Column(name = "P2NEFC")
    @Basic
    public int getP2Nefc() {
        return p2Nefc;
    }

    public void setP2Nefc(int p2Nefc) {
        this.p2Nefc = p2Nefc;
    }

    private String seqnum3;

    @javax.persistence.Column(name = "SEQNUM3")
    @Basic
    public String getSeqnum3() {
        return seqnum3;
    }

    public void setSeqnum3(String seqnum3) {
        this.seqnum3 = seqnum3;
    }

    private String p3Verfg;

    @javax.persistence.Column(name = "P3VERFG")
    @Basic
    public String getP3Verfg() {
        return p3Verfg;
    }

    public void setP3Verfg(String p3Verfg) {
        this.p3Verfg = p3Verfg;
    }

    private int p3Nefc;

    @javax.persistence.Column(name = "P3NEFC")
    @Basic
    public int getP3Nefc() {
        return p3Nefc;
    }

    public void setP3Nefc(int p3Nefc) {
        this.p3Nefc = p3Nefc;
    }

    private int schcod3;

    @javax.persistence.Column(name = "SCHCOD3")
    @Basic
    public int getSchcod3() {
        return schcod3;
    }

    public void setSchcod3(int schcod3) {
        this.schcod3 = schcod3;
    }

    private BigInteger tranum3;

    @javax.persistence.Column(name = "TRANUM3")
    @Basic
    public BigInteger getTranum3() {
        return tranum3;
    }

    public void setTranum3(BigInteger tranum3) {
        this.tranum3 = tranum3;
    }

    private String lstudt3C;

    @javax.persistence.Column(name = "LSTUDT3C")
    @Basic
    public String getLstudt3C() {
        return lstudt3C;
    }

    public void setLstudt3C(String lstudt3C) {
        this.lstudt3C = lstudt3C;
    }

    private int schamt3;

    @javax.persistence.Column(name = "SCHAMT3")
    @Basic
    public int getSchamt3() {
        return schamt3;
    }

    public void setSchamt3(int schamt3) {
        this.schamt3 = schamt3;
    }

    private int amtptdt3;

    @javax.persistence.Column(name = "AMTPTDT3")
    @Basic
    public int getAmtptdt3() {
        return amtptdt3;
    }

    public void setAmtptdt3(int amtptdt3) {
        this.amtptdt3 = amtptdt3;
    }

    private int rmamtpy3;

    @javax.persistence.Column(name = "RMAMTPY3")
    @Basic
    public int getRmamtpy3() {
        return rmamtpy3;
    }

    public void setRmamtpy3(int rmamtpy3) {
        this.rmamtpy3 = rmamtpy3;
    }

    private int prcntus3;

    @javax.persistence.Column(name = "PRCNTUS3")
    @Basic
    public int getPrcntus3() {
        return prcntus3;
    }

    public void setPrcntus3(int prcntus3) {
        this.prcntus3 = prcntus3;
    }

    private String primth;

    @javax.persistence.Column(name = "PRIMTH")
    @Basic
    public String getPrimth() {
        return primth;
    }

    public void setPrimth(String primth) {
        this.primth = primth;
    }

    private int pawat1;

    @javax.persistence.Column(name = "PAWAT1")
    @Basic
    public int getPawat1() {
        return pawat1;
    }

    public void setPawat1(int pawat1) {
        this.pawat1 = pawat1;
    }

    private int pawat2;

    @javax.persistence.Column(name = "PAWAT2")
    @Basic
    public int getPawat2() {
        return pawat2;
    }

    public void setPawat2(int pawat2) {
        this.pawat2 = pawat2;
    }

    private int pawat3;

    @javax.persistence.Column(name = "PAWAT3")
    @Basic
    public int getPawat3() {
        return pawat3;
    }

    public void setPawat3(int pawat3) {
        this.pawat3 = pawat3;
    }

    private String psread;

    @javax.persistence.Column(name = "PSREAD")
    @Basic
    public String getPsread() {
        return psread;
    }

    public void setPsread(String psread) {
        this.psread = psread;
    }

    private String drugcn;

    @javax.persistence.Column(name = "DRUGCN")
    @Basic
    public String getDrugcn() {
        return drugcn;
    }

    public void setDrugcn(String drugcn) {
        this.drugcn = drugcn;
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

        SnsEntity snsEntity = (SnsEntity) o;

        if (amtptdt3 != snsEntity.amtptdt3) return false;
        if (asaonti != snsEntity.asaonti) return false;
        if (asexcld != snsEntity.asexcld) return false;
        if (asinccr != snsEntity.asinccr) return false;
        if (p1Nefc != snsEntity.p1Nefc) return false;
        if (p2Nefc != snsEntity.p2Nefc) return false;
        if (p3Nefc != snsEntity.p3Nefc) return false;
        if (pawat1 != snsEntity.pawat1) return false;
        if (pawat2 != snsEntity.pawat2) return false;
        if (pawat3 != snsEntity.pawat3) return false;
        if (prcntus3 != snsEntity.prcntus3) return false;
        if (revlev != snsEntity.revlev) return false;
        if (rmamtpy3 != snsEntity.rmamtpy3) return false;
        if (saaavi != snsEntity.saaavi) return false;
        if (saadc != snsEntity.saadc) return false;
        if (saadj != snsEntity.saadj) return false;
        if (saagi != snsEntity.saagi) return false;
        if (sacs != snsEntity.sacs) return false;
        if (saded != snsEntity.saded) return false;
        if (saefinc != snsEntity.saefinc) return false;
        if (saemal != snsEntity.saemal) return false;
        if (safica != snsEntity.safica) return false;
        if (sagi != snsEntity.sagi) return false;
        if (sagia != snsEntity.sagia) return false;
        if (sagim != snsEntity.sagim) return false;
        if (saial1 != snsEntity.saial1) return false;
        if (saial2 != snsEntity.saial2) return false;
        if (saitx != snsEntity.saitx) return false;
        if (saitxc != snsEntity.saitxc) return false;
        if (saitxu != snsEntity.saitxu) return false;
        if (samed != snsEntity.samed) return false;
        if (sameda != snsEntity.sameda) return false;
        if (santx1 != snsEntity.santx1) return false;
        if (santx2 != snsEntity.santx2) return false;
        if (saonti != snsEntity.saonti) return false;
        if (saoti != snsEntity.saoti) return false;
        if (sapa != snsEntity.sapa) return false;
        if (sasma != snsEntity.sasma) return false;
        if (saspsw != snsEntity.saspsw) return false;
        if (sass != snsEntity.sass) return false;
        if (sassadj != snsEntity.sassadj) return false;
        if (sasttx != snsEntity.sasttx) return false;
        if (satalo != snsEntity.satalo) return false;
        if (satinc != snsEntity.satinc) return false;
        if (satnti != snsEntity.satnti) return false;
        if (satti != snsEntity.satti) return false;
        if (satuit != snsEntity.satuit) return false;
        if (satuta != snsEntity.satuta) return false;
        if (savaba != snsEntity.savaba) return false;
        if (savabn != snsEntity.savabn) return false;
        if (savabu != snsEntity.savabu) return false;
        if (savba != snsEntity.savba) return false;
        if (savc != snsEntity.savc) return false;
        if (savca != snsEntity.savca) return false;
        if (savcm != snsEntity.savcm) return false;
        if (savo != snsEntity.savo) return false;
        if (savoa != snsEntity.savoa) return false;
        if (savom != snsEntity.savom) return false;
        if (sawag != snsEntity.sawag) return false;
        if (sbfav != snsEntity.sbfav) return false;
        if (sbfd != snsEntity.sbfd) return false;
        if (sbfe != snsEntity.sbfe) return false;
        if (sbfv != snsEntity.sbfv) return false;
        if (sbnti != snsEntity.sbnti) return false;
        if (sboti != snsEntity.sboti) return false;
        if (sbspsw != snsEntity.sbspsw) return false;
        if (sbwag != snsEntity.sbwag) return false;
        if (scash != snsEntity.scash) return false;
        if (schamt3 != snsEntity.schamt3) return false;
        if (schcod3 != snsEntity.schcod3) return false;
        if (scnti != snsEntity.scnti) return false;
        if (scona != snsEntity.scona) return false;
        if (sconf != snsEntity.sconf) return false;
        if (sconfn != snsEntity.sconfn) return false;
        if (sconft != snsEntity.sconft) return false;
        if (scoti != snsEntity.scoti) return false;
        if (scspsw != snsEntity.scspsw) return false;
        if (sctinc != snsEntity.sctinc) return false;
        if (scwag != snsEntity.scwag) return false;
        if (sdded != snsEntity.sdded) return false;
        if (sdefin != snsEntity.sdefin) return false;
        if (sdemal != snsEntity.sdemal) return false;
        if (sdfica != snsEntity.sdfica) return false;
        if (sdial1 != snsEntity.sdial1) return false;
        if (sdial2 != snsEntity.sdial2) return false;
        if (sditx != snsEntity.sditx) return false;
        if (sditxc != snsEntity.sditxc) return false;
        if (sditxu != snsEntity.sditxu) return false;
        if (sdmed != snsEntity.sdmed) return false;
        if (sdmedc != snsEntity.sdmedc) return false;
        if (sdnet != snsEntity.sdnet) return false;
        if (sdnti != snsEntity.sdnti) return false;
        if (sdoti != snsEntity.sdoti) return false;
        if (sdsma != snsEntity.sdsma) return false;
        if (sdspsw != snsEntity.sdspsw) return false;
        if (sdsttx != snsEntity.sdsttx) return false;
        if (sdtalo != snsEntity.sdtalo) return false;
        if (sdtinc != snsEntity.sdtinc) return false;
        if (sdtuta != snsEntity.sdtuta) return false;
        if (sdvabn != snsEntity.sdvabn) return false;
        if (sdwag != snsEntity.sdwag) return false;
        if (sexcld != snsEntity.sexcld) return false;
        if (sfarmd != snsEntity.sfarmd) return false;
        if (sfarme != snsEntity.sfarme) return false;
        if (sfarmv != snsEntity.sfarmv) return false;
        if (shomd != snsEntity.shomd) return false;
        if (shome != snsEntity.shome) return false;
        if (shomv != snsEntity.shomv) return false;
        if (sinccr != snsEntity.sinccr) return false;
        if (snwrth != snsEntity.snwrth) return false;
        if (sorid != snsEntity.sorid) return false;
        if (sorie != snsEntity.sorie) return false;
        if (soriv != snsEntity.soriv) return false;
        if (sothd != snsEntity.sothd) return false;
        if (srctstf != snsEntity.srctstf) return false;
        if (stass != snsEntity.stass) return false;
        if (stotstf != snsEntity.stotstf) return false;
        if (aidyr != null ? !aidyr.equals(snsEntity.aidyr) : snsEntity.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(snsEntity.cmptype) : snsEntity.cmptype != null) return false;
        if (createc != null ? !createc.equals(snsEntity.createc) : snsEntity.createc != null) return false;
        if (crttime != null ? !crttime.equals(snsEntity.crttime) : snsEntity.crttime != null) return false;
        if (drugcn != null ? !drugcn.equals(snsEntity.drugcn) : snsEntity.drugcn != null) return false;
        if (hlcnse != null ? !hlcnse.equals(snsEntity.hlcnse) : snsEntity.hlcnse != null) return false;
        if (hsgedf != null ? !hsgedf.equals(snsEntity.hsgedf) : snsEntity.hsgedf != null) return false;
        if (initals != null ? !initals.equals(snsEntity.initals) : snsEntity.initals != null) return false;
        if (instid != null ? !instid.equals(snsEntity.instid) : snsEntity.instid != null) return false;
        if (lstudt3C != null ? !lstudt3C.equals(snsEntity.lstudt3C) : snsEntity.lstudt3C != null) return false;
        if (module != null ? !module.equals(snsEntity.module) : snsEntity.module != null) return false;
        if (p1Verfg != null ? !p1Verfg.equals(snsEntity.p1Verfg) : snsEntity.p1Verfg != null) return false;
        if (p2Verfg != null ? !p2Verfg.equals(snsEntity.p2Verfg) : snsEntity.p2Verfg != null) return false;
        if (p3Verfg != null ? !p3Verfg.equals(snsEntity.p3Verfg) : snsEntity.p3Verfg != null) return false;
        if (primth != null ? !primth.equals(snsEntity.primth) : snsEntity.primth != null) return false;
        if (psread != null ? !psread.equals(snsEntity.psread) : snsEntity.psread != null) return false;
        if (recstat != null ? !recstat.equals(snsEntity.recstat) : snsEntity.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(snsEntity.revdtc) : snsEntity.revdtc != null) return false;
        if (revtime != null ? !revtime.equals(snsEntity.revtime) : snsEntity.revtime != null) return false;
        if (sadage1 != null ? !sadage1.equals(snsEntity.sadage1) : snsEntity.sadage1 != null) return false;
        if (sadage2 != null ? !sadage2.equals(snsEntity.sadage2) : snsEntity.sadage2 != null) return false;
        if (sadage3 != null ? !sadage3.equals(snsEntity.sadage3) : snsEntity.sadage3 != null) return false;
        if (saddr != null ? !saddr.equals(snsEntity.saddr) : snsEntity.saddr != null) return false;
        if (sage != null ? !sage.equals(snsEntity.sage) : snsEntity.sage != null) return false;
        if (sasvast != null ? !sasvast.equals(snsEntity.sasvast) : snsEntity.sasvast != null) return false;
        if (satutn != null ? !satutn.equals(snsEntity.satutn) : snsEntity.satutn != null) return false;
        if (scacp != null ? !scacp.equals(snsEntity.scacp) : snsEntity.scacp != null) return false;
        if (sccaren != null ? !sccaren.equals(snsEntity.sccaren) : snsEntity.sccaren != null) return false;
        if (scity != null ? !scity.equals(snsEntity.scity) : snsEntity.scity != null) return false;
        if (sdishm != null ? !sdishm.equals(snsEntity.sdishm) : snsEntity.sdishm != null) return false;
        if (sdiswk != null ? !sdiswk.equals(snsEntity.sdiswk) : snsEntity.sdiswk != null) return false;
        if (sdtstec != null ? !sdtstec.equals(snsEntity.sdtstec) : snsEntity.sdtstec != null) return false;
        if (sdtstsc != null ? !sdtstsc.equals(snsEntity.sdtstsc) : snsEntity.sdtstsc != null) return false;
        if (selgfil != null ? !selgfil.equals(snsEntity.selgfil) : snsEntity.selgfil != null) return false;
        if (senrfal != null ? !senrfal.equals(snsEntity.senrfal) : snsEntity.senrfal != null) return false;
        if (senrspr != null ? !senrspr.equals(snsEntity.senrspr) : snsEntity.senrspr != null) return false;
        if (senrsu2 != null ? !senrsu2.equals(snsEntity.senrsu2) : snsEntity.senrsu2 != null) return false;
        if (senrsum != null ? !senrsum.equals(snsEntity.senrsum) : snsEntity.senrsum != null) return false;
        if (senrwin != null ? !senrwin.equals(snsEntity.senrwin) : snsEntity.senrwin != null) return false;
        if (seqnum3 != null ? !seqnum3.equals(snsEntity.seqnum3) : snsEntity.seqnum3 != null) return false;
        if (sexemp != null ? !sexemp.equals(snsEntity.sexemp) : snsEntity.sexemp != null) return false;
        if (sfarm != null ? !sfarm.equals(snsEntity.sfarm) : snsEntity.sfarm != null) return false;
        if (sfilrtn != null ? !sfilrtn.equals(snsEntity.sfilrtn) : snsEntity.sfilrtn != null) return false;
        if (sgeddtc != null ? !sgeddtc.equals(snsEntity.sgeddtc) : snsEntity.sgeddtc != null) return false;
        if (shsdtc != null ? !shsdtc.equals(snsEntity.shsdtc) : snsEntity.shsdtc != null) return false;
        if (shvcon != null ? !shvcon.equals(snsEntity.shvcon) : snsEntity.shvcon != null) return false;
        if (sid != null ? !sid.equals(snsEntity.sid) : snsEntity.sid != null) return false;
        if (sinsflag != null ? !sinsflag.equals(snsEntity.sinsflag) : snsEntity.sinsflag != null) return false;
        if (sintstf != null ? !sintstf.equals(snsEntity.sintstf) : snsEntity.sintstf != null) return false;
        if (slvlstf != null ? !slvlstf.equals(snsEntity.slvlstf) : snsEntity.slvlstf != null) return false;
        if (smale != null ? !smale.equals(snsEntity.smale) : snsEntity.smale != null) return false;
        if (smaritl != null ? !smaritl.equals(snsEntity.smaritl) : snsEntity.smaritl != null) return false;
        if (smrtldc != null ? !smrtldc.equals(snsEntity.smrtldc) : snsEntity.smrtldc != null) return false;
        if (snamef != null ? !snamef.equals(snsEntity.snamef) : snsEntity.snamef != null) return false;
        if (snamei != null ? !snamei.equals(snsEntity.snamei) : snsEntity.snamei != null) return false;
        if (snamel != null ? !snamel.equals(snsEntity.snamel) : snsEntity.snamel != null) return false;
        if (snrps != null ? !snrps.equals(snsEntity.snrps) : snsEntity.snrps != null) return false;
        if (snskey != null ? !snskey.equals(snsEntity.snskey) : snsEntity.snskey != null) return false;
        if (snumdl != null ? !snumdl.equals(snsEntity.snumdl) : snsEntity.snumdl != null) return false;
        if (sresbfr != null ? !sresbfr.equals(snsEntity.sresbfr) : snsEntity.sresbfr != null) return false;
        if (sselsrv != null ? !sselsrv.equals(snsEntity.sselsrv) : snsEntity.sselsrv != null) return false;
        if (sselsrvm != null ? !sselsrvm.equals(snsEntity.sselsrvm) : snsEntity.sselsrvm != null) return false;
        if (ssizhhd != null ? !ssizhhd.equals(snsEntity.ssizhhd) : snsEntity.ssizhhd != null) return false;
        if (sstate != null ? !sstate.equals(snsEntity.sstate) : snsEntity.sstate != null) return false;
        if (sstdl != null ? !sstdl.equals(snsEntity.sstdl) : snsEntity.sstdl != null) return false;
        if (stitle != null ? !stitle.equals(snsEntity.stitle) : snsEntity.stitle != null) return false;
        if (strfil != null ? !strfil.equals(snsEntity.strfil) : snsEntity.strfil != null) return false;
        if (szip != null ? !szip.equals(snsEntity.szip) : snsEntity.szip != null) return false;
        if (tranum3 != null ? !tranum3.equals(snsEntity.tranum3) : snsEntity.tranum3 != null) return false;
        if (ucode != null ? !ucode.equals(snsEntity.ucode) : snsEntity.ucode != null) return false;
        if (versnr != null ? !versnr.equals(snsEntity.versnr) : snsEntity.versnr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snskey != null ? snskey.hashCode() : 0);
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
        result = 31 * result + (snamel != null ? snamel.hashCode() : 0);
        result = 31 * result + (snamef != null ? snamef.hashCode() : 0);
        result = 31 * result + (snamei != null ? snamei.hashCode() : 0);
        result = 31 * result + (saddr != null ? saddr.hashCode() : 0);
        result = 31 * result + (sstate != null ? sstate.hashCode() : 0);
        result = 31 * result + (szip != null ? szip.hashCode() : 0);
        result = 31 * result + (smaritl != null ? smaritl.hashCode() : 0);
        result = 31 * result + (stitle != null ? stitle.hashCode() : 0);
        result = 31 * result + (snumdl != null ? snumdl.hashCode() : 0);
        result = 31 * result + (sstdl != null ? sstdl.hashCode() : 0);
        result = 31 * result + (senrsum != null ? senrsum.hashCode() : 0);
        result = 31 * result + (senrfal != null ? senrfal.hashCode() : 0);
        result = 31 * result + (senrwin != null ? senrwin.hashCode() : 0);
        result = 31 * result + (senrspr != null ? senrspr.hashCode() : 0);
        result = 31 * result + (sage != null ? sage.hashCode() : 0);
        result = 31 * result + (ssizhhd != null ? ssizhhd.hashCode() : 0);
        result = 31 * result + (sexemp != null ? sexemp.hashCode() : 0);
        result = 31 * result + (snrps != null ? snrps.hashCode() : 0);
        result = 31 * result + (sdiswk != null ? sdiswk.hashCode() : 0);
        result = 31 * result + (sdishm != null ? sdishm.hashCode() : 0);
        result = 31 * result + (strfil != null ? strfil.hashCode() : 0);
        result = 31 * result + (sselsrv != null ? sselsrv.hashCode() : 0);
        result = 31 * result + (sselsrvm != null ? sselsrvm.hashCode() : 0);
        result = 31 * result + (sinsflag != null ? sinsflag.hashCode() : 0);
        result = 31 * result + (sadage1 != null ? sadage1.hashCode() : 0);
        result = 31 * result + (sadage2 != null ? sadage2.hashCode() : 0);
        result = 31 * result + (sadage3 != null ? sadage3.hashCode() : 0);
        result = 31 * result + (sccaren != null ? sccaren.hashCode() : 0);
        result = 31 * result + (sfarm != null ? sfarm.hashCode() : 0);
        result = 31 * result + (sintstf != null ? sintstf.hashCode() : 0);
        result = 31 * result + (slvlstf != null ? slvlstf.hashCode() : 0);
        result = 31 * result + stotstf;
        result = 31 * result + srctstf;
        result = 31 * result + sagim;
        result = 31 * result + sagia;
        result = 31 * result + sagi;
        result = 31 * result + savcm;
        result = 31 * result + savca;
        result = 31 * result + savc;
        result = 31 * result + savom;
        result = 31 * result + savoa;
        result = 31 * result + savo;
        result = 31 * result + savabu;
        result = 31 * result + savabn;
        result = 31 * result + savaba;
        result = 31 * result + sawag;
        result = 31 * result + saspsw;
        result = 31 * result + saadj;
        result = 31 * result + saoti;
        result = 31 * result + satti;
        result = 31 * result + saagi;
        result = 31 * result + sass;
        result = 31 * result + saadc;
        result = 31 * result + sacs;
        result = 31 * result + saonti;
        result = 31 * result + santx1;
        result = 31 * result + santx2;
        result = 31 * result + satnti;
        result = 31 * result + satinc;
        result = 31 * result + saded;
        result = 31 * result + saitx;
        result = 31 * result + saitxc;
        result = 31 * result + saitxu;
        result = 31 * result + safica;
        result = 31 * result + sasttx;
        result = 31 * result + samed;
        result = 31 * result + sameda;
        result = 31 * result + satuit;
        result = 31 * result + (satutn != null ? satutn.hashCode() : 0);
        result = 31 * result + satuta;
        result = 31 * result + saemal;
        result = 31 * result + sasma;
        result = 31 * result + saial1;
        result = 31 * result + saial2;
        result = 31 * result + satalo;
        result = 31 * result + saefinc;
        result = 31 * result + scash;
        result = 31 * result + shomv;
        result = 31 * result + shomd;
        result = 31 * result + shome;
        result = 31 * result + sfarmv;
        result = 31 * result + sfarmd;
        result = 31 * result + sfarme;
        result = 31 * result + soriv;
        result = 31 * result + sorid;
        result = 31 * result + sorie;
        result = 31 * result + sbfv;
        result = 31 * result + sbfd;
        result = 31 * result + sbfe;
        result = 31 * result + sbfav;
        result = 31 * result + sassadj;
        result = 31 * result + stass;
        result = 31 * result + sothd;
        result = 31 * result + snwrth;
        result = 31 * result + sapa;
        result = 31 * result + sdnet;
        result = 31 * result + (scacp != null ? scacp.hashCode() : 0);
        result = 31 * result + scona;
        result = 31 * result + saaavi;
        result = 31 * result + savba;
        result = 31 * result + sconft;
        result = 31 * result + sconfn;
        result = 31 * result + sconf;
        result = 31 * result + sdwag;
        result = 31 * result + sdspsw;
        result = 31 * result + sdoti;
        result = 31 * result + sdnti;
        result = 31 * result + sdvabn;
        result = 31 * result + sdtinc;
        result = 31 * result + sbwag;
        result = 31 * result + scwag;
        result = 31 * result + sbspsw;
        result = 31 * result + scspsw;
        result = 31 * result + sboti;
        result = 31 * result + scoti;
        result = 31 * result + sbnti;
        result = 31 * result + scnti;
        result = 31 * result + sctinc;
        result = 31 * result + sdded;
        result = 31 * result + sditx;
        result = 31 * result + sditxc;
        result = 31 * result + sditxu;
        result = 31 * result + sdfica;
        result = 31 * result + sdsttx;
        result = 31 * result + sdmed;
        result = 31 * result + sdmedc;
        result = 31 * result + sdtuta;
        result = 31 * result + sdemal;
        result = 31 * result + sdsma;
        result = 31 * result + sdial1;
        result = 31 * result + sdial2;
        result = 31 * result + sdtalo;
        result = 31 * result + sdefin;
        result = 31 * result + (scity != null ? scity.hashCode() : 0);
        result = 31 * result + sexcld;
        result = 31 * result + (shvcon != null ? shvcon.hashCode() : 0);
        result = 31 * result + asexcld;
        result = 31 * result + (senrsu2 != null ? senrsu2.hashCode() : 0);
        result = 31 * result + sinccr;
        result = 31 * result + asinccr;
        result = 31 * result + asaonti;
        result = 31 * result + (smrtldc != null ? smrtldc.hashCode() : 0);
        result = 31 * result + (shsdtc != null ? shsdtc.hashCode() : 0);
        result = 31 * result + (sgeddtc != null ? sgeddtc.hashCode() : 0);
        result = 31 * result + (sdtstsc != null ? sdtstsc.hashCode() : 0);
        result = 31 * result + (sdtstec != null ? sdtstec.hashCode() : 0);
        result = 31 * result + (hsgedf != null ? hsgedf.hashCode() : 0);
        result = 31 * result + (hlcnse != null ? hlcnse.hashCode() : 0);
        result = 31 * result + (sresbfr != null ? sresbfr.hashCode() : 0);
        result = 31 * result + (smale != null ? smale.hashCode() : 0);
        result = 31 * result + (sfilrtn != null ? sfilrtn.hashCode() : 0);
        result = 31 * result + (selgfil != null ? selgfil.hashCode() : 0);
        result = 31 * result + (sasvast != null ? sasvast.hashCode() : 0);
        result = 31 * result + (p1Verfg != null ? p1Verfg.hashCode() : 0);
        result = 31 * result + p1Nefc;
        result = 31 * result + (p2Verfg != null ? p2Verfg.hashCode() : 0);
        result = 31 * result + p2Nefc;
        result = 31 * result + (seqnum3 != null ? seqnum3.hashCode() : 0);
        result = 31 * result + (p3Verfg != null ? p3Verfg.hashCode() : 0);
        result = 31 * result + p3Nefc;
        result = 31 * result + schcod3;
        result = 31 * result + (tranum3 != null ? tranum3.hashCode() : 0);
        result = 31 * result + (lstudt3C != null ? lstudt3C.hashCode() : 0);
        result = 31 * result + schamt3;
        result = 31 * result + amtptdt3;
        result = 31 * result + rmamtpy3;
        result = 31 * result + prcntus3;
        result = 31 * result + (primth != null ? primth.hashCode() : 0);
        result = 31 * result + pawat1;
        result = 31 * result + pawat2;
        result = 31 * result + pawat3;
        result = 31 * result + (psread != null ? psread.hashCode() : 0);
        result = 31 * result + (drugcn != null ? drugcn.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
