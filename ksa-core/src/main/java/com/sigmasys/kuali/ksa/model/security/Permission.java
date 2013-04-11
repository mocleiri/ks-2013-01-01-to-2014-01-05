package com.sigmasys.kuali.ksa.model.security;

/**
 * Access Control permission constants.
 *
 * @author Michael Ivanov
 */
public enum Permission {

    // Tag permissions
    EDIT_ADMIN_TAG,

    // Allocation permissions
    CREATE_ALLOCATION,
    REMOVE_ALLOCATION,
    CREATE_LOCKED_ALLOCATION,
    REMOVE_LOCKED_ALLOCATION,
    CREATE_INTERNALLY_LOCKED_ALLOCATION,
    REMOVE_INTERNALLY_LOCKED_ALLOCATION

    // TODO: add more KSA permissions

}
