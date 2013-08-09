package com.sigmasys.kuali.ksa.service.fm.impl;

import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.fm.FeeManagementService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

/**
 * FeeManagementService implementation.
 * <p/>
 * <p/>
 * This class provides a concrete implementation of the <code>FeeManagementService</code> interface
 * according to the specification in the "Process Diagrams" document
 *
 * @author Sergey Godunov
 */
@Service("feeManagementService")
@Transactional(readOnly = true)
@WebService(serviceName = FeeManagementService.SERVICE_NAME, portName = FeeManagementService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
@SuppressWarnings("unchecked")
public class FeeManagementServiceImpl extends GenericPersistenceService implements FeeManagementService {

    /**
     * This class's logger.
     */
    private static final Log logger = LogFactory.getLog(FeeManagementServiceImpl.class);

    // A query to get Manifests without regard to statuses. Status filtering can be added later:
    private static final String GET_MANIFESTS_JOIN = "select m from FeeManagementManifest m " +
            " left outer join fetch m.keyPairs kp " +
            " left outer join fetch m.tags t " +
            " left outer join fetch m.rate r " +
            " left outer join fetch m.rollup ru " +
            " left outer join fetch m.linkedManifest lm ";

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AuditableEntityService auditableEntityService;


    /**
     * Reconciles a FeeManagement session.
     * Session reconciliation takes former sessions and ensures that charges that need to be removed are
     * accurately recorded in the new session.
     *
     * @param feeManagementSessionId FeeManagementSession ID
     */
    @Override
    @Transactional(readOnly = false)
    public void reconcileSession(Long feeManagementSessionId) {

        // Get a FeeManagement session with the given ID:
        FeeManagementSession fmSession = getEntity(feeManagementSessionId, FeeManagementSession.class);

        if (fmSession == null) {
            logger.error("Cannot find an FM session with the ID " + feeManagementSessionId);
            throw new IllegalArgumentException("Cannot find an FM session with the ID " + feeManagementSessionId);
        }

        // Check the session passed is CURRENT or SIMULATED
        FeeManagementSessionStatus sessionStatus = fmSession.getStatus();

        if (sessionStatus == null || ((sessionStatus != FeeManagementSessionStatus.CURRENT) && (sessionStatus != FeeManagementSessionStatus.SIMULATED))) {
            String errorMsg = String.format("Invalid FeeManagement Session status [%s]. Session status must be CURRENT or SIMULATED.", sessionStatus);
            logger.error(errorMsg);
            throw new IllegalStateException(errorMsg);
        }

        // Get the associated Account:
        Account account = fmSession.getAccount();

        if (account == null) {
            String errorMsg = String.format("Fee Management Session with id [%s] does not have an associated Account.", feeManagementSessionId);
            logger.error(errorMsg);
            throw new IllegalStateException(errorMsg);
        } else {
            // Check if the Account associated with the FM Session is blocked:
            boolean accountBlocked = isAccountBlocked(account);

            if (accountBlocked) {
                String errorMsg = String.format("The account %s associated with the FM session with id [%s] is blocked.", account.getId(), feeManagementSessionId);
                logger.error(errorMsg);
                throw new IllegalStateException(errorMsg);
            }
        }

        // Get the last CHARGED FM Session:
        FeeManagementSession lastChargedFmSession = getLastChargedSession(fmSession);

        // If there is a prior CHARGED FM Session, perform line adjustment:
        if (lastChargedFmSession != null) {
            // Perform line comparison and status adjustment.
            processPriorSessionAdjustment(fmSession, lastChargedFmSession);
        }

        // TODO: Search the current manifests where offering + rate or internalId + rate match, and the types are one CHARGE and one CANCEL
        // Point the manifestId of these matching transactions together

        // Updated the status of the current FM Session to RECONCILED or SIMULATED_RECONCILED:
        FeeManagementSessionStatus newFmStatus = (sessionStatus == FeeManagementSessionStatus.CURRENT)
                ? FeeManagementSessionStatus.RECONCILED : FeeManagementSessionStatus.SIMULATED_RECONCILED;

        // Update the entity:
        fmSession.setChargeStatus(newFmStatus);
        persistEntity(fmSession);
    }

    /**
     * Creates charges on the current Fee Management session.
     * Creates reversals and cancellations and also rate transactions.
     *
     * @param feeManagementSessionId FeeManagementSession ID
     */
    @Override
    @Transactional(readOnly = false)
    public void chargeSession(Long feeManagementSessionId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Returns all FM Manifests associated with an FM Session with the given ID.
     *
     * @param feeManagementSessionId An FM Session ID.
     * @return All associated FM Manifests.
     */
    @Override
    public List<FeeManagementManifest> getManifests(Long feeManagementSessionId) {
        // Check permissions to perform this operation:
        PermissionUtils.checkPermission(Permission.READ_RATE);

        // Create a query to select all FM Manifests linked to the given FM Session:
        Query query = em.createQuery(GET_MANIFESTS_JOIN + " where m.session.id = :fmSessionId ");
        query.setParameter("fmSessionId", feeManagementSessionId);

        return query.getResultList();
    }

    /**
     * Returns all FM Manifests of given types associated with an FM Session with the given ID.
     *
     * @param feeManagementSessionId An FM Session ID.
     * @param manifestTypes          Types of FM Manifests to retrieve.
     * @return All associated FM Manifests of given types.
     */
    @Override
    @WebMethod(exclude = true)
    public List<FeeManagementManifest> getManifests(Long feeManagementSessionId, FeeManagementManifestType... manifestTypes) {

        // Check permissions to perform this operation:
        PermissionUtils.checkPermission(Permission.READ_RATE);

        // Create a query to select all FM Manifests linked to the given FM Session:
        Query query = em.createQuery(GET_MANIFESTS_JOIN + " where m.session.id = :fmSessionId and m.type in (:manifestTypes) ");
        query.setParameter("fmSessionId", feeManagementSessionId);
        query.setParameter("manifestTypes", Arrays.asList(manifestTypes));

        return query.getResultList();
    }


    /***************************************************************************
     *
     * Private helper methods.
     *
     ***************************************************************************/

    /**
     * A recursive method that checks all previous FM Sessions in succession in
     * order to find the last CHARGED session.
     *
     * @param fmSession A FeeManagement Session to find its last CHARGED prior FM Session.
     * @return The last prior CHARGED FM session or <code>null</code> if there is no last prior
     *         CHARGED FM Session.
     */
    private FeeManagementSession getLastChargedSession(FeeManagementSession fmSession) {
        // Check if the current session is null or its status is CHARGED, end the recursion here:
        if ((fmSession == null) || (fmSession.getStatus() == FeeManagementSessionStatus.CHARGED)) {
            return fmSession;
        } else {
            // Get the prior session and continue the recursion:
            return getLastChargedSession(fmSession.getPrevSession());
        }
    }

    /**
     * Checks if the Account associated with the given FM Session is blocked.
     *
     * @param account Account associated with a Fee Management Session.
     * @return boolean Whether the Account associated with the FM Session is blocked.
     */
    private boolean isAccountBlocked(Account account) {
        // TODO: Perform a check for a blocked account. This method will be defined and implemented later (per Paul):
        boolean accountBlocked = false;

        return accountBlocked;
    }

    /**
     * Performs adjustment of lines between the last charged FM Session and the current session.
     *
     * @param currentFmSession     Current FM Session.
     * @param lastChargedFmSession Last FM Session in the CHARGED status. Guaranteed not to be null.
     */
    private void processPriorSessionAdjustment(FeeManagementSession currentFmSession, FeeManagementSession lastChargedFmSession) {
        // Get the prior FM session's eligible lines:
        List<FeeManagementManifest> eligibleManifests = getManifests(lastChargedFmSession.getId(),
                FeeManagementManifestType.CHARGE, FeeManagementManifestType.CANCELLATION, FeeManagementManifestType.DISCOUNT);

    }
}
