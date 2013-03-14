package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.GeneralLedgerType;

import java.io.Serializable;

/**
 * An instance of this class represents a single row in the table of General Ledger
 * Accounts that have Pending Transactions. Each of these rows has a title, which is
 * the GL Account name, account type, DEBIT or CREDIT, and the total amount of Pending
 * Transactions.
 *
 * User: Sergey
 * Date: 3/14/13
 * Time: 12:08 AM
 */
public class GlPendingTransactionModel implements Serializable{

    /**
     * GL Account name, such as "Accounts Receivable"
     */
    private String accountName;

    /**
     * Account Type, such as "Credit" or "Debit"
     */
    private String accountType;

    /**
     * Total GL Account amount, pre-formatted.
     */
    private String formattedAmount;


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getFormattedAmount() {
        return formattedAmount;
    }

    public void setFormattedAmount(String formattedAmount) {
        this.formattedAmount = formattedAmount;
    }
}
