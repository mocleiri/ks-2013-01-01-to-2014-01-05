package com.sigmasys.kuali.ksa.exception;

/**
 * This exception is thrown when a refund has already been cancelled.
 *
 * @author Michael Ivanov
 *         Date: 8/7/12
 */
public class RefundFailedException extends GenericException {

    public RefundFailedException(String message) {
        super(message);
    }
}