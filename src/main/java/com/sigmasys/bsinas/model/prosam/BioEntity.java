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
 * Date: 11/25/12
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "BIO", schema = "SIGMA", catalog = "")
@Entity
public class BioEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getBiokey();
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

    private String biokey;

    @javax.persistence.Column(name = "BIOKEY")
    @Id
    public String getBiokey() {
        return biokey;
    }

    public void setBiokey(String biokey) {
        this.biokey = biokey;
    }

    private String bioakey;

    @javax.persistence.Column(name = "BIOAKEY")
    @Basic
    public String getBioakey() {
        return bioakey;
    }

    public void setBioakey(String bioakey) {
        this.bioakey = bioakey;
    }

    private String biobkey;

    @javax.persistence.Column(name = "BIOBKEY")
    @Basic
    public String getBiobkey() {
        return biobkey;
    }

    public void setBiobkey(String biobkey) {
        this.biobkey = biobkey;
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

    private String ainstid;

    @javax.persistence.Column(name = "AINSTID")
    @Basic
    public String getAinstid() {
        return ainstid;
    }

    public void setAinstid(String ainstid) {
        this.ainstid = ainstid;
    }

    private String sid2;

    @javax.persistence.Column(name = "SID2")
    @Basic
    public String getSid2() {
        return sid2;
    }

    public void setSid2(String sid2) {
        this.sid2 = sid2;
    }

    private String binstid;

    @javax.persistence.Column(name = "BINSTID")
    @Basic
    public String getBinstid() {
        return binstid;
    }

    public void setBinstid(String binstid) {
        this.binstid = binstid;
    }

    private String sname;

    @javax.persistence.Column(name = "SNAME")
    @Basic
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    private String scitzn;

    @javax.persistence.Column(name = "SCITZN")
    @Basic
    public String getScitzn() {
        return scitzn;
    }

    public void setScitzn(String scitzn) {
        this.scitzn = scitzn;
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

    private String ssex;

    @javax.persistence.Column(name = "SSEX")
    @Basic
    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    private String smaritl;

    @javax.persistence.Column(name = "SMARITL")
    @Basic
    public String getSmaritl() {
        return smaritl;
    }

    public void setSmaritl(String smaritl) {
        this.smaritl = smaritl;
    }

    private String sethnic;

    @javax.persistence.Column(name = "SETHNIC")
    @Basic
    public String getSethnic() {
        return sethnic;
    }

    public void setSethnic(String sethnic) {
        this.sethnic = sethnic;
    }

    private String addrtyp;

    @javax.persistence.Column(name = "ADDRTYP")
    @Basic
    public String getAddrtyp() {
        return addrtyp;
    }

    public void setAddrtyp(String addrtyp) {
        this.addrtyp = addrtyp;
    }

    private String laddrst;

    @javax.persistence.Column(name = "LADDRST")
    @Basic
    public String getLaddrst() {
        return laddrst;
    }

    public void setLaddrst(String laddrst) {
        this.laddrst = laddrst;
    }

    private String laddr;

    @javax.persistence.Column(name = "LADDR")
    @Basic
    public String getLaddr() {
        return laddr;
    }

    public void setLaddr(String laddr) {
        this.laddr = laddr;
    }

    private String laddr2;

    @javax.persistence.Column(name = "LADDR2")
    @Basic
    public String getLaddr2() {
        return laddr2;
    }

    public void setLaddr2(String laddr2) {
        this.laddr2 = laddr2;
    }

    private String lcity;

    @javax.persistence.Column(name = "LCITY")
    @Basic
    public String getLcity() {
        return lcity;
    }

    public void setLcity(String lcity) {
        this.lcity = lcity;
    }

    private String lstate;

    @javax.persistence.Column(name = "LSTATE")
    @Basic
    public String getLstate() {
        return lstate;
    }

    public void setLstate(String lstate) {
        this.lstate = lstate;
    }

    private String lzip;

    @javax.persistence.Column(name = "LZIP")
    @Basic
    public String getLzip() {
        return lzip;
    }

    public void setLzip(String lzip) {
        this.lzip = lzip;
    }

    private String lcntry;

    @javax.persistence.Column(name = "LCNTRY")
    @Basic
    public String getLcntry() {
        return lcntry;
    }

    public void setLcntry(String lcntry) {
        this.lcntry = lcntry;
    }

    private String lphone;

    @javax.persistence.Column(name = "LPHONE")
    @Basic
    public String getLphone() {
        return lphone;
    }

    public void setLphone(String lphone) {
        this.lphone = lphone;
    }

    private String paddrst;

    @javax.persistence.Column(name = "PADDRST")
    @Basic
    public String getPaddrst() {
        return paddrst;
    }

    public void setPaddrst(String paddrst) {
        this.paddrst = paddrst;
    }

    private String paddr;

    @javax.persistence.Column(name = "PADDR")
    @Basic
    public String getPaddr() {
        return paddr;
    }

    public void setPaddr(String paddr) {
        this.paddr = paddr;
    }

    private String paddr2;

    @javax.persistence.Column(name = "PADDR2")
    @Basic
    public String getPaddr2() {
        return paddr2;
    }

    public void setPaddr2(String paddr2) {
        this.paddr2 = paddr2;
    }

    private String pcity;

    @javax.persistence.Column(name = "PCITY")
    @Basic
    public String getPcity() {
        return pcity;
    }

    public void setPcity(String pcity) {
        this.pcity = pcity;
    }

    private String pstate;

    @javax.persistence.Column(name = "PSTATE")
    @Basic
    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    private String pzip;

    @javax.persistence.Column(name = "PZIP")
    @Basic
    public String getPzip() {
        return pzip;
    }

    public void setPzip(String pzip) {
        this.pzip = pzip;
    }

    private String pcntry;

    @javax.persistence.Column(name = "PCNTRY")
    @Basic
    public String getPcntry() {
        return pcntry;
    }

    public void setPcntry(String pcntry) {
        this.pcntry = pcntry;
    }

    private String pphone;

    @javax.persistence.Column(name = "PPHONE")
    @Basic
    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    private BigInteger lengres;

    @javax.persistence.Column(name = "LENGRES")
    @Basic
    public BigInteger getLengres() {
        return lengres;
    }

    public void setLengres(BigInteger lengres) {
        this.lengres = lengres;
    }

    private String scity;

    @javax.persistence.Column(name = "SCITY")
    @Basic
    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    private String scounty;

    @javax.persistence.Column(name = "SCOUNTY")
    @Basic
    public String getScounty() {
        return scounty;
    }

    public void setScounty(String scounty) {
        this.scounty = scounty;
    }

    private String sstate;

    @javax.persistence.Column(name = "SSTATE")
    @Basic
    public String getSstate() {
        return sstate;
    }

    public void setSstate(String sstate) {
        this.sstate = sstate;
    }

    private String proadm;

    @javax.persistence.Column(name = "PROADM")
    @Basic
    public String getProadm() {
        return proadm;
    }

    public void setProadm(String proadm) {
        this.proadm = proadm;
    }

    private String proreg;

    @javax.persistence.Column(name = "PROREG")
    @Basic
    public String getProreg() {
        return proreg;
    }

    public void setProreg(String proreg) {
        this.proreg = proreg;
    }

    private String prosam;

    @javax.persistence.Column(name = "PROSAM")
    @Basic
    public String getProsam() {
        return prosam;
    }

    public void setProsam(String prosam) {
        this.prosam = prosam;
    }

    private String prosar;

    @javax.persistence.Column(name = "PROSAR")
    @Basic
    public String getProsar() {
        return prosar;
    }

    public void setProsar(String prosar) {
        this.prosar = prosar;
    }

    private String prolap;

    @javax.persistence.Column(name = "PROLAP")
    @Basic
    public String getProlap() {
        return prolap;
    }

    public void setProlap(String prolap) {
        this.prolap = prolap;
    }

    private String sscrxst;

    @javax.persistence.Column(name = "SSCRXST")
    @Basic
    public String getSscrxst() {
        return sscrxst;
    }

    public void setSscrxst(String sscrxst) {
        this.sscrxst = sscrxst;
    }

    private String unused4;

    @javax.persistence.Column(name = "UNUSED4")
    @Basic
    public String getUnused4() {
        return unused4;
    }

    public void setUnused4(String unused4) {
        this.unused4 = unused4;
    }

    private BigDecimal index1;

    @javax.persistence.Column(name = "INDEX1")
    @Basic
    public BigDecimal getIndex1() {
        return index1;
    }

    public void setIndex1(BigDecimal index1) {
        this.index1 = index1;
    }

    private BigDecimal index2;

    @javax.persistence.Column(name = "INDEX2")
    @Basic
    public BigDecimal getIndex2() {
        return index2;
    }

    public void setIndex2(BigDecimal index2) {
        this.index2 = index2;
    }

    private int index3;

    @javax.persistence.Column(name = "INDEX3")
    @Basic
    public int getIndex3() {
        return index3;
    }

    public void setIndex3(int index3) {
        this.index3 = index3;
    }

    private int index4;

    @javax.persistence.Column(name = "INDEX4")
    @Basic
    public int getIndex4() {
        return index4;
    }

    public void setIndex4(int index4) {
        this.index4 = index4;
    }

    private int index5;

    @javax.persistence.Column(name = "INDEX5")
    @Basic
    public int getIndex5() {
        return index5;
    }

    public void setIndex5(int index5) {
        this.index5 = index5;
    }

    private String agncysp;

    @javax.persistence.Column(name = "AGNCYSP")
    @Basic
    public String getAgncysp() {
        return agncysp;
    }

    public void setAgncysp(String agncysp) {
        this.agncysp = agncysp;
    }

    private String instisp;

    @javax.persistence.Column(name = "INSTISP")
    @Basic
    public String getInstisp() {
        return instisp;
    }

    public void setInstisp(String instisp) {
        this.instisp = instisp;
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

    private String usercd3;

    @javax.persistence.Column(name = "USERCD3")
    @Basic
    public String getUsercd3() {
        return usercd3;
    }

    public void setUsercd3(String usercd3) {
        this.usercd3 = usercd3;
    }

    private String usercd4;

    @javax.persistence.Column(name = "USERCD4")
    @Basic
    public String getUsercd4() {
        return usercd4;
    }

    public void setUsercd4(String usercd4) {
        this.usercd4 = usercd4;
    }

    private String usercd5;

    @javax.persistence.Column(name = "USERCD5")
    @Basic
    public String getUsercd5() {
        return usercd5;
    }

    public void setUsercd5(String usercd5) {
        this.usercd5 = usercd5;
    }

    private String usercd6;

    @javax.persistence.Column(name = "USERCD6")
    @Basic
    public String getUsercd6() {
        return usercd6;
    }

    public void setUsercd6(String usercd6) {
        this.usercd6 = usercd6;
    }

    private String usercd7;

    @javax.persistence.Column(name = "USERCD7")
    @Basic
    public String getUsercd7() {
        return usercd7;
    }

    public void setUsercd7(String usercd7) {
        this.usercd7 = usercd7;
    }

    private String usercd8;

    @javax.persistence.Column(name = "USERCD8")
    @Basic
    public String getUsercd8() {
        return usercd8;
    }

    public void setUsercd8(String usercd8) {
        this.usercd8 = usercd8;
    }

    private String langprf;

    @javax.persistence.Column(name = "LANGPRF")
    @Basic
    public String getLangprf() {
        return langprf;
    }

    public void setLangprf(String langprf) {
        this.langprf = langprf;
    }

    private String privacy;

    @javax.persistence.Column(name = "PRIVACY")
    @Basic
    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    private String fatreq;

    @javax.persistence.Column(name = "FATREQ")
    @Basic
    public String getFatreq() {
        return fatreq;
    }

    public void setFatreq(String fatreq) {
        this.fatreq = fatreq;
    }

    private String glabel;

    @javax.persistence.Column(name = "GLABEL")
    @Basic
    public String getGlabel() {
        return glabel;
    }

    public void setGlabel(String glabel) {
        this.glabel = glabel;
    }

    private String biocat;

    @javax.persistence.Column(name = "BIOCAT")
    @Basic
    public String getBiocat() {
        return biocat;
    }

    public void setBiocat(String biocat) {
        this.biocat = biocat;
    }

    private String fflocn;

    @javax.persistence.Column(name = "FFLOCN")
    @Basic
    public String getFflocn() {
        return fflocn;
    }

    public void setFflocn(String fflocn) {
        this.fflocn = fflocn;
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

    private String sscrest;

    @javax.persistence.Column(name = "SSCREST")
    @Basic
    public String getSscrest() {
        return sscrest;
    }

    public void setSscrest(String sscrest) {
        this.sscrest = sscrest;
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

    private String vetstat;

    @javax.persistence.Column(name = "VETSTAT")
    @Basic
    public String getVetstat() {
        return vetstat;
    }

    public void setVetstat(String vetstat) {
        this.vetstat = vetstat;
    }

    private String vaelig;

    @javax.persistence.Column(name = "VAELIG")
    @Basic
    public String getVaelig() {
        return vaelig;
    }

    public void setVaelig(String vaelig) {
        this.vaelig = vaelig;
    }

    private String vaid;

    @javax.persistence.Column(name = "VAID")
    @Basic
    public String getVaid() {
        return vaid;
    }

    public void setVaid(String vaid) {
        this.vaid = vaid;
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

    private BigDecimal cmhrsdf;

    @javax.persistence.Column(name = "CMHRSDF")
    @Basic
    public BigDecimal getCmhrsdf() {
        return cmhrsdf;
    }

    public void setCmhrsdf(BigDecimal cmhrsdf) {
        this.cmhrsdf = cmhrsdf;
    }

    private BigDecimal cmhrsco;

    @javax.persistence.Column(name = "CMHRSCO")
    @Basic
    public BigDecimal getCmhrsco() {
        return cmhrsco;
    }

    public void setCmhrsco(BigDecimal cmhrsco) {
        this.cmhrsco = cmhrsco;
    }

    private BigDecimal lshrsca;

    @javax.persistence.Column(name = "LSHRSCA")
    @Basic
    public BigDecimal getLshrsca() {
        return lshrsca;
    }

    public void setLshrsca(BigDecimal lshrsca) {
        this.lshrsca = lshrsca;
    }

    private BigDecimal lshrsco;

    @javax.persistence.Column(name = "LSHRSCO")
    @Basic
    public BigDecimal getLshrsco() {
        return lshrsco;
    }

    public void setLshrsco(BigDecimal lshrsco) {
        this.lshrsco = lshrsco;
    }

    private BigDecimal cuhrsca;

    @javax.persistence.Column(name = "CUHRSCA")
    @Basic
    public BigDecimal getCuhrsca() {
        return cuhrsca;
    }

    public void setCuhrsca(BigDecimal cuhrsca) {
        this.cuhrsca = cuhrsca;
    }

    private String tlabel;

    @javax.persistence.Column(name = "TLABEL")
    @Basic
    public String getTlabel() {
        return tlabel;
    }

    public void setTlabel(String tlabel) {
        this.tlabel = tlabel;
    }

    private String sitime;

    @javax.persistence.Column(name = "SITIME")
    @Basic
    public String getSitime() {
        return sitime;
    }

    public void setSitime(String sitime) {
        this.sitime = sitime;
    }

    private BigInteger revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public BigInteger getRevlev() {
        return revlev;
    }

    public void setRevlev(BigInteger revlev) {
        this.revlev = revlev;
    }

    private String initals;

    @javax.persistence.Column(name = "INITALS")
    @Basic
    public String getInitals() {
        return initals;
    }

    public void setInitals(String initals) {
        this.initals = initals;
    }

    private String module;

    @javax.persistence.Column(name = "MODULE")
    @Basic
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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

    private String sbirthc;

    @javax.persistence.Column(name = "SBIRTHC")
    @Basic
    public String getSbirthc() {
        return sbirthc;
    }

    public void setSbirthc(String sbirthc) {
        this.sbirthc = sbirthc;
    }

    private String lexpdtc;

    @javax.persistence.Column(name = "LEXPDTC")
    @Basic
    public String getLexpdtc() {
        return lexpdtc;
    }

    public void setLexpdtc(String lexpdtc) {
        this.lexpdtc = lexpdtc;
    }

    private String expgrdc;

    @javax.persistence.Column(name = "EXPGRDC")
    @Basic
    public String getExpgrdc() {
        return expgrdc;
    }

    public void setExpgrdc(String expgrdc) {
        this.expgrdc = expgrdc;
    }

    private String fflcdtc;

    @javax.persistence.Column(name = "FFLCDTC")
    @Basic
    public String getFflcdtc() {
        return fflcdtc;
    }

    public void setFflcdtc(String fflcdtc) {
        this.fflcdtc = fflcdtc;
    }

    private String sscrsdc;

    @javax.persistence.Column(name = "SSCRSDC")
    @Basic
    public String getSscrsdc() {
        return sscrsdc;
    }

    public void setSscrsdc(String sscrsdc) {
        this.sscrsdc = sscrsdc;
    }

    private String entintc;

    @javax.persistence.Column(name = "ENTINTC")
    @Basic
    public String getEntintc() {
        return entintc;
    }

    public void setEntintc(String entintc) {
        this.entintc = entintc;
    }

    private String createc;

    @javax.persistence.Column(name = "CREATEC")
    @Basic
    public String getCreatec() {
        return createc;
    }

    public void setCreatec(String createc) {
        this.createc = createc;
    }

    private String revdtc;

    @javax.persistence.Column(name = "REVDTC")
    @Basic
    public String getRevdtc() {
        return revdtc;
    }

    public void setRevdtc(String revdtc) {
        this.revdtc = revdtc;
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

    private String extint;

    @javax.persistence.Column(name = "EXTINT")
    @Basic
    public String getExtint() {
        return extint;
    }

    public void setExtint(String extint) {
        this.extint = extint;
    }

    private String email;

    @javax.persistence.Column(name = "EMAIL")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    private int mpnamt;

    @javax.persistence.Column(name = "MPNAMT")
    @Basic
    public int getMpnamt() {
        return mpnamt;
    }

    public void setMpnamt(int mpnamt) {
        this.mpnamt = mpnamt;
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

    private int mpnrqat;

    @javax.persistence.Column(name = "MPNRQAT")
    @Basic
    public int getMpnrqat() {
        return mpnrqat;
    }

    public void setMpnrqat(int mpnrqat) {
        this.mpnrqat = mpnrqat;
    }

    private String mpnst;

    @javax.persistence.Column(name = "MPNST")
    @Basic
    public String getMpnst() {
        return mpnst;
    }

    public void setMpnst(String mpnst) {
        this.mpnst = mpnst;
    }

    private String usercd9;

    @javax.persistence.Column(name = "USERCD9")
    @Basic
    public String getUsercd9() {
        return usercd9;
    }

    public void setUsercd9(String usercd9) {
        this.usercd9 = usercd9;
    }

    private String user10;

    @javax.persistence.Column(name = "USER10")
    @Basic
    public String getUser10() {
        return user10;
    }

    public void setUser10(String user10) {
        this.user10 = user10;
    }

    private String user11;

    @javax.persistence.Column(name = "USER11")
    @Basic
    public String getUser11() {
        return user11;
    }

    public void setUser11(String user11) {
        this.user11 = user11;
    }

    private String user12;

    @javax.persistence.Column(name = "USER12")
    @Basic
    public String getUser12() {
        return user12;
    }

    public void setUser12(String user12) {
        this.user12 = user12;
    }

    private String user13;

    @javax.persistence.Column(name = "USER13")
    @Basic
    public String getUser13() {
        return user13;
    }

    public void setUser13(String user13) {
        this.user13 = user13;
    }

    private BigDecimal usernr1;

    @javax.persistence.Column(name = "USERNR1")
    @Basic
    public BigDecimal getUsernr1() {
        return usernr1;
    }

    public void setUsernr1(BigDecimal usernr1) {
        this.usernr1 = usernr1;
    }

    private BigDecimal usernr2;

    @javax.persistence.Column(name = "USERNR2")
    @Basic
    public BigDecimal getUsernr2() {
        return usernr2;
    }

    public void setUsernr2(BigDecimal usernr2) {
        this.usernr2 = usernr2;
    }

    private BigDecimal usernr3;

    @javax.persistence.Column(name = "USERNR3")
    @Basic
    public BigDecimal getUsernr3() {
        return usernr3;
    }

    public void setUsernr3(BigDecimal usernr3) {
        this.usernr3 = usernr3;
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

    private String dlpntyp;

    @javax.persistence.Column(name = "DLPNTYP")
    @Basic
    public String getDlpntyp() {
        return dlpntyp;
    }

    public void setDlpntyp(String dlpntyp) {
        this.dlpntyp = dlpntyp;
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

    private String pmpnst;

    @javax.persistence.Column(name = "PMPNST")
    @Basic
    public String getPmpnst() {
        return pmpnst;
    }

    public void setPmpnst(String pmpnst) {
        this.pmpnst = pmpnst;
    }

    private String emailst;

    @javax.persistence.Column(name = "EMAILST")
    @Basic
    public String getEmailst() {
        return emailst;
    }

    public void setEmailst(String emailst) {
        this.emailst = emailst;
    }

    private String alert;

    @javax.persistence.Column(name = "ALERT")
    @Basic
    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    private BigInteger r2T4Cnt;

    @javax.persistence.Column(name = "R2T4CNT")
    @Basic
    public BigInteger getR2T4Cnt() {
        return r2T4Cnt;
    }

    public void setR2T4Cnt(BigInteger r2T4Cnt) {
        this.r2T4Cnt = r2T4Cnt;
    }

    private String hsgrdtc;

    @javax.persistence.Column(name = "HSGRDTC")
    @Basic
    public String getHsgrdtc() {
        return hsgrdtc;
    }

    public void setHsgrdtc(String hsgrdtc) {
        this.hsgrdtc = hsgrdtc;
    }

    private BigDecimal acdygpa;

    @javax.persistence.Column(name = "ACDYGPA")
    @Basic
    public BigDecimal getAcdygpa() {
        return acdygpa;
    }

    public void setAcdygpa(BigDecimal acdygpa) {
        this.acdygpa = acdygpa;
    }

    private String hold1;

    @javax.persistence.Column(name = "HOLD1")
    @Basic
    public String getHold1() {
        return hold1;
    }

    public void setHold1(String hold1) {
        this.hold1 = hold1;
    }

    private String hold2;

    @javax.persistence.Column(name = "HOLD2")
    @Basic
    public String getHold2() {
        return hold2;
    }

    public void setHold2(String hold2) {
        this.hold2 = hold2;
    }

    private String entintp;

    @javax.persistence.Column(name = "ENTINTP")
    @Basic
    public String getEntintp() {
        return entintp;
    }

    public void setEntintp(String entintp) {
        this.entintp = entintp;
    }

    private String hscode;

    @javax.persistence.Column(name = "HSCODE")
    @Basic
    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode;
    }

    private String hsstate;

    @javax.persistence.Column(name = "HSSTATE")
    @Basic
    public String getHsstate() {
        return hsstate;
    }

    public void setHsstate(String hsstate) {
        this.hsstate = hsstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BioEntity bioEntity = (BioEntity) o;

        if (index3 != bioEntity.index3) return false;
        if (index4 != bioEntity.index4) return false;
        if (index5 != bioEntity.index5) return false;
        if (mpnamt != bioEntity.mpnamt) return false;
        if (mpnrqat != bioEntity.mpnrqat) return false;
        if (acdygpa != null ? !acdygpa.equals(bioEntity.acdygpa) : bioEntity.acdygpa != null) return false;
        if (addrtyp != null ? !addrtyp.equals(bioEntity.addrtyp) : bioEntity.addrtyp != null) return false;
        if (agncysp != null ? !agncysp.equals(bioEntity.agncysp) : bioEntity.agncysp != null) return false;
        if (ainstid != null ? !ainstid.equals(bioEntity.ainstid) : bioEntity.ainstid != null) return false;
        if (alert != null ? !alert.equals(bioEntity.alert) : bioEntity.alert != null) return false;
        if (binstid != null ? !binstid.equals(bioEntity.binstid) : bioEntity.binstid != null) return false;
        if (bioakey != null ? !bioakey.equals(bioEntity.bioakey) : bioEntity.bioakey != null) return false;
        if (biobkey != null ? !biobkey.equals(bioEntity.biobkey) : bioEntity.biobkey != null) return false;
        if (biocat != null ? !biocat.equals(bioEntity.biocat) : bioEntity.biocat != null) return false;
        if (biokey != null ? !biokey.equals(bioEntity.biokey) : bioEntity.biokey != null) return false;
        if (cmhrsco != null ? !cmhrsco.equals(bioEntity.cmhrsco) : bioEntity.cmhrsco != null) return false;
        if (cmhrsdf != null ? !cmhrsdf.equals(bioEntity.cmhrsdf) : bioEntity.cmhrsdf != null) return false;
        if (createc != null ? !createc.equals(bioEntity.createc) : bioEntity.createc != null) return false;
        if (crttime != null ? !crttime.equals(bioEntity.crttime) : bioEntity.crttime != null) return false;
        if (cuhrsca != null ? !cuhrsca.equals(bioEntity.cuhrsca) : bioEntity.cuhrsca != null) return false;
        if (cumgpa != null ? !cumgpa.equals(bioEntity.cumgpa) : bioEntity.cumgpa != null) return false;
        if (dlpntyp != null ? !dlpntyp.equals(bioEntity.dlpntyp) : bioEntity.dlpntyp != null) return false;
        if (email != null ? !email.equals(bioEntity.email) : bioEntity.email != null) return false;
        if (emailst != null ? !emailst.equals(bioEntity.emailst) : bioEntity.emailst != null) return false;
        if (entintc != null ? !entintc.equals(bioEntity.entintc) : bioEntity.entintc != null) return false;
        if (entintp != null ? !entintp.equals(bioEntity.entintp) : bioEntity.entintp != null) return false;
        if (expgrdc != null ? !expgrdc.equals(bioEntity.expgrdc) : bioEntity.expgrdc != null) return false;
        if (extint != null ? !extint.equals(bioEntity.extint) : bioEntity.extint != null) return false;
        if (fatreq != null ? !fatreq.equals(bioEntity.fatreq) : bioEntity.fatreq != null) return false;
        if (fflcdtc != null ? !fflcdtc.equals(bioEntity.fflcdtc) : bioEntity.fflcdtc != null) return false;
        if (fflocn != null ? !fflocn.equals(bioEntity.fflocn) : bioEntity.fflocn != null) return false;
        if (fmpnst != null ? !fmpnst.equals(bioEntity.fmpnst) : bioEntity.fmpnst != null) return false;
        if (fpntyp != null ? !fpntyp.equals(bioEntity.fpntyp) : bioEntity.fpntyp != null) return false;
        if (glabel != null ? !glabel.equals(bioEntity.glabel) : bioEntity.glabel != null) return false;
        if (guarid != null ? !guarid.equals(bioEntity.guarid) : bioEntity.guarid != null) return false;
        if (hold1 != null ? !hold1.equals(bioEntity.hold1) : bioEntity.hold1 != null) return false;
        if (hold2 != null ? !hold2.equals(bioEntity.hold2) : bioEntity.hold2 != null) return false;
        if (hscode != null ? !hscode.equals(bioEntity.hscode) : bioEntity.hscode != null) return false;
        if (hsgrdtc != null ? !hsgrdtc.equals(bioEntity.hsgrdtc) : bioEntity.hsgrdtc != null) return false;
        if (hsstate != null ? !hsstate.equals(bioEntity.hsstate) : bioEntity.hsstate != null) return false;
        if (index1 != null ? !index1.equals(bioEntity.index1) : bioEntity.index1 != null) return false;
        if (index2 != null ? !index2.equals(bioEntity.index2) : bioEntity.index2 != null) return false;
        if (initals != null ? !initals.equals(bioEntity.initals) : bioEntity.initals != null) return false;
        if (instid != null ? !instid.equals(bioEntity.instid) : bioEntity.instid != null) return false;
        if (instisp != null ? !instisp.equals(bioEntity.instisp) : bioEntity.instisp != null) return false;
        if (laddr != null ? !laddr.equals(bioEntity.laddr) : bioEntity.laddr != null) return false;
        if (laddr2 != null ? !laddr2.equals(bioEntity.laddr2) : bioEntity.laddr2 != null) return false;
        if (laddrst != null ? !laddrst.equals(bioEntity.laddrst) : bioEntity.laddrst != null) return false;
        if (langprf != null ? !langprf.equals(bioEntity.langprf) : bioEntity.langprf != null) return false;
        if (lcity != null ? !lcity.equals(bioEntity.lcity) : bioEntity.lcity != null) return false;
        if (lcntry != null ? !lcntry.equals(bioEntity.lcntry) : bioEntity.lcntry != null) return false;
        if (lendid != null ? !lendid.equals(bioEntity.lendid) : bioEntity.lendid != null) return false;
        if (lengres != null ? !lengres.equals(bioEntity.lengres) : bioEntity.lengres != null) return false;
        if (lexpdtc != null ? !lexpdtc.equals(bioEntity.lexpdtc) : bioEntity.lexpdtc != null) return false;
        if (lphone != null ? !lphone.equals(bioEntity.lphone) : bioEntity.lphone != null) return false;
        if (lshrsca != null ? !lshrsca.equals(bioEntity.lshrsca) : bioEntity.lshrsca != null) return false;
        if (lshrsco != null ? !lshrsco.equals(bioEntity.lshrsco) : bioEntity.lshrsco != null) return false;
        if (lstate != null ? !lstate.equals(bioEntity.lstate) : bioEntity.lstate != null) return false;
        if (lzip != null ? !lzip.equals(bioEntity.lzip) : bioEntity.lzip != null) return false;
        if (module != null ? !module.equals(bioEntity.module) : bioEntity.module != null) return false;
        if (mpnid != null ? !mpnid.equals(bioEntity.mpnid) : bioEntity.mpnid != null) return false;
        if (mpnst != null ? !mpnst.equals(bioEntity.mpnst) : bioEntity.mpnst != null) return false;
        if (mpnstat != null ? !mpnstat.equals(bioEntity.mpnstat) : bioEntity.mpnstat != null) return false;
        if (paddr != null ? !paddr.equals(bioEntity.paddr) : bioEntity.paddr != null) return false;
        if (paddr2 != null ? !paddr2.equals(bioEntity.paddr2) : bioEntity.paddr2 != null) return false;
        if (paddrst != null ? !paddrst.equals(bioEntity.paddrst) : bioEntity.paddrst != null) return false;
        if (pcity != null ? !pcity.equals(bioEntity.pcity) : bioEntity.pcity != null) return false;
        if (pcntry != null ? !pcntry.equals(bioEntity.pcntry) : bioEntity.pcntry != null) return false;
        if (pmpnst != null ? !pmpnst.equals(bioEntity.pmpnst) : bioEntity.pmpnst != null) return false;
        if (pphone != null ? !pphone.equals(bioEntity.pphone) : bioEntity.pphone != null) return false;
        if (privacy != null ? !privacy.equals(bioEntity.privacy) : bioEntity.privacy != null) return false;
        if (proadm != null ? !proadm.equals(bioEntity.proadm) : bioEntity.proadm != null) return false;
        if (prolap != null ? !prolap.equals(bioEntity.prolap) : bioEntity.prolap != null) return false;
        if (proreg != null ? !proreg.equals(bioEntity.proreg) : bioEntity.proreg != null) return false;
        if (prosam != null ? !prosam.equals(bioEntity.prosam) : bioEntity.prosam != null) return false;
        if (prosar != null ? !prosar.equals(bioEntity.prosar) : bioEntity.prosar != null) return false;
        if (pstate != null ? !pstate.equals(bioEntity.pstate) : bioEntity.pstate != null) return false;
        if (pzip != null ? !pzip.equals(bioEntity.pzip) : bioEntity.pzip != null) return false;
        if (r2T4Cnt != null ? !r2T4Cnt.equals(bioEntity.r2T4Cnt) : bioEntity.r2T4Cnt != null) return false;
        if (recstat != null ? !recstat.equals(bioEntity.recstat) : bioEntity.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(bioEntity.revdtc) : bioEntity.revdtc != null) return false;
        if (revlev != null ? !revlev.equals(bioEntity.revlev) : bioEntity.revlev != null) return false;
        if (sbirthc != null ? !sbirthc.equals(bioEntity.sbirthc) : bioEntity.sbirthc != null) return false;
        if (scity != null ? !scity.equals(bioEntity.scity) : bioEntity.scity != null) return false;
        if (scitzn != null ? !scitzn.equals(bioEntity.scitzn) : bioEntity.scitzn != null) return false;
        if (scounty != null ? !scounty.equals(bioEntity.scounty) : bioEntity.scounty != null) return false;
        if (sethnic != null ? !sethnic.equals(bioEntity.sethnic) : bioEntity.sethnic != null) return false;
        if (sid != null ? !sid.equals(bioEntity.sid) : bioEntity.sid != null) return false;
        if (sid2 != null ? !sid2.equals(bioEntity.sid2) : bioEntity.sid2 != null) return false;
        if (sitime != null ? !sitime.equals(bioEntity.sitime) : bioEntity.sitime != null) return false;
        if (smaritl != null ? !smaritl.equals(bioEntity.smaritl) : bioEntity.smaritl != null) return false;
        if (sname != null ? !sname.equals(bioEntity.sname) : bioEntity.sname != null) return false;
        if (sscrest != null ? !sscrest.equals(bioEntity.sscrest) : bioEntity.sscrest != null) return false;
        if (sscrsdc != null ? !sscrsdc.equals(bioEntity.sscrsdc) : bioEntity.sscrsdc != null) return false;
        if (sscrxst != null ? !sscrxst.equals(bioEntity.sscrxst) : bioEntity.sscrxst != null) return false;
        if (ssex != null ? !ssex.equals(bioEntity.ssex) : bioEntity.ssex != null) return false;
        if (sstate != null ? !sstate.equals(bioEntity.sstate) : bioEntity.sstate != null) return false;
        if (title != null ? !title.equals(bioEntity.title) : bioEntity.title != null) return false;
        if (tlabel != null ? !tlabel.equals(bioEntity.tlabel) : bioEntity.tlabel != null) return false;
        if (ucode != null ? !ucode.equals(bioEntity.ucode) : bioEntity.ucode != null) return false;
        if (unused4 != null ? !unused4.equals(bioEntity.unused4) : bioEntity.unused4 != null) return false;
        if (user10 != null ? !user10.equals(bioEntity.user10) : bioEntity.user10 != null) return false;
        if (user11 != null ? !user11.equals(bioEntity.user11) : bioEntity.user11 != null) return false;
        if (user12 != null ? !user12.equals(bioEntity.user12) : bioEntity.user12 != null) return false;
        if (user13 != null ? !user13.equals(bioEntity.user13) : bioEntity.user13 != null) return false;
        if (usercd1 != null ? !usercd1.equals(bioEntity.usercd1) : bioEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(bioEntity.usercd2) : bioEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(bioEntity.usercd3) : bioEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(bioEntity.usercd4) : bioEntity.usercd4 != null) return false;
        if (usercd5 != null ? !usercd5.equals(bioEntity.usercd5) : bioEntity.usercd5 != null) return false;
        if (usercd6 != null ? !usercd6.equals(bioEntity.usercd6) : bioEntity.usercd6 != null) return false;
        if (usercd7 != null ? !usercd7.equals(bioEntity.usercd7) : bioEntity.usercd7 != null) return false;
        if (usercd8 != null ? !usercd8.equals(bioEntity.usercd8) : bioEntity.usercd8 != null) return false;
        if (usercd9 != null ? !usercd9.equals(bioEntity.usercd9) : bioEntity.usercd9 != null) return false;
        if (usernr1 != null ? !usernr1.equals(bioEntity.usernr1) : bioEntity.usernr1 != null) return false;
        if (usernr2 != null ? !usernr2.equals(bioEntity.usernr2) : bioEntity.usernr2 != null) return false;
        if (usernr3 != null ? !usernr3.equals(bioEntity.usernr3) : bioEntity.usernr3 != null) return false;
        if (vaelig != null ? !vaelig.equals(bioEntity.vaelig) : bioEntity.vaelig != null) return false;
        if (vaid != null ? !vaid.equals(bioEntity.vaid) : bioEntity.vaid != null) return false;
        if (vetstat != null ? !vetstat.equals(bioEntity.vetstat) : bioEntity.vetstat != null) return false;
        if (visa != null ? !visa.equals(bioEntity.visa) : bioEntity.visa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (biokey != null ? biokey.hashCode() : 0);
        result = 31 * result + (bioakey != null ? bioakey.hashCode() : 0);
        result = 31 * result + (biobkey != null ? biobkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (ainstid != null ? ainstid.hashCode() : 0);
        result = 31 * result + (sid2 != null ? sid2.hashCode() : 0);
        result = 31 * result + (binstid != null ? binstid.hashCode() : 0);
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (scitzn != null ? scitzn.hashCode() : 0);
        result = 31 * result + (visa != null ? visa.hashCode() : 0);
        result = 31 * result + (ssex != null ? ssex.hashCode() : 0);
        result = 31 * result + (smaritl != null ? smaritl.hashCode() : 0);
        result = 31 * result + (sethnic != null ? sethnic.hashCode() : 0);
        result = 31 * result + (addrtyp != null ? addrtyp.hashCode() : 0);
        result = 31 * result + (laddrst != null ? laddrst.hashCode() : 0);
        result = 31 * result + (laddr != null ? laddr.hashCode() : 0);
        result = 31 * result + (laddr2 != null ? laddr2.hashCode() : 0);
        result = 31 * result + (lcity != null ? lcity.hashCode() : 0);
        result = 31 * result + (lstate != null ? lstate.hashCode() : 0);
        result = 31 * result + (lzip != null ? lzip.hashCode() : 0);
        result = 31 * result + (lcntry != null ? lcntry.hashCode() : 0);
        result = 31 * result + (lphone != null ? lphone.hashCode() : 0);
        result = 31 * result + (paddrst != null ? paddrst.hashCode() : 0);
        result = 31 * result + (paddr != null ? paddr.hashCode() : 0);
        result = 31 * result + (paddr2 != null ? paddr2.hashCode() : 0);
        result = 31 * result + (pcity != null ? pcity.hashCode() : 0);
        result = 31 * result + (pstate != null ? pstate.hashCode() : 0);
        result = 31 * result + (pzip != null ? pzip.hashCode() : 0);
        result = 31 * result + (pcntry != null ? pcntry.hashCode() : 0);
        result = 31 * result + (pphone != null ? pphone.hashCode() : 0);
        result = 31 * result + (lengres != null ? lengres.hashCode() : 0);
        result = 31 * result + (scity != null ? scity.hashCode() : 0);
        result = 31 * result + (scounty != null ? scounty.hashCode() : 0);
        result = 31 * result + (sstate != null ? sstate.hashCode() : 0);
        result = 31 * result + (proadm != null ? proadm.hashCode() : 0);
        result = 31 * result + (proreg != null ? proreg.hashCode() : 0);
        result = 31 * result + (prosam != null ? prosam.hashCode() : 0);
        result = 31 * result + (prosar != null ? prosar.hashCode() : 0);
        result = 31 * result + (prolap != null ? prolap.hashCode() : 0);
        result = 31 * result + (sscrxst != null ? sscrxst.hashCode() : 0);
        result = 31 * result + (unused4 != null ? unused4.hashCode() : 0);
        result = 31 * result + (index1 != null ? index1.hashCode() : 0);
        result = 31 * result + (index2 != null ? index2.hashCode() : 0);
        result = 31 * result + index3;
        result = 31 * result + index4;
        result = 31 * result + index5;
        result = 31 * result + (agncysp != null ? agncysp.hashCode() : 0);
        result = 31 * result + (instisp != null ? instisp.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + (usercd5 != null ? usercd5.hashCode() : 0);
        result = 31 * result + (usercd6 != null ? usercd6.hashCode() : 0);
        result = 31 * result + (usercd7 != null ? usercd7.hashCode() : 0);
        result = 31 * result + (usercd8 != null ? usercd8.hashCode() : 0);
        result = 31 * result + (langprf != null ? langprf.hashCode() : 0);
        result = 31 * result + (privacy != null ? privacy.hashCode() : 0);
        result = 31 * result + (fatreq != null ? fatreq.hashCode() : 0);
        result = 31 * result + (glabel != null ? glabel.hashCode() : 0);
        result = 31 * result + (biocat != null ? biocat.hashCode() : 0);
        result = 31 * result + (fflocn != null ? fflocn.hashCode() : 0);
        result = 31 * result + (guarid != null ? guarid.hashCode() : 0);
        result = 31 * result + (sscrest != null ? sscrest.hashCode() : 0);
        result = 31 * result + (lendid != null ? lendid.hashCode() : 0);
        result = 31 * result + (vetstat != null ? vetstat.hashCode() : 0);
        result = 31 * result + (vaelig != null ? vaelig.hashCode() : 0);
        result = 31 * result + (vaid != null ? vaid.hashCode() : 0);
        result = 31 * result + (cumgpa != null ? cumgpa.hashCode() : 0);
        result = 31 * result + (cmhrsdf != null ? cmhrsdf.hashCode() : 0);
        result = 31 * result + (cmhrsco != null ? cmhrsco.hashCode() : 0);
        result = 31 * result + (lshrsca != null ? lshrsca.hashCode() : 0);
        result = 31 * result + (lshrsco != null ? lshrsco.hashCode() : 0);
        result = 31 * result + (cuhrsca != null ? cuhrsca.hashCode() : 0);
        result = 31 * result + (tlabel != null ? tlabel.hashCode() : 0);
        result = 31 * result + (sitime != null ? sitime.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (sbirthc != null ? sbirthc.hashCode() : 0);
        result = 31 * result + (lexpdtc != null ? lexpdtc.hashCode() : 0);
        result = 31 * result + (expgrdc != null ? expgrdc.hashCode() : 0);
        result = 31 * result + (fflcdtc != null ? fflcdtc.hashCode() : 0);
        result = 31 * result + (sscrsdc != null ? sscrsdc.hashCode() : 0);
        result = 31 * result + (entintc != null ? entintc.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (extint != null ? extint.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mpnstat != null ? mpnstat.hashCode() : 0);
        result = 31 * result + mpnamt;
        result = 31 * result + (mpnid != null ? mpnid.hashCode() : 0);
        result = 31 * result + mpnrqat;
        result = 31 * result + (mpnst != null ? mpnst.hashCode() : 0);
        result = 31 * result + (usercd9 != null ? usercd9.hashCode() : 0);
        result = 31 * result + (user10 != null ? user10.hashCode() : 0);
        result = 31 * result + (user11 != null ? user11.hashCode() : 0);
        result = 31 * result + (user12 != null ? user12.hashCode() : 0);
        result = 31 * result + (user13 != null ? user13.hashCode() : 0);
        result = 31 * result + (usernr1 != null ? usernr1.hashCode() : 0);
        result = 31 * result + (usernr2 != null ? usernr2.hashCode() : 0);
        result = 31 * result + (usernr3 != null ? usernr3.hashCode() : 0);
        result = 31 * result + (fmpnst != null ? fmpnst.hashCode() : 0);
        result = 31 * result + (dlpntyp != null ? dlpntyp.hashCode() : 0);
        result = 31 * result + (fpntyp != null ? fpntyp.hashCode() : 0);
        result = 31 * result + (pmpnst != null ? pmpnst.hashCode() : 0);
        result = 31 * result + (emailst != null ? emailst.hashCode() : 0);
        result = 31 * result + (alert != null ? alert.hashCode() : 0);
        result = 31 * result + (r2T4Cnt != null ? r2T4Cnt.hashCode() : 0);
        result = 31 * result + (hsgrdtc != null ? hsgrdtc.hashCode() : 0);
        result = 31 * result + (acdygpa != null ? acdygpa.hashCode() : 0);
        result = 31 * result + (hold1 != null ? hold1.hashCode() : 0);
        result = 31 * result + (hold2 != null ? hold2.hashCode() : 0);
        result = 31 * result + (entintp != null ? entintp.hashCode() : 0);
        result = 31 * result + (hscode != null ? hscode.hashCode() : 0);
        result = 31 * result + (hsstate != null ? hsstate.hashCode() : 0);
        return result;
    }
}
