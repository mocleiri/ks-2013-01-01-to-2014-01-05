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
 * Time: 11:59 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "LNA", schema = "SIGMA", catalog = "")
@Entity
public class LnaEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getLnakey();
    }

    private String lnakey;

    @javax.persistence.Column(name = "LNAKEY")
    @Id
    public String getLnakey() {
        return lnakey;
    }

    public void setLnakey(String lnakey) {
        this.lnakey = lnakey;
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

    private String lntype;

    @javax.persistence.Column(name = "LNTYPE")
    @Basic
    public String getLntype() {
        return lntype;
    }

    public void setLntype(String lntype) {
        this.lntype = lntype;
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

    private String docid;

    @javax.persistence.Column(name = "DOCID")
    @Basic
    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    private String procdt;

    @javax.persistence.Column(name = "PROCDT")
    @Basic
    public String getProcdt() {
        return procdt;
    }

    public void setProcdt(String procdt) {
        this.procdt = procdt;
    }

    private String rptsch;

    @javax.persistence.Column(name = "RPTSCH")
    @Basic
    public String getRptsch() {
        return rptsch;
    }

    public void setRptsch(String rptsch) {
        this.rptsch = rptsch;
    }

    private String atdsch;

    @javax.persistence.Column(name = "ATDSCH")
    @Basic
    public String getAtdsch() {
        return atdsch;
    }

    public void setAtdsch(String atdsch) {
        this.atdsch = atdsch;
    }

    private String awdtcd;

    @javax.persistence.Column(name = "AWDTCD")
    @Basic
    public String getAwdtcd() {
        return awdtcd;
    }

    public void setAwdtcd(String awdtcd) {
        this.awdtcd = awdtcd;
    }

    private String awdyr;

    @javax.persistence.Column(name = "AWDYR")
    @Basic
    public String getAwdyr() {
        return awdyr;
    }

    public void setAwdyr(String awdyr) {
        this.awdyr = awdyr;
    }

    private String appid;

    @javax.persistence.Column(name = "APPID")
    @Basic
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    private String prapid;

    @javax.persistence.Column(name = "PRAPID")
    @Basic
    public String getPrapid() {
        return prapid;
    }

    public void setPrapid(String prapid) {
        this.prapid = prapid;
    }

    private String bpsnty;

    @javax.persistence.Column(name = "BPSNTY")
    @Basic
    public String getBpsnty() {
        return bpsnty;
    }

    public void setBpsnty(String bpsnty) {
        this.bpsnty = bpsnty;
    }

    private String bssnum;

    @javax.persistence.Column(name = "BSSNUM")
    @Basic
    public String getBssnum() {
        return bssnum;
    }

    public void setBssnum(String bssnum) {
        this.bssnum = bssnum;
    }

    private String bdob;

    @javax.persistence.Column(name = "BDOB")
    @Basic
    public String getBdob() {
        return bdob;
    }

    public void setBdob(String bdob) {
        this.bdob = bdob;
    }

    private String bnamel;

    @javax.persistence.Column(name = "BNAMEL")
    @Basic
    public String getBnamel() {
        return bnamel;
    }

    public void setBnamel(String bnamel) {
        this.bnamel = bnamel;
    }

    private String bnamef;

    @javax.persistence.Column(name = "BNAMEF")
    @Basic
    public String getBnamef() {
        return bnamef;
    }

    public void setBnamef(String bnamef) {
        this.bnamef = bnamef;
    }

    private String bnamem;

    @javax.persistence.Column(name = "BNAMEM")
    @Basic
    public String getBnamem() {
        return bnamem;
    }

    public void setBnamem(String bnamem) {
        this.bnamem = bnamem;
    }

    private int endamt;

    @javax.persistence.Column(name = "ENDAMT")
    @Basic
    public int getEndamt() {
        return endamt;
    }

    public void setEndamt(int endamt) {
        this.endamt = endamt;
    }

    private String ocrdst;

    @javax.persistence.Column(name = "OCRDST")
    @Basic
    public String getOcrdst() {
        return ocrdst;
    }

    public void setOcrdst(String ocrdst) {
        this.ocrdst = ocrdst;
    }

    private String crdcst;

    @javax.persistence.Column(name = "CRDCST")
    @Basic
    public String getCrdcst() {
        return crdcst;
    }

    public void setCrdcst(String crdcst) {
        this.crdcst = crdcst;
    }

    private String cractc;

    @javax.persistence.Column(name = "CRACTC")
    @Basic
    public String getCractc() {
        return cractc;
    }

    public void setCractc(String cractc) {
        this.cractc = cractc;
    }

    private String crapls;

    @javax.persistence.Column(name = "CRAPLS")
    @Basic
    public String getCrapls() {
        return crapls;
    }

    public void setCrapls(String crapls) {
        this.crapls = crapls;
    }

    private String cddte;

    @javax.persistence.Column(name = "CDDTE")
    @Basic
    public String getCddte() {
        return cddte;
    }

    public void setCddte(String cddte) {
        this.cddte = cddte;
    }

    private String cdexdt;

    @javax.persistence.Column(name = "CDEXDT")
    @Basic
    public String getCdexdt() {
        return cdexdt;
    }

    public void setCdexdt(String cdexdt) {
        this.cdexdt = cdexdt;
    }

    private String cdovri;

    @javax.persistence.Column(name = "CDOVRI")
    @Basic
    public String getCdovri() {
        return cdovri;
    }

    public void setCdovri(String cdovri) {
        this.cdovri = cdovri;
    }

    private BigDecimal alnamt;

    @javax.persistence.Column(name = "ALNAMT")
    @Basic
    public BigDecimal getAlnamt() {
        return alnamt;
    }

    public void setAlnamt(BigDecimal alnamt) {
        this.alnamt = alnamt;
    }

    private String mxlnai;

    @javax.persistence.Column(name = "MXLNAI")
    @Basic
    public String getMxlnai() {
        return mxlnai;
    }

    public void setMxlnai(String mxlnai) {
        this.mxlnai = mxlnai;
    }

    private String aprqdt;

    @javax.persistence.Column(name = "APRQDT")
    @Basic
    public String getAprqdt() {
        return aprqdt;
    }

    public void setAprqdt(String aprqdt) {
        this.aprqdt = aprqdt;
    }

    private String aprqtm;

    @javax.persistence.Column(name = "APRQTM")
    @Basic
    public String getAprqtm() {
        return aprqtm;
    }

    public void setAprqtm(String aprqtm) {
        this.aprqtm = aprqtm;
    }

    private String awdsdt;

    @javax.persistence.Column(name = "AWDSDT")
    @Basic
    public String getAwdsdt() {
        return awdsdt;
    }

    public void setAwdsdt(String awdsdt) {
        this.awdsdt = awdsdt;
    }

    private String awdedt;

    @javax.persistence.Column(name = "AWDEDT")
    @Basic
    public String getAwdedt() {
        return awdedt;
    }

    public void setAwdedt(String awdedt) {
        this.awdedt = awdedt;
    }

    private String defopt;

    @javax.persistence.Column(name = "DEFOPT")
    @Basic
    public String getDefopt() {
        return defopt;
    }

    public void setDefopt(String defopt) {
        this.defopt = defopt;
    }

    private String smthdo;

    @javax.persistence.Column(name = "SMTHDO")
    @Basic
    public String getSmthdo() {
        return smthdo;
    }

    public void setSmthdo(String smthdo) {
        this.smthdo = smthdo;
    }

    private String scrbo;

    @javax.persistence.Column(name = "SCRBO")
    @Basic
    public String getScrbo() {
        return scrbo;
    }

    public void setScrbo(String scrbo) {
        this.scrbo = scrbo;
    }

    private String crbalo;

    @javax.persistence.Column(name = "CRBALO")
    @Basic
    public String getCrbalo() {
        return crbalo;
    }

    public void setCrbalo(String crbalo) {
        this.crbalo = crbalo;
    }

    private String appsr;

    @javax.persistence.Column(name = "APPSR")
    @Basic
    public String getAppsr() {
        return appsr;
    }

    public void setAppsr(String appsr) {
        this.appsr = appsr;
    }

    private String unlamt;

    @javax.persistence.Column(name = "UNLAMT")
    @Basic
    public String getUnlamt() {
        return unlamt;
    }

    public void setUnlamt(String unlamt) {
        this.unlamt = unlamt;
    }

    private String reqsrc;

    @javax.persistence.Column(name = "REQSRC")
    @Basic
    public String getReqsrc() {
        return reqsrc;
    }

    public void setReqsrc(String reqsrc) {
        this.reqsrc = reqsrc;
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

    private String lpstrm;

    @javax.persistence.Column(name = "LPSTRM")
    @Basic
    public String getLpstrm() {
        return lpstrm;
    }

    public void setLpstrm(String lpstrm) {
        this.lpstrm = lpstrm;
    }

    private String lpetrm;

    @javax.persistence.Column(name = "LPETRM")
    @Basic
    public String getLpetrm() {
        return lpetrm;
    }

    public void setLpetrm(String lpetrm) {
        this.lpetrm = lpetrm;
    }

    private String aaidid;

    @javax.persistence.Column(name = "AAIDID")
    @Basic
    public String getAaidid() {
        return aaidid;
    }

    public void setAaidid(String aaidid) {
        this.aaidid = aaidid;
    }

    private String linkst;

    @javax.persistence.Column(name = "LINKST")
    @Basic
    public String getLinkst() {
        return linkst;
    }

    public void setLinkst(String linkst) {
        this.linkst = linkst;
    }

    private String syspdt;

    @javax.persistence.Column(name = "SYSPDT")
    @Basic
    public String getSyspdt() {
        return syspdt;
    }

    public void setSyspdt(String syspdt) {
        this.syspdt = syspdt;
    }

    private String sysrcd;

    @javax.persistence.Column(name = "SYSRCD")
    @Basic
    public String getSysrcd() {
        return sysrcd;
    }

    public void setSysrcd(String sysrcd) {
        this.sysrcd = sysrcd;
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

    private BigDecimal cpct1;

    @javax.persistence.Column(name = "CPCT1")
    @Basic
    public BigDecimal getCpct1() {
        return cpct1;
    }

    public void setCpct1(BigDecimal cpct1) {
        this.cpct1 = cpct1;
    }

    private BigDecimal cpct2;

    @javax.persistence.Column(name = "CPCT2")
    @Basic
    public BigDecimal getCpct2() {
        return cpct2;
    }

    public void setCpct2(BigDecimal cpct2) {
        this.cpct2 = cpct2;
    }

    private BigDecimal cpct3;

    @javax.persistence.Column(name = "CPCT3")
    @Basic
    public BigDecimal getCpct3() {
        return cpct3;
    }

    public void setCpct3(BigDecimal cpct3) {
        this.cpct3 = cpct3;
    }

    private BigDecimal cpct4;

    @javax.persistence.Column(name = "CPCT4")
    @Basic
    public BigDecimal getCpct4() {
        return cpct4;
    }

    public void setCpct4(BigDecimal cpct4) {
        this.cpct4 = cpct4;
    }

    private String cstat1;

    @javax.persistence.Column(name = "CSTAT1")
    @Basic
    public String getCstat1() {
        return cstat1;
    }

    public void setCstat1(String cstat1) {
        this.cstat1 = cstat1;
    }

    private String cstat2;

    @javax.persistence.Column(name = "CSTAT2")
    @Basic
    public String getCstat2() {
        return cstat2;
    }

    public void setCstat2(String cstat2) {
        this.cstat2 = cstat2;
    }

    private String cstat3;

    @javax.persistence.Column(name = "CSTAT3")
    @Basic
    public String getCstat3() {
        return cstat3;
    }

    public void setCstat3(String cstat3) {
        this.cstat3 = cstat3;
    }

    private String cstat4;

    @javax.persistence.Column(name = "CSTAT4")
    @Basic
    public String getCstat4() {
        return cstat4;
    }

    public void setCstat4(String cstat4) {
        this.cstat4 = cstat4;
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

    private String usrnt1;

    @javax.persistence.Column(name = "USRNT1")
    @Basic
    public String getUsrnt1() {
        return usrnt1;
    }

    public void setUsrnt1(String usrnt1) {
        this.usrnt1 = usrnt1;
    }

    private String usrnt2;

    @javax.persistence.Column(name = "USRNT2")
    @Basic
    public String getUsrnt2() {
        return usrnt2;
    }

    public void setUsrnt2(String usrnt2) {
        this.usrnt2 = usrnt2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LnaEntity lnaEntity = (LnaEntity) o;

        if (endamt != lnaEntity.endamt) return false;
        if (revlev != lnaEntity.revlev) return false;
        if (seqno != lnaEntity.seqno) return false;
        if (aaidid != null ? !aaidid.equals(lnaEntity.aaidid) : lnaEntity.aaidid != null) return false;
        if (aidyr != null ? !aidyr.equals(lnaEntity.aidyr) : lnaEntity.aidyr != null) return false;
        if (alnamt != null ? !alnamt.equals(lnaEntity.alnamt) : lnaEntity.alnamt != null) return false;
        if (appid != null ? !appid.equals(lnaEntity.appid) : lnaEntity.appid != null) return false;
        if (appsr != null ? !appsr.equals(lnaEntity.appsr) : lnaEntity.appsr != null) return false;
        if (aprqdt != null ? !aprqdt.equals(lnaEntity.aprqdt) : lnaEntity.aprqdt != null) return false;
        if (aprqtm != null ? !aprqtm.equals(lnaEntity.aprqtm) : lnaEntity.aprqtm != null) return false;
        if (atdsch != null ? !atdsch.equals(lnaEntity.atdsch) : lnaEntity.atdsch != null) return false;
        if (awdedt != null ? !awdedt.equals(lnaEntity.awdedt) : lnaEntity.awdedt != null) return false;
        if (awdsdt != null ? !awdsdt.equals(lnaEntity.awdsdt) : lnaEntity.awdsdt != null) return false;
        if (awdtcd != null ? !awdtcd.equals(lnaEntity.awdtcd) : lnaEntity.awdtcd != null) return false;
        if (awdyr != null ? !awdyr.equals(lnaEntity.awdyr) : lnaEntity.awdyr != null) return false;
        if (bdob != null ? !bdob.equals(lnaEntity.bdob) : lnaEntity.bdob != null) return false;
        if (bnamef != null ? !bnamef.equals(lnaEntity.bnamef) : lnaEntity.bnamef != null) return false;
        if (bnamel != null ? !bnamel.equals(lnaEntity.bnamel) : lnaEntity.bnamel != null) return false;
        if (bnamem != null ? !bnamem.equals(lnaEntity.bnamem) : lnaEntity.bnamem != null) return false;
        if (bpsnty != null ? !bpsnty.equals(lnaEntity.bpsnty) : lnaEntity.bpsnty != null) return false;
        if (bssnum != null ? !bssnum.equals(lnaEntity.bssnum) : lnaEntity.bssnum != null) return false;
        if (camt1 != null ? !camt1.equals(lnaEntity.camt1) : lnaEntity.camt1 != null) return false;
        if (camt2 != null ? !camt2.equals(lnaEntity.camt2) : lnaEntity.camt2 != null) return false;
        if (camt3 != null ? !camt3.equals(lnaEntity.camt3) : lnaEntity.camt3 != null) return false;
        if (camt4 != null ? !camt4.equals(lnaEntity.camt4) : lnaEntity.camt4 != null) return false;
        if (cddte != null ? !cddte.equals(lnaEntity.cddte) : lnaEntity.cddte != null) return false;
        if (cdexdt != null ? !cdexdt.equals(lnaEntity.cdexdt) : lnaEntity.cdexdt != null) return false;
        if (cdovri != null ? !cdovri.equals(lnaEntity.cdovri) : lnaEntity.cdovri != null) return false;
        if (cpct1 != null ? !cpct1.equals(lnaEntity.cpct1) : lnaEntity.cpct1 != null) return false;
        if (cpct2 != null ? !cpct2.equals(lnaEntity.cpct2) : lnaEntity.cpct2 != null) return false;
        if (cpct3 != null ? !cpct3.equals(lnaEntity.cpct3) : lnaEntity.cpct3 != null) return false;
        if (cpct4 != null ? !cpct4.equals(lnaEntity.cpct4) : lnaEntity.cpct4 != null) return false;
        if (cractc != null ? !cractc.equals(lnaEntity.cractc) : lnaEntity.cractc != null) return false;
        if (crapls != null ? !crapls.equals(lnaEntity.crapls) : lnaEntity.crapls != null) return false;
        if (crbalo != null ? !crbalo.equals(lnaEntity.crbalo) : lnaEntity.crbalo != null) return false;
        if (crdcst != null ? !crdcst.equals(lnaEntity.crdcst) : lnaEntity.crdcst != null) return false;
        if (crtdte != null ? !crtdte.equals(lnaEntity.crtdte) : lnaEntity.crtdte != null) return false;
        if (crtmod != null ? !crtmod.equals(lnaEntity.crtmod) : lnaEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(lnaEntity.crttime) : lnaEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(lnaEntity.crtuser) : lnaEntity.crtuser != null) return false;
        if (cstat1 != null ? !cstat1.equals(lnaEntity.cstat1) : lnaEntity.cstat1 != null) return false;
        if (cstat2 != null ? !cstat2.equals(lnaEntity.cstat2) : lnaEntity.cstat2 != null) return false;
        if (cstat3 != null ? !cstat3.equals(lnaEntity.cstat3) : lnaEntity.cstat3 != null) return false;
        if (cstat4 != null ? !cstat4.equals(lnaEntity.cstat4) : lnaEntity.cstat4 != null) return false;
        if (defopt != null ? !defopt.equals(lnaEntity.defopt) : lnaEntity.defopt != null) return false;
        if (docid != null ? !docid.equals(lnaEntity.docid) : lnaEntity.docid != null) return false;
        if (linkst != null ? !linkst.equals(lnaEntity.linkst) : lnaEntity.linkst != null) return false;
        if (lnakey != null ? !lnakey.equals(lnaEntity.lnakey) : lnaEntity.lnakey != null) return false;
        if (lntype != null ? !lntype.equals(lnaEntity.lntype) : lnaEntity.lntype != null) return false;
        if (lpetrm != null ? !lpetrm.equals(lnaEntity.lpetrm) : lnaEntity.lpetrm != null) return false;
        if (lpstrm != null ? !lpstrm.equals(lnaEntity.lpstrm) : lnaEntity.lpstrm != null) return false;
        if (mxlnai != null ? !mxlnai.equals(lnaEntity.mxlnai) : lnaEntity.mxlnai != null) return false;
        if (ocrdst != null ? !ocrdst.equals(lnaEntity.ocrdst) : lnaEntity.ocrdst != null) return false;
        if (prapid != null ? !prapid.equals(lnaEntity.prapid) : lnaEntity.prapid != null) return false;
        if (procdt != null ? !procdt.equals(lnaEntity.procdt) : lnaEntity.procdt != null) return false;
        if (reqsrc != null ? !reqsrc.equals(lnaEntity.reqsrc) : lnaEntity.reqsrc != null) return false;
        if (revdte != null ? !revdte.equals(lnaEntity.revdte) : lnaEntity.revdte != null) return false;
        if (revmod != null ? !revmod.equals(lnaEntity.revmod) : lnaEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(lnaEntity.revtime) : lnaEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(lnaEntity.revuser) : lnaEntity.revuser != null) return false;
        if (rptsch != null ? !rptsch.equals(lnaEntity.rptsch) : lnaEntity.rptsch != null) return false;
        if (scrbo != null ? !scrbo.equals(lnaEntity.scrbo) : lnaEntity.scrbo != null) return false;
        if (sid != null ? !sid.equals(lnaEntity.sid) : lnaEntity.sid != null) return false;
        if (smthdo != null ? !smthdo.equals(lnaEntity.smthdo) : lnaEntity.smthdo != null) return false;
        if (status != null ? !status.equals(lnaEntity.status) : lnaEntity.status != null) return false;
        if (syspdt != null ? !syspdt.equals(lnaEntity.syspdt) : lnaEntity.syspdt != null) return false;
        if (sysrcd != null ? !sysrcd.equals(lnaEntity.sysrcd) : lnaEntity.sysrcd != null) return false;
        if (ucode != null ? !ucode.equals(lnaEntity.ucode) : lnaEntity.ucode != null) return false;
        if (unlamt != null ? !unlamt.equals(lnaEntity.unlamt) : lnaEntity.unlamt != null) return false;
        if (usrcd1 != null ? !usrcd1.equals(lnaEntity.usrcd1) : lnaEntity.usrcd1 != null) return false;
        if (usrcd2 != null ? !usrcd2.equals(lnaEntity.usrcd2) : lnaEntity.usrcd2 != null) return false;
        if (usrcd3 != null ? !usrcd3.equals(lnaEntity.usrcd3) : lnaEntity.usrcd3 != null) return false;
        if (usrcd4 != null ? !usrcd4.equals(lnaEntity.usrcd4) : lnaEntity.usrcd4 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(lnaEntity.usrdt1) : lnaEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(lnaEntity.usrdt2) : lnaEntity.usrdt2 != null) return false;
        if (usrdt3 != null ? !usrdt3.equals(lnaEntity.usrdt3) : lnaEntity.usrdt3 != null) return false;
        if (usrdt4 != null ? !usrdt4.equals(lnaEntity.usrdt4) : lnaEntity.usrdt4 != null) return false;
        if (usrnr1 != null ? !usrnr1.equals(lnaEntity.usrnr1) : lnaEntity.usrnr1 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(lnaEntity.usrnr2) : lnaEntity.usrnr2 != null) return false;
        if (usrnr3 != null ? !usrnr3.equals(lnaEntity.usrnr3) : lnaEntity.usrnr3 != null) return false;
        if (usrnr4 != null ? !usrnr4.equals(lnaEntity.usrnr4) : lnaEntity.usrnr4 != null) return false;
        if (usrnr5 != null ? !usrnr5.equals(lnaEntity.usrnr5) : lnaEntity.usrnr5 != null) return false;
        if (usrnt1 != null ? !usrnt1.equals(lnaEntity.usrnt1) : lnaEntity.usrnt1 != null) return false;
        if (usrnt2 != null ? !usrnt2.equals(lnaEntity.usrnt2) : lnaEntity.usrnt2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lnakey != null ? lnakey.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (lntype != null ? lntype.hashCode() : 0);
        result = 31 * result + seqno;
        result = 31 * result + (crtdte != null ? crtdte.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (revdte != null ? revdte.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (docid != null ? docid.hashCode() : 0);
        result = 31 * result + (procdt != null ? procdt.hashCode() : 0);
        result = 31 * result + (rptsch != null ? rptsch.hashCode() : 0);
        result = 31 * result + (atdsch != null ? atdsch.hashCode() : 0);
        result = 31 * result + (awdtcd != null ? awdtcd.hashCode() : 0);
        result = 31 * result + (awdyr != null ? awdyr.hashCode() : 0);
        result = 31 * result + (appid != null ? appid.hashCode() : 0);
        result = 31 * result + (prapid != null ? prapid.hashCode() : 0);
        result = 31 * result + (bpsnty != null ? bpsnty.hashCode() : 0);
        result = 31 * result + (bssnum != null ? bssnum.hashCode() : 0);
        result = 31 * result + (bdob != null ? bdob.hashCode() : 0);
        result = 31 * result + (bnamel != null ? bnamel.hashCode() : 0);
        result = 31 * result + (bnamef != null ? bnamef.hashCode() : 0);
        result = 31 * result + (bnamem != null ? bnamem.hashCode() : 0);
        result = 31 * result + endamt;
        result = 31 * result + (ocrdst != null ? ocrdst.hashCode() : 0);
        result = 31 * result + (crdcst != null ? crdcst.hashCode() : 0);
        result = 31 * result + (cractc != null ? cractc.hashCode() : 0);
        result = 31 * result + (crapls != null ? crapls.hashCode() : 0);
        result = 31 * result + (cddte != null ? cddte.hashCode() : 0);
        result = 31 * result + (cdexdt != null ? cdexdt.hashCode() : 0);
        result = 31 * result + (cdovri != null ? cdovri.hashCode() : 0);
        result = 31 * result + (alnamt != null ? alnamt.hashCode() : 0);
        result = 31 * result + (mxlnai != null ? mxlnai.hashCode() : 0);
        result = 31 * result + (aprqdt != null ? aprqdt.hashCode() : 0);
        result = 31 * result + (aprqtm != null ? aprqtm.hashCode() : 0);
        result = 31 * result + (awdsdt != null ? awdsdt.hashCode() : 0);
        result = 31 * result + (awdedt != null ? awdedt.hashCode() : 0);
        result = 31 * result + (defopt != null ? defopt.hashCode() : 0);
        result = 31 * result + (smthdo != null ? smthdo.hashCode() : 0);
        result = 31 * result + (scrbo != null ? scrbo.hashCode() : 0);
        result = 31 * result + (crbalo != null ? crbalo.hashCode() : 0);
        result = 31 * result + (appsr != null ? appsr.hashCode() : 0);
        result = 31 * result + (unlamt != null ? unlamt.hashCode() : 0);
        result = 31 * result + (reqsrc != null ? reqsrc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (lpstrm != null ? lpstrm.hashCode() : 0);
        result = 31 * result + (lpetrm != null ? lpetrm.hashCode() : 0);
        result = 31 * result + (aaidid != null ? aaidid.hashCode() : 0);
        result = 31 * result + (linkst != null ? linkst.hashCode() : 0);
        result = 31 * result + (syspdt != null ? syspdt.hashCode() : 0);
        result = 31 * result + (sysrcd != null ? sysrcd.hashCode() : 0);
        result = 31 * result + (camt1 != null ? camt1.hashCode() : 0);
        result = 31 * result + (camt2 != null ? camt2.hashCode() : 0);
        result = 31 * result + (camt3 != null ? camt3.hashCode() : 0);
        result = 31 * result + (camt4 != null ? camt4.hashCode() : 0);
        result = 31 * result + (cpct1 != null ? cpct1.hashCode() : 0);
        result = 31 * result + (cpct2 != null ? cpct2.hashCode() : 0);
        result = 31 * result + (cpct3 != null ? cpct3.hashCode() : 0);
        result = 31 * result + (cpct4 != null ? cpct4.hashCode() : 0);
        result = 31 * result + (cstat1 != null ? cstat1.hashCode() : 0);
        result = 31 * result + (cstat2 != null ? cstat2.hashCode() : 0);
        result = 31 * result + (cstat3 != null ? cstat3.hashCode() : 0);
        result = 31 * result + (cstat4 != null ? cstat4.hashCode() : 0);
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
        result = 31 * result + (usrnt1 != null ? usrnt1.hashCode() : 0);
        result = 31 * result + (usrnt2 != null ? usrnt2.hashCode() : 0);
        return result;
    }
}
