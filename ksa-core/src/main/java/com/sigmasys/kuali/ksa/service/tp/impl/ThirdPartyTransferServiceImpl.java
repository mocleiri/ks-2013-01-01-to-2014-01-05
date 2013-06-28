package com.sigmasys.kuali.ksa.service.tp.impl;

import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.tp.*;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.TransactionTransferService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.service.tp.ThirdPartyTransferService;
import com.sigmasys.kuali.ksa.util.TransactionUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


/**
 * Third-Party Transfer Service implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("thirdPartyTransferService")
@Transactional(readOnly = true)
@WebService(serviceName = TransactionTransferService.SERVICE_NAME, portName = TransactionTransferService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
@SuppressWarnings("unchecked")
public class ThirdPartyTransferServiceImpl extends GenericPersistenceService implements ThirdPartyTransferService {

    private static final Log logger = LogFactory.getLog(ThirdPartyTransferServiceImpl.class);

    private static final String TRANSFER_DETAIL_SELECT = "select d from ThirdPartyTransferDetail d " +
            " left outer join fetch d.directChargeAccount dca " +
            " left outer join fetch d.plan p " +
            " left outer join fetch p.thirdPartyAccount tpa " +
            " left outer join fetch p.transferType t " +
            " left outer join fetch t.generalLedgerType g ";

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionTransferService transactionTransferService;

    @Autowired
    private AccountService accountService;


    /**
     * Retrieves ThirdPartyPlan instance by ID from the persistence store.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @return ThirdPartyPlan instance
     */
    @Override
    public ThirdPartyPlan getThirdPartyPlan(Long thirdPartyPlanId) {

        Query query = em.createQuery("select p from ThirdPartyPlan p " +
                " left outer join fetch p.thirdPartyAccount a " +
                " left outer join fetch p.transferType t " +
                " left outer join fetch t.generalLedgerType g " +
                " where p.id = :id");

        query.setParameter("id", thirdPartyPlanId);

        List<ThirdPartyPlan> plans = query.getResultList();

        return CollectionUtils.isNotEmpty(plans) ? plans.get(0) : null;
    }


    /**
     * Retrieves ThirdPartyTransferDetail with ACTIVE status by ID from the persistent store.
     *
     * @param thirdPartyTransferDetailId ThirdPartyTransferDetail ID
     * @return ThirdPartyTransferDetail instance
     */
    @Override
    public ThirdPartyTransferDetail getThirdPartyTransferDetail(Long thirdPartyTransferDetailId) {

        Query query = em.createQuery(TRANSFER_DETAIL_SELECT + " where d.id = :id and d.chargeStatusCode = :statusCode");

        query.setParameter("id", thirdPartyTransferDetailId);
        query.setParameter("statusCode", ThirdPartyChargeStatus.ACTIVE_CODE);

        List<ThirdPartyTransferDetail> details = query.getResultList();

        return CollectionUtils.isNotEmpty(details) ? details.get(0) : null;
    }

    /**
     * Retrieves ThirdPartyTransferDetail with ACTIVE status by ThirdPartyPlan and Account IDs
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param accountId        Account ID
     * @return ThirdPartyTransferDetail instance
     */
    @Override
    @WebMethod(exclude = true)
    public ThirdPartyTransferDetail getThirdPartyTransferDetail(Long thirdPartyPlanId, String accountId) {

        Query query = em.createQuery(TRANSFER_DETAIL_SELECT +
                " where p.id = :planId and dca.id = :accountId and d.chargeStatusCode = :statusCode");

        query.setParameter("planId", thirdPartyPlanId);
        query.setParameter("accountId", accountId);
        query.setParameter("statusCode", ThirdPartyChargeStatus.ACTIVE_CODE);

        List<ThirdPartyTransferDetail> details = query.getResultList();

        return CollectionUtils.isNotEmpty(details) ? details.get(0) : null;
    }


    /**
     * Returns the list of third-party allowable charges by ThirdPartyPlan ID sorted by priority in the descending order.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @return list of ThirdPartyAllowableCharge instances
     */
    @Override
    public List<ThirdPartyAllowableCharge> getThirdPartyAllowableCharges(Long thirdPartyPlanId) {

        Query query = em.createQuery("select c from ThirdPartyAllowableCharge c " +
                " inner join fetch c.plan p " +
                " where p.id = :planId " + "" +
                " order by c.priority desc");

        query.setParameter("planId", thirdPartyPlanId);

        return query.getResultList();
    }


    /**
     * This method takes an account and follows the established third-party plan and applies it to the account.
     * The return value is a ThirdPartyTransferDetail object that explains what occurred during the plan execution.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param accountId        Account ID
     * @param initiationDate   Initiation date
     * @return ThirdPartyTransferDetail instance
     */
    @Override
    @Transactional(readOnly = false)
    public ThirdPartyTransferDetail generateThirdPartyTransfer(Long thirdPartyPlanId, String accountId, Date initiationDate) {

        ThirdPartyPlan thirdPartyPlan = getThirdPartyPlan(thirdPartyPlanId);
        if (thirdPartyPlan == null) {
            String errMsg = "ThirdPartyPlan does not exist with ID = " + thirdPartyPlanId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Account account = accountService.getFullAccount(accountId);
        if (account == null || !(account instanceof DirectChargeAccount)) {
            String errMsg = "DirectChargeAccount with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        Query query = em.createQuery("select m from ThirdPartyPlanMember m " +
                " inner join fetch m.directChargeAccount a " +
                " inner join m.thirdPartyPlan p " +
                " where p.id = :planId and a.id = :accountId");

        query.setParameter("planId", thirdPartyPlanId);
        query.setParameter("accountId", accountId);

        List<ThirdPartyPlanMember> members = query.getResultList();

        if (CollectionUtils.isEmpty(members)) {
            String errMsg = "Account '" + accountId + "' is not eligible for this plan (ThirdPartyPlan ID = " + thirdPartyPlanId + ")";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        ThirdPartyPlanMember planMember = members.get(0);

        ThirdPartyTransferDetail transferDetail;

        BigDecimal remainingFund;

        BigDecimal maxAmount = (thirdPartyPlan.getMaxAmount() != null) ? thirdPartyPlan.getMaxAmount() : BigDecimal.ZERO;

        if (planMember.isExecuted()) {

            transferDetail = getThirdPartyTransferDetail(thirdPartyPlanId, accountId);
            if (transferDetail == null) {
                String errMsg = "Cannot find ThirdPartyTransferDetail instance for Plan ID = " + thirdPartyPlanId +
                        " and Account ID = " + accountId;
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }

            remainingFund = maxAmount.subtract(transferDetail.getTransferAmount());

        } else {

            // Creating a new transfer detail instance
            transferDetail = new ThirdPartyTransferDetail();
            transferDetail.setTransferGroupId(transactionTransferService.generateTransferGroupId());
            transferDetail.setDirectChargeAccount((DirectChargeAccount) account);
            transferDetail.setPlan(thirdPartyPlan);
            transferDetail.setChargeStatus(ThirdPartyChargeStatus.ACTIVE);
            transferDetail.setInitiationDate(initiationDate);

            remainingFund = maxAmount;
        }

        // Initializing the transaction effective date comparator
        TransactionUtils.EffectiveDateComparator dateComparator = new TransactionUtils.EffectiveDateComparator();

        // Getting allowable charges for the plan sorted by priority
        List<ThirdPartyAllowableCharge> allowableCharges = getThirdPartyAllowableCharges(thirdPartyPlanId);

        for (ThirdPartyAllowableCharge allowableCharge : allowableCharges) {

            BigDecimal chargeRemainingFund = allowableCharge.getMaxAmount();

            if (chargeRemainingFund != null && planMember.isExecuted()) {

                // Getting transfer details with the same transaction type mask and Transfer Group ID
                query = em.createQuery("select sum(t.transferAmount - t.reversalAmount) from TransactionTransfer t " +
                        " where t.transferAmount <> null and t.reversalAmount <> null and " +
                        " t.groupId = :groupId and t.transactionTypeMask = :typeMask");

                query.setParameter("groupId", transferDetail.getTransferGroupId());
                query.setParameter("typeMask", allowableCharge.getTransactionTypeMask());

                List<Object> results = query.getResultList();

                if (CollectionUtils.isNotEmpty(results)) {
                    chargeRemainingFund = chargeRemainingFund.subtract(new BigDecimal(results.get(0).toString()));
                }
            }

            // Retrieving the list of transactions for the given user ID and date range
            List<Transaction> transactions = transactionService.getTransactions(accountId,
                    thirdPartyPlan.getChargePeriodStartDate(), thirdPartyPlan.getChargePeriodEndDate());

            // Sorting transactions by effective date
            Collections.sort(transactions, dateComparator);

            Pattern typeMaskPattern = Pattern.compile(allowableCharge.getTransactionTypeMask());

            BigDecimal totalUnallocatedAmount = BigDecimal.ZERO;

            for (Transaction transaction : transactions) {

                String transactionTypeId = transaction.getTransactionType().getId().getId();

                if (typeMaskPattern.matcher(transactionTypeId).matches()) {

                    BigDecimal unallocatedAmount = transactionService.getUnallocatedAmount(transaction);
                    if (unallocatedAmount.compareTo(BigDecimal.ZERO) > 0) {
                        totalUnallocatedAmount = totalUnallocatedAmount.add(unallocatedAmount);
                    }

                }
            }

            final BigDecimal hundredPercent = new BigDecimal(100);

            BigDecimal maxPercentage = allowableCharge.getMaxPercentage();
            if (maxPercentage == null || maxPercentage.compareTo(hundredPercent) > 0) {
                maxPercentage = hundredPercent;
            }

            BigDecimal financeChargeAmount = totalUnallocatedAmount.multiply(maxPercentage);

            if ((chargeRemainingFund == null || financeChargeAmount.compareTo(chargeRemainingFund) < 0) &&
                    (remainingFund == null || financeChargeAmount.compareTo(remainingFund) < 0)) {

                // Doing non-divided funding

                for (Transaction transaction : transactions) {

                    if (remainingFund.compareTo(BigDecimal.ZERO) <= 0) {
                        break;
                    }

                    Date effectiveDate = thirdPartyPlan.getEffectiveDate();
                    if (effectiveDate == null) {
                        effectiveDate = transaction.getEffectiveDate();
                    }

                    Date recognitionDate = thirdPartyPlan.getRecognitionDate();
                    if (recognitionDate == null) {
                        recognitionDate = transaction.getRecognitionDate();
                    }

                    // Creating a new transaction transfer
                    TransactionTransfer transactionTransfer =
                            transactionTransferService.transferTransaction(
                                    transaction.getId(),
                                    transaction.getTransactionType().getId().getId(),
                                    thirdPartyPlan.getTransferType().getId(),
                                    // TODO: or thirdPartyPlan.getThirdPartyAccount().getId() ???
                                    accountId,
                                    transaction.getAmount().multiply(maxPercentage),
                                    effectiveDate,
                                    recognitionDate,
                                    // TODO: set memo text and statement prefix,
                                    null,
                                    null,
                                    allowableCharge.getTransactionTypeMask());

                    // Setting Transfer Group ID
                    transactionTransfer.setGroupId(transferDetail.getTransferGroupId());

                    // Subtracting the transfer amount from the remaining fund
                    remainingFund = remainingFund.subtract(transactionTransfer.getTransferAmount());
                }

            } else {

                // Doing divided funding

                // Taking the smallest funding amount from remainingFund and chargeRemainingFund
                BigDecimal maxDividedFund = remainingFund;
                if (maxDividedFund.compareTo(chargeRemainingFund) > 0) {
                    maxDividedFund = chargeRemainingFund;
                }

                if (allowableCharge.getDistributionPlan() == ChargeDistributionPlan.FULL) {

                    for (Transaction transaction : transactions) {

                        if (maxDividedFund.compareTo(BigDecimal.ZERO) <= 0 ||
                                remainingFund.compareTo(BigDecimal.ZERO) <= 0) {
                            break;
                        }

                        BigDecimal transferAmount = transaction.getAmount().multiply(maxPercentage);

                        if (transferAmount.compareTo(maxDividedFund) > 0) {
                            transferAmount = maxDividedFund;
                        }

                        Date effectiveDate = thirdPartyPlan.getEffectiveDate();
                        if (effectiveDate == null) {
                            effectiveDate = transaction.getEffectiveDate();
                        }

                        Date recognitionDate = thirdPartyPlan.getRecognitionDate();
                        if (recognitionDate == null) {
                            recognitionDate = transaction.getRecognitionDate();
                        }

                        // Creating a new transaction transfer
                        TransactionTransfer transactionTransfer =
                                transactionTransferService.transferTransaction(
                                        transaction.getId(),
                                        transaction.getTransactionType().getId().getId(),
                                        thirdPartyPlan.getTransferType().getId(),
                                        // TODO: or thirdPartyPlan.getThirdPartyAccount().getId() ???
                                        accountId,
                                        transferAmount,
                                        effectiveDate,
                                        recognitionDate,
                                        // TODO: set memo text and statement prefix,
                                        null,
                                        null,
                                        allowableCharge.getTransactionTypeMask());

                        // Setting Transfer Group ID
                        transactionTransfer.setGroupId(transferDetail.getTransferGroupId());

                        // Subtracting the transfer amount from the maxDividedFund fund
                        maxDividedFund = maxDividedFund.subtract(transactionTransfer.getTransferAmount());

                        // Subtracting the transfer amount from the remaining fund
                        remainingFund = remainingFund.subtract(transactionTransfer.getTransferAmount());
                    }

                }


            }

        }


        // TODO


        return null;
    }


}