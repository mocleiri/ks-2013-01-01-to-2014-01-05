package com.sigmasys.kuali.ksa.model.fm;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The incoming signup object is used to store the details of signup activity from the registration system.
 *
 * Note that we do not persist these objects. This construction is used purely to allow the transfer of
 * data from an external registration system.
 *
 * User: Sergey
 * Date: 10/8/13
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class FeeManagementIncomingSignup {

    /**
     * The identifier of the signup activity. This is a unique identifier for
     the registration activity, supplied by the registration system, which
     is the system of record for this information. Each time a student
     signs up, the registration system sends the whole activity instead
     of just the delta, so we use this identifier to tie together the
     records.
     */
    private String registrationId;

    /**
     * This date is for audit purposes only. This is the date in the
     registration that the activity was created. KSA doesn’t use this date
     directly in fee management.
     */
    private Date creationDate;

    /**
     * This is the date on which KSA registers the activity.
     */
    private Date effectiveDate;

    /**
     * This is the operation performed by the line.
     */
    private FeeManagementSignupOperation operation;

    /**
     * Type of the offering.
     */
    private OfferingType offeringType;

    /**
     * ID of the offering.
     */
    private String offeringId;

    /**
     * ATP of this offering.
     */
    private String atpId;

    /**
     * Number of units associated with the course, if applicable. KSA recognizes units as hundredths.
     */
    private Integer unit;

    /**
     * List of FeeManagementIncomingRateInfo objects.
     */
    private List<FeeManagementIncomingRateInfo> rates;


    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public FeeManagementSignupOperation getOperation() {
        return operation;
    }

    public void setOperation(FeeManagementSignupOperation operation) {
        this.operation = operation;
    }

    public OfferingType getOfferingType() {
        return offeringType;
    }

    public void setOfferingType(OfferingType offeringType) {
        this.offeringType = offeringType;
    }

    public String getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(String offeringId) {
        this.offeringId = offeringId;
    }

    public String getAtpId() {
        return atpId;
    }

    public void setAtpId(String atpId) {
        this.atpId = atpId;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public List<FeeManagementIncomingRateInfo> getRates() {
        return rates;
    }

    public void setRates(List<FeeManagementIncomingRateInfo> rates) {
        this.rates = rates;
    }
}