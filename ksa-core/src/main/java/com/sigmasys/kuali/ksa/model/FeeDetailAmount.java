package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Fee Detail Amount model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_FEE_DETAIL_AMOUNT")
public class FeeDetailAmount implements Identifiable {

    private Long id;

    private Integer lookup;

    private BigDecimal amount;

    private FeeDetail feeDetail;

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FEE_DETAIL_AMOUNT",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FEE_DETAIL_AMOUNT_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FEE_DETAIL_AMOUNT")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "LOOKUP")
    public Integer getLookup() {
        return lookup;
    }

    public void setLookup(Integer lookup) {
        this.lookup = lookup;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FEE_DETAIL_ID_FK")
    public FeeDetail getFeeDetail() {
        return feeDetail;
    }

    public void setFeeDetail(FeeDetail feeDetail) {
        this.feeDetail = feeDetail;
    }
}
