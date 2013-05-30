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
@javax.persistence.Table(name = "AMD", schema = "SIGMA", catalog = "")
@Entity
public class AmdEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getAmdkey();
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

    private String amdkey;

    @javax.persistence.Column(name = "AMDKEY")
    @Id
    public String getAmdkey() {
        return amdkey;
    }

    public void setAmdkey(String amdkey) {
        this.amdkey = amdkey;
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

    private int seqno;

    @javax.persistence.Column(name = "SEQNO")
    @Basic
    public int getSeqno() {
        return seqno;
    }

    public void setSeqno(int seqno) {
        this.seqno = seqno;
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

    private String crtmode;

    @javax.persistence.Column(name = "CRTMODE")
    @Basic
    public String getCrtmode() {
        return crtmode;
    }

    public void setCrtmode(String crtmode) {
        this.crtmode = crtmode;
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

    private String revmode;

    @javax.persistence.Column(name = "REVMODE")
    @Basic
    public String getRevmode() {
        return revmode;
    }

    public void setRevmode(String revmode) {
        this.revmode = revmode;
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

    private String mddesc;

    @javax.persistence.Column(name = "MDDESC")
    @Basic
    public String getMddesc() {
        return mddesc;
    }

    public void setMddesc(String mddesc) {
        this.mddesc = mddesc;
    }

    private String isirval;

    @javax.persistence.Column(name = "ISIRVAL")
    @Basic
    public String getIsirval() {
        return isirval;
    }

    public void setIsirval(String isirval) {
        this.isirval = isirval;
    }

    private String instval;

    @javax.persistence.Column(name = "INSTVAL")
    @Basic
    public String getInstval() {
        return instval;
    }

    public void setInstval(String instval) {
        this.instval = instval;
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

        AmdEntity amdEntity = (AmdEntity) o;

        if (revlev != amdEntity.revlev) return false;
        if (seqno != amdEntity.seqno) return false;
        if (amdkey != null ? !amdkey.equals(amdEntity.amdkey) : amdEntity.amdkey != null) return false;
        if (crtdate != null ? !crtdate.equals(amdEntity.crtdate) : amdEntity.crtdate != null) return false;
        if (crtmode != null ? !crtmode.equals(amdEntity.crtmode) : amdEntity.crtmode != null) return false;
        if (crttime != null ? !crttime.equals(amdEntity.crttime) : amdEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(amdEntity.crtuser) : amdEntity.crtuser != null) return false;
        if (grnt != null ? !grnt.equals(amdEntity.grnt) : amdEntity.grnt != null) return false;
        if (instval != null ? !instval.equals(amdEntity.instval) : amdEntity.instval != null) return false;
        if (isirval != null ? !isirval.equals(amdEntity.isirval) : amdEntity.isirval != null) return false;
        if (keydate != null ? !keydate.equals(amdEntity.keydate) : amdEntity.keydate != null) return false;
        if (keytime != null ? !keytime.equals(amdEntity.keytime) : amdEntity.keytime != null) return false;
        if (lastnum != null ? !lastnum.equals(amdEntity.lastnum) : amdEntity.lastnum != null) return false;
        if (mddesc != null ? !mddesc.equals(amdEntity.mddesc) : amdEntity.mddesc != null) return false;
        if (recstat != null ? !recstat.equals(amdEntity.recstat) : amdEntity.recstat != null) return false;
        if (rectyp != null ? !rectyp.equals(amdEntity.rectyp) : amdEntity.rectyp != null) return false;
        if (revdate != null ? !revdate.equals(amdEntity.revdate) : amdEntity.revdate != null) return false;
        if (revmode != null ? !revmode.equals(amdEntity.revmode) : amdEntity.revmode != null) return false;
        if (revtime != null ? !revtime.equals(amdEntity.revtime) : amdEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(amdEntity.revuser) : amdEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(amdEntity.sid) : amdEntity.sid != null) return false;
        if (ssn != null ? !ssn.equals(amdEntity.ssn) : amdEntity.ssn != null) return false;
        if (trannum != null ? !trannum.equals(amdEntity.trannum) : amdEntity.trannum != null) return false;
        if (ucode != null ? !ucode.equals(amdEntity.ucode) : amdEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (amdkey != null ? amdkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (lastnum != null ? lastnum.hashCode() : 0);
        result = 31 * result + (trannum != null ? trannum.hashCode() : 0);
        result = 31 * result + (keydate != null ? keydate.hashCode() : 0);
        result = 31 * result + (keytime != null ? keytime.hashCode() : 0);
        result = 31 * result + seqno;
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmode != null ? crtmode.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmode != null ? revmode.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (mddesc != null ? mddesc.hashCode() : 0);
        result = 31 * result + (isirval != null ? isirval.hashCode() : 0);
        result = 31 * result + (instval != null ? instval.hashCode() : 0);
        result = 31 * result + (grnt != null ? grnt.hashCode() : 0);
        result = 31 * result + (rectyp != null ? rectyp.hashCode() : 0);
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        return result;
    }
}
