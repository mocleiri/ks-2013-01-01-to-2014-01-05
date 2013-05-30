package com.sigmasys.bsinas.gwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PropertyChangeEvent;
import com.extjs.gxt.ui.client.event.*;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.layout.TableRowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Timer;
import com.sigmasys.bsinas.gwt.client.model.NavigationContext;
import com.sigmasys.bsinas.gwt.client.model.SearchCriteria;
import com.sigmasys.bsinas.gwt.client.service.GwtErrorHandler;

import java.io.Serializable;
import java.util.Map;

/**
 * Generic implementation of the search panel that includes form binding and search criteria conversion.
 *
 * @param <M> a type of searchable entities which extends BaseModel
 * @author Michael Ivanov
 */
public abstract class AbstractSearchPanel<M extends BaseModel> extends FormPanel implements SearchPanel<M> {

    public final static int BUTTON_WIDTH = 75;

    // Model and Form Binding
    protected SearchCriteriaModel searchCriteriaModel;

    protected FormBinding formBinding;

    protected AbstractCompositePanel<M> compositePanel;
    protected AbstractListPanel<M> listPanel;
    protected AbstractDetailsPanel<M> detailsPanel;

    protected final Button searchButton = new Button("Search");
    protected final Button resetButton = new Button("Reset");

    protected NavigationContext navigationContext;

    private boolean topPanel;


