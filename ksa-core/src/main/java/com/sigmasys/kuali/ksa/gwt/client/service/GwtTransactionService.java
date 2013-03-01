package com.sigmasys.kuali.ksa.gwt.client.service;

import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.sigmasys.kuali.ksa.gwt.client.model.GwtError;
import com.sigmasys.kuali.ksa.gwt.client.model.SearchCriteria;
import com.sigmasys.kuali.ksa.gwt.client.model.TransactionModel;

import java.util.Date;
import java.util.List;


/**
 * GwtTransactionService
 *
 * @author Michael Ivanov
 */
public interface GwtTransactionService extends RemoteService {

    PagingLoadResult<TransactionModel> findTransactions(SearchCriteria searchCriteria, String sortDir,
                                                        String sortField, int offset, int limit) throws GwtError;

    List<String> getExistingCurrencyCodes() throws GwtError;

    /**
     * Creates a new transaction based on the given parameters
     *
     * @param transactionTypeId The first part of TransactionTypeId PK, the second part (sub-code) will be calculated
     *                          based on the effective date
     * @param externalId        Transaction External ID
     * @param userId            Account ID
     * @param effectiveDate     Transaction effective Date
     * @param amount            Transaction amount
     * @return new Transaction instance
     */
    TransactionModel createTransaction(String transactionTypeId, String externalId, String userId,
                                       Date effectiveDate, Double amount) throws GwtError;


}
