package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.AuditableEntity;
import com.sigmasys.kuali.ksa.model.KeyPair;
import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
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

    protected Boolean isAmountFinal;

    protected Boolean isTransactionTypeFinal;

    protected String transactionTypeId;

    protected RateType rateType;

    protected Set<KeyPair> keyPairs;

    protected BigDecimal limitAmount;

    protected Integer minLimitUnits;

    protected Integer maxLimitUnits;

    protected TransactionDateType transactionDateType;

    protected String transactionDateTypeCode;


    @Transient
    @XmlTransient
    public abstract Set<KeyPair> getKeyPairs();


    public void setKeyPairs(Set<KeyPair> keyPairs) {
        this.keyPairs = keyPairs;
    }

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

    @Column(name = "LIMIT_AMOUNT")
    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    @Column(name = "MIN_LIMIT_UNITS")
    public Integer getMinLimitUnits() {
        return minLimitUnits;
    }

    public void setMinLimitUnits(Integer minLimitUnits) {
        this.minLimitUnits = minLimitUnits;
    }

    @Column(name = "MAX_LIMIT_UNITS")
    public Integer getMaxLimitUnits() {
        return maxLimitUnits;
    }

    public void setMaxLimitUnits(Integer maxLimitUnits) {
        this.maxLimitUnits = maxLimitUnits;
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
