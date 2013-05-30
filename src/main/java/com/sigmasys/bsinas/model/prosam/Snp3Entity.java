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
 * Date: 11/26/12
 * Time: 12:09 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNP3", schema = "SIGMA", catalog = "")
@Entity
public class Snp3Entity implements Identifiable {

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

    private String pmaritlc;

    @javax.persistence.Column(name = "PMARITLC")
    @Basic
    public String getPmaritlc() {
        return pmaritlc;
    }

    public void setPmaritlc(String pmaritlc) {
        this.pmaritlc = pmaritlc;
    }

    private BigInteger pagec;

    @javax.persistence.Column(name = "PAGEC")
    @Basic
    public BigInteger getPagec() {
        return pagec;
    }

    public void setPagec(BigInteger pagec) {
        this.pagec = pagec;
    }

    private BigInteger psizhhdc;

    @javax.persistence.Column(name = "PSIZHHDC")
    @Basic
    public BigInteger getPsizhhdc() {
        return psizhhdc;
    }

    public void setPsizhhdc(BigInteger psizhhdc) {
        this.psizhhdc = psizhhdc;
    }

    private BigInteger pexempc;

    @javax.persistence.Column(name = "PEXEMPC")
    @Basic
    public BigInteger getPexempc() {
        return pexempc;
    }

    public void setPexempc(BigInteger pexempc) {
        this.pexempc = pexempc;
    }

    private BigInteger pnrpsc;

    @javax.persistence.Column(name = "PNRPSC")
    @Basic
    public BigInteger getPnrpsc() {
        return pnrpsc;
    }

    public void setPnrpsc(BigInteger pnrpsc) {
        this.pnrpsc = pnrpsc;
    }

    private BigInteger pincollc;

    @javax.persistence.Column(name = "PINCOLLC")
    @Basic
    public BigInteger getPincollc() {
        return pincollc;
    }

    public void setPincollc(BigInteger pincollc) {
        this.pincollc = pincollc;
    }

    private String pdiswkc;

    @javax.persistence.Column(name = "PDISWKC")
    @Basic
    public String getPdiswkc() {
        return pdiswkc;
    }

    public void setPdiswkc(String pdiswkc) {
        this.pdiswkc = pdiswkc;
    }

    private String pdishmc;

    @javax.persistence.Column(name = "PDISHMC")
    @Basic
    public String getPdishmc() {
        return pdishmc;
    }

    public void setPdishmc(String pdishmc) {
        this.pdishmc = pdishmc;
    }

    private String ptrfilc;

    @javax.persistence.Column(name = "PTRFILC")
    @Basic
    public String getPtrfilc() {
        return ptrfilc;
    }

    public void setPtrfilc(String ptrfilc) {
        this.ptrfilc = ptrfilc;
    }

    private int pfwagc;

    @javax.persistence.Column(name = "PFWAGC")
    @Basic
    public int getPfwagc() {
        return pfwagc;
    }

    public void setPfwagc(int pfwagc) {
        this.pfwagc = pfwagc;
    }

    private int pmwagc;

    @javax.persistence.Column(name = "PMWAGC")
    @Basic
    public int getPmwagc() {
        return pmwagc;
    }

    public void setPmwagc(int pmwagc) {
        this.pmwagc = pmwagc;
    }

    private int padjwc;

    @javax.persistence.Column(name = "PADJWC")
    @Basic
    public int getPadjwc() {
        return padjwc;
    }

    public void setPadjwc(int padjwc) {
        this.padjwc = padjwc;
    }

    private int pwagc;

    @javax.persistence.Column(name = "PWAGC")
    @Basic
    public int getPwagc() {
        return pwagc;
    }

    public void setPwagc(int pwagc) {
        this.pwagc = pwagc;
    }

    private int pintc;

    @javax.persistence.Column(name = "PINTC")
    @Basic
    public int getPintc() {
        return pintc;
    }

    public void setPintc(int pintc) {
        this.pintc = pintc;
    }

    private int pdivc;

    @javax.persistence.Column(name = "PDIVC")
    @Basic
    public int getPdivc() {
        return pdivc;
    }

    public void setPdivc(int pdivc) {
        this.pdivc = pdivc;
    }

    private int pbfric;

    @javax.persistence.Column(name = "PBFRIC")
    @Basic
    public int getPbfric() {
        return pbfric;
    }

    public void setPbfric(int pbfric) {
        this.pbfric = pbfric;
    }

    private int potic;

    @javax.persistence.Column(name = "POTIC")
    @Basic
    public int getPotic() {
        return potic;
    }

    public void setPotic(int potic) {
        this.potic = potic;
    }

    private int pbexc;

    @javax.persistence.Column(name = "PBEXC")
    @Basic
    public int getPbexc() {
        return pbexc;
    }

    public void setPbexc(int pbexc) {
        this.pbexc = pbexc;
    }

    private int padjc;

    @javax.persistence.Column(name = "PADJC")
    @Basic
    public int getPadjc() {
        return padjc;
    }

    public void setPadjc(int padjc) {
        this.padjc = padjc;
    }

    private int pttincc;

    @javax.persistence.Column(name = "PTTINCC")
    @Basic
    public int getPttincc() {
        return pttincc;
    }

    public void setPttincc(int pttincc) {
        this.pttincc = pttincc;
    }

    private int pagirc;

