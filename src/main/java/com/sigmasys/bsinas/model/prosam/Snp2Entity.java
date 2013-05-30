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
 * Time: 12:08 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SNP2", schema = "SIGMA", catalog = "")
@Entity
public class Snp2Entity implements Identifiable {

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

    private String pmartl2;

    @javax.persistence.Column(name = "PMARTL2")
    @Basic
    public String getPmartl2() {
        return pmartl2;
    }

    public void setPmartl2(String pmartl2) {
        this.pmartl2 = pmartl2;
    }

    private String pfedlvl2;

    @javax.persistence.Column(name = "PFEDLVL2")
    @Basic
    public String getPfedlvl2() {
        return pfedlvl2;
    }

    public void setPfedlvl2(String pfedlvl2) {
        this.pfedlvl2 = pfedlvl2;
    }

    private String pmedlvl2;

    @javax.persistence.Column(name = "PMEDLVL2")
    @Basic
    public String getPmedlvl2() {
        return pmedlvl2;
    }

    public void setPmedlvl2(String pmedlvl2) {
        this.pmedlvl2 = pmedlvl2;
    }

    private BigInteger page2;

    @javax.persistence.Column(name = "PAGE2")
    @Basic
    public BigInteger getPage2() {
        return page2;
    }

    public void setPage2(BigInteger page2) {
        this.page2 = page2;
    }

    private BigInteger pszhhd2;

    @javax.persistence.Column(name = "PSZHHD2")
    @Basic
    public BigInteger getPszhhd2() {
        return pszhhd2;
    }

    public void setPszhhd2(BigInteger pszhhd2) {
        this.pszhhd2 = pszhhd2;
    }

    private BigInteger pexemp2;

    @javax.persistence.Column(name = "PEXEMP2")
    @Basic
    public BigInteger getPexemp2() {
        return pexemp2;
    }

    public void setPexemp2(BigInteger pexemp2) {
        this.pexemp2 = pexemp2;
    }

    private BigInteger pnrps2;

    @javax.persistence.Column(name = "PNRPS2")
    @Basic
    public BigInteger getPnrps2() {
        return pnrps2;
    }

    public void setPnrps2(BigInteger pnrps2) {
        this.pnrps2 = pnrps2;
    }

    private BigInteger pincol2;

    @javax.persistence.Column(name = "PINCOL2")
    @Basic
    public BigInteger getPincol2() {
        return pincol2;
    }

    public void setPincol2(BigInteger pincol2) {
        this.pincol2 = pincol2;
    }

    private String pdiswk2;

    @javax.persistence.Column(name = "PDISWK2")
    @Basic
    public String getPdiswk2() {
        return pdiswk2;
    }

    public void setPdiswk2(String pdiswk2) {
        this.pdiswk2 = pdiswk2;
    }

    private String pdishm2;

    @javax.persistence.Column(name = "PDISHM2")
    @Basic
    public String getPdishm2() {
        return pdishm2;
    }

    public void setPdishm2(String pdishm2) {
        this.pdishm2 = pdishm2;
    }

    private String ptrfil2;

    @javax.persistence.Column(name = "PTRFIL2")
    @Basic
    public String getPtrfil2() {
        return ptrfil2;
    }

    public void setPtrfil2(String ptrfil2) {
        this.ptrfil2 = ptrfil2;
    }

    private int pfwag2;

    @javax.persistence.Column(name = "PFWAG2")
    @Basic
    public int getPfwag2() {
        return pfwag2;
    }

    public void setPfwag2(int pfwag2) {
        this.pfwag2 = pfwag2;
    }

    private int pmwag2;

    @javax.persistence.Column(name = "PMWAG2")
    @Basic
    public int getPmwag2() {
        return pmwag2;
    }

    public void setPmwag2(int pmwag2) {
        this.pmwag2 = pmwag2;
    }

    private int padjw2;

    @javax.persistence.Column(name = "PADJW2")
    @Basic
    public int getPadjw2() {
        return padjw2;
    }

    public void setPadjw2(int padjw2) {
        this.padjw2 = padjw2;
    }

    private int pwag2;

    @javax.persistence.Column(name = "PWAG2")
    @Basic
    public int getPwag2() {
        return pwag2;
    }

    public void setPwag2(int pwag2) {
        this.pwag2 = pwag2;
    }

    private int pint2;

    @javax.persistence.Column(name = "PINT2")
    @Basic
    public int getPint2() {
        return pint2;
    }

    public void setPint2(int pint2) {
        this.pint2 = pint2;
    }

    private int pdiv2;

    @javax.persistence.Column(name = "PDIV2")
    @Basic
    public int getPdiv2() {
        return pdiv2;
    }

    public void setPdiv2(int pdiv2) {
        this.pdiv2 = pdiv2;
    }

    private int pbfri2;

    @javax.persistence.Column(name = "PBFRI2")
    @Basic
    public int getPbfri2() {
        return pbfri2;
    }

    public void setPbfri2(int pbfri2) {
        this.pbfri2 = pbfri2;
    }

    private int poti2;

    @javax.persistence.Column(name = "POTI2")
    @Basic
    public int getPoti2() {
        return poti2;
    }

    public void setPoti2(int poti2) {
        this.poti2 = poti2;
    }

    private int pbex2;

    @javax.persistence.Column(name = "PBEX2")
    @Basic
    public int getPbex2() {
        return pbex2;
    }

    public void setPbex2(int pbex2) {
        this.pbex2 = pbex2;
    }

    private int padj2;

    @javax.persistence.Column(name = "PADJ2")
    @Basic
    public int getPadj2() {
        return padj2;
    }

    public void setPadj2(int padj2) {
        this.padj2 = padj2;
    }

    private int pttinc2;

    @javax.persistence.Column(name = "PTTINC2")
    @Basic
    public int getPttinc2() {
        return pttinc2;
    }

    public void setPttinc2(int pttinc2) {
        this.pttinc2 = pttinc2;
    }

    private int pagir2;

    @javax.persistence.Column(name = "PAGIR2")
    @Basic
    public int getPagir2() {
        return pagir2;
    }

    public void setPagir2(int pagir2) {
        this.pagir2 = pagir2;
    }

    private int pss2;

    @javax.persistence.Column(name = "PSS2")
    @Basic
    public int getPss2() {
        return pss2;
    }

    public void setPss2(int pss2) {
        this.pss2 = pss2;
    }

    private int padc2;

    @javax.persistence.Column(name = "PADC2")
    @Basic
    public int getPadc2() {
        return padc2;
    }

    public void setPadc2(int padc2) {
        this.padc2 = padc2;
    }

    private int pntcs2;

    @javax.persistence.Column(name = "PNTCS2")
    @Basic
    public int getPntcs2() {
        return pntcs2;
    }

    public void setPntcs2(int pntcs2) {
        this.pntcs2 = pntcs2;
    }

    private int ponti2;

    @javax.persistence.Column(name = "PONTI2")
    @Basic
    public int getPonti2() {
        return ponti2;
    }

    public void setPonti2(int ponti2) {
        this.ponti2 = ponti2;
    }

    private int pinca12;

    @javax.persistence.Column(name = "PINCA12")
    @Basic
    public int getPinca12() {
        return pinca12;
    }

    public void setPinca12(int pinca12) {
        this.pinca12 = pinca12;
    }

