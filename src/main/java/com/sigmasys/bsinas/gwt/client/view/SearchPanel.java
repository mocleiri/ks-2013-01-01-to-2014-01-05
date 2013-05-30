package com.sigmasys.bsinas.gwt.client.view;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.sigmasys.bsinas.gwt.client.model.SearchCriteria;

public interface SearchPanel<M extends BaseModel> {

    void collapse();

    void expand();

    void setCompositePanel(AbstractCompositePanel<M> compositePanel);

    void setListPanel(AbstractListPanel<M> listPanel);

    void setDetailsPanel(AbstractDetailsPanel<M> detailsPanel);

    void submitForm();

    boolean isTopPanel();

    void updateFormWithSearchCriteria(SearchCriteria searchCriteria);

    SearchCriteria getSearchCriteria();
}
