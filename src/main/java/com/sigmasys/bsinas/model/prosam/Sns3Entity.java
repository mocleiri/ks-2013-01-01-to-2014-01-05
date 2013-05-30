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
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNS3", schema = "SIGMA", catalog = "")
@Entity
public class Sns3Entity implements Identifiable {

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

    private String smartc;

    @javax.persistence.Column(name = "SMARTC")
    @Basic
    public String getSmartc() {
        return smartc;
    }

    public void setSmartc(String smartc) {
        this.smartc = smartc;
    }

    private BigInteger sagec;

    @javax.persistence.Column(name = "SAGEC")
    @Basic
    public BigInteger getSagec() {
        return sagec;
    }

    public void setSagec(BigInteger sagec) {
        this.sagec = sagec;
    }

    private BigInteger ssizhdc;

    @javax.persistence.Column(name = "SSIZHDC")
    @Basic
    public BigInteger getSsizhdc() {
        return ssizhdc;
    }

    public void setSsizhdc(BigInteger ssizhdc) {
        this.ssizhdc = ssizhdc;
    }

    private BigInteger sexempc;

    @javax.persistence.Column(name = "SEXEMPC")
    @Basic
    public BigInteger getSexempc() {
        return sexempc;
    }

    public void setSexempc(BigInteger sexempc) {
        this.sexempc = sexempc;
    }

    private BigInteger snrpsc;

    @javax.persistence.Column(name = "SNRPSC")
    @Basic
    public BigInteger getSnrpsc() {
        return snrpsc;
    }

    public void setSnrpsc(BigInteger snrpsc) {
        this.snrpsc = snrpsc;
    }

    private String sdiswkc;

    @javax.persistence.Column(name = "SDISWKC")
    @Basic
    public String getSdiswkc() {
        return sdiswkc;
    }

    public void setSdiswkc(String sdiswkc) {
        this.sdiswkc = sdiswkc;
    }

    private String sdishmc;

    @javax.persistence.Column(name = "SDISHMC")
    @Basic
    public String getSdishmc() {
        return sdishmc;
    }

    public void setSdishmc(String sdishmc) {
        this.sdishmc = sdishmc;
    }

    private String strfilc;

    @javax.persistence.Column(name = "STRFILC")
    @Basic
    public String getStrfilc() {
        return strfilc;
    }

    public void setStrfilc(String strfilc) {
        this.strfilc = strfilc;
    }

    private String sselsrvc;

    @javax.persistence.Column(name = "SSELSRVC")
    @Basic
    public String getSselsrvc() {
        return sselsrvc;
    }

    public void setSselsrvc(String sselsrvc) {
        this.sselsrvc = sselsrvc;
    }

    private String sslsrvmc;

    @javax.persistence.Column(name = "SSLSRVMC")
    @Basic
    public String getSslsrvmc() {
        return sslsrvmc;
    }

    public void setSslsrvmc(String sslsrvmc) {
        this.sslsrvmc = sslsrvmc;
    }

    private String sinsflgc;

    @javax.persistence.Column(name = "SINSFLGC")
    @Basic
    public String getSinsflgc() {
        return sinsflgc;
    }

    public void setSinsflgc(String sinsflgc) {
        this.sinsflgc = sinsflgc;
    }

    private BigInteger sadagec1;

    @javax.persistence.Column(name = "SADAGEC1")
    @Basic
    public BigInteger getSadagec1() {
        return sadagec1;
    }

    public void setSadagec1(BigInteger sadagec1) {
        this.sadagec1 = sadagec1;
    }

    private BigInteger sadagec2;

    @javax.persistence.Column(name = "SADAGEC2")
    @Basic
    public BigInteger getSadagec2() {
        return sadagec2;
    }

    public void setSadagec2(BigInteger sadagec2) {
        this.sadagec2 = sadagec2;
    }

    private BigInteger sadagec3;

    @javax.persistence.Column(name = "SADAGEC3")
    @Basic
    public BigInteger getSadagec3() {
        return sadagec3;
    }

    public void setSadagec3(BigInteger sadagec3) {
        this.sadagec3 = sadagec3;
    }

    private String sfarmc;

    @javax.persistence.Column(name = "SFARMC")
    @Basic
    public String getSfarmc() {
        return sfarmc;
    }

    public void setSfarmc(String sfarmc) {
        this.sfarmc = sfarmc;
    }

    private int sagimc;

    @javax.persistence.Column(name = "SAGIMC")
    @Basic
    public int getSagimc() {
        return sagimc;
    }

    public void setSagimc(int sagimc) {
        this.sagimc = sagimc;
    }

    private int sagiac;

    @javax.persistence.Column(name = "SAGIAC")
    @Basic
    public int getSagiac() {
        return sagiac;
    }

    public void setSagiac(int sagiac) {
        this.sagiac = sagiac;
    }

    private int sagic;

    @javax.persistence.Column(name = "SAGIC")
    @Basic
    public int getSagic() {
        return sagic;
    }

    public void setSagic(int sagic) {
        this.sagic = sagic;
    }

    private int savcmc;

    @javax.persistence.Column(name = "SAVCMC")
    @Basic
    public int getSavcmc() {
        return savcmc;
    }

    public void setSavcmc(int savcmc) {
        this.savcmc = savcmc;
    }

