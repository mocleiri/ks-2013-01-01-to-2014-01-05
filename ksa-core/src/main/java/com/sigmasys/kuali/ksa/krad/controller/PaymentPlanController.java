package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.PaymentPlanForm;
import com.sigmasys.kuali.ksa.krad.model.PaymentBillingDateModel;
import com.sigmasys.kuali.ksa.krad.model.ThirdPartyPlanModel;
import com.sigmasys.kuali.ksa.krad.model.TransactionTransferModel;
import com.sigmasys.kuali.ksa.krad.util.AuditableEntityKeyValuesFinder;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.pb.*;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyAllowableCharge;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlan;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlanMember;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyTransferDetail;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.TransactionTransferService;
import com.sigmasys.kuali.ksa.service.pb.PaymentBillingService;
import com.sigmasys.kuali.ksa.service.tp.ThirdPartyTransferService;
import com.sigmasys.kuali.ksa.util.EnumUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;
import org.kuali.rice.krad.uif.UifParameters;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/paymentPlanView")
public class PaymentPlanController extends GenericSearchController {

    private static final String PAYMENT_PLAN_VIEW = "PaymentPlanView";
    private static final String TRANSFER_TYPE_FIELD = "PaymentPlanViewTransferType";
    private static final String RESPONSIBLE_ACCOUNT_FIELD = "PaymentPlanViewResponsibleAccount";
    private static final String RESPONSIBLE_ACCOUNT_SUGGEST = "PaymentPlanViewResponsibleAccountSuggest";

    private static final Log logger = LogFactory.getLog(PaymentPlanController.class);

    @Autowired
    private PaymentBillingService paymentBillingService;

    @Autowired
    private ThirdPartyTransferService thirdPartyTransferService;

    @Autowired
    private TransactionTransferService transactionTransferService;

    @Autowired
    private AuditableEntityService auditableEntityService;

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

        form.setTransferTypeOptionsFinder(this.getTransferTypeOptionsFinder());

