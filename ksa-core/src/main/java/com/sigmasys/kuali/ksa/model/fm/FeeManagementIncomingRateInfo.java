package com.sigmasys.kuali.ksa.model.fm;

/**
 * The FeeManagementIncomingRateInfo object is used to store the details of Rate from the registration system.
 * When this is translated into a session, the Rate will be converted to the appropriate ID.
 *
 * User: Sergey
 * Date: 10/8/13
 * Time: 12:43 AM
 */
public class FeeManagementIncomingRateInfo {

    /**
     * Code for the attached Rate.
     */
    private String rateCode;

    /**
     * Subcode for the attached rate.
     */
    private String rateSubcode;


    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getRateSubcode() {
        return rateSubcode;
    }

    public void setRateSubcode(String rateSubcode) {
        this.rateSubcode = rateSubcode;
    }
}
