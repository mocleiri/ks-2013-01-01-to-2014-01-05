package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.PotentialRefund;
import com.sigmasys.kuali.ksa.krad.model.RefundModel;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.RefundStatus;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 5/18/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountRefundForm extends AbstractViewModel {


    /**
     * Account associated with this form.
     */
    private Account account;

    /**
     * All possible values of Tag entity to filter on.
     */
    private List<String> filterTags;

    /**
     * Refund status to filter on.
     * A <code>null</code> refund status means "Show All Status Types".
     */
    private RefundStatus refundStatusCode;

    /**
     * A list of PotentialRefund objects.
     */
    private List<PotentialRefund> potentialRefunds;

    /**
     * A list of all Refunds displayed on the "Refund Status" tab.
     */
    private List<RefundModel> allRefunds;

    /**
     * Whether to run the Payment Application.
     */
    private boolean runPaymentApplication;

    /**
     * Whether the "Run Payment Application" checkbox is enabled.
     */
    private boolean runPaymentApplicationEnabled;

    /**
     * Type of the Date range to find transactions.
     * @see com.sigmasys.kuali.ksa.krad.util.RefundDateRangeKeyValuesFinder
     */
    private String dateRangeType;

    /**
     * Start of the filtering date range. (Optional)
     */
    private Date filterDateFrom;

    /**
     * End of the filter date range
     */
    private Date filterDateTo;



    public String getDateRangeType() {
        return dateRangeType;
    }

    public void setDateRangeType(String dateRangeType) {
        this.dateRangeType = dateRangeType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<String> getFilterTags() {
        return filterTags;
    }

    public void setFilterTags(List<String> filterTags) {
        this.filterTags = filterTags;
    }

    public RefundStatus getRefundStatusCode() {
        return refundStatusCode;
    }

    public void setRefundStatusCode(RefundStatus refundStatusCode) {
        this.refundStatusCode = refundStatusCode;
    }

    public List<PotentialRefund> getPotentialRefunds() {
        return potentialRefunds;
    }

    public void setPotentialRefunds(List<PotentialRefund> potentialRefunds) {
        this.potentialRefunds = potentialRefunds;
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

    public boolean isRunPaymentApplicationEnabled() {
        return runPaymentApplicationEnabled;
    }

    public void setRunPaymentApplicationEnabled(boolean runPaymentApplicationEnabled) {
        this.runPaymentApplicationEnabled = runPaymentApplicationEnabled;
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
}
