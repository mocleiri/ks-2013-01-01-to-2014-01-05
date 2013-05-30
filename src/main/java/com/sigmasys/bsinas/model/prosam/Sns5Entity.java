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
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNS5", schema = "SIGMA", catalog = "")
@Entity
public class Sns5Entity implements Identifiable {

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

    private String saaavics;

    @javax.persistence.Column(name = "SAAAVICS")
    @Basic
    public String getSaaavics() {
        return saaavics;
    }

    public void setSaaavics(String saaavics) {
        this.saaavics = saaavics;
    }

    private String savbacs;

    @javax.persistence.Column(name = "SAVBACS")
    @Basic
    public String getSavbacs() {
        return savbacs;
    }

    public void setSavbacs(String savbacs) {
        this.savbacs = savbacs;
    }

    private String sconftcs;

    @javax.persistence.Column(name = "SCONFTCS")
    @Basic
    public String getSconftcs() {
        return sconftcs;
    }

    public void setSconftcs(String sconftcs) {
        this.sconftcs = sconftcs;
    }

    private String sconfncs;

    @javax.persistence.Column(name = "SCONFNCS")
    @Basic
    public String getSconfncs() {
        return sconfncs;
    }

    public void setSconfncs(String sconfncs) {
        this.sconfncs = sconfncs;
    }

    private String sconfcs;

    @javax.persistence.Column(name = "SCONFCS")
    @Basic
    public String getSconfcs() {
        return sconfcs;
    }

    public void setSconfcs(String sconfcs) {
        this.sconfcs = sconfcs;
    }

    private String sdwagcs;

    @javax.persistence.Column(name = "SDWAGCS")
    @Basic
    public String getSdwagcs() {
        return sdwagcs;
    }

    public void setSdwagcs(String sdwagcs) {
        this.sdwagcs = sdwagcs;
    }

    private String sdspswcs;

    @javax.persistence.Column(name = "SDSPSWCS")
    @Basic
    public String getSdspswcs() {
        return sdspswcs;
    }

    public void setSdspswcs(String sdspswcs) {
        this.sdspswcs = sdspswcs;
    }

    private String sdotics;

    @javax.persistence.Column(name = "SDOTICS")
    @Basic
    public String getSdotics() {
        return sdotics;
    }

    public void setSdotics(String sdotics) {
        this.sdotics = sdotics;
    }

    private String sdntics;

    @javax.persistence.Column(name = "SDNTICS")
    @Basic
    public String getSdntics() {
        return sdntics;
    }

    public void setSdntics(String sdntics) {
        this.sdntics = sdntics;
    }

    private String sdvabncs;

    @javax.persistence.Column(name = "SDVABNCS")
    @Basic
    public String getSdvabncs() {
        return sdvabncs;
    }

    public void setSdvabncs(String sdvabncs) {
        this.sdvabncs = sdvabncs;
    }

    private String sdtinccs;

    @javax.persistence.Column(name = "SDTINCCS")
    @Basic
    public String getSdtinccs() {
        return sdtinccs;
    }

    public void setSdtinccs(String sdtinccs) {
        this.sdtinccs = sdtinccs;
    }

    private String sbwagcs;

    @javax.persistence.Column(name = "SBWAGCS")
    @Basic
    public String getSbwagcs() {
        return sbwagcs;
    }

    public void setSbwagcs(String sbwagcs) {
        this.sbwagcs = sbwagcs;
    }

    private String scwagcs;

    @javax.persistence.Column(name = "SCWAGCS")
    @Basic
    public String getScwagcs() {
        return scwagcs;
    }

    public void setScwagcs(String scwagcs) {
        this.scwagcs = scwagcs;
    }

    private String sbspswcs;

    @javax.persistence.Column(name = "SBSPSWCS")
    @Basic
    public String getSbspswcs() {
        return sbspswcs;
    }

    public void setSbspswcs(String sbspswcs) {
        this.sbspswcs = sbspswcs;
    }

    private String scspswcs;

    @javax.persistence.Column(name = "SCSPSWCS")
    @Basic
    public String getScspswcs() {
        return scspswcs;
    }

    public void setScspswcs(String scspswcs) {
        this.scspswcs = scspswcs;
    }

    private String sbotics;

    @javax.persistence.Column(name = "SBOTICS")
    @Basic
    public String getSbotics() {
        return sbotics;
    }

    public void setSbotics(String sbotics) {
        this.sbotics = sbotics;
    }

    private String scotics;

    @javax.persistence.Column(name = "SCOTICS")
    @Basic
    public String getScotics() {
        return scotics;
    }

    public void setScotics(String scotics) {
        this.scotics = scotics;
    }

    private String sbntics;

    @javax.persistence.Column(name = "SBNTICS")
    @Basic
    public String getSbntics() {
        return sbntics;
    }

    public void setSbntics(String sbntics) {
        this.sbntics = sbntics;
    }

    private String scntics;

    @javax.persistence.Column(name = "SCNTICS")
    @Basic
    public String getScntics() {
        return scntics;
    }

    public void setScntics(String scntics) {
        this.scntics = scntics;
    }

    private String sctinccs;

    @javax.persistence.Column(name = "SCTINCCS")
    @Basic
    public String getSctinccs() {
        return sctinccs;
    }

    public void setSctinccs(String sctinccs) {
        this.sctinccs = sctinccs;
    }

    private String sddedcs;

    @javax.persistence.Column(name = "SDDEDCS")
    @Basic
    public String getSddedcs() {
        return sddedcs;
    }

    public void setSddedcs(String sddedcs) {
        this.sddedcs = sddedcs;
    }

    private String sditxxcs;

    @javax.persistence.Column(name = "SDITXXCS")
    @Basic
    public String getSditxxcs() {
        return sditxxcs;
    }

    public void setSditxxcs(String sditxxcs) {
        this.sditxxcs = sditxxcs;
    }

    private String sditxccs;

    @javax.persistence.Column(name = "SDITXCCS")
    @Basic
    public String getSditxccs() {
        return sditxccs;
    }

    public void setSditxccs(String sditxccs) {
        this.sditxccs = sditxccs;
    }

    private String sditxucs;

    @javax.persistence.Column(name = "SDITXUCS")
    @Basic
    public String getSditxucs() {
        return sditxucs;
    }

    public void setSditxucs(String sditxucs) {
        this.sditxucs = sditxucs;
    }

    private String sdficacs;

    @javax.persistence.Column(name = "SDFICACS")
    @Basic
    public String getSdficacs() {
        return sdficacs;
    }

    public void setSdficacs(String sdficacs) {
        this.sdficacs = sdficacs;
    }

    private String sdsttxcs;

    @javax.persistence.Column(name = "SDSTTXCS")
    @Basic
    public String getSdsttxcs() {
        return sdsttxcs;
    }

    public void setSdsttxcs(String sdsttxcs) {
        this.sdsttxcs = sdsttxcs;
    }

    private String sdmedxcs;

    @javax.persistence.Column(name = "SDMEDXCS")
    @Basic
    public String getSdmedxcs() {
        return sdmedxcs;
    }

    public void setSdmedxcs(String sdmedxcs) {
        this.sdmedxcs = sdmedxcs;
    }

    private String sdmedccs;

    @javax.persistence.Column(name = "SDMEDCCS")
    @Basic
    public String getSdmedccs() {
        return sdmedccs;
    }

    public void setSdmedccs(String sdmedccs) {
        this.sdmedccs = sdmedccs;
    }

    private String sdtutacs;

    @javax.persistence.Column(name = "SDTUTACS")
    @Basic
    public String getSdtutacs() {
        return sdtutacs;
    }

    public void setSdtutacs(String sdtutacs) {
        this.sdtutacs = sdtutacs;
    }

    private String sdemalcs;

    @javax.persistence.Column(name = "SDEMALCS")
    @Basic
    public String getSdemalcs() {
        return sdemalcs;
    }

    public void setSdemalcs(String sdemalcs) {
        this.sdemalcs = sdemalcs;
    }

    private String sdsmacs;

    @javax.persistence.Column(name = "SDSMACS")
    @Basic
    public String getSdsmacs() {
        return sdsmacs;
    }

    public void setSdsmacs(String sdsmacs) {
        this.sdsmacs = sdsmacs;
    }

    private String sdial1Cs;

    @javax.persistence.Column(name = "SDIAL1CS")
    @Basic
    public String getSdial1Cs() {
        return sdial1Cs;
    }

    public void setSdial1Cs(String sdial1Cs) {
        this.sdial1Cs = sdial1Cs;
    }

    private String sdial2Cs;

    @javax.persistence.Column(name = "SDIAL2CS")
    @Basic
    public String getSdial2Cs() {
        return sdial2Cs;
    }

    public void setSdial2Cs(String sdial2Cs) {
        this.sdial2Cs = sdial2Cs;
    }

    private String sdtalocs;

    @javax.persistence.Column(name = "SDTALOCS")
    @Basic
    public String getSdtalocs() {
        return sdtalocs;
    }

    public void setSdtalocs(String sdtalocs) {
        this.sdtalocs = sdtalocs;
    }

    private String sdefincs;

    @javax.persistence.Column(name = "SDEFINCS")
    @Basic
    public String getSdefincs() {
        return sdefincs;
    }

    public void setSdefincs(String sdefincs) {
        this.sdefincs = sdefincs;
    }

    private String sexcldcs;

    @javax.persistence.Column(name = "SEXCLDCS")
    @Basic
    public String getSexcldcs() {
        return sexcldcs;
    }

