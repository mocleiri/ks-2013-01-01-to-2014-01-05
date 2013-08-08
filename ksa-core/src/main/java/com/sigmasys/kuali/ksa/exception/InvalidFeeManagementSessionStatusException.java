package com.sigmasys.kuali.ksa.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 8/7/13
 * Time: 11:46 PM
 *
 * This exception is thrown when a Fee Management Session is in an invalid status.
 *
 * @author Sergey Godunov
 */
public class InvalidFeeManagementSessionStatusException extends GenericException {

    /**
     * Creates a new instance of this exception class.
     *
     * @param msg An error message.
     */
    public InvalidFeeManagementSessionStatusException(String msg) {
        super(msg);
    }
}
