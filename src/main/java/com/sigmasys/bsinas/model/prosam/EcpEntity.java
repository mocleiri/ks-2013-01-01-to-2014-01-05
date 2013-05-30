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
@javax.persistence.Table(name = "ECP", schema = "SIGMA", catalog = "")
@Entity
public class EcpEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getEcpkey();
    }

    private String ecpkey;

    @javax.persistence.Column(name = "ECPKEY")
    @Id
    public String getEcpkey() {
        return ecpkey;
    }

    public void setEcpkey(String ecpkey) {
        this.ecpkey = ecpkey;
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

    private String ecpname;

    @javax.persistence.Column(name = "ECPNAME")
    @Basic
    public String getEcpname() {
        return ecpname;
    }

    public void setEcpname(String ecpname) {
        this.ecpname = ecpname;
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

    private BigDecimal usernr1;

    @javax.persistence.Column(name = "USERNR1")
    @Basic
    public BigDecimal getUsernr1() {
        return usernr1;
    }

    public void setUsernr1(BigDecimal usernr1) {
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

    private BigDecimal usernr3;

    @javax.persistence.Column(name = "USERNR3")
    @Basic
    public BigDecimal getUsernr3() {
        return usernr3;
    }

    public void setUsernr3(BigDecimal usernr3) {
        this.usernr3 = usernr3;
    }

    private BigDecimal usernr4;

    @javax.persistence.Column(name = "USERNR4")
    @Basic
    public BigDecimal getUsernr4() {
        return usernr4;
    }

    public void setUsernr4(BigDecimal usernr4) {
        this.usernr4 = usernr4;
    }

    private String idtype;

    @javax.persistence.Column(name = "IDTYPE")
    @Basic
    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    private String ecptype;

    @javax.persistence.Column(name = "ECPTYPE")
    @Basic
    public String getEcptype() {
        return ecptype;
    }

    public void setEcptype(String ecptype) {
        this.ecptype = ecptype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcpEntity ecpEntity = (EcpEntity) o;

        if (revlev != ecpEntity.revlev) return false;
        if (crtdtec != null ? !crtdtec.equals(ecpEntity.crtdtec) : ecpEntity.crtdtec != null) return false;
        if (crtmod != null ? !crtmod.equals(ecpEntity.crtmod) : ecpEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(ecpEntity.crttime) : ecpEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(ecpEntity.crtuser) : ecpEntity.crtuser != null) return false;
        if (ecpkey != null ? !ecpkey.equals(ecpEntity.ecpkey) : ecpEntity.ecpkey != null) return false;
        if (ecpname != null ? !ecpname.equals(ecpEntity.ecpname) : ecpEntity.ecpname != null) return false;
        if (ecptype != null ? !ecptype.equals(ecpEntity.ecptype) : ecpEntity.ecptype != null) return false;
        if (idtype != null ? !idtype.equals(ecpEntity.idtype) : ecpEntity.idtype != null) return false;
        if (instid != null ? !instid.equals(ecpEntity.instid) : ecpEntity.instid != null) return false;
        if (revdtec != null ? !revdtec.equals(ecpEntity.revdtec) : ecpEntity.revdtec != null) return false;
        if (revmod != null ? !revmod.equals(ecpEntity.revmod) : ecpEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(ecpEntity.revtime) : ecpEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(ecpEntity.revuser) : ecpEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(ecpEntity.sid) : ecpEntity.sid != null) return false;
        if (ucode != null ? !ucode.equals(ecpEntity.ucode) : ecpEntity.ucode != null) return false;
        if (usercd1 != null ? !usercd1.equals(ecpEntity.usercd1) : ecpEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(ecpEntity.usercd2) : ecpEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(ecpEntity.usercd3) : ecpEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(ecpEntity.usercd4) : ecpEntity.usercd4 != null) return false;
        if (usernr1 != null ? !usernr1.equals(ecpEntity.usernr1) : ecpEntity.usernr1 != null) return false;
        if (usernr2 != null ? !usernr2.equals(ecpEntity.usernr2) : ecpEntity.usernr2 != null) return false;
        if (usernr3 != null ? !usernr3.equals(ecpEntity.usernr3) : ecpEntity.usernr3 != null) return false;
        if (usernr4 != null ? !usernr4.equals(ecpEntity.usernr4) : ecpEntity.usernr4 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ecpkey != null ? ecpkey.hashCode() : 0;
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
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
        result = 31 * result + (ecpname != null ? ecpname.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + (usernr1 != null ? usernr1.hashCode() : 0);
        result = 31 * result + (usernr2 != null ? usernr2.hashCode() : 0);
        result = 31 * result + (usernr3 != null ? usernr3.hashCode() : 0);
        result = 31 * result + (usernr4 != null ? usernr4.hashCode() : 0);
        result = 31 * result + (idtype != null ? idtype.hashCode() : 0);
        result = 31 * result + (ecptype != null ? ecptype.hashCode() : 0);
        return result;
    }
}
