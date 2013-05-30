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
@javax.persistence.Table(name = "PSN", schema = "SIGMA", catalog = "")
@Entity
public class PsnEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getPsnkey();
    }

    private String psnkey;

    @javax.persistence.Column(name = "PSNKEY")
    @Id
    public String getPsnkey() {
        return psnkey;
    }

    public void setPsnkey(String psnkey) {
        this.psnkey = psnkey;
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

    private String addrsd;

    @javax.persistence.Column(name = "ADDRSD")
    @Basic
    public String getAddrsd() {
        return addrsd;
    }

    public void setAddrsd(String addrsd) {
        this.addrsd = addrsd;
    }

    private String phonsd;

    @javax.persistence.Column(name = "PHONSD")
    @Basic
    public String getPhonsd() {
        return phonsd;
    }

    public void setPhonsd(String phonsd) {
        this.phonsd = phonsd;
    }

    private String emalsd;

    @javax.persistence.Column(name = "EMALSD")
    @Basic
    public String getEmalsd() {
        return emalsd;
    }

    public void setEmalsd(String emalsd) {
        this.emalsd = emalsd;
    }

    private String ssnum;

    @javax.persistence.Column(name = "SSNUM")
    @Basic
    public String getSsnum() {
        return ssnum;
    }

    public void setSsnum(String ssnum) {
        this.ssnum = ssnum;
    }

    private String namel;

    @javax.persistence.Column(name = "NAMEL")
    @Basic
    public String getNamel() {
        return namel;
    }

    public void setNamel(String namel) {
        this.namel = namel;
    }

    private String namef;

    @javax.persistence.Column(name = "NAMEF")
    @Basic
    public String getNamef() {
        return namef;
    }

    public void setNamef(String namef) {
        this.namef = namef;
    }

    private String namem;

    @javax.persistence.Column(name = "NAMEM")
    @Basic
    public String getNamem() {
        return namem;
    }

    public void setNamem(String namem) {
        this.namem = namem;
    }

    private String dlst;

    @javax.persistence.Column(name = "DLST")
    @Basic
    public String getDlst() {
        return dlst;
    }

    public void setDlst(String dlst) {
        this.dlst = dlst;
    }

    private String dlnum;

    @javax.persistence.Column(name = "DLNUM")
    @Basic
    public String getDlnum() {
        return dlnum;
    }

    public void setDlnum(String dlnum) {
        this.dlnum = dlnum;
    }

    private String dob;

    @javax.persistence.Column(name = "DOB")
    @Basic
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    private String ctzns;

    @javax.persistence.Column(name = "CTZNS")
    @Basic
    public String getCtzns() {
        return ctzns;
    }

    public void setCtzns(String ctzns) {
        this.ctzns = ctzns;
    }

    private String ssnumr;

    @javax.persistence.Column(name = "SSNUMR")
    @Basic
    public String getSsnumr() {
        return ssnumr;
    }

    public void setSsnumr(String ssnumr) {
        this.ssnumr = ssnumr;
    }

    private String namelr;

    @javax.persistence.Column(name = "NAMELR")
    @Basic
    public String getNamelr() {
        return namelr;
    }

    public void setNamelr(String namelr) {
        this.namelr = namelr;
    }

    private String namefr;

    @javax.persistence.Column(name = "NAMEFR")
    @Basic
    public String getNamefr() {
        return namefr;
    }

    public void setNamefr(String namefr) {
        this.namefr = namefr;
    }

    private String namemr;

    @javax.persistence.Column(name = "NAMEMR")
    @Basic
    public String getNamemr() {
        return namemr;
    }

    public void setNamemr(String namemr) {
        this.namemr = namemr;
    }

    private String dlstr;

    @javax.persistence.Column(name = "DLSTR")
    @Basic
    public String getDlstr() {
        return dlstr;
    }

    public void setDlstr(String dlstr) {
        this.dlstr = dlstr;
    }

    private String dlnumr;

    @javax.persistence.Column(name = "DLNUMR")
    @Basic
    public String getDlnumr() {
        return dlnumr;
    }

    public void setDlnumr(String dlnumr) {
        this.dlnumr = dlnumr;
    }

    private String dobr;

    @javax.persistence.Column(name = "DOBR")
    @Basic
    public String getDobr() {
        return dobr;
    }

    public void setDobr(String dobr) {
        this.dobr = dobr;
    }

    private String ctznsc;

    @javax.persistence.Column(name = "CTZNSC")
    @Basic
    public String getCtznsc() {
        return ctznsc;
    }

    public void setCtznsc(String ctznsc) {
        this.ctznsc = ctznsc;
    }

    private String ssnumc;

    @javax.persistence.Column(name = "SSNUMC")
    @Basic
    public String getSsnumc() {
        return ssnumc;
    }

    public void setSsnumc(String ssnumc) {
        this.ssnumc = ssnumc;
    }

    private String namelc;

    @javax.persistence.Column(name = "NAMELC")
    @Basic
    public String getNamelc() {
        return namelc;
    }

    public void setNamelc(String namelc) {
        this.namelc = namelc;
    }

    private String namefc;

    @javax.persistence.Column(name = "NAMEFC")
    @Basic
    public String getNamefc() {
        return namefc;
    }

    public void setNamefc(String namefc) {
        this.namefc = namefc;
    }

    private String namemc;

    @javax.persistence.Column(name = "NAMEMC")
    @Basic
    public String getNamemc() {
        return namemc;
    }

    public void setNamemc(String namemc) {
        this.namemc = namemc;
    }

    private String dlstc;

    @javax.persistence.Column(name = "DLSTC")
    @Basic
    public String getDlstc() {
        return dlstc;
    }

    public void setDlstc(String dlstc) {
        this.dlstc = dlstc;
    }

    private String dlnumc;

    @javax.persistence.Column(name = "DLNUMC")
    @Basic
    public String getDlnumc() {
        return dlnumc;
    }

    public void setDlnumc(String dlnumc) {
        this.dlnumc = dlnumc;
    }

    private String dobc;

    @javax.persistence.Column(name = "DOBC")
    @Basic
    public String getDobc() {
        return dobc;
    }

    public void setDobc(String dobc) {
        this.dobc = dobc;
    }

    private String ctznsr;

    @javax.persistence.Column(name = "CTZNSR")
    @Basic
    public String getCtznsr() {
        return ctznsr;
    }

    public void setCtznsr(String ctznsr) {
        this.ctznsr = ctznsr;
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

    private String mpnid;

    @javax.persistence.Column(name = "MPNID")
    @Basic
    public String getMpnid() {
        return mpnid;
    }

    public void setMpnid(String mpnid) {
        this.mpnid = mpnid;
    }

    private String mpnstat;

    @javax.persistence.Column(name = "MPNSTAT")
    @Basic
    public String getMpnstat() {
        return mpnstat;
    }

    public void setMpnstat(String mpnstat) {
        this.mpnstat = mpnstat;
    }

    private String fmpnst;

    @javax.persistence.Column(name = "FMPNST")
    @Basic
    public String getFmpnst() {
        return fmpnst;
    }

    public void setFmpnst(String fmpnst) {
        this.fmpnst = fmpnst;
    }

    private String mpntyp;

    @javax.persistence.Column(name = "MPNTYP")
    @Basic
    public String getMpntyp() {
        return mpntyp;
    }

    public void setMpntyp(String mpntyp) {
        this.mpntyp = mpntyp;
    }

    private String pkmpnst;

    @javax.persistence.Column(name = "PKMPNST")
    @Basic
    public String getPkmpnst() {
        return pkmpnst;
    }

    public void setPkmpnst(String pkmpnst) {
        this.pkmpnst = pkmpnst;
    }

    private int mpnamt;

    @javax.persistence.Column(name = "MPNAMT")
    @Basic
    public int getMpnamt() {
        return mpnamt;
    }

    public void setMpnamt(int mpnamt) {
        this.mpnamt = mpnamt;
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

    private String fpntyp;

    @javax.persistence.Column(name = "FPNTYP")
    @Basic
    public String getFpntyp() {
        return fpntyp;
    }

    public void setFpntyp(String fpntyp) {
        this.fpntyp = fpntyp;
    }

    private String pkpntyp;

    @javax.persistence.Column(name = "PKPNTYP")
    @Basic
    public String getPkpntyp() {
        return pkpntyp;
    }

    public void setPkpntyp(String pkpntyp) {
        this.pkpntyp = pkpntyp;
    }

    private String arn;

    @javax.persistence.Column(name = "ARN")
    @Basic
    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn;
    }

    private String sigdte;

    @javax.persistence.Column(name = "SIGDTE")
    @Basic
    public String getSigdte() {
        return sigdte;
    }

    public void setSigdte(String sigdte) {
        this.sigdte = sigdte;
    }

    private String sigctp;

    @javax.persistence.Column(name = "SIGCTP")
    @Basic
    public String getSigctp() {
        return sigctp;
    }

    public void setSigctp(String sigctp) {
        this.sigctp = sigctp;
    }

    private String resdte;

    @javax.persistence.Column(name = "RESDTE")
    @Basic
    public String getResdte() {
        return resdte;
    }

    public void setResdte(String resdte) {
        this.resdte = resdte;
    }

    private String pgurid;

    @javax.persistence.Column(name = "PGURID")
    @Basic
    public String getPgurid() {
        return pgurid;
    }

    public void setPgurid(String pgurid) {
        this.pgurid = pgurid;
    }

    private String sigcid;

    @javax.persistence.Column(name = "SIGCID")
    @Basic
    public String getSigcid() {
        return sigcid;
    }

    public void setSigcid(String sigcid) {
        this.sigcid = sigcid;
    }

    private String resdst;

    @javax.persistence.Column(name = "RESDST")
    @Basic
    public String getResdst() {
        return resdst;
    }

    public void setResdst(String resdst) {
        this.resdst = resdst;
    }

    private String plenid;

    @javax.persistence.Column(name = "PLENID")
    @Basic
    public String getPlenid() {
        return plenid;
    }

    public void setPlenid(String plenid) {
        this.plenid = plenid;
    }

    private String ppnsdt;

    @javax.persistence.Column(name = "PPNSDT")
    @Basic
    public String getPpnsdt() {
        return ppnsdt;
    }

    public void setPpnsdt(String ppnsdt) {
        this.ppnsdt = ppnsdt;
    }

    private String ppnddt;

    @javax.persistence.Column(name = "PPNDDT")
    @Basic
    public String getPpnddt() {
        return ppnddt;
    }

    public void setPpnddt(String ppnddt) {
        this.ppnddt = ppnddt;
    }

    private String ppnpdt;

    @javax.persistence.Column(name = "PPNPDT")
    @Basic
    public String getPpnpdt() {
        return ppnpdt;
    }

    public void setPpnpdt(String ppnpdt) {
        this.ppnpdt = ppnpdt;
    }

    private String ptrndt;

    @javax.persistence.Column(name = "PTRNDT")
    @Basic
    public String getPtrndt() {
        return ptrndt;
    }

    public void setPtrndt(String ptrndt) {
        this.ptrndt = ptrndt;
    }

    private String ppnown;

    @javax.persistence.Column(name = "PPNOWN")
    @Basic
    public String getPpnown() {
        return ppnown;
    }

    public void setPpnown(String ppnown) {
        this.ppnown = ppnown;
    }

    private String relate;

    @javax.persistence.Column(name = "RELATE")
    @Basic
    public String getRelate() {
        return relate;
    }

    public void setRelate(String relate) {
        this.relate = relate;
    }

    private String docido;

    @javax.persistence.Column(name = "DOCIDO")
    @Basic
    public String getDocido() {
        return docido;
    }

    public void setDocido(String docido) {
        this.docido = docido;
    }

    private String orgst;

    @javax.persistence.Column(name = "ORGST")
    @Basic
    public String getOrgst() {
        return orgst;
    }

    public void setOrgst(String orgst) {
        this.orgst = orgst;
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

    private String docidc;

    @javax.persistence.Column(name = "DOCIDC")
    @Basic
    public String getDocidc() {
        return docidc;
    }

    public void setDocidc(String docidc) {
        this.docidc = docidc;
    }

    private String chgst;

    @javax.persistence.Column(name = "CHGST")
    @Basic
    public String getChgst() {
        return chgst;
    }

    public void setChgst(String chgst) {
        this.chgst = chgst;
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

    private String maiden;

    @javax.persistence.Column(name = "MAIDEN")
    @Basic
    public String getMaiden() {
        return maiden;
    }

    public void setMaiden(String maiden) {
        this.maiden = maiden;
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

    private String suffix;

    @javax.persistence.Column(name = "SUFFIX")
    @Basic
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private String dethdt;

    @javax.persistence.Column(name = "DETHDT")
    @Basic
    public String getDethdt() {
        return dethdt;
    }

    public void setDethdt(String dethdt) {
        this.dethdt = dethdt;
    }

    private String hspltn;

    @javax.persistence.Column(name = "HSPLTN")
    @Basic
    public String getHspltn() {
        return hspltn;
    }

    public void setHspltn(String hspltn) {
        this.hspltn = hspltn;
    }

    private String amiakn;

    @javax.persistence.Column(name = "AMIAKN")
    @Basic
    public String getAmiakn() {
        return amiakn;
    }

    public void setAmiakn(String amiakn) {
        this.amiakn = amiakn;
    }

    private String asian;

    @javax.persistence.Column(name = "ASIAN")
    @Basic
    public String getAsian() {
        return asian;
    }

    public void setAsian(String asian) {
        this.asian = asian;
    }

    private String blkafa;

    @javax.persistence.Column(name = "BLKAFA")
    @Basic
    public String getBlkafa() {
        return blkafa;
    }

    public void setBlkafa(String blkafa) {
        this.blkafa = blkafa;
    }

    private String nhiopi;

    @javax.persistence.Column(name = "NHIOPI")
    @Basic
    public String getNhiopi() {
        return nhiopi;
    }

    public void setNhiopi(String nhiopi) {
        this.nhiopi = nhiopi;
    }

    private String white;

    @javax.persistence.Column(name = "WHITE")
    @Basic
    public String getWhite() {
        return white;
    }

    public void setWhite(String white) {
        this.white = white;
    }

    private String auth;

    @javax.persistence.Column(name = "AUTH")
    @Basic
    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    private String graddt;

    @javax.persistence.Column(name = "GRADDT")
    @Basic
    public String getGraddt() {
        return graddt;
    }

    public void setGraddt(String graddt) {
        this.graddt = graddt;
    }

    private String acdlvl;

    @javax.persistence.Column(name = "ACDLVL")
    @Basic
    public String getAcdlvl() {
        return acdlvl;
    }

    public void setAcdlvl(String acdlvl) {
        this.acdlvl = acdlvl;
    }

    private String ecollg;

    @javax.persistence.Column(name = "ECOLLG")
    @Basic
    public String getEcollg() {
        return ecollg;
    }

    public void setEcollg(String ecollg) {
        this.ecollg = ecollg;
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

    private String atbbcd;

    @javax.persistence.Column(name = "ATBBCD")
    @Basic
    public String getAtbbcd() {
        return atbbcd;
    }

    public void setAtbbcd(String atbbcd) {
        this.atbbcd = atbbcd;
    }

    private String atbtac;

    @javax.persistence.Column(name = "ATBTAC")
    @Basic
    public String getAtbtac() {
        return atbtac;
    }

    public void setAtbtac(String atbtac) {
        this.atbtac = atbtac;
    }

    private String atbcdt;

    @javax.persistence.Column(name = "ATBCDT")
    @Basic
    public String getAtbcdt() {
        return atbcdt;
    }

    public void setAtbcdt(String atbcdt) {
        this.atbcdt = atbcdt;
    }

    private String atbstc;

    @javax.persistence.Column(name = "ATBSTC")
    @Basic
    public String getAtbstc() {
        return atbstc;
    }

    public void setAtbstc(String atbstc) {
        this.atbstc = atbstc;
    }

    private String plapsr;

    @javax.persistence.Column(name = "PLAPSR")
    @Basic
    public String getPlapsr() {
        return plapsr;
    }

    public void setPlapsr(String plapsr) {
        this.plapsr = plapsr;
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

    private String prapid;

    @javax.persistence.Column(name = "PRAPID")
    @Basic
    public String getPrapid() {
        return prapid;
    }

    public void setPrapid(String prapid) {
        this.prapid = prapid;
    }

    private String adtype;

    @javax.persistence.Column(name = "ADTYPE")
    @Basic
    public String getAdtype() {
        return adtype;
    }

    public void setAdtype(String adtype) {
        this.adtype = adtype;
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

    private String shsflg;

    @javax.persistence.Column(name = "SHSFLG")
    @Basic
    public String getShsflg() {
        return shsflg;
    }

    public void setShsflg(String shsflg) {
        this.shsflg = shsflg;
    }

    private String shscde;

    @javax.persistence.Column(name = "SHSCDE")
    @Basic
    public String getShscde() {
        return shscde;
    }

    public void setShscde(String shscde) {
        this.shscde = shscde;
    }

    private String shsnme;

    @javax.persistence.Column(name = "SHSNME")
    @Basic
    public String getShsnme() {
        return shsnme;
    }

    public void setShsnme(String shsnme) {
        this.shsnme = shsnme;
    }

    private String shscty;

    @javax.persistence.Column(name = "SHSCTY")
    @Basic
    public String getShscty() {
        return shscty;
    }

    public void setShscty(String shscty) {
        this.shscty = shscty;
    }

    private String shsst;

    @javax.persistence.Column(name = "SHSST")
    @Basic
    public String getShsst() {
        return shsst;
    }

    public void setShsst(String shsst) {
        this.shsst = shsst;
    }

    private String shsnm2;

    @javax.persistence.Column(name = "SHSNM2")
    @Basic
    public String getShsnm2() {
        return shsnm2;
    }

    public void setShsnm2(String shsnm2) {
        this.shsnm2 = shsnm2;
    }

    private String shsct2;

    @javax.persistence.Column(name = "SHSCT2")
    @Basic
    public String getShsct2() {
        return shsct2;
    }

    public void setShsct2(String shsct2) {
        this.shsct2 = shsct2;
    }

    private String shsst2;

    @javax.persistence.Column(name = "SHSST2")
    @Basic
    public String getShsst2() {
        return shsst2;
    }

    public void setShsst2(String shsst2) {
        this.shsst2 = shsst2;
    }

    private String fshsnm;

    @javax.persistence.Column(name = "FSHSNM")
    @Basic
    public String getFshsnm() {
        return fshsnm;
    }

    public void setFshsnm(String fshsnm) {
        this.fshsnm = fshsnm;
    }

    private String fshsct;

    @javax.persistence.Column(name = "FSHSCT")
    @Basic
    public String getFshsct() {
        return fshsct;
    }

    public void setFshsct(String fshsct) {
        this.fshsct = fshsct;
    }

    private String fshsst;

    @javax.persistence.Column(name = "FSHSST")
    @Basic
    public String getFshsst() {
        return fshsst;
    }

    public void setFshsst(String fshsst) {
        this.fshsst = fshsst;
    }

    private String epsnty;

    @javax.persistence.Column(name = "EPSNTY")
    @Basic
    public String getEpsnty() {
        return epsnty;
    }

    public void setEpsnty(String epsnty) {
        this.epsnty = epsnty;
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

    private String apcmpd;

    @javax.persistence.Column(name = "APCMPD")
    @Basic
    public String getApcmpd() {
        return apcmpd;
    }

    public void setApcmpd(String apcmpd) {
        this.apcmpd = apcmpd;
    }

    private String crdcex;

    @javax.persistence.Column(name = "CRDCEX")
    @Basic
    public String getCrdcex() {
        return crdcex;
    }

    public void setCrdcex(String crdcex) {
        this.crdcex = crdcex;
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

    private String mxlnai;

    @javax.persistence.Column(name = "MXLNAI")
    @Basic
    public String getMxlnai() {
        return mxlnai;
    }

    public void setMxlnai(String mxlnai) {
        this.mxlnai = mxlnai;
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

    private String aawdyr;

    @javax.persistence.Column(name = "AAWDYR")
    @Basic
    public String getAawdyr() {
        return aawdyr;
    }

    public void setAawdyr(String aawdyr) {
        this.aawdyr = aawdyr;
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

    private String ocrdst;

    @javax.persistence.Column(name = "OCRDST")
    @Basic
    public String getOcrdst() {
        return ocrdst;
    }

    public void setOcrdst(String ocrdst) {
        this.ocrdst = ocrdst;
    }

    private String crdcov;

    @javax.persistence.Column(name = "CRDCOV")
    @Basic
    public String getCrdcov() {
        return crdcov;
    }

    public void setCrdcov(String crdcov) {
        this.crdcov = crdcov;
    }

    private String atbtcd;

    @javax.persistence.Column(name = "ATBTCD")
    @Basic
    public String getAtbtcd() {
        return atbtcd;
    }

    public void setAtbtcd(String atbtcd) {
        this.atbtcd = atbtcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PsnEntity psnEntity = (PsnEntity) o;

        if (mpnamt != psnEntity.mpnamt) return false;
        if (revlev != psnEntity.revlev) return false;
        if (usrnr1 != psnEntity.usrnr1) return false;
        if (aawdyr != null ? !aawdyr.equals(psnEntity.aawdyr) : psnEntity.aawdyr != null) return false;
        if (acdlvl != null ? !acdlvl.equals(psnEntity.acdlvl) : psnEntity.acdlvl != null) return false;
        if (addrsd != null ? !addrsd.equals(psnEntity.addrsd) : psnEntity.addrsd != null) return false;
        if (adtype != null ? !adtype.equals(psnEntity.adtype) : psnEntity.adtype != null) return false;
        if (alnamt != null ? !alnamt.equals(psnEntity.alnamt) : psnEntity.alnamt != null) return false;
        if (amiakn != null ? !amiakn.equals(psnEntity.amiakn) : psnEntity.amiakn != null) return false;
        if (apcmpd != null ? !apcmpd.equals(psnEntity.apcmpd) : psnEntity.apcmpd != null) return false;
        if (appid != null ? !appid.equals(psnEntity.appid) : psnEntity.appid != null) return false;
        if (arn != null ? !arn.equals(psnEntity.arn) : psnEntity.arn != null) return false;
        if (asian != null ? !asian.equals(psnEntity.asian) : psnEntity.asian != null) return false;
        if (atbbcd != null ? !atbbcd.equals(psnEntity.atbbcd) : psnEntity.atbbcd != null) return false;
        if (atbcdt != null ? !atbcdt.equals(psnEntity.atbcdt) : psnEntity.atbcdt != null) return false;
        if (atbstc != null ? !atbstc.equals(psnEntity.atbstc) : psnEntity.atbstc != null) return false;
        if (atbtac != null ? !atbtac.equals(psnEntity.atbtac) : psnEntity.atbtac != null) return false;
        if (atbtcd != null ? !atbtcd.equals(psnEntity.atbtcd) : psnEntity.atbtcd != null) return false;
        if (auth != null ? !auth.equals(psnEntity.auth) : psnEntity.auth != null) return false;
        if (awdedt != null ? !awdedt.equals(psnEntity.awdedt) : psnEntity.awdedt != null) return false;
        if (awdsdt != null ? !awdsdt.equals(psnEntity.awdsdt) : psnEntity.awdsdt != null) return false;
        if (blkafa != null ? !blkafa.equals(psnEntity.blkafa) : psnEntity.blkafa != null) return false;
        if (chgst != null ? !chgst.equals(psnEntity.chgst) : psnEntity.chgst != null) return false;
        if (cractc != null ? !cractc.equals(psnEntity.cractc) : psnEntity.cractc != null) return false;
        if (crapls != null ? !crapls.equals(psnEntity.crapls) : psnEntity.crapls != null) return false;
        if (crbalo != null ? !crbalo.equals(psnEntity.crbalo) : psnEntity.crbalo != null) return false;
        if (crdcex != null ? !crdcex.equals(psnEntity.crdcex) : psnEntity.crdcex != null) return false;
        if (crdcov != null ? !crdcov.equals(psnEntity.crdcov) : psnEntity.crdcov != null) return false;
        if (crdcst != null ? !crdcst.equals(psnEntity.crdcst) : psnEntity.crdcst != null) return false;
        if (crtdby != null ? !crtdby.equals(psnEntity.crtdby) : psnEntity.crtdby != null) return false;
        if (crtdtec != null ? !crtdtec.equals(psnEntity.crtdtec) : psnEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(psnEntity.crtmod) : psnEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(psnEntity.crttime) : psnEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(psnEntity.crtuser) : psnEntity.crtuser != null) return false;
        if (ctzns != null ? !ctzns.equals(psnEntity.ctzns) : psnEntity.ctzns != null) return false;
        if (ctznsc != null ? !ctznsc.equals(psnEntity.ctznsc) : psnEntity.ctznsc != null) return false;
        if (ctznsr != null ? !ctznsr.equals(psnEntity.ctznsr) : psnEntity.ctznsr != null) return false;
        if (defopt != null ? !defopt.equals(psnEntity.defopt) : psnEntity.defopt != null) return false;
        if (dethdt != null ? !dethdt.equals(psnEntity.dethdt) : psnEntity.dethdt != null) return false;
        if (dlnum != null ? !dlnum.equals(psnEntity.dlnum) : psnEntity.dlnum != null) return false;
        if (dlnumc != null ? !dlnumc.equals(psnEntity.dlnumc) : psnEntity.dlnumc != null) return false;
        if (dlnumr != null ? !dlnumr.equals(psnEntity.dlnumr) : psnEntity.dlnumr != null) return false;
        if (dlst != null ? !dlst.equals(psnEntity.dlst) : psnEntity.dlst != null) return false;
        if (dlstc != null ? !dlstc.equals(psnEntity.dlstc) : psnEntity.dlstc != null) return false;
        if (dlstr != null ? !dlstr.equals(psnEntity.dlstr) : psnEntity.dlstr != null) return false;
        if (dob != null ? !dob.equals(psnEntity.dob) : psnEntity.dob != null) return false;
        if (dobc != null ? !dobc.equals(psnEntity.dobc) : psnEntity.dobc != null) return false;
        if (dobr != null ? !dobr.equals(psnEntity.dobr) : psnEntity.dobr != null) return false;
        if (docidc != null ? !docidc.equals(psnEntity.docidc) : psnEntity.docidc != null) return false;
        if (docido != null ? !docido.equals(psnEntity.docido) : psnEntity.docido != null) return false;
        if (ecollg != null ? !ecollg.equals(psnEntity.ecollg) : psnEntity.ecollg != null) return false;
        if (emalsd != null ? !emalsd.equals(psnEntity.emalsd) : psnEntity.emalsd != null) return false;
        if (epsnty != null ? !epsnty.equals(psnEntity.epsnty) : psnEntity.epsnty != null) return false;
        if (fmpnst != null ? !fmpnst.equals(psnEntity.fmpnst) : psnEntity.fmpnst != null) return false;
        if (fpntyp != null ? !fpntyp.equals(psnEntity.fpntyp) : psnEntity.fpntyp != null) return false;
        if (fshsct != null ? !fshsct.equals(psnEntity.fshsct) : psnEntity.fshsct != null) return false;
        if (fshsnm != null ? !fshsnm.equals(psnEntity.fshsnm) : psnEntity.fshsnm != null) return false;
        if (fshsst != null ? !fshsst.equals(psnEntity.fshsst) : psnEntity.fshsst != null) return false;
        if (graddt != null ? !graddt.equals(psnEntity.graddt) : psnEntity.graddt != null) return false;
        if (guarid != null ? !guarid.equals(psnEntity.guarid) : psnEntity.guarid != null) return false;
        if (hspltn != null ? !hspltn.equals(psnEntity.hspltn) : psnEntity.hspltn != null) return false;
        if (instid != null ? !instid.equals(psnEntity.instid) : psnEntity.instid != null) return false;
        if (lendid != null ? !lendid.equals(psnEntity.lendid) : psnEntity.lendid != null) return false;
        if (maiden != null ? !maiden.equals(psnEntity.maiden) : psnEntity.maiden != null) return false;
        if (mpnid != null ? !mpnid.equals(psnEntity.mpnid) : psnEntity.mpnid != null) return false;
        if (mpnstat != null ? !mpnstat.equals(psnEntity.mpnstat) : psnEntity.mpnstat != null) return false;
        if (mpntyp != null ? !mpntyp.equals(psnEntity.mpntyp) : psnEntity.mpntyp != null) return false;
        if (mxlnai != null ? !mxlnai.equals(psnEntity.mxlnai) : psnEntity.mxlnai != null) return false;
        if (namef != null ? !namef.equals(psnEntity.namef) : psnEntity.namef != null) return false;
        if (namefc != null ? !namefc.equals(psnEntity.namefc) : psnEntity.namefc != null) return false;
        if (namefr != null ? !namefr.equals(psnEntity.namefr) : psnEntity.namefr != null) return false;
        if (namel != null ? !namel.equals(psnEntity.namel) : psnEntity.namel != null) return false;
        if (namelc != null ? !namelc.equals(psnEntity.namelc) : psnEntity.namelc != null) return false;
        if (namelr != null ? !namelr.equals(psnEntity.namelr) : psnEntity.namelr != null) return false;
        if (namem != null ? !namem.equals(psnEntity.namem) : psnEntity.namem != null) return false;
        if (namemc != null ? !namemc.equals(psnEntity.namemc) : psnEntity.namemc != null) return false;
        if (namemr != null ? !namemr.equals(psnEntity.namemr) : psnEntity.namemr != null) return false;
        if (nhiopi != null ? !nhiopi.equals(psnEntity.nhiopi) : psnEntity.nhiopi != null) return false;
        if (ocrdst != null ? !ocrdst.equals(psnEntity.ocrdst) : psnEntity.ocrdst != null) return false;
        if (orgst != null ? !orgst.equals(psnEntity.orgst) : psnEntity.orgst != null) return false;
        if (pgurid != null ? !pgurid.equals(psnEntity.pgurid) : psnEntity.pgurid != null) return false;
        if (phonsd != null ? !phonsd.equals(psnEntity.phonsd) : psnEntity.phonsd != null) return false;
        if (pkmpnst != null ? !pkmpnst.equals(psnEntity.pkmpnst) : psnEntity.pkmpnst != null) return false;
        if (pkpntyp != null ? !pkpntyp.equals(psnEntity.pkpntyp) : psnEntity.pkpntyp != null) return false;
        if (plapsr != null ? !plapsr.equals(psnEntity.plapsr) : psnEntity.plapsr != null) return false;
        if (plenid != null ? !plenid.equals(psnEntity.plenid) : psnEntity.plenid != null) return false;
        if (ppnddt != null ? !ppnddt.equals(psnEntity.ppnddt) : psnEntity.ppnddt != null) return false;
        if (ppnown != null ? !ppnown.equals(psnEntity.ppnown) : psnEntity.ppnown != null) return false;
        if (ppnpdt != null ? !ppnpdt.equals(psnEntity.ppnpdt) : psnEntity.ppnpdt != null) return false;
        if (ppnsdt != null ? !ppnsdt.equals(psnEntity.ppnsdt) : psnEntity.ppnsdt != null) return false;
        if (prapid != null ? !prapid.equals(psnEntity.prapid) : psnEntity.prapid != null) return false;
        if (psnkey != null ? !psnkey.equals(psnEntity.psnkey) : psnEntity.psnkey != null) return false;
        if (psntyp != null ? !psntyp.equals(psnEntity.psntyp) : psnEntity.psntyp != null) return false;
        if (ptrndt != null ? !ptrndt.equals(psnEntity.ptrndt) : psnEntity.ptrndt != null) return false;
        if (relate != null ? !relate.equals(psnEntity.relate) : psnEntity.relate != null) return false;
        if (resdst != null ? !resdst.equals(psnEntity.resdst) : psnEntity.resdst != null) return false;
        if (resdte != null ? !resdte.equals(psnEntity.resdte) : psnEntity.resdte != null) return false;
        if (revdtec != null ? !revdtec.equals(psnEntity.revdtec) : psnEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(psnEntity.revmod) : psnEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(psnEntity.revtime) : psnEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(psnEntity.revuser) : psnEntity.revuser != null) return false;
        if (shscde != null ? !shscde.equals(psnEntity.shscde) : psnEntity.shscde != null) return false;
        if (shsct2 != null ? !shsct2.equals(psnEntity.shsct2) : psnEntity.shsct2 != null) return false;
        if (shscty != null ? !shscty.equals(psnEntity.shscty) : psnEntity.shscty != null) return false;
        if (shsflg != null ? !shsflg.equals(psnEntity.shsflg) : psnEntity.shsflg != null) return false;
        if (shsnm2 != null ? !shsnm2.equals(psnEntity.shsnm2) : psnEntity.shsnm2 != null) return false;
        if (shsnme != null ? !shsnme.equals(psnEntity.shsnme) : psnEntity.shsnme != null) return false;
        if (shsst != null ? !shsst.equals(psnEntity.shsst) : psnEntity.shsst != null) return false;
        if (shsst2 != null ? !shsst2.equals(psnEntity.shsst2) : psnEntity.shsst2 != null) return false;
        if (sid != null ? !sid.equals(psnEntity.sid) : psnEntity.sid != null) return false;
        if (sigcid != null ? !sigcid.equals(psnEntity.sigcid) : psnEntity.sigcid != null) return false;
        if (sigctp != null ? !sigctp.equals(psnEntity.sigctp) : psnEntity.sigctp != null) return false;
        if (sigdte != null ? !sigdte.equals(psnEntity.sigdte) : psnEntity.sigdte != null) return false;
        if (ssnum != null ? !ssnum.equals(psnEntity.ssnum) : psnEntity.ssnum != null) return false;
        if (ssnumc != null ? !ssnumc.equals(psnEntity.ssnumc) : psnEntity.ssnumc != null) return false;
        if (ssnumr != null ? !ssnumr.equals(psnEntity.ssnumr) : psnEntity.ssnumr != null) return false;
        if (suffix != null ? !suffix.equals(psnEntity.suffix) : psnEntity.suffix != null) return false;
        if (title != null ? !title.equals(psnEntity.title) : psnEntity.title != null) return false;
        if (ucode != null ? !ucode.equals(psnEntity.ucode) : psnEntity.ucode != null) return false;
        if (unlamt != null ? !unlamt.equals(psnEntity.unlamt) : psnEntity.unlamt != null) return false;
        if (usrcd1 != null ? !usrcd1.equals(psnEntity.usrcd1) : psnEntity.usrcd1 != null) return false;
        if (usrcd2 != null ? !usrcd2.equals(psnEntity.usrcd2) : psnEntity.usrcd2 != null) return false;
        if (usrcd3 != null ? !usrcd3.equals(psnEntity.usrcd3) : psnEntity.usrcd3 != null) return false;
        if (usrcd4 != null ? !usrcd4.equals(psnEntity.usrcd4) : psnEntity.usrcd4 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(psnEntity.usrdt1) : psnEntity.usrdt1 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(psnEntity.usrnr2) : psnEntity.usrnr2 != null) return false;
        if (white != null ? !white.equals(psnEntity.white) : psnEntity.white != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = psnkey != null ? psnkey.hashCode() : 0;
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (psntyp != null ? psntyp.hashCode() : 0);
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
        result = 31 * result + (addrsd != null ? addrsd.hashCode() : 0);
        result = 31 * result + (phonsd != null ? phonsd.hashCode() : 0);
        result = 31 * result + (emalsd != null ? emalsd.hashCode() : 0);
        result = 31 * result + (ssnum != null ? ssnum.hashCode() : 0);
        result = 31 * result + (namel != null ? namel.hashCode() : 0);
        result = 31 * result + (namef != null ? namef.hashCode() : 0);
        result = 31 * result + (namem != null ? namem.hashCode() : 0);
        result = 31 * result + (dlst != null ? dlst.hashCode() : 0);
        result = 31 * result + (dlnum != null ? dlnum.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (ctzns != null ? ctzns.hashCode() : 0);
        result = 31 * result + (ssnumr != null ? ssnumr.hashCode() : 0);
        result = 31 * result + (namelr != null ? namelr.hashCode() : 0);
        result = 31 * result + (namefr != null ? namefr.hashCode() : 0);
        result = 31 * result + (namemr != null ? namemr.hashCode() : 0);
        result = 31 * result + (dlstr != null ? dlstr.hashCode() : 0);
        result = 31 * result + (dlnumr != null ? dlnumr.hashCode() : 0);
        result = 31 * result + (dobr != null ? dobr.hashCode() : 0);
        result = 31 * result + (ctznsc != null ? ctznsc.hashCode() : 0);
        result = 31 * result + (ssnumc != null ? ssnumc.hashCode() : 0);
        result = 31 * result + (namelc != null ? namelc.hashCode() : 0);
        result = 31 * result + (namefc != null ? namefc.hashCode() : 0);
        result = 31 * result + (namemc != null ? namemc.hashCode() : 0);
        result = 31 * result + (dlstc != null ? dlstc.hashCode() : 0);
        result = 31 * result + (dlnumc != null ? dlnumc.hashCode() : 0);
        result = 31 * result + (dobc != null ? dobc.hashCode() : 0);
        result = 31 * result + (ctznsr != null ? ctznsr.hashCode() : 0);
        result = 31 * result + (lendid != null ? lendid.hashCode() : 0);
        result = 31 * result + (mpnid != null ? mpnid.hashCode() : 0);
        result = 31 * result + (mpnstat != null ? mpnstat.hashCode() : 0);
        result = 31 * result + (fmpnst != null ? fmpnst.hashCode() : 0);
        result = 31 * result + (mpntyp != null ? mpntyp.hashCode() : 0);
        result = 31 * result + (pkmpnst != null ? pkmpnst.hashCode() : 0);
        result = 31 * result + mpnamt;
        result = 31 * result + (guarid != null ? guarid.hashCode() : 0);
        result = 31 * result + (fpntyp != null ? fpntyp.hashCode() : 0);
        result = 31 * result + (pkpntyp != null ? pkpntyp.hashCode() : 0);
        result = 31 * result + (arn != null ? arn.hashCode() : 0);
        result = 31 * result + (sigdte != null ? sigdte.hashCode() : 0);
        result = 31 * result + (sigctp != null ? sigctp.hashCode() : 0);
        result = 31 * result + (resdte != null ? resdte.hashCode() : 0);
        result = 31 * result + (pgurid != null ? pgurid.hashCode() : 0);
        result = 31 * result + (sigcid != null ? sigcid.hashCode() : 0);
        result = 31 * result + (resdst != null ? resdst.hashCode() : 0);
        result = 31 * result + (plenid != null ? plenid.hashCode() : 0);
        result = 31 * result + (ppnsdt != null ? ppnsdt.hashCode() : 0);
        result = 31 * result + (ppnddt != null ? ppnddt.hashCode() : 0);
        result = 31 * result + (ppnpdt != null ? ppnpdt.hashCode() : 0);
        result = 31 * result + (ptrndt != null ? ptrndt.hashCode() : 0);
        result = 31 * result + (ppnown != null ? ppnown.hashCode() : 0);
        result = 31 * result + (relate != null ? relate.hashCode() : 0);
        result = 31 * result + (docido != null ? docido.hashCode() : 0);
        result = 31 * result + (orgst != null ? orgst.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (docidc != null ? docidc.hashCode() : 0);
        result = 31 * result + (chgst != null ? chgst.hashCode() : 0);
        result = 31 * result + (usrcd1 != null ? usrcd1.hashCode() : 0);
        result = 31 * result + (usrcd2 != null ? usrcd2.hashCode() : 0);
        result = 31 * result + (usrcd3 != null ? usrcd3.hashCode() : 0);
        result = 31 * result + (usrcd4 != null ? usrcd4.hashCode() : 0);
        result = 31 * result + usrnr1;
        result = 31 * result + (usrnr2 != null ? usrnr2.hashCode() : 0);
        result = 31 * result + (maiden != null ? maiden.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
        result = 31 * result + (dethdt != null ? dethdt.hashCode() : 0);
        result = 31 * result + (hspltn != null ? hspltn.hashCode() : 0);
        result = 31 * result + (amiakn != null ? amiakn.hashCode() : 0);
        result = 31 * result + (asian != null ? asian.hashCode() : 0);
        result = 31 * result + (blkafa != null ? blkafa.hashCode() : 0);
        result = 31 * result + (nhiopi != null ? nhiopi.hashCode() : 0);
        result = 31 * result + (white != null ? white.hashCode() : 0);
        result = 31 * result + (auth != null ? auth.hashCode() : 0);
        result = 31 * result + (graddt != null ? graddt.hashCode() : 0);
        result = 31 * result + (acdlvl != null ? acdlvl.hashCode() : 0);
        result = 31 * result + (ecollg != null ? ecollg.hashCode() : 0);
        result = 31 * result + (crdcst != null ? crdcst.hashCode() : 0);
        result = 31 * result + (atbbcd != null ? atbbcd.hashCode() : 0);
        result = 31 * result + (atbtac != null ? atbtac.hashCode() : 0);
        result = 31 * result + (atbcdt != null ? atbcdt.hashCode() : 0);
        result = 31 * result + (atbstc != null ? atbstc.hashCode() : 0);
        result = 31 * result + (plapsr != null ? plapsr.hashCode() : 0);
        result = 31 * result + (unlamt != null ? unlamt.hashCode() : 0);
        result = 31 * result + (awdsdt != null ? awdsdt.hashCode() : 0);
        result = 31 * result + (awdedt != null ? awdedt.hashCode() : 0);
        result = 31 * result + (prapid != null ? prapid.hashCode() : 0);
        result = 31 * result + (adtype != null ? adtype.hashCode() : 0);
        result = 31 * result + (crtdby != null ? crtdby.hashCode() : 0);
        result = 31 * result + (shsflg != null ? shsflg.hashCode() : 0);
        result = 31 * result + (shscde != null ? shscde.hashCode() : 0);
        result = 31 * result + (shsnme != null ? shsnme.hashCode() : 0);
        result = 31 * result + (shscty != null ? shscty.hashCode() : 0);
        result = 31 * result + (shsst != null ? shsst.hashCode() : 0);
        result = 31 * result + (shsnm2 != null ? shsnm2.hashCode() : 0);
        result = 31 * result + (shsct2 != null ? shsct2.hashCode() : 0);
        result = 31 * result + (shsst2 != null ? shsst2.hashCode() : 0);
        result = 31 * result + (fshsnm != null ? fshsnm.hashCode() : 0);
        result = 31 * result + (fshsct != null ? fshsct.hashCode() : 0);
        result = 31 * result + (fshsst != null ? fshsst.hashCode() : 0);
        result = 31 * result + (epsnty != null ? epsnty.hashCode() : 0);
        result = 31 * result + (appid != null ? appid.hashCode() : 0);
        result = 31 * result + (apcmpd != null ? apcmpd.hashCode() : 0);
        result = 31 * result + (crdcex != null ? crdcex.hashCode() : 0);
        result = 31 * result + (crbalo != null ? crbalo.hashCode() : 0);
        result = 31 * result + (cractc != null ? cractc.hashCode() : 0);
        result = 31 * result + (crapls != null ? crapls.hashCode() : 0);
        result = 31 * result + (mxlnai != null ? mxlnai.hashCode() : 0);
        result = 31 * result + (defopt != null ? defopt.hashCode() : 0);
        result = 31 * result + (aawdyr != null ? aawdyr.hashCode() : 0);
        result = 31 * result + (alnamt != null ? alnamt.hashCode() : 0);
        result = 31 * result + (ocrdst != null ? ocrdst.hashCode() : 0);
        result = 31 * result + (crdcov != null ? crdcov.hashCode() : 0);
        result = 31 * result + (atbtcd != null ? atbtcd.hashCode() : 0);
        return result;
    }
}
