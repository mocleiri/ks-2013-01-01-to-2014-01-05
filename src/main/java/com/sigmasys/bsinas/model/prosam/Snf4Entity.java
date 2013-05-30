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
@javax.persistence.Table(name = "SNF4", schema = "SIGMA", catalog = "")
@Entity
public class Snf4Entity implements Identifiable {

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

    private int tnexemp;

    @javax.persistence.Column(name = "TNEXEMP")
    @Basic
    public int getTnexemp() {
        return tnexemp;
    }

    public void setTnexemp(int tnexemp) {
        this.tnexemp = tnexemp;
    }

    private int tndivex;

    @javax.persistence.Column(name = "TNDIVEX")
    @Basic
    public int getTndivex() {
        return tndivex;
    }

    public void setTndivex(int tndivex) {
        this.tndivex = tndivex;
    }

    private int tnfwag;

    @javax.persistence.Column(name = "TNFWAG")
    @Basic
    public int getTnfwag() {
        return tnfwag;
    }

    public void setTnfwag(int tnfwag) {
        this.tnfwag = tnfwag;
    }

    private int tnmwag;

    @javax.persistence.Column(name = "TNMWAG")
    @Basic
    public int getTnmwag() {
        return tnmwag;
    }

    public void setTnmwag(int tnmwag) {
        this.tnmwag = tnmwag;
    }

    private int tnwag;

    @javax.persistence.Column(name = "TNWAG")
    @Basic
    public int getTnwag() {
        return tnwag;
    }

    public void setTnwag(int tnwag) {
        this.tnwag = tnwag;
    }

    private int tnint;

    @javax.persistence.Column(name = "TNINT")
    @Basic
    public int getTnint() {
        return tnint;
    }

    public void setTnint(int tnint) {
        this.tnint = tnint;
    }

    private int tndivn;

    @javax.persistence.Column(name = "TNDIVN")
    @Basic
    public int getTndivn() {
        return tndivn;
    }

    public void setTndivn(int tndivn) {
        this.tndivn = tndivn;
    }

    private int tndiv;

    @javax.persistence.Column(name = "TNDIV")
    @Basic
    public int getTndiv() {
        return tndiv;
    }

    public void setTndiv(int tndiv) {
        this.tndiv = tndiv;
    }

    private int tnrfsl;

    @javax.persistence.Column(name = "TNRFSL")
    @Basic
    public int getTnrfsl() {
        return tnrfsl;
    }

    public void setTnrfsl(int tnrfsl) {
        this.tnrfsl = tnrfsl;
    }

    private int tnalim;

    @javax.persistence.Column(name = "TNALIM")
    @Basic
    public int getTnalim() {
        return tnalim;
    }

    public void setTnalim(int tnalim) {
        this.tnalim = tnalim;
    }

    private int tnbus;

    @javax.persistence.Column(name = "TNBUS")
    @Basic
    public int getTnbus() {
        return tnbus;
    }

    public void setTnbus(int tnbus) {
        this.tnbus = tnbus;
    }

    private int tnfiex;

    @javax.persistence.Column(name = "TNFIEX")
    @Basic
    public int getTnfiex() {
        return tnfiex;
    }

    public void setTnfiex(int tnfiex) {
        this.tnfiex = tnfiex;
    }

    private int tnpeno;

    @javax.persistence.Column(name = "TNPENO")
    @Basic
    public int getTnpeno() {
        return tnpeno;
    }

    public void setTnpeno(int tnpeno) {
        this.tnpeno = tnpeno;
    }

    private int tnpent;

    @javax.persistence.Column(name = "TNPENT")
    @Basic
    public int getTnpent() {
        return tnpent;
    }

    public void setTnpent(int tnpent) {
        this.tnpent = tnpent;
    }

    private int tnrent;

    @javax.persistence.Column(name = "TNRENT")
    @Basic
    public int getTnrent() {
        return tnrent;
    }

    public void setTnrent(int tnrent) {
        this.tnrent = tnrent;
    }

    private int tnfarm;

    @javax.persistence.Column(name = "TNFARM")
    @Basic
    public int getTnfarm() {
        return tnfarm;
    }

    public void setTnfarm(int tnfarm) {
        this.tnfarm = tnfarm;
    }

