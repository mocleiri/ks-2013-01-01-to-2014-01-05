package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.config.ConfigService;
import com.sigmasys.kuali.ksa.krad.model.InformationModel;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.util.ContextUtils;
import com.sigmasys.kuali.ksa.util.InformationUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by: dmulderink on 9/28/12 at 2:25 PM
 */
public class QuickViewForm extends AbstractViewModel {


    private Account account;

    private Currency currency;

    // Account Overview

    private BigDecimal pastDueAmount;

    private BigDecimal balanceAmount;

    private BigDecimal futureAmount;

    private BigDecimal defermentAmount;

    private BigDecimal outstandingAmount;

    // Biographic Information

    private String compositeDefaultPersonName;

    private String compositeDefaultPostalAddress;

    // Alert

    private List<InformationModel> alerts;
    private List<InformationModel> flags;
    private List<InformationModel> holds;


    // the last aging date
    private Date lastAgeDate;

    // sum of aged values
    private BigDecimal agedTotal;

    // amountLate1
    private BigDecimal aged30;

    // amountLate2
    private BigDecimal aged60;

    // amountLate3
    private BigDecimal aged90;

    // Aged debit flag
    private String ignoreDeferment;

    private String daysLate1;

    private String daysLate2;

    private String daysLate3;

    // Memos

    private List<Memo> memoModels;

    private Memo memoModel;

    private String statusMessage;

    /*
      Get / Set methods
    */

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getPastDueAmount() {
        return pastDueAmount;
    }

    public void setPastDueAmount(BigDecimal pastDueAmount) {
        this.pastDueAmount = pastDueAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getFutureAmount() {
        return futureAmount;
    }

    public void setFutureAmount(BigDecimal futureAmount) {
        this.futureAmount = futureAmount;
    }

    public BigDecimal getDefermentAmount() {
        return defermentAmount;
    }

    public void setDefermentAmount(BigDecimal defermentAmount) {
        this.defermentAmount = defermentAmount;
    }


    public String getCompositeDefaultPersonName() {
        return compositeDefaultPersonName;
    }

    public void setCompositeDefaultPersonName(String compositeDefaultPersonName) {
        this.compositeDefaultPersonName = compositeDefaultPersonName;
    }

    public String getCompositeDefaultPostalAddress() {
        return compositeDefaultPostalAddress;
    }

    public void setCompositeDefaultPostalAddress(String compositeDefaultPostalAddress) {
        this.compositeDefaultPostalAddress = compositeDefaultPostalAddress;
    }


    public List<InformationModel> getAlertsFlags() {
        List<InformationModel> list = new ArrayList<InformationModel>();

        list.addAll(this.getAlerts());
        list.addAll(this.getFlags());
        list.addAll(this.getHolds());
        return InformationUtils.orderModelsByEffectiveDate(list, false);

    }

    public Date getLastAgeDate() {
        return lastAgeDate;
    }

    public void setLastAgeDate(Date lastAgeDate) {
        this.lastAgeDate = lastAgeDate;
    }

    public BigDecimal getAgedTotal() {
        return agedTotal;
    }

    public void setAgedTotal(BigDecimal agedTotal) {
        this.agedTotal = agedTotal;
    }

    public BigDecimal getAged30() {
        return aged30;
    }

    public void setAged30(BigDecimal aged30) {
        this.aged30 = aged30;
    }

    public BigDecimal getAged60() {
        return aged60;
    }

    public void setAged60(BigDecimal aged60) {
        this.aged60 = aged60;
    }

    public BigDecimal getAged90() {
        return aged90;
    }

    public void setAged90(BigDecimal aged90) {
        this.aged90 = aged90;
    }


    public String getIgnoreDeferment() {
        return ignoreDeferment;
    }

    public void setIgnoreDeferment(String ignoreDeferment) {
        this.ignoreDeferment = ignoreDeferment;
    }

    public List<Memo> getMemoModels() {
        if(memoModels == null){
            memoModels = new ArrayList<Memo>();
        }
        return memoModels;
    }

    public void setMemoModels(List<Memo> memoModels) {
        this.memoModels = memoModels;
    }

    public Memo getMemoModel() {
        return memoModel;
    }

    public void setMemoModel(Memo memoModel) {
        this.memoModel = memoModel;
    }


    public String getDaysLate1() {
        return daysLate1;
    }

    public void setDaysLate1(String daysLate1) {
        this.daysLate1 = daysLate1;
    }

    public String getDaysLate2() {
        return daysLate2;
    }

    public void setDaysLate2(String daysLate2) {
        this.daysLate2 = daysLate2;
    }

    public String getDaysLate3() {
        return daysLate3;
    }

    public void setDaysLate3(String daysLate3) {
        this.daysLate3 = daysLate3;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getInfoType(Information i){
        if(i instanceof Alert){
            return "alert";
        } else if(i instanceof Flag){
            return "flag";
        } else if(i instanceof Memo){
            return "memo";
        }
        return "";

    }

    public String getInfoType(InformationModel i){
        String type = getInfoType(i.getParentEntity());
        if("".equals(type)) {
            type = "hold";
        }
        return type;
    }

    public List<InformationModel> getAlerts() {
        if (alerts == null) {
            alerts = new ArrayList<InformationModel>();
        }
        return alerts;
    }

    public String getAlertTooltip() {
        return this.getInformationTooltip("Alerts", alerts);
    }

    public void setAlertObjects(List<Alert> alerts) {
        List<InformationModel> models = new ArrayList<InformationModel>(alerts.size());
        for(Alert alert : alerts){
            models.add(new InformationModel(alert));
        }
        setAlerts(models);
    }

    public void setAlerts(List<InformationModel> alerts) {
        this.alerts = alerts;
    }

    public List<InformationModel> getFlags() {
        if (flags == null) {
            flags = new ArrayList<InformationModel>();
        }
        return flags;
    }

    public String getFlagTooltip() {
        return this.getInformationTooltip("Flags", flags);
    }

    public void setFlagObjects(List<Flag> flags) {
        List<InformationModel> models = new ArrayList<InformationModel>(flags.size());
        for(Flag flag : flags){
            models.add(new InformationModel(flag));
        }
        setFlags(models);
    }

    public void setFlags(List<InformationModel> flags) {
        this.flags = flags;
    }

    public List<InformationModel> getHolds() {
        if(holds == null) {
            holds = new ArrayList<InformationModel>();
        }
        return holds;
    }

    public void setHolds(List<InformationModel> holds) {
        this.holds = holds;
    }

    public String getHoldTooltip() {
        return this.getInformationTooltip("Holds", holds);
    }

    private int getItemsPerPage() {
        return Integer.valueOf(ContextUtils.getBean(ConfigService.class).getParameter(Constants.QUICKVIEW_INFORMATION_COUNT));
    }


    private String getInformationTooltip(String name, List<InformationModel> items) {

        int itemsPerPage = getItemsPerPage();

        String html = "<b>" + name + " (";

        if (items == null || items.size() == 0) {
            html += "0/0)</b><br/><p>No " + name + "</p>";
            return html;
        }

        int size = items.size();

        if (size > itemsPerPage) {
            html += itemsPerPage + "/" + size + ")</b><br/>";
        } else {
            html += size + "/" + size + ")</b><br/>";
        }

        html += "<p>";
        for (int i = 0; i < items.size() && i < itemsPerPage; i++) {
            html += items.get(i).getDisplayValue() + "<br/>";
        }
        html += "</p>";

        return html;
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }
}
