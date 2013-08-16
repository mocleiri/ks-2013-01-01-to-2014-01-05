package com.sigmasys.kuali.ksa.model;


import javax.persistence.*;

/**
 * Currency model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_CURRENCY",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE"}), @UniqueConstraint(columnNames = {"NAME"})})
@AttributeOverrides({
        @AttributeOverride(name = "code", column = @Column(name = "CODE", length = 5, nullable = false, unique = true)),
        @AttributeOverride(name = "name", column = @Column(name = "NAME", length = 80, nullable = false, unique = true))
})
public class Currency extends AuditableEntity<Long> {


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_CURRENCY",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "CURRENCY_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_CURRENCY")
    @Override
    public Long getId() {
        return id;
    }

}
