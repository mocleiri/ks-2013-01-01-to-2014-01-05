package com.sigmasys.kuali.ksa.service.tp.impl;

import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.tp.*;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.TransactionTransferService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.service.tp.ThirdPartyTransferService;
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
import java.util.Date;
import java.util.List;


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

        BigDecimal remainingFund = BigDecimal.ZERO;

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

            remainingFund = maxAmount;
        }

        // Getting allowable charges for the plan sorted by priority
        List<ThirdPartyAllowableCharge> allowableCharges = getThirdPartyAllowableCharges(thirdPartyPlanId);

        // TODO


        return null;
    }


}