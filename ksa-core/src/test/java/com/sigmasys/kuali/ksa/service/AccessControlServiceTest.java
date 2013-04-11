package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.service.security.AccessControlService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class AccessControlServiceTest extends AbstractServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccessControlService accessControlService;

    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        accountService.getOrCreateAccount(userId);
    }

    @Test
    public void getRoles() throws Exception {

        Set<String> roles = accessControlService.getRoles("admin");

        Assert.notNull(roles);
        Assert.notEmpty(roles);

        for (String role : roles) {
            Assert.notNull(role);
            Assert.isTrue(!role.isEmpty());
        }

        logger.info("Role names: " + roles);
    }

    @Test
    public void getPermissions() throws Exception {

        Set<String> permissions = accessControlService.getPermissions("admin");

        Assert.notNull(permissions);
        Assert.notEmpty(permissions);

        for (String permission : permissions) {
            Assert.notNull(permission);
            Assert.isTrue(!permission.isEmpty());
        }

        logger.info("Permission names: " + permissions);
    }

    @Test
    public void hasPermissions() throws Exception {

        final String[] permissions = {"Use Configuration Viewer Screen",
                "Inquire Into Pessimistic",
                "Use Java Security Management Screen",
                "Grant Permission KUALI Namespace",
                "Modify Batch Job",
                "Look Up Rule Attribute",
                "Maintain System Parameter"};

        boolean result = accessControlService.hasPermissions("admin", permissions);

        Assert.isTrue(result);

        result = accessControlService.hasPermission("admin", permissions[0]);

        Assert.isTrue(result);

    }

    @Test
    public void refresh() throws Exception {

        accessControlService.refresh();

    }


}
