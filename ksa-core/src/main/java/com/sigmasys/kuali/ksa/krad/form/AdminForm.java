package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.AccountInformationHolder;
import com.sigmasys.kuali.ksa.krad.model.AccountSearchInformationHolder;
import com.sigmasys.kuali.ksa.krad.model.AccountSearchResultModel;
import com.sigmasys.kuali.ksa.model.Activity;
import com.sigmasys.kuali.ksa.model.GlTransaction;

import java.util.Date;
import java.util.List;

/**
 * Created by: dmulderink on 10/5/12 at 6:55 PM
 */
@SuppressWarnings("all")
public class AdminForm extends AbstractViewModel {
	
	/**
	 * Account information holder object
	 */
	private AccountInformationHolder accountInfo;
	
	/**
	 * Account search information holder. 
	 */
	private AccountSearchInformationHolder accountSearchInfo;
	
	/**
	 * Account search results.
	 */
	private List<AccountSearchResultModel> accountSearchResults;
	
	/**
	 * General Ledger Transactions.
	 */
	private List<GlTransaction> glTransactions;

   /*
     Activities
   */

   // a list of activities
   private List<Activity> activities;


    // Fields used to filter activities
    private Date startingDate;
    private Date endingDate;

    // drop down column keys
    private String accountStatusTypeId;
    private String accountBankTypeId;
    private String accountTaxTypeId;
    private String accountIdentityTypeId;

   /*
     Get / Set methods
   */

   	public AccountSearchInformationHolder getAccountSearchInfo() {
		return accountSearchInfo;
	}
	
	public void setAccountSearchInfo(AccountSearchInformationHolder accountSearchInfo) {
		this.accountSearchInfo = accountSearchInfo;
	}

	public List<Activity> getActivities() {
   		return activities;
   	}

   	public void setActivities(List<Activity> activities) {
   		this.activities = activities;
   	}

	public AccountInformationHolder getAccountInfo() {
		return accountInfo;
	}
	
	public void setAccountInfo(AccountInformationHolder accountInfo) {
		this.accountInfo = accountInfo;
	}

	public List<GlTransaction> getGlTransactions() {
        return glTransactions;
    }

    public void setGlTransactions(List<GlTransaction> glTransactions) {
        this.glTransactions = glTransactions;
    }

    public List<AccountSearchResultModel> getAccountSearchResults() {
		return accountSearchResults;
	}

	public void setAccountSearchResults(
			List<AccountSearchResultModel> accountSearchResults) {
		this.accountSearchResults = accountSearchResults;
	}

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public String getAccountStatusTypeId() {
        return accountStatusTypeId;
    }

    public void setAccountStatusTypeId(String accountStatusTypeId) {
        this.accountStatusTypeId = accountStatusTypeId;
    }

    public String getAccountBankTypeId() {
        return accountBankTypeId;
    }

    public void setAccountBankTypeId(String accountBankTypeId) {
        this.accountBankTypeId = accountBankTypeId;
    }

    public String getAccountTaxTypeId() {
        return accountTaxTypeId;
    }

    public void setAccountTaxTypeId(String accountTaxTypeId) {
        this.accountTaxTypeId = accountTaxTypeId;
    }

    public String getAccountIdentityTypeId() {
        return accountIdentityTypeId;
    }

    public void setAccountIdentityTypeId(String accountIdentityTypeId) {
        this.accountIdentityTypeId = accountIdentityTypeId;
    }
}
