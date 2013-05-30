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
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "AWD", schema = "SIGMA", catalog = "")
@Entity
public class AwdEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getAwdkey();
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

    private String awdkey;

    @javax.persistence.Column(name = "AWDKEY")
    @Id
    public String getAwdkey() {
        return awdkey;
    }

    public void setAwdkey(String awdkey) {
        this.awdkey = awdkey;
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

    private String unused1;

    @javax.persistence.Column(name = "UNUSED1")
    @Basic
    public String getUnused1() {
        return unused1;
    }

    public void setUnused1(String unused1) {
        this.unused1 = unused1;
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

    private String aaidyr;

    @javax.persistence.Column(name = "AAIDYR")
    @Basic
    public String getAaidyr() {
        return aaidyr;
    }

    public void setAaidyr(String aaidyr) {
        this.aaidyr = aaidyr;
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

    private String aptype;

    @javax.persistence.Column(name = "APTYPE")
    @Basic
    public String getAptype() {
        return aptype;
    }

    public void setAptype(String aptype) {
        this.aptype = aptype;
    }

    private String loannr;

    @javax.persistence.Column(name = "LOANNR")
    @Basic
    public String getLoannr() {
        return loannr;
    }

    public void setLoannr(String loannr) {
        this.loannr = loannr;
    }

    private String pgmname;

    @javax.persistence.Column(name = "PGMNAME")
    @Basic
    public String getPgmname() {
        return pgmname;
    }

    public void setPgmname(String pgmname) {
        this.pgmname = pgmname;
    }

    private String typetrm;

    @javax.persistence.Column(name = "TYPETRM")
    @Basic
    public String getTypetrm() {
        return typetrm;
    }

    public void setTypetrm(String typetrm) {
        this.typetrm = typetrm;
    }

    private String sponsor;

    @javax.persistence.Column(name = "SPONSOR")
    @Basic
    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    private String admresp;

    @javax.persistence.Column(name = "ADMRESP")
    @Basic
    public String getAdmresp() {
        return admresp;
    }

    public void setAdmresp(String admresp) {
        this.admresp = admresp;
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

    private String procrsp;

    @javax.persistence.Column(name = "PROCRSP")
    @Basic
    public String getProcrsp() {
        return procrsp;
    }

    public void setProcrsp(String procrsp) {
        this.procrsp = procrsp;
    }

    private String schsrce;

    @javax.persistence.Column(name = "SCHSRCE")
    @Basic
    public String getSchsrce() {
        return schsrce;
    }

    public void setSchsrce(String schsrce) {
        this.schsrce = schsrce;
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

    private String schtype;

    @javax.persistence.Column(name = "SCHTYPE")
    @Basic
    public String getSchtype() {
        return schtype;
    }

    public void setSchtype(String schtype) {
        this.schtype = schtype;
    }

    private String commsch;

    @javax.persistence.Column(name = "COMMSCH")
    @Basic
    public String getCommsch() {
        return commsch;
    }

    public void setCommsch(String commsch) {
        this.commsch = commsch;
    }

    private String offrst;

    @javax.persistence.Column(name = "OFFRST")
    @Basic
    public String getOffrst() {
        return offrst;
    }

    public void setOffrst(String offrst) {
        this.offrst = offrst;
    }

    private String acptst;

    @javax.persistence.Column(name = "ACPTST")
    @Basic
    public String getAcptst() {
        return acptst;
    }

    public void setAcptst(String acptst) {
        this.acptst = acptst;
    }

    private String commst;

    @javax.persistence.Column(name = "COMMST")
    @Basic
    public String getCommst() {
        return commst;
    }

    public void setCommst(String commst) {
        this.commst = commst;
    }

    private String paidst;

    @javax.persistence.Column(name = "PAIDST")
    @Basic
    public String getPaidst() {
        return paidst;
    }

    public void setPaidst(String paidst) {
        this.paidst = paidst;
    }

    private String promst;

    @javax.persistence.Column(name = "PROMST")
    @Basic
    public String getPromst() {
        return promst;
    }

    public void setPromst(String promst) {
        this.promst = promst;
    }

    private String revreas;

    @javax.persistence.Column(name = "REVREAS")
    @Basic
    public String getRevreas() {
        return revreas;
    }

    public void setRevreas(String revreas) {
        this.revreas = revreas;
    }

    private BigDecimal empst1;

    @javax.persistence.Column(name = "EMPST1")
    @Basic
    public BigDecimal getEmpst1() {
        return empst1;
    }

    public void setEmpst1(BigDecimal empst1) {
        this.empst1 = empst1;
    }

    private BigDecimal empst2;

    @javax.persistence.Column(name = "EMPST2")
    @Basic
    public BigDecimal getEmpst2() {
        return empst2;
    }

    public void setEmpst2(BigDecimal empst2) {
        this.empst2 = empst2;
    }

    private BigDecimal empst3;

    @javax.persistence.Column(name = "EMPST3")
    @Basic
    public BigDecimal getEmpst3() {
        return empst3;
    }

    public void setEmpst3(BigDecimal empst3) {
        this.empst3 = empst3;
    }

    private BigDecimal empst4;

    @javax.persistence.Column(name = "EMPST4")
    @Basic
    public BigDecimal getEmpst4() {
        return empst4;
    }

    public void setEmpst4(BigDecimal empst4) {
        this.empst4 = empst4;
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

    private BigDecimal totoffr;

    @javax.persistence.Column(name = "TOTOFFR")
    @Basic
    public BigDecimal getTotoffr() {
        return totoffr;
    }

    public void setTotoffr(BigDecimal totoffr) {
        this.totoffr = totoffr;
    }

    private BigDecimal totacpt;

    @javax.persistence.Column(name = "TOTACPT")
    @Basic
    public BigDecimal getTotacpt() {
        return totacpt;
    }

    public void setTotacpt(BigDecimal totacpt) {
        this.totacpt = totacpt;
    }

    private BigDecimal totcomm;

    @javax.persistence.Column(name = "TOTCOMM")
    @Basic
    public BigDecimal getTotcomm() {
        return totcomm;
    }

    public void setTotcomm(BigDecimal totcomm) {
        this.totcomm = totcomm;
    }

    private BigDecimal totpaid;

    @javax.persistence.Column(name = "TOTPAID")
    @Basic
    public BigDecimal getTotpaid() {
        return totpaid;
    }

    public void setTotpaid(BigDecimal totpaid) {
        this.totpaid = totpaid;
    }

    private BigDecimal totprom;

    @javax.persistence.Column(name = "TOTPROM")
    @Basic
    public BigDecimal getTotprom() {
        return totprom;
    }

    public void setTotprom(BigDecimal totprom) {
        this.totprom = totprom;
    }

    private BigDecimal pdoffr1;

    @javax.persistence.Column(name = "PDOFFR1")
    @Basic
    public BigDecimal getPdoffr1() {
        return pdoffr1;
    }

    public void setPdoffr1(BigDecimal pdoffr1) {
        this.pdoffr1 = pdoffr1;
    }

    private BigDecimal pdoffr2;

    @javax.persistence.Column(name = "PDOFFR2")
    @Basic
    public BigDecimal getPdoffr2() {
        return pdoffr2;
    }

    public void setPdoffr2(BigDecimal pdoffr2) {
        this.pdoffr2 = pdoffr2;
    }

    private BigDecimal pdoffr3;

    @javax.persistence.Column(name = "PDOFFR3")
    @Basic
    public BigDecimal getPdoffr3() {
        return pdoffr3;
    }

    public void setPdoffr3(BigDecimal pdoffr3) {
        this.pdoffr3 = pdoffr3;
    }

    private BigDecimal pdoffr4;

    @javax.persistence.Column(name = "PDOFFR4")
    @Basic
    public BigDecimal getPdoffr4() {
        return pdoffr4;
    }

    public void setPdoffr4(BigDecimal pdoffr4) {
        this.pdoffr4 = pdoffr4;
    }

    private BigDecimal pdoffr5;

    @javax.persistence.Column(name = "PDOFFR5")
    @Basic
    public BigDecimal getPdoffr5() {
        return pdoffr5;
    }

    public void setPdoffr5(BigDecimal pdoffr5) {
        this.pdoffr5 = pdoffr5;
    }

    private BigDecimal pdoffr6;

    @javax.persistence.Column(name = "PDOFFR6")
    @Basic
    public BigDecimal getPdoffr6() {
        return pdoffr6;
    }

    public void setPdoffr6(BigDecimal pdoffr6) {
        this.pdoffr6 = pdoffr6;
    }

    private BigDecimal pdoffr7;

    @javax.persistence.Column(name = "PDOFFR7")
    @Basic
    public BigDecimal getPdoffr7() {
        return pdoffr7;
    }

    public void setPdoffr7(BigDecimal pdoffr7) {
        this.pdoffr7 = pdoffr7;
    }

    private BigDecimal pdoffr8;

    @javax.persistence.Column(name = "PDOFFR8")
    @Basic
    public BigDecimal getPdoffr8() {
        return pdoffr8;
    }

    public void setPdoffr8(BigDecimal pdoffr8) {
        this.pdoffr8 = pdoffr8;
    }

    private BigDecimal pdoffr9;

    @javax.persistence.Column(name = "PDOFFR9")
    @Basic
    public BigDecimal getPdoffr9() {
        return pdoffr9;
    }

    public void setPdoffr9(BigDecimal pdoffr9) {
        this.pdoffr9 = pdoffr9;
    }

    private BigDecimal pdoffra;

    @javax.persistence.Column(name = "PDOFFRA")
    @Basic
    public BigDecimal getPdoffra() {
        return pdoffra;
    }

    public void setPdoffra(BigDecimal pdoffra) {
        this.pdoffra = pdoffra;
    }

    private BigDecimal pdoffrb;

    @javax.persistence.Column(name = "PDOFFRB")
    @Basic
    public BigDecimal getPdoffrb() {
        return pdoffrb;
    }

    public void setPdoffrb(BigDecimal pdoffrb) {
        this.pdoffrb = pdoffrb;
    }

    private BigDecimal pdoffrc;

    @javax.persistence.Column(name = "PDOFFRC")
    @Basic
    public BigDecimal getPdoffrc() {
        return pdoffrc;
    }

    public void setPdoffrc(BigDecimal pdoffrc) {
        this.pdoffrc = pdoffrc;
    }

    private String pdenrl1;

    @javax.persistence.Column(name = "PDENRL1")
    @Basic
    public String getPdenrl1() {
        return pdenrl1;
    }

    public void setPdenrl1(String pdenrl1) {
        this.pdenrl1 = pdenrl1;
    }

    private String pdenrl2;

    @javax.persistence.Column(name = "PDENRL2")
    @Basic
    public String getPdenrl2() {
        return pdenrl2;
    }

    public void setPdenrl2(String pdenrl2) {
        this.pdenrl2 = pdenrl2;
    }

    private String pdenrl3;

    @javax.persistence.Column(name = "PDENRL3")
    @Basic
    public String getPdenrl3() {
        return pdenrl3;
    }

    public void setPdenrl3(String pdenrl3) {
        this.pdenrl3 = pdenrl3;
    }

    private String pdenrl4;

    @javax.persistence.Column(name = "PDENRL4")
    @Basic
    public String getPdenrl4() {
        return pdenrl4;
    }

    public void setPdenrl4(String pdenrl4) {
        this.pdenrl4 = pdenrl4;
    }

    private String pdenrl5;

    @javax.persistence.Column(name = "PDENRL5")
    @Basic
    public String getPdenrl5() {
        return pdenrl5;
    }

    public void setPdenrl5(String pdenrl5) {
        this.pdenrl5 = pdenrl5;
    }

    private String pdenrl6;

    @javax.persistence.Column(name = "PDENRL6")
    @Basic
    public String getPdenrl6() {
        return pdenrl6;
    }

    public void setPdenrl6(String pdenrl6) {
        this.pdenrl6 = pdenrl6;
    }

    private String pdenrl7;

    @javax.persistence.Column(name = "PDENRL7")
    @Basic
    public String getPdenrl7() {
        return pdenrl7;
    }

    public void setPdenrl7(String pdenrl7) {
        this.pdenrl7 = pdenrl7;
    }

    private String pdenrl8;

    @javax.persistence.Column(name = "PDENRL8")
    @Basic
    public String getPdenrl8() {
        return pdenrl8;
    }

    public void setPdenrl8(String pdenrl8) {
        this.pdenrl8 = pdenrl8;
    }

    private String pdenrl9;

    @javax.persistence.Column(name = "PDENRL9")
    @Basic
    public String getPdenrl9() {
        return pdenrl9;
    }

    public void setPdenrl9(String pdenrl9) {
        this.pdenrl9 = pdenrl9;
    }

    private String pdenrla;

    @javax.persistence.Column(name = "PDENRLA")
    @Basic
    public String getPdenrla() {
        return pdenrla;
    }

    public void setPdenrla(String pdenrla) {
        this.pdenrla = pdenrla;
    }

    private String pdenrlb;

    @javax.persistence.Column(name = "PDENRLB")
    @Basic
    public String getPdenrlb() {
        return pdenrlb;
    }

    public void setPdenrlb(String pdenrlb) {
        this.pdenrlb = pdenrlb;
    }

    private String pdenrlc;

    @javax.persistence.Column(name = "PDENRLC")
    @Basic
    public String getPdenrlc() {
        return pdenrlc;
    }

    public void setPdenrlc(String pdenrlc) {
        this.pdenrlc = pdenrlc;
    }

    private BigDecimal pdpaid1;

    @javax.persistence.Column(name = "PDPAID1")
    @Basic
    public BigDecimal getPdpaid1() {
        return pdpaid1;
    }

    public void setPdpaid1(BigDecimal pdpaid1) {
        this.pdpaid1 = pdpaid1;
    }

    private BigDecimal pdpaid2;

    @javax.persistence.Column(name = "PDPAID2")
    @Basic
    public BigDecimal getPdpaid2() {
        return pdpaid2;
    }

    public void setPdpaid2(BigDecimal pdpaid2) {
        this.pdpaid2 = pdpaid2;
    }

    private BigDecimal pdpaid3;

    @javax.persistence.Column(name = "PDPAID3")
    @Basic
    public BigDecimal getPdpaid3() {
        return pdpaid3;
    }

    public void setPdpaid3(BigDecimal pdpaid3) {
        this.pdpaid3 = pdpaid3;
    }

    private BigDecimal pdpaid4;

    @javax.persistence.Column(name = "PDPAID4")
    @Basic
    public BigDecimal getPdpaid4() {
        return pdpaid4;
    }

    public void setPdpaid4(BigDecimal pdpaid4) {
        this.pdpaid4 = pdpaid4;
    }

    private BigDecimal pdpaid5;

    @javax.persistence.Column(name = "PDPAID5")
    @Basic
    public BigDecimal getPdpaid5() {
        return pdpaid5;
    }

    public void setPdpaid5(BigDecimal pdpaid5) {
        this.pdpaid5 = pdpaid5;
    }

    private BigDecimal pdpaid6;

    @javax.persistence.Column(name = "PDPAID6")
    @Basic
    public BigDecimal getPdpaid6() {
        return pdpaid6;
    }

    public void setPdpaid6(BigDecimal pdpaid6) {
        this.pdpaid6 = pdpaid6;
    }

    private BigDecimal pdpaid7;

    @javax.persistence.Column(name = "PDPAID7")
    @Basic
    public BigDecimal getPdpaid7() {
        return pdpaid7;
    }

    public void setPdpaid7(BigDecimal pdpaid7) {
        this.pdpaid7 = pdpaid7;
    }

    private BigDecimal pdpaid8;

    @javax.persistence.Column(name = "PDPAID8")
    @Basic
    public BigDecimal getPdpaid8() {
        return pdpaid8;
    }

    public void setPdpaid8(BigDecimal pdpaid8) {
        this.pdpaid8 = pdpaid8;
    }

    private BigDecimal pdpaid9;

    @javax.persistence.Column(name = "PDPAID9")
    @Basic
    public BigDecimal getPdpaid9() {
        return pdpaid9;
    }

    public void setPdpaid9(BigDecimal pdpaid9) {
        this.pdpaid9 = pdpaid9;
    }

    private BigDecimal pdpaida;

    @javax.persistence.Column(name = "PDPAIDA")
    @Basic
    public BigDecimal getPdpaida() {
        return pdpaida;
    }

    public void setPdpaida(BigDecimal pdpaida) {
        this.pdpaida = pdpaida;
    }

    private BigDecimal pdpaidb;

    @javax.persistence.Column(name = "PDPAIDB")
    @Basic
    public BigDecimal getPdpaidb() {
        return pdpaidb;
    }

    public void setPdpaidb(BigDecimal pdpaidb) {
        this.pdpaidb = pdpaidb;
    }

    private BigDecimal pdpaidc;

    @javax.persistence.Column(name = "PDPAIDC")
    @Basic
    public BigDecimal getPdpaidc() {
        return pdpaidc;
    }

    public void setPdpaidc(BigDecimal pdpaidc) {
        this.pdpaidc = pdpaidc;
    }

    private BigDecimal prvpaid;

    @javax.persistence.Column(name = "PRVPAID")
    @Basic
    public BigDecimal getPrvpaid() {
        return prvpaid;
    }

    public void setPrvpaid(BigDecimal prvpaid) {
        this.prvpaid = prvpaid;
    }

    private BigDecimal nxtoffr;

    @javax.persistence.Column(name = "NXTOFFR")
    @Basic
    public BigDecimal getNxtoffr() {
        return nxtoffr;
    }

    public void setNxtoffr(BigDecimal nxtoffr) {
        this.nxtoffr = nxtoffr;
    }

    private BigDecimal prpaid;

    @javax.persistence.Column(name = "PRPAID")
    @Basic
    public BigDecimal getPrpaid() {
        return prpaid;
    }

    public void setPrpaid(BigDecimal prpaid) {
        this.prpaid = prpaid;
    }

    private BigDecimal prtrms;

    @javax.persistence.Column(name = "PRTRMS")
    @Basic
    public BigDecimal getPrtrms() {
        return prtrms;
    }

    public void setPrtrms(BigDecimal prtrms) {
        this.prtrms = prtrms;
    }

    private BigDecimal curtrms;

    @javax.persistence.Column(name = "CURTRMS")
    @Basic
    public BigDecimal getCurtrms() {
        return curtrms;
    }

    public void setCurtrms(BigDecimal curtrms) {
        this.curtrms = curtrms;
    }

    private BigDecimal curpymt;

    @javax.persistence.Column(name = "CURPYMT")
    @Basic
    public BigDecimal getCurpymt() {
        return curpymt;
    }

    public void setCurpymt(BigDecimal curpymt) {
        this.curpymt = curpymt;
    }

    private BigDecimal curcomm;

    @javax.persistence.Column(name = "CURCOMM")
    @Basic
    public BigDecimal getCurcomm() {
        return curcomm;
    }

    public void setCurcomm(BigDecimal curcomm) {
        this.curcomm = curcomm;
    }

    private String pymtrm1;

    @javax.persistence.Column(name = "PYMTRM1")
    @Basic
    public String getPymtrm1() {
        return pymtrm1;
    }

    public void setPymtrm1(String pymtrm1) {
        this.pymtrm1 = pymtrm1;
    }

    private String pymtrm2;

    @javax.persistence.Column(name = "PYMTRM2")
    @Basic
    public String getPymtrm2() {
        return pymtrm2;
    }

    public void setPymtrm2(String pymtrm2) {
        this.pymtrm2 = pymtrm2;
    }

    private String pymtrm3;

    @javax.persistence.Column(name = "PYMTRM3")
    @Basic
    public String getPymtrm3() {
        return pymtrm3;
    }

    public void setPymtrm3(String pymtrm3) {
        this.pymtrm3 = pymtrm3;
    }

    private String pymtrm4;

    @javax.persistence.Column(name = "PYMTRM4")
    @Basic
    public String getPymtrm4() {
        return pymtrm4;
    }

    public void setPymtrm4(String pymtrm4) {
        this.pymtrm4 = pymtrm4;
    }

    private String pymtrm5;

    @javax.persistence.Column(name = "PYMTRM5")
    @Basic
    public String getPymtrm5() {
        return pymtrm5;
    }

    public void setPymtrm5(String pymtrm5) {
        this.pymtrm5 = pymtrm5;
    }

    private String pymtrm6;

    @javax.persistence.Column(name = "PYMTRM6")
    @Basic
    public String getPymtrm6() {
        return pymtrm6;
    }

    public void setPymtrm6(String pymtrm6) {
        this.pymtrm6 = pymtrm6;
    }

    private String awdrdc;

    @javax.persistence.Column(name = "AWDRDC")
    @Basic
    public String getAwdrdc() {
        return awdrdc;
    }

    public void setAwdrdc(String awdrdc) {
        this.awdrdc = awdrdc;
    }

    private String dclaid;

    @javax.persistence.Column(name = "DCLAID")
    @Basic
    public String getDclaid() {
        return dclaid;
    }

    public void setDclaid(String dclaid) {
        this.dclaid = dclaid;
    }

    private String mfid;

    @javax.persistence.Column(name = "MFID")
    @Basic
    public String getMfid() {
        return mfid;
    }

    public void setMfid(String mfid) {
        this.mfid = mfid;
    }

    private BigDecimal mempaid;

    @javax.persistence.Column(name = "MEMPAID")
    @Basic
    public BigDecimal getMempaid() {
        return mempaid;
    }

    public void setMempaid(BigDecimal mempaid) {
        this.mempaid = mempaid;
    }

    private String incneed;

    @javax.persistence.Column(name = "INCNEED")
    @Basic
    public String getIncneed() {
        return incneed;
    }

    public void setIncneed(String incneed) {
        this.incneed = incneed;
    }

    private String estactl;

    @javax.persistence.Column(name = "ESTACTL")
    @Basic
    public String getEstactl() {
        return estactl;
    }

    public void setEstactl(String estactl) {
        this.estactl = estactl;
    }

    private BigDecimal usernr1;

    @javax.persistence.Column(name = "USERNR1")
    @Basic
    public BigDecimal getUsernr1() {
        return usernr1;
    }

    public void setUsernr1(BigDecimal usernr1) {
        this.usernr1 = usernr1;
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

    private BigInteger revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public BigInteger getRevlev() {
        return revlev;
    }

    public void setRevlev(BigInteger revlev) {
        this.revlev = revlev;
    }

    private String sitime;

    @javax.persistence.Column(name = "SITIME")
    @Basic
    public String getSitime() {
        return sitime;
    }

    public void setSitime(String sitime) {
        this.sitime = sitime;
    }

    private String initals;

    @javax.persistence.Column(name = "INITALS")
    @Basic
    public String getInitals() {
        return initals;
    }

    public void setInitals(String initals) {
        this.initals = initals;
    }

    private String module;

    @javax.persistence.Column(name = "MODULE")
    @Basic
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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

    private String offrdtc;

    @javax.persistence.Column(name = "OFFRDTC")
    @Basic
    public String getOffrdtc() {
        return offrdtc;
    }

    public void setOffrdtc(String offrdtc) {
        this.offrdtc = offrdtc;
    }

    private String acptdtc;

    @javax.persistence.Column(name = "ACPTDTC")
    @Basic
    public String getAcptdtc() {
        return acptdtc;
    }

    public void setAcptdtc(String acptdtc) {
        this.acptdtc = acptdtc;
    }

    private String commdtc;

    @javax.persistence.Column(name = "COMMDTC")
    @Basic
    public String getCommdtc() {
        return commdtc;
    }

    public void setCommdtc(String commdtc) {
        this.commdtc = commdtc;
    }

    private String paiddtc;

    @javax.persistence.Column(name = "PAIDDTC")
    @Basic
    public String getPaiddtc() {
        return paiddtc;
    }

    public void setPaiddtc(String paiddtc) {
        this.paiddtc = paiddtc;
    }

    private String promdtc;

    @javax.persistence.Column(name = "PROMDTC")
    @Basic
    public String getPromdtc() {
        return promdtc;
    }

    public void setPromdtc(String promdtc) {
        this.promdtc = promdtc;
    }

    private String begdtec;

    @javax.persistence.Column(name = "BEGDTEC")
    @Basic
    public String getBegdtec() {
        return begdtec;
    }

    public void setBegdtec(String begdtec) {
        this.begdtec = begdtec;
    }

    private String enddtec;

    @javax.persistence.Column(name = "ENDDTEC")
    @Basic
    public String getEnddtec() {
        return enddtec;
    }

    public void setEnddtec(String enddtec) {
        this.enddtec = enddtec;
    }

    private String creatdc;

    @javax.persistence.Column(name = "CREATDC")
    @Basic
    public String getCreatdc() {
        return creatdc;
    }

    public void setCreatdc(String creatdc) {
        this.creatdc = creatdc;
    }

    private String revdtec;

    @javax.persistence.Column(name = "REVDTEC")
    @Basic
    public String getRevdtec() {
        return revdtec;
    }

    public void setRevdtec(String revdtec) {
        this.revdtec = revdtec;
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

    private String chrtact;

    @javax.persistence.Column(name = "CHRTACT")
    @Basic
    public String getChrtact() {
        return chrtact;
    }

    public void setChrtact(String chrtact) {
        this.chrtact = chrtact;
    }

    private String disbstd;

    @javax.persistence.Column(name = "DISBSTD")
    @Basic
    public String getDisbstd() {
        return disbstd;
    }

    public void setDisbstd(String disbstd) {
        this.disbstd = disbstd;
    }

    private String awdctl;

    @javax.persistence.Column(name = "AWDCTL")
    @Basic
    public String getAwdctl() {
        return awdctl;
    }

    public void setAwdctl(String awdctl) {
        this.awdctl = awdctl;
    }

    private int lstads;

    @javax.persistence.Column(name = "LSTADS")
    @Basic
    public int getLstads() {
        return lstads;
    }

    public void setLstads(int lstads) {
        this.lstads = lstads;
    }

    private int lsteds;

    @javax.persistence.Column(name = "LSTEDS")
    @Basic
    public int getLsteds() {
        return lsteds;
    }

    public void setLsteds(int lsteds) {
        this.lsteds = lsteds;
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

    private String expdate;

    @javax.persistence.Column(name = "EXPDATE")
    @Basic
    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    private BigDecimal orgamt;

    @javax.persistence.Column(name = "ORGAMT")
    @Basic
    public BigDecimal getOrgamt() {
        return orgamt;
    }

    public void setOrgamt(BigDecimal orgamt) {
        this.orgamt = orgamt;
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

    private String psntyp;

    @javax.persistence.Column(name = "PSNTYP")
    @Basic
    public String getPsntyp() {
        return psntyp;
    }

    public void setPsntyp(String psntyp) {
        this.psntyp = psntyp;
    }

    private String docdte;

    @javax.persistence.Column(name = "DOCDTE")
    @Basic
    public String getDocdte() {
        return docdte;
    }

    public void setDocdte(String docdte) {
        this.docdte = docdte;
    }

    private String doccmp;

    @javax.persistence.Column(name = "DOCCMP")
    @Basic
    public String getDoccmp() {
        return doccmp;
    }

    public void setDoccmp(String doccmp) {
        this.doccmp = doccmp;
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

    private String pkgenr1;

    @javax.persistence.Column(name = "PKGENR1")
    @Basic
    public String getPkgenr1() {
        return pkgenr1;
    }

    public void setPkgenr1(String pkgenr1) {
        this.pkgenr1 = pkgenr1;
    }

    private String pkgenr2;

    @javax.persistence.Column(name = "PKGENR2")
    @Basic
    public String getPkgenr2() {
        return pkgenr2;
    }

    public void setPkgenr2(String pkgenr2) {
        this.pkgenr2 = pkgenr2;
    }

    private String pkgenr3;

    @javax.persistence.Column(name = "PKGENR3")
    @Basic
    public String getPkgenr3() {
        return pkgenr3;
    }

    public void setPkgenr3(String pkgenr3) {
        this.pkgenr3 = pkgenr3;
    }

    private String pkgenr4;

    @javax.persistence.Column(name = "PKGENR4")
    @Basic
    public String getPkgenr4() {
        return pkgenr4;
    }

    public void setPkgenr4(String pkgenr4) {
        this.pkgenr4 = pkgenr4;
    }

    private String pkgenr5;

    @javax.persistence.Column(name = "PKGENR5")
    @Basic
    public String getPkgenr5() {
        return pkgenr5;
    }

    public void setPkgenr5(String pkgenr5) {
        this.pkgenr5 = pkgenr5;
    }

    private String pkgenr6;

    @javax.persistence.Column(name = "PKGENR6")
    @Basic
    public String getPkgenr6() {
        return pkgenr6;
    }

    public void setPkgenr6(String pkgenr6) {
        this.pkgenr6 = pkgenr6;
    }

    private String sarexps;

    @javax.persistence.Column(name = "SAREXPS")
    @Basic
    public String getSarexps() {
        return sarexps;
    }

    public void setSarexps(String sarexps) {
        this.sarexps = sarexps;
    }

    private String sarexpd;

    @javax.persistence.Column(name = "SAREXPD")
    @Basic
    public String getSarexpd() {
        return sarexpd;
    }

    public void setSarexpd(String sarexpd) {
        this.sarexpd = sarexpd;
    }

    private String fiscyr;

    @javax.persistence.Column(name = "FISCYR")
    @Basic
    public String getFiscyr() {
        return fiscyr;
    }

    public void setFiscyr(String fiscyr) {
        this.fiscyr = fiscyr;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AwdEntity awdEntity = (AwdEntity) o;

        if (lstads != awdEntity.lstads) return false;
        if (lsteds != awdEntity.lsteds) return false;
        if (aaidyr != null ? !aaidyr.equals(awdEntity.aaidyr) : awdEntity.aaidyr != null) return false;
        if (acdlvl != null ? !acdlvl.equals(awdEntity.acdlvl) : awdEntity.acdlvl != null) return false;
        if (acptdtc != null ? !acptdtc.equals(awdEntity.acptdtc) : awdEntity.acptdtc != null) return false;
        if (acptst != null ? !acptst.equals(awdEntity.acptst) : awdEntity.acptst != null) return false;
        if (actnr != null ? !actnr.equals(awdEntity.actnr) : awdEntity.actnr != null) return false;
        if (admresp != null ? !admresp.equals(awdEntity.admresp) : awdEntity.admresp != null) return false;
        if (aenrlt1 != null ? !aenrlt1.equals(awdEntity.aenrlt1) : awdEntity.aenrlt1 != null) return false;
        if (aenrlt2 != null ? !aenrlt2.equals(awdEntity.aenrlt2) : awdEntity.aenrlt2 != null) return false;
        if (aenrlt3 != null ? !aenrlt3.equals(awdEntity.aenrlt3) : awdEntity.aenrlt3 != null) return false;
        if (aenrlt4 != null ? !aenrlt4.equals(awdEntity.aenrlt4) : awdEntity.aenrlt4 != null) return false;
        if (aenrlt5 != null ? !aenrlt5.equals(awdEntity.aenrlt5) : awdEntity.aenrlt5 != null) return false;
        if (aenrlt6 != null ? !aenrlt6.equals(awdEntity.aenrlt6) : awdEntity.aenrlt6 != null) return false;
        if (aidid != null ? !aidid.equals(awdEntity.aidid) : awdEntity.aidid != null) return false;
        if (aidyr != null ? !aidyr.equals(awdEntity.aidyr) : awdEntity.aidyr != null) return false;
        if (aptype != null ? !aptype.equals(awdEntity.aptype) : awdEntity.aptype != null) return false;
        if (asid != null ? !asid.equals(awdEntity.asid) : awdEntity.asid != null) return false;
        if (awdctl != null ? !awdctl.equals(awdEntity.awdctl) : awdEntity.awdctl != null) return false;
        if (awdkey != null ? !awdkey.equals(awdEntity.awdkey) : awdEntity.awdkey != null) return false;
        if (awdrdc != null ? !awdrdc.equals(awdEntity.awdrdc) : awdEntity.awdrdc != null) return false;
        if (begdtec != null ? !begdtec.equals(awdEntity.begdtec) : awdEntity.begdtec != null) return false;
        if (chrtact != null ? !chrtact.equals(awdEntity.chrtact) : awdEntity.chrtact != null) return false;
        if (commdtc != null ? !commdtc.equals(awdEntity.commdtc) : awdEntity.commdtc != null) return false;
        if (commsch != null ? !commsch.equals(awdEntity.commsch) : awdEntity.commsch != null) return false;
        if (commst != null ? !commst.equals(awdEntity.commst) : awdEntity.commst != null) return false;
        if (creatdc != null ? !creatdc.equals(awdEntity.creatdc) : awdEntity.creatdc != null) return false;
        if (curcomm != null ? !curcomm.equals(awdEntity.curcomm) : awdEntity.curcomm != null) return false;
        if (curpymt != null ? !curpymt.equals(awdEntity.curpymt) : awdEntity.curpymt != null) return false;
        if (curtrms != null ? !curtrms.equals(awdEntity.curtrms) : awdEntity.curtrms != null) return false;
        if (dclaid != null ? !dclaid.equals(awdEntity.dclaid) : awdEntity.dclaid != null) return false;
        if (defexpt != null ? !defexpt.equals(awdEntity.defexpt) : awdEntity.defexpt != null) return false;
        if (disbloc != null ? !disbloc.equals(awdEntity.disbloc) : awdEntity.disbloc != null) return false;
        if (disbstd != null ? !disbstd.equals(awdEntity.disbstd) : awdEntity.disbstd != null) return false;
        if (doccmp != null ? !doccmp.equals(awdEntity.doccmp) : awdEntity.doccmp != null) return false;
        if (docdte != null ? !docdte.equals(awdEntity.docdte) : awdEntity.docdte != null) return false;
        if (empst1 != null ? !empst1.equals(awdEntity.empst1) : awdEntity.empst1 != null) return false;
        if (empst2 != null ? !empst2.equals(awdEntity.empst2) : awdEntity.empst2 != null) return false;
        if (empst3 != null ? !empst3.equals(awdEntity.empst3) : awdEntity.empst3 != null) return false;
        if (empst4 != null ? !empst4.equals(awdEntity.empst4) : awdEntity.empst4 != null) return false;
        if (enddtec != null ? !enddtec.equals(awdEntity.enddtec) : awdEntity.enddtec != null) return false;
        if (estactl != null ? !estactl.equals(awdEntity.estactl) : awdEntity.estactl != null) return false;
        if (expdate != null ? !expdate.equals(awdEntity.expdate) : awdEntity.expdate != null) return false;
        if (expstat != null ? !expstat.equals(awdEntity.expstat) : awdEntity.expstat != null) return false;
        if (fiscyr != null ? !fiscyr.equals(awdEntity.fiscyr) : awdEntity.fiscyr != null) return false;
        if (incneed != null ? !incneed.equals(awdEntity.incneed) : awdEntity.incneed != null) return false;
        if (initals != null ? !initals.equals(awdEntity.initals) : awdEntity.initals != null) return false;
        if (loannr != null ? !loannr.equals(awdEntity.loannr) : awdEntity.loannr != null) return false;
        if (mempaid != null ? !mempaid.equals(awdEntity.mempaid) : awdEntity.mempaid != null) return false;
        if (mfid != null ? !mfid.equals(awdEntity.mfid) : awdEntity.mfid != null) return false;
        if (module != null ? !module.equals(awdEntity.module) : awdEntity.module != null) return false;
        if (nxtoffr != null ? !nxtoffr.equals(awdEntity.nxtoffr) : awdEntity.nxtoffr != null) return false;
        if (offrdtc != null ? !offrdtc.equals(awdEntity.offrdtc) : awdEntity.offrdtc != null) return false;
        if (offrst != null ? !offrst.equals(awdEntity.offrst) : awdEntity.offrst != null) return false;
        if (orgamt != null ? !orgamt.equals(awdEntity.orgamt) : awdEntity.orgamt != null) return false;
        if (paiddtc != null ? !paiddtc.equals(awdEntity.paiddtc) : awdEntity.paiddtc != null) return false;
        if (paidst != null ? !paidst.equals(awdEntity.paidst) : awdEntity.paidst != null) return false;
        if (pdenrl1 != null ? !pdenrl1.equals(awdEntity.pdenrl1) : awdEntity.pdenrl1 != null) return false;
        if (pdenrl2 != null ? !pdenrl2.equals(awdEntity.pdenrl2) : awdEntity.pdenrl2 != null) return false;
        if (pdenrl3 != null ? !pdenrl3.equals(awdEntity.pdenrl3) : awdEntity.pdenrl3 != null) return false;
        if (pdenrl4 != null ? !pdenrl4.equals(awdEntity.pdenrl4) : awdEntity.pdenrl4 != null) return false;
        if (pdenrl5 != null ? !pdenrl5.equals(awdEntity.pdenrl5) : awdEntity.pdenrl5 != null) return false;
        if (pdenrl6 != null ? !pdenrl6.equals(awdEntity.pdenrl6) : awdEntity.pdenrl6 != null) return false;
        if (pdenrl7 != null ? !pdenrl7.equals(awdEntity.pdenrl7) : awdEntity.pdenrl7 != null) return false;
        if (pdenrl8 != null ? !pdenrl8.equals(awdEntity.pdenrl8) : awdEntity.pdenrl8 != null) return false;
        if (pdenrl9 != null ? !pdenrl9.equals(awdEntity.pdenrl9) : awdEntity.pdenrl9 != null) return false;
        if (pdenrla != null ? !pdenrla.equals(awdEntity.pdenrla) : awdEntity.pdenrla != null) return false;
        if (pdenrlb != null ? !pdenrlb.equals(awdEntity.pdenrlb) : awdEntity.pdenrlb != null) return false;
        if (pdenrlc != null ? !pdenrlc.equals(awdEntity.pdenrlc) : awdEntity.pdenrlc != null) return false;
        if (pdoffr1 != null ? !pdoffr1.equals(awdEntity.pdoffr1) : awdEntity.pdoffr1 != null) return false;
        if (pdoffr2 != null ? !pdoffr2.equals(awdEntity.pdoffr2) : awdEntity.pdoffr2 != null) return false;
        if (pdoffr3 != null ? !pdoffr3.equals(awdEntity.pdoffr3) : awdEntity.pdoffr3 != null) return false;
        if (pdoffr4 != null ? !pdoffr4.equals(awdEntity.pdoffr4) : awdEntity.pdoffr4 != null) return false;
        if (pdoffr5 != null ? !pdoffr5.equals(awdEntity.pdoffr5) : awdEntity.pdoffr5 != null) return false;
        if (pdoffr6 != null ? !pdoffr6.equals(awdEntity.pdoffr6) : awdEntity.pdoffr6 != null) return false;
        if (pdoffr7 != null ? !pdoffr7.equals(awdEntity.pdoffr7) : awdEntity.pdoffr7 != null) return false;
        if (pdoffr8 != null ? !pdoffr8.equals(awdEntity.pdoffr8) : awdEntity.pdoffr8 != null) return false;
        if (pdoffr9 != null ? !pdoffr9.equals(awdEntity.pdoffr9) : awdEntity.pdoffr9 != null) return false;
        if (pdoffra != null ? !pdoffra.equals(awdEntity.pdoffra) : awdEntity.pdoffra != null) return false;
        if (pdoffrb != null ? !pdoffrb.equals(awdEntity.pdoffrb) : awdEntity.pdoffrb != null) return false;
        if (pdoffrc != null ? !pdoffrc.equals(awdEntity.pdoffrc) : awdEntity.pdoffrc != null) return false;
        if (pdpaid1 != null ? !pdpaid1.equals(awdEntity.pdpaid1) : awdEntity.pdpaid1 != null) return false;
        if (pdpaid2 != null ? !pdpaid2.equals(awdEntity.pdpaid2) : awdEntity.pdpaid2 != null) return false;
        if (pdpaid3 != null ? !pdpaid3.equals(awdEntity.pdpaid3) : awdEntity.pdpaid3 != null) return false;
        if (pdpaid4 != null ? !pdpaid4.equals(awdEntity.pdpaid4) : awdEntity.pdpaid4 != null) return false;
        if (pdpaid5 != null ? !pdpaid5.equals(awdEntity.pdpaid5) : awdEntity.pdpaid5 != null) return false;
        if (pdpaid6 != null ? !pdpaid6.equals(awdEntity.pdpaid6) : awdEntity.pdpaid6 != null) return false;
        if (pdpaid7 != null ? !pdpaid7.equals(awdEntity.pdpaid7) : awdEntity.pdpaid7 != null) return false;
        if (pdpaid8 != null ? !pdpaid8.equals(awdEntity.pdpaid8) : awdEntity.pdpaid8 != null) return false;
        if (pdpaid9 != null ? !pdpaid9.equals(awdEntity.pdpaid9) : awdEntity.pdpaid9 != null) return false;
        if (pdpaida != null ? !pdpaida.equals(awdEntity.pdpaida) : awdEntity.pdpaida != null) return false;
        if (pdpaidb != null ? !pdpaidb.equals(awdEntity.pdpaidb) : awdEntity.pdpaidb != null) return false;
        if (pdpaidc != null ? !pdpaidc.equals(awdEntity.pdpaidc) : awdEntity.pdpaidc != null) return false;
        if (penrlt1 != null ? !penrlt1.equals(awdEntity.penrlt1) : awdEntity.penrlt1 != null) return false;
        if (penrlt2 != null ? !penrlt2.equals(awdEntity.penrlt2) : awdEntity.penrlt2 != null) return false;
        if (penrlt3 != null ? !penrlt3.equals(awdEntity.penrlt3) : awdEntity.penrlt3 != null) return false;
        if (penrlt4 != null ? !penrlt4.equals(awdEntity.penrlt4) : awdEntity.penrlt4 != null) return false;
        if (penrlt5 != null ? !penrlt5.equals(awdEntity.penrlt5) : awdEntity.penrlt5 != null) return false;
        if (penrlt6 != null ? !penrlt6.equals(awdEntity.penrlt6) : awdEntity.penrlt6 != null) return false;
        if (pgmname != null ? !pgmname.equals(awdEntity.pgmname) : awdEntity.pgmname != null) return false;
        if (pkgenr1 != null ? !pkgenr1.equals(awdEntity.pkgenr1) : awdEntity.pkgenr1 != null) return false;
        if (pkgenr2 != null ? !pkgenr2.equals(awdEntity.pkgenr2) : awdEntity.pkgenr2 != null) return false;
        if (pkgenr3 != null ? !pkgenr3.equals(awdEntity.pkgenr3) : awdEntity.pkgenr3 != null) return false;
        if (pkgenr4 != null ? !pkgenr4.equals(awdEntity.pkgenr4) : awdEntity.pkgenr4 != null) return false;
        if (pkgenr5 != null ? !pkgenr5.equals(awdEntity.pkgenr5) : awdEntity.pkgenr5 != null) return false;
        if (pkgenr6 != null ? !pkgenr6.equals(awdEntity.pkgenr6) : awdEntity.pkgenr6 != null) return false;
        if (pmnid != null ? !pmnid.equals(awdEntity.pmnid) : awdEntity.pmnid != null) return false;
        if (procrsp != null ? !procrsp.equals(awdEntity.procrsp) : awdEntity.procrsp != null) return false;
        if (promdtc != null ? !promdtc.equals(awdEntity.promdtc) : awdEntity.promdtc != null) return false;
        if (promst != null ? !promst.equals(awdEntity.promst) : awdEntity.promst != null) return false;
        if (prpaid != null ? !prpaid.equals(awdEntity.prpaid) : awdEntity.prpaid != null) return false;
        if (prtrms != null ? !prtrms.equals(awdEntity.prtrms) : awdEntity.prtrms != null) return false;
        if (prvpaid != null ? !prvpaid.equals(awdEntity.prvpaid) : awdEntity.prvpaid != null) return false;
        if (psntyp != null ? !psntyp.equals(awdEntity.psntyp) : awdEntity.psntyp != null) return false;
        if (ptype != null ? !ptype.equals(awdEntity.ptype) : awdEntity.ptype != null) return false;
        if (pymtrm1 != null ? !pymtrm1.equals(awdEntity.pymtrm1) : awdEntity.pymtrm1 != null) return false;
        if (pymtrm2 != null ? !pymtrm2.equals(awdEntity.pymtrm2) : awdEntity.pymtrm2 != null) return false;
        if (pymtrm3 != null ? !pymtrm3.equals(awdEntity.pymtrm3) : awdEntity.pymtrm3 != null) return false;
        if (pymtrm4 != null ? !pymtrm4.equals(awdEntity.pymtrm4) : awdEntity.pymtrm4 != null) return false;
        if (pymtrm5 != null ? !pymtrm5.equals(awdEntity.pymtrm5) : awdEntity.pymtrm5 != null) return false;
        if (pymtrm6 != null ? !pymtrm6.equals(awdEntity.pymtrm6) : awdEntity.pymtrm6 != null) return false;
        if (recstat != null ? !recstat.equals(awdEntity.recstat) : awdEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(awdEntity.revdtec) : awdEntity.revdtec != null) return false;
        if (revlev != null ? !revlev.equals(awdEntity.revlev) : awdEntity.revlev != null) return false;
        if (revreas != null ? !revreas.equals(awdEntity.revreas) : awdEntity.revreas != null) return false;
        if (sarexpd != null ? !sarexpd.equals(awdEntity.sarexpd) : awdEntity.sarexpd != null) return false;
        if (sarexps != null ? !sarexps.equals(awdEntity.sarexps) : awdEntity.sarexps != null) return false;
        if (schsrce != null ? !schsrce.equals(awdEntity.schsrce) : awdEntity.schsrce != null) return false;
        if (schtype != null ? !schtype.equals(awdEntity.schtype) : awdEntity.schtype != null) return false;
        if (sid != null ? !sid.equals(awdEntity.sid) : awdEntity.sid != null) return false;
        if (sitime != null ? !sitime.equals(awdEntity.sitime) : awdEntity.sitime != null) return false;
        if (sponsor != null ? !sponsor.equals(awdEntity.sponsor) : awdEntity.sponsor != null) return false;
        if (taxcode != null ? !taxcode.equals(awdEntity.taxcode) : awdEntity.taxcode != null) return false;
        if (totacpt != null ? !totacpt.equals(awdEntity.totacpt) : awdEntity.totacpt != null) return false;
        if (totcomm != null ? !totcomm.equals(awdEntity.totcomm) : awdEntity.totcomm != null) return false;
        if (totoffr != null ? !totoffr.equals(awdEntity.totoffr) : awdEntity.totoffr != null) return false;
        if (totpaid != null ? !totpaid.equals(awdEntity.totpaid) : awdEntity.totpaid != null) return false;
        if (totprom != null ? !totprom.equals(awdEntity.totprom) : awdEntity.totprom != null) return false;
        if (typeaid != null ? !typeaid.equals(awdEntity.typeaid) : awdEntity.typeaid != null) return false;
        if (typechk != null ? !typechk.equals(awdEntity.typechk) : awdEntity.typechk != null) return false;
        if (typetrm != null ? !typetrm.equals(awdEntity.typetrm) : awdEntity.typetrm != null) return false;
        if (ucode != null ? !ucode.equals(awdEntity.ucode) : awdEntity.ucode != null) return false;
        if (unused1 != null ? !unused1.equals(awdEntity.unused1) : awdEntity.unused1 != null) return false;
        if (usercd1 != null ? !usercd1.equals(awdEntity.usercd1) : awdEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(awdEntity.usercd2) : awdEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(awdEntity.usercd3) : awdEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(awdEntity.usercd4) : awdEntity.usercd4 != null) return false;
        if (usercd5 != null ? !usercd5.equals(awdEntity.usercd5) : awdEntity.usercd5 != null) return false;
        if (usercd6 != null ? !usercd6.equals(awdEntity.usercd6) : awdEntity.usercd6 != null) return false;
        if (usercd7 != null ? !usercd7.equals(awdEntity.usercd7) : awdEntity.usercd7 != null) return false;
        if (usercd8 != null ? !usercd8.equals(awdEntity.usercd8) : awdEntity.usercd8 != null) return false;
        if (usernr1 != null ? !usernr1.equals(awdEntity.usernr1) : awdEntity.usernr1 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (awdkey != null ? awdkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (aidid != null ? aidid.hashCode() : 0);
        result = 31 * result + (ptype != null ? ptype.hashCode() : 0);
        result = 31 * result + (unused1 != null ? unused1.hashCode() : 0);
        result = 31 * result + (asid != null ? asid.hashCode() : 0);
        result = 31 * result + (aaidyr != null ? aaidyr.hashCode() : 0);
        result = 31 * result + (actnr != null ? actnr.hashCode() : 0);
        result = 31 * result + (aptype != null ? aptype.hashCode() : 0);
        result = 31 * result + (loannr != null ? loannr.hashCode() : 0);
        result = 31 * result + (pgmname != null ? pgmname.hashCode() : 0);
        result = 31 * result + (typetrm != null ? typetrm.hashCode() : 0);
        result = 31 * result + (sponsor != null ? sponsor.hashCode() : 0);
        result = 31 * result + (admresp != null ? admresp.hashCode() : 0);
        result = 31 * result + (typeaid != null ? typeaid.hashCode() : 0);
        result = 31 * result + (procrsp != null ? procrsp.hashCode() : 0);
        result = 31 * result + (schsrce != null ? schsrce.hashCode() : 0);
        result = 31 * result + (typechk != null ? typechk.hashCode() : 0);
        result = 31 * result + (disbloc != null ? disbloc.hashCode() : 0);
        result = 31 * result + (taxcode != null ? taxcode.hashCode() : 0);
        result = 31 * result + (schtype != null ? schtype.hashCode() : 0);
        result = 31 * result + (commsch != null ? commsch.hashCode() : 0);
        result = 31 * result + (offrst != null ? offrst.hashCode() : 0);
        result = 31 * result + (acptst != null ? acptst.hashCode() : 0);
        result = 31 * result + (commst != null ? commst.hashCode() : 0);
        result = 31 * result + (paidst != null ? paidst.hashCode() : 0);
        result = 31 * result + (promst != null ? promst.hashCode() : 0);
        result = 31 * result + (revreas != null ? revreas.hashCode() : 0);
        result = 31 * result + (empst1 != null ? empst1.hashCode() : 0);
        result = 31 * result + (empst2 != null ? empst2.hashCode() : 0);
        result = 31 * result + (empst3 != null ? empst3.hashCode() : 0);
        result = 31 * result + (empst4 != null ? empst4.hashCode() : 0);
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
        result = 31 * result + (totoffr != null ? totoffr.hashCode() : 0);
        result = 31 * result + (totacpt != null ? totacpt.hashCode() : 0);
        result = 31 * result + (totcomm != null ? totcomm.hashCode() : 0);
        result = 31 * result + (totpaid != null ? totpaid.hashCode() : 0);
        result = 31 * result + (totprom != null ? totprom.hashCode() : 0);
        result = 31 * result + (pdoffr1 != null ? pdoffr1.hashCode() : 0);
        result = 31 * result + (pdoffr2 != null ? pdoffr2.hashCode() : 0);
        result = 31 * result + (pdoffr3 != null ? pdoffr3.hashCode() : 0);
        result = 31 * result + (pdoffr4 != null ? pdoffr4.hashCode() : 0);
        result = 31 * result + (pdoffr5 != null ? pdoffr5.hashCode() : 0);
        result = 31 * result + (pdoffr6 != null ? pdoffr6.hashCode() : 0);
        result = 31 * result + (pdoffr7 != null ? pdoffr7.hashCode() : 0);
        result = 31 * result + (pdoffr8 != null ? pdoffr8.hashCode() : 0);
        result = 31 * result + (pdoffr9 != null ? pdoffr9.hashCode() : 0);
        result = 31 * result + (pdoffra != null ? pdoffra.hashCode() : 0);
        result = 31 * result + (pdoffrb != null ? pdoffrb.hashCode() : 0);
        result = 31 * result + (pdoffrc != null ? pdoffrc.hashCode() : 0);
        result = 31 * result + (pdenrl1 != null ? pdenrl1.hashCode() : 0);
        result = 31 * result + (pdenrl2 != null ? pdenrl2.hashCode() : 0);
        result = 31 * result + (pdenrl3 != null ? pdenrl3.hashCode() : 0);
        result = 31 * result + (pdenrl4 != null ? pdenrl4.hashCode() : 0);
        result = 31 * result + (pdenrl5 != null ? pdenrl5.hashCode() : 0);
        result = 31 * result + (pdenrl6 != null ? pdenrl6.hashCode() : 0);
        result = 31 * result + (pdenrl7 != null ? pdenrl7.hashCode() : 0);
        result = 31 * result + (pdenrl8 != null ? pdenrl8.hashCode() : 0);
        result = 31 * result + (pdenrl9 != null ? pdenrl9.hashCode() : 0);
        result = 31 * result + (pdenrla != null ? pdenrla.hashCode() : 0);
        result = 31 * result + (pdenrlb != null ? pdenrlb.hashCode() : 0);
        result = 31 * result + (pdenrlc != null ? pdenrlc.hashCode() : 0);
        result = 31 * result + (pdpaid1 != null ? pdpaid1.hashCode() : 0);
        result = 31 * result + (pdpaid2 != null ? pdpaid2.hashCode() : 0);
        result = 31 * result + (pdpaid3 != null ? pdpaid3.hashCode() : 0);
        result = 31 * result + (pdpaid4 != null ? pdpaid4.hashCode() : 0);
        result = 31 * result + (pdpaid5 != null ? pdpaid5.hashCode() : 0);
        result = 31 * result + (pdpaid6 != null ? pdpaid6.hashCode() : 0);
        result = 31 * result + (pdpaid7 != null ? pdpaid7.hashCode() : 0);
        result = 31 * result + (pdpaid8 != null ? pdpaid8.hashCode() : 0);
        result = 31 * result + (pdpaid9 != null ? pdpaid9.hashCode() : 0);
        result = 31 * result + (pdpaida != null ? pdpaida.hashCode() : 0);
        result = 31 * result + (pdpaidb != null ? pdpaidb.hashCode() : 0);
        result = 31 * result + (pdpaidc != null ? pdpaidc.hashCode() : 0);
        result = 31 * result + (prvpaid != null ? prvpaid.hashCode() : 0);
        result = 31 * result + (nxtoffr != null ? nxtoffr.hashCode() : 0);
        result = 31 * result + (prpaid != null ? prpaid.hashCode() : 0);
        result = 31 * result + (prtrms != null ? prtrms.hashCode() : 0);
        result = 31 * result + (curtrms != null ? curtrms.hashCode() : 0);
        result = 31 * result + (curpymt != null ? curpymt.hashCode() : 0);
        result = 31 * result + (curcomm != null ? curcomm.hashCode() : 0);
        result = 31 * result + (pymtrm1 != null ? pymtrm1.hashCode() : 0);
        result = 31 * result + (pymtrm2 != null ? pymtrm2.hashCode() : 0);
        result = 31 * result + (pymtrm3 != null ? pymtrm3.hashCode() : 0);
        result = 31 * result + (pymtrm4 != null ? pymtrm4.hashCode() : 0);
        result = 31 * result + (pymtrm5 != null ? pymtrm5.hashCode() : 0);
        result = 31 * result + (pymtrm6 != null ? pymtrm6.hashCode() : 0);
        result = 31 * result + (awdrdc != null ? awdrdc.hashCode() : 0);
        result = 31 * result + (dclaid != null ? dclaid.hashCode() : 0);
        result = 31 * result + (mfid != null ? mfid.hashCode() : 0);
        result = 31 * result + (mempaid != null ? mempaid.hashCode() : 0);
        result = 31 * result + (incneed != null ? incneed.hashCode() : 0);
        result = 31 * result + (estactl != null ? estactl.hashCode() : 0);
        result = 31 * result + (usernr1 != null ? usernr1.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (sitime != null ? sitime.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (offrdtc != null ? offrdtc.hashCode() : 0);
        result = 31 * result + (acptdtc != null ? acptdtc.hashCode() : 0);
        result = 31 * result + (commdtc != null ? commdtc.hashCode() : 0);
        result = 31 * result + (paiddtc != null ? paiddtc.hashCode() : 0);
        result = 31 * result + (promdtc != null ? promdtc.hashCode() : 0);
        result = 31 * result + (begdtec != null ? begdtec.hashCode() : 0);
        result = 31 * result + (enddtec != null ? enddtec.hashCode() : 0);
        result = 31 * result + (creatdc != null ? creatdc.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (usercd5 != null ? usercd5.hashCode() : 0);
        result = 31 * result + (usercd6 != null ? usercd6.hashCode() : 0);
        result = 31 * result + (usercd7 != null ? usercd7.hashCode() : 0);
        result = 31 * result + (usercd8 != null ? usercd8.hashCode() : 0);
        result = 31 * result + (chrtact != null ? chrtact.hashCode() : 0);
        result = 31 * result + (disbstd != null ? disbstd.hashCode() : 0);
        result = 31 * result + (awdctl != null ? awdctl.hashCode() : 0);
        result = 31 * result + lstads;
        result = 31 * result + lsteds;
        result = 31 * result + (pmnid != null ? pmnid.hashCode() : 0);
        result = 31 * result + (expdate != null ? expdate.hashCode() : 0);
        result = 31 * result + (orgamt != null ? orgamt.hashCode() : 0);
        result = 31 * result + (expstat != null ? expstat.hashCode() : 0);
        result = 31 * result + (psntyp != null ? psntyp.hashCode() : 0);
        result = 31 * result + (docdte != null ? docdte.hashCode() : 0);
        result = 31 * result + (doccmp != null ? doccmp.hashCode() : 0);
        result = 31 * result + (acdlvl != null ? acdlvl.hashCode() : 0);
        result = 31 * result + (pkgenr1 != null ? pkgenr1.hashCode() : 0);
        result = 31 * result + (pkgenr2 != null ? pkgenr2.hashCode() : 0);
        result = 31 * result + (pkgenr3 != null ? pkgenr3.hashCode() : 0);
        result = 31 * result + (pkgenr4 != null ? pkgenr4.hashCode() : 0);
        result = 31 * result + (pkgenr5 != null ? pkgenr5.hashCode() : 0);
        result = 31 * result + (pkgenr6 != null ? pkgenr6.hashCode() : 0);
        result = 31 * result + (sarexps != null ? sarexps.hashCode() : 0);
        result = 31 * result + (sarexpd != null ? sarexpd.hashCode() : 0);
        result = 31 * result + (fiscyr != null ? fiscyr.hashCode() : 0);
        result = 31 * result + (defexpt != null ? defexpt.hashCode() : 0);
        return result;
    }
}
