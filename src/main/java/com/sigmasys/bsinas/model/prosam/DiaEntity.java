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
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DIA", schema = "SIGMA", catalog = "")
@Entity
public class DiaEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getDiakey();
    }

    private String diakey;

    @javax.persistence.Column(name = "DIAKEY")
    @Id
    public String getDiakey() {
        return diakey;
    }

    public void setDiakey(String diakey) {
        this.diakey = diakey;
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

    private String procyr;

    @javax.persistence.Column(name = "PROCYR")
    @Basic
    public String getProcyr() {
        return procyr;
    }

    public void setProcyr(String procyr) {
        this.procyr = procyr;
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

    private String catgory;

    @javax.persistence.Column(name = "CATGORY")
    @Basic
    public String getCatgory() {
        return catgory;
    }

    public void setCatgory(String catgory) {
        this.catgory = catgory;
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

    private String code;

    @javax.persistence.Column(name = "CODE")
    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    private String mesg;

    @javax.persistence.Column(name = "MESG")
    @Basic
    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    private String webpage;

    @javax.persistence.Column(name = "WEBPAGE")
    @Basic
    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    private String cat01;

    @javax.persistence.Column(name = "CAT01")
    @Basic
    public String getCat01() {
        return cat01;
    }

    public void setCat01(String cat01) {
        this.cat01 = cat01;
    }

    private String cat02;

    @javax.persistence.Column(name = "CAT02")
    @Basic
    public String getCat02() {
        return cat02;
    }

    public void setCat02(String cat02) {
        this.cat02 = cat02;
    }

    private String cat03;

    @javax.persistence.Column(name = "CAT03")
    @Basic
    public String getCat03() {
        return cat03;
    }

    public void setCat03(String cat03) {
        this.cat03 = cat03;
    }

    private String cat04;

    @javax.persistence.Column(name = "CAT04")
    @Basic
    public String getCat04() {
        return cat04;
    }

    public void setCat04(String cat04) {
        this.cat04 = cat04;
    }

    private String cat05;

    @javax.persistence.Column(name = "CAT05")
    @Basic
    public String getCat05() {
        return cat05;
    }

    public void setCat05(String cat05) {
        this.cat05 = cat05;
    }

    private String cat06;

    @javax.persistence.Column(name = "CAT06")
    @Basic
    public String getCat06() {
        return cat06;
    }

    public void setCat06(String cat06) {
        this.cat06 = cat06;
    }

    private String cat07;

    @javax.persistence.Column(name = "CAT07")
    @Basic
    public String getCat07() {
        return cat07;
    }

    public void setCat07(String cat07) {
        this.cat07 = cat07;
    }

    private String cat08;

    @javax.persistence.Column(name = "CAT08")
    @Basic
    public String getCat08() {
        return cat08;
    }

    public void setCat08(String cat08) {
        this.cat08 = cat08;
    }

    private String cat09;

    @javax.persistence.Column(name = "CAT09")
    @Basic
    public String getCat09() {
        return cat09;
    }

    public void setCat09(String cat09) {
        this.cat09 = cat09;
    }

    private String cat10;

    @javax.persistence.Column(name = "CAT10")
    @Basic
    public String getCat10() {
        return cat10;
    }

    public void setCat10(String cat10) {
        this.cat10 = cat10;
    }

    private String cat11;

    @javax.persistence.Column(name = "CAT11")
    @Basic
    public String getCat11() {
        return cat11;
    }

    public void setCat11(String cat11) {
        this.cat11 = cat11;
    }

    private String cat12;

    @javax.persistence.Column(name = "CAT12")
    @Basic
    public String getCat12() {
        return cat12;
    }

    public void setCat12(String cat12) {
        this.cat12 = cat12;
    }

    private String cat13;

    @javax.persistence.Column(name = "CAT13")
    @Basic
    public String getCat13() {
        return cat13;
    }

    public void setCat13(String cat13) {
        this.cat13 = cat13;
    }

    private String cat14;

    @javax.persistence.Column(name = "CAT14")
    @Basic
    public String getCat14() {
        return cat14;
    }

    public void setCat14(String cat14) {
        this.cat14 = cat14;
    }

    private String cat15;

    @javax.persistence.Column(name = "CAT15")
    @Basic
    public String getCat15() {
        return cat15;
    }

    public void setCat15(String cat15) {
        this.cat15 = cat15;
    }

    private String cat16;

    @javax.persistence.Column(name = "CAT16")
    @Basic
    public String getCat16() {
        return cat16;
    }

    public void setCat16(String cat16) {
        this.cat16 = cat16;
    }

    private String cat17;

    @javax.persistence.Column(name = "CAT17")
    @Basic
    public String getCat17() {
        return cat17;
    }

    public void setCat17(String cat17) {
        this.cat17 = cat17;
    }

    private String cat18;

    @javax.persistence.Column(name = "CAT18")
    @Basic
    public String getCat18() {
        return cat18;
    }

    public void setCat18(String cat18) {
        this.cat18 = cat18;
    }

    private String cat19;

    @javax.persistence.Column(name = "CAT19")
    @Basic
    public String getCat19() {
        return cat19;
    }

    public void setCat19(String cat19) {
        this.cat19 = cat19;
    }

    private String cat20;

    @javax.persistence.Column(name = "CAT20")
    @Basic
    public String getCat20() {
        return cat20;
    }

    public void setCat20(String cat20) {
        this.cat20 = cat20;
    }

    private String alert;

    @javax.persistence.Column(name = "ALERT")
    @Basic
    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    private String prvacy;

    @javax.persistence.Column(name = "PRVACY")
    @Basic
    public String getPrvacy() {
        return prvacy;
    }

    public void setPrvacy(String prvacy) {
        this.prvacy = prvacy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiaEntity diaEntity = (DiaEntity) o;

        if (revlev != diaEntity.revlev) return false;
        if (aidid != null ? !aidid.equals(diaEntity.aidid) : diaEntity.aidid != null) return false;
        if (alert != null ? !alert.equals(diaEntity.alert) : diaEntity.alert != null) return false;
        if (cat01 != null ? !cat01.equals(diaEntity.cat01) : diaEntity.cat01 != null) return false;
        if (cat02 != null ? !cat02.equals(diaEntity.cat02) : diaEntity.cat02 != null) return false;
        if (cat03 != null ? !cat03.equals(diaEntity.cat03) : diaEntity.cat03 != null) return false;
        if (cat04 != null ? !cat04.equals(diaEntity.cat04) : diaEntity.cat04 != null) return false;
        if (cat05 != null ? !cat05.equals(diaEntity.cat05) : diaEntity.cat05 != null) return false;
        if (cat06 != null ? !cat06.equals(diaEntity.cat06) : diaEntity.cat06 != null) return false;
        if (cat07 != null ? !cat07.equals(diaEntity.cat07) : diaEntity.cat07 != null) return false;
        if (cat08 != null ? !cat08.equals(diaEntity.cat08) : diaEntity.cat08 != null) return false;
        if (cat09 != null ? !cat09.equals(diaEntity.cat09) : diaEntity.cat09 != null) return false;
        if (cat10 != null ? !cat10.equals(diaEntity.cat10) : diaEntity.cat10 != null) return false;
        if (cat11 != null ? !cat11.equals(diaEntity.cat11) : diaEntity.cat11 != null) return false;
        if (cat12 != null ? !cat12.equals(diaEntity.cat12) : diaEntity.cat12 != null) return false;
        if (cat13 != null ? !cat13.equals(diaEntity.cat13) : diaEntity.cat13 != null) return false;
        if (cat14 != null ? !cat14.equals(diaEntity.cat14) : diaEntity.cat14 != null) return false;
        if (cat15 != null ? !cat15.equals(diaEntity.cat15) : diaEntity.cat15 != null) return false;
        if (cat16 != null ? !cat16.equals(diaEntity.cat16) : diaEntity.cat16 != null) return false;
        if (cat17 != null ? !cat17.equals(diaEntity.cat17) : diaEntity.cat17 != null) return false;
        if (cat18 != null ? !cat18.equals(diaEntity.cat18) : diaEntity.cat18 != null) return false;
        if (cat19 != null ? !cat19.equals(diaEntity.cat19) : diaEntity.cat19 != null) return false;
        if (cat20 != null ? !cat20.equals(diaEntity.cat20) : diaEntity.cat20 != null) return false;
        if (catgory != null ? !catgory.equals(diaEntity.catgory) : diaEntity.catgory != null) return false;
        if (code != null ? !code.equals(diaEntity.code) : diaEntity.code != null) return false;
        if (crtdtec != null ? !crtdtec.equals(diaEntity.crtdtec) : diaEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(diaEntity.crtmod) : diaEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(diaEntity.crttime) : diaEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(diaEntity.crtuser) : diaEntity.crtuser != null) return false;
        if (diakey != null ? !diakey.equals(diaEntity.diakey) : diaEntity.diakey != null) return false;
        if (instid != null ? !instid.equals(diaEntity.instid) : diaEntity.instid != null) return false;
        if (mesg != null ? !mesg.equals(diaEntity.mesg) : diaEntity.mesg != null) return false;
        if (procyr != null ? !procyr.equals(diaEntity.procyr) : diaEntity.procyr != null) return false;
        if (prvacy != null ? !prvacy.equals(diaEntity.prvacy) : diaEntity.prvacy != null) return false;
        if (revdtec != null ? !revdtec.equals(diaEntity.revdtec) : diaEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(diaEntity.revmod) : diaEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(diaEntity.revtime) : diaEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(diaEntity.revuser) : diaEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(diaEntity.sid) : diaEntity.sid != null) return false;
        if (term != null ? !term.equals(diaEntity.term) : diaEntity.term != null) return false;
        if (ucode != null ? !ucode.equals(diaEntity.ucode) : diaEntity.ucode != null) return false;
        if (webpage != null ? !webpage.equals(diaEntity.webpage) : diaEntity.webpage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diakey != null ? diakey.hashCode() : 0;
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (catgory != null ? catgory.hashCode() : 0);
        result = 31 * result + (aidid != null ? aidid.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
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
        result = 31 * result + (mesg != null ? mesg.hashCode() : 0);
        result = 31 * result + (webpage != null ? webpage.hashCode() : 0);
        result = 31 * result + (cat01 != null ? cat01.hashCode() : 0);
        result = 31 * result + (cat02 != null ? cat02.hashCode() : 0);
        result = 31 * result + (cat03 != null ? cat03.hashCode() : 0);
        result = 31 * result + (cat04 != null ? cat04.hashCode() : 0);
        result = 31 * result + (cat05 != null ? cat05.hashCode() : 0);
        result = 31 * result + (cat06 != null ? cat06.hashCode() : 0);
        result = 31 * result + (cat07 != null ? cat07.hashCode() : 0);
        result = 31 * result + (cat08 != null ? cat08.hashCode() : 0);
        result = 31 * result + (cat09 != null ? cat09.hashCode() : 0);
        result = 31 * result + (cat10 != null ? cat10.hashCode() : 0);
        result = 31 * result + (cat11 != null ? cat11.hashCode() : 0);
        result = 31 * result + (cat12 != null ? cat12.hashCode() : 0);
        result = 31 * result + (cat13 != null ? cat13.hashCode() : 0);
        result = 31 * result + (cat14 != null ? cat14.hashCode() : 0);
        result = 31 * result + (cat15 != null ? cat15.hashCode() : 0);
        result = 31 * result + (cat16 != null ? cat16.hashCode() : 0);
        result = 31 * result + (cat17 != null ? cat17.hashCode() : 0);
        result = 31 * result + (cat18 != null ? cat18.hashCode() : 0);
        result = 31 * result + (cat19 != null ? cat19.hashCode() : 0);
        result = 31 * result + (cat20 != null ? cat20.hashCode() : 0);
        result = 31 * result + (alert != null ? alert.hashCode() : 0);
        result = 31 * result + (prvacy != null ? prvacy.hashCode() : 0);
        return result;
    }
}
