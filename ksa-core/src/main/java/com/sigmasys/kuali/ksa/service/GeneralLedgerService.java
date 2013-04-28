package com.sigmasys.kuali.ksa.service;

import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.model.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * General Ledger service declares business operations on GL Transactions and related objects
 * <p/>
 *
 * @author Michael Ivanov
 */
@Url(GeneralLedgerService.SERVICE_URL)
@WebService(serviceName = GeneralLedgerService.SERVICE_NAME, portName = GeneralLedgerService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
public interface GeneralLedgerService {

    String SERVICE_URL = "generalLedger.webservice";
    String SERVICE_NAME = "GeneralLedgerService";
    String PORT_NAME = SERVICE_NAME + "Port";


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
    GeneralLedgerType createGeneralLedgerType(String code, String name, String description, String glAccountId,
                                              GlOperationType glOperationOnCharge);

    /**
     * Persists GeneralLedgerType instance in the persistence store.
     *
     * @param glType GL type
     * @return GL type ID
     */
    Long persistGeneralLedgerType(GeneralLedgerType glType);

    /**
     * Returns all general ledger types existing in KSA in chronological order.
     *
     * @return list of GeneralLedgerType instances
     */
    List<GeneralLedgerType> getGeneralLedgerTypes();


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
    @WebMethod(exclude = true)
    GlTransaction createGlTransaction(Long transactionId, String glAccountId, BigDecimal amount,
                                      GlOperationType operationType, String statement, boolean isQueued);

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
    @WebMethod(exclude = true)
    GlTransaction createGlTransaction(Long transactionId, String glAccountId, BigDecimal amount,
                                      GlOperationType operationType, String statement);


    /**
     * Summarizes the general ledger transactions for the given GL transaction list
     *
     * @param transactions List of general ledger transactions
     * @return the modified list of GL transactions
     */
    @WebMethod(exclude = true)
    List<GlTransaction> summarizeGlTransactions(List<GlTransaction> transactions);

    /**
     * Returns the general ledger type instance by code.
     *
     * @param glTypeCode General Ledger type code
     * @return GeneralLedgerType instance
     */
    GeneralLedgerType getGeneralLedgerType(String glTypeCode);

    /**
     * Returns the general ledger type instance by ID.
     *
     * @param glTypeId General Ledger type ID
     * @return GeneralLedgerType instance
     */
    @WebMethod(exclude = true)
    GeneralLedgerType getGeneralLedgerType(Long glTypeId);

    /**
     * Returns the default general ledger mode.
     *
     * @return GeneralLedgerMode instance
     */
    GeneralLedgerMode getDefaultGeneralLedgerMode();

    /**
     * Returns the default general ledger type instance for the given code.
     *
     * @return GeneralLedgerType instance
     */
    GeneralLedgerType getDefaultGeneralLedgerType();

    /**
     * Prepares a transmission to the general ledger for the given range of effective dates.
     * This process takes into account the different ways in which an institution may choose to transmit to
     * the general ledger, including real-time, batch, and rollup modes.
     *
     * @param fromDate Start effective date
     * @param toDate   End effective date
     */
    @WebMethod(exclude = true)
    void prepareGlTransmissionsForEffectiveDates(Date fromDate, Date toDate);

    /**
     * Prepares a transmission to the general ledger for the given range of recognition dates.
     * This process takes into account the different ways in which an institution may choose to transmit to
     * the general ledger, including real-time, batch, and rollup modes.
     *
     * @param fromDate Start recognition date
     * @param toDate   End recognition date
     */
    @WebMethod(exclude = true)
    void prepareGlTransmissionsForRecognitionDates(Date fromDate, Date toDate);

    /**
     * Prepares a transmission to the general ledger for the given GL recognition
     *
     * @param recognitionPeriods an array of GL recognition period codes
     */
    @WebMethod(exclude = true)
    void prepareGlTransmissions(String... recognitionPeriods);

    /**
     * Prepares a transmission to the general ledger for all GL transactions in status Q.
     * This process takes into account the different ways in which an institution may choose to transmit to
     * the general ledger, including real-time, batch, and rollup modes.
     */
    @WebMethod(exclude = true)
    void prepareGlTransmissions();

    /**
     * Retrieves all GL transmissions with the statuses for export
     *
     * @return list of GlTransmission instances
     */
    @WebMethod(exclude = true)
    List<GlTransmission> getGlTransmissionsForExport();

    /**
     * Retrieves all GL transmissions with the statuses for export by batch ID.
     *
     * @param batchId  GL transmission batch ID
     * @param statuses Status of GL Transmissions to retrieve.
     * @return list of GlTransmission instances
     */
    @WebMethod(exclude = true)
    List<GlTransmission> getGlTransmissionsForExport(String batchId, GlTransmissionStatus... statuses);

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
    List<GlTransmission> getGlTransmissionsForExport(Date startDate, Date endDate, boolean isEffectiveDate);

    /**
     * Validates the GL account number.
     *
     * @param glAccount GL account number
     * @return true if the GL account is valid, false - otherwise.
     */
    boolean isGlAccountValid(String glAccount);

    /**
     * Retrieves all GL transactions for the given GL transaction date range and GL account ID
     * sorted by dates in ascending order.
     *
     * @param startDate   GL Transaction start date
     * @param endDate     GL Transaction end date
     * @param glAccountId GL Account ID
     * @return list of GlTransaction instances
     */
    List<GlTransaction> getGlTransactions(Date startDate, Date endDate, String glAccountId);

    /**
     * Retrieves all GL transactions for the given GL transaction date range sorted by dates in ascending order.
     *
     * @param startDate GL Transaction start date
     * @param endDate   GL Transaction end date
     * @return list of GlTransaction instances
     */
    @WebMethod(exclude = true)
    List<GlTransaction> getGlTransactions(Date startDate, Date endDate);

    /**
     * Retrieves all GL transactions for the given GL transaction status.
     *
     * @param status GL Transaction status
     * @return list of GlTransaction instances
     */
    @WebMethod(exclude = true)
    List<GlTransaction> getGlTransactionsByStatus(GlTransactionStatus status);

    /**
     * Retrieves GL transactions that belong to the specified Batch.
     *
     * @param batchId   ID of a Batch which GL Transactions to retrieve.
     * @return list of GL Transactions belonging to the Batch.
     */
    @WebMethod(exclude = true)
    List<GlTransaction> getGlTransactionsForBatch(String batchId);

    /**
     * Retrieves all GL Transmissions with the specified statuses.
     *
     * @param statuses Statuses of GL Transmissions to retrieve.
     * @return A list of GL Transmissions with the specified statuses.
     */
    @WebMethod(exclude = true)
    List<GlTransmission> getGlTransmissionsByStatuses(GlTransmissionStatus... statuses);
}
