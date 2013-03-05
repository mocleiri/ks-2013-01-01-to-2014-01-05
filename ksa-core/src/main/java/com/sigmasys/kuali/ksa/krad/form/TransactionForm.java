package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.config.ConfigService;
import com.sigmasys.kuali.ksa.krad.model.TransactionModel;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.util.ContextUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionForm extends AbstractViewModel {

    private Account account;

    private List<Alert> alerts;
    private List<Flag> flags;
    private List<Memo> memos;

    private List<TransactionModel> rollupTransactions;
    private List<TransactionModel> allTransactions;

    private BigDecimal startingBalance;
    private BigDecimal endingBalance;

    // Not sure if any of these below this line are still used.


    // use this object as a query argument for matching transactions by student name
    private String studentLookupByName;

    private String selectedPersonName;

    // result set of matching persons and address postal information
    private List<Account> accountBrowseList;


    private List<Charge> chargeList;

    // result set of charges
    private List<Payment> paymentList;

    // a single charge
    private Charge charge;

    // a single payment
    private Payment payment;

    // Currency stuff
    private List<Currency> currencies;

    private Currency currency;

    private String code;

    private String currencyName;

    private String currencyDescription;

    // a list of activities
    private List<Activity> activities;

    /**
     * Get the student name
     * Possible uses is a query match for transactions
     * The value can be a partial matching name
     *
     * @return
     */
    public String getStudentLookupByName() {
        return studentLookupByName;
    }

    /**
     * Set the student lookup name
     * Possible uses is a query match for transactions
     * The value can be a partial matching name
     *
     * @param studentLookupByName
     */
    public void setStudentLookupByName(String studentLookupByName) {
        this.studentLookupByName = studentLookupByName;
    }

    /**
     * Get the selected person name
     *
     * @return
     */
    public String getSelectedPersonName() {
        return selectedPersonName;
    }

    /**
     * Set the selected person name
     *
     * @param selectedPersonName
     */
    public void setSelectedPersonName(String selectedPersonName) {
        this.selectedPersonName = selectedPersonName;
    }

    /**
     * Get the accountBrowseList
     * Encapsulates Person and Address model
     *
     * @return
     */
    public List<Account> getAccountBrowseList() {
        return accountBrowseList;
    }

    /**
     * Set the accountBrowseList
     * Encapsulates Person and Address model
     *
     * @param accountBrowseList
     */
    public void setAccountBrowseList(List<Account> accountBrowseList) {
        this.accountBrowseList = accountBrowseList;
    }

    /**
     * Get the list of Charges found via a selected Account
     *
     * @return
     */
    public List<Charge> getChargeList() {
        return chargeList;
    }

    /**
     * Set the list of Charges found via a selected Account
     *
     * @param chargeList
     */
    public void setChargeList(List<Charge> chargeList) {
        this.chargeList = chargeList;
    }

    /**
     * Get the list of Payments found via a selected Account
     *
     * @return
     */
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    /**
     * Set the list of Payments found via a selected Account
     *
     * @param paymentList
     */
    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    /**
     * Get a charge object
     *
     * @return
     */
    public Charge getCharge() {
        return charge;
    }

    /**
     * Set a charge object
     *
     * @param charge
     */
    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    /**
     * Get a Payment object
     *
     * @return
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Set a Payment object
     *
     * @param payment
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    // Currency get/Set methods

    /**
     * Get the list of Currency objects
     *
     * @return
     */
    public List<Currency> getCurrencies() {
        return currencies;
    }

    /**
     * Set the list of Currency objects
     *
     * @param currencies
     */
    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    /**
     * Get the Currency model object
     *
     * @return
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Set teh Currency model object
     *
     * @param currency
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * Get the ISO symbol
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the ISO symbol
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get the currencyName
     *
     * @return
     */
    public String getCurrencyName() {
        return currencyName;
    }

    /**
     * Set the Name
     *
     * @param currencyName
     */
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    /**
     * Get the currency description
     *
     * @return
     */
    public String getCurrencyDescription() {
        return currencyDescription;
    }

    /**
     * Set  the currency description
     *
     * @param currencyDescription
     */
    public void setCurrencyDescription(String currencyDescription) {
        this.currencyDescription = currencyDescription;
    }

    /**
     * Get a list of activities
     *
     * @return
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Set a list of activities
     *
     * @param activities
     */
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Alert> getAlerts() {
        if (alerts == null) {
            alerts = new ArrayList<Alert>();
        }
        return alerts;
    }

    public String getAlertTooltip() {

        int itemsPerPage = getItemsPerPage();

        String html = "<b>Alerts (";

        if (alerts == null || alerts.size() == 0) {
            html += "0/0)</b><br/><p>No alerts</p>";
            return html;
        }

        int size = alerts.size();

        if (size > itemsPerPage) {
            html += itemsPerPage + "/" + size + ")</b><br/>";
        } else {
            html += size + "/" + size + ")</b><br/>";
        }

        html += "<p>";
        for (int i = 0; i < alerts.size() && i < itemsPerPage; i++) {
            html += alerts.get(i).getDisplayValue() + "<br/>";
        }
        html += "</p>";

        return html;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public List<Flag> getFlags() {
        if (flags == null) {
            flags = new ArrayList<Flag>();
        }
        return flags;
    }

    public String getFlagTooltip() {

        int itemsPerPage = getItemsPerPage();

        String html = "<b>Flags (";

        if (flags == null || flags.size() == 0) {
            html += "0/0)</b><br/><p>No flags</p>";
            return html;
        }

        int size = flags.size();

        if (size > itemsPerPage) {
            html += itemsPerPage + "/" + size + ")</b><br/>";
        } else {
            html += size + "/" + size + ")</b><br/>";
        }

        html += "<p>";
        for (int i = 0; i < flags.size() && i < itemsPerPage; i++) {
            html += flags.get(i).getDisplayValue() + "<br/>";
        }
        html += "</p>";

        return html;
    }

    public void setFlags(List<Flag> flags) {
        this.flags = flags;
    }

    public List<TransactionModel> getRollupTransactions() {
        return rollupTransactions;
    }

    public void setRollupTransactions(List<TransactionModel> rollupTransactions) {
        this.rollupTransactions = rollupTransactions;
    }

    public List<TransactionModel> getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(List<TransactionModel> allTransactions) {
        this.allTransactions = allTransactions;
    }

    public List<Memo> getMemos() {
        return memos;
    }

    public String getMemoTooltip() {

        int itemsPerPage = getItemsPerPage();

        String html = "<b>Memos (";

        if (alerts == null || alerts.size() == 0) {
            html += "0/0)</b><br/><p>No memos</p>";
            return html;
        }

        int size = memos.size();

        if (size > itemsPerPage) {
            html += itemsPerPage + "/" + size + ")</b><br/>";
        } else {
            html += size + "/" + size + ")</b><br/>";
        }

        html += "<p>";
        for (int i = 0; i < memos.size() && i < itemsPerPage; i++) {
            html += memos.get(i).getDisplayValue() + "<br/>";
        }
        html += "</p>";

        return html;
    }

    public void setMemos(List<Memo> memos) {
        this.memos = memos;
    }

    public BigDecimal getStartingBalance() {
        if (this.startingBalance == null) {
            this.startingBalance = BigDecimal.ZERO;
        }
        return startingBalance;
    }

    public void setStartingBalance(BigDecimal startingBalance) {
        this.startingBalance = startingBalance;
    }

    public BigDecimal getEndingBalance() {
        if (this.endingBalance == null) {
            this.endingBalance = BigDecimal.ZERO;
        }
        return endingBalance;
    }

    public void setEndingBalance(BigDecimal endingBalance) {
        this.endingBalance = endingBalance;
    }

    private int getItemsPerPage() {
        return Integer.valueOf(ContextUtils.getBean(ConfigService.class).getParameter(Constants.QUICKVIEW_INFORMATION_COUNT));
    }

}
