package com.sigmasys.bsinas.gwt.client.service;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.sigmasys.bsinas.gwt.client.model.GwtError;

/**
 * GWT client error handler.
 *
 * @author Michael Ivanov
 */
public class GwtErrorHandler {

    private static final String DEFAULT_ERROR_MESSAGE = "Error occurred.";

    public static final String COMMON_ERROR_PREFIX = "Request failed.";
    public static final String COMMON_ERROR_SUFFIX = "See server log for details.";

    private static MessageBox messageBox = new MessageBox();

    private static String getErrorMessage(final Throwable t) {
        String errorMessage = null;
        if (t != null) {
            errorMessage = t.getMessage();
        }
        if (errorMessage == null || errorMessage.trim().length() == 0) {
            errorMessage = DEFAULT_ERROR_MESSAGE;
            if (t != null) {
                errorMessage = errorMessage + " " + t.toString();
            }
        }
        if (t instanceof GwtError && ((GwtError) t).isShowCommonMessage()) {
            errorMessage = COMMON_ERROR_PREFIX + "<br>" + errorMessage + "<br>" + COMMON_ERROR_SUFFIX;
        }
        return errorMessage;
    }

    public static void error(final Throwable t) {
        errorInternal(getErrorMessage(t), null, t);
    }

    public static void error(final Throwable t, Listener<MessageBoxEvent> listener) {
        errorInternal(getErrorMessage(t), listener, t);
    }

    public static void error(final String errorMessage) {
        errorInternal(errorMessage, null, null);
    }

    public static void error(final String errorMessage, final Throwable t) {
        errorInternal(errorMessage + " " + getErrorMessage(t), null, t);
    }

    public static void error(final String errorMessage, final Throwable t, Listener<MessageBoxEvent> listener) {
        errorInternal(errorMessage + " " + getErrorMessage(t), listener, t);
    }

    protected static void errorInternal(final String errorMessage, Listener<MessageBoxEvent> listener, Throwable t) {
        boolean visible = messageBox.isVisible();
        errorInternal((messageBox = new MessageBox()), errorMessage, listener, t, visible);
    }

    protected static void errorInternal(MessageBox messageBox, String errorMessage,
                                        Listener<MessageBoxEvent> listener, Throwable t, boolean visible) {
        if (t != null) {
            Log.error(errorMessage, t);
        } else {
            Log.error(errorMessage);
        }
        if (listener != null) {
            messageBox.addCallback(listener);
        }
        GWT.log("Error occurred: " + errorMessage);
        if (!visible) {
            messageBox.setMessage(errorMessage);
            messageBox.setIcon(MessageBox.ERROR);
            messageBox.setModal(true);
            messageBox.setTitle("Error");
            messageBox.show();
        }
    }
}
