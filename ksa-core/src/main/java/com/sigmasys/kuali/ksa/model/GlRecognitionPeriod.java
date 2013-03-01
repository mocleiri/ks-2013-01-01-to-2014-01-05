package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * General Ledger Recognition Period model.
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_GL_RECOGNITION_PERIOD")
public class GlRecognitionPeriod extends AuditableEntity<Long> {


    /**
     * Start date of the period.
     */
    private Date startDate;

    /**
     * End date of the period.
     */
    private Date endDate;

    /**
     * Fiscal year
     */
    private Integer fiscalYear;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GL_RECOGNITION_PERIOD",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "GL_RECOGNITION_PERIOD_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GL_RECOGNITION_PERIOD")
    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "START_DATE", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "END_DATE", nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "FISCAL_YEAR", nullable = false)
    public Integer getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
}
