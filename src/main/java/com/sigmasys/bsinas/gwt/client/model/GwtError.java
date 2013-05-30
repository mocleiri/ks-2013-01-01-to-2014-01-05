package com.sigmasys.bsinas.gwt.client.model;



public class GwtError extends RuntimeException {

    private String message;
    private boolean showCommonMessage;

    public GwtError() {
    }

    public GwtError(String message) {
        this(message, false);
    }

    public GwtError(String message, boolean showCommonMessage) {
        super(message);
        this.message = message;
        this.showCommonMessage = showCommonMessage;
    }

    public String getMessage() {
        return message;
    }

    public boolean isShowCommonMessage() {
        return showCommonMessage;
    }

}
