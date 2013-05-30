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
 * Time: 12:22 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "STT", schema = "SIGMA", catalog = "")
@Entity
public class SttEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSttkey();
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

    private String sttkey;

    @javax.persistence.Column(name = "STTKEY")
    @Id
    public String getSttkey() {
        return sttkey;
    }

    public void setSttkey(String sttkey) {
        this.sttkey = sttkey;
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

    private String aidyr;

    @javax.persistence.Column(name = "AIDYR")
    @Basic
    public String getAidyr() {
        return aidyr;
    }

    public void setAidyr(String aidyr) {
        this.aidyr = aidyr;
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

    private String crtdate;

    @javax.persistence.Column(name = "CRTDATE")
    @Basic
    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
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

    private String revdate;

    @javax.persistence.Column(name = "REVDATE")
    @Basic
    public String getRevdate() {
        return revdate;
    }

    public void setRevdate(String revdate) {
        this.revdate = revdate;
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

    private String ucode;

    @javax.persistence.Column(name = "UCODE")
    @Basic
    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    private BigDecimal caaca;

    @javax.persistence.Column(name = "CAACA")
    @Basic
    public BigDecimal getCaaca() {
        return caaca;
    }

    public void setCaaca(BigDecimal caaca) {
        this.caaca = caaca;
    }

    private BigDecimal caacar;

    @javax.persistence.Column(name = "CAACAR")
    @Basic
    public BigDecimal getCaacar() {
        return caacar;
    }

    public void setCaacar(BigDecimal caacar) {
        this.caacar = caacar;
    }

    private String caacps;

    @javax.persistence.Column(name = "CAACPS")
    @Basic
    public String getCaacps() {
        return caacps;
    }

    public void setCaacps(String caacps) {
        this.caacps = caacps;
    }

    private String caacpo;

    @javax.persistence.Column(name = "CAACPO")
    @Basic
    public String getCaacpo() {
        return caacpo;
    }

    public void setCaacpo(String caacpo) {
        this.caacpo = caacpo;
    }

    private String caacpr;

    @javax.persistence.Column(name = "CAACPR")
    @Basic
    public String getCaacpr() {
        return caacpr;
    }

    public void setCaacpr(String caacpr) {
        this.caacpr = caacpr;
    }

    private String caacac;

    @javax.persistence.Column(name = "CAACAC")
    @Basic
    public String getCaacac() {
        return caacac;
    }

    public void setCaacac(String caacac) {
        this.caacac = caacac;
    }

    private String caacao;

    @javax.persistence.Column(name = "CAACAO")
    @Basic
    public String getCaacao() {
        return caacao;
    }

    public void setCaacao(String caacao) {
        this.caacao = caacao;
    }

    private BigDecimal catfa;

    @javax.persistence.Column(name = "CATFA")
    @Basic
    public BigDecimal getCatfa() {
        return catfa;
    }

    public void setCatfa(BigDecimal catfa) {
        this.catfa = catfa;
    }

    private BigDecimal catfar;

    @javax.persistence.Column(name = "CATFAR")
    @Basic
    public BigDecimal getCatfar() {
        return catfar;
    }

    public void setCatfar(BigDecimal catfar) {
        this.catfar = catfar;
    }

    private String catfps;

    @javax.persistence.Column(name = "CATFPS")
    @Basic
    public String getCatfps() {
        return catfps;
    }

    public void setCatfps(String catfps) {
        this.catfps = catfps;
    }

    private String catfpo;

    @javax.persistence.Column(name = "CATFPO")
    @Basic
    public String getCatfpo() {
        return catfpo;
    }

    public void setCatfpo(String catfpo) {
        this.catfpo = catfpo;
    }

    private String catfpr;

    @javax.persistence.Column(name = "CATFPR")
    @Basic
    public String getCatfpr() {
        return catfpr;
    }

    public void setCatfpr(String catfpr) {
        this.catfpr = catfpr;
    }

    private String catfac;

    @javax.persistence.Column(name = "CATFAC")
    @Basic
    public String getCatfac() {
        return catfac;
    }

    public void setCatfac(String catfac) {
        this.catfac = catfac;
    }

    private String catfao;

    @javax.persistence.Column(name = "CATFAO")
    @Basic
    public String getCatfao() {
        return catfao;
    }

    public void setCatfao(String catfao) {
        this.catfao = catfao;
    }

    private BigDecimal cattar;

    @javax.persistence.Column(name = "CATTAR")
    @Basic
    public BigDecimal getCattar() {
        return cattar;
    }

    public void setCattar(BigDecimal cattar) {
        this.cattar = cattar;
    }

    private String capexf;

    @javax.persistence.Column(name = "CAPEXF")
    @Basic
    public String getCapexf() {
        return capexf;
    }

    public void setCapexf(String capexf) {
        this.capexf = capexf;
    }

    private String capexd;

    @javax.persistence.Column(name = "CAPEXD")
    @Basic
    public String getCapexd() {
        return capexd;
    }

    public void setCapexd(String capexd) {
        this.capexd = capexd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SttEntity sttEntity = (SttEntity) o;

        if (aidyr != null ? !aidyr.equals(sttEntity.aidyr) : sttEntity.aidyr != null) return false;
        if (caaca != null ? !caaca.equals(sttEntity.caaca) : sttEntity.caaca != null) return false;
        if (caacac != null ? !caacac.equals(sttEntity.caacac) : sttEntity.caacac != null) return false;
        if (caacao != null ? !caacao.equals(sttEntity.caacao) : sttEntity.caacao != null) return false;
        if (caacar != null ? !caacar.equals(sttEntity.caacar) : sttEntity.caacar != null) return false;
        if (caacpo != null ? !caacpo.equals(sttEntity.caacpo) : sttEntity.caacpo != null) return false;
        if (caacpr != null ? !caacpr.equals(sttEntity.caacpr) : sttEntity.caacpr != null) return false;
        if (caacps != null ? !caacps.equals(sttEntity.caacps) : sttEntity.caacps != null) return false;
        if (capexd != null ? !capexd.equals(sttEntity.capexd) : sttEntity.capexd != null) return false;
        if (capexf != null ? !capexf.equals(sttEntity.capexf) : sttEntity.capexf != null) return false;
        if (catfa != null ? !catfa.equals(sttEntity.catfa) : sttEntity.catfa != null) return false;
        if (catfac != null ? !catfac.equals(sttEntity.catfac) : sttEntity.catfac != null) return false;
        if (catfao != null ? !catfao.equals(sttEntity.catfao) : sttEntity.catfao != null) return false;
        if (catfar != null ? !catfar.equals(sttEntity.catfar) : sttEntity.catfar != null) return false;
        if (catfpo != null ? !catfpo.equals(sttEntity.catfpo) : sttEntity.catfpo != null) return false;
        if (catfpr != null ? !catfpr.equals(sttEntity.catfpr) : sttEntity.catfpr != null) return false;
        if (catfps != null ? !catfps.equals(sttEntity.catfps) : sttEntity.catfps != null) return false;
        if (cattar != null ? !cattar.equals(sttEntity.cattar) : sttEntity.cattar != null) return false;
        if (crtdate != null ? !crtdate.equals(sttEntity.crtdate) : sttEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(sttEntity.crtmod) : sttEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(sttEntity.crttime) : sttEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(sttEntity.crtuser) : sttEntity.crtuser != null) return false;
        if (recstat != null ? !recstat.equals(sttEntity.recstat) : sttEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(sttEntity.revdate) : sttEntity.revdate != null) return false;
        if (revlev != null ? !revlev.equals(sttEntity.revlev) : sttEntity.revlev != null) return false;
        if (revmod != null ? !revmod.equals(sttEntity.revmod) : sttEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(sttEntity.revtime) : sttEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(sttEntity.revuser) : sttEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(sttEntity.sid) : sttEntity.sid != null) return false;
        if (sttkey != null ? !sttkey.equals(sttEntity.sttkey) : sttEntity.sttkey != null) return false;
        if (term != null ? !term.equals(sttEntity.term) : sttEntity.term != null) return false;
        if (ucode != null ? !ucode.equals(sttEntity.ucode) : sttEntity.ucode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (sttkey != null ? sttkey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (caaca != null ? caaca.hashCode() : 0);
        result = 31 * result + (caacar != null ? caacar.hashCode() : 0);
        result = 31 * result + (caacps != null ? caacps.hashCode() : 0);
        result = 31 * result + (caacpo != null ? caacpo.hashCode() : 0);
        result = 31 * result + (caacpr != null ? caacpr.hashCode() : 0);
        result = 31 * result + (caacac != null ? caacac.hashCode() : 0);
        result = 31 * result + (caacao != null ? caacao.hashCode() : 0);
        result = 31 * result + (catfa != null ? catfa.hashCode() : 0);
        result = 31 * result + (catfar != null ? catfar.hashCode() : 0);
        result = 31 * result + (catfps != null ? catfps.hashCode() : 0);
        result = 31 * result + (catfpo != null ? catfpo.hashCode() : 0);
        result = 31 * result + (catfpr != null ? catfpr.hashCode() : 0);
        result = 31 * result + (catfac != null ? catfac.hashCode() : 0);
        result = 31 * result + (catfao != null ? catfao.hashCode() : 0);
        result = 31 * result + (cattar != null ? cattar.hashCode() : 0);
        result = 31 * result + (capexf != null ? capexf.hashCode() : 0);
        result = 31 * result + (capexd != null ? capexd.hashCode() : 0);
        return result;
    }
}
