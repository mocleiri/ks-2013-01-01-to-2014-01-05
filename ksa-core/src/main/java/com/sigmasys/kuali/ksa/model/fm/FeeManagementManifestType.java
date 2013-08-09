package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.Identifiable;

/**
 * FeeManagementManifest status values.
 *
 * @author Michael Ivanov
 */
public enum FeeManagementManifestType implements Identifiable {


    CHARGE(FeeManagementManifestType.CHARGE_CODE),
    CANCELLATION(FeeManagementManifestType.CANCELLATION_CODE),
    DISCOUNT(FeeManagementManifestType.DISCOUNT_CODE),
    CORRECTION(FeeManagementManifestType.CORRECTION_CODE);

    public static final String CHARGE_CODE = "CH";
    public static final String CANCELLATION_CODE = "CA";
    public static final String DISCOUNT_CODE = "DI";
    public static final String CORRECTION_CODE = "CO";


    private String id;

    private FeeManagementManifestType(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        switch (this) {
            case CHARGE:
                return "Charge";
            case CANCELLATION:
                return "Cancellation";
            case DISCOUNT:
                return "Discount";
            case CORRECTION:
                return "Correction";
        }
        throw new IllegalStateException("No Fee Management Manifest type found for " + name() + " value");
    }
}
