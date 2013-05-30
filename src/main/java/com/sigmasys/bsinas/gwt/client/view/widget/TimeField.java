package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.sigmasys.bsinas.gwt.client.service.validator.TimeFormatValidator;
import com.sigmasys.bsinas.gwt.client.view.widget.value.TimeValue;

/**
 * TimeField
 *
 * @author Michael Ivanov
 */
public class TimeField extends TextField<TimeValue> {

    private TimeFormatValidator formatValidator;

    public TimeField() {
        propertyEditor = new TimePropertyEditor();
        formatValidator = new TimeFormatValidator();
    }

    @Override
    protected boolean validateValue(String value) {
        String errorMessage = formatValidator.validate(this, value);
        if (errorMessage != null) {
            markInvalid(errorMessage);
            return false;
        }
        return super.validateValue(value);
    }

    /* (non-Javadoc)
      * @see com.extjs.gxt.ui.client.widget.form.Field#getPropertyEditor()
      */
    @Override
    public TimePropertyEditor getPropertyEditor() {
        return (TimePropertyEditor) propertyEditor;
    }

    public void setFormatValidator(TimeFormatValidator formatValidator) {
        this.formatValidator = formatValidator;
    }

    public TimeFormatValidator getFormatValidator() {
        return formatValidator;
    }
}
