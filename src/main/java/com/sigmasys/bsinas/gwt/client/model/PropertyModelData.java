package com.sigmasys.bsinas.gwt.client.model;

/**
 * PropertyModelData
 * This type of model can be useful in GWT list/combo boxes where name/value pairs are required.
 *
 * @author Michael Ivanov
 */

public class PropertyModelData extends StringModelData {

    public static final String KEY = "key";

    public PropertyModelData() {
    }

    public PropertyModelData(String key, String value) {
        super(value);
        set(KEY, key);
    }

    public String getKey() {
        return get(KEY);
    }

    public void setKey(String key) {
        set(KEY, key);
    }

    @Override
    public String toString() {
        return "key=" + getKey() + ";value=" + getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PropertyModelData)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PropertyModelData that = (PropertyModelData) o;
        if (getKey() != null ? !getKey().equals(that.getKey()) : that.getKey() != null) {
            return false;
        }
        return !(getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getKey() != null ? getKey().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }
}