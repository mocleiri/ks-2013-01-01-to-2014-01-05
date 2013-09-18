package com.sigmasys.kuali.ksa.service.tp.impl;

import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.model.tp.*;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.TransactionTransferService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import com.sigmasys.kuali.ksa.service.tp.ThirdPartyTransferService;
import com.sigmasys.kuali.ksa.util.CalendarUtils;
import com.sigmasys.kuali.ksa.util.TransactionUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.*;
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
            " inner join fetch d.directChargeAccount dca " +
            " left outer join fetch d.plan p " +
            " left outer join fetch p.thirdPartyAccount tpa " +
            " left outer join fetch p.transferType t " +
            " left outer join fetch t.generalLedgerType g ";

    private static final String TRANSFER_PLAN_SELECT = "select p from ThirdPartyPlan p " +
            " inner join fetch p.thirdPartyAccount a " +
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
     * Creates and persists a new third-party billing plan based on the given parameters.
     *
     * @param code                  ThirdPartyPlan code
     * @param name                  ThirdPartyPlan name
     * @param description           ThirdPartyPlan description
     * @param transferTypeId        TransferType ID
     * @param thirdPartyAccountId   ThirdPartyAccount ID
     * @param maxAmount             Maximum transfer amount
     * @param effectiveDate         Effective Date
     * @param recognitionDate       Recognition Date
     * @param openPeriodStartDate   Open Period Start Date
     * @param openPeriodEndDate     Open Period End Date
     * @param chargePeriodStartDate Charge Period Start Date
     * @param chargePeriodEndDate   Charge Period End Date
     * @return ThirdPartyPlan instance
     */
    @Override
    @Transactional(readOnly = false)
    public ThirdPartyPlan createThirdPartyPlan(String code,
                                               String name,
                                               String description,
                                               Long transferTypeId,
                                               String thirdPartyAccountId,
                                               BigDecimal maxAmount,
                                               Date effectiveDate,
                                               Date recognitionDate,
                                               Date openPeriodStartDate,
                                               Date openPeriodEndDate,
                                               Date chargePeriodStartDate,
                                               Date chargePeriodEndDate) {

        PermissionUtils.checkPermission(Permission.CREATE_THIRD_PARTY_PLAN);

        if (StringUtils.isBlank(code)) {
            String errMsg = "ThirdPartyPlan code is required";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        TransferType transferType = transactionTransferService.getTransferType(transferTypeId);
        if (transferType == null) {
            String errMsg = "TransferType does not exist with ID = " + transferTypeId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Account account = accountService.getFullAccount(thirdPartyAccountId);
        if (account == null || !(account instanceof ThirdPartyAccount)) {
            String errMsg = "ThirdPartyAccount with ID = " + thirdPartyAccountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        if (openPeriodStartDate.after(openPeriodEndDate)) {
            String errMsg = "Open Period Start Date cannot be before End Date";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (chargePeriodStartDate.after(chargePeriodEndDate)) {
            String errMsg = "Charge Period Start Date cannot be before End Date";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        ThirdPartyPlan plan = new ThirdPartyPlan();

        plan.setCode(code);
        plan.setName(name);
        plan.setDescription(description);
        plan.setTransferType(transferType);
        plan.setThirdPartyAccount((ThirdPartyAccount) account);
        plan.setEffectiveDate(effectiveDate);
        plan.setRecognitionDate(recognitionDate);
        plan.setOpenPeriodStartDate(openPeriodStartDate);
        plan.setOpenPeriodEndDate(openPeriodEndDate);
        plan.setChargePeriodStartDate(chargePeriodStartDate);
        plan.setChargePeriodEndDate(chargePeriodEndDate);

        // Persisting a new created plan
        auditableEntityService.persistAuditableEntity(plan);

        return plan;
    }

    /**
     * Creates and persists a new third-party plan member for the given DirectChargeAccount and plan IDs
     *
     * @param accountId        DirectChargeAccount ID
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param priority         Priority
     * @return ThirdPartyPlanMember instance
     */
    @Override
    @Transactional(readOnly = false)
    public ThirdPartyPlanMember createThirdPartyPlanMember(String accountId, Long thirdPartyPlanId, int priority) {

        PermissionUtils.checkPermission(Permission.CREATE_THIRD_PARTY_PLAN_MEMBER);

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

        ThirdPartyPlanMember planMember = new ThirdPartyPlanMember();

        planMember.setDirectChargeAccount((DirectChargeAccount) account);
        planMember.setAccountId(accountId);
        planMember.setPlan(thirdPartyPlan);
        planMember.setPriority(priority);
        planMember.setExecuted(false);

        persistEntity(planMember);

        return planMember;
    }


    /**
     * Creates and persists a new ThirdPartyAllowableCharge instance for the given parameters.
     *
     * @param thirdPartyPlanId    ThirdPartyPlan ID
     * @param transactionTypeMask Transaction Type Mask
     * @param maxAmount           Maximum amount
     * @param maxPercentage       Maximum percentage
     * @param priority            Priority
     * @param distributionPlan    Charge Distribution Plan
     * @return ThirdPartyAllowableCharge instance
     */
    @Override
    @Transactional(readOnly = false)
    public ThirdPartyAllowableCharge createThirdPartyAllowableCharge(Long thirdPartyPlanId,
                                                                     String transactionTypeMask,
                                                                     BigDecimal maxAmount,
                                                                     BigDecimal maxPercentage,
                                                                     int priority,
                                                                     ChargeDistributionPlan distributionPlan) {

        PermissionUtils.checkPermission(Permission.CREATE_THIRD_PARTY_ALLOWABLE_CHARGE);

        ThirdPartyPlan thirdPartyPlan = getThirdPartyPlan(thirdPartyPlanId);
        if (thirdPartyPlan == null) {
            String errMsg = "ThirdPartyPlan does not exist with ID = " + thirdPartyPlanId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (StringUtils.isBlank(transactionTypeMask)) {
            String errMsg = "Transaction type mask cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (maxPercentage == null) {
            String errMsg = "Maximum percentage cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (distributionPlan == null) {
            String errMsg = "Charge distribution plan is required";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        ThirdPartyAllowableCharge allowableCharge = new ThirdPartyAllowableCharge();

        allowableCharge.setPlan(thirdPartyPlan);
        allowableCharge.setTransactionTypeMask(transactionTypeMask);
        allowableCharge.setMaxAmount(maxAmount);
        allowableCharge.setMaxPercentage(maxPercentage);
        allowableCharge.setPriority(priority);
        allowableCharge.setDistributionPlan(distributionPlan);

        persistEntity(allowableCharge);

        return allowableCharge;
    }


    /**
     * Retrieves ThirdPartyPlan instance by ID from the persistence store.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @return ThirdPartyPlan instance
     */
    @Override
    public ThirdPartyPlan getThirdPartyPlan(Long thirdPartyPlanId) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_PLAN);

        Query query = em.createQuery(TRANSFER_PLAN_SELECT + " where p.id = :id");

        query.setParameter("id", thirdPartyPlanId);

        List<ThirdPartyPlan> plans = query.getResultList();

        return CollectionUtils.isNotEmpty(plans) ? plans.get(0) : null;
    }

    /**
     * Retrieves ThirdPartyPlan instances by the given name pattern.
     *
     * @param pattern Name pattern
     * @return list of ThirdPartyPlan instances.
     */
    @Override
    public List<ThirdPartyPlan> getThirdPartyPlanByNamePattern(String pattern) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_PLAN);

        Query query = em.createQuery(TRANSFER_PLAN_SELECT + " where upper(p.name) like upper(:pattern)");

        query.setParameter("pattern", "%" + pattern + "%");

        return query.getResultList();
    }

    /**
     * Retrieves ThirdPartyPlan instances for the given ThirdPartyAccount IDs.
     *
     * @param thirdPartyAccountIds Set of ThirdPartyAccount IDs
     * @return list of ThirdPartyPlan instances
     */
    @Override
    public List<ThirdPartyPlan> getThirdPartyPlans(Set<String> thirdPartyAccountIds) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_PLAN);

        boolean idsExist = CollectionUtils.isNotEmpty(thirdPartyAccountIds);

        Query query = em.createQuery(TRANSFER_PLAN_SELECT + (idsExist ? " where a.id in (:ids)" : "") + " order by p.id desc");

        if (idsExist) {
            query.setParameter("ids", thirdPartyAccountIds);
        }

        return query.getResultList();
    }

    /**
     * Retrieves all ThirdPartyPlan instances.
     *
     * @return list of ThirdPartyPlan instances
     */
    @Override
    @WebMethod(exclude = true)
    public List<ThirdPartyPlan> getThirdPartyPlans() {
        return getThirdPartyPlans(Collections.<String>emptySet());
    }


    /**
     * Retrieves ThirdPartyTransferDetail with ACTIVE status by ID from the persistent store.
     *
     * @param thirdPartyTransferDetailId ThirdPartyTransferDetail ID
     * @return ThirdPartyTransferDetail instance
     */
    @Override
    public ThirdPartyTransferDetail getThirdPartyTransferDetail(Long thirdPartyTransferDetailId) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_TRANSFER_DETAIL);

        Query query = em.createQuery(TRANSFER_DETAIL_SELECT + " where d.id = :id and d.chargeStatusCode = :statusCode");

        query.setParameter("id", thirdPartyTransferDetailId);
        query.setParameter("statusCode", ThirdPartyChargeStatus.ACTIVE_CODE);

        List<ThirdPartyTransferDetail> details = query.getResultList();

        return CollectionUtils.isNotEmpty(details) ? details.get(0) : null;
    }

    /**
     * Retrieves ThirdPartyTransferDetail with ACTIVE status by ThirdPartyPlan and DirectChargeAccount ID
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param accountId        DirectChargeAccount ID
     * @return ThirdPartyTransferDetail instance
     */
    @Override
    @WebMethod(exclude = true)
    public ThirdPartyTransferDetail getThirdPartyTransferDetail(Long thirdPartyPlanId, String accountId) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_TRANSFER_DETAIL);

        Query query = em.createQuery(TRANSFER_DETAIL_SELECT +
                " where p.id = :planId and dca.id = :accountId and d.chargeStatusCode = :statusCode");

        query.setParameter("planId", thirdPartyPlanId);
        query.setParameter("accountId", accountId);
        query.setParameter("statusCode", ThirdPartyChargeStatus.ACTIVE_CODE);

        List<ThirdPartyTransferDetail> details = query.getResultList();

        return CollectionUtils.isNotEmpty(details) ? details.get(0) : null;
    }

    /**
     * Retrieves ThirdPartyTransferDetail objects with all statuses by DirectChargeAccount ID
     *
     * @param accountId DirectChargeAccount ID
     * @return list of ThirdPartyTransferDetail instances
     */
    @Override
    public List<ThirdPartyTransferDetail> getThirdPartyTransferDetails(String accountId) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_TRANSFER_DETAIL);

        Query query = em.createQuery(TRANSFER_DETAIL_SELECT + " where dca.id = :accountId order by d.id desc");

        query.setParameter("accountId", accountId);

        return query.getResultList();
    }


    /**
     * Returns a list of third-party allowable charges by ThirdPartyPlan ID sorted by priority in the descending order.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @return list of ThirdPartyAllowableCharge instances
     */
    @Override
    public List<ThirdPartyAllowableCharge> getThirdPartyAllowableCharges(Long thirdPartyPlanId) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_ALLOWABLE_CHARGE);

        Query query = em.createQuery("select c from ThirdPartyAllowableCharge c " +
                " inner join fetch c.plan p " +
                " where p.id = :planId " + "" +
                " order by c.priority desc");

        query.setParameter("planId", thirdPartyPlanId);

        return query.getResultList();
    }

    /**
     * Retrieves ThirdPartyPlanMember objects from the persistent store for the given plan ID.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @return list of ThirdPartyPlanMember instances
     */
    @Override
    public List<ThirdPartyPlanMember> getThirdPartyPlanMembers(Long thirdPartyPlanId) {
        return getThirdPartyPlanMembers(thirdPartyPlanId, null);
    }

    /**
     * Retrieves ThirdPartyPlanMember instance from the persistent store by TP plan ID and DirectChargeAccount ID.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param accountId        DirectChargeAccount ID
     * @return ThirdPartyPlanMember instance
     */
    @Override
    public ThirdPartyPlanMember getThirdPartyPlanMember(Long thirdPartyPlanId, String accountId) {
        List<ThirdPartyPlanMember> planMembers = getThirdPartyPlanMembers(thirdPartyPlanId, accountId);
        return CollectionUtils.isNotEmpty(planMembers) ? planMembers.get(0) : null;
    }

    protected List<ThirdPartyPlanMember> getThirdPartyPlanMembers(Long thirdPartyPlanId, String accountId) {

        PermissionUtils.checkPermission(Permission.READ_THIRD_PARTY_PLAN_MEMBER);

        Query query = em.createQuery("select m from ThirdPartyPlanMember m " +
                " inner join fetch m.directChargeAccount a " +
                " inner join fetch m.plan p " +
                " where p.id = :planId " + ((accountId != null) ? "and a.id = :accountId" : ""));

        query.setParameter("planId", thirdPartyPlanId);

        if (accountId != null) {
            query.setParameter("accountId", accountId);
        }

        return query.getResultList();
    }


    /**
     * This method takes an account and follows the established third-party plan and applies it to the account.
     * The return value is a ThirdPartyTransferDetail object that explains what occurred during the plan execution.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param accountId        DirectChargeAccount ID
     * @param initiationDate   Initiation date
     * @return ThirdPartyTransferDetail instance
     */
    @Override
    @Transactional(readOnly = false)
    public ThirdPartyTransferDetail generateThirdPartyTransfer(Long thirdPartyPlanId, String accountId, Date initiationDate) {

        PermissionUtils.checkPermission(Permission.GENERATE_THIRD_PARTY_TRANSFER);

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

        ThirdPartyPlanMember planMember = getThirdPartyPlanMember(thirdPartyPlanId, accountId);
        if (planMember == null) {
            String errMsg = "Account '" + accountId + "' is not eligible for this plan (ThirdPartyPlan ID = " + thirdPartyPlanId + ")";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

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
            transferDetail.setAccountId(accountId);
            transferDetail.setPlan(thirdPartyPlan);
            transferDetail.setChargeStatus(ThirdPartyChargeStatus.ACTIVE);
            transferDetail.setInitiationDate(initiationDate);
            transferDetail.setTransferAmount(BigDecimal.ZERO);

            remainingFund = maxAmount;
        }

        // Initializing the transaction effective date comparator
        TransactionUtils.EffectiveDateComparator dateComparator = new TransactionUtils.EffectiveDateComparator();

        // Getting allowable charges for the plan sorted by priority
        List<ThirdPartyAllowableCharge> allowableCharges = getThirdPartyAllowableCharges(thirdPartyPlanId);

        // Setting the total transfer amount variable to the existing transfer amount
        BigDecimal totalTransferAmount = transferDetail.getTransferAmount();

        // Getting transfer details with the same transaction type mask and Transfer Group ID
        Query query = em.createQuery("select sum(t.transferAmount - t.reversalAmount) from TransactionTransfer t " +
                " where t.transferAmount <> null and t.reversalAmount <> null and " +
                " t.groupId = :groupId and t.transactionTypeMask = :typeMask");

        for (ThirdPartyAllowableCharge allowableCharge : allowableCharges) {

            BigDecimal chargeRemainingFund = allowableCharge.getMaxAmount();

            if (chargeRemainingFund != null && planMember.isExecuted()) {

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

                    BigDecimal unallocatedAmount = transaction.getUnallocatedAmount();
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

            if ((chargeRemainingFund == null || financeChargeAmount.compareTo(chargeRemainingFund) <= 0) &&
                    (remainingFund == null || financeChargeAmount.compareTo(remainingFund) <= 0)) {

                // Doing non-divided funding

                for (Transaction transaction : transactions) {

                    Date effectiveDate = thirdPartyPlan.getEffectiveDate();
                    if (effectiveDate == null) {
                        effectiveDate = transaction.getEffectiveDate();
                    }

                    Date recognitionDate = thirdPartyPlan.getRecognitionDate();
                    if (recognitionDate == null) {
                        recognitionDate = transaction.getRecognitionDate();
                    }

                    // Calculating the transfer amount as unallocated amount multiplied by maxPercentage
                    BigDecimal transferAmount = transaction.getUnallocatedAmount().multiply(maxPercentage);

                    // Creating a new transaction transfer
                    TransactionTransfer transactionTransfer =
                            transactionTransferService.transferTransaction(
                                    transaction.getId(),
                                    transaction.getTransactionType().getId().getId(),
                                    thirdPartyPlan.getTransferType().getId(),
                                    thirdPartyPlan.getThirdPartyAccount().getId(),
                                    transferAmount,
                                    effectiveDate,
                                    recognitionDate,
                                    // TODO: set memo text and statement prefix,
                                    null,
                                    null,
                                    allowableCharge.getTransactionTypeMask());

                    // Setting Transfer Group ID
                    transactionTransfer.setGroupId(transferDetail.getTransferGroupId());

                    // Subtracting the transfer amount from the remaining fund
                    remainingFund = remainingFund.subtract(transferAmount);

                    totalTransferAmount = totalTransferAmount.add(transferAmount);
                }

            } else {

                // Doing divided funding

                // Taking the smallest funding amount from remainingFund and chargeRemainingFund
                BigDecimal maxDividedFund = remainingFund;
                if (maxDividedFund.compareTo(chargeRemainingFund) > 0) {
                    maxDividedFund = chargeRemainingFund;
                }

                BigDecimal divideCoefficient;

                // Calculating the transfer amount percentage based on the distribution plan
                switch (allowableCharge.getDistributionPlan()) {
                    case FULL:
                        divideCoefficient = maxPercentage;
                        break;
                    case DIVIDED:
                        divideCoefficient = maxDividedFund.divide(financeChargeAmount);
                        break;
                    default:
                        String errMsg = "Unsupported distribution plan '" + allowableCharge.getDistributionPlan() + "'";
                        logger.error(errMsg);
                        throw new IllegalStateException(errMsg);
                }

                for (Transaction transaction : transactions) {

                    if (maxDividedFund.compareTo(BigDecimal.ZERO) <= 0 ||
                            remainingFund.compareTo(BigDecimal.ZERO) <= 0) {
                        break;
                    }

                    // Calculating the transfer amount as unallocated amount multiplied by maxPercentage
                    BigDecimal transferAmount = transaction.getUnallocatedAmount().multiply(divideCoefficient);

                    // Getting the smallest value out of unallocated amount, maxDividedFund and remainingFund
                    if (transferAmount.compareTo(maxDividedFund) > 0) {
                        transferAmount = maxDividedFund;
                    }

                    if (transferAmount.compareTo(remainingFund) > 0) {
                        transferAmount = remainingFund;
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
                                    thirdPartyPlan.getThirdPartyAccount().getId(),
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
                    maxDividedFund = maxDividedFund.subtract(transferAmount);

                    // Subtracting the transfer amount from the remaining fund
                    remainingFund = remainingFund.subtract(transferAmount);

                    totalTransferAmount = totalTransferAmount.add(transferAmount);
                }


            }

        }

        // Summing up transfers
        transferDetail.setTransferAmount(totalTransferAmount);
        planMember.setExecuted(true);

        // Persisting the transfer detail
        persistEntity(transferDetail);

        return transferDetail;
    }

    /**
     * Generates third-party transfers for the given account ID and current date as an open period date
     * ignoring already executed transfers
     *
     * @param accountId DirectChargeAccount ID
     * @return list of ThirdPartyTransferDetail instances
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<ThirdPartyTransferDetail> generateThirdPartyTransfers(String accountId) {
        return generateThirdPartyTransfers(accountId, new Date(), true);
    }


    /**
     * Generates third-party transfers for the given account ID and open period date.
     *
     * @param accountId      DirectChargeAccount ID
     * @param openPeriodDate Date between the open period start and end dates.
     * @param ignoreExecuted if "true" the method ignores "isExecuted" value
     * @return list of ThirdPartyTransferDetail instances
     */
    @Override
    @Transactional(readOnly = false)
    public List<ThirdPartyTransferDetail> generateThirdPartyTransfers(String accountId, Date openPeriodDate, boolean ignoreExecuted) {

        PermissionUtils.checkPermission(Permission.GENERATE_THIRD_PARTY_TRANSFER);

        if (openPeriodDate == null) {
            String errMsg = "Open Period Date cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Account account = accountService.getFullAccount(accountId);
        if (account == null || !(account instanceof DirectChargeAccount)) {
            String errMsg = "DirectChargeAccount with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        // Retrieving the third-party plan IDs for the given Account ID and open period date
        StringBuilder queryBuilder = new StringBuilder("select p.id from ThirdPartyPlan p, ThirdPartyPlanMember m " +
                " where p.id = m.plan.id and " +
                " m.directChargeAccount.id = :accountId and " +
                " :date >= to_date(p.openPeriodStartDate) and :date <= to_date(p.openPeriodEndDate)");

        if (!ignoreExecuted) {
            queryBuilder.append(" and m.executed = false ");
        }

        queryBuilder.append(" order by m.priority desc");

        Query query = em.createQuery(queryBuilder.toString());

        query.setParameter("accountId", accountId);
        query.setParameter("date", CalendarUtils.removeTime(openPeriodDate), TemporalType.DATE);

        List<Long> planIds = query.getResultList();

        if (CollectionUtils.isNotEmpty(planIds)) {

            List<ThirdPartyTransferDetail> transferDetails = new ArrayList<ThirdPartyTransferDetail>(planIds.size());

            // Generating transfers for Plan ID, Account ID and Open Period Date
            for (Long planId : planIds) {
                transferDetails.add(generateThirdPartyTransfer(planId, accountId, openPeriodDate));
            }

            return transferDetails;
        }

        return Collections.emptyList();
    }

    /**
     * Generates third-party transfers for each eligible account with the given plan ID
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param ignoreExecuted   if "true" the method ignores "isExecuted" value
     * @return list of ThirdPartyTransferDetail instances
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<ThirdPartyTransferDetail> generateThirdPartyTransfers(Long thirdPartyPlanId, boolean ignoreExecuted) {

        PermissionUtils.checkPermission(Permission.GENERATE_THIRD_PARTY_TRANSFER);

        ThirdPartyPlan thirdPartyPlan = getThirdPartyPlan(thirdPartyPlanId);
        if (thirdPartyPlan == null) {
            String errMsg = "ThirdPartyPlan does not exist with ID = " + thirdPartyPlanId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        // Retrieving the third-party plan IDs for the given Account ID and open period date
        StringBuilder queryBuilder = new StringBuilder("select m.directChargeAccount.id " +
                " from ThirdPartyPlan p, ThirdPartyPlanMember m " +
                " where p.id = m.plan.id and p.id = :planId");

        if (!ignoreExecuted) {
            queryBuilder.append(" and m.executed = false ");
        }

        Query query = em.createQuery(queryBuilder.toString());

        query.setParameter("planId", thirdPartyPlanId);

        List<String> ids = query.getResultList();

        if (CollectionUtils.isNotEmpty(ids)) {

            Set<String> accountIds = new HashSet<String>(ids);

            List<ThirdPartyTransferDetail> transferDetails = new ArrayList<ThirdPartyTransferDetail>(ids.size());

            Date currentDate = new Date();

            // Generating transfers for Plan ID, Account ID and current date
            for (String accountId : accountIds) {
                transferDetails.add(generateThirdPartyTransfer(thirdPartyPlanId, accountId, currentDate));
            }

            return transferDetails;
        }

        return Collections.emptyList();
    }

    /**
     * Reverses a third-party transaction transfer specified by ThirdPartyTransferDetail ID.
     *
     * @param transferDetailId ThirdPartyTransferDetail ID
     * @param memoText         Memo text
     * @return ThirdPartyTransferDetail instance
     */
    @Override
    @Transactional(readOnly = false)
    public ThirdPartyTransferDetail reverseThirdPartyTransfer(Long transferDetailId, String memoText) {

        PermissionUtils.checkPermission(Permission.REVERSE_THIRD_PARTY_TRANSFER);

        ThirdPartyTransferDetail transferDetail = getThirdPartyTransferDetail(transferDetailId);
        if (transferDetail == null) {
            String errMsg = "ThirdPartyTransferDetail does not exist with ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (transferDetail.getChargeStatus() != ThirdPartyChargeStatus.ACTIVE) {
            String errMsg = "ThirdPartyTransferDetail must be active, ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        ThirdPartyPlan plan = transferDetail.getPlan();
        if (plan == null) {
            String errMsg = "ThirdPartyTransferDetail does not have any plan associated with it, ID = " + transferDetailId;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        // Getting the plan member to set "isExecuted" to false
        ThirdPartyPlanMember planMember = getThirdPartyPlanMember(plan.getId(), transferDetail.getAccountId());
        if (planMember == null) {
            String errMsg = "Account '" + transferDetail.getAccountId() +
                    "' is not eligible for this plan (ThirdPartyPlan ID = " + plan.getId() + ")";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        // Reversing the entire transaction transfer group allowing locked allocations
        transactionTransferService.reverseTransferGroup(transferDetail.getTransferGroupId(), memoText, true);

        // Setting the Transfer Detail status to REVERSED
        transferDetail.setChargeStatus(ThirdPartyChargeStatus.REVERSED);

        planMember.setExecuted(false);

        return transferDetail;
    }


}