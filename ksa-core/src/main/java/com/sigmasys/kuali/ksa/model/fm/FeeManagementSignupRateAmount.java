package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.Identifiable;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Fee management signup rate amount model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_FM_SIGNUP_RATE_AMOUNT")
public class FeeManagementSignupRateAmount implements Identifiable {

    private Long id;

    private FeeManagementSignupRate signupRate;

    private String transactionTypeId;

    private Integer unit;

    private BigDecimal amount;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FM_SIGNUP_RATE_AMOUNT",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FM_SIGNUP_RATE_AMOUNT_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FM_SIGNUP_RATE_AMOUNT")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FM_SIGNUP_RATE_ID_FK")
    public FeeManagementSignupRate getSignupRate() {
        return signupRate;
    }

    public void setSignupRate(FeeManagementSignupRate signupRate) {
        this.signupRate = signupRate;
    }

    @Column(name = "TRANSACTION_TYPE_ID", length = 20)
    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Column(name = "UNIT")
    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
