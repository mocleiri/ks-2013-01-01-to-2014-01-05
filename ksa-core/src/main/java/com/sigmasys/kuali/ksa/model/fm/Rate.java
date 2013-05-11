package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.*;

import javax.persistence.*;
import java.util.Date;

/**
 * FM Rate model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RATE")
public class Rate extends AuditableEntity<Long> {

    private String atpId;

    private String transactionTypeCode;

    private String transactionDateType;

    private Date transactionDate;

    private Date recognitionDate;

    private Boolean isDefAmountFinal;

    private Boolean isTransactionTypeFinal;

    private RateCatalog rateCatalog;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_RATE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "RATE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_RATE")
    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "ATP_ID", length = 45)
    public String getAtpId() {
        return atpId;
    }

    public void setAtpId(String atpId) {
        this.atpId = atpId;
    }

    @Column(name = "TRANSACTION_TYPE_CD", length = 20)
    public String getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public void setTransactionTypeCode(String transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    @Column(name = "TRANS_DATE_TYPE", length = 10)
    public String getTransactionDateType() {
        return transactionDateType;
    }

    public void setTransactionDateType(String transactionDateType) {
        this.transactionDateType = transactionDateType;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "TRANSACTION_DATE")
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "RECOGNITION_DATE")
    public Date getRecognitionDate() {
        return recognitionDate;
    }

    public void setRecognitionDate(Date recognitionDate) {
        this.recognitionDate = recognitionDate;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_DEF_AMOUNT_FINAL")
    public Boolean isDefAmountFinal() {
        return isDefAmountFinal;
    }

    public void setDefAmountFinal(Boolean defAmountFinal) {
        isDefAmountFinal = defAmountFinal;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_TRANS_TYPE_FINAL")
    public Boolean isTransactionTypeFinal() {
        return isTransactionTypeFinal;
    }

    public void setTransactionTypeFinal(Boolean transactionTypeFinal) {
        isTransactionTypeFinal = transactionTypeFinal;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RATE_CATALOG_ID_FK")
    public RateCatalog getRateCatalog() {
        return rateCatalog;
    }

    public void setRateCatalog(RateCatalog rateCatalog) {
        this.rateCatalog = rateCatalog;
    }
}