    @javax.persistence.Column(name = "PAGIRC")
    @Basic
    public int getPagirc() {
        return pagirc;
    }

    public void setPagirc(int pagirc) {
        this.pagirc = pagirc;
    }

    private int pssc;

    @javax.persistence.Column(name = "PSSC")
    @Basic
    public int getPssc() {
        return pssc;
    }

    public void setPssc(int pssc) {
        this.pssc = pssc;
    }

    private int padcc;

    @javax.persistence.Column(name = "PADCC")
    @Basic
    public int getPadcc() {
        return padcc;
    }

    public void setPadcc(int padcc) {
        this.padcc = padcc;
    }

    private int pntcsc;

    @javax.persistence.Column(name = "PNTCSC")
    @Basic
    public int getPntcsc() {
        return pntcsc;
    }

    public void setPntcsc(int pntcsc) {
        this.pntcsc = pntcsc;
    }

    private int pontic;

    @javax.persistence.Column(name = "PONTIC")
    @Basic
    public int getPontic() {
        return pontic;
    }

    public void setPontic(int pontic) {
        this.pontic = pontic;
    }

    private int pinca1C;

    @javax.persistence.Column(name = "PINCA1C")
    @Basic
    public int getPinca1C() {
        return pinca1C;
    }

    public void setPinca1C(int pinca1C) {
        this.pinca1C = pinca1C;
    }

    private int pinca2C;

    @javax.persistence.Column(name = "PINCA2C")
    @Basic
    public int getPinca2C() {
        return pinca2C;
    }

    public void setPinca2C(int pinca2C) {
        this.pinca2C = pinca2C;
    }

    private int ptincc;

    @javax.persistence.Column(name = "PTINCC")
    @Basic
    public int getPtincc() {
        return ptincc;
    }

    public void setPtincc(int ptincc) {
        this.ptincc = ptincc;
    }

    private int pdedc;

    @javax.persistence.Column(name = "PDEDC")
    @Basic
    public int getPdedc() {
        return pdedc;
    }

    public void setPdedc(int pdedc) {
        this.pdedc = pdedc;
    }

    private int pitxpc;

    @javax.persistence.Column(name = "PITXPC")
    @Basic
    public int getPitxpc() {
        return pitxpc;
    }

    public void setPitxpc(int pitxpc) {
        this.pitxpc = pitxpc;
    }

    private int pitxcc;

    @javax.persistence.Column(name = "PITXCC")
    @Basic
    public int getPitxcc() {
        return pitxcc;
    }

    public void setPitxcc(int pitxcc) {
        this.pitxcc = pitxcc;
    }

    private int pitxvc;

    @javax.persistence.Column(name = "PITXVC")
    @Basic
    public int getPitxvc() {
        return pitxvc;
    }

    public void setPitxvc(int pitxvc) {
        this.pitxvc = pitxvc;
    }

    private int pficac;

    @javax.persistence.Column(name = "PFICAC")
    @Basic
    public int getPficac() {
        return pficac;
    }

    public void setPficac(int pficac) {
        this.pficac = pficac;
    }

    private int psttxc;

    @javax.persistence.Column(name = "PSTTXC")
    @Basic
    public int getPsttxc() {
        return psttxc;
    }

    public void setPsttxc(int psttxc) {
        this.psttxc = psttxc;
    }

    private int pmedc;

    @javax.persistence.Column(name = "PMEDC")
    @Basic
    public int getPmedc() {
        return pmedc;
    }

    public void setPmedc(int pmedc) {
        this.pmedc = pmedc;
    }

    private int pmedac;

    @javax.persistence.Column(name = "PMEDAC")
    @Basic
    public int getPmedac() {
        return pmedac;
    }

    public void setPmedac(int pmedac) {
        this.pmedac = pmedac;
    }

    private int ptuitc;

    @javax.persistence.Column(name = "PTUITC")
    @Basic
    public int getPtuitc() {
        return ptuitc;
    }

    public void setPtuitc(int ptuitc) {
        this.ptuitc = ptuitc;
    }

    private BigInteger pntuitc;

    @javax.persistence.Column(name = "PNTUITC")
    @Basic
    public BigInteger getPntuitc() {
        return pntuitc;
    }

    public void setPntuitc(BigInteger pntuitc) {
        this.pntuitc = pntuitc;
    }

    private int ptuitac;

    @javax.persistence.Column(name = "PTUITAC")
    @Basic
    public int getPtuitac() {
        return ptuitac;
    }

    public void setPtuitac(int ptuitac) {
        this.ptuitac = ptuitac;
    }

    private int pemaloc;

    @javax.persistence.Column(name = "PEMALOC")
    @Basic
    public int getPemaloc() {
        return pemaloc;
    }

    public void setPemaloc(int pemaloc) {
        this.pemaloc = pemaloc;
    }

    private int psmac;

    @javax.persistence.Column(name = "PSMAC")
    @Basic
    public int getPsmac() {
        return psmac;
    }

    public void setPsmac(int psmac) {
        this.psmac = psmac;
    }

    private int pialo1C;

    @javax.persistence.Column(name = "PIALO1C")
    @Basic
    public int getPialo1C() {
        return pialo1C;
    }

    public void setPialo1C(int pialo1C) {
        this.pialo1C = pialo1C;
    }

    private int pialo2C;

    @javax.persistence.Column(name = "PIALO2C")
    @Basic
    public int getPialo2C() {
        return pialo2C;
    }

