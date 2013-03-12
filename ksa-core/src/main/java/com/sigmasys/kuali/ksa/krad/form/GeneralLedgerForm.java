package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.BatchTransmissionModel;
import com.sigmasys.kuali.ksa.model.GeneralLedgerType;
import com.sigmasys.kuali.ksa.model.Transaction;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 3/12/13
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class GeneralLedgerForm extends AbstractViewModel {

    /**
     * All GL Accounts.
     */
    private List<GeneralLedgerType> glAccounts;

    /**
     * All Batch Transmissions.
     */
    private List<BatchTransmissionModel> batchTransmissions;


    public List<GeneralLedgerType> getGlAccounts() {
        return glAccounts;
    }

    public void setGlAccounts(List<GeneralLedgerType> glAccounts) {
        this.glAccounts = glAccounts;
    }

    public List<BatchTransmissionModel> getBatchTransmissions() {
        return batchTransmissions;
    }

    public void setBatchTransmissions(List<BatchTransmissionModel> batchTransmissions) {
        this.batchTransmissions = batchTransmissions;
    }
}
