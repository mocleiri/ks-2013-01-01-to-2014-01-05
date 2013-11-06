package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.CashLimitForm;
import com.sigmasys.kuali.ksa.krad.form.TransactionFilterForm;
import com.sigmasys.kuali.ksa.krad.model.CashLimitEventModel;
import com.sigmasys.kuali.ksa.model.CashLimitEvent;
import com.sigmasys.kuali.ksa.service.CashLimitService;
import com.sigmasys.kuali.ksa.service.ReportService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This controller serves requests from the "Batch - Combined Cash Limit" page.
 *
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 11/5/13
 * Time: 2:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/batchCashLimitView")
public class CombinedCashLimitController extends TransactionFilterController {

    private static final Log logger = LogFactory.getLog(CombinedCashLimitController.class);

    /**
     * Date formatter.
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    private CashLimitService cashLimitService;

    @Autowired
    private ReportService reportService;


    /**
     * Called by the framework to create the initial form object.
     *
     * @param request HTTP request.
     * @return The initial form object.
     */
    @Override
    protected CashLimitForm createInitialForm(HttpServletRequest request) {

        // Create a new form:
        CashLimitForm form = new CashLimitForm();

        initializeForm(form);

        // Set defaults:
        form.setCashLimitEvents(new ArrayList<CashLimitEventModel>());

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
    public ModelAndView displayInitialPage(@ModelAttribute("KualiForm") CashLimitForm form) throws Exception {
        // Get the model data:
        refreshModel(form);

        return getUIFModelAndView(form);
    }

    /**
     * Invoked to download a Complete CashLimitEvent XML.
     * Returns null to stay on the same page after download starts.
     *
     * @param form              Form object.
     * @return null to stay on the same page after download starts.
     * @throws Exception If an error occurs.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=downloadGeneratedArchiveXml")
    public ModelAndView downloadGeneratedArchiveXml(@ModelAttribute("KualiForm") CashLimitForm form) throws Exception {

        return null;
    }

    /**
     * Invoked to download a Complete CashLimitEvent XML.
     * Returns null to stay on the same page after download starts.
     *
     * @param form              Form object.
     * @param response          HTTP response.
     * @param cashLimitEventId  ID of a Cash Limit Event.
     * @param accountId         ID of an Account for which the report is to be generated.
     * @param eventDateString   String representation of the event date.
     * @return null to stay on the same page after download starts.
     * @throws Exception If an error occurs.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=downloadCashEventXml")
    public ModelAndView downloadCashEventXml(@ModelAttribute("KualiForm") CashLimitForm form,
                                             HttpServletResponse response,
                                             @RequestParam("cashLimitEventId") Long cashLimitEventId,
                                             @RequestParam("accountId") String accountId,
                                             @RequestParam("eventDateString") String eventDateString) throws Exception {

        // Generate an IRS form 8300 and start downloading:
        String form8300 = null;

        // Get the form from the ReportService:
        try {
            form8300 = reportService.generateIrs8300Report(cashLimitEventId);
        } catch (Exception e) {
            logger.error("Error generating form 8300. See log file for details.", e);
        }

        // Reset the error message:
        form.setXmlGenerationError(null);

        // If the form content is available, start download:
        if (StringUtils.isNotEmpty(form8300)) {
            // Start download:
            String reportFileName = generateReportFileName(accountId, eventDateString);

            doDownload(form8300, reportFileName, "application/xml", response);
        } else {
            // Set the error on the form and return the ModelAndView:
            form.setXmlGenerationError("Error generating IRS form 8300. See log file for details.");

            return getUIFModelAndView(form);
        }

        return null;
    }

    /**
     * Invoked when the "Submit" button is pressed.
     *
     * @param form      The form object.
     * @return          ModelAndView
     * @throws Exception If an error occurs.
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=submitCashAccounts")
    public ModelAndView submitCashAccounts(@ModelAttribute("KualiForm") CashLimitForm form) throws Exception {

        // Refresh the model:
        refreshModel(form);

        return getUIFModelAndView(form);
    }

    /**
     * Refreshes the underlying data model. This action happens after a filter
     * is changes and a refresh is required to apply the changed filter.
     *
     * @param form  The form object.
     */
    @Override
    protected void refreshModel(TransactionFilterForm form) {

        // Create a List of CashModelEventModel objects:
        List<CashLimitEventModel> cashLimitEventModels = createCashLimitEventModelList(form);

        // Set the models on the form:
        ((CashLimitForm)form).setCashLimitEvents(cashLimitEventModels);
    }


    /***********************************************************************************************
     *
     * Helper methods.
     *
     ***********************************************************************************************/

    /**
     * Creates a List of CashLimitEvent model objects.
     *
     * @param form  The form object.
     * @return A List of CashLimitEvent model objects.
     */
    private <T extends TransactionFilterForm> List<CashLimitEventModel> createCashLimitEventModelList(T form) {

        // Get the selected Account IDs:
        List<String> accountIds = getFilterAccountIds(form);
        List<CashLimitEventModel> cashLimitEventModels = new ArrayList<CashLimitEventModel>();

        // Get CashLimitEvent objects for the selected Accounts:
        if (CollectionUtils.isNotEmpty(accountIds)) {

            List<CashLimitEvent> cashLimitEvents = cashLimitService.getCashLimitEvents(accountIds);

            if (CollectionUtils.isNotEmpty(cashLimitEvents)) {

                for (CashLimitEvent cashLimitEvent : cashLimitEvents) {

                    // Create a CashLimitEventModel for each object:
                    CashLimitEventModel model = createCashLimitEventModel(cashLimitEvent);

                    cashLimitEventModels.add(model);
                }
            }
        }

        return cashLimitEventModels;
    }

    /**
     * Creates a CashLimitEventModel object from the given CashLimitEvent object.
     *
     * @param cashLimitEvent A CashLimitEvent object.
     * @return A CashLimitEventModel object.
     */
    private CashLimitEventModel createCashLimitEventModel(CashLimitEvent cashLimitEvent) {

        // Create a new model object:
        CashLimitEventModel model = new CashLimitEventModel();
        Date eventDate = cashLimitEvent.getEventDate();
        String eventDateString = (eventDate != null) ? DATE_FORMAT.format(eventDate) : null;

        // Set the values:
        model.setCashLimitEvent(cashLimitEvent);
        model.setSelected(true);
        model.setStatusString(cashLimitEvent.getStatus().toString());
        model.setEventDateString(eventDateString);

        return model;
    }

    /**
     * Creates a name for a 8300 XML report.
     *
     * @param accountId         ID of the account.
     * @param eventDateString   Event date as String.
     * @return Report file name.
     */
    private String generateReportFileName(String accountId, String eventDateString) {

        // Compose report file name:
        String reportFileName = String.format("%s--Combined_Cash_Limit_%s.xml", accountId,
                StringUtils.defaultString(eventDateString));

        return reportFileName;
    }
}
