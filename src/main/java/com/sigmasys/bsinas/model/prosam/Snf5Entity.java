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
@javax.persistence.Table(name = "SNF5", schema = "SIGMA", catalog = "")
@Entity
public class Snf5Entity implements Identifiable {

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

    private String pttform;

    @javax.persistence.Column(name = "PTTFORM")
    @Basic
    public String getPttform() {
        return pttform;
    }

    public void setPttform(String pttform) {
        this.pttform = pttform;
    }

    private String ptrvwin;

    @javax.persistence.Column(name = "PTRVWIN")
    @Basic
    public String getPtrvwin() {
        return ptrvwin;
    }

    public void setPtrvwin(String ptrvwin) {
        this.ptrvwin = ptrvwin;
    }

    private String sttform;

    @javax.persistence.Column(name = "STTFORM")
    @Basic
    public String getSttform() {
        return sttform;
    }

    public void setSttform(String sttform) {
        this.sttform = sttform;
    }

    private String strvwin;

    @javax.persistence.Column(name = "STRVWIN")
    @Basic
    public String getStrvwin() {
        return strvwin;
    }

    public void setStrvwin(String strvwin) {
        this.strvwin = strvwin;
    }

    private String nttform;

    @javax.persistence.Column(name = "NTTFORM")
    @Basic
    public String getNttform() {
        return nttform;
    }

    public void setNttform(String nttform) {
        this.nttform = nttform;
    }

    private String ntrvwin;

    @javax.persistence.Column(name = "NTRVWIN")
    @Basic
    public String getNtrvwin() {
        return ntrvwin;
    }

    public void setNtrvwin(String ntrvwin) {
        this.ntrvwin = ntrvwin;
    }

    private String vprtst;

    @javax.persistence.Column(name = "VPRTST")
    @Basic
    public String getVprtst() {
        return vprtst;
    }

    public void setVprtst(String vprtst) {
        this.vprtst = vprtst;
    }

    private int vpcwsi;

    @javax.persistence.Column(name = "VPCWSI")
    @Basic
    public int getVpcwsi() {
        return vpcwsi;
    }

    public void setVpcwsi(int vpcwsi) {
        this.vpcwsi = vpcwsi;
    }

    private int vpuntx;

    @javax.persistence.Column(name = "VPUNTX")
    @Basic
    public int getVpuntx() {
        return vpuntx;
    }

    public void setVpuntx(int vpuntx) {
        this.vpuntx = vpuntx;
    }

    private int vpntot;

    @javax.persistence.Column(name = "VPNTOT")
    @Basic
    public int getVpntot() {
        return vpntot;
    }

    public void setVpntot(int vpntot) {
        this.vpntot = vpntot;
    }

    private int vpssto;

    @javax.persistence.Column(name = "VPSSTO")
    @Basic
    public int getVpssto() {
        return vpssto;
    }

    public void setVpssto(int vpssto) {
        this.vpssto = vpssto;
    }

    private int vpcsto;

    @javax.persistence.Column(name = "VPCSTO")
    @Basic
    public int getVpcsto() {
        return vpcsto;
    }

    public void setVpcsto(int vpcsto) {
        this.vpcsto = vpcsto;
    }

    private int vptdpn;

    @javax.persistence.Column(name = "VPTDPN")
    @Basic
    public int getVptdpn() {
        return vptdpn;
    }

    public void setVptdpn(int vptdpn) {
        this.vptdpn = vptdpn;
    }

    private int vpwfto;

    @javax.persistence.Column(name = "VPWFTO")
    @Basic
    public int getVpwfto() {
        return vpwfto;
    }

    public void setVpwfto(int vpwfto) {
        this.vpwfto = vpwfto;
    }

    private String vpnrps;

    @javax.persistence.Column(name = "VPNRPS")
    @Basic
    public String getVpnrps() {
        return vpnrps;
    }

    public void setVpnrps(String vpnrps) {
        this.vpnrps = vpnrps;
    }

