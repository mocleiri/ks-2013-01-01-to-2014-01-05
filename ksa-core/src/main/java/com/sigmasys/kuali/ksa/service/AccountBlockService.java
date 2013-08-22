package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.model.AccountBlock;

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

}
