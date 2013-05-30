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
 * Time: 12:38 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "XCM", schema = "SIGMA", catalog = "")
@Entity
public class XcmEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getXcmkey();
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

    private String xcmkey;

    @javax.persistence.Column(name = "XCMKEY")
    @Id
    public String getXcmkey() {
        return xcmkey;
    }

    public void setXcmkey(String xcmkey) {
        this.xcmkey = xcmkey;
    }

    private String trandt;

    @javax.persistence.Column(name = "TRANDT")
    @Basic
    public String getTrandt() {
        return trandt;
    }

    public void setTrandt(String trandt) {
        this.trandt = trandt;
    }

    private String delim;

    @javax.persistence.Column(name = "DELIM")
    @Basic
    public String getDelim() {
        return delim;
    }

    public void setDelim(String delim) {
        this.delim = delim;
    }

    private String trantm;

    @javax.persistence.Column(name = "TRANTM")
    @Basic
    public String getTrantm() {
        return trantm;
    }

    public void setTrantm(String trantm) {
        this.trantm = trantm;
    }

    private int transq;

    @javax.persistence.Column(name = "TRANSQ")
    @Basic
    public int getTransq() {
        return transq;
    }

    public void setTransq(int transq) {
        this.transq = transq;
    }

    private BigInteger subseq;

    @javax.persistence.Column(name = "SUBSEQ")
    @Basic
    public BigInteger getSubseq() {
        return subseq;
    }

    public void setSubseq(BigInteger subseq) {
        this.subseq = subseq;
    }

    private String primid;

    @javax.persistence.Column(name = "PRIMID")
    @Basic
    public String getPrimid() {
        return primid;
    }

    public void setPrimid(String primid) {
        this.primid = primid;
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

    private String acton;

    @javax.persistence.Column(name = "ACTON")
    @Basic
    public String getActon() {
        return acton;
    }

    public void setActon(String acton) {
        this.acton = acton;
    }

    private String adtype;

    @javax.persistence.Column(name = "ADTYPE")
    @Basic
    public String getAdtype() {
        return adtype;
    }

    public void setAdtype(String adtype) {
        this.adtype = adtype;
    }

    private String comtyp;

    @javax.persistence.Column(name = "COMTYP")
    @Basic
    public String getComtyp() {
        return comtyp;
    }

    public void setComtyp(String comtyp) {
        this.comtyp = comtyp;
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

    private String begdte;

    @javax.persistence.Column(name = "BEGDTE")
    @Basic
    public String getBegdte() {
        return begdte;
    }

    public void setBegdte(String begdte) {
        this.begdte = begdte;
    }

    private String enddte;

    @javax.persistence.Column(name = "ENDDTE")
    @Basic
    public String getEnddte() {
        return enddte;
    }

    public void setEnddte(String enddte) {
        this.enddte = enddte;
    }

    private String comdat;

    @javax.persistence.Column(name = "COMDAT")
    @Basic
    public String getComdat() {
        return comdat;
    }

    public void setComdat(String comdat) {
        this.comdat = comdat;
    }

    private String updte;

    @javax.persistence.Column(name = "UPDTE")
    @Basic
    public String getUpdte() {
        return updte;
    }

    public void setUpdte(String updte) {
        this.updte = updte;
    }

    private String triggr;

    @javax.persistence.Column(name = "TRIGGR")
    @Basic
    public String getTriggr() {
        return triggr;
    }

    public void setTriggr(String triggr) {
        this.triggr = triggr;
    }

    private int tblatt;

    @javax.persistence.Column(name = "TBLATT")
    @Basic
    public int getTblatt() {
        return tblatt;
    }

    public void setTblatt(int tblatt) {
        this.tblatt = tblatt;
    }

    private String tblerr;

    @javax.persistence.Column(name = "TBLERR")
    @Basic
    public String getTblerr() {
        return tblerr;
    }

    public void setTblerr(String tblerr) {
        this.tblerr = tblerr;
    }

    private String tbldte;

    @javax.persistence.Column(name = "TBLDTE")
    @Basic
    public String getTbldte() {
        return tbldte;
    }

    public void setTbldte(String tbldte) {
        this.tbldte = tbldte;
    }

    private String tbltm;

    @javax.persistence.Column(name = "TBLTM")
    @Basic
    public String getTbltm() {
        return tbltm;
    }

    public void setTbltm(String tbltm) {
        this.tbltm = tbltm;
    }

    private int triatt;

    @javax.persistence.Column(name = "TRIATT")
    @Basic
    public int getTriatt() {
        return triatt;
    }

    public void setTriatt(int triatt) {
        this.triatt = triatt;
    }

    private String trierr;

    @javax.persistence.Column(name = "TRIERR")
    @Basic
    public String getTrierr() {
        return trierr;
    }

    public void setTrierr(String trierr) {
        this.trierr = trierr;
    }

    private String tridte;

    @javax.persistence.Column(name = "TRIDTE")
    @Basic
    public String getTridte() {
        return tridte;
    }

    public void setTridte(String tridte) {
        this.tridte = tridte;
    }

    private String tritm;

    @javax.persistence.Column(name = "TRITM")
    @Basic
    public String getTritm() {
        return tritm;
    }

    public void setTritm(String tritm) {
        this.tritm = tritm;
    }

    private String arules;

    @javax.persistence.Column(name = "ARULES")
    @Basic
    public String getArules() {
        return arules;
    }

    public void setArules(String arules) {
        this.arules = arules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XcmEntity xcmEntity = (XcmEntity) o;

        if (revlev != xcmEntity.revlev) return false;
        if (tblatt != xcmEntity.tblatt) return false;
        if (transq != xcmEntity.transq) return false;
        if (triatt != xcmEntity.triatt) return false;
        if (acton != null ? !acton.equals(xcmEntity.acton) : xcmEntity.acton != null) return false;
        if (adtype != null ? !adtype.equals(xcmEntity.adtype) : xcmEntity.adtype != null) return false;
        if (arules != null ? !arules.equals(xcmEntity.arules) : xcmEntity.arules != null) return false;
        if (begdte != null ? !begdte.equals(xcmEntity.begdte) : xcmEntity.begdte != null) return false;
        if (comdat != null ? !comdat.equals(xcmEntity.comdat) : xcmEntity.comdat != null) return false;
        if (comtyp != null ? !comtyp.equals(xcmEntity.comtyp) : xcmEntity.comtyp != null) return false;
        if (crtdtec != null ? !crtdtec.equals(xcmEntity.crtdtec) : xcmEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(xcmEntity.crtmod) : xcmEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(xcmEntity.crttime) : xcmEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(xcmEntity.crtuser) : xcmEntity.crtuser != null) return false;
        if (delim != null ? !delim.equals(xcmEntity.delim) : xcmEntity.delim != null) return false;
        if (enddte != null ? !enddte.equals(xcmEntity.enddte) : xcmEntity.enddte != null) return false;
        if (primid != null ? !primid.equals(xcmEntity.primid) : xcmEntity.primid != null) return false;
        if (recstat != null ? !recstat.equals(xcmEntity.recstat) : xcmEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(xcmEntity.revdtec) : xcmEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(xcmEntity.revmod) : xcmEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(xcmEntity.revtime) : xcmEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(xcmEntity.revuser) : xcmEntity.revuser != null) return false;
        if (status != null ? !status.equals(xcmEntity.status) : xcmEntity.status != null) return false;
        if (subseq != null ? !subseq.equals(xcmEntity.subseq) : xcmEntity.subseq != null) return false;
        if (tbldte != null ? !tbldte.equals(xcmEntity.tbldte) : xcmEntity.tbldte != null) return false;
        if (tblerr != null ? !tblerr.equals(xcmEntity.tblerr) : xcmEntity.tblerr != null) return false;
        if (tbltm != null ? !tbltm.equals(xcmEntity.tbltm) : xcmEntity.tbltm != null) return false;
        if (trandt != null ? !trandt.equals(xcmEntity.trandt) : xcmEntity.trandt != null) return false;
        if (trantm != null ? !trantm.equals(xcmEntity.trantm) : xcmEntity.trantm != null) return false;
        if (tridte != null ? !tridte.equals(xcmEntity.tridte) : xcmEntity.tridte != null) return false;
        if (trierr != null ? !trierr.equals(xcmEntity.trierr) : xcmEntity.trierr != null) return false;
        if (triggr != null ? !triggr.equals(xcmEntity.triggr) : xcmEntity.triggr != null) return false;
        if (tritm != null ? !tritm.equals(xcmEntity.tritm) : xcmEntity.tritm != null) return false;
        if (ucode != null ? !ucode.equals(xcmEntity.ucode) : xcmEntity.ucode != null) return false;
        if (updte != null ? !updte.equals(xcmEntity.updte) : xcmEntity.updte != null) return false;
        if (xcmkey != null ? !xcmkey.equals(xcmEntity.xcmkey) : xcmEntity.xcmkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (xcmkey != null ? xcmkey.hashCode() : 0);
        result = 31 * result + (trandt != null ? trandt.hashCode() : 0);
        result = 31 * result + (delim != null ? delim.hashCode() : 0);
        result = 31 * result + (trantm != null ? trantm.hashCode() : 0);
        result = 31 * result + transq;
        result = 31 * result + (subseq != null ? subseq.hashCode() : 0);
        result = 31 * result + (primid != null ? primid.hashCode() : 0);
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
        result = 31 * result + (acton != null ? acton.hashCode() : 0);
        result = 31 * result + (adtype != null ? adtype.hashCode() : 0);
        result = 31 * result + (comtyp != null ? comtyp.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (begdte != null ? begdte.hashCode() : 0);
        result = 31 * result + (enddte != null ? enddte.hashCode() : 0);
        result = 31 * result + (comdat != null ? comdat.hashCode() : 0);
        result = 31 * result + (updte != null ? updte.hashCode() : 0);
        result = 31 * result + (triggr != null ? triggr.hashCode() : 0);
        result = 31 * result + tblatt;
        result = 31 * result + (tblerr != null ? tblerr.hashCode() : 0);
        result = 31 * result + (tbldte != null ? tbldte.hashCode() : 0);
        result = 31 * result + (tbltm != null ? tbltm.hashCode() : 0);
        result = 31 * result + triatt;
        result = 31 * result + (trierr != null ? trierr.hashCode() : 0);
        result = 31 * result + (tridte != null ? tridte.hashCode() : 0);
        result = 31 * result + (tritm != null ? tritm.hashCode() : 0);
        result = 31 * result + (arules != null ? arules.hashCode() : 0);
        return result;
    }
}
