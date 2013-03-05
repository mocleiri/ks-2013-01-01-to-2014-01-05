package com.sigmasys.kuali.ksa.krad.model;

import java.io.Serializable;
import java.util.List;

import com.sigmasys.kuali.ksa.gwt.client.view.widget.value.DateRangeValue;
import com.sigmasys.kuali.ksa.model.UserPreference;

/**
 * Account Search information holder.
 * 
 * @author Sergey Godunov
 *
 */
@SuppressWarnings("serial")
public class AccountSearchInformationHolder implements Serializable {
	
	private UserPreference userPreference;
	private DateRangeValue dobDateRange;
	private DateRangeValue creationDateRange;
	private DateRangeValue lastUpdateDateRange;
	private Boolean lastNameSubstringSearch;
	private List<String> searchResultFields;
	
	
	public DateRangeValue getDobDateRange() {
		return dobDateRange;
	}
	public void setDobDateRange(DateRangeValue dobDateRange) {
		this.dobDateRange = dobDateRange;
	}
	public DateRangeValue getCreationDateRange() {
		return creationDateRange;
	}
	public void setCreationDateRange(DateRangeValue creationDateRange) {
		this.creationDateRange = creationDateRange;
	}
	public DateRangeValue getLastUpdateDateRange() {
		return lastUpdateDateRange;
	}
	public void setLastUpdateDateRange(DateRangeValue lastUpdateDateRange) {
		this.lastUpdateDateRange = lastUpdateDateRange;
	}
	public UserPreference getUserPreference() {
		return userPreference;
	}
	public void setUserPreference(UserPreference userPreference) {
		this.userPreference = userPreference;
	}
	public Boolean getLastNameSubstringSearch() {
		return lastNameSubstringSearch;
	}
	public void setLastNameSubstringSearch(Boolean lastNameSubstringSearch) {
		this.lastNameSubstringSearch = lastNameSubstringSearch;
	}
	public List<String> getSearchResultFields() {
		return searchResultFields;
	}
	public void setSearchResultFields(List<String> searchResultFields) {
		this.searchResultFields = searchResultFields;
	}
}