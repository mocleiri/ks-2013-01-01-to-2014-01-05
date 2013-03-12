package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.GeneralLedgerForm;
import com.sigmasys.kuali.ksa.service.GeneralLedgerService;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 3/12/13
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class GeneralLedgerController extends DownloadController {

    @Autowired
    private GeneralLedgerService generalLedgerService;


    /**
     * Creates an initial form, which is the GeneralLedger page form.
     */
    @Override
    protected UifFormBase createInitialForm(HttpServletRequest request) {
        // Create a new form:
        GeneralLedgerForm form = new GeneralLedgerForm();

        return form;
    }

    /**
     * Displays the initial page.
     *
     * @param form GeneralLedger form.
     * @return ModelAndView for the initial page.
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=displayGeneralLedger")
    public ModelAndView displayGeneralLedger(@ModelAttribute("KualiForm") GeneralLedgerForm form) {
        return getUIFModelAndView(form);
    }

    /**
     * Searches for Prior Batches and displays them on the page.
     *
     * @param form GeneralLedger form.
     * @return ModelAndView for the page.
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=searchForPriorBatches")
    public ModelAndView searchForPriorBatches(@ModelAttribute("KualiForm") GeneralLedgerForm form) {
        // Find prior batches:

        // Set objects on the form:

        return getUIFModelAndView(form);
    }

    /**
     * Searches for GL Accounts that have Pending Transactions and displays them on the page.
     *
     * @param form GeneralLedger form.
     * @return ModelAndView for the page.
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=searchForPendingTransactions")
    public ModelAndView searchForPendingTransactions(@ModelAttribute("KualiForm") GeneralLedgerForm form) {
        // Find pending transactions:

        // Set objects on the form:

        return getUIFModelAndView(form);
    }

    /**
     * Exports all Pending Transactions to the General ledger.
     *
     * @param form  The form object.
     * @return         null because we want to stay on the same page.
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=exportAllPendingTransactions")
    public ModelAndView exportAllPendingTransactions (@ModelAttribute("KualiForm") GeneralLedgerForm form){
        // Retrieve a list of Pending Transactions for all GL Accounts:

        return null;
    }

    /**
     * Generates a list of Prior Batch Transactions for a GL Account and starts download.
     *
     *
     * @param form      The form object.
     * @param batchId   Batch ID.
     * @return          null because we want to stay on the same page when download starts.
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=downloadPriorBatchTransactions")
    public ModelAndView downloadPriorBatchTransactions(@ModelAttribute("KualiForm") GeneralLedgerForm form, @RequestParam("batchId") String batchId) {
        // Retrieve a list of Transactions for a Batch:

        return null;
    }

    /**
     * Retrieves a list of Pending Transactions for a GL Account. Used as an AJAX call handler.
     *
     * @param form          The form object.
     * @param glAccountId   GL Account ID.
     * @return              null for AJAX requests to stay on the same page.
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=getPendingTransactionForGlAccount")
    public ModelAndView getPendingTransactionForGlAccount(@ModelAttribute("KualiForm") GeneralLedgerForm form, @RequestParam("glAccountId") String glAccountId) {
        // Retrieve a list of Pending Transactions for a GL Account:

        return null;
    }

    /**
     * Retrieves a list of GL Accounts for a Batch. Used as an AJAX call handler.
     *
     * @param form      The form object.
     * @param batchId   Batch ID.
     * @return          null for AJAX requests to stay on the same page.
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=getGlAccountsForBatch")
    public ModelAndView getGlAccountsForBatch(@ModelAttribute("KualiForm") GeneralLedgerForm form, @RequestParam("batchId") String batchId) {
        // Retrieve a list of GL Accounts for a Batch:

        return null;
    }
}
