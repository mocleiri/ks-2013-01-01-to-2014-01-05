package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.TransactionTransfer;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyTransferDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tbornholtz
 * Date: 9/18/13
 */
public class TransactionTransferModel {

    private ThirdPartyTransferDetail thirdPartyTransferDetail;

    private List<TransactionTransfer> transactionTransfer;


    public ThirdPartyTransferDetail getThirdPartyTransferDetail() {
        return thirdPartyTransferDetail;
    }

    public void setThirdPartyTransferDetail(ThirdPartyTransferDetail thirdPartyTransferDetail) {
        this.thirdPartyTransferDetail = thirdPartyTransferDetail;
    }

    public List<TransactionTransfer> getTransactionTransfers() {
        if(transactionTransfer == null) {
            transactionTransfer = new ArrayList<TransactionTransfer>();
        }
        return transactionTransfer;
    }

    public void setTransactionTransfers(List<TransactionTransfer> transactionTransfer) {
        this.transactionTransfer = transactionTransfer;
    }
}
