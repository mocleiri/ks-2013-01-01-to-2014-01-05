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
@AttributeOverride(name = "code", column = @Column(name ="CODE", length = 45, nullable = false, unique = true))
public class FlagType extends AuditableEntity<Long> {

    /**
     * Access Level
     */
    private InformationAccessLevel accessLevel;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCESS_LEVEL_ID_FK")
    public InformationAccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(InformationAccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

}