    public void setPialo2C(int pialo2C) {
        this.pialo2C = pialo2C;
    }

    private int ptotaloc;

    @javax.persistence.Column(name = "PTOTALOC")
    @Basic
    public int getPtotaloc() {
        return ptotaloc;
    }

    public void setPtotaloc(int ptotaloc) {
        this.ptotaloc = ptotaloc;
    }

    private int pefincc;

    @javax.persistence.Column(name = "PEFINCC")
    @Basic
    public int getPefincc() {
        return pefincc;
    }

    public void setPefincc(int pefincc) {
        this.pefincc = pefincc;
    }

    private int pcashc;

    @javax.persistence.Column(name = "PCASHC")
    @Basic
    public int getPcashc() {
        return pcashc;
    }

    public void setPcashc(int pcashc) {
        this.pcashc = pcashc;
    }

    private int pinvvc;

    @javax.persistence.Column(name = "PINVVC")
    @Basic
    public int getPinvvc() {
        return pinvvc;
    }

    public void setPinvvc(int pinvvc) {
        this.pinvvc = pinvvc;
    }

    private int pinvdc;

    @javax.persistence.Column(name = "PINVDC")
    @Basic
    public int getPinvdc() {
        return pinvdc;
    }

    public void setPinvdc(int pinvdc) {
        this.pinvdc = pinvdc;
    }

    private int pinvec;

    @javax.persistence.Column(name = "PINVEC")
    @Basic
    public int getPinvec() {
        return pinvec;
    }

    public void setPinvec(int pinvec) {
        this.pinvec = pinvec;
    }

    private int porvc;

    @javax.persistence.Column(name = "PORVC")
    @Basic
    public int getPorvc() {
        return porvc;
    }

    public void setPorvc(int porvc) {
        this.porvc = porvc;
    }

    private int pordc;

    @javax.persistence.Column(name = "PORDC")
    @Basic
    public int getPordc() {
        return pordc;
    }

    public void setPordc(int pordc) {
        this.pordc = pordc;
    }

    private int porec;

    @javax.persistence.Column(name = "POREC")
    @Basic
    public int getPorec() {
        return porec;
    }

    public void setPorec(int porec) {
        this.porec = porec;
    }

    private int pdassc;

    @javax.persistence.Column(name = "PDASSC")
    @Basic
    public int getPdassc() {
        return pdassc;
    }

    public void setPdassc(int pdassc) {
        this.pdassc = pdassc;
    }

    private int phompvc;

    @javax.persistence.Column(name = "PHOMPVC")
    @Basic
    public int getPhompvc() {
        return phompvc;
    }

    public void setPhompvc(int phompvc) {
        this.phompvc = phompvc;
    }

    private int phomcc;

    @javax.persistence.Column(name = "PHOMCC")
    @Basic
    public int getPhomcc() {
        return phomcc;
    }

    public void setPhomcc(int phomcc) {
        this.phomcc = phomcc;
    }

    private int phomvc;

    @javax.persistence.Column(name = "PHOMVC")
    @Basic
    public int getPhomvc() {
        return phomvc;
    }

    public void setPhomvc(int phomvc) {
        this.phomvc = phomvc;
    }

    private int phomdc;

    @javax.persistence.Column(name = "PHOMDC")
    @Basic
    public int getPhomdc() {
        return phomdc;
    }

    public void setPhomdc(int phomdc) {
        this.phomdc = phomdc;
    }

    private int phomec;

    @javax.persistence.Column(name = "PHOMEC")
    @Basic
    public int getPhomec() {
        return phomec;
    }

    public void setPhomec(int phomec) {
        this.phomec = phomec;
    }

    private int pfarmvc;

    @javax.persistence.Column(name = "PFARMVC")
    @Basic
    public int getPfarmvc() {
        return pfarmvc;
    }

    public void setPfarmvc(int pfarmvc) {
        this.pfarmvc = pfarmvc;
    }

    private int pfarmdc;

    @javax.persistence.Column(name = "PFARMDC")
    @Basic
    public int getPfarmdc() {
        return pfarmdc;
    }

    public void setPfarmdc(int pfarmdc) {
        this.pfarmdc = pfarmdc;
    }

    private int pfarmec;

    @javax.persistence.Column(name = "PFARMEC")
    @Basic
    public int getPfarmec() {
        return pfarmec;
    }

    public void setPfarmec(int pfarmec) {
        this.pfarmec = pfarmec;
    }

    private int pbfvc;

    @javax.persistence.Column(name = "PBFVC")
    @Basic
    public int getPbfvc() {
        return pbfvc;
    }

    public void setPbfvc(int pbfvc) {
        this.pbfvc = pbfvc;
    }

    private int pbfdc;

    @javax.persistence.Column(name = "PBFDC")
    @Basic
    public int getPbfdc() {
        return pbfdc;
    }

    public void setPbfdc(int pbfdc) {
        this.pbfdc = pbfdc;
    }

    private int pbfec;

    @javax.persistence.Column(name = "PBFEC")
    @Basic
    public int getPbfec() {
        return pbfec;
    }

    public void setPbfec(int pbfec) {
        this.pbfec = pbfec;
    }

    private String pfarmc;

    @javax.persistence.Column(name = "PFARMC")
    @Basic
    public String getPfarmc() {
        return pfarmc;
    }

    public void setPfarmc(String pfarmc) {
        this.pfarmc = pfarmc;
    }