    private int pinca22;

    @javax.persistence.Column(name = "PINCA22")
    @Basic
    public int getPinca22() {
        return pinca22;
    }

    public void setPinca22(int pinca22) {
        this.pinca22 = pinca22;
    }

    private int ptinc2;

    @javax.persistence.Column(name = "PTINC2")
    @Basic
    public int getPtinc2() {
        return ptinc2;
    }

    public void setPtinc2(int ptinc2) {
        this.ptinc2 = ptinc2;
    }

    private int pded2;

    @javax.persistence.Column(name = "PDED2")
    @Basic
    public int getPded2() {
        return pded2;
    }

    public void setPded2(int pded2) {
        this.pded2 = pded2;
    }

    private int pitxp2;

    @javax.persistence.Column(name = "PITXP2")
    @Basic
    public int getPitxp2() {
        return pitxp2;
    }

    public void setPitxp2(int pitxp2) {
        this.pitxp2 = pitxp2;
    }

    private int pitxc2;

    @javax.persistence.Column(name = "PITXC2")
    @Basic
    public int getPitxc2() {
        return pitxc2;
    }

    public void setPitxc2(int pitxc2) {
        this.pitxc2 = pitxc2;
    }

    private int pitx2;

    @javax.persistence.Column(name = "PITX2")
    @Basic
    public int getPitx2() {
        return pitx2;
    }

    public void setPitx2(int pitx2) {
        this.pitx2 = pitx2;
    }

    private int pfica2;

    @javax.persistence.Column(name = "PFICA2")
    @Basic
    public int getPfica2() {
        return pfica2;
    }

    public void setPfica2(int pfica2) {
        this.pfica2 = pfica2;
    }

    private int psttx2;

    @javax.persistence.Column(name = "PSTTX2")
    @Basic
    public int getPsttx2() {
        return psttx2;
    }

    public void setPsttx2(int psttx2) {
        this.psttx2 = psttx2;
    }

    private int pmed2;

    @javax.persistence.Column(name = "PMED2")
    @Basic
    public int getPmed2() {
        return pmed2;
    }

    public void setPmed2(int pmed2) {
        this.pmed2 = pmed2;
    }

    private int pmeda2;

    @javax.persistence.Column(name = "PMEDA2")
    @Basic
    public int getPmeda2() {
        return pmeda2;
    }

    public void setPmeda2(int pmeda2) {
        this.pmeda2 = pmeda2;
    }

    private int ptuit2;

    @javax.persistence.Column(name = "PTUIT2")
    @Basic
    public int getPtuit2() {
        return ptuit2;
    }

    public void setPtuit2(int ptuit2) {
        this.ptuit2 = ptuit2;
    }

    private BigInteger pntuit2;

    @javax.persistence.Column(name = "PNTUIT2")
    @Basic
    public BigInteger getPntuit2() {
        return pntuit2;
    }

    public void setPntuit2(BigInteger pntuit2) {
        this.pntuit2 = pntuit2;
    }

    private int ptuita2;

    @javax.persistence.Column(name = "PTUITA2")
    @Basic
    public int getPtuita2() {
        return ptuita2;
    }

    public void setPtuita2(int ptuita2) {
        this.ptuita2 = ptuita2;
    }

    private int pemalo2;

    @javax.persistence.Column(name = "PEMALO2")
    @Basic
    public int getPemalo2() {
        return pemalo2;
    }

    public void setPemalo2(int pemalo2) {
        this.pemalo2 = pemalo2;
    }

    private int psma2;

    @javax.persistence.Column(name = "PSMA2")
    @Basic
    public int getPsma2() {
        return psma2;
    }

    public void setPsma2(int psma2) {
        this.psma2 = psma2;
    }

    private int pialo12;

    @javax.persistence.Column(name = "PIALO12")
    @Basic
    public int getPialo12() {
        return pialo12;
    }

    public void setPialo12(int pialo12) {
        this.pialo12 = pialo12;
    }

    private int pialo22;

    @javax.persistence.Column(name = "PIALO22")
    @Basic
    public int getPialo22() {
        return pialo22;
    }

    public void setPialo22(int pialo22) {
        this.pialo22 = pialo22;
    }

    private int ptotal2;

    @javax.persistence.Column(name = "PTOTAL2")
    @Basic
    public int getPtotal2() {
        return ptotal2;
    }

    public void setPtotal2(int ptotal2) {
        this.ptotal2 = ptotal2;
    }

    private int pefinc2;

    @javax.persistence.Column(name = "PEFINC2")
    @Basic
    public int getPefinc2() {
        return pefinc2;
    }

    public void setPefinc2(int pefinc2) {
        this.pefinc2 = pefinc2;
    }

    private int pcash2;

    @javax.persistence.Column(name = "PCASH2")
    @Basic
    public int getPcash2() {
        return pcash2;
    }

    public void setPcash2(int pcash2) {
        this.pcash2 = pcash2;
    }

    private int pinvv2;

    @javax.persistence.Column(name = "PINVV2")
    @Basic
    public int getPinvv2() {
        return pinvv2;
    }

    public void setPinvv2(int pinvv2) {
        this.pinvv2 = pinvv2;
    }

    private int pinvd2;

    @javax.persistence.Column(name = "PINVD2")
    @Basic
    public int getPinvd2() {
        return pinvd2;
    }

    public void setPinvd2(int pinvd2) {
        this.pinvd2 = pinvd2;
    }

    private int pinve2;

    @javax.persistence.Column(name = "PINVE2")
    @Basic
    public int getPinve2() {
        return pinve2;
    }

    public void setPinve2(int pinve2) {
        this.pinve2 = pinve2;
    }

    private int porv2;

    @javax.persistence.Column(name = "PORV2")
    @Basic
    public int getPorv2() {
        return porv2;
    }

    public void setPorv2(int porv2) {
        this.porv2 = porv2;
    }

    private int pord2;

    @javax.persistence.Column(name = "PORD2")
    @Basic
    public int getPord2() {
        return pord2;
    }

    public void setPord2(int pord2) {
        this.pord2 = pord2;
    }

    private int pore2;

    @javax.persistence.Column(name = "PORE2")
    @Basic
    public int getPore2() {
        return pore2;
    }

    public void setPore2(int pore2) {
        this.pore2 = pore2;
    }

    private int pdass2;

    @javax.persistence.Column(name = "PDASS2")
    @Basic
    public int getPdass2() {
        return pdass2;
    }

    public void setPdass2(int pdass2) {
        this.pdass2 = pdass2;
    }

    private int phompv2;

    @javax.persistence.Column(name = "PHOMPV2")
    @Basic
    public int getPhompv2() {
        return phompv2;
    }

    public void setPhompv2(int phompv2) {
        this.phompv2 = phompv2;
    }

    private int phomc2;

    @javax.persistence.Column(name = "PHOMC2")
    @Basic
    public int getPhomc2() {
        return phomc2;
    }

    public void setPhomc2(int phomc2) {
        this.phomc2 = phomc2;
    }

    private int phomv2;

    @javax.persistence.Column(name = "PHOMV2")
    @Basic
    public int getPhomv2() {
        return phomv2;
    }

    public void setPhomv2(int phomv2) {
        this.phomv2 = phomv2;
    }

