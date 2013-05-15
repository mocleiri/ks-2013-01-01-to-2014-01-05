package com.sigmasys.kuali.ksa.krad.model;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: tbornholtz
 * Date: 5/14/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PotentialRefund {

    private TransactionModel transaction;
    private String      overrideDescription;
    private BigDecimal  refundAmount;

    public PotentialRefund(){
    }

    public PotentialRefund(TransactionModel t){
        this.transaction = t;
    }

    public TransactionModel getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionModel transaction) {
        this.transaction = transaction;
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

}
