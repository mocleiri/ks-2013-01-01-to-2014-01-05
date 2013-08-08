package com.sigmasys.kuali.ksa.model.fm;


import com.sigmasys.kuali.ksa.model.KeyPair;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Rate catalog model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RATE_CATALOG")
public class RateCatalog extends AbstractRateEntity {


    private BigDecimal minAmount;

    private BigDecimal maxAmount;

    private Boolean isKeyPairFinal;

    private Boolean isRecognitionDateDefinable;

    private Boolean isTransactionDateTypeFinal;


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

    @Column(name = "MIN_AMOUNT")
    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    @Column(name = "MAX_AMOUNT")
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
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

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_TRANS_DATE_TYPE_FINAL")
    public Boolean isTransactionDateTypeFinal() {
        return isTransactionDateTypeFinal != null ? isTransactionDateTypeFinal : false;
    }

    public void setTransactionDateTypeFinal(Boolean transactionDateTypeFinal) {
        isTransactionDateTypeFinal = transactionDateTypeFinal;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_RATE_CATALOG_KEY_PAIR",
            joinColumns = {
                    @JoinColumn(name = "RATE_CATALOG_ID_FK")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "KEY_PAIR_ID_FK")
            }
    )
    public Set<KeyPair> getKeyPairs() {
        return keyPairs;
    }

}
