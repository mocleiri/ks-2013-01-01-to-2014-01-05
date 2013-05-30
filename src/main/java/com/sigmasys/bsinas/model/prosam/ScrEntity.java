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
@javax.persistence.Table(name = "SCR", schema = "SIGMA", catalog = "")
@Entity
public class ScrEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getScrkey();
    }

    private String scrkey;

    @javax.persistence.Column(name = "SCRKEY")
    @Id
    public String getScrkey() {
        return scrkey;
    }

    public void setScrkey(String scrkey) {
        this.scrkey = scrkey;
    }

    private String scrdata1;

    @javax.persistence.Column(name = "SCRDATA1")
    @Basic
    public String getScrdata1() {
        return scrdata1;
    }

    public void setScrdata1(String scrdata1) {
        this.scrdata1 = scrdata1;
    }

    private String scrdata2;

    @javax.persistence.Column(name = "SCRDATA2")
    @Basic
    public String getScrdata2() {
        return scrdata2;
    }

    public void setScrdata2(String scrdata2) {
        this.scrdata2 = scrdata2;
    }

    private String scrdata3;

    @javax.persistence.Column(name = "SCRDATA3")
    @Basic
    public String getScrdata3() {
        return scrdata3;
    }

    public void setScrdata3(String scrdata3) {
        this.scrdata3 = scrdata3;
    }

    private String scrdata4;

    @javax.persistence.Column(name = "SCRDATA4")
    @Basic
    public String getScrdata4() {
        return scrdata4;
    }

    public void setScrdata4(String scrdata4) {
        this.scrdata4 = scrdata4;
    }

    private String scrdata5;

    @javax.persistence.Column(name = "SCRDATA5")
    @Basic
    public String getScrdata5() {
        return scrdata5;
    }

    public void setScrdata5(String scrdata5) {
        this.scrdata5 = scrdata5;
    }

    private String scrdata6;

    @javax.persistence.Column(name = "SCRDATA6")
    @Basic
    public String getScrdata6() {
        return scrdata6;
    }

    public void setScrdata6(String scrdata6) {
        this.scrdata6 = scrdata6;
    }

    private String scrdata7;

    @javax.persistence.Column(name = "SCRDATA7")
    @Basic
    public String getScrdata7() {
        return scrdata7;
    }

    public void setScrdata7(String scrdata7) {
        this.scrdata7 = scrdata7;
    }

    private String scrdata8;

    @javax.persistence.Column(name = "SCRDATA8")
    @Basic
    public String getScrdata8() {
        return scrdata8;
    }

    public void setScrdata8(String scrdata8) {
        this.scrdata8 = scrdata8;
    }

    private String scrdata9;

    @javax.persistence.Column(name = "SCRDATA9")
    @Basic
    public String getScrdata9() {
        return scrdata9;
    }

    public void setScrdata9(String scrdata9) {
        this.scrdata9 = scrdata9;
    }

    private String scrdataa;

    @javax.persistence.Column(name = "SCRDATAA")
    @Basic
    public String getScrdataa() {
        return scrdataa;
    }

    public void setScrdataa(String scrdataa) {
        this.scrdataa = scrdataa;
    }

    private String scrdatab;

    @javax.persistence.Column(name = "SCRDATAB")
    @Basic
    public String getScrdatab() {
        return scrdatab;
    }

    public void setScrdatab(String scrdatab) {
        this.scrdatab = scrdatab;
    }

    private String scrdatac;

    @javax.persistence.Column(name = "SCRDATAC")
    @Basic
    public String getScrdatac() {
        return scrdatac;
    }

    public void setScrdatac(String scrdatac) {
        this.scrdatac = scrdatac;
    }

    private String scrdatad;

    @javax.persistence.Column(name = "SCRDATAD")
    @Basic
    public String getScrdatad() {
        return scrdatad;
    }

    public void setScrdatad(String scrdatad) {
        this.scrdatad = scrdatad;
    }

    private String scrdatae;

    @javax.persistence.Column(name = "SCRDATAE")
    @Basic
    public String getScrdatae() {
        return scrdatae;
    }

    public void setScrdatae(String scrdatae) {
        this.scrdatae = scrdatae;
    }

    private String scrdataf;

    @javax.persistence.Column(name = "SCRDATAF")
    @Basic
    public String getScrdataf() {
        return scrdataf;
    }

    public void setScrdataf(String scrdataf) {
        this.scrdataf = scrdataf;
    }

    private String scrdatag;

    @javax.persistence.Column(name = "SCRDATAG")
    @Basic
    public String getScrdatag() {
        return scrdatag;
    }

    public void setScrdatag(String scrdatag) {
        this.scrdatag = scrdatag;
    }

    private String scrdatah;

    @javax.persistence.Column(name = "SCRDATAH")
    @Basic
    public String getScrdatah() {
        return scrdatah;
    }

    public void setScrdatah(String scrdatah) {
        this.scrdatah = scrdatah;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScrEntity scrEntity = (ScrEntity) o;

        if (scrdata1 != null ? !scrdata1.equals(scrEntity.scrdata1) : scrEntity.scrdata1 != null) return false;
        if (scrdata2 != null ? !scrdata2.equals(scrEntity.scrdata2) : scrEntity.scrdata2 != null) return false;
        if (scrdata3 != null ? !scrdata3.equals(scrEntity.scrdata3) : scrEntity.scrdata3 != null) return false;
        if (scrdata4 != null ? !scrdata4.equals(scrEntity.scrdata4) : scrEntity.scrdata4 != null) return false;
        if (scrdata5 != null ? !scrdata5.equals(scrEntity.scrdata5) : scrEntity.scrdata5 != null) return false;
        if (scrdata6 != null ? !scrdata6.equals(scrEntity.scrdata6) : scrEntity.scrdata6 != null) return false;
        if (scrdata7 != null ? !scrdata7.equals(scrEntity.scrdata7) : scrEntity.scrdata7 != null) return false;
        if (scrdata8 != null ? !scrdata8.equals(scrEntity.scrdata8) : scrEntity.scrdata8 != null) return false;
        if (scrdata9 != null ? !scrdata9.equals(scrEntity.scrdata9) : scrEntity.scrdata9 != null) return false;
        if (scrdataa != null ? !scrdataa.equals(scrEntity.scrdataa) : scrEntity.scrdataa != null) return false;
        if (scrdatab != null ? !scrdatab.equals(scrEntity.scrdatab) : scrEntity.scrdatab != null) return false;
        if (scrdatac != null ? !scrdatac.equals(scrEntity.scrdatac) : scrEntity.scrdatac != null) return false;
        if (scrdatad != null ? !scrdatad.equals(scrEntity.scrdatad) : scrEntity.scrdatad != null) return false;
        if (scrdatae != null ? !scrdatae.equals(scrEntity.scrdatae) : scrEntity.scrdatae != null) return false;
        if (scrdataf != null ? !scrdataf.equals(scrEntity.scrdataf) : scrEntity.scrdataf != null) return false;
        if (scrdatag != null ? !scrdatag.equals(scrEntity.scrdatag) : scrEntity.scrdatag != null) return false;
        if (scrdatah != null ? !scrdatah.equals(scrEntity.scrdatah) : scrEntity.scrdatah != null) return false;
        if (scrkey != null ? !scrkey.equals(scrEntity.scrkey) : scrEntity.scrkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scrkey != null ? scrkey.hashCode() : 0;
        result = 31 * result + (scrdata1 != null ? scrdata1.hashCode() : 0);
        result = 31 * result + (scrdata2 != null ? scrdata2.hashCode() : 0);
        result = 31 * result + (scrdata3 != null ? scrdata3.hashCode() : 0);
        result = 31 * result + (scrdata4 != null ? scrdata4.hashCode() : 0);
        result = 31 * result + (scrdata5 != null ? scrdata5.hashCode() : 0);
        result = 31 * result + (scrdata6 != null ? scrdata6.hashCode() : 0);
        result = 31 * result + (scrdata7 != null ? scrdata7.hashCode() : 0);
        result = 31 * result + (scrdata8 != null ? scrdata8.hashCode() : 0);
        result = 31 * result + (scrdata9 != null ? scrdata9.hashCode() : 0);
        result = 31 * result + (scrdataa != null ? scrdataa.hashCode() : 0);
        result = 31 * result + (scrdatab != null ? scrdatab.hashCode() : 0);
        result = 31 * result + (scrdatac != null ? scrdatac.hashCode() : 0);
        result = 31 * result + (scrdatad != null ? scrdatad.hashCode() : 0);
        result = 31 * result + (scrdatae != null ? scrdatae.hashCode() : 0);
        result = 31 * result + (scrdataf != null ? scrdataf.hashCode() : 0);
        result = 31 * result + (scrdatag != null ? scrdatag.hashCode() : 0);
        result = 31 * result + (scrdatah != null ? scrdatah.hashCode() : 0);
        return result;
    }
}
