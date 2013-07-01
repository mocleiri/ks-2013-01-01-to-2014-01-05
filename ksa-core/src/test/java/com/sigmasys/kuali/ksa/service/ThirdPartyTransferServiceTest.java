package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.service.tp.ThirdPartyTransferService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ThirdPartyTransferService tests.
 *
 * @author Michael Ivanov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class ThirdPartyTransferServiceTest extends AbstractServiceTest {


    @Autowired
    private ThirdPartyTransferService transferService;

    @Autowired
    private AccountService accountService;

    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        accountService.getOrCreateAccount(userId);
    }


    @Test
    public void createThirdPartyPlan() throws Exception {

        // TODO
    }


}
