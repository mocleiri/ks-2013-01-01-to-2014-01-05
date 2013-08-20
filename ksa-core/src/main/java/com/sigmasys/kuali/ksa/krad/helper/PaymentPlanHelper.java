package com.sigmasys.kuali.ksa.krad.helper;

import com.sigmasys.kuali.ksa.model.Tag;
import com.sigmasys.kuali.ksa.model.ThirdPartyAccount;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.util.ContextUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.krad.uif.service.impl.ViewHelperServiceImpl;

import java.util.List;


public class PaymentPlanHelper extends ViewHelperServiceImpl {

    protected final Log logger = LogFactory.getLog(getClass());

    private AccountService accountService;
    private AuditableEntityService auditableEntityService;

    public List<ThirdPartyAccount> getAccountsForSuggest(String suggest) {
        List<ThirdPartyAccount> accounts = getAccountService().getAccountsByNamePattern(suggest, ThirdPartyAccount.class);
        return accounts;
    }

    public List<Tag> getTagsForSuggest(String suggest) {
        return getAuditableEntityService().getAuditableEntitiesByNamePattern(suggest, Tag.class);
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

}
