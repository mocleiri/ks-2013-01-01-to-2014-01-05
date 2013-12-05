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
    boolean compareRateKeyPair(String key, String value, String operator, BrmContext context);

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
    boolean accountHasFlag(String flagTypeCode, int severity, String operator, BrmContext context);

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
    boolean compareSignupOperation(String signupOperations, BrmContext context);

    /**
     * Compares the number of FeeManagementSignup objects to the given number.
     *
     * @param numberOfSignups Number of FeeManagementSignup objects in the current FeeManagementSession
     * @param context         BRM context
     * @return boolean value
     */
    boolean compareNumberOfSignups(int numberOfSignups, BrmContext context);

    /**
     * Compares the number of units to the given number.
     *
     * @param numberOfUnits Number of units
     * @param context       BRM context
     * @return boolean value
     */
    boolean compareNumberOfUnits(int numberOfUnits, BrmContext context);

    // TODO

}
