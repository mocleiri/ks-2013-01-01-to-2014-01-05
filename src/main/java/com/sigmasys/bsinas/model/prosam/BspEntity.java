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
@javax.persistence.Table(name = "BSP", schema = "SIGMA", catalog = "")
@Entity
public class BspEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getBspkey();
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

    private String bspkey;

    @javax.persistence.Column(name = "BSPKEY")
    @Id
    public String getBspkey() {
        return bspkey;
    }

    public void setBspkey(String bspkey) {
        this.bspkey = bspkey;
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

    private String adtype;

    @javax.persistence.Column(name = "ADTYPE")
    @Basic
    public String getAdtype() {
        return adtype;
    }

    public void setAdtype(String adtype) {
        this.adtype = adtype;
    }

    private String instida;

    @javax.persistence.Column(name = "INSTIDA")
    @Basic
    public String getInstida() {
        return instida;
    }

    public void setInstida(String instida) {
        this.instida = instida;
    }

    private String adtypea;

    @javax.persistence.Column(name = "ADTYPEA")
    @Basic
    public String getAdtypea() {
        return adtypea;
    }

    public void setAdtypea(String adtypea) {
        this.adtypea = adtypea;
    }

    private String sida;

    @javax.persistence.Column(name = "SIDA")
    @Basic
    public String getSida() {
        return sida;
    }

    public void setSida(String sida) {
        this.sida = sida;
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

    private int revlev;

    @javax.persistence.Column(name = "REVLEV")
    @Basic
    public int getRevlev() {
        return revlev;
    }

    public void setRevlev(int revlev) {
        this.revlev = revlev;
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

    private String revtime;

    @javax.persistence.Column(name = "REVTIME")
    @Basic
    public String getRevtime() {
        return revtime;
    }

    public void setRevtime(String revtime) {
        this.revtime = revtime;
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

    private String cname;

    @javax.persistence.Column(name = "CNAME")
    @Basic
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    private String crelate;

    @javax.persistence.Column(name = "CRELATE")
    @Basic
    public String getCrelate() {
        return crelate;
    }

    public void setCrelate(String crelate) {
        this.crelate = crelate;
    }

    private String ctitle;

    @javax.persistence.Column(name = "CTITLE")
    @Basic
    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    private String cjtitle;

    @javax.persistence.Column(name = "CJTITLE")
    @Basic
    public String getCjtitle() {
        return cjtitle;
    }

    public void setCjtitle(String cjtitle) {
        this.cjtitle = cjtitle;
    }

    private String addrst;

    @javax.persistence.Column(name = "ADDRST")
    @Basic
    public String getAddrst() {
        return addrst;
    }

    public void setAddrst(String addrst) {
        this.addrst = addrst;
    }

    private String addr1;

    @javax.persistence.Column(name = "ADDR1")
    @Basic
    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    private String addr2;

    @javax.persistence.Column(name = "ADDR2")
    @Basic
    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    private String addr3;

    @javax.persistence.Column(name = "ADDR3")
    @Basic
    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    private String city;

    @javax.persistence.Column(name = "CITY")
    @Basic
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String state;

    @javax.persistence.Column(name = "STATE")
    @Basic
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String zip;

    @javax.persistence.Column(name = "ZIP")
    @Basic
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    private String country;

    @javax.persistence.Column(name = "COUNTRY")
    @Basic
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    private String userdt1;

    @javax.persistence.Column(name = "USERDT1")
    @Basic
    public String getUserdt1() {
        return userdt1;
    }

    public void setUserdt1(String userdt1) {
        this.userdt1 = userdt1;
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

    private String county;

    @javax.persistence.Column(name = "COUNTY")
    @Basic
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BspEntity bspEntity = (BspEntity) o;

        if (revlev != bspEntity.revlev) return false;
        if (usernr1 != bspEntity.usernr1) return false;
        if (addr1 != null ? !addr1.equals(bspEntity.addr1) : bspEntity.addr1 != null) return false;
        if (addr2 != null ? !addr2.equals(bspEntity.addr2) : bspEntity.addr2 != null) return false;
        if (addr3 != null ? !addr3.equals(bspEntity.addr3) : bspEntity.addr3 != null) return false;
        if (addrst != null ? !addrst.equals(bspEntity.addrst) : bspEntity.addrst != null) return false;
        if (adtype != null ? !adtype.equals(bspEntity.adtype) : bspEntity.adtype != null) return false;
        if (adtypea != null ? !adtypea.equals(bspEntity.adtypea) : bspEntity.adtypea != null) return false;
        if (bspkey != null ? !bspkey.equals(bspEntity.bspkey) : bspEntity.bspkey != null) return false;
        if (city != null ? !city.equals(bspEntity.city) : bspEntity.city != null) return false;
        if (cjtitle != null ? !cjtitle.equals(bspEntity.cjtitle) : bspEntity.cjtitle != null) return false;
        if (cname != null ? !cname.equals(bspEntity.cname) : bspEntity.cname != null) return false;
        if (country != null ? !country.equals(bspEntity.country) : bspEntity.country != null) return false;
        if (county != null ? !county.equals(bspEntity.county) : bspEntity.county != null) return false;
        if (crelate != null ? !crelate.equals(bspEntity.crelate) : bspEntity.crelate != null) return false;
        if (crtdate != null ? !crtdate.equals(bspEntity.crtdate) : bspEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(bspEntity.crtmod) : bspEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(bspEntity.crttime) : bspEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(bspEntity.crtuser) : bspEntity.crtuser != null) return false;
        if (ctitle != null ? !ctitle.equals(bspEntity.ctitle) : bspEntity.ctitle != null) return false;
        if (effdate != null ? !effdate.equals(bspEntity.effdate) : bspEntity.effdate != null) return false;
        if (expdate != null ? !expdate.equals(bspEntity.expdate) : bspEntity.expdate != null) return false;
        if (instid != null ? !instid.equals(bspEntity.instid) : bspEntity.instid != null) return false;
        if (instida != null ? !instida.equals(bspEntity.instida) : bspEntity.instida != null) return false;
        if (recstat != null ? !recstat.equals(bspEntity.recstat) : bspEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(bspEntity.revdate) : bspEntity.revdate != null) return false;
        if (revmod != null ? !revmod.equals(bspEntity.revmod) : bspEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(bspEntity.revtime) : bspEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(bspEntity.revuser) : bspEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(bspEntity.sid) : bspEntity.sid != null) return false;
        if (sida != null ? !sida.equals(bspEntity.sida) : bspEntity.sida != null) return false;
        if (state != null ? !state.equals(bspEntity.state) : bspEntity.state != null) return false;
        if (ucode != null ? !ucode.equals(bspEntity.ucode) : bspEntity.ucode != null) return false;
        if (usercd1 != null ? !usercd1.equals(bspEntity.usercd1) : bspEntity.usercd1 != null) return false;
        if (usercd2 != null ? !usercd2.equals(bspEntity.usercd2) : bspEntity.usercd2 != null) return false;
        if (usercd3 != null ? !usercd3.equals(bspEntity.usercd3) : bspEntity.usercd3 != null) return false;
        if (usercd4 != null ? !usercd4.equals(bspEntity.usercd4) : bspEntity.usercd4 != null) return false;
        if (userdt1 != null ? !userdt1.equals(bspEntity.userdt1) : bspEntity.userdt1 != null) return false;
        if (usernr2 != null ? !usernr2.equals(bspEntity.usernr2) : bspEntity.usernr2 != null) return false;
        if (zip != null ? !zip.equals(bspEntity.zip) : bspEntity.zip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (bspkey != null ? bspkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (adtype != null ? adtype.hashCode() : 0);
        result = 31 * result + (instida != null ? instida.hashCode() : 0);
        result = 31 * result + (adtypea != null ? adtypea.hashCode() : 0);
        result = 31 * result + (sida != null ? sida.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + revlev;
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + (crelate != null ? crelate.hashCode() : 0);
        result = 31 * result + (ctitle != null ? ctitle.hashCode() : 0);
        result = 31 * result + (cjtitle != null ? cjtitle.hashCode() : 0);
        result = 31 * result + (addrst != null ? addrst.hashCode() : 0);
        result = 31 * result + (addr1 != null ? addr1.hashCode() : 0);
        result = 31 * result + (addr2 != null ? addr2.hashCode() : 0);
        result = 31 * result + (addr3 != null ? addr3.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (usercd1 != null ? usercd1.hashCode() : 0);
        result = 31 * result + (usercd2 != null ? usercd2.hashCode() : 0);
        result = 31 * result + (usercd3 != null ? usercd3.hashCode() : 0);
        result = 31 * result + (usercd4 != null ? usercd4.hashCode() : 0);
        result = 31 * result + (userdt1 != null ? userdt1.hashCode() : 0);
        result = 31 * result + usernr1;
        result = 31 * result + (usernr2 != null ? usernr2.hashCode() : 0);
        result = 31 * result + (effdate != null ? effdate.hashCode() : 0);
        result = 31 * result + (expdate != null ? expdate.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        return result;
    }
}
