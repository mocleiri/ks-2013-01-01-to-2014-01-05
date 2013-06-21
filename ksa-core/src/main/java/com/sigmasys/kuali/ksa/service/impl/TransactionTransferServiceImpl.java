package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.exception.InvalidTransactionTypeException;
import com.sigmasys.kuali.ksa.exception.TransactionNotAllowedException;
import com.sigmasys.kuali.ksa.exception.TransactionNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.TransactionTransferService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.*;


/**
 * Transaction Transfer Service implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("transactionTransferService")
@Transactional(readOnly = true)
@WebService(serviceName = TransactionTransferService.SERVICE_NAME, portName = TransactionTransferService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
@SuppressWarnings("unchecked")
public class TransactionTransferServiceImpl extends GenericPersistenceService implements TransactionTransferService {

    private static final Log logger = LogFactory.getLog(TransactionTransferServiceImpl.class);

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;


    public TransferType getTransferType() {
        // TODO
        return null;
    }


    /**
     * This method transfers responsibility for a transaction from one account to another and
     * does this by issuing a negative transaction on the original account to wipe out its value
     * which is done via the reverseTransaction() method. Then it creates a new transaction on the new account.
     * Amount is passed, allowing only part of a transaction to be moved to a new account.
     * For example, a sponsor may agree to pay 80% of a student’s tuition charges,
     * therefore only 80% of the tuition charge would be transferred.
     * <p/>
     *
     * @param transactionId       Transaction ID
     * @param transactionTypeId   TransactionType ID
     * @param transferTypeId      TransferType ID
     * @param accountId           Account ID
     * @param amount              Transaction amount being transferred
     * @param effectiveDate       Effective Date
     * @param recognitionDate     Recognition Date
     * @param memoText            Memo text
     * @param statementPrefix     Statement prefix
     * @param transactionTypeMask Transaction type mask
     * @return TransactionTransfer instance
     */
    @Override
    @Transactional(readOnly = true)
    public TransactionTransfer transferTransaction(Long transactionId,
                                                   String transactionTypeId,
                                                   Long transferTypeId,
                                                   String accountId,
                                                   BigDecimal amount,
                                                   Date effectiveDate,
                                                   Date recognitionDate,
                                                   String memoText,
                                                   String statementPrefix,
                                                   String transactionTypeMask) {

        Transaction transaction = transactionService.getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        if (amount == null) {
            amount = transaction.getAmount();
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) == 0) {
            String errMsg = "Transaction amount cannot be null or 0";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        if (effectiveDate == null) {
            effectiveDate = transaction.getEffectiveDate();
        }

        if (recognitionDate == null) {
            recognitionDate = transaction.getRecognitionDate();
        }

        TransactionType transactionType;
        if (transactionTypeId != null) {
            transactionType = transactionService.getTransactionType(transactionTypeId, recognitionDate);
            if (!(transactionType instanceof DebitType && transaction.getTransactionType() instanceof DebitType) &&
                    !(transactionType instanceof CreditType && transaction.getTransactionType() instanceof CreditType)) {
                String errMsg = "Transactions must have the same type, both credit or debit";
                logger.error(errMsg);
                throw new InvalidTransactionTypeException(errMsg);
            }
        } else {
            transactionType = transaction.getTransactionType();
        }

        // Clearing all non-locked allocations
        transactionService.removeAllocations(transaction.getId());

        // Updating transaction from the persistence store
        transaction = transactionService.getTransaction(transactionId);

        // Checking if the amount is less or equal to the transaction unallocated amount
        if (amount.compareTo(transactionService.getUnallocatedAmount(transaction)) > 0) {
            String errMsg = "Transferred amount should be less or equal to transaction unallocated amount";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        // TODO: Ask Paul to figure out the correct check on the transaction, its type and amount ??

        // Checking if the new transaction is allowed
        if (!transactionService.isTransactionAllowed(accountId, transactionType.getId().getId(), effectiveDate)) {
            String errMsg = "Transaction is not allowed for account = " + accountId +
                    " and effective date = " + effectiveDate;
            logger.error(errMsg);
            throw new TransactionNotAllowedException(errMsg);
        }

        // Checking if the existing transaction is allowed
        if (!transactionService.isTransactionAllowed(transaction.getAccountId(),
                transaction.getTransactionType().getId().getId(), transaction.getEffectiveDate())) {
            String errMsg = "Transaction is not allowed for account = " + transaction.getAccountId() +
                    " and effective date = " + transaction.getEffectiveDate();
            logger.error(errMsg);
            throw new TransactionNotAllowedException(errMsg);
        }

        // Creating a transaction reversal with TRANSFERRING status
        transactionService.reverseTransaction(transactionId, transactionType.getId().getId(),
                memoText, amount, statementPrefix, TransactionStatus.TRANSFERRING);

        // Creating a new transaction
        Transaction newTransaction = transactionService.createTransaction(transactionTypeId, accountId, effectiveDate,
                recognitionDate, amount);

        newTransaction.setGeneralLedgerType(getTransferType().getGeneralLedgerType());
        newTransaction.setOriginationDate(transaction.getOriginationDate());
        newTransaction.setDocument(transaction.getDocument());

        // TODO

        return null;
    }


}