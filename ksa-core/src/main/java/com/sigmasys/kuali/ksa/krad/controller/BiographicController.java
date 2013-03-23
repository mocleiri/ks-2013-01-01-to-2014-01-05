package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.BiographicForm;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.PersonName;
import com.sigmasys.kuali.ksa.model.PostalAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by: dmulderink on 9/25/12 at 6:59 PM
 */
@Controller
@RequestMapping(value = "/biographicView")
public class BiographicController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(BiographicController.class);

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected BiographicForm createInitialForm(HttpServletRequest request) {
        BiographicForm form = new BiographicForm();
        form.setStatusMessage("");
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
     * @param form
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") BiographicForm form, HttpServletRequest request) {

        String viewId = request.getParameter("viewId");
        String pageId = request.getParameter("pageId");

        Account account = form.getAccount();

        if (account == null) {
            String errMsg = "No account available";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        if (pageId != null && pageId.compareTo("BiographicAddPersonPage") == 0) {
            form.setPersonName(new PersonName());
            return getUIFModelAndView(form);
        }

        // BiographicEDPersonPage needs a PersonName from a selection

        // BiographicInformationPostalADE

        // BiographicInformationElectronicContactADE

        //BiographicSummaryPage needs a list
        if (pageId != null && pageId.compareTo("BiographicPersonsPage") == 0) {
           List<Account> accountsByPattern = accountService.findAccountsByNamePattern(account.getId());
           List<PersonName> personNames = new ArrayList<PersonName>();
           if (accountsByPattern != null) {
              for (Account accountByPattern : accountsByPattern) {
                 Set<PersonName> personNameSet = account.getPersonNames();
                 for (PersonName personName : personNameSet) {
                    personNames.add(personName);
                 }
              }
           }

           form.setPersonNameList(personNames);
        }


       account = accountService.getFullAccount(account.getId());
        // TODO refactor to the id in the request parameters
        if (account == null) {
            String errMsg = "Cannot find Account by ID = " + account.getId();
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        PersonName personName = account.getDefaultPersonName();

        form.setKimNameType(personName.getKimNameType());
        form.setFirstName(personName.getFirstName());
        form.setLastName(personName.getLastName());
        form.setMiddleName(personName.getMiddleName());
        form.setSuffix(personName.getSuffix());
        form.setTitle(personName.getTitle());
        form.setPersonDefault(personName.isDefault().toString());

        form.setPersonName(personName);
        form.setAccount(account);

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @param result
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=insertPerson")
    @Transactional(readOnly = false)
    public ModelAndView addPerson(@ModelAttribute("KualiForm") BiographicForm form, BindingResult result,
                                  HttpServletRequest request, HttpServletResponse response) {

        Account account = form.getAccount();
        //PersonName personName = form.getPersonName();
        PersonName personName = new PersonName();
        personName.setKimNameType(form.getKimNameType());
        personName.setFirstName(form.getFirstName());
        personName.setMiddleName(form.getMiddleName());
        personName.setLastName(form.getLastName());
        personName.setSuffix(form.getSuffix());
        personName.setTitle(form.getTitle());
        personName.setDefault(new Boolean(form.getPersonDefault()));

        accountService.addPersonName(account.getId(), personName);

        form.setStatusMessage("Person added");
        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @param result
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=updatePerson")
    @Transactional(readOnly = false)
    public ModelAndView updatePerson(@ModelAttribute("KualiForm") BiographicForm form, BindingResult result,
                                     HttpServletRequest request, HttpServletResponse response) {

        // @TODO: This is wrong.  Don't create a new one, get the one to update
        PersonName personName = new PersonName();

        personName.setKimNameType(form.getKimNameType());
        personName.setFirstName(form.getFirstName());
        personName.setMiddleName(form.getMiddleName());
        personName.setLastName(form.getLastName());
        personName.setSuffix(form.getSuffix());
        personName.setTitle(form.getTitle());
        personName.setDefault(Boolean.parseBoolean(form.getPersonDefault()));

       //accountService.persist(personName);

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @param result
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=insertPostal")
    @Transactional(readOnly = false)
    public ModelAndView insertPostal(@ModelAttribute("KualiForm") BiographicForm form, BindingResult result,
                                     HttpServletRequest request, HttpServletResponse response) {

        // do save stuff...
        Account account = form.getAccount();

        PostalAddress address = new PostalAddress();
        address.setKimAddressType(form.getAddressType());
        address.setStreetAddress1(form.getAddress1());
        address.setStreetAddress2(form.getAddress2());
        address.setStreetAddress3(form.getAddress3());
        address.setCity(form.getCity());
        address.setState(form.getStateCode());
        address.setPostalCode(form.getPostalCode());
        address.setCountry(form.getCountryCode());
        address.setDefault(Boolean.valueOf(form.getPostalDefault()));

        accountService.addPostalAddress(account.getId(), address);

        form.setStatusMessage("Address added");

        return getUIFModelAndView(form);
    }

}
