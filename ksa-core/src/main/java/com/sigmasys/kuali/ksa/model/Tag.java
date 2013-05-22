package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;

/**
 * Tag.
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_TAG", uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE"})})
public class Tag extends AuditableEntity<Long> {

    /**
     * Access level
     */
    private Integer accessLevel;

    /**
     * Indicates whether the Tag is administrative or not.
     */
    private Boolean isAdministrative;

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_TAG",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "TAG_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_TAG")
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

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_ADMINISTRATIVE")
    public Boolean isAdministrative() {
        return isAdministrative != null ? isAdministrative : false;
    }

    public void setAdministrative(Boolean isAdministrative) {
        this.isAdministrative = isAdministrative;
    }
}