    private int phomd2;

    @javax.persistence.Column(name = "PHOMD2")
    @Basic
    public int getPhomd2() {
        return phomd2;
    }

    public void setPhomd2(int phomd2) {
        this.phomd2 = phomd2;
    }

    private int phome2;

    @javax.persistence.Column(name = "PHOME2")
    @Basic
    public int getPhome2() {
        return phome2;
    }

    public void setPhome2(int phome2) {
        this.phome2 = phome2;
    }

    private int pfarmv2;

    @javax.persistence.Column(name = "PFARMV2")
    @Basic
    public int getPfarmv2() {
        return pfarmv2;
    }

    public void setPfarmv2(int pfarmv2) {
        this.pfarmv2 = pfarmv2;
    }

    private int pfarmd2;

    @javax.persistence.Column(name = "PFARMD2")
    @Basic
    public int getPfarmd2() {
        return pfarmd2;
    }

    public void setPfarmd2(int pfarmd2) {
        this.pfarmd2 = pfarmd2;
    }

    private int pfarme2;

    @javax.persistence.Column(name = "PFARME2")
    @Basic
    public int getPfarme2() {
        return pfarme2;
    }

    public void setPfarme2(int pfarme2) {
        this.pfarme2 = pfarme2;
    }

    private int pbfv2;

    @javax.persistence.Column(name = "PBFV2")
    @Basic
    public int getPbfv2() {
        return pbfv2;
    }

    public void setPbfv2(int pbfv2) {
        this.pbfv2 = pbfv2;
    }

    private int pbfd2;

    @javax.persistence.Column(name = "PBFD2")
    @Basic
    public int getPbfd2() {
        return pbfd2;
    }

    public void setPbfd2(int pbfd2) {
        this.pbfd2 = pbfd2;
    }

    private int pbfe2;

    @javax.persistence.Column(name = "PBFE2")
    @Basic
    public int getPbfe2() {
        return pbfe2;
    }

    public void setPbfe2(int pbfe2) {
        this.pbfe2 = pbfe2;
    }

    private String pfarm2;

    @javax.persistence.Column(name = "PFARM2")
    @Basic
    public String getPfarm2() {
        return pfarm2;
    }

    public void setPfarm2(String pfarm2) {
        this.pfarm2 = pfarm2;
    }

    private int pabfw2;

    @javax.persistence.Column(name = "PABFW2")
    @Basic
    public int getPabfw2() {
        return pabfw2;
    }

    public void setPabfw2(int pabfw2) {
        this.pabfw2 = pabfw2;
    }

    private int passad2;

    @javax.persistence.Column(name = "PASSAD2")
    @Basic
    public int getPassad2() {
        return passad2;
    }

    public void setPassad2(int passad2) {
        this.passad2 = passad2;
    }

    private int ptass2;

    @javax.persistence.Column(name = "PTASS2")
    @Basic
    public int getPtass2() {
        return ptass2;
    }

    public void setPtass2(int ptass2) {
        this.ptass2 = ptass2;
    }

    private int pothd2;

    @javax.persistence.Column(name = "POTHD2")
    @Basic
    public int getPothd2() {
        return pothd2;
    }

    public void setPothd2(int pothd2) {
        this.pothd2 = pothd2;
    }

    private int pnwrth2;

    @javax.persistence.Column(name = "PNWRTH2")
    @Basic
    public int getPnwrth2() {
        return pnwrth2;
    }

    public void setPnwrth2(int pnwrth2) {
        this.pnwrth2 = pnwrth2;
    }

    private int papa2;

    @javax.persistence.Column(name = "PAPA2")
    @Basic
    public int getPapa2() {
        return papa2;
    }

    public void setPapa2(int papa2) {
        this.papa2 = papa2;
    }

    private int pdnet2;

    @javax.persistence.Column(name = "PDNET2")
    @Basic
    public int getPdnet2() {
        return pdnet2;
    }

    public void setPdnet2(int pdnet2) {
        this.pdnet2 = pdnet2;
    }

    private BigDecimal passcr2;

    @javax.persistence.Column(name = "PASSCR2")
    @Basic
    public BigDecimal getPasscr2() {
        return passcr2;
    }

    public void setPasscr2(BigDecimal passcr2) {
        this.passcr2 = passcr2;
    }

    private int pincsu2;

    @javax.persistence.Column(name = "PINCSU2")
    @Basic
    public int getPincsu2() {
        return pincsu2;
    }

    public void setPincsu2(int pincsu2) {
        this.pincsu2 = pincsu2;
    }

    private int paavli2;

    @javax.persistence.Column(name = "PAAVLI2")
    @Basic
    public int getPaavli2() {
        return paavli2;
    }

    public void setPaavli2(int paavli2) {
        this.paavli2 = paavli2;
    }

    private BigDecimal pcola2;

    @javax.persistence.Column(name = "PCOLA2")
    @Basic
    public BigDecimal getPcola2() {
        return pcola2;
    }

    public void setPcola2(BigDecimal pcola2) {
        this.pcola2 = pcola2;
    }

    private int pravli2;

    @javax.persistence.Column(name = "PRAVLI2")
    @Basic
    public int getPravli2() {
        return pravli2;
    }

    public void setPravli2(int pravli2) {
        this.pravli2 = pravli2;
    }

    private int ptconf2;

    @javax.persistence.Column(name = "PTCONF2")
    @Basic
    public int getPtconf2() {
        return ptconf2;
    }

    public void setPtconf2(int ptconf2) {
        this.ptconf2 = ptconf2;
    }

    private int pconfn2;

    @javax.persistence.Column(name = "PCONFN2")
    @Basic
    public int getPconfn2() {
        return pconfn2;
    }

    public void setPconfn2(int pconfn2) {
        this.pconfn2 = pconfn2;
    }

    private int pconf2;

    @javax.persistence.Column(name = "PCONF2")
    @Basic
    public int getPconf2() {
        return pconf2;
    }

    public void setPconf2(int pconf2) {
        this.pconf2 = pconf2;
    }

    private int pbfwag2;

    @javax.persistence.Column(name = "PBFWAG2")
    @Basic
    public int getPbfwag2() {
        return pbfwag2;
    }

    public void setPbfwag2(int pbfwag2) {
        this.pbfwag2 = pbfwag2;
    }

    private int pbmwag2;

    @javax.persistence.Column(name = "PBMWAG2")
    @Basic
    public int getPbmwag2() {
        return pbmwag2;
    }

    public void setPbmwag2(int pbmwag2) {
        this.pbmwag2 = pbmwag2;
    }

    private int pboti2;

    @javax.persistence.Column(name = "PBOTI2")
    @Basic
    public int getPboti2() {
        return pboti2;
    }

    public void setPboti2(int pboti2) {
        this.pboti2 = pboti2;
    }

    private int pbtti2;

    @javax.persistence.Column(name = "PBTTI2")
    @Basic
    public int getPbtti2() {
        return pbtti2;
    }

    public void setPbtti2(int pbtti2) {
        this.pbtti2 = pbtti2;
    }

    private int pbagir2;

    @javax.persistence.Column(name = "PBAGIR2")
    @Basic
    public int getPbagir2() {
        return pbagir2;
    }

    public void setPbagir2(int pbagir2) {
        this.pbagir2 = pbagir2;
    }

