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
 * Time: 12:17 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNS4", schema = "SIGMA", catalog = "")
@Entity
public class Sns4Entity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnskey();
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

    private String snskey;

    @javax.persistence.Column(name = "SNSKEY")
    @Id
    public String getSnskey() {
        return snskey;
    }

    public void setSnskey(String snskey) {
        this.snskey = snskey;
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

    private String smartls;

    @javax.persistence.Column(name = "SMARTLS")
    @Basic
    public String getSmartls() {
        return smartls;
    }

    public void setSmartls(String smartls) {
        this.smartls = smartls;
    }

    private String sages;

    @javax.persistence.Column(name = "SAGES")
    @Basic
    public String getSages() {
        return sages;
    }

    public void setSages(String sages) {
        this.sages = sages;
    }

    private String sszhhds;

    @javax.persistence.Column(name = "SSZHHDS")
    @Basic
    public String getSszhhds() {
        return sszhhds;
    }

    public void setSszhhds(String sszhhds) {
        this.sszhhds = sszhhds;
    }

    private String sexemps;

    @javax.persistence.Column(name = "SEXEMPS")
    @Basic
    public String getSexemps() {
        return sexemps;
    }

    public void setSexemps(String sexemps) {
        this.sexemps = sexemps;
    }

    private String snrpss;

    @javax.persistence.Column(name = "SNRPSS")
    @Basic
    public String getSnrpss() {
        return snrpss;
    }

    public void setSnrpss(String snrpss) {
        this.snrpss = snrpss;
    }

    private String sdiswks;

    @javax.persistence.Column(name = "SDISWKS")
    @Basic
    public String getSdiswks() {
        return sdiswks;
    }

    public void setSdiswks(String sdiswks) {
        this.sdiswks = sdiswks;
    }

    private String sdishms;

    @javax.persistence.Column(name = "SDISHMS")
    @Basic
    public String getSdishms() {
        return sdishms;
    }

    public void setSdishms(String sdishms) {
        this.sdishms = sdishms;
    }

    private String strfils;

    @javax.persistence.Column(name = "STRFILS")
    @Basic
    public String getStrfils() {
        return strfils;
    }

    public void setStrfils(String strfils) {
        this.strfils = strfils;
    }

    private String sselsrvs;

    @javax.persistence.Column(name = "SSELSRVS")
    @Basic
    public String getSselsrvs() {
        return sselsrvs;
    }

    public void setSselsrvs(String sselsrvs) {
        this.sselsrvs = sselsrvs;
    }

    private String sslsrvms;

    @javax.persistence.Column(name = "SSLSRVMS")
    @Basic
    public String getSslsrvms() {
        return sslsrvms;
    }

    public void setSslsrvms(String sslsrvms) {
        this.sslsrvms = sslsrvms;
    }

    private String sinsflgs;

    @javax.persistence.Column(name = "SINSFLGS")
    @Basic
    public String getSinsflgs() {
        return sinsflgs;
    }

    public void setSinsflgs(String sinsflgs) {
        this.sinsflgs = sinsflgs;
    }

    private String sadag1S;

    @javax.persistence.Column(name = "SADAG1S")
    @Basic
    public String getSadag1S() {
        return sadag1S;
    }

    public void setSadag1S(String sadag1S) {
        this.sadag1S = sadag1S;
    }

    private String sadag2S;

    @javax.persistence.Column(name = "SADAG2S")
    @Basic
    public String getSadag2S() {
        return sadag2S;
    }

    public void setSadag2S(String sadag2S) {
        this.sadag2S = sadag2S;
    }

    private String sadag3S;

    @javax.persistence.Column(name = "SADAG3S")
    @Basic
    public String getSadag3S() {
        return sadag3S;
    }

    public void setSadag3S(String sadag3S) {
        this.sadag3S = sadag3S;
    }

    private String sfarms;

    @javax.persistence.Column(name = "SFARMS")
    @Basic
    public String getSfarms() {
        return sfarms;
    }

    public void setSfarms(String sfarms) {
        this.sfarms = sfarms;
    }

    private String sagims;

    @javax.persistence.Column(name = "SAGIMS")
    @Basic
    public String getSagims() {
        return sagims;
    }

    public void setSagims(String sagims) {
        this.sagims = sagims;
    }

    private String sagias;

    @javax.persistence.Column(name = "SAGIAS")
    @Basic
    public String getSagias() {
        return sagias;
    }

    public void setSagias(String sagias) {
        this.sagias = sagias;
    }

    private String sagis;

    @javax.persistence.Column(name = "SAGIS")
    @Basic
    public String getSagis() {
        return sagis;
    }

    public void setSagis(String sagis) {
        this.sagis = sagis;
    }

    private String savcms;

    @javax.persistence.Column(name = "SAVCMS")
    @Basic
    public String getSavcms() {
        return savcms;
    }

    public void setSavcms(String savcms) {
        this.savcms = savcms;
    }

    private String savcas;

    @javax.persistence.Column(name = "SAVCAS")
    @Basic
    public String getSavcas() {
        return savcas;
    }

    public void setSavcas(String savcas) {
        this.savcas = savcas;
    }

    private String savcs;

    @javax.persistence.Column(name = "SAVCS")
    @Basic
    public String getSavcs() {
        return savcs;
    }

    public void setSavcs(String savcs) {
        this.savcs = savcs;
    }

    private String savoms;

    @javax.persistence.Column(name = "SAVOMS")
    @Basic
    public String getSavoms() {
        return savoms;
    }

    public void setSavoms(String savoms) {
        this.savoms = savoms;
    }

    private String savoas;

    @javax.persistence.Column(name = "SAVOAS")
    @Basic
    public String getSavoas() {
        return savoas;
    }

    public void setSavoas(String savoas) {
        this.savoas = savoas;
    }

    private String savos;

    @javax.persistence.Column(name = "SAVOS")
    @Basic
    public String getSavos() {
        return savos;
    }

    public void setSavos(String savos) {
        this.savos = savos;
    }

    private String savabus;

    @javax.persistence.Column(name = "SAVABUS")
    @Basic
    public String getSavabus() {
        return savabus;
    }

    public void setSavabus(String savabus) {
        this.savabus = savabus;
    }

    private String savabns;

    @javax.persistence.Column(name = "SAVABNS")
    @Basic
    public String getSavabns() {
        return savabns;
    }

    public void setSavabns(String savabns) {
        this.savabns = savabns;
    }

    private String savabas;

    @javax.persistence.Column(name = "SAVABAS")
    @Basic
    public String getSavabas() {
        return savabas;
    }

    public void setSavabas(String savabas) {
        this.savabas = savabas;
    }

    private String sawags;

    @javax.persistence.Column(name = "SAWAGS")
    @Basic
    public String getSawags() {
        return sawags;
    }

    public void setSawags(String sawags) {
        this.sawags = sawags;
    }

    private String saspsws;

    @javax.persistence.Column(name = "SASPSWS")
    @Basic
    public String getSaspsws() {
        return saspsws;
    }

    public void setSaspsws(String saspsws) {
        this.saspsws = saspsws;
    }

    private String saadjs;

    @javax.persistence.Column(name = "SAADJS")
    @Basic
    public String getSaadjs() {
        return saadjs;
    }

    public void setSaadjs(String saadjs) {
        this.saadjs = saadjs;
    }

    private String saotis;

    @javax.persistence.Column(name = "SAOTIS")
    @Basic
    public String getSaotis() {
        return saotis;
    }

    public void setSaotis(String saotis) {
        this.saotis = saotis;
    }

    private String sattis;

    @javax.persistence.Column(name = "SATTIS")
    @Basic
    public String getSattis() {
        return sattis;
    }

    public void setSattis(String sattis) {
        this.sattis = sattis;
    }

    private String saagis;

    @javax.persistence.Column(name = "SAAGIS")
    @Basic
    public String getSaagis() {
        return saagis;
    }

    public void setSaagis(String saagis) {
        this.saagis = saagis;
    }

    private String sasss;

    @javax.persistence.Column(name = "SASSS")
    @Basic
    public String getSasss() {
        return sasss;
    }

    public void setSasss(String sasss) {
        this.sasss = sasss;
    }

    private String saadcs;

    @javax.persistence.Column(name = "SAADCS")
    @Basic
    public String getSaadcs() {
        return saadcs;
    }

    public void setSaadcs(String saadcs) {
        this.saadcs = saadcs;
    }

    private String sacss;

    @javax.persistence.Column(name = "SACSS")
    @Basic
    public String getSacss() {
        return sacss;
    }

    public void setSacss(String sacss) {
        this.sacss = sacss;
    }

    private String saontis;

    @javax.persistence.Column(name = "SAONTIS")
    @Basic
    public String getSaontis() {
        return saontis;
    }

    public void setSaontis(String saontis) {
        this.saontis = saontis;
    }

    private String santx1S;

    @javax.persistence.Column(name = "SANTX1S")
    @Basic
    public String getSantx1S() {
        return santx1S;
    }

    public void setSantx1S(String santx1S) {
        this.santx1S = santx1S;
    }

    private String santx2S;

    @javax.persistence.Column(name = "SANTX2S")
    @Basic
    public String getSantx2S() {
        return santx2S;
    }

    public void setSantx2S(String santx2S) {
        this.santx2S = santx2S;
    }

    private String satntis;

    @javax.persistence.Column(name = "SATNTIS")
    @Basic
    public String getSatntis() {
        return satntis;
    }

    public void setSatntis(String satntis) {
        this.satntis = satntis;
    }

    private String satincs;

    @javax.persistence.Column(name = "SATINCS")
    @Basic
    public String getSatincs() {
        return satincs;
    }

    public void setSatincs(String satincs) {
        this.satincs = satincs;
    }

    private String sadeds;

    @javax.persistence.Column(name = "SADEDS")
    @Basic
    public String getSadeds() {
        return sadeds;
    }

    public void setSadeds(String sadeds) {
        this.sadeds = sadeds;
    }

    private String saitxs;

    @javax.persistence.Column(name = "SAITXS")
    @Basic
    public String getSaitxs() {
        return saitxs;
    }

    public void setSaitxs(String saitxs) {
        this.saitxs = saitxs;
    }

    private String saitxcs;

    @javax.persistence.Column(name = "SAITXCS")
    @Basic
    public String getSaitxcs() {
        return saitxcs;
    }

    public void setSaitxcs(String saitxcs) {
        this.saitxcs = saitxcs;
    }

    private String saitxus;

    @javax.persistence.Column(name = "SAITXUS")
    @Basic
    public String getSaitxus() {
        return saitxus;
    }

    public void setSaitxus(String saitxus) {
        this.saitxus = saitxus;
    }

    private String saficas;

    @javax.persistence.Column(name = "SAFICAS")
    @Basic
    public String getSaficas() {
        return saficas;
    }

    public void setSaficas(String saficas) {
        this.saficas = saficas;
    }

    private String sasttxs;

    @javax.persistence.Column(name = "SASTTXS")
    @Basic
    public String getSasttxs() {
        return sasttxs;
    }

    public void setSasttxs(String sasttxs) {
        this.sasttxs = sasttxs;
    }

    private String sameds;

    @javax.persistence.Column(name = "SAMEDS")
    @Basic
    public String getSameds() {
        return sameds;
    }

    public void setSameds(String sameds) {
        this.sameds = sameds;
    }

    private String samedas;

    @javax.persistence.Column(name = "SAMEDAS")
    @Basic
    public String getSamedas() {
        return samedas;
    }

    public void setSamedas(String samedas) {
        this.samedas = samedas;
    }

    private String satuits;

    @javax.persistence.Column(name = "SATUITS")
    @Basic
    public String getSatuits() {
        return satuits;
    }

    public void setSatuits(String satuits) {
        this.satuits = satuits;
    }

    private String satutns;

    @javax.persistence.Column(name = "SATUTNS")
    @Basic
    public String getSatutns() {
        return satutns;
    }

    public void setSatutns(String satutns) {
        this.satutns = satutns;
    }

    private String satutas;

    @javax.persistence.Column(name = "SATUTAS")
    @Basic
    public String getSatutas() {
        return satutas;
    }

    public void setSatutas(String satutas) {
        this.satutas = satutas;
    }

    private String saemals;

    @javax.persistence.Column(name = "SAEMALS")
    @Basic
    public String getSaemals() {
        return saemals;
    }

    public void setSaemals(String saemals) {
        this.saemals = saemals;
    }

    private String sasmas;

    @javax.persistence.Column(name = "SASMAS")
    @Basic
    public String getSasmas() {
        return sasmas;
    }

    public void setSasmas(String sasmas) {
        this.sasmas = sasmas;
    }

    private String saial1S;

    @javax.persistence.Column(name = "SAIAL1S")
    @Basic
    public String getSaial1S() {
        return saial1S;
    }

    public void setSaial1S(String saial1S) {
        this.saial1S = saial1S;
    }

    private String saial2S;

    @javax.persistence.Column(name = "SAIAL2S")
    @Basic
    public String getSaial2S() {
        return saial2S;
    }

    public void setSaial2S(String saial2S) {
        this.saial2S = saial2S;
    }

    private String satalos;

    @javax.persistence.Column(name = "SATALOS")
    @Basic
    public String getSatalos() {
        return satalos;
    }

    public void setSatalos(String satalos) {
        this.satalos = satalos;
    }

    private String saefins;

    @javax.persistence.Column(name = "SAEFINS")
    @Basic
    public String getSaefins() {
        return saefins;
    }

    public void setSaefins(String saefins) {
        this.saefins = saefins;
    }

    private String scashs;

    @javax.persistence.Column(name = "SCASHS")
    @Basic
    public String getScashs() {
        return scashs;
    }

    public void setScashs(String scashs) {
        this.scashs = scashs;
    }

    private String shomvs;

    @javax.persistence.Column(name = "SHOMVS")
    @Basic
    public String getShomvs() {
        return shomvs;
    }

    public void setShomvs(String shomvs) {
        this.shomvs = shomvs;
    }

    private String shomds;

    @javax.persistence.Column(name = "SHOMDS")
    @Basic
    public String getShomds() {
        return shomds;
    }

    public void setShomds(String shomds) {
        this.shomds = shomds;
    }

    private String shomes;

    @javax.persistence.Column(name = "SHOMES")
    @Basic
    public String getShomes() {
        return shomes;
    }

    public void setShomes(String shomes) {
        this.shomes = shomes;
    }

    private String sfarmvs;

    @javax.persistence.Column(name = "SFARMVS")
    @Basic
    public String getSfarmvs() {
        return sfarmvs;
    }

    public void setSfarmvs(String sfarmvs) {
        this.sfarmvs = sfarmvs;
    }

    private String sfarmds;

    @javax.persistence.Column(name = "SFARMDS")
    @Basic
    public String getSfarmds() {
        return sfarmds;
    }

    public void setSfarmds(String sfarmds) {
        this.sfarmds = sfarmds;
    }

    private String sfarmes;

    @javax.persistence.Column(name = "SFARMES")
    @Basic
    public String getSfarmes() {
        return sfarmes;
    }

    public void setSfarmes(String sfarmes) {
        this.sfarmes = sfarmes;
    }

    private String sorivs;

    @javax.persistence.Column(name = "SORIVS")
    @Basic
    public String getSorivs() {
        return sorivs;
    }

    public void setSorivs(String sorivs) {
        this.sorivs = sorivs;
    }

    private String sorids;

    @javax.persistence.Column(name = "SORIDS")
    @Basic
    public String getSorids() {
        return sorids;
    }

    public void setSorids(String sorids) {
        this.sorids = sorids;
    }

    private String sories;

    @javax.persistence.Column(name = "SORIES")
    @Basic
    public String getSories() {
        return sories;
    }

    public void setSories(String sories) {
        this.sories = sories;
    }

    private String sbfvs;

    @javax.persistence.Column(name = "SBFVS")
    @Basic
    public String getSbfvs() {
        return sbfvs;
    }

    public void setSbfvs(String sbfvs) {
        this.sbfvs = sbfvs;
    }

    private String sbfds;

    @javax.persistence.Column(name = "SBFDS")
    @Basic
    public String getSbfds() {
        return sbfds;
    }

    public void setSbfds(String sbfds) {
        this.sbfds = sbfds;
    }

    private String sbfes;

    @javax.persistence.Column(name = "SBFES")
    @Basic
    public String getSbfes() {
        return sbfes;
    }

    public void setSbfes(String sbfes) {
        this.sbfes = sbfes;
    }

    private String sbfavs;

    @javax.persistence.Column(name = "SBFAVS")
    @Basic
    public String getSbfavs() {
        return sbfavs;
    }

    public void setSbfavs(String sbfavs) {
        this.sbfavs = sbfavs;
    }

    private String sassads;

    @javax.persistence.Column(name = "SASSADS")
    @Basic
    public String getSassads() {
        return sassads;
    }

    public void setSassads(String sassads) {
        this.sassads = sassads;
    }

    private String stasss;

    @javax.persistence.Column(name = "STASSS")
    @Basic
    public String getStasss() {
        return stasss;
    }

    public void setStasss(String stasss) {
        this.stasss = stasss;
    }

    private String sothds;

    @javax.persistence.Column(name = "SOTHDS")
    @Basic
    public String getSothds() {
        return sothds;
    }

    public void setSothds(String sothds) {
        this.sothds = sothds;
    }

    private String snwrths;

    @javax.persistence.Column(name = "SNWRTHS")
    @Basic
    public String getSnwrths() {
        return snwrths;
    }

    public void setSnwrths(String snwrths) {
        this.snwrths = snwrths;
    }

    private String sapas;

    @javax.persistence.Column(name = "SAPAS")
    @Basic
    public String getSapas() {
        return sapas;
    }

    public void setSapas(String sapas) {
        this.sapas = sapas;
    }

    private String sdnets;

    @javax.persistence.Column(name = "SDNETS")
    @Basic
    public String getSdnets() {
        return sdnets;
    }

    public void setSdnets(String sdnets) {
        this.sdnets = sdnets;
    }

    private String scacps;

    @javax.persistence.Column(name = "SCACPS")
    @Basic
    public String getScacps() {
        return scacps;
    }

    public void setScacps(String scacps) {
        this.scacps = scacps;
    }

    private String sconas;

    @javax.persistence.Column(name = "SCONAS")
    @Basic
    public String getSconas() {
        return sconas;
    }

    public void setSconas(String sconas) {
        this.sconas = sconas;
    }

    private String saaavis;

    @javax.persistence.Column(name = "SAAAVIS")
    @Basic
    public String getSaaavis() {
        return saaavis;
    }

    public void setSaaavis(String saaavis) {
        this.saaavis = saaavis;
    }

    private String savbas;

    @javax.persistence.Column(name = "SAVBAS")
    @Basic
    public String getSavbas() {
        return savbas;
    }

    public void setSavbas(String savbas) {
        this.savbas = savbas;
    }

    private String sconfts;

    @javax.persistence.Column(name = "SCONFTS")
    @Basic
    public String getSconfts() {
        return sconfts;
    }

    public void setSconfts(String sconfts) {
        this.sconfts = sconfts;
    }

    private String sconfns;

    @javax.persistence.Column(name = "SCONFNS")
    @Basic
    public String getSconfns() {
        return sconfns;
    }

    public void setSconfns(String sconfns) {
        this.sconfns = sconfns;
    }

    private String sconfs;

    @javax.persistence.Column(name = "SCONFS")
    @Basic
    public String getSconfs() {
        return sconfs;
    }

    public void setSconfs(String sconfs) {
        this.sconfs = sconfs;
    }

    private String sdwags;

    @javax.persistence.Column(name = "SDWAGS")
    @Basic
    public String getSdwags() {
        return sdwags;
    }

    public void setSdwags(String sdwags) {
        this.sdwags = sdwags;
    }

    private String sdspsws;

    @javax.persistence.Column(name = "SDSPSWS")
    @Basic
    public String getSdspsws() {
        return sdspsws;
    }

    public void setSdspsws(String sdspsws) {
        this.sdspsws = sdspsws;
    }

    private String sdotis;

    @javax.persistence.Column(name = "SDOTIS")
    @Basic
    public String getSdotis() {
        return sdotis;
    }

    public void setSdotis(String sdotis) {
        this.sdotis = sdotis;
    }

    private String sdntis;

    @javax.persistence.Column(name = "SDNTIS")
    @Basic
    public String getSdntis() {
        return sdntis;
    }

    public void setSdntis(String sdntis) {
        this.sdntis = sdntis;
    }

    private String sdvabns;

    @javax.persistence.Column(name = "SDVABNS")
    @Basic
    public String getSdvabns() {
        return sdvabns;
    }

    public void setSdvabns(String sdvabns) {
        this.sdvabns = sdvabns;
    }

    private String sdtincs;

    @javax.persistence.Column(name = "SDTINCS")
    @Basic
    public String getSdtincs() {
        return sdtincs;
    }

    public void setSdtincs(String sdtincs) {
        this.sdtincs = sdtincs;
    }

    private String sbwags;

    @javax.persistence.Column(name = "SBWAGS")
    @Basic
    public String getSbwags() {
        return sbwags;
    }

    public void setSbwags(String sbwags) {
        this.sbwags = sbwags;
    }

    private String scwags;

    @javax.persistence.Column(name = "SCWAGS")
    @Basic
    public String getScwags() {
        return scwags;
    }

    public void setScwags(String scwags) {
        this.scwags = scwags;
    }

    private String sbspsws;

    @javax.persistence.Column(name = "SBSPSWS")
    @Basic
    public String getSbspsws() {
        return sbspsws;
    }

    public void setSbspsws(String sbspsws) {
        this.sbspsws = sbspsws;
    }

    private String scspsws;

    @javax.persistence.Column(name = "SCSPSWS")
    @Basic
    public String getScspsws() {
        return scspsws;
    }

    public void setScspsws(String scspsws) {
        this.scspsws = scspsws;
    }

    private String sbotis;

    @javax.persistence.Column(name = "SBOTIS")
    @Basic
    public String getSbotis() {
        return sbotis;
    }

    public void setSbotis(String sbotis) {
        this.sbotis = sbotis;
    }

    private String scotis;

    @javax.persistence.Column(name = "SCOTIS")
    @Basic
    public String getScotis() {
        return scotis;
    }

    public void setScotis(String scotis) {
        this.scotis = scotis;
    }

    private String sbntis;

    @javax.persistence.Column(name = "SBNTIS")
    @Basic
    public String getSbntis() {
        return sbntis;
    }

    public void setSbntis(String sbntis) {
        this.sbntis = sbntis;
    }

    private String scntis;

    @javax.persistence.Column(name = "SCNTIS")
    @Basic
    public String getScntis() {
        return scntis;
    }

    public void setScntis(String scntis) {
        this.scntis = scntis;
    }

    private String sctincs;

    @javax.persistence.Column(name = "SCTINCS")
    @Basic
    public String getSctincs() {
        return sctincs;
    }

    public void setSctincs(String sctincs) {
        this.sctincs = sctincs;
    }

    private String sddeds;

    @javax.persistence.Column(name = "SDDEDS")
    @Basic
    public String getSddeds() {
        return sddeds;
    }

    public void setSddeds(String sddeds) {
        this.sddeds = sddeds;
    }

    private String sditxs;

    @javax.persistence.Column(name = "SDITXS")
    @Basic
    public String getSditxs() {
        return sditxs;
    }

    public void setSditxs(String sditxs) {
        this.sditxs = sditxs;
    }

    private String sditxcs;

    @javax.persistence.Column(name = "SDITXCS")
    @Basic
    public String getSditxcs() {
        return sditxcs;
    }

    public void setSditxcs(String sditxcs) {
        this.sditxcs = sditxcs;
    }

    private String sditxus;

    @javax.persistence.Column(name = "SDITXUS")
    @Basic
    public String getSditxus() {
        return sditxus;
    }

    public void setSditxus(String sditxus) {
        this.sditxus = sditxus;
    }

    private String sdficas;

    @javax.persistence.Column(name = "SDFICAS")
    @Basic
    public String getSdficas() {
        return sdficas;
    }

    public void setSdficas(String sdficas) {
        this.sdficas = sdficas;
    }

    private String sdsttxs;

    @javax.persistence.Column(name = "SDSTTXS")
    @Basic
    public String getSdsttxs() {
        return sdsttxs;
    }

    public void setSdsttxs(String sdsttxs) {
        this.sdsttxs = sdsttxs;
    }

    private String sdmeds;

    @javax.persistence.Column(name = "SDMEDS")
    @Basic
    public String getSdmeds() {
        return sdmeds;
    }

    public void setSdmeds(String sdmeds) {
        this.sdmeds = sdmeds;
    }

    private String sdmedcs;

    @javax.persistence.Column(name = "SDMEDCS")
    @Basic
    public String getSdmedcs() {
        return sdmedcs;
    }

    public void setSdmedcs(String sdmedcs) {
        this.sdmedcs = sdmedcs;
    }

    private String sdtutas;

    @javax.persistence.Column(name = "SDTUTAS")
    @Basic
    public String getSdtutas() {
        return sdtutas;
    }

    public void setSdtutas(String sdtutas) {
        this.sdtutas = sdtutas;
    }

    private String sdemals;

    @javax.persistence.Column(name = "SDEMALS")
    @Basic
    public String getSdemals() {
        return sdemals;
    }

    public void setSdemals(String sdemals) {
        this.sdemals = sdemals;
    }

    private String sdsmas;

    @javax.persistence.Column(name = "SDSMAS")
    @Basic
    public String getSdsmas() {
        return sdsmas;
    }

    public void setSdsmas(String sdsmas) {
        this.sdsmas = sdsmas;
    }

    private String sdial1S;

    @javax.persistence.Column(name = "SDIAL1S")
    @Basic
    public String getSdial1S() {
        return sdial1S;
    }

    public void setSdial1S(String sdial1S) {
        this.sdial1S = sdial1S;
    }

    private String sdial2S;

    @javax.persistence.Column(name = "SDIAL2S")
    @Basic
    public String getSdial2S() {
        return sdial2S;
    }

    public void setSdial2S(String sdial2S) {
        this.sdial2S = sdial2S;
    }

    private String sdtalos;

    @javax.persistence.Column(name = "SDTALOS")
    @Basic
    public String getSdtalos() {
        return sdtalos;
    }

    public void setSdtalos(String sdtalos) {
        this.sdtalos = sdtalos;
    }

    private String sdefins;

    @javax.persistence.Column(name = "SDEFINS")
    @Basic
    public String getSdefins() {
        return sdefins;
    }

    public void setSdefins(String sdefins) {
        this.sdefins = sdefins;
    }

    private String sexclds;

    @javax.persistence.Column(name = "SEXCLDS")
    @Basic
    public String getSexclds() {
        return sexclds;
    }

    public void setSexclds(String sexclds) {
        this.sexclds = sexclds;
    }

    private String shvcons;

    @javax.persistence.Column(name = "SHVCONS")
    @Basic
    public String getShvcons() {
        return shvcons;
    }

    public void setShvcons(String shvcons) {
        this.shvcons = shvcons;
    }

    private String stotstfs;

    @javax.persistence.Column(name = "STOTSTFS")
    @Basic
    public String getStotstfs() {
        return stotstfs;
    }

    public void setStotstfs(String stotstfs) {
        this.stotstfs = stotstfs;
    }

    private String srctstfs;

    @javax.persistence.Column(name = "SRCTSTFS")
    @Basic
    public String getSrctstfs() {
        return srctstfs;
    }

    public void setSrctstfs(String srctstfs) {
        this.srctstfs = srctstfs;
    }

    private String snamels;

    @javax.persistence.Column(name = "SNAMELS")
    @Basic
    public String getSnamels() {
        return snamels;
    }

    public void setSnamels(String snamels) {
        this.snamels = snamels;
    }

    private String snamefs;

    @javax.persistence.Column(name = "SNAMEFS")
    @Basic
    public String getSnamefs() {
        return snamefs;
    }

    public void setSnamefs(String snamefs) {
        this.snamefs = snamefs;
    }

    private String snameis;

    @javax.persistence.Column(name = "SNAMEIS")
    @Basic
    public String getSnameis() {
        return snameis;
    }

    public void setSnameis(String snameis) {
        this.snameis = snameis;
    }

    private String smrtlds;

    @javax.persistence.Column(name = "SMRTLDS")
    @Basic
    public String getSmrtlds() {
        return smrtlds;
    }

    public void setSmrtlds(String smrtlds) {
        this.smrtlds = smrtlds;
    }

    private String shsdts;

    @javax.persistence.Column(name = "SHSDTS")
    @Basic
    public String getShsdts() {
        return shsdts;
    }

    public void setShsdts(String shsdts) {
        this.shsdts = shsdts;
    }

    private String sgeddts;

    @javax.persistence.Column(name = "SGEDDTS")
    @Basic
    public String getSgeddts() {
        return sgeddts;
    }

    public void setSgeddts(String sgeddts) {
        this.sgeddts = sgeddts;
    }

    private String sccares;

    @javax.persistence.Column(name = "SCCARES")
    @Basic
    public String getSccares() {
        return sccares;
    }

    public void setSccares(String sccares) {
        this.sccares = sccares;
    }

    private String sinccrs;

    @javax.persistence.Column(name = "SINCCRS")
    @Basic
    public String getSinccrs() {
        return sinccrs;
    }

    public void setSinccrs(String sinccrs) {
        this.sinccrs = sinccrs;
    }

    private String licsts;

    @javax.persistence.Column(name = "LICSTS")
    @Basic
    public String getLicsts() {
        return licsts;
    }

    public void setLicsts(String licsts) {
        this.licsts = licsts;
    }

    private String licnos;

    @javax.persistence.Column(name = "LICNOS")
    @Basic
    public String getLicnos() {
        return licnos;
    }

    public void setLicnos(String licnos) {
        this.licnos = licnos;
    }

    private String enrss;

    @javax.persistence.Column(name = "ENRSS")
    @Basic
    public String getEnrss() {
        return enrss;
    }

    public void setEnrss(String enrss) {
        this.enrss = enrss;
    }

    private String enrfs;

    @javax.persistence.Column(name = "ENRFS")
    @Basic
    public String getEnrfs() {
        return enrfs;
    }

    public void setEnrfs(String enrfs) {
        this.enrfs = enrfs;
    }

    private String enrws;

    @javax.persistence.Column(name = "ENRWS")
    @Basic
    public String getEnrws() {
        return enrws;
    }

    public void setEnrws(String enrws) {
        this.enrws = enrws;
    }

    private String enrps;

    @javax.persistence.Column(name = "ENRPS")
    @Basic
    public String getEnrps() {
        return enrps;
    }

    public void setEnrps(String enrps) {
        this.enrps = enrps;
    }

    private String enr2S;

    @javax.persistence.Column(name = "ENR2S")
    @Basic
    public String getEnr2S() {
        return enr2S;
    }

    public void setEnr2S(String enr2S) {
        this.enr2S = enr2S;
    }

    private String hsgeds;

    @javax.persistence.Column(name = "HSGEDS")
    @Basic
    public String getHsgeds() {
        return hsgeds;
    }

    public void setHsgeds(String hsgeds) {
        this.hsgeds = hsgeds;
    }

    private String hlcnses;

    @javax.persistence.Column(name = "HLCNSES")
    @Basic
    public String getHlcnses() {
        return hlcnses;
    }

    public void setHlcnses(String hlcnses) {
        this.hlcnses = hlcnses;
    }

    private String sresbfrs;

    @javax.persistence.Column(name = "SRESBFRS")
    @Basic
    public String getSresbfrs() {
        return sresbfrs;
    }

    public void setSresbfrs(String sresbfrs) {
        this.sresbfrs = sresbfrs;
    }

    private String smales;

    @javax.persistence.Column(name = "SMALES")
    @Basic
    public String getSmales() {
        return smales;
    }

    public void setSmales(String smales) {
        this.smales = smales;
    }

    private String sfilrtns;

    @javax.persistence.Column(name = "SFILRTNS")
    @Basic
    public String getSfilrtns() {
        return sfilrtns;
    }

    public void setSfilrtns(String sfilrtns) {
        this.sfilrtns = sfilrtns;
    }

    private String selgfils;

    @javax.persistence.Column(name = "SELGFILS")
    @Basic
    public String getSelgfils() {
        return selgfils;
    }

    public void setSelgfils(String selgfils) {
        this.selgfils = selgfils;
    }

    private String sasvasts;

    @javax.persistence.Column(name = "SASVASTS")
    @Basic
    public String getSasvasts() {
        return sasvasts;
    }

    public void setSasvasts(String sasvasts) {
        this.sasvasts = sasvasts;
    }

    private String primths;

    @javax.persistence.Column(name = "PRIMTHS")
    @Basic
    public String getPrimths() {
        return primths;
    }

    public void setPrimths(String primths) {
        this.primths = primths;
    }

    private String pawat1S;

    @javax.persistence.Column(name = "PAWAT1S")
    @Basic
    public String getPawat1S() {
        return pawat1S;
    }

    public void setPawat1S(String pawat1S) {
        this.pawat1S = pawat1S;
    }

    private String pawat2S;

    @javax.persistence.Column(name = "PAWAT2S")
    @Basic
    public String getPawat2S() {
        return pawat2S;
    }

    public void setPawat2S(String pawat2S) {
        this.pawat2S = pawat2S;
    }

    private String pawat3S;

    @javax.persistence.Column(name = "PAWAT3S")
    @Basic
    public String getPawat3S() {
        return pawat3S;
    }

    public void setPawat3S(String pawat3S) {
        this.pawat3S = pawat3S;
    }

    private String psreads;

    @javax.persistence.Column(name = "PSREADS")
    @Basic
    public String getPsreads() {
        return psreads;
    }

    public void setPsreads(String psreads) {
        this.psreads = psreads;
    }

    private String drugcns;

    @javax.persistence.Column(name = "DRUGCNS")
    @Basic
    public String getDrugcns() {
        return drugcns;
    }

    public void setDrugcns(String drugcns) {
        this.drugcns = drugcns;
    }

    private String smartcs;

    @javax.persistence.Column(name = "SMARTCS")
    @Basic
    public String getSmartcs() {
        return smartcs;
    }

    public void setSmartcs(String smartcs) {
        this.smartcs = smartcs;
    }

    private String sagecs;

    @javax.persistence.Column(name = "SAGECS")
    @Basic
    public String getSagecs() {
        return sagecs;
    }

    public void setSagecs(String sagecs) {
        this.sagecs = sagecs;
    }

    private String ssizhdcs;

    @javax.persistence.Column(name = "SSIZHDCS")
    @Basic
    public String getSsizhdcs() {
        return ssizhdcs;
    }

    public void setSsizhdcs(String ssizhdcs) {
        this.ssizhdcs = ssizhdcs;
    }

    private String sexempcs;

    @javax.persistence.Column(name = "SEXEMPCS")
    @Basic
    public String getSexempcs() {
        return sexempcs;
    }

    public void setSexempcs(String sexempcs) {
        this.sexempcs = sexempcs;
    }

    private String snrpscs;

    @javax.persistence.Column(name = "SNRPSCS")
    @Basic
    public String getSnrpscs() {
        return snrpscs;
    }

    public void setSnrpscs(String snrpscs) {
        this.snrpscs = snrpscs;
    }

    private String sdiswkcs;

    @javax.persistence.Column(name = "SDISWKCS")
    @Basic
    public String getSdiswkcs() {
        return sdiswkcs;
    }

    public void setSdiswkcs(String sdiswkcs) {
        this.sdiswkcs = sdiswkcs;
    }

    private String sdishmcs;

    @javax.persistence.Column(name = "SDISHMCS")
    @Basic
    public String getSdishmcs() {
        return sdishmcs;
    }

    public void setSdishmcs(String sdishmcs) {
        this.sdishmcs = sdishmcs;
    }

    private String strfilcs;

    @javax.persistence.Column(name = "STRFILCS")
    @Basic
    public String getStrfilcs() {
        return strfilcs;
    }

    public void setStrfilcs(String strfilcs) {
        this.strfilcs = strfilcs;
    }

    private String sslsrvcs;

    @javax.persistence.Column(name = "SSLSRVCS")
    @Basic
    public String getSslsrvcs() {
        return sslsrvcs;
    }

    public void setSslsrvcs(String sslsrvcs) {
        this.sslsrvcs = sslsrvcs;
    }

    private String sslsvmcs;

    @javax.persistence.Column(name = "SSLSVMCS")
    @Basic
    public String getSslsvmcs() {
        return sslsvmcs;
    }

    public void setSslsvmcs(String sslsvmcs) {
        this.sslsvmcs = sslsvmcs;
    }

    private String sinsfgcs;

    @javax.persistence.Column(name = "SINSFGCS")
    @Basic
    public String getSinsfgcs() {
        return sinsfgcs;
    }

    public void setSinsfgcs(String sinsfgcs) {
        this.sinsfgcs = sinsfgcs;
    }

    private String sadag1Cs;

    @javax.persistence.Column(name = "SADAG1CS")
    @Basic
    public String getSadag1Cs() {
        return sadag1Cs;
    }

    public void setSadag1Cs(String sadag1Cs) {
        this.sadag1Cs = sadag1Cs;
    }

    private String sadag2Cs;

    @javax.persistence.Column(name = "SADAG2CS")
    @Basic
    public String getSadag2Cs() {
        return sadag2Cs;
    }

    public void setSadag2Cs(String sadag2Cs) {
        this.sadag2Cs = sadag2Cs;
    }

    private String sadag3Cs;

    @javax.persistence.Column(name = "SADAG3CS")
    @Basic
    public String getSadag3Cs() {
        return sadag3Cs;
    }

    public void setSadag3Cs(String sadag3Cs) {
        this.sadag3Cs = sadag3Cs;
    }

    private String sfarmcs;

    @javax.persistence.Column(name = "SFARMCS")
    @Basic
    public String getSfarmcs() {
        return sfarmcs;
    }

    public void setSfarmcs(String sfarmcs) {
        this.sfarmcs = sfarmcs;
    }

    private String sagimcs;

    @javax.persistence.Column(name = "SAGIMCS")
    @Basic
    public String getSagimcs() {
        return sagimcs;
    }

    public void setSagimcs(String sagimcs) {
        this.sagimcs = sagimcs;
    }

    private String sagiacs;

    @javax.persistence.Column(name = "SAGIACS")
    @Basic
    public String getSagiacs() {
        return sagiacs;
    }

    public void setSagiacs(String sagiacs) {
        this.sagiacs = sagiacs;
    }

    private String sagics;

    @javax.persistence.Column(name = "SAGICS")
    @Basic
    public String getSagics() {
        return sagics;
    }

    public void setSagics(String sagics) {
        this.sagics = sagics;
    }

    private String savcmcs;

    @javax.persistence.Column(name = "SAVCMCS")
    @Basic
    public String getSavcmcs() {
        return savcmcs;
    }

    public void setSavcmcs(String savcmcs) {
        this.savcmcs = savcmcs;
    }

    private String savcacs;

    @javax.persistence.Column(name = "SAVCACS")
    @Basic
    public String getSavcacs() {
        return savcacs;
    }

    public void setSavcacs(String savcacs) {
        this.savcacs = savcacs;
    }

    private String savccs;

    @javax.persistence.Column(name = "SAVCCS")
    @Basic
    public String getSavccs() {
        return savccs;
    }

    public void setSavccs(String savccs) {
        this.savccs = savccs;
    }

    private String savomcs;

    @javax.persistence.Column(name = "SAVOMCS")
    @Basic
    public String getSavomcs() {
        return savomcs;
    }

    public void setSavomcs(String savomcs) {
        this.savomcs = savomcs;
    }

    private String savoacs;

    @javax.persistence.Column(name = "SAVOACS")
    @Basic
    public String getSavoacs() {
        return savoacs;
    }

    public void setSavoacs(String savoacs) {
        this.savoacs = savoacs;
    }

    private String savocs;

    @javax.persistence.Column(name = "SAVOCS")
    @Basic
    public String getSavocs() {
        return savocs;
    }

    public void setSavocs(String savocs) {
        this.savocs = savocs;
    }

    private String savabucs;

    @javax.persistence.Column(name = "SAVABUCS")
    @Basic
    public String getSavabucs() {
        return savabucs;
    }

    public void setSavabucs(String savabucs) {
        this.savabucs = savabucs;
    }

    private String savabncs;

    @javax.persistence.Column(name = "SAVABNCS")
    @Basic
    public String getSavabncs() {
        return savabncs;
    }

    public void setSavabncs(String savabncs) {
        this.savabncs = savabncs;
    }

    private String savabacs;

    @javax.persistence.Column(name = "SAVABACS")
    @Basic
    public String getSavabacs() {
        return savabacs;
    }

    public void setSavabacs(String savabacs) {
        this.savabacs = savabacs;
    }

    private String sawagcs;

    @javax.persistence.Column(name = "SAWAGCS")
    @Basic
    public String getSawagcs() {
        return sawagcs;
    }

    public void setSawagcs(String sawagcs) {
        this.sawagcs = sawagcs;
    }

    private String saspswcs;

    @javax.persistence.Column(name = "SASPSWCS")
    @Basic
    public String getSaspswcs() {
        return saspswcs;
    }

    public void setSaspswcs(String saspswcs) {
        this.saspswcs = saspswcs;
    }

    private String saadjcs;

    @javax.persistence.Column(name = "SAADJCS")
    @Basic
    public String getSaadjcs() {
        return saadjcs;
    }

    public void setSaadjcs(String saadjcs) {
        this.saadjcs = saadjcs;
    }

    private String saotics;

    @javax.persistence.Column(name = "SAOTICS")
    @Basic
    public String getSaotics() {
        return saotics;
    }

    public void setSaotics(String saotics) {
        this.saotics = saotics;
    }

    private String sattics;

    @javax.persistence.Column(name = "SATTICS")
    @Basic
    public String getSattics() {
        return sattics;
    }

    public void setSattics(String sattics) {
        this.sattics = sattics;
    }

    private String saagics;

    @javax.persistence.Column(name = "SAAGICS")
    @Basic
    public String getSaagics() {
        return saagics;
    }

    public void setSaagics(String saagics) {
        this.saagics = saagics;
    }

    private String sasscs;

    @javax.persistence.Column(name = "SASSCS")
    @Basic
    public String getSasscs() {
        return sasscs;
    }

    public void setSasscs(String sasscs) {
        this.sasscs = sasscs;
    }

    private String saadccs;

    @javax.persistence.Column(name = "SAADCCS")
    @Basic
    public String getSaadccs() {
        return saadccs;
    }

    public void setSaadccs(String saadccs) {
        this.saadccs = saadccs;
    }

    private String sacscs;

    @javax.persistence.Column(name = "SACSCS")
    @Basic
    public String getSacscs() {
        return sacscs;
    }

    public void setSacscs(String sacscs) {
        this.sacscs = sacscs;
    }

    private String saontics;

    @javax.persistence.Column(name = "SAONTICS")
    @Basic
    public String getSaontics() {
        return saontics;
    }

    public void setSaontics(String saontics) {
        this.saontics = saontics;
    }

    private String santx1Cs;

    @javax.persistence.Column(name = "SANTX1CS")
    @Basic
    public String getSantx1Cs() {
        return santx1Cs;
    }

    public void setSantx1Cs(String santx1Cs) {
        this.santx1Cs = santx1Cs;
    }

    private String santx2Cs;

    @javax.persistence.Column(name = "SANTX2CS")
    @Basic
    public String getSantx2Cs() {
        return santx2Cs;
    }

    public void setSantx2Cs(String santx2Cs) {
        this.santx2Cs = santx2Cs;
    }

    private String satntics;

    @javax.persistence.Column(name = "SATNTICS")
    @Basic
    public String getSatntics() {
        return satntics;
    }

    public void setSatntics(String satntics) {
        this.satntics = satntics;
    }

    private String satinccs;

    @javax.persistence.Column(name = "SATINCCS")
    @Basic
    public String getSatinccs() {
        return satinccs;
    }

    public void setSatinccs(String satinccs) {
        this.satinccs = satinccs;
    }

    private String sadedcs;

    @javax.persistence.Column(name = "SADEDCS")
    @Basic
    public String getSadedcs() {
        return sadedcs;
    }

    public void setSadedcs(String sadedcs) {
        this.sadedcs = sadedcs;
    }

    private String saitxxcs;

    @javax.persistence.Column(name = "SAITXXCS")
    @Basic
    public String getSaitxxcs() {
        return saitxxcs;
    }

    public void setSaitxxcs(String saitxxcs) {
        this.saitxxcs = saitxxcs;
    }

    private String saitxccs;

    @javax.persistence.Column(name = "SAITXCCS")
    @Basic
    public String getSaitxccs() {
        return saitxccs;
    }

    public void setSaitxccs(String saitxccs) {
        this.saitxccs = saitxccs;
    }

    private String saitxucs;

    @javax.persistence.Column(name = "SAITXUCS")
    @Basic
    public String getSaitxucs() {
        return saitxucs;
    }

    public void setSaitxucs(String saitxucs) {
        this.saitxucs = saitxucs;
    }

    private String saficacs;

    @javax.persistence.Column(name = "SAFICACS")
    @Basic
    public String getSaficacs() {
        return saficacs;
    }

    public void setSaficacs(String saficacs) {
        this.saficacs = saficacs;
    }

    private String sasttxcs;

    @javax.persistence.Column(name = "SASTTXCS")
    @Basic
    public String getSasttxcs() {
        return sasttxcs;
    }

    public void setSasttxcs(String sasttxcs) {
        this.sasttxcs = sasttxcs;
    }

    private String samedcs;

    @javax.persistence.Column(name = "SAMEDCS")
    @Basic
    public String getSamedcs() {
        return samedcs;
    }

    public void setSamedcs(String samedcs) {
        this.samedcs = samedcs;
    }

    private String samedacs;

    @javax.persistence.Column(name = "SAMEDACS")
    @Basic
    public String getSamedacs() {
        return samedacs;
    }

    public void setSamedacs(String samedacs) {
        this.samedacs = samedacs;
    }

    private String satuitcs;

    @javax.persistence.Column(name = "SATUITCS")
    @Basic
    public String getSatuitcs() {
        return satuitcs;
    }

    public void setSatuitcs(String satuitcs) {
        this.satuitcs = satuitcs;
    }

    private String satutncs;

    @javax.persistence.Column(name = "SATUTNCS")
    @Basic
    public String getSatutncs() {
        return satutncs;
    }

    public void setSatutncs(String satutncs) {
        this.satutncs = satutncs;
    }

    private String satutacs;

    @javax.persistence.Column(name = "SATUTACS")
    @Basic
    public String getSatutacs() {
        return satutacs;
    }

    public void setSatutacs(String satutacs) {
        this.satutacs = satutacs;
    }

    private String saemalcs;

    @javax.persistence.Column(name = "SAEMALCS")
    @Basic
    public String getSaemalcs() {
        return saemalcs;
    }

    public void setSaemalcs(String saemalcs) {
        this.saemalcs = saemalcs;
    }

    private String sasmacs;

    @javax.persistence.Column(name = "SASMACS")
    @Basic
    public String getSasmacs() {
        return sasmacs;
    }

    public void setSasmacs(String sasmacs) {
        this.sasmacs = sasmacs;
    }

    private String saial1Cs;

    @javax.persistence.Column(name = "SAIAL1CS")
    @Basic
    public String getSaial1Cs() {
        return saial1Cs;
    }

    public void setSaial1Cs(String saial1Cs) {
        this.saial1Cs = saial1Cs;
    }

    private String saial2Cs;

    @javax.persistence.Column(name = "SAIAL2CS")
    @Basic
    public String getSaial2Cs() {
        return saial2Cs;
    }

    public void setSaial2Cs(String saial2Cs) {
        this.saial2Cs = saial2Cs;
    }

    private String satalocs;

    @javax.persistence.Column(name = "SATALOCS")
    @Basic
    public String getSatalocs() {
        return satalocs;
    }

    public void setSatalocs(String satalocs) {
        this.satalocs = satalocs;
    }

    private String saefincs;

    @javax.persistence.Column(name = "SAEFINCS")
    @Basic
    public String getSaefincs() {
        return saefincs;
    }

    public void setSaefincs(String saefincs) {
        this.saefincs = saefincs;
    }

    private String scashcs;

    @javax.persistence.Column(name = "SCASHCS")
    @Basic
    public String getScashcs() {
        return scashcs;
    }

    public void setScashcs(String scashcs) {
        this.scashcs = scashcs;
    }

    private String shomvcs;

    @javax.persistence.Column(name = "SHOMVCS")
    @Basic
    public String getShomvcs() {
        return shomvcs;
    }

    public void setShomvcs(String shomvcs) {
        this.shomvcs = shomvcs;
    }

    private String shomdcs;

    @javax.persistence.Column(name = "SHOMDCS")
    @Basic
    public String getShomdcs() {
        return shomdcs;
    }

    public void setShomdcs(String shomdcs) {
        this.shomdcs = shomdcs;
    }

    private String shomecs;

    @javax.persistence.Column(name = "SHOMECS")
    @Basic
    public String getShomecs() {
        return shomecs;
    }

    public void setShomecs(String shomecs) {
        this.shomecs = shomecs;
    }

    private String sfarmvcs;

    @javax.persistence.Column(name = "SFARMVCS")
    @Basic
    public String getSfarmvcs() {
        return sfarmvcs;
    }

    public void setSfarmvcs(String sfarmvcs) {
        this.sfarmvcs = sfarmvcs;
    }

    private String sfarmdcs;

    @javax.persistence.Column(name = "SFARMDCS")
    @Basic
    public String getSfarmdcs() {
        return sfarmdcs;
    }

    public void setSfarmdcs(String sfarmdcs) {
        this.sfarmdcs = sfarmdcs;
    }

    private String sfarmecs;

    @javax.persistence.Column(name = "SFARMECS")
    @Basic
    public String getSfarmecs() {
        return sfarmecs;
    }

    public void setSfarmecs(String sfarmecs) {
        this.sfarmecs = sfarmecs;
    }

    private String sorivcs;

    @javax.persistence.Column(name = "SORIVCS")
    @Basic
    public String getSorivcs() {
        return sorivcs;
    }

    public void setSorivcs(String sorivcs) {
        this.sorivcs = sorivcs;
    }

    private String soridcs;

    @javax.persistence.Column(name = "SORIDCS")
    @Basic
    public String getSoridcs() {
        return soridcs;
    }

    public void setSoridcs(String soridcs) {
        this.soridcs = soridcs;
    }

    private String soriecs;

    @javax.persistence.Column(name = "SORIECS")
    @Basic
    public String getSoriecs() {
        return soriecs;
    }

    public void setSoriecs(String soriecs) {
        this.soriecs = soriecs;
    }

    private String sbfvcs;

    @javax.persistence.Column(name = "SBFVCS")
    @Basic
    public String getSbfvcs() {
        return sbfvcs;
    }

    public void setSbfvcs(String sbfvcs) {
        this.sbfvcs = sbfvcs;
    }

    private String sbfdcs;

    @javax.persistence.Column(name = "SBFDCS")
    @Basic
    public String getSbfdcs() {
        return sbfdcs;
    }

    public void setSbfdcs(String sbfdcs) {
        this.sbfdcs = sbfdcs;
    }

    private String sbfecs;

    @javax.persistence.Column(name = "SBFECS")
    @Basic
    public String getSbfecs() {
        return sbfecs;
    }

    public void setSbfecs(String sbfecs) {
        this.sbfecs = sbfecs;
    }

    private String sbfavcs;

    @javax.persistence.Column(name = "SBFAVCS")
    @Basic
    public String getSbfavcs() {
        return sbfavcs;
    }

    public void setSbfavcs(String sbfavcs) {
        this.sbfavcs = sbfavcs;
    }

    private String sassadcs;

    @javax.persistence.Column(name = "SASSADCS")
    @Basic
    public String getSassadcs() {
        return sassadcs;
    }

    public void setSassadcs(String sassadcs) {
        this.sassadcs = sassadcs;
    }

    private String stasscs;

    @javax.persistence.Column(name = "STASSCS")
    @Basic
    public String getStasscs() {
        return stasscs;
    }

    public void setStasscs(String stasscs) {
        this.stasscs = stasscs;
    }

    private String sothdcs;

    @javax.persistence.Column(name = "SOTHDCS")
    @Basic
    public String getSothdcs() {
        return sothdcs;
    }

    public void setSothdcs(String sothdcs) {
        this.sothdcs = sothdcs;
    }

    private String snwrthcs;

    @javax.persistence.Column(name = "SNWRTHCS")
    @Basic
    public String getSnwrthcs() {
        return snwrthcs;
    }

    public void setSnwrthcs(String snwrthcs) {
        this.snwrthcs = snwrthcs;
    }

    private String sapacs;

    @javax.persistence.Column(name = "SAPACS")
    @Basic
    public String getSapacs() {
        return sapacs;
    }

    public void setSapacs(String sapacs) {
        this.sapacs = sapacs;
    }

    private String sdnetcs;

    @javax.persistence.Column(name = "SDNETCS")
    @Basic
    public String getSdnetcs() {
        return sdnetcs;
    }

    public void setSdnetcs(String sdnetcs) {
        this.sdnetcs = sdnetcs;
    }

    private String scacpcs;

    @javax.persistence.Column(name = "SCACPCS")
    @Basic
    public String getScacpcs() {
        return scacpcs;
    }

    public void setScacpcs(String scacpcs) {
        this.scacpcs = scacpcs;
    }

    private String sconacs;

    @javax.persistence.Column(name = "SCONACS")
    @Basic
    public String getSconacs() {
        return sconacs;
    }

    public void setSconacs(String sconacs) {
        this.sconacs = sconacs;
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

        Sns4Entity that = (Sns4Entity) o;

        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (drugcns != null ? !drugcns.equals(that.drugcns) : that.drugcns != null) return false;
        if (enr2S != null ? !enr2S.equals(that.enr2S) : that.enr2S != null) return false;
        if (enrfs != null ? !enrfs.equals(that.enrfs) : that.enrfs != null) return false;
        if (enrps != null ? !enrps.equals(that.enrps) : that.enrps != null) return false;
        if (enrss != null ? !enrss.equals(that.enrss) : that.enrss != null) return false;
        if (enrws != null ? !enrws.equals(that.enrws) : that.enrws != null) return false;
        if (hlcnses != null ? !hlcnses.equals(that.hlcnses) : that.hlcnses != null) return false;
        if (hsgeds != null ? !hsgeds.equals(that.hsgeds) : that.hsgeds != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (licnos != null ? !licnos.equals(that.licnos) : that.licnos != null) return false;
        if (licsts != null ? !licsts.equals(that.licsts) : that.licsts != null) return false;
        if (pawat1S != null ? !pawat1S.equals(that.pawat1S) : that.pawat1S != null) return false;
        if (pawat2S != null ? !pawat2S.equals(that.pawat2S) : that.pawat2S != null) return false;
        if (pawat3S != null ? !pawat3S.equals(that.pawat3S) : that.pawat3S != null) return false;
        if (primths != null ? !primths.equals(that.primths) : that.primths != null) return false;
        if (psreads != null ? !psreads.equals(that.psreads) : that.psreads != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (saaavis != null ? !saaavis.equals(that.saaavis) : that.saaavis != null) return false;
        if (saadccs != null ? !saadccs.equals(that.saadccs) : that.saadccs != null) return false;
        if (saadcs != null ? !saadcs.equals(that.saadcs) : that.saadcs != null) return false;
        if (saadjcs != null ? !saadjcs.equals(that.saadjcs) : that.saadjcs != null) return false;
        if (saadjs != null ? !saadjs.equals(that.saadjs) : that.saadjs != null) return false;
        if (saagics != null ? !saagics.equals(that.saagics) : that.saagics != null) return false;
        if (saagis != null ? !saagis.equals(that.saagis) : that.saagis != null) return false;
        if (sacscs != null ? !sacscs.equals(that.sacscs) : that.sacscs != null) return false;
        if (sacss != null ? !sacss.equals(that.sacss) : that.sacss != null) return false;
        if (sadag1Cs != null ? !sadag1Cs.equals(that.sadag1Cs) : that.sadag1Cs != null) return false;
        if (sadag1S != null ? !sadag1S.equals(that.sadag1S) : that.sadag1S != null) return false;
        if (sadag2Cs != null ? !sadag2Cs.equals(that.sadag2Cs) : that.sadag2Cs != null) return false;
        if (sadag2S != null ? !sadag2S.equals(that.sadag2S) : that.sadag2S != null) return false;
        if (sadag3Cs != null ? !sadag3Cs.equals(that.sadag3Cs) : that.sadag3Cs != null) return false;
        if (sadag3S != null ? !sadag3S.equals(that.sadag3S) : that.sadag3S != null) return false;
        if (sadedcs != null ? !sadedcs.equals(that.sadedcs) : that.sadedcs != null) return false;
        if (sadeds != null ? !sadeds.equals(that.sadeds) : that.sadeds != null) return false;
        if (saefincs != null ? !saefincs.equals(that.saefincs) : that.saefincs != null) return false;
        if (saefins != null ? !saefins.equals(that.saefins) : that.saefins != null) return false;
        if (saemalcs != null ? !saemalcs.equals(that.saemalcs) : that.saemalcs != null) return false;
        if (saemals != null ? !saemals.equals(that.saemals) : that.saemals != null) return false;
        if (saficacs != null ? !saficacs.equals(that.saficacs) : that.saficacs != null) return false;
        if (saficas != null ? !saficas.equals(that.saficas) : that.saficas != null) return false;
        if (sagecs != null ? !sagecs.equals(that.sagecs) : that.sagecs != null) return false;
        if (sages != null ? !sages.equals(that.sages) : that.sages != null) return false;
        if (sagiacs != null ? !sagiacs.equals(that.sagiacs) : that.sagiacs != null) return false;
        if (sagias != null ? !sagias.equals(that.sagias) : that.sagias != null) return false;
        if (sagics != null ? !sagics.equals(that.sagics) : that.sagics != null) return false;
        if (sagimcs != null ? !sagimcs.equals(that.sagimcs) : that.sagimcs != null) return false;
        if (sagims != null ? !sagims.equals(that.sagims) : that.sagims != null) return false;
        if (sagis != null ? !sagis.equals(that.sagis) : that.sagis != null) return false;
        if (saial1Cs != null ? !saial1Cs.equals(that.saial1Cs) : that.saial1Cs != null) return false;
        if (saial1S != null ? !saial1S.equals(that.saial1S) : that.saial1S != null) return false;
        if (saial2Cs != null ? !saial2Cs.equals(that.saial2Cs) : that.saial2Cs != null) return false;
        if (saial2S != null ? !saial2S.equals(that.saial2S) : that.saial2S != null) return false;
        if (saitxccs != null ? !saitxccs.equals(that.saitxccs) : that.saitxccs != null) return false;
        if (saitxcs != null ? !saitxcs.equals(that.saitxcs) : that.saitxcs != null) return false;
        if (saitxs != null ? !saitxs.equals(that.saitxs) : that.saitxs != null) return false;
        if (saitxucs != null ? !saitxucs.equals(that.saitxucs) : that.saitxucs != null) return false;
        if (saitxus != null ? !saitxus.equals(that.saitxus) : that.saitxus != null) return false;
        if (saitxxcs != null ? !saitxxcs.equals(that.saitxxcs) : that.saitxxcs != null) return false;
        if (samedacs != null ? !samedacs.equals(that.samedacs) : that.samedacs != null) return false;
        if (samedas != null ? !samedas.equals(that.samedas) : that.samedas != null) return false;
        if (samedcs != null ? !samedcs.equals(that.samedcs) : that.samedcs != null) return false;
        if (sameds != null ? !sameds.equals(that.sameds) : that.sameds != null) return false;
        if (santx1Cs != null ? !santx1Cs.equals(that.santx1Cs) : that.santx1Cs != null) return false;
        if (santx1S != null ? !santx1S.equals(that.santx1S) : that.santx1S != null) return false;
        if (santx2Cs != null ? !santx2Cs.equals(that.santx2Cs) : that.santx2Cs != null) return false;
        if (santx2S != null ? !santx2S.equals(that.santx2S) : that.santx2S != null) return false;
        if (saontics != null ? !saontics.equals(that.saontics) : that.saontics != null) return false;
        if (saontis != null ? !saontis.equals(that.saontis) : that.saontis != null) return false;
        if (saotics != null ? !saotics.equals(that.saotics) : that.saotics != null) return false;
        if (saotis != null ? !saotis.equals(that.saotis) : that.saotis != null) return false;
        if (sapacs != null ? !sapacs.equals(that.sapacs) : that.sapacs != null) return false;
        if (sapas != null ? !sapas.equals(that.sapas) : that.sapas != null) return false;
        if (sasmacs != null ? !sasmacs.equals(that.sasmacs) : that.sasmacs != null) return false;
        if (sasmas != null ? !sasmas.equals(that.sasmas) : that.sasmas != null) return false;
        if (saspswcs != null ? !saspswcs.equals(that.saspswcs) : that.saspswcs != null) return false;
        if (saspsws != null ? !saspsws.equals(that.saspsws) : that.saspsws != null) return false;
        if (sassadcs != null ? !sassadcs.equals(that.sassadcs) : that.sassadcs != null) return false;
        if (sassads != null ? !sassads.equals(that.sassads) : that.sassads != null) return false;
        if (sasscs != null ? !sasscs.equals(that.sasscs) : that.sasscs != null) return false;
        if (sasss != null ? !sasss.equals(that.sasss) : that.sasss != null) return false;
        if (sasttxcs != null ? !sasttxcs.equals(that.sasttxcs) : that.sasttxcs != null) return false;
        if (sasttxs != null ? !sasttxs.equals(that.sasttxs) : that.sasttxs != null) return false;
        if (sasvasts != null ? !sasvasts.equals(that.sasvasts) : that.sasvasts != null) return false;
        if (satalocs != null ? !satalocs.equals(that.satalocs) : that.satalocs != null) return false;
        if (satalos != null ? !satalos.equals(that.satalos) : that.satalos != null) return false;
        if (satinccs != null ? !satinccs.equals(that.satinccs) : that.satinccs != null) return false;
        if (satincs != null ? !satincs.equals(that.satincs) : that.satincs != null) return false;
        if (satntics != null ? !satntics.equals(that.satntics) : that.satntics != null) return false;
        if (satntis != null ? !satntis.equals(that.satntis) : that.satntis != null) return false;
        if (sattics != null ? !sattics.equals(that.sattics) : that.sattics != null) return false;
        if (sattis != null ? !sattis.equals(that.sattis) : that.sattis != null) return false;
        if (satuitcs != null ? !satuitcs.equals(that.satuitcs) : that.satuitcs != null) return false;
        if (satuits != null ? !satuits.equals(that.satuits) : that.satuits != null) return false;
        if (satutacs != null ? !satutacs.equals(that.satutacs) : that.satutacs != null) return false;
        if (satutas != null ? !satutas.equals(that.satutas) : that.satutas != null) return false;
        if (satutncs != null ? !satutncs.equals(that.satutncs) : that.satutncs != null) return false;
        if (satutns != null ? !satutns.equals(that.satutns) : that.satutns != null) return false;
        if (savabacs != null ? !savabacs.equals(that.savabacs) : that.savabacs != null) return false;
        if (savabas != null ? !savabas.equals(that.savabas) : that.savabas != null) return false;
        if (savabncs != null ? !savabncs.equals(that.savabncs) : that.savabncs != null) return false;
        if (savabns != null ? !savabns.equals(that.savabns) : that.savabns != null) return false;
        if (savabucs != null ? !savabucs.equals(that.savabucs) : that.savabucs != null) return false;
        if (savabus != null ? !savabus.equals(that.savabus) : that.savabus != null) return false;
        if (savbas != null ? !savbas.equals(that.savbas) : that.savbas != null) return false;
        if (savcacs != null ? !savcacs.equals(that.savcacs) : that.savcacs != null) return false;
        if (savcas != null ? !savcas.equals(that.savcas) : that.savcas != null) return false;
        if (savccs != null ? !savccs.equals(that.savccs) : that.savccs != null) return false;
        if (savcmcs != null ? !savcmcs.equals(that.savcmcs) : that.savcmcs != null) return false;
        if (savcms != null ? !savcms.equals(that.savcms) : that.savcms != null) return false;
        if (savcs != null ? !savcs.equals(that.savcs) : that.savcs != null) return false;
        if (savoacs != null ? !savoacs.equals(that.savoacs) : that.savoacs != null) return false;
        if (savoas != null ? !savoas.equals(that.savoas) : that.savoas != null) return false;
        if (savocs != null ? !savocs.equals(that.savocs) : that.savocs != null) return false;
        if (savomcs != null ? !savomcs.equals(that.savomcs) : that.savomcs != null) return false;
        if (savoms != null ? !savoms.equals(that.savoms) : that.savoms != null) return false;
        if (savos != null ? !savos.equals(that.savos) : that.savos != null) return false;
        if (sawagcs != null ? !sawagcs.equals(that.sawagcs) : that.sawagcs != null) return false;
        if (sawags != null ? !sawags.equals(that.sawags) : that.sawags != null) return false;
        if (sbfavcs != null ? !sbfavcs.equals(that.sbfavcs) : that.sbfavcs != null) return false;
        if (sbfavs != null ? !sbfavs.equals(that.sbfavs) : that.sbfavs != null) return false;
        if (sbfdcs != null ? !sbfdcs.equals(that.sbfdcs) : that.sbfdcs != null) return false;
        if (sbfds != null ? !sbfds.equals(that.sbfds) : that.sbfds != null) return false;
        if (sbfecs != null ? !sbfecs.equals(that.sbfecs) : that.sbfecs != null) return false;
        if (sbfes != null ? !sbfes.equals(that.sbfes) : that.sbfes != null) return false;
        if (sbfvcs != null ? !sbfvcs.equals(that.sbfvcs) : that.sbfvcs != null) return false;
        if (sbfvs != null ? !sbfvs.equals(that.sbfvs) : that.sbfvs != null) return false;
        if (sbntis != null ? !sbntis.equals(that.sbntis) : that.sbntis != null) return false;
        if (sbotis != null ? !sbotis.equals(that.sbotis) : that.sbotis != null) return false;
        if (sbspsws != null ? !sbspsws.equals(that.sbspsws) : that.sbspsws != null) return false;
        if (sbwags != null ? !sbwags.equals(that.sbwags) : that.sbwags != null) return false;
        if (scacpcs != null ? !scacpcs.equals(that.scacpcs) : that.scacpcs != null) return false;
        if (scacps != null ? !scacps.equals(that.scacps) : that.scacps != null) return false;
        if (scashcs != null ? !scashcs.equals(that.scashcs) : that.scashcs != null) return false;
        if (scashs != null ? !scashs.equals(that.scashs) : that.scashs != null) return false;
        if (sccares != null ? !sccares.equals(that.sccares) : that.sccares != null) return false;
        if (scntis != null ? !scntis.equals(that.scntis) : that.scntis != null) return false;
        if (sconacs != null ? !sconacs.equals(that.sconacs) : that.sconacs != null) return false;
        if (sconas != null ? !sconas.equals(that.sconas) : that.sconas != null) return false;
        if (sconfns != null ? !sconfns.equals(that.sconfns) : that.sconfns != null) return false;
        if (sconfs != null ? !sconfs.equals(that.sconfs) : that.sconfs != null) return false;
        if (sconfts != null ? !sconfts.equals(that.sconfts) : that.sconfts != null) return false;
        if (scotis != null ? !scotis.equals(that.scotis) : that.scotis != null) return false;
        if (scspsws != null ? !scspsws.equals(that.scspsws) : that.scspsws != null) return false;
        if (sctincs != null ? !sctincs.equals(that.sctincs) : that.sctincs != null) return false;
        if (scwags != null ? !scwags.equals(that.scwags) : that.scwags != null) return false;
        if (sddeds != null ? !sddeds.equals(that.sddeds) : that.sddeds != null) return false;
        if (sdefins != null ? !sdefins.equals(that.sdefins) : that.sdefins != null) return false;
        if (sdemals != null ? !sdemals.equals(that.sdemals) : that.sdemals != null) return false;
        if (sdficas != null ? !sdficas.equals(that.sdficas) : that.sdficas != null) return false;
        if (sdial1S != null ? !sdial1S.equals(that.sdial1S) : that.sdial1S != null) return false;
        if (sdial2S != null ? !sdial2S.equals(that.sdial2S) : that.sdial2S != null) return false;
        if (sdishmcs != null ? !sdishmcs.equals(that.sdishmcs) : that.sdishmcs != null) return false;
        if (sdishms != null ? !sdishms.equals(that.sdishms) : that.sdishms != null) return false;
        if (sdiswkcs != null ? !sdiswkcs.equals(that.sdiswkcs) : that.sdiswkcs != null) return false;
        if (sdiswks != null ? !sdiswks.equals(that.sdiswks) : that.sdiswks != null) return false;
        if (sditxcs != null ? !sditxcs.equals(that.sditxcs) : that.sditxcs != null) return false;
        if (sditxs != null ? !sditxs.equals(that.sditxs) : that.sditxs != null) return false;
        if (sditxus != null ? !sditxus.equals(that.sditxus) : that.sditxus != null) return false;
        if (sdmedcs != null ? !sdmedcs.equals(that.sdmedcs) : that.sdmedcs != null) return false;
        if (sdmeds != null ? !sdmeds.equals(that.sdmeds) : that.sdmeds != null) return false;
        if (sdnetcs != null ? !sdnetcs.equals(that.sdnetcs) : that.sdnetcs != null) return false;
        if (sdnets != null ? !sdnets.equals(that.sdnets) : that.sdnets != null) return false;
        if (sdntis != null ? !sdntis.equals(that.sdntis) : that.sdntis != null) return false;
        if (sdotis != null ? !sdotis.equals(that.sdotis) : that.sdotis != null) return false;
        if (sdsmas != null ? !sdsmas.equals(that.sdsmas) : that.sdsmas != null) return false;
        if (sdspsws != null ? !sdspsws.equals(that.sdspsws) : that.sdspsws != null) return false;
        if (sdsttxs != null ? !sdsttxs.equals(that.sdsttxs) : that.sdsttxs != null) return false;
        if (sdtalos != null ? !sdtalos.equals(that.sdtalos) : that.sdtalos != null) return false;
        if (sdtincs != null ? !sdtincs.equals(that.sdtincs) : that.sdtincs != null) return false;
        if (sdtutas != null ? !sdtutas.equals(that.sdtutas) : that.sdtutas != null) return false;
        if (sdvabns != null ? !sdvabns.equals(that.sdvabns) : that.sdvabns != null) return false;
        if (sdwags != null ? !sdwags.equals(that.sdwags) : that.sdwags != null) return false;
        if (selgfils != null ? !selgfils.equals(that.selgfils) : that.selgfils != null) return false;
        if (sexclds != null ? !sexclds.equals(that.sexclds) : that.sexclds != null) return false;
        if (sexempcs != null ? !sexempcs.equals(that.sexempcs) : that.sexempcs != null) return false;
        if (sexemps != null ? !sexemps.equals(that.sexemps) : that.sexemps != null) return false;
        if (sfarmcs != null ? !sfarmcs.equals(that.sfarmcs) : that.sfarmcs != null) return false;
        if (sfarmdcs != null ? !sfarmdcs.equals(that.sfarmdcs) : that.sfarmdcs != null) return false;
        if (sfarmds != null ? !sfarmds.equals(that.sfarmds) : that.sfarmds != null) return false;
        if (sfarmecs != null ? !sfarmecs.equals(that.sfarmecs) : that.sfarmecs != null) return false;
        if (sfarmes != null ? !sfarmes.equals(that.sfarmes) : that.sfarmes != null) return false;
        if (sfarms != null ? !sfarms.equals(that.sfarms) : that.sfarms != null) return false;
        if (sfarmvcs != null ? !sfarmvcs.equals(that.sfarmvcs) : that.sfarmvcs != null) return false;
        if (sfarmvs != null ? !sfarmvs.equals(that.sfarmvs) : that.sfarmvs != null) return false;
        if (sfilrtns != null ? !sfilrtns.equals(that.sfilrtns) : that.sfilrtns != null) return false;
        if (sgeddts != null ? !sgeddts.equals(that.sgeddts) : that.sgeddts != null) return false;
        if (shomdcs != null ? !shomdcs.equals(that.shomdcs) : that.shomdcs != null) return false;
        if (shomds != null ? !shomds.equals(that.shomds) : that.shomds != null) return false;
        if (shomecs != null ? !shomecs.equals(that.shomecs) : that.shomecs != null) return false;
        if (shomes != null ? !shomes.equals(that.shomes) : that.shomes != null) return false;
        if (shomvcs != null ? !shomvcs.equals(that.shomvcs) : that.shomvcs != null) return false;
        if (shomvs != null ? !shomvs.equals(that.shomvs) : that.shomvs != null) return false;
        if (shsdts != null ? !shsdts.equals(that.shsdts) : that.shsdts != null) return false;
        if (shvcons != null ? !shvcons.equals(that.shvcons) : that.shvcons != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (sinccrs != null ? !sinccrs.equals(that.sinccrs) : that.sinccrs != null) return false;
        if (sinsfgcs != null ? !sinsfgcs.equals(that.sinsfgcs) : that.sinsfgcs != null) return false;
        if (sinsflgs != null ? !sinsflgs.equals(that.sinsflgs) : that.sinsflgs != null) return false;
        if (smales != null ? !smales.equals(that.smales) : that.smales != null) return false;
        if (smartcs != null ? !smartcs.equals(that.smartcs) : that.smartcs != null) return false;
        if (smartls != null ? !smartls.equals(that.smartls) : that.smartls != null) return false;
        if (smrtlds != null ? !smrtlds.equals(that.smrtlds) : that.smrtlds != null) return false;
        if (snamefs != null ? !snamefs.equals(that.snamefs) : that.snamefs != null) return false;
        if (snameis != null ? !snameis.equals(that.snameis) : that.snameis != null) return false;
        if (snamels != null ? !snamels.equals(that.snamels) : that.snamels != null) return false;
        if (snrpscs != null ? !snrpscs.equals(that.snrpscs) : that.snrpscs != null) return false;
        if (snrpss != null ? !snrpss.equals(that.snrpss) : that.snrpss != null) return false;
        if (snskey != null ? !snskey.equals(that.snskey) : that.snskey != null) return false;
        if (snwrthcs != null ? !snwrthcs.equals(that.snwrthcs) : that.snwrthcs != null) return false;
        if (snwrths != null ? !snwrths.equals(that.snwrths) : that.snwrths != null) return false;
        if (soridcs != null ? !soridcs.equals(that.soridcs) : that.soridcs != null) return false;
        if (sorids != null ? !sorids.equals(that.sorids) : that.sorids != null) return false;
        if (soriecs != null ? !soriecs.equals(that.soriecs) : that.soriecs != null) return false;
        if (sories != null ? !sories.equals(that.sories) : that.sories != null) return false;
        if (sorivcs != null ? !sorivcs.equals(that.sorivcs) : that.sorivcs != null) return false;
        if (sorivs != null ? !sorivs.equals(that.sorivs) : that.sorivs != null) return false;
        if (sothdcs != null ? !sothdcs.equals(that.sothdcs) : that.sothdcs != null) return false;
        if (sothds != null ? !sothds.equals(that.sothds) : that.sothds != null) return false;
        if (srctstfs != null ? !srctstfs.equals(that.srctstfs) : that.srctstfs != null) return false;
        if (sresbfrs != null ? !sresbfrs.equals(that.sresbfrs) : that.sresbfrs != null) return false;
        if (sselsrvs != null ? !sselsrvs.equals(that.sselsrvs) : that.sselsrvs != null) return false;
        if (ssizhdcs != null ? !ssizhdcs.equals(that.ssizhdcs) : that.ssizhdcs != null) return false;
        if (sslsrvcs != null ? !sslsrvcs.equals(that.sslsrvcs) : that.sslsrvcs != null) return false;
        if (sslsrvms != null ? !sslsrvms.equals(that.sslsrvms) : that.sslsrvms != null) return false;
        if (sslsvmcs != null ? !sslsvmcs.equals(that.sslsvmcs) : that.sslsvmcs != null) return false;
        if (sszhhds != null ? !sszhhds.equals(that.sszhhds) : that.sszhhds != null) return false;
        if (stasscs != null ? !stasscs.equals(that.stasscs) : that.stasscs != null) return false;
        if (stasss != null ? !stasss.equals(that.stasss) : that.stasss != null) return false;
        if (stotstfs != null ? !stotstfs.equals(that.stotstfs) : that.stotstfs != null) return false;
        if (strfilcs != null ? !strfilcs.equals(that.strfilcs) : that.strfilcs != null) return false;
        if (strfils != null ? !strfils.equals(that.strfils) : that.strfils != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snskey != null ? snskey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cmptype != null ? cmptype.hashCode() : 0);
        result = 31 * result + (versnr != null ? versnr.hashCode() : 0);
        result = 31 * result + (smartls != null ? smartls.hashCode() : 0);
        result = 31 * result + (sages != null ? sages.hashCode() : 0);
        result = 31 * result + (sszhhds != null ? sszhhds.hashCode() : 0);
        result = 31 * result + (sexemps != null ? sexemps.hashCode() : 0);
        result = 31 * result + (snrpss != null ? snrpss.hashCode() : 0);
        result = 31 * result + (sdiswks != null ? sdiswks.hashCode() : 0);
        result = 31 * result + (sdishms != null ? sdishms.hashCode() : 0);
        result = 31 * result + (strfils != null ? strfils.hashCode() : 0);
        result = 31 * result + (sselsrvs != null ? sselsrvs.hashCode() : 0);
        result = 31 * result + (sslsrvms != null ? sslsrvms.hashCode() : 0);
        result = 31 * result + (sinsflgs != null ? sinsflgs.hashCode() : 0);
        result = 31 * result + (sadag1S != null ? sadag1S.hashCode() : 0);
        result = 31 * result + (sadag2S != null ? sadag2S.hashCode() : 0);
        result = 31 * result + (sadag3S != null ? sadag3S.hashCode() : 0);
        result = 31 * result + (sfarms != null ? sfarms.hashCode() : 0);
        result = 31 * result + (sagims != null ? sagims.hashCode() : 0);
        result = 31 * result + (sagias != null ? sagias.hashCode() : 0);
        result = 31 * result + (sagis != null ? sagis.hashCode() : 0);
        result = 31 * result + (savcms != null ? savcms.hashCode() : 0);
        result = 31 * result + (savcas != null ? savcas.hashCode() : 0);
        result = 31 * result + (savcs != null ? savcs.hashCode() : 0);
        result = 31 * result + (savoms != null ? savoms.hashCode() : 0);
        result = 31 * result + (savoas != null ? savoas.hashCode() : 0);
        result = 31 * result + (savos != null ? savos.hashCode() : 0);
        result = 31 * result + (savabus != null ? savabus.hashCode() : 0);
        result = 31 * result + (savabns != null ? savabns.hashCode() : 0);
        result = 31 * result + (savabas != null ? savabas.hashCode() : 0);
        result = 31 * result + (sawags != null ? sawags.hashCode() : 0);
        result = 31 * result + (saspsws != null ? saspsws.hashCode() : 0);
        result = 31 * result + (saadjs != null ? saadjs.hashCode() : 0);
        result = 31 * result + (saotis != null ? saotis.hashCode() : 0);
        result = 31 * result + (sattis != null ? sattis.hashCode() : 0);
        result = 31 * result + (saagis != null ? saagis.hashCode() : 0);
        result = 31 * result + (sasss != null ? sasss.hashCode() : 0);
        result = 31 * result + (saadcs != null ? saadcs.hashCode() : 0);
        result = 31 * result + (sacss != null ? sacss.hashCode() : 0);
        result = 31 * result + (saontis != null ? saontis.hashCode() : 0);
        result = 31 * result + (santx1S != null ? santx1S.hashCode() : 0);
        result = 31 * result + (santx2S != null ? santx2S.hashCode() : 0);
        result = 31 * result + (satntis != null ? satntis.hashCode() : 0);
        result = 31 * result + (satincs != null ? satincs.hashCode() : 0);
        result = 31 * result + (sadeds != null ? sadeds.hashCode() : 0);
        result = 31 * result + (saitxs != null ? saitxs.hashCode() : 0);
        result = 31 * result + (saitxcs != null ? saitxcs.hashCode() : 0);
        result = 31 * result + (saitxus != null ? saitxus.hashCode() : 0);
        result = 31 * result + (saficas != null ? saficas.hashCode() : 0);
        result = 31 * result + (sasttxs != null ? sasttxs.hashCode() : 0);
        result = 31 * result + (sameds != null ? sameds.hashCode() : 0);
        result = 31 * result + (samedas != null ? samedas.hashCode() : 0);
        result = 31 * result + (satuits != null ? satuits.hashCode() : 0);
        result = 31 * result + (satutns != null ? satutns.hashCode() : 0);
        result = 31 * result + (satutas != null ? satutas.hashCode() : 0);
        result = 31 * result + (saemals != null ? saemals.hashCode() : 0);
        result = 31 * result + (sasmas != null ? sasmas.hashCode() : 0);
        result = 31 * result + (saial1S != null ? saial1S.hashCode() : 0);
        result = 31 * result + (saial2S != null ? saial2S.hashCode() : 0);
        result = 31 * result + (satalos != null ? satalos.hashCode() : 0);
        result = 31 * result + (saefins != null ? saefins.hashCode() : 0);
        result = 31 * result + (scashs != null ? scashs.hashCode() : 0);
        result = 31 * result + (shomvs != null ? shomvs.hashCode() : 0);
        result = 31 * result + (shomds != null ? shomds.hashCode() : 0);
        result = 31 * result + (shomes != null ? shomes.hashCode() : 0);
        result = 31 * result + (sfarmvs != null ? sfarmvs.hashCode() : 0);
        result = 31 * result + (sfarmds != null ? sfarmds.hashCode() : 0);
        result = 31 * result + (sfarmes != null ? sfarmes.hashCode() : 0);
        result = 31 * result + (sorivs != null ? sorivs.hashCode() : 0);
        result = 31 * result + (sorids != null ? sorids.hashCode() : 0);
        result = 31 * result + (sories != null ? sories.hashCode() : 0);
        result = 31 * result + (sbfvs != null ? sbfvs.hashCode() : 0);
        result = 31 * result + (sbfds != null ? sbfds.hashCode() : 0);
        result = 31 * result + (sbfes != null ? sbfes.hashCode() : 0);
        result = 31 * result + (sbfavs != null ? sbfavs.hashCode() : 0);
        result = 31 * result + (sassads != null ? sassads.hashCode() : 0);
        result = 31 * result + (stasss != null ? stasss.hashCode() : 0);
        result = 31 * result + (sothds != null ? sothds.hashCode() : 0);
        result = 31 * result + (snwrths != null ? snwrths.hashCode() : 0);
        result = 31 * result + (sapas != null ? sapas.hashCode() : 0);
        result = 31 * result + (sdnets != null ? sdnets.hashCode() : 0);
        result = 31 * result + (scacps != null ? scacps.hashCode() : 0);
        result = 31 * result + (sconas != null ? sconas.hashCode() : 0);
        result = 31 * result + (saaavis != null ? saaavis.hashCode() : 0);
        result = 31 * result + (savbas != null ? savbas.hashCode() : 0);
        result = 31 * result + (sconfts != null ? sconfts.hashCode() : 0);
        result = 31 * result + (sconfns != null ? sconfns.hashCode() : 0);
        result = 31 * result + (sconfs != null ? sconfs.hashCode() : 0);
        result = 31 * result + (sdwags != null ? sdwags.hashCode() : 0);
        result = 31 * result + (sdspsws != null ? sdspsws.hashCode() : 0);
        result = 31 * result + (sdotis != null ? sdotis.hashCode() : 0);
        result = 31 * result + (sdntis != null ? sdntis.hashCode() : 0);
        result = 31 * result + (sdvabns != null ? sdvabns.hashCode() : 0);
        result = 31 * result + (sdtincs != null ? sdtincs.hashCode() : 0);
        result = 31 * result + (sbwags != null ? sbwags.hashCode() : 0);
        result = 31 * result + (scwags != null ? scwags.hashCode() : 0);
        result = 31 * result + (sbspsws != null ? sbspsws.hashCode() : 0);
        result = 31 * result + (scspsws != null ? scspsws.hashCode() : 0);
        result = 31 * result + (sbotis != null ? sbotis.hashCode() : 0);
        result = 31 * result + (scotis != null ? scotis.hashCode() : 0);
        result = 31 * result + (sbntis != null ? sbntis.hashCode() : 0);
        result = 31 * result + (scntis != null ? scntis.hashCode() : 0);
        result = 31 * result + (sctincs != null ? sctincs.hashCode() : 0);
        result = 31 * result + (sddeds != null ? sddeds.hashCode() : 0);
        result = 31 * result + (sditxs != null ? sditxs.hashCode() : 0);
        result = 31 * result + (sditxcs != null ? sditxcs.hashCode() : 0);
        result = 31 * result + (sditxus != null ? sditxus.hashCode() : 0);
        result = 31 * result + (sdficas != null ? sdficas.hashCode() : 0);
        result = 31 * result + (sdsttxs != null ? sdsttxs.hashCode() : 0);
        result = 31 * result + (sdmeds != null ? sdmeds.hashCode() : 0);
        result = 31 * result + (sdmedcs != null ? sdmedcs.hashCode() : 0);
        result = 31 * result + (sdtutas != null ? sdtutas.hashCode() : 0);
        result = 31 * result + (sdemals != null ? sdemals.hashCode() : 0);
        result = 31 * result + (sdsmas != null ? sdsmas.hashCode() : 0);
        result = 31 * result + (sdial1S != null ? sdial1S.hashCode() : 0);
        result = 31 * result + (sdial2S != null ? sdial2S.hashCode() : 0);
        result = 31 * result + (sdtalos != null ? sdtalos.hashCode() : 0);
        result = 31 * result + (sdefins != null ? sdefins.hashCode() : 0);
        result = 31 * result + (sexclds != null ? sexclds.hashCode() : 0);
        result = 31 * result + (shvcons != null ? shvcons.hashCode() : 0);
        result = 31 * result + (stotstfs != null ? stotstfs.hashCode() : 0);
        result = 31 * result + (srctstfs != null ? srctstfs.hashCode() : 0);
        result = 31 * result + (snamels != null ? snamels.hashCode() : 0);
        result = 31 * result + (snamefs != null ? snamefs.hashCode() : 0);
        result = 31 * result + (snameis != null ? snameis.hashCode() : 0);
        result = 31 * result + (smrtlds != null ? smrtlds.hashCode() : 0);
        result = 31 * result + (shsdts != null ? shsdts.hashCode() : 0);
        result = 31 * result + (sgeddts != null ? sgeddts.hashCode() : 0);
        result = 31 * result + (sccares != null ? sccares.hashCode() : 0);
        result = 31 * result + (sinccrs != null ? sinccrs.hashCode() : 0);
        result = 31 * result + (licsts != null ? licsts.hashCode() : 0);
        result = 31 * result + (licnos != null ? licnos.hashCode() : 0);
        result = 31 * result + (enrss != null ? enrss.hashCode() : 0);
        result = 31 * result + (enrfs != null ? enrfs.hashCode() : 0);
        result = 31 * result + (enrws != null ? enrws.hashCode() : 0);
        result = 31 * result + (enrps != null ? enrps.hashCode() : 0);
        result = 31 * result + (enr2S != null ? enr2S.hashCode() : 0);
        result = 31 * result + (hsgeds != null ? hsgeds.hashCode() : 0);
        result = 31 * result + (hlcnses != null ? hlcnses.hashCode() : 0);
        result = 31 * result + (sresbfrs != null ? sresbfrs.hashCode() : 0);
        result = 31 * result + (smales != null ? smales.hashCode() : 0);
        result = 31 * result + (sfilrtns != null ? sfilrtns.hashCode() : 0);
        result = 31 * result + (selgfils != null ? selgfils.hashCode() : 0);
        result = 31 * result + (sasvasts != null ? sasvasts.hashCode() : 0);
        result = 31 * result + (primths != null ? primths.hashCode() : 0);
        result = 31 * result + (pawat1S != null ? pawat1S.hashCode() : 0);
        result = 31 * result + (pawat2S != null ? pawat2S.hashCode() : 0);
        result = 31 * result + (pawat3S != null ? pawat3S.hashCode() : 0);
        result = 31 * result + (psreads != null ? psreads.hashCode() : 0);
        result = 31 * result + (drugcns != null ? drugcns.hashCode() : 0);
        result = 31 * result + (smartcs != null ? smartcs.hashCode() : 0);
        result = 31 * result + (sagecs != null ? sagecs.hashCode() : 0);
        result = 31 * result + (ssizhdcs != null ? ssizhdcs.hashCode() : 0);
        result = 31 * result + (sexempcs != null ? sexempcs.hashCode() : 0);
        result = 31 * result + (snrpscs != null ? snrpscs.hashCode() : 0);
        result = 31 * result + (sdiswkcs != null ? sdiswkcs.hashCode() : 0);
        result = 31 * result + (sdishmcs != null ? sdishmcs.hashCode() : 0);
        result = 31 * result + (strfilcs != null ? strfilcs.hashCode() : 0);
        result = 31 * result + (sslsrvcs != null ? sslsrvcs.hashCode() : 0);
        result = 31 * result + (sslsvmcs != null ? sslsvmcs.hashCode() : 0);
        result = 31 * result + (sinsfgcs != null ? sinsfgcs.hashCode() : 0);
        result = 31 * result + (sadag1Cs != null ? sadag1Cs.hashCode() : 0);
        result = 31 * result + (sadag2Cs != null ? sadag2Cs.hashCode() : 0);
        result = 31 * result + (sadag3Cs != null ? sadag3Cs.hashCode() : 0);
        result = 31 * result + (sfarmcs != null ? sfarmcs.hashCode() : 0);
        result = 31 * result + (sagimcs != null ? sagimcs.hashCode() : 0);
        result = 31 * result + (sagiacs != null ? sagiacs.hashCode() : 0);
        result = 31 * result + (sagics != null ? sagics.hashCode() : 0);
        result = 31 * result + (savcmcs != null ? savcmcs.hashCode() : 0);
        result = 31 * result + (savcacs != null ? savcacs.hashCode() : 0);
        result = 31 * result + (savccs != null ? savccs.hashCode() : 0);
        result = 31 * result + (savomcs != null ? savomcs.hashCode() : 0);
        result = 31 * result + (savoacs != null ? savoacs.hashCode() : 0);
        result = 31 * result + (savocs != null ? savocs.hashCode() : 0);
        result = 31 * result + (savabucs != null ? savabucs.hashCode() : 0);
        result = 31 * result + (savabncs != null ? savabncs.hashCode() : 0);
        result = 31 * result + (savabacs != null ? savabacs.hashCode() : 0);
        result = 31 * result + (sawagcs != null ? sawagcs.hashCode() : 0);
        result = 31 * result + (saspswcs != null ? saspswcs.hashCode() : 0);
        result = 31 * result + (saadjcs != null ? saadjcs.hashCode() : 0);
        result = 31 * result + (saotics != null ? saotics.hashCode() : 0);
        result = 31 * result + (sattics != null ? sattics.hashCode() : 0);
        result = 31 * result + (saagics != null ? saagics.hashCode() : 0);
        result = 31 * result + (sasscs != null ? sasscs.hashCode() : 0);
        result = 31 * result + (saadccs != null ? saadccs.hashCode() : 0);
        result = 31 * result + (sacscs != null ? sacscs.hashCode() : 0);
        result = 31 * result + (saontics != null ? saontics.hashCode() : 0);
        result = 31 * result + (santx1Cs != null ? santx1Cs.hashCode() : 0);
        result = 31 * result + (santx2Cs != null ? santx2Cs.hashCode() : 0);
        result = 31 * result + (satntics != null ? satntics.hashCode() : 0);
        result = 31 * result + (satinccs != null ? satinccs.hashCode() : 0);
        result = 31 * result + (sadedcs != null ? sadedcs.hashCode() : 0);
        result = 31 * result + (saitxxcs != null ? saitxxcs.hashCode() : 0);
        result = 31 * result + (saitxccs != null ? saitxccs.hashCode() : 0);
        result = 31 * result + (saitxucs != null ? saitxucs.hashCode() : 0);
        result = 31 * result + (saficacs != null ? saficacs.hashCode() : 0);
        result = 31 * result + (sasttxcs != null ? sasttxcs.hashCode() : 0);
        result = 31 * result + (samedcs != null ? samedcs.hashCode() : 0);
        result = 31 * result + (samedacs != null ? samedacs.hashCode() : 0);
        result = 31 * result + (satuitcs != null ? satuitcs.hashCode() : 0);
        result = 31 * result + (satutncs != null ? satutncs.hashCode() : 0);
        result = 31 * result + (satutacs != null ? satutacs.hashCode() : 0);
        result = 31 * result + (saemalcs != null ? saemalcs.hashCode() : 0);
        result = 31 * result + (sasmacs != null ? sasmacs.hashCode() : 0);
        result = 31 * result + (saial1Cs != null ? saial1Cs.hashCode() : 0);
        result = 31 * result + (saial2Cs != null ? saial2Cs.hashCode() : 0);
        result = 31 * result + (satalocs != null ? satalocs.hashCode() : 0);
        result = 31 * result + (saefincs != null ? saefincs.hashCode() : 0);
        result = 31 * result + (scashcs != null ? scashcs.hashCode() : 0);
        result = 31 * result + (shomvcs != null ? shomvcs.hashCode() : 0);
        result = 31 * result + (shomdcs != null ? shomdcs.hashCode() : 0);
        result = 31 * result + (shomecs != null ? shomecs.hashCode() : 0);
        result = 31 * result + (sfarmvcs != null ? sfarmvcs.hashCode() : 0);
        result = 31 * result + (sfarmdcs != null ? sfarmdcs.hashCode() : 0);
        result = 31 * result + (sfarmecs != null ? sfarmecs.hashCode() : 0);
        result = 31 * result + (sorivcs != null ? sorivcs.hashCode() : 0);
        result = 31 * result + (soridcs != null ? soridcs.hashCode() : 0);
        result = 31 * result + (soriecs != null ? soriecs.hashCode() : 0);
        result = 31 * result + (sbfvcs != null ? sbfvcs.hashCode() : 0);
        result = 31 * result + (sbfdcs != null ? sbfdcs.hashCode() : 0);
        result = 31 * result + (sbfecs != null ? sbfecs.hashCode() : 0);
        result = 31 * result + (sbfavcs != null ? sbfavcs.hashCode() : 0);
        result = 31 * result + (sassadcs != null ? sassadcs.hashCode() : 0);
        result = 31 * result + (stasscs != null ? stasscs.hashCode() : 0);
        result = 31 * result + (sothdcs != null ? sothdcs.hashCode() : 0);
        result = 31 * result + (snwrthcs != null ? snwrthcs.hashCode() : 0);
        result = 31 * result + (sapacs != null ? sapacs.hashCode() : 0);
        result = 31 * result + (sdnetcs != null ? sdnetcs.hashCode() : 0);
        result = 31 * result + (scacpcs != null ? scacpcs.hashCode() : 0);
        result = 31 * result + (sconacs != null ? sconacs.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
