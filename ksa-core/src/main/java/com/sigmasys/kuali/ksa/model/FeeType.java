package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;

/**
 * Fee type model.
 * <p/>
 * @author Michael Ivanov
 */
@Deprecated
@Entity
@Table(name = "KSSA_FEE_TYPE")
public class FeeType extends AuditableEntity<Long> {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FEE_TYPE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FEE_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FEE_TYPE")
    @Override
    public Long getId() {
        return id;
    }
    

}
