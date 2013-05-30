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
@javax.persistence.Table(name = "SNB4", schema = "SIGMA", catalog = "")
@Entity
public class Snb4Entity implements Identifiable {

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

    private String npres;

    @javax.persistence.Column(name = "NPRES")
    @Basic
    public String getNpres() {
        return npres;
    }

    public void setNpres(String npres) {
        this.npres = npres;
    }

    private BigInteger npage;

    @javax.persistence.Column(name = "NPAGE")
    @Basic
    public BigInteger getNpage() {
        return npage;
    }

    public void setNpage(BigInteger npage) {
        this.npage = npage;
    }

    private String nptrfil;

    @javax.persistence.Column(name = "NPTRFIL")
    @Basic
    public String getNptrfil() {
        return nptrfil;
    }

    public void setNptrfil(String nptrfil) {
        this.nptrfil = nptrfil;
    }

    private BigInteger npszhhd;

    @javax.persistence.Column(name = "NPSZHHD")
    @Basic
    public BigInteger getNpszhhd() {
        return npszhhd;
    }

    public void setNpszhhd(BigInteger npszhhd) {
        this.npszhhd = npszhhd;
    }

    private BigInteger npexemp;

    @javax.persistence.Column(name = "NPEXEMP")
    @Basic
    public BigInteger getNpexemp() {
        return npexemp;
    }

    public void setNpexemp(BigInteger npexemp) {
        this.npexemp = npexemp;
    }

    private BigInteger npnrps;

    @javax.persistence.Column(name = "NPNRPS")
    @Basic
    public BigInteger getNpnrps() {
        return npnrps;
    }

    public void setNpnrps(BigInteger npnrps) {
        this.npnrps = npnrps;
    }

    private int npwag;

    @javax.persistence.Column(name = "NPWAG")
    @Basic
    public int getNpwag() {
        return npwag;
    }

    public void setNpwag(int npwag) {
        this.npwag = npwag;
    }

    private int npspwag;

    @javax.persistence.Column(name = "NPSPWAG")
    @Basic
    public int getNpspwag() {
        return npspwag;
    }

    public void setNpspwag(int npspwag) {
        this.npspwag = npspwag;
    }

    private int npint;

    @javax.persistence.Column(name = "NPINT")
    @Basic
    public int getNpint() {
        return npint;
    }

    public void setNpint(int npint) {
        this.npint = npint;
    }

    private int npdiv;

    @javax.persistence.Column(name = "NPDIV")
    @Basic
    public int getNpdiv() {
        return npdiv;
    }

    public void setNpdiv(int npdiv) {
        this.npdiv = npdiv;
    }

    private int npbfi;

    @javax.persistence.Column(name = "NPBFI")
    @Basic
    public int getNpbfi() {
        return npbfi;
    }

    public void setNpbfi(int npbfi) {
        this.npbfi = npbfi;
    }

    private int npoti;

    @javax.persistence.Column(name = "NPOTI")
    @Basic
    public int getNpoti() {
        return npoti;
    }

    public void setNpoti(int npoti) {
        this.npoti = npoti;
    }

    private int npadj;

    @javax.persistence.Column(name = "NPADJ")
    @Basic
    public int getNpadj() {
        return npadj;
    }

    public void setNpadj(int npadj) {
        this.npadj = npadj;
    }

    private int nptti;

    @javax.persistence.Column(name = "NPTTI")
    @Basic
    public int getNptti() {
        return nptti;
    }

    public void setNptti(int nptti) {
        this.nptti = nptti;
    }

    private int npss;

    @javax.persistence.Column(name = "NPSS")
    @Basic
    public int getNpss() {
        return npss;
    }

    public void setNpss(int npss) {
        this.npss = npss;
    }

    private int nponti;

    @javax.persistence.Column(name = "NPONTI")
    @Basic
    public int getNponti() {
        return nponti;
    }

    public void setNponti(int nponti) {
        this.nponti = nponti;
    }

    private int nptinc;

    @javax.persistence.Column(name = "NPTINC")
    @Basic
    public int getNptinc() {
        return nptinc;
    }

    public void setNptinc(int nptinc) {
        this.nptinc = nptinc;
    }

    private int npded;

