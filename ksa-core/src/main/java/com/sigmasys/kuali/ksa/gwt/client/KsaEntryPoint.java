package com.sigmasys.kuali.ksa.gwt.client;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.sigmasys.kuali.ksa.gwt.client.model.ReferenceData;
import com.sigmasys.kuali.ksa.gwt.client.service.*;
import com.sigmasys.kuali.ksa.gwt.client.view.KsaDesktop;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class KsaEntryPoint implements EntryPoint {

    private final KsaDesktop desktop = new KsaDesktop();

    private MessageBox waitingBox;

    public KsaEntryPoint() {
        Registry.register(KsaEntryPoint.class.getName(), this);
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
