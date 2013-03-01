package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.exception.InvalidTransactionTypeException;
import com.sigmasys.kuali.ksa.exception.TransactionNotAllowedException;
import com.sigmasys.kuali.ksa.krad.form.PaymentForm;
import com.sigmasys.kuali.ksa.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by: dmulderink on 9/30/12 at 11:27 AM
 */
@Controller
@RequestMapping(value = "/paymentView")
public class PaymentController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(PaymentController.class);

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
    public ModelAndView get(@ModelAttribute("KualiForm") PaymentForm form, HttpServletRequest request) {

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

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=submit")
    @Transactional(readOnly = false)
    public ModelAndView submit(@ModelAttribute("KualiForm") PaymentForm form, HttpServletRequest request) {
        // do submit stuff...

        String viewId = request.getParameter("viewId");
        // example user1
        String userId = request.getParameter("userId");

        logger.info("View: " + viewId + " User: " + userId);
        if (this.savePayment(form)) {
            this.initPayment(form);
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=submitAge")
    @Transactional(readOnly = false)
    public ModelAndView submitAge(@ModelAttribute("KualiForm") PaymentForm form, HttpServletRequest request) {
        // do submit stuff...

        String viewId = request.getParameter("viewId");
        // example user1
        String userId = request.getParameter("userId");

        logger.info("View: " + viewId + " User: " + userId);
        if (this.savePayment(form)) {
            this.initPayment(form);
        }

        Payment payment = form.getPayment();

        if (payment != null && payment.getId() != null) {
            accountService.ageDebt(payment.getAccount().getId(), false);
        }

        return getUIFModelAndView(form);
    }

    private boolean savePayment(PaymentForm form) {

        boolean saveResult = false;
        String statusMsg = "";
        Payment payment = form.getPayment();
        payment.setAccount(form.getAccount());

        String typeIdString = form.getPaymentTransactionTypeId();
        Date effectiveDate = payment.getEffectiveDate();
        if (effectiveDate == null) {
            effectiveDate = new Date();
        }

        BigDecimal amount = payment.getAmount();
        if (amount == null) {
            statusMsg = "Amount must be a numerical value";
            form.setStatusMessage(statusMsg);
            logger.error(statusMsg);
            return saveResult;
        }

        int compareResult = amount.compareTo(BigDecimal.ZERO);
        if (compareResult <= 0) {
            statusMsg = "Amount must be a positive value";
            form.setStatusMessage(statusMsg);
            logger.error(statusMsg);
            return saveResult;
        }

        TransactionType tt;
        try {
            tt = transactionService.getTransactionType(typeIdString, effectiveDate);
        } catch (InvalidTransactionTypeException e) {
            logger.error(e.getMessage(), e);
            form.setStatusMessage(e.getMessage());
            return saveResult;
        }

        if (tt == null) {
            // Error handler here.
            statusMsg = "Invalid Transaction Type";
            form.setStatusMessage(statusMsg);
            logger.error(statusMsg);
            return saveResult;
        } else if (!(tt instanceof CreditType)) {
            statusMsg = "Transaction Type must be a payment";
            form.setStatusMessage(statusMsg);
            logger.error(statusMsg);
            return saveResult;
        }

        try {
            payment = (Payment) transactionService.createTransaction(typeIdString, payment.getExternalId(),
                    payment.getAccount().getId(), effectiveDate, null, payment.getAmount());
            if (payment.getId() != null) {
                form.setPayment(payment);
                statusMsg = tt.getDescription() + " Payment saved";
                form.setStatusMessage(statusMsg);
                logger.info(statusMsg);
                saveResult = true;
            }

        } catch (TransactionNotAllowedException e) {
            logger.error(e.getMessage(), e);
            form.setStatusMessage(e.getMessage());
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
