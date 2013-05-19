package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.PotentialRefund;
import com.sigmasys.kuali.ksa.krad.model.RefundModel;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.RefundStatus;
import com.sigmasys.kuali.ksa.model.Tag;

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
    private List<Tag> tags;

    /**
     * Refund status to filter on.
     * A <code>null</code> refund status means "Show All Status Types".
     */
    private RefundStatus refundStatus;

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



    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public RefundStatus getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(RefundStatus refundStatus) {
        this.refundStatus = refundStatus;
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
}
