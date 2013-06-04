package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.service.fm.RateService;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * RateService tests.
 *
 * @author Michael Ivanov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class RateServiceTest extends AbstractServiceTest {


    @Autowired
    private RateService rateService;

    @Autowired
    private AccountService accountService;

    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        accountService.getOrCreateAccount(userId);
        _createRateType("RT_2013", "RateType_2013", "2013 Rate type description");
    }

    private RateType _createRateType(String code, String name, String description) {

        RateType rateType = rateService.createRateType(code, name, description);

        Assert.notNull(rateType);
        Assert.notNull(rateType.getId());
        Assert.notNull(rateType.getCode());
        Assert.notNull(rateType.getName());
        Assert.notNull(rateType.getDescription());
        Assert.notNull(rateType.getCreatorId());
        Assert.notNull(rateType.getCreationDate());

        return rateType;
    }

    private RateCatalog _createRateCatalog(String rateCatalogCode) {

        String rateTypeCode = "RT_2013";
        String transactionTypeId = "cash";
        TransactionDateType dateType = TransactionDateType.ALWAYS;
        BigDecimal lowerBound = new BigDecimal(10.99);
        BigDecimal upperBound = new BigDecimal(300000.67);
        BigDecimal cappedAmount = new BigDecimal(200.88);
        List<String> atpIds = Arrays.asList("19871", "19872", "19873", "19874");
        List<KeyPair> keyPairs = Arrays.asList(new KeyPair("key1", "value1"));

        RateCatalog rateCatalog = rateService.createRateCatalog(rateCatalogCode, rateTypeCode, transactionTypeId,
                dateType, lowerBound, upperBound, cappedAmount, atpIds, keyPairs, false, false, false, false, false);

        Assert.notNull(rateCatalog);
        Assert.notNull(rateCatalog.getId());
        Assert.notNull(rateCatalog.getCode());
        Assert.isTrue(rateCatalog.getCode().equals(rateCatalogCode));
        Assert.notNull(rateCatalog.getLowerBoundAmount());
        Assert.notNull(rateCatalog.getUpperBoundAmount());
        Assert.notNull(rateCatalog.getKeyPairs());
        Assert.notEmpty(rateCatalog.getKeyPairs());
        Assert.notNull(rateCatalog.getTransactionDateType());

        Set<String> atpIdsSet = rateService.getAtpsForRateCatalog(rateCatalog.getId());

        Assert.notNull(atpIdsSet);
        Assert.notEmpty(atpIdsSet);

        return rateCatalog;

    }

    private Rate _createRate(String rateCode, String rateCatalogCode) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_US);

        Date transactionDate = dateFormat.parse("05/23/2012");
        Date recognitionDate = null;

        String rateName = rateCode + " name";
        String transactionTypeId = "cash";
        String amountTransactionTypeId = "cash";
        TransactionDateType dateType = TransactionDateType.ALWAYS;
        BigDecimal cappedAmount = new BigDecimal(7776000.1111);
        BigDecimal rateAmount = new BigDecimal(200.88);

        String atpId = "19874";

        Rate rate = rateService.createRate(rateCode, rateName, rateCatalogCode, transactionTypeId,
                amountTransactionTypeId, dateType, rateAmount, cappedAmount, transactionDate, recognitionDate, atpId,
                false, false);

        Assert.notNull(rate);
        Assert.notNull(rate.getId());
        Assert.notNull(rate.getAtpId());
        Assert.notNull(rate.getCode());
        Assert.notNull(rate.getRateCatalogAtp());

        RateCatalog rateCatalog = rate.getRateCatalogAtp().getRateCatalog();

        Assert.notNull(rateCatalog);
        Assert.notNull(rate.getRateCatalogAtp().getId());
        Assert.isTrue(rateCatalogCode.equals(rateCatalog.getCode()));
        Assert.isTrue(rateCatalogCode.equals(rate.getRateCatalogAtp().getId().getCode()));
        Assert.notNull(rate.getDefaultRateAmount());
        Assert.notNull(rate.getDefaultRateAmount().getAmount());
        Assert.isTrue(rate.getDefaultRateAmount().getAmount().compareTo(rateAmount) == 0);
        Assert.notNull(rate.getKeyPairs());
        Assert.notEmpty(rate.getKeyPairs());
        Assert.notNull(rate.getTransactionDateType());
        Assert.notNull(rate.getTransactionTypeId());

        if (!rateCatalog.isRecognitionDateDefinable()) {
            Assert.isNull(rate.getRecognitionDate());
        }

        if (rateCatalog.isTransactionDateTypeFinal()) {
            Assert.isTrue(rate.getTransactionDateType() == rateCatalog.getTransactionDateType());
        }

        if (rateCatalog.isTransactionTypeFinal()) {
            Assert.isTrue(rate.getTransactionTypeId().equals(rateCatalog.getTransactionTypeId()));
        }

        if (rateCatalog.getKeyPairs() != null && rateCatalog.isKeyPairFinal()) {
            Assert.isTrue(CollectionUtils.isEqualCollection(rate.getKeyPairs(), rateCatalog.getKeyPairs()));
        }

        Assert.isTrue(!rateCatalog.isAmountFinal() || (rateCatalog.isAmountFinal() && rate.isAmountFinal()));

        return rate;

    }

    @Test
    public void createRateType() {
        _createRateType("RT_2013_1", "RateType_2013_1", "2013 Rate type description");
    }

    @Test
    public void creteRateCatalog() throws Exception {

        String rateCatalogCode = "RC_2013";

        _createRateCatalog(rateCatalogCode);
    }

    @Test
    public void getRateCatalogById() {

        String rateCatalogCode = "RC_2013_1";

        RateCatalog rateCatalog = _createRateCatalog(rateCatalogCode);

        Assert.notNull(rateCatalog);
        Assert.notNull(rateCatalog.getId());
        Assert.notNull(rateCatalog.getCode());
        Assert.isTrue(rateCatalogCode.equals(rateCatalog.getCode()));

        rateCatalog = rateService.getRateCatalog(rateCatalog.getId());

        Assert.notNull(rateCatalog);
        Assert.notNull(rateCatalog.getId());
        Assert.notNull(rateCatalog.getCode());
        Assert.isTrue(rateCatalogCode.equals(rateCatalog.getCode()));

    }

    @Test
    public void deleteRateCatalog() {

        String rateCatalogCode = "RC_2013_TO_DELETE";

        RateCatalog rateCatalog = _createRateCatalog(rateCatalogCode);

        Assert.notNull(rateCatalog);
        Assert.notNull(rateCatalog.getId());

        rateService.deleteRateCatalog(rateCatalog.getId());

        rateCatalog = rateService.getRateCatalog(rateCatalog.getId());

        Assert.isNull(rateCatalog);
    }

    @Test
    public void creteRate() throws Exception {

        String rateCatalogCode = "RC_2013";

        _createRateCatalog(rateCatalogCode);

        String rateCode = "R_2013";

        _createRate(rateCode, rateCatalogCode);
    }

    @Test
    public void assignAtpsToRateCatalog() {

        String rateCatalogCode = "RC_2013";

        String[] atpIds = {"19875", "19876", "19877"};

        RateCatalog rateCatalog = _createRateCatalog(rateCatalogCode);

        rateCatalog = rateService.assignAtpsToRateCatalog(rateCatalog.getId(), atpIds);

        Assert.notNull(rateCatalog);

        for (String atpId : atpIds) {

            RateCatalog rateCatalog1 = rateService.getRateCatalogByCodeAndAtpId(rateCatalogCode, atpId);

            Assert.notNull(rateCatalog1);

            Assert.isTrue(rateCatalog1.getId().equals(rateCatalog.getId()));
        }


        Set<String> atpIdSet = rateService.getAtpsForRateCatalog(rateCatalog.getId());

        Assert.notNull(atpIdSet);
        Assert.notEmpty(atpIdSet);

        Assert.isTrue(atpIdSet.containsAll(Arrays.asList(atpIds)));

    }

    @Test
    public void addKeyPairToRate() throws Exception {

        String rateCatalogCode = "RC_2013";

        _createRateCatalog(rateCatalogCode);

        String rateCode = "R_2013";

        Rate rate = _createRate(rateCode, rateCatalogCode);

        Assert.notNull(rate);
        Assert.notNull(rate.getId());

        rateService.addKeyPairToRate("key_45", "value_45", rate.getId());
        rate = rateService.getRate(rate.getId());

        Set<KeyPair> keyPairs = rate.getKeyPairs();

        Assert.notNull(keyPairs);
        Assert.notEmpty(keyPairs);

        Assert.isTrue(keyPairs.contains(new KeyPair("key_45", "value_45")));

    }

    @Test
    public void removeKeyPairFromRate() throws Exception {

        String rateCatalogCode = "RC_2013";

        _createRateCatalog(rateCatalogCode);

        String rateCode = "R_2013";

        Rate rate = _createRate(rateCode, rateCatalogCode);

        Assert.notNull(rate);
        Assert.notNull(rate.getId());

        rateService.addKeyPairToRate("key_48", "value_48", rate.getId());
        rate = rateService.getRate(rate.getId());

        Set<KeyPair> keyPairs = rate.getKeyPairs();

        Assert.notNull(keyPairs);
        Assert.notEmpty(keyPairs);

        Assert.isTrue(keyPairs.contains(new KeyPair("key_48", "value_48")));

        int keyPairsSize = keyPairs.size();

        rateService.removeKeyPairFromRate("key_48", rate.getId());
        rate = rateService.getRate(rate.getId());

        keyPairs = rate.getKeyPairs();

        Assert.notNull(keyPairs);
        Assert.notEmpty(keyPairs);

        Assert.isTrue(!keyPairs.contains(new KeyPair("key_48", "value_48")));

        Assert.isTrue(keyPairsSize - keyPairs.size() == 1);

    }

    @Test
    public void addKeyPairToRateCatalog() throws Exception {

        String rateCatalogCode = "RC_2013";

        RateCatalog catalog = _createRateCatalog(rateCatalogCode);

        Assert.notNull(catalog);
        Assert.notNull(catalog.getId());

        String rateCode = "R_2013";

        Rate rate = _createRate(rateCode, rateCatalogCode);

        Assert.notNull(rate);
        Assert.notNull(rate.getId());

        rateService.addKeyPairToRateCatalog("key_49", "value_49", catalog.getId());

        catalog = rateService.getRateCatalog(catalog.getId());
        rate = rateService.getRate(rate.getId());

        Set<KeyPair> catalogKeyPairs = catalog.getKeyPairs();

        Assert.notNull(catalogKeyPairs);
        Assert.notEmpty(catalogKeyPairs);
        Assert.isTrue(catalogKeyPairs.contains(new KeyPair("key_49", "value_49")));
        Assert.isTrue(catalogKeyPairs.contains(new KeyPair("key1", "value1")));

        Set<KeyPair> rateKeyPairs = rate.getKeyPairs();

        Assert.notNull(rateKeyPairs);
        Assert.notEmpty(rateKeyPairs);
        Assert.isTrue(rateKeyPairs.contains(new KeyPair("key_49", "value_49")));
        Assert.isTrue(rateKeyPairs.contains(new KeyPair("key1", "value1")));

        Assert.isTrue(catalogKeyPairs.size() == rateKeyPairs.size());
        Assert.isTrue(catalogKeyPairs.size() == 2);

        Assert.isTrue(CollectionUtils.isEqualCollection(catalogKeyPairs, rateKeyPairs));

    }

    @Test
    public void removeKeyPairFromRateCatalog() throws Exception {

        String rateCatalogCode = "RC_2013";

        RateCatalog catalog = _createRateCatalog(rateCatalogCode);

        Assert.notNull(catalog);
        Assert.notNull(catalog.getId());

        String rateCode = "R_2013";

        Rate rate = _createRate(rateCode, rateCatalogCode);

        Assert.notNull(rate);
        Assert.notNull(rate.getId());

        rateService.addKeyPairToRateCatalog("key_49", "value_49", catalog.getId());

        catalog = rateService.getRateCatalog(catalog.getId());
        rate = rateService.getRate(rate.getId());

        Set<KeyPair> catalogKeyPairs = catalog.getKeyPairs();

        Assert.notNull(catalogKeyPairs);
        Assert.notEmpty(catalogKeyPairs);
        Assert.isTrue(catalogKeyPairs.contains(new KeyPair("key_49", "value_49")));
        Assert.isTrue(catalogKeyPairs.contains(new KeyPair("key1", "value1")));

        Set<KeyPair> rateKeyPairs = rate.getKeyPairs();

        Assert.notNull(rateKeyPairs);
        Assert.notEmpty(rateKeyPairs);
        Assert.isTrue(rateKeyPairs.contains(new KeyPair("key_49", "value_49")));
        Assert.isTrue(rateKeyPairs.contains(new KeyPair("key1", "value1")));

        Assert.isTrue(catalogKeyPairs.size() == rateKeyPairs.size());
        Assert.isTrue(catalogKeyPairs.size() == 2);

        Assert.isTrue(CollectionUtils.isEqualCollection(catalogKeyPairs, rateKeyPairs));

        rateService.removeKeyPairFromRateCatalog("key_49", catalog.getId());
        catalog = rateService.getRateCatalog(catalog.getId());

        catalogKeyPairs = catalog.getKeyPairs();

        Assert.notNull(catalogKeyPairs);
        Assert.notEmpty(catalogKeyPairs);
        Assert.isTrue(catalogKeyPairs.size() == 1);

        Assert.isTrue(!catalogKeyPairs.contains(new KeyPair("key_49", "value_49")));

        rate = rateService.getRate(rate.getId());

        rateKeyPairs = rate.getKeyPairs();

        Assert.notNull(rateKeyPairs);
        Assert.notEmpty(rateKeyPairs);
        Assert.isTrue(rateKeyPairs.size() == 1);

        Assert.isTrue(!catalogKeyPairs.contains(new KeyPair("key_49", "value_49")));

    }


}
