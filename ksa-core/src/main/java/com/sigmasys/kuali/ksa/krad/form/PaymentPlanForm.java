package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.pb.PaymentBillingPlan;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyAllowableCharge;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tbornholtz
 * Date: 8/16/13
 */
public class PaymentPlanForm extends AbstractViewModel {

    private Account account;

    private PaymentBillingPlan newPaymentBillingPlan;
    private ThirdPartyPlan     newThirdPartyPlan;

    private List<ThirdPartyAllowableCharge> thirdPartyAllowableCharges;

    private String responsibleAccount;
    private String responsibleAccountMessage;
    private String transferType;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PaymentBillingPlan getNewPaymentBillingPlan() {
        if(newPaymentBillingPlan == null){
            newPaymentBillingPlan = new PaymentBillingPlan();
        }
        return newPaymentBillingPlan;
    }

    public void setNewPaymentBillingPlan(PaymentBillingPlan newPaymentBillingPlan) {
        this.newPaymentBillingPlan = newPaymentBillingPlan;
    }

    public String getResponsibleAccount() {
        return responsibleAccount;
    }

    public void setResponsibleAccount(String responsibleAccount) {
        this.responsibleAccount = responsibleAccount;
    }

    public String getResponsibleAccountMessage() {
        if(responsibleAccount == null){
            responsibleAccountMessage = "No responsible account specified";
        }
        return responsibleAccountMessage;
    }

    public void setResponsibleAccountMessage(String responsibleAccountMessage) {
        this.responsibleAccountMessage = responsibleAccountMessage;
    }

    public ThirdPartyPlan getNewThirdPartyPlan() {
        if(newThirdPartyPlan == null){
            newThirdPartyPlan = new ThirdPartyPlan();
        }
        return newThirdPartyPlan;
    }

    public void setNewThirdPartyPlan(ThirdPartyPlan newThirdPartyPlan) {
        this.newThirdPartyPlan = newThirdPartyPlan;
    }

    public List<ThirdPartyAllowableCharge> getThirdPartyAllowableCharges() {
        if(thirdPartyAllowableCharges == null){
            thirdPartyAllowableCharges = new ArrayList<ThirdPartyAllowableCharge>();
        }
        return thirdPartyAllowableCharges;
    }

    public void setThirdPartyAllowableCharges(List<ThirdPartyAllowableCharge> thirdPartyAllowableCharges) {
        this.thirdPartyAllowableCharges = thirdPartyAllowableCharges;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

}
