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
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "STA", schema = "SIGMA", catalog = "")
@Entity
public class StaEntity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getStakey();
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

    private String stakey;

    @javax.persistence.Column(name = "STAKEY")
    @Id
    public String getStakey() {
        return stakey;
    }

    public void setStakey(String stakey) {
        this.stakey = stakey;
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

    private String user1;

    @javax.persistence.Column(name = "USER1")
    @Basic
    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    private String user2;

    @javax.persistence.Column(name = "USER2")
    @Basic
    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    private String user3;

    @javax.persistence.Column(name = "USER3")
    @Basic
    public String getUser3() {
        return user3;
    }

    public void setUser3(String user3) {
        this.user3 = user3;
    }

    private String user4;

    @javax.persistence.Column(name = "USER4")
    @Basic
    public String getUser4() {
        return user4;
    }

    public void setUser4(String user4) {
        this.user4 = user4;
    }

    private String user5;

    @javax.persistence.Column(name = "USER5")
    @Basic
    public String getUser5() {
        return user5;
    }

    public void setUser5(String user5) {
        this.user5 = user5;
    }

    private String user6;

    @javax.persistence.Column(name = "USER6")
    @Basic
    public String getUser6() {
        return user6;
    }

    public void setUser6(String user6) {
        this.user6 = user6;
    }

    private String user7;

    @javax.persistence.Column(name = "USER7")
    @Basic
    public String getUser7() {
        return user7;
    }

    public void setUser7(String user7) {
        this.user7 = user7;
    }

    private String user8;

    @javax.persistence.Column(name = "USER8")
    @Basic
    public String getUser8() {
        return user8;
    }

    public void setUser8(String user8) {
        this.user8 = user8;
    }

    private String user9;

    @javax.persistence.Column(name = "USER9")
    @Basic
    public String getUser9() {
        return user9;
    }

    public void setUser9(String user9) {
        this.user9 = user9;
    }

    private String user10;

    @javax.persistence.Column(name = "USER10")
    @Basic
    public String getUser10() {
        return user10;
    }

    public void setUser10(String user10) {
        this.user10 = user10;
    }

    private String user11;

    @javax.persistence.Column(name = "USER11")
    @Basic
    public String getUser11() {
        return user11;
    }

    public void setUser11(String user11) {
        this.user11 = user11;
    }

    private String user12;

    @javax.persistence.Column(name = "USER12")
    @Basic
    public String getUser12() {
        return user12;
    }

    public void setUser12(String user12) {
        this.user12 = user12;
    }

    private String user13;

    @javax.persistence.Column(name = "USER13")
    @Basic
    public String getUser13() {
        return user13;
    }

    public void setUser13(String user13) {
        this.user13 = user13;
    }

    private String user14;

    @javax.persistence.Column(name = "USER14")
    @Basic
    public String getUser14() {
        return user14;
    }

    public void setUser14(String user14) {
        this.user14 = user14;
    }

    private String user15;

    @javax.persistence.Column(name = "USER15")
    @Basic
    public String getUser15() {
        return user15;
    }

    public void setUser15(String user15) {
        this.user15 = user15;
    }

    private String user16;

    @javax.persistence.Column(name = "USER16")
    @Basic
    public String getUser16() {
        return user16;
    }

    public void setUser16(String user16) {
        this.user16 = user16;
    }

    private String user17;

    @javax.persistence.Column(name = "USER17")
    @Basic
    public String getUser17() {
        return user17;
    }

    public void setUser17(String user17) {
        this.user17 = user17;
    }

    private String user18;

    @javax.persistence.Column(name = "USER18")
    @Basic
    public String getUser18() {
        return user18;
    }

    public void setUser18(String user18) {
        this.user18 = user18;
    }

    private String user19;

    @javax.persistence.Column(name = "USER19")
    @Basic
    public String getUser19() {
        return user19;
    }

    public void setUser19(String user19) {
        this.user19 = user19;
    }

    private String user20;

    @javax.persistence.Column(name = "USER20")
    @Basic
    public String getUser20() {
        return user20;
    }

    public void setUser20(String user20) {
        this.user20 = user20;
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

    private BigDecimal usrnr9;

    @javax.persistence.Column(name = "USRNR9")
    @Basic
    public BigDecimal getUsrnr9() {
        return usrnr9;
    }

    public void setUsrnr9(BigDecimal usrnr9) {
        this.usrnr9 = usrnr9;
    }

    private BigDecimal usrnra;

    @javax.persistence.Column(name = "USRNRA")
    @Basic
    public BigDecimal getUsrnra() {
        return usrnra;
    }

    public void setUsrnra(BigDecimal usrnra) {
        this.usrnra = usrnra;
    }

    private BigDecimal usrnrb;

    @javax.persistence.Column(name = "USRNRB")
    @Basic
    public BigDecimal getUsrnrb() {
        return usrnrb;
    }

    public void setUsrnrb(BigDecimal usrnrb) {
        this.usrnrb = usrnrb;
    }

    private BigDecimal usrnrc;

    @javax.persistence.Column(name = "USRNRC")
    @Basic
    public BigDecimal getUsrnrc() {
        return usrnrc;
    }

    public void setUsrnrc(BigDecimal usrnrc) {
        this.usrnrc = usrnrc;
    }

    private BigDecimal usrnrd;

    @javax.persistence.Column(name = "USRNRD")
    @Basic
    public BigDecimal getUsrnrd() {
        return usrnrd;
    }

    public void setUsrnrd(BigDecimal usrnrd) {
        this.usrnrd = usrnrd;
    }

    private BigDecimal usrnre;

    @javax.persistence.Column(name = "USRNRE")
    @Basic
    public BigDecimal getUsrnre() {
        return usrnre;
    }

    public void setUsrnre(BigDecimal usrnre) {
        this.usrnre = usrnre;
    }

    private BigDecimal usrnrf;

    @javax.persistence.Column(name = "USRNRF")
    @Basic
    public BigDecimal getUsrnrf() {
        return usrnrf;
    }

    public void setUsrnrf(BigDecimal usrnrf) {
        this.usrnrf = usrnrf;
    }

    private BigDecimal usrnrg;

    @javax.persistence.Column(name = "USRNRG")
    @Basic
    public BigDecimal getUsrnrg() {
        return usrnrg;
    }

    public void setUsrnrg(BigDecimal usrnrg) {
        this.usrnrg = usrnrg;
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

    private String usrdt9;

    @javax.persistence.Column(name = "USRDT9")
    @Basic
    public String getUsrdt9() {
        return usrdt9;
    }

    public void setUsrdt9(String usrdt9) {
        this.usrdt9 = usrdt9;
    }

    private String usrdta;

    @javax.persistence.Column(name = "USRDTA")
    @Basic
    public String getUsrdta() {
        return usrdta;
    }

    public void setUsrdta(String usrdta) {
        this.usrdta = usrdta;
    }

    private String usrdtb;

    @javax.persistence.Column(name = "USRDTB")
    @Basic
    public String getUsrdtb() {
        return usrdtb;
    }

    public void setUsrdtb(String usrdtb) {
        this.usrdtb = usrdtb;
    }

    private String usrdtc;

    @javax.persistence.Column(name = "USRDTC")
    @Basic
    public String getUsrdtc() {
        return usrdtc;
    }

    public void setUsrdtc(String usrdtc) {
        this.usrdtc = usrdtc;
    }

    private String cagrid;

    @javax.persistence.Column(name = "CAGRID")
    @Basic
    public String getCagrid() {
        return cagrid;
    }

    public void setCagrid(String cagrid) {
        this.cagrid = cagrid;
    }

    private String cagrif;

    @javax.persistence.Column(name = "CAGRIF")
    @Basic
    public String getCagrif() {
        return cagrif;
    }

    public void setCagrif(String cagrif) {
        this.cagrif = cagrif;
    }

    private String caelvf;

    @javax.persistence.Column(name = "CAELVF")
    @Basic
    public String getCaelvf() {
        return caelvf;
    }

    public void setCaelvf(String caelvf) {
        this.caelvf = caelvf;
    }

    private String caelvd;

    @javax.persistence.Column(name = "CAELVD")
    @Basic
    public String getCaelvd() {
        return caelvd;
    }

    public void setCaelvd(String caelvd) {
        this.caelvd = caelvd;
    }

    private String caelcd;

    @javax.persistence.Column(name = "CAELCD")
    @Basic
    public String getCaelcd() {
        return caelcd;
    }

    public void setCaelcd(String caelcd) {
        this.caelcd = caelcd;
    }

    private String caelcr;

    @javax.persistence.Column(name = "CAELCR")
    @Basic
    public String getCaelcr() {
        return caelcr;
    }

    public void setCaelcr(String caelcr) {
        this.caelcr = caelcr;
    }

    private String caelvs;

    @javax.persistence.Column(name = "CAELVS")
    @Basic
    public String getCaelvs() {
        return caelvs;
    }

    public void setCaelvs(String caelvs) {
        this.caelvs = caelvs;
    }

    private String caprc;

    @javax.persistence.Column(name = "CAPRC")
    @Basic
    public String getCaprc() {
        return caprc;
    }

    public void setCaprc(String caprc) {
        this.caprc = caprc;
    }

    private String caprco;

    @javax.persistence.Column(name = "CAPRCO")
    @Basic
    public String getCaprco() {
        return caprco;
    }

    public void setCaprco(String caprco) {
        this.caprco = caprco;
    }

    private String caprcd;

    @javax.persistence.Column(name = "CAPRCD")
    @Basic
    public String getCaprcd() {
        return caprcd;
    }

    public void setCaprcd(String caprcd) {
        this.caprcd = caprcd;
    }

    private String caprcu;

    @javax.persistence.Column(name = "CAPRCU")
    @Basic
    public String getCaprcu() {
        return caprcu;
    }

    public void setCaprcu(String caprcu) {
        this.caprcu = caprcu;
    }

    private String careni;

    @javax.persistence.Column(name = "CARENI")
    @Basic
    public String getCareni() {
        return careni;
    }

    public void setCareni(String careni) {
        this.careni = careni;
    }

    private String carenp;

    @javax.persistence.Column(name = "CARENP")
    @Basic
    public String getCarenp() {
        return carenp;
    }

    public void setCarenp(String carenp) {
        this.carenp = carenp;
    }

    private String capypc;

    @javax.persistence.Column(name = "CAPYPC")
    @Basic
    public String getCapypc() {
        return capypc;
    }

    public void setCapypc(String capypc) {
        this.capypc = capypc;
    }

    private String capypf;

    @javax.persistence.Column(name = "CAPYPF")
    @Basic
    public String getCapypf() {
        return capypf;
    }

    public void setCapypf(String capypf) {
        this.capypf = capypf;
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

    private String capred;

    @javax.persistence.Column(name = "CAPRED")
    @Basic
    public String getCapred() {
        return capred;
    }

    public void setCapred(String capred) {
        this.capred = capred;
    }

    private BigDecimal carese;

    @javax.persistence.Column(name = "CARESE")
    @Basic
    public BigDecimal getCarese() {
        return carese;
    }

    public void setCarese(BigDecimal carese) {
        this.carese = carese;
    }

    private String cagpav;

    @javax.persistence.Column(name = "CAGPAV")
    @Basic
    public String getCagpav() {
        return cagpav;
    }

    public void setCagpav(String cagpav) {
        this.cagpav = cagpav;
    }

    private String cagpad;

    @javax.persistence.Column(name = "CAGPAD")
    @Basic
    public String getCagpad() {
        return cagpad;
    }

    public void setCagpad(String cagpad) {
        this.cagpad = cagpad;
    }

    private String catrst;

    @javax.persistence.Column(name = "CATRST")
    @Basic
    public String getCatrst() {
        return catrst;
    }

    public void setCatrst(String catrst) {
        this.catrst = catrst;
    }

    private String cainef;

    @javax.persistence.Column(name = "CAINEF")
    @Basic
    public String getCainef() {
        return cainef;
    }

    public void setCainef(String cainef) {
        this.cainef = cainef;
    }

    private String caines;

    @javax.persistence.Column(name = "CAINES")
    @Basic
    public String getCaines() {
        return caines;
    }

    public void setCaines(String caines) {
        this.caines = caines;
    }

    private String carstr;

    @javax.persistence.Column(name = "CARSTR")
    @Basic
    public String getCarstr() {
        return carstr;
    }

    public void setCarstr(String carstr) {
        this.carstr = carstr;
    }

    private BigDecimal caelrp;

    @javax.persistence.Column(name = "CAELRP")
    @Basic
    public BigDecimal getCaelrp() {
        return caelrp;
    }

    public void setCaelrp(BigDecimal caelrp) {
        this.caelrp = caelrp;
    }

    private BigDecimal caelfp;

    @javax.persistence.Column(name = "CAELFP")
    @Basic
    public BigDecimal getCaelfp() {
        return caelfp;
    }

    public void setCaelfp(BigDecimal caelfp) {
        this.caelfp = caelfp;
    }

    private BigDecimal caneed;

    @javax.persistence.Column(name = "CANEED")
    @Basic
    public BigDecimal getCaneed() {
        return caneed;
    }

    public void setCaneed(BigDecimal caneed) {
        this.caneed = caneed;
    }

    private BigDecimal canovr;

    @javax.persistence.Column(name = "CANOVR")
    @Basic
    public BigDecimal getCanovr() {
        return canovr;
    }

    public void setCanovr(BigDecimal canovr) {
        this.canovr = canovr;
    }

    private String caprgc;

    @javax.persistence.Column(name = "CAPRGC")
    @Basic
    public String getCaprgc() {
        return caprgc;
    }

    public void setCaprgc(String caprgc) {
        this.caprgc = caprgc;
    }

    private String caprgf;

    @javax.persistence.Column(name = "CAPRGF")
    @Basic
    public String getCaprgf() {
        return caprgf;
    }

    public void setCaprgf(String caprgf) {
        this.caprgf = caprgf;
    }

    private BigDecimal cascr;

    @javax.persistence.Column(name = "CASCR")
    @Basic
    public BigDecimal getCascr() {
        return cascr;
    }

    public void setCascr(BigDecimal cascr) {
        this.cascr = cascr;
    }

    private String cassaf;

    @javax.persistence.Column(name = "CASSAF")
    @Basic
    public String getCassaf() {
        return cassaf;
    }

    public void setCassaf(String cassaf) {
        this.cassaf = cassaf;
    }

    private String calndf;

    @javax.persistence.Column(name = "CALNDF")
    @Basic
    public String getCalndf() {
        return calndf;
    }

    public void setCalndf(String calndf) {
        this.calndf = calndf;
    }

    private String cadhsi;

    @javax.persistence.Column(name = "CADHSI")
    @Basic
    public String getCadhsi() {
        return cadhsi;
    }

    public void setCadhsi(String cadhsi) {
        this.cadhsi = cadhsi;
    }

    private String cagpaf;

    @javax.persistence.Column(name = "CAGPAF")
    @Basic
    public String getCagpaf() {
        return cagpaf;
    }

    public void setCagpaf(String cagpaf) {
        this.cagpaf = cagpaf;
    }

    private BigDecimal cahgpa;

    @javax.persistence.Column(name = "CAHGPA")
    @Basic
    public BigDecimal getCahgpa() {
        return cahgpa;
    }

    public void setCahgpa(BigDecimal cahgpa) {
        this.cahgpa = cahgpa;
    }

    private String cahsgd;

    @javax.persistence.Column(name = "CAHSGD")
    @Basic
    public String getCahsgd() {
        return cahsgd;
    }

    public void setCahsgd(String cahsgd) {
        this.cahsgd = cahsgd;
    }

    private BigDecimal cacgpa;

    @javax.persistence.Column(name = "CACGPA")
    @Basic
    public BigDecimal getCacgpa() {
        return cacgpa;
    }

    public void setCacgpa(BigDecimal cacgpa) {
        this.cacgpa = cacgpa;
    }

    private String caindf;

    @javax.persistence.Column(name = "CAINDF")
    @Basic
    public String getCaindf() {
        return caindf;
    }

    public void setCaindf(String caindf) {
        this.caindf = caindf;
    }

    private String cainel;

    @javax.persistence.Column(name = "CAINEL")
    @Basic
    public String getCainel() {
        return cainel;
    }

    public void setCainel(String cainel) {
        this.cainel = cainel;
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

    private BigDecimal catfar;

    @javax.persistence.Column(name = "CATFAR")
    @Basic
    public BigDecimal getCatfar() {
        return catfar;
    }

    public void setCatfar(BigDecimal catfar) {
        this.catfar = catfar;
    }

    private BigDecimal cabsar;

    @javax.persistence.Column(name = "CABSAR")
    @Basic
    public BigDecimal getCabsar() {
        return cabsar;
    }

    public void setCabsar(BigDecimal cabsar) {
        this.cabsar = cabsar;
    }

    private BigDecimal cataar;

    @javax.persistence.Column(name = "CATAAR")
    @Basic
    public BigDecimal getCataar() {
        return cataar;
    }

    public void setCataar(BigDecimal cataar) {
        this.cataar = cataar;
    }

    private BigDecimal cabudr;

    @javax.persistence.Column(name = "CABUDR")
    @Basic
    public BigDecimal getCabudr() {
        return cabudr;
    }

    public void setCabudr(BigDecimal cabudr) {
        this.cabudr = cabudr;
    }

    private BigDecimal caefcr;

    @javax.persistence.Column(name = "CAEFCR")
    @Basic
    public BigDecimal getCaefcr() {
        return caefcr;
    }

    public void setCaefcr(BigDecimal caefcr) {
        this.caefcr = caefcr;
    }

    private String cahser;

    @javax.persistence.Column(name = "CAHSER")
    @Basic
    public String getCahser() {
        return cahser;
    }

    public void setCahser(String cahser) {
        this.cahser = cahser;
    }

    private String caseci;

    @javax.persistence.Column(name = "CASECI")
    @Basic
    public String getCaseci() {
        return caseci;
    }

    public void setCaseci(String caseci) {
        this.caseci = caseci;
    }

    private String caprcm;

    @javax.persistence.Column(name = "CAPRCM")
    @Basic
    public String getCaprcm() {
        return caprcm;
    }

    public void setCaprcm(String caprcm) {
        this.caprcm = caprcm;
    }

    private BigDecimal cacoa;

    @javax.persistence.Column(name = "CACOA")
    @Basic
    public BigDecimal getCacoa() {
        return cacoa;
    }

    public void setCacoa(BigDecimal cacoa) {
        this.cacoa = cacoa;
    }

    private BigDecimal cacoao;

    @javax.persistence.Column(name = "CACOAO")
    @Basic
    public BigDecimal getCacoao() {
        return cacoao;
    }

    public void setCacoao(BigDecimal cacoao) {
        this.cacoao = cacoao;
    }

    private String caoay;

    @javax.persistence.Column(name = "CAOAY")
    @Basic
    public String getCaoay() {
        return caoay;
    }

    public void setCaoay(String caoay) {
        this.caoay = caoay;
    }

    private String caineo;

    @javax.persistence.Column(name = "CAINEO")
    @Basic
    public String getCaineo() {
        return caineo;
    }

    public void setCaineo(String caineo) {
        this.caineo = caineo;
    }

    private String caisaw;

    @javax.persistence.Column(name = "CAISAW")
    @Basic
    public String getCaisaw() {
        return caisaw;
    }

    public void setCaisaw(String caisaw) {
        this.caisaw = caisaw;
    }

    private String cainss;

    @javax.persistence.Column(name = "CAINSS")
    @Basic
    public String getCainss() {
        return cainss;
    }

    public void setCainss(String cainss) {
        this.cainss = cainss;
    }

    private String cainso;

    @javax.persistence.Column(name = "CAINSO")
    @Basic
    public String getCainso() {
        return cainso;
    }

    public void setCainso(String cainso) {
        this.cainso = cainso;
    }

    private String caprcs;

    @javax.persistence.Column(name = "CAPRCS")
    @Basic
    public String getCaprcs() {
        return caprcs;
    }

    public void setCaprcs(String caprcs) {
        this.caprcs = caprcs;
    }

    private String caprso;

    @javax.persistence.Column(name = "CAPRSO")
    @Basic
    public String getCaprso() {
        return caprso;
    }

    public void setCaprso(String caprso) {
        this.caprso = caprso;
    }

    private BigDecimal caaypu;

    @javax.persistence.Column(name = "CAAYPU")
    @Basic
    public BigDecimal getCaaypu() {
        return caaypu;
    }

    public void setCaaypu(BigDecimal caaypu) {
        this.caaypu = caaypu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaEntity staEntity = (StaEntity) o;

        if (aidyr != null ? !aidyr.equals(staEntity.aidyr) : staEntity.aidyr != null) return false;
        if (caacar != null ? !caacar.equals(staEntity.caacar) : staEntity.caacar != null) return false;
        if (caaypu != null ? !caaypu.equals(staEntity.caaypu) : staEntity.caaypu != null) return false;
        if (cabsar != null ? !cabsar.equals(staEntity.cabsar) : staEntity.cabsar != null) return false;
        if (cabudr != null ? !cabudr.equals(staEntity.cabudr) : staEntity.cabudr != null) return false;
        if (cacgpa != null ? !cacgpa.equals(staEntity.cacgpa) : staEntity.cacgpa != null) return false;
        if (cacoa != null ? !cacoa.equals(staEntity.cacoa) : staEntity.cacoa != null) return false;
        if (cacoao != null ? !cacoao.equals(staEntity.cacoao) : staEntity.cacoao != null) return false;
        if (cadhsi != null ? !cadhsi.equals(staEntity.cadhsi) : staEntity.cadhsi != null) return false;
        if (caefcr != null ? !caefcr.equals(staEntity.caefcr) : staEntity.caefcr != null) return false;
        if (caelcd != null ? !caelcd.equals(staEntity.caelcd) : staEntity.caelcd != null) return false;
        if (caelcr != null ? !caelcr.equals(staEntity.caelcr) : staEntity.caelcr != null) return false;
        if (caelfp != null ? !caelfp.equals(staEntity.caelfp) : staEntity.caelfp != null) return false;
        if (caelrp != null ? !caelrp.equals(staEntity.caelrp) : staEntity.caelrp != null) return false;
        if (caelvd != null ? !caelvd.equals(staEntity.caelvd) : staEntity.caelvd != null) return false;
        if (caelvf != null ? !caelvf.equals(staEntity.caelvf) : staEntity.caelvf != null) return false;
        if (caelvs != null ? !caelvs.equals(staEntity.caelvs) : staEntity.caelvs != null) return false;
        if (cagpad != null ? !cagpad.equals(staEntity.cagpad) : staEntity.cagpad != null) return false;
        if (cagpaf != null ? !cagpaf.equals(staEntity.cagpaf) : staEntity.cagpaf != null) return false;
        if (cagpav != null ? !cagpav.equals(staEntity.cagpav) : staEntity.cagpav != null) return false;
        if (cagrid != null ? !cagrid.equals(staEntity.cagrid) : staEntity.cagrid != null) return false;
        if (cagrif != null ? !cagrif.equals(staEntity.cagrif) : staEntity.cagrif != null) return false;
        if (cahgpa != null ? !cahgpa.equals(staEntity.cahgpa) : staEntity.cahgpa != null) return false;
        if (cahser != null ? !cahser.equals(staEntity.cahser) : staEntity.cahser != null) return false;
        if (cahsgd != null ? !cahsgd.equals(staEntity.cahsgd) : staEntity.cahsgd != null) return false;
        if (caindf != null ? !caindf.equals(staEntity.caindf) : staEntity.caindf != null) return false;
        if (cainef != null ? !cainef.equals(staEntity.cainef) : staEntity.cainef != null) return false;
        if (cainel != null ? !cainel.equals(staEntity.cainel) : staEntity.cainel != null) return false;
        if (caineo != null ? !caineo.equals(staEntity.caineo) : staEntity.caineo != null) return false;
        if (caines != null ? !caines.equals(staEntity.caines) : staEntity.caines != null) return false;
        if (cainso != null ? !cainso.equals(staEntity.cainso) : staEntity.cainso != null) return false;
        if (cainss != null ? !cainss.equals(staEntity.cainss) : staEntity.cainss != null) return false;
        if (caisaw != null ? !caisaw.equals(staEntity.caisaw) : staEntity.caisaw != null) return false;
        if (calndf != null ? !calndf.equals(staEntity.calndf) : staEntity.calndf != null) return false;
        if (caneed != null ? !caneed.equals(staEntity.caneed) : staEntity.caneed != null) return false;
        if (canovr != null ? !canovr.equals(staEntity.canovr) : staEntity.canovr != null) return false;
        if (caoay != null ? !caoay.equals(staEntity.caoay) : staEntity.caoay != null) return false;
        if (capexd != null ? !capexd.equals(staEntity.capexd) : staEntity.capexd != null) return false;
        if (capexf != null ? !capexf.equals(staEntity.capexf) : staEntity.capexf != null) return false;
        if (caprc != null ? !caprc.equals(staEntity.caprc) : staEntity.caprc != null) return false;
        if (caprcd != null ? !caprcd.equals(staEntity.caprcd) : staEntity.caprcd != null) return false;
        if (caprcm != null ? !caprcm.equals(staEntity.caprcm) : staEntity.caprcm != null) return false;
        if (caprco != null ? !caprco.equals(staEntity.caprco) : staEntity.caprco != null) return false;
        if (caprcs != null ? !caprcs.equals(staEntity.caprcs) : staEntity.caprcs != null) return false;
        if (caprcu != null ? !caprcu.equals(staEntity.caprcu) : staEntity.caprcu != null) return false;
        if (capred != null ? !capred.equals(staEntity.capred) : staEntity.capred != null) return false;
        if (caprgc != null ? !caprgc.equals(staEntity.caprgc) : staEntity.caprgc != null) return false;
        if (caprgf != null ? !caprgf.equals(staEntity.caprgf) : staEntity.caprgf != null) return false;
        if (caprso != null ? !caprso.equals(staEntity.caprso) : staEntity.caprso != null) return false;
        if (capypc != null ? !capypc.equals(staEntity.capypc) : staEntity.capypc != null) return false;
        if (capypf != null ? !capypf.equals(staEntity.capypf) : staEntity.capypf != null) return false;
        if (careni != null ? !careni.equals(staEntity.careni) : staEntity.careni != null) return false;
        if (carenp != null ? !carenp.equals(staEntity.carenp) : staEntity.carenp != null) return false;
        if (carese != null ? !carese.equals(staEntity.carese) : staEntity.carese != null) return false;
        if (carstr != null ? !carstr.equals(staEntity.carstr) : staEntity.carstr != null) return false;
        if (cascr != null ? !cascr.equals(staEntity.cascr) : staEntity.cascr != null) return false;
        if (caseci != null ? !caseci.equals(staEntity.caseci) : staEntity.caseci != null) return false;
        if (cassaf != null ? !cassaf.equals(staEntity.cassaf) : staEntity.cassaf != null) return false;
        if (cataar != null ? !cataar.equals(staEntity.cataar) : staEntity.cataar != null) return false;
        if (catfar != null ? !catfar.equals(staEntity.catfar) : staEntity.catfar != null) return false;
        if (catrst != null ? !catrst.equals(staEntity.catrst) : staEntity.catrst != null) return false;
        if (crtdate != null ? !crtdate.equals(staEntity.crtdate) : staEntity.crtdate != null) return false;
        if (crtmod != null ? !crtmod.equals(staEntity.crtmod) : staEntity.crtmod != null) return false;
        if (crttime != null ? !crttime.equals(staEntity.crttime) : staEntity.crttime != null) return false;
        if (crtuser != null ? !crtuser.equals(staEntity.crtuser) : staEntity.crtuser != null) return false;
        if (recstat != null ? !recstat.equals(staEntity.recstat) : staEntity.recstat != null) return false;
        if (revdate != null ? !revdate.equals(staEntity.revdate) : staEntity.revdate != null) return false;
        if (revlev != null ? !revlev.equals(staEntity.revlev) : staEntity.revlev != null) return false;
        if (revmod != null ? !revmod.equals(staEntity.revmod) : staEntity.revmod != null) return false;
        if (revtime != null ? !revtime.equals(staEntity.revtime) : staEntity.revtime != null) return false;
        if (revuser != null ? !revuser.equals(staEntity.revuser) : staEntity.revuser != null) return false;
        if (sid != null ? !sid.equals(staEntity.sid) : staEntity.sid != null) return false;
        if (stakey != null ? !stakey.equals(staEntity.stakey) : staEntity.stakey != null) return false;
        if (ucode != null ? !ucode.equals(staEntity.ucode) : staEntity.ucode != null) return false;
        if (user1 != null ? !user1.equals(staEntity.user1) : staEntity.user1 != null) return false;
        if (user10 != null ? !user10.equals(staEntity.user10) : staEntity.user10 != null) return false;
        if (user11 != null ? !user11.equals(staEntity.user11) : staEntity.user11 != null) return false;
        if (user12 != null ? !user12.equals(staEntity.user12) : staEntity.user12 != null) return false;
        if (user13 != null ? !user13.equals(staEntity.user13) : staEntity.user13 != null) return false;
        if (user14 != null ? !user14.equals(staEntity.user14) : staEntity.user14 != null) return false;
        if (user15 != null ? !user15.equals(staEntity.user15) : staEntity.user15 != null) return false;
        if (user16 != null ? !user16.equals(staEntity.user16) : staEntity.user16 != null) return false;
        if (user17 != null ? !user17.equals(staEntity.user17) : staEntity.user17 != null) return false;
        if (user18 != null ? !user18.equals(staEntity.user18) : staEntity.user18 != null) return false;
        if (user19 != null ? !user19.equals(staEntity.user19) : staEntity.user19 != null) return false;
        if (user2 != null ? !user2.equals(staEntity.user2) : staEntity.user2 != null) return false;
        if (user20 != null ? !user20.equals(staEntity.user20) : staEntity.user20 != null) return false;
        if (user3 != null ? !user3.equals(staEntity.user3) : staEntity.user3 != null) return false;
        if (user4 != null ? !user4.equals(staEntity.user4) : staEntity.user4 != null) return false;
        if (user5 != null ? !user5.equals(staEntity.user5) : staEntity.user5 != null) return false;
        if (user6 != null ? !user6.equals(staEntity.user6) : staEntity.user6 != null) return false;
        if (user7 != null ? !user7.equals(staEntity.user7) : staEntity.user7 != null) return false;
        if (user8 != null ? !user8.equals(staEntity.user8) : staEntity.user8 != null) return false;
        if (user9 != null ? !user9.equals(staEntity.user9) : staEntity.user9 != null) return false;
        if (usrdt1 != null ? !usrdt1.equals(staEntity.usrdt1) : staEntity.usrdt1 != null) return false;
        if (usrdt2 != null ? !usrdt2.equals(staEntity.usrdt2) : staEntity.usrdt2 != null) return false;
        if (usrdt3 != null ? !usrdt3.equals(staEntity.usrdt3) : staEntity.usrdt3 != null) return false;
        if (usrdt4 != null ? !usrdt4.equals(staEntity.usrdt4) : staEntity.usrdt4 != null) return false;
        if (usrdt5 != null ? !usrdt5.equals(staEntity.usrdt5) : staEntity.usrdt5 != null) return false;
        if (usrdt6 != null ? !usrdt6.equals(staEntity.usrdt6) : staEntity.usrdt6 != null) return false;
        if (usrdt7 != null ? !usrdt7.equals(staEntity.usrdt7) : staEntity.usrdt7 != null) return false;
        if (usrdt8 != null ? !usrdt8.equals(staEntity.usrdt8) : staEntity.usrdt8 != null) return false;
        if (usrdt9 != null ? !usrdt9.equals(staEntity.usrdt9) : staEntity.usrdt9 != null) return false;
        if (usrdta != null ? !usrdta.equals(staEntity.usrdta) : staEntity.usrdta != null) return false;
        if (usrdtb != null ? !usrdtb.equals(staEntity.usrdtb) : staEntity.usrdtb != null) return false;
        if (usrdtc != null ? !usrdtc.equals(staEntity.usrdtc) : staEntity.usrdtc != null) return false;
        if (usrnr1 != null ? !usrnr1.equals(staEntity.usrnr1) : staEntity.usrnr1 != null) return false;
        if (usrnr2 != null ? !usrnr2.equals(staEntity.usrnr2) : staEntity.usrnr2 != null) return false;
        if (usrnr3 != null ? !usrnr3.equals(staEntity.usrnr3) : staEntity.usrnr3 != null) return false;
        if (usrnr4 != null ? !usrnr4.equals(staEntity.usrnr4) : staEntity.usrnr4 != null) return false;
        if (usrnr5 != null ? !usrnr5.equals(staEntity.usrnr5) : staEntity.usrnr5 != null) return false;
        if (usrnr6 != null ? !usrnr6.equals(staEntity.usrnr6) : staEntity.usrnr6 != null) return false;
        if (usrnr7 != null ? !usrnr7.equals(staEntity.usrnr7) : staEntity.usrnr7 != null) return false;
        if (usrnr8 != null ? !usrnr8.equals(staEntity.usrnr8) : staEntity.usrnr8 != null) return false;
        if (usrnr9 != null ? !usrnr9.equals(staEntity.usrnr9) : staEntity.usrnr9 != null) return false;
        if (usrnra != null ? !usrnra.equals(staEntity.usrnra) : staEntity.usrnra != null) return false;
        if (usrnrb != null ? !usrnrb.equals(staEntity.usrnrb) : staEntity.usrnrb != null) return false;
        if (usrnrc != null ? !usrnrc.equals(staEntity.usrnrc) : staEntity.usrnrc != null) return false;
        if (usrnrd != null ? !usrnrd.equals(staEntity.usrnrd) : staEntity.usrnrd != null) return false;
        if (usrnre != null ? !usrnre.equals(staEntity.usrnre) : staEntity.usrnre != null) return false;
        if (usrnrf != null ? !usrnrf.equals(staEntity.usrnrf) : staEntity.usrnrf != null) return false;
        if (usrnrg != null ? !usrnrg.equals(staEntity.usrnrg) : staEntity.usrnrg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (stakey != null ? stakey.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (crtdate != null ? crtdate.hashCode() : 0);
        result = 31 * result + (crttime != null ? crttime.hashCode() : 0);
        result = 31 * result + (crtuser != null ? crtuser.hashCode() : 0);
        result = 31 * result + (crtmod != null ? crtmod.hashCode() : 0);
        result = 31 * result + (revdate != null ? revdate.hashCode() : 0);
        result = 31 * result + (revtime != null ? revtime.hashCode() : 0);
        result = 31 * result + (revuser != null ? revuser.hashCode() : 0);
        result = 31 * result + (revmod != null ? revmod.hashCode() : 0);
        result = 31 * result + (revlev != null ? revlev.hashCode() : 0);
        result = 31 * result + (ucode != null ? ucode.hashCode() : 0);
        result = 31 * result + (user1 != null ? user1.hashCode() : 0);
        result = 31 * result + (user2 != null ? user2.hashCode() : 0);
        result = 31 * result + (user3 != null ? user3.hashCode() : 0);
        result = 31 * result + (user4 != null ? user4.hashCode() : 0);
        result = 31 * result + (user5 != null ? user5.hashCode() : 0);
        result = 31 * result + (user6 != null ? user6.hashCode() : 0);
        result = 31 * result + (user7 != null ? user7.hashCode() : 0);
        result = 31 * result + (user8 != null ? user8.hashCode() : 0);
        result = 31 * result + (user9 != null ? user9.hashCode() : 0);
        result = 31 * result + (user10 != null ? user10.hashCode() : 0);
        result = 31 * result + (user11 != null ? user11.hashCode() : 0);
        result = 31 * result + (user12 != null ? user12.hashCode() : 0);
        result = 31 * result + (user13 != null ? user13.hashCode() : 0);
        result = 31 * result + (user14 != null ? user14.hashCode() : 0);
        result = 31 * result + (user15 != null ? user15.hashCode() : 0);
        result = 31 * result + (user16 != null ? user16.hashCode() : 0);
        result = 31 * result + (user17 != null ? user17.hashCode() : 0);
        result = 31 * result + (user18 != null ? user18.hashCode() : 0);
        result = 31 * result + (user19 != null ? user19.hashCode() : 0);
        result = 31 * result + (user20 != null ? user20.hashCode() : 0);
        result = 31 * result + (usrnr1 != null ? usrnr1.hashCode() : 0);
        result = 31 * result + (usrnr2 != null ? usrnr2.hashCode() : 0);
        result = 31 * result + (usrnr3 != null ? usrnr3.hashCode() : 0);
        result = 31 * result + (usrnr4 != null ? usrnr4.hashCode() : 0);
        result = 31 * result + (usrnr5 != null ? usrnr5.hashCode() : 0);
        result = 31 * result + (usrnr6 != null ? usrnr6.hashCode() : 0);
        result = 31 * result + (usrnr7 != null ? usrnr7.hashCode() : 0);
        result = 31 * result + (usrnr8 != null ? usrnr8.hashCode() : 0);
        result = 31 * result + (usrnr9 != null ? usrnr9.hashCode() : 0);
        result = 31 * result + (usrnra != null ? usrnra.hashCode() : 0);
        result = 31 * result + (usrnrb != null ? usrnrb.hashCode() : 0);
        result = 31 * result + (usrnrc != null ? usrnrc.hashCode() : 0);
        result = 31 * result + (usrnrd != null ? usrnrd.hashCode() : 0);
        result = 31 * result + (usrnre != null ? usrnre.hashCode() : 0);
        result = 31 * result + (usrnrf != null ? usrnrf.hashCode() : 0);
        result = 31 * result + (usrnrg != null ? usrnrg.hashCode() : 0);
        result = 31 * result + (usrdt1 != null ? usrdt1.hashCode() : 0);
        result = 31 * result + (usrdt2 != null ? usrdt2.hashCode() : 0);
        result = 31 * result + (usrdt3 != null ? usrdt3.hashCode() : 0);
        result = 31 * result + (usrdt4 != null ? usrdt4.hashCode() : 0);
        result = 31 * result + (usrdt5 != null ? usrdt5.hashCode() : 0);
        result = 31 * result + (usrdt6 != null ? usrdt6.hashCode() : 0);
        result = 31 * result + (usrdt7 != null ? usrdt7.hashCode() : 0);
        result = 31 * result + (usrdt8 != null ? usrdt8.hashCode() : 0);
        result = 31 * result + (usrdt9 != null ? usrdt9.hashCode() : 0);
        result = 31 * result + (usrdta != null ? usrdta.hashCode() : 0);
        result = 31 * result + (usrdtb != null ? usrdtb.hashCode() : 0);
        result = 31 * result + (usrdtc != null ? usrdtc.hashCode() : 0);
        result = 31 * result + (cagrid != null ? cagrid.hashCode() : 0);
        result = 31 * result + (cagrif != null ? cagrif.hashCode() : 0);
        result = 31 * result + (caelvf != null ? caelvf.hashCode() : 0);
        result = 31 * result + (caelvd != null ? caelvd.hashCode() : 0);
        result = 31 * result + (caelcd != null ? caelcd.hashCode() : 0);
        result = 31 * result + (caelcr != null ? caelcr.hashCode() : 0);
        result = 31 * result + (caelvs != null ? caelvs.hashCode() : 0);
        result = 31 * result + (caprc != null ? caprc.hashCode() : 0);
        result = 31 * result + (caprco != null ? caprco.hashCode() : 0);
        result = 31 * result + (caprcd != null ? caprcd.hashCode() : 0);
        result = 31 * result + (caprcu != null ? caprcu.hashCode() : 0);
        result = 31 * result + (careni != null ? careni.hashCode() : 0);
        result = 31 * result + (carenp != null ? carenp.hashCode() : 0);
        result = 31 * result + (capypc != null ? capypc.hashCode() : 0);
        result = 31 * result + (capypf != null ? capypf.hashCode() : 0);
        result = 31 * result + (capexf != null ? capexf.hashCode() : 0);
        result = 31 * result + (capexd != null ? capexd.hashCode() : 0);
        result = 31 * result + (capred != null ? capred.hashCode() : 0);
        result = 31 * result + (carese != null ? carese.hashCode() : 0);
        result = 31 * result + (cagpav != null ? cagpav.hashCode() : 0);
        result = 31 * result + (cagpad != null ? cagpad.hashCode() : 0);
        result = 31 * result + (catrst != null ? catrst.hashCode() : 0);
        result = 31 * result + (cainef != null ? cainef.hashCode() : 0);
        result = 31 * result + (caines != null ? caines.hashCode() : 0);
        result = 31 * result + (carstr != null ? carstr.hashCode() : 0);
        result = 31 * result + (caelrp != null ? caelrp.hashCode() : 0);
        result = 31 * result + (caelfp != null ? caelfp.hashCode() : 0);
        result = 31 * result + (caneed != null ? caneed.hashCode() : 0);
        result = 31 * result + (canovr != null ? canovr.hashCode() : 0);
        result = 31 * result + (caprgc != null ? caprgc.hashCode() : 0);
        result = 31 * result + (caprgf != null ? caprgf.hashCode() : 0);
        result = 31 * result + (cascr != null ? cascr.hashCode() : 0);
        result = 31 * result + (cassaf != null ? cassaf.hashCode() : 0);
        result = 31 * result + (calndf != null ? calndf.hashCode() : 0);
        result = 31 * result + (cadhsi != null ? cadhsi.hashCode() : 0);
        result = 31 * result + (cagpaf != null ? cagpaf.hashCode() : 0);
        result = 31 * result + (cahgpa != null ? cahgpa.hashCode() : 0);
        result = 31 * result + (cahsgd != null ? cahsgd.hashCode() : 0);
        result = 31 * result + (cacgpa != null ? cacgpa.hashCode() : 0);
        result = 31 * result + (caindf != null ? caindf.hashCode() : 0);
        result = 31 * result + (cainel != null ? cainel.hashCode() : 0);
        result = 31 * result + (caacar != null ? caacar.hashCode() : 0);
        result = 31 * result + (catfar != null ? catfar.hashCode() : 0);
        result = 31 * result + (cabsar != null ? cabsar.hashCode() : 0);
        result = 31 * result + (cataar != null ? cataar.hashCode() : 0);
        result = 31 * result + (cabudr != null ? cabudr.hashCode() : 0);
        result = 31 * result + (caefcr != null ? caefcr.hashCode() : 0);
        result = 31 * result + (cahser != null ? cahser.hashCode() : 0);
        result = 31 * result + (caseci != null ? caseci.hashCode() : 0);
        result = 31 * result + (caprcm != null ? caprcm.hashCode() : 0);
        result = 31 * result + (cacoa != null ? cacoa.hashCode() : 0);
        result = 31 * result + (cacoao != null ? cacoao.hashCode() : 0);
        result = 31 * result + (caoay != null ? caoay.hashCode() : 0);
        result = 31 * result + (caineo != null ? caineo.hashCode() : 0);
        result = 31 * result + (caisaw != null ? caisaw.hashCode() : 0);
        result = 31 * result + (cainss != null ? cainss.hashCode() : 0);
        result = 31 * result + (cainso != null ? cainso.hashCode() : 0);
        result = 31 * result + (caprcs != null ? caprcs.hashCode() : 0);
        result = 31 * result + (caprso != null ? caprso.hashCode() : 0);
        result = 31 * result + (caaypu != null ? caaypu.hashCode() : 0);
        return result;
    }
}
