package com.sigmasys.kuali.ksa.model;


import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;
import java.util.Date;


/**
 * General Ledger transmission model.
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_GL_TRANSMISSION")
public class GlTransmission extends AbstractGlEntity {

    /**
     * Earliest transaction date
     */
    private Date earliestDate;

    /**
     * Latest transaction date
     */
    private Date latestDate;

    /**
     * Batch ID
     */
    private String batchId;

    private GlTransmissionStatus status;


    @PostLoad
    protected void populateTransientFields() {
        super.populateTransientFields();
        status = (statusCode != null) ? EnumUtils.findById(GlTransmissionStatus.class, statusCode) : null;
    }

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_GL_TRANSMISSION",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "GL_TRANSMISSION_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_GL_TRANSMISSION")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @Column(name = "TRANSMISSION_DATE")
    public Date getDate() {
        return date;
    }

    @Column(name = "EARLIEST_DATE")
    public Date getEarliestDate() {
        return earliestDate;
    }

    public void setEarliestDate(Date earliestDate) {
        this.earliestDate = earliestDate;
    }

    @Column(name = "LATEST_DATE")
    public Date getLatestDate() {
        return latestDate;
    }

    public void setLatestDate(Date latestDate) {
        this.latestDate = latestDate;
    }

    @Column(name = "BATCH_ID", length = 100)
    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    @Override
    protected void setStatusCode(String statusCode) {
        super.setStatusCode(statusCode);
        status = EnumUtils.findById(GlTransmissionStatus.class, statusCode);
    }

    @Transient
    public GlTransmissionStatus getStatus() {
        return status;
    }

    public void setStatus(GlTransmissionStatus status) {
        this.status = status;
        statusCode = status.getId();
    }
}
	


