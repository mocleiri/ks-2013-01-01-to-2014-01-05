package com.sigmasys.kuali.ksa.service;


import java.math.BigDecimal;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sigmasys.kuali.ksa.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import static org.springframework.util.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
@SuppressWarnings("unchecked")
public class TransactionServiceTest extends AbstractServiceTest {

    private static final String GL_ACCOUNT_ID = "03-2-998870 7723";

    @PersistenceContext(unitName = Constants.KSA_PERSISTENCE_UNIT)
    protected EntityManager em;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private GeneralLedgerService glService;

    @Autowired
    private AccountService accountService;

    private Transaction transaction1;
    private Transaction transaction2;

    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        accountService.getOrCreateAccount(userId);
    }

    @Test
    public void createTransaction() throws Exception {

        String id = "cash";

        Transaction transaction = transactionService.createTransaction(id, "admin", new Date(), new BigDecimal(10e5));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());

        isTrue("USD".equals(transaction.getCurrency().getCode()));
        isTrue("admin".equals(transaction.getAccount().getId()));
        isTrue(new Date().compareTo(transaction.getEffectiveDate()) >= 0);
        isTrue(new BigDecimal(10e5).equals(transaction.getNativeAmount()));

    }

    private void createAllocation(boolean locked) {

        String id = "1020";

        transaction1 = transactionService.createTransaction(id, "admin", new Date(), new BigDecimal(100));
        transaction2 = transactionService.createTransaction(id, "admin", new Date(), new BigDecimal(-100));

        notNull(transaction1);
        notNull(transaction2);
        notNull(transaction1.getId());
        notNull(transaction2.getId());
        notNull(transaction1.getAmount());
        notNull(transaction2.getAmount());

        CompositeAllocation compositeAllocation =
                locked ?
                        transactionService.createLockedAllocation(transaction1.getId(), transaction2.getId(), new BigDecimal(90)) :
                        transactionService.createAllocation(transaction1.getId(), transaction2.getId(), new BigDecimal(90));

        notNull(compositeAllocation);

        Allocation allocation = compositeAllocation.getAllocation();

        notNull(allocation);
        notNull(allocation.getId());
        notNull(allocation.getFirstTransaction());
        notNull(allocation.getSecondTransaction());
        notNull(allocation.getFirstTransaction().getId());
        notNull(allocation.getSecondTransaction().getId());
        isTrue(allocation.getFirstTransaction().getId().equals(transaction1.getId()));
        isTrue(allocation.getSecondTransaction().getId().equals(transaction2.getId()));

        transaction1 = transactionService.getTransaction(transaction1.getId());
        transaction2 = transactionService.getTransaction(transaction2.getId());

        notNull(transaction1);
        notNull(transaction2);
        notNull(transaction1.getId());
        notNull(transaction2.getId());

        isTrue(new BigDecimal(90).equals(allocation.getAmount()));

        BigDecimal allocatedAmount1 = locked ?
                transaction1.getLockedAllocatedAmount() :
                transaction1.getAllocatedAmount();

        BigDecimal allocatedAmount2 = locked ?
                transaction2.getLockedAllocatedAmount() :
                transaction2.getAllocatedAmount();

        logger.info("allocatedAmount1 = " + allocatedAmount1);
        logger.info("allocatedAmount2 = " + allocatedAmount2);

        isTrue(new BigDecimal(90).equals(allocatedAmount1));
        isTrue(new BigDecimal(90).equals(allocatedAmount2));
    }

    @Test
    public void createAllocation() throws Exception {

        createAllocation(false);

    }

    @Test
    public void createLockedAllocation() throws Exception {

        createAllocation(true);

    }

    @Test
    public void removeAllocation() throws Exception {

        createAllocation();

        transactionService.removeAllocation(transaction1.getId(), transaction2.getId());

    }

    @Test
    public void removeLockedAllocation() throws Exception {

        createLockedAllocation();

        transactionService.removeLockedAllocation(transaction1.getId(), transaction2.getId());

    }

    @Test
    public void removeAllocations() throws Exception {

        createAllocation();

        transactionService.removeAllocations(transaction2.getId());

    }

    @Test
    public void getTransactions() throws Exception {

        List<Transaction> transactions = transactionService.getTransactions();

        notNull(transactions);
        notEmpty(transactions);

        // Add more assertions when we have some test data
    }

    @Test
    public void getCharges() throws Exception {

        List<Charge> charges = transactionService.getCharges();

        notNull(charges);
        notEmpty(charges);

        // Add more assertions when we have some test data
    }

    @Test
    public void getTransaction() throws Exception {

        Transaction transaction = transactionService.getTransaction(7777777L);

        // Check that the entity does not exist
        isNull(transaction);

        // Add more assertions when we have some test data
    }

    @Test
    public void getTransactionByUserId() throws Exception {

        List<Transaction> transactions = transactionService.getTransactions("dukakis");

        notNull(transactions);

        isTrue(transactions.isEmpty());

        // Add more assertions when we have some test data
    }

    @Test
    public void getChargesWithFormattedAmounts() throws Exception {

        List<Charge> charges = transactionService.getCharges();

        notNull(charges);
        notEmpty(charges);

        for (Charge charge : charges) {
            notNull(charge.getFormattedAmount());
            logger.info("Formatted amount = " + charge.getFormattedAmount());
        }

    }

    @Test
    public void getTransactionType() throws Exception {

        String id = "1020";

        TransactionType transactionType = transactionService.getTransactionType(id, new Date());

        notNull(transactionType);
        notNull(transactionType.getId());
        isTrue("1020".equals(transactionType.getId().getId()));

    }

    @Test
    public void getTransactionTypeClass() throws Exception {

        String id = "1020";

        Class<TransactionType> debitTypeClass = transactionService.getTransactionTypeClass(id);

        notNull(debitTypeClass);
        notNull(debitTypeClass.equals(DebitType.class));

    }

    @Test
    public void reverseTransaction() throws Exception {

        String id = "cash";

        Transaction transaction = transactionService.createTransaction(id, "admin", new Date(), new BigDecimal(10e5));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getTransactionType().getId());

        TransactionTypeId transactionTypeId = transaction.getTransactionType().getId();

        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());
        notNull(transaction.getAmount());

        transaction = transactionService.reverseTransaction(transaction.getId(), "Memo text", new BigDecimal(150.05),
                "Reversed");

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());
        notNull(transaction.getAmount());

        isTrue(transaction.getStatementText().contains("Reversed"));
        isTrue(transactionTypeId.equals(transaction.getTransactionType().getId()));

    }

    @Test
    public void createDeferment() throws Exception {

        // Must be a credit type 'C'
        String id = "ach";
        String userId = "admin";

        Date effectiveDate = new Date();
        Date expirationDate = new Date(effectiveDate.getTime() * 2);

        Transaction deferment =
                transactionService.createTransaction(id, null, userId, effectiveDate, expirationDate,
                        new BigDecimal(10e5), false);


        notNull(deferment);

        isTrue(deferment instanceof Deferment);

        notNull(deferment.getId());
        notNull(deferment.getTransactionType());
        notNull(deferment.getTransactionType().getId());

        notNull(deferment.getAccount());
        notNull(deferment.getAccountId());
        notNull(deferment.getCurrency());
        notNull(deferment.getAmount());

    }

    @Test
    public void expireDeferment() throws Exception {

        // Must be a credit type 'C'
        String id = "ach";
        String userId = "admin";

        Date effectiveDate = new Date();
        Date expirationDate = new Date(effectiveDate.getTime() * 2);

        Transaction deferment =
                transactionService.createTransaction(id, null, userId, effectiveDate, expirationDate,
                        new BigDecimal(10e5), false);


        notNull(deferment);

        isTrue(deferment instanceof Deferment);

        notNull(deferment.getId());
        notNull(deferment.getTransactionType());
        notNull(deferment.getTransactionType().getId());

        notNull(deferment.getAccount());
        notNull(deferment.getAccountId());
        notNull(deferment.getCurrency());
        notNull(deferment.getAmount());

        transactionService.expireDeferment(deferment.getId());

    }

    @Test
    public void makeEffective() throws Exception {

        String id = "cash";

        Transaction transaction = transactionService.createTransaction(id, "admin", new Date(), new BigDecimal(10e5));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getTransactionType().getId());

        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());
        notNull(transaction.getAmount());

        transactionService.makeEffective(transaction.getId(), false);

    }

    @Test
    public void makeEffectiveForced() throws Exception {

        String id = "cash";

        Transaction transaction = transactionService.createTransaction(id, "admin", new Date(), new BigDecimal(10e5));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getTransactionType().getId());

        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());
        notNull(transaction.getAmount());

        transactionService.makeEffective(transaction.getId(), true);

    }

    @Test
    public void writeOffTransaction() throws Exception {

        // Must be a Charge
        String id = "1020";

        Transaction transaction = transactionService.createTransaction(id, "admin", new Date(), new BigDecimal(10e3));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getTransactionType().getId());

        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());
        notNull(transaction.getAmount());

        transaction = transactionService.writeOffTransaction(transaction.getId(), null, "Memo text", "Write-off");

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getTransactionType().getId());

        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());
        notNull(transaction.getAmount());

        isTrue(transaction.getStatementText().contains("Write-off"));
        isTrue(transaction.getAmount().compareTo(new BigDecimal(10e3).negate()) == 0);

    }

    @Test
    public void setGeneralLedgerType1() throws Exception {

        String id = "1020";

        Transaction transaction = transactionService.createTransaction(id, "admin", new Date(), new BigDecimal(10e3));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getTransactionType().getId());

        isTrue(!transaction.isGlEntryGenerated());

        GeneralLedgerType glType = glService.getDefaultGeneralLedgerType();

        notNull(glType);
        notNull(glType.getId());

        transactionService.setGeneralLedgerType(transaction.getId(), glType.getId());

        transaction = transactionService.getTransaction(transaction.getId());

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getGeneralLedgerType());
        isTrue(glType.getId().equals(transaction.getGeneralLedgerType().getId()));
        isTrue(!transaction.isGlEntryGenerated());

    }

    @Test
    public void setGeneralLedgerType2() throws Exception {

        String id = "1020";

        Transaction transaction = transactionService.createTransaction(id, "admin", new Date(), new BigDecimal(10e3));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getTransactionType().getId());

        isTrue(!transaction.isGlEntryGenerated());

        transactionService.makeEffective(transaction.getId(), false);

        GeneralLedgerType glType = glService.getDefaultGeneralLedgerType();

        notNull(glType);
        notNull(glType.getId());

        boolean isException = false;
        try {
            transactionService.setGeneralLedgerType(transaction.getId(), glType.getId());
        } catch (IllegalStateException e) {
            notNull(e.getMessage());
            isException = true;
        }

        isTrue(isException);
    }


    @Test
    public void allocateReversals() throws Exception {

        String userId = "admin";

        Transaction transaction = transactionService.createTransaction("1020", userId, new Date(), new BigDecimal(10e5));

        notNull(transaction);
        notNull(transaction.getId());

        transaction = transactionService.createTransaction("1020", userId, new Date(), new BigDecimal(-10e5));

        notNull(transaction);
        notNull(transaction.getId());


        List<Transaction> transactions = transactionService.getTransactions(userId);

        notNull(transactions);
        notEmpty(transactions);

        for (Transaction t : transactions) {
            notNull(t);
            notNull(t.getId());
        }

        List<GlTransaction> glTransactions = transactionService.allocateReversals(userId, true);

        notNull(glTransactions);
        notEmpty(glTransactions);

        isTrue(glTransactions.size() == 2);

        glTransactions = transactionService.allocateReversals(userId, false);

        notNull(glTransactions);

        isTrue(glTransactions.isEmpty());

    }


    @Test
    public void testTransactionExistsByTransactionType() throws Exception {
        // Create a new Transaction:
        String transactionTypeId = "1020";
        String accountId = "admin";
        BigDecimal amount = new BigDecimal(10e3);
        Date effectiveDate = new Date();

        transactionService.createTransaction(transactionTypeId, accountId, effectiveDate, amount);

        // Call the service:
        boolean exists = transactionService.transactionExists(accountId, transactionTypeId);

        isTrue(exists);

        // Try to find a Transaction by a fake Account:
        String fakeAccount = "fake";

        exists = transactionService.transactionExists(fakeAccount, transactionTypeId);
        isTrue(!exists);

        // Try to find a Transaction by a fake Transaction ID:
        String fakeTransactionTypeId = "somethingelse";

        exists = transactionService.transactionExists(accountId, fakeTransactionTypeId);
        isTrue(!exists);

        // Try to find a Transaction by all fake parameters:
        exists = transactionService.transactionExists(fakeAccount, fakeTransactionTypeId);
        isTrue(!exists);

        // Pass invalid parameters:
        try {
            transactionService.transactionExists(null, fakeTransactionTypeId);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(fakeAccount, null);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransactionExistsByTransactionTypeAndAmount() throws Exception {
        // Create a new Transaction:
        String transactionTypeId = "1020";
        String accountId = "admin";
        BigDecimal amount = new BigDecimal(10e3);
        Date effectiveDate = new Date();

        transactionService.createTransaction(transactionTypeId, accountId, effectiveDate, amount);

        // Call the service:
        BigDecimal amountFrom = new BigDecimal(10e2);
        BigDecimal amountTo = new BigDecimal(10e4);
        boolean exists = transactionService.transactionExists(accountId, transactionTypeId, amountFrom, amountTo);

        isTrue(exists);

        // Try to find a Transaction by a fake Account:
        String fakeAccount = "fake";

        exists = transactionService.transactionExists(fakeAccount, transactionTypeId, amountFrom, amountTo);
        isTrue(!exists);

        // Try to find a Transaction by a fake Transaction ID:
        String fakeTransactionTypeId = "somethingelse";

        exists = transactionService.transactionExists(accountId, fakeTransactionTypeId, amountFrom, amountTo);
        isTrue(!exists);

        // Try to find a Transaction by a fake amount:
        BigDecimal fakeAmount = new BigDecimal(1.0);

        exists = transactionService.transactionExists(accountId, transactionTypeId, fakeAmount, fakeAmount);
        isTrue(!exists);

        // Try to find a Transaction by all fake parameters:
        exists = transactionService.transactionExists(fakeAccount, fakeTransactionTypeId, fakeAmount, fakeAmount);
        isTrue(!exists);

        // Pass invalid parameters:
        try {
            transactionService.transactionExists(null, fakeTransactionTypeId, fakeAmount, fakeAmount);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(fakeAccount, null, fakeAmount, fakeAmount);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(fakeAccount, fakeTransactionTypeId, (BigDecimal) null, null);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, (BigDecimal) null, null);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransactionExistsByTransactionTypeAndEffectiveDate() throws Exception {
        // Create a new Transaction:
        String transactionTypeId = "1020";
        String accountId = "admin";
        BigDecimal amount = new BigDecimal(10e3);
        Date effectiveDate = new Date();

        transactionService.createTransaction(transactionTypeId, accountId, effectiveDate, amount);

        // Prepare input Date parameters:
        Calendar newDateFrom = Calendar.getInstance();
        int newDateFromYear = newDateFrom.get(Calendar.YEAR) - 1;
        int newDateFromMonth = Calendar.JULY;
        int newDateFromDay = 18;
        Calendar newDateTo = Calendar.getInstance();
        int newDateToYear = newDateTo.get(Calendar.YEAR) + 1;
        int newDateToMonth = Calendar.JANUARY;
        int newDateToDay = 25;

        newDateFrom.set(Calendar.YEAR, newDateFromYear);
        newDateFrom.set(Calendar.MONTH, newDateFromMonth);
        newDateFrom.set(Calendar.DAY_OF_MONTH, newDateFromDay);

        newDateTo.set(Calendar.YEAR, newDateToYear);
        newDateTo.set(Calendar.MONTH, newDateToMonth);
        newDateTo.set(Calendar.DAY_OF_MONTH, newDateToDay);

        // Call the service:
        boolean exists = transactionService.transactionExists(accountId, transactionTypeId, newDateFrom.getTime(), newDateTo.getTime());

        isTrue(exists);

        // Try to find a Transaction by a fake Account:
        String fakeAccount = "fake";

        exists = transactionService.transactionExists(fakeAccount, transactionTypeId, newDateFrom.getTime(), newDateTo.getTime());
        isTrue(!exists);

        // Try to find a Transaction by a fake Transaction ID:
        String fakeTransactionTypeId = "somethingelse";

        exists = transactionService.transactionExists(accountId, fakeTransactionTypeId, newDateFrom.getTime(), newDateTo.getTime());
        isTrue(!exists);

        // Try to find a Transaction by a fake Effective Date:
        Date fakeEffectiveDate = new Date(0);

        exists = transactionService.transactionExists(accountId, transactionTypeId, fakeEffectiveDate, fakeEffectiveDate);
        isTrue(!exists);

        // Try to find a Transaction by all fake parameters:
        exists = transactionService.transactionExists(fakeAccount, fakeTransactionTypeId, fakeEffectiveDate, fakeEffectiveDate);
        isTrue(!exists);

        // Pass invalid parameters:
        try {
            transactionService.transactionExists(null, fakeTransactionTypeId, fakeEffectiveDate, fakeEffectiveDate);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(fakeAccount, null, fakeEffectiveDate, fakeEffectiveDate);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, fakeEffectiveDate, fakeEffectiveDate);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, fakeEffectiveDate, null);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, null, fakeEffectiveDate);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, (Date) null, null);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransactionExistsByTransactionTypeAmountAndEffectiveDate() throws Exception {
        // Create a new Transaction:
        String transactionTypeId = "1020";
        String accountId = "admin";
        BigDecimal amount = new BigDecimal(10e3);
        Date effectiveDate = new Date();

        transactionService.createTransaction(transactionTypeId, accountId, effectiveDate, amount);

        // Prepare input Date parameters:
        Calendar newDateFrom = Calendar.getInstance();
        int newDateFromYear = newDateFrom.get(Calendar.YEAR) - 1;
        int newDateFromMonth = Calendar.JULY;
        int newDateFromDay = 18;
        Calendar newDateTo = Calendar.getInstance();
        int newDateToYear = newDateTo.get(Calendar.YEAR) + 1;
        int newDateToMonth = Calendar.JANUARY;
        int newDateToDay = 25;

        newDateFrom.set(Calendar.YEAR, newDateFromYear);
        newDateFrom.set(Calendar.MONTH, newDateFromMonth);
        newDateFrom.set(Calendar.DAY_OF_MONTH, newDateFromDay);

        newDateTo.set(Calendar.YEAR, newDateToYear);
        newDateTo.set(Calendar.MONTH, newDateToMonth);
        newDateTo.set(Calendar.DAY_OF_MONTH, newDateToDay);

        // Call the service:
        BigDecimal amountFrom = new BigDecimal(10e2);
        BigDecimal amountTo = new BigDecimal(10e4);
        boolean exists = transactionService.transactionExists(accountId, transactionTypeId, amountFrom, amountTo, newDateFrom.getTime(), newDateTo.getTime());

        isTrue(exists);

        // Try to find a Transaction by a fake Account:
        String fakeAccount = "fake";

        exists = transactionService.transactionExists(fakeAccount, transactionTypeId, amountFrom, amountTo, newDateFrom.getTime(), newDateTo.getTime());
        isTrue(!exists);

        // Try to find a Transaction by a fake Transaction ID:
        String fakeTransactionTypeId = "somethingelse";

        exists = transactionService.transactionExists(accountId, fakeTransactionTypeId, amountFrom, amountTo, newDateFrom.getTime(), newDateTo.getTime());
        isTrue(!exists);

        // Try to find a Transaction by a fake amount:
        BigDecimal fakeAmount = new BigDecimal(1.0);

        exists = transactionService.transactionExists(accountId, transactionTypeId, fakeAmount, fakeAmount, newDateFrom.getTime(), newDateTo.getTime());
        isTrue(!exists);

        // Try to find a Transaction by a fake Effective Date:
        Date fakeEffectiveDate = new Date(0);

        exists = transactionService.transactionExists(accountId, transactionTypeId, amountFrom, amountTo, fakeEffectiveDate, fakeEffectiveDate);
        isTrue(!exists);

        // Try to find a Transaction by all fake parameters:
        exists = transactionService.transactionExists(fakeAccount, fakeTransactionTypeId, fakeAmount, fakeAmount, fakeEffectiveDate, fakeEffectiveDate);
        isTrue(!exists);

        // Pass invalid parameters:
        try {
            transactionService.transactionExists(null, fakeTransactionTypeId, fakeAmount, fakeAmount, fakeEffectiveDate, fakeEffectiveDate);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(fakeAccount, null, fakeAmount, fakeAmount, fakeEffectiveDate, fakeEffectiveDate);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, fakeAmount, fakeAmount, fakeEffectiveDate, fakeEffectiveDate);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, null, null, fakeEffectiveDate, fakeEffectiveDate);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, null, null, fakeEffectiveDate, null);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, null, null, null, fakeEffectiveDate);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }

        try {
            transactionService.transactionExists(null, null, null, null, null, null);
            isTrue(false); // should not even get here
        } catch (Exception e) {
        }
    }

    @Test
    public void getCreditPermissions() throws Exception {

        Transaction transaction = transactionService.createTransaction("chip", "admin", new Date(), new BigDecimal(100.55));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getTransactionType().getId());

        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());
        notNull(transaction.getAmount());

        // Getting credit permissions
        List<CreditPermission> creditPermissions =
                transactionService.getCreditPermissions(transaction.getTransactionType().getId());

        notNull(creditPermissions);
        notEmpty(creditPermissions);

        for (CreditPermission creditPermission : creditPermissions) {
            logger.info("Credit Permission = " + creditPermission);
            notNull(creditPermission);
            notNull(creditPermission.getId());
            notNull(creditPermission.getAllowableDebitType());
            notNull(creditPermission.getCreditType());
        }

        creditPermissions =
                transactionService.getCreditPermissions(transaction.getTransactionType().getId(), 0, Integer.MAX_VALUE);

        notNull(creditPermissions);
        notEmpty(creditPermissions);

        for (CreditPermission creditPermission : creditPermissions) {
            logger.info("Credit Permission = " + creditPermission);
            notNull(creditPermission);
            notNull(creditPermission.getId());
            notNull(creditPermission.getAllowableDebitType());
            notNull(creditPermission.getCreditType());
        }

    }

    @Test
    public void isCancellationRuleValid() throws Exception {

        // Valid cases

        String rule = "DAYS(10)PERCENTAGE(50);DAYS(20)PERCENTAGE(20);DAYS(30)PERCENTAGE(1)";

        isTrue(transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(10)AMOUNT(500.99)";

        isTrue(transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/31/2001)PERCENTAGE(100)";

        isTrue(transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(0)PERCENTAGE(99.99);DAYS(365)AMOUNT(1160000.456)";

        isTrue(transactionService.isCancellationRuleValid(rule));

        rule = "DATE(10/11/1789)PERCENTAGE(50);DATE(12/12/2012)AMOUNT(4333.45);DATE(12/13/2012)PERCENTAGE(2.9)";

        isTrue(transactionService.isCancellationRuleValid(rule));

        rule = "DATE(10/10/2001)PERCENTAGE(50);DATE(01/01/2007)PERCENTAGE(20);DATE(11/23/2009)AMOUNT(1800.99)";

        isTrue(transactionService.isCancellationRuleValid(rule));

        rule = "  DAYS(0)PERCENTAGE(99.99);DAYS(365)AMOUNT(1160000.456)     ";

        isTrue(transactionService.isCancellationRuleValid(rule));


        // Invalid cases

        rule = null;

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "        ";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "BLAH;BLAH;?{}!@~*&^%$";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(10)PERCENTAGE(50);DAYS(20)PERCENTAGE(20);DAYS(30)PERCENTAGE(10";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "!!!DAYS(10)PERCENTAGE(50);DAYS(20)PERCENTAGE(20);DAYS(30)PERCENTAGE(1.1)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(10)PERCENTAGE(50);DAYS(20)PERCENTAGE(20);DAYS(30)PERCENTAGE(1.9);";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(10)PERCENTAGE(50);DAYS(20)PERCENTAGE(20);DAYS(30)PERCENTAGE(0);";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(10)PERCENTAGE(500);DAYS(20)PERCENTAGE(20);DAYS(30)PERCENTAGE(13)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(10)PERCENTAGE(50);DAYS(20)PERCENTAGE(20);DAYS(30)PERCENTAGE(-30)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(10)PERCENTAGE(50);DATE(12/10/1999)PERCENTAGE(20);DAYS(30)PERCENTAGE(80)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(10)PERCENTAGE(50);DAYS(5)PERCENTAGE(20);DAYS(30)PERCENTAGE(80)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DAYS(10)PERCENTAGE(50);DAYS(25)PERCENTAGE(20);DAYS(30)PERSENTAGE(80)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(10/10/2001)PERCENTAGE(50);DATE(01/01/2007)PERCENTAGE(20);DATE(30)AMOUNT(800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(10/10/2001)PERCENTAGE(50);DATE(01/01/2007)PERCENTAGE(20);DATE(11/23/2003)AMOUNT(800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(10/10/2001)PERCENTAGE(50);DATE(01/01/2007)PERCENTAGE(20);DATE(11/23/2009)AMOUNT(-1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(10/10/2001)PERCENTAGE(50);DATE(01/01/2007)PERCENTAGE(20);DATE(11/23/2009))AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(10/10/2001)PERCENTAGE(50);DATE(01/01/2007)PERCENTAGE(20);DATE(11/23/2009);AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(13/10/2001)PERCENTAGE(50);DATE(01/01/2007)PERCENTAGE(20);DATE(11/23/2009)AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001)PERCENTAGE(50);DATE(01-01-2007)PERCENTAGE(20);DATE(11/23/2009)AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001PERCENTAGE(50);DATE(01/01/2007)PERCENTAGE(20);DATE(11/23/2009)AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001)PERCENTAGE(50)PERCENTAGE(20);DATE(11/23/2009)AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001)PERCENTAGE(50);;DATE(11/23/2009)AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = ";DATE(12/10/2001)PERCENTAGE(50);DATE(11/23/2009)AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001);PERCENTAGE(50);DATE(11/23/2009)AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001)PERCENTAGE(50)DATE(11/23/2009)AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001)PERCENTAGE(50);DATE(11/23/2009);AMOUNT(1800.99)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001)PERCENTAGE(50);DATE(11/23/2009)AMOUNT(1800.99);DATE";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001)PERCENTAGE(50);DATE(11/23/2009)AMOUNT(1800.99);DATE(02/12/2012)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

        rule = "DATE(12/10/2001)PERCENTAGE(50);DATE(11/23/2009)AMOUNT(1800.99);DATE(null)AMOUNT(30)";

        isTrue(!transactionService.isCancellationRuleValid(rule));

    }

    @Test
    public void calculateCancellationRule1() throws Exception {

        String rule = "DAYS(10)PERCENTAGE(50);DAYS(20)PERCENTAGE(20);DAYS(30)PERCENTAGE(5.8)";

        rule = transactionService.calculateCancellationRule(rule, new Date());

        notNull(rule);
        isTrue(!rule.isEmpty());
        isTrue(rule.split(";").length == 3);
        isTrue(!rule.contains("DAYS"));
        isTrue(rule.contains("DATE"));

        logger.info("Modified cancellation rule = " + rule);
    }

    @Test
    public void calculateCancellationRule2() throws Exception {

        String rule = "DATE(10/11/1789)PERCENTAGE(50);DATE(12/12/2012)AMOUNT(4333.45);DATE(12/12/2013)PERCENTAGE(10)";

        rule = transactionService.calculateCancellationRule(rule, new Date());

        notNull(rule);
        isTrue(!rule.isEmpty());
        isTrue(rule.split(";").length == 3);
        isTrue(!rule.contains("DAYS"));
        isTrue(rule.contains("DATE"));

        logger.info("Modified cancellation rule = " + rule);
    }

    @Test
    public void getCancellationAmount() throws Exception {

        String userId = "admin";

        String rule = "DATE(10/11/1789)PERCENTAGE(50);DATE(12/12/2012)AMOUNT(4333.45);DATE(12/12/2013)PERCENTAGE(10)";

        TransactionType chargeType = transactionService.getTransactionType("1299", new Date());

        notNull(chargeType);
        notNull(chargeType.getId());
        notNull(chargeType.getId().getId());
        isTrue(chargeType instanceof DebitType);

        ((DebitType) chargeType).setCancellationRule(rule);

        transactionService.persistTransactionType(chargeType);

        String typeId = chargeType.getId().getId();

        Transaction charge = transactionService.createTransaction(typeId, userId, new Date(), new BigDecimal(1500.99));

        notNull(charge);
        notNull(charge.getId());

        BigDecimal cancellationAmount = transactionService.getCancellationAmount(charge.getId());

        notNull(cancellationAmount);
        isTrue(cancellationAmount.compareTo(BigDecimal.ZERO) > 0);

    }

    @Test
    public void createGlBreakdowns() throws Exception {


        TransactionType chargeType = transactionService.getTransactionType("1299", new Date());

        notNull(chargeType);

        GeneralLedgerType glType = glService.getDefaultGeneralLedgerType();

        notNull(glType);

        List<GlBreakdown> breakdowns = new LinkedList<GlBreakdown>();

        GlBreakdown breakdown = new GlBreakdown();
        breakdown.setGlAccount(GL_ACCOUNT_ID);
        breakdown.setGlOperation(GlOperationType.CREDIT);
        breakdown.setBreakdown(new BigDecimal(20.5));
        breakdowns.add(breakdown);

        breakdown = new GlBreakdown();
        breakdown.setGlAccount(GL_ACCOUNT_ID);
        breakdown.setGlOperation(GlOperationType.DEBIT);
        breakdown.setBreakdown(new BigDecimal(50));
        breakdowns.add(breakdown);

        breakdown = new GlBreakdown();
        breakdown.setGlAccount(GL_ACCOUNT_ID);
        breakdown.setGlOperation(GlOperationType.CREDIT);
        breakdown.setBreakdown(new BigDecimal(0));
        breakdowns.add(breakdown);

        List<Long> breakdownIds = transactionService.createGlBreakdowns(glType.getId(), chargeType.getId(), breakdowns);

        notNull(breakdownIds);
        notEmpty(breakdownIds);
        isTrue(breakdownIds.size() == breakdowns.size());

        for (GlBreakdown b : breakdowns) {
            notNull(b.getId());
            isTrue(GL_ACCOUNT_ID.equals(b.getGlAccount()));
        }

    }


    @Test
    public void setGeneralLedgerType() throws Exception {

        GeneralLedgerType glType = glService.createGeneralLedgerType("GL_TYPE10000000", "Test GL type2",
                "Test GL Description 2", GL_ACCOUNT_ID, GlOperationType.DEBIT);

        notNull(glType);
        notNull(glType.getId());
        notNull(glType.getCode());
        notNull(glType.getName());
        notNull(glType.getDescription());
        notNull(glType.getGlAccountId());
        notNull(glType.getGlOperationOnCharge());
        notNull(glType.getCreationDate());
        notNull(glType.getCreatorId());

        isTrue(GlOperationType.DEBIT == glType.getGlOperationOnCharge());

        Transaction transaction = transactionService.createTransaction("chip", "admin", new Date(), new BigDecimal(1.1));

        notNull(transaction);
        notNull(transaction.getId());

        transactionService.setGeneralLedgerType(transaction.getId(), glType.getId());

        transaction = transactionService.getTransaction(transaction.getId());

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getGeneralLedgerType());
        notNull(transaction.getGeneralLedgerType().getId());
        isTrue(glType.getId().equals(transaction.getGeneralLedgerType().getId()));

    }

    @Test
    public void addTagsToTransaction() throws Exception {

        int numberOfTags = 100;

        List<Tag> tags = new ArrayList<Tag>(numberOfTags);

        for (int i = 0; i < numberOfTags; i++) {
            int j = i + 1;
            Tag tag = auditableEntityService.createAuditableEntity("tag_" + j, "Tag name" + j, "Tag desc " + j, Tag.class);
            tags.add(tag);
        }

        Transaction transaction = transactionService.createTransaction("cash", "admin", new Date(), new BigDecimal(10e3));

        Assert.notNull(transaction);
        Assert.notNull(transaction.getId());

        transaction = transactionService.addTagsToTransaction(transaction.getId(), tags);

        tags = transaction.getTags();

        Assert.notNull(tags);
        Assert.notEmpty(tags);
        Assert.isTrue(tags.size() >= numberOfTags);

        for (Tag tag : tags) {
            Assert.notNull(tag);
            Assert.notNull(tag.getId());
            Assert.notNull(tag.getCode());
            Assert.notNull(tag.getCreatorId());
            Assert.notNull(tag.getCreationDate());
            Assert.isTrue(tag.getCreationDate().before(new Date()));
        }

        Tag tag = auditableEntityService.createAuditableEntity("t##", "t##", "Tag desc ##", Tag.class);
        tags.add(tag);

        transaction = transactionService.addTagsToTransaction(transaction.getId(), tags);

        tags = transaction.getTags();

        Assert.notNull(tags);
        Assert.notEmpty(tags);
        Assert.isTrue(tags.size() >= numberOfTags + 1);

    }

    @Test
    public void addTagsToTransactionType() throws Exception {

        int numberOfTags = 66;

        List<Tag> tags = new ArrayList<Tag>(numberOfTags);

        for (int i = 0; i < numberOfTags; i++) {
            int j = i + 1;
            Tag tag = auditableEntityService.createAuditableEntity("tag_" + j, "Tag name" + j, "Tag desc " + j, Tag.class);
            tags.add(tag);
        }

        TransactionType transactionType = transactionService.getTransactionType("cash", new Date());

        Assert.notNull(transactionType);
        Assert.notNull(transactionType.getId());

        transactionType = transactionService.addTagsToTransactionType(transactionType.getId(), tags);

        tags = transactionType.getTags();

        Assert.notNull(tags);
        Assert.notEmpty(tags);
        Assert.isTrue(tags.size() >= numberOfTags);

        for (Tag tag : tags) {
            Assert.notNull(tag);
            Assert.notNull(tag.getId());
            Assert.notNull(tag.getCode());
            Assert.notNull(tag.getCreatorId());
            Assert.notNull(tag.getCreationDate());
            Assert.isTrue(tag.getCreationDate().before(new Date()));
        }

        Tag tag = auditableEntityService.createAuditableEntity("t##", "t##", "Tag desc ##", Tag.class);
        tags.add(tag);

        transactionType = transactionService.addTagsToTransactionType(transactionType.getId(), tags);

        tags = transactionType.getTags();

        Assert.notNull(tags);
        Assert.notEmpty(tags);
        Assert.isTrue(tags.size() >= numberOfTags + 1);

    }


}
