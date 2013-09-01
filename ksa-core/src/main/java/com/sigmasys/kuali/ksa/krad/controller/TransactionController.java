package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.config.ConfigService;
import com.sigmasys.kuali.ksa.krad.form.TransactionForm;
import com.sigmasys.kuali.ksa.krad.model.AllocationModel;
import com.sigmasys.kuali.ksa.krad.model.InformationModel;
import com.sigmasys.kuali.ksa.krad.model.TransactionModel;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.PaymentService;
import com.sigmasys.kuali.ksa.service.RefundService;
import com.sigmasys.kuali.ksa.util.TransactionUtils;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.hold.dto.AppliedHoldInfo;
import org.kuali.student.r2.core.hold.service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/transactionView")
public class TransactionController extends GenericSearchController {

    private static final String TRANSACTION_VIEW = "TransactionView";
    private static final String ALLOCATE_TRANSACTION_PAGE = "AllocateTransactionPage";
    private static final String FILTER_TAG_FIELD = "transactionPageFilterTags";

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RefundService refundService;

    @Autowired
    private ConfigService configService;

    @Autowired
    private HoldService holdService;

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected TransactionForm createInitialForm(HttpServletRequest request) {
        TransactionForm form = new TransactionForm();

        String start = configService.getParameter(Constants.KSA_TRANSACTION_DEFAULT_START_DATE);
        String end = configService.getParameter(Constants.KSA_TRANSACTION_DEFAULT_END_DATE);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            form.setStartingDate(sdf.parse(start));
            form.setEndingDate(sdf.parse(end));
        } catch(Exception e){
            //log it but no big deal, the code will still work
            logger.error("Error parsing configuration parameters for transaction start and end dates.", e);
        }