    private int pbss2;

    @javax.persistence.Column(name = "PBSS2")
    @Basic
    public int getPbss2() {
        return pbss2;
    }

    public void setPbss2(int pbss2) {
        this.pbss2 = pbss2;
    }

    private int pbadc2;

    @javax.persistence.Column(name = "PBADC2")
    @Basic
    public int getPbadc2() {
        return pbadc2;
    }

    public void setPbadc2(int pbadc2) {
        this.pbadc2 = pbadc2;
    }

    private int pbntcs2;

    @javax.persistence.Column(name = "PBNTCS2")
    @Basic
    public int getPbntcs2() {
        return pbntcs2;
    }

    public void setPbntcs2(int pbntcs2) {
        this.pbntcs2 = pbntcs2;
    }

    private int pbonti2;

    @javax.persistence.Column(name = "PBONTI2")
    @Basic
    public int getPbonti2() {
        return pbonti2;
    }

    public void setPbonti2(int pbonti2) {
        this.pbonti2 = pbonti2;
    }

    private int pbinca2;

    @javax.persistence.Column(name = "PBINCA2")
    @Basic
    public int getPbinca2() {
        return pbinca2;
    }

    public void setPbinca2(int pbinca2) {
        this.pbinca2 = pbinca2;
    }

    private int pbnti2;

    @javax.persistence.Column(name = "PBNTI2")
    @Basic
    public int getPbnti2() {
        return pbnti2;
    }

    public void setPbnti2(int pbnti2) {
        this.pbnti2 = pbnti2;
    }

    private int pbti2;

    @javax.persistence.Column(name = "PBTI2")
    @Basic
    public int getPbti2() {
        return pbti2;
    }

    public void setPbti2(int pbti2) {
        this.pbti2 = pbti2;
    }

    private int pbitx2;

    @javax.persistence.Column(name = "PBITX2")
    @Basic
    public int getPbitx2() {
        return pbitx2;
    }

    public void setPbitx2(int pbitx2) {
        this.pbitx2 = pbitx2;
    }

    private int pbfica2;

    @javax.persistence.Column(name = "PBFICA2")
    @Basic
    public int getPbfica2() {
        return pbfica2;
    }

    public void setPbfica2(int pbfica2) {
        this.pbfica2 = pbfica2;
    }

    private int pbsttx2;

    @javax.persistence.Column(name = "PBSTTX2")
    @Basic
    public int getPbsttx2() {
        return pbsttx2;
    }

    public void setPbsttx2(int pbsttx2) {
        this.pbsttx2 = pbsttx2;
    }

    private int pbmeda2;

    @javax.persistence.Column(name = "PBMEDA2")
    @Basic
    public int getPbmeda2() {
        return pbmeda2;
    }

    public void setPbmeda2(int pbmeda2) {
        this.pbmeda2 = pbmeda2;
    }

    private int pbtuit2;

    @javax.persistence.Column(name = "PBTUIT2")
    @Basic
    public int getPbtuit2() {
        return pbtuit2;
    }

    public void setPbtuit2(int pbtuit2) {
        this.pbtuit2 = pbtuit2;
    }

    private int pbemal2;

    @javax.persistence.Column(name = "PBEMAL2")
    @Basic
    public int getPbemal2() {
        return pbemal2;
    }

    public void setPbemal2(int pbemal2) {
        this.pbemal2 = pbemal2;
    }

    private int pbsma2;

    @javax.persistence.Column(name = "PBSMA2")
    @Basic
    public int getPbsma2() {
        return pbsma2;
    }

    public void setPbsma2(int pbsma2) {
        this.pbsma2 = pbsma2;
    }

    private int pbial12;

    @javax.persistence.Column(name = "PBIAL12")
    @Basic
    public int getPbial12() {
        return pbial12;
    }

    public void setPbial12(int pbial12) {
        this.pbial12 = pbial12;
    }

    private int pbial22;

    @javax.persistence.Column(name = "PBIAL22")
    @Basic
    public int getPbial22() {
        return pbial22;
    }

    public void setPbial22(int pbial22) {
        this.pbial22 = pbial22;
    }

    private int pbtalo2;

    @javax.persistence.Column(name = "PBTALO2")
    @Basic
    public int getPbtalo2() {
        return pbtalo2;
    }

    public void setPbtalo2(int pbtalo2) {
        this.pbtalo2 = pbtalo2;
    }

    private int pbefin2;

    @javax.persistence.Column(name = "PBEFIN2")
    @Basic
    public int getPbefin2() {
        return pbefin2;
    }

    public void setPbefin2(int pbefin2) {
        this.pbefin2 = pbefin2;
    }

    private int ptnti2;

    @javax.persistence.Column(name = "PTNTI2")
    @Basic
    public int getPtnti2() {
        return ptnti2;
    }

    public void setPtnti2(int ptnti2) {
        this.ptnti2 = ptnti2;
    }

    private int pbtuita2;

    @javax.persistence.Column(name = "PBTUITA2")
    @Basic
    public int getPbtuita2() {
        return pbtuita2;
    }

    public void setPbtuita2(int pbtuita2) {
        this.pbtuita2 = pbtuita2;
    }

    private int pbnwrth2;

    @javax.persistence.Column(name = "PBNWRTH2")
    @Basic
    public int getPbnwrth2() {
        return pbnwrth2;
    }

    public void setPbnwrth2(int pbnwrth2) {
        this.pbnwrth2 = pbnwrth2;
    }

    private int pbapa2;

    @javax.persistence.Column(name = "PBAPA2")
    @Basic
    public int getPbapa2() {
        return pbapa2;
    }

    public void setPbapa2(int pbapa2) {
        this.pbapa2 = pbapa2;
    }

    private int pbdnet2;

    @javax.persistence.Column(name = "PBDNET2")
    @Basic
    public int getPbdnet2() {
        return pbdnet2;
    }

    public void setPbdnet2(int pbdnet2) {
        this.pbdnet2 = pbdnet2;
    }

    private BigDecimal pbasscr2;

    @javax.persistence.Column(name = "PBASSCR2")
    @Basic
    public BigDecimal getPbasscr2() {
        return pbasscr2;
    }

    public void setPbasscr2(BigDecimal pbasscr2) {
        this.pbasscr2 = pbasscr2;
    }

    private int pbincsu2;

    @javax.persistence.Column(name = "PBINCSU2")
    @Basic
    public int getPbincsu2() {
        return pbincsu2;
    }

    public void setPbincsu2(int pbincsu2) {
        this.pbincsu2 = pbincsu2;
    }

    private int pbaavli2;

    @javax.persistence.Column(name = "PBAAVLI2")
    @Basic
    public int getPbaavli2() {
        return pbaavli2;
    }

    public void setPbaavli2(int pbaavli2) {
        this.pbaavli2 = pbaavli2;
    }

    private int pbhome2;

    @javax.persistence.Column(name = "PBHOME2")
    @Basic
    public int getPbhome2() {
        return pbhome2;
    }

    public void setPbhome2(int pbhome2) {
        this.pbhome2 = pbhome2;
    }

    private int pbabfw2;

    @javax.persistence.Column(name = "PBABFW2")
    @Basic
    public int getPbabfw2() {
        return pbabfw2;
    }

