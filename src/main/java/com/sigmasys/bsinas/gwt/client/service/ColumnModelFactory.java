package com.sigmasys.bsinas.gwt.client.service;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.sigmasys.bsinas.gwt.client.view.AbstractListPanel;

import java.util.List;

/**
 * ColumnModelFactory
 *
 * @author Michael Ivanov
 */
public interface ColumnModelFactory<M extends BaseModel> {

    // To make it list panel aware
    void setListPanel(AbstractListPanel<M> listPanel);

    // To process grid pre loading
    void processPostLoading(LoadEvent be);

    ColumnModel getColumnModel();

    List<ColumnConfig> getColumnConfigs();

}
