package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/26/12
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNF3", schema = "SIGMA", catalog = "")
@Entity
public class Snf3Entity implements Identifiable {

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

    private int tsexemp;

    @javax.persistence.Column(name = "TSEXEMP")
    @Basic
    public int getTsexemp() {
        return tsexemp;
    }

    public void setTsexemp(int tsexemp) {
        this.tsexemp = tsexemp;
    }

    private int tsdivex;

    @javax.persistence.Column(name = "TSDIVEX")
    @Basic
    public int getTsdivex() {
        return tsdivex;
    }

    public void setTsdivex(int tsdivex) {
        this.tsdivex = tsdivex;
    }

    private int tsswag;

    @javax.persistence.Column(name = "TSSWAG")
    @Basic
    public int getTsswag() {
        return tsswag;
    }

    public void setTsswag(int tsswag) {
        this.tsswag = tsswag;
    }

    private int tspwag;

    @javax.persistence.Column(name = "TSPWAG")
    @Basic
    public int getTspwag() {
        return tspwag;
    }

    public void setTspwag(int tspwag) {
        this.tspwag = tspwag;
    }

    private int tswag;

    @javax.persistence.Column(name = "TSWAG")
    @Basic
    public int getTswag() {
        return tswag;
    }

    public void setTswag(int tswag) {
        this.tswag = tswag;
    }

    private int tsint;

    @javax.persistence.Column(name = "TSINT")
    @Basic
    public int getTsint() {
        return tsint;
    }

    public void setTsint(int tsint) {
        this.tsint = tsint;
    }

    private int tsdivn;

    @javax.persistence.Column(name = "TSDIVN")
    @Basic
    public int getTsdivn() {
        return tsdivn;
    }

    public void setTsdivn(int tsdivn) {
        this.tsdivn = tsdivn;
    }

    private int tsdiv;

    @javax.persistence.Column(name = "TSDIV")
    @Basic
    public int getTsdiv() {
        return tsdiv;
    }

    public void setTsdiv(int tsdiv) {
        this.tsdiv = tsdiv;
    }

    private int tsrfsl;

    @javax.persistence.Column(name = "TSRFSL")
    @Basic
    public int getTsrfsl() {
        return tsrfsl;
    }

    public void setTsrfsl(int tsrfsl) {
        this.tsrfsl = tsrfsl;
    }

    private int tsalim;

    @javax.persistence.Column(name = "TSALIM")
    @Basic
    public int getTsalim() {
        return tsalim;
    }

    public void setTsalim(int tsalim) {
        this.tsalim = tsalim;
    }

    private int tsbus;

    @javax.persistence.Column(name = "TSBUS")
    @Basic
    public int getTsbus() {
        return tsbus;
    }

    public void setTsbus(int tsbus) {
        this.tsbus = tsbus;
    }

    private int tsfiex;

    @javax.persistence.Column(name = "TSFIEX")
    @Basic
    public int getTsfiex() {
        return tsfiex;
    }

    public void setTsfiex(int tsfiex) {
        this.tsfiex = tsfiex;
    }

    private int tspeno;

    @javax.persistence.Column(name = "TSPENO")
    @Basic
    public int getTspeno() {
        return tspeno;
    }

    public void setTspeno(int tspeno) {
        this.tspeno = tspeno;
    }

    private int tspent;

    @javax.persistence.Column(name = "TSPENT")
    @Basic
    public int getTspent() {
        return tspent;
    }

    public void setTspent(int tspent) {
        this.tspent = tspent;
    }

    private int tsrent;

    @javax.persistence.Column(name = "TSRENT")
    @Basic
    public int getTsrent() {
        return tsrent;
    }

    public void setTsrent(int tsrent) {
        this.tsrent = tsrent;
    }

    private int tsfarm;

    @javax.persistence.Column(name = "TSFARM")
    @Basic
    public int getTsfarm() {
        return tsfarm;
    }

    public void setTsfarm(int tsfarm) {
        this.tsfarm = tsfarm;
    }

    private int tsiradt;

    @javax.persistence.Column(name = "TSIRADT")
    @Basic
    public int getTsiradt() {
        return tsiradt;
    }

