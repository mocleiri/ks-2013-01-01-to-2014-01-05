package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.RateTypeForm;
import com.sigmasys.kuali.ksa.model.fm.RateType;
import com.sigmasys.kuali.ksa.service.fm.RateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller to serve requests from the "Rate Types" page.
 * User: Sergey
 * Date: 12/4/13
 * Time: 10:37 PM
 */
@Controller
@RequestMapping(value = "/rateTypeView")
public class RateTypeController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(RateTypeController.class);

    @Autowired
    private RateService rateService;


    /**
     * Creates the page's form.
     */
    @Override
    protected RateTypeForm createInitialForm(HttpServletRequest request) {
        RateTypeForm form = new RateTypeForm();

        return form;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=displayInitialPage")
    public ModelAndView displayInitialPage(@ModelAttribute("KualiForm") RateTypeForm form) {
        List<RateType> rateTypes = rateService.getAllRateTypes();
        form.setRateTypes(rateTypes);

        return getUIFModelAndView(form);
    }

}