    public void setPbabfw2(int pbabfw2) {
        this.pbabfw2 = pbabfw2;
    }

    private int pbconf2;

    @javax.persistence.Column(name = "PBCONF2")
    @Basic
    public int getPbconf2() {
        return pbconf2;
    }

    public void setPbconf2(int pbconf2) {
        this.pbconf2 = pbconf2;
    }

    private int pexcld2;

    @javax.persistence.Column(name = "PEXCLD2")
    @Basic
    public int getPexcld2() {
        return pexcld2;
    }

    public void setPexcld2(int pexcld2) {
        this.pexcld2 = pexcld2;
    }

    private String phvplus2;

    @javax.persistence.Column(name = "PHVPLUS2")
    @Basic
    public String getPhvplus2() {
        return phvplus2;
    }

    public void setPhvplus2(String phvplus2) {
        this.phvplus2 = phvplus2;
    }

    private int apexcld2;

    @javax.persistence.Column(name = "APEXCLD2")
    @Basic
    public int getApexcld2() {
        return apexcld2;
    }

    public void setApexcld2(int apexcld2) {
        this.apexcld2 = apexcld2;
    }

    private int pinccr2;

    @javax.persistence.Column(name = "PINCCR2")
    @Basic
    public int getPinccr2() {
        return pinccr2;
    }

    public void setPinccr2(int pinccr2) {
        this.pinccr2 = pinccr2;
    }

    private int apinccr2;

    @javax.persistence.Column(name = "APINCCR2")
    @Basic
    public int getApinccr2() {
        return apinccr2;
    }

    public void setApinccr2(int apinccr2) {
        this.apinccr2 = apinccr2;
    }

    private int aponti2;

    @javax.persistence.Column(name = "APONTI2")
    @Basic
    public int getAponti2() {
        return aponti2;
    }

    public void setAponti2(int aponti2) {
        this.aponti2 = aponti2;
    }

    private int apadc2;

    @javax.persistence.Column(name = "APADC2")
    @Basic
    public int getApadc2() {
        return apadc2;
    }

    public void setApadc2(int apadc2) {
        this.apadc2 = apadc2;
    }

    private int apntcs2;

    @javax.persistence.Column(name = "APNTCS2")
    @Basic
    public int getApntcs2() {
        return apntcs2;
    }

    public void setApntcs2(int apntcs2) {
        this.apntcs2 = apntcs2;
    }

    private BigInteger phmyr2Z;

    @javax.persistence.Column(name = "PHMYR2Z")
    @Basic
    public BigInteger getPhmyr2Z() {
        return phmyr2Z;
    }

    public void setPhmyr2Z(BigInteger phmyr2Z) {
        this.phmyr2Z = phmyr2Z;
    }

    private BigInteger phomyr2;

    @javax.persistence.Column(name = "PHOMYR2")
    @Basic
    public BigInteger getPhomyr2() {
        return phomyr2;
    }

    public void setPhomyr2(BigInteger phomyr2) {
        this.phomyr2 = phomyr2;
    }

    private int sbaset2;

    @javax.persistence.Column(name = "SBASET2")
    @Basic
    public int getSbaset2() {
        return sbaset2;
    }

    public void setSbaset2(int sbaset2) {
        this.sbaset2 = sbaset2;
    }

    private String pfilrtn2;

    @javax.persistence.Column(name = "PFILRTN2")
    @Basic
    public String getPfilrtn2() {
        return pfilrtn2;
    }

    public void setPfilrtn2(String pfilrtn2) {
        this.pfilrtn2 = pfilrtn2;
    }

    private String pelgfil2;

    @javax.persistence.Column(name = "PELGFIL2")
    @Basic
    public String getPelgfil2() {
        return pelgfil2;
    }

    public void setPelgfil2(String pelgfil2) {
        this.pelgfil2 = pelgfil2;
    }

    private String presbfr2;

    @javax.persistence.Column(name = "PRESBFR2")
    @Basic
    public String getPresbfr2() {
        return presbfr2;
    }

    public void setPresbfr2(String presbfr2) {
        this.presbfr2 = presbfr2;
    }

    private String namefl2;

    @javax.persistence.Column(name = "NAMEFL2")
    @Basic
    public String getNamefl2() {
        return namefl2;
    }

    public void setNamefl2(String namefl2) {
        this.namefl2 = namefl2;
    }

    private String ssnfat2;

    @javax.persistence.Column(name = "SSNFAT2")
    @Basic
    public String getSsnfat2() {
        return ssnfat2;
    }

    public void setSsnfat2(String ssnfat2) {
        this.ssnfat2 = ssnfat2;
    }

    private String nameml2;

    @javax.persistence.Column(name = "NAMEML2")
    @Basic
    public String getNameml2() {
        return nameml2;
    }

    public void setNameml2(String nameml2) {
        this.nameml2 = nameml2;
    }

    private String ssnmot2;

    @javax.persistence.Column(name = "SSNMOT2")
    @Basic
    public String getSsnmot2() {
        return ssnmot2;
    }

