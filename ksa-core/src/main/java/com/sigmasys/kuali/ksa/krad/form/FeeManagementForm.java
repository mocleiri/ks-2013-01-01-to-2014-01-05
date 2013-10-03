package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.model.fm.Rate;
import com.sigmasys.kuali.ksa.model.fm.RateType;

import java.util.List;

/**
 * User: tbornholtz
 * Date: 10/3/13
 */
public class FeeManagementForm extends AbstractViewModel {

    private List<RateType> rateTypes;
    private List<Rate> rates;



    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public List<RateType> getRateTypes() {
        return rateTypes;
    }

    public void setRateTypes(List<RateType> rateTypes) {
        this.rateTypes = rateTypes;
    }
}
