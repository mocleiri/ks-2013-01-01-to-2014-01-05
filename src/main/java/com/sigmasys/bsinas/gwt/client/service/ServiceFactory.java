package com.sigmasys.bsinas.gwt.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.sigmasys.bsinas.model.Constants;

/**
 * ServiceFactory creates GWT Async services.
 *
 * @author Michael Ivanov
 */
@SuppressWarnings("unchecked")
public class ServiceFactory {

    private static final GwtConfigServiceAsync configService;
    private static final GwtBsinasServiceAsync bsinasService;

    // Initialization of the remote services
    static {
        configService = initService(GWT.create(GwtConfigService.class), Constants.CONFIG_SERVICE_URL);
        bsinasService = initService(GWT.create(GwtBsinasService.class), Constants.BSINAS_SERVICE_URL);
    }

    private ServiceFactory() {
    }

    protected static <T> T initService(Object asyncService, String serviceUrl) {
        ((ServiceDefTarget) asyncService).setServiceEntryPoint(serviceUrl);
        return (T) asyncService;
    }

    public static GwtConfigServiceAsync getConfigService() {
        return configService;
    }

    public static GwtBsinasServiceAsync getBsinasService() {
           return bsinasService;
    }

}
