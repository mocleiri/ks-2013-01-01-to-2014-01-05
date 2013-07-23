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
     * Generates a list of PaymentBillingSchedule objects for the given PaymentBillingPlan ID
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return list of PaymentBillingSchedule instances
     */
    List<PaymentBillingSchedule> generatePaymentBillingSchedules(Long paymentBillingPlanId);

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
     * This method creates the transactions that make up the payment billing charges and nets off the transactions
     * that are financed for the given PaymentBillingTransferDetail specified by ID.
     *
     * @param transferDetailId PaymentBillingTransferDetail ID
     * @return list of PaymentBillingTransaction instances
     */
    List<PaymentBillingTransaction> createPaymentBillingTransactions(Long transferDetailId);

    /**
     * Returns payment billing allowable charges for the given plan specified by ID from the persistent store
     * sorted by priorities in the descending order.
     *
     * @param paymentBillingPlanId PaymentBillingPlan ID
     * @return list of PaymentBillingAllowableCharge instances
     */
    List<PaymentBillingAllowableCharge> getPaymentBillingAllowableCharges(Long paymentBillingPlanId);


    // TODO

}
