package com.sigmasys.kuali.ksa.krad.form;

import java.util.List;

import com.sigmasys.kuali.ksa.krad.model.AccountInformationHolder;
import com.sigmasys.kuali.ksa.krad.model.AccountSearchInformationHolder;
import com.sigmasys.kuali.ksa.krad.model.AccountSearchResultModel;
import com.sigmasys.kuali.ksa.model.*;

/**
 * Created by: dmulderink on 10/5/12 at 6:55 PM
 */
@SuppressWarnings("all")
public class AdminForm extends AbstractViewModel {
	
	/**
	 * Account for creation or editing.
	 */
	private Account account;
	
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

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
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
}
