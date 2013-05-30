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
@javax.persistence.Table(name = "RAW_", schema = "SIGMA", catalog = "")
@Entity
public class RawEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getRawkey();
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

    private String rawkey;

    @javax.persistence.Column(name = "RAWKEY")
    @Id
    public String getRawkey() {
        return rawkey;
    }

    public void setRawkey(String rawkey) {
        this.rawkey = rawkey;
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

    private String aidid;

    @javax.persistence.Column(name = "AIDID")
    @Basic
    public String getAidid() {
        return aidid;
    }

    public void setAidid(String aidid) {
        this.aidid = aidid;
    }

    private String ptype;

    @javax.persistence.Column(name = "PTYPE")
    @Basic
    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
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

    private String crtdte;

    @javax.persistence.Column(name = "CRTDTE")
    @Basic
    public String getCrtdte() {
        return crtdte;
    }

    public void setCrtdte(String crtdte) {
        this.crtdte = crtdte;
    }

    private String crttme;

    @javax.persistence.Column(name = "CRTTME")
    @Basic
    public String getCrttme() {
        return crttme;
    }

    public void setCrttme(String crttme) {
        this.crttme = crttme;
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

    private String crtusr;

    @javax.persistence.Column(name = "CRTUSR")
    @Basic
    public String getCrtusr() {
        return crtusr;
    }

    public void setCrtusr(String crtusr) {
        this.crtusr = crtusr;
    }

    private String revdte;

    @javax.persistence.Column(name = "REVDTE")
    @Basic
    public String getRevdte() {
        return revdte;
    }

    public void setRevdte(String revdte) {
        this.revdte = revdte;
    }

    private String revtme;

    @javax.persistence.Column(name = "REVTME")
    @Basic
    public String getRevtme() {
        return revtme;
    }

    public void setRevtme(String revtme) {
        this.revtme = revtme;
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

    private String revusr;

    @javax.persistence.Column(name = "REVUSR")
    @Basic
    public String getRevusr() {
        return revusr;
    }

    public void setRevusr(String revusr) {
        this.revusr = revusr;
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

    private String status;

    @javax.persistence.Column(name = "STATUS")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String hold;

    @javax.persistence.Column(name = "HOLD")
    @Basic
    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    private String holdby;

    @javax.persistence.Column(name = "HOLDBY")
    @Basic
    public String getHoldby() {
        return holdby;
    }

    public void setHoldby(String holdby) {
        this.holdby = holdby;
    }

    private String typea;

    @javax.persistence.Column(name = "TYPEA")
    @Basic
    public String getTypea() {
        return typea;
    }

    public void setTypea(String typea) {
        this.typea = typea;
    }

    private BigDecimal ooffr;

    @javax.persistence.Column(name = "OOFFR")
    @Basic
    public BigDecimal getOoffr() {
        return ooffr;
    }

    public void setOoffr(BigDecimal ooffr) {
        this.ooffr = ooffr;
    }

    private BigDecimal odisb;

    @javax.persistence.Column(name = "ODISB")
    @Basic
    public BigDecimal getOdisb() {
        return odisb;
    }

    public void setOdisb(BigDecimal odisb) {
        this.odisb = odisb;
    }

    private BigDecimal chbdc;

    @javax.persistence.Column(name = "CHBDC")
    @Basic
    public BigDecimal getChbdc() {
        return chbdc;
    }

    public void setChbdc(BigDecimal chbdc) {
        this.chbdc = chbdc;
    }

    private BigDecimal chbdo;

    @javax.persistence.Column(name = "CHBDO")
    @Basic
    public BigDecimal getChbdo() {
        return chbdo;
    }

    public void setChbdo(BigDecimal chbdo) {
        this.chbdo = chbdo;
    }

    private BigDecimal irtnc;

    @javax.persistence.Column(name = "IRTNC")
    @Basic
    public BigDecimal getIrtnc() {
        return irtnc;
    }

    public void setIrtnc(BigDecimal irtnc) {
        this.irtnc = irtnc;
    }

    private BigDecimal irtno;

    @javax.persistence.Column(name = "IRTNO")
    @Basic
    public BigDecimal getIrtno() {
        return irtno;
    }

    public void setIrtno(BigDecimal irtno) {
        this.irtno = irtno;
    }

    private BigDecimal srtnic;

    @javax.persistence.Column(name = "SRTNIC")
    @Basic
    public BigDecimal getSrtnic() {
        return srtnic;
    }

    public void setSrtnic(BigDecimal srtnic) {
        this.srtnic = srtnic;
    }

    private BigDecimal srtnio;

    @javax.persistence.Column(name = "SRTNIO")
    @Basic
    public BigDecimal getSrtnio() {
        return srtnio;
    }

    public void setSrtnio(BigDecimal srtnio) {
        this.srtnio = srtnio;
    }

    private BigDecimal srtnc;

    @javax.persistence.Column(name = "SRTNC")
    @Basic
    public BigDecimal getSrtnc() {
        return srtnc;
    }

    public void setSrtnc(BigDecimal srtnc) {
        this.srtnc = srtnc;
    }

    private BigDecimal srtno;

    @javax.persistence.Column(name = "SRTNO")
    @Basic
    public BigDecimal getSrtno() {
        return srtno;
    }

    public void setSrtno(BigDecimal srtno) {
        this.srtno = srtno;
    }

    private BigDecimal tdisb;

    @javax.persistence.Column(name = "TDISB")
    @Basic
    public BigDecimal getTdisb() {
        return tdisb;
    }

    public void setTdisb(BigDecimal tdisb) {
        this.tdisb = tdisb;
    }

    private BigDecimal cdisb;

    @javax.persistence.Column(name = "CDISB")
    @Basic
    public BigDecimal getCdisb() {
        return cdisb;
    }

    public void setCdisb(BigDecimal cdisb) {
        this.cdisb = cdisb;
    }

    private BigDecimal paamt;

    @javax.persistence.Column(name = "PAAMT")
    @Basic
    public BigDecimal getPaamt() {
        return paamt;
    }

    public void setPaamt(BigDecimal paamt) {
        this.paamt = paamt;
    }

    private BigDecimal adjamt;

    @javax.persistence.Column(name = "ADJAMT")
    @Basic
    public BigDecimal getAdjamt() {
        return adjamt;
    }

    public void setAdjamt(BigDecimal adjamt) {
        this.adjamt = adjamt;
    }

    private String adjdte;

    @javax.persistence.Column(name = "ADJDTE")
    @Basic
    public String getAdjdte() {
        return adjdte;
    }

    public void setAdjdte(String adjdte) {
        this.adjdte = adjdte;
    }

    private String enrlev;

    @javax.persistence.Column(name = "ENRLEV")
    @Basic
    public String getEnrlev() {
        return enrlev;
    }

    public void setEnrlev(String enrlev) {
        this.enrlev = enrlev;
    }

    private BigDecimal camt1;

    @javax.persistence.Column(name = "CAMT1")
    @Basic
    public BigDecimal getCamt1() {
        return camt1;
    }

    public void setCamt1(BigDecimal camt1) {
        this.camt1 = camt1;
    }

    private BigDecimal camt2;

    @javax.persistence.Column(name = "CAMT2")
    @Basic
    public BigDecimal getCamt2() {
        return camt2;
    }

    public void setCamt2(BigDecimal camt2) {
        this.camt2 = camt2;
    }

    private BigDecimal camt3;

    @javax.persistence.Column(name = "CAMT3")
    @Basic
    public BigDecimal getCamt3() {
        return camt3;
    }

    public void setCamt3(BigDecimal camt3) {
        this.camt3 = camt3;
    }

    private BigDecimal camt4;

    @javax.persistence.Column(name = "CAMT4")
    @Basic
    public BigDecimal getCamt4() {
        return camt4;
    }

    public void setCamt4(BigDecimal camt4) {
        this.camt4 = camt4;
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

    private String pwdreq;

    @javax.persistence.Column(name = "PWDREQ")
    @Basic
    public String getPwdreq() {
        return pwdreq;
    }

    public void setPwdreq(String pwdreq) {
        this.pwdreq = pwdreq;
    }

    private String onotdt;

    @javax.persistence.Column(name = "ONOTDT")
    @Basic
    public String getOnotdt() {
        return onotdt;
    }

    public void setOnotdt(String onotdt) {
        this.onotdt = onotdt;
    }

    private BigDecimal ovrpda;

    @javax.persistence.Column(name = "OVRPDA")
    @Basic
    public BigDecimal getOvrpda() {
        return ovrpda;
    }

    public void setOvrpda(BigDecimal ovrpda) {
        this.ovrpda = ovrpda;
    }

    private String ovrcpd;

    @javax.persistence.Column(name = "OVRCPD")
    @Basic
    public String getOvrcpd() {
        return ovrcpd;
    }

    public void setOvrcpd(String ovrcpd) {
        this.ovrcpd = ovrcpd;
    }

    private String psntyp;

    @javax.persistence.Column(name = "PSNTYP")
    @Basic
    public String getPsntyp() {
        return psntyp;
    }

    public void setPsntyp(String psntyp) {
        this.psntyp = psntyp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RawEntity rawEntity = (RawEntity) o;

        if (revlev != rawEntity.revlev) return false;
        if (adjamt != null ? !adjamt.equals(rawEntity.adjamt) : rawEntity.adjamt != null) return false;
        if (adjdte != null ? !adjdte.equals(rawEntity.adjdte) : rawEntity.adjdte != null) return false;
        if (aidid != null ? !aidid.equals(rawEntity.aidid) : rawEntity.aidid != null) return false;
        if (aidyr != null ? !aidyr.equals(rawEntity.aidyr) : rawEntity.aidyr != null) return false;
        if (camt1 != null ? !camt1.equals(rawEntity.camt1) : rawEntity.camt1 != null) return false;
        if (camt2 != null ? !camt2.equals(rawEntity.camt2) : rawEntity.camt2 != null) return false;
        if (camt3 != null ? !camt3.equals(rawEntity.camt3) : rawEntity.camt3 != null) return false;
        if (camt4 != null ? !camt4.equals(rawEntity.camt4) : rawEntity.camt4 != null) return false;
        if (cdisb != null ? !cdisb.equals(rawEntity.cdisb) : rawEntity.cdisb != null) return false;
        if (chbdc != null ? !chbdc.equals(rawEntity.chbdc) : rawEntity.chbdc != null) return false;
        if (chbdo != null ? !chbdo.equals(rawEntity.chbdo) : rawEntity.chbdo != null) return false;
        if (crtdte != null ? !crtdte.equals(rawEntity.crtdte) : rawEntity.crtdte != null) return false;
        if (crtmod != null ? !crtmod.equals(rawEntity.crtmod) : rawEntity.crtmod != null) return false;
        if (crttme != null ? !crttme.equals(rawEntity.crttme) : rawEntity.crttme != null) return false;
        if (crtusr != null ? !crtusr.equals(rawEntity.crtusr) : rawEntity.crtusr != null) return false;
        if (enrlev != null ? !enrlev.equals(rawEntity.enrlev) : rawEntity.enrlev != null) return false;
        if (hold != null ? !hold.equals(rawEntity.hold) : rawEntity.hold != null) return false;
        if (holdby != null ? !holdby.equals(rawEntity.holdby) : rawEntity.holdby != null) return false;
        if (irtnc != null ? !irtnc.equals(rawEntity.irtnc) : rawEntity.irtnc != null) return false;
        if (irtno != null ? !irtno.equals(rawEntity.irtno) : rawEntity.irtno != null) return false;
        if (odisb != null ? !odisb.equals(rawEntity.odisb) : rawEntity.odisb != null) return false;
        if (onotdt != null ? !onotdt.equals(rawEntity.onotdt) : rawEntity.onotdt != null) return false;
        if (ooffr != null ? !ooffr.equals(rawEntity.ooffr) : rawEntity.ooffr != null) return false;
        if (ovrcpd != null ? !ovrcpd.equals(rawEntity.ovrcpd) : rawEntity.ovrcpd != null) return false;
        if (ovrpda != null ? !ovrpda.equals(rawEntity.ovrpda) : rawEntity.ovrpda != null) return false;
        if (paamt != null ? !paamt.equals(rawEntity.paamt) : rawEntity.paamt != null) return false;
        if (psntyp != null ? !psntyp.equals(rawEntity.psntyp) : rawEntity.psntyp != null) return false;
        if (ptype != null ? !ptype.equals(rawEntity.ptype) : rawEntity.ptype != null) return false;
        if (pwdreq != null ? !pwdreq.equals(rawEntity.pwdreq) : rawEntity.pwdreq != null) return false;
        if (rawkey != null ? !rawkey.equals(rawEntity.rawkey) : rawEntity.rawkey != null) return false;
        if (recstat != null ? !recstat.equals(rawEntity.recstat) : rawEntity.recstat != null) return false;
        if (revdte != null ? !revdte.equals(rawEntity.revdte) : rawEntity.revdte != null) return false;
        if (revmod != null ? !revmod.equals(rawEntity.revmod) : rawEntity.revmod != null) return false;
        if (revtme != null ? !revtme.equals(rawEntity.revtme) : rawEntity.revtme != null) return false;
        if (revusr != null ? !revusr.equals(rawEntity.revusr) : rawEntity.revusr != null) return false;
        if (sid != null ? !sid.equals(rawEntity.sid) : rawEntity.sid != null) return false;
        if (srtnc != null ? !srtnc.equals(rawEntity.srtnc) : rawEntity.srtnc != null) return false;
        if (srtnic != null ? !srtnic.equals(rawEntity.srtnic) : rawEntity.srtnic != null) return false;
        if (srtnio != null ? !srtnio.equals(rawEntity.srtnio) : rawEntity.srtnio != null) return false;
        if (srtno != null ? !srtno.equals(rawEntity.srtno) : rawEntity.srtno != null) return false;
        if (status != null ? !status.equals(rawEntity.status) : rawEntity.status != null) return false;
        if (tdisb != null ? !tdisb.equals(rawEntity.tdisb) : rawEntity.tdisb != null) return false;
        if (term != null ? !term.equals(rawEntity.term) : rawEntity.term != null) return false;
        if (typea != null ? !typea.equals(rawEntity.typea) : rawEntity.typea != null) return false;
        if (ucode != null ? !ucode.equals(rawEntity.ucode) : rawEntity.ucode != null) return false;
        if (usrcd1 != null ? !usrcd1.equals(rawEntity.usrcd1) : rawEntity.usrcd1 != null) return false;
        if (usrcd2 != null ? !usrcd2.equals(rawEntity.usrcd2) : rawEntity.usrcd2 != null) return false;
        if (usrcd3 != null ? !usrcd3.equals(rawEntity.usrcd3) : rawEntity.usrcd3 != null) return false;
        if (usrcd4 != null ? !usrcd4.equals(rawEntity.usrcd4) : rawEntity.usrcd4 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(rawEntity.usrdt1) : rawEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(rawEntity.usrdt2) : rawEntity.usrdt2 != null) return false;
        if (usrdt3 != null ? !usrdt3.equals(rawEntity.usrdt3) : rawEntity.usrdt3 != null) return false;
        if (usrdt4 != null ? !usrdt4.equals(rawEntity.usrdt4) : rawEntity.usrdt4 != null) return false;
        if (usrnr1 != null ? !usrnr1.equals(rawEntity.usrnr1) : rawEntity.usrnr1 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(rawEntity.usrnr2) : rawEntity.usrnr2 != null) return false;
        if (usrnr3 != null ? !usrnr3.equals(rawEntity.usrnr3) : rawEntity.usrnr3 != null) return false;
        if (usrnr4 != null ? !usrnr4.equals(rawEntity.usrnr4) : rawEntity.usrnr4 != null) return false;
        if (usrnr5 != null ? !usrnr5.equals(rawEntity.usrnr5) : rawEntity.usrnr5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (rawkey != null ? rawkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (aidid != null ? aidid.hashCode() : 0);
        result = 31 * result + (ptype != null ? ptype.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (crtdte != null ? crtdte.hashCode() : 0);
        result = 31 * result + (crttme != null ? crttme.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (crtusr != null ? crtusr.hashCode() : 0);
        result = 31 * result + (revdte != null ? revdte.hashCode() : 0);
        result = 31 * result + (revtme != null ? revtme.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (revusr != null ? revusr.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (hold != null ? hold.hashCode() : 0);
        result = 31 * result + (holdby != null ? holdby.hashCode() : 0);
        result = 31 * result + (typea != null ? typea.hashCode() : 0);
        result = 31 * result + (ooffr != null ? ooffr.hashCode() : 0);
        result = 31 * result + (odisb != null ? odisb.hashCode() : 0);
        result = 31 * result + (chbdc != null ? chbdc.hashCode() : 0);
        result = 31 * result + (chbdo != null ? chbdo.hashCode() : 0);
        result = 31 * result + (irtnc != null ? irtnc.hashCode() : 0);
        result = 31 * result + (irtno != null ? irtno.hashCode() : 0);
        result = 31 * result + (srtnic != null ? srtnic.hashCode() : 0);
        result = 31 * result + (srtnio != null ? srtnio.hashCode() : 0);
        result = 31 * result + (srtnc != null ? srtnc.hashCode() : 0);
        result = 31 * result + (srtno != null ? srtno.hashCode() : 0);
        result = 31 * result + (tdisb != null ? tdisb.hashCode() : 0);
        result = 31 * result + (cdisb != null ? cdisb.hashCode() : 0);
        result = 31 * result + (paamt != null ? paamt.hashCode() : 0);
        result = 31 * result + (adjamt != null ? adjamt.hashCode() : 0);
        result = 31 * result + (adjdte != null ? adjdte.hashCode() : 0);
        result = 31 * result + (enrlev != null ? enrlev.hashCode() : 0);
        result = 31 * result + (camt1 != null ? camt1.hashCode() : 0);
        result = 31 * result + (camt2 != null ? camt2.hashCode() : 0);
        result = 31 * result + (camt3 != null ? camt3.hashCode() : 0);
        result = 31 * result + (camt4 != null ? camt4.hashCode() : 0);
        result = 31 * result + (usrcd1 != null ? usrcd1.hashCode() : 0);
        result = 31 * result + (usrcd2 != null ? usrcd2.hashCode() : 0);
        result = 31 * result + (usrcd3 != null ? usrcd3.hashCode() : 0);
        result = 31 * result + (usrcd4 != null ? usrcd4.hashCode() : 0);
        result = 31 * result + (usrnr1 != null ? usrnr1.hashCode() : 0);
        result = 31 * result + (usrnr2 != null ? usrnr2.hashCode() : 0);
        result = 31 * result + (usrnr3 != null ? usrnr3.hashCode() : 0);
        result = 31 * result + (usrnr4 != null ? usrnr4.hashCode() : 0);
        result = 31 * result + (usrnr5 != null ? usrnr5.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (usrdt2 != null ? usrdt2.hashCode() : 0);
        result = 31 * result + (usrdt3 != null ? usrdt3.hashCode() : 0);
        result = 31 * result + (usrdt4 != null ? usrdt4.hashCode() : 0);
        result = 31 * result + (pwdreq != null ? pwdreq.hashCode() : 0);
        result = 31 * result + (onotdt != null ? onotdt.hashCode() : 0);
        result = 31 * result + (ovrpda != null ? ovrpda.hashCode() : 0);
        result = 31 * result + (ovrcpd != null ? ovrcpd.hashCode() : 0);
        result = 31 * result + (psntyp != null ? psntyp.hashCode() : 0);
        return result;
    }
}
