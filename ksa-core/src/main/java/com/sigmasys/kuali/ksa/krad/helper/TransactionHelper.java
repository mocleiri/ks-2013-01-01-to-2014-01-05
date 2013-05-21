package com.sigmasys.kuali.ksa.krad.helper;

import com.sigmasys.kuali.ksa.krad.form.TransactionTypeForm;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Tag;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.util.ContextUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.krad.uif.service.impl.ViewHelperServiceImpl;

import java.util.List;


public class TransactionHelper extends ViewHelperServiceImpl {

    protected final Log logger = LogFactory.getLog(getClass());

    private AccountService accountService;
    private AuditableEntityService auditableEntityService;

    private TransactionService transactionService;

    private TransactionTypeForm form;
    private List<Account> filteredByAccounts;

    public List<Account> getAccountsForSuggest(String suggest) {
        return getAccountService().getAccountsByNamePattern(suggest);
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
