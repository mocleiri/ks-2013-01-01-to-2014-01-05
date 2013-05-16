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

    private ViewHelperService viewHelperService;

    @Override
    public void setHeader(Header header) {
        if (header != null && header.getUpperGroup() != null) {
            header.getUpperGroup().setBaseId(getCurrentPageId());
        }
        super.setHeader(header);
    }

    /**
     * KRAD original View class does not allow Spring-managed view helpers to be injected,
     * but it would really be nice to support it as well.
     *
     * @return ViewHelperService instance.
     */
    @Override
    public ViewHelperService getViewHelperService() {
        return (viewHelperService != null) ? viewHelperService : super.getViewHelperService();
    }

    public void setViewHelperService(ViewHelperService viewHelperService) {
        this.viewHelperService = viewHelperService;
    }
}
