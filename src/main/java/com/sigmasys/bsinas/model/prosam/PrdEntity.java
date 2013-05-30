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
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "PRD", schema = "SIGMA", catalog = "")
@Entity
public class PrdEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getPrdkey();
    }

    private String prdkey;

    @javax.persistence.Column(name = "PRDKEY")
    @Id
    public String getPrdkey() {
        return prdkey;
    }

    public void setPrdkey(String prdkey) {
        this.prdkey = prdkey;
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

    private String aidyr;

    @javax.persistence.Column(name = "AIDYR")
    @Basic
    public String getAidyr() {
        return aidyr;
    }

    public void setAidyr(String aidyr) {
        this.aidyr = aidyr;
    }

    private String product;

    @javax.persistence.Column(name = "PRODUCT")
    @Basic
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    private String sortgrp;

    @javax.persistence.Column(name = "SORTGRP")
    @Basic
    public String getSortgrp() {
        return sortgrp;
    }

    public void setSortgrp(String sortgrp) {
        this.sortgrp = sortgrp;
    }

    private BigDecimal feeamt;

    @javax.persistence.Column(name = "FEEAMT")
    @Basic
    public BigDecimal getFeeamt() {
        return feeamt;
    }

    public void setFeeamt(BigDecimal feeamt) {
        this.feeamt = feeamt;
    }

    private BigDecimal feerte;

    @javax.persistence.Column(name = "FEERTE")
    @Basic
    public BigDecimal getFeerte() {
        return feerte;
    }

    public void setFeerte(BigDecimal feerte) {
        this.feerte = feerte;
    }

    private BigDecimal rebamt;

    @javax.persistence.Column(name = "REBAMT")
    @Basic
    public BigDecimal getRebamt() {
        return rebamt;
    }

    public void setRebamt(BigDecimal rebamt) {
        this.rebamt = rebamt;
    }

    private BigDecimal rebrate;

    @javax.persistence.Column(name = "REBRATE")
    @Basic
    public BigDecimal getRebrate() {
        return rebrate;
    }

    public void setRebrate(BigDecimal rebrate) {
        this.rebrate = rebrate;
    }

    private BigDecimal intrate;

    @javax.persistence.Column(name = "INTRATE")
    @Basic
    public BigDecimal getIntrate() {
        return intrate;
    }

    public void setIntrate(BigDecimal intrate) {
        this.intrate = intrate;
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

    private int nrpaidt;

    @javax.persistence.Column(name = "NRPAIDT")
    @Basic
    public int getNrpaidt() {
        return nrpaidt;
    }

    public void setNrpaidt(int nrpaidt) {
        this.nrpaidt = nrpaidt;
    }

    private int nroffu;

    @javax.persistence.Column(name = "NROFFU")
    @Basic
    public int getNroffu() {
        return nroffu;
    }

    public void setNroffu(int nroffu) {
        this.nroffu = nroffu;
    }

    private int nracpu;

    @javax.persistence.Column(name = "NRACPU")
    @Basic
    public int getNracpu() {
        return nracpu;
    }

    public void setNracpu(int nracpu) {
        this.nracpu = nracpu;
    }

    private int nrpaidu;

    @javax.persistence.Column(name = "NRPAIDU")
    @Basic
    public int getNrpaidu() {
        return nrpaidu;
    }

    public void setNrpaidu(int nrpaidu) {
        this.nrpaidu = nrpaidu;
    }

    private BigDecimal amtofft;

    @javax.persistence.Column(name = "AMTOFFT")
    @Basic
    public BigDecimal getAmtofft() {
        return amtofft;
    }

    public void setAmtofft(BigDecimal amtofft) {
        this.amtofft = amtofft;
    }

    private BigDecimal amtacct;

    @javax.persistence.Column(name = "AMTACCT")
    @Basic
    public BigDecimal getAmtacct() {
        return amtacct;
    }

    public void setAmtacct(BigDecimal amtacct) {
        this.amtacct = amtacct;
    }

    private BigDecimal amtpdt;

    @javax.persistence.Column(name = "AMTPDT")
    @Basic
    public BigDecimal getAmtpdt() {
        return amtpdt;
    }

    public void setAmtpdt(BigDecimal amtpdt) {
        this.amtpdt = amtpdt;
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

    private String usercd3;

    @javax.persistence.Column(name = "USERCD3")
    @Basic
    public String getUsercd3() {
        return usercd3;
    }

    public void setUsercd3(String usercd3) {
        this.usercd3 = usercd3;
    }

    private String usercd4;

    @javax.persistence.Column(name = "USERCD4")
    @Basic
    public String getUsercd4() {
        return usercd4;
    }

    public void setUsercd4(String usercd4) {
        this.usercd4 = usercd4;
    }

    private BigDecimal usernr1;

    @javax.persistence.Column(name = "USERNR1")
    @Basic
    public BigDecimal getUsernr1() {
        return usernr1;
    }

    public void setUsernr1(BigDecimal usernr1) {
        this.usernr1 = usernr1;
    }

    private BigDecimal usernr2;

    @javax.persistence.Column(name = "USERNR2")
    @Basic
    public BigDecimal getUsernr2() {
        return usernr2;
    }

    public void setUsernr2(BigDecimal usernr2) {
        this.usernr2 = usernr2;
    }

    private BigDecimal usernr3;

    @javax.persistence.Column(name = "USERNR3")
    @Basic
    public BigDecimal getUsernr3() {
        return usernr3;
    }

    public void setUsernr3(BigDecimal usernr3) {
        this.usernr3 = usernr3;
    }

    private BigDecimal usernr4;

    @javax.persistence.Column(name = "USERNR4")
    @Basic
    public BigDecimal getUsernr4() {
        return usernr4;
    }

    public void setUsernr4(BigDecimal usernr4) {
        this.usernr4 = usernr4;
    }

    private String pgmtcd;

    @javax.persistence.Column(name = "PGMTCD")
    @Basic
    public String getPgmtcd() {
        return pgmtcd;
    }

    public void setPgmtcd(String pgmtcd) {
        this.pgmtcd = pgmtcd;
    }

    private String aaidid;

    @javax.persistence.Column(name = "AAIDID")
    @Basic
    public String getAaidid() {
        return aaidid;
    }

    public void setAaidid(String aaidid) {
        this.aaidid = aaidid;
    }

    private String lntype;

    @javax.persistence.Column(name = "LNTYPE")
    @Basic
    public String getLntype() {
        return lntype;
    }

    public void setLntype(String lntype) {
        this.lntype = lntype;
    }

    private String prflnd;

    @javax.persistence.Column(name = "PRFLND")
    @Basic
    public String getPrflnd() {
        return prflnd;
    }

    public void setPrflnd(String prflnd) {
        this.prflnd = prflnd;
    }

    private BigDecimal ferte2;

    @javax.persistence.Column(name = "FERTE2")
    @Basic
    public BigDecimal getFerte2() {
        return ferte2;
    }

    public void setFerte2(BigDecimal ferte2) {
        this.ferte2 = ferte2;
    }

    private String effdte;

    @javax.persistence.Column(name = "EFFDTE")
    @Basic
    public String getEffdte() {
        return effdte;
    }

    public void setEffdte(String effdte) {
        this.effdte = effdte;
    }

    private String rteupd;

    @javax.persistence.Column(name = "RTEUPD")
    @Basic
    public String getRteupd() {
        return rteupd;
    }

    public void setRteupd(String rteupd) {
        this.rteupd = rteupd;
    }

    private String feltyp;

    @javax.persistence.Column(name = "FELTYP")
    @Basic
    public String getFeltyp() {
        return feltyp;
    }

    public void setFeltyp(String feltyp) {
        this.feltyp = feltyp;
    }

    private BigDecimal intrt2;

    @javax.persistence.Column(name = "INTRT2")
    @Basic
    public BigDecimal getIntrt2() {
        return intrt2;
    }

    public void setIntrt2(BigDecimal intrt2) {
        this.intrt2 = intrt2;
    }

    private BigDecimal rebrt2;

    @javax.persistence.Column(name = "REBRT2")
    @Basic
    public BigDecimal getRebrt2() {
        return rebrt2;
    }

    public void setRebrt2(BigDecimal rebrt2) {
        this.rebrt2 = rebrt2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrdEntity prdEntity = (PrdEntity) o;

        if (nracpt != prdEntity.nracpt) return false;
        if (nracpu != prdEntity.nracpu) return false;
        if (nroffr != prdEntity.nroffr) return false;
        if (nroffu != prdEntity.nroffu) return false;
        if (nrpaidt != prdEntity.nrpaidt) return false;
        if (nrpaidu != prdEntity.nrpaidu) return false;
        if (revlev != prdEntity.revlev) return false;
        if (aaidid != null ? !aaidid.equals(prdEntity.aaidid) : prdEntity.aaidid != null) return false;
        if (aidyr != null ? !aidyr.equals(prdEntity.aidyr) : prdEntity.aidyr != null) return false;
        if (amtacct != null ? !amtacct.equals(prdEntity.amtacct) : prdEntity.amtacct != null) return false;
        if (amtofft != null ? !amtofft.equals(prdEntity.amtofft) : prdEntity.amtofft != null) return false;
        if (amtpdt != null ? !amtpdt.equals(prdEntity.amtpdt) : prdEntity.amtpdt != null) return false;
        if (crtdtec != null ? !crtdtec.equals(prdEntity.crtdtec) : prdEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(prdEntity.crtmod) : prdEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(prdEntity.crttime) : prdEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(prdEntity.crtuser) : prdEntity.crtuser != null) return false;
        if (effdte != null ? !effdte.equals(prdEntity.effdte) : prdEntity.effdte != null) return false;
        if (feeamt != null ? !feeamt.equals(prdEntity.feeamt) : prdEntity.feeamt != null) return false;
        if (feerte != null ? !feerte.equals(prdEntity.feerte) : prdEntity.feerte != null) return false;
        if (feltyp != null ? !feltyp.equals(prdEntity.feltyp) : prdEntity.feltyp != null) return false;
        if (ferte2 != null ? !ferte2.equals(prdEntity.ferte2) : prdEntity.ferte2 != null) return false;
        if (instid != null ? !instid.equals(prdEntity.instid) : prdEntity.instid != null) return false;
        if (intrate != null ? !intrate.equals(prdEntity.intrate) : prdEntity.intrate != null) return false;
        if (intrt2 != null ? !intrt2.equals(prdEntity.intrt2) : prdEntity.intrt2 != null) return false;
        if (lntype != null ? !lntype.equals(prdEntity.lntype) : prdEntity.lntype != null) return false;
        if (pgmtcd != null ? !pgmtcd.equals(prdEntity.pgmtcd) : prdEntity.pgmtcd != null) return false;
        if (prdkey != null ? !prdkey.equals(prdEntity.prdkey) : prdEntity.prdkey != null) return false;
        if (prflnd != null ? !prflnd.equals(prdEntity.prflnd) : prdEntity.prflnd != null) return false;
        if (product != null ? !product.equals(prdEntity.product) : prdEntity.product != null) return false;
        if (rebamt != null ? !rebamt.equals(prdEntity.rebamt) : prdEntity.rebamt != null) return false;
        if (rebrate != null ? !rebrate.equals(prdEntity.rebrate) : prdEntity.rebrate != null) return false;
        if (rebrt2 != null ? !rebrt2.equals(prdEntity.rebrt2) : prdEntity.rebrt2 != null) return false;
        if (revdtec != null ? !revdtec.equals(prdEntity.revdtec) : prdEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(prdEntity.revmod) : prdEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(prdEntity.revtime) : prdEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(prdEntity.revuser) : prdEntity.revuser != null) return false;
        if (rteupd != null ? !rteupd.equals(prdEntity.rteupd) : prdEntity.rteupd != null) return false;
        if (sid != null ? !sid.equals(prdEntity.sid) : prdEntity.sid != null) return false;
        if (sortgrp != null ? !sortgrp.equals(prdEntity.sortgrp) : prdEntity.sortgrp != null) return false;
        if (ucode != null ? !ucode.equals(prdEntity.ucode) : prdEntity.ucode != null) return false;
        if (usercd1 != null ? !usercd1.equals(prdEntity.usercd1) : prdEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(prdEntity.usercd2) : prdEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(prdEntity.usercd3) : prdEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(prdEntity.usercd4) : prdEntity.usercd4 != null) return false;
        if (usernr1 != null ? !usernr1.equals(prdEntity.usernr1) : prdEntity.usernr1 != null) return false;
        if (usernr2 != null ? !usernr2.equals(prdEntity.usernr2) : prdEntity.usernr2 != null) return false;
        if (usernr3 != null ? !usernr3.equals(prdEntity.usernr3) : prdEntity.usernr3 != null) return false;
        if (usernr4 != null ? !usernr4.equals(prdEntity.usernr4) : prdEntity.usernr4 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prdkey != null ? prdkey.hashCode() : 0;
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
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
        result = 31 * result + (sortgrp != null ? sortgrp.hashCode() : 0);
        result = 31 * result + (feeamt != null ? feeamt.hashCode() : 0);
        result = 31 * result + (feerte != null ? feerte.hashCode() : 0);
        result = 31 * result + (rebamt != null ? rebamt.hashCode() : 0);
        result = 31 * result + (rebrate != null ? rebrate.hashCode() : 0);
        result = 31 * result + (intrate != null ? intrate.hashCode() : 0);
        result = 31 * result + nroffr;
        result = 31 * result + nracpt;
        result = 31 * result + nrpaidt;
        result = 31 * result + nroffu;
        result = 31 * result + nracpu;
        result = 31 * result + nrpaidu;
        result = 31 * result + (amtofft != null ? amtofft.hashCode() : 0);
        result = 31 * result + (amtacct != null ? amtacct.hashCode() : 0);
        result = 31 * result + (amtpdt != null ? amtpdt.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + (usernr1 != null ? usernr1.hashCode() : 0);
        result = 31 * result + (usernr2 != null ? usernr2.hashCode() : 0);
        result = 31 * result + (usernr3 != null ? usernr3.hashCode() : 0);
        result = 31 * result + (usernr4 != null ? usernr4.hashCode() : 0);
        result = 31 * result + (pgmtcd != null ? pgmtcd.hashCode() : 0);
        result = 31 * result + (aaidid != null ? aaidid.hashCode() : 0);
        result = 31 * result + (lntype != null ? lntype.hashCode() : 0);
        result = 31 * result + (prflnd != null ? prflnd.hashCode() : 0);
        result = 31 * result + (ferte2 != null ? ferte2.hashCode() : 0);
        result = 31 * result + (effdte != null ? effdte.hashCode() : 0);
        result = 31 * result + (rteupd != null ? rteupd.hashCode() : 0);
        result = 31 * result + (feltyp != null ? feltyp.hashCode() : 0);
        result = 31 * result + (intrt2 != null ? intrt2.hashCode() : 0);
        result = 31 * result + (rebrt2 != null ? rebrt2.hashCode() : 0);
        return result;
    }
}
