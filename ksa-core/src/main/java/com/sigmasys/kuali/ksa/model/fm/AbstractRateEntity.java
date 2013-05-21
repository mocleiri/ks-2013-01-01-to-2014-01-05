package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.AuditableEntity;
import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;
import java.util.Set;

/**
 * Abstract Rate entity.
 * <p/>
 *
 * @author Michael Ivanov
 */
@MappedSuperclass
@AttributeOverride(name = "code", column = @Column(name = "CODE", length = 20, nullable = false))
public abstract class AbstractRateEntity extends AuditableEntity<Long> {

    private Boolean isAmountFinal;

    private Boolean isTransactionTypeFinal;

    private String transactionTypeId;

    private RateType rateType;

    private Set<KeyPair> keyPairs;

    private TransactionDateType transactionDateType;

    private String transactionDateTypeCode;


    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_AMOUNT_FINAL")
    public Boolean isAmountFinal() {
        return isAmountFinal;
    }

    public void setAmountFinal(Boolean amountFinal) {
        isAmountFinal = amountFinal;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_TRANS_TYPE_FINAL")
    public Boolean isTransactionTypeFinal() {
        return isTransactionTypeFinal;
    }

    public void setTransactionTypeFinal(Boolean transactionTypeFinal) {
        isTransactionTypeFinal = transactionTypeFinal;
    }

    @Column(name = "TRANSACTION_TYPE_ID", length = 20)
    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RATE_TYPE_ID_FK")
    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_RATE_CATALOG_KYPR",
            joinColumns = {
                    @JoinColumn(name = "RATE_CATALOG_ID_FK")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "KYPR_ID_FK")
            }
    )
    public Set<KeyPair> getKeyPairs() {
        return keyPairs;
    }

    public void setKeyPairs(Set<KeyPair> keyPairs) {
        this.keyPairs = keyPairs;
    }

    @Column(name = "TRANS_DATE_TYPE", length = 10)
    protected String getTransactionDateTypeCode() {
        return transactionDateTypeCode;
    }

    protected void setTransactionDateTypeCode(String transactionDateTypeCode) {
        this.transactionDateTypeCode = transactionDateTypeCode;
        transactionDateType = EnumUtils.findById(TransactionDateType.class, transactionDateTypeCode);
    }

    @Transient
    public TransactionDateType getTransactionDateType() {
        return transactionDateType;
    }

    public void setTransactionDateType(TransactionDateType transactionDateType) {
        this.transactionDateType = transactionDateType;
        transactionDateTypeCode = transactionDateType.getId();
    }

}
