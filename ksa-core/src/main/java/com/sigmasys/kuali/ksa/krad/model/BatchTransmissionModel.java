package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.GlTransmission;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * This class encapsulates information about GlTransmissions that happened
 * as a part of the same batch, ie. share the same Batch ID.
 *
 * User: Sergey
 * Date: 3/12/13
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class BatchTransmissionModel implements Serializable {

    /**
     * Batch ID.
     */
    private String batchId;

    /**
     * Batch transmission date.
     */
    private Date transmissionDate;

    /**
     * Total Batch transmission amount.
     */
    private String formattedAmount;


    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Date getTransmissionDate() {
        return transmissionDate;
    }

    public void setTransmissionDate(Date transmissionDate) {
        this.transmissionDate = transmissionDate;
    }

    public String getFormattedAmount() {
        return formattedAmount;
    }

    public void setFormattedAmount(String formattedAmount) {
        this.formattedAmount = formattedAmount;
    }
}
