package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.KeyPair;

import java.util.List;

/**
 * The FeeManagementTermRecord will be the starting point for Fee Management. It will be from this
 * record that KSA can create a FeeManagementSession, from which KSA-FM can then start the processing.
 * This is the DTO required to start the fee management process.
 *
 * Note that we do not persist these objects. This construction is used purely to allow the transfer of
 * data from an external registration system.
 *
 * User: Sergey
 * Date: 10/8/13
 * Time: 12:23 AM
 */
public class FeeManagementTermRecord {

    /**
     * The identifier for the account to be charged.
     */
    private String accountId;

    /**
     * This is the status of the session. It can be SIMULATED or CURRENT.
     * @see FeeManagementSessionStatus#SIMULATED
     * @see FeeManagementSessionStatus#CURRENT
     */
    private FeeManagementSessionStatus fmSessionStatus;

    /**
     * The ATP identifier for the whole session.
     */
    private String atpId;

    /**
     * List of session keypairs. This is where registration information (or
     * what if information) can be passed to KSA.
     */
    private List<KeyPair> keyPairs;

    /**
     * List of major codes from the registration system.
     */
    private List<String> majorCodes;

    /**
     * List of cohort codes form the registration system.
     */
    private List<String> cohortCodes;

    /**
     * List of signup objects (the registration activity).
     */
    private List<FeeManagementIncomingSignup> incomingSignups;


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public FeeManagementSessionStatus getFmSessionStatus() {
        return fmSessionStatus;
    }

    public void setFmSessionStatus(FeeManagementSessionStatus fmSessionStatus) {
        this.fmSessionStatus = fmSessionStatus;
    }

    public String getAtpId() {
        return atpId;
    }

    public void setAtpId(String atpId) {
        this.atpId = atpId;
    }

    public List<KeyPair> getKeyPairs() {
        return keyPairs;
    }

    public void setKeyPairs(List<KeyPair> keyPairs) {
        this.keyPairs = keyPairs;
    }

    public List<String> getMajorCodes() {
        return majorCodes;
    }

    public void setMajorCodes(List<String> majorCodes) {
        this.majorCodes = majorCodes;
    }

    public List<String> getCohortCodes() {
        return cohortCodes;
    }

    public void setCohortCodes(List<String> cohortCodes) {
        this.cohortCodes = cohortCodes;
    }

    public List<FeeManagementIncomingSignup> getIncomingSignups() {
        return incomingSignups;
    }

    public void setIncomingSignups(List<FeeManagementIncomingSignup> incomingSignups) {
        this.incomingSignups = incomingSignups;
    }
}
