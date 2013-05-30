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
@javax.persistence.Table(name = "MEH", schema = "SIGMA", catalog = "")
@Entity
public class MehEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getMehkey();
    }

    private String mehkey;

    @javax.persistence.Column(name = "MEHKEY")
    @Id
    public String getMehkey() {
        return mehkey;
    }

    public void setMehkey(String mehkey) {
        this.mehkey = mehkey;
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

    private String crtcd1;

    @javax.persistence.Column(name = "CRTCD1")
    @Basic
    public String getCrtcd1() {
        return crtcd1;
    }

    public void setCrtcd1(String crtcd1) {
        this.crtcd1 = crtcd1;
    }

    private String crtcd2;

    @javax.persistence.Column(name = "CRTCD2")
    @Basic
    public String getCrtcd2() {
        return crtcd2;
    }

    public void setCrtcd2(String crtcd2) {
        this.crtcd2 = crtcd2;
    }

    private String crtcd3;

    @javax.persistence.Column(name = "CRTCD3")
    @Basic
    public String getCrtcd3() {
        return crtcd3;
    }

    public void setCrtcd3(String crtcd3) {
        this.crtcd3 = crtcd3;
    }

    private String crtcd4;

    @javax.persistence.Column(name = "CRTCD4")
    @Basic
    public String getCrtcd4() {
        return crtcd4;
    }

    public void setCrtcd4(String crtcd4) {
        this.crtcd4 = crtcd4;
    }

    private String crtcd5;

    @javax.persistence.Column(name = "CRTCD5")
    @Basic
    public String getCrtcd5() {
        return crtcd5;
    }

    public void setCrtcd5(String crtcd5) {
        this.crtcd5 = crtcd5;
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

    private String statdtc;

    @javax.persistence.Column(name = "STATDTC")
    @Basic
    public String getStatdtc() {
        return statdtc;
    }

    public void setStatdtc(String statdtc) {
        this.statdtc = statdtc;
    }

    private String mhdesc;

    @javax.persistence.Column(name = "MHDESC")
    @Basic
    public String getMhdesc() {
        return mhdesc;
    }

    public void setMhdesc(String mhdesc) {
        this.mhdesc = mhdesc;
    }

    private int nrlines;

    @javax.persistence.Column(name = "NRLINES")
    @Basic
    public int getNrlines() {
        return nrlines;
    }

    public void setNrlines(int nrlines) {
        this.nrlines = nrlines;
    }

    private int nrkywds;

    @javax.persistence.Column(name = "NRKYWDS")
    @Basic
    public int getNrkywds() {
        return nrkywds;
    }

    public void setNrkywds(int nrkywds) {
        this.nrkywds = nrkywds;
    }

    private String wftrig;

    @javax.persistence.Column(name = "WFTRIG")
    @Basic
    public String getWftrig() {
        return wftrig;
    }

    public void setWftrig(String wftrig) {
        this.wftrig = wftrig;
    }

    private String rlock;

    @javax.persistence.Column(name = "RLOCK")
    @Basic
    public String getRlock() {
        return rlock;
    }

    public void setRlock(String rlock) {
        this.rlock = rlock;
    }

    private String owner;

    @javax.persistence.Column(name = "OWNER")
    @Basic
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    private String letrtyp;

    @javax.persistence.Column(name = "LETRTYP")
    @Basic
    public String getLetrtyp() {
        return letrtyp;
    }

    public void setLetrtyp(String letrtyp) {
        this.letrtyp = letrtyp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MehEntity mehEntity = (MehEntity) o;

        if (nrkywds != mehEntity.nrkywds) return false;
        if (nrlines != mehEntity.nrlines) return false;
        if (revlev != mehEntity.revlev) return false;
        if (crtcd1 != null ? !crtcd1.equals(mehEntity.crtcd1) : mehEntity.crtcd1 != null) return false;
        if (crtcd2 != null ? !crtcd2.equals(mehEntity.crtcd2) : mehEntity.crtcd2 != null) return false;
        if (crtcd3 != null ? !crtcd3.equals(mehEntity.crtcd3) : mehEntity.crtcd3 != null) return false;
        if (crtcd4 != null ? !crtcd4.equals(mehEntity.crtcd4) : mehEntity.crtcd4 != null) return false;
        if (crtcd5 != null ? !crtcd5.equals(mehEntity.crtcd5) : mehEntity.crtcd5 != null) return false;
        if (crtdate != null ? !crtdate.equals(mehEntity.crtdate) : mehEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(mehEntity.crtmod) : mehEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(mehEntity.crttime) : mehEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(mehEntity.crtuser) : mehEntity.crtuser != null) return false;
        if (instid != null ? !instid.equals(mehEntity.instid) : mehEntity.instid != null) return false;
        if (keydt != null ? !keydt.equals(mehEntity.keydt) : mehEntity.keydt != null) return false;
        if (letrtyp != null ? !letrtyp.equals(mehEntity.letrtyp) : mehEntity.letrtyp != null) return false;
        if (mehkey != null ? !mehkey.equals(mehEntity.mehkey) : mehEntity.mehkey != null) return false;
        if (mhdesc != null ? !mhdesc.equals(mehEntity.mhdesc) : mehEntity.mhdesc != null) return false;
        if (origntr != null ? !origntr.equals(mehEntity.origntr) : mehEntity.origntr != null) return false;
        if (owner != null ? !owner.equals(mehEntity.owner) : mehEntity.owner != null) return false;
        if (procyr != null ? !procyr.equals(mehEntity.procyr) : mehEntity.procyr != null) return false;
        if (recid != null ? !recid.equals(mehEntity.recid) : mehEntity.recid != null) return false;
        if (refnr != null ? !refnr.equals(mehEntity.refnr) : mehEntity.refnr != null) return false;
        if (revdate != null ? !revdate.equals(mehEntity.revdate) : mehEntity.revdate != null) return false;
        if (revmod != null ? !revmod.equals(mehEntity.revmod) : mehEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(mehEntity.revtime) : mehEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(mehEntity.revuser) : mehEntity.revuser != null) return false;
        if (rlock != null ? !rlock.equals(mehEntity.rlock) : mehEntity.rlock != null) return false;
        if (seqnr != null ? !seqnr.equals(mehEntity.seqnr) : mehEntity.seqnr != null) return false;
        if (sid != null ? !sid.equals(mehEntity.sid) : mehEntity.sid != null) return false;
        if (sitime != null ? !sitime.equals(mehEntity.sitime) : mehEntity.sitime != null) return false;
        if (statcd != null ? !statcd.equals(mehEntity.statcd) : mehEntity.statcd != null) return false;
        if (statdtc != null ? !statdtc.equals(mehEntity.statdtc) : mehEntity.statdtc != null) return false;
        if (systid != null ? !systid.equals(mehEntity.systid) : mehEntity.systid != null) return false;
        if (ucode != null ? !ucode.equals(mehEntity.ucode) : mehEntity.ucode != null) return false;
        if (usecnt != null ? !usecnt.equals(mehEntity.usecnt) : mehEntity.usecnt != null) return false;
        if (wftrig != null ? !wftrig.equals(mehEntity.wftrig) : mehEntity.wftrig != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mehkey != null ? mehkey.hashCode() : 0;
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
        result = 31 * result + (statcd != null ? statcd.hashCode() : 0);
        result = 31 * result + (usecnt != null ? usecnt.hashCode() : 0);
        result = 31 * result + (origntr != null ? origntr.hashCode() : 0);
        result = 31 * result + (refnr != null ? refnr.hashCode() : 0);
        result = 31 * result + (crtcd1 != null ? crtcd1.hashCode() : 0);
        result = 31 * result + (crtcd2 != null ? crtcd2.hashCode() : 0);
        result = 31 * result + (crtcd3 != null ? crtcd3.hashCode() : 0);
        result = 31 * result + (crtcd4 != null ? crtcd4.hashCode() : 0);
        result = 31 * result + (crtcd5 != null ? crtcd5.hashCode() : 0);
        result = 31 * result + (sitime != null ? sitime.hashCode() : 0);
        result = 31 * result + (statdtc != null ? statdtc.hashCode() : 0);
        result = 31 * result + (mhdesc != null ? mhdesc.hashCode() : 0);
        result = 31 * result + nrlines;
        result = 31 * result + nrkywds;
        result = 31 * result + (wftrig != null ? wftrig.hashCode() : 0);
        result = 31 * result + (rlock != null ? rlock.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (letrtyp != null ? letrtyp.hashCode() : 0);
        return result;
    }
}
