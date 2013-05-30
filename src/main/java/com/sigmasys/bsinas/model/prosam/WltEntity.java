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
 * Date: 11/26/12
 * Time: 12:35 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "WLT", schema = "SIGMA", catalog = "")
@Entity
public class WltEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getWltkey();
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

    private String wltkey;

    @javax.persistence.Column(name = "WLTKEY")
    @Id
    public String getWltkey() {
        return wltkey;
    }

    public void setWltkey(String wltkey) {
        this.wltkey = wltkey;
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

    private String crtuser;

    @javax.persistence.Column(name = "CRTUSER")
    @Basic
    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
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

    private String revuser;

    @javax.persistence.Column(name = "REVUSER")
    @Basic
    public String getRevuser() {
        return revuser;
    }

    public void setRevuser(String revuser) {
        this.revuser = revuser;
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

    private BigDecimal revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public BigDecimal getRevlev() {
        return revlev;
    }

    public void setRevlev(BigDecimal revlev) {
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

    private BigDecimal usrnr1;

    @javax.persistence.Column(name = "USRNR1")
    @Basic
    public BigDecimal getUsrnr1() {
        return usrnr1;
    }

    public void setUsrnr1(BigDecimal usrnr1) {
        this.usrnr1 = usrnr1;
    }

    private BigDecimal usrnr2;

    @javax.persistence.Column(name = "USRNR2")
    @Basic
    public BigDecimal getUsrnr2() {
        return usrnr2;
    }

    public void setUsrnr2(BigDecimal usrnr2) {
        this.usrnr2 = usrnr2;
    }

    private BigDecimal usrnr3;

    @javax.persistence.Column(name = "USRNR3")
    @Basic
    public BigDecimal getUsrnr3() {
        return usrnr3;
    }

    public void setUsrnr3(BigDecimal usrnr3) {
        this.usrnr3 = usrnr3;
    }

    private BigDecimal usrnr4;

    @javax.persistence.Column(name = "USRNR4")
    @Basic
    public BigDecimal getUsrnr4() {
        return usrnr4;
    }

    public void setUsrnr4(BigDecimal usrnr4) {
        this.usrnr4 = usrnr4;
    }

    private BigDecimal usrnr5;

    @javax.persistence.Column(name = "USRNR5")
    @Basic
    public BigDecimal getUsrnr5() {
        return usrnr5;
    }

    public void setUsrnr5(BigDecimal usrnr5) {
        this.usrnr5 = usrnr5;
    }

    private BigDecimal usrnr6;

    @javax.persistence.Column(name = "USRNR6")
    @Basic
    public BigDecimal getUsrnr6() {
        return usrnr6;
    }

    public void setUsrnr6(BigDecimal usrnr6) {
        this.usrnr6 = usrnr6;
    }

    private BigDecimal usrnr7;

    @javax.persistence.Column(name = "USRNR7")
    @Basic
    public BigDecimal getUsrnr7() {
        return usrnr7;
    }

    public void setUsrnr7(BigDecimal usrnr7) {
        this.usrnr7 = usrnr7;
    }

    private BigDecimal usrnr8;

    @javax.persistence.Column(name = "USRNR8")
    @Basic
    public BigDecimal getUsrnr8() {
        return usrnr8;
    }

    public void setUsrnr8(BigDecimal usrnr8) {
        this.usrnr8 = usrnr8;
    }

    private String usrcd1;

    @javax.persistence.Column(name = "USRCD1")
    @Basic
    public String getUsrcd1() {
        return usrcd1;
    }

    public void setUsrcd1(String usrcd1) {
        this.usrcd1 = usrcd1;
    }

    private String usrcd2;

    @javax.persistence.Column(name = "USRCD2")
    @Basic
    public String getUsrcd2() {
        return usrcd2;
    }

    public void setUsrcd2(String usrcd2) {
        this.usrcd2 = usrcd2;
    }

    private String usrcd3;

    @javax.persistence.Column(name = "USRCD3")
    @Basic
    public String getUsrcd3() {
        return usrcd3;
    }

    public void setUsrcd3(String usrcd3) {
        this.usrcd3 = usrcd3;
    }

    private String usrcd4;

    @javax.persistence.Column(name = "USRCD4")
    @Basic
    public String getUsrcd4() {
        return usrcd4;
    }

    public void setUsrcd4(String usrcd4) {
        this.usrcd4 = usrcd4;
    }

    private String usrcd5;

    @javax.persistence.Column(name = "USRCD5")
    @Basic
    public String getUsrcd5() {
        return usrcd5;
    }

    public void setUsrcd5(String usrcd5) {
        this.usrcd5 = usrcd5;
    }

    private String usrcd6;

    @javax.persistence.Column(name = "USRCD6")
    @Basic
    public String getUsrcd6() {
        return usrcd6;
    }

    public void setUsrcd6(String usrcd6) {
        this.usrcd6 = usrcd6;
    }

    private String usrcd7;

    @javax.persistence.Column(name = "USRCD7")
    @Basic
    public String getUsrcd7() {
        return usrcd7;
    }

    public void setUsrcd7(String usrcd7) {
        this.usrcd7 = usrcd7;
    }

    private String usrcd8;

    @javax.persistence.Column(name = "USRCD8")
    @Basic
    public String getUsrcd8() {
        return usrcd8;
    }

    public void setUsrcd8(String usrcd8) {
        this.usrcd8 = usrcd8;
    }

    private String usrcd9;

    @javax.persistence.Column(name = "USRCD9")
    @Basic
    public String getUsrcd9() {
        return usrcd9;
    }

    public void setUsrcd9(String usrcd9) {
        this.usrcd9 = usrcd9;
    }

    private String usrcda;

    @javax.persistence.Column(name = "USRCDA")
    @Basic
    public String getUsrcda() {
        return usrcda;
    }

    public void setUsrcda(String usrcda) {
        this.usrcda = usrcda;
    }

    private String usrcdb;

    @javax.persistence.Column(name = "USRCDB")
    @Basic
    public String getUsrcdb() {
        return usrcdb;
    }

    public void setUsrcdb(String usrcdb) {
        this.usrcdb = usrcdb;
    }

    private String usrcdc;

    @javax.persistence.Column(name = "USRCDC")
    @Basic
    public String getUsrcdc() {
        return usrcdc;
    }

    public void setUsrcdc(String usrcdc) {
        this.usrcdc = usrcdc;
    }

    private String usrdt1;

    @javax.persistence.Column(name = "USRDT1")
    @Basic
    public String getUsrdt1() {
        return usrdt1;
    }

    public void setUsrdt1(String usrdt1) {
        this.usrdt1 = usrdt1;
    }

    private String usrdt2;

    @javax.persistence.Column(name = "USRDT2")
    @Basic
    public String getUsrdt2() {
        return usrdt2;
    }

    public void setUsrdt2(String usrdt2) {
        this.usrdt2 = usrdt2;
    }

    private String usrdt3;

    @javax.persistence.Column(name = "USRDT3")
    @Basic
    public String getUsrdt3() {
        return usrdt3;
    }

    public void setUsrdt3(String usrdt3) {
        this.usrdt3 = usrdt3;
    }

    private String usrdt4;

    @javax.persistence.Column(name = "USRDT4")
    @Basic
    public String getUsrdt4() {
        return usrdt4;
    }

    public void setUsrdt4(String usrdt4) {
        this.usrdt4 = usrdt4;
    }

    private String usrdt5;

    @javax.persistence.Column(name = "USRDT5")
    @Basic
    public String getUsrdt5() {
        return usrdt5;
    }

    public void setUsrdt5(String usrdt5) {
        this.usrdt5 = usrdt5;
    }

    private String usrdt6;

    @javax.persistence.Column(name = "USRDT6")
    @Basic
    public String getUsrdt6() {
        return usrdt6;
    }

    public void setUsrdt6(String usrdt6) {
        this.usrdt6 = usrdt6;
    }

    private String usrdt7;

    @javax.persistence.Column(name = "USRDT7")
    @Basic
    public String getUsrdt7() {
        return usrdt7;
    }

    public void setUsrdt7(String usrdt7) {
        this.usrdt7 = usrdt7;
    }

    private String usrdt8;

    @javax.persistence.Column(name = "USRDT8")
    @Basic
    public String getUsrdt8() {
        return usrdt8;
    }

    public void setUsrdt8(String usrdt8) {
        this.usrdt8 = usrdt8;
    }

    private String tname;

    @javax.persistence.Column(name = "TNAME")
    @Basic
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    private String leadnm;

    @javax.persistence.Column(name = "LEADNM")
    @Basic
    public String getLeadnm() {
        return leadnm;
    }

    public void setLeadnm(String leadnm) {
        this.leadnm = leadnm;
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

    private String inactv;

    @javax.persistence.Column(name = "INACTV")
    @Basic
    public String getInactv() {
        return inactv;
    }

    public void setInactv(String inactv) {
        this.inactv = inactv;
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

    private String deprtm;

    @javax.persistence.Column(name = "DEPRTM")
    @Basic
    public String getDeprtm() {
        return deprtm;
    }

    public void setDeprtm(String deprtm) {
        this.deprtm = deprtm;
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

    private String begdte;

    @javax.persistence.Column(name = "BEGDTE")
    @Basic
    public String getBegdte() {
        return begdte;
    }

    public void setBegdte(String begdte) {
        this.begdte = begdte;
    }

    private String enddte;

    @javax.persistence.Column(name = "ENDDTE")
    @Basic
    public String getEnddte() {
        return enddte;
    }

    public void setEnddte(String enddte) {
        this.enddte = enddte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WltEntity wltEntity = (WltEntity) o;

        if (begdte != null ? !begdte.equals(wltEntity.begdte) : wltEntity.begdte != null) return false;
        if (campus != null ? !campus.equals(wltEntity.campus) : wltEntity.campus != null) return false;
        if (crtdtec != null ? !crtdtec.equals(wltEntity.crtdtec) : wltEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(wltEntity.crtmod) : wltEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(wltEntity.crttime) : wltEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(wltEntity.crtuser) : wltEntity.crtuser != null) return false;
        if (deprtm != null ? !deprtm.equals(wltEntity.deprtm) : wltEntity.deprtm != null) return false;
        if (email != null ? !email.equals(wltEntity.email) : wltEntity.email != null) return false;
        if (enddte != null ? !enddte.equals(wltEntity.enddte) : wltEntity.enddte != null) return false;
        if (inactv != null ? !inactv.equals(wltEntity.inactv) : wltEntity.inactv != null) return false;
        if (leadnm != null ? !leadnm.equals(wltEntity.leadnm) : wltEntity.leadnm != null) return false;
        if (phonex != null ? !phonex.equals(wltEntity.phonex) : wltEntity.phonex != null) return false;
        if (phonum != null ? !phonum.equals(wltEntity.phonum) : wltEntity.phonum != null) return false;
        if (recstat != null ? !recstat.equals(wltEntity.recstat) : wltEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(wltEntity.revdtec) : wltEntity.revdtec != null) return false;
        if (revlev != null ? !revlev.equals(wltEntity.revlev) : wltEntity.revlev != null) return false;
        if (revmod != null ? !revmod.equals(wltEntity.revmod) : wltEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(wltEntity.revtime) : wltEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(wltEntity.revuser) : wltEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(wltEntity.sid) : wltEntity.sid != null) return false;
        if (tname != null ? !tname.equals(wltEntity.tname) : wltEntity.tname != null) return false;
        if (ucode != null ? !ucode.equals(wltEntity.ucode) : wltEntity.ucode != null) return false;
        if (usrcd1 != null ? !usrcd1.equals(wltEntity.usrcd1) : wltEntity.usrcd1 != null) return false;
        if (usrcd2 != null ? !usrcd2.equals(wltEntity.usrcd2) : wltEntity.usrcd2 != null) return false;
        if (usrcd3 != null ? !usrcd3.equals(wltEntity.usrcd3) : wltEntity.usrcd3 != null) return false;
        if (usrcd4 != null ? !usrcd4.equals(wltEntity.usrcd4) : wltEntity.usrcd4 != null) return false;
        if (usrcd5 != null ? !usrcd5.equals(wltEntity.usrcd5) : wltEntity.usrcd5 != null) return false;
        if (usrcd6 != null ? !usrcd6.equals(wltEntity.usrcd6) : wltEntity.usrcd6 != null) return false;
        if (usrcd7 != null ? !usrcd7.equals(wltEntity.usrcd7) : wltEntity.usrcd7 != null) return false;
        if (usrcd8 != null ? !usrcd8.equals(wltEntity.usrcd8) : wltEntity.usrcd8 != null) return false;
        if (usrcd9 != null ? !usrcd9.equals(wltEntity.usrcd9) : wltEntity.usrcd9 != null) return false;
        if (usrcda != null ? !usrcda.equals(wltEntity.usrcda) : wltEntity.usrcda != null) return false;
        if (usrcdb != null ? !usrcdb.equals(wltEntity.usrcdb) : wltEntity.usrcdb != null) return false;
        if (usrcdc != null ? !usrcdc.equals(wltEntity.usrcdc) : wltEntity.usrcdc != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(wltEntity.usrdt1) : wltEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(wltEntity.usrdt2) : wltEntity.usrdt2 != null) return false;
        if (usrdt3 != null ? !usrdt3.equals(wltEntity.usrdt3) : wltEntity.usrdt3 != null) return false;
        if (usrdt4 != null ? !usrdt4.equals(wltEntity.usrdt4) : wltEntity.usrdt4 != null) return false;
        if (usrdt5 != null ? !usrdt5.equals(wltEntity.usrdt5) : wltEntity.usrdt5 != null) return false;
        if (usrdt6 != null ? !usrdt6.equals(wltEntity.usrdt6) : wltEntity.usrdt6 != null) return false;
        if (usrdt7 != null ? !usrdt7.equals(wltEntity.usrdt7) : wltEntity.usrdt7 != null) return false;
        if (usrdt8 != null ? !usrdt8.equals(wltEntity.usrdt8) : wltEntity.usrdt8 != null) return false;
        if (usrnr1 != null ? !usrnr1.equals(wltEntity.usrnr1) : wltEntity.usrnr1 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(wltEntity.usrnr2) : wltEntity.usrnr2 != null) return false;
        if (usrnr3 != null ? !usrnr3.equals(wltEntity.usrnr3) : wltEntity.usrnr3 != null) return false;
        if (usrnr4 != null ? !usrnr4.equals(wltEntity.usrnr4) : wltEntity.usrnr4 != null) return false;
        if (usrnr5 != null ? !usrnr5.equals(wltEntity.usrnr5) : wltEntity.usrnr5 != null) return false;
        if (usrnr6 != null ? !usrnr6.equals(wltEntity.usrnr6) : wltEntity.usrnr6 != null) return false;
        if (usrnr7 != null ? !usrnr7.equals(wltEntity.usrnr7) : wltEntity.usrnr7 != null) return false;
        if (usrnr8 != null ? !usrnr8.equals(wltEntity.usrnr8) : wltEntity.usrnr8 != null) return false;
        if (wltkey != null ? !wltkey.equals(wltEntity.wltkey) : wltEntity.wltkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (wltkey != null ? wltkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (crtdtec != null ? crtdtec.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (usrnr1 != null ? usrnr1.hashCode() : 0);
        result = 31 * result + (usrnr2 != null ? usrnr2.hashCode() : 0);
        result = 31 * result + (usrnr3 != null ? usrnr3.hashCode() : 0);
        result = 31 * result + (usrnr4 != null ? usrnr4.hashCode() : 0);
        result = 31 * result + (usrnr5 != null ? usrnr5.hashCode() : 0);
        result = 31 * result + (usrnr6 != null ? usrnr6.hashCode() : 0);
        result = 31 * result + (usrnr7 != null ? usrnr7.hashCode() : 0);
        result = 31 * result + (usrnr8 != null ? usrnr8.hashCode() : 0);
        result = 31 * result + (usrcd1 != null ? usrcd1.hashCode() : 0);
        result = 31 * result + (usrcd2 != null ? usrcd2.hashCode() : 0);
        result = 31 * result + (usrcd3 != null ? usrcd3.hashCode() : 0);
        result = 31 * result + (usrcd4 != null ? usrcd4.hashCode() : 0);
        result = 31 * result + (usrcd5 != null ? usrcd5.hashCode() : 0);
        result = 31 * result + (usrcd6 != null ? usrcd6.hashCode() : 0);
        result = 31 * result + (usrcd7 != null ? usrcd7.hashCode() : 0);
        result = 31 * result + (usrcd8 != null ? usrcd8.hashCode() : 0);
        result = 31 * result + (usrcd9 != null ? usrcd9.hashCode() : 0);
        result = 31 * result + (usrcda != null ? usrcda.hashCode() : 0);
        result = 31 * result + (usrcdb != null ? usrcdb.hashCode() : 0);
        result = 31 * result + (usrcdc != null ? usrcdc.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (usrdt2 != null ? usrdt2.hashCode() : 0);
        result = 31 * result + (usrdt3 != null ? usrdt3.hashCode() : 0);
        result = 31 * result + (usrdt4 != null ? usrdt4.hashCode() : 0);
        result = 31 * result + (usrdt5 != null ? usrdt5.hashCode() : 0);
        result = 31 * result + (usrdt6 != null ? usrdt6.hashCode() : 0);
        result = 31 * result + (usrdt7 != null ? usrdt7.hashCode() : 0);
        result = 31 * result + (usrdt8 != null ? usrdt8.hashCode() : 0);
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        result = 31 * result + (leadnm != null ? leadnm.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (inactv != null ? inactv.hashCode() : 0);
        result = 31 * result + (phonum != null ? phonum.hashCode() : 0);
        result = 31 * result + (phonex != null ? phonex.hashCode() : 0);
        result = 31 * result + (deprtm != null ? deprtm.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (begdte != null ? begdte.hashCode() : 0);
        result = 31 * result + (enddte != null ? enddte.hashCode() : 0);
        return result;
    }
}
