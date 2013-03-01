package com.sigmasys.kuali.ksa.gwt.client.view;

import com.sigmasys.kuali.ksa.gwt.client.model.NavigationContext;
import com.sigmasys.kuali.ksa.gwt.client.model.TransactionModel;

/**
 * User: dmulderink
 * Date: 5/14/12
 * Time: 9:26 AM
 */
public class TransactionCompositePanel extends AbstractCompositePanel<TransactionModel> {

    public TransactionCompositePanel() {
        this(NavigationContext.getDefaultContext());
    }

    public TransactionCompositePanel(NavigationContext context) {
        super(
                new TransactionSearchPanel(context),
                new TransactionListPanel(context),
                new TransactionDetailsPanel(),
                300,
                300,
                350,
                context != null && context.getSearchCriteria() != null
        );
    }
}
