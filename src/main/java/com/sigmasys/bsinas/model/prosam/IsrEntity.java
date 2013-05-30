package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.*;
import java.sql.Clob;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/25/12
 * Time: 11:59 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "ISR", schema = "SIGMA", catalog = "")
@Entity
public class IsrEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getIsrkey();
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

    private String isrkey;

    @javax.persistence.Column(name = "ISRKEY")
    @Id
    public String getIsrkey() {
        return isrkey;
    }

    public void setIsrkey(String isrkey) {
        this.isrkey = isrkey;
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

    private String aidyr;

    @javax.persistence.Column(name = "AIDYR")
    @Basic
    public String getAidyr() {
        return aidyr;
    }

    public void setAidyr(String aidyr) {
        this.aidyr = aidyr;
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

    private String trannr;

    @javax.persistence.Column(name = "TRANNR")
    @Basic
    public String getTrannr() {
        return trannr;
    }

    public void setTrannr(String trannr) {
        this.trannr = trannr;
    }

    private String rsrvd1;

    @javax.persistence.Column(name = "RSRVD1")
    @Basic
    public String getRsrvd1() {
        return rsrvd1;
    }

    public void setRsrvd1(String rsrvd1) {
        this.rsrvd1 = rsrvd1;
    }

    private String origssn;

    @javax.persistence.Column(name = "ORIGSSN")
    @Basic
    public String getOrigssn() {
        return origssn;
    }

    public void setOrigssn(String origssn) {
        this.origssn = origssn;
    }

    private String nameid;

    @javax.persistence.Column(name = "NAMEID")
    @Basic
    public String getNameid() {
        return nameid;
    }

    public void setNameid(String nameid) {
        this.nameid = nameid;
    }

    private String crtdtec;

    @javax.persistence.Column(name = "CRTDTEC")
    @Basic
    public String getCrtdtec() {
        return crtdtec;
    }

    public void setCrtdtec(String crtdtec) {
        this.crtdtec = crtdtec;
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

    private String crtmod;

    @javax.persistence.Column(name = "CRTMOD")
    @Basic
    public String getCrtmod() {
        return crtmod;
    }

    public void setCrtmod(String crtmod) {
        this.crtmod = crtmod;
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

    private String revdtec;

    @javax.persistence.Column(name = "REVDTEC")
    @Basic
    public String getRevdtec() {
        return revdtec;
    }

    public void setRevdtec(String revdtec) {
        this.revdtec = revdtec;
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

    private String revmod;

    @javax.persistence.Column(name = "REVMOD")
    @Basic
    public String getRevmod() {
        return revmod;
    }

    public void setRevmod(String revmod) {
        this.revmod = revmod;
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

    private String ucode;

    @javax.persistence.Column(name = "UCODE")
    @Basic
    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    private Clob isrrec;

    @javax.persistence.Column(name = "ISRREC")
    @Lob
    @Basic
    public Clob getIsrrec() {
        return isrrec;
    }

    public void setIsrrec(Clob isrrec) {
        this.isrrec = isrrec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IsrEntity isrEntity = (IsrEntity) o;

        if (revlev != isrEntity.revlev) return false;
        if (aidyr != null ? !aidyr.equals(isrEntity.aidyr) : isrEntity.aidyr != null) return false;
        if (crtdtec != null ? !crtdtec.equals(isrEntity.crtdtec) : isrEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(isrEntity.crtmod) : isrEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(isrEntity.crttime) : isrEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(isrEntity.crtuser) : isrEntity.crtuser != null) return false;
        if (instid != null ? !instid.equals(isrEntity.instid) : isrEntity.instid != null) return false;
        if (isrkey != null ? !isrkey.equals(isrEntity.isrkey) : isrEntity.isrkey != null) return false;
        if (isrrec != null ? !isrrec.equals(isrEntity.isrrec) : isrEntity.isrrec != null) return false;
        if (nameid != null ? !nameid.equals(isrEntity.nameid) : isrEntity.nameid != null) return false;
        if (origssn != null ? !origssn.equals(isrEntity.origssn) : isrEntity.origssn != null) return false;
        if (recstat != null ? !recstat.equals(isrEntity.recstat) : isrEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(isrEntity.revdtec) : isrEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(isrEntity.revmod) : isrEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(isrEntity.revtime) : isrEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(isrEntity.revuser) : isrEntity.revuser != null) return false;
        if (rsrvd1 != null ? !rsrvd1.equals(isrEntity.rsrvd1) : isrEntity.rsrvd1 != null) return false;
        if (sid != null ? !sid.equals(isrEntity.sid) : isrEntity.sid != null) return false;
        if (trannr != null ? !trannr.equals(isrEntity.trannr) : isrEntity.trannr != null) return false;
        if (ucode != null ? !ucode.equals(isrEntity.ucode) : isrEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (isrkey != null ? isrkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (trannr != null ? trannr.hashCode() : 0);
        result = 31 * result + (rsrvd1 != null ? rsrvd1.hashCode() : 0);
        result = 31 * result + (origssn != null ? origssn.hashCode() : 0);
        result = 31 * result + (nameid != null ? nameid.hashCode() : 0);
        result = 31 * result + (crtdtec != null ? crtdtec.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (isrrec != null ? isrrec.hashCode() : 0);
        return result;
    }
}
