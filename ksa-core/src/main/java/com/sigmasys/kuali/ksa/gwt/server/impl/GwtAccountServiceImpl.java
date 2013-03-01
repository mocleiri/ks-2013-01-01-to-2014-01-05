package com.sigmasys.kuali.ksa.gwt.server.impl;

import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.sigmasys.kuali.ksa.annotation.UrlMapping;
import com.sigmasys.kuali.ksa.gwt.client.model.AccountModel;
import com.sigmasys.kuali.ksa.gwt.client.model.GwtError;
import com.sigmasys.kuali.ksa.gwt.client.model.PagingLoadResultImpl;
import com.sigmasys.kuali.ksa.gwt.client.model.SearchCriteria;
import com.sigmasys.kuali.ksa.gwt.client.service.GwtAccountService;
import com.sigmasys.kuali.ksa.gwt.server.AbstractSearchService;
import com.sigmasys.kuali.ksa.gwt.server.AccountColumnMapper;
import com.sigmasys.kuali.ksa.gwt.server.SearchQueryBuilder;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * GwtAccountService implementation
 *
 * @author Michael Ivanov
 */
@UrlMapping(Constants.ACCOUNT_SERVICE_URL)
@Service("gwtAccountService")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class GwtAccountServiceImpl extends AbstractSearchService implements GwtAccountService {

    private static final Log logger = LogFactory.getLog(GwtAccountServiceImpl.class);

    private static final String select = "select distinct account";

    private static final String from =
            "from Account account " +
                    "left outer join fetch account.personNames person " +
                    "left outer join fetch account.postalAddresses address " +
                    "left outer join fetch account.electronicContacts contact " +
                    "left outer join fetch account.statusType statusType " +
                    "left outer join fetch account.latePeriod latePeriod";

    private static final String where =
            "      person.default = true and " +
                    "      address.default = true and " +
                    "      contact.default = true ";

    private static final String defaultOrder = "account.creationDate desc";


    @PersistenceContext(unitName = Constants.KSA_PERSISTENCE_UNIT)
    protected EntityManager em;

    @Autowired
    private AccountService accountService;


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public PagingLoadResult<AccountModel> findAccounts(SearchCriteria searchCriteria, String sortDir,
                                                       String sortField, int offset, int limit) throws GwtError {
        logger.info("sortDir = " + sortDir + ", sortField = " + sortField);
        SearchQueryBuilder queryBuilder = new SearchQueryBuilder(select, from, where);
        queryBuilder.setDefaultSort(defaultOrder);
        queryBuilder.setSortMapping(new AccountColumnMapper());
        // TODO: provide query builder customization for streetAddress
        PagingLoadResult<Account> loadResult =
                buildPagingLoadResult(queryBuilder, searchCriteria, sortDir, sortField, offset, limit);

        List<AccountModel> accounts = new ArrayList<AccountModel>(loadResult.getData().size());
        for (Account account : loadResult.getData()) {
            accounts.add(createModelFrom(account));
        }
        return new PagingLoadResultImpl<AccountModel>(accounts, loadResult.getOffset(), loadResult.getTotalLength());
    }

    private AccountModel createModelFrom(Account account) {

        AccountModel model = new AccountModel();

        model.setId(account.getId());
        model.setEntityId(account.getEntityId());
        model.setCreationDate(account.getCreationDate());

        model.setKimAccount(account.isKimAccount());
        model.setLastKimUpdate(account.getLastKimUpdate());
        model.setCreditLimit(account.getCreditLimit() != null ? account.getCreditLimit().doubleValue() : null);

        PersonName personName = account.getDefaultPersonName();
        model.setFirstName(personName.getFirstName());
        model.setMiddleName(personName.getMiddleName());
        model.setLastName(personName.getLastName());

        LatePeriod latePeriod = account.getLatePeriod();
        model.setDaysLate1(latePeriod.getDaysLate1());
        model.setDaysLate2(latePeriod.getDaysLate2());
        model.setDaysLate3(latePeriod.getDaysLate3());

        PostalAddress address = account.getDefaultPostalAddress();
        model.setCountry(address.getCountry());
        model.setPostalCode(address.getPostalCode());
        model.setState(address.getState());
        model.setCity(address.getCity());

        String streetAddress = address.getStreetAddress1();
        if (streetAddress != null) {
            String streetAddress2 = address.getStreetAddress2();
            if (streetAddress2 != null && !streetAddress2.trim().isEmpty()) {
                streetAddress += " " + streetAddress2;
            }
            String streetAddress3 = address.getStreetAddress3();
            if (streetAddress3 != null && !streetAddress3.trim().isEmpty()) {
                streetAddress += " " + streetAddress3;
            }

        }

        model.setStreetAddress(streetAddress);

        if (account instanceof ChargeableAccount) {
            ChargeableAccount chargeableAccount = (ChargeableAccount) account;
            BigDecimal value = chargeableAccount.getAmountLate1();
            model.setAmountLate1(value != null ? value.doubleValue() : 0.0);
            value = chargeableAccount.getAmountLate2();
            model.setAmountLate2(value != null ? value.doubleValue() : 0.0);
            value = chargeableAccount.getAmountLate3();
            model.setAmountLate3(value != null ? value.doubleValue() : 0.0);
            model.setLateLastUpdate(chargeableAccount.getLateLastUpdate());
        }

        return model;
    }

    @Override
    public List<String> getExistingCountryCodes() throws GwtError {
        Query query = em.createQuery("select distinct country from PostalAddress " +
                "where country is not null order by country asc");
        List<String> results = query.getResultList();
        if (results != null && !results.isEmpty()) {
            List<String> countries = new ArrayList<String>(results);
            logger.info("Existing countries: " + countries);
            return countries;
        }
        return new ArrayList<String>();
    }

    @Override
    public Double getOutstandingBalance(String userId, boolean ignoreDeferment) {
        BigDecimal value = accountService.getOutstandingBalance(userId, ignoreDeferment);
        return value != null ? value.doubleValue() : 0.0;
    }

    @Override
    public Double getDueBalance(String userId, boolean ignoreDeferment) {
        BigDecimal value = accountService.getDueBalance(userId, ignoreDeferment);
        return value != null ? value.doubleValue() : 0.0;
    }

    @Override
    public Double getUnallocatedBalance(String userId) {
        BigDecimal value = accountService.getUnallocatedBalance(userId);
        return value != null ? value.doubleValue() : 0.0;
    }

    @Override
    public Double getDeferredAmount(String userId) {
        BigDecimal value = accountService.getDeferredAmount(userId);
        return value != null ? value.doubleValue() : 0.0;
    }

    @Override
    public AccountModel ageDebt(String userId, boolean ignoreDeferment) {
        return createModelFrom(accountService.ageDebt(userId, ignoreDeferment));
    }
}
