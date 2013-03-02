package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.exception.InvalidRulesException;
import com.sigmasys.kuali.ksa.krad.form.RulesForm;
import com.sigmasys.kuali.ksa.model.rule.Rule;
import com.sigmasys.kuali.ksa.model.rule.RuleType;
import com.sigmasys.kuali.ksa.service.brm.BrmPersistenceService;
import com.sigmasys.kuali.ksa.service.brm.BrmService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * A controller for editing KSA Drools rule sets
 *
 * @author Michael Ivanov
 */
@Controller
@Transactional
@RequestMapping(value = "/rulesView")
public class RulesController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(RulesController.class);


    @Autowired
    private BrmService brmService;

    @Autowired
    private BrmPersistenceService brmPersistenceService;


    private boolean ruleExists(String ruleName) {
        return StringUtils.isNotBlank(ruleName) && brmPersistenceService.getRule(ruleName) != null;
    }


    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected RulesForm createInitialForm(HttpServletRequest request) {

        String ruleSetName = request.getParameter("ruleSetName");

        RulesForm rulesForm = new RulesForm();

        List<String> ruleNames = StringUtils.isNotBlank(ruleSetName) ?
                brmPersistenceService.getRuleNames(ruleSetName) : brmPersistenceService.getRuleNames();

        rulesForm.initRuleNameFinder(ruleNames);

        List<RuleType> ruleTypes = brmPersistenceService.getRuleTypes();
        if (ruleTypes != null) {
            List<String> ruleTypeNames = new ArrayList<String>(ruleTypes.size());
            for (RuleType ruleType : ruleTypes) {
                ruleTypeNames.add(ruleType.getName());
            }
            rulesForm.initRuleTypeFinder(ruleTypeNames);
        }

        rulesForm.setRuleSetName(ruleSetName);
        rulesForm.setAddStatusMessage("");
        rulesForm.setEditStatusMessage("");

        return rulesForm;

    }


    /**
     * @param form RuleForm instance
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") RulesForm form) {

        logger.debug("Page ID = " + form.getPageId());

        return getUIFModelAndView(form);
    }

    /**
     * @param form RuleForm instance
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=update")
    public ModelAndView update(@ModelAttribute("KualiForm") RulesForm form) {

        Rule rule = new Rule();

        copyFormToRule(form, rule);

        try {
            brmPersistenceService.persistRule(rule);
            brmService.reloadRuleSets();
            form.setEditStatusMessage("Rule has been updated");
        } catch (InvalidRulesException ire) {
            form.setEditStatusMessage(ire.getMessage());
        }

        logger.info("Updated Rule => \n" + rule);

        return getUIFModelAndView(form);
    }

    /**
     * @param form RulesForm
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=select")
    public ModelAndView select(@ModelAttribute("KualiForm") RulesForm form) {

        String ruleName = form.getRuleName();
        if (StringUtils.isBlank(ruleName)) {
            String errMsg = "Rule name must be specified";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        Rule rule = brmPersistenceService.getRule(ruleName);
        if (rule == null) {
            String errMsg = "Rule specified by name '" + ruleName + "' does not exist";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        copyRuleToForm(rule, form);

        logger.info("Selected Rule => \n" + rule);

        return getUIFModelAndView(form);
    }

    /**
     * @param form RulesForm
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=checkExistence")
    public ModelAndView checkExistence(@ModelAttribute("KualiForm") RulesForm form) {

        Rule rule = form.getNewRule();
        if (rule == null) {
            String errMsg = "Rule cannot be null";
            logger.error(errMsg);
            form.setAddStatusMessage(errMsg);
            return getUIFModelAndView(form);
        }

        String ruleName = rule.getName();

        if (StringUtils.isBlank(ruleName)) {
            String errMsg = "Rule name cannot be empty";
            logger.error(errMsg);
            form.setAddStatusMessage(errMsg);
        } else if (ruleExists(ruleName)) {
            form.setAddStatusMessage("Rule with name '" + ruleName + "' already exists");
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form RuleForm instance
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=add")
    public ModelAndView add(@ModelAttribute("KualiForm") RulesForm form) {

        Rule rule = form.getNewRule();
        if (rule == null) {
            String errMsg = "Rule cannot be null";
            logger.error(errMsg);
            form.setAddStatusMessage(errMsg);
            return getUIFModelAndView(form);
        }

        String ruleName = rule.getName();

        if (StringUtils.isBlank(ruleName)) {
            String errMsg = "Rule name cannot be empty";
            logger.error(errMsg);
            form.setAddStatusMessage(errMsg);
            return getUIFModelAndView(form);

        } else if (!ruleExists(ruleName)) {

            String ruleTypeName = form.getNewRuleType();
            if (StringUtils.isBlank(ruleTypeName)) {
                String errMsg = "Rule type is required";
                logger.error(errMsg);
                form.setAddStatusMessage(errMsg);
                return getUIFModelAndView(form);
            }

            RuleType ruleType = brmPersistenceService.getRuleType(ruleTypeName);
            if (ruleType == null) {
                String errMsg = "Rule type '" + ruleTypeName + "' does not exist";
                logger.error(errMsg);
                form.setAddStatusMessage(errMsg);
                return getUIFModelAndView(form);
            }

            rule.setType(ruleType);

            try {
                brmPersistenceService.persistRule(rule);
                brmService.reloadRuleSets();
                form.setAddStatusMessage("A new Rule has been created");
                logger.info("Added Rule => \n" + rule);
            } catch (InvalidRulesException ire) {
                form.setAddStatusMessage(ire.getMessage());
                return getUIFModelAndView(form);
            }

        } else {
            form.setAddStatusMessage("Rule with name = '" + ruleName + "' already exists");
        }

        return getUIFModelAndView(form);
    }

    private void copyRuleToForm(Rule rule, RulesForm form) {
        form.setRuleId(rule.getId());
        form.setRuleName(rule.getName());
        Integer priority = rule.getPriority();
        form.setRulePriority(priority != null ? priority.toString() : "0");
        form.setRuleLhs(rule.getLhs());
        form.setRuleRhs(rule.getRhs());
        form.setRuleType(rule.getType().getName());
    }

    private void copyFormToRule(RulesForm form, Rule rule) {
        rule.setId(form.getRuleId());
        rule.setName(form.getRuleName());
        String priority = form.getRulePriority();
        rule.setPriority(StringUtils.isNotBlank(priority) ? Integer.parseInt(priority.trim()) : 0);
        rule.setLhs(form.getRuleLhs());
        rule.setRhs(form.getRuleRhs());
        RuleType ruleType = brmPersistenceService.getRuleType(form.getRuleType());
        if (ruleType == null) {
            throw new IllegalStateException("Rule Type with name '" + form.getRuleType() + "' does not exist");
        }
        rule.setType(ruleType);
    }

}
