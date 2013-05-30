package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;

import com.sigmasys.bsinas.gwt.client.service.validator.*;

import java.util.Date;

/**
 * DateTimeField
 *
 * @author Michael Ivanov
 */
public class DateTimeField extends Field<Date> implements Listener<BaseEvent> {

    private static final String DEFAULT_DATE_FORMAT_STRING = "MM/dd/yyyy";
    private static final String DEFAULT_TIME_FORMAT_STRING = "HH:mm";
    private static final String DATE_TIME_SEPARATOR = " ";

    public static final DateTimeFormat DEFAULT_DATE_FORMAT = DateTimeFormat.getFormat(DEFAULT_DATE_FORMAT_STRING);
    public static final DateTimeFormat DEFAULT_TIME_FORMAT = DateTimeFormat.getFormat(DEFAULT_TIME_FORMAT_STRING);

    public static final int DEFAULT_DATE_FIELD_WIDTH = 100;
    public static final int DEFAULT_TIME_FIELD_WIDTH = 60;

    private EmbeddedDateField dateField;
    private EmbeddedTimeField timeField;

    private HorizontalPanel layoutContainer;

    private Integer spacing;

    public DateTimeField() {
        this(DEFAULT_DATE_FORMAT, DEFAULT_TIME_FORMAT);
    }

    public DateTimeField(String dateFormat, String timeFormat) {
        this(DateTimeFormat.getFormat(dateFormat), DateTimeFormat.getFormat(timeFormat));
    }

    void setWidths(int dateFieldWidth, int timeFieldWidth) {
        if (dateFieldWidth > 0) {
            dateField.setWidth(dateFieldWidth);
        }
        if (timeFieldWidth > 0) {
            timeField.setWidth(timeFieldWidth);
        }
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

    private DateTimeField(DateTimeFormat dateFormat, DateTimeFormat timeFormat) {
        propertyEditor = new DateTimePropertyEditor(DateTimeFormat.getFormat(dateFormat.getPattern() + DATE_TIME_SEPARATOR + timeFormat.getPattern()));

        timeField = new EmbeddedTimeField();
        timeField.setFormat(timeFormat);

        dateField = new EmbeddedDateField(timeField);
        dateField.setPropertyEditor(new DateTimePropertyEditor(dateFormat));
        dateField.addListener(Events.Invalid, this);
        timeField.addListener(Events.Invalid, this);

        timeField.setValidator(TimeFormatValidator.minutes());

        setWidths(DEFAULT_DATE_FIELD_WIDTH, DEFAULT_TIME_FIELD_WIDTH);

    }

    @Override
    public String getRawValue() {
        String res = dateField.getRawValue() + DATE_TIME_SEPARATOR + timeField.getRawValue();
        return res.trim();
    }

    @Override
    public void setRawValue(String value) {
        String[] splitted = split(value);
        dateField.setRawValue(splitted[0]);
        timeField.setRawValue(splitted[1]);
    }

    @Override
    public void disable() {
        dateField.disable();
        timeField.disable();
        super.disable();
    }

    @Override
    public void enable() {
        dateField.enable();
        timeField.enable();
        super.enable();
    }

    private static String[] split(String rawValue) {
        String[] res = new String[]{"", ""};
        if (rawValue != null) {
            String[] params = rawValue.split(DATE_TIME_SEPARATOR, 2);
            if (params.length > 0) {
                res[0] = params[0];
            }
            if (params.length > 1) {
                res[1] = params[1];
            }
        }
        return res;
    }

    @Override
    protected boolean validateValue(String value) {
        String[] splitted = split(value);

        boolean res = timeField.validateValue(splitted[1]) & dateField.validateValue(splitted[0]);
        if (!res || (splitted[0].length() == 0 && splitted[1].length() == 0)) {
            /* && allowBlank; which is true */
            return res;
        }
        if (splitted[0].length() == 0 && splitted[1].length() > 0) {
            dateField.markInvalid(dateField.getMessages().getBlankText());
            return false;
        }

        if (splitted[1].length() == 0 && splitted[0].length() > 0) {
            timeField.markInvalid(timeField.getMessages().getBlankText());
            return false;
        }
        return true;
    }

    public DateField getDateField() {
        return dateField;
    }

    public TimeField getTimeField() {
        return timeField;
    }

    @Override
    protected void onRender(Element parent, int index) {
        // need to add extra div to fight quirks with error marks
        layoutContainer = new HorizontalPanel();

        LayoutContainer innerContainer = new HorizontalPanel();

        if (spacing != null) {
            timeField.setStyleAttribute("margin-left", spacing + "px");
        }

        innerContainer.add(dateField);
        innerContainer.add(timeField);
        layoutContainer.add(innerContainer);

        layoutContainer.render(parent, index);

        setElement(layoutContainer.getElement());

    }

    static class EmbeddedDateField extends DateField {

        EmbeddedTimeField timeField;

        public EmbeddedDateField(EmbeddedTimeField timeField) {
            this.timeField = timeField;
        }

        @Override
        // NOTE: "public" access modifier
        public boolean validateValue(String value) {
            return super.validateValue(value);
        }

        protected void alignErrorIcon() {
            DeferredCommand.addCommand(new Command() {
                public void execute() {
                    errorIcon.el().alignTo(timeField.getElement(), "tl-tr", new int[]{2, 3});
                }
            });
        }

        public void onAttach() {
            super.onAttach();
            // Problems when rendering into hidden
            // (display:none) panels
            // then hack from TriggerField source will not work because
            // getY() will
            // be 0 for both trigger and input
            if (GXT.isIE && !isHideTrigger()) {
                input.makePositionable();
                input.setTop(0);
            }
        }

    }

    static class EmbeddedTimeField extends TimeField {
        @Override
        // NOTE: "public" access modifier
        public boolean validateValue(String value) {
            return super.validateValue(value);
        }

        public void onAttach() {
            super.onAttach();
            // Problems when rendering into hidden
            // (display:none) panels
            // then hack from TriggerField source will not work because
            // getY() will
            // be 0 for both trigger and input
            if (GXT.isIE && !isHideTrigger()) {
                input.makePositionable();
                input.setTop(0);
            }
        }

    }

    public void handleEvent(BaseEvent be) {
        if (be instanceof FieldEvent && be.getType() == Events.Invalid && (be.getSource() == dateField || be.getSource() == timeField)) {
            FieldEvent fe = new FieldEvent(this);
            fe.setMessage(((FieldEvent) be).getMessage());
            fireEvent(Events.Invalid, fe);
        }

    }

    protected void alignErrorIcon() {
        DeferredCommand.addCommand(new Command() {
            public void execute() {
                errorIcon.el().alignTo(timeField.getElement(), "tl-tr", new int[]{2, 3});
            }
        });
    }

    @Override
    public void clearInvalid() {
        super.clearInvalid();
        getTimeField().clearInvalid();
        getDateField().clearInvalid();
    }

    public Integer getSpacing() {
        return spacing;
    }

    public void setSpacing(Integer spacing) {
        this.spacing = spacing;
    }
}
