package com.sigmasys.kuali.ksa.service.fm.impl;

import com.sigmasys.kuali.ksa.exception.InvalidRateCatalogException;
import com.sigmasys.kuali.ksa.exception.InvalidRateException;
import com.sigmasys.kuali.ksa.exception.InvalidRateTypeException;
import com.sigmasys.kuali.ksa.exception.InvalidTransactionTypeException;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.fm.RateService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import com.sigmasys.kuali.ksa.util.BeanUtils;
import com.sigmasys.kuali.ksa.util.RequestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.core.atp.infc.Atp;
import org.kuali.student.r2.core.atp.service.AtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.*;

/**
 * Fee Rate Service implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("rateService")
@Transactional(readOnly = true)
@WebService(serviceName = RateService.SERVICE_NAME, portName = RateService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
@SuppressWarnings("unchecked")
public class RateServiceImpl extends GenericPersistenceService implements RateService {

    private static final Log logger = LogFactory.getLog(RateServiceImpl.class);

    private static final String GET_RATE_JOIN = "select r from Rate r " +
            " inner join fetch r.rateType rt " +
            " inner join fetch r.rateCatalogAtp rca " +
            " left outer join fetch r.defaultRateAmount dra " +
            " left outer join fetch r.keyPairs kp " +
            " left outer join fetch r.rateAmounts ra ";


    @Autowired
    private AtpService atpService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AuditableEntityService auditableEntityService;


    // Rate Type methods

    /**
     * Creates a new RateType instance and persists it in the database.
     *
     * @param code        RateType code
     * @param name        RateType name
     * @param description RateType description
     * @return a new RateType instance
     */
    @Override
    @Transactional(readOnly = false)
    public RateType createRateType(String code, String name, String description) {

        PermissionUtils.checkPermission(Permission.CREATE_RATE_TYPE);

        RateType rateType = new RateType();
        rateType.setCode(code);
        rateType.setName(name);
        rateType.setDescription(description);

        validateRateType(rateType);

        auditableEntityService.persistAuditableEntity(rateType);

        return rateType;
    }

    /**
     * Persists RateType in the database.
     *
     * @param rateType RateType instance
     * @return RateType ID
     */
    @Override
    @Transactional(readOnly = false)
    public Long persistRateType(RateType rateType) {

        PermissionUtils.checkPermission(Permission.UPDATE_RATE_TYPE);

        validateRateType(rateType);

        return auditableEntityService.persistAuditableEntity(rateType);
    }

    /**
     * Removes the RateType instance specified by ID from the persistence store.
     *
     * @param rateTypeId RateType ID
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteRateType(Long rateTypeId) {

        PermissionUtils.checkPermission(Permission.UPDATE_RATE_TYPE);

        auditableEntityService.deleteAuditableEntity(rateTypeId, RateType.class);
    }

    /**
     * Removes the RateType instance specified by code from the persistence store
     *
     * @param rateTypeCode RateType code
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteRateTypeByCode(String rateTypeCode) {

        PermissionUtils.checkPermission(Permission.DELETE_RATE_TYPE);

        RateType rateType = getRateTypeByCode(rateTypeCode);
        if (rateType == null) {
            String errMsg = "RateType with code '" + rateTypeCode + "' does not exist";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        auditableEntityService.deleteAuditableEntity(rateType.getId(), RateType.class);
    }

    /**
     * Retrieves the RateType instance from the persistence store by ID.
     *
     * @param rateTypeId RateType ID
     * @return RateType instance
     */
    @Override
    public RateType getRateType(Long rateTypeId) {
        PermissionUtils.checkPermission(Permission.READ_RATE_TYPE);
        return auditableEntityService.getAuditableEntity(rateTypeId, RateType.class);
    }

    /**
     * Retrieves the RateType instance from the persistence store by code.
     *
     * @param rateTypeCode RateType code
     * @return RateType instance
     */
    @Override
    public RateType getRateTypeByCode(String rateTypeCode) {
        PermissionUtils.checkPermission(Permission.READ_RATE_TYPE);
        return auditableEntityService.getAuditableEntity(rateTypeCode, RateType.class);
    }

    /**
     * Checks if the rate type specified by code exists.
     *
     * @param rateTypeCode RateType code
     * @return true if the rate type exists, false - otherwise
     */
    @Override
    public boolean rateTypeExists(String rateTypeCode) {
        Query query = em.createQuery("select 1 from RateType where code = :code");
        query.setParameter("code", rateTypeCode);
        query.setMaxResults(1);
        return CollectionUtils.isNotEmpty(query.getResultList());
    }

    /**
     * Returns the list of rate types by the given name pattern.
     *
     * @param namePattern Name pattern
     * @return a list of RateType instances
     */
    @Override
    public List<RateType> getRateTypesByNamePattern(String namePattern) {
        PermissionUtils.checkPermission(Permission.READ_RATE_TYPE);
        return auditableEntityService.getAuditableEntitiesByNamePattern(namePattern, RateType.class);
    }

    /**
     * Returns the list of all rate types.
     *
     * @return a list of RateType instances
     */
    @Override
    public List<RateType> getAllRateTypes() {
        PermissionUtils.checkPermission(Permission.READ_RATE_TYPE);
        return auditableEntityService.getAuditableEntities(RateType.class);
    }

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
    @Override
    @Transactional(readOnly = false)
    public RateCatalog createRateCatalog(String rateCatalogCode,
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
                                         boolean isKeyPairFinal) {

        PermissionUtils.checkPermission(Permission.CREATE_RATE_CATALOG);

        if (StringUtils.isBlank(rateCatalogCode)) {
            String errMsg = "RateCatalog code cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        RateType rateType = getRateTypeByCode(rateTypeCode);
        if (rateType == null) {
            String errMsg = "RateType with code = " + rateTypeCode;
            logger.error(errMsg);
            throw new InvalidRateTypeException(errMsg);
        }

        RateCatalog rateCatalog = new RateCatalog();
        rateCatalog.setCode(rateCatalogCode);
        rateCatalog.setRateType(rateType);
        rateCatalog.setTransactionTypeId(transactionTypeId);
        rateCatalog.setTransactionDateType(transactionDateType);
        rateCatalog.setLowerBoundAmount(lowerBoundAmount);
        rateCatalog.setUpperBoundAmount(upperBoundAmount);
        rateCatalog.setCappedAmount(cappedAmount);


        rateCatalog.setTransactionTypeFinal(isTransactionTypeFinal);
        rateCatalog.setTransactionDateTypeFinal(isTransactionDateTypeFinal);
        rateCatalog.setRecognitionDateDefinable(isRecognitionDateDefinable);
        rateCatalog.setAmountFinal(isAmountFinal);
        rateCatalog.setKeyPairFinal(isKeyPairFinal);

        // Persisting RateCatalog's key pairs
        Set<KeyPair> keyPairSet = new HashSet<KeyPair>(keyPairs);
        if (CollectionUtils.isNotEmpty(keyPairSet)) {
            for (KeyPair keyPair : keyPairSet) {
                persistEntity(keyPair);
            }
            rateCatalog.setKeyPairs(keyPairSet);
        }

        // Persisting the new RateCatalog instance
        persistRateCatalog(rateCatalog);

        // Persisting ATP IDs
        Set<String> atpIdSet = new HashSet<String>(atpIds);
        if (CollectionUtils.isNotEmpty(atpIdSet)) {

            // Checking if there are other rate catalogs with the same code and any ATP IDs from the list
            Query query = em.createQuery("select 1 from RateCatalogAtp where id.code = :code and id.atpId in (:atpIds)");
            query.setParameter("code", rateCatalogCode);
            query.setParameter("atpIds", atpIdSet);
            query.setMaxResults(1);

            if (CollectionUtils.isNotEmpty(query.getResultList())) {
                String errMsg = "The same ATP IDs cannot be associated with the other rate catalogs with the same code";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }

            for (String atpId : atpIds) {
                // Checking if the ATP ID exists using AtpService
                if (!atpExists(atpId)) {
                    String errMsg = "ATP with ID = " + atpId + " does not exist";
                    logger.error(errMsg);
                    throw new IllegalArgumentException(errMsg);
                }

                // Creating a new instance of RateCatalogAtp and persisting the ATP ID
                RateCatalogAtp rateCatalogAtp = new RateCatalogAtp();
                rateCatalogAtp.setId(new RateCatalogAtpId(rateCatalogCode, atpId));
                rateCatalogAtp.setRateCatalog(rateCatalog);
                persistEntity(rateCatalogAtp);
            }
        }

        return rateCatalog;
    }


    /**
     * Persists RateCatalog in the database.
     *
     * @param rateCatalog RateCatalog instance
     * @return RateCatalog ID
     */
    @Override
    @Transactional(readOnly = false)
    public Long persistRateCatalog(RateCatalog rateCatalog) {

        PermissionUtils.checkPermission(Permission.UPDATE_RATE_CATALOG);

        if (!isRateCatalogValid(rateCatalog)) {
            String errMsg = "RateCatalog (code=" + rateCatalog.getCode() + ") is invalid";
            logger.error(errMsg);
            throw new InvalidRateCatalogException(errMsg);
        }

        return auditableEntityService.persistAuditableEntity(rateCatalog);
    }

    /**
     * Removes RateCatalog from the persistence store.
     *
     * @param rateCatalogId RateCatalog ID
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteRateCatalog(Long rateCatalogId) {

        PermissionUtils.checkPermission(Permission.DELETE_RATE_CATALOG);

        RateCatalog rateCatalog = getRateCatalog(rateCatalogId);

        if (rateCatalog == null) {
            String errMsg = "RateCatalog with ID = " + rateCatalogId + " does not exist";
            logger.error(errMsg);
            throw new InvalidRateCatalogException(errMsg);
        }

        rateCatalog.setKeyPairs(null);

        persistEntity(rateCatalog);

        Query query = em.createQuery("delete from RateCatalogAtp where rateCatalog.id = :rateCatalogId");
        query.setParameter("rateCatalogId", rateCatalogId);
        query.executeUpdate();

        auditableEntityService.deleteAuditableEntity(rateCatalogId, RateCatalog.class);
    }

    /**
     * Retrieves the RateCatalog instance specified by ID from the persistence store.
     *
     * @param rateCatalogId RateCatalog ID
     * @return RateCatalog instance
     */
    @Override
    public RateCatalog getRateCatalog(Long rateCatalogId) {
        PermissionUtils.checkPermission(Permission.READ_RATE_CATALOG);
        Query query = em.createQuery("select rc from RateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where rc.id = :id");
        query.setParameter("id", rateCatalogId);
        List<RateCatalog> results = query.getResultList();
        return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
    }

    /**
     * Retrieves the RateCatalog instance specified by Rate ID from the persistence store.
     *
     * @param rateId Rate ID
     * @return RateCatalog instance
     */
    @Override
    public RateCatalog getRateCatalogByRateId(Long rateId) {
        PermissionUtils.checkPermission(Permission.READ_RATE_CATALOG);
        Query query = em.createQuery("select rca.rateCatalog from RateCatalogAtp rca, Rate r " +
                " inner join fetch rca.rateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where rca.id = r.rateCatalogAtp.id and rate.id = :rateId");
        query.setParameter("rateId", rateId);
        List<RateCatalog> results = query.getResultList();
        return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
    }

    /**
     * Retrieves the RateCatalog instance specified by code and ATP ID from the persistence store.
     *
     * @param rateCatalogCode RateCatalog code
     * @param atpId           ATP ID
     * @return RateCatalog instance
     */
    @Override
    public RateCatalog getRateCatalogByCodeAndAtpId(String rateCatalogCode, String atpId) {
        PermissionUtils.checkPermission(Permission.READ_RATE_CATALOG);
        Query query = em.createQuery("select rca.rateCatalog from RateCatalogAtp rca " +
                " inner join fetch rca.rateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where rca.id = :id");
        query.setParameter("id", new RateCatalogAtpId(rateCatalogCode, atpId));
        List<RateCatalog> results = query.getResultList();
        return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
    }

    /**
     * Returns the list of rate catalogs by code.
     *
     * @param rateCatalogCode RateCatalog code
     * @return a list of RateCatalog instances
     */
    @Override
    public List<RateCatalog> getRateCatalogsByCode(String rateCatalogCode) {
        PermissionUtils.checkPermission(Permission.READ_RATE_CATALOG);
        Query query = em.createQuery("select rc from RateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where rc.code = :code");
        query.setParameter("code", rateCatalogCode);
        return query.getResultList();
    }

    /**
     * Returns the list of rate catalogs by ATP ID.
     *
     * @param atpId ATP ID
     * @return a list of RateCatalog instances
     */
    @Override
    public List<RateCatalog> getRateCatalogsByAtpId(String atpId) {
        PermissionUtils.checkPermission(Permission.READ_RATE_CATALOG);
        Query query = em.createQuery("select rca.rateCatalog from RateCatalogAtp rca " +
                " inner join fetch rca.rateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where rca.id.atpId = :atpId");
        query.setParameter("atpId", atpId);
        return query.getResultList();
    }

    protected RateCatalogAtp getRateCatalogAtp(String rateCatalogCode, String atpId) {
        PermissionUtils.checkPermission(Permission.READ_RATE_CATALOG);
        Query query = em.createQuery("select rca from RateCatalogAtp rca " +
                " inner join fetch rca.rateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where rca.id = :id");
        query.setParameter("id", new RateCatalogAtpId(rateCatalogCode, atpId));
        List<RateCatalogAtp> results = query.getResultList();
        return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
    }

    /**
     * Returns the list of rate catalogs by the given name pattern.
     *
     * @param namePattern Name pattern
     * @return a list of RateCatalog instances
     */
    @Override
    public List<RateCatalog> getRateCatalogsByNamePattern(String namePattern) {
        PermissionUtils.checkPermission(Permission.READ_RATE_CATALOG);
        Query query = em.createQuery("select rc from RateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where upper(rc.name) like upper(:namePattern)");
        query.setParameter("namePattern", "%" + namePattern + "%");
        return query.getResultList();
    }

    /**
     * Returns the list of all rate catalogs.
     *
     * @return a list of RateCatalog instances
     */
    @Override
    public List<RateCatalog> getAllRateCatalogs() {
        PermissionUtils.checkPermission(Permission.READ_RATE_CATALOG);
        Query query = em.createQuery("select rc from RateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " order by rc.id desc");
        return query.getResultList();
    }

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
    @Override
    @Transactional(readOnly = false)
    public Rate createRate(String rateCode,
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
                           boolean isAmountFinal) {

        PermissionUtils.checkPermission(Permission.CREATE_RATE);

        if (StringUtils.isBlank(rateCatalogCode)) {
            String errMsg = "RateCatalog code cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (StringUtils.isBlank(atpId)) {
            String errMsg = "ATP ID cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (!atpExists(atpId)) {
            String errMsg = "ATP ID = " + atpId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        RateCatalogAtp rateCatalogAtp = getRateCatalogAtp(rateCatalogCode, atpId);
        if (rateCatalogAtp == null || rateCatalogAtp.getRateCatalog() == null) {
            String errMsg = "RateCatalog does not exist with code = " + rateCatalogCode + " and ATP ID = " + atpId;
            logger.error(errMsg);
            throw new InvalidRateCatalogException(errMsg);
        }

        RateCatalog rateCatalog = rateCatalogAtp.getRateCatalog();

        if (isTransactionTypeFinal) {
            amountTransactionTypeId = transactionTypeId;
        }

        // Creating a new Rate instance
        Rate rate = new Rate();
        rate.setCode(rateCode);
        rate.setName(rateName);
        rate.setRateType(rateCatalog.getRateType());
        rate.setTransactionTypeId(transactionTypeId);
        rate.setRateCatalogAtp(rateCatalogAtp);
        rate.setAtpId(atpId);
        rate.setTransactionDate(transactionDate);
        rate.setTransactionDateType(transactionDateType);
        rate.setRecognitionDate(recognitionDate);
        rate.setCappedAmount(cappedAmount);

        rate.setAmountFinal(isAmountFinal);
        rate.setTransactionTypeFinal(isTransactionTypeFinal);

        // Creating a new RateAmount instance
        RateAmount rateAmount = new RateAmount();
        rateAmount.setAmount(defaultRateAmount);
        rateAmount.setTransactionTypeId(amountTransactionTypeId);
        rateAmount.setUnit(0);
        rateAmount.setUnitFraction(0);

        // Persisting RateAmount
        persistEntity(rateAmount);

        rate.setDefaultRateAmount(rateAmount);
        rate.setRateAmounts(new HashSet<RateAmount>(Arrays.asList(rateAmount)));

        // Copying the key pairs from RateCatalog
        Set<KeyPair> catalogKeyPairs = rateCatalog.getKeyPairs();
        if (CollectionUtils.isNotEmpty(catalogKeyPairs)) {
            Set<KeyPair> rateKeyPairs = new HashSet<KeyPair>(catalogKeyPairs.size());
            for (KeyPair keyPair : catalogKeyPairs) {
                // Making a KeyPair deep copy and make sure it is new (setting its ID to null)
                KeyPair keyPairCopy = BeanUtils.getDeepCopy(keyPair);
                keyPairCopy.setId(null);
                rateKeyPairs.add(keyPairCopy);
            }
            rate.setKeyPairs(rateKeyPairs);
        }

        // Validating the new rate with the rate catalog
        validateRateWithCatalog(rate, rateCatalog);

        // Persisting the new Rate instance
        auditableEntityService.persistAuditableEntity(rate);

        // Setting the persistent Rate reference in RateAmount
        rateAmount.setRate(rate);

        return rate;
    }

    /**
     * Persists the Rate instance in the database.
     *
     * @param rate Rate instance
     * @return Rate ID
     */
    @Override
    @Transactional(readOnly = false)
    public Long persistRate(Rate rate) {
        PermissionUtils.checkPermission(Permission.UPDATE_RATE);
        validateRate(rate);
        return persistEntity(rate);
    }

    /**
     * Removes Rate specified by ID from the persistence store
     *
     * @param rateId Rate ID
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteRate(Long rateId) {
        PermissionUtils.checkPermission(Permission.DELETE_RATE);
        deleteEntity(rateId, Rate.class);
    }

    /**
     * Retrieves the Rate instance from the database by ID.
     *
     * @param rateId Rate ID
     * @return Rate instance
     */
    @Override
    public Rate getRate(Long rateId) {
        PermissionUtils.checkPermission(Permission.READ_RATE);
        Query query = em.createQuery(GET_RATE_JOIN + " where r.id = :id");
        query.setParameter("id", rateId);
        List<Rate> rates = query.getResultList();
        return CollectionUtils.isNotEmpty(rates) ? rates.get(0) : null;
    }

    /**
     * Retrieves the Rate instance from the database by code and ATP ID.
     *
     * @param rateCode Rate code
     * @param atpId    ATP ID
     * @return Rate instance
     */
    @Override
    public Rate getRateByCodeAndAtpId(String rateCode, String atpId) {
        PermissionUtils.checkPermission(Permission.READ_RATE);
        Query query = em.createQuery(GET_RATE_JOIN + " where r.code = :rateCode and rca.id.atpId = :atpId");
        query.setParameter("rateCode", rateCode);
        query.setParameter("atpId", atpId);
        List<Rate> rates = query.getResultList();
        return CollectionUtils.isNotEmpty(rates) ? rates.get(0) : null;
    }

    /**
     * Returns the list of rates by code.
     *
     * @param rateCode Rate code
     * @return a list of Rate instances
     */
    @Override
    public List<Rate> getRatesByCode(String rateCode) {
        PermissionUtils.checkPermission(Permission.READ_RATE);
        Query query = em.createQuery(GET_RATE_JOIN + " where rca.id.code = :code");
        query.setParameter("code", rateCode);
        return query.getResultList();
    }

    /**
     * Returns the list of rates by ATP ID.
     *
     * @param atpId ATP ID
     * @return a list of Rate instances
     */
    @Override
    public List<Rate> getRatesByAtpId(String atpId) {
        PermissionUtils.checkPermission(Permission.READ_RATE);
        Query query = em.createQuery(GET_RATE_JOIN + " where rca.id.atpId = :atpId");
        query.setParameter("atpId", atpId);
        return query.getResultList();
    }

    /**
     * Returns the list of rates by RateCatalog ID.
     *
     * @param rateCatalogId Rate catalog ID
     * @return a list of Rate instances
     */
    @Override
    public List<Rate> getRatesByCatalogId(Long rateCatalogId) {
        PermissionUtils.checkPermission(Permission.READ_RATE);
        Query query = em.createQuery(GET_RATE_JOIN + " where rca.rateCatalog.id = :rateCatalogId");
        query.setParameter("rateCatalogId", rateCatalogId);
        return query.getResultList();
    }

    /**
     * Returns the list of rates by name pattern.
     *
     * @param namePattern Name pattern
     * @return a list of Rate instances
     */
    @Override
    public List<Rate> getRatesByNamePattern(String namePattern) {
        PermissionUtils.checkPermission(Permission.READ_RATE);
        Query query = em.createQuery(GET_RATE_JOIN + " where upper(r.name) like upper(:namePattern)");
        query.setParameter("namePattern", "%" + namePattern + "%");
        return query.getResultList();
    }

    /**
     * Returns the list of all rates.
     *
     * @return a list of Rate instances
     */
    @Override
    public List<Rate> getAllRates() {
        PermissionUtils.checkPermission(Permission.READ_RATE);
        Query query = em.createQuery(GET_RATE_JOIN + " order by r.id desc");
        return query.getResultList();
    }

    /**
     * Retrieves a set of ATP IDs for the rate catalog specified by ID.
     *
     * @param rateCatalogId RateCatalog ID
     * @return a set of ATP IDs
     */
    @Override
    public Set<String> getAtpsForRateCatalog(Long rateCatalogId) {
        Query query = em.createQuery("select rca.id.atpId from RateCatalogAtp rca where rca.rateCatalog.id = :id");
        query.setParameter("id", rateCatalogId);
        return new HashSet<String>(query.getResultList());
    }

    /**
     * Checks with the ATP service whether the given ATP ID exists in the system.
     *
     * @param atpId ATP ID to check
     * @return true if the ATP ID exists, false - otherwise
     */
    @Override
    public boolean atpExists(String atpId) {
        // Checking if the ATP ID exists using AtpService
        boolean atpExists;
        try {
            atpExists = atpService.getAtp(atpId, getAtpContextInfo()) != null;
        } catch (DoesNotExistException e) {
            logger.error(e.getMessage(), e);
            atpExists = false;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return atpExists;
    }


    // Additional methods

    /**
     * Validates the given RateType instance and throws <code>InvalidRateTypeException</code> if the validation fails.
     *
     * @param rateType RateType instance
     * @throws InvalidRateTypeException
     */
    @Override
    public void validateRateType(RateType rateType) throws InvalidRateTypeException {

        if (rateType == null) {
            String errMsg = "RateType cannot be null";
            logger.error(errMsg);
            throw new InvalidRateTypeException(errMsg);
        }

        if (StringUtils.isBlank(rateType.getCode())) {
            String errMsg = "RateType code is required";
            logger.error(errMsg);
            throw new InvalidRateTypeException(errMsg);
        }

        if (StringUtils.isBlank(rateType.getName())) {
            String errMsg = "RateType name is required";
            logger.error(errMsg);
            throw new InvalidRateTypeException(errMsg);
        }

    }

    /**
     * Validates the given Rate instance and throws <code>InvalidRateException</code> if the validation fails.
     *
     * @param rate Rate instance
     * @throws com.sigmasys.kuali.ksa.exception.InvalidRateException
     *
     */
    @Override
    public void validateRate(Rate rate) throws InvalidRateException {
        RateCatalogAtp rateCatalogAtp = rate.getRateCatalogAtp();
        validateRateWithCatalog(rate, (rateCatalogAtp != null) ? rateCatalogAtp.getRateCatalog() : null);
    }

    private ContextInfo getAtpContextInfo() {
        String userId = userSessionManager.getUserId(RequestUtils.getThreadRequest());
        ContextInfo contextInfo = new ContextInfo();
        contextInfo.setAuthenticatedPrincipalId(userId);
        contextInfo.setPrincipalId(userId);
        return contextInfo;
    }

    private boolean isTransactionTypeValid(String transactionTypeId, Date date) {
        boolean isTransactionTypeValid;
        try {
            isTransactionTypeValid =
                    transactionService.getTransactionType(transactionTypeId, date) != null;
        } catch (InvalidTransactionTypeException e) {
            isTransactionTypeValid = false;
        }
        return isTransactionTypeValid;
    }


    /**
     * Validates the given RateCatalog instance and throws <code>InvalidRateCatalogException</code> if the validation fails.
     *
     * @param rateCatalog RateCatalog instance
     * @throws com.sigmasys.kuali.ksa.exception.InvalidRateException
     *
     * @throws com.sigmasys.kuali.ksa.exception.InvalidRateCatalogException
     *
     */
    @Override
    public void validateRateCatalog(RateCatalog rateCatalog) throws InvalidRateException, InvalidRateCatalogException {

        if (rateCatalog == null) {
            String errMsg = "RateCatalog cannot be null";
            logger.error(errMsg);
            throw new InvalidRateCatalogException(errMsg);
        }

        RateType rateType = rateCatalog.getRateType();

        validateRateType(rateType);

        if (!rateTypeExists(rateType.getCode())) {
            String errMsg = "RateType does not exist with code = " + rateType.getCode();
            logger.error(errMsg);
            throw new InvalidRateTypeException(errMsg);
        }

        BigDecimal lowerBoundAmount = rateCatalog.getLowerBoundAmount();
        BigDecimal upperBoundAmount = rateCatalog.getUpperBoundAmount();

        if (lowerBoundAmount != null && upperBoundAmount != null) {
            if (lowerBoundAmount.compareTo(upperBoundAmount) > 0) {
                String errMsg = "Lower bound amount cannot be greater than upper bound amount";
                logger.error(errMsg);
                throw new InvalidRateCatalogException(errMsg);
            }
        }

        // If the rate catalog exists we have to check all the rates associated with it
        if (rateCatalog.getId() != null) {
            Query query = em.createQuery("select rate from Rate rate " +
                    "inner join rate.rateCatalogAtp rca " +
                    "inner join rca.rateCatalog rc " +
                    "where rc.id = :rateCatalogId");
            query.setParameter("rateCatalogId", rateCatalog.getId());
            List<Rate> rates = query.getResultList();
            if (CollectionUtils.isNotEmpty(rates)) {
                for (Rate rate : rates) {
                    validateRate(rate);
                }
            }
        }

    }

    /**
     * Validates the Rate against the RateCatalog instance
     * and throws <code>InvalidRateException</code> or <code>InvalidRateCatalogException</code> if the validation fails.
     *
     * @param rate        Rate instance
     * @param rateCatalog RateCatalog instance
     * @throws com.sigmasys.kuali.ksa.exception.InvalidRateException
     *
     */
    @Override
    public void validateRateWithCatalog(Rate rate, RateCatalog rateCatalog) throws InvalidRateException {

        if (rate == null) {
            String errMsg = "Rate cannot be null";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        if (StringUtils.isBlank(rate.getCode())) {
            String errMsg = "Rate code is required";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        if (StringUtils.isBlank(rate.getName())) {
            String errMsg = "Rate name is required";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        Set<RateAmount> rateAmounts = rate.getRateAmounts();

        if (CollectionUtils.isEmpty(rateAmounts)) {
            String errMsg = "Rate must have at least one RateAmount";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        RateAmount defaultRateAmount = rate.getDefaultRateAmount();
        if (defaultRateAmount == null) {
            String errMsg = "Rate must have the default RateAmount";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        boolean defaultAmountIsPresent = false;
        for (RateAmount rateAmount : rateAmounts) {
            if (rateAmount.getId() == null) {
                String errMsg = "RateAmount ID cannot be null";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }
            if (rateAmount.getUnit() == null) {
                String errMsg = "RateAmount unit cannot be null";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }
            if (rateAmount.getAmount() == null) {
                String errMsg = "RateAmount amount cannot be null";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }
            String transactionTypeId = rateAmount.getTransactionTypeId();
            if (transactionTypeId == null) {
                String errMsg = "RateAmount's transaction type cannot be null";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }
            if (rate.getTransactionDate() != null) {
                if (!isTransactionTypeValid(transactionTypeId, rate.getTransactionDate())) {
                    String errMsg = "RateAmount's transaction type is invalid";
                    logger.error(errMsg);
                    throw new InvalidRateException(errMsg);
                }
            } else {
                try {
                    Atp atp = atpService.getAtp(rate.getAtpId(), getAtpContextInfo());
                    if (!isTransactionTypeValid(transactionTypeId, atp.getStartDate()) ||
                            !isTransactionTypeValid(transactionTypeId, atp.getEndDate())) {
                        String errMsg = "RateAmount's transaction type is invalid";
                        logger.error(errMsg);
                        throw new InvalidRateException(errMsg);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    throw new IllegalStateException(e.getMessage(), e);
                }
            }
            if (!defaultAmountIsPresent && rateAmount.getId().equals(defaultRateAmount.getId())) {
                defaultAmountIsPresent = true;
            }
        }

        if (!defaultAmountIsPresent) {
            String errMsg = "Default RateAmount must be one of existing Rate's amounts";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        if (rate.getCappedAmount() != null && rate.getCappedAmount().compareTo(defaultRateAmount.getAmount()) < 0) {
            String errMsg = "Rate capped amount cannot be less than the default Rate amount";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (rate.getTransactionDateType() != null && rate.getTransactionDate() == null) {
            String errMsg = "Rate transaction date must not be null when transaction date type is set";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        if (rate.isTransactionTypeFinal() &&
                !defaultRateAmount.getTransactionTypeId().equals(rate.getTransactionTypeId())) {
            String errMsg = "Default RateAmount must have the same transaction type as Rate";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        if (rateCatalog != null) {

            BigDecimal lowerBoundAmount = rateCatalog.getLowerBoundAmount();
            BigDecimal upperBoundAmount = rateCatalog.getUpperBoundAmount();

            if (lowerBoundAmount != null && lowerBoundAmount.compareTo(defaultRateAmount.getAmount()) > 0) {
                String errMsg = "Default Rate amount cannot be less than the lower bound amount";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }

            if (upperBoundAmount != null && upperBoundAmount.compareTo(defaultRateAmount.getAmount()) < 0) {
                String errMsg = "Default Rate amount cannot be greater than the upper bound amount";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }

            if (rateCatalog.isTransactionTypeFinal() && !rate.isTransactionTypeFinal()) {
                String errMsg = "Rate's transaction type must be final as forced by RateCatalog";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }

            if (rateCatalog.isTransactionTypeFinal() &&
                    !rate.getTransactionTypeId().equals(rateCatalog.getTransactionTypeId())) {
                String errMsg = "Rate must have the same transaction type as RateCatalog";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }

            if (rateCatalog.isAmountFinal() && !rate.isAmountFinal()) {
                String errMsg = "Rate's amount must be final as dictated by RateCatalog";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }

            if (!rateCatalog.isRecognitionDateDefinable() && rate.getRecognitionDate() != null) {
                String errMsg = "Rate's recognition date is not definable and must not be set";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }

            Set<KeyPair> catalogKeyPairs = rateCatalog.getKeyPairs();

            if (CollectionUtils.isNotEmpty(catalogKeyPairs)) {

                Set<KeyPair> rateKeyPairs = rate.getKeyPairs();

                if (CollectionUtils.isEmpty(rateKeyPairs)) {
                    String errMsg = "Rate's set of key pairs cannot be empty";
                    logger.error(errMsg);
                    throw new InvalidRateException(errMsg);
                }

                if (!rateKeyPairs.containsAll(catalogKeyPairs)) {
                    String errMsg = "Rate's set of key pairs must be a sub-collection of RateCatalog's set of key pairs";
                    logger.error(errMsg);
                    throw new InvalidRateException(errMsg);
                }

                if (rateCatalog.isKeyPairFinal() && catalogKeyPairs.size() != rateKeyPairs.size()) {
                    String errMsg = "Rate's and RateCatalog's sets of key pairs must be the same";
                    logger.error(errMsg);
                    throw new InvalidRateException(errMsg);
                }

            }

        }
    }


    /**
     * Checks if the rate type is valid.
     *
     * @param rateType RateType instance
     * @return true if the rate is valid, otherwise false
     */
    @Override
    public boolean isRateTypeValid(RateType rateType) {
        try {
            validateRateType(rateType);
            return true;
        } catch (InvalidRateTypeException e) {
            return false;
        }
    }


    /**
     * Checks if the rate is valid.
     *
     * @param rate Rate instance
     * @return true if the rate is valid, otherwise false
     */
    @Override
    public boolean isRateValid(Rate rate) {
        try {
            validateRate(rate);
            return true;
        } catch (InvalidRateException e) {
            return false;
        }
    }

    /**
     * Checks if the rate catalog is valid.
     *
     * @param rateCatalog RateCatalog instance
     * @return true if the rate catalog is valid, otherwise false
     */
    @Override
    public boolean isRateCatalogValid(RateCatalog rateCatalog) {
        try {
            validateRateCatalog(rateCatalog);
            return true;
        } catch (InvalidRateException e) {
            return false;
        } catch (InvalidRateCatalogException ce) {
            return false;
        }
    }

    /**
     * Checks if the rate is valid for the given rate catalog.
     *
     * @param rate        Rate instance
     * @param rateCatalog RateCatalog instance
     * @return true if the rate is valid, otherwise false
     */
    @Override
    public boolean isRateValidWithCatalog(Rate rate, RateCatalog rateCatalog) {
        try {
            validateRateWithCatalog(rate, rateCatalog);
            return true;
        } catch (InvalidRateException e) {
            return false;
        } catch (InvalidRateCatalogException ce) {
            return false;
        }
    }

    /**
     * Assigns the array of ATP IDs to the rate catalog specified by ID.
     *
     * @param rateCatalogId RateCatalog ID
     * @param atpIds        Array of ATP IDs
     * @return RateCatalog instance
     */
    @Override
    @Transactional(readOnly = false)
    public RateCatalog assignAtpsToRateCatalog(Long rateCatalogId, String... atpIds) {

        // Trying to remove ATPs from the rate catalog first
        RateCatalog rateCatalog = removeAtpsToRateCatalog(rateCatalogId, atpIds);

        // Creating new RateCatalogAtp entities
        for (String atpId : atpIds) {
            RateCatalogAtp rateCatalogAtp = new RateCatalogAtp();
            rateCatalogAtp.setId(new RateCatalogAtpId(rateCatalog.getCode(), atpId));
            rateCatalogAtp.setRateCatalog(rateCatalog);
            persistEntity(rateCatalogAtp);
        }

        return rateCatalog;
    }


    /**
     * Adds new and/or transfer the existing array of ATP IDs
     * from another rate catalog (if other rate catalogs use them) the to the rate catalog specified by ID.
     *
     * @param rateCatalogId RateCatalog ID
     * @param atpIds        Array of ATP IDs
     * @return RateCatalog instance
     */
    @Override
    @Transactional(readOnly = false)
    public RateCatalog transferAtpsToRateCatalog(Long rateCatalogId, String... atpIds) {

        PermissionUtils.checkPermission(Permission.UPDATE_RATE_CATALOG, Permission.UPDATE_RATE);

        RateCatalog rateCatalog = getRateCatalog(rateCatalogId);

        if (rateCatalog == null) {
            String errMsg = "RateCatalog with ID = " + rateCatalogId + " does not exist";
            logger.error(errMsg);
            throw new InvalidRateCatalogException(errMsg);
        }

        Set<String> newAtpIds = new HashSet<String>(Arrays.asList(atpIds));

        // Retrieving rates by RateCatalog code and ATP IDs
        Query query = em.createQuery("select r from Rate r where r.rateCatalogAtp.id.code = :code and " +
                " r.rateCatalogAtp.id.atpId in (:atpIds) and r.rateCatalogAtp.rateCatalog.id <> :id");
        query.setParameter("code", rateCatalog.getCode());
        query.setParameter("atpIds", newAtpIds);
        query.setParameter("id", rateCatalog.getId());

        List<Rate> rates = query.getResultList();

        // Validating each rate with the rate catalog
        if (CollectionUtils.isNotEmpty(rates)) {
            for (Rate rate : rates) {
                validateRateWithCatalog(rate, rateCatalog);
            }
        }

        // Retrieving the existing ATP IDs and merge them with the new ones
        Set<String> oldAtpIds = getAtpsForRateCatalog(rateCatalog.getId());
        if (CollectionUtils.isNotEmpty(oldAtpIds)) {
            newAtpIds.addAll(oldAtpIds);
            // Removing the old ATP IDs from RateCatalogAtp by the rate catalog ID
            query = em.createQuery("delete from RateCatalogAtp where rateCatalogAtp.rateCatalog.id = :id");
            query.setParameter("id", rateCatalog.getId());
            query.executeUpdate();
        }

        // Creating and persisting the new RateCatalogAtp instances the ATP IDs and rate catalog ID
        for (String atpId : newAtpIds) {
            RateCatalogAtp rateCatalogAtp = new RateCatalogAtp();
            rateCatalogAtp.setId(new RateCatalogAtpId(rateCatalog.getCode(), atpId));
            rateCatalogAtp.setRateCatalog(rateCatalog);
            persistEntity(rateCatalogAtp);
        }

        return rateCatalog;
    }

    /**
     * Remove the ATP IDs from the rate catalog specified by ID.
     *
     * @param rateCatalogId RateCatalog ID
     * @param atpIds        Array of ATP IDs to be removed
     * @return RateCatalog instance
     */
    @Override
    @Transactional(readOnly = false)
    public RateCatalog removeAtpsToRateCatalog(Long rateCatalogId, String... atpIds) {

        PermissionUtils.checkPermission(Permission.UPDATE_RATE_CATALOG);

        RateCatalog rateCatalog = getRateCatalog(rateCatalogId);

        if (rateCatalog == null) {
            String errMsg = "RateCatalog with ID = " + rateCatalogId + " does not exist";
            logger.error(errMsg);
            throw new InvalidRateCatalogException(errMsg);
        }

        // Checking if there are any rates that use these ATPs
        Query query = em.createQuery("select 1 from Rate where rateCatalogAtp.id.code = :code and " +
                " rateCatalogAtp.id.atpId in (:atpIds)");
        query.setParameter("code", rateCatalog.getCode());
        query.setParameter("atpIds", Arrays.asList(atpIds));
        query.setMaxResults(1);

        if (CollectionUtils.isNotEmpty(query.getResultList())) {
            String errMsg = "Cannot assign ATPs to a rate catalog with code '" + rateCatalog.getCode() +
                    "' because they are being used by other rates";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        // Removing ATPs from rate catalogs with the same code
        query = em.createQuery("delete from RateCatalogAtp where id.code = :code and id.atpId in (:atpIds)");
        query.setParameter("code", rateCatalog.getCode());
        query.setParameter("atpIds", Arrays.asList(atpIds));
        query.executeUpdate();

        return rateCatalog;
    }


    /**
     * Adds a new key pair to the rate catalog specified by ID.
     *
     * @param key           KeyPair key
     * @param value         KeyPair value
     * @param rateCatalogId RateCatalog ID
     * @return RateCatalog instance
     */
    @Override
    @Transactional(readOnly = false)
    public RateCatalog addKeyPairToRateCatalog(String key, String value, Long rateCatalogId) {

        PermissionUtils.checkPermission(Permission.UPDATE_RATE_CATALOG);

        RateCatalog rateCatalog = getRateCatalog(rateCatalogId);

        if (rateCatalog == null) {
            String errMsg = "RateCatalog with ID = " + rateCatalogId + " does not exist";
            logger.error(errMsg);
            throw new InvalidRateCatalogException(errMsg);
        }

        KeyPair newKeyPair = new KeyPair(key, value);

        Set<KeyPair> catalogKeyPairs = rateCatalog.getKeyPairs();

        persistEntity(newKeyPair);

        if (catalogKeyPairs == null) {
            catalogKeyPairs = new HashSet<KeyPair>();
        }

        catalogKeyPairs.add(newKeyPair);

        rateCatalog.setKeyPairs(catalogKeyPairs);

        // Adding the key pair to all dependent rates
        List<Rate> rates = getRatesByCatalogId(rateCatalogId);
        if (CollectionUtils.isNotEmpty(rates)) {
            for (Rate rate : rates) {
                addKeyPairToRate(key, value, rate.getId(), false);
            }
        }

        return rateCatalog;
    }

    /**
     * Removes the key pair from the rate catalog specified by ID.
     *
     * @param key           KeyPair key
     * @param rateCatalogId RateCatalog ID
     * @return RateCatalog instance
     */
    @Override
    @Transactional(readOnly = false)
    public RateCatalog removeKeyPairFromRateCatalog(String key, Long rateCatalogId) {

        PermissionUtils.checkPermission(Permission.UPDATE_RATE_CATALOG);

        RateCatalog rateCatalog = getRateCatalog(rateCatalogId);

        if (rateCatalog == null) {
            String errMsg = "RateCatalog with ID = " + rateCatalogId + " does not exist";
            logger.error(errMsg);
            throw new InvalidRateCatalogException(errMsg);
        }

        Set<KeyPair> catalogKeyPairs = rateCatalog.getKeyPairs();

        if (CollectionUtils.isNotEmpty(catalogKeyPairs)) {
            for (KeyPair keyPair : new HashSet<KeyPair>(catalogKeyPairs)) {
                if (keyPair.getKey().equals(key)) {
                    catalogKeyPairs.remove(keyPair);
                    deleteEntity(keyPair.getId(), KeyPair.class);
                }
            }
        }

        // Removing the key pair from all dependent rates
        List<Rate> rates = getRatesByCatalogId(rateCatalogId);
        if (CollectionUtils.isNotEmpty(rates)) {
            for (Rate rate : rates) {
                removeKeyPairFromRate(key, rate.getId(), false);
            }
        }

        return rateCatalog;
    }

    protected Rate addKeyPairToRate(String key, String value, Long rateId, boolean checkRestrictions) {

        PermissionUtils.checkPermission(Permission.UPDATE_RATE);

        if (checkRestrictions) {

            RateCatalog rateCatalog = getRateCatalogByRateId(rateId);
            if (rateCatalog == null) {
                String errMsg = "Rate (ID=" + rateId + ") is not associated with any RateCatalog";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }

            if (rateCatalog.isKeyPairFinal()) {
                String errMsg = "Rate's set of key pairs cannot be modified";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }
        }

        Rate rate = getRate(rateId);

        if (rate == null) {
            String errMsg = "Rate with ID = " + rateId + " does not exist";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        KeyPair newKeyPair = new KeyPair(key, value);

        Set<KeyPair> rateKeyPairs = rate.getKeyPairs();

        persistEntity(newKeyPair);

        if (rateKeyPairs == null) {
            rateKeyPairs = new HashSet<KeyPair>();
        }

        rateKeyPairs.add(newKeyPair);

        rate.setKeyPairs(rateKeyPairs);

        return rate;

    }

    protected Rate removeKeyPairFromRate(String key, Long rateId, boolean checkRestrictions) {

        PermissionUtils.checkPermission(Permission.UPDATE_RATE);

        Rate rate = getRate(rateId);

        if (rate == null) {
            String errMsg = "Rate with ID = " + rateId + " does not exist";
            logger.error(errMsg);
            throw new InvalidRateException(errMsg);
        }

        Set<KeyPair> rateKeyPairs = rate.getKeyPairs();

        boolean keyPairExists = false;
        if (CollectionUtils.isNotEmpty(rateKeyPairs)) {
            for (KeyPair keyPair : new HashSet<KeyPair>(rateKeyPairs)) {
                if (keyPair.getKey().equals(key)) {
                    rateKeyPairs.remove(keyPair);
                    if (!keyPairExists) {
                        keyPairExists = true;
                    }
                }
            }
        }

        if (checkRestrictions) {

            if (!keyPairExists) {
                String errMsg = "KeyPair (key=" + key + ") does not exist in Rate (ID=" + rateId + ")";
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
            }

            RateCatalog rateCatalog = getRateCatalogByRateId(rateId);
            if (rateCatalog == null) {
                String errMsg = "Rate (ID=" + rateId + ") is not associated with any RateCatalog";
                logger.error(errMsg);
                throw new InvalidRateException(errMsg);
            }

            if (rateCatalog.isKeyPairFinal()) {
                String errMsg = "Rate's set of key pairs cannot be modified";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }
        }

        return rate;
    }

    /**
     * Adds a new key pair to the rate specified by ID.
     *
     * @param key    KeyPair key
     * @param value  KeyPair value
     * @param rateId Rate ID
     * @return Rate instance
     */
    @Override
    @Transactional(readOnly = false)
    public Rate addKeyPairToRate(String key, String value, Long rateId) {
        return addKeyPairToRate(key, value, rateId, true);
    }

    /**
     * Removes the key pair from the rate specified by ID.
     *
     * @param key    KeyPair key
     * @param rateId Rate ID
     * @return Rate instance
     */
    @Override
    @Transactional(readOnly = false)
    public Rate removeKeyPairFromRate(String key, Long rateId) {
        return removeKeyPairFromRate(key, rateId, true);
    }

}