    public void setTsiradt(int tsiradt) {
        this.tsiradt = tsiradt;
    }

    private int tsunemt;

    @javax.persistence.Column(name = "TSUNEMT")
    @Basic
    public int getTsunemt() {
        return tsunemt;
    }

    public void setTsunemt(int tsunemt) {
        this.tsunemt = tsunemt;
    }

    private int tsss;

    @javax.persistence.Column(name = "TSSS")
    @Basic
    public int getTsss() {
        return tsss;
    }

    public void setTsss(int tsss) {
        this.tsss = tsss;
    }

    private int tssstp;

    @javax.persistence.Column(name = "TSSSTP")
    @Basic
    public int getTssstp() {
        return tssstp;
    }

    public void setTssstp(int tssstp) {
        this.tssstp = tssstp;
    }

    private int tsoti;

    @javax.persistence.Column(name = "TSOTI")
    @Basic
    public int getTsoti() {
        return tsoti;
    }

    public void setTsoti(int tsoti) {
        this.tsoti = tsoti;
    }

    private int tsebex;

    @javax.persistence.Column(name = "TSEBEX")
    @Basic
    public int getTsebex() {
        return tsebex;
    }

    public void setTsebex(int tsebex) {
        this.tsebex = tsebex;
    }

    private int tsira;

    @javax.persistence.Column(name = "TSIRA")
    @Basic
    public int getTsira() {
        return tsira;
    }

    public void setTsira(int tsira) {
        this.tsira = tsira;
    }

    private int tskeogh;

    @javax.persistence.Column(name = "TSKEOGH")
    @Basic
    public int getTskeogh() {
        return tskeogh;
    }

    public void setTskeogh(int tskeogh) {
        this.tskeogh = tskeogh;
    }

    private int tsalmpd;

    @javax.persistence.Column(name = "TSALMPD")
    @Basic
    public int getTsalmpd() {
        return tsalmpd;
    }

    public void setTsalmpd(int tsalmpd) {
        this.tsalmpd = tsalmpd;
    }

    private int tstirad;

    @javax.persistence.Column(name = "TSTIRAD")
    @Basic
    public int getTstirad() {
        return tstirad;
    }

    public void setTstirad(int tstirad) {
        this.tstirad = tstirad;
    }

    private int tsadji;

    @javax.persistence.Column(name = "TSADJI")
    @Basic
    public int getTsadji() {
        return tsadji;
    }

    public void setTsadji(int tsadji) {
        this.tsadji = tsadji;
    }

    private int tsagi;

    @javax.persistence.Column(name = "TSAGI")
    @Basic
    public int getTsagi() {
        return tsagi;
    }

    public void setTsagi(int tsagi) {
        this.tsagi = tsagi;
    }

    private int tsfitx;

    @javax.persistence.Column(name = "TSFITX")
    @Basic
    public int getTsfitx() {
        return tsfitx;
    }

    public void setTsfitx(int tsfitx) {
        this.tsfitx = tsfitx;
    }

    private int tsfuel;

    @javax.persistence.Column(name = "TSFUEL")
    @Basic
    public int getTsfuel() {
        return tsfuel;
    }

    public void setTsfuel(int tsfuel) {
        this.tsfuel = tsfuel;
    }

    private int tsmed;

    @javax.persistence.Column(name = "TSMED")
    @Basic
    public int getTsmed() {
        return tsmed;
    }

    public void setTsmed(int tsmed) {
        this.tsmed = tsmed;
    }

    private int tsstx;

    @javax.persistence.Column(name = "TSSTX")
    @Basic
    public int getTsstx() {
        return tsstx;
    }

    public void setTsstx(int tsstx) {
        this.tsstx = tsstx;
    }

    private int tssira;

    @javax.persistence.Column(name = "TSSIRA")
    @Basic
    public int getTssira() {
        return tssira;
    }

    public void setTssira(int tssira) {
        this.tssira = tssira;
    }

    private int tseic;

    @javax.persistence.Column(name = "TSEIC")
    @Basic
    public int getTseic() {
        return tseic;
    }