    protected final Listener<ComponentEvent> enterHitListener = new Listener<ComponentEvent>() {
        public void handleEvent(ComponentEvent event) {
            if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
                submitForm();
            }
        }
    };

    @SuppressWarnings("serial")
    protected static class SearchCriteriaModel extends BaseModel {

        public SearchCriteriaModel() {
            setAllowNestedValues(false);
        }

        public SearchCriteria toSearchCriteria() {
            SearchCriteria searchCriteria = new SearchCriteria();
            for (String key : getPropertyNames()) {
                Serializable value = (Serializable) get(key);
                if (value != null) {
                    Log.debug("Adding key = '" + key + "' value = '" + value + "' to SearchCriteria");
                    searchCriteria.put(key, value);
                }
            }
            return searchCriteria;
        }

        public void fromSearchCriteria(SearchCriteria searchCriteria) {
            for (String key : getPropertyNames()) {
                remove(key);
            }
            if (searchCriteria != null) {
                for (Map.Entry<String, Serializable> entry : searchCriteria.entrySet()) {
                    if (entry.getKey() != null) {
                        Serializable value = entry.getValue();
                        Log.debug("Adding key = '" + entry.getKey() + "' value = " +
                                "'" + value + "' to SearchCriteriaModel");
                        set(entry.getKey(), value);
                    }
                }
            }
        }
    }

    // Constructors
    public AbstractSearchPanel() {
        this(NavigationContext.getDefaultContext());
    }

    public AbstractSearchPanel(NavigationContext context) {

        navigationContext = context;

        searchCriteriaModel = new SearchCriteriaModel();

        SearchCriteria searchCriteria = navigationContext.getSearchCriteria();
        if (searchCriteria != null) {
            searchCriteriaModel.fromSearchCriteria(searchCriteria);
        }

        formBinding = new FormBinding(this);

        setHeading("Search");
        setPadding(2);

        setButtonAlign(HorizontalAlignment.LEFT);

    }

    @Override
    protected void beforeRender() {

        if (topPanel) {
            TableRowLayout layout = new TableRowLayout();
            layout.setWidth("100%");
            setLayout(layout);
            setScrollMode(Style.Scroll.AUTO);
        }

        createSearchPanel();
        createSearchButtons();

        // Doing bind from Model after all child classes do
        // addFieldBinding in createSearchPanel()-> fillSearchElementsContainer()
        // MOVED from afterOnRender method, because it triggered premature validation
        // and marking of required form elements as invalid
        formBinding.bind(searchCriteriaModel);

        super.beforeRender();
    }

    protected void createSearchPanel() {

        if (topPanel) {

            LayoutContainer formContainer = new LayoutContainer();

            add(formContainer);

            fillSearchElementsContainer(formContainer);

        } else {

            setScrollMode(Scroll.AUTOY);

            TableLayout layout = new TableLayout(2);
            layout.setCellSpacing(2);
            layout.setCellPadding(3);

            setLayout(layout);

            ToolBar tb = getToolBar();
            if (tb != null) {
                setTopComponent(tb);
            }

            fillSearchElementsContainer(this);

        }

        addEnterHitListener();
    }

    protected void addFieldBinding(final Field<?> field, final String id) {
        addFieldBinding(field, id, null);
    }

    protected <T> void addFieldBinding(final Field<T> field, final String id, T defaultValue) {
        FieldBinding fieldBinding = new FieldBinding(field, id) {
            /**
             * Model changes are never supposed to be reflected on UI
             * @param event PropertyChangeEvent instance
             */
            @Override
            protected void onModelChange(PropertyChangeEvent event) {
                // DOES NOTHING
            }
        };
        Log.debug("Binding field = '" + field.getClass().getName() + "' to id = '" + id + "'");
        if (defaultValue != null) {
            field.setValue(defaultValue);
            field.setOriginalValue(defaultValue);
            searchCriteriaModel.set(id, defaultValue);
        }
        formBinding.addFieldBinding(fieldBinding);
    }

    protected boolean isFormValid() {
        boolean valid = true;
        // Going through all items because isValid should be called on all items,
        // otherwise all red markers will disappear except for the first invalid field.
        for (FieldBinding binding : formBinding.getBindings()) {
            valid &= binding.getField().isValid();
        }
        return valid;
    }

    protected boolean validateFields() {
        boolean isFormValid = true;
        for (FieldBinding binding : formBinding.getBindings()) {
            isFormValid &= binding.getField().validate();
        }
        return isFormValid;
    }

    protected void resetForm() {
        for (FieldBinding binding : formBinding.getBindings()) {
            Field<?> f = binding.getField();
            if (f != null && f.isEnabled()) {
                f.reset();
            } else {
                Log.debug("Field bound to " + binding.getProperty() + " was not reset");
            }
        }
    }

    @Override
    public void submitForm() {
        try {
            Log.debug("Submit Form");
            clearInvalid();
            // if form has failed even one validation, do not search.
            if (!isFormValid()) {
                MessageBox.alert("Error", "Search filters contain invalid value(s), please correct the error.", null);
                return;
            }
            performSearch(getSearchCriteria());
        } catch (Exception e) {
            GwtErrorHandler.error("Search Error: " + e.getMessage(), e);
        }
    }

    protected void createSearchButtons() {

        searchButton.setIconStyle("icon-search");
        searchButton.setId("csp-search-btn");
        searchButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                submitForm();
            }

        });
        searchButton.addStyleName("bold-btn");

        resetButton.setId("csp-reset-btn");
        resetButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                resetForm();
            }
        });
        resetButton.setMinWidth(BUTTON_WIDTH);

        addSearchButtons();

    }

    protected void addSearchButtons() {

        if (topPanel) {

            LayoutContainer panel = new LayoutContainer(new FitLayout());

            LayoutContainer buttonPanel = new LayoutContainer(new TableLayout(1));

            TableData td = new TableData();
            td.setPadding(5);
            td.setHorizontalAlign(Style.HorizontalAlignment.LEFT);

            searchButton.setWidth(70);
            resetButton.setWidth(70);

            buttonPanel.add(resetButton, td);
            buttonPanel.add(searchButton, td);

            panel.add(buttonPanel);

            add(panel);

        } else {
            addButton(resetButton);
            getButtonBar().add(new FillToolItem());
            addButton(searchButton);
        }
    }

    @Override
    public void updateFormWithSearchCriteria(SearchCriteria searchCriteria) {
        resetForm();
        searchCriteriaModel.fromSearchCriteria(searchCriteria);
    }

    protected void beforePerformSearch(SearchCriteria searchCriteria) {
        // NOTHING by default
    }

    protected void afterPerformSearch(SearchCriteria searchCriteria) {
        // NOTHING by default
    }

    public void performSearch(SearchCriteria searchCriteria) {
        beforePerformSearch(searchCriteria);
        if (getListPanel() != null) {
            getListPanel().setSearchCriteria(searchCriteria);
            getListPanel().loadPageWithZeroOffset();
        }
        afterPerformSearch(searchCriteria);
    }


    protected void clearInvalid() {
        for (Field<?> field : getFields()) {
            field.clearInvalid();
        }
    }

    public AbstractCompositePanel<M> getCompositePanel() {
        return compositePanel;
    }

    @Override
    public void setCompositePanel(AbstractCompositePanel<M> compositePanel) {
        this.compositePanel = compositePanel;
    }

    public AbstractListPanel<M> getListPanel() {
        return listPanel;
    }

    @Override
    public void setListPanel(AbstractListPanel<M> listPanel) {
        this.listPanel = listPanel;
    }

    public AbstractDetailsPanel<M> getDetailsPanel() {
        return detailsPanel;
    }

    @Override
    public void setDetailsPanel(AbstractDetailsPanel<M> detailsPanel) {
        this.detailsPanel = detailsPanel;
    }

    @Override
    public SearchCriteria getSearchCriteria() {
        for (FieldBinding fieldBinding : formBinding.getBindings()) {
            if (fieldBinding.getModel() != null) {
                fieldBinding.updateModel();
            } else {
                Log.debug("Field binding model is null, property = " + fieldBinding.getProperty());
            }
        }
        return toSearchCriteria();
    }

    protected abstract Component[] getEnterKeyDownEventAwareComponents();

    protected void addEnterHitListener() {
        if (getEnterKeyDownEventAwareComponents() != null) {
            for (Component comp : getEnterKeyDownEventAwareComponents()) {
                if (comp != null) {
                    comp.addListener(Events.KeyPress, enterHitListener);
                }
            }
        }
    }

    protected abstract void fillSearchElementsContainer(LayoutContainer cont);

    /**
     * Overwrite this method if you need any custom post-processing, or manipulate with
     * SearchCriteriaModel before sending it to back-end.
     * <p/>
     * There is may be better name for this method..
     *
     * @return SearchCriteria
     */
    protected SearchCriteria toSearchCriteria() {
        return searchCriteriaModel.toSearchCriteria();
    }

    // Can be overridden in subclasses
    protected ToolBar getToolBar() {
        return null;
    }

    protected boolean isClearInvalidOnOpen() {
        return false;
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        new Timer() {
            @Override
            public void run() {
                SearchCriteria searchCriteria = getSearchCriteria();
                beforePerformSearch(searchCriteria);
                if (getListPanel() != null) {
                    getListPanel().setSearchCriteria(searchCriteria);
                }
            }
        }.schedule(5);
        if (isClearInvalidOnOpen()) {
            new Timer() {
                @Override
                public void run() {
                    resetForm();
                }
            }.schedule(5);
        }
    }

    @Override
    public boolean isTopPanel() {
        return topPanel;
    }

    public void setTopPanel(boolean topPanel) {
        this.topPanel = topPanel;
    }
}