    private int savcac;

    @javax.persistence.Column(name = "SAVCAC")
    @Basic
    public int getSavcac() {
        return savcac;
    }

    public void setSavcac(int savcac) {
        this.savcac = savcac;
    }

    private int savcc;

    @javax.persistence.Column(name = "SAVCC")
    @Basic
    public int getSavcc() {
        return savcc;
    }

    public void setSavcc(int savcc) {
        this.savcc = savcc;
    }

    private int savomc;

    @javax.persistence.Column(name = "SAVOMC")
    @Basic
    public int getSavomc() {
        return savomc;
    }

    public void setSavomc(int savomc) {
        this.savomc = savomc;
    }

    private int savoac;

    @javax.persistence.Column(name = "SAVOAC")
    @Basic
    public int getSavoac() {
        return savoac;
    }

    public void setSavoac(int savoac) {
        this.savoac = savoac;
    }

    private int savoc;

    @javax.persistence.Column(name = "SAVOC")
    @Basic
    public int getSavoc() {
        return savoc;
    }

    public void setSavoc(int savoc) {
        this.savoc = savoc;
    }

    private int savabuc;

    @javax.persistence.Column(name = "SAVABUC")
    @Basic
    public int getSavabuc() {
        return savabuc;
    }

    public void setSavabuc(int savabuc) {
        this.savabuc = savabuc;
    }

    private int savabnc;

    @javax.persistence.Column(name = "SAVABNC")
    @Basic
    public int getSavabnc() {
        return savabnc;
    }

    public void setSavabnc(int savabnc) {
        this.savabnc = savabnc;
    }

    private int savabac;

    @javax.persistence.Column(name = "SAVABAC")
    @Basic
    public int getSavabac() {
        return savabac;
    }

    public void setSavabac(int savabac) {
        this.savabac = savabac;
    }

    private int sawagc;

    @javax.persistence.Column(name = "SAWAGC")
    @Basic
    public int getSawagc() {
        return sawagc;
    }

    public void setSawagc(int sawagc) {
        this.sawagc = sawagc;
    }

    private int saspswc;

    @javax.persistence.Column(name = "SASPSWC")
    @Basic
    public int getSaspswc() {
        return saspswc;
    }

    public void setSaspswc(int saspswc) {
        this.saspswc = saspswc;
    }

    private int saadjc;

    @javax.persistence.Column(name = "SAADJC")
    @Basic
    public int getSaadjc() {
        return saadjc;
    }

    public void setSaadjc(int saadjc) {
        this.saadjc = saadjc;
    }

    private int saotic;

    @javax.persistence.Column(name = "SAOTIC")
    @Basic
    public int getSaotic() {
        return saotic;
    }

    public void setSaotic(int saotic) {
        this.saotic = saotic;
    }

    private int sattic;

    @javax.persistence.Column(name = "SATTIC")
    @Basic
    public int getSattic() {
        return sattic;
    }

    public void setSattic(int sattic) {
        this.sattic = sattic;
    }

    private int saagic;

    @javax.persistence.Column(name = "SAAGIC")
    @Basic
    public int getSaagic() {
        return saagic;
    }

    public void setSaagic(int saagic) {
        this.saagic = saagic;
    }

    private int sassc;

    @javax.persistence.Column(name = "SASSC")
    @Basic
    public int getSassc() {
        return sassc;
    }

    public void setSassc(int sassc) {
        this.sassc = sassc;
    }

    private int saadcc;

    @javax.persistence.Column(name = "SAADCC")
    @Basic
    public int getSaadcc() {
        return saadcc;
    }

    public void setSaadcc(int saadcc) {
        this.saadcc = saadcc;
    }

    private int sacsc;

    @javax.persistence.Column(name = "SACSC")
    @Basic
    public int getSacsc() {
        return sacsc;
    }

    public void setSacsc(int sacsc) {
        this.sacsc = sacsc;
    }

    private int saontic;

    @javax.persistence.Column(name = "SAONTIC")
    @Basic
    public int getSaontic() {
        return saontic;
    }

    public void setSaontic(int saontic) {
        this.saontic = saontic;
    }

    private int santx1C;

    @javax.persistence.Column(name = "SANTX1C")
    @Basic
    public int getSantx1C() {
        return santx1C;
    }

    public void setSantx1C(int santx1C) {
        this.santx1C = santx1C;
    }

    private int santx2C;

    @javax.persistence.Column(name = "SANTX2C")
    @Basic
    public int getSantx2C() {
        return santx2C;
    }

    public void setSantx2C(int santx2C) {
        this.santx2C = santx2C;
    }

    private int satntic;

    @javax.persistence.Column(name = "SATNTIC")
    @Basic
    public int getSatntic() {
        return satntic;
    }

    public void setSatntic(int satntic) {
        this.satntic = satntic;
    }

    private int satincc;

    @javax.persistence.Column(name = "SATINCC")
    @Basic
    public int getSatincc() {
        return satincc;
    }

    public void setSatincc(int satincc) {
        this.satincc = satincc;
    }

    private int sadedc;

    @javax.persistence.Column(name = "SADEDC")
    @Basic
    public int getSadedc() {
        return sadedc;
    }

    public void setSadedc(int sadedc) {
        this.sadedc = sadedc;
    }

