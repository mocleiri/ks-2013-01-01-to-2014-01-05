package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.GlTransaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
@SuppressWarnings("unchecked")
public class ReportServiceTest extends GeneralLedgerServiceTest {

    @Autowired
    private ReportService reportService;

    @Autowired
    private TransactionExportService transactionExportService;

    @Autowired
    private GeneralLedgerService glService;


    @Before
    public void setUpWithinTransaction() throws Exception {

        super.setUpWithinTransaction();

        accountService.getOrCreateAccount("user1");
        accountService.getOrCreateAccount("user2");
    }

    @Test
    public void generateGeneralLedgerReport() throws Exception {

        GlTransaction glTransaction1 = createGlTransaction(transaction1);
        Assert.notNull(glTransaction1);
        Assert.notNull(glTransaction1.getId());
        Assert.notNull(glTransaction1.getStatus());
        Assert.notNull(glTransaction1.getRecognitionPeriod());

        GlTransaction glTransaction2 = createGlTransaction(transaction2);
        Assert.notNull(glTransaction2);
        Assert.notNull(glTransaction2.getId());
        Assert.notNull(glTransaction2.getStatus());
        Assert.notNull(glTransaction2.getRecognitionPeriod());

        GlTransaction glTransaction3 = createGlTransaction(transaction2);
        Assert.notNull(glTransaction3);
        Assert.notNull(glTransaction3.getId());
        Assert.notNull(glTransaction3.getStatus());
        Assert.notNull(glTransaction3.getRecognitionPeriod());

        Date startDate = dateFormat.parse("01/01/1970");
        Date endDate = dateFormat.parse("01/01/2020");

        String xml = reportService.generateGeneralLedgerReport(GL_ACCOUNT_ID, startDate, endDate);

        logger.debug("GL Report: \n" + xml);

        Assert.notNull(xml);
        Assert.hasText(xml);

    }

    @Test
    public void generateGeneralLedgerReport2() throws Exception {

        GlTransaction glTransaction1 = createGlTransaction(transaction1);
        Assert.notNull(glTransaction1);
        Assert.notNull(glTransaction1.getId());
        Assert.notNull(glTransaction1.getStatus());
        Assert.notNull(glTransaction1.getRecognitionPeriod());

        GlTransaction glTransaction2 = createGlTransaction(transaction2);
        Assert.notNull(glTransaction2);
        Assert.notNull(glTransaction2.getId());
        Assert.notNull(glTransaction2.getStatus());
        Assert.notNull(glTransaction2.getRecognitionPeriod());

        transactionService.makeEffective(transaction1.getId(), true);
        transactionService.makeEffective(transaction2.getId(), true);

        glService.prepareGlTransmissions();

        String xml = transactionExportService.exportTransactions();

        logger.debug("Transaction export: \n" + xml);

        Assert.notNull(xml);
        Assert.hasText(xml);

        Date startDate = dateFormat.parse("12/01/2010");
        Date endDate = dateFormat.parse("12/01/2015");

        xml = reportService.generateGeneralLedgerReport(GL_ACCOUNT_ID, startDate, endDate, true);

        logger.debug("GL Report: \n" + xml);

        Assert.notNull(xml);
        Assert.hasText(xml);

    }

    @Test
    public void generateAccountReport() throws Exception {

        Date startDate = dateFormat.parse("12/01/2010");
        Date endDate = dateFormat.parse("12/01/2015");

        String xml = reportService.generateAccountReport("admin", startDate, endDate, true, true, true, false);

        logger.debug("Account Report: \n" + xml);

        Assert.notNull(xml);
        Assert.hasText(xml);
    }

    @Test
    public void generateAgedBalanceReport() throws Exception {

        List<String> userIds = Arrays.asList("admin", "user1");

        String xml = reportService.generateAgedBalanceReport(userIds, false, true);

        logger.debug("Aged Balance Report: \n" + xml);

        Assert.notNull(xml);
        Assert.hasText(xml);
    }

    @Test
    public void generateRejectedTransactionsReport() throws Exception {

        Date startDate = dateFormat.parse("12/01/1987");
        Date endDate = dateFormat.parse("12/01/2020");

        String xml = reportService.generateRejectedTransactionsReport(startDate, endDate, false);

        logger.debug("Rejected Transactions Report: \n" + xml);

        Assert.notNull(xml);
        Assert.hasText(xml);

    }

    @Test
    public void generateTransactionReceipt() throws Exception {

        String xml = reportService.generateTransactionReceipt(transaction2.getId());

        logger.debug("Transaction Receipt: \n" + xml);

        Assert.notNull(xml);
        Assert.hasText(xml);

    }

    @Test
    public void generateIrs1098TReports() throws Exception {

        Date startDate = dateFormat.parse("01/01/2012");
        Date endDate = dateFormat.parse("12/31/2012");

        List<String> userIds = Arrays.asList("admin", "user1", "user2");

        for (boolean isTransient : Arrays.asList(true, false)) {

            for (String userId : userIds) {

                String createdXml = reportService.generate1098TReport(userId, startDate, endDate, 4, isTransient);

                logger.debug("IRS 1098T Report for user '" + userId + "' \n" + createdXml);

                Assert.notNull(createdXml);
                Assert.hasText(createdXml);

                if (!isTransient) {

                    String restoredXml = reportService.getIrs1098TReport(userId, startDate, endDate);

                    Assert.notNull(restoredXml);
                    Assert.hasText(restoredXml);

                    Assert.isTrue(createdXml.equals(restoredXml));
                }
            }
        }

    }

    @Test
    public void generateIrs1098TReportsByYear() throws Exception {

        final int year = 2011;

        List<String> userIds = Arrays.asList("admin", "user1", "user2");

        for (boolean isTransient : new boolean[]{true, false}) {

            for (String userId : userIds) {

                String createdXml = reportService.generate1098TReportByYear(userId, year, 4, isTransient);

                logger.debug("IRS 1098T Report for user '" + userId + "' \n" + createdXml);

                Assert.notNull(createdXml);
                Assert.hasText(createdXml);

                if (!isTransient) {

                    String restoredXml = reportService.getIrs1098TReportByYear(userId, year);

                    Assert.notNull(restoredXml);
                    Assert.hasText(restoredXml);

                    Assert.isTrue(createdXml.equals(restoredXml));
                }
            }
        }
    }

}