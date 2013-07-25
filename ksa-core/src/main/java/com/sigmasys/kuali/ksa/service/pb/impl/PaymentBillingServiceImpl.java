package com.sigmasys.kuali.ksa.service.pb.impl;

import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.pb.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.TransactionTransferService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.service.pb.PaymentBillingService;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import com.sigmasys.kuali.ksa.util.CalendarUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.util.*;
import java.util.regex.Pattern;


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

    private static final String TRANSACTION_SELECT = "select pbt from PaymentBillingTransaction pbt " +
            " left outer join fetch pbt.transaction t " +
            " left outer join fetch pbt.transferDetail td " +
            " left outer join fetch td.directChargeAccount a " +
            " left outer join fetch td.plan p ";


    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionTransferService transactionTransferService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private InformationService informationService;


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
     * @param memoText         Memo text
     * @param removeFees       if true, then the fee charges will also be reversed
     * @return PaymentBillingTransferDetail instance
     */
    @Override
    @Transactional(readOnly = false)
    public PaymentBillingTransferDetail reversePaymentBillingTransfer(Long transferDetailId, String memoText, boolean removeFees) {

        PermissionUtils.checkPermission(Permission.REVERSE_PAYMENT_BILLING_TRANSFER);

        PaymentBillingTransferDetail transferDetail = getPaymentBillingTransferDetail(transferDetailId);
        if (transferDetail == null) {
            String errMsg = "PaymentBillingTransferDetail does not exist with ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (transferDetail.getChargeStatus() != PaymentBillingChargeStatus.ACTIVE) {
            String errMsg = "PaymentBillingTransferDetail must be " + PaymentBillingChargeStatus.ACTIVE.toString();
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
    public List<PaymentBillingTransaction> getPaymentBillingTransactionsByPlanId(Long paymentBillingPlanId) {

        PermissionUtils.checkPermission(Permission.READ_PAYMENT_BILLING_TRANSACTION);

        Query query = em.createQuery(TRANSACTION_SELECT + " where p.id = :planId order by pbt.id desc");

        query.setParameter("planId", paymentBillingPlanId);

        return query.getResultList();
    }

    /**
     * Returns a list of payment billing transactions for the transfer detail specified by ID.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingTransaction instances
     */
    @Override
    public List<PaymentBillingTransaction> getPaymentBillingTransactionsByTransferDetailId(Long transferDetailId) {

        PermissionUtils.checkPermission(Permission.READ_PAYMENT_BILLING_TRANSACTION);

        Query query = em.createQuery(TRANSACTION_SELECT + " where td.id = :transferDetailId order by pbt.id desc");

        query.setParameter("transferDetailId", transferDetailId);

        return query.getResultList();
    }

    /**
     * Returns a list of payment billing schedules for the transfer detail specified by ID.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingSchedule instances
     */
    @Override
    public List<PaymentBillingSchedule> getPaymentBillingSchedulesByTransferDetailId(Long transferDetailId) {

        PermissionUtils.checkPermission(Permission.READ_PAYMENT_BILLING_SCHEDULE);

        Query query = em.createQuery("select s from PaymentBillingSchedule s " +
                " inner join fetch s.transferDetail d " +
                " left outer join fetch d.directChargeAccount " +
                " left outer join fetch d.plan " +
                " left outer join fetch d.flatFeeCharge " +
                " left outer join fetch d.variableFeeCharge " +
                " where d.id = :transferDetailId order by s.id desc");

        query.setParameter("transferDetailId", transferDetailId);

        return query.getResultList();
    }

    /**
     * Generates a list of PaymentBillingSchedule objects for the given PaymentBillingTransferDetail ID
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingSchedule instances
     */
    @Override
    @Transactional(readOnly = false)
    public List<PaymentBillingSchedule> generatePaymentBillingSchedules(Long transferDetailId) {

        PaymentBillingTransferDetail transferDetail = getPaymentBillingTransferDetail(transferDetailId);
        if (transferDetail == null) {
            String errMsg = "PaymentBillingTransferDetail does not exist with ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        PaymentBillingPlan billingPlan = transferDetail.getPlan();
        if (billingPlan == null) {
            String errMsg = "PaymentBillingPlan does not exist for PaymentBillingTransferDetail with ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        return generatePaymentBillingSchedules(transferDetail, billingPlan.getRoundingFactor());
    }

    protected List<PaymentBillingSchedule> generatePaymentBillingSchedules(PaymentBillingTransferDetail transferDetail,
                                                                           int roundingFactor) {

        PermissionUtils.checkPermission(Permission.GENERATE_PAYMENT_BILLING_SCHEDULE);

        PaymentBillingPlan billingPlan = transferDetail.getPlan();
        if (billingPlan == null) {
            String errMsg = "PaymentBillingPlan does not exist for PaymentBillingTransferDetail with ID = " +
                    transferDetail.getId();
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        ScheduleType scheduleType = billingPlan.getScheduleType();

        if (scheduleType == null || scheduleType == ScheduleType.NOT_ALLOWED) {
            String errMsg = "Payment Billing Schedule is not allowed for this plan (PaymentBillingPlan ID = " +
                    billingPlan.getId() + ")";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        List<PaymentBillingDate> billingDates = getPaymentBillingDates(billingPlan.getId());

        boolean isInitiationDateBefore = true;

        for (PaymentBillingDate billingDate : billingDates) {
            if (transferDetail.getInitiationDate().after(billingDate.getEffectiveDate())) {
                isInitiationDateBefore = false;
                break;
            }
        }

        List<PaymentBillingSchedule> billingSchedules = new LinkedList<PaymentBillingSchedule>();

        BigDecimal totalPercentage = BigDecimal.ZERO;

        boolean skipEarlier = !isInitiationDateBefore && scheduleType == ScheduleType.SKIP_EARLIER;

        for (PaymentBillingDate billingDate : billingDates) {

            if (skipEarlier) {
                // Skipping the earlier PB dates and continuing
                if (transferDetail.getInitiationDate().after(billingDate.getEffectiveDate())) {
                    continue;
                }
            }

            PaymentBillingSchedule billingSchedule = new PaymentBillingSchedule();

            billingSchedule.setEffectiveDate(billingDate.getEffectiveDate());
            billingSchedule.setPercentage(billingDate.getPercentage());
            billingSchedule.setTransferDetail(transferDetail);

            billingSchedules.add(billingSchedule);

            totalPercentage = totalPercentage.add(billingDate.getPercentage());
        }

        if (!billingSchedules.isEmpty()) {

            final BigDecimal percentageCoeff = new BigDecimal(100).divide(totalPercentage);

            boolean offsetPercentage = (skipEarlier && totalPercentage.compareTo(BigDecimal.ZERO) > 0);

            for (PaymentBillingSchedule billingSchedule : billingSchedules) {

                if (offsetPercentage) {
                    billingSchedule.setPercentage(billingSchedule.getPercentage().multiply(percentageCoeff));
                }

                BigDecimal paymentAmount = calculatePaymentAmount(transferDetail.getPlanAmount(),
                        billingSchedule.getPercentage(),
                        billingPlan.getRoundingFactor());

                billingSchedule.setAmount(paymentAmount);
            }

            PaymentBillingSchedule firstLastSchedule =
                    (billingPlan.getPaymentRoundingType() == PaymentRoundingType.FIRST) ?
                            billingSchedules.get(0) : billingSchedules.get(billingSchedules.size() - 1);

            BigDecimal tempAmount = BigDecimal.ZERO;

            for (PaymentBillingSchedule billingSchedule : billingSchedules) {
                if (!billingSchedule.equals(firstLastSchedule)) {
                    tempAmount = tempAmount.add(billingSchedule.getAmount());
                }
            }

            BigDecimal nonRoundedAmount = transferDetail.getPlanAmount().subtract(tempAmount);

            firstLastSchedule.setAmount(nonRoundedAmount);

            if (nonRoundedAmount.compareTo(BigDecimal.ZERO) <= 0) {

                if (roundingFactor <= 0) {
                    String errMsg = "Payment billing rounding problem occurred, PaymentBillingTransferDetail ID = " +
                            transferDetail.getId() + ", non-rounded amount = " + nonRoundedAmount.toString();
                    logger.error(errMsg);
                    throw new IllegalStateException(errMsg);
                } else {

                    String memoText = configService.getParameter(Constants.PAYMENT_BILLING_ROUNDING_PROBLEM_MEMO);

                    String accountId = transferDetail.getDirectChargeAccount().getId();

                    informationService.createMemo(accountId, memoText, new Date(), null, null);

                    // Trying to generate PB schedules again with roundingFactor = 0
                    return generatePaymentBillingSchedules(transferDetail, 0);
                }
            }

            List<PaymentBillingSchedule> finalSchedules = new LinkedList<PaymentBillingSchedule>();

            if (!isInitiationDateBefore && scheduleType == ScheduleType.BALANCE_TODAY) {

                tempAmount = BigDecimal.ZERO;

                for (PaymentBillingSchedule billingSchedule : billingSchedules) {

                    if (billingSchedule.getEffectiveDate().before(transferDetail.getInitiationDate())) {
                        tempAmount = tempAmount.add(billingSchedule.getAmount());
                    } else {
                        finalSchedules.add(billingSchedule);
                    }

                }

                if (tempAmount.compareTo(BigDecimal.ZERO) > 0) {

                    PaymentBillingSchedule billingSchedule = new PaymentBillingSchedule();
                    billingSchedule.setEffectiveDate(transferDetail.getInitiationDate());
                    billingSchedule.setAmount(tempAmount);
                    billingSchedule.setTransferDetail(transferDetail);

                    finalSchedules.add(billingSchedule);
                }

            } else {
                finalSchedules.addAll(billingSchedules);
            }

            // Persisting all PB schedules
            for (PaymentBillingSchedule billingSchedule : finalSchedules) {
                persistEntity(billingSchedule);
            }

            transferDetail.setChargeStatus(PaymentBillingChargeStatus.SCHEDULED);

            persistEntity(transferDetail);

            return finalSchedules;
        }

        return Collections.emptyList();
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

        if (roundingFactor < 0) {
            String errMsg = "Rounding factor cannot be a negative number";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        BigDecimal paymentAmount = totalAmount.multiply(percentage).divide(new BigDecimal(100));

        if (roundingFactor == 0) {
            return paymentAmount.setScale(2, RoundingMode.CEILING);
        }

        BigInteger roundedAmount = paymentAmount.divide(new BigDecimal(roundingFactor)).toBigInteger();

        return new BigDecimal(roundedAmount.add(BigInteger.ONE)).multiply(new BigDecimal(roundingFactor));
    }


    /**
     * This method creates the list of type PaymentBillingTransaction, detailing which transactions can be financed,
     * and how much of each of them can be financed. The parameters for this calculation derive from PaymentBillingPlan.
     * Note that the maxAmount in PaymentBillingTransferDetail allows the system to decrease the amount to finance,
     * allowing a student to finance less than the maximum amount specified in the plan.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingTransaction instances
     */
    @Override
    @Transactional(readOnly = false)
    public List<PaymentBillingTransaction> generatePaymentBillingTransactions(Long transferDetailId) {

        PermissionUtils.checkPermission(Permission.GENERATE_PAYMENT_BILLING_TRANSACTIONS);

        PaymentBillingTransferDetail transferDetail = getPaymentBillingTransferDetail(transferDetailId);
        if (transferDetail == null) {
            String errMsg = "PaymentBillingTransferDetail does not exist with ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (transferDetail.getChargeStatus() != PaymentBillingChargeStatus.INITIALIZED) {
            String errMsg = "PaymentBillingTransferDetail must be " + PaymentBillingChargeStatus.INITIALIZED.toString();
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        PaymentBillingPlan billingPlan = transferDetail.getPlan();
        if (billingPlan == null) {
            String errMsg = "PaymentBillingPlan does not exist for PaymentBillingTransferDetail with ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        List<Charge> charges = transactionService.getCharges(transferDetail.getDirectChargeAccount().getId(),
                billingPlan.getChargePeriodStartDate(),
                billingPlan.getChargePeriodEndDate());

        List<PaymentBillingAllowableCharge> allowableCharges = getPaymentBillingAllowableCharges(billingPlan.getId());

        List<PaymentBillingTransaction> billingTransactions = new LinkedList<PaymentBillingTransaction>();

        for (Charge charge : charges) {

            if (isChargeAllowed(charge, allowableCharges)) {

                PaymentBillingTransaction billingTransaction = new PaymentBillingTransaction();

                billingTransaction.setCharge(charge);
                billingTransaction.setTransferDetail(transferDetail);

                BigDecimal unallocatedAmount = charge.getUnallocatedAmount();

                billingTransaction.setOriginalAmount(charge.getAmount());
                billingTransaction.setOriginalUnallocatedAmount(unallocatedAmount);
                billingTransaction.setRemainingAmount(unallocatedAmount);
                billingTransaction.setFinancedAmount(BigDecimal.ZERO);

                billingTransactions.add(billingTransaction);
            }
        }

        List<PaymentBillingTransaction> resultTransactions = new LinkedList<PaymentBillingTransaction>();

        for (PaymentBillingAllowableCharge allowableCharge : allowableCharges) {

            for (PaymentBillingTransaction billingTransaction : billingTransactions) {

                if (transferDetail.getPlanAmount().compareTo(transferDetail.getMaxAmount()) >= 0) {
                    break;
                }

                if (billingTransaction.getRemainingAmount().compareTo(BigDecimal.ZERO) > 0) {

                    if (isChargeAllowed(billingTransaction.getCharge(), Arrays.asList(allowableCharge))) {

                        final BigDecimal hundredPercent = new BigDecimal(100);

                        BigDecimal maxPercentage = allowableCharge.getMaxPercentage();
                        if (maxPercentage == null) {
                            maxPercentage = hundredPercent;
                        }

                        BigDecimal amountToFinance =
                                billingTransaction.getOriginalAmount().multiply(maxPercentage).divide(hundredPercent);

                        if (amountToFinance.compareTo(billingTransaction.getRemainingAmount()) > 0) {
                            amountToFinance = billingTransaction.getRemainingAmount();
                        }

                        if (billingTransaction.getFinancedAmount().add(amountToFinance).compareTo(allowableCharge.getMaxAmount()) > 0) {
                            amountToFinance = allowableCharge.getMaxAmount().subtract(billingTransaction.getFinancedAmount());
                        }

                        if (transferDetail.getPlanAmount().add(amountToFinance).compareTo(transferDetail.getMaxAmount()) > 0) {
                            amountToFinance = transferDetail.getMaxAmount().subtract(transferDetail.getPlanAmount());
                        }

                        billingTransaction.setRemainingAmount(billingTransaction.getRemainingAmount().subtract(amountToFinance));
                        billingTransaction.setFinancedAmount(billingTransaction.getFinancedAmount().add(amountToFinance));
                        transferDetail.setPlanAmount(transferDetail.getPlanAmount().add(amountToFinance));

                    }

                }

            }
        }

        for (PaymentBillingTransaction billingTransaction : billingTransactions) {
            if (billingTransaction.getFinancedAmount().compareTo(BigDecimal.ZERO) > 0) {
                persistEntity(billingTransaction);
                resultTransactions.add(billingTransaction);
            }
        }

        transferDetail.setChargeStatus(PaymentBillingChargeStatus.ACTIVE);

        return resultTransactions;
    }

    private boolean isChargeAllowed(Charge charge, List<PaymentBillingAllowableCharge> allowableCharges) {
        for (PaymentBillingAllowableCharge allowableCharge : allowableCharges) {
            String transactionTypeMask = allowableCharge.getTransactionTypeMask();
            if (StringUtils.isNotBlank(transactionTypeMask)) {
                if (Pattern.matches(transactionTypeMask, charge.getTransactionType().getId().getId())) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * This method transfers the transactions that make up the payment billing charges and nets off the transactions
     * that are financed for the given PaymentBillingTransferDetail specified by ID.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return PaymentBillingTransferDetail instances
     */
    @Override
    @Transactional(readOnly = false)
    public PaymentBillingTransferDetail transferPaymentBillingTransactions(Long transferDetailId) {

        PaymentBillingTransferDetail transferDetail = getPaymentBillingTransferDetail(transferDetailId);
        if (transferDetail == null) {
            String errMsg = "PaymentBillingTransferDetail does not exist with ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        final PaymentBillingPlan billingPlan = transferDetail.getPlan();
        if (billingPlan == null) {
            String errMsg = "PaymentBillingPlan does not exist for PaymentBillingTransferDetail with ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        transferDetail.setTransferGroupId(transactionTransferService.generateTransferGroupId());

        List<PaymentBillingTransaction> billingTransactions = getPaymentBillingTransactionsByTransferDetailId(transferDetailId);

        if (CollectionUtils.isNotEmpty(billingTransactions)) {

            // Sorting PB transactions by financed amounts
            Collections.sort(billingTransactions, new Comparator<PaymentBillingTransaction>() {
                @Override
                public int compare(PaymentBillingTransaction t1, PaymentBillingTransaction t2) {
                    return t1.getFinancedAmount().compareTo(t2.getFinancedAmount());
                }
            });

            // Getting PB schedules for the transfer detail and sorting them according to he payment rounding type
            List<PaymentBillingSchedule> billingSchedules = getPaymentBillingSchedulesByTransferDetailId(transferDetailId);

            Collections.sort(billingSchedules, new Comparator<PaymentBillingSchedule>() {
                @Override
                public int compare(PaymentBillingSchedule s1, PaymentBillingSchedule s2) {
                    switch (billingPlan.getPaymentRoundingType()) {
                        case FIRST:
                            return s2.getEffectiveDate().compareTo(s1.getEffectiveDate());
                        default:
                            return s1.getEffectiveDate().compareTo(s2.getEffectiveDate());
                    }
                }
            });

            BigDecimal totalFinancedAmount = getTotalFinancedAmount(billingTransactions);

            // Calculating the finance ratio and setting it for each PB transaction
            for (PaymentBillingTransaction billingTransaction : billingTransactions) {
                billingTransaction.setRatio(billingTransaction.getFinancedAmount().divide(totalFinancedAmount));
            }


            for (PaymentBillingSchedule billingSchedule : billingSchedules) {

                // Getting the rollup by Plan ID and PaymentBillingSchedule's effective date
                Rollup rollup = getRollup(billingPlan.getId(), billingSchedule.getEffectiveDate());

                BigDecimal totalTempAmount = BigDecimal.ZERO;

                // Iterating through all, but last PB transactions and calculate temporary amounts
                for (int i = 0; i < billingTransactions.size() - 1; i++) {

                    PaymentBillingTransaction billingTransaction = billingTransactions.get(i);

                    if (billingTransaction.getRemainingAmount().compareTo(BigDecimal.ZERO) > 0) {

                        BigDecimal tempAmount = billingSchedule.getAmount().multiply(billingTransaction.getRatio());
                        if (tempAmount.compareTo(billingTransaction.getRemainingAmount()) > 0) {
                            tempAmount = billingTransaction.getRemainingAmount();
                        }

                        billingTransaction.setTemporaryAmount(tempAmount);

                        totalTempAmount = totalTempAmount.add(tempAmount);

                        // Creating a new transaction transfer
                        transferTransaction(billingTransaction, billingSchedule.getEffectiveDate(), rollup);
                    }
                }

                // Taking the last transaction and setting its temporary amount to
                // PaymentBillingSchedule's amount minus totalTempAmount
                PaymentBillingTransaction lastTransaction = billingTransactions.get(billingTransactions.size() - 1);

                if (billingSchedule.getAmount().compareTo(totalTempAmount) > 0 &&
                        lastTransaction.getRemainingAmount().compareTo(BigDecimal.ZERO) > 0) {

                    lastTransaction.setTemporaryAmount(billingSchedule.getAmount().subtract(totalTempAmount));

                    // Creating a new transaction transfer for the last transaction
                    transferTransaction(lastTransaction, billingSchedule.getEffectiveDate(), rollup);
                }
            }
        }

        if (billingPlan.getFlatFeeAmount() != null && billingPlan.getFlatFeeAmount().compareTo(BigDecimal.ZERO) > 0) {

            Charge flatFeeCharge = (Charge) transactionService.createTransaction(
                    billingPlan.getFlatFeeDebitTypeId(),
                    transferDetail.getDirectChargeAccount().getId(),
                    new Date(),
                    billingPlan.getFlatFeeAmount());

            transferDetail.setFlatFeeCharge(flatFeeCharge);
        }

        if (billingPlan.getVariableFeeAmount() != null && billingPlan.getVariableFeeAmount().compareTo(BigDecimal.ZERO) > 0) {

            BigDecimal amountToCharge = billingPlan.getVariableFeeAmount().multiply(transferDetail.getPlanAmount());

            if (billingPlan.getMaxFeeAmount().compareTo(amountToCharge) < 0) {
                amountToCharge = billingPlan.getMaxFeeAmount();
            }

            if (billingPlan.getMinFeeAmount().compareTo(amountToCharge) > 0) {
                amountToCharge = billingPlan.getMinFeeAmount();
            }

            Charge varFeeCharge = (Charge) transactionService.createTransaction(
                    billingPlan.getVariableFeeDebitTypeId(),
                    transferDetail.getDirectChargeAccount().getId(),
                    new Date(),
                    amountToCharge);

            transferDetail.setVariableFeeCharge(varFeeCharge);
        }

        transferDetail.setChargeStatus(PaymentBillingChargeStatus.ACTIVE);

        return transferDetail;
    }

    private Rollup getRollup(Long paymentBillingPlanId, Date effectiveDate) {
        effectiveDate = CalendarUtils.removeTime(effectiveDate);
        List<PaymentBillingDate> billingDates = getPaymentBillingDates(paymentBillingPlanId);
        for (PaymentBillingDate billingDate : billingDates) {
            if (effectiveDate.equals(CalendarUtils.removeTime(billingDate.getEffectiveDate()))) {
                return billingDate.getRollup();
            }
        }
        return null;
    }

    private TransactionTransfer transferTransaction(PaymentBillingTransaction billingTransaction, Date effectiveDate, Rollup rollup) {

        Charge charge = billingTransaction.getCharge();
        if (charge == null) {
            String errMsg = "PaymentBillingTransaction does not have a reference to Charge, ID = " + billingTransaction.getId();
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        PaymentBillingTransferDetail transferDetail = billingTransaction.getTransferDetail();
        if (transferDetail == null) {
            String errMsg = "PaymentBillingTransaction does not have a reference to PaymentBillingTransferDetail, ID = " + billingTransaction.getId();
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        PaymentBillingPlan plan = transferDetail.getPlan();
        if (plan == null) {
            String errMsg = "PaymentBillingTransferDetail does not have a reference to PaymentBillingPlan, ID = " + transferDetail.getId();
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        TransactionTransfer transactionTransfer = transactionTransferService.transferTransaction(charge.getId(),
                charge.getTransactionType().getId().getId(),
                plan.getTransferType().getId(),
                transferDetail.getDirectChargeAccount().getId(),
                billingTransaction.getTemporaryAmount(),
                effectiveDate,
                null,
                "PB transferred " + charge.getId() + " in amount of " + billingTransaction.getTemporaryAmount() +
                        ", scheduled for " + DateFormat.getDateInstance().format(effectiveDate),
                plan.getStatementPrefix(),
                null
        );

        transactionTransfer.setGroupId(transferDetail.getTransferGroupId());
        transactionTransfer.getDestTransaction().setRollup(rollup);

        if (plan.isGlCreationImmediate()) {
            transactionService.makeEffective(transactionTransfer.getDestTransaction().getId(), true);
        }

        BigDecimal remainingAmount = billingTransaction.getRemainingAmount();
        BigDecimal tempAmount = billingTransaction.getTemporaryAmount();

        billingTransaction.setRemainingAmount(remainingAmount.subtract(tempAmount));
        billingTransaction.setTemporaryAmount(BigDecimal.ZERO);

        return transactionTransfer;
    }

    private BigDecimal getTotalFinancedAmount(List<PaymentBillingTransaction> billingTransactions) {
        BigDecimal totalFinancedAmount = BigDecimal.ZERO;
        for (PaymentBillingTransaction billingTransaction : billingTransactions) {
            BigDecimal financedAmount = billingTransaction.getFinancedAmount();
            if (financedAmount == null) {
                financedAmount = BigDecimal.ZERO;
            }
            totalFinancedAmount = totalFinancedAmount.add(financedAmount);
        }
        return totalFinancedAmount;
    }


    /**
     * Returns payment billing allowable charges for the given plan specified by ID from the persistent store
     * sorted by priorities in the descending order.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return list of PaymentBillingAllowableCharge instances
     */
    @Override
    public List<PaymentBillingAllowableCharge> getPaymentBillingAllowableCharges(Long paymentBillingPlanId) {

        Query query = em.createQuery("select c from PaymentBillingAllowableCharge c " +
                " inner join fetch c.plan p " +
                " where p.id = :planId " +
                " order by c.priority desc");

        query.setParameter("planId", paymentBillingPlanId);

        return query.getResultList();
    }

    /**
     * Returns payment billing dates for the given plan specified by ID from the persistent store
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return list of PaymentBillingDate instances
     */
    @Override
    public List<PaymentBillingDate> getPaymentBillingDates(Long paymentBillingPlanId) {

        Query query = em.createQuery("select d from PaymentBillingDate d " +
                " inner join fetch d.plan p " +
                " left outer join fetch d.rollup r " +
                " where p.id = :planId " +
                " order by d.effectiveDate asc");

        query.setParameter("planId", paymentBillingPlanId);

        return query.getResultList();
    }


}