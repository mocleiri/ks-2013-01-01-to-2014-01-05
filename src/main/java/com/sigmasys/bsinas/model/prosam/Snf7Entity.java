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
@javax.persistence.Table(name = "SNF7", schema = "SIGMA", catalog = "")
@Entity
public class Snf7Entity implements Identifiable {

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

    private String fpdegree;

    @javax.persistence.Column(name = "FPDEGREE")
    @Basic
    public String getFpdegree() {
        return fpdegree;
    }

    public void setFpdegree(String fpdegree) {
        this.fpdegree = fpdegree;
    }

    private String fslvlstf;

    @javax.persistence.Column(name = "FSLVLSTF")
    @Basic
    public String getFslvlstf() {
        return fslvlstf;
    }

    public void setFslvlstf(String fslvlstf) {
        this.fslvlstf = fslvlstf;
    }

    private String fshsetp;

    @javax.persistence.Column(name = "FSHSETP")
    @Basic
    public String getFshsetp() {
        return fshsetp;
    }

    public void setFshsetp(String fshsetp) {
        this.fshsetp = fshsetp;
    }

    private String fsamecol;

    @javax.persistence.Column(name = "FSAMECOL")
    @Basic
    public String getFsamecol() {
        return fsamecol;
    }

    public void setFsamecol(String fsamecol) {
        this.fsamecol = fsamecol;
    }

    private String fmajor;

    @javax.persistence.Column(name = "FMAJOR")
    @Basic
    public String getFmajor() {
        return fmajor;
    }

    public void setFmajor(String fmajor) {
        this.fmajor = fmajor;
    }

    private int fadjefc;

    @javax.persistence.Column(name = "FADJEFC")
    @Basic
    public int getFadjefc() {
        return fadjefc;
    }

    public void setFadjefc(int fadjefc) {
        this.fadjefc = fadjefc;
    }

    private String fdupesar;

    @javax.persistence.Column(name = "FDUPESAR")
    @Basic
    public String getFdupesar() {
        return fdupesar;
    }

    public void setFdupesar(String fdupesar) {
        this.fdupesar = fdupesar;
    }

    private int fpexcld;

    @javax.persistence.Column(name = "FPEXCLD")
    @Basic
    public int getFpexcld() {
        return fpexcld;
    }

    public void setFpexcld(int fpexcld) {
        this.fpexcld = fpexcld;
    }

    private int fsexcld;

    @javax.persistence.Column(name = "FSEXCLD")
    @Basic
    public int getFsexcld() {
        return fsexcld;
    }

    public void setFsexcld(int fsexcld) {
        this.fsexcld = fsexcld;
    }

    private String fphvplus;

    @javax.persistence.Column(name = "FPHVPLUS")
    @Basic
    public String getFphvplus() {
        return fphvplus;
    }

    public void setFphvplus(String fphvplus) {
        this.fphvplus = fphvplus;
    }

    private String fshvcon;

    @javax.persistence.Column(name = "FSHVCON")
    @Basic
    public String getFshvcon() {
        return fshvcon;
    }

    public void setFshvcon(String fshvcon) {
        this.fshvcon = fshvcon;
    }

    private String fsintws;

    @javax.persistence.Column(name = "FSINTWS")
    @Basic
    public String getFsintws() {
        return fsintws;
    }

    public void setFsintws(String fsintws) {
        this.fsintws = fsintws;
    }

    private String fsintsln;

    @javax.persistence.Column(name = "FSINTSLN")
    @Basic
    public String getFsintsln() {
        return fsintsln;
    }

    public void setFsintsln(String fsintsln) {
        this.fsintsln = fsintsln;
    }

    private String fsintpln;

    @javax.persistence.Column(name = "FSINTPLN")
    @Basic
    public String getFsintpln() {
        return fsintpln;
    }

    public void setFsintpln(String fsintpln) {
        this.fsintpln = fsintpln;
    }

    private String fshous1;

    @javax.persistence.Column(name = "FSHOUS1")
    @Basic
    public String getFshous1() {
        return fshous1;
    }

