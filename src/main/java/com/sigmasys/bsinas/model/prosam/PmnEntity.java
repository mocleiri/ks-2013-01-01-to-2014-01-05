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
 * Date: 11/26/12
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "PMN", schema = "SIGMA", catalog = "")
@Entity
public class PmnEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getPmnkey();
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

    private String pmnkey;

    @javax.persistence.Column(name = "PMNKEY")
    @Id
    public String getPmnkey() {
        return pmnkey;
    }

    public void setPmnkey(String pmnkey) {
        this.pmnkey = pmnkey;
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

    private String psntyp;

    @javax.persistence.Column(name = "PSNTYP")
    @Basic
    public String getPsntyp() {
        return psntyp;
    }

    public void setPsntyp(String psntyp) {
        this.psntyp = psntyp;
    }

    private String pmltyp;

    @javax.persistence.Column(name = "PMLTYP")
    @Basic
    public String getPmltyp() {
        return pmltyp;
    }

    public void setPmltyp(String pmltyp) {
        this.pmltyp = pmltyp;
    }

    private int seqno;

    @javax.persistence.Column(name = "SEQNO")
    @Basic
    public int getSeqno() {
        return seqno;
    }

    public void setSeqno(int seqno) {
        this.seqno = seqno;
    }

    private String pmnid;

    @javax.persistence.Column(name = "PMNID")
    @Basic
    public String getPmnid() {
        return pmnid;
    }

    public void setPmnid(String pmnid) {
        this.pmnid = pmnid;
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

    private String pnsdte;

    @javax.persistence.Column(name = "PNSDTE")
    @Basic
    public String getPnsdte() {
        return pnsdte;
    }

    public void setPnsdte(String pnsdte) {
        this.pnsdte = pnsdte;
    }

    private String sigind;

    @javax.persistence.Column(name = "SIGIND")
    @Basic
    public String getSigind() {
        return sigind;
    }

    public void setSigind(String sigind) {
        this.sigind = sigind;
    }

    private String pnfddt;

    @javax.persistence.Column(name = "PNFDDT")
    @Basic
    public String getPnfddt() {
        return pnfddt;
    }

    public void setPnfddt(String pnfddt) {
        this.pnfddt = pnfddt;
    }

    private String pnlddt;

    @javax.persistence.Column(name = "PNLDDT")
    @Basic
    public String getPnlddt() {
        return pnlddt;
    }

    public void setPnlddt(String pnlddt) {
        this.pnlddt = pnlddt;
    }

    private String pnpdte;

    @javax.persistence.Column(name = "PNPDTE")
    @Basic
    public String getPnpdte() {
        return pnpdte;
    }

    public void setPnpdte(String pnpdte) {
        this.pnpdte = pnpdte;
    }

    private String trndte;

    @javax.persistence.Column(name = "TRNDTE")
    @Basic
    public String getTrndte() {
        return trndte;
    }

    public void setTrndte(String trndte) {
        this.trndte = trndte;
    }

    private String pnown;

    @javax.persistence.Column(name = "PNOWN")
    @Basic
    public String getPnown() {
        return pnown;
    }

    public void setPnown(String pnown) {
        this.pnown = pnown;
    }

    private String locatn;

    @javax.persistence.Column(name = "LOCATN")
    @Basic
    public String getLocatn() {
        return locatn;
    }

    public void setLocatn(String locatn) {
        this.locatn = locatn;
    }

    private BigDecimal pmnamt;

    @javax.persistence.Column(name = "PMNAMT")
    @Basic
    public BigDecimal getPmnamt() {
        return pmnamt;
    }

    public void setPmnamt(BigDecimal pmnamt) {
        this.pmnamt = pmnamt;
    }

    private String pmntyp;

    @javax.persistence.Column(name = "PMNTYP")
    @Basic
    public String getPmntyp() {
        return pmntyp;
    }

    public void setPmntyp(String pmntyp) {
        this.pmntyp = pmntyp;
    }

    private String pnstat;

    @javax.persistence.Column(name = "PNSTAT")
    @Basic
    public String getPnstat() {
        return pnstat;
    }

    public void setPnstat(String pnstat) {
        this.pnstat = pnstat;
    }

    private String expdte;

    @javax.persistence.Column(name = "EXPDTE")
    @Basic
    public String getExpdte() {
        return expdte;
    }

    public void setExpdte(String expdte) {
        this.expdte = expdte;
    }

    private String guarid;

    @javax.persistence.Column(name = "GUARID")
    @Basic
    public String getGuarid() {
        return guarid;
    }

    public void setGuarid(String guarid) {
        this.guarid = guarid;
    }

    private String lendid;

    @javax.persistence.Column(name = "LENDID")
    @Basic
    public String getLendid() {
        return lendid;
    }

    public void setLendid(String lendid) {
        this.lendid = lendid;
    }

    private String sigcus;

    @javax.persistence.Column(name = "SIGCUS")
    @Basic
    public String getSigcus() {
        return sigcus;
    }

    public void setSigcus(String sigcus) {
        this.sigcus = sigcus;
    }

    private String eaidyr;

    @javax.persistence.Column(name = "EAIDYR")
    @Basic
    public String getEaidyr() {
        return eaidyr;
    }

    public void setEaidyr(String eaidyr) {
        this.eaidyr = eaidyr;
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

    private int usrnr1;

    @javax.persistence.Column(name = "USRNR1")
    @Basic
    public int getUsrnr1() {
        return usrnr1;
    }

    public void setUsrnr1(int usrnr1) {
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

    private String mpnid;

    @javax.persistence.Column(name = "MPNID")
    @Basic
    public String getMpnid() {
        return mpnid;
    }

    public void setMpnid(String mpnid) {
        this.mpnid = mpnid;
    }

    private String delcd;

    @javax.persistence.Column(name = "DELCD")
    @Basic
    public String getDelcd() {
        return delcd;
    }

    public void setDelcd(String delcd) {
        this.delcd = delcd;
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

    private String custid;

    @javax.persistence.Column(name = "CUSTID")
    @Basic
    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    private BigInteger pnseqn;

    @javax.persistence.Column(name = "PNSEQN")
    @Basic
    public BigInteger getPnseqn() {
        return pnseqn;
    }

    public void setPnseqn(BigInteger pnseqn) {
        this.pnseqn = pnseqn;
    }

    private String pnprtcd;

    @javax.persistence.Column(name = "PNPRTCD")
    @Basic
    public String getPnprtcd() {
        return pnprtcd;
    }

    public void setPnprtcd(String pnprtcd) {
        this.pnprtcd = pnprtcd;
    }

    private String entrdt;

    @javax.persistence.Column(name = "ENTRDT")
    @Basic
    public String getEntrdt() {
        return entrdt;
    }

    public void setEntrdt(String entrdt) {
        this.entrdt = entrdt;
    }

    private String exitdt;

    @javax.persistence.Column(name = "EXITDT")
    @Basic
    public String getExitdt() {
        return exitdt;
    }

    public void setExitdt(String exitdt) {
        this.exitdt = exitdt;
    }

    private String folldt;

    @javax.persistence.Column(name = "FOLLDT")
    @Basic
    public String getFolldt() {
        return folldt;
    }

    public void setFolldt(String folldt) {
        this.folldt = folldt;
    }

    private String crtdby;

    @javax.persistence.Column(name = "CRTDBY")
    @Basic
    public String getCrtdby() {
        return crtdby;
    }

    public void setCrtdby(String crtdby) {
        this.crtdby = crtdby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PmnEntity pmnEntity = (PmnEntity) o;

        if (revlev != pmnEntity.revlev) return false;
        if (seqno != pmnEntity.seqno) return false;
        if (usrnr1 != pmnEntity.usrnr1) return false;
        if (crtdby != null ? !crtdby.equals(pmnEntity.crtdby) : pmnEntity.crtdby != null) return false;
        if (crtdte != null ? !crtdte.equals(pmnEntity.crtdte) : pmnEntity.crtdte != null) return false;
        if (crtmod != null ? !crtmod.equals(pmnEntity.crtmod) : pmnEntity.crtmod != null) return false;
        if (crttme != null ? !crttme.equals(pmnEntity.crttme) : pmnEntity.crttme != null) return false;
        if (crtusr != null ? !crtusr.equals(pmnEntity.crtusr) : pmnEntity.crtusr != null) return false;
        if (custid != null ? !custid.equals(pmnEntity.custid) : pmnEntity.custid != null) return false;
        if (delcd != null ? !delcd.equals(pmnEntity.delcd) : pmnEntity.delcd != null) return false;
        if (eaidyr != null ? !eaidyr.equals(pmnEntity.eaidyr) : pmnEntity.eaidyr != null) return false;
        if (entrdt != null ? !entrdt.equals(pmnEntity.entrdt) : pmnEntity.entrdt != null) return false;
        if (exitdt != null ? !exitdt.equals(pmnEntity.exitdt) : pmnEntity.exitdt != null) return false;
        if (expdte != null ? !expdte.equals(pmnEntity.expdte) : pmnEntity.expdte != null) return false;
        if (folldt != null ? !folldt.equals(pmnEntity.folldt) : pmnEntity.folldt != null) return false;
        if (guarid != null ? !guarid.equals(pmnEntity.guarid) : pmnEntity.guarid != null) return false;
        if (lendid != null ? !lendid.equals(pmnEntity.lendid) : pmnEntity.lendid != null) return false;
        if (locatn != null ? !locatn.equals(pmnEntity.locatn) : pmnEntity.locatn != null) return false;
        if (mpnid != null ? !mpnid.equals(pmnEntity.mpnid) : pmnEntity.mpnid != null) return false;
        if (pmltyp != null ? !pmltyp.equals(pmnEntity.pmltyp) : pmnEntity.pmltyp != null) return false;
        if (pmnamt != null ? !pmnamt.equals(pmnEntity.pmnamt) : pmnEntity.pmnamt != null) return false;
        if (pmnid != null ? !pmnid.equals(pmnEntity.pmnid) : pmnEntity.pmnid != null) return false;
        if (pmnkey != null ? !pmnkey.equals(pmnEntity.pmnkey) : pmnEntity.pmnkey != null) return false;
        if (pmntyp != null ? !pmntyp.equals(pmnEntity.pmntyp) : pmnEntity.pmntyp != null) return false;
        if (pnfddt != null ? !pnfddt.equals(pmnEntity.pnfddt) : pmnEntity.pnfddt != null) return false;
        if (pnlddt != null ? !pnlddt.equals(pmnEntity.pnlddt) : pmnEntity.pnlddt != null) return false;
        if (pnown != null ? !pnown.equals(pmnEntity.pnown) : pmnEntity.pnown != null) return false;
        if (pnpdte != null ? !pnpdte.equals(pmnEntity.pnpdte) : pmnEntity.pnpdte != null) return false;
        if (pnprtcd != null ? !pnprtcd.equals(pmnEntity.pnprtcd) : pmnEntity.pnprtcd != null) return false;
        if (pnsdte != null ? !pnsdte.equals(pmnEntity.pnsdte) : pmnEntity.pnsdte != null) return false;
        if (pnseqn != null ? !pnseqn.equals(pmnEntity.pnseqn) : pmnEntity.pnseqn != null) return false;
        if (pnstat != null ? !pnstat.equals(pmnEntity.pnstat) : pmnEntity.pnstat != null) return false;
        if (psntyp != null ? !psntyp.equals(pmnEntity.psntyp) : pmnEntity.psntyp != null) return false;
        if (recstat != null ? !recstat.equals(pmnEntity.recstat) : pmnEntity.recstat != null) return false;
        if (revdte != null ? !revdte.equals(pmnEntity.revdte) : pmnEntity.revdte != null) return false;
        if (revmod != null ? !revmod.equals(pmnEntity.revmod) : pmnEntity.revmod != null) return false;
        if (revtme != null ? !revtme.equals(pmnEntity.revtme) : pmnEntity.revtme != null) return false;
        if (revusr != null ? !revusr.equals(pmnEntity.revusr) : pmnEntity.revusr != null) return false;
        if (sid != null ? !sid.equals(pmnEntity.sid) : pmnEntity.sid != null) return false;
        if (sigcus != null ? !sigcus.equals(pmnEntity.sigcus) : pmnEntity.sigcus != null) return false;
        if (sigind != null ? !sigind.equals(pmnEntity.sigind) : pmnEntity.sigind != null) return false;
        if (status != null ? !status.equals(pmnEntity.status) : pmnEntity.status != null) return false;
        if (trndte != null ? !trndte.equals(pmnEntity.trndte) : pmnEntity.trndte != null) return false;
        if (ucode != null ? !ucode.equals(pmnEntity.ucode) : pmnEntity.ucode != null) return false;
        if (usrcd1 != null ? !usrcd1.equals(pmnEntity.usrcd1) : pmnEntity.usrcd1 != null) return false;
        if (usrcd2 != null ? !usrcd2.equals(pmnEntity.usrcd2) : pmnEntity.usrcd2 != null) return false;
        if (usrcd3 != null ? !usrcd3.equals(pmnEntity.usrcd3) : pmnEntity.usrcd3 != null) return false;
        if (usrcd4 != null ? !usrcd4.equals(pmnEntity.usrcd4) : pmnEntity.usrcd4 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(pmnEntity.usrdt1) : pmnEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(pmnEntity.usrdt2) : pmnEntity.usrdt2 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(pmnEntity.usrnr2) : pmnEntity.usrnr2 != null) return false;
        if (usrnr3 != null ? !usrnr3.equals(pmnEntity.usrnr3) : pmnEntity.usrnr3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (pmnkey != null ? pmnkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (psntyp != null ? psntyp.hashCode() : 0);
        result = 31 * result + (pmltyp != null ? pmltyp.hashCode() : 0);
        result = 31 * result + seqno;
        result = 31 * result + (pmnid != null ? pmnid.hashCode() : 0);
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
        result = 31 * result + (pnsdte != null ? pnsdte.hashCode() : 0);
        result = 31 * result + (sigind != null ? sigind.hashCode() : 0);
        result = 31 * result + (pnfddt != null ? pnfddt.hashCode() : 0);
        result = 31 * result + (pnlddt != null ? pnlddt.hashCode() : 0);
        result = 31 * result + (pnpdte != null ? pnpdte.hashCode() : 0);
        result = 31 * result + (trndte != null ? trndte.hashCode() : 0);
        result = 31 * result + (pnown != null ? pnown.hashCode() : 0);
        result = 31 * result + (locatn != null ? locatn.hashCode() : 0);
        result = 31 * result + (pmnamt != null ? pmnamt.hashCode() : 0);
        result = 31 * result + (pmntyp != null ? pmntyp.hashCode() : 0);
        result = 31 * result + (pnstat != null ? pnstat.hashCode() : 0);
        result = 31 * result + (expdte != null ? expdte.hashCode() : 0);
        result = 31 * result + (guarid != null ? guarid.hashCode() : 0);
        result = 31 * result + (lendid != null ? lendid.hashCode() : 0);
        result = 31 * result + (sigcus != null ? sigcus.hashCode() : 0);
        result = 31 * result + (eaidyr != null ? eaidyr.hashCode() : 0);
        result = 31 * result + (usrcd1 != null ? usrcd1.hashCode() : 0);
        result = 31 * result + (usrcd2 != null ? usrcd2.hashCode() : 0);
        result = 31 * result + (usrcd3 != null ? usrcd3.hashCode() : 0);
        result = 31 * result + (usrcd4 != null ? usrcd4.hashCode() : 0);
        result = 31 * result + usrnr1;
        result = 31 * result + (usrnr2 != null ? usrnr2.hashCode() : 0);
        result = 31 * result + (usrnr3 != null ? usrnr3.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (usrdt2 != null ? usrdt2.hashCode() : 0);
        result = 31 * result + (mpnid != null ? mpnid.hashCode() : 0);
        result = 31 * result + (delcd != null ? delcd.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (custid != null ? custid.hashCode() : 0);
        result = 31 * result + (pnseqn != null ? pnseqn.hashCode() : 0);
        result = 31 * result + (pnprtcd != null ? pnprtcd.hashCode() : 0);
        result = 31 * result + (entrdt != null ? entrdt.hashCode() : 0);
        result = 31 * result + (exitdt != null ? exitdt.hashCode() : 0);
        result = 31 * result + (folldt != null ? folldt.hashCode() : 0);
        result = 31 * result + (crtdby != null ? crtdby.hashCode() : 0);
        return result;
    }
}
