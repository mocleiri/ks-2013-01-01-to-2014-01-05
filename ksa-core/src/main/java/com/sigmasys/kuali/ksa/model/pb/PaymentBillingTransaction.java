package com.sigmasys.kuali.ksa.model.pb;

import com.sigmasys.kuali.ksa.model.Charge;
import com.sigmasys.kuali.ksa.model.Identifiable;
import com.sigmasys.kuali.ksa.model.Transaction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Payment Billing Transaction model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_PB_TRANSACTION")
public class PaymentBillingTransaction implements Identifiable {

    private Long id;

    private Charge charge;

    private PaymentBillingTransferDetail transferDetail;

    private BigDecimal originalAmount;

    private BigDecimal originalUnallocatedAmount;

    private BigDecimal financedAmount;

    private BigDecimal remainingAmount;

    private BigDecimal temporaryAmount;

    private BigDecimal ratio;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_PB_TRANSACTION",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "PB_TRANSACTION_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_PB_TRANSACTION")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHARGE_ID_FK")
    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PB_TRANSFER_DETAIL_ID_FK")
    public PaymentBillingTransferDetail getTransferDetail() {
        return transferDetail;
    }

    public void setTransferDetail(PaymentBillingTransferDetail transferDetail) {
        this.transferDetail = transferDetail;
    }

    @Column(name = "ORIG_AMOUNT")
    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    @Column(name = "ORIG_UNALLOC_AMOUNT")
    public BigDecimal getOriginalUnallocatedAmount() {
        return originalUnallocatedAmount;
    }

    public void setOriginalUnallocatedAmount(BigDecimal originalUnallocatedAmount) {
        this.originalUnallocatedAmount = originalUnallocatedAmount;
    }

    @Column(name = "FINANCED_AMOUNT")
    public BigDecimal getFinancedAmount() {
        return financedAmount;
    }

    public void setFinancedAmount(BigDecimal financedAmount) {
        this.financedAmount = financedAmount;
    }

    @Column(name = "REMAINING_AMOUNT")
    public BigDecimal getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    @Column(name = "TEMP_AMOUNT")
    public BigDecimal getTemporaryAmount() {
        return temporaryAmount;
    }

    public void setTemporaryAmount(BigDecimal temporaryAmount) {
        this.temporaryAmount = temporaryAmount;
    }

    @Column(name = "RATIO")
    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
}
