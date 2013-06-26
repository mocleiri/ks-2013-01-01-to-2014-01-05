package com.sigmasys.kuali.ksa.model.pb;

import com.sigmasys.kuali.ksa.model.AuditableEntity;
import com.sigmasys.kuali.ksa.model.DebitType;
import com.sigmasys.kuali.ksa.model.TransferType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Payment Billing Plan model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_PB_PLAN")
@AttributeOverride(name = "code", column = @Column(name = "CODE", length = 20, nullable = false, unique = true))
public class PaymentBillingPlan extends AuditableEntity<Long> {


    private TransferType transferType;

    private Date openPeriodStartDate;

    private Date openPeriodEndDate;

    private Date chargePeriodStartDate;

    private Date chargePeriodEndDate;

    private BigDecimal maxAmount;

    private BigDecimal flatFeeAmount;

    private BigDecimal feeAmountPercentage;

    private BigDecimal minFeeAmount;

    private BigDecimal maxFeeAmount;

    private DebitType flatFeeDebitType;

    private DebitType nonFlatFeeDebitType;

    private Integer roundingFactor;

    private Boolean isGlCreationImmediate;

    private String statementPrefix;

    // TODO


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_PB_PLAN",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "PB_PLAN_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_PB_PLAN")
    @Override
    public Long getId() {
        return id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "START_OPEN_PERIOD")
    public Date getOpenPeriodStartDate() {
        return openPeriodStartDate;
    }

    public void setOpenPeriodStartDate(Date openPeriodStartDate) {
        this.openPeriodStartDate = openPeriodStartDate;
    }

    public Date getOpenPeriodEndDate() {
        return openPeriodEndDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "END_OPEN_PERIOD")
    public void setOpenPeriodEndDate(Date openPeriodEndDate) {
        this.openPeriodEndDate = openPeriodEndDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "START_CHARGE_PERIOD")
    public Date getChargePeriodStartDate() {
        return chargePeriodStartDate;
    }

    public void setChargePeriodStartDate(Date chargePeriodStartDate) {
        this.chargePeriodStartDate = chargePeriodStartDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "END_OPEN_PERIOD")
    public Date getChargePeriodEndDate() {
        return chargePeriodEndDate;
    }

    public void setChargePeriodEndDate(Date chargePeriodEndDate) {
        this.chargePeriodEndDate = chargePeriodEndDate;
    }


}
