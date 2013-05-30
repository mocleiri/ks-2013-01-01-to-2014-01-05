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
 * Time: 12:10 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNP4", schema = "SIGMA", catalog = "")
@Entity
public class Snp4Entity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnpkey();
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

    private String snpkey;

    @javax.persistence.Column(name = "SNPKEY")
    @Id
    public String getSnpkey() {
        return snpkey;
    }

    public void setSnpkey(String snpkey) {
        this.snpkey = snpkey;
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

    private String pmartls;

    @javax.persistence.Column(name = "PMARTLS")
    @Basic
    public String getPmartls() {
        return pmartls;
    }

    public void setPmartls(String pmartls) {
        this.pmartls = pmartls;
    }

    private String pfedlvls;

    @javax.persistence.Column(name = "PFEDLVLS")
    @Basic
    public String getPfedlvls() {
        return pfedlvls;
    }

    public void setPfedlvls(String pfedlvls) {
        this.pfedlvls = pfedlvls;
    }

    private String pmedlvls;

    @javax.persistence.Column(name = "PMEDLVLS")
    @Basic
    public String getPmedlvls() {
        return pmedlvls;
    }

    public void setPmedlvls(String pmedlvls) {
        this.pmedlvls = pmedlvls;
    }

    private String pages;

    @javax.persistence.Column(name = "PAGES")
    @Basic
    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    private String pszhhds;

    @javax.persistence.Column(name = "PSZHHDS")
    @Basic
    public String getPszhhds() {
        return pszhhds;
    }

    public void setPszhhds(String pszhhds) {
        this.pszhhds = pszhhds;
    }

    private String pexemps;

    @javax.persistence.Column(name = "PEXEMPS")
    @Basic
    public String getPexemps() {
        return pexemps;
    }

    public void setPexemps(String pexemps) {
        this.pexemps = pexemps;
    }

    private String pnrpss;

    @javax.persistence.Column(name = "PNRPSS")
    @Basic
    public String getPnrpss() {
        return pnrpss;
    }

    public void setPnrpss(String pnrpss) {
        this.pnrpss = pnrpss;
    }

    private String pincols;

    @javax.persistence.Column(name = "PINCOLS")
    @Basic
    public String getPincols() {
        return pincols;
    }

    public void setPincols(String pincols) {
        this.pincols = pincols;
    }

    private String pdiswks;

    @javax.persistence.Column(name = "PDISWKS")
    @Basic
    public String getPdiswks() {
        return pdiswks;
    }

    public void setPdiswks(String pdiswks) {
        this.pdiswks = pdiswks;
    }

    private String pdishms;

    @javax.persistence.Column(name = "PDISHMS")
    @Basic
    public String getPdishms() {
        return pdishms;
    }

    public void setPdishms(String pdishms) {
        this.pdishms = pdishms;
    }

    private String ptrfils;

    @javax.persistence.Column(name = "PTRFILS")
    @Basic
    public String getPtrfils() {
        return ptrfils;
    }

    public void setPtrfils(String ptrfils) {
        this.ptrfils = ptrfils;
    }

    private String pfwags;

    @javax.persistence.Column(name = "PFWAGS")
    @Basic
    public String getPfwags() {
        return pfwags;
    }

    public void setPfwags(String pfwags) {
        this.pfwags = pfwags;
    }

    private String pmwags;

    @javax.persistence.Column(name = "PMWAGS")
    @Basic
    public String getPmwags() {
        return pmwags;
    }

    public void setPmwags(String pmwags) {
        this.pmwags = pmwags;
    }

    private String padjws;

    @javax.persistence.Column(name = "PADJWS")
    @Basic
    public String getPadjws() {
        return padjws;
    }

    public void setPadjws(String padjws) {
        this.padjws = padjws;
    }

    private String pwags;

    @javax.persistence.Column(name = "PWAGS")
    @Basic
    public String getPwags() {
        return pwags;
    }

    public void setPwags(String pwags) {
        this.pwags = pwags;
    }

    private String pints;

    @javax.persistence.Column(name = "PINTS")
    @Basic
    public String getPints() {
        return pints;
    }

    public void setPints(String pints) {
        this.pints = pints;
    }

    private String pdivs;

    @javax.persistence.Column(name = "PDIVS")
    @Basic
    public String getPdivs() {
        return pdivs;
    }

    public void setPdivs(String pdivs) {
        this.pdivs = pdivs;
    }

    private String pbfris;

    @javax.persistence.Column(name = "PBFRIS")
    @Basic
    public String getPbfris() {
        return pbfris;
    }

    public void setPbfris(String pbfris) {
        this.pbfris = pbfris;
    }

    private String potis;

    @javax.persistence.Column(name = "POTIS")
    @Basic
    public String getPotis() {
        return potis;
    }

    public void setPotis(String potis) {
        this.potis = potis;
    }

    private String pbexs;

    @javax.persistence.Column(name = "PBEXS")
    @Basic
    public String getPbexs() {
        return pbexs;
    }

    public void setPbexs(String pbexs) {
        this.pbexs = pbexs;
    }

    private String padjs;

    @javax.persistence.Column(name = "PADJS")
    @Basic
    public String getPadjs() {
        return padjs;
    }

    public void setPadjs(String padjs) {
        this.padjs = padjs;
    }

    private String pttincs;

    @javax.persistence.Column(name = "PTTINCS")
    @Basic
    public String getPttincs() {
        return pttincs;
    }

    public void setPttincs(String pttincs) {
        this.pttincs = pttincs;
    }

    private String pagirs;

    @javax.persistence.Column(name = "PAGIRS")
    @Basic
    public String getPagirs() {
        return pagirs;
    }

    public void setPagirs(String pagirs) {
        this.pagirs = pagirs;
    }

    private String psss;

    @javax.persistence.Column(name = "PSSS")
    @Basic
    public String getPsss() {
        return psss;
    }

    public void setPsss(String psss) {
        this.psss = psss;
    }

    private String padcs;

    @javax.persistence.Column(name = "PADCS")
    @Basic
    public String getPadcs() {
        return padcs;
    }

    public void setPadcs(String padcs) {
        this.padcs = padcs;
    }

    private String pntcss;

    @javax.persistence.Column(name = "PNTCSS")
    @Basic
    public String getPntcss() {
        return pntcss;
    }

    public void setPntcss(String pntcss) {
        this.pntcss = pntcss;
    }

    private String pontis;

    @javax.persistence.Column(name = "PONTIS")
    @Basic
    public String getPontis() {
        return pontis;
    }

    public void setPontis(String pontis) {
        this.pontis = pontis;
    }

    private String pinca1S;

    @javax.persistence.Column(name = "PINCA1S")
    @Basic
    public String getPinca1S() {
        return pinca1S;
    }

    public void setPinca1S(String pinca1S) {
        this.pinca1S = pinca1S;
    }

    private String pinca2S;

    @javax.persistence.Column(name = "PINCA2S")
    @Basic
    public String getPinca2S() {
        return pinca2S;
    }

    public void setPinca2S(String pinca2S) {
        this.pinca2S = pinca2S;
    }

    private String ptincs;

    @javax.persistence.Column(name = "PTINCS")
    @Basic
    public String getPtincs() {
        return ptincs;
    }

    public void setPtincs(String ptincs) {
        this.ptincs = ptincs;
    }

    private String pdeds;

    @javax.persistence.Column(name = "PDEDS")
    @Basic
    public String getPdeds() {
        return pdeds;
    }

    public void setPdeds(String pdeds) {
        this.pdeds = pdeds;
    }

    private String pitxps;

    @javax.persistence.Column(name = "PITXPS")
    @Basic
    public String getPitxps() {
        return pitxps;
    }

    public void setPitxps(String pitxps) {
        this.pitxps = pitxps;
    }

    private String pitxcs;

    @javax.persistence.Column(name = "PITXCS")
    @Basic
    public String getPitxcs() {
        return pitxcs;
    }

    public void setPitxcs(String pitxcs) {
        this.pitxcs = pitxcs;
    }

    private String pitxs;

    @javax.persistence.Column(name = "PITXS")
    @Basic
    public String getPitxs() {
        return pitxs;
    }

    public void setPitxs(String pitxs) {
        this.pitxs = pitxs;
    }

    private String pficas;

    @javax.persistence.Column(name = "PFICAS")
    @Basic
    public String getPficas() {
        return pficas;
    }

    public void setPficas(String pficas) {
        this.pficas = pficas;
    }

    private String psttxs;

    @javax.persistence.Column(name = "PSTTXS")
    @Basic
    public String getPsttxs() {
        return psttxs;
    }

    public void setPsttxs(String psttxs) {
        this.psttxs = psttxs;
    }

    private String pmeds;

    @javax.persistence.Column(name = "PMEDS")
    @Basic
    public String getPmeds() {
        return pmeds;
    }

    public void setPmeds(String pmeds) {
        this.pmeds = pmeds;
    }

    private String pmedas;

    @javax.persistence.Column(name = "PMEDAS")
    @Basic
    public String getPmedas() {
        return pmedas;
    }

    public void setPmedas(String pmedas) {
        this.pmedas = pmedas;
    }

    private String ptuits;

    @javax.persistence.Column(name = "PTUITS")
    @Basic
    public String getPtuits() {
        return ptuits;
    }

    public void setPtuits(String ptuits) {
        this.ptuits = ptuits;
    }

    private String pntuits;

    @javax.persistence.Column(name = "PNTUITS")
    @Basic
    public String getPntuits() {
        return pntuits;
    }

    public void setPntuits(String pntuits) {
        this.pntuits = pntuits;
    }

    private String ptuitas;

    @javax.persistence.Column(name = "PTUITAS")
    @Basic
    public String getPtuitas() {
        return ptuitas;
    }

    public void setPtuitas(String ptuitas) {
        this.ptuitas = ptuitas;
    }

    private String pemalos;

    @javax.persistence.Column(name = "PEMALOS")
    @Basic
    public String getPemalos() {
        return pemalos;
    }

    public void setPemalos(String pemalos) {
        this.pemalos = pemalos;
    }

    private String psmas;

    @javax.persistence.Column(name = "PSMAS")
    @Basic
    public String getPsmas() {
        return psmas;
    }

    public void setPsmas(String psmas) {
        this.psmas = psmas;
    }

    private String pialo1S;

    @javax.persistence.Column(name = "PIALO1S")
    @Basic
    public String getPialo1S() {
        return pialo1S;
    }

    public void setPialo1S(String pialo1S) {
        this.pialo1S = pialo1S;
    }

    private String pialo2S;

    @javax.persistence.Column(name = "PIALO2S")
    @Basic
    public String getPialo2S() {
        return pialo2S;
    }

    public void setPialo2S(String pialo2S) {
        this.pialo2S = pialo2S;
    }

    private String ptotals;

    @javax.persistence.Column(name = "PTOTALS")
    @Basic
    public String getPtotals() {
        return ptotals;
    }

    public void setPtotals(String ptotals) {
        this.ptotals = ptotals;
    }

    private String pefincs;

    @javax.persistence.Column(name = "PEFINCS")
    @Basic
    public String getPefincs() {
        return pefincs;
    }

    public void setPefincs(String pefincs) {
        this.pefincs = pefincs;
    }

    private String pcashs;

    @javax.persistence.Column(name = "PCASHS")
    @Basic
    public String getPcashs() {
        return pcashs;
    }

    public void setPcashs(String pcashs) {
        this.pcashs = pcashs;
    }

    private String pinvvs;

    @javax.persistence.Column(name = "PINVVS")
    @Basic
    public String getPinvvs() {
        return pinvvs;
    }

    public void setPinvvs(String pinvvs) {
        this.pinvvs = pinvvs;
    }

    private String pinvds;

    @javax.persistence.Column(name = "PINVDS")
    @Basic
    public String getPinvds() {
        return pinvds;
    }

    public void setPinvds(String pinvds) {
        this.pinvds = pinvds;
    }

    private String pinves;

    @javax.persistence.Column(name = "PINVES")
    @Basic
    public String getPinves() {
        return pinves;
    }

    public void setPinves(String pinves) {
        this.pinves = pinves;
    }

    private String porvs;

    @javax.persistence.Column(name = "PORVS")
    @Basic
    public String getPorvs() {
        return porvs;
    }

    public void setPorvs(String porvs) {
        this.porvs = porvs;
    }

    private String pords;

    @javax.persistence.Column(name = "PORDS")
    @Basic
    public String getPords() {
        return pords;
    }

    public void setPords(String pords) {
        this.pords = pords;
    }

    private String pores;

    @javax.persistence.Column(name = "PORES")
    @Basic
    public String getPores() {
        return pores;
    }

    public void setPores(String pores) {
        this.pores = pores;
    }

    private String pdasss;

    @javax.persistence.Column(name = "PDASSS")
    @Basic
    public String getPdasss() {
        return pdasss;
    }

    public void setPdasss(String pdasss) {
        this.pdasss = pdasss;
    }

    private String phomyrs;

    @javax.persistence.Column(name = "PHOMYRS")
    @Basic
    public String getPhomyrs() {
        return phomyrs;
    }

    public void setPhomyrs(String phomyrs) {
        this.phomyrs = phomyrs;
    }

    private String phompvs;

    @javax.persistence.Column(name = "PHOMPVS")
    @Basic
    public String getPhompvs() {
        return phompvs;
    }

    public void setPhompvs(String phompvs) {
        this.phompvs = phompvs;
    }

    private String phomcs;

    @javax.persistence.Column(name = "PHOMCS")
    @Basic
    public String getPhomcs() {
        return phomcs;
    }

    public void setPhomcs(String phomcs) {
        this.phomcs = phomcs;
    }

    private String phomvs;

    @javax.persistence.Column(name = "PHOMVS")
    @Basic
    public String getPhomvs() {
        return phomvs;
    }

    public void setPhomvs(String phomvs) {
        this.phomvs = phomvs;
    }

    private String phomds;

    @javax.persistence.Column(name = "PHOMDS")
    @Basic
    public String getPhomds() {
        return phomds;
    }

    public void setPhomds(String phomds) {
        this.phomds = phomds;
    }

    private String phomes;

    @javax.persistence.Column(name = "PHOMES")
    @Basic
    public String getPhomes() {
        return phomes;
    }

    public void setPhomes(String phomes) {
        this.phomes = phomes;
    }

    private String pfarmvs;

    @javax.persistence.Column(name = "PFARMVS")
    @Basic
    public String getPfarmvs() {
        return pfarmvs;
    }

    public void setPfarmvs(String pfarmvs) {
        this.pfarmvs = pfarmvs;
    }

    private String pfarmds;

    @javax.persistence.Column(name = "PFARMDS")
    @Basic
    public String getPfarmds() {
        return pfarmds;
    }

    public void setPfarmds(String pfarmds) {
        this.pfarmds = pfarmds;
    }

    private String pfarmes;

    @javax.persistence.Column(name = "PFARMES")
    @Basic
    public String getPfarmes() {
        return pfarmes;
    }

    public void setPfarmes(String pfarmes) {
        this.pfarmes = pfarmes;
    }

    private String pbfvs;

    @javax.persistence.Column(name = "PBFVS")
    @Basic
    public String getPbfvs() {
        return pbfvs;
    }

    public void setPbfvs(String pbfvs) {
        this.pbfvs = pbfvs;
    }

    private String pbfds;

    @javax.persistence.Column(name = "PBFDS")
    @Basic
    public String getPbfds() {
        return pbfds;
    }

    public void setPbfds(String pbfds) {
        this.pbfds = pbfds;
    }

    private String pbfes;

    @javax.persistence.Column(name = "PBFES")
    @Basic
    public String getPbfes() {
        return pbfes;
    }

    public void setPbfes(String pbfes) {
        this.pbfes = pbfes;
    }

    private String pfarms;

    @javax.persistence.Column(name = "PFARMS")
    @Basic
    public String getPfarms() {
        return pfarms;
    }

    public void setPfarms(String pfarms) {
        this.pfarms = pfarms;
    }

    private String pabfws;

    @javax.persistence.Column(name = "PABFWS")
    @Basic
    public String getPabfws() {
        return pabfws;
    }

    public void setPabfws(String pabfws) {
        this.pabfws = pabfws;
    }

    private String passads;

    @javax.persistence.Column(name = "PASSADS")
    @Basic
    public String getPassads() {
        return passads;
    }

    public void setPassads(String passads) {
        this.passads = passads;
    }

    private String ptasss;

    @javax.persistence.Column(name = "PTASSS")
    @Basic
    public String getPtasss() {
        return ptasss;
    }

    public void setPtasss(String ptasss) {
        this.ptasss = ptasss;
    }

    private String pothds;

    @javax.persistence.Column(name = "POTHDS")
    @Basic
    public String getPothds() {
        return pothds;
    }

    public void setPothds(String pothds) {
        this.pothds = pothds;
    }

    private String pnwrths;

    @javax.persistence.Column(name = "PNWRTHS")
    @Basic
    public String getPnwrths() {
        return pnwrths;
    }

    public void setPnwrths(String pnwrths) {
        this.pnwrths = pnwrths;
    }

    private String papas;

    @javax.persistence.Column(name = "PAPAS")
    @Basic
    public String getPapas() {
        return papas;
    }

    public void setPapas(String papas) {
        this.papas = papas;
    }

    private String pdnets;

    @javax.persistence.Column(name = "PDNETS")
    @Basic
    public String getPdnets() {
        return pdnets;
    }

    public void setPdnets(String pdnets) {
        this.pdnets = pdnets;
    }

    private String passcrs;

    @javax.persistence.Column(name = "PASSCRS")
    @Basic
    public String getPasscrs() {
        return passcrs;
    }

    public void setPasscrs(String passcrs) {
        this.passcrs = passcrs;
    }

    private String pincsus;

    @javax.persistence.Column(name = "PINCSUS")
    @Basic
    public String getPincsus() {
        return pincsus;
    }

    public void setPincsus(String pincsus) {
        this.pincsus = pincsus;
    }

    private String paavlis;

    @javax.persistence.Column(name = "PAAVLIS")
    @Basic
    public String getPaavlis() {
        return paavlis;
    }

    public void setPaavlis(String paavlis) {
        this.paavlis = paavlis;
    }

    private String pcolas;

    @javax.persistence.Column(name = "PCOLAS")
    @Basic
    public String getPcolas() {
        return pcolas;
    }

    public void setPcolas(String pcolas) {
        this.pcolas = pcolas;
    }

    private String pravlis;

    @javax.persistence.Column(name = "PRAVLIS")
    @Basic
    public String getPravlis() {
        return pravlis;
    }

    public void setPravlis(String pravlis) {
        this.pravlis = pravlis;
    }

    private String ptconfs;

    @javax.persistence.Column(name = "PTCONFS")
    @Basic
    public String getPtconfs() {
        return ptconfs;
    }

    public void setPtconfs(String ptconfs) {
        this.ptconfs = ptconfs;
    }

    private String pconfns;

    @javax.persistence.Column(name = "PCONFNS")
    @Basic
    public String getPconfns() {
        return pconfns;
    }

    public void setPconfns(String pconfns) {
        this.pconfns = pconfns;
    }

    private String pconfs;

    @javax.persistence.Column(name = "PCONFS")
    @Basic
    public String getPconfs() {
        return pconfs;
    }

    public void setPconfs(String pconfs) {
        this.pconfs = pconfs;
    }

    private String pbfwags;

    @javax.persistence.Column(name = "PBFWAGS")
    @Basic
    public String getPbfwags() {
        return pbfwags;
    }

    public void setPbfwags(String pbfwags) {
        this.pbfwags = pbfwags;
    }

    private String pbmwags;

    @javax.persistence.Column(name = "PBMWAGS")
    @Basic
    public String getPbmwags() {
        return pbmwags;
    }

    public void setPbmwags(String pbmwags) {
        this.pbmwags = pbmwags;
    }

    private String pbotis;

    @javax.persistence.Column(name = "PBOTIS")
    @Basic
    public String getPbotis() {
        return pbotis;
    }

    public void setPbotis(String pbotis) {
        this.pbotis = pbotis;
    }

    private String pbttis;

    @javax.persistence.Column(name = "PBTTIS")
    @Basic
    public String getPbttis() {
        return pbttis;
    }

    public void setPbttis(String pbttis) {
        this.pbttis = pbttis;
    }

    private String pbagirs;

    @javax.persistence.Column(name = "PBAGIRS")
    @Basic
    public String getPbagirs() {
        return pbagirs;
    }

    public void setPbagirs(String pbagirs) {
        this.pbagirs = pbagirs;
    }

    private String pbsss;

    @javax.persistence.Column(name = "PBSSS")
    @Basic
    public String getPbsss() {
        return pbsss;
    }

    public void setPbsss(String pbsss) {
        this.pbsss = pbsss;
    }

    private String pbadcs;

    @javax.persistence.Column(name = "PBADCS")
    @Basic
    public String getPbadcs() {
        return pbadcs;
    }

    public void setPbadcs(String pbadcs) {
        this.pbadcs = pbadcs;
    }

    private String pbntcss;

    @javax.persistence.Column(name = "PBNTCSS")
    @Basic
    public String getPbntcss() {
        return pbntcss;
    }

    public void setPbntcss(String pbntcss) {
        this.pbntcss = pbntcss;
    }

    private String pbontis;

    @javax.persistence.Column(name = "PBONTIS")
    @Basic
    public String getPbontis() {
        return pbontis;
    }

    public void setPbontis(String pbontis) {
        this.pbontis = pbontis;
    }

    private String pbincas;

    @javax.persistence.Column(name = "PBINCAS")
    @Basic
    public String getPbincas() {
        return pbincas;
    }

    public void setPbincas(String pbincas) {
        this.pbincas = pbincas;
    }

    private String pbntis;

    @javax.persistence.Column(name = "PBNTIS")
    @Basic
    public String getPbntis() {
        return pbntis;
    }

    public void setPbntis(String pbntis) {
        this.pbntis = pbntis;
    }

    private String pbtis;

    @javax.persistence.Column(name = "PBTIS")
    @Basic
    public String getPbtis() {
        return pbtis;
    }

    public void setPbtis(String pbtis) {
        this.pbtis = pbtis;
    }

    private String pbitxs;

    @javax.persistence.Column(name = "PBITXS")
    @Basic
    public String getPbitxs() {
        return pbitxs;
    }

    public void setPbitxs(String pbitxs) {
        this.pbitxs = pbitxs;
    }

    private String pbficas;

    @javax.persistence.Column(name = "PBFICAS")
    @Basic
    public String getPbficas() {
        return pbficas;
    }

    public void setPbficas(String pbficas) {
        this.pbficas = pbficas;
    }

    private String pbsttxs;

    @javax.persistence.Column(name = "PBSTTXS")
    @Basic
    public String getPbsttxs() {
        return pbsttxs;
    }

    public void setPbsttxs(String pbsttxs) {
        this.pbsttxs = pbsttxs;
    }

    private String pbmedas;

    @javax.persistence.Column(name = "PBMEDAS")
    @Basic
    public String getPbmedas() {
        return pbmedas;
    }

    public void setPbmedas(String pbmedas) {
        this.pbmedas = pbmedas;
    }

    private String pbtuits;

    @javax.persistence.Column(name = "PBTUITS")
    @Basic
    public String getPbtuits() {
        return pbtuits;
    }

    public void setPbtuits(String pbtuits) {
        this.pbtuits = pbtuits;
    }

    private String pbemals;

    @javax.persistence.Column(name = "PBEMALS")
    @Basic
    public String getPbemals() {
        return pbemals;
    }

    public void setPbemals(String pbemals) {
        this.pbemals = pbemals;
    }

    private String pbsmas;

    @javax.persistence.Column(name = "PBSMAS")
    @Basic
    public String getPbsmas() {
        return pbsmas;
    }

    public void setPbsmas(String pbsmas) {
        this.pbsmas = pbsmas;
    }

    private String pbial1S;

    @javax.persistence.Column(name = "PBIAL1S")
    @Basic
    public String getPbial1S() {
        return pbial1S;
    }

    public void setPbial1S(String pbial1S) {
        this.pbial1S = pbial1S;
    }

    private String pbial2S;

    @javax.persistence.Column(name = "PBIAL2S")
    @Basic
    public String getPbial2S() {
        return pbial2S;
    }

    public void setPbial2S(String pbial2S) {
        this.pbial2S = pbial2S;
    }

    private String pbtalos;

    @javax.persistence.Column(name = "PBTALOS")
    @Basic
    public String getPbtalos() {
        return pbtalos;
    }

    public void setPbtalos(String pbtalos) {
        this.pbtalos = pbtalos;
    }

    private String pbefins;

    @javax.persistence.Column(name = "PBEFINS")
    @Basic
    public String getPbefins() {
        return pbefins;
    }

    public void setPbefins(String pbefins) {
        this.pbefins = pbefins;
    }

    private String ptntis;

    @javax.persistence.Column(name = "PTNTIS")
    @Basic
    public String getPtntis() {
        return ptntis;
    }

    public void setPtntis(String ptntis) {
        this.ptntis = ptntis;
    }

    private String pbtuitas;

    @javax.persistence.Column(name = "PBTUITAS")
    @Basic
    public String getPbtuitas() {
        return pbtuitas;
    }

    public void setPbtuitas(String pbtuitas) {
        this.pbtuitas = pbtuitas;
    }

    private String pbnwrths;

    @javax.persistence.Column(name = "PBNWRTHS")
    @Basic
    public String getPbnwrths() {
        return pbnwrths;
    }

    public void setPbnwrths(String pbnwrths) {
        this.pbnwrths = pbnwrths;
    }

    private String pbapas;

    @javax.persistence.Column(name = "PBAPAS")
    @Basic
    public String getPbapas() {
        return pbapas;
    }

    public void setPbapas(String pbapas) {
        this.pbapas = pbapas;
    }

    private String pbdnets;

    @javax.persistence.Column(name = "PBDNETS")
    @Basic
    public String getPbdnets() {
        return pbdnets;
    }

    public void setPbdnets(String pbdnets) {
        this.pbdnets = pbdnets;
    }

    private String pbasscrs;

    @javax.persistence.Column(name = "PBASSCRS")
    @Basic
    public String getPbasscrs() {
        return pbasscrs;
    }

    public void setPbasscrs(String pbasscrs) {
        this.pbasscrs = pbasscrs;
    }

    private String pbincsus;

    @javax.persistence.Column(name = "PBINCSUS")
    @Basic
    public String getPbincsus() {
        return pbincsus;
    }

    public void setPbincsus(String pbincsus) {
        this.pbincsus = pbincsus;
    }

    private String pbaavlis;

    @javax.persistence.Column(name = "PBAAVLIS")
    @Basic
    public String getPbaavlis() {
        return pbaavlis;
    }

    public void setPbaavlis(String pbaavlis) {
        this.pbaavlis = pbaavlis;
    }

    private String pbhomes;

    @javax.persistence.Column(name = "PBHOMES")
    @Basic
    public String getPbhomes() {
        return pbhomes;
    }

    public void setPbhomes(String pbhomes) {
        this.pbhomes = pbhomes;
    }

    private String pbabfws;

    @javax.persistence.Column(name = "PBABFWS")
    @Basic
    public String getPbabfws() {
        return pbabfws;
    }

    public void setPbabfws(String pbabfws) {
        this.pbabfws = pbabfws;
    }

    private String pbconfs;

    @javax.persistence.Column(name = "PBCONFS")
    @Basic
    public String getPbconfs() {
        return pbconfs;
    }

    public void setPbconfs(String pbconfs) {
        this.pbconfs = pbconfs;
    }

    private String pexclds;

    @javax.persistence.Column(name = "PEXCLDS")
    @Basic
    public String getPexclds() {
        return pexclds;
    }

    public void setPexclds(String pexclds) {
        this.pexclds = pexclds;
    }

    private String phvpluss;

    @javax.persistence.Column(name = "PHVPLUSS")
    @Basic
    public String getPhvpluss() {
        return phvpluss;
    }

    public void setPhvpluss(String phvpluss) {
        this.phvpluss = phvpluss;
    }

    private String pinccrs;

    @javax.persistence.Column(name = "PINCCRS")
    @Basic
    public String getPinccrs() {
        return pinccrs;
    }

    public void setPinccrs(String pinccrs) {
        this.pinccrs = pinccrs;
    }

    private String sbasets;

    @javax.persistence.Column(name = "SBASETS")
    @Basic
    public String getSbasets() {
        return sbasets;
    }

    public void setSbasets(String sbasets) {
        this.sbasets = sbasets;
    }

    private String disbpri;

    @javax.persistence.Column(name = "DISBPRI")
    @Basic
    public String getDisbpri() {
        return disbpri;
    }

    public void setDisbpri(String disbpri) {
        this.disbpri = disbpri;
    }

    private String deflchg;

    @javax.persistence.Column(name = "DEFLCHG")
    @Basic
    public String getDeflchg() {
        return deflchg;
    }

    public void setDeflchg(String deflchg) {
        this.deflchg = deflchg;
    }

    private String discchg;

    @javax.persistence.Column(name = "DISCCHG")
    @Basic
    public String getDiscchg() {
        return discchg;
    }

    public void setDiscchg(String discchg) {
        this.discchg = discchg;
    }

    private String repychg;

    @javax.persistence.Column(name = "REPYCHG")
    @Basic
    public String getRepychg() {
        return repychg;
    }

    public void setRepychg(String repychg) {
        this.repychg = repychg;
    }

    private String bankchg;

    @javax.persistence.Column(name = "BANKCHG")
    @Basic
    public String getBankchg() {
        return bankchg;
    }

    public void setBankchg(String bankchg) {
        this.bankchg = bankchg;
    }

    private String opaychg;

    @javax.persistence.Column(name = "OPAYCHG")
    @Basic
    public String getOpaychg() {
        return opaychg;
    }

    public void setOpaychg(String opaychg) {
        this.opaychg = opaychg;
    }

    private String aggrchg;

    @javax.persistence.Column(name = "AGGRCHG")
    @Basic
    public String getAggrchg() {
        return aggrchg;
    }

    public void setAggrchg(String aggrchg) {
        this.aggrchg = aggrchg;
    }

    private String perkchg;

    @javax.persistence.Column(name = "PERKCHG")
    @Basic
    public String getPerkchg() {
        return perkchg;
    }

    public void setPerkchg(String perkchg) {
        this.perkchg = perkchg;
    }

    private String plpychg;

    @javax.persistence.Column(name = "PLPYCHG")
    @Basic
    public String getPlpychg() {
        return plpychg;
    }

    public void setPlpychg(String plpychg) {
        this.plpychg = plpychg;
    }

    private String addlpel;

    @javax.persistence.Column(name = "ADDLPEL")
    @Basic
    public String getAddlpel() {
        return addlpel;
    }

    public void setAddlpel(String addlpel) {
        this.addlpel = addlpel;
    }

    private String addloan;

    @javax.persistence.Column(name = "ADDLOAN")
    @Basic
    public String getAddloan() {
        return addloan;
    }

    public void setAddloan(String addloan) {
        this.addloan = addloan;
    }

    private String pfilrtns;

    @javax.persistence.Column(name = "PFILRTNS")
    @Basic
    public String getPfilrtns() {
        return pfilrtns;
    }

    public void setPfilrtns(String pfilrtns) {
        this.pfilrtns = pfilrtns;
    }

    private String pelgfils;

    @javax.persistence.Column(name = "PELGFILS")
    @Basic
    public String getPelgfils() {
        return pelgfils;
    }

    public void setPelgfils(String pelgfils) {
        this.pelgfils = pelgfils;
    }

    private String presbfrs;

    @javax.persistence.Column(name = "PRESBFRS")
    @Basic
    public String getPresbfrs() {
        return presbfrs;
    }

    public void setPresbfrs(String presbfrs) {
        this.presbfrs = presbfrs;
    }

    private String namefls;

    @javax.persistence.Column(name = "NAMEFLS")
    @Basic
    public String getNamefls() {
        return namefls;
    }

    public void setNamefls(String namefls) {
        this.namefls = namefls;
    }

    private String ssnfats;

    @javax.persistence.Column(name = "SSNFATS")
    @Basic
    public String getSsnfats() {
        return ssnfats;
    }

    public void setSsnfats(String ssnfats) {
        this.ssnfats = ssnfats;
    }

    private String namemls;

    @javax.persistence.Column(name = "NAMEMLS")
    @Basic
    public String getNamemls() {
        return namemls;
    }

    public void setNamemls(String namemls) {
        this.namemls = namemls;
    }

    private String ssnmots;

    @javax.persistence.Column(name = "SSNMOTS")
    @Basic
    public String getSsnmots() {
        return ssnmots;
    }

    public void setSsnmots(String ssnmots) {
        this.ssnmots = ssnmots;
    }

    private String pmartlcs;

    @javax.persistence.Column(name = "PMARTLCS")
    @Basic
    public String getPmartlcs() {
        return pmartlcs;
    }

    public void setPmartlcs(String pmartlcs) {
        this.pmartlcs = pmartlcs;
    }

    private String pagecs;

    @javax.persistence.Column(name = "PAGECS")
    @Basic
    public String getPagecs() {
        return pagecs;
    }

    public void setPagecs(String pagecs) {
        this.pagecs = pagecs;
    }

    private String pszhhdcs;

    @javax.persistence.Column(name = "PSZHHDCS")
    @Basic
    public String getPszhhdcs() {
        return pszhhdcs;
    }

    public void setPszhhdcs(String pszhhdcs) {
        this.pszhhdcs = pszhhdcs;
    }

    private String pexempcs;

    @javax.persistence.Column(name = "PEXEMPCS")
    @Basic
    public String getPexempcs() {
        return pexempcs;
    }

    public void setPexempcs(String pexempcs) {
        this.pexempcs = pexempcs;
    }

    private String pnrpscs;

    @javax.persistence.Column(name = "PNRPSCS")
    @Basic
    public String getPnrpscs() {
        return pnrpscs;
    }

    public void setPnrpscs(String pnrpscs) {
        this.pnrpscs = pnrpscs;
    }

    private String pincolcs;

    @javax.persistence.Column(name = "PINCOLCS")
    @Basic
    public String getPincolcs() {
        return pincolcs;
    }

    public void setPincolcs(String pincolcs) {
        this.pincolcs = pincolcs;
    }

    private String pdiswkcs;

    @javax.persistence.Column(name = "PDISWKCS")
    @Basic
    public String getPdiswkcs() {
        return pdiswkcs;
    }

    public void setPdiswkcs(String pdiswkcs) {
        this.pdiswkcs = pdiswkcs;
    }

    private String pdishmcs;

    @javax.persistence.Column(name = "PDISHMCS")
    @Basic
    public String getPdishmcs() {
        return pdishmcs;
    }

    public void setPdishmcs(String pdishmcs) {
        this.pdishmcs = pdishmcs;
    }

    private String ptrfilcs;

    @javax.persistence.Column(name = "PTRFILCS")
    @Basic
    public String getPtrfilcs() {
        return ptrfilcs;
    }

    public void setPtrfilcs(String ptrfilcs) {
        this.ptrfilcs = ptrfilcs;
    }

    private String pfwagcs;

    @javax.persistence.Column(name = "PFWAGCS")
    @Basic
    public String getPfwagcs() {
        return pfwagcs;
    }

    public void setPfwagcs(String pfwagcs) {
        this.pfwagcs = pfwagcs;
    }

    private String pmwagcs;

    @javax.persistence.Column(name = "PMWAGCS")
    @Basic
    public String getPmwagcs() {
        return pmwagcs;
    }

    public void setPmwagcs(String pmwagcs) {
        this.pmwagcs = pmwagcs;
    }

    private String padjwcs;

    @javax.persistence.Column(name = "PADJWCS")
    @Basic
    public String getPadjwcs() {
        return padjwcs;
    }

    public void setPadjwcs(String padjwcs) {
        this.padjwcs = padjwcs;
    }

    private String pwagcs;

    @javax.persistence.Column(name = "PWAGCS")
    @Basic
    public String getPwagcs() {
        return pwagcs;
    }

    public void setPwagcs(String pwagcs) {
        this.pwagcs = pwagcs;
    }

    private String pintcs;

    @javax.persistence.Column(name = "PINTCS")
    @Basic
    public String getPintcs() {
        return pintcs;
    }

    public void setPintcs(String pintcs) {
        this.pintcs = pintcs;
    }

    private String pdivcs;

    @javax.persistence.Column(name = "PDIVCS")
    @Basic
    public String getPdivcs() {
        return pdivcs;
    }

    public void setPdivcs(String pdivcs) {
        this.pdivcs = pdivcs;
    }

    private String pbfrics;

    @javax.persistence.Column(name = "PBFRICS")
    @Basic
    public String getPbfrics() {
        return pbfrics;
    }

    public void setPbfrics(String pbfrics) {
        this.pbfrics = pbfrics;
    }

    private String potics;

    @javax.persistence.Column(name = "POTICS")
    @Basic
    public String getPotics() {
        return potics;
    }

    public void setPotics(String potics) {
        this.potics = potics;
    }

    private String pbexcs;

    @javax.persistence.Column(name = "PBEXCS")
    @Basic
    public String getPbexcs() {
        return pbexcs;
    }

    public void setPbexcs(String pbexcs) {
        this.pbexcs = pbexcs;
    }

    private String padjcs;

    @javax.persistence.Column(name = "PADJCS")
    @Basic
    public String getPadjcs() {
        return padjcs;
    }

    public void setPadjcs(String padjcs) {
        this.padjcs = padjcs;
    }

    private String pttinccs;

    @javax.persistence.Column(name = "PTTINCCS")
    @Basic
    public String getPttinccs() {
        return pttinccs;
    }

    public void setPttinccs(String pttinccs) {
        this.pttinccs = pttinccs;
    }

    private String pagircs;

    @javax.persistence.Column(name = "PAGIRCS")
    @Basic
    public String getPagircs() {
        return pagircs;
    }

    public void setPagircs(String pagircs) {
        this.pagircs = pagircs;
    }

    private String psscs;

    @javax.persistence.Column(name = "PSSCS")
    @Basic
    public String getPsscs() {
        return psscs;
    }

    public void setPsscs(String psscs) {
        this.psscs = psscs;
    }

    private String padccs;

    @javax.persistence.Column(name = "PADCCS")
    @Basic
    public String getPadccs() {
        return padccs;
    }

    public void setPadccs(String padccs) {
        this.padccs = padccs;
    }

    private String pntcscs;

    @javax.persistence.Column(name = "PNTCSCS")
    @Basic
    public String getPntcscs() {
        return pntcscs;
    }

    public void setPntcscs(String pntcscs) {
        this.pntcscs = pntcscs;
    }

    private String pontics;

    @javax.persistence.Column(name = "PONTICS")
    @Basic
    public String getPontics() {
        return pontics;
    }

    public void setPontics(String pontics) {
        this.pontics = pontics;
    }

    private String pinca1Cs;

    @javax.persistence.Column(name = "PINCA1CS")
    @Basic
    public String getPinca1Cs() {
        return pinca1Cs;
    }

    public void setPinca1Cs(String pinca1Cs) {
        this.pinca1Cs = pinca1Cs;
    }

    private String pinca2Cs;

    @javax.persistence.Column(name = "PINCA2CS")
    @Basic
    public String getPinca2Cs() {
        return pinca2Cs;
    }

    public void setPinca2Cs(String pinca2Cs) {
        this.pinca2Cs = pinca2Cs;
    }

    private String ptinccs;

    @javax.persistence.Column(name = "PTINCCS")
    @Basic
    public String getPtinccs() {
        return ptinccs;
    }

    public void setPtinccs(String ptinccs) {
        this.ptinccs = ptinccs;
    }

    private String pdedcs;

    @javax.persistence.Column(name = "PDEDCS")
    @Basic
    public String getPdedcs() {
        return pdedcs;
    }

    public void setPdedcs(String pdedcs) {
        this.pdedcs = pdedcs;
    }

    private String pitxpcs;

    @javax.persistence.Column(name = "PITXPCS")
    @Basic
    public String getPitxpcs() {
        return pitxpcs;
    }

    public void setPitxpcs(String pitxpcs) {
        this.pitxpcs = pitxpcs;
    }

    private String pitxccs;

    @javax.persistence.Column(name = "PITXCCS")
    @Basic
    public String getPitxccs() {
        return pitxccs;
    }

    public void setPitxccs(String pitxccs) {
        this.pitxccs = pitxccs;
    }

    private String pitxxcs;

    @javax.persistence.Column(name = "PITXXCS")
    @Basic
    public String getPitxxcs() {
        return pitxxcs;
    }

    public void setPitxxcs(String pitxxcs) {
        this.pitxxcs = pitxxcs;
    }

    private String pficacs;

    @javax.persistence.Column(name = "PFICACS")
    @Basic
    public String getPficacs() {
        return pficacs;
    }

    public void setPficacs(String pficacs) {
        this.pficacs = pficacs;
    }

    private String psttxcs;

    @javax.persistence.Column(name = "PSTTXCS")
    @Basic
    public String getPsttxcs() {
        return psttxcs;
    }

    public void setPsttxcs(String psttxcs) {
        this.psttxcs = psttxcs;
    }

    private String pmedcs;

    @javax.persistence.Column(name = "PMEDCS")
    @Basic
    public String getPmedcs() {
        return pmedcs;
    }

    public void setPmedcs(String pmedcs) {
        this.pmedcs = pmedcs;
    }

    private String pmedacs;

    @javax.persistence.Column(name = "PMEDACS")
    @Basic
    public String getPmedacs() {
        return pmedacs;
    }

    public void setPmedacs(String pmedacs) {
        this.pmedacs = pmedacs;
    }

    private String ptuitcs;

    @javax.persistence.Column(name = "PTUITCS")
    @Basic
    public String getPtuitcs() {
        return ptuitcs;
    }

    public void setPtuitcs(String ptuitcs) {
        this.ptuitcs = ptuitcs;
    }

    private String pntuitcs;

    @javax.persistence.Column(name = "PNTUITCS")
    @Basic
    public String getPntuitcs() {
        return pntuitcs;
    }

    public void setPntuitcs(String pntuitcs) {
        this.pntuitcs = pntuitcs;
    }

    private String ptuitacs;

    @javax.persistence.Column(name = "PTUITACS")
    @Basic
    public String getPtuitacs() {
        return ptuitacs;
    }

    public void setPtuitacs(String ptuitacs) {
        this.ptuitacs = ptuitacs;
    }

    private String pemalocs;

    @javax.persistence.Column(name = "PEMALOCS")
    @Basic
    public String getPemalocs() {
        return pemalocs;
    }

    public void setPemalocs(String pemalocs) {
        this.pemalocs = pemalocs;
    }

    private String psmacs;

    @javax.persistence.Column(name = "PSMACS")
    @Basic
    public String getPsmacs() {
        return psmacs;
    }

    public void setPsmacs(String psmacs) {
        this.psmacs = psmacs;
    }

    private String pialo1Cs;

    @javax.persistence.Column(name = "PIALO1CS")
    @Basic
    public String getPialo1Cs() {
        return pialo1Cs;
    }

    public void setPialo1Cs(String pialo1Cs) {
        this.pialo1Cs = pialo1Cs;
    }

    private String pialo2Cs;

    @javax.persistence.Column(name = "PIALO2CS")
    @Basic
    public String getPialo2Cs() {
        return pialo2Cs;
    }

    public void setPialo2Cs(String pialo2Cs) {
        this.pialo2Cs = pialo2Cs;
    }

    private String ptotalcs;

    @javax.persistence.Column(name = "PTOTALCS")
    @Basic
    public String getPtotalcs() {
        return ptotalcs;
    }

    public void setPtotalcs(String ptotalcs) {
        this.ptotalcs = ptotalcs;
    }

    private String pefinccs;

    @javax.persistence.Column(name = "PEFINCCS")
    @Basic
    public String getPefinccs() {
        return pefinccs;
    }

    public void setPefinccs(String pefinccs) {
        this.pefinccs = pefinccs;
    }

    private String pcashcs;

    @javax.persistence.Column(name = "PCASHCS")
    @Basic
    public String getPcashcs() {
        return pcashcs;
    }

    public void setPcashcs(String pcashcs) {
        this.pcashcs = pcashcs;
    }

    private String pinvvcs;

    @javax.persistence.Column(name = "PINVVCS")
    @Basic
    public String getPinvvcs() {
        return pinvvcs;
    }

    public void setPinvvcs(String pinvvcs) {
        this.pinvvcs = pinvvcs;
    }

    private String pinvdcs;

    @javax.persistence.Column(name = "PINVDCS")
    @Basic
    public String getPinvdcs() {
        return pinvdcs;
    }

    public void setPinvdcs(String pinvdcs) {
        this.pinvdcs = pinvdcs;
    }

    private String pinvecs;

    @javax.persistence.Column(name = "PINVECS")
    @Basic
    public String getPinvecs() {
        return pinvecs;
    }

    public void setPinvecs(String pinvecs) {
        this.pinvecs = pinvecs;
    }

    private String porvcs;

    @javax.persistence.Column(name = "PORVCS")
    @Basic
    public String getPorvcs() {
        return porvcs;
    }

    public void setPorvcs(String porvcs) {
        this.porvcs = porvcs;
    }

    private String pordcs;

    @javax.persistence.Column(name = "PORDCS")
    @Basic
    public String getPordcs() {
        return pordcs;
    }

    public void setPordcs(String pordcs) {
        this.pordcs = pordcs;
    }

    private String porecs;

    @javax.persistence.Column(name = "PORECS")
    @Basic
    public String getPorecs() {
        return porecs;
    }

    public void setPorecs(String porecs) {
        this.porecs = porecs;
    }

    private String pdasscs;

    @javax.persistence.Column(name = "PDASSCS")
    @Basic
    public String getPdasscs() {
        return pdasscs;
    }

    public void setPdasscs(String pdasscs) {
        this.pdasscs = pdasscs;
    }

    private String phomyrcs;

    @javax.persistence.Column(name = "PHOMYRCS")
    @Basic
    public String getPhomyrcs() {
        return phomyrcs;
    }

    public void setPhomyrcs(String phomyrcs) {
        this.phomyrcs = phomyrcs;
    }

    private String phompvcs;

    @javax.persistence.Column(name = "PHOMPVCS")
    @Basic
    public String getPhompvcs() {
        return phompvcs;
    }

    public void setPhompvcs(String phompvcs) {
        this.phompvcs = phompvcs;
    }

    private String phomccs;

    @javax.persistence.Column(name = "PHOMCCS")
    @Basic
    public String getPhomccs() {
        return phomccs;
    }

    public void setPhomccs(String phomccs) {
        this.phomccs = phomccs;
    }

    private String phomvcs;

    @javax.persistence.Column(name = "PHOMVCS")
    @Basic
    public String getPhomvcs() {
        return phomvcs;
    }

    public void setPhomvcs(String phomvcs) {
        this.phomvcs = phomvcs;
    }

    private String phomdcs;

    @javax.persistence.Column(name = "PHOMDCS")
    @Basic
    public String getPhomdcs() {
        return phomdcs;
    }

    public void setPhomdcs(String phomdcs) {
        this.phomdcs = phomdcs;
    }

    private String phomecs;

    @javax.persistence.Column(name = "PHOMECS")
    @Basic
    public String getPhomecs() {
        return phomecs;
    }

    public void setPhomecs(String phomecs) {
        this.phomecs = phomecs;
    }

    private String pfarmvcs;

    @javax.persistence.Column(name = "PFARMVCS")
    @Basic
    public String getPfarmvcs() {
        return pfarmvcs;
    }

    public void setPfarmvcs(String pfarmvcs) {
        this.pfarmvcs = pfarmvcs;
    }

    private String pfarmdcs;

    @javax.persistence.Column(name = "PFARMDCS")
    @Basic
    public String getPfarmdcs() {
        return pfarmdcs;
    }

    public void setPfarmdcs(String pfarmdcs) {
        this.pfarmdcs = pfarmdcs;
    }

    private String pfarmecs;

    @javax.persistence.Column(name = "PFARMECS")
    @Basic
    public String getPfarmecs() {
        return pfarmecs;
    }

    public void setPfarmecs(String pfarmecs) {
        this.pfarmecs = pfarmecs;
    }

    private String pbfvcs;

    @javax.persistence.Column(name = "PBFVCS")
    @Basic
    public String getPbfvcs() {
        return pbfvcs;
    }

    public void setPbfvcs(String pbfvcs) {
        this.pbfvcs = pbfvcs;
    }

    private String pbfdcs;

    @javax.persistence.Column(name = "PBFDCS")
    @Basic
    public String getPbfdcs() {
        return pbfdcs;
    }

    public void setPbfdcs(String pbfdcs) {
        this.pbfdcs = pbfdcs;
    }

    private String pbfecs;

    @javax.persistence.Column(name = "PBFECS")
    @Basic
    public String getPbfecs() {
        return pbfecs;
    }

    public void setPbfecs(String pbfecs) {
        this.pbfecs = pbfecs;
    }

    private String pfarmcs;

    @javax.persistence.Column(name = "PFARMCS")
    @Basic
    public String getPfarmcs() {
        return pfarmcs;
    }

    public void setPfarmcs(String pfarmcs) {
        this.pfarmcs = pfarmcs;
    }

    private String pabfwcs;

    @javax.persistence.Column(name = "PABFWCS")
    @Basic
    public String getPabfwcs() {
        return pabfwcs;
    }

    public void setPabfwcs(String pabfwcs) {
        this.pabfwcs = pabfwcs;
    }

    private String passadcs;

    @javax.persistence.Column(name = "PASSADCS")
    @Basic
    public String getPassadcs() {
        return passadcs;
    }

    public void setPassadcs(String passadcs) {
        this.passadcs = passadcs;
    }

    private String ptasscs;

    @javax.persistence.Column(name = "PTASSCS")
    @Basic
    public String getPtasscs() {
        return ptasscs;
    }

    public void setPtasscs(String ptasscs) {
        this.ptasscs = ptasscs;
    }

    private String pothdcs;

    @javax.persistence.Column(name = "POTHDCS")
    @Basic
    public String getPothdcs() {
        return pothdcs;
    }

    public void setPothdcs(String pothdcs) {
        this.pothdcs = pothdcs;
    }

    private String pnwrthcs;

    @javax.persistence.Column(name = "PNWRTHCS")
    @Basic
    public String getPnwrthcs() {
        return pnwrthcs;
    }

    public void setPnwrthcs(String pnwrthcs) {
        this.pnwrthcs = pnwrthcs;
    }

    private String papacs;

    @javax.persistence.Column(name = "PAPACS")
    @Basic
    public String getPapacs() {
        return papacs;
    }

    public void setPapacs(String papacs) {
        this.papacs = papacs;
    }

    private String pdnetcs;

    @javax.persistence.Column(name = "PDNETCS")
    @Basic
    public String getPdnetcs() {
        return pdnetcs;
    }

    public void setPdnetcs(String pdnetcs) {
        this.pdnetcs = pdnetcs;
    }

    private String passcrcs;

    @javax.persistence.Column(name = "PASSCRCS")
    @Basic
    public String getPasscrcs() {
        return passcrcs;
    }

    public void setPasscrcs(String passcrcs) {
        this.passcrcs = passcrcs;
    }

    private String pincsucs;

    @javax.persistence.Column(name = "PINCSUCS")
    @Basic
    public String getPincsucs() {
        return pincsucs;
    }

    public void setPincsucs(String pincsucs) {
        this.pincsucs = pincsucs;
    }

    private String paavlics;

    @javax.persistence.Column(name = "PAAVLICS")
    @Basic
    public String getPaavlics() {
        return paavlics;
    }

    public void setPaavlics(String paavlics) {
        this.paavlics = paavlics;
    }

    private String pcolacs;

    @javax.persistence.Column(name = "PCOLACS")
    @Basic
    public String getPcolacs() {
        return pcolacs;
    }

    public void setPcolacs(String pcolacs) {
        this.pcolacs = pcolacs;
    }

    private String pravlics;

    @javax.persistence.Column(name = "PRAVLICS")
    @Basic
    public String getPravlics() {
        return pravlics;
    }

    public void setPravlics(String pravlics) {
        this.pravlics = pravlics;
    }

    private String ptconfcs;

    @javax.persistence.Column(name = "PTCONFCS")
    @Basic
    public String getPtconfcs() {
        return ptconfcs;
    }

    public void setPtconfcs(String ptconfcs) {
        this.ptconfcs = ptconfcs;
    }

    private String pconfncs;

    @javax.persistence.Column(name = "PCONFNCS")
    @Basic
    public String getPconfncs() {
        return pconfncs;
    }

    public void setPconfncs(String pconfncs) {
        this.pconfncs = pconfncs;
    }

    private String pconfcs;

    @javax.persistence.Column(name = "PCONFCS")
    @Basic
    public String getPconfcs() {
        return pconfcs;
    }

    public void setPconfcs(String pconfcs) {
        this.pconfcs = pconfcs;
    }

    private String pbfwagcs;

    @javax.persistence.Column(name = "PBFWAGCS")
    @Basic
    public String getPbfwagcs() {
        return pbfwagcs;
    }

    public void setPbfwagcs(String pbfwagcs) {
        this.pbfwagcs = pbfwagcs;
    }

    private String pbmwagcs;

    @javax.persistence.Column(name = "PBMWAGCS")
    @Basic
    public String getPbmwagcs() {
        return pbmwagcs;
    }

    public void setPbmwagcs(String pbmwagcs) {
        this.pbmwagcs = pbmwagcs;
    }

    private String pbotics;

    @javax.persistence.Column(name = "PBOTICS")
    @Basic
    public String getPbotics() {
        return pbotics;
    }

    public void setPbotics(String pbotics) {
        this.pbotics = pbotics;
    }

    private String pbttics;

    @javax.persistence.Column(name = "PBTTICS")
    @Basic
    public String getPbttics() {
        return pbttics;
    }

    public void setPbttics(String pbttics) {
        this.pbttics = pbttics;
    }

    private String pbagircs;

    @javax.persistence.Column(name = "PBAGIRCS")
    @Basic
    public String getPbagircs() {
        return pbagircs;
    }

    public void setPbagircs(String pbagircs) {
        this.pbagircs = pbagircs;
    }

    private String pbsscs;

    @javax.persistence.Column(name = "PBSSCS")
    @Basic
    public String getPbsscs() {
        return pbsscs;
    }

    public void setPbsscs(String pbsscs) {
        this.pbsscs = pbsscs;
    }

    private String pbadccs;

    @javax.persistence.Column(name = "PBADCCS")
    @Basic
    public String getPbadccs() {
        return pbadccs;
    }

    public void setPbadccs(String pbadccs) {
        this.pbadccs = pbadccs;
    }

    private String pbntcscs;

    @javax.persistence.Column(name = "PBNTCSCS")
    @Basic
    public String getPbntcscs() {
        return pbntcscs;
    }

    public void setPbntcscs(String pbntcscs) {
        this.pbntcscs = pbntcscs;
    }

    private String pbontics;

    @javax.persistence.Column(name = "PBONTICS")
    @Basic
    public String getPbontics() {
        return pbontics;
    }

    public void setPbontics(String pbontics) {
        this.pbontics = pbontics;
    }

    private String pbincacs;

    @javax.persistence.Column(name = "PBINCACS")
    @Basic
    public String getPbincacs() {
        return pbincacs;
    }

    public void setPbincacs(String pbincacs) {
        this.pbincacs = pbincacs;
    }

    private String pbntics;

    @javax.persistence.Column(name = "PBNTICS")
    @Basic
    public String getPbntics() {
        return pbntics;
    }

    public void setPbntics(String pbntics) {
        this.pbntics = pbntics;
    }

    private String pbtics;

    @javax.persistence.Column(name = "PBTICS")
    @Basic
    public String getPbtics() {
        return pbtics;
    }

    public void setPbtics(String pbtics) {
        this.pbtics = pbtics;
    }

    private String pbitxcs;

    @javax.persistence.Column(name = "PBITXCS")
    @Basic
    public String getPbitxcs() {
        return pbitxcs;
    }

    public void setPbitxcs(String pbitxcs) {
        this.pbitxcs = pbitxcs;
    }

    private String pbficacs;

    @javax.persistence.Column(name = "PBFICACS")
    @Basic
    public String getPbficacs() {
        return pbficacs;
    }

    public void setPbficacs(String pbficacs) {
        this.pbficacs = pbficacs;
    }

    private String pbsttxcs;

    @javax.persistence.Column(name = "PBSTTXCS")
    @Basic
    public String getPbsttxcs() {
        return pbsttxcs;
    }

    public void setPbsttxcs(String pbsttxcs) {
        this.pbsttxcs = pbsttxcs;
    }

    private String pbmedacs;

    @javax.persistence.Column(name = "PBMEDACS")
    @Basic
    public String getPbmedacs() {
        return pbmedacs;
    }

    public void setPbmedacs(String pbmedacs) {
        this.pbmedacs = pbmedacs;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snp4Entity that = (Snp4Entity) o;

        if (addloan != null ? !addloan.equals(that.addloan) : that.addloan != null) return false;
        if (addlpel != null ? !addlpel.equals(that.addlpel) : that.addlpel != null) return false;
        if (aggrchg != null ? !aggrchg.equals(that.aggrchg) : that.aggrchg != null) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (bankchg != null ? !bankchg.equals(that.bankchg) : that.bankchg != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (deflchg != null ? !deflchg.equals(that.deflchg) : that.deflchg != null) return false;
        if (disbpri != null ? !disbpri.equals(that.disbpri) : that.disbpri != null) return false;
        if (discchg != null ? !discchg.equals(that.discchg) : that.discchg != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (namefls != null ? !namefls.equals(that.namefls) : that.namefls != null) return false;
        if (namemls != null ? !namemls.equals(that.namemls) : that.namemls != null) return false;
        if (opaychg != null ? !opaychg.equals(that.opaychg) : that.opaychg != null) return false;
        if (paavlics != null ? !paavlics.equals(that.paavlics) : that.paavlics != null) return false;
        if (paavlis != null ? !paavlis.equals(that.paavlis) : that.paavlis != null) return false;
        if (pabfwcs != null ? !pabfwcs.equals(that.pabfwcs) : that.pabfwcs != null) return false;
        if (pabfws != null ? !pabfws.equals(that.pabfws) : that.pabfws != null) return false;
        if (padccs != null ? !padccs.equals(that.padccs) : that.padccs != null) return false;
        if (padcs != null ? !padcs.equals(that.padcs) : that.padcs != null) return false;
        if (padjcs != null ? !padjcs.equals(that.padjcs) : that.padjcs != null) return false;
        if (padjs != null ? !padjs.equals(that.padjs) : that.padjs != null) return false;
        if (padjwcs != null ? !padjwcs.equals(that.padjwcs) : that.padjwcs != null) return false;
        if (padjws != null ? !padjws.equals(that.padjws) : that.padjws != null) return false;
        if (pagecs != null ? !pagecs.equals(that.pagecs) : that.pagecs != null) return false;
        if (pages != null ? !pages.equals(that.pages) : that.pages != null) return false;
        if (pagircs != null ? !pagircs.equals(that.pagircs) : that.pagircs != null) return false;
        if (pagirs != null ? !pagirs.equals(that.pagirs) : that.pagirs != null) return false;
        if (papacs != null ? !papacs.equals(that.papacs) : that.papacs != null) return false;
        if (papas != null ? !papas.equals(that.papas) : that.papas != null) return false;
        if (passadcs != null ? !passadcs.equals(that.passadcs) : that.passadcs != null) return false;
        if (passads != null ? !passads.equals(that.passads) : that.passads != null) return false;
        if (passcrcs != null ? !passcrcs.equals(that.passcrcs) : that.passcrcs != null) return false;
        if (passcrs != null ? !passcrs.equals(that.passcrs) : that.passcrs != null) return false;
        if (pbaavlis != null ? !pbaavlis.equals(that.pbaavlis) : that.pbaavlis != null) return false;
        if (pbabfws != null ? !pbabfws.equals(that.pbabfws) : that.pbabfws != null) return false;
        if (pbadccs != null ? !pbadccs.equals(that.pbadccs) : that.pbadccs != null) return false;
        if (pbadcs != null ? !pbadcs.equals(that.pbadcs) : that.pbadcs != null) return false;
        if (pbagircs != null ? !pbagircs.equals(that.pbagircs) : that.pbagircs != null) return false;
        if (pbagirs != null ? !pbagirs.equals(that.pbagirs) : that.pbagirs != null) return false;
        if (pbapas != null ? !pbapas.equals(that.pbapas) : that.pbapas != null) return false;
        if (pbasscrs != null ? !pbasscrs.equals(that.pbasscrs) : that.pbasscrs != null) return false;
        if (pbconfs != null ? !pbconfs.equals(that.pbconfs) : that.pbconfs != null) return false;
        if (pbdnets != null ? !pbdnets.equals(that.pbdnets) : that.pbdnets != null) return false;
        if (pbefins != null ? !pbefins.equals(that.pbefins) : that.pbefins != null) return false;
        if (pbemals != null ? !pbemals.equals(that.pbemals) : that.pbemals != null) return false;
        if (pbexcs != null ? !pbexcs.equals(that.pbexcs) : that.pbexcs != null) return false;
        if (pbexs != null ? !pbexs.equals(that.pbexs) : that.pbexs != null) return false;
        if (pbfdcs != null ? !pbfdcs.equals(that.pbfdcs) : that.pbfdcs != null) return false;
        if (pbfds != null ? !pbfds.equals(that.pbfds) : that.pbfds != null) return false;
        if (pbfecs != null ? !pbfecs.equals(that.pbfecs) : that.pbfecs != null) return false;
        if (pbfes != null ? !pbfes.equals(that.pbfes) : that.pbfes != null) return false;
        if (pbficacs != null ? !pbficacs.equals(that.pbficacs) : that.pbficacs != null) return false;
        if (pbficas != null ? !pbficas.equals(that.pbficas) : that.pbficas != null) return false;
        if (pbfrics != null ? !pbfrics.equals(that.pbfrics) : that.pbfrics != null) return false;
        if (pbfris != null ? !pbfris.equals(that.pbfris) : that.pbfris != null) return false;
        if (pbfvcs != null ? !pbfvcs.equals(that.pbfvcs) : that.pbfvcs != null) return false;
        if (pbfvs != null ? !pbfvs.equals(that.pbfvs) : that.pbfvs != null) return false;
        if (pbfwagcs != null ? !pbfwagcs.equals(that.pbfwagcs) : that.pbfwagcs != null) return false;
        if (pbfwags != null ? !pbfwags.equals(that.pbfwags) : that.pbfwags != null) return false;
        if (pbhomes != null ? !pbhomes.equals(that.pbhomes) : that.pbhomes != null) return false;
        if (pbial1S != null ? !pbial1S.equals(that.pbial1S) : that.pbial1S != null) return false;
        if (pbial2S != null ? !pbial2S.equals(that.pbial2S) : that.pbial2S != null) return false;
        if (pbincacs != null ? !pbincacs.equals(that.pbincacs) : that.pbincacs != null) return false;
        if (pbincas != null ? !pbincas.equals(that.pbincas) : that.pbincas != null) return false;
        if (pbincsus != null ? !pbincsus.equals(that.pbincsus) : that.pbincsus != null) return false;
        if (pbitxcs != null ? !pbitxcs.equals(that.pbitxcs) : that.pbitxcs != null) return false;
        if (pbitxs != null ? !pbitxs.equals(that.pbitxs) : that.pbitxs != null) return false;
        if (pbmedacs != null ? !pbmedacs.equals(that.pbmedacs) : that.pbmedacs != null) return false;
        if (pbmedas != null ? !pbmedas.equals(that.pbmedas) : that.pbmedas != null) return false;
        if (pbmwagcs != null ? !pbmwagcs.equals(that.pbmwagcs) : that.pbmwagcs != null) return false;
        if (pbmwags != null ? !pbmwags.equals(that.pbmwags) : that.pbmwags != null) return false;
        if (pbntcscs != null ? !pbntcscs.equals(that.pbntcscs) : that.pbntcscs != null) return false;
        if (pbntcss != null ? !pbntcss.equals(that.pbntcss) : that.pbntcss != null) return false;
        if (pbntics != null ? !pbntics.equals(that.pbntics) : that.pbntics != null) return false;
        if (pbntis != null ? !pbntis.equals(that.pbntis) : that.pbntis != null) return false;
        if (pbnwrths != null ? !pbnwrths.equals(that.pbnwrths) : that.pbnwrths != null) return false;
        if (pbontics != null ? !pbontics.equals(that.pbontics) : that.pbontics != null) return false;
        if (pbontis != null ? !pbontis.equals(that.pbontis) : that.pbontis != null) return false;
        if (pbotics != null ? !pbotics.equals(that.pbotics) : that.pbotics != null) return false;
        if (pbotis != null ? !pbotis.equals(that.pbotis) : that.pbotis != null) return false;
        if (pbsmas != null ? !pbsmas.equals(that.pbsmas) : that.pbsmas != null) return false;
        if (pbsscs != null ? !pbsscs.equals(that.pbsscs) : that.pbsscs != null) return false;
        if (pbsss != null ? !pbsss.equals(that.pbsss) : that.pbsss != null) return false;
        if (pbsttxcs != null ? !pbsttxcs.equals(that.pbsttxcs) : that.pbsttxcs != null) return false;
        if (pbsttxs != null ? !pbsttxs.equals(that.pbsttxs) : that.pbsttxs != null) return false;
        if (pbtalos != null ? !pbtalos.equals(that.pbtalos) : that.pbtalos != null) return false;
        if (pbtics != null ? !pbtics.equals(that.pbtics) : that.pbtics != null) return false;
        if (pbtis != null ? !pbtis.equals(that.pbtis) : that.pbtis != null) return false;
        if (pbttics != null ? !pbttics.equals(that.pbttics) : that.pbttics != null) return false;
        if (pbttis != null ? !pbttis.equals(that.pbttis) : that.pbttis != null) return false;
        if (pbtuitas != null ? !pbtuitas.equals(that.pbtuitas) : that.pbtuitas != null) return false;
        if (pbtuits != null ? !pbtuits.equals(that.pbtuits) : that.pbtuits != null) return false;
        if (pcashcs != null ? !pcashcs.equals(that.pcashcs) : that.pcashcs != null) return false;
        if (pcashs != null ? !pcashs.equals(that.pcashs) : that.pcashs != null) return false;
        if (pcolacs != null ? !pcolacs.equals(that.pcolacs) : that.pcolacs != null) return false;
        if (pcolas != null ? !pcolas.equals(that.pcolas) : that.pcolas != null) return false;
        if (pconfcs != null ? !pconfcs.equals(that.pconfcs) : that.pconfcs != null) return false;
        if (pconfncs != null ? !pconfncs.equals(that.pconfncs) : that.pconfncs != null) return false;
        if (pconfns != null ? !pconfns.equals(that.pconfns) : that.pconfns != null) return false;
        if (pconfs != null ? !pconfs.equals(that.pconfs) : that.pconfs != null) return false;
        if (pdasscs != null ? !pdasscs.equals(that.pdasscs) : that.pdasscs != null) return false;
        if (pdasss != null ? !pdasss.equals(that.pdasss) : that.pdasss != null) return false;
        if (pdedcs != null ? !pdedcs.equals(that.pdedcs) : that.pdedcs != null) return false;
        if (pdeds != null ? !pdeds.equals(that.pdeds) : that.pdeds != null) return false;
        if (pdishmcs != null ? !pdishmcs.equals(that.pdishmcs) : that.pdishmcs != null) return false;
        if (pdishms != null ? !pdishms.equals(that.pdishms) : that.pdishms != null) return false;
        if (pdiswkcs != null ? !pdiswkcs.equals(that.pdiswkcs) : that.pdiswkcs != null) return false;
        if (pdiswks != null ? !pdiswks.equals(that.pdiswks) : that.pdiswks != null) return false;
        if (pdivcs != null ? !pdivcs.equals(that.pdivcs) : that.pdivcs != null) return false;
        if (pdivs != null ? !pdivs.equals(that.pdivs) : that.pdivs != null) return false;
        if (pdnetcs != null ? !pdnetcs.equals(that.pdnetcs) : that.pdnetcs != null) return false;
        if (pdnets != null ? !pdnets.equals(that.pdnets) : that.pdnets != null) return false;
        if (pefinccs != null ? !pefinccs.equals(that.pefinccs) : that.pefinccs != null) return false;
        if (pefincs != null ? !pefincs.equals(that.pefincs) : that.pefincs != null) return false;
        if (pelgfils != null ? !pelgfils.equals(that.pelgfils) : that.pelgfils != null) return false;
        if (pemalocs != null ? !pemalocs.equals(that.pemalocs) : that.pemalocs != null) return false;
        if (pemalos != null ? !pemalos.equals(that.pemalos) : that.pemalos != null) return false;
        if (perkchg != null ? !perkchg.equals(that.perkchg) : that.perkchg != null) return false;
        if (pexclds != null ? !pexclds.equals(that.pexclds) : that.pexclds != null) return false;
        if (pexempcs != null ? !pexempcs.equals(that.pexempcs) : that.pexempcs != null) return false;
        if (pexemps != null ? !pexemps.equals(that.pexemps) : that.pexemps != null) return false;
        if (pfarmcs != null ? !pfarmcs.equals(that.pfarmcs) : that.pfarmcs != null) return false;
        if (pfarmdcs != null ? !pfarmdcs.equals(that.pfarmdcs) : that.pfarmdcs != null) return false;
        if (pfarmds != null ? !pfarmds.equals(that.pfarmds) : that.pfarmds != null) return false;
        if (pfarmecs != null ? !pfarmecs.equals(that.pfarmecs) : that.pfarmecs != null) return false;
        if (pfarmes != null ? !pfarmes.equals(that.pfarmes) : that.pfarmes != null) return false;
        if (pfarms != null ? !pfarms.equals(that.pfarms) : that.pfarms != null) return false;
        if (pfarmvcs != null ? !pfarmvcs.equals(that.pfarmvcs) : that.pfarmvcs != null) return false;
        if (pfarmvs != null ? !pfarmvs.equals(that.pfarmvs) : that.pfarmvs != null) return false;
        if (pfedlvls != null ? !pfedlvls.equals(that.pfedlvls) : that.pfedlvls != null) return false;
        if (pficacs != null ? !pficacs.equals(that.pficacs) : that.pficacs != null) return false;
        if (pficas != null ? !pficas.equals(that.pficas) : that.pficas != null) return false;
        if (pfilrtns != null ? !pfilrtns.equals(that.pfilrtns) : that.pfilrtns != null) return false;
        if (pfwagcs != null ? !pfwagcs.equals(that.pfwagcs) : that.pfwagcs != null) return false;
        if (pfwags != null ? !pfwags.equals(that.pfwags) : that.pfwags != null) return false;
        if (phomccs != null ? !phomccs.equals(that.phomccs) : that.phomccs != null) return false;
        if (phomcs != null ? !phomcs.equals(that.phomcs) : that.phomcs != null) return false;
        if (phomdcs != null ? !phomdcs.equals(that.phomdcs) : that.phomdcs != null) return false;
        if (phomds != null ? !phomds.equals(that.phomds) : that.phomds != null) return false;
        if (phomecs != null ? !phomecs.equals(that.phomecs) : that.phomecs != null) return false;
        if (phomes != null ? !phomes.equals(that.phomes) : that.phomes != null) return false;
        if (phompvcs != null ? !phompvcs.equals(that.phompvcs) : that.phompvcs != null) return false;
        if (phompvs != null ? !phompvs.equals(that.phompvs) : that.phompvs != null) return false;
        if (phomvcs != null ? !phomvcs.equals(that.phomvcs) : that.phomvcs != null) return false;
        if (phomvs != null ? !phomvs.equals(that.phomvs) : that.phomvs != null) return false;
        if (phomyrcs != null ? !phomyrcs.equals(that.phomyrcs) : that.phomyrcs != null) return false;
        if (phomyrs != null ? !phomyrs.equals(that.phomyrs) : that.phomyrs != null) return false;
        if (phvpluss != null ? !phvpluss.equals(that.phvpluss) : that.phvpluss != null) return false;
        if (pialo1Cs != null ? !pialo1Cs.equals(that.pialo1Cs) : that.pialo1Cs != null) return false;
        if (pialo1S != null ? !pialo1S.equals(that.pialo1S) : that.pialo1S != null) return false;
        if (pialo2Cs != null ? !pialo2Cs.equals(that.pialo2Cs) : that.pialo2Cs != null) return false;
        if (pialo2S != null ? !pialo2S.equals(that.pialo2S) : that.pialo2S != null) return false;
        if (pinca1Cs != null ? !pinca1Cs.equals(that.pinca1Cs) : that.pinca1Cs != null) return false;
        if (pinca1S != null ? !pinca1S.equals(that.pinca1S) : that.pinca1S != null) return false;
        if (pinca2Cs != null ? !pinca2Cs.equals(that.pinca2Cs) : that.pinca2Cs != null) return false;
        if (pinca2S != null ? !pinca2S.equals(that.pinca2S) : that.pinca2S != null) return false;
        if (pinccrs != null ? !pinccrs.equals(that.pinccrs) : that.pinccrs != null) return false;
        if (pincolcs != null ? !pincolcs.equals(that.pincolcs) : that.pincolcs != null) return false;
        if (pincols != null ? !pincols.equals(that.pincols) : that.pincols != null) return false;
        if (pincsucs != null ? !pincsucs.equals(that.pincsucs) : that.pincsucs != null) return false;
        if (pincsus != null ? !pincsus.equals(that.pincsus) : that.pincsus != null) return false;
        if (pintcs != null ? !pintcs.equals(that.pintcs) : that.pintcs != null) return false;
        if (pints != null ? !pints.equals(that.pints) : that.pints != null) return false;
        if (pinvdcs != null ? !pinvdcs.equals(that.pinvdcs) : that.pinvdcs != null) return false;
        if (pinvds != null ? !pinvds.equals(that.pinvds) : that.pinvds != null) return false;
        if (pinvecs != null ? !pinvecs.equals(that.pinvecs) : that.pinvecs != null) return false;
        if (pinves != null ? !pinves.equals(that.pinves) : that.pinves != null) return false;
        if (pinvvcs != null ? !pinvvcs.equals(that.pinvvcs) : that.pinvvcs != null) return false;
        if (pinvvs != null ? !pinvvs.equals(that.pinvvs) : that.pinvvs != null) return false;
        if (pitxccs != null ? !pitxccs.equals(that.pitxccs) : that.pitxccs != null) return false;
        if (pitxcs != null ? !pitxcs.equals(that.pitxcs) : that.pitxcs != null) return false;
        if (pitxpcs != null ? !pitxpcs.equals(that.pitxpcs) : that.pitxpcs != null) return false;
        if (pitxps != null ? !pitxps.equals(that.pitxps) : that.pitxps != null) return false;
        if (pitxs != null ? !pitxs.equals(that.pitxs) : that.pitxs != null) return false;
        if (pitxxcs != null ? !pitxxcs.equals(that.pitxxcs) : that.pitxxcs != null) return false;
        if (plpychg != null ? !plpychg.equals(that.plpychg) : that.plpychg != null) return false;
        if (pmartlcs != null ? !pmartlcs.equals(that.pmartlcs) : that.pmartlcs != null) return false;
        if (pmartls != null ? !pmartls.equals(that.pmartls) : that.pmartls != null) return false;
        if (pmedacs != null ? !pmedacs.equals(that.pmedacs) : that.pmedacs != null) return false;
        if (pmedas != null ? !pmedas.equals(that.pmedas) : that.pmedas != null) return false;
        if (pmedcs != null ? !pmedcs.equals(that.pmedcs) : that.pmedcs != null) return false;
        if (pmedlvls != null ? !pmedlvls.equals(that.pmedlvls) : that.pmedlvls != null) return false;
        if (pmeds != null ? !pmeds.equals(that.pmeds) : that.pmeds != null) return false;
        if (pmwagcs != null ? !pmwagcs.equals(that.pmwagcs) : that.pmwagcs != null) return false;
        if (pmwags != null ? !pmwags.equals(that.pmwags) : that.pmwags != null) return false;
        if (pnrpscs != null ? !pnrpscs.equals(that.pnrpscs) : that.pnrpscs != null) return false;
        if (pnrpss != null ? !pnrpss.equals(that.pnrpss) : that.pnrpss != null) return false;
        if (pntcscs != null ? !pntcscs.equals(that.pntcscs) : that.pntcscs != null) return false;
        if (pntcss != null ? !pntcss.equals(that.pntcss) : that.pntcss != null) return false;
        if (pntuitcs != null ? !pntuitcs.equals(that.pntuitcs) : that.pntuitcs != null) return false;
        if (pntuits != null ? !pntuits.equals(that.pntuits) : that.pntuits != null) return false;
        if (pnwrthcs != null ? !pnwrthcs.equals(that.pnwrthcs) : that.pnwrthcs != null) return false;
        if (pnwrths != null ? !pnwrths.equals(that.pnwrths) : that.pnwrths != null) return false;
        if (pontics != null ? !pontics.equals(that.pontics) : that.pontics != null) return false;
        if (pontis != null ? !pontis.equals(that.pontis) : that.pontis != null) return false;
        if (pordcs != null ? !pordcs.equals(that.pordcs) : that.pordcs != null) return false;
        if (pords != null ? !pords.equals(that.pords) : that.pords != null) return false;
        if (porecs != null ? !porecs.equals(that.porecs) : that.porecs != null) return false;
        if (pores != null ? !pores.equals(that.pores) : that.pores != null) return false;
        if (porvcs != null ? !porvcs.equals(that.porvcs) : that.porvcs != null) return false;
        if (porvs != null ? !porvs.equals(that.porvs) : that.porvs != null) return false;
        if (pothdcs != null ? !pothdcs.equals(that.pothdcs) : that.pothdcs != null) return false;
        if (pothds != null ? !pothds.equals(that.pothds) : that.pothds != null) return false;
        if (potics != null ? !potics.equals(that.potics) : that.potics != null) return false;
        if (potis != null ? !potis.equals(that.potis) : that.potis != null) return false;
        if (pravlics != null ? !pravlics.equals(that.pravlics) : that.pravlics != null) return false;
        if (pravlis != null ? !pravlis.equals(that.pravlis) : that.pravlis != null) return false;
        if (presbfrs != null ? !presbfrs.equals(that.presbfrs) : that.presbfrs != null) return false;
        if (psmacs != null ? !psmacs.equals(that.psmacs) : that.psmacs != null) return false;
        if (psmas != null ? !psmas.equals(that.psmas) : that.psmas != null) return false;
        if (psscs != null ? !psscs.equals(that.psscs) : that.psscs != null) return false;
        if (psss != null ? !psss.equals(that.psss) : that.psss != null) return false;
        if (psttxcs != null ? !psttxcs.equals(that.psttxcs) : that.psttxcs != null) return false;
        if (psttxs != null ? !psttxs.equals(that.psttxs) : that.psttxs != null) return false;
        if (pszhhdcs != null ? !pszhhdcs.equals(that.pszhhdcs) : that.pszhhdcs != null) return false;
        if (pszhhds != null ? !pszhhds.equals(that.pszhhds) : that.pszhhds != null) return false;
        if (ptasscs != null ? !ptasscs.equals(that.ptasscs) : that.ptasscs != null) return false;
        if (ptasss != null ? !ptasss.equals(that.ptasss) : that.ptasss != null) return false;
        if (ptconfcs != null ? !ptconfcs.equals(that.ptconfcs) : that.ptconfcs != null) return false;
        if (ptconfs != null ? !ptconfs.equals(that.ptconfs) : that.ptconfs != null) return false;
        if (ptinccs != null ? !ptinccs.equals(that.ptinccs) : that.ptinccs != null) return false;
        if (ptincs != null ? !ptincs.equals(that.ptincs) : that.ptincs != null) return false;
        if (ptntis != null ? !ptntis.equals(that.ptntis) : that.ptntis != null) return false;
        if (ptotalcs != null ? !ptotalcs.equals(that.ptotalcs) : that.ptotalcs != null) return false;
        if (ptotals != null ? !ptotals.equals(that.ptotals) : that.ptotals != null) return false;
        if (ptrfilcs != null ? !ptrfilcs.equals(that.ptrfilcs) : that.ptrfilcs != null) return false;
        if (ptrfils != null ? !ptrfils.equals(that.ptrfils) : that.ptrfils != null) return false;
        if (pttinccs != null ? !pttinccs.equals(that.pttinccs) : that.pttinccs != null) return false;
        if (pttincs != null ? !pttincs.equals(that.pttincs) : that.pttincs != null) return false;
        if (ptuitacs != null ? !ptuitacs.equals(that.ptuitacs) : that.ptuitacs != null) return false;
        if (ptuitas != null ? !ptuitas.equals(that.ptuitas) : that.ptuitas != null) return false;
        if (ptuitcs != null ? !ptuitcs.equals(that.ptuitcs) : that.ptuitcs != null) return false;
        if (ptuits != null ? !ptuits.equals(that.ptuits) : that.ptuits != null) return false;
        if (pwagcs != null ? !pwagcs.equals(that.pwagcs) : that.pwagcs != null) return false;
        if (pwags != null ? !pwags.equals(that.pwags) : that.pwags != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (repychg != null ? !repychg.equals(that.repychg) : that.repychg != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sbasets != null ? !sbasets.equals(that.sbasets) : that.sbasets != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snpkey != null ? !snpkey.equals(that.snpkey) : that.snpkey != null) return false;
        if (ssnfats != null ? !ssnfats.equals(that.ssnfats) : that.ssnfats != null) return false;
        if (ssnmots != null ? !ssnmots.equals(that.ssnmots) : that.ssnmots != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snpkey != null ? snpkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cmptype != null ? cmptype.hashCode() : 0);
        result = 31 * result + (versnr != null ? versnr.hashCode() : 0);
        result = 31 * result + (pmartls != null ? pmartls.hashCode() : 0);
        result = 31 * result + (pfedlvls != null ? pfedlvls.hashCode() : 0);
        result = 31 * result + (pmedlvls != null ? pmedlvls.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (pszhhds != null ? pszhhds.hashCode() : 0);
        result = 31 * result + (pexemps != null ? pexemps.hashCode() : 0);
        result = 31 * result + (pnrpss != null ? pnrpss.hashCode() : 0);
        result = 31 * result + (pincols != null ? pincols.hashCode() : 0);
        result = 31 * result + (pdiswks != null ? pdiswks.hashCode() : 0);
        result = 31 * result + (pdishms != null ? pdishms.hashCode() : 0);
        result = 31 * result + (ptrfils != null ? ptrfils.hashCode() : 0);
        result = 31 * result + (pfwags != null ? pfwags.hashCode() : 0);
        result = 31 * result + (pmwags != null ? pmwags.hashCode() : 0);
        result = 31 * result + (padjws != null ? padjws.hashCode() : 0);
        result = 31 * result + (pwags != null ? pwags.hashCode() : 0);
        result = 31 * result + (pints != null ? pints.hashCode() : 0);
        result = 31 * result + (pdivs != null ? pdivs.hashCode() : 0);
        result = 31 * result + (pbfris != null ? pbfris.hashCode() : 0);
        result = 31 * result + (potis != null ? potis.hashCode() : 0);
        result = 31 * result + (pbexs != null ? pbexs.hashCode() : 0);
        result = 31 * result + (padjs != null ? padjs.hashCode() : 0);
        result = 31 * result + (pttincs != null ? pttincs.hashCode() : 0);
        result = 31 * result + (pagirs != null ? pagirs.hashCode() : 0);
        result = 31 * result + (psss != null ? psss.hashCode() : 0);
        result = 31 * result + (padcs != null ? padcs.hashCode() : 0);
        result = 31 * result + (pntcss != null ? pntcss.hashCode() : 0);
        result = 31 * result + (pontis != null ? pontis.hashCode() : 0);
        result = 31 * result + (pinca1S != null ? pinca1S.hashCode() : 0);
        result = 31 * result + (pinca2S != null ? pinca2S.hashCode() : 0);
        result = 31 * result + (ptincs != null ? ptincs.hashCode() : 0);
        result = 31 * result + (pdeds != null ? pdeds.hashCode() : 0);
        result = 31 * result + (pitxps != null ? pitxps.hashCode() : 0);
        result = 31 * result + (pitxcs != null ? pitxcs.hashCode() : 0);
        result = 31 * result + (pitxs != null ? pitxs.hashCode() : 0);
        result = 31 * result + (pficas != null ? pficas.hashCode() : 0);
        result = 31 * result + (psttxs != null ? psttxs.hashCode() : 0);
        result = 31 * result + (pmeds != null ? pmeds.hashCode() : 0);
        result = 31 * result + (pmedas != null ? pmedas.hashCode() : 0);
        result = 31 * result + (ptuits != null ? ptuits.hashCode() : 0);
        result = 31 * result + (pntuits != null ? pntuits.hashCode() : 0);
        result = 31 * result + (ptuitas != null ? ptuitas.hashCode() : 0);
        result = 31 * result + (pemalos != null ? pemalos.hashCode() : 0);
        result = 31 * result + (psmas != null ? psmas.hashCode() : 0);
        result = 31 * result + (pialo1S != null ? pialo1S.hashCode() : 0);
        result = 31 * result + (pialo2S != null ? pialo2S.hashCode() : 0);
        result = 31 * result + (ptotals != null ? ptotals.hashCode() : 0);
        result = 31 * result + (pefincs != null ? pefincs.hashCode() : 0);
        result = 31 * result + (pcashs != null ? pcashs.hashCode() : 0);
        result = 31 * result + (pinvvs != null ? pinvvs.hashCode() : 0);
        result = 31 * result + (pinvds != null ? pinvds.hashCode() : 0);
        result = 31 * result + (pinves != null ? pinves.hashCode() : 0);
        result = 31 * result + (porvs != null ? porvs.hashCode() : 0);
        result = 31 * result + (pords != null ? pords.hashCode() : 0);
        result = 31 * result + (pores != null ? pores.hashCode() : 0);
        result = 31 * result + (pdasss != null ? pdasss.hashCode() : 0);
        result = 31 * result + (phomyrs != null ? phomyrs.hashCode() : 0);
        result = 31 * result + (phompvs != null ? phompvs.hashCode() : 0);
        result = 31 * result + (phomcs != null ? phomcs.hashCode() : 0);
        result = 31 * result + (phomvs != null ? phomvs.hashCode() : 0);
        result = 31 * result + (phomds != null ? phomds.hashCode() : 0);
        result = 31 * result + (phomes != null ? phomes.hashCode() : 0);
        result = 31 * result + (pfarmvs != null ? pfarmvs.hashCode() : 0);
        result = 31 * result + (pfarmds != null ? pfarmds.hashCode() : 0);
        result = 31 * result + (pfarmes != null ? pfarmes.hashCode() : 0);
        result = 31 * result + (pbfvs != null ? pbfvs.hashCode() : 0);
        result = 31 * result + (pbfds != null ? pbfds.hashCode() : 0);
        result = 31 * result + (pbfes != null ? pbfes.hashCode() : 0);
        result = 31 * result + (pfarms != null ? pfarms.hashCode() : 0);
        result = 31 * result + (pabfws != null ? pabfws.hashCode() : 0);
        result = 31 * result + (passads != null ? passads.hashCode() : 0);
        result = 31 * result + (ptasss != null ? ptasss.hashCode() : 0);
        result = 31 * result + (pothds != null ? pothds.hashCode() : 0);
        result = 31 * result + (pnwrths != null ? pnwrths.hashCode() : 0);
        result = 31 * result + (papas != null ? papas.hashCode() : 0);
        result = 31 * result + (pdnets != null ? pdnets.hashCode() : 0);
        result = 31 * result + (passcrs != null ? passcrs.hashCode() : 0);
        result = 31 * result + (pincsus != null ? pincsus.hashCode() : 0);
        result = 31 * result + (paavlis != null ? paavlis.hashCode() : 0);
        result = 31 * result + (pcolas != null ? pcolas.hashCode() : 0);
        result = 31 * result + (pravlis != null ? pravlis.hashCode() : 0);
        result = 31 * result + (ptconfs != null ? ptconfs.hashCode() : 0);
        result = 31 * result + (pconfns != null ? pconfns.hashCode() : 0);
        result = 31 * result + (pconfs != null ? pconfs.hashCode() : 0);
        result = 31 * result + (pbfwags != null ? pbfwags.hashCode() : 0);
        result = 31 * result + (pbmwags != null ? pbmwags.hashCode() : 0);
        result = 31 * result + (pbotis != null ? pbotis.hashCode() : 0);
        result = 31 * result + (pbttis != null ? pbttis.hashCode() : 0);
        result = 31 * result + (pbagirs != null ? pbagirs.hashCode() : 0);
        result = 31 * result + (pbsss != null ? pbsss.hashCode() : 0);
        result = 31 * result + (pbadcs != null ? pbadcs.hashCode() : 0);
        result = 31 * result + (pbntcss != null ? pbntcss.hashCode() : 0);
        result = 31 * result + (pbontis != null ? pbontis.hashCode() : 0);
        result = 31 * result + (pbincas != null ? pbincas.hashCode() : 0);
        result = 31 * result + (pbntis != null ? pbntis.hashCode() : 0);
        result = 31 * result + (pbtis != null ? pbtis.hashCode() : 0);
        result = 31 * result + (pbitxs != null ? pbitxs.hashCode() : 0);
        result = 31 * result + (pbficas != null ? pbficas.hashCode() : 0);
        result = 31 * result + (pbsttxs != null ? pbsttxs.hashCode() : 0);
        result = 31 * result + (pbmedas != null ? pbmedas.hashCode() : 0);
        result = 31 * result + (pbtuits != null ? pbtuits.hashCode() : 0);
        result = 31 * result + (pbemals != null ? pbemals.hashCode() : 0);
        result = 31 * result + (pbsmas != null ? pbsmas.hashCode() : 0);
        result = 31 * result + (pbial1S != null ? pbial1S.hashCode() : 0);
        result = 31 * result + (pbial2S != null ? pbial2S.hashCode() : 0);
        result = 31 * result + (pbtalos != null ? pbtalos.hashCode() : 0);
        result = 31 * result + (pbefins != null ? pbefins.hashCode() : 0);
        result = 31 * result + (ptntis != null ? ptntis.hashCode() : 0);
        result = 31 * result + (pbtuitas != null ? pbtuitas.hashCode() : 0);
        result = 31 * result + (pbnwrths != null ? pbnwrths.hashCode() : 0);
        result = 31 * result + (pbapas != null ? pbapas.hashCode() : 0);
        result = 31 * result + (pbdnets != null ? pbdnets.hashCode() : 0);
        result = 31 * result + (pbasscrs != null ? pbasscrs.hashCode() : 0);
        result = 31 * result + (pbincsus != null ? pbincsus.hashCode() : 0);
        result = 31 * result + (pbaavlis != null ? pbaavlis.hashCode() : 0);
        result = 31 * result + (pbhomes != null ? pbhomes.hashCode() : 0);
        result = 31 * result + (pbabfws != null ? pbabfws.hashCode() : 0);
        result = 31 * result + (pbconfs != null ? pbconfs.hashCode() : 0);
        result = 31 * result + (pexclds != null ? pexclds.hashCode() : 0);
        result = 31 * result + (phvpluss != null ? phvpluss.hashCode() : 0);
        result = 31 * result + (pinccrs != null ? pinccrs.hashCode() : 0);
        result = 31 * result + (sbasets != null ? sbasets.hashCode() : 0);
        result = 31 * result + (disbpri != null ? disbpri.hashCode() : 0);
        result = 31 * result + (deflchg != null ? deflchg.hashCode() : 0);
        result = 31 * result + (discchg != null ? discchg.hashCode() : 0);
        result = 31 * result + (repychg != null ? repychg.hashCode() : 0);
        result = 31 * result + (bankchg != null ? bankchg.hashCode() : 0);
        result = 31 * result + (opaychg != null ? opaychg.hashCode() : 0);
        result = 31 * result + (aggrchg != null ? aggrchg.hashCode() : 0);
        result = 31 * result + (perkchg != null ? perkchg.hashCode() : 0);
        result = 31 * result + (plpychg != null ? plpychg.hashCode() : 0);
        result = 31 * result + (addlpel != null ? addlpel.hashCode() : 0);
        result = 31 * result + (addloan != null ? addloan.hashCode() : 0);
        result = 31 * result + (pfilrtns != null ? pfilrtns.hashCode() : 0);
        result = 31 * result + (pelgfils != null ? pelgfils.hashCode() : 0);
        result = 31 * result + (presbfrs != null ? presbfrs.hashCode() : 0);
        result = 31 * result + (namefls != null ? namefls.hashCode() : 0);
        result = 31 * result + (ssnfats != null ? ssnfats.hashCode() : 0);
        result = 31 * result + (namemls != null ? namemls.hashCode() : 0);
        result = 31 * result + (ssnmots != null ? ssnmots.hashCode() : 0);
        result = 31 * result + (pmartlcs != null ? pmartlcs.hashCode() : 0);
        result = 31 * result + (pagecs != null ? pagecs.hashCode() : 0);
        result = 31 * result + (pszhhdcs != null ? pszhhdcs.hashCode() : 0);
        result = 31 * result + (pexempcs != null ? pexempcs.hashCode() : 0);
        result = 31 * result + (pnrpscs != null ? pnrpscs.hashCode() : 0);
        result = 31 * result + (pincolcs != null ? pincolcs.hashCode() : 0);
        result = 31 * result + (pdiswkcs != null ? pdiswkcs.hashCode() : 0);
        result = 31 * result + (pdishmcs != null ? pdishmcs.hashCode() : 0);
        result = 31 * result + (ptrfilcs != null ? ptrfilcs.hashCode() : 0);
        result = 31 * result + (pfwagcs != null ? pfwagcs.hashCode() : 0);
        result = 31 * result + (pmwagcs != null ? pmwagcs.hashCode() : 0);
        result = 31 * result + (padjwcs != null ? padjwcs.hashCode() : 0);
        result = 31 * result + (pwagcs != null ? pwagcs.hashCode() : 0);
        result = 31 * result + (pintcs != null ? pintcs.hashCode() : 0);
        result = 31 * result + (pdivcs != null ? pdivcs.hashCode() : 0);
        result = 31 * result + (pbfrics != null ? pbfrics.hashCode() : 0);
        result = 31 * result + (potics != null ? potics.hashCode() : 0);
        result = 31 * result + (pbexcs != null ? pbexcs.hashCode() : 0);
        result = 31 * result + (padjcs != null ? padjcs.hashCode() : 0);
        result = 31 * result + (pttinccs != null ? pttinccs.hashCode() : 0);
        result = 31 * result + (pagircs != null ? pagircs.hashCode() : 0);
        result = 31 * result + (psscs != null ? psscs.hashCode() : 0);
        result = 31 * result + (padccs != null ? padccs.hashCode() : 0);
        result = 31 * result + (pntcscs != null ? pntcscs.hashCode() : 0);
        result = 31 * result + (pontics != null ? pontics.hashCode() : 0);
        result = 31 * result + (pinca1Cs != null ? pinca1Cs.hashCode() : 0);
        result = 31 * result + (pinca2Cs != null ? pinca2Cs.hashCode() : 0);
        result = 31 * result + (ptinccs != null ? ptinccs.hashCode() : 0);
        result = 31 * result + (pdedcs != null ? pdedcs.hashCode() : 0);
        result = 31 * result + (pitxpcs != null ? pitxpcs.hashCode() : 0);
        result = 31 * result + (pitxccs != null ? pitxccs.hashCode() : 0);
        result = 31 * result + (pitxxcs != null ? pitxxcs.hashCode() : 0);
        result = 31 * result + (pficacs != null ? pficacs.hashCode() : 0);
        result = 31 * result + (psttxcs != null ? psttxcs.hashCode() : 0);
        result = 31 * result + (pmedcs != null ? pmedcs.hashCode() : 0);
        result = 31 * result + (pmedacs != null ? pmedacs.hashCode() : 0);
        result = 31 * result + (ptuitcs != null ? ptuitcs.hashCode() : 0);
        result = 31 * result + (pntuitcs != null ? pntuitcs.hashCode() : 0);
        result = 31 * result + (ptuitacs != null ? ptuitacs.hashCode() : 0);
        result = 31 * result + (pemalocs != null ? pemalocs.hashCode() : 0);
        result = 31 * result + (psmacs != null ? psmacs.hashCode() : 0);
        result = 31 * result + (pialo1Cs != null ? pialo1Cs.hashCode() : 0);
        result = 31 * result + (pialo2Cs != null ? pialo2Cs.hashCode() : 0);
        result = 31 * result + (ptotalcs != null ? ptotalcs.hashCode() : 0);
        result = 31 * result + (pefinccs != null ? pefinccs.hashCode() : 0);
        result = 31 * result + (pcashcs != null ? pcashcs.hashCode() : 0);
        result = 31 * result + (pinvvcs != null ? pinvvcs.hashCode() : 0);
        result = 31 * result + (pinvdcs != null ? pinvdcs.hashCode() : 0);
        result = 31 * result + (pinvecs != null ? pinvecs.hashCode() : 0);
        result = 31 * result + (porvcs != null ? porvcs.hashCode() : 0);
        result = 31 * result + (pordcs != null ? pordcs.hashCode() : 0);
        result = 31 * result + (porecs != null ? porecs.hashCode() : 0);
        result = 31 * result + (pdasscs != null ? pdasscs.hashCode() : 0);
        result = 31 * result + (phomyrcs != null ? phomyrcs.hashCode() : 0);
        result = 31 * result + (phompvcs != null ? phompvcs.hashCode() : 0);
        result = 31 * result + (phomccs != null ? phomccs.hashCode() : 0);
        result = 31 * result + (phomvcs != null ? phomvcs.hashCode() : 0);
        result = 31 * result + (phomdcs != null ? phomdcs.hashCode() : 0);
        result = 31 * result + (phomecs != null ? phomecs.hashCode() : 0);
        result = 31 * result + (pfarmvcs != null ? pfarmvcs.hashCode() : 0);
        result = 31 * result + (pfarmdcs != null ? pfarmdcs.hashCode() : 0);
        result = 31 * result + (pfarmecs != null ? pfarmecs.hashCode() : 0);
        result = 31 * result + (pbfvcs != null ? pbfvcs.hashCode() : 0);
        result = 31 * result + (pbfdcs != null ? pbfdcs.hashCode() : 0);
        result = 31 * result + (pbfecs != null ? pbfecs.hashCode() : 0);
        result = 31 * result + (pfarmcs != null ? pfarmcs.hashCode() : 0);
        result = 31 * result + (pabfwcs != null ? pabfwcs.hashCode() : 0);
        result = 31 * result + (passadcs != null ? passadcs.hashCode() : 0);
        result = 31 * result + (ptasscs != null ? ptasscs.hashCode() : 0);
        result = 31 * result + (pothdcs != null ? pothdcs.hashCode() : 0);
        result = 31 * result + (pnwrthcs != null ? pnwrthcs.hashCode() : 0);
        result = 31 * result + (papacs != null ? papacs.hashCode() : 0);
        result = 31 * result + (pdnetcs != null ? pdnetcs.hashCode() : 0);
        result = 31 * result + (passcrcs != null ? passcrcs.hashCode() : 0);
        result = 31 * result + (pincsucs != null ? pincsucs.hashCode() : 0);
        result = 31 * result + (paavlics != null ? paavlics.hashCode() : 0);
        result = 31 * result + (pcolacs != null ? pcolacs.hashCode() : 0);
        result = 31 * result + (pravlics != null ? pravlics.hashCode() : 0);
        result = 31 * result + (ptconfcs != null ? ptconfcs.hashCode() : 0);
        result = 31 * result + (pconfncs != null ? pconfncs.hashCode() : 0);
        result = 31 * result + (pconfcs != null ? pconfcs.hashCode() : 0);
        result = 31 * result + (pbfwagcs != null ? pbfwagcs.hashCode() : 0);
        result = 31 * result + (pbmwagcs != null ? pbmwagcs.hashCode() : 0);
        result = 31 * result + (pbotics != null ? pbotics.hashCode() : 0);
        result = 31 * result + (pbttics != null ? pbttics.hashCode() : 0);
        result = 31 * result + (pbagircs != null ? pbagircs.hashCode() : 0);
        result = 31 * result + (pbsscs != null ? pbsscs.hashCode() : 0);
        result = 31 * result + (pbadccs != null ? pbadccs.hashCode() : 0);
        result = 31 * result + (pbntcscs != null ? pbntcscs.hashCode() : 0);
        result = 31 * result + (pbontics != null ? pbontics.hashCode() : 0);
        result = 31 * result + (pbincacs != null ? pbincacs.hashCode() : 0);
        result = 31 * result + (pbntics != null ? pbntics.hashCode() : 0);
        result = 31 * result + (pbtics != null ? pbtics.hashCode() : 0);
        result = 31 * result + (pbitxcs != null ? pbitxcs.hashCode() : 0);
        result = 31 * result + (pbficacs != null ? pbficacs.hashCode() : 0);
        result = 31 * result + (pbsttxcs != null ? pbsttxcs.hashCode() : 0);
        result = 31 * result + (pbmedacs != null ? pbmedacs.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
