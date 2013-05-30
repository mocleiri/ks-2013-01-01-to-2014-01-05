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
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SAC", schema = "SIGMA", catalog = "")
@Entity
public class SacEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSackey();
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

    private String sackey;

    @javax.persistence.Column(name = "SACKEY")
    @Id
    public String getSackey() {
        return sackey;
    }

    public void setSackey(String sackey) {
        this.sackey = sackey;
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

    private String system;

    @javax.persistence.Column(name = "SYSTEM")
    @Basic
    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
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

    private String crtdtec;

    @javax.persistence.Column(name = "CRTDTEC")
    @Basic
    public String getCrtdtec() {
        return crtdtec;
    }

    public void setCrtdtec(String crtdtec) {
        this.crtdtec = crtdtec;
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

    private String crtmod;

    @javax.persistence.Column(name = "CRTMOD")
    @Basic
    public String getCrtmod() {
        return crtmod;
    }

    public void setCrtmod(String crtmod) {
        this.crtmod = crtmod;
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

    private String revdtec;

    @javax.persistence.Column(name = "REVDTEC")
    @Basic
    public String getRevdtec() {
        return revdtec;
    }

    public void setRevdtec(String revdtec) {
        this.revdtec = revdtec;
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

    private String revmod;

    @javax.persistence.Column(name = "REVMOD")
    @Basic
    public String getRevmod() {
        return revmod;
    }

    public void setRevmod(String revmod) {
        this.revmod = revmod;
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

    private String ucode;

    @javax.persistence.Column(name = "UCODE")
    @Basic
    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    private String acces;

    @javax.persistence.Column(name = "ACCES")
    @Basic
    public String getAcces() {
        return acces;
    }

    public void setAcces(String acces) {
        this.acces = acces;
    }

    private String disacct;

    @javax.persistence.Column(name = "DISACCT")
    @Basic
    public String getDisacct() {
        return disacct;
    }

    public void setDisacct(String disacct) {
        this.disacct = disacct;
    }

    private String frcpass;

    @javax.persistence.Column(name = "FRCPASS")
    @Basic
    public String getFrcpass() {
        return frcpass;
    }

    public void setFrcpass(String frcpass) {
        this.frcpass = frcpass;
    }

    private String lname;

    @javax.persistence.Column(name = "LNAME")
    @Basic
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    private String midinit;

    @javax.persistence.Column(name = "MIDINIT")
    @Basic
    public String getMidinit() {
        return midinit;
    }

    public void setMidinit(String midinit) {
        this.midinit = midinit;
    }

    private String ubirth;

    @javax.persistence.Column(name = "UBIRTH")
    @Basic
    public String getUbirth() {
        return ubirth;
    }

    public void setUbirth(String ubirth) {
        this.ubirth = ubirth;
    }

    private String filsufx;

    @javax.persistence.Column(name = "FILSUFX")
    @Basic
    public String getFilsufx() {
        return filsufx;
    }

    public void setFilsufx(String filsufx) {
        this.filsufx = filsufx;
    }

    private String tblsufx;

    @javax.persistence.Column(name = "TBLSUFX")
    @Basic
    public String getTblsufx() {
        return tblsufx;
    }

    public void setTblsufx(String tblsufx) {
        this.tblsufx = tblsufx;
    }

    private String acsrole;

    @javax.persistence.Column(name = "ACSROLE")
    @Basic
    public String getAcsrole() {
        return acsrole;
    }

    public void setAcsrole(String acsrole) {
        this.acsrole = acsrole;
    }

    private String begdate;

    @javax.persistence.Column(name = "BEGDATE")
    @Basic
    public String getBegdate() {
        return begdate;
    }

    public void setBegdate(String begdate) {
        this.begdate = begdate;
    }

    private String enddate;

    @javax.persistence.Column(name = "ENDDATE")
    @Basic
    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    private int ntries;

    @javax.persistence.Column(name = "NTRIES")
    @Basic
    public int getNtries() {
        return ntries;
    }

    public void setNtries(int ntries) {
        this.ntries = ntries;
    }

    private String dtlast;

    @javax.persistence.Column(name = "DTLAST")
    @Basic
    public String getDtlast() {
        return dtlast;
    }

    public void setDtlast(String dtlast) {
        this.dtlast = dtlast;
    }

    private String timlast;

    @javax.persistence.Column(name = "TIMLAST")
    @Basic
    public String getTimlast() {
        return timlast;
    }

    public void setTimlast(String timlast) {
        this.timlast = timlast;
    }

    private String seclvl;

    @javax.persistence.Column(name = "SECLVL")
    @Basic
    public String getSeclvl() {
        return seclvl;
    }

    public void setSeclvl(String seclvl) {
        this.seclvl = seclvl;
    }

    private String biosufx;

    @javax.persistence.Column(name = "BIOSUFX")
    @Basic
    public String getBiosufx() {
        return biosufx;
    }

    public void setBiosufx(String biosufx) {
        this.biosufx = biosufx;
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

    private String email;

    @javax.persistence.Column(name = "EMAIL")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String maiden;

    @javax.persistence.Column(name = "MAIDEN")
    @Basic
    public String getMaiden() {
        return maiden;
    }

    public void setMaiden(String maiden) {
        this.maiden = maiden;
    }

    private String deprtm;

    @javax.persistence.Column(name = "DEPRTM")
    @Basic
    public String getDeprtm() {
        return deprtm;
    }

    public void setDeprtm(String deprtm) {
        this.deprtm = deprtm;
    }

    private String phonum;

    @javax.persistence.Column(name = "PHONUM")
    @Basic
    public String getPhonum() {
        return phonum;
    }

    public void setPhonum(String phonum) {
        this.phonum = phonum;
    }

    private String phonex;

    @javax.persistence.Column(name = "PHONEX")
    @Basic
    public String getPhonex() {
        return phonex;
    }

    public void setPhonex(String phonex) {
        this.phonex = phonex;
    }

    private String build;

    @javax.persistence.Column(name = "BUILD")
    @Basic
    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    private String office;

    @javax.persistence.Column(name = "OFFICE")
    @Basic
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SacEntity sacEntity = (SacEntity) o;

        if (ntries != sacEntity.ntries) return false;
        if (revlev != sacEntity.revlev) return false;
        if (acces != null ? !acces.equals(sacEntity.acces) : sacEntity.acces != null) return false;
        if (acsrole != null ? !acsrole.equals(sacEntity.acsrole) : sacEntity.acsrole != null) return false;
        if (begdate != null ? !begdate.equals(sacEntity.begdate) : sacEntity.begdate != null) return false;
        if (biosufx != null ? !biosufx.equals(sacEntity.biosufx) : sacEntity.biosufx != null) return false;
        if (build != null ? !build.equals(sacEntity.build) : sacEntity.build != null) return false;
        if (campus != null ? !campus.equals(sacEntity.campus) : sacEntity.campus != null) return false;
        if (crtdtec != null ? !crtdtec.equals(sacEntity.crtdtec) : sacEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(sacEntity.crtmod) : sacEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(sacEntity.crttime) : sacEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(sacEntity.crtuser) : sacEntity.crtuser != null) return false;
        if (deprtm != null ? !deprtm.equals(sacEntity.deprtm) : sacEntity.deprtm != null) return false;
        if (disacct != null ? !disacct.equals(sacEntity.disacct) : sacEntity.disacct != null) return false;
        if (dtlast != null ? !dtlast.equals(sacEntity.dtlast) : sacEntity.dtlast != null) return false;
        if (email != null ? !email.equals(sacEntity.email) : sacEntity.email != null) return false;
        if (enddate != null ? !enddate.equals(sacEntity.enddate) : sacEntity.enddate != null) return false;
        if (filsufx != null ? !filsufx.equals(sacEntity.filsufx) : sacEntity.filsufx != null) return false;
        if (fname != null ? !fname.equals(sacEntity.fname) : sacEntity.fname != null) return false;
        if (frcpass != null ? !frcpass.equals(sacEntity.frcpass) : sacEntity.frcpass != null) return false;
        if (initals != null ? !initals.equals(sacEntity.initals) : sacEntity.initals != null) return false;
        if (instid != null ? !instid.equals(sacEntity.instid) : sacEntity.instid != null) return false;
        if (lname != null ? !lname.equals(sacEntity.lname) : sacEntity.lname != null) return false;
        if (maiden != null ? !maiden.equals(sacEntity.maiden) : sacEntity.maiden != null) return false;
        if (midinit != null ? !midinit.equals(sacEntity.midinit) : sacEntity.midinit != null) return false;
        if (office != null ? !office.equals(sacEntity.office) : sacEntity.office != null) return false;
        if (operid != null ? !operid.equals(sacEntity.operid) : sacEntity.operid != null) return false;
        if (phonex != null ? !phonex.equals(sacEntity.phonex) : sacEntity.phonex != null) return false;
        if (phonum != null ? !phonum.equals(sacEntity.phonum) : sacEntity.phonum != null) return false;
        if (recstat != null ? !recstat.equals(sacEntity.recstat) : sacEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(sacEntity.revdtec) : sacEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(sacEntity.revmod) : sacEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(sacEntity.revtime) : sacEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(sacEntity.revuser) : sacEntity.revuser != null) return false;
        if (sackey != null ? !sackey.equals(sacEntity.sackey) : sacEntity.sackey != null) return false;
        if (seclvl != null ? !seclvl.equals(sacEntity.seclvl) : sacEntity.seclvl != null) return false;
        if (system != null ? !system.equals(sacEntity.system) : sacEntity.system != null) return false;
        if (tblsufx != null ? !tblsufx.equals(sacEntity.tblsufx) : sacEntity.tblsufx != null) return false;
        if (timlast != null ? !timlast.equals(sacEntity.timlast) : sacEntity.timlast != null) return false;
        if (ubirth != null ? !ubirth.equals(sacEntity.ubirth) : sacEntity.ubirth != null) return false;
        if (ucode != null ? !ucode.equals(sacEntity.ucode) : sacEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (sackey != null ? sackey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (operid != null ? operid.hashCode() : 0);
        result = 31 * result + (crtdtec != null ? crtdtec.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (acces != null ? acces.hashCode() : 0);
        result = 31 * result + (disacct != null ? disacct.hashCode() : 0);
        result = 31 * result + (frcpass != null ? frcpass.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (midinit != null ? midinit.hashCode() : 0);
        result = 31 * result + (ubirth != null ? ubirth.hashCode() : 0);
        result = 31 * result + (filsufx != null ? filsufx.hashCode() : 0);
        result = 31 * result + (tblsufx != null ? tblsufx.hashCode() : 0);
        result = 31 * result + (acsrole != null ? acsrole.hashCode() : 0);
        result = 31 * result + (begdate != null ? begdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + ntries;
        result = 31 * result + (dtlast != null ? dtlast.hashCode() : 0);
        result = 31 * result + (timlast != null ? timlast.hashCode() : 0);
        result = 31 * result + (seclvl != null ? seclvl.hashCode() : 0);
        result = 31 * result + (biosufx != null ? biosufx.hashCode() : 0);
        result = 31 * result + (initals != null ? initals.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (maiden != null ? maiden.hashCode() : 0);
        result = 31 * result + (deprtm != null ? deprtm.hashCode() : 0);
        result = 31 * result + (phonum != null ? phonum.hashCode() : 0);
        result = 31 * result + (phonex != null ? phonex.hashCode() : 0);
        result = 31 * result + (build != null ? build.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        return result;
    }
}
