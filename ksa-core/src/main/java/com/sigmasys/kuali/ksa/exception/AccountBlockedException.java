package com.sigmasys.kuali.ksa.exception;


import com.sigmasys.kuali.ksa.model.security.Permission;

import java.util.Set;

/**
 * This exception is thrown  when a user account is blocked.
 *
 * @author Michael Ivanov
 */
public class AccountBlockedException extends PermissionDeniedException {

    private Set<String> ruleNames;


    public AccountBlockedException(String userId, Permission permission, Set<String> ruleNames) {
        super(userId, permission);
        this.ruleNames = ruleNames;
    }

    public Set<String> getRuleNames() {
        return ruleNames;
    }
}
