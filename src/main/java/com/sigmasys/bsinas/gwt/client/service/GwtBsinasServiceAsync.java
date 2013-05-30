package com.sigmasys.bsinas.gwt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sigmasys.bsinas.gwt.client.model.ReferenceData;

/**
 * GwtBsinasServiceAsync
 *
 * @author Michael Ivanov
 */
public interface GwtBsinasServiceAsync {

    void runEngine(String requestXml, int year, AsyncCallback<String> callback);

}
