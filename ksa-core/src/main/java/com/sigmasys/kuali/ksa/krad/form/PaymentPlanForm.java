package com.sigmasys.kuali.ksa.krad.form;

//import com.sigmasys.kuali.ksa.krad.model.PaymentBillingDateModel;
import com.sigmasys.kuali.ksa.krad.model.ThirdPartyPlanModel;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.ThirdPartyAccount;
import com.sigmasys.kuali.ksa.model.pb.PaymentBillingAllowableCharge;
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
    private List<PaymentBillingAllowableCharge> paymentBillingAllowableCharges;

    private String filterPlanName;
    private List<ThirdPartyPlan> filterThirdPartyPlans;

    //private List<PaymentBillingDateModel> paymentBillingDates;

    private String filterThirdPartyAccount;
    private List<ThirdPartyAccount> filterThirdPartyAccounts;

    private List<ThirdPartyPlanModel> thirdPartyPlans;

    private ThirdPartyPlanModel thirdPartyPlan;

    private String responsibleAccount;
    private String responsibleAccountMessage;
    private String transferType;

    private KeyValuesFinder transferTypeOptionsFinder;
    private KeyValuesFinder rollupOptionsFinder;



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

    // Fields for a new Payment Billing Plan
    private BigDecimal flatFeeAmount;
    private String flatFeeTransactionType;
    private BigDecimal variableFeePercentage;
    private String variableFeeTransactionType;
    private BigDecimal minimumAmount;
    private BigDecimal maximumAmount;
    private String roundingFactor;
    private String nonRoundedPaymentType;
    private String postToGeneralLedger;
    private String lateMembership;
    private String prefixStatement;

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

    public ThirdPartyPlanModel getThirdPartyPlan() {
        return thirdPartyPlan;
    }

    public void setThirdPartyPlan(ThirdPartyPlanModel thirdPartyPlan) {
        this.thirdPartyPlan = thirdPartyPlan;
    }

    public List<PaymentBillingAllowableCharge> getPaymentBillingAllowableCharges() {
        return paymentBillingAllowableCharges;
    }

    public void setPaymentBillingAllowableCharges(List<PaymentBillingAllowableCharge> paymentBillingAllowableCharges) {
        this.paymentBillingAllowableCharges = paymentBillingAllowableCharges;
    }

    /*public List<PaymentBillingDateModel> getPaymentBillingDates() {
        return paymentBillingDates;
    }

    public void setPaymentBillingDates(List<PaymentBillingDateModel> paymentBillingDates) {
        this.paymentBillingDates = paymentBillingDates;
    }*/

    public KeyValuesFinder getRollupOptionsFinder() {
        return rollupOptionsFinder;
    }

    public void setRollupOptionsFinder(KeyValuesFinder rollupOptionsFinder) {
        this.rollupOptionsFinder = rollupOptionsFinder;
    }

    public BigDecimal getFlatFeeAmount() {
        return flatFeeAmount;
    }

    public void setFlatFeeAmount(BigDecimal flatFeeAmount) {
        this.flatFeeAmount = flatFeeAmount;
    }

    public String getFlatFeeTransactionType() {
        return flatFeeTransactionType;
    }

    public void setFlatFeeTransactionType(String flatFeeTransactionType) {
        this.flatFeeTransactionType = flatFeeTransactionType;
    }

    public BigDecimal getVariableFeePercentage() {
        return variableFeePercentage;
    }

    public void setVariableFeePercentage(BigDecimal variableFeePercentage) {
        this.variableFeePercentage = variableFeePercentage;
    }

    public String getVariableFeeTransactionType() {
        return variableFeeTransactionType;
    }

    public void setVariableFeeTransactionType(String variableFeeTransactionType) {
        this.variableFeeTransactionType = variableFeeTransactionType;
    }

    public BigDecimal getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(BigDecimal minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public BigDecimal getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(BigDecimal maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public String getRoundingFactor() {
        return roundingFactor;
    }

    public void setRoundingFactor(String roundingFactor) {
        this.roundingFactor = roundingFactor;
    }

    public String getNonRoundedPaymentType() {
        return nonRoundedPaymentType;
    }

    public void setNonRoundedPaymentType(String nonRoundedPaymentType) {
        this.nonRoundedPaymentType = nonRoundedPaymentType;
    }

    public String getPostToGeneralLedger() {
        return postToGeneralLedger;
    }

    public void setPostToGeneralLedger(String postToGeneralLedger) {
        this.postToGeneralLedger = postToGeneralLedger;
    }

    public String getLateMembership() {
        return lateMembership;
    }

    public void setLateMembership(String lateMembership) {
        this.lateMembership = lateMembership;
    }

    public String getPrefixStatement() {
        return prefixStatement;
    }

    public void setPrefixStatement(String prefixStatement) {
        this.prefixStatement = prefixStatement;
    }
}
