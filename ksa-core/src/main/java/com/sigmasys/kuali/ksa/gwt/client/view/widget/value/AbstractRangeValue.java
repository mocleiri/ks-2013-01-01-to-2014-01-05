package com.sigmasys.kuali.ksa.gwt.client.view.widget.value;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;


/**
 * AbstractRangeValue
 *
 * @param <V> Serializable type
 * @author Michael Ivanov
 */
public abstract class AbstractRangeValue<V extends Serializable> implements Serializable, IsSerializable {

    private V from;
    private V to;

    public AbstractRangeValue() {
    }

    public AbstractRangeValue(V from, V to) {
        this.from = from;
        this.to = to;
    }

    public V getFrom() {
        return from;
    }

    public void setFrom(V from) {
        this.from = from;
    }

    public V getTo() {
        return to;
    }

    public void setTo(V to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return from + " - " + to;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractRangeValue other = (AbstractRangeValue) obj;
        if (from == null) {
            if (other.from != null)
                return false;
        } else if (!from.equals(other.from))
            return false;
        if (to == null) {
            if (other.to != null)
                return false;
        } else if (!to.equals(other.to))
            return false;
        return true;
    }
}
