package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.QuickViewForm;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.Currency;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.FeeManagementService;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.util.InformationUtils;
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

/**
 * TODO -> handle InformationAccessLevel logic
 * <p/>
 * Created by: dmulderink on 9/28/12 at 2:25 PM
 */
@Controller
@RequestMapping(value = "/quickView")
public class QuickViewController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(QuickViewController.class);

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private FeeManagementService feeManagementService;

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected QuickViewForm createInitialForm(HttpServletRequest request) {

        QuickViewForm form = new QuickViewForm();

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
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") QuickViewForm form, HttpServletRequest request) {

        String viewId = request.getParameter("viewId");
        String pageId = request.getParameter("pageId");
        String userId = request.getParameter("userId");

        logger.info("View: " + viewId + " User: " + userId);

        if ("QuickView".equals(viewId)) {
            if (!accountService.accountExists(userId)) {
                throw new IllegalArgumentException("Unknown account for userid '" + userId + "'");
            }

            if (pageId == null) {
                populateForm(userId, form);
            } else if (pageId.equals("QuickViewAddMemoPage")) {
                if (userId == null || userId.isEmpty()) {
                    throw new IllegalArgumentException("'userId' request parameter must be specified");
                }

                // create a Memo, set defaults for the view
                Account account = accountService.getFullAccount(userId);
                String accountId = account.getId();

                // don't create a persistent memo when adding a memo, just initialize one for use
                // rather persist when the user submits (button control) an insert on the memo
                Memo memo = new Memo();
                memo.setAccount(account);
                memo.setAccountId(accountId);
                memo.setEffectiveDate(new Date());
                memo.setText("");
                memo.setAccessLevel(new InformationAccessLevel());

                form.setMemoModel(memo);

            }
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=refresh")
    public ModelAndView refresh(@ModelAttribute("KualiForm") QuickViewForm form, HttpServletRequest request) {

        String viewId = request.getParameter("viewId");
        String userId = request.getParameter("actionParameters[userId]");

        logger.info("View: " + viewId + " User: " + userId);

        if ("QuickView".equals(viewId)) {
            if (!accountService.accountExists(userId)) {
                throw new IllegalArgumentException("Unknown account for userid '" + userId + "'");
            }

            populateForm(userId, form);

        }

        return getUIFModelAndView(form);
    }

    /**
     * Ageing debts.
     *
     * @param form Kuali form instance
     * @return ModelandView
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=ageDebt")
    public ModelAndView ageDebt(@ModelAttribute("KualiForm") QuickViewForm form) {

        // do aging of transactions stuff...
        String accountId = form.getAccount().getId();
        boolean ignoreDeferment = Boolean.parseBoolean(form.getIgnoreDeferment());

        if (accountId != null && !accountId.trim().isEmpty()) {
            // age the indexed Account Transactions
            accountService.ageDebt(accountId, ignoreDeferment);
            // populate the form using the id
            populateForm(accountId, form);
        }

        return getUIFModelAndView(form);
    }

    /**
     * Fee assessment.
     *
     * @param form Kuali form instance
     * @return ModelandView
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=assessFees")
    public ModelAndView assessFees(@ModelAttribute("KualiForm") QuickViewForm form) {

        String accountId = form.getAccount().getId();

        if (accountId != null && !accountId.trim().isEmpty()) {
            // age the indexed Account Transactions
            feeManagementService.assessFees(accountId);
            // populate the form using the id
            populateForm(accountId, form);
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=insertMemo")
    public ModelAndView insertMemo(@ModelAttribute("KualiForm") QuickViewForm form, HttpServletRequest request) {
        // do insert stuff...

        String viewId = request.getParameter("viewId");
        // example user1
        String userId = request.getParameter("actionParameters[userId]");

        logger.info("View: " + viewId + " User: " + userId);

        // TODO validate the field entries before inserting

        Memo memoModel = form.getMemoModel();

        String accountId = memoModel.getAccountId();
        String memoText = memoModel.getText();

        String accessLevelCode = (memoModel.getAccessLevel() != null) ? memoModel.getAccessLevel().getCode() : null;

        Date effectiveDate = memoModel.getEffectiveDate();
        Date expirationDate = memoModel.getExpirationDate();
        Memo previousMemo = memoModel.getPreviousMemo();
        Long previousMemoId = previousMemo != null ? previousMemo.getId() : null;

        try {

            Memo memo = informationService.createMemo(accountId, memoText, accessLevelCode, effectiveDate, expirationDate, previousMemoId);

            Long persistResult = informationService.persistInformation(memo);

            if (persistResult >= 0) {
                form.setStatusMessage("Success");
                logger.info("Successful insert of memo number " + memo.getId().toString());
            } else {
                String failedMsg = "Failed to add memo. result code: " + persistResult.toString();
                form.setStatusMessage(failedMsg);

                form.setStatusMessage(failedMsg);
            }
        } catch (Exception exp) {
            String errMsg = "'Failed to add memo. " + exp.getMessage();
            logger.error(errMsg);
        }

        return getUIFModelAndView(form);
    }

    /**
     * Populate the form per business needs for a single account by the account identifier
     *
     * @param userId
     * @param form
     */
    private void populateForm(String userId, QuickViewForm form) {

        // store the selected account ID
        //form.setSelectedId(id);

        boolean ignoreDeferment = Boolean.parseBoolean(form.getIgnoreDeferment());

        Account accountById = accountService.getFullAccount(userId);
        if (accountById == null) {
            throw new IllegalStateException("Cannot find Account by ID = " + userId);
        }

        form.setAccount(accountById);

        ChargeableAccount chargeableAccount = (ChargeableAccount) accountById;

        // no session scope
        //form.setStudentLookupByName(accountById.getDefaultPersonName().getLastName());
        // a list of one
        //form.setAccountBrowseList(accountList);
        form.setCompositeDefaultPersonName(accountById.getCompositeDefaultPersonName());
        form.setCompositeDefaultPostalAddress(accountById.getCompositeDefaultPostalAddress());

        BigDecimal balance = accountService.getDueBalance(userId, ignoreDeferment) != null ? accountService.getDueBalance(userId, ignoreDeferment) : BigDecimal.ZERO;
        BigDecimal future = accountService.getUnallocatedBalance(userId) != null ? accountService.getUnallocatedBalance(userId) : BigDecimal.ZERO;
        BigDecimal deferment = accountService.getDeferredAmount(userId) != null ? accountService.getDeferredAmount(userId) : BigDecimal.ZERO;

        // Aging

        Date lastAgeDate = chargeableAccount.getLateLastUpdate();
        form.setLastAgeDate(lastAgeDate);

        Currency currency = auditableEntityService.getCurrency("USD");
        form.setCurrency(currency);

        LatePeriod latePeriod = chargeableAccount.getLatePeriod();

        form.setDaysLate1(latePeriod.getDaysLate1() != null ? latePeriod.getDaysLate1().toString() : "30");
        form.setDaysLate2(latePeriod.getDaysLate2() != null ? latePeriod.getDaysLate2().toString() : "60");
        form.setDaysLate3(latePeriod.getDaysLate3() != null ? latePeriod.getDaysLate3().toString() : "90");

        // getOutstandingBalance above always ignores deferment per Paul setting the pastDue to the ageTotal

        BigDecimal pastDue = BigDecimal.ZERO;
        if (chargeableAccount.getAmountLate1() != null) {
            form.setAged30(chargeableAccount.getAmountLate1().toString());
            pastDue = pastDue.add(chargeableAccount.getAmountLate1());
        } else {
            form.setAged30(BigDecimal.ZERO.toString());
        }

        if (chargeableAccount.getAmountLate2() != null) {
            form.setAged60(chargeableAccount.getAmountLate2().toString());
            pastDue = pastDue.add(chargeableAccount.getAmountLate2());
        } else {
            form.setAged60(BigDecimal.ZERO.toString());
        }

        if (chargeableAccount.getAmountLate3() != null) {
            form.setAged90(chargeableAccount.getAmountLate3().toString());
            pastDue = pastDue.add(chargeableAccount.getAmountLate3());
        } else {
            form.setAged90(BigDecimal.ZERO.toString());
        }

        BigDecimal agedTotal = BigDecimal.ZERO;

        if (chargeableAccount.getAmountLate1() != null &&
                chargeableAccount.getAmountLate2() != null &&
                chargeableAccount.getAmountLate3() != null) {
            agedTotal = agedTotal.add(chargeableAccount.getAmountLate1());
            agedTotal = agedTotal.add(chargeableAccount.getAmountLate2());
            agedTotal = agedTotal.add(chargeableAccount.getAmountLate3());
        }

        form.setAgedTotal(agedTotal.toString());

        form.setPastDueAmount(pastDue.toString());
        form.setBalanceAmount(balance.toString());
        form.setFutureAmount(future.toString());

        if (deferment != null) {
            form.setDefermentAmount(deferment.toString());
        }

        List<Information> alertFlags = new ArrayList<Information>();

        List<Alert> alertsAll = informationService.getAlerts(userId);
        List<Flag> flagAll = informationService.getFlags(userId);

        alertFlags.addAll(alertsAll);
        alertFlags.addAll(flagAll);

        alertFlags = InformationUtils.orderByEffectiveDate(alertFlags, false);

        form.setAlertsFlags(alertFlags);

        List<Memo> memos = informationService.getMemos(userId);

        Iterator<Memo> iterator = memos.iterator();
        Date today = new Date();
        while (iterator.hasNext()) {
            Date expire = iterator.next().getExpirationDate();
            if (expire != null && expire.before(today)) {
                iterator.remove();
            }
        }


        form.setMemoModels(memos);
    }
}
