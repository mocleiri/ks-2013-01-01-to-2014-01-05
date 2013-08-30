package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.BiographicForm;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.ElectronicContact;
import com.sigmasys.kuali.ksa.model.PersonName;
import com.sigmasys.kuali.ksa.model.PostalAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

        account = accountService.getFullAccount(account.getId());
        form.setAccount(account);
        if (account == null) {
            String errMsg = "No account available";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        form.setPersonNameList(new ArrayList<PersonName>());
        form.getPersonNameList().addAll(account.getPersonNames());

        form.setPostalAddressList(new ArrayList<PostalAddress>());
        form.getPostalAddressList().addAll(account.getPostalAddresses());

        form.setElectronicContactList(new ArrayList<ElectronicContact>());
        form.getElectronicContactList().addAll(account.getElectronicContacts());

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=update")
    public ModelAndView update(@ModelAttribute("KualiForm") BiographicForm form, HttpServletRequest request) {

        Account account = form.getAccount();
        String userid = account.getId();

        try{

            List<PersonName> personList = form.getPersonNameList();
            for(PersonName person : personList) {
                if(person.getId() == null){
                    accountService.addPersonName(userid, person);
                } else {
                    accountService.persistPersonName(person);
                }
            }

            List<PostalAddress> addressList = form.getPostalAddressList();
            for(PostalAddress address : addressList) {
                if(address.getId() == null){
                    accountService.addPostalAddress(userid, address);
                } else {
                    accountService.persistPostalAddress(address);
                }
            }

            List<ElectronicContact> contactList = form.getElectronicContactList();
            for(ElectronicContact contact : contactList) {
                if(contact.getId() == null){
                    accountService.addElectronicContact(userid, contact);
                } else {
                    accountService.persistElectronicContact(contact);
                }
            }

            GlobalVariables.getMessageMap().putInfo("BiographicView", RiceKeyConstants.ERROR_CUSTOM, "Saved");
        } catch(Throwable t){
            GlobalVariables.getMessageMap().putInfo("BiographicView", RiceKeyConstants.ERROR_CUSTOM, "Error saving data: " + t.getLocalizedMessage());
        }

        return getUIFModelAndView(form);
    }

}
