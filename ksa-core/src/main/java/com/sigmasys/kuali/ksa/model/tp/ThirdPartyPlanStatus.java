package com.sigmasys.kuali.ksa.model.tp;

import com.sigmasys.kuali.ksa.model.Identifiable;

/**
 * ThirdPartyPlan status constants.
 *
 * @author Michael Ivanov
 */
public enum ThirdPartyPlanStatus implements Identifiable {

    CHARGED(ThirdPartyPlanStatus.CHARGED_CODE),
    REVERSED(ThirdPartyPlanStatus.REVERSED_CODE);

    public static final String CHARGED_CODE = "C";
    public static final String REVERSED_CODE = "R";

    private String id;

    private ThirdPartyPlanStatus(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        switch (this) {
            case CHARGED:
                return "Charged";
            case REVERSED:
                return "Reversed";
        }
        throw new IllegalStateException("No third party plan status found for " + name() + " value");
    }
}
