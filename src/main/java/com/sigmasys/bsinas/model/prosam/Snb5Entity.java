package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/26/12
 * Time: 12:03 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNB5", schema = "SIGMA", catalog = "")
@Entity
public class Snb5Entity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnbkey();
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

    private String snbkey;

    @javax.persistence.Column(name = "SNBKEY")
    @Id
    public String getSnbkey() {
        return snbkey;
    }

    public void setSnbkey(String snbkey) {
        this.snbkey = snbkey;
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

    private String aidyr;

    @javax.persistence.Column(name = "AIDYR")
    @Basic
    public String getAidyr() {
        return aidyr;
    }

    public void setAidyr(String aidyr) {
        this.aidyr = aidyr;
    }

    private String cmptype;

    @javax.persistence.Column(name = "CMPTYPE")
    @Basic
    public String getCmptype() {
        return cmptype;
    }

    public void setCmptype(String cmptype) {
        this.cmptype = cmptype;
    }

    private String versnr;

    @javax.persistence.Column(name = "VERSNR")
    @Basic
    public String getVersnr() {
        return versnr;
    }

    public void setVersnr(String versnr) {
        this.versnr = versnr;
    }

    private String corflds;

    @javax.persistence.Column(name = "CORFLDS")
    @Basic
    public String getCorflds() {
        return corflds;
    }

    public void setCorflds(String corflds) {
        this.corflds = corflds;
    }

    private String saddrs;

    @javax.persistence.Column(name = "SADDRS")
    @Basic
    public String getSaddrs() {
        return saddrs;
    }

    public void setSaddrs(String saddrs) {
        this.saddrs = saddrs;
    }

    private String sphones;

    @javax.persistence.Column(name = "SPHONES")
    @Basic
    public String getSphones() {
        return sphones;
    }

    public void setSphones(String sphones) {
        this.sphones = sphones;
    }

    private String sresdts;

    @javax.persistence.Column(name = "SRESDTS")
    @Basic
    public String getSresdts() {
        return sresdts;
    }

    public void setSresdts(String sresdts) {
        this.sresdts = sresdts;
    }

    private String salnrs;

    @javax.persistence.Column(name = "SALNRS")
    @Basic
    public String getSalnrs() {
        return salnrs;
    }

    public void setSalnrs(String salnrs) {
        this.salnrs = salnrs;
    }

    private String ssregs;

    @javax.persistence.Column(name = "SSREGS")
    @Basic
    public String getSsregs() {
        return ssregs;
    }

    public void setSsregs(String ssregs) {
        this.ssregs = ssregs;
    }

    private String majors;

    @javax.persistence.Column(name = "MAJORS")
    @Basic
    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    private String degobjs;

    @javax.persistence.Column(name = "DEGOBJS")
    @Basic
    public String getDegobjs() {
        return degobjs;
    }

    public void setDegobjs(String degobjs) {
        this.degobjs = degobjs;
    }

    private String sexpgrs;

    @javax.persistence.Column(name = "SEXPGRS")
    @Basic
    public String getSexpgrs() {
        return sexpgrs;
    }

    public void setSexpgrs(String sexpgrs) {
        this.sexpgrs = sexpgrs;
    }

    private String samecos;

    @javax.persistence.Column(name = "SAMECOS")
    @Basic
    public String getSamecos() {
        return samecos;
    }

    public void setSamecos(String samecos) {
        this.samecos = samecos;
    }

    private String presdts;

    @javax.persistence.Column(name = "PRESDTS")
    @Basic
    public String getPresdts() {
        return presdts;
    }

    public void setPresdts(String presdts) {
        this.presdts = presdts;
    }

    private String press;

    @javax.persistence.Column(name = "PRESS")
    @Basic
    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    private String spsigns;

    @javax.persistence.Column(name = "SPSIGNS")
    @Basic
    public String getSpsigns() {
        return spsigns;
    }

    public void setSpsigns(String spsigns) {
        this.spsigns = spsigns;
    }

    private String fsigns;

    @javax.persistence.Column(name = "FSIGNS")
    @Basic
    public String getFsigns() {
        return fsigns;
    }

    public void setFsigns(String fsigns) {
        this.fsigns = fsigns;
    }

    private String msigns;

    @javax.persistence.Column(name = "MSIGNS")
    @Basic
    public String getMsigns() {
        return msigns;
    }

    public void setMsigns(String msigns) {
        this.msigns = msigns;
    }

    private String wsscrs;

    @javax.persistence.Column(name = "WSSCRS")
    @Basic
    public String getWsscrs() {
        return wsscrs;
    }

    public void setWsscrs(String wsscrs) {
        this.wsscrs = wsscrs;
    }

    private String slscrs;

    @javax.persistence.Column(name = "SLSCRS")
    @Basic
    public String getSlscrs() {
        return slscrs;
    }

    public void setSlscrs(String slscrs) {
        this.slscrs = slscrs;
    }

    private String plscrs;

    @javax.persistence.Column(name = "PLSCRS")
    @Basic
    public String getPlscrs() {
        return plscrs;
    }

    public void setPlscrs(String plscrs) {
        this.plscrs = plscrs;
    }

    private String relssts;

    @javax.persistence.Column(name = "RELSSTS")
    @Basic
    public String getRelssts() {
        return relssts;
    }

    public void setRelssts(String relssts) {
        this.relssts = relssts;
    }

    private String peins;

    @javax.persistence.Column(name = "PEINS")
    @Basic
    public String getPeins() {
        return peins;
    }

    public void setPeins(String peins) {
        this.peins = peins;
    }

    private String pssns;

    @javax.persistence.Column(name = "PSSNS")
    @Basic
    public String getPssns() {
        return pssns;
    }

    public void setPssns(String pssns) {
        this.pssns = pssns;
    }

    private String psigns;

    @javax.persistence.Column(name = "PSIGNS")
    @Basic
    public String getPsigns() {
        return psigns;
    }

    public void setPsigns(String psigns) {
        this.psigns = psigns;
    }

    private String hos1S;

    @javax.persistence.Column(name = "HOS1S")
    @Basic
    public String getHos1S() {
        return hos1S;
    }

    public void setHos1S(String hos1S) {
        this.hos1S = hos1S;
    }

    private String hos2S;

    @javax.persistence.Column(name = "HOS2S")
    @Basic
    public String getHos2S() {
        return hos2S;
    }

    public void setHos2S(String hos2S) {
        this.hos2S = hos2S;
    }

    private String hos3S;

    @javax.persistence.Column(name = "HOS3S")
    @Basic
    public String getHos3S() {
        return hos3S;
    }

    public void setHos3S(String hos3S) {
        this.hos3S = hos3S;
    }

    private String hos4S;

    @javax.persistence.Column(name = "HOS4S")
    @Basic
    public String getHos4S() {
        return hos4S;
    }

    public void setHos4S(String hos4S) {
        this.hos4S = hos4S;
    }

    private String hos5S;

    @javax.persistence.Column(name = "HOS5S")
    @Basic
    public String getHos5S() {
        return hos5S;
    }

    public void setHos5S(String hos5S) {
        this.hos5S = hos5S;
    }

    private String hos6S;

    @javax.persistence.Column(name = "HOS6S")
    @Basic
    public String getHos6S() {
        return hos6S;
    }

    public void setHos6S(String hos6S) {
        this.hos6S = hos6S;
    }

    private String gradpros;

    @javax.persistence.Column(name = "GRADPROS")
    @Basic
    public String getGradpros() {
        return gradpros;
    }

    public void setGradpros(String gradpros) {
        this.gradpros = gradpros;
    }

    private String sresdtc;

    @javax.persistence.Column(name = "SRESDTC")
    @Basic
    public String getSresdtc() {
        return sresdtc;
    }

    public void setSresdtc(String sresdtc) {
        this.sresdtc = sresdtc;
    }

    private String srsdt2C;

    @javax.persistence.Column(name = "SRSDT2C")
    @Basic
    public String getSrsdt2C() {
        return srsdt2C;
    }

    public void setSrsdt2C(String srsdt2C) {
        this.srsdt2C = srsdt2C;
    }

    private String presdtc;

    @javax.persistence.Column(name = "PRESDTC")
    @Basic
    public String getPresdtc() {
        return presdtc;
    }

    public void setPresdtc(String presdtc) {
        this.presdtc = presdtc;
    }

    private String prsdt2C;

    @javax.persistence.Column(name = "PRSDT2C")
    @Basic
    public String getPrsdt2C() {
        return prsdt2C;
    }

    public void setPrsdt2C(String prsdt2C) {
        this.prsdt2C = prsdt2C;
    }

    private String sexpgrc;

    @javax.persistence.Column(name = "SEXPGRC")
    @Basic
    public String getSexpgrc() {
        return sexpgrc;
    }

    public void setSexpgrc(String sexpgrc) {
        this.sexpgrc = sexpgrc;
    }

    private String sexpg2C;

    @javax.persistence.Column(name = "SEXPG2C")
    @Basic
    public String getSexpg2C() {
        return sexpg2C;
    }

    public void setSexpg2C(String sexpg2C) {
        this.sexpg2C = sexpg2C;
    }

    private String sbeginc;

    @javax.persistence.Column(name = "SBEGINC")
    @Basic
    public String getSbeginc() {
        return sbeginc;
    }

    public void setSbeginc(String sbeginc) {
        this.sbeginc = sbeginc;
    }

    private String sendc;

    @javax.persistence.Column(name = "SENDC")
    @Basic
    public String getSendc() {
        return sendc;
    }

    public void setSendc(String sendc) {
        this.sendc = sendc;
    }

    private String sigdtec;

    @javax.persistence.Column(name = "SIGDTEC")
    @Basic
    public String getSigdtec() {
        return sigdtec;
    }

    public void setSigdtec(String sigdtec) {
        this.sigdtec = sigdtec;
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

    private String sbrth2C;

    @javax.persistence.Column(name = "SBRTH2C")
    @Basic
    public String getSbrth2C() {
        return sbrth2C;
    }

    public void setSbrth2C(String sbrth2C) {
        this.sbrth2C = sbrth2C;
    }

    private String sigdt2C;

    @javax.persistence.Column(name = "SIGDT2C")
    @Basic
    public String getSigdt2C() {
        return sigdt2C;
    }

    public void setSigdt2C(String sigdt2C) {
        this.sigdt2C = sigdt2C;
    }

    private String procesc;

    @javax.persistence.Column(name = "PROCESC")
    @Basic
    public String getProcesc() {
        return procesc;
    }

    public void setProcesc(String procesc) {
        this.procesc = procesc;
    }

    private String revis1C;

    @javax.persistence.Column(name = "REVIS1C")
    @Basic
    public String getRevis1C() {
        return revis1C;
    }

    public void setRevis1C(String revis1C) {
        this.revis1C = revis1C;
    }

    private String revis2C;

    @javax.persistence.Column(name = "REVIS2C")
    @Basic
    public String getRevis2C() {
        return revis2C;
    }

    public void setRevis2C(String revis2C) {
        this.revis2C = revis2C;
    }

    private String revis3C;

    @javax.persistence.Column(name = "REVIS3C")
    @Basic
    public String getRevis3C() {
        return revis3C;
    }

    public void setRevis3C(String revis3C) {
        this.revis3C = revis3C;
    }

    private String revis4C;

    @javax.persistence.Column(name = "REVIS4C")
    @Basic
    public String getRevis4C() {
        return revis4C;
    }

    public void setRevis4C(String revis4C) {
        this.revis4C = revis4C;
    }

    private String appsrcd;

    @javax.persistence.Column(name = "APPSRCD")
    @Basic
    public String getAppsrcd() {
        return appsrcd;
    }

    public void setAppsrcd(String appsrcd) {
        this.appsrcd = appsrcd;
    }

    private String appsrcd2;

    @javax.persistence.Column(name = "APPSRCD2")
    @Basic
    public String getAppsrcd2() {
        return appsrcd2;
    }

    public void setAppsrcd2(String appsrcd2) {
        this.appsrcd2 = appsrcd2;
    }

    private String appnum;

    @javax.persistence.Column(name = "APPNUM")
    @Basic
    public String getAppnum() {
        return appnum;
    }

    public void setAppnum(String appnum) {
        this.appnum = appnum;
    }

    private String appnum2;

    @javax.persistence.Column(name = "APPNUM2")
    @Basic
    public String getAppnum2() {
        return appnum2;
    }

    public void setAppnum2(String appnum2) {
        this.appnum2 = appnum2;
    }

    private String etidcd;

    @javax.persistence.Column(name = "ETIDCD")
    @Basic
    public String getEtidcd() {
        return etidcd;
    }

    public void setEtidcd(String etidcd) {
        this.etidcd = etidcd;
    }

    private String etidcd2;

    @javax.persistence.Column(name = "ETIDCD2")
    @Basic
    public String getEtidcd2() {
        return etidcd2;
    }

    public void setEtidcd2(String etidcd2) {
        this.etidcd2 = etidcd2;
    }

    private String rectyp;

    @javax.persistence.Column(name = "RECTYP")
    @Basic
    public String getRectyp() {
        return rectyp;
    }

    public void setRectyp(String rectyp) {
        this.rectyp = rectyp;
    }

    private String rectyp2;

    @javax.persistence.Column(name = "RECTYP2")
    @Basic
    public String getRectyp2() {
        return rectyp2;
    }

    public void setRectyp2(String rectyp2) {
        this.rectyp2 = rectyp2;
    }

    private String sntest;

    @javax.persistence.Column(name = "SNTEST")
    @Basic
    public String getSntest() {
        return sntest;
    }

    public void setSntest(String sntest) {
        this.sntest = sntest;
    }

    private String sntest2;

    @javax.persistence.Column(name = "SNTEST2")
    @Basic
    public String getSntest2() {
        return sntest2;
    }

    public void setSntest2(String sntest2) {
        this.sntest2 = sntest2;
    }

    private String deaddtc;

    @javax.persistence.Column(name = "DEADDTC")
    @Basic
    public String getDeaddtc() {
        return deaddtc;
    }

    public void setDeaddtc(String deaddtc) {
        this.deaddtc = deaddtc;
    }

    private String deaddtc2;

    @javax.persistence.Column(name = "DEADDTC2")
    @Basic
    public String getDeaddtc2() {
        return deaddtc2;
    }

    public void setDeaddtc2(String deaddtc2) {
        this.deaddtc2 = deaddtc2;
    }

    private String vamchfg;

    @javax.persistence.Column(name = "VAMCHFG")
    @Basic
    public String getVamchfg() {
        return vamchfg;
    }

    public void setVamchfg(String vamchfg) {
        this.vamchfg = vamchfg;
    }

    private String vamchfg2;

    @javax.persistence.Column(name = "VAMCHFG2")
    @Basic
    public String getVamchfg2() {
        return vamchfg2;
    }

    public void setVamchfg2(String vamchfg2) {
        this.vamchfg2 = vamchfg2;
    }

    private int cmpnum;

    @javax.persistence.Column(name = "CMPNUM")
    @Basic
    public int getCmpnum() {
        return cmpnum;
    }

    public void setCmpnum(int cmpnum) {
        this.cmpnum = cmpnum;
    }

    private int cmpnum2;

    @javax.persistence.Column(name = "CMPNUM2")
    @Basic
    public int getCmpnum2() {
        return cmpnum2;
    }

    public void setCmpnum2(int cmpnum2) {
        this.cmpnum2 = cmpnum2;
    }

    private int pdefc;

    @javax.persistence.Column(name = "PDEFC")
    @Basic
    public int getPdefc() {
        return pdefc;
    }

    public void setPdefc(int pdefc) {
        this.pdefc = pdefc;
    }

    private int pdefc2;

    @javax.persistence.Column(name = "PDEFC2")
    @Basic
    public int getPdefc2() {
        return pdefc2;
    }

    public void setPdefc2(int pdefc2) {
        this.pdefc2 = pdefc2;
    }

    private String efctpsc;

    @javax.persistence.Column(name = "EFCTPSC")
    @Basic
    public String getEfctpsc() {
        return efctpsc;
    }

    public void setEfctpsc(String efctpsc) {
        this.efctpsc = efctpsc;
    }

    private String efctpsc2;

    @javax.persistence.Column(name = "EFCTPSC2")
    @Basic
    public String getEfctpsc2() {
        return efctpsc2;
    }

    public void setEfctpsc2(String efctpsc2) {
        this.efctpsc2 = efctpsc2;
    }

    private int efcntwr;

    @javax.persistence.Column(name = "EFCNTWR")
    @Basic
    public int getEfcntwr() {
        return efcntwr;
    }

    public void setEfcntwr(int efcntwr) {
        this.efcntwr = efcntwr;
    }

    private int efcntwr2;

    @javax.persistence.Column(name = "EFCNTWR2")
    @Basic
    public int getEfcntwr2() {
        return efcntwr2;
    }

    public void setEfcntwr2(int efcntwr2) {
        this.efcntwr2 = efcntwr2;
    }

    private int sawtoti;

    @javax.persistence.Column(name = "SAWTOTI")
    @Basic
    public int getSawtoti() {
        return sawtoti;
    }

    public void setSawtoti(int sawtoti) {
        this.sawtoti = sawtoti;
    }

    private int sawtoti2;

    @javax.persistence.Column(name = "SAWTOTI2")
    @Basic
    public int getSawtoti2() {
        return sawtoti2;
    }

    public void setSawtoti2(int sawtoti2) {
        this.sawtoti2 = sawtoti2;
    }

    private int snetwth;

    @javax.persistence.Column(name = "SNETWTH")
    @Basic
    public int getSnetwth() {
        return snetwth;
    }

    public void setSnetwth(int snetwth) {
        this.snetwth = snetwth;
    }

    private int snetwth2;

    @javax.persistence.Column(name = "SNETWTH2")
    @Basic
    public int getSnetwth2() {
        return snetwth2;
    }

    public void setSnetwth2(int snetwth2) {
        this.snetwth2 = snetwth2;
    }

    private String dupdtc;

    @javax.persistence.Column(name = "DUPDTC")
    @Basic
    public String getDupdtc() {
        return dupdtc;
    }

    public void setDupdtc(String dupdtc) {
        this.dupdtc = dupdtc;
    }

    private String dupdtc2;

    @javax.persistence.Column(name = "DUPDTC2")
    @Basic
    public String getDupdtc2() {
        return dupdtc2;
    }

    public void setDupdtc2(String dupdtc2) {
        this.dupdtc2 = dupdtc2;
    }

    private String appsrcds;

    @javax.persistence.Column(name = "APPSRCDS")
    @Basic
    public String getAppsrcds() {
        return appsrcds;
    }

    public void setAppsrcds(String appsrcds) {
        this.appsrcds = appsrcds;
    }

    private String appnums;

    @javax.persistence.Column(name = "APPNUMS")
    @Basic
    public String getAppnums() {
        return appnums;
    }

    public void setAppnums(String appnums) {
        this.appnums = appnums;
    }

    private String etidcds;

    @javax.persistence.Column(name = "ETIDCDS")
    @Basic
    public String getEtidcds() {
        return etidcds;
    }

    public void setEtidcds(String etidcds) {
        this.etidcds = etidcds;
    }

    private String rectyps;

    @javax.persistence.Column(name = "RECTYPS")
    @Basic
    public String getRectyps() {
        return rectyps;
    }

    public void setRectyps(String rectyps) {
        this.rectyps = rectyps;
    }

    private String sntests;

    @javax.persistence.Column(name = "SNTESTS")
    @Basic
    public String getSntests() {
        return sntests;
    }

    public void setSntests(String sntests) {
        this.sntests = sntests;
    }

    private String deaddtcs;

    @javax.persistence.Column(name = "DEADDTCS")
    @Basic
    public String getDeaddtcs() {
        return deaddtcs;
    }

    public void setDeaddtcs(String deaddtcs) {
        this.deaddtcs = deaddtcs;
    }

    private String vamchfgs;

    @javax.persistence.Column(name = "VAMCHFGS")
    @Basic
    public String getVamchfgs() {
        return vamchfgs;
    }

    public void setVamchfgs(String vamchfgs) {
        this.vamchfgs = vamchfgs;
    }

    private String cmpnums;

    @javax.persistence.Column(name = "CMPNUMS")
    @Basic
    public String getCmpnums() {
        return cmpnums;
    }

    public void setCmpnums(String cmpnums) {
        this.cmpnums = cmpnums;
    }

    private String pdefcs;

    @javax.persistence.Column(name = "PDEFCS")
    @Basic
    public String getPdefcs() {
        return pdefcs;
    }

    public void setPdefcs(String pdefcs) {
        this.pdefcs = pdefcs;
    }

    private String efctpscs;

    @javax.persistence.Column(name = "EFCTPSCS")
    @Basic
    public String getEfctpscs() {
        return efctpscs;
    }

    public void setEfctpscs(String efctpscs) {
        this.efctpscs = efctpscs;
    }

    private String efcntwrs;

    @javax.persistence.Column(name = "EFCNTWRS")
    @Basic
    public String getEfcntwrs() {
        return efcntwrs;
    }

    public void setEfcntwrs(String efcntwrs) {
        this.efcntwrs = efcntwrs;
    }

    private String sawtotis;

    @javax.persistence.Column(name = "SAWTOTIS")
    @Basic
    public String getSawtotis() {
        return sawtotis;
    }

    public void setSawtotis(String sawtotis) {
        this.sawtotis = sawtotis;
    }

    private String snetwths;

    @javax.persistence.Column(name = "SNETWTHS")
    @Basic
    public String getSnetwths() {
        return snetwths;
    }

    public void setSnetwths(String snetwths) {
        this.snetwths = snetwths;
    }

    private String dupdtcs;

    @javax.persistence.Column(name = "DUPDTCS")
    @Basic
    public String getDupdtcs() {
        return dupdtcs;
    }

    public void setDupdtcs(String dupdtcs) {
        this.dupdtcs = dupdtcs;
    }

    private String verinbx;

    @javax.persistence.Column(name = "VERINBX")
    @Basic
    public String getVerinbx() {
        return verinbx;
    }

    public void setVerinbx(String verinbx) {
        this.verinbx = verinbx;
    }

    private String verinbx2;

    @javax.persistence.Column(name = "VERINBX2")
    @Basic
    public String getVerinbx2() {
        return verinbx2;
    }

    public void setVerinbx2(String verinbx2) {
        this.verinbx2 = verinbx2;
    }

    private int paidefc;

    @javax.persistence.Column(name = "PAIDEFC")
    @Basic
    public int getPaidefc() {
        return paidefc;
    }

    public void setPaidefc(int paidefc) {
        this.paidefc = paidefc;
    }

    private String sigdtes;

    @javax.persistence.Column(name = "SIGDTES")
    @Basic
    public String getSigdtes() {
        return sigdtes;
    }

    public void setSigdtes(String sigdtes) {
        this.sigdtes = sigdtes;
    }

    private String revises;

    @javax.persistence.Column(name = "REVISES")
    @Basic
    public String getRevises() {
        return revises;
    }

    public void setRevises(String revises) {
        this.revises = revises;
    }

    private String admflg2;

    @javax.persistence.Column(name = "ADMFLG2")
    @Basic
    public String getAdmflg2() {
        return admflg2;
    }

    public void setAdmflg2(String admflg2) {
        this.admflg2 = admflg2;
    }

    private String admflgs;

    @javax.persistence.Column(name = "ADMFLGS")
    @Basic
    public String getAdmflgs() {
        return admflgs;
    }

    public void setAdmflgs(String admflgs) {
        this.admflgs = admflgs;
    }

    private String sigs2;

    @javax.persistence.Column(name = "SIGS2")
    @Basic
    public String getSigs2() {
        return sigs2;
    }

    public void setSigs2(String sigs2) {
        this.sigs2 = sigs2;
    }

    private String sigss;

    @javax.persistence.Column(name = "SIGSS")
    @Basic
    public String getSigss() {
        return sigss;
    }

    public void setSigss(String sigss) {
        this.sigss = sigss;
    }

    private String inrctps;

    @javax.persistence.Column(name = "INRCTPS")
    @Basic
    public String getInrctps() {
        return inrctps;
    }

    public void setInrctps(String inrctps) {
        this.inrctps = inrctps;
    }

    private String inrctcs;

    @javax.persistence.Column(name = "INRCTCS")
    @Basic
    public String getInrctcs() {
        return inrctcs;
    }

    public void setInrctcs(String inrctcs) {
        this.inrctcs = inrctcs;
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

    private String corrsrc;

    @javax.persistence.Column(name = "CORRSRC")
    @Basic
    public String getCorrsrc() {
        return corrsrc;
    }

    public void setCorrsrc(String corrsrc) {
        this.corrsrc = corrsrc;
    }

    private String efcchgf;

    @javax.persistence.Column(name = "EFCCHGF")
    @Basic
    public String getEfcchgf() {
        return efcchgf;
    }

    public void setEfcchgf(String efcchgf) {
        this.efcchgf = efcchgf;
    }

    private String secinsf;

    @javax.persistence.Column(name = "SECINSF")
    @Basic
    public String getSecinsf() {
        return secinsf;
    }

    public void setSecinsf(String secinsf) {
        this.secinsf = secinsf;
    }

    private String dupssni;

    @javax.persistence.Column(name = "DUPSSNI")
    @Basic
    public String getDupssni() {
        return dupssni;
    }

    public void setDupssni(String dupssni) {
        this.dupssni = dupssni;
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

    private String depchd;

    @javax.persistence.Column(name = "DEPCHD")
    @Basic
    public String getDepchd() {
        return depchd;
    }

    public void setDepchd(String depchd) {
        this.depchd = depchd;
    }

    private String depchd2;

    @javax.persistence.Column(name = "DEPCHD2")
    @Basic
    public String getDepchd2() {
        return depchd2;
    }

    public void setDepchd2(String depchd2) {
        this.depchd2 = depchd2;
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

    private String rroverc;

    @javax.persistence.Column(name = "RROVERC")
    @Basic
    public String getRroverc() {
        return rroverc;
    }

    public void setRroverc(String rroverc) {
        this.rroverc = rroverc;
    }

    private String vtrkflg;

    @javax.persistence.Column(name = "VTRKFLG")
    @Basic
    public String getVtrkflg() {
        return vtrkflg;
    }

    public void setVtrkflg(String vtrkflg) {
        this.vtrkflg = vtrkflg;
    }

    private String applmth;

    @javax.persistence.Column(name = "APPLMTH")
    @Basic
    public String getApplmth() {
        return applmth;
    }

    public void setApplmth(String applmth) {
        this.applmth = applmth;
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

    private String rroverr;

    @javax.persistence.Column(name = "RROVERR")
    @Basic
    public String getRroverr() {
        return rroverr;
    }

    public void setRroverr(String rroverr) {
        this.rroverr = rroverr;
    }

    private String adochg;

    @javax.persistence.Column(name = "ADOCHG")
    @Basic
    public String getAdochg() {
        return adochg;
    }

    public void setAdochg(String adochg) {
        this.adochg = adochg;
    }

    private String cpspsh;

    @javax.persistence.Column(name = "CPSPSH")
    @Basic
    public String getCpspsh() {
        return cpspsh;
    }

    public void setCpspsh(String cpspsh) {
        this.cpspsh = cpspsh;
    }

    private String sarcchg;

    @javax.persistence.Column(name = "SARCCHG")
    @Basic
    public String getSarcchg() {
        return sarcchg;
    }

    public void setSarcchg(String sarcchg) {
        this.sarcchg = sarcchg;
    }

    private String vertfg;

    @javax.persistence.Column(name = "VERTFG")
    @Basic
    public String getVertfg() {
        return vertfg;
    }

    public void setVertfg(String vertfg) {
        this.vertfg = vertfg;
    }

    private String trnsrc;

    @javax.persistence.Column(name = "TRNSRC")
    @Basic
    public String getTrnsrc() {
        return trnsrc;
    }

    public void setTrnsrc(String trnsrc) {
        this.trnsrc = trnsrc;
    }

    private String apdtsc;

    @javax.persistence.Column(name = "APDTSC")
    @Basic
    public String getApdtsc() {
        return apdtsc;
    }

    public void setApdtsc(String apdtsc) {
        this.apdtsc = apdtsc;
    }

    private String etiflg;

    @javax.persistence.Column(name = "ETIFLG")
    @Basic
    public String getEtiflg() {
        return etiflg;
    }

    public void setEtiflg(String etiflg) {
        this.etiflg = etiflg;
    }

    private String sublimf;

    @javax.persistence.Column(name = "SUBLIMF")
    @Basic
    public String getSublimf() {
        return sublimf;
    }

    public void setSublimf(String sublimf) {
        this.sublimf = sublimf;
    }

    private String comlimf;

    @javax.persistence.Column(name = "COMLIMF")
    @Basic
    public String getComlimf() {
        return comlimf;
    }

    public void setComlimf(String comlimf) {
        this.comlimf = comlimf;
    }

    private String rrovers;

    @javax.persistence.Column(name = "RROVERS")
    @Basic
    public String getRrovers() {
        return rrovers;
    }

    public void setRrovers(String rrovers) {
        this.rrovers = rrovers;
    }

    private String rrovert;

    @javax.persistence.Column(name = "RROVERT")
    @Basic
    public String getRrovert() {
        return rrovert;
    }

    public void setRrovert(String rrovert) {
        this.rrovert = rrovert;
    }

    private String rrover3;

    @javax.persistence.Column(name = "RROVER3")
    @Basic
    public String getRrover3() {
        return rrover3;
    }

    public void setRrover3(String rrover3) {
        this.rrover3 = rrover3;
    }

    private String rrovr12;

    @javax.persistence.Column(name = "RROVR12")
    @Basic
    public String getRrovr12() {
        return rrovr12;
    }

    public void setRrovr12(String rrovr12) {
        this.rrovr12 = rrovr12;
    }

    private String rroverj;

    @javax.persistence.Column(name = "RROVERJ")
    @Basic
    public String getRroverj() {
        return rroverj;
    }

    public void setRroverj(String rroverj) {
        this.rroverj = rroverj;
    }

    private String rroverk;

    @javax.persistence.Column(name = "RROVERK")
    @Basic
    public String getRroverk() {
        return rroverk;
    }

    public void setRroverk(String rroverk) {
        this.rroverk = rroverk;
    }

    private String rrovere;

    @javax.persistence.Column(name = "RROVERE")
    @Basic
    public String getRrovere() {
        return rrovere;
    }

    public void setRrovere(String rrovere) {
        this.rrovere = rrovere;
    }

    private String rroverf;

    @javax.persistence.Column(name = "RROVERF")
    @Basic
    public String getRroverf() {
        return rroverf;
    }

    public void setRroverf(String rroverf) {
        this.rroverf = rroverf;
    }

    private String rejstcf;

    @javax.persistence.Column(name = "REJSTCF")
    @Basic
    public String getRejstcf() {
        return rejstcf;
    }

    public void setRejstcf(String rejstcf) {
        this.rejstcf = rejstcf;
    }

    private String verself;

    @javax.persistence.Column(name = "VERSELF")
    @Basic
    public String getVerself() {
        return verself;
    }

    public void setVerself(String verself) {
        this.verself = verself;
    }

    private String active;

    @javax.persistence.Column(name = "ACTIVE")
    @Basic
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    private String active2;

    @javax.persistence.Column(name = "ACTIVE2")
    @Basic
    public String getActive2() {
        return active2;
    }

    public void setActive2(String active2) {
        this.active2 = active2;
    }

    private String corfld2;

    @javax.persistence.Column(name = "CORFLD2")
    @Basic
    public String getCorfld2() {
        return corfld2;
    }

    public void setCorfld2(String corfld2) {
        this.corfld2 = corfld2;
    }

    private int efcsrej;

    @javax.persistence.Column(name = "EFCSREJ")
    @Basic
    public int getEfcsrej() {
        return efcsrej;
    }

    public void setEfcsrej(int efcsrej) {
        this.efcsrej = efcsrej;
    }

    private String campus7;

    @javax.persistence.Column(name = "CAMPUS7")
    @Basic
    public String getCampus7() {
        return campus7;
    }

    public void setCampus7(String campus7) {
        this.campus7 = campus7;
    }

    private String camps27;

    @javax.persistence.Column(name = "CAMPS27")
    @Basic
    public String getCamps27() {
        return camps27;
    }

    public void setCamps27(String camps27) {
        this.camps27 = camps27;
    }

    private String resgt7E;

    @javax.persistence.Column(name = "RESGT7E")
    @Basic
    public String getResgt7E() {
        return resgt7E;
    }

    public void setResgt7E(String resgt7E) {
        this.resgt7E = resgt7E;
    }

    private String shous7;

    @javax.persistence.Column(name = "SHOUS7")
    @Basic
    public String getShous7() {
        return shous7;
    }

    public void setShous7(String shous7) {
        this.shous7 = shous7;
    }

    private String shous27;

    @javax.persistence.Column(name = "SHOUS27")
    @Basic
    public String getShous27() {
        return shous27;
    }

    public void setShous27(String shous27) {
        this.shous27 = shous27;
    }

    private String hos7S;

    @javax.persistence.Column(name = "HOS7S")
    @Basic
    public String getHos7S() {
        return hos7S;
    }

    public void setHos7S(String hos7S) {
        this.hos7S = hos7S;
    }

    private String campus8;

    @javax.persistence.Column(name = "CAMPUS8")
    @Basic
    public String getCampus8() {
        return campus8;
    }

    public void setCampus8(String campus8) {
        this.campus8 = campus8;
    }

    private String camps28;

    @javax.persistence.Column(name = "CAMPS28")
    @Basic
    public String getCamps28() {
        return camps28;
    }

    public void setCamps28(String camps28) {
        this.camps28 = camps28;
    }

    private String resgt8E;

    @javax.persistence.Column(name = "RESGT8E")
    @Basic
    public String getResgt8E() {
        return resgt8E;
    }

    public void setResgt8E(String resgt8E) {
        this.resgt8E = resgt8E;
    }

    private String shous8;

    @javax.persistence.Column(name = "SHOUS8")
    @Basic
    public String getShous8() {
        return shous8;
    }

    public void setShous8(String shous8) {
        this.shous8 = shous8;
    }

    private String shous28;

    @javax.persistence.Column(name = "SHOUS28")
    @Basic
    public String getShous28() {
        return shous28;
    }

    public void setShous28(String shous28) {
        this.shous28 = shous28;
    }

    private String hos8S;

    @javax.persistence.Column(name = "HOS8S")
    @Basic
    public String getHos8S() {
        return hos8S;
    }

    public void setHos8S(String hos8S) {
        this.hos8S = hos8S;
    }

    private String campus9;

    @javax.persistence.Column(name = "CAMPUS9")
    @Basic
    public String getCampus9() {
        return campus9;
    }

    public void setCampus9(String campus9) {
        this.campus9 = campus9;
    }

    private String camps29;

    @javax.persistence.Column(name = "CAMPS29")
    @Basic
    public String getCamps29() {
        return camps29;
    }

    public void setCamps29(String camps29) {
        this.camps29 = camps29;
    }

    private String resgt9E;

    @javax.persistence.Column(name = "RESGT9E")
    @Basic
    public String getResgt9E() {
        return resgt9E;
    }

    public void setResgt9E(String resgt9E) {
        this.resgt9E = resgt9E;
    }

    private String shous9;

    @javax.persistence.Column(name = "SHOUS9")
    @Basic
    public String getShous9() {
        return shous9;
    }

    public void setShous9(String shous9) {
        this.shous9 = shous9;
    }

    private String shous29;

    @javax.persistence.Column(name = "SHOUS29")
    @Basic
    public String getShous29() {
        return shous29;
    }

    public void setShous29(String shous29) {
        this.shous29 = shous29;
    }

    private String hos9S;

    @javax.persistence.Column(name = "HOS9S")
    @Basic
    public String getHos9S() {
        return hos9S;
    }

    public void setHos9S(String hos9S) {
        this.hos9S = hos9S;
    }

    private String campusa;

    @javax.persistence.Column(name = "CAMPUSA")
    @Basic
    public String getCampusa() {
        return campusa;
    }

    public void setCampusa(String campusa) {
        this.campusa = campusa;
    }

    private String camps2A;

    @javax.persistence.Column(name = "CAMPS2A")
    @Basic
    public String getCamps2A() {
        return camps2A;
    }

    public void setCamps2A(String camps2A) {
        this.camps2A = camps2A;
    }

    private String resgtae;

    @javax.persistence.Column(name = "RESGTAE")
    @Basic
    public String getResgtae() {
        return resgtae;
    }

    public void setResgtae(String resgtae) {
        this.resgtae = resgtae;
    }

    private String shousa;

    @javax.persistence.Column(name = "SHOUSA")
    @Basic
    public String getShousa() {
        return shousa;
    }

    public void setShousa(String shousa) {
        this.shousa = shousa;
    }

    private String shous2A;

    @javax.persistence.Column(name = "SHOUS2A")
    @Basic
    public String getShous2A() {
        return shous2A;
    }

    public void setShous2A(String shous2A) {
        this.shous2A = shous2A;
    }

    private String hosas;

    @javax.persistence.Column(name = "HOSAS")
    @Basic
    public String getHosas() {
        return hosas;
    }

    public void setHosas(String hosas) {
        this.hosas = hosas;
    }

    private String rrover4;

    @javax.persistence.Column(name = "RROVER4")
    @Basic
    public String getRrover4() {
        return rrover4;
    }

    public void setRrover4(String rrover4) {
        this.rrover4 = rrover4;
    }

    private String rrovr20;

    @javax.persistence.Column(name = "RROVR20")
    @Basic
    public String getRrovr20() {
        return rrovr20;
    }

    public void setRrovr20(String rrovr20) {
        this.rrovr20 = rrovr20;
    }

    private String grsblim;

    @javax.persistence.Column(name = "GRSBLIM")
    @Basic
    public String getGrsblim() {
        return grsblim;
    }

    public void setGrsblim(String grsblim) {
        this.grsblim = grsblim;
    }

    private String grcmlim;

    @javax.persistence.Column(name = "GRCMLIM")
    @Basic
    public String getGrcmlim() {
        return grcmlim;
    }

    public void setGrcmlim(String grcmlim) {
        this.grcmlim = grcmlim;
    }

    private String esntdtc;

    @javax.persistence.Column(name = "ESNTDTC")
    @Basic
    public String getEsntdtc() {
        return esntdtc;
    }

    public void setEsntdtc(String esntdtc) {
        this.esntdtc = esntdtc;
    }

    private String corlddt;

    @javax.persistence.Column(name = "CORLDDT")
    @Basic
    public String getCorlddt() {
        return corlddt;
    }

    public void setCorlddt(String corlddt) {
        this.corlddt = corlddt;
    }

    private String mulprt2;

    @javax.persistence.Column(name = "MULPRT2")
    @Basic
    public String getMulprt2() {
        return mulprt2;
    }

    public void setMulprt2(String mulprt2) {
        this.mulprt2 = mulprt2;
    }

    private int l41Lev;

    @javax.persistence.Column(name = "L41LEV")
    @Basic
    public int getL41Lev() {
        return l41Lev;
    }

    public void setL41Lev(int l41Lev) {
        this.l41Lev = l41Lev;
    }

    private int sdivin2;

    @javax.persistence.Column(name = "SDIVIN2")
    @Basic
    public int getSdivin2() {
        return sdivin2;
    }

    public void setSdivin2(int sdivin2) {
        this.sdivin2 = sdivin2;
    }

    private String sdivins;

    @javax.persistence.Column(name = "SDIVINS")
    @Basic
    public String getSdivins() {
        return sdivins;
    }

    public void setSdivins(String sdivins) {
        this.sdivins = sdivins;
    }

    private String emancd;

    @javax.persistence.Column(name = "EMANCD")
    @Basic
    public String getEmancd() {
        return emancd;
    }

    public void setEmancd(String emancd) {
        this.emancd = emancd;
    }

    private String emancd2;

    @javax.persistence.Column(name = "EMANCD2")
    @Basic
    public String getEmancd2() {
        return emancd2;
    }

    public void setEmancd2(String emancd2) {
        this.emancd2 = emancd2;
    }

    private String emancds;

    @javax.persistence.Column(name = "EMANCDS")
    @Basic
    public String getEmancds() {
        return emancds;
    }

    public void setEmancds(String emancds) {
        this.emancds = emancds;
    }

    private String lggusp;

    @javax.persistence.Column(name = "LGGUSP")
    @Basic
    public String getLggusp() {
        return lggusp;
    }

    public void setLggusp(String lggusp) {
        this.lggusp = lggusp;
    }

    private String lggusp2;

    @javax.persistence.Column(name = "LGGUSP2")
    @Basic
    public String getLggusp2() {
        return lggusp2;
    }

    public void setLggusp2(String lggusp2) {
        this.lggusp2 = lggusp2;
    }

    private String lggusps;

    @javax.persistence.Column(name = "LGGUSPS")
    @Basic
    public String getLggusps() {
        return lggusps;
    }

    public void setLggusps(String lggusps) {
        this.lggusps = lggusps;
    }

    private String uaccsh;

    @javax.persistence.Column(name = "UACCSH")
    @Basic
    public String getUaccsh() {
        return uaccsh;
    }

    public void setUaccsh(String uaccsh) {
        this.uaccsh = uaccsh;
    }

    private String uaccsh2;

    @javax.persistence.Column(name = "UACCSH2")
    @Basic
    public String getUaccsh2() {
        return uaccsh2;
    }

    public void setUaccsh2(String uaccsh2) {
        this.uaccsh2 = uaccsh2;
    }

    private String uaccshs;

    @javax.persistence.Column(name = "UACCSHS")
    @Basic
    public String getUaccshs() {
        return uaccshs;
    }

    public void setUaccshs(String uaccshs) {
        this.uaccshs = uaccshs;
    }

    private String uacchd;

    @javax.persistence.Column(name = "UACCHD")
    @Basic
    public String getUacchd() {
        return uacchd;
    }

    public void setUacchd(String uacchd) {
        this.uacchd = uacchd;
    }

    private String uacchd2;

    @javax.persistence.Column(name = "UACCHD2")
    @Basic
    public String getUacchd2() {
        return uacchd2;
    }

    public void setUacchd2(String uacchd2) {
        this.uacchd2 = uacchd2;
    }

    private String uacchds;

    @javax.persistence.Column(name = "UACCHDS")
    @Basic
    public String getUacchds() {
        return uacchds;
    }

    public void setUacchds(String uacchds) {
        this.uacchds = uacchds;
    }

    private String spcrfg;

    @javax.persistence.Column(name = "SPCRFG")
    @Basic
    public String getSpcrfg() {
        return spcrfg;
    }

    public void setSpcrfg(String spcrfg) {
        this.spcrfg = spcrfg;
    }

    private String corfld3;

    @javax.persistence.Column(name = "CORFLD3")
    @Basic
    public String getCorfld3() {
        return corfld3;
    }

    public void setCorfld3(String corfld3) {
        this.corfld3 = corfld3;
    }

    private String dodmch;

    @javax.persistence.Column(name = "DODMCH")
    @Basic
    public String getDodmch() {
        return dodmch;
    }

    public void setDodmch(String dodmch) {
        this.dodmch = dodmch;
    }

    private String dodddt;

    @javax.persistence.Column(name = "DODDDT")
    @Basic
    public String getDodddt() {
        return dodddt;
    }

    public void setDodddt(String dodddt) {
        this.dodddt = dodddt;
    }

    private String nsldsrc;

    @javax.persistence.Column(name = "NSLDSRC")
    @Basic
    public String getNsldsrc() {
        return nsldsrc;
    }

    public void setNsldsrc(String nsldsrc) {
        this.nsldsrc = nsldsrc;
    }

    private String cssid;

    @javax.persistence.Column(name = "CSSID")
    @Basic
    public String getCssid() {
        return cssid;
    }

    public void setCssid(String cssid) {
        this.cssid = cssid;
    }

    private String uaccshc;

    @javax.persistence.Column(name = "UACCSHC")
    @Basic
    public String getUaccshc() {
        return uaccshc;
    }

    public void setUaccshc(String uaccshc) {
        this.uaccshc = uaccshc;
    }

    private String uacshcs;

    @javax.persistence.Column(name = "UACSHCS")
    @Basic
    public String getUacshcs() {
        return uacshcs;
    }

    public void setUacshcs(String uacshcs) {
        this.uacshcs = uacshcs;
    }

    private String uacchdc;

    @javax.persistence.Column(name = "UACCHDC")
    @Basic
    public String getUacchdc() {
        return uacchdc;
    }

    public void setUacchdc(String uacchdc) {
        this.uacchdc = uacchdc;
    }

    private String uachdcs;

    @javax.persistence.Column(name = "UACHDCS")
    @Basic
    public String getUachdcs() {
        return uachdcs;
    }

    public void setUachdcs(String uachdcs) {
        this.uachdcs = uachdcs;
    }

    private String rrovr21;

    @javax.persistence.Column(name = "RROVR21")
    @Basic
    public String getRrovr21() {
        return rrovr21;
    }

    public void setRrovr21(String rrovr21) {
        this.rrovr21 = rrovr21;
    }

    private String ahmlssc;

    @javax.persistence.Column(name = "AHMLSSC")
    @Basic
    public String getAhmlssc() {
        return ahmlssc;
    }

    public void setAhmlssc(String ahmlssc) {
        this.ahmlssc = ahmlssc;
    }

    private String ahmlshd;

    @javax.persistence.Column(name = "AHMLSHD")
    @Basic
    public String getAhmlshd() {
        return ahmlshd;
    }

    public void setAhmlshd(String ahmlshd) {
        this.ahmlshd = ahmlshd;
    }

    private String arskhml;

    @javax.persistence.Column(name = "ARSKHML")
    @Basic
    public String getArskhml() {
        return arskhml;
    }

    public void setArskhml(String arskhml) {
        this.arskhml = arskhml;
    }

    private String rjct01;

    @javax.persistence.Column(name = "RJCT01")
    @Basic
    public String getRjct01() {
        return rjct01;
    }

    public void setRjct01(String rjct01) {
        this.rjct01 = rjct01;
    }

    private String rjct02;

    @javax.persistence.Column(name = "RJCT02")
    @Basic
    public String getRjct02() {
        return rjct02;
    }

    public void setRjct02(String rjct02) {
        this.rjct02 = rjct02;
    }

    private String rjct03;

    @javax.persistence.Column(name = "RJCT03")
    @Basic
    public String getRjct03() {
        return rjct03;
    }

    public void setRjct03(String rjct03) {
        this.rjct03 = rjct03;
    }

    private String rjct04;

    @javax.persistence.Column(name = "RJCT04")
    @Basic
    public String getRjct04() {
        return rjct04;
    }

    public void setRjct04(String rjct04) {
        this.rjct04 = rjct04;
    }

    private String rjct05;

    @javax.persistence.Column(name = "RJCT05")
    @Basic
    public String getRjct05() {
        return rjct05;
    }

    public void setRjct05(String rjct05) {
        this.rjct05 = rjct05;
    }

    private String rjct06;

    @javax.persistence.Column(name = "RJCT06")
    @Basic
    public String getRjct06() {
        return rjct06;
    }

    public void setRjct06(String rjct06) {
        this.rjct06 = rjct06;
    }

    private String rjct07;

    @javax.persistence.Column(name = "RJCT07")
    @Basic
    public String getRjct07() {
        return rjct07;
    }

    public void setRjct07(String rjct07) {
        this.rjct07 = rjct07;
    }

    private String rjct08;

    @javax.persistence.Column(name = "RJCT08")
    @Basic
    public String getRjct08() {
        return rjct08;
    }

    public void setRjct08(String rjct08) {
        this.rjct08 = rjct08;
    }

    private String rjct09;

    @javax.persistence.Column(name = "RJCT09")
    @Basic
    public String getRjct09() {
        return rjct09;
    }

    public void setRjct09(String rjct09) {
        this.rjct09 = rjct09;
    }

    private String rjct10;

    @javax.persistence.Column(name = "RJCT10")
    @Basic
    public String getRjct10() {
        return rjct10;
    }

    public void setRjct10(String rjct10) {
        this.rjct10 = rjct10;
    }

    private String rjct11;

    @javax.persistence.Column(name = "RJCT11")
    @Basic
    public String getRjct11() {
        return rjct11;
    }

    public void setRjct11(String rjct11) {
        this.rjct11 = rjct11;
    }

    private String rjct12;

    @javax.persistence.Column(name = "RJCT12")
    @Basic
    public String getRjct12() {
        return rjct12;
    }

    public void setRjct12(String rjct12) {
        this.rjct12 = rjct12;
    }

    private String rjct13;

    @javax.persistence.Column(name = "RJCT13")
    @Basic
    public String getRjct13() {
        return rjct13;
    }

    public void setRjct13(String rjct13) {
        this.rjct13 = rjct13;
    }

    private String rjct14;

    @javax.persistence.Column(name = "RJCT14")
    @Basic
    public String getRjct14() {
        return rjct14;
    }

    public void setRjct14(String rjct14) {
        this.rjct14 = rjct14;
    }

    private String rjct15;

    @javax.persistence.Column(name = "RJCT15")
    @Basic
    public String getRjct15() {
        return rjct15;
    }

    public void setRjct15(String rjct15) {
        this.rjct15 = rjct15;
    }

    private String rjct16;

    @javax.persistence.Column(name = "RJCT16")
    @Basic
    public String getRjct16() {
        return rjct16;
    }

    public void setRjct16(String rjct16) {
        this.rjct16 = rjct16;
    }

    private String rjct17;

    @javax.persistence.Column(name = "RJCT17")
    @Basic
    public String getRjct17() {
        return rjct17;
    }

    public void setRjct17(String rjct17) {
        this.rjct17 = rjct17;
    }

    private String rjct18;

    @javax.persistence.Column(name = "RJCT18")
    @Basic
    public String getRjct18() {
        return rjct18;
    }

    public void setRjct18(String rjct18) {
        this.rjct18 = rjct18;
    }

    private String rjct19;

    @javax.persistence.Column(name = "RJCT19")
    @Basic
    public String getRjct19() {
        return rjct19;
    }

    public void setRjct19(String rjct19) {
        this.rjct19 = rjct19;
    }

    private String rjct20;

    @javax.persistence.Column(name = "RJCT20")
    @Basic
    public String getRjct20() {
        return rjct20;
    }

    public void setRjct20(String rjct20) {
        this.rjct20 = rjct20;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snb5Entity that = (Snb5Entity) o;

        if (cmpnum != that.cmpnum) return false;
        if (cmpnum2 != that.cmpnum2) return false;
        if (efcntwr != that.efcntwr) return false;
        if (efcntwr2 != that.efcntwr2) return false;
        if (efcsrej != that.efcsrej) return false;
        if (l41Lev != that.l41Lev) return false;
        if (paidefc != that.paidefc) return false;
        if (pdefc != that.pdefc) return false;
        if (pdefc2 != that.pdefc2) return false;
        if (sawtoti != that.sawtoti) return false;
        if (sawtoti2 != that.sawtoti2) return false;
        if (sdivin2 != that.sdivin2) return false;
        if (snetwth != that.snetwth) return false;
        if (snetwth2 != that.snetwth2) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (active2 != null ? !active2.equals(that.active2) : that.active2 != null) return false;
        if (admflg2 != null ? !admflg2.equals(that.admflg2) : that.admflg2 != null) return false;
        if (admflgs != null ? !admflgs.equals(that.admflgs) : that.admflgs != null) return false;
        if (adochg != null ? !adochg.equals(that.adochg) : that.adochg != null) return false;
        if (ahmlshd != null ? !ahmlshd.equals(that.ahmlshd) : that.ahmlshd != null) return false;
        if (ahmlssc != null ? !ahmlssc.equals(that.ahmlssc) : that.ahmlssc != null) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (apdtsc != null ? !apdtsc.equals(that.apdtsc) : that.apdtsc != null) return false;
        if (applmth != null ? !applmth.equals(that.applmth) : that.applmth != null) return false;
        if (appnum != null ? !appnum.equals(that.appnum) : that.appnum != null) return false;
        if (appnum2 != null ? !appnum2.equals(that.appnum2) : that.appnum2 != null) return false;
        if (appnums != null ? !appnums.equals(that.appnums) : that.appnums != null) return false;
        if (appsrcd != null ? !appsrcd.equals(that.appsrcd) : that.appsrcd != null) return false;
        if (appsrcd2 != null ? !appsrcd2.equals(that.appsrcd2) : that.appsrcd2 != null) return false;
        if (appsrcds != null ? !appsrcds.equals(that.appsrcds) : that.appsrcds != null) return false;
        if (arskhml != null ? !arskhml.equals(that.arskhml) : that.arskhml != null) return false;
        if (camps27 != null ? !camps27.equals(that.camps27) : that.camps27 != null) return false;
        if (camps28 != null ? !camps28.equals(that.camps28) : that.camps28 != null) return false;
        if (camps29 != null ? !camps29.equals(that.camps29) : that.camps29 != null) return false;
        if (camps2A != null ? !camps2A.equals(that.camps2A) : that.camps2A != null) return false;
        if (campus7 != null ? !campus7.equals(that.campus7) : that.campus7 != null) return false;
        if (campus8 != null ? !campus8.equals(that.campus8) : that.campus8 != null) return false;
        if (campus9 != null ? !campus9.equals(that.campus9) : that.campus9 != null) return false;
        if (campusa != null ? !campusa.equals(that.campusa) : that.campusa != null) return false;
        if (cmpnums != null ? !cmpnums.equals(that.cmpnums) : that.cmpnums != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (comlimf != null ? !comlimf.equals(that.comlimf) : that.comlimf != null) return false;
        if (corfld2 != null ? !corfld2.equals(that.corfld2) : that.corfld2 != null) return false;
        if (corfld3 != null ? !corfld3.equals(that.corfld3) : that.corfld3 != null) return false;
        if (corflds != null ? !corflds.equals(that.corflds) : that.corflds != null) return false;
        if (corlddt != null ? !corlddt.equals(that.corlddt) : that.corlddt != null) return false;
        if (corrsrc != null ? !corrsrc.equals(that.corrsrc) : that.corrsrc != null) return false;
        if (cpspsh != null ? !cpspsh.equals(that.cpspsh) : that.cpspsh != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (cssid != null ? !cssid.equals(that.cssid) : that.cssid != null) return false;
        if (deaddtc != null ? !deaddtc.equals(that.deaddtc) : that.deaddtc != null) return false;
        if (deaddtc2 != null ? !deaddtc2.equals(that.deaddtc2) : that.deaddtc2 != null) return false;
        if (deaddtcs != null ? !deaddtcs.equals(that.deaddtcs) : that.deaddtcs != null) return false;
        if (degobjs != null ? !degobjs.equals(that.degobjs) : that.degobjs != null) return false;
        if (depchd != null ? !depchd.equals(that.depchd) : that.depchd != null) return false;
        if (depchd2 != null ? !depchd2.equals(that.depchd2) : that.depchd2 != null) return false;
        if (dodddt != null ? !dodddt.equals(that.dodddt) : that.dodddt != null) return false;
        if (dodmch != null ? !dodmch.equals(that.dodmch) : that.dodmch != null) return false;
        if (dupdtc != null ? !dupdtc.equals(that.dupdtc) : that.dupdtc != null) return false;
        if (dupdtc2 != null ? !dupdtc2.equals(that.dupdtc2) : that.dupdtc2 != null) return false;
        if (dupdtcs != null ? !dupdtcs.equals(that.dupdtcs) : that.dupdtcs != null) return false;
        if (dupssni != null ? !dupssni.equals(that.dupssni) : that.dupssni != null) return false;
        if (efcchgf != null ? !efcchgf.equals(that.efcchgf) : that.efcchgf != null) return false;
        if (efcntwrs != null ? !efcntwrs.equals(that.efcntwrs) : that.efcntwrs != null) return false;
        if (efctpsc != null ? !efctpsc.equals(that.efctpsc) : that.efctpsc != null) return false;
        if (efctpsc2 != null ? !efctpsc2.equals(that.efctpsc2) : that.efctpsc2 != null) return false;
        if (efctpscs != null ? !efctpscs.equals(that.efctpscs) : that.efctpscs != null) return false;
        if (emancd != null ? !emancd.equals(that.emancd) : that.emancd != null) return false;
        if (emancd2 != null ? !emancd2.equals(that.emancd2) : that.emancd2 != null) return false;
        if (emancds != null ? !emancds.equals(that.emancds) : that.emancds != null) return false;
        if (esntdtc != null ? !esntdtc.equals(that.esntdtc) : that.esntdtc != null) return false;
        if (etidcd != null ? !etidcd.equals(that.etidcd) : that.etidcd != null) return false;
        if (etidcd2 != null ? !etidcd2.equals(that.etidcd2) : that.etidcd2 != null) return false;
        if (etidcds != null ? !etidcds.equals(that.etidcds) : that.etidcds != null) return false;
        if (etiflg != null ? !etiflg.equals(that.etiflg) : that.etiflg != null) return false;
        if (fmpnst != null ? !fmpnst.equals(that.fmpnst) : that.fmpnst != null) return false;
        if (fsigns != null ? !fsigns.equals(that.fsigns) : that.fsigns != null) return false;
        if (gradpros != null ? !gradpros.equals(that.gradpros) : that.gradpros != null) return false;
        if (grcmlim != null ? !grcmlim.equals(that.grcmlim) : that.grcmlim != null) return false;
        if (grsblim != null ? !grsblim.equals(that.grsblim) : that.grsblim != null) return false;
        if (hos1S != null ? !hos1S.equals(that.hos1S) : that.hos1S != null) return false;
        if (hos2S != null ? !hos2S.equals(that.hos2S) : that.hos2S != null) return false;
        if (hos3S != null ? !hos3S.equals(that.hos3S) : that.hos3S != null) return false;
        if (hos4S != null ? !hos4S.equals(that.hos4S) : that.hos4S != null) return false;
        if (hos5S != null ? !hos5S.equals(that.hos5S) : that.hos5S != null) return false;
        if (hos6S != null ? !hos6S.equals(that.hos6S) : that.hos6S != null) return false;
        if (hos7S != null ? !hos7S.equals(that.hos7S) : that.hos7S != null) return false;
        if (hos8S != null ? !hos8S.equals(that.hos8S) : that.hos8S != null) return false;
        if (hos9S != null ? !hos9S.equals(that.hos9S) : that.hos9S != null) return false;
        if (hosas != null ? !hosas.equals(that.hosas) : that.hosas != null) return false;
        if (inrctcs != null ? !inrctcs.equals(that.inrctcs) : that.inrctcs != null) return false;
        if (inrctps != null ? !inrctps.equals(that.inrctps) : that.inrctps != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (lendid != null ? !lendid.equals(that.lendid) : that.lendid != null) return false;
        if (lggusp != null ? !lggusp.equals(that.lggusp) : that.lggusp != null) return false;
        if (lggusp2 != null ? !lggusp2.equals(that.lggusp2) : that.lggusp2 != null) return false;
        if (lggusps != null ? !lggusps.equals(that.lggusps) : that.lggusps != null) return false;
        if (majors != null ? !majors.equals(that.majors) : that.majors != null) return false;
        if (mpnstat != null ? !mpnstat.equals(that.mpnstat) : that.mpnstat != null) return false;
        if (msigns != null ? !msigns.equals(that.msigns) : that.msigns != null) return false;
        if (mulprt2 != null ? !mulprt2.equals(that.mulprt2) : that.mulprt2 != null) return false;
        if (nsldsrc != null ? !nsldsrc.equals(that.nsldsrc) : that.nsldsrc != null) return false;
        if (pdefcs != null ? !pdefcs.equals(that.pdefcs) : that.pdefcs != null) return false;
        if (peins != null ? !peins.equals(that.peins) : that.peins != null) return false;
        if (plscrs != null ? !plscrs.equals(that.plscrs) : that.plscrs != null) return false;
        if (pmpnst != null ? !pmpnst.equals(that.pmpnst) : that.pmpnst != null) return false;
        if (presdtc != null ? !presdtc.equals(that.presdtc) : that.presdtc != null) return false;
        if (presdts != null ? !presdts.equals(that.presdts) : that.presdts != null) return false;
        if (press != null ? !press.equals(that.press) : that.press != null) return false;
        if (procesc != null ? !procesc.equals(that.procesc) : that.procesc != null) return false;
        if (prsdt2C != null ? !prsdt2C.equals(that.prsdt2C) : that.prsdt2C != null) return false;
        if (psigns != null ? !psigns.equals(that.psigns) : that.psigns != null) return false;
        if (pssns != null ? !pssns.equals(that.pssns) : that.pssns != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (rectyp != null ? !rectyp.equals(that.rectyp) : that.rectyp != null) return false;
        if (rectyp2 != null ? !rectyp2.equals(that.rectyp2) : that.rectyp2 != null) return false;
        if (rectyps != null ? !rectyps.equals(that.rectyps) : that.rectyps != null) return false;
        if (rejstcf != null ? !rejstcf.equals(that.rejstcf) : that.rejstcf != null) return false;
        if (relssts != null ? !relssts.equals(that.relssts) : that.relssts != null) return false;
        if (resgt7E != null ? !resgt7E.equals(that.resgt7E) : that.resgt7E != null) return false;
        if (resgt8E != null ? !resgt8E.equals(that.resgt8E) : that.resgt8E != null) return false;
        if (resgt9E != null ? !resgt9E.equals(that.resgt9E) : that.resgt9E != null) return false;
        if (resgtae != null ? !resgtae.equals(that.resgtae) : that.resgtae != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (revis1C != null ? !revis1C.equals(that.revis1C) : that.revis1C != null) return false;
        if (revis2C != null ? !revis2C.equals(that.revis2C) : that.revis2C != null) return false;
        if (revis3C != null ? !revis3C.equals(that.revis3C) : that.revis3C != null) return false;
        if (revis4C != null ? !revis4C.equals(that.revis4C) : that.revis4C != null) return false;
        if (revises != null ? !revises.equals(that.revises) : that.revises != null) return false;
        if (rjct01 != null ? !rjct01.equals(that.rjct01) : that.rjct01 != null) return false;
        if (rjct02 != null ? !rjct02.equals(that.rjct02) : that.rjct02 != null) return false;
        if (rjct03 != null ? !rjct03.equals(that.rjct03) : that.rjct03 != null) return false;
        if (rjct04 != null ? !rjct04.equals(that.rjct04) : that.rjct04 != null) return false;
        if (rjct05 != null ? !rjct05.equals(that.rjct05) : that.rjct05 != null) return false;
        if (rjct06 != null ? !rjct06.equals(that.rjct06) : that.rjct06 != null) return false;
        if (rjct07 != null ? !rjct07.equals(that.rjct07) : that.rjct07 != null) return false;
        if (rjct08 != null ? !rjct08.equals(that.rjct08) : that.rjct08 != null) return false;
        if (rjct09 != null ? !rjct09.equals(that.rjct09) : that.rjct09 != null) return false;
        if (rjct10 != null ? !rjct10.equals(that.rjct10) : that.rjct10 != null) return false;
        if (rjct11 != null ? !rjct11.equals(that.rjct11) : that.rjct11 != null) return false;
        if (rjct12 != null ? !rjct12.equals(that.rjct12) : that.rjct12 != null) return false;
        if (rjct13 != null ? !rjct13.equals(that.rjct13) : that.rjct13 != null) return false;
        if (rjct14 != null ? !rjct14.equals(that.rjct14) : that.rjct14 != null) return false;
        if (rjct15 != null ? !rjct15.equals(that.rjct15) : that.rjct15 != null) return false;
        if (rjct16 != null ? !rjct16.equals(that.rjct16) : that.rjct16 != null) return false;
        if (rjct17 != null ? !rjct17.equals(that.rjct17) : that.rjct17 != null) return false;
        if (rjct18 != null ? !rjct18.equals(that.rjct18) : that.rjct18 != null) return false;
        if (rjct19 != null ? !rjct19.equals(that.rjct19) : that.rjct19 != null) return false;
        if (rjct20 != null ? !rjct20.equals(that.rjct20) : that.rjct20 != null) return false;
        if (rrover3 != null ? !rrover3.equals(that.rrover3) : that.rrover3 != null) return false;
        if (rrover4 != null ? !rrover4.equals(that.rrover4) : that.rrover4 != null) return false;
        if (rroverc != null ? !rroverc.equals(that.rroverc) : that.rroverc != null) return false;
        if (rrovere != null ? !rrovere.equals(that.rrovere) : that.rrovere != null) return false;
        if (rroverf != null ? !rroverf.equals(that.rroverf) : that.rroverf != null) return false;
        if (rroverj != null ? !rroverj.equals(that.rroverj) : that.rroverj != null) return false;
        if (rroverk != null ? !rroverk.equals(that.rroverk) : that.rroverk != null) return false;
        if (rroverr != null ? !rroverr.equals(that.rroverr) : that.rroverr != null) return false;
        if (rrovers != null ? !rrovers.equals(that.rrovers) : that.rrovers != null) return false;
        if (rrovert != null ? !rrovert.equals(that.rrovert) : that.rrovert != null) return false;
        if (rrovr12 != null ? !rrovr12.equals(that.rrovr12) : that.rrovr12 != null) return false;
        if (rrovr20 != null ? !rrovr20.equals(that.rrovr20) : that.rrovr20 != null) return false;
        if (rrovr21 != null ? !rrovr21.equals(that.rrovr21) : that.rrovr21 != null) return false;
        if (saddrs != null ? !saddrs.equals(that.saddrs) : that.saddrs != null) return false;
        if (salnrs != null ? !salnrs.equals(that.salnrs) : that.salnrs != null) return false;
        if (samecos != null ? !samecos.equals(that.samecos) : that.samecos != null) return false;
        if (sarcchg != null ? !sarcchg.equals(that.sarcchg) : that.sarcchg != null) return false;
        if (sawtotis != null ? !sawtotis.equals(that.sawtotis) : that.sawtotis != null) return false;
        if (sbeginc != null ? !sbeginc.equals(that.sbeginc) : that.sbeginc != null) return false;
        if (sbirthc != null ? !sbirthc.equals(that.sbirthc) : that.sbirthc != null) return false;
        if (sbrth2C != null ? !sbrth2C.equals(that.sbrth2C) : that.sbrth2C != null) return false;
        if (sdivins != null ? !sdivins.equals(that.sdivins) : that.sdivins != null) return false;
        if (secinsf != null ? !secinsf.equals(that.secinsf) : that.secinsf != null) return false;
        if (sendc != null ? !sendc.equals(that.sendc) : that.sendc != null) return false;
        if (sexpg2C != null ? !sexpg2C.equals(that.sexpg2C) : that.sexpg2C != null) return false;
        if (sexpgrc != null ? !sexpgrc.equals(that.sexpgrc) : that.sexpgrc != null) return false;
        if (sexpgrs != null ? !sexpgrs.equals(that.sexpgrs) : that.sexpgrs != null) return false;
        if (shous27 != null ? !shous27.equals(that.shous27) : that.shous27 != null) return false;
        if (shous28 != null ? !shous28.equals(that.shous28) : that.shous28 != null) return false;
        if (shous29 != null ? !shous29.equals(that.shous29) : that.shous29 != null) return false;
        if (shous2A != null ? !shous2A.equals(that.shous2A) : that.shous2A != null) return false;
        if (shous7 != null ? !shous7.equals(that.shous7) : that.shous7 != null) return false;
        if (shous8 != null ? !shous8.equals(that.shous8) : that.shous8 != null) return false;
        if (shous9 != null ? !shous9.equals(that.shous9) : that.shous9 != null) return false;
        if (shousa != null ? !shousa.equals(that.shousa) : that.shousa != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (sigdt2C != null ? !sigdt2C.equals(that.sigdt2C) : that.sigdt2C != null) return false;
        if (sigdtec != null ? !sigdtec.equals(that.sigdtec) : that.sigdtec != null) return false;
        if (sigdtes != null ? !sigdtes.equals(that.sigdtes) : that.sigdtes != null) return false;
        if (sigs2 != null ? !sigs2.equals(that.sigs2) : that.sigs2 != null) return false;
        if (sigss != null ? !sigss.equals(that.sigss) : that.sigss != null) return false;
        if (slscrs != null ? !slscrs.equals(that.slscrs) : that.slscrs != null) return false;
        if (snbkey != null ? !snbkey.equals(that.snbkey) : that.snbkey != null) return false;
        if (snetwths != null ? !snetwths.equals(that.snetwths) : that.snetwths != null) return false;
        if (sntest != null ? !sntest.equals(that.sntest) : that.sntest != null) return false;
        if (sntest2 != null ? !sntest2.equals(that.sntest2) : that.sntest2 != null) return false;
        if (sntests != null ? !sntests.equals(that.sntests) : that.sntests != null) return false;
        if (spcrfg != null ? !spcrfg.equals(that.spcrfg) : that.spcrfg != null) return false;
        if (sphones != null ? !sphones.equals(that.sphones) : that.sphones != null) return false;
        if (spsigns != null ? !spsigns.equals(that.spsigns) : that.spsigns != null) return false;
        if (sresdtc != null ? !sresdtc.equals(that.sresdtc) : that.sresdtc != null) return false;
        if (sresdts != null ? !sresdts.equals(that.sresdts) : that.sresdts != null) return false;
        if (srsdt2C != null ? !srsdt2C.equals(that.srsdt2C) : that.srsdt2C != null) return false;
        if (ssregs != null ? !ssregs.equals(that.ssregs) : that.ssregs != null) return false;
        if (sublimf != null ? !sublimf.equals(that.sublimf) : that.sublimf != null) return false;
        if (trnsrc != null ? !trnsrc.equals(that.trnsrc) : that.trnsrc != null) return false;
        if (uacchd != null ? !uacchd.equals(that.uacchd) : that.uacchd != null) return false;
        if (uacchd2 != null ? !uacchd2.equals(that.uacchd2) : that.uacchd2 != null) return false;
        if (uacchdc != null ? !uacchdc.equals(that.uacchdc) : that.uacchdc != null) return false;
        if (uacchds != null ? !uacchds.equals(that.uacchds) : that.uacchds != null) return false;
        if (uaccsh != null ? !uaccsh.equals(that.uaccsh) : that.uaccsh != null) return false;
        if (uaccsh2 != null ? !uaccsh2.equals(that.uaccsh2) : that.uaccsh2 != null) return false;
        if (uaccshc != null ? !uaccshc.equals(that.uaccshc) : that.uaccshc != null) return false;
        if (uaccshs != null ? !uaccshs.equals(that.uaccshs) : that.uaccshs != null) return false;
        if (uachdcs != null ? !uachdcs.equals(that.uachdcs) : that.uachdcs != null) return false;
        if (uacshcs != null ? !uacshcs.equals(that.uacshcs) : that.uacshcs != null) return false;
        if (vamchfg != null ? !vamchfg.equals(that.vamchfg) : that.vamchfg != null) return false;
        if (vamchfg2 != null ? !vamchfg2.equals(that.vamchfg2) : that.vamchfg2 != null) return false;
        if (vamchfgs != null ? !vamchfgs.equals(that.vamchfgs) : that.vamchfgs != null) return false;
        if (verinbx != null ? !verinbx.equals(that.verinbx) : that.verinbx != null) return false;
        if (verinbx2 != null ? !verinbx2.equals(that.verinbx2) : that.verinbx2 != null) return false;
        if (verself != null ? !verself.equals(that.verself) : that.verself != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;
        if (vertfg != null ? !vertfg.equals(that.vertfg) : that.vertfg != null) return false;
        if (vtrkflg != null ? !vtrkflg.equals(that.vtrkflg) : that.vtrkflg != null) return false;
        if (wsscrs != null ? !wsscrs.equals(that.wsscrs) : that.wsscrs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snbkey != null ? snbkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cmptype != null ? cmptype.hashCode() : 0);
        result = 31 * result + (versnr != null ? versnr.hashCode() : 0);
        result = 31 * result + (corflds != null ? corflds.hashCode() : 0);
        result = 31 * result + (saddrs != null ? saddrs.hashCode() : 0);
        result = 31 * result + (sphones != null ? sphones.hashCode() : 0);
        result = 31 * result + (sresdts != null ? sresdts.hashCode() : 0);
        result = 31 * result + (salnrs != null ? salnrs.hashCode() : 0);
        result = 31 * result + (ssregs != null ? ssregs.hashCode() : 0);
        result = 31 * result + (majors != null ? majors.hashCode() : 0);
        result = 31 * result + (degobjs != null ? degobjs.hashCode() : 0);
        result = 31 * result + (sexpgrs != null ? sexpgrs.hashCode() : 0);
        result = 31 * result + (samecos != null ? samecos.hashCode() : 0);
        result = 31 * result + (presdts != null ? presdts.hashCode() : 0);
        result = 31 * result + (press != null ? press.hashCode() : 0);
        result = 31 * result + (spsigns != null ? spsigns.hashCode() : 0);
        result = 31 * result + (fsigns != null ? fsigns.hashCode() : 0);
        result = 31 * result + (msigns != null ? msigns.hashCode() : 0);
        result = 31 * result + (wsscrs != null ? wsscrs.hashCode() : 0);
        result = 31 * result + (slscrs != null ? slscrs.hashCode() : 0);
        result = 31 * result + (plscrs != null ? plscrs.hashCode() : 0);
        result = 31 * result + (relssts != null ? relssts.hashCode() : 0);
        result = 31 * result + (peins != null ? peins.hashCode() : 0);
        result = 31 * result + (pssns != null ? pssns.hashCode() : 0);
        result = 31 * result + (psigns != null ? psigns.hashCode() : 0);
        result = 31 * result + (hos1S != null ? hos1S.hashCode() : 0);
        result = 31 * result + (hos2S != null ? hos2S.hashCode() : 0);
        result = 31 * result + (hos3S != null ? hos3S.hashCode() : 0);
        result = 31 * result + (hos4S != null ? hos4S.hashCode() : 0);
        result = 31 * result + (hos5S != null ? hos5S.hashCode() : 0);
        result = 31 * result + (hos6S != null ? hos6S.hashCode() : 0);
        result = 31 * result + (gradpros != null ? gradpros.hashCode() : 0);
        result = 31 * result + (sresdtc != null ? sresdtc.hashCode() : 0);
        result = 31 * result + (srsdt2C != null ? srsdt2C.hashCode() : 0);
        result = 31 * result + (presdtc != null ? presdtc.hashCode() : 0);
        result = 31 * result + (prsdt2C != null ? prsdt2C.hashCode() : 0);
        result = 31 * result + (sexpgrc != null ? sexpgrc.hashCode() : 0);
        result = 31 * result + (sexpg2C != null ? sexpg2C.hashCode() : 0);
        result = 31 * result + (sbeginc != null ? sbeginc.hashCode() : 0);
        result = 31 * result + (sendc != null ? sendc.hashCode() : 0);
        result = 31 * result + (sigdtec != null ? sigdtec.hashCode() : 0);
        result = 31 * result + (sbirthc != null ? sbirthc.hashCode() : 0);
        result = 31 * result + (sbrth2C != null ? sbrth2C.hashCode() : 0);
        result = 31 * result + (sigdt2C != null ? sigdt2C.hashCode() : 0);
        result = 31 * result + (procesc != null ? procesc.hashCode() : 0);
        result = 31 * result + (revis1C != null ? revis1C.hashCode() : 0);
        result = 31 * result + (revis2C != null ? revis2C.hashCode() : 0);
        result = 31 * result + (revis3C != null ? revis3C.hashCode() : 0);
        result = 31 * result + (revis4C != null ? revis4C.hashCode() : 0);
        result = 31 * result + (appsrcd != null ? appsrcd.hashCode() : 0);
        result = 31 * result + (appsrcd2 != null ? appsrcd2.hashCode() : 0);
        result = 31 * result + (appnum != null ? appnum.hashCode() : 0);
        result = 31 * result + (appnum2 != null ? appnum2.hashCode() : 0);
        result = 31 * result + (etidcd != null ? etidcd.hashCode() : 0);
        result = 31 * result + (etidcd2 != null ? etidcd2.hashCode() : 0);
        result = 31 * result + (rectyp != null ? rectyp.hashCode() : 0);
        result = 31 * result + (rectyp2 != null ? rectyp2.hashCode() : 0);
        result = 31 * result + (sntest != null ? sntest.hashCode() : 0);
        result = 31 * result + (sntest2 != null ? sntest2.hashCode() : 0);
        result = 31 * result + (deaddtc != null ? deaddtc.hashCode() : 0);
        result = 31 * result + (deaddtc2 != null ? deaddtc2.hashCode() : 0);
        result = 31 * result + (vamchfg != null ? vamchfg.hashCode() : 0);
        result = 31 * result + (vamchfg2 != null ? vamchfg2.hashCode() : 0);
        result = 31 * result + cmpnum;
        result = 31 * result + cmpnum2;
        result = 31 * result + pdefc;
        result = 31 * result + pdefc2;
        result = 31 * result + (efctpsc != null ? efctpsc.hashCode() : 0);
        result = 31 * result + (efctpsc2 != null ? efctpsc2.hashCode() : 0);
        result = 31 * result + efcntwr;
        result = 31 * result + efcntwr2;
        result = 31 * result + sawtoti;
        result = 31 * result + sawtoti2;
        result = 31 * result + snetwth;
        result = 31 * result + snetwth2;
        result = 31 * result + (dupdtc != null ? dupdtc.hashCode() : 0);
        result = 31 * result + (dupdtc2 != null ? dupdtc2.hashCode() : 0);
        result = 31 * result + (appsrcds != null ? appsrcds.hashCode() : 0);
        result = 31 * result + (appnums != null ? appnums.hashCode() : 0);
        result = 31 * result + (etidcds != null ? etidcds.hashCode() : 0);
        result = 31 * result + (rectyps != null ? rectyps.hashCode() : 0);
        result = 31 * result + (sntests != null ? sntests.hashCode() : 0);
        result = 31 * result + (deaddtcs != null ? deaddtcs.hashCode() : 0);
        result = 31 * result + (vamchfgs != null ? vamchfgs.hashCode() : 0);
        result = 31 * result + (cmpnums != null ? cmpnums.hashCode() : 0);
        result = 31 * result + (pdefcs != null ? pdefcs.hashCode() : 0);
        result = 31 * result + (efctpscs != null ? efctpscs.hashCode() : 0);
        result = 31 * result + (efcntwrs != null ? efcntwrs.hashCode() : 0);
        result = 31 * result + (sawtotis != null ? sawtotis.hashCode() : 0);
        result = 31 * result + (snetwths != null ? snetwths.hashCode() : 0);
        result = 31 * result + (dupdtcs != null ? dupdtcs.hashCode() : 0);
        result = 31 * result + (verinbx != null ? verinbx.hashCode() : 0);
        result = 31 * result + (verinbx2 != null ? verinbx2.hashCode() : 0);
        result = 31 * result + paidefc;
        result = 31 * result + (sigdtes != null ? sigdtes.hashCode() : 0);
        result = 31 * result + (revises != null ? revises.hashCode() : 0);
        result = 31 * result + (admflg2 != null ? admflg2.hashCode() : 0);
        result = 31 * result + (admflgs != null ? admflgs.hashCode() : 0);
        result = 31 * result + (sigs2 != null ? sigs2.hashCode() : 0);
        result = 31 * result + (sigss != null ? sigss.hashCode() : 0);
        result = 31 * result + (inrctps != null ? inrctps.hashCode() : 0);
        result = 31 * result + (inrctcs != null ? inrctcs.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        result = 31 * result + (corrsrc != null ? corrsrc.hashCode() : 0);
        result = 31 * result + (efcchgf != null ? efcchgf.hashCode() : 0);
        result = 31 * result + (secinsf != null ? secinsf.hashCode() : 0);
        result = 31 * result + (dupssni != null ? dupssni.hashCode() : 0);
        result = 31 * result + (mpnstat != null ? mpnstat.hashCode() : 0);
        result = 31 * result + (fmpnst != null ? fmpnst.hashCode() : 0);
        result = 31 * result + (depchd != null ? depchd.hashCode() : 0);
        result = 31 * result + (depchd2 != null ? depchd2.hashCode() : 0);
        result = 31 * result + (lendid != null ? lendid.hashCode() : 0);
        result = 31 * result + (rroverc != null ? rroverc.hashCode() : 0);
        result = 31 * result + (vtrkflg != null ? vtrkflg.hashCode() : 0);
        result = 31 * result + (applmth != null ? applmth.hashCode() : 0);
        result = 31 * result + (pmpnst != null ? pmpnst.hashCode() : 0);
        result = 31 * result + (rroverr != null ? rroverr.hashCode() : 0);
        result = 31 * result + (adochg != null ? adochg.hashCode() : 0);
        result = 31 * result + (cpspsh != null ? cpspsh.hashCode() : 0);
        result = 31 * result + (sarcchg != null ? sarcchg.hashCode() : 0);
        result = 31 * result + (vertfg != null ? vertfg.hashCode() : 0);
        result = 31 * result + (trnsrc != null ? trnsrc.hashCode() : 0);
        result = 31 * result + (apdtsc != null ? apdtsc.hashCode() : 0);
        result = 31 * result + (etiflg != null ? etiflg.hashCode() : 0);
        result = 31 * result + (sublimf != null ? sublimf.hashCode() : 0);
        result = 31 * result + (comlimf != null ? comlimf.hashCode() : 0);
        result = 31 * result + (rrovers != null ? rrovers.hashCode() : 0);
        result = 31 * result + (rrovert != null ? rrovert.hashCode() : 0);
        result = 31 * result + (rrover3 != null ? rrover3.hashCode() : 0);
        result = 31 * result + (rrovr12 != null ? rrovr12.hashCode() : 0);
        result = 31 * result + (rroverj != null ? rroverj.hashCode() : 0);
        result = 31 * result + (rroverk != null ? rroverk.hashCode() : 0);
        result = 31 * result + (rrovere != null ? rrovere.hashCode() : 0);
        result = 31 * result + (rroverf != null ? rroverf.hashCode() : 0);
        result = 31 * result + (rejstcf != null ? rejstcf.hashCode() : 0);
        result = 31 * result + (verself != null ? verself.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (active2 != null ? active2.hashCode() : 0);
        result = 31 * result + (corfld2 != null ? corfld2.hashCode() : 0);
        result = 31 * result + efcsrej;
        result = 31 * result + (campus7 != null ? campus7.hashCode() : 0);
        result = 31 * result + (camps27 != null ? camps27.hashCode() : 0);
        result = 31 * result + (resgt7E != null ? resgt7E.hashCode() : 0);
        result = 31 * result + (shous7 != null ? shous7.hashCode() : 0);
        result = 31 * result + (shous27 != null ? shous27.hashCode() : 0);
        result = 31 * result + (hos7S != null ? hos7S.hashCode() : 0);
        result = 31 * result + (campus8 != null ? campus8.hashCode() : 0);
        result = 31 * result + (camps28 != null ? camps28.hashCode() : 0);
        result = 31 * result + (resgt8E != null ? resgt8E.hashCode() : 0);
        result = 31 * result + (shous8 != null ? shous8.hashCode() : 0);
        result = 31 * result + (shous28 != null ? shous28.hashCode() : 0);
        result = 31 * result + (hos8S != null ? hos8S.hashCode() : 0);
        result = 31 * result + (campus9 != null ? campus9.hashCode() : 0);
        result = 31 * result + (camps29 != null ? camps29.hashCode() : 0);
        result = 31 * result + (resgt9E != null ? resgt9E.hashCode() : 0);
        result = 31 * result + (shous9 != null ? shous9.hashCode() : 0);
        result = 31 * result + (shous29 != null ? shous29.hashCode() : 0);
        result = 31 * result + (hos9S != null ? hos9S.hashCode() : 0);
        result = 31 * result + (campusa != null ? campusa.hashCode() : 0);
        result = 31 * result + (camps2A != null ? camps2A.hashCode() : 0);
        result = 31 * result + (resgtae != null ? resgtae.hashCode() : 0);
        result = 31 * result + (shousa != null ? shousa.hashCode() : 0);
        result = 31 * result + (shous2A != null ? shous2A.hashCode() : 0);
        result = 31 * result + (hosas != null ? hosas.hashCode() : 0);
        result = 31 * result + (rrover4 != null ? rrover4.hashCode() : 0);
        result = 31 * result + (rrovr20 != null ? rrovr20.hashCode() : 0);
        result = 31 * result + (grsblim != null ? grsblim.hashCode() : 0);
        result = 31 * result + (grcmlim != null ? grcmlim.hashCode() : 0);
        result = 31 * result + (esntdtc != null ? esntdtc.hashCode() : 0);
        result = 31 * result + (corlddt != null ? corlddt.hashCode() : 0);
        result = 31 * result + (mulprt2 != null ? mulprt2.hashCode() : 0);
        result = 31 * result + l41Lev;
        result = 31 * result + sdivin2;
        result = 31 * result + (sdivins != null ? sdivins.hashCode() : 0);
        result = 31 * result + (emancd != null ? emancd.hashCode() : 0);
        result = 31 * result + (emancd2 != null ? emancd2.hashCode() : 0);
        result = 31 * result + (emancds != null ? emancds.hashCode() : 0);
        result = 31 * result + (lggusp != null ? lggusp.hashCode() : 0);
        result = 31 * result + (lggusp2 != null ? lggusp2.hashCode() : 0);
        result = 31 * result + (lggusps != null ? lggusps.hashCode() : 0);
        result = 31 * result + (uaccsh != null ? uaccsh.hashCode() : 0);
        result = 31 * result + (uaccsh2 != null ? uaccsh2.hashCode() : 0);
        result = 31 * result + (uaccshs != null ? uaccshs.hashCode() : 0);
        result = 31 * result + (uacchd != null ? uacchd.hashCode() : 0);
        result = 31 * result + (uacchd2 != null ? uacchd2.hashCode() : 0);
        result = 31 * result + (uacchds != null ? uacchds.hashCode() : 0);
        result = 31 * result + (spcrfg != null ? spcrfg.hashCode() : 0);
        result = 31 * result + (corfld3 != null ? corfld3.hashCode() : 0);
        result = 31 * result + (dodmch != null ? dodmch.hashCode() : 0);
        result = 31 * result + (dodddt != null ? dodddt.hashCode() : 0);
        result = 31 * result + (nsldsrc != null ? nsldsrc.hashCode() : 0);
        result = 31 * result + (cssid != null ? cssid.hashCode() : 0);
        result = 31 * result + (uaccshc != null ? uaccshc.hashCode() : 0);
        result = 31 * result + (uacshcs != null ? uacshcs.hashCode() : 0);
        result = 31 * result + (uacchdc != null ? uacchdc.hashCode() : 0);
        result = 31 * result + (uachdcs != null ? uachdcs.hashCode() : 0);
        result = 31 * result + (rrovr21 != null ? rrovr21.hashCode() : 0);
        result = 31 * result + (ahmlssc != null ? ahmlssc.hashCode() : 0);
        result = 31 * result + (ahmlshd != null ? ahmlshd.hashCode() : 0);
        result = 31 * result + (arskhml != null ? arskhml.hashCode() : 0);
        result = 31 * result + (rjct01 != null ? rjct01.hashCode() : 0);
        result = 31 * result + (rjct02 != null ? rjct02.hashCode() : 0);
        result = 31 * result + (rjct03 != null ? rjct03.hashCode() : 0);
        result = 31 * result + (rjct04 != null ? rjct04.hashCode() : 0);
        result = 31 * result + (rjct05 != null ? rjct05.hashCode() : 0);
        result = 31 * result + (rjct06 != null ? rjct06.hashCode() : 0);
        result = 31 * result + (rjct07 != null ? rjct07.hashCode() : 0);
        result = 31 * result + (rjct08 != null ? rjct08.hashCode() : 0);
        result = 31 * result + (rjct09 != null ? rjct09.hashCode() : 0);
        result = 31 * result + (rjct10 != null ? rjct10.hashCode() : 0);
        result = 31 * result + (rjct11 != null ? rjct11.hashCode() : 0);
        result = 31 * result + (rjct12 != null ? rjct12.hashCode() : 0);
        result = 31 * result + (rjct13 != null ? rjct13.hashCode() : 0);
        result = 31 * result + (rjct14 != null ? rjct14.hashCode() : 0);
        result = 31 * result + (rjct15 != null ? rjct15.hashCode() : 0);
        result = 31 * result + (rjct16 != null ? rjct16.hashCode() : 0);
        result = 31 * result + (rjct17 != null ? rjct17.hashCode() : 0);
        result = 31 * result + (rjct18 != null ? rjct18.hashCode() : 0);
        result = 31 * result + (rjct19 != null ? rjct19.hashCode() : 0);
        result = 31 * result + (rjct20 != null ? rjct20.hashCode() : 0);
        return result;
    }
}
