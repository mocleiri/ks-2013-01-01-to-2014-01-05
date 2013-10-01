package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.ThirdPartyAccount;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlan;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlanMember;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyTransferDetail;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: tbornholtz
 * Date: 10/1/13
 */
public class ThirdPartyMemberModel {


    private ThirdPartyPlanMember planMember;

    private ThirdPartyPlan plan;

    private ThirdPartyTransferDetail transferDetail;

    public ThirdPartyPlanMember getPlanMember() {
        return planMember;
    }

    public void setPlanMember(ThirdPartyPlanMember planMember) {
        this.planMember = planMember;
    }

    public ThirdPartyPlan getPlan() {
        return plan;
    }

    public void setPlan(ThirdPartyPlan plan) {
        this.plan = plan;
    }

    public ThirdPartyTransferDetail getTransferDetail() {
        return transferDetail;
    }

    public void setTransferDetail(ThirdPartyTransferDetail transferDetail) {
        this.transferDetail = transferDetail;
    }

    public Date getInitiationDate() {
        if(transferDetail != null){
            return transferDetail.getInitiationDate();
        }
        return null;
    }

    public BigDecimal getTransferAmount() {
        if(transferDetail != null) {
            return transferDetail.getTransferAmount();
        }
        return null;
    }

    public ThirdPartyAccount getResponsibleAccount() {
        if(plan != null) {
            return plan.getThirdPartyAccount();
        }

        return null;
    }

    public Boolean getExecuted() {
        if(planMember != null) {
            return planMember.isExecuted();
        }
        return Boolean.FALSE;
    }

    public Integer getPriority() {
        if(planMember != null) {
            return planMember.getPriority();
        }
        return null;
    }

}
