package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.BatchRefundForm;
import com.sigmasys.kuali.ksa.krad.model.PotentialRefundModel;
import com.sigmasys.kuali.ksa.krad.model.TransactionModel;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Refund;
import com.sigmasys.kuali.ksa.model.Tag;
import com.sigmasys.kuali.ksa.model.Transaction;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.RefundService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/batchRefundView")
public class BatchRefundController extends GenericSearchController {

   private static final Log logger = LogFactory.getLog(BatchRefundController.class);

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private RefundService refundService;

   /**
    * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
    */
   @Override
   protected BatchRefundForm createInitialForm(HttpServletRequest request) {
      BatchRefundForm form = new BatchRefundForm();
      form.setAccounts(new ArrayList<Account>());
      return form;
   }

   /**
    *
    * @param form
    * @return
    */
   @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
   public ModelAndView get(@ModelAttribute("KualiForm") BatchRefundForm form) {

      populateForm(form);
      return getUIFModelAndView(form);
   }

    /**
     *
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=filterAccounts")
    public ModelAndView filterAccounts(@ModelAttribute("KualiForm") BatchRefundForm form) {
        String newAccount = form.getNewAccount();
        Account acct = accountService.getFullAccount(newAccount);
        List<Account> accounts = form.getAccounts();
        if(accounts == null){
            accounts = new ArrayList<Account>();
            form.setAccounts(accounts);
        }
        if(acct != null){
            accounts.add(acct);
        }

        populateForm(form);
        return getUIFModelAndView(form);
    }

    /**
     *
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=filterDates")
    public ModelAndView filterDates(@ModelAttribute("KualiForm") BatchRefundForm form) {
        Date startDate = form.getStartingDate();
        Date endDate = form.getEndingDate();



        populateForm(form);
        return getUIFModelAndView(form);
    }

    /**
     *
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=filterTags")
    public ModelAndView filterTags(@ModelAttribute("KualiForm") BatchRefundForm form) {
        String newTag = form.getNewTag();
        Tag tag = auditableEntityService.getAuditableEntity(newTag, Tag.class);
        List<Tag> tags = form.getTags();
        if(tags == null){
            tags = new ArrayList<Tag>();
            form.setTags(tags);
        }
        if(tag != null){
            tags.add(tag);
        }

        populateForm(form);
        return getUIFModelAndView(form);
    }

    private void populateForm(BatchRefundForm form){
        form.setNewAccount("");
        form.setRefunds(new ArrayList<Refund>());
        form.setPotentialRefundModels(new ArrayList<PotentialRefundModel>());

        List<Account> accounts = form.getAccounts();
        if(accounts == null || accounts.size() == 0){
            return;
        }

        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date startDate = form.getStartingDate();
        Date endDate = form.getEndingDate();

        try{
            if(startDate == null){
                startDate = df.parse("01-01-1970");
            }
            if(endDate == null){
                endDate = df.parse("01-01-2070");
            }
        } catch(ParseException e){
            // eh.
        }

        List<String> accountList = new ArrayList<String>();
        for(Account account : accounts){
            accountList.add(account.getId());
        }

        List<Refund> refunds = refundService.checkForRefund(accountList, startDate, endDate);
        form.setRefunds(refunds);

        List<PotentialRefundModel> potentialRefundModels = form.getPotentialRefundModels();

        for(String userid : accountList){
            logger.info("Retrieving transactions for '" + userid + "' From: " + startDate.toString() + " to: " + endDate.toString());
            List<Transaction> transactions = transactionService.getTransactions(userid, startDate, endDate);
            logger.info("Count: " + transactions.size());

            for(Transaction t: transactions){
                potentialRefundModels.add(new PotentialRefundModel(new TransactionModel(t)));
            }
        }


    }


}
