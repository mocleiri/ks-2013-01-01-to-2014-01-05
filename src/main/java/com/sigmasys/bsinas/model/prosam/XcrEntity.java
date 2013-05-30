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
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "XCR", schema = "SIGMA", catalog = "")
@Entity
public class XcrEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getXcrkey();
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

    private String xcrkey;

    @javax.persistence.Column(name = "XCRKEY")
    @Id
    public String getXcrkey() {
        return xcrkey;
    }

    public void setXcrkey(String xcrkey) {
        this.xcrkey = xcrkey;
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

    private String cid;

    @javax.persistence.Column(name = "CID")
    @Basic
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    private String revdate;

    @javax.persistence.Column(name = "REVDATE")
    @Basic
    public String getRevdate() {
        return revdate;
    }

    public void setRevdate(String revdate) {
        this.revdate = revdate;
    }

    private BigDecimal revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public BigDecimal getRevlev() {
        return revlev;
    }

    public void setRevlev(BigDecimal revlev) {
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

    private String campus;

    @javax.persistence.Column(name = "CAMPUS")
    @Basic
    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    private String cdesc;

    @javax.persistence.Column(name = "CDESC")
    @Basic
    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    private BigDecimal cunit;

    @javax.persistence.Column(name = "CUNIT")
    @Basic
    public BigDecimal getCunit() {
        return cunit;
    }

    public void setCunit(BigDecimal cunit) {
        this.cunit = cunit;
    }

    private BigDecimal cfee;

    @javax.persistence.Column(name = "CFEE")
    @Basic
    public BigDecimal getCfee() {
        return cfee;
    }

    public void setCfee(BigDecimal cfee) {
        this.cfee = cfee;
    }

    private BigDecimal prgfee;

    @javax.persistence.Column(name = "PRGFEE")
    @Basic
    public BigDecimal getPrgfee() {
        return prgfee;
    }

    public void setPrgfee(BigDecimal prgfee) {
        this.prgfee = prgfee;
    }

    private BigDecimal ugcfee;

    @javax.persistence.Column(name = "UGCFEE")
    @Basic
    public BigDecimal getUgcfee() {
        return ugcfee;
    }

    public void setUgcfee(BigDecimal ugcfee) {
        this.ugcfee = ugcfee;
    }

    private BigDecimal grcfee;

    @javax.persistence.Column(name = "GRCFEE")
    @Basic
    public BigDecimal getGrcfee() {
        return grcfee;
    }

    public void setGrcfee(BigDecimal grcfee) {
        this.grcfee = grcfee;
    }

    private BigDecimal uglexp;

    @javax.persistence.Column(name = "UGLEXP")
    @Basic
    public BigDecimal getUglexp() {
        return uglexp;
    }

    public void setUglexp(BigDecimal uglexp) {
        this.uglexp = uglexp;
    }

    private BigDecimal grlexp;

    @javax.persistence.Column(name = "GRLEXP")
    @Basic
    public BigDecimal getGrlexp() {
        return grlexp;
    }

    public void setGrlexp(BigDecimal grlexp) {
        this.grlexp = grlexp;
    }

    private String cstatus;

    @javax.persistence.Column(name = "CSTATUS")
    @Basic
    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    private String sesscd;

    @javax.persistence.Column(name = "SESSCD")
    @Basic
    public String getSesscd() {
        return sesscd;
    }

    public void setSesscd(String sesscd) {
        this.sesscd = sesscd;
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

    private String enddate;

    @javax.persistence.Column(name = "ENDDATE")
    @Basic
    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    private String cendate;

    @javax.persistence.Column(name = "CENDATE")
    @Basic
    public String getCendate() {
        return cendate;
    }

    public void setCendate(String cendate) {
        this.cendate = cendate;
    }

    private String trvlflg;

    @javax.persistence.Column(name = "TRVLFLG")
    @Basic
    public String getTrvlflg() {
        return trvlflg;
    }

    public void setTrvlflg(String trvlflg) {
        this.trvlflg = trvlflg;
    }

    private String onlnflg;

    @javax.persistence.Column(name = "ONLNFLG")
    @Basic
    public String getOnlnflg() {
        return onlnflg;
    }

    public void setOnlnflg(String onlnflg) {
        this.onlnflg = onlnflg;
    }

    private String varuflg;

    @javax.persistence.Column(name = "VARUFLG")
    @Basic
    public String getVaruflg() {
        return varuflg;
    }

    public void setVaruflg(String varuflg) {
        this.varuflg = varuflg;
    }

    private BigDecimal numpar;

    @javax.persistence.Column(name = "NUMPAR")
    @Basic
    public BigDecimal getNumpar() {
        return numpar;
    }

    public void setNumpar(BigDecimal numpar) {
        this.numpar = numpar;
    }

    private BigDecimal usnr1;

    @javax.persistence.Column(name = "USNR1")
    @Basic
    public BigDecimal getUsnr1() {
        return usnr1;
    }

    public void setUsnr1(BigDecimal usnr1) {
        this.usnr1 = usnr1;
    }

    private BigDecimal usnr2;

    @javax.persistence.Column(name = "USNR2")
    @Basic
    public BigDecimal getUsnr2() {
        return usnr2;
    }

    public void setUsnr2(BigDecimal usnr2) {
        this.usnr2 = usnr2;
    }

    private BigDecimal usnr3;

    @javax.persistence.Column(name = "USNR3")
    @Basic
    public BigDecimal getUsnr3() {
        return usnr3;
    }

    public void setUsnr3(BigDecimal usnr3) {
        this.usnr3 = usnr3;
    }

    private String usrdt1;

    @javax.persistence.Column(name = "USRDT1")
    @Basic
    public String getUsrdt1() {
        return usrdt1;
    }

    public void setUsrdt1(String usrdt1) {
        this.usrdt1 = usrdt1;
    }

    private String usrdt2;

    @javax.persistence.Column(name = "USRDT2")
    @Basic
    public String getUsrdt2() {
        return usrdt2;
    }

    public void setUsrdt2(String usrdt2) {
        this.usrdt2 = usrdt2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XcrEntity xcrEntity = (XcrEntity) o;

        if (aidyr != null ? !aidyr.equals(xcrEntity.aidyr) : xcrEntity.aidyr != null) return false;
        if (begdate != null ? !begdate.equals(xcrEntity.begdate) : xcrEntity.begdate != null) return false;
        if (campus != null ? !campus.equals(xcrEntity.campus) : xcrEntity.campus != null) return false;
        if (cdesc != null ? !cdesc.equals(xcrEntity.cdesc) : xcrEntity.cdesc != null) return false;
        if (cendate != null ? !cendate.equals(xcrEntity.cendate) : xcrEntity.cendate != null) return false;
        if (cfee != null ? !cfee.equals(xcrEntity.cfee) : xcrEntity.cfee != null) return false;
        if (cid != null ? !cid.equals(xcrEntity.cid) : xcrEntity.cid != null) return false;
        if (crtdate != null ? !crtdate.equals(xcrEntity.crtdate) : xcrEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(xcrEntity.crtmod) : xcrEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(xcrEntity.crttime) : xcrEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(xcrEntity.crtuser) : xcrEntity.crtuser != null) return false;
        if (cstatus != null ? !cstatus.equals(xcrEntity.cstatus) : xcrEntity.cstatus != null) return false;
        if (cunit != null ? !cunit.equals(xcrEntity.cunit) : xcrEntity.cunit != null) return false;
        if (enddate != null ? !enddate.equals(xcrEntity.enddate) : xcrEntity.enddate != null) return false;
        if (grcfee != null ? !grcfee.equals(xcrEntity.grcfee) : xcrEntity.grcfee != null) return false;
        if (grlexp != null ? !grlexp.equals(xcrEntity.grlexp) : xcrEntity.grlexp != null) return false;
        if (numpar != null ? !numpar.equals(xcrEntity.numpar) : xcrEntity.numpar != null) return false;
        if (onlnflg != null ? !onlnflg.equals(xcrEntity.onlnflg) : xcrEntity.onlnflg != null) return false;
        if (prgfee != null ? !prgfee.equals(xcrEntity.prgfee) : xcrEntity.prgfee != null) return false;
        if (recstat != null ? !recstat.equals(xcrEntity.recstat) : xcrEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(xcrEntity.revdate) : xcrEntity.revdate != null) return false;
        if (revlev != null ? !revlev.equals(xcrEntity.revlev) : xcrEntity.revlev != null) return false;
        if (revmod != null ? !revmod.equals(xcrEntity.revmod) : xcrEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(xcrEntity.revtime) : xcrEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(xcrEntity.revuser) : xcrEntity.revuser != null) return false;
        if (sesscd != null ? !sesscd.equals(xcrEntity.sesscd) : xcrEntity.sesscd != null) return false;
        if (trvlflg != null ? !trvlflg.equals(xcrEntity.trvlflg) : xcrEntity.trvlflg != null) return false;
        if (ucode != null ? !ucode.equals(xcrEntity.ucode) : xcrEntity.ucode != null) return false;
        if (ugcfee != null ? !ugcfee.equals(xcrEntity.ugcfee) : xcrEntity.ugcfee != null) return false;
        if (uglexp != null ? !uglexp.equals(xcrEntity.uglexp) : xcrEntity.uglexp != null) return false;
        if (usnr1 != null ? !usnr1.equals(xcrEntity.usnr1) : xcrEntity.usnr1 != null) return false;
        if (usnr2 != null ? !usnr2.equals(xcrEntity.usnr2) : xcrEntity.usnr2 != null) return false;
        if (usnr3 != null ? !usnr3.equals(xcrEntity.usnr3) : xcrEntity.usnr3 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(xcrEntity.usrdt1) : xcrEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(xcrEntity.usrdt2) : xcrEntity.usrdt2 != null) return false;
        if (varuflg != null ? !varuflg.equals(xcrEntity.varuflg) : xcrEntity.varuflg != null) return false;
        if (xcrkey != null ? !xcrkey.equals(xcrEntity.xcrkey) : xcrEntity.xcrkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (xcrkey != null ? xcrkey.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (cdesc != null ? cdesc.hashCode() : 0);
        result = 31 * result + (cunit != null ? cunit.hashCode() : 0);
        result = 31 * result + (cfee != null ? cfee.hashCode() : 0);
        result = 31 * result + (prgfee != null ? prgfee.hashCode() : 0);
        result = 31 * result + (ugcfee != null ? ugcfee.hashCode() : 0);
        result = 31 * result + (grcfee != null ? grcfee.hashCode() : 0);
        result = 31 * result + (uglexp != null ? uglexp.hashCode() : 0);
        result = 31 * result + (grlexp != null ? grlexp.hashCode() : 0);
        result = 31 * result + (cstatus != null ? cstatus.hashCode() : 0);
        result = 31 * result + (sesscd != null ? sesscd.hashCode() : 0);
        result = 31 * result + (begdate != null ? begdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (cendate != null ? cendate.hashCode() : 0);
        result = 31 * result + (trvlflg != null ? trvlflg.hashCode() : 0);
        result = 31 * result + (onlnflg != null ? onlnflg.hashCode() : 0);
        result = 31 * result + (varuflg != null ? varuflg.hashCode() : 0);
        result = 31 * result + (numpar != null ? numpar.hashCode() : 0);
        result = 31 * result + (usnr1 != null ? usnr1.hashCode() : 0);
        result = 31 * result + (usnr2 != null ? usnr2.hashCode() : 0);
        result = 31 * result + (usnr3 != null ? usnr3.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (usrdt2 != null ? usrdt2.hashCode() : 0);
        return result;
    }
}
