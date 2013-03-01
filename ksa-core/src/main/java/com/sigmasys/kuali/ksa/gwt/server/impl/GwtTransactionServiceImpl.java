package com.sigmasys.kuali.ksa.gwt.server.impl;

import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.sigmasys.kuali.ksa.annotation.UrlMapping;
import com.sigmasys.kuali.ksa.gwt.client.model.*;
import com.sigmasys.kuali.ksa.gwt.client.model.TransactionType;
import com.sigmasys.kuali.ksa.gwt.client.service.GwtTransactionService;
import com.sigmasys.kuali.ksa.gwt.server.AbstractSearchService;
import com.sigmasys.kuali.ksa.gwt.server.SearchQueryBuilder;
import com.sigmasys.kuali.ksa.gwt.server.TransactionColumnMapper;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * GwtTransactionService implementation
 *
 * @author Michael Ivanov
 */
@UrlMapping(Constants.TRANSACTION_SERVICE_URL)
@Service("gwtTransactionService")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class GwtTransactionServiceImpl extends AbstractSearchService implements GwtTransactionService {

    private static final Log logger = LogFactory.getLog(GwtTransactionServiceImpl.class);

    private static final String select = "select transaction";

    private static final String from =
            "from Transaction transaction " +
                    "left outer join fetch transaction.transactionType type " +
                    "left outer join fetch transaction.account account " +
                    "left outer join fetch transaction.currency currency " +
                    "left outer join fetch transaction.rollup rollup " +
                    "left outer join fetch transaction.document document";

    private static final String defaultOrder = "transaction.effectiveDate desc";


    @PersistenceContext(unitName = Constants.KSA_PERSISTENCE_UNIT)
    protected EntityManager em;

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private TransactionService transactionService;


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public PagingLoadResult<TransactionModel> findTransactions(SearchCriteria searchCriteria, String sortDir,
                                                               String sortField, int offset, int limit) throws GwtError {
        logger.info("sortDir = " + sortDir + ", sortField = " + sortField);

        StringBuilder where = new StringBuilder("");
        Set<TransactionType> transactionTypes = (Set<TransactionType>) searchCriteria.get(TransactionModel.TYPE);
        if (transactionTypes != null && !transactionTypes.isEmpty()) {
            where.append(" type(transaction) in ( ");
            int i = 0;
            for (TransactionType type : transactionTypes) {
                where.append(type.toString());
                if (++i < transactionTypes.size()) {
                    where.append(",");
                }
            }
            where.append(")");
        }

        SearchQueryBuilder queryBuilder = new SearchQueryBuilder(select, from, where.toString());
        queryBuilder.setDefaultSort(defaultOrder);
        queryBuilder.setSortMapping(new TransactionColumnMapper());

        PagingLoadResult<Transaction> loadResult =
                buildPagingLoadResult(queryBuilder, searchCriteria, sortDir, sortField, offset, limit);

        List<TransactionModel> transactions = new ArrayList<TransactionModel>(loadResult.getData().size());
        for (Transaction transaction : loadResult.getData()) {
            transactions.add(createModelFrom(transaction));
        }
        return new PagingLoadResultImpl<TransactionModel>(transactions, loadResult.getOffset(), loadResult.getTotalLength());
    }

    private TransactionModel createModelFrom(Transaction transaction) {

        TransactionModel model = new TransactionModel();
        model.setId(transaction.getId());
        model.setExternalId(transaction.getExternalId());
        model.setTypeId(transaction.getTransactionType().getId().getId());
        model.setTypeSubCode(transaction.getTransactionType().getId().getSubCode());

        model.setAmount(transaction.getAmount() != null ? transaction.getAmount().doubleValue() : 0.0);
        model.setNativeAmount(transaction.getNativeAmount() != null ? transaction.getNativeAmount().doubleValue() : 0.0);
        model.setAllocatedAmount(transaction.getAllocatedAmount() != null ?
                transaction.getAllocatedAmount().doubleValue() : 0.0);
        model.setLockedAllocatedAmount(transaction.getLockedAllocatedAmount() != null ?
                transaction.getAllocatedAmount().doubleValue() : 0.0);

        model.setAccountId(transaction.getAccount().getId());
        model.setCurrencyCode(transaction.getCurrency().getCode());

        model.setEffectiveDate(transaction.getEffectiveDate());
        model.setCreationDate(transaction.getCreationDate());
        model.setOriginationDate(transaction.getOriginationDate());
        model.setGlEntryGenerated(transaction.isGlEntryGenerated());
        model.setInternal(transaction.isInternal());
        //model.setRefundRule(transaction.getRefundRule());
        model.setStatementText(transaction.getStatementText());
        model.setResponsibleEntity(transaction.getCreatorId());

        if (transaction instanceof Charge) {
            model.setType(TransactionType.CHARGE);
        } else if (transaction instanceof Payment) {
            model.setType(TransactionType.PAYMENT);
        } else if (transaction instanceof Deferment) {
            model.setType(TransactionType.DEFERMENT);
        }

        return model;
    }

    @Override
    public List<String> getExistingCurrencyCodes() throws GwtError {
        List<Currency> currencies = auditableEntityService.getCurrencies();
        List<String> currencyCodes = new ArrayList<String>(currencies.size());
        for (Currency currency : currencies) {
            currencyCodes.add(currency.getCode());
        }
        return currencyCodes;
    }

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
    @Override
    @Transactional(readOnly = false)
    public TransactionModel createTransaction(String transactionTypeId, String externalId, String userId,
                                              Date effectiveDate, Double amount) throws GwtError {
        Transaction transaction = transactionService.createTransaction(transactionTypeId, externalId, userId,
                effectiveDate, null, new BigDecimal(amount));
        return createModelFrom(transaction);
    }


}