    @javax.persistence.Column(name = "NPDED")
    @Basic
    public int getNpded() {
        return npded;
    }

    public void setNpded(int npded) {
        this.npded = npded;
    }

    private int npitx;

    @javax.persistence.Column(name = "NPITX")
    @Basic
    public int getNpitx() {
        return npitx;
    }

    public void setNpitx(int npitx) {
        this.npitx = npitx;
    }

    private int npfica;

    @javax.persistence.Column(name = "NPFICA")
    @Basic
    public int getNpfica() {
        return npfica;
    }

    public void setNpfica(int npfica) {
        this.npfica = npfica;
    }

    private int npsttx;

    @javax.persistence.Column(name = "NPSTTX")
    @Basic
    public int getNpsttx() {
        return npsttx;
    }

    public void setNpsttx(int npsttx) {
        this.npsttx = npsttx;
    }

    private int npmed;

    @javax.persistence.Column(name = "NPMED")
    @Basic
    public int getNpmed() {
        return npmed;
    }

    public void setNpmed(int npmed) {
        this.npmed = npmed;
    }

    private int nptuit;

    @javax.persistence.Column(name = "NPTUIT")
    @Basic
    public int getNptuit() {
        return nptuit;
    }

    public void setNptuit(int nptuit) {
        this.nptuit = nptuit;
    }

    private int npoalo;

    @javax.persistence.Column(name = "NPOALO")
    @Basic
    public int getNpoalo() {
        return npoalo;
    }

    public void setNpoalo(int npoalo) {
        this.npoalo = npoalo;
    }

    private int npemalo;

    @javax.persistence.Column(name = "NPEMALO")
    @Basic
    public int getNpemalo() {
        return npemalo;
    }

    public void setNpemalo(int npemalo) {
        this.npemalo = npemalo;
    }

    private int npsma;

    @javax.persistence.Column(name = "NPSMA")
    @Basic
    public int getNpsma() {
        return npsma;
    }

    public void setNpsma(int npsma) {
        this.npsma = npsma;
    }

    private int npcstot;

    @javax.persistence.Column(name = "NPCSTOT")
    @Basic
    public int getNpcstot() {
        return npcstot;
    }

    public void setNpcstot(int npcstot) {
        this.npcstot = npcstot;
    }

    private int npcsstu;

    @javax.persistence.Column(name = "NPCSSTU")
    @Basic
    public int getNpcsstu() {
        return npcsstu;
    }

    public void setNpcsstu(int npcsstu) {
        this.npcsstu = npcsstu;
    }

    private int npalm;

    @javax.persistence.Column(name = "NPALM")
    @Basic
    public int getNpalm() {
        return npalm;
    }

    public void setNpalm(int npalm) {
        this.npalm = npalm;
    }

    private int nptalo;

    @javax.persistence.Column(name = "NPTALO")
    @Basic
    public int getNptalo() {
        return nptalo;
    }

    public void setNptalo(int nptalo) {
        this.nptalo = nptalo;
    }

    private int npefi;

    @javax.persistence.Column(name = "NPEFI")
    @Basic
    public int getNpefi() {
        return npefi;
    }

    public void setNpefi(int npefi) {
        this.npefi = npefi;
    }

    private String nphomyr;

    @javax.persistence.Column(name = "NPHOMYR")
    @Basic
    public String getNphomyr() {
        return nphomyr;
    }

    public void setNphomyr(String nphomyr) {
        this.nphomyr = nphomyr;
    }

    private int nphompv;

    @javax.persistence.Column(name = "NPHOMPV")
    @Basic
    public int getNphompv() {
        return nphompv;
    }

    public void setNphompv(int nphompv) {
        this.nphompv = nphompv;
    }

    private int nphomv;

    @javax.persistence.Column(name = "NPHOMV")
    @Basic
    public int getNphomv() {
        return nphomv;
    }

    public void setNphomv(int nphomv) {
        this.nphomv = nphomv;
    }

    private int nphomd;

    @javax.persistence.Column(name = "NPHOMD")
    @Basic
    public int getNphomd() {
        return nphomd;
    }

    public void setNphomd(int nphomd) {
        this.nphomd = nphomd;
    }

    private int npcash;

