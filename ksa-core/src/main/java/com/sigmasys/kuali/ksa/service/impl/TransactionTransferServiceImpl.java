package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.exception.InvalidGeneralLedgerTypeException;
import com.sigmasys.kuali.ksa.exception.InvalidTransactionTypeException;
import com.sigmasys.kuali.ksa.exception.TransactionNotAllowedException;
import com.sigmasys.kuali.ksa.exception.TransactionNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.GeneralLedgerService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.TransactionTransferService;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import javax.persistence.Query;
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
    private GeneralLedgerService generalLedgerService;

    @Autowired
    private AuditableEntityService auditableEntityService;


    /**
     * Retrieves TransferType instance from the persistent store by ID.
     *
     * @param transferTypeId TransferType ID
     * @return TransferType instance
     */
    @Override
    public TransferType getTransferType(Long transferTypeId) {

        PermissionUtils.checkPermission(Permission.READ_TRANSFER_TYPE);

        Query query = em.createQuery("select t from TransferType t " +
                " left outer join fetch t.generalLedgerType " +
                " where t.id = :id");

        query.setParameter("id", transferTypeId);

        List<TransferType> transferTypes = query.getResultList();
        return CollectionUtils.isNotEmpty(transferTypes) ? transferTypes.get(0) : null;
    }


    /**
     * Creates a new instance of TransferType and persists it in the persistent store.
     *
     * @param glTypeId    General Ledger Type ID
     * @param code        TransferType code
     * @param name        TransferType name
     * @param description TransferType description
     * @return TransferType instance
     */
    @Override
    @Transactional(readOnly = false)
    public TransferType createTransferType(Long glTypeId, String code, String name, String description) {

        PermissionUtils.checkPermission(Permission.CREATE_TRANSFER_TYPE);

        if (StringUtils.isBlank(code)) {
            String errMsg = "TransferType code is required";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        GeneralLedgerType glType = generalLedgerService.getGeneralLedgerType(glTypeId);
        if (glType == null) {
            String errMsg = "General Ledger Type with ID = " + glTypeId + " does not exist";
            logger.error(errMsg);
            throw new InvalidGeneralLedgerTypeException(errMsg);
        }

        // Cresting a new instance of TransferType
        TransferType transferType = new TransferType();

        transferType.setGeneralLedgerType(glType);
        transferType.setCode(code);
        transferType.setName(name);
        transferType.setDescription(description);

        // Persisting the new instance of TransferType
        auditableEntityService.persistAuditableEntity(transferType);

        return transferType;
    }

    /**
     * Persists TransferType instance in the persistent store.
     *
     * @param transferType TransferType instance
     * @return TransferType ID
     */
    @Override
    @Transactional(readOnly = false)
    public Long persistTransferType(TransferType transferType) {

        PermissionUtils.checkPermission(Permission.UPDATE_TRANSFER_TYPE);

        return auditableEntityService.persistAuditableEntity(transferType);
    }

    /**
     * Removes TransferType instance from the persistent store by ID.
     *
     * @param transferTypeId TransferType ID
     * @return true, if the transfer type has successfully been deleted, false - otherwise
     */
    @Override
    @Transactional(readOnly = false)
    public boolean deleteTransferType(Long transferTypeId) {

        PermissionUtils.checkPermission(Permission.DELETE_TRANSFER_TYPE);

        return auditableEntityService.deleteAuditableEntity(transferTypeId, TransferType.class);
    }

    /**
     * Returns all transfer types existing in the persistent store.
     *
     * @return list of TransferType instances
     */
    @Override
    public List<TransferType> getTransferTypes() {

        PermissionUtils.checkPermission(Permission.READ_TRANSFER_TYPE);

        Query query = em.createQuery("select t from TransferType t " +
                " left outer join fetch t.generalLedgerType " +
                " order by t.id desc");

        return query.getResultList();
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

        PermissionUtils.checkPermission(Permission.CREATE_TRANSACTION_TRANSFER);

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

        TransferType transferType = getTransferType(transferTypeId);
        if (transferType == null) {
            String errMsg = "Transfer type with ID = " + transactionTypeId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
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

        // Updating transaction from the persistent store
        transaction = transactionService.getTransaction(transactionId);

        // Checking if the amount is less or equal to the transaction unallocated amount
        if (amount.compareTo(transactionService.getUnallocatedAmount(transaction)) > 0) {
            String errMsg = "Transferred amount should be less or equal to transaction unallocated amount";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

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
        Transaction reverseTransaction = transactionService.reverseTransaction(transactionId,
                transactionType.getId().getId(), memoText, amount, statementPrefix, TransactionStatus.TRANSFERRING);

        // Creating a new transaction
        Transaction newTransaction = transactionService.createTransaction(transactionTypeId, accountId, effectiveDate,
                recognitionDate, amount);

        newTransaction.setGeneralLedgerType(transferType.getGeneralLedgerType());
        newTransaction.setOriginationDate(transaction.getOriginationDate());
        newTransaction.setDocument(transaction.getDocument());
        newTransaction.setRollup(transaction.getRollup());

        List<Tag> transactionTags = transaction.getTags();

        if (CollectionUtils.isNotEmpty(transactionTags)) {
            newTransaction.setTags(new ArrayList<Tag>(transactionTags));
        }

        if (StringUtils.isNotBlank(statementPrefix) && StringUtils.isNotBlank(transaction.getStatementText())) {
            newTransaction.setStatementText(statementPrefix + " " + transaction.getStatementText());
        }

        // If both transactions are payments -> copy some additional properties from one to another
        if (newTransaction.getTransactionTypeValue() == TransactionTypeValue.PAYMENT &&
                transaction.getTransactionTypeValue() == TransactionTypeValue.PAYMENT) {

            Payment newPayment = (Payment) newTransaction;
            Payment payment = (Payment) transaction;

            newPayment.setRefundable(payment.isRefundable());
            newPayment.setRefundRule(payment.getRefundRule());
            newPayment.setClearDate(payment.getClearDate());
        }

        // Creating a new TransactionTransfer object and persisting it
        TransactionTransfer transactionTransfer = new TransactionTransfer();
        transactionTransfer.setCreationDate(new Date());
        transactionTransfer.setTransferType(transferType);
        transactionTransfer.setTransferAmount(amount);
        transactionTransfer.setTransactionTypeMask(transactionTypeMask);
        transactionTransfer.setSourceTransaction(transaction);
        transactionTransfer.setOffsetTransaction(reverseTransaction);
        transactionTransfer.setDestTransaction(newTransaction);
        transactionTransfer.setTransactionTypeMask(transactionTypeMask);
        transactionTransfer.setReversalStatus(ReversalStatus.NOT_REVERSED);

        persistEntity(transactionTransfer);

        return transactionTransfer;
    }

    /**
     * Persists TransactionTransfer in the persistent store
     *
     * @param transactionTransfer TransactionTransfer instance
     * @return TransactionTransfer ID
     */
    @Override
    @Transactional(readOnly = true)
    public Long persistTransactionTransfer(TransactionTransfer transactionTransfer) {

        PermissionUtils.checkPermission(Permission.UPDATE_TRANSACTION_TRANSFER);

        return persistEntity(transactionTransfer);
    }


}