package com.sigmasys.kuali.ksa.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue(TransactionTypeValue.DEFERMENT_CODE)
public class Deferment extends Credit {

    /**
     * All deferments are set with an expiration date. If the date passes, then the deferment is expired, and the payment application system will
     * remove the allocation of the deferment, and the charge it is applied to will become due.
     */
    private Date expirationDate;


    @Transient
    public TransactionTypeValue getTransactionTypeValue() {
        return TransactionTypeValue.DEFERMENT;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRATION_DATE")
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Indicates that the deferment has gone through a process called "expireDeferment"
     */
    @Transient
    public boolean isExpired() {
        return (getStatus() != null && getStatus() == TransactionStatus.EXPIRED);
    }

}

