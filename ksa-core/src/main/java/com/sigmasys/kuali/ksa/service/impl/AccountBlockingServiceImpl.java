package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.exception.AccountBlockedException;
import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.AccountBlockOverride;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.rule.Rule;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.*;
import com.sigmasys.kuali.ksa.service.brm.BrmContext;
import com.sigmasys.kuali.ksa.service.brm.BrmPersistenceService;
import com.sigmasys.kuali.ksa.service.brm.BrmService;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.*;


/**
 * AccountBlockingService implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("accountBlockingService")
@Transactional(readOnly = true, noRollbackFor = AccountBlockedException.class)
@SuppressWarnings("unchecked")
public class AccountBlockingServiceImpl extends GenericPersistenceService implements AccountBlockingService {


    private static final Log logger = LogFactory.getLog(AccountBlockingServiceImpl.class);


    private static final String GET_BLOCK_OVERRIDE_SELECT = "select a from AccountBlockOverride a " +
            "inner join fetch a.account ac" +
            "inner join fetch a.rule r " +
            "inner join fetch r.type t ";


    @Autowired
    private AccountService accountService;

    @Autowired
    private BrmPersistenceService brmPersistenceService;

    @Autowired
    private BrmService brmService;


    /**
     * Creates and persists a new instance of AccountBlockOverride in the persistent store.
     *
     * @param ruleName       BRM rule name of the account block
     * @param accountId      Account ID
     * @param expirationDate Expiration date
     * @param reason         Override reason
     * @return AccountBlockOverride instance
     */
    @Override
    @Transactional(readOnly = false)
    public AccountBlockOverride createAccountBlockOverride(String ruleName, String accountId, Date expirationDate, String reason) {

        PermissionUtils.checkPermission(Permission.CREATE_ACCOUNT_BLOCK_OVERRIDE);

        Rule rule = brmPersistenceService.getRule(ruleName);
        if (rule == null) {
            String errMsg = "Rule '" + ruleName + "' does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

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

        blockOverride.setAccount(account);
        blockOverride.setRule(rule);

        blockOverride.setExpirationDate(expirationDate);
        blockOverride.setReason(reason);
        blockOverride.setActive(true);
        blockOverride.setCreationDate(new Date());
        blockOverride.setCreatorId(userSessionManager.getUserId());

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

        Query query = em.createQuery(GET_BLOCK_OVERRIDE_SELECT + " where ac.id = :accountId order by a.id desc");

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
     * Enables AccountBlockOverride object.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return AccountBlockOverride instance
     */
    @Override
    @Transactional(readOnly = false)
    public AccountBlockOverride enableAccountBlockOverride(Long blockOverrideId) {
        return setAccountBlockOverride(blockOverrideId, true);
    }

    /**
     * Disables AccountBlockOverride object.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @return AccountBlockOverride instance
     */
    @Override
    @Transactional(readOnly = false)
    public AccountBlockOverride disableAccountBlockOverride(Long blockOverrideId) {
        return setAccountBlockOverride(blockOverrideId, false);
    }

    /**
     * Enables/disables AccountBlockOverride object.
     *
     * @param blockOverrideId AccountBlockOverride ID
     * @param active          Enables the account block if true, disables if false
     * @return AccountBlockOverride instance
     */
    protected AccountBlockOverride setAccountBlockOverride(Long blockOverrideId, boolean active) {

        PermissionUtils.checkPermission(Permission.RELEASE_ACCOUNT_BLOCK_OVERRIDE);

        AccountBlockOverride blockOverride = getAccountBlockOverride(blockOverrideId);
        if (blockOverride == null) {
            String errMsg = "AccountBlockOverride with ID = " + blockOverrideId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        blockOverride.setActive(active);

        return blockOverride;
    }

    /**
     * Checks if there is an account block set for the current user based on the permission and account attributes.
     *
     * @param permission Permission value
     * @param attributes Account attributes
     * @throws AccountBlockedException
     */
    @Override
    @Transactional(readOnly = false, noRollbackFor = AccountBlockedException.class)
    public void checkBlock(Permission permission, Map<String, Object> attributes) throws AccountBlockedException {
        checkBlock(userSessionManager.getUserId(), permission, attributes);
    }

    /**
     * Checks if there is an account block set for the given Account ID based on the permission and account attributes.
     *
     * @param accountId  Account ID
     * @param permission Permission value
     * @param attributes Account attributes
     * @throws AccountBlockedException
     */
    @Override
    @Transactional(readOnly = false, noRollbackFor = AccountBlockedException.class)
    public void checkBlock(String accountId, Permission permission, Map<String, Object> attributes) throws AccountBlockedException {

        Account account = accountService.getFullAccount(accountId);
        if (account == null) {
            String errMsg = "Account with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        // If the account blocking is disabled nothing else should be done
        if (account.isBlockingEnabled()) {
            logger.info("Account Blocking is disabled for Account ID = " + accountId);
            return;
        }

        // Calling BrmService with payment application rules
        BrmContext brmContext = new BrmContext();
        brmContext.setAccount(account);

        Map<String, Object> globalParams = new HashMap<String, Object>();

        globalParams.put("blockNames", new LinkedList<String>());
        globalParams.put("permission", permission);

        String atpId = (String) attributes.get("atpId");
        if (atpId == null) {
            atpId = "";
        }

        globalParams.put("atpId", atpId);

        String holdIssueId = (String) attributes.get("holdIssueId");
        if (holdIssueId == null) {
            holdIssueId = "";
        }

        globalParams.put("holdIssueId", holdIssueId);


        brmContext.setGlobalVariables(globalParams);

        brmContext.setAttributes(attributes);

        brmService.fireRules(Constants.DROOLS_AB_RULE_SET_NAME, brmContext);

        Set<String> blockNames = (Set<String>) globalParams.get("blockNames");

        if (CollectionUtils.isNotEmpty(blockNames)) {

            boolean accountIsBlocked = true;

            // Checking AccountBlockOverride objects
            List<AccountBlockOverride> blockOverrides = getAccountBlockOverrides(accountId);

            if (CollectionUtils.isNotEmpty(blockOverrides)) {

                Set<String> ruleOverrideNames = new HashSet<String>();

                for (AccountBlockOverride blockOverride : blockOverrides) {
                    if (blockOverride.isActive()) {
                        Rule rule = blockOverride.getRule();
                        if (rule != null && blockNames.contains(rule.getName())) {
                            ruleOverrideNames.add(rule.getName());
                        }
                    }
                }

                // If the set of rule names equals the set of block names retrieved from the BRM engine
                // then the account is NOT blocked and we DO NOT have to throw AccountBlockedException
                if (ruleOverrideNames.size() == blockNames.size()) {
                    accountIsBlocked = false;
                }
            }

            if (accountIsBlocked) {
                throw new AccountBlockedException(accountId, permission, blockNames);
            }
        }

    }

}