    @javax.persistence.Column(name = "NPCASH")
    @Basic
    public int getNpcash() {
        return npcash;
    }

    public void setNpcash(int npcash) {
        this.npcash = npcash;
    }

    private int nporv;

    @javax.persistence.Column(name = "NPORV")
    @Basic
    public int getNporv() {
        return nporv;
    }

    public void setNporv(int nporv) {
        this.nporv = nporv;
    }

    private int npord;

    @javax.persistence.Column(name = "NPORD")
    @Basic
    public int getNpord() {
        return npord;
    }

    public void setNpord(int npord) {
        this.npord = npord;
    }

    private int npinvv;

    @javax.persistence.Column(name = "NPINVV")
    @Basic
    public int getNpinvv() {
        return npinvv;
    }

    public void setNpinvv(int npinvv) {
        this.npinvv = npinvv;
    }

    private int npinvd;

    @javax.persistence.Column(name = "NPINVD")
    @Basic
    public int getNpinvd() {
        return npinvd;
    }

    public void setNpinvd(int npinvd) {
        this.npinvd = npinvd;
    }

    private int npbfv;

    @javax.persistence.Column(name = "NPBFV")
    @Basic
    public int getNpbfv() {
        return npbfv;
    }

    public void setNpbfv(int npbfv) {
        this.npbfv = npbfv;
    }

    private int npbfd;

    @javax.persistence.Column(name = "NPBFD")
    @Basic
    public int getNpbfd() {
        return npbfd;
    }

    public void setNpbfd(int npbfd) {
        this.npbfd = npbfd;
    }

    private BigDecimal npbfper;

    @javax.persistence.Column(name = "NPBFPER")
    @Basic
    public BigDecimal getNpbfper() {
        return npbfper;
    }

    public void setNpbfper(BigDecimal npbfper) {
        this.npbfper = npbfper;
    }

    private int npothd;

    @javax.persistence.Column(name = "NPOTHD")
    @Basic
    public int getNpothd() {
        return npothd;
    }

    public void setNpothd(int npothd) {
        this.npothd = npothd;
    }

    private int npnetw;

    @javax.persistence.Column(name = "NPNETW")
    @Basic
    public int getNpnetw() {
        return npnetw;
    }

    public void setNpnetw(int npnetw) {
        this.npnetw = npnetw;
    }

    private int npapa;

    @javax.persistence.Column(name = "NPAPA")
    @Basic
    public int getNpapa() {
        return npapa;
    }

    public void setNpapa(int npapa) {
        this.npapa = npapa;
    }

    private int npdnet;

    @javax.persistence.Column(name = "NPDNET")
    @Basic
    public int getNpdnet() {
        return npdnet;
    }

    public void setNpdnet(int npdnet) {
        this.npdnet = npdnet;
    }

    private int npincs;

    @javax.persistence.Column(name = "NPINCS")
    @Basic
    public int getNpincs() {
        return npincs;
    }

    public void setNpincs(int npincs) {
        this.npincs = npincs;
    }

    private int npaavl;

    @javax.persistence.Column(name = "NPAAVL")
    @Basic
    public int getNpaavl() {
        return npaavl;
    }

    public void setNpaavl(int npaavl) {
        this.npaavl = npaavl;
    }

    private BigDecimal npcola;

    @javax.persistence.Column(name = "NPCOLA")
    @Basic
    public BigDecimal getNpcola() {
        return npcola;
    }

    public void setNpcola(BigDecimal npcola) {
        this.npcola = npcola;
    }

    private int npraav;

    @javax.persistence.Column(name = "NPRAAV")
    @Basic
    public int getNpraav() {
        return npraav;
    }

    public void setNpraav(int npraav) {
        this.npraav = npraav;
    }

    private int nptcon;

    @javax.persistence.Column(name = "NPTCON")
    @Basic
    public int getNptcon() {
        return nptcon;
    }

    public void setNptcon(int nptcon) {
        this.nptcon = nptcon;
    }

    private int npconn;

    @javax.persistence.Column(name = "NPCONN")
    @Basic
    public int getNpconn() {
        return npconn;
    }

    public void setNpconn(int npconn) {
        this.npconn = npconn;
    }

    private int npconr;

