package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.config.ConfigService;
import com.sigmasys.kuali.ksa.krad.form.SettingsForm;
import com.sigmasys.kuali.ksa.krad.model.AuditableEntityModel;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by: dmulderink on 10/10/12 at 8:06 PM
 */
@Controller
@RequestMapping(value = "/settingsView")
public class SettingsController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(SettingsController.class);

    @Autowired
    private AuditableEntityService auditableEntityService;

    @Autowired
    protected ConfigService configService;


    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected SettingsForm createInitialForm(HttpServletRequest request) {
        SettingsForm form = new SettingsForm();
        form.setStatusMessage("");
        return form;
    }

    /**
     * @param form
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") SettingsForm form, HttpServletRequest request) {

        // do get stuff...
        String viewId = request.getParameter("viewId");
        String pageId = request.getParameter("pageId");

        String entityId = request.getParameter("entityId");

        logger.info("View: " + viewId + " Page: " + pageId + " Entity ID: " + entityId);

        // Currency type
        if ("CurrencyPage".equals(pageId)) {
            Currency c = new Currency();
            form.setAuditableEntity(c);

            form.setAuditableEntities(auditableEntityService.getAuditableEntities(Currency.class));
        } else if ("CurrencyDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), Currency.class));
        } else if ("RollupPage".equals(pageId)) {
            form.setAuditableEntity(new Rollup());
            form.setAuditableEntities(auditableEntityService.getAuditableEntities(Rollup.class));
        } else if ("RollupDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), Rollup.class));
        } else if ("TagPage".equals(pageId)) {
            form.setAuditableEntity(new Tag());
            form.setAuditableEntities(auditableEntityService.getAuditableEntities(Tag.class));
        } else if ("TagDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), Tag.class));
        } else if ("BankTypePage".equals(pageId)) {
            form.setAuditableEntity(new BankType());
            form.setAuditableEntities(auditableEntityService.getAuditableEntities(BankType.class));
        } else if ("BankTypeDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), BankType.class));
        } else if ("TaxTypePage".equals(pageId)) {
            form.setAuditableEntity(new TaxType());
            form.setAuditableEntities(auditableEntityService.getAuditableEntities(TaxType.class));
        } else if ("TaxTypeDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), TaxType.class));
        } else if ("LatePeriodPage".equals(pageId)) {
            form.setAuditableEntity(new LatePeriod());
            form.setAuditableEntities(auditableEntityService.getAuditableEntities(LatePeriod.class));
        } else if ("LatePeriodDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), LatePeriod.class));
        } else if ("AccountStatusTypePage".equals(pageId)) {
            form.setAuditableEntity(new AccountStatusType());
            form.setAuditableEntities(auditableEntityService.getAuditableEntities(AccountStatusType.class));
        } else if ("AccountStatusTypeDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), AccountStatusType.class));
        } else if ("FlagTypePage".equals(pageId)) {
            form.setAuditableEntity(new FlagType());
            form.setAuditableEntities(auditableEntityService.getAuditableEntities(FlagType.class));
        } else if ("FlagTypeDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), FlagType.class));
        } else if ("ActivityTypePage".equals(pageId)) {
            form.setAuditableEntity(new ActivityType());
            form.setAuditableEntities(auditableEntityService.getAuditableEntities(ActivityType.class));
        } else if ("ActivityTypeDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), ActivityType.class));
        } else if ("GeneralLedgerTypePage".equals(pageId)) {
            form.setAuditableEntity(new GeneralLedgerType());
            form.setAuditableEntities(auditableEntityService.getAuditableEntities(GeneralLedgerType.class));
        } else if ("GeneralLedgerTypeDetailsPage".equals(pageId)) {
            if (entityId == null || entityId.trim().isEmpty()) {
                throw new IllegalArgumentException("'entityId' request parameter must be specified");
            }
            form.setAuditableEntity(auditableEntityService.getAuditableEntity(Long.valueOf(entityId), GeneralLedgerType.class));
        } else if("SystemConfigurationPage".equals(pageId)){
            List<ConfigParameter> parameters = configService.getParameters();
            form.setConfigParameters(parameters);
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=insertAuditableEntity")
    public ModelAndView insertAuditableEntity(@ModelAttribute("KualiForm") SettingsForm form) {

        AuditableEntityModel entity = form.getAuditableEntity();
        AuditableEntity parentEntity = entity.getParentEntity();

        if (entity == null) {
            logger.info("Entity is null");
        } else {
            logger.info("Entity is of type : " + entity.getClass().getName());
            logger.info("Entity code: " + entity.getCode());
        }

        if (parentEntity == null) {
            logger.info("Parent entity is null");
        } else {


            logger.info("Parent entity is of type : " + parentEntity.getClass().getName());

            try {

                String code = parentEntity.getCode();
                String name = parentEntity.getName();
                String description = parentEntity.getDescription();

                auditableEntityService.createAuditableEntity(code, name, description, parentEntity.getClass());

                form.setAuditableEntities(auditableEntityService.getAuditableEntities(parentEntity.getClass()));

                form.setAuditableEntity(parentEntity.getClass().newInstance());
                // success in creating the currency.
                String statusMsg = "Success: " + parentEntity.getClass().getName() + " saved, ID = " + parentEntity.getId();
                form.setStatusMessage(statusMsg);
                logger.info(statusMsg);
            } catch (Exception e) {
                // failed to create the currency. Leave the currency information in the view
                String statusMsg = "Failure: " + parentEntity.getClass().getName() + "entity did not save, ID = " + parentEntity.getId() +
                        ". " + e.getMessage();
                form.setStatusMessage(statusMsg);
                logger.error(statusMsg);
            }
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=insertLatePeriod")
    public ModelAndView insertLatePeriod(@ModelAttribute("KualiForm") SettingsForm form) {

        AuditableEntityModel entity = form.getAuditableEntity();
        LatePeriod parentEntity = entity.getLatePeriod();

        if (entity == null) {
            logger.info("Entity is null");
        } else {
            logger.info("Entity is of type : " + entity.getClass().getName());
            logger.info("Entity code: " + entity.getCode());
        }

        if (parentEntity == null) {
            logger.info("Parent entity is null");
        } else {
            logger.info("Parent entity is of type : " + parentEntity.getClass().getName());
        }


        try {

            auditableEntityService.persistAuditableEntity(parentEntity);

            form.setAuditableEntities(auditableEntityService.getAuditableEntities(parentEntity.getClass()));

            form.setAuditableEntity(parentEntity.getClass().newInstance());
            // success in creating the currency.
            String statusMsg = "Success: " + parentEntity.getClass().getName() + " saved, ID = " + parentEntity.getId();
            form.setStatusMessage(statusMsg);
            logger.info(statusMsg);
        } catch (Exception e) {
            // failed to create the currency. Leave the currency information in the view
            String statusMsg = "Failure: " + parentEntity.getClass().getName() + "entity did not save, ID = " + parentEntity.getId() +
                    ". " + e.getMessage();
            form.setStatusMessage(statusMsg);
            logger.error(statusMsg);
        }

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=updateAuditableEntity")
    public <T extends AuditableEntity> ModelAndView updateAuditableEntity(@ModelAttribute("KualiForm")
                                                                          SettingsForm form) {

        AuditableEntity entity = form.getAuditableEntity();
        if (entity instanceof AuditableEntityModel) {
            entity = ((AuditableEntityModel) entity).getParentEntity();
        }

        try {
            // occurs in the detail page.
            auditableEntityService.persistAuditableEntity(entity);
            // success in updating the currency.
            String statusMsg = "Success: " + entity.getClass() + " entity updated. Entity ID =  " + entity.getId();
            form.setStatusMessage(statusMsg);
            logger.info(statusMsg);
        } catch (Exception e) {
            // failed to update the currency. Leave the currency information in the view
            String statusMsg = "Failure: " + entity.getClass() + " entity did not update, Entity ID =  " + entity.getId() + ". " + e.getMessage();
            form.setStatusMessage(statusMsg);
            logger.error(statusMsg);
        }

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=updateSystemConfig")
    public ModelAndView updateSystemConfig(@ModelAttribute("KualiForm") SettingsForm form) {

       List<ConfigParameter> parameters = form.getConfigParameters();

        try {
            configService.updateParameters(parameters);
            // success in updating the currency.
            String statusMsg = "System Parameters updated.";
            GlobalVariables.getMessageMap().putInfo("SettingsView", RiceKeyConstants.ERROR_CUSTOM, statusMsg);
            logger.info(statusMsg);
        } catch (Exception e) {
            // failed to update the currency. Leave the currency information in the view
            String statusMsg = "System Parameters did not update. " + e.getMessage();
            GlobalVariables.getMessageMap().putError("SettingsView", RiceKeyConstants.ERROR_CUSTOM, statusMsg);
            logger.error(statusMsg);
        }

        return getUIFModelAndView(form);
    }


}