    private int pabfwc;

    @javax.persistence.Column(name = "PABFWC")
    @Basic
    public int getPabfwc() {
        return pabfwc;
    }

    public void setPabfwc(int pabfwc) {
        this.pabfwc = pabfwc;
    }

    private int passadjc;

    @javax.persistence.Column(name = "PASSADJC")
    @Basic
    public int getPassadjc() {
        return passadjc;
    }

    public void setPassadjc(int passadjc) {
        this.passadjc = passadjc;
    }

    private int ptassc;

    @javax.persistence.Column(name = "PTASSC")
    @Basic
    public int getPtassc() {
        return ptassc;
    }

    public void setPtassc(int ptassc) {
        this.ptassc = ptassc;
    }

    private int pothdc;

    @javax.persistence.Column(name = "POTHDC")
    @Basic
    public int getPothdc() {
        return pothdc;
    }

    public void setPothdc(int pothdc) {
        this.pothdc = pothdc;
    }

    private int pnwrthc;

    @javax.persistence.Column(name = "PNWRTHC")
    @Basic
    public int getPnwrthc() {
        return pnwrthc;
    }

    public void setPnwrthc(int pnwrthc) {
        this.pnwrthc = pnwrthc;
    }

    private int papac;

    @javax.persistence.Column(name = "PAPAC")
    @Basic
    public int getPapac() {
        return papac;
    }

    public void setPapac(int papac) {
        this.papac = papac;
    }

    private int pdnetc;

    @javax.persistence.Column(name = "PDNETC")
    @Basic
    public int getPdnetc() {
        return pdnetc;
    }

    public void setPdnetc(int pdnetc) {
        this.pdnetc = pdnetc;
    }

    private BigDecimal passcrc;

    @javax.persistence.Column(name = "PASSCRC")
    @Basic
    public BigDecimal getPasscrc() {
        return passcrc;
    }

    public void setPasscrc(BigDecimal passcrc) {
        this.passcrc = passcrc;
    }

    private int pincsuc;

    @javax.persistence.Column(name = "PINCSUC")
    @Basic
    public int getPincsuc() {
        return pincsuc;
    }

    public void setPincsuc(int pincsuc) {
        this.pincsuc = pincsuc;
    }

    private int paavlic;

    @javax.persistence.Column(name = "PAAVLIC")
    @Basic
    public int getPaavlic() {
        return paavlic;
    }

    public void setPaavlic(int paavlic) {
        this.paavlic = paavlic;
    }

    private BigDecimal pcolac;

    @javax.persistence.Column(name = "PCOLAC")
    @Basic
    public BigDecimal getPcolac() {
        return pcolac;
    }

    public void setPcolac(BigDecimal pcolac) {
        this.pcolac = pcolac;
    }

    private int praavlic;

    @javax.persistence.Column(name = "PRAAVLIC")
    @Basic
    public int getPraavlic() {
        return praavlic;
    }

    public void setPraavlic(int praavlic) {
        this.praavlic = praavlic;
    }

    private int ptconfc;

    @javax.persistence.Column(name = "PTCONFC")
    @Basic
    public int getPtconfc() {
        return ptconfc;
    }

    public void setPtconfc(int ptconfc) {
        this.ptconfc = ptconfc;
    }

    private int pconfnc;

    @javax.persistence.Column(name = "PCONFNC")
    @Basic
    public int getPconfnc() {
        return pconfnc;
    }

    public void setPconfnc(int pconfnc) {
        this.pconfnc = pconfnc;
    }

    private int pconfc;

    @javax.persistence.Column(name = "PCONFC")
    @Basic
    public int getPconfc() {
        return pconfc;
    }

    public void setPconfc(int pconfc) {
        this.pconfc = pconfc;
    }

    private int pbfwagc;

    @javax.persistence.Column(name = "PBFWAGC")
    @Basic
    public int getPbfwagc() {
        return pbfwagc;
    }

    public void setPbfwagc(int pbfwagc) {
        this.pbfwagc = pbfwagc;
    }

    private int pbmwagc;

    @javax.persistence.Column(name = "PBMWAGC")
    @Basic
    public int getPbmwagc() {
        return pbmwagc;
    }

    public void setPbmwagc(int pbmwagc) {
        this.pbmwagc = pbmwagc;
    }

    private int pbotic;

    @javax.persistence.Column(name = "PBOTIC")
    @Basic
    public int getPbotic() {
        return pbotic;
    }

    public void setPbotic(int pbotic) {
        this.pbotic = pbotic;
    }

    private int pbttic;

    @javax.persistence.Column(name = "PBTTIC")
    @Basic
    public int getPbttic() {
        return pbttic;
    }

    public void setPbttic(int pbttic) {
        this.pbttic = pbttic;
    }

    private int pbagirc;

    @javax.persistence.Column(name = "PBAGIRC")
    @Basic
    public int getPbagirc() {
        return pbagirc;
    }

    public void setPbagirc(int pbagirc) {
        this.pbagirc = pbagirc;
    }

    private int pbssc;

    @javax.persistence.Column(name = "PBSSC")
    @Basic
    public int getPbssc() {
        return pbssc;
    }

    public void setPbssc(int pbssc) {
        this.pbssc = pbssc;
    }

    private int pbadcc;

    @javax.persistence.Column(name = "PBADCC")
    @Basic
    public int getPbadcc() {
        return pbadcc;
    }

