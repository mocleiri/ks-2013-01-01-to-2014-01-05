package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.pb.*;
import com.sigmasys.kuali.ksa.service.pb.PaymentBillingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * PaymentBillingService tests.
 *
 * @author Michael Ivanov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class PaymentBillingServiceTest extends AbstractServiceTest {

    @PersistenceContext(unitName = Constants.KSA_PERSISTENCE_UNIT)
    protected EntityManager em;

    @Autowired
    private PaymentBillingService billingService;

    @Autowired
    private TransactionTransferService transferService;

    @Autowired
    private GeneralLedgerService glService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;


    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        accountService.getOrCreateAccount(TEST_USER_ID);
    }

    private void _createCharge(String chargeTypeId) throws Exception {

        Transaction transaction = transactionService.createTransaction(chargeTypeId, TEST_USER_ID, new Date(),
                new BigDecimal(300));

        Assert.notNull(transaction);
        Assert.isTrue(transaction instanceof Charge);
        Assert.notNull(transaction.getId());
        Assert.notNull(transaction.getTransactionType());
        Assert.notNull(transaction.getAccount());
        Assert.notNull(transaction.getAccountId());
        Assert.notNull(transaction.getCurrency());

        Assert.isTrue("USD".equals(transaction.getCurrency().getCode()));
        Assert.isTrue(TEST_USER_ID.equals(transaction.getAccount().getId()));
        Assert.isTrue(new Date().compareTo(transaction.getEffectiveDate()) >= 0);
        Assert.isTrue(new BigDecimal(300).equals(transaction.getNativeAmount()));

    }

    protected GeneralLedgerType _createGeneralLedgerType() {

        String GL_ACCOUNT_ID = "01-0-131120 1326";

        GeneralLedgerType glType = glService.createGeneralLedgerType("GL_TYPE1", "Test GL type1",
                "Test GL Description 1", GL_ACCOUNT_ID, GlOperationType.CREDIT);

        Assert.notNull(glType);
        Assert.notNull(glType.getId());
        Assert.notNull(glType.getCode());
        Assert.notNull(glType.getName());
        Assert.notNull(glType.getDescription());
        Assert.notNull(glType.getGlAccountId());
        Assert.notNull(glType.getGlOperationOnCharge());
        Assert.notNull(glType.getCreationDate());
        Assert.notNull(glType.getCreatorId());

        Assert.isTrue(GlOperationType.CREDIT == glType.getGlOperationOnCharge());

        return glType;
    }


    protected PaymentBillingPlan _createPaymentBillingPlan() throws Exception {

        _createCharge("1020");
        _createCharge("1001");

        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_US);

        Date openPeriodStartDate = dateFormat.parse("01/01/2011");
        Date openPeriodEndDate = dateFormat.parse("01/01/2020");

        Date chargePeriodStartDate = dateFormat.parse("01/01/2011");
        Date chargePeriodEndDate = dateFormat.parse("01/01/2020");

        GeneralLedgerType glType = _createGeneralLedgerType();

        TransferType transferType = transferService.createTransferType(glType.getId(), "_TT_1", "TT 1", "Transfer Type 1");

        Assert.notNull(transferType);
        Assert.notNull(transferType.getId());

        PaymentBillingPlan plan = billingService.createPaymentBillingPlan(
                "PB code1",
                "PB name 1",
                "PB description 1",
                transferType.getId(),
                "1001",
                "1020",
                openPeriodStartDate,
                openPeriodEndDate,
                chargePeriodStartDate,
                chargePeriodEndDate,
                new BigDecimal(10e7),
                new BigDecimal(3570.99),
                new BigDecimal(400.00),
                new BigDecimal(1),
                new BigDecimal(3700.99),
                1,
                true,
                "PB plan prefix",
                PaymentRoundingType.FIRST,
                ScheduleType.SKIP_EARLIER);

        Assert.notNull(plan);
        Assert.notNull(plan.getId());
        Assert.notNull(plan.getTransferType());
        Assert.notNull(plan.getFlatFeeAmount());
        Assert.notNull(plan.getVariableFeeAmount());

        Assert.isTrue(plan.getFlatFeeAmount().compareTo(BigDecimal.ZERO) > 0);
        Assert.isTrue(plan.getVariableFeeAmount().compareTo(BigDecimal.ZERO) > 0);
        Assert.isTrue(PaymentRoundingType.FIRST == plan.getPaymentRoundingType());
        Assert.isTrue(ScheduleType.SKIP_EARLIER == plan.getScheduleType());
        Assert.isTrue("1001".equals(plan.getFlatFeeDebitTypeId()));
        Assert.isTrue("1020".equals(plan.getVariableFeeDebitTypeId()));

        _createPaymentBillingAllowableCharge(plan.getId());

        return plan;
    }


    private PaymentBillingAllowableCharge _createPaymentBillingAllowableCharge(Long paymentBillingPlanId) {

        PaymentBillingAllowableCharge allowableCharge = billingService.createPaymentBillingAllowableCharge(
                paymentBillingPlanId,
                ".*",
                new BigDecimal(1450),
                new BigDecimal(100),
                1);

        Assert.notNull(allowableCharge);
        Assert.notNull(allowableCharge.getId());
        Assert.notNull(allowableCharge.getPlan());

        Assert.isTrue(".*".equals(allowableCharge.getTransactionTypeMask()));
        Assert.isTrue(new BigDecimal(1450).compareTo(allowableCharge.getMaxAmount()) == 0);
        Assert.isTrue(new BigDecimal(100).compareTo(allowableCharge.getMaxPercentage()) == 0);
        Assert.isTrue(1 == allowableCharge.getPriority());

        return allowableCharge;
    }

    private PaymentBillingQueue _createPaymentBillingQueue(Long paymentBillingPlanId) {

        PaymentBillingQueue billingQueue = billingService.createPaymentBillingQueue(paymentBillingPlanId,
                TEST_USER_ID,
                new BigDecimal(240.09),
                new Date(),
                true);

        Assert.notNull(billingQueue);
        Assert.notNull(billingQueue.getId());
        Assert.notNull(billingQueue.getDirectChargeAccount());
        Assert.notNull(billingQueue.getCreatorId());
        Assert.notNull(billingQueue.getCreationDate());
        Assert.notNull(billingQueue.getInitiationDate());
        Assert.notNull(billingQueue.getPlan());

        return billingQueue;
    }

    @Test
    public void createPaymentBillingPlan() throws Exception {
        _createPaymentBillingPlan();
    }

    @Test
    public void generatePaymentBillingTransfer() throws Exception {

        PaymentBillingPlan plan = _createPaymentBillingPlan();

        PaymentBillingTransferDetail transfer =
                billingService.generatePaymentBillingTransfer(plan.getId(), TEST_USER_ID, new BigDecimal(2300), new Date());

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.INITIALIZED);
    }

    @Test
    public void executePaymentBilling() throws Exception {

        PaymentBillingPlan plan = _createPaymentBillingPlan();

        PaymentBillingTransferDetail transferDetail =
                billingService.executePaymentBilling(plan.getId(), TEST_USER_ID, new BigDecimal(10e3), new Date());

        Assert.notNull(transferDetail);
        Assert.notNull(transferDetail.getId());
        Assert.notNull(transferDetail.getDirectChargeAccount());
        Assert.notNull(transferDetail.getPlan());

        Assert.notNull(transferDetail.getFlatFeeCharge());
        Assert.notNull(transferDetail.getVariableFeeCharge());

        List<PaymentBillingTransaction> billingTransactions =
                billingService.getPaymentBillingTransactionsByTransferDetailId(transferDetail.getId());

        Assert.notNull(billingTransactions);
        Assert.notEmpty(billingTransactions);

        for (PaymentBillingTransaction billingTransaction : billingTransactions) {

            Assert.notNull(billingTransaction);
            Assert.notNull(billingTransaction.getId());
            Assert.notNull(billingTransaction.getTransferDetail());
            Assert.notNull(billingTransaction.getCharge());
        }

    }

    @Test
    public void reversePaymentBillingTransfer() throws Exception {

        PaymentBillingPlan plan = _createPaymentBillingPlan();

        PaymentBillingTransferDetail transfer =
                billingService.generatePaymentBillingTransfer(plan.getId(), TEST_USER_ID, new BigDecimal(1300), new Date());

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.INITIALIZED);

        transfer = billingService.transferPaymentBillingTransactions(transfer.getId());

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.ACTIVE);

        transfer = billingService.reversePaymentBillingTransfer(transfer.getId(), "Reversed Memo", true);

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());
        Assert.notNull(transfer.getChargeStatus());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.REVERSED);

    }

    @Test
    public void generatePaymentBillingSchedules() throws Exception {

        PaymentBillingPlan plan = _createPaymentBillingPlan();

        PaymentBillingTransferDetail transfer =
                billingService.generatePaymentBillingTransfer(plan.getId(), TEST_USER_ID, new BigDecimal(2300), new Date());

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.INITIALIZED);

        Rollup rollup = new Rollup();
        rollup.setCode("Rollup 1 code");
        rollup.setName("Rollup 1 name");
        rollup.setDescription("Rollup 1 description");

        em.persist(rollup);

        billingService.createPaymentBillingDate(plan.getId(), rollup.getId(), new BigDecimal(30),
                new Date(System.currentTimeMillis() + System.currentTimeMillis()));

        List<PaymentBillingTransaction> billingTransactions =
                billingService.generatePaymentBillingTransactions(transfer.getId());

        Assert.notNull(billingTransactions);
        Assert.notEmpty(billingTransactions);

        List<PaymentBillingSchedule> billingSchedules = billingService.generatePaymentBillingSchedules(transfer.getId());

        Assert.notNull(billingSchedules);
        Assert.notEmpty(billingSchedules);

        for (PaymentBillingSchedule schedule : billingSchedules) {

            Assert.notNull(schedule);
            Assert.notNull(schedule.getId());
            Assert.notNull(schedule.getAmount());
            Assert.notNull(schedule.getTransferDetail());
            Assert.notNull(schedule.getPercentage());
            Assert.notNull(schedule.getEffectiveDate());
        }

    }

    @Test
    public void processPaymentBillingQueues() throws Exception {

        PaymentBillingPlan plan = _createPaymentBillingPlan();

        PaymentBillingTransferDetail transfer =
                billingService.generatePaymentBillingTransfer(plan.getId(), TEST_USER_ID, new BigDecimal(100), new Date());

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.INITIALIZED);

        transfer = billingService.transferPaymentBillingTransactions(transfer.getId());

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.ACTIVE);

        transfer = billingService.reversePaymentBillingTransfer(transfer.getId(), "Reversed Transfer", true);

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.REVERSED);

        _createPaymentBillingQueue(plan.getId());

        billingService.processPaymentBillingQueues(TEST_USER_ID);

    }

    @Test
    public void processPaymentBillingQueuesByCreator() throws Exception {

        PaymentBillingPlan plan = _createPaymentBillingPlan();

        PaymentBillingTransferDetail transfer =
                billingService.generatePaymentBillingTransfer(plan.getId(), TEST_USER_ID, new BigDecimal(700.22), new Date());

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.INITIALIZED);

        transfer = billingService.transferPaymentBillingTransactions(transfer.getId());

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        Assert.isTrue(transfer.getChargeStatus() == PaymentBillingChargeStatus.ACTIVE);

        _createPaymentBillingQueue(plan.getId());

        billingService.processPaymentBillingQueuesByCreator(TEST_USER_ID);

    }

}
