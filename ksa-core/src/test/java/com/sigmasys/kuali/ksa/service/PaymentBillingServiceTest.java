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


    private Account adminAccount;

    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        adminAccount = accountService.getOrCreateAccount(userId);
    }

    protected GeneralLedgerType createGeneralLedgerType() {

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

        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_US);

        Date openPeriodStartDate = dateFormat.parse("01/01/2011");
        Date openPeriodEndDate = dateFormat.parse("01/01/2020");

        Date chargePeriodStartDate = dateFormat.parse("01/01/2011");
        Date chargePeriodEndDate = dateFormat.parse("01/01/2020");


        GeneralLedgerType glType = createGeneralLedgerType();

        TransferType transferType = transferService.createTransferType(glType.getId(), "_TT_1", "TT 1", "Transfer Type 1");

        Assert.notNull(transferType);
        Assert.notNull(transferType.getId());

        /*
         Long transferTypeId,
            String flatFeeDebitTypeId,
            String variableFeeDebitTypeId,
            Date openPeriodStartDate,
            Date openPeriodEndDate,
            Date chargePeriodStartDate,
            Date chargePeriodEndDate,
            BigDecimal maxAmount,
            BigDecimal flatFeeAmount,
            BigDecimal variableFeeAmount,
            BigDecimal minFeeAmount,
            BigDecimal maxFeeAmount,
            int roundingFactor,
            boolean isGlCreationImmediate,
            String statementPrefix,
            PaymentRoundingType paymentRoundingType,
            ScheduleType scheduleType
         */

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

        Assert.isTrue(PaymentRoundingType.FIRST == plan.getPaymentRoundingType());
        Assert.isTrue(ScheduleType.SKIP_EARLIER == plan.getScheduleType());
        Assert.isTrue("1001".equals(plan.getFlatFeeDebitTypeId()));
        Assert.isTrue("1020".equals(plan.getVariableFeeDebitTypeId()));

        return plan;
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

    // TODO -> implement more JUnit tests

    /*
    @Test
    public void generateThirdPartyTransfers1() throws Exception {

        _createPaymentBillingPlan();

        List<ThirdPartyTransferDetail> transfers =
                billingService.generateThirdPartyTransfers(TEST_USER_ID, new Date(), true);

        Assert.notNull(transfers);
        Assert.notEmpty(transfers);

        for (ThirdPartyTransferDetail transfer : transfers) {

            Assert.notNull(transfer);
            Assert.notNull(transfer.getId());

            Assert.isTrue(transfer.getChargeStatus() == ThirdPartyChargeStatus.ACTIVE);
        }

    }

    @Test
    public void generateThirdPartyTransfers2() throws Exception {

        ThirdPartyPlan plan = _createPaymentBillingPlan();

        List<ThirdPartyTransferDetail> transfers =
                billingService.generateThirdPartyTransfers(plan.getId(), true);

        Assert.notNull(transfers);
        Assert.notEmpty(transfers);

        for (ThirdPartyTransferDetail transfer : transfers) {

            Assert.notNull(transfer);
            Assert.notNull(transfer.getId());

            Assert.isTrue(transfer.getChargeStatus() == ThirdPartyChargeStatus.ACTIVE);
        }

    }

    @Test
    public void generateThirdPartyTransfers3() throws Exception {

        ThirdPartyPlan plan = _createPaymentBillingPlan();

        List<ThirdPartyTransferDetail> transfers =
                billingService.generateThirdPartyTransfers(plan.getId(), false);

        Assert.notNull(transfers);
        Assert.notEmpty(transfers);

        transfers =
                billingService.generateThirdPartyTransfers(plan.getId(), true);

        Assert.notNull(transfers);
        Assert.notEmpty(transfers);

        for (ThirdPartyTransferDetail transfer : transfers) {

            Assert.notNull(transfer);
            Assert.notNull(transfer.getId());

            Assert.isTrue(transfer.getChargeStatus() == ThirdPartyChargeStatus.ACTIVE);
        }

    }

    @Test
    public void generateThirdPartyTransfers4() throws Exception {

        _createPaymentBillingPlan();

        List<ThirdPartyTransferDetail> transfers =
                billingService.generateThirdPartyTransfers(TEST_USER_ID);

        Assert.notNull(transfers);
        Assert.notEmpty(transfers);

        for (ThirdPartyTransferDetail transfer : transfers) {

            Assert.notNull(transfer);
            Assert.notNull(transfer.getId());

            Assert.isTrue(transfer.getChargeStatus() == ThirdPartyChargeStatus.ACTIVE);
        }

    }

    @Test
    public void reverseThirdPartyTransfers() throws Exception {

        ThirdPartyPlan plan = _createPaymentBillingPlan();

        ThirdPartyTransferDetail transfer =
                billingService.generateThirdPartyTransfer(plan.getId(), TEST_USER_ID, new Date());

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());

        transfer = billingService.reverseThirdPartyTransfer(transfer.getId(), "Reversed Memo");

        Assert.notNull(transfer);
        Assert.notNull(transfer.getId());
        Assert.notNull(transfer.getChargeStatus());

        Assert.isTrue(transfer.getChargeStatus() == ThirdPartyChargeStatus.REVERSED);

    }


    @Test
    public void createThirdPartyAllowableCharge() throws Exception {

        ThirdPartyPlan plan = _createPaymentBillingPlan();

        ThirdPartyAllowableCharge allowableCharge =
                billingService.createThirdPartyAllowableCharge(
                        plan.getId(),
                        ".*",
                        new BigDecimal(390.01),
                        new BigDecimal(55.5),
                        11,
                        ChargeDistributionPlan.DIVIDED);


        Assert.notNull(allowableCharge);
        Assert.notNull(allowableCharge.getId());
        Assert.notNull(allowableCharge.getDistributionPlan());

        Assert.isTrue(allowableCharge.getDistributionPlan() == ChargeDistributionPlan.DIVIDED);
        Assert.isTrue(".*".equals(allowableCharge.getTransactionTypeMask()));
        Assert.isTrue(allowableCharge.getPriority() == 11);
        Assert.isTrue(new BigDecimal(390.01).compareTo(allowableCharge.getMaxAmount()) == 0);
        Assert.isTrue(new BigDecimal(55.5).compareTo(allowableCharge.getMaxPercentage()) == 0);

    }
    */

}
