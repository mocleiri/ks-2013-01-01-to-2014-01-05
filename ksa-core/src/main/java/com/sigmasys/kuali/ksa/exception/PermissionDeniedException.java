package com.sigmasys.kuali.ksa.exception;


/**
 * This exception is thrown  when a user does not have the appropriate permission.
 *
 * @author Michael Ivanov
 */
public class PermissionDeniedException extends GenericException {

    private String userId;
    private String permissionName;

    public PermissionDeniedException(String userId, String permissionName) {
        super(null);
        this.userId = userId;
        this.permissionName = permissionName;

    }

    public String getUserId() {
        return userId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    @Override
    public String getMessage() {
        return "User '" + userId + "' does not have permission '" + permissionName + "'";
    }

}
