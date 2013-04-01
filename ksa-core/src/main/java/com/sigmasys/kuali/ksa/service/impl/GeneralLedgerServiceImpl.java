package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.exception.ConfigurationException;
import com.sigmasys.kuali.ksa.exception.InvalidGeneralLedgerAccountException;
import com.sigmasys.kuali.ksa.exception.InvalidGeneralLedgerTypeException;
import com.sigmasys.kuali.ksa.exception.TransactionNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.*;
import com.sigmasys.kuali.ksa.util.CalendarUtils;
import com.sigmasys.kuali.ksa.util.EnumUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

import static com.sigmasys.kuali.ksa.model.Constants.*;

/**
 * General Ledger service implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("generalLedgerService")
@Transactional(readOnly = true)
@WebService(serviceName = GeneralLedgerService.SERVICE_NAME, portName = GeneralLedgerService.PORT_NAME,
        targetNamespace = WS_NAMESPACE)
@SuppressWarnings("unchecked")
public class GeneralLedgerServiceImpl extends GenericPersistenceService implements GeneralLedgerService {

    private static final Log logger = LogFactory.getLog(GeneralLedgerServiceImpl.class);


    /**
     * Creates a new general ledger type.
     *
     * @param code                GL type code
     * @param name                GL type name
     * @param description         GL type description
     * @param glAccountId         GL Account ID
     * @param glOperationOnCharge GL operation on charge
     * @return GeneralLedgerType instance
     */
    @Override
    @Transactional(readOnly = false)
    public GeneralLedgerType createGeneralLedgerType(String code, String name, String description, String glAccountId,
                                                     GlOperationType glOperationOnCharge) {

        if (!isGlAccountValid(glAccountId)) {
            String errMsg = "GL Account '" + glAccountId + "' is invalid";
            logger.error(errMsg);
            throw new InvalidGeneralLedgerAccountException(errMsg);
        }

        GeneralLedgerType glType = new GeneralLedgerType();
        glType.setCode(code);
        glType.setName(name);
        glType.setDescription(description);
        glType.setGlAccountId(glAccountId);
        glType.setGlOperationOnCharge(glOperationOnCharge);

        persistEntity(glType);

        return glType;
    }

    /**
     * Persists GeneralLedgerType instance in the persistence store.
     *
     * @param glType GL type
     * @return GL type ID
     */
    @Override
    public Long persistGeneralLedgerType(GeneralLedgerType glType) {
        return persistEntity(glType);
    }

    /**
     * Returns all general ledger types existing in KSA in chronological order.
     *
     * @return list of GeneralLedgerType instances
     */
    @Override
    public List<GeneralLedgerType> getGeneralLedgerTypes() {
        return getEntities(GeneralLedgerType.class, new Pair<String, SortOrder>("creationDate", SortOrder.ASC),
                new Pair<String, SortOrder>("id", SortOrder.ASC));
    }

    /**
     * Creates a new general ledger transaction based on the given parameters
     *
     * @param transactionId ID of the corresponding transaction
     * @param glAccountId   General ledger account ID
     * @param amount        Transaction amount
     * @param operationType GL operation type
     * @param statement     GL transaction statement
     * @param isQueued      Set status to Q unless isQueued is passed and is false, in which case, set status to W
     * @return new GL Transaction instance
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public GlTransaction createGlTransaction(Long transactionId, String glAccountId, BigDecimal amount,
                                             GlOperationType operationType, String statement, boolean isQueued) {

        if (!isGlAccountValid(glAccountId)) {
            String errMsg = "GL Account '" + glAccountId + "' is invalid";
            logger.error(errMsg);
            throw new InvalidGeneralLedgerAccountException(errMsg);
        }

        Transaction transaction = em.find(Transaction.class, transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        GlTransaction glTransaction = new GlTransaction();
        glTransaction.setDate(new Date());
        glTransaction.setAmount(amount != null ? amount : BigDecimal.ZERO);
        glTransaction.setGlAccountId(glAccountId);
        glTransaction.setGlOperation(operationType);
        if (StringUtils.hasText(statement)) {
            glTransaction.setStatement(statement);
        }
        glTransaction.setTransactions(new HashSet<Transaction>(Arrays.asList(transaction)));
        glTransaction.setStatus(isQueued ? GlTransactionStatus.QUEUED : GlTransactionStatus.WAITING);

        Date recognitionDate = transaction.getRecognitionDate();
        if (recognitionDate == null) {
            String errMsg = "GL recognition date cannot be null, Transaction ID = " + transactionId;
            throw new IllegalStateException(errMsg);
        }

        GlRecognitionPeriod recognitionPeriod = getGlRecognitionPeriod(recognitionDate);
        if (recognitionPeriod == null) {
            String errMsg = "GL recognition period cannot be found for the given date = " + recognitionDate;
            throw new IllegalStateException(errMsg);
        }

        glTransaction.setRecognitionPeriod(recognitionPeriod);

        persistEntity(glTransaction);

        return glTransaction;

    }

    /**
     * Creates a new general ledger transaction based on the given parameters
     *
     * @param transactionId ID of the corresponding transaction
     * @param glAccountId   General ledger account ID
     * @param amount        Transaction amount
     * @param operationType GL operation type
     * @param statement     GL transaction statement
     * @return new GL Transaction instance
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public GlTransaction createGlTransaction(Long transactionId, String glAccountId, BigDecimal amount,
                                             GlOperationType operationType, String statement) {
        return createGlTransaction(transactionId, glAccountId, amount, operationType, statement, true);

    }

    /**
     * Summarizes the general ledger transactions for the given GL transaction list
     *
     * @param transactions List of general ledger transactions
     * @return the modified list of GL transactions
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public List<GlTransaction> summarizeGlTransactions(List<GlTransaction> transactions) {

        // Creating a new array list based on the given GL transaction list
        List<GlTransaction> glTransactions = new ArrayList<GlTransaction>(transactions);

        // Map of [GL Account ID, GL Recognition Period ID] and set of transactions
        Map<Pair<String, Long>, Set<Transaction>> transactionMap = new HashMap<Pair<String, Long>, Set<Transaction>>();

        // Map of [GL Account ID, GL Recognition Period ID] and total transaction amount
        Map<Pair<String, Long>, BigDecimal> amountMap = new HashMap<Pair<String, Long>, BigDecimal>();

        // Map of [GL Account ID, GL Recognition Period ID] and the first GL transaction for this GL account from the given list
        Map<Pair<String, Long>, List<GlTransaction>> glTransactionMap = new HashMap<Pair<String, Long>, List<GlTransaction>>();

        for (GlTransaction glTransaction : glTransactions) {

            if (GlTransactionStatus.WAITING.equals(glTransaction.getStatus())) {

                String glAccountId = glTransaction.getGlAccountId();
                Long recognitionPeriodId = glTransaction.getRecognitionPeriod().getId();

                if (glAccountId != null && recognitionPeriodId != null) {

                    final Pair<String, Long> key = new Pair<String, Long>(glAccountId, recognitionPeriodId);

                    Set<Transaction> transactionsForAccount = transactionMap.get(key);
                    if (transactionsForAccount == null) {
                        transactionsForAccount = new HashSet<Transaction>();
                        transactionMap.put(key, transactionsForAccount);
                    }

                    // Adding all transactions to the list of transactions for the current GL account and Recognition Period
                    transactionsForAccount.addAll(glTransaction.getTransactions());

                    List<GlTransaction> glTransactionsForAccount = glTransactionMap.get(key);
                    if (glTransactionsForAccount == null) {
                        glTransactionsForAccount = new LinkedList<GlTransaction>();
                        glTransactionMap.put(key, glTransactionsForAccount);
                    }

                    // Adding GL transaction to the list of GL transactions for the current GL account and Recognition Period
                    glTransactionsForAccount.add(glTransaction);

                    BigDecimal amount = amountMap.get(key);
                    if (amount == null) {
                        amount = BigDecimal.ZERO;
                    }

                    for (Transaction trans : glTransaction.getTransactions()) {
                        amount = amount.add(trans.getAmount() != null ? trans.getAmount() : BigDecimal.ZERO);
                    }

                    // Sum up the transaction amount for the current GL account and Recognition Period
                    amountMap.put(key, amount.add(amount));
                }
            }
        }

        Set<Long> glTransactionIdsToDelete = new HashSet<Long>();
        for (Pair<String, Long> key : glTransactionMap.keySet()) {

            List<GlTransaction> glTransactionsForAccount = glTransactionMap.get(key);

            if (!CollectionUtils.isEmpty(glTransactionsForAccount)) {

                BigDecimal totalAmount = amountMap.get(key);

                if (!BigDecimal.ZERO.equals(totalAmount)) {

                    // Persisting the first GL transaction with the total amount and all
                    // transactions for the current GL account
                    GlTransaction firstGlTransaction = glTransactionsForAccount.get(0);
                    firstGlTransaction.setTransactions(transactionMap.get(key));
                    firstGlTransaction.setAmount(totalAmount);
                    persistEntity(firstGlTransaction);
                    // We have to remove the rest of GL transactions
                    for (int i = 1; i < glTransactionsForAccount.size(); i++) {
                        glTransactionIdsToDelete.add(glTransactionsForAccount.get(i).getId());
                    }

                } else {
                    for (GlTransaction glTransaction : glTransactionsForAccount) {
                        glTransactionIdsToDelete.add(glTransaction.getId());
                    }
                }
            }
        }

        // Deleting GL transactions that must be eliminated from the list and database and
        // persisting the rest with the status 'Q'
        for (Iterator<GlTransaction> iterator = glTransactions.iterator(); iterator.hasNext(); ) {
            GlTransaction glTransaction = iterator.next();
            if (glTransactionIdsToDelete.contains(glTransaction.getId())) {
                em.remove(glTransaction);
                iterator.remove();
            } else {
                glTransaction.setStatus(GlTransactionStatus.QUEUED);
                persistEntity(glTransaction);
            }
        }

        return glTransactions;
    }

    /**
     * Returns the general ledger type instance by code.
     *
     * @param glTypeCode General Ledger type code
     * @return GeneralLedgerType instance
     */
    @Override
    public GeneralLedgerType getGeneralLedgerType(String glTypeCode) {
        Query query = em.createQuery("select t from GeneralLedgerType t where t.code = :code");
        query.setParameter("code", glTypeCode);
        List<GeneralLedgerType> glTypes = query.getResultList();
        if (glTypes != null && !glTypes.isEmpty()) {
            return glTypes.get(0);
        }
        String errMsg = "Cannot find GeneralLedgerType for the code = " + glTypeCode;
        logger.error(errMsg);
        throw new InvalidGeneralLedgerTypeException(errMsg);
    }

    /**
     * Returns the general ledger type instance by ID.
     *
     * @param glTypeId General Ledger type ID
     * @return GeneralLedgerType instance
     */
    @Override
    @WebMethod(exclude = true)
    public GeneralLedgerType getGeneralLedgerType(Long glTypeId) {
        return getEntity(glTypeId, GeneralLedgerType.class);
    }

    /**
     * Returns the default general ledger type.
     *
     * @return GeneralLedgerType instance
     */
    @Override
    public GeneralLedgerType getDefaultGeneralLedgerType() {
        String defaultGlTypeCode = configService.getParameter(DEFAULT_GL_TYPE);
        if (org.apache.commons.lang.StringUtils.isBlank(defaultGlTypeCode)) {
            String errMsg = "Configuration parameter '" + DEFAULT_GL_TYPE + "' is required";
            logger.error(errMsg);
            throw new ConfigurationException(errMsg);
        }
        return getGeneralLedgerType(defaultGlTypeCode);
    }

    /**
     * Returns the default general ledger mode.
     *
     * @return GeneralLedgerMode instance
     */
    @Override
    public GeneralLedgerMode getDefaultGeneralLedgerMode() {
        String glMode = configService.getParameter(DEFAULT_GL_MODE);
        if (org.apache.commons.lang.StringUtils.isBlank(glMode)) {
            String errMsg = "Configuration parameter '" + DEFAULT_GL_MODE + "' is required";
            logger.error(errMsg);
            throw new ConfigurationException(errMsg);
        }
        return EnumUtils.findById(GeneralLedgerMode.class, glMode);
    }

    private GlTransmission createGlTransmission(String glAccountId, Date earliestDate, Date latestDate,
                                                GlOperationType glOperation, BigDecimal amount,
                                                GlRecognitionPeriod recognitionPeriod, String batchId) {

        if (!isGlAccountValid(glAccountId)) {
            String errMsg = "GL Account '" + glAccountId + "' is invalid";
            logger.error(errMsg);
            throw new InvalidGeneralLedgerAccountException(errMsg);
        }

        GlTransmission transmission = new GlTransmission();
        transmission.setStatus(GlTransmissionStatus.GENERATED);
        transmission.setBatchId(batchId);
        transmission.setGlAccountId(glAccountId);
        transmission.setEarliestDate(earliestDate);
        transmission.setLatestDate(latestDate);
        transmission.setRecognitionPeriod(recognitionPeriod);
        transmission.setDate(new Date());
        transmission.setGlOperation(glOperation);
        transmission.setAmount(amount);

        persistEntity(transmission);

        return transmission;

    }

    private GlTransmission createGlTransmission(GlTransaction transaction, GlRecognitionPeriod recognitionPeriod,
                                                String batchId) {
        return createGlTransmission(transaction.getGlAccountId(), transaction.getDate(), transaction.getDate(),
                transaction.getGlOperation(), transaction.getAmount(), recognitionPeriod, batchId);

    }

    /**
     * Finds the GL recognition period for the given date.
     *
     * @param date <code>java.util.Date</code> instance
     * @return GlRecognitionPeriod instance or null if not found
     */
    private GlRecognitionPeriod getGlRecognitionPeriod(Date date) {
        date = CalendarUtils.removeTime(date);
        Query query = em.createQuery("select rp from GlRecognitionPeriod rp where rp.startDate <= :date and rp.endDate >= :date");
        query.setParameter("date", date);
        List<GlRecognitionPeriod> results = (List<GlRecognitionPeriod>) query.getResultList();
        return (results != null && !results.isEmpty()) ? results.get(0) : null;
    }

    private synchronized void prepareGlTransmissions(Date fromDate, Date toDate, boolean isEffectiveDate,
                                                     String... recognitionPeriods) {

        if (fromDate != null && toDate != null && fromDate.after(toDate)) {
            String errMsg = "Start Date cannot be greater than End Date: Start Date = " + fromDate +
                    ", End Date = " + toDate;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        String glModeCode = configService.getParameter(DEFAULT_GL_MODE);
        if (org.apache.commons.lang.StringUtils.isBlank(glModeCode)) {
            String errMsg = "Configuration parameter '" + Constants.DEFAULT_GL_MODE + "' is required";
            logger.error(errMsg);
            throw new ConfigurationException(errMsg);
        }

        GeneralLedgerMode glMode = EnumUtils.findById(GeneralLedgerMode.class, glModeCode);
        if (glMode == null) {
            String errMsg = "General Ledger mode must be specified";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        Query query;
        if (fromDate != null && toDate != null) {
            // If isEffectiveDate is true then use the transaction effective date, otherwise the recognition date
            String dateField = isEffectiveDate ? "effectiveDate" : "recognitionDate";
            query = em.createQuery("select distinct t from GlTransaction t " +
                    " inner join fetch t.recognitionPeriod rp " +
                    " left outer join t.transactions ts " +
                    " where t.statusCode = :status and " +
                    " ts." + dateField + " <> null and ts." + dateField + " between :fromDate and :toDate " +
                    " order by t.date asc");
            query.setParameter("fromDate", fromDate);
            query.setParameter("toDate", toDate);
        } else {
            boolean periodExists = (recognitionPeriods != null && recognitionPeriods.length > 0);
            String inClause = periodExists ? " and rp.code in (:recognitionPeriods) " : "";
            query = em.createQuery("select t from GlTransaction t " +
                    " inner join fetch t.recognitionPeriod rp " +
                    " where t.statusCode = :status " + inClause + " order by t.date asc");
            if (periodExists) {
                query.setParameter("recognitionPeriods", Arrays.asList(recognitionPeriods));
            }
        }

        query.setParameter("status", GlTransactionStatus.QUEUED_CODE);
        if (glMode == GeneralLedgerMode.INDIVIDUAL) {
            query.setMaxResults(1);
        }

        List<GlTransaction> glTransactions = query.getResultList();
        if (CollectionUtils.isEmpty(glTransactions)) {
            if (fromDate != null && toDate != null) {
                logger.warn("Cannot find GL transactions for the given date range: fromDate = " + fromDate +
                        ", toDate = " + toDate);
            } else {
                logger.warn("No GL transactions found");
            }
            return;
        }

        if (glMode == GeneralLedgerMode.INDIVIDUAL) {
            GlTransaction earliestGlTransaction = glTransactions.get(0);
            GlRecognitionPeriod recognitionPeriod = earliestGlTransaction.getRecognitionPeriod();
            GlTransmission transmission = createGlTransmission(earliestGlTransaction, recognitionPeriod, "RT");
            earliestGlTransaction.setTransmission(transmission);
            earliestGlTransaction.setStatus(GlTransactionStatus.COMPLETED);
            //persistEntity(earliestGlTransaction);
        } else if (glMode == GeneralLedgerMode.BATCH) {
            for (GlTransaction transaction : glTransactions) {
                GlRecognitionPeriod recognitionPeriod = transaction.getRecognitionPeriod();
                GlTransmission transmission = createGlTransmission(transaction, recognitionPeriod, null);
                transaction.setTransmission(transmission);
                transaction.setStatus(GlTransactionStatus.COMPLETED);
                //persistEntity(transaction);
            }

        } else if (glMode == GeneralLedgerMode.BATCH_ROLLUP) {

            // Creating a map of <GL account, set of GL transactions>
            HashMap<String, Set<GlTransaction>> accountTransactions = new HashMap<String, Set<GlTransaction>>();
            for (GlTransaction transaction : glTransactions) {
                String accountId = transaction.getGlAccountId();
                Set<GlTransaction> glTransactionSet = accountTransactions.get(accountId);
                if (glTransactionSet == null) {
                    glTransactionSet = new HashSet<GlTransaction>();
                    accountTransactions.put(accountId, glTransactionSet);
                }
                glTransactionSet.add(transaction);
            }

            for (Map.Entry<String, Set<GlTransaction>> entry : accountTransactions.entrySet()) {

                String accountId = entry.getKey();

                Set<GlTransaction> glTransactionSet = entry.getValue();

                if (glTransactionSet.isEmpty()) {
                    continue;
                }

                GlRecognitionPeriod recognitionPeriod = null;
                GlOperationType groupOperation = null;
                BigDecimal amount1 = BigDecimal.ZERO;
                BigDecimal amount2 = BigDecimal.ZERO;
                Date minDate = null;
                Date maxDate = null;

                for (GlTransaction transaction : glTransactionSet) {
                    if (recognitionPeriod == null) {
                        recognitionPeriod = transaction.getRecognitionPeriod();
                    }
                    if (groupOperation == null) {
                        groupOperation = transaction.getGlOperation();
                    }
                    GlOperationType glOperation = transaction.getGlOperation();
                    if (glOperation != null) {
                        if (glOperation == groupOperation) {
                            amount1 = amount1.add(transaction.getAmount());
                        } else {
                            amount2 = amount2.add(transaction.getAmount());
                        }
                    }
                    if (minDate == null || minDate.after(transaction.getDate())) {
                        minDate = transaction.getDate();
                    }
                    if (maxDate == null || maxDate.before(transaction.getDate())) {
                        maxDate = transaction.getDate();
                    }
                }

                GlTransmission transmission = createGlTransmission(accountId, minDate, maxDate, groupOperation,
                        amount1.subtract(amount2), recognitionPeriod, null);

                // Updating GL transactions for the current account
                for (GlTransaction transaction : glTransactionSet) {
                    transaction.setStatus(GlTransactionStatus.COMPLETED);
                    transaction.setTransmission(transmission);
                    //persistEntity(transaction);
                }
            }
        } else {
            String errMsg = "Unexpected GeneralLedgerMode: " + glMode;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

    }

    /**
     * Prepares a transmission to the general ledger for the given range of effective dates.
     * This process takes into account the different ways in which an institution may choose to transmit to
     * the general ledger, including real-time, batch, and rollup modes.
     *
     * @param fromDate Start effective date
     * @param toDate   End effective date
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public void prepareGlTransmissionsForEffectiveDates(Date fromDate, Date toDate) {
        prepareGlTransmissions(fromDate, toDate, true);
    }

    /**
     * Prepares a transmission to the general ledger for the given range of recognition dates.
     * This process takes into account the different ways in which an institution may choose to transmit to
     * the general ledger, including real-time, batch, and rollup modes.
     *
     * @param fromDate Start recognition date
     * @param toDate   End recognition date
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public void prepareGlTransmissionsForRecognitionDates(Date fromDate, Date toDate) {
        prepareGlTransmissions(fromDate, toDate, false);
    }

    /**
     * Prepares a transmission to the general ledger for all GL transactions in status Q.
     * This process takes into account the different ways in which an institution may choose to transmit to
     * the general ledger, including real-time, batch, and rollup modes.
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public void prepareGlTransmissions() {
        prepareGlTransmissions(null, null, true);
    }

    /**
     * Prepares a transmission to the general ledger for the given GL recognition
     *
     * @param recognitionPeriods an array of GL recognition period codes
     */
    @Override
    @WebMethod(exclude = true)
    @Transactional(readOnly = false)
    public void prepareGlTransmissions(String... recognitionPeriods) {
        prepareGlTransmissions(null, null, true, recognitionPeriods);
    }

    /**
     * Retrieves all GL transmissions with the empty "result" field for export.
     *
     * @return list of GlTransmission instances
     */
    @Override
    @WebMethod(exclude = true)
    public List<GlTransmission> getGlTransmissionsForExport() {
        Query query = em.createQuery("select glt from GlTransmission glt " +
                " inner join fetch glt.recognitionPeriod rp " +
                " where glt.statusCode in (:statuses) " +
                " order by glt.date asc");
        query.setParameter("statuses", Arrays.asList(GlTransmissionStatus.GENERATED_CODE, GlTransmissionStatus.FAILED_CODE));
        return query.getResultList();
    }

    /**
     * Retrieves all GL transmissions with the empty "result" field
     * for the given transaction effective start and end dates
     *
     * @param startDate       Transaction effective or recognition start date
     * @param endDate         Transaction effective or recognition end date
     * @param isEffectiveDate if "true" this parameter indicates that transaction effective date should be used,
     *                        if "false" - transaction recognition date
     * @return list of GlTransmission instances
     */
    @Override
    public List<GlTransmission> getGlTransmissionsForExport(Date startDate, Date endDate, boolean isEffectiveDate) {

        if (startDate == null || endDate == null) {
            String errMsg = "Start Date and End Date cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (startDate.after(endDate)) {
            String errMsg = "Start Date cannot be greater than End Date: Start Date = " + startDate +
                    ", End Date = " + endDate;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        String dateField = isEffectiveDate ? "effectiveDate" : "recognitionDate";

        Query query = em.createQuery("select distinct glt from GlTransaction glt " +
                " inner join fetch glt.recognitionPeriod rp " +
                " inner join fetch glt.transmission t " +
                " left outer join glt.transactions ts " +
                " where t.statusCode in (:statuses) and " +
                " ts." + dateField + " <> null and ts." + dateField + " between :fromDate and :toDate " +
                " order by glt.date asc");

        query.setParameter("statuses", Arrays.asList(GlTransmissionStatus.GENERATED_CODE, GlTransmissionStatus.FAILED_CODE));
        query.setParameter("fromDate", startDate);
        query.setParameter("toDate", endDate);

        List<GlTransaction> glTransactions = query.getResultList();
        List<GlTransmission> glTransmissions = new ArrayList<GlTransmission>(glTransactions.size());

        for (GlTransaction glTransaction : glTransactions) {
            glTransmissions.add(glTransaction.getTransmission());
        }

        return glTransmissions;
    }


    /**
     * Validates the GL account number.
     *
     * @param glAccount GL account number
     * @return true if the GL account is valid, false - otherwise.
     */
    @Override
    public boolean isGlAccountValid(String glAccount) {

        if (!StringUtils.hasText(glAccount)) {
            logger.warn("GL Account cannot be empty");
            return false;
        }

        Query query = em.createQuery("select pattern from AllowableGlAccount");
        List<String> patterns = query.getResultList();
        if (!CollectionUtils.isEmpty(patterns)) {
            for (String pattern : patterns) {
                if (Pattern.compile(pattern).matcher(glAccount).matches()) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Retrieves all GL transactions for the given GL transaction date range and GL account ID
     * sorted by dates in ascending order.
     *
     * @param startDate   GL Transaction start date
     * @param endDate     GL Transaction end date
     * @param glAccountId GL Account ID
     * @return list of GlTransaction instances
     */
    @Override
    public List<GlTransaction> getGlTransactions(Date startDate, Date endDate, String glAccountId) {

        if (startDate == null || endDate == null) {
            String errMsg = "Start Date and End Date cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (startDate.after(endDate)) {
            String errMsg = "Start Date cannot be greater than End Date: Start Date = " + startDate +
                    ", End Date = " + endDate;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Query query = em.createQuery("select glt from GlTransaction glt " +
                " left outer join fetch glt.recognitionPeriod rp " +
                " left outer join fetch glt.transmission t " +
                " left outer join fetch glt.transactions ts " +
                " where glt.date between :startDate and :endDate " +
                (glAccountId != null ? " and glt.glAccountId = :glAccountId " : "") +
                " order by glt.date asc");

        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        if (glAccountId != null) {
            query.setParameter("glAccountId", glAccountId);
        }

        return query.getResultList();
    }

    /**
     * Retrieves all GL transactions for the given GL transaction date range sorted by dates in ascending order.
     *
     * @param startDate GL Transaction start date
     * @param endDate   GL Transaction end date
     * @return list of GlTransaction instances
     */
    @Override
    @WebMethod(exclude = true)
    public List<GlTransaction> getGlTransactions(Date startDate, Date endDate) {
        return getGlTransactions(startDate, endDate, null);
    }

    /**
     * Retrieves all GL transactions for the given GL transaction status.
     *
     * @param status GL Transaction status
     * @return list of GlTransaction instances
     */
    @Override
    public List<GlTransaction> getGlTransactionsByStatus(GlTransactionStatus status) {

        if (status == null) {
            String errMsg = "Status cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Query query = em.createQuery("select glt from GlTransaction glt " +
                " left outer join fetch glt.recognitionPeriod rp " +
                " left outer join fetch glt.transmission t " +
                " left outer join fetch glt.transactions ts " +
                " where glt.statusCode = :status " +
                " order by glt.date asc");

        query.setParameter("status", status.getId());

        return query.getResultList();
    }


}