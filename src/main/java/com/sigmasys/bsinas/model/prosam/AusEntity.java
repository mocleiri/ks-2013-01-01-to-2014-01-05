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
@javax.persistence.Table(name = "AUS", schema = "SIGMA", catalog = "")
@Entity
public class AusEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getAuskey();
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

    private String auskey;

    @javax.persistence.Column(name = "AUSKEY")
    @Id
    public String getAuskey() {
        return auskey;
    }

    public void setAuskey(String auskey) {
        this.auskey = auskey;
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

    private String uskey;

    @javax.persistence.Column(name = "USKEY")
    @Basic
    public String getUskey() {
        return uskey;
    }

    public void setUskey(String uskey) {
        this.uskey = uskey;
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

    private String remkey;

    @javax.persistence.Column(name = "REMKEY")
    @Basic
    public String getRemkey() {
        return remkey;
    }

    public void setRemkey(String remkey) {
        this.remkey = remkey;
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

    private String altkey;

    @javax.persistence.Column(name = "ALTKEY")
    @Basic
    public String getAltkey() {
        return altkey;
    }

    public void setAltkey(String altkey) {
        this.altkey = altkey;
    }

    private String operid;

    @javax.persistence.Column(name = "OPERID")
    @Basic
    public String getOperid() {
        return operid;
    }

    public void setOperid(String operid) {
        this.operid = operid;
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

    private int numchgs;

    @javax.persistence.Column(name = "NUMCHGS")
    @Basic
    public int getNumchgs() {
        return numchgs;
    }

    public void setNumchgs(int numchgs) {
        this.numchgs = numchgs;
    }

    private String prog;

    @javax.persistence.Column(name = "PROG")
    @Basic
    public String getProg() {
        return prog;
    }

    public void setProg(String prog) {
        this.prog = prog;
    }

    private String proces;

    @javax.persistence.Column(name = "PROCES")
    @Basic
    public String getProces() {
        return proces;
    }

    public void setProces(String proces) {
        this.proces = proces;
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

    private int revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public int getRevlev() {
        return revlev;
    }

    public void setRevlev(int revlev) {
        this.revlev = revlev;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AusEntity ausEntity = (AusEntity) o;

        if (numchgs != ausEntity.numchgs) return false;
        if (revlev != ausEntity.revlev) return false;
        if (altkey != null ? !altkey.equals(ausEntity.altkey) : ausEntity.altkey != null) return false;
        if (applid != null ? !applid.equals(ausEntity.applid) : ausEntity.applid != null) return false;
        if (auskey != null ? !auskey.equals(ausEntity.auskey) : ausEntity.auskey != null) return false;
        if (filecd != null ? !filecd.equals(ausEntity.filecd) : ausEntity.filecd != null) return false;
        if (fileid != null ? !fileid.equals(ausEntity.fileid) : ausEntity.fileid != null) return false;
        if (fsystem != null ? !fsystem.equals(ausEntity.fsystem) : ausEntity.fsystem != null) return false;
        if (inital != null ? !inital.equals(ausEntity.inital) : ausEntity.inital != null) return false;
        if (instid != null ? !instid.equals(ausEntity.instid) : ausEntity.instid != null) return false;
        if (operid != null ? !operid.equals(ausEntity.operid) : ausEntity.operid != null) return false;
        if (proces != null ? !proces.equals(ausEntity.proces) : ausEntity.proces != null) return false;
        if (procyr != null ? !procyr.equals(ausEntity.procyr) : ausEntity.procyr != null) return false;
        if (prog != null ? !prog.equals(ausEntity.prog) : ausEntity.prog != null) return false;
        if (recstat != null ? !recstat.equals(ausEntity.recstat) : ausEntity.recstat != null) return false;
        if (remkey != null ? !remkey.equals(ausEntity.remkey) : ausEntity.remkey != null) return false;
        if (revdate != null ? !revdate.equals(ausEntity.revdate) : ausEntity.revdate != null) return false;
        if (revpgm != null ? !revpgm.equals(ausEntity.revpgm) : ausEntity.revpgm != null) return false;
        if (revtime != null ? !revtime.equals(ausEntity.revtime) : ausEntity.revtime != null) return false;
        if (sid != null ? !sid.equals(ausEntity.sid) : ausEntity.sid != null) return false;
        if (systcd != null ? !systcd.equals(ausEntity.systcd) : ausEntity.systcd != null) return false;
        if (system != null ? !system.equals(ausEntity.system) : ausEntity.system != null) return false;
        if (termid != null ? !termid.equals(ausEntity.termid) : ausEntity.termid != null) return false;
        if (ucode != null ? !ucode.equals(ausEntity.ucode) : ausEntity.ucode != null) return false;
        if (uskey != null ? !uskey.equals(ausEntity.uskey) : ausEntity.uskey != null) return false;
        if (version != null ? !version.equals(ausEntity.version) : ausEntity.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (auskey != null ? auskey.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (uskey != null ? uskey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (remkey != null ? remkey.hashCode() : 0);
        result = 31 * result + (systcd != null ? systcd.hashCode() : 0);
        result = 31 * result + (filecd != null ? filecd.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (altkey != null ? altkey.hashCode() : 0);
        result = 31 * result + (operid != null ? operid.hashCode() : 0);
        result = 31 * result + (applid != null ? applid.hashCode() : 0);
        result = 31 * result + (termid != null ? termid.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (fsystem != null ? fsystem.hashCode() : 0);
        result = 31 * result + (fileid != null ? fileid.hashCode() : 0);
        result = 31 * result + (inital != null ? inital.hashCode() : 0);
        result = 31 * result + numchgs;
        result = 31 * result + (prog != null ? prog.hashCode() : 0);
        result = 31 * result + (proces != null ? proces.hashCode() : 0);
        result = 31 * result + (revpgm != null ? revpgm.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        return result;
    }
}
