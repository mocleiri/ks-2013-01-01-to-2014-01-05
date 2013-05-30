package com.sigmasys.bsinas.gwt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Generic Callback.
 *
 * @author Michael Ivanov
 */
public abstract class GenericCallback<T> implements AsyncCallback<T> {

    public void onFailure(Throwable t) {
        GwtErrorHandler.error(t);
    }

}
