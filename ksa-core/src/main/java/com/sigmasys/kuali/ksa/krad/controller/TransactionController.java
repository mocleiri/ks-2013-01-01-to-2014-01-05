package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.TransactionForm;
import com.sigmasys.kuali.ksa.krad.model.TransactionModel;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;

import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.util.TransactionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping(value = "/transactionView")
public class TransactionController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(TransactionController.class);

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private InformationService informationService;


    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected TransactionForm createInitialForm(HttpServletRequest request) {
        return new TransactionForm();
    }


    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=save")
    public ModelAndView save(@ModelAttribute("KualiForm") TransactionForm form) {
        auditableEntityService.persistAuditableEntity(form.getCurrency());
        return getUIFModelAndView(form);
    }


    /**
     * @param form
     * @param request
     * @return
     */
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView get(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {

        // just for the transactions by person page
        String pageId = request.getParameter("pageId");
        if (pageId == null) {
            pageId = "ViewTransactions";
        }

        String userId = request.getParameter("userId");
        //if(userId == null){
        //    userId = request.getParameter("actionParameters[userId]");
        //}

        if (userId == null) {
            // Error out here
            form.setStatusMessage("No userId passed to method");
            return getUIFModelAndView(form);
        }
        form.setAccount(accountService.getFullAccount(userId));

        if ("ViewTransactions".equals(pageId)) {
            form.setAlerts(informationService.getAlerts(userId));
            form.setFlags(informationService.getFlags(userId));

            Date startDate = form.getStartingDate();
            Date endDate = form.getEndingDate();

            Date actualStartDate = startDate;
            Date actualEndDate = endDate;

            // All transactions
            List<Transaction> transactions = TransactionUtils.orderByEffectiveDate(transactionService.getTransactions(userId, startDate, endDate), true);
            List<TransactionModel> models = new ArrayList<TransactionModel>(transactions.size());
            for (Transaction t : transactions) {
                Date effectiveDate = t.getEffectiveDate();
                if(actualStartDate == null || (effectiveDate.before(actualStartDate))){
                    actualStartDate = effectiveDate;
                }
                if(actualEndDate == null || (effectiveDate.after(actualEndDate))){
                    actualEndDate = effectiveDate;
                }

                TransactionModel m = new TransactionModel(t);

                // Set the list of allocations
                m.setAllocations(transactionService.getAllocations(t.getId()));

                // Add the memos
                m.setMemos(informationService.getMemos(t.getId()));
                models.add(m);

                // Add appropriate Alerts
                for (Alert a : form.getAlerts()) {
                    Transaction alertTransaction = a.getTransaction();
                    if (alertTransaction != null && alertTransaction.getId().equals(t.getId())) {
                        m.addAlert(a);
                    }
                }

                // Add appropriate flags
                for (Flag f : form.getFlags()) {
                    Transaction flagTransaction = f.getTransaction();
                    if (flagTransaction != null && flagTransaction.getId().equals(t.getId())) {
                        m.addFlag(f);
                    }
                }
            }

            if(startDate == null){
                form.setStartingDate(actualStartDate);
            }
            if(endDate == null){
                form.setEndingDate(actualEndDate);
            }
            this.populateRollups(form, models);


        } else if ("ViewAlerts".equals(pageId)) {
            form.setAlerts(informationService.getAlerts(userId));
        } else if ("ViewFlags".equals(pageId)) {
            form.setFlags(informationService.getFlags(userId));
        } else if ("ViewMemos".equals(pageId)) {
            form.setMemos(informationService.getMemos(userId));
        }


        ModelAndView mv = getUIFModelAndView(form);

        return mv;
    }


    private void populateRollups(TransactionForm form, List<TransactionModel> transactions) {
        List<TransactionModel> rollUpTransactionModelList = new ArrayList<TransactionModel>();
        List<TransactionModel> unGroupedTransactionModelList = new ArrayList<TransactionModel>();
        List<TransactionModel> defermentModelList = new ArrayList<TransactionModel>();

        TransactionModel nonRolledUp = null;

        BigDecimal balance = form.getStartingBalance();

        // Assuming that transactions are already passed into this method sorted in the proper way for the running balance.
        for (TransactionModel t : transactions) {
            Transaction parentTransaction = t.getParentTransaction();
            BigDecimal amount = parentTransaction.getAmount();
            BigDecimal allocated = parentTransaction.getAllocatedAmount();
            if(allocated == null){
                allocated = BigDecimal.ZERO;
            }

            BigDecimal unallocated = parentTransaction.getUnallocatedAmount();

            if(parentTransaction instanceof Deferment){
                defermentModelList.add(t);
                form.addDefermentTotal(amount);
                continue;
            }

            BigDecimal locked = parentTransaction.getLockedAllocatedAmount();
            if(locked == null){
                locked = BigDecimal.ZERO;
            }

            if (t.getParentTransaction() instanceof Charge) {
                form.addChargeTotal(amount);
                balance = balance.add(amount);
                form.addAllocatedTotal(allocated);
                form.addAllocatedTotal(locked);
                form.addUnallocatedTotal(unallocated);
            } else {
                parentTransaction.setAllocatedAmount(BigDecimal.ZERO.subtract(allocated));
                parentTransaction.setLockedAllocatedAmount(BigDecimal.ZERO.subtract(locked));

                form.addPaymentTotal(amount);
                form.subtractAllocatedTotal(allocated);
                form.subtractAllocatedTotal(locked);
                form.subtractUnallocatedTotal(unallocated);

                balance = balance.subtract(allocated).subtract(locked);

            }
            t.setRunningBalance(balance);
            unGroupedTransactionModelList.add(t);

            Rollup tmRollup = t.getRollup();
            if (tmRollup != null) {
                // Check if this rollup is already in there.
                boolean found = false;
                for (TransactionModel m : rollUpTransactionModelList) {
                    Rollup r = m.getRollup();
                    if (r.getId().equals(tmRollup.getId())) {
                        m.addSubTransaction(t);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    TransactionModel tm = new TransactionModel();
                    tm.setRollup(tmRollup);

                    rollUpTransactionModelList.add(tm);
                    tm.addSubTransaction(t);
                }
            } else {
                if (nonRolledUp == null) {
                    Rollup r = new Rollup();
                    r.setName("Other Transactions not in a Roll-up");

                    nonRolledUp = new TransactionModel();
                    nonRolledUp.setRollup(r);
                }
                nonRolledUp.addSubTransaction(t);
            }

        }
        form.setEndingBalance(balance);

        if (nonRolledUp != null) {
            rollUpTransactionModelList.add(nonRolledUp);
        }

        form.setRollupTransactions(rollUpTransactionModelList);
        form.setAllTransactions(unGroupedTransactionModelList);
        form.setDeferments(defermentModelList);
    }

}
