package com.sigmasys.bsinas.gwt.client.view;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;

import java.util.Date;

/**
 * AbstractDetailsPanel
 *
 * @param <M>
 */
public abstract class AbstractDetailsPanel<M extends BaseModel> extends ContentPanel {

    private AbstractListPanel<M> listPanel;


    public AbstractDetailsPanel() {
        setHeading("Details");
    }

    abstract public void updateView(M model);

    public AbstractListPanel<M> getListPanel() {
        return listPanel;
    }

    public void setListPanel(AbstractListPanel<M> listPanel) {
        this.listPanel = listPanel;
    }

    public void updateViewAndRefresh(M item) {
        updateView(item);
        refreshView();
    }

    protected void refreshView() {
        setItemsVisible(true);
        layout();
    }

    public void setItemsVisible(boolean val) {
        for (Component c : getItems()) {
            c.setVisible(val);
        }
    }

    protected void addTo(LayoutContainer container, String label, Text value, boolean isRightCellNoWrap) {
        AbstractDetailsContainer.addTo(container, label, value, isRightCellNoWrap);
    }

    protected void addTo(LayoutContainer container, String label, Text value) {
        AbstractDetailsContainer.addTo(container, label, value);
    }

    protected String displayDouble2(Double number) {
        return AbstractDetailsContainer.displayDouble2(number);
    }

    protected String displayLong(Long number) {
        return AbstractDetailsContainer.displayLong(number);
    }

    protected String displayInt(Integer number) {
        return AbstractDetailsContainer.displayInt(number);
    }

    protected String displayDate(Date date) {
        return AbstractDetailsContainer.displayDate(date);
    }

    protected String displayTimeStamp(Date date) {
        return AbstractDetailsContainer.displayTimeStamp(date);
    }

    protected String displayTimeOnly(Date date) {
        return AbstractDetailsContainer.displayTimeOnly(date);
    }

}
