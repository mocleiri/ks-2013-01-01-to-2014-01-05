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
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "TBL", schema = "SIGMA", catalog = "")
@Entity
public class TblEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getTblkey();
    }

    private String tblkey;

    @javax.persistence.Column(name = "TBLKEY")
    @Id
    public String getTblkey() {
        return tblkey;
    }

    public void setTblkey(String tblkey) {
        this.tblkey = tblkey;
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

    private String sisyskey;

    @javax.persistence.Column(name = "SISYSKEY")
    @Basic
    public String getSisyskey() {
        return sisyskey;
    }

    public void setSisyskey(String sisyskey) {
        this.sisyskey = sisyskey;
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

    private String rectype;

    @javax.persistence.Column(name = "RECTYPE")
    @Basic
    public String getRectype() {
        return rectype;
    }

    public void setRectype(String rectype) {
        this.rectype = rectype;
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

    private String tbldata1;

    @javax.persistence.Column(name = "TBLDATA1")
    @Basic
    public String getTbldata1() {
        return tbldata1;
    }

    public void setTbldata1(String tbldata1) {
        this.tbldata1 = tbldata1;
    }

    private String tbldata2;

    @javax.persistence.Column(name = "TBLDATA2")
    @Basic
    public String getTbldata2() {
        return tbldata2;
    }

    public void setTbldata2(String tbldata2) {
        this.tbldata2 = tbldata2;
    }

    private String tbldata3;

    @javax.persistence.Column(name = "TBLDATA3")
    @Basic
    public String getTbldata3() {
        return tbldata3;
    }

    public void setTbldata3(String tbldata3) {
        this.tbldata3 = tbldata3;
    }

    private String tbldata4;

    @javax.persistence.Column(name = "TBLDATA4")
    @Basic
    public String getTbldata4() {
        return tbldata4;
    }

    public void setTbldata4(String tbldata4) {
        this.tbldata4 = tbldata4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblEntity tblEntity = (TblEntity) o;

        if (instid != null ? !instid.equals(tblEntity.instid) : tblEntity.instid != null) return false;
        if (rectype != null ? !rectype.equals(tblEntity.rectype) : tblEntity.rectype != null) return false;
        if (rkey != null ? !rkey.equals(tblEntity.rkey) : tblEntity.rkey != null) return false;
        if (sisyskey != null ? !sisyskey.equals(tblEntity.sisyskey) : tblEntity.sisyskey != null) return false;
        if (system != null ? !system.equals(tblEntity.system) : tblEntity.system != null) return false;
        if (tbldata1 != null ? !tbldata1.equals(tblEntity.tbldata1) : tblEntity.tbldata1 != null) return false;
        if (tbldata2 != null ? !tbldata2.equals(tblEntity.tbldata2) : tblEntity.tbldata2 != null) return false;
        if (tbldata3 != null ? !tbldata3.equals(tblEntity.tbldata3) : tblEntity.tbldata3 != null) return false;
        if (tbldata4 != null ? !tbldata4.equals(tblEntity.tbldata4) : tblEntity.tbldata4 != null) return false;
        if (tblkey != null ? !tblkey.equals(tblEntity.tblkey) : tblEntity.tblkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tblkey != null ? tblkey.hashCode() : 0;
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sisyskey != null ? sisyskey.hashCode() : 0);
        result = 31 * result + (system != null ? system.hashCode() : 0);
        result = 31 * result + (rectype != null ? rectype.hashCode() : 0);
        result = 31 * result + (rkey != null ? rkey.hashCode() : 0);
        result = 31 * result + (tbldata1 != null ? tbldata1.hashCode() : 0);
        result = 31 * result + (tbldata2 != null ? tbldata2.hashCode() : 0);
        result = 31 * result + (tbldata3 != null ? tbldata3.hashCode() : 0);
        result = 31 * result + (tbldata4 != null ? tbldata4.hashCode() : 0);
        return result;
    }
}
