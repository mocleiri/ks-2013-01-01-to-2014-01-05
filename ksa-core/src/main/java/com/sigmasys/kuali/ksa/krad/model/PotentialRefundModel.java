package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.Transaction;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: tbornholtz
 * Date: 5/14/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PotentialRefundModel extends TransactionModel {

    private String      overrideDescription;
    private BigDecimal  refundAmount;
    private boolean     selected;

    public PotentialRefundModel(){
    }

    public PotentialRefundModel(Transaction t){
        super(t);
        this.refundAmount = t.getUnallocatedAmount();
    }

    public String getDescription () {
        return getStatementText();
    }

    public String getOverrideDescription() {
        return overrideDescription;
    }

    public void setOverrideDescription(String overrideDescription) {
        this.overrideDescription = overrideDescription;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
