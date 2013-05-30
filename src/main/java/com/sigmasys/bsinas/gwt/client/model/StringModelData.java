package com.sigmasys.bsinas.gwt.client.model;

import com.extjs.gxt.ui.client.data.BaseModelData;

import java.io.Serializable;

/**
 * This model is widely used by GWT components
 *
 * @author Michael Ivanov
 */
public class StringModelData extends BaseModelData implements Serializable {

    public static final String VALUE_KEY = "value";
    public static final String DISPLAY_VALUE_KEY = "displayValue";

    public StringModelData() {
    }

    public StringModelData(String value) {
        set(VALUE_KEY, value);
        set(DISPLAY_VALUE_KEY, value);
    }

    public StringModelData(String value, String displayValue) {
        set(VALUE_KEY, value);
        set(DISPLAY_VALUE_KEY, displayValue);
    }

    public String getValue() {
        return (String) get(VALUE_KEY);
    }

    public void setValue(String value) {
        set(VALUE_KEY, value);
    }

    public String getDisplayValue() {
        return get(DISPLAY_VALUE_KEY);
    }

    public void setDisplayValue(String value) {
        set(DISPLAY_VALUE_KEY, value);
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public int hashCode() {
        String value = getValue();
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        String value = getValue();
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StringModelData other = (StringModelData) obj;
        if (value == null) {
            if (other.getValue() != null)
                return false;
        } else if (!value.equals(other.getValue()))
            return false;
        return true;
    }
}