package com.sigmasys.kuali.ksa.service;

import com.sigmasys.kuali.ksa.config.ConfigService;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.service.brm.BrmContext;
import com.sigmasys.kuali.ksa.service.brm.BrmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.*;


/**
 * BRM FeeManagementService unit tests.
 *
 * @author Michael Ivanov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class BrmFeeManagementServiceTest extends AbstractServiceTest {

    private static final String ACCOUNT_ID = "admin";
    private static final String TRANSACTION_TYPE_ID = "cash";
    private static final BigDecimal MANIFEST_AMOUNT = new BigDecimal(10);
    private static final BigDecimal IMPLICATED_TRANSACTION_AMOUNT = new BigDecimal(12);


    @Autowired
    protected ConfigService configService;

    @Autowired
    private PersistenceService persistenceService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BrmService brmService;


    @Test
    public void assesFees() throws Exception {

        String accountId = "admin";

        Account account = accountService.getOrCreateAccount(accountId);

        // Create an FM session and manifest:
        FeeManagementSession session = createFmSession(1, true, false, false, false, FeeManagementManifestType.ORIGINAL);

        Assert.notNull(session);
        Assert.notNull(session.getSignups());
        Assert.notEmpty(session.getSignups());

        FeeManagementSignup signup = session.getSignups().iterator().next();

        // Calling BrmService with payment application rules
        BrmContext brmContext = new BrmContext();
        brmContext.setAccount(account);

        Map<String, Object> globalParams = new HashMap<String, Object>();

        globalParams.put("fmSession", session);
        globalParams.put("fmSignup", signup);

        brmContext.setGlobalVariables(globalParams);

        brmService.fireRules(Constants.BRM_FM_RULE_SET_NAME_1, brmContext);

        session = (FeeManagementSession) globalParams.get("fmSession");
        signup = (FeeManagementSignup) globalParams.get("fmSignup");

        Assert.notNull(session);
        Assert.notNull(signup);

    }


    /********************************************************************************
     *
     * Helper methods for "chargeSession"
     *
     ********************************************************************************/

    /**
     * Creates an FM Session, Manifests, Linked Manifests, Transactions and Implicated Transactions.
     *
     * @param numManifests             Number of FM manifests to create.
     * @param addPrimaryTransactions   Whether to add primary manifests' transactions.
     * @param addLinkedManifests       Whether to add linked manifests.
     * @param addImplicatedTransaction Whether to add implicated Transactions.
     * @param addLockedAllocation      Whether to add implicated transaction locked allocations in addition to unlocked.
     * @param manifestTypes            Types of primary manifests to create. Must be the size of "numManifests"
     * @return An <code>FmSession</code> with new objects.
     */
    private FeeManagementSession createFmSession(int numManifests, boolean addPrimaryTransactions, boolean addLinkedManifests,
                                                 boolean addImplicatedTransaction, boolean addLockedAllocation, FeeManagementManifestType... manifestTypes) {

        // Create Session:
        Account account = accountService.getOrCreateAccount(ACCOUNT_ID);
        FeeManagementSession session = new FeeManagementSession();

        session.setChargeStatus(FeeManagementSessionStatus.RECONCILED);
        session.setAccount(account);

        session.setAtpId("19871");

        persistenceService.persistEntity(session);

        FeeManagementSignup signup = new FeeManagementSignup();
        signup.setOfferingId("12345");
        signup.setCreationDate(new Date());
        signup.setEffectiveDate(new Date());
        signup.setAtpId("19871");
        signup.setOfferingType(OfferingType.ACTIVITY_OFFERING);
        signup.setSession(session);
        signup.setOperation(FeeManagementSignupOperation. ADD_WITHOUT_PENALTY);
        signup.setUnit(5);

        persistenceService.persistEntity(signup);

        Set<FeeManagementSignup> signups = new HashSet<FeeManagementSignup>();
        signups.add(signup);

        session.setSignups(signups);

        // Create manifests:
        for (int i = 0; i < numManifests; i++) {

            FeeManagementManifest manifest = new FeeManagementManifest();

            manifest.setSession(session);
            manifest.setType(manifestTypes[i]);
            manifest.setAmount(MANIFEST_AMOUNT);
            manifest.setTransactionTypeId(TRANSACTION_TYPE_ID);

            // Add Transaction:
            if (addPrimaryTransactions) {

                Transaction transaction = transactionService.createTransaction(TRANSACTION_TYPE_ID, ACCOUNT_ID, new Date(), MANIFEST_AMOUNT);

                manifest.setTransaction(transaction);
            }

            // Persist the manifest:
            persistenceService.persistEntity(manifest);

            if (session.getManifests() == null) {
                session.setManifests(new HashSet<FeeManagementManifest>());
            }

            session.getManifests().add(manifest);

            // Add linked manifest, linked and implicated transactions:
            if (addLinkedManifests) {

                FeeManagementManifest linkedManifest = new FeeManagementManifest();
                Transaction linkedTransaction = transactionService.createTransaction(TRANSACTION_TYPE_ID, ACCOUNT_ID, new Date(), IMPLICATED_TRANSACTION_AMOUNT);

                linkedManifest.setSession(session);
                linkedManifest.setTransaction(linkedTransaction);
                linkedManifest.setType(FeeManagementManifestType.CORRECTION);
                linkedManifest.setLinkedManifest(manifest);

                persistenceService.persistEntity(manifest);
                manifest.setLinkedManifest(linkedManifest);

                persistenceService.persistEntity(linkedManifest);

                // Create implicated transaction and allocation:
                if (addImplicatedTransaction) {
                    createAllocations(linkedTransaction, addLockedAllocation);
                }
            }
        }

        persistenceService.persistEntity(session);

        return session;
    }

    /**
     * Creates an allocation between the given transaction and a temporary transaction.
     *
     * @param transaction         A transaction for which to create an allocation.
     * @param addLockedAllocation Whether to also create a locked allocation.
     */
    private void createAllocations(Transaction transaction, boolean addLockedAllocation) {

        // Create an unlocked allocation:
        BigDecimal allocationAmount = transaction.getAmount().divide(new BigDecimal(2));
        Transaction implicatedTransaction = transactionService.createTransaction(TRANSACTION_TYPE_ID, ACCOUNT_ID,
                new Date(), transaction.getAmount().negate());

        transactionService.createAllocation(transaction.getId(), implicatedTransaction.getId(), allocationAmount);

        // Create a locked allocation if needed:
        if (addLockedAllocation) {
            // Refresh the transactions:
            transaction = transactionService.getTransaction(transaction.getId());
            implicatedTransaction = transactionService.getTransaction(implicatedTransaction.getId());

            // Create a locked allocation:
            transactionService.createAllocation(transaction, implicatedTransaction, allocationAmount, true, true, false);
        }
    }

}
