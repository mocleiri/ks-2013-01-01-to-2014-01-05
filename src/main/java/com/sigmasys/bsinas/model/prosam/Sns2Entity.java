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
 * Time: 12:15 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNS2", schema = "SIGMA", catalog = "")
@Entity
public class Sns2Entity implements Identifiable {

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

    private String snamel2;

    @javax.persistence.Column(name = "SNAMEL2")
    @Basic
    public String getSnamel2() {
        return snamel2;
    }

    public void setSnamel2(String snamel2) {
        this.snamel2 = snamel2;
    }

    private String snamef2;

    @javax.persistence.Column(name = "SNAMEF2")
    @Basic
    public String getSnamef2() {
        return snamef2;
    }

    public void setSnamef2(String snamef2) {
        this.snamef2 = snamef2;
    }

    private String snamei2;

    @javax.persistence.Column(name = "SNAMEI2")
    @Basic
    public String getSnamei2() {
        return snamei2;
    }

    public void setSnamei2(String snamei2) {
        this.snamei2 = snamei2;
    }

    private String saddr2;

    @javax.persistence.Column(name = "SADDR2")
    @Basic
    public String getSaddr2() {
        return saddr2;
    }

    public void setSaddr2(String saddr2) {
        this.saddr2 = saddr2;
    }

    private String sstate2;

    @javax.persistence.Column(name = "SSTATE2")
    @Basic
    public String getSstate2() {
        return sstate2;
    }

    public void setSstate2(String sstate2) {
        this.sstate2 = sstate2;
    }

    private String szip2;

    @javax.persistence.Column(name = "SZIP2")
    @Basic
    public String getSzip2() {
        return szip2;
    }

    public void setSzip2(String szip2) {
        this.szip2 = szip2;
    }

    private String smartl2;

    @javax.persistence.Column(name = "SMARTL2")
    @Basic
    public String getSmartl2() {
        return smartl2;
    }

    public void setSmartl2(String smartl2) {
        this.smartl2 = smartl2;
    }

    private String stitle2;

    @javax.persistence.Column(name = "STITLE2")
    @Basic
    public String getStitle2() {
        return stitle2;
    }

    public void setStitle2(String stitle2) {
        this.stitle2 = stitle2;
    }

    private String snumdl2;

    @javax.persistence.Column(name = "SNUMDL2")
    @Basic
    public String getSnumdl2() {
        return snumdl2;
    }

    public void setSnumdl2(String snumdl2) {
        this.snumdl2 = snumdl2;
    }

    private String sstdl2;

    @javax.persistence.Column(name = "SSTDL2")
    @Basic
    public String getSstdl2() {
        return sstdl2;
    }

    public void setSstdl2(String sstdl2) {
        this.sstdl2 = sstdl2;
    }

    private String senrsum2;

    @javax.persistence.Column(name = "SENRSUM2")
    @Basic
    public String getSenrsum2() {
        return senrsum2;
    }

    public void setSenrsum2(String senrsum2) {
        this.senrsum2 = senrsum2;
    }

    private String senrfal2;

    @javax.persistence.Column(name = "SENRFAL2")
    @Basic
    public String getSenrfal2() {
        return senrfal2;
    }

    public void setSenrfal2(String senrfal2) {
        this.senrfal2 = senrfal2;
    }

    private String senrwin2;

    @javax.persistence.Column(name = "SENRWIN2")
    @Basic
    public String getSenrwin2() {
        return senrwin2;
    }

    public void setSenrwin2(String senrwin2) {
        this.senrwin2 = senrwin2;
    }

    private String senrspr2;

    @javax.persistence.Column(name = "SENRSPR2")
    @Basic
    public String getSenrspr2() {
        return senrspr2;
    }

    public void setSenrspr2(String senrspr2) {
        this.senrspr2 = senrspr2;
    }

    private BigInteger sage2;

    @javax.persistence.Column(name = "SAGE2")
    @Basic
    public BigInteger getSage2() {
        return sage2;
    }

    public void setSage2(BigInteger sage2) {
        this.sage2 = sage2;
    }

    private BigInteger sszhhd2;

    @javax.persistence.Column(name = "SSZHHD2")
    @Basic
    public BigInteger getSszhhd2() {
        return sszhhd2;
    }

    public void setSszhhd2(BigInteger sszhhd2) {
        this.sszhhd2 = sszhhd2;
    }

    private BigInteger sexemp2;

    @javax.persistence.Column(name = "SEXEMP2")
    @Basic
    public BigInteger getSexemp2() {
        return sexemp2;
    }

    public void setSexemp2(BigInteger sexemp2) {
        this.sexemp2 = sexemp2;
    }

    private BigInteger snrps2;

    @javax.persistence.Column(name = "SNRPS2")
    @Basic
    public BigInteger getSnrps2() {
        return snrps2;
    }

    public void setSnrps2(BigInteger snrps2) {
        this.snrps2 = snrps2;
    }

    private String sdiswk2;

    @javax.persistence.Column(name = "SDISWK2")
    @Basic
    public String getSdiswk2() {
        return sdiswk2;
    }

    public void setSdiswk2(String sdiswk2) {
        this.sdiswk2 = sdiswk2;
    }

    private String sdishm2;

    @javax.persistence.Column(name = "SDISHM2")
    @Basic
    public String getSdishm2() {
        return sdishm2;
    }

    public void setSdishm2(String sdishm2) {
        this.sdishm2 = sdishm2;
    }

    private String strfil2;

    @javax.persistence.Column(name = "STRFIL2")
    @Basic
    public String getStrfil2() {
        return strfil2;
    }

    public void setStrfil2(String strfil2) {
        this.strfil2 = strfil2;
    }

    private String sselsrv2;

    @javax.persistence.Column(name = "SSELSRV2")
    @Basic
    public String getSselsrv2() {
        return sselsrv2;
    }

    public void setSselsrv2(String sselsrv2) {
        this.sselsrv2 = sselsrv2;
    }

    private String sslsrvm2;

    @javax.persistence.Column(name = "SSLSRVM2")
    @Basic
    public String getSslsrvm2() {
        return sslsrvm2;
    }

    public void setSslsrvm2(String sslsrvm2) {
        this.sslsrvm2 = sslsrvm2;
    }

    private String sinsflg2;

    @javax.persistence.Column(name = "SINSFLG2")
    @Basic
    public String getSinsflg2() {
        return sinsflg2;
    }

    public void setSinsflg2(String sinsflg2) {
        this.sinsflg2 = sinsflg2;
    }

    private BigInteger sadage21;

    @javax.persistence.Column(name = "SADAGE21")
    @Basic
    public BigInteger getSadage21() {
        return sadage21;
    }

    public void setSadage21(BigInteger sadage21) {
        this.sadage21 = sadage21;
    }

    private BigInteger sadage22;

    @javax.persistence.Column(name = "SADAGE22")
    @Basic
    public BigInteger getSadage22() {
        return sadage22;
    }

    public void setSadage22(BigInteger sadage22) {
        this.sadage22 = sadage22;
    }

    private BigInteger sadage23;

    @javax.persistence.Column(name = "SADAGE23")
    @Basic
    public BigInteger getSadage23() {
        return sadage23;
    }

    public void setSadage23(BigInteger sadage23) {
        this.sadage23 = sadage23;
    }

    private BigInteger sccaren2;

    @javax.persistence.Column(name = "SCCAREN2")
    @Basic
    public BigInteger getSccaren2() {
        return sccaren2;
    }

    public void setSccaren2(BigInteger sccaren2) {
        this.sccaren2 = sccaren2;
    }

    private String sfarm2;

    @javax.persistence.Column(name = "SFARM2")
    @Basic
    public String getSfarm2() {
        return sfarm2;
    }

    public void setSfarm2(String sfarm2) {
        this.sfarm2 = sfarm2;
    }

    private String sintstf2;

    @javax.persistence.Column(name = "SINTSTF2")
    @Basic
    public String getSintstf2() {
        return sintstf2;
    }

    public void setSintstf2(String sintstf2) {
        this.sintstf2 = sintstf2;
    }

    private String slvlstf2;

    @javax.persistence.Column(name = "SLVLSTF2")
    @Basic
    public String getSlvlstf2() {
        return slvlstf2;
    }