    public void setPbadcc(int pbadcc) {
        this.pbadcc = pbadcc;
    }

    private int pbntcsc;

    @javax.persistence.Column(name = "PBNTCSC")
    @Basic
    public int getPbntcsc() {
        return pbntcsc;
    }

    public void setPbntcsc(int pbntcsc) {
        this.pbntcsc = pbntcsc;
    }

    private int pbontic;

    @javax.persistence.Column(name = "PBONTIC")
    @Basic
    public int getPbontic() {
        return pbontic;
    }

    public void setPbontic(int pbontic) {
        this.pbontic = pbontic;
    }

    private int pbincac;

    @javax.persistence.Column(name = "PBINCAC")
    @Basic
    public int getPbincac() {
        return pbincac;
    }

    public void setPbincac(int pbincac) {
        this.pbincac = pbincac;
    }

    private int pbntic;

    @javax.persistence.Column(name = "PBNTIC")
    @Basic
    public int getPbntic() {
        return pbntic;
    }

    public void setPbntic(int pbntic) {
        this.pbntic = pbntic;
    }

    private int pbtic;

    @javax.persistence.Column(name = "PBTIC")
    @Basic
    public int getPbtic() {
        return pbtic;
    }

    public void setPbtic(int pbtic) {
        this.pbtic = pbtic;
    }

    private int pbitxc;

    @javax.persistence.Column(name = "PBITXC")
    @Basic
    public int getPbitxc() {
        return pbitxc;
    }

    public void setPbitxc(int pbitxc) {
        this.pbitxc = pbitxc;
    }

    private int pbficac;

    @javax.persistence.Column(name = "PBFICAC")
    @Basic
    public int getPbficac() {
        return pbficac;
    }

    public void setPbficac(int pbficac) {
        this.pbficac = pbficac;
    }

    private int pbsttxc;

    @javax.persistence.Column(name = "PBSTTXC")
    @Basic
    public int getPbsttxc() {
        return pbsttxc;
    }

    public void setPbsttxc(int pbsttxc) {
        this.pbsttxc = pbsttxc;
    }

    private int pbmedac;

    @javax.persistence.Column(name = "PBMEDAC")
    @Basic
    public int getPbmedac() {
        return pbmedac;
    }

    public void setPbmedac(int pbmedac) {
        this.pbmedac = pbmedac;
    }

    private int pbtuitc;

    @javax.persistence.Column(name = "PBTUITC")
    @Basic
    public int getPbtuitc() {
        return pbtuitc;
    }

    public void setPbtuitc(int pbtuitc) {
        this.pbtuitc = pbtuitc;
    }

    private int pbemalc;

    @javax.persistence.Column(name = "PBEMALC")
    @Basic
    public int getPbemalc() {
        return pbemalc;
    }

    public void setPbemalc(int pbemalc) {
        this.pbemalc = pbemalc;
    }

    private int pbsmac;

    @javax.persistence.Column(name = "PBSMAC")
    @Basic
    public int getPbsmac() {
        return pbsmac;
    }

    public void setPbsmac(int pbsmac) {
        this.pbsmac = pbsmac;
    }

    private int pbial1C;

    @javax.persistence.Column(name = "PBIAL1C")
    @Basic
    public int getPbial1C() {
        return pbial1C;
    }

    public void setPbial1C(int pbial1C) {
        this.pbial1C = pbial1C;
    }

    private int pbial2C;

    @javax.persistence.Column(name = "PBIAL2C")
    @Basic
    public int getPbial2C() {
        return pbial2C;
    }

    public void setPbial2C(int pbial2C) {
        this.pbial2C = pbial2C;
    }

    private int pbtaloc;

    @javax.persistence.Column(name = "PBTALOC")
    @Basic
    public int getPbtaloc() {
        return pbtaloc;
    }

    public void setPbtaloc(int pbtaloc) {
        this.pbtaloc = pbtaloc;
    }

    private int pbefinc;

    @javax.persistence.Column(name = "PBEFINC")
    @Basic
    public int getPbefinc() {
        return pbefinc;
    }

    public void setPbefinc(int pbefinc) {
        this.pbefinc = pbefinc;
    }

    private int ptntic;

    @javax.persistence.Column(name = "PTNTIC")
    @Basic
    public int getPtntic() {
        return ptntic;
    }

    public void setPtntic(int ptntic) {
        this.ptntic = ptntic;
    }

    private int pbtuitac;

    @javax.persistence.Column(name = "PBTUITAC")
    @Basic
    public int getPbtuitac() {
        return pbtuitac;
    }

    public void setPbtuitac(int pbtuitac) {
        this.pbtuitac = pbtuitac;
    }

    private int pbnwrthc;

    @javax.persistence.Column(name = "PBNWRTHC")
    @Basic
    public int getPbnwrthc() {
        return pbnwrthc;
    }

    public void setPbnwrthc(int pbnwrthc) {
        this.pbnwrthc = pbnwrthc;
    }

    private int pbapac;

    @javax.persistence.Column(name = "PBAPAC")
    @Basic
    public int getPbapac() {
        return pbapac;
    }

    public void setPbapac(int pbapac) {
        this.pbapac = pbapac;
    }

    private int pbdnetc;

    @javax.persistence.Column(name = "PBDNETC")
    @Basic
    public int getPbdnetc() {
        return pbdnetc;
    }

