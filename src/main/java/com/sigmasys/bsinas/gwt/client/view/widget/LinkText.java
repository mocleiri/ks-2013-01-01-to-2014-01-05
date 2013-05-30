package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.widget.Text;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * LinkText is a clickable link
 *
 * @author Michael Ivanov
 */
public class LinkText extends Text {

    public LinkText(String name) {
        super(name);
    }

    public LinkText(String name, String style) {
        this(name);
        setStyleName(style);
    }

    protected void onRender(Element target, int index) {
        super.onRender(target, index);
        el().addEventsSunk(Event.ONCLICK);
    }
}
