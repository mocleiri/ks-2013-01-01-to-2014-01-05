package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.ReportReconciliationForm;
import com.sigmasys.kuali.ksa.krad.model.BatchTransmissionModel;
import com.sigmasys.kuali.ksa.krad.model.GeneralLedgerAccountModel;
import com.sigmasys.kuali.ksa.krad.model.GeneralLedgerTransactionModel;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.GeneralLedgerService;
import com.sigmasys.kuali.ksa.service.TransactionExportService;
import com.sigmasys.kuali.ksa.util.ErrorUtils;
import com.sigmasys.kuali.ksa.util.TransactionUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.mutable.MutableDouble;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.kew.rule.GenericRoleAttribute;
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
import java.io.PrintWriter;
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
public class GeneralLedgerController extends ReportReconciliationController {

    private static final Log logger = LogFactory.getLog(GeneralLedgerController.class);

    @Autowired
    private GeneralLedgerService generalLedgerService;

    @Autowired
    private AuditableEntityService auditableEntityService;


    /**
     * Displays the initial page.
     *
     * @param form GeneralLedger form.
     * @return ModelAndView for the initial page.
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, params = "methodToCall=displayGeneralLedger")
    public ModelAndView displayGeneralLedger(@ModelAttribute("KualiForm") ReportReconciliationForm form) {
        // At this time, we actively pre-generate the model for the view because KRAD is unable
        // to remember the tab selection or use asynchronous requests to load the data on-demand.
        searchForPriorBatches(form);
        searchForPendingTransactions(form);

        return getUIFModelAndView(form);
    }

    /**
     * Generates a list of Prior Batch Transactions for a GL Account and starts download.
     *
     * @param form    The form object.
     * @param batchId Batch ID.
     * @return null because we want to stay on the same page when download starts.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=downloadPriorBatchTransactions")
    public ModelAndView downloadPriorBatchTransactions(@ModelAttribute("KualiForm") ReportReconciliationForm form,
                    HttpServletResponse response, @RequestParam("batchId") String batchId) throws Exception {
        // Retrieve a list of Transactions for a Batch:
        String batchTransactionXML = null;
        String error = null;

        // Get the form from the ReportService:
        try {
            batchTransactionXML = transactionExportService.exportTransactionsForBatch(batchId);
        } catch (Exception e) {
            error = String.format("<h2>Error generating Prior Batch report. See log file for details.</h2><p><h4>%s</h4>",
                    StringUtils.defaultString(ErrorUtils.getMessage(e), "Contact your administrator for details."));
            logger.error(error, e);
        }

        // If the form content is available, start download:
        if (StringUtils.isNotEmpty(batchTransactionXML)) {
            // Start download:
            String reportFileName = generatePriorBatchReportFileName(batchId);

            doDownload(batchTransactionXML, reportFileName, "application/xml", response);
        } else {
            // Write an error message into the HTTP response:
            PrintWriter out = response.getWriter();
            out.println(error);
        }

        return null;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Helper Methods.
    //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Searches for Prior Batches and populates the form object.
     *
     * @param form The form object.
     */
    private void searchForPriorBatches(ReportReconciliationForm form) {
        // Create a BatchTransmissionModel List:
        MutableDouble grandTotal = new MutableDouble(0);
        List<BatchTransmissionModel> batchTransmissions = createBatchTransmissionList(grandTotal);

        // Set objects on the form:
        form.setPriorBatchTransmissions(batchTransmissions);
        form.setAllPriorBatchTotal(TransactionUtils.getFormattedAmount(new BigDecimal(grandTotal.doubleValue())));
    }

    /**
     * Searches for Pending transactions under GL Accounts and records them in the form.
     *
     * @param form The form object.
     */
    private void searchForPendingTransactions(ReportReconciliationForm form) {
        // Create a GeneralLedgerAccountModel List:
        MutableDouble grandTotal = new MutableDouble(0);
        List<GeneralLedgerAccountModel> glAccounts = createPendingTransactionGlAccountsList(grandTotal);

        // Set objects on the form:
        form.setGlAccountsPending(glAccounts);
        form.setAllGlAccountsTotal(TransactionUtils.getFormattedAmount(new BigDecimal(grandTotal.doubleValue())));
    }