    private int vpotntx;

    @javax.persistence.Column(name = "VPOTNTX")
    @Basic
    public int getVpotntx() {
        return vpotntx;
    }

    public void setVpotntx(int vpotntx) {
        this.vpotntx = vpotntx;
    }

    private String vpfsgn;

    @javax.persistence.Column(name = "VPFSGN")
    @Basic
    public String getVpfsgn() {
        return vpfsgn;
    }

    public void setVpfsgn(String vpfsgn) {
        this.vpfsgn = vpfsgn;
    }

    private BigInteger vpszhhd;

    @javax.persistence.Column(name = "VPSZHHD")
    @Basic
    public BigInteger getVpszhhd() {
        return vpszhhd;
    }

    public void setVpszhhd(BigInteger vpszhhd) {
        this.vpszhhd = vpszhhd;
    }

    private String procst;

    @javax.persistence.Column(name = "PROCST")
    @Basic
    public String getProcst() {
        return procst;
    }

    public void setProcst(String procst) {
        this.procst = procst;
    }

    private int vphsalw;

    @javax.persistence.Column(name = "VPHSALW")
    @Basic
    public int getVphsalw() {
        return vphsalw;
    }

    public void setVphsalw(int vphsalw) {
        this.vphsalw = vphsalw;
    }

    private String vsrtst;

    @javax.persistence.Column(name = "VSRTST")
    @Basic
    public String getVsrtst() {
        return vsrtst;
    }

    public void setVsrtst(String vsrtst) {
        this.vsrtst = vsrtst;
    }

    private int vscwsi;

    @javax.persistence.Column(name = "VSCWSI")
    @Basic
    public int getVscwsi() {
        return vscwsi;
    }

    public void setVscwsi(int vscwsi) {
        this.vscwsi = vscwsi;
    }

    private int vsuntx;

    @javax.persistence.Column(name = "VSUNTX")
    @Basic
    public int getVsuntx() {
        return vsuntx;
    }

    public void setVsuntx(int vsuntx) {
        this.vsuntx = vsuntx;
    }

    private int vsntot;

    @javax.persistence.Column(name = "VSNTOT")
    @Basic
    public int getVsntot() {
        return vsntot;
    }

    public void setVsntot(int vsntot) {
        this.vsntot = vsntot;
    }

    private int vsssto;

    @javax.persistence.Column(name = "VSSSTO")
    @Basic
    public int getVsssto() {
        return vsssto;
    }

    public void setVsssto(int vsssto) {
        this.vsssto = vsssto;
    }

    private int vscsto;

    @javax.persistence.Column(name = "VSCSTO")
    @Basic
    public int getVscsto() {
        return vscsto;
    }

    public void setVscsto(int vscsto) {
        this.vscsto = vscsto;
    }

    private int vstdpn;

    @javax.persistence.Column(name = "VSTDPN")
    @Basic
    public int getVstdpn() {
        return vstdpn;
    }

    public void setVstdpn(int vstdpn) {
        this.vstdpn = vstdpn;
    }

    private int vswfto;

    @javax.persistence.Column(name = "VSWFTO")
    @Basic
    public int getVswfto() {
        return vswfto;
    }

    public void setVswfto(int vswfto) {
        this.vswfto = vswfto;
    }

    private String vsnrps;

    @javax.persistence.Column(name = "VSNRPS")
    @Basic
    public String getVsnrps() {
        return vsnrps;
    }

    public void setVsnrps(String vsnrps) {
        this.vsnrps = vsnrps;
    }

    private int vsotntx;

    @javax.persistence.Column(name = "VSOTNTX")
    @Basic
    public int getVsotntx() {
        return vsotntx;
    }

    public void setVsotntx(int vsotntx) {
        this.vsotntx = vsotntx;
    }

    private String vsfsgn;

    @javax.persistence.Column(name = "VSFSGN")
    @Basic
    public String getVsfsgn() {
        return vsfsgn;
    }