    public void setSlvlstf2(String slvlstf2) {
        this.slvlstf2 = slvlstf2;
    }

    private int stotstf2;

    @javax.persistence.Column(name = "STOTSTF2")
    @Basic
    public int getStotstf2() {
        return stotstf2;
    }

    public void setStotstf2(int stotstf2) {
        this.stotstf2 = stotstf2;
    }

    private int srctstf2;

    @javax.persistence.Column(name = "SRCTSTF2")
    @Basic
    public int getSrctstf2() {
        return srctstf2;
    }

    public void setSrctstf2(int srctstf2) {
        this.srctstf2 = srctstf2;
    }

    private int sagim2;

    @javax.persistence.Column(name = "SAGIM2")
    @Basic
    public int getSagim2() {
        return sagim2;
    }

    public void setSagim2(int sagim2) {
        this.sagim2 = sagim2;
    }

    private int sagia2;

    @javax.persistence.Column(name = "SAGIA2")
    @Basic
    public int getSagia2() {
        return sagia2;
    }

    public void setSagia2(int sagia2) {
        this.sagia2 = sagia2;
    }

    private int sagi2;

    @javax.persistence.Column(name = "SAGI2")
    @Basic
    public int getSagi2() {
        return sagi2;
    }

    public void setSagi2(int sagi2) {
        this.sagi2 = sagi2;
    }

    private int savcm2;

    @javax.persistence.Column(name = "SAVCM2")
    @Basic
    public int getSavcm2() {
        return savcm2;
    }

    public void setSavcm2(int savcm2) {
        this.savcm2 = savcm2;
    }

    private int savca2;

    @javax.persistence.Column(name = "SAVCA2")
    @Basic
    public int getSavca2() {
        return savca2;
    }

    public void setSavca2(int savca2) {
        this.savca2 = savca2;
    }

    private int savc2;

    @javax.persistence.Column(name = "SAVC2")
    @Basic
    public int getSavc2() {
        return savc2;
    }

    public void setSavc2(int savc2) {
        this.savc2 = savc2;
    }

    private int savom2;

    @javax.persistence.Column(name = "SAVOM2")
    @Basic
    public int getSavom2() {
        return savom2;
    }

    public void setSavom2(int savom2) {
        this.savom2 = savom2;
    }

    private int savoa2;

    @javax.persistence.Column(name = "SAVOA2")
    @Basic
    public int getSavoa2() {
        return savoa2;
    }

    public void setSavoa2(int savoa2) {
        this.savoa2 = savoa2;
    }

    private int savo2;

    @javax.persistence.Column(name = "SAVO2")
    @Basic
    public int getSavo2() {
        return savo2;
    }

    public void setSavo2(int savo2) {
        this.savo2 = savo2;
    }

    private int savabu2;

    @javax.persistence.Column(name = "SAVABU2")
    @Basic
    public int getSavabu2() {
        return savabu2;
    }

    public void setSavabu2(int savabu2) {
        this.savabu2 = savabu2;
    }

    private int savabn2;

    @javax.persistence.Column(name = "SAVABN2")
    @Basic
    public int getSavabn2() {
        return savabn2;
    }

    public void setSavabn2(int savabn2) {
        this.savabn2 = savabn2;
    }

    private int savaba2;

    @javax.persistence.Column(name = "SAVABA2")
    @Basic
    public int getSavaba2() {
        return savaba2;
    }

    public void setSavaba2(int savaba2) {
        this.savaba2 = savaba2;
    }

    private int sawag2;

    @javax.persistence.Column(name = "SAWAG2")
    @Basic
    public int getSawag2() {
        return sawag2;
    }

    public void setSawag2(int sawag2) {
        this.sawag2 = sawag2;
    }

    private int saspsw2;

    @javax.persistence.Column(name = "SASPSW2")
    @Basic
    public int getSaspsw2() {
        return saspsw2;
    }

    public void setSaspsw2(int saspsw2) {
        this.saspsw2 = saspsw2;
    }

    private int saadj2;

    @javax.persistence.Column(name = "SAADJ2")
    @Basic
    public int getSaadj2() {
        return saadj2;
    }

    public void setSaadj2(int saadj2) {
        this.saadj2 = saadj2;
    }

    private int saoti2;

    @javax.persistence.Column(name = "SAOTI2")
    @Basic
    public int getSaoti2() {
        return saoti2;
    }

    public void setSaoti2(int saoti2) {
        this.saoti2 = saoti2;
    }

    private int satti2;

    @javax.persistence.Column(name = "SATTI2")
    @Basic
    public int getSatti2() {
        return satti2;
    }

    public void setSatti2(int satti2) {
        this.satti2 = satti2;
    }

    private int saagi2;

    @javax.persistence.Column(name = "SAAGI2")
    @Basic
    public int getSaagi2() {
        return saagi2;
    }

    public void setSaagi2(int saagi2) {
        this.saagi2 = saagi2;
    }

    private int sass2;

    @javax.persistence.Column(name = "SASS2")
    @Basic
    public int getSass2() {
        return sass2;
    }

    public void setSass2(int sass2) {
        this.sass2 = sass2;
    }

    private int saadc2;

    @javax.persistence.Column(name = "SAADC2")
    @Basic
    public int getSaadc2() {
        return saadc2;
    }

    public void setSaadc2(int saadc2) {
        this.saadc2 = saadc2;
    }

    private int sacs2;

    @javax.persistence.Column(name = "SACS2")
    @Basic
    public int getSacs2() {
        return sacs2;
    }

    public void setSacs2(int sacs2) {
        this.sacs2 = sacs2;
    }

    private int saonti2;

    @javax.persistence.Column(name = "SAONTI2")
    @Basic
    public int getSaonti2() {
        return saonti2;
    }

    public void setSaonti2(int saonti2) {
        this.saonti2 = saonti2;
    }

    private int santx12;

    @javax.persistence.Column(name = "SANTX12")
    @Basic
    public int getSantx12() {
        return santx12;
    }

    public void setSantx12(int santx12) {
        this.santx12 = santx12;
    }

    private int santx22;

    @javax.persistence.Column(name = "SANTX22")
    @Basic
    public int getSantx22() {
        return santx22;
    }

    public void setSantx22(int santx22) {
        this.santx22 = santx22;
    }

    private int satnti2;

    @javax.persistence.Column(name = "SATNTI2")
    @Basic
    public int getSatnti2() {
        return satnti2;
    }

    public void setSatnti2(int satnti2) {
        this.satnti2 = satnti2;
    }

    private int satinc2;

    @javax.persistence.Column(name = "SATINC2")
    @Basic
    public int getSatinc2() {
        return satinc2;
    }

    public void setSatinc2(int satinc2) {
        this.satinc2 = satinc2;
    }

    private int saded2;

    @javax.persistence.Column(name = "SADED2")
    @Basic
    public int getSaded2() {
        return saded2;
    }

    public void setSaded2(int saded2) {
        this.saded2 = saded2;
    }

    private int saitx2;

    @javax.persistence.Column(name = "SAITX2")
    @Basic
    public int getSaitx2() {
        return saitx2;
    }

    public void setSaitx2(int saitx2) {
        this.saitx2 = saitx2;
    }

    private int saitxc2;

    @javax.persistence.Column(name = "SAITXC2")
    @Basic
    public int getSaitxc2() {
        return saitxc2;
    }

    public void setSaitxc2(int saitxc2) {
        this.saitxc2 = saitxc2;
    }

    private int saitxu2;

    @javax.persistence.Column(name = "SAITXU2")
    @Basic
    public int getSaitxu2() {
        return saitxu2;
    }

    public void setSaitxu2(int saitxu2) {
        this.saitxu2 = saitxu2;
    }

    private int safica2;

    @javax.persistence.Column(name = "SAFICA2")
    @Basic
    public int getSafica2() {
        return safica2;
    }

    public void setSafica2(int safica2) {
        this.safica2 = safica2;
    }

    private int sasttx2;

    @javax.persistence.Column(name = "SASTTX2")
    @Basic
    public int getSasttx2() {
        return sasttx2;
    }

    public void setSasttx2(int sasttx2) {
        this.sasttx2 = sasttx2;
    }

    private int samed2;

