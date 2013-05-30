package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/25/12
 * Time: 11:59 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "MEM", schema = "SIGMA", catalog = "")
@Entity
public class MemEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getMemkey();
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

    private String memkey;

    @javax.persistence.Column(name = "MEMKEY")
    @Id
    public String getMemkey() {
        return memkey;
    }

    public void setMemkey(String memkey) {
        this.memkey = memkey;
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

    private String dupkyid;

    @javax.persistence.Column(name = "DUPKYID")
    @Basic
    public String getDupkyid() {
        return dupkyid;
    }

    public void setDupkyid(String dupkyid) {
        this.dupkyid = dupkyid;
    }

    private String specode;

    @javax.persistence.Column(name = "SPECODE")
    @Basic
    public String getSpecode() {
        return specode;
    }

    public void setSpecode(String specode) {
        this.specode = specode;
    }

    private String letrkey;

    @javax.persistence.Column(name = "LETRKEY")
    @Basic
    public String getLetrkey() {
        return letrkey;
    }

    public void setLetrkey(String letrkey) {
        this.letrkey = letrkey;
    }

    private String statcd;

    @javax.persistence.Column(name = "STATCD")
    @Basic
    public String getStatcd() {
        return statcd;
    }

    public void setStatcd(String statcd) {
        this.statcd = statcd;
    }

    private BigInteger usecnt;

    @javax.persistence.Column(name = "USECNT")
    @Basic
    public BigInteger getUsecnt() {
        return usecnt;
    }

    public void setUsecnt(BigInteger usecnt) {
        this.usecnt = usecnt;
    }

    private String origntr;

    @javax.persistence.Column(name = "ORIGNTR")
    @Basic
    public String getOrigntr() {
        return origntr;
    }

    public void setOrigntr(String origntr) {
        this.origntr = origntr;
    }

    private String refnr;

    @javax.persistence.Column(name = "REFNR")
    @Basic
    public String getRefnr() {
        return refnr;
    }

    public void setRefnr(String refnr) {
        this.refnr = refnr;
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

    private String usr;

    @javax.persistence.Column(name = "USR")
    @Basic
    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    private String sitime;

    @javax.persistence.Column(name = "SITIME")
    @Basic
    public String getSitime() {
        return sitime;
    }

    public void setSitime(String sitime) {
        this.sitime = sitime;
    }

    private BigInteger revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public BigInteger getRevlev() {
        return revlev;
    }

    public void setRevlev(BigInteger revlev) {
        this.revlev = revlev;
    }

    private String initals;

    @javax.persistence.Column(name = "INITALS")
    @Basic
    public String getInitals() {
        return initals;
    }

    public void setInitals(String initals) {
        this.initals = initals;
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

    private String ucode;

    @javax.persistence.Column(name = "UCODE")
    @Basic
    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    private String statdtc;

    @javax.persistence.Column(name = "STATDTC")
    @Basic
    public String getStatdtc() {
        return statdtc;
    }

    public void setStatdtc(String statdtc) {
        this.statdtc = statdtc;
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

        MemEntity memEntity = (MemEntity) o;

        if (createc != null ? !createc.equals(memEntity.createc) : memEntity.createc != null) return false;
        if (dupkyid != null ? !dupkyid.equals(memEntity.dupkyid) : memEntity.dupkyid != null) return false;
        if (initals != null ? !initals.equals(memEntity.initals) : memEntity.initals != null) return false;
        if (instid != null ? !instid.equals(memEntity.instid) : memEntity.instid != null) return false;
        if (letrkey != null ? !letrkey.equals(memEntity.letrkey) : memEntity.letrkey != null) return false;
        if (mdesc != null ? !mdesc.equals(memEntity.mdesc) : memEntity.mdesc != null) return false;
        if (memkey != null ? !memkey.equals(memEntity.memkey) : memEntity.memkey != null) return false;
        if (module != null ? !module.equals(memEntity.module) : memEntity.module != null) return false;
        if (origntr != null ? !origntr.equals(memEntity.origntr) : memEntity.origntr != null) return false;
        if (procyr != null ? !procyr.equals(memEntity.procyr) : memEntity.procyr != null) return false;
        if (recid != null ? !recid.equals(memEntity.recid) : memEntity.recid != null) return false;
        if (recstat != null ? !recstat.equals(memEntity.recstat) : memEntity.recstat != null) return false;
        if (refnr != null ? !refnr.equals(memEntity.refnr) : memEntity.refnr != null) return false;
        if (revdtc != null ? !revdtc.equals(memEntity.revdtc) : memEntity.revdtc != null) return false;
        if (revlev != null ? !revlev.equals(memEntity.revlev) : memEntity.revlev != null) return false;
        if (sid != null ? !sid.equals(memEntity.sid) : memEntity.sid != null) return false;
        if (sitime != null ? !sitime.equals(memEntity.sitime) : memEntity.sitime != null) return false;
        if (specode != null ? !specode.equals(memEntity.specode) : memEntity.specode != null) return false;
        if (statcd != null ? !statcd.equals(memEntity.statcd) : memEntity.statcd != null) return false;
        if (statdtc != null ? !statdtc.equals(memEntity.statdtc) : memEntity.statdtc != null) return false;
        if (systid != null ? !systid.equals(memEntity.systid) : memEntity.systid != null) return false;
        if (ucode != null ? !ucode.equals(memEntity.ucode) : memEntity.ucode != null) return false;
        if (usecnt != null ? !usecnt.equals(memEntity.usecnt) : memEntity.usecnt != null) return false;
        if (usr != null ? !usr.equals(memEntity.usr) : memEntity.usr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (memkey != null ? memkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (systid != null ? systid.hashCode() : 0);
        result = 31 * result + (recid != null ? recid.hashCode() : 0);
        result = 31 * result + (dupkyid != null ? dupkyid.hashCode() : 0);
        result = 31 * result + (specode != null ? specode.hashCode() : 0);
        result = 31 * result + (letrkey != null ? letrkey.hashCode() : 0);
        result = 31 * result + (statcd != null ? statcd.hashCode() : 0);
        result = 31 * result + (usecnt != null ? usecnt.hashCode() : 0);
        result = 31 * result + (origntr != null ? origntr.hashCode() : 0);
        result = 31 * result + (refnr != null ? refnr.hashCode() : 0);
        result = 31 * result + (mdesc != null ? mdesc.hashCode() : 0);
        result = 31 * result + (usr != null ? usr.hashCode() : 0);
        result = 31 * result + (sitime != null ? sitime.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (statdtc != null ? statdtc.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
