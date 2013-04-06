package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.BatchTransmissionModel;
import com.sigmasys.kuali.ksa.krad.model.GlPendingTransactionModel;
import com.sigmasys.kuali.ksa.model.Account;

import java.util.List;

/**
 * Created by: dmulderink on 10/6/12 at 2:23 PM
 */
public class ReportReconciliationForm extends AbstractViewModel {

   private Account account;


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


    public List<GlPendingTransactionModel> getGlAccountsPending() {
        return glAccountsPending;
    }

    public void setGlAccountsPending(List<GlPendingTransactionModel> glAccountsPending) {
        this.glAccountsPending = glAccountsPending;
    }

    public List<BatchTransmissionModel> getPriorBatchTransmissions() {
        return priorBatchTransmissions;
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

    public Account getAccount() {
      return account;
   }

   public void setAccount(Account account) {
      this.account = account;
   }
}
