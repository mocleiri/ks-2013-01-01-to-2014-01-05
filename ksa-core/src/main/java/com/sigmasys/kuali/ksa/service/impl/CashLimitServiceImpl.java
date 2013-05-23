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
import java.util.*;

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
    private SmtpService smtpService;

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
    @Transactional(readOnly = false)
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
    @Transactional(readOnly = false)
    public Long persistCashLimitParameter(CashLimitParameter cashLimitParameter) {

        PermissionUtils.checkPermission(cashLimitParameter.getId() == null ?
                Permission.CREATE_CASH_LIMIT_PARAMETER : Permission.EDIT_CASH_LIMIT_PARAMETER);

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

        PermissionUtils.checkPermission(Permission.READ_IRS_8300);

        Query query = em.createQuery("select cle from CashLimitEvent cle " +
                " left outer join fetch cle.xmlDocument xml " +
                " where cle.accountId = :userId and cle.statusCode = :status " +
                " order by cle.eventDate desc");
        query.setParameter("userId", userId);
        query.setParameter("status", status.getId());
        return query.getResultList();
    }

    /**
     * Returns CashLimitEvent object by ID.
     *
     * @param id Cash limit event ID
     * @return CashLimitEvent instance
     */
    @Override
    public CashLimitEvent getCashLimitEvent(Long id) {

        PermissionUtils.checkPermission(Permission.READ_IRS_8300);

        Query query = em.createQuery("select cle from CashLimitEvent cle " +
                " left outer join fetch cle.xmlDocument xml " +
                " left outer join fetch cle.payments ts " +
                " where cle.id = :id");
        query.setParameter("id", id);
        List<CashLimitEvent> results = query.getResultList();
        return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
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
        query.setParameter("code", code);
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
    public CashLimitParameter getCashLimitParameterByCode(String code) {
        Query query = em.createQuery("select clp from CashLimitParameter clp " +
                " left outer join fetch clp.tag tag " +
                " where clp.code = :code");
        query.setParameter("code", code);
        List<CashLimitParameter> results = query.getResultList();
        return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
    }

    /**
     * Returns the cash limit parameter by ID.
     *
     * @param id CashLimitParameter's ID
     * @return CashLimitParameter instance
     */
    @Override
    public CashLimitParameter getCashLimitParameter(Long id) {
        Query query = em.createQuery("select clp from CashLimitParameter clp " +
                " left outer join fetch clp.tag tag " +
                " where clp.id = :id");
        query.setParameter("id", id);
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
    @Transactional(readOnly = false)
    public boolean checkCashLimit(String userId) {

        PermissionUtils.checkPermission(Permission.CHECK_CASH_LIMIT);

        String cashTracking = configService.getParameter(Constants.CASH_TRACKING_SYSTEM);
        if (!"ON".equalsIgnoreCase(cashTracking)) {
            return false;
        }

        String trackingTag = configService.getParameter(Constants.CASH_TRACKING_TAG);

        int trackingDays = Integer.parseInt(configService.getParameter(Constants.CASH_TRACKING_DAYS));

        final Date endDate = CalendarUtils.removeTime(new Date());
        final Date startDate = CalendarUtils.removeTime(CalendarUtils.addCalendarDays(endDate, -trackingDays));

        Query query = em.createQuery("select distinct t.id from Payment t where exists " +
                " (select 1 from CashLimitEvent cle " +
                " inner join cle.payments ts " +
                " where t.id = ts.id " +
                " and cle.accountId = :userId and cle.statusCode = :status " +
                " and cle.eventDate between :startDate and :endDate) ");

        query.setParameter("userId", userId);
        query.setParameter("status", CashLimitEventStatus.COMPLETED_CODE);
        query.setParameter("startDate", startDate, TemporalType.DATE);
        query.setParameter("endDate", endDate, TemporalType.DATE);

        Set<Long> paymentIds = new HashSet<Long>(query.getResultList());

        boolean paymentIdsExist = CollectionUtils.isNotEmpty(paymentIds);

        query = em.createQuery("select distinct t from Payment t inner join t.tags tag " +
                " where t.account.id = :userId and tag.code = :tagCode " +
                " and t.effectiveDate between :startDate and :endDate " +
                (paymentIdsExist ? " and t.id not in (:paymentIds)" : "") +
                " and exists (select 1 from CashLimitParameter clp  " +
                " where t.amount between clp.lowerLimit and clp.upperLimit " +
                " and clp.active = true and clp.tag.code = :tagCode)");

        query.setParameter("userId", userId);
        query.setParameter("startDate", startDate, TemporalType.DATE);
        query.setParameter("endDate", endDate, TemporalType.DATE);
        query.setParameter("tagCode", trackingTag);

        if (paymentIdsExist) {
            query.setParameter("paymentIds", paymentIds);
        }

        logger.debug("Cash tracking query parameters: userId = " + query.getParameterValue("userId") +
                ", startDate = " + query.getParameterValue("startDate") +
                ", endDate = " + query.getParameterValue("endDate") +
                ", tagCode = " + query.getParameterValue("tagCode"));

        List<Payment> payments = query.getResultList();
        if (CollectionUtils.isNotEmpty(payments)) {

            logger.debug("Number of payments to track = " + payments.size());

            BigDecimal paymentAmount = BigDecimal.ZERO;

            for (Payment payment : payments) {
                paymentAmount = paymentAmount.add(payment.getAmount());
            }

            BigDecimal trackingAmount = new BigDecimal(configService.getParameter(Constants.CASH_TRACKING_AMOUNT));

            if (paymentAmount.compareTo(trackingAmount) < 0) {

                return false;

            } else {

                String recipient = configService.getParameter(Constants.CASH_TRACKING_EMAIL_RECIPIENT);

                CashLimitEvent cashLimitEvent = new CashLimitEvent();
                cashLimitEvent.setAccountId(userId);
                cashLimitEvent.setCreatorId(userSessionManager.getUserId(RequestUtils.getThreadRequest()));
                cashLimitEvent.setEventDate(new Date());
                cashLimitEvent.setPaymentAmount(paymentAmount);
                cashLimitEvent.setPayments(new HashSet<Payment>(payments));
                cashLimitEvent.setNotificationDate(new Date());
                cashLimitEvent.setRecipient(recipient);
                cashLimitEvent.setMultiple(payments.size() > 1);
                cashLimitEvent.setStatus(CashLimitEventStatus.QUEUED);

                // Calculating the total charge amount from allocations
                Map<Long, Transaction> chargeMap = new HashMap<Long, Transaction>();
                for (Payment payment : payments) {
                    List<Allocation> allocations = transactionService.getAllocations(payment.getId());
                    for (Allocation allocation : allocations) {
                        Transaction transaction1 = allocation.getFirstTransaction();
                        Transaction transaction2 = allocation.getSecondTransaction();
                        if (transaction1.getId().equals(payment.getId())) {
                            chargeMap.put(transaction2.getId(), transaction2);
                        } else {
                            chargeMap.put(transaction1.getId(), transaction1);
                        }
                    }
                }

                // Summarizing the transaction amounts from chargeMap
                BigDecimal chargeAmount = BigDecimal.ZERO;
                for (Transaction charge : chargeMap.values()) {
                    chargeAmount = chargeAmount.add(charge.getAmount());
                }

                // If the charge amount is less than the payment amount we should use the payment amount
                if (chargeAmount.compareTo(paymentAmount) < 0) {
                    chargeAmount = paymentAmount;
                }

                cashLimitEvent.setChargeAmount(chargeAmount);


                persistEntity(cashLimitEvent);

                // Sending email notification
                String subject = configService.getParameter(Constants.CASH_TRACKING_EMAIL_SUBJECT);
                String body = "\n\nCash Limit Event (ID = " + cashLimitEvent.getId() + ") has been created. " +
                        "The form 8300 can now be filed with IRS.";

                smtpService.sendEmail(new String[]{recipient}, subject, body);

                return true;
            }
        }

        return false;
    }

}