    public void setPbdnetc(int pbdnetc) {
        this.pbdnetc = pbdnetc;
    }

    private BigDecimal pbasscrc;

    @javax.persistence.Column(name = "PBASSCRC")
    @Basic
    public BigDecimal getPbasscrc() {
        return pbasscrc;
    }

    public void setPbasscrc(BigDecimal pbasscrc) {
        this.pbasscrc = pbasscrc;
    }

    private int pbincsuc;

    @javax.persistence.Column(name = "PBINCSUC")
    @Basic
    public int getPbincsuc() {
        return pbincsuc;
    }

    public void setPbincsuc(int pbincsuc) {
        this.pbincsuc = pbincsuc;
    }

    private int pbaavlic;

    @javax.persistence.Column(name = "PBAAVLIC")
    @Basic
    public int getPbaavlic() {
        return pbaavlic;
    }

    public void setPbaavlic(int pbaavlic) {
        this.pbaavlic = pbaavlic;
    }

    private int pbhomec;

    @javax.persistence.Column(name = "PBHOMEC")
    @Basic
    public int getPbhomec() {
        return pbhomec;
    }

    public void setPbhomec(int pbhomec) {
        this.pbhomec = pbhomec;
    }

    private int pbabfwc;

    @javax.persistence.Column(name = "PBABFWC")
    @Basic
    public int getPbabfwc() {
        return pbabfwc;
    }

    public void setPbabfwc(int pbabfwc) {
        this.pbabfwc = pbabfwc;
    }

    private int pbconfc;

    @javax.persistence.Column(name = "PBCONFC")
    @Basic
    public int getPbconfc() {
        return pbconfc;
    }

    public void setPbconfc(int pbconfc) {
        this.pbconfc = pbconfc;
    }

    private int pexcldc;

    @javax.persistence.Column(name = "PEXCLDC")
    @Basic
    public int getPexcldc() {
        return pexcldc;
    }

    public void setPexcldc(int pexcldc) {
        this.pexcldc = pexcldc;
    }

    private String phvplusc;

    @javax.persistence.Column(name = "PHVPLUSC")
    @Basic
    public String getPhvplusc() {
        return phvplusc;
    }

    public void setPhvplusc(String phvplusc) {
        this.phvplusc = phvplusc;
    }

    private int pinccrc;

    @javax.persistence.Column(name = "PINCCRC")
    @Basic
    public int getPinccrc() {
        return pinccrc;
    }

    public void setPinccrc(int pinccrc) {
        this.pinccrc = pinccrc;
    }

    private BigInteger phmyrcz;

    @javax.persistence.Column(name = "PHMYRCZ")
    @Basic
    public BigInteger getPhmyrcz() {
        return phmyrcz;
    }

    public void setPhmyrcz(BigInteger phmyrcz) {
        this.phmyrcz = phmyrcz;
    }

    private BigInteger phomyrc;

    @javax.persistence.Column(name = "PHOMYRC")
    @Basic
    public BigInteger getPhomyrc() {
        return phomyrc;
    }

    public void setPhomyrc(BigInteger phomyrc) {
        this.phomyrc = phomyrc;
    }

    private int sbasetc;

    @javax.persistence.Column(name = "SBASETC")
    @Basic
    public int getSbasetc() {
        return sbasetc;
    }

