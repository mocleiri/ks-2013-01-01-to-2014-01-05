package com.sigmasys.kuali.ksa.gwt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sigmasys.kuali.ksa.gwt.client.model.ReferenceData;

/**
 * GwtAccountServiceAsync
 *
 * @author Michael Ivanov
 */
public interface GwtConfigServiceAsync {

    void getReferenceData(AsyncCallback<ReferenceData> callback);

    void getReferenceData(String language, String country, AsyncCallback<ReferenceData> callback);

}
