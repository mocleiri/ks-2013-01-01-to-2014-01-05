package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.config.ConfigService;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.*;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import com.sigmasys.kuali.ksa.util.CalendarUtils;
import com.sigmasys.kuali.ksa.util.RequestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Cash limit service implementation
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("cashLimitService")
@Transactional(readOnly = true)
@WebService(serviceName = CashLimitService.SERVICE_NAME, portName = CashLimitService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
@SuppressWarnings("unchecked")
public class CashLimitServiceImpl extends GenericPersistenceService implements CashLimitService {

    private static final Log logger = LogFactory.getLog(CashLimitServiceImpl.class);


    @Autowired
    private ConfigService configService;

    @Autowired
    private TransactionService transactionService;


    /**
     * Creates a new cash limit parameter for the given parameters.
     *
     * @param code          Parameter code
     * @param name          Parameter name
     * @param description   Parameter description
     * @param tag           Parameter tag
     * @param lowerLimit    Lower limit
     * @param upperLimit    Upper limit
     * @param isActive      Indicates whether the new parameter should be active upon creation
     * @param authorityName Authority name
     * @param xmlElement    XML element name
     * @return a new instance of CashLimitParameter
     */
    @Override
    public CashLimitParameter createCashLimitParameter(String code, String name, String description, Tag tag,
                                                       BigDecimal lowerLimit, BigDecimal upperLimit, boolean isActive,
                                                       String authorityName, String xmlElement) {

        PermissionUtils.checkPermission(Permission.CREATE_CASH_LIMIT_PARAMETER);

        if (cashLimitParameterExists(code)) {
            String errMsg = "CashLimitParameter already exists with code '" + code + "'";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        CashLimitParameter cashLimitParameter = new CashLimitParameter();
        cashLimitParameter.setCode(code);
        cashLimitParameter.setName(name);
        cashLimitParameter.setDescription(description);
        cashLimitParameter.setTag(tag);
        cashLimitParameter.setLowerLimit(lowerLimit);
        cashLimitParameter.setUpperLimit(upperLimit);
        cashLimitParameter.setActive(isActive);
        cashLimitParameter.setAuthorityName(authorityName);
        cashLimitParameter.setXmlElement(xmlElement);

        persistCashLimitParameter(cashLimitParameter);

        return cashLimitParameter;
    }

    /**
     * Persists the given cash limit parameter in the persistence store
     *
     * @param cashLimitParameter CashLimitParameter instance
     * @return Cash limit parameter ID
     */
    @Override
    public Long persistCashLimitParameter(CashLimitParameter cashLimitParameter) {

        Tag tag = cashLimitParameter.getTag();
        if (tag != null) {
            if (tag.getId() != null) {
                PermissionUtils.checkPermissions(tag, Permission.EDIT_TAG, Permission.EDIT_ADMIN_TAG);
            } else {
                PermissionUtils.checkPermissions(tag, Permission.CREATE_TAG, Permission.CREATE_ADMIN_TAG);
            }
            persistEntity(tag);
        }

        BigDecimal lowerLimit = cashLimitParameter.getLowerLimit();
        BigDecimal upperLimit = cashLimitParameter.getUpperLimit();
        if (lowerLimit != null && upperLimit != null && lowerLimit.compareTo(upperLimit) >= 0) {
            String errMsg = "The lower limit must be less than the upper limit, lowerLimit = " + lowerLimit +
                    ", upperLimit = " + upperLimit;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        return persistEntity(cashLimitParameter);
    }

    /**
     * Retrieves all CashLimitEvent objects for the given user ID and CashLimitEventStatus.
     *
     * @param userId Account ID
     * @param status CashLimitEvent status
     * @return a list of cash limit events
     */
    @Override
    public List<CashLimitEvent> getCashLimitEvents(String userId, CashLimitEventStatus status) {
        Query query = em.createQuery("select cle from CashLimitEvent cle " +
                " left outer join fetch cle.xmlDocument xml " +
                " where cle.accountId = :userId and cle.statusCode = :status " +
                " order by cle.eventDate desc");
        query.setParameter("userId", userId);
        query.setParameter("status", status.getId());
        return query.getResultList();
    }

    /**
     * Retrieves cash limit parameters.
     *
     * @param activeOnly if true only active parameters will be retrieved.
     * @return a list of cash limit parameters
     */
    @Override
    public List<CashLimitParameter> getCashLimitParameters(boolean activeOnly) {
        Query query = em.createQuery("select clp from CashLimitParameter clp " +
                " left outer join fetch clp.tag tag " +
                (activeOnly ? " where clp.active = true " : "") +
                " order by clp.code asc");
        return query.getResultList();
    }

    /**
     * Checks if the cash limit parameter exists by code.
     *
     * @param code CashLimitParameter's code
     * @return true if it exists, false - otherwise
     */
    @Override
    public boolean cashLimitParameterExists(String code) {
        Query query = em.createQuery("select 1 from CashLimitParameter where code = :code");
        query.setParameter("id", code);
        query.setMaxResults(1);
        return CollectionUtils.isNotEmpty(query.getResultList());
    }

    /**
     * Checks if the cash limit parameter exists by code.
     *
     * @param code CashLimitParameter's code
     * @return CashLimitParameter instance
     */
    @Override
    public CashLimitParameter getCashLimitParameter(String code) {
        Query query = em.createQuery("select clp from CashLimitParameter clp " +
                " left outer join fetch clp.tag tag " +
                " where clp.code = :code");
        query.setParameter("code", code);
        List<CashLimitParameter> results = query.getResultList();
        return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
    }

    /**
     * This method will return true if there has been a cash limit event. A <code>CashLimitEvent</code> object will be
     * created and persisted and an email will be sent to the appropriate administrator to allow them to check
     * up on the event. A further step will be required to actually register the event (by producing an 8300
     * form to be filed with the IRS).
     *
     * @param userId Account ID
     * @return true if there has been a cash limit event, otherwise false
     */
    @Override
    public boolean checkCashLimit(String userId) {

        String cashTracking = configService.getParameter(Constants.CASH_TRACKING_SYSTEM);
        if (!"ON".equalsIgnoreCase(cashTracking)) {
            return false;
        }

        String trackingTag = configService.getParameter(Constants.CASH_TRACKING_TAG);

        int trackingDays = Integer.parseInt(configService.getParameter(Constants.CASH_TRACKING_DAYS));

        final Date endDate = CalendarUtils.removeTime(new Date());
        final Date startDate = CalendarUtils.removeTime(CalendarUtils.addCalendarDays(endDate, -trackingDays));

        Query query = em.createQuery("select distinct t.id from Transaction t where exists " +
                " (select 1 from CashLimitEvent cle " +
                " inner join cle.transactions ts " +
                " where t.id = ts.id " +
                " and cle.accountId = :userId and cle.statusCode = :status " +
                " and cle.eventDate between :startDate and :endDate) ");

        query.setParameter("userId", userId);
        query.setParameter("status", CashLimitEventStatus.COMPLETED_CODE);
        query.setParameter("startDate", startDate, TemporalType.DATE);
        query.setParameter("endDate", endDate, TemporalType.DATE);

        Set<Long> transactionIds = new HashSet<Long>(query.getResultList());

        boolean transactionIdsExist = CollectionUtils.isNotEmpty(transactionIds);

        query = em.createQuery("select distinct t from Transaction t, CashLimitParameter clp " +
                " left outer join t.tags tag " +
                " where t.account.id = :userId and clp.active = true " +
                " and t.effectiveDate between :startDate and :endDate " +
                " and t.amount between clp.lowerLimit and clp.upperLimit " +
                " and tag.code = clp.tag.code and tag.code = :tagCode " +
                (transactionIdsExist ? " and t.id not in (:transactionIds)" : ""));

        query.setParameter("userId", userId);
        query.setParameter("startDate", startDate, TemporalType.DATE);
        query.setParameter("endDate", endDate, TemporalType.DATE);
        query.setParameter("tagCode", trackingTag);

        if (transactionIdsExist) {
            query.setParameter("transactionIds", transactionIds);
        }

        List<Transaction> transactions = query.getResultList();
        if (CollectionUtils.isNotEmpty(transactions)) {

            BigDecimal transactionAmount = BigDecimal.ZERO;

            for (Transaction transaction : transactions) {
                transactionAmount = transactionAmount.add(transaction.getAmount());
            }

            BigDecimal trackingAmount = new BigDecimal(configService.getParameter(Constants.CASH_TRACKING_AMOUNT));

            if (transactionAmount.compareTo(trackingAmount) < 0) {

                return false;

            } else {

                CashLimitEvent cashLimitEvent = new CashLimitEvent();
                cashLimitEvent.setAccountId(userId);
                cashLimitEvent.setCreatorId(userSessionManager.getUserId(RequestUtils.getThreadRequest()));
                cashLimitEvent.setEventDate(new Date());
                cashLimitEvent.setTransactionAmount(transactionAmount);
                cashLimitEvent.setTransactions(new HashSet<Transaction>(transactions));
                cashLimitEvent.setNotificationDate(new Date());
                cashLimitEvent.setNotificationSentTo(configService.getParameter(Constants.CASH_TRACKING_EMAIL_ADDRESS));
                cashLimitEvent.setMultiple(transactions.size() > 1);
                cashLimitEvent.setStatus(CashLimitEventStatus.COMPLETED);

                persistEntity(cashLimitEvent);

                // TODO: cash limit report and email

                return true;
            }
        }

        // TODO:
        return false;
    }


}