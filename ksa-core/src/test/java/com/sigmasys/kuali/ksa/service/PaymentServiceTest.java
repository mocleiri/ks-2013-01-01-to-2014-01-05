package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
@SuppressWarnings("unchecked")
public class PaymentServiceTest extends AbstractServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private AccountService accountService;


    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        accountService.getOrCreateAccount(userId);
    }

    @Test
    public void applyPayments1() throws Exception {

        List<Transaction> transactions = new LinkedList<Transaction>();

        transactions.add(transactionService.createTransaction("cash", "admin", new Date(), new BigDecimal(10e5)));
        transactions.add(transactionService.createTransaction("cash", "admin", new Date(), new BigDecimal(10e3)));
        transactions.add(transactionService.createTransaction("1020", "admin", new Date(), new BigDecimal(10e8)));
        transactions.add(transactionService.createTransaction("ach", "admin", new Date(), new BigDecimal(300.07)));
        transactions.add(transactionService.createTransaction("1292", "admin", new Date(), new BigDecimal(0.11)));
        transactions.add(transactionService.createTransaction("ach", "admin", new Date(), new BigDecimal(524.39)));
        transactions.add(transactionService.createTransaction("pp", "admin", new Date(), new BigDecimal(99.01)));
        transactions.add(transactionService.createTransaction("chip", "admin", new Date(), new BigDecimal(230.34)));
        transactions.add(transactionService.createTransaction("1310", "admin", new Date(), new BigDecimal(35.99)));

        List<GlTransaction> glTransactions = paymentService.applyPayments(transactions, new BigDecimal(7000.09), false);

        Assert.notEmpty(glTransactions);

        for (GlTransaction glTransaction : glTransactions) {
            Assert.notNull(glTransaction.getId());
            Assert.notNull(glTransaction.getGlOperation());
            Assert.notNull(glTransaction.getStatus());
            Assert.isTrue(GlTransactionStatus.WAITING == glTransaction.getStatus());
        }

    }

    @Test
    public void applyPayments2() throws Exception {

        List<Transaction> transactions = new LinkedList<Transaction>();

        transactions.add(transactionService.createTransaction("1310", "admin", new Date(), new BigDecimal(-35.99)));
        transactions.add(transactionService.createTransaction("cash", "admin", new Date(), new BigDecimal(10e11)));
        transactions.add(transactionService.createTransaction("cash", "admin", new Date(), new BigDecimal(-10e3)));
        transactions.add(transactionService.createTransaction("1540", "admin", new Date(), new BigDecimal(10e8)));
        transactions.add(transactionService.createTransaction("ach", "admin", new Date(), new BigDecimal(300.07)));
        transactions.add(transactionService.createTransaction("1292", "admin", new Date(), new BigDecimal(-0.98)));
        transactions.add(transactionService.createTransaction("ach", "admin", new Date(), new BigDecimal(524.39)));
        transactions.add(transactionService.createTransaction("pp", "admin", new Date(), new BigDecimal(-99.01)));
        transactions.add(transactionService.createTransaction("chip", "admin", new Date(), new BigDecimal(230.34)));
        transactions.add(transactionService.createTransaction("1539", "admin", new Date(), new BigDecimal(35.99)));

        List<GlTransaction> glTransactions = paymentService.applyPayments(transactions, new BigDecimal(300.09), true);

        Assert.notEmpty(glTransactions);

        for (GlTransaction glTransaction : glTransactions) {
            Assert.notNull(glTransaction.getId());
            Assert.notNull(glTransaction.getGlOperation());
            Assert.notNull(glTransaction.getStatus());
            Assert.isTrue(GlTransactionStatus.QUEUED == glTransaction.getStatus());
        }

    }

    @Test
    public void paymentApplication1() throws Exception {

        String userId = "admin";

        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_US);
        Date transactionDate = dateFormat.parse("12/12/2012");

        transactionService.createTransaction("1310", userId, transactionDate, new BigDecimal(-350.99));
        transactionService.createTransaction("cash", userId, transactionDate, new BigDecimal(10e11));
        transactionService.createTransaction("cash", userId, transactionDate, new BigDecimal(-10e3));
        transactionService.createTransaction("1540", userId, transactionDate, new BigDecimal(10e8));
        transactionService.createTransaction("ach", userId, transactionDate, new BigDecimal(78800.07));
        transactionService.createTransaction("1292", userId, transactionDate, new BigDecimal(-0.98));
        transactionService.createTransaction("ach", userId, transactionDate, new BigDecimal(524.39));
        transactionService.createTransaction("pp", userId, transactionDate, new BigDecimal(-998.01));
        transactionService.createTransaction("chip", userId, transactionDate, new BigDecimal(100111.34));
        transactionService.createTransaction("finaid", userId, transactionDate, new BigDecimal(20000.88));
        transactionService.createTransaction("finaid2", userId, transactionDate, new BigDecimal(5500));

        List<GlTransaction> glTransactions = paymentService.paymentApplication(userId);

        logger.info("The number of generated GL transactions is " + glTransactions.size());
        logger.info("Generated GL transactions: \n" + glTransactions);

        Assert.notNull(glTransactions);
        Assert.notEmpty(glTransactions);
    }

}