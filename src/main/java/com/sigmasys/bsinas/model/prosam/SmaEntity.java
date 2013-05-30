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
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SMA", schema = "SIGMA", catalog = "")
@Entity
public class SmaEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSmakey();
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

    private String smakey;

    @javax.persistence.Column(name = "SMAKEY")
    @Id
    public String getSmakey() {
        return smakey;
    }

    public void setSmakey(String smakey) {
        this.smakey = smakey;
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

    private String system;

    @javax.persistence.Column(name = "SYSTEM")
    @Basic
    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    private String acsrole;

    @javax.persistence.Column(name = "ACSROLE")
    @Basic
    public String getAcsrole() {
        return acsrole;
    }

    public void setAcsrole(String acsrole) {
        this.acsrole = acsrole;
    }

    private String modcode;

    @javax.persistence.Column(name = "MODCODE")
    @Basic
    public String getModcode() {
        return modcode;
    }

    public void setModcode(String modcode) {
        this.modcode = modcode;
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

    private String acscod;

    @javax.persistence.Column(name = "ACSCOD")
    @Basic
    public String getAcscod() {
        return acscod;
    }

    public void setAcscod(String acscod) {
        this.acscod = acscod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmaEntity smaEntity = (SmaEntity) o;

        if (revlev != smaEntity.revlev) return false;
        if (acscod != null ? !acscod.equals(smaEntity.acscod) : smaEntity.acscod != null) return false;
        if (acsrole != null ? !acsrole.equals(smaEntity.acsrole) : smaEntity.acsrole != null) return false;
        if (crtdtec != null ? !crtdtec.equals(smaEntity.crtdtec) : smaEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(smaEntity.crtmod) : smaEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(smaEntity.crttime) : smaEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(smaEntity.crtuser) : smaEntity.crtuser != null) return false;
        if (instid != null ? !instid.equals(smaEntity.instid) : smaEntity.instid != null) return false;
        if (modcode != null ? !modcode.equals(smaEntity.modcode) : smaEntity.modcode != null) return false;
        if (recstat != null ? !recstat.equals(smaEntity.recstat) : smaEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(smaEntity.revdtec) : smaEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(smaEntity.revmod) : smaEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(smaEntity.revtime) : smaEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(smaEntity.revuser) : smaEntity.revuser != null) return false;
        if (smakey != null ? !smakey.equals(smaEntity.smakey) : smaEntity.smakey != null) return false;
        if (system != null ? !system.equals(smaEntity.system) : smaEntity.system != null) return false;
        if (ucode != null ? !ucode.equals(smaEntity.ucode) : smaEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (smakey != null ? smakey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (acsrole != null ? acsrole.hashCode() : 0);
        result = 31 * result + (modcode != null ? modcode.hashCode() : 0);
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
        result = 31 * result + (acscod != null ? acscod.hashCode() : 0);
        return result;
    }
}
