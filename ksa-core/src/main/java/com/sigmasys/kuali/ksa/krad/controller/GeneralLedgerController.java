package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.ReportReconciliationForm;
import com.sigmasys.kuali.ksa.krad.model.BatchTransmission;
import com.sigmasys.kuali.ksa.krad.model.BatchTransmissionModel;
import com.sigmasys.kuali.ksa.model.GeneralLedgerType;
import com.sigmasys.kuali.ksa.model.GlTransmission;
import com.sigmasys.kuali.ksa.service.GeneralLedgerService;
import com.sigmasys.kuali.ksa.util.TransactionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.mutable.MutableDouble;
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
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 3/12/13
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/generalLedger")
public class GeneralLedgerController extends DownloadController {

    @Autowired
    private GeneralLedgerService generalLedgerService;


    /**
     * Creates an initial form, which is the GeneralLedger page form.
     */
    @Override
    protected UifFormBase createInitialForm(HttpServletRequest request) {
        // Create a new form:
        ReportReconciliationForm form = new ReportReconciliationForm();

        return form;
    }

    /**
     * Displays the initial page.
     *
     * @param form GeneralLedger form.
     * @return ModelAndView for the initial page.
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=displayGeneralLedger")
    public ModelAndView displayGeneralLedger(@ModelAttribute("KualiForm") ReportReconciliationForm form) {
        return getUIFModelAndView(form);
    }

    /**
     * Searches for Prior Batches and displays them on the page.
     *
     * @param form GeneralLedger form.
     * @return ModelAndView for the page.
     */
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, params = "methodToCall=searchForPriorBatches")
    public ModelAndView searchForPriorBatches(@ModelAttribute("KualiForm") ReportReconciliationForm form) {
        // Find GL Transmissions, create BatchTransmission Map by Batch ID:
        List<GlTransmission> glTransmissions = generalLedgerService.getGlTransmissionsForExport();
        MutableDouble totalAllBatches = new MutableDouble(0);
        Map<String,BatchTransmission> batchTransmissionMap = createBatchTransmissionMap(glTransmissions, totalAllBatches);

        // Create a list of BatchTransmissionModel objects:
        List<BatchTransmissionModel> priorBatches = new ArrayList<BatchTransmissionModel>();

        for (String batchId : batchTransmissionMap.keySet()) {
            // Get a BatchTransmission and create a BatchTransmissionModel out of it:
            BatchTransmission batchTransmission = batchTransmissionMap.get(batchId);
            BatchTransmissionModel batchTransmissionModel = new BatchTransmissionModel();

            batchTransmissionModel.setBatchId(batchId);
            batchTransmissionModel.setTransmissionDate(batchTransmission.getDate());
            batchTransmissionModel.setFormattedAmount(TransactionUtils.getFormattedAmount(batchTransmission.getTotalAmount()));

            // Add to the list:
            priorBatches.add(batchTransmissionModel);
        }

        // Set objects on the form:
        form.setPriorBatchTransmissions(priorBatches);
        form.setAllPriorBatchTotal(TransactionUtils.getFormattedAmount(new BigDecimal(totalAllBatches.doubleValue())));

        return getUIFModelAndView(form);
    }

    /**
     * Searches for GL Accounts that have Pending Transactions and displays them on the page.
     *
     * @param form GeneralLedger form.
     * @return ModelAndView for the page.
     */
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, params = "methodToCall=searchForPendingTransactions")
    public ModelAndView searchForPendingTransactions(@ModelAttribute("KualiForm") ReportReconciliationForm form) {
        // Find pending transactions:

        // Set objects on the form:

        return getUIFModelAndView(form);
    }

    /**
     * Exports all Pending Transactions to the General ledger and starts download.
     *
     * @param form  The form object.
     * @return         null because we want to stay on the same page when download starts.
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=exportAllPendingTransactions")
    public ModelAndView exportAllPendingTransactions (@ModelAttribute("KualiForm") ReportReconciliationForm form){
        // Retrieve a list of Pending Transactions for all GL Accounts:

        return null;
    }

    /**
     * Generates a list of Prior Batch Transactions for a GL Account and starts download.
     *
     *
     * @param form      The form object.
     * @param batchId   Batch ID.
     * @return          null because we want to stay on the same page when download starts.
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=downloadPriorBatchTransactions")
    public ModelAndView downloadPriorBatchTransactions(@ModelAttribute("KualiForm") ReportReconciliationForm form, @RequestParam("batchId") String batchId) {
        // Retrieve a list of Transactions for a Batch:

        return null;
    }

    /**
     * Retrieves a list of Pending Transactions for a GL Account. Used as an AJAX call handler.
     *
     * @param form          The form object.
     * @param glAccountId   GL Account ID.
     * @return              null for AJAX requests to stay on the same page.
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=getPendingTransactionForGlAccount")
    public ModelAndView getPendingTransactionForGlAccount(@ModelAttribute("KualiForm") ReportReconciliationForm form, @RequestParam("glAccountId") String glAccountId) {
        // Retrieve a list of Pending Transactions for a GL Account:

        return null;
    }

    /**
     * Retrieves a list of GL Accounts for a Batch. Used as an AJAX call handler.
     *
     * @param form      The form object.
     * @param batchId   Batch ID.
     * @return          null for AJAX requests to stay on the same page.
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=getGlAccountsForBatch")
    public ModelAndView getGlAccountsForBatch(@ModelAttribute("KualiForm") ReportReconciliationForm form, @RequestParam("batchId") String batchId) {
        // Retrieve a list of GL Accounts for a Batch:

        return null;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Helper Methods.
    //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Creates a Map of all Batches mapped to BatchTransmission objects that contain
     * their related GL Account Types.
     *
     * @param glTransmissions   All GL Transmissions.
     * @param totalAllBatches   The total for all batches. This is an OUT parameter.
     * @return  a Map of all Batches IDs mapped to BatchTransmission objects.
     */
    private Map<String, BatchTransmission> createBatchTransmissionMap(List<GlTransmission> glTransmissions,
                                                                      MutableDouble totalAllBatches) {
        // Create the result Map:
        Map<String, BatchTransmission> result = new HashMap<String, BatchTransmission>();

        // Go through the list of GLTransmissions
        for (GlTransmission glTransmission : glTransmissions) {
            // Get the batch ID from the current transmission:
            String batchId = glTransmission.getBatchId();

            if (StringUtils.isNotEmpty(batchId)) {
                // See if the current GlTransmission is already mapped to a BatchTransmission:
                BatchTransmission batchTransmission = result.get(batchId);

                // If not mapped yet, create a new BatchTransmission, set attributes and map it:
                if (batchTransmission == null) {
                    batchTransmission = new BatchTransmission();
                    batchTransmission.setBatchId(batchId);
                    batchTransmission.setDate(glTransmission.getDate());
                    batchTransmission.setGlAccounts(new ArrayList<GeneralLedgerType>());
                    batchTransmission.setTotalAmount(new BigDecimal(0));
                    result.put(batchId, batchTransmission);
                }

                // Add the current transmission's amount to the total:
                if (glTransmission.getAmount() != null) {
                    BigDecimal transmissionAmount = glTransmission.getAmount();
                    BigDecimal newTotal = batchTransmission.getTotalAmount().add(transmissionAmount);

                    batchTransmission.setTotalAmount(newTotal);
                    totalAllBatches.add(transmissionAmount);
                }

                // TODO:Add GL Account to the list of all accounts in the batch:
                // Need to figure out how to link GL Accounts to GL Transmissions.
            }
        }

        return result;
    }
}
