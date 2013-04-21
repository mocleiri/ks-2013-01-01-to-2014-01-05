package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.ReportReconciliationForm;
import com.sigmasys.kuali.ksa.krad.model.BatchTransmissionModel;
import com.sigmasys.kuali.ksa.krad.model.GeneralLedgerAccountModel;
import com.sigmasys.kuali.ksa.model.GeneralLedgerType;
import com.sigmasys.kuali.ksa.model.GlOperationType;
import com.sigmasys.kuali.ksa.model.GlTransmission;
import com.sigmasys.kuali.ksa.model.GlTransmissionStatus;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
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

    @Autowired
    private AuditableEntityService auditableEntityService;


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
        // Find GL Transmissions, create BatchTransmissionModel List:
        List<GlTransmission> glTransmissions = generalLedgerService.getGlTransmissions(
                GlTransmissionStatus.TRANSMITTED, GlTransmissionStatus.COMPLETED);
        MutableDouble totalAllBatches = new MutableDouble(0);
        List<BatchTransmissionModel> batchTransmissions = createBatchTransmissionList(glTransmissions, totalAllBatches);

        // Set objects on the form:
        form.setPriorBatchTransmissions(batchTransmissions);
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
     * Creates a List of all BatchTransmissionModel objects that contain
     * their related GL Account Types.
     *
     * @param glTransmissions   All GL Transmissions.
     * @param grandTotalAmount  The total for all batches. This is an OUT parameter.
     * @return  a List of all BatchTransmissionModel objects.
     */
    private List<BatchTransmissionModel> createBatchTransmissionList(List<GlTransmission> glTransmissions,
                                                                      MutableDouble grandTotalAmount) {
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
     * @param generalLedgerTypes    A list of GL Types.
     * @param glAccountId           ID of a GL Account.
     * @return                      A matching GL Type or <code>null</code> if no match can be found.
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
     * @param glTransmission        A GlTransmission.
     * @param generalLedgerTypes    A list of all existing GlTypes.
     * @param glAccountModels       A list of GeneralLedgerAccountModel objects belonging to a BatchTransmissionModel.
     * @param grandTotalAmount      The grand total for all Batch Transmissions.
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
        GeneralLedgerAccountModel glAccount =null;

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
}