    public void setFshous1(String fshous1) {
        this.fshous1 = fshous1;
    }

    private String fshous2;

    @javax.persistence.Column(name = "FSHOUS2")
    @Basic
    public String getFshous2() {
        return fshous2;
    }

    public void setFshous2(String fshous2) {
        this.fshous2 = fshous2;
    }

    private String fshous3;

    @javax.persistence.Column(name = "FSHOUS3")
    @Basic
    public String getFshous3() {
        return fshous3;
    }

    public void setFshous3(String fshous3) {
        this.fshous3 = fshous3;
    }

    private String fshous4;

    @javax.persistence.Column(name = "FSHOUS4")
    @Basic
    public String getFshous4() {
        return fshous4;
    }

    public void setFshous4(String fshous4) {
        this.fshous4 = fshous4;
    }

    private String fshous5;

    @javax.persistence.Column(name = "FSHOUS5")
    @Basic
    public String getFshous5() {
        return fshous5;
    }

    public void setFshous5(String fshous5) {
        this.fshous5 = fshous5;
    }

    private String fshous6;

    @javax.persistence.Column(name = "FSHOUS6")
    @Basic
    public String getFshous6() {
        return fshous6;
    }

    public void setFshous6(String fshous6) {
        this.fshous6 = fshous6;
    }

    private String fgradpro;

    @javax.persistence.Column(name = "FGRADPRO")
    @Basic
    public String getFgradpro() {
        return fgradpro;
    }

    public void setFgradpro(String fgradpro) {
        this.fgradpro = fgradpro;
    }

    private String fsmrtlst;

    @javax.persistence.Column(name = "FSMRTLST")
    @Basic
    public String getFsmrtlst() {
        return fsmrtlst;
    }

    public void setFsmrtlst(String fsmrtlst) {
        this.fsmrtlst = fsmrtlst;
    }

    private String ffdepdoc;

    @javax.persistence.Column(name = "FFDEPDOC")
    @Basic
    public String getFfdepdoc() {
        return ffdepdoc;
    }

    public void setFfdepdoc(String ffdepdoc) {
        this.ffdepdoc = ffdepdoc;
    }

    private String fssreg;

    @javax.persistence.Column(name = "FSSREG")
    @Basic
    public String getFssreg() {
        return fssreg;
    }

    public void setFssreg(String fssreg) {
        this.fssreg = fssreg;
    }

    private String fssnmch;

    @javax.persistence.Column(name = "FSSNMCH")
    @Basic
    public String getFssnmch() {
        return fssnmch;
    }

    public void setFssnmch(String fssnmch) {
        this.fssnmch = fssnmch;
    }

    private String fgamch;

    @javax.persistence.Column(name = "FGAMCH")
    @Basic
    public String getFgamch() {
        return fgamch;
    }

    public void setFgamch(String fgamch) {
        this.fgamch = fgamch;
    }

    private String ftivmch;

    @javax.persistence.Column(name = "FTIVMCH")
    @Basic
    public String getFtivmch() {
        return ftivmch;
    }

    public void setFtivmch(String ftivmch) {
        this.ftivmch = ftivmch;
    }

    private String ftivregn;

    @javax.persistence.Column(name = "FTIVREGN")
    @Basic
    public String getFtivregn() {
        return ftivregn;
    }

    public void setFtivregn(String ftivregn) {
        this.ftivregn = ftivregn;
    }

    private String fnsldsm;

    @javax.persistence.Column(name = "FNSLDSM")
    @Basic
    public String getFnsldsm() {
        return fnsldsm;
    }

    public void setFnsldsm(String fnsldsm) {
        this.fnsldsm = fnsldsm;
    }

    private String fzefc;

    @javax.persistence.Column(name = "FZEFC")
    @Basic
    public String getFzefc() {
        return fzefc;
    }

    public void setFzefc(String fzefc) {
        this.fzefc = fzefc;
    }

    private String fformtyp;

    @javax.persistence.Column(name = "FFORMTYP")
    @Basic
    public String getFformtyp() {
        return fformtyp;
    }

