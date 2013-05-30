package com.sigmasys.bsinas.gwt.client.view.widget;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.SimpleComboValue;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;

/**
 * Extended PagingToolBar allowing for dynamic page size change using a combo box
 *
 * @author Michael Ivanov
 */
public class PageSizeSelectableToolBar extends GenericPagingToolBar {


    /**
     * Creates a new paging tool bar with the given page size options.
     * <p/>
     * This creates a paging toolbar with Page Size selector with values 20, 50, 100, 200 and 20 is the default
     * <pre>
     * PagingToolBar bar = new PageSizeSelectableToolBar(20, 50, 100, 200 })
     * </pre>
     *
     * @param pageSize       the default page size
     * @param otherPageSizes other page size values to appear on the Page Size combo
     */
    public PageSizeSelectableToolBar(int pageSize, int... otherPageSizes) {

        super(pageSize);

        final SimpleComboBox<Integer> pageSizeSelector = new SimpleComboBox<Integer>();
        pageSizeSelector.add(pageSize);
        for (int otherPageSize : otherPageSizes) {
            pageSizeSelector.add(otherPageSize);
            Log.debug("PageSizeSelectableToolBar::Adding page size = " + otherPageSize);
        }
        pageSizeSelector.setSimpleValue(pageSize);
        pageSizeSelector.setTriggerAction(ComboBox.TriggerAction.ALL);
        pageSizeSelector.setForceSelection(true);
        pageSizeSelector.setAllowBlank(false);
        pageSizeSelector.setEditable(false);
        pageSizeSelector.setWidth(50);
        pageSizeSelector.addListener(Events.Select, new Listener<FieldEvent>() {
            public void handleEvent(FieldEvent be) {
                @SuppressWarnings("unchecked")
                int newPageSize = ((SimpleComboValue<Integer>) be.getField().getValue()).getValue();
                changePageSize(newPageSize);
            }
        });

        insert(new SeparatorToolItem(), 0);
        insert(pageSizeSelector, 0);
        insert(new Text("Page Size"), 0);
        insert(new SeparatorToolItem(), 0);

    }


    /**
     * changes the page size and reloads the data keeping the first page row the same
     *
     * @param newPageSize the new page size
     */
    protected void changePageSize(int newPageSize) {
        setPageSize(newPageSize);
        // doLoadRequest(start, pageSize);
        // To solve page numbering issues after the page size has changed we always have to start from 0
        if (config != null) {
            doLoadRequest(0, pageSize);
        }
    }

}
