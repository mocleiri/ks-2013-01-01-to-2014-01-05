package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.exception.AccountBlockedException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
@SuppressWarnings("unchecked")
public class AccountBlockingServiceTest extends AbstractServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountBlockingService accountBlockingService;


    @Before
    public void setUpWithinTransaction() {
        // Set up test data within the transaction
        Account userAccount = accountService.getOrCreateAccount("user1");
        Assert.isTrue(userAccount.isBlockingEnabled());
    }

    @Test
    public void checkBlock1() throws Exception {

        String userId = "user1";
        String transactionTypeId1 = "cash";
        String transactionTypeId2 = "chip";
        String transactionTypeId3 = "finaid";

        Map<String, Object> attributes = new HashMap<String, Object>();

        List<String> transactionTypeIds = Arrays.asList(transactionTypeId1, transactionTypeId2, transactionTypeId3);

        attributes.put(Constants.BRM_AB_TRANSACTION_TYPE_IDS, transactionTypeIds);

        try {

            accountBlockingService.checkBlock(userId, attributes, Permission.CREATE_PAYMENT, Permission.CREATE_ALLOCATION);

        } catch (AccountBlockedException abe) {

            logger.info("Message = " + abe.getMessage() + ", Account ID = " + abe.getAccountId() +
                    ", Block names = " + abe.getBlockNames());

            Assert.notNull(abe.getAccountId());
            Assert.notNull(abe.getBlockNames());

            Assert.isTrue(abe.getAccountId().equals(userId));
            Assert.notEmpty(abe.getBlockNames());
            Assert.isTrue(abe.getBlockNames().contains("Block 1"));

        }

    }

}