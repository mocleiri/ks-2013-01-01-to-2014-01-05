package com.sigmasys.kuali.ksa.model;


import javax.persistence.*;

/**
 * Allowable General Ledger Account model.
 * The account pattern can either represent a GL account itself or a regex value.
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_ALLOWABLE_GL_ACCOUNT")
public class AllowableGlAccount implements Identifiable {

    private Long id;
    private String pattern;

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_ALLOWABLE_GL_ACCOUNT",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "ALLOWABLE_GL_ACCOUNT_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_ALLOWABLE_GL_ACCOUNT")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "PATTERN", length = 128, unique = true, nullable = false)
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