    public void setFformtyp(String fformtyp) {
        this.fformtyp = fformtyp;
    }

    private String fverityp;

    @javax.persistence.Column(name = "FVERITYP")
    @Basic
    public String getFverityp() {
        return fverityp;
    }

    public void setFverityp(String fverityp) {
        this.fverityp = fverityp;
    }

    private String fverinbr;

    @javax.persistence.Column(name = "FVERINBR")
    @Basic
    public String getFverinbr() {
        return fverinbr;
    }

    public void setFverinbr(String fverinbr) {
        this.fverinbr = fverinbr;
    }

    private BigInteger fcorrnbr;

    @javax.persistence.Column(name = "FCORRNBR")
    @Basic
    public BigInteger getFcorrnbr() {
        return fcorrnbr;
    }

    public void setFcorrnbr(BigInteger fcorrnbr) {
        this.fcorrnbr = fcorrnbr;
    }

    private String ffaatyp;

    @javax.persistence.Column(name = "FFAATYP")
    @Basic
    public String getFfaatyp() {
        return ffaatyp;
    }

    public void setFfaatyp(String ffaatyp) {
        this.ffaatyp = ffaatyp;
    }

    private String ffaarst;

    @javax.persistence.Column(name = "FFAARST")
    @Basic
    public String getFfaarst() {
        return ffaarst;
    }

    public void setFfaarst(String ffaarst) {
        this.ffaarst = ffaarst;
    }

    private String fpellelg;

    @javax.persistence.Column(name = "FPELLELG")
    @Basic
    public String getFpellelg() {
        return fpellelg;
    }

    public void setFpellelg(String fpellelg) {
        this.fpellelg = fpellelg;
    }

    private int fapexcld;

    @javax.persistence.Column(name = "FAPEXCLD")
    @Basic
    public int getFapexcld() {
        return fapexcld;
    }

    public void setFapexcld(int fapexcld) {
        this.fapexcld = fapexcld;
    }

    private int fasexcld;

    @javax.persistence.Column(name = "FASEXCLD")
    @Basic
    public int getFasexcld() {
        return fasexcld;
    }

    public void setFasexcld(int fasexcld) {
        this.fasexcld = fasexcld;
    }

    private int fexexcld;

    @javax.persistence.Column(name = "FEXEXCLD")
    @Basic
    public int getFexexcld() {
        return fexexcld;
    }

    public void setFexexcld(int fexexcld) {
        this.fexexcld = fexexcld;
    }

    private int faexexc;

    @javax.persistence.Column(name = "FAEXEXC")
    @Basic
    public int getFaexexc() {
        return faexexc;
    }

    public void setFaexexc(int faexexc) {
        this.faexexc = faexexc;
    }

    private String fsenrsu2;

    @javax.persistence.Column(name = "FSENRSU2")
    @Basic
    public String getFsenrsu2() {
        return fsenrsu2;
    }

    public void setFsenrsu2(String fsenrsu2) {
        this.fsenrsu2 = fsenrsu2;
    }

    private String fhilight;

    @javax.persistence.Column(name = "FHILIGHT")
    @Basic
    public String getFhilight() {
        return fhilight;
    }

    public void setFhilight(String fhilight) {
        this.fhilight = fhilight;
    }

    private int fpinccr;

    @javax.persistence.Column(name = "FPINCCR")
    @Basic
    public int getFpinccr() {
        return fpinccr;
    }

    public void setFpinccr(int fpinccr) {
        this.fpinccr = fpinccr;
    }

    private int fsinccr;

    @javax.persistence.Column(name = "FSINCCR")
    @Basic
    public int getFsinccr() {
        return fsinccr;
    }

