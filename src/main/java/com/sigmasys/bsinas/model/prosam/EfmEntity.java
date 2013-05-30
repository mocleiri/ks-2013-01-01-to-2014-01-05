package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/25/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "EFM", schema = "SIGMA", catalog = "")
@Entity
public class EfmEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getEfmkey();
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

    private String efmkey;

    @javax.persistence.Column(name = "EFMKEY")
    @Id
    public String getEfmkey() {
        return efmkey;
    }

    public void setEfmkey(String efmkey) {
        this.efmkey = efmkey;
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

    private String mfid;

    @javax.persistence.Column(name = "MFID")
    @Basic
    public String getMfid() {
        return mfid;
    }

    public void setMfid(String mfid) {
        this.mfid = mfid;
    }

    private int recseq;

    @javax.persistence.Column(name = "RECSEQ")
    @Basic
    public int getRecseq() {
        return recseq;
    }

    public void setRecseq(int recseq) {
        this.recseq = recseq;
    }

    private String submfid;

    @javax.persistence.Column(name = "SUBMFID")
    @Basic
    public String getSubmfid() {
        return submfid;
    }

    public void setSubmfid(String submfid) {
        this.submfid = submfid;
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

    private String crttime;

    @javax.persistence.Column(name = "CRTTIME")
    @Basic
    public String getCrttime() {
        return crttime;
    }

    public void setCrttime(String crttime) {
        this.crttime = crttime;
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

    private String crtpgm;

    @javax.persistence.Column(name = "CRTPGM")
    @Basic
    public String getCrtpgm() {
        return crtpgm;
    }

    public void setCrtpgm(String crtpgm) {
        this.crtpgm = crtpgm;
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

    private String revtime;

    @javax.persistence.Column(name = "REVTIME")
    @Basic
    public String getRevtime() {
        return revtime;
    }

    public void setRevtime(String revtime) {
        this.revtime = revtime;
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

    private String revpgm;

    @javax.persistence.Column(name = "REVPGM")
    @Basic
    public String getRevpgm() {
        return revpgm;
    }

    public void setRevpgm(String revpgm) {
        this.revpgm = revpgm;
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

    private String exprdte;

    @javax.persistence.Column(name = "EXPRDTE")
    @Basic
    public String getExprdte() {
        return exprdte;
    }

    public void setExprdte(String exprdte) {
        this.exprdte = exprdte;
    }

    private String schcode;

    @javax.persistence.Column(name = "SCHCODE")
    @Basic
    public String getSchcode() {
        return schcode;
    }

    public void setSchcode(String schcode) {
        this.schcode = schcode;
    }

    private String acttype;

    @javax.persistence.Column(name = "ACTTYPE")
    @Basic
    public String getActtype() {
        return acttype;
    }

    public void setActtype(String acttype) {
        this.acttype = acttype;
    }

    private String confcde;

    @javax.persistence.Column(name = "CONFCDE")
    @Basic
    public String getConfcde() {
        return confcde;
    }

    public void setConfcde(String confcde) {
        this.confcde = confcde;
    }

    private int tranamt;

    @javax.persistence.Column(name = "TRANAMT")
    @Basic
    public int getTranamt() {
        return tranamt;
    }

    public void setTranamt(int tranamt) {
        this.tranamt = tranamt;
    }

    private String trandte;

    @javax.persistence.Column(name = "TRANDTE")
    @Basic
    public String getTrandte() {
        return trandte;
    }

    public void setTrandte(String trandte) {
        this.trandte = trandte;
    }

    private String rcnstat;

    @javax.persistence.Column(name = "RCNSTAT")
    @Basic
    public String getRcnstat() {
        return rcnstat;
    }

    public void setRcnstat(String rcnstat) {
        this.rcnstat = rcnstat;
    }

    private String unuseda;

    @javax.persistence.Column(name = "UNUSEDA")
    @Basic
    public String getUnuseda() {
        return unuseda;
    }

    public void setUnuseda(String unuseda) {
        this.unuseda = unuseda;
    }

    private String rcndte;

    @javax.persistence.Column(name = "RCNDTE")
    @Basic
    public String getRcndte() {
        return rcndte;
    }

    public void setRcndte(String rcndte) {
        this.rcndte = rcndte;
    }

    private String usercd1;

    @javax.persistence.Column(name = "USERCD1")
    @Basic
    public String getUsercd1() {
        return usercd1;
    }

    public void setUsercd1(String usercd1) {
        this.usercd1 = usercd1;
    }

    private String usercd2;

    @javax.persistence.Column(name = "USERCD2")
    @Basic
    public String getUsercd2() {
        return usercd2;
    }

    public void setUsercd2(String usercd2) {
        this.usercd2 = usercd2;
    }

    private String gapnum;

    @javax.persistence.Column(name = "GAPNUM")
    @Basic
    public String getGapnum() {
        return gapnum;
    }

    public void setGapnum(String gapnum) {
        this.gapnum = gapnum;
    }

    private String chknum;

    @javax.persistence.Column(name = "CHKNUM")
    @Basic
    public String getChknum() {
        return chknum;
    }

    public void setChknum(String chknum) {
        this.chknum = chknum;
    }

    private String rcnbtch;

    @javax.persistence.Column(name = "RCNBTCH")
    @Basic
    public String getRcnbtch() {
        return rcnbtch;
    }

    public void setRcnbtch(String rcnbtch) {
        this.rcnbtch = rcnbtch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EfmEntity efmEntity = (EfmEntity) o;

        if (recseq != efmEntity.recseq) return false;
        if (revlev != efmEntity.revlev) return false;
        if (tranamt != efmEntity.tranamt) return false;
        if (acttype != null ? !acttype.equals(efmEntity.acttype) : efmEntity.acttype != null) return false;
        if (chknum != null ? !chknum.equals(efmEntity.chknum) : efmEntity.chknum != null) return false;
        if (confcde != null ? !confcde.equals(efmEntity.confcde) : efmEntity.confcde != null) return false;
        if (crtdte != null ? !crtdte.equals(efmEntity.crtdte) : efmEntity.crtdte != null) return false;
        if (crtpgm != null ? !crtpgm.equals(efmEntity.crtpgm) : efmEntity.crtpgm != null) return false;
        if (crttime != null ? !crttime.equals(efmEntity.crttime) : efmEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(efmEntity.crtuser) : efmEntity.crtuser != null) return false;
        if (efmkey != null ? !efmkey.equals(efmEntity.efmkey) : efmEntity.efmkey != null) return false;
        if (exprdte != null ? !exprdte.equals(efmEntity.exprdte) : efmEntity.exprdte != null) return false;
        if (gapnum != null ? !gapnum.equals(efmEntity.gapnum) : efmEntity.gapnum != null) return false;
        if (mfid != null ? !mfid.equals(efmEntity.mfid) : efmEntity.mfid != null) return false;
        if (procyr != null ? !procyr.equals(efmEntity.procyr) : efmEntity.procyr != null) return false;
        if (rcnbtch != null ? !rcnbtch.equals(efmEntity.rcnbtch) : efmEntity.rcnbtch != null) return false;
        if (rcndte != null ? !rcndte.equals(efmEntity.rcndte) : efmEntity.rcndte != null) return false;
        if (rcnstat != null ? !rcnstat.equals(efmEntity.rcnstat) : efmEntity.rcnstat != null) return false;
        if (recstat != null ? !recstat.equals(efmEntity.recstat) : efmEntity.recstat != null) return false;
        if (revdte != null ? !revdte.equals(efmEntity.revdte) : efmEntity.revdte != null) return false;
        if (revpgm != null ? !revpgm.equals(efmEntity.revpgm) : efmEntity.revpgm != null) return false;
        if (revtime != null ? !revtime.equals(efmEntity.revtime) : efmEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(efmEntity.revuser) : efmEntity.revuser != null) return false;
        if (schcode != null ? !schcode.equals(efmEntity.schcode) : efmEntity.schcode != null) return false;
        if (status != null ? !status.equals(efmEntity.status) : efmEntity.status != null) return false;
        if (submfid != null ? !submfid.equals(efmEntity.submfid) : efmEntity.submfid != null) return false;
        if (trandte != null ? !trandte.equals(efmEntity.trandte) : efmEntity.trandte != null) return false;
        if (ucode != null ? !ucode.equals(efmEntity.ucode) : efmEntity.ucode != null) return false;
        if (unuseda != null ? !unuseda.equals(efmEntity.unuseda) : efmEntity.unuseda != null) return false;
        if (usercd1 != null ? !usercd1.equals(efmEntity.usercd1) : efmEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(efmEntity.usercd2) : efmEntity.usercd2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (efmkey != null ? efmkey.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (mfid != null ? mfid.hashCode() : 0);
        result = 31 * result + recseq;
        result = 31 * result + (submfid != null ? submfid.hashCode() : 0);
        result = 31 * result + (crtdte != null ? crtdte.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtpgm != null ? crtpgm.hashCode() : 0);
        result = 31 * result + (revdte != null ? revdte.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revpgm != null ? revpgm.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (exprdte != null ? exprdte.hashCode() : 0);
        result = 31 * result + (schcode != null ? schcode.hashCode() : 0);
        result = 31 * result + (acttype != null ? acttype.hashCode() : 0);
        result = 31 * result + (confcde != null ? confcde.hashCode() : 0);
        result = 31 * result + tranamt;
        result = 31 * result + (trandte != null ? trandte.hashCode() : 0);
        result = 31 * result + (rcnstat != null ? rcnstat.hashCode() : 0);
        result = 31 * result + (unuseda != null ? unuseda.hashCode() : 0);
        result = 31 * result + (rcndte != null ? rcndte.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (gapnum != null ? gapnum.hashCode() : 0);
        result = 31 * result + (chknum != null ? chknum.hashCode() : 0);
        result = 31 * result + (rcnbtch != null ? rcnbtch.hashCode() : 0);
        return result;
    }
}
