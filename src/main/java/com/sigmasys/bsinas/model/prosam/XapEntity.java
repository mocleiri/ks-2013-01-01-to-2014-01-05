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
@javax.persistence.Table(name = "XAP", schema = "SIGMA", catalog = "")
@Entity
public class XapEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getXapkey();
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

    private String xapkey;

    @javax.persistence.Column(name = "XAPKEY")
    @Id
    public String getXapkey() {
        return xapkey;
    }

    public void setXapkey(String xapkey) {
        this.xapkey = xapkey;
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

    private String aidyr;

    @javax.persistence.Column(name = "AIDYR")
    @Basic
    public String getAidyr() {
        return aidyr;
    }

    public void setAidyr(String aidyr) {
        this.aidyr = aidyr;
    }

    private String term;

    @javax.persistence.Column(name = "TERM")
    @Basic
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    private String catgory;

    @javax.persistence.Column(name = "CATGORY")
    @Basic
    public String getCatgory() {
        return catgory;
    }

    public void setCatgory(String catgory) {
        this.catgory = catgory;
    }

    private String valu;

    @javax.persistence.Column(name = "VALU")
    @Basic
    public String getValu() {
        return valu;
    }

    public void setValu(String valu) {
        this.valu = valu;
    }

    private String divisn;

    @javax.persistence.Column(name = "DIVISN")
    @Basic
    public String getDivisn() {
        return divisn;
    }

    public void setDivisn(String divisn) {
        this.divisn = divisn;
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

    private String scycle;

    @javax.persistence.Column(name = "SCYCLE")
    @Basic
    public String getScycle() {
        return scycle;
    }

    public void setScycle(String scycle) {
        this.scycle = scycle;
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

        XapEntity xapEntity = (XapEntity) o;

        if (revlev != xapEntity.revlev) return false;
        if (tblatt != xapEntity.tblatt) return false;
        if (transq != xapEntity.transq) return false;
        if (triatt != xapEntity.triatt) return false;
        if (acton != null ? !acton.equals(xapEntity.acton) : xapEntity.acton != null) return false;
        if (aidyr != null ? !aidyr.equals(xapEntity.aidyr) : xapEntity.aidyr != null) return false;
        if (arules != null ? !arules.equals(xapEntity.arules) : xapEntity.arules != null) return false;
        if (catgory != null ? !catgory.equals(xapEntity.catgory) : xapEntity.catgory != null) return false;
        if (crtdtec != null ? !crtdtec.equals(xapEntity.crtdtec) : xapEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(xapEntity.crtmod) : xapEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(xapEntity.crttime) : xapEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(xapEntity.crtuser) : xapEntity.crtuser != null) return false;
        if (delim != null ? !delim.equals(xapEntity.delim) : xapEntity.delim != null) return false;
        if (divisn != null ? !divisn.equals(xapEntity.divisn) : xapEntity.divisn != null) return false;
        if (primid != null ? !primid.equals(xapEntity.primid) : xapEntity.primid != null) return false;
        if (recstat != null ? !recstat.equals(xapEntity.recstat) : xapEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(xapEntity.revdtec) : xapEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(xapEntity.revmod) : xapEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(xapEntity.revtime) : xapEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(xapEntity.revuser) : xapEntity.revuser != null) return false;
        if (scycle != null ? !scycle.equals(xapEntity.scycle) : xapEntity.scycle != null) return false;
        if (subseq != null ? !subseq.equals(xapEntity.subseq) : xapEntity.subseq != null) return false;
        if (tbldte != null ? !tbldte.equals(xapEntity.tbldte) : xapEntity.tbldte != null) return false;
        if (tblerr != null ? !tblerr.equals(xapEntity.tblerr) : xapEntity.tblerr != null) return false;
        if (tbltm != null ? !tbltm.equals(xapEntity.tbltm) : xapEntity.tbltm != null) return false;
        if (term != null ? !term.equals(xapEntity.term) : xapEntity.term != null) return false;
        if (trandt != null ? !trandt.equals(xapEntity.trandt) : xapEntity.trandt != null) return false;
        if (trantm != null ? !trantm.equals(xapEntity.trantm) : xapEntity.trantm != null) return false;
        if (tridte != null ? !tridte.equals(xapEntity.tridte) : xapEntity.tridte != null) return false;
        if (trierr != null ? !trierr.equals(xapEntity.trierr) : xapEntity.trierr != null) return false;
        if (triggr != null ? !triggr.equals(xapEntity.triggr) : xapEntity.triggr != null) return false;
        if (tritm != null ? !tritm.equals(xapEntity.tritm) : xapEntity.tritm != null) return false;
        if (ucode != null ? !ucode.equals(xapEntity.ucode) : xapEntity.ucode != null) return false;
        if (updte != null ? !updte.equals(xapEntity.updte) : xapEntity.updte != null) return false;
        if (valu != null ? !valu.equals(xapEntity.valu) : xapEntity.valu != null) return false;
        if (xapkey != null ? !xapkey.equals(xapEntity.xapkey) : xapEntity.xapkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (xapkey != null ? xapkey.hashCode() : 0);
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
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (catgory != null ? catgory.hashCode() : 0);
        result = 31 * result + (valu != null ? valu.hashCode() : 0);
        result = 31 * result + (divisn != null ? divisn.hashCode() : 0);
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
        result = 31 * result + (scycle != null ? scycle.hashCode() : 0);
        result = 31 * result + (arules != null ? arules.hashCode() : 0);
        return result;
    }
}
