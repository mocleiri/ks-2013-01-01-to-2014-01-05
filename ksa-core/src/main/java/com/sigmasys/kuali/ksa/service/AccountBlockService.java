package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.model.AccountBlock;
import com.sigmasys.kuali.ksa.model.AccountBlockOverride;

import java.util.Date;
import java.util.List;

/**
 * Account Block Service
 * <p/>
 *
 * @author Michael Ivanov
 */
public interface AccountBlockService {


    /**
     * Creates and persists a new instance of AccountBlock based on the given parameters.
     *
     * @param code        AccountBlock code
     * @param name        AccountBlock name
     * @param description AccountBlock description
     * @return AccountBlock instance
     */
    AccountBlock createAccountBlock(String code, String name, String description);

    /**
     * Persists AccountBlock instance in the persistent store
     *
     * @param accountBlock AccountBlock instance
     * @return AccountBlock ID
     */
    Long persistAccountBlock(AccountBlock accountBlock);

    /**
     * Removes AccountBlock entity from the persistent store by ID.
     *
     * @param accountBlockId AccountBlock ID
     * @return true if AccountBlock entity has been deleted
     */
    boolean deleteAccountBlock(Long accountBlockId);

    /**
     * Retrieves AccountBlock entity by ID from the persistent store.
     *
     * @param accountBlockId AccountBlock ID
     * @return AccountBlock instance
     */
    AccountBlock getAccountBlock(Long accountBlockId);

    /**
     * Returns all account blocks from the persistent store sorted by code in the ascending order.
     *
     * @return list of AccountBlock instances
     */
    List<AccountBlock> getAccountBlocks();

    /**
     * Creates and persists a new instance of AccountBlockOverride in the persistent store.
     *
     * @param accountBlockId AccountBlock ID
     * @param accountId      Account ID
     * @param expirationDate Expiration date
     * @param reason         Override reason
     * @param isSingleUse    Indicates whether AccountBlockOverride is for single use
     * @return AccountBlockOverride instance
     */
    AccountBlockOverride createAccountBlockOverride(Long accountBlockId, String accountId, Date expirationDate,
                                                    String reason, boolean isSingleUse);

    /**
     * Creates and persists an administrative account block override in the persistent store.
     *
     * @param accountId      Account ID
     * @param expirationDate Expiration date
     * @param reason         Override reason
     * @return AccountBlockOverride instance
     */
    AccountBlockOverride createAdminAccountBlockOverride(String accountId, Date expirationDate, String reason);

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
     * Releases AccountBlockOverride object.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return AccountBlockOverride instance
     */
    AccountBlockOverride releaseAccountBlockOverride(Long blockOverrideId);

}
