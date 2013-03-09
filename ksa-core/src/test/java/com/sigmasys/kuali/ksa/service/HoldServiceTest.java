package com.sigmasys.kuali.ksa.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.hold.dto.HoldIssueInfo;
import org.kuali.student.r2.core.hold.service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * KS Hold service tests.
 *
 * @author Michael Ivanov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class HoldServiceTest extends AbstractServiceTest {


    @Autowired
    private HoldService holdService;

    @Autowired
    private AccountService accountService;

    private ContextInfo contextInfo;

    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        accountService.getOrCreateAccount(userId);
        contextInfo = new ContextInfo();
        contextInfo.setAuthenticatedPrincipalId(userId);
        contextInfo.setPrincipalId(userId);
    }


    @Test
    public void getHoldIssueIdsByType() throws Exception {

        String holdIssueType = "kuali.hold.issue.type.library";

        List<String> holdIssueIds = holdService.getHoldIssueIdsByType (holdIssueType, contextInfo);

        Assert.notNull(holdIssueIds);
        Assert.notEmpty(holdIssueIds);

        List<HoldIssueInfo> holdIssues = holdService.getHoldIssuesByIds(holdIssueIds, contextInfo);

        Assert.notNull(holdIssues);
        Assert.notEmpty(holdIssues);

        for ( HoldIssueInfo holdIssue : holdIssues ) {
            Assert.notNull(holdIssue);
            Assert.notNull(holdIssue.getId());
            Assert.notNull(holdIssue.getName());
            Assert.notNull(holdIssue.getTypeKey());
            Assert.notNull(holdIssue.getStateKey());
            Assert.notNull(holdIssue.getOrganizationId());
            Assert.notNull(holdIssue.getDescr());
            Assert.notNull(holdIssue.getDescr().getPlain());
            Assert.notNull(holdIssue.getMeta());
            Assert.notNull(holdIssue.getMeta().getCreateTime());
        }

    }

}
