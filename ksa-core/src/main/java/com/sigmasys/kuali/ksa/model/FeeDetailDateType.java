package com.sigmasys.kuali.ksa.model;

/**
 * Date Type constants used by FeeDetail.
 *
 * @author Michael Ivanov
 */
@Deprecated
public enum FeeDetailDateType implements Identifiable {

    ALWAYS,
    UNTIL,
    AFTER;

    @Override
    public String getId() {
        return name();
    }

}
