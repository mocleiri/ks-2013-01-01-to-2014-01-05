package com.sigmasys.kuali.ksa.model;

/**
 * Refund status
 *
 * @author Michael Ivanov
 */
public enum RefundStatus implements Identifiable {

    UNVERIFIED(RefundStatus.UNVERIFIED_CODE),
    VERIFIED(RefundStatus.VERIFIED_CODE),
    REFUNDED(RefundStatus.REFUNDED_CODE),
    CANCELLED(RefundStatus.CANCELED_CODE),
    FAILED(RefundStatus.FAILED_CODE);

    public static final String UNVERIFIED_CODE = "U";
    public static final String VERIFIED_CODE = "V";
    public static final String REFUNDED_CODE = "R";
    public static final String CANCELED_CODE = "C";
    public static final String FAILED_CODE = "F";

    private String id;

    private RefundStatus(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        switch (this) {
            case UNVERIFIED:
                return "Unverified";
            case VERIFIED:
                return "Verified";
            case REFUNDED:
                return "Refunded";
            case CANCELLED:
            	return "Cancelled";
            case FAILED:
                return "Failed";
        }
        throw new IllegalStateException("No refund status found for " + name() + " value");
    }

}
