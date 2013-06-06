package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.FlagForm;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Flag;
import com.sigmasys.kuali.ksa.model.FlagType;
import com.sigmasys.kuali.ksa.model.InformationAccessLevel;
import com.sigmasys.kuali.ksa.service.InformationService;
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
 * TODO -> handle InformationAccessLevel
 * <p/>
 * Created by: dmulderink on 10/6/12 at 2:29 PM
 */
@Controller
@RequestMapping(value = "/flagView")
public class FlagController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(FlagController.class);

    @Autowired
    private InformationService informationService;

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected FlagForm createInitialForm(HttpServletRequest request) {
        FlagForm form = new FlagForm();
        String userId = request.getParameter("userId");

        if (userId != null) {

            Account account = accountService.getFullAccount(userId);

            if (account == null) {
                String errMsg = "Cannot find Account by ID = " + userId;
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
            }

            form.setAccount(account);
        } /*else {
           String errMsg = "'userId' request parameter cannot be null";
           logger.error(errMsg);
           throw new IllegalStateException(errMsg);
        }*/

        return form;
    }

    /**
     * @param form    FlagForm
     * @param request HttpServletRequest
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") FlagForm form, HttpServletRequest request) {

        // do get stuff...

        String pageId = request.getParameter("pageId");
        // example user 1
        String userId = request.getParameter("userId");

        if (pageId != null && pageId.equals("FlagsPage")) {

            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("'userId' request parameter must be specified");
            }
            List<Flag> flags = informationService.getFlags(userId);

            form.setFlagModels(flags);

        } else if (pageId != null && pageId.equals("AddFlagPage")) {
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("'userId' request parameter must be specified");
            }
            form.setAeInstructionalText("Add a flag");

            // TODO: get InformationAccessLevel
            InformationAccessLevel accessLevel = new InformationAccessLevel();


            Flag flag = new Flag();
            // set default values
            FlagType flagType = new FlagType();

            flagType.setAccessLevel(accessLevel);

            // Text is not saved if the type is not set
            // we need a list of flags for the view so the user can make a choice
            flag.setType(flagType);

            flag.setAccount(accountService.getFullAccount(userId));
            flag.setAccessLevel(accessLevel);
            flag.setSeverity(0);

            form.setFlagModel(flag);
            form.setAeInstructionalText("Add a flag");

        } else if (pageId != null && pageId.equals("ViewFlagPage")) {
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("'userId' request parameter must be specified");
            }

            form.setAeInstructionalText("View a flag");

        } else if (pageId != null && pageId.equals("EditFlagPage")) {
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("'userId' request parameter must be specified");
            }

            form.setAeInstructionalText("Edit a flag");

        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form FlagForm
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=insertFlag")
    public ModelAndView insertFlag(@ModelAttribute("KualiForm") FlagForm form) {

        Flag flag = form.getFlagModel();

        Long persistResult = informationService.persistInformation(flag);

        if (persistResult >= 0) {
            form.setStatusMessage("Success");
        } else {
            form.setStatusMessage("Failed to add flag. result code: " + persistResult.toString());
        }

        return getUIFModelAndView(form);
    }

}
