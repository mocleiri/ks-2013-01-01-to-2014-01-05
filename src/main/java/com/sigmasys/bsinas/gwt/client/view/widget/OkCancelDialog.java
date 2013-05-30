package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.Element;
import com.sigmasys.bsinas.gwt.client.service.GwtErrorHandler;

/**
 * Base class for all dialogs that have Ok and Cancel buttons
 */
public abstract class OkCancelDialog extends AbstractDialog {

    private boolean okOnly; // only show ok button

    public OkCancelDialog() {
        this("");
    }

    public OkCancelDialog(String title) {
        this(title, false);
    }

    public OkCancelDialog(String title, boolean okOnly) {
        super(title);
        this.okOnly = okOnly;
    }

    @Override
    protected void onRender(Element parent, int pos) {
        initButtons();
        super.onRender(parent, pos);
    }


    protected void initButtons() {

        setButtons(okOnly ? Dialog.OK : Dialog.OKCANCEL);

        Button cancelButton = getCancelButton();
        if (cancelButton != null) {
            cancelButton.setIconStyle("icon-cancel");
            cancelButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
                public void componentSelected(ButtonEvent event) {
                    try {
                        onCancelClicked();
                    } catch (Exception e) {
                        GwtErrorHandler.error(e);
                    }
                }
            });
        }

        Button okButton = getOkButton();
        if (okButton != null) {
            okButton.setIconStyle("icon-check");
            okButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
                public void componentSelected(ButtonEvent event) {
                    try {
                        onOkClicked();
                    } catch (Exception e) {
                        GwtErrorHandler.error(e);
                    }
                }
            });
        }
    }

    protected void onCancelClicked() {
    }

    protected void onOkClicked() {
    }

    protected Button getOkButton() {
        return getButtonById(Dialog.OK);
    }

    protected Button getCancelButton() {
        return getButtonById(Dialog.CANCEL);
    }
}
