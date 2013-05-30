package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Clob;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/26/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SDE", schema = "SIGMA", catalog = "")
@Entity
public class SdeEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSdekey();
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

    private String sdekey;

    @javax.persistence.Column(name = "SDEKEY")
    @Id
    public String getSdekey() {
        return sdekey;
    }

    public void setSdekey(String sdekey) {
        this.sdekey = sdekey;
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

    private String module;

    @javax.persistence.Column(name = "MODULE")
    @Basic
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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

    private BigDecimal revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public BigDecimal getRevlev() {
        return revlev;
    }

    public void setRevlev(BigDecimal revlev) {
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

    private Clob dedacs;

    @javax.persistence.Column(name = "DEDACS")
    @Lob
    @Basic
    public Clob getDedacs() {
        return dedacs;
    }

    public void setDedacs(Clob dedacs) {
        this.dedacs = dedacs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SdeEntity sdeEntity = (SdeEntity) o;

        if (acsrole != null ? !acsrole.equals(sdeEntity.acsrole) : sdeEntity.acsrole != null) return false;
        if (crtdtec != null ? !crtdtec.equals(sdeEntity.crtdtec) : sdeEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(sdeEntity.crtmod) : sdeEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(sdeEntity.crttime) : sdeEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(sdeEntity.crtuser) : sdeEntity.crtuser != null) return false;
        if (dedacs != null ? !dedacs.equals(sdeEntity.dedacs) : sdeEntity.dedacs != null) return false;
        if (instid != null ? !instid.equals(sdeEntity.instid) : sdeEntity.instid != null) return false;
        if (module != null ? !module.equals(sdeEntity.module) : sdeEntity.module != null) return false;
        if (recstat != null ? !recstat.equals(sdeEntity.recstat) : sdeEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(sdeEntity.revdtec) : sdeEntity.revdtec != null) return false;
        if (revlev != null ? !revlev.equals(sdeEntity.revlev) : sdeEntity.revlev != null) return false;
        if (revmod != null ? !revmod.equals(sdeEntity.revmod) : sdeEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(sdeEntity.revtime) : sdeEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(sdeEntity.revuser) : sdeEntity.revuser != null) return false;
        if (sdekey != null ? !sdekey.equals(sdeEntity.sdekey) : sdeEntity.sdekey != null) return false;
        if (system != null ? !system.equals(sdeEntity.system) : sdeEntity.system != null) return false;
        if (ucode != null ? !ucode.equals(sdeEntity.ucode) : sdeEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (sdekey != null ? sdekey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (acsrole != null ? acsrole.hashCode() : 0);
        result = 31 * result + (crtdtec != null ? crtdtec.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (dedacs != null ? dedacs.hashCode() : 0);
        return result;
    }
}
