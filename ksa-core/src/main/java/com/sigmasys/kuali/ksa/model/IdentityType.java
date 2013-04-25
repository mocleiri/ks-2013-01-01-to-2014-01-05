package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;

/**
 * Identity Type.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_ID_TYPE")
public class IdentityType extends AuditableEntity<Long> {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_ID_TYPE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "ID_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_ID_TYPE")
    @Override
    public Long getId() {
        return id;
    }


}