    public void setTseic(int tseic) {
        this.tseic = tseic;
    }

    private int tscapg;

    @javax.persistence.Column(name = "TSCAPG")
    @Basic
    public int getTscapg() {
        return tscapg;
    }

    public void setTscapg(int tscapg) {
        this.tscapg = tscapg;
    }

    private int tscapg4;

    @javax.persistence.Column(name = "TSCAPG4")
    @Basic
    public int getTscapg4() {
        return tscapg4;
    }

    public void setTscapg4(int tscapg4) {
        this.tscapg4 = tscapg4;
    }

    private int tsmonti;

    @javax.persistence.Column(name = "TSMONTI")
    @Basic
    public int getTsmonti() {
        return tsmonti;
    }

    public void setTsmonti(int tsmonti) {
        this.tsmonti = tsmonti;
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

        Snf3Entity that = (Snf3Entity) o;

        if (tsadji != that.tsadji) return false;
        if (tsagi != that.tsagi) return false;
        if (tsalim != that.tsalim) return false;
        if (tsalmpd != that.tsalmpd) return false;
        if (tsbus != that.tsbus) return false;
        if (tscapg != that.tscapg) return false;
        if (tscapg4 != that.tscapg4) return false;
        if (tsdiv != that.tsdiv) return false;
        if (tsdivex != that.tsdivex) return false;
        if (tsdivn != that.tsdivn) return false;
        if (tsebex != that.tsebex) return false;
        if (tseic != that.tseic) return false;
        if (tsexemp != that.tsexemp) return false;
        if (tsfarm != that.tsfarm) return false;
        if (tsfiex != that.tsfiex) return false;
        if (tsfitx != that.tsfitx) return false;
        if (tsfuel != that.tsfuel) return false;
        if (tsint != that.tsint) return false;
        if (tsira != that.tsira) return false;
        if (tsiradt != that.tsiradt) return false;
        if (tskeogh != that.tskeogh) return false;
        if (tsmed != that.tsmed) return false;
        if (tsmonti != that.tsmonti) return false;
        if (tsoti != that.tsoti) return false;
        if (tspeno != that.tspeno) return false;
        if (tspent != that.tspent) return false;
        if (tspwag != that.tspwag) return false;
        if (tsrent != that.tsrent) return false;
        if (tsrfsl != that.tsrfsl) return false;
        if (tssira != that.tssira) return false;
        if (tsss != that.tsss) return false;
        if (tssstp != that.tssstp) return false;
        if (tsstx != that.tsstx) return false;
        if (tsswag != that.tsswag) return false;
        if (tstirad != that.tstirad) return false;
        if (tsunemt != that.tsunemt) return false;
        if (tswag != that.tswag) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
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
        result = 31 * result + tsexemp;
        result = 31 * result + tsdivex;
        result = 31 * result + tsswag;
        result = 31 * result + tspwag;
        result = 31 * result + tswag;
        result = 31 * result + tsint;
        result = 31 * result + tsdivn;
        result = 31 * result + tsdiv;
        result = 31 * result + tsrfsl;
        result = 31 * result + tsalim;
        result = 31 * result + tsbus;
        result = 31 * result + tsfiex;
        result = 31 * result + tspeno;
        result = 31 * result + tspent;
        result = 31 * result + tsrent;
        result = 31 * result + tsfarm;
        result = 31 * result + tsiradt;
        result = 31 * result + tsunemt;
        result = 31 * result + tsss;
        result = 31 * result + tssstp;
        result = 31 * result + tsoti;
        result = 31 * result + tsebex;
        result = 31 * result + tsira;
        result = 31 * result + tskeogh;
        result = 31 * result + tsalmpd;
        result = 31 * result + tstirad;
        result = 31 * result + tsadji;
        result = 31 * result + tsagi;
        result = 31 * result + tsfitx;
        result = 31 * result + tsfuel;
        result = 31 * result + tsmed;
        result = 31 * result + tsstx;
        result = 31 * result + tssira;
        result = 31 * result + tseic;
        result = 31 * result + tscapg;
        result = 31 * result + tscapg4;
        result = 31 * result + tsmonti;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
