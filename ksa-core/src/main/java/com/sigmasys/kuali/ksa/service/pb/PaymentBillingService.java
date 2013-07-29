package com.sigmasys.kuali.ksa.service.pb;

import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.pb.*;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Payment Billing Service
 * <p/>
 *
 * @author Michael Ivanov
 */
@Url(PaymentBillingService.SERVICE_URL)
@WebService(serviceName = PaymentBillingService.SERVICE_NAME, portName = PaymentBillingService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
public interface PaymentBillingService {

    String SERVICE_URL = "paymentBilling.webservice";
    String SERVICE_NAME = "PaymentBillingService";
    String PORT_NAME = SERVICE_NAME + "Port";

    /**
     * Creates and persists a payment billing transfer detail object for the given parameters.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @param accountId            DirectChargeAccount ID
     * @param maxAmount            Maximum amount to finance
     * @param initiationDate       Initiation Date
     * @return PaymentBillingTransferDetail instance
     */
    PaymentBillingTransferDetail generatePaymentBillingTransfer(Long paymentBillingPlanId,
                                                                String accountId,
                                                                BigDecimal maxAmount,
                                                                Date initiationDate);

    /**
     * Creates and persists a new PaymentBillingPlan instance in the persistent store
     *
     * @param code                   PaymentBillingPlan code
     * @param name                   PaymentBillingPlan name
     * @param description            PaymentBillingPlan description
     * @param transferTypeId         TransferType ID
     * @param flatFeeDebitTypeId     Flat fee DebitType ID
     * @param variableFeeDebitTypeId Variable fee DebitType ID
     * @param openPeriodStartDate    Open period start date
     * @param openPeriodEndDate      Open period end date
     * @param chargePeriodStartDate  Charge period start date
     * @param chargePeriodEndDate    Charge period end date
     * @param maxAmount              Maximum amount
     * @param flatFeeAmount          Flat fee amount
     * @param variableFeeAmount      Variable fee amount
     * @param minFeeAmount           Minimum fee amount
     * @param maxFeeAmount           Maximum fee amount
     * @param roundingFactor         Rounding factor
     * @param isGlCreationImmediate  Indicates whether GL transaction creation is immediate
     * @param statementPrefix        Transaction statement prefix
     * @param paymentRoundingType    Payment rounding type
     * @param scheduleType           Schedule type
     * @return PaymentBillingPlan instance
     */
    PaymentBillingPlan createPaymentBillingPlan(
            String code,
            String name,
            String description,
            Long transferTypeId,
            String flatFeeDebitTypeId,
            String variableFeeDebitTypeId,
            Date openPeriodStartDate,
            Date openPeriodEndDate,
            Date chargePeriodStartDate,
            Date chargePeriodEndDate,
            BigDecimal maxAmount,
            BigDecimal flatFeeAmount,
            BigDecimal variableFeeAmount,
            BigDecimal minFeeAmount,
            BigDecimal maxFeeAmount,
            int roundingFactor,
            boolean isGlCreationImmediate,
            String statementPrefix,
            PaymentRoundingType paymentRoundingType,
            ScheduleType scheduleType);

    /**
     * Retrieves PaymentBillingPlan instance by ID from the persistent store.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return PaymentBillingPlan instance
     */
    PaymentBillingPlan getPaymentBillingPlan(Long paymentBillingPlanId);

    /**
     * Retrieves PaymentBillingTransferDetail with ACTIVE status by ID from the persistent store.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return PaymentBillingTransferDetail instance
     */
    PaymentBillingTransferDetail getPaymentBillingTransferDetail(Long transferDetailId);


    /**
     * Reverses a payment billing transfer specified by PaymentBillingTransferDetail ID.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @param memoText         Memo text
     * @param removeFees       if true, then the fee charges will also be reversed
     * @return PaymentBillingTransferDetail instance
     */
    PaymentBillingTransferDetail reversePaymentBillingTransfer(Long transferDetailId, String memoText, boolean removeFees);


    /**
     * Persists PaymentBillingTransferDetail instance in the persistent store.
     *
     * @param transferDetail PaymentBillingTransferDetail instance
     * @return PaymentBillingTransferDetail ID
     */
    Long persistPaymentBillingTransferDetail(PaymentBillingTransferDetail transferDetail);

    /**
     * Returns a list of payment billing transactions for the plan specified by ID.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return list of PaymentBillingTransaction instances
     */
    List<PaymentBillingTransaction> getPaymentBillingTransactionsByPlanId(Long paymentBillingPlanId);

    /**
     * Returns a list of payment billing transactions for the transfer detail specified by ID.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingTransaction instances
     */
    List<PaymentBillingTransaction> getPaymentBillingTransactionsByTransferDetailId(Long transferDetailId);

    /**
     * Returns a list of payment billing schedules for the transfer detail specified by ID.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingSchedule instances
     */
    List<PaymentBillingSchedule> getPaymentBillingSchedulesByTransferDetailId(Long transferDetailId);

    /**
     * Generates a list of PaymentBillingSchedule objects for the given PaymentBillingTransferDetail ID
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingSchedule instances
     */
    List<PaymentBillingSchedule> generatePaymentBillingSchedules(Long transferDetailId);

    /**
     * This method creates the list of type PaymentBillingTransaction, detailing which transactions can be financed,
     * and how much of each of them can be financed. The parameters for this calculation derive from PaymentBillingPlan.
     * Note that the maxAmount in PaymentBillingTransferDetail allows the system to decrease the amount to finance,
     * allowing a student to finance less than the maximum amount specified in the plan.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingTransaction instances
     */
    List<PaymentBillingTransaction> generatePaymentBillingTransactions(Long transferDetailId);

    /**
     * This method transfers the transactions that make up the payment billing charges and nets off the transactions
     * that are financed for the given PaymentBillingTransferDetail specified by ID.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return PaymentBillingTransferDetail instance
     */
    PaymentBillingTransferDetail transferPaymentBillingTransactions(Long transferDetailId);

    /**
     * Returns payment billing allowable charges for the given plan specified by ID from the persistent store
     * sorted by priorities in the descending order.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return list of PaymentBillingAllowableCharge instances
     */
    List<PaymentBillingAllowableCharge> getPaymentBillingAllowableCharges(Long paymentBillingPlanId);

    /**
     * Returns payment billing dates for the given plan specified by ID from the persistent store
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return list of PaymentBillingDate instances
     */
    List<PaymentBillingDate> getPaymentBillingDates(Long paymentBillingPlanId);

    /**
     * Returns a list of PaymentBillingQueue objects by Account and PaymentBillingTransferDetail IDs
     *
     * @param accountId        Account Id
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingQueue instances
     */
    List<PaymentBillingQueue> getPaymentBillingQueues(String accountId, Long transferDetailId);

    /**
     * Returns a list of PaymentBillingQueue objects by Creator and PaymentBillingTransferDetail IDs
     *
     * @param creatorId        Creator Id
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingQueue instances
     */
    List<PaymentBillingQueue> getPaymentBillingQueuesByCreatorId(String creatorId, Long transferDetailId);

    /**
     * Executes a payment billing plan for the specified user account with the given maximum payment amount.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @param accountId            Account Id
     * @param maxAmount            Maximum payment amount
     * @param initiationDate       Initiation date
     * @return PaymentBillingTransferDetail instance
     */
    PaymentBillingTransferDetail executePaymentBilling(Long paymentBillingPlanId,
                                                       String accountId,
                                                       BigDecimal maxAmount,
                                                       Date initiationDate);

    /**
     * Processes PaymentBillingQueue objects for the given Account ID.
     *
     * @param accountId Account ID
     */
    void processPaymentBillingQueues(String accountId);

    /**
     * Processes PaymentBillingQueue objects for the given Creator ID.
     *
     * @param creatorId Creator's account ID
     */
    void processPaymentBillingQueuesByCreator(String creatorId);

    /**
     * Creates and persists a new PaymentBillingQueue object.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @param accountId            Account ID
     * @param maxAmount            Maximum payment amount
     * @param initiationDate       Initiation date
     * @param forceReversal        Indicates whether to force reversal of previously created PB transfers
     * @return PaymentBillingQueue instance
     */
    PaymentBillingQueue createPaymentBillingQueue(Long paymentBillingPlanId,
                                                  String accountId,
                                                  BigDecimal maxAmount,
                                                  Date initiationDate,
                                                  boolean forceReversal);


}
