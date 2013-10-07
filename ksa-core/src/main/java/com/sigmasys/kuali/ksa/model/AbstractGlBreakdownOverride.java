package com.sigmasys.kuali.ksa.model;


import javax.persistence.*;


/**
 * Abstract GL Breakdown Override model.
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_GL_BREAKDOWN_OVERRIDE")
@DiscriminatorColumn(name = "TYPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractGlBreakdownOverride extends AbstractGlBreakdown {


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_GL_BR_OVERRIDE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "GL_BREAKDOWN_OVERRIDE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_GL_BR_OVERRIDE")
    @Override
    public Long getId() {
        return id;
    }

}
	


