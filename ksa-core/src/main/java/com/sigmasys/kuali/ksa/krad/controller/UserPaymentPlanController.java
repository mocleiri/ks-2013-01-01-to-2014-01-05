package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.UserPaymentPlanForm;
import com.sigmasys.kuali.ksa.krad.model.ThirdPartyMemberModel;
import com.sigmasys.kuali.ksa.krad.util.AccountUtils;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlan;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlanMember;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyTransferDetail;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.TransactionTransferService;
import com.sigmasys.kuali.ksa.service.tp.ThirdPartyTransferService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.core.api.util.RiceKeyConstants;
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
import java.util.Date;
import java.util.List;

//import com.sigmasys.kuali.ksa.krad.model.ThirdPartyMemberModel;

@Controller
@RequestMapping(value = "/userPaymentPlanView")
public class UserPaymentPlanController extends GenericSearchController {

    private static final String USER_PAYMENT_PLAN_VIEW = "UserPaymentPlanView";
    private static final String ADD_THIRD_PARTY_FIELD = "availableThirdPartyPlansSection";

    private static final Log logger = LogFactory.getLog(UserPaymentPlanController.class);

    @Autowired
    private InformationService informationService;

    @Autowired
    private ThirdPartyTransferService thirdPartyTransferService;

    @Autowired
    private TransactionTransferService transactionTransferService;

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected UserPaymentPlanForm createInitialForm(HttpServletRequest request) {
        UserPaymentPlanForm form = new UserPaymentPlanForm();
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

    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") UserPaymentPlanForm form, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        String pageId = request.getParameter("pageId");

        if ("ThirdPartyPaymentPlans".equals(pageId)) {
            populateForm(form);
        }

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=addThirdPartyPlan")
    public ModelAndView addThirdPartyPlan(@ModelAttribute("KualiForm") UserPaymentPlanForm form) {
        String planString = form.getAddThirdPartyPlanName();
        Long planId = Long.parseLong(planString);

        String userId = form.getAccount().getId();

        ThirdPartyPlan plan = thirdPartyTransferService.getThirdPartyPlan(planId);

        if (plan != null) {
            ThirdPartyPlanMember memeber = thirdPartyTransferService.getThirdPartyPlanMember(planId, userId);
            if(memeber == null) {
                thirdPartyTransferService.createThirdPartyPlanMember(userId, planId, 1);
            } else {
                String errorMessage = userId + " is already a member of requested plan";
                GlobalVariables.getMessageMap().putError(ADD_THIRD_PARTY_FIELD, RiceKeyConstants.ERROR_CUSTOM, errorMessage);

            }
        }

        populateForm(form);

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=reexecuteThirdPartyPlan")
    public ModelAndView reexecuteThirdPartyPlan(@ModelAttribute("KualiForm") UserPaymentPlanForm form, BindingResult result,
                            HttpServletRequest request, HttpServletResponse response) {

        String planIdString = request.getParameter("actionParameters[planId]");
        Long planId;

        try {
            planId = Long.parseLong(planIdString);
        } catch(NumberFormatException e) {
            String errorMessage = planIdString + " is not a valid Third Party Plan";
            GlobalVariables.getMessageMap().putError(form.getViewId(), RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            return getUIFModelAndView(form);
        }

        String userId = form.getAccount().getId();

        thirdPartyTransferService.generateThirdPartyTransfer (planId, userId, new Date());
        GlobalVariables.getMessageMap().putInfo(form.getViewId(), RiceKeyConstants.ERROR_CUSTOM, "Plan re-executed");

        populateForm(form);

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=reverseThirdPartyPlan")
    public ModelAndView reverseThirdPartyPlan(@ModelAttribute("KualiForm") UserPaymentPlanForm form, BindingResult result,
                                                HttpServletRequest request, HttpServletResponse response) {

        String transferDetailIdString = request.getParameter("actionParameters[transferDetailId]");
        Long transferDetailId;

        try {
            transferDetailId = Long.parseLong(transferDetailIdString);
        } catch(NumberFormatException e) {
            String errorMessage = transferDetailIdString + " is not a valid Third Party Transfer Detail Id";
            GlobalVariables.getMessageMap().putError(form.getViewId(), RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            return getUIFModelAndView(form);
        }

        if(transferDetailId == 0L) {
            String errorMessage = transferDetailIdString + " is not a valid Third Party Transfer Detail Id";
            GlobalVariables.getMessageMap().putError(form.getViewId(), RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            return getUIFModelAndView(form);
        }

        List<ThirdPartyMemberModel> models = form.getThirdPartyMembers();

        String memoText = null;

        // Need to loop through and find the right one to get the memo text
        for(ThirdPartyMemberModel model : models) {
            if(transferDetailId.equals(model.getTransferDetail().getId())) {
                memoText = model.getMemo().getText();
                break;
            }
        }

        if(memoText == null || "".equals(memoText)) {
            String errorMessage = "Memo description is required when reversing a Third Party Payment Plan.  Plan not reversed.";
            GlobalVariables.getMessageMap().putError(form.getViewId(), RiceKeyConstants.ERROR_CUSTOM, errorMessage);
            return getUIFModelAndView(form);
        }

        thirdPartyTransferService.reverseThirdPartyTransfer(transferDetailId, memoText);

        GlobalVariables.getMessageMap().putInfo(form.getViewId(), RiceKeyConstants.ERROR_CUSTOM, "Plan reversed");

        populateForm(form);

        return getUIFModelAndView(form);
    }

    private void populateForm(UserPaymentPlanForm form) {
        String userId = form.getAccount().getId();

        form.setAlertObjects(informationService.getAlerts(userId));
        form.setFlagObjects(informationService.getFlags(userId));
        form.setHolds(AccountUtils.getHolds(userId));

        List<ThirdPartyMemberModel> memberModels = new ArrayList<ThirdPartyMemberModel>();

        List<ThirdPartyPlan> plans = thirdPartyTransferService.getThirdPartyPlansByMember(userId);

        for(ThirdPartyPlan plan : plans) {
            ThirdPartyMemberModel model = new ThirdPartyMemberModel();
            model.setPlan(plan);
            ThirdPartyPlanMember member = thirdPartyTransferService.getThirdPartyPlanMember(plan.getId(), userId);
            member.getDirectChargeAccount().getCompositeDefaultPersonName();
            model.setPlanMember(member);

            if(member.isExecuted()) {
                ThirdPartyTransferDetail transferDetail = thirdPartyTransferService.getThirdPartyTransferDetail(plan.getId(), userId);
                model.setTransferDetail(transferDetail);
            }

            memberModels.add(model);
        }

        form.setThirdPartyMembers(memberModels);

    }

}
