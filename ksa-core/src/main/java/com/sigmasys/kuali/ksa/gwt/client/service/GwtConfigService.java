package com.sigmasys.kuali.ksa.gwt.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.sigmasys.kuali.ksa.gwt.client.model.GwtError;
import com.sigmasys.kuali.ksa.gwt.client.model.ReferenceData;

/**
 * GwtConfigService
 *
 * @author Michael Ivanov
 */
public interface GwtConfigService extends RemoteService {

    ReferenceData getReferenceData() throws GwtError;

    ReferenceData getReferenceData(String language, String country) throws GwtError;

}
