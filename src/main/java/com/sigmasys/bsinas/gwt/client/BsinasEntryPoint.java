package com.sigmasys.bsinas.gwt.client;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.sigmasys.bsinas.gwt.client.model.ReferenceData;
import com.sigmasys.bsinas.gwt.client.service.*;
import com.sigmasys.bsinas.gwt.client.view.BsinasDesktop;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BsinasEntryPoint implements EntryPoint {

    private final BsinasDesktop desktop = new BsinasDesktop();

    private MessageBox waitingBox;

    public BsinasEntryPoint() {
        Registry.register(BsinasEntryPoint.class.getName(), this);
    }

    public void onModuleLoad() {

        Log.debug("onModuleLoad Start");

        waitingBox = MessageBox.wait("", "Loading workspace...", "");

        Log.debug("getModuleBaseURL: " + GWT.getModuleBaseURL());
        Log.debug("getHostPageBaseURL: " + GWT.getHostPageBaseURL());

        // Initializing reference data
        loadReferenceData();

        Log.debug("onModuleLoad Finish");
    }

    private void loadReferenceData() {
        ReferenceDataProvider.addAfterSetCommand(new ReferenceDataCommand() {
            @Override
            public void execute(ReferenceData referenceData) {
                desktop.init();
            }
        });
        ReferenceDataProvider.init(waitingBox);
    }

}
