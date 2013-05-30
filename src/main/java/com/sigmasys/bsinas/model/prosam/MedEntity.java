package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/25/12
 * Time: 11:59 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "MED", schema = "SIGMA", catalog = "")
@Entity
public class MedEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getMedkey();
    }

    private String medkey;

    @javax.persistence.Column(name = "MEDKEY")
    @Id
    public String getMedkey() {
        return medkey;
    }

    public void setMedkey(String medkey) {
        this.medkey = medkey;
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

    private String procyr;

    @javax.persistence.Column(name = "PROCYR")
    @Basic
    public String getProcyr() {
        return procyr;
    }

    public void setProcyr(String procyr) {
        this.procyr = procyr;
    }

    private String systid;

    @javax.persistence.Column(name = "SYSTID")
    @Basic
    public String getSystid() {
        return systid;
    }

    public void setSystid(String systid) {
        this.systid = systid;
    }

    private String recid;

    @javax.persistence.Column(name = "RECID")
    @Basic
    public String getRecid() {
        return recid;
    }

    public void setRecid(String recid) {
        this.recid = recid;
    }

    private String keydt;

    @javax.persistence.Column(name = "KEYDT")
    @Basic
    public String getKeydt() {
        return keydt;
    }

    public void setKeydt(String keydt) {
        this.keydt = keydt;
    }

    private String seqnr;

    @javax.persistence.Column(name = "SEQNR")
    @Basic
    public String getSeqnr() {
        return seqnr;
    }

    public void setSeqnr(String seqnr) {
        this.seqnr = seqnr;
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

    private String mdesc;

    @javax.persistence.Column(name = "MDESC")
    @Basic
    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedEntity medEntity = (MedEntity) o;

        if (revlev != medEntity.revlev) return false;
        if (crtdate != null ? !crtdate.equals(medEntity.crtdate) : medEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(medEntity.crtmod) : medEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(medEntity.crttime) : medEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(medEntity.crtuser) : medEntity.crtuser != null) return false;
        if (instid != null ? !instid.equals(medEntity.instid) : medEntity.instid != null) return false;
        if (keydt != null ? !keydt.equals(medEntity.keydt) : medEntity.keydt != null) return false;
        if (mdesc != null ? !mdesc.equals(medEntity.mdesc) : medEntity.mdesc != null) return false;
        if (medkey != null ? !medkey.equals(medEntity.medkey) : medEntity.medkey != null) return false;
        if (procyr != null ? !procyr.equals(medEntity.procyr) : medEntity.procyr != null) return false;
        if (recid != null ? !recid.equals(medEntity.recid) : medEntity.recid != null) return false;
        if (revdate != null ? !revdate.equals(medEntity.revdate) : medEntity.revdate != null) return false;
        if (revmod != null ? !revmod.equals(medEntity.revmod) : medEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(medEntity.revtime) : medEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(medEntity.revuser) : medEntity.revuser != null) return false;
        if (seqnr != null ? !seqnr.equals(medEntity.seqnr) : medEntity.seqnr != null) return false;
        if (sid != null ? !sid.equals(medEntity.sid) : medEntity.sid != null) return false;
        if (systid != null ? !systid.equals(medEntity.systid) : medEntity.systid != null) return false;
        if (ucode != null ? !ucode.equals(medEntity.ucode) : medEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = medkey != null ? medkey.hashCode() : 0;
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (systid != null ? systid.hashCode() : 0);
        result = 31 * result + (recid != null ? recid.hashCode() : 0);
        result = 31 * result + (keydt != null ? keydt.hashCode() : 0);
        result = 31 * result + (seqnr != null ? seqnr.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (mdesc != null ? mdesc.hashCode() : 0);
        return result;
    }
}
