package com.sigmasys.kuali.ksa.service.security;

import com.sigmasys.kuali.ksa.exception.PermissionDeniedException;
import com.sigmasys.kuali.ksa.model.Allocation;
import com.sigmasys.kuali.ksa.model.Tag;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.UserSessionManager;
import com.sigmasys.kuali.ksa.util.ContextUtils;
import com.sigmasys.kuali.ksa.util.RequestUtils;

/**
 * KSA Permission utility-methods
 */
public class PermissionUtils {

    private static UserSessionManager userSessionManager;
    private static AccessControlService acService;

    private PermissionUtils() {
    }

    private static UserSessionManager getUserSessionManager() {
        if (userSessionManager == null) {
            userSessionManager = ContextUtils.getBean(UserSessionManager.class);
        }
        return userSessionManager;
    }

    private static AccessControlService getAccessControlService() {
        if (acService == null) {
            acService = ContextUtils.getBean(AccessControlService.class);
        }
        return acService;
    }

    public static boolean hasPermission(Permission permission) {
        return getAccessControlService().hasPermission(permission);
    }

    public static void checkPermission(Permission permission, Object target) {

        boolean throwException = false;
        boolean noPermission = !hasPermission(permission);

        if (target instanceof Allocation) {
            Allocation allocation = (Allocation) target;
            switch (permission) {
                case CREATE_ALLOCATION:
                case REMOVE_ALLOCATION:
                case CREATE_LOCKED_ALLOCATION:
                case REMOVE_LOCKED_ALLOCATION:
                    throwException = noPermission;
                    break;
                case CREATE_INTERNALLY_LOCKED_ALLOCATION:
                case REMOVE_INTERNALLY_LOCKED_ALLOCATION:
                    throwException = noPermission && allocation.isInternallyLocked();
                    break;
            }

        } else if (target instanceof Tag) {
            Tag tag = (Tag) target;
            switch (permission) {
                case EDIT_ADMIN_TAG:
                    throwException = noPermission && tag.isAdministrative();
                    break;
            }
        }

        if (throwException) {
            String userId = getUserSessionManager().getUserId(RequestUtils.getThreadRequest());
            throw new PermissionDeniedException(userId, permission);
        }

    }


}
