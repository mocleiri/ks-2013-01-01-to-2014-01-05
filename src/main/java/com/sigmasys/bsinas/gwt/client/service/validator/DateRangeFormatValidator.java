package com.sigmasys.bsinas.gwt.client.service.validator;

import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Validator;

import java.util.Date;

/**
 * DateRangeFormatValidator.
 *
 * @author Michael Ivanov
 */
public class DateRangeFormatValidator implements Validator {

    private final DateFormatValidator formatValidator = new DateFormatValidator();

    private DateField fromDateField;
    private DateField toDateField;

    /**
     * DateRangeFormatValidator single constructor.
     *
     * @param fromDateField DateField fromDate
     * @param toDateField   DateField toDate
     */
    public DateRangeFormatValidator(DateField fromDateField, DateField toDateField) {
        this.fromDateField = fromDateField;
        this.toDateField = toDateField;
    }

    /* (non-Javadoc)
      * @see com.extjs.gxt.ui.client.widget.form.Validator#validate(com.extjs.gxt.ui.client.widget.form.Field, java.lang.String)
      */
    public String validate(Field<?> field, String value) {

        if (formatValidator.validate(fromDateField, fromDateField.getRawValue()) == null &&
                formatValidator.validate(toDateField, toDateField.getRawValue()) == null) {
            Date fromDate = fromDateField.getValue();
            Date toDate = toDateField.getValue();
            if (fromDate != null && toDate != null && fromDate.compareTo(toDate) > 0) {
                return "From date cannot be greater than To date";
            }
        }

        return null;
    }
    
    public DateFormatValidator getFormatValidator() {
    	return this.formatValidator;
    }
}