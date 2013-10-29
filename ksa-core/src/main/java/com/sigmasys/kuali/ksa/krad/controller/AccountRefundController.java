package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.AccountRefundForm;
import com.sigmasys.kuali.ksa.krad.model.PotentialRefundModel;
import com.sigmasys.kuali.ksa.krad.model.RefundModel;
import com.sigmasys.kuali.ksa.krad.model.RequestPotentialRefundSummaryModel;
import com.sigmasys.kuali.ksa.krad.util.AccountUtils;
import com.sigmasys.kuali.ksa.krad.util.RefundDateRangeKeyValuesFinder;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.*;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The Controller for the Account Refund page.
 * <p/>
 * <p/>
 *
 * @author Sergey Godunov
 */
@Controller
@RequestMapping(value = "/accountRefund")
public class AccountRefundController extends DownloadController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RefundService refundService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private PaymentService paymentService;


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
        AccountUtils.populateTransactionHeading(form, userId);

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
     * This method is called when the "Request Refund" button on the "Potential Refunds" tab is pressed.
     *
     *
     * @param form The form object associated with the Account Refund page.
     * @param userId Current Account ID.
     * @return ModelAndView.
     * @throws Exception If an error occurs.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=requestRefund")
    public ModelAndView requestRefund(@ModelAttribute("KualiForm") AccountRefundForm form,
                                      @RequestParam("userId") String userId) throws Exception {

        // Process Refund request for all selected Potential Refunds:
        processRequestPotentialRefund(form);

        // Run Payment Application, if selected:
        if (form.isRunPaymentApplication() && form.isRunPaymentApplicationEnabled()) {
            paymentService.paymentApplication(userId);
        }

        return getUIFModelAndView(form);
    }

    /**
     * TEST METHOD: Creates a bunch of test refunds. This method will be deleted when demo data includes
     * test refunds.
     *
     * @param form   The form object.
     * @param userId ID of the user.
     * @return ModelAndView.
     * @throws Exception
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=createTestRefunds")
    public ModelAndView createTestRefunds(@ModelAttribute("KualiForm") AccountRefundForm form,
                                          @RequestParam("userId") String userId) throws Exception {

        // Creates test refunds in the database:
        Transaction transaction = transactionService.createTransaction("cash", userId, new Date(), new BigDecimal(10e5));
        Payment payment = (Payment) transaction;

        payment.setRefundable(true);
        payment.setRefundRule(String.format("A(9)(%s)", userId));

        refundService.checkForRefund(payment.getId());

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
     * Searches for all Refunds and compiles a list of PotentialRefundModel and Refund objects.
     * Sets the lists of Potential and all Refunds on the given form object.
     *
     * @param form The form object.
     */
    private void findAllRefunds(AccountRefundForm form, String userId) {

        Date filterDateFrom;
        Date filterDateTo;

        if (StringUtils.equals(form.getDateRangeType(), RefundDateRangeKeyValuesFinder.RANGE)) {
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
     * @return list of RefundModel instances
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
     * @return list of potential refunds
     */
    private List<PotentialRefundModel> createPotentialRefundList(String userId, Date dateFrom, Date dateTo) {

        // Get Payments for the current account within the specified date range.

        List<Payment> payments = transactionService.getPotentialRefunds(userId, dateFrom, dateTo);

        List<PotentialRefundModel> potentialRefundModels = new ArrayList<PotentialRefundModel>(payments.size());

        for (Payment payment : payments) {
            potentialRefundModels.add(new PotentialRefundModel(payment));
        }

        return potentialRefundModels;
    }

    /**
     * Processes the "Request Refund" action for all selected Potential Refunds.
     *
     * @param form The form object.
     */
    private void processRequestPotentialRefund(AccountRefundForm form) {

        // Figure out the eligibility for a Refund Request:
        List<PotentialRefundModel> selectedPotentialRefunds = getSelectedPotentialRefunds(form);
        List<PotentialRefundModel> eligibleForRefund = new ArrayList<PotentialRefundModel>();
        List<PotentialRefundModel> notEligibleForRefund = new ArrayList<PotentialRefundModel>();

        for (PotentialRefundModel potentialRefund : selectedPotentialRefunds) {
            Long paymentId = potentialRefund.getId();

            try {
                // Generate a Refund:
                Refund refund = refundService.checkForRefund(paymentId, potentialRefund.getRefundAmount());

                // If Refund generated without errors, add to eligible:
                if (refund != null) {
                    logger.info(String.format("Successfully generated a Refund for Payment with ID %d", paymentId));
                    eligibleForRefund.add(potentialRefund);
                } else {
                    // If no Refund was generated, log an error and add to ineligible:
                    logger.error(String.format("Error generating refund for Payment ID %d", paymentId));
                    notEligibleForRefund.add(potentialRefund);
                }
            } catch (Exception e) {
                // Log an error and add to ineligible:
                logger.error(String.format("Error generating refund for Payment ID %d", paymentId), e);
                notEligibleForRefund.add(potentialRefund);
            }
        }

        // Set the eligible an ineligible Potential Refunds:
        RequestPotentialRefundSummaryModel summary = form.getRequestRefundSummary();

        summary.setEligiblePotentialRefunds(eligibleForRefund);
        summary.setNotEligiblePotentialRefunds(notEligibleForRefund);

        // Calculate the totals for the Request Refund summary:
        calculateRefundRequestSummaryTotals(summary);
    }

    /**
     * Returns only the selected potential refund list.
     * @param form The form
     * @return Only the selected Potential Refunds.
     */
    List<PotentialRefundModel> getSelectedPotentialRefunds(AccountRefundForm form) {

        List<PotentialRefundModel> allPotentialRefunds = form.getPotentialRefunds();
        List<PotentialRefundModel> selectedRefunds = new ArrayList<PotentialRefundModel>();

        if (allPotentialRefunds != null) {
            for (PotentialRefundModel refund : allPotentialRefunds) {
                if (refund.isSelected()) {
                    selectedRefunds.add(refund);
                }
            }
        }

        return selectedRefunds;
    }

    /**
     * Calculates totals for the Refund Request summary.
     *
     * @param summary The summary object.
     */
    private void calculateRefundRequestSummaryTotals(RequestPotentialRefundSummaryModel summary) {

        // All totals:
        BigDecimal totalEligiblePayment = new BigDecimal(0);
        BigDecimal totalEligibleAllocated = new BigDecimal(0);
        BigDecimal totalEligibleUnallocated = new BigDecimal(0);
        BigDecimal totalEligibleRefundAmount = new BigDecimal(0);
        BigDecimal totalNotEligiblePayment = new BigDecimal(0);
        BigDecimal totalNotEligibleAllocated = new BigDecimal(0);
        BigDecimal totalNotEligibleUnallocated = new BigDecimal(0);
        BigDecimal totalNotEligibleRefundAmount = new BigDecimal(0);

        // Go through the list of Eligible Refunds:
        for (PotentialRefundModel refund : summary.getEligiblePotentialRefunds()) {
            // Adjust the totals:
            totalEligibleAllocated = safeAdd(totalEligibleAllocated, refund.getAllocatedAmount());
            totalEligiblePayment = safeAdd(totalEligiblePayment, refund.getPaymentAmount());
            totalEligibleRefundAmount = safeAdd(totalEligibleRefundAmount, refund.getRefundAmount());
            totalEligibleUnallocated = safeAdd(totalEligibleUnallocated, refund.getUnallocatedAmount());
        }

        // Set the Eligible totals:
        summary.setTotalEligibleAllocated(totalEligibleAllocated);
        summary.setTotalEligiblePayment(totalEligiblePayment);
        summary.setTotalEligibleUnallocated(totalEligibleUnallocated);
        summary.setTotalEligibleRefundAmount(totalEligibleRefundAmount);

        // Go through the list of Ineligible Refunds:
        for (PotentialRefundModel refund : summary.getNotEligiblePotentialRefunds()) {
            // Adjust the totals:
            totalNotEligibleAllocated = safeAdd(totalNotEligibleAllocated, refund.getAllocatedAmount());
            totalNotEligiblePayment = safeAdd(totalNotEligiblePayment, refund.getPaymentAmount());
            totalNotEligibleRefundAmount = safeAdd(totalNotEligibleRefundAmount, refund.getRefundAmount());
            totalNotEligibleUnallocated = safeAdd(totalNotEligibleUnallocated, refund.getUnallocatedAmount());
        }

        // Set the Not Eligible totals:
        summary.setTotalNotEligibleAllocated(totalNotEligibleAllocated);
        summary.setTotalNotEligiblePayment(totalNotEligiblePayment);
        summary.setTotalNotEligibleRefundAmount(totalNotEligibleRefundAmount);
        summary.setTotalNotEligibleUnallocated(totalNotEligibleUnallocated);
    }

    /**
     * Safely adds one BigDecimal to another. Ignores null.
     *
     * @param bd1 First operand
     * @param bd2 Second operand
     * @return Result of addition.
     */
    private static BigDecimal safeAdd(BigDecimal bd1, BigDecimal bd2) {
        if ((bd1 != null) && (bd2 != null)) {
            bd1 = bd1.add(bd2);
        }
        return bd1;
    }
}
