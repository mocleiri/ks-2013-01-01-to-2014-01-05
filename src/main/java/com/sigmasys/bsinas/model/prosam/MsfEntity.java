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
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "MSF", schema = "SIGMA", catalog = "")
@Entity
public class MsfEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getMsfkey();
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

    private String msfkey;

    @javax.persistence.Column(name = "MSFKEY")
    @Id
    public String getMsfkey() {
        return msfkey;
    }

    public void setMsfkey(String msfkey) {
        this.msfkey = msfkey;
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

    private String mfid;

    @javax.persistence.Column(name = "MFID")
    @Basic
    public String getMfid() {
        return mfid;
    }

    public void setMfid(String mfid) {
        this.mfid = mfid;
    }

    private String crtdte;

    @javax.persistence.Column(name = "CRTDTE")
    @Basic
    public String getCrtdte() {
        return crtdte;
    }

    public void setCrtdte(String crtdte) {
        this.crtdte = crtdte;
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

    private String crtpgm;

    @javax.persistence.Column(name = "CRTPGM")
    @Basic
    public String getCrtpgm() {
        return crtpgm;
    }

    public void setCrtpgm(String crtpgm) {
        this.crtpgm = crtpgm;
    }

    private String revdte;

    @javax.persistence.Column(name = "REVDTE")
    @Basic
    public String getRevdte() {
        return revdte;
    }

    public void setRevdte(String revdte) {
        this.revdte = revdte;
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

    private String revpgm;

    @javax.persistence.Column(name = "REVPGM")
    @Basic
    public String getRevpgm() {
        return revpgm;
    }

    public void setRevpgm(String revpgm) {
        this.revpgm = revpgm;
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

    private String ucode;

    @javax.persistence.Column(name = "UCODE")
    @Basic
    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    private String status;

    @javax.persistence.Column(name = "STATUS")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String exprdte;

    @javax.persistence.Column(name = "EXPRDTE")
    @Basic
    public String getExprdte() {
        return exprdte;
    }

    public void setExprdte(String exprdte) {
        this.exprdte = exprdte;
    }

    private int efmseq;

    @javax.persistence.Column(name = "EFMSEQ")
    @Basic
    public int getEfmseq() {
        return efmseq;
    }

    public void setEfmseq(int efmseq) {
        this.efmseq = efmseq;
    }

    private int nrpgm;

    @javax.persistence.Column(name = "NRPGM")
    @Basic
    public int getNrpgm() {
        return nrpgm;
    }

    public void setNrpgm(int nrpgm) {
        this.nrpgm = nrpgm;
    }

    private int nrefm;

    @javax.persistence.Column(name = "NREFM")
    @Basic
    public int getNrefm() {
        return nrefm;
    }

    public void setNrefm(int nrefm) {
        this.nrefm = nrefm;
    }

    private int nrefr;

    @javax.persistence.Column(name = "NREFR")
    @Basic
    public int getNrefr() {
        return nrefr;
    }

    public void setNrefr(int nrefr) {
        this.nrefr = nrefr;
    }

    private int nrefx;

    @javax.persistence.Column(name = "NREFX")
    @Basic
    public int getNrefx() {
        return nrefx;
    }

    public void setNrefx(int nrefx) {
        this.nrefx = nrefx;
    }

    private int nroffr;

    @javax.persistence.Column(name = "NROFFR")
    @Basic
    public int getNroffr() {
        return nroffr;
    }

    public void setNroffr(int nroffr) {
        this.nroffr = nroffr;
    }

    private int nracpt;

    @javax.persistence.Column(name = "NRACPT")
    @Basic
    public int getNracpt() {
        return nracpt;
    }

    public void setNracpt(int nracpt) {
        this.nracpt = nracpt;
    }

    private int nrcomm;

    @javax.persistence.Column(name = "NRCOMM")
    @Basic
    public int getNrcomm() {
        return nrcomm;
    }

    public void setNrcomm(int nrcomm) {
        this.nrcomm = nrcomm;
    }

    private int nrpaid;

    @javax.persistence.Column(name = "NRPAID")
    @Basic
    public int getNrpaid() {
        return nrpaid;
    }

    public void setNrpaid(int nrpaid) {
        this.nrpaid = nrpaid;
    }

    private int nrowed;

    @javax.persistence.Column(name = "NROWED")
    @Basic
    public int getNrowed() {
        return nrowed;
    }

    public void setNrowed(int nrowed) {
        this.nrowed = nrowed;
    }

    private int amtefr;

    @javax.persistence.Column(name = "AMTEFR")
    @Basic
    public int getAmtefr() {
        return amtefr;
    }

    public void setAmtefr(int amtefr) {
        this.amtefr = amtefr;
    }

    private int amtefx;

    @javax.persistence.Column(name = "AMTEFX")
    @Basic
    public int getAmtefx() {
        return amtefx;
    }

    public void setAmtefx(int amtefx) {
        this.amtefx = amtefx;
    }

    private int amtefh;

    @javax.persistence.Column(name = "AMTEFH")
    @Basic
    public int getAmtefh() {
        return amtefh;
    }

    public void setAmtefh(int amtefh) {
        this.amtefh = amtefh;
    }

    private int amtoffr;

    @javax.persistence.Column(name = "AMTOFFR")
    @Basic
    public int getAmtoffr() {
        return amtoffr;
    }

    public void setAmtoffr(int amtoffr) {
        this.amtoffr = amtoffr;
    }

    private int amtacpt;

    @javax.persistence.Column(name = "AMTACPT")
    @Basic
    public int getAmtacpt() {
        return amtacpt;
    }

    public void setAmtacpt(int amtacpt) {
        this.amtacpt = amtacpt;
    }

    private int amtcomm;

    @javax.persistence.Column(name = "AMTCOMM")
    @Basic
    public int getAmtcomm() {
        return amtcomm;
    }

    public void setAmtcomm(int amtcomm) {
        this.amtcomm = amtcomm;
    }

    private int amtpaid;

    @javax.persistence.Column(name = "AMTPAID")
    @Basic
    public int getAmtpaid() {
        return amtpaid;
    }

    public void setAmtpaid(int amtpaid) {
        this.amtpaid = amtpaid;
    }

    private int amtowed;

    @javax.persistence.Column(name = "AMTOWED")
    @Basic
    public int getAmtowed() {
        return amtowed;
    }

    public void setAmtowed(int amtowed) {
        this.amtowed = amtowed;
    }

    private String usercd1;

    @javax.persistence.Column(name = "USERCD1")
    @Basic
    public String getUsercd1() {
        return usercd1;
    }

    public void setUsercd1(String usercd1) {
        this.usercd1 = usercd1;
    }

    private String usercd2;

    @javax.persistence.Column(name = "USERCD2")
    @Basic
    public String getUsercd2() {
        return usercd2;
    }

    public void setUsercd2(String usercd2) {
        this.usercd2 = usercd2;
    }

    private String fiscyr;

    @javax.persistence.Column(name = "FISCYR")
    @Basic
    public String getFiscyr() {
        return fiscyr;
    }

    public void setFiscyr(String fiscyr) {
        this.fiscyr = fiscyr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MsfEntity msfEntity = (MsfEntity) o;

        if (amtacpt != msfEntity.amtacpt) return false;
        if (amtcomm != msfEntity.amtcomm) return false;
        if (amtefh != msfEntity.amtefh) return false;
        if (amtefr != msfEntity.amtefr) return false;
        if (amtefx != msfEntity.amtefx) return false;
        if (amtoffr != msfEntity.amtoffr) return false;
        if (amtowed != msfEntity.amtowed) return false;
        if (amtpaid != msfEntity.amtpaid) return false;
        if (efmseq != msfEntity.efmseq) return false;
        if (nracpt != msfEntity.nracpt) return false;
        if (nrcomm != msfEntity.nrcomm) return false;
        if (nrefm != msfEntity.nrefm) return false;
        if (nrefr != msfEntity.nrefr) return false;
        if (nrefx != msfEntity.nrefx) return false;
        if (nroffr != msfEntity.nroffr) return false;
        if (nrowed != msfEntity.nrowed) return false;
        if (nrpaid != msfEntity.nrpaid) return false;
        if (nrpgm != msfEntity.nrpgm) return false;
        if (revlev != msfEntity.revlev) return false;
        if (crtdte != null ? !crtdte.equals(msfEntity.crtdte) : msfEntity.crtdte != null) return false;
        if (crtpgm != null ? !crtpgm.equals(msfEntity.crtpgm) : msfEntity.crtpgm != null) return false;
        if (crttime != null ? !crttime.equals(msfEntity.crttime) : msfEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(msfEntity.crtuser) : msfEntity.crtuser != null) return false;
        if (exprdte != null ? !exprdte.equals(msfEntity.exprdte) : msfEntity.exprdte != null) return false;
        if (fiscyr != null ? !fiscyr.equals(msfEntity.fiscyr) : msfEntity.fiscyr != null) return false;
        if (mfid != null ? !mfid.equals(msfEntity.mfid) : msfEntity.mfid != null) return false;
        if (msfkey != null ? !msfkey.equals(msfEntity.msfkey) : msfEntity.msfkey != null) return false;
        if (procyr != null ? !procyr.equals(msfEntity.procyr) : msfEntity.procyr != null) return false;
        if (recstat != null ? !recstat.equals(msfEntity.recstat) : msfEntity.recstat != null) return false;
        if (revdte != null ? !revdte.equals(msfEntity.revdte) : msfEntity.revdte != null) return false;
        if (revpgm != null ? !revpgm.equals(msfEntity.revpgm) : msfEntity.revpgm != null) return false;
        if (revtime != null ? !revtime.equals(msfEntity.revtime) : msfEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(msfEntity.revuser) : msfEntity.revuser != null) return false;
        if (status != null ? !status.equals(msfEntity.status) : msfEntity.status != null) return false;
        if (ucode != null ? !ucode.equals(msfEntity.ucode) : msfEntity.ucode != null) return false;
        if (usercd1 != null ? !usercd1.equals(msfEntity.usercd1) : msfEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(msfEntity.usercd2) : msfEntity.usercd2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (msfkey != null ? msfkey.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (mfid != null ? mfid.hashCode() : 0);
        result = 31 * result + (crtdte != null ? crtdte.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtpgm != null ? crtpgm.hashCode() : 0);
        result = 31 * result + (revdte != null ? revdte.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revpgm != null ? revpgm.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (exprdte != null ? exprdte.hashCode() : 0);
        result = 31 * result + efmseq;
        result = 31 * result + nrpgm;
        result = 31 * result + nrefm;
        result = 31 * result + nrefr;
        result = 31 * result + nrefx;
        result = 31 * result + nroffr;
        result = 31 * result + nracpt;
        result = 31 * result + nrcomm;
        result = 31 * result + nrpaid;
        result = 31 * result + nrowed;
        result = 31 * result + amtefr;
        result = 31 * result + amtefx;
        result = 31 * result + amtefh;
        result = 31 * result + amtoffr;
        result = 31 * result + amtacpt;
        result = 31 * result + amtcomm;
        result = 31 * result + amtpaid;
        result = 31 * result + amtowed;
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (fiscyr != null ? fiscyr.hashCode() : 0);
        return result;
    }
}
