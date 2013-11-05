package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;

/**
 * Account status type.
 * <p/>
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_ACNT_STATUS_TYPE")
public class AccountStatusType extends AuditableEntity<Long> {


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_ACNT_TYPE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "ACCOUNT_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_ACNT_TYPE")
    @Override
    public Long getId() {
        return id;
    }
}