    @javax.persistence.Column(name = "SAMED2")
    @Basic
    public int getSamed2() {
        return samed2;
    }

    public void setSamed2(int samed2) {
        this.samed2 = samed2;
    }

    private int sameda2;

    @javax.persistence.Column(name = "SAMEDA2")
    @Basic
    public int getSameda2() {
        return sameda2;
    }

    public void setSameda2(int sameda2) {
        this.sameda2 = sameda2;
    }

    private int satuit2;

    @javax.persistence.Column(name = "SATUIT2")
    @Basic
    public int getSatuit2() {
        return satuit2;
    }

    public void setSatuit2(int satuit2) {
        this.satuit2 = satuit2;
    }

    private BigInteger satutn2;

    @javax.persistence.Column(name = "SATUTN2")
    @Basic
    public BigInteger getSatutn2() {
        return satutn2;
    }

    public void setSatutn2(BigInteger satutn2) {
        this.satutn2 = satutn2;
    }

    private int satuta2;

    @javax.persistence.Column(name = "SATUTA2")
    @Basic
    public int getSatuta2() {
        return satuta2;
    }

    public void setSatuta2(int satuta2) {
        this.satuta2 = satuta2;
    }

    private int saemal2;

    @javax.persistence.Column(name = "SAEMAL2")
    @Basic
    public int getSaemal2() {
        return saemal2;
    }

    public void setSaemal2(int saemal2) {
        this.saemal2 = saemal2;
    }

    private int sasma2;

    @javax.persistence.Column(name = "SASMA2")
    @Basic
    public int getSasma2() {
        return sasma2;
    }

    public void setSasma2(int sasma2) {
        this.sasma2 = sasma2;
    }

    private int saial12;

    @javax.persistence.Column(name = "SAIAL12")
    @Basic
    public int getSaial12() {
        return saial12;
    }

    public void setSaial12(int saial12) {
        this.saial12 = saial12;
    }

    private int saial22;

    @javax.persistence.Column(name = "SAIAL22")
    @Basic
    public int getSaial22() {
        return saial22;
    }

    public void setSaial22(int saial22) {
        this.saial22 = saial22;
    }

    private int satalo2;

    @javax.persistence.Column(name = "SATALO2")
    @Basic
    public int getSatalo2() {
        return satalo2;
    }

    public void setSatalo2(int satalo2) {
        this.satalo2 = satalo2;
    }

    private int saefin2;

    @javax.persistence.Column(name = "SAEFIN2")
    @Basic
    public int getSaefin2() {
        return saefin2;
    }

    public void setSaefin2(int saefin2) {
        this.saefin2 = saefin2;
    }

    private int scash2;

    @javax.persistence.Column(name = "SCASH2")
    @Basic
    public int getScash2() {
        return scash2;
    }

    public void setScash2(int scash2) {
        this.scash2 = scash2;
    }

    private int shomv2;

    @javax.persistence.Column(name = "SHOMV2")
    @Basic
    public int getShomv2() {
        return shomv2;
    }

    public void setShomv2(int shomv2) {
        this.shomv2 = shomv2;
    }

    private int shomd2;

    @javax.persistence.Column(name = "SHOMD2")
    @Basic
    public int getShomd2() {
        return shomd2;
    }

    public void setShomd2(int shomd2) {
        this.shomd2 = shomd2;
    }

    private int shome2;

    @javax.persistence.Column(name = "SHOME2")
    @Basic
    public int getShome2() {
        return shome2;
    }

    public void setShome2(int shome2) {
        this.shome2 = shome2;
    }

    private int sfarmv2;

    @javax.persistence.Column(name = "SFARMV2")
    @Basic
    public int getSfarmv2() {
        return sfarmv2;
    }

    public void setSfarmv2(int sfarmv2) {
        this.sfarmv2 = sfarmv2;
    }

    private int sfarmd2;

    @javax.persistence.Column(name = "SFARMD2")
    @Basic
    public int getSfarmd2() {
        return sfarmd2;
    }

    public void setSfarmd2(int sfarmd2) {
        this.sfarmd2 = sfarmd2;
    }

    private int sfarme2;

    @javax.persistence.Column(name = "SFARME2")
    @Basic
    public int getSfarme2() {
        return sfarme2;
    }

    public void setSfarme2(int sfarme2) {
        this.sfarme2 = sfarme2;
    }

    private int soriv2;

    @javax.persistence.Column(name = "SORIV2")
    @Basic
    public int getSoriv2() {
        return soriv2;
    }

    public void setSoriv2(int soriv2) {
        this.soriv2 = soriv2;
    }

    private int sorid2;

    @javax.persistence.Column(name = "SORID2")
    @Basic
    public int getSorid2() {
        return sorid2;
    }

    public void setSorid2(int sorid2) {
        this.sorid2 = sorid2;
    }

    private int sorie2;

    @javax.persistence.Column(name = "SORIE2")
    @Basic
    public int getSorie2() {
        return sorie2;
    }

    public void setSorie2(int sorie2) {
        this.sorie2 = sorie2;
    }

    private int sbfv2;

    @javax.persistence.Column(name = "SBFV2")
    @Basic
    public int getSbfv2() {
        return sbfv2;
    }

    public void setSbfv2(int sbfv2) {
        this.sbfv2 = sbfv2;
    }

    private int sbfd2;

    @javax.persistence.Column(name = "SBFD2")
    @Basic
    public int getSbfd2() {
        return sbfd2;
    }

    public void setSbfd2(int sbfd2) {
        this.sbfd2 = sbfd2;
    }

    private int sbfe2;

    @javax.persistence.Column(name = "SBFE2")
    @Basic
    public int getSbfe2() {
        return sbfe2;
    }

    public void setSbfe2(int sbfe2) {
        this.sbfe2 = sbfe2;
    }

    private int sbfav2;

    @javax.persistence.Column(name = "SBFAV2")
    @Basic
    public int getSbfav2() {
        return sbfav2;
    }

    public void setSbfav2(int sbfav2) {
        this.sbfav2 = sbfav2;
    }

    private int sassad2;

    @javax.persistence.Column(name = "SASSAD2")
    @Basic
    public int getSassad2() {
        return sassad2;
    }

    public void setSassad2(int sassad2) {
        this.sassad2 = sassad2;
    }

    private int stass2;

    @javax.persistence.Column(name = "STASS2")
    @Basic
    public int getStass2() {
        return stass2;
    }

    public void setStass2(int stass2) {
        this.stass2 = stass2;
    }

    private int sothd2;

    @javax.persistence.Column(name = "SOTHD2")
    @Basic
    public int getSothd2() {
        return sothd2;
    }

    public void setSothd2(int sothd2) {
        this.sothd2 = sothd2;
    }

    private int snwrth2;

    @javax.persistence.Column(name = "SNWRTH2")
    @Basic
    public int getSnwrth2() {
        return snwrth2;
    }

    public void setSnwrth2(int snwrth2) {
        this.snwrth2 = snwrth2;
    }

    private int sapa2;

    @javax.persistence.Column(name = "SAPA2")
    @Basic
    public int getSapa2() {
        return sapa2;
    }

    public void setSapa2(int sapa2) {
        this.sapa2 = sapa2;
    }

    private int sdnet2;

    @javax.persistence.Column(name = "SDNET2")
    @Basic
    public int getSdnet2() {
        return sdnet2;
    }

    public void setSdnet2(int sdnet2) {
        this.sdnet2 = sdnet2;
    }

    private BigDecimal scacp2;

    @javax.persistence.Column(name = "SCACP2")
    @Basic
    public BigDecimal getScacp2() {
        return scacp2;
    }

    public void setScacp2(BigDecimal scacp2) {
        this.scacp2 = scacp2;
    }

    private int scona2;

    @javax.persistence.Column(name = "SCONA2")
    @Basic
    public int getScona2() {
        return scona2;
    }

    public void setScona2(int scona2) {
        this.scona2 = scona2;
    }

    private int saaavi2;

    @javax.persistence.Column(name = "SAAAVI2")
    @Basic
    public int getSaaavi2() {
        return saaavi2;
    }

    public void setSaaavi2(int saaavi2) {
        this.saaavi2 = saaavi2;
    }

    private int savba2;

    @javax.persistence.Column(name = "SAVBA2")
    @Basic
    public int getSavba2() {
        return savba2;
    }

