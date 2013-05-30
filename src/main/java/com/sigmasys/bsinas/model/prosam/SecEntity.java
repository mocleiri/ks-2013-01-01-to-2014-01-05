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
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SEC", schema = "SIGMA", catalog = "")
@Entity
public class SecEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSeckey();
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

    private String seckey;

    @javax.persistence.Column(name = "SECKEY")
    @Id
    public String getSeckey() {
        return seckey;
    }

    public void setSeckey(String seckey) {
        this.seckey = seckey;
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

    private String rectype;

    @javax.persistence.Column(name = "RECTYPE")
    @Basic
    public String getRectype() {
        return rectype;
    }

    public void setRectype(String rectype) {
        this.rectype = rectype;
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

    private String secdata;

    @javax.persistence.Column(name = "SECDATA")
    @Basic
    public String getSecdata() {
        return secdata;
    }

    public void setSecdata(String secdata) {
        this.secdata = secdata;
    }

    private String secdata1;

    @javax.persistence.Column(name = "SECDATA1")
    @Basic
    public String getSecdata1() {
        return secdata1;
    }

    public void setSecdata1(String secdata1) {
        this.secdata1 = secdata1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecEntity secEntity = (SecEntity) o;

        if (instid != null ? !instid.equals(secEntity.instid) : secEntity.instid != null) return false;
        if (operid != null ? !operid.equals(secEntity.operid) : secEntity.operid != null) return false;
        if (recstat != null ? !recstat.equals(secEntity.recstat) : secEntity.recstat != null) return false;
        if (rectype != null ? !rectype.equals(secEntity.rectype) : secEntity.rectype != null) return false;
        if (secdata != null ? !secdata.equals(secEntity.secdata) : secEntity.secdata != null) return false;
        if (secdata1 != null ? !secdata1.equals(secEntity.secdata1) : secEntity.secdata1 != null) return false;
        if (seckey != null ? !seckey.equals(secEntity.seckey) : secEntity.seckey != null) return false;
        if (system != null ? !system.equals(secEntity.system) : secEntity.system != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (seckey != null ? seckey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (rectype != null ? rectype.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (operid != null ? operid.hashCode() : 0);
        result = 31 * result + (secdata != null ? secdata.hashCode() : 0);
        result = 31 * result + (secdata1 != null ? secdata1.hashCode() : 0);
        return result;
    }
}
