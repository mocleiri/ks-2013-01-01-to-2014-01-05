package com.sigmasys.kuali.ksa.gwt.client.view.widget;

import com.sigmasys.kuali.ksa.gwt.client.view.widget.value.TimeValue;

/**
 * Converts TimeValue to String and back.
 *
 * @author Michael Ivanov
 */
public class TimePropertyEditor extends AbstractStringPropertyEditor<TimeValue> {

    /* (non-Javadoc)
      * @see com.extjs.gxt.ui.client.widget.form.PropertyEditor#convertStringValue(java.lang.String)
      */
    public TimeValue convertStringValue(String value) {
        return new TimeValue(value);
    }
}
