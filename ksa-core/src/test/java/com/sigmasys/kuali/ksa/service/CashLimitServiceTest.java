package com.sigmasys.kuali.ksa.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
@SuppressWarnings("unchecked")
public class CashLimitServiceTest extends AbstractServiceTest {

    @Autowired
    private CashLimitService cashLimitService;

    @Autowired
    private AccountService accountService;


    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        accountService.getOrCreateAccount("admin");
    }

    @Test
    public void checkCashLimit() throws Exception {

        cashLimitService.checkCashLimit("admin");

        // TODO: add assertions

    }

}