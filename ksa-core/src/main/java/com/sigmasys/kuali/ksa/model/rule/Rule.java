package com.sigmasys.kuali.ksa.model.rule;

import javax.persistence.*;

/**
 * Rule JPA entity.
 * <p/>
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RULE")
public class Rule extends AbstractRuleEntity {


    /**
     * Rule Priority
     */
    private Integer priority;

    /**
     * "When" condition
     */
    private String lhs;

    /**
     * "Then" clause
     */
    private String rhs;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_RULE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "RULE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_RULE")
    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "PRIORITY")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Column(name = "LHS", length = 4000, nullable = false)
    public String getLhs() {
        return lhs;
    }

    public void setLhs(String lhs) {
        this.lhs = lhs;
    }

    @Column(name = "RHS", length = 4000, nullable = false)
    public String getRhs() {
        return rhs;
    }

    public void setRhs(String rhs) {
        this.rhs = rhs;
    }



}
