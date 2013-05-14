package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.AuditableEntity;

import javax.persistence.*;

/**
 * Rate type.
 * <p/>
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RATE_TYPE")
@AttributeOverride(name = "code", column = @Column(name ="CODE", length = 20, nullable = false, unique = true))
public class RateType extends AuditableEntity<Long> {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_RATE_TYPE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "RATE_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_RATE_TYPE")
    @Override
    public Long getId() {
        return id;
    }

}
