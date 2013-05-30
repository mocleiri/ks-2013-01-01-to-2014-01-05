package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractFieldContainer
 * <p/>
 *
 * @author Michael Ivanov
 */
public abstract class AbstractFieldContainer<V extends Serializable, T extends Serializable, C extends Field<V>> extends Field<T> {

    private List<C> fields;
    private LayoutContainer layoutContainer;

    // The default value which is set by reset()
    private T resetValue;


    protected AbstractFieldContainer() {
        fields = new ArrayList<C>();
    }

    protected abstract void resetTo(T resetValue);

    public void setResetValue(T resetValue) {
        this.resetValue = resetValue;
    }

    public void reset() {
        if (resetValue != null) {
            resetTo(resetValue);
        } else {
            for (C field : fields) {
                field.reset();
            }
        }
    }

    protected void addField(C field) {
        fields.add(field);
    }

    protected List<C> getFields() {
        return fields;
    }

    public boolean isValid() {
        // For highlighting going through all the fields even if one of them is invalid
        boolean isValid = true;
        for (C field : fields) {
            isValid &= field.isValid();
        }
        return isValid && super.isValid();
    }

    protected void doAttachChildren() {
        if (layoutContainer != null) {
            ComponentHelper.doAttach(layoutContainer);
        }
    }

    protected void doDetachChildren() {
        if (layoutContainer != null) {
            ComponentHelper.doDetach(layoutContainer);
        }
    }

    public LayoutContainer getLayoutContainer() {
        return layoutContainer;
    }

    public void setLayoutContainer(LayoutContainer layoutContainer) {
        this.layoutContainer = layoutContainer;
    }
}
