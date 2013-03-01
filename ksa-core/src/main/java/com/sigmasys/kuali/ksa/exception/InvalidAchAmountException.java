package com.sigmasys.kuali.ksa.exception;

/**
 * This exception is thrown when ACH amount is invalid.
 *
 * @author Michael Ivanov
 *         Date: 8/7/12
 */
public class InvalidAchAmountException extends GenericException {

    public InvalidAchAmountException(String message) {
        super(message);
    }

}
