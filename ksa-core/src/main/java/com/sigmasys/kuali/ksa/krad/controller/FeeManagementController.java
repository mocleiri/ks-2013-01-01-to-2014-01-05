package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.FeeManagementForm;
import com.sigmasys.kuali.ksa.model.fm.RateType;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.fm.FeeManagementService;
import com.sigmasys.kuali.ksa.service.fm.RateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//import com.sigmasys.kuali.ksa.krad.model.ThirdPartyMemberModel;

@Controller
@RequestMapping(value = "/feeManagementView")
public class FeeManagementController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(FeeManagementController.class);

    @Autowired
    private InformationService informationService;

    @Autowired
    private FeeManagementService feeManagementService;

    @Autowired
    private RateService rateService;

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected FeeManagementForm createInitialForm(HttpServletRequest request) {
        FeeManagementForm form = new FeeManagementForm();

        return form;
    }

    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") FeeManagementForm form, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        String pageId = request.getParameter("pageId");

        if("RateTypesPage".equals(pageId)) {
            List<RateType> rateTypes = rateService.getAllRateTypes();
            form.setRateTypes(rateTypes);
        }

        return getUIFModelAndView(form);
    }

}
