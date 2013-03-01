package com.sigmasys.kuali.ksa.gwt.client.view;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.http.client.UrlBuilder;
import com.sigmasys.kuali.ksa.gwt.client.view.widget.IFrame;

/**
 * KIM UI root window
 *
 * @author Michael Ivanov
 *         Date: 5/2/12
 */
public class KimWindow extends Window {

    public KimWindow() {
        setHeading("Kuali Identity Management");
        setMinimizable(true);
        setMaximizable(true);
        setClosable(true);
        setSize(1000, 700);
        setLayout(new FitLayout());
        LayoutContainer panel = new LayoutContainer(new FitLayout());
        panel.add(new IFrame(getKimUrl(), "bg-white"));
        add(panel);
    }

    private String getKimUrl() {
        UrlBuilder urlBuilder = com.google.gwt.user.client.Window.Location.createUrlBuilder();
        urlBuilder.setPath("/ksa/kim/index.jsp");
        return urlBuilder.buildString();
    }
}