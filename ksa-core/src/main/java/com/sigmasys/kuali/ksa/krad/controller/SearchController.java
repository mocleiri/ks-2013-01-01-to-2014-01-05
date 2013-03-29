package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.SearchForm;
import com.sigmasys.kuali.ksa.krad.model.TransactionModel;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.InformationService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by: dmulderink on 8/29/12 at 12:58 PM
 */
@Controller
@RequestMapping(value = "/searchView")
public class SearchController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(SearchController.class);

    @Autowired
    protected InformationService informationService;

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected SearchForm createInitialForm(HttpServletRequest request) {

        SearchForm form = new SearchForm();
        // page can be used for editing or viewing
        form.setOvDetailReadWriteState("true");
        String userId = request.getParameter("userId");

        if (userId != null) {

            Account account = accountService.getFullAccount(userId);

            if (account == null) {
                String errMsg = "Cannot find Account by ID = " + userId;
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }

            form.setAccount(account);
        }/* else {
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
    public ModelAndView get(@ModelAttribute("KualiForm") SearchForm form, HttpServletRequest request) {

        // do get stuff...
        String pageId = request.getParameter("pageId");
        String userId = request.getParameter("userId");
        String transactionId = request.getParameter("id");

        if (pageId != null && pageId.equals("AccountOVTransactionsPage")) {
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("'userId' request parameter must be specified");
            }

            // All transactions
            List<Transaction> transactions = transactionService.getTransactions(userId);

            logger.info("Transaction Count: " + transactions.size());
            List<TransactionModel> rollUpTransactionModelList = new ArrayList<TransactionModel>();
            List<TransactionModel> unGroupedTransactionModelList = new ArrayList<TransactionModel>();

            BigDecimal rollUpCredit = BigDecimal.ZERO;
            BigDecimal rollUpDebit = BigDecimal.ZERO;
            BigDecimal unGroupedCredit = BigDecimal.ZERO;
            BigDecimal unGroupedDebit = BigDecimal.ZERO;

            for (Transaction t : transactions) {
                unGroupedTransactionModelList.add(new TransactionModel(t));
                if (TransactionTypeValue.CHARGE.equals(t.getTransactionTypeValue())) {
                    unGroupedCredit = unGroupedCredit.add(t.getAmount());
                } else {
                    unGroupedDebit = unGroupedDebit.add(t.getAmount());
                }

                TransactionModel transactionModel = new TransactionModel(t);
                Rollup tmRollup = t.getRollup();
                if (tmRollup != null) {
                    // Check if this rollup is already in there.
                    boolean found = false;
                    for (TransactionModel m : rollUpTransactionModelList) {
                        Rollup r = m.getRollup();
                        if (r.getId().equals(tmRollup.getId())) {
                            m.setAmount(m.getAmount().add(transactionModel.getAmount()));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        rollUpTransactionModelList.add(transactionModel);
                    }
                    if (TransactionTypeValue.CHARGE.equals(t.getTransactionTypeValue())) {
                        rollUpCredit = rollUpCredit.add(t.getAmount());
                    } else {
                        rollUpDebit = rollUpDebit.add(t.getAmount());
                    }
                }
            }
            TransactionModel singleTransactionModel = new TransactionModel();
            singleTransactionModel.setRollUpCredit(rollUpCredit.toString());
            singleTransactionModel.setRollUpDebit(rollUpDebit.toString());
            singleTransactionModel.setUnGroupedCredit(unGroupedCredit.toString());
            singleTransactionModel.setUnGroupedDebit(unGroupedDebit.toString());
            form.setTransactionModel(singleTransactionModel);
            form.setRollUpTransactionModelList(rollUpTransactionModelList);
            form.setUnGroupedTransactionModelList(unGroupedTransactionModelList);

        } else if (pageId != null && pageId.equals("AccountOVTransactionsRollupDetailPage")) {
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("'userId' request parameter must be specified");
            }

            Long rollupId;
            try {
                rollupId = new Long(request.getParameter("rollupId"));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("'rollupId' request parameter is invalid");
            }

            List<Transaction> transactions = transactionService.getTransactions(userId);
            List<TransactionModel> rollups = new ArrayList<TransactionModel>();

            for (Transaction t : transactions) {
                Rollup r = t.getRollup();

                if (r != null && rollupId.equals(r.getId())) {
                    logger.info("Retrieved transaction with description: " + t.getTransactionType().getDescription());
                    TransactionModel transactionModel = new TransactionModel(t);
                    rollups.add(transactionModel);
                }
            }

            form.setByRollUpTransactionModelList(rollups);


        } else if (pageId != null && pageId.equals("AccountOVTransactionDetailPage")) {

            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("'userId' request parameter must be specified");
            }

            // page can be used for editing or viewing
            form.setOvDetailReadWriteState("true");

            Transaction t = transactionService.getTransaction(new Long(transactionId));
            logger.info("Retrieved transaction with description: " + t.getTransactionType().getDescription());

            TransactionModel transactionModel = new TransactionModel(t);

            if (t.getRollup() != null) {
                Rollup rollup = t.getRollup();

                //@TODO change this method name.  It isn't part of Rollup.
                transactionModel.setRollupDesc(rollup.getDescription());
            }

            TransactionType tt = t.getTransactionType();
            if (tt != null) {
                List<Tag> tags = tt.getTags();
                if (tags != null) {
                    List<String> names = new ArrayList<String>();
                    for (Tag tag : tags) {
                        names.add(tag.getName());
                    }
                    // added to TransactionModel
                    transactionModel.setRollupTag(StringUtils.collectionToCommaDelimitedString(names));
                }
                transactionModel.setTransactionTypeId(tt.getId().getId());
                transactionModel.setTransactionTypeDesc(tt.getDescription());

            }
            // // added to TransactionModel
            if (tt instanceof DebitType) {
                DebitType dt = (DebitType) tt;
                transactionModel.setDebitPriority(dt.getPriority().toString());
            }

            transactionModel.setTransactionTypeSubCode(t.getTransactionType().getId().getSubCode().toString());

            if (t instanceof Deferment) {
                Deferment def = (Deferment) t;
                transactionModel.setDeferredId(def.getId().toString());
            } else if (t instanceof Payment) {
                Payment payment = (Payment) t;
                transactionModel.setPaymentClearDate(payment.getClearDate());
                transactionModel.setRefundRule(payment.getRefundRule());
            }

            transactionModel.setDocumentId(t.getDocument() != null ? t.getDocument().getId().toString() : null);

            transactionModel.setGeneralLedgerTypeId(t.getGeneralLedgerType() != null ? t.getGeneralLedgerType().getId().toString() : null);

            transactionModel.setGlOverRidden(t.isGlOverridden() != null ? t.isGlOverridden().toString() : null);

            form.setTransactionModel(transactionModel);
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=submit")
    @Transactional(readOnly = false)
    public ModelAndView submit(@ModelAttribute("KualiForm") SearchForm form) {
        // do submit stuff...


        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=save")
    @Transactional(readOnly = false)
    public ModelAndView save(@ModelAttribute("KualiForm") SearchForm form) {

        // do save stuff...

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=refresh")
    public ModelAndView refresh(@ModelAttribute("KualiForm") SearchForm form) {
        // do refresh stuff...
        return getUIFModelAndView(form);
    }
}