    private int saitxxc;

    @javax.persistence.Column(name = "SAITXXC")
    @Basic
    public int getSaitxxc() {
        return saitxxc;
    }

    public void setSaitxxc(int saitxxc) {
        this.saitxxc = saitxxc;
    }

    private int saitxcc;

    @javax.persistence.Column(name = "SAITXCC")
    @Basic
    public int getSaitxcc() {
        return saitxcc;
    }

    public void setSaitxcc(int saitxcc) {
        this.saitxcc = saitxcc;
    }

    private int saitxuc;

    @javax.persistence.Column(name = "SAITXUC")
    @Basic
    public int getSaitxuc() {
        return saitxuc;
    }

    public void setSaitxuc(int saitxuc) {
        this.saitxuc = saitxuc;
    }

    private int saficac;

    @javax.persistence.Column(name = "SAFICAC")
    @Basic
    public int getSaficac() {
        return saficac;
    }

    public void setSaficac(int saficac) {
        this.saficac = saficac;
    }

    private int sasttxc;

    @javax.persistence.Column(name = "SASTTXC")
    @Basic
    public int getSasttxc() {
        return sasttxc;
    }

    public void setSasttxc(int sasttxc) {
        this.sasttxc = sasttxc;
    }

    private int samedc;

    @javax.persistence.Column(name = "SAMEDC")
    @Basic
    public int getSamedc() {
        return samedc;
    }

    public void setSamedc(int samedc) {
        this.samedc = samedc;
    }

    private int samedac;

    @javax.persistence.Column(name = "SAMEDAC")
    @Basic
    public int getSamedac() {
        return samedac;
    }

    public void setSamedac(int samedac) {
        this.samedac = samedac;
    }

    private int satuitc;

    @javax.persistence.Column(name = "SATUITC")
    @Basic
    public int getSatuitc() {
        return satuitc;
    }

    public void setSatuitc(int satuitc) {
        this.satuitc = satuitc;
    }

    private BigInteger satutnc;

    @javax.persistence.Column(name = "SATUTNC")
    @Basic
    public BigInteger getSatutnc() {
        return satutnc;
    }

    public void setSatutnc(BigInteger satutnc) {
        this.satutnc = satutnc;
    }

    private int satutac;

    @javax.persistence.Column(name = "SATUTAC")
    @Basic
    public int getSatutac() {
        return satutac;
    }

    public void setSatutac(int satutac) {
        this.satutac = satutac;
    }

    private int saemalc;

    @javax.persistence.Column(name = "SAEMALC")
    @Basic
    public int getSaemalc() {
        return saemalc;
    }

    public void setSaemalc(int saemalc) {
        this.saemalc = saemalc;
    }

    private int sasmac;

    @javax.persistence.Column(name = "SASMAC")
    @Basic
    public int getSasmac() {
        return sasmac;
    }

    public void setSasmac(int sasmac) {
        this.sasmac = sasmac;
    }

    private int saial1C;

    @javax.persistence.Column(name = "SAIAL1C")
    @Basic
    public int getSaial1C() {
        return saial1C;
    }

    public void setSaial1C(int saial1C) {
        this.saial1C = saial1C;
    }

    private int saial2C;

    @javax.persistence.Column(name = "SAIAL2C")
    @Basic
    public int getSaial2C() {
        return saial2C;
    }

    public void setSaial2C(int saial2C) {
        this.saial2C = saial2C;
    }

    private int sataloc;

    @javax.persistence.Column(name = "SATALOC")
    @Basic
    public int getSataloc() {
        return sataloc;
    }

    public void setSataloc(int sataloc) {
        this.sataloc = sataloc;
    }

    private int saefincc;

    @javax.persistence.Column(name = "SAEFINCC")
    @Basic
    public int getSaefincc() {
        return saefincc;
    }

    public void setSaefincc(int saefincc) {
        this.saefincc = saefincc;
    }

    private int scashc;

    @javax.persistence.Column(name = "SCASHC")
    @Basic
    public int getScashc() {
        return scashc;
    }

    public void setScashc(int scashc) {
        this.scashc = scashc;
    }

    private int shomvc;

    @javax.persistence.Column(name = "SHOMVC")
    @Basic
    public int getShomvc() {
        return shomvc;
    }

    public void setShomvc(int shomvc) {
        this.shomvc = shomvc;
    }

    private int shomdc;

    @javax.persistence.Column(name = "SHOMDC")
    @Basic
    public int getShomdc() {
        return shomdc;
    }

    public void setShomdc(int shomdc) {
        this.shomdc = shomdc;
    }

    private int shomec;

    @javax.persistence.Column(name = "SHOMEC")
    @Basic
    public int getShomec() {
        return shomec;
    }

    public void setShomec(int shomec) {
        this.shomec = shomec;
    }

    private int sfarmvc;

    @javax.persistence.Column(name = "SFARMVC")
    @Basic
    public int getSfarmvc() {
        return sfarmvc;
    }

    public void setSfarmvc(int sfarmvc) {
        this.sfarmvc = sfarmvc;
    }

    private int sfarmdc;

    @javax.persistence.Column(name = "SFARMDC")
    @Basic
    public int getSfarmdc() {
        return sfarmdc;
    }

