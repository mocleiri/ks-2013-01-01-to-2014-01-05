/**
 *
 */
package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.DatePickerEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.sigmasys.bsinas.gwt.client.util.StringUtils;
import com.sigmasys.bsinas.gwt.client.view.widget.value.DateRangeValue;
import com.sigmasys.bsinas.model.Constants;

import com.sigmasys.bsinas.gwt.client.service.validator.*;

import java.util.Date;

/**
 * DateRangeField.
 *
 * @author Michael Ivanov
 */
public class DateRangeField extends AbstractRangeField<Date, DateRangeValue, DateField> {

    public static final DateTimeFormat DEFAULT_DATE_FORMAT = DateTimeFormat.getFormat(Constants.DATE_FORMAT_US);

    private DateTimeFormat dateFormat;

    private static class InternalDateField extends DateField {

        private final DateFormatValidator formatValidator;
        private String rawValue;

        private InternalDateField(DateRangeField dateRangeField) {
            formatValidator = new DateFormatValidator();
            getPropertyEditor().setFormat(dateRangeField.getDateFormat());
            Listener<ComponentEvent> keyListener = new Listener<ComponentEvent>() {
                @Override
                public void handleEvent(ComponentEvent be) {
                    rawValue = getRawValue();
                }
            };
            Listener<ComponentEvent> blurListener = new Listener<ComponentEvent>() {
                @Override
                public void handleEvent(ComponentEvent be) {
                    if (!StringUtils.isEmpty(getRawValue())) {
                        setRawValue(rawValue);
                    }
                    validateValue(getRawValue());
                }
            };
            getDatePicker().addListener(Events.Select, new Listener<DatePickerEvent>() {
                @Override
                public void handleEvent(DatePickerEvent be) {
                    Date pickerDate = be.getDate();
                    if (pickerDate != null) {
                        rawValue = getPropertyEditor().getFormat().format(pickerDate);
                    }
                }
            });
            addListener(Events.OnBlur, blurListener);
            addListener(Events.KeyUp, keyListener);
            addListener(Events.OnMouseUp, keyListener);

        }

        @Override
        protected boolean validateValue(String value) {
            if (StringUtils.isEmpty(value) && !getAllowBlank()) {
                setRawValue(rawValue);
                value = rawValue;
            }
            boolean isValid = true;
            String errorMessage = formatValidator.validate(this, value);
            if (errorMessage != null) {
                markInvalid(errorMessage);
                isValid = false;
            }
            if (isValid) {
                isValid = super.validateValue(value);
            }
            if (!isValid) {
                // if the date field was not valid - restore the date picker with the original value if it is not null
                if (getOriginalValue() != null) {
                    getDatePicker().setValue(getOriginalValue(), true);
                }
            }
            return isValid;
        }
        
        public DateFormatValidator getFormatValidator() {
        	return this.formatValidator;
        }
    }

    public DateRangeField() {
        this("from", "to");
    }

    public DateRangeField(String emptyTextFrom, String emptyTextTo) {
        this(Orientation.HORIZONTAL, emptyTextFrom, emptyTextTo, 94, 6);
    }

    public DateRangeField(Style.Orientation ori, String emptyTextFrom, String emptyTextTo, int width, int spacing) {

        dateFormat = DEFAULT_DATE_FORMAT;

        InternalDateField dateFrom = new InternalDateField(this);
        InternalDateField dateTo = new InternalDateField(this);

        init(dateFrom, dateTo);

        setOrientation(ori);

        getFrom().setWidth(width);
        getFrom().setEmptyText(emptyTextFrom);

        getTo().setWidth(width);
        getTo().setEmptyText(emptyTextTo);

        setSpacing(spacing);

        setAllowBlank(true);

        // validator: check that dateFrom is not later than dateTo
        DateRangeFormatValidator rangeValidator = new DateRangeFormatValidator(getFrom(), getTo());
        rangeValidator.getFormatValidator().setStrictFormat(false);
        addValidator(rangeValidator);
    }

    public void setDateFormat(DateTimeFormat dateFormat) {
        this.dateFormat = dateFormat;
        
        getFrom().setMessageTarget("tooltip");
        getTo().setMessageTarget("tooltip");
    }

    public DateTimeFormat getDateFormat() {
        return dateFormat;
    }

    /* (non-Javadoc)
      * @see com.extjs.gxt.ui.client.widget.form.Field#getValue()
      */

    @Override
    public DateRangeValue getValue() {
        DateRangeValue value = new DateRangeValue();
        value.setFrom(getFrom().getValue());
        value.setTo(getTo().getValue());
        return value;
    }

    @Override
    public DateRangeValue getOriginalValue() {
        DateRangeValue value = new DateRangeValue();
        value.setFrom(getFrom().getOriginalValue());
        value.setTo(getTo().getOriginalValue());
        return value;
    }

	public boolean isStrictFormat() {
		return ((InternalDateField)getFrom()).getFormatValidator().isStrictFormat();
	}

	public void setStrictFormat(boolean strictFormat) {
		((InternalDateField)getFrom()).getFormatValidator().setStrictFormat(strictFormat);
		((InternalDateField)getTo()).getFormatValidator().setStrictFormat(strictFormat);
	}
    
    

}
