package com.sigmasys.kuali.ksa.service;

import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Transaction;
import com.sigmasys.kuali.ksa.model.TransactionStatus;
import com.sigmasys.kuali.ksa.model.TransactionType;
import com.sigmasys.kuali.ksa.model.fm.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sigmasys.kuali.ksa.service.fm.FeeManagementService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * FeeManagementService unit tests.
 * 
 * @author Sergey Godunov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class FeeManagementServiceTest extends AbstractServiceTest {

    private static final String ACCOUNT_ID = "admin1";
    private static final String TRANSACTION_TYPE_ID = "cash";

	@Autowired
	private FeeManagementService fmService;
	
	@Autowired
	private PersistenceService persistenceService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;




    /*****************************************************************
     *
     * Unit tests for "chargeSession"
     *
     ****************************************************************/

	
	@Test
	public void testChargeSessionNoSessionIdFound() throws Exception {
		// Call the method with a fake FM Session ID:
		boolean exceptionCaught = false;

		try {
			fmService.chargeSession(0L);
		} catch (IllegalArgumentException e) {
			assertEquals("Cannot find an FM session with the ID 0", e.getMessage());
            exceptionCaught = true;
		} catch (Throwable t) {
			// We should never catch any other type of a Throwable:
			assertTrue("Must never catch anything by IllegalArgumentException", false);
		}
		
		// Assert Exception was caught
		assertTrue("Never caught an IllegalArgumentException", exceptionCaught);
	}
	
	@Test
	public void testChargeSessionNullStatus() throws Exception {
		// Create an FM session:
		FeeManagementSession fmSession = new FeeManagementSession();
		
		persistenceService.persistEntity(fmSession);
		
		// Call the method:
		boolean exceptionCaught = false;
		
		try {
			fmService.chargeSession(fmSession.getId());
		} catch (IllegalStateException ise) {
			// We should catch this exception here
			exceptionCaught = true;
		} catch (Throwable e) {
			// We should never catch any other type of a Throwable:
			assertTrue("Must never catch anything by IllegalStateException", false);
		}
		
		// Assert Exception was caught
		assertTrue("Never caught an IllegalStateException", exceptionCaught);
	}

    @Test
    public void testChargeSessionWrongStatus() throws Exception {
        // Create an FM session:
        FeeManagementSession fmSession = new FeeManagementSession();

        fmSession.setChargeStatus(FeeManagementSessionStatus.CURRENT);
        persistenceService.persistEntity(fmSession);

        // Call the method:
        boolean exceptionCaught = false;

        try {
            fmService.chargeSession(fmSession.getId());
        } catch (IllegalStateException ise) {
            // We should catch this exception here
            exceptionCaught = true;
        } catch (Throwable e) {
            // We should never catch any other type of a Throwable:
            assertTrue("Must never catch anything by IllegalStateException", false);
        }

        // Assert Exception was caught
        assertTrue("Never caught an IllegalStateException", exceptionCaught);
    }

    @Test
    public void testChargeSessionNoManifestsFound() throws Exception {
        // Create an FM session:
        FeeManagementSession fmSession = new FeeManagementSession();

        fmSession.setChargeStatus(FeeManagementSessionStatus.RECONCILED);
        persistenceService.persistEntity(fmSession);

        // Call the method:
        fmService.chargeSession(fmSession.getId());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getStatus());
    }

    @Test
    public void testChargeSessionManifestHasTransaction() throws Exception {
        // Create an FM session and manifest:
        FmSession fmSession = createFmSession(1, true, false, FeeManagementManifestType.ORIGINAL);

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionManifestHasNoTransactionTypeId() throws Exception {
        // Create an FM Session:
        FmSession fmSession = createFmSession(1, false, false, FeeManagementManifestType.CHARGE);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);

        // Nullify the Transaction type ID:
        manifest.setTransactionTypeId(null);
        persistenceService.persistEntity(manifest);

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Verify a Charge was not created:
        assertNull("A CHARGE Transaction was created, but not expected.", manifest.getTransaction());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionChargeManifestNoLinkedManifest() throws Exception {
        // Create an FM Session:
        FmSession fmSession = createFmSession(1, false, false, FeeManagementManifestType.CHARGE);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);
        Transaction primaryTransaction = manifest.getTransaction();

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Validate that a new Transaction was created:
        Transaction chargeTransaction = manifest.getTransaction();

        assertNull(primaryTransaction);
        assertNotNull("No CHARGE Transaction was created.", chargeTransaction);
        assertNotNull("CHARGE Transaction's ID must not be null", chargeTransaction.getId());
        assertNotNull("New Transaction's amount must not be empty.", chargeTransaction.getAmount());
        assertTrue("CHARGE Transaction was created in a different amount than the manifest.", manifest.getAmount().compareTo(chargeTransaction.getAmount()) == 0);

        // Validate there is no linked manifest:
        assertNull("Linked manifest must not exist", manifest.getLinkedManifest());

        // Validate manifest is marked session current:
        assertTrue("FM Session must be current.", manifest.isSessionCurrent());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionCorrectionManifestHasNoLinkedManifest() throws Exception {
        // Create an FM Session:
        FmSession fmSession = createFmSession(1, false, false, FeeManagementManifestType.CORRECTION);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);
        Transaction primaryTransaction = manifest.getTransaction();

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Validate that a new Transaction was created:
        Transaction chargeTransaction = manifest.getTransaction();

        assertNull(primaryTransaction);
        assertNotNull("No CHARGE Transaction was created.", chargeTransaction);
        assertNotNull("CHARGE Transaction's ID must not be null", chargeTransaction.getId());
        assertNotNull("New Transaction's amount must not be empty.", chargeTransaction.getAmount());
        assertTrue("CHARGE Transaction was not a reversal to the manifest.", manifest.getAmount().compareTo(chargeTransaction.getAmount().negate()) == 0);

        // Validate there is no linked manifest:
        assertNull("Linked manifest must not exist", manifest.getLinkedManifest());

        // Validate manifest is marked session current:
        assertTrue("FM Session must be current.", manifest.isSessionCurrent());

        // Validate the Session is marked for review:
        assertTrue("FM Session must be marked for manual review", fmSession.getSession().isReviewRequired());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionCorrectionManifestLinkedManifestHasNoTransaction() throws Exception {
        // Create an FM session with linked manifests:
        FmSession fmSession = createFmSession(1, FeeManagementManifestType.CORRECTION);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);

        // Nullify the implicated Transaction:
        FeeManagementManifest linkedManifest = manifest.getLinkedManifest();

        linkedManifest.setTransaction(null);
        persistenceService.persistEntity(linkedManifest);

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Verify that the linked manifest still has no Transaction:
        assertNull("Linked manifest must not have a transaction", linkedManifest.getTransaction());

        // Verify the Session is not marked for review and manifest is not marked session current:
        assertFalse("FM Session must not marked for review", fmSession.getSession().isReviewRequired());
        assertFalse("Manifests must not be marked session current", manifest.isSessionCurrent());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionLinkedManifestHasNonReversalTransactionNoAllocationsRemain() throws Exception {
        // Create an FM session with linked manifests:
        FmSession fmSession = createFmSession(1, FeeManagementManifestType.CANCELLATION);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);
        FeeManagementManifest linkedManifest = manifest.getLinkedManifest();
        Transaction implicatedTransaction = linkedManifest.getTransaction();

        implicatedTransaction.setStatus(TransactionStatus.BOUNCING);

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Verify all allocations were removed:
        boolean allocationsRemain = (implicatedTransaction.getAllocatedAmount() != null) && (implicatedTransaction.getLockedAllocatedAmount() != null)
                && (implicatedTransaction.getAllocatedAmount().compareTo(implicatedTransaction.getLockedAllocatedAmount().negate()) != 0);

        assertFalse("There are uncleared allocations remain", allocationsRemain);

        // Verify the main manifest still has no Transaction:
        assertNull("Primary transaction must not exist", manifest.getTransaction());

        // Verify the session is not marked for manual review:
        assertFalse("FM Session must not marked for review", fmSession.getSession().isReviewRequired());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionLinkedManifestHasReversalTransactionNoAllocationsRemain() throws Exception {
        // Create an FM session with linked manifests:
        FmSession fmSession = createFmSession(1, FeeManagementManifestType.DISCOUNT);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);
        FeeManagementManifest linkedManifest = manifest.getLinkedManifest();
        Transaction implicatedTransaction = linkedManifest.getTransaction();

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Verify the original manifest was updated with a reversal Transaction:
        Transaction primaryTransaction = manifest.getTransaction();

        assertNotNull("Primary transaction must exist", primaryTransaction);
        assertNotNull("Primary transaction ID must exist", primaryTransaction.getId());
        assertEquals("Reversal transaction amount must be reverse from the manifest", manifest.getAmount(), primaryTransaction.getAmount().negate());

        // Verify the session is not marked for manual review:
        assertFalse("FM Session must not be marked for manual review", fmSession.getSession().isReviewRequired());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionLinkedManifestHasNonReversalTransactionAllocationsRemain() throws Exception {
        // Create an FM session with linked manifests and simulate allocation remain:
        FmSession fmSession = createFmSession(1, FeeManagementManifestType.CORRECTION);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);
        FeeManagementManifest linkedManifest = manifest.getLinkedManifest();
        Transaction implicatedTransaction = linkedManifest.getTransaction();

        implicatedTransaction.setStatus(TransactionStatus.WRITING_OFF);
        implicatedTransaction.setAllocatedAmount(new BigDecimal(2));
        implicatedTransaction.setLockedAllocatedAmount(new BigDecimal(3));

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Verify the main manifest still has no Transaction:
        assertNull("Primary transaction must not exist", manifest.getTransaction());

        // Verify the session is marked for manual review:
        assertTrue("FM Session must be marked for manual review", fmSession.getSession().isReviewRequired());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionLinkedManifestHasReversalTransactionAllocationsRemainNotEnoughBalanceForReversal() throws Exception {
        // Create an FM session with linked manifests and simulate allocation remain:
        FmSession fmSession = createFmSession(1, FeeManagementManifestType.CANCELLATION);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);
        FeeManagementManifest linkedManifest = manifest.getLinkedManifest();
        Transaction implicatedTransaction = linkedManifest.getTransaction();

        implicatedTransaction.setStatus(TransactionStatus.REVERSING);
        implicatedTransaction.setAllocatedAmount(new BigDecimal(2));
        implicatedTransaction.setLockedAllocatedAmount(new BigDecimal(3));

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Verify the main manifest still has no Transaction:
        assertNull("Primary transaction must not exist", manifest.getTransaction());

        // Verify the session is marked for manual review:
        assertTrue("FM Session must be marked for manual review", fmSession.getSession().isReviewRequired());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionLinkedManifestHasReversalStatusTransactionAllocationsRemainEnoughBalanceForReversal() throws Exception {
        // Create an FM session with linked manifests and simulate allocation remain:
        FmSession fmSession = createFmSession(1, FeeManagementManifestType.DISCOUNT);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);
        FeeManagementManifest linkedManifest = manifest.getLinkedManifest();
        Transaction implicatedTransaction = linkedManifest.getTransaction();

        implicatedTransaction.setStatus(TransactionStatus.ACTIVE);
        implicatedTransaction.setAllocatedAmount(new BigDecimal(-2));
        implicatedTransaction.setLockedAllocatedAmount(new BigDecimal(-3));

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Verify the original manifest was updated with a reversal Transaction:
        Transaction primaryTransaction = manifest.getTransaction();

        assertNotNull("Primary transaction must exist", primaryTransaction);
        assertNotNull("Primary transaction ID must exist", primaryTransaction.getId());
        assertEquals("Reversal transaction amount must be reverse from the manifest", manifest.getAmount(), primaryTransaction.getAmount().negate());

        // Verify the session is marked for manual review:
        assertTrue("FM Session must be marked for manual review", fmSession.getSession().isReviewRequired());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    public void testChargeSessionLinkedManifestHasNonReversalStatusTransactionAllocationsRemainEnoughBalanceForReversal() throws Exception {
        // Create an FM session with linked manifests and simulate allocation remain:
        FmSession fmSession = createFmSession(1, FeeManagementManifestType.DISCOUNT);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);
        FeeManagementManifest linkedManifest = manifest.getLinkedManifest();
        Transaction implicatedTransaction = linkedManifest.getTransaction();

        implicatedTransaction.setStatus(TransactionStatus.DISCOUNTING);
        implicatedTransaction.setAllocatedAmount(new BigDecimal(-2));
        implicatedTransaction.setLockedAllocatedAmount(new BigDecimal(-3));

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

        // Verify the main manifest still has no Transaction:
        assertNull("Primary transaction must not exist", manifest.getTransaction());

        // Verify the session is marked for manual review:
        assertTrue("FM Session must be marked for manual review", fmSession.getSession().isReviewRequired());

        // Verify session's status changed to CHARGED:
        assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getSession().getStatus());
    }

    @Test
    @Ignore
    public void testChargeSessionTransferNoTransactionTransfer() throws Exception {
        // Create an FM session with linked manifests and simulate allocation remain:
        FmSession fmSession = createFmSession(1, FeeManagementManifestType.DISCOUNT);
        FeeManagementManifest manifest = fmSession.getManifests().get(0);
        FeeManagementManifest linkedManifest = manifest.getLinkedManifest();
        Transaction implicatedTransaction = linkedManifest.getTransaction();

        implicatedTransaction.setStatus(TransactionStatus.TRANSFERRING);
        implicatedTransaction.setAllocatedAmount(new BigDecimal(-2));
        implicatedTransaction.setLockedAllocatedAmount(new BigDecimal(-3));

        // Call the method:
        fmService.chargeSession(fmSession.getSession().getId());

    }

    @Test
    public void testChargeSessionTransferTransactionTransferExistsNoTransferGroup() throws Exception {

    }

    @Test
    public void testChargeSessionTransferPaymentBillingExists() throws Exception {

    }

    @Test
    public void testChargeSessionTransferNoPaymentBillingThirdPartyBillingExists() throws Exception {

    }

    @Test
    public void testChargeSessionTransferNoPaymentBillingNoThirdPartyTransfer() throws Exception {

    }

    /********************************************************************************
     *
     * Helper methods
     *
     ********************************************************************************/

    /**
     * Creates FM Session, primary manifests WITHOUT Transactions, creates linked manifests with implicated transactions.
     *
     * @param numManifests                  Number of FM manifests to create.
     * @param manifestTypes                 Types of primary manifests to create. Must be the size of "numManifests"
     * @return An <code>FmSession</code> with new objects.
     */
    private FmSession createFmSession(int numManifests, FeeManagementManifestType... manifestTypes) {
        return createFmSession(numManifests, false, true, manifestTypes);
    }

    /**
     * Creates an FM Session, Manifests, Linked Manifests, Transactions and Implicated Transactions.
     *
     * @param numManifests                  Number of FM manifests to create.
     * @param addPrimaryTransactions        Whether to add primary manifests' transactions.
     * @param addLinkedManifests            Whether to add linked manifests and their implicated transactions.
     * @param manifestTypes                 Types of primary manifests to create. Must be the size of "numManifests"
     * @return An <code>FmSession</code> with new objects.
     */
    private FmSession createFmSession(int numManifests, boolean addPrimaryTransactions, boolean addLinkedManifests, FeeManagementManifestType... manifestTypes) {
        // Create Session:
        Account account = accountService.getOrCreateAccount(ACCOUNT_ID);
        FeeManagementSession fmSession = new FeeManagementSession();
        FmSession result = new FmSession();

        fmSession.setChargeStatus(FeeManagementSessionStatus.RECONCILED);
        fmSession.setAccount(account);
        persistenceService.persistEntity(fmSession);
        result.setSession(fmSession);

        // Create manifests:
        for (int i=0; i<numManifests; i++) {
            FeeManagementManifest manifest = new FeeManagementManifest();
            BigDecimal manifestAmount = new BigDecimal(10d * (i+1));

            manifest.setSession(fmSession);
            manifest.setType(manifestTypes[i]);
            manifest.setAmount(manifestAmount);
            manifest.setTransactionTypeId(TRANSACTION_TYPE_ID);

            // Add Transaction:
            if (addPrimaryTransactions) {
                Transaction transaction = transactionService.createTransaction(TRANSACTION_TYPE_ID, ACCOUNT_ID, new Date(), manifestAmount);

                manifest.setTransaction(transaction);
            }

            // Persist the manifest:
            persistenceService.persistEntity(manifest);
            result.getManifests().add(manifest);

            // Add linked manifest and implicated transaction:
            if (addLinkedManifests) {
                FeeManagementManifest linkedManifest = new FeeManagementManifest();
                Transaction implicatedTransaction = transactionService.createTransaction(TRANSACTION_TYPE_ID, ACCOUNT_ID, new Date(), manifestAmount.add(new BigDecimal(1)));

                //linkedManifest.setSession(fmSession);
                linkedManifest.setTransaction(implicatedTransaction);
                linkedManifest.setType(FeeManagementManifestType.CORRECTION);
                linkedManifest.setLinkedManifest(manifest);
                persistenceService.persistEntity(manifest);
                manifest.setLinkedManifest(linkedManifest);
                persistenceService.persistEntity(linkedManifest);
            }
        }

        return result;
    }

    /**
     * Encapsulates an FM Session and related Manifests.
     */
    private class FmSession {
        private FeeManagementSession session;
        private List<FeeManagementManifest> manifests = new ArrayList<FeeManagementManifest>();

        public FeeManagementSession getSession() {
            return session;
        }

        public void setSession(FeeManagementSession session) {
            this.session = session;
        }

        public List<FeeManagementManifest> getManifests() {
            return manifests;
        }

        public void setManifests(List<FeeManagementManifest> manifests) {
            this.manifests = manifests;
        }
    }
}
