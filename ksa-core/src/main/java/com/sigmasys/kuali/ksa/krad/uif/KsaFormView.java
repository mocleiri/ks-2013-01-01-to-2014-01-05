package com.sigmasys.kuali.ksa.krad.uif;

import org.kuali.rice.krad.uif.element.Header;
import org.kuali.rice.krad.uif.view.FormView;

/**
 * KSA extension of the standard KRAD FormView.
 *
 * @author Michael Ivanov
 */
public class KsaFormView extends FormView {

    @Override
    public void setHeader(Header header) {
        if (header != null && header.getUpperGroup() != null) {
            header.getUpperGroup().setBaseId(getCurrentPageId());
        }
        super.setHeader(header);
    }

}
