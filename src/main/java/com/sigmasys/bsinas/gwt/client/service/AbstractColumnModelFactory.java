package com.sigmasys.bsinas.gwt.client.service;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.sigmasys.bsinas.gwt.client.view.AbstractListPanel;

import java.util.List;

/**
 * AbstractColumnModelFactory
 *
 * @author Michael Ivanov
 */
public abstract class AbstractColumnModelFactory<M extends BaseModel> implements ColumnModelFactory<M> {

    // To make it list panel aware - subclasses may want to override it if necessary
    public void setListPanel(AbstractListPanel<M> listPanel) {
        // Do nothing here
    }

    // To process grid pre loading
    public void processPostLoading(LoadEvent be) {
        // Do nothing here
    }

    public ColumnModel getColumnModel() {
        return new ColumnModel(getColumnConfigs());
    }

    public abstract List<ColumnConfig> getColumnConfigs();

}

