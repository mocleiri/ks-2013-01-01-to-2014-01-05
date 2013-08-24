package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.AccountBlock;
import com.sigmasys.kuali.ksa.model.AccountBlockOverride;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.*;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import com.sigmasys.kuali.ksa.util.RequestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


/**
 * AccountBlockService implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("accountBlockService")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class AccountBlockServiceImpl extends GenericPersistenceService implements AccountBlockService {


    private static final Log logger = LogFactory.getLog(AccountBlockServiceImpl.class);


    private static final String GET_BLOCK_OVERRIDE_SELECT = "select a from AccountBlockOverride a " +
            "left outer join fetch a.account ac" +
            "left outer join fetch a.accountBlock acb ";


    @Autowired
    private AuditableEntityService entityService;

    @Autowired
    private AccountService accountService;


    /**
     * Creates and persists a new instance of AccountBlock based on the given parameters.
     *
     * @param code        AccountBlock code
     * @param name        AccountBlock name
     * @param description AccountBlock description
     * @return AccountBlock instance
     */
    @Override
    @Transactional(readOnly = false)
    public AccountBlock createAccountBlock(String code, String name, String description) {

        PermissionUtils.checkPermission(Permission.CREATE_ACCOUNT_BLOCK);

        if (StringUtils.isBlank(code)) {
            String errMsg = "AccountBlock code cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (StringUtils.isBlank(name)) {
            String errMsg = "AccountBlock name cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        return entityService.createAuditableEntity(code, name, description, AccountBlock.class);
    }

    /**
     * Persists AccountBlock instance in the persistent store
     *
     * @param accountBlock AccountBlock instance
     * @return AccountBlock ID
     */
    @Override
    @Transactional(readOnly = false)
    public Long persistAccountBlock(AccountBlock accountBlock) {

        PermissionUtils.checkPermission(Permission.UPDATE_ACCOUNT_BLOCK);

        if (StringUtils.isBlank(accountBlock.getCode())) {
            String errMsg = "AccountBlock code cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (StringUtils.isBlank(accountBlock.getName())) {
            String errMsg = "AccountBlock name cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        return entityService.persistAuditableEntity(accountBlock);
    }

    /**
     * Removes AccountBlock entity from the persistent store by ID.
     *
     * @param accountBlockId AccountBlock ID
     * @return true if AccountBlock entity has been deleted
     */
    @Override
    @Transactional(readOnly = false)
    public boolean deleteAccountBlock(Long accountBlockId) {
        PermissionUtils.checkPermission(Permission.DELETE_ACCOUNT_BLOCK);
        return entityService.deleteAuditableEntity(accountBlockId, AccountBlock.class);
    }

    /**
     * Retrieves AccountBlock entity by ID from the persistent store.
     *
     * @param accountBlockId AccountBlock ID
     * @return AccountBlock instance
     */
    @Override
    public AccountBlock getAccountBlock(Long accountBlockId) {
        PermissionUtils.checkPermission(Permission.READ_ACCOUNT_BLOCK);
        return entityService.getAuditableEntity(accountBlockId, AccountBlock.class);
    }

    /**
     * Returns all account blocks from the persistent store sorted by code in the ascending order.
     *
     * @return list of AccountBlock instances
     */
    @Override
    public List<AccountBlock> getAccountBlocks() {
        PermissionUtils.checkPermission(Permission.READ_ACCOUNT_BLOCK);
        List<AccountBlock> accountBlocks = entityService.getAuditableEntities(AccountBlock.class);
        if (CollectionUtils.isNotEmpty(accountBlocks)) {
            Collections.sort(accountBlocks, new Comparator<AccountBlock>() {
                @Override
                public int compare(AccountBlock block1, AccountBlock block2) {
                    return block1.getCode().compareToIgnoreCase(block2.getCode());
                }
            });
        }
        return accountBlocks;
    }

    /**
     * Creates and persists a new instance of AccountBlockOverride in the persistent store.
     *
     * @param accountBlockId AccountBlock ID
     * @param accountId      Account ID
     * @param expirationDate Expiration date
     * @param reason         Override reason
     * @param isSingleUse    Indicates whether AccountBlockOverride is for single use
     * @return AccountBlockOverride instance
     */
    @Override
    @Transactional(readOnly = false)
    public AccountBlockOverride createAccountBlockOverride(Long accountBlockId, String accountId, Date expirationDate,
                                                           String reason, boolean isSingleUse) {
        return createAccountBlockOverride(accountBlockId, accountId, expirationDate, reason, isSingleUse, false);
    }

    /**
     * Creates and persists an administrative account block override in the persistent store.
     *
     * @param accountId      Account ID
     * @param expirationDate Expiration date
     * @param reason         Override reason
     * @return AccountBlockOverride instance
     */
    @Override
    @Transactional(readOnly = false)
    public AccountBlockOverride createAdminAccountBlockOverride(String accountId, Date expirationDate, String reason) {
        return createAccountBlockOverride(null, accountId, expirationDate, reason, false, true);
    }

    private AccountBlockOverride createAccountBlockOverride(Long accountBlockId, String accountId, Date expirationDate,
                                                            String reason, boolean isSingleUse, boolean isAdminOverride) {

        PermissionUtils.checkPermission(Permission.CREATE_ACCOUNT_BLOCK_OVERRIDE);

        Account account = accountService.getFullAccount(accountId);
        if (account == null) {
            String errMsg = "Account with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        if (expirationDate == null) {
            String errMsg = "AccountBlockOverride expiration date cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (StringUtils.isBlank(reason)) {
            String errMsg = "AccountBlockOverride reason cannot be empty";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        AccountBlockOverride blockOverride = new AccountBlockOverride();

        if (!isAdminOverride) {

            AccountBlock accountBlock = getAccountBlock(accountBlockId);
            if (accountBlock == null) {
                String errMsg = "AccountBlock with ID = " + accountBlockId + " does not exist";
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
            }

            blockOverride.setAccountBlock(accountBlock);
        }

        blockOverride.setAccount(account);

        blockOverride.setExpirationDate(expirationDate);
        blockOverride.setReason(reason);
        blockOverride.setSingleUse(!isAdminOverride && isSingleUse);
        blockOverride.setAdminOverride(isAdminOverride);
        blockOverride.setComplete(false);
        blockOverride.setCreationDate(new Date());
        blockOverride.setCreatorId(userSessionManager.getUserId(RequestUtils.getThreadRequest()));

        persistEntity(blockOverride);

        return blockOverride;
    }


    /**
     * Retrieves AccountBlockOverride entity from the persistent store.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return AccountBlockOverride instance
     */
    @Override
    public AccountBlockOverride getAccountBlockOverride(Long blockOverrideId) {

        PermissionUtils.checkPermission(Permission.READ_ACCOUNT_BLOCK_OVERRIDE);

        Query query = em.createQuery(GET_BLOCK_OVERRIDE_SELECT + " where a.id = :id");

        query.setParameter("id", blockOverrideId);

        List<AccountBlockOverride> blockOverrides = query.getResultList();

        return CollectionUtils.isNotEmpty(blockOverrides) ? blockOverrides.get(0) : null;
    }

    /**
     * Returns all AccountBlockOverride objects from the persistent store.
     *
     * @return list of AccountBlockOverride instances
     */
    @Override
    public List<AccountBlockOverride> getAccountBlockOverrides() {

        PermissionUtils.checkPermission(Permission.READ_ACCOUNT_BLOCK_OVERRIDE);

        Query query = em.createQuery(GET_BLOCK_OVERRIDE_SELECT + " order by a.id desc");

        return query.getResultList();
    }

    /**
     * Returns AccountBlockOverride objects for the given Account ID from the persistent store.
     *
     * @return list of AccountBlockOverride instances
     */
    @Override
    public List<AccountBlockOverride> getAccountBlockOverrides(String accountId) {

        PermissionUtils.checkPermission(Permission.READ_ACCOUNT_BLOCK_OVERRIDE);

        Query query = em.createQuery(GET_BLOCK_OVERRIDE_SELECT + " where ac <> null and ac.id = :accountId order by a.id desc");

        query.setParameter("accountId", accountId);

        return query.getResultList();
    }

    /**
     * Removes AccountBlockOverride entity from the persistent store by ID.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return true if AccountBlockOverride entity has been deleted
     */
    @Override
    @Transactional(readOnly = false)
    public boolean deleteAccountBlockOverride(Long blockOverrideId) {
        PermissionUtils.checkPermission(Permission.DELETE_ACCOUNT_BLOCK_OVERRIDE);
        return deleteEntity(blockOverrideId, AccountBlockOverride.class);

    }


    /**
     * Releases AccountBlockOverride object.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return AccountBlockOverride instance
     */
    @Override
    @Transactional(readOnly = false)
    public AccountBlockOverride releaseAccountBlockOverride(Long blockOverrideId) {

        PermissionUtils.checkPermission(Permission.RELEASE_ACCOUNT_BLOCK_OVERRIDE);

        AccountBlockOverride blockOverride = getAccountBlockOverride(blockOverrideId);
        if (blockOverride == null) {
            String errMsg = "AccountBlockOverride with ID = " + blockOverrideId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        blockOverride.setComplete(true);

        return blockOverride;
    }


}
