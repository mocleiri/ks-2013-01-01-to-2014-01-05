package com.sigmasys.kuali.ksa.gwt.client.model;

import java.io.Serializable;

/**
 * GWT transaction type.
 *
 * @author Michael Ivanov
 *         Date: 5/16/12
 */
public enum TransactionType implements Serializable {

    CHARGE,
    PAYMENT,
    DEFERMENT;


    @Override
    public String toString() {
        switch (this) {
            case CHARGE:
                return "Charge";
            case PAYMENT:
                return "Payment";
            case DEFERMENT:
                return "Deferment";
        }
        throw new IllegalStateException("Unknown transaction type: " + name());
    }
}
