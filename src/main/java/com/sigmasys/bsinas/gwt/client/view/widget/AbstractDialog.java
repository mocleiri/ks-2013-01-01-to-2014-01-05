package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;

/**
 * AbstractDialog
 *
 * @author Michael Ivanov
 */
public abstract class AbstractDialog extends Dialog {

    public AbstractDialog() {
        this("");
    }

    public AbstractDialog(String title) {
        setModal(true);
        setLayout(new FitLayout());
        setHideOnButtonClick(true);
        setHeading(title);
    }

    @Override
    protected void onRender(Element parent, int pos) {
        super.onRender(parent, pos);
        init();
    }

    /**
     * Subclasses should override this method for initializing of all UI elements
     */
    protected abstract void init();

}



