package com.sigmasys.kuali.ksa.model.fm;


import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Rate catalog model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RATE_CATALOG")
public class RateCatalog extends AbstractRateEntity {


    private BigDecimal lowerBoundAmount;

    private BigDecimal upperBoundAmount;

    private BigDecimal cappedAmount;

    private Boolean isAmountCapped;

    private Boolean isKeyPairFinal;

    private Boolean isRecognitionDateDefinable;


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

}
