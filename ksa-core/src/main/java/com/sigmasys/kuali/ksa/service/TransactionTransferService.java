package com.sigmasys.kuali.ksa.service;

import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.TransactionTransfer;
import com.sigmasys.kuali.ksa.model.TransferType;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The transfer transaction service is a set of methods that take care of transferring transactions
 * from one account to another, or, in the case of payment billing, within the account,
 * breaking a group of transactions into payments with different due dates.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Url(TransactionTransferService.SERVICE_URL)
@WebService(serviceName = TransactionTransferService.SERVICE_NAME, portName = TransactionTransferService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
public interface TransactionTransferService {

    String SERVICE_URL = "transactionTransfer.webservice";
    String SERVICE_NAME = "TransactionTransferService";
    String PORT_NAME = SERVICE_NAME + "Port";

    /**
     * This method transfers responsibility for a transaction from one account to another and
     * does this by issuing a negative transaction on the original account to wipe out its value
     * which is done via the reverseTransaction() method. Then it creates a new transaction on the new account.
     * Amount is passed, allowing only part of a transaction to be moved to a new account.
     * For example, a sponsor may agree to pay 80% of a student’s tuition charges,
     * therefore only 80% of the tuition charge would be transferred.
     * <p/>
     * TODO -> specify the correct parameters and provide their descriptions
     *
     * @param transactionId
     * @param transactionTypeId
     * @param accountId
     * @param transferType
     * @param amount
     * @param effectiveDate
     * @param recognitionDate
     * @param memoText
     * @param statementPrefix
     * @param transactionTypeMask
     * @return TransactionTransfer instance
     */
    TransactionTransfer transferTransaction(Long transactionId, String transactionTypeId, String accountId,
                                            TransferType transferType, BigDecimal amount, Date effectiveDate,
                                            Date recognitionDate, String memoText, String statementPrefix,
                                            String transactionTypeMask);

}
