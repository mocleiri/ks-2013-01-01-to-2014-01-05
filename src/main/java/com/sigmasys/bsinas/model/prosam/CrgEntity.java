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
@javax.persistence.Table(name = "CRG", schema = "SIGMA", catalog = "")
@Entity
public class CrgEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getCrgkey();
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

    private String crgkey;

    @javax.persistence.Column(name = "CRGKEY")
    @Id
    public String getCrgkey() {
        return crgkey;
    }

    public void setCrgkey(String crgkey) {
        this.crgkey = crgkey;
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

    private String term;

    @javax.persistence.Column(name = "TERM")
    @Basic
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    private String crgtyp;

    @javax.persistence.Column(name = "CRGTYP")
    @Basic
    public String getCrgtyp() {
        return crgtyp;
    }

    public void setCrgtyp(String crgtyp) {
        this.crgtyp = crgtyp;
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

    private String sdesc;

    @javax.persistence.Column(name = "SDESC")
    @Basic
    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    private BigDecimal amount;

    @javax.persistence.Column(name = "AMOUNT")
    @Basic
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private BigDecimal amto;

    @javax.persistence.Column(name = "AMTO")
    @Basic
    public BigDecimal getAmto() {
        return amto;
    }

    public void setAmto(BigDecimal amto) {
        this.amto = amto;
    }

    private String asmdte;

    @javax.persistence.Column(name = "ASMDTE")
    @Basic
    public String getAsmdte() {
        return asmdte;
    }

    public void setAsmdte(String asmdte) {
        this.asmdte = asmdte;
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

    private String r2T4;

    @javax.persistence.Column(name = "R2T4")
    @Basic
    public String getR2T4() {
        return r2T4;
    }

    public void setR2T4(String r2T4) {
        this.r2T4 = r2T4;
    }

    private String source;

    @javax.persistence.Column(name = "SOURCE")
    @Basic
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrgEntity crgEntity = (CrgEntity) o;

        if (revlev != crgEntity.revlev) return false;
        if (aidyr != null ? !aidyr.equals(crgEntity.aidyr) : crgEntity.aidyr != null) return false;
        if (amount != null ? !amount.equals(crgEntity.amount) : crgEntity.amount != null) return false;
        if (amto != null ? !amto.equals(crgEntity.amto) : crgEntity.amto != null) return false;
        if (asmdte != null ? !asmdte.equals(crgEntity.asmdte) : crgEntity.asmdte != null) return false;
        if (crgkey != null ? !crgkey.equals(crgEntity.crgkey) : crgEntity.crgkey != null) return false;
        if (crgtyp != null ? !crgtyp.equals(crgEntity.crgtyp) : crgEntity.crgtyp != null) return false;
        if (crtdte != null ? !crtdte.equals(crgEntity.crtdte) : crgEntity.crtdte != null) return false;
        if (crtmod != null ? !crtmod.equals(crgEntity.crtmod) : crgEntity.crtmod != null) return false;
        if (crttme != null ? !crttme.equals(crgEntity.crttme) : crgEntity.crttme != null) return false;
        if (crtusr != null ? !crtusr.equals(crgEntity.crtusr) : crgEntity.crtusr != null) return false;
        if (effdte != null ? !effdte.equals(crgEntity.effdte) : crgEntity.effdte != null) return false;
        if (r2T4 != null ? !r2T4.equals(crgEntity.r2T4) : crgEntity.r2T4 != null) return false;
        if (recstat != null ? !recstat.equals(crgEntity.recstat) : crgEntity.recstat != null) return false;
        if (revdte != null ? !revdte.equals(crgEntity.revdte) : crgEntity.revdte != null) return false;
        if (revmod != null ? !revmod.equals(crgEntity.revmod) : crgEntity.revmod != null) return false;
        if (revtme != null ? !revtme.equals(crgEntity.revtme) : crgEntity.revtme != null) return false;
        if (revusr != null ? !revusr.equals(crgEntity.revusr) : crgEntity.revusr != null) return false;
        if (sdesc != null ? !sdesc.equals(crgEntity.sdesc) : crgEntity.sdesc != null) return false;
        if (sid != null ? !sid.equals(crgEntity.sid) : crgEntity.sid != null) return false;
        if (source != null ? !source.equals(crgEntity.source) : crgEntity.source != null) return false;
        if (term != null ? !term.equals(crgEntity.term) : crgEntity.term != null) return false;
        if (ucode != null ? !ucode.equals(crgEntity.ucode) : crgEntity.ucode != null) return false;
        if (usrcd1 != null ? !usrcd1.equals(crgEntity.usrcd1) : crgEntity.usrcd1 != null) return false;
        if (usrcd2 != null ? !usrcd2.equals(crgEntity.usrcd2) : crgEntity.usrcd2 != null) return false;
        if (usrcd3 != null ? !usrcd3.equals(crgEntity.usrcd3) : crgEntity.usrcd3 != null) return false;
        if (usrcd4 != null ? !usrcd4.equals(crgEntity.usrcd4) : crgEntity.usrcd4 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(crgEntity.usrdt1) : crgEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(crgEntity.usrdt2) : crgEntity.usrdt2 != null) return false;
        if (usrdt3 != null ? !usrdt3.equals(crgEntity.usrdt3) : crgEntity.usrdt3 != null) return false;
        if (usrdt4 != null ? !usrdt4.equals(crgEntity.usrdt4) : crgEntity.usrdt4 != null) return false;
        if (usrnr1 != null ? !usrnr1.equals(crgEntity.usrnr1) : crgEntity.usrnr1 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(crgEntity.usrnr2) : crgEntity.usrnr2 != null) return false;
        if (usrnr3 != null ? !usrnr3.equals(crgEntity.usrnr3) : crgEntity.usrnr3 != null) return false;
        if (usrnr4 != null ? !usrnr4.equals(crgEntity.usrnr4) : crgEntity.usrnr4 != null) return false;
        if (usrnr5 != null ? !usrnr5.equals(crgEntity.usrnr5) : crgEntity.usrnr5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (crgkey != null ? crgkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (crgtyp != null ? crgtyp.hashCode() : 0);
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
        result = 31 * result + (sdesc != null ? sdesc.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (amto != null ? amto.hashCode() : 0);
        result = 31 * result + (asmdte != null ? asmdte.hashCode() : 0);
        result = 31 * result + (effdte != null ? effdte.hashCode() : 0);
        result = 31 * result + (r2T4 != null ? r2T4.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
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
        return result;
    }
}