    public void setSavba2(int savba2) {
        this.savba2 = savba2;
    }

    private int sconft2;

    @javax.persistence.Column(name = "SCONFT2")
    @Basic
    public int getSconft2() {
        return sconft2;
    }

    public void setSconft2(int sconft2) {
        this.sconft2 = sconft2;
    }

    private int sconfn2;

    @javax.persistence.Column(name = "SCONFN2")
    @Basic
    public int getSconfn2() {
        return sconfn2;
    }

    public void setSconfn2(int sconfn2) {
        this.sconfn2 = sconfn2;
    }

    private int sconf2;

    @javax.persistence.Column(name = "SCONF2")
    @Basic
    public int getSconf2() {
        return sconf2;
    }

    public void setSconf2(int sconf2) {
        this.sconf2 = sconf2;
    }

    private int sdwag2;

    @javax.persistence.Column(name = "SDWAG2")
    @Basic
    public int getSdwag2() {
        return sdwag2;
    }

    public void setSdwag2(int sdwag2) {
        this.sdwag2 = sdwag2;
    }

    private int sdspsw2;

    @javax.persistence.Column(name = "SDSPSW2")
    @Basic
    public int getSdspsw2() {
        return sdspsw2;
    }

    public void setSdspsw2(int sdspsw2) {
        this.sdspsw2 = sdspsw2;
    }

    private int sdoti2;

    @javax.persistence.Column(name = "SDOTI2")
    @Basic
    public int getSdoti2() {
        return sdoti2;
    }

    public void setSdoti2(int sdoti2) {
        this.sdoti2 = sdoti2;
    }

    private int sdnti2;

    @javax.persistence.Column(name = "SDNTI2")
    @Basic
    public int getSdnti2() {
        return sdnti2;
    }

    public void setSdnti2(int sdnti2) {
        this.sdnti2 = sdnti2;
    }

    private int sdvabn2;

    @javax.persistence.Column(name = "SDVABN2")
    @Basic
    public int getSdvabn2() {
        return sdvabn2;
    }

    public void setSdvabn2(int sdvabn2) {
        this.sdvabn2 = sdvabn2;
    }

    private int sdtinc2;

    @javax.persistence.Column(name = "SDTINC2")
    @Basic
    public int getSdtinc2() {
        return sdtinc2;
    }

    public void setSdtinc2(int sdtinc2) {
        this.sdtinc2 = sdtinc2;
    }

    private int sbwag2;

    @javax.persistence.Column(name = "SBWAG2")
    @Basic
    public int getSbwag2() {
        return sbwag2;
    }

    public void setSbwag2(int sbwag2) {
        this.sbwag2 = sbwag2;
    }

    private int scwag2;

    @javax.persistence.Column(name = "SCWAG2")
    @Basic
    public int getScwag2() {
        return scwag2;
    }

    public void setScwag2(int scwag2) {
        this.scwag2 = scwag2;
    }

    private int sbspsw2;

    @javax.persistence.Column(name = "SBSPSW2")
    @Basic
    public int getSbspsw2() {
        return sbspsw2;
    }

    public void setSbspsw2(int sbspsw2) {
        this.sbspsw2 = sbspsw2;
    }

    private int scspsw2;

    @javax.persistence.Column(name = "SCSPSW2")
    @Basic
    public int getScspsw2() {
        return scspsw2;
    }

    public void setScspsw2(int scspsw2) {
        this.scspsw2 = scspsw2;
    }

    private int sboti2;

    @javax.persistence.Column(name = "SBOTI2")
    @Basic
    public int getSboti2() {
        return sboti2;
    }

    public void setSboti2(int sboti2) {
        this.sboti2 = sboti2;
    }

    private int scoti2;

    @javax.persistence.Column(name = "SCOTI2")
    @Basic
    public int getScoti2() {
        return scoti2;
    }

    public void setScoti2(int scoti2) {
        this.scoti2 = scoti2;
    }

    private int sbnti2;

    @javax.persistence.Column(name = "SBNTI2")
    @Basic
    public int getSbnti2() {
        return sbnti2;
    }

    public void setSbnti2(int sbnti2) {
        this.sbnti2 = sbnti2;
    }

    private int scnti2;

    @javax.persistence.Column(name = "SCNTI2")
    @Basic
    public int getScnti2() {
        return scnti2;
    }

    public void setScnti2(int scnti2) {
        this.scnti2 = scnti2;
    }

    private int sctinc2;

    @javax.persistence.Column(name = "SCTINC2")
    @Basic
    public int getSctinc2() {
        return sctinc2;
    }

    public void setSctinc2(int sctinc2) {
        this.sctinc2 = sctinc2;
    }

    private int sdded2;

    @javax.persistence.Column(name = "SDDED2")
    @Basic
    public int getSdded2() {
        return sdded2;
    }

    public void setSdded2(int sdded2) {
        this.sdded2 = sdded2;
    }

    private int sditx2;

    @javax.persistence.Column(name = "SDITX2")
    @Basic
    public int getSditx2() {
        return sditx2;
    }

    public void setSditx2(int sditx2) {
        this.sditx2 = sditx2;
    }

    private int sditxc2;

    @javax.persistence.Column(name = "SDITXC2")
    @Basic
    public int getSditxc2() {
        return sditxc2;
    }

    public void setSditxc2(int sditxc2) {
        this.sditxc2 = sditxc2;
    }

    private int sditxu2;

    @javax.persistence.Column(name = "SDITXU2")
    @Basic
    public int getSditxu2() {
        return sditxu2;
    }

    public void setSditxu2(int sditxu2) {
        this.sditxu2 = sditxu2;
    }

    private int sdfica2;

    @javax.persistence.Column(name = "SDFICA2")
    @Basic
    public int getSdfica2() {
        return sdfica2;
    }

    public void setSdfica2(int sdfica2) {
        this.sdfica2 = sdfica2;
    }

    private int sdsttx2;

    @javax.persistence.Column(name = "SDSTTX2")
    @Basic
    public int getSdsttx2() {
        return sdsttx2;
    }

    public void setSdsttx2(int sdsttx2) {
        this.sdsttx2 = sdsttx2;
    }

    private int sdmed2;

    @javax.persistence.Column(name = "SDMED2")
    @Basic
    public int getSdmed2() {
        return sdmed2;
    }

    public void setSdmed2(int sdmed2) {
        this.sdmed2 = sdmed2;
    }

    private int sdmedc2;

    @javax.persistence.Column(name = "SDMEDC2")
    @Basic
    public int getSdmedc2() {
        return sdmedc2;
    }

    public void setSdmedc2(int sdmedc2) {
        this.sdmedc2 = sdmedc2;
    }

    private int sdtuta2;

    @javax.persistence.Column(name = "SDTUTA2")
    @Basic
    public int getSdtuta2() {
        return sdtuta2;
    }

    public void setSdtuta2(int sdtuta2) {
        this.sdtuta2 = sdtuta2;
    }

    private int sdemal2;

    @javax.persistence.Column(name = "SDEMAL2")
    @Basic
    public int getSdemal2() {
        return sdemal2;
    }

    public void setSdemal2(int sdemal2) {
        this.sdemal2 = sdemal2;
    }

    private int sdsma2;

    @javax.persistence.Column(name = "SDSMA2")
    @Basic
    public int getSdsma2() {
        return sdsma2;
    }

    public void setSdsma2(int sdsma2) {
        this.sdsma2 = sdsma2;
    }

    private int sdial12;

    @javax.persistence.Column(name = "SDIAL12")
    @Basic
    public int getSdial12() {
        return sdial12;
    }

    public void setSdial12(int sdial12) {
        this.sdial12 = sdial12;
    }

    private int sdial22;

    @javax.persistence.Column(name = "SDIAL22")
    @Basic
    public int getSdial22() {
        return sdial22;
    }

    public void setSdial22(int sdial22) {
        this.sdial22 = sdial22;
    }

    private int sdtalo2;

    @javax.persistence.Column(name = "SDTALO2")
    @Basic
    public int getSdtalo2() {
        return sdtalo2;
    }

    public void setSdtalo2(int sdtalo2) {
        this.sdtalo2 = sdtalo2;
    }

    private int sdefin2;

