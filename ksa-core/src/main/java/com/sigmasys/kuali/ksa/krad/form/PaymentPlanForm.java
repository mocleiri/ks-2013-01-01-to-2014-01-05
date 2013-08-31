package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.ThirdPartyPlanModel;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.ThirdPartyAccount;
import com.sigmasys.kuali.ksa.model.pb.PaymentBillingPlan;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyAllowableCharge;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlan;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: tbornholtz
 * Date: 8/16/13
 */
public class PaymentPlanForm extends AbstractViewModel {

    private Account account;

    private PaymentBillingPlan newPaymentBillingPlan;

    private List<ThirdPartyAllowableCharge> thirdPartyAllowableCharges;

    private String filterPlanName;
    private List<ThirdPartyPlan> filterThirdPartyPlans;

    private String filterThirdPartyAccount;
    private List<ThirdPartyAccount> filterThirdPartyAccounts;

    private List<ThirdPartyPlanModel> thirdPartyPlans;


    private String responsibleAccount;
    private String responsibleAccountMessage;
    private String transferType;

    private KeyValuesFinder transferTypeOptionsFinder;



    // Fields for a new Third Party plan
    private ThirdPartyPlan     newThirdPartyPlan;
    private String code;
    private String name;
    private String description;
    private ThirdPartyAccount thirdPartyAccount;
    private Date openPeriodStartDate;
    private Date openPeriodEndDate;
    private Date chargePeriodStartDate;
    private Date chargePeriodEndDate;
    private BigDecimal maxAmount;
    private Date effectiveDate;
    private Date recognitionDate;



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

    public List<ThirdPartyPlan> getFilterThirdPartyPlans() {
        if(this.filterThirdPartyPlans == null){
            this.filterThirdPartyPlans = new ArrayList<ThirdPartyPlan>();
        }
        return filterThirdPartyPlans;
    }

    public void setFilterThirdPartyPlans(List<ThirdPartyPlan> filterThirdPartyPlans) {
        this.filterThirdPartyPlans = filterThirdPartyPlans;
    }

    public String getFilterPlanName() {
        return filterPlanName;
    }

    public void setFilterPlanName(String filterPlanName) {
        this.filterPlanName = filterPlanName;
    }

    public String getFilterThirdPartyAccount() {
        return filterThirdPartyAccount;
    }

    public void setFilterThirdPartyAccount(String filterThirdPartyAccount) {
        this.filterThirdPartyAccount = filterThirdPartyAccount;
    }

    public List<ThirdPartyAccount> getFilterThirdPartyAccounts() {
        if(this.filterThirdPartyAccounts == null){
            this.filterThirdPartyAccounts = new ArrayList<ThirdPartyAccount>();
        }
        return filterThirdPartyAccounts;
    }

    public void setFilterThirdPartyAccounts(List<ThirdPartyAccount> filterThirdPartyAccounts) {
        this.filterThirdPartyAccounts = filterThirdPartyAccounts;
    }

    public List<ThirdPartyPlanModel> getThirdPartyPlans() {
        if(thirdPartyPlans == null) {
            thirdPartyPlans = new ArrayList<ThirdPartyPlanModel>();
        }
        return thirdPartyPlans;
    }

    public void setThirdPartyPlans(List<ThirdPartyPlanModel> thirdPartyPlans) {
        this.thirdPartyPlans = thirdPartyPlans;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ThirdPartyAccount getThirdPartyAccount() {
        if(thirdPartyAccount == null){
            thirdPartyAccount = new ThirdPartyAccount();
        }
        return thirdPartyAccount;
    }

    public void setThirdPartyAccount(ThirdPartyAccount thirdPartyAccount) {
        this.thirdPartyAccount = thirdPartyAccount;
    }

    public Date getOpenPeriodStartDate() {
        return openPeriodStartDate;
    }

    public void setOpenPeriodStartDate(Date openPeriodStartDate) {
        this.openPeriodStartDate = openPeriodStartDate;
    }

    public Date getOpenPeriodEndDate() {
        return openPeriodEndDate;
    }

    public void setOpenPeriodEndDate(Date openPeriodEndDate) {
        this.openPeriodEndDate = openPeriodEndDate;
    }

    public Date getChargePeriodStartDate() {
        return chargePeriodStartDate;
    }

    public void setChargePeriodStartDate(Date chargePeriodStartDate) {
        this.chargePeriodStartDate = chargePeriodStartDate;
    }

    public Date getChargePeriodEndDate() {
        return chargePeriodEndDate;
    }

    public void setChargePeriodEndDate(Date chargePeriodEndDate) {
        this.chargePeriodEndDate = chargePeriodEndDate;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getRecognitionDate() {
        return recognitionDate;
    }

    public void setRecognitionDate(Date recognitionDate) {
        this.recognitionDate = recognitionDate;
    }

    public KeyValuesFinder getTransferTypeOptionsFinder() {
        return transferTypeOptionsFinder;
    }

    public void setTransferTypeOptionsFinder(KeyValuesFinder transferTypeOptionsFinder) {
        this.transferTypeOptionsFinder = transferTypeOptionsFinder;
    }
}
