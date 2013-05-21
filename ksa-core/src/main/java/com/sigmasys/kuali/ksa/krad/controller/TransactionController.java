package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.TransactionForm;
import com.sigmasys.kuali.ksa.krad.model.TransactionModel;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.PaymentService;
import com.sigmasys.kuali.ksa.service.RefundService;
import com.sigmasys.kuali.ksa.util.TransactionUtils;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping(value = "/transactionView")
public class TransactionController extends GenericSearchController {

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RefundService refundService;


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
     * @param form    TransactionForm
     * @param request HttpServletRequest
     * @return ModelAndView
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView get(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {

        //long debugStart = System.currentTimeMillis();

        // just for the transactions by person page
        String pageId = request.getParameter("pageId");
        if (pageId == null) {
            pageId = "ViewTransactions";
        }

        String userId = request.getParameter("userId");

        if (userId == null) {
            // Error out here
            form.setStatusMessage("No userId passed to method");
            return getUIFModelAndView(form);
        }
        form.setAccount(accountService.getFullAccount(userId));

        if ("ViewTransactions".equals(pageId) || "RollUpTransactions".equals(pageId) || "RunningBalanceTransactions".equals(pageId)) {

            populateForm(form);


        } else if ("ViewAlerts".equals(pageId)) {
            form.setAlerts(informationService.getAlerts(userId));
        } else if ("ViewFlags".equals(pageId)) {
            form.setFlags(informationService.getFlags(userId));
        } else if ("ViewMemos".equals(pageId)) {
            form.setMemos(informationService.getMemos(userId));
        }

        return getUIFModelAndView(form);
    }

    /**
     *
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=filterTags")
    public ModelAndView filterTags(@ModelAttribute("KualiForm") TransactionForm form) {
        String newTag = form.getNewTag();
        Tag tag = auditableEntityService.getAuditableEntity(newTag, Tag.class);
        List<Tag> tags = form.getFilterTags();
        if(tags == null){
            tags = new ArrayList<Tag>();
            form.setFilterTags(tags);
        }
        if(tag != null){
            tags.add(tag);
        }

        form.setNewTag("");
        populateForm(form);
        return getUIFModelAndView(form);
    }

    /**
     *
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=removeTag")
    public ModelAndView removeTag(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {

        String tagString = request.getParameter("actionParameters[tagId]");
        Long tagId = Long.parseLong(tagString);
        if (tagId != null) {
            Tag tag = auditableEntityService.getAuditableEntity(tagId, Tag.class);

            List<Tag> tags = form.getFilterTags();
            if(tags == null){
                tags = new ArrayList<Tag>();
                form.setFilterTags(tags);
            }
            if(tag != null){
                boolean removed = tags.remove(tag);
                logger.info("Removed tag id: " + tagString + " - " + removed);
                form.setFilterTags(tags);
            }

            form.setNewTag("");
        }
        populateForm(form);
        return getUIFModelAndView(form);
    }

    private void populateForm(TransactionForm form) {
        Account act = form.getAccount();
        String userId = "";
        if(act != null){
            userId = act.getId();
        } else {
            form.setStatusMessage("No account in form");
            return;
        }

        form.setAlerts(informationService.getAlerts(userId));
        form.setFlags(informationService.getFlags(userId));

        Date startDate = form.getStartingDate();
        Date endDate = form.getEndingDate();

        Date actualStartDate = startDate;
        Date actualEndDate = endDate;

        form.setStartingBalance(accountService.getBalance(userId, startDate));

        form.setChargeTotal(BigDecimal.ZERO);
        form.setPaymentTotal(BigDecimal.ZERO);
        form.setDefermentTotal(BigDecimal.ZERO);
        form.setAllocatedTotal(BigDecimal.ZERO);
        form.setUnallocatedTotal(BigDecimal.ZERO);

        // All transactions
        List<Transaction> transactions = transactionService.getTransactions(userId, startDate, endDate);

        List<Tag> tags = form.getFilterTags();

        if(tags != null && tags.size() > 0){
            transactions = TransactionUtils.filterByTag(transactions, tags);
        }

        transactions = TransactionUtils.orderByEffectiveDate(transactions, true);

        List<TransactionModel> models = new ArrayList<TransactionModel>(transactions.size());
        for (Transaction t : transactions) {
            Date effectiveDate = t.getEffectiveDate();
            if (actualStartDate == null || (effectiveDate.before(actualStartDate))) {
                actualStartDate = effectiveDate;
            }
            if (actualEndDate == null || (effectiveDate.after(actualEndDate))) {
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

        if (startDate == null) {
            form.setStartingDate(actualStartDate);
        }
        if (endDate == null) {
            form.setEndingDate(actualEndDate);
        }
        this.populateRollups(form, models);
    }


    /**
     * perform Payment Application.
     *
     * @param form Kuali form instance
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=paymentApplication")
    public ModelAndView paymentApplication(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {

        String accountId = request.getParameter("userId");

        if (accountId != null && !accountId.trim().isEmpty()) {
            paymentService.paymentApplication(accountId);

            form.setStatusMessage("Payments successfully applied");

        }

        Properties props = new Properties();
        String refreshLocation = request.getParameter("refresh");
        if (refreshLocation == null) {
            refreshLocation = "transactionView";
        }

        if (refreshLocation.equals("quickView")) {
            props.put("viewId", "QuickView");

        } else {
            props.put("pageId", "ViewTransactions");
            props.put("viewId", "TransactionView");
        }
        props.put("methodToCall", "get");
        props.put("userId", accountId);

        return performRedirect(form, refreshLocation, props);
    }

    /**
     * Attempt a refund on a transaction
     *
     * @param form Kuali form instance
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=refund")
    public ModelAndView refund(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {

        Long transactionId;
        String errorMessage = "";

        try {

            transactionId = new Long(request.getParameter("transactionId"));

        } catch (NumberFormatException e) {
            // Error here
            errorMessage = "Invalid Payment";
            //GlobalVariables.getMessageMap().putError("refundLightbox", RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            form.setMessage(errorMessage);

            return getUIFModelAndView(form);

        }


        // Need to loop through the transactions and find the one that matches this transaction id to make sure
        // it is a payment and get the amount (if any)

        BigDecimal amount = null;
        Payment payment = null;
        TransactionModel model = null;

        for (TransactionModel t : form.getAllTransactions()) {
            if (t.getParentTransaction().getId().equals(transactionId)) {
                model = t;
                if (t.getTransactionTypeValue().equals(TransactionTypeValue.PAYMENT)) {
                    payment = (Payment) t.getParentTransaction();
                    amount = t.getRefundAmount();
                } else {
                    // error here, Refunds must occur on payments
                    errorMessage = "Refunds can only apply to payments";
                    //GlobalVariables.getMessageMap().putError("refundLightbox_line0", RiceKeyConstants.ERROR_CUSTOM, errorMessage);
                    t.setMessage(errorMessage);
                    return getUIFModelAndView(form);
                }
            }
        }
        if (model == null) {
            // The row isn't in the collection at all.  Something major happened.
            errorMessage = "Invalid Transaction ID";
            GlobalVariables.getMessageMap().putError("TransactionView", RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            return getUIFModelAndView(form);
        }
        try {
            Refund refund = refundService.checkForRefund(transactionId, amount);
            String success = "Refund saved";
            //GlobalVariables.getMessageMap().putInfo("refundLightbox", RiceKeyConstants.ERROR_CUSTOM, success);
            model.setMessage(success);

        } catch (RuntimeException e) {
            errorMessage = e.getMessage();
            //GlobalVariables.getMessageMap().putError("refundLightbox", RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            model.setMessage(errorMessage);
        }

        return getUIFModelAndView(form);
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
            if (allocated == null) {
                allocated = BigDecimal.ZERO;
            }

            BigDecimal unallocated = parentTransaction.getUnallocatedAmount();

            if (parentTransaction instanceof Deferment) {
                defermentModelList.add(t);
                form.addDefermentTotal(amount);
                continue;
            }

            BigDecimal locked = parentTransaction.getLockedAllocatedAmount();
            if (locked == null) {
                locked = BigDecimal.ZERO;
            }

            if (t.getParentTransaction() instanceof Charge) {
                form.addChargeTotal(amount);
                balance = balance.add(amount);
                form.addAllocatedTotal(allocated);
                form.addAllocatedTotal(locked);
                form.addUnallocatedTotal(unallocated);
            } else {

                // TODO: ??????
                //parentTransaction.setAllocatedAmount(BigDecimal.ZERO.subtract(allocated));
                //parentTransaction.setLockedAllocatedAmount(BigDecimal.ZERO.subtract(locked));

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
