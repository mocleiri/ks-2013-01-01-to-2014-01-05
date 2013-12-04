package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.PaymentBillingPlanModel;
import com.sigmasys.kuali.ksa.krad.model.ThirdPartyMemberModel;
import com.sigmasys.kuali.ksa.model.pb.PaymentBillingPlan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//import com.sigmasys.kuali.ksa.krad.model.ThirdPartyMemberModel;

/**
 * User: tbornholtz
 * Date: 8/16/13
 */
public class UserPaymentPlanForm extends AbstractViewModel {

    private String addPlanName;
    private BigDecimal maxRequestedAmount;

    private List<ThirdPartyMemberModel> thirdPartyMembers;

    private List<PaymentBillingPlanModel> paymentBillingPlans;

    public String getAddPlanName() {
        return addPlanName;
    }

    public void setAddPlanName(String addPlanName) {
        this.addPlanName = addPlanName;
    }

    public List<ThirdPartyMemberModel> getThirdPartyMembers() {
        if(thirdPartyMembers == null) {
            thirdPartyMembers = new ArrayList<ThirdPartyMemberModel>();
        }
        return thirdPartyMembers;
    }

    public void setThirdPartyMembers(List<ThirdPartyMemberModel> thirdPartyMembers) {
        this.thirdPartyMembers = thirdPartyMembers;
    }

    public BigDecimal getMaxRequestedAmount() {
        return maxRequestedAmount;
    }

    public void setMaxRequestedAmount(BigDecimal maxRequestedAmount) {
        this.maxRequestedAmount = maxRequestedAmount;
    }

    public List<PaymentBillingPlanModel> getPaymentBillingPlans() {
        return paymentBillingPlans;
    }

    public void setPaymentBillingPlans(List<PaymentBillingPlanModel> paymentBillingPlans) {
        this.paymentBillingPlans = paymentBillingPlans;
    }
}
