package com.sigmasys.kuali.ksa.gwt.client.model;

import java.util.Date;

/**
 * KSA GWT Account model
 * <p/>
 * <p/>
 *
 * @author Michael Ivanov
 *         Date: 3/13/12
 *         Time: 3:56 PM
 */
public class AccountModel extends AbstractModel {

    // The search criteria keys
    public static final String ID = "account.id";
    public static final String ENTITY_ID = "account.entityId";
    public static final String CREATION_DATE = "account.creationDate";
    public static final String LAST_KIM_UPDATE = "account.lastKimUpdate";
    public static final String IS_KIM_ACCOUNT = "account.isKimAccount";
    public static final String CREDIT_LIMIT = "account.creditLimit";
    public static final String FIRST_NAME = "person.firstName";
    public static final String MIDDLE_NAME = "person.middleName";
    public static final String LAST_NAME = "person.lastName";
    public static final String EMAIL_ADDRESS = "contact.emailAddress";
    public static final String PHONE_NUMBER = "contact.phoneNumber";
    public static final String COUNTRY = "address.country";
    public static final String POSTAL_CODE = "address.postalCode";
    public static final String STATE = "address.state";
    public static final String CITY = "address.city";


    // The real column names
    public static final String COLUMN_ID = "account_id";
    public static final String COLUMN_ENTITY_ID = "entity_id";
    public static final String COLUMN_CREATION_DATE = "creation_date";
    public static final String COLUMN_LAST_KIM_UPDATE = "last_kim_update";
    public static final String COLUMN_IS_KIM_ACCOUNT = "is_kim_account";
    public static final String COLUMN_CREDIT_LIMIT = "credit_limit";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_MIDDLE_NAME = "middle_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_EMAIL_ADDRESS = "email_address";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_COUNTRY = "country";
    public static final String COLUMN_POSTAL_CODE = "postal_code";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STREET_ADDRESS = "street_address";


    private Integer daysLate1;
    private Integer daysLate2;
    private Integer daysLate3;

    private Double amountLate1;
    private Double amountLate2;
    private Double amountLate3;

    private Date lateLastUpdate;


    public String getId() {
        return get(COLUMN_ID);
    }

    public void setId(String id) {
        set(COLUMN_ID, id);
    }


    public String getEntityId() {
        return get(COLUMN_ENTITY_ID);
    }

    public void setEntityId(String entityId) {
        set(COLUMN_ENTITY_ID, entityId);
    }

    public Date getCreationDate() {
        return get(COLUMN_CREATION_DATE);
    }

    public void setCreationDate(Date creationDate) {
        set(COLUMN_CREATION_DATE, creationDate);
    }

    public Date getLastKimUpdate() {
        return get(COLUMN_LAST_KIM_UPDATE);
    }

    public void setLastKimUpdate(Date lastKimUpdate) {
        set(COLUMN_LAST_KIM_UPDATE, lastKimUpdate);
    }

    public Boolean isKimAccount() {
        return get(COLUMN_IS_KIM_ACCOUNT);
    }

    public void setKimAccount(Boolean kimAccount) {
        set(COLUMN_IS_KIM_ACCOUNT, kimAccount);
    }

    public Double getCreditLimit() {
        return get(COLUMN_CREDIT_LIMIT);
    }

    public void setCreditLimit(Double creditLimit) {
        set(COLUMN_CREDIT_LIMIT, creditLimit);
    }

    public String getFirstName() {
        return get(COLUMN_FIRST_NAME);
    }

    public void setFirstName(String firstName) {
        set(COLUMN_FIRST_NAME, firstName);
    }

    public String getMiddleName() {
        return get(COLUMN_MIDDLE_NAME);
    }

    public void setMiddleName(String middleName) {
        set(COLUMN_MIDDLE_NAME, middleName);
    }

    public String getLastName() {
        return get(COLUMN_LAST_NAME);
    }

    public void setLastName(String lastName) {
        set(COLUMN_LAST_NAME, lastName);
    }

    public String getEmailAddress() {
        return get(COLUMN_EMAIL_ADDRESS);
    }

    public void setEmailAddress(String emailAddress) {
        set(COLUMN_EMAIL_ADDRESS, emailAddress);
    }

    public String getPhoneNumber() {
        return get(COLUMN_PHONE_NUMBER);
    }

    public void setPhoneNumber(String phoneNumber) {
        set(COLUMN_PHONE_NUMBER, phoneNumber);
    }

    public String getCountry() {
        return get(COLUMN_COUNTRY);
    }

    public void setCountry(String country) {
        set(COLUMN_COUNTRY, country);
    }

    public String getPostalCode() {
        return get(COLUMN_POSTAL_CODE);
    }

    public void setPostalCode(String postalCode) {
        set(COLUMN_POSTAL_CODE, postalCode);
    }

    public String getState() {
        return get(COLUMN_STATE);
    }

    public void setState(String state) {
        set(COLUMN_STATE, state);
    }

    public String getCity() {
        return get(COLUMN_CITY);
    }

    public void setCity(String city) {
        set(COLUMN_CITY, city);
    }

    public String getStreetAddress() {
        return get(COLUMN_STREET_ADDRESS);
    }

    public void setStreetAddress(String streetAddress) {
        set(COLUMN_STREET_ADDRESS, streetAddress);
    }

    ////////////////

    public Integer getDaysLate1() {
        return daysLate1;
    }

    public void setDaysLate1(Integer daysLate1) {
        this.daysLate1 = daysLate1;
    }

    public Integer getDaysLate2() {
        return daysLate2;
    }

    public void setDaysLate2(Integer daysLate2) {
        this.daysLate2 = daysLate2;
    }

    public Integer getDaysLate3() {
        return daysLate3;
    }

    public void setDaysLate3(Integer daysLate3) {
        this.daysLate3 = daysLate3;
    }

    public Double getAmountLate1() {
        return amountLate1;
    }

    public void setAmountLate1(Double amountLate1) {
        this.amountLate1 = amountLate1;
    }

    public Double getAmountLate2() {
        return amountLate2;
    }

    public void setAmountLate2(Double amountLate2) {
        this.amountLate2 = amountLate2;
    }

    public Double getAmountLate3() {
        return amountLate3;
    }

    public void setAmountLate3(Double amountLate3) {
        this.amountLate3 = amountLate3;
    }

    public Date getLateLastUpdate() {
        return lateLastUpdate;
    }

    public void setLateLastUpdate(Date lateLastUpdate) {
        this.lateLastUpdate = lateLastUpdate;
    }
}
