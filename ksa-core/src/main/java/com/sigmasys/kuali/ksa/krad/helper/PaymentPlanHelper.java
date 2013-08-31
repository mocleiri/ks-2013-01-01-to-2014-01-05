package com.sigmasys.kuali.ksa.krad.helper;

import com.sigmasys.kuali.ksa.model.Tag;
import com.sigmasys.kuali.ksa.model.ThirdPartyAccount;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlan;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.tp.ThirdPartyTransferService;
import com.sigmasys.kuali.ksa.util.ContextUtils;
import org.kuali.rice.krad.uif.service.impl.ViewHelperServiceImpl;

import java.util.List;


public class PaymentPlanHelper extends ViewHelperServiceImpl {

    private AccountService accountService;
    private AuditableEntityService auditableEntityService;
    private ThirdPartyTransferService thirdPartyTransferService;

    public List<ThirdPartyAccount> getAccountsForSuggest(String suggest) {
        return getAccountService().getAccountsByNamePattern(suggest, ThirdPartyAccount.class);
    }

    public List<Tag> getTagsForSuggest(String suggest) {
        return getAuditableEntityService().getAuditableEntitiesByNamePattern(suggest, Tag.class);
    }

    public List<ThirdPartyPlan> getThirdPartyPlansForSuggest(String suggest) {
        return getThirdPartyTransferService().getThirdPartyPlanByNamePattern(suggest);
    }

    private AccountService getAccountService() {
        if (accountService == null) {
            accountService = ContextUtils.getBean(AccountService.class);
        }
        return accountService;
    }

    private AuditableEntityService getAuditableEntityService() {
        if (auditableEntityService == null) {
            auditableEntityService = ContextUtils.getBean(AuditableEntityService.class);
        }
        return auditableEntityService;
    }

    private ThirdPartyTransferService getThirdPartyTransferService() {
        if (thirdPartyTransferService == null) {
            thirdPartyTransferService = ContextUtils.getBean(ThirdPartyTransferService.class);
        }
        return thirdPartyTransferService;
    }

}
