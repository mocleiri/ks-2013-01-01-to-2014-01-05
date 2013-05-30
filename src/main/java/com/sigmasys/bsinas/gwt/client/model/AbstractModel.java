package com.sigmasys.bsinas.gwt.client.model;

import com.extjs.gxt.ui.client.data.BaseModel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Abstract model used as a super class for GWT UI beans.
 *
 * @author Michael Ivanov
 */
public abstract class AbstractModel extends BaseModel {

    public abstract Serializable getId();

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        AbstractModel entity = (AbstractModel) obj;
        if (this.getId() == null) {
            // When both are null the two entities are new, but not necessarily equal
            return entity.getId() == null && super.equals(obj);
        }
        return this.getId().equals(entity.getId());
    }

    public int hashCode() {
        return 31 + ((getId() == null) ? super.hashCode() : getId().hashCode());
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(this.getClass().getName());
        buffer.append("[");
        for (Map.Entry<String, Object> entry : getProperties().entrySet()) {
            buffer.append(entry.getKey());
            Object value = entry.getValue();
            buffer.append("=");
            if (value != null) {
                if (!(value instanceof Collection<?>)) {
                    buffer.append(value.toString());
                } else {
                    buffer.append("collection");
                }
            } else {
                buffer.append("null");
            }
            buffer.append(",");
        }
        buffer.append("]@");
        buffer.append(this.hashCode());
        return buffer.toString();
    }

}
