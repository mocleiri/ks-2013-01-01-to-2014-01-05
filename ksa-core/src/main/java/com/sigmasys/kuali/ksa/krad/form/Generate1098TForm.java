package com.sigmasys.kuali.ksa.krad.form;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Irs1098T;

/**
 * This class serves as a form behind the "Generate 1098T" screen. 
 * 
 * @author Sergey
 */
@SuppressWarnings("serial")
public class Generate1098TForm extends AbstractViewModel {

	/**
	 * Account associated with the 1098T View.
	 */
	private Account account;
	
	/**
	 * A List of reporting years. Multiple selection is allowed. 
	 */
	private List<String> reportYears;
	
	/**
	 * Generated Forms 1098T for the search by account.
	 */
	private List<Irs1098T> generatedForms1098T;
	

	/**
	 * Returns the page header, which defaults to the Account holder's name.
	 * 
	 * @return Page header.
	 */
	public String getPageHeader() {
		return (account != null) && (account.getDefaultPersonName() != null) 
				? account.getDefaultPersonName().getDisplayValue() : "Generate 1098T";
	}
	
	/**
	 * Returns CSS display style of Address Line 2.
	 * 
	 * @return CSS display style of Address Line 2. 
	 */
	public String getAddressLine2DisplayStyle() {
		return (account != null) && (account.getDefaultPostalAddress() != null) && StringUtils.isNotBlank(account.getDefaultPostalAddress().getStreetAddress2()) ? "inline-block" : "none";
	}
	
	/**
	 * Returns CSS display style of Address Line 3.
	 * 
	 * @return CSS display style of Address Line 3. 
	 */
	public String getAddressLine3DisplayStyle() {
		return (account != null) && (account.getDefaultPostalAddress() != null) && StringUtils.isNotBlank(account.getDefaultPostalAddress().getStreetAddress3()) ? "inline-block" : "none";
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<String> getReportYears() {
		return reportYears;
	}

	public void setReportYears(List<String> reportYears) {
		this.reportYears = reportYears;
	}

	public List<Irs1098T> getGeneratedForms1098T() {
		return generatedForms1098T;
	}

	public void setGeneratedForms1098T(List<Irs1098T> generatedForms1098T) {
		this.generatedForms1098T = generatedForms1098T;
	}
}
