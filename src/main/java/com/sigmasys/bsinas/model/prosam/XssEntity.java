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
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "XSS", schema = "SIGMA", catalog = "")
@Entity
public class XssEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getXsskey();
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

    private String xsskey;

    @javax.persistence.Column(name = "XSSKEY")
    @Id
    public String getXsskey() {
        return xsskey;
    }

    public void setXsskey(String xsskey) {
        this.xsskey = xsskey;
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

    private String sessid;

    @javax.persistence.Column(name = "SESSID")
    @Basic
    public String getSessid() {
        return sessid;
    }

    public void setSessid(String sessid) {
        this.sessid = sessid;
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

    private String pdegree;

    @javax.persistence.Column(name = "PDEGREE")
    @Basic
    public String getPdegree() {
        return pdegree;
    }

    public void setPdegree(String pdegree) {
        this.pdegree = pdegree;
    }

    private String ecampus;

    @javax.persistence.Column(name = "ECAMPUS")
    @Basic
    public String getEcampus() {
        return ecampus;
    }

    public void setEcampus(String ecampus) {
        this.ecampus = ecampus;
    }

    private String feecat;

    @javax.persistence.Column(name = "FEECAT")
    @Basic
    public String getFeecat() {
        return feecat;
    }

    public void setFeecat(String feecat) {
        this.feecat = feecat;
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

    private String clazz;

    @javax.persistence.Column(name = "CLASS")
    @Basic
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
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

    private String scycle;

    @javax.persistence.Column(name = "SCYCLE")
    @Basic
    public String getScycle() {
        return scycle;
    }

    public void setScycle(String scycle) {
        this.scycle = scycle;
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

    private BigDecimal cumgpa;

    @javax.persistence.Column(name = "CUMGPA")
    @Basic
    public BigDecimal getCumgpa() {
        return cumgpa;
    }

    public void setCumgpa(BigDecimal cumgpa) {
        this.cumgpa = cumgpa;
    }

    private BigDecimal trmgpa;

    @javax.persistence.Column(name = "TRMGPA")
    @Basic
    public BigDecimal getTrmgpa() {
        return trmgpa;
    }

    public void setTrmgpa(BigDecimal trmgpa) {
        this.trmgpa = trmgpa;
    }

    private BigDecimal cmhrsd;

    @javax.persistence.Column(name = "CMHRSD")
    @Basic
    public BigDecimal getCmhrsd() {
        return cmhrsd;
    }

    public void setCmhrsd(BigDecimal cmhrsd) {
        this.cmhrsd = cmhrsd;
    }

    private String acstdf;

    @javax.persistence.Column(name = "ACSTDF")
    @Basic
    public String getAcstdf() {
        return acstdf;
    }

    public void setAcstdf(String acstdf) {
        this.acstdf = acstdf;
    }

    private String acstds;

    @javax.persistence.Column(name = "ACSTDS")
    @Basic
    public String getAcstds() {
        return acstds;
    }

    public void setAcstds(String acstds) {
        this.acstds = acstds;
    }

    private String acstdi;

    @javax.persistence.Column(name = "ACSTDI")
    @Basic
    public String getAcstdi() {
        return acstdi;
    }

    public void setAcstdi(String acstdi) {
        this.acstdi = acstdi;
    }

    private String acstdl;

    @javax.persistence.Column(name = "ACSTDL")
    @Basic
    public String getAcstdl() {
        return acstdl;
    }

    public void setAcstdl(String acstdl) {
        this.acstdl = acstdl;
    }

    private String acstdo;

    @javax.persistence.Column(name = "ACSTDO")
    @Basic
    public String getAcstdo() {
        return acstdo;
    }

    public void setAcstdo(String acstdo) {
        this.acstdo = acstdo;
    }

    private BigDecimal enrmea;

    @javax.persistence.Column(name = "ENRMEA")
    @Basic
    public BigDecimal getEnrmea() {
        return enrmea;
    }

    public void setEnrmea(BigDecimal enrmea) {
        this.enrmea = enrmea;
    }

    private String prgmea;

    @javax.persistence.Column(name = "PRGMEA")
    @Basic
    public String getPrgmea() {
        return prgmea;
    }

    public void setPrgmea(String prgmea) {
        this.prgmea = prgmea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XssEntity xssEntity = (XssEntity) o;

        if (revlev != xssEntity.revlev) return false;
        if (tblatt != xssEntity.tblatt) return false;
        if (transq != xssEntity.transq) return false;
        if (triatt != xssEntity.triatt) return false;
        if (acstdf != null ? !acstdf.equals(xssEntity.acstdf) : xssEntity.acstdf != null) return false;
        if (acstdi != null ? !acstdi.equals(xssEntity.acstdi) : xssEntity.acstdi != null) return false;
        if (acstdl != null ? !acstdl.equals(xssEntity.acstdl) : xssEntity.acstdl != null) return false;
        if (acstdo != null ? !acstdo.equals(xssEntity.acstdo) : xssEntity.acstdo != null) return false;
        if (acstds != null ? !acstds.equals(xssEntity.acstds) : xssEntity.acstds != null) return false;
        if (acton != null ? !acton.equals(xssEntity.acton) : xssEntity.acton != null) return false;
        if (aidyr != null ? !aidyr.equals(xssEntity.aidyr) : xssEntity.aidyr != null) return false;
        if (arules != null ? !arules.equals(xssEntity.arules) : xssEntity.arules != null) return false;
        if (clazz != null ? !clazz.equals(xssEntity.clazz) : xssEntity.clazz != null) return false;
        if (cmhrsd != null ? !cmhrsd.equals(xssEntity.cmhrsd) : xssEntity.cmhrsd != null) return false;
        if (crtdtec != null ? !crtdtec.equals(xssEntity.crtdtec) : xssEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(xssEntity.crtmod) : xssEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(xssEntity.crttime) : xssEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(xssEntity.crtuser) : xssEntity.crtuser != null) return false;
        if (cumgpa != null ? !cumgpa.equals(xssEntity.cumgpa) : xssEntity.cumgpa != null) return false;
        if (degree != null ? !degree.equals(xssEntity.degree) : xssEntity.degree != null) return false;
        if (delim != null ? !delim.equals(xssEntity.delim) : xssEntity.delim != null) return false;
        if (divisn != null ? !divisn.equals(xssEntity.divisn) : xssEntity.divisn != null) return false;
        if (ecampus != null ? !ecampus.equals(xssEntity.ecampus) : xssEntity.ecampus != null) return false;
        if (enrmea != null ? !enrmea.equals(xssEntity.enrmea) : xssEntity.enrmea != null) return false;
        if (feecat != null ? !feecat.equals(xssEntity.feecat) : xssEntity.feecat != null) return false;
        if (pdegree != null ? !pdegree.equals(xssEntity.pdegree) : xssEntity.pdegree != null) return false;
        if (prgmea != null ? !prgmea.equals(xssEntity.prgmea) : xssEntity.prgmea != null) return false;
        if (primid != null ? !primid.equals(xssEntity.primid) : xssEntity.primid != null) return false;
        if (program != null ? !program.equals(xssEntity.program) : xssEntity.program != null) return false;
        if (recstat != null ? !recstat.equals(xssEntity.recstat) : xssEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(xssEntity.revdtec) : xssEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(xssEntity.revmod) : xssEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(xssEntity.revtime) : xssEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(xssEntity.revuser) : xssEntity.revuser != null) return false;
        if (scycle != null ? !scycle.equals(xssEntity.scycle) : xssEntity.scycle != null) return false;
        if (sessid != null ? !sessid.equals(xssEntity.sessid) : xssEntity.sessid != null) return false;
        if (subseq != null ? !subseq.equals(xssEntity.subseq) : xssEntity.subseq != null) return false;
        if (tbldte != null ? !tbldte.equals(xssEntity.tbldte) : xssEntity.tbldte != null) return false;
        if (tblerr != null ? !tblerr.equals(xssEntity.tblerr) : xssEntity.tblerr != null) return false;
        if (tbltm != null ? !tbltm.equals(xssEntity.tbltm) : xssEntity.tbltm != null) return false;
        if (term != null ? !term.equals(xssEntity.term) : xssEntity.term != null) return false;
        if (trandt != null ? !trandt.equals(xssEntity.trandt) : xssEntity.trandt != null) return false;
        if (trantm != null ? !trantm.equals(xssEntity.trantm) : xssEntity.trantm != null) return false;
        if (tridte != null ? !tridte.equals(xssEntity.tridte) : xssEntity.tridte != null) return false;
        if (trierr != null ? !trierr.equals(xssEntity.trierr) : xssEntity.trierr != null) return false;
        if (triggr != null ? !triggr.equals(xssEntity.triggr) : xssEntity.triggr != null) return false;
        if (tritm != null ? !tritm.equals(xssEntity.tritm) : xssEntity.tritm != null) return false;
        if (trmgpa != null ? !trmgpa.equals(xssEntity.trmgpa) : xssEntity.trmgpa != null) return false;
        if (ucode != null ? !ucode.equals(xssEntity.ucode) : xssEntity.ucode != null) return false;
        if (updte != null ? !updte.equals(xssEntity.updte) : xssEntity.updte != null) return false;
        if (xsskey != null ? !xsskey.equals(xssEntity.xsskey) : xssEntity.xsskey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (xsskey != null ? xsskey.hashCode() : 0);
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
        result = 31 * result + (sessid != null ? sessid.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (pdegree != null ? pdegree.hashCode() : 0);
        result = 31 * result + (ecampus != null ? ecampus.hashCode() : 0);
        result = 31 * result + (feecat != null ? feecat.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (divisn != null ? divisn.hashCode() : 0);
        result = 31 * result + (scycle != null ? scycle.hashCode() : 0);
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
        result = 31 * result + (cumgpa != null ? cumgpa.hashCode() : 0);
        result = 31 * result + (trmgpa != null ? trmgpa.hashCode() : 0);
        result = 31 * result + (cmhrsd != null ? cmhrsd.hashCode() : 0);
        result = 31 * result + (acstdf != null ? acstdf.hashCode() : 0);
        result = 31 * result + (acstds != null ? acstds.hashCode() : 0);
        result = 31 * result + (acstdi != null ? acstdi.hashCode() : 0);
        result = 31 * result + (acstdl != null ? acstdl.hashCode() : 0);
        result = 31 * result + (acstdo != null ? acstdo.hashCode() : 0);
        result = 31 * result + (enrmea != null ? enrmea.hashCode() : 0);
        result = 31 * result + (prgmea != null ? prgmea.hashCode() : 0);
        return result;
    }
}
