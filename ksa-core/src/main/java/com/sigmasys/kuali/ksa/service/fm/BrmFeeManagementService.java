package com.sigmasys.kuali.ksa.service.fm;

import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.service.brm.BrmContext;


/**
 * BRM FeeManagementService.
 * <p/>
 * This interface defines the new methods used by Fee Management rules based on the FM DSL mapping.
 *
 * @author Michael Ivanov
 */

public interface BrmFeeManagementService {

    /**
     * Executes the rule-based logic to assess fees for the given Account and ATP IDs.
     *
     * @param accountId Account ID
     * @param atpId     ATP ID
     * @return FeeManagementManifest instance
     */
    FeeManagementManifest assessFees(String accountId, String atpId);

    /**
     * Compares the value of the Account KeyPair specified by "key" to the given "value".
     *
     * @param key      KeyPair's key
     * @param value    Value to compare
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return true if the KeyPair's value satisfies the given value and relational operator, false - otherwise.
     */
    boolean compareAccountKeyPair(String key, String value, String operator, BrmContext context);

    /**
     * Compares the value of the FeeManagementSession KeyPair specified by "key" to the given "value".
     *
     * @param key      KeyPair's key
     * @param value    Value to compare
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return true if the KeyPair's value satisfies the given value and relational operator, false - otherwise.
     */
    boolean compareSessionKeyPair(String key, String value, String operator, BrmContext context);

    /**
     * Compares the value of any FeeManagementSignup KeyPair specified by "key" to the given "value".
     *
     * @param key      KeyPair's key
     * @param value    Value to compare
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return true if the KeyPair's value satisfies the given value and relational operator, false - otherwise.
     */
    boolean compareSignupKeyPair(String key, String value, String operator, BrmContext context);

    /**
     * Compares the value of any FeeManagementSignup's Rate KeyPair specified by "key" to the given "value".
     *
     * @param key      KeyPair's key
     * @param value    Value to compare
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return true if the KeyPair's value satisfies the given value and relational operator, false - otherwise.
     */
    boolean compareSignupRateKeyPair(String key, String value, String operator, BrmContext context);

    /**
     * Compares the current account type code to the given value.
     *
     * @param accountTypeCode AccountType code
     * @param operator        Relational operator. For example, "==" or "!="
     * @param context         BRM context
     * @return boolean value
     */
    boolean compareAccountType(String accountTypeCode, String operator, BrmContext context);

    /**
     * Compares the current account status type code to the given value.
     *
     * @param accountStatusCode AccountStatusType code
     * @param operator          Relational operator. For example, "==" or "!="
     * @param context           BRM context
     * @return boolean value
     */
    boolean compareAccountStatus(String accountStatusCode, String operator, BrmContext context);

    /**
     * Compares the FeeManagementSession ATP ID to the given value.
     *
     * @param atpId    ATP ID
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return boolean value
     */
    boolean compareSessionAtp(String atpId, String operator, BrmContext context);

    /**
     * Checks if the account has a flag specified by FlagType code with the given severity value.
     *
     * @param flagTypeCode FlagType code
     * @param severity     Severity value
     * @param operator     Relational operator. For example, "==" or "!="
     * @param context      BRM context
     * @return boolean value
     */
    boolean accountHasFlag(String flagTypeCode, Integer severity, String operator, BrmContext context);

    /**
     * Compares the FeeManagementSession ATP ID to the given value.
     *
     * @param holdIssueName HoldIssue name
     * @param context       BRM context
     * @return boolean value
     */
    boolean accountHasAppliedHold(String holdIssueName, BrmContext context);

    /**
     * Compares the FeeManagementSignup operation to the list of values separated by "," in one line.
     *
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     * @return boolean value
     */
    boolean compareSignupOperations(String signupOperations, BrmContext context);

    /**
     * Compares the FeeManagementSignup effective date to the given date.
     *
     * @param date     Date in "MM/dd/yyyy"format
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return boolean value
     */
    boolean compareSignupEffectiveDate(String date, String operator, BrmContext context);

    /**
     * Compares the FeeManagementSignup effective date to the signup or session ATP milestone.
     *
     * @param milestoneName Milestone name
     * @param operator      Relational operator. For example, "==" or "!="
     * @param context       BRM context
     * @return boolean value
     */
    boolean compareSignupEffectiveDateToAtpMilestone(String milestoneName, String operator, BrmContext context);

