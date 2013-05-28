package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.model.fm.KeyPair;
import com.sigmasys.kuali.ksa.model.fm.RateCatalog;
import com.sigmasys.kuali.ksa.model.fm.RateType;
import com.sigmasys.kuali.ksa.model.fm.TransactionDateType;
import com.sigmasys.kuali.ksa.service.fm.RateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Arrays;
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
        TransactionDateType dateType = TransactionDateType.ALWAYS;
        BigDecimal lowerBound = new BigDecimal(10.99);
        BigDecimal upperBound = new BigDecimal(300000.67);
        BigDecimal cappedAmount = new BigDecimal(200.88);
        List<String> atpIds = Arrays.asList("19871", "19872", "19873", "19874");
        List<KeyPair> keyPairs = Arrays.asList(new KeyPair("key1", "value1"));

        RateCatalog rateCatalog = rateService.createRateCatalog(rateCatalogCode, rateTypeCode, dateType, lowerBound,
                upperBound, cappedAmount, atpIds, keyPairs, false, false, false, false, false);

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

}
