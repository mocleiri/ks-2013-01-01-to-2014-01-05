package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.model.AccountBlockOverride;

import java.util.Date;
import java.util.List;

/**
 * Account Block Service
 * <p/>
 *
 * @author Michael Ivanov
 */
public interface AccountBlockingService {


    /**
     * Creates and persists a new instance of AccountBlockOverride in the persistent store.
     *
     * @param ruleName       BRM rule name of the account block
     * @param accountId      Account ID
     * @param expirationDate Expiration date
     * @param reason         Override reason
     * @return AccountBlockOverride instance
     */
    AccountBlockOverride createAccountBlockOverride(String ruleName, String accountId, Date expirationDate, String reason);

    /**
     * Retrieves AccountBlockOverride entity from the persistent store.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return AccountBlockOverride instance
     */
    AccountBlockOverride getAccountBlockOverride(Long blockOverrideId);

    /**
     * Returns all AccountBlockOverride objects from the persistent store.
     *
     * @return list of AccountBlockOverride instances
     */
    List<AccountBlockOverride> getAccountBlockOverrides();

    /**
     * Returns AccountBlockOverride objects for the given Account ID from the persistent store.
     *
     * @return list of AccountBlockOverride instances
     */
    List<AccountBlockOverride> getAccountBlockOverrides(String accountId);

    /**
     * Removes AccountBlockOverride entity from the persistent store by ID.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return true if AccountBlockOverride entity has been deleted
     */
    boolean deleteAccountBlockOverride(Long blockOverrideId);

    /**
     * Enables AccountBlockOverride object.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return AccountBlockOverride instance
     */
    AccountBlockOverride enableAccountBlockOverride(Long blockOverrideId);

    /**
     * Disables AccountBlockOverride object.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return AccountBlockOverride instance
     */
    AccountBlockOverride disableAccountBlockOverride(Long blockOverrideId);

}
