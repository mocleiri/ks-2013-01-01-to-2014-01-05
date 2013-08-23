package com.sigmasys.kuali.ksa.krad.uif;

import org.kuali.rice.krad.uif.element.Header;
import org.kuali.rice.krad.uif.service.ViewHelperService;
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

    /**
     * The KRAD View sets the default View Helper class and does not remove that reference when setting a different
     * view helper via this setter. Hence, we have to override it.
     *
     * @param viewHelperService ViewHelperService instance
     */
    @Override
    public void setViewHelperService(ViewHelperService viewHelperService) {
        super.setViewHelperServiceClass(null);
        super.setViewHelperService(viewHelperService);
    }
}
