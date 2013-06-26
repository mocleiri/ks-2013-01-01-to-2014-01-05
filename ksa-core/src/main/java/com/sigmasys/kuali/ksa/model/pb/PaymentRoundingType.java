package com.sigmasys.kuali.ksa.model.pb;

import com.sigmasys.kuali.ksa.model.Identifiable;

/**
 * PaymentRoundingType values.
 *
 * @author Michael Ivanov
 */
public enum PaymentRoundingType implements Identifiable {

    ALL_BUT_FIRST(PaymentRoundingType.ALL_BUT_FIRST_CODE),
    ALL_BUT_LAST(PaymentRoundingType.ALL_BUT_LAST_CODE);

    public static final String ALL_BUT_FIRST_CODE = "F";
    public static final String ALL_BUT_LAST_CODE = "L";


    private String id;

    private PaymentRoundingType(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        switch (this) {
            case ALL_BUT_FIRST:
                return "Non-rounded First";
            case ALL_BUT_LAST:
                return "Non-rounded Last";
        }
        throw new IllegalStateException("No payment rounding type found for " + name() + " value");
    }
}
