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
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "PGM", schema = "SIGMA", catalog = "")
@Entity
public class PgmEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getPgmkey();
    }

    private String pgmkey;

    @javax.persistence.Column(name = "PGMKEY")
    @Id
    public String getPgmkey() {
        return pgmkey;
    }

    public void setPgmkey(String pgmkey) {
        this.pgmkey = pgmkey;
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

    private String campus;

    @javax.persistence.Column(name = "CAMPUS")
    @Basic
    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    private String pdesc;

    @javax.persistence.Column(name = "PDESC")
    @Basic
    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
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

    private String ptype2;

    @javax.persistence.Column(name = "PTYPE2")
    @Basic
    public String getPtype2() {
        return ptype2;
    }

    public void setPtype2(String ptype2) {
        this.ptype2 = ptype2;
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

    private String packtyp;

    @javax.persistence.Column(name = "PACKTYP")
    @Basic
    public String getPacktyp() {
        return packtyp;
    }

    public void setPacktyp(String packtyp) {
        this.packtyp = packtyp;
    }

    private int awdmin;

    @javax.persistence.Column(name = "AWDMIN")
    @Basic
    public int getAwdmin() {
        return awdmin;
    }

    public void setAwdmin(int awdmin) {
        this.awdmin = awdmin;
    }

    private int awdmax;

    @javax.persistence.Column(name = "AWDMAX")
    @Basic
    public int getAwdmax() {
        return awdmax;
    }

    public void setAwdmax(int awdmax) {
        this.awdmax = awdmax;
    }

    private int paymin;

    @javax.persistence.Column(name = "PAYMIN")
    @Basic
    public int getPaymin() {
        return paymin;
    }

    public void setPaymin(int paymin) {
        this.paymin = paymin;
    }

    private int paymax;

    @javax.persistence.Column(name = "PAYMAX")
    @Basic
    public int getPaymax() {
        return paymax;
    }

    public void setPaymax(int paymax) {
        this.paymax = paymax;
    }

    private int awdrnd;

    @javax.persistence.Column(name = "AWDRND")
    @Basic
    public int getAwdrnd() {
        return awdrnd;
    }

    public void setAwdrnd(int awdrnd) {
        this.awdrnd = awdrnd;
    }

    private String typernd;

    @javax.persistence.Column(name = "TYPERND")
    @Basic
    public String getTypernd() {
        return typernd;
    }

    public void setTypernd(String typernd) {
        this.typernd = typernd;
    }

    private int nrofft;

    @javax.persistence.Column(name = "NROFFT")
    @Basic
    public int getNrofft() {
        return nrofft;
    }

    public void setNrofft(int nrofft) {
        this.nrofft = nrofft;
    }

    private int nracpt;

    @javax.persistence.Column(name = "NRACPT")
    @Basic
    public int getNracpt() {
        return nracpt;
    }

    public void setNracpt(int nracpt) {
        this.nracpt = nracpt;
    }

    private int nrcommt;

    @javax.persistence.Column(name = "NRCOMMT")
    @Basic
    public int getNrcommt() {
        return nrcommt;
    }

    public void setNrcommt(int nrcommt) {
        this.nrcommt = nrcommt;
    }

    private int nrpaidt;

    @javax.persistence.Column(name = "NRPAIDT")
    @Basic
    public int getNrpaidt() {
        return nrpaidt;
    }

    public void setNrpaidt(int nrpaidt) {
        this.nrpaidt = nrpaidt;
    }

    private int nrowedt;

    @javax.persistence.Column(name = "NROWEDT")
    @Basic
    public int getNrowedt() {
        return nrowedt;
    }

    public void setNrowedt(int nrowedt) {
        this.nrowedt = nrowedt;
    }

    private BigDecimal amtofft;

    @javax.persistence.Column(name = "AMTOFFT")
    @Basic
    public BigDecimal getAmtofft() {
        return amtofft;
    }

    public void setAmtofft(BigDecimal amtofft) {
        this.amtofft = amtofft;
    }

    private BigDecimal amtacct;

    @javax.persistence.Column(name = "AMTACCT")
    @Basic
    public BigDecimal getAmtacct() {
        return amtacct;
    }

    public void setAmtacct(BigDecimal amtacct) {
        this.amtacct = amtacct;
    }

    private BigDecimal amtcomt;

    @javax.persistence.Column(name = "AMTCOMT")
    @Basic
    public BigDecimal getAmtcomt() {
        return amtcomt;
    }

    public void setAmtcomt(BigDecimal amtcomt) {
        this.amtcomt = amtcomt;
    }

    private BigDecimal amtpdt;

    @javax.persistence.Column(name = "AMTPDT")
    @Basic
    public BigDecimal getAmtpdt() {
        return amtpdt;
    }

    public void setAmtpdt(BigDecimal amtpdt) {
        this.amtpdt = amtpdt;
    }

    private BigDecimal amtowdt;

    @javax.persistence.Column(name = "AMTOWDT")
    @Basic
    public BigDecimal getAmtowdt() {
        return amtowdt;
    }

    public void setAmtowdt(BigDecimal amtowdt) {
        this.amtowdt = amtowdt;
    }

    private int nroff1;

    @javax.persistence.Column(name = "NROFF1")
    @Basic
    public int getNroff1() {
        return nroff1;
    }

    public void setNroff1(int nroff1) {
        this.nroff1 = nroff1;
    }

    private int nrpaid1;

    @javax.persistence.Column(name = "NRPAID1")
    @Basic
    public int getNrpaid1() {
        return nrpaid1;
    }

    public void setNrpaid1(int nrpaid1) {
        this.nrpaid1 = nrpaid1;
    }

    private BigDecimal amtoff1;

    @javax.persistence.Column(name = "AMTOFF1")
    @Basic
    public BigDecimal getAmtoff1() {
        return amtoff1;
    }

    public void setAmtoff1(BigDecimal amtoff1) {
        this.amtoff1 = amtoff1;
    }

    private BigDecimal amtpd1;

    @javax.persistence.Column(name = "AMTPD1")
    @Basic
    public BigDecimal getAmtpd1() {
        return amtpd1;
    }

    public void setAmtpd1(BigDecimal amtpd1) {
        this.amtpd1 = amtpd1;
    }

    private int nroff2;

    @javax.persistence.Column(name = "NROFF2")
    @Basic
    public int getNroff2() {
        return nroff2;
    }

    public void setNroff2(int nroff2) {
        this.nroff2 = nroff2;
    }

    private int nrpaid2;

    @javax.persistence.Column(name = "NRPAID2")
    @Basic
    public int getNrpaid2() {
        return nrpaid2;
    }

    public void setNrpaid2(int nrpaid2) {
        this.nrpaid2 = nrpaid2;
    }

    private BigDecimal amtoff2;

    @javax.persistence.Column(name = "AMTOFF2")
    @Basic
    public BigDecimal getAmtoff2() {
        return amtoff2;
    }

    public void setAmtoff2(BigDecimal amtoff2) {
        this.amtoff2 = amtoff2;
    }

    private BigDecimal amtpd2;

    @javax.persistence.Column(name = "AMTPD2")
    @Basic
    public BigDecimal getAmtpd2() {
        return amtpd2;
    }

    public void setAmtpd2(BigDecimal amtpd2) {
        this.amtpd2 = amtpd2;
    }

    private int nroff3;

    @javax.persistence.Column(name = "NROFF3")
    @Basic
    public int getNroff3() {
        return nroff3;
    }

    public void setNroff3(int nroff3) {
        this.nroff3 = nroff3;
    }

    private int nrpaid3;

    @javax.persistence.Column(name = "NRPAID3")
    @Basic
    public int getNrpaid3() {
        return nrpaid3;
    }

    public void setNrpaid3(int nrpaid3) {
        this.nrpaid3 = nrpaid3;
    }

    private BigDecimal amtoff3;

    @javax.persistence.Column(name = "AMTOFF3")
    @Basic
    public BigDecimal getAmtoff3() {
        return amtoff3;
    }

    public void setAmtoff3(BigDecimal amtoff3) {
        this.amtoff3 = amtoff3;
    }

    private BigDecimal amtpd3;

    @javax.persistence.Column(name = "AMTPD3")
    @Basic
    public BigDecimal getAmtpd3() {
        return amtpd3;
    }

    public void setAmtpd3(BigDecimal amtpd3) {
        this.amtpd3 = amtpd3;
    }

    private int nroff4;

    @javax.persistence.Column(name = "NROFF4")
    @Basic
    public int getNroff4() {
        return nroff4;
    }

    public void setNroff4(int nroff4) {
        this.nroff4 = nroff4;
    }

    private int nrpaid4;

    @javax.persistence.Column(name = "NRPAID4")
    @Basic
    public int getNrpaid4() {
        return nrpaid4;
    }

    public void setNrpaid4(int nrpaid4) {
        this.nrpaid4 = nrpaid4;
    }

    private BigDecimal amtoff4;

    @javax.persistence.Column(name = "AMTOFF4")
    @Basic
    public BigDecimal getAmtoff4() {
        return amtoff4;
    }

    public void setAmtoff4(BigDecimal amtoff4) {
        this.amtoff4 = amtoff4;
    }

    private BigDecimal amtpd4;

    @javax.persistence.Column(name = "AMTPD4")
    @Basic
    public BigDecimal getAmtpd4() {
        return amtpd4;
    }

    public void setAmtpd4(BigDecimal amtpd4) {
        this.amtpd4 = amtpd4;
    }

    private int nroff5;

    @javax.persistence.Column(name = "NROFF5")
    @Basic
    public int getNroff5() {
        return nroff5;
    }

    public void setNroff5(int nroff5) {
        this.nroff5 = nroff5;
    }

    private int nrpaid5;

    @javax.persistence.Column(name = "NRPAID5")
    @Basic
    public int getNrpaid5() {
        return nrpaid5;
    }

    public void setNrpaid5(int nrpaid5) {
        this.nrpaid5 = nrpaid5;
    }

    private BigDecimal amtoff5;

    @javax.persistence.Column(name = "AMTOFF5")
    @Basic
    public BigDecimal getAmtoff5() {
        return amtoff5;
    }

    public void setAmtoff5(BigDecimal amtoff5) {
        this.amtoff5 = amtoff5;
    }

    private BigDecimal amtpd5;

    @javax.persistence.Column(name = "AMTPD5")
    @Basic
    public BigDecimal getAmtpd5() {
        return amtpd5;
    }

    public void setAmtpd5(BigDecimal amtpd5) {
        this.amtpd5 = amtpd5;
    }

    private int nroff6;

    @javax.persistence.Column(name = "NROFF6")
    @Basic
    public int getNroff6() {
        return nroff6;
    }

    public void setNroff6(int nroff6) {
        this.nroff6 = nroff6;
    }

    private int nrpaid6;

    @javax.persistence.Column(name = "NRPAID6")
    @Basic
    public int getNrpaid6() {
        return nrpaid6;
    }

    public void setNrpaid6(int nrpaid6) {
        this.nrpaid6 = nrpaid6;
    }

    private BigDecimal amtoff6;

    @javax.persistence.Column(name = "AMTOFF6")
    @Basic
    public BigDecimal getAmtoff6() {
        return amtoff6;
    }

    public void setAmtoff6(BigDecimal amtoff6) {
        this.amtoff6 = amtoff6;
    }

    private BigDecimal amtpd6;

    @javax.persistence.Column(name = "AMTPD6")
    @Basic
    public BigDecimal getAmtpd6() {
        return amtpd6;
    }

    public void setAmtpd6(BigDecimal amtpd6) {
        this.amtpd6 = amtpd6;
    }

    private int nroff7;

    @javax.persistence.Column(name = "NROFF7")
    @Basic
    public int getNroff7() {
        return nroff7;
    }

    public void setNroff7(int nroff7) {
        this.nroff7 = nroff7;
    }

    private int nrpaid7;

    @javax.persistence.Column(name = "NRPAID7")
    @Basic
    public int getNrpaid7() {
        return nrpaid7;
    }

    public void setNrpaid7(int nrpaid7) {
        this.nrpaid7 = nrpaid7;
    }

    private BigDecimal amtoff7;

    @javax.persistence.Column(name = "AMTOFF7")
    @Basic
    public BigDecimal getAmtoff7() {
        return amtoff7;
    }

    public void setAmtoff7(BigDecimal amtoff7) {
        this.amtoff7 = amtoff7;
    }

    private BigDecimal amtpd7;

    @javax.persistence.Column(name = "AMTPD7")
    @Basic
    public BigDecimal getAmtpd7() {
        return amtpd7;
    }

    public void setAmtpd7(BigDecimal amtpd7) {
        this.amtpd7 = amtpd7;
    }

    private int nroff8;

    @javax.persistence.Column(name = "NROFF8")
    @Basic
    public int getNroff8() {
        return nroff8;
    }

    public void setNroff8(int nroff8) {
        this.nroff8 = nroff8;
    }

    private int nrpaid8;

    @javax.persistence.Column(name = "NRPAID8")
    @Basic
    public int getNrpaid8() {
        return nrpaid8;
    }

    public void setNrpaid8(int nrpaid8) {
        this.nrpaid8 = nrpaid8;
    }

    private BigDecimal amtoff8;

    @javax.persistence.Column(name = "AMTOFF8")
    @Basic
    public BigDecimal getAmtoff8() {
        return amtoff8;
    }

    public void setAmtoff8(BigDecimal amtoff8) {
        this.amtoff8 = amtoff8;
    }

    private BigDecimal amtpd8;

    @javax.persistence.Column(name = "AMTPD8")
    @Basic
    public BigDecimal getAmtpd8() {
        return amtpd8;
    }

    public void setAmtpd8(BigDecimal amtpd8) {
        this.amtpd8 = amtpd8;
    }

    private int nroff9;

    @javax.persistence.Column(name = "NROFF9")
    @Basic
    public int getNroff9() {
        return nroff9;
    }

    public void setNroff9(int nroff9) {
        this.nroff9 = nroff9;
    }

    private int nrpaid9;

    @javax.persistence.Column(name = "NRPAID9")
    @Basic
    public int getNrpaid9() {
        return nrpaid9;
    }

    public void setNrpaid9(int nrpaid9) {
        this.nrpaid9 = nrpaid9;
    }

    private BigDecimal amtoff9;

    @javax.persistence.Column(name = "AMTOFF9")
    @Basic
    public BigDecimal getAmtoff9() {
        return amtoff9;
    }

    public void setAmtoff9(BigDecimal amtoff9) {
        this.amtoff9 = amtoff9;
    }

    private BigDecimal amtpd9;

    @javax.persistence.Column(name = "AMTPD9")
    @Basic
    public BigDecimal getAmtpd9() {
        return amtpd9;
    }

    public void setAmtpd9(BigDecimal amtpd9) {
        this.amtpd9 = amtpd9;
    }

    private int nroffa;

    @javax.persistence.Column(name = "NROFFA")
    @Basic
    public int getNroffa() {
        return nroffa;
    }

    public void setNroffa(int nroffa) {
        this.nroffa = nroffa;
    }

    private int nrpaida;

    @javax.persistence.Column(name = "NRPAIDA")
    @Basic
    public int getNrpaida() {
        return nrpaida;
    }

    public void setNrpaida(int nrpaida) {
        this.nrpaida = nrpaida;
    }

    private BigDecimal amtoffa;

    @javax.persistence.Column(name = "AMTOFFA")
    @Basic
    public BigDecimal getAmtoffa() {
        return amtoffa;
    }

    public void setAmtoffa(BigDecimal amtoffa) {
        this.amtoffa = amtoffa;
    }

    private BigDecimal amtpda;

    @javax.persistence.Column(name = "AMTPDA")
    @Basic
    public BigDecimal getAmtpda() {
        return amtpda;
    }

    public void setAmtpda(BigDecimal amtpda) {
        this.amtpda = amtpda;
    }

    private int nroffb;

    @javax.persistence.Column(name = "NROFFB")
    @Basic
    public int getNroffb() {
        return nroffb;
    }

    public void setNroffb(int nroffb) {
        this.nroffb = nroffb;
    }

    private int nrpaidb;

    @javax.persistence.Column(name = "NRPAIDB")
    @Basic
    public int getNrpaidb() {
        return nrpaidb;
    }

    public void setNrpaidb(int nrpaidb) {
        this.nrpaidb = nrpaidb;
    }

    private BigDecimal amtoffb;

    @javax.persistence.Column(name = "AMTOFFB")
    @Basic
    public BigDecimal getAmtoffb() {
        return amtoffb;
    }

    public void setAmtoffb(BigDecimal amtoffb) {
        this.amtoffb = amtoffb;
    }

    private BigDecimal amtpdb;

    @javax.persistence.Column(name = "AMTPDB")
    @Basic
    public BigDecimal getAmtpdb() {
        return amtpdb;
    }

    public void setAmtpdb(BigDecimal amtpdb) {
        this.amtpdb = amtpdb;
    }

    private int nroffc;

    @javax.persistence.Column(name = "NROFFC")
    @Basic
    public int getNroffc() {
        return nroffc;
    }

    public void setNroffc(int nroffc) {
        this.nroffc = nroffc;
    }

    private int nrpaidc;

    @javax.persistence.Column(name = "NRPAIDC")
    @Basic
    public int getNrpaidc() {
        return nrpaidc;
    }

    public void setNrpaidc(int nrpaidc) {
        this.nrpaidc = nrpaidc;
    }

    private BigDecimal amtoffc;

    @javax.persistence.Column(name = "AMTOFFC")
    @Basic
    public BigDecimal getAmtoffc() {
        return amtoffc;
    }

    public void setAmtoffc(BigDecimal amtoffc) {
        this.amtoffc = amtoffc;
    }

    private BigDecimal amtpdc;

    @javax.persistence.Column(name = "AMTPDC")
    @Basic
    public BigDecimal getAmtpdc() {
        return amtpdc;
    }

    public void setAmtpdc(BigDecimal amtpdc) {
        this.amtpdc = amtpdc;
    }

    private BigDecimal progbud;

    @javax.persistence.Column(name = "PROGBUD")
    @Basic
    public BigDecimal getProgbud() {
        return progbud;
    }

    public void setProgbud(BigDecimal progbud) {
        this.progbud = progbud;
    }

    private String typebud;

    @javax.persistence.Column(name = "TYPEBUD")
    @Basic
    public String getTypebud() {
        return typebud;
    }

    public void setTypebud(String typebud) {
        this.typebud = typebud;
    }

    private BigDecimal bperoff;

    @javax.persistence.Column(name = "BPEROFF")
    @Basic
    public BigDecimal getBperoff() {
        return bperoff;
    }

    public void setBperoff(BigDecimal bperoff) {
        this.bperoff = bperoff;
    }

    private BigDecimal bperacc;

    @javax.persistence.Column(name = "BPERACC")
    @Basic
    public BigDecimal getBperacc() {
        return bperacc;
    }

    public void setBperacc(BigDecimal bperacc) {
        this.bperacc = bperacc;
    }

    private BigDecimal bpersch;

    @javax.persistence.Column(name = "BPERSCH")
    @Basic
    public BigDecimal getBpersch() {
        return bpersch;
    }

    public void setBpersch(BigDecimal bpersch) {
        this.bpersch = bpersch;
    }

    private BigDecimal bperpay;

    @javax.persistence.Column(name = "BPERPAY")
    @Basic
    public BigDecimal getBperpay() {
        return bperpay;
    }

    public void setBperpay(BigDecimal bperpay) {
        this.bperpay = bperpay;
    }

    private String resrv1;

    @javax.persistence.Column(name = "RESRV1")
    @Basic
    public String getResrv1() {
        return resrv1;
    }

    public void setResrv1(String resrv1) {
        this.resrv1 = resrv1;
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

    private BigDecimal usernr1;

    @javax.persistence.Column(name = "USERNR1")
    @Basic
    public BigDecimal getUsernr1() {
        return usernr1;
    }

    public void setUsernr1(BigDecimal usernr1) {
        this.usernr1 = usernr1;
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

    private String paynofc;

    @javax.persistence.Column(name = "PAYNOFC")
    @Basic
    public String getPaynofc() {
        return paynofc;
    }

    public void setPaynofc(String paynofc) {
        this.paynofc = paynofc;
    }

    private int pmtpcty;

    @javax.persistence.Column(name = "PMTPCTY")
    @Basic
    public int getPmtpcty() {
        return pmtpcty;
    }

    public void setPmtpcty(int pmtpcty) {
        this.pmtpcty = pmtpcty;
    }

    private int pmtpctn;

    @javax.persistence.Column(name = "PMTPCTN")
    @Basic
    public int getPmtpctn() {
        return pmtpctn;
    }

    public void setPmtpctn(int pmtpctn) {
        this.pmtpctn = pmtpctn;
    }

    private int pmtpctf;

    @javax.persistence.Column(name = "PMTPCTF")
    @Basic
    public int getPmtpctf() {
        return pmtpctf;
    }

    public void setPmtpctf(int pmtpctf) {
        this.pmtpctf = pmtpctf;
    }

    private int pmtpctt;

    @javax.persistence.Column(name = "PMTPCTT")
    @Basic
    public int getPmtpctt() {
        return pmtpctt;
    }

    public void setPmtpctt(int pmtpctt) {
        this.pmtpctt = pmtpctt;
    }

    private int pmtpcth;

    @javax.persistence.Column(name = "PMTPCTH")
    @Basic
    public int getPmtpcth() {
        return pmtpcth;
    }

    public void setPmtpcth(int pmtpcth) {
        this.pmtpcth = pmtpcth;
    }

    private int pmtpctl;

    @javax.persistence.Column(name = "PMTPCTL")
    @Basic
    public int getPmtpctl() {
        return pmtpctl;
    }

    public void setPmtpctl(int pmtpctl) {
        this.pmtpctl = pmtpctl;
    }

    private int pmtpctb;

    @javax.persistence.Column(name = "PMTPCTB")
    @Basic
    public int getPmtpctb() {
        return pmtpctb;
    }

    public void setPmtpctb(int pmtpctb) {
        this.pmtpctb = pmtpctb;
    }

    private String eqtytyp;

    @javax.persistence.Column(name = "EQTYTYP")
    @Basic
    public String getEqtytyp() {
        return eqtytyp;
    }

    public void setEqtytyp(String eqtytyp) {
        this.eqtytyp = eqtytyp;
    }

    private String pollim;

    @javax.persistence.Column(name = "POLLIM")
    @Basic
    public String getPollim() {
        return pollim;
    }

    public void setPollim(String pollim) {
        this.pollim = pollim;
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

    private int lnseq;

    @javax.persistence.Column(name = "LNSEQ")
    @Basic
    public int getLnseq() {
        return lnseq;
    }

    public void setLnseq(int lnseq) {
        this.lnseq = lnseq;
    }

    private int pnseq;

    @javax.persistence.Column(name = "PNSEQ")
    @Basic
    public int getPnseq() {
        return pnseq;
    }

    public void setPnseq(int pnseq) {
        this.pnseq = pnseq;
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

    private String chrtact;

    @javax.persistence.Column(name = "CHRTACT")
    @Basic
    public String getChrtact() {
        return chrtact;
    }

    public void setChrtact(String chrtact) {
        this.chrtact = chrtact;
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

    private String begdtc;

    @javax.persistence.Column(name = "BEGDTC")
    @Basic
    public String getBegdtc() {
        return begdtc;
    }

    public void setBegdtc(String begdtc) {
        this.begdtc = begdtc;
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

    private String revdtec;

    @javax.persistence.Column(name = "REVDTEC")
    @Basic
    public String getRevdtec() {
        return revdtec;
    }

    public void setRevdtec(String revdtec) {
        this.revdtec = revdtec;
    }

    private String product;

    @javax.persistence.Column(name = "PRODUCT")
    @Basic
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    private BigDecimal amtdecl;

    @javax.persistence.Column(name = "AMTDECL")
    @Basic
    public BigDecimal getAmtdecl() {
        return amtdecl;
    }

    public void setAmtdecl(BigDecimal amtdecl) {
        this.amtdecl = amtdecl;
    }

    private int nrdecl;

    @javax.persistence.Column(name = "NRDECL")
    @Basic
    public int getNrdecl() {
        return nrdecl;
    }

    public void setNrdecl(int nrdecl) {
        this.nrdecl = nrdecl;
    }

    private String hrstype;

    @javax.persistence.Column(name = "HRSTYPE")
    @Basic
    public String getHrstype() {
        return hrstype;
    }

    public void setHrstype(String hrstype) {
        this.hrstype = hrstype;
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

    private String pmltyp;

    @javax.persistence.Column(name = "PMLTYP")
    @Basic
    public String getPmltyp() {
        return pmltyp;
    }

    public void setPmltyp(String pmltyp) {
        this.pmltyp = pmltyp;
    }

    private String rulecon;

    @javax.persistence.Column(name = "RULECON")
    @Basic
    public String getRulecon() {
        return rulecon;
    }

    public void setRulecon(String rulecon) {
        this.rulecon = rulecon;
    }

    private String doccon;

    @javax.persistence.Column(name = "DOCCON")
    @Basic
    public String getDoccon() {
        return doccon;
    }

    public void setDoccon(String doccon) {
        this.doccon = doccon;
    }

    private String pcttype;

    @javax.persistence.Column(name = "PCTTYPE")
    @Basic
    public String getPcttype() {
        return pcttype;
    }

    public void setPcttype(String pcttype) {
        this.pcttype = pcttype;
    }

    private int pckperc;

    @javax.persistence.Column(name = "PCKPERC")
    @Basic
    public int getPckperc() {
        return pckperc;
    }

    public void setPckperc(int pckperc) {
        this.pckperc = pckperc;
    }

    private String webctrl;

    @javax.persistence.Column(name = "WEBCTRL")
    @Basic
    public String getWebctrl() {
        return webctrl;
    }

    public void setWebctrl(String webctrl) {
        this.webctrl = webctrl;
    }

    private String postctl;

    @javax.persistence.Column(name = "POSTCTL")
    @Basic
    public String getPostctl() {
        return postctl;
    }

    public void setPostctl(String postctl) {
        this.postctl = postctl;
    }

    private String dsbhld;

    @javax.persistence.Column(name = "DSBHLD")
    @Basic
    public String getDsbhld() {
        return dsbhld;
    }

    public void setDsbhld(String dsbhld) {
        this.dsbhld = dsbhld;
    }

    private String frzpaid;

    @javax.persistence.Column(name = "FRZPAID")
    @Basic
    public String getFrzpaid() {
        return frzpaid;
    }

    public void setFrzpaid(String frzpaid) {
        this.frzpaid = frzpaid;
    }

    private String ahrstyp;

    @javax.persistence.Column(name = "AHRSTYP")
    @Basic
    public String getAhrstyp() {
        return ahrstyp;
    }

    public void setAhrstyp(String ahrstyp) {
        this.ahrstyp = ahrstyp;
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

    private int manptm;

    @javax.persistence.Column(name = "MANPTM")
    @Basic
    public int getManptm() {
        return manptm;
    }

    public void setManptm(int manptm) {
        this.manptm = manptm;
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

    private String aschtyp;

    @javax.persistence.Column(name = "ASCHTYP")
    @Basic
    public String getAschtyp() {
        return aschtyp;
    }

    public void setAschtyp(String aschtyp) {
        this.aschtyp = aschtyp;
    }

    private String actnum;

    @javax.persistence.Column(name = "ACTNUM")
    @Basic
    public String getActnum() {
        return actnum;
    }

    public void setActnum(String actnum) {
        this.actnum = actnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PgmEntity pgmEntity = (PgmEntity) o;

        if (awdmax != pgmEntity.awdmax) return false;
        if (awdmin != pgmEntity.awdmin) return false;
        if (awdrnd != pgmEntity.awdrnd) return false;
        if (lnseq != pgmEntity.lnseq) return false;
        if (manptm != pgmEntity.manptm) return false;
        if (nracpt != pgmEntity.nracpt) return false;
        if (nrcommt != pgmEntity.nrcommt) return false;
        if (nrdecl != pgmEntity.nrdecl) return false;
        if (nroff1 != pgmEntity.nroff1) return false;
        if (nroff2 != pgmEntity.nroff2) return false;
        if (nroff3 != pgmEntity.nroff3) return false;
        if (nroff4 != pgmEntity.nroff4) return false;
        if (nroff5 != pgmEntity.nroff5) return false;
        if (nroff6 != pgmEntity.nroff6) return false;
        if (nroff7 != pgmEntity.nroff7) return false;
        if (nroff8 != pgmEntity.nroff8) return false;
        if (nroff9 != pgmEntity.nroff9) return false;
        if (nroffa != pgmEntity.nroffa) return false;
        if (nroffb != pgmEntity.nroffb) return false;
        if (nroffc != pgmEntity.nroffc) return false;
        if (nrofft != pgmEntity.nrofft) return false;
        if (nrowedt != pgmEntity.nrowedt) return false;
        if (nrpaid1 != pgmEntity.nrpaid1) return false;
        if (nrpaid2 != pgmEntity.nrpaid2) return false;
        if (nrpaid3 != pgmEntity.nrpaid3) return false;
        if (nrpaid4 != pgmEntity.nrpaid4) return false;
        if (nrpaid5 != pgmEntity.nrpaid5) return false;
        if (nrpaid6 != pgmEntity.nrpaid6) return false;
        if (nrpaid7 != pgmEntity.nrpaid7) return false;
        if (nrpaid8 != pgmEntity.nrpaid8) return false;
        if (nrpaid9 != pgmEntity.nrpaid9) return false;
        if (nrpaida != pgmEntity.nrpaida) return false;
        if (nrpaidb != pgmEntity.nrpaidb) return false;
        if (nrpaidc != pgmEntity.nrpaidc) return false;
        if (nrpaidt != pgmEntity.nrpaidt) return false;
        if (paymax != pgmEntity.paymax) return false;
        if (paymin != pgmEntity.paymin) return false;
        if (pckperc != pgmEntity.pckperc) return false;
        if (pmtpctb != pgmEntity.pmtpctb) return false;
        if (pmtpctf != pgmEntity.pmtpctf) return false;
        if (pmtpcth != pgmEntity.pmtpcth) return false;
        if (pmtpctl != pgmEntity.pmtpctl) return false;
        if (pmtpctn != pgmEntity.pmtpctn) return false;
        if (pmtpctt != pgmEntity.pmtpctt) return false;
        if (pmtpcty != pgmEntity.pmtpcty) return false;
        if (pnseq != pgmEntity.pnseq) return false;
        if (aaidyr != null ? !aaidyr.equals(pgmEntity.aaidyr) : pgmEntity.aaidyr != null) return false;
        if (actnr != null ? !actnr.equals(pgmEntity.actnr) : pgmEntity.actnr != null) return false;
        if (actnum != null ? !actnum.equals(pgmEntity.actnum) : pgmEntity.actnum != null) return false;
        if (admresp != null ? !admresp.equals(pgmEntity.admresp) : pgmEntity.admresp != null) return false;
        if (ahrstyp != null ? !ahrstyp.equals(pgmEntity.ahrstyp) : pgmEntity.ahrstyp != null) return false;
        if (aidid != null ? !aidid.equals(pgmEntity.aidid) : pgmEntity.aidid != null) return false;
        if (aidyr != null ? !aidyr.equals(pgmEntity.aidyr) : pgmEntity.aidyr != null) return false;
        if (amtacct != null ? !amtacct.equals(pgmEntity.amtacct) : pgmEntity.amtacct != null) return false;
        if (amtcomt != null ? !amtcomt.equals(pgmEntity.amtcomt) : pgmEntity.amtcomt != null) return false;
        if (amtdecl != null ? !amtdecl.equals(pgmEntity.amtdecl) : pgmEntity.amtdecl != null) return false;
        if (amtoff1 != null ? !amtoff1.equals(pgmEntity.amtoff1) : pgmEntity.amtoff1 != null) return false;
        if (amtoff2 != null ? !amtoff2.equals(pgmEntity.amtoff2) : pgmEntity.amtoff2 != null) return false;
        if (amtoff3 != null ? !amtoff3.equals(pgmEntity.amtoff3) : pgmEntity.amtoff3 != null) return false;
        if (amtoff4 != null ? !amtoff4.equals(pgmEntity.amtoff4) : pgmEntity.amtoff4 != null) return false;
        if (amtoff5 != null ? !amtoff5.equals(pgmEntity.amtoff5) : pgmEntity.amtoff5 != null) return false;
        if (amtoff6 != null ? !amtoff6.equals(pgmEntity.amtoff6) : pgmEntity.amtoff6 != null) return false;
        if (amtoff7 != null ? !amtoff7.equals(pgmEntity.amtoff7) : pgmEntity.amtoff7 != null) return false;
        if (amtoff8 != null ? !amtoff8.equals(pgmEntity.amtoff8) : pgmEntity.amtoff8 != null) return false;
        if (amtoff9 != null ? !amtoff9.equals(pgmEntity.amtoff9) : pgmEntity.amtoff9 != null) return false;
        if (amtoffa != null ? !amtoffa.equals(pgmEntity.amtoffa) : pgmEntity.amtoffa != null) return false;
        if (amtoffb != null ? !amtoffb.equals(pgmEntity.amtoffb) : pgmEntity.amtoffb != null) return false;
        if (amtoffc != null ? !amtoffc.equals(pgmEntity.amtoffc) : pgmEntity.amtoffc != null) return false;
        if (amtofft != null ? !amtofft.equals(pgmEntity.amtofft) : pgmEntity.amtofft != null) return false;
        if (amtowdt != null ? !amtowdt.equals(pgmEntity.amtowdt) : pgmEntity.amtowdt != null) return false;
        if (amtpd1 != null ? !amtpd1.equals(pgmEntity.amtpd1) : pgmEntity.amtpd1 != null) return false;
        if (amtpd2 != null ? !amtpd2.equals(pgmEntity.amtpd2) : pgmEntity.amtpd2 != null) return false;
        if (amtpd3 != null ? !amtpd3.equals(pgmEntity.amtpd3) : pgmEntity.amtpd3 != null) return false;
        if (amtpd4 != null ? !amtpd4.equals(pgmEntity.amtpd4) : pgmEntity.amtpd4 != null) return false;
        if (amtpd5 != null ? !amtpd5.equals(pgmEntity.amtpd5) : pgmEntity.amtpd5 != null) return false;
        if (amtpd6 != null ? !amtpd6.equals(pgmEntity.amtpd6) : pgmEntity.amtpd6 != null) return false;
        if (amtpd7 != null ? !amtpd7.equals(pgmEntity.amtpd7) : pgmEntity.amtpd7 != null) return false;
        if (amtpd8 != null ? !amtpd8.equals(pgmEntity.amtpd8) : pgmEntity.amtpd8 != null) return false;
        if (amtpd9 != null ? !amtpd9.equals(pgmEntity.amtpd9) : pgmEntity.amtpd9 != null) return false;
        if (amtpda != null ? !amtpda.equals(pgmEntity.amtpda) : pgmEntity.amtpda != null) return false;
        if (amtpdb != null ? !amtpdb.equals(pgmEntity.amtpdb) : pgmEntity.amtpdb != null) return false;
        if (amtpdc != null ? !amtpdc.equals(pgmEntity.amtpdc) : pgmEntity.amtpdc != null) return false;
        if (amtpdt != null ? !amtpdt.equals(pgmEntity.amtpdt) : pgmEntity.amtpdt != null) return false;
        if (aschtyp != null ? !aschtyp.equals(pgmEntity.aschtyp) : pgmEntity.aschtyp != null) return false;
        if (awdctl != null ? !awdctl.equals(pgmEntity.awdctl) : pgmEntity.awdctl != null) return false;
        if (begdtc != null ? !begdtc.equals(pgmEntity.begdtc) : pgmEntity.begdtc != null) return false;
        if (bperacc != null ? !bperacc.equals(pgmEntity.bperacc) : pgmEntity.bperacc != null) return false;
        if (bperoff != null ? !bperoff.equals(pgmEntity.bperoff) : pgmEntity.bperoff != null) return false;
        if (bperpay != null ? !bperpay.equals(pgmEntity.bperpay) : pgmEntity.bperpay != null) return false;
        if (bpersch != null ? !bpersch.equals(pgmEntity.bpersch) : pgmEntity.bpersch != null) return false;
        if (campus != null ? !campus.equals(pgmEntity.campus) : pgmEntity.campus != null) return false;
        if (chrtact != null ? !chrtact.equals(pgmEntity.chrtact) : pgmEntity.chrtact != null) return false;
        if (dclaid != null ? !dclaid.equals(pgmEntity.dclaid) : pgmEntity.dclaid != null) return false;
        if (defexpt != null ? !defexpt.equals(pgmEntity.defexpt) : pgmEntity.defexpt != null) return false;
        if (disbloc != null ? !disbloc.equals(pgmEntity.disbloc) : pgmEntity.disbloc != null) return false;
        if (disbstd != null ? !disbstd.equals(pgmEntity.disbstd) : pgmEntity.disbstd != null) return false;
        if (doccon != null ? !doccon.equals(pgmEntity.doccon) : pgmEntity.doccon != null) return false;
        if (dsbhld != null ? !dsbhld.equals(pgmEntity.dsbhld) : pgmEntity.dsbhld != null) return false;
        if (enddtec != null ? !enddtec.equals(pgmEntity.enddtec) : pgmEntity.enddtec != null) return false;
        if (eqtytyp != null ? !eqtytyp.equals(pgmEntity.eqtytyp) : pgmEntity.eqtytyp != null) return false;
        if (fiscyr != null ? !fiscyr.equals(pgmEntity.fiscyr) : pgmEntity.fiscyr != null) return false;
        if (frzpaid != null ? !frzpaid.equals(pgmEntity.frzpaid) : pgmEntity.frzpaid != null) return false;
        if (hrstype != null ? !hrstype.equals(pgmEntity.hrstype) : pgmEntity.hrstype != null) return false;
        if (incneed != null ? !incneed.equals(pgmEntity.incneed) : pgmEntity.incneed != null) return false;
        if (initals != null ? !initals.equals(pgmEntity.initals) : pgmEntity.initals != null) return false;
        if (mfid != null ? !mfid.equals(pgmEntity.mfid) : pgmEntity.mfid != null) return false;
        if (module != null ? !module.equals(pgmEntity.module) : pgmEntity.module != null) return false;
        if (packtyp != null ? !packtyp.equals(pgmEntity.packtyp) : pgmEntity.packtyp != null) return false;
        if (paynofc != null ? !paynofc.equals(pgmEntity.paynofc) : pgmEntity.paynofc != null) return false;
        if (pcttype != null ? !pcttype.equals(pgmEntity.pcttype) : pgmEntity.pcttype != null) return false;
        if (pdesc != null ? !pdesc.equals(pgmEntity.pdesc) : pgmEntity.pdesc != null) return false;
        if (pgmkey != null ? !pgmkey.equals(pgmEntity.pgmkey) : pgmEntity.pgmkey != null) return false;
        if (pgmname != null ? !pgmname.equals(pgmEntity.pgmname) : pgmEntity.pgmname != null) return false;
        if (pmltyp != null ? !pmltyp.equals(pgmEntity.pmltyp) : pgmEntity.pmltyp != null) return false;
        if (pollim != null ? !pollim.equals(pgmEntity.pollim) : pgmEntity.pollim != null) return false;
        if (postctl != null ? !postctl.equals(pgmEntity.postctl) : pgmEntity.postctl != null) return false;
        if (procrsp != null ? !procrsp.equals(pgmEntity.procrsp) : pgmEntity.procrsp != null) return false;
        if (product != null ? !product.equals(pgmEntity.product) : pgmEntity.product != null) return false;
        if (progbud != null ? !progbud.equals(pgmEntity.progbud) : pgmEntity.progbud != null) return false;
        if (ptype != null ? !ptype.equals(pgmEntity.ptype) : pgmEntity.ptype != null) return false;
        if (ptype2 != null ? !ptype2.equals(pgmEntity.ptype2) : pgmEntity.ptype2 != null) return false;
        if (resrv1 != null ? !resrv1.equals(pgmEntity.resrv1) : pgmEntity.resrv1 != null) return false;
        if (revdtec != null ? !revdtec.equals(pgmEntity.revdtec) : pgmEntity.revdtec != null) return false;
        if (revlev != null ? !revlev.equals(pgmEntity.revlev) : pgmEntity.revlev != null) return false;
        if (rulecon != null ? !rulecon.equals(pgmEntity.rulecon) : pgmEntity.rulecon != null) return false;
        if (sartran != null ? !sartran.equals(pgmEntity.sartran) : pgmEntity.sartran != null) return false;
        if (schsrce != null ? !schsrce.equals(pgmEntity.schsrce) : pgmEntity.schsrce != null) return false;
        if (schtype != null ? !schtype.equals(pgmEntity.schtype) : pgmEntity.schtype != null) return false;
        if (sitime != null ? !sitime.equals(pgmEntity.sitime) : pgmEntity.sitime != null) return false;
        if (sponsor != null ? !sponsor.equals(pgmEntity.sponsor) : pgmEntity.sponsor != null) return false;
        if (taxcode != null ? !taxcode.equals(pgmEntity.taxcode) : pgmEntity.taxcode != null) return false;
        if (term != null ? !term.equals(pgmEntity.term) : pgmEntity.term != null) return false;
        if (typeaid != null ? !typeaid.equals(pgmEntity.typeaid) : pgmEntity.typeaid != null) return false;
        if (typebud != null ? !typebud.equals(pgmEntity.typebud) : pgmEntity.typebud != null) return false;
        if (typechk != null ? !typechk.equals(pgmEntity.typechk) : pgmEntity.typechk != null) return false;
        if (typernd != null ? !typernd.equals(pgmEntity.typernd) : pgmEntity.typernd != null) return false;
        if (typetrm != null ? !typetrm.equals(pgmEntity.typetrm) : pgmEntity.typetrm != null) return false;
        if (ucode != null ? !ucode.equals(pgmEntity.ucode) : pgmEntity.ucode != null) return false;
        if (usercd1 != null ? !usercd1.equals(pgmEntity.usercd1) : pgmEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(pgmEntity.usercd2) : pgmEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(pgmEntity.usercd3) : pgmEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(pgmEntity.usercd4) : pgmEntity.usercd4 != null) return false;
        if (usercd5 != null ? !usercd5.equals(pgmEntity.usercd5) : pgmEntity.usercd5 != null) return false;
        if (usercd6 != null ? !usercd6.equals(pgmEntity.usercd6) : pgmEntity.usercd6 != null) return false;
        if (usercd7 != null ? !usercd7.equals(pgmEntity.usercd7) : pgmEntity.usercd7 != null) return false;
        if (usercd8 != null ? !usercd8.equals(pgmEntity.usercd8) : pgmEntity.usercd8 != null) return false;
        if (usernr1 != null ? !usernr1.equals(pgmEntity.usernr1) : pgmEntity.usernr1 != null) return false;
        if (webctrl != null ? !webctrl.equals(pgmEntity.webctrl) : pgmEntity.webctrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pgmkey != null ? pgmkey.hashCode() : 0;
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (aidid != null ? aidid.hashCode() : 0);
        result = 31 * result + (ptype != null ? ptype.hashCode() : 0);
        result = 31 * result + (aaidyr != null ? aaidyr.hashCode() : 0);
        result = 31 * result + (actnr != null ? actnr.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (pdesc != null ? pdesc.hashCode() : 0);
        result = 31 * result + (pgmname != null ? pgmname.hashCode() : 0);
        result = 31 * result + (ptype2 != null ? ptype2.hashCode() : 0);
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
        result = 31 * result + (packtyp != null ? packtyp.hashCode() : 0);
        result = 31 * result + awdmin;
        result = 31 * result + awdmax;
        result = 31 * result + paymin;
        result = 31 * result + paymax;
        result = 31 * result + awdrnd;
        result = 31 * result + (typernd != null ? typernd.hashCode() : 0);
        result = 31 * result + nrofft;
        result = 31 * result + nracpt;
        result = 31 * result + nrcommt;
        result = 31 * result + nrpaidt;
        result = 31 * result + nrowedt;
        result = 31 * result + (amtofft != null ? amtofft.hashCode() : 0);
        result = 31 * result + (amtacct != null ? amtacct.hashCode() : 0);
        result = 31 * result + (amtcomt != null ? amtcomt.hashCode() : 0);
        result = 31 * result + (amtpdt != null ? amtpdt.hashCode() : 0);
        result = 31 * result + (amtowdt != null ? amtowdt.hashCode() : 0);
        result = 31 * result + nroff1;
        result = 31 * result + nrpaid1;
        result = 31 * result + (amtoff1 != null ? amtoff1.hashCode() : 0);
        result = 31 * result + (amtpd1 != null ? amtpd1.hashCode() : 0);
        result = 31 * result + nroff2;
        result = 31 * result + nrpaid2;
        result = 31 * result + (amtoff2 != null ? amtoff2.hashCode() : 0);
        result = 31 * result + (amtpd2 != null ? amtpd2.hashCode() : 0);
        result = 31 * result + nroff3;
        result = 31 * result + nrpaid3;
        result = 31 * result + (amtoff3 != null ? amtoff3.hashCode() : 0);
        result = 31 * result + (amtpd3 != null ? amtpd3.hashCode() : 0);
        result = 31 * result + nroff4;
        result = 31 * result + nrpaid4;
        result = 31 * result + (amtoff4 != null ? amtoff4.hashCode() : 0);
        result = 31 * result + (amtpd4 != null ? amtpd4.hashCode() : 0);
        result = 31 * result + nroff5;
        result = 31 * result + nrpaid5;
        result = 31 * result + (amtoff5 != null ? amtoff5.hashCode() : 0);
        result = 31 * result + (amtpd5 != null ? amtpd5.hashCode() : 0);
        result = 31 * result + nroff6;
        result = 31 * result + nrpaid6;
        result = 31 * result + (amtoff6 != null ? amtoff6.hashCode() : 0);
        result = 31 * result + (amtpd6 != null ? amtpd6.hashCode() : 0);
        result = 31 * result + nroff7;
        result = 31 * result + nrpaid7;
        result = 31 * result + (amtoff7 != null ? amtoff7.hashCode() : 0);
        result = 31 * result + (amtpd7 != null ? amtpd7.hashCode() : 0);
        result = 31 * result + nroff8;
        result = 31 * result + nrpaid8;
        result = 31 * result + (amtoff8 != null ? amtoff8.hashCode() : 0);
        result = 31 * result + (amtpd8 != null ? amtpd8.hashCode() : 0);
        result = 31 * result + nroff9;
        result = 31 * result + nrpaid9;
        result = 31 * result + (amtoff9 != null ? amtoff9.hashCode() : 0);
        result = 31 * result + (amtpd9 != null ? amtpd9.hashCode() : 0);
        result = 31 * result + nroffa;
        result = 31 * result + nrpaida;
        result = 31 * result + (amtoffa != null ? amtoffa.hashCode() : 0);
        result = 31 * result + (amtpda != null ? amtpda.hashCode() : 0);
        result = 31 * result + nroffb;
        result = 31 * result + nrpaidb;
        result = 31 * result + (amtoffb != null ? amtoffb.hashCode() : 0);
        result = 31 * result + (amtpdb != null ? amtpdb.hashCode() : 0);
        result = 31 * result + nroffc;
        result = 31 * result + nrpaidc;
        result = 31 * result + (amtoffc != null ? amtoffc.hashCode() : 0);
        result = 31 * result + (amtpdc != null ? amtpdc.hashCode() : 0);
        result = 31 * result + (progbud != null ? progbud.hashCode() : 0);
        result = 31 * result + (typebud != null ? typebud.hashCode() : 0);
        result = 31 * result + (bperoff != null ? bperoff.hashCode() : 0);
        result = 31 * result + (bperacc != null ? bperacc.hashCode() : 0);
        result = 31 * result + (bpersch != null ? bpersch.hashCode() : 0);
        result = 31 * result + (bperpay != null ? bperpay.hashCode() : 0);
        result = 31 * result + (resrv1 != null ? resrv1.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + (usernr1 != null ? usernr1.hashCode() : 0);
        result = 31 * result + (incneed != null ? incneed.hashCode() : 0);
        result = 31 * result + (paynofc != null ? paynofc.hashCode() : 0);
        result = 31 * result + pmtpcty;
        result = 31 * result + pmtpctn;
        result = 31 * result + pmtpctf;
        result = 31 * result + pmtpctt;
        result = 31 * result + pmtpcth;
        result = 31 * result + pmtpctl;
        result = 31 * result + pmtpctb;
        result = 31 * result + (eqtytyp != null ? eqtytyp.hashCode() : 0);
        result = 31 * result + (pollim != null ? pollim.hashCode() : 0);
        result = 31 * result + (sartran != null ? sartran.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (sitime != null ? sitime.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + lnseq;
        result = 31 * result + pnseq;
        result = 31 * result + (dclaid != null ? dclaid.hashCode() : 0);
        result = 31 * result + (mfid != null ? mfid.hashCode() : 0);
        result = 31 * result + (chrtact != null ? chrtact.hashCode() : 0);
        result = 31 * result + (usercd5 != null ? usercd5.hashCode() : 0);
        result = 31 * result + (usercd6 != null ? usercd6.hashCode() : 0);
        result = 31 * result + (usercd7 != null ? usercd7.hashCode() : 0);
        result = 31 * result + (usercd8 != null ? usercd8.hashCode() : 0);
        result = 31 * result + (begdtc != null ? begdtc.hashCode() : 0);
        result = 31 * result + (enddtec != null ? enddtec.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (amtdecl != null ? amtdecl.hashCode() : 0);
        result = 31 * result + nrdecl;
        result = 31 * result + (hrstype != null ? hrstype.hashCode() : 0);
        result = 31 * result + (disbstd != null ? disbstd.hashCode() : 0);
        result = 31 * result + (awdctl != null ? awdctl.hashCode() : 0);
        result = 31 * result + (pmltyp != null ? pmltyp.hashCode() : 0);
        result = 31 * result + (rulecon != null ? rulecon.hashCode() : 0);
        result = 31 * result + (doccon != null ? doccon.hashCode() : 0);
        result = 31 * result + (pcttype != null ? pcttype.hashCode() : 0);
        result = 31 * result + pckperc;
        result = 31 * result + (webctrl != null ? webctrl.hashCode() : 0);
        result = 31 * result + (postctl != null ? postctl.hashCode() : 0);
        result = 31 * result + (dsbhld != null ? dsbhld.hashCode() : 0);
        result = 31 * result + (frzpaid != null ? frzpaid.hashCode() : 0);
        result = 31 * result + (ahrstyp != null ? ahrstyp.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + manptm;
        result = 31 * result + (fiscyr != null ? fiscyr.hashCode() : 0);
        result = 31 * result + (defexpt != null ? defexpt.hashCode() : 0);
        result = 31 * result + (aschtyp != null ? aschtyp.hashCode() : 0);
        result = 31 * result + (actnum != null ? actnum.hashCode() : 0);
        return result;
    }
}