    public void setVsfsgn(String vsfsgn) {
        this.vsfsgn = vsfsgn;
    }

    private String vsszhhd;

    @javax.persistence.Column(name = "VSSZHHD")
    @Basic
    public String getVsszhhd() {
        return vsszhhd;
    }

    public void setVsszhhd(String vsszhhd) {
        this.vsszhhd = vsszhhd;
    }

    private int vshsalw;

    @javax.persistence.Column(name = "VSHSALW")
    @Basic
    public int getVshsalw() {
        return vshsalw;
    }

    public void setVshsalw(int vshsalw) {
        this.vshsalw = vshsalw;
    }

    private int vsgiamt;

    @javax.persistence.Column(name = "VSGIAMT")
    @Basic
    public int getVsgiamt() {
        return vsgiamt;
    }

    public void setVsgiamt(int vsgiamt) {
        this.vsgiamt = vsgiamt;
    }

    private BigInteger vsgimth;

    @javax.persistence.Column(name = "VSGIMTH")
    @Basic
    public BigInteger getVsgimth() {
        return vsgimth;
    }

    public void setVsgimth(BigInteger vsgimth) {
        this.vsgimth = vsgimth;
    }

    private int vsgitot;

    @javax.persistence.Column(name = "VSGITOT")
    @Basic
    public int getVsgitot() {
        return vsgitot;
    }

    public void setVsgitot(int vsgitot) {
        this.vsgitot = vsgitot;
    }

    private int vsvpamt;

    @javax.persistence.Column(name = "VSVPAMT")
    @Basic
    public int getVsvpamt() {
        return vsvpamt;
    }

    public void setVsvpamt(int vsvpamt) {
        this.vsvpamt = vsvpamt;
    }

    private BigInteger vsvpmth;

    @javax.persistence.Column(name = "VSVPMTH")
    @Basic
    public BigInteger getVsvpmth() {
        return vsvpmth;
    }

    public void setVsvpmth(BigInteger vsvpmth) {
        this.vsvpmth = vsvpmth;
    }

    private int vsvptot;

    @javax.persistence.Column(name = "VSVPTOT")
    @Basic
    public int getVsvptot() {
        return vsvptot;
    }