        return form;
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
            form.setAlertObjects(informationService.getAlerts(userId));
        } else if ("ViewFlags".equals(pageId)) {
            form.setFlagObjects(informationService.getFlags(userId));
        } else if ("ViewMemos".equals(pageId)) {
            form.setMemos(informationService.getMemos(userId));
        } else if ("ViewHolds".equals(pageId)) {
            form.setHolds(this.getHolds(userId));
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=filterTags")
    public ModelAndView filterTags(@ModelAttribute("KualiForm") TransactionForm form) {
        String newTag = form.getNewTag();

        Tag tag = auditableEntityService.getAuditableEntity(newTag, Tag.class);

        if(tag == null) {
            List<Tag> searchTags = auditableEntityService.getAuditableEntitiesByNamePattern(newTag, Tag.class);

            if(searchTags.size() == 0) {
                String errorMessage = "'" + newTag + "' is not a valid tag";
                GlobalVariables.getMessageMap().putError(FILTER_TAG_FIELD, RiceKeyConstants.ERROR_CUSTOM, errorMessage);
                return getUIFModelAndView(form);
            } else if(searchTags.size() > 1) {
                String errorMessage = "'" + newTag + "' matches multiple tags, please select one tag at a time to add";
                GlobalVariables.getMessageMap().putError(FILTER_TAG_FIELD, RiceKeyConstants.ERROR_CUSTOM, errorMessage);
                return getUIFModelAndView(form);
            }

            // There can be only one
            tag = searchTags.get(0);

        }

        List<Tag> tags = form.getFilterTags();
        if (tags == null) {
            tags = new ArrayList<Tag>();
            form.setFilterTags(tags);
        }
        if (tag != null) {
            tags.add(tag);
        }

        form.setNewTag("");
        populateForm(form);
        return getUIFModelAndView(form);
    }

    /**
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
            if (tags == null) {
                tags = new ArrayList<Tag>();
                form.setFilterTags(tags);
            }
            if (tag != null) {

                this.removeTag(tags, tag);
                form.setFilterTags(tags);
            }

            form.setNewTag("");
        }
        populateForm(form);
        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=removeTransactionTag")
    public ModelAndView removeTransactionTag(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {
        String tagString = request.getParameter("actionParameters[tagId]");
        String transactionIdString = request.getParameter("actionParameters[currentTagParent]");


        Long tagId = Long.parseLong(tagString);
        Long transactionId;
        try {
            transactionId = Long.parseLong(transactionIdString);
        } catch (NumberFormatException e) {
            String errorMessage = "Unable to find a transaction with the id '" + transactionIdString + "'";
            GlobalVariables.getMessageMap().putError(TRANSACTION_VIEW, RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            return getUIFModelAndView(form);
        }

        if (tagId != null && transactionId != null) {
            transactionService.removeTagsFromTransaction(transactionId, tagId);
            String message = "Tag removed from transaction";
            GlobalVariables.getMessageMap().putInfo(TRANSACTION_VIEW, RiceKeyConstants.ERROR_CUSTOM, message);

        }
        populateForm(form);
        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=addTransactionTag")
    public ModelAndView addTransactionTag(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {
        String transactionIdString = request.getParameter("actionParameters[currentParent]");

        Long transactionId;
        try {
            transactionId = Long.parseLong(transactionIdString);
        } catch (NumberFormatException e) {
            logger.error("Invalid transaction id passed to addTransactionTag: '" + transactionIdString + "'");
            return getUIFModelAndView(form);
        }

        // Need to loop through the form's 'allTransactions' to figure out which one we're talking about.
        for (TransactionModel tm : form.getAllTransactions()) {
            if (tm.getId().equals(transactionId)) {
                String tagString = tm.getNewTag();

                Tag tag = auditableEntityService.getAuditableEntity(tagString, Tag.class);
                List<Tag> tags = new ArrayList<Tag>();
                if (tag != null) {
                    tags.add(tag);
                    transactionService.addTagsToTransaction(transactionId, tags);
                }
                break;
            }
        }

        populateForm(form);
        return getUIFModelAndView(form);
    }

    private void populateForm(TransactionForm form) {
        Account act = form.getAccount();
        String userId = "";
        if (act != null) {
            userId = act.getId();
        } else {
            form.setStatusMessage("No account in form");
            return;
        }

        form.setAlertObjects(informationService.getAlerts(userId));
        form.setFlagObjects(informationService.getFlags(userId));
        form.setHolds(this.getHolds(userId));

        Boolean showInternal = form.getShowInternal();
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

        if (tags != null && tags.size() > 0) {
            transactions = TransactionUtils.filterByTags(transactions, tags);
        }

        transactions = TransactionUtils.orderByEffectiveDate(transactions, true);

        List<TransactionModel> models = new ArrayList<TransactionModel>(transactions.size());
        for (Transaction t : transactions) {
            if(!showInternal && t.isInternal()){
                continue;
            }

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
            for (InformationModel im : form.getAlerts()) {
                Alert a = (Alert) im.getParentEntity();
                Transaction alertTransaction = a.getTransaction();
                if (alertTransaction != null && alertTransaction.getId().equals(t.getId())) {
                    m.addAlert(a);
                }
            }

            // Add appropriate flags
            for (InformationModel im : form.getFlags()) {
                Flag f = (Flag) im.getParentEntity();
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

    /**
     * perform Payment Application.
     *
     * @param form Kuali form instance
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=removeAllocation")
    public ModelAndView removeAllocation(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {

        String transactionIdString = request.getParameter("actionParameters[transactionId]");
        String allocationIdString = request.getParameter("actionParameters[allocationId]");
        String lockedString = request.getParameter("actionParameters[locked]");

        Boolean locked = Boolean.parseBoolean(lockedString);


        String errorMessage = "";
        Long transactionId;
        Long allocationId;
        try {
            transactionId = Long.parseLong(transactionIdString);
            allocationId = Long.parseLong(allocationIdString);
        } catch (NumberFormatException e) {
            errorMessage = "Invalid ID passed to removeAllocation";
            GlobalVariables.getMessageMap().putError("transactionView", RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            return getUIFModelAndView(form);
        }

        if (locked) {
            // Save the memo attached to this.
            if (this.saveAllocationMemos(form, transactionId, allocationId)) {
                transactionService.removeLockedAllocation(transactionId, allocationId);
            } else {
                errorMessage = "Memo is required for locked allocations";
                GlobalVariables.getMessageMap().putError("TransactionView", RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            }
        } else {
            transactionService.removeAllocation(transactionId, allocationId);
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
        props.put("userId", form.getAccount().getId());

        return performRedirect(form, refreshLocation, props);
    }

    /**
     * Load the information needed for the allocation form
     *
     * @param form Kuali form instance
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=allocate")
    public ModelAndView allocate(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {

        String transactionIdString = request.getParameter("actionParameters[transactionId]");
        Long transactionId = Long.parseLong(transactionIdString);

        String userId = form.getAccount().getId();

        Transaction t = transactionService.getTransaction(transactionId);

        if (!t.getAccount().getId().equals(form.getAccount().getId())) {
            // This should never happen unless someone is messing with the URL and trying to see things
            throw new IllegalStateException("Transaction ID and User ID do not match: " + t.getAccount().getId() + " " + userId);
        }

        TransactionModel tm = new TransactionModel(t);
        form.setCurrentTransaction(tm);

        List<TransactionModel> allocations = this.getPossibleAllocations(userId, t);
        logger.info("Potential allocations size: " + allocations.size());
        form.setCurrrentTransactionAllocations(allocations);

        form.setPageId(ALLOCATE_TRANSACTION_PAGE);

        return getUIFModelAndView(form);
    }

    /**
     * Save the information from the allocation form
     *
     * @param form Kuali form instance
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=allocateTransaction")
    public ModelAndView allocateTransaction(@ModelAttribute("KualiForm") TransactionForm form, HttpServletRequest request) {

        TransactionModel currentTransaction = form.getCurrentTransaction();
        Transaction parent = currentTransaction.getParentTransaction();

        if (parent == null) {
            String statusMsg = "Unknown transaction.  Unable to process allocations.";
            GlobalVariables.getMessageMap().putError("", RiceKeyConstants.ERROR_CUSTOM, statusMsg);
            logger.error(statusMsg);

            return getUIFModelAndView(form);
        }

        BigDecimal total = BigDecimal.ZERO;

        List<TransactionModel> allocations = form.getCurrrentTransactionAllocations();
        for (TransactionModel model : allocations) {
            BigDecimal amount = model.getNewAllocation();

            if (amount != null) {
                if (amount.compareTo(model.getUnallocatedAmount()) > 0) {
                    String statusMsg = "Allocation amount of " + amount + " cannot be greater than the unallocated amount of " + model.getUnallocatedAmount() + " for " + model.getParentTransaction().getTransactionType().getDescription();
                    GlobalVariables.getMessageMap().putError(TRANSACTION_VIEW, RiceKeyConstants.ERROR_CUSTOM, statusMsg);
                }
                total = total.add(amount);
            }
        }

        // Total of allocations can't be greater than the payment amount
        if (total.compareTo(parent.getAmount()) > 0) {
            String statusMsg = "Allocations cannot add up to more than the payment amount";
            GlobalVariables.getMessageMap().putError(TRANSACTION_VIEW, RiceKeyConstants.ERROR_CUSTOM, statusMsg);
            logger.error(statusMsg);

            return getUIFModelAndView(form);
        }

        if (!GlobalVariables.getMessageMap().hasErrors()) {
            for (TransactionModel model : allocations) {
                BigDecimal amount = model.getNewAllocation();
                if (amount != null && (amount.compareTo(BigDecimal.ZERO) > 0)) {
                    transactionService.createLockedAllocation(parent.getId(), model.getParentTransaction().getId(), amount);
                }
            }

            String userId = form.getAccount().getId();
//            paymentService.paymentApplication(userId);
            List<TransactionModel> models = this.getPossibleAllocations(userId, parent);
            form.setCurrrentTransactionAllocations(models);

            Transaction t = transactionService.getTransaction(parent.getId());
            form.setCurrentTransaction(new TransactionModel(t));

            String statusMsg = "Transaction successfully allocated";
            GlobalVariables.getMessageMap().putInfo(TRANSACTION_VIEW, RiceKeyConstants.ERROR_CUSTOM, statusMsg);

        }

        return getUIFModelAndView(form);
    }

    private boolean saveAllocationMemos(TransactionForm form, Long transactionId, Long allocationId) {

        List<TransactionModel> allTransactions = form.getAllTransactions();

        for (TransactionModel model : allTransactions) {
            if (transactionId.equals(model.getId()) || allocationId.equals(model.getId())) {
                List<AllocationModel> allocations = model.getAllocations();
                for (AllocationModel allocation : allocations) {
                    Memo memo = allocation.getMemoModel();
                    if (memo != null && memo.getText() != null) {
                        return informationService.createMemo(transactionId, memo.getText(), memo.getEffectiveDate(), memo.getExpirationDate(), null) != null;
                    }
                }

            }
        }

        return false;
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

    private void removeTag(List<Tag> tags, Tag tagToRemove) {
        for (Tag tag : new HashSet<Tag>(tags)) {
            if (tag.getCode().equals(tagToRemove.getCode())) {
                tags.remove(tag);
                break;
            }
        }
    }

    private List<TransactionModel> getPossibleAllocations(String userId, Transaction transaction) {

        List<Transaction> transactions = transactionService.getTransactions(userId);

        List<TransactionModel> models = new ArrayList<TransactionModel>(transactions.size());
        for (Transaction t : transactions) {
            if (transactionService.canPay(transaction, t) && (t.getUnallocatedAmount().compareTo(BigDecimal.ZERO) > 0)) {
                TransactionModel m = new TransactionModel(t);
                models.add(m);
            }
        }

        return models;
    }

    private List<InformationModel> getHolds(String userId) {

        ContextInfo context = new ContextInfo();
        String effectiveUser = GlobalVariables.getUserSession().getActualPerson().getPrincipalId();
        context.setAuthenticatedPrincipalId(effectiveUser);

        List<InformationModel> models = new ArrayList<InformationModel>();

        try {
            List<AppliedHoldInfo> holds = holdService.getActiveAppliedHoldsByPerson(userId, context);

            for(AppliedHoldInfo hold : holds) {
                Information info = new Information();

                info.setEffectiveDate(hold.getEffectiveDate());
                info.setText(hold.getDescr().getPlain());
                InformationModel model = new InformationModel(info);
                models.add(model);
            }

        } catch (Exception e) {
            GlobalVariables.getMessageMap().putError(TRANSACTION_VIEW, RiceKeyConstants.ERROR_CUSTOM, e.getLocalizedMessage());
        }

        return models;
    }


}
