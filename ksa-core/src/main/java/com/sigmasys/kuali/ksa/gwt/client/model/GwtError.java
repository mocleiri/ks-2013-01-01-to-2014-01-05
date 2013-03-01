package com.sigmasys.kuali.ksa.gwt.client.model;



public class GwtError extends RuntimeException {

    private String message;
    private boolean showCommonMessage;

    public GwtError() {
        super();
    }

    public GwtError(String message) {
        this(message, true);
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
