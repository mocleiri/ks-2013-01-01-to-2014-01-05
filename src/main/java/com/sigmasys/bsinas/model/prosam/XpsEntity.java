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
 * Time: 12:43 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "XPS", schema = "SIGMA", catalog = "")
@Entity
public class XpsEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getXpskey();
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

    private String xpskey;

    @javax.persistence.Column(name = "XPSKEY")
    @Id
    public String getXpskey() {
        return xpskey;
    }

    public void setXpskey(String xpskey) {
        this.xpskey = xpskey;
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

    private String title;

    @javax.persistence.Column(name = "TITLE")
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String fname;

    @javax.persistence.Column(name = "FNAME")
    @Basic
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    private String mname;

    @javax.persistence.Column(name = "MNAME")
    @Basic
    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    private String lname;

    @javax.persistence.Column(name = "LNAME")
    @Basic
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    private String maiden;

    @javax.persistence.Column(name = "MAIDEN")
    @Basic
    public String getMaiden() {
        return maiden;
    }

    public void setMaiden(String maiden) {
        this.maiden = maiden;
    }

    private String secid;

    @javax.persistence.Column(name = "SECID")
    @Basic
    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    private String bdate;

    @javax.persistence.Column(name = "BDATE")
    @Basic
    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    private String ddate;

    @javax.persistence.Column(name = "DDATE")
    @Basic
    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    private String gender;

    @javax.persistence.Column(name = "GENDER")
    @Basic
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String ethnic;

    @javax.persistence.Column(name = "ETHNIC")
    @Basic
    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    private String maritl;

    @javax.persistence.Column(name = "MARITL")
    @Basic
    public String getMaritl() {
        return maritl;
    }

    public void setMaritl(String maritl) {
        this.maritl = maritl;
    }

    private String privcy;

    @javax.persistence.Column(name = "PRIVCY")
    @Basic
    public String getPrivcy() {
        return privcy;
    }

    public void setPrivcy(String privcy) {
        this.privcy = privcy;
    }

    private String langpr;

    @javax.persistence.Column(name = "LANGPR")
    @Basic
    public String getLangpr() {
        return langpr;
    }

    public void setLangpr(String langpr) {
        this.langpr = langpr;
    }

    private String citizn;

    @javax.persistence.Column(name = "CITIZN")
    @Basic
    public String getCitizn() {
        return citizn;
    }

    public void setCitizn(String citizn) {
        this.citizn = citizn;
    }

    private String visa;

    @javax.persistence.Column(name = "VISA")
    @Basic
    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    private String vetern;

    @javax.persistence.Column(name = "VETERN")
    @Basic
    public String getVetern() {
        return vetern;
    }

    public void setVetern(String vetern) {
        this.vetern = vetern;
    }

    private String vetid;

    @javax.persistence.Column(name = "VETID")
    @Basic
    public String getVetid() {
        return vetid;
    }

    public void setVetid(String vetid) {
        this.vetid = vetid;
    }

    private String rescty;

    @javax.persistence.Column(name = "RESCTY")
    @Basic
    public String getRescty() {
        return rescty;
    }

    public void setRescty(String rescty) {
        this.rescty = rescty;
    }

    private String resst;

    @javax.persistence.Column(name = "RESST")
    @Basic
    public String getResst() {
        return resst;
    }

    public void setResst(String resst) {
        this.resst = resst;
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

        XpsEntity xpsEntity = (XpsEntity) o;

        if (revlev != xpsEntity.revlev) return false;
        if (tblatt != xpsEntity.tblatt) return false;
        if (transq != xpsEntity.transq) return false;
        if (triatt != xpsEntity.triatt) return false;
        if (acton != null ? !acton.equals(xpsEntity.acton) : xpsEntity.acton != null) return false;
        if (arules != null ? !arules.equals(xpsEntity.arules) : xpsEntity.arules != null) return false;
        if (bdate != null ? !bdate.equals(xpsEntity.bdate) : xpsEntity.bdate != null) return false;
        if (citizn != null ? !citizn.equals(xpsEntity.citizn) : xpsEntity.citizn != null) return false;
        if (crtdtec != null ? !crtdtec.equals(xpsEntity.crtdtec) : xpsEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(xpsEntity.crtmod) : xpsEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(xpsEntity.crttime) : xpsEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(xpsEntity.crtuser) : xpsEntity.crtuser != null) return false;
        if (ddate != null ? !ddate.equals(xpsEntity.ddate) : xpsEntity.ddate != null) return false;
        if (delim != null ? !delim.equals(xpsEntity.delim) : xpsEntity.delim != null) return false;
        if (ethnic != null ? !ethnic.equals(xpsEntity.ethnic) : xpsEntity.ethnic != null) return false;
        if (fname != null ? !fname.equals(xpsEntity.fname) : xpsEntity.fname != null) return false;
        if (gender != null ? !gender.equals(xpsEntity.gender) : xpsEntity.gender != null) return false;
        if (langpr != null ? !langpr.equals(xpsEntity.langpr) : xpsEntity.langpr != null) return false;
        if (lname != null ? !lname.equals(xpsEntity.lname) : xpsEntity.lname != null) return false;
        if (maiden != null ? !maiden.equals(xpsEntity.maiden) : xpsEntity.maiden != null) return false;
        if (maritl != null ? !maritl.equals(xpsEntity.maritl) : xpsEntity.maritl != null) return false;
        if (mname != null ? !mname.equals(xpsEntity.mname) : xpsEntity.mname != null) return false;
        if (primid != null ? !primid.equals(xpsEntity.primid) : xpsEntity.primid != null) return false;
        if (privcy != null ? !privcy.equals(xpsEntity.privcy) : xpsEntity.privcy != null) return false;
        if (recstat != null ? !recstat.equals(xpsEntity.recstat) : xpsEntity.recstat != null) return false;
        if (rescty != null ? !rescty.equals(xpsEntity.rescty) : xpsEntity.rescty != null) return false;
        if (resst != null ? !resst.equals(xpsEntity.resst) : xpsEntity.resst != null) return false;
        if (revdtec != null ? !revdtec.equals(xpsEntity.revdtec) : xpsEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(xpsEntity.revmod) : xpsEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(xpsEntity.revtime) : xpsEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(xpsEntity.revuser) : xpsEntity.revuser != null) return false;
        if (secid != null ? !secid.equals(xpsEntity.secid) : xpsEntity.secid != null) return false;
        if (subseq != null ? !subseq.equals(xpsEntity.subseq) : xpsEntity.subseq != null) return false;
        if (tbldte != null ? !tbldte.equals(xpsEntity.tbldte) : xpsEntity.tbldte != null) return false;
        if (tblerr != null ? !tblerr.equals(xpsEntity.tblerr) : xpsEntity.tblerr != null) return false;
        if (tbltm != null ? !tbltm.equals(xpsEntity.tbltm) : xpsEntity.tbltm != null) return false;
        if (title != null ? !title.equals(xpsEntity.title) : xpsEntity.title != null) return false;
        if (trandt != null ? !trandt.equals(xpsEntity.trandt) : xpsEntity.trandt != null) return false;
        if (trantm != null ? !trantm.equals(xpsEntity.trantm) : xpsEntity.trantm != null) return false;
        if (tridte != null ? !tridte.equals(xpsEntity.tridte) : xpsEntity.tridte != null) return false;
        if (trierr != null ? !trierr.equals(xpsEntity.trierr) : xpsEntity.trierr != null) return false;
        if (triggr != null ? !triggr.equals(xpsEntity.triggr) : xpsEntity.triggr != null) return false;
        if (tritm != null ? !tritm.equals(xpsEntity.tritm) : xpsEntity.tritm != null) return false;
        if (ucode != null ? !ucode.equals(xpsEntity.ucode) : xpsEntity.ucode != null) return false;
        if (updte != null ? !updte.equals(xpsEntity.updte) : xpsEntity.updte != null) return false;
        if (vetern != null ? !vetern.equals(xpsEntity.vetern) : xpsEntity.vetern != null) return false;
        if (vetid != null ? !vetid.equals(xpsEntity.vetid) : xpsEntity.vetid != null) return false;
        if (visa != null ? !visa.equals(xpsEntity.visa) : xpsEntity.visa != null) return false;
        if (xpskey != null ? !xpskey.equals(xpsEntity.xpskey) : xpsEntity.xpskey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (xpskey != null ? xpskey.hashCode() : 0);
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
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (mname != null ? mname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (maiden != null ? maiden.hashCode() : 0);
        result = 31 * result + (secid != null ? secid.hashCode() : 0);
        result = 31 * result + (bdate != null ? bdate.hashCode() : 0);
        result = 31 * result + (ddate != null ? ddate.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (ethnic != null ? ethnic.hashCode() : 0);
        result = 31 * result + (maritl != null ? maritl.hashCode() : 0);
        result = 31 * result + (privcy != null ? privcy.hashCode() : 0);
        result = 31 * result + (langpr != null ? langpr.hashCode() : 0);
        result = 31 * result + (citizn != null ? citizn.hashCode() : 0);
        result = 31 * result + (visa != null ? visa.hashCode() : 0);
        result = 31 * result + (vetern != null ? vetern.hashCode() : 0);
        result = 31 * result + (vetid != null ? vetid.hashCode() : 0);
        result = 31 * result + (rescty != null ? rescty.hashCode() : 0);
        result = 31 * result + (resst != null ? resst.hashCode() : 0);
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