    @javax.persistence.Column(name = "NPCONR")
    @Basic
    public int getNpconr() {
        return npconr;
    }

    public void setNpconr(int npconr) {
        this.npconr = npconr;
    }

    private int npconf;

    @javax.persistence.Column(name = "NPCONF")
    @Basic
    public int getNpconf() {
        return npconf;
    }

    public void setNpconf(int npconf) {
        this.npconf = npconf;
    }

    private String nptincs;

    @javax.persistence.Column(name = "NPTINCS")
    @Basic
    public String getNptincs() {
        return nptincs;
    }

    public void setNptincs(String nptincs) {
        this.nptincs = nptincs;
    }

    private String npitxs;

    @javax.persistence.Column(name = "NPITXS")
    @Basic
    public String getNpitxs() {
        return npitxs;
    }

    public void setNpitxs(String npitxs) {
        this.npitxs = npitxs;
    }

    private String npficas;

    @javax.persistence.Column(name = "NPFICAS")
    @Basic
    public String getNpficas() {
        return npficas;
    }

    public void setNpficas(String npficas) {
        this.npficas = npficas;
    }

    private String npsttxs;

    @javax.persistence.Column(name = "NPSTTXS")
    @Basic
    public String getNpsttxs() {
        return npsttxs;
    }

    public void setNpsttxs(String npsttxs) {
        this.npsttxs = npsttxs;
    }

    private String npmeds;

    @javax.persistence.Column(name = "NPMEDS")
    @Basic
    public String getNpmeds() {
        return npmeds;
    }

    public void setNpmeds(String npmeds) {
        this.npmeds = npmeds;
    }

    private String npemas;

    @javax.persistence.Column(name = "NPEMAS")
    @Basic
    public String getNpemas() {
        return npemas;
    }

    public void setNpemas(String npemas) {
        this.npemas = npemas;
    }

    private String npsmas;

    @javax.persistence.Column(name = "NPSMAS")
    @Basic
    public String getNpsmas() {
        return npsmas;
    }

    public void setNpsmas(String npsmas) {
        this.npsmas = npsmas;
    }

    private String nptalos;

    @javax.persistence.Column(name = "NPTALOS")
    @Basic
    public String getNptalos() {
        return nptalos;
    }

    public void setNptalos(String nptalos) {
        this.nptalos = nptalos;
    }

    private String nphomvs;

    @javax.persistence.Column(name = "NPHOMVS")
    @Basic
    public String getNphomvs() {
        return nphomvs;
    }

    public void setNphomvs(String nphomvs) {
        this.nphomvs = nphomvs;
    }

    private String npincss;

    @javax.persistence.Column(name = "NPINCSS")
    @Basic
    public String getNpincss() {
        return npincss;
    }

    public void setNpincss(String npincss) {
        this.npincss = npincss;
    }

    private String npaavls;

    @javax.persistence.Column(name = "NPAAVLS")
    @Basic
    public String getNpaavls() {
        return npaavls;
    }

    public void setNpaavls(String npaavls) {
        this.npaavls = npaavls;
    }

    private String npconns;

    @javax.persistence.Column(name = "NPCONNS")
    @Basic
    public String getNpconns() {
        return npconns;
    }

    public void setNpconns(String npconns) {
        this.npconns = npconns;
    }

    private String npconrs;

    @javax.persistence.Column(name = "NPCONRS")
    @Basic
    public String getNpconrs() {
        return npconrs;
    }

    public void setNpconrs(String npconrs) {
        this.npconrs = npconrs;
    }

    private String npconfs;

    @javax.persistence.Column(name = "NPCONFS")
    @Basic
    public String getNpconfs() {
        return npconfs;
    }

    public void setNpconfs(String npconfs) {
        this.npconfs = npconfs;
    }

    private String npcomp;

    @javax.persistence.Column(name = "NPCOMP")
    @Basic
    public String getNpcomp() {
        return npcomp;
    }

    public void setNpcomp(String npcomp) {
        this.npcomp = npcomp;
    }

    private String npsig;

    @javax.persistence.Column(name = "NPSIG")
    @Basic
    public String getNpsig() {
        return npsig;
    }