    private int tniradt;

    @javax.persistence.Column(name = "TNIRADT")
    @Basic
    public int getTniradt() {
        return tniradt;
    }

    public void setTniradt(int tniradt) {
        this.tniradt = tniradt;
    }

    private int tnunemt;

    @javax.persistence.Column(name = "TNUNEMT")
    @Basic
    public int getTnunemt() {
        return tnunemt;
    }

    public void setTnunemt(int tnunemt) {
        this.tnunemt = tnunemt;
    }

    private int tnss;

    @javax.persistence.Column(name = "TNSS")
    @Basic
    public int getTnss() {
        return tnss;
    }

    public void setTnss(int tnss) {
        this.tnss = tnss;
    }

    private int tnsstp;

    @javax.persistence.Column(name = "TNSSTP")
    @Basic
    public int getTnsstp() {
        return tnsstp;
    }

    public void setTnsstp(int tnsstp) {
        this.tnsstp = tnsstp;
    }

    private int tnoti;

    @javax.persistence.Column(name = "TNOTI")
    @Basic
    public int getTnoti() {
        return tnoti;
    }

    public void setTnoti(int tnoti) {
        this.tnoti = tnoti;
    }

    private int tnebex;

    @javax.persistence.Column(name = "TNEBEX")
    @Basic
    public int getTnebex() {
        return tnebex;
    }

    public void setTnebex(int tnebex) {
        this.tnebex = tnebex;
    }

    private int tnira;

    @javax.persistence.Column(name = "TNIRA")
    @Basic
    public int getTnira() {
        return tnira;
    }

    public void setTnira(int tnira) {
        this.tnira = tnira;
    }

    private int tnkeogh;

    @javax.persistence.Column(name = "TNKEOGH")
    @Basic
    public int getTnkeogh() {
        return tnkeogh;
    }

    public void setTnkeogh(int tnkeogh) {
        this.tnkeogh = tnkeogh;
    }

    private int tnalmpd;

    @javax.persistence.Column(name = "TNALMPD")
    @Basic
    public int getTnalmpd() {
        return tnalmpd;
    }

    public void setTnalmpd(int tnalmpd) {
        this.tnalmpd = tnalmpd;
    }

    private int tntirad;

    @javax.persistence.Column(name = "TNTIRAD")
    @Basic
    public int getTntirad() {
        return tntirad;
    }

    public void setTntirad(int tntirad) {
        this.tntirad = tntirad;
    }

    private int tnadji;

    @javax.persistence.Column(name = "TNADJI")
    @Basic
    public int getTnadji() {
        return tnadji;
    }

    public void setTnadji(int tnadji) {
        this.tnadji = tnadji;
    }

    private int tnagi;

    @javax.persistence.Column(name = "TNAGI")
    @Basic
    public int getTnagi() {
        return tnagi;
    }

    public void setTnagi(int tnagi) {
        this.tnagi = tnagi;
    }

    private int tnfitx;

    @javax.persistence.Column(name = "TNFITX")
    @Basic
    public int getTnfitx() {
        return tnfitx;
    }

    public void setTnfitx(int tnfitx) {
        this.tnfitx = tnfitx;
    }

    private int tnfuel;

    @javax.persistence.Column(name = "TNFUEL")
    @Basic
    public int getTnfuel() {
        return tnfuel;
    }

    public void setTnfuel(int tnfuel) {
        this.tnfuel = tnfuel;
    }

    private int tnmed;

    @javax.persistence.Column(name = "TNMED")
    @Basic
    public int getTnmed() {
        return tnmed;
    }

    public void setTnmed(int tnmed) {
        this.tnmed = tnmed;
    }

    private int tnstx;

    @javax.persistence.Column(name = "TNSTX")
    @Basic
    public int getTnstx() {
        return tnstx;
    }

    public void setTnstx(int tnstx) {
        this.tnstx = tnstx;
    }

    private int tnsira;

    @javax.persistence.Column(name = "TNSIRA")
    @Basic
    public int getTnsira() {
        return tnsira;
    }

    public void setTnsira(int tnsira) {
        this.tnsira = tnsira;
    }

    private int tneic;

    @javax.persistence.Column(name = "TNEIC")
    @Basic
    public int getTneic() {
        return tneic;
    }

