package com.sigmasys.kuali.ksa.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.sigmasys.kuali.ksa.exception.*;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.*;
import com.sigmasys.kuali.ksa.service.security.AccessControlService;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import com.sigmasys.kuali.ksa.util.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Transaction service JPA implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("transactionService")
@Transactional(readOnly = true)
@WebService(serviceName = TransactionService.SERVICE_NAME, portName = TransactionService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
@SuppressWarnings("unchecked")
public class TransactionServiceImpl extends GenericPersistenceService implements TransactionService {

    private static final Log logger = LogFactory.getLog(TransactionServiceImpl.class);

    private static final String GET_TRANSACTION_JOIN =
            " left outer join fetch t.transactionType tt " +
                    " left outer join fetch t.generalLedgerType glt " +
                    " left outer join fetch t.account a " +
                    " left outer join fetch t.currency c " +
                    " left outer join fetch t.rollup r " +
                    " left outer join fetch t.document d ";

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private GeneralLedgerService glService;


    private AccessControlService getAccessControlService() {
        return ContextUtils.getBean(AccessControlService.class);
    }


    private <T extends Transaction> List<T> getTransactions(Class<T> entityType, Date fromDate, Date toDate,
                                                            String... userIds) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION);

        Query query = em.createQuery("select t from " + entityType.getName() + " t " + GET_TRANSACTION_JOIN +
                ((userIds != null && userIds.length > 0) ? " where t.account.id in (:userIds) " : "") +
                (fromDate != null ? " and to_date(t.effectiveDate) >= :fromDate " : "") +
                (toDate != null ? " and to_date(t.effectiveDate) <= :toDate " : "") +
                " order by t.id desc");

        if (fromDate != null) {
            query.setParameter("fromDate", CalendarUtils.removeTime(fromDate), TemporalType.DATE);
        }

        if (toDate != null) {
            query.setParameter("toDate", CalendarUtils.removeTime(toDate), TemporalType.DATE);
        }

        if (userIds != null && userIds.length > 0) {
            query.setParameter("userIds", Arrays.asList(userIds));
        }

        return (List<T>) query.getResultList();
    }

    private <T extends Transaction> T getTransaction(Long id, Class<T> entityType) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION);

        Query query = em.createQuery("select t from " + entityType.getName() + " t " + GET_TRANSACTION_JOIN +
                " where t.id = :id ");
        query.setParameter("id", id);
        List<T> transactions = query.getResultList();
        return CollectionUtils.isNotEmpty(transactions) ? transactions.get(0) : null;
    }

    /**
     * Creates a new transaction based on the given parameters
     *
     * @param transactionTypeId The first part of TransactionTypeId PK, the second part (sub-code) will be calculated
     *                          based on the effective date
     * @param userId            Account ID
     * @param effectiveDate     Transaction effective date
     * @param amount            Transaction amount
     * @return new Transaction instance
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public Transaction createTransaction(String transactionTypeId, String userId, Date effectiveDate, BigDecimal amount) {
        return createTransaction(transactionTypeId, null, userId, effectiveDate, null, amount);
    }

    /**
     * Creates a new transaction based on the given parameters
     *
     * @param transactionTypeId The first part of TransactionTypeId PK, the second part (sub-code) will be calculated
     *                          based on the effective date
     * @param userId            Account ID
     * @param effectiveDate     Transaction Effective date
     * @param recognitionDate   Transaction Recognition date
     * @param amount            Transaction amount
     * @return new Transaction instance
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public Transaction createTransaction(String transactionTypeId, String userId, Date effectiveDate,
                                         Date recognitionDate, BigDecimal amount) {
        return createTransaction(transactionTypeId, null, userId, effectiveDate, recognitionDate, null, amount, false);
    }

    /**
     * Creates a new transaction based on the given parameters
     *
     * @param transactionTypeId The first part of TransactionTypeId PK, the second part (sub-code) will be calculated
     *                          based on the effective date
     * @param externalId        Transaction External ID
     * @param userId            Account ID
     * @param effectiveDate     Transaction Effective Date
     * @param expirationDate    used for deferments only
     * @param amount            Transaction amount
     * @return new Transaction instance
     */
    @Override
    @Transactional(readOnly = false)
    public Transaction createTransaction(String transactionTypeId, String externalId, String userId,
                                         Date effectiveDate, Date expirationDate, BigDecimal amount) {
        return createTransaction(transactionTypeId, externalId, userId, effectiveDate, null, expirationDate, amount, false);
    }

    /**
     * Creates a new transaction based on the given parameters
     *
     * @param transactionTypeId The first part of TransactionTypeId PK, the second part (sub-code) will be calculated
     *                          based on the effective date
     * @param externalId        Transaction External ID
     * @param userId            Account ID
     * @param effectiveDate     Transaction Effective Date
     * @param recognitionDate   Transaction Recognition Date
     * @param expirationDate    Used for deferments only
     * @param amount            Transaction amount
     * @param overrideBlocks    indicates whether the account blocks must be overridden
     * @return new Transaction instance
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public Transaction createTransaction(String transactionTypeId, String externalId, String userId,
                                         Date effectiveDate, Date recognitionDate, Date expirationDate,
                                         BigDecimal amount, boolean overrideBlocks) {
        if (recognitionDate == null) {
            recognitionDate = effectiveDate;
        }
        TransactionTypeId id = getTransactionType(transactionTypeId, recognitionDate).getId();
        return createTransaction(id, externalId, userId, effectiveDate, recognitionDate, expirationDate, amount, overrideBlocks);
    }


    /**
     * Returns the transaction type instance for the given transaction type ID and date
     *
     * @param transactionTypeId The first part of TransactionTypeId PK, the second part (sub-code) will be calculated
     *                          based on the effective date
     * @param date              Transaction effective or recognition Date
     * @return TransactionType instance
     */
    @Override
    public TransactionType getTransactionType(String transactionTypeId, Date date) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION_TYPE);

        date = CalendarUtils.removeTime(date);

        Query query = em.createQuery("select t from TransactionType t " +
                " where t.id.id = :transactionTypeId and :date >= t.startDate and " +
                " (t.endDate is null or t.endDate >= :date)");

        query.setParameter("transactionTypeId", transactionTypeId);
        query.setParameter("date", date, TemporalType.DATE);

        List<TransactionType> transactionTypes = query.getResultList();
        if (CollectionUtils.isNotEmpty(transactionTypes)) {
            return transactionTypes.get(0);
        }

        String errMsg = "Cannot find TransactionType for ID = " + transactionTypeId + " and date = " + date;
        logger.error(errMsg);
        throw new InvalidTransactionTypeException(errMsg);
    }

    /**
     * Returns the transaction type instance for the given transaction type ID and effective date
     *
     * @param transactionTypeId TransactionTypeId instance
     * @return TransactionType instance
     */
    @Override
    @WebMethod(exclude = true)
    public TransactionType getTransactionType(TransactionTypeId transactionTypeId) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION_TYPE);

        Query query = em.createQuery("select t from TransactionType t where t.id = :transactionTypeId");
        query.setParameter("transactionTypeId", transactionTypeId);
        List<TransactionType> transactionTypes = query.getResultList();
        if (CollectionUtils.isNotEmpty(transactionTypes)) {
            return transactionTypes.get(0);
        }
        String errMsg = "Cannot find TransactionType with ID = " + transactionTypeId;
        logger.error(errMsg);
        throw new InvalidTransactionTypeException(errMsg);
    }

    /**
     * Returns the list of transaction type instances for the given string
     *
     * @param pattern    String containing characters within the name
     * @param entityType Class instance of TransactionType subclass
     * @return List of TransactionType instances
     */
    @Override
    @WebMethod(exclude = true)
    public <T extends TransactionType> List<T> getTransactionTypeByNamePattern(String pattern, Class<T> entityType) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION_TYPE);

        if (StringUtils.isBlank(pattern)) {
            String errMsg = "Name pattern cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Query query = em.createQuery("select tt from " + entityType.getName() +
                " tt where upper(tt.id.id) like upper(:pattern) or " +
                " upper(tt.code) like upper(:pattern) or " +
                " upper(tt.name) like upper(:pattern) or " +
                " upper(tt.description) like upper(:pattern)");

        query.setParameter("pattern", "%" + pattern + "%");

        return query.getResultList();
    }

    /**
     * Creates a new debit type based on the given parameters.
     *
     * @param debitTypeId Transaction Type ID
     * @param name        Transaction Type name
     * @param startDate   Transaction type start date
     * @param priority    Priority integer value
     * @param description Default statement text
     * @return a new DebitType instance
     */
    @Override
    @Transactional(readOnly = false)
    public DebitType createDebitType(String debitTypeId, String name, Date startDate, int priority, String description) {
        return createTransactionType(debitTypeId, 0, name, startDate, priority, description, DebitType.class, true);
    }

    /**
     * Creates a new credit type based on the given parameters.
     *
     * @param creditTypeId Transaction Type ID
     * @param name         Transaction Type name
     * @param startDate    Transaction type start date
     * @param priority     Priority integer value
     * @param description  Default statement text
     * @return a new CreditType instance
     */
    @Override
    @Transactional(readOnly = false)
    public CreditType createCreditType(String creditTypeId, String name, Date startDate, int priority, String description) {
        return createTransactionType(creditTypeId, 0, name, startDate, priority, description, CreditType.class, true);
    }

    /**
     * Creates a new debit sub-type based on the given parameters.
     * The original debit type must exist prior to its sub-type creation.
     *
     * @param debitTypeId ID of the existing Debit Type
     * @param startDate   Debit Type start date
     * @return a new DebitType instance
     */
    @Override
    @Transactional(readOnly = false)
    public DebitType createDebitSubType(String debitTypeId, Date startDate) {
        return createTransactionType(debitTypeId, startDate, DebitType.class);
    }

    /**
     * Creates a new credit sub-type based on the given parameters.
     * The original credit type must exist prior to its sub-type creation.
     *
     * @param creditTypeId ID of the existing Credit Type
     * @param startDate    Credit Type start date
     * @return a new CreditType instance
     */
    @Override
    @Transactional(readOnly = false)
    public CreditType createCreditSubType(String creditTypeId, Date startDate) {
        return createTransactionType(creditTypeId, startDate, CreditType.class);
    }

    private synchronized <T extends TransactionType> T createTransactionType(String transactionTypeId, Date startDate,
                                                                             Class<T> entityType) {

        PermissionUtils.checkPermission(Permission.CREATE_TRANSACTION_TYPE);

        T transactionType = getActiveTransactionType(transactionTypeId, entityType);
        if (transactionType == null) {
            String errMsg = "Transaction type with ID = " + transactionTypeId + " does not exist";
            logger.error(errMsg);
            throw new InvalidTransactionTypeException(errMsg);
        }

        startDate = CalendarUtils.removeTime(startDate);

        transactionType.setEndDate(CalendarUtils.addCalendarDays(startDate, -1));

        int nextSubCode = transactionType.getId().getSubCode() + 1;

        return createTransactionType(transactionTypeId, nextSubCode, transactionType.getName(), startDate,
                transactionType.getPriority(), transactionType.getDescription(), entityType, false);

    }

    private <T extends TransactionType> T createTransactionType(String transactionTypeId, int subCode, String name,
                                                                Date startDate, int priority, String description,
                                                                Class<T> entityType, boolean createNewType) {

        PermissionUtils.checkPermission(Permission.CREATE_TRANSACTION_TYPE);

        if (subCode > 0 && createNewType) {
            String errMsg = "Transaction type with ID = " + transactionTypeId + " already exists";
            logger.error(errMsg);
            throw new InvalidTransactionTypeException(errMsg);
        }

        T transactionType = (T) (CreditType.class.equals(entityType) ? new CreditType() : new DebitType());

        TransactionTypeId typeId = new TransactionTypeId(transactionTypeId, subCode);

        transactionType.setId(typeId);
        transactionType.setCode(transactionTypeId);
        transactionType.setName(name);
        transactionType.setStartDate(CalendarUtils.removeTime(startDate));
        transactionType.setPriority(priority);
        transactionType.setDescription(description);
        transactionType.setCreationDate(new Date());
        transactionType.setCreatorId(userSessionManager.getUserId(RequestUtils.getThreadRequest()));

        persistTransactionType(transactionType);

        return transactionType;
    }

    private <T extends TransactionType> T getActiveTransactionType(String transactionTypeId, Class<T> entityType) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION_TYPE);

        Query query = em.createQuery("select t from " + entityType.getName() + " t where t.endDate is null and t.id.id = :id");
        query.setParameter("id", transactionTypeId);
        query.setMaxResults(1);

        List<T> results = query.getResultList();
        return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
    }


    /**
     * Checks if the transaction type exists.
     *
     * @param transactionTypeId Transaction Type ID
     * @return "true" if the transaction type exists, false - otherwise
     */
    @Override
    public boolean transactionTypeExists(String transactionTypeId) {
        Query query = em.createQuery("select 1 from TransactionType where id.id = :id");
        query.setParameter("id", transactionTypeId);
        query.setMaxResults(1);
        return CollectionUtils.isNotEmpty(query.getResultList());
    }

    /**
     * Assigns the general ledger type to the transaction specified by IDs.
     *
     * @param transactionId Transaction ID
     * @param glTypeId      GL Type ID
     */
    @Override
    @Transactional(readOnly = false)
    public void setGeneralLedgerType(Long transactionId, Long glTypeId) {

        PermissionUtils.checkPermission(Permission.EDIT_TRANSACTION);

        Transaction transaction = getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction does not exist for the given ID = " + transactionId;
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        Boolean isGlEntryGenerated = transaction.isGlEntryGenerated();
        if (isGlEntryGenerated != null && isGlEntryGenerated) {
            String errMsg = "GL entry has already been generated for Transaction with ID = " + transactionId;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        GeneralLedgerType generalLedgerType = glService.getGeneralLedgerType(glTypeId);
        if (generalLedgerType == null) {
            String errMsg = "General Ledger Type does not exist for the given ID = " + glTypeId;
            logger.error(errMsg);
            throw new GeneralLedgerTypeNotFoundException(errMsg);
        }

        transaction.setGeneralLedgerType(generalLedgerType);

    }


    /**
     * Creates a new transaction based on the given parameters
     *
     * @param id              Transaction type ID
     * @param userId          Account ID
     * @param effectiveDate   Transaction Effective Date
     * @param recognitionDate Transaction Recognition Date
     * @param expirationDate  Used for deferments only
     * @param amount          Transaction amount
     * @param overrideBlocks  indicates whether the account blocks must be overridden
     * @return new Transaction instance
     */
    protected Transaction createTransaction(TransactionTypeId id, String externalId, String userId,
                                            Date effectiveDate, Date recognitionDate, Date expirationDate,
                                            BigDecimal amount, boolean overrideBlocks) {

        if (amount == null) {
            String errMsg = "Transaction amount must not be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        TransactionType transactionType = getTransactionType(id);
        if (transactionType == null) {
            String errMsg = "Transaction type does not exist for the given ID = " + id;
            logger.error(errMsg);
            throw new TransactionTypeNotFoundException(errMsg);
        }

        Account account = em.find(Account.class, userId);
        if (account == null) {
            String errMsg = "Account does not exist for the given ID = " + userId;
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        String currencyCode = java.util.Currency.getInstance(Locale.getDefault()).getCurrencyCode();
        com.sigmasys.kuali.ksa.model.Currency currency = auditableEntityService.getCurrency(currencyCode);
        if (currency == null) {
            String errMsg = "Currency does not exist for the given ISO code = " + currencyCode;
            logger.error(errMsg);
            throw new CurrencyNotFoundException(errMsg);
        }

        String creatorId = userSessionManager.getUserId(RequestUtils.getThreadRequest());

        if (overrideBlocks) {
            if (!getAccessControlService().isTransactionTypeAllowed(creatorId, id.getId())) {
                String errMsg = "Transaction type is not allowed for the given account = " + creatorId;
                logger.error(errMsg);
                throw new TransactionTypeNotAllowedException(errMsg);
            }
        } else if (!isTransactionAllowed(creatorId, id.getId(), effectiveDate)) {
            String errMsg = "Transaction is not allowed for the given account = " + creatorId;
            logger.error(errMsg);
            throw new TransactionNotAllowedException(errMsg);
        }

        Transaction transaction;
        if (transactionType instanceof CreditType) {
            transaction = (expirationDate != null) ? new Deferment() : new Payment();
        } else {
            transaction = new Charge();
        }

        final Permission permissionToCheck;

        switch (transaction.getTransactionTypeValue()) {
            case PAYMENT:
                permissionToCheck = Permission.CREATE_PAYMENT;
                break;
            case DEFERMENT:
                permissionToCheck = Permission.CREATE_DEFERMENT;
                break;
            case CHARGE:
                permissionToCheck = Permission.CREATE_CHARGE;
                break;
            default:
                String errMsg = "Unknown transaction type = " + transaction.getTransactionTypeValue();
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
        }

        PermissionUtils.checkPermission(permissionToCheck);

        transaction.setTransactionType(transactionType);
        transaction.setAccount(account);
        transaction.setAccountId(account.getId());
        transaction.setCurrency(currency);

        transaction.setExternalId(externalId);
        transaction.setEffectiveDate(effectiveDate);
        transaction.setRecognitionDate(recognitionDate != null ? recognitionDate : effectiveDate);
        transaction.setNativeAmount(amount);
        transaction.setAmount(amount);
        transaction.setAllocatedAmount(BigDecimal.ZERO);
        transaction.setLockedAllocatedAmount(BigDecimal.ZERO);

        transaction.setRollup(transactionType.getRollup());
        transaction.setStatementText(transactionType.getDescription());
        transaction.setGlEntryGenerated(false);
        transaction.setGlOverridden(false);
        transaction.setInternal(false);

        transaction.setCreationDate(new Date());
        transaction.setGeneralLedgerType(glService.getDefaultGeneralLedgerType());

        transaction.setCreatorId(creatorId);

        transaction.setStatus(TransactionStatus.ACTIVE);

        // Copying tags from the transaction type to the new transaction if they exist
        List<Tag> tags = transactionType.getTags();
        if (CollectionUtils.isNotEmpty(tags)) {
            transaction.setTags(new ArrayList<Tag>(tags));
        }

        if (transaction instanceof Payment) {
            CreditType creditType = (CreditType) transactionType;
            Payment payment = (Payment) transaction;
            int clearPeriod = (creditType.getClearPeriod() != null) ? creditType.getClearPeriod() : 0;
            payment.setClearDate(CalendarUtils.addCalendarDays(effectiveDate, clearPeriod));
            payment.setRefundRule(creditType.getRefundRule());
            payment.setRefundable(creditType.isRefundable());
        } else if (transaction instanceof Deferment) {
            Deferment deferment = (Deferment) transaction;
            deferment.setExpirationDate(expirationDate);
            deferment.setOriginalAmount(amount);
        } else {
            DebitType debitType = (DebitType) transactionType;
            Charge charge = (Charge) transaction;
            String cancellationRule = debitType.getCancellationRule();
            if (cancellationRule != null) {
                charge.setCancellationRule(calculateCancellationRule(cancellationRule, effectiveDate));
            }
        }

        persistTransaction(transaction);

        return transaction;
    }


    /**
     * Returns Transaction by ID
     *
     * @param id Transaction ID
     * @return Transaction instance
     */
    @Override
    public Transaction getTransaction(Long id) {
        return getTransaction(id, Transaction.class);
    }

    /**
     * Returns Charge by ID
     *
     * @param id Charge ID
     * @return Charge instance
     */
    @Override
    public Charge getCharge(Long id) {
        return getTransaction(id, Charge.class);
    }

    /**
     * Returns Payment by ID
     *
     * @param id Payment ID
     * @return Payment instance
     */
    @Override
    public Payment getPayment(Long id) {
        return getTransaction(id, Payment.class);
    }

    /**
     * Returns Deferment by ID
     *
     * @param id Deferment ID
     * @return Deferment instance
     */
    @Override
    public Deferment getDeferment(Long id) {
        return getTransaction(id, Deferment.class);
    }


    /**
     * Returns all transactions sorted by ID
     *
     * @return List of transactions
     */
    @Override
    @WebMethod(exclude = true)
    public List<Transaction> getTransactions() {
        return getTransactions(Transaction.class, null, null);
    }

    /**
     * Returns all charges sorted by ID
     *
     * @return List of all charges
     */
    @Override
    @WebMethod(exclude = true)
    public List<Charge> getCharges() {
        return getTransactions(Charge.class, null, null);
    }

    /**
     * Returns all charges by account ID
     *
     * @param userId Account ID
     * @return List of all charges by account ID
     */
    @Override
    public List<Charge> getCharges(String userId) {
        return getTransactions(Charge.class, null, null, userId);
    }

    /**
     * Returns all payments sorted by ID
     *
     * @return List of all payments
     */
    @Override
    @WebMethod(exclude = true)
    public List<Payment> getPayments() {
        return getTransactions(Payment.class, null, null);
    }

    /**
     * Returns all payments by account ID
     *
     * @param userId Account ID
     * @return List of all payments by account ID
     */
    @Override
    public List<Payment> getPayments(String userId) {
        return getTransactions(Payment.class, null, null, userId);
    }


    /**
     * Returns all deferments sorted by ID
     *
     * @return List of all deferments
     */
    @Override
    @WebMethod(exclude = true)
    public List<Deferment> getDeferments() {
        return getTransactions(Deferment.class, null, null);
    }

    /**
     * Returns all deferments by account ID
     *
     * @param userId Account ID
     * @return List of all deferments by account ID
     */
    @Override
    public List<Deferment> getDeferments(String userId) {
        return getTransactions(Deferment.class, null, null, userId);
    }

    /**
     * Returns all transactions by account ID
     *
     * @param userId Account ID
     * @return List of transactions
     */
    @Override
    @WebMethod(exclude = true)
    public List<Transaction> getTransactions(String userId) {
        return getTransactions(Transaction.class, null, null, userId);
    }

    /**
     * Returns all transactions by account ID and date range
     *
     * @param userId   Account ID
     * @param fromDate Start date
     * @param toDate   End date
     * @return List of transactions
     */
    @Override
    public List<Transaction> getTransactions(String userId, Date fromDate, Date toDate) {
        return getTransactions(Transaction.class, fromDate, toDate, userId);
    }


    /**
     * Returns all transactions by account ID, date range and statuses
     *
     * @param userId   Account ID
     * @param fromDate Start date
     * @param toDate   End date
     * @param statuses Array of transaction statuses
     * @return List of transactions
     */
    @Override
    @WebMethod(exclude = true)
    public List<Transaction> getTransactions(String userId, Date fromDate, Date toDate, TransactionStatus... statuses) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION);

        List<String> statusCodes = new ArrayList<String>(statuses.length);
        for (TransactionStatus status : statuses) {
            statusCodes.add(status.getId());
        }

        Query query = em.createQuery("select t from Transaction t " + GET_TRANSACTION_JOIN +
                " where t.account.id = :userId and t.statusCode in (:statusCodes) " +
                (fromDate != null ? " and t.effectiveDate >= :fromDate " : "") +
                (toDate != null ? " and t.effectiveDate <= :toDate " : "") +
                " order by t.id desc");

        if (fromDate != null) {
            query.setParameter("fromDate", CalendarUtils.removeTime(fromDate), TemporalType.DATE);
        }

        if (toDate != null) {
            query.setParameter("toDate", CalendarUtils.removeTime(toDate), TemporalType.DATE);
        }

        query.setParameter("userId", userId);
        query.setParameter("statusCodes", statusCodes);

        return query.getResultList();
    }

    /**
     * Persists the transaction in the database.
     * Creates a new entity when ID is null and updates the existing one otherwise.
     *
     * @param transaction Transaction instance
     * @return Transaction ID
     */
    @Override
    @Transactional(readOnly = false)
    public Long persistTransaction(Transaction transaction) {

        PermissionUtils.checkPermission(Permission.EDIT_TRANSACTION);

        return persistEntity(transaction);
    }

    /**
     * Persists the transaction type in the database.
     * Creates a new entity when ID is null and updates the existing one otherwise.
     *
     * @param transactionType TransactionType instance
     * @return Transaction Type ID
     */
    @Override
    @Transactional(readOnly = false)
    public TransactionTypeId persistTransactionType(TransactionType transactionType) {

        PermissionUtils.checkPermission(Permission.EDIT_TRANSACTION_TYPE);

        return persistEntity(transactionType);
    }

    /**
     * Removes the transaction from the database.
     *
     * @param id Transaction ID
     * @return true if the Transaction entity has been deleted
     */
    @Override
    @Transactional(readOnly = false)
    public boolean deleteTransaction(Long id) {

        PermissionUtils.checkPermission(Permission.EDIT_TRANSACTION);

        return deleteEntity(id, Transaction.class);
    }

    /**
     * This will allocate the value of amount on the transaction. A check will
     * be made to ensure that the allocated amount is equal to or less than the
     * localAmount, less any lockedAllocationAmount. The expectation is that
     * this method will only be called by the payment application module.
     * <p/>
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @param amount         amount of money to be allocated
     * @return a new CompositeAllocation instance that has references to Allocation and GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public CompositeAllocation createAllocation(Long transactionId1, Long transactionId2, BigDecimal amount) {
        return createAllocation(transactionId1, transactionId2, amount, true, false, false);
    }

    /**
     * This will allocate the value of amount on the transaction. A check will
     * be made to ensure that the allocated amount is equal to or less than the
     * localAmount, less any lockedAllocationAmount. The expectation is that
     * this method will only be called by the payment application module.
     * <p/>
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @param amount         amount of money to be allocated
     * @param isQueued       indicates whether the GL transaction should be in Q or W status
     * @return a new CompositeAllocation instance that has references to Allocation and GL transactions
     */
    @Override
    @Transactional(readOnly = false)
    public CompositeAllocation createAllocation(Long transactionId1, Long transactionId2, BigDecimal amount, boolean isQueued) {
        return createAllocation(transactionId1, transactionId2, amount, isQueued, false, false);
    }

    protected CompositeAllocation createAllocation(Long transactionId1, Long transactionId2, BigDecimal newAmount,
                                                   boolean isQueued, boolean locked, boolean internallyLocked) {

        Transaction transaction1 = getTransaction(transactionId1);
        if (transaction1 == null) {
            String errMsg = "Transaction with ID = " + transactionId1 + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        Transaction transaction2 = getTransaction(transactionId2);
        if (transaction2 == null) {
            String errMsg = "Transaction with ID = " + transactionId2 + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        return createAllocation(transaction1, transaction2, newAmount, isQueued, locked, internallyLocked);
    }

    private void addAllocatedAmount(Transaction transaction, BigDecimal newAmount, boolean locked) {

        if (newAmount == null) {
            newAmount = BigDecimal.ZERO;
        }

        BigDecimal oldAmount = locked ? transaction.getLockedAllocatedAmount() : transaction.getAllocatedAmount();

        if (oldAmount == null) {
            oldAmount = BigDecimal.ZERO;
        }

        BigDecimal totalAmount = oldAmount.add(newAmount);

        if (locked) {
            transaction.setLockedAllocatedAmount(totalAmount);
        } else {
            transaction.setAllocatedAmount(totalAmount);
        }
    }

    /**
     * Creates an allocation between two transactions with the specified parameters.
     *
     * @param transaction1     First transaction
     * @param transaction2     Second transaction
     * @param newAmount        amount to be allocated
     * @param isQueued         indicates whether the GL transaction should be in Q or W status
     * @param locked           indicates whether the allocation should be locked or unlocked
     * @param internallyLocked indicates whether the allocation should be internally locked or unlocked
     * @return a new CompositeAllocation instance that has references to Allocation and GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public CompositeAllocation createAllocation(Transaction transaction1, Transaction transaction2, BigDecimal newAmount,
                                                boolean isQueued, boolean locked, boolean internallyLocked) {

        final Long transactionId1 = transaction1.getId();
        final Long transactionId2 = transaction2.getId();

        if (internallyLocked) {
            if (!locked) {
                String errMsg = "Internally locked allocations must also be locked";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }
            PermissionUtils.checkPermission(Permission.CREATE_INTERNALLY_LOCKED_ALLOCATION);
        } else if (locked && !internallyLocked) {
            PermissionUtils.checkPermission(Permission.CREATE_LOCKED_ALLOCATION);
        } else {
            PermissionUtils.checkPermission(Permission.CREATE_ALLOCATION);
        }

        if (newAmount == null || newAmount.compareTo(BigDecimal.ZERO) <= 0) {
            String errMsg = "The allocation amount should be a positive number";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (transaction1.getAccount() == null || transaction2.getAccount() == null) {
            String errMsg = "Transaction must be associated with Account";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        Account account = transaction1.getAccount();
        String userId = account.getId();
        if (!userId.equals(transaction2.getAccount().getId())) {
            String errMsg = "Both transactions must be associated with the same account";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        // Check if Transaction1 can pay Transaction2
        if (!canPay(transactionId1, transactionId2)) {
            String errMsg = "Transaction1 [ID = " + transactionId1 + "] cannot pay Transaction2 [ID = " +
                    transactionId2 + "]";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        Query query = em.createQuery("select distinct a from Allocation a " +
                " where a.account.id = :userId and ((a.firstTransaction.id = :id1 and a.secondTransaction.id = :id2) or " +
                " (a.firstTransaction.id = :id2 and a.secondTransaction.id = :id1)) and a.locked = :locked");

        query.setParameter("userId", userId);
        query.setParameter("id1", transactionId1);
        query.setParameter("id2", transactionId2);
        query.setParameter("locked", locked);

        List<Allocation> allocations = query.getResultList();

        for (Allocation allocation : allocations) {

            PermissionUtils.checkPermissions(allocation,
                    Permission.REMOVE_ALLOCATION,
                    Permission.REMOVE_LOCKED_ALLOCATION,
                    Permission.REMOVE_INTERNALLY_LOCKED_ALLOCATION);

            BigDecimal allocatedAmount1 = locked ? transaction1.getLockedAllocatedAmount() :
                    transaction1.getAllocatedAmount();

            BigDecimal allocatedAmount2 = locked ? transaction2.getLockedAllocatedAmount() :
                    transaction2.getAllocatedAmount();

            if (allocatedAmount1 == null) {
                allocatedAmount1 = BigDecimal.ZERO;
            }

            if (allocatedAmount2 == null) {
                allocatedAmount2 = BigDecimal.ZERO;
            }

            BigDecimal newAllocatedAmount1 = (allocatedAmount1.compareTo(BigDecimal.ZERO) >= 0) ?
                    allocatedAmount1.subtract(allocation.getAmount()) :
                    allocatedAmount1.add(allocation.getAmount());

            BigDecimal newAllocatedAmount2 = (allocatedAmount2.compareTo(BigDecimal.ZERO) >= 0) ?
                    allocatedAmount2.subtract(allocation.getAmount()) :
                    allocatedAmount2.add(allocation.getAmount());

            if (locked) {
                transaction1.setLockedAllocatedAmount(newAllocatedAmount1);
                transaction2.setLockedAllocatedAmount(newAllocatedAmount2);
            } else {
                transaction1.setAllocatedAmount(newAllocatedAmount1);
                transaction2.setAllocatedAmount(newAllocatedAmount2);
            }

            deleteEntity(allocation.getId(), Allocation.class);
        }

        BigDecimal unallocatedAmount1 = getUnallocatedAmount(transaction1);
        BigDecimal unallocatedAmount2 = getUnallocatedAmount(transaction2);

        if (unallocatedAmount1.abs().compareTo(newAmount) < 0 || unallocatedAmount2.abs().compareTo(newAmount) < 0) {
            String errMsg = "Not enough balance to cover the allocation amount " + newAmount;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        TransactionType transactionType1 = transaction1.getTransactionType();
        TransactionType transactionType2 = transaction2.getTransactionType();

        boolean canAllocate = false;
        if ((transactionType1 instanceof DebitType && transactionType2 instanceof CreditType) ||
                (transactionType1 instanceof CreditType && transactionType2 instanceof DebitType)) {
            canAllocate = (unallocatedAmount1.compareTo(BigDecimal.ZERO) > 0 &&
                    unallocatedAmount2.compareTo(BigDecimal.ZERO) > 0);
        } else if ((transactionType1 instanceof DebitType && transactionType2 instanceof DebitType) ||
                (transactionType1 instanceof CreditType && transactionType2 instanceof CreditType)) {
            canAllocate = (unallocatedAmount1.compareTo(BigDecimal.ZERO) > 0 &&
                    unallocatedAmount2.compareTo(BigDecimal.ZERO) < 0) ||
                    (unallocatedAmount1.compareTo(BigDecimal.ZERO) < 0 &&
                            unallocatedAmount2.compareTo(BigDecimal.ZERO) > 0);
        }

        if (canAllocate) {

            Allocation allocation = new Allocation();
            allocation.setAccount(account);
            allocation.setFirstTransaction(transaction1);
            allocation.setSecondTransaction(transaction2);
            allocation.setAmount(newAmount);
            allocation.setLocked(locked);
            allocation.setInternallyLocked(internallyLocked);

            persistEntity(allocation);

            addAllocatedAmount(transaction1, newAmount, locked);
            addAllocatedAmount(transaction2, newAmount, locked);

            persistTransaction(transaction1);
            persistTransaction(transaction2);

            CompositeAllocation compositeAllocation = new CompositeAllocation();
            compositeAllocation.setAllocation(allocation);

            // Creating GL transactions for charge+payment or payment+charge only
            if ((transaction1.getTransactionTypeValue() == TransactionTypeValue.CHARGE &&
                    transaction2.getTransactionTypeValue() == TransactionTypeValue.PAYMENT) ||
                    (transaction1.getTransactionTypeValue() == TransactionTypeValue.PAYMENT &&
                            transaction2.getTransactionTypeValue() == TransactionTypeValue.CHARGE)) {
                String statement = configService.getParameter(Constants.DEFAULT_GL_PA_STATEMENT);
                Pair<GlTransaction, GlTransaction> pair =
                        createGlTransactions(transaction1, transaction2, newAmount, statement, isQueued);
                compositeAllocation.setCreditGlTransaction(pair.getA());
                compositeAllocation.setDebitGlTransaction(pair.getB());
            }

            return compositeAllocation;

        } else {
            String errMsg = "Illegal allocation. Transaction IDs: " + transactionId1 + ", " + transactionId2 +
                    " Amount: " + newAmount;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
    }

    /**
     * Creates the credit and debit transactions
     *
     * @param transaction1 First Transaction instance
     * @param transaction2 Second Transaction instance
     * @param amount       Allocation amount
     * @param statement    GL transaction statement
     * @param isQueued     indicates whether the GL transaction should be in Q or W status
     * @return Pair instance with credit and debit GL transactions
     */
    protected Pair<GlTransaction, GlTransaction> createGlTransactions(Transaction transaction1,
                                                                      Transaction transaction2,
                                                                      BigDecimal amount,
                                                                      String statement,
                                                                      boolean isQueued) {

        PermissionUtils.checkPermission(Permission.CREATE_GL_TRANSACTION);


        TransactionType transactionType1 = transaction1.getTransactionType();
        TransactionType transactionType2 = transaction2.getTransactionType();

        Pair<GlTransaction, GlTransaction> pair = new Pair<GlTransaction, GlTransaction>();

        if ((transactionType1 instanceof DebitType && transactionType2 instanceof CreditType) ||
                (transactionType1 instanceof CreditType && transactionType2 instanceof DebitType)) {

            final Credit creditTransaction;
            final Debit debitTransaction;
            final CreditType creditType;

            if (transactionType1 instanceof CreditType) {
                creditTransaction = (Credit) transaction1;
                debitTransaction = (Debit) transaction2;
                creditType = (CreditType) transactionType1;
            } else {
                creditTransaction = (Credit) transaction2;
                debitTransaction = (Debit) transaction1;
                creditType = (CreditType) transactionType2;
            }

            // Getting the opposite GL operation for credit
            GlOperationType operationType = (GlOperationType.CREDIT == creditType.getUnallocatedGlOperation()) ?
                    GlOperationType.DEBIT :
                    GlOperationType.CREDIT;

            // Creating GL transaction for credit
            GlTransaction creditGlTransaction = glService.createGlTransaction(creditTransaction.getId(),
                    creditType.getUnallocatedGlAccount(), amount, operationType, statement, isQueued);


            pair.setA(creditGlTransaction);

            GeneralLedgerType glType = debitTransaction.getGeneralLedgerType();

            if (glType != null) {

                // Getting the opposite GL operation for debit
                operationType = (GlOperationType.CREDIT.equals(glType.getGlOperationOnCharge())) ?
                        GlOperationType.DEBIT :
                        GlOperationType.CREDIT;

                // Creating GL transaction for debit
                GlTransaction debitGlTransaction = glService.createGlTransaction(debitTransaction.getId(),
                        glType.getGlAccountId(), amount, operationType, statement, isQueued);
                pair.setB(debitGlTransaction);
            }

        }

        return pair;
    }

    /**
     * Returns the total unallocated amount for the given transaction
     *
     * @param transaction Transaction instance
     * @return the total unallocated amount
     */
    @Override
    public BigDecimal getUnallocatedAmount(Transaction transaction) {
        return TransactionUtils.getUnallocatedAmount(transaction);
    }

    /**
     * This will allocate a locked amount on the transaction. A check will be
     * made to ensure that the lockedAmount and the allocateAmount don't exceed
     * the ledgerAmount of the transaction. Setting an amount as locked prevents
     * the payment application system from reallocating the balance elsewhere.
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @param amount         amount of money to be allocated
     * @return a new CompositeAllocation instance that has references to Allocation and GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public CompositeAllocation createLockedAllocation(Long transactionId1, Long transactionId2, BigDecimal amount) {
        return createAllocation(transactionId1, transactionId2, amount, true, true, false);
    }

    /**
     * This will allocate a locked amount on the transaction. A check will be
     * made to ensure that the lockedAmount and the allocateAmount don't exceed
     * the ledgerAmount of the transaction. Setting an amount as locked prevents
     * the payment application system from reallocating the balance elsewhere.
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @param amount         amount of money to be allocated
     * @param isQueued       indicates whether the GL transaction should be in Q or W status
     * @return a new CompositeAllocation instance that has references to Allocation and GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public CompositeAllocation createLockedAllocation(Long transactionId1, Long transactionId2, BigDecimal amount,
                                                      boolean isQueued) {
        return createAllocation(transactionId1, transactionId2, amount, isQueued, true, false);
    }

    /**
     * This will allocate a locked amount on the transaction. A check will be
     * made to ensure that the lockedAmount and the allocateAmount don't exceed
     * the ledgerAmount of the transaction. Setting an amount as locked prevents
     * the payment application system from reallocating the balance elsewhere.
     *
     * @param transactionId1   transaction1 ID
     * @param transactionId2   transaction2 ID
     * @param amount           amount of money to be allocated
     * @param isQueued         indicates whether the GL transaction should be in Q or W status
     * @param internallyLocked indicates whether the allocation should be internally locked or not
     * @return a new CompositeAllocation instance that has references to Allocation and GL transactions
     */
    public CompositeAllocation createLockedAllocation(Long transactionId1, Long transactionId2, BigDecimal amount,
                                                      boolean isQueued, boolean internallyLocked) {
        return createAllocation(transactionId1, transactionId2, amount, isQueued, true, true);
    }

    /**
     * Retrieves all allocations associated with the given transaction by ID.
     * <p/>
     *
     * @param transactionId Transaction ID
     * @return list of allocations
     */
    @Override
    public List<Allocation> getAllocations(Long transactionId) {

        PermissionUtils.checkPermission(Permission.READ_ALLOCATION);

        Query query = em.createQuery("select a from Allocation a " +
                " left outer join fetch a.account ac " +
                " inner join fetch a.firstTransaction t1 " +
                " inner join fetch a.secondTransaction t2 " +
                " inner join fetch t1.transactionType tt1 " +
                " inner join fetch t2.transactionType tt2 " +
                " where t1.id = :id or t2.id = :id");

        query.setParameter("id", transactionId);

        List<Allocation> allocations = query.getResultList();

        Set<Allocation> allocationSet = new HashSet<Allocation>();
        if (CollectionUtils.isNotEmpty(allocations)) {
            for (Allocation allocation : allocations) {
                if (!allocationSet.contains(allocation)) {
                    allocationSet.add(allocation);
                }
            }
        }

        ArrayList<Allocation> sortedAllocations = new ArrayList<Allocation>(allocationSet);

        Collections.sort(sortedAllocations, new Comparator<Allocation>() {
            @Override
            public int compare(Allocation o1, Allocation o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });

        return sortedAllocations;
    }

    /**
     * Removes all allocations (locked and non-locked) associated with the given transaction.
     * <p/>
     *
     * @param transactionId Transaction ID
     * @return list of generated GL transactions
     */
    @Override
    @Transactional(readOnly = false)
    public List<GlTransaction> removeAllAllocations(Long transactionId) {
        return removeAllocations(transactionId, false);
    }

    /**
     * Removes non-locked allocations associated with the given transaction.
     * <p/>
     *
     * @param transactionId transaction ID
     * @return list of generated GL transactions
     */
    @Override
    @Transactional(readOnly = false)
    @WebMethod(exclude = true)
    public List<GlTransaction> removeAllocations(Long transactionId) {
        return removeAllocations(transactionId, true);
    }

    private List<GlTransaction> removeAllocations(Long transactionId, boolean excludeLockAllocations) {

        Transaction transaction = getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        StringBuilder builder = new StringBuilder("select distinct a from Allocation a " +
                " where (a.firstTransaction.id = :id or a.secondTransaction.id = :id)");

        if (excludeLockAllocations) {
            builder.append(" and a.locked <> true)");
        }

        Query query = em.createQuery(builder.toString());

        query.setParameter("id", transactionId);

        List<Allocation> allocations = query.getResultList();

        List<GlTransaction> glTransactions = new LinkedList<GlTransaction>();
        if (CollectionUtils.isNotEmpty(allocations)) {
            for (Allocation allocation : new HashSet<Allocation>(allocations)) {
                glTransactions.addAll(removeAllocation(allocation, true));
            }
        }

        return glTransactions;
    }


    /**
     * Removes all allocations (locked and non-locked) associated with the given Account ID
     * <p/>
     *
     * @param userId Account ID
     * @return list of generated GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<GlTransaction> removeAllAllocations(String userId) {

        List<GlTransaction> glTransactions = new LinkedList<GlTransaction>();

        Query query = em.createQuery("select t.id from Transaction t where t.account.id = :userId");
        query.setParameter("userId", userId);

        List<Long> transactionIds = query.getResultList();
        if (CollectionUtils.isNotEmpty(transactionIds)) {
            for (Long transactionId : transactionIds) {
                glTransactions.addAll(removeAllAllocations(transactionId));
            }
        }

        return glTransactions;
    }

    /**
     * Removes all allocations (locked and non-locked) associated with the given transaction list.
     * <p/>
     *
     * @param transactions list of transactions for which allocations have to be removed
     * @return list of generated GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<GlTransaction> removeAllAllocations(List<Transaction> transactions) {

        List<GlTransaction> glTransactions = new LinkedList<GlTransaction>();
        for (Transaction transaction : transactions) {
            glTransactions.addAll(removeAllAllocations(transaction.getId()));
        }

        return glTransactions;
    }

    /**
     * Removes non-locked allocations associated with the given transaction list.
     * <p/>
     *
     * @param transactions list of transactions for which allocations have to be removed
     * @return list of generated GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<GlTransaction> removeAllocations(List<Transaction> transactions) {

        List<GlTransaction> glTransactions = new LinkedList<GlTransaction>();
        for (Transaction transaction : transactions) {
            glTransactions.addAll(removeAllocations(transaction.getId()));
        }

        return glTransactions;
    }

    /**
     * Removes allocation between two given transactions
     * <p/>
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @return list of GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<GlTransaction> removeAllocation(Long transactionId1, Long transactionId2) {
        return removeAllocation(transactionId1, transactionId2, true, false);
    }


    /**
     * Removes allocation between two given transactions
     * <p/>
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @param isQueued       indicates whether the GL transaction should be in Q or W status
     * @return list of GL transactions
     */
    @Override
    @Transactional(readOnly = false)
    public List<GlTransaction> removeAllocation(Long transactionId1, Long transactionId2, boolean isQueued) {
        return removeAllocation(transactionId1, transactionId2, isQueued, false);
    }

    /**
     * Removes locked allocation between two given transactions
     * <p/>
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @return list of GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<GlTransaction> removeLockedAllocation(Long transactionId1, Long transactionId2) {
        return removeAllocation(transactionId1, transactionId2, true, true);
    }

    /**
     * Removes locked allocation between two given transactions
     * <p/>
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @param isQueued       indicates whether the GL transaction should be in Q or W status
     * @return list of GL transactions
     */
    @Override
    @Transactional(readOnly = false)
    public List<GlTransaction> removeLockedAllocation(Long transactionId1, Long transactionId2, boolean isQueued) {
        return removeAllocation(transactionId1, transactionId2, isQueued, true);
    }

    protected List<GlTransaction> removeAllocation(Allocation allocation, boolean isQueued) {

        PermissionUtils.checkPermissions(allocation,
                Permission.REMOVE_ALLOCATION,
                Permission.REMOVE_LOCKED_ALLOCATION,
                Permission.REMOVE_INTERNALLY_LOCKED_ALLOCATION);

        List<GlTransaction> glTransactions = new LinkedList<GlTransaction>();

        boolean locked = allocation.isLocked();

        Transaction transaction1 = allocation.getFirstTransaction();
        Transaction transaction2 = allocation.getSecondTransaction();

        BigDecimal allocatedAmount = (allocation.getAmount() != null) ? allocation.getAmount() : BigDecimal.ZERO;

        BigDecimal allocatedAmount1 = locked ? transaction1.getLockedAllocatedAmount() :
                transaction1.getAllocatedAmount();

        BigDecimal allocatedAmount2 = locked ? transaction2.getLockedAllocatedAmount() :
                transaction2.getAllocatedAmount();

        if (allocatedAmount1 == null) {
            allocatedAmount1 = BigDecimal.ZERO;
        }

        if (allocatedAmount2 == null) {
            allocatedAmount2 = BigDecimal.ZERO;
        }

        BigDecimal newAmount1 = allocatedAmount1.subtract(allocatedAmount);
        BigDecimal newAmount2 = allocatedAmount2.subtract(allocatedAmount);

        if (locked) {
            transaction1.setLockedAllocatedAmount(newAmount1);
            transaction2.setLockedAllocatedAmount(newAmount2);
        } else {
            transaction1.setAllocatedAmount(newAmount1);
            transaction2.setAllocatedAmount(newAmount2);
        }

        deleteEntity(allocation.getId(), Allocation.class);

        // Creating GL transactions for charge+payment or payment+charge only
        if ((transaction1.getTransactionTypeValue() == TransactionTypeValue.CHARGE &&
                transaction2.getTransactionTypeValue() != TransactionTypeValue.PAYMENT) ||
                (transaction1.getTransactionTypeValue() == TransactionTypeValue.PAYMENT &&
                        transaction2.getTransactionTypeValue() != TransactionTypeValue.CHARGE)) {
            String statement = configService.getParameter(Constants.DEFAULT_GL_PA_STATEMENT);
            Pair<GlTransaction, GlTransaction> pair =
                    createGlTransactions(transaction1, transaction2, allocatedAmount, statement, isQueued);
            glTransactions.add(pair.getA());
            glTransactions.add(pair.getB());
        }

        return glTransactions;

    }

    protected List<GlTransaction> removeAllocation(Long transactionId1, Long transactionId2,
                                                   boolean isQueued, boolean locked) {

        Transaction transaction1 = getTransaction(transactionId1);
        if (transaction1 == null) {
            String errMsg = "Transaction with ID = " + transactionId1 + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        Transaction transaction2 = getTransaction(transactionId2);
        if (transaction2 == null) {
            String errMsg = "Transaction with ID = " + transactionId2 + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        Query query = em.createQuery("select distinct a from Allocation a " +
                " where ((a.firstTransaction.id = :id1 and a.secondTransaction.id = :id2) or " +
                " (a.firstTransaction.id = :id2 and a.secondTransaction.id = :id1)) and a.locked = :locked");

        query.setParameter("id1", transactionId1);
        query.setParameter("id2", transactionId2);
        query.setParameter("locked", locked);

        List<Allocation> allocations = query.getResultList();

        List<GlTransaction> glTransactions = new LinkedList<GlTransaction>();

        if (CollectionUtils.isNotEmpty(allocations)) {

            for (Allocation allocation : new HashSet<Allocation>(allocations)) {
                glTransactions.addAll(removeAllocation(allocation, isQueued));
            }

        } else {
            logger.warn("Allocation does not exist for transactions: '" + transactionId1 +
                    "' and '" + transactionId2 + "'");
        }

        return glTransactions;

    }

    private List<AbstractGlBreakdown> getGlBreakdowns(Transaction transaction) {

        GeneralLedgerType glType = transaction.getGeneralLedgerType();
        if (glType == null) {
            String errMsg = "Transaction (ID = " + transaction.getId() + ") must have GL type";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        Query query = em.createQuery("select g from " +
                (transaction.isGlOverridden() ? "GlBreakdownOverride" : "GlBreakdown") +
                " g where " +
                (transaction.isGlOverridden() ? "g.transaction.id" : "g.generalLedgerType.id") +
                " = :id order by g.breakdown desc");

        query.setParameter("id", transaction.isGlOverridden() ? transaction.getId() : glType.getId());

        List<AbstractGlBreakdown> breakdowns = query.getResultList();

        if (!transaction.isGlOverridden() && CollectionUtils.isEmpty(breakdowns)) {
            GeneralLedgerType defaultGlType = glService.getDefaultGeneralLedgerType();
            query.setParameter("id", defaultGlType.getId());
            breakdowns = query.getResultList();
        }

        return breakdowns;
    }

    /**
     * This method persists new GL breakdowns and associates them with the given GL and transaction types.
     * It also provides validation of the breakdowns.
     *
     * @param glTypeId          GL type ID
     * @param transactionTypeId Transaction type ID
     * @param breakdowns        a list of GL breakdowns
     * @return a list of GL breakdown IDs
     */
    @Override
    @Transactional(readOnly = false)
    public List<Long> createGlBreakdowns(Long glTypeId, TransactionTypeId transactionTypeId, List<GlBreakdown> breakdowns) {

        PermissionUtils.checkPermission(Permission.CREATE_GL_BREAKDOWN);

        List<Long> breakdownIds = new ArrayList<Long>(breakdowns.size());

        GeneralLedgerType glType = glService.getGeneralLedgerType(glTypeId);
        if (glType == null) {
            String errMsg = "General Ledger Type with ID = " + glTypeId + " does not exist";
            logger.error(errMsg);
            throw new InvalidGeneralLedgerTypeException(errMsg);
        }

        TransactionType debitType = getTransactionType(transactionTypeId);
        if (!(debitType instanceof DebitType)) {
            String errMsg = "Transaction Type with ID = " + glTypeId + " must be DebitType";
            logger.error(errMsg);
            throw new InvalidTransactionTypeException(errMsg);
        }

        // Removing all existing GL breakdowns for the same transaction type
        Query query = em.createQuery("delete from GlBreakdown where debitType.id = :debitTypeId");
        query.setParameter("debitTypeId", transactionTypeId);
        query.executeUpdate();

        boolean hasZeroPercent = false;
        BigDecimal totalPercentage = BigDecimal.ZERO;

        for (GlBreakdown breakdown : breakdowns) {

            if (!glService.isGlAccountValid(breakdown.getGlAccount())) {
                String errMsg = "GL account '" + breakdown.getGlAccount() + "' is invalid";
                logger.error(errMsg);
                throw new InvalidGeneralLedgerAccountException(errMsg);
            }
            if (breakdown.getBreakdown() == null) {
                String errMsg = "GL breakdown does not have any percentage value";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            } else if (breakdown.getBreakdown().compareTo(BigDecimal.ZERO) == 0) {
                if (hasZeroPercent) {
                    String errMsg = "One and only one breakdown must have 0 percentage value for the given GL type";
                    logger.error(errMsg);
                    throw new IllegalStateException(errMsg);
                }
                hasZeroPercent = true;
            }

            totalPercentage = totalPercentage.add(breakdown.getBreakdown());

            breakdown.setDebitType((DebitType) debitType);
            breakdown.setGeneralLedgerType(glType);

            Long breakdownId = persistEntity(breakdown);
            breakdownIds.add(breakdownId);
        }

        if (totalPercentage.compareTo(new BigDecimal(100)) >= 0) {
            String errMsg = "The total percentage value of all breakdowns cannot be equal to and greater than 100";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        return breakdownIds;
    }

    /**
     * Moves a transaction from a pre-effective state to an effective state. Once a transaction is effective, its
     * general ledger entries are created. In certain cases, a transaction might be moved to an effective state
     * before its effective date, in which case, forceEffective is passed as true.
     *
     * @param transactionId  transaction ID
     * @param forceEffective indicates whether it has to be forced
     */
    @Override
    @Transactional(readOnly = false)
    public void makeEffective(Long transactionId, boolean forceEffective) {

        PermissionUtils.checkPermission(Permission.CREATE_GL_TRANSACTION);

        Transaction transaction = getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Debit with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        if (transaction.isGlEntryGenerated() ||
                (new Date().before(transaction.getEffectiveDate()) && !forceEffective)) {
            logger.info("Cannot make transaction effective, ID = " + transaction);
            return;
        }

        if (transaction.getTransactionTypeValue() == TransactionTypeValue.DEFERMENT) {
            logger.info("Transaction is a deferment, ID = " + transaction);
            transaction.setGlEntryGenerated(true);
            return;
        }

        GeneralLedgerType glType = transaction.getGeneralLedgerType();

        String glAccount = null;
        GlOperationType glOperationType = null;
        if (transaction.getTransactionType() instanceof CreditType) {
            CreditType creditType = (CreditType) transaction.getTransactionType();
            glAccount = creditType.getUnallocatedGlAccount();
            glOperationType = creditType.getUnallocatedGlOperation();
        } else if (glType != null) {
            glAccount = glType.getGlAccountId();
            glOperationType = glType.getGlOperationOnCharge();
        }

        // TODO: This logic needs to be revised, discuss it with Paul
        // Using the default GL type
        if (glAccount == null || glOperationType == null) {
            logger.info("Default GL type is being used...");
            glType = glService.getDefaultGeneralLedgerType();
            glAccount = glType.getGlAccountId();
            glOperationType = glType.getGlOperationOnCharge();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_EXPORT);

        final String statement = dateFormat.format(transaction.getEffectiveDate()) + ":" +
                transaction.getAccount().getId() + ":" +
                transaction.getTransactionType().getCode() + ":" +
                transaction.getTransactionTypeValue() + ":" +
                transaction.getStatementText();

        // Creating one GL transaction with the whole transaction amount
        glService.createGlTransaction(transactionId, glAccount, transaction.getAmount(), glOperationType, statement, true);

        BigDecimal initialAmount = transaction.getAmount();
        BigDecimal remainingAmount = initialAmount;

        List<AbstractGlBreakdown> glBreakDowns = getGlBreakdowns(transaction);
        if (CollectionUtils.isNotEmpty(glBreakDowns)) {
            for (AbstractGlBreakdown glBreakdown : glBreakDowns) {

                BigDecimal percentage = glBreakdown.getBreakdown();
                if (percentage == null) {
                    String errMsg = "Breakdown percentage cannot be null, transaction ID = " + transactionId;
                    logger.error(errMsg);
                    throw new IllegalStateException(errMsg);
                }

                glAccount = glBreakdown.getGlAccount();
                GlOperationType operationType = (glBreakdown instanceof GlBreakdown) ?
                        ((GlBreakdown) glBreakdown).getGlOperation() : glType.getGlOperationOnCharge();

                if (percentage.compareTo(BigDecimal.ZERO) > 0) {
                    BigDecimal amount = initialAmount.divide(new BigDecimal(100)).multiply(percentage);
                    glService.createGlTransaction(transactionId, glBreakdown.getGlAccount(), amount, operationType,
                            statement, true);
                    remainingAmount = remainingAmount.subtract(amount);
                } else {
                    // If the remaining amount == 0 then apply it to the new GL transaction and exit
                    // considering that GL breakdowns are sorted by percentage in descendant order :)
                    glService.createGlTransaction(transactionId, glAccount, remainingAmount, operationType,
                            statement, true);
                    break;
                }
            }
        }

        transaction.setGlEntryGenerated(true);

        //persistTransaction(transaction);
    }

    /**
     * This method is used to apply “obvious” payments to their reversal. Under normal circumstances, this will not be needed,
     * as reversals created inside of KSA will automatically be locked together. However, after an import from an external system,
     * this allocation may not exist. This method is provided to ensure that transactions that are obviously designed to be together,
     * are allocated together. “Obvious” means they are entirely unallocated, have the same amounts,
     * but one is negated, and they have the same transaction type.
     * <p/>
     *
     * @param accountId Account ID
     * @return list of generated GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<GlTransaction> allocateReversals(String accountId) {
        return allocateReversals(accountId, true);
    }


    /**
     * This method is used to apply “obvious” payments to their reversal. Under normal circumstances, this will not be needed,
     * as reversals created inside of KSA will automatically be locked together. However, after an import from an external system,
     * this allocation may not exist. This method is provided to ensure that transactions that are obviously designed to be together,
     * are allocated together. “Obvious” means they are entirely unallocated, have the same amounts,
     * but one is negated, and they have the same transaction type.
     * <p/>
     *
     * @param accountId Account ID
     * @param isQueued  indicates whether the GL transaction should be in Q or W status
     * @return list of generated GL transactions
     */
    @Override
    @Transactional(readOnly = false)
    public List<GlTransaction> allocateReversals(String accountId, boolean isQueued) {
        return allocateReversals(getTransactions(accountId), isQueued);
    }

    /**
     * An overridden version of allocateReversals() that takes a list of transactions as an argument.
     *
     * @param transactions list of transactions
     * @return list of generated GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<GlTransaction> allocateReversals(List<Transaction> transactions) {
        return allocateReversals(transactions, true);
    }

    /**
     * An overridden version of allocateReversals() that takes a list of transactions as an argument.
     *
     * @param transactions list of transactions
     * @param isQueued     indicates whether the GL transaction should be in Q or W status
     * @return list of generated GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<GlTransaction> allocateReversals(List<Transaction> transactions, boolean isQueued) {

        List<GlTransaction> glTransactions = new LinkedList<GlTransaction>();
        List<Transaction> unallocatedTransactions = new LinkedList<Transaction>();

        for (Transaction transaction : transactions) {

            BigDecimal allocatedAmount = transaction.getAllocatedAmount() != null ?
                    transaction.getAllocatedAmount() : BigDecimal.ZERO;

            BigDecimal lockedAllocatedAmount = transaction.getLockedAllocatedAmount() != null ?
                    transaction.getLockedAllocatedAmount() : BigDecimal.ZERO;

            if (allocatedAmount.compareTo(BigDecimal.ZERO) == 0 && lockedAllocatedAmount.compareTo(BigDecimal.ZERO) == 0) {
                unallocatedTransactions.add(transaction);
            }

        }

        Set<Transaction> unprocessedTransactions = new HashSet<Transaction>(unallocatedTransactions);
        for (Transaction transaction : unallocatedTransactions) {
            Transaction reversal = findReversal(unprocessedTransactions, transaction);
            if (reversal != null) {
                CompositeAllocation allocation =
                        createAllocation(transaction, reversal, transaction.getAmount().abs(), isQueued, false, false);
                glTransactions.add(allocation.getCreditGlTransaction());
                glTransactions.add(allocation.getDebitGlTransaction());
                unprocessedTransactions.remove(transaction);
                unprocessedTransactions.remove(reversal);
            }
        }

        return glTransactions;
    }

    /**
     * Finds a transaction with a negated amount for the given transaction from the given list.
     *
     * @param transactions Collection of transactions
     * @param transaction  Transaction instance
     * @return Transaction reversal
     */
    protected Transaction findReversal(Collection<Transaction> transactions, Transaction transaction) {
        for (Transaction reversal : transactions) {
            if (transaction.getAmount() != null && reversal.getAmount() != null) {
                if (transaction.getAmount().add(reversal.getAmount()).compareTo(BigDecimal.ZERO) == 0) {
                    return reversal;
                }
            }
        }
        return null;
    }


    /**
     * If the reverse method is called, the system will generate a negative
     * transaction for the type of the original transaction. A memo transaction
     * will be generated, and the transactions will be locked together. Subject
     * to user customization, the transactions may be marked as hidden. (likely
     * that credits will not be hidden, debits will.) A charge to an account may
     * be reversed when a mistake is made, or a refund is issued. A payment may
     * be reversed when a payment bounces, or for some other reason is entered
     * on to the account and is not payable.
     *
     * @param transactionId   Transaction ID
     * @param memoText        Text of the memo to be created
     * @param partialAmount   Partial amount
     * @param statementPrefix Statement prefix that will be added to the existing Transaction statement
     * @return a newly created reversed transaction
     */
    @Override
    @Transactional(readOnly = false)
    public Transaction reverseTransaction(Long transactionId, String memoText, BigDecimal partialAmount,
                                          String statementPrefix) {

        PermissionUtils.checkPermission(Permission.REVERSE_TRANSACTION);

        Transaction transaction = getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        if (transaction.getTransactionTypeValue() == TransactionTypeValue.DEFERMENT) {
            String errMsg = "Transaction is a deferment and cannot be reversed, ID = " + transactionId;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        if (transaction.getAmount() == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not have any amount";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        // Removing all the transaction allocations
        removeAllAllocations(transactionId);


        BigDecimal lockedAllocatedAmount = transaction.getLockedAllocatedAmount();

        // If partialAmount is not null OR transaction does not have any locked allocated amount
        if (partialAmount != null ||
                lockedAllocatedAmount == null || lockedAllocatedAmount.compareTo(BigDecimal.ZERO) == 0) {

            BigDecimal reversedAmount;

            if (partialAmount != null) {
                if (partialAmount.compareTo(getUnallocatedAmount(transaction)) > 0) {
                    String errMsg = "Partial amount is greater than transaction unallocated amount";
                    logger.error(errMsg);
                    throw new IllegalStateException(errMsg);
                }
                reversedAmount = partialAmount.negate();
            } else {
                reversedAmount = transaction.getAmount().negate();
            }

            // Creating a new reversed transaction
            String transactionTypeId = transaction.getTransactionType().getId().getId();
            Transaction reversedTransaction = createTransaction(transactionTypeId, transaction.getAccountId(),
                    transaction.getEffectiveDate(), reversedAmount);

            boolean updateReversed = false;
            boolean updateOriginal = false;

            if (statementPrefix != null && transaction.getStatementText() != null) {
                String statement = statementPrefix + " " + transaction.getStatementText();
                reversedTransaction.setStatementText(statement);
                updateReversed = true;
            }

            if (transaction.getTransactionTypeValue() == TransactionTypeValue.CHARGE) {
                transaction.setInternal(true);
                reversedTransaction.setInternal(true);
                updateOriginal = true;
                updateReversed = true;
            }

            // Creating a locked allocation between the original and reversed transactions
            createLockedAllocation(transaction.getId(), reversedTransaction.getId(), partialAmount);

            if (updateOriginal) {
                persistEntity(transaction);
            }

            if (updateReversed) {
                persistEntity(reversedTransaction);
            }

            // Creating memo
            if (memoText != null && !memoText.trim().isEmpty()) {
                Integer defaultMemoLevel = informationService.getDefaultMemoLevel();
                Date effectiveDate = new Date();
                informationService.createMemo(transactionId, memoText, defaultMemoLevel, effectiveDate, null, null);
            }

            return reversedTransaction;

        } else {
            // TODO: Check if the locked allocated amount comes from a deferment
            String errMsg = "Transaction with ID = " + transactionId + " has locked allocation";
            logger.error(errMsg);
            throw new LockedAllocationException(errMsg);
        }
    }

    protected void expireDeferment(Deferment deferment) {

        PermissionUtils.checkPermission(Permission.EXPIRE_DEFERMENT);

        // Removing all allocations for the deferment
        removeAllAllocations(deferment.getId());

        deferment.setInternal(true);
        deferment.setAmount(BigDecimal.ZERO);
        deferment.setExpirationDate(new Date());
        deferment.setStatus(TransactionStatus.EXPIRED);

        persistTransaction(deferment);
    }

    /**
     * A deferment may be expired automatically (when the date of the deferment
     * passes) or be expired manually but the system, either through user
     * intervention, or by a payment being received on the account that removes
     * the need for the deferment. If, for example, an account is paid in full,
     * the deferment would have to be expired, otherwise a credit balance would
     * technically occur on the account.
     */
    @Override
    @Transactional(readOnly = false)
    public void expireDeferment(Long defermentId) {

        Deferment deferment = getDeferment(defermentId);
        if (deferment == null) {
            String errMsg = "Deferment with ID = " + defermentId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        expireDeferment(deferment);
    }

    /**
     * Expires all deferments on the account whose expiration date has passed
     *
     * @param userId Account ID
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public void expireDeferments(String userId) {

        Date currentDate = new Date();

        List<Deferment> deferments = getDeferments(userId);
        for (Deferment deferment : deferments) {
            Date expirationDate = deferment.getExpirationDate();
            if (expirationDate != null && expirationDate.before(currentDate)) {
                expireDeferment(deferment);
            }
        }

    }


    /**
     * Returns the transaction type for the given transaction type ID
     *
     * @param transactionTypeId The first part of TransactionTypeId PK
     * @return a subclass of TransactionType
     */
    @Override
    @WebMethod(exclude = true)
    public <T extends TransactionType> Class<T> getTransactionTypeClass(String transactionTypeId) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION_TYPE);

        Query query = em.createQuery("select t from TransactionType t " +
                " where t.id.id = :transactionTypeId");
        query.setParameter("transactionTypeId", transactionTypeId);
        List<T> transactionTypes = query.getResultList();
        if (transactionTypes != null && !transactionTypes.isEmpty()) {
            T transactionType = transactionTypes.get(0);
            return (transactionType != null) ? (Class<T>) transactionType.getClass() : null;
        }
        return null;
    }

    /**
     * Checks if the first transaction can pay the second transaction.
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @return true if transactionId1 can pay transactionId2, false - otherwise
     */
    @Override
    @WebMethod(exclude = true)
    public boolean canPay(Long transactionId1, Long transactionId2) {
        return canPay(transactionId1, transactionId2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Checks if the first transaction can pay the second transaction.
     *
     * @param transaction1 First transaction
     * @param transaction2 Second transaction
     * @return true if transaction1 can pay transaction2, false - otherwise
     */
    @Override
    @WebMethod(exclude = true)
    public boolean canPay(Transaction transaction1, Transaction transaction2) {
        return canPayInternal(transaction1, transaction2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    /**
     * Checks if the first transaction can pay the second transaction.
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @param priority       priority
     * @return true if transactionId1 can pay transactionId2, false - otherwise
     */
    @Override
    @WebMethod(exclude = true)
    public boolean canPay(Long transactionId1, Long transactionId2, int priority) {
        return canPay(transactionId1, transactionId2, priority, priority);
    }


    /**
     * Checks if the first transaction can pay the second transaction.
     *
     * @param transactionId1 transaction1 ID
     * @param transactionId2 transaction2 ID
     * @param priorityFrom   lower priority boundary
     * @param priorityTo     upper priority boundary
     * @return true if transactionId1 can pay transactionId2, false - otherwise
     */
    @Override
    public boolean canPay(Long transactionId1, Long transactionId2, int priorityFrom, int priorityTo) {

        if (priorityFrom > priorityTo) {
            String errMsg = "priorityFrom must be less or equal to priorityTo";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Transaction transaction1 = getTransaction(transactionId1);
        if (transaction1 == null) {
            String errMsg = "Transaction with ID = " + transactionId1 + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        Transaction transaction2 = getTransaction(transactionId2);
        if (transaction2 == null) {
            String errMsg = "Transaction with ID = " + transactionId2 + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        boolean canPay = canPayInternal(transaction1, transaction2, priorityFrom, priorityTo);
        return (canPay || canPayInternal(transaction2, transaction1, priorityFrom, priorityTo));
    }

    protected boolean canPayInternal(Transaction transaction1, Transaction transaction2, int priorityFrom, int priorityTo) {

        boolean compatible = false;

        if (transaction1 instanceof Credit && transaction2 instanceof Debit) {
            if (transaction1.getAmount() != null && transaction1.getAmount().compareTo(BigDecimal.ZERO) > 0 &&
                    transaction2.getAmount() != null && transaction2.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                compatible = true;
            }
        } else if (transaction1 instanceof Credit && transaction2 instanceof Credit) {
            if (transaction1.getAmount() != null && transaction1.getAmount().compareTo(BigDecimal.ZERO) > 0 &&
                    transaction2.getAmount() != null && transaction2.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                compatible = true;
            }
        } else if (transaction1 instanceof Debit && transaction2 instanceof Debit) {
            if (transaction1.getAmount() != null && transaction1.getAmount().compareTo(BigDecimal.ZERO) > 0 &&
                    transaction2.getAmount() != null && transaction2.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                return true;
            }
        }

        if (!compatible) {
            return false;
        }

        TransactionTypeId creditTypeId = transaction1.getTransactionType().getId();
        TransactionTypeId debitTypeId = transaction2.getTransactionType().getId();

        List<CreditPermission> creditPermissions = getCreditPermissions(creditTypeId, priorityFrom, priorityTo);

        if (CollectionUtils.isNotEmpty(creditPermissions)) {
            for (CreditPermission creditPermission : creditPermissions) {
                String debitTypeMask = creditPermission.getAllowableDebitType();
                logger.info("Debit type mask: " + debitTypeMask);
                if (debitTypeMask != null && Pattern.matches(debitTypeMask, debitTypeId.getId())) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns a list of credit permissions for the given transaction type sorted by
     * priority in descending order.
     *
     * @param transactionTypeId Transaction Type ID
     * @return list of CreditPermission instances
     */
    @Override
    @WebMethod(exclude = true)
    public List<CreditPermission> getCreditPermissions(TransactionTypeId transactionTypeId) {
        return getCreditPermissions(transactionTypeId, null, null);
    }

    /**
     * Returns a list of credit permissions for the given transaction type and priority range sorted by
     * priority in descending order.
     *
     * @param transactionTypeId Transaction Type ID
     * @param priorityFrom      lower priority
     * @param priorityTo        upper priority
     * @return list of CreditPermission instances
     */
    @Override
    public List<CreditPermission> getCreditPermissions(TransactionTypeId transactionTypeId,
                                                       Integer priorityFrom, Integer priorityTo) {
        Set<TransactionTypeId> typeIds = new HashSet<TransactionTypeId>(1);
        typeIds.add(transactionTypeId);
        return getCreditPermissions(typeIds, priorityFrom, priorityTo);
    }

    /**
     * Returns a list of credit permissions for the given set of transaction types sorted by
     * priority in descending order.
     *
     * @param transactionTypeIds a set of Transaction Type IDs
     * @return list of CreditPermission instances
     */
    private List<CreditPermission> getCreditPermissions(Set<TransactionTypeId> transactionTypeIds) {
        return getCreditPermissions(transactionTypeIds, null, null);
    }

    /**
     * Returns a list of credit permissions for the given set of transaction types and priority range sorted by
     * priority in descending order.
     *
     * @param transactionTypeIds a set of Transaction Type IDs
     * @param priorityFrom       lower priority
     * @param priorityTo         upper priority
     * @return list of CreditPermission instances
     */
    private List<CreditPermission> getCreditPermissions(Set<TransactionTypeId> transactionTypeIds,
                                                        Integer priorityFrom, Integer priorityTo) {

        PermissionUtils.checkPermission(Permission.READ_CREDIT_PERMISSION);

        StringBuilder queryBuilder =
                new StringBuilder("select distinct cp from CreditPermission cp where cp.creditType.id in (:typeIds)");

        if (priorityFrom != null && priorityTo != null) {
            queryBuilder.append(" and cp.priority between :priorityFrom and :priorityTo");
        }

        queryBuilder.append(" order by cp.priority desc");

        Query query = em.createQuery(queryBuilder.toString());

        query.setParameter("typeIds", transactionTypeIds);

        if (priorityFrom != null && priorityTo != null) {
            query.setParameter("priorityFrom", priorityFrom);
            query.setParameter("priorityTo", priorityTo);
        }

        return query.getResultList();
    }

    /**
     * Determine if the transaction is allowed for the given account ID, transaction type and effective date
     *
     * @param accountId         Account ID
     * @param transactionTypeId Transaction Type ID
     * @param effectiveDate     Effective Date
     * @return true/false
     */
    @Override
    public boolean isTransactionAllowed(String accountId, String transactionTypeId, Date effectiveDate) {
        return accountService.accountExists(accountId) &&
                getTransactionType(transactionTypeId, effectiveDate) != null &&
                getAccessControlService().isTransactionTypeAllowed(accountId, transactionTypeId);

    }

    /**
     * Returns the list of matching transactions for the given name pattern.
     *
     * @param pattern Statement text pattern
     * @return List of Transaction instances
     */
    @Override
    public List<Transaction> findTransactionsByStatementPattern(String pattern) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION);

        boolean patternIsNotEmpty = (pattern != null) && !pattern.isEmpty();

        StringBuilder builder = new StringBuilder("select t from Transaction t " + GET_TRANSACTION_JOIN);

        if (patternIsNotEmpty) {
            builder.append(" where t.statementText like :pattern ");
        }

        builder.append(" order by t.id");

        Query query = em.createQuery(builder.toString());

        if (patternIsNotEmpty) {
            query.setParameter("pattern", "%" + pattern.toLowerCase() + "%");
        }

        return query.getResultList();
    }

    /**
     * The logic of this is very similar to reverseTransaction(), except a partial write off is allowed, and only
     * credits can be written off. Also, the institution can choose to write off charges to a different general
     * ledger account, instead of the original, permitting the writing off to a general "bad debt" account, if they
     * so choose.
     *
     * @param transactionId     Transaction ID
     * @param transactionTypeId TransactionType ID
     * @param memoText          Memo test
     * @param statementPrefix   Transaction statement prefix
     * @return a write-off transaction instance
     */
    @Override
    @Transactional(readOnly = false)
    public Transaction writeOffTransaction(Long transactionId, TransactionTypeId transactionTypeId,
                                           String memoText, String statementPrefix) {

        PermissionUtils.checkPermission(Permission.WRITE_OFF_TRANSACTION);

        Transaction transaction = getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        if (transaction.getTransactionTypeValue() != TransactionTypeValue.CHARGE) {
            String errMsg = "Transaction must be a charge, ID = " + transactionId;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        TransactionType transactionType = (transactionTypeId != null) ?
                getTransactionType(transactionTypeId) : transaction.getTransactionType();

        Query query = em.createQuery("select a from Allocation a " +
                " join fetch a.firstTransaction t1 " +
                " join fetch a.secondTransaction t2 " +
                " where (a.firstTransaction.id = :transactionId or " +
                " a.secondTransaction.id = :transactionId) and a.locked = true");
        query.setParameter("transactionId", transactionId);
        List<Allocation> lockedAllocations = query.getResultList();
        if (lockedAllocations != null) {
            for (Allocation allocation : lockedAllocations) {
                Transaction firstTransaction = allocation.getFirstTransaction();
                Transaction secondTransaction = allocation.getSecondTransaction();
                if (firstTransaction.getTransactionTypeValue() == TransactionTypeValue.DEFERMENT) {
                    expireDeferment(firstTransaction.getId());
                }
                if (secondTransaction.getTransactionTypeValue() == TransactionTypeValue.DEFERMENT) {
                    expireDeferment(secondTransaction.getId());
                }
            }
        }

        BigDecimal writeOffAmount = getUnallocatedAmount(transaction);

        // Creating a new transaction with the negate writeOffAmount
        Transaction writeOffTransaction = createTransaction(transactionType.getId().getId(), transaction.getAccountId(),
                transaction.getEffectiveDate(), writeOffAmount.negate());

        // Creating a new locked allocation between the original and write-off transactions
        createLockedAllocation(transaction.getId(), writeOffTransaction.getId(), writeOffAmount);

        String statementText = transaction.getStatementText();
        if (statementPrefix != null && !statementPrefix.isEmpty()) {
            statementText = statementPrefix + " " + statementText;
        }

        writeOffTransaction.setStatementText(statementText);

        String rollupCode = configService.getParameter(Constants.DEFAULT_WRITE_OFF_ROLLUP);

        if (StringUtils.isNotBlank(rollupCode)) {
            Rollup rollup = getRollupByCode(rollupCode);
            if (rollup != null) {
                writeOffTransaction.setRollup(rollup);
            }
        }

        writeOffTransaction.setStatus(TransactionStatus.WRITTEN_OFF);

        persistTransaction(writeOffTransaction);

        // Creating memo
        if (memoText != null && !memoText.trim().isEmpty()) {
            Integer defaultMemoLevel = informationService.getDefaultMemoLevel();
            Date effectiveDate = new Date();
            informationService.createMemo(transactionId, memoText, defaultMemoLevel, effectiveDate, null, null);
        }

        return writeOffTransaction;

    }

    private Rollup getRollupByCode(String code) {

        PermissionUtils.checkPermission(Permission.READ_ROLLUP);

        return getAuditableEntityByCode(code, Rollup.class);
    }


    /**
     * Checks if Transactions that meet the specified search criteria exist.
     *
     * @param accountId         Account ID.
     * @param transactionTypeId Transaction Type ID.
     * @return <code>true</code> if at least one Transaction of the given type for the given account exists.
     */
    @Override
    @WebMethod(exclude = true)
    public boolean transactionExists(String accountId, String transactionTypeId) {
        return transactionExistsInternal(accountId, transactionTypeId, null, null, null, null);
    }

    /**
     * Checks if Transactions that meet the specified search criteria exist.
     *
     * @param accountId         Account ID.
     * @param transactionTypeId Transaction Type ID.
     * @param effectiveDateFrom Transaction Effective Date beginning range (inclusive).
     * @param effectiveDateTo   Transaction Effective Date end range (inclusive).
     * @return <code>true</code> if at least one Transaction of the given type for the given account
     *         with the Effective Dates that fall into the specified range exists.
     */
    @Override
    @WebMethod(exclude = true)
    public boolean transactionExists(String accountId, String transactionTypeId, Date effectiveDateFrom, Date effectiveDateTo) {
        return transactionExistsInternal(accountId, transactionTypeId, null, null, effectiveDateFrom, effectiveDateTo);
    }

    /**
     * Checks if Transactions that meet the specified search criteria exist.
     *
     * @param accountId         Account ID.
     * @param transactionTypeId Transaction Type ID.
     * @param amountFrom        Amount of a Transaction begging of a search range.
     * @param amountTo          Amount of a Transaction end of a search range.
     * @return <code>true</code> if at least one Transaction of the given type, given amount for the given account exists.
     */
    @Override
    @WebMethod(exclude = true)
    public boolean transactionExists(String accountId, String transactionTypeId, BigDecimal amountFrom, BigDecimal amountTo) {
        return transactionExistsInternal(accountId, transactionTypeId, amountFrom, amountTo, null, null);
    }

    /**
     * Checks if Transactions that meet the specified search criteria exist.
     *
     * @param accountId         Account ID.
     * @param transactionTypeId Transaction Type ID.
     * @param amountFrom        Amount of a Transaction begging of a search range.
     * @param amountTo          Amount of a Transaction end of a search range.
     * @param effectiveDateFrom Transaction Effective Date beginning range (inclusive).
     * @param effectiveDateTo   Transaction Effective Date end range (inclusive).
     * @return <code>true</code> if at least one Transaction of the given type, given amount for the given account
     *         with the Effective Dates that fall into the specified range exists.
     */
    @Override
    public boolean transactionExists(String accountId, String transactionTypeId, BigDecimal amountFrom,
                                     BigDecimal amountTo, Date effectiveDateFrom, Date effectiveDateTo) {
        return transactionExistsInternal(accountId, transactionTypeId, amountFrom, amountTo, effectiveDateFrom, effectiveDateTo);
    }

    /**
     * InternalMethod: Checks if Transactions that meet the specified search criteria exist.
     *
     * @param accountId         Account ID.
     * @param transactionTypeId Transaction Type ID.
     * @param amountFrom        Amount of a Transaction begging of a search range.
     * @param amountTo          Amount of a Transaction end of a search range.
     * @param effectiveDateFrom Transaction Effective Date beginning range (inclusive).
     * @param effectiveDateTo   Transaction Effective Date end range (inclusive).
     * @return <code>true</code> if at least one Transaction of the given type, given amount for the given account
     *         with the Effective Dates that fall into the specified range exists.
     */
    private boolean transactionExistsInternal(String accountId, String transactionTypeId, BigDecimal amountFrom,
                                              BigDecimal amountTo, Date effectiveDateFrom, Date effectiveDateTo) {

        // Create a query that may contain some of the parameters. "accountId" and "transactionType" are required
        StringBuilder builder = new StringBuilder("select 1 from Transaction t where t.account.id = :accountId " +
                " and t.transactionType.id.id = :transactionTypeId");

        boolean hasAmounts = (amountFrom != null) && (amountTo != null);
        boolean hasDates = (effectiveDateFrom != null) && (effectiveDateTo != null);

        if (hasAmounts) {
            builder.append(" and t.amount between :amountFrom and :amountTo");
        }

        if (hasDates) {
            builder.append(" and t.effectiveDate between :dateFrom and :dateTo");
        }

        // Create a Query:
        Query query = em.createQuery(builder.toString());

        query.setParameter("accountId", accountId);
        query.setParameter("transactionTypeId", transactionTypeId);
        query.setMaxResults(1);

        if (hasAmounts) {
            query.setParameter("amountFrom", amountFrom);
            query.setParameter("amountTo", amountTo);
        }

        if (hasDates) {
            query.setParameter("dateFrom", effectiveDateFrom);
            query.setParameter("dateTo", effectiveDateTo);
        }

        return CollectionUtils.isNotEmpty(query.getResultList());
    }


    /**
     * Returns the unallocated amount of all transactions in the list for the given transaction type and
     * debit type mask
     *
     * @param transactions    a list of transactions
     * @param transactionType transaction type <code>TransactionTypeValue</code>(Charge, Payment or Deferment)
     * @param restricted      if "true" credit permissions with a mask != ".*" will be summarized,
     *                        otherwise the mask ".*" will be used
     * @return BigDecimal of the sum of the Restricted Payment amount
     */
    @Override
    @WebMethod(exclude = true)
    public BigDecimal getUnallocatedAmount(List<Transaction> transactions, TransactionTypeValue transactionType,
                                           boolean restricted) {

        PermissionUtils.checkPermissions(Permission.READ_TRANSACTION, Permission.READ_TRANSACTION_TYPE);

        BigDecimal unallocatedAmount = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {

            if (transaction.getTransactionTypeValue() == transactionType) {

                TransactionTypeId transactionTypeId = transaction.getTransactionType().getId();

                List<CreditPermission> creditPermissions = getCreditPermissions(transactionTypeId);

                if (CollectionUtils.isNotEmpty(creditPermissions)) {
                    boolean allPermissions = false;
                    for (CreditPermission creditPermission : creditPermissions) {
                        if (".*".equals(creditPermission.getAllowableDebitType())) {
                            allPermissions = true;
                            break;
                        }
                    }
                    if ((allPermissions && !restricted) || (!allPermissions && restricted)) {
                        unallocatedAmount = unallocatedAmount.add(getUnallocatedAmount(transaction));
                    }
                }
            }
        }

        return null;
    }

    /**
     * Takes the cancellationRule and using the baseDate calculates the
     * appropriate dates to be stored in the actual transaction version of the cancellation rule.
     *
     * @param cancellationRule the cancellation rule
     * @param baseDate         the base date that is used for calculation by "DATE" values in the rule sentence
     * @return the modified cancellation rule with the updated dates
     */
    @Override
    public String calculateCancellationRule(String cancellationRule, Date baseDate) {

        if (!isCancellationRuleValid(cancellationRule)) {
            String errMsg = "Cancellation Rule '" + cancellationRule + "' is invalid";
            logger.error(errMsg);
            throw new InvalidCancellationRuleException(errMsg);
        }

        String rule = cancellationRule.toUpperCase().trim();

        Date date = baseDate;

        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_US);

        StringBuilder builder = new StringBuilder(cancellationRule.length());

        String[] clauses = rule.split(";");

        for (int i = 0; i < clauses.length; i++) {

            String clause = clauses[i];

            if (clause.startsWith("DAYS(")) {

                int index = clause.indexOf(")");

                String daysValue = clause.substring(5, index);
                String ruleValue = clause.substring(index + 1);

                int days = Integer.parseInt(daysValue);
                date = CalendarUtils.addCalendarDays(date, days);

                builder.append("DATE(");
                builder.append(dateFormat.format(date));
                builder.append(")");
                builder.append(ruleValue);

            } else {
                // If it already starts with DATE simply add that clause to the builder
                builder.append(clause);
            }

            if (i < clauses.length - 1) {
                builder.append(";");
            }
        }

        return builder.toString();
    }

    /**
     * Parses the cancellationRule and returns a sorted map of dates and pairs of cancellation rule types with
     * the corresponding amount. The map is sorted by dates in ascending order.
     *
     * @param cancellationRule The cancellation rule. The String value to be normalized:
     *                         DAYS values have to be replaced with DATE.
     * @return a sorted map of dates and pairs of cancellation rule types and amount
     */
    @Override
    @WebMethod(exclude = true)
    public TreeMap<Date, List<Pair<CancellationRuleType, BigDecimal>>> parseCancellationRule(String cancellationRule) {

        if (!isCancellationRuleValid(cancellationRule)) {
            String errMsg = "Cancellation Rule '" + cancellationRule + "' is invalid";
            logger.error(errMsg);
            throw new InvalidCancellationRuleException(errMsg);
        }

        try {

            String rule = cancellationRule.toUpperCase().trim();

            SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_US);

            TreeMap<Date, List<Pair<CancellationRuleType, BigDecimal>>> parsedRules =
                    new TreeMap<Date, List<Pair<CancellationRuleType, BigDecimal>>>();

            for (String clause : rule.split(";")) {

                if (clause.startsWith("DATE(")) {

                    int index = clause.indexOf(")");

                    String dateValue = clause.substring(5, index);
                    String ruleValue = clause.substring(index + 1);

                    BigDecimal amount = null;
                    CancellationRuleType ruleType = null;
                    if (ruleValue.startsWith(CancellationRuleType.PERCENTAGE.name())) {
                        int firstIndex = CancellationRuleType.PERCENTAGE.name().length() + 1;
                        amount = new BigDecimal(ruleValue.substring(firstIndex, ruleValue.indexOf(")")));
                        ruleType = CancellationRuleType.PERCENTAGE;
                    } else if (ruleValue.startsWith(CancellationRuleType.AMOUNT.name())) {
                        int firstIndex = CancellationRuleType.AMOUNT.name().length() + 1;
                        amount = new BigDecimal(ruleValue.substring(firstIndex, ruleValue.indexOf(")")));
                        ruleType = CancellationRuleType.AMOUNT;
                    }

                    Date date = dateFormat.parse(dateValue);

                    List<Pair<CancellationRuleType, BigDecimal>> rules = parsedRules.get(date);
                    if (rules == null) {
                        rules = new LinkedList<Pair<CancellationRuleType, BigDecimal>>();
                        parsedRules.put(date, rules);
                    }

                    rules.add(new Pair<CancellationRuleType, BigDecimal>(ruleType, amount));
                }
            }

            return parsedRules;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }

    }


    /**
     * Checks if the given cancellation rule is legal.
     *
     * @param cancellationRule the cancellation rule
     * @return true if the rule is valid or null, false - otherwise
     */
    @Override
    public boolean isCancellationRuleValid(String cancellationRule) {

        if (StringUtils.isBlank(cancellationRule) || cancellationRule.length() < 6) {
            return false;
        }

        String rule = cancellationRule.toUpperCase().trim();

        int curDays = -1;
        Date curDate = null;
        Boolean isDateRule = null;

        logger.debug("Cancellation Rule = '" + rule + "'");

        while (rule.length() > 0) {

            boolean startsWithDate = rule.startsWith("DATE(");
            boolean startsWithDays = rule.startsWith("DAYS(");

            if (isDateRule == null) {
                isDateRule = startsWithDate;
            } else if (isDateRule && startsWithDays) {
                return false;
            } else if (!isDateRule && startsWithDate) {
                return false;
            }

            if (startsWithDate || startsWithDays) {
                rule = rule.substring(5);
                int index = rule.indexOf(")");
                if (index <= 0) {
                    return false;
                }
                String dateDays = rule.substring(0, index);
                if (StringUtils.isBlank(dateDays)) {
                    return false;
                }
                try {
                    int days = Integer.parseInt(dateDays);
                    if (isDateRule) {
                        return false;
                    }
                    if (days < 0 || days > 365 || days < curDays) {
                        return false;
                    }
                    curDays = days;
                } catch (NumberFormatException nfe) {
                    if (!isDateRule) {
                        return false;
                    }
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_US);
                        // We have to set "lenient" to false to prevent auto-conversion of dates like "13/23/1999"
                        dateFormat.setLenient(false);
                        Date date = dateFormat.parse(dateDays);
                        if (curDate != null && date.compareTo(curDate) < 0) {
                            return false;
                        }
                        curDate = date;
                    } catch (ParseException pe) {
                        logger.warn("isCancellationRuleValid: Rule = '" + cancellationRule + "' " + pe.getMessage());
                        return false;
                    }
                }
                if (rule.length() <= index + 2) {
                    return false;
                }
                rule = rule.substring(index + 1);
                boolean startsWithAmount = rule.startsWith(CancellationRuleType.AMOUNT.name());
                boolean startsWithPercentage = rule.startsWith(CancellationRuleType.PERCENTAGE.name());
                if (startsWithAmount || startsWithPercentage) {
                    int firstIndex = (startsWithAmount ? CancellationRuleType.AMOUNT.name().length() :
                            CancellationRuleType.PERCENTAGE.name().length()) + 1;
                    rule = rule.substring(firstIndex);
                    index = rule.indexOf(")");
                    if (index <= 0) {
                        return false;
                    }
                    String amountValue = rule.substring(0, index);
                    if (StringUtils.isBlank(amountValue)) {
                        return false;
                    }
                    try {
                        double amount = Double.parseDouble(amountValue);
                        if (amount <= 0) {
                            return false;
                        }
                        if (startsWithPercentage && amount > 100) {
                            return false;
                        }
                    } catch (NumberFormatException nfe) {
                        logger.warn("isCancellationRuleValid: Rule = '" + cancellationRule + "' " + nfe.getMessage());
                        return false;
                    }
                    rule = rule.substring(index + 1);
                    if (rule.length() > 0) {
                        if (rule.startsWith(";")) {
                            rule = rule.substring(1);
                            if (StringUtils.isBlank(rule)) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }

            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Using the cancellationRule, calculates the appropriate amount that can be cancelled
     * from a charge based on the current date.
     *
     * @param chargeId Charge ID
     * @return Cancellation amount
     */
    @Override
    @WebMethod(exclude = true)
    public BigDecimal getCancellationAmount(Long chargeId) {
        return getCancellationAmount(chargeId, new Date());
    }

    /**
     * Using the cancellationRule, calculates the appropriate amount that can be cancelled
     * from a charge based on the given cancellation date.
     *
     * @param chargeId         Charge ID
     * @param cancellationDate Cancellation date
     * @return Cancellation amount
     */
    @Override
    public BigDecimal getCancellationAmount(Long chargeId, Date cancellationDate) {

        PermissionUtils.checkPermission(Permission.READ_TRANSACTION);

        Charge charge = getCharge(chargeId);
        if (charge == null) {
            String errMsg = "Charge does not exist for the given ID = " + chargeId;
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        String cancellationRule = charge.getCancellationRule();
        if (TransactionStatus.CANCELLED.equals(charge.getStatus()) || StringUtils.isBlank(cancellationRule) ||
                charge.getAmount() == null || charge.getAmount().compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        TreeMap<Date, List<Pair<CancellationRuleType, BigDecimal>>> parsedRules = parseCancellationRule(cancellationRule);

        if (!parsedRules.isEmpty()) {

            Date paymentDate = parsedRules.firstKey();
            if (paymentDate.before(cancellationDate)) {
                return charge.getAmount();
            }

            for (Date date : parsedRules.keySet()) {
                if (date.before(cancellationDate)) {
                    return getCancellationAmount(parsedRules.get(paymentDate), charge.getAmount());
                }
                paymentDate = date;
            }

            return getCancellationAmount(parsedRules.get(paymentDate), charge.getAmount());
        }

        return BigDecimal.ZERO;
    }

    private BigDecimal getCancellationAmount(List<Pair<CancellationRuleType, BigDecimal>> rules, BigDecimal chargeAmount) {
        if (CollectionUtils.isNotEmpty(rules)) {
            BigDecimal totalAmount = BigDecimal.ZERO;
            for (Pair<CancellationRuleType, BigDecimal> rule : rules) {
                switch (rule.getA()) {
                    case AMOUNT:
                        totalAmount = totalAmount.add(rule.getB());
                    case PERCENTAGE:
                        BigDecimal amountPerPercent = chargeAmount.divide(new BigDecimal(100));
                        totalAmount = totalAmount.add(amountPerPercent.multiply(rule.getB()));
                }
            }
            return totalAmount;
        }
        return BigDecimal.ZERO;
    }

    /**
     * Cancels a charge by ID.
     *
     * @param chargeId Charge ID
     * @param memoText Memo text
     */
    @Override
    @Transactional(readOnly = false)
    public void cancelCharge(Long chargeId, String memoText) {

        PermissionUtils.checkPermission(Permission.CANCEL_CHARGE);

        Charge charge = getCharge(chargeId);
        if (charge == null) {
            String errMsg = "Charge does not exist for the given ID = " + chargeId;
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        if (!TransactionStatus.ACTIVE.equals(charge.getStatus())) {
            String errMsg = "Charge must be active, ID = " + chargeId;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        BigDecimal cancellationAmount = getCancellationAmount(chargeId);

        if (cancellationAmount != null && cancellationAmount.compareTo(BigDecimal.ZERO) != 0) {
            reverseTransaction(chargeId, memoText, cancellationAmount, null);
        }

        charge.setStatus(TransactionStatus.CANCELLED);
    }


    /**
     * Creates a deferment using createTransaction() and the default contest payment type as the transaction type.
     * After that it creates a locked allocation between the deferment and charge.
     *
     * @param chargeId       Charge ID
     * @param expirationDate Deferment expiration date
     * @param memoText       Memo text
     */
    @Override
    @Transactional(readOnly = false)
    public void contestCharge(Long chargeId, Date expirationDate, String memoText) {

        PermissionUtils.checkPermission(Permission.CONTEST_CHARGE);

        Charge charge = getCharge(chargeId);
        if (charge == null) {
            String errMsg = "Charge does not exist for the given ID = " + chargeId;
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        // Getting the default contest payment type ID
        String contestPaymentTypeId = configService.getParameter(Constants.CONTEST_PAYMENT_TYPE);
        if (StringUtils.isBlank(contestPaymentTypeId)) {
            String errMsg = "Configuration parameter '" + Constants.CONTEST_PAYMENT_TYPE + "' is required";
            logger.error(errMsg);
            throw new ConfigurationException(errMsg);
        }

        // Creating a deferment
        Transaction deferment = createTransaction(contestPaymentTypeId, charge.getExternalId(), charge.getAccountId(),
                charge.getEffectiveDate(), expirationDate, charge.getAmount());

        // Creating a locked allocation between the deferment and charge
        createLockedAllocation(deferment.getId(), chargeId, charge.getAmount());

        // Creating a memo
        Integer memoLevel = informationService.getDefaultMemoLevel();
        informationService.createMemo(deferment.getId(), memoText, memoLevel, new Date(), expirationDate, null);
    }

    /**
     * Adds the list of tags to the transaction specified by Transaction ID.
     *
     * @param transactionId Transaction ID
     * @param tags          a list of tags
     * @return the updated transaction instance with tags
     */
    @Override
    @Transactional(readOnly = false)
    public Transaction addTagsToTransaction(Long transactionId, List<Tag> tags) {

        PermissionUtils.checkPermission(Permission.ASSIGN_TAG_TO_TRANSACTION);

        Transaction transaction = getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        transaction.setTags(mergeNewAndPersistentTags(tags, transaction.getTags()));

        return transaction;
    }

    /**
     * Removes the specified list of tags from the transaction specified by Transaction ID.
     *
     * @param transactionId Transaction ID
     * @param tagIds        IDs of tags being removed
     * @return the updated transaction instance
     */
    @Override
    @Transactional(readOnly = false)
    public Transaction removeTagsFromTransaction(Long transactionId, Long... tagIds) {

        Transaction transaction = getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        List<Tag> updatedTags = removeTags(tagIds, transaction.getTags());

        transaction.setTags(updatedTags);

        return transaction;
    }

    /**
     * Removes the specified list of tags from the transaction type specified by TransactionType ID.
     *
     * @param typeId Transaction ID
     * @return the updated transaction type instance with tags
     */
    @Override
    @Transactional(readOnly = false)
    public TransactionType removeTagsFromTransactionType(TransactionTypeId typeId, Long... tagIds) {

        TransactionType transactionType = getTransactionType(typeId);
        if (transactionType == null) {
            String errMsg = "Transaction type with ID = " + typeId + " does not exist";
            logger.error(errMsg);
            throw new TransactionTypeNotFoundException(errMsg);
        }

        List<Tag> updatedTags = removeTags(tagIds, transactionType.getTags());

        transactionType.setTags(updatedTags);

        return transactionType;
    }

    /**
     * Adds the list of tags to the transaction type specified by TransactionType ID.
     *
     * @param typeId Transaction ID
     * @param tags   a list of tags
     * @return the updated transaction type instance with tags
     */
    @Override
    @Transactional(readOnly = false)
    public TransactionType addTagsToTransactionType(TransactionTypeId typeId, List<Tag> tags) {

        PermissionUtils.checkPermission(Permission.ASSIGN_TAG_TO_TRANSACTION_TYPE);

        TransactionType transactionType = getTransactionType(typeId);
        if (transactionType == null) {
            String errMsg = "Transaction type with ID = " + typeId + " does not exist";
            logger.error(errMsg);
            throw new TransactionTypeNotFoundException(errMsg);
        }

        transactionType.setTags(mergeNewAndPersistentTags(tags, transactionType.getTags()));

        return transactionType;
    }

    /**
     * Retrieve a list of all GL Breakdowns for a given debit type ID
     *
     * @param debitTypeId Debit Type ID
     * @return a list of GlBreakdown instances
     */
    @Override
    public List<GlBreakdown> getGlBreakdowns(TransactionTypeId debitTypeId) {

        PermissionUtils.checkPermission(Permission.READ_GL_BREAKDOWN);

        Query query = em.createQuery("select g from GlBreakdown g " +
                " left outer join fetch g.debitType dt " +
                " left outer join fetch g.generalLedgerType glt " +
                " where dt.id =  :debitTypeId " +
                " order by g.breakdown desc");

        query.setParameter("debitTypeId", debitTypeId);
        return query.getResultList();
    }

    /**
     * Returns the number of all transactions associated with the given Transaction Type ID (code and sub-code)
     *
     * @param transactionTypeId TransactionType ID
     * @return the number of transactions
     */
    @Override
    public long getNumberOfTransactions(TransactionTypeId transactionTypeId) {
        Query query = em.createQuery("select count(id) from Transaction where transactionType.id = :transactionTypeId");
        query.setParameter("transactionTypeId", transactionTypeId);
        return (Long) query.getSingleResult();
    }

    private List<Tag> removeTags(Long[] tagIdsToRemove, List<Tag> tags) {

        Set<Long> tagIds = new HashSet<Long>(Arrays.asList(tagIdsToRemove));

        if (CollectionUtils.isNotEmpty(tags)) {
            for (Tag tag : new ArrayList<Tag>(tags)) {
                if (tagIds.contains(tag.getId())) {
                    PermissionUtils.checkPermissions(tag, Permission.EDIT_TAG, Permission.EDIT_ADMIN_TAG);
                    tags.remove(tag);
                }
            }
        }

        return tags;
    }


    private List<Tag> mergeNewAndPersistentTags(List<Tag> tagsToAdd, List<Tag> persistentTags) {

        List<Tag> newTags = new ArrayList<Tag>(tagsToAdd);

        // Persisting new or merging existing tags in the persistence store
        Set<Long> tagIds = new HashSet<Long>();
        for (Tag tag : newTags) {
            if (tag.getId() != null) {
                tagIds.add(tag.getId());
            }
            PermissionUtils.checkPermissions(tag, Permission.EDIT_TAG, Permission.EDIT_ADMIN_TAG);
            auditableEntityService.persistAuditableEntity(tag);
        }

        if (persistentTags != null) {
            for (Tag currentTag : new ArrayList<Tag>(persistentTags)) {
                if (tagIds.contains(currentTag.getId())) {
                    PermissionUtils.checkPermissions(currentTag, Permission.EDIT_TAG, Permission.EDIT_ADMIN_TAG);
                    persistentTags.remove(currentTag);
                }
            }
        } else {
            persistentTags = new ArrayList<Tag>(newTags.size());
        }

        persistentTags.addAll(newTags);

        return persistentTags;

    }

}