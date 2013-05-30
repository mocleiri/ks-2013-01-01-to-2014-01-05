package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.sigmasys.bsinas.gwt.client.service.validator.TimeFormatValidator;
import com.sigmasys.bsinas.gwt.client.view.widget.value.TimeRangeValue;
import com.sigmasys.bsinas.gwt.client.view.widget.value.TimeValue;
import com.sigmasys.bsinas.model.Constants;

import java.util.Date;

/**
 * TimeRangeField.
 *
 * @author Michael Ivanov
 */
public class TimeRangeField extends AbstractRangeField<TimeValue, TimeRangeValue, TimeField> {

    public static final DateTimeFormat DEFAULT_TIME_FORMAT = DateTimeFormat.getFormat(Constants.TIME_FORMAT_NO_MS);

    private DateTimeFormat timeFormat;

    private final Validator timeRangeValidator = new Validator() {

        @Override
        public String validate(Field<?> field, String value) {
            TimeFormatValidator fromTimeValidator = getFrom().getFormatValidator();
            TimeFormatValidator toTimeValidator = getTo().getFormatValidator();
            if (fromTimeValidator.validate(getFrom(), getFrom().getRawValue()) == null &&
                    toTimeValidator.validate(getTo(), getTo().getRawValue()) == null) {
                String fromMessage = null;
                String toMessage = null;
                Date fromDate = null;
                Date toDate = null;
                try {
                    fromDate = timeFormat.parse(getFrom().getRawValue());
                } catch (Exception ex) {
                    fromMessage = "Valid format is " + timeFormat.getPattern();
                }
                try {
                    toDate = timeFormat.parse(getTo().getRawValue());
                } catch (Exception ex) {
                    toMessage = "Valid format is " + timeFormat.getPattern();
                }
                if (getFrom().equals(field) && fromMessage != null) {
                    return fromMessage;
                }
                if (getTo().equals(field) && toMessage != null) {
                    return toMessage;
                }
                if (fromMessage == null && toMessage == null) {
                    if (toDate != null && fromDate != null && fromDate.compareTo(toDate) > 0) {
                        return "From time cannot be greater than To time";
                    }
                }
            }
            return null;
        }
    };

    public TimeRangeField(Orientation ori, String emptyTextFrom, String emptyTextTo, int width, int spacing,
                          String fromLabel, String toLabel) {

        super(new TimeField(), new TimeField(), fromLabel, toLabel);

        timeFormat = DEFAULT_TIME_FORMAT;

        setOrientation(ori);

        getFrom().setWidth(width);
        getFrom().setEmptyText(emptyTextFrom);

        getTo().setWidth(width);
        getTo().setEmptyText(emptyTextTo);

        setAllowBlank(true);

        setSpacing(spacing);

        // validator: check that timeFrom is not greater than timeTo
        addValidator(timeRangeValidator);
    }

    public TimeRangeField(Orientation ori, String emptyTextFrom, String emptyTextTo, int width, int spacing) {
        this(ori, emptyTextFrom, emptyTextTo, width, spacing, null, null);
    }

    public TimeRangeField() {
        this(null, null);
    }

    public TimeRangeField(String fromLabel, String toLabel) {
        this(Orientation.HORIZONTAL, "from", "to", 94, 6, fromLabel, toLabel);
    }

    /* (non-Javadoc)
      * @see com.extjs.gxt.ui.client.widget.form.Field#getValue()
      */

    @Override
    public TimeRangeValue getValue() {
        TimeRangeValue value = new TimeRangeValue();
        value.setFrom(getFrom().getValue());
        value.setTo(getTo().getValue());
        return value;
    }

    @Override
    public TimeRangeValue getOriginalValue() {
        TimeRangeValue value = new TimeRangeValue();
        value.setFrom(getFrom().getOriginalValue());
        value.setTo(getTo().getOriginalValue());
        return value;
    }

    public DateTimeFormat getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(DateTimeFormat timeFormat) {
        this.timeFormat = timeFormat;
        if (Constants.TIME_FORMAT_NO_MS.equalsIgnoreCase(timeFormat.getPattern())) {
            getFrom().setFormatValidator(TimeFormatValidator.seconds());
            getTo().setFormatValidator(TimeFormatValidator.seconds());
        } else if (Constants.TIME_FORMAT_MINUTES.equalsIgnoreCase(timeFormat.getPattern())) {
            getFrom().setFormatValidator(TimeFormatValidator.minutes());
            getTo().setFormatValidator(TimeFormatValidator.minutes());
        } else {
            getFrom().setFormatValidator(new TimeFormatValidator());
            getTo().setFormatValidator(new TimeFormatValidator());
        }
    }

}