    public void setSfarmdc(int sfarmdc) {
        this.sfarmdc = sfarmdc;
    }

    private int sfarmec;

    @javax.persistence.Column(name = "SFARMEC")
    @Basic
    public int getSfarmec() {
        return sfarmec;
    }

    public void setSfarmec(int sfarmec) {
        this.sfarmec = sfarmec;
    }

    private int sorivc;

    @javax.persistence.Column(name = "SORIVC")
    @Basic
    public int getSorivc() {
        return sorivc;
    }

    public void setSorivc(int sorivc) {
        this.sorivc = sorivc;
    }

    private int soridc;

    @javax.persistence.Column(name = "SORIDC")
    @Basic
    public int getSoridc() {
        return soridc;
    }

    public void setSoridc(int soridc) {
        this.soridc = soridc;
    }

    private int soriec;

    @javax.persistence.Column(name = "SORIEC")
    @Basic
    public int getSoriec() {
        return soriec;
    }

    public void setSoriec(int soriec) {
        this.soriec = soriec;
    }

    private int sbfvc;

    @javax.persistence.Column(name = "SBFVC")
    @Basic
    public int getSbfvc() {
        return sbfvc;
    }

    public void setSbfvc(int sbfvc) {
        this.sbfvc = sbfvc;
    }

    private int sbfdc;

    @javax.persistence.Column(name = "SBFDC")
    @Basic
    public int getSbfdc() {
        return sbfdc;
    }

    public void setSbfdc(int sbfdc) {
        this.sbfdc = sbfdc;
    }

    private int sbfec;

    @javax.persistence.Column(name = "SBFEC")
    @Basic
    public int getSbfec() {
        return sbfec;
    }

    public void setSbfec(int sbfec) {
        this.sbfec = sbfec;
    }

    private int sbfavc;

    @javax.persistence.Column(name = "SBFAVC")
    @Basic
    public int getSbfavc() {
        return sbfavc;
    }

    public void setSbfavc(int sbfavc) {
        this.sbfavc = sbfavc;
    }

    private int sassadc;

    @javax.persistence.Column(name = "SASSADC")
    @Basic
    public int getSassadc() {
        return sassadc;
    }

    public void setSassadc(int sassadc) {
        this.sassadc = sassadc;
    }

    private int stassc;

    @javax.persistence.Column(name = "STASSC")
    @Basic
    public int getStassc() {
        return stassc;
    }

    public void setStassc(int stassc) {
        this.stassc = stassc;
    }

    private int sothdc;

    @javax.persistence.Column(name = "SOTHDC")
    @Basic
    public int getSothdc() {
        return sothdc;
    }

    public void setSothdc(int sothdc) {
        this.sothdc = sothdc;
    }

    private int snwrthc;

    @javax.persistence.Column(name = "SNWRTHC")
    @Basic
    public int getSnwrthc() {
        return snwrthc;
    }

    public void setSnwrthc(int snwrthc) {
        this.snwrthc = snwrthc;
    }

    private int sapac;

    @javax.persistence.Column(name = "SAPAC")
    @Basic
    public int getSapac() {
        return sapac;
    }

    public void setSapac(int sapac) {
        this.sapac = sapac;
    }

    private int sdnetc;

    @javax.persistence.Column(name = "SDNETC")
    @Basic
    public int getSdnetc() {
        return sdnetc;
    }

    public void setSdnetc(int sdnetc) {
        this.sdnetc = sdnetc;
    }

    private BigDecimal scacpc;

    @javax.persistence.Column(name = "SCACPC")
    @Basic
    public BigDecimal getScacpc() {
        return scacpc;
    }

    public void setScacpc(BigDecimal scacpc) {
        this.scacpc = scacpc;
    }

    private int sconac;

    @javax.persistence.Column(name = "SCONAC")
    @Basic
    public int getSconac() {
        return sconac;
    }

    public void setSconac(int sconac) {
        this.sconac = sconac;
    }

    private int saaavic;

    @javax.persistence.Column(name = "SAAAVIC")
    @Basic
    public int getSaaavic() {
        return saaavic;
    }

    public void setSaaavic(int saaavic) {
        this.saaavic = saaavic;
    }

    private int savbac;

    @javax.persistence.Column(name = "SAVBAC")
    @Basic
    public int getSavbac() {
        return savbac;
    }

    public void setSavbac(int savbac) {
        this.savbac = savbac;
    }

    private int sconftc;

    @javax.persistence.Column(name = "SCONFTC")
    @Basic
    public int getSconftc() {
        return sconftc;
    }

    public void setSconftc(int sconftc) {
        this.sconftc = sconftc;
    }

    private int sconfnc;

    @javax.persistence.Column(name = "SCONFNC")
    @Basic
    public int getSconfnc() {
        return sconfnc;
    }

    public void setSconfnc(int sconfnc) {
        this.sconfnc = sconfnc;
    }

    private int sconfc;

    @javax.persistence.Column(name = "SCONFC")
    @Basic
    public int getSconfc() {
        return sconfc;
    }

    public void setSconfc(int sconfc) {
        this.sconfc = sconfc;
    }

    private int sdwagc;

    @javax.persistence.Column(name = "SDWAGC")
    @Basic
    public int getSdwagc() {
        return sdwagc;
    }

