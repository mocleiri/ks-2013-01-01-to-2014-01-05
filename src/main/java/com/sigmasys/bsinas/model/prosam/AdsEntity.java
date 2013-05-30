package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/25/12
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "ADS", schema = "SIGMA", catalog = "")
@Entity
public class AdsEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getAdskey();
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

    private String adskey;

    @javax.persistence.Column(name = "ADSKEY")
    @Id
    public String getAdskey() {
        return adskey;
    }

    public void setAdskey(String adskey) {
        this.adskey = adskey;
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

    private int recseq;

    @javax.persistence.Column(name = "RECSEQ")
    @Basic
    public int getRecseq() {
        return recseq;
    }

    public void setRecseq(int recseq) {
        this.recseq = recseq;
    }

    private String crtdte;

    @javax.persistence.Column(name = "CRTDTE")
    @Basic
    public String getCrtdte() {
        return crtdte;
    }

    public void setCrtdte(String crtdte) {
        this.crtdte = crtdte;
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

    private String revdte;

    @javax.persistence.Column(name = "REVDTE")
    @Basic
    public String getRevdte() {
        return revdte;
    }

    public void setRevdte(String revdte) {
        this.revdte = revdte;
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

    private String status;

    @javax.persistence.Column(name = "STATUS")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String exprdte;

    @javax.persistence.Column(name = "EXPRDTE")
    @Basic
    public String getExprdte() {
        return exprdte;
    }

    public void setExprdte(String exprdte) {
        this.exprdte = exprdte;
    }

    private String lnsid;

    @javax.persistence.Column(name = "LNSID")
    @Basic
    public String getLnsid() {
        return lnsid;
    }

    public void setLnsid(String lnsid) {
        this.lnsid = lnsid;
    }

    private String lntype;

    @javax.persistence.Column(name = "LNTYPE")
    @Basic
    public String getLntype() {
        return lntype;
    }

    public void setLntype(String lntype) {
        this.lntype = lntype;
    }

    private String lnyear;

    @javax.persistence.Column(name = "LNYEAR")
    @Basic
    public String getLnyear() {
        return lnyear;
    }

    public void setLnyear(String lnyear) {
        this.lnyear = lnyear;
    }

    private String lnschcde;

    @javax.persistence.Column(name = "LNSCHCDE")
    @Basic
    public String getLnschcde() {
        return lnschcde;
    }

    public void setLnschcde(String lnschcde) {
        this.lnschcde = lnschcde;
    }

    private String seqno2;

    @javax.persistence.Column(name = "SEQNO2")
    @Basic
    public String getSeqno2() {
        return seqno2;
    }

    public void setSeqno2(String seqno2) {
        this.seqno2 = seqno2;
    }

    private int dseqno;

    @javax.persistence.Column(name = "DSEQNO")
    @Basic
    public int getDseqno() {
        return dseqno;
    }

    public void setDseqno(int dseqno) {
        this.dseqno = dseqno;
    }

    private int eseqno;

    @javax.persistence.Column(name = "ESEQNO")
    @Basic
    public int getEseqno() {
        return eseqno;
    }

    public void setEseqno(int eseqno) {
        this.eseqno = eseqno;
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

    private String typeaid;

    @javax.persistence.Column(name = "TYPEAID")
    @Basic
    public String getTypeaid() {
        return typeaid;
    }

    public void setTypeaid(String typeaid) {
        this.typeaid = typeaid;
    }

    private String acttype;

    @javax.persistence.Column(name = "ACTTYPE")
    @Basic
    public String getActtype() {
        return acttype;
    }

    public void setActtype(String acttype) {
        this.acttype = acttype;
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

    private String trandte;

    @javax.persistence.Column(name = "TRANDTE")
    @Basic
    public String getTrandte() {
        return trandte;
    }

    public void setTrandte(String trandte) {
        this.trandte = trandte;
    }

    private BigDecimal tranamt;

    @javax.persistence.Column(name = "TRANAMT")
    @Basic
    public BigDecimal getTranamt() {
        return tranamt;
    }

    public void setTranamt(BigDecimal tranamt) {
        this.tranamt = tranamt;
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

    private int agroamt;

    @javax.persistence.Column(name = "AGROAMT")
    @Basic
    public int getAgroamt() {
        return agroamt;
    }

    public void setAgroamt(int agroamt) {
        this.agroamt = agroamt;
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

    private int netaamt;

    @javax.persistence.Column(name = "NETAAMT")
    @Basic
    public int getNetaamt() {
        return netaamt;
    }

    public void setNetaamt(int netaamt) {
        this.netaamt = netaamt;
    }

    private String expstat;

    @javax.persistence.Column(name = "EXPSTAT")
    @Basic
    public String getExpstat() {
        return expstat;
    }

    public void setExpstat(String expstat) {
        this.expstat = expstat;
    }

    private String expdte;

    @javax.persistence.Column(name = "EXPDTE")
    @Basic
    public String getExpdte() {
        return expdte;
    }

    public void setExpdte(String expdte) {
        this.expdte = expdte;
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

    private String rcnstat;

    @javax.persistence.Column(name = "RCNSTAT")
    @Basic
    public String getRcnstat() {
        return rcnstat;
    }

    public void setRcnstat(String rcnstat) {
        this.rcnstat = rcnstat;
    }

    private String rcndte;

    @javax.persistence.Column(name = "RCNDTE")
    @Basic
    public String getRcndte() {
        return rcndte;
    }

    public void setRcndte(String rcndte) {
        this.rcndte = rcndte;
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

    private String schcode;

    @javax.persistence.Column(name = "SCHCODE")
    @Basic
    public String getSchcode() {
        return schcode;
    }

    public void setSchcode(String schcode) {
        this.schcode = schcode;
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

    private String disbloc;

    @javax.persistence.Column(name = "DISBLOC")
    @Basic
    public String getDisbloc() {
        return disbloc;
    }

    public void setDisbloc(String disbloc) {
        this.disbloc = disbloc;
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

    private String actnr;

    @javax.persistence.Column(name = "ACTNR")
    @Basic
    public String getActnr() {
        return actnr;
    }

    public void setActnr(String actnr) {
        this.actnr = actnr;
    }

    private String batchnr;

    @javax.persistence.Column(name = "BATCHNR")
    @Basic
    public String getBatchnr() {
        return batchnr;
    }

    public void setBatchnr(String batchnr) {
        this.batchnr = batchnr;
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

    private String sartran;

    @javax.persistence.Column(name = "SARTRAN")
    @Basic
    public String getSartran() {
        return sartran;
    }

    public void setSartran(String sartran) {
        this.sartran = sartran;
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

    private String taxcode;

    @javax.persistence.Column(name = "TAXCODE")
    @Basic
    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
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

    private String chknr;

    @javax.persistence.Column(name = "CHKNR")
    @Basic
    public String getChknr() {
        return chknr;
    }

    public void setChknr(String chknr) {
        this.chknr = chknr;
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

    private String refndno;

    @javax.persistence.Column(name = "REFNDNO")
    @Basic
    public String getRefndno() {
        return refndno;
    }

    public void setRefndno(String refndno) {
        this.refndno = refndno;
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

    private String penrlt1;

    @javax.persistence.Column(name = "PENRLT1")
    @Basic
    public String getPenrlt1() {
        return penrlt1;
    }

    public void setPenrlt1(String penrlt1) {
        this.penrlt1 = penrlt1;
    }

    private String penrlt2;

    @javax.persistence.Column(name = "PENRLT2")
    @Basic
    public String getPenrlt2() {
        return penrlt2;
    }

    public void setPenrlt2(String penrlt2) {
        this.penrlt2 = penrlt2;
    }

    private String penrlt3;

    @javax.persistence.Column(name = "PENRLT3")
    @Basic
    public String getPenrlt3() {
        return penrlt3;
    }

    public void setPenrlt3(String penrlt3) {
        this.penrlt3 = penrlt3;
    }

    private String penrlt4;

    @javax.persistence.Column(name = "PENRLT4")
    @Basic
    public String getPenrlt4() {
        return penrlt4;
    }

    public void setPenrlt4(String penrlt4) {
        this.penrlt4 = penrlt4;
    }

    private String penrlt5;

    @javax.persistence.Column(name = "PENRLT5")
    @Basic
    public String getPenrlt5() {
        return penrlt5;
    }

    public void setPenrlt5(String penrlt5) {
        this.penrlt5 = penrlt5;
    }

    private String penrlt6;

    @javax.persistence.Column(name = "PENRLT6")
    @Basic
    public String getPenrlt6() {
        return penrlt6;
    }

    public void setPenrlt6(String penrlt6) {
        this.penrlt6 = penrlt6;
    }

    private String aenrlt1;

    @javax.persistence.Column(name = "AENRLT1")
    @Basic
    public String getAenrlt1() {
        return aenrlt1;
    }

    public void setAenrlt1(String aenrlt1) {
        this.aenrlt1 = aenrlt1;
    }

    private String aenrlt2;

    @javax.persistence.Column(name = "AENRLT2")
    @Basic
    public String getAenrlt2() {
        return aenrlt2;
    }

    public void setAenrlt2(String aenrlt2) {
        this.aenrlt2 = aenrlt2;
    }

    private String aenrlt3;

    @javax.persistence.Column(name = "AENRLT3")
    @Basic
    public String getAenrlt3() {
        return aenrlt3;
    }

    public void setAenrlt3(String aenrlt3) {
        this.aenrlt3 = aenrlt3;
    }

    private String aenrlt4;

    @javax.persistence.Column(name = "AENRLT4")
    @Basic
    public String getAenrlt4() {
        return aenrlt4;
    }

    public void setAenrlt4(String aenrlt4) {
        this.aenrlt4 = aenrlt4;
    }

    private String aenrlt5;

    @javax.persistence.Column(name = "AENRLT5")
    @Basic
    public String getAenrlt5() {
        return aenrlt5;
    }

    public void setAenrlt5(String aenrlt5) {
        this.aenrlt5 = aenrlt5;
    }

    private String aenrlt6;

    @javax.persistence.Column(name = "AENRLT6")
    @Basic
    public String getAenrlt6() {
        return aenrlt6;
    }

    public void setAenrlt6(String aenrlt6) {
        this.aenrlt6 = aenrlt6;
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

    private String parssn;

    @javax.persistence.Column(name = "PARSSN")
    @Basic
    public String getParssn() {
        return parssn;
    }

    public void setParssn(String parssn) {
        this.parssn = parssn;
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

    private String ackdte;

    @javax.persistence.Column(name = "ACKDTE")
    @Basic
    public String getAckdte() {
        return ackdte;
    }

    public void setAckdte(String ackdte) {
        this.ackdte = ackdte;
    }

    private String act01;

    @javax.persistence.Column(name = "ACT01")
    @Basic
    public String getAct01() {
        return act01;
    }

    public void setAct01(String act01) {
        this.act01 = act01;
    }

    private String act02;

    @javax.persistence.Column(name = "ACT02")
    @Basic
    public String getAct02() {
        return act02;
    }

    public void setAct02(String act02) {
        this.act02 = act02;
    }

    private String act03;

    @javax.persistence.Column(name = "ACT03")
    @Basic
    public String getAct03() {
        return act03;
    }

    public void setAct03(String act03) {
        this.act03 = act03;
    }

    private String act04;

    @javax.persistence.Column(name = "ACT04")
    @Basic
    public String getAct04() {
        return act04;
    }

    public void setAct04(String act04) {
        this.act04 = act04;
    }

    private String act05;

    @javax.persistence.Column(name = "ACT05")
    @Basic
    public String getAct05() {
        return act05;
    }

    public void setAct05(String act05) {
        this.act05 = act05;
    }

    private String act06;

    @javax.persistence.Column(name = "ACT06")
    @Basic
    public String getAct06() {
        return act06;
    }

    public void setAct06(String act06) {
        this.act06 = act06;
    }

    private String act07;

    @javax.persistence.Column(name = "ACT07")
    @Basic
    public String getAct07() {
        return act07;
    }

    public void setAct07(String act07) {
        this.act07 = act07;
    }

    private String act08;

    @javax.persistence.Column(name = "ACT08")
    @Basic
    public String getAct08() {
        return act08;
    }

    public void setAct08(String act08) {
        this.act08 = act08;
    }

    private String act09;

    @javax.persistence.Column(name = "ACT09")
    @Basic
    public String getAct09() {
        return act09;
    }

    public void setAct09(String act09) {
        this.act09 = act09;
    }

    private String act10;

    @javax.persistence.Column(name = "ACT10")
    @Basic
    public String getAct10() {
        return act10;
    }

    public void setAct10(String act10) {
        this.act10 = act10;
    }

    private String bkcd01;

    @javax.persistence.Column(name = "BKCD01")
    @Basic
    public String getBkcd01() {
        return bkcd01;
    }

    public void setBkcd01(String bkcd01) {
        this.bkcd01 = bkcd01;
    }

    private String bkcd02;

    @javax.persistence.Column(name = "BKCD02")
    @Basic
    public String getBkcd02() {
        return bkcd02;
    }

    public void setBkcd02(String bkcd02) {
        this.bkcd02 = bkcd02;
    }

    private String bkcd03;

    @javax.persistence.Column(name = "BKCD03")
    @Basic
    public String getBkcd03() {
        return bkcd03;
    }

    public void setBkcd03(String bkcd03) {
        this.bkcd03 = bkcd03;
    }

    private String bkcd04;

    @javax.persistence.Column(name = "BKCD04")
    @Basic
    public String getBkcd04() {
        return bkcd04;
    }

    public void setBkcd04(String bkcd04) {
        this.bkcd04 = bkcd04;
    }

    private String bkcd05;

    @javax.persistence.Column(name = "BKCD05")
    @Basic
    public String getBkcd05() {
        return bkcd05;
    }

    public void setBkcd05(String bkcd05) {
        this.bkcd05 = bkcd05;
    }

    private String bkcd06;

    @javax.persistence.Column(name = "BKCD06")
    @Basic
    public String getBkcd06() {
        return bkcd06;
    }

    public void setBkcd06(String bkcd06) {
        this.bkcd06 = bkcd06;
    }

    private String bkcd07;

    @javax.persistence.Column(name = "BKCD07")
    @Basic
    public String getBkcd07() {
        return bkcd07;
    }

    public void setBkcd07(String bkcd07) {
        this.bkcd07 = bkcd07;
    }

    private String bkcd08;

    @javax.persistence.Column(name = "BKCD08")
    @Basic
    public String getBkcd08() {
        return bkcd08;
    }

    public void setBkcd08(String bkcd08) {
        this.bkcd08 = bkcd08;
    }

    private String bkcd09;

    @javax.persistence.Column(name = "BKCD09")
    @Basic
    public String getBkcd09() {
        return bkcd09;
    }

    public void setBkcd09(String bkcd09) {
        this.bkcd09 = bkcd09;
    }

    private String bkcd10;

    @javax.persistence.Column(name = "BKCD10")
    @Basic
    public String getBkcd10() {
        return bkcd10;
    }

    public void setBkcd10(String bkcd10) {
        this.bkcd10 = bkcd10;
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

    private String reject1;

    @javax.persistence.Column(name = "REJECT1")
    @Basic
    public String getReject1() {
        return reject1;
    }

    public void setReject1(String reject1) {
        this.reject1 = reject1;
    }

    private String reject2;

    @javax.persistence.Column(name = "REJECT2")
    @Basic
    public String getReject2() {
        return reject2;
    }

    public void setReject2(String reject2) {
        this.reject2 = reject2;
    }

    private String reject3;

    @javax.persistence.Column(name = "REJECT3")
    @Basic
    public String getReject3() {
        return reject3;
    }

    public void setReject3(String reject3) {
        this.reject3 = reject3;
    }

    private String reject4;

    @javax.persistence.Column(name = "REJECT4")
    @Basic
    public String getReject4() {
        return reject4;
    }

    public void setReject4(String reject4) {
        this.reject4 = reject4;
    }

    private String reject5;

    @javax.persistence.Column(name = "REJECT5")
    @Basic
    public String getReject5() {
        return reject5;
    }

    public void setReject5(String reject5) {
        this.reject5 = reject5;
    }

    private String reject6;

    @javax.persistence.Column(name = "REJECT6")
    @Basic
    public String getReject6() {
        return reject6;
    }

    public void setReject6(String reject6) {
        this.reject6 = reject6;
    }

    private String reject7;

    @javax.persistence.Column(name = "REJECT7")
    @Basic
    public String getReject7() {
        return reject7;
    }

    public void setReject7(String reject7) {
        this.reject7 = reject7;
    }

    private String reject8;

    @javax.persistence.Column(name = "REJECT8")
    @Basic
    public String getReject8() {
        return reject8;
    }

    public void setReject8(String reject8) {
        this.reject8 = reject8;
    }

    private String reject9;

    @javax.persistence.Column(name = "REJECT9")
    @Basic
    public String getReject9() {
        return reject9;
    }

    public void setReject9(String reject9) {
        this.reject9 = reject9;
    }

    private String rejecta;

    @javax.persistence.Column(name = "REJECTA")
    @Basic
    public String getRejecta() {
        return rejecta;
    }

    public void setRejecta(String rejecta) {
        this.rejecta = rejecta;
    }

    private String bkddate;

    @javax.persistence.Column(name = "BKDDATE")
    @Basic
    public String getBkddate() {
        return bkddate;
    }

    public void setBkddate(String bkddate) {
        this.bkddate = bkddate;
    }

    private String expbtch;

    @javax.persistence.Column(name = "EXPBTCH")
    @Basic
    public String getExpbtch() {
        return expbtch;
    }

    public void setExpbtch(String expbtch) {
        this.expbtch = expbtch;
    }

    private String rcnbtch;

    @javax.persistence.Column(name = "RCNBTCH")
    @Basic
    public String getRcnbtch() {
        return rcnbtch;
    }

    public void setRcnbtch(String rcnbtch) {
        this.rcnbtch = rcnbtch;
    }

    private String chrtact;

    @javax.persistence.Column(name = "CHRTACT")
    @Basic
    public String getChrtact() {
        return chrtact;
    }

    public void setChrtact(String chrtact) {
        this.chrtact = chrtact;
    }

    private String firdisf;

    @javax.persistence.Column(name = "FIRDISF")
    @Basic
    public String getFirdisf() {
        return firdisf;
    }

    public void setFirdisf(String firdisf) {
        this.firdisf = firdisf;
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

    private BigDecimal arebloc;

    @javax.persistence.Column(name = "AREBLOC")
    @Basic
    public BigDecimal getArebloc() {
        return arebloc;
    }

    public void setArebloc(BigDecimal arebloc) {
        this.arebloc = arebloc;
    }

    private String pmnid;

    @javax.persistence.Column(name = "PMNID")
    @Basic
    public String getPmnid() {
        return pmnid;
    }

    public void setPmnid(String pmnid) {
        this.pmnid = pmnid;
    }

    private String acdlvl;

    @javax.persistence.Column(name = "ACDLVL")
    @Basic
    public String getAcdlvl() {
        return acdlvl;
    }

    public void setAcdlvl(String acdlvl) {
        this.acdlvl = acdlvl;
    }

    private BigDecimal gpa;

    @javax.persistence.Column(name = "GPA")
    @Basic
    public BigDecimal getGpa() {
        return gpa;
    }

    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    private int sarrtcd;

    @javax.persistence.Column(name = "SARRTCD")
    @Basic
    public int getSarrtcd() {
        return sarrtcd;
    }

    public void setSarrtcd(int sarrtcd) {
        this.sarrtcd = sarrtcd;
    }

    private String sarrcns;

    @javax.persistence.Column(name = "SARRCNS")
    @Basic
    public String getSarrcns() {
        return sarrcns;
    }

    public void setSarrcns(String sarrcns) {
        this.sarrcns = sarrcns;
    }

    private String sarkey;

    @javax.persistence.Column(name = "SARKEY")
    @Basic
    public String getSarkey() {
        return sarkey;
    }

    public void setSarkey(String sarkey) {
        this.sarkey = sarkey;
    }

    private String sarrtst;

    @javax.persistence.Column(name = "SARRTST")
    @Basic
    public String getSarrtst() {
        return sarrtst;
    }

    public void setSarrtst(String sarrtst) {
        this.sarrtst = sarrtst;
    }

    private String sarpstd;

    @javax.persistence.Column(name = "SARPSTD")
    @Basic
    public String getSarpstd() {
        return sarpstd;
    }

    public void setSarpstd(String sarpstd) {
        this.sarpstd = sarpstd;
    }

    private String sarpstt;

    @javax.persistence.Column(name = "SARPSTT")
    @Basic
    public String getSarpstt() {
        return sarpstt;
    }

    public void setSarpstt(String sarpstt) {
        this.sarpstt = sarpstt;
    }

    private String sarrcnd;

    @javax.persistence.Column(name = "SARRCND")
    @Basic
    public String getSarrcnd() {
        return sarrcnd;
    }

    public void setSarrcnd(String sarrcnd) {
        this.sarrcnd = sarrcnd;
    }

    private String sarrcnt;

    @javax.persistence.Column(name = "SARRCNT")
    @Basic
    public String getSarrcnt() {
        return sarrcnt;
    }

    public void setSarrcnt(String sarrcnt) {
        this.sarrcnt = sarrcnt;
    }

    private String antddte;

    @javax.persistence.Column(name = "ANTDDTE")
    @Basic
    public String getAntddte() {
        return antddte;
    }

    public void setAntddte(String antddte) {
        this.antddte = antddte;
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

    private String defexpt;

    @javax.persistence.Column(name = "DEFEXPT")
    @Basic
    public String getDefexpt() {
        return defexpt;
    }

    public void setDefexpt(String defexpt) {
        this.defexpt = defexpt;
    }

    private String enrscd;

    @javax.persistence.Column(name = "ENRSCD")
    @Basic
    public String getEnrscd() {
        return enrscd;
    }

    public void setEnrscd(String enrscd) {
        this.enrscd = enrscd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdsEntity adsEntity = (AdsEntity) o;

        if (afeeamt != adsEntity.afeeamt) return false;
        if (agroamt != adsEntity.agroamt) return false;
        if (anetamt != adsEntity.anetamt) return false;
        if (dseqno != adsEntity.dseqno) return false;
        if (eseqno != adsEntity.eseqno) return false;
        if (netaamt != adsEntity.netaamt) return false;
        if (priornr != adsEntity.priornr) return false;
        if (recseq != adsEntity.recseq) return false;
        if (revlev != adsEntity.revlev) return false;
        if (sarrtcd != adsEntity.sarrtcd) return false;
        if (usernr1 != adsEntity.usernr1) return false;
        if (usernr2 != adsEntity.usernr2) return false;
        if (acdlvl != null ? !acdlvl.equals(adsEntity.acdlvl) : adsEntity.acdlvl != null) return false;
        if (ackdte != null ? !ackdte.equals(adsEntity.ackdte) : adsEntity.ackdte != null) return false;
        if (act01 != null ? !act01.equals(adsEntity.act01) : adsEntity.act01 != null) return false;
        if (act02 != null ? !act02.equals(adsEntity.act02) : adsEntity.act02 != null) return false;
        if (act03 != null ? !act03.equals(adsEntity.act03) : adsEntity.act03 != null) return false;
        if (act04 != null ? !act04.equals(adsEntity.act04) : adsEntity.act04 != null) return false;
        if (act05 != null ? !act05.equals(adsEntity.act05) : adsEntity.act05 != null) return false;
        if (act06 != null ? !act06.equals(adsEntity.act06) : adsEntity.act06 != null) return false;
        if (act07 != null ? !act07.equals(adsEntity.act07) : adsEntity.act07 != null) return false;
        if (act08 != null ? !act08.equals(adsEntity.act08) : adsEntity.act08 != null) return false;
        if (act09 != null ? !act09.equals(adsEntity.act09) : adsEntity.act09 != null) return false;
        if (act10 != null ? !act10.equals(adsEntity.act10) : adsEntity.act10 != null) return false;
        if (actnr != null ? !actnr.equals(adsEntity.actnr) : adsEntity.actnr != null) return false;
        if (acttype != null ? !acttype.equals(adsEntity.acttype) : adsEntity.acttype != null) return false;
        if (adskey != null ? !adskey.equals(adsEntity.adskey) : adsEntity.adskey != null) return false;
        if (aenrlt1 != null ? !aenrlt1.equals(adsEntity.aenrlt1) : adsEntity.aenrlt1 != null) return false;
        if (aenrlt2 != null ? !aenrlt2.equals(adsEntity.aenrlt2) : adsEntity.aenrlt2 != null) return false;
        if (aenrlt3 != null ? !aenrlt3.equals(adsEntity.aenrlt3) : adsEntity.aenrlt3 != null) return false;
        if (aenrlt4 != null ? !aenrlt4.equals(adsEntity.aenrlt4) : adsEntity.aenrlt4 != null) return false;
        if (aenrlt5 != null ? !aenrlt5.equals(adsEntity.aenrlt5) : adsEntity.aenrlt5 != null) return false;
        if (aenrlt6 != null ? !aenrlt6.equals(adsEntity.aenrlt6) : adsEntity.aenrlt6 != null) return false;
        if (aidid != null ? !aidid.equals(adsEntity.aidid) : adsEntity.aidid != null) return false;
        if (antddte != null ? !antddte.equals(adsEntity.antddte) : adsEntity.antddte != null) return false;
        if (arebamt != null ? !arebamt.equals(adsEntity.arebamt) : adsEntity.arebamt != null) return false;
        if (arebloc != null ? !arebloc.equals(adsEntity.arebloc) : adsEntity.arebloc != null) return false;
        if (batchnr != null ? !batchnr.equals(adsEntity.batchnr) : adsEntity.batchnr != null) return false;
        if (bkcd01 != null ? !bkcd01.equals(adsEntity.bkcd01) : adsEntity.bkcd01 != null) return false;
        if (bkcd02 != null ? !bkcd02.equals(adsEntity.bkcd02) : adsEntity.bkcd02 != null) return false;
        if (bkcd03 != null ? !bkcd03.equals(adsEntity.bkcd03) : adsEntity.bkcd03 != null) return false;
        if (bkcd04 != null ? !bkcd04.equals(adsEntity.bkcd04) : adsEntity.bkcd04 != null) return false;
        if (bkcd05 != null ? !bkcd05.equals(adsEntity.bkcd05) : adsEntity.bkcd05 != null) return false;
        if (bkcd06 != null ? !bkcd06.equals(adsEntity.bkcd06) : adsEntity.bkcd06 != null) return false;
        if (bkcd07 != null ? !bkcd07.equals(adsEntity.bkcd07) : adsEntity.bkcd07 != null) return false;
        if (bkcd08 != null ? !bkcd08.equals(adsEntity.bkcd08) : adsEntity.bkcd08 != null) return false;
        if (bkcd09 != null ? !bkcd09.equals(adsEntity.bkcd09) : adsEntity.bkcd09 != null) return false;
        if (bkcd10 != null ? !bkcd10.equals(adsEntity.bkcd10) : adsEntity.bkcd10 != null) return false;
        if (bkddate != null ? !bkddate.equals(adsEntity.bkddate) : adsEntity.bkddate != null) return false;
        if (campus != null ? !campus.equals(adsEntity.campus) : adsEntity.campus != null) return false;
        if (chgtype != null ? !chgtype.equals(adsEntity.chgtype) : adsEntity.chgtype != null) return false;
        if (chknr != null ? !chknr.equals(adsEntity.chknr) : adsEntity.chknr != null) return false;
        if (chrtact != null ? !chrtact.equals(adsEntity.chrtact) : adsEntity.chrtact != null) return false;
        if (crtdte != null ? !crtdte.equals(adsEntity.crtdte) : adsEntity.crtdte != null) return false;
        if (crtpgm != null ? !crtpgm.equals(adsEntity.crtpgm) : adsEntity.crtpgm != null) return false;
        if (crttime != null ? !crttime.equals(adsEntity.crttime) : adsEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(adsEntity.crtuser) : adsEntity.crtuser != null) return false;
        if (cuhrsca != null ? !cuhrsca.equals(adsEntity.cuhrsca) : adsEntity.cuhrsca != null) return false;
        if (defexpt != null ? !defexpt.equals(adsEntity.defexpt) : adsEntity.defexpt != null) return false;
        if (disbloc != null ? !disbloc.equals(adsEntity.disbloc) : adsEntity.disbloc != null) return false;
        if (enrscd != null ? !enrscd.equals(adsEntity.enrscd) : adsEntity.enrscd != null) return false;
        if (expbtch != null ? !expbtch.equals(adsEntity.expbtch) : adsEntity.expbtch != null) return false;
        if (expdte != null ? !expdte.equals(adsEntity.expdte) : adsEntity.expdte != null) return false;
        if (exprdte != null ? !exprdte.equals(adsEntity.exprdte) : adsEntity.exprdte != null) return false;
        if (expstat != null ? !expstat.equals(adsEntity.expstat) : adsEntity.expstat != null) return false;
        if (firdisf != null ? !firdisf.equals(adsEntity.firdisf) : adsEntity.firdisf != null) return false;
        if (gpa != null ? !gpa.equals(adsEntity.gpa) : adsEntity.gpa != null) return false;
        if (koref != null ? !koref.equals(adsEntity.koref) : adsEntity.koref != null) return false;
        if (lnschcde != null ? !lnschcde.equals(adsEntity.lnschcde) : adsEntity.lnschcde != null) return false;
        if (lnsid != null ? !lnsid.equals(adsEntity.lnsid) : adsEntity.lnsid != null) return false;
        if (lntype != null ? !lntype.equals(adsEntity.lntype) : adsEntity.lntype != null) return false;
        if (lnyear != null ? !lnyear.equals(adsEntity.lnyear) : adsEntity.lnyear != null) return false;
        if (parssn != null ? !parssn.equals(adsEntity.parssn) : adsEntity.parssn != null) return false;
        if (penrlt1 != null ? !penrlt1.equals(adsEntity.penrlt1) : adsEntity.penrlt1 != null) return false;
        if (penrlt2 != null ? !penrlt2.equals(adsEntity.penrlt2) : adsEntity.penrlt2 != null) return false;
        if (penrlt3 != null ? !penrlt3.equals(adsEntity.penrlt3) : adsEntity.penrlt3 != null) return false;
        if (penrlt4 != null ? !penrlt4.equals(adsEntity.penrlt4) : adsEntity.penrlt4 != null) return false;
        if (penrlt5 != null ? !penrlt5.equals(adsEntity.penrlt5) : adsEntity.penrlt5 != null) return false;
        if (penrlt6 != null ? !penrlt6.equals(adsEntity.penrlt6) : adsEntity.penrlt6 != null) return false;
        if (pmnid != null ? !pmnid.equals(adsEntity.pmnid) : adsEntity.pmnid != null) return false;
        if (procyr != null ? !procyr.equals(adsEntity.procyr) : adsEntity.procyr != null) return false;
        if (ptype != null ? !ptype.equals(adsEntity.ptype) : adsEntity.ptype != null) return false;
        if (rcnbtch != null ? !rcnbtch.equals(adsEntity.rcnbtch) : adsEntity.rcnbtch != null) return false;
        if (rcndte != null ? !rcndte.equals(adsEntity.rcndte) : adsEntity.rcndte != null) return false;
        if (rcnstat != null ? !rcnstat.equals(adsEntity.rcnstat) : adsEntity.rcnstat != null) return false;
        if (reamt != null ? !reamt.equals(adsEntity.reamt) : adsEntity.reamt != null) return false;
        if (recstat != null ? !recstat.equals(adsEntity.recstat) : adsEntity.recstat != null) return false;
        if (refndno != null ? !refndno.equals(adsEntity.refndno) : adsEntity.refndno != null) return false;
        if (refnr != null ? !refnr.equals(adsEntity.refnr) : adsEntity.refnr != null) return false;
        if (reject1 != null ? !reject1.equals(adsEntity.reject1) : adsEntity.reject1 != null) return false;
        if (reject2 != null ? !reject2.equals(adsEntity.reject2) : adsEntity.reject2 != null) return false;
        if (reject3 != null ? !reject3.equals(adsEntity.reject3) : adsEntity.reject3 != null) return false;
        if (reject4 != null ? !reject4.equals(adsEntity.reject4) : adsEntity.reject4 != null) return false;
        if (reject5 != null ? !reject5.equals(adsEntity.reject5) : adsEntity.reject5 != null) return false;
        if (reject6 != null ? !reject6.equals(adsEntity.reject6) : adsEntity.reject6 != null) return false;
        if (reject7 != null ? !reject7.equals(adsEntity.reject7) : adsEntity.reject7 != null) return false;
        if (reject8 != null ? !reject8.equals(adsEntity.reject8) : adsEntity.reject8 != null) return false;
        if (reject9 != null ? !reject9.equals(adsEntity.reject9) : adsEntity.reject9 != null) return false;
        if (rejecta != null ? !rejecta.equals(adsEntity.rejecta) : adsEntity.rejecta != null) return false;
        if (revdte != null ? !revdte.equals(adsEntity.revdte) : adsEntity.revdte != null) return false;
        if (revpgm != null ? !revpgm.equals(adsEntity.revpgm) : adsEntity.revpgm != null) return false;
        if (revtime != null ? !revtime.equals(adsEntity.revtime) : adsEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(adsEntity.revuser) : adsEntity.revuser != null) return false;
        if (sarkey != null ? !sarkey.equals(adsEntity.sarkey) : adsEntity.sarkey != null) return false;
        if (sarpstd != null ? !sarpstd.equals(adsEntity.sarpstd) : adsEntity.sarpstd != null) return false;
        if (sarpstt != null ? !sarpstt.equals(adsEntity.sarpstt) : adsEntity.sarpstt != null) return false;
        if (sarrcnd != null ? !sarrcnd.equals(adsEntity.sarrcnd) : adsEntity.sarrcnd != null) return false;
        if (sarrcns != null ? !sarrcns.equals(adsEntity.sarrcns) : adsEntity.sarrcns != null) return false;
        if (sarrcnt != null ? !sarrcnt.equals(adsEntity.sarrcnt) : adsEntity.sarrcnt != null) return false;
        if (sarrtst != null ? !sarrtst.equals(adsEntity.sarrtst) : adsEntity.sarrtst != null) return false;
        if (sartran != null ? !sartran.equals(adsEntity.sartran) : adsEntity.sartran != null) return false;
        if (schcode != null ? !schcode.equals(adsEntity.schcode) : adsEntity.schcode != null) return false;
        if (seqno2 != null ? !seqno2.equals(adsEntity.seqno2) : adsEntity.seqno2 != null) return false;
        if (sessid != null ? !sessid.equals(adsEntity.sessid) : adsEntity.sessid != null) return false;
        if (sid != null ? !sid.equals(adsEntity.sid) : adsEntity.sid != null) return false;
        if (status != null ? !status.equals(adsEntity.status) : adsEntity.status != null) return false;
        if (taxcode != null ? !taxcode.equals(adsEntity.taxcode) : adsEntity.taxcode != null) return false;
        if (term != null ? !term.equals(adsEntity.term) : adsEntity.term != null) return false;
        if (tranamt != null ? !tranamt.equals(adsEntity.tranamt) : adsEntity.tranamt != null) return false;
        if (trandte != null ? !trandte.equals(adsEntity.trandte) : adsEntity.trandte != null) return false;
        if (trndesc != null ? !trndesc.equals(adsEntity.trndesc) : adsEntity.trndesc != null) return false;
        if (trntype != null ? !trntype.equals(adsEntity.trntype) : adsEntity.trntype != null) return false;
        if (typeaid != null ? !typeaid.equals(adsEntity.typeaid) : adsEntity.typeaid != null) return false;
        if (typechk != null ? !typechk.equals(adsEntity.typechk) : adsEntity.typechk != null) return false;
        if (ucode != null ? !ucode.equals(adsEntity.ucode) : adsEntity.ucode != null) return false;
        if (untdesc != null ? !untdesc.equals(adsEntity.untdesc) : adsEntity.untdesc != null) return false;
        if (unuseda != null ? !unuseda.equals(adsEntity.unuseda) : adsEntity.unuseda != null) return false;
        if (unusedb != null ? !unusedb.equals(adsEntity.unusedb) : adsEntity.unusedb != null) return false;
        if (usercd1 != null ? !usercd1.equals(adsEntity.usercd1) : adsEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(adsEntity.usercd2) : adsEntity.usercd2 != null) return false;
        if (usercd5 != null ? !usercd5.equals(adsEntity.usercd5) : adsEntity.usercd5 != null) return false;
        if (usercd6 != null ? !usercd6.equals(adsEntity.usercd6) : adsEntity.usercd6 != null) return false;
        if (usercd7 != null ? !usercd7.equals(adsEntity.usercd7) : adsEntity.usercd7 != null) return false;
        if (usercd8 != null ? !usercd8.equals(adsEntity.usercd8) : adsEntity.usercd8 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (adskey != null ? adskey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (aidid != null ? aidid.hashCode() : 0);
        result = 31 * result + (ptype != null ? ptype.hashCode() : 0);
        result = 31 * result + recseq;
        result = 31 * result + (crtdte != null ? crtdte.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtpgm != null ? crtpgm.hashCode() : 0);
        result = 31 * result + (revdte != null ? revdte.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revpgm != null ? revpgm.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (exprdte != null ? exprdte.hashCode() : 0);
        result = 31 * result + (lnsid != null ? lnsid.hashCode() : 0);
        result = 31 * result + (lntype != null ? lntype.hashCode() : 0);
        result = 31 * result + (lnyear != null ? lnyear.hashCode() : 0);
        result = 31 * result + (lnschcde != null ? lnschcde.hashCode() : 0);
        result = 31 * result + (seqno2 != null ? seqno2.hashCode() : 0);
        result = 31 * result + dseqno;
        result = 31 * result + eseqno;
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (typeaid != null ? typeaid.hashCode() : 0);
        result = 31 * result + (acttype != null ? acttype.hashCode() : 0);
        result = 31 * result + (trntype != null ? trntype.hashCode() : 0);
        result = 31 * result + (trandte != null ? trandte.hashCode() : 0);
        result = 31 * result + (tranamt != null ? tranamt.hashCode() : 0);
        result = 31 * result + (reamt != null ? reamt.hashCode() : 0);
        result = 31 * result + agroamt;
        result = 31 * result + afeeamt;
        result = 31 * result + anetamt;
        result = 31 * result + netaamt;
        result = 31 * result + (expstat != null ? expstat.hashCode() : 0);
        result = 31 * result + (expdte != null ? expdte.hashCode() : 0);
        result = 31 * result + (unuseda != null ? unuseda.hashCode() : 0);
        result = 31 * result + (rcnstat != null ? rcnstat.hashCode() : 0);
        result = 31 * result + (rcndte != null ? rcndte.hashCode() : 0);
        result = 31 * result + (unusedb != null ? unusedb.hashCode() : 0);
        result = 31 * result + (schcode != null ? schcode.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (disbloc != null ? disbloc.hashCode() : 0);
        result = 31 * result + (trndesc != null ? trndesc.hashCode() : 0);
        result = 31 * result + (untdesc != null ? untdesc.hashCode() : 0);
        result = 31 * result + (actnr != null ? actnr.hashCode() : 0);
        result = 31 * result + (batchnr != null ? batchnr.hashCode() : 0);
        result = 31 * result + priornr;
        result = 31 * result + (sartran != null ? sartran.hashCode() : 0);
        result = 31 * result + (chgtype != null ? chgtype.hashCode() : 0);
        result = 31 * result + (taxcode != null ? taxcode.hashCode() : 0);
        result = 31 * result + (typechk != null ? typechk.hashCode() : 0);
        result = 31 * result + (chknr != null ? chknr.hashCode() : 0);
        result = 31 * result + (refnr != null ? refnr.hashCode() : 0);
        result = 31 * result + (refndno != null ? refndno.hashCode() : 0);
        result = 31 * result + (koref != null ? koref.hashCode() : 0);
        result = 31 * result + (penrlt1 != null ? penrlt1.hashCode() : 0);
        result = 31 * result + (penrlt2 != null ? penrlt2.hashCode() : 0);
        result = 31 * result + (penrlt3 != null ? penrlt3.hashCode() : 0);
        result = 31 * result + (penrlt4 != null ? penrlt4.hashCode() : 0);
        result = 31 * result + (penrlt5 != null ? penrlt5.hashCode() : 0);
        result = 31 * result + (penrlt6 != null ? penrlt6.hashCode() : 0);
        result = 31 * result + (aenrlt1 != null ? aenrlt1.hashCode() : 0);
        result = 31 * result + (aenrlt2 != null ? aenrlt2.hashCode() : 0);
        result = 31 * result + (aenrlt3 != null ? aenrlt3.hashCode() : 0);
        result = 31 * result + (aenrlt4 != null ? aenrlt4.hashCode() : 0);
        result = 31 * result + (aenrlt5 != null ? aenrlt5.hashCode() : 0);
        result = 31 * result + (aenrlt6 != null ? aenrlt6.hashCode() : 0);
        result = 31 * result + (cuhrsca != null ? cuhrsca.hashCode() : 0);
        result = 31 * result + (parssn != null ? parssn.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + usernr1;
        result = 31 * result + usernr2;
        result = 31 * result + (ackdte != null ? ackdte.hashCode() : 0);
        result = 31 * result + (act01 != null ? act01.hashCode() : 0);
        result = 31 * result + (act02 != null ? act02.hashCode() : 0);
        result = 31 * result + (act03 != null ? act03.hashCode() : 0);
        result = 31 * result + (act04 != null ? act04.hashCode() : 0);
        result = 31 * result + (act05 != null ? act05.hashCode() : 0);
        result = 31 * result + (act06 != null ? act06.hashCode() : 0);
        result = 31 * result + (act07 != null ? act07.hashCode() : 0);
        result = 31 * result + (act08 != null ? act08.hashCode() : 0);
        result = 31 * result + (act09 != null ? act09.hashCode() : 0);
        result = 31 * result + (act10 != null ? act10.hashCode() : 0);
        result = 31 * result + (bkcd01 != null ? bkcd01.hashCode() : 0);
        result = 31 * result + (bkcd02 != null ? bkcd02.hashCode() : 0);
        result = 31 * result + (bkcd03 != null ? bkcd03.hashCode() : 0);
        result = 31 * result + (bkcd04 != null ? bkcd04.hashCode() : 0);
        result = 31 * result + (bkcd05 != null ? bkcd05.hashCode() : 0);
        result = 31 * result + (bkcd06 != null ? bkcd06.hashCode() : 0);
        result = 31 * result + (bkcd07 != null ? bkcd07.hashCode() : 0);
        result = 31 * result + (bkcd08 != null ? bkcd08.hashCode() : 0);
        result = 31 * result + (bkcd09 != null ? bkcd09.hashCode() : 0);
        result = 31 * result + (bkcd10 != null ? bkcd10.hashCode() : 0);
        result = 31 * result + (usercd5 != null ? usercd5.hashCode() : 0);
        result = 31 * result + (usercd6 != null ? usercd6.hashCode() : 0);
        result = 31 * result + (usercd7 != null ? usercd7.hashCode() : 0);
        result = 31 * result + (usercd8 != null ? usercd8.hashCode() : 0);
        result = 31 * result + (reject1 != null ? reject1.hashCode() : 0);
        result = 31 * result + (reject2 != null ? reject2.hashCode() : 0);
        result = 31 * result + (reject3 != null ? reject3.hashCode() : 0);
        result = 31 * result + (reject4 != null ? reject4.hashCode() : 0);
        result = 31 * result + (reject5 != null ? reject5.hashCode() : 0);
        result = 31 * result + (reject6 != null ? reject6.hashCode() : 0);
        result = 31 * result + (reject7 != null ? reject7.hashCode() : 0);
        result = 31 * result + (reject8 != null ? reject8.hashCode() : 0);
        result = 31 * result + (reject9 != null ? reject9.hashCode() : 0);
        result = 31 * result + (rejecta != null ? rejecta.hashCode() : 0);
        result = 31 * result + (bkddate != null ? bkddate.hashCode() : 0);
        result = 31 * result + (expbtch != null ? expbtch.hashCode() : 0);
        result = 31 * result + (rcnbtch != null ? rcnbtch.hashCode() : 0);
        result = 31 * result + (chrtact != null ? chrtact.hashCode() : 0);
        result = 31 * result + (firdisf != null ? firdisf.hashCode() : 0);
        result = 31 * result + (arebamt != null ? arebamt.hashCode() : 0);
        result = 31 * result + (arebloc != null ? arebloc.hashCode() : 0);
        result = 31 * result + (pmnid != null ? pmnid.hashCode() : 0);
        result = 31 * result + (acdlvl != null ? acdlvl.hashCode() : 0);
        result = 31 * result + (gpa != null ? gpa.hashCode() : 0);
        result = 31 * result + sarrtcd;
        result = 31 * result + (sarrcns != null ? sarrcns.hashCode() : 0);
        result = 31 * result + (sarkey != null ? sarkey.hashCode() : 0);
        result = 31 * result + (sarrtst != null ? sarrtst.hashCode() : 0);
        result = 31 * result + (sarpstd != null ? sarpstd.hashCode() : 0);
        result = 31 * result + (sarpstt != null ? sarpstt.hashCode() : 0);
        result = 31 * result + (sarrcnd != null ? sarrcnd.hashCode() : 0);
        result = 31 * result + (sarrcnt != null ? sarrcnt.hashCode() : 0);
        result = 31 * result + (antddte != null ? antddte.hashCode() : 0);
        result = 31 * result + (sessid != null ? sessid.hashCode() : 0);
        result = 31 * result + (defexpt != null ? defexpt.hashCode() : 0);
        result = 31 * result + (enrscd != null ? enrscd.hashCode() : 0);
        return result;
    }
}