    /**
     * Compares the number of FeeManagementSignup objects to the given number.
     *
     * @param numberOfSignups  Number of FeeManagementSignup objects in the current FeeManagementSession
     * @param rateCodes        List of Rate codes separated by ","
     * @param rateTypeCodes    List of RateType codes separated by ","
     * @param signupOperations List of signup operation values separated by ","
     * @param operator         Relational operator. For example, "==" or "!="
     * @param context          BRM context
     * @return boolean value
     */
    boolean compareNumberOfSignups(int numberOfSignups, String rateCodes, String rateTypeCodes,
                                   String signupOperations, String operator, BrmContext context);

    /**
     * Compares the number of units to the given number.
     *
     * @param numberOfUnits    Number of units in the current FeeManagementSession
     * @param rateCodes        List of Rate codes separated by ","
     * @param rateTypeCodes    List of RateType codes separated by ","
     * @param signupOperations List of signup operation values separated by ","
     * @param operator         Relational operator. For example, "==" or "!="
     * @param context          BRM context
     * @return boolean value
     */
    boolean compareNumberOfUnits(int numberOfUnits, String rateCodes, String rateTypeCodes,
                                 String signupOperations, String operator, BrmContext context);

    /**
     * Compares the number of units to the number of units of taken signups.
     *
     * @param rateCodes      List of Rate codes of all signups separated by ","
     * @param takenRateCodes List of Rate codes of taken signups separated by ","
     * @param operator       Relational operator. For example, "==" or "!="
     * @param context        BRM context
     * @return boolean value
     */
    boolean compareNumberOfTakenUnits(String rateCodes, String takenRateCodes, String operator, BrmContext context);

    /**
     * Compares the amount of all session signups to the amount of taken signups.
     *
     * @param rateCodes      List of Rate codes of all signups separated by ","
     * @param takenRateCodes List of Rate codes of taken signups separated by ","
     * @param operator       Relational operator. For example, "==" or "!="
     * @param context        BRM context
     * @return boolean value
     */
    boolean compareAmountOfTakenSignups(String rateCodes, String takenRateCodes, String operator, BrmContext context);

    /**
     * Checks if the current signup in the context is taken.
     *
     * @param context BRM context
     * @return boolean value
     */
    boolean signupIsTaken(BrmContext context);

    /**
     * Checks if the current signup in the context is complete.
     *
     * @param context BRM context
     * @return boolean value
     */
    boolean signupIsComplete(BrmContext context);

    /**
     * Checks if the signup has rates specified by the codes.
     *
     * @param rateCodes List of Rate codes separated by ","
     * @param context   BRM context
     * @return boolean value
     */
    boolean signupHasRates(String rateCodes, BrmContext context);

    /**
     * Checks if the signup has rate types specified by the codes.
     *
     * @param rateTypeCodes List of RateType codes separated by ","
     * @param context       BRM context
     * @return boolean value
     */
    boolean signupHasRateTypes(String rateTypeCodes, BrmContext context);

    /**
     * Checks if the signup has rate catalogs specified by the codes.
     *
     * @param rateCatalogCodes List of RateCatalog codes separated by ","
     * @param context          BRM context
     * @return boolean value
     */
    boolean signupHasRateCatalogs(String rateCatalogCodes, BrmContext context);

    /**
     * Checks if the signup has Offering IDs.
     *
     * @param offeringIds List of Offering IDs separated by ","
     * @param context     BRM context
     * @return boolean value
     */
    boolean signupHasOfferingIds(String offeringIds, BrmContext context);

    /**
     * Checks if the signup has Offering Types.
     *
     * @param offeringTypes List of OfferingType values by ","
     * @param context       BRM context
     * @return boolean value
     */
    boolean signupHasOfferingTypes(String offeringTypes, BrmContext context);


    // TODO

    // RHS method declarations

    /**
     * Sets an Account KeyPair specified by "key" and "value".
     *
     * @param key     KeyPair key
     * @param value   KeyPair value
     * @param context BRM context
     */
    void setAccountKeyPair(String key, String value, BrmContext context);

    /**
     * Sets a FeeManagementSession KeyPair specified by "key" and "value".
     *
     * @param key     KeyPair key
     * @param value   KeyPair value
     * @param context BRM context
     */
    void setSessionKeyPair(String key, String value, BrmContext context);

    /**
     * Sets a FeeManagementSession KeyPair specified by "key" to the unit number of signups with
     * "includedSignupOperations" minus "excludedSignupOperations"
     *
     * @param key                      KeyPair key
     * @param includedSignupOperations List of included signup operation values separated by ","
     * @param excludedSignupOperations List of excluded signup operation values separated by ","
     * @param context                  BRM context
     */
    void setSessionKeyPairToUnitNumber(String key,
                                       String includedSignupOperations,
                                       String excludedSignupOperations,
                                       BrmContext context);

