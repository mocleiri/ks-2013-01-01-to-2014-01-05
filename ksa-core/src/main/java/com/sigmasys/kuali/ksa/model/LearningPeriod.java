package com.sigmasys.kuali.ksa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * This class represents a single period in a study process.
 * It can be a semester or a half-semester or any arbitrary period of time.
 * <p/>
 * Per existing documentation:
 * Simple dictionary table to define the acceptable period types in FeeBase.
 *
 * @author Sergey
 * @version 1.0
 */

@Entity
@Table(name = "KSSA_LEARNING_PERIOD")
public class LearningPeriod extends AuditableEntity<Long> {

    /**
     * Starting date of the period.
     */
    private Date startDate;

    /**
     * End date of the period.
     */
    private Date endDate;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_LEARNING_PERIOD",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "LEARNING_PERIOD_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_LEARNING_PERIOD")
    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "START_DATE", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    @Column(name = "END_DATE", nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
