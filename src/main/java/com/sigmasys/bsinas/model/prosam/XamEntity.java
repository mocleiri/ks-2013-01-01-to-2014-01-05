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
 * Time: 12:37 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "XAM", schema = "SIGMA", catalog = "")
@Entity
public class XamEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getXamkey();
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

    private String xamkey;

    @javax.persistence.Column(name = "XAMKEY")
    @Id
    public String getXamkey() {
        return xamkey;
    }

    public void setXamkey(String xamkey) {
        this.xamkey = xamkey;
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

    private String admstat;

    @javax.persistence.Column(name = "ADMSTAT")
    @Basic
    public String getAdmstat() {
        return admstat;
    }

    public void setAdmstat(String admstat) {
        this.admstat = admstat;
    }

    private String admtyp;

    @javax.persistence.Column(name = "ADMTYP")
    @Basic
    public String getAdmtyp() {
        return admtyp;
    }

    public void setAdmtyp(String admtyp) {
        this.admtyp = admtyp;
    }

    private String appstat;

    @javax.persistence.Column(name = "APPSTAT")
    @Basic
    public String getAppstat() {
        return appstat;
    }

    public void setAppstat(String appstat) {
        this.appstat = appstat;
    }

    private String adterm;

    @javax.persistence.Column(name = "ADTERM")
    @Basic
    public String getAdterm() {
        return adterm;
    }

    public void setAdterm(String adterm) {
        this.adterm = adterm;
    }

    private String regtyp;

    @javax.persistence.Column(name = "REGTYP")
    @Basic
    public String getRegtyp() {
        return regtyp;
    }

    public void setRegtyp(String regtyp) {
        this.regtyp = regtyp;
    }

    private String clazz;

    @javax.persistence.Column(name = "CLASS")
    @Basic
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    private BigInteger preced;

    @javax.persistence.Column(name = "PRECED")
    @Basic
    public BigInteger getPreced() {
        return preced;
    }

    public void setPreced(BigInteger preced) {
        this.preced = preced;
    }

    private String program;

    @javax.persistence.Column(name = "PROGRAM")
    @Basic
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
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

    private String degree;

    @javax.persistence.Column(name = "DEGREE")
    @Basic
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    private String depart;

    @javax.persistence.Column(name = "DEPART")
    @Basic
    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    private String cipcode;

    @javax.persistence.Column(name = "CIPCODE")
    @Basic
    public String getCipcode() {
        return cipcode;
    }

    public void setCipcode(String cipcode) {
        this.cipcode = cipcode;
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

    private String campus;

    @javax.persistence.Column(name = "CAMPUS")
    @Basic
    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    private String pdegree;

    @javax.persistence.Column(name = "PDEGREE")
    @Basic
    public String getPdegree() {
        return pdegree;
    }

    public void setPdegree(String pdegree) {
        this.pdegree = pdegree;
    }

    private String acgelg;

    @javax.persistence.Column(name = "ACGELG")
    @Basic
    public String getAcgelg() {
        return acgelg;
    }

    public void setAcgelg(String acgelg) {
        this.acgelg = acgelg;
    }

    private String rhsprog;

    @javax.persistence.Column(name = "RHSPROG")
    @Basic
    public String getRhsprog() {
        return rhsprog;
    }

    public void setRhsprog(String rhsprog) {
        this.rhsprog = rhsprog;
    }

    private String hsgrdte;

    @javax.persistence.Column(name = "HSGRDTE")
    @Basic
    public String getHsgrdte() {
        return hsgrdte;
    }

    public void setHsgrdte(String hsgrdte) {
        this.hsgrdte = hsgrdte;
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

        XamEntity xamEntity = (XamEntity) o;

        if (revlev != xamEntity.revlev) return false;
        if (tblatt != xamEntity.tblatt) return false;
        if (transq != xamEntity.transq) return false;
        if (triatt != xamEntity.triatt) return false;
        if (acgelg != null ? !acgelg.equals(xamEntity.acgelg) : xamEntity.acgelg != null) return false;
        if (acton != null ? !acton.equals(xamEntity.acton) : xamEntity.acton != null) return false;
        if (admstat != null ? !admstat.equals(xamEntity.admstat) : xamEntity.admstat != null) return false;
        if (admtyp != null ? !admtyp.equals(xamEntity.admtyp) : xamEntity.admtyp != null) return false;
        if (adterm != null ? !adterm.equals(xamEntity.adterm) : xamEntity.adterm != null) return false;
        if (aidyr != null ? !aidyr.equals(xamEntity.aidyr) : xamEntity.aidyr != null) return false;
        if (appstat != null ? !appstat.equals(xamEntity.appstat) : xamEntity.appstat != null) return false;
        if (arules != null ? !arules.equals(xamEntity.arules) : xamEntity.arules != null) return false;
        if (campus != null ? !campus.equals(xamEntity.campus) : xamEntity.campus != null) return false;
        if (cipcode != null ? !cipcode.equals(xamEntity.cipcode) : xamEntity.cipcode != null) return false;
        if (clazz != null ? !clazz.equals(xamEntity.clazz) : xamEntity.clazz != null) return false;
        if (crtdtec != null ? !crtdtec.equals(xamEntity.crtdtec) : xamEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(xamEntity.crtmod) : xamEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(xamEntity.crttime) : xamEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(xamEntity.crtuser) : xamEntity.crtuser != null) return false;
        if (degree != null ? !degree.equals(xamEntity.degree) : xamEntity.degree != null) return false;
        if (delim != null ? !delim.equals(xamEntity.delim) : xamEntity.delim != null) return false;
        if (depart != null ? !depart.equals(xamEntity.depart) : xamEntity.depart != null) return false;
        if (divisn != null ? !divisn.equals(xamEntity.divisn) : xamEntity.divisn != null) return false;
        if (hsgrdte != null ? !hsgrdte.equals(xamEntity.hsgrdte) : xamEntity.hsgrdte != null) return false;
        if (pdegree != null ? !pdegree.equals(xamEntity.pdegree) : xamEntity.pdegree != null) return false;
        if (preced != null ? !preced.equals(xamEntity.preced) : xamEntity.preced != null) return false;
        if (primid != null ? !primid.equals(xamEntity.primid) : xamEntity.primid != null) return false;
        if (program != null ? !program.equals(xamEntity.program) : xamEntity.program != null) return false;
        if (recstat != null ? !recstat.equals(xamEntity.recstat) : xamEntity.recstat != null) return false;
        if (regtyp != null ? !regtyp.equals(xamEntity.regtyp) : xamEntity.regtyp != null) return false;
        if (revdtec != null ? !revdtec.equals(xamEntity.revdtec) : xamEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(xamEntity.revmod) : xamEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(xamEntity.revtime) : xamEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(xamEntity.revuser) : xamEntity.revuser != null) return false;
        if (rhsprog != null ? !rhsprog.equals(xamEntity.rhsprog) : xamEntity.rhsprog != null) return false;
        if (scycle != null ? !scycle.equals(xamEntity.scycle) : xamEntity.scycle != null) return false;
        if (subseq != null ? !subseq.equals(xamEntity.subseq) : xamEntity.subseq != null) return false;
        if (tbldte != null ? !tbldte.equals(xamEntity.tbldte) : xamEntity.tbldte != null) return false;
        if (tblerr != null ? !tblerr.equals(xamEntity.tblerr) : xamEntity.tblerr != null) return false;
        if (tbltm != null ? !tbltm.equals(xamEntity.tbltm) : xamEntity.tbltm != null) return false;
        if (term != null ? !term.equals(xamEntity.term) : xamEntity.term != null) return false;
        if (trandt != null ? !trandt.equals(xamEntity.trandt) : xamEntity.trandt != null) return false;
        if (trantm != null ? !trantm.equals(xamEntity.trantm) : xamEntity.trantm != null) return false;
        if (tridte != null ? !tridte.equals(xamEntity.tridte) : xamEntity.tridte != null) return false;
        if (trierr != null ? !trierr.equals(xamEntity.trierr) : xamEntity.trierr != null) return false;
        if (triggr != null ? !triggr.equals(xamEntity.triggr) : xamEntity.triggr != null) return false;
        if (tritm != null ? !tritm.equals(xamEntity.tritm) : xamEntity.tritm != null) return false;
        if (ucode != null ? !ucode.equals(xamEntity.ucode) : xamEntity.ucode != null) return false;
        if (updte != null ? !updte.equals(xamEntity.updte) : xamEntity.updte != null) return false;
        if (xamkey != null ? !xamkey.equals(xamEntity.xamkey) : xamEntity.xamkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (xamkey != null ? xamkey.hashCode() : 0);
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
        result = 31 * result + (admstat != null ? admstat.hashCode() : 0);
        result = 31 * result + (admtyp != null ? admtyp.hashCode() : 0);
        result = 31 * result + (appstat != null ? appstat.hashCode() : 0);
        result = 31 * result + (adterm != null ? adterm.hashCode() : 0);
        result = 31 * result + (regtyp != null ? regtyp.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (preced != null ? preced.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + (divisn != null ? divisn.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (depart != null ? depart.hashCode() : 0);
        result = 31 * result + (cipcode != null ? cipcode.hashCode() : 0);
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
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (pdegree != null ? pdegree.hashCode() : 0);
        result = 31 * result + (acgelg != null ? acgelg.hashCode() : 0);
        result = 31 * result + (rhsprog != null ? rhsprog.hashCode() : 0);
        result = 31 * result + (hsgrdte != null ? hsgrdte.hashCode() : 0);
        result = 31 * result + (scycle != null ? scycle.hashCode() : 0);
        result = 31 * result + (arules != null ? arules.hashCode() : 0);
        return result;
    }
}
