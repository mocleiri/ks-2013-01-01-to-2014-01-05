package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;

/**
 * DebitType
 * Defines information about the debit.
 * Expressed as a transaction code, this defines what general ledger accounts the debit will pay,
 * the percentage allocations to those accounts,
 * etc. The effective date of a debit also can alter the attributes of the debitType.
 * <p/>
 * <p/>
 * <p/>
 * @author Michael Ivanov
 */
@Entity
@DiscriminatorValue(TransactionType.DEBIT_TYPE)
public class DebitType extends TransactionType {

    private String cancellationRule;


    @Column(name = "CANCELLATION_RULE", length = 2000)
    public String getCancellationRule() {
        return cancellationRule;
    }

    public void setCancellationRule(String cancellationRule) {
        this.cancellationRule = cancellationRule;
    }

    @Transient
    public TransactionTypeValue getTransactionTypeValue() {
        return TransactionTypeValue.CHARGE;
    }

}
