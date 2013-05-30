package com.sigmasys.bsinas.gwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.*;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.*;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sigmasys.bsinas.gwt.client.model.NavigationContext;
import com.sigmasys.bsinas.gwt.client.model.SearchCriteria;
import com.sigmasys.bsinas.gwt.client.service.ColumnModelFactory;
import com.sigmasys.bsinas.gwt.client.service.GwtErrorHandler;
import com.sigmasys.bsinas.gwt.client.view.widget.GenericPagingToolBar;
import com.sigmasys.bsinas.gwt.client.view.widget.PageSizeSelectableToolBar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractListPanel<M extends BaseModel> extends ContentPanel {

    public static final int DEFAULT_NUMBER_OF_ITEMS_PER_PAGE = 50;

    private Grid<M> grid;
    private GenericPagingToolBar pagingToolBar;
    private SearchCriteria searchCriteria;

    private Button selectOnAllPagesItem;
    private LabelToolItem statusLabel;

    private AbstractDetailsPanel<M> detailsPanel;
    private SearchPanel<M> searchPanel;

    private Boolean selectFirstRow;

    protected BasePagingLoader<PagingLoadResult<M>> pagingLoader;

    protected boolean isSelectOnAllPages;

    private boolean showNoMatchingRecordsMessage = true;

    boolean loadFirstPageOnCreation;
    boolean firstTime = true;

    private int selectedAllTotalCount;

    public AbstractListPanel() {
        this(null, false);
    }

    public AbstractListPanel(boolean loadFirstPageOnCreation) {
        this(null, loadFirstPageOnCreation);
    }

    /*
     * Do nto select first row after load
     */
    public AbstractListPanel(SearchCriteria criteria, boolean loadFirstPageOnCreation) {
        this(criteria, loadFirstPageOnCreation, false);
    }

    public AbstractListPanel(NavigationContext navigationContext) {
        this(navigationContext.getSearchCriteria(), false, false);
    }

    public AbstractListPanel(SearchCriteria criteria, boolean loadFirstPageOnCreation, boolean selectFirstRow) {

        this.loadFirstPageOnCreation = loadFirstPageOnCreation;
        if (isSelectOnAllPagesButtonEnabled()) {
            selectOnAllPagesItem = new Button("Select on all pages");
        }

        statusLabel = new LabelToolItem();

        setSelectFirstRow(selectFirstRow);

        setBodyBorder(true);
        setHeaderVisible(false);
        setButtonAlign(HorizontalAlignment.CENTER);
        setLayout(new FitLayout());

        setSearchCriteria(criteria);
    }

    /**
     * Used for the late component binding
     */
    protected void init() {

        Component topComponent = createTopComponent();
        if (topComponent != null) {
            setTopComponent(topComponent);
        }

        // **** Init Table Paging
        final RpcProxy<PagingLoadResult<M>> proxy = new RpcProxy<PagingLoadResult<M>>() {
            @Override
            protected void load(Object loadConfigObject, AsyncCallback<PagingLoadResult<M>> callback) {
                PagingLoadConfig loadConfig = (PagingLoadConfig) loadConfigObject;

                // CR 127,375
                if (loadConfig.getOffset() < 0) {
                    loadConfig.setOffset(0);
                }

                // page size is reverting to the default when sort
                // column is changed, so resetting to the current page size
                loadConfig.setLimit(pagingToolBar != null ? pagingToolBar.getPageSize() : getNumberOfItemsPerPage());

                // need to undo select before actual loading started
                // (selectAll constants in search criteria should be cleared for
                // example)
                undoSelectOnAllPages();
                loadData(loadConfig, callback);
            }
        };

        // Retrieving column model factory
        final ColumnModelFactory<M> columnModelFactory = getColumnModelFactory();
        columnModelFactory.setListPanel(this);

        pagingLoader = new BasePagingLoader<PagingLoadResult<M>>(proxy);
        pagingLoader.setRemoteSort(true);
        if (getSortDir() != null && getSortField() != null) {
            pagingLoader.setSortDir(getSortDir());
            pagingLoader.setSortField(getSortField());
        }

        pagingLoader.addListener(Loader.Load, new Listener<LoadEvent>() {
            public void handleEvent(LoadEvent be) {
                Object eventData = be.getData();
                if (eventData instanceof PagingLoadResult<?>
                        && (((PagingLoadResult<?>) eventData).getData() == null || ((PagingLoadResult<?>) eventData).getData().isEmpty())) {
                    if (isShowNoMatchingRecordsMessage()) {
                        Info.display("No Matching Records", "Please check search criteria and try again!");
                    }
                }
                // Always enable paging toolbar and grid after search
                setGridDisabled(false);
                setPagingToolbarDisabled(false);

                // To remove vertical scroll bar and show top of the grid.
                if (grid.getStore().getCount() > 0) {
                    grid.getView().focusRow(0);
                }

                columnModelFactory.processPostLoading(be);
                undoSelectOnAllPages();
            }
        });

        pagingLoader.addListener(Loader.Load, getLoadListener());
        pagingLoader.addListener(Loader.LoadException, getLoadExceptionListener());

        // store
        ListStore<M> store = new ListStore<M>(pagingLoader);
        ColumnModel cm = columnModelFactory.getColumnModel();

        CheckBoxSelectionModel<M> sm = null;
        if (isCheckBoxSelection()) {
            sm = new CheckBoxSelectionModel<M>();
            cm.getColumns().add(0, sm.getColumn());
        }

        grid = new Grid<M>(store, cm);
        grid.setWidth("100%");
        grid.setLoadMask(true);
        grid.setBorders(true);
        grid.setColumnLines(true);
        grid.getView().setAutoFill(true);

        if (isCheckBoxSelection()) {
            grid.setSelectionModel(sm);
            grid.addPlugin(sm);
        }

        grid.getSelectionModel().setSelectionMode(SelectionMode.MULTI);

        setGridDisabled(true);

        // empty row selection will be taken care of by selection change
        // listener
        if (isPagingToolbarOn()) {
            if (getAdditionalPageSizes() != null) {
                pagingToolBar = new PageSizeSelectableToolBar(getNumberOfItemsPerPage(), getAdditionalPageSizes());
            } else {
                pagingToolBar = new GenericPagingToolBar(getNumberOfItemsPerPage());
            }
            pagingToolBar.setId("grid-paging-toolbar");
            pagingToolBar.bind(pagingLoader);

            setBottomComponent(pagingToolBar);
        }
        setPagingToolbarDisabled(true);

        Menu contextMenu = createContextMenu();
        if (contextMenu != null) {
            grid.setContextMenu(contextMenu);
        }

        grid.setStyleAttribute("borderTop", "none");

        // Getting auto expand column name
        String autoExpandColumn = getAutoExpandColumn();
        if (autoExpandColumn != null && grid.getColumnModel().getColumnById(autoExpandColumn) != null) {
            grid.setAutoExpandColumn(autoExpandColumn);
            grid.setAutoExpandMax(3000);
        }

        add(grid);

        Listener<SelectionChangedEvent<M>> selectionChangeListener = new Listener<SelectionChangedEvent<M>>() {

            private long exitTime = 0L;
            private M prevSelection;

            private boolean objectsMatch(Object a, Object b) {
                if (a == null && b == null) {
                    return true;
                }
                if (a != null) {
                    return a.equals(b);
                }
                //in other cases a is null, b is not null. So, not equal
                return false;
            }

            public void handleEvent(SelectionChangedEvent<M> be) {
                long selectionTime = System.currentTimeMillis();

                if ((selectionTime - exitTime) <= 400 && objectsMatch(be.getSelectedItem(), prevSelection)) {
                    Log.debug("Event stopped. Reason: (selectionTime - exitTime) < 100 ms and same object selected");
                    be.setCancelled(true);
                    return;
                }
                try {
                    if (be == null) {
                        Log.debug("SelectionChangedEvent<M> == null");
                        return;
                    }

                    List<M> selList = be.getSelection();
                    if (selList == null || selList.size() == 0) {
                        Log.debug("SelectedItem is null");
                        onEmptyRowSelection();
                        return;
                    }
                    if (selList.size() == 1) {
                        Log.debug("SelectedItem size is 1");
                        onSingleRowSelection(selList.get(0));
                        return;
                    }
                    Log.debug("SelectedItem size > 1");
                    onMultipleRowSelection(selList);
                } catch (RuntimeException e) {
                    GwtErrorHandler.error(e);
                } finally {
                    exitTime = System.currentTimeMillis();
                    if (be != null) {
                        prevSelection = be.getSelectedItem();
                    }
                }
            }
        };

        grid.getSelectionModel().addListener(Events.SelectionChange, selectionChangeListener);

        getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<M>>() {
            public void handleEvent(StoreEvent<M> be) {
                synchronizeToolBar();
                if (be.getStore() == null || be.getStore().getModels() == null || be.getStore().getModels().isEmpty()) {
                    return;
                }
                // Selecting the first row if selectFirstRow is true
                if (isSelectFirstRow()) {
                    Log.debug("Selecting the first row... ");
                    grid.getSelectionModel().select(0, false);
                }
            }
        });

        // **** Select on All pages ********************
        if (isSelectOnAllPagesButtonEnabled()) {
            selectOnAllPagesItem.setTitle("Select on all pages");
            selectOnAllPagesItem.setIconStyle("icon-select-all");
            selectOnAllPagesItem.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent be) {
                    if (grid.getStore() == null || grid.getStore().getModels() == null || grid.getStore().getModels().isEmpty()) {
                        MessageBox.alert("Alert", "There are no items to select", null);
                        return;
                    }
                    selectOnAllPages();
                }
            });
        }

        // **** Status info ******************
        statusLabel.addStyleName("yellow-label");
        statusLabel.setVisible(false);
        synchronizeToolBar();
    }

    @Override
    protected void beforeRender() {
        init();
        super.beforeRender();
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        if (loadFirstPageOnCreation && firstTime) {
            firstTime = false;
            new Timer() {
                @Override
                public void run() {
                    Log.debug("AbstractListPanel (" + getClass() + ") loadPageWithZeroOffset()");
                    loadPageWithZeroOffset();
                }
            }.schedule(5);
        }
    }

    protected Listener<LoadEvent> getLoadListener() {
        return null;
    }

    protected Listener<LoadEvent> getLoadExceptionListener() {
        return new Listener<LoadEvent>() {
            public void handleEvent(LoadEvent be) {
                getGrid().unmask();
                getGrid().getStore().removeAll();
                GwtErrorHandler.error(be.exception);
            }
        };
    }

    protected int getNumberOfItemsPerPage() {
        return DEFAULT_NUMBER_OF_ITEMS_PER_PAGE;
    }

    protected void setGridDisabled(boolean disabled) {
        if (grid != null) {
            if (disabled) {
                grid.mask();
            } else {
                grid.unmask();
            }
        }
    }

    protected void setGridSortingDisabled(boolean disabled) {
        if (grid != null) {
            for (ColumnConfig column : grid.getColumnModel().getColumns()) {
                column.setSortable(disabled);
            }
        }
    }

    protected void setGridHeaderDisabled(boolean disabled) {
        if (grid != null) {
            ColumnHeader header = grid.getView().getHeader();
            if (disabled) {
                header.mask();
            } else {
                header.unmask();
            }
        }
    }

    protected void setPagingToolbarDisabled(boolean disabled) {
        if (pagingToolBar != null) {
            if (disabled) {
                pagingToolBar.mask();
            } else {
                pagingToolBar.unmask();
            }
        }
    }

    protected boolean isPagingToolbarOn() {
        return true;
    }

    public void setSelectFirstRow(Boolean selectFirstRow) {
        this.selectFirstRow = selectFirstRow;
    }

    public Boolean isSelectFirstRow() {
        return selectFirstRow;
    }

    public List<M> getSelectedItems() {
        return grid.getSelectionModel().getSelectedItems();
    }

    public M getSelectedItem() {
        return grid.getSelectionModel().getSelectedItem();
    }

    abstract protected Component createTopComponent();

    protected Menu createContextMenu() {
        return null;
    }

    public void loadPageWithZeroOffset() {
        pagingLoader.load(0, getNumberOfItemsPerPage());
    }

    public void loadPageWithCurrentOffsetAndLimit() {
        pagingLoader.load();
    }

    public void refreshGridView(boolean headerToo, M model) {
        List<M> models = new ArrayList<M>();
        models.add(model);
        refreshGridView(headerToo, models);
    }

    public void refreshGridView(boolean headerToo, List<M> models) {
        grid.getView().refresh(headerToo);
    }

    public void refreshGridRows(List<M> models) {
        for (M model : models) {
            refreshGridRow(model);
        }
    }

    public void refreshGridRow(M model) {
        StoreEvent<M> event = new StoreEvent<M>(getGrid().getStore());
        event.setModel(model);
        grid.getStore().fireEvent(Store.Update, event);
    }

    public void refreshGridView(boolean headerToo) {
        refreshGridView(headerToo, grid.getStore().getModels());
    }

    public void refreshGridViewOnly(boolean headerToo) {
        grid.getView().refresh(headerToo);
    }

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria != null ? searchCriteria : new SearchCriteria();
    }

    protected void synchronizeToolBar() {
        // TODO: refactor this method
    }

    protected void onMultipleRowSelection(Collection<M> items) {
        if (getDetailsPanel() != null) {
            getDetailsPanel().setItemsVisible(false);
        }
        synchronizeToolBar();
    }

    protected void onSingleRowSelection(M item) {
        Log.debug("On Single Row Selection");
        if (isSelectOnAllPages) {
            undoSelectOnAllPages();
        }
        if (getDetailsPanel() != null) {
            getDetailsPanel().updateViewAndRefresh(item);
        }
        synchronizeToolBar();
    }

    protected void onEmptyRowSelection() {
        hideDetailsPanelOnEmptyRowSelection();
        synchronizeToolBar();
    }

    // when the grid is auto refreshing itself - it is not always desirable to
    // hide open details

    protected void hideDetailsPanelOnEmptyRowSelection() {
        if (getDetailsPanel() != null) {
            getDetailsPanel().setItemsVisible(false);
        }
    }

    protected abstract ColumnModelFactory<M> getColumnModelFactory();

    protected abstract void loadData(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<M>> callback);

    public AbstractDetailsPanel<M> getDetailsPanel() {
        return detailsPanel;
    }

    public void setDetailsPanel(AbstractDetailsPanel<M> detailsPanel) {
        this.detailsPanel = detailsPanel;
    }

    public SearchPanel<M> getSearchPanel() {
        return searchPanel;
    }

    public void setSearchPanel(SearchPanel<M> searchPanel) {
        this.searchPanel = searchPanel;
    }

    public Grid<M> getGrid() {
        return grid;
    }

    protected abstract String getAutoExpandColumn();

    protected int getTotalCount() {
        return pagingLoader.getTotalCount();
    }

    protected void selectOnAllPages() {
        isSelectOnAllPages = true;
        grid.getSelectionModel().selectAll();
        if (isSelectOnAllPagesButtonEnabled()) {
            selectOnAllPagesItem.setVisible(false);
        }
        statusLabel.setLabel("All <b>" + getTotalCount() + "</b> selected");
        statusLabel.setVisible(true);
        setSelectedAllTotalCount(getTotalCount());
    }

    private void setSelectedAllTotalCount(int totalCount) {
        this.selectedAllTotalCount = totalCount;

    }

    protected int getSelectedAllTotalCount() {
        return selectedAllTotalCount;
    }

    protected void undoSelectOnAllPages() {
        if (isSelectOnAllPages) {
            isSelectOnAllPages = false;
            if (isSelectOnAllPagesButtonEnabled()) {
                selectOnAllPagesItem.setVisible(true);
            }
            statusLabel.setLabel(null);
            statusLabel.setVisible(false);
            setSelectedAllTotalCount(0);
        }
    }

    protected Button getSelectOnAllPagesItem() {
        return selectOnAllPagesItem;
    }

    protected LabelToolItem getStatusLabel() {
        return statusLabel;
    }

    /**
     * if returns null then GenericPagingToolBar will be used
     *
     * @return array of available sizez
     */
    protected int[] getAdditionalPageSizes() {
        return new int[]{100, 200};
    }

    public boolean isSelectOnAllPages() {
        return isSelectOnAllPages;
    }

    public GenericPagingToolBar getPagingToolBar() {
        return pagingToolBar;
    }

    public BasePagingLoader<PagingLoadResult<M>> getPagingLoader() {
        return pagingLoader;
    }

    protected SortDir getSortDir() {
        return null;
    }

    protected String getSortField() {
        return null;
    }

    public boolean isShowNoMatchingRecordsMessage() {
        return showNoMatchingRecordsMessage;
    }

    public void setShowNoMatchingRecordsMessage(boolean showNoMatchingRecordsMessage) {
        this.showNoMatchingRecordsMessage = showNoMatchingRecordsMessage;
    }

    public boolean isCheckBoxSelection() {
        return false;
    }

    public boolean isSelectOnAllPagesButtonEnabled() {
        return true;
    }
}
