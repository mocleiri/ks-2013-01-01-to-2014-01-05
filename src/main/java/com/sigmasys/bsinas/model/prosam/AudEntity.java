package com.sigmasys.bsinas.model.prosam;

import com.sigmasys.bsinas.model.Identifiable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/25/12
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "AUD", schema = "SIGMA", catalog = "")
@Entity
public class AudEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getAudkey();
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

    private String audkey;

    @javax.persistence.Column(name = "AUDKEY")
    @Id
    public String getAudkey() {
        return audkey;
    }

    public void setAudkey(String audkey) {
        this.audkey = audkey;
    }

    private String version;

    @javax.persistence.Column(name = "VERSION")
    @Basic
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    private String systcd;

    @javax.persistence.Column(name = "SYSTCD")
    @Basic
    public String getSystcd() {
        return systcd;
    }

    public void setSystcd(String systcd) {
        this.systcd = systcd;
    }

    private String filecd;

    @javax.persistence.Column(name = "FILECD")
    @Basic
    public String getFilecd() {
        return filecd;
    }

    public void setFilecd(String filecd) {
        this.filecd = filecd;
    }

    private String uakey;

    @javax.persistence.Column(name = "UAKEY")
    @Basic
    public String getUakey() {
        return uakey;
    }

    public void setUakey(String uakey) {
        this.uakey = uakey;
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

    private String pryr;

    @javax.persistence.Column(name = "PRYR")
    @Basic
    public String getPryr() {
        return pryr;
    }

    public void setPryr(String pryr) {
        this.pryr = pryr;
    }

    private String rkey;

    @javax.persistence.Column(name = "RKEY")
    @Basic
    public String getRkey() {
        return rkey;
    }

    public void setRkey(String rkey) {
        this.rkey = rkey;
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

    private String image;

    @javax.persistence.Column(name = "IMAGE")
    @Basic
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String bkey;

    @javax.persistence.Column(name = "BKEY")
    @Basic
    public String getBkey() {
        return bkey;
    }

    public void setBkey(String bkey) {
        this.bkey = bkey;
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

    private String crttime;

    @javax.persistence.Column(name = "CRTTIME")
    @Basic
    public String getCrttime() {
        return crttime;
    }

    public void setCrttime(String crttime) {
        this.crttime = crttime;
    }

    private String rmodule;

    @javax.persistence.Column(name = "RMODULE")
    @Basic
    public String getRmodule() {
        return rmodule;
    }

    public void setRmodule(String rmodule) {
        this.rmodule = rmodule;
    }

    private String rucode;

    @javax.persistence.Column(name = "RUCODE")
    @Basic
    public String getRucode() {
        return rucode;
    }

    public void setRucode(String rucode) {
        this.rucode = rucode;
    }

    private String applid;

    @javax.persistence.Column(name = "APPLID")
    @Basic
    public String getApplid() {
        return applid;
    }

    public void setApplid(String applid) {
        this.applid = applid;
    }

    private String termid;

    @javax.persistence.Column(name = "TERMID")
    @Basic
    public String getTermid() {
        return termid;
    }

    public void setTermid(String termid) {
        this.termid = termid;
    }

    private String program;

    @javax.persistence.Column(name = "PROGRAM")
    @Basic
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    private String process;

    @javax.persistence.Column(name = "PROCESS")
    @Basic
    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    private String system;

    @javax.persistence.Column(name = "SYSTEM")
    @Basic
    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    private String fsystem;

    @javax.persistence.Column(name = "FSYSTEM")
    @Basic
    public String getFsystem() {
        return fsystem;
    }

    public void setFsystem(String fsystem) {
        this.fsystem = fsystem;
    }

    private String fileid;

    @javax.persistence.Column(name = "FILEID")
    @Basic
    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    private String inital;

    @javax.persistence.Column(name = "INITAL")
    @Basic
    public String getInital() {
        return inital;
    }

    public void setInital(String inital) {
        this.inital = inital;
    }

    private int audlen;

    @javax.persistence.Column(name = "AUDLEN")
    @Basic
    public int getAudlen() {
        return audlen;
    }

    public void setAudlen(int audlen) {
        this.audlen = audlen;
    }

    private String arevtm;

    @javax.persistence.Column(name = "AREVTM")
    @Basic
    public String getArevtm() {
        return arevtm;
    }

    public void setArevtm(String arevtm) {
        this.arevtm = arevtm;
    }

    private String amodule;

    @javax.persistence.Column(name = "AMODULE")
    @Basic
    public String getAmodule() {
        return amodule;
    }

    public void setAmodule(String amodule) {
        this.amodule = amodule;
    }

    private String aucode;

    @javax.persistence.Column(name = "AUCODE")
    @Basic
    public String getAucode() {
        return aucode;
    }

    public void setAucode(String aucode) {
        this.aucode = aucode;
    }

    private String crtdtec;

    @javax.persistence.Column(name = "CRTDTEC")
    @Basic
    public String getCrtdtec() {
        return crtdtec;
    }

    public void setCrtdtec(String crtdtec) {
        this.crtdtec = crtdtec;
    }

    private String arevdtc;

    @javax.persistence.Column(name = "AREVDTC")
    @Basic
    public String getArevdtc() {
        return arevdtc;
    }

    public void setArevdtc(String arevdtc) {
        this.arevdtc = arevdtc;
    }

    private String auddata1;

    @javax.persistence.Column(name = "AUDDATA1")
    @Basic
    public String getAuddata1() {
        return auddata1;
    }

    public void setAuddata1(String auddata1) {
        this.auddata1 = auddata1;
    }

    private String auddata2;

    @javax.persistence.Column(name = "AUDDATA2")
    @Basic
    public String getAuddata2() {
        return auddata2;
    }

    public void setAuddata2(String auddata2) {
        this.auddata2 = auddata2;
    }

    private String auddata3;

    @javax.persistence.Column(name = "AUDDATA3")
    @Basic
    public String getAuddata3() {
        return auddata3;
    }

    public void setAuddata3(String auddata3) {
        this.auddata3 = auddata3;
    }

    private String auddata4;

    @javax.persistence.Column(name = "AUDDATA4")
    @Basic
    public String getAuddata4() {
        return auddata4;
    }

    public void setAuddata4(String auddata4) {
        this.auddata4 = auddata4;
    }

    private String auddata5;

    @javax.persistence.Column(name = "AUDDATA5")
    @Basic
    public String getAuddata5() {
        return auddata5;
    }

    public void setAuddata5(String auddata5) {
        this.auddata5 = auddata5;
    }

    private String auddata6;

    @javax.persistence.Column(name = "AUDDATA6")
    @Basic
    public String getAuddata6() {
        return auddata6;
    }

    public void setAuddata6(String auddata6) {
        this.auddata6 = auddata6;
    }

    private String auddata7;

    @javax.persistence.Column(name = "AUDDATA7")
    @Basic
    public String getAuddata7() {
        return auddata7;
    }

    public void setAuddata7(String auddata7) {
        this.auddata7 = auddata7;
    }

    private String auddata8;

    @javax.persistence.Column(name = "AUDDATA8")
    @Basic
    public String getAuddata8() {
        return auddata8;
    }

    public void setAuddata8(String auddata8) {
        this.auddata8 = auddata8;
    }

    private String auddata9;

    @javax.persistence.Column(name = "AUDDATA9")
    @Basic
    public String getAuddata9() {
        return auddata9;
    }

    public void setAuddata9(String auddata9) {
        this.auddata9 = auddata9;
    }

    private String auddataa;

    @javax.persistence.Column(name = "AUDDATAA")
    @Basic
    public String getAuddataa() {
        return auddataa;
    }

    public void setAuddataa(String auddataa) {
        this.auddataa = auddataa;
    }

    private String auddatab;

    @javax.persistence.Column(name = "AUDDATAB")
    @Basic
    public String getAuddatab() {
        return auddatab;
    }

    public void setAuddatab(String auddatab) {
        this.auddatab = auddatab;
    }

    private String auddatac;

    @javax.persistence.Column(name = "AUDDATAC")
    @Basic
    public String getAuddatac() {
        return auddatac;
    }

    public void setAuddatac(String auddatac) {
        this.auddatac = auddatac;
    }

    private String auddatad;

    @javax.persistence.Column(name = "AUDDATAD")
    @Basic
    public String getAuddatad() {
        return auddatad;
    }

    public void setAuddatad(String auddatad) {
        this.auddatad = auddatad;
    }

    private String auddatae;

    @javax.persistence.Column(name = "AUDDATAE")
    @Basic
    public String getAuddatae() {
        return auddatae;
    }

    public void setAuddatae(String auddatae) {
        this.auddatae = auddatae;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AudEntity audEntity = (AudEntity) o;

        if (audlen != audEntity.audlen) return false;
        if (revlev != audEntity.revlev) return false;
        if (amodule != null ? !amodule.equals(audEntity.amodule) : audEntity.amodule != null) return false;
        if (applid != null ? !applid.equals(audEntity.applid) : audEntity.applid != null) return false;
        if (arevdtc != null ? !arevdtc.equals(audEntity.arevdtc) : audEntity.arevdtc != null) return false;
        if (arevtm != null ? !arevtm.equals(audEntity.arevtm) : audEntity.arevtm != null) return false;
        if (aucode != null ? !aucode.equals(audEntity.aucode) : audEntity.aucode != null) return false;
        if (auddata1 != null ? !auddata1.equals(audEntity.auddata1) : audEntity.auddata1 != null) return false;
        if (auddata2 != null ? !auddata2.equals(audEntity.auddata2) : audEntity.auddata2 != null) return false;
        if (auddata3 != null ? !auddata3.equals(audEntity.auddata3) : audEntity.auddata3 != null) return false;
        if (auddata4 != null ? !auddata4.equals(audEntity.auddata4) : audEntity.auddata4 != null) return false;
        if (auddata5 != null ? !auddata5.equals(audEntity.auddata5) : audEntity.auddata5 != null) return false;
        if (auddata6 != null ? !auddata6.equals(audEntity.auddata6) : audEntity.auddata6 != null) return false;
        if (auddata7 != null ? !auddata7.equals(audEntity.auddata7) : audEntity.auddata7 != null) return false;
        if (auddata8 != null ? !auddata8.equals(audEntity.auddata8) : audEntity.auddata8 != null) return false;
        if (auddata9 != null ? !auddata9.equals(audEntity.auddata9) : audEntity.auddata9 != null) return false;
        if (auddataa != null ? !auddataa.equals(audEntity.auddataa) : audEntity.auddataa != null) return false;
        if (auddatab != null ? !auddatab.equals(audEntity.auddatab) : audEntity.auddatab != null) return false;
        if (auddatac != null ? !auddatac.equals(audEntity.auddatac) : audEntity.auddatac != null) return false;
        if (auddatad != null ? !auddatad.equals(audEntity.auddatad) : audEntity.auddatad != null) return false;
        if (auddatae != null ? !auddatae.equals(audEntity.auddatae) : audEntity.auddatae != null) return false;
        if (audkey != null ? !audkey.equals(audEntity.audkey) : audEntity.audkey != null) return false;
        if (bkey != null ? !bkey.equals(audEntity.bkey) : audEntity.bkey != null) return false;
        if (crtdtec != null ? !crtdtec.equals(audEntity.crtdtec) : audEntity.crtdtec != null) return false;
        if (crttime != null ? !crttime.equals(audEntity.crttime) : audEntity.crttime != null) return false;
        if (filecd != null ? !filecd.equals(audEntity.filecd) : audEntity.filecd != null) return false;
        if (fileid != null ? !fileid.equals(audEntity.fileid) : audEntity.fileid != null) return false;
        if (fsystem != null ? !fsystem.equals(audEntity.fsystem) : audEntity.fsystem != null) return false;
        if (image != null ? !image.equals(audEntity.image) : audEntity.image != null) return false;
        if (inital != null ? !inital.equals(audEntity.inital) : audEntity.inital != null) return false;
        if (instid != null ? !instid.equals(audEntity.instid) : audEntity.instid != null) return false;
        if (process != null ? !process.equals(audEntity.process) : audEntity.process != null) return false;
        if (program != null ? !program.equals(audEntity.program) : audEntity.program != null) return false;
        if (pryr != null ? !pryr.equals(audEntity.pryr) : audEntity.pryr != null) return false;
        if (recstat != null ? !recstat.equals(audEntity.recstat) : audEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(audEntity.revdate) : audEntity.revdate != null) return false;
        if (revtime != null ? !revtime.equals(audEntity.revtime) : audEntity.revtime != null) return false;
        if (rkey != null ? !rkey.equals(audEntity.rkey) : audEntity.rkey != null) return false;
        if (rmodule != null ? !rmodule.equals(audEntity.rmodule) : audEntity.rmodule != null) return false;
        if (rucode != null ? !rucode.equals(audEntity.rucode) : audEntity.rucode != null) return false;
        if (sid != null ? !sid.equals(audEntity.sid) : audEntity.sid != null) return false;
        if (systcd != null ? !systcd.equals(audEntity.systcd) : audEntity.systcd != null) return false;
        if (system != null ? !system.equals(audEntity.system) : audEntity.system != null) return false;
        if (termid != null ? !termid.equals(audEntity.termid) : audEntity.termid != null) return false;
        if (uakey != null ? !uakey.equals(audEntity.uakey) : audEntity.uakey != null) return false;
        if (version != null ? !version.equals(audEntity.version) : audEntity.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (audkey != null ? audkey.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (systcd != null ? systcd.hashCode() : 0);
        result = 31 * result + (filecd != null ? filecd.hashCode() : 0);
        result = 31 * result + (uakey != null ? uakey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (pryr != null ? pryr.hashCode() : 0);
        result = 31 * result + (rkey != null ? rkey.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (bkey != null ? bkey.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (rmodule != null ? rmodule.hashCode() : 0);
        result = 31 * result + (rucode != null ? rucode.hashCode() : 0);
        result = 31 * result + (applid != null ? applid.hashCode() : 0);
        result = 31 * result + (termid != null ? termid.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + (process != null ? process.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (fsystem != null ? fsystem.hashCode() : 0);
        result = 31 * result + (fileid != null ? fileid.hashCode() : 0);
        result = 31 * result + (inital != null ? inital.hashCode() : 0);
        result = 31 * result + audlen;
        result = 31 * result + (arevtm != null ? arevtm.hashCode() : 0);
        result = 31 * result + (amodule != null ? amodule.hashCode() : 0);
        result = 31 * result + (aucode != null ? aucode.hashCode() : 0);
        result = 31 * result + (crtdtec != null ? crtdtec.hashCode() : 0);
        result = 31 * result + (arevdtc != null ? arevdtc.hashCode() : 0);
        result = 31 * result + (auddata1 != null ? auddata1.hashCode() : 0);
        result = 31 * result + (auddata2 != null ? auddata2.hashCode() : 0);
        result = 31 * result + (auddata3 != null ? auddata3.hashCode() : 0);
        result = 31 * result + (auddata4 != null ? auddata4.hashCode() : 0);
        result = 31 * result + (auddata5 != null ? auddata5.hashCode() : 0);
        result = 31 * result + (auddata6 != null ? auddata6.hashCode() : 0);
        result = 31 * result + (auddata7 != null ? auddata7.hashCode() : 0);
        result = 31 * result + (auddata8 != null ? auddata8.hashCode() : 0);
        result = 31 * result + (auddata9 != null ? auddata9.hashCode() : 0);
        result = 31 * result + (auddataa != null ? auddataa.hashCode() : 0);
        result = 31 * result + (auddatab != null ? auddatab.hashCode() : 0);
        result = 31 * result + (auddatac != null ? auddatac.hashCode() : 0);
        result = 31 * result + (auddatad != null ? auddatad.hashCode() : 0);
        result = 31 * result + (auddatae != null ? auddatae.hashCode() : 0);
        return result;
    }
}
