package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.ListViewSelectionModel;
import com.extjs.gxt.ui.client.widget.form.AdapterField;

import java.util.Arrays;
import java.util.List;

/**
 * A field wrapper for ListView, primarily used for form bindings.
 *
 * @param <M> model type
 * @author Michael Ivanov
 */

public class ListViewAdapter<M extends ModelData> extends AdapterField {


    public ListViewAdapter() {
        this(new ListView<M>());
    }

    public ListViewAdapter(ListStore<M> listStore) {
        this(new ListView<M>(listStore));
    }

    public ListViewAdapter(ListView<M> listView) {
        super(listView);
        setResizeWidget(true);
    }

    public ListView<M> getListView() {
        return (ListView<M>) getWidget();
    }

    @Override
    public List<M> getValue() {
        return getListView().getSelectionModel().getSelectedItems();
    }

    public void setDisplayProperty(String propertyName) {
        getListView().setDisplayProperty(propertyName);
    }

    public void setSelectionModel(ListViewSelectionModel<M> selectionModel) {
        getListView().setSelectionModel(selectionModel);
    }

    public List<M> getSelectedItems() {
        return getListView().getSelectionModel().getSelectedItems();
    }

    @Override
    public void setValue(Object value) {
        super.setValue(value);
        deselectAll();
        if (value != null) {
            List<M> newValues = (value instanceof List<?>) ? (List<M>) value : Arrays.asList((M) value);
            getListView().getSelectionModel().select(newValues, false);
        }
    }

    public void populateStore(List<M> items) {
        ListStore<M> store = getListView().getStore();
        store.removeAll();
        store.add(items);
    }

    public void addToStore(M item) {
        ListStore<M> store = getListView().getStore();
        store.add(item);
    }

    public void deselectAll() {
        getListView().getSelectionModel().deselectAll();
    }

    public void selectAll() {
        getListView().getSelectionModel().selectAll();
    }

}
