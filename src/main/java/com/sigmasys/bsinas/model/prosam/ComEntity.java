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
 * Date: 11/25/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "COM", schema = "SIGMA", catalog = "")
@Entity
public class ComEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getComkey();
    }

    private String comkey;

    @javax.persistence.Column(name = "COMKEY")
    @Id
    public String getComkey() {
        return comkey;
    }

    public void setComkey(String comkey) {
        this.comkey = comkey;
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

    private String comtype;

    @javax.persistence.Column(name = "COMTYPE")
    @Basic
    public String getComtype() {
        return comtype;
    }

    public void setComtype(String comtype) {
        this.comtype = comtype;
    }

    private String adtype;

    @javax.persistence.Column(name = "ADTYPE")
    @Basic
    public String getAdtype() {
        return adtype;
    }

    public void setAdtype(String adtype) {
        this.adtype = adtype;
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

    private String status;

    @javax.persistence.Column(name = "STATUS")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String effdate;

    @javax.persistence.Column(name = "EFFDATE")
    @Basic
    public String getEffdate() {
        return effdate;
    }

    public void setEffdate(String effdate) {
        this.effdate = effdate;
    }

    private String expdate;

    @javax.persistence.Column(name = "EXPDATE")
    @Basic
    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    private String comaddr;

    @javax.persistence.Column(name = "COMADDR")
    @Basic
    public String getComaddr() {
        return comaddr;
    }

    public void setComaddr(String comaddr) {
        this.comaddr = comaddr;
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

    private int usernr1;

    @javax.persistence.Column(name = "USERNR1")
    @Basic
    public int getUsernr1() {
        return usernr1;
    }

    public void setUsernr1(int usernr1) {
        this.usernr1 = usernr1;
    }

    private BigDecimal usernr2;

    @javax.persistence.Column(name = "USERNR2")
    @Basic
    public BigDecimal getUsernr2() {
        return usernr2;
    }

    public void setUsernr2(BigDecimal usernr2) {
        this.usernr2 = usernr2;
    }

    private String userdt1;

    @javax.persistence.Column(name = "USERDT1")
    @Basic
    public String getUserdt1() {
        return userdt1;
    }

    public void setUserdt1(String userdt1) {
        this.userdt1 = userdt1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComEntity comEntity = (ComEntity) o;

        if (revlev != comEntity.revlev) return false;
        if (usernr1 != comEntity.usernr1) return false;
        if (adtype != null ? !adtype.equals(comEntity.adtype) : comEntity.adtype != null) return false;
        if (comaddr != null ? !comaddr.equals(comEntity.comaddr) : comEntity.comaddr != null) return false;
        if (comkey != null ? !comkey.equals(comEntity.comkey) : comEntity.comkey != null) return false;
        if (comtype != null ? !comtype.equals(comEntity.comtype) : comEntity.comtype != null) return false;
        if (crtdtec != null ? !crtdtec.equals(comEntity.crtdtec) : comEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(comEntity.crtmod) : comEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(comEntity.crttime) : comEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(comEntity.crtuser) : comEntity.crtuser != null) return false;
        if (effdate != null ? !effdate.equals(comEntity.effdate) : comEntity.effdate != null) return false;
        if (expdate != null ? !expdate.equals(comEntity.expdate) : comEntity.expdate != null) return false;
        if (instid != null ? !instid.equals(comEntity.instid) : comEntity.instid != null) return false;
        if (revdtec != null ? !revdtec.equals(comEntity.revdtec) : comEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(comEntity.revmod) : comEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(comEntity.revtime) : comEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(comEntity.revuser) : comEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(comEntity.sid) : comEntity.sid != null) return false;
        if (status != null ? !status.equals(comEntity.status) : comEntity.status != null) return false;
        if (ucode != null ? !ucode.equals(comEntity.ucode) : comEntity.ucode != null) return false;
        if (usercd1 != null ? !usercd1.equals(comEntity.usercd1) : comEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(comEntity.usercd2) : comEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(comEntity.usercd3) : comEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(comEntity.usercd4) : comEntity.usercd4 != null) return false;
        if (userdt1 != null ? !userdt1.equals(comEntity.userdt1) : comEntity.userdt1 != null) return false;
        if (usernr2 != null ? !usernr2.equals(comEntity.usernr2) : comEntity.usernr2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = comkey != null ? comkey.hashCode() : 0;
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (comtype != null ? comtype.hashCode() : 0);
        result = 31 * result + (adtype != null ? adtype.hashCode() : 0);
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
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (effdate != null ? effdate.hashCode() : 0);
        result = 31 * result + (expdate != null ? expdate.hashCode() : 0);
        result = 31 * result + (comaddr != null ? comaddr.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + usernr1;
        result = 31 * result + (usernr2 != null ? usernr2.hashCode() : 0);
        result = 31 * result + (userdt1 != null ? userdt1.hashCode() : 0);
        return result;
    }
}