    public void setSexcldcs(String sexcldcs) {
        this.sexcldcs = sexcldcs;
    }

    private String shvconcs;

    @javax.persistence.Column(name = "SHVCONCS")
    @Basic
    public String getShvconcs() {
        return shvconcs;
    }

    public void setShvconcs(String shvconcs) {
        this.shvconcs = shvconcs;
    }

    private String stotstcs;

    @javax.persistence.Column(name = "STOTSTCS")
    @Basic
    public String getStotstcs() {
        return stotstcs;
    }

    public void setStotstcs(String stotstcs) {
        this.stotstcs = stotstcs;
    }

    private String srctstcs;

    @javax.persistence.Column(name = "SRCTSTCS")
    @Basic
    public String getSrctstcs() {
        return srctstcs;
    }

    public void setSrctstcs(String srctstcs) {
        this.srctstcs = srctstcs;
    }

    private String sinccrcs;

    @javax.persistence.Column(name = "SINCCRCS")
    @Basic
    public String getSinccrcs() {
        return sinccrcs;
    }

    public void setSinccrcs(String sinccrcs) {
        this.sinccrcs = sinccrcs;
    }

    private String seqnum1;

    @javax.persistence.Column(name = "SEQNUM1")
    @Basic
    public String getSeqnum1() {
        return seqnum1;
    }

    public void setSeqnum1(String seqnum1) {
        this.seqnum1 = seqnum1;
    }

    private String schcod1;

    @javax.persistence.Column(name = "SCHCOD1")
    @Basic
    public String getSchcod1() {
        return schcod1;
    }

    public void setSchcod1(String schcod1) {
        this.schcod1 = schcod1;
    }

    private String seqnum2;

    @javax.persistence.Column(name = "SEQNUM2")
    @Basic
    public String getSeqnum2() {
        return seqnum2;
    }

    public void setSeqnum2(String seqnum2) {
        this.seqnum2 = seqnum2;
    }

    private String schcod2;

    @javax.persistence.Column(name = "SCHCOD2")
    @Basic
    public String getSchcod2() {
        return schcod2;
    }

    public void setSchcod2(String schcod2) {
        this.schcod2 = schcod2;
    }

    private String primhcs;

    @javax.persistence.Column(name = "PRIMHCS")
    @Basic
    public String getPrimhcs() {
        return primhcs;
    }

    public void setPrimhcs(String primhcs) {
        this.primhcs = primhcs;
    }

    private String pawa1Cs;

    @javax.persistence.Column(name = "PAWA1CS")
    @Basic
    public String getPawa1Cs() {
        return pawa1Cs;
    }

    public void setPawa1Cs(String pawa1Cs) {
        this.pawa1Cs = pawa1Cs;
    }

    private String pawa2Cs;

    @javax.persistence.Column(name = "PAWA2CS")
    @Basic
    public String getPawa2Cs() {
        return pawa2Cs;
    }

    public void setPawa2Cs(String pawa2Cs) {
        this.pawa2Cs = pawa2Cs;
    }

    private String pawa3Cs;

    @javax.persistence.Column(name = "PAWA3CS")
    @Basic
    public String getPawa3Cs() {
        return pawa3Cs;
    }

    public void setPawa3Cs(String pawa3Cs) {
        this.pawa3Cs = pawa3Cs;
    }

    private String psreacs;

    @javax.persistence.Column(name = "PSREACS")
    @Basic
    public String getPsreacs() {
        return psreacs;
    }

    public void setPsreacs(String psreacs) {
        this.psreacs = psreacs;
    }

    private String drugccs;

    @javax.persistence.Column(name = "DRUGCCS")
    @Basic
    public String getDrugccs() {
        return drugccs;
    }

    public void setDrugccs(String drugccs) {
        this.drugccs = drugccs;
    }

    private String santx1L;

    @javax.persistence.Column(name = "SANTX1L")
    @Basic
    public String getSantx1L() {
        return santx1L;
    }

    public void setSantx1L(String santx1L) {
        this.santx1L = santx1L;
    }

    private String santx2L;

    @javax.persistence.Column(name = "SANTX2L")
    @Basic
    public String getSantx2L() {
        return santx2L;
    }

    public void setSantx2L(String santx2L) {
        this.santx2L = santx2L;
    }

    private String saial1L;

    @javax.persistence.Column(name = "SAIAL1L")
    @Basic
    public String getSaial1L() {
        return saial1L;
    }

    public void setSaial1L(String saial1L) {
        this.saial1L = saial1L;
    }

    private String saial2L;

    @javax.persistence.Column(name = "SAIAL2L")
    @Basic
    public String getSaial2L() {
        return saial2L;
    }

    public void setSaial2L(String saial2L) {
        this.saial2L = saial2L;
    }

    private String sdial1L;

    @javax.persistence.Column(name = "SDIAL1L")
    @Basic
    public String getSdial1L() {
        return sdial1L;
    }

    public void setSdial1L(String sdial1L) {
        this.sdial1L = sdial1L;
    }

    private String sdial2L;

    @javax.persistence.Column(name = "SDIAL2L")
    @Basic
    public String getSdial2L() {
        return sdial2L;
    }

    public void setSdial2L(String sdial2L) {
        this.sdial2L = sdial2L;
    }

    private String sassadl;

    @javax.persistence.Column(name = "SASSADL")
    @Basic
    public String getSassadl() {
        return sassadl;
    }

    public void setSassadl(String sassadl) {
        this.sassadl = sassadl;
    }

    private String lstupdt1;

    @javax.persistence.Column(name = "LSTUPDT1")
    @Basic
    public String getLstupdt1() {
        return lstupdt1;
    }

    public void setLstupdt1(String lstupdt1) {
        this.lstupdt1 = lstupdt1;
    }

    private int schdamt1;

    @javax.persistence.Column(name = "SCHDAMT1")
    @Basic
    public int getSchdamt1() {
        return schdamt1;
    }

    public void setSchdamt1(int schdamt1) {
        this.schdamt1 = schdamt1;
    }

    private int amtptdt1;

    @javax.persistence.Column(name = "AMTPTDT1")
    @Basic
    public int getAmtptdt1() {
        return amtptdt1;
    }

    public void setAmtptdt1(int amtptdt1) {
        this.amtptdt1 = amtptdt1;
    }

    private String lstupdt2;

    @javax.persistence.Column(name = "LSTUPDT2")
    @Basic
    public String getLstupdt2() {
        return lstupdt2;
    }

    public void setLstupdt2(String lstupdt2) {
        this.lstupdt2 = lstupdt2;
    }

    private int schdamt2;

    @javax.persistence.Column(name = "SCHDAMT2")
    @Basic
    public int getSchdamt2() {
        return schdamt2;
    }

    public void setSchdamt2(int schdamt2) {
        this.schdamt2 = schdamt2;
    }

    private int amtptdt2;

    @javax.persistence.Column(name = "AMTPTDT2")
    @Basic
    public int getAmtptdt2() {
        return amtptdt2;
    }

    public void setAmtptdt2(int amtptdt2) {
        this.amtptdt2 = amtptdt2;
    }

    private String depstf;

    @javax.persistence.Column(name = "DEPSTF")
    @Basic
    public String getDepstf() {
        return depstf;
    }

    public void setDepstf(String depstf) {
        this.depstf = depstf;
    }

    private String ptyp;

    @javax.persistence.Column(name = "PTYP")
    @Basic
    public String getPtyp() {
        return ptyp;
    }

    public void setPtyp(String ptyp) {
        this.ptyp = ptyp;
    }

    private String styp;

    @javax.persistence.Column(name = "STYP")
    @Basic
    public String getStyp() {
        return styp;
    }

    public void setStyp(String styp) {
        this.styp = styp;
    }

    private String depsti;

    @javax.persistence.Column(name = "DEPSTI")
    @Basic
    public String getDepsti() {
        return depsti;
    }

    public void setDepsti(String depsti) {
        this.depsti = depsti;
    }

    private String iptyp;

    @javax.persistence.Column(name = "IPTYP")
    @Basic
    public String getIptyp() {
        return iptyp;
    }

    public void setIptyp(String iptyp) {
        this.iptyp = iptyp;
    }

    private String istyp;

    @javax.persistence.Column(name = "ISTYP")
    @Basic
    public String getIstyp() {
        return istyp;
    }

    public void setIstyp(String istyp) {
        this.istyp = istyp;
    }

    private int psai;

    @javax.persistence.Column(name = "PSAI")
    @Basic
    public int getPsai() {
        return psai;
    }

