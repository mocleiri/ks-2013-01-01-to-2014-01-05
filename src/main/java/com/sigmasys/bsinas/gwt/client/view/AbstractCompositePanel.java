package com.sigmasys.bsinas.gwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.sigmasys.bsinas.gwt.client.model.SearchCriteria;

/**
 * AbstractCompositePanel
 *
 * @param <M>
 */
public class AbstractCompositePanel<M extends BaseModel> extends LayoutContainer {

    private final SearchPanel<M> searchPanel;
    private final AbstractListPanel<M> listPanel;
    private final AbstractDetailsPanel<M> detailsPanel;

    private boolean searchOnOpen;
    private boolean isFirstTime = true;

    public AbstractCompositePanel(SearchPanel<M> searchPanel,
                                  AbstractListPanel<M> listPanel,
                                  AbstractDetailsPanel<M> detailsPanel,
                                  float westWidth,
                                  float southHeight,
                                  boolean searchOnOpen) {
        this(searchPanel, listPanel, detailsPanel, westWidth, 200, southHeight, searchOnOpen);
    }

    public AbstractCompositePanel(SearchPanel<M> searchPanel,
                                  AbstractListPanel<M> listPanel,
                                  AbstractDetailsPanel<M> detailsPanel,
                                  float westWidth,
                                  float centerHeight,
                                  float southHeight,
                                  boolean searchOnOpen) {

        this.listPanel = listPanel;
        this.detailsPanel = detailsPanel;
        this.searchPanel = searchPanel;
        this.searchOnOpen = searchOnOpen;

        setLayout(new BorderLayout());

        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER, centerHeight);

        BorderLayoutData southData;
        if (listPanel != null && detailsPanel != null) {
            southData = new BorderLayoutData(LayoutRegion.SOUTH, southHeight);
            southData.setSplit(true);
            southData.setCollapsible(true);
            southData.setFloatable(true);
            southData.setMargins(new Margins(5, 0, 0, 0));
            detailsPanel.setListPanel(listPanel);
            listPanel.setDetailsPanel(detailsPanel);
        } else {
            southData = null;
        }

        if (searchPanel != null) {

            searchPanel.setCompositePanel(this);
            searchPanel.setListPanel(listPanel);
            searchPanel.setDetailsPanel(detailsPanel);

            if (listPanel != null) {
                listPanel.setSearchPanel(searchPanel);
            }

            LayoutContainer rightPane;
            if (listPanel != null && detailsPanel != null) {
                rightPane = new LayoutContainer(new BorderLayout());
                if (listPanel instanceof LayoutDataAware) {
                    ((LayoutDataAware) listPanel).setLayoutData(centerData);
                }
                if (detailsPanel instanceof LayoutDataAware) {
                    ((LayoutDataAware) detailsPanel).setLayoutData(southData);
                }
                rightPane.add(listPanel, centerData);
                rightPane.add(detailsPanel, southData);
            } else {
                rightPane = listPanel;
            }

            LayoutRegion region = searchPanel.isTopPanel() ? LayoutRegion.NORTH : LayoutRegion.WEST;

            BorderLayoutData westData = new BorderLayoutData(region, westWidth);
            westData.setSplit(true);
            westData.setCollapsible(true);
            westData.setFloatable(true);
            westData.setMargins(new Margins(0, 5, 0, 0));

            if (searchPanel instanceof LayoutDataAware) {
                ((LayoutDataAware) searchPanel).setLayoutData(westData);
            }
            add((Widget) searchPanel, westData);

            if (rightPane != null) {
                if (rightPane instanceof LayoutDataAware) {
                    ((LayoutDataAware) rightPane).setLayoutData(centerData);
                }
                add(rightPane, centerData);
            }
        } else if (listPanel != null) {
            if (listPanel instanceof LayoutDataAware) {
                ((LayoutDataAware) listPanel).setLayoutData(centerData);
            }
            add(listPanel, centerData);
            if (detailsPanel != null) {
                if (detailsPanel instanceof LayoutDataAware) {
                    ((LayoutDataAware) detailsPanel).setLayoutData(southData);
                }
                add(detailsPanel, southData);
            }
        }
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        if (searchPanel != null) {
            searchPanel.expand();
        }

        if (searchOnOpen && isFirstTime) {
            isFirstTime = false;
            Log.debug("AbstractCompositePanel (" + getClass() + ") search()");
            Timer t = new Timer() {
                @Override
                public void run() {
                    search();
                }
            };
            t.schedule(10);
        }
    }

    public SearchPanel<M> getSearchPanel() {
        return searchPanel;
    }

    public AbstractListPanel<M> getListPanel() {
        return listPanel;
    }

    public AbstractDetailsPanel<M> getDetailsPanel() {
        return detailsPanel;
    }

    public void search() {
        search(null);
    }

    public void search(SearchCriteria searchCriteria) {
        if (isRendered()) {
            SearchPanel<M> sp = getSearchPanel();
            if (sp != null) {
                if (searchCriteria != null) {
                    sp.updateFormWithSearchCriteria(searchCriteria);
                }
                sp.submitForm();
            }
        }
    }

}
