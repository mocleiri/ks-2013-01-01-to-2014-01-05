package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.BatchTransmissionModel;
import com.sigmasys.kuali.ksa.krad.model.GlPendingTransactionModel;

import java.util.List;

/**
 * The form object behind the "General Ledger" screen.
 * User: Sergey
 * Date: 3/12/13
 * Time: 12:11 AM
 */
public class GeneralLedgerForm extends AbstractViewModel {

    /**
     * All table rows containing information about GL Accounts
     * that have Pending Transactions.
     */
    private List<GlPendingTransactionModel> glAccountsPending;

    /**
     * All Batch Transmissions.
     */
    private List<BatchTransmissionModel> priorBatchTransmissions;

    /**
     * Formatted total amount for all GL Accounts with Pending Transactions.
     */
    private String allGlAccountsTotal;

    /**
     * Formatted total amount for all Prior Batches.
     */
    private String allPriorBatchTotal;


    public List<BatchTransmissionModel> getPriorBatchTransmissions() {
        return priorBatchTransmissions;
    }

    public List<GlPendingTransactionModel> getGlAccountsPending() {
        return glAccountsPending;
    }

    public void setGlAccountsPending(List<GlPendingTransactionModel> glAccountsPending) {
        this.glAccountsPending = glAccountsPending;
    }

    public void setPriorBatchTransmissions(List<BatchTransmissionModel> priorBatchTransmissions) {
        this.priorBatchTransmissions = priorBatchTransmissions;
    }

    public String getAllGlAccountsTotal() {
        return allGlAccountsTotal;
    }

    public void setAllGlAccountsTotal(String allGlAccountsTotal) {
        this.allGlAccountsTotal = allGlAccountsTotal;
    }

    public String getAllPriorBatchTotal() {
        return allPriorBatchTotal;
    }

    public void setAllPriorBatchTotal(String allPriorBatchTotal) {
        this.allPriorBatchTotal = allPriorBatchTotal;
    }
}