    public void setFsinccr(int fsinccr) {
        this.fsinccr = fsinccr;
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

        Snf7Entity that = (Snf7Entity) o;

        if (fadjefc != that.fadjefc) return false;
        if (faexexc != that.faexexc) return false;
        if (fapexcld != that.fapexcld) return false;
        if (fasexcld != that.fasexcld) return false;
        if (fexexcld != that.fexexcld) return false;
        if (fpexcld != that.fpexcld) return false;
        if (fpinccr != that.fpinccr) return false;
        if (fsexcld != that.fsexcld) return false;
        if (fsinccr != that.fsinccr) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (fcorrnbr != null ? !fcorrnbr.equals(that.fcorrnbr) : that.fcorrnbr != null) return false;
        if (fdupesar != null ? !fdupesar.equals(that.fdupesar) : that.fdupesar != null) return false;
        if (ffaarst != null ? !ffaarst.equals(that.ffaarst) : that.ffaarst != null) return false;
        if (ffaatyp != null ? !ffaatyp.equals(that.ffaatyp) : that.ffaatyp != null) return false;
        if (ffdepdoc != null ? !ffdepdoc.equals(that.ffdepdoc) : that.ffdepdoc != null) return false;
        if (fformtyp != null ? !fformtyp.equals(that.fformtyp) : that.fformtyp != null) return false;
        if (fgamch != null ? !fgamch.equals(that.fgamch) : that.fgamch != null) return false;
        if (fgradpro != null ? !fgradpro.equals(that.fgradpro) : that.fgradpro != null) return false;
        if (fhilight != null ? !fhilight.equals(that.fhilight) : that.fhilight != null) return false;
        if (fmajor != null ? !fmajor.equals(that.fmajor) : that.fmajor != null) return false;
        if (fnsldsm != null ? !fnsldsm.equals(that.fnsldsm) : that.fnsldsm != null) return false;
        if (fpdegree != null ? !fpdegree.equals(that.fpdegree) : that.fpdegree != null) return false;
        if (fpellelg != null ? !fpellelg.equals(that.fpellelg) : that.fpellelg != null) return false;
        if (fphvplus != null ? !fphvplus.equals(that.fphvplus) : that.fphvplus != null) return false;
        if (fsamecol != null ? !fsamecol.equals(that.fsamecol) : that.fsamecol != null) return false;
        if (fsenrsu2 != null ? !fsenrsu2.equals(that.fsenrsu2) : that.fsenrsu2 != null) return false;
        if (fshous1 != null ? !fshous1.equals(that.fshous1) : that.fshous1 != null) return false;
        if (fshous2 != null ? !fshous2.equals(that.fshous2) : that.fshous2 != null) return false;
        if (fshous3 != null ? !fshous3.equals(that.fshous3) : that.fshous3 != null) return false;
        if (fshous4 != null ? !fshous4.equals(that.fshous4) : that.fshous4 != null) return false;
        if (fshous5 != null ? !fshous5.equals(that.fshous5) : that.fshous5 != null) return false;
        if (fshous6 != null ? !fshous6.equals(that.fshous6) : that.fshous6 != null) return false;
        if (fshsetp != null ? !fshsetp.equals(that.fshsetp) : that.fshsetp != null) return false;
        if (fshvcon != null ? !fshvcon.equals(that.fshvcon) : that.fshvcon != null) return false;
        if (fsintpln != null ? !fsintpln.equals(that.fsintpln) : that.fsintpln != null) return false;
        if (fsintsln != null ? !fsintsln.equals(that.fsintsln) : that.fsintsln != null) return false;
        if (fsintws != null ? !fsintws.equals(that.fsintws) : that.fsintws != null) return false;
        if (fslvlstf != null ? !fslvlstf.equals(that.fslvlstf) : that.fslvlstf != null) return false;
        if (fsmrtlst != null ? !fsmrtlst.equals(that.fsmrtlst) : that.fsmrtlst != null) return false;
        if (fssnmch != null ? !fssnmch.equals(that.fssnmch) : that.fssnmch != null) return false;
        if (fssreg != null ? !fssreg.equals(that.fssreg) : that.fssreg != null) return false;
        if (ftivmch != null ? !ftivmch.equals(that.ftivmch) : that.ftivmch != null) return false;
        if (ftivregn != null ? !ftivregn.equals(that.ftivregn) : that.ftivregn != null) return false;
        if (fverinbr != null ? !fverinbr.equals(that.fverinbr) : that.fverinbr != null) return false;
        if (fverityp != null ? !fverityp.equals(that.fverityp) : that.fverityp != null) return false;
        if (fzefc != null ? !fzefc.equals(that.fzefc) : that.fzefc != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snfkey != null ? !snfkey.equals(that.snfkey) : that.snfkey != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;

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
        result = 31 * result + (fpdegree != null ? fpdegree.hashCode() : 0);
        result = 31 * result + (fslvlstf != null ? fslvlstf.hashCode() : 0);
        result = 31 * result + (fshsetp != null ? fshsetp.hashCode() : 0);
        result = 31 * result + (fsamecol != null ? fsamecol.hashCode() : 0);
        result = 31 * result + (fmajor != null ? fmajor.hashCode() : 0);
        result = 31 * result + fadjefc;
        result = 31 * result + (fdupesar != null ? fdupesar.hashCode() : 0);
        result = 31 * result + fpexcld;
        result = 31 * result + fsexcld;
        result = 31 * result + (fphvplus != null ? fphvplus.hashCode() : 0);
        result = 31 * result + (fshvcon != null ? fshvcon.hashCode() : 0);
        result = 31 * result + (fsintws != null ? fsintws.hashCode() : 0);
        result = 31 * result + (fsintsln != null ? fsintsln.hashCode() : 0);
        result = 31 * result + (fsintpln != null ? fsintpln.hashCode() : 0);
        result = 31 * result + (fshous1 != null ? fshous1.hashCode() : 0);
        result = 31 * result + (fshous2 != null ? fshous2.hashCode() : 0);
        result = 31 * result + (fshous3 != null ? fshous3.hashCode() : 0);
        result = 31 * result + (fshous4 != null ? fshous4.hashCode() : 0);
        result = 31 * result + (fshous5 != null ? fshous5.hashCode() : 0);
        result = 31 * result + (fshous6 != null ? fshous6.hashCode() : 0);
        result = 31 * result + (fgradpro != null ? fgradpro.hashCode() : 0);
        result = 31 * result + (fsmrtlst != null ? fsmrtlst.hashCode() : 0);
        result = 31 * result + (ffdepdoc != null ? ffdepdoc.hashCode() : 0);
        result = 31 * result + (fssreg != null ? fssreg.hashCode() : 0);
        result = 31 * result + (fssnmch != null ? fssnmch.hashCode() : 0);
        result = 31 * result + (fgamch != null ? fgamch.hashCode() : 0);
        result = 31 * result + (ftivmch != null ? ftivmch.hashCode() : 0);
        result = 31 * result + (ftivregn != null ? ftivregn.hashCode() : 0);
        result = 31 * result + (fnsldsm != null ? fnsldsm.hashCode() : 0);
        result = 31 * result + (fzefc != null ? fzefc.hashCode() : 0);
        result = 31 * result + (fformtyp != null ? fformtyp.hashCode() : 0);
        result = 31 * result + (fverityp != null ? fverityp.hashCode() : 0);
        result = 31 * result + (fverinbr != null ? fverinbr.hashCode() : 0);
        result = 31 * result + (fcorrnbr != null ? fcorrnbr.hashCode() : 0);
        result = 31 * result + (ffaatyp != null ? ffaatyp.hashCode() : 0);
        result = 31 * result + (ffaarst != null ? ffaarst.hashCode() : 0);
        result = 31 * result + (fpellelg != null ? fpellelg.hashCode() : 0);
        result = 31 * result + fapexcld;
        result = 31 * result + fasexcld;
        result = 31 * result + fexexcld;
        result = 31 * result + faexexc;
        result = 31 * result + (fsenrsu2 != null ? fsenrsu2.hashCode() : 0);
        result = 31 * result + (fhilight != null ? fhilight.hashCode() : 0);
        result = 31 * result + fpinccr;
        result = 31 * result + fsinccr;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
