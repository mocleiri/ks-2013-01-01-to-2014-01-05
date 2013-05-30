package com.sigmasys.bsinas.gwt.client.service.validator;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.sigmasys.bsinas.gwt.client.util.StringUtils;

import java.util.Date;

/**
 * Validates the date field against the given date with the specified
 * operation.
 *
 * @author Michael Ivanov
 */
public class DateComparatorValidator implements Validator {

    private Date date;
    private Operation operation;

    public static enum Operation {
        EQUAL,
        NOT_EQUAL,
        GREATER,
        GREATER_OR_EQUAL,
        LESS,
        LESS_OR_EQUAL
    }

    public DateComparatorValidator(Operation operation, Date date) {
        this.operation = operation;
        this.date = date;
    }


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
            if (dateField.getAllowBlank()) {
                return null;
            }
            return "Date field cannot be empty";
        }

        final String pattern = dateField.getPropertyEditor().getFormat().getPattern();
        final String errMsg = "Valid date format is " + pattern;

        final String parsedDate = dateField.getPropertyEditor().getFormat().format(date);

        Date fieldDate;
        try {
            fieldDate = dateField.getPropertyEditor().getFormat().parseStrict(value);
        } catch (Exception ex) {
            Log.error(errMsg, ex);
            return errMsg;
        }

        if (fieldDate == null) {
            return errMsg;
        }

        switch (operation) {
            case EQUAL:
                if (fieldDate.compareTo(date) != 0) {
                    return "Date must be equal to " + parsedDate;
                }
                break;
            case NOT_EQUAL:
                if (fieldDate.compareTo(date) == 0) {
                    return "Date must not be equal to " + parsedDate;
                }
                break;
            case GREATER:
                if (fieldDate.compareTo(date) <= 0) {
                    return "Date must be greater than " + parsedDate;
                }
                break;
            case GREATER_OR_EQUAL:
                if (fieldDate.compareTo(date) < 0) {
                    return "Date must be greater than or equal to " + parsedDate;
                }
                break;
            case LESS:
                if (fieldDate.compareTo(date) >= 0) {
                    return "Date must be less than " + parsedDate;
                }
                break;
            case LESS_OR_EQUAL:
                if (fieldDate.compareTo(date) > 0) {
                    return "Date must be less than or equal to " + parsedDate;
                }
                break;
        }

        return null;
    }

}