    @javax.persistence.Column(name = "SDEFIN2")
    @Basic
    public int getSdefin2() {
        return sdefin2;
    }

    public void setSdefin2(int sdefin2) {
        this.sdefin2 = sdefin2;
    }

    private String scity2;

    @javax.persistence.Column(name = "SCITY2")
    @Basic
    public String getScity2() {
        return scity2;
    }

    public void setScity2(String scity2) {
        this.scity2 = scity2;
    }

    private int sexcld2;

    @javax.persistence.Column(name = "SEXCLD2")
    @Basic
    public int getSexcld2() {
        return sexcld2;
    }

    public void setSexcld2(int sexcld2) {
        this.sexcld2 = sexcld2;
    }

    private String shvcon2;

    @javax.persistence.Column(name = "SHVCON2")
    @Basic
    public String getShvcon2() {
        return shvcon2;
    }

    public void setShvcon2(String shvcon2) {
        this.shvcon2 = shvcon2;
    }

    private int asexcld2;

    @javax.persistence.Column(name = "ASEXCLD2")
    @Basic
    public int getAsexcld2() {
        return asexcld2;
    }

    public void setAsexcld2(int asexcld2) {
        this.asexcld2 = asexcld2;
    }

    private String senrsu22;

    @javax.persistence.Column(name = "SENRSU22")
    @Basic
    public String getSenrsu22() {
        return senrsu22;
    }

    public void setSenrsu22(String senrsu22) {
        this.senrsu22 = senrsu22;
    }

    private int sinccr2;

    @javax.persistence.Column(name = "SINCCR2")
    @Basic
    public int getSinccr2() {
        return sinccr2;
    }

    public void setSinccr2(int sinccr2) {
        this.sinccr2 = sinccr2;
    }

    private int asinccr2;

    @javax.persistence.Column(name = "ASINCCR2")
    @Basic
    public int getAsinccr2() {
        return asinccr2;
    }

    public void setAsinccr2(int asinccr2) {
        this.asinccr2 = asinccr2;
    }

    private int asaonti2;

    @javax.persistence.Column(name = "ASAONTI2")
    @Basic
    public int getAsaonti2() {
        return asaonti2;
    }

    public void setAsaonti2(int asaonti2) {
        this.asaonti2 = asaonti2;
    }

    private String smrld2C;

    @javax.persistence.Column(name = "SMRLD2C")
    @Basic
    public String getSmrld2C() {
        return smrld2C;
    }

    public void setSmrld2C(String smrld2C) {
        this.smrld2C = smrld2C;
    }

    private String shsdt2C;

    @javax.persistence.Column(name = "SHSDT2C")
    @Basic
    public String getShsdt2C() {
        return shsdt2C;
    }

    public void setShsdt2C(String shsdt2C) {
        this.shsdt2C = shsdt2C;
    }

    private String sgedt2C;

    @javax.persistence.Column(name = "SGEDT2C")
    @Basic
    public String getSgedt2C() {
        return sgedt2C;
    }

    public void setSgedt2C(String sgedt2C) {
        this.sgedt2C = sgedt2C;
    }

    private String sdtss2C;

    @javax.persistence.Column(name = "SDTSS2C")
    @Basic
    public String getSdtss2C() {
        return sdtss2C;
    }

    public void setSdtss2C(String sdtss2C) {
        this.sdtss2C = sdtss2C;
    }

    private String sdtse2C;

    @javax.persistence.Column(name = "SDTSE2C")
    @Basic
    public String getSdtse2C() {
        return sdtse2C;
    }

    public void setSdtse2C(String sdtse2C) {
        this.sdtse2C = sdtse2C;
    }

    private String hsgedf2;

    @javax.persistence.Column(name = "HSGEDF2")
    @Basic
    public String getHsgedf2() {
        return hsgedf2;
    }

    public void setHsgedf2(String hsgedf2) {
        this.hsgedf2 = hsgedf2;
    }

    private String hlcnse2;

    @javax.persistence.Column(name = "HLCNSE2")
    @Basic
    public String getHlcnse2() {
        return hlcnse2;
    }

    public void setHlcnse2(String hlcnse2) {
        this.hlcnse2 = hlcnse2;
    }

    private String sresbfr2;

    @javax.persistence.Column(name = "SRESBFR2")
    @Basic
    public String getSresbfr2() {
        return sresbfr2;
    }

    public void setSresbfr2(String sresbfr2) {
        this.sresbfr2 = sresbfr2;
    }

    private String smale2;

    @javax.persistence.Column(name = "SMALE2")
    @Basic
    public String getSmale2() {
        return smale2;
    }

    public void setSmale2(String smale2) {
        this.smale2 = smale2;
    }

    private String sfilrtn2;

    @javax.persistence.Column(name = "SFILRTN2")
    @Basic
    public String getSfilrtn2() {
        return sfilrtn2;
    }

    public void setSfilrtn2(String sfilrtn2) {
        this.sfilrtn2 = sfilrtn2;
    }

    private String selgfil2;

    @javax.persistence.Column(name = "SELGFIL2")
    @Basic
    public String getSelgfil2() {
        return selgfil2;
    }

    public void setSelgfil2(String selgfil2) {
        this.selgfil2 = selgfil2;
    }

    private String sasvast2;

    @javax.persistence.Column(name = "SASVAST2")
    @Basic
    public String getSasvast2() {
        return sasvast2;
    }

    public void setSasvast2(String sasvast2) {
        this.sasvast2 = sasvast2;
    }

    private String primth2;

    @javax.persistence.Column(name = "PRIMTH2")
    @Basic
    public String getPrimth2() {
        return primth2;
    }

    public void setPrimth2(String primth2) {
        this.primth2 = primth2;
    }

    private int pawat12;

    @javax.persistence.Column(name = "PAWAT12")
    @Basic
    public int getPawat12() {
        return pawat12;
    }

    public void setPawat12(int pawat12) {
        this.pawat12 = pawat12;
    }

    private int pawat22;

    @javax.persistence.Column(name = "PAWAT22")
    @Basic
    public int getPawat22() {
        return pawat22;
    }

    public void setPawat22(int pawat22) {
        this.pawat22 = pawat22;
    }

    private int pawat32;

    @javax.persistence.Column(name = "PAWAT32")
    @Basic
    public int getPawat32() {
        return pawat32;
    }

    public void setPawat32(int pawat32) {
        this.pawat32 = pawat32;
    }

    private String psread2;

    @javax.persistence.Column(name = "PSREAD2")
    @Basic
    public String getPsread2() {
        return psread2;
    }

    public void setPsread2(String psread2) {
        this.psread2 = psread2;
    }

    private String drugcn2;

    @javax.persistence.Column(name = "DRUGCN2")
    @Basic
    public String getDrugcn2() {
        return drugcn2;
    }

