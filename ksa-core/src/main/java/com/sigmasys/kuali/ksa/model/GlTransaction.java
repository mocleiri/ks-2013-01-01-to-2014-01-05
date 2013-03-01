package com.sigmasys.kuali.ksa.model;

import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * General ledger transaction model.
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_GL_TRANSACTION")
public class GlTransaction extends AbstractGlEntity {


    /**
     * Transactions associated with this GL transaction
     */
    private Set<Transaction> transactions;

    /**
     * Transmission of the current GL transaction
     */
    private GlTransmission transmission;

    /**
     * Generated text
     */
    private String description;

    private GlTransactionStatus status;


    @PostLoad
    protected void populateTransientFields() {
        super.populateTransientFields();
        status = (statusCode != null) ? EnumUtils.findById(GlTransactionStatus.class, statusCode) : null;
    }


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_GL_TRANSACTION",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "GL_TRANSACTION_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_GL_TRANSACTION")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_GL_TRANS_TRANSACTION",
            joinColumns = {
                    @JoinColumn(name = "GL_TRANSACTION_ID_FK")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "TRANSACTION_ID_FK")
            }
    )
    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GL_TRANSMISSION_ID_FK")
    public GlTransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(GlTransmission transmission) {
        this.transmission = transmission;
    }

    @Override
    @Column(name = "TRANSACTION_DATE")
    public Date getDate() {
        return date;
    }

    @Column(name = "GENERATED_TEXT", length = 1024)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected void setStatusCode(String statusCode) {
        super.setStatusCode(statusCode);
        status = EnumUtils.findById(GlTransactionStatus.class, statusCode);
    }

    @Transient
    public GlTransactionStatus getStatus() {
        return status;
    }

    public void setStatus(GlTransactionStatus status) {
        this.status = status;
        statusCode = status.getId();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", {transactions=" + transactions +
                ", transmission=" + transmission +
                ", description='" + description + '\'' +
                ", status=" + status +
                "}\n";
    }
}
	


