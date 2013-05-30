package com.sigmasys.bsinas.gwt.client.view.widget.value;


import java.io.Serializable;

/**
 * A common class for widget fields that have string values.
 *
 * @author Michael Ivanov
 */
public class StringValue implements Serializable {

    private String value = "";

    public StringValue() {
    }

    public StringValue(String value) {
        this.value = value;
    }

    /**
     * @return the stringValue
     */
    public String getValue() {
        return value;
    }

    /**
     * @param stringValue the stringValue to set
     */
    public void setValue(String stringValue) {
        this.value = stringValue;
    }

    @Override
    public String toString() {
        return value;
    }
}