    /**
     * Sets a FeeManagementSession KeyPair specified by "key" to the unit number of signups on which a boolean method
     * specified by "signupBooleanMethod" method name returns true.
     * It throws IllegalArgumentException if the boolean method does not exist or returns a non-boolean value.
     *
     * @param key                 KeyPair key
     * @param signupBooleanMethod The name of the boolean method on FeeManagementSignup class.
     * @param context             BRM context
     * @throws IllegalArgumentException
     */
    void setSessionKeyPairToUnitNumberWithSignupMethod(String key, String signupBooleanMethod, BrmContext context);

    /**
     * Sets a FeeManagementSignup KeyPair specified by "key" and "value".
     *
     * @param key     KeyPair key
     * @param value   KeyPair value
     * @param context BRM context
     */
    void setSignupKeyPair(String key, String value, BrmContext context);

    /**
     * Sets "isReviewRequired" to true or false on FeeManagementSession.
     *
     * @param isReviewRequired Boolean value
     * @param context          BRM context
     */
    void setSessionReviewRequired(boolean isReviewRequired, BrmContext context);

    /**
     * Sets "isReviewComplete" to true or false on FeeManagementSession.
     *
     * @param isReviewComplete Boolean value
     * @param context          BRM context
     */
    void setSessionReviewComplete(boolean isReviewComplete, BrmContext context);

    /**
     * Sets "isComplete" to true or false on FeeManagementSignup.
     *
     * @param isComplete Boolean value
     * @param context    BRM context
     */
    void setSignupComplete(boolean isComplete, BrmContext context);

    /**
     * Sets "isComplete" to true or false on all FeeManagementSignup objects from FeeManagementSession
     * that have certain signup operations.
     *
     * @param isComplete       Boolean value
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     */
    void setSessionSignupsComplete(boolean isComplete, String signupOperations, BrmContext context);

    /**
     * Sets "isTaken" to true or false on FeeManagementSignup.
     *
     * @param isTaken Boolean value
     * @param context BRM context
     */
    void setSignupTaken(boolean isTaken, BrmContext context);

    /**
     * Sets "isTaken" to true or false on all FeeManagementSignup objects from FeeManagementSession
     * that have certain signup operations.
     *
     * @param isTaken          Boolean value
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     */
    void setSessionSignupsTaken(boolean isTaken, String signupOperations, BrmContext context);

    /**
     * Sets "isComplete" to true or false on all preceding FeeManagementSignup objects from FeeManagementSession
     * that have certain signup operations with the same Offering ID.
     *
     * @param isComplete       Boolean value
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     */
    void setPrecedingOfferingsComplete(boolean isComplete, String signupOperations, BrmContext context);

    /**
     * Sets "isTaken" to true or false on all preceding FeeManagementSignup objects from FeeManagementSession
     * that have certain signup operations with the same Offering ID.
     *
     * @param isTaken          Boolean value
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     */
    void setPrecedingOfferingsTaken(boolean isTaken, String signupOperations, BrmContext context);

    /**
     * Removes all rates on the current signup and all preceding signups (offerings) based on the given parameters.
     *
     * @param rateCodes            List of rate codes separated by ","
     * @param rateTypeCodes        List of rate type codes separated by ","
     * @param rateCatalogCodes     List of rate catalog codes separated by ","
     * @param removeFromSignupOnly If true the rates will be removed from the signup only
     * @param context              BRM context
     */
    void removeRatesFromSignupAndPrecedingOfferings(String rateCodes,
                                                    String rateTypeCodes,
                                                    String rateCatalogCodes,
                                                    boolean removeFromSignupOnly,
                                                    BrmContext context);

    /**
     * Adds a rate to a FeeManagementSignup object from the BRM context.
     *
     * @param rateCode    Rate code
     * @param rateSubCode Rate sub-code
     */
    void addRateToSignup(String rateCode, String rateSubCode, BrmContext context);

    /**
     * Replaces a rate on FeeManagementSignup object with the new rate specified by code and sub-code.
     *
     * @param rateCode       Code of the rate to be replaced
     * @param rateSubCode    Sub-code of the rate to be replaced
     * @param newRateCode    Code of the new rate
     * @param newRateSubCode Sub-code of the new rate
     */
    void replaceRateOnSignup(String rateCode, String rateSubCode, String newRateCode, String newRateSubCode, BrmContext context);

    /**
     * Charges rates on the manifests from FeeManagementSession.
     *
     * @param rateCodes        List of rate codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    void chargeManifestRates(String rateCodes, String rateTypeCodes, String rateCatalogCodes, BrmContext context);


}
