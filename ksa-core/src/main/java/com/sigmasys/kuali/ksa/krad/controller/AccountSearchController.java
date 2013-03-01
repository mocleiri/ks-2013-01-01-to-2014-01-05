package com.sigmasys.kuali.ksa.krad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sigmasys.kuali.ksa.gwt.client.view.widget.value.DateRangeValue;
import com.sigmasys.kuali.ksa.krad.form.AdminForm;
import com.sigmasys.kuali.ksa.krad.util.AccountSearchInformationHolder;
import com.sigmasys.kuali.ksa.krad.util.AccountSearchResultCollectionLine;
import com.sigmasys.kuali.ksa.model.*;

/**
 * This class handles searches for a personal or organizational Accounts.
 * 
 * @author Sergey
 */
@Controller
@RequestMapping(value = "/accountSearch")
@Transactional
public class AccountSearchController extends AccountManagementController {

	
	/**
	 * Handles display of the Search Person Account page.
	 * @param form
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = "methodToCall=searchPersonAccount")
	public ModelAndView searchPersonAccount(@ModelAttribute("KualiForm") AdminForm form, HttpServletRequest request) {
		// Populate the form:
		populateForSearchPersonAccount(form);
		
		return getUIFModelAndView(form);
	}
	
	/**
	 * Handles Person Account search and redirection to the search result page.
	 * 
	 * @param form
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, params = "methodToCall=doSearchPersonAccount")
	public ModelAndView doSearchPersonAccount(@ModelAttribute("KualiForm") AdminForm form, HttpServletRequest request) {
		// TODO: Inspect the search parameters
		
		// TODO: Search for Accounts: Temporarily load all Accounts to have some data available for testing:
		List<Account> matchingAccounts = accountService.getFullAccounts();
		
		// TODO: Prepare the result:
		List<AccountSearchResultCollectionLine> accountSearchResults = prepareDisplayLines(matchingAccounts);
		
		form.setAccountSearchResults(accountSearchResults);
		
		// Navigate to the Search Result page:
		form.setPageId("SearchAccountResultsPage");
		
		return getUIFModelAndView(form);
	}


	/* *******************************************************************************************************************
	 * 
	 * Helper methods. 
	 * 
	 * ******************************************************************************************************************/
	
	/*
	 * Populates the specified form for a Search Person Account page.
	 */
	private void populateForSearchPersonAccount(AdminForm form) {
		// Populate for New Person Account first:
		populateForNewPersonAccount(form, true);
		
		// Add additional Search specific info:
		AccountSearchInformationHolder accountSearchInfo = new AccountSearchInformationHolder();
		
		accountSearchInfo.setLastNameSubstringSearch(true);
		accountSearchInfo.setDobDateRange(new DateRangeValue());
		accountSearchInfo.setLastUpdateDateRange(new DateRangeValue());
		accountSearchInfo.setCreationDateRange(new DateRangeValue());
		accountSearchInfo.setUserPreference(new UserPreference());
		accountSearchInfo.setSearchResultFields(new ArrayList<String>());
		form.setAccountSearchInfo(accountSearchInfo);
		form.getAccountInfo().setAccountType(null);
	}
	
	/**
	 * Prepares a <code>List</code> of Account search result line items suitable for display.
	 * 
	 * @param accounts	Accounts - search results to be converted to display elements.
	 * @return A <code>List</code> of display elements.
	 */
	private List<AccountSearchResultCollectionLine> prepareDisplayLines(List<Account> accounts) {
		// Create the result collection:
		List<AccountSearchResultCollectionLine> lines = new ArrayList<AccountSearchResultCollectionLine>();
		
		// Add elements to the resultant collection:
		for (Account account : accounts) {
			// Create a new line item:
			AccountSearchResultCollectionLine line = new AccountSearchResultCollectionLine();
			AccountProtectedInfo accountProtectedInfo = accountService.getAccountProtectedInfo(account.getId());
			
			line.setAccount(account);
			line.setAccountProtectedInfo(accountProtectedInfo);
			line.setDateOfBirth(getAccountDateOfBirth(account));
			lines.add(line);
		}
		
		return lines;
	}
}
