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
@javax.persistence.Table(name = "RTN", schema = "SIGMA", catalog = "")
@Entity
public class RtnEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getRtnkey();
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

    private String rtnkey;

    @javax.persistence.Column(name = "RTNKEY")
    @Id
    public String getRtnkey() {
        return rtnkey;
    }

    public void setRtnkey(String rtnkey) {
        this.rtnkey = rtnkey;
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

    private String wdrldt;

    @javax.persistence.Column(name = "WDRLDT")
    @Basic
    public String getWdrldt() {
        return wdrldt;
    }

    public void setWdrldt(String wdrldt) {
        this.wdrldt = wdrldt;
    }

    private String wdrltp;

    @javax.persistence.Column(name = "WDRLTP")
    @Basic
    public String getWdrltp() {
        return wdrltp;
    }

    public void setWdrltp(String wdrltp) {
        this.wdrltp = wdrltp;
    }

    private String detdte;

    @javax.persistence.Column(name = "DETDTE")
    @Basic
    public String getDetdte() {
        return detdte;
    }

    public void setDetdte(String detdte) {
        this.detdte = detdte;
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

    private String respby;

    @javax.persistence.Column(name = "RESPBY")
    @Basic
    public String getRespby() {
        return respby;
    }

    public void setRespby(String respby) {
        this.respby = respby;
    }

    private String icby;

    @javax.persistence.Column(name = "ICBY")
    @Basic
    public String getIcby() {
        return icby;
    }

    public void setIcby(String icby) {
        this.icby = icby;
    }

    private String icdte;

    @javax.persistence.Column(name = "ICDTE")
    @Basic
    public String getIcdte() {
        return icdte;
    }

    public void setIcdte(String icdte) {
        this.icdte = icdte;
    }

    private String calcby;

    @javax.persistence.Column(name = "CALCBY")
    @Basic
    public String getCalcby() {
        return calcby;
    }

    public void setCalcby(String calcby) {
        this.calcby = calcby;
    }

    private String calcdt;

    @javax.persistence.Column(name = "CALCDT")
    @Basic
    public String getCalcdt() {
        return calcdt;
    }

    public void setCalcdt(String calcdt) {
        this.calcdt = calcdt;
    }

    private String appvby;

    @javax.persistence.Column(name = "APPVBY")
    @Basic
    public String getAppvby() {
        return appvby;
    }

    public void setAppvby(String appvby) {
        this.appvby = appvby;
    }

    private String appvdt;

    @javax.persistence.Column(name = "APPVDT")
    @Basic
    public String getAppvdt() {
        return appvdt;
    }

    public void setAppvdt(String appvdt) {
        this.appvdt = appvdt;
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

    private String pwdby;

    @javax.persistence.Column(name = "PWDBY")
    @Basic
    public String getPwdby() {
        return pwdby;
    }

    public void setPwdby(String pwdby) {
        this.pwdby = pwdby;
    }

    private String disadt;

    @javax.persistence.Column(name = "DISADT")
    @Basic
    public String getDisadt() {
        return disadt;
    }

    public void setDisadt(String disadt) {
        this.disadt = disadt;
    }

    private String unittp;

    @javax.persistence.Column(name = "UNITTP")
    @Basic
    public String getUnittp() {
        return unittp;
    }

    public void setUnittp(String unittp) {
        this.unittp = unittp;
    }

    private String pdstrt;

    @javax.persistence.Column(name = "PDSTRT")
    @Basic
    public String getPdstrt() {
        return pdstrt;
    }

    public void setPdstrt(String pdstrt) {
        this.pdstrt = pdstrt;
    }

    private String pdend;

    @javax.persistence.Column(name = "PDEND")
    @Basic
    public String getPdend() {
        return pdend;
    }

    public void setPdend(String pdend) {
        this.pdend = pdend;
    }

    private String pdtype;

    @javax.persistence.Column(name = "PDTYPE")
    @Basic
    public String getPdtype() {
        return pdtype;
    }

    public void setPdtype(String pdtype) {
        this.pdtype = pdtype;
    }

    private int pdlen;

    @javax.persistence.Column(name = "PDLEN")
    @Basic
    public int getPdlen() {
        return pdlen;
    }

    public void setPdlen(int pdlen) {
        this.pdlen = pdlen;
    }

    private int pdschc;

    @javax.persistence.Column(name = "PDSCHC")
    @Basic
    public int getPdschc() {
        return pdschc;
    }

    public void setPdschc(int pdschc) {
        this.pdschc = pdschc;
    }

    private int pdbrk;

    @javax.persistence.Column(name = "PDBRK")
    @Basic
    public int getPdbrk() {
        return pdbrk;
    }

    public void setPdbrk(int pdbrk) {
        this.pdbrk = pdbrk;
    }

    private int pdloa;

    @javax.persistence.Column(name = "PDLOA")
    @Basic
    public int getPdloa() {
        return pdloa;
    }

    public void setPdloa(int pdloa) {
        this.pdloa = pdloa;
    }

    private int pdnln;

    @javax.persistence.Column(name = "PDNLN")
    @Basic
    public int getPdnln() {
        return pdnln;
    }

    public void setPdnln(int pdnln) {
        this.pdnln = pdnln;
    }

    private int pdnlno;

    @javax.persistence.Column(name = "PDNLNO")
    @Basic
    public int getPdnlno() {
        return pdnlno;
    }

    public void setPdnlno(int pdnlno) {
        this.pdnlno = pdnlno;
    }

    private int pdcmp;

    @javax.persistence.Column(name = "PDCMP")
    @Basic
    public int getPdcmp() {
        return pdcmp;
    }

    public void setPdcmp(int pdcmp) {
        this.pdcmp = pdcmp;
    }

    private BigDecimal pdcmpo;

    @javax.persistence.Column(name = "PDCMPO")
    @Basic
    public BigDecimal getPdcmpo() {
        return pdcmpo;
    }

    public void setPdcmpo(BigDecimal pdcmpo) {
        this.pdcmpo = pdcmpo;
    }

    private BigDecimal pdpcmp;

    @javax.persistence.Column(name = "PDPCMP")
    @Basic
    public BigDecimal getPdpcmp() {
        return pdpcmp;
    }

    public void setPdpcmp(BigDecimal pdpcmp) {
        this.pdpcmp = pdpcmp;
    }

    private BigDecimal pctern;

    @javax.persistence.Column(name = "PCTERN")
    @Basic
    public BigDecimal getPctern() {
        return pctern;
    }

    public void setPctern(BigDecimal pctern) {
        this.pctern = pctern;
    }

    private BigDecimal pctun;

    @javax.persistence.Column(name = "PCTUN")
    @Basic
    public BigDecimal getPctun() {
        return pctun;
    }

    public void setPctun(BigDecimal pctun) {
        this.pctun = pctun;
    }

    private BigDecimal disb;

    @javax.persistence.Column(name = "DISB")
    @Basic
    public BigDecimal getDisb() {
        return disb;
    }

    public void setDisb(BigDecimal disb) {
        this.disb = disb;
    }

    private BigDecimal chbdis;

    @javax.persistence.Column(name = "CHBDIS")
    @Basic
    public BigDecimal getChbdis() {
        return chbdis;
    }

    public void setChbdis(BigDecimal chbdis) {
        this.chbdis = chbdis;
    }

    private BigDecimal aidcon;

    @javax.persistence.Column(name = "AIDCON")
    @Basic
    public BigDecimal getAidcon() {
        return aidcon;
    }

    public void setAidcon(BigDecimal aidcon) {
        this.aidcon = aidcon;
    }

    private BigDecimal aidern;

    @javax.persistence.Column(name = "AIDERN")
    @Basic
    public BigDecimal getAidern() {
        return aidern;
    }

    public void setAidern(BigDecimal aidern) {
        this.aidern = aidern;
    }

    private BigDecimal aidun;

    @javax.persistence.Column(name = "AIDUN")
    @Basic
    public BigDecimal getAidun() {
        return aidun;
    }

    public void setAidun(BigDecimal aidun) {
        this.aidun = aidun;
    }

    private BigDecimal pwdtot;

    @javax.persistence.Column(name = "PWDTOT")
    @Basic
    public BigDecimal getPwdtot() {
        return pwdtot;
    }

    public void setPwdtot(BigDecimal pwdtot) {
        this.pwdtot = pwdtot;
    }

    private BigDecimal rtntot;

    @javax.persistence.Column(name = "RTNTOT")
    @Basic
    public BigDecimal getRtntot() {
        return rtntot;
    }

    public void setRtntot(BigDecimal rtntot) {
        this.rtntot = rtntot;
    }

    private BigDecimal icrg;

    @javax.persistence.Column(name = "ICRG")
    @Basic
    public BigDecimal getIcrg() {
        return icrg;
    }

    public void setIcrg(BigDecimal icrg) {
        this.icrg = icrg;
    }

    private BigDecimal icrgo;

    @javax.persistence.Column(name = "ICRGO")
    @Basic
    public BigDecimal getIcrgo() {
        return icrgo;
    }

    public void setIcrgo(BigDecimal icrgo) {
        this.icrgo = icrgo;
    }

    private BigDecimal icrgu;

    @javax.persistence.Column(name = "ICRGU")
    @Basic
    public BigDecimal getIcrgu() {
        return icrgu;
    }

    public void setIcrgu(BigDecimal icrgu) {
        this.icrgu = icrgu;
    }

    private BigDecimal icrguo;

    @javax.persistence.Column(name = "ICRGUO")
    @Basic
    public BigDecimal getIcrguo() {
        return icrguo;
    }

    public void setIcrguo(BigDecimal icrguo) {
        this.icrguo = icrguo;
    }

    private BigDecimal idue;

    @javax.persistence.Column(name = "IDUE")
    @Basic
    public BigDecimal getIdue() {
        return idue;
    }

    public void setIdue(BigDecimal idue) {
        this.idue = idue;
    }

    private BigDecimal sdue;

    @javax.persistence.Column(name = "SDUE")
    @Basic
    public BigDecimal getSdue() {
        return sdue;
    }

    public void setSdue(BigDecimal sdue) {
        this.sdue = sdue;
    }

    private BigDecimal pwoc;

    @javax.persistence.Column(name = "PWOC")
    @Basic
    public BigDecimal getPwoc() {
        return pwoc;
    }

    public void setPwoc(BigDecimal pwoc) {
        this.pwoc = pwoc;
    }

    private BigDecimal pwtfrb;

    @javax.persistence.Column(name = "PWTFRB")
    @Basic
    public BigDecimal getPwtfrb() {
        return pwtfrb;
    }

    public void setPwtfrb(BigDecimal pwtfrb) {
        this.pwtfrb = pwtfrb;
    }

    private BigDecimal pwo;

    @javax.persistence.Column(name = "PWO")
    @Basic
    public BigDecimal getPwo() {
        return pwo;
    }

    public void setPwo(BigDecimal pwo) {
        this.pwo = pwo;
    }

    private String pwoby;

    @javax.persistence.Column(name = "PWOBY")
    @Basic
    public String getPwoby() {
        return pwoby;
    }

    public void setPwoby(String pwoby) {
        this.pwoby = pwoby;
    }

    private String pwodte;

    @javax.persistence.Column(name = "PWODTE")
    @Basic
    public String getPwodte() {
        return pwodte;
    }

    public void setPwodte(String pwodte) {
        this.pwodte = pwodte;
    }

    private BigDecimal pwp;

    @javax.persistence.Column(name = "PWP")
    @Basic
    public BigDecimal getPwp() {
        return pwp;
    }

    public void setPwp(BigDecimal pwp) {
        this.pwp = pwp;
    }

    private String pwpby;

    @javax.persistence.Column(name = "PWPBY")
    @Basic
    public String getPwpby() {
        return pwpby;
    }

    public void setPwpby(String pwpby) {
        this.pwpby = pwpby;
    }

    private String pwpdte;

    @javax.persistence.Column(name = "PWPDTE")
    @Basic
    public String getPwpdte() {
        return pwpdte;
    }

    public void setPwpdte(String pwpdte) {
        this.pwpdte = pwpdte;
    }

    private BigDecimal pwcr;

    @javax.persistence.Column(name = "PWCR")
    @Basic
    public BigDecimal getPwcr() {
        return pwcr;
    }

    public void setPwcr(BigDecimal pwcr) {
        this.pwcr = pwcr;
    }

    private String pwcrd;

    @javax.persistence.Column(name = "PWCRD")
    @Basic
    public String getPwcrd() {
        return pwcrd;
    }

    public void setPwcrd(String pwcrd) {
        this.pwcrd = pwcrd;
    }

    private BigDecimal pwrfed;

    @javax.persistence.Column(name = "PWRFED")
    @Basic
    public BigDecimal getPwrfed() {
        return pwrfed;
    }

    public void setPwrfed(BigDecimal pwrfed) {
        this.pwrfed = pwrfed;
    }

    private BigDecimal pwrfa;

    @javax.persistence.Column(name = "PWRFA")
    @Basic
    public BigDecimal getPwrfa() {
        return pwrfa;
    }

    public void setPwrfa(BigDecimal pwrfa) {
        this.pwrfa = pwrfa;
    }

    private String pwrfd;

    @javax.persistence.Column(name = "PWRFD")
    @Basic
    public String getPwrfd() {
        return pwrfd;
    }

    public void setPwrfd(String pwrfd) {
        this.pwrfd = pwrfd;
    }

    private String pwnotd;

    @javax.persistence.Column(name = "PWNOTD")
    @Basic
    public String getPwnotd() {
        return pwnotd;
    }

    public void setPwnotd(String pwnotd) {
        this.pwnotd = pwnotd;
    }

    private String pwrspd;

    @javax.persistence.Column(name = "PWRSPD")
    @Basic
    public String getPwrspd() {
        return pwrspd;
    }

    public void setPwrspd(String pwrspd) {
        this.pwrspd = pwrspd;
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

    private BigDecimal govrpm;

    @javax.persistence.Column(name = "GOVRPM")
    @Basic
    public BigDecimal getGovrpm() {
        return govrpm;
    }

    public void setGovrpm(BigDecimal govrpm) {
        this.govrpm = govrpm;
    }

    private BigDecimal lovrpm;

    @javax.persistence.Column(name = "LOVRPM")
    @Basic
    public BigDecimal getLovrpm() {
        return lovrpm;
    }

    public void setLovrpm(BigDecimal lovrpm) {
        this.lovrpm = lovrpm;
    }

    private String capvby;

    @javax.persistence.Column(name = "CAPVBY")
    @Basic
    public String getCapvby() {
        return capvby;
    }

    public void setCapvby(String capvby) {
        this.capvby = capvby;
    }

    private String capvdt;

    @javax.persistence.Column(name = "CAPVDT")
    @Basic
    public String getCapvdt() {
        return capvdt;
    }

    public void setCapvdt(String capvdt) {
        this.capvdt = capvdt;
    }

    private BigDecimal slnbal;

    @javax.persistence.Column(name = "SLNBAL")
    @Basic
    public BigDecimal getSlnbal() {
        return slnbal;
    }

    public void setSlnbal(BigDecimal slnbal) {
        this.slnbal = slnbal;
    }

    private String rnotdt;

    @javax.persistence.Column(name = "RNOTDT")
    @Basic
    public String getRnotdt() {
        return rnotdt;
    }

    public void setRnotdt(String rnotdt) {
        this.rnotdt = rnotdt;
    }

    private String pwdsap;

    @javax.persistence.Column(name = "PWDSAP")
    @Basic
    public String getPwdsap() {
        return pwdsap;
    }

    public void setPwdsap(String pwdsap) {
        this.pwdsap = pwdsap;
    }

    private String pwdpap;

    @javax.persistence.Column(name = "PWDPAP")
    @Basic
    public String getPwdpap() {
        return pwdpap;
    }

    public void setPwdpap(String pwdpap) {
        this.pwdpap = pwdpap;
    }

    private String pwdrdd;

    @javax.persistence.Column(name = "PWDRDD")
    @Basic
    public String getPwdrdd() {
        return pwdrdd;
    }

    public void setPwdrdd(String pwdrdd) {
        this.pwdrdd = pwdrdd;
    }

    private BigDecimal pwrpls;

    @javax.persistence.Column(name = "PWRPLS")
    @Basic
    public BigDecimal getPwrpls() {
        return pwrpls;
    }

    public void setPwrpls(BigDecimal pwrpls) {
        this.pwrpls = pwrpls;
    }

    private BigDecimal pwrgnt;

    @javax.persistence.Column(name = "PWRGNT")
    @Basic
    public BigDecimal getPwrgnt() {
        return pwrgnt;
    }

    public void setPwrgnt(BigDecimal pwrgnt) {
        this.pwrgnt = pwrgnt;
    }

    private String m1Lcdd;

    @javax.persistence.Column(name = "M1LCDD")
    @Basic
    public String getM1Lcdd() {
        return m1Lcdd;
    }

    public void setM1Lcdd(String m1Lcdd) {
        this.m1Lcdd = m1Lcdd;
    }

    private String m1Lda;

    @javax.persistence.Column(name = "M1LDA")
    @Basic
    public String getM1Lda() {
        return m1Lda;
    }

    public void setM1Lda(String m1Lda) {
        this.m1Lda = m1Lda;
    }

    private String m1Wird;

    @javax.persistence.Column(name = "M1WIRD")
    @Basic
    public String getM1Wird() {
        return m1Wird;
    }

    public void setM1Wird(String m1Wird) {
        this.m1Wird = m1Wird;
    }

    private String m1Sond;

    @javax.persistence.Column(name = "M1SOND")
    @Basic
    public String getM1Sond() {
        return m1Sond;
    }

    public void setM1Sond(String m1Sond) {
        this.m1Sond = m1Sond;
    }

    private String m2Lcdd;

    @javax.persistence.Column(name = "M2LCDD")
    @Basic
    public String getM2Lcdd() {
        return m2Lcdd;
    }

    public void setM2Lcdd(String m2Lcdd) {
        this.m2Lcdd = m2Lcdd;
    }

    private String m2Lda;

    @javax.persistence.Column(name = "M2LDA")
    @Basic
    public String getM2Lda() {
        return m2Lda;
    }

    public void setM2Lda(String m2Lda) {
        this.m2Lda = m2Lda;
    }

    private String m2Wird;

    @javax.persistence.Column(name = "M2WIRD")
    @Basic
    public String getM2Wird() {
        return m2Wird;
    }

    public void setM2Wird(String m2Wird) {
        this.m2Wird = m2Wird;
    }

    private String m2Sond;

    @javax.persistence.Column(name = "M2SOND")
    @Basic
    public String getM2Sond() {
        return m2Sond;
    }

    public void setM2Sond(String m2Sond) {
        this.m2Sond = m2Sond;
    }

    private String m1Dcmp;

    @javax.persistence.Column(name = "M1DCMP")
    @Basic
    public String getM1Dcmp() {
        return m1Dcmp;
    }

    public void setM1Dcmp(String m1Dcmp) {
        this.m1Dcmp = m1Dcmp;
    }

    private String m2Dcmp;

    @javax.persistence.Column(name = "M2DCMP")
    @Basic
    public String getM2Dcmp() {
        return m2Dcmp;
    }

    public void setM2Dcmp(String m2Dcmp) {
        this.m2Dcmp = m2Dcmp;
    }

    private String awdcby;

    @javax.persistence.Column(name = "AWDCBY")
    @Basic
    public String getAwdcby() {
        return awdcby;
    }

    public void setAwdcby(String awdcby) {
        this.awdcby = awdcby;
    }

    private String acalcd;

    @javax.persistence.Column(name = "ACALCD")
    @Basic
    public String getAcalcd() {
        return acalcd;
    }

    public void setAcalcd(String acalcd) {
        this.acalcd = acalcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RtnEntity rtnEntity = (RtnEntity) o;

        if (pdbrk != rtnEntity.pdbrk) return false;
        if (pdcmp != rtnEntity.pdcmp) return false;
        if (pdlen != rtnEntity.pdlen) return false;
        if (pdloa != rtnEntity.pdloa) return false;
        if (pdnln != rtnEntity.pdnln) return false;
        if (pdnlno != rtnEntity.pdnlno) return false;
        if (pdschc != rtnEntity.pdschc) return false;
        if (revlev != rtnEntity.revlev) return false;
        if (acalcd != null ? !acalcd.equals(rtnEntity.acalcd) : rtnEntity.acalcd != null) return false;
        if (aidcon != null ? !aidcon.equals(rtnEntity.aidcon) : rtnEntity.aidcon != null) return false;
        if (aidern != null ? !aidern.equals(rtnEntity.aidern) : rtnEntity.aidern != null) return false;
        if (aidun != null ? !aidun.equals(rtnEntity.aidun) : rtnEntity.aidun != null) return false;
        if (aidyr != null ? !aidyr.equals(rtnEntity.aidyr) : rtnEntity.aidyr != null) return false;
        if (appvby != null ? !appvby.equals(rtnEntity.appvby) : rtnEntity.appvby != null) return false;
        if (appvdt != null ? !appvdt.equals(rtnEntity.appvdt) : rtnEntity.appvdt != null) return false;
        if (awdcby != null ? !awdcby.equals(rtnEntity.awdcby) : rtnEntity.awdcby != null) return false;
        if (calcby != null ? !calcby.equals(rtnEntity.calcby) : rtnEntity.calcby != null) return false;
        if (calcdt != null ? !calcdt.equals(rtnEntity.calcdt) : rtnEntity.calcdt != null) return false;
        if (camt1 != null ? !camt1.equals(rtnEntity.camt1) : rtnEntity.camt1 != null) return false;
        if (camt2 != null ? !camt2.equals(rtnEntity.camt2) : rtnEntity.camt2 != null) return false;
        if (camt3 != null ? !camt3.equals(rtnEntity.camt3) : rtnEntity.camt3 != null) return false;
        if (camt4 != null ? !camt4.equals(rtnEntity.camt4) : rtnEntity.camt4 != null) return false;
        if (capvby != null ? !capvby.equals(rtnEntity.capvby) : rtnEntity.capvby != null) return false;
        if (capvdt != null ? !capvdt.equals(rtnEntity.capvdt) : rtnEntity.capvdt != null) return false;
        if (chbdis != null ? !chbdis.equals(rtnEntity.chbdis) : rtnEntity.chbdis != null) return false;
        if (cpct1 != null ? !cpct1.equals(rtnEntity.cpct1) : rtnEntity.cpct1 != null) return false;
        if (cpct2 != null ? !cpct2.equals(rtnEntity.cpct2) : rtnEntity.cpct2 != null) return false;
        if (cpct3 != null ? !cpct3.equals(rtnEntity.cpct3) : rtnEntity.cpct3 != null) return false;
        if (cpct4 != null ? !cpct4.equals(rtnEntity.cpct4) : rtnEntity.cpct4 != null) return false;
        if (crtdte != null ? !crtdte.equals(rtnEntity.crtdte) : rtnEntity.crtdte != null) return false;
        if (crtmod != null ? !crtmod.equals(rtnEntity.crtmod) : rtnEntity.crtmod != null) return false;
        if (crttme != null ? !crttme.equals(rtnEntity.crttme) : rtnEntity.crttme != null) return false;
        if (crtusr != null ? !crtusr.equals(rtnEntity.crtusr) : rtnEntity.crtusr != null) return false;
        if (cstat1 != null ? !cstat1.equals(rtnEntity.cstat1) : rtnEntity.cstat1 != null) return false;
        if (cstat2 != null ? !cstat2.equals(rtnEntity.cstat2) : rtnEntity.cstat2 != null) return false;
        if (cstat3 != null ? !cstat3.equals(rtnEntity.cstat3) : rtnEntity.cstat3 != null) return false;
        if (cstat4 != null ? !cstat4.equals(rtnEntity.cstat4) : rtnEntity.cstat4 != null) return false;
        if (detdte != null ? !detdte.equals(rtnEntity.detdte) : rtnEntity.detdte != null) return false;
        if (disadt != null ? !disadt.equals(rtnEntity.disadt) : rtnEntity.disadt != null) return false;
        if (disb != null ? !disb.equals(rtnEntity.disb) : rtnEntity.disb != null) return false;
        if (enrlev != null ? !enrlev.equals(rtnEntity.enrlev) : rtnEntity.enrlev != null) return false;
        if (govrpm != null ? !govrpm.equals(rtnEntity.govrpm) : rtnEntity.govrpm != null) return false;
        if (hold != null ? !hold.equals(rtnEntity.hold) : rtnEntity.hold != null) return false;
        if (holdby != null ? !holdby.equals(rtnEntity.holdby) : rtnEntity.holdby != null) return false;
        if (icby != null ? !icby.equals(rtnEntity.icby) : rtnEntity.icby != null) return false;
        if (icdte != null ? !icdte.equals(rtnEntity.icdte) : rtnEntity.icdte != null) return false;
        if (icrg != null ? !icrg.equals(rtnEntity.icrg) : rtnEntity.icrg != null) return false;
        if (icrgo != null ? !icrgo.equals(rtnEntity.icrgo) : rtnEntity.icrgo != null) return false;
        if (icrgu != null ? !icrgu.equals(rtnEntity.icrgu) : rtnEntity.icrgu != null) return false;
        if (icrguo != null ? !icrguo.equals(rtnEntity.icrguo) : rtnEntity.icrguo != null) return false;
        if (idue != null ? !idue.equals(rtnEntity.idue) : rtnEntity.idue != null) return false;
        if (lovrpm != null ? !lovrpm.equals(rtnEntity.lovrpm) : rtnEntity.lovrpm != null) return false;
        if (m1Dcmp != null ? !m1Dcmp.equals(rtnEntity.m1Dcmp) : rtnEntity.m1Dcmp != null) return false;
        if (m1Lcdd != null ? !m1Lcdd.equals(rtnEntity.m1Lcdd) : rtnEntity.m1Lcdd != null) return false;
        if (m1Lda != null ? !m1Lda.equals(rtnEntity.m1Lda) : rtnEntity.m1Lda != null) return false;
        if (m1Sond != null ? !m1Sond.equals(rtnEntity.m1Sond) : rtnEntity.m1Sond != null) return false;
        if (m1Wird != null ? !m1Wird.equals(rtnEntity.m1Wird) : rtnEntity.m1Wird != null) return false;
        if (m2Dcmp != null ? !m2Dcmp.equals(rtnEntity.m2Dcmp) : rtnEntity.m2Dcmp != null) return false;
        if (m2Lcdd != null ? !m2Lcdd.equals(rtnEntity.m2Lcdd) : rtnEntity.m2Lcdd != null) return false;
        if (m2Lda != null ? !m2Lda.equals(rtnEntity.m2Lda) : rtnEntity.m2Lda != null) return false;
        if (m2Sond != null ? !m2Sond.equals(rtnEntity.m2Sond) : rtnEntity.m2Sond != null) return false;
        if (m2Wird != null ? !m2Wird.equals(rtnEntity.m2Wird) : rtnEntity.m2Wird != null) return false;
        if (pctern != null ? !pctern.equals(rtnEntity.pctern) : rtnEntity.pctern != null) return false;
        if (pctun != null ? !pctun.equals(rtnEntity.pctun) : rtnEntity.pctun != null) return false;
        if (pdcmpo != null ? !pdcmpo.equals(rtnEntity.pdcmpo) : rtnEntity.pdcmpo != null) return false;
        if (pdend != null ? !pdend.equals(rtnEntity.pdend) : rtnEntity.pdend != null) return false;
        if (pdpcmp != null ? !pdpcmp.equals(rtnEntity.pdpcmp) : rtnEntity.pdpcmp != null) return false;
        if (pdstrt != null ? !pdstrt.equals(rtnEntity.pdstrt) : rtnEntity.pdstrt != null) return false;
        if (pdtype != null ? !pdtype.equals(rtnEntity.pdtype) : rtnEntity.pdtype != null) return false;
        if (pwcr != null ? !pwcr.equals(rtnEntity.pwcr) : rtnEntity.pwcr != null) return false;
        if (pwcrd != null ? !pwcrd.equals(rtnEntity.pwcrd) : rtnEntity.pwcrd != null) return false;
        if (pwdby != null ? !pwdby.equals(rtnEntity.pwdby) : rtnEntity.pwdby != null) return false;
        if (pwdpap != null ? !pwdpap.equals(rtnEntity.pwdpap) : rtnEntity.pwdpap != null) return false;
        if (pwdrdd != null ? !pwdrdd.equals(rtnEntity.pwdrdd) : rtnEntity.pwdrdd != null) return false;
        if (pwdreq != null ? !pwdreq.equals(rtnEntity.pwdreq) : rtnEntity.pwdreq != null) return false;
        if (pwdsap != null ? !pwdsap.equals(rtnEntity.pwdsap) : rtnEntity.pwdsap != null) return false;
        if (pwdtot != null ? !pwdtot.equals(rtnEntity.pwdtot) : rtnEntity.pwdtot != null) return false;
        if (pwnotd != null ? !pwnotd.equals(rtnEntity.pwnotd) : rtnEntity.pwnotd != null) return false;
        if (pwo != null ? !pwo.equals(rtnEntity.pwo) : rtnEntity.pwo != null) return false;
        if (pwoby != null ? !pwoby.equals(rtnEntity.pwoby) : rtnEntity.pwoby != null) return false;
        if (pwoc != null ? !pwoc.equals(rtnEntity.pwoc) : rtnEntity.pwoc != null) return false;
        if (pwodte != null ? !pwodte.equals(rtnEntity.pwodte) : rtnEntity.pwodte != null) return false;
        if (pwp != null ? !pwp.equals(rtnEntity.pwp) : rtnEntity.pwp != null) return false;
        if (pwpby != null ? !pwpby.equals(rtnEntity.pwpby) : rtnEntity.pwpby != null) return false;
        if (pwpdte != null ? !pwpdte.equals(rtnEntity.pwpdte) : rtnEntity.pwpdte != null) return false;
        if (pwrfa != null ? !pwrfa.equals(rtnEntity.pwrfa) : rtnEntity.pwrfa != null) return false;
        if (pwrfd != null ? !pwrfd.equals(rtnEntity.pwrfd) : rtnEntity.pwrfd != null) return false;
        if (pwrfed != null ? !pwrfed.equals(rtnEntity.pwrfed) : rtnEntity.pwrfed != null) return false;
        if (pwrgnt != null ? !pwrgnt.equals(rtnEntity.pwrgnt) : rtnEntity.pwrgnt != null) return false;
        if (pwrpls != null ? !pwrpls.equals(rtnEntity.pwrpls) : rtnEntity.pwrpls != null) return false;
        if (pwrspd != null ? !pwrspd.equals(rtnEntity.pwrspd) : rtnEntity.pwrspd != null) return false;
        if (pwtfrb != null ? !pwtfrb.equals(rtnEntity.pwtfrb) : rtnEntity.pwtfrb != null) return false;
        if (recstat != null ? !recstat.equals(rtnEntity.recstat) : rtnEntity.recstat != null) return false;
        if (respby != null ? !respby.equals(rtnEntity.respby) : rtnEntity.respby != null) return false;
        if (revdte != null ? !revdte.equals(rtnEntity.revdte) : rtnEntity.revdte != null) return false;
        if (revmod != null ? !revmod.equals(rtnEntity.revmod) : rtnEntity.revmod != null) return false;
        if (revtme != null ? !revtme.equals(rtnEntity.revtme) : rtnEntity.revtme != null) return false;
        if (revusr != null ? !revusr.equals(rtnEntity.revusr) : rtnEntity.revusr != null) return false;
        if (rnotdt != null ? !rnotdt.equals(rtnEntity.rnotdt) : rtnEntity.rnotdt != null) return false;
        if (rtnkey != null ? !rtnkey.equals(rtnEntity.rtnkey) : rtnEntity.rtnkey != null) return false;
        if (rtntot != null ? !rtntot.equals(rtnEntity.rtntot) : rtnEntity.rtntot != null) return false;
        if (sdue != null ? !sdue.equals(rtnEntity.sdue) : rtnEntity.sdue != null) return false;
        if (sid != null ? !sid.equals(rtnEntity.sid) : rtnEntity.sid != null) return false;
        if (slnbal != null ? !slnbal.equals(rtnEntity.slnbal) : rtnEntity.slnbal != null) return false;
        if (status != null ? !status.equals(rtnEntity.status) : rtnEntity.status != null) return false;
        if (term != null ? !term.equals(rtnEntity.term) : rtnEntity.term != null) return false;
        if (ucode != null ? !ucode.equals(rtnEntity.ucode) : rtnEntity.ucode != null) return false;
        if (unittp != null ? !unittp.equals(rtnEntity.unittp) : rtnEntity.unittp != null) return false;
        if (usrcd1 != null ? !usrcd1.equals(rtnEntity.usrcd1) : rtnEntity.usrcd1 != null) return false;
        if (usrcd2 != null ? !usrcd2.equals(rtnEntity.usrcd2) : rtnEntity.usrcd2 != null) return false;
        if (usrcd3 != null ? !usrcd3.equals(rtnEntity.usrcd3) : rtnEntity.usrcd3 != null) return false;
        if (usrcd4 != null ? !usrcd4.equals(rtnEntity.usrcd4) : rtnEntity.usrcd4 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(rtnEntity.usrdt1) : rtnEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(rtnEntity.usrdt2) : rtnEntity.usrdt2 != null) return false;
        if (usrdt3 != null ? !usrdt3.equals(rtnEntity.usrdt3) : rtnEntity.usrdt3 != null) return false;
        if (usrdt4 != null ? !usrdt4.equals(rtnEntity.usrdt4) : rtnEntity.usrdt4 != null) return false;
        if (usrnr1 != null ? !usrnr1.equals(rtnEntity.usrnr1) : rtnEntity.usrnr1 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(rtnEntity.usrnr2) : rtnEntity.usrnr2 != null) return false;
        if (usrnr3 != null ? !usrnr3.equals(rtnEntity.usrnr3) : rtnEntity.usrnr3 != null) return false;
        if (usrnr4 != null ? !usrnr4.equals(rtnEntity.usrnr4) : rtnEntity.usrnr4 != null) return false;
        if (usrnr5 != null ? !usrnr5.equals(rtnEntity.usrnr5) : rtnEntity.usrnr5 != null) return false;
        if (usrnt1 != null ? !usrnt1.equals(rtnEntity.usrnt1) : rtnEntity.usrnt1 != null) return false;
        if (usrnt2 != null ? !usrnt2.equals(rtnEntity.usrnt2) : rtnEntity.usrnt2 != null) return false;
        if (wdrldt != null ? !wdrldt.equals(rtnEntity.wdrldt) : rtnEntity.wdrldt != null) return false;
        if (wdrltp != null ? !wdrltp.equals(rtnEntity.wdrltp) : rtnEntity.wdrltp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (rtnkey != null ? rtnkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
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
        result = 31 * result + (wdrldt != null ? wdrldt.hashCode() : 0);
        result = 31 * result + (wdrltp != null ? wdrltp.hashCode() : 0);
        result = 31 * result + (detdte != null ? detdte.hashCode() : 0);
        result = 31 * result + (enrlev != null ? enrlev.hashCode() : 0);
        result = 31 * result + (respby != null ? respby.hashCode() : 0);
        result = 31 * result + (icby != null ? icby.hashCode() : 0);
        result = 31 * result + (icdte != null ? icdte.hashCode() : 0);
        result = 31 * result + (calcby != null ? calcby.hashCode() : 0);
        result = 31 * result + (calcdt != null ? calcdt.hashCode() : 0);
        result = 31 * result + (appvby != null ? appvby.hashCode() : 0);
        result = 31 * result + (appvdt != null ? appvdt.hashCode() : 0);
        result = 31 * result + (pwdreq != null ? pwdreq.hashCode() : 0);
        result = 31 * result + (pwdby != null ? pwdby.hashCode() : 0);
        result = 31 * result + (disadt != null ? disadt.hashCode() : 0);
        result = 31 * result + (unittp != null ? unittp.hashCode() : 0);
        result = 31 * result + (pdstrt != null ? pdstrt.hashCode() : 0);
        result = 31 * result + (pdend != null ? pdend.hashCode() : 0);
        result = 31 * result + (pdtype != null ? pdtype.hashCode() : 0);
        result = 31 * result + pdlen;
        result = 31 * result + pdschc;
        result = 31 * result + pdbrk;
        result = 31 * result + pdloa;
        result = 31 * result + pdnln;
        result = 31 * result + pdnlno;
        result = 31 * result + pdcmp;
        result = 31 * result + (pdcmpo != null ? pdcmpo.hashCode() : 0);
        result = 31 * result + (pdpcmp != null ? pdpcmp.hashCode() : 0);
        result = 31 * result + (pctern != null ? pctern.hashCode() : 0);
        result = 31 * result + (pctun != null ? pctun.hashCode() : 0);
        result = 31 * result + (disb != null ? disb.hashCode() : 0);
        result = 31 * result + (chbdis != null ? chbdis.hashCode() : 0);
        result = 31 * result + (aidcon != null ? aidcon.hashCode() : 0);
        result = 31 * result + (aidern != null ? aidern.hashCode() : 0);
        result = 31 * result + (aidun != null ? aidun.hashCode() : 0);
        result = 31 * result + (pwdtot != null ? pwdtot.hashCode() : 0);
        result = 31 * result + (rtntot != null ? rtntot.hashCode() : 0);
        result = 31 * result + (icrg != null ? icrg.hashCode() : 0);
        result = 31 * result + (icrgo != null ? icrgo.hashCode() : 0);
        result = 31 * result + (icrgu != null ? icrgu.hashCode() : 0);
        result = 31 * result + (icrguo != null ? icrguo.hashCode() : 0);
        result = 31 * result + (idue != null ? idue.hashCode() : 0);
        result = 31 * result + (sdue != null ? sdue.hashCode() : 0);
        result = 31 * result + (pwoc != null ? pwoc.hashCode() : 0);
        result = 31 * result + (pwtfrb != null ? pwtfrb.hashCode() : 0);
        result = 31 * result + (pwo != null ? pwo.hashCode() : 0);
        result = 31 * result + (pwoby != null ? pwoby.hashCode() : 0);
        result = 31 * result + (pwodte != null ? pwodte.hashCode() : 0);
        result = 31 * result + (pwp != null ? pwp.hashCode() : 0);
        result = 31 * result + (pwpby != null ? pwpby.hashCode() : 0);
        result = 31 * result + (pwpdte != null ? pwpdte.hashCode() : 0);
        result = 31 * result + (pwcr != null ? pwcr.hashCode() : 0);
        result = 31 * result + (pwcrd != null ? pwcrd.hashCode() : 0);
        result = 31 * result + (pwrfed != null ? pwrfed.hashCode() : 0);
        result = 31 * result + (pwrfa != null ? pwrfa.hashCode() : 0);
        result = 31 * result + (pwrfd != null ? pwrfd.hashCode() : 0);
        result = 31 * result + (pwnotd != null ? pwnotd.hashCode() : 0);
        result = 31 * result + (pwrspd != null ? pwrspd.hashCode() : 0);
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
        result = 31 * result + (govrpm != null ? govrpm.hashCode() : 0);
        result = 31 * result + (lovrpm != null ? lovrpm.hashCode() : 0);
        result = 31 * result + (capvby != null ? capvby.hashCode() : 0);
        result = 31 * result + (capvdt != null ? capvdt.hashCode() : 0);
        result = 31 * result + (slnbal != null ? slnbal.hashCode() : 0);
        result = 31 * result + (rnotdt != null ? rnotdt.hashCode() : 0);
        result = 31 * result + (pwdsap != null ? pwdsap.hashCode() : 0);
        result = 31 * result + (pwdpap != null ? pwdpap.hashCode() : 0);
        result = 31 * result + (pwdrdd != null ? pwdrdd.hashCode() : 0);
        result = 31 * result + (pwrpls != null ? pwrpls.hashCode() : 0);
        result = 31 * result + (pwrgnt != null ? pwrgnt.hashCode() : 0);
        result = 31 * result + (m1Lcdd != null ? m1Lcdd.hashCode() : 0);
        result = 31 * result + (m1Lda != null ? m1Lda.hashCode() : 0);
        result = 31 * result + (m1Wird != null ? m1Wird.hashCode() : 0);
        result = 31 * result + (m1Sond != null ? m1Sond.hashCode() : 0);
        result = 31 * result + (m2Lcdd != null ? m2Lcdd.hashCode() : 0);
        result = 31 * result + (m2Lda != null ? m2Lda.hashCode() : 0);
        result = 31 * result + (m2Wird != null ? m2Wird.hashCode() : 0);
        result = 31 * result + (m2Sond != null ? m2Sond.hashCode() : 0);
        result = 31 * result + (m1Dcmp != null ? m1Dcmp.hashCode() : 0);
        result = 31 * result + (m2Dcmp != null ? m2Dcmp.hashCode() : 0);
        result = 31 * result + (awdcby != null ? awdcby.hashCode() : 0);
        result = 31 * result + (acalcd != null ? acalcd.hashCode() : 0);
        return result;
    }
}
