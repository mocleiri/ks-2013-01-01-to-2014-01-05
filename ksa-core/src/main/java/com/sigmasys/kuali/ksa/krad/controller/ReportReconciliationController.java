package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.ReportReconciliationForm;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Transaction;
import com.sigmasys.kuali.ksa.service.GeneralLedgerService;
import com.sigmasys.kuali.ksa.service.TransactionExportService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by: dmulderink on 10/6/12 at 2:24 PM
 */
@Controller
@RequestMapping(value = "/reportReconciliationView")
public class ReportReconciliationController extends DownloadController {

    private static final Log logger = LogFactory.getLog(ReportReconciliationController.class);

    @Autowired
    protected GeneralLedgerService generalLedgerService;

    @Autowired
    protected TransactionExportService transactionExportService;


    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected ReportReconciliationForm createInitialForm(HttpServletRequest request) {
        ReportReconciliationForm form = new ReportReconciliationForm();
        String userId = request.getParameter("userId");

        if (userId != null) {

            Account account = accountService.getFullAccount(userId);

            if (account == null) {
                String errMsg = "Cannot find Account by ID = " + userId;
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }

            form.setAccount(account);
        } /*else {
           String errMsg = "'userId' request parameter cannot be null";
           logger.error(errMsg);
           throw new IllegalStateException(errMsg);
        }*/

        return form;
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") ReportReconciliationForm form) {
        return getUIFModelAndView(form);
    }


    /**
     * Exports all Pending Transactions to the General ledger.
     *
     * @param form The form object.
     * @return The page's form.
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, params = "methodToCall=exportAllPendingTransactions")
    public ModelAndView exportAllPendingTransactions(@ModelAttribute("KualiForm") ReportReconciliationForm form) {

        // Call the service to export all pending transactions:
        transactionExportService.exportTransactions();

        return getUIFModelAndView(form);
    }

    /**
     * Makes all KSA Transactions effective.
     *
     * @param form The form object.
     * @return The page's form.
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, params = "methodToCall=makeTransactionsEffective")
    public ModelAndView makeTransactionsEffective(@ModelAttribute("KualiForm") ReportReconciliationForm form) {
        try {
            // Get all KSA Transactions:
            List<Transaction> transactions = transactionService.getTransactions();
            Date today = new Date();

            for (Transaction t : transactions) {
                // Make the Transaction effective:
                if (!t.isGlEntryGenerated() && t.getEffectiveDate().before(today)) {
                    logger.info("Calling 'makeEffective' for ID: " + t.getId());
                    transactionService.makeEffective(t.getId(), false);
                }
            }
        } catch (Exception e) {
            return handleError(form, e);
        }

        return getUIFModelAndView(form);
    }
}
