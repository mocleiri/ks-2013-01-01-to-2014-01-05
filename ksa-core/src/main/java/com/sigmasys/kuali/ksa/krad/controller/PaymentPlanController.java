package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.PaymentPlanForm;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.ThirdPartyAccount;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyAllowableCharge;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlan;
import com.sigmasys.kuali.ksa.service.tp.ThirdPartyTransferService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/paymentPlanView")
public class PaymentPlanController extends GenericSearchController {

    private static final String PAYMENT_PLAN_VIEW = "PaymentPlanView";
    private static final String TRANSFER_TYPE_FIELD = "PaymentPlanViewTransferType";
    private static final String RESPONSIBLE_ACCOUNT_FIELD = "PaymentPlanViewResponsibleAccount";
    private static final String RESPONSIBLE_ACCOUNT_SUGGEST = "PaymentPlanViewResponsibleAccountSuggest";

    private static final Log logger = LogFactory.getLog(PaymentPlanController.class);

    @Autowired
    private ThirdPartyTransferService thirdPartyTransferService;

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected PaymentPlanForm createInitialForm(HttpServletRequest request) {
        PaymentPlanForm form = new PaymentPlanForm();
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
     * @param form
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") PaymentPlanForm form, HttpServletRequest request) {


        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=getResponsibleAccount")
    public ModelAndView getResponsibleAccount(@ModelAttribute("KualiForm") PaymentPlanForm form) {
        String accountString = form.getResponsibleAccount();
        Account account = accountService.getFullAccount(accountString);
        if(account instanceof ThirdPartyAccount){
            form.getNewThirdPartyPlan().setThirdPartyAccount((ThirdPartyAccount)account);
            form.setResponsibleAccountMessage("");
        } else {
            form.setResponsibleAccountMessage(accountString + " is not a valid Third Party Account");
        }

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=filterThirdPartyAccount")
    public ModelAndView filterThirdPartyAccount(@ModelAttribute("KualiForm") PaymentPlanForm form) {
        String accountString = form.getFilterThirdPartyAccount();
        Account account = accountService.getFullAccount(accountString);
        if(account instanceof ThirdPartyAccount){
            form.getFilterThirdPartyAccounts().add((ThirdPartyAccount)account);
        } else {
            String errorMessage = accountString + " is not a valid Third Party Account";
            GlobalVariables.getMessageMap().putError(RESPONSIBLE_ACCOUNT_SUGGEST, RiceKeyConstants.ERROR_CUSTOM, errorMessage);
        }

        populateForm(form);

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=removeThirdPartyAccount")
    public ModelAndView removeThirdPartyAccount(@ModelAttribute("KualiForm") PaymentPlanForm form, HttpServletRequest request) {

        String accountString = request.getParameter("actionParameters[accountId]");

        List<ThirdPartyAccount> updatedAccounts = new ArrayList<ThirdPartyAccount>();

        // Don't remove while iterating through a list.
        for(ThirdPartyAccount account : form.getFilterThirdPartyAccounts()) {
            if(! account.getId().equals(accountString)) {
                updatedAccounts.add(account);
            }
        }

        form.setFilterThirdPartyAccounts(updatedAccounts);

        populateForm(form);

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=filterThirdPartyPlans")
    public ModelAndView filterThirdPartyPlans(@ModelAttribute("KualiForm") PaymentPlanForm form) {
        String planString = form.getFilterPlanName();
        Long planId = Long.parseLong(planString);

        ThirdPartyPlan plan = thirdPartyTransferService.getThirdPartyPlan(planId);

        if(plan != null){
            form.getFilterThirdPartyPlans().add(plan);
        }

        populateForm(form);

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=removeThirdPartyPlan")
    public ModelAndView removeThirdPartyPlan(@ModelAttribute("KualiForm") PaymentPlanForm form, HttpServletRequest request) {

        String planString = request.getParameter("actionParameters[planId]");
        Long planId = Long.parseLong(planString);

        List<ThirdPartyPlan> updatedPlans = new ArrayList<ThirdPartyPlan>();

        // Don't remove while iterating through a list.
        for(ThirdPartyPlan plan : form.getFilterThirdPartyPlans()) {
            if(! plan.getId().equals(planId)) {
                updatedPlans.add(plan);
            }
        }

        form.setFilterThirdPartyPlans(updatedPlans);

        populateForm(form);

        return getUIFModelAndView(form);
    }


    private void populateForm(PaymentPlanForm form) {
    }

    @RequestMapping(method = RequestMethod.POST, params="methodToCall=insertThirdParty")
    public ModelAndView insertThirdParty(@ModelAttribute("KualiForm") PaymentPlanForm form) {

        ThirdPartyPlan plan = form.getNewThirdPartyPlan();

        boolean errors = false;

        if(plan.getThirdPartyAccount() == null  || plan.getThirdPartyAccount().getId() == null){
            String errorMessage = "Invalid third party account";
            GlobalVariables.getMessageMap().putError(RESPONSIBLE_ACCOUNT_FIELD, RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            errors = true;
        }

        String accountId = null;
        if(plan.getThirdPartyAccount() != null){
            accountId = plan.getThirdPartyAccount().getId();
        }

        Long transferTypeId = null;
        if(plan.getTransferType() != null) {
            transferTypeId = plan.getTransferType().getId();
        } else {
            String errorMessage = "Transfer Type is required";
            GlobalVariables.getMessageMap().putError(TRANSFER_TYPE_FIELD, RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            errors = true;
        }

        if(errors){
            return getUIFModelAndView(form);
        }

        plan = thirdPartyTransferService.createThirdPartyPlan(plan.getCode(), plan.getName(), plan.getDescription(), transferTypeId, accountId,
                                          plan.getMaxAmount(), plan.getEffectiveDate(), plan.getRecognitionDate(), plan.getOpenPeriodStartDate(), plan.getOpenPeriodEndDate(),
                                            plan.getChargePeriodStartDate(), plan.getChargePeriodEndDate());

        for(ThirdPartyAllowableCharge charge : form.getThirdPartyAllowableCharges()) {
            thirdPartyTransferService.createThirdPartyAllowableCharge(plan.getId(), charge.getTransactionTypeMask(),
                    charge.getMaxAmount(), charge.getMaxPercentage(), charge.getPriority(),
                    charge.getDistributionPlan());
        }


        return getUIFModelAndView(form);
    }

}
