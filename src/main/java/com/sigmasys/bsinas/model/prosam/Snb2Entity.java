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
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNB2", schema = "SIGMA", catalog = "")
@Entity
public class Snb2Entity implements Identifiable {

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

    private int pscona;

    @javax.persistence.Column(name = "PSCONA")
    @Basic
    public int getPscona() {
        return pscona;
    }

    public void setPscona(int pscona) {
        this.pscona = pscona;
    }

    private int psconi;

    @javax.persistence.Column(name = "PSCONI")
    @Basic
    public int getPsconi() {
        return psconi;
    }

    public void setPsconi(int psconi) {
        this.psconi = psconi;
    }

    private int psconf;

    @javax.persistence.Column(name = "PSCONF")
    @Basic
    public int getPsconf() {
        return psconf;
    }

    public void setPsconf(int psconf) {
        this.psconf = psconf;
    }

    private int ppcona;

    @javax.persistence.Column(name = "PPCONA")
    @Basic
    public int getPpcona() {
        return ppcona;
    }

    public void setPpcona(int ppcona) {
        this.ppcona = ppcona;
    }

    private int ppconi;

    @javax.persistence.Column(name = "PPCONI")
    @Basic
    public int getPpconi() {
        return ppconi;
    }

    public void setPpconi(int ppconi) {
        this.ppconi = ppconi;
    }

    private int ppconf;

    @javax.persistence.Column(name = "PPCONF")
    @Basic
    public int getPpconf() {
        return ppconf;
    }

    public void setPpconf(int ppconf) {
        this.ppconf = ppconf;
    }

    private int ptfcf;

    @javax.persistence.Column(name = "PTFCF")
    @Basic
    public int getPtfcf() {
        return ptfcf;
    }

    public void setPtfcf(int ptfcf) {
        this.ptfcf = ptfcf;
    }

    private int sscona;

    @javax.persistence.Column(name = "SSCONA")
    @Basic
    public int getSscona() {
        return sscona;
    }

    public void setSscona(int sscona) {
        this.sscona = sscona;
    }

    private int ssconi;

    @javax.persistence.Column(name = "SSCONI")
    @Basic
    public int getSsconi() {
        return ssconi;
    }

    public void setSsconi(int ssconi) {
        this.ssconi = ssconi;
    }

    private int ssconf;

    @javax.persistence.Column(name = "SSCONF")
    @Basic
    public int getSsconf() {
        return ssconf;
    }

    public void setSsconf(int ssconf) {
        this.ssconf = ssconf;
    }

    private int spcona;

    @javax.persistence.Column(name = "SPCONA")
    @Basic
    public int getSpcona() {
        return spcona;
    }

    public void setSpcona(int spcona) {
        this.spcona = spcona;
    }

    private int spconi;

    @javax.persistence.Column(name = "SPCONI")
    @Basic
    public int getSpconi() {
        return spconi;
    }

    public void setSpconi(int spconi) {
        this.spconi = spconi;
    }

    private int spconf;

    @javax.persistence.Column(name = "SPCONF")
    @Basic
    public int getSpconf() {
        return spconf;
    }

    public void setSpconf(int spconf) {
        this.spconf = spconf;
    }

    private int stfcf;

    @javax.persistence.Column(name = "STFCF")
    @Basic
    public int getStfcf() {
        return stfcf;
    }

    public void setStfcf(int stfcf) {
        this.stfcf = stfcf;
    }

    private int pcadj;

    @javax.persistence.Column(name = "PCADJ")
    @Basic
    public int getPcadj() {
        return pcadj;
    }

    public void setPcadj(int pcadj) {
        this.pcadj = pcadj;
    }

    private int pcloss;

    @javax.persistence.Column(name = "PCLOSS")
    @Basic
    public int getPcloss() {
        return pcloss;
    }

    public void setPcloss(int pcloss) {
        this.pcloss = pcloss;
    }

    private int scpy;

    @javax.persistence.Column(name = "SCPY")
    @Basic
    public int getScpy() {
        return scpy;
    }

    public void setScpy(int scpy) {
        this.scpy = scpy;
    }

    private int pajlt9;

    @javax.persistence.Column(name = "PAJLT9")
    @Basic
    public int getPajlt9() {
        return pajlt9;
    }

    public void setPajlt9(int pajlt9) {
        this.pajlt9 = pajlt9;
    }

    private int pajgt9;

    @javax.persistence.Column(name = "PAJGT9")
    @Basic
    public int getPajgt9() {
        return pajgt9;
    }

    public void setPajgt9(int pajgt9) {
        this.pajgt9 = pajgt9;
    }

    private int sajlt9;

    @javax.persistence.Column(name = "SAJLT9")
    @Basic
    public int getSajlt9() {
        return sajlt9;
    }

    public void setSajlt9(int sajlt9) {
        this.sajlt9 = sajlt9;
    }

    private int sajgt9;

    @javax.persistence.Column(name = "SAJGT9")
    @Basic
    public int getSajgt9() {
        return sajgt9;
    }

    public void setSajgt9(int sajgt9) {
        this.sajgt9 = sajgt9;
    }

    private int pscona2;

    @javax.persistence.Column(name = "PSCONA2")
    @Basic
    public int getPscona2() {
        return pscona2;
    }

    public void setPscona2(int pscona2) {
        this.pscona2 = pscona2;
    }

    private int psconi2;

    @javax.persistence.Column(name = "PSCONI2")
    @Basic
    public int getPsconi2() {
        return psconi2;
    }

    public void setPsconi2(int psconi2) {
        this.psconi2 = psconi2;
    }

    private int psconf2;

    @javax.persistence.Column(name = "PSCONF2")
    @Basic
    public int getPsconf2() {
        return psconf2;
    }

    public void setPsconf2(int psconf2) {
        this.psconf2 = psconf2;
    }

    private int ppcona2;

    @javax.persistence.Column(name = "PPCONA2")
    @Basic
    public int getPpcona2() {
        return ppcona2;
    }

    public void setPpcona2(int ppcona2) {
        this.ppcona2 = ppcona2;
    }

    private int ppconi2;

    @javax.persistence.Column(name = "PPCONI2")
    @Basic
    public int getPpconi2() {
        return ppconi2;
    }

    public void setPpconi2(int ppconi2) {
        this.ppconi2 = ppconi2;
    }

    private int ppconf2;

    @javax.persistence.Column(name = "PPCONF2")
    @Basic
    public int getPpconf2() {
        return ppconf2;
    }

    public void setPpconf2(int ppconf2) {
        this.ppconf2 = ppconf2;
    }

    private int ptfcf2;

    @javax.persistence.Column(name = "PTFCF2")
    @Basic
    public int getPtfcf2() {
        return ptfcf2;
    }

    public void setPtfcf2(int ptfcf2) {
        this.ptfcf2 = ptfcf2;
    }

    private int sscona2;

    @javax.persistence.Column(name = "SSCONA2")
    @Basic
    public int getSscona2() {
        return sscona2;
    }

    public void setSscona2(int sscona2) {
        this.sscona2 = sscona2;
    }

    private int ssconi2;

    @javax.persistence.Column(name = "SSCONI2")
    @Basic
    public int getSsconi2() {
        return ssconi2;
    }

    public void setSsconi2(int ssconi2) {
        this.ssconi2 = ssconi2;
    }

    private int ssconf2;

    @javax.persistence.Column(name = "SSCONF2")
    @Basic
    public int getSsconf2() {
        return ssconf2;
    }

    public void setSsconf2(int ssconf2) {
        this.ssconf2 = ssconf2;
    }

    private int spcona2;

    @javax.persistence.Column(name = "SPCONA2")
    @Basic
    public int getSpcona2() {
        return spcona2;
    }

    public void setSpcona2(int spcona2) {
        this.spcona2 = spcona2;
    }

    private int spconi2;

    @javax.persistence.Column(name = "SPCONI2")
    @Basic
    public int getSpconi2() {
        return spconi2;
    }

    public void setSpconi2(int spconi2) {
        this.spconi2 = spconi2;
    }

    private int spconf2;

    @javax.persistence.Column(name = "SPCONF2")
    @Basic
    public int getSpconf2() {
        return spconf2;
    }

    public void setSpconf2(int spconf2) {
        this.spconf2 = spconf2;
    }

    private int stfcf2;

    @javax.persistence.Column(name = "STFCF2")
    @Basic
    public int getStfcf2() {
        return stfcf2;
    }

    public void setStfcf2(int stfcf2) {
        this.stfcf2 = stfcf2;
    }

    private int pcadj2;

    @javax.persistence.Column(name = "PCADJ2")
    @Basic
    public int getPcadj2() {
        return pcadj2;
    }

    public void setPcadj2(int pcadj2) {
        this.pcadj2 = pcadj2;
    }

    private int pcloss2;

    @javax.persistence.Column(name = "PCLOSS2")
    @Basic
    public int getPcloss2() {
        return pcloss2;
    }

    public void setPcloss2(int pcloss2) {
        this.pcloss2 = pcloss2;
    }

    private int scpy2;

    @javax.persistence.Column(name = "SCPY2")
    @Basic
    public int getScpy2() {
        return scpy2;
    }

    public void setScpy2(int scpy2) {
        this.scpy2 = scpy2;
    }

    private int pajlt92;

    @javax.persistence.Column(name = "PAJLT92")
    @Basic
    public int getPajlt92() {
        return pajlt92;
    }

    public void setPajlt92(int pajlt92) {
        this.pajlt92 = pajlt92;
    }

    private int pajgt92;

    @javax.persistence.Column(name = "PAJGT92")
    @Basic
    public int getPajgt92() {
        return pajgt92;
    }

    public void setPajgt92(int pajgt92) {
        this.pajgt92 = pajgt92;
    }

    private int sajlt92;

    @javax.persistence.Column(name = "SAJLT92")
    @Basic
    public int getSajlt92() {
        return sajlt92;
    }

    public void setSajlt92(int sajlt92) {
        this.sajlt92 = sajlt92;
    }

    private int sajgt92;

    @javax.persistence.Column(name = "SAJGT92")
    @Basic
    public int getSajgt92() {
        return sajgt92;
    }

    public void setSajgt92(int sajgt92) {
        this.sajgt92 = sajgt92;
    }

    private int savaba;

    @javax.persistence.Column(name = "SAVABA")
    @Basic
    public int getSavaba() {
        return savaba;
    }

