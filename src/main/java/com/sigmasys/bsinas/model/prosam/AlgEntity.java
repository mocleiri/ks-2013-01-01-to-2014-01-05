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
@javax.persistence.Table(name = "ALG", schema = "SIGMA", catalog = "")
@Entity
public class AlgEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getAlgkey();
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

    private String algkey;

    @javax.persistence.Column(name = "ALGKEY")
    @Id
    public String getAlgkey() {
        return algkey;
    }

    public void setAlgkey(String algkey) {
        this.algkey = algkey;
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

    private String atype;

    @javax.persistence.Column(name = "ATYPE")
    @Basic
    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
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

    private String acode;

    @javax.persistence.Column(name = "ACODE")
    @Basic
    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }

    private int seqno;

    @javax.persistence.Column(name = "SEQNO")
    @Basic
    public int getSeqno() {
        return seqno;
    }

    public void setSeqno(int seqno) {
        this.seqno = seqno;
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

    private String actdtec;

    @javax.persistence.Column(name = "ACTDTEC")
    @Basic
    public String getActdtec() {
        return actdtec;
    }

    public void setActdtec(String actdtec) {
        this.actdtec = actdtec;
    }

    private String acttime;

    @javax.persistence.Column(name = "ACTTIME")
    @Basic
    public String getActtime() {
        return acttime;
    }

    public void setActtime(String acttime) {
        this.acttime = acttime;
    }

    private String adesc;

    @javax.persistence.Column(name = "ADESC")
    @Basic
    public String getAdesc() {
        return adesc;
    }

    public void setAdesc(String adesc) {
        this.adesc = adesc;
    }

    private String adesctp;

    @javax.persistence.Column(name = "ADESCTP")
    @Basic
    public String getAdesctp() {
        return adesctp;
    }

    public void setAdesctp(String adesctp) {
        this.adesctp = adesctp;
    }

    private String aalert;

    @javax.persistence.Column(name = "AALERT")
    @Basic
    public String getAalert() {
        return aalert;
    }

    public void setAalert(String aalert) {
        this.aalert = aalert;
    }

    private String aprivacy;

    @javax.persistence.Column(name = "APRIVACY")
    @Basic
    public String getAprivacy() {
        return aprivacy;
    }

    public void setAprivacy(String aprivacy) {
        this.aprivacy = aprivacy;
    }

    private String aclear;

    @javax.persistence.Column(name = "ACLEAR")
    @Basic
    public String getAclear() {
        return aclear;
    }

    public void setAclear(String aclear) {
        this.aclear = aclear;
    }

    private String aclrdtc;

    @javax.persistence.Column(name = "ACLRDTC")
    @Basic
    public String getAclrdtc() {
        return aclrdtc;
    }

    public void setAclrdtc(String aclrdtc) {
        this.aclrdtc = aclrdtc;
    }

    private BigDecimal atrnamt;

    @javax.persistence.Column(name = "ATRNAMT")
    @Basic
    public BigDecimal getAtrnamt() {
        return atrnamt;
    }

    public void setAtrnamt(BigDecimal atrnamt) {
        this.atrnamt = atrnamt;
    }

    private int atrncnt;

    @javax.persistence.Column(name = "ATRNCNT")
    @Basic
    public int getAtrncnt() {
        return atrncnt;
    }

    public void setAtrncnt(int atrncnt) {
        this.atrncnt = atrncnt;
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

    private String stuid;

    @javax.persistence.Column(name = "STUID")
    @Basic
    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    private String statcd;

    @javax.persistence.Column(name = "STATCD")
    @Basic
    public String getStatcd() {
        return statcd;
    }

    public void setStatcd(String statcd) {
        this.statcd = statcd;
    }

    private String procst;

    @javax.persistence.Column(name = "PROCST")
    @Basic
    public String getProcst() {
        return procst;
    }

    public void setProcst(String procst) {
        this.procst = procst;
    }

    private String aclrtm;

    @javax.persistence.Column(name = "ACLRTM")
    @Basic
    public String getAclrtm() {
        return aclrtm;
    }

    public void setAclrtm(String aclrtm) {
        this.aclrtm = aclrtm;
    }

    private String effdte;

    @javax.persistence.Column(name = "EFFDTE")
    @Basic
    public String getEffdte() {
        return effdte;
    }

    public void setEffdte(String effdte) {
        this.effdte = effdte;
    }

    private String efftme;

    @javax.persistence.Column(name = "EFFTME")
    @Basic
    public String getEfftme() {
        return efftme;
    }

    public void setEfftme(String efftme) {
        this.efftme = efftme;
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

    private String endtme;

    @javax.persistence.Column(name = "ENDTME")
    @Basic
    public String getEndtme() {
        return endtme;
    }

    public void setEndtme(String endtme) {
        this.endtme = endtme;
    }

    private BigDecimal slahrs;

    @javax.persistence.Column(name = "SLAHRS")
    @Basic
    public BigDecimal getSlahrs() {
        return slahrs;
    }

    public void setSlahrs(BigDecimal slahrs) {
        this.slahrs = slahrs;
    }

    private String sladte;

    @javax.persistence.Column(name = "SLADTE")
    @Basic
    public String getSladte() {
        return sladte;
    }

    public void setSladte(String sladte) {
        this.sladte = sladte;
    }

    private String slatme;

    @javax.persistence.Column(name = "SLATME")
    @Basic
    public String getSlatme() {
        return slatme;
    }

    public void setSlatme(String slatme) {
        this.slatme = slatme;
    }

    private String slamet;

    @javax.persistence.Column(name = "SLAMET")
    @Basic
    public String getSlamet() {
        return slamet;
    }

    public void setSlamet(String slamet) {
        this.slamet = slamet;
    }

    private String diflvl;

    @javax.persistence.Column(name = "DIFLVL")
    @Basic
    public String getDiflvl() {
        return diflvl;
    }

    public void setDiflvl(String diflvl) {
        this.diflvl = diflvl;
    }

    private String clrdte;

    @javax.persistence.Column(name = "CLRDTE")
    @Basic
    public String getClrdte() {
        return clrdte;
    }

    public void setClrdte(String clrdte) {
        this.clrdte = clrdte;
    }

    private String mrefid;

    @javax.persistence.Column(name = "MREFID")
    @Basic
    public String getMrefid() {
        return mrefid;
    }

    public void setMrefid(String mrefid) {
        this.mrefid = mrefid;
    }

    private String ereftp;

    @javax.persistence.Column(name = "EREFTP")
    @Basic
    public String getEreftp() {
        return ereftp;
    }

    public void setEreftp(String ereftp) {
        this.ereftp = ereftp;
    }

    private String erefid;

    @javax.persistence.Column(name = "EREFID")
    @Basic
    public String getErefid() {
        return erefid;
    }

    public void setErefid(String erefid) {
        this.erefid = erefid;
    }

    private int wlctot;

    @javax.persistence.Column(name = "WLCTOT")
    @Basic
    public int getWlctot() {
        return wlctot;
    }

    public void setWlctot(int wlctot) {
        this.wlctot = wlctot;
    }

    private int wlcign;

    @javax.persistence.Column(name = "WLCIGN")
    @Basic
    public int getWlcign() {
        return wlcign;
    }

    public void setWlcign(int wlcign) {
        this.wlcign = wlcign;
    }

    private int wlcuna;

    @javax.persistence.Column(name = "WLCUNA")
    @Basic
    public int getWlcuna() {
        return wlcuna;
    }

    public void setWlcuna(int wlcuna) {
        this.wlcuna = wlcuna;
    }

    private int wlccmp;

    @javax.persistence.Column(name = "WLCCMP")
    @Basic
    public int getWlccmp() {
        return wlccmp;
    }

    public void setWlccmp(int wlccmp) {
        this.wlccmp = wlccmp;
    }

    private int wlcinc;

    @javax.persistence.Column(name = "WLCINC")
    @Basic
    public int getWlcinc() {
        return wlcinc;
    }

    public void setWlcinc(int wlcinc) {
        this.wlcinc = wlcinc;
    }

    private String hrefid;

    @javax.persistence.Column(name = "HREFID")
    @Basic
    public String getHrefid() {
        return hrefid;
    }

    public void setHrefid(String hrefid) {
        this.hrefid = hrefid;
    }

    private String srcid;

    @javax.persistence.Column(name = "SRCID")
    @Basic
    public String getSrcid() {
        return srcid;
    }

    public void setSrcid(String srcid) {
        this.srcid = srcid;
    }

    private String targid;

    @javax.persistence.Column(name = "TARGID")
    @Basic
    public String getTargid() {
        return targid;
    }

    public void setTargid(String targid) {
        this.targid = targid;
    }

    private String assnby;

    @javax.persistence.Column(name = "ASSNBY")
    @Basic
    public String getAssnby() {
        return assnby;
    }

    public void setAssnby(String assnby) {
        this.assnby = assnby;
    }

    private BigDecimal metnr1;

    @javax.persistence.Column(name = "METNR1")
    @Basic
    public BigDecimal getMetnr1() {
        return metnr1;
    }

    public void setMetnr1(BigDecimal metnr1) {
        this.metnr1 = metnr1;
    }

    private BigDecimal metnr2;

    @javax.persistence.Column(name = "METNR2")
    @Basic
    public BigDecimal getMetnr2() {
        return metnr2;
    }

    public void setMetnr2(BigDecimal metnr2) {
        this.metnr2 = metnr2;
    }

    private BigDecimal metnr3;

    @javax.persistence.Column(name = "METNR3")
    @Basic
    public BigDecimal getMetnr3() {
        return metnr3;
    }

    public void setMetnr3(BigDecimal metnr3) {
        this.metnr3 = metnr3;
    }

    private BigDecimal metrn4;

    @javax.persistence.Column(name = "METRN4")
    @Basic
    public BigDecimal getMetrn4() {
        return metrn4;
    }

    public void setMetrn4(BigDecimal metrn4) {
        this.metrn4 = metrn4;
    }

    private BigDecimal metnr5;

    @javax.persistence.Column(name = "METNR5")
    @Basic
    public BigDecimal getMetnr5() {
        return metnr5;
    }

    public void setMetnr5(BigDecimal metnr5) {
        this.metnr5 = metnr5;
    }

    private BigDecimal metnr6;

    @javax.persistence.Column(name = "METNR6")
    @Basic
    public BigDecimal getMetnr6() {
        return metnr6;
    }

    public void setMetnr6(BigDecimal metnr6) {
        this.metnr6 = metnr6;
    }

    private BigDecimal metnr7;

    @javax.persistence.Column(name = "METNR7")
    @Basic
    public BigDecimal getMetnr7() {
        return metnr7;
    }

    public void setMetnr7(BigDecimal metnr7) {
        this.metnr7 = metnr7;
    }

    private BigDecimal metnr8;

    @javax.persistence.Column(name = "METNR8")
    @Basic
    public BigDecimal getMetnr8() {
        return metnr8;
    }

    public void setMetnr8(BigDecimal metnr8) {
        this.metnr8 = metnr8;
    }

    private String psmmod;

    @javax.persistence.Column(name = "PSMMOD")
    @Basic
    public String getPsmmod() {
        return psmmod;
    }

    public void setPsmmod(String psmmod) {
        this.psmmod = psmmod;
    }

    private String metlb1;

    @javax.persistence.Column(name = "METLB1")
    @Basic
    public String getMetlb1() {
        return metlb1;
    }

    public void setMetlb1(String metlb1) {
        this.metlb1 = metlb1;
    }

    private String metlb2;

    @javax.persistence.Column(name = "METLB2")
    @Basic
    public String getMetlb2() {
        return metlb2;
    }

    public void setMetlb2(String metlb2) {
        this.metlb2 = metlb2;
    }

    private String metlb3;

    @javax.persistence.Column(name = "METLB3")
    @Basic
    public String getMetlb3() {
        return metlb3;
    }

    public void setMetlb3(String metlb3) {
        this.metlb3 = metlb3;
    }

    private String metlb4;

    @javax.persistence.Column(name = "METLB4")
    @Basic
    public String getMetlb4() {
        return metlb4;
    }

    public void setMetlb4(String metlb4) {
        this.metlb4 = metlb4;
    }

    private String metlb5;

    @javax.persistence.Column(name = "METLB5")
    @Basic
    public String getMetlb5() {
        return metlb5;
    }

    public void setMetlb5(String metlb5) {
        this.metlb5 = metlb5;
    }

    private String metlb6;

    @javax.persistence.Column(name = "METLB6")
    @Basic
    public String getMetlb6() {
        return metlb6;
    }

    public void setMetlb6(String metlb6) {
        this.metlb6 = metlb6;
    }

    private String metlb7;

    @javax.persistence.Column(name = "METLB7")
    @Basic
    public String getMetlb7() {
        return metlb7;
    }

    public void setMetlb7(String metlb7) {
        this.metlb7 = metlb7;
    }

    private String metlb8;

    @javax.persistence.Column(name = "METLB8")
    @Basic
    public String getMetlb8() {
        return metlb8;
    }

    public void setMetlb8(String metlb8) {
        this.metlb8 = metlb8;
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

    private BigInteger prtyrk;

    @javax.persistence.Column(name = "PRTYRK")
    @Basic
    public BigInteger getPrtyrk() {
        return prtyrk;
    }

    public void setPrtyrk(BigInteger prtyrk) {
        this.prtyrk = prtyrk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlgEntity algEntity = (AlgEntity) o;

        if (atrncnt != algEntity.atrncnt) return false;
        if (revlev != algEntity.revlev) return false;
        if (seqno != algEntity.seqno) return false;
        if (wlccmp != algEntity.wlccmp) return false;
        if (wlcign != algEntity.wlcign) return false;
        if (wlcinc != algEntity.wlcinc) return false;
        if (wlctot != algEntity.wlctot) return false;
        if (wlcuna != algEntity.wlcuna) return false;
        if (aalert != null ? !aalert.equals(algEntity.aalert) : algEntity.aalert != null) return false;
        if (aclear != null ? !aclear.equals(algEntity.aclear) : algEntity.aclear != null) return false;
        if (aclrdtc != null ? !aclrdtc.equals(algEntity.aclrdtc) : algEntity.aclrdtc != null) return false;
        if (aclrtm != null ? !aclrtm.equals(algEntity.aclrtm) : algEntity.aclrtm != null) return false;
        if (acode != null ? !acode.equals(algEntity.acode) : algEntity.acode != null) return false;
        if (actdtec != null ? !actdtec.equals(algEntity.actdtec) : algEntity.actdtec != null) return false;
        if (acttime != null ? !acttime.equals(algEntity.acttime) : algEntity.acttime != null) return false;
        if (adesc != null ? !adesc.equals(algEntity.adesc) : algEntity.adesc != null) return false;
        if (adesctp != null ? !adesctp.equals(algEntity.adesctp) : algEntity.adesctp != null) return false;
        if (aidid != null ? !aidid.equals(algEntity.aidid) : algEntity.aidid != null) return false;
        if (algkey != null ? !algkey.equals(algEntity.algkey) : algEntity.algkey != null) return false;
        if (aprivacy != null ? !aprivacy.equals(algEntity.aprivacy) : algEntity.aprivacy != null) return false;
        if (assnby != null ? !assnby.equals(algEntity.assnby) : algEntity.assnby != null) return false;
        if (atrnamt != null ? !atrnamt.equals(algEntity.atrnamt) : algEntity.atrnamt != null) return false;
        if (atype != null ? !atype.equals(algEntity.atype) : algEntity.atype != null) return false;
        if (catgory != null ? !catgory.equals(algEntity.catgory) : algEntity.catgory != null) return false;
        if (clrdte != null ? !clrdte.equals(algEntity.clrdte) : algEntity.clrdte != null) return false;
        if (crtdtec != null ? !crtdtec.equals(algEntity.crtdtec) : algEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(algEntity.crtmod) : algEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(algEntity.crttime) : algEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(algEntity.crtuser) : algEntity.crtuser != null) return false;
        if (diflvl != null ? !diflvl.equals(algEntity.diflvl) : algEntity.diflvl != null) return false;
        if (effdte != null ? !effdte.equals(algEntity.effdte) : algEntity.effdte != null) return false;
        if (efftme != null ? !efftme.equals(algEntity.efftme) : algEntity.efftme != null) return false;
        if (enddte != null ? !enddte.equals(algEntity.enddte) : algEntity.enddte != null) return false;
        if (endtme != null ? !endtme.equals(algEntity.endtme) : algEntity.endtme != null) return false;
        if (erefid != null ? !erefid.equals(algEntity.erefid) : algEntity.erefid != null) return false;
        if (ereftp != null ? !ereftp.equals(algEntity.ereftp) : algEntity.ereftp != null) return false;
        if (hrefid != null ? !hrefid.equals(algEntity.hrefid) : algEntity.hrefid != null) return false;
        if (instid != null ? !instid.equals(algEntity.instid) : algEntity.instid != null) return false;
        if (metlb1 != null ? !metlb1.equals(algEntity.metlb1) : algEntity.metlb1 != null) return false;
        if (metlb2 != null ? !metlb2.equals(algEntity.metlb2) : algEntity.metlb2 != null) return false;
        if (metlb3 != null ? !metlb3.equals(algEntity.metlb3) : algEntity.metlb3 != null) return false;
        if (metlb4 != null ? !metlb4.equals(algEntity.metlb4) : algEntity.metlb4 != null) return false;
        if (metlb5 != null ? !metlb5.equals(algEntity.metlb5) : algEntity.metlb5 != null) return false;
        if (metlb6 != null ? !metlb6.equals(algEntity.metlb6) : algEntity.metlb6 != null) return false;
        if (metlb7 != null ? !metlb7.equals(algEntity.metlb7) : algEntity.metlb7 != null) return false;
        if (metlb8 != null ? !metlb8.equals(algEntity.metlb8) : algEntity.metlb8 != null) return false;
        if (metnr1 != null ? !metnr1.equals(algEntity.metnr1) : algEntity.metnr1 != null) return false;
        if (metnr2 != null ? !metnr2.equals(algEntity.metnr2) : algEntity.metnr2 != null) return false;
        if (metnr3 != null ? !metnr3.equals(algEntity.metnr3) : algEntity.metnr3 != null) return false;
        if (metnr5 != null ? !metnr5.equals(algEntity.metnr5) : algEntity.metnr5 != null) return false;
        if (metnr6 != null ? !metnr6.equals(algEntity.metnr6) : algEntity.metnr6 != null) return false;
        if (metnr7 != null ? !metnr7.equals(algEntity.metnr7) : algEntity.metnr7 != null) return false;
        if (metnr8 != null ? !metnr8.equals(algEntity.metnr8) : algEntity.metnr8 != null) return false;
        if (metrn4 != null ? !metrn4.equals(algEntity.metrn4) : algEntity.metrn4 != null) return false;
        if (mrefid != null ? !mrefid.equals(algEntity.mrefid) : algEntity.mrefid != null) return false;
        if (procst != null ? !procst.equals(algEntity.procst) : algEntity.procst != null) return false;
        if (procyr != null ? !procyr.equals(algEntity.procyr) : algEntity.procyr != null) return false;
        if (prtyrk != null ? !prtyrk.equals(algEntity.prtyrk) : algEntity.prtyrk != null) return false;
        if (psmmod != null ? !psmmod.equals(algEntity.psmmod) : algEntity.psmmod != null) return false;
        if (ptype != null ? !ptype.equals(algEntity.ptype) : algEntity.ptype != null) return false;
        if (recstat != null ? !recstat.equals(algEntity.recstat) : algEntity.recstat != null) return false;
        if (revdtec != null ? !revdtec.equals(algEntity.revdtec) : algEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(algEntity.revmod) : algEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(algEntity.revtime) : algEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(algEntity.revuser) : algEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(algEntity.sid) : algEntity.sid != null) return false;
        if (sladte != null ? !sladte.equals(algEntity.sladte) : algEntity.sladte != null) return false;
        if (slahrs != null ? !slahrs.equals(algEntity.slahrs) : algEntity.slahrs != null) return false;
        if (slamet != null ? !slamet.equals(algEntity.slamet) : algEntity.slamet != null) return false;
        if (slatme != null ? !slatme.equals(algEntity.slatme) : algEntity.slatme != null) return false;
        if (srcid != null ? !srcid.equals(algEntity.srcid) : algEntity.srcid != null) return false;
        if (statcd != null ? !statcd.equals(algEntity.statcd) : algEntity.statcd != null) return false;
        if (stuid != null ? !stuid.equals(algEntity.stuid) : algEntity.stuid != null) return false;
        if (targid != null ? !targid.equals(algEntity.targid) : algEntity.targid != null) return false;
        if (term != null ? !term.equals(algEntity.term) : algEntity.term != null) return false;
        if (ucode != null ? !ucode.equals(algEntity.ucode) : algEntity.ucode != null) return false;
        if (usrcd1 != null ? !usrcd1.equals(algEntity.usrcd1) : algEntity.usrcd1 != null) return false;
        if (usrcd2 != null ? !usrcd2.equals(algEntity.usrcd2) : algEntity.usrcd2 != null) return false;
        if (usrcd3 != null ? !usrcd3.equals(algEntity.usrcd3) : algEntity.usrcd3 != null) return false;
        if (usrcd4 != null ? !usrcd4.equals(algEntity.usrcd4) : algEntity.usrcd4 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(algEntity.usrdt1) : algEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(algEntity.usrdt2) : algEntity.usrdt2 != null) return false;
        if (usrdt3 != null ? !usrdt3.equals(algEntity.usrdt3) : algEntity.usrdt3 != null) return false;
        if (usrdt4 != null ? !usrdt4.equals(algEntity.usrdt4) : algEntity.usrdt4 != null) return false;
        if (usrdt5 != null ? !usrdt5.equals(algEntity.usrdt5) : algEntity.usrdt5 != null) return false;
        if (usrnr1 != null ? !usrnr1.equals(algEntity.usrnr1) : algEntity.usrnr1 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(algEntity.usrnr2) : algEntity.usrnr2 != null) return false;
        if (usrnr3 != null ? !usrnr3.equals(algEntity.usrnr3) : algEntity.usrnr3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (algkey != null ? algkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (atype != null ? atype.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (procyr != null ? procyr.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (catgory != null ? catgory.hashCode() : 0);
        result = 31 * result + (acode != null ? acode.hashCode() : 0);
        result = 31 * result + seqno;
        result = 31 * result + (crtdtec != null ? crtdtec.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (revdtec != null ? revdtec.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (actdtec != null ? actdtec.hashCode() : 0);
        result = 31 * result + (acttime != null ? acttime.hashCode() : 0);
        result = 31 * result + (adesc != null ? adesc.hashCode() : 0);
        result = 31 * result + (adesctp != null ? adesctp.hashCode() : 0);
        result = 31 * result + (aalert != null ? aalert.hashCode() : 0);
        result = 31 * result + (aprivacy != null ? aprivacy.hashCode() : 0);
        result = 31 * result + (aclear != null ? aclear.hashCode() : 0);
        result = 31 * result + (aclrdtc != null ? aclrdtc.hashCode() : 0);
        result = 31 * result + (atrnamt != null ? atrnamt.hashCode() : 0);
        result = 31 * result + atrncnt;
        result = 31 * result + (aidid != null ? aidid.hashCode() : 0);
        result = 31 * result + (ptype != null ? ptype.hashCode() : 0);
        result = 31 * result + (usrnr1 != null ? usrnr1.hashCode() : 0);
        result = 31 * result + (usrnr2 != null ? usrnr2.hashCode() : 0);
        result = 31 * result + (usrnr3 != null ? usrnr3.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (usrdt2 != null ? usrdt2.hashCode() : 0);
        result = 31 * result + (usrcd1 != null ? usrcd1.hashCode() : 0);
        result = 31 * result + (usrcd2 != null ? usrcd2.hashCode() : 0);
        result = 31 * result + (usrcd3 != null ? usrcd3.hashCode() : 0);
        result = 31 * result + (usrcd4 != null ? usrcd4.hashCode() : 0);
        result = 31 * result + (stuid != null ? stuid.hashCode() : 0);
        result = 31 * result + (statcd != null ? statcd.hashCode() : 0);
        result = 31 * result + (procst != null ? procst.hashCode() : 0);
        result = 31 * result + (aclrtm != null ? aclrtm.hashCode() : 0);
        result = 31 * result + (effdte != null ? effdte.hashCode() : 0);
        result = 31 * result + (efftme != null ? efftme.hashCode() : 0);
        result = 31 * result + (enddte != null ? enddte.hashCode() : 0);
        result = 31 * result + (endtme != null ? endtme.hashCode() : 0);
        result = 31 * result + (slahrs != null ? slahrs.hashCode() : 0);
        result = 31 * result + (sladte != null ? sladte.hashCode() : 0);
        result = 31 * result + (slatme != null ? slatme.hashCode() : 0);
        result = 31 * result + (slamet != null ? slamet.hashCode() : 0);
        result = 31 * result + (diflvl != null ? diflvl.hashCode() : 0);
        result = 31 * result + (clrdte != null ? clrdte.hashCode() : 0);
        result = 31 * result + (mrefid != null ? mrefid.hashCode() : 0);
        result = 31 * result + (ereftp != null ? ereftp.hashCode() : 0);
        result = 31 * result + (erefid != null ? erefid.hashCode() : 0);
        result = 31 * result + wlctot;
        result = 31 * result + wlcign;
        result = 31 * result + wlcuna;
        result = 31 * result + wlccmp;
        result = 31 * result + wlcinc;
        result = 31 * result + (hrefid != null ? hrefid.hashCode() : 0);
        result = 31 * result + (srcid != null ? srcid.hashCode() : 0);
        result = 31 * result + (targid != null ? targid.hashCode() : 0);
        result = 31 * result + (assnby != null ? assnby.hashCode() : 0);
        result = 31 * result + (metnr1 != null ? metnr1.hashCode() : 0);
        result = 31 * result + (metnr2 != null ? metnr2.hashCode() : 0);
        result = 31 * result + (metnr3 != null ? metnr3.hashCode() : 0);
        result = 31 * result + (metrn4 != null ? metrn4.hashCode() : 0);
        result = 31 * result + (metnr5 != null ? metnr5.hashCode() : 0);
        result = 31 * result + (metnr6 != null ? metnr6.hashCode() : 0);
        result = 31 * result + (metnr7 != null ? metnr7.hashCode() : 0);
        result = 31 * result + (metnr8 != null ? metnr8.hashCode() : 0);
        result = 31 * result + (psmmod != null ? psmmod.hashCode() : 0);
        result = 31 * result + (metlb1 != null ? metlb1.hashCode() : 0);
        result = 31 * result + (metlb2 != null ? metlb2.hashCode() : 0);
        result = 31 * result + (metlb3 != null ? metlb3.hashCode() : 0);
        result = 31 * result + (metlb4 != null ? metlb4.hashCode() : 0);
        result = 31 * result + (metlb5 != null ? metlb5.hashCode() : 0);
        result = 31 * result + (metlb6 != null ? metlb6.hashCode() : 0);
        result = 31 * result + (metlb7 != null ? metlb7.hashCode() : 0);
        result = 31 * result + (metlb8 != null ? metlb8.hashCode() : 0);
        result = 31 * result + (usrdt3 != null ? usrdt3.hashCode() : 0);
        result = 31 * result + (usrdt4 != null ? usrdt4.hashCode() : 0);
        result = 31 * result + (usrdt5 != null ? usrdt5.hashCode() : 0);
        result = 31 * result + (prtyrk != null ? prtyrk.hashCode() : 0);
        return result;
    }
}
