package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.exception.ConfigurationException;
import com.sigmasys.kuali.ksa.exception.InformationNotFoundException;
import com.sigmasys.kuali.ksa.exception.TransactionNotFoundException;
import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.util.RequestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Information service JPA implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("informationService")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class InformationServiceImpl extends GenericPersistenceService implements InformationService {


    private static final Log logger = LogFactory.getLog(InformationServiceImpl.class);

    private static final String GET_INFORMATION_JOIN =
            " left outer join fetch i.account a " +
                    " left outer join fetch i.accessLevel al " +
                    " left outer join fetch i.transaction t ";


    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuditableEntityService auditableEntityService;


    private <T extends Information> T getInformation(Long id, Class<T> entityType) {

        Query query = em.createQuery("select i from " + entityType.getName() + " i " + GET_INFORMATION_JOIN +
                " where i.id = :id ");

        query.setParameter("id", id);

        List<T> transactions = query.getResultList();

        return CollectionUtils.isNotEmpty(transactions) ? transactions.get(0) : null;
    }

    private <T extends Information> List<T> getInformations(String userId, Class<T> entityType) {

        Query query = em.createQuery("select i from " + entityType.getName() + " i " + GET_INFORMATION_JOIN +
                (userId != null ? " where a.id = :userId " : "") +
                " order by i.creationDate desc, i.effectiveDate");

        if (userId != null) {
            query.setParameter("userId", userId);
        }

        return query.getResultList();
    }


    /**
     * Returns Information by ID
     *
     * @param id Information ID
     * @return Information instance
     */
    @Override
    public Information getInformation(Long id) {
        return getInformation(id, Information.class);
    }

    /**
     * Returns Memo by ID
     *
     * @param id Memo ID
     * @return Memo instance
     */
    @Override
    public Memo getMemo(Long id) {
        return getInformation(id, Memo.class);
    }

    /**
     * Returns Alert by ID
     *
     * @param id Alert ID
     * @return Alert instance
     */
    @Override
    public Alert getAlert(Long id) {
        return getInformation(id, Alert.class);
    }

    /**
     * Returns Flag by ID
     *
     * @param id Flag ID
     * @return Flag instance
     */
    @Override
    public Flag getFlag(Long id) {
        return getInformation(id, Flag.class);
    }


    /**
     * Returns all Information instances sorted by ID in the descendant order
     *
     * @return List of Information instances
     */
    @Override
    public List<Information> getInformations() {
        return getInformations(null, Information.class);
    }

    /**
     * Returns all Memo entities sorted by ID in the descendant order
     *
     * @return List of memos
     */
    @Override
    public List<Memo> getMemos() {
        return getInformations(null, Memo.class);
    }

    /**
     * Returns all Flag entities sorted by ID in the descendant order
     *
     * @return List of flags
     */
    public List<Flag> getFlags() {
        return getInformations(null, Flag.class);
    }

    /**
     * Returns all Alert entities sorted by ID in the descendant order
     *
     * @return List of alerts
     */
    public List<Alert> getAlerts() {
        return getInformations(null, Alert.class);
    }

    /**
     * Returns all Alert entities by Account ID
     *
     * @param userId Account ID
     * @return List of memos
     */
    @Override
    public List<Alert> getAlerts(String userId) {
        return getInformations(userId, Alert.class);
    }

    /**
     * Returns all Flag entities by Account ID
     *
     * @param userId Account ID
     * @return List of flags
     */
    @Override
    public List<Flag> getFlags(String userId) {
        return getInformations(userId, Flag.class);
    }

    /**
     * Returns all Memo entities by Account ID
     *
     * @param userId Account ID
     * @return List of memos
     */
    @Override
    public List<Memo> getMemos(String userId) {
        return getInformations(userId, Memo.class);
    }

    /**
     * Returns all Memo entities by Transaction ID
     *
     * @param transactionId Transaction ID
     * @return List of memos for the given transaction
     */
    @Override
    public List<Memo> getMemos(Long transactionId) {
        Query query = em.createQuery("select i from Memo i " + GET_INFORMATION_JOIN +
                " left outer join fetch i.nextMemo nm " +
                " left outer join fetch i.previousMemo pm " +
                " where i.transaction.id = :transactionId order by " +
                " i.creationDate desc, i.effectiveDate desc");
        query.setParameter("transactionId", transactionId);
        return query.getResultList();
    }

    /**
     * Persists Information in the database.
     * Creates a new entity when ID is null and updates the existing one otherwise.
     *
     * @param information Information instance
     * @return Information ID
     */
    @Override
    @Transactional(readOnly = false)
    public Long persistInformation(Information information) {
        String userId = userSessionManager.getUserId(RequestUtils.getThreadRequest());
        Date currentDate = new Date();
        if (information.getId() != null) {
            information.setEditorId(userId);
            information.setLastUpdate(currentDate);
        } else {
            information.setCreatorId(userId);
            information.setCreationDate(currentDate);
        }
        return persistEntity(information);
    }

    /**
     * Removes Information from the database.
     *
     * @param id Information ID
     * @return true if Information entity has been deleted
     */
    @Override
    @Transactional(readOnly = false)
    public boolean deleteInformation(Long id) {
        return deleteEntity(id, Information.class);
    }

    /**
     * Creates a new memo based on the given parameters
     *
     * @param transactionId   Transaction ID
     * @param memoText        Memo text
     * @param accessLevelCode InformationAccessLevel code
     * @param effectiveDate   Effective date
     * @param expirationDate  Expiration date
     * @param prevMemoId      Previous Memo ID    @return new Memo instance
     */
    @Override
    @Transactional(readOnly = false)
    public Memo createMemo(Long transactionId, String memoText, String accessLevelCode,
                           Date effectiveDate, Date expirationDate, Long prevMemoId) {

        Transaction transaction = transactionService.getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Memo memo = createMemo(transaction.getAccount().getId(), memoText, accessLevelCode,
                effectiveDate, expirationDate, prevMemoId);

        memo.setTransaction(transaction);

        return memo;

    }

    /**
     * Creates a new memo based on the given parameters
     *
     * @param accountId       Account ID
     * @param memoText        Memo text
     * @param accessLevelCode InformationAccessLevel code
     * @param effectiveDate   Effective date
     * @param expirationDate  Expiration date
     * @param prevMemoId      Previous Memo ID    @return new Memo instance
     */
    @Override
    @Transactional(readOnly = false)
    public Memo createMemo(String accountId, String memoText, String accessLevelCode,
                           Date effectiveDate, Date expirationDate, Long prevMemoId) {

        if (accountId == null) {
            String errMsg = "Account ID cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Account account = accountService.getFullAccount(accountId);
        if (account == null) {
            String errMsg = "Account with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        InformationAccessLevel accessLevel = getInformationAccessLevel(accessLevelCode);
        if (accessLevel == null) {
            String errMsg = "InformationAccessLevel with code = " + accessLevelCode + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Memo newMemo = new Memo();
        newMemo.setText(memoText);
        newMemo.setAccount(account);
        newMemo.setAccessLevel(accessLevel);

        Memo prevMemo = null;
        if (prevMemoId != null) {
            prevMemo = getMemo(prevMemoId);
            if (prevMemo == null) {
                String errMsg = "Memo with ID = " + prevMemoId + " does not exist";
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
            }
            newMemo.setPreviousMemo(prevMemo);
            prevMemo.setNextMemo(newMemo);
        }

        String creatorId = userSessionManager.getUserId(RequestUtils.getThreadRequest());
        newMemo.setCreatorId(creatorId);

        Date curDate = new Date();
        newMemo.setCreationDate(curDate);
        newMemo.setEffectiveDate(effectiveDate != null ? effectiveDate : curDate);
        newMemo.setExpirationDate(expirationDate);

        persistEntity(newMemo);

        if (prevMemo != null) {
            prevMemo.setNextMemo(newMemo);
        }

        return newMemo;
    }

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
    @Override
    @Transactional(readOnly = false)
    public Flag createFlag(Long transactionId, Long flagTypeId, String accessLevelCode,
                           Integer severity, Date effectiveDate, Date expirationDate) {

        Transaction transaction = transactionService.getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Flag flag = createFlag(transaction.getAccount().getId(), flagTypeId, accessLevelCode, severity,
                effectiveDate, expirationDate);

        flag.setTransaction(transaction);

        return flag;

    }

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
    @Override
    @Transactional(readOnly = false)
    public Flag createFlag(String accountId, Long flagTypeId, String accessLevelCode,
                           Integer severity, Date effectiveDate, Date expirationDate) {

        if (accountId == null) {
            String errMsg = "Account ID cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Account account = accountService.getFullAccount(accountId);
        if (account == null) {
            String errMsg = "Account with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        FlagType flagType = getEntity(flagTypeId, FlagType.class);
        if (flagType == null) {
            String errMsg = "FlagType with ID = " + flagTypeId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        InformationAccessLevel accessLevel = getInformationAccessLevel(accessLevelCode);
        if (accessLevel == null) {
            String errMsg = "InformationAccessLevel with code = " + accessLevelCode + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Flag flag = new Flag();
        flag.setType(flagType);
        flag.setAccount(account);
        flag.setAccessLevel(accessLevel);
        flag.setSeverity(severity);

        String creatorId = userSessionManager.getUserId(RequestUtils.getThreadRequest());
        flag.setCreatorId(creatorId);

        Date curDate = new Date();
        flag.setCreationDate(curDate);
        flag.setEffectiveDate(effectiveDate != null ? effectiveDate : curDate);
        flag.setExpirationDate(expirationDate);

        persistEntity(flag);

        return flag;
    }


    /**
     * Creates a new alert based on the given parameters
     *
     * @param transactionId   Transaction ID
     * @param alertText       Alert text
     * @param accessLevelCode InformationAccessLevel code
     * @param effectiveDate   Effective date
     * @param expirationDate  Expiration date   @return new Alert instance
     */
    @Override
    @Transactional(readOnly = false)
    public Alert createAlert(Long transactionId, String alertText, String accessLevelCode, Date effectiveDate,
                             Date expirationDate) {

        Transaction transaction = transactionService.getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Alert alert = createAlert(transaction.getAccount().getId(), alertText, accessLevelCode,
                effectiveDate, expirationDate);

        alert.setTransaction(transaction);

        return alert;

    }

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
    @Override
    @Transactional(readOnly = false)
    public Alert createAlert(String accountId, String alertText, String accessLevelCode, Date effectiveDate,
                             Date expirationDate) {

        if (accountId == null) {
            String errMsg = "Account ID cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Account account = accountService.getFullAccount(accountId);
        if (account == null) {
            String errMsg = "Account with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        InformationAccessLevel accessLevel = getInformationAccessLevel(accessLevelCode);
        if (accessLevel == null) {
            String errMsg = "InformationAccessLevel with code = " + accessLevelCode + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Alert alert = new Alert();
        alert.setText(alertText);
        alert.setAccount(account);
        alert.setAccessLevel(accessLevel);

        String creatorId = userSessionManager.getUserId(RequestUtils.getThreadRequest());
        alert.setCreatorId(creatorId);

        Date curDate = new Date();
        alert.setCreationDate(curDate);
        alert.setEffectiveDate(effectiveDate != null ? effectiveDate : curDate);
        alert.setExpirationDate(expirationDate);

        persistEntity(alert);

        return alert;
    }


    /**
     * Returns the default Memo's InformationAccessLevel code.
     *
     * @return InformationAccessLevel code
     */
    @Override
    public String getDefaultMemoLevel() {
        String defaultMemoLevel = configService.getParameter(Constants.DEFAULT_MEMO_LEVEL);
        if (StringUtils.isBlank(defaultMemoLevel)) {
            String errMsg = "Configuration parameter '" + Constants.DEFAULT_MEMO_LEVEL + "' is required";
            logger.error(errMsg);
            throw new ConfigurationException(errMsg);
        }
        return defaultMemoLevel;
    }

    /**
     * Associates the information represented by Information ID with the given Account ID
     *
     * @param informationId Information ID
     * @param accountId     Account ID
     * @return an updated instance of Information
     */
    @Override
    @Transactional(readOnly = false)
    public Information associateWithAccount(Long informationId, String accountId) {

        Information information = getInformation(informationId);
        if (information == null) {
            String errMsg = "Information with ID = " + informationId + " does not exist";
            logger.error(errMsg);
            throw new InformationNotFoundException(errMsg);
        }

        Account account = accountService.getFullAccount(accountId);
        if (account == null) {
            String errMsg = "Account with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        information.setAccount(account);

        return information;

    }

    /**
     * Associates the information represented by Information ID with the Transaction specified by ID
     *
     * @param informationId Information ID
     * @param transactionId Transaction ID
     * @return an updated instance of Information
     */
    @Override
    @Transactional(readOnly = false)
    public Information associateWithTransaction(Long informationId, Long transactionId) {

        Information information = getInformation(informationId);
        if (information == null) {
            String errMsg = "Information with ID = " + informationId + " does not exist";
            logger.error(errMsg);
            throw new InformationNotFoundException(errMsg);
        }

        Transaction transaction = transactionService.getTransaction(transactionId);
        if (transaction == null) {
            String errMsg = "Transaction with ID = " + transactionId + " does not exist";
            logger.error(errMsg);
            throw new TransactionNotFoundException(errMsg);
        }

        information.setTransaction(transaction);

        return information;
    }


    /**
     * Returns InformationAccessLevel instance by code.
     *
     * @param code InformationAccessLevel code
     * @return InformationAccessLevel instance
     */
    @Override
    public InformationAccessLevel getInformationAccessLevel(String code) {
        return auditableEntityService.getAuditableEntity(code, InformationAccessLevel.class);
    }

    /**
     * Returns InformationAccessLevel instance by ID.
     *
     * @param id InformationAccessLevel ID
     * @return InformationAccessLevel instance
     */
    @Override
    public InformationAccessLevel getInformationAccessLevel(Long id) {
        return auditableEntityService.getAuditableEntity(id, InformationAccessLevel.class);
    }

}