    /**
     * Creates a List of all BatchTransmissionModel objects that contain
     * their related GL Account Types.
     *
     * @param grandTotalAmount The total for all batches. This is an OUT parameter.
     * @return a List of all BatchTransmissionModel objects.
     */
    private List<BatchTransmissionModel> createBatchTransmissionList(MutableDouble grandTotalAmount) {

        // Find all GL Transmissions in all statuses:
        List<GlTransmission> glTransmissions = generalLedgerService.getGlTransmissionsByStatuses(GlTransmissionStatus.TRANSMITTED);

        // Create a temporary Map of Batch IDs mapped to BatchTransmissionModel objects:
        Map<String, BatchTransmissionModel> result = new HashMap<String, BatchTransmissionModel>();

        // Declare, but not fetch yet, a list of all GL Types:
        List<GeneralLedgerType> generalLedgerTypes = null;

        // Go through the list of GLTransmissions
        for (GlTransmission glTransmission : glTransmissions) {

            // Get the batch ID from the current transmission:
            String batchId = glTransmission.getBatchId();

            if (StringUtils.isNotEmpty(batchId)) {

                // Initialize the list of GL Types if needed:
                if (generalLedgerTypes == null) {
                    generalLedgerTypes = auditableEntityService.getAuditableEntities(GeneralLedgerType.class);
                }

                // See if the current GlTransmission is already mapped to a BatchTransmissionModel:
                BatchTransmissionModel batchTransmission = result.get(batchId);

                // If not mapped yet, create a new BatchTransmissionModel, set attributes and map it:
                if (batchTransmission == null) {
                    batchTransmission = new BatchTransmissionModel();
                    batchTransmission.setBatchId(batchId);
                    batchTransmission.setTransmissionDate(glTransmission.getDate());
                    batchTransmission.setGlAccountSublist(new ArrayList<GeneralLedgerAccountModel>());
                    batchTransmission.setTotalAmount(new BigDecimal(0));
                    result.put(batchId, batchTransmission);
                }

                // Add a GL Account to the sub-list:
                addGlAccountModel(glTransmission, generalLedgerTypes, batchTransmission,
                        batchTransmission.getGlAccountSublist(), grandTotalAmount);
            }
        }

        return new ArrayList<BatchTransmissionModel>(result.values());
    }

    /**
     * Searches for a GL Type in the given list by its GL Account ID.
     *
     * @param generalLedgerTypes A list of GL Types.
     * @param glAccountId        ID of a GL Account.
     * @return A matching GL Type or <code>null</code> if no match can be found.
     */
    private GeneralLedgerType findGlType(List<GeneralLedgerType> generalLedgerTypes, String glAccountId) {
        for (GeneralLedgerType glType : generalLedgerTypes) {
            if (StringUtils.equalsIgnoreCase(glType.getGlAccountId(), glAccountId)) {
                return glType;
            }
        }

        return null;
    }

    /**
     * Creates a new GeneralLedgerAccountModel object from the given GlTransmission
     * and adds it to the given list. Or if one wiht a matching GL Account ID and Operation
     * Type already exists in the list, adds or subtracts the amount.
     *
     * @param glTransmission     A GlTransmission.
     * @param generalLedgerTypes A list of all existing GlTypes.
     * @param glAccountModels    A list of GeneralLedgerAccountModel objects belonging to a BatchTransmissionModel.
     * @param grandTotalAmount   The grand total for all Batch Transmissions.
     * @return A new GeneralLedgerAccountModel object created from the given GlTransmission.
     */
    private GeneralLedgerAccountModel addGlAccountModel(GlTransmission glTransmission,
                                                        List<GeneralLedgerType> generalLedgerTypes, BatchTransmissionModel batchTransmission,
                                                        List<GeneralLedgerAccountModel> glAccountModels, MutableDouble grandTotalAmount) {
        // Try to find a matching GL Type:
        String glAccountId = glTransmission.getGlAccountId();
        GeneralLedgerType glType = findGlType(generalLedgerTypes, glAccountId);
        String glAccountName = (glType != null)
                ? StringUtils.defaultIfBlank(glType.getDescription(), glType.getName()) : glAccountId;
        GlOperationType glOperationType = (glType != null)
                ? glType.getGlOperationOnCharge() : glTransmission.getGlOperation();
        GeneralLedgerAccountModel glAccount = null;

        // Try to find an existing GeneralLedgerAccountModel in the list:
        for (GeneralLedgerAccountModel glAccountModel : glAccountModels) {
            if (StringUtils.equals(glAccountId, glAccountModel.getGlAccountId())
                    && (glOperationType == glAccountModel.getOperationType())) {
                glAccount = glAccountModel;
                break;
            }
        }

        // Create a new GeneralLedgerAccountModel object if an existing one is not found:
        if (glAccount == null) {
            glAccount = new GeneralLedgerAccountModel();
            glAccount.setGlAccountId(glAccountId);
            glAccount.setName(glAccountName);
            glAccount.setOperationType(glOperationType);
            glAccount.setTotalAmount(new BigDecimal(0));
            glAccountModels.add(glAccount);
        }

        // Adjust the amount of the GeneralLedgerAccountModel object:
        BigDecimal adjustmentAmount = (glOperationType == GlOperationType.CREDIT)
                ? glTransmission.getAmount() : glTransmission.getAmount().negate();

        glAccount.setTotalAmount(glAccount.getTotalAmount().add(adjustmentAmount));

        // Adjust the total amount for the GlTransmission and the Grand Total:
        if (glType != null) {
            batchTransmission.setTotalAmount(batchTransmission.getTotalAmount().add(adjustmentAmount));
            grandTotalAmount.add(adjustmentAmount);
        }

        return glAccount;
    }

