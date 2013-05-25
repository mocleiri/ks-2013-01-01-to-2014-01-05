package com.sigmasys.kuali.ksa.model.fm;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Rate model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RATE", uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE", "RATE_CATALOG_ATP_ID_FK"})})
public class Rate extends AbstractRateEntity {

    private String atpId;

    private Date transactionDate;

    private Date recognitionDate;

    private RateCatalogAtp rateCatalogAtp;

    private Set<RateAmount> rateAmounts;

    private RateAmount defaultRateAmount;


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

    @Column(name = "RATE_CATALOG_ATP_ID_FK", insertable = false, updatable = false, nullable = false, length = 45)
    public String getAtpId() {
        return atpId;
    }

    public void setAtpId(String atpId) {
        this.atpId = atpId;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "RATE_CATALOG_CODE_FK", referencedColumnName = "RATE_CATALOG_CODE"),
            @JoinColumn(name = "RATE_CATALOG_ATP_ID_FK", referencedColumnName = "ATP_ID")
    })
    public RateCatalogAtp getRateCatalogAtp() {
        return rateCatalogAtp;
    }

    public void setRateCatalogAtp(RateCatalogAtp rateCatalogAtp) {
        this.rateCatalogAtp = rateCatalogAtp;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RATE_ID_FK")
    public Set<RateAmount> getRateAmounts() {
        return rateAmounts;
    }

    public void setRateAmounts(Set<RateAmount> rateAmounts) {
        this.rateAmounts = rateAmounts;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEFAULT_RATE_AMOUNT_ID_FK", nullable = false)
    public RateAmount getDefaultRateAmount() {
        return defaultRateAmount;
    }

    public void setDefaultRateAmount(RateAmount defaultRateAmount) {
        this.defaultRateAmount = defaultRateAmount;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_RATE_KYPR",
            joinColumns = {
                    @JoinColumn(name = "RATE_ID_FK")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "RATE_KYPR_ID_FK")
            }
    )
    public Set<KeyPair> getKeyPairs() {
        return keyPairs;
    }

}
