package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AccessControlService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.core.api.criteria.*;
import org.kuali.rice.core.api.membership.MemberType;
import org.kuali.rice.kim.api.identity.IdentityService;
import org.kuali.rice.kim.api.identity.principal.Principal;
import org.kuali.rice.kim.api.permission.Permission;
import org.kuali.rice.kim.api.permission.PermissionQueryResults;
import org.kuali.rice.kim.api.permission.PermissionService;
import org.kuali.rice.kim.api.role.Role;
import org.kuali.rice.kim.api.role.RoleMember;
import org.kuali.rice.kim.api.role.RoleService;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.rice.kim.impl.KIMPropertyConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * Access Control service implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("accessControlService")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class AccessControlServiceImpl extends GenericPersistenceService implements AccessControlService {

    private static final Log logger = LogFactory.getLog(AccessControlServiceImpl.class);

    // Map of [User ID, list of Role instances]
    private static final Map<String, List<Role>> userRoles = new HashMap<String, List<Role>>();

    // Map of [User ID, list of Permission instances]
    private static final Map<String, List<Permission>> userPermissions = new HashMap<String, List<Permission>>();

    private final Set<String> transactionTypeIds = new HashSet<String>();
    private final Map<String, String> transactionTypeMasks = new HashMap<String, String>();


    private IdentityService getIdentityService() {
        return KimApiServiceLocator.getIdentityService();
    }

    private RoleService getRoleService() {
        return KimApiServiceLocator.getRoleService();
    }

    private PermissionService getPermissionService() {
        return KimApiServiceLocator.getPermissionService();
    }


    @PostConstruct
    private void postConstruct() {
        refresh();
    }

    private void loadTransactionTypeMasks() {
        transactionTypeMasks.clear();
        List<TransactionMaskRole> maskRoles = getEntities(TransactionMaskRole.class);
        for (TransactionMaskRole maskRole : maskRoles) {
            String roleName = maskRole.getRoleName();
            String typeMask = maskRole.getTypeMask();
            logger.debug("Loading [roleName = '" + roleName + "', typeMask = '" + typeMask + "']");
            transactionTypeMasks.put(roleName, typeMask);
        }
    }

    private void loadTransactionTypeIds() {
        transactionTypeIds.clear();
        List<TransactionType> transactionTypes = getEntities(TransactionType.class);
        for (TransactionType transactionType : transactionTypes) {
            String transactionTypeId = transactionType.getId().getId();
            logger.debug("Loading [Transaction Type ID = '" + transactionTypeId + "']");
            transactionTypeIds.add(transactionTypeId);
        }
    }

    private List<Role> getKimRoles(String userId) {
        List<Role> roles = userRoles.get(userId);
        if (roles == null) {
            roles = new LinkedList<Role>();
            Principal principal = getIdentityService().getPrincipalByPrincipalName(userId);
            Predicate memberPredicate =
                    PredicateFactory.equal(KIMPropertyConstants.RoleMember.MEMBER_ID, principal.getPrincipalId());
            Predicate memberTypePredicate =
                    PredicateFactory.equal(KIMPropertyConstants.RoleMember.MEMBER_TYPE_CODE, MemberType.PRINCIPAL.getCode());
            QueryByCriteria criteria = QueryByCriteria.Builder.fromPredicates(memberPredicate, memberTypePredicate);
            List<RoleMember> roleMembers = getRoleService().findRoleMembers(criteria).getResults();
            if (roleMembers != null && !roleMembers.isEmpty()) {
                List<String> roleIds = new ArrayList<String>(roleMembers.size());
                for (RoleMember roleMember : roleMembers) {
                    roleIds.add(roleMember.getRoleId());
                }
                roles.addAll(getRoleService().getRoles(roleIds));
            }
            userRoles.put(userId, roles);
        }
        return roles;
    }

    @Override
    public Set<String> getRoles(String userId) {
        List<Role> roles = getKimRoles(userId);
        if (CollectionUtils.isNotEmpty(roles)) {
            Set<String> roleNames = new HashSet<String>(roles.size());
            for (Role role : roles) {
                roleNames.add(role.getName());
            }
            return roleNames;
        }
        return Collections.emptySet();
    }

    private List<Permission> getKimPermissions(String userId) {
        List<Permission> permissions = userPermissions.get(userId);
        if (permissions == null) {
            permissions = new LinkedList<Permission>();
            QueryByCriteria criteria = QueryByCriteria.Builder.create().build();
            PermissionService permissionService = getPermissionService();
            PermissionQueryResults results = permissionService.findPermissions(criteria);
            List<Permission> allPermissions = results.getResults();
            if (CollectionUtils.isNotEmpty(allPermissions)) {
                for (Permission permission : allPermissions) {
                    String name = permission.getName();
                    String namespaceCode = permission.getNamespaceCode();
                    if (permissionService.hasPermission(userId, namespaceCode, name)) {
                        permissions.add(permission);
                    }
                }
            }
            userPermissions.put(userId, permissions);
        }
        return permissions;
    }

    @Override
    public Set<String> getPermissions(String userId) {
        List<Permission> permissions = getKimPermissions(userId);
        if (CollectionUtils.isNotEmpty(permissions)) {
            Set<String> permissionNames = new HashSet<String>(permissions.size());
            for (Permission permission : permissions) {
                permissionNames.add(permission.getName());
            }
            return permissionNames;
        }
        return Collections.emptySet();
    }

    private List<String> getTransactionTypeMasksByRoleNames(Set<String> roleNames) {
        if (CollectionUtils.isNotEmpty(roleNames)) {
            if (!transactionTypeMasks.isEmpty()) {
                List<String> typeMasks = new LinkedList<String>();
                for (Map.Entry<String, String> roleMask : transactionTypeMasks.entrySet()) {
                    String roleName = roleMask.getKey();
                    String typeMask = roleMask.getValue();
                    if (roleNames.contains(roleName)) {
                        typeMasks.add(typeMask);
                    }
                }
                return typeMasks;
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> getAllowedTransactionTypeMasks(String userId) {
        return getTransactionTypeMasksByRoleNames(getRoles(userId));
    }

    @Override
    public List<String> getAllowedTransactionTypes(String userId) {
        return getTransactionTypesByRoleNames(getRoles(userId));
    }

    @Override
    public List<String> getTransactionTypesByRoleNames(Set<String> roleNames) {
        List<String> typeMasks = getTransactionTypeMasksByRoleNames(roleNames);
        logger.debug("Loaded type masks: " + typeMasks);
        List<String> transactionTypes = new LinkedList<String>();
        for (String typeMask : typeMasks) {
            for (String transactionTypeId : transactionTypeIds) {
                if (Pattern.matches(typeMask, transactionTypeId)) {
                    transactionTypes.add(transactionTypeId);
                    logger.debug("Adding [Transaction Type ID = '" + transactionTypeId + "']");
                }
            }
        }
        return transactionTypes;
    }

    @Override
    public boolean isTransactionTypeAllowed(String userId, String transactionTypeId) {
        List<String> typeMasks = getAllowedTransactionTypeMasks(userId);
        logger.debug("Loaded type masks: " + typeMasks);
        for (String typeMask : typeMasks) {
            if (Pattern.matches(typeMask, transactionTypeId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasPermissions(String userId, String... permissionNames) {
        Set<String> permissions = getPermissions(userId);
        for (String permissionName : permissionNames) {
            if (!permissions.contains(permissionName)) {
                return false;
            }
        }
        return CollectionUtils.isNotEmpty(permissions) && permissionNames.length > 0;
    }

    @Override
    public boolean hasPermission(String userId, String permissionName) {
        return hasPermissions(userId, permissionName);
    }

    @Override
    public void refresh() {
        loadTransactionTypeMasks();
        loadTransactionTypeIds();
        userRoles.clear();
        userPermissions.clear();
    }
}
