package com.sigmasys.kuali.ksa.model;

/**
 * FeeDetail amount type constants.
 *
 * @author Michael Ivanov
 */
@Deprecated
public enum FeeDetailAmountType implements Identifiable {

    FLAT,
    FIXED,
    FLEXIBLE;

    @Override
    public String getId() {
        return name();
    }

    @Override
    public String toString() {
        switch (this) {
            case FLAT:
                return "Flat Amount";
            case FIXED:
                return "Credit Hour Fixed Amount";
            case FLEXIBLE:
                return "Credit Hour Flexible Amount";
        }
        throw new IllegalStateException("No FeeDetail amount type found for " + name() + " value");
    }

}
