package com.sigmasys.kuali.ksa.service.fm;

import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.exception.InvalidRateCatalogException;
import com.sigmasys.kuali.ksa.exception.InvalidRateException;
import com.sigmasys.kuali.ksa.exception.InvalidRateTypeException;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.fm.*;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Fee Rate Service.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Url(RateService.SERVICE_URL)
@WebService(serviceName = RateService.SERVICE_NAME, portName = RateService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
public interface RateService {

    String SERVICE_URL = "rate.webservice";
    String SERVICE_NAME = "RateService";
    String PORT_NAME = SERVICE_NAME + "Port";


    // Rate Type methods

    /**
     * Creates a new RateType instance and persists it in the database.
     *
     * @param code        RateType code
     * @param name        RateType name
     * @param description RateType description
     * @return a new RateType instance
     */
    RateType createRateType(String code, String name, String description);

    /**
     * Persists RateType in the database.
     *
     * @param rateType RateType instance
     * @return RateType ID
     */
    Long persistRateType(RateType rateType);

    /**
     * Removes the RateType instance specified by ID from the persistent store.
     *
     * @param rateTypeId RateType ID
     */
    void deleteRateType(Long rateTypeId);

    /**
     * Removes the RateType instance specified by code from the persistent store
     *
     * @param rateTypeCode RateType code
     */
    void deleteRateTypeByCode(String rateTypeCode);

    /**
     * Retrieves the RateType instance from the persistent store by ID.
     *
     * @param rateTypeId RateType ID
     * @return RateType instance
     */
    RateType getRateType(Long rateTypeId);

    /**
     * Retrieves the RateType instance from the persistent store by code.
     *
     * @param rateTypeCode RateType code
     * @return RateType instance
     */
    RateType getRateTypeByCode(String rateTypeCode);

    /**
     * Checks if the rate type specified by code exists.
     *
     * @param rateTypeCode RateType code
     * @return true if the rate type exists, false - otherwise
     */
    boolean rateTypeExists(String rateTypeCode);

    /**
     * Returns the list of rate types by the given name pattern.
     *
     * @param namePattern Name pattern
     * @return a list of RateType instances
     */
    List<RateType> getRateTypesByNamePattern(String namePattern);

    /**
     * Returns the list of all rate types.
     *
     * @return a list of RateType instances
     */
    List<RateType> getAllRateTypes();

    // Rate Catalog methods

    /**
     * Creates a new RateCatalog persistent instance from the set of given parameters.
     *
     * @param rateCatalogCode            RateCatalog code
     * @param rateTypeCode               RateType code
     * @param transactionTypeId          TransactionType ID
     * @param transactionDateType        TransactionDateType enum value
     * @param lowerBoundAmount           Minimum transaction amount
     * @param upperBoundAmount           Maximum transaction amount
     * @param cappedAmount               Capped amount
     * @param atpIds                     list of ATP IDs
     * @param keyPairs                   list of KeyPair instances
     * @param isTransactionTypeFinal     Indicates whether the transaction type is final
     * @param isTransactionDateTypeFinal Indicates whether the transaction date type is final
     * @param isRecognitionDateDefinable Indicates whether the recognition date can be set
     * @param isAmountFinal              Indicates whether the rate amount is final
     * @param isKeyPairFinal             Indicates whether the set of KeyPairs is immutable
     * @return a new RateCatalog instance
     */
    RateCatalog createRateCatalog(String rateCatalogCode,
                                  String rateTypeCode,
                                  String transactionTypeId,
                                  TransactionDateType transactionDateType,
                                  BigDecimal lowerBoundAmount,
                                  BigDecimal upperBoundAmount,
                                  BigDecimal cappedAmount,
                                  List<String> atpIds,
                                  List<KeyPair> keyPairs,
                                  boolean isTransactionTypeFinal,
                                  boolean isTransactionDateTypeFinal,
                                  boolean isRecognitionDateDefinable,
                                  boolean isAmountFinal,
                                  boolean isKeyPairFinal);

    /**
     * Persists RateCatalog in the database.
     *
     * @param rateCatalog RateCatalog instance
     * @return RateCatalog ID
     */
    Long persistRateCatalog(RateCatalog rateCatalog);

    /**
     * Removes RateCatalog from the persistent store.
     *
     * @param rateCatalogId RateCatalog ID
     */
    void deleteRateCatalog(Long rateCatalogId);

    /**
     * Retrieves the RateCatalog instance specified by ID from the persistent store.
     *
     * @param rateCatalogId RateCatalog ID
     * @return RateCatalog instance
     */
    RateCatalog getRateCatalog(Long rateCatalogId);

    /**
     * Retrieves the RateCatalog instance specified by Rate ID from the persistent store.
     *
     * @param rateId Rate ID
     * @return RateCatalog instance
     */
    RateCatalog getRateCatalogByRateId(Long rateId);

    /**
     * Retrieves the RateCatalog instance specified by code and ATP ID from the persistent store.
     *
     * @param rateCatalogCode RateCatalog code
     * @param atpId           ATP ID
     * @return RateCatalog instance
     */
    RateCatalog getRateCatalogByCodeAndAtpId(String rateCatalogCode, String atpId);

    /**
     * Returns the list of rate catalogs by code.
     *
     * @param rateCatalogCode RateCatalog code
     * @return a list of RateCatalog instances
     */
    List<RateCatalog> getRateCatalogsByCode(String rateCatalogCode);

    /**
     * Returns the list of rate catalogs by ATP ID.
     *
     * @param atpId ATP ID
     * @return a list of RateCatalog instances
     */
    List<RateCatalog> getRateCatalogsByAtpId(String atpId);

    /**
     * Returns the list of rate catalogs by the given name pattern.
     *
     * @param namePattern Name pattern
     * @return a list of RateCatalog instances
     */
    List<RateCatalog> getRateCatalogsByNamePattern(String namePattern);

    /**
     * Returns the list of all rate catalogs.
     *
     * @return a list of RateCatalog instances
     */
    List<RateCatalog> getAllRateCatalogs();

    // Rate methods

    /**
     * Creates a new persistent Rate instance based on the given parameters.
     *
     * @param rateCode                Rate code
     * @param rateName                Rate name
     * @param rateCatalogCode         RateCatalog code
     * @param transactionTypeId       Rate TransactionType ID
     * @param amountTransactionTypeId RateAmount TransactionType ID
     * @param transactionDateType     TransactionDateType enum value
     * @param defaultRateAmount       Default Rate amount
     * @param cappedAmount            Capped amount
     * @param transactionDate         Transaction date
     * @param recognitionDate         Recognition date
     * @param atpId                   ATP ID
     * @param isTransactionTypeFinal  Indicates whether the transaction type is final
     * @param isAmountFinal           Indicates whether the rate amount is final
     * @return a new Rate instance
     */
    Rate createRate(String rateCode,
                    String rateName,
                    String rateCatalogCode,
                    String transactionTypeId,
                    String amountTransactionTypeId,
                    TransactionDateType transactionDateType,
                    BigDecimal defaultRateAmount,
                    BigDecimal cappedAmount,
                    Date transactionDate,
                    Date recognitionDate,
                    String atpId,
                    boolean isTransactionTypeFinal,
                    boolean isAmountFinal);

    /**
     * Persists the Rate instance in the database.
     *
     * @param rate Rate instance
     * @return Rate ID
     */
    Long persistRate(Rate rate);

    /**
     * Removes Rate specified by ID from the persistent store
     *
     * @param rateId Rate ID
     */
    void deleteRate(Long rateId);

    /**
     * Retrieves the Rate instance from the database by ID.
     *
     * @param rateId Rate ID
     * @return Rate instance
     */
    Rate getRate(Long rateId);

    /**
     * Retrieves the Rate instance from the database by code and ATP ID.
     *
     * @param rateCode Rate code
     * @param atpId    ATP ID
     * @return Rate instance
     */
    Rate getRateByCodeAndAtpId(String rateCode, String atpId);

    /**
     * Returns the list of rates by code.
     *
     * @param rateCode Rate code
     * @return a list of Rate instances
     */
    List<Rate> getRatesByCode(String rateCode);

    /**
     * Returns the list of rates by ATP ID.
     *
     * @param atpId ATP ID
     * @return a list of Rate instances
     */
    List<Rate> getRatesByAtpId(String atpId);

    /**
     * Returns the list of rates by RateCatalog ID.
     *
     * @param rateCatalogId Rate catalog ID
     * @return a list of Rate instances
     */
    List<Rate> getRatesByCatalogId(Long rateCatalogId);

    /**
     * Returns the list of rates by name pattern.
     *
     * @param namePattern Name pattern
     * @return a list of Rate instances
     */
    List<Rate> getRatesByNamePattern(String namePattern);

    /**
     * Returns the list of all rates.
     *
     * @return a list of Rate instances
     */
    List<Rate> getAllRates();

    /**
     * Retrieves a set of ATP IDs for the rate catalog specified by ID.
     *
     * @param rateCatalogId RateCatalog ID
     * @return a set of ATP IDs
     */
    Set<String> getAtpsForRateCatalog(Long rateCatalogId);

    /**
     * Checks with the ATP service whether the given ATP ID exists in the system.
     *
     * @param atpId ATP ID to check
     * @return true if the ATP ID exists, false - otherwise
     */
    boolean atpExists(String atpId);

    // Additional methods

    /**
     * Validates the given RateType instance and throws <code>InvalidRateTypeException</code> if the validation fails.
     *
     * @param rateType RateType instance
     * @throws com.sigmasys.kuali.ksa.exception.InvalidRateTypeException
     *
     */
    void validateRateType(RateType rateType) throws InvalidRateTypeException;

    /**
     * Validates the given Rate instance and throws <code>InvalidRateException</code> if the validation fails.
     *
     * @param rate Rate instance
     * @throws com.sigmasys.kuali.ksa.exception.InvalidRateException
     *
     */
    void validateRate(Rate rate) throws InvalidRateException;

    /**
     * Validates the given RateCatalog instance and throws <code>InvalidRateCatalogException</code> if the validation fails.
     *
     * @param rateCatalog RateCatalog instance
     * @throws com.sigmasys.kuali.ksa.exception.InvalidRateException
     *
     * @throws com.sigmasys.kuali.ksa.exception.InvalidRateCatalogException
     *
     */
    void validateRateCatalog(RateCatalog rateCatalog) throws InvalidRateException, InvalidRateCatalogException;

    /**
     * Validates the Rate against the RateCatalog instance
     * and throws <code>InvalidRateException</code> or <code>InvalidRateCatalogException</code> if the validation fails.
     *
     * @param rate        Rate instance
     * @param rateCatalog RateCatalog instance
     * @throws com.sigmasys.kuali.ksa.exception.InvalidRateException
     *
     */
    void validateRateWithCatalog(Rate rate, RateCatalog rateCatalog) throws InvalidRateException;

    /**
     * Checks if the rate type is valid.
     *
     * @param rateType RateType instance
     * @return true if the rate is valid, otherwise false
     */
    boolean isRateTypeValid(RateType rateType);

    /**
     * Checks if the rate is valid.
     *
     * @param rate Rate instance
     * @return true if the rate is valid, otherwise false
     */
    boolean isRateValid(Rate rate);

    /**
     * Checks if the rate catalog is valid.
     *
     * @param rateCatalog RateCatalog instance
     * @return true if the rate catalog is valid, otherwise false
     */
    boolean isRateCatalogValid(RateCatalog rateCatalog);

    /**
     * Checks if the rate is valid for the given rate catalog.
     *
     * @param rate        Rate instance
     * @param rateCatalog RateCatalog instance
     * @return true if the rate is valid, otherwise false
     */
    boolean isRateValidWithCatalog(Rate rate, RateCatalog rateCatalog);

    /**
     * Assigns the array of ATP IDs to the rate catalog specified by ID.
     *
     * @param rateCatalogId RateCatalog ID
     * @param atpIds        Array of ATP IDs
     * @return RateCatalog instance
     */
    RateCatalog assignAtpsToRateCatalog(Long rateCatalogId, String... atpIds);

    /**
     * Adds new and/or transfer the existing array of ATP IDs
     * from another rate catalog (if other rate catalogs use them) the to the rate catalog specified by ID.
     *
     * @param rateCatalogId RateCatalog ID
     * @param atpIds        Array of ATP IDs
     * @return RateCatalog instance
     */
    RateCatalog transferAtpsToRateCatalog(Long rateCatalogId, String... atpIds);

    /**
     * Remove the ATP IDs from the rate catalog specified by ID.
     *
     * @param rateCatalogId RateCatalog ID
     * @param atpIds        Array of ATP IDs to be removed
     * @return RateCatalog instance
     */
    RateCatalog removeAtpsFromRateCatalog(Long rateCatalogId, String... atpIds);

    /**
     * Adds a new key pair to the rate catalog specified by ID.
     *
     * @param key           KeyPair key
     * @param value         KeyPair value
     * @param rateCatalogId RateCatalog ID
     * @return RateCatalog instance
     */
    RateCatalog addKeyPairToRateCatalog(String key, String value, Long rateCatalogId);

    /**
     * Removes the key pair from the rate catalog specified by ID.
     *
     * @param key           KeyPair key
     * @param rateCatalogId RateCatalog ID
     * @return RateCatalog instance
     */
    RateCatalog removeKeyPairFromRateCatalog(String key, Long rateCatalogId);

    /**
     * Adds a new key pair to the rate specified by ID.
     *
     * @param key    KeyPair key
     * @param value  KeyPair value
     * @param rateId Rate ID
     * @return Rate instance
     */
    Rate addKeyPairToRate(String key, String value, Long rateId);

    /**
     * Removes the key pair from the rate specified by ID.
     *
     * @param key    KeyPair key
     * @param rateId Rate ID
     * @return Rate instance
     */
    Rate removeKeyPairFromRate(String key, Long rateId);


    /**
     * Adds new amounts to the rate specified by ID
     *
     * @param rateId      Rate ID
     * @param rateAmounts list of RateAmount instances
     * @return Rate instance
     */
    Rate addAmountsToRate(Long rateId, List<RateAmount> rateAmounts);


    /**
     * Removes the rate amount from the persistent store by ID.
     *
     * @param rateAmountId RateAmount ID
     */
    void deleteRateAmount(Long rateAmountId);


}
