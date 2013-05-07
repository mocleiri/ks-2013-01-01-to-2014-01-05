package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.PaymentForm;
import com.sigmasys.kuali.ksa.krad.util.AuditableEntityKeyValuesFinder;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

/**
 * PaymentController
 *
 * @author Tim
 */
@Controller
@RequestMapping(value = "/paymentView")
public class PaymentController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(PaymentController.class);

    @Autowired
    private AuditableEntityService auditableEntityService;

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected PaymentForm createInitialForm(HttpServletRequest request) {

        PaymentForm form = new PaymentForm();

        form.setStatusMessage("");

        String userId = request.getParameter("userId");

        if (userId != null) {

            Account account = accountService.getFullAccount(userId);

            if (account == null) {
                String errMsg = "Cannot find Account by ID = " + userId;
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }

            form.setAccount(account);
        }

        return form;
    }

    /**
     * Default GET method
     *
     * @param form PaymentForm
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") PaymentForm form) {
        return getUIFModelAndView(form);
    }

    /**
     * Payment creating method
     *
     * @param form    PaymentForm
     * @param request HttpServletRequest
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=create")
    public ModelAndView create(@ModelAttribute("KualiForm") PaymentForm form, HttpServletRequest request) {

        // do get stuff...

        String viewId = request.getParameter("viewId");
        // example user1
        String userId = request.getParameter("userId");

        logger.info("View: " + viewId + " User: " + userId);

        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("'userId' request parameter must be specified");
        }

        // abbreviated payment initialization
        Account account = accountService.getFullAccount(userId);
        String accountId = account.getId();

        Payment payment = new Payment();
        payment.setAccount(account);
        payment.setAccountId(accountId);
        payment.setEffectiveDate(new Date());
        form.setPayment(payment);
        form.setCurrencyOptionsFinder(this.getCurrencyOptionsFinder());
        form.setRollupOptionsFinder(this.getRollupOptionsFinder());

        BigDecimal startingBalance = accountService.getBalance(userId, new Date());
        form.setEstimatedCurrentBalance(startingBalance);

        return getUIFModelAndView(form);
    }

    /**
     * Retrieves the transaction type.
     *
     * @param form PaymentForm
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=getTransactionType")
    public ModelAndView getTransactionType(@ModelAttribute("KualiForm") PaymentForm form) {

        String ttId = form.getPaymentTransactionTypeId();

        form.setTransactionType(null);
        TransactionType type = null;

        try {
            form.setTransactionTypeMessage("");
            type = transactionService.getTransactionType(ttId, new Date());
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            form.setTransactionTypeMessage("Invalid Transaction Type");
        }

        if (type != null && type instanceof CreditType) {

            form.setTransactionType((CreditType) type);

            String systemCurrency = java.util.Currency.getInstance(Locale.getDefault()).getCurrencyCode();
            form.setSystemCurrency(systemCurrency);

            Currency curr = auditableEntityService.getCurrency(systemCurrency);
            form.setCurrencyId(curr.getId().toString());
        }

        return getUIFModelAndView(form);
    }

    /**
     * Form submitting method
     *
     * @param form    PaymentForm
     * @param request HttpServletRequest
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=submit")
    @Transactional(readOnly = false)
    public ModelAndView submit(@ModelAttribute("KualiForm") PaymentForm form, HttpServletRequest request) {
        // do submit stuff...

        String viewId = request.getParameter("viewId");
        // example user1
        String userId = request.getParameter("userId");

        logger.info("View: " + viewId + " User: " + userId);

        if (savePayment(form)) {
            initPayment(form);
        }

        Payment payment = form.getPayment();

        if (payment != null && payment.getId() != null && form.isAgeAccount()) {
            accountService.ageDebt(payment.getAccount().getId(), false);
        }

        return getUIFModelAndView(form);
    }

    public KeyValuesFinder getCurrencyOptionsFinder() {
        // Don't cache the values finder or else new entries will not show when added
        return new AuditableEntityKeyValuesFinder<Currency>(Currency.class, true);
    }

    public KeyValuesFinder getRollupOptionsFinder() {
        // Don't cache the values finder or else new entries will not show when added
        return new AuditableEntityKeyValuesFinder<Rollup>(Rollup.class);
    }

    private boolean savePayment(PaymentForm form) {

        boolean saveResult = false;
        boolean errors = false;
        String statusMsg = "";
        Payment payment = form.getPayment();
        payment.setAccount(form.getAccount());

        String typeIdString = form.getPaymentTransactionTypeId();
        Date effectiveDate = payment.getEffectiveDate();
        if (effectiveDate == null) {
            effectiveDate = new Date();
        }

        // Because of the way that the fields are hidden and shown on the screen,
        // Check the currency of the native amount If that matches the system currency
        // then the native amount will contain the actual amount.
        BigDecimal amount = payment.getAmount();
        BigDecimal nativeAmount = payment.getNativeAmount();
        String currencyId = form.getCurrencyId();

        String systemCurrency = java.util.Currency.getInstance(Locale.getDefault()).getCurrencyCode();
        Currency systemCurr = auditableEntityService.getCurrency(systemCurrency);
        String systemCurrencyId = systemCurr.getId().toString();

        if (currencyId == null || systemCurrencyId.equals(currencyId)) {
            amount = nativeAmount;
            nativeAmount = null;
        } else {
            Currency curr = auditableEntityService.getCurrency(currencyId);
            payment.setCurrency(curr);
        }

        if (amount == null) {
            statusMsg = "Amount must be a numerical value";
            GlobalVariables.getMessageMap().putError("PaymentView", RiceKeyConstants.ERROR_CUSTOM, statusMsg);
            logger.error(statusMsg);
            errors = true;
        } else if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            statusMsg = "Amount must be a positive value";
            GlobalVariables.getMessageMap().putError("PaymentView", RiceKeyConstants.ERROR_CUSTOM, statusMsg);
            logger.error(statusMsg);
            errors = true;
        }

        TransactionType tt = null;

        try {
            tt = transactionService.getTransactionType(typeIdString, effectiveDate);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        if (tt == null) {
            // Error handler here.
            statusMsg = "Invalid Payment Type";
            GlobalVariables.getMessageMap().putError("PaymentView", RiceKeyConstants.ERROR_CUSTOM, statusMsg);
            logger.error(statusMsg);
            errors = true;
        } else if (!(tt instanceof CreditType)) {
            statusMsg = "Payment Type must be a credit type";
            GlobalVariables.getMessageMap().putError("PaymentView", RiceKeyConstants.ERROR_CUSTOM, statusMsg);
            logger.error(statusMsg);
            errors = true;
        }

        // Handle all error checking prior to this point.
        if (errors) {
            return saveResult;
        }

        try {

            payment = (Payment) transactionService.createTransaction(typeIdString, form.getExternalId(),
                    payment.getAccount().getId(), effectiveDate, effectiveDate, null, amount, false);

            if (payment != null && payment.getId() != null) {

                if (nativeAmount != null) {
                    payment.setAmount(amount);
                    Currency c = auditableEntityService.getAuditableEntity(new Long(currencyId), Currency.class);
                    payment.setCurrency(c);
                    payment.setNativeAmount(nativeAmount);

                    transactionService.persistTransaction(payment);
                }

                form.setPayment(payment);
                statusMsg = tt.getDescription() + " Payment saved";
                GlobalVariables.getMessageMap().putInfo("PaymentView", RiceKeyConstants.ERROR_CUSTOM, statusMsg);
                logger.info(statusMsg);
                saveResult = true;
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            GlobalVariables.getMessageMap().putError("PaymentView", RiceKeyConstants.ERROR_CUSTOM, e.getMessage());

        }

        return saveResult;
    }

    private void initPayment(PaymentForm form) {

        // abbreviated payment initialization
        Account account = form.getAccount();
        String accountId = account.getId();

        Payment payment = new Payment();
        payment.setAccount(account);
        payment.setAccountId(accountId);
        payment.setEffectiveDate(new Date());
        form.setPayment(payment);
    }
}
