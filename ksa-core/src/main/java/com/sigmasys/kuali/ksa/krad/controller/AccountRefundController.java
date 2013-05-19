package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.AccountRefundForm;
import com.sigmasys.kuali.ksa.krad.form.ReportReconciliationForm;
import com.sigmasys.kuali.ksa.krad.model.PotentialRefund;
import com.sigmasys.kuali.ksa.krad.model.RefundModel;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Tag;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * The Controller for the Account Refund page.
 *
 *
 * User: Sergey
 * Date: 5/18/13
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/accountRefund")
public class AccountRefundController extends DownloadController {

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private AccountService accountService;


    /**
     * Generates an initial form object for the Account Refund page.
     *
     * @param request   Request object.
     * @return          The initial form.
     */
    @Override
    protected UifFormBase createInitialForm(HttpServletRequest request) {
        // Create a new form:
        AccountRefundForm form = new AccountRefundForm();

        // Initialize the Account:
        String userId = request.getParameter("userId");
        Account account = accountService.getFullAccount(userId);

        if (account != null) {
            form.setAccount(account);
        }

        return form;
    }

    /**
     * Called when the form is initially opened.
     *
     * @param form          The form object associated with the Account Refund page.
     * @return              ModelAndView for the page.
     * @throws Exception    If any errors occur.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=displayInitialPage")
    public ModelAndView displayInitialPage(@ModelAttribute("KualiForm") AccountRefundForm form) throws Exception {
        // TODO: Implement initial page population:

        return getUIFModelAndView(form);
    }

    /**
     * Invoked when the "Search" button is pressed. Performs Refund search and populates
     * the form object to be displayed on the screen.
     *
     * @param form          The form object associated with the Account Refund page.
     * @return              ModelAndView for the page.
     * @throws Exception    If there are any errors search for Refunds.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=searchForRefunds")
    public ModelAndView searchForRefunds(@ModelAttribute("KualiForm") AccountRefundForm form) throws Exception {
        // TODO: Implement search for refunds:

        return getUIFModelAndView(form);
    }

    /**
     * Invoked when the "Verify Selected Refunds" button is pressed.
     *
     * @param form          The form object.
     * @return              The ModelAndView for the page.
     * @throws Exception    If there are any errors.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=verifySelectedRefunds")
    public ModelAndView verifySelectedRefunds(@ModelAttribute("KualiForm") AccountRefundForm form) throws Exception {
        // TODO: Implement the logic of Refund verification:

        return getUIFModelAndView(form);
    }

    /**
     * Invoked when the "Cancel Selected Refunds" button is pressed.
     *
     * @param form          The form object.
     * @return              The ModelAndView for the page.
     * @throws Exception    If there are any errors.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=cancelSelectedRefunds")
    public ModelAndView cancelSelectedRefunds(@ModelAttribute("KualiForm") AccountRefundForm form) throws Exception {
        // TODO: Implement the logic of Refund cancellation:

        return getUIFModelAndView(form);
    }


    /* ********************************************************************
   *
   * Helper methods.
   *
   * ********************************************************************/

    /**
     * Returns all entities of the Tag type.
     *
     * @return All Tag entities.
     */
    private List<Tag> getAllTags() {
        // Get all Tags from the AuditableEntityService:
        return auditableEntityService.getAuditableEntities(Tag.class);
    }


    /**
     * Searches for all potential Refunds and compiles a list of PotentialRefund objects.
     *
     * @param form  The form object.
     * @return      A list of PotentialRefund objects.
     */
    private List<PotentialRefund> findPotentialRefunds(AccountRefundForm form) {
        // TODO: Find all potential Refunds and compile a list of table objects:

        return new ArrayList<PotentialRefund>();
    }

    /**
     * Searches for all matching Refund objects based on the selected search criteria.
     *
     * @param form  The form object.
     * @return      A list of all matching refunds based on the search criteria.
     */
    private List<RefundModel> findRefunds(AccountRefundForm form) {
        // TODO: Apply the search criteria and find all matching Refunds:

        return new ArrayList<RefundModel>();
    }

 }
