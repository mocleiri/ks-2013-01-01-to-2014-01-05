package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.Identifiable;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Rate Amount model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RATE_AMOUNT",  uniqueConstraints = {@UniqueConstraint(columnNames = {"RATE_ID_FK", "UNIT", "UNIT_FRACTION"})})
public class RateAmount implements Identifiable {

    private Long id;

    private Integer unit;

    private Integer unitFraction;

    private BigDecimal amount;

    private String transactionTypeId;

    private Rate rate;

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_RATE_AMOUNT",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "RATE_AMOUNT_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_RATE_AMOUNT")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "UNIT")
    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Column(name = "UNIT_FRACTION")
    public Integer getUnitFraction() {
        return unitFraction;
    }

    public void setUnitFraction(Integer unitFraction) {
        this.unitFraction = unitFraction;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "TRANSACTION_TYPE_ID", length = 20)
    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RATE_ID_FK")
    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
}
