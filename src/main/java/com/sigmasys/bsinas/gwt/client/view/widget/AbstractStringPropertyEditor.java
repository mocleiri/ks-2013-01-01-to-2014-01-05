package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.widget.form.PropertyEditor;
import com.sigmasys.bsinas.gwt.client.view.widget.value.StringValue;

/**
 * AbstractStringPropertyEditor
 *
 * @author Michael Ivanov
 *
 */
public abstract class AbstractStringPropertyEditor<T extends StringValue> implements PropertyEditor<T> {

	/* (non-Javadoc)
	 * @see com.extjs.gxt.ui.client.widget.form.PropertyEditor#convertStringValue(java.lang.String)
	 */
	public abstract T convertStringValue(String value);

	public String getStringValue(T value) {
		return value.getValue();
	}

}