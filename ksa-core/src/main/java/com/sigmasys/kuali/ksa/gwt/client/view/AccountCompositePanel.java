package com.sigmasys.kuali.ksa.gwt.client.view;


import com.sigmasys.kuali.ksa.gwt.client.model.AccountModel;
import com.sigmasys.kuali.ksa.gwt.client.model.NavigationContext;

/**
 * AccountCompositePanel
 *
 * @author ivanovm
 */
public class AccountCompositePanel extends AbstractCompositePanel<AccountModel> {

    public AccountCompositePanel() {
        this(NavigationContext.getDefaultContext());
    }

    public AccountCompositePanel(NavigationContext context) {
        super(
                new AccountSearchPanel(context),
                new AccountListPanel(context),
                new AccountDetailsPanel(),
                300,
                300,
                350,
                context != null && context.getSearchCriteria() != null
        );
    }
}