        return form;
    }

    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=navigate")
    public ModelAndView navigate(@ModelAttribute("KualiForm") PaymentPlanForm form, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        String pageId = form.getActionParamaterValue(UifParameters.NAVIGATE_TO_PAGE_ID);

        if ("ManageThirdPartyPage".equals(pageId)) {
            populateForm(form);
        }

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") PaymentPlanForm form, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        String pageId = request.getParameter("pageId");
        form.setRollupOptionsFinder(this.getRollupOptionsFinder());

        // Clean up the "new" objects to clear out any old data
        form.setNewPaymentBillingPlan(new PaymentBillingPlan());
        form.setNewThirdPartyPlan(new ThirdPartyPlan());

        if ("ManageThirdPartyPage".equals(pageId)) {
            populateForm(form);
        }

        return getUIFModelAndView(form);
    }


    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=getResponsibleAccount")
    public ModelAndView getResponsibleAccount(@ModelAttribute("KualiForm") PaymentPlanForm form, HttpServletRequest request) {

        String accountString = request.getParameter("actionParameters[accountId]");

        if (accountString == null) {
            accountString = form.getResponsibleAccount();
        }

        Account account = accountService.getFullAccount(accountString);
        if (account instanceof ThirdPartyAccount) {
            form.setThirdPartyAccount((ThirdPartyAccount) account);
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
        if (account instanceof ThirdPartyAccount) {
            form.getFilterThirdPartyAccounts().add((ThirdPartyAccount) account);
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
        for (ThirdPartyAccount account : form.getFilterThirdPartyAccounts()) {
            if (!account.getId().equals(accountString)) {
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

        if (plan != null) {
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
        for (ThirdPartyPlan plan : form.getFilterThirdPartyPlans()) {
            if (!plan.getId().equals(planId)) {
                updatedPlans.add(plan);
            }
        }

        form.setFilterThirdPartyPlans(updatedPlans);

        populateForm(form);

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=transactionTransferList")
    public ModelAndView transactionTransferList(@ModelAttribute("KualiForm") PaymentPlanForm form, HttpServletRequest request) {

        String memberIdString = request.getParameter("actionParameters[memberId]");

        String planIdString = request.getParameter("actionParameters[planId]");
        Long planId = Long.parseLong(planIdString);


        List<ThirdPartyPlanModel> plans = form.getThirdPartyPlans();
        ThirdPartyPlanModel currentPlan = null;
        for(ThirdPartyPlanModel plan : plans) {
            if(planId.equals(plan.getParent().getId())) {
                currentPlan = plan;
                break;
            }
        }

        if(currentPlan == null){
            ThirdPartyPlan plan = thirdPartyTransferService.getThirdPartyPlan(planId);
            currentPlan = new ThirdPartyPlanModel();
            currentPlan.setParent(plan);
        }

        List<TransactionTransferModel> transferDetails = currentPlan.getThirdPartyTransferDetails();
        if(transferDetails == null || transferDetails.size() == 0) {
            TransactionTransferModel transferModel = new TransactionTransferModel();
            List<ThirdPartyTransferDetail> details = thirdPartyTransferService.getThirdPartyTransferDetails(memberIdString);
            if(details != null) {
                for(ThirdPartyTransferDetail detail : details) {
                    transferModel.setThirdPartyTransferDetail(detail);
                    if(detail != null && detail.getTransferGroupId() != null) {
                        List<TransactionTransfer> transfers = transactionTransferService.getTransactionTransfersByGroupId(detail.getTransferGroupId());
                        transferModel.setTransactionTransfers(transfers);
                    }
                    transferDetails.add(transferModel);
                }
            }

        }


        form.setThirdPartyPlan(currentPlan);

        form.setPageId("ViewTransactionTransferListPage");

        return getUIFModelAndView(form);
    }


    public KeyValuesFinder getTransferTypeOptionsFinder() {
        // Don't cache the values finder or else new entries will not show when added
        return new AuditableEntityKeyValuesFinder<TransferType>(TransferType.class);
    }


    private void populateForm(PaymentPlanForm form) {
        List<ThirdPartyAccount> accounts = form.getFilterThirdPartyAccounts();
        List<ThirdPartyPlan> plans = form.getFilterThirdPartyPlans();

        List<ThirdPartyPlan> allPlans = new ArrayList<ThirdPartyPlan>();

        if ((accounts == null || accounts.size() == 0) && (plans == null || plans.size() == 0)) {
            allPlans = thirdPartyTransferService.getThirdPartyPlans();
        } else if (accounts == null || accounts.size() == 0) {
            allPlans = form.getFilterThirdPartyPlans();
        } else {
            // Accounts have something in them.  Plans might too.
            Set<String> users = new HashSet<String>();
            for (ThirdPartyAccount account : accounts) {
                users.add(account.getId());
            }

            List<ThirdPartyPlan> accountPlans = thirdPartyTransferService.getThirdPartyPlans(users);

            if (plans == null || plans.size() == 0) {
                allPlans = accountPlans;
            } else {
                // Make sure that only the accounts that are also within the plans are displayed

                for (ThirdPartyPlan plan : accountPlans) {
                    Long id = plan.getId();
                    for (ThirdPartyPlan filteredPlan : plans) {
                        if (filteredPlan.getId().equals(id)) {
                            allPlans.add(plan);
                            break;
                        }
                    }
                }
            }
        }

        List<ThirdPartyPlanModel> models = new ArrayList<ThirdPartyPlanModel>(allPlans.size());

        for (ThirdPartyPlan plan : allPlans) {

            ThirdPartyPlanModel model = new ThirdPartyPlanModel();
            model.setParent(plan);

            ThirdPartyAccount account = plan.getThirdPartyAccount();
            if (account == null) {
                logger.error("Plan: " + plan.getCode() + " has a null third party account");
            } else {
                account.getCompositeDefaultPersonName();
            }

            model.setThirdPartyAllowableCharges(thirdPartyTransferService.getThirdPartyAllowableCharges(plan.getId()));

            List<ThirdPartyPlanMember> members = thirdPartyTransferService.getThirdPartyPlanMembers(plan.getId());
            model.setThirdPartyPlanMembers(members);
            for(ThirdPartyPlanMember member : members) {
                member.getDirectChargeAccount().getCompositeDefaultPersonName();
            }

            models.add(model);

        }

        form.setThirdPartyPlans(models);

    }


    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=insertPaymentBilling")
    public ModelAndView insertPaymentBilling(@ModelAttribute("KualiForm") PaymentPlanForm form) {

        boolean errors = false;

        PaymentBillingPlan plan = form.getNewPaymentBillingPlan();

        TransferType transferType = auditableEntityService.getAuditableEntity("PB", TransferType.class);

        if(plan == null) {
            plan = new PaymentBillingPlan();
        }
        if (plan.getCode() == null) {
            plan.setCode(form.getCode());
        }

        if (plan.getName() == null) {
            plan.setName(form.getName());
        }

        if (plan.getDescription() == null) {
            plan.setDescription(form.getDescription());
        }
        if (plan.getOpenPeriodStartDate() == null) {
            plan.setOpenPeriodStartDate(form.getOpenPeriodStartDate());
        }

        if (plan.getOpenPeriodEndDate() == null) {
            plan.setOpenPeriodEndDate(form.getOpenPeriodEndDate());
        }

        if (plan.getChargePeriodStartDate() == null) {
            plan.setChargePeriodStartDate(form.getChargePeriodStartDate());
        }

        if (plan.getChargePeriodEndDate() == null) {
            plan.setChargePeriodEndDate(form.getChargePeriodEndDate());
        }

        if (plan.getMaxAmount() == null) {
            plan.setMaxAmount(form.getMaxAmount());
        }

        plan.setGlCreationImmediate("Y".equals(form.getPostToGeneralLedger()));

        PaymentRoundingType roundingType = EnumUtils.findById(PaymentRoundingType.class, form.getNonRoundedPaymentType());
        plan.setPaymentRoundingType(roundingType);

        ScheduleType scheduleType = EnumUtils.findById(ScheduleType.class, form.getLateMembership());
        if(scheduleType == null){
            GlobalVariables.getMessageMap().putError(form.getViewId(), RiceKeyConstants.ERROR_CUSTOM, "Late Membership is a required field");
            errors = true;
        }
        plan.setScheduleType(scheduleType);

        plan.setTransferType(transferType);

        plan.setFlatFeeDebitTypeId(form.getFlatFeeTransactionType());
        plan.setVariableFeeDebitTypeId(form.getVariableFeeTransactionType());

        if(errors) {
            return getUIFModelAndView(form);
        }

        Long planId = paymentBillingService.persistPaymentBillingPlan(plan);
        plan.setId(planId);


        List<PaymentBillingAllowableCharge> allowableCharges = form.getPaymentBillingAllowableCharges();
        for(PaymentBillingAllowableCharge charge : allowableCharges) {
            PaymentBillingAllowableCharge newCharge = paymentBillingService.createPaymentBillingAllowableCharge(planId, charge.getTransactionTypeMask(), charge.getMaxAmount(), charge.getMaxPercentage(), charge.getPriority());
        }


        List<PaymentBillingDateModel> billingModels = form.getPaymentBillingDates();
        for(PaymentBillingDateModel model : billingModels) {
            String rollupIdString = model.getRollupId();
            Long rollupId = null;
            try {
               rollupId = Long.parseLong(rollupIdString);
            } catch(NumberFormatException e) {
               GlobalVariables.getMessageMap().putError(form.getViewId(), RiceKeyConstants.ERROR_CUSTOM, "Rollup is required.  '" + rollupIdString + "' is not a valid rollup");
               errors = true;
            }
            if(! errors ) {
                PaymentBillingDate newBillingDate = paymentBillingService.createPaymentBillingDate(planId, rollupId, model.getPercentage(), model.getEffectiveDate());
            }
        }

        GlobalVariables.getMessageMap().putInfo(form.getViewId(), RiceKeyConstants.ERROR_CUSTOM, "Payment Billing Plan saved.");

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=insertThirdParty")
    public ModelAndView insertThirdParty(@ModelAttribute("KualiForm") PaymentPlanForm form) {

        ThirdPartyPlan plan = form.getNewThirdPartyPlan();
        if (plan == null) {
            plan = new ThirdPartyPlan();
        }

        if (plan.getCode() == null) {
            plan.setCode(form.getCode());
        }

        if (plan.getName() == null) {
            plan.setName(form.getName());
        }

        if (plan.getDescription() == null) {
            plan.setDescription(form.getDescription());
        }

        if (plan.getOpenPeriodStartDate() == null) {
            plan.setOpenPeriodStartDate(form.getOpenPeriodStartDate());
        }

        if (plan.getOpenPeriodEndDate() == null) {
            plan.setOpenPeriodEndDate(form.getOpenPeriodEndDate());
        }

        if (plan.getChargePeriodStartDate() == null) {
            plan.setChargePeriodStartDate(form.getChargePeriodStartDate());
        }

        if (plan.getChargePeriodEndDate() == null) {
            plan.setChargePeriodEndDate(form.getChargePeriodEndDate());
        }

        if (plan.getMaxAmount() == null) {
            plan.setMaxAmount(form.getMaxAmount());
        }


        boolean errors = false;

        if (form.getThirdPartyAccount() == null || form.getThirdPartyAccount().getId() == null) {
            String errorMessage = "Invalid third party account";
            GlobalVariables.getMessageMap().putError(RESPONSIBLE_ACCOUNT_FIELD, RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            errors = true;
        }

        String accountId = null;
        if (plan.getThirdPartyAccount() != null) {
            accountId = plan.getThirdPartyAccount().getId();
        } else if (form.getThirdPartyAccount() != null) {
            accountId = form.getThirdPartyAccount().getId();
        }

        Long transferTypeId = null;
        if (form.getTransferType() != null) {
            transferTypeId = Long.parseLong(form.getTransferType());
        } else {
            String errorMessage = "Transfer Type is required";
            GlobalVariables.getMessageMap().putError(TRANSFER_TYPE_FIELD, RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            errors = true;
        }

        if (errors) {
            return getUIFModelAndView(form);
        }

        plan = thirdPartyTransferService.createThirdPartyPlan(plan.getCode(), plan.getName(), plan.getDescription(), transferTypeId, accountId,
                plan.getMaxAmount(), plan.getEffectiveDate(), plan.getRecognitionDate(), plan.getOpenPeriodStartDate(), plan.getOpenPeriodEndDate(),
                plan.getChargePeriodStartDate(), plan.getChargePeriodEndDate());

        for (ThirdPartyAllowableCharge charge : form.getThirdPartyAllowableCharges()) {
            thirdPartyTransferService.createThirdPartyAllowableCharge(plan.getId(), charge.getTransactionTypeMask(),
                    charge.getMaxAmount(), charge.getMaxPercentage(), charge.getPriority(),
                    charge.getDistributionPlan());
        }

        String message = "Transfer Type saved";
        GlobalVariables.getMessageMap().putInfo(PAYMENT_PLAN_VIEW, RiceKeyConstants.ERROR_CUSTOM, message);


        return getUIFModelAndView(form);
    }

    public KeyValuesFinder getRollupOptionsFinder() {
        // Don't cache the values finder or else new entries will not show when added
        return new AuditableEntityKeyValuesFinder<Rollup>(Rollup.class);
    }


}
