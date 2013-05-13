package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.AuditableEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Rate catalog.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RATE_TYPE")
public class RateCatalog extends AuditableEntity<Long> {


    private BigDecimal lowerBoundAmount;

    private BigDecimal upperBoundAmount;

    private BigDecimal cappedAmount;

    private Boolean isAmountCapped;

    private Boolean isTransactionTypeFinal;

    private Boolean isTransactionDateTypeFinal;

    private Boolean isKeyPairFinal;

    private Boolean isRecognitionDateDefinable;

    private String transactionTypeId;

    private String transactionDateType;

    private RateType rateType;

    private Set<KeyPair> keyPairs;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_RATE_CATALOG",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "RATE_CATALOG_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_RATE_CATALOG")
    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "LOWER_BOUND_AMOUNT")
    public BigDecimal getLowerBoundAmount() {
        return lowerBoundAmount;
    }

    public void setLowerBoundAmount(BigDecimal lowerBoundAmount) {
        this.lowerBoundAmount = lowerBoundAmount;
    }

    @Column(name = "UPPER_BOUND_AMOUNT")
    public BigDecimal getUpperBoundAmount() {
        return upperBoundAmount;
    }

    public void setUpperBoundAmount(BigDecimal upperBoundAmount) {
        this.upperBoundAmount = upperBoundAmount;
    }

    @Column(name = "CAPPED_AMOUNT")
    public BigDecimal getCappedAmount() {
        return cappedAmount;
    }

    public void setCappedAmount(BigDecimal cappedAmount) {
        this.cappedAmount = cappedAmount;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_AMOUNT_CAPPED")
    public Boolean isAmountCapped() {
        return isAmountCapped != null ? isAmountCapped : false;
    }

    public void setAmountCapped(Boolean amountCapped) {
        isAmountCapped = amountCapped;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_TRANS_TYPE_FINAL")
    public Boolean isTransactionTypeFinal() {
        return isTransactionTypeFinal;
    }

    public void setTransactionTypeFinal(Boolean transactionTypeFinal) {
        isTransactionTypeFinal = transactionTypeFinal;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_TRANS_DATE_TYPE_FINAL")
    public Boolean isTransactionDateTypeFinal() {
        return isTransactionDateTypeFinal != null ? isTransactionDateTypeFinal : false;
    }

    public void setTransactionDateTypeFinal(Boolean transactionDateTypeFinal) {
        isTransactionDateTypeFinal = transactionDateTypeFinal;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_KEYPAIR_FINAL")
    public Boolean isKeyPairFinal() {
        return isKeyPairFinal != null ? isKeyPairFinal : false;
    }

    public void setKeyPairFinal(Boolean keyPairFinal) {
        isKeyPairFinal = keyPairFinal;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_RECOG_DATE_DEFINABLE")
    public Boolean isRecognitionDateDefinable() {
        return isRecognitionDateDefinable != null ? isRecognitionDateDefinable : false;
    }

    public void setRecognitionDateDefinable(Boolean recognitionDateDefinable) {
        isRecognitionDateDefinable = recognitionDateDefinable;
    }

    @Column(name = "TRANSACTION_TYPE_ID", length = 20)
    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Column(name = "TRANS_DATE_TYPE", length = 10)
    public String getTransactionDateType() {
        return transactionDateType;
    }

    public void setTransactionDateType(String transactionDateType) {
        this.transactionDateType = transactionDateType;
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

}
