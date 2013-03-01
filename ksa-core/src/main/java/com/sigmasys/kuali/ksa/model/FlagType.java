package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;

/**
 * Flag type.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_FLAG_TYPE")
public class FlagType extends AuditableEntity<Long> {

    /**
     * Access Level
     */
    private Integer accessLevel;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FLAG_TYPE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FLAG_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FLAG_TYPE")
    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "ACCESS_LEVEL")
    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

}
