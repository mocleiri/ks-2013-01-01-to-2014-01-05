package com.sigmasys.kuali.ksa.exception;

/**
 * This exception is thrown when ACH information not been found.
 *
 * @author Michael Ivanov
 *         Date: 8/7/12
 */
public class NoAchInformationException extends GenericException {

    public NoAchInformationException(String message) {
        super(message);
    }
}