    public void setSdwagc(int sdwagc) {
        this.sdwagc = sdwagc;
    }

    private int sdspswc;

    @javax.persistence.Column(name = "SDSPSWC")
    @Basic
    public int getSdspswc() {
        return sdspswc;
    }

    public void setSdspswc(int sdspswc) {
        this.sdspswc = sdspswc;
    }

    private int sdotic;

    @javax.persistence.Column(name = "SDOTIC")
    @Basic
    public int getSdotic() {
        return sdotic;
    }

    public void setSdotic(int sdotic) {
        this.sdotic = sdotic;
    }

    private int sdntic;

    @javax.persistence.Column(name = "SDNTIC")
    @Basic
    public int getSdntic() {
        return sdntic;
    }

    public void setSdntic(int sdntic) {
        this.sdntic = sdntic;
    }

    private int sdvabnc;

    @javax.persistence.Column(name = "SDVABNC")
    @Basic
    public int getSdvabnc() {
        return sdvabnc;
    }

    public void setSdvabnc(int sdvabnc) {
        this.sdvabnc = sdvabnc;
    }

    private int sdtincc;

    @javax.persistence.Column(name = "SDTINCC")
    @Basic
    public int getSdtincc() {
        return sdtincc;
    }

    public void setSdtincc(int sdtincc) {
        this.sdtincc = sdtincc;
    }

    private int sbwagc;

    @javax.persistence.Column(name = "SBWAGC")
    @Basic
    public int getSbwagc() {
        return sbwagc;
    }

    public void setSbwagc(int sbwagc) {
        this.sbwagc = sbwagc;
    }

    private int scwagc;

    @javax.persistence.Column(name = "SCWAGC")
    @Basic
    public int getScwagc() {
        return scwagc;
    }

    public void setScwagc(int scwagc) {
        this.scwagc = scwagc;
    }

    private int sbspswc;

    @javax.persistence.Column(name = "SBSPSWC")
    @Basic
    public int getSbspswc() {
        return sbspswc;
    }

    public void setSbspswc(int sbspswc) {
        this.sbspswc = sbspswc;
    }

    private int scspswc;

    @javax.persistence.Column(name = "SCSPSWC")
    @Basic
    public int getScspswc() {
        return scspswc;
    }

    public void setScspswc(int scspswc) {
        this.scspswc = scspswc;
    }

    private int sbotic;

    @javax.persistence.Column(name = "SBOTIC")
    @Basic
    public int getSbotic() {
        return sbotic;
    }

    public void setSbotic(int sbotic) {
        this.sbotic = sbotic;
    }

    private int scotic;

    @javax.persistence.Column(name = "SCOTIC")
    @Basic
    public int getScotic() {
        return scotic;
    }

    public void setScotic(int scotic) {
        this.scotic = scotic;
    }

    private int sbntic;

    @javax.persistence.Column(name = "SBNTIC")
    @Basic
    public int getSbntic() {
        return sbntic;
    }

    public void setSbntic(int sbntic) {
        this.sbntic = sbntic;
    }

    private int scntic;

    @javax.persistence.Column(name = "SCNTIC")
    @Basic
    public int getScntic() {
        return scntic;
    }

    public void setScntic(int scntic) {
        this.scntic = scntic;
    }

    private int sctincc;

    @javax.persistence.Column(name = "SCTINCC")
    @Basic
    public int getSctincc() {
        return sctincc;
    }

    public void setSctincc(int sctincc) {
        this.sctincc = sctincc;
    }

    private int sddedc;

    @javax.persistence.Column(name = "SDDEDC")
    @Basic
    public int getSddedc() {
        return sddedc;
    }

    public void setSddedc(int sddedc) {
        this.sddedc = sddedc;
    }

    private int sditxxc;

    @javax.persistence.Column(name = "SDITXXC")
    @Basic
    public int getSditxxc() {
        return sditxxc;
    }

    public void setSditxxc(int sditxxc) {
        this.sditxxc = sditxxc;
    }

    private int sditxcc;

    @javax.persistence.Column(name = "SDITXCC")
    @Basic
    public int getSditxcc() {
        return sditxcc;
    }

    public void setSditxcc(int sditxcc) {
        this.sditxcc = sditxcc;
    }

    private int sditxuc;

    @javax.persistence.Column(name = "SDITXUC")
    @Basic
    public int getSditxuc() {
        return sditxuc;
    }

    public void setSditxuc(int sditxuc) {
        this.sditxuc = sditxuc;
    }

    private int sdficac;

    @javax.persistence.Column(name = "SDFICAC")
    @Basic
    public int getSdficac() {
        return sdficac;
    }

    public void setSdficac(int sdficac) {
        this.sdficac = sdficac;
    }

    private int sdsttxc;

    @javax.persistence.Column(name = "SDSTTXC")
    @Basic
    public int getSdsttxc() {
        return sdsttxc;
    }

    public void setSdsttxc(int sdsttxc) {
        this.sdsttxc = sdsttxc;
    }

    private int sdmedxc;

    @javax.persistence.Column(name = "SDMEDXC")
    @Basic
    public int getSdmedxc() {
        return sdmedxc;
    }

    public void setSdmedxc(int sdmedxc) {
        this.sdmedxc = sdmedxc;
    }

    private int sdmedcc;