    public void setSbasetc(int sbasetc) {
        this.sbasetc = sbasetc;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snp3Entity that = (Snp3Entity) o;

        if (paavlic != that.paavlic) return false;
        if (pabfwc != that.pabfwc) return false;
        if (padcc != that.padcc) return false;
        if (padjc != that.padjc) return false;
        if (padjwc != that.padjwc) return false;
        if (pagirc != that.pagirc) return false;
        if (papac != that.papac) return false;
        if (passadjc != that.passadjc) return false;
        if (pbaavlic != that.pbaavlic) return false;
        if (pbabfwc != that.pbabfwc) return false;
        if (pbadcc != that.pbadcc) return false;
        if (pbagirc != that.pbagirc) return false;
        if (pbapac != that.pbapac) return false;
        if (pbconfc != that.pbconfc) return false;
        if (pbdnetc != that.pbdnetc) return false;
        if (pbefinc != that.pbefinc) return false;
        if (pbemalc != that.pbemalc) return false;
        if (pbexc != that.pbexc) return false;
        if (pbfdc != that.pbfdc) return false;
        if (pbfec != that.pbfec) return false;
        if (pbficac != that.pbficac) return false;
        if (pbfric != that.pbfric) return false;
        if (pbfvc != that.pbfvc) return false;
        if (pbfwagc != that.pbfwagc) return false;
        if (pbhomec != that.pbhomec) return false;
        if (pbial1C != that.pbial1C) return false;
        if (pbial2C != that.pbial2C) return false;
        if (pbincac != that.pbincac) return false;
        if (pbincsuc != that.pbincsuc) return false;
        if (pbitxc != that.pbitxc) return false;
        if (pbmedac != that.pbmedac) return false;
        if (pbmwagc != that.pbmwagc) return false;
        if (pbntcsc != that.pbntcsc) return false;
        if (pbntic != that.pbntic) return false;
        if (pbnwrthc != that.pbnwrthc) return false;
        if (pbontic != that.pbontic) return false;
        if (pbotic != that.pbotic) return false;
        if (pbsmac != that.pbsmac) return false;
        if (pbssc != that.pbssc) return false;
        if (pbsttxc != that.pbsttxc) return false;
        if (pbtaloc != that.pbtaloc) return false;
        if (pbtic != that.pbtic) return false;
        if (pbttic != that.pbttic) return false;
        if (pbtuitac != that.pbtuitac) return false;
        if (pbtuitc != that.pbtuitc) return false;
        if (pcashc != that.pcashc) return false;
        if (pconfc != that.pconfc) return false;
        if (pconfnc != that.pconfnc) return false;
        if (pdassc != that.pdassc) return false;
        if (pdedc != that.pdedc) return false;
        if (pdivc != that.pdivc) return false;
        if (pdnetc != that.pdnetc) return false;
        if (pefincc != that.pefincc) return false;
        if (pemaloc != that.pemaloc) return false;
        if (pexcldc != that.pexcldc) return false;
        if (pfarmdc != that.pfarmdc) return false;
        if (pfarmec != that.pfarmec) return false;
        if (pfarmvc != that.pfarmvc) return false;
        if (pficac != that.pficac) return false;
        if (pfwagc != that.pfwagc) return false;
        if (phomcc != that.phomcc) return false;
        if (phomdc != that.phomdc) return false;
        if (phomec != that.phomec) return false;
        if (phompvc != that.phompvc) return false;
        if (phomvc != that.phomvc) return false;
        if (pialo1C != that.pialo1C) return false;
        if (pialo2C != that.pialo2C) return false;
        if (pinca1C != that.pinca1C) return false;
        if (pinca2C != that.pinca2C) return false;
        if (pinccrc != that.pinccrc) return false;
        if (pincsuc != that.pincsuc) return false;
        if (pintc != that.pintc) return false;
        if (pinvdc != that.pinvdc) return false;
        if (pinvec != that.pinvec) return false;
        if (pinvvc != that.pinvvc) return false;
        if (pitxcc != that.pitxcc) return false;
        if (pitxpc != that.pitxpc) return false;
        if (pitxvc != that.pitxvc) return false;
        if (pmedac != that.pmedac) return false;
        if (pmedc != that.pmedc) return false;
        if (pmwagc != that.pmwagc) return false;
        if (pntcsc != that.pntcsc) return false;
        if (pnwrthc != that.pnwrthc) return false;
        if (pontic != that.pontic) return false;
        if (pordc != that.pordc) return false;
        if (porec != that.porec) return false;
        if (porvc != that.porvc) return false;
        if (pothdc != that.pothdc) return false;
        if (potic != that.potic) return false;
        if (praavlic != that.praavlic) return false;
        if (psmac != that.psmac) return false;
        if (pssc != that.pssc) return false;
        if (psttxc != that.psttxc) return false;
        if (ptassc != that.ptassc) return false;
        if (ptconfc != that.ptconfc) return false;
        if (ptincc != that.ptincc) return false;
        if (ptntic != that.ptntic) return false;
        if (ptotaloc != that.ptotaloc) return false;
        if (pttincc != that.pttincc) return false;
        if (ptuitac != that.ptuitac) return false;
        if (ptuitc != that.ptuitc) return false;
        if (pwagc != that.pwagc) return false;
        if (sbasetc != that.sbasetc) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (pagec != null ? !pagec.equals(that.pagec) : that.pagec != null) return false;
        if (passcrc != null ? !passcrc.equals(that.passcrc) : that.passcrc != null) return false;
        if (pbasscrc != null ? !pbasscrc.equals(that.pbasscrc) : that.pbasscrc != null) return false;
        if (pcolac != null ? !pcolac.equals(that.pcolac) : that.pcolac != null) return false;
        if (pdishmc != null ? !pdishmc.equals(that.pdishmc) : that.pdishmc != null) return false;
        if (pdiswkc != null ? !pdiswkc.equals(that.pdiswkc) : that.pdiswkc != null) return false;
        if (pexempc != null ? !pexempc.equals(that.pexempc) : that.pexempc != null) return false;
        if (pfarmc != null ? !pfarmc.equals(that.pfarmc) : that.pfarmc != null) return false;
        if (phmyrcz != null ? !phmyrcz.equals(that.phmyrcz) : that.phmyrcz != null) return false;
        if (phomyrc != null ? !phomyrc.equals(that.phomyrc) : that.phomyrc != null) return false;
        if (phvplusc != null ? !phvplusc.equals(that.phvplusc) : that.phvplusc != null) return false;
        if (pincollc != null ? !pincollc.equals(that.pincollc) : that.pincollc != null) return false;
        if (pmaritlc != null ? !pmaritlc.equals(that.pmaritlc) : that.pmaritlc != null) return false;
        if (pnrpsc != null ? !pnrpsc.equals(that.pnrpsc) : that.pnrpsc != null) return false;
        if (pntuitc != null ? !pntuitc.equals(that.pntuitc) : that.pntuitc != null) return false;
        if (psizhhdc != null ? !psizhhdc.equals(that.psizhhdc) : that.psizhhdc != null) return false;
        if (ptrfilc != null ? !ptrfilc.equals(that.ptrfilc) : that.ptrfilc != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snpkey != null ? !snpkey.equals(that.snpkey) : that.snpkey != null) return false;
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
        result = 31 * result + (pmaritlc != null ? pmaritlc.hashCode() : 0);
        result = 31 * result + (pagec != null ? pagec.hashCode() : 0);
        result = 31 * result + (psizhhdc != null ? psizhhdc.hashCode() : 0);
        result = 31 * result + (pexempc != null ? pexempc.hashCode() : 0);
        result = 31 * result + (pnrpsc != null ? pnrpsc.hashCode() : 0);
        result = 31 * result + (pincollc != null ? pincollc.hashCode() : 0);
        result = 31 * result + (pdiswkc != null ? pdiswkc.hashCode() : 0);
        result = 31 * result + (pdishmc != null ? pdishmc.hashCode() : 0);
        result = 31 * result + (ptrfilc != null ? ptrfilc.hashCode() : 0);
        result = 31 * result + pfwagc;
        result = 31 * result + pmwagc;
        result = 31 * result + padjwc;
        result = 31 * result + pwagc;
        result = 31 * result + pintc;
        result = 31 * result + pdivc;
        result = 31 * result + pbfric;
        result = 31 * result + potic;
        result = 31 * result + pbexc;
        result = 31 * result + padjc;
        result = 31 * result + pttincc;
        result = 31 * result + pagirc;
        result = 31 * result + pssc;
        result = 31 * result + padcc;
        result = 31 * result + pntcsc;
        result = 31 * result + pontic;
        result = 31 * result + pinca1C;
        result = 31 * result + pinca2C;
        result = 31 * result + ptincc;
        result = 31 * result + pdedc;
        result = 31 * result + pitxpc;
        result = 31 * result + pitxcc;
        result = 31 * result + pitxvc;
        result = 31 * result + pficac;
        result = 31 * result + psttxc;
        result = 31 * result + pmedc;
        result = 31 * result + pmedac;
        result = 31 * result + ptuitc;
        result = 31 * result + (pntuitc != null ? pntuitc.hashCode() : 0);
        result = 31 * result + ptuitac;
        result = 31 * result + pemaloc;
        result = 31 * result + psmac;
        result = 31 * result + pialo1C;
        result = 31 * result + pialo2C;
        result = 31 * result + ptotaloc;
        result = 31 * result + pefincc;
        result = 31 * result + pcashc;
        result = 31 * result + pinvvc;
        result = 31 * result + pinvdc;
        result = 31 * result + pinvec;
        result = 31 * result + porvc;
        result = 31 * result + pordc;
        result = 31 * result + porec;
        result = 31 * result + pdassc;
        result = 31 * result + phompvc;
        result = 31 * result + phomcc;
        result = 31 * result + phomvc;
        result = 31 * result + phomdc;
        result = 31 * result + phomec;
        result = 31 * result + pfarmvc;
        result = 31 * result + pfarmdc;
        result = 31 * result + pfarmec;
        result = 31 * result + pbfvc;
        result = 31 * result + pbfdc;
        result = 31 * result + pbfec;
        result = 31 * result + (pfarmc != null ? pfarmc.hashCode() : 0);
        result = 31 * result + pabfwc;
        result = 31 * result + passadjc;
        result = 31 * result + ptassc;
        result = 31 * result + pothdc;
        result = 31 * result + pnwrthc;
        result = 31 * result + papac;
        result = 31 * result + pdnetc;
        result = 31 * result + (passcrc != null ? passcrc.hashCode() : 0);
        result = 31 * result + pincsuc;
        result = 31 * result + paavlic;
        result = 31 * result + (pcolac != null ? pcolac.hashCode() : 0);
        result = 31 * result + praavlic;
        result = 31 * result + ptconfc;
        result = 31 * result + pconfnc;
        result = 31 * result + pconfc;
        result = 31 * result + pbfwagc;
        result = 31 * result + pbmwagc;
        result = 31 * result + pbotic;
        result = 31 * result + pbttic;
        result = 31 * result + pbagirc;
        result = 31 * result + pbssc;
        result = 31 * result + pbadcc;
        result = 31 * result + pbntcsc;
        result = 31 * result + pbontic;
        result = 31 * result + pbincac;
        result = 31 * result + pbntic;
        result = 31 * result + pbtic;
        result = 31 * result + pbitxc;
        result = 31 * result + pbficac;
        result = 31 * result + pbsttxc;
        result = 31 * result + pbmedac;
        result = 31 * result + pbtuitc;
        result = 31 * result + pbemalc;
        result = 31 * result + pbsmac;
        result = 31 * result + pbial1C;
        result = 31 * result + pbial2C;
        result = 31 * result + pbtaloc;
        result = 31 * result + pbefinc;
        result = 31 * result + ptntic;
        result = 31 * result + pbtuitac;
        result = 31 * result + pbnwrthc;
        result = 31 * result + pbapac;
        result = 31 * result + pbdnetc;
        result = 31 * result + (pbasscrc != null ? pbasscrc.hashCode() : 0);
        result = 31 * result + pbincsuc;
        result = 31 * result + pbaavlic;
        result = 31 * result + pbhomec;
        result = 31 * result + pbabfwc;
        result = 31 * result + pbconfc;
        result = 31 * result + pexcldc;
        result = 31 * result + (phvplusc != null ? phvplusc.hashCode() : 0);
        result = 31 * result + pinccrc;
        result = 31 * result + (phmyrcz != null ? phmyrcz.hashCode() : 0);
        result = 31 * result + (phomyrc != null ? phomyrc.hashCode() : 0);
        result = 31 * result + sbasetc;
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        return result;
    }
}
