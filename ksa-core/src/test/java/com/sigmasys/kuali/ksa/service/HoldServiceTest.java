package com.sigmasys.kuali.ksa.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.RichTextInfo;
import org.kuali.student.r2.core.hold.dto.AppliedHoldInfo;
import org.kuali.student.r2.core.hold.dto.HoldIssueInfo;
import org.kuali.student.r2.core.hold.service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * KS Hold service tests.
 *
 * @author Michael Ivanov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class HoldServiceTest extends AbstractServiceTest {

    private static final String[] holdIssueTypes = {
            "kuali.hold.issue.type.library",
            "kuali.hold.issue.type.financial",
            "kuali.hold.issue.type.discipline"
    };

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
    public void getHoldIssuesByType1() throws Exception {

        for (String holdIssueType : holdIssueTypes) {

            List<String> holdIssueIds = holdService.getHoldIssueIdsByType(holdIssueType, contextInfo);

            Assert.notNull(holdIssueIds);
            Assert.notEmpty(holdIssueIds);

            List<HoldIssueInfo> holdIssues = holdService.getHoldIssuesByIds(holdIssueIds, contextInfo);

            Assert.notNull(holdIssues);
            Assert.notEmpty(holdIssues);

            for (HoldIssueInfo holdIssue : holdIssues) {
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

    @Test
    public void getHoldIssuesByType2() throws Exception {

        for (String holdIssueType : holdIssueTypes) {

            List<String> holdIssueIds = holdService.getHoldIssueIdsByType(holdIssueType, contextInfo);

            Assert.notNull(holdIssueIds);
            Assert.notEmpty(holdIssueIds);

            for (String holdIssueId : holdIssueIds) {
                HoldIssueInfo holdIssue = holdService.getHoldIssue(holdIssueId, contextInfo);
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

    @Test
    public void getHoldIssuesByOrgId() throws Exception {

        final String[] organizationIds = {"1", "94"};

        for (String organizationId : organizationIds) {

            List<HoldIssueInfo> holdIssues = holdService.getHoldIssuesByOrg(organizationId, contextInfo);

            Assert.notNull(holdIssues);
            Assert.notEmpty(holdIssues);

            for (HoldIssueInfo holdIssue : holdIssues) {
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

    @Test
    public void createHoldIssue() throws Exception {

        for (String holdIssueType : holdIssueTypes) {

            HoldIssueInfo holdIssue = new HoldIssueInfo();
            holdIssue.setTypeKey(holdIssueType);
            holdIssue.setStateKey("kuali.hold.issue.state.active");
            holdIssue.setName("Test issue");
            holdIssue.setOrganizationId("2");
            holdIssue.setDescr(new RichTextInfo("Plain description", "Formatted description"));

            holdService.createHoldIssue(holdIssueType, holdIssue, contextInfo);
        }

    }

    @Test
    public void createAppliedHold() throws Exception {

        for (String holdIssueType : holdIssueTypes) {

            List<String> holdIssueIds = holdService.getHoldIssueIdsByType(holdIssueType, contextInfo);

            Assert.notNull(holdIssueIds);
            Assert.notEmpty(holdIssueIds);

            for (String holdIssueId : holdIssueIds) {

                HoldIssueInfo holdIssue = holdService.getHoldIssue(holdIssueId, contextInfo);

                AppliedHoldInfo hold = new AppliedHoldInfo();
                hold.setHoldIssueId(holdIssueId);
                hold.setPersonId("admin");
                hold.setTypeKey(holdIssue.getTypeKey());
                hold.setStateKey("kuali.hold.issue.state.active");
                hold.setName("Test applied hold");
                hold.setEffectiveDate(new Date());
                hold.setReleasedDate(new Date(new Date().getTime() + 50 * 1000));
                hold.setDescr(new RichTextInfo("Plain description", "Formatted description"));

                holdService.createAppliedHold(hold.getPersonId(), hold.getHoldIssueId(),
                        hold.getTypeKey(), hold, contextInfo);

            }
        }
    }


}
