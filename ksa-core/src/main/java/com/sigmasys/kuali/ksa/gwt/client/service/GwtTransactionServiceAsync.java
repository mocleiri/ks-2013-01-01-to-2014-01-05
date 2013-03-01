package com.sigmasys.kuali.ksa.gwt.client.service;

import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sigmasys.kuali.ksa.gwt.client.model.SearchCriteria;
import com.sigmasys.kuali.ksa.gwt.client.model.TransactionModel;

import java.util.Date;
import java.util.List;


/**
 * GwtTransactionServiceAsync
 *
 * @author Michael Ivanov
 */
public interface GwtTransactionServiceAsync {

    void findTransactions(SearchCriteria searchCriteria, String sortDir,
                          String sortField, int offset, int limit,
                          AsyncCallback<PagingLoadResult<TransactionModel>> callback);

    void getExistingCurrencyCodes(AsyncCallback<List<String>> callback);

    void createTransaction(String transactionTypeId, String externalId, String userId,
                           Date effectiveDate, Double amount, AsyncCallback<TransactionModel> callback);

}
