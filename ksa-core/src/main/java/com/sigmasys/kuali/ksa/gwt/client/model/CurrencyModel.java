package com.sigmasys.kuali.ksa.gwt.client.model;

/**
 * GWT version of Currency model.
 *
 * @author Michael Ivanov
 *         Date: 5/27/12
 *         Time: 11:55 AM
 */
public class CurrencyModel extends AuditableEntityModel {

    private static final String CODE = "code";


    public String getCode() {
        return get(CODE);
    }

    public void setCode(String code) {
        set(CODE, code);
    }
}
