package com.sigmasys.kuali.ksa.model;

import com.sigmasys.kuali.ksa.util.CalendarUtils;
import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Fee detail model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Deprecated
@Entity
@Table(name = "KSSA_FEE_DETAIL")
public class FeeDetail extends AuditableEntity<Long> {

    private Integer subCode;

    private FeeType feeType;

    private Date startDate;

    private Date endDate;

    private String defaultTransactionTypeId;

    private BigDecimal defaultTransactionAmount;

    private Date defaultRecognitionDate;

    private Date defaultTransactionDate;

    private Set<DeprecatedKeyPair> keyPairs;

    private Set<FeeDetailAmount> amounts;

    private FeeDetailDateType dateType;

    private String dateTypeCode;

    private FeeDetailAmountType amountType;

    private String amountTypeCode;

    @PostLoad
    protected void populateTransientFields() {
        dateType = (dateTypeCode != null) ? EnumUtils.findById(FeeDetailDateType.class, dateTypeCode) : null;
        amountType = (amountTypeCode != null) ? EnumUtils.findById(FeeDetailAmountType.class, amountTypeCode) : null;
    }

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FEE_DETAIL",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FEE_DETAIL_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FEE_DETAIL")
    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "SUB_CODE")
    public Integer getSubCode() {
        return subCode;
    }

    public void setSubCode(Integer subCode) {
        this.subCode = subCode;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FEE_TYPE_ID_FK")
    public FeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }

    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = (startDate != null) ? CalendarUtils.removeTime(startDate) : null;
    }

    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = (endDate != null) ? CalendarUtils.removeTime(endDate) : null;
    }

    @Column(name = "DEFAULT_TRN_TYPE_ID", length = 45)
    public String getDefaultTransactionTypeId() {
        return defaultTransactionTypeId;
    }

    public void setDefaultTransactionTypeId(String defaultTransactionTypeId) {
        this.defaultTransactionTypeId = defaultTransactionTypeId;
    }

    @Column(name = "DEFAULT_TRN_AMOUNT")
    public BigDecimal getDefaultTransactionAmount() {
        return defaultTransactionAmount;
    }

    public void setDefaultTransactionAmount(BigDecimal defaultTransactionAmount) {
        this.defaultTransactionAmount = defaultTransactionAmount;
    }

    @Column(name = "DEFAULT_RECOG_DATE")
    @Temporal(TemporalType.DATE)
    public Date getDefaultRecognitionDate() {
        return defaultRecognitionDate;
    }

    public void setDefaultRecognitionDate(Date defaultRecognitionDate) {
        this.defaultRecognitionDate = (defaultRecognitionDate != null) ?
                CalendarUtils.removeTime(defaultRecognitionDate) : null;
    }

    @Column(name = "DEFAULT_TRN_DATE")
    @Temporal(TemporalType.DATE)
    public Date getDefaultTransactionDate() {
        return defaultTransactionDate;
    }

    public void setDefaultTransactionDate(Date defaultTransactionDate) {
        this.defaultTransactionDate = (defaultTransactionDate != null) ?
                CalendarUtils.removeTime(defaultTransactionDate) : null;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_FD_KYPR",
            joinColumns = {
                    @JoinColumn(name = "FD_ID_FK")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "KYPR_ID_FK")
            }
    )
    public Set<DeprecatedKeyPair> getKeyPairs() {
        return keyPairs;
    }

    public void setKeyPairs(Set<DeprecatedKeyPair> keyPairs) {
        this.keyPairs = keyPairs;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FEE_DETAIL_ID_FK")
    public Set<FeeDetailAmount> getAmounts() {
        return amounts;
    }

    public void setAmounts(Set<FeeDetailAmount> amounts) {
        this.amounts = amounts;
    }

    @Transient
    public FeeDetailDateType getDateType() {
        return dateType;
    }

    public void setDateType(FeeDetailDateType dateType) {
        this.dateType = dateType;
        dateTypeCode = dateType.getId();
    }

    protected void setDateTypeCode(String dateTypeCode) {
        this.dateTypeCode = dateTypeCode;
        dateType = EnumUtils.findById(FeeDetailDateType.class, dateTypeCode);
    }

    @Transient
    public FeeDetailAmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(FeeDetailAmountType amountType) {
        this.amountType = amountType;
        amountTypeCode = amountType.getId();
    }

    protected void setAmountTypeCode(String amountTypeCode) {
        this.amountTypeCode = amountTypeCode;
        amountType = EnumUtils.findById(FeeDetailAmountType.class, amountTypeCode);
    }
}
