package com.sigmasys.kuali.ksa.service;

import com.sigmasys.kuali.ksa.model.*;

import java.util.Date;
import java.util.List;

/**
 * Information Service
 * <p/>
 *
 * @author Michael Ivanov
 */
public interface InformationService {

    /**
     * Returns Information by ID
     *
     * @param id Information ID
     * @return Information instance
     */
    Information getInformation(Long id);

    /**
     * Returns Memo by ID
     *
     * @param id Memo ID
     * @return Memo instance
     */
    Memo getMemo(Long id);

    /**
     * Returns Alert by ID
     *
     * @param id Alert ID
     * @return Alert instance
     */
    Alert getAlert(Long id);

    /**
     * Returns Flag by ID
     *
     * @param id Flag ID
     * @return Flag instance
     */
    Flag getFlag(Long id);

    /**
     * Returns all Information entities sorted by ID in the descendant order
     *
     * @return List of Information instances
     */
    List<Information> getInformations();

    /**
     * Returns all Memo entities sorted by ID in the descendant order
     *
     * @return List of memos
     */
    List<Memo> getMemos();

    /**
     * Returns all Flag entities sorted by ID in the descendant order
     *
     * @return List of flags
     */
    List<Flag> getFlags();

    /**
     * Returns all Alert entities sorted by ID in the descendant order
     *
     * @return List of alerts
     */
    List<Alert> getAlerts();

    /**
     * Returns all Memo entities by Transaction ID
     *
     * @param transactionId Transaction ID
     * @return List of memos for the given transaction
     */
    List<Memo> getMemos(Long transactionId);


    /**
     * Returns all Alert entities by Account ID
     *
     * @param userId Account ID
     * @return List of alerts
     */
    List<Alert> getAlerts(String userId);

    /**
     * Returns all Flag entities by Account ID
     *
     * @param userId Account ID
     * @return List of flags
     */
    List<Flag> getFlags(String userId);

    /**
     * Returns all Memo entities by Account ID
     *
     * @param userId Account ID
     * @return List of memos
     */
    List<Memo> getMemos(String userId);

    /**
     * Persists Information in the database.
     * Creates a new entity when ID is null and updates the existing one otherwise.
     *
     * @param information Information instance
     * @return Information ID
     */
    Long persistInformation(Information information);

    /**
     * Removes Information from the database.
     *
     * @param id Information ID
     * @return true if Information entity has been deleted
     */
    boolean deleteInformation(Long id);

    /**
     * Memos can be generated in a number of ways. If a memo is generated
     * against a transaction, it is placed in the main memo account, and also
     * the memoReference is set to point to that memo. This allows the CSR to
     * see the most recent memo associated with a certain transaction. Certain
     * transaction instantiations will generate a memo as soon as they are
     * created.
     *
     * @param transactionId   Transaction ID
     * @param memoText        Memo text
     * @param accessLevelCode InformationAccessLevel code
     * @param effectiveDate   Effective date
     * @param expirationDate  Expiration date
     * @param prevMemoId      Previous Memo ID    @return new Memo instance
     */
    Memo createMemo(Long transactionId, String memoText, String accessLevelCode,
                    Date effectiveDate, Date expirationDate, Long prevMemoId);

    /**
     * Memos can be generated in a number of ways. If a memo is generated
     * against a transaction, it is placed in the main memo account, and also
     * the memoReference is set to point to that memo. This allows the CSR to
     * see the most recent memo associated with a certain transaction. Certain
     * transaction instantiations will generate a memo as soon as they are
     * created.
     *
     * @param accountId       Account ID
     * @param memoText        Memo text
     * @param accessLevelCode InformationAccessLevel code
     * @param effectiveDate   Effective date
     * @param expirationDate  Expiration date
     * @param prevMemoId      Previous Memo ID    @return new Memo instance
     */
    Memo createMemo(String accountId, String memoText, String accessLevelCode,
                    Date effectiveDate, Date expirationDate, Long prevMemoId);


    /**
     * Creates a new flag based on the given parameters
     *
     * @param transactionId   Transaction ID
     * @param flagTypeId      Flag Type ID
     * @param accessLevelCode InformationAccessLevel code
     * @param severity        Severity
     * @param effectiveDate   Effective date
     * @param expirationDate  Expiration date    @return new Flag instance
     */
    Flag createFlag(Long transactionId, Long flagTypeId, String accessLevelCode,
                    Integer severity, Date effectiveDate, Date expirationDate);

    /**
     * Creates a new flag based on the given parameters
     *
     * @param accountId       Account ID
     * @param flagTypeId      Flag Type ID
     * @param accessLevelCode InformationAccessLevel code
     * @param severity        Severity
     * @param effectiveDate   Effective date
     * @param expirationDate  Expiration date    @return new Flag instance
     */
    Flag createFlag(String accountId, Long flagTypeId, String accessLevelCode,
                    Integer severity, Date effectiveDate, Date expirationDate);

    /**
     * Creates a new alert based on the given parameters
     *
     * @param transactionId   Transaction ID
     * @param alertText       Alert text
     * @param accessLevelCode InformationAccessLevel code
     * @param effectiveDate   Effective date
     * @param expirationDate  Expiration date   @return new Alert instance
     */
    Alert createAlert(Long transactionId, String alertText, String accessLevelCode, Date effectiveDate, Date expirationDate);

    /**
     * Creates a new alert based on the given parameters
     *
     * @param accountId       Account ID
     * @param alertText       Alert text
     * @param accessLevelCode InformationAccessLevel code
     * @param effectiveDate   Effective date
     * @param expirationDate  Expiration date
     * @return new Alert instance
     */
    Alert createAlert(String accountId, String alertText, String accessLevelCode, Date effectiveDate, Date expirationDate);

    /**
     * Returns the default Memo's InformationAccessLevel code.
     *
     * @return InformationAccessLevel code
     */
    String getDefaultMemoLevel();

    /**
     * Associates the information represented by Information ID with the given Account ID
     *
     * @param informationId Information ID
     * @param accountId     Account ID
     * @return an updated instance of Information
     */
    Information associateWithAccount(Long informationId, String accountId);

    /**
     * Associates the information represented by Information ID with the Transaction specified by ID
     *
     * @param informationId Information ID
     * @param transactionId Transaction ID
     * @return an updated instance of Information
     */
    Information associateWithTransaction(Long informationId, Long transactionId);

    /**
     * Returns InformationAccessLevel instance by code.
     *
     * @param code InformationAccessLevel code
     * @return InformationAccessLevel instance
     */
    InformationAccessLevel getInformationAccessLevel(String code);

    /**
     * Returns InformationAccessLevel instance by ID.
     *
     * @param id InformationAccessLevel ID
     * @return InformationAccessLevel instance
     */
    InformationAccessLevel getInformationAccessLevel(Long id);

}
