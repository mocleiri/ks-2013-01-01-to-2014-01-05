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
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "AUB", schema = "SIGMA", catalog = "")
@Entity
public class AubEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getAubkey();
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

    private String aubkey;

    @javax.persistence.Column(name = "AUBKEY")
    @Id
    public String getAubkey() {
        return aubkey;
    }

    public void setAubkey(String aubkey) {
        this.aubkey = aubkey;
    }

    private String version;

    @javax.persistence.Column(name = "VERSION")
    @Basic
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    private String ubkey;

    @javax.persistence.Column(name = "UBKEY")
    @Basic
    public String getUbkey() {
        return ubkey;
    }

    public void setUbkey(String ubkey) {
        this.ubkey = ubkey;
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

    private String remkey;

    @javax.persistence.Column(name = "REMKEY")
    @Basic
    public String getRemkey() {
        return remkey;
    }

    public void setRemkey(String remkey) {
        this.remkey = remkey;
    }

    private String systcd;

    @javax.persistence.Column(name = "SYSTCD")
    @Basic
    public String getSystcd() {
        return systcd;
    }

    public void setSystcd(String systcd) {
        this.systcd = systcd;
    }

    private String filecd;

    @javax.persistence.Column(name = "FILECD")
    @Basic
    public String getFilecd() {
        return filecd;
    }

    public void setFilecd(String filecd) {
        this.filecd = filecd;
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

    private String revtime;

    @javax.persistence.Column(name = "REVTIME")
    @Basic
    public String getRevtime() {
        return revtime;
    }

    public void setRevtime(String revtime) {
        this.revtime = revtime;
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

    private String elevalb;

    @javax.persistence.Column(name = "ELEVALB")
    @Basic
    public String getElevalb() {
        return elevalb;
    }

    public void setElevalb(String elevalb) {
        this.elevalb = elevalb;
    }

    private String elevald;

    @javax.persistence.Column(name = "ELEVALD")
    @Basic
    public String getElevald() {
        return elevald;
    }

    public void setElevald(String elevald) {
        this.elevald = elevald;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AubEntity aubEntity = (AubEntity) o;

        if (aubkey != null ? !aubkey.equals(aubEntity.aubkey) : aubEntity.aubkey != null) return false;
        if (elename != null ? !elename.equals(aubEntity.elename) : aubEntity.elename != null) return false;
        if (elevalb != null ? !elevalb.equals(aubEntity.elevalb) : aubEntity.elevalb != null) return false;
        if (elevald != null ? !elevald.equals(aubEntity.elevald) : aubEntity.elevald != null) return false;
        if (filecd != null ? !filecd.equals(aubEntity.filecd) : aubEntity.filecd != null) return false;
        if (instid != null ? !instid.equals(aubEntity.instid) : aubEntity.instid != null) return false;
        if (procyr != null ? !procyr.equals(aubEntity.procyr) : aubEntity.procyr != null) return false;
        if (recstat != null ? !recstat.equals(aubEntity.recstat) : aubEntity.recstat != null) return false;
        if (remkey != null ? !remkey.equals(aubEntity.remkey) : aubEntity.remkey != null) return false;
        if (revdate != null ? !revdate.equals(aubEntity.revdate) : aubEntity.revdate != null) return false;
        if (revtime != null ? !revtime.equals(aubEntity.revtime) : aubEntity.revtime != null) return false;
        if (sid != null ? !sid.equals(aubEntity.sid) : aubEntity.sid != null) return false;
        if (systcd != null ? !systcd.equals(aubEntity.systcd) : aubEntity.systcd != null) return false;
        if (ubkey != null ? !ubkey.equals(aubEntity.ubkey) : aubEntity.ubkey != null) return false;
        if (version != null ? !version.equals(aubEntity.version) : aubEntity.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (aubkey != null ? aubkey.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (ubkey != null ? ubkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (remkey != null ? remkey.hashCode() : 0);
        result = 31 * result + (systcd != null ? systcd.hashCode() : 0);
        result = 31 * result + (filecd != null ? filecd.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (elename != null ? elename.hashCode() : 0);
        result = 31 * result + (elevalb != null ? elevalb.hashCode() : 0);
        result = 31 * result + (elevald != null ? elevald.hashCode() : 0);
        return result;
    }
}
