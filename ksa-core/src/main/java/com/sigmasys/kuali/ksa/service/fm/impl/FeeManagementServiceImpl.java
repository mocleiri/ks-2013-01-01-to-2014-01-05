package com.sigmasys.kuali.ksa.service.fm.impl;

import java.math.BigDecimal;
import java.util.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.fm.FeeManagementService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;

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

        // Validate the full-reversal manifests of the current FM session:
        validateFullReversals(fmSession);

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
        return getManifests(feeManagementSessionId, (FeeManagementManifestType[]) null);
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

        boolean typesExist = (manifestTypes != null && manifestTypes.length > 0);

        List<String> typeCodes = null;

        if (typesExist) {
            typeCodes = new ArrayList<String>(manifestTypes.length);
            for (FeeManagementManifestType manifestType : manifestTypes) {
                typeCodes.add(manifestType.getId());
            }
        }

        // Create a query to select all FM Manifests linked to the given FM Session:
        Query query = em.createQuery(GET_MANIFESTS_JOIN + " where m.session.id = :fmSessionId" +
                (typesExist ? " and m.typeCode in (:typeCodes)" : ""));

        query.setParameter("fmSessionId", feeManagementSessionId);

        if (typesExist) {
            query.setParameter("typeCodes", typeCodes);
        }

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
     * @param currentFmSession	Current FM Session.
     * @param priorFmSession 	Last FM Session in the CHARGED status. Guaranteed not to be null.
     */
    private void processPriorSessionAdjustment(FeeManagementSession currentFmSession, FeeManagementSession priorFmSession) {
        // Get the prior and current FM sessions' manifests:
        List<FeeManagementManifest> priorManifests = getManifests(priorFmSession.getId(),
                FeeManagementManifestType.CHARGE, FeeManagementManifestType.CANCELLATION, FeeManagementManifestType.DISCOUNT);
        List<FeeManagementManifest> currentManifests = getManifests(currentFmSession.getId(),
        		FeeManagementManifestType.CHARGE, FeeManagementManifestType.CANCELLATION, FeeManagementManifestType.DISCOUNT);
     
        // Get pairs of matching FM manifests in the prior and the current FM sessions:
        List<FeeManagementManifest> unmatchedPriorManifests = new ArrayList<FeeManagementManifest>();
        List<Pair<FeeManagementManifest, FeeManagementManifest>> matchingManifests = getMatchingManifests(priorManifests, currentManifests, unmatchedPriorManifests);
        
        // Process matching manifest pairs:
        for (Pair<FeeManagementManifest, FeeManagementManifest> matchingPair : matchingManifests) {
        	processMatchingManifests(matchingPair, currentFmSession);
        }
        
        // Process unmatched prior manifests:
        processUnmatchedPriorManifest(unmatchedPriorManifests, currentFmSession);
    }
    
    /**
     * Returns a <code>List</code> of matching <code>FeeManagementManifest</code>s that match in both prior and current manifest lists.
     * Matching manifests is done by either:
     * 1. registrationId + offeringId + rate, or
     * 2. internalChargeId + rate.
     * 
     * @param priorManifests			Prior FM session's manifests.
     * @param currentManifests			Current FM session's manifests.
     * @param unmatchedPriorManifests	A List to be populated with unmatched prior FM session's manifests. This is an IN parameter and must not be null.
     * @return	A List of matching manifest pairs. The "a" property of the <code>Pair</code> is the prior manifest, and "b" is the current one.
     */
    private List<Pair<FeeManagementManifest, FeeManagementManifest>> getMatchingManifests (List<FeeManagementManifest> priorManifests, 
    								List<FeeManagementManifest> currentManifests, List<FeeManagementManifest> unmatchedPriorManifests) {
    	// Create the resulting list:
    	List<Pair<FeeManagementManifest, FeeManagementManifest>> matchingManifests = new ArrayList<Pair<FeeManagementManifest,FeeManagementManifest>>();
    	
    	// Create a copy of the prior manifest List since we'll be removing matched prior manifests:
    	List<FeeManagementManifest> priorManifestsCopy = new ArrayList<FeeManagementManifest>(priorManifests);
    	
    	// Iterate through the prior manifests trying find a match in the current manifest list:
    	for (Iterator<FeeManagementManifest> itPrior = priorManifestsCopy.iterator(); itPrior.hasNext();) {
    		FeeManagementManifest priorManifest = itPrior.next();
    		
    		// Iterate through the list of current manifests trying to find a match:
    		for (FeeManagementManifest currentManifest : currentManifests) {
    			if (manifestsMatch(priorManifest, currentManifest)) {
    				// Add a new matching pair, remove the matching prior manifest from the underlying list and break out of the loop:
    				matchingManifests.add(new Pair<FeeManagementManifest, FeeManagementManifest>(priorManifest, currentManifest));
    				itPrior.remove();
    				
    				break;
    			}
    		}
    	}
    	
    	// Add non-matching prior FM session's manifests to the list of unmatched manifests:
    	unmatchedPriorManifests.addAll(priorManifestsCopy);
    	
    	return matchingManifests;
    }
    
    /**
     * Compares two FM manifests, prior and current, and check if they match by either:
     * 1. registrationId + offeringId + rate, or
     * 2. internalChargeId + rate.
     * 
     * @param prior		A prior FM session's manifest.
     * @param current	A current FM session's manifest.
     * @return	<code>true</code> if the manifests are a match, <code>false</code> otherwise.
     */
    private boolean manifestsMatch(FeeManagementManifest prior, FeeManagementManifest current) {
    	if ((prior != null) && (current != null)) {
    		boolean rateMatches = (prior.getRate() != null) && (current.getRate() != null) && prior.getRate().equals(current.getRate());
    		
    		return rateMatches
    				&& ((StringUtils.equals(prior.getRegistrationId(), current.getRegistrationId()) && StringUtils.equals(prior.getOfferingId(), current.getOfferingId())) 
    						|| StringUtils.equals(prior.getInternalChargeId(), current.getInternalChargeId()));
    	}
    	
    	return false;
    }
    
    /**
     * Processes matching manifests from the prior and current FM sessions by doing one of the following:<br> 
     * 1. Either copies the transactionId from the prior manifest to the current one if already charged, or<br>
     * 2. Performs corrections.
     * 
     * @param manifests 		A <code>Pair</code> of matching manifests, the first one in the pair is the prior session's manifest.
     * @param currentFmSession	The current FM session. Used for non-charged matching manifests adjustment.
     */
	private void processMatchingManifests(Pair<FeeManagementManifest, FeeManagementManifest> manifests, FeeManagementSession currentFmSession) {
		// First, check if the payment information on the prior and current manifests match, i.e. current has already been charged:
		FeeManagementManifest prior = manifests.getA();
		FeeManagementManifest current = manifests.getB();
    	boolean currentAlreadyCharged = manifestPaymentInformationMatch(prior, current);
    	
    	if (currentAlreadyCharged) {
    		// Copy the transactionId from the prior to the current:
    		// TODO: Figure out what "transactionId" in an FM manifest is
    	} else {
    		// Create a correction on the current session from the prior manifest:
    		createPriorManifestCorrection(prior, currentFmSession);
    	}
    }
	
	/**
	 * Checks if the prior and current FM manifests' payment information matches. That includes:<p>
	 * 1. effectiveDate<br>
	 * 2. recognitionDate<br>
	 * 3. transactionTypeId<br>
	 * 4. amount
	 * 
	 * @param prior		A prior FM session manifest.
	 * @param current	A current FM session manifest.
	 * @return <code>true</code> if the payment information on both manifests matches.
	 */
	private boolean manifestPaymentInformationMatch(FeeManagementManifest prior, FeeManagementManifest current) {
		return (prior.getEffectiveDate() != null) && (current.getEffectiveDate() != null) && prior.getEffectiveDate().equals(current.getEffectiveDate())
			&& (prior.getRecognitionDate() != null) && (current.getRecognitionDate() != null) && prior.getRecognitionDate().equals(current.getRecognitionDate())
			&& StringUtils.equals(prior.getTransactionTypeId(), current.getTransactionTypeId())
			&& getManifestAmount(prior).equals(getManifestAmount(current));
	}
	
	/**
	 * Calculates the total manifest amount. Guaranteed not to return null.
	 * 
	 * @param manifest An FM manifest to calculate its total amount.
	 * @return	The total FM manifest amount.
	 */
	private final BigDecimal getManifestAmount(FeeManagementManifest manifest) {
		// TODO: Figure out how to calculate an FM manifest's amount and move this method to RateService:
		Rate rate = manifest.getRate();
		BigDecimal manifestAmount = new BigDecimal(0);
		
		if (rate != null) {
			// Get all RateAmounts:
			Set<RateAmount> rateAmounts = rate.getRateAmounts();
			
			if (rateAmounts != null) {
				for (RateAmount rateAmount : rateAmounts) {
					// Add amount to the total amount:
					if (rateAmount.getAmount() != null) {
						manifestAmount = manifestAmount.add(rateAmount.getAmount());
					}
				}
			}
		}
		
		// If the total Manifest amount is still 0, then use the default amount if it exists:
		if (manifestAmount.doubleValue() == 0d) {
			RateAmount defaultAmount = rate.getDefaultRateAmount();
			
			if (defaultAmount.getAmount() != null) {
				manifestAmount = defaultAmount.getAmount();
			}
		}
		
		return manifestAmount;
	}
	
	/**
	 * Processes all prior FM session's unmatched manifests (those that do not have matching manifests on the current FM session).
	 * 
	 * @param unmatchedPriorManifests	Unmatched prior FM manifests.	
	 * @param currentFmSession			Current FM session.
	 */
	private void processUnmatchedPriorManifest(List<FeeManagementManifest> unmatchedPriorManifests, FeeManagementSession currentFmSession) {
		// TODO: Remove all full-reversal manifest pairs:

		// Iterate through the remaining non-full-reversal prior manifests and create a correction on the current FM session out of each one of them:
		for (FeeManagementManifest priorManifest : unmatchedPriorManifests) {
			// Create a correction on the current session from the prior manifest:
			createPriorManifestCorrection(priorManifest, currentFmSession);
		}
	}
	
	/**
	 * Checks if the two <code>FeeManagementManifest</code>s are a subject to full reversal, which means that:<p>
	 * 
	 * 1. The types of the two are CHARGE and CANCEL<br>
	 * 2. Manifests match (see {@link #manifestsMatch(FeeManagementManifest, FeeManagementManifest)}<br>
	 * 3. Same transactionTypeId and amount.<br>
	 * 4. Their manifests point at each other.<br>
	 * 
	 * @param fmm1	The first FM manifest to check for full reversal.
	 * @param fmm2	The second FM manifest to check for full reversal.
	 * @return <code>true</code> if the two FM manifests are full reversal.
	 */
	private boolean isFullReversal(FeeManagementManifest fmm1, FeeManagementManifest fmm2) {
		// First check if the FM manifests point at each other:
		boolean pointAtEachOther = (fmm1.getLinkedManifest() != null) && (fmm2.getLinkedManifest() != null) 
				&& fmm1.getLinkedManifest().getId().equals(fmm2.getId()) && fmm2.getLinkedManifest().getId().equals(fmm1.getId());
		
		// Check if the types are CHARGE and CANCEL
		if (pointAtEachOther) {
			boolean statusesForReversal = ((fmm1.getType() == FeeManagementManifestType.CHARGE) && (fmm2.getType() == FeeManagementManifestType.CANCELLATION))
					|| ((fmm2.getType() == FeeManagementManifestType.CHARGE) && (fmm1.getType() == FeeManagementManifestType.CANCELLATION));
			
			// Now check if the manifests match and have the same transactionTypeId and amount:
			if (statusesForReversal) {
				return manifestsMatch(fmm1, fmm2) 
						&& StringUtils.equals(fmm1.getTransactionTypeId(), fmm2.getTransactionTypeId())
						&& getManifestAmount(fmm1).equals(getManifestAmount(fmm2));
			}
		}
		
		return false;
	}
	
	/**
	 * Creates a correction from a prior FM session's manifest into the current FM session. 
	 *  
	 * @param priorManifest		A prior FM manifest to create a correction out of.
	 * @param currentFmSession	Current FM session.
	 */
	private void createPriorManifestCorrection(FeeManagementManifest priorManifest, FeeManagementSession currentFmSession) {
		// Bring the prior manifest to the current session. Change its type to CORRECTED:
		priorManifest.setSession(currentFmSession);
		priorManifest.setType(FeeManagementManifestType.CORRECTION);
		
		// Duplicate the prior manifest and add to the current FM session:
		// TODO: Figure out why there is no CORRECTED type and what to do with Manifest duplication:
		
		// Persist the prior and new manifests:
		persistEntity(priorManifest);
	}
	
	/**
	 * Validates that full-reversal manifests point at each other. Repoints them at each other if necessary.
	 * 
	 * @param fmSession An FM Session to validate its full reversals.
	 */
	private void validateFullReversals(FeeManagementSession fmSession) {
		// TODO: Either get Manifests for the FM session or use the already loaded ones:
	}
}
