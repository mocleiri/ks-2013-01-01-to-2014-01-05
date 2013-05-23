package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.PotentialRefundModel;
import com.sigmasys.kuali.ksa.model.Refund;
import com.sigmasys.kuali.ksa.model.Tag;

import java.util.Date;
import java.util.List;

public class BatchRefundForm extends AbstractViewModel {

    private String newAccount;

    private Date startingDate;
    private Date endingDate;

    private List<Tag> tags;
    private String newTag;

    private List<Refund> refunds;
    private List<PotentialRefundModel> potentialRefundModels;

    public String getNewAccount() {
        return newAccount;
    }

    public void setNewAccount(String newAccount) {
        this.newAccount = newAccount;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getNewTag() {
        return newTag;
    }

    public void setNewTag(String newTag) {
        this.newTag = newTag;
    }

    public List<Refund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Refund> refunds) {
        this.refunds = refunds;
    }

    public List<PotentialRefundModel> getPotentialRefundModels() {
        return potentialRefundModels;
    }

    public void setPotentialRefundModels(List<PotentialRefundModel> potentialRefundModels) {
        this.potentialRefundModels = potentialRefundModels;
    }
}