    public void setVsvptot(int vsvptot) {
        this.vsvptot = vsvptot;
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

        Snf5Entity that = (Snf5Entity) o;

        if (vpcsto != that.vpcsto) return false;
        if (vpcwsi != that.vpcwsi) return false;
        if (vphsalw != that.vphsalw) return false;
        if (vpntot != that.vpntot) return false;
        if (vpotntx != that.vpotntx) return false;
        if (vpssto != that.vpssto) return false;
        if (vptdpn != that.vptdpn) return false;
        if (vpuntx != that.vpuntx) return false;
        if (vpwfto != that.vpwfto) return false;
        if (vscsto != that.vscsto) return false;
        if (vscwsi != that.vscwsi) return false;
        if (vsgiamt != that.vsgiamt) return false;
        if (vsgitot != that.vsgitot) return false;
        if (vshsalw != that.vshsalw) return false;
        if (vsntot != that.vsntot) return false;
        if (vsotntx != that.vsotntx) return false;
        if (vsssto != that.vsssto) return false;
        if (vstdpn != that.vstdpn) return false;
        if (vsuntx != that.vsuntx) return false;
        if (vsvpamt != that.vsvpamt) return false;
        if (vsvptot != that.vsvptot) return false;
        if (vswfto != that.vswfto) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (ntrvwin != null ? !ntrvwin.equals(that.ntrvwin) : that.ntrvwin != null) return false;
        if (nttform != null ? !nttform.equals(that.nttform) : that.nttform != null) return false;
        if (procst != null ? !procst.equals(that.procst) : that.procst != null) return false;
        if (ptrvwin != null ? !ptrvwin.equals(that.ptrvwin) : that.ptrvwin != null) return false;
        if (pttform != null ? !pttform.equals(that.pttform) : that.pttform != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snfkey != null ? !snfkey.equals(that.snfkey) : that.snfkey != null) return false;
        if (strvwin != null ? !strvwin.equals(that.strvwin) : that.strvwin != null) return false;
        if (sttform != null ? !sttform.equals(that.sttform) : that.sttform != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;
        if (vpfsgn != null ? !vpfsgn.equals(that.vpfsgn) : that.vpfsgn != null) return false;
        if (vpnrps != null ? !vpnrps.equals(that.vpnrps) : that.vpnrps != null) return false;
        if (vprtst != null ? !vprtst.equals(that.vprtst) : that.vprtst != null) return false;
        if (vpszhhd != null ? !vpszhhd.equals(that.vpszhhd) : that.vpszhhd != null) return false;
        if (vsfsgn != null ? !vsfsgn.equals(that.vsfsgn) : that.vsfsgn != null) return false;
        if (vsgimth != null ? !vsgimth.equals(that.vsgimth) : that.vsgimth != null) return false;
        if (vsnrps != null ? !vsnrps.equals(that.vsnrps) : that.vsnrps != null) return false;
        if (vsrtst != null ? !vsrtst.equals(that.vsrtst) : that.vsrtst != null) return false;
        if (vsszhhd != null ? !vsszhhd.equals(that.vsszhhd) : that.vsszhhd != null) return false;
        if (vsvpmth != null ? !vsvpmth.equals(that.vsvpmth) : that.vsvpmth != null) return false;

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
        result = 31 * result + (pttform != null ? pttform.hashCode() : 0);
        result = 31 * result + (ptrvwin != null ? ptrvwin.hashCode() : 0);
        result = 31 * result + (sttform != null ? sttform.hashCode() : 0);
        result = 31 * result + (strvwin != null ? strvwin.hashCode() : 0);
        result = 31 * result + (nttform != null ? nttform.hashCode() : 0);
        result = 31 * result + (ntrvwin != null ? ntrvwin.hashCode() : 0);
        result = 31 * result + (vprtst != null ? vprtst.hashCode() : 0);
        result = 31 * result + vpcwsi;
        result = 31 * result + vpuntx;
        result = 31 * result + vpntot;
        result = 31 * result + vpssto;
        result = 31 * result + vpcsto;
        result = 31 * result + vptdpn;
        result = 31 * result + vpwfto;
        result = 31 * result + (vpnrps != null ? vpnrps.hashCode() : 0);
        result = 31 * result + vpotntx;
        result = 31 * result + (vpfsgn != null ? vpfsgn.hashCode() : 0);
        result = 31 * result + (vpszhhd != null ? vpszhhd.hashCode() : 0);
        result = 31 * result + (procst != null ? procst.hashCode() : 0);
        result = 31 * result + vphsalw;
        result = 31 * result + (vsrtst != null ? vsrtst.hashCode() : 0);
        result = 31 * result + vscwsi;
        result = 31 * result + vsuntx;
        result = 31 * result + vsntot;
        result = 31 * result + vsssto;
        result = 31 * result + vscsto;
        result = 31 * result + vstdpn;
        result = 31 * result + vswfto;
        result = 31 * result + (vsnrps != null ? vsnrps.hashCode() : 0);
        result = 31 * result + vsotntx;
        result = 31 * result + (vsfsgn != null ? vsfsgn.hashCode() : 0);
        result = 31 * result + (vsszhhd != null ? vsszhhd.hashCode() : 0);
        result = 31 * result + vshsalw;
        result = 31 * result + vsgiamt;
        result = 31 * result + (vsgimth != null ? vsgimth.hashCode() : 0);
        result = 31 * result + vsgitot;
        result = 31 * result + vsvpamt;
        result = 31 * result + (vsvpmth != null ? vsvpmth.hashCode() : 0);
        result = 31 * result + vsvptot;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
