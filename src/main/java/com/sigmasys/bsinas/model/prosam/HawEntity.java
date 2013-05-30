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
 * Date: 11/25/12
 * Time: 11:59 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "HAW", schema = "SIGMA", catalog = "")
@Entity
public class HawEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getHawkey();
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

    private String hawkey;

    @javax.persistence.Column(name = "HAWKEY")
    @Id
    public String getHawkey() {
        return hawkey;
    }

    public void setHawkey(String hawkey) {
        this.hawkey = hawkey;
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

    private String aidid;

    @javax.persistence.Column(name = "AIDID")
    @Basic
    public String getAidid() {
        return aidid;
    }

    public void setAidid(String aidid) {
        this.aidid = aidid;
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

    private String actnr;

    @javax.persistence.Column(name = "ACTNR")
    @Basic
    public String getActnr() {
        return actnr;
    }

    public void setActnr(String actnr) {
        this.actnr = actnr;
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

    private String loannr;

    @javax.persistence.Column(name = "LOANNR")
    @Basic
    public String getLoannr() {
        return loannr;
    }

    public void setLoannr(String loannr) {
        this.loannr = loannr;
    }

    private String pgmname;

    @javax.persistence.Column(name = "PGMNAME")
    @Basic
    public String getPgmname() {
        return pgmname;
    }

    public void setPgmname(String pgmname) {
        this.pgmname = pgmname;
    }

    private String admresp;

    @javax.persistence.Column(name = "ADMRESP")
    @Basic
    public String getAdmresp() {
        return admresp;
    }

    public void setAdmresp(String admresp) {
        this.admresp = admresp;
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

    private String typetrm;

    @javax.persistence.Column(name = "TYPETRM")
    @Basic
    public String getTypetrm() {
        return typetrm;
    }

    public void setTypetrm(String typetrm) {
        this.typetrm = typetrm;
    }

    private String taxcode;

    @javax.persistence.Column(name = "TAXCODE")
    @Basic
    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
    }

    private BigDecimal cfte;

    @javax.persistence.Column(name = "CFTE")
    @Basic
    public BigDecimal getCfte() {
        return cfte;
    }

    public void setCfte(BigDecimal cfte) {
        this.cfte = cfte;
    }

    private BigDecimal allyrs;

    @javax.persistence.Column(name = "ALLYRS")
    @Basic
    public BigDecimal getAllyrs() {
        return allyrs;
    }

    public void setAllyrs(BigDecimal allyrs) {
        this.allyrs = allyrs;
    }

    private BigDecimal allterm;

    @javax.persistence.Column(name = "ALLTERM")
    @Basic
    public BigDecimal getAllterm() {
        return allterm;
    }

    public void setAllterm(BigDecimal allterm) {
        this.allterm = allterm;
    }

    private String acdlvl;

    @javax.persistence.Column(name = "ACDLVL")
    @Basic
    public String getAcdlvl() {
        return acdlvl;
    }

    public void setAcdlvl(String acdlvl) {
        this.acdlvl = acdlvl;
    }

    private String depstat;

    @javax.persistence.Column(name = "DEPSTAT")
    @Basic
    public String getDepstat() {
        return depstat;
    }

    public void setDepstat(String depstat) {
        this.depstat = depstat;
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

    private String sitime;

    @javax.persistence.Column(name = "SITIME")
    @Basic
    public String getSitime() {
        return sitime;
    }

    public void setSitime(String sitime) {
        this.sitime = sitime;
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

    private String caidyrz;

    @javax.persistence.Column(name = "CAIDYRZ")
    @Basic
    public String getCaidyrz() {
        return caidyrz;
    }

    public void setCaidyrz(String caidyrz) {
        this.caidyrz = caidyrz;
    }

    private String caidyr;

    @javax.persistence.Column(name = "CAIDYR")
    @Basic
    public String getCaidyr() {
        return caidyr;
    }

    public void setCaidyr(String caidyr) {
        this.caidyr = caidyr;
    }

    private String revdtez;

    @javax.persistence.Column(name = "REVDTEZ")
    @Basic
    public String getRevdtez() {
        return revdtez;
    }

    public void setRevdtez(String revdtez) {
        this.revdtez = revdtez;
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

    private String chrtact;

    @javax.persistence.Column(name = "CHRTACT")
    @Basic
    public String getChrtact() {
        return chrtact;
    }

    public void setChrtact(String chrtact) {
        this.chrtact = chrtact;
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

    private BigDecimal cawdamt;

    @javax.persistence.Column(name = "CAWDAMT")
    @Basic
    public BigDecimal getCawdamt() {
        return cawdamt;
    }

    public void setCawdamt(BigDecimal cawdamt) {
        this.cawdamt = cawdamt;
    }

    private BigDecimal cawdsch;

    @javax.persistence.Column(name = "CAWDSCH")
    @Basic
    public BigDecimal getCawdsch() {
        return cawdsch;
    }

    public void setCawdsch(BigDecimal cawdsch) {
        this.cawdsch = cawdsch;
    }

    private BigDecimal cawdpay;

    @javax.persistence.Column(name = "CAWDPAY")
    @Basic
    public BigDecimal getCawdpay() {
        return cawdpay;
    }

    public void setCawdpay(BigDecimal cawdpay) {
        this.cawdpay = cawdpay;
    }

    private BigDecimal allawd;

    @javax.persistence.Column(name = "ALLAWD")
    @Basic
    public BigDecimal getAllawd() {
        return allawd;
    }

    public void setAllawd(BigDecimal allawd) {
        this.allawd = allawd;
    }

    private BigDecimal allpay;

    @javax.persistence.Column(name = "ALLPAY")
    @Basic
    public BigDecimal getAllpay() {
        return allpay;
    }

    public void setAllpay(BigDecimal allpay) {
        this.allpay = allpay;
    }

    private BigDecimal cumpaid;

    @javax.persistence.Column(name = "CUMPAID")
    @Basic
    public BigDecimal getCumpaid() {
        return cumpaid;
    }

    public void setCumpaid(BigDecimal cumpaid) {
        this.cumpaid = cumpaid;
    }

    private String begdtez;

    @javax.persistence.Column(name = "BEGDTEZ")
    @Basic
    public String getBegdtez() {
        return begdtez;
    }

    public void setBegdtez(String begdtez) {
        this.begdtez = begdtez;
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

    private String begdted;

    @javax.persistence.Column(name = "BEGDTED")
    @Basic
    public String getBegdted() {
        return begdted;
    }

    public void setBegdted(String begdted) {
        this.begdted = begdted;
    }

    private String enddtez;

    @javax.persistence.Column(name = "ENDDTEZ")
    @Basic
    public String getEnddtez() {
        return enddtez;
    }

    public void setEnddtez(String enddtez) {
        this.enddtez = enddtez;
    }

    private String enddate;

    @javax.persistence.Column(name = "ENDDATE")
    @Basic
    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    private String enddted;

    @javax.persistence.Column(name = "ENDDTED")
    @Basic
    public String getEnddted() {
        return enddted;
    }

    public void setEnddted(String enddted) {
        this.enddted = enddted;
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

    private String vflag;

    @javax.persistence.Column(name = "VFLAG")
    @Basic
    public String getVflag() {
        return vflag;
    }

    public void setVflag(String vflag) {
        this.vflag = vflag;
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

    private String trnnum;

    @javax.persistence.Column(name = "TRNNUM")
    @Basic
    public String getTrnnum() {
        return trnnum;
    }

    public void setTrnnum(String trnnum) {
        this.trnnum = trnnum;
    }

    private String statdte;

    @javax.persistence.Column(name = "STATDTE")
    @Basic
    public String getStatdte() {
        return statdte;
    }

    public void setStatdte(String statdte) {
        this.statdte = statdte;
    }

    private BigDecimal schamt;

    @javax.persistence.Column(name = "SCHAMT")
    @Basic
    public BigDecimal getSchamt() {
        return schamt;
    }

    public void setSchamt(BigDecimal schamt) {
        this.schamt = schamt;
    }

    private BigDecimal cawdrmn;

    @javax.persistence.Column(name = "CAWDRMN")
    @Basic
    public BigDecimal getCawdrmn() {
        return cawdrmn;
    }

    public void setCawdrmn(BigDecimal cawdrmn) {
        this.cawdrmn = cawdrmn;
    }

    private BigDecimal cawdper;

    @javax.persistence.Column(name = "CAWDPER")
    @Basic
    public BigDecimal getCawdper() {
        return cawdper;
    }

    public void setCawdper(BigDecimal cawdper) {
        this.cawdper = cawdper;
    }

    private String typecd;

    @javax.persistence.Column(name = "TYPECD")
    @Basic
    public String getTypecd() {
        return typecd;
    }

    public void setTypecd(String typecd) {
        this.typecd = typecd;
    }

    private String chngflg;

    @javax.persistence.Column(name = "CHNGFLG")
    @Basic
    public String getChngflg() {
        return chngflg;
    }

    public void setChngflg(String chngflg) {
        this.chngflg = chngflg;
    }

    private BigDecimal cawdnet;

    @javax.persistence.Column(name = "CAWDNET")
    @Basic
    public BigDecimal getCawdnet() {
        return cawdnet;
    }

    public void setCawdnet(BigDecimal cawdnet) {
        this.cawdnet = cawdnet;
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

    private String baldte;

    @javax.persistence.Column(name = "BALDTE")
    @Basic
    public String getBaldte() {
        return baldte;
    }

    public void setBaldte(String baldte) {
        this.baldte = baldte;
    }

    private String gacode;

    @javax.persistence.Column(name = "GACODE")
    @Basic
    public String getGacode() {
        return gacode;
    }

    public void setGacode(String gacode) {
        this.gacode = gacode;
    }

    private String contype;

    @javax.persistence.Column(name = "CONTYPE")
    @Basic
    public String getContype() {
        return contype;
    }

    public void setContype(String contype) {
        this.contype = contype;
    }

    private String concode;

    @javax.persistence.Column(name = "CONCODE")
    @Basic
    public String getConcode() {
        return concode;
    }

    public void setConcode(String concode) {
        this.concode = concode;
    }

    private String exusubf;

    @javax.persistence.Column(name = "EXUSUBF")
    @Basic
    public String getExusubf() {
        return exusubf;
    }

    public void setExusubf(String exusubf) {
        this.exusubf = exusubf;
    }

    private String capintf;

    @javax.persistence.Column(name = "CAPINTF")
    @Basic
    public String getCapintf() {
        return capintf;
    }

    public void setCapintf(String capintf) {
        this.capintf = capintf;
    }

    private String source;

    @javax.persistence.Column(name = "SOURCE")
    @Basic
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    private BigDecimal usernr1;

    @javax.persistence.Column(name = "USERNR1")
    @Basic
    public BigDecimal getUsernr1() {
        return usernr1;
    }

    public void setUsernr1(BigDecimal usernr1) {
        this.usernr1 = usernr1;
    }

    private BigDecimal usernr2;

    @javax.persistence.Column(name = "USERNR2")
    @Basic
    public BigDecimal getUsernr2() {
        return usernr2;
    }

    public void setUsernr2(BigDecimal usernr2) {
        this.usernr2 = usernr2;
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

    private String prgcode;

    @javax.persistence.Column(name = "PRGCODE")
    @Basic
    public String getPrgcode() {
        return prgcode;
    }

    public void setPrgcode(String prgcode) {
        this.prgcode = prgcode;
    }

    private String aghspcd;

    @javax.persistence.Column(name = "AGHSPCD")
    @Basic
    public String getAghspcd() {
        return aghspcd;
    }

    public void setAghspcd(String aghspcd) {
        this.aghspcd = aghspcd;
    }

    private String stipgcd;

    @javax.persistence.Column(name = "STIPGCD")
    @Basic
    public String getStipgcd() {
        return stipgcd;
    }

    public void setStipgcd(String stipgcd) {
        this.stipgcd = stipgcd;
    }

    private String agseqcd;

    @javax.persistence.Column(name = "AGSEQCD")
    @Basic
    public String getAgseqcd() {
        return agseqcd;
    }

    public void setAgseqcd(String agseqcd) {
        this.agseqcd = agseqcd;
    }

    private String agelgcd;

    @javax.persistence.Column(name = "AGELGCD")
    @Basic
    public String getAgelgcd() {
        return agelgcd;
    }

    public void setAgelgcd(String agelgcd) {
        this.agelgcd = agelgcd;
    }

    private String agschyr;

    @javax.persistence.Column(name = "AGSCHYR")
    @Basic
    public String getAgschyr() {
        return agschyr;
    }

    public void setAgschyr(String agschyr) {
        this.agschyr = agschyr;
    }

    private String awdyr;

    @javax.persistence.Column(name = "AWDYR")
    @Basic
    public String getAwdyr() {
        return awdyr;
    }

    public void setAwdyr(String awdyr) {
        this.awdyr = awdyr;
    }

    private BigDecimal tpctusy;

    @javax.persistence.Column(name = "TPCTUSY")
    @Basic
    public BigDecimal getTpctusy() {
        return tpctusy;
    }

    public void setTpctusy(BigDecimal tpctusy) {
        this.tpctusy = tpctusy;
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

    private String addelg;

    @javax.persistence.Column(name = "ADDELG")
    @Basic
    public String getAddelg() {
        return addelg;
    }

    public void setAddelg(String addelg) {
        this.addelg = addelg;
    }

    private int ugagg;

    @javax.persistence.Column(name = "UGAGG")
    @Basic
    public int getUgagg() {
        return ugagg;
    }

    public void setUgagg(int ugagg) {
        this.ugagg = ugagg;
    }

    private int grdagg;

    @javax.persistence.Column(name = "GRDAGG")
    @Basic
    public int getGrdagg() {
        return grdagg;
    }

    public void setGrdagg(int grdagg) {
        this.grdagg = grdagg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HawEntity hawEntity = (HawEntity) o;

        if (efc != hawEntity.efc) return false;
        if (grdagg != hawEntity.grdagg) return false;
        if (revlev != hawEntity.revlev) return false;
        if (ugagg != hawEntity.ugagg) return false;
        if (acdlvl != null ? !acdlvl.equals(hawEntity.acdlvl) : hawEntity.acdlvl != null) return false;
        if (actnr != null ? !actnr.equals(hawEntity.actnr) : hawEntity.actnr != null) return false;
        if (addelg != null ? !addelg.equals(hawEntity.addelg) : hawEntity.addelg != null) return false;
        if (admresp != null ? !admresp.equals(hawEntity.admresp) : hawEntity.admresp != null) return false;
        if (agelgcd != null ? !agelgcd.equals(hawEntity.agelgcd) : hawEntity.agelgcd != null) return false;
        if (aghspcd != null ? !aghspcd.equals(hawEntity.aghspcd) : hawEntity.aghspcd != null) return false;
        if (agschyr != null ? !agschyr.equals(hawEntity.agschyr) : hawEntity.agschyr != null) return false;
        if (agseqcd != null ? !agseqcd.equals(hawEntity.agseqcd) : hawEntity.agseqcd != null) return false;
        if (aidid != null ? !aidid.equals(hawEntity.aidid) : hawEntity.aidid != null) return false;
        if (aidyr != null ? !aidyr.equals(hawEntity.aidyr) : hawEntity.aidyr != null) return false;
        if (allawd != null ? !allawd.equals(hawEntity.allawd) : hawEntity.allawd != null) return false;
        if (allpay != null ? !allpay.equals(hawEntity.allpay) : hawEntity.allpay != null) return false;
        if (allterm != null ? !allterm.equals(hawEntity.allterm) : hawEntity.allterm != null) return false;
        if (allyrs != null ? !allyrs.equals(hawEntity.allyrs) : hawEntity.allyrs != null) return false;
        if (awdyr != null ? !awdyr.equals(hawEntity.awdyr) : hawEntity.awdyr != null) return false;
        if (baldte != null ? !baldte.equals(hawEntity.baldte) : hawEntity.baldte != null) return false;
        if (begdate != null ? !begdate.equals(hawEntity.begdate) : hawEntity.begdate != null) return false;
        if (begdted != null ? !begdted.equals(hawEntity.begdted) : hawEntity.begdted != null) return false;
        if (begdtez != null ? !begdtez.equals(hawEntity.begdtez) : hawEntity.begdtez != null) return false;
        if (caidyr != null ? !caidyr.equals(hawEntity.caidyr) : hawEntity.caidyr != null) return false;
        if (caidyrz != null ? !caidyrz.equals(hawEntity.caidyrz) : hawEntity.caidyrz != null) return false;
        if (capintf != null ? !capintf.equals(hawEntity.capintf) : hawEntity.capintf != null) return false;
        if (cawdamt != null ? !cawdamt.equals(hawEntity.cawdamt) : hawEntity.cawdamt != null) return false;
        if (cawdnet != null ? !cawdnet.equals(hawEntity.cawdnet) : hawEntity.cawdnet != null) return false;
        if (cawdpay != null ? !cawdpay.equals(hawEntity.cawdpay) : hawEntity.cawdpay != null) return false;
        if (cawdper != null ? !cawdper.equals(hawEntity.cawdper) : hawEntity.cawdper != null) return false;
        if (cawdrmn != null ? !cawdrmn.equals(hawEntity.cawdrmn) : hawEntity.cawdrmn != null) return false;
        if (cawdsch != null ? !cawdsch.equals(hawEntity.cawdsch) : hawEntity.cawdsch != null) return false;
        if (cfte != null ? !cfte.equals(hawEntity.cfte) : hawEntity.cfte != null) return false;
        if (chngflg != null ? !chngflg.equals(hawEntity.chngflg) : hawEntity.chngflg != null) return false;
        if (chrtact != null ? !chrtact.equals(hawEntity.chrtact) : hawEntity.chrtact != null) return false;
        if (concode != null ? !concode.equals(hawEntity.concode) : hawEntity.concode != null) return false;
        if (contype != null ? !contype.equals(hawEntity.contype) : hawEntity.contype != null) return false;
        if (crtdate != null ? !crtdate.equals(hawEntity.crtdate) : hawEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(hawEntity.crtmod) : hawEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(hawEntity.crttime) : hawEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(hawEntity.crtuser) : hawEntity.crtuser != null) return false;
        if (cumpaid != null ? !cumpaid.equals(hawEntity.cumpaid) : hawEntity.cumpaid != null) return false;
        if (depstat != null ? !depstat.equals(hawEntity.depstat) : hawEntity.depstat != null) return false;
        if (ecampus != null ? !ecampus.equals(hawEntity.ecampus) : hawEntity.ecampus != null) return false;
        if (enddate != null ? !enddate.equals(hawEntity.enddate) : hawEntity.enddate != null) return false;
        if (enddted != null ? !enddted.equals(hawEntity.enddted) : hawEntity.enddted != null) return false;
        if (enddtez != null ? !enddtez.equals(hawEntity.enddtez) : hawEntity.enddtez != null) return false;
        if (exusubf != null ? !exusubf.equals(hawEntity.exusubf) : hawEntity.exusubf != null) return false;
        if (gacode != null ? !gacode.equals(hawEntity.gacode) : hawEntity.gacode != null) return false;
        if (hawkey != null ? !hawkey.equals(hawEntity.hawkey) : hawEntity.hawkey != null) return false;
        if (initals != null ? !initals.equals(hawEntity.initals) : hawEntity.initals != null) return false;
        if (lendid != null ? !lendid.equals(hawEntity.lendid) : hawEntity.lendid != null) return false;
        if (loannr != null ? !loannr.equals(hawEntity.loannr) : hawEntity.loannr != null) return false;
        if (module != null ? !module.equals(hawEntity.module) : hawEntity.module != null) return false;
        if (pgmname != null ? !pgmname.equals(hawEntity.pgmname) : hawEntity.pgmname != null) return false;
        if (prgcode != null ? !prgcode.equals(hawEntity.prgcode) : hawEntity.prgcode != null) return false;
        if (recstat != null ? !recstat.equals(hawEntity.recstat) : hawEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(hawEntity.revdate) : hawEntity.revdate != null) return false;
        if (revdtez != null ? !revdtez.equals(hawEntity.revdtez) : hawEntity.revdtez != null) return false;
        if (schamt != null ? !schamt.equals(hawEntity.schamt) : hawEntity.schamt != null) return false;
        if (sid != null ? !sid.equals(hawEntity.sid) : hawEntity.sid != null) return false;
        if (sid2 != null ? !sid2.equals(hawEntity.sid2) : hawEntity.sid2 != null) return false;
        if (sitime != null ? !sitime.equals(hawEntity.sitime) : hawEntity.sitime != null) return false;
        if (source != null ? !source.equals(hawEntity.source) : hawEntity.source != null) return false;
        if (statcd != null ? !statcd.equals(hawEntity.statcd) : hawEntity.statcd != null) return false;
        if (statdte != null ? !statdte.equals(hawEntity.statdte) : hawEntity.statdte != null) return false;
        if (stipgcd != null ? !stipgcd.equals(hawEntity.stipgcd) : hawEntity.stipgcd != null) return false;
        if (taxcode != null ? !taxcode.equals(hawEntity.taxcode) : hawEntity.taxcode != null) return false;
        if (tcnflg != null ? !tcnflg.equals(hawEntity.tcnflg) : hawEntity.tcnflg != null) return false;
        if (tpctusy != null ? !tpctusy.equals(hawEntity.tpctusy) : hawEntity.tpctusy != null) return false;
        if (trnnum != null ? !trnnum.equals(hawEntity.trnnum) : hawEntity.trnnum != null) return false;
        if (typeaid != null ? !typeaid.equals(hawEntity.typeaid) : hawEntity.typeaid != null) return false;
        if (typecd != null ? !typecd.equals(hawEntity.typecd) : hawEntity.typecd != null) return false;
        if (typetrm != null ? !typetrm.equals(hawEntity.typetrm) : hawEntity.typetrm != null) return false;
        if (ucode != null ? !ucode.equals(hawEntity.ucode) : hawEntity.ucode != null) return false;
        if (unused1 != null ? !unused1.equals(hawEntity.unused1) : hawEntity.unused1 != null) return false;
        if (usercd1 != null ? !usercd1.equals(hawEntity.usercd1) : hawEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(hawEntity.usercd2) : hawEntity.usercd2 != null) return false;
        if (usernr1 != null ? !usernr1.equals(hawEntity.usernr1) : hawEntity.usernr1 != null) return false;
        if (usernr2 != null ? !usernr2.equals(hawEntity.usernr2) : hawEntity.usernr2 != null) return false;
        if (vflag != null ? !vflag.equals(hawEntity.vflag) : hawEntity.vflag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (hawkey != null ? hawkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (aidid != null ? aidid.hashCode() : 0);
        result = 31 * result + (unused1 != null ? unused1.hashCode() : 0);
        result = 31 * result + (actnr != null ? actnr.hashCode() : 0);
        result = 31 * result + (sid2 != null ? sid2.hashCode() : 0);
        result = 31 * result + (loannr != null ? loannr.hashCode() : 0);
        result = 31 * result + (pgmname != null ? pgmname.hashCode() : 0);
        result = 31 * result + (admresp != null ? admresp.hashCode() : 0);
        result = 31 * result + (typeaid != null ? typeaid.hashCode() : 0);
        result = 31 * result + (typetrm != null ? typetrm.hashCode() : 0);
        result = 31 * result + (taxcode != null ? taxcode.hashCode() : 0);
        result = 31 * result + (cfte != null ? cfte.hashCode() : 0);
        result = 31 * result + (allyrs != null ? allyrs.hashCode() : 0);
        result = 31 * result + (allterm != null ? allterm.hashCode() : 0);
        result = 31 * result + (acdlvl != null ? acdlvl.hashCode() : 0);
        result = 31 * result + (depstat != null ? depstat.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (sitime != null ? sitime.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (caidyrz != null ? caidyrz.hashCode() : 0);
        result = 31 * result + (caidyr != null ? caidyr.hashCode() : 0);
        result = 31 * result + (revdtez != null ? revdtez.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (chrtact != null ? chrtact.hashCode() : 0);
        result = 31 * result + (ecampus != null ? ecampus.hashCode() : 0);
        result = 31 * result + (cawdamt != null ? cawdamt.hashCode() : 0);
        result = 31 * result + (cawdsch != null ? cawdsch.hashCode() : 0);
        result = 31 * result + (cawdpay != null ? cawdpay.hashCode() : 0);
        result = 31 * result + (allawd != null ? allawd.hashCode() : 0);
        result = 31 * result + (allpay != null ? allpay.hashCode() : 0);
        result = 31 * result + (cumpaid != null ? cumpaid.hashCode() : 0);
        result = 31 * result + (begdtez != null ? begdtez.hashCode() : 0);
        result = 31 * result + (begdate != null ? begdate.hashCode() : 0);
        result = 31 * result + (begdted != null ? begdted.hashCode() : 0);
        result = 31 * result + (enddtez != null ? enddtez.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (enddted != null ? enddted.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (vflag != null ? vflag.hashCode() : 0);
        result = 31 * result + efc;
        result = 31 * result + (trnnum != null ? trnnum.hashCode() : 0);
        result = 31 * result + (statdte != null ? statdte.hashCode() : 0);
        result = 31 * result + (schamt != null ? schamt.hashCode() : 0);
        result = 31 * result + (cawdrmn != null ? cawdrmn.hashCode() : 0);
        result = 31 * result + (cawdper != null ? cawdper.hashCode() : 0);
        result = 31 * result + (typecd != null ? typecd.hashCode() : 0);
        result = 31 * result + (chngflg != null ? chngflg.hashCode() : 0);
        result = 31 * result + (cawdnet != null ? cawdnet.hashCode() : 0);
        result = 31 * result + (statcd != null ? statcd.hashCode() : 0);
        result = 31 * result + (baldte != null ? baldte.hashCode() : 0);
        result = 31 * result + (gacode != null ? gacode.hashCode() : 0);
        result = 31 * result + (contype != null ? contype.hashCode() : 0);
        result = 31 * result + (concode != null ? concode.hashCode() : 0);
        result = 31 * result + (exusubf != null ? exusubf.hashCode() : 0);
        result = 31 * result + (capintf != null ? capintf.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usernr1 != null ? usernr1.hashCode() : 0);
        result = 31 * result + (usernr2 != null ? usernr2.hashCode() : 0);
        result = 31 * result + (lendid != null ? lendid.hashCode() : 0);
        result = 31 * result + (prgcode != null ? prgcode.hashCode() : 0);
        result = 31 * result + (aghspcd != null ? aghspcd.hashCode() : 0);
        result = 31 * result + (stipgcd != null ? stipgcd.hashCode() : 0);
        result = 31 * result + (agseqcd != null ? agseqcd.hashCode() : 0);
        result = 31 * result + (agelgcd != null ? agelgcd.hashCode() : 0);
        result = 31 * result + (agschyr != null ? agschyr.hashCode() : 0);
        result = 31 * result + (awdyr != null ? awdyr.hashCode() : 0);
        result = 31 * result + (tpctusy != null ? tpctusy.hashCode() : 0);
        result = 31 * result + (tcnflg != null ? tcnflg.hashCode() : 0);
        result = 31 * result + (addelg != null ? addelg.hashCode() : 0);
        result = 31 * result + ugagg;
        result = 31 * result + grdagg;
        return result;
    }
}
