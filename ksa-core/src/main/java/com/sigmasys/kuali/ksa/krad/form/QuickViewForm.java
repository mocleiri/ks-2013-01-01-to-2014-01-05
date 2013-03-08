package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.model.*;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
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

    private String pastDueAmount;

    private String balanceAmount;

    private String futureAmount;

    private String defermentAmount;

    // Biographic Information

    private String compositeDefaultPersonName;

    private String compositeDefaultPostalAddress;

    // Alert

    private List<Information> alertsFlags;
    // Aging

    // the last aging date
    private Date lastAgeDate;

    // sum of aged values
    private String agedTotal;

    // amountLate1
    private String aged30;

    // amountLate2
    private String aged60;

    // amountLate3
    private String aged90;

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

    public String getPastDueAmount() {
        return this.getFormattedAmount(pastDueAmount);
    }

    public void setPastDueAmount(String pastDueAmount) {
        this.pastDueAmount = pastDueAmount;
    }

    public String getBalanceAmount() {
        return this.getFormattedAmount(balanceAmount);
    }

    public void setBalanceAmount(String balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getFutureAmount() {
        return this.getFormattedAmount(futureAmount);
    }

    public void setFutureAmount(String futureAmount) {
        this.futureAmount = futureAmount;
    }

    public String getDefermentAmount() {
        return this.getFormattedAmount(defermentAmount);
    }

    public void setDefermentAmount(String defermentAmount) {
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


    public List<Information> getAlertsFlags() {
        return alertsFlags;
    }

    public void setAlertsFlags(List<Information> alertsFlags) {
        this.alertsFlags = alertsFlags;
    }

    public Date getLastAgeDate() {
        return lastAgeDate;
    }

    public void setLastAgeDate(Date lastAgeDate) {
        this.lastAgeDate = lastAgeDate;
    }

    public String getAgedTotal() {
        return this.getFormattedAmount(agedTotal);
    }

    public void setAgedTotal(String agedTotal) {
        this.agedTotal = agedTotal;
    }

    public String getAged30() {
        return this.getFormattedAmount(aged30);
    }

    public void setAged30(String aged30) {
        this.aged30 = aged30;
    }

    public String getAged60() {
        return this.getFormattedAmount(aged60);
    }

    public void setAged60(String aged60) {
        this.aged60 = aged60;
    }

    public String getAged90() {
        return this.getFormattedAmount(aged90);
    }

    public void setAged90(String aged90) {
        this.aged90 = aged90;
    }


    public String getIgnoreDeferment() {
        return ignoreDeferment;
    }

    public void setIgnoreDeferment(String ignoreDeferment) {
        this.ignoreDeferment = ignoreDeferment;
    }

    public List<Memo> getMemoModels() {
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

    public String getFormattedAmount(String amount) {
        String formattedNumber = "";
        if (getCurrency() != null && amount != null) {
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
            numberFormat.setCurrency(java.util.Currency.getInstance(getCurrency().getCode()));
            double doubleAmount = Double.parseDouble(amount);
            formattedNumber = numberFormat.format(doubleAmount);
        }
        return formattedNumber;
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
        return "unknown";

    }

    public String getFormattedDate(Date date){
        DateFormat df;
        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        return df.format(date);
    }
}
