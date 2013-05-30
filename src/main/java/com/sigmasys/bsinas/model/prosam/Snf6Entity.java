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
 * Date: 11/26/12
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNF6", schema = "SIGMA", catalog = "")
@Entity
public class Snf6Entity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnfkey();
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

    private String snfkey;

    @javax.persistence.Column(name = "SNFKEY")
    @Id
    public String getSnfkey() {
        return snfkey;
    }

    public void setSnfkey(String snfkey) {
        this.snfkey = snfkey;
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

    private String cmptype;

    @javax.persistence.Column(name = "CMPTYPE")
    @Basic
    public String getCmptype() {
        return cmptype;
    }

    public void setCmptype(String cmptype) {
        this.cmptype = cmptype;
    }

    private String versnr;

    @javax.persistence.Column(name = "VERSNR")
    @Basic
    public String getVersnr() {
        return versnr;
    }

    public void setVersnr(String versnr) {
        this.versnr = versnr;
    }

    private String vnrtst;

    @javax.persistence.Column(name = "VNRTST")
    @Basic
    public String getVnrtst() {
        return vnrtst;
    }

    public void setVnrtst(String vnrtst) {
        this.vnrtst = vnrtst;
    }

    private int vncwsi;

    @javax.persistence.Column(name = "VNCWSI")
    @Basic
    public int getVncwsi() {
        return vncwsi;
    }

    public void setVncwsi(int vncwsi) {
        this.vncwsi = vncwsi;
    }

    private int vnuntx;

    @javax.persistence.Column(name = "VNUNTX")
    @Basic
    public int getVnuntx() {
        return vnuntx;
    }

    public void setVnuntx(int vnuntx) {
        this.vnuntx = vnuntx;
    }

    private int vnntot;

    @javax.persistence.Column(name = "VNNTOT")
    @Basic
    public int getVnntot() {
        return vnntot;
    }

    public void setVnntot(int vnntot) {
        this.vnntot = vnntot;
    }

    private int vnssto;

    @javax.persistence.Column(name = "VNSSTO")
    @Basic
    public int getVnssto() {
        return vnssto;
    }

    public void setVnssto(int vnssto) {
        this.vnssto = vnssto;
    }

    private int vncsto;

    @javax.persistence.Column(name = "VNCSTO")
    @Basic
    public int getVncsto() {
        return vncsto;
    }

    public void setVncsto(int vncsto) {
        this.vncsto = vncsto;
    }

    private int vntdpn;

    @javax.persistence.Column(name = "VNTDPN")
    @Basic
    public int getVntdpn() {
        return vntdpn;
    }

    public void setVntdpn(int vntdpn) {
        this.vntdpn = vntdpn;
    }

    private int vnwfto;

    @javax.persistence.Column(name = "VNWFTO")
    @Basic
    public int getVnwfto() {
        return vnwfto;
    }

    public void setVnwfto(int vnwfto) {
        this.vnwfto = vnwfto;
    }

    private String vnnrps;

    @javax.persistence.Column(name = "VNNRPS")
    @Basic
    public String getVnnrps() {
        return vnnrps;
    }

    public void setVnnrps(String vnnrps) {
        this.vnnrps = vnnrps;
    }

    private int vnotntx;

    @javax.persistence.Column(name = "VNOTNTX")
    @Basic
    public int getVnotntx() {
        return vnotntx;
    }

    public void setVnotntx(int vnotntx) {
        this.vnotntx = vnotntx;
    }

    private String vnfsgn;

    @javax.persistence.Column(name = "VNFSGN")
    @Basic
    public String getVnfsgn() {
        return vnfsgn;
    }

    public void setVnfsgn(String vnfsgn) {
        this.vnfsgn = vnfsgn;
    }

    private BigInteger vnszhhd;

    @javax.persistence.Column(name = "VNSZHHD")
    @Basic
    public BigInteger getVnszhhd() {
        return vnszhhd;
    }

    public void setVnszhhd(BigInteger vnszhhd) {
        this.vnszhhd = vnszhhd;
    }

    private int vnhsalw;

    @javax.persistence.Column(name = "VNHSALW")
    @Basic
    public int getVnhsalw() {
        return vnhsalw;
    }

    public void setVnhsalw(int vnhsalw) {
        this.vnhsalw = vnhsalw;
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

        Snf6Entity that = (Snf6Entity) o;

        if (vncsto != that.vncsto) return false;
        if (vncwsi != that.vncwsi) return false;
        if (vnhsalw != that.vnhsalw) return false;
        if (vnntot != that.vnntot) return false;
        if (vnotntx != that.vnotntx) return false;
        if (vnssto != that.vnssto) return false;
        if (vntdpn != that.vntdpn) return false;
        if (vnuntx != that.vnuntx) return false;
        if (vnwfto != that.vnwfto) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snfkey != null ? !snfkey.equals(that.snfkey) : that.snfkey != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;
        if (vnfsgn != null ? !vnfsgn.equals(that.vnfsgn) : that.vnfsgn != null) return false;
        if (vnnrps != null ? !vnnrps.equals(that.vnnrps) : that.vnnrps != null) return false;
        if (vnrtst != null ? !vnrtst.equals(that.vnrtst) : that.vnrtst != null) return false;
        if (vnszhhd != null ? !vnszhhd.equals(that.vnszhhd) : that.vnszhhd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snfkey != null ? snfkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cmptype != null ? cmptype.hashCode() : 0);
        result = 31 * result + (versnr != null ? versnr.hashCode() : 0);
        result = 31 * result + (vnrtst != null ? vnrtst.hashCode() : 0);
        result = 31 * result + vncwsi;
        result = 31 * result + vnuntx;
        result = 31 * result + vnntot;
        result = 31 * result + vnssto;
        result = 31 * result + vncsto;
        result = 31 * result + vntdpn;
        result = 31 * result + vnwfto;
        result = 31 * result + (vnnrps != null ? vnnrps.hashCode() : 0);
        result = 31 * result + vnotntx;
        result = 31 * result + (vnfsgn != null ? vnfsgn.hashCode() : 0);
        result = 31 * result + (vnszhhd != null ? vnszhhd.hashCode() : 0);
        result = 31 * result + vnhsalw;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
