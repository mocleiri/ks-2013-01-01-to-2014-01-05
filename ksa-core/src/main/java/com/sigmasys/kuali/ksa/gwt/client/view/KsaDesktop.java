package com.sigmasys.kuali.ksa.gwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.desktop.client.Desktop;
import com.extjs.gxt.desktop.client.Shortcut;
import com.extjs.gxt.desktop.client.StartMenu;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.sigmasys.kuali.ksa.gwt.client.service.GwtErrorHandler;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * KSA Desktop
 *
 * @author Michael Ivanov
 */

public class KsaDesktop extends Desktop {

    public static final String DESKTOP_WINDOW_ID = "x-desktop-window-id";
    public static final String WINDOW_KEY = "window";

    private SelectionListener<ComponentEvent> shortcutListener;


    public KsaDesktop() {
        Registry.register(KsaDesktop.class.getName(), this);
    }

    /*
     * Adds new window to desktop. Do not use addWindow() directly.
     *
     */
    public void openWindow(Window w, boolean maxOnShow) {
        try {

            String desktopWindowId = w.getData(DESKTOP_WINDOW_ID);

            Log.info("Desktop window ID = " + desktopWindowId);

            if (desktopWindowId != null) {
                removeWindows(desktopWindowId);
            }

            if (!getWindows().contains(w)) {
                addWindow(w);
            }

            try {
                w.show();
            } catch (ConcurrentModificationException e) {
                Log.error("ConcurrentModificationException when calling window.show()", e);
            }
            // maximize on show.
            if (w.isMaximizable() && maxOnShow) {
                w.maximize();
            }

        } catch (Exception e) {
            GwtErrorHandler.error("Cannot open window: " + e.getMessage(), e);
        }
    }

    public void openWindow(Window w) {
        openWindow(w, true);
    }

    public void init() {

        final SelectionListener<MenuEvent> listener = new SelectionListener<MenuEvent>() {
            @Override
            public void componentSelected(MenuEvent ce) {
                Window w = ce.getItem().getData(WINDOW_KEY);
                openWindow(w);
            }
        };

        shortcutListener = new SelectionListener<ComponentEvent>() {
            @Override
            public void componentSelected(ComponentEvent ce) {
                Shortcut shortcut = (Shortcut) ce.getSource();
                Window w = (Window) shortcut.getData(WINDOW_KEY);
                openWindow(w);
            }
        };


        final Window ksaWindow = new KsaWindow();
        final Window kimWindow = new KimWindow();

        addShortcut("KSA", ksaWindow, "ksa-shortcut");
        addShortcut("KIM", kimWindow, "accessControl-shortcut");

        // Creating "Start" menu
        final StartMenu menu = taskBar.getStartMenu();
        // TODO: make heading a user name retrieved from ReferenceData
        //menu.setHeading("Admin");
        //menu.setIconStyle("user");

        MenuItem menuItem = new MenuItem(ksaWindow.getHeading());
        menuItem.setData(WINDOW_KEY, ksaWindow);
        menuItem.setIconStyle("tabs");
        menuItem.addSelectionListener(listener);
        menu.add(menuItem);

        menuItem = new MenuItem(kimWindow.getHeading());
        menuItem.setData(WINDOW_KEY, kimWindow);
        menuItem.setIconStyle("tabs");
        menuItem.addSelectionListener(listener);
        menu.add(menuItem);

    }

    public void removeWindows(String desktopWindowId) {
        if (getWindows() != null) {
            // To prevent ConcurrentModificationException we have to create a new list
            List<Window> windows = new ArrayList<Window>(getWindows());
            for (Window w : windows) {
                if (w.getData(DESKTOP_WINDOW_ID) != null && desktopWindowId.equals(w.getData(DESKTOP_WINDOW_ID))) {
                    Log.info("Removing window = " + w + " from desktop");
                    removeWindow(w);
                }
            }
        }
    }

    public void addShortcut(String title, Window window, String id) {
        Shortcut shortcut = new Shortcut();
        shortcut.setText(title);
        shortcut.setId(id);
        shortcut.setData(WINDOW_KEY, window);
        shortcut.addSelectionListener(shortcutListener);
        if (window.getHeading() != null) {
            shortcut.setToolTip(window.getHeading());
        }
        addShortcut(shortcut);
    }

}