    public void setNpsig(String npsig) {
        this.npsig = npsig;
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

        Snb4Entity that = (Snb4Entity) o;

        if (npaavl != that.npaavl) return false;
        if (npadj != that.npadj) return false;
        if (npalm != that.npalm) return false;
        if (npapa != that.npapa) return false;
        if (npbfd != that.npbfd) return false;
        if (npbfi != that.npbfi) return false;
        if (npbfv != that.npbfv) return false;
        if (npcash != that.npcash) return false;
        if (npconf != that.npconf) return false;
        if (npconn != that.npconn) return false;
        if (npconr != that.npconr) return false;
        if (npcsstu != that.npcsstu) return false;
        if (npcstot != that.npcstot) return false;
        if (npded != that.npded) return false;
        if (npdiv != that.npdiv) return false;
        if (npdnet != that.npdnet) return false;
        if (npefi != that.npefi) return false;
        if (npemalo != that.npemalo) return false;
        if (npfica != that.npfica) return false;
        if (nphomd != that.nphomd) return false;
        if (nphompv != that.nphompv) return false;
        if (nphomv != that.nphomv) return false;
        if (npincs != that.npincs) return false;
        if (npint != that.npint) return false;
        if (npinvd != that.npinvd) return false;
        if (npinvv != that.npinvv) return false;
        if (npitx != that.npitx) return false;
        if (npmed != that.npmed) return false;
        if (npnetw != that.npnetw) return false;
        if (npoalo != that.npoalo) return false;
        if (nponti != that.nponti) return false;
        if (npord != that.npord) return false;
        if (nporv != that.nporv) return false;
        if (npothd != that.npothd) return false;
        if (npoti != that.npoti) return false;
        if (npraav != that.npraav) return false;
        if (npsma != that.npsma) return false;
        if (npspwag != that.npspwag) return false;
        if (npss != that.npss) return false;
        if (npsttx != that.npsttx) return false;
        if (nptalo != that.nptalo) return false;
        if (nptcon != that.nptcon) return false;
        if (nptinc != that.nptinc) return false;
        if (nptti != that.nptti) return false;
        if (nptuit != that.nptuit) return false;
        if (npwag != that.npwag) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (npaavls != null ? !npaavls.equals(that.npaavls) : that.npaavls != null) return false;
        if (npage != null ? !npage.equals(that.npage) : that.npage != null) return false;
        if (npbfper != null ? !npbfper.equals(that.npbfper) : that.npbfper != null) return false;
        if (npcola != null ? !npcola.equals(that.npcola) : that.npcola != null) return false;
        if (npcomp != null ? !npcomp.equals(that.npcomp) : that.npcomp != null) return false;
        if (npconfs != null ? !npconfs.equals(that.npconfs) : that.npconfs != null) return false;
        if (npconns != null ? !npconns.equals(that.npconns) : that.npconns != null) return false;
        if (npconrs != null ? !npconrs.equals(that.npconrs) : that.npconrs != null) return false;
        if (npemas != null ? !npemas.equals(that.npemas) : that.npemas != null) return false;
        if (npexemp != null ? !npexemp.equals(that.npexemp) : that.npexemp != null) return false;
        if (npficas != null ? !npficas.equals(that.npficas) : that.npficas != null) return false;
        if (nphomvs != null ? !nphomvs.equals(that.nphomvs) : that.nphomvs != null) return false;
        if (nphomyr != null ? !nphomyr.equals(that.nphomyr) : that.nphomyr != null) return false;
        if (npincss != null ? !npincss.equals(that.npincss) : that.npincss != null) return false;
        if (npitxs != null ? !npitxs.equals(that.npitxs) : that.npitxs != null) return false;
        if (npmeds != null ? !npmeds.equals(that.npmeds) : that.npmeds != null) return false;
        if (npnrps != null ? !npnrps.equals(that.npnrps) : that.npnrps != null) return false;
        if (npres != null ? !npres.equals(that.npres) : that.npres != null) return false;
        if (npsig != null ? !npsig.equals(that.npsig) : that.npsig != null) return false;
        if (npsmas != null ? !npsmas.equals(that.npsmas) : that.npsmas != null) return false;
        if (npsttxs != null ? !npsttxs.equals(that.npsttxs) : that.npsttxs != null) return false;
        if (npszhhd != null ? !npszhhd.equals(that.npszhhd) : that.npszhhd != null) return false;
        if (nptalos != null ? !nptalos.equals(that.nptalos) : that.nptalos != null) return false;
        if (nptincs != null ? !nptincs.equals(that.nptincs) : that.nptincs != null) return false;
        if (nptrfil != null ? !nptrfil.equals(that.nptrfil) : that.nptrfil != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snbkey != null ? !snbkey.equals(that.snbkey) : that.snbkey != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;

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
        result = 31 * result + (npres != null ? npres.hashCode() : 0);
        result = 31 * result + (npage != null ? npage.hashCode() : 0);
        result = 31 * result + (nptrfil != null ? nptrfil.hashCode() : 0);
        result = 31 * result + (npszhhd != null ? npszhhd.hashCode() : 0);
        result = 31 * result + (npexemp != null ? npexemp.hashCode() : 0);
        result = 31 * result + (npnrps != null ? npnrps.hashCode() : 0);
        result = 31 * result + npwag;
        result = 31 * result + npspwag;
        result = 31 * result + npint;
        result = 31 * result + npdiv;
        result = 31 * result + npbfi;
        result = 31 * result + npoti;
        result = 31 * result + npadj;
        result = 31 * result + nptti;
        result = 31 * result + npss;
        result = 31 * result + nponti;
        result = 31 * result + nptinc;
        result = 31 * result + npded;
        result = 31 * result + npitx;
        result = 31 * result + npfica;
        result = 31 * result + npsttx;
        result = 31 * result + npmed;
        result = 31 * result + nptuit;
        result = 31 * result + npoalo;
        result = 31 * result + npemalo;
        result = 31 * result + npsma;
        result = 31 * result + npcstot;
        result = 31 * result + npcsstu;
        result = 31 * result + npalm;
        result = 31 * result + nptalo;
        result = 31 * result + npefi;
        result = 31 * result + (nphomyr != null ? nphomyr.hashCode() : 0);
        result = 31 * result + nphompv;
        result = 31 * result + nphomv;
        result = 31 * result + nphomd;
        result = 31 * result + npcash;
        result = 31 * result + nporv;
        result = 31 * result + npord;
        result = 31 * result + npinvv;
        result = 31 * result + npinvd;
        result = 31 * result + npbfv;
        result = 31 * result + npbfd;
        result = 31 * result + (npbfper != null ? npbfper.hashCode() : 0);
        result = 31 * result + npothd;
        result = 31 * result + npnetw;
        result = 31 * result + npapa;
        result = 31 * result + npdnet;
        result = 31 * result + npincs;
        result = 31 * result + npaavl;
        result = 31 * result + (npcola != null ? npcola.hashCode() : 0);
        result = 31 * result + npraav;
        result = 31 * result + nptcon;
        result = 31 * result + npconn;
        result = 31 * result + npconr;
        result = 31 * result + npconf;
        result = 31 * result + (nptincs != null ? nptincs.hashCode() : 0);
        result = 31 * result + (npitxs != null ? npitxs.hashCode() : 0);
        result = 31 * result + (npficas != null ? npficas.hashCode() : 0);
        result = 31 * result + (npsttxs != null ? npsttxs.hashCode() : 0);
        result = 31 * result + (npmeds != null ? npmeds.hashCode() : 0);
        result = 31 * result + (npemas != null ? npemas.hashCode() : 0);
        result = 31 * result + (npsmas != null ? npsmas.hashCode() : 0);
        result = 31 * result + (nptalos != null ? nptalos.hashCode() : 0);
        result = 31 * result + (nphomvs != null ? nphomvs.hashCode() : 0);
        result = 31 * result + (npincss != null ? npincss.hashCode() : 0);
        result = 31 * result + (npaavls != null ? npaavls.hashCode() : 0);
        result = 31 * result + (npconns != null ? npconns.hashCode() : 0);
        result = 31 * result + (npconrs != null ? npconrs.hashCode() : 0);
        result = 31 * result + (npconfs != null ? npconfs.hashCode() : 0);
        result = 31 * result + (npcomp != null ? npcomp.hashCode() : 0);
        result = 31 * result + (npsig != null ? npsig.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
