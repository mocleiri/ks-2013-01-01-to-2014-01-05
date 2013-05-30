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
@javax.persistence.Table(name = "SUB", schema = "SIGMA", catalog = "")
@Entity
public class SubEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSubkey();
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

    private String subkey;

    @javax.persistence.Column(name = "SUBKEY")
    @Id
    public String getSubkey() {
        return subkey;
    }

    public void setSubkey(String subkey) {
        this.subkey = subkey;
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

    private String type;

    @javax.persistence.Column(name = "TYPE")
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    private String descript;

    @javax.persistence.Column(name = "DESCRIPT")
    @Basic
    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    private String budflag;

    @javax.persistence.Column(name = "BUDFLAG")
    @Basic
    public String getBudflag() {
        return budflag;
    }

    public void setBudflag(String budflag) {
        this.budflag = budflag;
    }

    private String tddexp;

    @javax.persistence.Column(name = "TDDEXP")
    @Basic
    public String getTddexp() {
        return tddexp;
    }

    public void setTddexp(String tddexp) {
        this.tddexp = tddexp;
    }

    private BigDecimal ovramt;

    @javax.persistence.Column(name = "OVRAMT")
    @Basic
    public BigDecimal getOvramt() {
        return ovramt;
    }

    public void setOvramt(BigDecimal ovramt) {
        this.ovramt = ovramt;
    }

    private BigDecimal amount;

    @javax.persistence.Column(name = "AMOUNT")
    @Basic
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubEntity subEntity = (SubEntity) o;

        if (revlev != subEntity.revlev) return false;
        if (aidyr != null ? !aidyr.equals(subEntity.aidyr) : subEntity.aidyr != null) return false;
        if (amount != null ? !amount.equals(subEntity.amount) : subEntity.amount != null) return false;
        if (budflag != null ? !budflag.equals(subEntity.budflag) : subEntity.budflag != null) return false;
        if (budlck != null ? !budlck.equals(subEntity.budlck) : subEntity.budlck != null) return false;
        if (crtdate != null ? !crtdate.equals(subEntity.crtdate) : subEntity.crtdate != null) return false;
        if (crttime != null ? !crttime.equals(subEntity.crttime) : subEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(subEntity.crtuser) : subEntity.crtuser != null) return false;
        if (descript != null ? !descript.equals(subEntity.descript) : subEntity.descript != null) return false;
        if (ovramt != null ? !ovramt.equals(subEntity.ovramt) : subEntity.ovramt != null) return false;
        if (recstat != null ? !recstat.equals(subEntity.recstat) : subEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(subEntity.revdate) : subEntity.revdate != null) return false;
        if (revmod != null ? !revmod.equals(subEntity.revmod) : subEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(subEntity.revtime) : subEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(subEntity.revuser) : subEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(subEntity.sid) : subEntity.sid != null) return false;
        if (subkey != null ? !subkey.equals(subEntity.subkey) : subEntity.subkey != null) return false;
        if (tddexp != null ? !tddexp.equals(subEntity.tddexp) : subEntity.tddexp != null) return false;
        if (term != null ? !term.equals(subEntity.term) : subEntity.term != null) return false;
        if (type != null ? !type.equals(subEntity.type) : subEntity.type != null) return false;
        if (ucode != null ? !ucode.equals(subEntity.ucode) : subEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (subkey != null ? subkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (descript != null ? descript.hashCode() : 0);
        result = 31 * result + (budflag != null ? budflag.hashCode() : 0);
        result = 31 * result + (tddexp != null ? tddexp.hashCode() : 0);
        result = 31 * result + (ovramt != null ? ovramt.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (budlck != null ? budlck.hashCode() : 0);
        return result;
    }
}
