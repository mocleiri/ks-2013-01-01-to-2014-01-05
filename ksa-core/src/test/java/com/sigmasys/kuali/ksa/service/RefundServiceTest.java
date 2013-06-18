package com.sigmasys.kuali.ksa.service;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sigmasys.kuali.ksa.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
@SuppressWarnings("unchecked")
public class RefundServiceTest extends AbstractServiceTest {

    @PersistenceContext(unitName = Constants.KSA_PERSISTENCE_UNIT)
    protected EntityManager em;

    @Autowired
    private RefundService refundService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        accountService.getOrCreateAccount(userId);
    }

    @Test
    public void testIsRefundRuleValid() throws Exception {
        // Test null rule:
        String refundRule = null;
        boolean ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(ruleValid);

        // Test empty rule:
        refundRule = "";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(ruleValid);

        // Test blank rule:
        refundRule = "   ";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(ruleValid);

        // Test bad format rule:
        refundRule = "1234345---";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test bad format "A" rule:
        refundRule = "A(1234345---";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test bad format "S" rule:
        refundRule = "S123434)5---";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test "A" rule numeric parameter out of lower bound:
        refundRule = "A(-1)";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test "A" rule numeric parameter out of upper bound:
        refundRule = "A(65536)";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test "S" rule numeric parameter out of lower bound:
        refundRule = "S(-100)";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test "S" rule numeric parameter out of upper bound:
        refundRule = "A(65538)";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test "A" rule does not have an account:
        refundRule = "A(9)";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test "A" rule has an blank account:
        refundRule = "A(9)()";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test "A" rule has an non-existing account:
        refundRule = "A(9)(dum-de-dum)";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(!ruleValid);

        // Test valid "A" rule:
        refundRule = "A(9)(admin1)";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(ruleValid);

        // Test valid "S" rule:
        refundRule = "S(9)";
        ruleValid = refundService.isRefundRuleValid(refundRule);

        isTrue(ruleValid);
    }

    @Test
    public void testGetOrCreateRefundType() throws Exception {

        boolean exceptionCaught = false;

        // Test both parameters null:
        try {
            refundService.getOrCreateRefundType(null, null);
            assertTrue(false); // we should not be here
        } catch (Exception e) {
            exceptionCaught = true;
        }

        isTrue(exceptionCaught);

        // Test one parameter null:
        exceptionCaught = false;

        try {
            refundService.getOrCreateRefundType(null, "cash");
            assertTrue(false); // we should not be here
        } catch (Exception e) {
            exceptionCaught = true;
        }

        isTrue(exceptionCaught);

        // Test second parameter null:
        exceptionCaught = false;

        try {
            refundService.getOrCreateRefundType("cash", null);
            assertTrue(false); // we should not be here
        } catch (Exception e) {
            exceptionCaught = true;
        }

        isTrue(exceptionCaught);

        // Test valid parameters, no RefundType exists:
        String creditTypeId = "foobar-y";
        String debitTypeId = "snafu-x";
        List<RefundType> existingRefundTypes = em.createQuery("select rt from RefundType rt where rt.creditTypeId = :creditType and rt.debitTypeId = :debitType")
                .setParameter("creditType", creditTypeId).setParameter("debitType", debitTypeId).setMaxResults(1).getResultList();
        isTrue(CollectionUtils.isEmpty(existingRefundTypes));

        RefundType testRefundType = refundService.getOrCreateRefundType(debitTypeId, creditTypeId);

        notNull(testRefundType);
        notNull(testRefundType.getId());
        isTrue(testRefundType.getId() > 0);
        assertEquals(creditTypeId, testRefundType.getCreditTypeId());
        assertEquals(debitTypeId, testRefundType.getDebitTypeId());
        assertEquals(debitTypeId + ":" + creditTypeId, testRefundType.getCode());
        assertEquals("Autogenerated", testRefundType.getName());

        // Test valid parameters, RefundType exists:
        Long id = testRefundType.getId();

        notNull(id);

        testRefundType = refundService.getOrCreateRefundType(debitTypeId, creditTypeId);
        notNull(testRefundType);
        assertEquals(id, testRefundType.getId());
        assertEquals(debitTypeId, testRefundType.getDebitTypeId());
        assertEquals(creditTypeId, testRefundType.getCreditTypeId());

        // Delete the test RefundType:
        refundService.deleteRefundType(testRefundType);
    }

    @Test
    public void createRefundForPayment() throws Exception {

        Transaction transaction = transactionService.createTransaction("cash", "admin", new Date(), new BigDecimal(10e5));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());

        isTrue(transaction instanceof Payment);

        Payment payment = (Payment) transaction;

        payment.setRefundable(true);
        payment.setRefundRule("A(9)(admin)");

        Refund refund = refundService.checkForRefund(payment.getId());

        notNull(refund);
        notNull(refund.getId());
        notNull(refund.getRequestedBy());
        notNull(refund.getRequestDate());
        notNull(refund.getAmount());

        notNull(refund.getTransaction());
        notNull(refund.getTransaction().getStatus());

        isTrue(payment.getStatus() == TransactionStatus.REFUND_REQUESTED);

    }

    @Test
    public void cancelRefund() throws Exception {

        Transaction transaction = transactionService.createTransaction("cash", "admin", new Date(), new BigDecimal(30.56));

        notNull(transaction);
        notNull(transaction.getId());
        notNull(transaction.getTransactionType());
        notNull(transaction.getAccount());
        notNull(transaction.getAccountId());
        notNull(transaction.getCurrency());

        isTrue(transaction instanceof Payment);

        Payment payment = (Payment) transaction;

        payment.setRefundable(true);
        payment.setRefundRule("A(9)(admin)");

        Refund refund = refundService.checkForRefund(payment.getId());

        notNull(refund);
        notNull(refund.getId());
        notNull(refund.getRequestedBy());
        notNull(refund.getRequestDate());
        notNull(refund.getAmount());
        notNull(refund.getTransaction());
        notNull(refund.getTransaction().getStatus());

        isTrue(payment.getStatus() == TransactionStatus.REFUND_REQUESTED);

        refund = refundService.validateRefund(refund.getId());

        notNull(refund);
        notNull(refund.getId());

        refund = refundService.performRefund(refund.getId());

        notNull(refund);
        notNull(refund.getId());
        notNull(refund.getTransaction());
        notNull(refund.getRefundTransaction());
        notNull(refund.getTransaction().getStatus());

        isTrue(refund.getTransaction().getStatus() == TransactionStatus.REFUNDING);

        refund = refundService.cancelRefund(refund.getId(), "Refund for payment 'cash' has been cancelled");

        notNull(refund);
        notNull(refund.getId());
        notNull(refund.getTransaction());
        notNull(refund.getTransaction().getStatus());

        isTrue(refund.getTransaction().getStatus() == TransactionStatus.ACTIVE);

    }


}
