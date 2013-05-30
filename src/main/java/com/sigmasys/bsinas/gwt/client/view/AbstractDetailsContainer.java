package com.sigmasys.bsinas.gwt.client.view;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.sigmasys.bsinas.gwt.client.view.widget.WidgetFactory;
import com.sigmasys.bsinas.model.Constants;

import java.util.Date;

/**
 * AbstractDetailsContainer
 *
 * @author Michael Ivanov
 */
public class AbstractDetailsContainer extends ContentPanel {

    protected static final DateTimeFormat DATE_DISPLAY_FORMAT = DateTimeFormat.getFormat(Constants.DATE_FORMAT_US);
    protected static final DateTimeFormat TIMESTAMP_DISPLAY_FORMAT = DateTimeFormat.getFormat(Constants.TIMESTAMP_FORMAT);
    protected static final DateTimeFormat TIME_DISPLAY_FORMAT = DateTimeFormat.getFormat(Constants.TIME_FORMAT);
    protected static final DateTimeFormat TIMESTAMP_DISPLAY_FORMAT_NO_MS = DateTimeFormat.getFormat(Constants.TIMESTAMP_FORMAT_NO_MS);
    protected static final NumberFormat DOUBLE2_DISPLAY_FORMAT = NumberFormat.getFormat("#,##0.00");
    protected static final NumberFormat LONG_DISPLAY_FORMAT = NumberFormat.getFormat("#,##0");
    protected static final TableData leftAlign = new TableData(HorizontalAlignment.LEFT, VerticalAlignment.MIDDLE);
    protected static final TableData rightAlignNoWrap = new TableData(HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
    protected static final TableData rightAlignWrap = new TableData(HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
    public static final String COLON = ":";

    static {
        leftAlign.setStyle("whiteSpace: nowrap;");
        rightAlignNoWrap.setStyle("whiteSpace: nowrap;");
    }

    public AbstractDetailsContainer() {
        TableLayout layout = new TableLayout(1);
        layout.setCellHorizontalAlign(HorizontalAlignment.LEFT);
        layout.setCellVerticalAlign(VerticalAlignment.TOP);
        setLayout(layout);
        setHeaderVisible(false);
        setScrollMode(Scroll.AUTO);
        setBodyBorder(false);
    }

    public static void addTo(LayoutContainer container, String label, Text value, boolean isRightCellNoWrap) {
        addTo(container, label, null, value, isRightCellNoWrap);
    }

    public static void addTo(LayoutContainer container, String label, String tooltip, Text value, boolean isRightCellNoWrap) {
        Text labelWidget = WidgetFactory.createText(label + ((label != null && label.length() > 0) ? COLON : ""));
        if (tooltip != null) {
            labelWidget.setToolTip(tooltip);
            value.setToolTip(tooltip);
        }
        labelWidget.setStyleAttribute("margin-right", "5px");
        container.add(labelWidget, leftAlign);
        container.add(value, isRightCellNoWrap ? rightAlignNoWrap : rightAlignWrap);
    }

    public static void addTo(LayoutContainer container, String label, Text value) {
        addTo(container, label, value, true);
    }

    public static void addTo(LayoutContainer container, String label, String tooltip, Text value) {
        addTo(container, label, tooltip, value, true);
    }

    public static String displayDouble(Double number) {
        return number == null ? "" : number.toString();
    }

    public static String displayDouble2(Double number) {
        return number == null ? "" : DOUBLE2_DISPLAY_FORMAT.format(number);
    }

    public static String displayLong(Long number) {
        return number == null ? "" : LONG_DISPLAY_FORMAT.format(number);
    }

    public static String displayInt(Integer number) {
        return number == null ? "" : LONG_DISPLAY_FORMAT.format(number);
    }

    public static String displayText(String text) {
        return text == null ? "" : text.trim();
    }

    public static String displayDate(Date date) {
        return date == null ? "" : DATE_DISPLAY_FORMAT.format(date);
    }

    public static String displayTimeStamp(Date date) {
        return date == null ? "" : TIMESTAMP_DISPLAY_FORMAT.format(date);
    }

    public static String displayTimeOnly(Date date) {
        return date == null ? "" : TIME_DISPLAY_FORMAT.format(date);
    }

    public static String displayTimestampNoMs(Date date) {
        return date == null ? "" : TIMESTAMP_DISPLAY_FORMAT_NO_MS.format(date);
    }


    protected FieldSet createFieldSet(String heading, boolean collapsible) {
        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeading(heading);
        fieldSet.setCollapsible(collapsible);
        TableLayout tl = new TableLayout(2);
        fieldSet.setLayout(tl);
        return fieldSet;
    }

}
