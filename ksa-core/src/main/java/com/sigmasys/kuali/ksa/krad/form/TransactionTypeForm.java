package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.GlBreakdownModel;
import com.sigmasys.kuali.ksa.krad.model.TransactionTypeGroupModel;
import com.sigmasys.kuali.ksa.krad.model.TransactionTypeModel;
import com.sigmasys.kuali.ksa.model.*;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;

import java.util.*;

public class TransactionTypeForm extends AbstractViewModel {


    private Account account;

    private TransactionTypeModel transactionType;

    private Map<String, TransactionTypeGroupModel> transactionTypeGroups = new HashMap<String, TransactionTypeGroupModel>();


    private String statusMessage;

    private KeyValuesFinder creditDebitKeyValuesFinder;
    private KeyValuesFinder rollupOptionsFinder;

    // Fields used for creating a new transaction type
    private String type;
    private String code;
    private String description;
    private String defaultStatement;
    private Date startDate;
    private Date endDate;
    private Integer priority;
    private String rollupId;

    // Credit types only
    private Integer clearPeriod;
    private String authorizationText;
    private String unallocatedGLAccount;
    private String unallocatedGLOperation;
    private List<GlBreakdownModel> glBreakdowns;
    private List<Tag> tags;

    // Debit types only


    // Display only fields
    private boolean showEndDate;
    private Tag tagSearch;

    /*
      Get/Set methods
    */

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<TransactionTypeGroupModel> getTransactionTypes() {
        return new ArrayList<TransactionTypeGroupModel>(transactionTypeGroups.values());
    }

    public TransactionTypeModel getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeModel transactionType) {
        this.transactionType = transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = new TransactionTypeModel(transactionType);
    }


    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<KeyValue> getTransactionTypeCodes() {
        List<KeyValue> labels = new ArrayList<KeyValue>();

        labels.add(new ConcreteKeyValue("", ""));
        labels.add(new ConcreteKeyValue("C", "Credit"));
        return labels;
    }

    public void reset() {

    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getClearPeriod() {
        return clearPeriod;
    }

    public void setClearPeriod(Integer clearPeriod) {
        this.clearPeriod = clearPeriod;
    }

    public String getAuthorizationText() {
        return authorizationText;
    }

    public void setAuthorizationText(String authorizationText) {
        this.authorizationText = authorizationText;
    }

    public String getUnallocatedGLAccount() {
        return unallocatedGLAccount;
    }

    public void setUnallocatedGLAccount(String unallocatedGLAccount) {
        this.unallocatedGLAccount = unallocatedGLAccount;
    }

    public String getUnallocatedGLOperation() {
        return unallocatedGLOperation;
    }

    public void setUnallocatedGLOperation(String unallocatedGLOperation) {
        this.unallocatedGLOperation = unallocatedGLOperation;
    }

    public List<GlBreakdownModel> getGlBreakdowns() {
        return glBreakdowns;
    }

    public void setGlBreakdowns(List<GlBreakdownModel> glBreakdowns) {
        this.glBreakdowns = glBreakdowns;
    }

    public KeyValuesFinder getCreditDebitKeyValuesFinder() {
        return creditDebitKeyValuesFinder;
    }

    public void setCreditDebitKeyValuesFinder(KeyValuesFinder creditDebitKeyValuesFinder) {
        this.creditDebitKeyValuesFinder = creditDebitKeyValuesFinder;
    }

    public boolean getShowEndDate() {
        return showEndDate;
    }

    public void setShowEndDate(boolean showEndDate) {
        this.showEndDate = showEndDate;
    }

    public String getDefaultStatement() {
        return defaultStatement;
    }

    public void setDefaultStatement(String defaultStatement) {
        this.defaultStatement = defaultStatement;
    }

    public KeyValuesFinder getRollupOptionsFinder() {
        return rollupOptionsFinder;
    }

    public void setRollupOptionsFinder(KeyValuesFinder rollupOptionsFinder) {
        this.rollupOptionsFinder = rollupOptionsFinder;
    }

    public String getRollupId() {
        return rollupId;
    }

    public void setRollupId(String rollupId) {
        this.rollupId = rollupId;
    }

    public List<Tag> getTags() {
        if(this.tags == null){
            this.tags = new ArrayList<Tag>();
        }
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Tag getTagSearch() {
        return tagSearch;
    }

    public void setTagSearch(Tag tagSearch) {
        this.tagSearch = tagSearch;
    }

    public Map<String, TransactionTypeGroupModel> getTransactionTypeGroups() {
        return transactionTypeGroups;
    }

    public void setTransactionTypeGroups(Map<String, TransactionTypeGroupModel> transactionTypeGroups) {
        this.transactionTypeGroups = transactionTypeGroups;
    }
}
