package com.sigmasys.kuali.ksa.gwt.client.service;

import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.sigmasys.kuali.ksa.gwt.client.model.AccountModel;
import com.sigmasys.kuali.ksa.gwt.client.model.GwtError;
import com.sigmasys.kuali.ksa.gwt.client.model.SearchCriteria;

import java.util.List;

/**
 * GwtAccountService
 *
 * @author Michael Ivanov
 */
public interface GwtAccountService extends RemoteService {

    PagingLoadResult<AccountModel> findAccounts(SearchCriteria searchCriteria, String sortDir,
                                                           String sortField, int offset, int limit) throws GwtError;

    List<String> getExistingCountryCodes() throws GwtError;

    /**
     * Returns the outstanding balance for the given account
     *
     * @param userId          Account ID
     * @param ignoreDeferment boolean value
     * @return total amount of outstanding balance
     */
    Double getOutstandingBalance(String userId, boolean ignoreDeferment);

    /**
     * Returns the total balance due of all active transactions.
     *
     * @param userId          Account ID
     * @param ignoreDeferment boolean value
     * @return total amount of balance due
     */
    Double getDueBalance(String userId, boolean ignoreDeferment);

    /**
     * Returns unallocated balance for the given Account ID
     *
     * @param userId Account ID
     * @return unallocated balance
     */
    Double getUnallocatedBalance(String userId);

    /**
     * Returns the deferred amount
     *
     * @param userId Account ID
     * @return deferred amount
     */
    Double getDeferredAmount(String userId);

    /**
     * Aging debts for a chargeable account.
     *
     * @param userId          Account ID
     * @param ignoreDeferment boolean value
     * @return a chargeable account being updated
     */
    AccountModel ageDebt(String userId, boolean ignoreDeferment);

}
