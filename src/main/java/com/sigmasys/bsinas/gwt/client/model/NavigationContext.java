package com.sigmasys.bsinas.gwt.client.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * NavigationContext is a data model that holds the search criteria and
 * other context attributes to facilitate parameters exchange between
 * various KSA UI components
 *
 * @author Michael Ivanov
 *         Date: 5/17/12
 */
public class NavigationContext implements Serializable {

    private SearchCriteria searchCriteria;
    private final HashMap<String, Serializable> attributes = new HashMap<String, Serializable>();

    public static NavigationContext getDefaultContext() {
        return new NavigationContext();
    }

    public NavigationContext() {
    }

    public NavigationContext(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * @return the searchCriteria
     */
    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * @param searchCriteria the searchCriteria to set
     */
    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public void setAttribute(String key, Serializable value) {
        attributes.put(key, value);
    }

    public Serializable getAttribute(String key) {
        return attributes.get(key);
    }
}