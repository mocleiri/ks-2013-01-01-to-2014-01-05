package com.sigmasys.kuali.ksa.service.pb.impl;

import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.pb.PaymentBillingChargeStatus;
import com.sigmasys.kuali.ksa.model.pb.PaymentBillingPlan;
import com.sigmasys.kuali.ksa.model.pb.PaymentBillingTransferDetail;
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
     * @param effectiveDate        Effective Date
     * @return PaymentBillingTransferDetail instance
     */
    @Override
    @Transactional(readOnly = false)
    public PaymentBillingTransferDetail generatePaymentBillingTransfer(Long paymentBillingPlanId,
                                                                       String accountId,
                                                                       BigDecimal maxAmount,
                                                                       Date effectiveDate) {
        // TODO

        return null;
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


}