package com.sigmasys.kuali.ksa.model;


/**
 * Transaction status model.
 *
 * @author Michael Ivanov
 */
public enum TransactionStatus implements Identifiable {

    ACTIVE,
    BOUNCED,
    REFUNDED,
    REFUND_REQUESTED,
    EXPIRED,
    CANCELLED,
    WRITTEN_OFF,
    RECIPROCAL_OFFSET,
    REVERSED_OFFSET;


    @Override
    public String getId() {
        return name();
    }

    @Override
    public String toString() {
        switch (this) {
            case ACTIVE:
                return "Active";
            case BOUNCED:
                return "Bounced";
            case REFUNDED:
                return "Refunded";
            case REFUND_REQUESTED:
                return "Refund Requested";
            case EXPIRED:
                return "Expired";
            case CANCELLED:
                return "Cancelled";
            case WRITTEN_OFF:
                return "Written Off";
            case RECIPROCAL_OFFSET:
                return "Reciprocal Offset";
            case REVERSED_OFFSET:
                return "Reversed Offset";
        }
        throw new IllegalStateException("No Transaction status found for " + name() + " value");
    }


}
