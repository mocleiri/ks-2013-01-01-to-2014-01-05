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
 * Time: 12:04 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNF", schema = "SIGMA", catalog = "")
@Entity
public class SnfEntity implements Identifiable {

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

    private String crttime;

    @javax.persistence.Column(name = "CRTTIME")
    @Basic
    public String getCrttime() {
        return crttime;
    }

    public void setCrttime(String crttime) {
        this.crttime = crttime;
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

    private int revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public int getRevlev() {
        return revlev;
    }

    public void setRevlev(int revlev) {
        this.revlev = revlev;
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

    private String pgsid;

    @javax.persistence.Column(name = "PGSID")
    @Basic
    public String getPgsid() {
        return pgsid;
    }

    public void setPgsid(String pgsid) {
        this.pgsid = pgsid;
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

    private int fpin;

    @javax.persistence.Column(name = "FPIN")
    @Basic
    public int getFpin() {
        return fpin;
    }

    public void setFpin(int fpin) {
        this.fpin = fpin;
    }

    private String snamel;

    @javax.persistence.Column(name = "SNAMEL")
    @Basic
    public String getSnamel() {
        return snamel;
    }

    public void setSnamel(String snamel) {
        this.snamel = snamel;
    }

    private String snamef;

    @javax.persistence.Column(name = "SNAMEF")
    @Basic
    public String getSnamef() {
        return snamef;
    }

    public void setSnamef(String snamef) {
        this.snamef = snamef;
    }

    private String snamei;

    @javax.persistence.Column(name = "SNAMEI")
    @Basic
    public String getSnamei() {
        return snamei;
    }

    public void setSnamei(String snamei) {
        this.snamei = snamei;
    }

    private String fsaddr;

    @javax.persistence.Column(name = "FSADDR")
    @Basic
    public String getFsaddr() {
        return fsaddr;
    }

    public void setFsaddr(String fsaddr) {
        this.fsaddr = fsaddr;
    }

    private String fscity;

    @javax.persistence.Column(name = "FSCITY")
    @Basic
    public String getFscity() {
        return fscity;
    }

    public void setFscity(String fscity) {
        this.fscity = fscity;
    }

    private String fsstate;

    @javax.persistence.Column(name = "FSSTATE")
    @Basic
    public String getFsstate() {
        return fsstate;
    }

    public void setFsstate(String fsstate) {
        this.fsstate = fsstate;
    }

    private String fszip;

    @javax.persistence.Column(name = "FSZIP")
    @Basic
    public String getFszip() {
        return fszip;
    }

    public void setFszip(String fszip) {
        this.fszip = fszip;
    }

    private String fsphone;

    @javax.persistence.Column(name = "FSPHONE")
    @Basic
    public String getFsphone() {
        return fsphone;
    }

    public void setFsphone(String fsphone) {
        this.fsphone = fsphone;
    }

    private String fsnumdl;

    @javax.persistence.Column(name = "FSNUMDL")
    @Basic
    public String getFsnumdl() {
        return fsnumdl;
    }

    public void setFsnumdl(String fsnumdl) {
        this.fsnumdl = fsnumdl;
    }

    private String fsstdl;

    @javax.persistence.Column(name = "FSSTDL")
    @Basic
    public String getFsstdl() {
        return fsstdl;
    }

    public void setFsstdl(String fsstdl) {
        this.fsstdl = fsstdl;
    }

    private String fincud0;

    @javax.persistence.Column(name = "FINCUD0")
    @Basic
    public String getFincud0() {
        return fincud0;
    }

    public void setFincud0(String fincud0) {
        this.fincud0 = fincud0;
    }

    private String fincud1;

    @javax.persistence.Column(name = "FINCUD1")
    @Basic
    public String getFincud1() {
        return fincud1;
    }

    public void setFincud1(String fincud1) {
        this.fincud1 = fincud1;
    }

    private String fincudx;

    @javax.persistence.Column(name = "FINCUDX")
    @Basic
    public String getFincudx() {
        return fincudx;
    }

    public void setFincudx(String fincudx) {
        this.fincudx = fincudx;
    }

    private String fincud2;

    @javax.persistence.Column(name = "FINCUD2")
    @Basic
    public String getFincud2() {
        return fincud2;
    }

    public void setFincud2(String fincud2) {
        this.fincud2 = fincud2;
    }

    private String fincud3;

    @javax.persistence.Column(name = "FINCUD3")
    @Basic
    public String getFincud3() {
        return fincud3;
    }

    public void setFincud3(String fincud3) {
        this.fincud3 = fincud3;
    }

    private String fresgt3C;

    @javax.persistence.Column(name = "FRESGT3C")
    @Basic
    public String getFresgt3C() {
        return fresgt3C;
    }

    public void setFresgt3C(String fresgt3C) {
        this.fresgt3C = fresgt3C;
    }

    private String fresgt4C;

    @javax.persistence.Column(name = "FRESGT4C")
    @Basic
    public String getFresgt4C() {
        return fresgt4C;
    }

    public void setFresgt4C(String fresgt4C) {
        this.fresgt4C = fresgt4C;
    }

    private String fresgt4D;

    @javax.persistence.Column(name = "FRESGT4D")
    @Basic
    public String getFresgt4D() {
        return fresgt4D;
    }

    public void setFresgt4D(String fresgt4D) {
        this.fresgt4D = fresgt4D;
    }

    private String fresgt5D;

    @javax.persistence.Column(name = "FRESGT5D")
    @Basic
    public String getFresgt5D() {
        return fresgt5D;
    }

    public void setFresgt5D(String fresgt5D) {
        this.fresgt5D = fresgt5D;
    }

    private String fresgt5E;

    @javax.persistence.Column(name = "FRESGT5E")
    @Basic
    public String getFresgt5E() {
        return fresgt5E;
    }

    public void setFresgt5E(String fresgt5E) {
        this.fresgt5E = fresgt5E;
    }

    private String fresgt6E;

    @javax.persistence.Column(name = "FRESGT6E")
    @Basic
    public String getFresgt6E() {
        return fresgt6E;
    }

    public void setFresgt6E(String fresgt6E) {
        this.fresgt6E = fresgt6E;
    }

    private String fresgt6F;

    @javax.persistence.Column(name = "FRESGT6F")
    @Basic
    public String getFresgt6F() {
        return fresgt6F;
    }

    public void setFresgt6F(String fresgt6F) {
        this.fresgt6F = fresgt6F;
    }

    private String fresgt7F;

    @javax.persistence.Column(name = "FRESGT7F")
    @Basic
    public String getFresgt7F() {
        return fresgt7F;
    }

    public void setFresgt7F(String fresgt7F) {
        this.fresgt7F = fresgt7F;
    }

    private String fborn0;

    @javax.persistence.Column(name = "FBORN0")
    @Basic
    public String getFborn0() {
        return fborn0;
    }

    public void setFborn0(String fborn0) {
        this.fborn0 = fborn0;
    }

    private String fsvet;

    @javax.persistence.Column(name = "FSVET")
    @Basic
    public String getFsvet() {
        return fsvet;
    }

    public void setFsvet(String fsvet) {
        this.fsvet = fsvet;
    }

    private String forphwd;

    @javax.persistence.Column(name = "FORPHWD")
    @Basic
    public String getForphwd() {
        return forphwd;
    }

    public void setForphwd(String forphwd) {
        this.forphwd = forphwd;
    }

    private String flgldep;

    @javax.persistence.Column(name = "FLGLDEP")
    @Basic
    public String getFlgldep() {
        return flgldep;
    }

    public void setFlgldep(String flgldep) {
        this.flgldep = flgldep;
    }

    private String fexemp3;

    @javax.persistence.Column(name = "FEXEMP3")
    @Basic
    public String getFexemp3() {
        return fexemp3;
    }

    public void setFexemp3(String fexemp3) {
        this.fexemp3 = fexemp3;
    }

    private String fexemp2;

    @javax.persistence.Column(name = "FEXEMP2")
    @Basic
    public String getFexemp2() {
        return fexemp2;
    }

    public void setFexemp2(String fexemp2) {
        this.fexemp2 = fexemp2;
    }

    private String fexemp1;

    @javax.persistence.Column(name = "FEXEMP1")
    @Basic
    public String getFexemp1() {
        return fexemp1;
    }

    public void setFexemp1(String fexemp1) {
        this.fexemp1 = fexemp1;
    }

    private String fexemp0;

    @javax.persistence.Column(name = "FEXEMP0")
    @Basic
    public String getFexemp0() {
        return fexemp0;
    }

    public void setFexemp0(String fexemp0) {
        this.fexemp0 = fexemp0;
    }

    private String ffedad1;

    @javax.persistence.Column(name = "FFEDAD1")
    @Basic
    public String getFfedad1() {
        return ffedad1;
    }

    public void setFfedad1(String ffedad1) {
        this.ffedad1 = ffedad1;
    }

    private String frqadefc;

    @javax.persistence.Column(name = "FRQADEFC")
    @Basic
    public String getFrqadefc() {
        return frqadefc;
    }

    public void setFrqadefc(String frqadefc) {
        this.frqadefc = frqadefc;
    }

    private String fsccaren;

    @javax.persistence.Column(name = "FSCCAREN")
    @Basic
    public String getFsccaren() {
        return fsccaren;
    }

    public void setFsccaren(String fsccaren) {
        this.fsccaren = fsccaren;
    }

    private String fsres;

    @javax.persistence.Column(name = "FSRES")
    @Basic
    public String getFsres() {
        return fsres;
    }

    public void setFsres(String fsres) {
        this.fsres = fsres;
    }

    private String fsssn;

    @javax.persistence.Column(name = "FSSSN")
    @Basic
    public String getFsssn() {
        return fsssn;
    }

    public void setFsssn(String fsssn) {
        this.fsssn = fsssn;
    }

    private String fscitzn;

    @javax.persistence.Column(name = "FSCITZN")
    @Basic
    public String getFscitzn() {
        return fscitzn;
    }

    public void setFscitzn(String fscitzn) {
        this.fscitzn = fscitzn;
    }

    private String fsalnr;

    @javax.persistence.Column(name = "FSALNR")
    @Basic
    public String getFsalnr() {
        return fsalnr;
    }

    public void setFsalnr(String fsalnr) {
        this.fsalnr = fsalnr;
    }

    private String fsmartl;

    @javax.persistence.Column(name = "FSMARTL")
    @Basic
    public String getFsmartl() {
        return fsmartl;
    }

    public void setFsmartl(String fsmartl) {
        this.fsmartl = fsmartl;
    }

    private String fsyrinc;

    @javax.persistence.Column(name = "FSYRINC")
    @Basic
    public String getFsyrinc() {
        return fsyrinc;
    }

    public void setFsyrinc(String fsyrinc) {
        this.fsyrinc = fsyrinc;
    }

    private String fpdeg;

    @javax.persistence.Column(name = "FPDEG")
    @Basic
    public String getFpdeg() {
        return fpdeg;
    }

    public void setFpdeg(String fpdeg) {
        this.fpdeg = fpdeg;
    }

    private String fdegobj;

    @javax.persistence.Column(name = "FDEGOBJ")
    @Basic
    public String getFdegobj() {
        return fdegobj;
    }

    public void setFdegobj(String fdegobj) {
        this.fdegobj = fdegobj;
    }

    private String fsenrsum;

    @javax.persistence.Column(name = "FSENRSUM")
    @Basic
    public String getFsenrsum() {
        return fsenrsum;
    }

    public void setFsenrsum(String fsenrsum) {
        this.fsenrsum = fsenrsum;
    }

    private String fsenrfal;

    @javax.persistence.Column(name = "FSENRFAL")
    @Basic
    public String getFsenrfal() {
        return fsenrfal;
    }

    public void setFsenrfal(String fsenrfal) {
        this.fsenrfal = fsenrfal;
    }

    private String fsenrwin;

    @javax.persistence.Column(name = "FSENRWIN")
    @Basic
    public String getFsenrwin() {
        return fsenrwin;
    }

    public void setFsenrwin(String fsenrwin) {
        this.fsenrwin = fsenrwin;
    }

    private String fsenrspr;

    @javax.persistence.Column(name = "FSENRSPR")
    @Basic
    public String getFsenrspr() {
        return fsenrspr;
    }

    public void setFsenrspr(String fsenrspr) {
        this.fsenrspr = fsenrspr;
    }

    private int fpprssn;

    @javax.persistence.Column(name = "FPPRSSN")
    @Basic
    public int getFpprssn() {
        return fpprssn;
    }

    public void setFpprssn(int fpprssn) {
        this.fpprssn = fpprssn;
    }

    private int fpprein;

    @javax.persistence.Column(name = "FPPREIN")
    @Basic
    public int getFpprein() {
        return fpprein;
    }

    public void setFpprein(int fpprein) {
        this.fpprein = fpprein;
    }

    private String fpprsig;

    @javax.persistence.Column(name = "FPPRSIG")
    @Basic
    public String getFpprsig() {
        return fpprsig;
    }

    public void setFpprsig(String fpprsig) {
        this.fpprsig = fpprsig;
    }

    private int fstotstf;

    @javax.persistence.Column(name = "FSTOTSTF")
    @Basic
    public int getFstotstf() {
        return fstotstf;
    }

    public void setFstotstf(int fstotstf) {
        this.fstotstf = fstotstf;
    }

    private int fsrctstf;

    @javax.persistence.Column(name = "FSRCTSTF")
    @Basic
    public int getFsrctstf() {
        return fsrctstf;
    }

    public void setFsrctstf(int fsrctstf) {
        this.fsrctstf = fsrctstf;
    }

    private String fsintstf;

    @javax.persistence.Column(name = "FSINTSTF")
    @Basic
    public String getFsintstf() {
        return fsintstf;
    }

    public void setFsintstf(String fsintstf) {
        this.fsintstf = fsintstf;
    }

    private int fsasttx;

    @javax.persistence.Column(name = "FSASTTX")
    @Basic
    public int getFsasttx() {
        return fsasttx;
    }

    public void setFsasttx(int fsasttx) {
        this.fsasttx = fsasttx;
    }

    private String finsflag;

    @javax.persistence.Column(name = "FINSFLAG")
    @Basic
    public String getFinsflag() {
        return finsflag;
    }

    public void setFinsflag(String finsflag) {
        this.finsflag = finsflag;
    }

    private BigInteger fsszhhd;

    @javax.persistence.Column(name = "FSSZHHD")
    @Basic
    public BigInteger getFsszhhd() {
        return fsszhhd;
    }

    public void setFsszhhd(BigInteger fsszhhd) {
        this.fsszhhd = fsszhhd;
    }

    private BigInteger fsnrps;

    @javax.persistence.Column(name = "FSNRPS")
    @Basic
    public BigInteger getFsnrps() {
        return fsnrps;
    }

    public void setFsnrps(BigInteger fsnrps) {
        this.fsnrps = fsnrps;
    }

    private String fstrfil;

    @javax.persistence.Column(name = "FSTRFIL")
    @Basic
    public String getFstrfil() {
        return fstrfil;
    }

    public void setFstrfil(String fstrfil) {
        this.fstrfil = fstrfil;
    }

    private BigInteger fsexemp;

    @javax.persistence.Column(name = "FSEXEMP")
    @Basic
    public BigInteger getFsexemp() {
        return fsexemp;
    }

    public void setFsexemp(BigInteger fsexemp) {
        this.fsexemp = fsexemp;
    }

    private int fsaagi;

    @javax.persistence.Column(name = "FSAAGI")
    @Basic
    public int getFsaagi() {
        return fsaagi;
    }

    public void setFsaagi(int fsaagi) {
        this.fsaagi = fsaagi;
    }

    private int fsaitx;

    @javax.persistence.Column(name = "FSAITX")
    @Basic
    public int getFsaitx() {
        return fsaitx;
    }

    public void setFsaitx(int fsaitx) {
        this.fsaitx = fsaitx;
    }

    private int fsaded;

    @javax.persistence.Column(name = "FSADED")
    @Basic
    public int getFsaded() {
        return fsaded;
    }

    public void setFsaded(int fsaded) {
        this.fsaded = fsaded;
    }

    private int fsawag;

    @javax.persistence.Column(name = "FSAWAG")
    @Basic
    public int getFsawag() {
        return fsawag;
    }

    public void setFsawag(int fsawag) {
        this.fsawag = fsawag;
    }

    private int fsaspsw;

    @javax.persistence.Column(name = "FSASPSW")
    @Basic
    public int getFsaspsw() {
        return fsaspsw;
    }

    public void setFsaspsw(int fsaspsw) {
        this.fsaspsw = fsaspsw;
    }

    private int fsass;

    @javax.persistence.Column(name = "FSASS")
    @Basic
    public int getFsass() {
        return fsass;
    }

    public void setFsass(int fsass) {
        this.fsass = fsass;
    }

    private int fsaadc;

    @javax.persistence.Column(name = "FSAADC")
    @Basic
    public int getFsaadc() {
        return fsaadc;
    }

    public void setFsaadc(int fsaadc) {
        this.fsaadc = fsaadc;
    }

    private int fsacs;

    @javax.persistence.Column(name = "FSACS")
    @Basic
    public int getFsacs() {
        return fsacs;
    }

    public void setFsacs(int fsacs) {
        this.fsacs = fsacs;
    }

    private int fsaonti;

    @javax.persistence.Column(name = "FSAONTI")
    @Basic
    public int getFsaonti() {
        return fsaonti;
    }

    public void setFsaonti(int fsaonti) {
        this.fsaonti = fsaonti;
    }

    private int fsamed;

    @javax.persistence.Column(name = "FSAMED")
    @Basic
    public int getFsamed() {
        return fsamed;
    }

    public void setFsamed(int fsamed) {
        this.fsamed = fsamed;
    }

    private int fsameda;

    @javax.persistence.Column(name = "FSAMEDA")
    @Basic
    public int getFsameda() {
        return fsameda;
    }

    public void setFsameda(int fsameda) {
        this.fsameda = fsameda;
    }

    private int fsatuit;

    @javax.persistence.Column(name = "FSATUIT")
    @Basic
    public int getFsatuit() {
        return fsatuit;
    }

    public void setFsatuit(int fsatuit) {
        this.fsatuit = fsatuit;
    }

    private BigInteger fsntuit;

    @javax.persistence.Column(name = "FSNTUIT")
    @Basic
    public BigInteger getFsntuit() {
        return fsntuit;
    }

    public void setFsntuit(BigInteger fsntuit) {
        this.fsntuit = fsntuit;
    }

    private int fsatuta;

    @javax.persistence.Column(name = "FSATUTA")
    @Basic
    public int getFsatuta() {
        return fsatuta;
    }

    public void setFsatuta(int fsatuta) {
        this.fsatuta = fsatuta;
    }

    private int fsagim;

    @javax.persistence.Column(name = "FSAGIM")
    @Basic
    public int getFsagim() {
        return fsagim;
    }

    public void setFsagim(int fsagim) {
        this.fsagim = fsagim;
    }

    private int fsagia;

    @javax.persistence.Column(name = "FSAGIA")
    @Basic
    public int getFsagia() {
        return fsagia;
    }

    public void setFsagia(int fsagia) {
        this.fsagia = fsagia;
    }

    private int fsagi;

    @javax.persistence.Column(name = "FSAGI")
    @Basic
    public int getFsagi() {
        return fsagi;
    }

    public void setFsagi(int fsagi) {
        this.fsagi = fsagi;
    }

    private int fsavcm;

    @javax.persistence.Column(name = "FSAVCM")
    @Basic
    public int getFsavcm() {
        return fsavcm;
    }

    public void setFsavcm(int fsavcm) {
        this.fsavcm = fsavcm;
    }

    private int fsavca;

    @javax.persistence.Column(name = "FSAVCA")
    @Basic
    public int getFsavca() {
        return fsavca;
    }

    public void setFsavca(int fsavca) {
        this.fsavca = fsavca;
    }

    private int fsavc;

    @javax.persistence.Column(name = "FSAVC")
    @Basic
    public int getFsavc() {
        return fsavc;
    }

    public void setFsavc(int fsavc) {
        this.fsavc = fsavc;
    }

    private String fsdiswk;

    @javax.persistence.Column(name = "FSDISWK")
    @Basic
    public String getFsdiswk() {
        return fsdiswk;
    }

    public void setFsdiswk(String fsdiswk) {
        this.fsdiswk = fsdiswk;
    }

    private String fsdishm;

    @javax.persistence.Column(name = "FSDISHM")
    @Basic
    public String getFsdishm() {
        return fsdishm;
    }

    public void setFsdishm(String fsdishm) {
        this.fsdishm = fsdishm;
    }

    private int fsdwag;

    @javax.persistence.Column(name = "FSDWAG")
    @Basic
    public int getFsdwag() {
        return fsdwag;
    }

    public void setFsdwag(int fsdwag) {
        this.fsdwag = fsdwag;
    }

    private int fsdspsw;

    @javax.persistence.Column(name = "FSDSPSW")
    @Basic
    public int getFsdspsw() {
        return fsdspsw;
    }

    public void setFsdspsw(int fsdspsw) {
        this.fsdspsw = fsdspsw;
    }

    private int fsdoti;

    @javax.persistence.Column(name = "FSDOTI")
    @Basic
    public int getFsdoti() {
        return fsdoti;
    }

    public void setFsdoti(int fsdoti) {
        this.fsdoti = fsdoti;
    }

    private int fsdonti;

    @javax.persistence.Column(name = "FSDONTI")
    @Basic
    public int getFsdonti() {
        return fsdonti;
    }

    public void setFsdonti(int fsdonti) {
        this.fsdonti = fsdonti;
    }

    private BigInteger fsage;

    @javax.persistence.Column(name = "FSAGE")
    @Basic
    public BigInteger getFsage() {
        return fsage;
    }

    public void setFsage(BigInteger fsage) {
        this.fsage = fsage;
    }

    private int fscash;

    @javax.persistence.Column(name = "FSCASH")
    @Basic
    public int getFscash() {
        return fscash;
    }

    public void setFscash(int fscash) {
        this.fscash = fscash;
    }

    private int fshomv;

    @javax.persistence.Column(name = "FSHOMV")
    @Basic
    public int getFshomv() {
        return fshomv;
    }

    public void setFshomv(int fshomv) {
        this.fshomv = fshomv;
    }

    private int fshomd;

    @javax.persistence.Column(name = "FSHOMD")
    @Basic
    public int getFshomd() {
        return fshomd;
    }

    public void setFshomd(int fshomd) {
        this.fshomd = fshomd;
    }

    private int fsfarmv;

    @javax.persistence.Column(name = "FSFARMV")
    @Basic
    public int getFsfarmv() {
        return fsfarmv;
    }

    public void setFsfarmv(int fsfarmv) {
        this.fsfarmv = fsfarmv;
    }

    private int fsfarmd;

    @javax.persistence.Column(name = "FSFARMD")
    @Basic
    public int getFsfarmd() {
        return fsfarmd;
    }

    public void setFsfarmd(int fsfarmd) {
        this.fsfarmd = fsfarmd;
    }

    private int fsoriv;

    @javax.persistence.Column(name = "FSORIV")
    @Basic
    public int getFsoriv() {
        return fsoriv;
    }

    public void setFsoriv(int fsoriv) {
        this.fsoriv = fsoriv;
    }

    private int fsorid;

    @javax.persistence.Column(name = "FSORID")
    @Basic
    public int getFsorid() {
        return fsorid;
    }

    public void setFsorid(int fsorid) {
        this.fsorid = fsorid;
    }

    private int fsbfv;

    @javax.persistence.Column(name = "FSBFV")
    @Basic
    public int getFsbfv() {
        return fsbfv;
    }

    public void setFsbfv(int fsbfv) {
        this.fsbfv = fsbfv;
    }

    private int fsbfd;

    @javax.persistence.Column(name = "FSBFD")
    @Basic
    public int getFsbfd() {
        return fsbfd;
    }

    public void setFsbfd(int fsbfd) {
        this.fsbfd = fsbfd;
    }

    private String fsfarm;

    @javax.persistence.Column(name = "FSFARM")
    @Basic
    public String getFsfarm() {
        return fsfarm;
    }

    public void setFsfarm(String fsfarm) {
        this.fsfarm = fsfarm;
    }

    private String fcampus;

    @javax.persistence.Column(name = "FCAMPUS")
    @Basic
    public String getFcampus() {
        return fcampus;
    }

    public void setFcampus(String fcampus) {
        this.fcampus = fcampus;
    }

    private String fcampus1;

    @javax.persistence.Column(name = "FCAMPUS1")
    @Basic
    public String getFcampus1() {
        return fcampus1;
    }

    public void setFcampus1(String fcampus1) {
        this.fcampus1 = fcampus1;
    }

    private String fcampus2;

    @javax.persistence.Column(name = "FCAMPUS2")
    @Basic
    public String getFcampus2() {
        return fcampus2;
    }

    public void setFcampus2(String fcampus2) {
        this.fcampus2 = fcampus2;
    }

    private String fcampus3;

    @javax.persistence.Column(name = "FCAMPUS3")
    @Basic
    public String getFcampus3() {
        return fcampus3;
    }

    public void setFcampus3(String fcampus3) {
        this.fcampus3 = fcampus3;
    }

    private String fcampus4;

    @javax.persistence.Column(name = "FCAMPUS4")
    @Basic
    public String getFcampus4() {
        return fcampus4;
    }

    public void setFcampus4(String fcampus4) {
        this.fcampus4 = fcampus4;
    }

    private String fcampus5;

    @javax.persistence.Column(name = "FCAMPUS5")
    @Basic
    public String getFcampus5() {
        return fcampus5;
    }

    public void setFcampus5(String fcampus5) {
        this.fcampus5 = fcampus5;
    }

    private String fcampus6;

    @javax.persistence.Column(name = "FCAMPUS6")
    @Basic
    public String getFcampus6() {
        return fcampus6;
    }

    public void setFcampus6(String fcampus6) {
        this.fcampus6 = fcampus6;
    }

    private String frelfed;

    @javax.persistence.Column(name = "FRELFED")
    @Basic
    public String getFrelfed() {
        return frelfed;
    }

    public void setFrelfed(String frelfed) {
        this.frelfed = frelfed;
    }

    private String frelst;

    @javax.persistence.Column(name = "FRELST")
    @Basic
    public String getFrelst() {
        return frelst;
    }

    public void setFrelst(String frelst) {
        this.frelst = frelst;
    }

    private String frlinst;

    @javax.persistence.Column(name = "FRLINST")
    @Basic
    public String getFrlinst() {
        return frlinst;
    }

    public void setFrlinst(String frlinst) {
        this.frlinst = frlinst;
    }

    private String fsigs;

    @javax.persistence.Column(name = "FSIGS")
    @Basic
    public String getFsigs() {
        return fsigs;
    }

    public void setFsigs(String fsigs) {
        this.fsigs = fsigs;
    }

    private String fsigsp;

    @javax.persistence.Column(name = "FSIGSP")
    @Basic
    public String getFsigsp() {
        return fsigsp;
    }

    public void setFsigsp(String fsigsp) {
        this.fsigsp = fsigsp;
    }

    private String fsigf;

    @javax.persistence.Column(name = "FSIGF")
    @Basic
    public String getFsigf() {
        return fsigf;
    }

    public void setFsigf(String fsigf) {
        this.fsigf = fsigf;
    }

    private String fsigm;

    @javax.persistence.Column(name = "FSIGM")
    @Basic
    public String getFsigm() {
        return fsigm;
    }

    public void setFsigm(String fsigm) {
        this.fsigm = fsigm;
    }

    private String fselsrv;

    @javax.persistence.Column(name = "FSELSRV")
    @Basic
    public String getFselsrv() {
        return fselsrv;
    }

    public void setFselsrv(String fselsrv) {
        this.fselsrv = fselsrv;
    }

    private String fselsrvm;

    @javax.persistence.Column(name = "FSELSRVM")
    @Basic
    public String getFselsrvm() {
        return fselsrvm;
    }

    public void setFselsrvm(String fselsrvm) {
        this.fselsrvm = fselsrvm;
    }

    private int fsavom;

    @javax.persistence.Column(name = "FSAVOM")
    @Basic
    public int getFsavom() {
        return fsavom;
    }

    public void setFsavom(int fsavom) {
        this.fsavom = fsavom;
    }

    private int fsavoa;

    @javax.persistence.Column(name = "FSAVOA")
    @Basic
    public int getFsavoa() {
        return fsavoa;
    }

    public void setFsavoa(int fsavoa) {
        this.fsavoa = fsavoa;
    }

    private int fsavo;

    @javax.persistence.Column(name = "FSAVO")
    @Basic
    public int getFsavo() {
        return fsavo;
    }

    public void setFsavo(int fsavo) {
        this.fsavo = fsavo;
    }

    private String fssflag;

    @javax.persistence.Column(name = "FSSFLAG")
    @Basic
    public String getFssflag() {
        return fssflag;
    }

    public void setFssflag(String fssflag) {
        this.fssflag = fssflag;
    }

    private String fdepstf;

    @javax.persistence.Column(name = "FDEPSTF")
    @Basic
    public String getFdepstf() {
        return fdepstf;
    }

    public void setFdepstf(String fdepstf) {
        this.fdepstf = fdepstf;
    }

    private int fsafi;

    @javax.persistence.Column(name = "FSAFI")
    @Basic
    public int getFsafi() {
        return fsafi;
    }

    public void setFsafi(int fsafi) {
        this.fsafi = fsafi;
    }

    private int fsefi;

    @javax.persistence.Column(name = "FSEFI")
    @Basic
    public int getFsefi() {
        return fsefi;
    }

    public void setFsefi(int fsefi) {
        this.fsefi = fsefi;
    }

    private int fsfso;

    @javax.persistence.Column(name = "FSFSO")
    @Basic
    public int getFsfso() {
        return fsfso;
    }

    public void setFsfso(int fsfso) {
        this.fsfso = fsfso;
    }

    private int fseea;

    @javax.persistence.Column(name = "FSEEA")
    @Basic
    public int getFseea() {
        return fseea;
    }

    public void setFseea(int fseea) {
        this.fseea = fseea;
    }

    private int fsdfi;

    @javax.persistence.Column(name = "FSDFI")
    @Basic
    public int getFsdfi() {
        return fsdfi;
    }

    public void setFsdfi(int fsdfi) {
        this.fsdfi = fsdfi;
    }

    private int fspconi;

    @javax.persistence.Column(name = "FSPCONI")
    @Basic
    public int getFspconi() {
        return fspconi;
    }

    public void setFspconi(int fspconi) {
        this.fspconi = fspconi;
    }

    private int fshar;

    @javax.persistence.Column(name = "FSHAR")
    @Basic
    public int getFshar() {
        return fshar;
    }

    public void setFshar(int fshar) {
        this.fshar = fshar;
    }

    private int fsoar;

    @javax.persistence.Column(name = "FSOAR")
    @Basic
    public int getFsoar() {
        return fsoar;
    }

    public void setFsoar(int fsoar) {
        this.fsoar = fsoar;
    }

    private int fsbar;

    @javax.persistence.Column(name = "FSBAR")
    @Basic
    public int getFsbar() {
        return fsbar;
    }

    public void setFsbar(int fsbar) {
        this.fsbar = fsbar;
    }

    private int fspca;

    @javax.persistence.Column(name = "FSPCA")
    @Basic
    public int getFspca() {
        return fspca;
    }

    public void setFspca(int fspca) {
        this.fspca = fspca;
    }

    private int fstpc;

    @javax.persistence.Column(name = "FSTPC")
    @Basic
    public int getFstpc() {
        return fstpc;
    }

    public void setFstpc(int fstpc) {
        this.fstpc = fstpc;
    }

    private int fsapc;

    @javax.persistence.Column(name = "FSAPC")
    @Basic
    public int getFsapc() {
        return fsapc;
    }

    public void setFsapc(int fsapc) {
        this.fsapc = fsapc;
    }

    private int fsai;

    @javax.persistence.Column(name = "FSAI")
    @Basic
    public int getFsai() {
        return fsai;
    }

    public void setFsai(int fsai) {
        this.fsai = fsai;
    }

    private String frvwini;

    @javax.persistence.Column(name = "FRVWINI")
    @Basic
    public String getFrvwini() {
        return frvwini;
    }

    public void setFrvwini(String frvwini) {
        this.frvwini = frvwini;
    }

    private int fsditx;

    @javax.persistence.Column(name = "FSDITX")
    @Basic
    public int getFsditx() {
        return fsditx;
    }

    public void setFsditx(int fsditx) {
        this.fsditx = fsditx;
    }

    private int fsdgi;

    @javax.persistence.Column(name = "FSDGI")
    @Basic
    public int getFsdgi() {
        return fsdgi;
    }

    public void setFsdgi(int fsdgi) {
        this.fsdgi = fsdgi;
    }

    private int fsdsttx;

    @javax.persistence.Column(name = "FSDSTTX")
    @Basic
    public int getFsdsttx() {
        return fsdsttx;
    }

    public void setFsdsttx(int fsdsttx) {
        this.fsdsttx = fsdsttx;
    }

    private int fsdmeda;

    @javax.persistence.Column(name = "FSDMEDA")
    @Basic
    public int getFsdmeda() {
        return fsdmeda;
    }

    public void setFsdmeda(int fsdmeda) {
        this.fsdmeda = fsdmeda;
    }

    private int fsdtuta;

    @javax.persistence.Column(name = "FSDTUTA")
    @Basic
    public int getFsdtuta() {
        return fsdtuta;
    }

    public void setFsdtuta(int fsdtuta) {
        this.fsdtuta = fsdtuta;
    }

    private int fsdea;

    @javax.persistence.Column(name = "FSDEA")
    @Basic
    public int getFsdea() {
        return fsdea;
    }

    public void setFsdea(int fsdea) {
        this.fsdea = fsdea;
    }

    private int fsdfso;

    @javax.persistence.Column(name = "FSDFSO")
    @Basic
    public int getFsdfso() {
        return fsdfso;
    }

    public void setFsdfso(int fsdfso) {
        this.fsdfso = fsdfso;
    }

    private int fshome;

    @javax.persistence.Column(name = "FSHOME")
    @Basic
    public int getFshome() {
        return fshome;
    }

    public void setFshome(int fshome) {
        this.fshome = fshome;
    }

    private int fsorie;

    @javax.persistence.Column(name = "FSORIE")
    @Basic
    public int getFsorie() {
        return fsorie;
    }

    public void setFsorie(int fsorie) {
        this.fsorie = fsorie;
    }

    private int fsatti;

    @javax.persistence.Column(name = "FSATTI")
    @Basic
    public int getFsatti() {
        return fsatti;
    }

    public void setFsatti(int fsatti) {
        this.fsatti = fsatti;
    }

    private int fsddfi;

    @javax.persistence.Column(name = "FSDDFI")
    @Basic
    public int getFsddfi() {
        return fsddfi;
    }

    public void setFsddfi(int fsddfi) {
        this.fsddfi = fsddfi;
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

        SnfEntity snfEntity = (SnfEntity) o;

        if (fpin != snfEntity.fpin) return false;
        if (fpprein != snfEntity.fpprein) return false;
        if (fpprssn != snfEntity.fpprssn) return false;
        if (fsaadc != snfEntity.fsaadc) return false;
        if (fsaagi != snfEntity.fsaagi) return false;
        if (fsacs != snfEntity.fsacs) return false;
        if (fsaded != snfEntity.fsaded) return false;
        if (fsafi != snfEntity.fsafi) return false;
        if (fsagi != snfEntity.fsagi) return false;
        if (fsagia != snfEntity.fsagia) return false;
        if (fsagim != snfEntity.fsagim) return false;
        if (fsai != snfEntity.fsai) return false;
        if (fsaitx != snfEntity.fsaitx) return false;
        if (fsamed != snfEntity.fsamed) return false;
        if (fsameda != snfEntity.fsameda) return false;
        if (fsaonti != snfEntity.fsaonti) return false;
        if (fsapc != snfEntity.fsapc) return false;
        if (fsaspsw != snfEntity.fsaspsw) return false;
        if (fsass != snfEntity.fsass) return false;
        if (fsasttx != snfEntity.fsasttx) return false;
        if (fsatti != snfEntity.fsatti) return false;
        if (fsatuit != snfEntity.fsatuit) return false;
        if (fsatuta != snfEntity.fsatuta) return false;
        if (fsavc != snfEntity.fsavc) return false;
        if (fsavca != snfEntity.fsavca) return false;
        if (fsavcm != snfEntity.fsavcm) return false;
        if (fsavo != snfEntity.fsavo) return false;
        if (fsavoa != snfEntity.fsavoa) return false;
        if (fsavom != snfEntity.fsavom) return false;
        if (fsawag != snfEntity.fsawag) return false;
        if (fsbar != snfEntity.fsbar) return false;
        if (fsbfd != snfEntity.fsbfd) return false;
        if (fsbfv != snfEntity.fsbfv) return false;
        if (fscash != snfEntity.fscash) return false;
        if (fsddfi != snfEntity.fsddfi) return false;
        if (fsdea != snfEntity.fsdea) return false;
        if (fsdfi != snfEntity.fsdfi) return false;
        if (fsdfso != snfEntity.fsdfso) return false;
        if (fsdgi != snfEntity.fsdgi) return false;
        if (fsditx != snfEntity.fsditx) return false;
        if (fsdmeda != snfEntity.fsdmeda) return false;
        if (fsdonti != snfEntity.fsdonti) return false;
        if (fsdoti != snfEntity.fsdoti) return false;
        if (fsdspsw != snfEntity.fsdspsw) return false;
        if (fsdsttx != snfEntity.fsdsttx) return false;
        if (fsdtuta != snfEntity.fsdtuta) return false;
        if (fsdwag != snfEntity.fsdwag) return false;
        if (fseea != snfEntity.fseea) return false;
        if (fsefi != snfEntity.fsefi) return false;
        if (fsfarmd != snfEntity.fsfarmd) return false;
        if (fsfarmv != snfEntity.fsfarmv) return false;
        if (fsfso != snfEntity.fsfso) return false;
        if (fshar != snfEntity.fshar) return false;
        if (fshomd != snfEntity.fshomd) return false;
        if (fshome != snfEntity.fshome) return false;
        if (fshomv != snfEntity.fshomv) return false;
        if (fsoar != snfEntity.fsoar) return false;
        if (fsorid != snfEntity.fsorid) return false;
        if (fsorie != snfEntity.fsorie) return false;
        if (fsoriv != snfEntity.fsoriv) return false;
        if (fspca != snfEntity.fspca) return false;
        if (fspconi != snfEntity.fspconi) return false;
        if (fsrctstf != snfEntity.fsrctstf) return false;
        if (fstotstf != snfEntity.fstotstf) return false;
        if (fstpc != snfEntity.fstpc) return false;
        if (revlev != snfEntity.revlev) return false;
        if (aidyr != null ? !aidyr.equals(snfEntity.aidyr) : snfEntity.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(snfEntity.cmptype) : snfEntity.cmptype != null) return false;
        if (createc != null ? !createc.equals(snfEntity.createc) : snfEntity.createc != null) return false;
        if (crttime != null ? !crttime.equals(snfEntity.crttime) : snfEntity.crttime != null) return false;
        if (fborn0 != null ? !fborn0.equals(snfEntity.fborn0) : snfEntity.fborn0 != null) return false;
        if (fcampus != null ? !fcampus.equals(snfEntity.fcampus) : snfEntity.fcampus != null) return false;
        if (fcampus1 != null ? !fcampus1.equals(snfEntity.fcampus1) : snfEntity.fcampus1 != null) return false;
        if (fcampus2 != null ? !fcampus2.equals(snfEntity.fcampus2) : snfEntity.fcampus2 != null) return false;
        if (fcampus3 != null ? !fcampus3.equals(snfEntity.fcampus3) : snfEntity.fcampus3 != null) return false;
        if (fcampus4 != null ? !fcampus4.equals(snfEntity.fcampus4) : snfEntity.fcampus4 != null) return false;
        if (fcampus5 != null ? !fcampus5.equals(snfEntity.fcampus5) : snfEntity.fcampus5 != null) return false;
        if (fcampus6 != null ? !fcampus6.equals(snfEntity.fcampus6) : snfEntity.fcampus6 != null) return false;
        if (fdegobj != null ? !fdegobj.equals(snfEntity.fdegobj) : snfEntity.fdegobj != null) return false;
        if (fdepstf != null ? !fdepstf.equals(snfEntity.fdepstf) : snfEntity.fdepstf != null) return false;
        if (fexemp0 != null ? !fexemp0.equals(snfEntity.fexemp0) : snfEntity.fexemp0 != null) return false;
        if (fexemp1 != null ? !fexemp1.equals(snfEntity.fexemp1) : snfEntity.fexemp1 != null) return false;
        if (fexemp2 != null ? !fexemp2.equals(snfEntity.fexemp2) : snfEntity.fexemp2 != null) return false;
        if (fexemp3 != null ? !fexemp3.equals(snfEntity.fexemp3) : snfEntity.fexemp3 != null) return false;
        if (ffedad1 != null ? !ffedad1.equals(snfEntity.ffedad1) : snfEntity.ffedad1 != null) return false;
        if (fincud0 != null ? !fincud0.equals(snfEntity.fincud0) : snfEntity.fincud0 != null) return false;
        if (fincud1 != null ? !fincud1.equals(snfEntity.fincud1) : snfEntity.fincud1 != null) return false;
        if (fincud2 != null ? !fincud2.equals(snfEntity.fincud2) : snfEntity.fincud2 != null) return false;
        if (fincud3 != null ? !fincud3.equals(snfEntity.fincud3) : snfEntity.fincud3 != null) return false;
        if (fincudx != null ? !fincudx.equals(snfEntity.fincudx) : snfEntity.fincudx != null) return false;
        if (finsflag != null ? !finsflag.equals(snfEntity.finsflag) : snfEntity.finsflag != null) return false;
        if (flgldep != null ? !flgldep.equals(snfEntity.flgldep) : snfEntity.flgldep != null) return false;
        if (forphwd != null ? !forphwd.equals(snfEntity.forphwd) : snfEntity.forphwd != null) return false;
        if (fpdeg != null ? !fpdeg.equals(snfEntity.fpdeg) : snfEntity.fpdeg != null) return false;
        if (fpprsig != null ? !fpprsig.equals(snfEntity.fpprsig) : snfEntity.fpprsig != null) return false;
        if (frelfed != null ? !frelfed.equals(snfEntity.frelfed) : snfEntity.frelfed != null) return false;
        if (frelst != null ? !frelst.equals(snfEntity.frelst) : snfEntity.frelst != null) return false;
        if (fresgt3C != null ? !fresgt3C.equals(snfEntity.fresgt3C) : snfEntity.fresgt3C != null) return false;
        if (fresgt4C != null ? !fresgt4C.equals(snfEntity.fresgt4C) : snfEntity.fresgt4C != null) return false;
        if (fresgt4D != null ? !fresgt4D.equals(snfEntity.fresgt4D) : snfEntity.fresgt4D != null) return false;
        if (fresgt5D != null ? !fresgt5D.equals(snfEntity.fresgt5D) : snfEntity.fresgt5D != null) return false;
        if (fresgt5E != null ? !fresgt5E.equals(snfEntity.fresgt5E) : snfEntity.fresgt5E != null) return false;
        if (fresgt6E != null ? !fresgt6E.equals(snfEntity.fresgt6E) : snfEntity.fresgt6E != null) return false;
        if (fresgt6F != null ? !fresgt6F.equals(snfEntity.fresgt6F) : snfEntity.fresgt6F != null) return false;
        if (fresgt7F != null ? !fresgt7F.equals(snfEntity.fresgt7F) : snfEntity.fresgt7F != null) return false;
        if (frlinst != null ? !frlinst.equals(snfEntity.frlinst) : snfEntity.frlinst != null) return false;
        if (frqadefc != null ? !frqadefc.equals(snfEntity.frqadefc) : snfEntity.frqadefc != null) return false;
        if (frvwini != null ? !frvwini.equals(snfEntity.frvwini) : snfEntity.frvwini != null) return false;
        if (fsaddr != null ? !fsaddr.equals(snfEntity.fsaddr) : snfEntity.fsaddr != null) return false;
        if (fsage != null ? !fsage.equals(snfEntity.fsage) : snfEntity.fsage != null) return false;
        if (fsalnr != null ? !fsalnr.equals(snfEntity.fsalnr) : snfEntity.fsalnr != null) return false;
        if (fsccaren != null ? !fsccaren.equals(snfEntity.fsccaren) : snfEntity.fsccaren != null) return false;
        if (fscity != null ? !fscity.equals(snfEntity.fscity) : snfEntity.fscity != null) return false;
        if (fscitzn != null ? !fscitzn.equals(snfEntity.fscitzn) : snfEntity.fscitzn != null) return false;
        if (fsdishm != null ? !fsdishm.equals(snfEntity.fsdishm) : snfEntity.fsdishm != null) return false;
        if (fsdiswk != null ? !fsdiswk.equals(snfEntity.fsdiswk) : snfEntity.fsdiswk != null) return false;
        if (fselsrv != null ? !fselsrv.equals(snfEntity.fselsrv) : snfEntity.fselsrv != null) return false;
        if (fselsrvm != null ? !fselsrvm.equals(snfEntity.fselsrvm) : snfEntity.fselsrvm != null) return false;
        if (fsenrfal != null ? !fsenrfal.equals(snfEntity.fsenrfal) : snfEntity.fsenrfal != null) return false;
        if (fsenrspr != null ? !fsenrspr.equals(snfEntity.fsenrspr) : snfEntity.fsenrspr != null) return false;
        if (fsenrsum != null ? !fsenrsum.equals(snfEntity.fsenrsum) : snfEntity.fsenrsum != null) return false;
        if (fsenrwin != null ? !fsenrwin.equals(snfEntity.fsenrwin) : snfEntity.fsenrwin != null) return false;
        if (fsexemp != null ? !fsexemp.equals(snfEntity.fsexemp) : snfEntity.fsexemp != null) return false;
        if (fsfarm != null ? !fsfarm.equals(snfEntity.fsfarm) : snfEntity.fsfarm != null) return false;
        if (fsigf != null ? !fsigf.equals(snfEntity.fsigf) : snfEntity.fsigf != null) return false;
        if (fsigm != null ? !fsigm.equals(snfEntity.fsigm) : snfEntity.fsigm != null) return false;
        if (fsigs != null ? !fsigs.equals(snfEntity.fsigs) : snfEntity.fsigs != null) return false;
        if (fsigsp != null ? !fsigsp.equals(snfEntity.fsigsp) : snfEntity.fsigsp != null) return false;
        if (fsintstf != null ? !fsintstf.equals(snfEntity.fsintstf) : snfEntity.fsintstf != null) return false;
        if (fsmartl != null ? !fsmartl.equals(snfEntity.fsmartl) : snfEntity.fsmartl != null) return false;
        if (fsnrps != null ? !fsnrps.equals(snfEntity.fsnrps) : snfEntity.fsnrps != null) return false;
        if (fsntuit != null ? !fsntuit.equals(snfEntity.fsntuit) : snfEntity.fsntuit != null) return false;
        if (fsnumdl != null ? !fsnumdl.equals(snfEntity.fsnumdl) : snfEntity.fsnumdl != null) return false;
        if (fsphone != null ? !fsphone.equals(snfEntity.fsphone) : snfEntity.fsphone != null) return false;
        if (fsres != null ? !fsres.equals(snfEntity.fsres) : snfEntity.fsres != null) return false;
        if (fssflag != null ? !fssflag.equals(snfEntity.fssflag) : snfEntity.fssflag != null) return false;
        if (fsssn != null ? !fsssn.equals(snfEntity.fsssn) : snfEntity.fsssn != null) return false;
        if (fsstate != null ? !fsstate.equals(snfEntity.fsstate) : snfEntity.fsstate != null) return false;
        if (fsstdl != null ? !fsstdl.equals(snfEntity.fsstdl) : snfEntity.fsstdl != null) return false;
        if (fsszhhd != null ? !fsszhhd.equals(snfEntity.fsszhhd) : snfEntity.fsszhhd != null) return false;
        if (fstrfil != null ? !fstrfil.equals(snfEntity.fstrfil) : snfEntity.fstrfil != null) return false;
        if (fsvet != null ? !fsvet.equals(snfEntity.fsvet) : snfEntity.fsvet != null) return false;
        if (fsyrinc != null ? !fsyrinc.equals(snfEntity.fsyrinc) : snfEntity.fsyrinc != null) return false;
        if (fszip != null ? !fszip.equals(snfEntity.fszip) : snfEntity.fszip != null) return false;
        if (initals != null ? !initals.equals(snfEntity.initals) : snfEntity.initals != null) return false;
        if (instid != null ? !instid.equals(snfEntity.instid) : snfEntity.instid != null) return false;
        if (module != null ? !module.equals(snfEntity.module) : snfEntity.module != null) return false;
        if (pgidsf != null ? !pgidsf.equals(snfEntity.pgidsf) : snfEntity.pgidsf != null) return false;
        if (pgsid != null ? !pgsid.equals(snfEntity.pgsid) : snfEntity.pgsid != null) return false;
        if (pgtrnnr != null ? !pgtrnnr.equals(snfEntity.pgtrnnr) : snfEntity.pgtrnnr != null) return false;
        if (recstat != null ? !recstat.equals(snfEntity.recstat) : snfEntity.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(snfEntity.revdtc) : snfEntity.revdtc != null) return false;
        if (revtime != null ? !revtime.equals(snfEntity.revtime) : snfEntity.revtime != null) return false;
        if (sid != null ? !sid.equals(snfEntity.sid) : snfEntity.sid != null) return false;
        if (snamef != null ? !snamef.equals(snfEntity.snamef) : snfEntity.snamef != null) return false;
        if (snamei != null ? !snamei.equals(snfEntity.snamei) : snfEntity.snamei != null) return false;
        if (snamel != null ? !snamel.equals(snfEntity.snamel) : snfEntity.snamel != null) return false;
        if (snfkey != null ? !snfkey.equals(snfEntity.snfkey) : snfEntity.snfkey != null) return false;
        if (ucode != null ? !ucode.equals(snfEntity.ucode) : snfEntity.ucode != null) return false;
        if (versnr != null ? !versnr.equals(snfEntity.versnr) : snfEntity.versnr != null) return false;

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
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (pgsid != null ? pgsid.hashCode() : 0);
        result = 31 * result + (pgidsf != null ? pgidsf.hashCode() : 0);
        result = 31 * result + (pgtrnnr != null ? pgtrnnr.hashCode() : 0);
        result = 31 * result + fpin;
        result = 31 * result + (snamel != null ? snamel.hashCode() : 0);
        result = 31 * result + (snamef != null ? snamef.hashCode() : 0);
        result = 31 * result + (snamei != null ? snamei.hashCode() : 0);
        result = 31 * result + (fsaddr != null ? fsaddr.hashCode() : 0);
        result = 31 * result + (fscity != null ? fscity.hashCode() : 0);
        result = 31 * result + (fsstate != null ? fsstate.hashCode() : 0);
        result = 31 * result + (fszip != null ? fszip.hashCode() : 0);
        result = 31 * result + (fsphone != null ? fsphone.hashCode() : 0);
        result = 31 * result + (fsnumdl != null ? fsnumdl.hashCode() : 0);
        result = 31 * result + (fsstdl != null ? fsstdl.hashCode() : 0);
        result = 31 * result + (fincud0 != null ? fincud0.hashCode() : 0);
        result = 31 * result + (fincud1 != null ? fincud1.hashCode() : 0);
        result = 31 * result + (fincudx != null ? fincudx.hashCode() : 0);
        result = 31 * result + (fincud2 != null ? fincud2.hashCode() : 0);
        result = 31 * result + (fincud3 != null ? fincud3.hashCode() : 0);
        result = 31 * result + (fresgt3C != null ? fresgt3C.hashCode() : 0);
        result = 31 * result + (fresgt4C != null ? fresgt4C.hashCode() : 0);
        result = 31 * result + (fresgt4D != null ? fresgt4D.hashCode() : 0);
        result = 31 * result + (fresgt5D != null ? fresgt5D.hashCode() : 0);
        result = 31 * result + (fresgt5E != null ? fresgt5E.hashCode() : 0);
        result = 31 * result + (fresgt6E != null ? fresgt6E.hashCode() : 0);
        result = 31 * result + (fresgt6F != null ? fresgt6F.hashCode() : 0);
        result = 31 * result + (fresgt7F != null ? fresgt7F.hashCode() : 0);
        result = 31 * result + (fborn0 != null ? fborn0.hashCode() : 0);
        result = 31 * result + (fsvet != null ? fsvet.hashCode() : 0);
        result = 31 * result + (forphwd != null ? forphwd.hashCode() : 0);
        result = 31 * result + (flgldep != null ? flgldep.hashCode() : 0);
        result = 31 * result + (fexemp3 != null ? fexemp3.hashCode() : 0);
        result = 31 * result + (fexemp2 != null ? fexemp2.hashCode() : 0);
        result = 31 * result + (fexemp1 != null ? fexemp1.hashCode() : 0);
        result = 31 * result + (fexemp0 != null ? fexemp0.hashCode() : 0);
        result = 31 * result + (ffedad1 != null ? ffedad1.hashCode() : 0);
        result = 31 * result + (frqadefc != null ? frqadefc.hashCode() : 0);
        result = 31 * result + (fsccaren != null ? fsccaren.hashCode() : 0);
        result = 31 * result + (fsres != null ? fsres.hashCode() : 0);
        result = 31 * result + (fsssn != null ? fsssn.hashCode() : 0);
        result = 31 * result + (fscitzn != null ? fscitzn.hashCode() : 0);
        result = 31 * result + (fsalnr != null ? fsalnr.hashCode() : 0);
        result = 31 * result + (fsmartl != null ? fsmartl.hashCode() : 0);
        result = 31 * result + (fsyrinc != null ? fsyrinc.hashCode() : 0);
        result = 31 * result + (fpdeg != null ? fpdeg.hashCode() : 0);
        result = 31 * result + (fdegobj != null ? fdegobj.hashCode() : 0);
        result = 31 * result + (fsenrsum != null ? fsenrsum.hashCode() : 0);
        result = 31 * result + (fsenrfal != null ? fsenrfal.hashCode() : 0);
        result = 31 * result + (fsenrwin != null ? fsenrwin.hashCode() : 0);
        result = 31 * result + (fsenrspr != null ? fsenrspr.hashCode() : 0);
        result = 31 * result + fpprssn;
        result = 31 * result + fpprein;
        result = 31 * result + (fpprsig != null ? fpprsig.hashCode() : 0);
        result = 31 * result + fstotstf;
        result = 31 * result + fsrctstf;
        result = 31 * result + (fsintstf != null ? fsintstf.hashCode() : 0);
        result = 31 * result + fsasttx;
        result = 31 * result + (finsflag != null ? finsflag.hashCode() : 0);
        result = 31 * result + (fsszhhd != null ? fsszhhd.hashCode() : 0);
        result = 31 * result + (fsnrps != null ? fsnrps.hashCode() : 0);
        result = 31 * result + (fstrfil != null ? fstrfil.hashCode() : 0);
        result = 31 * result + (fsexemp != null ? fsexemp.hashCode() : 0);
        result = 31 * result + fsaagi;
        result = 31 * result + fsaitx;
        result = 31 * result + fsaded;
        result = 31 * result + fsawag;
        result = 31 * result + fsaspsw;
        result = 31 * result + fsass;
        result = 31 * result + fsaadc;
        result = 31 * result + fsacs;
        result = 31 * result + fsaonti;
        result = 31 * result + fsamed;
        result = 31 * result + fsameda;
        result = 31 * result + fsatuit;
        result = 31 * result + (fsntuit != null ? fsntuit.hashCode() : 0);
        result = 31 * result + fsatuta;
        result = 31 * result + fsagim;
        result = 31 * result + fsagia;
        result = 31 * result + fsagi;
        result = 31 * result + fsavcm;
        result = 31 * result + fsavca;
        result = 31 * result + fsavc;
        result = 31 * result + (fsdiswk != null ? fsdiswk.hashCode() : 0);
        result = 31 * result + (fsdishm != null ? fsdishm.hashCode() : 0);
        result = 31 * result + fsdwag;
        result = 31 * result + fsdspsw;
        result = 31 * result + fsdoti;
        result = 31 * result + fsdonti;
        result = 31 * result + (fsage != null ? fsage.hashCode() : 0);
        result = 31 * result + fscash;
        result = 31 * result + fshomv;
        result = 31 * result + fshomd;
        result = 31 * result + fsfarmv;
        result = 31 * result + fsfarmd;
        result = 31 * result + fsoriv;
        result = 31 * result + fsorid;
        result = 31 * result + fsbfv;
        result = 31 * result + fsbfd;
        result = 31 * result + (fsfarm != null ? fsfarm.hashCode() : 0);
        result = 31 * result + (fcampus != null ? fcampus.hashCode() : 0);
        result = 31 * result + (fcampus1 != null ? fcampus1.hashCode() : 0);
        result = 31 * result + (fcampus2 != null ? fcampus2.hashCode() : 0);
        result = 31 * result + (fcampus3 != null ? fcampus3.hashCode() : 0);
        result = 31 * result + (fcampus4 != null ? fcampus4.hashCode() : 0);
        result = 31 * result + (fcampus5 != null ? fcampus5.hashCode() : 0);
        result = 31 * result + (fcampus6 != null ? fcampus6.hashCode() : 0);
        result = 31 * result + (frelfed != null ? frelfed.hashCode() : 0);
        result = 31 * result + (frelst != null ? frelst.hashCode() : 0);
        result = 31 * result + (frlinst != null ? frlinst.hashCode() : 0);
        result = 31 * result + (fsigs != null ? fsigs.hashCode() : 0);
        result = 31 * result + (fsigsp != null ? fsigsp.hashCode() : 0);
        result = 31 * result + (fsigf != null ? fsigf.hashCode() : 0);
        result = 31 * result + (fsigm != null ? fsigm.hashCode() : 0);
        result = 31 * result + (fselsrv != null ? fselsrv.hashCode() : 0);
        result = 31 * result + (fselsrvm != null ? fselsrvm.hashCode() : 0);
        result = 31 * result + fsavom;
        result = 31 * result + fsavoa;
        result = 31 * result + fsavo;
        result = 31 * result + (fssflag != null ? fssflag.hashCode() : 0);
        result = 31 * result + (fdepstf != null ? fdepstf.hashCode() : 0);
        result = 31 * result + fsafi;
        result = 31 * result + fsefi;
        result = 31 * result + fsfso;
        result = 31 * result + fseea;
        result = 31 * result + fsdfi;
        result = 31 * result + fspconi;
        result = 31 * result + fshar;
        result = 31 * result + fsoar;
        result = 31 * result + fsbar;
        result = 31 * result + fspca;
        result = 31 * result + fstpc;
        result = 31 * result + fsapc;
        result = 31 * result + fsai;
        result = 31 * result + (frvwini != null ? frvwini.hashCode() : 0);
        result = 31 * result + fsditx;
        result = 31 * result + fsdgi;
        result = 31 * result + fsdsttx;
        result = 31 * result + fsdmeda;
        result = 31 * result + fsdtuta;
        result = 31 * result + fsdea;
        result = 31 * result + fsdfso;
        result = 31 * result + fshome;
        result = 31 * result + fsorie;
        result = 31 * result + fsatti;
        result = 31 * result + fsddfi;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
