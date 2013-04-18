package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.GeneralLedgerType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * This class represents a single Batch of General Ledger Transmissions.
 * Each batch may consist of multiple GeneralLedgerType object (GL Accounts).
 * Each batch has a transmission date and a Batch ID.
 * Also, a Batch Transmission has the total amount of all GL Transmissions from
 * all GL Accounts.
 * In the KSA database, GL Transmissions live in the KSSA_GL_TRANSMISSION table,
 * whereas, GL Accounts live in the KSSA_GL_TYPE table.
 *
 * User: Sergey
 * Date: 4/17/13
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class BatchTransmission implements Serializable {

    /**
     * Batch identifier.
     */
    private String batchId;

    /**
     * All General Ledger Accounts that were affected by this batch transmission.
     */
    private List<GeneralLedgerType> glAccounts;

    /**
     * Total amount of all GL Transmissions included in the batch.
     */
    private BigDecimal totalAmount;

    /**
     * Batch transmissions date.
     */
    private Date date;


    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public List<GeneralLedgerType> getGlAccounts() {
        return glAccounts;
    }

    public void setGlAccounts(List<GeneralLedgerType> glAccounts) {
        this.glAccounts = glAccounts;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
