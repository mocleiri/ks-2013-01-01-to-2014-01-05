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
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "WLP", schema = "SIGMA", catalog = "")
@Entity
public class WlpEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getWlpkey();
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

    private String wlpkey;

    @javax.persistence.Column(name = "WLPKEY")
    @Id
    public String getWlpkey() {
        return wlpkey;
    }

    public void setWlpkey(String wlpkey) {
        this.wlpkey = wlpkey;
    }

    private String ssitbl;

    @javax.persistence.Column(name = "SSITBL")
    @Basic
    public String getSsitbl() {
        return ssitbl;
    }

    public void setSsitbl(String ssitbl) {
        this.ssitbl = ssitbl;
    }

    private String parmtp;

    @javax.persistence.Column(name = "PARMTP")
    @Basic
    public String getParmtp() {
        return parmtp;
    }

    public void setParmtp(String parmtp) {
        this.parmtp = parmtp;
    }

    private String parmv;

    @javax.persistence.Column(name = "PARMV")
    @Basic
    public String getParmv() {
        return parmv;
    }

    public void setParmv(String parmv) {
        this.parmv = parmv;
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

    private BigDecimal revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public BigDecimal getRevlev() {
        return revlev;
    }

    public void setRevlev(BigDecimal revlev) {
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

    private BigDecimal usrnr1;

    @javax.persistence.Column(name = "USRNR1")
    @Basic
    public BigDecimal getUsrnr1() {
        return usrnr1;
    }

    public void setUsrnr1(BigDecimal usrnr1) {
        this.usrnr1 = usrnr1;
    }

    private BigDecimal usrnr2;

    @javax.persistence.Column(name = "USRNR2")
    @Basic
    public BigDecimal getUsrnr2() {
        return usrnr2;
    }

    public void setUsrnr2(BigDecimal usrnr2) {
        this.usrnr2 = usrnr2;
    }

    private BigDecimal usrnr3;

    @javax.persistence.Column(name = "USRNR3")
    @Basic
    public BigDecimal getUsrnr3() {
        return usrnr3;
    }

    public void setUsrnr3(BigDecimal usrnr3) {
        this.usrnr3 = usrnr3;
    }

    private BigDecimal usrnr4;

    @javax.persistence.Column(name = "USRNR4")
    @Basic
    public BigDecimal getUsrnr4() {
        return usrnr4;
    }

    public void setUsrnr4(BigDecimal usrnr4) {
        this.usrnr4 = usrnr4;
    }

    private BigDecimal usrnr5;

    @javax.persistence.Column(name = "USRNR5")
    @Basic
    public BigDecimal getUsrnr5() {
        return usrnr5;
    }

    public void setUsrnr5(BigDecimal usrnr5) {
        this.usrnr5 = usrnr5;
    }

    private BigDecimal usrnr6;

    @javax.persistence.Column(name = "USRNR6")
    @Basic
    public BigDecimal getUsrnr6() {
        return usrnr6;
    }

    public void setUsrnr6(BigDecimal usrnr6) {
        this.usrnr6 = usrnr6;
    }

    private BigDecimal usrnr7;

    @javax.persistence.Column(name = "USRNR7")
    @Basic
    public BigDecimal getUsrnr7() {
        return usrnr7;
    }

    public void setUsrnr7(BigDecimal usrnr7) {
        this.usrnr7 = usrnr7;
    }

    private BigDecimal usrnr8;

    @javax.persistence.Column(name = "USRNR8")
    @Basic
    public BigDecimal getUsrnr8() {
        return usrnr8;
    }

    public void setUsrnr8(BigDecimal usrnr8) {
        this.usrnr8 = usrnr8;
    }

    private String usrcd1;

    @javax.persistence.Column(name = "USRCD1")
    @Basic
    public String getUsrcd1() {
        return usrcd1;
    }

    public void setUsrcd1(String usrcd1) {
        this.usrcd1 = usrcd1;
    }

    private String usrcd2;

    @javax.persistence.Column(name = "USRCD2")
    @Basic
    public String getUsrcd2() {
        return usrcd2;
    }

    public void setUsrcd2(String usrcd2) {
        this.usrcd2 = usrcd2;
    }

    private String usrcd3;

    @javax.persistence.Column(name = "USRCD3")
    @Basic
    public String getUsrcd3() {
        return usrcd3;
    }

    public void setUsrcd3(String usrcd3) {
        this.usrcd3 = usrcd3;
    }

    private String usrcd4;

    @javax.persistence.Column(name = "USRCD4")
    @Basic
    public String getUsrcd4() {
        return usrcd4;
    }

    public void setUsrcd4(String usrcd4) {
        this.usrcd4 = usrcd4;
    }

    private String usrcd5;

    @javax.persistence.Column(name = "USRCD5")
    @Basic
    public String getUsrcd5() {
        return usrcd5;
    }

    public void setUsrcd5(String usrcd5) {
        this.usrcd5 = usrcd5;
    }

    private String usrcd6;

    @javax.persistence.Column(name = "USRCD6")
    @Basic
    public String getUsrcd6() {
        return usrcd6;
    }

    public void setUsrcd6(String usrcd6) {
        this.usrcd6 = usrcd6;
    }

    private String usrcd7;

    @javax.persistence.Column(name = "USRCD7")
    @Basic
    public String getUsrcd7() {
        return usrcd7;
    }

    public void setUsrcd7(String usrcd7) {
        this.usrcd7 = usrcd7;
    }

    private String usrcd8;

    @javax.persistence.Column(name = "USRCD8")
    @Basic
    public String getUsrcd8() {
        return usrcd8;
    }

    public void setUsrcd8(String usrcd8) {
        this.usrcd8 = usrcd8;
    }

    private String usrcd9;

    @javax.persistence.Column(name = "USRCD9")
    @Basic
    public String getUsrcd9() {
        return usrcd9;
    }

    public void setUsrcd9(String usrcd9) {
        this.usrcd9 = usrcd9;
    }

    private String usrcda;

    @javax.persistence.Column(name = "USRCDA")
    @Basic
    public String getUsrcda() {
        return usrcda;
    }

    public void setUsrcda(String usrcda) {
        this.usrcda = usrcda;
    }

    private String usrcdb;

    @javax.persistence.Column(name = "USRCDB")
    @Basic
    public String getUsrcdb() {
        return usrcdb;
    }

    public void setUsrcdb(String usrcdb) {
        this.usrcdb = usrcdb;
    }

    private String usrcdc;

    @javax.persistence.Column(name = "USRCDC")
    @Basic
    public String getUsrcdc() {
        return usrcdc;
    }

    public void setUsrcdc(String usrcdc) {
        this.usrcdc = usrcdc;
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

    private String usrdt3;

    @javax.persistence.Column(name = "USRDT3")
    @Basic
    public String getUsrdt3() {
        return usrdt3;
    }

    public void setUsrdt3(String usrdt3) {
        this.usrdt3 = usrdt3;
    }

    private String usrdt4;

    @javax.persistence.Column(name = "USRDT4")
    @Basic
    public String getUsrdt4() {
        return usrdt4;
    }

    public void setUsrdt4(String usrdt4) {
        this.usrdt4 = usrdt4;
    }

    private String usrdt5;

    @javax.persistence.Column(name = "USRDT5")
    @Basic
    public String getUsrdt5() {
        return usrdt5;
    }

    public void setUsrdt5(String usrdt5) {
        this.usrdt5 = usrdt5;
    }

    private String usrdt6;

    @javax.persistence.Column(name = "USRDT6")
    @Basic
    public String getUsrdt6() {
        return usrdt6;
    }

    public void setUsrdt6(String usrdt6) {
        this.usrdt6 = usrdt6;
    }

    private String usrdt7;

    @javax.persistence.Column(name = "USRDT7")
    @Basic
    public String getUsrdt7() {
        return usrdt7;
    }

    public void setUsrdt7(String usrdt7) {
        this.usrdt7 = usrdt7;
    }

    private String usrdt8;

    @javax.persistence.Column(name = "USRDT8")
    @Basic
    public String getUsrdt8() {
        return usrdt8;
    }

    public void setUsrdt8(String usrdt8) {
        this.usrdt8 = usrdt8;
    }

    private BigDecimal refval;

    @javax.persistence.Column(name = "REFVAL")
    @Basic
    public BigDecimal getRefval() {
        return refval;
    }

    public void setRefval(BigDecimal refval) {
        this.refval = refval;
    }

    private String reftxt;

    @javax.persistence.Column(name = "REFTXT")
    @Basic
    public String getReftxt() {
        return reftxt;
    }

    public void setReftxt(String reftxt) {
        this.reftxt = reftxt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WlpEntity wlpEntity = (WlpEntity) o;

        if (crtdtec != null ? !crtdtec.equals(wlpEntity.crtdtec) : wlpEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(wlpEntity.crtmod) : wlpEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(wlpEntity.crttime) : wlpEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(wlpEntity.crtuser) : wlpEntity.crtuser != null) return false;
        if (parmtp != null ? !parmtp.equals(wlpEntity.parmtp) : wlpEntity.parmtp != null) return false;
        if (parmv != null ? !parmv.equals(wlpEntity.parmv) : wlpEntity.parmv != null) return false;
        if (recstat != null ? !recstat.equals(wlpEntity.recstat) : wlpEntity.recstat != null) return false;
        if (reftxt != null ? !reftxt.equals(wlpEntity.reftxt) : wlpEntity.reftxt != null) return false;
        if (refval != null ? !refval.equals(wlpEntity.refval) : wlpEntity.refval != null) return false;
        if (revdtec != null ? !revdtec.equals(wlpEntity.revdtec) : wlpEntity.revdtec != null) return false;
        if (revlev != null ? !revlev.equals(wlpEntity.revlev) : wlpEntity.revlev != null) return false;
        if (revmod != null ? !revmod.equals(wlpEntity.revmod) : wlpEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(wlpEntity.revtime) : wlpEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(wlpEntity.revuser) : wlpEntity.revuser != null) return false;
        if (ssitbl != null ? !ssitbl.equals(wlpEntity.ssitbl) : wlpEntity.ssitbl != null) return false;
        if (ucode != null ? !ucode.equals(wlpEntity.ucode) : wlpEntity.ucode != null) return false;
        if (usrcd1 != null ? !usrcd1.equals(wlpEntity.usrcd1) : wlpEntity.usrcd1 != null) return false;
        if (usrcd2 != null ? !usrcd2.equals(wlpEntity.usrcd2) : wlpEntity.usrcd2 != null) return false;
        if (usrcd3 != null ? !usrcd3.equals(wlpEntity.usrcd3) : wlpEntity.usrcd3 != null) return false;
        if (usrcd4 != null ? !usrcd4.equals(wlpEntity.usrcd4) : wlpEntity.usrcd4 != null) return false;
        if (usrcd5 != null ? !usrcd5.equals(wlpEntity.usrcd5) : wlpEntity.usrcd5 != null) return false;
        if (usrcd6 != null ? !usrcd6.equals(wlpEntity.usrcd6) : wlpEntity.usrcd6 != null) return false;
        if (usrcd7 != null ? !usrcd7.equals(wlpEntity.usrcd7) : wlpEntity.usrcd7 != null) return false;
        if (usrcd8 != null ? !usrcd8.equals(wlpEntity.usrcd8) : wlpEntity.usrcd8 != null) return false;
        if (usrcd9 != null ? !usrcd9.equals(wlpEntity.usrcd9) : wlpEntity.usrcd9 != null) return false;
        if (usrcda != null ? !usrcda.equals(wlpEntity.usrcda) : wlpEntity.usrcda != null) return false;
        if (usrcdb != null ? !usrcdb.equals(wlpEntity.usrcdb) : wlpEntity.usrcdb != null) return false;
        if (usrcdc != null ? !usrcdc.equals(wlpEntity.usrcdc) : wlpEntity.usrcdc != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(wlpEntity.usrdt1) : wlpEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(wlpEntity.usrdt2) : wlpEntity.usrdt2 != null) return false;
        if (usrdt3 != null ? !usrdt3.equals(wlpEntity.usrdt3) : wlpEntity.usrdt3 != null) return false;
        if (usrdt4 != null ? !usrdt4.equals(wlpEntity.usrdt4) : wlpEntity.usrdt4 != null) return false;
        if (usrdt5 != null ? !usrdt5.equals(wlpEntity.usrdt5) : wlpEntity.usrdt5 != null) return false;
        if (usrdt6 != null ? !usrdt6.equals(wlpEntity.usrdt6) : wlpEntity.usrdt6 != null) return false;
        if (usrdt7 != null ? !usrdt7.equals(wlpEntity.usrdt7) : wlpEntity.usrdt7 != null) return false;
        if (usrdt8 != null ? !usrdt8.equals(wlpEntity.usrdt8) : wlpEntity.usrdt8 != null) return false;
        if (usrnr1 != null ? !usrnr1.equals(wlpEntity.usrnr1) : wlpEntity.usrnr1 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(wlpEntity.usrnr2) : wlpEntity.usrnr2 != null) return false;
        if (usrnr3 != null ? !usrnr3.equals(wlpEntity.usrnr3) : wlpEntity.usrnr3 != null) return false;
        if (usrnr4 != null ? !usrnr4.equals(wlpEntity.usrnr4) : wlpEntity.usrnr4 != null) return false;
        if (usrnr5 != null ? !usrnr5.equals(wlpEntity.usrnr5) : wlpEntity.usrnr5 != null) return false;
        if (usrnr6 != null ? !usrnr6.equals(wlpEntity.usrnr6) : wlpEntity.usrnr6 != null) return false;
        if (usrnr7 != null ? !usrnr7.equals(wlpEntity.usrnr7) : wlpEntity.usrnr7 != null) return false;
        if (usrnr8 != null ? !usrnr8.equals(wlpEntity.usrnr8) : wlpEntity.usrnr8 != null) return false;
        if (wlpkey != null ? !wlpkey.equals(wlpEntity.wlpkey) : wlpEntity.wlpkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (wlpkey != null ? wlpkey.hashCode() : 0);
        result = 31 * result + (ssitbl != null ? ssitbl.hashCode() : 0);
        result = 31 * result + (parmtp != null ? parmtp.hashCode() : 0);
        result = 31 * result + (parmv != null ? parmv.hashCode() : 0);
        result = 31 * result + (crtdtec != null ? crtdtec.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (usrnr1 != null ? usrnr1.hashCode() : 0);
        result = 31 * result + (usrnr2 != null ? usrnr2.hashCode() : 0);
        result = 31 * result + (usrnr3 != null ? usrnr3.hashCode() : 0);
        result = 31 * result + (usrnr4 != null ? usrnr4.hashCode() : 0);
        result = 31 * result + (usrnr5 != null ? usrnr5.hashCode() : 0);
        result = 31 * result + (usrnr6 != null ? usrnr6.hashCode() : 0);
        result = 31 * result + (usrnr7 != null ? usrnr7.hashCode() : 0);
        result = 31 * result + (usrnr8 != null ? usrnr8.hashCode() : 0);
        result = 31 * result + (usrcd1 != null ? usrcd1.hashCode() : 0);
        result = 31 * result + (usrcd2 != null ? usrcd2.hashCode() : 0);
        result = 31 * result + (usrcd3 != null ? usrcd3.hashCode() : 0);
        result = 31 * result + (usrcd4 != null ? usrcd4.hashCode() : 0);
        result = 31 * result + (usrcd5 != null ? usrcd5.hashCode() : 0);
        result = 31 * result + (usrcd6 != null ? usrcd6.hashCode() : 0);
        result = 31 * result + (usrcd7 != null ? usrcd7.hashCode() : 0);
        result = 31 * result + (usrcd8 != null ? usrcd8.hashCode() : 0);
        result = 31 * result + (usrcd9 != null ? usrcd9.hashCode() : 0);
        result = 31 * result + (usrcda != null ? usrcda.hashCode() : 0);
        result = 31 * result + (usrcdb != null ? usrcdb.hashCode() : 0);
        result = 31 * result + (usrcdc != null ? usrcdc.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (usrdt2 != null ? usrdt2.hashCode() : 0);
        result = 31 * result + (usrdt3 != null ? usrdt3.hashCode() : 0);
        result = 31 * result + (usrdt4 != null ? usrdt4.hashCode() : 0);
        result = 31 * result + (usrdt5 != null ? usrdt5.hashCode() : 0);
        result = 31 * result + (usrdt6 != null ? usrdt6.hashCode() : 0);
        result = 31 * result + (usrdt7 != null ? usrdt7.hashCode() : 0);
        result = 31 * result + (usrdt8 != null ? usrdt8.hashCode() : 0);
        result = 31 * result + (refval != null ? refval.hashCode() : 0);
        result = 31 * result + (reftxt != null ? reftxt.hashCode() : 0);
        return result;
    }
}