    public void setDrugcn2(String drugcn2) {
        this.drugcn2 = drugcn2;
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

    private String p1Verfg2;

    @javax.persistence.Column(name = "P1VERFG2")
    @Basic
    public String getP1Verfg2() {
        return p1Verfg2;
    }

    public void setP1Verfg2(String p1Verfg2) {
        this.p1Verfg2 = p1Verfg2;
    }

    private int p1Nefc2;

    @javax.persistence.Column(name = "P1NEFC2")
    @Basic
    public int getP1Nefc2() {
        return p1Nefc2;
    }

    public void setP1Nefc2(int p1Nefc2) {
        this.p1Nefc2 = p1Nefc2;
    }

    private String p2Verfg2;

    @javax.persistence.Column(name = "P2VERFG2")
    @Basic
    public String getP2Verfg2() {
        return p2Verfg2;
    }

    public void setP2Verfg2(String p2Verfg2) {
        this.p2Verfg2 = p2Verfg2;
    }

    private int p2Nefc2;

    @javax.persistence.Column(name = "P2NEFC2")
    @Basic
    public int getP2Nefc2() {
        return p2Nefc2;
    }

    public void setP2Nefc2(int p2Nefc2) {
        this.p2Nefc2 = p2Nefc2;
    }

    private String p3Verfg2;

    @javax.persistence.Column(name = "P3VERFG2")
    @Basic
    public String getP3Verfg2() {
        return p3Verfg2;
    }

    public void setP3Verfg2(String p3Verfg2) {
        this.p3Verfg2 = p3Verfg2;
    }

    private int p3Nefc2;

    @javax.persistence.Column(name = "P3NEFC2")
    @Basic
    public int getP3Nefc2() {
        return p3Nefc2;
    }

    public void setP3Nefc2(int p3Nefc2) {
        this.p3Nefc2 = p3Nefc2;
    }

    private String seqnum32;

    @javax.persistence.Column(name = "SEQNUM32")
    @Basic
    public String getSeqnum32() {
        return seqnum32;
    }

    public void setSeqnum32(String seqnum32) {
        this.seqnum32 = seqnum32;
    }

    private int schcod32;

    @javax.persistence.Column(name = "SCHCOD32")
    @Basic
    public int getSchcod32() {
        return schcod32;
    }

    public void setSchcod32(int schcod32) {
        this.schcod32 = schcod32;
    }

    private BigInteger tranum32;

    @javax.persistence.Column(name = "TRANUM32")
    @Basic
    public BigInteger getTranum32() {
        return tranum32;
    }

    public void setTranum32(BigInteger tranum32) {
        this.tranum32 = tranum32;
    }

    private String lstudt3C2;

    @javax.persistence.Column(name = "LSTUDT3C2")
    @Basic
    public String getLstudt3C2() {
        return lstudt3C2;
    }

    public void setLstudt3C2(String lstudt3C2) {
        this.lstudt3C2 = lstudt3C2;
    }

    private int schamt32;

    @javax.persistence.Column(name = "SCHAMT32")
    @Basic
    public int getSchamt32() {
        return schamt32;
    }

    public void setSchamt32(int schamt32) {
        this.schamt32 = schamt32;
    }

    private int amtptdt32;

    @javax.persistence.Column(name = "AMTPTDT32")
    @Basic
    public int getAmtptdt32() {
        return amtptdt32;
    }

    public void setAmtptdt32(int amtptdt32) {
        this.amtptdt32 = amtptdt32;
    }

    private int rmamtpy32;

    @javax.persistence.Column(name = "RMAMTPY32")
    @Basic
    public int getRmamtpy32() {
        return rmamtpy32;
    }

    public void setRmamtpy32(int rmamtpy32) {
        this.rmamtpy32 = rmamtpy32;
    }

    private int prcntus32;

    @javax.persistence.Column(name = "PRCNTUS32")
    @Basic
    public int getPrcntus32() {
        return prcntus32;
    }

    public void setPrcntus32(int prcntus32) {
        this.prcntus32 = prcntus32;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sns2Entity that = (Sns2Entity) o;

        if (amtptdt32 != that.amtptdt32) return false;
        if (asaonti2 != that.asaonti2) return false;
        if (asexcld2 != that.asexcld2) return false;
        if (asinccr2 != that.asinccr2) return false;
        if (p1Nefc2 != that.p1Nefc2) return false;
        if (p2Nefc2 != that.p2Nefc2) return false;
        if (p3Nefc2 != that.p3Nefc2) return false;
        if (pawat12 != that.pawat12) return false;
        if (pawat22 != that.pawat22) return false;
        if (pawat32 != that.pawat32) return false;
        if (prcntus32 != that.prcntus32) return false;
        if (rmamtpy32 != that.rmamtpy32) return false;
        if (saaavi2 != that.saaavi2) return false;
        if (saadc2 != that.saadc2) return false;
        if (saadj2 != that.saadj2) return false;
        if (saagi2 != that.saagi2) return false;
        if (sacs2 != that.sacs2) return false;
        if (saded2 != that.saded2) return false;
        if (saefin2 != that.saefin2) return false;
        if (saemal2 != that.saemal2) return false;
        if (safica2 != that.safica2) return false;
        if (sagi2 != that.sagi2) return false;
        if (sagia2 != that.sagia2) return false;
        if (sagim2 != that.sagim2) return false;
        if (saial12 != that.saial12) return false;
        if (saial22 != that.saial22) return false;
        if (saitx2 != that.saitx2) return false;
        if (saitxc2 != that.saitxc2) return false;
        if (saitxu2 != that.saitxu2) return false;
        if (samed2 != that.samed2) return false;
        if (sameda2 != that.sameda2) return false;
        if (santx12 != that.santx12) return false;
        if (santx22 != that.santx22) return false;
        if (saonti2 != that.saonti2) return false;
        if (saoti2 != that.saoti2) return false;
        if (sapa2 != that.sapa2) return false;
        if (sasma2 != that.sasma2) return false;
        if (saspsw2 != that.saspsw2) return false;
        if (sass2 != that.sass2) return false;
        if (sassad2 != that.sassad2) return false;
        if (sasttx2 != that.sasttx2) return false;
        if (satalo2 != that.satalo2) return false;
        if (satinc2 != that.satinc2) return false;
        if (satnti2 != that.satnti2) return false;
        if (satti2 != that.satti2) return false;
        if (satuit2 != that.satuit2) return false;
        if (satuta2 != that.satuta2) return false;
        if (savaba2 != that.savaba2) return false;
        if (savabn2 != that.savabn2) return false;
        if (savabu2 != that.savabu2) return false;
        if (savba2 != that.savba2) return false;
        if (savc2 != that.savc2) return false;
        if (savca2 != that.savca2) return false;
        if (savcm2 != that.savcm2) return false;
        if (savo2 != that.savo2) return false;
        if (savoa2 != that.savoa2) return false;
        if (savom2 != that.savom2) return false;
        if (sawag2 != that.sawag2) return false;
        if (sbfav2 != that.sbfav2) return false;
        if (sbfd2 != that.sbfd2) return false;
        if (sbfe2 != that.sbfe2) return false;
        if (sbfv2 != that.sbfv2) return false;
        if (sbnti2 != that.sbnti2) return false;
        if (sboti2 != that.sboti2) return false;
        if (sbspsw2 != that.sbspsw2) return false;
        if (sbwag2 != that.sbwag2) return false;
        if (scash2 != that.scash2) return false;
        if (schamt32 != that.schamt32) return false;
        if (schcod32 != that.schcod32) return false;
        if (scnti2 != that.scnti2) return false;
        if (scona2 != that.scona2) return false;
        if (sconf2 != that.sconf2) return false;
        if (sconfn2 != that.sconfn2) return false;
        if (sconft2 != that.sconft2) return false;
        if (scoti2 != that.scoti2) return false;
        if (scspsw2 != that.scspsw2) return false;
        if (sctinc2 != that.sctinc2) return false;
        if (scwag2 != that.scwag2) return false;
        if (sdded2 != that.sdded2) return false;
        if (sdefin2 != that.sdefin2) return false;
        if (sdemal2 != that.sdemal2) return false;
        if (sdfica2 != that.sdfica2) return false;
        if (sdial12 != that.sdial12) return false;
        if (sdial22 != that.sdial22) return false;
        if (sditx2 != that.sditx2) return false;
        if (sditxc2 != that.sditxc2) return false;
        if (sditxu2 != that.sditxu2) return false;
        if (sdmed2 != that.sdmed2) return false;
        if (sdmedc2 != that.sdmedc2) return false;
        if (sdnet2 != that.sdnet2) return false;
        if (sdnti2 != that.sdnti2) return false;
        if (sdoti2 != that.sdoti2) return false;
        if (sdsma2 != that.sdsma2) return false;
        if (sdspsw2 != that.sdspsw2) return false;
        if (sdsttx2 != that.sdsttx2) return false;
        if (sdtalo2 != that.sdtalo2) return false;
        if (sdtinc2 != that.sdtinc2) return false;
        if (sdtuta2 != that.sdtuta2) return false;
        if (sdvabn2 != that.sdvabn2) return false;
        if (sdwag2 != that.sdwag2) return false;
        if (sexcld2 != that.sexcld2) return false;
        if (sfarmd2 != that.sfarmd2) return false;
        if (sfarme2 != that.sfarme2) return false;
        if (sfarmv2 != that.sfarmv2) return false;
        if (shomd2 != that.shomd2) return false;
        if (shome2 != that.shome2) return false;
        if (shomv2 != that.shomv2) return false;
        if (sinccr2 != that.sinccr2) return false;
        if (snwrth2 != that.snwrth2) return false;
        if (sorid2 != that.sorid2) return false;
        if (sorie2 != that.sorie2) return false;
        if (soriv2 != that.soriv2) return false;
        if (sothd2 != that.sothd2) return false;
        if (srctstf2 != that.srctstf2) return false;
        if (stass2 != that.stass2) return false;
        if (stotstf2 != that.stotstf2) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (drugcn2 != null ? !drugcn2.equals(that.drugcn2) : that.drugcn2 != null) return false;
        if (hlcnse2 != null ? !hlcnse2.equals(that.hlcnse2) : that.hlcnse2 != null) return false;
        if (hsgedf2 != null ? !hsgedf2.equals(that.hsgedf2) : that.hsgedf2 != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (lstudt3C2 != null ? !lstudt3C2.equals(that.lstudt3C2) : that.lstudt3C2 != null) return false;
        if (p1Verfg2 != null ? !p1Verfg2.equals(that.p1Verfg2) : that.p1Verfg2 != null) return false;
        if (p2Verfg2 != null ? !p2Verfg2.equals(that.p2Verfg2) : that.p2Verfg2 != null) return false;
        if (p3Verfg2 != null ? !p3Verfg2.equals(that.p3Verfg2) : that.p3Verfg2 != null) return false;
        if (primth2 != null ? !primth2.equals(that.primth2) : that.primth2 != null) return false;
        if (psread2 != null ? !psread2.equals(that.psread2) : that.psread2 != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sadage21 != null ? !sadage21.equals(that.sadage21) : that.sadage21 != null) return false;
        if (sadage22 != null ? !sadage22.equals(that.sadage22) : that.sadage22 != null) return false;
        if (sadage23 != null ? !sadage23.equals(that.sadage23) : that.sadage23 != null) return false;
        if (saddr2 != null ? !saddr2.equals(that.saddr2) : that.saddr2 != null) return false;
        if (sage2 != null ? !sage2.equals(that.sage2) : that.sage2 != null) return false;
        if (sasvast2 != null ? !sasvast2.equals(that.sasvast2) : that.sasvast2 != null) return false;
        if (satutn2 != null ? !satutn2.equals(that.satutn2) : that.satutn2 != null) return false;
        if (scacp2 != null ? !scacp2.equals(that.scacp2) : that.scacp2 != null) return false;
        if (sccaren2 != null ? !sccaren2.equals(that.sccaren2) : that.sccaren2 != null) return false;
        if (scity2 != null ? !scity2.equals(that.scity2) : that.scity2 != null) return false;
        if (sdishm2 != null ? !sdishm2.equals(that.sdishm2) : that.sdishm2 != null) return false;
        if (sdiswk2 != null ? !sdiswk2.equals(that.sdiswk2) : that.sdiswk2 != null) return false;
        if (sdtse2C != null ? !sdtse2C.equals(that.sdtse2C) : that.sdtse2C != null) return false;
        if (sdtss2C != null ? !sdtss2C.equals(that.sdtss2C) : that.sdtss2C != null) return false;
        if (selgfil2 != null ? !selgfil2.equals(that.selgfil2) : that.selgfil2 != null) return false;
        if (senrfal2 != null ? !senrfal2.equals(that.senrfal2) : that.senrfal2 != null) return false;
        if (senrspr2 != null ? !senrspr2.equals(that.senrspr2) : that.senrspr2 != null) return false;
        if (senrsu22 != null ? !senrsu22.equals(that.senrsu22) : that.senrsu22 != null) return false;
        if (senrsum2 != null ? !senrsum2.equals(that.senrsum2) : that.senrsum2 != null) return false;
        if (senrwin2 != null ? !senrwin2.equals(that.senrwin2) : that.senrwin2 != null) return false;
        if (seqnum32 != null ? !seqnum32.equals(that.seqnum32) : that.seqnum32 != null) return false;
        if (sexemp2 != null ? !sexemp2.equals(that.sexemp2) : that.sexemp2 != null) return false;
        if (sfarm2 != null ? !sfarm2.equals(that.sfarm2) : that.sfarm2 != null) return false;
        if (sfilrtn2 != null ? !sfilrtn2.equals(that.sfilrtn2) : that.sfilrtn2 != null) return false;
        if (sgedt2C != null ? !sgedt2C.equals(that.sgedt2C) : that.sgedt2C != null) return false;
        if (shsdt2C != null ? !shsdt2C.equals(that.shsdt2C) : that.shsdt2C != null) return false;
        if (shvcon2 != null ? !shvcon2.equals(that.shvcon2) : that.shvcon2 != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (sinsflg2 != null ? !sinsflg2.equals(that.sinsflg2) : that.sinsflg2 != null) return false;
        if (sintstf2 != null ? !sintstf2.equals(that.sintstf2) : that.sintstf2 != null) return false;
        if (slvlstf2 != null ? !slvlstf2.equals(that.slvlstf2) : that.slvlstf2 != null) return false;
        if (smale2 != null ? !smale2.equals(that.smale2) : that.smale2 != null) return false;
        if (smartl2 != null ? !smartl2.equals(that.smartl2) : that.smartl2 != null) return false;
        if (smrld2C != null ? !smrld2C.equals(that.smrld2C) : that.smrld2C != null) return false;
        if (snamef2 != null ? !snamef2.equals(that.snamef2) : that.snamef2 != null) return false;
        if (snamei2 != null ? !snamei2.equals(that.snamei2) : that.snamei2 != null) return false;
        if (snamel2 != null ? !snamel2.equals(that.snamel2) : that.snamel2 != null) return false;
        if (snrps2 != null ? !snrps2.equals(that.snrps2) : that.snrps2 != null) return false;
        if (snskey != null ? !snskey.equals(that.snskey) : that.snskey != null) return false;
        if (snumdl2 != null ? !snumdl2.equals(that.snumdl2) : that.snumdl2 != null) return false;
        if (sresbfr2 != null ? !sresbfr2.equals(that.sresbfr2) : that.sresbfr2 != null) return false;
        if (sselsrv2 != null ? !sselsrv2.equals(that.sselsrv2) : that.sselsrv2 != null) return false;
        if (sslsrvm2 != null ? !sslsrvm2.equals(that.sslsrvm2) : that.sslsrvm2 != null) return false;
        if (sstate2 != null ? !sstate2.equals(that.sstate2) : that.sstate2 != null) return false;
        if (sstdl2 != null ? !sstdl2.equals(that.sstdl2) : that.sstdl2 != null) return false;
        if (sszhhd2 != null ? !sszhhd2.equals(that.sszhhd2) : that.sszhhd2 != null) return false;
        if (stitle2 != null ? !stitle2.equals(that.stitle2) : that.stitle2 != null) return false;
        if (strfil2 != null ? !strfil2.equals(that.strfil2) : that.strfil2 != null) return false;
        if (szip2 != null ? !szip2.equals(that.szip2) : that.szip2 != null) return false;
        if (tranum32 != null ? !tranum32.equals(that.tranum32) : that.tranum32 != null) return false;
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
        result = 31 * result + (snamel2 != null ? snamel2.hashCode() : 0);
        result = 31 * result + (snamef2 != null ? snamef2.hashCode() : 0);
        result = 31 * result + (snamei2 != null ? snamei2.hashCode() : 0);
        result = 31 * result + (saddr2 != null ? saddr2.hashCode() : 0);
        result = 31 * result + (sstate2 != null ? sstate2.hashCode() : 0);
        result = 31 * result + (szip2 != null ? szip2.hashCode() : 0);
        result = 31 * result + (smartl2 != null ? smartl2.hashCode() : 0);
        result = 31 * result + (stitle2 != null ? stitle2.hashCode() : 0);
        result = 31 * result + (snumdl2 != null ? snumdl2.hashCode() : 0);
        result = 31 * result + (sstdl2 != null ? sstdl2.hashCode() : 0);
        result = 31 * result + (senrsum2 != null ? senrsum2.hashCode() : 0);
        result = 31 * result + (senrfal2 != null ? senrfal2.hashCode() : 0);
        result = 31 * result + (senrwin2 != null ? senrwin2.hashCode() : 0);
        result = 31 * result + (senrspr2 != null ? senrspr2.hashCode() : 0);
        result = 31 * result + (sage2 != null ? sage2.hashCode() : 0);
        result = 31 * result + (sszhhd2 != null ? sszhhd2.hashCode() : 0);
        result = 31 * result + (sexemp2 != null ? sexemp2.hashCode() : 0);
        result = 31 * result + (snrps2 != null ? snrps2.hashCode() : 0);
        result = 31 * result + (sdiswk2 != null ? sdiswk2.hashCode() : 0);
        result = 31 * result + (sdishm2 != null ? sdishm2.hashCode() : 0);
        result = 31 * result + (strfil2 != null ? strfil2.hashCode() : 0);
        result = 31 * result + (sselsrv2 != null ? sselsrv2.hashCode() : 0);
        result = 31 * result + (sslsrvm2 != null ? sslsrvm2.hashCode() : 0);
        result = 31 * result + (sinsflg2 != null ? sinsflg2.hashCode() : 0);
        result = 31 * result + (sadage21 != null ? sadage21.hashCode() : 0);
        result = 31 * result + (sadage22 != null ? sadage22.hashCode() : 0);
        result = 31 * result + (sadage23 != null ? sadage23.hashCode() : 0);
        result = 31 * result + (sccaren2 != null ? sccaren2.hashCode() : 0);
        result = 31 * result + (sfarm2 != null ? sfarm2.hashCode() : 0);
        result = 31 * result + (sintstf2 != null ? sintstf2.hashCode() : 0);
        result = 31 * result + (slvlstf2 != null ? slvlstf2.hashCode() : 0);
        result = 31 * result + stotstf2;
        result = 31 * result + srctstf2;
        result = 31 * result + sagim2;
        result = 31 * result + sagia2;
        result = 31 * result + sagi2;
        result = 31 * result + savcm2;
        result = 31 * result + savca2;
        result = 31 * result + savc2;
        result = 31 * result + savom2;
        result = 31 * result + savoa2;
        result = 31 * result + savo2;
        result = 31 * result + savabu2;
        result = 31 * result + savabn2;
        result = 31 * result + savaba2;
        result = 31 * result + sawag2;
        result = 31 * result + saspsw2;
        result = 31 * result + saadj2;
        result = 31 * result + saoti2;
        result = 31 * result + satti2;
        result = 31 * result + saagi2;
        result = 31 * result + sass2;
        result = 31 * result + saadc2;
        result = 31 * result + sacs2;
        result = 31 * result + saonti2;
        result = 31 * result + santx12;
        result = 31 * result + santx22;
        result = 31 * result + satnti2;
        result = 31 * result + satinc2;
        result = 31 * result + saded2;
        result = 31 * result + saitx2;
        result = 31 * result + saitxc2;
        result = 31 * result + saitxu2;
        result = 31 * result + safica2;
        result = 31 * result + sasttx2;
        result = 31 * result + samed2;
        result = 31 * result + sameda2;
        result = 31 * result + satuit2;
        result = 31 * result + (satutn2 != null ? satutn2.hashCode() : 0);
        result = 31 * result + satuta2;
        result = 31 * result + saemal2;
        result = 31 * result + sasma2;
        result = 31 * result + saial12;
        result = 31 * result + saial22;
        result = 31 * result + satalo2;
        result = 31 * result + saefin2;
        result = 31 * result + scash2;
        result = 31 * result + shomv2;
        result = 31 * result + shomd2;
        result = 31 * result + shome2;
        result = 31 * result + sfarmv2;
        result = 31 * result + sfarmd2;
        result = 31 * result + sfarme2;
        result = 31 * result + soriv2;
        result = 31 * result + sorid2;
        result = 31 * result + sorie2;
        result = 31 * result + sbfv2;
        result = 31 * result + sbfd2;
        result = 31 * result + sbfe2;
        result = 31 * result + sbfav2;
        result = 31 * result + sassad2;
        result = 31 * result + stass2;
        result = 31 * result + sothd2;
        result = 31 * result + snwrth2;
        result = 31 * result + sapa2;
        result = 31 * result + sdnet2;
        result = 31 * result + (scacp2 != null ? scacp2.hashCode() : 0);
        result = 31 * result + scona2;
        result = 31 * result + saaavi2;
        result = 31 * result + savba2;
        result = 31 * result + sconft2;
        result = 31 * result + sconfn2;
        result = 31 * result + sconf2;
        result = 31 * result + sdwag2;
        result = 31 * result + sdspsw2;
        result = 31 * result + sdoti2;
        result = 31 * result + sdnti2;
        result = 31 * result + sdvabn2;
        result = 31 * result + sdtinc2;
        result = 31 * result + sbwag2;
        result = 31 * result + scwag2;
        result = 31 * result + sbspsw2;
        result = 31 * result + scspsw2;
        result = 31 * result + sboti2;
        result = 31 * result + scoti2;
        result = 31 * result + sbnti2;
        result = 31 * result + scnti2;
        result = 31 * result + sctinc2;
        result = 31 * result + sdded2;
        result = 31 * result + sditx2;
        result = 31 * result + sditxc2;
        result = 31 * result + sditxu2;
        result = 31 * result + sdfica2;
        result = 31 * result + sdsttx2;
        result = 31 * result + sdmed2;
        result = 31 * result + sdmedc2;
        result = 31 * result + sdtuta2;
        result = 31 * result + sdemal2;
        result = 31 * result + sdsma2;
        result = 31 * result + sdial12;
        result = 31 * result + sdial22;
        result = 31 * result + sdtalo2;
        result = 31 * result + sdefin2;
        result = 31 * result + (scity2 != null ? scity2.hashCode() : 0);
        result = 31 * result + sexcld2;
        result = 31 * result + (shvcon2 != null ? shvcon2.hashCode() : 0);
        result = 31 * result + asexcld2;
        result = 31 * result + (senrsu22 != null ? senrsu22.hashCode() : 0);
        result = 31 * result + sinccr2;
        result = 31 * result + asinccr2;
        result = 31 * result + asaonti2;
        result = 31 * result + (smrld2C != null ? smrld2C.hashCode() : 0);
        result = 31 * result + (shsdt2C != null ? shsdt2C.hashCode() : 0);
        result = 31 * result + (sgedt2C != null ? sgedt2C.hashCode() : 0);
        result = 31 * result + (sdtss2C != null ? sdtss2C.hashCode() : 0);
        result = 31 * result + (sdtse2C != null ? sdtse2C.hashCode() : 0);
        result = 31 * result + (hsgedf2 != null ? hsgedf2.hashCode() : 0);
        result = 31 * result + (hlcnse2 != null ? hlcnse2.hashCode() : 0);
        result = 31 * result + (sresbfr2 != null ? sresbfr2.hashCode() : 0);
        result = 31 * result + (smale2 != null ? smale2.hashCode() : 0);
        result = 31 * result + (sfilrtn2 != null ? sfilrtn2.hashCode() : 0);
        result = 31 * result + (selgfil2 != null ? selgfil2.hashCode() : 0);
        result = 31 * result + (sasvast2 != null ? sasvast2.hashCode() : 0);
        result = 31 * result + (primth2 != null ? primth2.hashCode() : 0);
        result = 31 * result + pawat12;
        result = 31 * result + pawat22;
        result = 31 * result + pawat32;
        result = 31 * result + (psread2 != null ? psread2.hashCode() : 0);
        result = 31 * result + (drugcn2 != null ? drugcn2.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        result = 31 * result + (p1Verfg2 != null ? p1Verfg2.hashCode() : 0);
        result = 31 * result + p1Nefc2;
        result = 31 * result + (p2Verfg2 != null ? p2Verfg2.hashCode() : 0);
        result = 31 * result + p2Nefc2;
        result = 31 * result + (p3Verfg2 != null ? p3Verfg2.hashCode() : 0);
        result = 31 * result + p3Nefc2;
        result = 31 * result + (seqnum32 != null ? seqnum32.hashCode() : 0);
        result = 31 * result + schcod32;
        result = 31 * result + (tranum32 != null ? tranum32.hashCode() : 0);
        result = 31 * result + (lstudt3C2 != null ? lstudt3C2.hashCode() : 0);
        result = 31 * result + schamt32;
        result = 31 * result + amtptdt32;
        result = 31 * result + rmamtpy32;
        result = 31 * result + prcntus32;
        return result;
    }
}
