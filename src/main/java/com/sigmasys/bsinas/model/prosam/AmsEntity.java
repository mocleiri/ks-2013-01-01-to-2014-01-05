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
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "AMS", schema = "SIGMA", catalog = "")
@Entity
public class AmsEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getAmskey();
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

    private String amskey;

    @javax.persistence.Column(name = "AMSKEY")
    @Id
    public String getAmskey() {
        return amskey;
    }

    public void setAmskey(String amskey) {
        this.amskey = amskey;
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

    private String lastnum;

    @javax.persistence.Column(name = "LASTNUM")
    @Basic
    public String getLastnum() {
        return lastnum;
    }

    public void setLastnum(String lastnum) {
        this.lastnum = lastnum;
    }

    private BigInteger trannum;

    @javax.persistence.Column(name = "TRANNUM")
    @Basic
    public BigInteger getTrannum() {
        return trannum;
    }

    public void setTrannum(BigInteger trannum) {
        this.trannum = trannum;
    }

    private String keydate;

    @javax.persistence.Column(name = "KEYDATE")
    @Basic
    public String getKeydate() {
        return keydate;
    }

    public void setKeydate(String keydate) {
        this.keydate = keydate;
    }

    private String keytime;

    @javax.persistence.Column(name = "KEYTIME")
    @Basic
    public String getKeytime() {
        return keytime;
    }

    public void setKeytime(String keytime) {
        this.keytime = keytime;
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

    private String procyr;

    @javax.persistence.Column(name = "PROCYR")
    @Basic
    public String getProcyr() {
        return procyr;
    }

    public void setProcyr(String procyr) {
        this.procyr = procyr;
    }

    private String loaddte;

    @javax.persistence.Column(name = "LOADDTE")
    @Basic
    public String getLoaddte() {
        return loaddte;
    }

    public void setLoaddte(String loaddte) {
        this.loaddte = loaddte;
    }

    private String prcflag;

    @javax.persistence.Column(name = "PRCFLAG")
    @Basic
    public String getPrcflag() {
        return prcflag;
    }

    public void setPrcflag(String prcflag) {
        this.prcflag = prcflag;
    }

    private String isrinst;

    @javax.persistence.Column(name = "ISRINST")
    @Basic
    public String getIsrinst() {
        return isrinst;
    }

    public void setIsrinst(String isrinst) {
        this.isrinst = isrinst;
    }

    private String isrname;

    @javax.persistence.Column(name = "ISRNAME")
    @Basic
    public String getIsrname() {
        return isrname;
    }

    public void setIsrname(String isrname) {
        this.isrname = isrname;
    }

    private String grnt;

    @javax.persistence.Column(name = "GRNT")
    @Basic
    public String getGrnt() {
        return grnt;
    }

    public void setGrnt(String grnt) {
        this.grnt = grnt;
    }

    private String rectyp;

    @javax.persistence.Column(name = "RECTYP")
    @Basic
    public String getRectyp() {
        return rectyp;
    }

    public void setRectyp(String rectyp) {
        this.rectyp = rectyp;
    }

    private String ssn;

    @javax.persistence.Column(name = "SSN")
    @Basic
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmsEntity amsEntity = (AmsEntity) o;

        if (revlev != amsEntity.revlev) return false;
        if (amskey != null ? !amskey.equals(amsEntity.amskey) : amsEntity.amskey != null) return false;
        if (crtdate != null ? !crtdate.equals(amsEntity.crtdate) : amsEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(amsEntity.crtmod) : amsEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(amsEntity.crttime) : amsEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(amsEntity.crtuser) : amsEntity.crtuser != null) return false;
        if (grnt != null ? !grnt.equals(amsEntity.grnt) : amsEntity.grnt != null) return false;
        if (isrinst != null ? !isrinst.equals(amsEntity.isrinst) : amsEntity.isrinst != null) return false;
        if (isrname != null ? !isrname.equals(amsEntity.isrname) : amsEntity.isrname != null) return false;
        if (keydate != null ? !keydate.equals(amsEntity.keydate) : amsEntity.keydate != null) return false;
        if (keytime != null ? !keytime.equals(amsEntity.keytime) : amsEntity.keytime != null) return false;
        if (lastnum != null ? !lastnum.equals(amsEntity.lastnum) : amsEntity.lastnum != null) return false;
        if (loaddte != null ? !loaddte.equals(amsEntity.loaddte) : amsEntity.loaddte != null) return false;
        if (prcflag != null ? !prcflag.equals(amsEntity.prcflag) : amsEntity.prcflag != null) return false;
        if (procyr != null ? !procyr.equals(amsEntity.procyr) : amsEntity.procyr != null) return false;
        if (recstat != null ? !recstat.equals(amsEntity.recstat) : amsEntity.recstat != null) return false;
        if (rectyp != null ? !rectyp.equals(amsEntity.rectyp) : amsEntity.rectyp != null) return false;
        if (revdate != null ? !revdate.equals(amsEntity.revdate) : amsEntity.revdate != null) return false;
        if (revmod != null ? !revmod.equals(amsEntity.revmod) : amsEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(amsEntity.revtime) : amsEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(amsEntity.revuser) : amsEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(amsEntity.sid) : amsEntity.sid != null) return false;
        if (ssn != null ? !ssn.equals(amsEntity.ssn) : amsEntity.ssn != null) return false;
        if (trannum != null ? !trannum.equals(amsEntity.trannum) : amsEntity.trannum != null) return false;
        if (ucode != null ? !ucode.equals(amsEntity.ucode) : amsEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (amskey != null ? amskey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (lastnum != null ? lastnum.hashCode() : 0);
        result = 31 * result + (trannum != null ? trannum.hashCode() : 0);
        result = 31 * result + (keydate != null ? keydate.hashCode() : 0);
        result = 31 * result + (keytime != null ? keytime.hashCode() : 0);
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
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (loaddte != null ? loaddte.hashCode() : 0);
        result = 31 * result + (prcflag != null ? prcflag.hashCode() : 0);
        result = 31 * result + (isrinst != null ? isrinst.hashCode() : 0);
        result = 31 * result + (isrname != null ? isrname.hashCode() : 0);
        result = 31 * result + (grnt != null ? grnt.hashCode() : 0);
        result = 31 * result + (rectyp != null ? rectyp.hashCode() : 0);
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        return result;
    }
}
