package com.sigmasys.kuali.ksa.service.fm.impl;

import com.sigmasys.kuali.ksa.exception.InvalidRateTypeException;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.fm.Rate;
import com.sigmasys.kuali.ksa.model.fm.RateCatalog;
import com.sigmasys.kuali.ksa.model.fm.RateCatalogAtpId;
import com.sigmasys.kuali.ksa.model.fm.RateType;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.fm.RateService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
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
import java.util.List;

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


    @Autowired
    private AuditableEntityService auditableEntityService;


    protected void validateRateType(RateType rateType) {

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
        PermissionUtils.checkPermission(Permission.VIEW_RATE_TYPE);
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
        PermissionUtils.checkPermission(Permission.VIEW_RATE_TYPE);
        return auditableEntityService.getAuditableEntity(rateTypeCode, RateType.class);
    }

    /**
     * Returns the list of rate types by the given name pattern.
     *
     * @param namePattern Name pattern
     * @return a list of RateType instances
     */
    @Override
    public List<RateType> getRateTypesByNamePattern(String namePattern) {
        PermissionUtils.checkPermission(Permission.VIEW_RATE_TYPE);
        return auditableEntityService.getAuditableEntitiesByNamePattern(namePattern, RateType.class);
    }

    /**
     * Returns the list of all rate types.
     *
     * @return a list of RateType instances
     */
    @Override
    public List<RateType> getAllRateTypes() {
        PermissionUtils.checkPermission(Permission.VIEW_RATE_TYPE);
        return auditableEntityService.getAuditableEntities(RateType.class);
    }

    // Rate Catalog methods

    /**
     * Creates and persists a new RateCatalog instance.
     *
     * @param rateCatalog RateCatalog instance
     * @return RateCatalog instance with the new ID
     */
    @Override
    @Transactional(readOnly = false)
    public RateCatalog createRateCatalog(RateCatalog rateCatalog) {
        PermissionUtils.checkPermission(Permission.CREATE_RATE_CATALOG);
        auditableEntityService.persistAuditableEntity(rateCatalog);
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
        PermissionUtils.checkPermission(Permission.VIEW_RATE_CATALOG);
        Query query = em.createQuery("select rc from RateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where rc.id = :id");
        query.setParameter("id", rateCatalogId);
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
        PermissionUtils.checkPermission(Permission.VIEW_RATE_CATALOG);
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
        PermissionUtils.checkPermission(Permission.VIEW_RATE_CATALOG);
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
        PermissionUtils.checkPermission(Permission.VIEW_RATE_CATALOG);
        Query query = em.createQuery("select rca.rateCatalog from RateCatalogAtp rca " +
                " inner join fetch rca.rateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where rca.id.atpId = :atpId");
        query.setParameter("atpId", atpId);
        return query.getResultList();
    }

    /**
     * Returns the list of rate catalogs by the given name pattern.
     *
     * @param namePattern Name pattern
     * @return a list of RateCatalog instances
     */
    @Override
    public List<RateCatalog> getRateCatalogsByNamePattern(String namePattern) {
        PermissionUtils.checkPermission(Permission.VIEW_RATE_CATALOG);
        Query query = em.createQuery("select rc from RateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " where upper(rc.name) like upper (:namePattern)");
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
        PermissionUtils.checkPermission(Permission.VIEW_RATE_CATALOG);
        Query query = em.createQuery("select rc from RateCatalog rc " +
                " left outer join fetch rc.rateType rt " +
                " left outer join fetch rc.keyPairs kp " +
                " order by rc.id desc");
        return query.getResultList();
    }

    // Rate methods

    /**
     * Creates a new Rate instance and persists it in the database.
     *
     * @param rate Rate instance
     * @return Rate instance with the new ID
     */
    @Override
    @Transactional(readOnly = false)
    public Rate createRate(Rate rate) {

        PermissionUtils.checkPermission(Permission.CREATE_RATE);

        // TODO

        return null;
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

        // TODO

        return null;
    }

    /**
     * Removes Rate specified by ID from the persistence store
     *
     * @param rateId Rate ID
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteRate(Long rateId) {
        // TODO
    }

    /**
     * Retrieves the Rate instance from the database by ID.
     *
     * @param rateId Rate ID
     * @return Rate instance
     */
    @Override
    public Rate getRate(Long rateId) {
        // TODO
        return null;
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
        // TODO
        return null;
    }

    /**
     * Returns the list of rates by code.
     *
     * @param rateCode Rate code
     * @return a list of Rate instances
     */
    @Override
    public List<Rate> getRatesByCode(String rateCode) {
        // TODO
        return null;
    }

    /**
     * Returns the list of rates by ATP ID.
     *
     * @param atpId ATP ID
     * @return a list of Rate instances
     */
    @Override
    public List<Rate> getRatesByAtpId(String atpId) {
        // TODO
        return null;
    }

    /**
     * Returns the list of rates by name pattern.
     *
     * @param namePattern Name pattern
     * @return a list of Rate instances
     */
    @Override
    public List<Rate> getRatesByNamePattern(String namePattern) {
        // TODO
        return null;
    }

    /**
     * Returns the list of all rates.
     *
     * @return a list of Rate instances
     */
    @Override
    public List<Rate> getAllRates() {
        // TODO
        return null;
    }

    // Additional methods

    /**
     * Checks if the rate is valid.
     *
     * @param rate Rate instance
     * @return true if the rate is valid, otherwise false
     */
    @Override
    public boolean isRateValid(Rate rate) {
        // TODO
        return false;
    }

    /**
     * Checks if the rate catalog is valid.
     *
     * @param rateCatalog RateCatalog instance
     * @return true if the rate catalog is valid, otherwise false
     */
    @Override
    public boolean isRateCatalogValid(RateCatalog rateCatalog) {
        // TODO
        return false;
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
        // TODO
        return false;
    }

    /**
     * Assigns the ATP ID to the rate catalog specified by ID.
     *
     * @param atpId         ATP ID
     * @param rateCatalogId RateCatalog ID
     * @return RateCatalog instance
     */
    @Override
    @Transactional(readOnly = false)
    public RateCatalog assignAtpToRateCatalog(String atpId, Long rateCatalogId) {
        // TODO
        return null;
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
        // TODO
        return null;
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
        // TODO
        return null;
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
        // TODO
        return null;
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
        // TODO
        return null;
    }

}
