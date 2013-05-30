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
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DIS", schema = "SIGMA", catalog = "")
@Entity
public class DisEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getDiskey();
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

    private String diskey;

    @javax.persistence.Column(name = "DISKEY")
    @Id
    public String getDiskey() {
        return diskey;
    }

    public void setDiskey(String diskey) {
        this.diskey = diskey;
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

    private String procyr;

    @javax.persistence.Column(name = "PROCYR")
    @Basic
    public String getProcyr() {
        return procyr;
    }

    public void setProcyr(String procyr) {
        this.procyr = procyr;
    }

    private String aidid;

    @javax.persistence.Column(name = "AIDID")
    @Basic
    public String getAidid() {
        return aidid;
    }

    public void setAidid(String aidid) {
        this.aidid = aidid;
    }

    private String ptype;

    @javax.persistence.Column(name = "PTYPE")
    @Basic
    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    private String seqno;

    @javax.persistence.Column(name = "SEQNO")
    @Basic
    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }

    private String unuseda;

    @javax.persistence.Column(name = "UNUSEDA")
    @Basic
    public String getUnuseda() {
        return unuseda;
    }

    public void setUnuseda(String unuseda) {
        this.unuseda = unuseda;
    }

    private String unusedb;

    @javax.persistence.Column(name = "UNUSEDB")
    @Basic
    public String getUnusedb() {
        return unusedb;
    }

    public void setUnusedb(String unusedb) {
        this.unusedb = unusedb;
    }

    private String unusedc;

    @javax.persistence.Column(name = "UNUSEDC")
    @Basic
    public String getUnusedc() {
        return unusedc;
    }

    public void setUnusedc(String unusedc) {
        this.unusedc = unusedc;
    }

    private String unusedd;

    @javax.persistence.Column(name = "UNUSEDD")
    @Basic
    public String getUnusedd() {
        return unusedd;
    }

    public void setUnusedd(String unusedd) {
        this.unusedd = unusedd;
    }

    private int unusede;

    @javax.persistence.Column(name = "UNUSEDE")
    @Basic
    public int getUnusede() {
        return unusede;
    }

    public void setUnusede(int unusede) {
        this.unusede = unusede;
    }

    private String unused1;

    @javax.persistence.Column(name = "UNUSED1")
    @Basic
    public String getUnused1() {
        return unused1;
    }

    public void setUnused1(String unused1) {
        this.unused1 = unused1;
    }

    private String crtdate;

    @javax.persistence.Column(name = "CRTDATE")
    @Basic
    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
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

    private String crtuser;

    @javax.persistence.Column(name = "CRTUSER")
    @Basic
    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
    }

    private String crtpgm;

    @javax.persistence.Column(name = "CRTPGM")
    @Basic
    public String getCrtpgm() {
        return crtpgm;
    }

    public void setCrtpgm(String crtpgm) {
        this.crtpgm = crtpgm;
    }

    private String revdate;

    @javax.persistence.Column(name = "REVDATE")
    @Basic
    public String getRevdate() {
        return revdate;
    }

    public void setRevdate(String revdate) {
        this.revdate = revdate;
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

    private String revuser;

    @javax.persistence.Column(name = "REVUSER")
    @Basic
    public String getRevuser() {
        return revuser;
    }

    public void setRevuser(String revuser) {
        this.revuser = revuser;
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

    private String revpgm;

    @javax.persistence.Column(name = "REVPGM")
    @Basic
    public String getRevpgm() {
        return revpgm;
    }

    public void setRevpgm(String revpgm) {
        this.revpgm = revpgm;
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

    private String scitzn;

    @javax.persistence.Column(name = "SCITZN")
    @Basic
    public String getScitzn() {
        return scitzn;
    }

    public void setScitzn(String scitzn) {
        this.scitzn = scitzn;
    }

    private String penrlts;

    @javax.persistence.Column(name = "PENRLTS")
    @Basic
    public String getPenrlts() {
        return penrlts;
    }

    public void setPenrlts(String penrlts) {
        this.penrlts = penrlts;
    }

    private String aenrlts;

    @javax.persistence.Column(name = "AENRLTS")
    @Basic
    public String getAenrlts() {
        return aenrlts;
    }

    public void setAenrlts(String aenrlts) {
        this.aenrlts = aenrlts;
    }

    private String loanstat;

    @javax.persistence.Column(name = "LOANSTAT")
    @Basic
    public String getLoanstat() {
        return loanstat;
    }

    public void setLoanstat(String loanstat) {
        this.loanstat = loanstat;
    }

    private String origdate;

    @javax.persistence.Column(name = "ORIGDATE")
    @Basic
    public String getOrigdate() {
        return origdate;
    }

    public void setOrigdate(String origdate) {
        this.origdate = origdate;
    }

    private String trndate;

    @javax.persistence.Column(name = "TRNDATE")
    @Basic
    public String getTrndate() {
        return trndate;
    }

    public void setTrndate(String trndate) {
        this.trndate = trndate;
    }

    private String trntype;

    @javax.persistence.Column(name = "TRNTYPE")
    @Basic
    public String getTrntype() {
        return trntype;
    }

    public void setTrntype(String trntype) {
        this.trntype = trntype;
    }

    private String term;

    @javax.persistence.Column(name = "TERM")
    @Basic
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    private String typechk;

    @javax.persistence.Column(name = "TYPECHK")
    @Basic
    public String getTypechk() {
        return typechk;
    }

    public void setTypechk(String typechk) {
        this.typechk = typechk;
    }

    private String campus;

    @javax.persistence.Column(name = "CAMPUS")
    @Basic
    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    private String actnr;

    @javax.persistence.Column(name = "ACTNR")
    @Basic
    public String getActnr() {
        return actnr;
    }

    public void setActnr(String actnr) {
        this.actnr = actnr;
    }

    private String refnr;

    @javax.persistence.Column(name = "REFNR")
    @Basic
    public String getRefnr() {
        return refnr;
    }

    public void setRefnr(String refnr) {
        this.refnr = refnr;
    }

    private String chknr;

    @javax.persistence.Column(name = "CHKNR")
    @Basic
    public String getChknr() {
        return chknr;
    }

    public void setChknr(String chknr) {
        this.chknr = chknr;
    }

    private String chgtype;

    @javax.persistence.Column(name = "CHGTYPE")
    @Basic
    public String getChgtype() {
        return chgtype;
    }

    public void setChgtype(String chgtype) {
        this.chgtype = chgtype;
    }

    private String trndesc;

    @javax.persistence.Column(name = "TRNDESC")
    @Basic
    public String getTrndesc() {
        return trndesc;
    }

    public void setTrndesc(String trndesc) {
        this.trndesc = trndesc;
    }

    private String untdesc;

    @javax.persistence.Column(name = "UNTDESC")
    @Basic
    public String getUntdesc() {
        return untdesc;
    }

    public void setUntdesc(String untdesc) {
        this.untdesc = untdesc;
    }

    private String sartran;

    @javax.persistence.Column(name = "SARTRAN")
    @Basic
    public String getSartran() {
        return sartran;
    }

    public void setSartran(String sartran) {
        this.sartran = sartran;
    }

    private BigDecimal reamt;

    @javax.persistence.Column(name = "REAMT")
    @Basic
    public BigDecimal getReamt() {
        return reamt;
    }

    public void setReamt(BigDecimal reamt) {
        this.reamt = reamt;
    }

    private String koref;

    @javax.persistence.Column(name = "KOREF")
    @Basic
    public String getKoref() {
        return koref;
    }

    public void setKoref(String koref) {
        this.koref = koref;
    }

    private int priornr;

    @javax.persistence.Column(name = "PRIORNR")
    @Basic
    public int getPriornr() {
        return priornr;
    }

    public void setPriornr(int priornr) {
        this.priornr = priornr;
    }

    private String disbloc;

    @javax.persistence.Column(name = "DISBLOC")
    @Basic
    public String getDisbloc() {
        return disbloc;
    }

    public void setDisbloc(String disbloc) {
        this.disbloc = disbloc;
    }

    private String taxcode;

    @javax.persistence.Column(name = "TAXCODE")
    @Basic
    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
    }

    private String typeaid;

    @javax.persistence.Column(name = "TYPEAID")
    @Basic
    public String getTypeaid() {
        return typeaid;
    }

    public void setTypeaid(String typeaid) {
        this.typeaid = typeaid;
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

    private String ecampus;

    @javax.persistence.Column(name = "ECAMPUS")
    @Basic
    public String getEcampus() {
        return ecampus;
    }

    public void setEcampus(String ecampus) {
        this.ecampus = ecampus;
    }

    private String adisbeg;

    @javax.persistence.Column(name = "ADISBEG")
    @Basic
    public String getAdisbeg() {
        return adisbeg;
    }

    public void setAdisbeg(String adisbeg) {
        this.adisbeg = adisbeg;
    }

    private int adisamt;

    @javax.persistence.Column(name = "ADISAMT")
    @Basic
    public int getAdisamt() {
        return adisamt;
    }

    public void setAdisamt(int adisamt) {
        this.adisamt = adisamt;
    }

    private int afeeamt;

    @javax.persistence.Column(name = "AFEEAMT")
    @Basic
    public int getAfeeamt() {
        return afeeamt;
    }

    public void setAfeeamt(int afeeamt) {
        this.afeeamt = afeeamt;
    }

    private int anetamt;

    @javax.persistence.Column(name = "ANETAMT")
    @Basic
    public int getAnetamt() {
        return anetamt;
    }

    public void setAnetamt(int anetamt) {
        this.anetamt = anetamt;
    }

    private String disdate;

    @javax.persistence.Column(name = "DISDATE")
    @Basic
    public String getDisdate() {
        return disdate;
    }

    public void setDisdate(String disdate) {
        this.disdate = disdate;
    }

    private int grosamt;

    @javax.persistence.Column(name = "GROSAMT")
    @Basic
    public int getGrosamt() {
        return grosamt;
    }

    public void setGrosamt(int grosamt) {
        this.grosamt = grosamt;
    }

    private int feeamt;

    @javax.persistence.Column(name = "FEEAMT")
    @Basic
    public int getFeeamt() {
        return feeamt;
    }

    public void setFeeamt(int feeamt) {
        this.feeamt = feeamt;
    }

    private int netamt;

    @javax.persistence.Column(name = "NETAMT")
    @Basic
    public int getNetamt() {
        return netamt;
    }

    public void setNetamt(int netamt) {
        this.netamt = netamt;
    }

    private String acancde;

    @javax.persistence.Column(name = "ACANCDE")
    @Basic
    public String getAcancde() {
        return acancde;
    }

    public void setAcancde(String acancde) {
        this.acancde = acancde;
    }

    private String acandte;

    @javax.persistence.Column(name = "ACANDTE")
    @Basic
    public String getAcandte() {
        return acandte;
    }

    public void setAcandte(String acandte) {
        this.acandte = acandte;
    }

    private String disstat;

    @javax.persistence.Column(name = "DISSTAT")
    @Basic
    public String getDisstat() {
        return disstat;
    }

    public void setDisstat(String disstat) {
        this.disstat = disstat;
    }

    private String refcode;

    @javax.persistence.Column(name = "REFCODE")
    @Basic
    public String getRefcode() {
        return refcode;
    }

    public void setRefcode(String refcode) {
        this.refcode = refcode;
    }

    private String refdate;

    @javax.persistence.Column(name = "REFDATE")
    @Basic
    public String getRefdate() {
        return refdate;
    }

    public void setRefdate(String refdate) {
        this.refdate = refdate;
    }

    private String snddate;

    @javax.persistence.Column(name = "SNDDATE")
    @Basic
    public String getSnddate() {
        return snddate;
    }

    public void setSnddate(String snddate) {
        this.snddate = snddate;
    }

    private String unusedf;

    @javax.persistence.Column(name = "UNUSEDF")
    @Basic
    public String getUnusedf() {
        return unusedf;
    }

    public void setUnusedf(String unusedf) {
        this.unusedf = unusedf;
    }

    private String ddbatch;

    @javax.persistence.Column(name = "DDBATCH")
    @Basic
    public String getDdbatch() {
        return ddbatch;
    }

    public void setDdbatch(String ddbatch) {
        this.ddbatch = ddbatch;
    }

    private String dddate;

    @javax.persistence.Column(name = "DDDATE")
    @Basic
    public String getDddate() {
        return dddate;
    }

    public void setDddate(String dddate) {
        this.dddate = dddate;
    }

    private String recon;

    @javax.persistence.Column(name = "RECON")
    @Basic
    public String getRecon() {
        return recon;
    }

    public void setRecon(String recon) {
        this.recon = recon;
    }

    private String recondt;

    @javax.persistence.Column(name = "RECONDT")
    @Basic
    public String getRecondt() {
        return recondt;
    }

    public void setRecondt(String recondt) {
        this.recondt = recondt;
    }

    private String netadte;

    @javax.persistence.Column(name = "NETADTE")
    @Basic
    public String getNetadte() {
        return netadte;
    }

    public void setNetadte(String netadte) {
        this.netadte = netadte;
    }

    private int netaamt;

    @javax.persistence.Column(name = "NETAAMT")
    @Basic
    public int getNetaamt() {
        return netaamt;
    }

    public void setNetaamt(int netaamt) {
        this.netaamt = netaamt;
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

    private int usernr1;

    @javax.persistence.Column(name = "USERNR1")
    @Basic
    public int getUsernr1() {
        return usernr1;
    }

    public void setUsernr1(int usernr1) {
        this.usernr1 = usernr1;
    }

    private int usernr2;

    @javax.persistence.Column(name = "USERNR2")
    @Basic
    public int getUsernr2() {
        return usernr2;
    }

    public void setUsernr2(int usernr2) {
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

    private BigDecimal usernr4;

    @javax.persistence.Column(name = "USERNR4")
    @Basic
    public BigDecimal getUsernr4() {
        return usernr4;
    }

    public void setUsernr4(BigDecimal usernr4) {
        this.usernr4 = usernr4;
    }

    private String senrlst;

    @javax.persistence.Column(name = "SENRLST")
    @Basic
    public String getSenrlst() {
        return senrlst;
    }

    public void setSenrlst(String senrlst) {
        this.senrlst = senrlst;
    }

    private String senrsdt;

    @javax.persistence.Column(name = "SENRSDT")
    @Basic
    public String getSenrsdt() {
        return senrsdt;
    }

    public void setSenrsdt(String senrsdt) {
        this.senrsdt = senrsdt;
    }

    private int aogramt;

    @javax.persistence.Column(name = "AOGRAMT")
    @Basic
    public int getAogramt() {
        return aogramt;
    }

    public void setAogramt(int aogramt) {
        this.aogramt = aogramt;
    }

    private String distyp;

    @javax.persistence.Column(name = "DISTYP")
    @Basic
    public String getDistyp() {
        return distyp;
    }

    public void setDistyp(String distyp) {
        this.distyp = distyp;
    }

    private String adjtyp;

    @javax.persistence.Column(name = "ADJTYP")
    @Basic
    public String getAdjtyp() {
        return adjtyp;
    }

    public void setAdjtyp(String adjtyp) {
        this.adjtyp = adjtyp;
    }

    private BigInteger expseq;

    @javax.persistence.Column(name = "EXPSEQ")
    @Basic
    public BigInteger getExpseq() {
        return expseq;
    }

    public void setExpseq(BigInteger expseq) {
        this.expseq = expseq;
    }

    private String refchk;

    @javax.persistence.Column(name = "REFCHK")
    @Basic
    public String getRefchk() {
        return refchk;
    }

    public void setRefchk(String refchk) {
        this.refchk = refchk;
    }

    private int netdamt;

    @javax.persistence.Column(name = "NETDAMT")
    @Basic
    public int getNetdamt() {
        return netdamt;
    }

    public void setNetdamt(int netdamt) {
        this.netdamt = netdamt;
    }

    private String netddte;

    @javax.persistence.Column(name = "NETDDTE")
    @Basic
    public String getNetddte() {
        return netddte;
    }

    public void setNetddte(String netddte) {
        this.netddte = netddte;
    }

    private String cantyp;

    @javax.persistence.Column(name = "CANTYP")
    @Basic
    public String getCantyp() {
        return cantyp;
    }

    public void setCantyp(String cantyp) {
        this.cantyp = cantyp;
    }

    private int netcamt;

    @javax.persistence.Column(name = "NETCAMT")
    @Basic
    public int getNetcamt() {
        return netcamt;
    }

    public void setNetcamt(int netcamt) {
        this.netcamt = netcamt;
    }

    private String netcdte;

    @javax.persistence.Column(name = "NETCDTE")
    @Basic
    public String getNetcdte() {
        return netcdte;
    }

    public void setNetcdte(String netcdte) {
        this.netcdte = netcdte;
    }

    private String unusedg;

    @javax.persistence.Column(name = "UNUSEDG")
    @Basic
    public String getUnusedg() {
        return unusedg;
    }

    public void setUnusedg(String unusedg) {
        this.unusedg = unusedg;
    }

    private String acttyp;

    @javax.persistence.Column(name = "ACTTYP")
    @Basic
    public String getActtyp() {
        return acttyp;
    }

    public void setActtyp(String acttyp) {
        this.acttyp = acttyp;
    }

    private String ackdte;

    @javax.persistence.Column(name = "ACKDTE")
    @Basic
    public String getAckdte() {
        return ackdte;
    }

    public void setAckdte(String ackdte) {
        this.ackdte = ackdte;
    }

    private String disdte2;

    @javax.persistence.Column(name = "DISDTE2")
    @Basic
    public String getDisdte2() {
        return disdte2;
    }

    public void setDisdte2(String disdte2) {
        this.disdte2 = disdte2;
    }

    private int disamt2;

    @javax.persistence.Column(name = "DISAMT2")
    @Basic
    public int getDisamt2() {
        return disamt2;
    }

    public void setDisamt2(int disamt2) {
        this.disamt2 = disamt2;
    }

    private String cancde2;

    @javax.persistence.Column(name = "CANCDE2")
    @Basic
    public String getCancde2() {
        return cancde2;
    }

    public void setCancde2(String cancde2) {
        this.cancde2 = cancde2;
    }

    private String candte2;

    @javax.persistence.Column(name = "CANDTE2")
    @Basic
    public String getCandte2() {
        return candte2;
    }

    public void setCandte2(String candte2) {
        this.candte2 = candte2;
    }

    private String adisdt2;

    @javax.persistence.Column(name = "ADISDT2")
    @Basic
    public String getAdisdt2() {
        return adisdt2;
    }

    public void setAdisdt2(String adisdt2) {
        this.adisdt2 = adisdt2;
    }

    private int agroam2;

    @javax.persistence.Column(name = "AGROAM2")
    @Basic
    public int getAgroam2() {
        return agroam2;
    }

    public void setAgroam2(int agroam2) {
        this.agroam2 = agroam2;
    }

    private String refcode2;

    @javax.persistence.Column(name = "REFCODE2")
    @Basic
    public String getRefcode2() {
        return refcode2;
    }

    public void setRefcode2(String refcode2) {
        this.refcode2 = refcode2;
    }

    private String refdate2;

    @javax.persistence.Column(name = "REFDATE2")
    @Basic
    public String getRefdate2() {
        return refdate2;
    }

    public void setRefdate2(String refdate2) {
        this.refdate2 = refdate2;
    }

    private String recon2;

    @javax.persistence.Column(name = "RECON2")
    @Basic
    public String getRecon2() {
        return recon2;
    }

    public void setRecon2(String recon2) {
        this.recon2 = recon2;
    }

    private String acttyp2;

    @javax.persistence.Column(name = "ACTTYP2")
    @Basic
    public String getActtyp2() {
        return acttyp2;
    }

    public void setActtyp2(String acttyp2) {
        this.acttyp2 = acttyp2;
    }

    private String disdte3;

    @javax.persistence.Column(name = "DISDTE3")
    @Basic
    public String getDisdte3() {
        return disdte3;
    }

    public void setDisdte3(String disdte3) {
        this.disdte3 = disdte3;
    }

    private int disamt3;

    @javax.persistence.Column(name = "DISAMT3")
    @Basic
    public int getDisamt3() {
        return disamt3;
    }

    public void setDisamt3(int disamt3) {
        this.disamt3 = disamt3;
    }

    private String cancde3;

    @javax.persistence.Column(name = "CANCDE3")
    @Basic
    public String getCancde3() {
        return cancde3;
    }

    public void setCancde3(String cancde3) {
        this.cancde3 = cancde3;
    }

    private String candte3;

    @javax.persistence.Column(name = "CANDTE3")
    @Basic
    public String getCandte3() {
        return candte3;
    }

    public void setCandte3(String candte3) {
        this.candte3 = candte3;
    }

    private String adisdt3;

    @javax.persistence.Column(name = "ADISDT3")
    @Basic
    public String getAdisdt3() {
        return adisdt3;
    }

    public void setAdisdt3(String adisdt3) {
        this.adisdt3 = adisdt3;
    }

    private int agroam3;

    @javax.persistence.Column(name = "AGROAM3")
    @Basic
    public int getAgroam3() {
        return agroam3;
    }

    public void setAgroam3(int agroam3) {
        this.agroam3 = agroam3;
    }

    private String refcode3;

    @javax.persistence.Column(name = "REFCODE3")
    @Basic
    public String getRefcode3() {
        return refcode3;
    }

    public void setRefcode3(String refcode3) {
        this.refcode3 = refcode3;
    }

    private String refdate3;

    @javax.persistence.Column(name = "REFDATE3")
    @Basic
    public String getRefdate3() {
        return refdate3;
    }

    public void setRefdate3(String refdate3) {
        this.refdate3 = refdate3;
    }

    private String recon3;

    @javax.persistence.Column(name = "RECON3")
    @Basic
    public String getRecon3() {
        return recon3;
    }

    public void setRecon3(String recon3) {
        this.recon3 = recon3;
    }

    private String acttyp3;

    @javax.persistence.Column(name = "ACTTYP3")
    @Basic
    public String getActtyp3() {
        return acttyp3;
    }

    public void setActtyp3(String acttyp3) {
        this.acttyp3 = acttyp3;
    }

    private String afrmfg;

    @javax.persistence.Column(name = "AFRMFG")
    @Basic
    public String getAfrmfg() {
        return afrmfg;
    }

    public void setAfrmfg(String afrmfg) {
        this.afrmfg = afrmfg;
    }

    private String afrmfg2;

    @javax.persistence.Column(name = "AFRMFG2")
    @Basic
    public String getAfrmfg2() {
        return afrmfg2;
    }

    public void setAfrmfg2(String afrmfg2) {
        this.afrmfg2 = afrmfg2;
    }

    private String afrmfg3;

    @javax.persistence.Column(name = "AFRMFG3")
    @Basic
    public String getAfrmfg3() {
        return afrmfg3;
    }

    public void setAfrmfg3(String afrmfg3) {
        this.afrmfg3 = afrmfg3;
    }

    private String sndbtch;

    @javax.persistence.Column(name = "SNDBTCH")
    @Basic
    public String getSndbtch() {
        return sndbtch;
    }

    public void setSndbtch(String sndbtch) {
        this.sndbtch = sndbtch;
    }

    private String reconbh;

    @javax.persistence.Column(name = "RECONBH")
    @Basic
    public String getReconbh() {
        return reconbh;
    }

    public void setReconbh(String reconbh) {
        this.reconbh = reconbh;
    }

    private String aorigbth;

    @javax.persistence.Column(name = "AORIGBTH")
    @Basic
    public String getAorigbth() {
        return aorigbth;
    }

    public void setAorigbth(String aorigbth) {
        this.aorigbth = aorigbth;
    }

    private String asid;

    @javax.persistence.Column(name = "ASID")
    @Basic
    public String getAsid() {
        return asid;
    }

    public void setAsid(String asid) {
        this.asid = asid;
    }

    private String aaidid;

    @javax.persistence.Column(name = "AAIDID")
    @Basic
    public String getAaidid() {
        return aaidid;
    }

    public void setAaidid(String aaidid) {
        this.aaidid = aaidid;
    }

    private String aptype;

    @javax.persistence.Column(name = "APTYPE")
    @Basic
    public String getAptype() {
        return aptype;
    }

    public void setAptype(String aptype) {
        this.aptype = aptype;
    }

    private int aseqno;

    @javax.persistence.Column(name = "ASEQNO")
    @Basic
    public int getAseqno() {
        return aseqno;
    }

    public void setAseqno(int aseqno) {
        this.aseqno = aseqno;
    }

    private BigDecimal artnamt;

    @javax.persistence.Column(name = "ARTNAMT")
    @Basic
    public BigDecimal getArtnamt() {
        return artnamt;
    }

    public void setArtnamt(BigDecimal artnamt) {
        this.artnamt = artnamt;
    }

    private BigDecimal acanamt;

    @javax.persistence.Column(name = "ACANAMT")
    @Basic
    public BigDecimal getAcanamt() {
        return acanamt;
    }

    public void setAcanamt(BigDecimal acanamt) {
        this.acanamt = acanamt;
    }

    private String apptoar;

    @javax.persistence.Column(name = "APPTOAR")
    @Basic
    public String getApptoar() {
        return apptoar;
    }

    public void setApptoar(String apptoar) {
        this.apptoar = apptoar;
    }

    private BigDecimal rebamt;

    @javax.persistence.Column(name = "REBAMT")
    @Basic
    public BigDecimal getRebamt() {
        return rebamt;
    }

    public void setRebamt(BigDecimal rebamt) {
        this.rebamt = rebamt;
    }

    private BigDecimal arebamt;

    @javax.persistence.Column(name = "AREBAMT")
    @Basic
    public BigDecimal getArebamt() {
        return arebamt;
    }

    public void setArebamt(BigDecimal arebamt) {
        this.arebamt = arebamt;
    }

    private String adisdte;

    @javax.persistence.Column(name = "ADISDTE")
    @Basic
    public String getAdisdte() {
        return adisdte;
    }

    public void setAdisdte(String adisdte) {
        this.adisdte = adisdte;
    }

    private BigDecimal feespd;

    @javax.persistence.Column(name = "FEESPD")
    @Basic
    public BigDecimal getFeespd() {
        return feespd;
    }

    public void setFeespd(BigDecimal feespd) {
        this.feespd = feespd;
    }

    private BigDecimal feespd2;

    @javax.persistence.Column(name = "FEESPD2")
    @Basic
    public BigDecimal getFeespd2() {
        return feespd2;
    }

    public void setFeespd2(BigDecimal feespd2) {
        this.feespd2 = feespd2;
    }

    private BigDecimal feespd3;

    @javax.persistence.Column(name = "FEESPD3")
    @Basic
    public BigDecimal getFeespd3() {
        return feespd3;
    }

    public void setFeespd3(BigDecimal feespd3) {
        this.feespd3 = feespd3;
    }

    private int pdbnum;

    @javax.persistence.Column(name = "PDBNUM")
    @Basic
    public int getPdbnum() {
        return pdbnum;
    }

    public void setPdbnum(int pdbnum) {
        this.pdbnum = pdbnum;
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

    private String docidc;

    @javax.persistence.Column(name = "DOCIDC")
    @Basic
    public String getDocidc() {
        return docidc;
    }

    public void setDocidc(String docidc) {
        this.docidc = docidc;
    }

    private String dayovr;

    @javax.persistence.Column(name = "DAYOVR")
    @Basic
    public String getDayovr() {
        return dayovr;
    }

    public void setDayovr(String dayovr) {
        this.dayovr = dayovr;
    }

    private String disams;

    @javax.persistence.Column(name = "DISAMS")
    @Basic
    public String getDisams() {
        return disams;
    }

    public void setDisams(String disams) {
        this.disams = disams;
    }

    private String disdts;

    @javax.persistence.Column(name = "DISDTS")
    @Basic
    public String getDisdts() {
        return disdts;
    }

    public void setDisdts(String disdts) {
        this.disdts = disdts;
    }

    private String agroas;

    @javax.persistence.Column(name = "AGROAS")
    @Basic
    public String getAgroas() {
        return agroas;
    }

    public void setAgroas(String agroas) {
        this.agroas = agroas;
    }

    private String adisds;

    @javax.persistence.Column(name = "ADISDS")
    @Basic
    public String getAdisds() {
        return adisds;
    }

    public void setAdisds(String adisds) {
        this.adisds = adisds;
    }

    private String cancds;

    @javax.persistence.Column(name = "CANCDS")
    @Basic
    public String getCancds() {
        return cancds;
    }

    public void setCancds(String cancds) {
        this.cancds = cancds;
    }

    private String candts;

    @javax.persistence.Column(name = "CANDTS")
    @Basic
    public String getCandts() {
        return candts;
    }

    public void setCandts(String candts) {
        this.candts = candts;
    }

    private String refcds;

    @javax.persistence.Column(name = "REFCDS")
    @Basic
    public String getRefcds() {
        return refcds;
    }

    public void setRefcds(String refcds) {
        this.refcds = refcds;
    }

    private String refdts;

    @javax.persistence.Column(name = "REFDTS")
    @Basic
    public String getRefdts() {
        return refdts;
    }

    public void setRefdts(String refdts) {
        this.refdts = refdts;
    }

    private String sessid;

    @javax.persistence.Column(name = "SESSID")
    @Basic
    public String getSessid() {
        return sessid;
    }

    public void setSessid(String sessid) {
        this.sessid = sessid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisEntity disEntity = (DisEntity) o;

        if (adisamt != disEntity.adisamt) return false;
        if (afeeamt != disEntity.afeeamt) return false;
        if (agroam2 != disEntity.agroam2) return false;
        if (agroam3 != disEntity.agroam3) return false;
        if (anetamt != disEntity.anetamt) return false;
        if (aogramt != disEntity.aogramt) return false;
        if (aseqno != disEntity.aseqno) return false;
        if (disamt2 != disEntity.disamt2) return false;
        if (disamt3 != disEntity.disamt3) return false;
        if (feeamt != disEntity.feeamt) return false;
        if (grosamt != disEntity.grosamt) return false;
        if (netaamt != disEntity.netaamt) return false;
        if (netamt != disEntity.netamt) return false;
        if (netcamt != disEntity.netcamt) return false;
        if (netdamt != disEntity.netdamt) return false;
        if (pdbnum != disEntity.pdbnum) return false;
        if (priornr != disEntity.priornr) return false;
        if (revlev != disEntity.revlev) return false;
        if (unusede != disEntity.unusede) return false;
        if (usernr1 != disEntity.usernr1) return false;
        if (usernr2 != disEntity.usernr2) return false;
        if (aaidid != null ? !aaidid.equals(disEntity.aaidid) : disEntity.aaidid != null) return false;
        if (acanamt != null ? !acanamt.equals(disEntity.acanamt) : disEntity.acanamt != null) return false;
        if (acancde != null ? !acancde.equals(disEntity.acancde) : disEntity.acancde != null) return false;
        if (acandte != null ? !acandte.equals(disEntity.acandte) : disEntity.acandte != null) return false;
        if (ackdte != null ? !ackdte.equals(disEntity.ackdte) : disEntity.ackdte != null) return false;
        if (actnr != null ? !actnr.equals(disEntity.actnr) : disEntity.actnr != null) return false;
        if (acttyp != null ? !acttyp.equals(disEntity.acttyp) : disEntity.acttyp != null) return false;
        if (acttyp2 != null ? !acttyp2.equals(disEntity.acttyp2) : disEntity.acttyp2 != null) return false;
        if (acttyp3 != null ? !acttyp3.equals(disEntity.acttyp3) : disEntity.acttyp3 != null) return false;
        if (adisbeg != null ? !adisbeg.equals(disEntity.adisbeg) : disEntity.adisbeg != null) return false;
        if (adisds != null ? !adisds.equals(disEntity.adisds) : disEntity.adisds != null) return false;
        if (adisdt2 != null ? !adisdt2.equals(disEntity.adisdt2) : disEntity.adisdt2 != null) return false;
        if (adisdt3 != null ? !adisdt3.equals(disEntity.adisdt3) : disEntity.adisdt3 != null) return false;
        if (adisdte != null ? !adisdte.equals(disEntity.adisdte) : disEntity.adisdte != null) return false;
        if (adjtyp != null ? !adjtyp.equals(disEntity.adjtyp) : disEntity.adjtyp != null) return false;
        if (aenrlts != null ? !aenrlts.equals(disEntity.aenrlts) : disEntity.aenrlts != null) return false;
        if (afrmfg != null ? !afrmfg.equals(disEntity.afrmfg) : disEntity.afrmfg != null) return false;
        if (afrmfg2 != null ? !afrmfg2.equals(disEntity.afrmfg2) : disEntity.afrmfg2 != null) return false;
        if (afrmfg3 != null ? !afrmfg3.equals(disEntity.afrmfg3) : disEntity.afrmfg3 != null) return false;
        if (agroas != null ? !agroas.equals(disEntity.agroas) : disEntity.agroas != null) return false;
        if (aidid != null ? !aidid.equals(disEntity.aidid) : disEntity.aidid != null) return false;
        if (aorigbth != null ? !aorigbth.equals(disEntity.aorigbth) : disEntity.aorigbth != null) return false;
        if (apptoar != null ? !apptoar.equals(disEntity.apptoar) : disEntity.apptoar != null) return false;
        if (aptype != null ? !aptype.equals(disEntity.aptype) : disEntity.aptype != null) return false;
        if (arebamt != null ? !arebamt.equals(disEntity.arebamt) : disEntity.arebamt != null) return false;
        if (artnamt != null ? !artnamt.equals(disEntity.artnamt) : disEntity.artnamt != null) return false;
        if (asid != null ? !asid.equals(disEntity.asid) : disEntity.asid != null) return false;
        if (campus != null ? !campus.equals(disEntity.campus) : disEntity.campus != null) return false;
        if (cancde2 != null ? !cancde2.equals(disEntity.cancde2) : disEntity.cancde2 != null) return false;
        if (cancde3 != null ? !cancde3.equals(disEntity.cancde3) : disEntity.cancde3 != null) return false;
        if (cancds != null ? !cancds.equals(disEntity.cancds) : disEntity.cancds != null) return false;
        if (candte2 != null ? !candte2.equals(disEntity.candte2) : disEntity.candte2 != null) return false;
        if (candte3 != null ? !candte3.equals(disEntity.candte3) : disEntity.candte3 != null) return false;
        if (candts != null ? !candts.equals(disEntity.candts) : disEntity.candts != null) return false;
        if (cantyp != null ? !cantyp.equals(disEntity.cantyp) : disEntity.cantyp != null) return false;
        if (chgtype != null ? !chgtype.equals(disEntity.chgtype) : disEntity.chgtype != null) return false;
        if (chknr != null ? !chknr.equals(disEntity.chknr) : disEntity.chknr != null) return false;
        if (crtdate != null ? !crtdate.equals(disEntity.crtdate) : disEntity.crtdate != null) return false;
        if (crtpgm != null ? !crtpgm.equals(disEntity.crtpgm) : disEntity.crtpgm != null) return false;
        if (crttime != null ? !crttime.equals(disEntity.crttime) : disEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(disEntity.crtuser) : disEntity.crtuser != null) return false;
        if (cuhrsca != null ? !cuhrsca.equals(disEntity.cuhrsca) : disEntity.cuhrsca != null) return false;
        if (dayovr != null ? !dayovr.equals(disEntity.dayovr) : disEntity.dayovr != null) return false;
        if (ddbatch != null ? !ddbatch.equals(disEntity.ddbatch) : disEntity.ddbatch != null) return false;
        if (dddate != null ? !dddate.equals(disEntity.dddate) : disEntity.dddate != null) return false;
        if (disams != null ? !disams.equals(disEntity.disams) : disEntity.disams != null) return false;
        if (disbloc != null ? !disbloc.equals(disEntity.disbloc) : disEntity.disbloc != null) return false;
        if (disdate != null ? !disdate.equals(disEntity.disdate) : disEntity.disdate != null) return false;
        if (disdte2 != null ? !disdte2.equals(disEntity.disdte2) : disEntity.disdte2 != null) return false;
        if (disdte3 != null ? !disdte3.equals(disEntity.disdte3) : disEntity.disdte3 != null) return false;
        if (disdts != null ? !disdts.equals(disEntity.disdts) : disEntity.disdts != null) return false;
        if (diskey != null ? !diskey.equals(disEntity.diskey) : disEntity.diskey != null) return false;
        if (disstat != null ? !disstat.equals(disEntity.disstat) : disEntity.disstat != null) return false;
        if (distyp != null ? !distyp.equals(disEntity.distyp) : disEntity.distyp != null) return false;
        if (docidc != null ? !docidc.equals(disEntity.docidc) : disEntity.docidc != null) return false;
        if (docido != null ? !docido.equals(disEntity.docido) : disEntity.docido != null) return false;
        if (ecampus != null ? !ecampus.equals(disEntity.ecampus) : disEntity.ecampus != null) return false;
        if (expseq != null ? !expseq.equals(disEntity.expseq) : disEntity.expseq != null) return false;
        if (feespd != null ? !feespd.equals(disEntity.feespd) : disEntity.feespd != null) return false;
        if (feespd2 != null ? !feespd2.equals(disEntity.feespd2) : disEntity.feespd2 != null) return false;
        if (feespd3 != null ? !feespd3.equals(disEntity.feespd3) : disEntity.feespd3 != null) return false;
        if (koref != null ? !koref.equals(disEntity.koref) : disEntity.koref != null) return false;
        if (loanstat != null ? !loanstat.equals(disEntity.loanstat) : disEntity.loanstat != null) return false;
        if (netadte != null ? !netadte.equals(disEntity.netadte) : disEntity.netadte != null) return false;
        if (netcdte != null ? !netcdte.equals(disEntity.netcdte) : disEntity.netcdte != null) return false;
        if (netddte != null ? !netddte.equals(disEntity.netddte) : disEntity.netddte != null) return false;
        if (origdate != null ? !origdate.equals(disEntity.origdate) : disEntity.origdate != null) return false;
        if (penrlts != null ? !penrlts.equals(disEntity.penrlts) : disEntity.penrlts != null) return false;
        if (procyr != null ? !procyr.equals(disEntity.procyr) : disEntity.procyr != null) return false;
        if (ptype != null ? !ptype.equals(disEntity.ptype) : disEntity.ptype != null) return false;
        if (reamt != null ? !reamt.equals(disEntity.reamt) : disEntity.reamt != null) return false;
        if (rebamt != null ? !rebamt.equals(disEntity.rebamt) : disEntity.rebamt != null) return false;
        if (recon != null ? !recon.equals(disEntity.recon) : disEntity.recon != null) return false;
        if (recon2 != null ? !recon2.equals(disEntity.recon2) : disEntity.recon2 != null) return false;
        if (recon3 != null ? !recon3.equals(disEntity.recon3) : disEntity.recon3 != null) return false;
        if (reconbh != null ? !reconbh.equals(disEntity.reconbh) : disEntity.reconbh != null) return false;
        if (recondt != null ? !recondt.equals(disEntity.recondt) : disEntity.recondt != null) return false;
        if (recstat != null ? !recstat.equals(disEntity.recstat) : disEntity.recstat != null) return false;
        if (refcds != null ? !refcds.equals(disEntity.refcds) : disEntity.refcds != null) return false;
        if (refchk != null ? !refchk.equals(disEntity.refchk) : disEntity.refchk != null) return false;
        if (refcode != null ? !refcode.equals(disEntity.refcode) : disEntity.refcode != null) return false;
        if (refcode2 != null ? !refcode2.equals(disEntity.refcode2) : disEntity.refcode2 != null) return false;
        if (refcode3 != null ? !refcode3.equals(disEntity.refcode3) : disEntity.refcode3 != null) return false;
        if (refdate != null ? !refdate.equals(disEntity.refdate) : disEntity.refdate != null) return false;
        if (refdate2 != null ? !refdate2.equals(disEntity.refdate2) : disEntity.refdate2 != null) return false;
        if (refdate3 != null ? !refdate3.equals(disEntity.refdate3) : disEntity.refdate3 != null) return false;
        if (refdts != null ? !refdts.equals(disEntity.refdts) : disEntity.refdts != null) return false;
        if (refnr != null ? !refnr.equals(disEntity.refnr) : disEntity.refnr != null) return false;
        if (revdate != null ? !revdate.equals(disEntity.revdate) : disEntity.revdate != null) return false;
        if (revpgm != null ? !revpgm.equals(disEntity.revpgm) : disEntity.revpgm != null) return false;
        if (revtime != null ? !revtime.equals(disEntity.revtime) : disEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(disEntity.revuser) : disEntity.revuser != null) return false;
        if (sartran != null ? !sartran.equals(disEntity.sartran) : disEntity.sartran != null) return false;
        if (scitzn != null ? !scitzn.equals(disEntity.scitzn) : disEntity.scitzn != null) return false;
        if (senrlst != null ? !senrlst.equals(disEntity.senrlst) : disEntity.senrlst != null) return false;
        if (senrsdt != null ? !senrsdt.equals(disEntity.senrsdt) : disEntity.senrsdt != null) return false;
        if (seqno != null ? !seqno.equals(disEntity.seqno) : disEntity.seqno != null) return false;
        if (sessid != null ? !sessid.equals(disEntity.sessid) : disEntity.sessid != null) return false;
        if (sid != null ? !sid.equals(disEntity.sid) : disEntity.sid != null) return false;
        if (sndbtch != null ? !sndbtch.equals(disEntity.sndbtch) : disEntity.sndbtch != null) return false;
        if (snddate != null ? !snddate.equals(disEntity.snddate) : disEntity.snddate != null) return false;
        if (taxcode != null ? !taxcode.equals(disEntity.taxcode) : disEntity.taxcode != null) return false;
        if (term != null ? !term.equals(disEntity.term) : disEntity.term != null) return false;
        if (trndate != null ? !trndate.equals(disEntity.trndate) : disEntity.trndate != null) return false;
        if (trndesc != null ? !trndesc.equals(disEntity.trndesc) : disEntity.trndesc != null) return false;
        if (trntype != null ? !trntype.equals(disEntity.trntype) : disEntity.trntype != null) return false;
        if (typeaid != null ? !typeaid.equals(disEntity.typeaid) : disEntity.typeaid != null) return false;
        if (typechk != null ? !typechk.equals(disEntity.typechk) : disEntity.typechk != null) return false;
        if (ucode != null ? !ucode.equals(disEntity.ucode) : disEntity.ucode != null) return false;
        if (untdesc != null ? !untdesc.equals(disEntity.untdesc) : disEntity.untdesc != null) return false;
        if (unused1 != null ? !unused1.equals(disEntity.unused1) : disEntity.unused1 != null) return false;
        if (unuseda != null ? !unuseda.equals(disEntity.unuseda) : disEntity.unuseda != null) return false;
        if (unusedb != null ? !unusedb.equals(disEntity.unusedb) : disEntity.unusedb != null) return false;
        if (unusedc != null ? !unusedc.equals(disEntity.unusedc) : disEntity.unusedc != null) return false;
        if (unusedd != null ? !unusedd.equals(disEntity.unusedd) : disEntity.unusedd != null) return false;
        if (unusedf != null ? !unusedf.equals(disEntity.unusedf) : disEntity.unusedf != null) return false;
        if (unusedg != null ? !unusedg.equals(disEntity.unusedg) : disEntity.unusedg != null) return false;
        if (usercd1 != null ? !usercd1.equals(disEntity.usercd1) : disEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(disEntity.usercd2) : disEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(disEntity.usercd3) : disEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(disEntity.usercd4) : disEntity.usercd4 != null) return false;
        if (usercd5 != null ? !usercd5.equals(disEntity.usercd5) : disEntity.usercd5 != null) return false;
        if (usercd6 != null ? !usercd6.equals(disEntity.usercd6) : disEntity.usercd6 != null) return false;
        if (usercd7 != null ? !usercd7.equals(disEntity.usercd7) : disEntity.usercd7 != null) return false;
        if (usercd8 != null ? !usercd8.equals(disEntity.usercd8) : disEntity.usercd8 != null) return false;
        if (usernr3 != null ? !usernr3.equals(disEntity.usernr3) : disEntity.usernr3 != null) return false;
        if (usernr4 != null ? !usernr4.equals(disEntity.usernr4) : disEntity.usernr4 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (diskey != null ? diskey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (aidid != null ? aidid.hashCode() : 0);
        result = 31 * result + (ptype != null ? ptype.hashCode() : 0);
        result = 31 * result + (seqno != null ? seqno.hashCode() : 0);
        result = 31 * result + (unuseda != null ? unuseda.hashCode() : 0);
        result = 31 * result + (unusedb != null ? unusedb.hashCode() : 0);
        result = 31 * result + (unusedc != null ? unusedc.hashCode() : 0);
        result = 31 * result + (unusedd != null ? unusedd.hashCode() : 0);
        result = 31 * result + unusede;
        result = 31 * result + (unused1 != null ? unused1.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtpgm != null ? crtpgm.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revpgm != null ? revpgm.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (scitzn != null ? scitzn.hashCode() : 0);
        result = 31 * result + (penrlts != null ? penrlts.hashCode() : 0);
        result = 31 * result + (aenrlts != null ? aenrlts.hashCode() : 0);
        result = 31 * result + (loanstat != null ? loanstat.hashCode() : 0);
        result = 31 * result + (origdate != null ? origdate.hashCode() : 0);
        result = 31 * result + (trndate != null ? trndate.hashCode() : 0);
        result = 31 * result + (trntype != null ? trntype.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (typechk != null ? typechk.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (actnr != null ? actnr.hashCode() : 0);
        result = 31 * result + (refnr != null ? refnr.hashCode() : 0);
        result = 31 * result + (chknr != null ? chknr.hashCode() : 0);
        result = 31 * result + (chgtype != null ? chgtype.hashCode() : 0);
        result = 31 * result + (trndesc != null ? trndesc.hashCode() : 0);
        result = 31 * result + (untdesc != null ? untdesc.hashCode() : 0);
        result = 31 * result + (sartran != null ? sartran.hashCode() : 0);
        result = 31 * result + (reamt != null ? reamt.hashCode() : 0);
        result = 31 * result + (koref != null ? koref.hashCode() : 0);
        result = 31 * result + priornr;
        result = 31 * result + (disbloc != null ? disbloc.hashCode() : 0);
        result = 31 * result + (taxcode != null ? taxcode.hashCode() : 0);
        result = 31 * result + (typeaid != null ? typeaid.hashCode() : 0);
        result = 31 * result + (cuhrsca != null ? cuhrsca.hashCode() : 0);
        result = 31 * result + (ecampus != null ? ecampus.hashCode() : 0);
        result = 31 * result + (adisbeg != null ? adisbeg.hashCode() : 0);
        result = 31 * result + adisamt;
        result = 31 * result + afeeamt;
        result = 31 * result + anetamt;
        result = 31 * result + (disdate != null ? disdate.hashCode() : 0);
        result = 31 * result + grosamt;
        result = 31 * result + feeamt;
        result = 31 * result + netamt;
        result = 31 * result + (acancde != null ? acancde.hashCode() : 0);
        result = 31 * result + (acandte != null ? acandte.hashCode() : 0);
        result = 31 * result + (disstat != null ? disstat.hashCode() : 0);
        result = 31 * result + (refcode != null ? refcode.hashCode() : 0);
        result = 31 * result + (refdate != null ? refdate.hashCode() : 0);
        result = 31 * result + (snddate != null ? snddate.hashCode() : 0);
        result = 31 * result + (unusedf != null ? unusedf.hashCode() : 0);
        result = 31 * result + (ddbatch != null ? ddbatch.hashCode() : 0);
        result = 31 * result + (dddate != null ? dddate.hashCode() : 0);
        result = 31 * result + (recon != null ? recon.hashCode() : 0);
        result = 31 * result + (recondt != null ? recondt.hashCode() : 0);
        result = 31 * result + (netadte != null ? netadte.hashCode() : 0);
        result = 31 * result + netaamt;
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + (usercd5 != null ? usercd5.hashCode() : 0);
        result = 31 * result + (usercd6 != null ? usercd6.hashCode() : 0);
        result = 31 * result + (usercd7 != null ? usercd7.hashCode() : 0);
        result = 31 * result + (usercd8 != null ? usercd8.hashCode() : 0);
        result = 31 * result + usernr1;
        result = 31 * result + usernr2;
        result = 31 * result + (usernr3 != null ? usernr3.hashCode() : 0);
        result = 31 * result + (usernr4 != null ? usernr4.hashCode() : 0);
        result = 31 * result + (senrlst != null ? senrlst.hashCode() : 0);
        result = 31 * result + (senrsdt != null ? senrsdt.hashCode() : 0);
        result = 31 * result + aogramt;
        result = 31 * result + (distyp != null ? distyp.hashCode() : 0);
        result = 31 * result + (adjtyp != null ? adjtyp.hashCode() : 0);
        result = 31 * result + (expseq != null ? expseq.hashCode() : 0);
        result = 31 * result + (refchk != null ? refchk.hashCode() : 0);
        result = 31 * result + netdamt;
        result = 31 * result + (netddte != null ? netddte.hashCode() : 0);
        result = 31 * result + (cantyp != null ? cantyp.hashCode() : 0);
        result = 31 * result + netcamt;
        result = 31 * result + (netcdte != null ? netcdte.hashCode() : 0);
        result = 31 * result + (unusedg != null ? unusedg.hashCode() : 0);
        result = 31 * result + (acttyp != null ? acttyp.hashCode() : 0);
        result = 31 * result + (ackdte != null ? ackdte.hashCode() : 0);
        result = 31 * result + (disdte2 != null ? disdte2.hashCode() : 0);
        result = 31 * result + disamt2;
        result = 31 * result + (cancde2 != null ? cancde2.hashCode() : 0);
        result = 31 * result + (candte2 != null ? candte2.hashCode() : 0);
        result = 31 * result + (adisdt2 != null ? adisdt2.hashCode() : 0);
        result = 31 * result + agroam2;
        result = 31 * result + (refcode2 != null ? refcode2.hashCode() : 0);
        result = 31 * result + (refdate2 != null ? refdate2.hashCode() : 0);
        result = 31 * result + (recon2 != null ? recon2.hashCode() : 0);
        result = 31 * result + (acttyp2 != null ? acttyp2.hashCode() : 0);
        result = 31 * result + (disdte3 != null ? disdte3.hashCode() : 0);
        result = 31 * result + disamt3;
        result = 31 * result + (cancde3 != null ? cancde3.hashCode() : 0);
        result = 31 * result + (candte3 != null ? candte3.hashCode() : 0);
        result = 31 * result + (adisdt3 != null ? adisdt3.hashCode() : 0);
        result = 31 * result + agroam3;
        result = 31 * result + (refcode3 != null ? refcode3.hashCode() : 0);
        result = 31 * result + (refdate3 != null ? refdate3.hashCode() : 0);
        result = 31 * result + (recon3 != null ? recon3.hashCode() : 0);
        result = 31 * result + (acttyp3 != null ? acttyp3.hashCode() : 0);
        result = 31 * result + (afrmfg != null ? afrmfg.hashCode() : 0);
        result = 31 * result + (afrmfg2 != null ? afrmfg2.hashCode() : 0);
        result = 31 * result + (afrmfg3 != null ? afrmfg3.hashCode() : 0);
        result = 31 * result + (sndbtch != null ? sndbtch.hashCode() : 0);
        result = 31 * result + (reconbh != null ? reconbh.hashCode() : 0);
        result = 31 * result + (aorigbth != null ? aorigbth.hashCode() : 0);
        result = 31 * result + (asid != null ? asid.hashCode() : 0);
        result = 31 * result + (aaidid != null ? aaidid.hashCode() : 0);
        result = 31 * result + (aptype != null ? aptype.hashCode() : 0);
        result = 31 * result + aseqno;
        result = 31 * result + (artnamt != null ? artnamt.hashCode() : 0);
        result = 31 * result + (acanamt != null ? acanamt.hashCode() : 0);
        result = 31 * result + (apptoar != null ? apptoar.hashCode() : 0);
        result = 31 * result + (rebamt != null ? rebamt.hashCode() : 0);
        result = 31 * result + (arebamt != null ? arebamt.hashCode() : 0);
        result = 31 * result + (adisdte != null ? adisdte.hashCode() : 0);
        result = 31 * result + (feespd != null ? feespd.hashCode() : 0);
        result = 31 * result + (feespd2 != null ? feespd2.hashCode() : 0);
        result = 31 * result + (feespd3 != null ? feespd3.hashCode() : 0);
        result = 31 * result + pdbnum;
        result = 31 * result + (docido != null ? docido.hashCode() : 0);
        result = 31 * result + (docidc != null ? docidc.hashCode() : 0);
        result = 31 * result + (dayovr != null ? dayovr.hashCode() : 0);
        result = 31 * result + (disams != null ? disams.hashCode() : 0);
        result = 31 * result + (disdts != null ? disdts.hashCode() : 0);
        result = 31 * result + (agroas != null ? agroas.hashCode() : 0);
        result = 31 * result + (adisds != null ? adisds.hashCode() : 0);
        result = 31 * result + (cancds != null ? cancds.hashCode() : 0);
        result = 31 * result + (candts != null ? candts.hashCode() : 0);
        result = 31 * result + (refcds != null ? refcds.hashCode() : 0);
        result = 31 * result + (refdts != null ? refdts.hashCode() : 0);
        result = 31 * result + (sessid != null ? sessid.hashCode() : 0);
        return result;
    }
}
