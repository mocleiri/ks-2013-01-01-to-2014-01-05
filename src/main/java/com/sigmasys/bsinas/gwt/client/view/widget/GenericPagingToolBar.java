package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.user.client.Command;

/**
 * GenericPagingToolBar
 *
 * @author Michael Ivanov
 */
public class GenericPagingToolBar extends PagingToolBar {

    private Command beforeRefreshCommand;

    public GenericPagingToolBar(final int pageSize) {
        super(pageSize);
    }

    @Override
    public void onLoad(LoadEvent event) {
        super.onLoad(event);
    }

    public int getStart() {
        return start;
    }

    public int getTotalLength() {
        return totalLength;
    }

    public void refresh() {
        if (beforeRefreshCommand != null) {
            beforeRefreshCommand.execute();
        }
        super.refresh();
    }

    public void setBeforeRefreshCommand(Command beforeRefreshCommand) {
        this.beforeRefreshCommand = beforeRefreshCommand;
    }
}
