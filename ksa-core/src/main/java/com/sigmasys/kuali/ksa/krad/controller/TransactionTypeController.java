package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.TransactionTypeForm;
import com.sigmasys.kuali.ksa.krad.model.GlBreakdownModel;
import com.sigmasys.kuali.ksa.krad.model.TransactionTypeGroupModel;
import com.sigmasys.kuali.ksa.krad.model.TransactionTypeModel;
import com.sigmasys.kuali.ksa.krad.util.AuditableEntityKeyValuesFinder;
import com.sigmasys.kuali.ksa.krad.util.CreditDebitKeyValuesFinder;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.GeneralLedgerService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;


/**
 * Created by: dmulderink on 10/10/12 at 8:06 PM
 */
@Controller
@RequestMapping(value = "/transactionTypeView")
public class TransactionTypeController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(TransactionTypeController.class);

    private KeyValuesFinder creditDebitTypeOptionsFinder;

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private GeneralLedgerService glService;

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected TransactionTypeForm createInitialForm(HttpServletRequest request) {
        TransactionTypeForm form = new TransactionTypeForm();
        form.setStatusMessage("");
        return form;
    }

    /**
     * @param form
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") TransactionTypeForm form, HttpServletRequest request) {

        // do get stuff...
        String viewId = request.getParameter("viewId");
        String pageId = request.getParameter("pageId");

        logger.info("View: " + viewId + " Page: " + pageId);

        if ("TransactionTypePage".equals(pageId)) {
            List<TransactionType> entities = auditableEntityService.getAuditableEntities(TransactionType.class);
            logger.info("Transaction Type Count: " + entities.size());

            Map<String, TransactionTypeGroupModel> map = new HashMap<String, TransactionTypeGroupModel>();

            for (TransactionType tt : entities) {
                TransactionTypeModel ttModel = new TransactionTypeModel(tt);
                String id = tt.getId().getId();
                TransactionTypeGroupModel group = map.get(id);
                if (group == null) {
                    group = new TransactionTypeGroupModel();
                    map.put(id, group);
                }


                group.addTransactionType(ttModel);

                if (tt instanceof DebitType) {
                    ttModel.setGlBreakdowns(transactionService.getGlBreakdowns((DebitType) tt));
                }
            }

            form.setTransactionTypeGroups(map);

            //form.setTransactionTypes(entities);
        } else if ("TransactionTypeDetailsPage".equals(pageId)) {
            String entityId = request.getParameter("entityId");
            String subCode = request.getParameter("subCode");

            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }

            if (subCode == null) {
                subCode = "1";
            }

            TransactionTypeId ttId = new TransactionTypeId(entityId, Integer.parseInt(subCode));

            TransactionType tt = transactionService.getTransactionType(ttId);
            logger.info("Retrieved Transaction Type: " + tt.getDescription());

            form.setTransactionType(tt);
        }

        return getUIFModelAndView(form);
    }


    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=create")
    public ModelAndView create(@ModelAttribute("KualiForm") TransactionTypeForm form, HttpServletRequest request) {

        form.reset();
        form.setType("C");

        String modelToCopy = request.getParameter("model");

        if (modelToCopy != null) {
            TransactionType ttSource = transactionService.getTransactionType(modelToCopy, new Date());

            if (ttSource != null) {
                this.loadFormFromTransactionType(form, ttSource);
            }
        }

        form.setCreditDebitKeyValuesFinder(this.getCreditDebitTypeOptionsFinder());
        form.setRollupOptionsFinder(this.getRollupOptionsFinder());

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=insert")
    public ModelAndView insert(@ModelAttribute("KualiForm") TransactionTypeForm form) {

        String type = form.getType();
        String code = form.getCode();
        // If the subcode is anything other than -1 then this is an edit.
        Integer subCode = form.getSubCode();
        Date startDate = form.getStartDate();
        Integer priority = form.getPriority();
        if (priority == null) {
            priority = 1;
        }
        String description = form.getDescription();

        List<GlBreakdown> breakdowns = new ArrayList<GlBreakdown>();
        // For now, all breakdowns use the default GL Account
        GeneralLedgerType defaultGlType = glService.getDefaultGeneralLedgerType();

        /*
            validate as much as we can before we save anything.
         */
        boolean errors = this.validateBreakdowns(breakdowns, form, defaultGlType);

        if (errors) {
            return getUIFModelAndView(form);
        }

        boolean typeExists = transactionService.transactionTypeExists(code);

        TransactionType tt;

        if (subCode == null || subCode == -1) {
            if ("C".equalsIgnoreCase(type)) {
                if (!typeExists) {
                    tt = transactionService.createCreditType(code, "", startDate, priority, description);
                } else {
                    tt = transactionService.createCreditSubType(code, startDate);
                }

            } else if ("D".equalsIgnoreCase(type)) {
                if (!typeExists) {
                    tt = transactionService.createDebitType(code, "", startDate, priority, description);
                } else {
                    tt = transactionService.createDebitSubType(code, startDate);
                }

            } else {
                String errMsg = "Invalid transaction type '" + type + "'";
                logger.error(errMsg);
                GlobalVariables.getMessageMap().putError("TransactionTypeView", RiceKeyConstants.ERROR_CUSTOM, errMsg);
                return getUIFModelAndView(form);
            }
        } else {
            TransactionTypeId ttId = new TransactionTypeId(code, subCode);
            tt = transactionService.getTransactionType(ttId);

            tt.setStartDate(startDate);
            tt.setPriority(priority);
            tt.setDescription(description);
        }

        // If there are errors further on and they want to resubmit things, make sure they're modifying the same tt, not creating a new subcode.
        form.setSubCode(tt.getId().getSubCode());


        List<Tag> tags = form.getTags();
        tt = transactionService.addTagsToTransactionType(tt.getId(), tags);

        Long rollupId;
        try {
            rollupId = new Long(form.getRollupId());
        } catch (NumberFormatException e) {
            rollupId = null;
        }

        if (rollupId != null) {
            Rollup r = auditableEntityService.getAuditableEntity(rollupId, Rollup.class);
            tt.setRollup(r);
        }

        TransactionTypeId ttId = transactionService.persistTransactionType(tt);
        if (tt instanceof DebitType) {
            for (GlBreakdown breakdown : breakdowns) {
                breakdown.setDebitType((DebitType) tt);
            }
            transactionService.createGlBreakdowns(defaultGlType.getId(), ttId, breakdowns);
        } else {
            String unAllocatedGlOperation = form.getUnallocatedGLOperation();
            GlOperationType unallocatedGlOperationType = (GlOperationType.CREDIT.getId().equals(unAllocatedGlOperation)) ?
                    GlOperationType.CREDIT : GlOperationType.DEBIT;
            ((CreditType) tt).setUnallocatedGlOperation(unallocatedGlOperationType);
            String unallocatedGLAccount = form.getUnallocatedGLAccount();
            ((CreditType) tt).setUnallocatedGlAccount(unallocatedGLAccount);
            transactionService.persistTransactionType(tt);
        }

        GlobalVariables.getMessageMap().putInfo("TransactionTypeView", RiceKeyConstants.ERROR_CUSTOM, "Transaction Type added");

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=edit")
    public ModelAndView edit(@ModelAttribute("KualiForm") TransactionTypeForm form, HttpServletRequest request) {

        form.reset();
        form.setType("C");

        String modelToCopy = request.getParameter("model");
        Integer subCode = new Integer(request.getParameter("subCode"));

        TransactionTypeId ttId = new TransactionTypeId(modelToCopy, subCode);


        if (modelToCopy != null) {
            TransactionType ttSource = transactionService.getTransactionType(ttId);

            if (ttSource != null) {
                form.setSubCode(ttSource.getId().getSubCode());
                this.loadFormFromTransactionType(form, ttSource);
            }
        }


        form.setCreditDebitKeyValuesFinder(this.getCreditDebitTypeOptionsFinder());
        form.setRollupOptionsFinder(this.getRollupOptionsFinder());

        return getUIFModelAndView(form);
    }


    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=update")
    public <T extends AuditableEntity> ModelAndView update(@ModelAttribute("KualiForm") TransactionTypeForm form) {

        TransactionTypeModel entity = form.getTransactionType();

        if (entity == null) {
            String errMsg = "TransactionType cannot be null";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        logger.debug("Entity code: " + entity.getCode());

        try {
            // occurs in the detail page.
            auditableEntityService.persistAuditableEntity(entity.getTransactionType());
            // success in updating the currency.
            String statusMsg = "Success: Transaction Type entity updated. Entity ID =  " + entity.getId();
            form.setStatusMessage(statusMsg);
            logger.info(statusMsg);
        } catch (Exception e) {
            // failed to update the currency. Leave the currency information in the view
            String statusMsg = "Failure: Transaction Type entity did not update, Entity ID =  " + entity.getId() + ". " + e.getMessage();
            form.setStatusMessage(statusMsg);
            logger.error(statusMsg);
        }

        return getUIFModelAndView(form);
    }

    public synchronized KeyValuesFinder getCreditDebitTypeOptionsFinder() {
        if (creditDebitTypeOptionsFinder == null) {
            creditDebitTypeOptionsFinder = new CreditDebitKeyValuesFinder(true);
        }
        return creditDebitTypeOptionsFinder;
    }

    /*
      * Returns Rollup type option finder.
      */
    public KeyValuesFinder getRollupOptionsFinder() {
        // Don't cache the values finder or else new entries will not show when added

        return new AuditableEntityKeyValuesFinder<Rollup>(Rollup.class);
    }

    private void loadFormFromTransactionType(TransactionTypeForm form, TransactionType ttSource) {
        List<GlBreakdownModel> breakdowns = new ArrayList<GlBreakdownModel>();
        form.setType((ttSource instanceof CreditType ? "C" : "D"));
        form.setCode(ttSource.getId().getId());
        form.setStartDate(new Date());
        form.setDescription(ttSource.getDescription());
        if (ttSource.getRollup() != null) {
            form.setRollupId(ttSource.getRollup().getId().toString());
        }
        ArrayList<Tag> tags = new ArrayList<Tag>();
        for (Tag t : ttSource.getTags()) {
            tags.add(t);
        }

        form.setTags(tags);
        //form.setGlBreakdowns(ttSource.get);

        List<GlBreakdown> sourceBreakdowns = transactionService.getGlBreakdowns((DebitType) ttSource);

        for (GlBreakdown sourceBreakdown : sourceBreakdowns) {
            GlBreakdownModel breakdownModel = new GlBreakdownModel();
            breakdownModel.setGlAccount(sourceBreakdown.getGlAccount());
            breakdownModel.setOperation(sourceBreakdown.getGlOperation().getId());
            breakdownModel.setBreakdown(sourceBreakdown.getBreakdown());
            breakdowns.add(breakdownModel);
        }
        form.setGlBreakdowns(breakdowns);


    }

    public boolean validateBreakdowns(List<GlBreakdown> breakdowns, TransactionTypeForm form, GeneralLedgerType defaultGlType) {
        boolean errors = false;
        String type = form.getType();
        if (!"D".equals(type)) {
            // Breakdowns only apply to Debit types
            return errors;
        }

        // Handle the GL Breakdown sections.
        BigDecimal total = new BigDecimal(0);

        boolean zeroRow = false;

        for (GlBreakdownModel breakdownModel : form.getGlBreakdowns()) {
            GlBreakdown breakdown = new GlBreakdown();
            breakdowns.add(breakdown);

            breakdown.setGeneralLedgerType(defaultGlType);

            breakdown.setGlAccount(breakdownModel.getGlAccount());
            if (!glService.isGlAccountValid(breakdown.getGlAccount())) {
                GlobalVariables.getMessageMap().putError("glBreakdownList", RiceKeyConstants.ERROR_CUSTOM, "GL Account '" + breakdown.getGlAccount() + "' is not valid");
                errors = true;
            }

            String operation = breakdownModel.getOperation();
            if (operation == null || "".equals(operation)) {
                GlobalVariables.getMessageMap().putError("glBreakdownList", RiceKeyConstants.ERROR_CUSTOM, "Operation is required");
                errors = true;
            }
            GlOperationType operationType = (GlOperationType.CREDIT.getId().equals(operation)) ? GlOperationType.CREDIT : GlOperationType.DEBIT;

            breakdown.setGlOperation(operationType);

            BigDecimal b = breakdownModel.getBreakdown();
            if (b == null) {
                b = BigDecimal.ZERO;
            }
            breakdown.setBreakdown(b);
            total = total.add(b);

            if (BigDecimal.ZERO.equals(b)) {
                if (!zeroRow) {
                    zeroRow = true;
                } else {
                    // There can be only one
                    GlobalVariables.getMessageMap().putError("glBreakdownList", RiceKeyConstants.ERROR_CUSTOM, "Only one row may have a breakdown amount of 0%");
                    errors = true;
                }
            }
            if (total.compareTo(BigDecimal.ONE) >= 0) {
                // Error, the numbers exceed the allowable amount.  It must be less than 100%
                GlobalVariables.getMessageMap().putError("glBreakdownList", RiceKeyConstants.ERROR_CUSTOM, "Breakdowns must be less than 100%");
                errors = true;
            }


        }

        if (!zeroRow) {
            // Tell the user here that there needs to be a row with a 0 amount
            GlobalVariables.getMessageMap().putError("glBreakdownList", RiceKeyConstants.ERROR_CUSTOM, "One row must have a breakdown of 0%");
            errors = true;
        }

        GeneralLedgerType defatulGlType = glService.getDefaultGeneralLedgerType();
        if (defatulGlType == null || defatulGlType.getId() == null) {
            GlobalVariables.getMessageMap().putError("glBreakdownList", RiceKeyConstants.ERROR_CUSTOM, "No default GL Type configured");
            errors = true;
        }

        return errors;
    }
}