    public void setPsai(int psai) {
        this.psai = psai;
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

    private int ipsaia;

    @javax.persistence.Column(name = "IPSAIA")
    @Basic
    public int getIpsaia() {
        return ipsaia;
    }

    public void setIpsaia(int ipsaia) {
        this.ipsaia = ipsaia;
    }

    private int iptfcfw;

    @javax.persistence.Column(name = "IPTFCFW")
    @Basic
    public int getIptfcfw() {
        return iptfcfw;
    }

    public void setIptfcfw(int iptfcfw) {
        this.iptfcfw = iptfcfw;
    }

    private String trannum1;

    @javax.persistence.Column(name = "TRANNUM1")
    @Basic
    public String getTrannum1() {
        return trannum1;
    }

    public void setTrannum1(String trannum1) {
        this.trannum1 = trannum1;
    }

    private String trannum2;

    @javax.persistence.Column(name = "TRANNUM2")
    @Basic
    public String getTrannum2() {
        return trannum2;
    }

    public void setTrannum2(String trannum2) {
        this.trannum2 = trannum2;
    }

    private int nasaitx;

    @javax.persistence.Column(name = "NASAITX")
    @Basic
    public int getNasaitx() {
        return nasaitx;
    }

    public void setNasaitx(int nasaitx) {
        this.nasaitx = nasaitx;
    }

    private int nasass;

    @javax.persistence.Column(name = "NASASS")
    @Basic
    public int getNasass() {
        return nasass;
    }

    public void setNasass(int nasass) {
        this.nasass = nasass;
    }

    private int nasaadc;

    @javax.persistence.Column(name = "NASAADC")
    @Basic
    public int getNasaadc() {
        return nasaadc;
    }

    public void setNasaadc(int nasaadc) {
        this.nasaadc = nasaadc;
    }

    private int nasacs;

    @javax.persistence.Column(name = "NASACS")
    @Basic
    public int getNasacs() {
        return nasacs;
    }

    public void setNasacs(int nasacs) {
        this.nasacs = nasacs;
    }

    private int nasoriv;

    @javax.persistence.Column(name = "NASORIV")
    @Basic
    public int getNasoriv() {
        return nasoriv;
    }

    public void setNasoriv(int nasoriv) {
        this.nasoriv = nasoriv;
    }

    private int nasbfv;

    @javax.persistence.Column(name = "NASBFV")
    @Basic
    public int getNasbfv() {
        return nasbfv;
    }

    public void setNasbfv(int nasbfv) {
        this.nasbfv = nasbfv;
    }

    private int nasfrmv;

    @javax.persistence.Column(name = "NASFRMV")
    @Basic
    public int getNasfrmv() {
        return nasfrmv;
    }

    public void setNasfrmv(int nasfrmv) {
        this.nasfrmv = nasfrmv;
    }

    private int nasdwag;

    @javax.persistence.Column(name = "NASDWAG")
    @Basic
    public int getNasdwag() {
        return nasdwag;
    }

    public void setNasdwag(int nasdwag) {
        this.nasdwag = nasdwag;
    }

    private int cavlinc;

    @javax.persistence.Column(name = "CAVLINC")
    @Basic
    public int getCavlinc() {
        return cavlinc;
    }

    public void setCavlinc(int cavlinc) {
        this.cavlinc = cavlinc;
    }

    private String batno;

    @javax.persistence.Column(name = "BATNO")
    @Basic
    public String getBatno() {
        return batno;
    }

    public void setBatno(String batno) {
        this.batno = batno;
    }

    private int dupseq;

    @javax.persistence.Column(name = "DUPSEQ")
    @Basic
    public int getDupseq() {
        return dupseq;
    }

    public void setDupseq(int dupseq) {
        this.dupseq = dupseq;
    }

    private int chgseq;

    @javax.persistence.Column(name = "CHGSEQ")
    @Basic
    public int getChgseq() {
        return chgseq;
    }

    public void setChgseq(int chgseq) {
        this.chgseq = chgseq;
    }

    private String cbatno;

    @javax.persistence.Column(name = "CBATNO")
    @Basic
    public String getCbatno() {
        return cbatno;
    }

    public void setCbatno(String cbatno) {
        this.cbatno = cbatno;
    }

    private String dbatno;

    @javax.persistence.Column(name = "DBATNO")
    @Basic
    public String getDbatno() {
        return dbatno;
    }

    public void setDbatno(String dbatno) {
        this.dbatno = dbatno;
    }

    private int rmamtpy1;

    @javax.persistence.Column(name = "RMAMTPY1")
    @Basic
    public int getRmamtpy1() {
        return rmamtpy1;
    }

    public void setRmamtpy1(int rmamtpy1) {
        this.rmamtpy1 = rmamtpy1;
    }

    private int prcntus1;

    @javax.persistence.Column(name = "PRCNTUS1")
    @Basic
    public int getPrcntus1() {
        return prcntus1;
    }

    public void setPrcntus1(int prcntus1) {
        this.prcntus1 = prcntus1;
    }

    private int rmamtpy2;

    @javax.persistence.Column(name = "RMAMTPY2")
    @Basic
    public int getRmamtpy2() {
        return rmamtpy2;
    }

    public void setRmamtpy2(int rmamtpy2) {
        this.rmamtpy2 = rmamtpy2;
    }

    private int prcntus2;

    @javax.persistence.Column(name = "PRCNTUS2")
    @Basic
    public int getPrcntus2() {
        return prcntus2;
    }

    public void setPrcntus2(int prcntus2) {
        this.prcntus2 = prcntus2;
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

    private int s2Onti;

    @javax.persistence.Column(name = "S2ONTI")
    @Basic
    public int getS2Onti() {
        return s2Onti;
    }

    public void setS2Onti(int s2Onti) {
        this.s2Onti = s2Onti;
    }

    private int s2Onti2;

    @javax.persistence.Column(name = "S2ONTI2")
    @Basic
    public int getS2Onti2() {
        return s2Onti2;
    }

    public void setS2Onti2(int s2Onti2) {
        this.s2Onti2 = s2Onti2;
    }

    private int s2Ontic;

    @javax.persistence.Column(name = "S2ONTIC")
    @Basic
    public int getS2Ontic() {
        return s2Ontic;
    }

    public void setS2Ontic(int s2Ontic) {
        this.s2Ontic = s2Ontic;
    }

    private String s2Ontis;

    @javax.persistence.Column(name = "S2ONTIS")
    @Basic
    public String getS2Ontis() {
        return s2Ontis;
    }

    public void setS2Ontis(String s2Ontis) {
        this.s2Ontis = s2Ontis;
    }

    private String s2Ontics;

    @javax.persistence.Column(name = "S2ONTICS")
    @Basic
    public String getS2Ontics() {
        return s2Ontics;
    }

    public void setS2Ontics(String s2Ontics) {
        this.s2Ontics = s2Ontics;
    }

    private String psred1;

    @javax.persistence.Column(name = "PSRED1")
    @Basic
    public String getPsred1() {
        return psred1;
    }

    public void setPsred1(String psred1) {
        this.psred1 = psred1;
    }

    private String psred2;

    @javax.persistence.Column(name = "PSRED2")
    @Basic
    public String getPsred2() {
        return psred2;
    }

    public void setPsred2(String psred2) {
        this.psred2 = psred2;
    }

    private String psred3;

    @javax.persistence.Column(name = "PSRED3")
    @Basic
    public String getPsred3() {
        return psred3;
    }

    public void setPsred3(String psred3) {
        this.psred3 = psred3;
    }

    private String psred12;

    @javax.persistence.Column(name = "PSRED12")
    @Basic
    public String getPsred12() {
        return psred12;
    }

    public void setPsred12(String psred12) {
        this.psred12 = psred12;
    }

    private String psred22;

    @javax.persistence.Column(name = "PSRED22")
    @Basic
    public String getPsred22() {
        return psred22;
    }

    public void setPsred22(String psred22) {
        this.psred22 = psred22;
    }

    private String psred32;

    @javax.persistence.Column(name = "PSRED32")
    @Basic
    public String getPsred32() {
        return psred32;
    }

    public void setPsred32(String psred32) {
        this.psred32 = psred32;
    }

    private String emadtp;

    @javax.persistence.Column(name = "EMADTP")
    @Basic
    public String getEmadtp() {
        return emadtp;
    }

    public void setEmadtp(String emadtp) {
        this.emadtp = emadtp;
    }

    private String emadtp2;

    @javax.persistence.Column(name = "EMADTP2")
    @Basic
    public String getEmadtp2() {
        return emadtp2;
    }

    public void setEmadtp2(String emadtp2) {
        this.emadtp2 = emadtp2;
    }

    private String emadtps;

    @javax.persistence.Column(name = "EMADTPS")
    @Basic
    public String getEmadtps() {
        return emadtps;
    }

    public void setEmadtps(String emadtps) {
        this.emadtps = emadtps;
    }

    private String sssib;

    @javax.persistence.Column(name = "SSSIB")
    @Basic
    public String getSssib() {
        return sssib;
    }

    public void setSssib(String sssib) {
        this.sssib = sssib;
    }

    private String sfsb;

    @javax.persistence.Column(name = "SFSB")
    @Basic
    public String getSfsb() {
        return sfsb;
    }

    public void setSfsb(String sfsb) {
        this.sfsb = sfsb;
    }

    private String sflb;

    @javax.persistence.Column(name = "SFLB")
    @Basic
    public String getSflb() {
        return sflb;
    }

    public void setSflb(String sflb) {
        this.sflb = sflb;
    }

    private String stanf;

    @javax.persistence.Column(name = "STANF")
    @Basic
    public String getStanf() {
        return stanf;
    }

    public void setStanf(String stanf) {
        this.stanf = stanf;
    }

    private String swic;

    @javax.persistence.Column(name = "SWIC")
    @Basic
    public String getSwic() {
        return swic;
    }

    public void setSwic(String swic) {
        this.swic = swic;
    }

    private String sssib2;

    @javax.persistence.Column(name = "SSSIB2")
    @Basic
    public String getSssib2() {
        return sssib2;
    }

    public void setSssib2(String sssib2) {
        this.sssib2 = sssib2;
    }

    private String sfsb2;

    @javax.persistence.Column(name = "SFSB2")
    @Basic
    public String getSfsb2() {
        return sfsb2;
    }

    public void setSfsb2(String sfsb2) {
        this.sfsb2 = sfsb2;
    }

    private String sflb2;

    @javax.persistence.Column(name = "SFLB2")
    @Basic
    public String getSflb2() {
        return sflb2;
    }

    public void setSflb2(String sflb2) {
        this.sflb2 = sflb2;
    }

    private String stanf2;

    @javax.persistence.Column(name = "STANF2")
    @Basic
    public String getStanf2() {
        return stanf2;
    }

    public void setStanf2(String stanf2) {
        this.stanf2 = stanf2;
    }

    private String swic2;

    @javax.persistence.Column(name = "SWIC2")
    @Basic
    public String getSwic2() {
        return swic2;
    }

    public void setSwic2(String swic2) {
        this.swic2 = swic2;
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

    private int scstpd;

    @javax.persistence.Column(name = "SCSTPD")
    @Basic
    public int getScstpd() {
        return scstpd;
    }

    public void setScstpd(int scstpd) {
        this.scstpd = scstpd;
    }

    private int sgtsad;

    @javax.persistence.Column(name = "SGTSAD")
    @Basic
    public int getSgtsad() {
        return sgtsad;
    }

    public void setSgtsad(int sgtsad) {
        this.sgtsad = sgtsad;
    }

    private int scomby;

    @javax.persistence.Column(name = "SCOMBY")
    @Basic
    public int getScomby() {
        return scomby;
    }

    public void setScomby(int scomby) {
        this.scomby = scomby;
    }

    private String shomls;

    @javax.persistence.Column(name = "SHOMLS")
    @Basic
    public String getShomls() {
        return shomls;
    }

    public void setShomls(String shomls) {
        this.shomls = shomls;
    }

    private int scstpd2;

    @javax.persistence.Column(name = "SCSTPD2")
    @Basic
    public int getScstpd2() {
        return scstpd2;
    }

    public void setScstpd2(int scstpd2) {
        this.scstpd2 = scstpd2;
    }

    private int sgtsad2;

    @javax.persistence.Column(name = "SGTSAD2")
    @Basic
    public int getSgtsad2() {
        return sgtsad2;
    }

    public void setSgtsad2(int sgtsad2) {
        this.sgtsad2 = sgtsad2;
    }

    private int scomby2;

    @javax.persistence.Column(name = "SCOMBY2")
    @Basic
    public int getScomby2() {
        return scomby2;
    }

    public void setScomby2(int scomby2) {
        this.scomby2 = scomby2;
    }

    private String shomls2;

    @javax.persistence.Column(name = "SHOMLS2")
    @Basic
    public String getShomls2() {
        return shomls2;
    }

    public void setShomls2(String shomls2) {
        this.shomls2 = shomls2;
    }

    private String scstpds;

    @javax.persistence.Column(name = "SCSTPDS")
    @Basic
    public String getScstpds() {
        return scstpds;
    }

    public void setScstpds(String scstpds) {
        this.scstpds = scstpds;
    }

    private String sgtsads;

    @javax.persistence.Column(name = "SGTSADS")
    @Basic
    public String getSgtsads() {
        return sgtsads;
    }

    public void setSgtsads(String sgtsads) {
        this.sgtsads = sgtsads;
    }

    private String scombys;

    @javax.persistence.Column(name = "SCOMBYS")
    @Basic
    public String getScombys() {
        return scombys;
    }

    public void setScombys(String scombys) {
        this.scombys = scombys;
    }

    private String shomlss;

    @javax.persistence.Column(name = "SHOMLSS")
    @Basic
    public String getShomlss() {
        return shomlss;
    }

    public void setShomlss(String shomlss) {
        this.shomlss = shomlss;
    }

    private String trcswk;

    @javax.persistence.Column(name = "TRCSWK")
    @Basic
    public String getTrcswk() {
        return trcswk;
    }

    public void setTrcswk(String trcswk) {
        this.trcswk = trcswk;
    }

    private int sedcrd;

    @javax.persistence.Column(name = "SEDCRD")
    @Basic
    public int getSedcrd() {
        return sedcrd;
    }

    public void setSedcrd(int sedcrd) {
        this.sedcrd = sedcrd;
    }

    private int snbemp;

    @javax.persistence.Column(name = "SNBEMP")
    @Basic
    public int getSnbemp() {
        return snbemp;
    }

    public void setSnbemp(int snbemp) {
        this.snbemp = snbemp;
    }

    private int spenpy;

    @javax.persistence.Column(name = "SPENPY")
    @Basic
    public int getSpenpy() {
        return spenpy;
    }

    public void setSpenpy(int spenpy) {
        this.spenpy = spenpy;
    }

    private int sirapy;

    @javax.persistence.Column(name = "SIRAPY")
    @Basic
    public int getSirapy() {
        return sirapy;
    }

    public void setSirapy(int sirapy) {
        this.sirapy = sirapy;
    }

    private int sirads;

    @javax.persistence.Column(name = "SIRADS")
    @Basic
    public int getSirads() {
        return sirads;
    }

    public void setSirads(int sirads) {
        this.sirads = sirads;
    }

    private int sutxpn;

    @javax.persistence.Column(name = "SUTXPN")
    @Basic
    public int getSutxpn() {
        return sutxpn;
    }

    public void setSutxpn(int sutxpn) {
        this.sutxpn = sutxpn;
    }

    private int smcall;

    @javax.persistence.Column(name = "SMCALL")
    @Basic
    public int getSmcall() {
        return smcall;
    }

    public void setSmcall(int smcall) {
        this.smcall = smcall;
    }

    private int sornrm;

    @javax.persistence.Column(name = "SORNRM")
    @Basic
    public int getSornrm() {
        return sornrm;
    }

    public void setSornrm(int sornrm) {
        this.sornrm = sornrm;
    }

    private String svarec;

    @javax.persistence.Column(name = "SVAREC")
    @Basic
    public String getSvarec() {
        return svarec;
    }

    public void setSvarec(String svarec) {
        this.svarec = svarec;
    }

    private String svatyp;

    @javax.persistence.Column(name = "SVATYP")
    @Basic
    public String getSvatyp() {
        return svatyp;
    }

    public void setSvatyp(String svatyp) {
        this.svatyp = svatyp;
    }

    private String trcswk2;

    @javax.persistence.Column(name = "TRCSWK2")
    @Basic
    public String getTrcswk2() {
        return trcswk2;
    }

    public void setTrcswk2(String trcswk2) {
        this.trcswk2 = trcswk2;
    }

    private int sedcrd2;

    @javax.persistence.Column(name = "SEDCRD2")
    @Basic
    public int getSedcrd2() {
        return sedcrd2;
    }

    public void setSedcrd2(int sedcrd2) {
        this.sedcrd2 = sedcrd2;
    }

    private int snbemp2;

    @javax.persistence.Column(name = "SNBEMP2")
    @Basic
    public int getSnbemp2() {
        return snbemp2;
    }

    public void setSnbemp2(int snbemp2) {
        this.snbemp2 = snbemp2;
    }

    private int spenpy2;

    @javax.persistence.Column(name = "SPENPY2")
    @Basic
    public int getSpenpy2() {
        return spenpy2;
    }

    public void setSpenpy2(int spenpy2) {
        this.spenpy2 = spenpy2;
    }

    private int sirapy2;

    @javax.persistence.Column(name = "SIRAPY2")
    @Basic
    public int getSirapy2() {
        return sirapy2;
    }

    public void setSirapy2(int sirapy2) {
        this.sirapy2 = sirapy2;
    }

    private int sirads2;

    @javax.persistence.Column(name = "SIRADS2")
    @Basic
    public int getSirads2() {
        return sirads2;
    }

    public void setSirads2(int sirads2) {
        this.sirads2 = sirads2;
    }

    private int sutxpn2;

    @javax.persistence.Column(name = "SUTXPN2")
    @Basic
    public int getSutxpn2() {
        return sutxpn2;
    }

    public void setSutxpn2(int sutxpn2) {
        this.sutxpn2 = sutxpn2;
    }

    private int smcall2;

    @javax.persistence.Column(name = "SMCALL2")
    @Basic
    public int getSmcall2() {
        return smcall2;
    }

    public void setSmcall2(int smcall2) {
        this.smcall2 = smcall2;
    }

    private int sornrm2;

    @javax.persistence.Column(name = "SORNRM2")
    @Basic
    public int getSornrm2() {
        return sornrm2;
    }

    public void setSornrm2(int sornrm2) {
        this.sornrm2 = sornrm2;
    }

    private String svarec2;

    @javax.persistence.Column(name = "SVAREC2")
    @Basic
    public String getSvarec2() {
        return svarec2;
    }

    public void setSvarec2(String svarec2) {
        this.svarec2 = svarec2;
    }

    private String svatyp2;

    @javax.persistence.Column(name = "SVATYP2")
    @Basic
    public String getSvatyp2() {
        return svatyp2;
    }

    public void setSvatyp2(String svatyp2) {
        this.svatyp2 = svatyp2;
    }

    private String trcswks;

    @javax.persistence.Column(name = "TRCSWKS")
    @Basic
    public String getTrcswks() {
        return trcswks;
    }

    public void setTrcswks(String trcswks) {
        this.trcswks = trcswks;
    }

    private String sedcrds;

    @javax.persistence.Column(name = "SEDCRDS")
    @Basic
    public String getSedcrds() {
        return sedcrds;
    }

    public void setSedcrds(String sedcrds) {
        this.sedcrds = sedcrds;
    }

    private String snbemps;

    @javax.persistence.Column(name = "SNBEMPS")
    @Basic
    public String getSnbemps() {
        return snbemps;
    }

    public void setSnbemps(String snbemps) {
        this.snbemps = snbemps;
    }

    private String spenpys;

    @javax.persistence.Column(name = "SPENPYS")
    @Basic
    public String getSpenpys() {
        return spenpys;
    }

    public void setSpenpys(String spenpys) {
        this.spenpys = spenpys;
    }

    private String sirapys;

    @javax.persistence.Column(name = "SIRAPYS")
    @Basic
    public String getSirapys() {
        return sirapys;
    }

    public void setSirapys(String sirapys) {
        this.sirapys = sirapys;
    }

    private String siradss;

    @javax.persistence.Column(name = "SIRADSS")
    @Basic
    public String getSiradss() {
        return siradss;
    }

    public void setSiradss(String siradss) {
        this.siradss = siradss;
    }

    private String sutxpns;

    @javax.persistence.Column(name = "SUTXPNS")
    @Basic
    public String getSutxpns() {
        return sutxpns;
    }

    public void setSutxpns(String sutxpns) {
        this.sutxpns = sutxpns;
    }

    private String smcalls;

    @javax.persistence.Column(name = "SMCALLS")
    @Basic
    public String getSmcalls() {
        return smcalls;
    }

    public void setSmcalls(String smcalls) {
        this.smcalls = smcalls;
    }

    private String sornrms;

    @javax.persistence.Column(name = "SORNRMS")
    @Basic
    public String getSornrms() {
        return sornrms;
    }

    public void setSornrms(String sornrms) {
        this.sornrms = sornrms;
    }

    private String svarecs;

    @javax.persistence.Column(name = "SVARECS")
    @Basic
    public String getSvarecs() {
        return svarecs;
    }

    public void setSvarecs(String svarecs) {
        this.svarecs = svarecs;
    }

    private String svatyps;

    @javax.persistence.Column(name = "SVATYPS")
    @Basic
    public String getSvatyps() {
        return svatyps;
    }

    public void setSvatyps(String svatyps) {
        this.svatyps = svatyps;
    }

    private int soutx;

    @javax.persistence.Column(name = "SOUTX")
    @Basic
    public int getSoutx() {
        return soutx;
    }

    public void setSoutx(int soutx) {
        this.soutx = soutx;
    }

    private int soutx2;

    @javax.persistence.Column(name = "SOUTX2")
    @Basic
    public int getSoutx2() {
        return soutx2;
    }

    public void setSoutx2(int soutx2) {
        this.soutx2 = soutx2;
    }

    private int soutxc;

    @javax.persistence.Column(name = "SOUTXC")
    @Basic
    public int getSoutxc() {
        return soutxc;
    }

    public void setSoutxc(int soutxc) {
        this.soutxc = soutxc;
    }

    private String soutxs;

    @javax.persistence.Column(name = "SOUTXS")
    @Basic
    public String getSoutxs() {
        return soutxs;
    }

    public void setSoutxs(String soutxs) {
        this.soutxs = soutxs;
    }

    private String soutxcs;

    @javax.persistence.Column(name = "SOUTXCS")
    @Basic
    public String getSoutxcs() {
        return soutxcs;
    }

    public void setSoutxcs(String soutxcs) {
        this.soutxcs = soutxcs;
    }

    private int sint;

    @javax.persistence.Column(name = "SINT")
    @Basic
    public int getSint() {
        return sint;
    }

    public void setSint(int sint) {
        this.sint = sint;
    }

    private int sint2;

    @javax.persistence.Column(name = "SINT2")
    @Basic
    public int getSint2() {
        return sint2;
    }

    public void setSint2(int sint2) {
        this.sint2 = sint2;
    }

    private int sintc;

    @javax.persistence.Column(name = "SINTC")
    @Basic
    public int getSintc() {
        return sintc;
    }

    public void setSintc(int sintc) {
        this.sintc = sintc;
    }

    private String sints;

    @javax.persistence.Column(name = "SINTS")
    @Basic
    public String getSints() {
        return sints;
    }

    public void setSints(String sints) {
        this.sints = sints;
    }

    private String sintcs;

    @javax.persistence.Column(name = "SINTCS")
    @Basic
    public String getSintcs() {
        return sintcs;
    }

    public void setSintcs(String sintcs) {
        this.sintcs = sintcs;
    }

    private int scoop;

    @javax.persistence.Column(name = "SCOOP")
    @Basic
    public int getScoop() {
        return scoop;
    }

    public void setScoop(int scoop) {
        this.scoop = scoop;
    }

    private int scoop2;

    @javax.persistence.Column(name = "SCOOP2")
    @Basic
    public int getScoop2() {
        return scoop2;
    }

    public void setScoop2(int scoop2) {
        this.scoop2 = scoop2;
    }

    private int scoopc;

    @javax.persistence.Column(name = "SCOOPC")
    @Basic
    public int getScoopc() {
        return scoopc;
    }

    public void setScoopc(int scoopc) {
        this.scoopc = scoopc;
    }

    private String scoops;

    @javax.persistence.Column(name = "SCOOPS")
    @Basic
    public String getScoops() {
        return scoops;
    }

    public void setScoops(String scoops) {
        this.scoops = scoops;
    }

    private String scoopcs;

    @javax.persistence.Column(name = "SCOOPCS")
    @Basic
    public String getScoopcs() {
        return scoopcs;
    }

    public void setScoopcs(String scoopcs) {
        this.scoopcs = scoopcs;
    }

    private String sirsrq;

    @javax.persistence.Column(name = "SIRSRQ")
    @Basic
    public String getSirsrq() {
        return sirsrq;
    }

    public void setSirsrq(String sirsrq) {
        this.sirsrq = sirsrq;
    }

    private String shomlsc;

    @javax.persistence.Column(name = "SHOMLSC")
    @Basic
    public String getShomlsc() {
        return shomlsc;
    }

    public void setShomlsc(String shomlsc) {
        this.shomlsc = shomlsc;
    }

    private String shmlscs;

    @javax.persistence.Column(name = "SHMLSCS")
    @Basic
    public String getShmlscs() {
        return shmlscs;
    }

    public void setShmlscs(String shmlscs) {
        this.shmlscs = shmlscs;
    }

    private String sathx;

    @javax.persistence.Column(name = "SATHX")
    @Basic
    public String getSathx() {
        return sathx;
    }

    public void setSathx(String sathx) {
        this.sathx = sathx;
    }

    private String sathx2;

    @javax.persistence.Column(name = "SATHX2")
    @Basic
    public String getSathx2() {
        return sathx2;
    }

    public void setSathx2(String sathx2) {
        this.sathx2 = sathx2;
    }

    private String sathxs;

    @javax.persistence.Column(name = "SATHXS")
    @Basic
    public String getSathxs() {
        return sathxs;
    }

    public void setSathxs(String sathxs) {
        this.sathxs = sathxs;
    }

    private String sathxc;

    @javax.persistence.Column(name = "SATHXC")
    @Basic
    public String getSathxc() {
        return sathxc;
    }

    public void setSathxc(String sathxc) {
        this.sathxc = sathxc;
    }

    private String sathxcs;

    @javax.persistence.Column(name = "SATHXCS")
    @Basic
    public String getSathxcs() {
        return sathxcs;
    }

    public void setSathxcs(String sathxcs) {
        this.sathxcs = sathxcs;
    }

    private String asathex;

    @javax.persistence.Column(name = "ASATHEX")
    @Basic
    public String getAsathex() {
        return asathex;
    }

    public void setAsathex(String asathex) {
        this.asathex = asathex;
    }

    private String sfsbs;

    @javax.persistence.Column(name = "SFSBS")
    @Basic
    public String getSfsbs() {
        return sfsbs;
    }

    public void setSfsbs(String sfsbs) {
        this.sfsbs = sfsbs;
    }

    private String sfsbcs;

    @javax.persistence.Column(name = "SFSBCS")
    @Basic
    public String getSfsbcs() {
        return sfsbcs;
    }

    public void setSfsbcs(String sfsbcs) {
        this.sfsbcs = sfsbcs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sns5Entity that = (Sns5Entity) o;

        if (amtptdt1 != that.amtptdt1) return false;
        if (amtptdt2 != that.amtptdt2) return false;
        if (cavlinc != that.cavlinc) return false;
        if (chgseq != that.chgseq) return false;
        if (dupseq != that.dupseq) return false;
        if (ipsaia != that.ipsaia) return false;
        if (iptfcfw != that.iptfcfw) return false;
        if (l41Lev != that.l41Lev) return false;
        if (nasaadc != that.nasaadc) return false;
        if (nasacs != that.nasacs) return false;
        if (nasaitx != that.nasaitx) return false;
        if (nasass != that.nasass) return false;
        if (nasbfv != that.nasbfv) return false;
        if (nasdwag != that.nasdwag) return false;
        if (nasfrmv != that.nasfrmv) return false;
        if (nasoriv != that.nasoriv) return false;
        if (prcntus1 != that.prcntus1) return false;
        if (prcntus2 != that.prcntus2) return false;
        if (psai != that.psai) return false;
        if (ptfcf != that.ptfcf) return false;
        if (rmamtpy1 != that.rmamtpy1) return false;
        if (rmamtpy2 != that.rmamtpy2) return false;
        if (s2Onti != that.s2Onti) return false;
        if (s2Onti2 != that.s2Onti2) return false;
        if (s2Ontic != that.s2Ontic) return false;
        if (schdamt1 != that.schdamt1) return false;
        if (schdamt2 != that.schdamt2) return false;
        if (scomby != that.scomby) return false;
        if (scomby2 != that.scomby2) return false;
        if (scoop != that.scoop) return false;
        if (scoop2 != that.scoop2) return false;
        if (scoopc != that.scoopc) return false;
        if (scstpd != that.scstpd) return false;
        if (scstpd2 != that.scstpd2) return false;
        if (sedcrd != that.sedcrd) return false;
        if (sedcrd2 != that.sedcrd2) return false;
        if (sgtsad != that.sgtsad) return false;
        if (sgtsad2 != that.sgtsad2) return false;
        if (sint != that.sint) return false;
        if (sint2 != that.sint2) return false;
        if (sintc != that.sintc) return false;
        if (sirads != that.sirads) return false;
        if (sirads2 != that.sirads2) return false;
        if (sirapy != that.sirapy) return false;
        if (sirapy2 != that.sirapy2) return false;
        if (smcall != that.smcall) return false;
        if (smcall2 != that.smcall2) return false;
        if (snbemp != that.snbemp) return false;
        if (snbemp2 != that.snbemp2) return false;
        if (sornrm != that.sornrm) return false;
        if (sornrm2 != that.sornrm2) return false;
        if (soutx != that.soutx) return false;
        if (soutx2 != that.soutx2) return false;
        if (soutxc != that.soutxc) return false;
        if (spenpy != that.spenpy) return false;
        if (spenpy2 != that.spenpy2) return false;
        if (sutxpn != that.sutxpn) return false;
        if (sutxpn2 != that.sutxpn2) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (asathex != null ? !asathex.equals(that.asathex) : that.asathex != null) return false;
        if (batno != null ? !batno.equals(that.batno) : that.batno != null) return false;
        if (cbatno != null ? !cbatno.equals(that.cbatno) : that.cbatno != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (dbatno != null ? !dbatno.equals(that.dbatno) : that.dbatno != null) return false;
        if (depstf != null ? !depstf.equals(that.depstf) : that.depstf != null) return false;
        if (depsti != null ? !depsti.equals(that.depsti) : that.depsti != null) return false;
        if (drugccs != null ? !drugccs.equals(that.drugccs) : that.drugccs != null) return false;
        if (emadtp != null ? !emadtp.equals(that.emadtp) : that.emadtp != null) return false;
        if (emadtp2 != null ? !emadtp2.equals(that.emadtp2) : that.emadtp2 != null) return false;
        if (emadtps != null ? !emadtps.equals(that.emadtps) : that.emadtps != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (iptyp != null ? !iptyp.equals(that.iptyp) : that.iptyp != null) return false;
        if (istyp != null ? !istyp.equals(that.istyp) : that.istyp != null) return false;
        if (lstupdt1 != null ? !lstupdt1.equals(that.lstupdt1) : that.lstupdt1 != null) return false;
        if (lstupdt2 != null ? !lstupdt2.equals(that.lstupdt2) : that.lstupdt2 != null) return false;
        if (pawa1Cs != null ? !pawa1Cs.equals(that.pawa1Cs) : that.pawa1Cs != null) return false;
        if (pawa2Cs != null ? !pawa2Cs.equals(that.pawa2Cs) : that.pawa2Cs != null) return false;
        if (pawa3Cs != null ? !pawa3Cs.equals(that.pawa3Cs) : that.pawa3Cs != null) return false;
        if (primhcs != null ? !primhcs.equals(that.primhcs) : that.primhcs != null) return false;
        if (psreacs != null ? !psreacs.equals(that.psreacs) : that.psreacs != null) return false;
        if (psred1 != null ? !psred1.equals(that.psred1) : that.psred1 != null) return false;
        if (psred12 != null ? !psred12.equals(that.psred12) : that.psred12 != null) return false;
        if (psred2 != null ? !psred2.equals(that.psred2) : that.psred2 != null) return false;
        if (psred22 != null ? !psred22.equals(that.psred22) : that.psred22 != null) return false;
        if (psred3 != null ? !psred3.equals(that.psred3) : that.psred3 != null) return false;
        if (psred32 != null ? !psred32.equals(that.psred32) : that.psred32 != null) return false;
        if (ptyp != null ? !ptyp.equals(that.ptyp) : that.ptyp != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (s2Ontics != null ? !s2Ontics.equals(that.s2Ontics) : that.s2Ontics != null) return false;
        if (s2Ontis != null ? !s2Ontis.equals(that.s2Ontis) : that.s2Ontis != null) return false;
        if (saaavics != null ? !saaavics.equals(that.saaavics) : that.saaavics != null) return false;
        if (saial1L != null ? !saial1L.equals(that.saial1L) : that.saial1L != null) return false;
        if (saial2L != null ? !saial2L.equals(that.saial2L) : that.saial2L != null) return false;
        if (santx1L != null ? !santx1L.equals(that.santx1L) : that.santx1L != null) return false;
        if (santx2L != null ? !santx2L.equals(that.santx2L) : that.santx2L != null) return false;
        if (sassadl != null ? !sassadl.equals(that.sassadl) : that.sassadl != null) return false;
        if (sathx != null ? !sathx.equals(that.sathx) : that.sathx != null) return false;
        if (sathx2 != null ? !sathx2.equals(that.sathx2) : that.sathx2 != null) return false;
        if (sathxc != null ? !sathxc.equals(that.sathxc) : that.sathxc != null) return false;
        if (sathxcs != null ? !sathxcs.equals(that.sathxcs) : that.sathxcs != null) return false;
        if (sathxs != null ? !sathxs.equals(that.sathxs) : that.sathxs != null) return false;
        if (savbacs != null ? !savbacs.equals(that.savbacs) : that.savbacs != null) return false;
        if (sbntics != null ? !sbntics.equals(that.sbntics) : that.sbntics != null) return false;
        if (sbotics != null ? !sbotics.equals(that.sbotics) : that.sbotics != null) return false;
        if (sbspswcs != null ? !sbspswcs.equals(that.sbspswcs) : that.sbspswcs != null) return false;
        if (sbwagcs != null ? !sbwagcs.equals(that.sbwagcs) : that.sbwagcs != null) return false;
        if (schcod1 != null ? !schcod1.equals(that.schcod1) : that.schcod1 != null) return false;
        if (schcod2 != null ? !schcod2.equals(that.schcod2) : that.schcod2 != null) return false;
        if (scntics != null ? !scntics.equals(that.scntics) : that.scntics != null) return false;
        if (scombys != null ? !scombys.equals(that.scombys) : that.scombys != null) return false;
        if (sconfcs != null ? !sconfcs.equals(that.sconfcs) : that.sconfcs != null) return false;
        if (sconfncs != null ? !sconfncs.equals(that.sconfncs) : that.sconfncs != null) return false;
        if (sconftcs != null ? !sconftcs.equals(that.sconftcs) : that.sconftcs != null) return false;
        if (scoopcs != null ? !scoopcs.equals(that.scoopcs) : that.scoopcs != null) return false;
        if (scoops != null ? !scoops.equals(that.scoops) : that.scoops != null) return false;
        if (scotics != null ? !scotics.equals(that.scotics) : that.scotics != null) return false;
        if (scspswcs != null ? !scspswcs.equals(that.scspswcs) : that.scspswcs != null) return false;
        if (scstpds != null ? !scstpds.equals(that.scstpds) : that.scstpds != null) return false;
        if (sctinccs != null ? !sctinccs.equals(that.sctinccs) : that.sctinccs != null) return false;
        if (scwagcs != null ? !scwagcs.equals(that.scwagcs) : that.scwagcs != null) return false;
        if (sddedcs != null ? !sddedcs.equals(that.sddedcs) : that.sddedcs != null) return false;
        if (sdefincs != null ? !sdefincs.equals(that.sdefincs) : that.sdefincs != null) return false;
        if (sdemalcs != null ? !sdemalcs.equals(that.sdemalcs) : that.sdemalcs != null) return false;
        if (sdficacs != null ? !sdficacs.equals(that.sdficacs) : that.sdficacs != null) return false;
        if (sdial1Cs != null ? !sdial1Cs.equals(that.sdial1Cs) : that.sdial1Cs != null) return false;
        if (sdial1L != null ? !sdial1L.equals(that.sdial1L) : that.sdial1L != null) return false;
        if (sdial2Cs != null ? !sdial2Cs.equals(that.sdial2Cs) : that.sdial2Cs != null) return false;
        if (sdial2L != null ? !sdial2L.equals(that.sdial2L) : that.sdial2L != null) return false;
        if (sditxccs != null ? !sditxccs.equals(that.sditxccs) : that.sditxccs != null) return false;
        if (sditxucs != null ? !sditxucs.equals(that.sditxucs) : that.sditxucs != null) return false;
        if (sditxxcs != null ? !sditxxcs.equals(that.sditxxcs) : that.sditxxcs != null) return false;
        if (sdmedccs != null ? !sdmedccs.equals(that.sdmedccs) : that.sdmedccs != null) return false;
        if (sdmedxcs != null ? !sdmedxcs.equals(that.sdmedxcs) : that.sdmedxcs != null) return false;
        if (sdntics != null ? !sdntics.equals(that.sdntics) : that.sdntics != null) return false;
        if (sdotics != null ? !sdotics.equals(that.sdotics) : that.sdotics != null) return false;
        if (sdsmacs != null ? !sdsmacs.equals(that.sdsmacs) : that.sdsmacs != null) return false;
        if (sdspswcs != null ? !sdspswcs.equals(that.sdspswcs) : that.sdspswcs != null) return false;
        if (sdsttxcs != null ? !sdsttxcs.equals(that.sdsttxcs) : that.sdsttxcs != null) return false;
        if (sdtalocs != null ? !sdtalocs.equals(that.sdtalocs) : that.sdtalocs != null) return false;
        if (sdtinccs != null ? !sdtinccs.equals(that.sdtinccs) : that.sdtinccs != null) return false;
        if (sdtutacs != null ? !sdtutacs.equals(that.sdtutacs) : that.sdtutacs != null) return false;
        if (sdvabncs != null ? !sdvabncs.equals(that.sdvabncs) : that.sdvabncs != null) return false;
        if (sdwagcs != null ? !sdwagcs.equals(that.sdwagcs) : that.sdwagcs != null) return false;
        if (sedcrds != null ? !sedcrds.equals(that.sedcrds) : that.sedcrds != null) return false;
        if (seqnum1 != null ? !seqnum1.equals(that.seqnum1) : that.seqnum1 != null) return false;
        if (seqnum2 != null ? !seqnum2.equals(that.seqnum2) : that.seqnum2 != null) return false;
        if (sexcldcs != null ? !sexcldcs.equals(that.sexcldcs) : that.sexcldcs != null) return false;
        if (sflb != null ? !sflb.equals(that.sflb) : that.sflb != null) return false;
        if (sflb2 != null ? !sflb2.equals(that.sflb2) : that.sflb2 != null) return false;
        if (sfsb != null ? !sfsb.equals(that.sfsb) : that.sfsb != null) return false;
        if (sfsb2 != null ? !sfsb2.equals(that.sfsb2) : that.sfsb2 != null) return false;
        if (sfsbcs != null ? !sfsbcs.equals(that.sfsbcs) : that.sfsbcs != null) return false;
        if (sfsbs != null ? !sfsbs.equals(that.sfsbs) : that.sfsbs != null) return false;
        if (sgtsads != null ? !sgtsads.equals(that.sgtsads) : that.sgtsads != null) return false;
        if (shmlscs != null ? !shmlscs.equals(that.shmlscs) : that.shmlscs != null) return false;
        if (shomls != null ? !shomls.equals(that.shomls) : that.shomls != null) return false;
        if (shomls2 != null ? !shomls2.equals(that.shomls2) : that.shomls2 != null) return false;
        if (shomlsc != null ? !shomlsc.equals(that.shomlsc) : that.shomlsc != null) return false;
        if (shomlss != null ? !shomlss.equals(that.shomlss) : that.shomlss != null) return false;
        if (shvconcs != null ? !shvconcs.equals(that.shvconcs) : that.shvconcs != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (sinccrcs != null ? !sinccrcs.equals(that.sinccrcs) : that.sinccrcs != null) return false;
        if (sintcs != null ? !sintcs.equals(that.sintcs) : that.sintcs != null) return false;
        if (sints != null ? !sints.equals(that.sints) : that.sints != null) return false;
        if (siradss != null ? !siradss.equals(that.siradss) : that.siradss != null) return false;
        if (sirapys != null ? !sirapys.equals(that.sirapys) : that.sirapys != null) return false;
        if (sirsrq != null ? !sirsrq.equals(that.sirsrq) : that.sirsrq != null) return false;
        if (smcalls != null ? !smcalls.equals(that.smcalls) : that.smcalls != null) return false;
        if (snbemps != null ? !snbemps.equals(that.snbemps) : that.snbemps != null) return false;
        if (snskey != null ? !snskey.equals(that.snskey) : that.snskey != null) return false;
        if (sornrms != null ? !sornrms.equals(that.sornrms) : that.sornrms != null) return false;
        if (soutxcs != null ? !soutxcs.equals(that.soutxcs) : that.soutxcs != null) return false;
        if (soutxs != null ? !soutxs.equals(that.soutxs) : that.soutxs != null) return false;
        if (spenpys != null ? !spenpys.equals(that.spenpys) : that.spenpys != null) return false;
        if (srctstcs != null ? !srctstcs.equals(that.srctstcs) : that.srctstcs != null) return false;
        if (sssib != null ? !sssib.equals(that.sssib) : that.sssib != null) return false;
        if (sssib2 != null ? !sssib2.equals(that.sssib2) : that.sssib2 != null) return false;
        if (stanf != null ? !stanf.equals(that.stanf) : that.stanf != null) return false;
        if (stanf2 != null ? !stanf2.equals(that.stanf2) : that.stanf2 != null) return false;
        if (stotstcs != null ? !stotstcs.equals(that.stotstcs) : that.stotstcs != null) return false;
        if (styp != null ? !styp.equals(that.styp) : that.styp != null) return false;
        if (sutxpns != null ? !sutxpns.equals(that.sutxpns) : that.sutxpns != null) return false;
        if (svarec != null ? !svarec.equals(that.svarec) : that.svarec != null) return false;
        if (svarec2 != null ? !svarec2.equals(that.svarec2) : that.svarec2 != null) return false;
        if (svarecs != null ? !svarecs.equals(that.svarecs) : that.svarecs != null) return false;
        if (svatyp != null ? !svatyp.equals(that.svatyp) : that.svatyp != null) return false;
        if (svatyp2 != null ? !svatyp2.equals(that.svatyp2) : that.svatyp2 != null) return false;
        if (svatyps != null ? !svatyps.equals(that.svatyps) : that.svatyps != null) return false;
        if (swic != null ? !swic.equals(that.swic) : that.swic != null) return false;
        if (swic2 != null ? !swic2.equals(that.swic2) : that.swic2 != null) return false;
        if (trannum1 != null ? !trannum1.equals(that.trannum1) : that.trannum1 != null) return false;
        if (trannum2 != null ? !trannum2.equals(that.trannum2) : that.trannum2 != null) return false;
        if (trcswk != null ? !trcswk.equals(that.trcswk) : that.trcswk != null) return false;
        if (trcswk2 != null ? !trcswk2.equals(that.trcswk2) : that.trcswk2 != null) return false;
        if (trcswks != null ? !trcswks.equals(that.trcswks) : that.trcswks != null) return false;
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
        result = 31 * result + (saaavics != null ? saaavics.hashCode() : 0);
        result = 31 * result + (savbacs != null ? savbacs.hashCode() : 0);
        result = 31 * result + (sconftcs != null ? sconftcs.hashCode() : 0);
        result = 31 * result + (sconfncs != null ? sconfncs.hashCode() : 0);
        result = 31 * result + (sconfcs != null ? sconfcs.hashCode() : 0);
        result = 31 * result + (sdwagcs != null ? sdwagcs.hashCode() : 0);
        result = 31 * result + (sdspswcs != null ? sdspswcs.hashCode() : 0);
        result = 31 * result + (sdotics != null ? sdotics.hashCode() : 0);
        result = 31 * result + (sdntics != null ? sdntics.hashCode() : 0);
        result = 31 * result + (sdvabncs != null ? sdvabncs.hashCode() : 0);
        result = 31 * result + (sdtinccs != null ? sdtinccs.hashCode() : 0);
        result = 31 * result + (sbwagcs != null ? sbwagcs.hashCode() : 0);
        result = 31 * result + (scwagcs != null ? scwagcs.hashCode() : 0);
        result = 31 * result + (sbspswcs != null ? sbspswcs.hashCode() : 0);
        result = 31 * result + (scspswcs != null ? scspswcs.hashCode() : 0);
        result = 31 * result + (sbotics != null ? sbotics.hashCode() : 0);
        result = 31 * result + (scotics != null ? scotics.hashCode() : 0);
        result = 31 * result + (sbntics != null ? sbntics.hashCode() : 0);
        result = 31 * result + (scntics != null ? scntics.hashCode() : 0);
        result = 31 * result + (sctinccs != null ? sctinccs.hashCode() : 0);
        result = 31 * result + (sddedcs != null ? sddedcs.hashCode() : 0);
        result = 31 * result + (sditxxcs != null ? sditxxcs.hashCode() : 0);
        result = 31 * result + (sditxccs != null ? sditxccs.hashCode() : 0);
        result = 31 * result + (sditxucs != null ? sditxucs.hashCode() : 0);
        result = 31 * result + (sdficacs != null ? sdficacs.hashCode() : 0);
        result = 31 * result + (sdsttxcs != null ? sdsttxcs.hashCode() : 0);
        result = 31 * result + (sdmedxcs != null ? sdmedxcs.hashCode() : 0);
        result = 31 * result + (sdmedccs != null ? sdmedccs.hashCode() : 0);
        result = 31 * result + (sdtutacs != null ? sdtutacs.hashCode() : 0);
        result = 31 * result + (sdemalcs != null ? sdemalcs.hashCode() : 0);
        result = 31 * result + (sdsmacs != null ? sdsmacs.hashCode() : 0);
        result = 31 * result + (sdial1Cs != null ? sdial1Cs.hashCode() : 0);
        result = 31 * result + (sdial2Cs != null ? sdial2Cs.hashCode() : 0);
        result = 31 * result + (sdtalocs != null ? sdtalocs.hashCode() : 0);
        result = 31 * result + (sdefincs != null ? sdefincs.hashCode() : 0);
        result = 31 * result + (sexcldcs != null ? sexcldcs.hashCode() : 0);
        result = 31 * result + (shvconcs != null ? shvconcs.hashCode() : 0);
        result = 31 * result + (stotstcs != null ? stotstcs.hashCode() : 0);
        result = 31 * result + (srctstcs != null ? srctstcs.hashCode() : 0);
        result = 31 * result + (sinccrcs != null ? sinccrcs.hashCode() : 0);
        result = 31 * result + (seqnum1 != null ? seqnum1.hashCode() : 0);
        result = 31 * result + (schcod1 != null ? schcod1.hashCode() : 0);
        result = 31 * result + (seqnum2 != null ? seqnum2.hashCode() : 0);
        result = 31 * result + (schcod2 != null ? schcod2.hashCode() : 0);
        result = 31 * result + (primhcs != null ? primhcs.hashCode() : 0);
        result = 31 * result + (pawa1Cs != null ? pawa1Cs.hashCode() : 0);
        result = 31 * result + (pawa2Cs != null ? pawa2Cs.hashCode() : 0);
        result = 31 * result + (pawa3Cs != null ? pawa3Cs.hashCode() : 0);
        result = 31 * result + (psreacs != null ? psreacs.hashCode() : 0);
        result = 31 * result + (drugccs != null ? drugccs.hashCode() : 0);
        result = 31 * result + (santx1L != null ? santx1L.hashCode() : 0);
        result = 31 * result + (santx2L != null ? santx2L.hashCode() : 0);
        result = 31 * result + (saial1L != null ? saial1L.hashCode() : 0);
        result = 31 * result + (saial2L != null ? saial2L.hashCode() : 0);
        result = 31 * result + (sdial1L != null ? sdial1L.hashCode() : 0);
        result = 31 * result + (sdial2L != null ? sdial2L.hashCode() : 0);
        result = 31 * result + (sassadl != null ? sassadl.hashCode() : 0);
        result = 31 * result + (lstupdt1 != null ? lstupdt1.hashCode() : 0);
        result = 31 * result + schdamt1;
        result = 31 * result + amtptdt1;
        result = 31 * result + (lstupdt2 != null ? lstupdt2.hashCode() : 0);
        result = 31 * result + schdamt2;
        result = 31 * result + amtptdt2;
        result = 31 * result + (depstf != null ? depstf.hashCode() : 0);
        result = 31 * result + (ptyp != null ? ptyp.hashCode() : 0);
        result = 31 * result + (styp != null ? styp.hashCode() : 0);
        result = 31 * result + (depsti != null ? depsti.hashCode() : 0);
        result = 31 * result + (iptyp != null ? iptyp.hashCode() : 0);
        result = 31 * result + (istyp != null ? istyp.hashCode() : 0);
        result = 31 * result + psai;
        result = 31 * result + ptfcf;
        result = 31 * result + ipsaia;
        result = 31 * result + iptfcfw;
        result = 31 * result + (trannum1 != null ? trannum1.hashCode() : 0);
        result = 31 * result + (trannum2 != null ? trannum2.hashCode() : 0);
        result = 31 * result + nasaitx;
        result = 31 * result + nasass;
        result = 31 * result + nasaadc;
        result = 31 * result + nasacs;
        result = 31 * result + nasoriv;
        result = 31 * result + nasbfv;
        result = 31 * result + nasfrmv;
        result = 31 * result + nasdwag;
        result = 31 * result + cavlinc;
        result = 31 * result + (batno != null ? batno.hashCode() : 0);
        result = 31 * result + dupseq;
        result = 31 * result + chgseq;
        result = 31 * result + (cbatno != null ? cbatno.hashCode() : 0);
        result = 31 * result + (dbatno != null ? dbatno.hashCode() : 0);
        result = 31 * result + rmamtpy1;
        result = 31 * result + prcntus1;
        result = 31 * result + rmamtpy2;
        result = 31 * result + prcntus2;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        result = 31 * result + s2Onti;
        result = 31 * result + s2Onti2;
        result = 31 * result + s2Ontic;
        result = 31 * result + (s2Ontis != null ? s2Ontis.hashCode() : 0);
        result = 31 * result + (s2Ontics != null ? s2Ontics.hashCode() : 0);
        result = 31 * result + (psred1 != null ? psred1.hashCode() : 0);
        result = 31 * result + (psred2 != null ? psred2.hashCode() : 0);
        result = 31 * result + (psred3 != null ? psred3.hashCode() : 0);
        result = 31 * result + (psred12 != null ? psred12.hashCode() : 0);
        result = 31 * result + (psred22 != null ? psred22.hashCode() : 0);
        result = 31 * result + (psred32 != null ? psred32.hashCode() : 0);
        result = 31 * result + (emadtp != null ? emadtp.hashCode() : 0);
        result = 31 * result + (emadtp2 != null ? emadtp2.hashCode() : 0);
        result = 31 * result + (emadtps != null ? emadtps.hashCode() : 0);
        result = 31 * result + (sssib != null ? sssib.hashCode() : 0);
        result = 31 * result + (sfsb != null ? sfsb.hashCode() : 0);
        result = 31 * result + (sflb != null ? sflb.hashCode() : 0);
        result = 31 * result + (stanf != null ? stanf.hashCode() : 0);
        result = 31 * result + (swic != null ? swic.hashCode() : 0);
        result = 31 * result + (sssib2 != null ? sssib2.hashCode() : 0);
        result = 31 * result + (sfsb2 != null ? sfsb2.hashCode() : 0);
        result = 31 * result + (sflb2 != null ? sflb2.hashCode() : 0);
        result = 31 * result + (stanf2 != null ? stanf2.hashCode() : 0);
        result = 31 * result + (swic2 != null ? swic2.hashCode() : 0);
        result = 31 * result + l41Lev;
        result = 31 * result + scstpd;
        result = 31 * result + sgtsad;
        result = 31 * result + scomby;
        result = 31 * result + (shomls != null ? shomls.hashCode() : 0);
        result = 31 * result + scstpd2;
        result = 31 * result + sgtsad2;
        result = 31 * result + scomby2;
        result = 31 * result + (shomls2 != null ? shomls2.hashCode() : 0);
        result = 31 * result + (scstpds != null ? scstpds.hashCode() : 0);
        result = 31 * result + (sgtsads != null ? sgtsads.hashCode() : 0);
        result = 31 * result + (scombys != null ? scombys.hashCode() : 0);
        result = 31 * result + (shomlss != null ? shomlss.hashCode() : 0);
        result = 31 * result + (trcswk != null ? trcswk.hashCode() : 0);
        result = 31 * result + sedcrd;
        result = 31 * result + snbemp;
        result = 31 * result + spenpy;
        result = 31 * result + sirapy;
        result = 31 * result + sirads;
        result = 31 * result + sutxpn;
        result = 31 * result + smcall;
        result = 31 * result + sornrm;
        result = 31 * result + (svarec != null ? svarec.hashCode() : 0);
        result = 31 * result + (svatyp != null ? svatyp.hashCode() : 0);
        result = 31 * result + (trcswk2 != null ? trcswk2.hashCode() : 0);
        result = 31 * result + sedcrd2;
        result = 31 * result + snbemp2;
        result = 31 * result + spenpy2;
        result = 31 * result + sirapy2;
        result = 31 * result + sirads2;
        result = 31 * result + sutxpn2;
        result = 31 * result + smcall2;
        result = 31 * result + sornrm2;
        result = 31 * result + (svarec2 != null ? svarec2.hashCode() : 0);
        result = 31 * result + (svatyp2 != null ? svatyp2.hashCode() : 0);
        result = 31 * result + (trcswks != null ? trcswks.hashCode() : 0);
        result = 31 * result + (sedcrds != null ? sedcrds.hashCode() : 0);
        result = 31 * result + (snbemps != null ? snbemps.hashCode() : 0);
        result = 31 * result + (spenpys != null ? spenpys.hashCode() : 0);
        result = 31 * result + (sirapys != null ? sirapys.hashCode() : 0);
        result = 31 * result + (siradss != null ? siradss.hashCode() : 0);
        result = 31 * result + (sutxpns != null ? sutxpns.hashCode() : 0);
        result = 31 * result + (smcalls != null ? smcalls.hashCode() : 0);
        result = 31 * result + (sornrms != null ? sornrms.hashCode() : 0);
        result = 31 * result + (svarecs != null ? svarecs.hashCode() : 0);
        result = 31 * result + (svatyps != null ? svatyps.hashCode() : 0);
        result = 31 * result + soutx;
        result = 31 * result + soutx2;
        result = 31 * result + soutxc;
        result = 31 * result + (soutxs != null ? soutxs.hashCode() : 0);
        result = 31 * result + (soutxcs != null ? soutxcs.hashCode() : 0);
        result = 31 * result + sint;
        result = 31 * result + sint2;
        result = 31 * result + sintc;
        result = 31 * result + (sints != null ? sints.hashCode() : 0);
        result = 31 * result + (sintcs != null ? sintcs.hashCode() : 0);
        result = 31 * result + scoop;
        result = 31 * result + scoop2;
        result = 31 * result + scoopc;
        result = 31 * result + (scoops != null ? scoops.hashCode() : 0);
        result = 31 * result + (scoopcs != null ? scoopcs.hashCode() : 0);
        result = 31 * result + (sirsrq != null ? sirsrq.hashCode() : 0);
        result = 31 * result + (shomlsc != null ? shomlsc.hashCode() : 0);
        result = 31 * result + (shmlscs != null ? shmlscs.hashCode() : 0);
        result = 31 * result + (sathx != null ? sathx.hashCode() : 0);
        result = 31 * result + (sathx2 != null ? sathx2.hashCode() : 0);
        result = 31 * result + (sathxs != null ? sathxs.hashCode() : 0);
        result = 31 * result + (sathxc != null ? sathxc.hashCode() : 0);
        result = 31 * result + (sathxcs != null ? sathxcs.hashCode() : 0);
        result = 31 * result + (asathex != null ? asathex.hashCode() : 0);
        result = 31 * result + (sfsbs != null ? sfsbs.hashCode() : 0);
        result = 31 * result + (sfsbcs != null ? sfsbcs.hashCode() : 0);
        return result;
    }
}
