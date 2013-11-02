package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.PotentialRefundModel;
import com.sigmasys.kuali.ksa.krad.model.RefundModel;
import com.sigmasys.kuali.ksa.krad.model.RequestPotentialRefundSummaryModel;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Refund;
import com.sigmasys.kuali.ksa.model.RefundStatus;
import com.sigmasys.kuali.ksa.model.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BatchRefundForm extends TransactionForm {

    /*
    Lookup Account and Tag support.
     */
    private String newAccount;
    private List<Account> filterAccounts;
    private String newTag;

    /**
     * Refund status to filter on.
     * A <code>null</code> refund status means "Show All Status Types".
     */
    private RefundStatus refundStatusCode;

    /**
     * A list of PotentialRefundModel objects.
     */
    private List<PotentialRefundModel> potentialRefunds;

    /**
     * Start of the filtering date range. (Optional)
     */
    private Date filterDateFrom;

    /**
     * End of the filter date range
     */
    private Date filterDateTo;

    /**
     * A list of all Refunds displayed on the "Refund Status" tab.
     */
    private List<RefundModel> allRefunds;

    /**
     * Whether to run the Payment Application.
     */
    private boolean runPaymentApplication;

    /**
     * Type of the Date range to find transactions.
     * @see com.sigmasys.kuali.ksa.krad.util.RefundDateRangeKeyValuesFinder
     */
    private String dateRangeType;

    /**
     * Potential Refund requets summary.
     */
    private RequestPotentialRefundSummaryModel requestRefundSummary;



    public String getNewAccount() {
        return newAccount;
    }

    public void setNewAccount(String newAccount) {
        this.newAccount = newAccount;
    }

    public List<Account> getFilterAccounts() {
        return filterAccounts;
    }

    public void setFilterAccounts(List<Account> filterAccounts) {
        this.filterAccounts = filterAccounts;
    }

    public String getNewTag() {
        return newTag;
    }

    public void setNewTag(String newTag) {
        this.newTag = newTag;
    }

    public RefundStatus getRefundStatusCode() {
        return refundStatusCode;
    }

    public void setRefundStatusCode(RefundStatus refundStatusCode) {
        this.refundStatusCode = refundStatusCode;
    }

    public List<PotentialRefundModel> getPotentialRefunds() {
        return potentialRefunds;
    }

    public void setPotentialRefunds(List<PotentialRefundModel> potentialRefunds) {
        this.potentialRefunds = potentialRefunds;
    }

    public Date getFilterDateFrom() {
        return filterDateFrom;
    }

    public void setFilterDateFrom(Date filterDateFrom) {
        this.filterDateFrom = filterDateFrom;
    }

    public Date getFilterDateTo() {
        return filterDateTo;
    }

    public void setFilterDateTo(Date filterDateTo) {
        this.filterDateTo = filterDateTo;
    }

    public List<RefundModel> getAllRefunds() {
        return allRefunds;
    }

    public void setAllRefunds(List<RefundModel> allRefunds) {
        this.allRefunds = allRefunds;
    }

    public boolean isRunPaymentApplication() {
        return runPaymentApplication;
    }

    public void setRunPaymentApplication(boolean runPaymentApplication) {
        this.runPaymentApplication = runPaymentApplication;
    }

    public String getDateRangeType() {
        return dateRangeType;
    }

    public void setDateRangeType(String dateRangeType) {
        this.dateRangeType = dateRangeType;
    }

    public RequestPotentialRefundSummaryModel getRequestRefundSummary() {
        return requestRefundSummary;
    }

    public void setRequestRefundSummary(RequestPotentialRefundSummaryModel requestRefundSummary) {
        this.requestRefundSummary = requestRefundSummary;
    }
}
