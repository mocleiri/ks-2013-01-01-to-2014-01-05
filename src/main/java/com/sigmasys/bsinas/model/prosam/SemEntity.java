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
@javax.persistence.Table(name = "SEM", schema = "SIGMA", catalog = "")
@Entity
public class SemEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSemkey();
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

    private String semkey;

    @javax.persistence.Column(name = "SEMKEY")
    @Id
    public String getSemkey() {
        return semkey;
    }

    public void setSemkey(String semkey) {
        this.semkey = semkey;
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

    private String filname;

    @javax.persistence.Column(name = "FILNAME")
    @Basic
    public String getFilname() {
        return filname;
    }

    public void setFilname(String filname) {
        this.filname = filname;
    }

    private String elename;

    @javax.persistence.Column(name = "ELENAME")
    @Basic
    public String getElename() {
        return elename;
    }

    public void setElename(String elename) {
        this.elename = elename;
    }

    private int seqnum;

    @javax.persistence.Column(name = "SEQNUM")
    @Basic
    public int getSeqnum() {
        return seqnum;
    }

    public void setSeqnum(int seqnum) {
        this.seqnum = seqnum;
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

    private String elemask;

    @javax.persistence.Column(name = "ELEMASK")
    @Basic
    public String getElemask() {
        return elemask;
    }

    public void setElemask(String elemask) {
        this.elemask = elemask;
    }

    private String eleperm;

    @javax.persistence.Column(name = "ELEPERM")
    @Basic
    public String getEleperm() {
        return eleperm;
    }

    public void setEleperm(String eleperm) {
        this.eleperm = eleperm;
    }

    private String descrpt;

    @javax.persistence.Column(name = "DESCRPT")
    @Basic
    public String getDescrpt() {
        return descrpt;
    }

    public void setDescrpt(String descrpt) {
        this.descrpt = descrpt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SemEntity semEntity = (SemEntity) o;

        if (revlev != semEntity.revlev) return false;
        if (seqnum != semEntity.seqnum) return false;
        if (acsrole != null ? !acsrole.equals(semEntity.acsrole) : semEntity.acsrole != null) return false;
        if (crtdtec != null ? !crtdtec.equals(semEntity.crtdtec) : semEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(semEntity.crtmod) : semEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(semEntity.crttime) : semEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(semEntity.crtuser) : semEntity.crtuser != null) return false;
        if (descrpt != null ? !descrpt.equals(semEntity.descrpt) : semEntity.descrpt != null) return false;
        if (elemask != null ? !elemask.equals(semEntity.elemask) : semEntity.elemask != null) return false;
        if (elename != null ? !elename.equals(semEntity.elename) : semEntity.elename != null) return false;
        if (eleperm != null ? !eleperm.equals(semEntity.eleperm) : semEntity.eleperm != null) return false;
        if (filname != null ? !filname.equals(semEntity.filname) : semEntity.filname != null) return false;
        if (instid != null ? !instid.equals(semEntity.instid) : semEntity.instid != null) return false;
        if (recstat != null ? !recstat.equals(semEntity.recstat) : semEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(semEntity.revdtec) : semEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(semEntity.revmod) : semEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(semEntity.revtime) : semEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(semEntity.revuser) : semEntity.revuser != null) return false;
        if (semkey != null ? !semkey.equals(semEntity.semkey) : semEntity.semkey != null) return false;
        if (system != null ? !system.equals(semEntity.system) : semEntity.system != null) return false;
        if (ucode != null ? !ucode.equals(semEntity.ucode) : semEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (semkey != null ? semkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (acsrole != null ? acsrole.hashCode() : 0);
        result = 31 * result + (filname != null ? filname.hashCode() : 0);
        result = 31 * result + (elename != null ? elename.hashCode() : 0);
        result = 31 * result + seqnum;
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
        result = 31 * result + (elemask != null ? elemask.hashCode() : 0);
        result = 31 * result + (eleperm != null ? eleperm.hashCode() : 0);
        result = 31 * result + (descrpt != null ? descrpt.hashCode() : 0);
        return result;
    }
}