    public void setSsnmot2(String ssnmot2) {
        this.ssnmot2 = ssnmot2;
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

    private String grdlvl12;

    @javax.persistence.Column(name = "GRDLVL12")
    @Basic
    public String getGrdlvl12() {
        return grdlvl12;
    }

    public void setGrdlvl12(String grdlvl12) {
        this.grdlvl12 = grdlvl12;
    }

    private String grdlvl22;

    @javax.persistence.Column(name = "GRDLVL22")
    @Basic
    public String getGrdlvl22() {
        return grdlvl22;
    }

    public void setGrdlvl22(String grdlvl22) {
        this.grdlvl22 = grdlvl22;
    }

    private String grdlvl32;

    @javax.persistence.Column(name = "GRDLVL32")
    @Basic
    public String getGrdlvl32() {
        return grdlvl32;
    }

    public void setGrdlvl32(String grdlvl32) {
        this.grdlvl32 = grdlvl32;
    }

    private String grdlvl42;

    @javax.persistence.Column(name = "GRDLVL42")
    @Basic
    public String getGrdlvl42() {
        return grdlvl42;
    }

    public void setGrdlvl42(String grdlvl42) {
        this.grdlvl42 = grdlvl42;
    }

    private String grdlvl52;

    @javax.persistence.Column(name = "GRDLVL52")
    @Basic
    public String getGrdlvl52() {
        return grdlvl52;
    }

    public void setGrdlvl52(String grdlvl52) {
        this.grdlvl52 = grdlvl52;
    }

    private String grdlvl62;

    @javax.persistence.Column(name = "GRDLVL62")
    @Basic
    public String getGrdlvl62() {
        return grdlvl62;
    }

    public void setGrdlvl62(String grdlvl62) {
        this.grdlvl62 = grdlvl62;
    }

    private String grdlvl72;

    @javax.persistence.Column(name = "GRDLVL72")
    @Basic
    public String getGrdlvl72() {
        return grdlvl72;
    }

    public void setGrdlvl72(String grdlvl72) {
        this.grdlvl72 = grdlvl72;
    }

    private String grdlvl82;

    @javax.persistence.Column(name = "GRDLVL82")
    @Basic
    public String getGrdlvl82() {
        return grdlvl82;
    }

    public void setGrdlvl82(String grdlvl82) {
        this.grdlvl82 = grdlvl82;
    }

    private String grdlvl92;

    @javax.persistence.Column(name = "GRDLVL92")
    @Basic
    public String getGrdlvl92() {
        return grdlvl92;
    }

    public void setGrdlvl92(String grdlvl92) {
        this.grdlvl92 = grdlvl92;
    }

    private String grdlvla2;

    @javax.persistence.Column(name = "GRDLVLA2")
    @Basic
    public String getGrdlvla2() {
        return grdlvla2;
    }

    public void setGrdlvla2(String grdlvla2) {
        this.grdlvla2 = grdlvla2;
    }

    private String grdlvlb2;

    @javax.persistence.Column(name = "GRDLVLB2")
    @Basic
    public String getGrdlvlb2() {
        return grdlvlb2;
    }

    public void setGrdlvlb2(String grdlvlb2) {
        this.grdlvlb2 = grdlvlb2;
    }

    private String grdlvlc2;

    @javax.persistence.Column(name = "GRDLVLC2")
    @Basic
    public String getGrdlvlc2() {
        return grdlvlc2;
    }

    public void setGrdlvlc2(String grdlvlc2) {
        this.grdlvlc2 = grdlvlc2;
    }

    private int aesamt2;

    @javax.persistence.Column(name = "AESAMT2")
    @Basic
    public int getAesamt2() {
        return aesamt2;
    }

    public void setAesamt2(int aesamt2) {
        this.aesamt2 = aesamt2;
    }

    private int cesamt2;

    @javax.persistence.Column(name = "CESAMT2")
    @Basic
    public int getCesamt2() {
        return cesamt2;
    }

    public void setCesamt2(int cesamt2) {
        this.cesamt2 = cesamt2;
    }

    private String cssncol2;

    @javax.persistence.Column(name = "CSSNCOL2")
    @Basic
    public String getCssncol2() {
        return cssncol2;
    }

    public void setCssncol2(String cssncol2) {
        this.cssncol2 = cssncol2;
    }

    private String nsldldt2;

    @javax.persistence.Column(name = "NSLDLDT2")
    @Basic
    public String getNsldldt2() {
        return nsldldt2;
    }

    public void setNsldldt2(String nsldldt2) {
        this.nsldldt2 = nsldldt2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snp2Entity that = (Snp2Entity) o;

        if (aesamt2 != that.aesamt2) return false;
        if (apadc2 != that.apadc2) return false;
        if (apexcld2 != that.apexcld2) return false;
        if (apinccr2 != that.apinccr2) return false;
        if (apntcs2 != that.apntcs2) return false;
        if (aponti2 != that.aponti2) return false;
        if (cesamt2 != that.cesamt2) return false;
        if (paavli2 != that.paavli2) return false;
        if (pabfw2 != that.pabfw2) return false;
        if (padc2 != that.padc2) return false;
        if (padj2 != that.padj2) return false;
        if (padjw2 != that.padjw2) return false;
        if (pagir2 != that.pagir2) return false;
        if (papa2 != that.papa2) return false;
        if (passad2 != that.passad2) return false;
        if (pbaavli2 != that.pbaavli2) return false;
        if (pbabfw2 != that.pbabfw2) return false;
        if (pbadc2 != that.pbadc2) return false;
        if (pbagir2 != that.pbagir2) return false;
        if (pbapa2 != that.pbapa2) return false;
        if (pbconf2 != that.pbconf2) return false;
        if (pbdnet2 != that.pbdnet2) return false;
        if (pbefin2 != that.pbefin2) return false;
        if (pbemal2 != that.pbemal2) return false;
        if (pbex2 != that.pbex2) return false;
        if (pbfd2 != that.pbfd2) return false;
        if (pbfe2 != that.pbfe2) return false;
        if (pbfica2 != that.pbfica2) return false;
        if (pbfri2 != that.pbfri2) return false;
        if (pbfv2 != that.pbfv2) return false;
        if (pbfwag2 != that.pbfwag2) return false;
        if (pbhome2 != that.pbhome2) return false;
        if (pbial12 != that.pbial12) return false;
        if (pbial22 != that.pbial22) return false;
        if (pbinca2 != that.pbinca2) return false;
        if (pbincsu2 != that.pbincsu2) return false;
        if (pbitx2 != that.pbitx2) return false;
        if (pbmeda2 != that.pbmeda2) return false;
        if (pbmwag2 != that.pbmwag2) return false;
        if (pbntcs2 != that.pbntcs2) return false;
        if (pbnti2 != that.pbnti2) return false;
        if (pbnwrth2 != that.pbnwrth2) return false;
        if (pbonti2 != that.pbonti2) return false;
        if (pboti2 != that.pboti2) return false;
        if (pbsma2 != that.pbsma2) return false;
        if (pbss2 != that.pbss2) return false;
        if (pbsttx2 != that.pbsttx2) return false;
        if (pbtalo2 != that.pbtalo2) return false;
        if (pbti2 != that.pbti2) return false;
        if (pbtti2 != that.pbtti2) return false;
        if (pbtuit2 != that.pbtuit2) return false;
        if (pbtuita2 != that.pbtuita2) return false;
        if (pcash2 != that.pcash2) return false;
        if (pconf2 != that.pconf2) return false;
        if (pconfn2 != that.pconfn2) return false;
        if (pdass2 != that.pdass2) return false;
        if (pded2 != that.pded2) return false;
        if (pdiv2 != that.pdiv2) return false;
        if (pdnet2 != that.pdnet2) return false;
        if (pefinc2 != that.pefinc2) return false;
        if (pemalo2 != that.pemalo2) return false;
        if (pexcld2 != that.pexcld2) return false;
        if (pfarmd2 != that.pfarmd2) return false;
        if (pfarme2 != that.pfarme2) return false;
        if (pfarmv2 != that.pfarmv2) return false;
        if (pfica2 != that.pfica2) return false;
        if (pfwag2 != that.pfwag2) return false;
        if (phomc2 != that.phomc2) return false;
        if (phomd2 != that.phomd2) return false;
        if (phome2 != that.phome2) return false;
        if (phompv2 != that.phompv2) return false;
        if (phomv2 != that.phomv2) return false;
        if (pialo12 != that.pialo12) return false;
        if (pialo22 != that.pialo22) return false;
        if (pinca12 != that.pinca12) return false;
        if (pinca22 != that.pinca22) return false;
        if (pinccr2 != that.pinccr2) return false;
        if (pincsu2 != that.pincsu2) return false;
        if (pint2 != that.pint2) return false;
        if (pinvd2 != that.pinvd2) return false;
        if (pinve2 != that.pinve2) return false;
        if (pinvv2 != that.pinvv2) return false;
        if (pitx2 != that.pitx2) return false;
        if (pitxc2 != that.pitxc2) return false;
        if (pitxp2 != that.pitxp2) return false;
        if (pmed2 != that.pmed2) return false;
        if (pmeda2 != that.pmeda2) return false;
        if (pmwag2 != that.pmwag2) return false;
        if (pntcs2 != that.pntcs2) return false;
        if (pnwrth2 != that.pnwrth2) return false;
        if (ponti2 != that.ponti2) return false;
        if (pord2 != that.pord2) return false;
        if (pore2 != that.pore2) return false;
        if (porv2 != that.porv2) return false;
        if (pothd2 != that.pothd2) return false;
        if (poti2 != that.poti2) return false;
        if (pravli2 != that.pravli2) return false;
        if (psma2 != that.psma2) return false;
        if (pss2 != that.pss2) return false;
        if (psttx2 != that.psttx2) return false;
        if (ptass2 != that.ptass2) return false;
        if (ptconf2 != that.ptconf2) return false;
        if (ptinc2 != that.ptinc2) return false;
        if (ptnti2 != that.ptnti2) return false;
        if (ptotal2 != that.ptotal2) return false;
        if (pttinc2 != that.pttinc2) return false;
        if (ptuit2 != that.ptuit2) return false;
        if (ptuita2 != that.ptuita2) return false;
        if (pwag2 != that.pwag2) return false;
        if (sbaset2 != that.sbaset2) return false;
        if (aidyr != null ? !aidyr.equals(that.aidyr) : that.aidyr != null) return false;
        if (cmptype != null ? !cmptype.equals(that.cmptype) : that.cmptype != null) return false;
        if (createc != null ? !createc.equals(that.createc) : that.createc != null) return false;
        if (cssncol2 != null ? !cssncol2.equals(that.cssncol2) : that.cssncol2 != null) return false;
        if (grdlvl12 != null ? !grdlvl12.equals(that.grdlvl12) : that.grdlvl12 != null) return false;
        if (grdlvl22 != null ? !grdlvl22.equals(that.grdlvl22) : that.grdlvl22 != null) return false;
        if (grdlvl32 != null ? !grdlvl32.equals(that.grdlvl32) : that.grdlvl32 != null) return false;
        if (grdlvl42 != null ? !grdlvl42.equals(that.grdlvl42) : that.grdlvl42 != null) return false;
        if (grdlvl52 != null ? !grdlvl52.equals(that.grdlvl52) : that.grdlvl52 != null) return false;
        if (grdlvl62 != null ? !grdlvl62.equals(that.grdlvl62) : that.grdlvl62 != null) return false;
        if (grdlvl72 != null ? !grdlvl72.equals(that.grdlvl72) : that.grdlvl72 != null) return false;
        if (grdlvl82 != null ? !grdlvl82.equals(that.grdlvl82) : that.grdlvl82 != null) return false;
        if (grdlvl92 != null ? !grdlvl92.equals(that.grdlvl92) : that.grdlvl92 != null) return false;
        if (grdlvla2 != null ? !grdlvla2.equals(that.grdlvla2) : that.grdlvla2 != null) return false;
        if (grdlvlb2 != null ? !grdlvlb2.equals(that.grdlvlb2) : that.grdlvlb2 != null) return false;
        if (grdlvlc2 != null ? !grdlvlc2.equals(that.grdlvlc2) : that.grdlvlc2 != null) return false;
        if (instid != null ? !instid.equals(that.instid) : that.instid != null) return false;
        if (namefl2 != null ? !namefl2.equals(that.namefl2) : that.namefl2 != null) return false;
        if (nameml2 != null ? !nameml2.equals(that.nameml2) : that.nameml2 != null) return false;
        if (nsldldt2 != null ? !nsldldt2.equals(that.nsldldt2) : that.nsldldt2 != null) return false;
        if (page2 != null ? !page2.equals(that.page2) : that.page2 != null) return false;
        if (passcr2 != null ? !passcr2.equals(that.passcr2) : that.passcr2 != null) return false;
        if (pbasscr2 != null ? !pbasscr2.equals(that.pbasscr2) : that.pbasscr2 != null) return false;
        if (pcola2 != null ? !pcola2.equals(that.pcola2) : that.pcola2 != null) return false;
        if (pdishm2 != null ? !pdishm2.equals(that.pdishm2) : that.pdishm2 != null) return false;
        if (pdiswk2 != null ? !pdiswk2.equals(that.pdiswk2) : that.pdiswk2 != null) return false;
        if (pelgfil2 != null ? !pelgfil2.equals(that.pelgfil2) : that.pelgfil2 != null) return false;
        if (pexemp2 != null ? !pexemp2.equals(that.pexemp2) : that.pexemp2 != null) return false;
        if (pfarm2 != null ? !pfarm2.equals(that.pfarm2) : that.pfarm2 != null) return false;
        if (pfedlvl2 != null ? !pfedlvl2.equals(that.pfedlvl2) : that.pfedlvl2 != null) return false;
        if (pfilrtn2 != null ? !pfilrtn2.equals(that.pfilrtn2) : that.pfilrtn2 != null) return false;
        if (phmyr2Z != null ? !phmyr2Z.equals(that.phmyr2Z) : that.phmyr2Z != null) return false;
        if (phomyr2 != null ? !phomyr2.equals(that.phomyr2) : that.phomyr2 != null) return false;
        if (phvplus2 != null ? !phvplus2.equals(that.phvplus2) : that.phvplus2 != null) return false;
        if (pincol2 != null ? !pincol2.equals(that.pincol2) : that.pincol2 != null) return false;
        if (pmartl2 != null ? !pmartl2.equals(that.pmartl2) : that.pmartl2 != null) return false;
        if (pmedlvl2 != null ? !pmedlvl2.equals(that.pmedlvl2) : that.pmedlvl2 != null) return false;
        if (pnrps2 != null ? !pnrps2.equals(that.pnrps2) : that.pnrps2 != null) return false;
        if (pntuit2 != null ? !pntuit2.equals(that.pntuit2) : that.pntuit2 != null) return false;
        if (presbfr2 != null ? !presbfr2.equals(that.presbfr2) : that.presbfr2 != null) return false;
        if (pszhhd2 != null ? !pszhhd2.equals(that.pszhhd2) : that.pszhhd2 != null) return false;
        if (ptrfil2 != null ? !ptrfil2.equals(that.ptrfil2) : that.ptrfil2 != null) return false;
        if (recstat != null ? !recstat.equals(that.recstat) : that.recstat != null) return false;
        if (revdtc != null ? !revdtc.equals(that.revdtc) : that.revdtc != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (snpkey != null ? !snpkey.equals(that.snpkey) : that.snpkey != null) return false;
        if (ssnfat2 != null ? !ssnfat2.equals(that.ssnfat2) : that.ssnfat2 != null) return false;
        if (ssnmot2 != null ? !ssnmot2.equals(that.ssnmot2) : that.ssnmot2 != null) return false;
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
        result = 31 * result + (pmartl2 != null ? pmartl2.hashCode() : 0);
        result = 31 * result + (pfedlvl2 != null ? pfedlvl2.hashCode() : 0);
        result = 31 * result + (pmedlvl2 != null ? pmedlvl2.hashCode() : 0);
        result = 31 * result + (page2 != null ? page2.hashCode() : 0);
        result = 31 * result + (pszhhd2 != null ? pszhhd2.hashCode() : 0);
        result = 31 * result + (pexemp2 != null ? pexemp2.hashCode() : 0);
        result = 31 * result + (pnrps2 != null ? pnrps2.hashCode() : 0);
        result = 31 * result + (pincol2 != null ? pincol2.hashCode() : 0);
        result = 31 * result + (pdiswk2 != null ? pdiswk2.hashCode() : 0);
        result = 31 * result + (pdishm2 != null ? pdishm2.hashCode() : 0);
        result = 31 * result + (ptrfil2 != null ? ptrfil2.hashCode() : 0);
        result = 31 * result + pfwag2;
        result = 31 * result + pmwag2;
        result = 31 * result + padjw2;
        result = 31 * result + pwag2;
        result = 31 * result + pint2;
        result = 31 * result + pdiv2;
        result = 31 * result + pbfri2;
        result = 31 * result + poti2;
        result = 31 * result + pbex2;
        result = 31 * result + padj2;
        result = 31 * result + pttinc2;
        result = 31 * result + pagir2;
        result = 31 * result + pss2;
        result = 31 * result + padc2;
        result = 31 * result + pntcs2;
        result = 31 * result + ponti2;
        result = 31 * result + pinca12;
        result = 31 * result + pinca22;
        result = 31 * result + ptinc2;
        result = 31 * result + pded2;
        result = 31 * result + pitxp2;
        result = 31 * result + pitxc2;
        result = 31 * result + pitx2;
        result = 31 * result + pfica2;
        result = 31 * result + psttx2;
        result = 31 * result + pmed2;
        result = 31 * result + pmeda2;
        result = 31 * result + ptuit2;
        result = 31 * result + (pntuit2 != null ? pntuit2.hashCode() : 0);
        result = 31 * result + ptuita2;
        result = 31 * result + pemalo2;
        result = 31 * result + psma2;
        result = 31 * result + pialo12;
        result = 31 * result + pialo22;
        result = 31 * result + ptotal2;
        result = 31 * result + pefinc2;
        result = 31 * result + pcash2;
        result = 31 * result + pinvv2;
        result = 31 * result + pinvd2;
        result = 31 * result + pinve2;
        result = 31 * result + porv2;
        result = 31 * result + pord2;
        result = 31 * result + pore2;
        result = 31 * result + pdass2;
        result = 31 * result + phompv2;
        result = 31 * result + phomc2;
        result = 31 * result + phomv2;
        result = 31 * result + phomd2;
        result = 31 * result + phome2;
        result = 31 * result + pfarmv2;
        result = 31 * result + pfarmd2;
        result = 31 * result + pfarme2;
        result = 31 * result + pbfv2;
        result = 31 * result + pbfd2;
        result = 31 * result + pbfe2;
        result = 31 * result + (pfarm2 != null ? pfarm2.hashCode() : 0);
        result = 31 * result + pabfw2;
        result = 31 * result + passad2;
        result = 31 * result + ptass2;
        result = 31 * result + pothd2;
        result = 31 * result + pnwrth2;
        result = 31 * result + papa2;
        result = 31 * result + pdnet2;
        result = 31 * result + (passcr2 != null ? passcr2.hashCode() : 0);
        result = 31 * result + pincsu2;
        result = 31 * result + paavli2;
        result = 31 * result + (pcola2 != null ? pcola2.hashCode() : 0);
        result = 31 * result + pravli2;
        result = 31 * result + ptconf2;
        result = 31 * result + pconfn2;
        result = 31 * result + pconf2;
        result = 31 * result + pbfwag2;
        result = 31 * result + pbmwag2;
        result = 31 * result + pboti2;
        result = 31 * result + pbtti2;
        result = 31 * result + pbagir2;
        result = 31 * result + pbss2;
        result = 31 * result + pbadc2;
        result = 31 * result + pbntcs2;
        result = 31 * result + pbonti2;
        result = 31 * result + pbinca2;
        result = 31 * result + pbnti2;
        result = 31 * result + pbti2;
        result = 31 * result + pbitx2;
        result = 31 * result + pbfica2;
        result = 31 * result + pbsttx2;
        result = 31 * result + pbmeda2;
        result = 31 * result + pbtuit2;
        result = 31 * result + pbemal2;
        result = 31 * result + pbsma2;
        result = 31 * result + pbial12;
        result = 31 * result + pbial22;
        result = 31 * result + pbtalo2;
        result = 31 * result + pbefin2;
        result = 31 * result + ptnti2;
        result = 31 * result + pbtuita2;
        result = 31 * result + pbnwrth2;
        result = 31 * result + pbapa2;
        result = 31 * result + pbdnet2;
        result = 31 * result + (pbasscr2 != null ? pbasscr2.hashCode() : 0);
        result = 31 * result + pbincsu2;
        result = 31 * result + pbaavli2;
        result = 31 * result + pbhome2;
        result = 31 * result + pbabfw2;
        result = 31 * result + pbconf2;
        result = 31 * result + pexcld2;
        result = 31 * result + (phvplus2 != null ? phvplus2.hashCode() : 0);
        result = 31 * result + apexcld2;
        result = 31 * result + pinccr2;
        result = 31 * result + apinccr2;
        result = 31 * result + aponti2;
        result = 31 * result + apadc2;
        result = 31 * result + apntcs2;
        result = 31 * result + (phmyr2Z != null ? phmyr2Z.hashCode() : 0);
        result = 31 * result + (phomyr2 != null ? phomyr2.hashCode() : 0);
        result = 31 * result + sbaset2;
        result = 31 * result + (pfilrtn2 != null ? pfilrtn2.hashCode() : 0);
        result = 31 * result + (pelgfil2 != null ? pelgfil2.hashCode() : 0);
        result = 31 * result + (presbfr2 != null ? presbfr2.hashCode() : 0);
        result = 31 * result + (namefl2 != null ? namefl2.hashCode() : 0);
        result = 31 * result + (ssnfat2 != null ? ssnfat2.hashCode() : 0);
        result = 31 * result + (nameml2 != null ? nameml2.hashCode() : 0);
        result = 31 * result + (ssnmot2 != null ? ssnmot2.hashCode() : 0);
        result = 31 * result + (createc != null ? createc.hashCode() : 0);
        result = 31 * result + (revdtc != null ? revdtc.hashCode() : 0);
        result = 31 * result + (grdlvl12 != null ? grdlvl12.hashCode() : 0);
        result = 31 * result + (grdlvl22 != null ? grdlvl22.hashCode() : 0);
        result = 31 * result + (grdlvl32 != null ? grdlvl32.hashCode() : 0);
        result = 31 * result + (grdlvl42 != null ? grdlvl42.hashCode() : 0);
        result = 31 * result + (grdlvl52 != null ? grdlvl52.hashCode() : 0);
        result = 31 * result + (grdlvl62 != null ? grdlvl62.hashCode() : 0);
        result = 31 * result + (grdlvl72 != null ? grdlvl72.hashCode() : 0);
        result = 31 * result + (grdlvl82 != null ? grdlvl82.hashCode() : 0);
        result = 31 * result + (grdlvl92 != null ? grdlvl92.hashCode() : 0);
        result = 31 * result + (grdlvla2 != null ? grdlvla2.hashCode() : 0);
        result = 31 * result + (grdlvlb2 != null ? grdlvlb2.hashCode() : 0);
        result = 31 * result + (grdlvlc2 != null ? grdlvlc2.hashCode() : 0);
        result = 31 * result + aesamt2;
        result = 31 * result + cesamt2;
        result = 31 * result + (cssncol2 != null ? cssncol2.hashCode() : 0);
        result = 31 * result + (nsldldt2 != null ? nsldldt2.hashCode() : 0);
        return result;
    }
}
