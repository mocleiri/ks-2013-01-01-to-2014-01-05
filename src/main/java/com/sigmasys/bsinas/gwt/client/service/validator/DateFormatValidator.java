package com.sigmasys.bsinas.gwt.client.service.validator;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.sigmasys.bsinas.gwt.client.util.StringUtils;

/**
 * Validates against date format set via field.getPropertyEditor().setFormat().
 *
 * @author Michael Ivanov
 */
public class DateFormatValidator implements Validator {

    protected boolean strictFormat = true;


    /* (non-Javadoc)
    * @see com.extjs.gxt.ui.client.widget.form.Validator#validate(com.extjs.gxt.ui.client.widget.form.Field, java.lang.String)
    */

    public String validate(Field<?> field, String value) {

        if (!(field instanceof DateField)) {
            String errMsg = "Wrong field type. DateField is expected";
            Log.error(errMsg);
            return errMsg;
        }

        DateField dateField = (DateField) field;

        if (StringUtils.isEmpty(value)) {
            return dateField.getAllowBlank() ? null : "Date field cannot be empty";
        }

        final String pattern = dateField.getPropertyEditor().getFormat().getPattern();
        final String errMsg = "Valid date format is " + pattern;

        try {
            if (isStrictFormat()) {
                if (value.length() != pattern.length()) {
                    return errMsg;
                }
                dateField.getPropertyEditor().getFormat().parseStrict(value);
            } else {
                dateField.getPropertyEditor().getFormat().parse(value);
            }
        } catch (Exception ex) {
            Log.error(errMsg, ex);
            return errMsg;
        }
        return null;
    }


    public boolean isStrictFormat() {
        return strictFormat;
    }


    public void setStrictFormat(boolean strictFormat) {
        this.strictFormat = strictFormat;
    }


}