    public void setTneic(int tneic) {
        this.tneic = tneic;
    }

    private int tncapg;

    @javax.persistence.Column(name = "TNCAPG")
    @Basic
    public int getTncapg() {
        return tncapg;
    }

    public void setTncapg(int tncapg) {
        this.tncapg = tncapg;
    }

    private int tncapg4;

    @javax.persistence.Column(name = "TNCAPG4")
    @Basic
    public int getTncapg4() {
        return tncapg4;
    }

    public void setTncapg4(int tncapg4) {
        this.tncapg4 = tncapg4;
    }

    private int tnmonti;

    @javax.persistence.Column(name = "TNMONTI")
    @Basic
    public int getTnmonti() {
        return tnmonti;
    }

    public void setTnmonti(int tnmonti) {
        this.tnmonti = tnmonti;
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

        Snf4Entity that = (Snf4Entity) o;

        if (tnadji != that.tnadji) return false;
        if (tnagi != that.tnagi) return false;
        if (tnalim != that.tnalim) return false;
        if (tnalmpd != that.tnalmpd) return false;
        if (tnbus != that.tnbus) return false;
        if (tncapg != that.tncapg) return false;
        if (tncapg4 != that.tncapg4) return false;
        if (tndiv != that.tndiv) return false;
        if (tndivex != that.tndivex) return false;
        if (tndivn != that.tndivn) return false;
        if (tnebex != that.tnebex) return false;
        if (tneic != that.tneic) return false;
        if (tnexemp != that.tnexemp) return false;
        if (tnfarm != that.tnfarm) return false;
        if (tnfiex != that.tnfiex) return false;
        if (tnfitx != that.tnfitx) return false;
        if (tnfuel != that.tnfuel) return false;
        if (tnfwag != that.tnfwag) return false;
        if (tnint != that.tnint) return false;
        if (tnira != that.tnira) return false;
        if (tniradt != that.tniradt) return false;
        if (tnkeogh != that.tnkeogh) return false;
        if (tnmed != that.tnmed) return false;
        if (tnmonti != that.tnmonti) return false;
        if (tnmwag != that.tnmwag) return false;
        if (tnoti != that.tnoti) return false;
        if (tnpeno != that.tnpeno) return false;
        if (tnpent != that.tnpent) return false;
        if (tnrent != that.tnrent) return false;
        if (tnrfsl != that.tnrfsl) return false;
        if (tnsira != that.tnsira) return false;
        if (tnss != that.tnss) return false;
        if (tnsstp != that.tnsstp) return false;
        if (tnstx != that.tnstx) return false;
        if (tntirad != that.tntirad) return false;
        if (tnunemt != that.tnunemt) return false;
        if (tnwag != that.tnwag) return false;
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
        result = 31 * result + tnexemp;
        result = 31 * result + tndivex;
        result = 31 * result + tnfwag;
        result = 31 * result + tnmwag;
        result = 31 * result + tnwag;
        result = 31 * result + tnint;
        result = 31 * result + tndivn;
        result = 31 * result + tndiv;
        result = 31 * result + tnrfsl;
        result = 31 * result + tnalim;
        result = 31 * result + tnbus;
        result = 31 * result + tnfiex;
        result = 31 * result + tnpeno;
        result = 31 * result + tnpent;
        result = 31 * result + tnrent;
        result = 31 * result + tnfarm;
        result = 31 * result + tniradt;
        result = 31 * result + tnunemt;
        result = 31 * result + tnss;
        result = 31 * result + tnsstp;
        result = 31 * result + tnoti;
        result = 31 * result + tnebex;
        result = 31 * result + tnira;
        result = 31 * result + tnkeogh;
        result = 31 * result + tnalmpd;
        result = 31 * result + tntirad;
        result = 31 * result + tnadji;
        result = 31 * result + tnagi;
        result = 31 * result + tnfitx;
        result = 31 * result + tnfuel;
        result = 31 * result + tnmed;
        result = 31 * result + tnstx;
        result = 31 * result + tnsira;
        result = 31 * result + tneic;
        result = 31 * result + tncapg;
        result = 31 * result + tncapg4;
        result = 31 * result + tnmonti;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
