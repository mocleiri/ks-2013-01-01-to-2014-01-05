package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.AbstractViewModel;
import com.sigmasys.kuali.ksa.model.SearchTypeValue;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import org.kuali.rice.krad.web.controller.UifControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * GenericSearchController
 *
 * @author Michael Ivanov
 */
@Transactional
public abstract class GenericSearchController extends UifControllerBase {

    private static final String ACCOUNT_SEARCH_PAGE_ID = "AccountSearchPage";
    private static final String TRANSACTION_SEARCH_PAGE_ID = "TransactionSearchPage";


    @Autowired
    protected AccountService accountService;

    @Autowired
    protected TransactionService transactionService;


    /**
     * This method can search for entities of different types specified by "searchType" and "searchValue" parameters
     *
     * @param form KSA form
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=searchByType")
    public ModelAndView searchByType(@ModelAttribute("KualiForm") AbstractViewModel form) {

        String searchType = form.getSearchType();
        if (searchType == null || searchType.isEmpty()) {
            throw new IllegalStateException("Search type is null");
        }

        String searchValue = form.getSearchValue();
        if (searchValue == null) {
            searchValue = "";
        }

        SearchTypeValue searchTypeValue = SearchTypeValue.valueOf(searchType);
        switch (searchTypeValue) {
            case ACCOUNT:
                form.setAccounts(accountService.findAccountsByNamePattern(searchValue));
                form.setPageId(ACCOUNT_SEARCH_PAGE_ID);
                break;
            case TRANSACTION:
                form.setTransactions(transactionService.findTransactionsByStatementPattern(searchValue));
                form.setPageId(TRANSACTION_SEARCH_PAGE_ID);
                break;
            default:
                throw new IllegalStateException("Search type '" + searchTypeValue + "' is not supported");
        }

        return getUIFModelAndView(form);
    }


}
