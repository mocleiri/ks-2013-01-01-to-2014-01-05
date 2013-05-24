package com.sigmasys.kuali.ksa.service;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.isNull;
import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.fm.KeyPair;
import com.sigmasys.kuali.ksa.model.fm.LearningPeriod;
import com.sigmasys.kuali.ksa.model.fm.LearningUnit;
import com.sigmasys.kuali.ksa.model.fm.PeriodKeyPair;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
@Transactional(readOnly = false)
public class FeeManagementServiceTest extends AbstractServiceTest {

    @PersistenceContext(unitName = Constants.KSA_PERSISTENCE_UNIT)
    protected EntityManager em;

    @Autowired
    private FeeManagementService feeManagementService;

    @Autowired
    private AccountService accountService;

    // Test objects
    private String accountId = "admin1";
    private Account testAccount;

    private FeeType testFeeType;
    private SimpleDateFormat dateFormat;

    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        accountService.getOrCreateAccount(userId);
        dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_US);
        testFeeType = createFeeType();
    }


    private FeeType createFeeType() {

        String feeTypeCode = "FeeType_1";
        String feeTypeName = "Fee Type 1 Name";
        String feeTypeDesc = "Test Fee Type 1";

        FeeType feeType = feeManagementService.createFeeType(feeTypeCode, feeTypeName, feeTypeDesc);

        Assert.notNull(feeType);
        Assert.notNull(feeType.getId());
        Assert.isTrue(feeTypeCode.equals(feeType.getCode()));
        Assert.isTrue(feeTypeName.equals(feeType.getName()));
        Assert.isTrue(feeTypeDesc.equals(feeType.getDescription()));

        return feeType;
    }


    private FeeDetail createFeeDetail(String code, Date startDate, Date endDate) {

        final Random random = new Random();

        int listSize = random.nextInt(100) + 1;

        ArrayList<FeeDetailAmount> feeDetailAmounts = new ArrayList<FeeDetailAmount>(listSize);
        for (int i = 0; i < listSize; i++) {
            FeeDetailAmount feeDetailAmount = new FeeDetailAmount();
            feeDetailAmount.setId(1L);
            feeDetailAmount.setFeeDetail(new FeeDetail());
            feeDetailAmount.setCode(11);
            feeDetailAmount.setSubCode(new Random().nextInt(50));
            feeDetailAmount.setAmount(new BigDecimal(random.nextDouble()));
            feeDetailAmounts.add(feeDetailAmount);
        }

        FeeDetail feeDetail = feeManagementService.createFeeDetail(testFeeType.getCode(), code, code + ":name",
                code + ":description", startDate, endDate, "1020", new BigDecimal(45000.567), new Date(), new Date(),
                FeeDetailDateType.ALWAYS, FeeDetailAmountType.FLAT, feeDetailAmounts);

        Assert.notNull(feeDetail);
        Assert.notNull(feeDetail.getId());
        Assert.notNull(feeDetail.getFeeType());
        Assert.notNull(feeDetail.getAmountType());
        Assert.notNull(feeDetail.getDateType());

        Set<FeeDetailAmount> amounts = feeDetail.getAmounts();

        Assert.notNull(amounts);
        Assert.notEmpty(amounts);

        for (FeeDetailAmount amount : amounts) {
            Assert.notNull(amount);
            Assert.notNull(amount.getId());
            Assert.notNull(amount.getCode());
            Assert.notNull(amount.getSubCode());
        }

        return feeDetail;
    }

    @Test
    public void createFeeDetail() throws Exception {

        String feeCode = "FeeDetail_1";
        String startDate = "01/23/2012";
        String endDate = "01/23/2013";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));
    }

    @Test
    public void createFeeDetails1() throws Exception {

        String feeCode = "FeeDetail_1";
        String startDate = "01/23/2012";
        String endDate = "01/23/2013";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));

        feeCode = "FeeDetail_2";
        startDate = "02/23/2012";
        endDate = "12/23/2012";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));
    }

    @Test
    public void createFeeDetails2() throws Exception {

        String feeCode = "FeeDetail_2";
        String startDate = "01/01/2012";
        String endDate = "01/23/2013";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));

        feeCode = "FeeDetail_2";
        startDate = "02/15/2012";
        endDate = "12/23/2012";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));

        feeCode = "FeeDetail_2";
        startDate = "02/10/2012";
        endDate = "11/03/2012";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));
    }

    @Test
    public void createFeeDetails3() throws Exception {

        String feeCode = "FeeDetail_3";
        String startDate = "01/01/2012";
        String endDate = "01/23/2013";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));

        feeCode = "FeeDetail_3";
        startDate = "01/01/2012";
        endDate = "12/23/2012";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));

        feeCode = "FeeDetail_3";
        startDate = "02/10/2012";
        endDate = "01/23/2013";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));
    }

    @Test
    public void createFeeDetails4() throws Exception {

        String feeCode = "FeeDetail_4";
        String startDate = "01/23/2012";
        String endDate = "01/23/2013";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));

        feeCode = "FeeDetail_4";
        startDate = "01/23/2012";
        endDate = "01/23/2013";

        createFeeDetail(feeCode, dateFormat.parse(startDate), dateFormat.parse(endDate));
    }

    @Test
    public void getFeeDetail() throws Exception {

        String feeCode = "MT23";

        String date = "01/23/2013";

        FeeDetail feeDetail = feeManagementService.getFeeDetail(feeCode, dateFormat.parse(date));

        feeDetail = feeManagementService.getFeeDetail(feeCode, null);

        // TODO: provide assertions

    }


    @Test
    public void testKeyPairPreviousValue() throws Exception {
        // Create a new KeyPair:
        KeyPair kp = new KeyPair();
        String name = "name";
        String value = "value";
        String newValue = "new value";

        kp.setName(name);
        kp.setValue(value);

        // Assert validity:
        assertEquals(name, kp.getName());
        assertEquals(value, kp.getValue());
        isNull(kp.getPreviousValue());

        // Set a new value:
        kp.setValue(newValue);

        // Make more assertions:
        assertEquals(name, kp.getName());
        assertEquals(newValue, kp.getValue());
        assertEquals(value, kp.getPreviousValue());
    }

    @Test
    public void testGetStudentDataNoDataExists() throws Exception {
        // Get the student data:
        List<KeyPair> studentDataFromService = feeManagementService.getStudentData(accountId);

        notNull(studentDataFromService);
        isTrue(studentDataFromService.isEmpty());
    }

    @Test
    public void testGetStudentDataDataPersistedWithEM() throws Exception {
        // Create and persist new Student Data:
        List<KeyPair> testStudentData = createTestStudentData();

        // If creation of the test data failed, so be it, nothing to test:
        if (testStudentData == null) {
            return;
        }

        // Get student data for the test account:
        List<KeyPair> studentDataFromService = feeManagementService.getStudentData(accountId);

        // Validate the result:
        assertKeyPairs(testStudentData, studentDataFromService);
    }

    @Test
    public void testGetLearningPeriodDataNoDataExists() throws Exception {
        // Get the learning period data:
        List<PeriodKeyPair> periodDataFromService = feeManagementService.getLearningPeriodData(accountId);

        notNull(periodDataFromService);
        isTrue(periodDataFromService.isEmpty());
    }

    @Test
    public void testGetLearningPeriodDataDataPersistedWithEM() throws Exception {
        // Create and persist Period data:
        List<PeriodKeyPair> testPeriodData = createTestPeriodData();

        // If creation of the test data failed, so be it, nothing to test:
        if (testPeriodData == null) {
            return;
        }

        // Get the learning period data:
        List<PeriodKeyPair> periodDataFromService = feeManagementService.getLearningPeriodData(accountId);

        // Validate the result:
        assertKeyPairs(testPeriodData, periodDataFromService);
    }

    @Test
    public void testGetStudyNoDataExists() throws Exception {
        // Get the study data:
        List<LearningUnit> studyFromService = feeManagementService.getLearningUnits(accountId);

        notNull(studyFromService);
        isTrue(studyFromService.isEmpty());
    }

    @Test
    public void testGetStudyDataPersistedWithEM() throws Exception {
        // Create and persist the study data:
        List<LearningUnit> testStudy = createTestStudy();

        // If creation of the test data failed, so be it, nothing to test:
        if (testStudy == null) {
            return;
        }

        // Get the study data:
        List<LearningUnit> studyFromService = feeManagementService.getLearningUnits(accountId);

        // Validate the result:
        assertStudy(testStudy, studyFromService);
    }

    @Test
    public void testGetFeeBaseNoDataExists() throws Exception {
        // Create an account:
        testAccount = accountService.getOrCreateAccount(accountId);

        // Get a FeeBase from the service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Validate the result:
        notNull(feeBaseFromService);
        notNull(feeBaseFromService.getStudentData());
        isTrue(feeBaseFromService.getStudentData().isEmpty());
        notNull(feeBaseFromService.getPeriodData());
        isTrue(feeBaseFromService.getPeriodData().isEmpty());
        notNull(feeBaseFromService.getLearningUnits());
        isTrue(feeBaseFromService.getLearningUnits().isEmpty());
        notNull(feeBaseFromService.getAccount());
        assertAccount(testAccount, feeBaseFromService.getAccount());
    }

    @Test
    public void testGetFeeBaseDataPersistedWithEM() throws Exception {
        // Create a test FeeBase:
        FeeBase testFeeBase = createTestFeeBase();

        // If creation of a new FeeBase failed, nothing to test, something just went wrong:
        if (testFeeBase == null) {
            return;
        }

        // Get the FeeBase from the service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Validate the result:
        assertFeeBase(testFeeBase, feeBaseFromService);
    }

    @Test
    public void testCalcluateChargeByCreditToMaxNegativeMax() throws Exception {
        int numOfCredits = 5;
        BigDecimal amountPerCredit = new BigDecimal(250.5);
        BigDecimal maxAmount = new BigDecimal(-100.5);
        BigDecimal charge = feeManagementService.calculateChargeByCreditToMax(numOfCredits, amountPerCredit, maxAmount);

        assertEquals(1252.5, charge.doubleValue(), 0.0);
    }

    @Test
    public void testCalcluateChargeByCreditToMaxPositiveMaxGreaterThanTotal() throws Exception {
        int numOfCredits = 5;
        BigDecimal amountPerCredit = new BigDecimal(250.5);
        BigDecimal maxAmount = new BigDecimal(2000.5);
        BigDecimal charge = feeManagementService.calculateChargeByCreditToMax(numOfCredits, amountPerCredit, maxAmount);

        assertEquals(1252.5, charge.doubleValue(), 0.0);
    }

    @Test
    public void testCalcluateChargeByCreditToMaxPositiveMaxLessThanTotal() throws Exception {
        int numOfCredits = 5;
        BigDecimal amountPerCredit = new BigDecimal(250.5);
        BigDecimal maxAmount = new BigDecimal(200.5);
        BigDecimal charge = feeManagementService.calculateChargeByCreditToMax(numOfCredits, amountPerCredit, maxAmount);

        assertEquals(200.5, charge.doubleValue(), 0.0);
    }

    @Test
    public void testCalcluateChargeByCreditToMaxZeroMax() throws Exception {
        int numOfCredits = 5;
        BigDecimal amountPerCredit = new BigDecimal(250.5);
        BigDecimal maxAmount = new BigDecimal(0d);
        BigDecimal charge = feeManagementService.calculateChargeByCreditToMax(numOfCredits, amountPerCredit, maxAmount);

        assertEquals(0, charge.doubleValue(), 0.0);
    }

    @Test
    public void testCreateKeyPairWithNewName() throws Exception {

        // Test objects:
        createTestFeeBase();
        String name = "absolutely new name";
        String value = "absolutely new value";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        KeyPair newKeyPair = feeManagementService.createKeyPair(feeBaseFromService, name, value);

        // Validate the result:
        notNull(newKeyPair);
        assertEquals(name, newKeyPair.getName());
        assertEquals(value, newKeyPair.getValue());
        isNull(newKeyPair.getPreviousValue());

        // Get a fresh FeeBase from Service again:
        FeeBase freshFeeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Validate the new KeyPair is in the FeeBase now:
        assertFeeBase(feeBaseFromService, freshFeeBaseFromService);
    }

    @Test
    public void testCreateKeyPairWithExistingName() throws Exception {
        // Test objects:
        FeeBase testFeeBase = createTestFeeBase();
        String nameThatHasAlreadyBeenUsed = "boo";
        String value = "absolutely new value";

        // Make sure an exception is thrown because the name already exists:
        boolean exceptionRaised = false;

        try {
            // Call the service:
            feeManagementService.createKeyPair(testFeeBase, nameThatHasAlreadyBeenUsed, value);

            // We should not be here:
            isTrue(false, "An error should have occurred because a KeyPair name already exists, but it DID'T.");
        } catch (Exception e) {
            exceptionRaised = true;
        }

        // Assert an exception has been raised:
        isTrue(exceptionRaised, "An error should have occurred because a KeyPair name already exists, but it DID'T.");
    }

    @Test
    public void testCreateKeyPairWithInvalidParameters() throws Exception {
        // Null FeeBase:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.createKeyPair(nullFeeBase, "new name", "New value");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.createKeyPair(testFeeBase, null, "New value");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null value:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.createKeyPair(testFeeBase, "New name", null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null Everything:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.createKeyPair(nullFeeBase, null, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testCreatePeriodKeyPairWithNewName() throws Exception {
        // Test objects:
        FeeBase testFeeBase = createTestFeeBase();
        String name = "absolutely new name";
        String value = "absolutely new value";
        LearningPeriod period = testFeeBase.getPeriodData().get(0).getLearningPeriod();

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        PeriodKeyPair newKeyPair = feeManagementService.createKeyPair(feeBaseFromService, name, value, period);

        // Validate the result:
        notNull(newKeyPair);
        assertEquals(name, newKeyPair.getName());
        assertEquals(value, newKeyPair.getValue());
        isNull(newKeyPair.getPreviousValue());
        assertLearningPeriod(period, newKeyPair.getLearningPeriod());

        // Get a fresh FeeBase from service:
        FeeBase freshFeeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Validate the new KeyPair is in the FeeBase now:
        assertFeeBase(feeBaseFromService, freshFeeBaseFromService);
    }

    @Test
    public void testCreatePeriodKeyPairWithExistingName() throws Exception {
        // Test objects:
        FeeBase testFeeBase = createTestFeeBase();
        String nameThatHasAlreadyBeenUsed = "boo1";
        String value = "absolutely new value";
        LearningPeriod period = testFeeBase.getPeriodData().get(0).getLearningPeriod();

        // Make sure an exception is thrown because the name already exists:
        boolean exceptionRaised = false;

        try {
            // Call the service:
            feeManagementService.createKeyPair(testFeeBase, nameThatHasAlreadyBeenUsed, value, period);

            // We should not be here:
            isTrue(false, "An error should have occurred because a PeriodKeyPair name already exists, but it DID'T.");
        } catch (Exception e) {
            exceptionRaised = true;
        }

        // Assert an exception has been raised:
        isTrue(exceptionRaised, "An error should have occurred because a PeriodKeyPair name already exists, but it DID'T.");
    }

    @Test
    public void testCreatePeriodKeyPairWithInvalidParameters() throws Exception {
        // Null FeeBase:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.createKeyPair(nullFeeBase, "new name", "New value", new LearningPeriod());
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.createKeyPair(testFeeBase, null, "New value", new LearningPeriod());
            isTrue(false);
        } catch (Exception e) {
        }

        // Null value:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.createKeyPair(testFeeBase, "New name", null, new LearningPeriod());
            isTrue(false);
        } catch (Exception e) {
        }

        // Null period:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.createKeyPair(testFeeBase, "New name", "new value", null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null Everything:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.createKeyPair(nullFeeBase, null, null, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testCreateLearningUnitKeyPairWithNewName() throws Exception {
        // Test objects:
        createTestFeeBase();
        String name = "absolutely new name";
        String value = "absolutely new value";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit testLearningUnit = feeBaseFromService.getLearningUnits().get(0);

        // Call the service:
        KeyPair newKeyPair = feeManagementService.setKeyPair(testLearningUnit, name, value);

        // Validate the result:
        notNull(newKeyPair);
        assertEquals(name, newKeyPair.getName());
        assertEquals(value, newKeyPair.getValue());
        isNull(newKeyPair.getPreviousValue());

        // Get a fresh FeeBase from service:
        FeeBase freshFeeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Validate the new KeyPair is in the FeeBase now:
        assertFeeBase(feeBaseFromService, freshFeeBaseFromService);
    }

    @Test
    public void testCreateLearningUnitKeyPairWithExistingName() throws Exception {
        // Test objects:
        FeeBase testFeeBase = createTestFeeBase();
        LearningUnit testLearningUnit = testFeeBase.getLearningUnits().get(0);
        String nameThatHasAlreadyBeenUsed = "boo";
        String value = "absolutely new value";

        // Make sure an exception is thrown because the name already exists:
        boolean exceptionRaised = false;

        try {
            // Call the service:
            feeManagementService.setKeyPair(testLearningUnit, nameThatHasAlreadyBeenUsed, value);

            // We should not be here:
            isTrue(false, "An error should have occurred because a KeyPair name already exists, but it DID'T.");
        } catch (Exception e) {
            exceptionRaised = true;
        }

        // Assert an exception has been raised:
        isTrue(exceptionRaised, "An error should have occurred because a KeyPair name already exists, but it DID'T.");
    }

    @Test
    public void testCreateKeyLearningUnitPairWithInvalidParameters() throws Exception {
        // Null LearningUnit:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.setKeyPair(nullLearningUnit, "new name", "New value");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            feeManagementService.setKeyPair(new LearningUnit(), null, "New value");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null value:
        try {
            feeManagementService.setKeyPair(new LearningUnit(), "new name", null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null everything:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.setKeyPair(nullLearningUnit, null, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testGetKeyPairValueExistingName() throws Exception {
        // Test Objects:
        createTestFeeBase();
        String existingKeyPairName = "boo";
        String existingKeyPairValue = "foo";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        String kpValueFromService = feeManagementService.getKeyPairValue(feeBaseFromService, existingKeyPairName);

        // Validate:
        assertEquals(existingKeyPairValue, kpValueFromService);
    }

    @Test
    public void testGetKeyPairValueNonExistingName() throws Exception {
        // Test Objects:
        createTestFeeBase();
        String nonExistingKeyPairName = "lalala-1";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        String kpValueFromService = feeManagementService.getKeyPairValue(feeBaseFromService, nonExistingKeyPairName);

        // Validate:
        isNull(kpValueFromService);
    }

    @Test
    public void testGetKeyPairValueWithInvalidParameters() throws Exception {
        // Null FeeBase:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.getKeyPairValue(nullFeeBase, "new name");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.getKeyPairValue(testFeeBase, null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null Everything:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.getKeyPairValue(nullFeeBase, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testGetPeriodKeyPairValueExistingName() throws Exception {
        // Test Objects:
        createTestFeeBase();
        String existingKeyPairName = "boo1";
        String existingKeyPairValue = "foo1";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        String kpValueFromService = feeManagementService.getKeyPairValue(feeBaseFromService, existingKeyPairName);

        // Validate:
        assertEquals(existingKeyPairValue, kpValueFromService);
    }

    @Test
    public void testGetLearningUnitKeyPairValueExistingName() throws Exception {
        // Test Objects:
        createTestFeeBase();
        String existingKeyPairName = "boo";
        String existingKeyPairValue = "foo";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Call the service:
        String kpValueFromService = feeManagementService.getKeyPairValue(luFromService, existingKeyPairName);

        // Validate:
        assertEquals(existingKeyPairValue, kpValueFromService);
    }

    @Test
    public void testGetLearningUnitKeyPairValueNonExistingName() throws Exception {
        // Test Objects:
        createTestFeeBase();
        String nonExistingKeyPairName = "lalala-1";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Call the service:
        String kpValueFromService = feeManagementService.getKeyPairValue(luFromService, nonExistingKeyPairName);

        // Validate:
        isNull(kpValueFromService);
    }

    @Test
    public void testGetLearningUnitKeyPairValueWithInvalidParameters() throws Exception {
        // Null LearningUnit:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.getKeyPairValue(nullLearningUnit, "new name");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            feeManagementService.getKeyPairValue(new LearningUnit(), null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null everything:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.getKeyPairValue(nullLearningUnit, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testRemoveKeyPairExistingName() {
        // Test objects:
        createTestFeeBase();
        String name = "boo";

        // Get the FeeBase from the service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        feeManagementService.removeKeyPair(feeBaseFromService, name);

        // Validate:
        boolean hasBeenRemoved = !feeManagementService.containsKeyPair(feeBaseFromService, name);

        isTrue(hasBeenRemoved);

        // Select from service again:
        feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Revalidate:
        hasBeenRemoved = !feeManagementService.containsKeyPair(feeBaseFromService, name);

        isTrue(hasBeenRemoved);
    }

    @Test
    public void testRemoveKeyPairNonExistingName() {
        // Test objects:
        FeeBase testFeeBase = createTestFeeBase();
        String name = "something different";

        // Get the FeeBase from the service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        feeManagementService.removeKeyPair(feeBaseFromService, name);

        // Validate:
        assertFeeBase(testFeeBase, feeBaseFromService);
    }

    @Test
    public void testRemovePeriodKeyPairExistingName() {
        // Test objects:
        createTestFeeBase();
        String name = "boo1";

        // Get the FeeBase from the service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        feeManagementService.removeKeyPair(feeBaseFromService, name);

        // Validate:
        boolean hasBeenRemoved = !feeManagementService.containsKeyPair(feeBaseFromService, name);

        isTrue(hasBeenRemoved);

        // Select from service again:
        feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Revalidate:
        hasBeenRemoved = !feeManagementService.containsKeyPair(feeBaseFromService, name);

        isTrue(hasBeenRemoved);
    }

    @Test
    public void testRemoveKeyPairWithInvalidParameters() {
        // Null FeeBase:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.removeKeyPair(nullFeeBase, "new name");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.removeKeyPair(testFeeBase, null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null Everything:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.removeKeyPair(nullFeeBase, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testRemoveLearningUnitKeyPairExistingName() {
        // Test Objects:
        createTestFeeBase();
        String existingKeyPairName = "boo";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Call the service:
        feeManagementService.removeKeyPair(luFromService, existingKeyPairName);

        // Validate:
        boolean hasBeenRemoved = !feeManagementService.containsKeyPair(luFromService, existingKeyPairName);

        isTrue(hasBeenRemoved);
    }

    @Test
    public void testRemoveLearningUnitKeyPairNonExistingName() {
        // Test Objects:
        FeeBase testFeeBase = createTestFeeBase();
        String existingKeyPairName = "boo";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Call the service:
        feeManagementService.removeKeyPair(luFromService, existingKeyPairName);

        // Validate:
        assertStudy(testFeeBase.getLearningUnits(), feeBaseFromService.getLearningUnits());
    }

    @Test
    public void testRemoveLearningUnitKeyPairWithInvalidParameters() {
        // Null LearningUnit:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.removeKeyPair(nullLearningUnit, "new name");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            feeManagementService.removeKeyPair(new LearningUnit(), null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null everything:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.removeKeyPair(nullLearningUnit, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testUpdateKeyPairExistingName() {
        // Test objects:
        createTestFeeBase();
        String name = "boo";
        String currentValue = "foo";
        String newValue = "new foo";

        // Get the FeeBase from the service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Assert the value is still the same:
        assertEquals(currentValue, feeManagementService.getKeyPairValue(feeBaseFromService, name));

        // Call the service:
        feeManagementService.updateKeyPair(feeBaseFromService, name, newValue);

        // Validate:
        assertEquals(newValue, feeManagementService.getKeyPairValue(feeBaseFromService, name));

        // Select from service again:
        feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Re-validate:
        assertEquals(newValue, feeManagementService.getKeyPairValue(feeBaseFromService, name));
    }

    @Test
    public void testUpdateKeyPairNonExistingName() {
        // Test objects:
        FeeBase testFeeBase = createTestFeeBase();
        String nonExistingName = "boo-hoo";
        String newValue = "new foo value";

        // Get the FeeBase from the service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        try {
            feeManagementService.updateKeyPair(feeBaseFromService, nonExistingName, newValue);
        } catch (Throwable t) {
            // Make sure we never get here:
            isTrue(false, "An exception should not have been raised");
        }

        // Validate:
        assertFeeBase(testFeeBase, feeBaseFromService);

        // Get a fresh FeeBase from service:
        FeeBase freshFeeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Validate the FeeBase:
        assertFeeBase(testFeeBase, freshFeeBaseFromService);
    }

    @Test
    public void testUpdateKeyPairWithInvalidParameters() {
        // Null FeeBase:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.updateKeyPair(nullFeeBase, "new name", "New value");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.updateKeyPair(testFeeBase, null, "New value");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null value:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.updateKeyPair(testFeeBase, "New name", null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null Everything:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.updateKeyPair(nullFeeBase, null, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testUpdatePeriodKeyPairExistingName() {
        // Test objects:
        FeeBase testFeeBase = createTestFeeBase();
        String name = "boo1";
        String currentValue = "foo1";
        String newValue = "new foo1";
        LearningPeriod newPeriod = new LearningPeriod();
        Calendar calFrom = Calendar.getInstance();
        Calendar calTo = Calendar.getInstance();
        int newYearFrom = 1999;
        int newYearTo = 2001;

        calFrom.set(Calendar.YEAR, newYearFrom);
        calTo.set(Calendar.YEAR, newYearTo);
        newPeriod.setStartDate(calFrom.getTime());
        newPeriod.setEndDate(calTo.getTime());

        // Find the original PeriodKeyPair being updated:
        PeriodKeyPair originalPkp = null;

        for (PeriodKeyPair pkp : testFeeBase.getPeriodData()) {
            if (StringUtils.equalsIgnoreCase(pkp.getName(), name)) {
                originalPkp = pkp;
                break;
            }
        }

        // Get the FeeBase from the service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Assert the value is still the same:
        assertEquals(currentValue, feeManagementService.getKeyPairValue(feeBaseFromService, name));

        // Assert original years are different from what we're going to change them to:
        Calendar calOriginalFrom = Calendar.getInstance();
        Calendar calOriginalTo = Calendar.getInstance();

        calOriginalFrom.setTime(originalPkp.getLearningPeriod().getStartDate());
        calOriginalTo.setTime(originalPkp.getLearningPeriod().getEndDate());
        isTrue(calOriginalFrom.get(Calendar.YEAR) != newYearFrom);
        isTrue(calOriginalTo.get(Calendar.YEAR) != newYearTo);

        // Call the service:
        feeManagementService.updateKeyPair(feeBaseFromService, name, newValue, newPeriod);

        // Validate:
        assertEquals(newValue, feeManagementService.getKeyPairValue(feeBaseFromService, name));

        // Find the PeriodKeyPair that has been updated:
        PeriodKeyPair updatedPkp = null;

        for (PeriodKeyPair pkp : testFeeBase.getPeriodData()) {
            if (StringUtils.equalsIgnoreCase(pkp.getName(), name)) {
                updatedPkp = pkp;
                break;
            }
        }

        // Validate:
        isTrue(DateUtils.isSameDay(calFrom.getTime(), updatedPkp.getLearningPeriod().getStartDate()));
        isTrue(DateUtils.isSameDay(calTo.getTime(), updatedPkp.getLearningPeriod().getEndDate()));
    }

    @Test
    public void testUpdatePeriodKeyPairNonExistingName() {
        // Test objects:
        FeeBase testFeeBase = createTestFeeBase();
        String nonExistingName = "boo-hoo";
        String newValue = "new foo value";

        // Get the FeeBase from the service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Call the service:
        try {
            feeManagementService.updateKeyPair(feeBaseFromService, nonExistingName, newValue, new LearningPeriod());
        } catch (Throwable t) {
            // Make sure we never get here:
            isTrue(false, "An exception should not have been raised");
        }

        // Validate:
        assertFeeBase(testFeeBase, feeBaseFromService);

        // Get a fresh FeeBase from service:
        FeeBase freshFeeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Validate the FeeBase:
        assertFeeBase(testFeeBase, freshFeeBaseFromService);
    }

    @Test
    public void testUpdatePeriodKeyPairWithInvalidParameters() {
        // Null FeeBase:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.updateKeyPair(nullFeeBase, "new name", "New value", new LearningPeriod());
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.updateKeyPair(testFeeBase, null, "New value", new LearningPeriod());
            isTrue(false);
        } catch (Exception e) {
        }

        // Null value:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.updateKeyPair(testFeeBase, "New name", null, new LearningPeriod());
            isTrue(false);
        } catch (Exception e) {
        }

        // Null period:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.updateKeyPair(testFeeBase, "New name", "new value", null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null Everything:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.updateKeyPair(nullFeeBase, null, null, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testUpdateLearningUnitKeyPairExistingName() {
        // Test objects:
        createTestFeeBase();
        String name = "boo";
        String existingValue = "foo";
        String newValue = "something really new";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);
        Long updatedId = luFromService.getId();

        // Assert the value is still the same:
        assertEquals(existingValue, feeManagementService.getKeyPairValue(luFromService, name));

        // Call the service:
        feeManagementService.updateKeyPair(luFromService, name, newValue);

        // Get a fresh FeeBase from service:
        FeeBase freshFeeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Find the same learning unit:
        LearningUnit updatedLu = null;

        for (LearningUnit lu : freshFeeBaseFromService.getLearningUnits()) {
            if (lu.getId().equals(updatedId)) {
                updatedLu = lu;
                break;
            }
        }

        // Validate:
        assertEquals(newValue, feeManagementService.getKeyPairValue(updatedLu, name));
        assertFeeBase(feeBaseFromService, freshFeeBaseFromService);
    }

    @Test
    public void testUpdateLearningUnitKeyPairNonExistingName() {
        // Test objects:
        FeeBase testFeeBase = createTestFeeBase();
        String name = "boo";
        String existingValue = "foo";
        String newValue = "something really new";

        // Get the FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Assert the value is still the same:
        assertEquals(existingValue, feeManagementService.getKeyPairValue(luFromService, name));

        // Call the service:
        try {
            feeManagementService.updateKeyPair(luFromService, name, newValue);
        } catch (Throwable t) {
            // Make sure no exception has been raised:
            isTrue(false);
        }

        // Validate:
        assertFeeBase(testFeeBase, feeBaseFromService);

        // Get a fresh FeeBase from service:
        FeeBase freshFeeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Validate the FeeBase:
        assertFeeBase(testFeeBase, freshFeeBaseFromService);
    }

    @Test
    public void testUpdateLearningUnitKeyPairWithInvalidParameters() {
        // Null LearningUnit:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.updateKeyPair(nullLearningUnit, "new name", "New value");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            feeManagementService.updateKeyPair(new LearningUnit(), null, "New value");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null value:
        try {
            feeManagementService.updateKeyPair(new LearningUnit(), "new name", null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null everything:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.updateKeyPair(nullLearningUnit, null, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testContainsKeyPair() {
        // Test objects:
        createTestFeeBase();

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Test contains an existing name:
        String existingName = "boo";
        boolean contains = feeManagementService.containsKeyPair(feeBaseFromService, existingName);

        isTrue(contains);

        // Test does not contain a non-existing name:
        String nonExistingName = "trolololol";

        contains = feeManagementService.containsKeyPair(feeBaseFromService, nonExistingName);
        isTrue(!contains);
    }

    @Test
    public void testContainsKeyPairWithInvalidParameters() {
        // Null FeeBase:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.containsKeyPair(nullFeeBase, "new name");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            FeeBase testFeeBase = createTestFeeBase();
            feeManagementService.containsKeyPair(testFeeBase, null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null Everything:
        try {
            FeeBase nullFeeBase = null;
            feeManagementService.containsKeyPair(nullFeeBase, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testContainsPeriodKeyPair() {
        // Test objects:
        createTestFeeBase();

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Test contains an existing name:
        String existingName = "boo1";
        boolean contains = feeManagementService.containsKeyPair(feeBaseFromService, existingName);

        isTrue(contains);
    }

    @Test
    public void testContainsLearningUnitKeyPair() {
        // Test objects:
        createTestFeeBase();

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Test contains an existing name:
        String existingName = "boo";
        boolean contains = feeManagementService.containsKeyPair(luFromService, existingName);

        isTrue(contains);

        // Test does not contain a non-existing name:
        String nonExistingName = "trolololol";

        contains = feeManagementService.containsKeyPair(luFromService, nonExistingName);
        isTrue(!contains);
    }

    @Test
    public void testContainsLearningUnitKeyPairWithInvalidParameters() {
        // Null LearningUnit:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.containsKeyPair(nullLearningUnit, "new name");
            isTrue(false);
        } catch (Exception e) {
        }

        // Null name:
        try {
            feeManagementService.containsKeyPair(new LearningUnit(), null);
            isTrue(false);
        } catch (Exception e) {
        }

        // Null everything:
        try {
            LearningUnit nullLearningUnit = null;
            feeManagementService.containsKeyPair(nullLearningUnit, null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testSaveLearningUnit() {
        // Test objects:
        createTestFeeBase();
        Calendar calNewAddDate = Calendar.getInstance();
        int newAddDateYear = 1987;
        int newAddDateMonth = Calendar.SEPTEMBER;
        int newAddDateDay = 5;
        Calendar calNewDropDate = Calendar.getInstance();
        int newDropDateYear = 1999;
        int newDropDateMonth = Calendar.MARCH;
        int newDropDateDay = 13;
        String newCampus = "new campus, eh?";
        double newCredit = 35.5;
        String newLevel = "new level, eh?";
        String newStatus = "new status, eh?";
        String newUnitCode = "new code, eh?";
        String newUnitSection = "new section, eh?";
        LearningPeriod newLp = new LearningPeriod();
        Calendar newDateFrom = Calendar.getInstance();
        int newDateFromYear = 1986;
        int newDateFromMonth = Calendar.JULY;
        int newDateFromDay = 18;
        Calendar newDateTo = Calendar.getInstance();
        int newDateToYear = 1995;
        int newDateToMonth = Calendar.JANUARY;
        int newDateToDay = 25;

        calNewAddDate.set(Calendar.YEAR, newAddDateYear);
        calNewAddDate.set(Calendar.MONTH, newAddDateMonth);
        calNewAddDate.set(Calendar.DAY_OF_MONTH, newAddDateDay);

        calNewDropDate.set(Calendar.YEAR, newDropDateYear);
        calNewDropDate.set(Calendar.MONTH, newDropDateMonth);
        calNewDropDate.set(Calendar.DAY_OF_MONTH, newDropDateDay);

        newDateFrom.set(Calendar.YEAR, newDateFromYear);
        newDateFrom.set(Calendar.MONTH, newDateFromMonth);
        newDateFrom.set(Calendar.DAY_OF_MONTH, newDateFromDay);

        newDateTo.set(Calendar.YEAR, newDateToYear);
        newDateTo.set(Calendar.MONTH, newDateToMonth);
        newDateTo.set(Calendar.DAY_OF_MONTH, newDateToDay);

        newLp.setStartDate(newDateFrom.getTime());
        newLp.setEndDate(newDateTo.getTime());

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Create a few new KeyPairs:
        String newName1 = "new name 1";
        String newValue1 = "new value 1";
        KeyPair newKp1 = feeManagementService.createKeyPair(feeBaseFromService, newName1, newValue1);
        String newName2 = "new name 2";
        String newValue2 = "new value 2";
        KeyPair newKp2 = feeManagementService.createKeyPair(feeBaseFromService, newName2, newValue2);

        // Set the new values:
        luFromService.setAddDate(calNewAddDate.getTime());
        luFromService.setCampus(newCampus);
        luFromService.setCredit(new BigDecimal(newCredit));
        luFromService.setDropDate(calNewDropDate.getTime());
        luFromService.setLearningPeriod(newLp);
        luFromService.setLevel(newLevel);
        luFromService.setStatus(newStatus);
        luFromService.setUnitCode(newUnitCode);
        luFromService.setUnitSection(newUnitSection);
        luFromService.setKeyPairs(new HashSet<KeyPair>(Arrays.asList(newKp1, newKp2)));

        // Call the service:
        feeManagementService.persistLearningUnit(luFromService);

        // Get a fresh FeeBase from service:
        FeeBase freshFeeBaseFromService = feeManagementService.getFeeBase(accountId);

        // Validate:
        assertFeeBase(feeBaseFromService, freshFeeBaseFromService);
    }

    @Test
    public void testSaveLearningUnitNullLearningUnit() {
        try {
            feeManagementService.persistLearningUnit(null);
            isTrue(false);
        } catch (Exception e) {
        }
    }

    @Test
    public void testFindLearningPeriodsDatesExactlyMatchesRangeSingleResult() {
        // Test objects:
        createTestFeeBase();

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Set new date values:
        Calendar newDateFrom = Calendar.getInstance();
        int newDateFromYear = 1986;
        int newDateFromMonth = Calendar.JULY;
        int newDateFromDay = 18;
        Calendar newDateTo = Calendar.getInstance();
        int newDateToYear = 1995;
        int newDateToMonth = Calendar.JANUARY;
        int newDateToDay = 25;

        newDateFrom.set(Calendar.YEAR, newDateFromYear);
        newDateFrom.set(Calendar.MONTH, newDateFromMonth);
        newDateFrom.set(Calendar.DAY_OF_MONTH, newDateFromDay);

        newDateTo.set(Calendar.YEAR, newDateToYear);
        newDateTo.set(Calendar.MONTH, newDateToMonth);
        newDateTo.set(Calendar.DAY_OF_MONTH, newDateToDay);

        luFromService.getLearningPeriod().setStartDate(newDateFrom.getTime());
        luFromService.getLearningPeriod().setEndDate(newDateTo.getTime());

        // Save the changes:
        feeManagementService.persistLearningUnit(luFromService);

        // Call the service:
        List<LearningPeriod> lps = feeManagementService.findLearningPeriods(newDateFrom.getTime(), newDateTo.getTime());

        // Validate result:
        isTrue(CollectionUtils.isNotEmpty(lps));
        isTrue(lps.size() == 1);
        assertLearningPeriod(luFromService.getLearningPeriod(), lps.get(0));
    }

    @Test
    public void testFindLearningPeriodsDatesInRangeSingleResult() {
        // Test objects:
        createTestFeeBase();

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Set new date values:
        Calendar newDateFrom = Calendar.getInstance();
        int newDateFromYear = 1986;
        int newDateFromMonth = Calendar.JULY;
        int newDateFromDay = 18;
        Calendar newDateTo = Calendar.getInstance();
        int newDateToYear = 1995;
        int newDateToMonth = Calendar.JANUARY;
        int newDateToDay = 25;

        newDateFrom.set(Calendar.YEAR, newDateFromYear);
        newDateFrom.set(Calendar.MONTH, newDateFromMonth);
        newDateFrom.set(Calendar.DAY_OF_MONTH, newDateFromDay);

        newDateTo.set(Calendar.YEAR, newDateToYear);
        newDateTo.set(Calendar.MONTH, newDateToMonth);
        newDateTo.set(Calendar.DAY_OF_MONTH, newDateToDay);

        luFromService.getLearningPeriod().setStartDate(newDateFrom.getTime());
        luFromService.getLearningPeriod().setEndDate(newDateTo.getTime());

        // Save the changes:
        feeManagementService.persistLearningUnit(luFromService);

        // Prepare input parameters:
        Calendar newDateFrom_in = Calendar.getInstance();
        int newDateFromYear_in = 1985;
        int newDateFromMonth_in = Calendar.JULY;
        int newDateFromDay_in = 18;
        Calendar newDateTo_in = Calendar.getInstance();
        int newDateToYear_in = 1996;
        int newDateToMonth_in = Calendar.JANUARY;
        int newDateToDay_in = 25;

        newDateFrom_in.set(Calendar.YEAR, newDateFromYear_in);
        newDateFrom_in.set(Calendar.MONTH, newDateFromMonth_in);
        newDateFrom_in.set(Calendar.DAY_OF_MONTH, newDateFromDay_in);

        newDateTo_in.set(Calendar.YEAR, newDateToYear_in);
        newDateTo_in.set(Calendar.MONTH, newDateToMonth_in);
        newDateTo_in.set(Calendar.DAY_OF_MONTH, newDateToDay_in);

        // Call the service:
        List<LearningPeriod> lps = feeManagementService.findLearningPeriods(newDateFrom_in.getTime(), newDateTo_in.getTime());

        // Validate result:
        isTrue(CollectionUtils.isNotEmpty(lps));
        isTrue(lps.size() == 1);
        assertLearningPeriod(luFromService.getLearningPeriod(), lps.get(0));
    }

    @Test
    public void testFindLearningPeriodsDatesInRangeMultipleResults() {
        // Test objects:
        createTestFeeBase();

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);
        LearningUnit luFromService2 = feeBaseFromService.getLearningUnits().get(1);

        // Set new date values for LearningPeriod 1:
        Calendar newDateFrom = Calendar.getInstance();
        int newDateFromYear = 1986;
        int newDateFromMonth = Calendar.JULY;
        int newDateFromDay = 18;
        Calendar newDateTo = Calendar.getInstance();
        int newDateToYear = 1995;
        int newDateToMonth = Calendar.JANUARY;
        int newDateToDay = 25;

        newDateFrom.set(Calendar.YEAR, newDateFromYear);
        newDateFrom.set(Calendar.MONTH, newDateFromMonth);
        newDateFrom.set(Calendar.DAY_OF_MONTH, newDateFromDay);

        newDateTo.set(Calendar.YEAR, newDateToYear);
        newDateTo.set(Calendar.MONTH, newDateToMonth);
        newDateTo.set(Calendar.DAY_OF_MONTH, newDateToDay);

        luFromService.getLearningPeriod().setStartDate(newDateFrom.getTime());
        luFromService.getLearningPeriod().setEndDate(newDateTo.getTime());

        // Set new dates for LearningPeriod 2:
        newDateFrom.set(Calendar.YEAR, newDateFromYear + 5);
        newDateTo.set(Calendar.YEAR, newDateToYear + 5);

        luFromService2.getLearningPeriod().setStartDate(newDateFrom.getTime());
        luFromService2.getLearningPeriod().setEndDate(newDateTo.getTime());

        // Save the changes:
        feeManagementService.persistLearningUnit(luFromService);

        // Prepare input parameters:
        Calendar newDateFrom_in = Calendar.getInstance();
        int newDateFromYear_in = 1985;
        int newDateFromMonth_in = Calendar.JULY;
        int newDateFromDay_in = 18;
        Calendar newDateTo_in = Calendar.getInstance();
        int newDateToYear_in = 2001;
        int newDateToMonth_in = Calendar.JANUARY;
        int newDateToDay_in = 25;

        newDateFrom_in.set(Calendar.YEAR, newDateFromYear_in);
        newDateFrom_in.set(Calendar.MONTH, newDateFromMonth_in);
        newDateFrom_in.set(Calendar.DAY_OF_MONTH, newDateFromDay_in);

        newDateTo_in.set(Calendar.YEAR, newDateToYear_in);
        newDateTo_in.set(Calendar.MONTH, newDateToMonth_in);
        newDateTo_in.set(Calendar.DAY_OF_MONTH, newDateToDay_in);

        // Call the service:
        List<LearningPeriod> lps = feeManagementService.findLearningPeriods(newDateFrom_in.getTime(), newDateTo_in.getTime());

        // Validate result:
        isTrue(CollectionUtils.isNotEmpty(lps));
        isTrue(lps.size() == 2);

        if (lps.get(0).getId().equals(luFromService.getLearningPeriod().getId())) {
            assertLearningPeriod(luFromService.getLearningPeriod(), lps.get(0));
            assertLearningPeriod(luFromService2.getLearningPeriod(), lps.get(1));
        } else {
            assertLearningPeriod(luFromService2.getLearningPeriod(), lps.get(0));
            assertLearningPeriod(luFromService.getLearningPeriod(), lps.get(1));
        }
    }

    @Test
    public void testFindLearningPeriodsDatesOutOfRange() {
        // Test objects:
        createTestFeeBase();

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Set new date values:
        Calendar newDateFrom = Calendar.getInstance();
        int newDateFromYear = 1986;
        int newDateFromMonth = Calendar.JULY;
        int newDateFromDay = 18;
        Calendar newDateTo = Calendar.getInstance();
        int newDateToYear = 1995;
        int newDateToMonth = Calendar.JANUARY;
        int newDateToDay = 25;

        newDateFrom.set(Calendar.YEAR, newDateFromYear);
        newDateFrom.set(Calendar.MONTH, newDateFromMonth);
        newDateFrom.set(Calendar.DAY_OF_MONTH, newDateFromDay);

        newDateTo.set(Calendar.YEAR, newDateToYear);
        newDateTo.set(Calendar.MONTH, newDateToMonth);
        newDateTo.set(Calendar.DAY_OF_MONTH, newDateToDay);

        luFromService.getLearningPeriod().setStartDate(newDateFrom.getTime());
        luFromService.getLearningPeriod().setEndDate(newDateTo.getTime());

        // Save the changes:
        feeManagementService.persistLearningUnit(luFromService);

        // Prepare input parameters:
        Calendar newDateFrom_in = Calendar.getInstance();
        int newDateFromYear_in = 1987;
        int newDateFromMonth_in = Calendar.JULY;
        int newDateFromDay_in = 18;
        Calendar newDateTo_in = Calendar.getInstance();
        int newDateToYear_in = 1994;
        int newDateToMonth_in = Calendar.JANUARY;
        int newDateToDay_in = 25;

        newDateFrom_in.set(Calendar.YEAR, newDateFromYear_in);
        newDateFrom_in.set(Calendar.MONTH, newDateFromMonth_in);
        newDateFrom_in.set(Calendar.DAY_OF_MONTH, newDateFromDay_in);

        newDateTo_in.set(Calendar.YEAR, newDateToYear_in);
        newDateTo_in.set(Calendar.MONTH, newDateToMonth_in);
        newDateTo_in.set(Calendar.DAY_OF_MONTH, newDateToDay_in);

        // Call the service:
        List<LearningPeriod> lps = feeManagementService.findLearningPeriods(newDateFrom_in.getTime(), newDateTo_in.getTime());

        // Validate result:
        isTrue(CollectionUtils.isEmpty(lps));
    }

    @Test
    public void testFindLearningPeriodsOnlyDateFromInRange() {
        // Test objects:
        createTestFeeBase();

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Set new date values:
        Calendar newDateFrom = Calendar.getInstance();
        int newDateFromYear = 1986;
        int newDateFromMonth = Calendar.JULY;
        int newDateFromDay = 18;
        Calendar newDateTo = Calendar.getInstance();
        int newDateToYear = 1995;
        int newDateToMonth = Calendar.JANUARY;
        int newDateToDay = 25;

        newDateFrom.set(Calendar.YEAR, newDateFromYear);
        newDateFrom.set(Calendar.MONTH, newDateFromMonth);
        newDateFrom.set(Calendar.DAY_OF_MONTH, newDateFromDay);

        newDateTo.set(Calendar.YEAR, newDateToYear);
        newDateTo.set(Calendar.MONTH, newDateToMonth);
        newDateTo.set(Calendar.DAY_OF_MONTH, newDateToDay);

        luFromService.getLearningPeriod().setStartDate(newDateFrom.getTime());
        luFromService.getLearningPeriod().setEndDate(newDateTo.getTime());

        // Save the changes:
        feeManagementService.persistLearningUnit(luFromService);

        // Prepare input parameters:
        Calendar newDateFrom_in = Calendar.getInstance();
        int newDateFromYear_in = 1985;
        int newDateFromMonth_in = Calendar.JULY;
        int newDateFromDay_in = 18;
        Calendar newDateTo_in = Calendar.getInstance();
        int newDateToYear_in = 1994;
        int newDateToMonth_in = Calendar.JANUARY;
        int newDateToDay_in = 25;

        newDateFrom_in.set(Calendar.YEAR, newDateFromYear_in);
        newDateFrom_in.set(Calendar.MONTH, newDateFromMonth_in);
        newDateFrom_in.set(Calendar.DAY_OF_MONTH, newDateFromDay_in);

        newDateTo_in.set(Calendar.YEAR, newDateToYear_in);
        newDateTo_in.set(Calendar.MONTH, newDateToMonth_in);
        newDateTo_in.set(Calendar.DAY_OF_MONTH, newDateToDay_in);

        // Call the service:
        List<LearningPeriod> lps = feeManagementService.findLearningPeriods(newDateFrom_in.getTime(), newDateTo_in.getTime());

        // Validate result:
        isTrue(CollectionUtils.isEmpty(lps));
    }

    @Test
    public void testFindLearningPeriodsOnlyDateToInRange() {
        // Test objects:
        createTestFeeBase();

        // Get a fresh FeeBase from service:
        FeeBase feeBaseFromService = feeManagementService.getFeeBase(accountId);
        LearningUnit luFromService = feeBaseFromService.getLearningUnits().get(0);

        // Set new date values:
        Calendar newDateFrom = Calendar.getInstance();
        int newDateFromYear = 1986;
        int newDateFromMonth = Calendar.JULY;
        int newDateFromDay = 18;
        Calendar newDateTo = Calendar.getInstance();
        int newDateToYear = 1995;
        int newDateToMonth = Calendar.JANUARY;
        int newDateToDay = 25;

        newDateFrom.set(Calendar.YEAR, newDateFromYear);
        newDateFrom.set(Calendar.MONTH, newDateFromMonth);
        newDateFrom.set(Calendar.DAY_OF_MONTH, newDateFromDay);

        newDateTo.set(Calendar.YEAR, newDateToYear);
        newDateTo.set(Calendar.MONTH, newDateToMonth);
        newDateTo.set(Calendar.DAY_OF_MONTH, newDateToDay);

        luFromService.getLearningPeriod().setStartDate(newDateFrom.getTime());
        luFromService.getLearningPeriod().setEndDate(newDateTo.getTime());

        // Save the changes:
        feeManagementService.persistLearningUnit(luFromService);

        // Prepare input parameters:
        Calendar newDateFrom_in = Calendar.getInstance();
        int newDateFromYear_in = 1987;
        int newDateFromMonth_in = Calendar.JULY;
        int newDateFromDay_in = 18;
        Calendar newDateTo_in = Calendar.getInstance();
        int newDateToYear_in = 1996;
        int newDateToMonth_in = Calendar.JANUARY;
        int newDateToDay_in = 25;

        newDateFrom_in.set(Calendar.YEAR, newDateFromYear_in);
        newDateFrom_in.set(Calendar.MONTH, newDateFromMonth_in);
        newDateFrom_in.set(Calendar.DAY_OF_MONTH, newDateFromDay_in);

        newDateTo_in.set(Calendar.YEAR, newDateToYear_in);
        newDateTo_in.set(Calendar.MONTH, newDateToMonth_in);
        newDateTo_in.set(Calendar.DAY_OF_MONTH, newDateToDay_in);

        // Call the service:
        List<LearningPeriod> lps = feeManagementService.findLearningPeriods(newDateFrom_in.getTime(), newDateTo_in.getTime());

        // Validate result:
        isTrue(CollectionUtils.isEmpty(lps));
    }

    @Test
    public void testGetLearningPeriod() throws Exception {
        // Test objects:
        createTestFeeBase();
        String nameExactMatch = "2011-ODISSEY";
        String nameMatchDifferentCase = "2011-OdiSseY";
        String nameNoMatch = "boo";

        // Call the service with an exact case matching name:
        LearningPeriod lp = feeManagementService.getLearningPeriod(nameExactMatch);

        // Validate:
        notNull(lp);
        assertEquals(nameExactMatch, lp.getName());

        // Call the service with a different case name:
        lp = feeManagementService.getLearningPeriod(nameMatchDifferentCase);

        // Validate:
        notNull(lp);
        assertEquals(nameExactMatch, lp.getName());

        // Call the service with a non-matched name:
        lp = feeManagementService.getLearningPeriod(nameNoMatch);

        // Validate:
        isNull(lp);
    }

    /* *************************************
      *
      * Helper methods.
      *
      * *************************************/

    private List<KeyPair> createTestStudentData() {
        // Create and persist a test Account:
        testAccount = accountService.getOrCreateAccount(accountId);
        persistAccount();

        // Create KeyPairs:
        List<KeyPair> studentData = createKeyPairs();

        try {
            // Persist KeyPairs:
            for (KeyPair kp : studentData) {
                em.persist(kp);
            }

            em.flush();
        } catch (Throwable t) {
            return null;
        }

        // Insert association table records:
        for (KeyPair kp : studentData) {
            Query query = em.createNativeQuery("insert into ksa.kssa_acnt_kypr (acnt_id_fk, kypr_id_fk) values(:accountId, :keypairId)")
                    .setParameter("accountId", accountId).setParameter("keypairId", kp.getId());

            query.executeUpdate();
        }

        return studentData;
    }

    private List<KeyPair> createKeyPairs() {
        KeyPair kp1 = new KeyPair();
        KeyPair kp2 = new KeyPair();
        KeyPair kp3 = new KeyPair();

        kp1.setName("boo");
        kp1.setValue("foo");
        kp2.setName("boo2");
        kp2.setValue("foo2");
        kp2.setPreviousValue("previous foo2");
        kp3.setName("snafu");
        kp3.setValue("beyond recognition");

        return new ArrayList<KeyPair>(Arrays.asList(kp1, kp2, kp3));
    }

    private List<PeriodKeyPair> createTestPeriodData() {
        // Create and persist a test Account:
        testAccount = accountService.getOrCreateAccount(accountId);
        persistAccount();

        // Create PeriodKeyPairs:
        List<PeriodKeyPair> periodData = createPeriodKeyPairs();

        try {
            // Persist PeriodKeyPairs:
            for (PeriodKeyPair pkp : periodData) {
                em.persist(pkp);
            }

            em.flush();
        } catch (Throwable t) {
            return null;
        }

        // Insert association table records:
        for (PeriodKeyPair pkp : periodData) {
            Query query = em.createNativeQuery("insert into ksa.kssa_acnt_kypr (acnt_id_fk, kypr_id_fk) values(:accountId, :keypairId)")
                    .setParameter("accountId", accountId).setParameter("keypairId", pkp.getId());

            query.executeUpdate();
        }

        return periodData;
    }

    private List<PeriodKeyPair> createPeriodKeyPairs() {
        PeriodKeyPair pkp1 = new PeriodKeyPair();
        PeriodKeyPair pkp2 = new PeriodKeyPair();
        PeriodKeyPair pkp3 = new PeriodKeyPair();
        PeriodKeyPair pkp4 = new PeriodKeyPair();
        LearningPeriod lp = new LearningPeriod();
        String lpName = "2011-ODDITY";

        pkp1.setName("boo1");
        pkp1.setValue("foo1");
        pkp1.setLearningPeriod(lp);
        pkp2.setName("boo2");
        pkp2.setValue("foo2");
        pkp2.setPreviousValue("previous foo2");
        pkp2.setLearningPeriod(lp);
        pkp3.setName("boo3");
        pkp3.setValue("foo3");
        pkp3.setLearningPeriod(lp);
        pkp4.setName("boo4");
        pkp4.setValue("foo4");
        pkp4.setPreviousValue("previous foo4");
        pkp4.setLearningPeriod(lp);
        lp.setStartDate(new Date());
        lp.setEndDate(new Date());
        lp.setName(lpName);

        return new ArrayList<PeriodKeyPair>(Arrays.asList(pkp1, pkp2, pkp3, pkp4));
    }

    private List<LearningUnit> createTestStudy() {
        // Create and persist a test Account:
        testAccount = accountService.getOrCreateAccount(accountId);
        persistAccount();

        // Create LearningUnits:
        List<LearningUnit> learningUnits = createLearningUnits();

        try {
            // Persist PeriodKeyPairs:
            for (LearningUnit lu : learningUnits) {
                em.persist(lu);
            }

            em.flush();
        } catch (Throwable t) {
            return null;
        }

        return learningUnits;
    }

    private List<LearningUnit> createLearningUnits() {
        LearningUnit lu1 = new LearningUnit();
        LearningUnit lu2 = new LearningUnit();
        LearningPeriod lp1 = new LearningPeriod();
        LearningPeriod lp2 = new LearningPeriod();
        String lp1Name = "2011-ODISSEY";
        String lp2Name = "2012-ELECTION";

        // Set up learning periods:
        lp1.setStartDate(new Date());
        lp1.setEndDate(new Date());
        lp1.setName(lp1Name);
        lp2.setStartDate(new Date());
        lp2.setEndDate(new Date());
        lp2.setName(lp2Name);

        // Set up LearningUnit 1:
        lu1.setAccount(testAccount);
        lu1.setAccountId(accountId);
        lu1.setAddDate(new Date());
        lu1.setCampus("boogie campus");
        lu1.setCredit(new BigDecimal(5.5));
        lu1.setDropDate(new Date());
        lu1.setLearningPeriod(lp1);
        lu1.setLevel("Level 1");
        lu1.setStatus("Undefined");
        lu1.setUnitCode("doo");
        lu1.setUnitSection("section 000v");
        lu1.setKeyPairs(new HashSet<KeyPair>(createKeyPairs()));

        // Set up LearningUnit 2:
        lu2.setAccount(testAccount);
        lu2.setAccountId(accountId);
        lu2.setAddDate(new Date());
        lu2.setCampus("boogie campus 2");
        lu2.setCredit(new BigDecimal(555.45));
        lu2.setDropDate(new Date());
        lu2.setLearningPeriod(lp2);
        lu2.setLevel("Level 2");
        lu2.setStatus("Undefined 2");
        lu2.setUnitCode("doo2");
        lu2.setUnitSection("section 002v");
        lu2.setKeyPairs(new HashSet<KeyPair>(createKeyPairs()));

        return new ArrayList<LearningUnit>(Arrays.asList(lu1, lu2));
    }

    private void persistAccount() {
        testAccount = em.merge(testAccount);
        em.persist(testAccount);
    }

    private FeeBase createTestFeeBase() {
        // Create test objects:
        List<KeyPair> testStudentData = createTestStudentData();
        List<PeriodKeyPair> testPeriodData = createTestPeriodData();
        List<LearningUnit> testStudy = createTestStudy();

        // If creation of the test data failed, so be it, nothing to test:
        if ((testStudentData == null) || (testPeriodData == null) || (testStudy == null)) {
            return null;
        }

        // Create a new FeeBase:
        FeeBase feeBase = new FeeBase();

        feeBase.setAccount(testAccount);
        feeBase.setStudentData(testStudentData);
        feeBase.setPeriodData(testPeriodData);
        feeBase.setLearningUnits(testStudy);

        return feeBase;
    }


    /* **************************************************************
      *
      * Assertion methods.
      *
      * **************************************************************/

    private void assertFeeBase(FeeBase expected, FeeBase actual) {
        notNull(actual);
        assertKeyPairs(expected.getStudentData(), actual.getStudentData());
        assertKeyPairs(expected.getPeriodData(), actual.getPeriodData());
        assertStudy(expected.getLearningUnits(), actual.getLearningUnits());
    }

    private <T extends KeyPair> void assertKeyPairs(List<T> expected, List<T> actual) {
        notNull(actual);
        assertEquals(expected.size(), actual.size());

        // Pre-sort the lists by their natural IDs:
        List<KeyPair> expectedKeyPairs = new ArrayList<KeyPair>(expected);
        List<KeyPair> actualKeyPairs = new ArrayList<KeyPair>(actual);
        KeyPairComparator comparator = new KeyPairComparator();

        Collections.sort(expectedKeyPairs, comparator);
        Collections.sort(actualKeyPairs, comparator);

        // Inspect each result object:
        for (int i = 0, sz = expectedKeyPairs.size(); i < sz; i++) {
            notNull(actualKeyPairs.get(i));
            assertEquals(expectedKeyPairs.get(i).getId(), actualKeyPairs.get(i).getId());
            assertEquals(expectedKeyPairs.get(i).getName(), actualKeyPairs.get(i).getName());
            assertEquals(expectedKeyPairs.get(i).getValue(), actualKeyPairs.get(i).getValue());
            assertEquals(expectedKeyPairs.get(i).getPreviousValue(), actualKeyPairs.get(i).getPreviousValue());

            if (actual.get(i) instanceof PeriodKeyPair) {
                assertLearningPeriod(
                        PeriodKeyPair.class.cast(expectedKeyPairs.get(i)).getLearningPeriod(),
                        PeriodKeyPair.class.cast(actualKeyPairs.get(i)).getLearningPeriod()
                );
            }
        }
    }

    private void assertStudy(List<LearningUnit> expected, List<LearningUnit> actual) {
        notNull(actual);
        assertEquals(expected.size(), actual.size());

        // Inspect each result object:
        for (int i = 0, sz = expected.size(); i < sz; i++) {
            notNull(actual.get(i));
            assertEquals(expected.get(i).getId(), actual.get(i).getId());
            assertEquals(expected.get(i).getUnitCode(), actual.get(i).getUnitCode());
            assertEquals(expected.get(i).getUnitSection(), actual.get(i).getUnitSection());
            assertEquals(expected.get(i).getCampus(), actual.get(i).getCampus());
            assertEquals(expected.get(i).getLevel(), actual.get(i).getLevel());
            isTrue(DateUtils.isSameDay(expected.get(i).getAddDate(), actual.get(i).getAddDate()));
            isTrue(DateUtils.isSameDay(expected.get(i).getDropDate(), actual.get(i).getDropDate()));
            assertLearningPeriod(expected.get(i).getLearningPeriod(), actual.get(i).getLearningPeriod());
            assertEquals(expected.get(i).getCredit(), actual.get(i).getCredit());
            assertEquals(expected.get(i).getStatus(), actual.get(i).getStatus());
            assertEquals(expected.get(i).getAccountId(), actual.get(i).getAccountId());
            assertAccount(expected.get(i).getAccount(), actual.get(i).getAccount());
            assertKeyPairs(new ArrayList<KeyPair>(expected.get(i).getKeyPairs()), new ArrayList<KeyPair>(actual.get(i).getKeyPairs()));
        }
    }

    private void assertLearningPeriod(LearningPeriod expected, LearningPeriod actual) {
        if (expected != null) {
            notNull(actual);
            assertEquals(expected.getId(), actual.getId());
            isTrue(DateUtils.isSameDay(expected.getStartDate(), actual.getStartDate()));
            isTrue(DateUtils.isSameDay(expected.getEndDate(), actual.getEndDate()));
        } else {
            isNull(actual);
        }
    }

    private void assertAccount(Account expected, Account actual) {
        if (expected != null) {
            notNull(actual);
            assertEquals(expected.getId(), actual.getId());
        } else {
            isNull(actual);
        }
    }

    private static class KeyPairComparator implements Comparator<KeyPair> {
        @Override
        public int compare(KeyPair o1, KeyPair o2) {
            return o1.getId().compareTo(o2.getId());
        }

    }
}