    /**
     * Generates a name for a Prior Batch transaction report file.
     *
     * @param batchId   Batch ID
     * @return          Batch transaction report file name.
     */
    private String generatePriorBatchReportFileName(String batchId) {
        return String.format("%s-General_Ledger_Transactions.xml", batchId);
    }

    /**
     * Creates a list of GeneralLedgerAccountModel that contain related Pending GL Transactions.
     *
     * @param grandTotalAmount  The grand total amount of all GL Accounts to populate after this method ends.
     * @return                  A list of GeneralLedgerAccountModel object for display.
     */
    private List<GeneralLedgerAccountModel> createPendingTransactionGlAccountsList(MutableDouble grandTotalAmount) {
        // Find all GL Transactions in the "Pending" status ('Q'):
        List<GlTransaction> pendingTransactions = generalLedgerService.getGlTransactionsByStatus(GlTransactionStatus.QUEUED);

        // Create a temporary Map of GL Account Ids mapped to GeneralLedgerAccountModel objects:
        Map<String,GeneralLedgerAccountModel> glAccountMap = new HashMap<String, GeneralLedgerAccountModel>();

        // Declare, but not fetch yet, a list of all GL Types:
        List<GeneralLedgerType> generalLedgerTypes = null;

        // Go through the list of all GL Transactions:
        for (GlTransaction glTransaction : pendingTransactions) {
            // Get the GL Account ID from the current GL Transaction:
            String glAccountId = glTransaction.getGlAccountId();

            if (StringUtils.isNotBlank(glAccountId)) {
                // Initialize the list of GL Types if needed:
                if (generalLedgerTypes == null) {
                    generalLedgerTypes = auditableEntityService.getAuditableEntities(GeneralLedgerType.class);
                }

                // Check if the current GL Account ID is already mapped to a GeneralLedgerAccountModel object:
                GeneralLedgerAccountModel glAccountModel = glAccountMap.get(glAccountId);

                // If not mapped yet, create a new GeneralLedgerAccountModel object and map it:
                if (glAccountModel == null) {
                    // Find a matching GL Type if one can be found:
                    GeneralLedgerType glType = findGlType(generalLedgerTypes, glAccountId);
                    String glAccountName = (glType != null)
                            ? StringUtils.defaultIfBlank(glType.getDescription(), glType.getName()) : glAccountId;
                    GlOperationType glOperationType = (glType != null)
                            ? glType.getGlOperationOnCharge() : glTransaction.getGlOperation();

                    glAccountModel = new GeneralLedgerAccountModel();
                    glAccountModel.setGlAccountId(glAccountId);
                    glAccountModel.setName(glAccountName);
                    glAccountModel.setOperationType(glOperationType);
                    glAccountModel.setTotalAmount(new BigDecimal(0));
                    glAccountMap.put(glAccountId, glAccountModel);
                }

                // Add a GL Transaction to the GL Account:
                addGlTransactionModel(glAccountModel, glTransaction, grandTotalAmount);
            }
        }

        return new ArrayList<GeneralLedgerAccountModel>(glAccountMap.values());
    }

    /**
     * Adds a GL Transaction to the given GeneralLedgerAccountModel object.
     * Adjusts the GL Account amount and the Grand total amount accordingly.
     * According to the logic, only those GL Transactions that point to a SINGLE
     * KSA Transactions are need for this view.
     *
     * @param glAccountModel    A GL Account to add a GL Transaction to.
     * @param glTransaction     A GL Transaction to add to the GL Account.
     * @param grandTotalAmount  The grand total amount for all GL Accounts.
     */
    private void addGlTransactionModel(GeneralLedgerAccountModel glAccountModel, GlTransaction glTransaction, MutableDouble grandTotalAmount) {
        // Get the list of KSA Transactions from the GL Transaction:
        Set<Transaction> ksaTransactions = glTransaction.getTransactions();

        if (CollectionUtils.size(ksaTransactions) == 1) {
            // Create a new GeneralLedgerTransactionModel and add it to the GL Account model object:
            Transaction ksaTransaction = (Transaction)CollectionUtils.get(ksaTransactions, 0);
            GeneralLedgerTransactionModel glTransactionModel = new GeneralLedgerTransactionModel();

            glTransactionModel.setGlTransaction(glTransaction);
            glTransactionModel.setKsaTransaction(ksaTransaction);
            glAccountModel.getGlTransactions().add(glTransactionModel);

            // Adjust the total for the GL Account and the Grand Total amount:
            BigDecimal adjustmentAmount = (glTransaction.getGlOperation() == GlOperationType.CREDIT)
                    ? glTransaction.getAmount() : glTransaction.getAmount().negate();

            glAccountModel.setTotalAmount(glAccountModel.getTotalAmount().add(adjustmentAmount));
            grandTotalAmount.add(adjustmentAmount);
        }
    }
}