    @javax.persistence.Column(name = "SDMEDCC")
    @Basic
    public int getSdmedcc() {
        return sdmedcc;
    }

    public void setSdmedcc(int sdmedcc) {
        this.sdmedcc = sdmedcc;
    }

    private int sdtutac;

    @javax.persistence.Column(name = "SDTUTAC")
    @Basic
    public int getSdtutac() {
        return sdtutac;
    }

    public void setSdtutac(int sdtutac) {
        this.sdtutac = sdtutac;
    }

    private int sdemalc;

    @javax.persistence.Column(name = "SDEMALC")
    @Basic
    public int getSdemalc() {
        return sdemalc;
    }

    public void setSdemalc(int sdemalc) {
        this.sdemalc = sdemalc;
    }

    private int sdsmac;

    @javax.persistence.Column(name = "SDSMAC")
    @Basic
    public int getSdsmac() {
        return sdsmac;
    }

    public void setSdsmac(int sdsmac) {
        this.sdsmac = sdsmac;
    }

    private int sdial1C;

    @javax.persistence.Column(name = "SDIAL1C")
    @Basic
    public int getSdial1C() {
        return sdial1C;
    }

    public void setSdial1C(int sdial1C) {
        this.sdial1C = sdial1C;
    }

    private int sdial2C;

    @javax.persistence.Column(name = "SDIAL2C")
    @Basic
    public int getSdial2C() {
        return sdial2C;
    }

    public void setSdial2C(int sdial2C) {
        this.sdial2C = sdial2C;
    }

    private int sdtaloc;

    @javax.persistence.Column(name = "SDTALOC")
    @Basic
    public int getSdtaloc() {
        return sdtaloc;
    }

    public void setSdtaloc(int sdtaloc) {
        this.sdtaloc = sdtaloc;
    }

    private int sdefinc;

    @javax.persistence.Column(name = "SDEFINC")
    @Basic
    public int getSdefinc() {
        return sdefinc;
    }

    public void setSdefinc(int sdefinc) {
        this.sdefinc = sdefinc;
    }

    private int sexcldc;

    @javax.persistence.Column(name = "SEXCLDC")
    @Basic
    public int getSexcldc() {
        return sexcldc;
    }

    public void setSexcldc(int sexcldc) {
        this.sexcldc = sexcldc;
    }

    private String shvconc;

    @javax.persistence.Column(name = "SHVCONC")
    @Basic
    public String getShvconc() {
        return shvconc;
    }

    public void setShvconc(String shvconc) {
        this.shvconc = shvconc;
    }

    private int stotstfc;

    @javax.persistence.Column(name = "STOTSTFC")
    @Basic
    public int getStotstfc() {
        return stotstfc;
    }

    public void setStotstfc(int stotstfc) {
        this.stotstfc = stotstfc;
    }

    private int srctstfc;

    @javax.persistence.Column(name = "SRCTSTFC")
    @Basic
    public int getSrctstfc() {
        return srctstfc;
    }

    public void setSrctstfc(int srctstfc) {
        this.srctstfc = srctstfc;
    }

    private int sinccrc;

    @javax.persistence.Column(name = "SINCCRC")
    @Basic
    public int getSinccrc() {
        return sinccrc;
    }

