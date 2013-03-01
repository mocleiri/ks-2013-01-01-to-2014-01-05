package com.sigmasys.kuali.ksa.krad.uif;

import org.kuali.rice.krad.uif.element.Header;
import org.kuali.rice.krad.uif.view.View;

/**
 * KSA extension of the standard KRAD Header.
 */
public class KsaHeader extends Header {

    private View view;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
