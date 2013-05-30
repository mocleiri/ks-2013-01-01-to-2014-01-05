package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/26/12
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNF8", schema = "SIGMA", catalog = "")
@Entity
public class Snf8Entity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnfkey();
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

    private String snfkey;

    @javax.persistence.Column(name = "SNFKEY")
    @Id
    public String getSnfkey() {
        return snfkey;
    }

    public void setSnfkey(String snfkey) {
        this.snfkey = snfkey;
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

    private String nsldsfg;

    @javax.persistence.Column(name = "NSLDSFG")
    @Basic
    public String getNsldsfg() {
        return nsldsfg;
    }

    public void setNsldsfg(String nsldsfg) {
        this.nsldsfg = nsldsfg;
    }

    private int agsuopb;

    @javax.persistence.Column(name = "AGSUOPB")
    @Basic
    public int getAgsuopb() {
        return agsuopb;
    }

    public void setAgsuopb(int agsuopb) {
        this.agsuopb = agsuopb;
    }

    private int agusopb;

    @javax.persistence.Column(name = "AGUSOPB")
    @Basic
    public int getAgusopb() {
        return agusopb;
    }

    public void setAgusopb(int agusopb) {
        this.agusopb = agusopb;
    }

    private int agcnopb;

    @javax.persistence.Column(name = "AGCNOPB")
    @Basic
    public int getAgcnopb() {
        return agcnopb;
    }

    public void setAgcnopb(int agcnopb) {
        this.agcnopb = agcnopb;
    }

    private String lnfmcd1;

    @javax.persistence.Column(name = "LNFMCD1")
    @Basic
    public String getLnfmcd1() {
        return lnfmcd1;
    }

    public void setLnfmcd1(String lnfmcd1) {
        this.lnfmcd1 = lnfmcd1;
    }

    private String adlnfg1;

    @javax.persistence.Column(name = "ADLNFG1")
    @Basic
    public String getAdlnfg1() {
        return adlnfg1;
    }

    public void setAdlnfg1(String adlnfg1) {
        this.adlnfg1 = adlnfg1;
    }

    private String pgmcd1;

    @javax.persistence.Column(name = "PGMCD1")
    @Basic
    public String getPgmcd1() {
        return pgmcd1;
    }

    public void setPgmcd1(String pgmcd1) {
        this.pgmcd1 = pgmcd1;
    }

    private String statcd1;

    @javax.persistence.Column(name = "STATCD1")
    @Basic
    public String getStatcd1() {
        return statcd1;
    }

    public void setStatcd1(String statcd1) {
        this.statcd1 = statcd1;
    }

    private String statdt1;

    @javax.persistence.Column(name = "STATDT1")
    @Basic
    public String getStatdt1() {
        return statdt1;
    }

    public void setStatdt1(String statdt1) {
        this.statdt1 = statdt1;
    }

    private int outbal1;

    @javax.persistence.Column(name = "OUTBAL1")
    @Basic
    public int getOutbal1() {
        return outbal1;
    }

    public void setOutbal1(int outbal1) {
        this.outbal1 = outbal1;
    }

    private String begdt1;

    @javax.persistence.Column(name = "BEGDT1")
    @Basic
    public String getBegdt1() {
        return begdt1;
    }

    public void setBegdt1(String begdt1) {
        this.begdt1 = begdt1;
    }

    private String enddt1;

    @javax.persistence.Column(name = "ENDDT1")
    @Basic
    public String getEnddt1() {
        return enddt1;
    }

    public void setEnddt1(String enddt1) {
        this.enddt1 = enddt1;
    }

    private String gacode1;

    @javax.persistence.Column(name = "GACODE1")
    @Basic
    public String getGacode1() {
        return gacode1;
    }

    public void setGacode1(String gacode1) {
        this.gacode1 = gacode1;
    }

    private String instcd1;

    @javax.persistence.Column(name = "INSTCD1")
    @Basic
    public String getInstcd1() {
        return instcd1;
    }

    public void setInstcd1(String instcd1) {
        this.instcd1 = instcd1;
    }

    private String sercd1;

    @javax.persistence.Column(name = "SERCD1")
    @Basic
    public String getSercd1() {
        return sercd1;
    }

    public void setSercd1(String sercd1) {
        this.sercd1 = sercd1;
    }

    private String regcd1;

    @javax.persistence.Column(name = "REGCD1")
    @Basic
    public String getRegcd1() {
        return regcd1;
    }

    public void setRegcd1(String regcd1) {
        this.regcd1 = regcd1;
    }

    private String lnfmcd2;

    @javax.persistence.Column(name = "LNFMCD2")
    @Basic
    public String getLnfmcd2() {
        return lnfmcd2;
    }

    public void setLnfmcd2(String lnfmcd2) {
        this.lnfmcd2 = lnfmcd2;
    }

    private String adlnfg2;

    @javax.persistence.Column(name = "ADLNFG2")
    @Basic
    public String getAdlnfg2() {
        return adlnfg2;
    }

    public void setAdlnfg2(String adlnfg2) {
        this.adlnfg2 = adlnfg2;
    }

    private String pgmcd2;

    @javax.persistence.Column(name = "PGMCD2")
    @Basic
    public String getPgmcd2() {
        return pgmcd2;
    }

    public void setPgmcd2(String pgmcd2) {
        this.pgmcd2 = pgmcd2;
    }

    private String statcd2;

    @javax.persistence.Column(name = "STATCD2")
    @Basic
    public String getStatcd2() {
        return statcd2;
    }

    public void setStatcd2(String statcd2) {
        this.statcd2 = statcd2;
    }

    private String statdt2;

    @javax.persistence.Column(name = "STATDT2")
    @Basic
    public String getStatdt2() {
        return statdt2;
    }

    public void setStatdt2(String statdt2) {
        this.statdt2 = statdt2;
    }

    private int outbal2;

    @javax.persistence.Column(name = "OUTBAL2")
    @Basic
    public int getOutbal2() {
        return outbal2;
    }

    public void setOutbal2(int outbal2) {
        this.outbal2 = outbal2;
    }

    private String begdt2;

    @javax.persistence.Column(name = "BEGDT2")
    @Basic
    public String getBegdt2() {
        return begdt2;
    }

    public void setBegdt2(String begdt2) {
        this.begdt2 = begdt2;
    }

    private String enddt2;

    @javax.persistence.Column(name = "ENDDT2")
    @Basic
    public String getEnddt2() {
        return enddt2;
    }

    public void setEnddt2(String enddt2) {
        this.enddt2 = enddt2;
    }

    private String gacode2;

    @javax.persistence.Column(name = "GACODE2")
    @Basic
    public String getGacode2() {
        return gacode2;
    }

    public void setGacode2(String gacode2) {
        this.gacode2 = gacode2;
    }

    private String instcd2;

    @javax.persistence.Column(name = "INSTCD2")
    @Basic
    public String getInstcd2() {
        return instcd2;
    }

    public void setInstcd2(String instcd2) {
        this.instcd2 = instcd2;
    }

    private String sercd2;

    @javax.persistence.Column(name = "SERCD2")
    @Basic
    public String getSercd2() {
        return sercd2;
    }

    public void setSercd2(String sercd2) {
        this.sercd2 = sercd2;
    }

    private String regcd2;

    @javax.persistence.Column(name = "REGCD2")
    @Basic
    public String getRegcd2() {
        return regcd2;
    }

    public void setRegcd2(String regcd2) {
        this.regcd2 = regcd2;
    }

    private String lnfmcd3;

    @javax.persistence.Column(name = "LNFMCD3")
    @Basic
    public String getLnfmcd3() {
        return lnfmcd3;
    }

    public void setLnfmcd3(String lnfmcd3) {
        this.lnfmcd3 = lnfmcd3;
    }

    private String adlnfg3;

    @javax.persistence.Column(name = "ADLNFG3")
    @Basic
    public String getAdlnfg3() {
        return adlnfg3;
    }

    public void setAdlnfg3(String adlnfg3) {
        this.adlnfg3 = adlnfg3;
    }

    private String pgmcd3;

    @javax.persistence.Column(name = "PGMCD3")
    @Basic
    public String getPgmcd3() {
        return pgmcd3;
    }

    public void setPgmcd3(String pgmcd3) {
        this.pgmcd3 = pgmcd3;
    }

    private String statcd3;

    @javax.persistence.Column(name = "STATCD3")
    @Basic
    public String getStatcd3() {
        return statcd3;
    }

    public void setStatcd3(String statcd3) {
        this.statcd3 = statcd3;
    }

    private String statdt3;

    @javax.persistence.Column(name = "STATDT3")
    @Basic
    public String getStatdt3() {
        return statdt3;
    }

    public void setStatdt3(String statdt3) {
        this.statdt3 = statdt3;
    }

    private int outbal3;

    @javax.persistence.Column(name = "OUTBAL3")
    @Basic
    public int getOutbal3() {
        return outbal3;
    }

    public void setOutbal3(int outbal3) {
        this.outbal3 = outbal3;
    }

    private String begdt3;

    @javax.persistence.Column(name = "BEGDT3")
    @Basic
    public String getBegdt3() {
        return begdt3;
    }

    public void setBegdt3(String begdt3) {
        this.begdt3 = begdt3;
    }

    private String enddt3;

    @javax.persistence.Column(name = "ENDDT3")
    @Basic
    public String getEnddt3() {
        return enddt3;
    }

    public void setEnddt3(String enddt3) {
        this.enddt3 = enddt3;
    }

    private String gacode3;

    @javax.persistence.Column(name = "GACODE3")
    @Basic
    public String getGacode3() {
        return gacode3;
    }

    public void setGacode3(String gacode3) {
        this.gacode3 = gacode3;
    }

    private String instcd3;

    @javax.persistence.Column(name = "INSTCD3")
    @Basic
    public String getInstcd3() {
        return instcd3;
    }

    public void setInstcd3(String instcd3) {
        this.instcd3 = instcd3;
    }

    private String sercd3;

    @javax.persistence.Column(name = "SERCD3")
    @Basic
    public String getSercd3() {
        return sercd3;
    }

    public void setSercd3(String sercd3) {
        this.sercd3 = sercd3;
    }

    private String regcd3;

    @javax.persistence.Column(name = "REGCD3")
    @Basic
    public String getRegcd3() {
        return regcd3;
    }

    public void setRegcd3(String regcd3) {
        this.regcd3 = regcd3;
    }

    private String fhsgedf;

    @javax.persistence.Column(name = "FHSGEDF")
    @Basic
    public String getFhsgedf() {
        return fhsgedf;
    }

    public void setFhsgedf(String fhsgedf) {
        this.fhsgedf = fhsgedf;
    }

    private String lncncd1;

    @javax.persistence.Column(name = "LNCNCD1")
    @Basic
    public String getLncncd1() {
        return lncncd1;
    }

    public void setLncncd1(String lncncd1) {
        this.lncncd1 = lncncd1;
    }

    private String lncncd2;

    @javax.persistence.Column(name = "LNCNCD2")
    @Basic
    public String getLncncd2() {
        return lncncd2;
    }

    public void setLncncd2(String lncncd2) {
        this.lncncd2 = lncncd2;
    }

    private String lncncd3;

    @javax.persistence.Column(name = "LNCNCD3")
    @Basic
    public String getLncncd3() {
        return lncncd3;
    }

    public void setLncncd3(String lncncd3) {
        this.lncncd3 = lncncd3;
    }

    private String lncncd4;

    @javax.persistence.Column(name = "LNCNCD4")
    @Basic
    public String getLncncd4() {
        return lncncd4;
    }

    public void setLncncd4(String lncncd4) {
        this.lncncd4 = lncncd4;
    }

    private String lncncd5;

    @javax.persistence.Column(name = "LNCNCD5")
    @Basic
    public String getLncncd5() {
        return lncncd5;
    }

    public void setLncncd5(String lncncd5) {
        this.lncncd5 = lncncd5;
    }

    private String lncncd6;

    @javax.persistence.Column(name = "LNCNCD6")
    @Basic
    public String getLncncd6() {
        return lncncd6;
    }

    public void setLncncd6(String lncncd6) {
        this.lncncd6 = lncncd6;
    }

    private String lnfmcd4;

    @javax.persistence.Column(name = "LNFMCD4")
    @Basic
    public String getLnfmcd4() {
        return lnfmcd4;
    }

    public void setLnfmcd4(String lnfmcd4) {
        this.lnfmcd4 = lnfmcd4;
    }

    private String adlnfg4;

    @javax.persistence.Column(name = "ADLNFG4")
    @Basic
    public String getAdlnfg4() {
        return adlnfg4;
    }

    public void setAdlnfg4(String adlnfg4) {
        this.adlnfg4 = adlnfg4;
    }

    private String pgmcd4;

    @javax.persistence.Column(name = "PGMCD4")
    @Basic
    public String getPgmcd4() {
        return pgmcd4;
    }

    public void setPgmcd4(String pgmcd4) {
        this.pgmcd4 = pgmcd4;
    }

    private String statcd4;

    @javax.persistence.Column(name = "STATCD4")
    @Basic
    public String getStatcd4() {
        return statcd4;
    }

    public void setStatcd4(String statcd4) {
        this.statcd4 = statcd4;
    }

    private String statdt4;

    @javax.persistence.Column(name = "STATDT4")
    @Basic
    public String getStatdt4() {
        return statdt4;
    }

    public void setStatdt4(String statdt4) {
        this.statdt4 = statdt4;
    }

    private int outbal4;

    @javax.persistence.Column(name = "OUTBAL4")
    @Basic
    public int getOutbal4() {
        return outbal4;
    }

    public void setOutbal4(int outbal4) {
        this.outbal4 = outbal4;
    }

    private String begdt4;

    @javax.persistence.Column(name = "BEGDT4")
    @Basic
    public String getBegdt4() {
        return begdt4;
    }

    public void setBegdt4(String begdt4) {
        this.begdt4 = begdt4;
    }

    private String enddt4;

    @javax.persistence.Column(name = "ENDDT4")
    @Basic
    public String getEnddt4() {
        return enddt4;
    }

    public void setEnddt4(String enddt4) {
        this.enddt4 = enddt4;
    }

    private String gacode4;

    @javax.persistence.Column(name = "GACODE4")
    @Basic
    public String getGacode4() {
        return gacode4;
    }

    public void setGacode4(String gacode4) {
        this.gacode4 = gacode4;
    }

    private String instcd4;

    @javax.persistence.Column(name = "INSTCD4")
    @Basic
    public String getInstcd4() {
        return instcd4;
    }

    public void setInstcd4(String instcd4) {
        this.instcd4 = instcd4;
    }

    private String sercd4;

    @javax.persistence.Column(name = "SERCD4")
    @Basic
    public String getSercd4() {
        return sercd4;
    }

    public void setSercd4(String sercd4) {
        this.sercd4 = sercd4;
    }

    private String regcd4;

    @javax.persistence.Column(name = "REGCD4")
    @Basic
    public String getRegcd4() {
        return regcd4;
    }

    public void setRegcd4(String regcd4) {
        this.regcd4 = regcd4;
    }

    private String lnfmcd5;

    @javax.persistence.Column(name = "LNFMCD5")
    @Basic
    public String getLnfmcd5() {
        return lnfmcd5;
    }

    public void setLnfmcd5(String lnfmcd5) {
        this.lnfmcd5 = lnfmcd5;
    }

    private String adlnfg5;

    @javax.persistence.Column(name = "ADLNFG5")
    @Basic
    public String getAdlnfg5() {
        return adlnfg5;
    }

    public void setAdlnfg5(String adlnfg5) {
        this.adlnfg5 = adlnfg5;
    }

    private String pgmcd5;

    @javax.persistence.Column(name = "PGMCD5")
    @Basic
    public String getPgmcd5() {
        return pgmcd5;
    }

    public void setPgmcd5(String pgmcd5) {
        this.pgmcd5 = pgmcd5;
    }

    private String statcd5;

    @javax.persistence.Column(name = "STATCD5")
    @Basic
    public String getStatcd5() {
        return statcd5;
    }

    public void setStatcd5(String statcd5) {
        this.statcd5 = statcd5;
    }

    private String statdt5;

    @javax.persistence.Column(name = "STATDT5")
    @Basic
    public String getStatdt5() {
        return statdt5;
    }

    public void setStatdt5(String statdt5) {
        this.statdt5 = statdt5;
    }

    private int outbal5;

    @javax.persistence.Column(name = "OUTBAL5")
    @Basic
    public int getOutbal5() {
        return outbal5;
    }

    public void setOutbal5(int outbal5) {
        this.outbal5 = outbal5;
    }

    private String begdt5;

    @javax.persistence.Column(name = "BEGDT5")
    @Basic
    public String getBegdt5() {
        return begdt5;
    }

    public void setBegdt5(String begdt5) {
        this.begdt5 = begdt5;
    }

    private String enddt5;

    @javax.persistence.Column(name = "ENDDT5")
    @Basic
    public String getEnddt5() {
        return enddt5;
    }

    public void setEnddt5(String enddt5) {
        this.enddt5 = enddt5;
    }

    private String gacode5;

    @javax.persistence.Column(name = "GACODE5")
    @Basic
    public String getGacode5() {
        return gacode5;
    }

    public void setGacode5(String gacode5) {
        this.gacode5 = gacode5;
    }

    private String instcd5;

    @javax.persistence.Column(name = "INSTCD5")
    @Basic
    public String getInstcd5() {
        return instcd5;
    }

    public void setInstcd5(String instcd5) {
        this.instcd5 = instcd5;
    }

    private String sercd5;

    @javax.persistence.Column(name = "SERCD5")
    @Basic
    public String getSercd5() {
        return sercd5;
    }

    public void setSercd5(String sercd5) {
        this.sercd5 = sercd5;
    }

    private String regcd5;

    @javax.persistence.Column(name = "REGCD5")
    @Basic
    public String getRegcd5() {
        return regcd5;
    }

    public void setRegcd5(String regcd5) {
        this.regcd5 = regcd5;
    }

    private String lnfmcd6;

    @javax.persistence.Column(name = "LNFMCD6")
    @Basic
    public String getLnfmcd6() {
        return lnfmcd6;
    }

    public void setLnfmcd6(String lnfmcd6) {
        this.lnfmcd6 = lnfmcd6;
    }

    private String adlnfg6;

    @javax.persistence.Column(name = "ADLNFG6")
    @Basic
    public String getAdlnfg6() {
        return adlnfg6;
    }

    public void setAdlnfg6(String adlnfg6) {
        this.adlnfg6 = adlnfg6;
    }

    private String pgmcd6;

    @javax.persistence.Column(name = "PGMCD6")
    @Basic
    public String getPgmcd6() {
        return pgmcd6;
    }

    public void setPgmcd6(String pgmcd6) {
        this.pgmcd6 = pgmcd6;
    }

    private String statcd6;

    @javax.persistence.Column(name = "STATCD6")
    @Basic
    public String getStatcd6() {
        return statcd6;
    }

    public void setStatcd6(String statcd6) {
        this.statcd6 = statcd6;
    }

    private String statdt6;

    @javax.persistence.Column(name = "STATDT6")
    @Basic
    public String getStatdt6() {
        return statdt6;
    }

    public void setStatdt6(String statdt6) {
        this.statdt6 = statdt6;
    }

    private int outbal6;

    @javax.persistence.Column(name = "OUTBAL6")
    @Basic
    public int getOutbal6() {
        return outbal6;
    }

    public void setOutbal6(int outbal6) {
        this.outbal6 = outbal6;
    }

    private String begdt6;

    @javax.persistence.Column(name = "BEGDT6")
    @Basic
    public String getBegdt6() {
        return begdt6;
    }

    public void setBegdt6(String begdt6) {
        this.begdt6 = begdt6;
    }

    private String enddt6;

    @javax.persistence.Column(name = "ENDDT6")
    @Basic
    public String getEnddt6() {
        return enddt6;
    }

    public void setEnddt6(String enddt6) {
        this.enddt6 = enddt6;
    }

    private String gacode6;

    @javax.persistence.Column(name = "GACODE6")
    @Basic
    public String getGacode6() {
        return gacode6;
    }

    public void setGacode6(String gacode6) {
        this.gacode6 = gacode6;
    }

    private String instcd6;

    @javax.persistence.Column(name = "INSTCD6")
    @Basic
    public String getInstcd6() {
        return instcd6;
    }

    public void setInstcd6(String instcd6) {
        this.instcd6 = instcd6;
    }

    private String sercd6;

    @javax.persistence.Column(name = "SERCD6")
    @Basic
    public String getSercd6() {
        return sercd6;
    }

    public void setSercd6(String sercd6) {
        this.sercd6 = sercd6;
    }

    private String regcd6;

    @javax.persistence.Column(name = "REGCD6")
    @Basic
    public String getRegcd6() {
        return regcd6;
    }

    public void setRegcd6(String regcd6) {
        this.regcd6 = regcd6;
    }

    private String fadlnf1;

    @javax.persistence.Column(name = "FADLNF1")
    @Basic
    public String getFadlnf1() {
        return fadlnf1;
    }

    public void setFadlnf1(String fadlnf1) {
        this.fadlnf1 = fadlnf1;
    }

    private String fpgmcd1;

    @javax.persistence.Column(name = "FPGMCD1")
    @Basic
    public String getFpgmcd1() {
        return fpgmcd1;
    }

    public void setFpgmcd1(String fpgmcd1) {
        this.fpgmcd1 = fpgmcd1;
    }

    private String fstcd1;

    @javax.persistence.Column(name = "FSTCD1")
    @Basic
    public String getFstcd1() {
        return fstcd1;
    }

    public void setFstcd1(String fstcd1) {
        this.fstcd1 = fstcd1;
    }

    private String fstdt1;

    @javax.persistence.Column(name = "FSTDT1")
    @Basic
    public String getFstdt1() {
        return fstdt1;
    }

    public void setFstdt1(String fstdt1) {
        this.fstdt1 = fstdt1;
    }

    private int flnamt1;

    @javax.persistence.Column(name = "FLNAMT1")
    @Basic
    public int getFlnamt1() {
        return flnamt1;
    }

    public void setFlnamt1(int flnamt1) {
        this.flnamt1 = flnamt1;
    }

    private int fotbal1;

    @javax.persistence.Column(name = "FOTBAL1")
    @Basic
    public int getFotbal1() {
        return fotbal1;
    }

    public void setFotbal1(int fotbal1) {
        this.fotbal1 = fotbal1;
    }

    private String foutdt1;

    @javax.persistence.Column(name = "FOUTDT1")
    @Basic
    public String getFoutdt1() {
        return foutdt1;
    }

    public void setFoutdt1(String foutdt1) {
        this.foutdt1 = foutdt1;
    }

    private String fbegdt1;

    @javax.persistence.Column(name = "FBEGDT1")
    @Basic
    public String getFbegdt1() {
        return fbegdt1;
    }

    public void setFbegdt1(String fbegdt1) {
        this.fbegdt1 = fbegdt1;
    }

    private String fenddt1;

    @javax.persistence.Column(name = "FENDDT1")
    @Basic
    public String getFenddt1() {
        return fenddt1;
    }

    public void setFenddt1(String fenddt1) {
        this.fenddt1 = fenddt1;
    }

    private String fgacde1;

    @javax.persistence.Column(name = "FGACDE1")
    @Basic
    public String getFgacde1() {
        return fgacde1;
    }

    public void setFgacde1(String fgacde1) {
        this.fgacde1 = fgacde1;
    }

    private String fsercd1;

    @javax.persistence.Column(name = "FSERCD1")
    @Basic
    public String getFsercd1() {
        return fsercd1;
    }

    public void setFsercd1(String fsercd1) {
        this.fsercd1 = fsercd1;
    }

    private String fadlnf2;

    @javax.persistence.Column(name = "FADLNF2")
    @Basic
    public String getFadlnf2() {
        return fadlnf2;
    }

    public void setFadlnf2(String fadlnf2) {
        this.fadlnf2 = fadlnf2;
    }

    private String fpgmcd2;

    @javax.persistence.Column(name = "FPGMCD2")
    @Basic
    public String getFpgmcd2() {
        return fpgmcd2;
    }

    public void setFpgmcd2(String fpgmcd2) {
        this.fpgmcd2 = fpgmcd2;
    }

    private String fstcd2;

    @javax.persistence.Column(name = "FSTCD2")
    @Basic
    public String getFstcd2() {
        return fstcd2;
    }

    public void setFstcd2(String fstcd2) {
        this.fstcd2 = fstcd2;
    }

    private String fstdt2;

    @javax.persistence.Column(name = "FSTDT2")
    @Basic
    public String getFstdt2() {
        return fstdt2;
    }

    public void setFstdt2(String fstdt2) {
        this.fstdt2 = fstdt2;
    }

    private int flnamt2;

    @javax.persistence.Column(name = "FLNAMT2")
    @Basic
    public int getFlnamt2() {
        return flnamt2;
    }

    public void setFlnamt2(int flnamt2) {
        this.flnamt2 = flnamt2;
    }

    private int fotbal2;

    @javax.persistence.Column(name = "FOTBAL2")
    @Basic
    public int getFotbal2() {
        return fotbal2;
    }

    public void setFotbal2(int fotbal2) {
        this.fotbal2 = fotbal2;
    }

    private String foutdt2;

    @javax.persistence.Column(name = "FOUTDT2")
    @Basic
    public String getFoutdt2() {
        return foutdt2;
    }

    public void setFoutdt2(String foutdt2) {
        this.foutdt2 = foutdt2;
    }

    private String fbegdt2;

    @javax.persistence.Column(name = "FBEGDT2")
    @Basic
    public String getFbegdt2() {
        return fbegdt2;
    }

    public void setFbegdt2(String fbegdt2) {
        this.fbegdt2 = fbegdt2;
    }

    private String fenddt2;

    @javax.persistence.Column(name = "FENDDT2")
    @Basic
    public String getFenddt2() {
        return fenddt2;
    }

    public void setFenddt2(String fenddt2) {
        this.fenddt2 = fenddt2;
    }

    private String fgacde2;

    @javax.persistence.Column(name = "FGACDE2")
    @Basic
    public String getFgacde2() {
        return fgacde2;
    }

    public void setFgacde2(String fgacde2) {
        this.fgacde2 = fgacde2;
    }

    private String fsercd2;

    @javax.persistence.Column(name = "FSERCD2")
    @Basic
    public String getFsercd2() {
        return fsercd2;
    }

    public void setFsercd2(String fsercd2) {
        this.fsercd2 = fsercd2;
    }

    private String fadlnf3;

    @javax.persistence.Column(name = "FADLNF3")
    @Basic
    public String getFadlnf3() {
        return fadlnf3;
    }

    public void setFadlnf3(String fadlnf3) {
        this.fadlnf3 = fadlnf3;
    }

    private String fpgmcd3;

    @javax.persistence.Column(name = "FPGMCD3")
    @Basic
    public String getFpgmcd3() {
        return fpgmcd3;
    }

    public void setFpgmcd3(String fpgmcd3) {
        this.fpgmcd3 = fpgmcd3;
    }

    private String fstcd3;

    @javax.persistence.Column(name = "FSTCD3")
    @Basic
    public String getFstcd3() {
        return fstcd3;
    }

    public void setFstcd3(String fstcd3) {
        this.fstcd3 = fstcd3;
    }

    private String fstdt3;

    @javax.persistence.Column(name = "FSTDT3")
    @Basic
    public String getFstdt3() {
        return fstdt3;
    }

    public void setFstdt3(String fstdt3) {
        this.fstdt3 = fstdt3;
    }

    private int flnamt3;

    @javax.persistence.Column(name = "FLNAMT3")
    @Basic
    public int getFlnamt3() {
        return flnamt3;
    }

    public void setFlnamt3(int flnamt3) {
        this.flnamt3 = flnamt3;
    }

    private int fotbal3;

    @javax.persistence.Column(name = "FOTBAL3")
    @Basic
    public int getFotbal3() {
        return fotbal3;
    }

    public void setFotbal3(int fotbal3) {
        this.fotbal3 = fotbal3;
    }

    private String foutdt3;

    @javax.persistence.Column(name = "FOUTDT3")
    @Basic
    public String getFoutdt3() {
        return foutdt3;
    }

    public void setFoutdt3(String foutdt3) {
        this.foutdt3 = foutdt3;
    }

    private String fbegdt3;

    @javax.persistence.Column(name = "FBEGDT3")
    @Basic
    public String getFbegdt3() {
        return fbegdt3;
    }

    public void setFbegdt3(String fbegdt3) {
        this.fbegdt3 = fbegdt3;
    }

    private String fenddt3;

    @javax.persistence.Column(name = "FENDDT3")
    @Basic
    public String getFenddt3() {
        return fenddt3;
    }

    public void setFenddt3(String fenddt3) {
        this.fenddt3 = fenddt3;
    }

    private String fgacde3;

    @javax.persistence.Column(name = "FGACDE3")
    @Basic
    public String getFgacde3() {
        return fgacde3;
    }

    public void setFgacde3(String fgacde3) {
        this.fgacde3 = fgacde3;
    }

    private String fsercd3;

    @javax.persistence.Column(name = "FSERCD3")
    @Basic
    public String getFsercd3() {
        return fsercd3;
    }

    public void setFsercd3(String fsercd3) {
        this.fsercd3 = fsercd3;
    }

    private int pkcmamt;

    @javax.persistence.Column(name = "PKCMAMT")
    @Basic
    public int getPkcmamt() {
        return pkcmamt;
    }

    public void setPkcmamt(int pkcmamt) {
        this.pkcmamt = pkcmamt;
    }

    private int pkcyamt;

    @javax.persistence.Column(name = "PKCYAMT")
    @Basic
    public int getPkcyamt() {
        return pkcyamt;
    }

    public void setPkcyamt(int pkcyamt) {
        this.pkcyamt = pkcyamt;
    }

    private String pkdsfg1;

    @javax.persistence.Column(name = "PKDSFG1")
    @Basic
    public String getPkdsfg1() {
        return pkdsfg1;
    }

    public void setPkdsfg1(String pkdsfg1) {
        this.pkdsfg1 = pkdsfg1;
    }

    private String pkdsfg2;

    @javax.persistence.Column(name = "PKDSFG2")
    @Basic
    public String getPkdsfg2() {
        return pkdsfg2;
    }

    public void setPkdsfg2(String pkdsfg2) {
        this.pkdsfg2 = pkdsfg2;
    }

    private String pkxlnfg;

    @javax.persistence.Column(name = "PKXLNFG")
    @Basic
    public String getPkxlnfg() {
        return pkxlnfg;
    }

    public void setPkxlnfg(String pkxlnfg) {
        this.pkxlnfg = pkxlnfg;
    }

    private String plovflg;

    @javax.persistence.Column(name = "PLOVFLG")
    @Basic
    public String getPlovflg() {
        return plovflg;
    }

    public void setPlovflg(String plovflg) {
        this.plovflg = plovflg;
    }

    private String sgovflg;

    @javax.persistence.Column(name = "SGOVFLG")
    @Basic
    public String getSgovflg() {
        return sgovflg;
    }

    public void setSgovflg(String sgovflg) {
        this.sgovflg = sgovflg;
    }

    private String pkdfflg;

    @javax.persistence.Column(name = "PKDFFLG")
    @Basic
    public String getPkdfflg() {
        return pkdfflg;
    }

    public void setPkdfflg(String pkdfflg) {
        this.pkdfflg = pkdfflg;
    }

    private String bankyfg;

    @javax.persistence.Column(name = "BANKYFG")
    @Basic
    public String getBankyfg() {
        return bankyfg;
    }

    public void setBankyfg(String bankyfg) {
        this.bankyfg = bankyfg;
    }

    private String lntpcd1;

    @javax.persistence.Column(name = "LNTPCD1")
    @Basic
    public String getLntpcd1() {
        return lntpcd1;
    }

    public void setLntpcd1(String lntpcd1) {
        this.lntpcd1 = lntpcd1;
    }

    private String lntpcd2;

    @javax.persistence.Column(name = "LNTPCD2")
    @Basic
    public String getLntpcd2() {
        return lntpcd2;
    }

    public void setLntpcd2(String lntpcd2) {
        this.lntpcd2 = lntpcd2;
    }

    private String lntpcd3;

    @javax.persistence.Column(name = "LNTPCD3")
    @Basic
    public String getLntpcd3() {
        return lntpcd3;
    }

    public void setLntpcd3(String lntpcd3) {
        this.lntpcd3 = lntpcd3;
    }

    private String lntpcd4;

    @javax.persistence.Column(name = "LNTPCD4")
    @Basic
    public String getLntpcd4() {
        return lntpcd4;
    }

    public void setLntpcd4(String lntpcd4) {
        this.lntpcd4 = lntpcd4;
    }

    private String lntpcd5;

    @javax.persistence.Column(name = "LNTPCD5")
    @Basic
    public String getLntpcd5() {
        return lntpcd5;
    }

    public void setLntpcd5(String lntpcd5) {
        this.lntpcd5 = lntpcd5;
    }

    private String lntpcd6;

    @javax.persistence.Column(name = "LNTPCD6")
    @Basic
    public String getLntpcd6() {
        return lntpcd6;
    }

    public void setLntpcd6(String lntpcd6) {
        this.lntpcd6 = lntpcd6;
    }

    private String lntpcd7;

    @javax.persistence.Column(name = "LNTPCD7")
    @Basic
    public String getLntpcd7() {
        return lntpcd7;
    }

    public void setLntpcd7(String lntpcd7) {
        this.lntpcd7 = lntpcd7;
    }

    private String lntpcd8;

    @javax.persistence.Column(name = "LNTPCD8")
    @Basic
    public String getLntpcd8() {
        return lntpcd8;
    }

    public void setLntpcd8(String lntpcd8) {
        this.lntpcd8 = lntpcd8;
    }

    private String lntpcd9;

    @javax.persistence.Column(name = "LNTPCD9")
    @Basic
    public String getLntpcd9() {
        return lntpcd9;
    }

    public void setLntpcd9(String lntpcd9) {
        this.lntpcd9 = lntpcd9;
    }

    private String lntpcd10;

    @javax.persistence.Column(name = "LNTPCD10")
    @Basic
    public String getLntpcd10() {
        return lntpcd10;
    }

    public void setLntpcd10(String lntpcd10) {
        this.lntpcd10 = lntpcd10;
    }

    private String lntpcd11;

    @javax.persistence.Column(name = "LNTPCD11")
    @Basic
    public String getLntpcd11() {
        return lntpcd11;
    }

    public void setLntpcd11(String lntpcd11) {
        this.lntpcd11 = lntpcd11;
    }

    private String lntpcd12;

    @javax.persistence.Column(name = "LNTPCD12")
    @Basic
    public String getLntpcd12() {
        return lntpcd12;
    }

    public void setLntpcd12(String lntpcd12) {
        this.lntpcd12 = lntpcd12;
    }

    private String lncncd7;

    @javax.persistence.Column(name = "LNCNCD7")
    @Basic
    public String getLncncd7() {
        return lncncd7;
    }

    public void setLncncd7(String lncncd7) {
        this.lncncd7 = lncncd7;
    }

    private String lncncd8;

    @javax.persistence.Column(name = "LNCNCD8")
    @Basic
    public String getLncncd8() {
        return lncncd8;
    }

    public void setLncncd8(String lncncd8) {
        this.lncncd8 = lncncd8;
    }

    private String lncncd9;

    @javax.persistence.Column(name = "LNCNCD9")
    @Basic
    public String getLncncd9() {
        return lncncd9;
    }

    public void setLncncd9(String lncncd9) {
        this.lncncd9 = lncncd9;
    }

    private String lncncd10;

    @javax.persistence.Column(name = "LNCNCD10")
    @Basic
    public String getLncncd10() {
        return lncncd10;
    }

    public void setLncncd10(String lncncd10) {
        this.lncncd10 = lncncd10;
    }

    private String lncncd11;

    @javax.persistence.Column(name = "LNCNCD11")
    @Basic
    public String getLncncd11() {
        return lncncd11;
    }

    public void setLncncd11(String lncncd11) {
        this.lncncd11 = lncncd11;
    }

    private String lncncd12;

    @javax.persistence.Column(name = "LNCNCD12")
    @Basic
    public String getLncncd12() {
        return lncncd12;
    }

    public void setLncncd12(String lncncd12) {
        this.lncncd12 = lncncd12;
    }

    private String fsresdc;

    @javax.persistence.Column(name = "FSRESDC")
    @Basic
    public String getFsresdc() {
        return fsresdc;
    }

    public void setFsresdc(String fsresdc) {
        this.fsresdc = fsresdc;
    }

    private String fsbrthc;

    @javax.persistence.Column(name = "FSBRTHC")
    @Basic
    public String getFsbrthc() {
        return fsbrthc;
    }

    public void setFsbrthc(String fsbrthc) {
        this.fsbrthc = fsbrthc;
    }

    private String fsmrtdc;

    @javax.persistence.Column(name = "FSMRTDC")
    @Basic
    public String getFsmrtdc() {
        return fsmrtdc;
    }

    public void setFsmrtdc(String fsmrtdc) {
        this.fsmrtdc = fsmrtdc;
    }

    private String fsxpgrc;

    @javax.persistence.Column(name = "FSXPGRC")
    @Basic
    public String getFsxpgrc() {
        return fsxpgrc;
    }

    public void setFsxpgrc(String fsxpgrc) {
        this.fsxpgrc = fsxpgrc;
    }

    private String fshsdtc;

    @javax.persistence.Column(name = "FSHSDTC")
    @Basic
    public String getFshsdtc() {
        return fshsdtc;
    }

    public void setFshsdtc(String fshsdtc) {
        this.fshsdtc = fshsdtc;
    }

    private String fsgedtc;

    @javax.persistence.Column(name = "FSGEDTC")
    @Basic
    public String getFsgedtc() {
        return fsgedtc;
    }

    public void setFsgedtc(String fsgedtc) {
        this.fsgedtc = fsgedtc;
    }

    private String fsdstsc;

    @javax.persistence.Column(name = "FSDSTSC")
    @Basic
    public String getFsdstsc() {
        return fsdstsc;
    }

    public void setFsdstsc(String fsdstsc) {
        this.fsdstsc = fsdstsc;
    }

    private String fsdstec;

    @javax.persistence.Column(name = "FSDSTEC")
    @Basic
    public String getFsdstec() {
        return fsdstec;
    }

    public void setFsdstec(String fsdstec) {
        this.fsdstec = fsdstec;
    }

    private String fsigdtc;

    @javax.persistence.Column(name = "FSIGDTC")
    @Basic
    public String getFsigdtc() {
        return fsigdtc;
    }

    public void setFsigdtc(String fsigdtc) {
        this.fsigdtc = fsigdtc;
    }

    private String frsigdc;

    @javax.persistence.Column(name = "FRSIGDC")
    @Basic
    public String getFrsigdc() {
        return frsigdc;
    }

    public void setFrsigdc(String frsigdc) {
        this.frsigdc = frsigdc;
    }

    private String fappdtc;

    @javax.persistence.Column(name = "FAPPDTC")
    @Basic
    public String getFappdtc() {
        return fappdtc;
    }

    public void setFappdtc(String fappdtc) {
        this.fappdtc = fappdtc;
    }

    private String fprcesc;

    @javax.persistence.Column(name = "FPRCESC")
    @Basic
    public String getFprcesc() {
        return fprcesc;
    }

    public void setFprcesc(String fprcesc) {
        this.fprcesc = fprcesc;
    }

    private String ftfdtec;

    @javax.persistence.Column(name = "FTFDTEC")
    @Basic
    public String getFtfdtec() {
        return ftfdtec;
    }

    public void setFtfdtec(String ftfdtec) {
        this.ftfdtec = ftfdtec;
    }

    private String frvwdtc;

    @javax.persistence.Column(name = "FRVWDTC")
    @Basic
    public String getFrvwdtc() {
        return frvwdtc;
    }

    public void setFrvwdtc(String frvwdtc) {
        this.frvwdtc = frvwdtc;
    }

    private String fprsdtc;

    @javax.persistence.Column(name = "FPRSDTC")
    @Basic
    public String getFprsdtc() {
        return fprsdtc;
    }

    public void setFprsdtc(String fprsdtc) {
        this.fprsdtc = fprsdtc;
    }

    private String ptfdtec;

    @javax.persistence.Column(name = "PTFDTEC")
    @Basic
    public String getPtfdtec() {
        return ptfdtec;
    }

    public void setPtfdtec(String ptfdtec) {
        this.ptfdtec = ptfdtec;
    }

    private String ptrvwdc;

    @javax.persistence.Column(name = "PTRVWDC")
    @Basic
    public String getPtrvwdc() {
        return ptrvwdc;
    }

    public void setPtrvwdc(String ptrvwdc) {
        this.ptrvwdc = ptrvwdc;
    }

    private String stfdtec;

    @javax.persistence.Column(name = "STFDTEC")
    @Basic
    public String getStfdtec() {
        return stfdtec;
    }

    public void setStfdtec(String stfdtec) {
        this.stfdtec = stfdtec;
    }

    private String strvwdc;

    @javax.persistence.Column(name = "STRVWDC")
    @Basic
    public String getStrvwdc() {
        return strvwdc;
    }

    public void setStrvwdc(String strvwdc) {
        this.strvwdc = strvwdc;
    }

    private String ntfdtec;

    @javax.persistence.Column(name = "NTFDTEC")
    @Basic
    public String getNtfdtec() {
        return ntfdtec;
    }

    public void setNtfdtec(String ntfdtec) {
        this.ntfdtec = ntfdtec;
    }

    private String ntrvwdc;

    @javax.persistence.Column(name = "NTRVWDC")
    @Basic
    public String getNtrvwdc() {
        return ntrvwdc;
    }

    public void setNtrvwdc(String ntrvwdc) {
        this.ntrvwdc = ntrvwdc;
    }

    private String vpfdtec;

    @javax.persistence.Column(name = "VPFDTEC")
    @Basic
    public String getVpfdtec() {
        return vpfdtec;
    }

    public void setVpfdtec(String vpfdtec) {
        this.vpfdtec = vpfdtec;
    }

    private String vsfdtec;

    @javax.persistence.Column(name = "VSFDTEC")
    @Basic
    public String getVsfdtec() {
        return vsfdtec;
    }

    public void setVsfdtec(String vsfdtec) {
        this.vsfdtec = vsfdtec;
    }

    private String vnfdtec;

    @javax.persistence.Column(name = "VNFDTEC")
    @Basic
    public String getVnfdtec() {
        return vnfdtec;
    }

    public void setVnfdtec(String vnfdtec) {
        this.vnfdtec = vnfdtec;
    }

    private String fsigdac;

    @javax.persistence.Column(name = "FSIGDAC")
    @Basic
    public String getFsigdac() {
        return fsigdac;
    }

    public void setFsigdac(String fsigdac) {
        this.fsigdac = fsigdac;
    }

    private int fsfarme;

    @javax.persistence.Column(name = "FSFARME")
    @Basic
    public int getFsfarme() {
        return fsfarme;
    }

    public void setFsfarme(int fsfarme) {
        this.fsfarme = fsfarme;
    }

    private int fsbfe;

    @javax.persistence.Column(name = "FSBFE")
    @Basic
    public int getFsbfe() {
        return fsbfe;
    }

    public void setFsbfe(int fsbfe) {
        this.fsbfe = fsbfe;
    }

    private int fpfarme;

    @javax.persistence.Column(name = "FPFARME")
    @Basic
    public int getFpfarme() {
        return fpfarme;
    }

    public void setFpfarme(int fpfarme) {
        this.fpfarme = fpfarme;
    }

    private int fpbfe;

    @javax.persistence.Column(name = "FPBFE")
    @Basic
    public int getFpbfe() {
        return fpbfe;
    }

    public void setFpbfe(int fpbfe) {
        this.fpbfe = fpbfe;
    }

    private String fadmflg;

    @javax.persistence.Column(name = "FADMFLG")
    @Basic
    public String getFadmflg() {
        return fadmflg;
    }

    public void setFadmflg(String fadmflg) {
        this.fadmflg = fadmflg;
    }

    private String frevisc;

    @javax.persistence.Column(name = "FREVISC")
    @Basic
    public String getFrevisc() {
        return frevisc;
    }

    public void setFrevisc(String frevisc) {
        this.frevisc = frevisc;
    }

    private String fnamefl;

    @javax.persistence.Column(name = "FNAMEFL")
    @Basic
    public String getFnamefl() {
        return fnamefl;
    }

    public void setFnamefl(String fnamefl) {
        this.fnamefl = fnamefl;
    }

    private String fssnfat;

    @javax.persistence.Column(name = "FSSNFAT")
    @Basic
    public String getFssnfat() {
        return fssnfat;
    }

    public void setFssnfat(String fssnfat) {
        this.fssnfat = fssnfat;
    }

    private String fnameml;

    @javax.persistence.Column(name = "FNAMEML")
    @Basic
    public String getFnameml() {
        return fnameml;
    }

    public void setFnameml(String fnameml) {
        this.fnameml = fnameml;
    }

    private String fssnmot;

    @javax.persistence.Column(name = "FSSNMOT")
    @Basic
    public String getFssnmot() {
        return fssnmot;
    }

    public void setFssnmot(String fssnmot) {
        this.fssnmot = fssnmot;
    }

    private String fprimth;

    @javax.persistence.Column(name = "FPRIMTH")
    @Basic
    public String getFprimth() {
        return fprimth;
    }

    public void setFprimth(String fprimth) {
        this.fprimth = fprimth;
    }

    private String finrctp;

    @javax.persistence.Column(name = "FINRCTP")
    @Basic
    public String getFinrctp() {
        return finrctp;
    }

    public void setFinrctp(String finrctp) {
        this.finrctp = finrctp;
    }

    private int fpawat1;

    @javax.persistence.Column(name = "FPAWAT1")
    @Basic
    public int getFpawat1() {
        return fpawat1;
    }

    public void setFpawat1(int fpawat1) {
        this.fpawat1 = fpawat1;
    }

    private int fpawat2;

    @javax.persistence.Column(name = "FPAWAT2")
    @Basic
    public int getFpawat2() {
        return fpawat2;
    }

    public void setFpawat2(int fpawat2) {
        this.fpawat2 = fpawat2;
    }

    private int fpawat3;

    @javax.persistence.Column(name = "FPAWAT3")
    @Basic
    public int getFpawat3() {
        return fpawat3;
    }

    public void setFpawat3(int fpawat3) {
        this.fpawat3 = fpawat3;
    }

    private String fpsread;

    @javax.persistence.Column(name = "FPSREAD")
    @Basic
    public String getFpsread() {
        return fpsread;
    }

    public void setFpsread(String fpsread) {
        this.fpsread = fpsread;
    }

    private String fdrugcn;

    @javax.persistence.Column(name = "FDRUGCN")
    @Basic
    public String getFdrugcn() {
        return fdrugcn;
    }

    public void setFdrugcn(String fdrugcn) {
        this.fdrugcn = fdrugcn;
    }

    private String fhlcnse;

    @javax.persistence.Column(name = "FHLCNSE")
    @Basic
    public String getFhlcnse() {
        return fhlcnse;
    }

    public void setFhlcnse(String fhlcnse) {
        this.fhlcnse = fhlcnse;
    }

    private String fsresbfr;

    @javax.persistence.Column(name = "FSRESBFR")
    @Basic
    public String getFsresbfr() {
        return fsresbfr;
    }

    public void setFsresbfr(String fsresbfr) {
        this.fsresbfr = fsresbfr;
    }

    private String fsmale;

    @javax.persistence.Column(name = "FSMALE")
    @Basic
    public String getFsmale() {
        return fsmale;
    }

    public void setFsmale(String fsmale) {
        this.fsmale = fsmale;
    }

    private String fsfilrtn;

    @javax.persistence.Column(name = "FSFILRTN")
    @Basic
    public String getFsfilrtn() {
        return fsfilrtn;
    }

    public void setFsfilrtn(String fsfilrtn) {
        this.fsfilrtn = fsfilrtn;
    }

    private String fselgfil;

    @javax.persistence.Column(name = "FSELGFIL")
    @Basic
    public String getFselgfil() {
        return fselgfil;
    }

    public void setFselgfil(String fselgfil) {
        this.fselgfil = fselgfil;
    }

    private String fsasvast;

    @javax.persistence.Column(name = "FSASVAST")
    @Basic
    public String getFsasvast() {
        return fsasvast;
    }

    public void setFsasvast(String fsasvast) {
        this.fsasvast = fsasvast;
    }

    private String fpfilrtn;

    @javax.persistence.Column(name = "FPFILRTN")
    @Basic
    public String getFpfilrtn() {
        return fpfilrtn;
    }

    public void setFpfilrtn(String fpfilrtn) {
        this.fpfilrtn = fpfilrtn;
    }

    private String fpelgfil;

    @javax.persistence.Column(name = "FPELGFIL")
    @Basic
    public String getFpelgfil() {
        return fpelgfil;
    }

    public void setFpelgfil(String fpelgfil) {
        this.fpelgfil = fpelgfil;
    }

    private String fpresbfr;

    @javax.persistence.Column(name = "FPRESBFR")
    @Basic
    public String getFpresbfr() {
        return fpresbfr;
    }

    public void setFpresbfr(String fpresbfr) {
        this.fpresbfr = fpresbfr;
    }

    private String fappsrcd;

    @javax.persistence.Column(name = "FAPPSRCD")
    @Basic
    public String getFappsrcd() {
        return fappsrcd;
    }

    public void setFappsrcd(String fappsrcd) {
        this.fappsrcd = fappsrcd;
    }

    private String fappnum;

    @javax.persistence.Column(name = "FAPPNUM")
    @Basic
    public String getFappnum() {
        return fappnum;
    }

    public void setFappnum(String fappnum) {
        this.fappnum = fappnum;
    }

    private String fetidcd;

    @javax.persistence.Column(name = "FETIDCD")
    @Basic
    public String getFetidcd() {
        return fetidcd;
    }

    public void setFetidcd(String fetidcd) {
        this.fetidcd = fetidcd;
    }

    private String frectyp;

    @javax.persistence.Column(name = "FRECTYP")
    @Basic
    public String getFrectyp() {
        return frectyp;
    }

    public void setFrectyp(String frectyp) {
        this.frectyp = frectyp;
    }

    private String fsntest;

    @javax.persistence.Column(name = "FSNTEST")
    @Basic
    public String getFsntest() {
        return fsntest;
    }

    public void setFsntest(String fsntest) {
        this.fsntest = fsntest;
    }

    private String fdeaddtc;

    @javax.persistence.Column(name = "FDEADDTC")
    @Basic
    public String getFdeaddtc() {
        return fdeaddtc;
    }

    public void setFdeaddtc(String fdeaddtc) {
        this.fdeaddtc = fdeaddtc;
    }

    private String fvamchfg;

    @javax.persistence.Column(name = "FVAMCHFG")
    @Basic
    public String getFvamchfg() {
        return fvamchfg;
    }

    public void setFvamchfg(String fvamchfg) {
        this.fvamchfg = fvamchfg;
    }

    private int fcmpnum;

    @javax.persistence.Column(name = "FCMPNUM")
    @Basic
    public int getFcmpnum() {
        return fcmpnum;
    }

    public void setFcmpnum(int fcmpnum) {
        this.fcmpnum = fcmpnum;
    }

    private int fpdefc;

    @javax.persistence.Column(name = "FPDEFC")
    @Basic
    public int getFpdefc() {
        return fpdefc;
    }

    public void setFpdefc(int fpdefc) {
        this.fpdefc = fpdefc;
    }

    private String fefctpsc;

    @javax.persistence.Column(name = "FEFCTPSC")
    @Basic
    public String getFefctpsc() {
        return fefctpsc;
    }

    public void setFefctpsc(String fefctpsc) {
        this.fefctpsc = fefctpsc;
    }

    private int fefcntwr;

    @javax.persistence.Column(name = "FEFCNTWR")
    @Basic
    public int getFefcntwr() {
        return fefcntwr;
    }

    public void setFefcntwr(int fefcntwr) {
        this.fefcntwr = fefcntwr;
    }

    private int fsawtoti;

    @javax.persistence.Column(name = "FSAWTOTI")
    @Basic
    public int getFsawtoti() {
        return fsawtoti;
    }

    public void setFsawtoti(int fsawtoti) {
        this.fsawtoti = fsawtoti;
    }

    private int fsnetwth;

    @javax.persistence.Column(name = "FSNETWTH")
    @Basic
    public int getFsnetwth() {
        return fsnetwth;
    }

    public void setFsnetwth(int fsnetwth) {
        this.fsnetwth = fsnetwth;
    }

    private String fdupdtc;

    @javax.persistence.Column(name = "FDUPDTC")
    @Basic
    public String getFdupdtc() {
        return fdupdtc;
    }

    public void setFdupdtc(String fdupdtc) {
        this.fdupdtc = fdupdtc;
    }

    private String povcnt;

    @javax.persistence.Column(name = "POVCNT")
    @Basic
    public String getPovcnt() {
        return povcnt;
    }

    public void setPovcnt(String povcnt) {
        this.povcnt = povcnt;
    }

    private String sovcnt;

    @javax.persistence.Column(name = "SOVCNT")
    @Basic
    public String getSovcnt() {
        return sovcnt;
    }

    public void setSovcnt(String sovcnt) {
        this.sovcnt = sovcnt;
    }

    private String pkovcnt;

    @javax.persistence.Column(name = "PKOVCNT")
    @Basic
    public String getPkovcnt() {
        return pkovcnt;
    }

    public void setPkovcnt(String pkovcnt) {
        this.pkovcnt = pkovcnt;
    }

    private String dlnflg;

    @javax.persistence.Column(name = "DLNFLG")
    @Basic
    public String getDlnflg() {
        return dlnflg;
    }

    public void setDlnflg(String dlnflg) {
        this.dlnflg = dlnflg;
    }

    private String dglnfg;

    @javax.persistence.Column(name = "DGLNFG")
    @Basic
    public String getDglnfg() {
        return dglnfg;
    }

    public void setDglnfg(String dglnfg) {
        this.dglnfg = dglnfg;
    }

    private String lnsatrp;

    @javax.persistence.Column(name = "LNSATRP")
    @Basic
    public String getLnsatrp() {
        return lnsatrp;
    }

    public void setLnsatrp(String lnsatrp) {
        this.lnsatrp = lnsatrp;
    }

    private String fverinbx;

    @javax.persistence.Column(name = "FVERINBX")
    @Basic
    public String getFverinbx() {
        return fverinbx;
    }

    public void setFverinbx(String fverinbx) {
        this.fverinbx = fverinbx;
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

    private int fs2Onti;

    @javax.persistence.Column(name = "FS2ONTI")
    @Basic
    public int getFs2Onti() {
        return fs2Onti;
    }

    public void setFs2Onti(int fs2Onti) {
        this.fs2Onti = fs2Onti;
    }

    private int fp2Onti;

    @javax.persistence.Column(name = "FP2ONTI")
    @Basic
    public int getFp2Onti() {
        return fp2Onti;
    }

    public void setFp2Onti(int fp2Onti) {
        this.fp2Onti = fp2Onti;
    }

    private String fdepchd;

    @javax.persistence.Column(name = "FDEPCHD")
    @Basic
    public String getFdepchd() {
        return fdepchd;
    }

    public void setFdepchd(String fdepchd) {
        this.fdepchd = fdepchd;
    }

    private String sttfsgn;

    @javax.persistence.Column(name = "STTFSGN")
    @Basic
    public String getSttfsgn() {
        return sttfsgn;
    }

    public void setSttfsgn(String sttfsgn) {
        this.sttfsgn = sttfsgn;
    }

    private String pttfsgn;

    @javax.persistence.Column(name = "PTTFSGN")
    @Basic
    public String getPttfsgn() {
        return pttfsgn;
    }

    public void setPttfsgn(String pttfsgn) {
        this.pttfsgn = pttfsgn;
    }

    private String nttfsgn;

    @javax.persistence.Column(name = "NTTFSGN")
    @Basic
    public String getNttfsgn() {
        return nttfsgn;
    }

    public void setNttfsgn(String nttfsgn) {
        this.nttfsgn = nttfsgn;
    }

    private int tsctc;

    @javax.persistence.Column(name = "TSCTC")
    @Basic
    public int getTsctc() {
        return tsctc;
    }

    public void setTsctc(int tsctc) {
        this.tsctc = tsctc;
    }

    private int tpctc;

    @javax.persistence.Column(name = "TPCTC")
    @Basic
    public int getTpctc() {
        return tpctc;
    }

    public void setTpctc(int tpctc) {
        this.tpctc = tpctc;
    }

    private int tnctc;

    @javax.persistence.Column(name = "TNCTC")
    @Basic
    public int getTnctc() {
        return tnctc;
    }

    public void setTnctc(int tnctc) {
        this.tnctc = tnctc;
    }

    private int tsedcr;

    @javax.persistence.Column(name = "TSEDCR")
    @Basic
    public int getTsedcr() {
        return tsedcr;
    }

    public void setTsedcr(int tsedcr) {
        this.tsedcr = tsedcr;
    }

    private int tpedcr;

    @javax.persistence.Column(name = "TPEDCR")
    @Basic
    public int getTpedcr() {
        return tpedcr;
    }

    public void setTpedcr(int tpedcr) {
        this.tpedcr = tpedcr;
    }

    private int tnedcr;

    @javax.persistence.Column(name = "TNEDCR")
    @Basic
    public int getTnedcr() {
        return tnedcr;
    }

    public void setTnedcr(int tnedcr) {
        this.tnedcr = tnedcr;
    }

    private int tscse;

    @javax.persistence.Column(name = "TSCSE")
    @Basic
    public int getTscse() {
        return tscse;
    }

    public void setTscse(int tscse) {
        this.tscse = tscse;
    }

    private int tpcse;

    @javax.persistence.Column(name = "TPCSE")
    @Basic
    public int getTpcse() {
        return tpcse;
    }

    public void setTpcse(int tpcse) {
        this.tpcse = tpcse;
    }

    private int tncse;

    @javax.persistence.Column(name = "TNCSE")
    @Basic
    public int getTncse() {
        return tncse;
    }

    public void setTncse(int tncse) {
        this.tncse = tncse;
    }

    private int tsivre;

    @javax.persistence.Column(name = "TSIVRE")
    @Basic
    public int getTsivre() {
        return tsivre;
    }

    public void setTsivre(int tsivre) {
        this.tsivre = tsivre;
    }

    private int tpivre;

    @javax.persistence.Column(name = "TPIVRE")
    @Basic
    public int getTpivre() {
        return tpivre;
    }

    public void setTpivre(int tpivre) {
        this.tpivre = tpivre;
    }

    private int tnivre;

    @javax.persistence.Column(name = "TNIVRE")
    @Basic
    public int getTnivre() {
        return tnivre;
    }

    public void setTnivre(int tnivre) {
        this.tnivre = tnivre;
    }

    private int tsbsfm;

    @javax.persistence.Column(name = "TSBSFM")
    @Basic
    public int getTsbsfm() {
        return tsbsfm;
    }

    public void setTsbsfm(int tsbsfm) {
        this.tsbsfm = tsbsfm;
    }

    private int tpbsfm;

    @javax.persistence.Column(name = "TPBSFM")
    @Basic
    public int getTpbsfm() {
        return tpbsfm;
    }

    public void setTpbsfm(int tpbsfm) {
        this.tpbsfm = tpbsfm;
    }

    private int tnbsfm;

    @javax.persistence.Column(name = "TNBSFM")
    @Basic
    public int getTnbsfm() {
        return tnbsfm;
    }

    public void setTnbsfm(int tnbsfm) {
        this.tnbsfm = tnbsfm;
    }

    private String vsouit1;

    @javax.persistence.Column(name = "VSOUIT1")
    @Basic
    public String getVsouit1() {
        return vsouit1;
    }

    public void setVsouit1(String vsouit1) {
        this.vsouit1 = vsouit1;
    }

    private int vsouia1;

    @javax.persistence.Column(name = "VSOUIA1")
    @Basic
    public int getVsouia1() {
        return vsouia1;
    }

    public void setVsouia1(int vsouia1) {
        this.vsouia1 = vsouia1;
    }

    private String vsouit2;

    @javax.persistence.Column(name = "VSOUIT2")
    @Basic
    public String getVsouit2() {
        return vsouit2;
    }

    public void setVsouit2(String vsouit2) {
        this.vsouit2 = vsouit2;
    }

    private int vsouia2;

    @javax.persistence.Column(name = "VSOUIA2")
    @Basic
    public int getVsouia2() {
        return vsouia2;
    }

    public void setVsouia2(int vsouia2) {
        this.vsouia2 = vsouia2;
    }

    private String vsouit3;

    @javax.persistence.Column(name = "VSOUIT3")
    @Basic
    public String getVsouit3() {
        return vsouit3;
    }

    public void setVsouit3(String vsouit3) {
        this.vsouit3 = vsouit3;
    }

    private int vsouia3;

    @javax.persistence.Column(name = "VSOUIA3")
    @Basic
    public int getVsouia3() {
        return vsouia3;
    }

    public void setVsouia3(int vsouia3) {
        this.vsouia3 = vsouia3;
    }

    private String vpouit1;

    @javax.persistence.Column(name = "VPOUIT1")
    @Basic
    public String getVpouit1() {
        return vpouit1;
    }

    public void setVpouit1(String vpouit1) {
        this.vpouit1 = vpouit1;
    }

    private int vpouia1;

    @javax.persistence.Column(name = "VPOUIA1")
    @Basic
    public int getVpouia1() {
        return vpouia1;
    }

    public void setVpouia1(int vpouia1) {
        this.vpouia1 = vpouia1;
    }

    private String vpouit2;

    @javax.persistence.Column(name = "VPOUIT2")
    @Basic
    public String getVpouit2() {
        return vpouit2;
    }

    public void setVpouit2(String vpouit2) {
        this.vpouit2 = vpouit2;
    }

    private int vpouia2;

    @javax.persistence.Column(name = "VPOUIA2")
    @Basic
    public int getVpouia2() {
        return vpouia2;
    }

    public void setVpouia2(int vpouia2) {
        this.vpouia2 = vpouia2;
    }

    private String vpouit3;

    @javax.persistence.Column(name = "VPOUIT3")
    @Basic
    public String getVpouit3() {
        return vpouit3;
    }

    public void setVpouit3(String vpouit3) {
        this.vpouit3 = vpouit3;
    }

    private int vpouia3;

    @javax.persistence.Column(name = "VPOUIA3")
    @Basic
    public int getVpouia3() {
        return vpouia3;
    }

    public void setVpouia3(int vpouia3) {
        this.vpouia3 = vpouia3;
    }

    private String vnouit1;

    @javax.persistence.Column(name = "VNOUIT1")
    @Basic
    public String getVnouit1() {
        return vnouit1;
    }

    public void setVnouit1(String vnouit1) {
        this.vnouit1 = vnouit1;
    }

    private int vnouia1;

    @javax.persistence.Column(name = "VNOUIA1")
    @Basic
    public int getVnouia1() {
        return vnouia1;
    }

    public void setVnouia1(int vnouia1) {
        this.vnouia1 = vnouia1;
    }

    private String vnouit2;

    @javax.persistence.Column(name = "VNOUIT2")
    @Basic
    public String getVnouit2() {
        return vnouit2;
    }

    public void setVnouit2(String vnouit2) {
        this.vnouit2 = vnouit2;
    }

    private int vnouia2;

    @javax.persistence.Column(name = "VNOUIA2")
    @Basic
    public int getVnouia2() {
        return vnouia2;
    }

    public void setVnouia2(int vnouia2) {
        this.vnouia2 = vnouia2;
    }

    private String vnouit3;

    @javax.persistence.Column(name = "VNOUIT3")
    @Basic
    public String getVnouit3() {
        return vnouit3;
    }

    public void setVnouit3(String vnouit3) {
        this.vnouit3 = vnouit3;
    }

    private int vnouia3;

    @javax.persistence.Column(name = "VNOUIA3")
    @Basic
    public int getVnouia3() {
        return vnouia3;
    }

    public void setVnouia3(int vnouia3) {
        this.vnouia3 = vnouia3;
    }

    private String fpmrtdc;

    @javax.persistence.Column(name = "FPMRTDC")
    @Basic
    public String getFpmrtdc() {
        return fpmrtdc;
    }

    public void setFpmrtdc(String fpmrtdc) {
        this.fpmrtdc = fpmrtdc;
    }

    private String fpsredn;

    @javax.persistence.Column(name = "FPSREDN")
    @Basic
    public String getFpsredn() {
        return fpsredn;
    }

    public void setFpsredn(String fpsredn) {
        this.fpsredn = fpsredn;
    }

    private String femadtp;

    @javax.persistence.Column(name = "FEMADTP")
    @Basic
    public String getFemadtp() {
        return femadtp;
    }

    public void setFemadtp(String femadtp) {
        this.femadtp = femadtp;
    }

    private String fnameff;

    @javax.persistence.Column(name = "FNAMEFF")
    @Basic
    public String getFnameff() {
        return fnameff;
    }

    public void setFnameff(String fnameff) {
        this.fnameff = fnameff;
    }

    private String fnamemf;

    @javax.persistence.Column(name = "FNAMEMF")
    @Basic
    public String getFnamemf() {
        return fnamemf;
    }

    public void setFnamemf(String fnamemf) {
        this.fnamemf = fnamemf;
    }

    private String ffatdob;

    @javax.persistence.Column(name = "FFATDOB")
    @Basic
    public String getFfatdob() {
        return ffatdob;
    }

    public void setFfatdob(String ffatdob) {
        this.ffatdob = ffatdob;
    }

    private String fmotdob;

    @javax.persistence.Column(name = "FMOTDOB")
    @Basic
    public String getFmotdob() {
        return fmotdob;
    }

    public void setFmotdob(String fmotdob) {
        this.fmotdob = fmotdob;
    }

    private String factive;

    @javax.persistence.Column(name = "FACTIVE")
    @Basic
    public String getFactive() {
        return factive;
    }

    public void setFactive(String factive) {
        this.factive = factive;
    }

    private String fswic;

    @javax.persistence.Column(name = "FSWIC")
    @Basic
    public String getFswic() {
        return fswic;
    }

    public void setFswic(String fswic) {
        this.fswic = fswic;
    }

    private String fstanf;

    @javax.persistence.Column(name = "FSTANF")
    @Basic
    public String getFstanf() {
        return fstanf;
    }

    public void setFstanf(String fstanf) {
        this.fstanf = fstanf;
    }

    private String fsflb;

    @javax.persistence.Column(name = "FSFLB")
    @Basic
    public String getFsflb() {
        return fsflb;
    }

    public void setFsflb(String fsflb) {
        this.fsflb = fsflb;
    }

    private String fsfsb;

    @javax.persistence.Column(name = "FSFSB")
    @Basic
    public String getFsfsb() {
        return fsfsb;
    }

    public void setFsfsb(String fsfsb) {
        this.fsfsb = fsfsb;
    }

    private String fsssib;

    @javax.persistence.Column(name = "FSSSIB")
    @Basic
    public String getFsssib() {
        return fsssib;
    }

    public void setFsssib(String fsssib) {
        this.fsssib = fsssib;
    }

    private String fpwic;

    @javax.persistence.Column(name = "FPWIC")
    @Basic
    public String getFpwic() {
        return fpwic;
    }

    public void setFpwic(String fpwic) {
        this.fpwic = fpwic;
    }

    private String fptanf;

    @javax.persistence.Column(name = "FPTANF")
    @Basic
    public String getFptanf() {
        return fptanf;
    }

    public void setFptanf(String fptanf) {
        this.fptanf = fptanf;
    }

    private String fpflb;

    @javax.persistence.Column(name = "FPFLB")
    @Basic
    public String getFpflb() {
        return fpflb;
    }

    public void setFpflb(String fpflb) {
        this.fpflb = fpflb;
    }

    private String fpfsb;

    @javax.persistence.Column(name = "FPFSB")
    @Basic
    public String getFpfsb() {
        return fpfsb;
    }

    public void setFpfsb(String fpfsb) {
        this.fpfsb = fpfsb;
    }

    private String fpssib;

    @javax.persistence.Column(name = "FPSSIB")
    @Basic
    public String getFpssib() {
        return fpssib;
    }

    public void setFpssib(String fpssib) {
        this.fpssib = fpssib;
    }

    private String gpmpnfg;

    @javax.persistence.Column(name = "GPMPNFG")
    @Basic
    public String getGpmpnfg() {
        return gpmpnfg;
    }

    public void setGpmpnfg(String gpmpnfg) {
        this.gpmpnfg = gpmpnfg;
    }

    private String staddfg;

    @javax.persistence.Column(name = "STADDFG")
    @Basic
    public String getStaddfg() {
        return staddfg;
    }

    public void setStaddfg(String staddfg) {
        this.staddfg = staddfg;
    }

    private String agaddfg;

    @javax.persistence.Column(name = "AGADDFG")
    @Basic
    public String getAgaddfg() {
        return agaddfg;
    }

    public void setAgaddfg(String agaddfg) {
        this.agaddfg = agaddfg;
    }

    private String stchgfg;

    @javax.persistence.Column(name = "STCHGFG")
    @Basic
    public String getStchgfg() {
        return stchgfg;
    }

    public void setStchgfg(String stchgfg) {
        this.stchgfg = stchgfg;
    }

    private String agchgfg;

    @javax.persistence.Column(name = "AGCHGFG")
    @Basic
    public String getAgchgfg() {
        return agchgfg;
    }

    public void setAgchgfg(String agchgfg) {
        this.agchgfg = agchgfg;
    }

    private String stovcnt;

    @javax.persistence.Column(name = "STOVCNT")
    @Basic
    public String getStovcnt() {
        return stovcnt;
    }

    public void setStovcnt(String stovcnt) {
        this.stovcnt = stovcnt;
    }

    private String agovcnt;

    @javax.persistence.Column(name = "AGOVCNT")
    @Basic
    public String getAgovcnt() {
        return agovcnt;
    }

    public void setAgovcnt(String agovcnt) {
        this.agovcnt = agovcnt;
    }

    private String agovflg;

    @javax.persistence.Column(name = "AGOVFLG")
    @Basic
    public String getAgovflg() {
        return agovflg;
    }

    public void setAgovflg(String agovflg) {
        this.agovflg = agovflg;
    }

    private String stovflg;

    @javax.persistence.Column(name = "STOVFLG")
    @Basic
    public String getStovflg() {
        return stovflg;
    }

    public void setStovflg(String stovflg) {
        this.stovflg = stovflg;
    }

    private int tsfsb;

    @javax.persistence.Column(name = "TSFSB")
    @Basic
    public int getTsfsb() {
        return tsfsb;
    }

    public void setTsfsb(int tsfsb) {
        this.tsfsb = tsfsb;
    }

    private int tssib;

    @javax.persistence.Column(name = "TSSIB")
    @Basic
    public int getTssib() {
        return tssib;
    }

    public void setTssib(int tssib) {
        this.tssib = tssib;
    }

    private int tpwic;

    @javax.persistence.Column(name = "TPWIC")
    @Basic
    public int getTpwic() {
        return tpwic;
    }

    public void setTpwic(int tpwic) {
        this.tpwic = tpwic;
    }

    private int tptanf;

    @javax.persistence.Column(name = "TPTANF")
    @Basic
    public int getTptanf() {
        return tptanf;
    }

    public void setTptanf(int tptanf) {
        this.tptanf = tptanf;
    }

    private int tpfsb;

    @javax.persistence.Column(name = "TPFSB")
    @Basic
    public int getTpfsb() {
        return tpfsb;
    }

    public void setTpfsb(int tpfsb) {
        this.tpfsb = tpfsb;
    }

    private int tpssib;

    @javax.persistence.Column(name = "TPSSIB")
    @Basic
    public int getTpssib() {
        return tpssib;
    }

    public void setTpssib(int tpssib) {
        this.tpssib = tpssib;
    }

    private int tswic;

    @javax.persistence.Column(name = "TSWIC")
    @Basic
    public int getTswic() {
        return tswic;
    }

    public void setTswic(int tswic) {
        this.tswic = tswic;
    }

    private int tstanf;

    @javax.persistence.Column(name = "TSTANF")
    @Basic
    public int getTstanf() {
        return tstanf;
    }

    public void setTstanf(int tstanf) {
        this.tstanf = tstanf;
    }

    private String fhlght2;

    @javax.persistence.Column(name = "FHLGHT2")
    @Basic
    public String getFhlght2() {
        return fhlght2;
    }

    public void setFhlght2(String fhlght2) {
        this.fhlght2 = fhlght2;
    }

    private String filst;

    @javax.persistence.Column(name = "FILST")
    @Basic
    public String getFilst() {
        return filst;
    }

    public void setFilst(String filst) {
        this.filst = filst;
    }

    private BigInteger famage1;

    @javax.persistence.Column(name = "FAMAGE1")
    @Basic
    public BigInteger getFamage1() {
        return famage1;
    }

    public void setFamage1(BigInteger famage1) {
        this.famage1 = famage1;
    }

    private BigInteger famage2;

    @javax.persistence.Column(name = "FAMAGE2")
    @Basic
    public BigInteger getFamage2() {
        return famage2;
    }

    public void setFamage2(BigInteger famage2) {
        this.famage2 = famage2;
    }

    private BigInteger famage3;

    @javax.persistence.Column(name = "FAMAGE3")
    @Basic
    public BigInteger getFamage3() {
        return famage3;
    }

    public void setFamage3(BigInteger famage3) {
        this.famage3 = famage3;
    }

    private BigInteger famage4;

    @javax.persistence.Column(name = "FAMAGE4")
    @Basic
    public BigInteger getFamage4() {
        return famage4;
    }

    public void setFamage4(BigInteger famage4) {
        this.famage4 = famage4;
    }

    private BigInteger famage5;

    @javax.persistence.Column(name = "FAMAGE5")
    @Basic
    public BigInteger getFamage5() {
        return famage5;
    }

    public void setFamage5(BigInteger famage5) {
        this.famage5 = famage5;
    }

    private BigInteger famage6;

    @javax.persistence.Column(name = "FAMAGE6")
    @Basic
    public BigInteger getFamage6() {
        return famage6;
    }

    public void setFamage6(BigInteger famage6) {
        this.famage6 = famage6;
    }

    private BigInteger famage7;

    @javax.persistence.Column(name = "FAMAGE7")
    @Basic
    public BigInteger getFamage7() {
        return famage7;
    }

    public void setFamage7(BigInteger famage7) {
        this.famage7 = famage7;
    }

    private String famrel1;

    @javax.persistence.Column(name = "FAMREL1")
    @Basic
    public String getFamrel1() {
        return famrel1;
    }

    public void setFamrel1(String famrel1) {
        this.famrel1 = famrel1;
    }

    private String famrel2;

    @javax.persistence.Column(name = "FAMREL2")
    @Basic
    public String getFamrel2() {
        return famrel2;
    }

    public void setFamrel2(String famrel2) {
        this.famrel2 = famrel2;
    }

    private String famrel3;

    @javax.persistence.Column(name = "FAMREL3")
    @Basic
    public String getFamrel3() {
        return famrel3;
    }

    public void setFamrel3(String famrel3) {
        this.famrel3 = famrel3;
    }

    private String famrel4;

    @javax.persistence.Column(name = "FAMREL4")
    @Basic
    public String getFamrel4() {
        return famrel4;
    }

    public void setFamrel4(String famrel4) {
        this.famrel4 = famrel4;
    }

    private String famrel5;

    @javax.persistence.Column(name = "FAMREL5")
    @Basic
    public String getFamrel5() {
        return famrel5;
    }

    public void setFamrel5(String famrel5) {
        this.famrel5 = famrel5;
    }

    private String famrel6;

    @javax.persistence.Column(name = "FAMREL6")
    @Basic
    public String getFamrel6() {
        return famrel6;
    }

    public void setFamrel6(String famrel6) {
        this.famrel6 = famrel6;
    }

    private String famrel7;

    @javax.persistence.Column(name = "FAMREL7")
    @Basic
    public String getFamrel7() {
        return famrel7;
    }

    public void setFamrel7(String famrel7) {
        this.famrel7 = famrel7;
    }

    private String famcol1;

    @javax.persistence.Column(name = "FAMCOL1")
    @Basic
    public String getFamcol1() {
        return famcol1;
    }

    public void setFamcol1(String famcol1) {
        this.famcol1 = famcol1;
    }

    private String famcol2;

    @javax.persistence.Column(name = "FAMCOL2")
    @Basic
    public String getFamcol2() {
        return famcol2;
    }

    public void setFamcol2(String famcol2) {
        this.famcol2 = famcol2;
    }

    private String famcol3;

    @javax.persistence.Column(name = "FAMCOL3")
    @Basic
    public String getFamcol3() {
        return famcol3;
    }

    public void setFamcol3(String famcol3) {
        this.famcol3 = famcol3;
    }

    private String famcol4;

    @javax.persistence.Column(name = "FAMCOL4")
    @Basic
    public String getFamcol4() {
        return famcol4;
    }

    public void setFamcol4(String famcol4) {
        this.famcol4 = famcol4;
    }

    private String famcol5;

    @javax.persistence.Column(name = "FAMCOL5")
    @Basic
    public String getFamcol5() {
        return famcol5;
    }

    public void setFamcol5(String famcol5) {
        this.famcol5 = famcol5;
    }

    private String famcol6;

    @javax.persistence.Column(name = "FAMCOL6")
    @Basic
    public String getFamcol6() {
        return famcol6;
    }

    public void setFamcol6(String famcol6) {
        this.famcol6 = famcol6;
    }

    private String famcol7;

    @javax.persistence.Column(name = "FAMCOL7")
    @Basic
    public String getFamcol7() {
        return famcol7;
    }

    public void setFamcol7(String famcol7) {
        this.famcol7 = famcol7;
    }

    private BigInteger addfmly;

    @javax.persistence.Column(name = "ADDFMLY")
    @Basic
    public BigInteger getAddfmly() {
        return addfmly;
    }

    public void setAddfmly(BigInteger addfmly) {
        this.addfmly = addfmly;
    }

    private BigInteger addfamc;

    @javax.persistence.Column(name = "ADDFAMC")
    @Basic
    public BigInteger getAddfamc() {
        return addfamc;
    }

    public void setAddfamc(BigInteger addfamc) {
        this.addfamc = addfamc;
    }

    private String pfilst;

    @javax.persistence.Column(name = "PFILST")
    @Basic
    public String getPfilst() {
        return pfilst;
    }

    public void setPfilst(String pfilst) {
        this.pfilst = pfilst;
    }

    private String nfilst;

    @javax.persistence.Column(name = "NFILST")
    @Basic
    public String getNfilst() {
        return nfilst;
    }

    public void setNfilst(String nfilst) {
        this.nfilst = nfilst;
    }

    private String fcamps7;

    @javax.persistence.Column(name = "FCAMPS7")
    @Basic
    public String getFcamps7() {
        return fcamps7;
    }

    public void setFcamps7(String fcamps7) {
        this.fcamps7 = fcamps7;
    }

    private String fshous7;

    @javax.persistence.Column(name = "FSHOUS7")
    @Basic
    public String getFshous7() {
        return fshous7;
    }

    public void setFshous7(String fshous7) {
        this.fshous7 = fshous7;
    }

    private String fcamps8;

    @javax.persistence.Column(name = "FCAMPS8")
    @Basic
    public String getFcamps8() {
        return fcamps8;
    }

    public void setFcamps8(String fcamps8) {
        this.fcamps8 = fcamps8;
    }

    private String fshous8;

    @javax.persistence.Column(name = "FSHOUS8")
    @Basic
    public String getFshous8() {
        return fshous8;
    }

    public void setFshous8(String fshous8) {
        this.fshous8 = fshous8;
    }

    private String fcamps9;

    @javax.persistence.Column(name = "FCAMPS9")
    @Basic
    public String getFcamps9() {
        return fcamps9;
    }

    public void setFcamps9(String fcamps9) {
        this.fcamps9 = fcamps9;
    }

    private String fshous9;

    @javax.persistence.Column(name = "FSHOUS9")
    @Basic
    public String getFshous9() {
        return fshous9;
    }

    public void setFshous9(String fshous9) {
        this.fshous9 = fshous9;
    }

    private String fcampsa;

    @javax.persistence.Column(name = "FCAMPSA")
    @Basic
    public String getFcampsa() {
        return fcampsa;
    }

    public void setFcampsa(String fcampsa) {
        this.fcampsa = fcampsa;
    }

    private String fshousa;

    @javax.persistence.Column(name = "FSHOUSA")
    @Basic
    public String getFshousa() {
        return fshousa;
    }

    public void setFshousa(String fshousa) {
        this.fshousa = fshousa;
    }

    private String frlnfg;

    @javax.persistence.Column(name = "FRLNFG")
    @Basic
    public String getFrlnfg() {
        return frlnfg;
    }

    public void setFrlnfg(String frlnfg) {
        this.frlnfg = frlnfg;
    }

    private String combtfi;

    @javax.persistence.Column(name = "COMBTFI")
    @Basic
    public String getCombtfi() {
        return combtfi;
    }

    public void setCombtfi(String combtfi) {
        this.combtfi = combtfi;
    }

    private int fpcstpd;

    @javax.persistence.Column(name = "FPCSTPD")
    @Basic
    public int getFpcstpd() {
        return fpcstpd;
    }

    public void setFpcstpd(int fpcstpd) {
        this.fpcstpd = fpcstpd;
    }

    private int fpcomby;

    @javax.persistence.Column(name = "FPCOMBY")
    @Basic
    public int getFpcomby() {
        return fpcomby;
    }

    public void setFpcomby(int fpcomby) {
        this.fpcomby = fpcomby;
    }

    private int fscstpd;

    @javax.persistence.Column(name = "FSCSTPD")
    @Basic
    public int getFscstpd() {
        return fscstpd;
    }

    public void setFscstpd(int fscstpd) {
        this.fscstpd = fscstpd;
    }

    private int fsgtsad;

    @javax.persistence.Column(name = "FSGTSAD")
    @Basic
    public int getFsgtsad() {
        return fsgtsad;
    }

    public void setFsgtsad(int fsgtsad) {
        this.fsgtsad = fsgtsad;
    }

    private int fscomby;

    @javax.persistence.Column(name = "FSCOMBY")
    @Basic
    public int getFscomby() {
        return fscomby;
    }

    public void setFscomby(int fscomby) {
        this.fscomby = fscomby;
    }

    private String fshomls;

    @javax.persistence.Column(name = "FSHOMLS")
    @Basic
    public String getFshomls() {
        return fshomls;
    }

    public void setFshomls(String fshomls) {
        this.fshomls = fshomls;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snf8Entity that = (Snf8Entity) o;

        if (agcnopb != that.agcnopb) return false;
        if (agsuopb != that.agsuopb) return false;
        if (agusopb != that.agusopb) return false;
        if (fcmpnum != that.fcmpnum) return false;
        if (fefcntwr != that.fefcntwr) return false;
        if (flnamt1 != that.flnamt1) return false;
        if (flnamt2 != that.flnamt2) return false;
        if (flnamt3 != that.flnamt3) return false;
        if (fotbal1 != that.fotbal1) return false;
        if (fotbal2 != that.fotbal2) return false;
        if (fotbal3 != that.fotbal3) return false;
        if (fp2Onti != that.fp2Onti) return false;
        if (fpawat1 != that.fpawat1) return false;
        if (fpawat2 != that.fpawat2) return false;
        if (fpawat3 != that.fpawat3) return false;
        if (fpbfe != that.fpbfe) return false;
        if (fpcomby != that.fpcomby) return false;
        if (fpcstpd != that.fpcstpd) return false;
        if (fpdefc != that.fpdefc) return false;
        if (fpfarme != that.fpfarme) return false;
        if (fs2Onti != that.fs2Onti) return false;
        if (fsawtoti != that.fsawtoti) return false;
        if (fsbfe != that.fsbfe) return false;
        if (fscomby != that.fscomby) return false;
        if (fscstpd != that.fscstpd) return false;
        if (fsfarme != that.fsfarme) return false;
        if (fsgtsad != that.fsgtsad) return false;
        if (fsnetwth != that.fsnetwth) return false;
        if (l41Lev != that.l41Lev) return false;
        if (outbal1 != that.outbal1) return false;
        if (outbal2 != that.outbal2) return false;
        if (outbal3 != that.outbal3) return false;
        if (outbal4 != that.outbal4) return false;
        if (outbal5 != that.outbal5) return false;
        if (outbal6 != that.outbal6) return false;
        if (pkcmamt != that.pkcmamt) return false;
        if (pkcyamt != that.pkcyamt) return false;
        if (tnbsfm != that.tnbsfm) return false;
        if (tncse != that.tncse) return false;
        if (tnctc != that.tnctc) return false;
        if (tnedcr != that.tnedcr) return false;
        if (tnivre != that.tnivre) return false;
        if (tpbsfm != that.tpbsfm) return false;
        if (tpcse != that.tpcse) return false;
        if (tpctc != that.tpctc) return false;
        if (tpedcr != that.tpedcr) return false;
        if (tpfsb != that.tpfsb) return false;
        if (tpivre != that.tpivre) return false;
        if (tpssib != that.tpssib) return false;
        if (tptanf != that.tptanf) return false;
        if (tpwic != that.tpwic) return false;
        if (tsbsfm != that.tsbsfm) return false;
        if (tscse != that.tscse) return false;
        if (tsctc != that.tsctc) return false;
        if (tsedcr != that.tsedcr) return false;
        if (tsfsb != that.tsfsb) return false;
        if (tsivre != that.tsivre) return false;
        if (tssib != that.tssib) return false;
        if (tstanf != that.tstanf) return false;
        if (tswic != that.tswic) return false;
        if (vnouia1 != that.vnouia1) return false;
        if (vnouia2 != that.vnouia2) return false;
        if (vnouia3 != that.vnouia3) return false;
        if (vpouia1 != that.vpouia1) return false;
        if (vpouia2 != that.vpouia2) return false;
        if (vpouia3 != that.vpouia3) return false;
        if (vsouia1 != that.vsouia1) return false;
        if (vsouia2 != that.vsouia2) return false;
        if (vsouia3 != that.vsouia3) return false;
        if (addfamc != null ? !addfamc.equals(that.addfamc) : that.addfamc != null) return false;
        if (addfmly != null ? !addfmly.equals(that.addfmly) : that.addfmly != null) return false;
        if (adlnfg1 != null ? !adlnfg1.equals(that.adlnfg1) : that.adlnfg1 != null) return false;
        if (adlnfg2 != null ? !adlnfg2.equals(that.adlnfg2) : that.adlnfg2 != null) return false;
        if (adlnfg3 != null ? !adlnfg3.equals(that.adlnfg3) : that.adlnfg3 != null) return false;
        if (adlnfg4 != null ? !adlnfg4.equals(that.adlnfg4) : that.adlnfg4 != null) return false;
        if (adlnfg5 != null ? !adlnfg5.equals(that.adlnfg5) : that.adlnfg5 != null) return false;
        if (adlnfg6 != null ? !adlnfg6.equals(that.adlnfg6) : that.adlnfg6 != null) return false;
        if (agaddfg != null ? !agaddfg.equals(that.agaddfg) : that.agaddfg != null) return false;
        if (agchgfg != null ? !agchgfg.equals(that.agchgfg) : that.agchgfg != null) return false;
        if (agovcnt != null ? !agovcnt.equals(that.agovcnt) : that.agovcnt != null) return false;
        if (agovflg != null ? !agovflg.equals(that.agovflg) : that.agovflg != null) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (bankyfg != null ? !bankyfg.equals(that.bankyfg) : that.bankyfg != null) return false;
        if (begdt1 != null ? !begdt1.equals(that.begdt1) : that.begdt1 != null) return false;
        if (begdt2 != null ? !begdt2.equals(that.begdt2) : that.begdt2 != null) return false;
        if (begdt3 != null ? !begdt3.equals(that.begdt3) : that.begdt3 != null) return false;
        if (begdt4 != null ? !begdt4.equals(that.begdt4) : that.begdt4 != null) return false;
        if (begdt5 != null ? !begdt5.equals(that.begdt5) : that.begdt5 != null) return false;
        if (begdt6 != null ? !begdt6.equals(that.begdt6) : that.begdt6 != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (combtfi != null ? !combtfi.equals(that.combtfi) : that.combtfi != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (dglnfg != null ? !dglnfg.equals(that.dglnfg) : that.dglnfg != null) return false;
        if (dlnflg != null ? !dlnflg.equals(that.dlnflg) : that.dlnflg != null) return false;
        if (enddt1 != null ? !enddt1.equals(that.enddt1) : that.enddt1 != null) return false;
        if (enddt2 != null ? !enddt2.equals(that.enddt2) : that.enddt2 != null) return false;
        if (enddt3 != null ? !enddt3.equals(that.enddt3) : that.enddt3 != null) return false;
        if (enddt4 != null ? !enddt4.equals(that.enddt4) : that.enddt4 != null) return false;
        if (enddt5 != null ? !enddt5.equals(that.enddt5) : that.enddt5 != null) return false;
        if (enddt6 != null ? !enddt6.equals(that.enddt6) : that.enddt6 != null) return false;
        if (factive != null ? !factive.equals(that.factive) : that.factive != null) return false;
        if (fadlnf1 != null ? !fadlnf1.equals(that.fadlnf1) : that.fadlnf1 != null) return false;
        if (fadlnf2 != null ? !fadlnf2.equals(that.fadlnf2) : that.fadlnf2 != null) return false;
        if (fadlnf3 != null ? !fadlnf3.equals(that.fadlnf3) : that.fadlnf3 != null) return false;
        if (fadmflg != null ? !fadmflg.equals(that.fadmflg) : that.fadmflg != null) return false;
        if (famage1 != null ? !famage1.equals(that.famage1) : that.famage1 != null) return false;
        if (famage2 != null ? !famage2.equals(that.famage2) : that.famage2 != null) return false;
        if (famage3 != null ? !famage3.equals(that.famage3) : that.famage3 != null) return false;
        if (famage4 != null ? !famage4.equals(that.famage4) : that.famage4 != null) return false;
        if (famage5 != null ? !famage5.equals(that.famage5) : that.famage5 != null) return false;
        if (famage6 != null ? !famage6.equals(that.famage6) : that.famage6 != null) return false;
        if (famage7 != null ? !famage7.equals(that.famage7) : that.famage7 != null) return false;
        if (famcol1 != null ? !famcol1.equals(that.famcol1) : that.famcol1 != null) return false;
        if (famcol2 != null ? !famcol2.equals(that.famcol2) : that.famcol2 != null) return false;
        if (famcol3 != null ? !famcol3.equals(that.famcol3) : that.famcol3 != null) return false;
        if (famcol4 != null ? !famcol4.equals(that.famcol4) : that.famcol4 != null) return false;
        if (famcol5 != null ? !famcol5.equals(that.famcol5) : that.famcol5 != null) return false;
        if (famcol6 != null ? !famcol6.equals(that.famcol6) : that.famcol6 != null) return false;
        if (famcol7 != null ? !famcol7.equals(that.famcol7) : that.famcol7 != null) return false;
        if (famrel1 != null ? !famrel1.equals(that.famrel1) : that.famrel1 != null) return false;
        if (famrel2 != null ? !famrel2.equals(that.famrel2) : that.famrel2 != null) return false;
        if (famrel3 != null ? !famrel3.equals(that.famrel3) : that.famrel3 != null) return false;
        if (famrel4 != null ? !famrel4.equals(that.famrel4) : that.famrel4 != null) return false;
        if (famrel5 != null ? !famrel5.equals(that.famrel5) : that.famrel5 != null) return false;
        if (famrel6 != null ? !famrel6.equals(that.famrel6) : that.famrel6 != null) return false;
        if (famrel7 != null ? !famrel7.equals(that.famrel7) : that.famrel7 != null) return false;
        if (fappdtc != null ? !fappdtc.equals(that.fappdtc) : that.fappdtc != null) return false;
        if (fappnum != null ? !fappnum.equals(that.fappnum) : that.fappnum != null) return false;
        if (fappsrcd != null ? !fappsrcd.equals(that.fappsrcd) : that.fappsrcd != null) return false;
        if (fbegdt1 != null ? !fbegdt1.equals(that.fbegdt1) : that.fbegdt1 != null) return false;
        if (fbegdt2 != null ? !fbegdt2.equals(that.fbegdt2) : that.fbegdt2 != null) return false;
        if (fbegdt3 != null ? !fbegdt3.equals(that.fbegdt3) : that.fbegdt3 != null) return false;
        if (fcamps7 != null ? !fcamps7.equals(that.fcamps7) : that.fcamps7 != null) return false;
        if (fcamps8 != null ? !fcamps8.equals(that.fcamps8) : that.fcamps8 != null) return false;
        if (fcamps9 != null ? !fcamps9.equals(that.fcamps9) : that.fcamps9 != null) return false;
        if (fcampsa != null ? !fcampsa.equals(that.fcampsa) : that.fcampsa != null) return false;
        if (fdeaddtc != null ? !fdeaddtc.equals(that.fdeaddtc) : that.fdeaddtc != null) return false;
        if (fdepchd != null ? !fdepchd.equals(that.fdepchd) : that.fdepchd != null) return false;
        if (fdrugcn != null ? !fdrugcn.equals(that.fdrugcn) : that.fdrugcn != null) return false;
        if (fdupdtc != null ? !fdupdtc.equals(that.fdupdtc) : that.fdupdtc != null) return false;
        if (fefctpsc != null ? !fefctpsc.equals(that.fefctpsc) : that.fefctpsc != null) return false;
        if (femadtp != null ? !femadtp.equals(that.femadtp) : that.femadtp != null) return false;
        if (fenddt1 != null ? !fenddt1.equals(that.fenddt1) : that.fenddt1 != null) return false;
        if (fenddt2 != null ? !fenddt2.equals(that.fenddt2) : that.fenddt2 != null) return false;
        if (fenddt3 != null ? !fenddt3.equals(that.fenddt3) : that.fenddt3 != null) return false;
        if (fetidcd != null ? !fetidcd.equals(that.fetidcd) : that.fetidcd != null) return false;
        if (ffatdob != null ? !ffatdob.equals(that.ffatdob) : that.ffatdob != null) return false;
        if (fgacde1 != null ? !fgacde1.equals(that.fgacde1) : that.fgacde1 != null) return false;
        if (fgacde2 != null ? !fgacde2.equals(that.fgacde2) : that.fgacde2 != null) return false;
        if (fgacde3 != null ? !fgacde3.equals(that.fgacde3) : that.fgacde3 != null) return false;
        if (fhlcnse != null ? !fhlcnse.equals(that.fhlcnse) : that.fhlcnse != null) return false;
        if (fhlght2 != null ? !fhlght2.equals(that.fhlght2) : that.fhlght2 != null) return false;
        if (fhsgedf != null ? !fhsgedf.equals(that.fhsgedf) : that.fhsgedf != null) return false;
        if (filst != null ? !filst.equals(that.filst) : that.filst != null) return false;
        if (finrctp != null ? !finrctp.equals(that.finrctp) : that.finrctp != null) return false;
        if (fmotdob != null ? !fmotdob.equals(that.fmotdob) : that.fmotdob != null) return false;
        if (fnameff != null ? !fnameff.equals(that.fnameff) : that.fnameff != null) return false;
        if (fnamefl != null ? !fnamefl.equals(that.fnamefl) : that.fnamefl != null) return false;
        if (fnamemf != null ? !fnamemf.equals(that.fnamemf) : that.fnamemf != null) return false;
        if (fnameml != null ? !fnameml.equals(that.fnameml) : that.fnameml != null) return false;
        if (foutdt1 != null ? !foutdt1.equals(that.foutdt1) : that.foutdt1 != null) return false;
        if (foutdt2 != null ? !foutdt2.equals(that.foutdt2) : that.foutdt2 != null) return false;
        if (foutdt3 != null ? !foutdt3.equals(that.foutdt3) : that.foutdt3 != null) return false;
        if (fpelgfil != null ? !fpelgfil.equals(that.fpelgfil) : that.fpelgfil != null) return false;
        if (fpfilrtn != null ? !fpfilrtn.equals(that.fpfilrtn) : that.fpfilrtn != null) return false;
        if (fpflb != null ? !fpflb.equals(that.fpflb) : that.fpflb != null) return false;
        if (fpfsb != null ? !fpfsb.equals(that.fpfsb) : that.fpfsb != null) return false;
        if (fpgmcd1 != null ? !fpgmcd1.equals(that.fpgmcd1) : that.fpgmcd1 != null) return false;
        if (fpgmcd2 != null ? !fpgmcd2.equals(that.fpgmcd2) : that.fpgmcd2 != null) return false;
        if (fpgmcd3 != null ? !fpgmcd3.equals(that.fpgmcd3) : that.fpgmcd3 != null) return false;
        if (fpmrtdc != null ? !fpmrtdc.equals(that.fpmrtdc) : that.fpmrtdc != null) return false;
        if (fprcesc != null ? !fprcesc.equals(that.fprcesc) : that.fprcesc != null) return false;
        if (fpresbfr != null ? !fpresbfr.equals(that.fpresbfr) : that.fpresbfr != null) return false;
        if (fprimth != null ? !fprimth.equals(that.fprimth) : that.fprimth != null) return false;
        if (fprsdtc != null ? !fprsdtc.equals(that.fprsdtc) : that.fprsdtc != null) return false;
        if (fpsread != null ? !fpsread.equals(that.fpsread) : that.fpsread != null) return false;
        if (fpsredn != null ? !fpsredn.equals(that.fpsredn) : that.fpsredn != null) return false;
        if (fpssib != null ? !fpssib.equals(that.fpssib) : that.fpssib != null) return false;
        if (fptanf != null ? !fptanf.equals(that.fptanf) : that.fptanf != null) return false;
        if (fpwic != null ? !fpwic.equals(that.fpwic) : that.fpwic != null) return false;
        if (frectyp != null ? !frectyp.equals(that.frectyp) : that.frectyp != null) return false;
        if (frevisc != null ? !frevisc.equals(that.frevisc) : that.frevisc != null) return false;
        if (frlnfg != null ? !frlnfg.equals(that.frlnfg) : that.frlnfg != null) return false;
        if (frsigdc != null ? !frsigdc.equals(that.frsigdc) : that.frsigdc != null) return false;
        if (frvwdtc != null ? !frvwdtc.equals(that.frvwdtc) : that.frvwdtc != null) return false;
        if (fsasvast != null ? !fsasvast.equals(that.fsasvast) : that.fsasvast != null) return false;
        if (fsbrthc != null ? !fsbrthc.equals(that.fsbrthc) : that.fsbrthc != null) return false;
        if (fsdstec != null ? !fsdstec.equals(that.fsdstec) : that.fsdstec != null) return false;
        if (fsdstsc != null ? !fsdstsc.equals(that.fsdstsc) : that.fsdstsc != null) return false;
        if (fselgfil != null ? !fselgfil.equals(that.fselgfil) : that.fselgfil != null) return false;
        if (fsercd1 != null ? !fsercd1.equals(that.fsercd1) : that.fsercd1 != null) return false;
        if (fsercd2 != null ? !fsercd2.equals(that.fsercd2) : that.fsercd2 != null) return false;
        if (fsercd3 != null ? !fsercd3.equals(that.fsercd3) : that.fsercd3 != null) return false;
        if (fsfilrtn != null ? !fsfilrtn.equals(that.fsfilrtn) : that.fsfilrtn != null) return false;
        if (fsflb != null ? !fsflb.equals(that.fsflb) : that.fsflb != null) return false;
        if (fsfsb != null ? !fsfsb.equals(that.fsfsb) : that.fsfsb != null) return false;
        if (fsgedtc != null ? !fsgedtc.equals(that.fsgedtc) : that.fsgedtc != null) return false;
        if (fshomls != null ? !fshomls.equals(that.fshomls) : that.fshomls != null) return false;
        if (fshous7 != null ? !fshous7.equals(that.fshous7) : that.fshous7 != null) return false;
        if (fshous8 != null ? !fshous8.equals(that.fshous8) : that.fshous8 != null) return false;
        if (fshous9 != null ? !fshous9.equals(that.fshous9) : that.fshous9 != null) return false;
        if (fshousa != null ? !fshousa.equals(that.fshousa) : that.fshousa != null) return false;
        if (fshsdtc != null ? !fshsdtc.equals(that.fshsdtc) : that.fshsdtc != null) return false;
        if (fsigdac != null ? !fsigdac.equals(that.fsigdac) : that.fsigdac != null) return false;
        if (fsigdtc != null ? !fsigdtc.equals(that.fsigdtc) : that.fsigdtc != null) return false;
        if (fsmale != null ? !fsmale.equals(that.fsmale) : that.fsmale != null) return false;
        if (fsmrtdc != null ? !fsmrtdc.equals(that.fsmrtdc) : that.fsmrtdc != null) return false;
        if (fsntest != null ? !fsntest.equals(that.fsntest) : that.fsntest != null) return false;
        if (fsresbfr != null ? !fsresbfr.equals(that.fsresbfr) : that.fsresbfr != null) return false;
        if (fsresdc != null ? !fsresdc.equals(that.fsresdc) : that.fsresdc != null) return false;
        if (fssnfat != null ? !fssnfat.equals(that.fssnfat) : that.fssnfat != null) return false;
        if (fssnmot != null ? !fssnmot.equals(that.fssnmot) : that.fssnmot != null) return false;
        if (fsssib != null ? !fsssib.equals(that.fsssib) : that.fsssib != null) return false;
        if (fstanf != null ? !fstanf.equals(that.fstanf) : that.fstanf != null) return false;
        if (fstcd1 != null ? !fstcd1.equals(that.fstcd1) : that.fstcd1 != null) return false;
        if (fstcd2 != null ? !fstcd2.equals(that.fstcd2) : that.fstcd2 != null) return false;
        if (fstcd3 != null ? !fstcd3.equals(that.fstcd3) : that.fstcd3 != null) return false;
        if (fstdt1 != null ? !fstdt1.equals(that.fstdt1) : that.fstdt1 != null) return false;
        if (fstdt2 != null ? !fstdt2.equals(that.fstdt2) : that.fstdt2 != null) return false;
        if (fstdt3 != null ? !fstdt3.equals(that.fstdt3) : that.fstdt3 != null) return false;
        if (fswic != null ? !fswic.equals(that.fswic) : that.fswic != null) return false;
        if (fsxpgrc != null ? !fsxpgrc.equals(that.fsxpgrc) : that.fsxpgrc != null) return false;
        if (ftfdtec != null ? !ftfdtec.equals(that.ftfdtec) : that.ftfdtec != null) return false;
        if (fvamchfg != null ? !fvamchfg.equals(that.fvamchfg) : that.fvamchfg != null) return false;
        if (fverinbx != null ? !fverinbx.equals(that.fverinbx) : that.fverinbx != null) return false;
        if (gacode1 != null ? !gacode1.equals(that.gacode1) : that.gacode1 != null) return false;
        if (gacode2 != null ? !gacode2.equals(that.gacode2) : that.gacode2 != null) return false;
        if (gacode3 != null ? !gacode3.equals(that.gacode3) : that.gacode3 != null) return false;
        if (gacode4 != null ? !gacode4.equals(that.gacode4) : that.gacode4 != null) return false;
        if (gacode5 != null ? !gacode5.equals(that.gacode5) : that.gacode5 != null) return false;
        if (gacode6 != null ? !gacode6.equals(that.gacode6) : that.gacode6 != null) return false;
        if (gpmpnfg != null ? !gpmpnfg.equals(that.gpmpnfg) : that.gpmpnfg != null) return false;
        if (instcd1 != null ? !instcd1.equals(that.instcd1) : that.instcd1 != null) return false;
        if (instcd2 != null ? !instcd2.equals(that.instcd2) : that.instcd2 != null) return false;
        if (instcd3 != null ? !instcd3.equals(that.instcd3) : that.instcd3 != null) return false;
        if (instcd4 != null ? !instcd4.equals(that.instcd4) : that.instcd4 != null) return false;
        if (instcd5 != null ? !instcd5.equals(that.instcd5) : that.instcd5 != null) return false;
        if (instcd6 != null ? !instcd6.equals(that.instcd6) : that.instcd6 != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (lncncd1 != null ? !lncncd1.equals(that.lncncd1) : that.lncncd1 != null) return false;
        if (lncncd10 != null ? !lncncd10.equals(that.lncncd10) : that.lncncd10 != null) return false;
        if (lncncd11 != null ? !lncncd11.equals(that.lncncd11) : that.lncncd11 != null) return false;
        if (lncncd12 != null ? !lncncd12.equals(that.lncncd12) : that.lncncd12 != null) return false;
        if (lncncd2 != null ? !lncncd2.equals(that.lncncd2) : that.lncncd2 != null) return false;
        if (lncncd3 != null ? !lncncd3.equals(that.lncncd3) : that.lncncd3 != null) return false;
        if (lncncd4 != null ? !lncncd4.equals(that.lncncd4) : that.lncncd4 != null) return false;
        if (lncncd5 != null ? !lncncd5.equals(that.lncncd5) : that.lncncd5 != null) return false;
        if (lncncd6 != null ? !lncncd6.equals(that.lncncd6) : that.lncncd6 != null) return false;
        if (lncncd7 != null ? !lncncd7.equals(that.lncncd7) : that.lncncd7 != null) return false;
        if (lncncd8 != null ? !lncncd8.equals(that.lncncd8) : that.lncncd8 != null) return false;
        if (lncncd9 != null ? !lncncd9.equals(that.lncncd9) : that.lncncd9 != null) return false;
        if (lnfmcd1 != null ? !lnfmcd1.equals(that.lnfmcd1) : that.lnfmcd1 != null) return false;
        if (lnfmcd2 != null ? !lnfmcd2.equals(that.lnfmcd2) : that.lnfmcd2 != null) return false;
        if (lnfmcd3 != null ? !lnfmcd3.equals(that.lnfmcd3) : that.lnfmcd3 != null) return false;
        if (lnfmcd4 != null ? !lnfmcd4.equals(that.lnfmcd4) : that.lnfmcd4 != null) return false;
        if (lnfmcd5 != null ? !lnfmcd5.equals(that.lnfmcd5) : that.lnfmcd5 != null) return false;
        if (lnfmcd6 != null ? !lnfmcd6.equals(that.lnfmcd6) : that.lnfmcd6 != null) return false;
        if (lnsatrp != null ? !lnsatrp.equals(that.lnsatrp) : that.lnsatrp != null) return false;
        if (lntpcd1 != null ? !lntpcd1.equals(that.lntpcd1) : that.lntpcd1 != null) return false;
        if (lntpcd10 != null ? !lntpcd10.equals(that.lntpcd10) : that.lntpcd10 != null) return false;
        if (lntpcd11 != null ? !lntpcd11.equals(that.lntpcd11) : that.lntpcd11 != null) return false;
        if (lntpcd12 != null ? !lntpcd12.equals(that.lntpcd12) : that.lntpcd12 != null) return false;
        if (lntpcd2 != null ? !lntpcd2.equals(that.lntpcd2) : that.lntpcd2 != null) return false;
        if (lntpcd3 != null ? !lntpcd3.equals(that.lntpcd3) : that.lntpcd3 != null) return false;
        if (lntpcd4 != null ? !lntpcd4.equals(that.lntpcd4) : that.lntpcd4 != null) return false;
        if (lntpcd5 != null ? !lntpcd5.equals(that.lntpcd5) : that.lntpcd5 != null) return false;
        if (lntpcd6 != null ? !lntpcd6.equals(that.lntpcd6) : that.lntpcd6 != null) return false;
        if (lntpcd7 != null ? !lntpcd7.equals(that.lntpcd7) : that.lntpcd7 != null) return false;
        if (lntpcd8 != null ? !lntpcd8.equals(that.lntpcd8) : that.lntpcd8 != null) return false;
        if (lntpcd9 != null ? !lntpcd9.equals(that.lntpcd9) : that.lntpcd9 != null) return false;
        if (nfilst != null ? !nfilst.equals(that.nfilst) : that.nfilst != null) return false;
        if (nsldsfg != null ? !nsldsfg.equals(that.nsldsfg) : that.nsldsfg != null) return false;
        if (ntfdtec != null ? !ntfdtec.equals(that.ntfdtec) : that.ntfdtec != null) return false;
        if (ntrvwdc != null ? !ntrvwdc.equals(that.ntrvwdc) : that.ntrvwdc != null) return false;
        if (nttfsgn != null ? !nttfsgn.equals(that.nttfsgn) : that.nttfsgn != null) return false;
        if (pfilst != null ? !pfilst.equals(that.pfilst) : that.pfilst != null) return false;
        if (pgmcd1 != null ? !pgmcd1.equals(that.pgmcd1) : that.pgmcd1 != null) return false;
        if (pgmcd2 != null ? !pgmcd2.equals(that.pgmcd2) : that.pgmcd2 != null) return false;
        if (pgmcd3 != null ? !pgmcd3.equals(that.pgmcd3) : that.pgmcd3 != null) return false;
        if (pgmcd4 != null ? !pgmcd4.equals(that.pgmcd4) : that.pgmcd4 != null) return false;
        if (pgmcd5 != null ? !pgmcd5.equals(that.pgmcd5) : that.pgmcd5 != null) return false;
        if (pgmcd6 != null ? !pgmcd6.equals(that.pgmcd6) : that.pgmcd6 != null) return false;
        if (pkdfflg != null ? !pkdfflg.equals(that.pkdfflg) : that.pkdfflg != null) return false;
        if (pkdsfg1 != null ? !pkdsfg1.equals(that.pkdsfg1) : that.pkdsfg1 != null) return false;
        if (pkdsfg2 != null ? !pkdsfg2.equals(that.pkdsfg2) : that.pkdsfg2 != null) return false;
        if (pkovcnt != null ? !pkovcnt.equals(that.pkovcnt) : that.pkovcnt != null) return false;
        if (pkxlnfg != null ? !pkxlnfg.equals(that.pkxlnfg) : that.pkxlnfg != null) return false;
        if (plovflg != null ? !plovflg.equals(that.plovflg) : that.plovflg != null) return false;
        if (povcnt != null ? !povcnt.equals(that.povcnt) : that.povcnt != null) return false;
        if (ptfdtec != null ? !ptfdtec.equals(that.ptfdtec) : that.ptfdtec != null) return false;
        if (ptrvwdc != null ? !ptrvwdc.equals(that.ptrvwdc) : that.ptrvwdc != null) return false;
        if (pttfsgn != null ? !pttfsgn.equals(that.pttfsgn) : that.pttfsgn != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (regcd1 != null ? !regcd1.equals(that.regcd1) : that.regcd1 != null) return false;
        if (regcd2 != null ? !regcd2.equals(that.regcd2) : that.regcd2 != null) return false;
        if (regcd3 != null ? !regcd3.equals(that.regcd3) : that.regcd3 != null) return false;
        if (regcd4 != null ? !regcd4.equals(that.regcd4) : that.regcd4 != null) return false;
        if (regcd5 != null ? !regcd5.equals(that.regcd5) : that.regcd5 != null) return false;
        if (regcd6 != null ? !regcd6.equals(that.regcd6) : that.regcd6 != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sercd1 != null ? !sercd1.equals(that.sercd1) : that.sercd1 != null) return false;
        if (sercd2 != null ? !sercd2.equals(that.sercd2) : that.sercd2 != null) return false;
        if (sercd3 != null ? !sercd3.equals(that.sercd3) : that.sercd3 != null) return false;
        if (sercd4 != null ? !sercd4.equals(that.sercd4) : that.sercd4 != null) return false;
        if (sercd5 != null ? !sercd5.equals(that.sercd5) : that.sercd5 != null) return false;
        if (sercd6 != null ? !sercd6.equals(that.sercd6) : that.sercd6 != null) return false;
        if (sgovflg != null ? !sgovflg.equals(that.sgovflg) : that.sgovflg != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snfkey != null ? !snfkey.equals(that.snfkey) : that.snfkey != null) return false;
        if (sovcnt != null ? !sovcnt.equals(that.sovcnt) : that.sovcnt != null) return false;
        if (staddfg != null ? !staddfg.equals(that.staddfg) : that.staddfg != null) return false;
        if (statcd1 != null ? !statcd1.equals(that.statcd1) : that.statcd1 != null) return false;
        if (statcd2 != null ? !statcd2.equals(that.statcd2) : that.statcd2 != null) return false;
        if (statcd3 != null ? !statcd3.equals(that.statcd3) : that.statcd3 != null) return false;
        if (statcd4 != null ? !statcd4.equals(that.statcd4) : that.statcd4 != null) return false;
        if (statcd5 != null ? !statcd5.equals(that.statcd5) : that.statcd5 != null) return false;
        if (statcd6 != null ? !statcd6.equals(that.statcd6) : that.statcd6 != null) return false;
        if (statdt1 != null ? !statdt1.equals(that.statdt1) : that.statdt1 != null) return false;
        if (statdt2 != null ? !statdt2.equals(that.statdt2) : that.statdt2 != null) return false;
        if (statdt3 != null ? !statdt3.equals(that.statdt3) : that.statdt3 != null) return false;
        if (statdt4 != null ? !statdt4.equals(that.statdt4) : that.statdt4 != null) return false;
        if (statdt5 != null ? !statdt5.equals(that.statdt5) : that.statdt5 != null) return false;
        if (statdt6 != null ? !statdt6.equals(that.statdt6) : that.statdt6 != null) return false;
        if (stchgfg != null ? !stchgfg.equals(that.stchgfg) : that.stchgfg != null) return false;
        if (stfdtec != null ? !stfdtec.equals(that.stfdtec) : that.stfdtec != null) return false;
        if (stovcnt != null ? !stovcnt.equals(that.stovcnt) : that.stovcnt != null) return false;
        if (stovflg != null ? !stovflg.equals(that.stovflg) : that.stovflg != null) return false;
        if (strvwdc != null ? !strvwdc.equals(that.strvwdc) : that.strvwdc != null) return false;
        if (sttfsgn != null ? !sttfsgn.equals(that.sttfsgn) : that.sttfsgn != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;
        if (vnfdtec != null ? !vnfdtec.equals(that.vnfdtec) : that.vnfdtec != null) return false;
        if (vnouit1 != null ? !vnouit1.equals(that.vnouit1) : that.vnouit1 != null) return false;
        if (vnouit2 != null ? !vnouit2.equals(that.vnouit2) : that.vnouit2 != null) return false;
        if (vnouit3 != null ? !vnouit3.equals(that.vnouit3) : that.vnouit3 != null) return false;
        if (vpfdtec != null ? !vpfdtec.equals(that.vpfdtec) : that.vpfdtec != null) return false;
        if (vpouit1 != null ? !vpouit1.equals(that.vpouit1) : that.vpouit1 != null) return false;
        if (vpouit2 != null ? !vpouit2.equals(that.vpouit2) : that.vpouit2 != null) return false;
        if (vpouit3 != null ? !vpouit3.equals(that.vpouit3) : that.vpouit3 != null) return false;
        if (vsfdtec != null ? !vsfdtec.equals(that.vsfdtec) : that.vsfdtec != null) return false;
        if (vsouit1 != null ? !vsouit1.equals(that.vsouit1) : that.vsouit1 != null) return false;
        if (vsouit2 != null ? !vsouit2.equals(that.vsouit2) : that.vsouit2 != null) return false;
        if (vsouit3 != null ? !vsouit3.equals(that.vsouit3) : that.vsouit3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snfkey != null ? snfkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cmptype != null ? cmptype.hashCode() : 0);
        result = 31 * result + (versnr != null ? versnr.hashCode() : 0);
        result = 31 * result + (nsldsfg != null ? nsldsfg.hashCode() : 0);
        result = 31 * result + agsuopb;
        result = 31 * result + agusopb;
        result = 31 * result + agcnopb;
        result = 31 * result + (lnfmcd1 != null ? lnfmcd1.hashCode() : 0);
        result = 31 * result + (adlnfg1 != null ? adlnfg1.hashCode() : 0);
        result = 31 * result + (pgmcd1 != null ? pgmcd1.hashCode() : 0);
        result = 31 * result + (statcd1 != null ? statcd1.hashCode() : 0);
        result = 31 * result + (statdt1 != null ? statdt1.hashCode() : 0);
        result = 31 * result + outbal1;
        result = 31 * result + (begdt1 != null ? begdt1.hashCode() : 0);
        result = 31 * result + (enddt1 != null ? enddt1.hashCode() : 0);
        result = 31 * result + (gacode1 != null ? gacode1.hashCode() : 0);
        result = 31 * result + (instcd1 != null ? instcd1.hashCode() : 0);
        result = 31 * result + (sercd1 != null ? sercd1.hashCode() : 0);
        result = 31 * result + (regcd1 != null ? regcd1.hashCode() : 0);
        result = 31 * result + (lnfmcd2 != null ? lnfmcd2.hashCode() : 0);
        result = 31 * result + (adlnfg2 != null ? adlnfg2.hashCode() : 0);
        result = 31 * result + (pgmcd2 != null ? pgmcd2.hashCode() : 0);
        result = 31 * result + (statcd2 != null ? statcd2.hashCode() : 0);
        result = 31 * result + (statdt2 != null ? statdt2.hashCode() : 0);
        result = 31 * result + outbal2;
        result = 31 * result + (begdt2 != null ? begdt2.hashCode() : 0);
        result = 31 * result + (enddt2 != null ? enddt2.hashCode() : 0);
        result = 31 * result + (gacode2 != null ? gacode2.hashCode() : 0);
        result = 31 * result + (instcd2 != null ? instcd2.hashCode() : 0);
        result = 31 * result + (sercd2 != null ? sercd2.hashCode() : 0);
        result = 31 * result + (regcd2 != null ? regcd2.hashCode() : 0);
        result = 31 * result + (lnfmcd3 != null ? lnfmcd3.hashCode() : 0);
        result = 31 * result + (adlnfg3 != null ? adlnfg3.hashCode() : 0);
        result = 31 * result + (pgmcd3 != null ? pgmcd3.hashCode() : 0);
        result = 31 * result + (statcd3 != null ? statcd3.hashCode() : 0);
        result = 31 * result + (statdt3 != null ? statdt3.hashCode() : 0);
        result = 31 * result + outbal3;
        result = 31 * result + (begdt3 != null ? begdt3.hashCode() : 0);
        result = 31 * result + (enddt3 != null ? enddt3.hashCode() : 0);
        result = 31 * result + (gacode3 != null ? gacode3.hashCode() : 0);
        result = 31 * result + (instcd3 != null ? instcd3.hashCode() : 0);
        result = 31 * result + (sercd3 != null ? sercd3.hashCode() : 0);
        result = 31 * result + (regcd3 != null ? regcd3.hashCode() : 0);
        result = 31 * result + (fhsgedf != null ? fhsgedf.hashCode() : 0);
        result = 31 * result + (lncncd1 != null ? lncncd1.hashCode() : 0);
        result = 31 * result + (lncncd2 != null ? lncncd2.hashCode() : 0);
        result = 31 * result + (lncncd3 != null ? lncncd3.hashCode() : 0);
        result = 31 * result + (lncncd4 != null ? lncncd4.hashCode() : 0);
        result = 31 * result + (lncncd5 != null ? lncncd5.hashCode() : 0);
        result = 31 * result + (lncncd6 != null ? lncncd6.hashCode() : 0);
        result = 31 * result + (lnfmcd4 != null ? lnfmcd4.hashCode() : 0);
        result = 31 * result + (adlnfg4 != null ? adlnfg4.hashCode() : 0);
        result = 31 * result + (pgmcd4 != null ? pgmcd4.hashCode() : 0);
        result = 31 * result + (statcd4 != null ? statcd4.hashCode() : 0);
        result = 31 * result + (statdt4 != null ? statdt4.hashCode() : 0);
        result = 31 * result + outbal4;
        result = 31 * result + (begdt4 != null ? begdt4.hashCode() : 0);
        result = 31 * result + (enddt4 != null ? enddt4.hashCode() : 0);
        result = 31 * result + (gacode4 != null ? gacode4.hashCode() : 0);
        result = 31 * result + (instcd4 != null ? instcd4.hashCode() : 0);
        result = 31 * result + (sercd4 != null ? sercd4.hashCode() : 0);
        result = 31 * result + (regcd4 != null ? regcd4.hashCode() : 0);
        result = 31 * result + (lnfmcd5 != null ? lnfmcd5.hashCode() : 0);
        result = 31 * result + (adlnfg5 != null ? adlnfg5.hashCode() : 0);
        result = 31 * result + (pgmcd5 != null ? pgmcd5.hashCode() : 0);
        result = 31 * result + (statcd5 != null ? statcd5.hashCode() : 0);
        result = 31 * result + (statdt5 != null ? statdt5.hashCode() : 0);
        result = 31 * result + outbal5;
        result = 31 * result + (begdt5 != null ? begdt5.hashCode() : 0);
        result = 31 * result + (enddt5 != null ? enddt5.hashCode() : 0);
        result = 31 * result + (gacode5 != null ? gacode5.hashCode() : 0);
        result = 31 * result + (instcd5 != null ? instcd5.hashCode() : 0);
        result = 31 * result + (sercd5 != null ? sercd5.hashCode() : 0);
        result = 31 * result + (regcd5 != null ? regcd5.hashCode() : 0);
        result = 31 * result + (lnfmcd6 != null ? lnfmcd6.hashCode() : 0);
        result = 31 * result + (adlnfg6 != null ? adlnfg6.hashCode() : 0);
        result = 31 * result + (pgmcd6 != null ? pgmcd6.hashCode() : 0);
        result = 31 * result + (statcd6 != null ? statcd6.hashCode() : 0);
        result = 31 * result + (statdt6 != null ? statdt6.hashCode() : 0);
        result = 31 * result + outbal6;
        result = 31 * result + (begdt6 != null ? begdt6.hashCode() : 0);
        result = 31 * result + (enddt6 != null ? enddt6.hashCode() : 0);
        result = 31 * result + (gacode6 != null ? gacode6.hashCode() : 0);
        result = 31 * result + (instcd6 != null ? instcd6.hashCode() : 0);
        result = 31 * result + (sercd6 != null ? sercd6.hashCode() : 0);
        result = 31 * result + (regcd6 != null ? regcd6.hashCode() : 0);
        result = 31 * result + (fadlnf1 != null ? fadlnf1.hashCode() : 0);
        result = 31 * result + (fpgmcd1 != null ? fpgmcd1.hashCode() : 0);
        result = 31 * result + (fstcd1 != null ? fstcd1.hashCode() : 0);
        result = 31 * result + (fstdt1 != null ? fstdt1.hashCode() : 0);
        result = 31 * result + flnamt1;
        result = 31 * result + fotbal1;
        result = 31 * result + (foutdt1 != null ? foutdt1.hashCode() : 0);
        result = 31 * result + (fbegdt1 != null ? fbegdt1.hashCode() : 0);
        result = 31 * result + (fenddt1 != null ? fenddt1.hashCode() : 0);
        result = 31 * result + (fgacde1 != null ? fgacde1.hashCode() : 0);
        result = 31 * result + (fsercd1 != null ? fsercd1.hashCode() : 0);
        result = 31 * result + (fadlnf2 != null ? fadlnf2.hashCode() : 0);
        result = 31 * result + (fpgmcd2 != null ? fpgmcd2.hashCode() : 0);
        result = 31 * result + (fstcd2 != null ? fstcd2.hashCode() : 0);
        result = 31 * result + (fstdt2 != null ? fstdt2.hashCode() : 0);
        result = 31 * result + flnamt2;
        result = 31 * result + fotbal2;
        result = 31 * result + (foutdt2 != null ? foutdt2.hashCode() : 0);
        result = 31 * result + (fbegdt2 != null ? fbegdt2.hashCode() : 0);
        result = 31 * result + (fenddt2 != null ? fenddt2.hashCode() : 0);
        result = 31 * result + (fgacde2 != null ? fgacde2.hashCode() : 0);
        result = 31 * result + (fsercd2 != null ? fsercd2.hashCode() : 0);
        result = 31 * result + (fadlnf3 != null ? fadlnf3.hashCode() : 0);
        result = 31 * result + (fpgmcd3 != null ? fpgmcd3.hashCode() : 0);
        result = 31 * result + (fstcd3 != null ? fstcd3.hashCode() : 0);
        result = 31 * result + (fstdt3 != null ? fstdt3.hashCode() : 0);
        result = 31 * result + flnamt3;
        result = 31 * result + fotbal3;
        result = 31 * result + (foutdt3 != null ? foutdt3.hashCode() : 0);
        result = 31 * result + (fbegdt3 != null ? fbegdt3.hashCode() : 0);
        result = 31 * result + (fenddt3 != null ? fenddt3.hashCode() : 0);
        result = 31 * result + (fgacde3 != null ? fgacde3.hashCode() : 0);
        result = 31 * result + (fsercd3 != null ? fsercd3.hashCode() : 0);
        result = 31 * result + pkcmamt;
        result = 31 * result + pkcyamt;
        result = 31 * result + (pkdsfg1 != null ? pkdsfg1.hashCode() : 0);
        result = 31 * result + (pkdsfg2 != null ? pkdsfg2.hashCode() : 0);
        result = 31 * result + (pkxlnfg != null ? pkxlnfg.hashCode() : 0);
        result = 31 * result + (plovflg != null ? plovflg.hashCode() : 0);
        result = 31 * result + (sgovflg != null ? sgovflg.hashCode() : 0);
        result = 31 * result + (pkdfflg != null ? pkdfflg.hashCode() : 0);
        result = 31 * result + (bankyfg != null ? bankyfg.hashCode() : 0);
        result = 31 * result + (lntpcd1 != null ? lntpcd1.hashCode() : 0);
        result = 31 * result + (lntpcd2 != null ? lntpcd2.hashCode() : 0);
        result = 31 * result + (lntpcd3 != null ? lntpcd3.hashCode() : 0);
        result = 31 * result + (lntpcd4 != null ? lntpcd4.hashCode() : 0);
        result = 31 * result + (lntpcd5 != null ? lntpcd5.hashCode() : 0);
        result = 31 * result + (lntpcd6 != null ? lntpcd6.hashCode() : 0);
        result = 31 * result + (lntpcd7 != null ? lntpcd7.hashCode() : 0);
        result = 31 * result + (lntpcd8 != null ? lntpcd8.hashCode() : 0);
        result = 31 * result + (lntpcd9 != null ? lntpcd9.hashCode() : 0);
        result = 31 * result + (lntpcd10 != null ? lntpcd10.hashCode() : 0);
        result = 31 * result + (lntpcd11 != null ? lntpcd11.hashCode() : 0);
        result = 31 * result + (lntpcd12 != null ? lntpcd12.hashCode() : 0);
        result = 31 * result + (lncncd7 != null ? lncncd7.hashCode() : 0);
        result = 31 * result + (lncncd8 != null ? lncncd8.hashCode() : 0);
        result = 31 * result + (lncncd9 != null ? lncncd9.hashCode() : 0);
        result = 31 * result + (lncncd10 != null ? lncncd10.hashCode() : 0);
        result = 31 * result + (lncncd11 != null ? lncncd11.hashCode() : 0);
        result = 31 * result + (lncncd12 != null ? lncncd12.hashCode() : 0);
        result = 31 * result + (fsresdc != null ? fsresdc.hashCode() : 0);
        result = 31 * result + (fsbrthc != null ? fsbrthc.hashCode() : 0);
        result = 31 * result + (fsmrtdc != null ? fsmrtdc.hashCode() : 0);
        result = 31 * result + (fsxpgrc != null ? fsxpgrc.hashCode() : 0);
        result = 31 * result + (fshsdtc != null ? fshsdtc.hashCode() : 0);
        result = 31 * result + (fsgedtc != null ? fsgedtc.hashCode() : 0);
        result = 31 * result + (fsdstsc != null ? fsdstsc.hashCode() : 0);
        result = 31 * result + (fsdstec != null ? fsdstec.hashCode() : 0);
        result = 31 * result + (fsigdtc != null ? fsigdtc.hashCode() : 0);
        result = 31 * result + (frsigdc != null ? frsigdc.hashCode() : 0);
        result = 31 * result + (fappdtc != null ? fappdtc.hashCode() : 0);
        result = 31 * result + (fprcesc != null ? fprcesc.hashCode() : 0);
        result = 31 * result + (ftfdtec != null ? ftfdtec.hashCode() : 0);
        result = 31 * result + (frvwdtc != null ? frvwdtc.hashCode() : 0);
        result = 31 * result + (fprsdtc != null ? fprsdtc.hashCode() : 0);
        result = 31 * result + (ptfdtec != null ? ptfdtec.hashCode() : 0);
        result = 31 * result + (ptrvwdc != null ? ptrvwdc.hashCode() : 0);
        result = 31 * result + (stfdtec != null ? stfdtec.hashCode() : 0);
        result = 31 * result + (strvwdc != null ? strvwdc.hashCode() : 0);
        result = 31 * result + (ntfdtec != null ? ntfdtec.hashCode() : 0);
        result = 31 * result + (ntrvwdc != null ? ntrvwdc.hashCode() : 0);
        result = 31 * result + (vpfdtec != null ? vpfdtec.hashCode() : 0);
        result = 31 * result + (vsfdtec != null ? vsfdtec.hashCode() : 0);
        result = 31 * result + (vnfdtec != null ? vnfdtec.hashCode() : 0);
        result = 31 * result + (fsigdac != null ? fsigdac.hashCode() : 0);
        result = 31 * result + fsfarme;
        result = 31 * result + fsbfe;
        result = 31 * result + fpfarme;
        result = 31 * result + fpbfe;
        result = 31 * result + (fadmflg != null ? fadmflg.hashCode() : 0);
        result = 31 * result + (frevisc != null ? frevisc.hashCode() : 0);
        result = 31 * result + (fnamefl != null ? fnamefl.hashCode() : 0);
        result = 31 * result + (fssnfat != null ? fssnfat.hashCode() : 0);
        result = 31 * result + (fnameml != null ? fnameml.hashCode() : 0);
        result = 31 * result + (fssnmot != null ? fssnmot.hashCode() : 0);
        result = 31 * result + (fprimth != null ? fprimth.hashCode() : 0);
        result = 31 * result + (finrctp != null ? finrctp.hashCode() : 0);
        result = 31 * result + fpawat1;
        result = 31 * result + fpawat2;
        result = 31 * result + fpawat3;
        result = 31 * result + (fpsread != null ? fpsread.hashCode() : 0);
        result = 31 * result + (fdrugcn != null ? fdrugcn.hashCode() : 0);
        result = 31 * result + (fhlcnse != null ? fhlcnse.hashCode() : 0);
        result = 31 * result + (fsresbfr != null ? fsresbfr.hashCode() : 0);
        result = 31 * result + (fsmale != null ? fsmale.hashCode() : 0);
        result = 31 * result + (fsfilrtn != null ? fsfilrtn.hashCode() : 0);
        result = 31 * result + (fselgfil != null ? fselgfil.hashCode() : 0);
        result = 31 * result + (fsasvast != null ? fsasvast.hashCode() : 0);
        result = 31 * result + (fpfilrtn != null ? fpfilrtn.hashCode() : 0);
        result = 31 * result + (fpelgfil != null ? fpelgfil.hashCode() : 0);
        result = 31 * result + (fpresbfr != null ? fpresbfr.hashCode() : 0);
        result = 31 * result + (fappsrcd != null ? fappsrcd.hashCode() : 0);
        result = 31 * result + (fappnum != null ? fappnum.hashCode() : 0);
        result = 31 * result + (fetidcd != null ? fetidcd.hashCode() : 0);
        result = 31 * result + (frectyp != null ? frectyp.hashCode() : 0);
        result = 31 * result + (fsntest != null ? fsntest.hashCode() : 0);
        result = 31 * result + (fdeaddtc != null ? fdeaddtc.hashCode() : 0);
        result = 31 * result + (fvamchfg != null ? fvamchfg.hashCode() : 0);
        result = 31 * result + fcmpnum;
        result = 31 * result + fpdefc;
        result = 31 * result + (fefctpsc != null ? fefctpsc.hashCode() : 0);
        result = 31 * result + fefcntwr;
        result = 31 * result + fsawtoti;
        result = 31 * result + fsnetwth;
        result = 31 * result + (fdupdtc != null ? fdupdtc.hashCode() : 0);
        result = 31 * result + (povcnt != null ? povcnt.hashCode() : 0);
        result = 31 * result + (sovcnt != null ? sovcnt.hashCode() : 0);
        result = 31 * result + (pkovcnt != null ? pkovcnt.hashCode() : 0);
        result = 31 * result + (dlnflg != null ? dlnflg.hashCode() : 0);
        result = 31 * result + (dglnfg != null ? dglnfg.hashCode() : 0);
        result = 31 * result + (lnsatrp != null ? lnsatrp.hashCode() : 0);
        result = 31 * result + (fverinbx != null ? fverinbx.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        result = 31 * result + fs2Onti;
        result = 31 * result + fp2Onti;
        result = 31 * result + (fdepchd != null ? fdepchd.hashCode() : 0);
        result = 31 * result + (sttfsgn != null ? sttfsgn.hashCode() : 0);
        result = 31 * result + (pttfsgn != null ? pttfsgn.hashCode() : 0);
        result = 31 * result + (nttfsgn != null ? nttfsgn.hashCode() : 0);
        result = 31 * result + tsctc;
        result = 31 * result + tpctc;
        result = 31 * result + tnctc;
        result = 31 * result + tsedcr;
        result = 31 * result + tpedcr;
        result = 31 * result + tnedcr;
        result = 31 * result + tscse;
        result = 31 * result + tpcse;
        result = 31 * result + tncse;
        result = 31 * result + tsivre;
        result = 31 * result + tpivre;
        result = 31 * result + tnivre;
        result = 31 * result + tsbsfm;
        result = 31 * result + tpbsfm;
        result = 31 * result + tnbsfm;
        result = 31 * result + (vsouit1 != null ? vsouit1.hashCode() : 0);
        result = 31 * result + vsouia1;
        result = 31 * result + (vsouit2 != null ? vsouit2.hashCode() : 0);
        result = 31 * result + vsouia2;
        result = 31 * result + (vsouit3 != null ? vsouit3.hashCode() : 0);
        result = 31 * result + vsouia3;
        result = 31 * result + (vpouit1 != null ? vpouit1.hashCode() : 0);
        result = 31 * result + vpouia1;
        result = 31 * result + (vpouit2 != null ? vpouit2.hashCode() : 0);
        result = 31 * result + vpouia2;
        result = 31 * result + (vpouit3 != null ? vpouit3.hashCode() : 0);
        result = 31 * result + vpouia3;
        result = 31 * result + (vnouit1 != null ? vnouit1.hashCode() : 0);
        result = 31 * result + vnouia1;
        result = 31 * result + (vnouit2 != null ? vnouit2.hashCode() : 0);
        result = 31 * result + vnouia2;
        result = 31 * result + (vnouit3 != null ? vnouit3.hashCode() : 0);
        result = 31 * result + vnouia3;
        result = 31 * result + (fpmrtdc != null ? fpmrtdc.hashCode() : 0);
        result = 31 * result + (fpsredn != null ? fpsredn.hashCode() : 0);
        result = 31 * result + (femadtp != null ? femadtp.hashCode() : 0);
        result = 31 * result + (fnameff != null ? fnameff.hashCode() : 0);
        result = 31 * result + (fnamemf != null ? fnamemf.hashCode() : 0);
        result = 31 * result + (ffatdob != null ? ffatdob.hashCode() : 0);
        result = 31 * result + (fmotdob != null ? fmotdob.hashCode() : 0);
        result = 31 * result + (factive != null ? factive.hashCode() : 0);
        result = 31 * result + (fswic != null ? fswic.hashCode() : 0);
        result = 31 * result + (fstanf != null ? fstanf.hashCode() : 0);
        result = 31 * result + (fsflb != null ? fsflb.hashCode() : 0);
        result = 31 * result + (fsfsb != null ? fsfsb.hashCode() : 0);
        result = 31 * result + (fsssib != null ? fsssib.hashCode() : 0);
        result = 31 * result + (fpwic != null ? fpwic.hashCode() : 0);
        result = 31 * result + (fptanf != null ? fptanf.hashCode() : 0);
        result = 31 * result + (fpflb != null ? fpflb.hashCode() : 0);
        result = 31 * result + (fpfsb != null ? fpfsb.hashCode() : 0);
        result = 31 * result + (fpssib != null ? fpssib.hashCode() : 0);
        result = 31 * result + (gpmpnfg != null ? gpmpnfg.hashCode() : 0);
        result = 31 * result + (staddfg != null ? staddfg.hashCode() : 0);
        result = 31 * result + (agaddfg != null ? agaddfg.hashCode() : 0);
        result = 31 * result + (stchgfg != null ? stchgfg.hashCode() : 0);
        result = 31 * result + (agchgfg != null ? agchgfg.hashCode() : 0);
        result = 31 * result + (stovcnt != null ? stovcnt.hashCode() : 0);
        result = 31 * result + (agovcnt != null ? agovcnt.hashCode() : 0);
        result = 31 * result + (agovflg != null ? agovflg.hashCode() : 0);
        result = 31 * result + (stovflg != null ? stovflg.hashCode() : 0);
        result = 31 * result + tsfsb;
        result = 31 * result + tssib;
        result = 31 * result + tpwic;
        result = 31 * result + tptanf;
        result = 31 * result + tpfsb;
        result = 31 * result + tpssib;
        result = 31 * result + tswic;
        result = 31 * result + tstanf;
        result = 31 * result + (fhlght2 != null ? fhlght2.hashCode() : 0);
        result = 31 * result + (filst != null ? filst.hashCode() : 0);
        result = 31 * result + (famage1 != null ? famage1.hashCode() : 0);
        result = 31 * result + (famage2 != null ? famage2.hashCode() : 0);
        result = 31 * result + (famage3 != null ? famage3.hashCode() : 0);
        result = 31 * result + (famage4 != null ? famage4.hashCode() : 0);
        result = 31 * result + (famage5 != null ? famage5.hashCode() : 0);
        result = 31 * result + (famage6 != null ? famage6.hashCode() : 0);
        result = 31 * result + (famage7 != null ? famage7.hashCode() : 0);
        result = 31 * result + (famrel1 != null ? famrel1.hashCode() : 0);
        result = 31 * result + (famrel2 != null ? famrel2.hashCode() : 0);
        result = 31 * result + (famrel3 != null ? famrel3.hashCode() : 0);
        result = 31 * result + (famrel4 != null ? famrel4.hashCode() : 0);
        result = 31 * result + (famrel5 != null ? famrel5.hashCode() : 0);
        result = 31 * result + (famrel6 != null ? famrel6.hashCode() : 0);
        result = 31 * result + (famrel7 != null ? famrel7.hashCode() : 0);
        result = 31 * result + (famcol1 != null ? famcol1.hashCode() : 0);
        result = 31 * result + (famcol2 != null ? famcol2.hashCode() : 0);
        result = 31 * result + (famcol3 != null ? famcol3.hashCode() : 0);
        result = 31 * result + (famcol4 != null ? famcol4.hashCode() : 0);
        result = 31 * result + (famcol5 != null ? famcol5.hashCode() : 0);
        result = 31 * result + (famcol6 != null ? famcol6.hashCode() : 0);
        result = 31 * result + (famcol7 != null ? famcol7.hashCode() : 0);
        result = 31 * result + (addfmly != null ? addfmly.hashCode() : 0);
        result = 31 * result + (addfamc != null ? addfamc.hashCode() : 0);
        result = 31 * result + (pfilst != null ? pfilst.hashCode() : 0);
        result = 31 * result + (nfilst != null ? nfilst.hashCode() : 0);
        result = 31 * result + (fcamps7 != null ? fcamps7.hashCode() : 0);
        result = 31 * result + (fshous7 != null ? fshous7.hashCode() : 0);
        result = 31 * result + (fcamps8 != null ? fcamps8.hashCode() : 0);
        result = 31 * result + (fshous8 != null ? fshous8.hashCode() : 0);
        result = 31 * result + (fcamps9 != null ? fcamps9.hashCode() : 0);
        result = 31 * result + (fshous9 != null ? fshous9.hashCode() : 0);
        result = 31 * result + (fcampsa != null ? fcampsa.hashCode() : 0);
        result = 31 * result + (fshousa != null ? fshousa.hashCode() : 0);
        result = 31 * result + (frlnfg != null ? frlnfg.hashCode() : 0);
        result = 31 * result + (combtfi != null ? combtfi.hashCode() : 0);
        result = 31 * result + fpcstpd;
        result = 31 * result + fpcomby;
        result = 31 * result + fscstpd;
        result = 31 * result + fsgtsad;
        result = 31 * result + fscomby;
        result = 31 * result + (fshomls != null ? fshomls.hashCode() : 0);
        result = 31 * result + l41Lev;
        return result;
    }
}