    public void setSinccrc(int sinccrc) {
        this.sinccrc = sinccrc;
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

        Sns3Entity that = (Sns3Entity) o;

        if (saaavic != that.saaavic) return false;
        if (saadcc != that.saadcc) return false;
        if (saadjc != that.saadjc) return false;
        if (saagic != that.saagic) return false;
        if (sacsc != that.sacsc) return false;
        if (sadedc != that.sadedc) return false;
        if (saefincc != that.saefincc) return false;
        if (saemalc != that.saemalc) return false;
        if (saficac != that.saficac) return false;
        if (sagiac != that.sagiac) return false;
        if (sagic != that.sagic) return false;
        if (sagimc != that.sagimc) return false;
        if (saial1C != that.saial1C) return false;
        if (saial2C != that.saial2C) return false;
        if (saitxcc != that.saitxcc) return false;
        if (saitxuc != that.saitxuc) return false;
        if (saitxxc != that.saitxxc) return false;
        if (samedac != that.samedac) return false;
        if (samedc != that.samedc) return false;
        if (santx1C != that.santx1C) return false;
        if (santx2C != that.santx2C) return false;
        if (saontic != that.saontic) return false;
        if (saotic != that.saotic) return false;
        if (sapac != that.sapac) return false;
        if (sasmac != that.sasmac) return false;
        if (saspswc != that.saspswc) return false;
        if (sassadc != that.sassadc) return false;
        if (sassc != that.sassc) return false;
        if (sasttxc != that.sasttxc) return false;
        if (sataloc != that.sataloc) return false;
        if (satincc != that.satincc) return false;
        if (satntic != that.satntic) return false;
        if (sattic != that.sattic) return false;
        if (satuitc != that.satuitc) return false;
        if (satutac != that.satutac) return false;
        if (savabac != that.savabac) return false;
        if (savabnc != that.savabnc) return false;
        if (savabuc != that.savabuc) return false;
        if (savbac != that.savbac) return false;
        if (savcac != that.savcac) return false;
        if (savcc != that.savcc) return false;
        if (savcmc != that.savcmc) return false;
        if (savoac != that.savoac) return false;
        if (savoc != that.savoc) return false;
        if (savomc != that.savomc) return false;
        if (sawagc != that.sawagc) return false;
        if (sbfavc != that.sbfavc) return false;
        if (sbfdc != that.sbfdc) return false;
        if (sbfec != that.sbfec) return false;
        if (sbfvc != that.sbfvc) return false;
        if (sbntic != that.sbntic) return false;
        if (sbotic != that.sbotic) return false;
        if (sbspswc != that.sbspswc) return false;
        if (sbwagc != that.sbwagc) return false;
        if (scashc != that.scashc) return false;
        if (scntic != that.scntic) return false;
        if (sconac != that.sconac) return false;
        if (sconfc != that.sconfc) return false;
        if (sconfnc != that.sconfnc) return false;
        if (sconftc != that.sconftc) return false;
        if (scotic != that.scotic) return false;
        if (scspswc != that.scspswc) return false;
        if (sctincc != that.sctincc) return false;
        if (scwagc != that.scwagc) return false;
        if (sddedc != that.sddedc) return false;
        if (sdefinc != that.sdefinc) return false;
        if (sdemalc != that.sdemalc) return false;
        if (sdficac != that.sdficac) return false;
        if (sdial1C != that.sdial1C) return false;
        if (sdial2C != that.sdial2C) return false;
        if (sditxcc != that.sditxcc) return false;
        if (sditxuc != that.sditxuc) return false;
        if (sditxxc != that.sditxxc) return false;
        if (sdmedcc != that.sdmedcc) return false;
        if (sdmedxc != that.sdmedxc) return false;
        if (sdnetc != that.sdnetc) return false;
        if (sdntic != that.sdntic) return false;
        if (sdotic != that.sdotic) return false;
        if (sdsmac != that.sdsmac) return false;
        if (sdspswc != that.sdspswc) return false;
        if (sdsttxc != that.sdsttxc) return false;
        if (sdtaloc != that.sdtaloc) return false;
        if (sdtincc != that.sdtincc) return false;
        if (sdtutac != that.sdtutac) return false;
        if (sdvabnc != that.sdvabnc) return false;
        if (sdwagc != that.sdwagc) return false;
        if (sexcldc != that.sexcldc) return false;
        if (sfarmdc != that.sfarmdc) return false;
        if (sfarmec != that.sfarmec) return false;
        if (sfarmvc != that.sfarmvc) return false;
        if (shomdc != that.shomdc) return false;
        if (shomec != that.shomec) return false;
        if (shomvc != that.shomvc) return false;
        if (sinccrc != that.sinccrc) return false;
        if (snwrthc != that.snwrthc) return false;
        if (soridc != that.soridc) return false;
        if (soriec != that.soriec) return false;
        if (sorivc != that.sorivc) return false;
        if (sothdc != that.sothdc) return false;
        if (srctstfc != that.srctstfc) return false;
        if (stassc != that.stassc) return false;
        if (stotstfc != that.stotstfc) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sadagec1 != null ? !sadagec1.equals(that.sadagec1) : that.sadagec1 != null) return false;
        if (sadagec2 != null ? !sadagec2.equals(that.sadagec2) : that.sadagec2 != null) return false;
        if (sadagec3 != null ? !sadagec3.equals(that.sadagec3) : that.sadagec3 != null) return false;
        if (sagec != null ? !sagec.equals(that.sagec) : that.sagec != null) return false;
        if (satutnc != null ? !satutnc.equals(that.satutnc) : that.satutnc != null) return false;
        if (scacpc != null ? !scacpc.equals(that.scacpc) : that.scacpc != null) return false;
        if (sdishmc != null ? !sdishmc.equals(that.sdishmc) : that.sdishmc != null) return false;
        if (sdiswkc != null ? !sdiswkc.equals(that.sdiswkc) : that.sdiswkc != null) return false;
        if (sexempc != null ? !sexempc.equals(that.sexempc) : that.sexempc != null) return false;
        if (sfarmc != null ? !sfarmc.equals(that.sfarmc) : that.sfarmc != null) return false;
        if (shvconc != null ? !shvconc.equals(that.shvconc) : that.shvconc != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (sinsflgc != null ? !sinsflgc.equals(that.sinsflgc) : that.sinsflgc != null) return false;
        if (smartc != null ? !smartc.equals(that.smartc) : that.smartc != null) return false;
        if (snrpsc != null ? !snrpsc.equals(that.snrpsc) : that.snrpsc != null) return false;
        if (snskey != null ? !snskey.equals(that.snskey) : that.snskey != null) return false;
        if (sselsrvc != null ? !sselsrvc.equals(that.sselsrvc) : that.sselsrvc != null) return false;
        if (ssizhdc != null ? !ssizhdc.equals(that.ssizhdc) : that.ssizhdc != null) return false;
        if (sslsrvmc != null ? !sslsrvmc.equals(that.sslsrvmc) : that.sslsrvmc != null) return false;
        if (strfilc != null ? !strfilc.equals(that.strfilc) : that.strfilc != null) return false;
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
        result = 31 * result + (smartc != null ? smartc.hashCode() : 0);
        result = 31 * result + (sagec != null ? sagec.hashCode() : 0);
        result = 31 * result + (ssizhdc != null ? ssizhdc.hashCode() : 0);
        result = 31 * result + (sexempc != null ? sexempc.hashCode() : 0);
        result = 31 * result + (snrpsc != null ? snrpsc.hashCode() : 0);
        result = 31 * result + (sdiswkc != null ? sdiswkc.hashCode() : 0);
        result = 31 * result + (sdishmc != null ? sdishmc.hashCode() : 0);
        result = 31 * result + (strfilc != null ? strfilc.hashCode() : 0);
        result = 31 * result + (sselsrvc != null ? sselsrvc.hashCode() : 0);
        result = 31 * result + (sslsrvmc != null ? sslsrvmc.hashCode() : 0);
        result = 31 * result + (sinsflgc != null ? sinsflgc.hashCode() : 0);
        result = 31 * result + (sadagec1 != null ? sadagec1.hashCode() : 0);
        result = 31 * result + (sadagec2 != null ? sadagec2.hashCode() : 0);
        result = 31 * result + (sadagec3 != null ? sadagec3.hashCode() : 0);
        result = 31 * result + (sfarmc != null ? sfarmc.hashCode() : 0);
        result = 31 * result + sagimc;
        result = 31 * result + sagiac;
        result = 31 * result + sagic;
        result = 31 * result + savcmc;
        result = 31 * result + savcac;
        result = 31 * result + savcc;
        result = 31 * result + savomc;
        result = 31 * result + savoac;
        result = 31 * result + savoc;
        result = 31 * result + savabuc;
        result = 31 * result + savabnc;
        result = 31 * result + savabac;
        result = 31 * result + sawagc;
        result = 31 * result + saspswc;
        result = 31 * result + saadjc;
        result = 31 * result + saotic;
        result = 31 * result + sattic;
        result = 31 * result + saagic;
        result = 31 * result + sassc;
        result = 31 * result + saadcc;
        result = 31 * result + sacsc;
        result = 31 * result + saontic;
        result = 31 * result + santx1C;
        result = 31 * result + santx2C;
        result = 31 * result + satntic;
        result = 31 * result + satincc;
        result = 31 * result + sadedc;
        result = 31 * result + saitxxc;
        result = 31 * result + saitxcc;
        result = 31 * result + saitxuc;
        result = 31 * result + saficac;
        result = 31 * result + sasttxc;
        result = 31 * result + samedc;
        result = 31 * result + samedac;
        result = 31 * result + satuitc;
        result = 31 * result + (satutnc != null ? satutnc.hashCode() : 0);
        result = 31 * result + satutac;
        result = 31 * result + saemalc;
        result = 31 * result + sasmac;
        result = 31 * result + saial1C;
        result = 31 * result + saial2C;
        result = 31 * result + sataloc;
        result = 31 * result + saefincc;
        result = 31 * result + scashc;
        result = 31 * result + shomvc;
        result = 31 * result + shomdc;
        result = 31 * result + shomec;
        result = 31 * result + sfarmvc;
        result = 31 * result + sfarmdc;
        result = 31 * result + sfarmec;
        result = 31 * result + sorivc;
        result = 31 * result + soridc;
        result = 31 * result + soriec;
        result = 31 * result + sbfvc;
        result = 31 * result + sbfdc;
        result = 31 * result + sbfec;
        result = 31 * result + sbfavc;
        result = 31 * result + sassadc;
        result = 31 * result + stassc;
        result = 31 * result + sothdc;
        result = 31 * result + snwrthc;
        result = 31 * result + sapac;
        result = 31 * result + sdnetc;
        result = 31 * result + (scacpc != null ? scacpc.hashCode() : 0);
        result = 31 * result + sconac;
        result = 31 * result + saaavic;
        result = 31 * result + savbac;
        result = 31 * result + sconftc;
        result = 31 * result + sconfnc;
        result = 31 * result + sconfc;
        result = 31 * result + sdwagc;
        result = 31 * result + sdspswc;
        result = 31 * result + sdotic;
        result = 31 * result + sdntic;
        result = 31 * result + sdvabnc;
        result = 31 * result + sdtincc;
        result = 31 * result + sbwagc;
        result = 31 * result + scwagc;
        result = 31 * result + sbspswc;
        result = 31 * result + scspswc;
        result = 31 * result + sbotic;
        result = 31 * result + scotic;
        result = 31 * result + sbntic;
        result = 31 * result + scntic;
        result = 31 * result + sctincc;
        result = 31 * result + sddedc;
        result = 31 * result + sditxxc;
        result = 31 * result + sditxcc;
        result = 31 * result + sditxuc;
        result = 31 * result + sdficac;
        result = 31 * result + sdsttxc;
        result = 31 * result + sdmedxc;
        result = 31 * result + sdmedcc;
        result = 31 * result + sdtutac;
        result = 31 * result + sdemalc;
        result = 31 * result + sdsmac;
        result = 31 * result + sdial1C;
        result = 31 * result + sdial2C;
        result = 31 * result + sdtaloc;
        result = 31 * result + sdefinc;
        result = 31 * result + sexcldc;
        result = 31 * result + (shvconc != null ? shvconc.hashCode() : 0);
        result = 31 * result + stotstfc;
        result = 31 * result + srctstfc;
        result = 31 * result + sinccrc;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
