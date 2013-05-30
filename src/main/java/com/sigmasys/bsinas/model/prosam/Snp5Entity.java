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
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNP5", schema = "SIGMA", catalog = "")
@Entity
public class Snp5Entity implements Identifiable {

    @Override
    @Transient
    public String getId() {
        return getSnpkey();
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

    private String snpkey;

    @javax.persistence.Column(name = "SNPKEY")
    @Id
    public String getSnpkey() {
        return snpkey;
    }

    public void setSnpkey(String snpkey) {
        this.snpkey = snpkey;
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

    private String aidyr;

    @javax.persistence.Column(name = "AIDYR")
    @Basic
    public String getAidyr() {
        return aidyr;
    }

    public void setAidyr(String aidyr) {
        this.aidyr = aidyr;
    }

    private String cmptype;

    @javax.persistence.Column(name = "CMPTYPE")
    @Basic
    public String getCmptype() {
        return cmptype;
    }

    public void setCmptype(String cmptype) {
        this.cmptype = cmptype;
    }

    private String versnr;

    @javax.persistence.Column(name = "VERSNR")
    @Basic
    public String getVersnr() {
        return versnr;
    }

    public void setVersnr(String versnr) {
        this.versnr = versnr;
    }

    private String pbtuitcs;

    @javax.persistence.Column(name = "PBTUITCS")
    @Basic
    public String getPbtuitcs() {
        return pbtuitcs;
    }

    public void setPbtuitcs(String pbtuitcs) {
        this.pbtuitcs = pbtuitcs;
    }

    private String pbemalcs;

    @javax.persistence.Column(name = "PBEMALCS")
    @Basic
    public String getPbemalcs() {
        return pbemalcs;
    }

    public void setPbemalcs(String pbemalcs) {
        this.pbemalcs = pbemalcs;
    }

    private String pbsmacs;

    @javax.persistence.Column(name = "PBSMACS")
    @Basic
    public String getPbsmacs() {
        return pbsmacs;
    }

    public void setPbsmacs(String pbsmacs) {
        this.pbsmacs = pbsmacs;
    }

    private String pbial1Cs;

    @javax.persistence.Column(name = "PBIAL1CS")
    @Basic
    public String getPbial1Cs() {
        return pbial1Cs;
    }

    public void setPbial1Cs(String pbial1Cs) {
        this.pbial1Cs = pbial1Cs;
    }

    private String pbial2Cs;

    @javax.persistence.Column(name = "PBIAL2CS")
    @Basic
    public String getPbial2Cs() {
        return pbial2Cs;
    }

    public void setPbial2Cs(String pbial2Cs) {
        this.pbial2Cs = pbial2Cs;
    }

    private String pbtalocs;

    @javax.persistence.Column(name = "PBTALOCS")
    @Basic
    public String getPbtalocs() {
        return pbtalocs;
    }

    public void setPbtalocs(String pbtalocs) {
        this.pbtalocs = pbtalocs;
    }

    private String pbefincs;

    @javax.persistence.Column(name = "PBEFINCS")
    @Basic
    public String getPbefincs() {
        return pbefincs;
    }

    public void setPbefincs(String pbefincs) {
        this.pbefincs = pbefincs;
    }

    private String ptntics;

    @javax.persistence.Column(name = "PTNTICS")
    @Basic
    public String getPtntics() {
        return ptntics;
    }

    public void setPtntics(String ptntics) {
        this.ptntics = ptntics;
    }

    private String pbtutacs;

    @javax.persistence.Column(name = "PBTUTACS")
    @Basic
    public String getPbtutacs() {
        return pbtutacs;
    }

    public void setPbtutacs(String pbtutacs) {
        this.pbtutacs = pbtutacs;
    }

    private String pbnwrtcs;

    @javax.persistence.Column(name = "PBNWRTCS")
    @Basic
    public String getPbnwrtcs() {
        return pbnwrtcs;
    }

    public void setPbnwrtcs(String pbnwrtcs) {
        this.pbnwrtcs = pbnwrtcs;
    }

    private String pbapacs;

    @javax.persistence.Column(name = "PBAPACS")
    @Basic
    public String getPbapacs() {
        return pbapacs;
    }

    public void setPbapacs(String pbapacs) {
        this.pbapacs = pbapacs;
    }

    private String pbdnetcs;

    @javax.persistence.Column(name = "PBDNETCS")
    @Basic
    public String getPbdnetcs() {
        return pbdnetcs;
    }

    public void setPbdnetcs(String pbdnetcs) {
        this.pbdnetcs = pbdnetcs;
    }

    private String pbascrcs;

    @javax.persistence.Column(name = "PBASCRCS")
    @Basic
    public String getPbascrcs() {
        return pbascrcs;
    }

    public void setPbascrcs(String pbascrcs) {
        this.pbascrcs = pbascrcs;
    }

    private String pbincscs;

    @javax.persistence.Column(name = "PBINCSCS")
    @Basic
    public String getPbincscs() {
        return pbincscs;
    }

    public void setPbincscs(String pbincscs) {
        this.pbincscs = pbincscs;
    }

    private String pbaavlcs;

    @javax.persistence.Column(name = "PBAAVLCS")
    @Basic
    public String getPbaavlcs() {
        return pbaavlcs;
    }

    public void setPbaavlcs(String pbaavlcs) {
        this.pbaavlcs = pbaavlcs;
    }

    private String pbhomecs;

    @javax.persistence.Column(name = "PBHOMECS")
    @Basic
    public String getPbhomecs() {
        return pbhomecs;
    }

    public void setPbhomecs(String pbhomecs) {
        this.pbhomecs = pbhomecs;
    }

    private String pbabfwcs;

    @javax.persistence.Column(name = "PBABFWCS")
    @Basic
    public String getPbabfwcs() {
        return pbabfwcs;
    }

    public void setPbabfwcs(String pbabfwcs) {
        this.pbabfwcs = pbabfwcs;
    }

    private String pbconfcs;

    @javax.persistence.Column(name = "PBCONFCS")
    @Basic
    public String getPbconfcs() {
        return pbconfcs;
    }

    public void setPbconfcs(String pbconfcs) {
        this.pbconfcs = pbconfcs;
    }

    private String pexcldcs;

    @javax.persistence.Column(name = "PEXCLDCS")
    @Basic
    public String getPexcldcs() {
        return pexcldcs;
    }

    public void setPexcldcs(String pexcldcs) {
        this.pexcldcs = pexcldcs;
    }

    private String phvplucs;

    @javax.persistence.Column(name = "PHVPLUCS")
    @Basic
    public String getPhvplucs() {
        return phvplucs;
    }

    public void setPhvplucs(String phvplucs) {
        this.phvplucs = phvplucs;
    }

    private String pinccrcs;

    @javax.persistence.Column(name = "PINCCRCS")
    @Basic
    public String getPinccrcs() {
        return pinccrcs;
    }

    public void setPinccrcs(String pinccrcs) {
        this.pinccrcs = pinccrcs;
    }

    private String sbasetcs;

    @javax.persistence.Column(name = "SBASETCS")
    @Basic
    public String getSbasetcs() {
        return sbasetcs;
    }

    public void setSbasetcs(String sbasetcs) {
        this.sbasetcs = sbasetcs;
    }

    private String lonchg1;

    @javax.persistence.Column(name = "LONCHG1")
    @Basic
    public String getLonchg1() {
        return lonchg1;
    }

    public void setLonchg1(String lonchg1) {
        this.lonchg1 = lonchg1;
    }

    private String lonchg2;

    @javax.persistence.Column(name = "LONCHG2")
    @Basic
    public String getLonchg2() {
        return lonchg2;
    }

    public void setLonchg2(String lonchg2) {
        this.lonchg2 = lonchg2;
    }

    private String lonchg3;

    @javax.persistence.Column(name = "LONCHG3")
    @Basic
    public String getLonchg3() {
        return lonchg3;
    }

    public void setLonchg3(String lonchg3) {
        this.lonchg3 = lonchg3;
    }

    private String lonchg4;

    @javax.persistence.Column(name = "LONCHG4")
    @Basic
    public String getLonchg4() {
        return lonchg4;
    }

    public void setLonchg4(String lonchg4) {
        this.lonchg4 = lonchg4;
    }

    private String lonchg5;

    @javax.persistence.Column(name = "LONCHG5")
    @Basic
    public String getLonchg5() {
        return lonchg5;
    }

    public void setLonchg5(String lonchg5) {
        this.lonchg5 = lonchg5;
    }

    private String lonchg6;

    @javax.persistence.Column(name = "LONCHG6")
    @Basic
    public String getLonchg6() {
        return lonchg6;
    }

    public void setLonchg6(String lonchg6) {
        this.lonchg6 = lonchg6;
    }

    private String lonchg7;

    @javax.persistence.Column(name = "LONCHG7")
    @Basic
    public String getLonchg7() {
        return lonchg7;
    }

    public void setLonchg7(String lonchg7) {
        this.lonchg7 = lonchg7;
    }

    private String lonchg8;

    @javax.persistence.Column(name = "LONCHG8")
    @Basic
    public String getLonchg8() {
        return lonchg8;
    }

    public void setLonchg8(String lonchg8) {
        this.lonchg8 = lonchg8;
    }

    private String lonchg9;

    @javax.persistence.Column(name = "LONCHG9")
    @Basic
    public String getLonchg9() {
        return lonchg9;
    }

    public void setLonchg9(String lonchg9) {
        this.lonchg9 = lonchg9;
    }

    private String lonchg10;

    @javax.persistence.Column(name = "LONCHG10")
    @Basic
    public String getLonchg10() {
        return lonchg10;
    }

    public void setLonchg10(String lonchg10) {
        this.lonchg10 = lonchg10;
    }

    private String lonchg11;

    @javax.persistence.Column(name = "LONCHG11")
    @Basic
    public String getLonchg11() {
        return lonchg11;
    }

    public void setLonchg11(String lonchg11) {
        this.lonchg11 = lonchg11;
    }

    private String lonchg12;

    @javax.persistence.Column(name = "LONCHG12")
    @Basic
    public String getLonchg12() {
        return lonchg12;
    }

    public void setLonchg12(String lonchg12) {
        this.lonchg12 = lonchg12;
    }

    private String namflcs;

    @javax.persistence.Column(name = "NAMFLCS")
    @Basic
    public String getNamflcs() {
        return namflcs;
    }

    public void setNamflcs(String namflcs) {
        this.namflcs = namflcs;
    }

    private String ssnfacs;

    @javax.persistence.Column(name = "SSNFACS")
    @Basic
    public String getSsnfacs() {
        return ssnfacs;
    }

    public void setSsnfacs(String ssnfacs) {
        this.ssnfacs = ssnfacs;
    }

    private String nammlcs;

    @javax.persistence.Column(name = "NAMMLCS")
    @Basic
    public String getNammlcs() {
        return nammlcs;
    }

    public void setNammlcs(String nammlcs) {
        this.nammlcs = nammlcs;
    }

    private String ssnmocs;

    @javax.persistence.Column(name = "SSNMOCS")
    @Basic
    public String getSsnmocs() {
        return ssnmocs;
    }

    public void setSsnmocs(String ssnmocs) {
        this.ssnmocs = ssnmocs;
    }

    private String pinca1L;

    @javax.persistence.Column(name = "PINCA1L")
    @Basic
    public String getPinca1L() {
        return pinca1L;
    }

    public void setPinca1L(String pinca1L) {
        this.pinca1L = pinca1L;
    }

    private String pinca2L;

    @javax.persistence.Column(name = "PINCA2L")
    @Basic
    public String getPinca2L() {
        return pinca2L;
    }

    public void setPinca2L(String pinca2L) {
        this.pinca2L = pinca2L;
    }

    private String pialo1L;

    @javax.persistence.Column(name = "PIALO1L")
    @Basic
    public String getPialo1L() {
        return pialo1L;
    }

    public void setPialo1L(String pialo1L) {
        this.pialo1L = pialo1L;
    }

    private String pialo2L;

    @javax.persistence.Column(name = "PIALO2L")
    @Basic
    public String getPialo2L() {
        return pialo2L;
    }

    public void setPialo2L(String pialo2L) {
        this.pialo2L = pialo2L;
    }

    private String pbincal;

    @javax.persistence.Column(name = "PBINCAL")
    @Basic
    public String getPbincal() {
        return pbincal;
    }

    public void setPbincal(String pbincal) {
        this.pbincal = pbincal;
    }

    private String pbial1L;

    @javax.persistence.Column(name = "PBIAL1L")
    @Basic
    public String getPbial1L() {
        return pbial1L;
    }

    public void setPbial1L(String pbial1L) {
        this.pbial1L = pbial1L;
    }

    private String pbial2L;

    @javax.persistence.Column(name = "PBIAL2L")
    @Basic
    public String getPbial2L() {
        return pbial2L;
    }

    public void setPbial2L(String pbial2L) {
        this.pbial2L = pbial2L;
    }

    private String passadl;

    @javax.persistence.Column(name = "PASSADL")
    @Basic
    public String getPassadl() {
        return passadl;
    }

    public void setPassadl(String passadl) {
        this.passadl = passadl;
    }

    private String depstf;

    @javax.persistence.Column(name = "DEPSTF")
    @Basic
    public String getDepstf() {
        return depstf;
    }

    public void setDepstf(String depstf) {
        this.depstf = depstf;
    }

    private String ptyp;

    @javax.persistence.Column(name = "PTYP")
    @Basic
    public String getPtyp() {
        return ptyp;
    }

    public void setPtyp(String ptyp) {
        this.ptyp = ptyp;
    }

    private String styp;

    @javax.persistence.Column(name = "STYP")
    @Basic
    public String getStyp() {
        return styp;
    }

    public void setStyp(String styp) {
        this.styp = styp;
    }

    private String depsti;

    @javax.persistence.Column(name = "DEPSTI")
    @Basic
    public String getDepsti() {
        return depsti;
    }

    public void setDepsti(String depsti) {
        this.depsti = depsti;
    }

    private String iptyp;

    @javax.persistence.Column(name = "IPTYP")
    @Basic
    public String getIptyp() {
        return iptyp;
    }

    public void setIptyp(String iptyp) {
        this.iptyp = iptyp;
    }

    private String istyp;

    @javax.persistence.Column(name = "ISTYP")
    @Basic
    public String getIstyp() {
        return istyp;
    }

    public void setIstyp(String istyp) {
        this.istyp = istyp;
    }

    private int psai;

    @javax.persistence.Column(name = "PSAI")
    @Basic
    public int getPsai() {
        return psai;
    }

    public void setPsai(int psai) {
        this.psai = psai;
    }

    private int ptfcf;

    @javax.persistence.Column(name = "PTFCF")
    @Basic
    public int getPtfcf() {
        return ptfcf;
    }

    public void setPtfcf(int ptfcf) {
        this.ptfcf = ptfcf;
    }

    private int ipsaia;

    @javax.persistence.Column(name = "IPSAIA")
    @Basic
    public int getIpsaia() {
        return ipsaia;
    }

    public void setIpsaia(int ipsaia) {
        this.ipsaia = ipsaia;
    }

    private int iptfcfw;

    @javax.persistence.Column(name = "IPTFCFW")
    @Basic
    public int getIptfcfw() {
        return iptfcfw;
    }

    public void setIptfcfw(int iptfcfw) {
        this.iptfcfw = iptfcfw;
    }

    private int napitx;

    @javax.persistence.Column(name = "NAPITX")
    @Basic
    public int getNapitx() {
        return napitx;
    }

    public void setNapitx(int napitx) {
        this.napitx = napitx;
    }

    private int napditx;

    @javax.persistence.Column(name = "NAPDITX")
    @Basic
    public int getNapditx() {
        return napditx;
    }

    public void setNapditx(int napditx) {
        this.napditx = napditx;
    }

    private String tranrdt;

    @javax.persistence.Column(name = "TRANRDT")
    @Basic
    public String getTranrdt() {
        return tranrdt;
    }

    public void setTranrdt(String tranrdt) {
        this.tranrdt = tranrdt;
    }

    private String sitercd;

    @javax.persistence.Column(name = "SITERCD")
    @Basic
    public String getSitercd() {
        return sitercd;
    }

    public void setSitercd(String sitercd) {
        this.sitercd = sitercd;
    }

    private String appsscd;

    @javax.persistence.Column(name = "APPSSCD")
    @Basic
    public String getAppsscd() {
        return appsscd;
    }

    public void setAppsscd(String appsscd) {
        this.appsscd = appsscd;
    }

    private String nsldsno;

    @javax.persistence.Column(name = "NSLDSNO")
    @Basic
    public String getNsldsno() {
        return nsldsno;
    }

    public void setNsldsno(String nsldsno) {
        this.nsldsno = nsldsno;
    }

    private String reprrsn;

    @javax.persistence.Column(name = "REPRRSN")
    @Basic
    public String getReprrsn() {
        return reprrsn;
    }

    public void setReprrsn(String reprrsn) {
        this.reprrsn = reprrsn;
    }

    private int pasumss;

    @javax.persistence.Column(name = "PASUMSS")
    @Basic
    public int getPasumss() {
        return pasumss;
    }

    public void setPasumss(int pasumss) {
        this.pasumss = pasumss;
    }

    private int agspdis;

    @javax.persistence.Column(name = "AGSPDIS")
    @Basic
    public int getAgspdis() {
        return agspdis;
    }

    public void setAgspdis(int agspdis) {
        this.agspdis = agspdis;
    }

    private int aguspds;

    @javax.persistence.Column(name = "AGUSPDS")
    @Basic
    public int getAguspds() {
        return aguspds;
    }

    public void setAguspds(int aguspds) {
        this.aguspds = aguspds;
    }

    private int agcpdis;

    @javax.persistence.Column(name = "AGCPDIS")
    @Basic
    public int getAgcpdis() {
        return agcpdis;
    }

    public void setAgcpdis(int agcpdis) {
        this.agcpdis = agcpdis;
    }

    private int agstot;

    @javax.persistence.Column(name = "AGSTOT")
    @Basic
    public int getAgstot() {
        return agstot;
    }

    public void setAgstot(int agstot) {
        this.agstot = agstot;
    }

    private int agustot;

    @javax.persistence.Column(name = "AGUSTOT")
    @Basic
    public int getAgustot() {
        return agustot;
    }

    public void setAgustot(int agustot) {
        this.agustot = agustot;
    }

    private int agctot;

    @javax.persistence.Column(name = "AGCTOT")
    @Basic
    public int getAgctot() {
        return agctot;
    }

    public void setAgctot(int agctot) {
        this.agctot = agctot;
    }

    private int lnamt1;

    @javax.persistence.Column(name = "LNAMT1")
    @Basic
    public int getLnamt1() {
        return lnamt1;
    }

    public void setLnamt1(int lnamt1) {
        this.lnamt1 = lnamt1;
    }

    private String otbldt1;

    @javax.persistence.Column(name = "OTBLDT1")
    @Basic
    public String getOtbldt1() {
        return otbldt1;
    }

    public void setOtbldt1(String otbldt1) {
        this.otbldt1 = otbldt1;
    }

    private int lnamt2;

    @javax.persistence.Column(name = "LNAMT2")
    @Basic
    public int getLnamt2() {
        return lnamt2;
    }

    public void setLnamt2(int lnamt2) {
        this.lnamt2 = lnamt2;
    }

    private String otbldt2;

    @javax.persistence.Column(name = "OTBLDT2")
    @Basic
    public String getOtbldt2() {
        return otbldt2;
    }

    public void setOtbldt2(String otbldt2) {
        this.otbldt2 = otbldt2;
    }

    private int lnamt3;

    @javax.persistence.Column(name = "LNAMT3")
    @Basic
    public int getLnamt3() {
        return lnamt3;
    }

    public void setLnamt3(int lnamt3) {
        this.lnamt3 = lnamt3;
    }

    private String otbldt3;

    @javax.persistence.Column(name = "OTBLDT3")
    @Basic
    public String getOtbldt3() {
        return otbldt3;
    }

    public void setOtbldt3(String otbldt3) {
        this.otbldt3 = otbldt3;
    }

    private int lnamt4;

    @javax.persistence.Column(name = "LNAMT4")
    @Basic
    public int getLnamt4() {
        return lnamt4;
    }

    public void setLnamt4(int lnamt4) {
        this.lnamt4 = lnamt4;
    }

    private String otbldt4;

    @javax.persistence.Column(name = "OTBLDT4")
    @Basic
    public String getOtbldt4() {
        return otbldt4;
    }

    public void setOtbldt4(String otbldt4) {
        this.otbldt4 = otbldt4;
    }

    private int lnamt5;

    @javax.persistence.Column(name = "LNAMT5")
    @Basic
    public int getLnamt5() {
        return lnamt5;
    }

    public void setLnamt5(int lnamt5) {
        this.lnamt5 = lnamt5;
    }

    private String otbldt5;

    @javax.persistence.Column(name = "OTBLDT5")
    @Basic
    public String getOtbldt5() {
        return otbldt5;
    }

    public void setOtbldt5(String otbldt5) {
        this.otbldt5 = otbldt5;
    }

    private int lnamt6;

    @javax.persistence.Column(name = "LNAMT6")
    @Basic
    public int getLnamt6() {
        return lnamt6;
    }

    public void setLnamt6(int lnamt6) {
        this.lnamt6 = lnamt6;
    }

    private String otbldt6;

    @javax.persistence.Column(name = "OTBLDT6")
    @Basic
    public String getOtbldt6() {
        return otbldt6;
    }

    public void setOtbldt6(String otbldt6) {
        this.otbldt6 = otbldt6;
    }

    private String fintcd1;

    @javax.persistence.Column(name = "FINTCD1")
    @Basic
    public String getFintcd1() {
        return fintcd1;
    }

    public void setFintcd1(String fintcd1) {
        this.fintcd1 = fintcd1;
    }

    private String fregcd1;

    @javax.persistence.Column(name = "FREGCD1")
    @Basic
    public String getFregcd1() {
        return fregcd1;
    }

    public void setFregcd1(String fregcd1) {
        this.fregcd1 = fregcd1;
    }

    private String fintcd2;

    @javax.persistence.Column(name = "FINTCD2")
    @Basic
    public String getFintcd2() {
        return fintcd2;
    }

    public void setFintcd2(String fintcd2) {
        this.fintcd2 = fintcd2;
    }

    private String fregcd2;

    @javax.persistence.Column(name = "FREGCD2")
    @Basic
    public String getFregcd2() {
        return fregcd2;
    }

    public void setFregcd2(String fregcd2) {
        this.fregcd2 = fregcd2;
    }

    private String fintcd3;

    @javax.persistence.Column(name = "FINTCD3")
    @Basic
    public String getFintcd3() {
        return fintcd3;
    }

    public void setFintcd3(String fintcd3) {
        this.fintcd3 = fintcd3;
    }

    private String fregcd3;

    @javax.persistence.Column(name = "FREGCD3")
    @Basic
    public String getFregcd3() {
        return fregcd3;
    }

    public void setFregcd3(String fregcd3) {
        this.fregcd3 = fregcd3;
    }

    private String fadlnf4;

    @javax.persistence.Column(name = "FADLNF4")
    @Basic
    public String getFadlnf4() {
        return fadlnf4;
    }

    public void setFadlnf4(String fadlnf4) {
        this.fadlnf4 = fadlnf4;
    }

    private String fpgmcd4;

    @javax.persistence.Column(name = "FPGMCD4")
    @Basic
    public String getFpgmcd4() {
        return fpgmcd4;
    }

    public void setFpgmcd4(String fpgmcd4) {
        this.fpgmcd4 = fpgmcd4;
    }

    private String fstcd4;

    @javax.persistence.Column(name = "FSTCD4")
    @Basic
    public String getFstcd4() {
        return fstcd4;
    }

    public void setFstcd4(String fstcd4) {
        this.fstcd4 = fstcd4;
    }

    private String fstdt4;

    @javax.persistence.Column(name = "FSTDT4")
    @Basic
    public String getFstdt4() {
        return fstdt4;
    }

    public void setFstdt4(String fstdt4) {
        this.fstdt4 = fstdt4;
    }

    private int flnamt4;

    @javax.persistence.Column(name = "FLNAMT4")
    @Basic
    public int getFlnamt4() {
        return flnamt4;
    }

    public void setFlnamt4(int flnamt4) {
        this.flnamt4 = flnamt4;
    }

    private int fotbal4;

    @javax.persistence.Column(name = "FOTBAL4")
    @Basic
    public int getFotbal4() {
        return fotbal4;
    }

    public void setFotbal4(int fotbal4) {
        this.fotbal4 = fotbal4;
    }

    private String foutdt4;

    @javax.persistence.Column(name = "FOUTDT4")
    @Basic
    public String getFoutdt4() {
        return foutdt4;
    }

    public void setFoutdt4(String foutdt4) {
        this.foutdt4 = foutdt4;
    }

    private String fbegdt4;

    @javax.persistence.Column(name = "FBEGDT4")
    @Basic
    public String getFbegdt4() {
        return fbegdt4;
    }

    public void setFbegdt4(String fbegdt4) {
        this.fbegdt4 = fbegdt4;
    }

    private String fenddt4;

    @javax.persistence.Column(name = "FENDDT4")
    @Basic
    public String getFenddt4() {
        return fenddt4;
    }

    public void setFenddt4(String fenddt4) {
        this.fenddt4 = fenddt4;
    }

    private String fgacde4;

    @javax.persistence.Column(name = "FGACDE4")
    @Basic
    public String getFgacde4() {
        return fgacde4;
    }

    public void setFgacde4(String fgacde4) {
        this.fgacde4 = fgacde4;
    }

    private String fintcd4;

    @javax.persistence.Column(name = "FINTCD4")
    @Basic
    public String getFintcd4() {
        return fintcd4;
    }

    public void setFintcd4(String fintcd4) {
        this.fintcd4 = fintcd4;
    }

    private String fsercd4;

    @javax.persistence.Column(name = "FSERCD4")
    @Basic
    public String getFsercd4() {
        return fsercd4;
    }

    public void setFsercd4(String fsercd4) {
        this.fsercd4 = fsercd4;
    }

    private String fregcd4;

    @javax.persistence.Column(name = "FREGCD4")
    @Basic
    public String getFregcd4() {
        return fregcd4;
    }

    public void setFregcd4(String fregcd4) {
        this.fregcd4 = fregcd4;
    }

    private String fadlnf5;

    @javax.persistence.Column(name = "FADLNF5")
    @Basic
    public String getFadlnf5() {
        return fadlnf5;
    }

    public void setFadlnf5(String fadlnf5) {
        this.fadlnf5 = fadlnf5;
    }

    private String fpgmcd5;

    @javax.persistence.Column(name = "FPGMCD5")
    @Basic
    public String getFpgmcd5() {
        return fpgmcd5;
    }

    public void setFpgmcd5(String fpgmcd5) {
        this.fpgmcd5 = fpgmcd5;
    }

    private String fstcd5;

    @javax.persistence.Column(name = "FSTCD5")
    @Basic
    public String getFstcd5() {
        return fstcd5;
    }

    public void setFstcd5(String fstcd5) {
        this.fstcd5 = fstcd5;
    }

    private String fstdt5;

    @javax.persistence.Column(name = "FSTDT5")
    @Basic
    public String getFstdt5() {
        return fstdt5;
    }

    public void setFstdt5(String fstdt5) {
        this.fstdt5 = fstdt5;
    }

    private int flnamt5;

    @javax.persistence.Column(name = "FLNAMT5")
    @Basic
    public int getFlnamt5() {
        return flnamt5;
    }

    public void setFlnamt5(int flnamt5) {
        this.flnamt5 = flnamt5;
    }

    private int fotbal5;

    @javax.persistence.Column(name = "FOTBAL5")
    @Basic
    public int getFotbal5() {
        return fotbal5;
    }

    public void setFotbal5(int fotbal5) {
        this.fotbal5 = fotbal5;
    }

    private String foutdt5;

    @javax.persistence.Column(name = "FOUTDT5")
    @Basic
    public String getFoutdt5() {
        return foutdt5;
    }

    public void setFoutdt5(String foutdt5) {
        this.foutdt5 = foutdt5;
    }

    private String fbegdt5;

    @javax.persistence.Column(name = "FBEGDT5")
    @Basic
    public String getFbegdt5() {
        return fbegdt5;
    }

    public void setFbegdt5(String fbegdt5) {
        this.fbegdt5 = fbegdt5;
    }

    private String fenddt5;

    @javax.persistence.Column(name = "FENDDT5")
    @Basic
    public String getFenddt5() {
        return fenddt5;
    }

    public void setFenddt5(String fenddt5) {
        this.fenddt5 = fenddt5;
    }

    private String fgacde5;

    @javax.persistence.Column(name = "FGACDE5")
    @Basic
    public String getFgacde5() {
        return fgacde5;
    }

    public void setFgacde5(String fgacde5) {
        this.fgacde5 = fgacde5;
    }

    private String fintcd5;

    @javax.persistence.Column(name = "FINTCD5")
    @Basic
    public String getFintcd5() {
        return fintcd5;
    }

    public void setFintcd5(String fintcd5) {
        this.fintcd5 = fintcd5;
    }

    private String fsercd5;

    @javax.persistence.Column(name = "FSERCD5")
    @Basic
    public String getFsercd5() {
        return fsercd5;
    }

    public void setFsercd5(String fsercd5) {
        this.fsercd5 = fsercd5;
    }

    private String fregcd5;

    @javax.persistence.Column(name = "FREGCD5")
    @Basic
    public String getFregcd5() {
        return fregcd5;
    }

    public void setFregcd5(String fregcd5) {
        this.fregcd5 = fregcd5;
    }

    private String fadlnf6;

    @javax.persistence.Column(name = "FADLNF6")
    @Basic
    public String getFadlnf6() {
        return fadlnf6;
    }

    public void setFadlnf6(String fadlnf6) {
        this.fadlnf6 = fadlnf6;
    }

    private String fpgmcd6;

    @javax.persistence.Column(name = "FPGMCD6")
    @Basic
    public String getFpgmcd6() {
        return fpgmcd6;
    }

    public void setFpgmcd6(String fpgmcd6) {
        this.fpgmcd6 = fpgmcd6;
    }

    private String fstcd6;

    @javax.persistence.Column(name = "FSTCD6")
    @Basic
    public String getFstcd6() {
        return fstcd6;
    }

    public void setFstcd6(String fstcd6) {
        this.fstcd6 = fstcd6;
    }

    private String fstdt6;

    @javax.persistence.Column(name = "FSTDT6")
    @Basic
    public String getFstdt6() {
        return fstdt6;
    }

    public void setFstdt6(String fstdt6) {
        this.fstdt6 = fstdt6;
    }

    private int flnamt6;

    @javax.persistence.Column(name = "FLNAMT6")
    @Basic
    public int getFlnamt6() {
        return flnamt6;
    }

    public void setFlnamt6(int flnamt6) {
        this.flnamt6 = flnamt6;
    }

    private int fotbal6;

    @javax.persistence.Column(name = "FOTBAL6")
    @Basic
    public int getFotbal6() {
        return fotbal6;
    }

    public void setFotbal6(int fotbal6) {
        this.fotbal6 = fotbal6;
    }

    private String foutdt6;

    @javax.persistence.Column(name = "FOUTDT6")
    @Basic
    public String getFoutdt6() {
        return foutdt6;
    }

    public void setFoutdt6(String foutdt6) {
        this.foutdt6 = foutdt6;
    }

    private String fbegdt6;

    @javax.persistence.Column(name = "FBEGDT6")
    @Basic
    public String getFbegdt6() {
        return fbegdt6;
    }

    public void setFbegdt6(String fbegdt6) {
        this.fbegdt6 = fbegdt6;
    }

    private String fenddt6;

    @javax.persistence.Column(name = "FENDDT6")
    @Basic
    public String getFenddt6() {
        return fenddt6;
    }

    public void setFenddt6(String fenddt6) {
        this.fenddt6 = fenddt6;
    }

    private String fgacde6;

    @javax.persistence.Column(name = "FGACDE6")
    @Basic
    public String getFgacde6() {
        return fgacde6;
    }

    public void setFgacde6(String fgacde6) {
        this.fgacde6 = fgacde6;
    }

    private String fintcd6;

    @javax.persistence.Column(name = "FINTCD6")
    @Basic
    public String getFintcd6() {
        return fintcd6;
    }

    public void setFintcd6(String fintcd6) {
        this.fintcd6 = fintcd6;
    }

    private String fsercd6;

    @javax.persistence.Column(name = "FSERCD6")
    @Basic
    public String getFsercd6() {
        return fsercd6;
    }

    public void setFsercd6(String fsercd6) {
        this.fsercd6 = fsercd6;
    }

    private String fregcd6;

    @javax.persistence.Column(name = "FREGCD6")
    @Basic
    public String getFregcd6() {
        return fregcd6;
    }

    public void setFregcd6(String fregcd6) {
        this.fregcd6 = fregcd6;
    }

    private String seqnum1;

    @javax.persistence.Column(name = "SEQNUM1")
    @Basic
    public String getSeqnum1() {
        return seqnum1;
    }

    public void setSeqnum1(String seqnum1) {
        this.seqnum1 = seqnum1;
    }

    private String seqnum2;

    @javax.persistence.Column(name = "SEQNUM2")
    @Basic
    public String getSeqnum2() {
        return seqnum2;
    }

    public void setSeqnum2(String seqnum2) {
        this.seqnum2 = seqnum2;
    }

    private String seqnum3;

    @javax.persistence.Column(name = "SEQNUM3")
    @Basic
    public String getSeqnum3() {
        return seqnum3;
    }

    public void setSeqnum3(String seqnum3) {
        this.seqnum3 = seqnum3;
    }

    private String seqnum4;

    @javax.persistence.Column(name = "SEQNUM4")
    @Basic
    public String getSeqnum4() {
        return seqnum4;
    }

    public void setSeqnum4(String seqnum4) {
        this.seqnum4 = seqnum4;
    }

    private String seqnum5;

    @javax.persistence.Column(name = "SEQNUM5")
    @Basic
    public String getSeqnum5() {
        return seqnum5;
    }

    public void setSeqnum5(String seqnum5) {
        this.seqnum5 = seqnum5;
    }

    private String seqnum6;

    @javax.persistence.Column(name = "SEQNUM6")
    @Basic
    public String getSeqnum6() {
        return seqnum6;
    }

    public void setSeqnum6(String seqnum6) {
        this.seqnum6 = seqnum6;
    }

    private String seqnum7;

    @javax.persistence.Column(name = "SEQNUM7")
    @Basic
    public String getSeqnum7() {
        return seqnum7;
    }

    public void setSeqnum7(String seqnum7) {
        this.seqnum7 = seqnum7;
    }

    private String seqnum8;

    @javax.persistence.Column(name = "SEQNUM8")
    @Basic
    public String getSeqnum8() {
        return seqnum8;
    }

    public void setSeqnum8(String seqnum8) {
        this.seqnum8 = seqnum8;
    }

    private String seqnum9;

    @javax.persistence.Column(name = "SEQNUM9")
    @Basic
    public String getSeqnum9() {
        return seqnum9;
    }

    public void setSeqnum9(String seqnum9) {
        this.seqnum9 = seqnum9;
    }

    private String seqnum10;

    @javax.persistence.Column(name = "SEQNUM10")
    @Basic
    public String getSeqnum10() {
        return seqnum10;
    }

    public void setSeqnum10(String seqnum10) {
        this.seqnum10 = seqnum10;
    }

    private String seqnum11;

    @javax.persistence.Column(name = "SEQNUM11")
    @Basic
    public String getSeqnum11() {
        return seqnum11;
    }

    public void setSeqnum11(String seqnum11) {
        this.seqnum11 = seqnum11;
    }

    private String seqnum12;

    @javax.persistence.Column(name = "SEQNUM12")
    @Basic
    public String getSeqnum12() {
        return seqnum12;
    }

    public void setSeqnum12(String seqnum12) {
        this.seqnum12 = seqnum12;
    }

    private String contyp1;

    @javax.persistence.Column(name = "CONTYP1")
    @Basic
    public String getContyp1() {
        return contyp1;
    }

    public void setContyp1(String contyp1) {
        this.contyp1 = contyp1;
    }

    private String contyp2;

    @javax.persistence.Column(name = "CONTYP2")
    @Basic
    public String getContyp2() {
        return contyp2;
    }

    public void setContyp2(String contyp2) {
        this.contyp2 = contyp2;
    }

    private String contyp3;

    @javax.persistence.Column(name = "CONTYP3")
    @Basic
    public String getContyp3() {
        return contyp3;
    }

    public void setContyp3(String contyp3) {
        this.contyp3 = contyp3;
    }

    private String contyp4;

    @javax.persistence.Column(name = "CONTYP4")
    @Basic
    public String getContyp4() {
        return contyp4;
    }

    public void setContyp4(String contyp4) {
        this.contyp4 = contyp4;
    }

    private String contyp5;

    @javax.persistence.Column(name = "CONTYP5")
    @Basic
    public String getContyp5() {
        return contyp5;
    }

    public void setContyp5(String contyp5) {
        this.contyp5 = contyp5;
    }

    private String contyp6;

    @javax.persistence.Column(name = "CONTYP6")
    @Basic
    public String getContyp6() {
        return contyp6;
    }

    public void setContyp6(String contyp6) {
        this.contyp6 = contyp6;
    }

    private String contyp7;

    @javax.persistence.Column(name = "CONTYP7")
    @Basic
    public String getContyp7() {
        return contyp7;
    }

    public void setContyp7(String contyp7) {
        this.contyp7 = contyp7;
    }

    private String contyp8;

    @javax.persistence.Column(name = "CONTYP8")
    @Basic
    public String getContyp8() {
        return contyp8;
    }

    public void setContyp8(String contyp8) {
        this.contyp8 = contyp8;
    }

    private String contyp9;

    @javax.persistence.Column(name = "CONTYP9")
    @Basic
    public String getContyp9() {
        return contyp9;
    }

    public void setContyp9(String contyp9) {
        this.contyp9 = contyp9;
    }

    private String contyp10;

    @javax.persistence.Column(name = "CONTYP10")
    @Basic
    public String getContyp10() {
        return contyp10;
    }

    public void setContyp10(String contyp10) {
        this.contyp10 = contyp10;
    }

    private String contyp11;

    @javax.persistence.Column(name = "CONTYP11")
    @Basic
    public String getContyp11() {
        return contyp11;
    }

    public void setContyp11(String contyp11) {
        this.contyp11 = contyp11;
    }

    private String contyp12;

    @javax.persistence.Column(name = "CONTYP12")
    @Basic
    public String getContyp12() {
        return contyp12;
    }

    public void setContyp12(String contyp12) {
        this.contyp12 = contyp12;
    }

    private String createc;

    @javax.persistence.Column(name = "CREATEC")
    @Basic
    public String getCreatec() {
        return createc;
    }

    public void setCreatec(String createc) {
        this.createc = createc;
    }

    private String revdtc;

    @javax.persistence.Column(name = "REVDTC")
    @Basic
    public String getRevdtc() {
        return revdtc;
    }

    public void setRevdtc(String revdtc) {
        this.revdtc = revdtc;
    }

    private int p2Onti;

    @javax.persistence.Column(name = "P2ONTI")
    @Basic
    public int getP2Onti() {
        return p2Onti;
    }

    public void setP2Onti(int p2Onti) {
        this.p2Onti = p2Onti;
    }

    private int p2Onti2;

    @javax.persistence.Column(name = "P2ONTI2")
    @Basic
    public int getP2Onti2() {
        return p2Onti2;
    }

    public void setP2Onti2(int p2Onti2) {
        this.p2Onti2 = p2Onti2;
    }

    private int p2Ontic;

    @javax.persistence.Column(name = "P2ONTIC")
    @Basic
    public int getP2Ontic() {
        return p2Ontic;
    }

    public void setP2Ontic(int p2Ontic) {
        this.p2Ontic = p2Ontic;
    }

    private String p2Ontis;

    @javax.persistence.Column(name = "P2ONTIS")
    @Basic
    public String getP2Ontis() {
        return p2Ontis;
    }

    public void setP2Ontis(String p2Ontis) {
        this.p2Ontis = p2Ontis;
    }

    private String p2Ontics;

    @javax.persistence.Column(name = "P2ONTICS")
    @Basic
    public String getP2Ontics() {
        return p2Ontics;
    }

    public void setP2Ontics(String p2Ontics) {
        this.p2Ontics = p2Ontics;
    }

    private String nsldldt;

    @javax.persistence.Column(name = "NSLDLDT")
    @Basic
    public String getNsldldt() {
        return nsldldt;
    }

    public void setNsldldt(String nsldldt) {
        this.nsldldt = nsldldt;
    }

    private String pmrtldc;

    @javax.persistence.Column(name = "PMRTLDC")
    @Basic
    public String getPmrtldc() {
        return pmrtldc;
    }

    public void setPmrtldc(String pmrtldc) {
        this.pmrtldc = pmrtldc;
    }

    private String pmrtldc2;

    @javax.persistence.Column(name = "PMRTLDC2")
    @Basic
    public String getPmrtldc2() {
        return pmrtldc2;
    }

    public void setPmrtldc2(String pmrtldc2) {
        this.pmrtldc2 = pmrtldc2;
    }

    private String pmrtlds;

    @javax.persistence.Column(name = "PMRTLDS")
    @Basic
    public String getPmrtlds() {
        return pmrtlds;
    }

    public void setPmrtlds(String pmrtlds) {
        this.pmrtlds = pmrtlds;
    }

    private String nameff;

    @javax.persistence.Column(name = "NAMEFF")
    @Basic
    public String getNameff() {
        return nameff;
    }

    public void setNameff(String nameff) {
        this.nameff = nameff;
    }

    private String namemf;

    @javax.persistence.Column(name = "NAMEMF")
    @Basic
    public String getNamemf() {
        return namemf;
    }

    public void setNamemf(String namemf) {
        this.namemf = namemf;
    }

    private String emadtp;

    @javax.persistence.Column(name = "EMADTP")
    @Basic
    public String getEmadtp() {
        return emadtp;
    }

    public void setEmadtp(String emadtp) {
        this.emadtp = emadtp;
    }

    private String fatdob;

    @javax.persistence.Column(name = "FATDOB")
    @Basic
    public String getFatdob() {
        return fatdob;
    }

    public void setFatdob(String fatdob) {
        this.fatdob = fatdob;
    }

    private String motdob;

    @javax.persistence.Column(name = "MOTDOB")
    @Basic
    public String getMotdob() {
        return motdob;
    }

    public void setMotdob(String motdob) {
        this.motdob = motdob;
    }

    private String nameff2;

    @javax.persistence.Column(name = "NAMEFF2")
    @Basic
    public String getNameff2() {
        return nameff2;
    }

    public void setNameff2(String nameff2) {
        this.nameff2 = nameff2;
    }

    private String namemf2;

    @javax.persistence.Column(name = "NAMEMF2")
    @Basic
    public String getNamemf2() {
        return namemf2;
    }

    public void setNamemf2(String namemf2) {
        this.namemf2 = namemf2;
    }

    private String emadtp2;

    @javax.persistence.Column(name = "EMADTP2")
    @Basic
    public String getEmadtp2() {
        return emadtp2;
    }

    public void setEmadtp2(String emadtp2) {
        this.emadtp2 = emadtp2;
    }

    private String fatdob2;

    @javax.persistence.Column(name = "FATDOB2")
    @Basic
    public String getFatdob2() {
        return fatdob2;
    }

    public void setFatdob2(String fatdob2) {
        this.fatdob2 = fatdob2;
    }

    private String motdob2;

    @javax.persistence.Column(name = "MOTDOB2")
    @Basic
    public String getMotdob2() {
        return motdob2;
    }

    public void setMotdob2(String motdob2) {
        this.motdob2 = motdob2;
    }

    private String nameffs;

    @javax.persistence.Column(name = "NAMEFFS")
    @Basic
    public String getNameffs() {
        return nameffs;
    }

    public void setNameffs(String nameffs) {
        this.nameffs = nameffs;
    }

    private String namemfs;

    @javax.persistence.Column(name = "NAMEMFS")
    @Basic
    public String getNamemfs() {
        return namemfs;
    }

    public void setNamemfs(String namemfs) {
        this.namemfs = namemfs;
    }

    private String emadtps;

    @javax.persistence.Column(name = "EMADTPS")
    @Basic
    public String getEmadtps() {
        return emadtps;
    }

    public void setEmadtps(String emadtps) {
        this.emadtps = emadtps;
    }

    private String fatdobs;

    @javax.persistence.Column(name = "FATDOBS")
    @Basic
    public String getFatdobs() {
        return fatdobs;
    }

    public void setFatdobs(String fatdobs) {
        this.fatdobs = fatdobs;
    }

    private String motdobs;

    @javax.persistence.Column(name = "MOTDOBS")
    @Basic
    public String getMotdobs() {
        return motdobs;
    }

    public void setMotdobs(String motdobs) {
        this.motdobs = motdobs;
    }

    private String fssnmf;

    @javax.persistence.Column(name = "FSSNMF")
    @Basic
    public String getFssnmf() {
        return fssnmf;
    }

    public void setFssnmf(String fssnmf) {
        this.fssnmf = fssnmf;
    }

    private String mssnmf;

    @javax.persistence.Column(name = "MSSNMF")
    @Basic
    public String getMssnmf() {
        return mssnmf;
    }

    public void setMssnmf(String mssnmf) {
        this.mssnmf = mssnmf;
    }

    private String pssib;

    @javax.persistence.Column(name = "PSSIB")
    @Basic
    public String getPssib() {
        return pssib;
    }

    public void setPssib(String pssib) {
        this.pssib = pssib;
    }

    private String pfsb;

    @javax.persistence.Column(name = "PFSB")
    @Basic
    public String getPfsb() {
        return pfsb;
    }

    public void setPfsb(String pfsb) {
        this.pfsb = pfsb;
    }

    private String pflb;

    @javax.persistence.Column(name = "PFLB")
    @Basic
    public String getPflb() {
        return pflb;
    }

    public void setPflb(String pflb) {
        this.pflb = pflb;
    }

    private String ptanf;

    @javax.persistence.Column(name = "PTANF")
    @Basic
    public String getPtanf() {
        return ptanf;
    }

    public void setPtanf(String ptanf) {
        this.ptanf = ptanf;
    }

    private String pwic;

    @javax.persistence.Column(name = "PWIC")
    @Basic
    public String getPwic() {
        return pwic;
    }

    public void setPwic(String pwic) {
        this.pwic = pwic;
    }

    private String pssib2;

    @javax.persistence.Column(name = "PSSIB2")
    @Basic
    public String getPssib2() {
        return pssib2;
    }

    public void setPssib2(String pssib2) {
        this.pssib2 = pssib2;
    }

    private String pfsb2;

    @javax.persistence.Column(name = "PFSB2")
    @Basic
    public String getPfsb2() {
        return pfsb2;
    }

    public void setPfsb2(String pfsb2) {
        this.pfsb2 = pfsb2;
    }

    private String pflb2;

    @javax.persistence.Column(name = "PFLB2")
    @Basic
    public String getPflb2() {
        return pflb2;
    }

    public void setPflb2(String pflb2) {
        this.pflb2 = pflb2;
    }

    private String ptanf2;

    @javax.persistence.Column(name = "PTANF2")
    @Basic
    public String getPtanf2() {
        return ptanf2;
    }

    public void setPtanf2(String ptanf2) {
        this.ptanf2 = ptanf2;
    }

    private String pwic2;

    @javax.persistence.Column(name = "PWIC2")
    @Basic
    public String getPwic2() {
        return pwic2;
    }

    public void setPwic2(String pwic2) {
        this.pwic2 = pwic2;
    }

    private String frlnchg;

    @javax.persistence.Column(name = "FRLNCHG")
    @Basic
    public String getFrlnchg() {
        return frlnchg;
    }

    public void setFrlnchg(String frlnchg) {
        this.frlnchg = frlnchg;
    }

    private int pcstpd;

    @javax.persistence.Column(name = "PCSTPD")
    @Basic
    public int getPcstpd() {
        return pcstpd;
    }

    public void setPcstpd(int pcstpd) {
        this.pcstpd = pcstpd;
    }

    private int pcomby;

    @javax.persistence.Column(name = "PCOMBY")
    @Basic
    public int getPcomby() {
        return pcomby;
    }

    public void setPcomby(int pcomby) {
        this.pcomby = pcomby;
    }

    private int pcstpd2;

    @javax.persistence.Column(name = "PCSTPD2")
    @Basic
    public int getPcstpd2() {
        return pcstpd2;
    }

    public void setPcstpd2(int pcstpd2) {
        this.pcstpd2 = pcstpd2;
    }

    private int pcomby2;

    @javax.persistence.Column(name = "PCOMBY2")
    @Basic
    public int getPcomby2() {
        return pcomby2;
    }

    public void setPcomby2(int pcomby2) {
        this.pcomby2 = pcomby2;
    }

    private String pcombys;

    @javax.persistence.Column(name = "PCOMBYS")
    @Basic
    public String getPcombys() {
        return pcombys;
    }

    public void setPcombys(String pcombys) {
        this.pcombys = pcombys;
    }

    private String pcstpds;

    @javax.persistence.Column(name = "PCSTPDS")
    @Basic
    public String getPcstpds() {
        return pcstpds;
    }

    public void setPcstpds(String pcstpds) {
        this.pcstpds = pcstpds;
    }

    private int l41Lev;

    @javax.persistence.Column(name = "L41LEV")
    @Basic
    public int getL41Lev() {
        return l41Lev;
    }

    public void setL41Lev(int l41Lev) {
        this.l41Lev = l41Lev;
    }

    private int pedcrd;

    @javax.persistence.Column(name = "PEDCRD")
    @Basic
    public int getPedcrd() {
        return pedcrd;
    }

    public void setPedcrd(int pedcrd) {
        this.pedcrd = pedcrd;
    }

    private int pnbemp;

    @javax.persistence.Column(name = "PNBEMP")
    @Basic
    public int getPnbemp() {
        return pnbemp;
    }

    public void setPnbemp(int pnbemp) {
        this.pnbemp = pnbemp;
    }

    private int pgtsad;

    @javax.persistence.Column(name = "PGTSAD")
    @Basic
    public int getPgtsad() {
        return pgtsad;
    }

    public void setPgtsad(int pgtsad) {
        this.pgtsad = pgtsad;
    }

    private int ppenpy;

    @javax.persistence.Column(name = "PPENPY")
    @Basic
    public int getPpenpy() {
        return ppenpy;
    }

    public void setPpenpy(int ppenpy) {
        this.ppenpy = ppenpy;
    }

    private int pirapy;

    @javax.persistence.Column(name = "PIRAPY")
    @Basic
    public int getPirapy() {
        return pirapy;
    }

    public void setPirapy(int pirapy) {
        this.pirapy = pirapy;
    }

    private int pirads;

    @javax.persistence.Column(name = "PIRADS")
    @Basic
    public int getPirads() {
        return pirads;
    }

    public void setPirads(int pirads) {
        this.pirads = pirads;
    }

    private int putxpn;

    @javax.persistence.Column(name = "PUTXPN")
    @Basic
    public int getPutxpn() {
        return putxpn;
    }

    public void setPutxpn(int putxpn) {
        this.putxpn = putxpn;
    }

    private int pmcall;

    @javax.persistence.Column(name = "PMCALL")
    @Basic
    public int getPmcall() {
        return pmcall;
    }

    public void setPmcall(int pmcall) {
        this.pmcall = pmcall;
    }

    private int pvnebn;

    @javax.persistence.Column(name = "PVNEBN")
    @Basic
    public int getPvnebn() {
        return pvnebn;
    }

    public void setPvnebn(int pvnebn) {
        this.pvnebn = pvnebn;
    }

    private int pedcrd2;

    @javax.persistence.Column(name = "PEDCRD2")
    @Basic
    public int getPedcrd2() {
        return pedcrd2;
    }

    public void setPedcrd2(int pedcrd2) {
        this.pedcrd2 = pedcrd2;
    }

    private int pnbemp2;

    @javax.persistence.Column(name = "PNBEMP2")
    @Basic
    public int getPnbemp2() {
        return pnbemp2;
    }

    public void setPnbemp2(int pnbemp2) {
        this.pnbemp2 = pnbemp2;
    }

    private int pgtsad2;

    @javax.persistence.Column(name = "PGTSAD2")
    @Basic
    public int getPgtsad2() {
        return pgtsad2;
    }

    public void setPgtsad2(int pgtsad2) {
        this.pgtsad2 = pgtsad2;
    }

    private int ppenpy2;

    @javax.persistence.Column(name = "PPENPY2")
    @Basic
    public int getPpenpy2() {
        return ppenpy2;
    }

    public void setPpenpy2(int ppenpy2) {
        this.ppenpy2 = ppenpy2;
    }

    private int pirapy2;

    @javax.persistence.Column(name = "PIRAPY2")
    @Basic
    public int getPirapy2() {
        return pirapy2;
    }

    public void setPirapy2(int pirapy2) {
        this.pirapy2 = pirapy2;
    }

    private int pirads2;

    @javax.persistence.Column(name = "PIRADS2")
    @Basic
    public int getPirads2() {
        return pirads2;
    }

    public void setPirads2(int pirads2) {
        this.pirads2 = pirads2;
    }

    private int putxpn2;

    @javax.persistence.Column(name = "PUTXPN2")
    @Basic
    public int getPutxpn2() {
        return putxpn2;
    }

    public void setPutxpn2(int putxpn2) {
        this.putxpn2 = putxpn2;
    }

    private int pmcall2;

    @javax.persistence.Column(name = "PMCALL2")
    @Basic
    public int getPmcall2() {
        return pmcall2;
    }

    public void setPmcall2(int pmcall2) {
        this.pmcall2 = pmcall2;
    }

    private int pvnebn2;

    @javax.persistence.Column(name = "PVNEBN2")
    @Basic
    public int getPvnebn2() {
        return pvnebn2;
    }

    public void setPvnebn2(int pvnebn2) {
        this.pvnebn2 = pvnebn2;
    }

    private String pedcrds;

    @javax.persistence.Column(name = "PEDCRDS")
    @Basic
    public String getPedcrds() {
        return pedcrds;
    }

    public void setPedcrds(String pedcrds) {
        this.pedcrds = pedcrds;
    }

    private String pnbemps;

    @javax.persistence.Column(name = "PNBEMPS")
    @Basic
    public String getPnbemps() {
        return pnbemps;
    }

    public void setPnbemps(String pnbemps) {
        this.pnbemps = pnbemps;
    }

    private String pgtsads;

    @javax.persistence.Column(name = "PGTSADS")
    @Basic
    public String getPgtsads() {
        return pgtsads;
    }

    public void setPgtsads(String pgtsads) {
        this.pgtsads = pgtsads;
    }

    private String ppenpys;

    @javax.persistence.Column(name = "PPENPYS")
    @Basic
    public String getPpenpys() {
        return ppenpys;
    }

    public void setPpenpys(String ppenpys) {
        this.ppenpys = ppenpys;
    }

    private String pirapys;

    @javax.persistence.Column(name = "PIRAPYS")
    @Basic
    public String getPirapys() {
        return pirapys;
    }

    public void setPirapys(String pirapys) {
        this.pirapys = pirapys;
    }

    private String piradss;

    @javax.persistence.Column(name = "PIRADSS")
    @Basic
    public String getPiradss() {
        return piradss;
    }

    public void setPiradss(String piradss) {
        this.piradss = piradss;
    }

    private String putxpns;

    @javax.persistence.Column(name = "PUTXPNS")
    @Basic
    public String getPutxpns() {
        return putxpns;
    }

    public void setPutxpns(String putxpns) {
        this.putxpns = putxpns;
    }

    private String pmcalls;

    @javax.persistence.Column(name = "PMCALLS")
    @Basic
    public String getPmcalls() {
        return pmcalls;
    }

    public void setPmcalls(String pmcalls) {
        this.pmcalls = pmcalls;
    }

    private String pvnebns;

    @javax.persistence.Column(name = "PVNEBNS")
    @Basic
    public String getPvnebns() {
        return pvnebns;
    }

    public void setPvnebns(String pvnebns) {
        this.pvnebns = pvnebns;
    }

    private int poutx;

    @javax.persistence.Column(name = "POUTX")
    @Basic
    public int getPoutx() {
        return poutx;
    }

    public void setPoutx(int poutx) {
        this.poutx = poutx;
    }

    private int poutx2;

    @javax.persistence.Column(name = "POUTX2")
    @Basic
    public int getPoutx2() {
        return poutx2;
    }

    public void setPoutx2(int poutx2) {
        this.poutx2 = poutx2;
    }

    private int poutxc;

    @javax.persistence.Column(name = "POUTXC")
    @Basic
    public int getPoutxc() {
        return poutxc;
    }

    public void setPoutxc(int poutxc) {
        this.poutxc = poutxc;
    }

    private String poutxs;

    @javax.persistence.Column(name = "POUTXS")
    @Basic
    public String getPoutxs() {
        return poutxs;
    }

    public void setPoutxs(String poutxs) {
        this.poutxs = poutxs;
    }

    private String poutxcs;

    @javax.persistence.Column(name = "POUTXCS")
    @Basic
    public String getPoutxcs() {
        return poutxcs;
    }

    public void setPoutxcs(String poutxcs) {
        this.poutxcs = poutxcs;
    }

    private String numemp;

    @javax.persistence.Column(name = "NUMEMP")
    @Basic
    public String getNumemp() {
        return numemp;
    }

    public void setNumemp(String numemp) {
        this.numemp = numemp;
    }

    private int pcoop;

    @javax.persistence.Column(name = "PCOOP")
    @Basic
    public int getPcoop() {
        return pcoop;
    }

    public void setPcoop(int pcoop) {
        this.pcoop = pcoop;
    }

    private int pcoop2;

    @javax.persistence.Column(name = "PCOOP2")
    @Basic
    public int getPcoop2() {
        return pcoop2;
    }

    public void setPcoop2(int pcoop2) {
        this.pcoop2 = pcoop2;
    }

    private int pcoopc;

    @javax.persistence.Column(name = "PCOOPC")
    @Basic
    public int getPcoopc() {
        return pcoopc;
    }

    public void setPcoopc(int pcoopc) {
        this.pcoopc = pcoopc;
    }

    private String pcoops;

    @javax.persistence.Column(name = "PCOOPS")
    @Basic
    public String getPcoops() {
        return pcoops;
    }

    public void setPcoops(String pcoops) {
        this.pcoops = pcoops;
    }

    private String pcoopcs;

    @javax.persistence.Column(name = "PCOOPCS")
    @Basic
    public String getPcoopcs() {
        return pcoopcs;
    }

    public void setPcoopcs(String pcoopcs) {
        this.pcoopcs = pcoopcs;
    }

    private String pirsrq;

    @javax.persistence.Column(name = "PIRSRQ")
    @Basic
    public String getPirsrq() {
        return pirsrq;
    }

    public void setPirsrq(String pirsrq) {
        this.pirsrq = pirsrq;
    }

    private int ptsctc;

    @javax.persistence.Column(name = "PTSCTC")
    @Basic
    public int getPtsctc() {
        return ptsctc;
    }

    public void setPtsctc(int ptsctc) {
        this.ptsctc = ptsctc;
    }

    private String pathx;

    @javax.persistence.Column(name = "PATHX")
    @Basic
    public String getPathx() {
        return pathx;
    }

    public void setPathx(String pathx) {
        this.pathx = pathx;
    }

    private String pathx2;

    @javax.persistence.Column(name = "PATHX2")
    @Basic
    public String getPathx2() {
        return pathx2;
    }

    public void setPathx2(String pathx2) {
        this.pathx2 = pathx2;
    }

    private String pathxc;

    @javax.persistence.Column(name = "PATHXC")
    @Basic
    public String getPathxc() {
        return pathxc;
    }

    public void setPathxc(String pathxc) {
        this.pathxc = pathxc;
    }

    private String pathxs;

    @javax.persistence.Column(name = "PATHXS")
    @Basic
    public String getPathxs() {
        return pathxs;
    }

    public void setPathxs(String pathxs) {
        this.pathxs = pathxs;
    }

    private String pathxcs;

    @javax.persistence.Column(name = "PATHXCS")
    @Basic
    public String getPathxcs() {
        return pathxcs;
    }

    public void setPathxcs(String pathxcs) {
        this.pathxcs = pathxcs;
    }

    private String apathex;

    @javax.persistence.Column(name = "APATHEX")
    @Basic
    public String getApathex() {
        return apathex;
    }

    public void setApathex(String apathex) {
        this.apathex = apathex;
    }

    private String pfsbs;

    @javax.persistence.Column(name = "PFSBS")
    @Basic
    public String getPfsbs() {
        return pfsbs;
    }

    public void setPfsbs(String pfsbs) {
        this.pfsbs = pfsbs;
    }

    private String pfsbcs;

    @javax.persistence.Column(name = "PFSBCS")
    @Basic
    public String getPfsbcs() {
        return pfsbcs;
    }

    public void setPfsbcs(String pfsbcs) {
        this.pfsbcs = pfsbcs;
    }

    private int stuptu;

    @javax.persistence.Column(name = "STUPTU")
    @Basic
    public int getStuptu() {
        return stuptu;
    }

    public void setStuptu(int stuptu) {
        this.stuptu = stuptu;
    }

    private int stbptu;

    @javax.persistence.Column(name = "STBPTU")
    @Basic
    public int getStbptu() {
        return stbptu;
    }

    public void setStbptu(int stbptu) {
        this.stbptu = stbptu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snp5Entity that = (Snp5Entity) o;

        if (agcpdis != that.agcpdis) return false;
        if (agctot != that.agctot) return false;
        if (agspdis != that.agspdis) return false;
        if (agstot != that.agstot) return false;
        if (aguspds != that.aguspds) return false;
        if (agustot != that.agustot) return false;
        if (flnamt4 != that.flnamt4) return false;
        if (flnamt5 != that.flnamt5) return false;
        if (flnamt6 != that.flnamt6) return false;
        if (fotbal4 != that.fotbal4) return false;
        if (fotbal5 != that.fotbal5) return false;
        if (fotbal6 != that.fotbal6) return false;
        if (ipsaia != that.ipsaia) return false;
        if (iptfcfw != that.iptfcfw) return false;
        if (l41Lev != that.l41Lev) return false;
        if (lnamt1 != that.lnamt1) return false;
        if (lnamt2 != that.lnamt2) return false;
        if (lnamt3 != that.lnamt3) return false;
        if (lnamt4 != that.lnamt4) return false;
        if (lnamt5 != that.lnamt5) return false;
        if (lnamt6 != that.lnamt6) return false;
        if (napditx != that.napditx) return false;
        if (napitx != that.napitx) return false;
        if (p2Onti != that.p2Onti) return false;
        if (p2Onti2 != that.p2Onti2) return false;
        if (p2Ontic != that.p2Ontic) return false;
        if (pasumss != that.pasumss) return false;
        if (pcomby != that.pcomby) return false;
        if (pcomby2 != that.pcomby2) return false;
        if (pcoop != that.pcoop) return false;
        if (pcoop2 != that.pcoop2) return false;
        if (pcoopc != that.pcoopc) return false;
        if (pcstpd != that.pcstpd) return false;
        if (pcstpd2 != that.pcstpd2) return false;
        if (pedcrd != that.pedcrd) return false;
        if (pedcrd2 != that.pedcrd2) return false;
        if (pgtsad != that.pgtsad) return false;
        if (pgtsad2 != that.pgtsad2) return false;
        if (pirads != that.pirads) return false;
        if (pirads2 != that.pirads2) return false;
        if (pirapy != that.pirapy) return false;
        if (pirapy2 != that.pirapy2) return false;
        if (pmcall != that.pmcall) return false;
        if (pmcall2 != that.pmcall2) return false;
        if (pnbemp != that.pnbemp) return false;
        if (pnbemp2 != that.pnbemp2) return false;
        if (poutx != that.poutx) return false;
        if (poutx2 != that.poutx2) return false;
        if (poutxc != that.poutxc) return false;
        if (ppenpy != that.ppenpy) return false;
        if (ppenpy2 != that.ppenpy2) return false;
        if (psai != that.psai) return false;
        if (ptfcf != that.ptfcf) return false;
        if (ptsctc != that.ptsctc) return false;
        if (putxpn != that.putxpn) return false;
        if (putxpn2 != that.putxpn2) return false;
        if (pvnebn != that.pvnebn) return false;
        if (pvnebn2 != that.pvnebn2) return false;
        if (stbptu != that.stbptu) return false;
        if (stuptu != that.stuptu) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (apathex != null ? !apathex.equals(that.apathex) : that.apathex != null) return false;
        if (appsscd != null ? !appsscd.equals(that.appsscd) : that.appsscd != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (contyp1 != null ? !contyp1.equals(that.contyp1) : that.contyp1 != null) return false;
        if (contyp10 != null ? !contyp10.equals(that.contyp10) : that.contyp10 != null) return false;
        if (contyp11 != null ? !contyp11.equals(that.contyp11) : that.contyp11 != null) return false;
        if (contyp12 != null ? !contyp12.equals(that.contyp12) : that.contyp12 != null) return false;
        if (contyp2 != null ? !contyp2.equals(that.contyp2) : that.contyp2 != null) return false;
        if (contyp3 != null ? !contyp3.equals(that.contyp3) : that.contyp3 != null) return false;
        if (contyp4 != null ? !contyp4.equals(that.contyp4) : that.contyp4 != null) return false;
        if (contyp5 != null ? !contyp5.equals(that.contyp5) : that.contyp5 != null) return false;
        if (contyp6 != null ? !contyp6.equals(that.contyp6) : that.contyp6 != null) return false;
        if (contyp7 != null ? !contyp7.equals(that.contyp7) : that.contyp7 != null) return false;
        if (contyp8 != null ? !contyp8.equals(that.contyp8) : that.contyp8 != null) return false;
        if (contyp9 != null ? !contyp9.equals(that.contyp9) : that.contyp9 != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (depstf != null ? !depstf.equals(that.depstf) : that.depstf != null) return false;
        if (depsti != null ? !depsti.equals(that.depsti) : that.depsti != null) return false;
        if (emadtp != null ? !emadtp.equals(that.emadtp) : that.emadtp != null) return false;
        if (emadtp2 != null ? !emadtp2.equals(that.emadtp2) : that.emadtp2 != null) return false;
        if (emadtps != null ? !emadtps.equals(that.emadtps) : that.emadtps != null) return false;
        if (fadlnf4 != null ? !fadlnf4.equals(that.fadlnf4) : that.fadlnf4 != null) return false;
        if (fadlnf5 != null ? !fadlnf5.equals(that.fadlnf5) : that.fadlnf5 != null) return false;
        if (fadlnf6 != null ? !fadlnf6.equals(that.fadlnf6) : that.fadlnf6 != null) return false;
        if (fatdob != null ? !fatdob.equals(that.fatdob) : that.fatdob != null) return false;
        if (fatdob2 != null ? !fatdob2.equals(that.fatdob2) : that.fatdob2 != null) return false;
        if (fatdobs != null ? !fatdobs.equals(that.fatdobs) : that.fatdobs != null) return false;
        if (fbegdt4 != null ? !fbegdt4.equals(that.fbegdt4) : that.fbegdt4 != null) return false;
        if (fbegdt5 != null ? !fbegdt5.equals(that.fbegdt5) : that.fbegdt5 != null) return false;
        if (fbegdt6 != null ? !fbegdt6.equals(that.fbegdt6) : that.fbegdt6 != null) return false;
        if (fenddt4 != null ? !fenddt4.equals(that.fenddt4) : that.fenddt4 != null) return false;
        if (fenddt5 != null ? !fenddt5.equals(that.fenddt5) : that.fenddt5 != null) return false;
        if (fenddt6 != null ? !fenddt6.equals(that.fenddt6) : that.fenddt6 != null) return false;
        if (fgacde4 != null ? !fgacde4.equals(that.fgacde4) : that.fgacde4 != null) return false;
        if (fgacde5 != null ? !fgacde5.equals(that.fgacde5) : that.fgacde5 != null) return false;
        if (fgacde6 != null ? !fgacde6.equals(that.fgacde6) : that.fgacde6 != null) return false;
        if (fintcd1 != null ? !fintcd1.equals(that.fintcd1) : that.fintcd1 != null) return false;
        if (fintcd2 != null ? !fintcd2.equals(that.fintcd2) : that.fintcd2 != null) return false;
        if (fintcd3 != null ? !fintcd3.equals(that.fintcd3) : that.fintcd3 != null) return false;
        if (fintcd4 != null ? !fintcd4.equals(that.fintcd4) : that.fintcd4 != null) return false;
        if (fintcd5 != null ? !fintcd5.equals(that.fintcd5) : that.fintcd5 != null) return false;
        if (fintcd6 != null ? !fintcd6.equals(that.fintcd6) : that.fintcd6 != null) return false;
        if (foutdt4 != null ? !foutdt4.equals(that.foutdt4) : that.foutdt4 != null) return false;
        if (foutdt5 != null ? !foutdt5.equals(that.foutdt5) : that.foutdt5 != null) return false;
        if (foutdt6 != null ? !foutdt6.equals(that.foutdt6) : that.foutdt6 != null) return false;
        if (fpgmcd4 != null ? !fpgmcd4.equals(that.fpgmcd4) : that.fpgmcd4 != null) return false;
        if (fpgmcd5 != null ? !fpgmcd5.equals(that.fpgmcd5) : that.fpgmcd5 != null) return false;
        if (fpgmcd6 != null ? !fpgmcd6.equals(that.fpgmcd6) : that.fpgmcd6 != null) return false;
        if (fregcd1 != null ? !fregcd1.equals(that.fregcd1) : that.fregcd1 != null) return false;
        if (fregcd2 != null ? !fregcd2.equals(that.fregcd2) : that.fregcd2 != null) return false;
        if (fregcd3 != null ? !fregcd3.equals(that.fregcd3) : that.fregcd3 != null) return false;
        if (fregcd4 != null ? !fregcd4.equals(that.fregcd4) : that.fregcd4 != null) return false;
        if (fregcd5 != null ? !fregcd5.equals(that.fregcd5) : that.fregcd5 != null) return false;
        if (fregcd6 != null ? !fregcd6.equals(that.fregcd6) : that.fregcd6 != null) return false;
        if (frlnchg != null ? !frlnchg.equals(that.frlnchg) : that.frlnchg != null) return false;
        if (fsercd4 != null ? !fsercd4.equals(that.fsercd4) : that.fsercd4 != null) return false;
        if (fsercd5 != null ? !fsercd5.equals(that.fsercd5) : that.fsercd5 != null) return false;
        if (fsercd6 != null ? !fsercd6.equals(that.fsercd6) : that.fsercd6 != null) return false;
        if (fssnmf != null ? !fssnmf.equals(that.fssnmf) : that.fssnmf != null) return false;
        if (fstcd4 != null ? !fstcd4.equals(that.fstcd4) : that.fstcd4 != null) return false;
        if (fstcd5 != null ? !fstcd5.equals(that.fstcd5) : that.fstcd5 != null) return false;
        if (fstcd6 != null ? !fstcd6.equals(that.fstcd6) : that.fstcd6 != null) return false;
        if (fstdt4 != null ? !fstdt4.equals(that.fstdt4) : that.fstdt4 != null) return false;
        if (fstdt5 != null ? !fstdt5.equals(that.fstdt5) : that.fstdt5 != null) return false;
        if (fstdt6 != null ? !fstdt6.equals(that.fstdt6) : that.fstdt6 != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (iptyp != null ? !iptyp.equals(that.iptyp) : that.iptyp != null) return false;
        if (istyp != null ? !istyp.equals(that.istyp) : that.istyp != null) return false;
        if (lonchg1 != null ? !lonchg1.equals(that.lonchg1) : that.lonchg1 != null) return false;
        if (lonchg10 != null ? !lonchg10.equals(that.lonchg10) : that.lonchg10 != null) return false;
        if (lonchg11 != null ? !lonchg11.equals(that.lonchg11) : that.lonchg11 != null) return false;
        if (lonchg12 != null ? !lonchg12.equals(that.lonchg12) : that.lonchg12 != null) return false;
        if (lonchg2 != null ? !lonchg2.equals(that.lonchg2) : that.lonchg2 != null) return false;
        if (lonchg3 != null ? !lonchg3.equals(that.lonchg3) : that.lonchg3 != null) return false;
        if (lonchg4 != null ? !lonchg4.equals(that.lonchg4) : that.lonchg4 != null) return false;
        if (lonchg5 != null ? !lonchg5.equals(that.lonchg5) : that.lonchg5 != null) return false;
        if (lonchg6 != null ? !lonchg6.equals(that.lonchg6) : that.lonchg6 != null) return false;
        if (lonchg7 != null ? !lonchg7.equals(that.lonchg7) : that.lonchg7 != null) return false;
        if (lonchg8 != null ? !lonchg8.equals(that.lonchg8) : that.lonchg8 != null) return false;
        if (lonchg9 != null ? !lonchg9.equals(that.lonchg9) : that.lonchg9 != null) return false;
        if (motdob != null ? !motdob.equals(that.motdob) : that.motdob != null) return false;
        if (motdob2 != null ? !motdob2.equals(that.motdob2) : that.motdob2 != null) return false;
        if (motdobs != null ? !motdobs.equals(that.motdobs) : that.motdobs != null) return false;
        if (mssnmf != null ? !mssnmf.equals(that.mssnmf) : that.mssnmf != null) return false;
        if (nameff != null ? !nameff.equals(that.nameff) : that.nameff != null) return false;
        if (nameff2 != null ? !nameff2.equals(that.nameff2) : that.nameff2 != null) return false;
        if (nameffs != null ? !nameffs.equals(that.nameffs) : that.nameffs != null) return false;
        if (namemf != null ? !namemf.equals(that.namemf) : that.namemf != null) return false;
        if (namemf2 != null ? !namemf2.equals(that.namemf2) : that.namemf2 != null) return false;
        if (namemfs != null ? !namemfs.equals(that.namemfs) : that.namemfs != null) return false;
        if (namflcs != null ? !namflcs.equals(that.namflcs) : that.namflcs != null) return false;
        if (nammlcs != null ? !nammlcs.equals(that.nammlcs) : that.nammlcs != null) return false;
        if (nsldldt != null ? !nsldldt.equals(that.nsldldt) : that.nsldldt != null) return false;
        if (nsldsno != null ? !nsldsno.equals(that.nsldsno) : that.nsldsno != null) return false;
        if (numemp != null ? !numemp.equals(that.numemp) : that.numemp != null) return false;
        if (otbldt1 != null ? !otbldt1.equals(that.otbldt1) : that.otbldt1 != null) return false;
        if (otbldt2 != null ? !otbldt2.equals(that.otbldt2) : that.otbldt2 != null) return false;
        if (otbldt3 != null ? !otbldt3.equals(that.otbldt3) : that.otbldt3 != null) return false;
        if (otbldt4 != null ? !otbldt4.equals(that.otbldt4) : that.otbldt4 != null) return false;
        if (otbldt5 != null ? !otbldt5.equals(that.otbldt5) : that.otbldt5 != null) return false;
        if (otbldt6 != null ? !otbldt6.equals(that.otbldt6) : that.otbldt6 != null) return false;
        if (p2Ontics != null ? !p2Ontics.equals(that.p2Ontics) : that.p2Ontics != null) return false;
        if (p2Ontis != null ? !p2Ontis.equals(that.p2Ontis) : that.p2Ontis != null) return false;
        if (passadl != null ? !passadl.equals(that.passadl) : that.passadl != null) return false;
        if (pathx != null ? !pathx.equals(that.pathx) : that.pathx != null) return false;
        if (pathx2 != null ? !pathx2.equals(that.pathx2) : that.pathx2 != null) return false;
        if (pathxc != null ? !pathxc.equals(that.pathxc) : that.pathxc != null) return false;
        if (pathxcs != null ? !pathxcs.equals(that.pathxcs) : that.pathxcs != null) return false;
        if (pathxs != null ? !pathxs.equals(that.pathxs) : that.pathxs != null) return false;
        if (pbaavlcs != null ? !pbaavlcs.equals(that.pbaavlcs) : that.pbaavlcs != null) return false;
        if (pbabfwcs != null ? !pbabfwcs.equals(that.pbabfwcs) : that.pbabfwcs != null) return false;
        if (pbapacs != null ? !pbapacs.equals(that.pbapacs) : that.pbapacs != null) return false;
        if (pbascrcs != null ? !pbascrcs.equals(that.pbascrcs) : that.pbascrcs != null) return false;
        if (pbconfcs != null ? !pbconfcs.equals(that.pbconfcs) : that.pbconfcs != null) return false;
        if (pbdnetcs != null ? !pbdnetcs.equals(that.pbdnetcs) : that.pbdnetcs != null) return false;
        if (pbefincs != null ? !pbefincs.equals(that.pbefincs) : that.pbefincs != null) return false;
        if (pbemalcs != null ? !pbemalcs.equals(that.pbemalcs) : that.pbemalcs != null) return false;
        if (pbhomecs != null ? !pbhomecs.equals(that.pbhomecs) : that.pbhomecs != null) return false;
        if (pbial1Cs != null ? !pbial1Cs.equals(that.pbial1Cs) : that.pbial1Cs != null) return false;
        if (pbial1L != null ? !pbial1L.equals(that.pbial1L) : that.pbial1L != null) return false;
        if (pbial2Cs != null ? !pbial2Cs.equals(that.pbial2Cs) : that.pbial2Cs != null) return false;
        if (pbial2L != null ? !pbial2L.equals(that.pbial2L) : that.pbial2L != null) return false;
        if (pbincal != null ? !pbincal.equals(that.pbincal) : that.pbincal != null) return false;
        if (pbincscs != null ? !pbincscs.equals(that.pbincscs) : that.pbincscs != null) return false;
        if (pbnwrtcs != null ? !pbnwrtcs.equals(that.pbnwrtcs) : that.pbnwrtcs != null) return false;
        if (pbsmacs != null ? !pbsmacs.equals(that.pbsmacs) : that.pbsmacs != null) return false;
        if (pbtalocs != null ? !pbtalocs.equals(that.pbtalocs) : that.pbtalocs != null) return false;
        if (pbtuitcs != null ? !pbtuitcs.equals(that.pbtuitcs) : that.pbtuitcs != null) return false;
        if (pbtutacs != null ? !pbtutacs.equals(that.pbtutacs) : that.pbtutacs != null) return false;
        if (pcombys != null ? !pcombys.equals(that.pcombys) : that.pcombys != null) return false;
        if (pcoopcs != null ? !pcoopcs.equals(that.pcoopcs) : that.pcoopcs != null) return false;
        if (pcoops != null ? !pcoops.equals(that.pcoops) : that.pcoops != null) return false;
        if (pcstpds != null ? !pcstpds.equals(that.pcstpds) : that.pcstpds != null) return false;
        if (pedcrds != null ? !pedcrds.equals(that.pedcrds) : that.pedcrds != null) return false;
        if (pexcldcs != null ? !pexcldcs.equals(that.pexcldcs) : that.pexcldcs != null) return false;
        if (pflb != null ? !pflb.equals(that.pflb) : that.pflb != null) return false;
        if (pflb2 != null ? !pflb2.equals(that.pflb2) : that.pflb2 != null) return false;
        if (pfsb != null ? !pfsb.equals(that.pfsb) : that.pfsb != null) return false;
        if (pfsb2 != null ? !pfsb2.equals(that.pfsb2) : that.pfsb2 != null) return false;
        if (pfsbcs != null ? !pfsbcs.equals(that.pfsbcs) : that.pfsbcs != null) return false;
        if (pfsbs != null ? !pfsbs.equals(that.pfsbs) : that.pfsbs != null) return false;
        if (pgtsads != null ? !pgtsads.equals(that.pgtsads) : that.pgtsads != null) return false;
        if (phvplucs != null ? !phvplucs.equals(that.phvplucs) : that.phvplucs != null) return false;
        if (pialo1L != null ? !pialo1L.equals(that.pialo1L) : that.pialo1L != null) return false;
        if (pialo2L != null ? !pialo2L.equals(that.pialo2L) : that.pialo2L != null) return false;
        if (pinca1L != null ? !pinca1L.equals(that.pinca1L) : that.pinca1L != null) return false;
        if (pinca2L != null ? !pinca2L.equals(that.pinca2L) : that.pinca2L != null) return false;
        if (pinccrcs != null ? !pinccrcs.equals(that.pinccrcs) : that.pinccrcs != null) return false;
        if (piradss != null ? !piradss.equals(that.piradss) : that.piradss != null) return false;
        if (pirapys != null ? !pirapys.equals(that.pirapys) : that.pirapys != null) return false;
        if (pirsrq != null ? !pirsrq.equals(that.pirsrq) : that.pirsrq != null) return false;
        if (pmcalls != null ? !pmcalls.equals(that.pmcalls) : that.pmcalls != null) return false;
        if (pmrtldc != null ? !pmrtldc.equals(that.pmrtldc) : that.pmrtldc != null) return false;
        if (pmrtldc2 != null ? !pmrtldc2.equals(that.pmrtldc2) : that.pmrtldc2 != null) return false;
        if (pmrtlds != null ? !pmrtlds.equals(that.pmrtlds) : that.pmrtlds != null) return false;
        if (pnbemps != null ? !pnbemps.equals(that.pnbemps) : that.pnbemps != null) return false;
        if (poutxcs != null ? !poutxcs.equals(that.poutxcs) : that.poutxcs != null) return false;
        if (poutxs != null ? !poutxs.equals(that.poutxs) : that.poutxs != null) return false;
        if (ppenpys != null ? !ppenpys.equals(that.ppenpys) : that.ppenpys != null) return false;
        if (pssib != null ? !pssib.equals(that.pssib) : that.pssib != null) return false;
        if (pssib2 != null ? !pssib2.equals(that.pssib2) : that.pssib2 != null) return false;
        if (ptanf != null ? !ptanf.equals(that.ptanf) : that.ptanf != null) return false;
        if (ptanf2 != null ? !ptanf2.equals(that.ptanf2) : that.ptanf2 != null) return false;
        if (ptntics != null ? !ptntics.equals(that.ptntics) : that.ptntics != null) return false;
        if (ptyp != null ? !ptyp.equals(that.ptyp) : that.ptyp != null) return false;
        if (putxpns != null ? !putxpns.equals(that.putxpns) : that.putxpns != null) return false;
        if (pvnebns != null ? !pvnebns.equals(that.pvnebns) : that.pvnebns != null) return false;
        if (pwic != null ? !pwic.equals(that.pwic) : that.pwic != null) return false;
        if (pwic2 != null ? !pwic2.equals(that.pwic2) : that.pwic2 != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (reprrsn != null ? !reprrsn.equals(that.reprrsn) : that.reprrsn != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sbasetcs != null ? !sbasetcs.equals(that.sbasetcs) : that.sbasetcs != null) return false;
        if (seqnum1 != null ? !seqnum1.equals(that.seqnum1) : that.seqnum1 != null) return false;
        if (seqnum10 != null ? !seqnum10.equals(that.seqnum10) : that.seqnum10 != null) return false;
        if (seqnum11 != null ? !seqnum11.equals(that.seqnum11) : that.seqnum11 != null) return false;
        if (seqnum12 != null ? !seqnum12.equals(that.seqnum12) : that.seqnum12 != null) return false;
        if (seqnum2 != null ? !seqnum2.equals(that.seqnum2) : that.seqnum2 != null) return false;
        if (seqnum3 != null ? !seqnum3.equals(that.seqnum3) : that.seqnum3 != null) return false;
        if (seqnum4 != null ? !seqnum4.equals(that.seqnum4) : that.seqnum4 != null) return false;
        if (seqnum5 != null ? !seqnum5.equals(that.seqnum5) : that.seqnum5 != null) return false;
        if (seqnum6 != null ? !seqnum6.equals(that.seqnum6) : that.seqnum6 != null) return false;
        if (seqnum7 != null ? !seqnum7.equals(that.seqnum7) : that.seqnum7 != null) return false;
        if (seqnum8 != null ? !seqnum8.equals(that.seqnum8) : that.seqnum8 != null) return false;
        if (seqnum9 != null ? !seqnum9.equals(that.seqnum9) : that.seqnum9 != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (sitercd != null ? !sitercd.equals(that.sitercd) : that.sitercd != null) return false;
        if (snpkey != null ? !snpkey.equals(that.snpkey) : that.snpkey != null) return false;
        if (ssnfacs != null ? !ssnfacs.equals(that.ssnfacs) : that.ssnfacs != null) return false;
        if (ssnmocs != null ? !ssnmocs.equals(that.ssnmocs) : that.ssnmocs != null) return false;
        if (styp != null ? !styp.equals(that.styp) : that.styp != null) return false;
        if (tranrdt != null ? !tranrdt.equals(that.tranrdt) : that.tranrdt != null) return false;
        if (versnr != null ? !versnr.equals(that.versnr) : that.versnr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recstat != null ? recstat.hashCode() : 0;
        result = 31 * result + (snpkey != null ? snpkey.hashCode() : 0);
        result = 31 * result + (instid != null ? instid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (aidyr != null ? aidyr.hashCode() : 0);
        result = 31 * result + (cmptype != null ? cmptype.hashCode() : 0);
        result = 31 * result + (versnr != null ? versnr.hashCode() : 0);
        result = 31 * result + (pbtuitcs != null ? pbtuitcs.hashCode() : 0);
        result = 31 * result + (pbemalcs != null ? pbemalcs.hashCode() : 0);
        result = 31 * result + (pbsmacs != null ? pbsmacs.hashCode() : 0);
        result = 31 * result + (pbial1Cs != null ? pbial1Cs.hashCode() : 0);
        result = 31 * result + (pbial2Cs != null ? pbial2Cs.hashCode() : 0);
        result = 31 * result + (pbtalocs != null ? pbtalocs.hashCode() : 0);
        result = 31 * result + (pbefincs != null ? pbefincs.hashCode() : 0);
        result = 31 * result + (ptntics != null ? ptntics.hashCode() : 0);
        result = 31 * result + (pbtutacs != null ? pbtutacs.hashCode() : 0);
        result = 31 * result + (pbnwrtcs != null ? pbnwrtcs.hashCode() : 0);
        result = 31 * result + (pbapacs != null ? pbapacs.hashCode() : 0);
        result = 31 * result + (pbdnetcs != null ? pbdnetcs.hashCode() : 0);
        result = 31 * result + (pbascrcs != null ? pbascrcs.hashCode() : 0);
        result = 31 * result + (pbincscs != null ? pbincscs.hashCode() : 0);
        result = 31 * result + (pbaavlcs != null ? pbaavlcs.hashCode() : 0);
        result = 31 * result + (pbhomecs != null ? pbhomecs.hashCode() : 0);
        result = 31 * result + (pbabfwcs != null ? pbabfwcs.hashCode() : 0);
        result = 31 * result + (pbconfcs != null ? pbconfcs.hashCode() : 0);
        result = 31 * result + (pexcldcs != null ? pexcldcs.hashCode() : 0);
        result = 31 * result + (phvplucs != null ? phvplucs.hashCode() : 0);
        result = 31 * result + (pinccrcs != null ? pinccrcs.hashCode() : 0);
        result = 31 * result + (sbasetcs != null ? sbasetcs.hashCode() : 0);
        result = 31 * result + (lonchg1 != null ? lonchg1.hashCode() : 0);
        result = 31 * result + (lonchg2 != null ? lonchg2.hashCode() : 0);
        result = 31 * result + (lonchg3 != null ? lonchg3.hashCode() : 0);
        result = 31 * result + (lonchg4 != null ? lonchg4.hashCode() : 0);
        result = 31 * result + (lonchg5 != null ? lonchg5.hashCode() : 0);
        result = 31 * result + (lonchg6 != null ? lonchg6.hashCode() : 0);
        result = 31 * result + (lonchg7 != null ? lonchg7.hashCode() : 0);
        result = 31 * result + (lonchg8 != null ? lonchg8.hashCode() : 0);
        result = 31 * result + (lonchg9 != null ? lonchg9.hashCode() : 0);
        result = 31 * result + (lonchg10 != null ? lonchg10.hashCode() : 0);
        result = 31 * result + (lonchg11 != null ? lonchg11.hashCode() : 0);
        result = 31 * result + (lonchg12 != null ? lonchg12.hashCode() : 0);
        result = 31 * result + (namflcs != null ? namflcs.hashCode() : 0);
        result = 31 * result + (ssnfacs != null ? ssnfacs.hashCode() : 0);
        result = 31 * result + (nammlcs != null ? nammlcs.hashCode() : 0);
        result = 31 * result + (ssnmocs != null ? ssnmocs.hashCode() : 0);
        result = 31 * result + (pinca1L != null ? pinca1L.hashCode() : 0);
        result = 31 * result + (pinca2L != null ? pinca2L.hashCode() : 0);
        result = 31 * result + (pialo1L != null ? pialo1L.hashCode() : 0);
        result = 31 * result + (pialo2L != null ? pialo2L.hashCode() : 0);
        result = 31 * result + (pbincal != null ? pbincal.hashCode() : 0);
        result = 31 * result + (pbial1L != null ? pbial1L.hashCode() : 0);
        result = 31 * result + (pbial2L != null ? pbial2L.hashCode() : 0);
        result = 31 * result + (passadl != null ? passadl.hashCode() : 0);
        result = 31 * result + (depstf != null ? depstf.hashCode() : 0);
        result = 31 * result + (ptyp != null ? ptyp.hashCode() : 0);
        result = 31 * result + (styp != null ? styp.hashCode() : 0);
        result = 31 * result + (depsti != null ? depsti.hashCode() : 0);
        result = 31 * result + (iptyp != null ? iptyp.hashCode() : 0);
        result = 31 * result + (istyp != null ? istyp.hashCode() : 0);
        result = 31 * result + psai;
        result = 31 * result + ptfcf;
        result = 31 * result + ipsaia;
        result = 31 * result + iptfcfw;
        result = 31 * result + napitx;
        result = 31 * result + napditx;
        result = 31 * result + (tranrdt != null ? tranrdt.hashCode() : 0);
        result = 31 * result + (sitercd != null ? sitercd.hashCode() : 0);
        result = 31 * result + (appsscd != null ? appsscd.hashCode() : 0);
        result = 31 * result + (nsldsno != null ? nsldsno.hashCode() : 0);
        result = 31 * result + (reprrsn != null ? reprrsn.hashCode() : 0);
        result = 31 * result + pasumss;
        result = 31 * result + agspdis;
        result = 31 * result + aguspds;
        result = 31 * result + agcpdis;
        result = 31 * result + agstot;
        result = 31 * result + agustot;
        result = 31 * result + agctot;
        result = 31 * result + lnamt1;
        result = 31 * result + (otbldt1 != null ? otbldt1.hashCode() : 0);
        result = 31 * result + lnamt2;
        result = 31 * result + (otbldt2 != null ? otbldt2.hashCode() : 0);
        result = 31 * result + lnamt3;
        result = 31 * result + (otbldt3 != null ? otbldt3.hashCode() : 0);
        result = 31 * result + lnamt4;
        result = 31 * result + (otbldt4 != null ? otbldt4.hashCode() : 0);
        result = 31 * result + lnamt5;
        result = 31 * result + (otbldt5 != null ? otbldt5.hashCode() : 0);
        result = 31 * result + lnamt6;
        result = 31 * result + (otbldt6 != null ? otbldt6.hashCode() : 0);
        result = 31 * result + (fintcd1 != null ? fintcd1.hashCode() : 0);
        result = 31 * result + (fregcd1 != null ? fregcd1.hashCode() : 0);
        result = 31 * result + (fintcd2 != null ? fintcd2.hashCode() : 0);
        result = 31 * result + (fregcd2 != null ? fregcd2.hashCode() : 0);
        result = 31 * result + (fintcd3 != null ? fintcd3.hashCode() : 0);
        result = 31 * result + (fregcd3 != null ? fregcd3.hashCode() : 0);
        result = 31 * result + (fadlnf4 != null ? fadlnf4.hashCode() : 0);
        result = 31 * result + (fpgmcd4 != null ? fpgmcd4.hashCode() : 0);
        result = 31 * result + (fstcd4 != null ? fstcd4.hashCode() : 0);
        result = 31 * result + (fstdt4 != null ? fstdt4.hashCode() : 0);
        result = 31 * result + flnamt4;
        result = 31 * result + fotbal4;
        result = 31 * result + (foutdt4 != null ? foutdt4.hashCode() : 0);
        result = 31 * result + (fbegdt4 != null ? fbegdt4.hashCode() : 0);
        result = 31 * result + (fenddt4 != null ? fenddt4.hashCode() : 0);
        result = 31 * result + (fgacde4 != null ? fgacde4.hashCode() : 0);
        result = 31 * result + (fintcd4 != null ? fintcd4.hashCode() : 0);
        result = 31 * result + (fsercd4 != null ? fsercd4.hashCode() : 0);
        result = 31 * result + (fregcd4 != null ? fregcd4.hashCode() : 0);
        result = 31 * result + (fadlnf5 != null ? fadlnf5.hashCode() : 0);
        result = 31 * result + (fpgmcd5 != null ? fpgmcd5.hashCode() : 0);
        result = 31 * result + (fstcd5 != null ? fstcd5.hashCode() : 0);
        result = 31 * result + (fstdt5 != null ? fstdt5.hashCode() : 0);
        result = 31 * result + flnamt5;
        result = 31 * result + fotbal5;
        result = 31 * result + (foutdt5 != null ? foutdt5.hashCode() : 0);
        result = 31 * result + (fbegdt5 != null ? fbegdt5.hashCode() : 0);
        result = 31 * result + (fenddt5 != null ? fenddt5.hashCode() : 0);
        result = 31 * result + (fgacde5 != null ? fgacde5.hashCode() : 0);
        result = 31 * result + (fintcd5 != null ? fintcd5.hashCode() : 0);
        result = 31 * result + (fsercd5 != null ? fsercd5.hashCode() : 0);
        result = 31 * result + (fregcd5 != null ? fregcd5.hashCode() : 0);
        result = 31 * result + (fadlnf6 != null ? fadlnf6.hashCode() : 0);
        result = 31 * result + (fpgmcd6 != null ? fpgmcd6.hashCode() : 0);
        result = 31 * result + (fstcd6 != null ? fstcd6.hashCode() : 0);
        result = 31 * result + (fstdt6 != null ? fstdt6.hashCode() : 0);
        result = 31 * result + flnamt6;
        result = 31 * result + fotbal6;
        result = 31 * result + (foutdt6 != null ? foutdt6.hashCode() : 0);
        result = 31 * result + (fbegdt6 != null ? fbegdt6.hashCode() : 0);
        result = 31 * result + (fenddt6 != null ? fenddt6.hashCode() : 0);
        result = 31 * result + (fgacde6 != null ? fgacde6.hashCode() : 0);
        result = 31 * result + (fintcd6 != null ? fintcd6.hashCode() : 0);
        result = 31 * result + (fsercd6 != null ? fsercd6.hashCode() : 0);
        result = 31 * result + (fregcd6 != null ? fregcd6.hashCode() : 0);
        result = 31 * result + (seqnum1 != null ? seqnum1.hashCode() : 0);
        result = 31 * result + (seqnum2 != null ? seqnum2.hashCode() : 0);
        result = 31 * result + (seqnum3 != null ? seqnum3.hashCode() : 0);
        result = 31 * result + (seqnum4 != null ? seqnum4.hashCode() : 0);
        result = 31 * result + (seqnum5 != null ? seqnum5.hashCode() : 0);
        result = 31 * result + (seqnum6 != null ? seqnum6.hashCode() : 0);
        result = 31 * result + (seqnum7 != null ? seqnum7.hashCode() : 0);
        result = 31 * result + (seqnum8 != null ? seqnum8.hashCode() : 0);
        result = 31 * result + (seqnum9 != null ? seqnum9.hashCode() : 0);
        result = 31 * result + (seqnum10 != null ? seqnum10.hashCode() : 0);
        result = 31 * result + (seqnum11 != null ? seqnum11.hashCode() : 0);
        result = 31 * result + (seqnum12 != null ? seqnum12.hashCode() : 0);
        result = 31 * result + (contyp1 != null ? contyp1.hashCode() : 0);
        result = 31 * result + (contyp2 != null ? contyp2.hashCode() : 0);
        result = 31 * result + (contyp3 != null ? contyp3.hashCode() : 0);
        result = 31 * result + (contyp4 != null ? contyp4.hashCode() : 0);
        result = 31 * result + (contyp5 != null ? contyp5.hashCode() : 0);
        result = 31 * result + (contyp6 != null ? contyp6.hashCode() : 0);
        result = 31 * result + (contyp7 != null ? contyp7.hashCode() : 0);
        result = 31 * result + (contyp8 != null ? contyp8.hashCode() : 0);
        result = 31 * result + (contyp9 != null ? contyp9.hashCode() : 0);
        result = 31 * result + (contyp10 != null ? contyp10.hashCode() : 0);
        result = 31 * result + (contyp11 != null ? contyp11.hashCode() : 0);
        result = 31 * result + (contyp12 != null ? contyp12.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        result = 31 * result + p2Onti;
        result = 31 * result + p2Onti2;
        result = 31 * result + p2Ontic;
        result = 31 * result + (p2Ontis != null ? p2Ontis.hashCode() : 0);
        result = 31 * result + (p2Ontics != null ? p2Ontics.hashCode() : 0);
        result = 31 * result + (nsldldt != null ? nsldldt.hashCode() : 0);
        result = 31 * result + (pmrtldc != null ? pmrtldc.hashCode() : 0);
        result = 31 * result + (pmrtldc2 != null ? pmrtldc2.hashCode() : 0);
        result = 31 * result + (pmrtlds != null ? pmrtlds.hashCode() : 0);
        result = 31 * result + (nameff != null ? nameff.hashCode() : 0);
        result = 31 * result + (namemf != null ? namemf.hashCode() : 0);
        result = 31 * result + (emadtp != null ? emadtp.hashCode() : 0);
        result = 31 * result + (fatdob != null ? fatdob.hashCode() : 0);
        result = 31 * result + (motdob != null ? motdob.hashCode() : 0);
        result = 31 * result + (nameff2 != null ? nameff2.hashCode() : 0);
        result = 31 * result + (namemf2 != null ? namemf2.hashCode() : 0);
        result = 31 * result + (emadtp2 != null ? emadtp2.hashCode() : 0);
        result = 31 * result + (fatdob2 != null ? fatdob2.hashCode() : 0);
        result = 31 * result + (motdob2 != null ? motdob2.hashCode() : 0);
        result = 31 * result + (nameffs != null ? nameffs.hashCode() : 0);
        result = 31 * result + (namemfs != null ? namemfs.hashCode() : 0);
        result = 31 * result + (emadtps != null ? emadtps.hashCode() : 0);
        result = 31 * result + (fatdobs != null ? fatdobs.hashCode() : 0);
        result = 31 * result + (motdobs != null ? motdobs.hashCode() : 0);
        result = 31 * result + (fssnmf != null ? fssnmf.hashCode() : 0);
        result = 31 * result + (mssnmf != null ? mssnmf.hashCode() : 0);
        result = 31 * result + (pssib != null ? pssib.hashCode() : 0);
        result = 31 * result + (pfsb != null ? pfsb.hashCode() : 0);
        result = 31 * result + (pflb != null ? pflb.hashCode() : 0);
        result = 31 * result + (ptanf != null ? ptanf.hashCode() : 0);
        result = 31 * result + (pwic != null ? pwic.hashCode() : 0);
        result = 31 * result + (pssib2 != null ? pssib2.hashCode() : 0);
        result = 31 * result + (pfsb2 != null ? pfsb2.hashCode() : 0);
        result = 31 * result + (pflb2 != null ? pflb2.hashCode() : 0);
        result = 31 * result + (ptanf2 != null ? ptanf2.hashCode() : 0);
        result = 31 * result + (pwic2 != null ? pwic2.hashCode() : 0);
        result = 31 * result + (frlnchg != null ? frlnchg.hashCode() : 0);
        result = 31 * result + pcstpd;
        result = 31 * result + pcomby;
        result = 31 * result + pcstpd2;
        result = 31 * result + pcomby2;
        result = 31 * result + (pcombys != null ? pcombys.hashCode() : 0);
        result = 31 * result + (pcstpds != null ? pcstpds.hashCode() : 0);
        result = 31 * result + l41Lev;
        result = 31 * result + pedcrd;
        result = 31 * result + pnbemp;
        result = 31 * result + pgtsad;
        result = 31 * result + ppenpy;
        result = 31 * result + pirapy;
        result = 31 * result + pirads;
        result = 31 * result + putxpn;
        result = 31 * result + pmcall;
        result = 31 * result + pvnebn;
        result = 31 * result + pedcrd2;
        result = 31 * result + pnbemp2;
        result = 31 * result + pgtsad2;
        result = 31 * result + ppenpy2;
        result = 31 * result + pirapy2;
        result = 31 * result + pirads2;
        result = 31 * result + putxpn2;
        result = 31 * result + pmcall2;
        result = 31 * result + pvnebn2;
        result = 31 * result + (pedcrds != null ? pedcrds.hashCode() : 0);
        result = 31 * result + (pnbemps != null ? pnbemps.hashCode() : 0);
        result = 31 * result + (pgtsads != null ? pgtsads.hashCode() : 0);
        result = 31 * result + (ppenpys != null ? ppenpys.hashCode() : 0);
        result = 31 * result + (pirapys != null ? pirapys.hashCode() : 0);
        result = 31 * result + (piradss != null ? piradss.hashCode() : 0);
        result = 31 * result + (putxpns != null ? putxpns.hashCode() : 0);
        result = 31 * result + (pmcalls != null ? pmcalls.hashCode() : 0);
        result = 31 * result + (pvnebns != null ? pvnebns.hashCode() : 0);
        result = 31 * result + poutx;
        result = 31 * result + poutx2;
        result = 31 * result + poutxc;
        result = 31 * result + (poutxs != null ? poutxs.hashCode() : 0);
        result = 31 * result + (poutxcs != null ? poutxcs.hashCode() : 0);
        result = 31 * result + (numemp != null ? numemp.hashCode() : 0);
        result = 31 * result + pcoop;
        result = 31 * result + pcoop2;
        result = 31 * result + pcoopc;
        result = 31 * result + (pcoops != null ? pcoops.hashCode() : 0);
        result = 31 * result + (pcoopcs != null ? pcoopcs.hashCode() : 0);
        result = 31 * result + (pirsrq != null ? pirsrq.hashCode() : 0);
        result = 31 * result + ptsctc;
        result = 31 * result + (pathx != null ? pathx.hashCode() : 0);
        result = 31 * result + (pathx2 != null ? pathx2.hashCode() : 0);
        result = 31 * result + (pathxc != null ? pathxc.hashCode() : 0);
        result = 31 * result + (pathxs != null ? pathxs.hashCode() : 0);
        result = 31 * result + (pathxcs != null ? pathxcs.hashCode() : 0);
        result = 31 * result + (apathex != null ? apathex.hashCode() : 0);
        result = 31 * result + (pfsbs != null ? pfsbs.hashCode() : 0);
        result = 31 * result + (pfsbcs != null ? pfsbcs.hashCode() : 0);
        result = 31 * result + stuptu;
        result = 31 * result + stbptu;
        return result;
    }
}
