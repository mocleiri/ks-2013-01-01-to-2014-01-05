package com.sigmasys.kuali.ksa.exception;

/**
 * This exception is thrown when a transaction is invalid.
 *
 * @author Michael Ivanov
 */
public class InvalidRefundTypeException extends GenericException {

    public InvalidRefundTypeException(String message) {
        super(message);
    }

}
