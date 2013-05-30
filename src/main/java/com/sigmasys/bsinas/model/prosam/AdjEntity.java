package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/25/12
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "ADJ", schema = "SIGMA", catalog = "")
@Entity
public class AdjEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getAdjkey();
    }

    private String adjkey;

    @javax.persistence.Column(name = "ADJKEY")
    @Id
    public String getAdjkey() {
        return adjkey;
    }

    public void setAdjkey(String adjkey) {
        this.adjkey = adjkey;
    }

    private String trnrec;

    @javax.persistence.Column(name = "TRNREC")
    @Basic
    public String getTrnrec() {
        return trnrec;
    }

    public void setTrnrec(String trnrec) {
        this.trnrec = trnrec;
    }

    private BigDecimal mempaid;

    @javax.persistence.Column(name = "MEMPAID")
    @Basic
    public BigDecimal getMempaid() {
        return mempaid;
    }

    public void setMempaid(BigDecimal mempaid) {
        this.mempaid = mempaid;
    }

    private String sname;

    @javax.persistence.Column(name = "SNAME")
    @Basic
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    private String sitime;

    @javax.persistence.Column(name = "SITIME")
    @Basic
    public String getSitime() {
        return sitime;
    }

    public void setSitime(String sitime) {
        this.sitime = sitime;
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

    private String trndtec;

    @javax.persistence.Column(name = "TRNDTEC")
    @Basic
    public String getTrndtec() {
        return trndtec;
    }

    public void setTrndtec(String trndtec) {
        this.trndtec = trndtec;
    }

    private String cretdtc;

    @javax.persistence.Column(name = "CRETDTC")
    @Basic
    public String getCretdtc() {
        return cretdtc;
    }

    public void setCretdtc(String cretdtc) {
        this.cretdtc = cretdtc;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdjEntity adjEntity = (AdjEntity) o;

        if (adjkey != null ? !adjkey.equals(adjEntity.adjkey) : adjEntity.adjkey != null) return false;
        if (cretdtc != null ? !cretdtc.equals(adjEntity.cretdtc) : adjEntity.cretdtc != null) return false;
        if (initals != null ? !initals.equals(adjEntity.initals) : adjEntity.initals != null) return false;
        if (mempaid != null ? !mempaid.equals(adjEntity.mempaid) : adjEntity.mempaid != null) return false;
        if (module != null ? !module.equals(adjEntity.module) : adjEntity.module != null) return false;
        if (revdtec != null ? !revdtec.equals(adjEntity.revdtec) : adjEntity.revdtec != null) return false;
        if (revlev != null ? !revlev.equals(adjEntity.revlev) : adjEntity.revlev != null) return false;
        if (sitime != null ? !sitime.equals(adjEntity.sitime) : adjEntity.sitime != null) return false;
        if (sname != null ? !sname.equals(adjEntity.sname) : adjEntity.sname != null) return false;
        if (trndtec != null ? !trndtec.equals(adjEntity.trndtec) : adjEntity.trndtec != null) return false;
        if (trnrec != null ? !trnrec.equals(adjEntity.trnrec) : adjEntity.trnrec != null) return false;
        if (ucode != null ? !ucode.equals(adjEntity.ucode) : adjEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adjkey != null ? adjkey.hashCode() : 0;
        result = 31 * result + (trnrec != null ? trnrec.hashCode() : 0);
        result = 31 * result + (mempaid != null ? mempaid.hashCode() : 0);
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (sitime != null ? sitime.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (trndtec != null ? trndtec.hashCode() : 0);
        result = 31 * result + (cretdtc != null ? cretdtc.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        return result;
    }
}
