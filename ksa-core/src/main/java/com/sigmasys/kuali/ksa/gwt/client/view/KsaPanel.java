package com.sigmasys.kuali.ksa.gwt.client.view;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.*;
import com.extjs.gxt.ui.client.widget.*;
import com.extjs.gxt.ui.client.widget.layout.*;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.user.client.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * KSA Root Panel
 *
 * @author Michael Ivanov
 */
public class KsaPanel extends TabPanel {

    public KsaPanel() {
        setCloseContextMenu(true);
        Registry.register(KsaPanel.class.getName(), this);
    }

    private void init() {

        TabItem tabItem = new TabItem("Accounts");
        tabItem.setIconStyle("icon-user");
        tabItem.setLayout(new FitLayout());
        tabItem.setScrollMode(Style.Scroll.AUTO);
        tabItem.add(new AccountCompositePanel());
        add(tabItem);

        tabItem = new TabItem("Transactions");
        tabItem.setIconStyle("tabs");
        //tabItem.setIconStyle("icon-card");
        tabItem.setLayout(new FitLayout());
        tabItem.setScrollMode(Style.Scroll.AUTO);
        tabItem.add(new TransactionCompositePanel());
        add(tabItem);

        /*
        tabItem = new TabItem("Payments");
        tabItem.setIconStyle("icon-coins");
        tabItem.setLayout(new FitLayout());
        tabItem.setScrollMode(Style.Scroll.AUTO);
        // TODO
        tabItem.add(new LayoutContainer());
        add(tabItem);

        tabItem = new TabItem("Deferments");
        tabItem.setIconStyle("icon-calculator");
        tabItem.setLayout(new FitLayout());
        tabItem.setScrollMode(Style.Scroll.AUTO);
        // TODO
        tabItem.add(new LayoutContainer());
        add(tabItem);
        */

        tabItem = new TabItem("Alerts");
        tabItem.setIconStyle("icon-alert");
        tabItem.setLayout(new FitLayout());
        tabItem.setScrollMode(Style.Scroll.AUTO);
        // TODO
        tabItem.add(new LayoutContainer());
        add(tabItem);

        tabItem = new TabItem("Memos");
        tabItem.setIconStyle("icon-memo");
        tabItem.setLayout(new FitLayout());
        tabItem.setScrollMode(Style.Scroll.AUTO);
        // TODO
        tabItem.add(new LayoutContainer());
        add(tabItem);

        tabItem = new TabItem("Flags");
        tabItem.setIconStyle("icon-flag");
        tabItem.setLayout(new FitLayout());
        tabItem.setScrollMode(Style.Scroll.AUTO);
        // TODO
        tabItem.add(new LayoutContainer());
        add(tabItem);

    }

    @Override
    protected void onRender(Element target, int index) {
        super.onRender(target, index);
        init();
    }

    @Override
    protected void onItemContextMenu(TabItem tab, int x, int y) {

        if (isCloseContextMenu()) {

            if (closeContextMenu == null) {
                closeContextMenu = new Menu();
                closeContextMenu.addListener(Events.Hide, new Listener<MenuEvent>() {
                    @Override
                    public void handleEvent(MenuEvent be) {
                        be.getContainer().setData("tab", null);
                    }
                });

                MenuItem item = new MenuItem("Move to New Window", new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        TabItem item = (TabItem) ce.getContainer().getData("tab");
                        if (item != null) {
                            List<Component> innerItems = item.getItems();
                            if (innerItems != null && !innerItems.isEmpty()) {
                                Window window = new Window();
                                window.setHeading(item.getText());
                                window.setLayout(new FitLayout());
                                window.setMaximizable(true);
                                window.setMinimizable(true);
                                window.setClosable(true);
                                window.setSize(800, 600);
                                window.add(innerItems.get(0));
                                KsaDesktop desktop = Registry.get(KsaDesktop.class.getName());
                                desktop.openWindow(window);
                                close(item);
                            }
                        }
                    }
                });
                item.setIconStyle("icon-checkin");

                closeContextMenu.add(item);

                item = new MenuItem("Close Tab", new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        TabItem item = (TabItem) ce.getContainer().getData("tab");
                        if (item != null) {
                            close(item);
                        }
                    }
                });
                item.setIconStyle("icon-delete");

                closeContextMenu.add(item);

                item = new MenuItem("Close Other Tabs", new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        TabItem item = (TabItem) ce.getContainer().getData("tab");
                        if (item != null) {
                            List<TabItem> items = new ArrayList<TabItem>();
                            items.addAll(getItems());
                            for (TabItem currentItem : items) {
                                if (currentItem != item && currentItem.isClosable()) {
                                    close(currentItem);
                                }
                            }
                        }
                    }

                });
                item.setIconStyle("icon-delete");

                closeContextMenu.add(item);
            }

            closeContextMenu.getItem(0).setEnabled(tab.isClosable());
            closeContextMenu.getItem(1).setEnabled(tab.isClosable());

            closeContextMenu.setData("tab", tab);

            boolean hasClosable = false;
            for (TabItem item : getItems()) {
                if (item.isClosable() && item != tab) {
                    hasClosable = true;
                    break;
                }
            }

            closeContextMenu.getItem(2).setEnabled(hasClosable);
            closeContextMenu.showAt(x, y);
        }
    }

}
