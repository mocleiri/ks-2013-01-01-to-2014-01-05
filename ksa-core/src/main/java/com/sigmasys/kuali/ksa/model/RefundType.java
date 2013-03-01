package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;

/**
 * This entity class describes a type of a <code>Refund</code> stored in the "refundType" attribute of that class.
 * <p/>
 *
 * @author Michael Ivanov
 * @author Sergey Godunov
 * @version 1.1
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KSSA_REFUND_TYPE")
public class RefundType extends AuditableEntity<Long> {

	/**
	 * The transaction type for refunds that are made by this type. This is a debit type ("charge"), as it deducts the over-payment from the account.
	 */
    private String debitTypeId;
    
    /**
     * For refund types that send the refund back to a KSA account ("Account Refunds", "Payoff Refunds") 
     * this is the credit type ("payment") that will be applied to the receiving account. 
     * For most refund types where the money is sent.
     */
    private String creditTypeId;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_REFUND_TYPE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "REFUND_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_REFUND_TYPE")
    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "CREDIT_TYPE_ID", length = 20)
    public String getCreditTypeId() {
        return creditTypeId;
    }

    public void setCreditTypeId(String creditTypeId) {
        this.creditTypeId = creditTypeId;
    }

    @Column(name = "DEBIT_TYPE_ID", length = 20)
    public String getDebitTypeId() {
        return debitTypeId;
    }

    public void setDebitTypeId(String debitTypeId) {
        this.debitTypeId = debitTypeId;
    }
}
