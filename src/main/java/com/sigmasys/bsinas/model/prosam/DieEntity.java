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
 * Date: 11/25/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DIE", schema = "SIGMA", catalog = "")
@Entity
public class DieEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getDiekey();
    }

    private String diekey;

    @javax.persistence.Column(name = "DIEKEY")
    @Id
    public String getDiekey() {
        return diekey;
    }

    public void setDiekey(String diekey) {
        this.diekey = diekey;
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

    private String procyr;

    @javax.persistence.Column(name = "PROCYR")
    @Basic
    public String getProcyr() {
        return procyr;
    }

    public void setProcyr(String procyr) {
        this.procyr = procyr;
    }

    private String docid;

    @javax.persistence.Column(name = "DOCID")
    @Basic
    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    private String rschid;

    @javax.persistence.Column(name = "RSCHID")
    @Basic
    public String getRschid() {
        return rschid;
    }

    public void setRschid(String rschid) {
        this.rschid = rschid;
    }

    private String awdtyp;

    @javax.persistence.Column(name = "AWDTYP")
    @Basic
    public String getAwdtyp() {
        return awdtyp;
    }

    public void setAwdtyp(String awdtyp) {
        this.awdtyp = awdtyp;
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

    private String dentid;

    @javax.persistence.Column(name = "DENTID")
    @Basic
    public String getDentid() {
        return dentid;
    }

    public void setDentid(String dentid) {
        this.dentid = dentid;
    }

    private String frsflg;

    @javax.persistence.Column(name = "FRSFLG")
    @Basic
    public String getFrsflg() {
        return frsflg;
    }

    public void setFrsflg(String frsflg) {
        this.frsflg = frsflg;
    }

    private String recpt;

    @javax.persistence.Column(name = "RECPT")
    @Basic
    public String getRecpt() {
        return recpt;
    }

    public void setRecpt(String recpt) {
        this.recpt = recpt;
    }

    private String doctyp;

    @javax.persistence.Column(name = "DOCTYP")
    @Basic
    public String getDoctyp() {
        return doctyp;
    }

    public void setDoctyp(String doctyp) {
        this.doctyp = doctyp;
    }

    private String docst;

    @javax.persistence.Column(name = "DOCST")
    @Basic
    public String getDocst() {
        return docst;
    }

    public void setDocst(String docst) {
        this.docst = docst;
    }

    private String prcdte;

    @javax.persistence.Column(name = "PRCDTE")
    @Basic
    public String getPrcdte() {
        return prcdte;
    }

    public void setPrcdte(String prcdte) {
        this.prcdte = prcdte;
    }

    private int snstds;

    @javax.persistence.Column(name = "SNSTDS")
    @Basic
    public int getSnstds() {
        return snstds;
    }

    public void setSnstds(int snstds) {
        this.snstds = snstds;
    }

    private BigDecimal sawdam;

    @javax.persistence.Column(name = "SAWDAM")
    @Basic
    public BigDecimal getSawdam() {
        return sawdam;
    }

    public void setSawdam(BigDecimal sawdam) {
        this.sawdam = sawdam;
    }

    private BigDecimal samtrp;

    @javax.persistence.Column(name = "SAMTRP")
    @Basic
    public BigDecimal getSamtrp() {
        return samtrp;
    }

    public void setSamtrp(BigDecimal samtrp) {
        this.samtrp = samtrp;
    }

    private int rnstds;

    @javax.persistence.Column(name = "RNSTDS")
    @Basic
    public int getRnstds() {
        return rnstds;
    }

    public void setRnstds(int rnstds) {
        this.rnstds = rnstds;
    }

    private int raccpt;

    @javax.persistence.Column(name = "RACCPT")
    @Basic
    public int getRaccpt() {
        return raccpt;
    }

    public void setRaccpt(int raccpt) {
        this.raccpt = raccpt;
    }

    private int rrejct;

    @javax.persistence.Column(name = "RREJCT")
    @Basic
    public int getRrejct() {
        return rrejct;
    }

    public void setRrejct(int rrejct) {
        this.rrejct = rrejct;
    }

    private int rcorr;

    @javax.persistence.Column(name = "RCORR")
    @Basic
    public int getRcorr() {
        return rcorr;
    }

    public void setRcorr(int rcorr) {
        this.rcorr = rcorr;
    }

    private int rdupl;

    @javax.persistence.Column(name = "RDUPL")
    @Basic
    public int getRdupl() {
        return rdupl;
    }

    public void setRdupl(int rdupl) {
        this.rdupl = rdupl;
    }

    private int rheld;

    @javax.persistence.Column(name = "RHELD")
    @Basic
    public int getRheld() {
        return rheld;
    }

    public void setRheld(int rheld) {
        this.rheld = rheld;
    }

    private int rpartl;

    @javax.persistence.Column(name = "RPARTL")
    @Basic
    public int getRpartl() {
        return rpartl;
    }

    public void setRpartl(int rpartl) {
        this.rpartl = rpartl;
    }

    private int rverif;

    @javax.persistence.Column(name = "RVERIF")
    @Basic
    public int getRverif() {
        return rverif;
    }

    public void setRverif(int rverif) {
        this.rverif = rverif;
    }

    private int rssa;

    @javax.persistence.Column(name = "RSSA")
    @Basic
    public int getRssa() {
        return rssa;
    }

    public void setRssa(int rssa) {
        this.rssa = rssa;
    }

    private BigDecimal rawdam;

    @javax.persistence.Column(name = "RAWDAM")
    @Basic
    public BigDecimal getRawdam() {
        return rawdam;
    }

    public void setRawdam(BigDecimal rawdam) {
        this.rawdam = rawdam;
    }

    private BigDecimal ramtrp;

    @javax.persistence.Column(name = "RAMTRP")
    @Basic
    public BigDecimal getRamtrp() {
        return ramtrp;
    }

    public void setRamtrp(BigDecimal ramtrp) {
        this.ramtrp = ramtrp;
    }

    private BigDecimal ramtac;

    @javax.persistence.Column(name = "RAMTAC")
    @Basic
    public BigDecimal getRamtac() {
        return ramtac;
    }

    public void setRamtac(BigDecimal ramtac) {
        this.ramtac = ramtac;
    }

    private BigDecimal ramtcr;

    @javax.persistence.Column(name = "RAMTCR")
    @Basic
    public BigDecimal getRamtcr() {
        return ramtcr;
    }

    public void setRamtcr(BigDecimal ramtcr) {
        this.ramtcr = ramtcr;
    }

    private BigDecimal netdis;

    @javax.persistence.Column(name = "NETDIS")
    @Basic
    public BigDecimal getNetdis() {
        return netdis;
    }

    public void setNetdis(BigDecimal netdis) {
        this.netdis = netdis;
    }

    private BigDecimal neteft;

    @javax.persistence.Column(name = "NETEFT")
    @Basic
    public BigDecimal getNeteft() {
        return neteft;
    }

    public void setNeteft(BigDecimal neteft) {
        this.neteft = neteft;
    }

    private BigDecimal netnef;

    @javax.persistence.Column(name = "NETNEF")
    @Basic
    public BigDecimal getNetnef() {
        return netnef;
    }

    public void setNetnef(BigDecimal netnef) {
        this.netnef = netnef;
    }

    private BigDecimal reisue;

    @javax.persistence.Column(name = "REISUE")
    @Basic
    public BigDecimal getReisue() {
        return reisue;
    }

    public void setReisue(BigDecimal reisue) {
        this.reisue = reisue;
    }

    private BigDecimal totcan;

    @javax.persistence.Column(name = "TOTCAN")
    @Basic
    public BigDecimal getTotcan() {
        return totcan;
    }

    public void setTotcan(BigDecimal totcan) {
        this.totcan = totcan;
    }

    private BigDecimal outcan;

    @javax.persistence.Column(name = "OUTCAN")
    @Basic
    public BigDecimal getOutcan() {
        return outcan;
    }

    public void setOutcan(BigDecimal outcan) {
        this.outcan = outcan;
    }

    private BigDecimal netcan;

    @javax.persistence.Column(name = "NETCAN")
    @Basic
    public BigDecimal getNetcan() {
        return netcan;
    }

    public void setNetcan(BigDecimal netcan) {
        this.netcan = netcan;
    }

    private BigDecimal defict;

    @javax.persistence.Column(name = "DEFICT")
    @Basic
    public BigDecimal getDefict() {
        return defict;
    }

    public void setDefict(BigDecimal defict) {
        this.defict = defict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DieEntity dieEntity = (DieEntity) o;

        if (raccpt != dieEntity.raccpt) return false;
        if (rcorr != dieEntity.rcorr) return false;
        if (rdupl != dieEntity.rdupl) return false;
        if (revlev != dieEntity.revlev) return false;
        if (rheld != dieEntity.rheld) return false;
        if (rnstds != dieEntity.rnstds) return false;
        if (rpartl != dieEntity.rpartl) return false;
        if (rrejct != dieEntity.rrejct) return false;
        if (rssa != dieEntity.rssa) return false;
        if (rverif != dieEntity.rverif) return false;
        if (snstds != dieEntity.snstds) return false;
        if (awdtyp != null ? !awdtyp.equals(dieEntity.awdtyp) : dieEntity.awdtyp != null) return false;
        if (crtdtec != null ? !crtdtec.equals(dieEntity.crtdtec) : dieEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(dieEntity.crtmod) : dieEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(dieEntity.crttime) : dieEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(dieEntity.crtuser) : dieEntity.crtuser != null) return false;
        if (defict != null ? !defict.equals(dieEntity.defict) : dieEntity.defict != null) return false;
        if (dentid != null ? !dentid.equals(dieEntity.dentid) : dieEntity.dentid != null) return false;
        if (diekey != null ? !diekey.equals(dieEntity.diekey) : dieEntity.diekey != null) return false;
        if (docid != null ? !docid.equals(dieEntity.docid) : dieEntity.docid != null) return false;
        if (docst != null ? !docst.equals(dieEntity.docst) : dieEntity.docst != null) return false;
        if (doctyp != null ? !doctyp.equals(dieEntity.doctyp) : dieEntity.doctyp != null) return false;
        if (frsflg != null ? !frsflg.equals(dieEntity.frsflg) : dieEntity.frsflg != null) return false;
        if (instid != null ? !instid.equals(dieEntity.instid) : dieEntity.instid != null) return false;
        if (netcan != null ? !netcan.equals(dieEntity.netcan) : dieEntity.netcan != null) return false;
        if (netdis != null ? !netdis.equals(dieEntity.netdis) : dieEntity.netdis != null) return false;
        if (neteft != null ? !neteft.equals(dieEntity.neteft) : dieEntity.neteft != null) return false;
        if (netnef != null ? !netnef.equals(dieEntity.netnef) : dieEntity.netnef != null) return false;
        if (outcan != null ? !outcan.equals(dieEntity.outcan) : dieEntity.outcan != null) return false;
        if (prcdte != null ? !prcdte.equals(dieEntity.prcdte) : dieEntity.prcdte != null) return false;
        if (procyr != null ? !procyr.equals(dieEntity.procyr) : dieEntity.procyr != null) return false;
        if (ramtac != null ? !ramtac.equals(dieEntity.ramtac) : dieEntity.ramtac != null) return false;
        if (ramtcr != null ? !ramtcr.equals(dieEntity.ramtcr) : dieEntity.ramtcr != null) return false;
        if (ramtrp != null ? !ramtrp.equals(dieEntity.ramtrp) : dieEntity.ramtrp != null) return false;
        if (rawdam != null ? !rawdam.equals(dieEntity.rawdam) : dieEntity.rawdam != null) return false;
        if (recpt != null ? !recpt.equals(dieEntity.recpt) : dieEntity.recpt != null) return false;
        if (reisue != null ? !reisue.equals(dieEntity.reisue) : dieEntity.reisue != null) return false;
        if (revdtec != null ? !revdtec.equals(dieEntity.revdtec) : dieEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(dieEntity.revmod) : dieEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(dieEntity.revtime) : dieEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(dieEntity.revuser) : dieEntity.revuser != null) return false;
        if (rschid != null ? !rschid.equals(dieEntity.rschid) : dieEntity.rschid != null) return false;
        if (samtrp != null ? !samtrp.equals(dieEntity.samtrp) : dieEntity.samtrp != null) return false;
        if (sawdam != null ? !sawdam.equals(dieEntity.sawdam) : dieEntity.sawdam != null) return false;
        if (totcan != null ? !totcan.equals(dieEntity.totcan) : dieEntity.totcan != null) return false;
        if (ucode != null ? !ucode.equals(dieEntity.ucode) : dieEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diekey != null ? diekey.hashCode() : 0;
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (docid != null ? docid.hashCode() : 0);
        result = 31 * result + (rschid != null ? rschid.hashCode() : 0);
        result = 31 * result + (awdtyp != null ? awdtyp.hashCode() : 0);
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
        result = 31 * result + (dentid != null ? dentid.hashCode() : 0);
        result = 31 * result + (frsflg != null ? frsflg.hashCode() : 0);
        result = 31 * result + (recpt != null ? recpt.hashCode() : 0);
        result = 31 * result + (doctyp != null ? doctyp.hashCode() : 0);
        result = 31 * result + (docst != null ? docst.hashCode() : 0);
        result = 31 * result + (prcdte != null ? prcdte.hashCode() : 0);
        result = 31 * result + snstds;
        result = 31 * result + (sawdam != null ? sawdam.hashCode() : 0);
        result = 31 * result + (samtrp != null ? samtrp.hashCode() : 0);
        result = 31 * result + rnstds;
        result = 31 * result + raccpt;
        result = 31 * result + rrejct;
        result = 31 * result + rcorr;
        result = 31 * result + rdupl;
        result = 31 * result + rheld;
        result = 31 * result + rpartl;
        result = 31 * result + rverif;
        result = 31 * result + rssa;
        result = 31 * result + (rawdam != null ? rawdam.hashCode() : 0);
        result = 31 * result + (ramtrp != null ? ramtrp.hashCode() : 0);
        result = 31 * result + (ramtac != null ? ramtac.hashCode() : 0);
        result = 31 * result + (ramtcr != null ? ramtcr.hashCode() : 0);
        result = 31 * result + (netdis != null ? netdis.hashCode() : 0);
        result = 31 * result + (neteft != null ? neteft.hashCode() : 0);
        result = 31 * result + (netnef != null ? netnef.hashCode() : 0);
        result = 31 * result + (reisue != null ? reisue.hashCode() : 0);
        result = 31 * result + (totcan != null ? totcan.hashCode() : 0);
        result = 31 * result + (outcan != null ? outcan.hashCode() : 0);
        result = 31 * result + (netcan != null ? netcan.hashCode() : 0);
        result = 31 * result + (defict != null ? defict.hashCode() : 0);
        return result;
    }
}
