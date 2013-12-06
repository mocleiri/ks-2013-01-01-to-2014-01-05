package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.RateTypeModel;
import com.sigmasys.kuali.ksa.model.fm.RateType;

import java.util.List;

/**
 * This is a form object behind the "Rate Types" page.
 *
 * User: Sergey
 * Date: 12/4/13
 * Time: 10:40 PM
 */
public class RateTypeForm extends AbstractViewModel {

    /**
     * A List of all RateType objects.
     */
    private List<RateTypeModel> rateTypes;

    /**
     * Search String to find RateTypes using wildcards.
     */
    private String searchString;

    /**
     * Error message.
     */
    private String errorMessage;


    public List<RateTypeModel> getRateTypes() {
        return rateTypes;
    }

    public void setRateTypes(List<RateTypeModel> rateTypes) {
        this.rateTypes = rateTypes;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
