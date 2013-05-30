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
 * Date: 11/25/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DED", schema = "SIGMA", catalog = "")
@Entity
public class DedEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getDedkey();
    }

    private String dedkey;

    @javax.persistence.Column(name = "DEDKEY")
    @Id
    public String getDedkey() {
        return dedkey;
    }

    public void setDedkey(String dedkey) {
        this.dedkey = dedkey;
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

    private String dedfile;

    @javax.persistence.Column(name = "DEDFILE")
    @Basic
    public String getDedfile() {
        return dedfile;
    }

    public void setDedfile(String dedfile) {
        this.dedfile = dedfile;
    }

    private String dedname;

    @javax.persistence.Column(name = "DEDNAME")
    @Basic
    public String getDedname() {
        return dedname;
    }

    public void setDedname(String dedname) {
        this.dedname = dedname;
    }

    private String rectype;

    @javax.persistence.Column(name = "RECTYPE")
    @Basic
    public String getRectype() {
        return rectype;
    }

    public void setRectype(String rectype) {
        this.rectype = rectype;
    }

    private String seqnox;

    @javax.persistence.Column(name = "SEQNOX")
    @Basic
    public String getSeqnox() {
        return seqnox;
    }

    public void setSeqnox(String seqnox) {
        this.seqnox = seqnox;
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

    private String filename;

    @javax.persistence.Column(name = "FILENAME")
    @Basic
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private String deddata;

    @javax.persistence.Column(name = "DEDDATA")
    @Basic
    public String getDeddata() {
        return deddata;
    }

    public void setDeddata(String deddata) {
        this.deddata = deddata;
    }

    private String fname;

    @javax.persistence.Column(name = "FNAME")
    @Basic
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    private String fname2;

    @javax.persistence.Column(name = "FNAME2")
    @Basic
    public String getFname2() {
        return fname2;
    }

    public void setFname2(String fname2) {
        this.fname2 = fname2;
    }

    private int compno;

    @javax.persistence.Column(name = "COMPNO")
    @Basic
    public int getCompno() {
        return compno;
    }

    public void setCompno(int compno) {
        this.compno = compno;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DedEntity dedEntity = (DedEntity) o;

        if (compno != dedEntity.compno) return false;
        if (deddata != null ? !deddata.equals(dedEntity.deddata) : dedEntity.deddata != null) return false;
        if (dedfile != null ? !dedfile.equals(dedEntity.dedfile) : dedEntity.dedfile != null) return false;
        if (dedkey != null ? !dedkey.equals(dedEntity.dedkey) : dedEntity.dedkey != null) return false;
        if (dedname != null ? !dedname.equals(dedEntity.dedname) : dedEntity.dedname != null) return false;
        if (filename != null ? !filename.equals(dedEntity.filename) : dedEntity.filename != null) return false;
        if (fname != null ? !fname.equals(dedEntity.fname) : dedEntity.fname != null) return false;
        if (fname2 != null ? !fname2.equals(dedEntity.fname2) : dedEntity.fname2 != null) return false;
        if (initals != null ? !initals.equals(dedEntity.initals) : dedEntity.initals != null) return false;
        if (instid != null ? !instid.equals(dedEntity.instid) : dedEntity.instid != null) return false;
        if (module != null ? !module.equals(dedEntity.module) : dedEntity.module != null) return false;
        if (rectype != null ? !rectype.equals(dedEntity.rectype) : dedEntity.rectype != null) return false;
        if (revdtec != null ? !revdtec.equals(dedEntity.revdtec) : dedEntity.revdtec != null) return false;
        if (revlev != null ? !revlev.equals(dedEntity.revlev) : dedEntity.revlev != null) return false;
        if (seqnox != null ? !seqnox.equals(dedEntity.seqnox) : dedEntity.seqnox != null) return false;
        if (sitime != null ? !sitime.equals(dedEntity.sitime) : dedEntity.sitime != null) return false;
        if (system != null ? !system.equals(dedEntity.system) : dedEntity.system != null) return false;
        if (ucode != null ? !ucode.equals(dedEntity.ucode) : dedEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dedkey != null ? dedkey.hashCode() : 0;
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (dedfile != null ? dedfile.hashCode() : 0);
        result = 31 * result + (dedname != null ? dedname.hashCode() : 0);
        result = 31 * result + (rectype != null ? rectype.hashCode() : 0);
        result = 31 * result + (seqnox != null ? seqnox.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + (deddata != null ? deddata.hashCode() : 0);
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (fname2 != null ? fname2.hashCode() : 0);
        result = 31 * result + compno;
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (sitime != null ? sitime.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        return result;
    }
}
