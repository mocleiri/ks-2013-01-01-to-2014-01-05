package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.*;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.sigmasys.bsinas.gwt.client.model.StringModelData;
import com.sigmasys.bsinas.model.Constants;

import java.util.*;

/**
 * Creates different widgets
 *
 * @author Michael Ivanov
 */
public class WidgetFactory {

    public static final int DEFAULT_LIST_WIDTH = -1;
    public static final int DEFAULT_LIST_HEIGHT = 67;

    public static DateRangeField createDateRangeField() {
        return new DateRangeField();
    }

    public static EntityNameField createEntityNameField() {
        return new EntityNameField();
    }

    public static TimeRangeField createTimeRangeField() {
        return new TimeRangeField();
    }

    public static TextArea createTextArea(String label, boolean allowBlank) {
        TextArea field = new TextArea();
        field.setFieldLabel(label);
        field.setAllowBlank(allowBlank);
        field.setLabelSeparator(":");
        return field;
    }

    public static LabelField createLabelField(String label) {
        LabelField field = new LabelField();
        field.setFieldLabel(label);
        field.setLabelSeparator(":");
        return field;
    }

    public static Text createText(String text) {
        return WidgetFactory.createStyledText(text, "text-label");
    }

    public static Text createText(String text, String id) {
        return WidgetFactory.createStyledText(text, "text-label", id);
    }

    public static Text createTextBold(String text) {
        return WidgetFactory.createStyledText(text, "text-label-bold");
    }

    public static Text createTextBold(String text, String id) {
        return WidgetFactory.createStyledText(text, "text-label-bold", id);
    }

    public static Text createStyledText(String text, String styleName) {
        Text element = new LinkText(text);
        element.addStyleName(styleName);
        return element;
    }

    public static Text createStyledText(String text, String styleName, String id) {
        Text element = createStyledText(text, styleName);
        element.setId(id);
        return element;
    }

    public static <T extends StringModelData> ListViewAdapter<T> createListView(List<T> items) {
        return createListView(items, DEFAULT_LIST_HEIGHT);
    }

    public static <T extends StringModelData> ListViewAdapter<T> createListView(List<T> items, int height) {
        return createListView(items, StringModelData.DISPLAY_VALUE_KEY, height);
    }

    public static <T extends StringModelData> ListViewAdapter<T> createListView(List<T> items, int width, int height) {
        return createListView(items, StringModelData.DISPLAY_VALUE_KEY, width, height);
    }

    public static <T extends ModelData> ListViewAdapter<T> createListView(List<T> items, String displayValue, int height) {
        return createListView(items, displayValue, DEFAULT_LIST_WIDTH, height);
    }

    public static <T extends ModelData> ListViewAdapter<T> createListView(List<T> items, String displayValue,
                                                                          int width, int height) {
        return new ListViewAdapter<T>(createListViewForAdapter(items, displayValue, width, height));
    }

    public static <T extends StringModelData> ListView<T> createListViewForAdapter(List<T> items, int height) {
        return createListViewForAdapter(items, StringModelData.DISPLAY_VALUE_KEY, DEFAULT_LIST_WIDTH, height);
    }

    public static <T extends StringModelData> ListView<T> createListViewForAdapter(List<T> items,
                                                                                   int width, int height) {
        return createListViewForAdapter(items, StringModelData.DISPLAY_VALUE_KEY, width, height);
    }

    public static <T extends StringModelData> ListView<T> createListViewForAdapter(List<T> items) {
        return createListViewForAdapter(items, StringModelData.DISPLAY_VALUE_KEY, DEFAULT_LIST_WIDTH, DEFAULT_LIST_HEIGHT);
    }

    public static <T extends ModelData> ListView<T> createListViewForAdapter(List<T> items, String displayProperty,
                                                                             int width, int height) {
        ListView<T> listView = new ListView<T>();
        if (width != -1) {
            listView.setWidth(width);
        }
        if (height != -1) {
            listView.setHeight(height);
        }
        ListStore<T> store = new ListStore<T>();
        if (items != null) {
            store.add(items);
        }
        listView.setStore(store);
        listView.setDisplayProperty(displayProperty);
        return listView;
    }

    public static <T extends ModelData> ComboBox<T> createComboBox(List<T> values, String displayField) {
        ComboBox<T> combo = new ComboBox<T>();
        combo.setStore(new ListStore<T>());
        combo.setDisplayField(displayField);
        combo.setTriggerAction(TriggerAction.ALL);
        combo.getStore().add(values);
        return combo;
    }

    public static <T extends ModelData> ComboBox<T> createComboBox(String displayField) {
        return createComboBox(new ArrayList<T>(), displayField);
    }

    public static ComboBox<StringModelData> createComboBox(List<String> values) {
        ComboBox<StringModelData> combo = WidgetFactory.createComboBox();
        populateListStore(combo.getStore(), values);
        return combo;
    }

    public static ComboBox<StringModelData> createComboBox() {
        ComboBox<StringModelData> combo = new ComboBox<StringModelData>();
        combo.setStore(new ListStore<StringModelData>());
        combo.setDisplayField(StringModelData.VALUE_KEY);
        combo.setTriggerAction(TriggerAction.ALL);
        return combo;
    }

    public static DateField createDateField() {
        return createDateField("");
    }

    public static DateField createDateField(String label) {
        DateField date = new DateField();
        date.getPropertyEditor().setFormat(DateTimeFormat.getFormat(Constants.DATE_FORMAT_US));
        date.setFieldLabel(label);
        return date;
    }

    public static DateField createDateField(int width) {
        DateField f = createDateField();
        f.setWidth(width);
        return f;
    }

    public static DateField createDateField(String label, int width) {
        DateField f = createDateField(label);
        f.setWidth(width);
        return f;
    }

    public static void populateListStore(ListStore<StringModelData> store, String... values) {
        List<String> valueList = (values != null && values.length > 0) ?
                new ArrayList<String>(Arrays.asList(values)) : new ArrayList<String>();
        populateListStore(store, valueList);
    }

    public static void populateListStore(ListStore<StringModelData> store, List<String> values) {
        for (String value : values) {
            store.add(new StringModelData(value));
        }
    }

    public static TextField<String> createTextField(int width) {
        TextField<String> tf = new TextField<String>();
        tf.setWidth(width);
        return tf;
    }

    public static NumberField createNumberField(boolean allowDecimals, String format, Class<?> propEditorType) {
        NumberField nf = new NumberField();
        nf.setAllowDecimals(allowDecimals);
        nf.setFormat(NumberFormat.getFormat(format));
        nf.setPropertyEditorType(propEditorType);
        return nf;
    }
}
