package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/26/12
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "XCP", schema = "SIGMA", catalog = "")
@Entity
public class XcpEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getXcpkey();
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

    private String xcpkey;

    @javax.persistence.Column(name = "XCPKEY")
    @Id
    public String getXcpkey() {
        return xcpkey;
    }

    public void setXcpkey(String xcpkey) {
        this.xcpkey = xcpkey;
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

    private String aidyr;

    @javax.persistence.Column(name = "AIDYR")
    @Basic
    public String getAidyr() {
        return aidyr;
    }

    public void setAidyr(String aidyr) {
        this.aidyr = aidyr;
    }

    private String cid;

    @javax.persistence.Column(name = "CID")
    @Basic
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    private BigDecimal revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public BigDecimal getRevlev() {
        return revlev;
    }

    public void setRevlev(BigDecimal revlev) {
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

    private String pstatus;

    @javax.persistence.Column(name = "PSTATUS")
    @Basic
    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    private BigDecimal pfee;

    @javax.persistence.Column(name = "PFEE")
    @Basic
    public BigDecimal getPfee() {
        return pfee;
    }

    public void setPfee(BigDecimal pfee) {
        this.pfee = pfee;
    }

    private BigDecimal punit;

    @javax.persistence.Column(name = "PUNIT")
    @Basic
    public BigDecimal getPunit() {
        return punit;
    }

    public void setPunit(BigDecimal punit) {
        this.punit = punit;
    }

    private String effdate;

    @javax.persistence.Column(name = "EFFDATE")
    @Basic
    public String getEffdate() {
        return effdate;
    }

    public void setEffdate(String effdate) {
        this.effdate = effdate;
    }

    private String drpdate;

    @javax.persistence.Column(name = "DRPDATE")
    @Basic
    public String getDrpdate() {
        return drpdate;
    }

    public void setDrpdate(String drpdate) {
        this.drpdate = drpdate;
    }

    private String srcflag;

    @javax.persistence.Column(name = "SRCFLAG")
    @Basic
    public String getSrcflag() {
        return srcflag;
    }

    public void setSrcflag(String srcflag) {
        this.srcflag = srcflag;
    }

    private String procflg;

    @javax.persistence.Column(name = "PROCFLG")
    @Basic
    public String getProcflg() {
        return procflg;
    }

    public void setProcflg(String procflg) {
        this.procflg = procflg;
    }

    private BigDecimal usnr1;

    @javax.persistence.Column(name = "USNR1")
    @Basic
    public BigDecimal getUsnr1() {
        return usnr1;
    }

    public void setUsnr1(BigDecimal usnr1) {
        this.usnr1 = usnr1;
    }

    private BigDecimal usnr2;

    @javax.persistence.Column(name = "USNR2")
    @Basic
    public BigDecimal getUsnr2() {
        return usnr2;
    }

    public void setUsnr2(BigDecimal usnr2) {
        this.usnr2 = usnr2;
    }

    private BigDecimal usnr3;

    @javax.persistence.Column(name = "USNR3")
    @Basic
    public BigDecimal getUsnr3() {
        return usnr3;
    }

    public void setUsnr3(BigDecimal usnr3) {
        this.usnr3 = usnr3;
    }

    private String usrdt1;

    @javax.persistence.Column(name = "USRDT1")
    @Basic
    public String getUsrdt1() {
        return usrdt1;
    }

    public void setUsrdt1(String usrdt1) {
        this.usrdt1 = usrdt1;
    }

    private String usrdt2;

    @javax.persistence.Column(name = "USRDT2")
    @Basic
    public String getUsrdt2() {
        return usrdt2;
    }

    public void setUsrdt2(String usrdt2) {
        this.usrdt2 = usrdt2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XcpEntity xcpEntity = (XcpEntity) o;

        if (aidyr != null ? !aidyr.equals(xcpEntity.aidyr) : xcpEntity.aidyr != null) return false;
        if (cid != null ? !cid.equals(xcpEntity.cid) : xcpEntity.cid != null) return false;
        if (crtdate != null ? !crtdate.equals(xcpEntity.crtdate) : xcpEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(xcpEntity.crtmod) : xcpEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(xcpEntity.crttime) : xcpEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(xcpEntity.crtuser) : xcpEntity.crtuser != null) return false;
        if (drpdate != null ? !drpdate.equals(xcpEntity.drpdate) : xcpEntity.drpdate != null) return false;
        if (effdate != null ? !effdate.equals(xcpEntity.effdate) : xcpEntity.effdate != null) return false;
        if (pfee != null ? !pfee.equals(xcpEntity.pfee) : xcpEntity.pfee != null) return false;
        if (procflg != null ? !procflg.equals(xcpEntity.procflg) : xcpEntity.procflg != null) return false;
        if (pstatus != null ? !pstatus.equals(xcpEntity.pstatus) : xcpEntity.pstatus != null) return false;
        if (punit != null ? !punit.equals(xcpEntity.punit) : xcpEntity.punit != null) return false;
        if (recstat != null ? !recstat.equals(xcpEntity.recstat) : xcpEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(xcpEntity.revdate) : xcpEntity.revdate != null) return false;
        if (revlev != null ? !revlev.equals(xcpEntity.revlev) : xcpEntity.revlev != null) return false;
        if (revmod != null ? !revmod.equals(xcpEntity.revmod) : xcpEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(xcpEntity.revtime) : xcpEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(xcpEntity.revuser) : xcpEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(xcpEntity.sid) : xcpEntity.sid != null) return false;
        if (srcflag != null ? !srcflag.equals(xcpEntity.srcflag) : xcpEntity.srcflag != null) return false;
        if (ucode != null ? !ucode.equals(xcpEntity.ucode) : xcpEntity.ucode != null) return false;
        if (usnr1 != null ? !usnr1.equals(xcpEntity.usnr1) : xcpEntity.usnr1 != null) return false;
        if (usnr2 != null ? !usnr2.equals(xcpEntity.usnr2) : xcpEntity.usnr2 != null) return false;
        if (usnr3 != null ? !usnr3.equals(xcpEntity.usnr3) : xcpEntity.usnr3 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(xcpEntity.usrdt1) : xcpEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(xcpEntity.usrdt2) : xcpEntity.usrdt2 != null) return false;
        if (xcpkey != null ? !xcpkey.equals(xcpEntity.xcpkey) : xcpEntity.xcpkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (xcpkey != null ? xcpkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (pstatus != null ? pstatus.hashCode() : 0);
        result = 31 * result + (pfee != null ? pfee.hashCode() : 0);
        result = 31 * result + (punit != null ? punit.hashCode() : 0);
        result = 31 * result + (effdate != null ? effdate.hashCode() : 0);
        result = 31 * result + (drpdate != null ? drpdate.hashCode() : 0);
        result = 31 * result + (srcflag != null ? srcflag.hashCode() : 0);
        result = 31 * result + (procflg != null ? procflg.hashCode() : 0);
        result = 31 * result + (usnr1 != null ? usnr1.hashCode() : 0);
        result = 31 * result + (usnr2 != null ? usnr2.hashCode() : 0);
        result = 31 * result + (usnr3 != null ? usnr3.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (usrdt2 != null ? usrdt2.hashCode() : 0);
        return result;
    }
}
