package com.sigmasys.kuali.ksa.exception;


import java.util.Set;

/**
 * This exception is thrown  when a user account is blocked.
 *
 * @author Michael Ivanov
 */
public class AccountBlockedException extends GenericException {

    private Set<String> blockNames;


    public AccountBlockedException(String accountId, Set<String> blockNames) {
        super("Account '" + accountId + "' is blocked");
        this.blockNames = blockNames;
    }

    public Set<String> getBlockNames() {
        return blockNames;
    }
}
