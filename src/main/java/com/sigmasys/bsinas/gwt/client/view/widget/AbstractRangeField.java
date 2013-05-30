package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.*;
import com.extjs.gxt.ui.client.widget.*;
import com.extjs.gxt.ui.client.widget.form.GxtUtils;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.google.gwt.user.client.Element;
import com.sigmasys.bsinas.gwt.client.view.widget.value.AbstractRangeValue;
import com.sigmasys.bsinas.gwt.client.service.validator.*;

import java.io.Serializable;
import java.util.List;

/**
 * AbstractRangeField
 *
 * @author Michael Ivanov
 */
public abstract class AbstractRangeField<V extends Serializable, T extends AbstractRangeValue<V>, C extends TextField<V>>
        extends AbstractFieldContainer<V, T, C> {

    private Orientation orientation;
    private int spacing;

    private C from;
    private C to;

    private Text fromLabel;
    private Text toLabel;

    private FormatValidators toValidators;
    private FormatValidators fromValidators;


    protected AbstractRangeField() {
    }

    protected AbstractRangeField(C from, C to) {
        init(from, to);
    }

    protected AbstractRangeField(C from, C to, String fromLabelValue, String toLabelValue) {
        init(from, to, fromLabelValue, toLabelValue);
    }

    protected void init(C from, C to) {
        init(from, to, null, null);
    }

    protected void init(C from, C to, String fromLabelValue, String toLabelValue) {

        this.from = from;
        this.to = to;
        orientation = Orientation.VERTICAL;

        fromValidators = new FormatValidators();
        toValidators = new FormatValidators();
        getFrom().setValidator(fromValidators);
        getTo().setValidator(toValidators);

        if (fromLabelValue != null && toLabelValue != null) {
            fromLabel = WidgetFactory.createText(fromLabelValue + "&nbsp;");
            toLabel = WidgetFactory.createText(toLabelValue + "&nbsp;");
        }

        addField(this.from);
        addField(this.to);

        validateOnBlur();
    }


    public int getSpacing() {
        return spacing;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    protected void onRender(Element target, int index) {
        boolean vertical = orientation == Orientation.VERTICAL;
        if (vertical) {
            setLayoutContainer(new VerticalPanel());
        } else {
            setLayoutContainer(new HorizontalPanel());
        }

        List<C> fields = getFields();
        for (int i = 0; i < fields.size(); i++) {
            C f = fields.get(i);
            String style = "position: static;";
            if (vertical && (i != (fields.size() - 1)) && spacing > 0) {
                style += "padding-bottom:" + spacing + "px;";
            } else if (!vertical && spacing > 0) {
                style += "padding-right:" + spacing + "px;";
            }
            if (i == 0 && fromLabel != null) {
                getLayoutContainer().add(fromLabel, getLayoutData(fromLabel));
            } else if (i == 1 && toLabel != null) {
                getLayoutContainer().add(toLabel, getLayoutData(toLabel));
            }
            getLayoutContainer().add(f, getLayoutData(f, style));
        }

        getLayoutContainer().render(target, index);
        setElement(getLayoutContainer().getElement());
    }

    protected LayoutData getLayoutData(Component c) {
        return getLayoutData(c, null);
    }

    protected LayoutData getLayoutData(Component c, String style) {
        LayoutData data = ComponentHelper.getLayoutData(c);
        if (data == null) {
            data = new TableData();
        }
        if (data instanceof TableData) {
            TableData tableData = (TableData) data;
            tableData.setVerticalAlign(Style.VerticalAlignment.MIDDLE);
            if (style != null) {
                tableData.setStyle(style);
            }
        }
        return data;
    }

    protected El getInputEl() {
        return GxtUtils.getInputEl(from);
    }

    public C getFrom() {
        return from;
    }

    public C getTo() {
        return to;
    }

    @Override
    public void setValue(T value) {
        getFrom().setValue((value != null) ? value.getFrom() : null);
        getTo().setValue((value != null) ? value.getTo() : null);
    }

    @Override
    public void setOriginalValue(T value) {
        getFrom().setOriginalValue((value != null) ? value.getFrom() : null);
        getTo().setOriginalValue((value != null) ? value.getTo() : null);
    }

    @Override
    public void reset() {
        getFrom().reset();
        getTo().reset();
    }


    public void setId(String id) {
        super.setId(id);
        getFrom().setId(id + "-from");
        getTo().setId(id + "-to");
    }

    protected void resetTo(T resetValue) {
        getFrom().setValue(resetValue.getFrom());
        getTo().setValue(resetValue.getTo());
    }

    @Override
    public void addListener(EventType eventType, Listener<? extends BaseEvent> listener) {
        getFrom().addListener(eventType, listener);
        getTo().addListener(eventType, listener);
    }

    @Override
    public void clearInvalid() {
        super.clearInvalid();
        getFrom().clearInvalid();
        getTo().clearInvalid();
    }

    @Override
    public boolean validate() {
        return super.validate() && getFrom().validate() && getTo().validate();
    }

    public void addFromValidator(Validator validator) {
        fromValidators.addValidator(validator);
    }

    public void addToValidator(Validator validator) {
        toValidators.addValidator(validator);
    }

    public void addValidator(Validator validator) {
        addFromValidator(validator);
        addToValidator(validator);
    }

    public void setAllowBlank(boolean allowBlank) {
        getFrom().setAllowBlank(allowBlank);
        getTo().setAllowBlank(allowBlank);
    }

    @Override
    public boolean isValid() {
        return super.isValid() && getFrom().isValid() && getTo().isValid();
    }

    protected void validateOnBlur() {
        Listener<ComponentEvent> blurListener = new Listener<ComponentEvent>() {
            @Override
            public void handleEvent(ComponentEvent be) {
                validate();
            }
        };
        addListener(Events.OnBlur, blurListener);
    }
}
