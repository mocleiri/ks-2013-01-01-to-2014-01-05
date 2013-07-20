package com.sigmasys.kuali.ksa.service.pb.impl;

import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.pb.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.TransactionTransferService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.service.pb.PaymentBillingService;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;


/**
 * Payment Billing Service implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("paymentBillingService")
@Transactional(readOnly = true)
@WebService(serviceName = PaymentBillingService.SERVICE_NAME, portName = PaymentBillingService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
@SuppressWarnings("unchecked")
public class PaymentBillingServiceImpl extends GenericPersistenceService implements PaymentBillingService {

    private static final Log logger = LogFactory.getLog(PaymentBillingServiceImpl.class);

    private static final String TRANSFER_DETAIL_SELECT = "select d from PaymentBillingTransferDetail d " +
            " left outer join fetch d.directChargeAccount dca " +
            " left outer join fetch d.plan p " +
            " left outer join fetch d.flatFeeCharge fc " +
            " left outer join fetch d.variableFeeCharge vc " +
            " left outer join fetch p.transferType t " +
            " left outer join fetch t.generalLedgerType g ";

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionTransferService transactionTransferService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuditableEntityService auditableEntityService;


    /**
     * Creates and persists a payment billing transfer detail object for the given parameters.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @param accountId            DirectChargeAccount ID
     * @param maxAmount            Maximum amount to finance
     * @param initiationDate       Initiation Date
     * @return PaymentBillingTransferDetail instance
     */
    @Override
    @Transactional(readOnly = false)
    public PaymentBillingTransferDetail generatePaymentBillingTransfer(Long paymentBillingPlanId,
                                                                       String accountId,
                                                                       BigDecimal maxAmount,
                                                                       Date initiationDate) {

        PermissionUtils.checkPermission(Permission.GENERATE_PAYMENT_BILLING_TRANSFER);

        PaymentBillingPlan billingPlan = getPaymentBillingPlan(paymentBillingPlanId);
        if (billingPlan == null) {
            String errMsg = "PaymentBillingPlan does not exist with ID = " + paymentBillingPlanId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Account account = accountService.getFullAccount(accountId);
        if (account == null || !(account instanceof DirectChargeAccount)) {
            String errMsg = "DirectChargeAccount with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        if (maxAmount == null) {
            String errMsg = "Maximum amount to finance cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (initiationDate == null) {
            String errMsg = "Initiation date cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (initiationDate.after(billingPlan.getOpenPeriodEndDate()) ||
                initiationDate.before(billingPlan.getOpenPeriodStartDate())) {
            String errMsg = "Initiation date must be between Open Period Start and End dates";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        Query query = em.createQuery("select 1 from PaymentBillingTransferDetail t " +
                " inner join t.directChargeAccount a " +
                " inner join t.plan p " +
                " where p.id = :planId and a.id = :accountId and t.chargeStatusCode <> :statusCode");

        query.setParameter("planId", paymentBillingPlanId);
        query.setParameter("accountId", accountId);
        query.setParameter("statusCode", PaymentBillingChargeStatus.REVERSED_CODE);
        query.setMaxResults(1);

        if (CollectionUtils.isNotEmpty(query.getResultList())) {
            String errMsg = "Account '" + accountId + "' is not eligible for this plan (PaymentBillingPlan ID = " +
                    paymentBillingPlanId + ")";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        if (maxAmount.compareTo(billingPlan.getMaxAmount()) > 0) {
            maxAmount = billingPlan.getMaxAmount();
        }

        PaymentBillingTransferDetail transferDetail = new PaymentBillingTransferDetail();

        transferDetail.setInitiationDate(initiationDate);
        transferDetail.setMaxAmount(maxAmount);
        transferDetail.setDirectChargeAccount((DirectChargeAccount) account);
        transferDetail.setPlan(billingPlan);
        transferDetail.setChargeStatus(PaymentBillingChargeStatus.INITIALIZED);

        persistPaymentBillingTransferDetail(transferDetail);

        return transferDetail;
    }

    /**
     * Retrieves PaymentBillingPlan instance by ID from the persistent store.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return PaymentBillingPlan instance
     */
    @Override
    public PaymentBillingPlan getPaymentBillingPlan(Long paymentBillingPlanId) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_PLAN);

        Query query = em.createQuery("select p from PaymentBillingPlan p " +
                " left outer join fetch p.transferType t " +
                " left outer join fetch t.generalLedgerType g " +
                " where p.id = :id");

        query.setParameter("id", paymentBillingPlanId);

        List<PaymentBillingPlan> plans = query.getResultList();

        return CollectionUtils.isNotEmpty(plans) ? plans.get(0) : null;
    }

    /**
     * Retrieves PaymentBillingTransferDetail with ACTIVE status by ID from the persistent store.
     *
     * @param paymentBillingTransferDetailId PaymentBillingTransferDetail ID
     * @return PaymentBillingTransferDetail instance
     */
    @Override
    public PaymentBillingTransferDetail getPaymentBillingTransferDetail(Long paymentBillingTransferDetailId) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_TRANSFER_DETAIL);

        Query query = em.createQuery(TRANSFER_DETAIL_SELECT + " where d.id = :id and d.chargeStatusCode = :statusCode");

        query.setParameter("id", paymentBillingTransferDetailId);
        query.setParameter("statusCode", PaymentBillingChargeStatus.ACTIVE_CODE);

        List<PaymentBillingTransferDetail> details = query.getResultList();

        return CollectionUtils.isNotEmpty(details) ? details.get(0) : null;
    }

    /**
     * Reverses a payment billing transfer specified by PaymentBillingTransferDetail ID.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @param removeFees       if true, then the fee charges will also be reversed
     * @param memoText         Memo text
     * @return PaymentBillingTransferDetail instance
     */
    @Override
    @Transactional(readOnly = false)
    public PaymentBillingTransferDetail reversePaymentBillingTransfer(Long transferDetailId, boolean removeFees, String memoText) {

        PermissionUtils.checkPermission(Permission.REVERSE_PAYMENT_BILLING_TRANSFER);

        PaymentBillingTransferDetail transferDetail = getPaymentBillingTransferDetail(transferDetailId);
        if (transferDetail == null) {
            String errMsg = "PaymentBillingTransferDetail does not exist with ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (transferDetail.getChargeStatus() != PaymentBillingChargeStatus.ACTIVE) {
            String errMsg = "PaymentBillingTransferDetail must be active";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        // Reversing the entire transaction transfer group allowing locked allocations
        transactionTransferService.reverseTransferGroup(transferDetail.getTransferGroupId(), memoText, true);

        if (removeFees) {

            Charge flatFeeCharge = transferDetail.getFlatFeeCharge();
            if (flatFeeCharge != null) {
                transactionService.reverseTransaction(flatFeeCharge.getId(), memoText, flatFeeCharge.getAmount());
            }

            Charge variableFeeCharge = transferDetail.getVariableFeeCharge();
            if (variableFeeCharge != null) {
                transactionService.reverseTransaction(variableFeeCharge.getId(), memoText, variableFeeCharge.getAmount());
            }
        }

        transferDetail.setChargeStatus(PaymentBillingChargeStatus.REVERSED);

        return transferDetail;
    }


    /**
     * Persists PaymentBillingTransferDetail instance in the persistent store.
     *
     * @param transferDetail PaymentBillingTransferDetail instance
     * @return PaymentBillingTransferDetail ID
     */
    @Override
    @Transactional(readOnly = false)
    public Long persistPaymentBillingTransferDetail(PaymentBillingTransferDetail transferDetail) {
        return persistEntity(transferDetail);
    }

    /**
     * Returns a list of payment billing transactions for the plan specified by ID.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return list of PaymentBillingTransaction instances
     */
    @Override
    public List<PaymentBillingTransaction> getPaymentBillingTransactions(Long paymentBillingPlanId) {

        PermissionUtils.checkPermission(Permission.READ_PAYMENT_BILLING_TRANSACTION);

        Query query = em.createQuery("select pbt from PaymentBillingTransaction pbt " +
                " left outer join fetch pbt.transaction t " +
                " left outer join fetch pbt.transferDetail td " +
                " left outer join fetch td.directChargeAccount a " +
                " left outer join fetch td.plan p " +
                " where p.id = :planId " +
                " order by pbt.id desc");

        query.setParameter("planId", paymentBillingPlanId);

        return query.getResultList();
    }


    /**
     * Generates a list of PaymentBillingSchedule objects for the given PaymentBillingPlan ID
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return list of PaymentBillingSchedule instances
     */
    @Override
    @Transactional(readOnly = false)
    public List<PaymentBillingSchedule> generatePaymentBillingSchedules(Long paymentBillingPlanId) {

        PermissionUtils.checkPermission(Permission.GENERATE_PAYMENT_BILLING_SCHEDULE);

        PaymentBillingPlan billingPlan = getPaymentBillingPlan(paymentBillingPlanId);
        if (billingPlan == null) {
            String errMsg = "PaymentBillingPlan does not exist with ID = " + paymentBillingPlanId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        ScheduleType scheduleType = billingPlan.getScheduleType();

        if (scheduleType == null || scheduleType == ScheduleType.NOT_ALLOWED) {
            String errMsg = "Payment Billing Schedule is not allowed for this plan (PaymentBillingPlan ID = " +
                    paymentBillingPlanId + ")";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        // TODO: Ask Paul how to implement the next steps


        return null;
    }


    /**
     * This method is used internally to produce a monthly payment amount, based on the original amount,
     * the percentage and the rounding factor.
     *
     * @param totalAmount    Total amount
     * @param percentage     Percentage
     * @param roundingFactor Rounding factor
     * @return Payment amount
     */
    protected BigDecimal calculatePaymentAmount(BigDecimal totalAmount, BigDecimal percentage, int roundingFactor) {

        if (roundingFactor != 0 && roundingFactor != 1 && roundingFactor % 10 != 0) {
            String errMsg = "Rounding factor must be 0, 1 or a power of 10 (0,1,10,100,1000,...)";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        BigDecimal paymentAmount = totalAmount.multiply(percentage).divide(new BigDecimal(100));

        if (roundingFactor == 0) {
            paymentAmount = paymentAmount.setScale(2, RoundingMode.CEILING);
        }

        // TODO: ask Paul about rounding of BigDecimal values

        return null;
    }


    /**
     * This method creates the transactions that make up the payment billing charges and
     * nets off the transactions that are financed.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return PaymentBillingTransferDetail instance
     */
    @Override
    @Transactional(readOnly = false)
    public PaymentBillingTransferDetail generatePaymentBillingTransactions(Long paymentBillingPlanId) {

        PermissionUtils.checkPermission(Permission.GENERATE_PAYMENT_BILLING_TRANSFER);

        List<PaymentBillingTransaction> billingTransactions = getPaymentBillingTransactions(paymentBillingPlanId);

        if (CollectionUtils.isNotEmpty(billingTransactions)) {

            BigDecimal totalFinancedAmount = BigDecimal.ZERO;

            for (PaymentBillingTransaction billingTransaction : billingTransactions) {

                BigDecimal financedAmount = billingTransaction.getFinancedAmount();
                if (financedAmount == null) {
                    financedAmount = BigDecimal.ZERO;
                }

                totalFinancedAmount = totalFinancedAmount.add(financedAmount);
            }

            // TODO "Create a UUID and set paymentBillingDetail.transferGroup to this UUID"
            // TODO ask Paul how to get PaymentBillingDetail here

        }

        return null;
    }


}