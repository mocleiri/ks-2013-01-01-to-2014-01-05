package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.AccountRefundForm;
import com.sigmasys.kuali.ksa.krad.model.PotentialRefundModel;
import com.sigmasys.kuali.ksa.krad.model.RefundModel;
import com.sigmasys.kuali.ksa.krad.util.RefundDateRangeKeyValuesFinder;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.RefundService;
import com.sigmasys.kuali.ksa.util.TransactionUtils;
import org.apache.commons.lang.StringUtils;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The Controller for the Account Refund page.
 * <p/>
 * <p/>
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

    @Autowired
    private RefundService refundService;

    @Autowired
    private InformationService informationService;


    /**
     * Generates an initial form object for the Account Refund page.
     *
     * @param request Request object.
     * @return The initial form.
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

        // Set the defaults:
        Calendar calendar = Calendar.getInstance();

        form.setDateRangeType(RefundDateRangeKeyValuesFinder.ALL);
        form.setFilterDateTo(calendar.getTime());
        calendar.add(Calendar.YEAR, -1);
        form.setFilterDateFrom(calendar.getTime());
        form.setPotentialRefunds(new ArrayList<PotentialRefundModel>());
        form.setAllRefunds(new ArrayList<RefundModel>());

        // Set statistics:
        form.setFlags(informationService.getFlags(userId));
        form.setAlerts(informationService.getAlerts(userId));

        return form;
    }

    /**
     * Called when the form is initially opened.
     *
     * @param form The form object associated with the Account Refund page.
     * @return ModelAndView for the page.
     * @throws Exception If any errors occur.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=displayInitialPage")
    public ModelAndView displayInitialPage(@ModelAttribute("KualiForm") AccountRefundForm form,
                                           @RequestParam("userId") String userId) throws Exception {
        // Find all refunds:
        findAllRefunds(form, userId);

        return getUIFModelAndView(form);
    }

    /**
     * Invoked when the "Search" button is pressed. Performs Refund search and populates
     * the form object to be displayed on the screen.
     *
     * @param form The form object associated with the Account Refund page.
     * @return ModelAndView for the page.
     * @throws Exception If there are any errors search for Refunds.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=searchForRefunds")
    public ModelAndView searchForRefunds(@ModelAttribute("KualiForm") AccountRefundForm form,
                                         @RequestParam("userId") String userId) throws Exception {
        // Refresh the view with the updated filtering criteria:
        findAllRefunds(form, userId);

        return getUIFModelAndView(form);
    }

    /**
     * Invoked when the "Verify Selected Refunds" button is pressed.
     *
     * @param form The form object.
     * @return The ModelAndView for the page.
     * @throws Exception If there are any errors.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=verifySelectedRefunds")
    public ModelAndView verifySelectedRefunds(@ModelAttribute("KualiForm") AccountRefundForm form) throws Exception {
        // TODO: Implement the logic of Refund verification:

        return getUIFModelAndView(form);
    }

    /**
     * Invoked when the "Cancel Selected Refunds" button is pressed.
     *
     * @param form The form object.
     * @return The ModelAndView for the page.
     * @throws Exception If there are any errors.
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
     * Searches for all Refunds and compiles a list of PotentialRefundModel and Refund objects.
     * Sets the lists of Potential and all Refunds on the given form object.
     *
     * @param form The form object.
     */
    private void findAllRefunds(AccountRefundForm form, String userId) {
        // Calculate the filtering date range:
        String dateRangeType = form.getDateRangeType();
        Date filterDateFrom = null;
        Date filterDateTo = null;

        if (StringUtils.equals(dateRangeType, RefundDateRangeKeyValuesFinder.RANGE)) {
            filterDateFrom = (form.getFilterDateFrom() != null) ? form.getFilterDateFrom() : new Date(0);
            filterDateTo = (form.getFilterDateTo() != null) ? form.getFilterDateTo() : new Date();
        } else { // ALL Dates
            filterDateFrom = new Date(0);
            filterDateTo = new Date();
        }

        // Create model objects to display in the tables:
        List<RefundModel> refundModels = createRefundModelList(userId, filterDateFrom, filterDateTo);
        List<PotentialRefundModel> potentialRefundModels = createPotentialRefundList(userId, filterDateFrom, filterDateTo);

        form.setAllRefunds(refundModels);
        form.setPotentialRefunds(potentialRefundModels);
    }

    /**
     * Creates a list of RefundModel objects to be displayed in the "Refund Status" table.
     *
     * @param userId   The current account Id.
     * @param dateFrom Filtering date from.
     * @param dateTo   Filtering date to.
     * @return
     */
    private List<RefundModel> createRefundModelList(String userId, Date dateFrom, Date dateTo) {
        // Get all Refunds for the current Account:
        List<Refund> refunds = refundService.checkForRefund(userId, dateFrom, dateTo);

        // Create a list of RefundModel objects:
        List<RefundModel> refundModels = new ArrayList<RefundModel>();

        if (refunds != null) {
            for (Refund refund : refunds) {
                // Create a new RefundModel object:
                RefundModel refundModel = new RefundModel();

                refundModel.setRefund(refund);
                refundModel.setRefundStatusDisplay(refund.getStatus().toString());
                refundModels.add(refundModel);
            }
        }

        return refundModels;
    }

    /**
     * Creates a list of PotentialRefundModel objects to be displayed in the "Refund Status" table.
     *
     * @param userId   The current account Id.
     * @param dateFrom Filtering date from.
     * @param dateTo   Filtering date to.
     * @return
     */
    private List<PotentialRefundModel> createPotentialRefundList(String userId, Date dateFrom, Date dateTo) {

        // Get Transactions for the current account within the specified date range.
        List<PotentialRefundModel> potentialRefundModels = new ArrayList<PotentialRefundModel>();
        List<Transaction> transactions = transactionService.getTransactions(userId, dateFrom, dateTo);

        for (Transaction t : transactions) {

            // Add new PotentialRefundModel object:
            PotentialRefundModel potentialRefundModel = new PotentialRefundModel(t);

            potentialRefundModels.add(potentialRefundModel);
        }

        return potentialRefundModels;
    }
}
