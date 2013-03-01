package com.sigmasys.kuali.ksa.model.rule;

import com.sigmasys.kuali.ksa.model.Identifiable;

import javax.persistence.*;


/**
 * Rule Type model.
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RULE_TYPE")
public class RuleType implements Identifiable {

    /**
     * Rule Type ID
     */
    private Long id;

    /**
     * Rule Type Name
     */
    private String name;

    /**
     * Rule Type Description
     */
    private String description;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_RULE_TYPE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "RULE_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_RULE_TYPE")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 16, nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION", length = 512, nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RuleType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