    public void setSavaba(int savaba) {
        this.savaba = savaba;
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

    private String smrtlst;

    @javax.persistence.Column(name = "SMRTLST")
    @Basic
    public String getSmrtlst() {
        return smrtlst;
    }

    public void setSmrtlst(String smrtlst) {
        this.smrtlst = smrtlst;
    }

    private BigInteger ssizhhd;

    @javax.persistence.Column(name = "SSIZHHD")
    @Basic
    public BigInteger getSsizhhd() {
        return ssizhhd;
    }

    public void setSsizhhd(BigInteger ssizhhd) {
        this.ssizhhd = ssizhhd;
    }

    private BigInteger psizhhd;

    @javax.persistence.Column(name = "PSIZHHD")
    @Basic
    public BigInteger getPsizhhd() {
        return psizhhd;
    }

    public void setPsizhhd(BigInteger psizhhd) {
        this.psizhhd = psizhhd;
    }

    private int saagi;

    @javax.persistence.Column(name = "SAAGI")
    @Basic
    public int getSaagi() {
        return saagi;
    }

    public void setSaagi(int saagi) {
        this.saagi = saagi;
    }

    private int pagi;

    @javax.persistence.Column(name = "PAGI")
    @Basic
    public int getPagi() {
        return pagi;
    }

    public void setPagi(int pagi) {
        this.pagi = pagi;
    }

    private int pscona4;

    @javax.persistence.Column(name = "PSCONA4")
    @Basic
    public int getPscona4() {
        return pscona4;
    }

    public void setPscona4(int pscona4) {
        this.pscona4 = pscona4;
    }

    private int psconi4;

    @javax.persistence.Column(name = "PSCONI4")
    @Basic
    public int getPsconi4() {
        return psconi4;
    }

    public void setPsconi4(int psconi4) {
        this.psconi4 = psconi4;
    }

    private int pscont4;

    @javax.persistence.Column(name = "PSCONT4")
    @Basic
    public int getPscont4() {
        return pscont4;
    }

    public void setPscont4(int pscont4) {
        this.pscont4 = pscont4;
    }

    private int ppcona4;

    @javax.persistence.Column(name = "PPCONA4")
    @Basic
    public int getPpcona4() {
        return ppcona4;
    }

    public void setPpcona4(int ppcona4) {
        this.ppcona4 = ppcona4;
    }

    private int ppconi4;

    @javax.persistence.Column(name = "PPCONI4")
    @Basic
    public int getPpconi4() {
        return ppconi4;
    }

    public void setPpconi4(int ppconi4) {
        this.ppconi4 = ppconi4;
    }

    private int ppcont4;

    @javax.persistence.Column(name = "PPCONT4")
    @Basic
    public int getPpcont4() {
        return ppcont4;
    }

    public void setPpcont4(int ppcont4) {
        this.ppcont4 = ppcont4;
    }

    private int ptfci4;

    @javax.persistence.Column(name = "PTFCI4")
    @Basic
    public int getPtfci4() {
        return ptfci4;
    }

    public void setPtfci4(int ptfci4) {
        this.ptfci4 = ptfci4;
    }

    private int sscona4;

    @javax.persistence.Column(name = "SSCONA4")
    @Basic
    public int getSscona4() {
        return sscona4;
    }

    public void setSscona4(int sscona4) {
        this.sscona4 = sscona4;
    }

    private int ssconi4;

    @javax.persistence.Column(name = "SSCONI4")
    @Basic
    public int getSsconi4() {
        return ssconi4;
    }

    public void setSsconi4(int ssconi4) {
        this.ssconi4 = ssconi4;
    }

    private int sscont4;

    @javax.persistence.Column(name = "SSCONT4")
    @Basic
    public int getSscont4() {
        return sscont4;
    }

    public void setSscont4(int sscont4) {
        this.sscont4 = sscont4;
    }

    private int spcona4;

    @javax.persistence.Column(name = "SPCONA4")
    @Basic
    public int getSpcona4() {
        return spcona4;
    }

    public void setSpcona4(int spcona4) {
        this.spcona4 = spcona4;
    }

    private int spconi4;

    @javax.persistence.Column(name = "SPCONI4")
    @Basic
    public int getSpconi4() {
        return spconi4;
    }

    public void setSpconi4(int spconi4) {
        this.spconi4 = spconi4;
    }

    private int spcont4;

    @javax.persistence.Column(name = "SPCONT4")
    @Basic
    public int getSpcont4() {
        return spcont4;
    }

    public void setSpcont4(int spcont4) {
        this.spcont4 = spcont4;
    }

    private int stfci4;

    @javax.persistence.Column(name = "STFCI4")
    @Basic
    public int getStfci4() {
        return stfci4;
    }

    public void setStfci4(int stfci4) {
        this.stfci4 = stfci4;
    }

    private int pcadj4;

    @javax.persistence.Column(name = "PCADJ4")
    @Basic
    public int getPcadj4() {
        return pcadj4;
    }

    public void setPcadj4(int pcadj4) {
        this.pcadj4 = pcadj4;
    }

    private int pcloss4;

    @javax.persistence.Column(name = "PCLOSS4")
    @Basic
    public int getPcloss4() {
        return pcloss4;
    }

    public void setPcloss4(int pcloss4) {
        this.pcloss4 = pcloss4;
    }

    private int scpy4;

    @javax.persistence.Column(name = "SCPY4")
    @Basic
    public int getScpy4() {
        return scpy4;
    }

    public void setScpy4(int scpy4) {
        this.scpy4 = scpy4;
    }

    private int pajlt94;

    @javax.persistence.Column(name = "PAJLT94")
    @Basic
    public int getPajlt94() {
        return pajlt94;
    }

    public void setPajlt94(int pajlt94) {
        this.pajlt94 = pajlt94;
    }

    private int pajgt94;

    @javax.persistence.Column(name = "PAJGT94")
    @Basic
    public int getPajgt94() {
        return pajgt94;
    }

    public void setPajgt94(int pajgt94) {
        this.pajgt94 = pajgt94;
    }

    private int sajlt94;

    @javax.persistence.Column(name = "SAJLT94")
    @Basic
    public int getSajlt94() {
        return sajlt94;
    }

    public void setSajlt94(int sajlt94) {
        this.sajlt94 = sajlt94;
    }

    private int sajgt94;

    @javax.persistence.Column(name = "SAJGT94")
    @Basic
    public int getSajgt94() {
        return sajgt94;
    }

    public void setSajgt94(int sajgt94) {
        this.sajgt94 = sajgt94;
    }

    private int pscona5;

    @javax.persistence.Column(name = "PSCONA5")
    @Basic
    public int getPscona5() {
        return pscona5;
    }

    public void setPscona5(int pscona5) {
        this.pscona5 = pscona5;
    }

    private int psconi5;

    @javax.persistence.Column(name = "PSCONI5")
    @Basic
    public int getPsconi5() {
        return psconi5;
    }

    public void setPsconi5(int psconi5) {
        this.psconi5 = psconi5;
    }

    private int pscont5;

    @javax.persistence.Column(name = "PSCONT5")
    @Basic
    public int getPscont5() {
        return pscont5;
    }

    public void setPscont5(int pscont5) {
        this.pscont5 = pscont5;
    }

    private int ppcona5;

    @javax.persistence.Column(name = "PPCONA5")
    @Basic
    public int getPpcona5() {
        return ppcona5;
    }

    public void setPpcona5(int ppcona5) {
        this.ppcona5 = ppcona5;
    }

    private int ppconi5;

    @javax.persistence.Column(name = "PPCONI5")
    @Basic
    public int getPpconi5() {
        return ppconi5;
    }

    public void setPpconi5(int ppconi5) {
        this.ppconi5 = ppconi5;
    }

    private int ppcont5;

    @javax.persistence.Column(name = "PPCONT5")
    @Basic
    public int getPpcont5() {
        return ppcont5;
    }

    public void setPpcont5(int ppcont5) {
        this.ppcont5 = ppcont5;
    }

    private int ptfci5;

    @javax.persistence.Column(name = "PTFCI5")
    @Basic
    public int getPtfci5() {
        return ptfci5;
    }

    public void setPtfci5(int ptfci5) {
        this.ptfci5 = ptfci5;
    }

    private int sscona5;

    @javax.persistence.Column(name = "SSCONA5")
    @Basic
    public int getSscona5() {
        return sscona5;
    }

    public void setSscona5(int sscona5) {
        this.sscona5 = sscona5;
    }

    private int ssconi5;

    @javax.persistence.Column(name = "SSCONI5")
    @Basic
    public int getSsconi5() {
        return ssconi5;
    }

    public void setSsconi5(int ssconi5) {
        this.ssconi5 = ssconi5;
    }

    private int sscont5;

    @javax.persistence.Column(name = "SSCONT5")
    @Basic
    public int getSscont5() {
        return sscont5;
    }

    public void setSscont5(int sscont5) {
        this.sscont5 = sscont5;
    }

    private int spcona5;

    @javax.persistence.Column(name = "SPCONA5")
    @Basic
    public int getSpcona5() {
        return spcona5;
    }

    public void setSpcona5(int spcona5) {
        this.spcona5 = spcona5;
    }

    private int spconi5;

    @javax.persistence.Column(name = "SPCONI5")
    @Basic
    public int getSpconi5() {
        return spconi5;
    }

    public void setSpconi5(int spconi5) {
        this.spconi5 = spconi5;
    }

    private int spcont5;

    @javax.persistence.Column(name = "SPCONT5")
    @Basic
    public int getSpcont5() {
        return spcont5;
    }

    public void setSpcont5(int spcont5) {
        this.spcont5 = spcont5;
    }

    private int stfci5;

    @javax.persistence.Column(name = "STFCI5")
    @Basic
    public int getStfci5() {
        return stfci5;
    }

    public void setStfci5(int stfci5) {
        this.stfci5 = stfci5;
    }

    private int pcadj5;

    @javax.persistence.Column(name = "PCADJ5")
    @Basic
    public int getPcadj5() {
        return pcadj5;
    }

    public void setPcadj5(int pcadj5) {
        this.pcadj5 = pcadj5;
    }

    private int pcloss5;

    @javax.persistence.Column(name = "PCLOSS5")
    @Basic
    public int getPcloss5() {
        return pcloss5;
    }

    public void setPcloss5(int pcloss5) {
        this.pcloss5 = pcloss5;
    }

    private int scpy5;

    @javax.persistence.Column(name = "SCPY5")
    @Basic
    public int getScpy5() {
        return scpy5;
    }

    public void setScpy5(int scpy5) {
        this.scpy5 = scpy5;
    }

    private int pajlt95;

    @javax.persistence.Column(name = "PAJLT95")
    @Basic
    public int getPajlt95() {
        return pajlt95;
    }

    public void setPajlt95(int pajlt95) {
        this.pajlt95 = pajlt95;
    }

    private int pajgt95;

    @javax.persistence.Column(name = "PAJGT95")
    @Basic
    public int getPajgt95() {
        return pajgt95;
    }

    public void setPajgt95(int pajgt95) {
        this.pajgt95 = pajgt95;
    }

    private int sajlt95;

    @javax.persistence.Column(name = "SAJLT95")
    @Basic
    public int getSajlt95() {
        return sajlt95;
    }

    public void setSajlt95(int sajlt95) {
        this.sajlt95 = sajlt95;
    }

    private int sajgt95;

    @javax.persistence.Column(name = "SAJGT95")
    @Basic
    public int getSajgt95() {
        return sajgt95;
    }

    public void setSajgt95(int sajgt95) {
        this.sajgt95 = sajgt95;
    }

    private int osai;

    @javax.persistence.Column(name = "OSAI")
    @Basic
    public int getOsai() {
        return osai;
    }

    public void setOsai(int osai) {
        this.osai = osai;
    }

    private String scover;

    @javax.persistence.Column(name = "SCOVER")
    @Basic
    public String getScover() {
        return scover;
    }

    public void setScover(String scover) {
        this.scover = scover;
    }

    private String pcover;

    @javax.persistence.Column(name = "PCOVER")
    @Basic
    public String getPcover() {
        return pcover;
    }

    public void setPcover(String pcover) {
        this.pcover = pcover;
    }

    private String revrsn;

    @javax.persistence.Column(name = "REVRSN")
    @Basic
    public String getRevrsn() {
        return revrsn;
    }

    public void setRevrsn(String revrsn) {
        this.revrsn = revrsn;
    }

    private String verrsns;

    @javax.persistence.Column(name = "VERRSNS")
    @Basic
    public String getVerrsns() {
        return verrsns;
    }

    public void setVerrsns(String verrsns) {
        this.verrsns = verrsns;
    }

    private String ver;

    @javax.persistence.Column(name = "VER")
    @Basic
    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    private String snaclr;

    @javax.persistence.Column(name = "SNACLR")
    @Basic
    public String getSnaclr() {
        return snaclr;
    }

    public void setSnaclr(String snaclr) {
        this.snaclr = snaclr;
    }

    private String trmem;

    @javax.persistence.Column(name = "TRMEM")
    @Basic
    public String getTrmem() {
        return trmem;
    }

    public void setTrmem(String trmem) {
        this.trmem = trmem;
    }

    private String comm1;

    @javax.persistence.Column(name = "COMM1")
    @Basic
    public String getComm1() {
        return comm1;
    }

    public void setComm1(String comm1) {
        this.comm1 = comm1;
    }

    private String comm2;

    @javax.persistence.Column(name = "COMM2")
    @Basic
    public String getComm2() {
        return comm2;
    }

    public void setComm2(String comm2) {
        this.comm2 = comm2;
    }

    private String comm3;

    @javax.persistence.Column(name = "COMM3")
    @Basic
    public String getComm3() {
        return comm3;
    }

    public void setComm3(String comm3) {
        this.comm3 = comm3;
    }

    private String comm4;

    @javax.persistence.Column(name = "COMM4")
    @Basic
    public String getComm4() {
        return comm4;
    }

    public void setComm4(String comm4) {
        this.comm4 = comm4;
    }

    private String comm5;

    @javax.persistence.Column(name = "COMM5")
    @Basic
    public String getComm5() {
        return comm5;
    }

    public void setComm5(String comm5) {
        this.comm5 = comm5;
    }

    private String pgid;

    @javax.persistence.Column(name = "PGID")
    @Basic
    public String getPgid() {
        return pgid;
    }

    public void setPgid(String pgid) {
        this.pgid = pgid;
    }

    private String pgidsf;

    @javax.persistence.Column(name = "PGIDSF")
    @Basic
    public String getPgidsf() {
        return pgidsf;
    }

    public void setPgidsf(String pgidsf) {
        this.pgidsf = pgidsf;
    }

    private BigInteger pgtrnnr;

    @javax.persistence.Column(name = "PGTRNNR")
    @Basic
    public BigInteger getPgtrnnr() {
        return pgtrnnr;
    }

    public void setPgtrnnr(BigInteger pgtrnnr) {
        this.pgtrnnr = pgtrnnr;
    }

    private String sspcol;

    @javax.persistence.Column(name = "SSPCOL")
    @Basic
    public String getSspcol() {
        return sspcol;
    }

    public void setSspcol(String sspcol) {
        this.sspcol = sspcol;
    }

    private String spssn;

    @javax.persistence.Column(name = "SPSSN")
    @Basic
    public String getSpssn() {
        return spssn;
    }

    public void setSpssn(String spssn) {
        this.spssn = spssn;
    }

    private String sfrel2;

    @javax.persistence.Column(name = "SFREL2")
    @Basic
    public String getSfrel2() {
        return sfrel2;
    }

    public void setSfrel2(String sfrel2) {
        this.sfrel2 = sfrel2;
    }

    private String sfatt2;

    @javax.persistence.Column(name = "SFATT2")
    @Basic
    public String getSfatt2() {
        return sfatt2;
    }

    public void setSfatt2(String sfatt2) {
        this.sfatt2 = sfatt2;
    }

    private String sfrel3;

    @javax.persistence.Column(name = "SFREL3")
    @Basic
    public String getSfrel3() {
        return sfrel3;
    }

    public void setSfrel3(String sfrel3) {
        this.sfrel3 = sfrel3;
    }

    private String sfatt3;

    @javax.persistence.Column(name = "SFATT3")
    @Basic
    public String getSfatt3() {
        return sfatt3;
    }

    public void setSfatt3(String sfatt3) {
        this.sfatt3 = sfatt3;
    }

    private String sfrel4;

    @javax.persistence.Column(name = "SFREL4")
    @Basic
    public String getSfrel4() {
        return sfrel4;
    }

    public void setSfrel4(String sfrel4) {
        this.sfrel4 = sfrel4;
    }

    private String sfatt4;

    @javax.persistence.Column(name = "SFATT4")
    @Basic
    public String getSfatt4() {
        return sfatt4;
    }

    public void setSfatt4(String sfatt4) {
        this.sfatt4 = sfatt4;
    }

    private String sfrel5;

    @javax.persistence.Column(name = "SFREL5")
    @Basic
    public String getSfrel5() {
        return sfrel5;
    }

    public void setSfrel5(String sfrel5) {
        this.sfrel5 = sfrel5;
    }

    private String sfatt5;

    @javax.persistence.Column(name = "SFATT5")
    @Basic
    public String getSfatt5() {
        return sfatt5;
    }

    public void setSfatt5(String sfatt5) {
        this.sfatt5 = sfatt5;
    }

    private String sfrel6;

    @javax.persistence.Column(name = "SFREL6")
    @Basic
    public String getSfrel6() {
        return sfrel6;
    }

    public void setSfrel6(String sfrel6) {
        this.sfrel6 = sfrel6;
    }

    private String sfatt6;

    @javax.persistence.Column(name = "SFATT6")
    @Basic
    public String getSfatt6() {
        return sfatt6;
    }

    public void setSfatt6(String sfatt6) {
        this.sfatt6 = sfatt6;
    }

    private String sfrel7;

    @javax.persistence.Column(name = "SFREL7")
    @Basic
    public String getSfrel7() {
        return sfrel7;
    }

    public void setSfrel7(String sfrel7) {
        this.sfrel7 = sfrel7;
    }

    private String sfatt7;

    @javax.persistence.Column(name = "SFATT7")
    @Basic
    public String getSfatt7() {
        return sfatt7;
    }

    public void setSfatt7(String sfatt7) {
        this.sfatt7 = sfatt7;
    }

    private String sfrel8;

    @javax.persistence.Column(name = "SFREL8")
    @Basic
    public String getSfrel8() {
        return sfrel8;
    }

    public void setSfrel8(String sfrel8) {
        this.sfrel8 = sfrel8;
    }

    private String sfatt8;

    @javax.persistence.Column(name = "SFATT8")
    @Basic
    public String getSfatt8() {
        return sfatt8;
    }

    public void setSfatt8(String sfatt8) {
        this.sfatt8 = sfatt8;
    }

    private String saddr;

    @javax.persistence.Column(name = "SADDR")
    @Basic
    public String getSaddr() {
        return saddr;
    }

    public void setSaddr(String saddr) {
        this.saddr = saddr;
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

    private String sstate;

    @javax.persistence.Column(name = "SSTATE")
    @Basic
    public String getSstate() {
        return sstate;
    }

    public void setSstate(String sstate) {
        this.sstate = sstate;
    }

    private String szip;

    @javax.persistence.Column(name = "SZIP")
    @Basic
    public String getSzip() {
        return szip;
    }

    public void setSzip(String szip) {
        this.szip = szip;
    }

    private String stitle;

    @javax.persistence.Column(name = "STITLE")
    @Basic
    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    private String pdegree;

    @javax.persistence.Column(name = "PDEGREE")
    @Basic
    public String getPdegree() {
        return pdegree;
    }

    public void setPdegree(String pdegree) {
        this.pdegree = pdegree;
    }

    private String pdegree2;

    @javax.persistence.Column(name = "PDEGREE2")
    @Basic
    public String getPdegree2() {
        return pdegree2;
    }

    public void setPdegree2(String pdegree2) {
        this.pdegree2 = pdegree2;
    }

    private String samecol2;

    @javax.persistence.Column(name = "SAMECOL2")
    @Basic
    public String getSamecol2() {
        return samecol2;
    }

    public void setSamecol2(String samecol2) {
        this.samecol2 = samecol2;
    }

    private String major2;

    @javax.persistence.Column(name = "MAJOR2")
    @Basic
    public String getMajor2() {
        return major2;
    }

    public void setMajor2(String major2) {
        this.major2 = major2;
    }

    private int pindex;

    @javax.persistence.Column(name = "PINDEX")
    @Basic
    public int getPindex() {
        return pindex;
    }

    public void setPindex(int pindex) {
        this.pindex = pindex;
    }

    private String sintws;

    @javax.persistence.Column(name = "SINTWS")
    @Basic
    public String getSintws() {
        return sintws;
    }

    public void setSintws(String sintws) {
        this.sintws = sintws;
    }

    private String sintsln;

    @javax.persistence.Column(name = "SINTSLN")
    @Basic
    public String getSintsln() {
        return sintsln;
    }

    public void setSintsln(String sintsln) {
        this.sintsln = sintsln;
    }

    private String sintpln;

    @javax.persistence.Column(name = "SINTPLN")
    @Basic
    public String getSintpln() {
        return sintpln;
    }

    public void setSintpln(String sintpln) {
        this.sintpln = sintpln;
    }

    private String sintws2;

    @javax.persistence.Column(name = "SINTWS2")
    @Basic
    public String getSintws2() {
        return sintws2;
    }

    public void setSintws2(String sintws2) {
        this.sintws2 = sintws2;
    }

    private String sintsln2;

    @javax.persistence.Column(name = "SINTSLN2")
    @Basic
    public String getSintsln2() {
        return sintsln2;
    }

    public void setSintsln2(String sintsln2) {
        this.sintsln2 = sintsln2;
    }

    private String sintpln2;

    @javax.persistence.Column(name = "SINTPLN2")
    @Basic
    public String getSintpln2() {
        return sintpln2;
    }

    public void setSintpln2(String sintpln2) {
        this.sintpln2 = sintpln2;
    }

    private String shous1;

    @javax.persistence.Column(name = "SHOUS1")
    @Basic
    public String getShous1() {
        return shous1;
    }

    public void setShous1(String shous1) {
        this.shous1 = shous1;
    }

    private String shous2;

    @javax.persistence.Column(name = "SHOUS2")
    @Basic
    public String getShous2() {
        return shous2;
    }

    public void setShous2(String shous2) {
        this.shous2 = shous2;
    }

    private String shous3;

    @javax.persistence.Column(name = "SHOUS3")
    @Basic
    public String getShous3() {
        return shous3;
    }

    public void setShous3(String shous3) {
        this.shous3 = shous3;
    }

    private String shous4;

    @javax.persistence.Column(name = "SHOUS4")
    @Basic
    public String getShous4() {
        return shous4;
    }

    public void setShous4(String shous4) {
        this.shous4 = shous4;
    }

    private String shous5;

    @javax.persistence.Column(name = "SHOUS5")
    @Basic
    public String getShous5() {
        return shous5;
    }

    public void setShous5(String shous5) {
        this.shous5 = shous5;
    }

    private String shous6;

    @javax.persistence.Column(name = "SHOUS6")
    @Basic
    public String getShous6() {
        return shous6;
    }

    public void setShous6(String shous6) {
        this.shous6 = shous6;
    }

    private String shous21;

    @javax.persistence.Column(name = "SHOUS21")
    @Basic
    public String getShous21() {
        return shous21;
    }

    public void setShous21(String shous21) {
        this.shous21 = shous21;
    }

    private String shous22;

    @javax.persistence.Column(name = "SHOUS22")
    @Basic
    public String getShous22() {
        return shous22;
    }

    public void setShous22(String shous22) {
        this.shous22 = shous22;
    }

    private String shous23;

    @javax.persistence.Column(name = "SHOUS23")
    @Basic
    public String getShous23() {
        return shous23;
    }

    public void setShous23(String shous23) {
        this.shous23 = shous23;
    }

    private String shous24;

    @javax.persistence.Column(name = "SHOUS24")
    @Basic
    public String getShous24() {
        return shous24;
    }

    public void setShous24(String shous24) {
        this.shous24 = shous24;
    }

    private String shous25;

    @javax.persistence.Column(name = "SHOUS25")
    @Basic
    public String getShous25() {
        return shous25;
    }

    public void setShous25(String shous25) {
        this.shous25 = shous25;
    }

    private String shous26;

    @javax.persistence.Column(name = "SHOUS26")
    @Basic
    public String getShous26() {
        return shous26;
    }

    public void setShous26(String shous26) {
        this.shous26 = shous26;
    }

    private String born02;

    @javax.persistence.Column(name = "BORN02")
    @Basic
    public String getBorn02() {
        return born02;
    }

    public void setBorn02(String born02) {
        this.born02 = born02;
    }

    private String gradpro2;

    @javax.persistence.Column(name = "GRADPRO2")
    @Basic
    public String getGradpro2() {
        return gradpro2;
    }

    public void setGradpro2(String gradpro2) {
        this.gradpro2 = gradpro2;
    }

    private String smrtlst2;

    @javax.persistence.Column(name = "SMRTLST2")
    @Basic
    public String getSmrtlst2() {
        return smrtlst2;
    }

    public void setSmrtlst2(String smrtlst2) {
        this.smrtlst2 = smrtlst2;
    }

    private String orphwd2;

    @javax.persistence.Column(name = "ORPHWD2")
    @Basic
    public String getOrphwd2() {
        return orphwd2;
    }

    public void setOrphwd2(String orphwd2) {
        this.orphwd2 = orphwd2;
    }

    private String lgldep2;

    @javax.persistence.Column(name = "LGLDEP2")
    @Basic
    public String getLgldep2() {
        return lgldep2;
    }

    public void setLgldep2(String lgldep2) {
        this.lgldep2 = lgldep2;
    }

    private String sigsp2;

    @javax.persistence.Column(name = "SIGSP2")
    @Basic
    public String getSigsp2() {
        return sigsp2;
    }

    public void setSigsp2(String sigsp2) {
        this.sigsp2 = sigsp2;
    }

    private String sigf2;

    @javax.persistence.Column(name = "SIGF2")
    @Basic
    public String getSigf2() {
        return sigf2;
    }

    public void setSigf2(String sigf2) {
        this.sigf2 = sigf2;
    }

    private String sigm2;

    @javax.persistence.Column(name = "SIGM2")
    @Basic
    public String getSigm2() {
        return sigm2;
    }

    public void setSigm2(String sigm2) {
        this.sigm2 = sigm2;
    }

    private String fdepdoc2;

    @javax.persistence.Column(name = "FDEPDOC2")
    @Basic
    public String getFdepdoc2() {
        return fdepdoc2;
    }

    public void setFdepdoc2(String fdepdoc2) {
        this.fdepdoc2 = fdepdoc2;
    }

    private String ssreg;

    @javax.persistence.Column(name = "SSREG")
    @Basic
    public String getSsreg() {
        return ssreg;
    }

    public void setSsreg(String ssreg) {
        this.ssreg = ssreg;
    }

    private String ssnmch;

    @javax.persistence.Column(name = "SSNMCH")
    @Basic
    public String getSsnmch() {
        return ssnmch;
    }

    public void setSsnmch(String ssnmch) {
        this.ssnmch = ssnmch;
    }

    private String gamch;

    @javax.persistence.Column(name = "GAMCH")
    @Basic
    public String getGamch() {
        return gamch;
    }

    public void setGamch(String gamch) {
        this.gamch = gamch;
    }

    private String tivmch;

    @javax.persistence.Column(name = "TIVMCH")
    @Basic
    public String getTivmch() {
        return tivmch;
    }

    public void setTivmch(String tivmch) {
        this.tivmch = tivmch;
    }

    private String tivregn;

    @javax.persistence.Column(name = "TIVREGN")
    @Basic
    public String getTivregn() {
        return tivregn;
    }

    public void setTivregn(String tivregn) {
        this.tivregn = tivregn;
    }

    private String nsldsm;

    @javax.persistence.Column(name = "NSLDSM")
    @Basic
    public String getNsldsm() {
        return nsldsm;
    }

    public void setNsldsm(String nsldsm) {
        this.nsldsm = nsldsm;
    }

    private String zefc;

    @javax.persistence.Column(name = "ZEFC")
    @Basic
    public String getZefc() {
        return zefc;
    }

    public void setZefc(String zefc) {
        this.zefc = zefc;
    }

    private String formtyp;

    @javax.persistence.Column(name = "FORMTYP")
    @Basic
    public String getFormtyp() {
        return formtyp;
    }

    public void setFormtyp(String formtyp) {
        this.formtyp = formtyp;
    }

    private String verityp;

    @javax.persistence.Column(name = "VERITYP")
    @Basic
    public String getVerityp() {
        return verityp;
    }

    public void setVerityp(String verityp) {
        this.verityp = verityp;
    }

    private String verinbr;

    @javax.persistence.Column(name = "VERINBR")
    @Basic
    public String getVerinbr() {
        return verinbr;
    }

    public void setVerinbr(String verinbr) {
        this.verinbr = verinbr;
    }

    private BigInteger corrnbr;

    @javax.persistence.Column(name = "CORRNBR")
    @Basic
    public BigInteger getCorrnbr() {
        return corrnbr;
    }

    public void setCorrnbr(BigInteger corrnbr) {
        this.corrnbr = corrnbr;
    }

    private String faatyp;

    @javax.persistence.Column(name = "FAATYP")
    @Basic
    public String getFaatyp() {
        return faatyp;
    }

    public void setFaatyp(String faatyp) {
        this.faatyp = faatyp;
    }

    private String faarst;

    @javax.persistence.Column(name = "FAARST")
    @Basic
    public String getFaarst() {
        return faarst;
    }

    public void setFaarst(String faarst) {
        this.faarst = faarst;
    }

    private String pellelg;

    @javax.persistence.Column(name = "PELLELG")
    @Basic
    public String getPellelg() {
        return pellelg;
    }

    public void setPellelg(String pellelg) {
        this.pellelg = pellelg;
    }

    private String ssreg2;

    @javax.persistence.Column(name = "SSREG2")
    @Basic
    public String getSsreg2() {
        return ssreg2;
    }

    public void setSsreg2(String ssreg2) {
        this.ssreg2 = ssreg2;
    }

    private String ssnmch2;

    @javax.persistence.Column(name = "SSNMCH2")
    @Basic
    public String getSsnmch2() {
        return ssnmch2;
    }

    public void setSsnmch2(String ssnmch2) {
        this.ssnmch2 = ssnmch2;
    }

    private String gamch2;

    @javax.persistence.Column(name = "GAMCH2")
    @Basic
    public String getGamch2() {
        return gamch2;
    }

    public void setGamch2(String gamch2) {
        this.gamch2 = gamch2;
    }

    private String tivmch2;

    @javax.persistence.Column(name = "TIVMCH2")
    @Basic
    public String getTivmch2() {
        return tivmch2;
    }

    public void setTivmch2(String tivmch2) {
        this.tivmch2 = tivmch2;
    }

    private String tivregn2;

    @javax.persistence.Column(name = "TIVREGN2")
    @Basic
    public String getTivregn2() {
        return tivregn2;
    }

    public void setTivregn2(String tivregn2) {
        this.tivregn2 = tivregn2;
    }

    private String nsldsm2;

    @javax.persistence.Column(name = "NSLDSM2")
    @Basic
    public String getNsldsm2() {
        return nsldsm2;
    }

    public void setNsldsm2(String nsldsm2) {
        this.nsldsm2 = nsldsm2;
    }

    private String zefc2;

    @javax.persistence.Column(name = "ZEFC2")
    @Basic
    public String getZefc2() {
        return zefc2;
    }

    public void setZefc2(String zefc2) {
        this.zefc2 = zefc2;
    }

    private String formtyp2;

    @javax.persistence.Column(name = "FORMTYP2")
    @Basic
    public String getFormtyp2() {
        return formtyp2;
    }

    public void setFormtyp2(String formtyp2) {
        this.formtyp2 = formtyp2;
    }

    private String verityp2;

    @javax.persistence.Column(name = "VERITYP2")
    @Basic
    public String getVerityp2() {
        return verityp2;
    }

    public void setVerityp2(String verityp2) {
        this.verityp2 = verityp2;
    }

    private String verinbr2;

    @javax.persistence.Column(name = "VERINBR2")
    @Basic
    public String getVerinbr2() {
        return verinbr2;
    }

    public void setVerinbr2(String verinbr2) {
        this.verinbr2 = verinbr2;
    }

    private BigInteger corrnbr2;

    @javax.persistence.Column(name = "CORRNBR2")
    @Basic
    public BigInteger getCorrnbr2() {
        return corrnbr2;
    }

    public void setCorrnbr2(BigInteger corrnbr2) {
        this.corrnbr2 = corrnbr2;
    }

    private String faatyp2;

    @javax.persistence.Column(name = "FAATYP2")
    @Basic
    public String getFaatyp2() {
        return faatyp2;
    }

    public void setFaatyp2(String faatyp2) {
        this.faatyp2 = faatyp2;
    }

    private String faarst2;

    @javax.persistence.Column(name = "FAARST2")
    @Basic
    public String getFaarst2() {
        return faarst2;
    }

    public void setFaarst2(String faarst2) {
        this.faarst2 = faarst2;
    }

    private String pellelg2;

    @javax.persistence.Column(name = "PELLELG2")
    @Basic
    public String getPellelg2() {
        return pellelg2;
    }

    public void setPellelg2(String pellelg2) {
        this.pellelg2 = pellelg2;
    }

    private String sernum;

    @javax.persistence.Column(name = "SERNUM")
    @Basic
    public String getSernum() {
        return sernum;
    }

    public void setSernum(String sernum) {
        this.sernum = sernum;
    }

    private String admflg;

    @javax.persistence.Column(name = "ADMFLG")
    @Basic
    public String getAdmflg() {
        return admflg;
    }

    public void setAdmflg(String admflg) {
        this.admflg = admflg;
    }

    private String gradflg;

    @javax.persistence.Column(name = "GRADFLG")
    @Basic
    public String getGradflg() {
        return gradflg;
    }

    public void setGradflg(String gradflg) {
        this.gradflg = gradflg;
    }

    private String citind;

    @javax.persistence.Column(name = "CITIND")
    @Basic
    public String getCitind() {
        return citind;
    }

    public void setCitind(String citind) {
        this.citind = citind;
    }

    private String sarcd1;

    @javax.persistence.Column(name = "SARCD1")
    @Basic
    public String getSarcd1() {
        return sarcd1;
    }

    public void setSarcd1(String sarcd1) {
        this.sarcd1 = sarcd1;
    }

    private String sarcd2;

    @javax.persistence.Column(name = "SARCD2")
    @Basic
    public String getSarcd2() {
        return sarcd2;
    }

    public void setSarcd2(String sarcd2) {
        this.sarcd2 = sarcd2;
    }

    private String sarcd3;

    @javax.persistence.Column(name = "SARCD3")
    @Basic
    public String getSarcd3() {
        return sarcd3;
    }

    public void setSarcd3(String sarcd3) {
        this.sarcd3 = sarcd3;
    }

    private String sarcd4;

    @javax.persistence.Column(name = "SARCD4")
    @Basic
    public String getSarcd4() {
        return sarcd4;
    }

    public void setSarcd4(String sarcd4) {
        this.sarcd4 = sarcd4;
    }

    private String sarcd5;

    @javax.persistence.Column(name = "SARCD5")
    @Basic
    public String getSarcd5() {
        return sarcd5;
    }

    public void setSarcd5(String sarcd5) {
        this.sarcd5 = sarcd5;
    }

    private String sarcd6;

    @javax.persistence.Column(name = "SARCD6")
    @Basic
    public String getSarcd6() {
        return sarcd6;
    }

    public void setSarcd6(String sarcd6) {
        this.sarcd6 = sarcd6;
    }

    private String sarcd7;

    @javax.persistence.Column(name = "SARCD7")
    @Basic
    public String getSarcd7() {
        return sarcd7;
    }

    public void setSarcd7(String sarcd7) {
        this.sarcd7 = sarcd7;
    }

    private String sarcd8;

    @javax.persistence.Column(name = "SARCD8")
    @Basic
    public String getSarcd8() {
        return sarcd8;
    }

    public void setSarcd8(String sarcd8) {
        this.sarcd8 = sarcd8;
    }

    private String sarcd9;

    @javax.persistence.Column(name = "SARCD9")
    @Basic
    public String getSarcd9() {
        return sarcd9;
    }

    public void setSarcd9(String sarcd9) {
        this.sarcd9 = sarcd9;
    }

    private String sarcda;

    @javax.persistence.Column(name = "SARCDA")
    @Basic
    public String getSarcda() {
        return sarcda;
    }

    public void setSarcda(String sarcda) {
        this.sarcda = sarcda;
    }

    private String algldep;

    @javax.persistence.Column(name = "ALGLDEP")
    @Basic
    public String getAlgldep() {
        return algldep;
    }

    public void setAlgldep(String algldep) {
        this.algldep = algldep;
    }

    private int sdivinc;

    @javax.persistence.Column(name = "SDIVINC")
    @Basic
    public int getSdivinc() {
        return sdivinc;
    }

    public void setSdivinc(int sdivinc) {
        this.sdivinc = sdivinc;
    }

    private int staxaid;

    @javax.persistence.Column(name = "STAXAID")
    @Basic
    public int getStaxaid() {
        return staxaid;
    }

    public void setStaxaid(int staxaid) {
        this.staxaid = staxaid;
    }

    private int pmonmtg;

    @javax.persistence.Column(name = "PMONMTG")
    @Basic
    public int getPmonmtg() {
        return pmonmtg;
    }

    public void setPmonmtg(int pmonmtg) {
        this.pmonmtg = pmonmtg;
    }

    private int pinvval;

    @javax.persistence.Column(name = "PINVVAL")
    @Basic
    public int getPinvval() {
        return pinvval;
    }

    public void setPinvval(int pinvval) {
        this.pinvval = pinvval;
    }

    private int pinvdbt;

    @javax.persistence.Column(name = "PINVDBT")
    @Basic
    public int getPinvdbt() {
        return pinvdbt;
    }

    public void setPinvdbt(int pinvdbt) {
        this.pinvdbt = pinvdbt;
    }

    private int poreval;

    @javax.persistence.Column(name = "POREVAL")
    @Basic
    public int getPoreval() {
        return poreval;
    }

    public void setPoreval(int poreval) {
        this.poreval = poreval;
    }

    private int poredbt;

    @javax.persistence.Column(name = "POREDBT")
    @Basic
    public int getPoredbt() {
        return poredbt;
    }

    public void setPoredbt(int poredbt) {
        this.poredbt = poredbt;
    }

    private int pwage;

    @javax.persistence.Column(name = "PWAGE")
    @Basic
    public int getPwage() {
        return pwage;
    }

    public void setPwage(int pwage) {
        this.pwage = pwage;
    }

    private int csntxin;

    @javax.persistence.Column(name = "CSNTXIN")
    @Basic
    public int getCsntxin() {
        return csntxin;
    }

    public void setCsntxin(int csntxin) {
        this.csntxin = csntxin;
    }

    private int stotcnt;

    @javax.persistence.Column(name = "STOTCNT")
    @Basic
    public int getStotcnt() {
        return stotcnt;
    }

    public void setStotcnt(int stotcnt) {
        this.stotcnt = stotcnt;
    }

    private int sinv;

    @javax.persistence.Column(name = "SINV")
    @Basic
    public int getSinv() {
        return sinv;
    }

    public void setSinv(int sinv) {
        this.sinv = sinv;
    }

    private int ncuscon;

    @javax.persistence.Column(name = "NCUSCON")
    @Basic
    public int getNcuscon() {
        return ncuscon;
    }

    public void setNcuscon(int ncuscon) {
        this.ncuscon = ncuscon;
    }

    private int fti;

    @javax.persistence.Column(name = "FTI")
    @Basic
    public int getFti() {
        return fti;
    }

    public void setFti(int fti) {
        this.fti = fti;
    }

    private int umpc;

    @javax.persistence.Column(name = "UMPC")
    @Basic
    public int getUmpc() {
        return umpc;
    }

    public void setUmpc(int umpc) {
        this.umpc = umpc;
    }

    private int umsc;

    @javax.persistence.Column(name = "UMSC")
    @Basic
    public int getUmsc() {
        return umsc;
    }

    public void setUmsc(int umsc) {
        this.umsc = umsc;
    }

    private int umefc;

    @javax.persistence.Column(name = "UMEFC")
    @Basic
    public int getUmefc() {
        return umefc;
    }

    public void setUmefc(int umefc) {
        this.umefc = umefc;
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

        Snb2Entity that = (Snb2Entity) o;

        if (csntxin != that.csntxin) return false;
        if (fti != that.fti) return false;
        if (ncuscon != that.ncuscon) return false;
        if (osai != that.osai) return false;
        if (pagi != that.pagi) return false;
        if (pajgt9 != that.pajgt9) return false;
        if (pajgt92 != that.pajgt92) return false;
        if (pajgt94 != that.pajgt94) return false;
        if (pajgt95 != that.pajgt95) return false;
        if (pajlt9 != that.pajlt9) return false;
        if (pajlt92 != that.pajlt92) return false;
        if (pajlt94 != that.pajlt94) return false;
        if (pajlt95 != that.pajlt95) return false;
        if (pcadj != that.pcadj) return false;
        if (pcadj2 != that.pcadj2) return false;
        if (pcadj4 != that.pcadj4) return false;
        if (pcadj5 != that.pcadj5) return false;
        if (pcloss != that.pcloss) return false;
        if (pcloss2 != that.pcloss2) return false;
        if (pcloss4 != that.pcloss4) return false;
        if (pcloss5 != that.pcloss5) return false;
        if (pindex != that.pindex) return false;
        if (pinvdbt != that.pinvdbt) return false;
        if (pinvval != that.pinvval) return false;
        if (pmonmtg != that.pmonmtg) return false;
        if (poredbt != that.poredbt) return false;
        if (poreval != that.poreval) return false;
        if (ppcona != that.ppcona) return false;
        if (ppcona2 != that.ppcona2) return false;
        if (ppcona4 != that.ppcona4) return false;
        if (ppcona5 != that.ppcona5) return false;
        if (ppconf != that.ppconf) return false;
        if (ppconf2 != that.ppconf2) return false;
        if (ppconi != that.ppconi) return false;
        if (ppconi2 != that.ppconi2) return false;
        if (ppconi4 != that.ppconi4) return false;
        if (ppconi5 != that.ppconi5) return false;
        if (ppcont4 != that.ppcont4) return false;
        if (ppcont5 != that.ppcont5) return false;
        if (pscona != that.pscona) return false;
        if (pscona2 != that.pscona2) return false;
        if (pscona4 != that.pscona4) return false;
        if (pscona5 != that.pscona5) return false;
        if (psconf != that.psconf) return false;
        if (psconf2 != that.psconf2) return false;
        if (psconi != that.psconi) return false;
        if (psconi2 != that.psconi2) return false;
        if (psconi4 != that.psconi4) return false;
        if (psconi5 != that.psconi5) return false;
        if (pscont4 != that.pscont4) return false;
        if (pscont5 != that.pscont5) return false;
        if (ptfcf != that.ptfcf) return false;
        if (ptfcf2 != that.ptfcf2) return false;
        if (ptfci4 != that.ptfci4) return false;
        if (ptfci5 != that.ptfci5) return false;
        if (pwage != that.pwage) return false;
        if (saagi != that.saagi) return false;
        if (sajgt9 != that.sajgt9) return false;
        if (sajgt92 != that.sajgt92) return false;
        if (sajgt94 != that.sajgt94) return false;
        if (sajgt95 != that.sajgt95) return false;
        if (sajlt9 != that.sajlt9) return false;
        if (sajlt92 != that.sajlt92) return false;
        if (sajlt94 != that.sajlt94) return false;
        if (sajlt95 != that.sajlt95) return false;
        if (savaba != that.savaba) return false;
        if (scpy != that.scpy) return false;
        if (scpy2 != that.scpy2) return false;
        if (scpy4 != that.scpy4) return false;
        if (scpy5 != that.scpy5) return false;
        if (sdivinc != that.sdivinc) return false;
        if (sinv != that.sinv) return false;
        if (spcona != that.spcona) return false;
        if (spcona2 != that.spcona2) return false;
        if (spcona4 != that.spcona4) return false;
        if (spcona5 != that.spcona5) return false;
        if (spconf != that.spconf) return false;
        if (spconf2 != that.spconf2) return false;
        if (spconi != that.spconi) return false;
        if (spconi2 != that.spconi2) return false;
        if (spconi4 != that.spconi4) return false;
        if (spconi5 != that.spconi5) return false;
        if (spcont4 != that.spcont4) return false;
        if (spcont5 != that.spcont5) return false;
        if (sscona != that.sscona) return false;
        if (sscona2 != that.sscona2) return false;
        if (sscona4 != that.sscona4) return false;
        if (sscona5 != that.sscona5) return false;
        if (ssconf != that.ssconf) return false;
        if (ssconf2 != that.ssconf2) return false;
        if (ssconi != that.ssconi) return false;
        if (ssconi2 != that.ssconi2) return false;
        if (ssconi4 != that.ssconi4) return false;
        if (ssconi5 != that.ssconi5) return false;
        if (sscont4 != that.sscont4) return false;
        if (sscont5 != that.sscont5) return false;
        if (staxaid != that.staxaid) return false;
        if (stfcf != that.stfcf) return false;
        if (stfcf2 != that.stfcf2) return false;
        if (stfci4 != that.stfci4) return false;
        if (stfci5 != that.stfci5) return false;
        if (stotcnt != that.stotcnt) return false;
        if (umefc != that.umefc) return false;
        if (umpc != that.umpc) return false;
        if (umsc != that.umsc) return false;
        if (admflg != null ? !admflg.equals(that.admflg) : that.admflg != null) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (algldep != null ? !algldep.equals(that.algldep) : that.algldep != null) return false;
        if (born02 != null ? !born02.equals(that.born02) : that.born02 != null) return false;
        if (citind != null ? !citind.equals(that.citind) : that.citind != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (comm1 != null ? !comm1.equals(that.comm1) : that.comm1 != null) return false;
        if (comm2 != null ? !comm2.equals(that.comm2) : that.comm2 != null) return false;
        if (comm3 != null ? !comm3.equals(that.comm3) : that.comm3 != null) return false;
        if (comm4 != null ? !comm4.equals(that.comm4) : that.comm4 != null) return false;
        if (comm5 != null ? !comm5.equals(that.comm5) : that.comm5 != null) return false;
        if (corrnbr != null ? !corrnbr.equals(that.corrnbr) : that.corrnbr != null) return false;
        if (corrnbr2 != null ? !corrnbr2.equals(that.corrnbr2) : that.corrnbr2 != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (faarst != null ? !faarst.equals(that.faarst) : that.faarst != null) return false;
        if (faarst2 != null ? !faarst2.equals(that.faarst2) : that.faarst2 != null) return false;
        if (faatyp != null ? !faatyp.equals(that.faatyp) : that.faatyp != null) return false;
        if (faatyp2 != null ? !faatyp2.equals(that.faatyp2) : that.faatyp2 != null) return false;
        if (fdepdoc2 != null ? !fdepdoc2.equals(that.fdepdoc2) : that.fdepdoc2 != null) return false;
        if (formtyp != null ? !formtyp.equals(that.formtyp) : that.formtyp != null) return false;
        if (formtyp2 != null ? !formtyp2.equals(that.formtyp2) : that.formtyp2 != null) return false;
        if (gamch != null ? !gamch.equals(that.gamch) : that.gamch != null) return false;
        if (gamch2 != null ? !gamch2.equals(that.gamch2) : that.gamch2 != null) return false;
        if (gradflg != null ? !gradflg.equals(that.gradflg) : that.gradflg != null) return false;
        if (gradpro2 != null ? !gradpro2.equals(that.gradpro2) : that.gradpro2 != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (lgldep2 != null ? !lgldep2.equals(that.lgldep2) : that.lgldep2 != null) return false;
        if (major2 != null ? !major2.equals(that.major2) : that.major2 != null) return false;
        if (nsldsm != null ? !nsldsm.equals(that.nsldsm) : that.nsldsm != null) return false;
        if (nsldsm2 != null ? !nsldsm2.equals(that.nsldsm2) : that.nsldsm2 != null) return false;
        if (orphwd2 != null ? !orphwd2.equals(that.orphwd2) : that.orphwd2 != null) return false;
        if (pcover != null ? !pcover.equals(that.pcover) : that.pcover != null) return false;
        if (pdegree != null ? !pdegree.equals(that.pdegree) : that.pdegree != null) return false;
        if (pdegree2 != null ? !pdegree2.equals(that.pdegree2) : that.pdegree2 != null) return false;
        if (pellelg != null ? !pellelg.equals(that.pellelg) : that.pellelg != null) return false;
        if (pellelg2 != null ? !pellelg2.equals(that.pellelg2) : that.pellelg2 != null) return false;
        if (pgid != null ? !pgid.equals(that.pgid) : that.pgid != null) return false;
        if (pgidsf != null ? !pgidsf.equals(that.pgidsf) : that.pgidsf != null) return false;
        if (pgtrnnr != null ? !pgtrnnr.equals(that.pgtrnnr) : that.pgtrnnr != null) return false;
        if (psizhhd != null ? !psizhhd.equals(that.psizhhd) : that.psizhhd != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (revrsn != null ? !revrsn.equals(that.revrsn) : that.revrsn != null) return false;
        if (saddr != null ? !saddr.equals(that.saddr) : that.saddr != null) return false;
        if (samecol2 != null ? !samecol2.equals(that.samecol2) : that.samecol2 != null) return false;
        if (sarcd1 != null ? !sarcd1.equals(that.sarcd1) : that.sarcd1 != null) return false;
        if (sarcd2 != null ? !sarcd2.equals(that.sarcd2) : that.sarcd2 != null) return false;
        if (sarcd3 != null ? !sarcd3.equals(that.sarcd3) : that.sarcd3 != null) return false;
        if (sarcd4 != null ? !sarcd4.equals(that.sarcd4) : that.sarcd4 != null) return false;
        if (sarcd5 != null ? !sarcd5.equals(that.sarcd5) : that.sarcd5 != null) return false;
        if (sarcd6 != null ? !sarcd6.equals(that.sarcd6) : that.sarcd6 != null) return false;
        if (sarcd7 != null ? !sarcd7.equals(that.sarcd7) : that.sarcd7 != null) return false;
        if (sarcd8 != null ? !sarcd8.equals(that.sarcd8) : that.sarcd8 != null) return false;
        if (sarcd9 != null ? !sarcd9.equals(that.sarcd9) : that.sarcd9 != null) return false;
        if (sarcda != null ? !sarcda.equals(that.sarcda) : that.sarcda != null) return false;
        if (scity != null ? !scity.equals(that.scity) : that.scity != null) return false;
        if (scover != null ? !scover.equals(that.scover) : that.scover != null) return false;
        if (sernum != null ? !sernum.equals(that.sernum) : that.sernum != null) return false;
        if (sfatt2 != null ? !sfatt2.equals(that.sfatt2) : that.sfatt2 != null) return false;
        if (sfatt3 != null ? !sfatt3.equals(that.sfatt3) : that.sfatt3 != null) return false;
        if (sfatt4 != null ? !sfatt4.equals(that.sfatt4) : that.sfatt4 != null) return false;
        if (sfatt5 != null ? !sfatt5.equals(that.sfatt5) : that.sfatt5 != null) return false;
        if (sfatt6 != null ? !sfatt6.equals(that.sfatt6) : that.sfatt6 != null) return false;
        if (sfatt7 != null ? !sfatt7.equals(that.sfatt7) : that.sfatt7 != null) return false;
        if (sfatt8 != null ? !sfatt8.equals(that.sfatt8) : that.sfatt8 != null) return false;
        if (sfrel2 != null ? !sfrel2.equals(that.sfrel2) : that.sfrel2 != null) return false;
        if (sfrel3 != null ? !sfrel3.equals(that.sfrel3) : that.sfrel3 != null) return false;
        if (sfrel4 != null ? !sfrel4.equals(that.sfrel4) : that.sfrel4 != null) return false;
        if (sfrel5 != null ? !sfrel5.equals(that.sfrel5) : that.sfrel5 != null) return false;
        if (sfrel6 != null ? !sfrel6.equals(that.sfrel6) : that.sfrel6 != null) return false;
        if (sfrel7 != null ? !sfrel7.equals(that.sfrel7) : that.sfrel7 != null) return false;
        if (sfrel8 != null ? !sfrel8.equals(that.sfrel8) : that.sfrel8 != null) return false;
        if (shous1 != null ? !shous1.equals(that.shous1) : that.shous1 != null) return false;
        if (shous2 != null ? !shous2.equals(that.shous2) : that.shous2 != null) return false;
        if (shous21 != null ? !shous21.equals(that.shous21) : that.shous21 != null) return false;
        if (shous22 != null ? !shous22.equals(that.shous22) : that.shous22 != null) return false;
        if (shous23 != null ? !shous23.equals(that.shous23) : that.shous23 != null) return false;
        if (shous24 != null ? !shous24.equals(that.shous24) : that.shous24 != null) return false;
        if (shous25 != null ? !shous25.equals(that.shous25) : that.shous25 != null) return false;
        if (shous26 != null ? !shous26.equals(that.shous26) : that.shous26 != null) return false;
        if (shous3 != null ? !shous3.equals(that.shous3) : that.shous3 != null) return false;
        if (shous4 != null ? !shous4.equals(that.shous4) : that.shous4 != null) return false;
        if (shous5 != null ? !shous5.equals(that.shous5) : that.shous5 != null) return false;
        if (shous6 != null ? !shous6.equals(that.shous6) : that.shous6 != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (sigf2 != null ? !sigf2.equals(that.sigf2) : that.sigf2 != null) return false;
        if (sigm2 != null ? !sigm2.equals(that.sigm2) : that.sigm2 != null) return false;
        if (sigsp2 != null ? !sigsp2.equals(that.sigsp2) : that.sigsp2 != null) return false;
        if (sintpln != null ? !sintpln.equals(that.sintpln) : that.sintpln != null) return false;
        if (sintpln2 != null ? !sintpln2.equals(that.sintpln2) : that.sintpln2 != null) return false;
        if (sintsln != null ? !sintsln.equals(that.sintsln) : that.sintsln != null) return false;
        if (sintsln2 != null ? !sintsln2.equals(that.sintsln2) : that.sintsln2 != null) return false;
        if (sintws != null ? !sintws.equals(that.sintws) : that.sintws != null) return false;
        if (sintws2 != null ? !sintws2.equals(that.sintws2) : that.sintws2 != null) return false;
        if (smaritl != null ? !smaritl.equals(that.smaritl) : that.smaritl != null) return false;
        if (smrtlst != null ? !smrtlst.equals(that.smrtlst) : that.smrtlst != null) return false;
        if (smrtlst2 != null ? !smrtlst2.equals(that.smrtlst2) : that.smrtlst2 != null) return false;
        if (snaclr != null ? !snaclr.equals(that.snaclr) : that.snaclr != null) return false;
        if (snbkey != null ? !snbkey.equals(that.snbkey) : that.snbkey != null) return false;
        if (spssn != null ? !spssn.equals(that.spssn) : that.spssn != null) return false;
        if (ssizhhd != null ? !ssizhhd.equals(that.ssizhhd) : that.ssizhhd != null) return false;
        if (ssnmch != null ? !ssnmch.equals(that.ssnmch) : that.ssnmch != null) return false;
        if (ssnmch2 != null ? !ssnmch2.equals(that.ssnmch2) : that.ssnmch2 != null) return false;
        if (sspcol != null ? !sspcol.equals(that.sspcol) : that.sspcol != null) return false;
        if (ssreg != null ? !ssreg.equals(that.ssreg) : that.ssreg != null) return false;
        if (ssreg2 != null ? !ssreg2.equals(that.ssreg2) : that.ssreg2 != null) return false;
        if (sstate != null ? !sstate.equals(that.sstate) : that.sstate != null) return false;
        if (stitle != null ? !stitle.equals(that.stitle) : that.stitle != null) return false;
        if (szip != null ? !szip.equals(that.szip) : that.szip != null) return false;
        if (tivmch != null ? !tivmch.equals(that.tivmch) : that.tivmch != null) return false;
        if (tivmch2 != null ? !tivmch2.equals(that.tivmch2) : that.tivmch2 != null) return false;
        if (tivregn != null ? !tivregn.equals(that.tivregn) : that.tivregn != null) return false;
        if (tivregn2 != null ? !tivregn2.equals(that.tivregn2) : that.tivregn2 != null) return false;
        if (trmem != null ? !trmem.equals(that.trmem) : that.trmem != null) return false;
        if (ver != null ? !ver.equals(that.ver) : that.ver != null) return false;
        if (verinbr != null ? !verinbr.equals(that.verinbr) : that.verinbr != null) return false;
        if (verinbr2 != null ? !verinbr2.equals(that.verinbr2) : that.verinbr2 != null) return false;
        if (verityp != null ? !verityp.equals(that.verityp) : that.verityp != null) return false;
        if (verityp2 != null ? !verityp2.equals(that.verityp2) : that.verityp2 != null) return false;
        if (verrsns != null ? !verrsns.equals(that.verrsns) : that.verrsns != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;
        if (zefc != null ? !zefc.equals(that.zefc) : that.zefc != null) return false;
        if (zefc2 != null ? !zefc2.equals(that.zefc2) : that.zefc2 != null) return false;

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
        result = 31 * result + pscona;
        result = 31 * result + psconi;
        result = 31 * result + psconf;
        result = 31 * result + ppcona;
        result = 31 * result + ppconi;
        result = 31 * result + ppconf;
        result = 31 * result + ptfcf;
        result = 31 * result + sscona;
        result = 31 * result + ssconi;
        result = 31 * result + ssconf;
        result = 31 * result + spcona;
        result = 31 * result + spconi;
        result = 31 * result + spconf;
        result = 31 * result + stfcf;
        result = 31 * result + pcadj;
        result = 31 * result + pcloss;
        result = 31 * result + scpy;
        result = 31 * result + pajlt9;
        result = 31 * result + pajgt9;
        result = 31 * result + sajlt9;
        result = 31 * result + sajgt9;
        result = 31 * result + pscona2;
        result = 31 * result + psconi2;
        result = 31 * result + psconf2;
        result = 31 * result + ppcona2;
        result = 31 * result + ppconi2;
        result = 31 * result + ppconf2;
        result = 31 * result + ptfcf2;
        result = 31 * result + sscona2;
        result = 31 * result + ssconi2;
        result = 31 * result + ssconf2;
        result = 31 * result + spcona2;
        result = 31 * result + spconi2;
        result = 31 * result + spconf2;
        result = 31 * result + stfcf2;
        result = 31 * result + pcadj2;
        result = 31 * result + pcloss2;
        result = 31 * result + scpy2;
        result = 31 * result + pajlt92;
        result = 31 * result + pajgt92;
        result = 31 * result + sajlt92;
        result = 31 * result + sajgt92;
        result = 31 * result + savaba;
        result = 31 * result + (smaritl != null ? smaritl.hashCode() : 0);
        result = 31 * result + (smrtlst != null ? smrtlst.hashCode() : 0);
        result = 31 * result + (ssizhhd != null ? ssizhhd.hashCode() : 0);
        result = 31 * result + (psizhhd != null ? psizhhd.hashCode() : 0);
        result = 31 * result + saagi;
        result = 31 * result + pagi;
        result = 31 * result + pscona4;
        result = 31 * result + psconi4;
        result = 31 * result + pscont4;
        result = 31 * result + ppcona4;
        result = 31 * result + ppconi4;
        result = 31 * result + ppcont4;
        result = 31 * result + ptfci4;
        result = 31 * result + sscona4;
        result = 31 * result + ssconi4;
        result = 31 * result + sscont4;
        result = 31 * result + spcona4;
        result = 31 * result + spconi4;
        result = 31 * result + spcont4;
        result = 31 * result + stfci4;
        result = 31 * result + pcadj4;
        result = 31 * result + pcloss4;
        result = 31 * result + scpy4;
        result = 31 * result + pajlt94;
        result = 31 * result + pajgt94;
        result = 31 * result + sajlt94;
        result = 31 * result + sajgt94;
        result = 31 * result + pscona5;
        result = 31 * result + psconi5;
        result = 31 * result + pscont5;
        result = 31 * result + ppcona5;
        result = 31 * result + ppconi5;
        result = 31 * result + ppcont5;
        result = 31 * result + ptfci5;
        result = 31 * result + sscona5;
        result = 31 * result + ssconi5;
        result = 31 * result + sscont5;
        result = 31 * result + spcona5;
        result = 31 * result + spconi5;
        result = 31 * result + spcont5;
        result = 31 * result + stfci5;
        result = 31 * result + pcadj5;
        result = 31 * result + pcloss5;
        result = 31 * result + scpy5;
        result = 31 * result + pajlt95;
        result = 31 * result + pajgt95;
        result = 31 * result + sajlt95;
        result = 31 * result + sajgt95;
        result = 31 * result + osai;
        result = 31 * result + (scover != null ? scover.hashCode() : 0);
        result = 31 * result + (pcover != null ? pcover.hashCode() : 0);
        result = 31 * result + (revrsn != null ? revrsn.hashCode() : 0);
        result = 31 * result + (verrsns != null ? verrsns.hashCode() : 0);
        result = 31 * result + (ver != null ? ver.hashCode() : 0);
        result = 31 * result + (snaclr != null ? snaclr.hashCode() : 0);
        result = 31 * result + (trmem != null ? trmem.hashCode() : 0);
        result = 31 * result + (comm1 != null ? comm1.hashCode() : 0);
        result = 31 * result + (comm2 != null ? comm2.hashCode() : 0);
        result = 31 * result + (comm3 != null ? comm3.hashCode() : 0);
        result = 31 * result + (comm4 != null ? comm4.hashCode() : 0);
        result = 31 * result + (comm5 != null ? comm5.hashCode() : 0);
        result = 31 * result + (pgid != null ? pgid.hashCode() : 0);
        result = 31 * result + (pgidsf != null ? pgidsf.hashCode() : 0);
        result = 31 * result + (pgtrnnr != null ? pgtrnnr.hashCode() : 0);
        result = 31 * result + (sspcol != null ? sspcol.hashCode() : 0);
        result = 31 * result + (spssn != null ? spssn.hashCode() : 0);
        result = 31 * result + (sfrel2 != null ? sfrel2.hashCode() : 0);
        result = 31 * result + (sfatt2 != null ? sfatt2.hashCode() : 0);
        result = 31 * result + (sfrel3 != null ? sfrel3.hashCode() : 0);
        result = 31 * result + (sfatt3 != null ? sfatt3.hashCode() : 0);
        result = 31 * result + (sfrel4 != null ? sfrel4.hashCode() : 0);
        result = 31 * result + (sfatt4 != null ? sfatt4.hashCode() : 0);
        result = 31 * result + (sfrel5 != null ? sfrel5.hashCode() : 0);
        result = 31 * result + (sfatt5 != null ? sfatt5.hashCode() : 0);
        result = 31 * result + (sfrel6 != null ? sfrel6.hashCode() : 0);
        result = 31 * result + (sfatt6 != null ? sfatt6.hashCode() : 0);
        result = 31 * result + (sfrel7 != null ? sfrel7.hashCode() : 0);
        result = 31 * result + (sfatt7 != null ? sfatt7.hashCode() : 0);
        result = 31 * result + (sfrel8 != null ? sfrel8.hashCode() : 0);
        result = 31 * result + (sfatt8 != null ? sfatt8.hashCode() : 0);
        result = 31 * result + (saddr != null ? saddr.hashCode() : 0);
        result = 31 * result + (scity != null ? scity.hashCode() : 0);
        result = 31 * result + (sstate != null ? sstate.hashCode() : 0);
        result = 31 * result + (szip != null ? szip.hashCode() : 0);
        result = 31 * result + (stitle != null ? stitle.hashCode() : 0);
        result = 31 * result + (pdegree != null ? pdegree.hashCode() : 0);
        result = 31 * result + (pdegree2 != null ? pdegree2.hashCode() : 0);
        result = 31 * result + (samecol2 != null ? samecol2.hashCode() : 0);
        result = 31 * result + (major2 != null ? major2.hashCode() : 0);
        result = 31 * result + pindex;
        result = 31 * result + (sintws != null ? sintws.hashCode() : 0);
        result = 31 * result + (sintsln != null ? sintsln.hashCode() : 0);
        result = 31 * result + (sintpln != null ? sintpln.hashCode() : 0);
        result = 31 * result + (sintws2 != null ? sintws2.hashCode() : 0);
        result = 31 * result + (sintsln2 != null ? sintsln2.hashCode() : 0);
        result = 31 * result + (sintpln2 != null ? sintpln2.hashCode() : 0);
        result = 31 * result + (shous1 != null ? shous1.hashCode() : 0);
        result = 31 * result + (shous2 != null ? shous2.hashCode() : 0);
        result = 31 * result + (shous3 != null ? shous3.hashCode() : 0);
        result = 31 * result + (shous4 != null ? shous4.hashCode() : 0);
        result = 31 * result + (shous5 != null ? shous5.hashCode() : 0);
        result = 31 * result + (shous6 != null ? shous6.hashCode() : 0);
        result = 31 * result + (shous21 != null ? shous21.hashCode() : 0);
        result = 31 * result + (shous22 != null ? shous22.hashCode() : 0);
        result = 31 * result + (shous23 != null ? shous23.hashCode() : 0);
        result = 31 * result + (shous24 != null ? shous24.hashCode() : 0);
        result = 31 * result + (shous25 != null ? shous25.hashCode() : 0);
        result = 31 * result + (shous26 != null ? shous26.hashCode() : 0);
        result = 31 * result + (born02 != null ? born02.hashCode() : 0);
        result = 31 * result + (gradpro2 != null ? gradpro2.hashCode() : 0);
        result = 31 * result + (smrtlst2 != null ? smrtlst2.hashCode() : 0);
        result = 31 * result + (orphwd2 != null ? orphwd2.hashCode() : 0);
        result = 31 * result + (lgldep2 != null ? lgldep2.hashCode() : 0);
        result = 31 * result + (sigsp2 != null ? sigsp2.hashCode() : 0);
        result = 31 * result + (sigf2 != null ? sigf2.hashCode() : 0);
        result = 31 * result + (sigm2 != null ? sigm2.hashCode() : 0);
        result = 31 * result + (fdepdoc2 != null ? fdepdoc2.hashCode() : 0);
        result = 31 * result + (ssreg != null ? ssreg.hashCode() : 0);
        result = 31 * result + (ssnmch != null ? ssnmch.hashCode() : 0);
        result = 31 * result + (gamch != null ? gamch.hashCode() : 0);
        result = 31 * result + (tivmch != null ? tivmch.hashCode() : 0);
        result = 31 * result + (tivregn != null ? tivregn.hashCode() : 0);
        result = 31 * result + (nsldsm != null ? nsldsm.hashCode() : 0);
        result = 31 * result + (zefc != null ? zefc.hashCode() : 0);
        result = 31 * result + (formtyp != null ? formtyp.hashCode() : 0);
        result = 31 * result + (verityp != null ? verityp.hashCode() : 0);
        result = 31 * result + (verinbr != null ? verinbr.hashCode() : 0);
        result = 31 * result + (corrnbr != null ? corrnbr.hashCode() : 0);
        result = 31 * result + (faatyp != null ? faatyp.hashCode() : 0);
        result = 31 * result + (faarst != null ? faarst.hashCode() : 0);
        result = 31 * result + (pellelg != null ? pellelg.hashCode() : 0);
        result = 31 * result + (ssreg2 != null ? ssreg2.hashCode() : 0);
        result = 31 * result + (ssnmch2 != null ? ssnmch2.hashCode() : 0);
        result = 31 * result + (gamch2 != null ? gamch2.hashCode() : 0);
        result = 31 * result + (tivmch2 != null ? tivmch2.hashCode() : 0);
        result = 31 * result + (tivregn2 != null ? tivregn2.hashCode() : 0);
        result = 31 * result + (nsldsm2 != null ? nsldsm2.hashCode() : 0);
        result = 31 * result + (zefc2 != null ? zefc2.hashCode() : 0);
        result = 31 * result + (formtyp2 != null ? formtyp2.hashCode() : 0);
        result = 31 * result + (verityp2 != null ? verityp2.hashCode() : 0);
        result = 31 * result + (verinbr2 != null ? verinbr2.hashCode() : 0);
        result = 31 * result + (corrnbr2 != null ? corrnbr2.hashCode() : 0);
        result = 31 * result + (faatyp2 != null ? faatyp2.hashCode() : 0);
        result = 31 * result + (faarst2 != null ? faarst2.hashCode() : 0);
        result = 31 * result + (pellelg2 != null ? pellelg2.hashCode() : 0);
        result = 31 * result + (sernum != null ? sernum.hashCode() : 0);
        result = 31 * result + (admflg != null ? admflg.hashCode() : 0);
        result = 31 * result + (gradflg != null ? gradflg.hashCode() : 0);
        result = 31 * result + (citind != null ? citind.hashCode() : 0);
        result = 31 * result + (sarcd1 != null ? sarcd1.hashCode() : 0);
        result = 31 * result + (sarcd2 != null ? sarcd2.hashCode() : 0);
        result = 31 * result + (sarcd3 != null ? sarcd3.hashCode() : 0);
        result = 31 * result + (sarcd4 != null ? sarcd4.hashCode() : 0);
        result = 31 * result + (sarcd5 != null ? sarcd5.hashCode() : 0);
        result = 31 * result + (sarcd6 != null ? sarcd6.hashCode() : 0);
        result = 31 * result + (sarcd7 != null ? sarcd7.hashCode() : 0);
        result = 31 * result + (sarcd8 != null ? sarcd8.hashCode() : 0);
        result = 31 * result + (sarcd9 != null ? sarcd9.hashCode() : 0);
        result = 31 * result + (sarcda != null ? sarcda.hashCode() : 0);
        result = 31 * result + (algldep != null ? algldep.hashCode() : 0);
        result = 31 * result + sdivinc;
        result = 31 * result + staxaid;
        result = 31 * result + pmonmtg;
        result = 31 * result + pinvval;
        result = 31 * result + pinvdbt;
        result = 31 * result + poreval;
        result = 31 * result + poredbt;
        result = 31 * result + pwage;
        result = 31 * result + csntxin;
        result = 31 * result + stotcnt;
        result = 31 * result + sinv;
        result = 31 * result + ncuscon;
        result = 31 * result + fti;
        result = 31 * result + umpc;
        result = 31 * result + umsc;
        result = 31 * result + umefc;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
