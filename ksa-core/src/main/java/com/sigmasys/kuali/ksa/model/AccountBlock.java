package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;

/**
 * Account block model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_ACNT_BLOCK")
@AttributeOverride(name = "code", column = @Column(name = "CODE", length = 20, nullable = false, unique = true))
public class AccountBlock extends AuditableEntity<Long> {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_ACNT_BLOCK",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "ACNT_BLOCK_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_ACNT_BLOCK")
    @Override
    public Long getId() {
        return id;
    }


}
