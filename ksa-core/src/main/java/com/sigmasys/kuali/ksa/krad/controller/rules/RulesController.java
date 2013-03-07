package com.sigmasys.kuali.ksa.krad.controller.rules;

import com.sigmasys.kuali.ksa.krad.form.rules.RulesForm;
import com.sigmasys.kuali.ksa.model.rule.Rule;
import com.sigmasys.kuali.ksa.model.rule.RuleType;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * A controller for managing KSA business rules.
 *
 * @author Michael Ivanov
 */
@Controller
@RequestMapping(value = "/rulesView")
public class RulesController extends AbstractRuleController {

    private static final Log logger = LogFactory.getLog(RulesController.class);


    private boolean ruleExists(String ruleName) {
        return StringUtils.isNotBlank(ruleName) && brmPersistenceService.getRule(ruleName) != null;
    }

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected RulesForm createInitialForm(HttpServletRequest request) {
        RulesForm form = new RulesForm();
        initForm(form, request.getParameter("ruleSetName"), request.getParameter("ruleName"));
        return form;
    }

    private void initForm(RulesForm rulesForm, String ruleSetName, String ruleName) {

        rulesForm.setRuleName(StringUtils.isNotBlank(ruleName) ? ruleName : null);

        rulesForm.setRuleSetName(StringUtils.isNotBlank(ruleSetName) ? ruleSetName : null);

        List<String> ruleNames = StringUtils.isNotBlank(ruleSetName) ?
                brmPersistenceService.getRuleNames(ruleSetName) : brmPersistenceService.getRuleNames();

        rulesForm.initNameFinder(ruleNames);

        List<RuleType> ruleTypes = brmPersistenceService.getRuleTypes();
        if (ruleTypes != null) {
            List<String> ruleTypeNames = new ArrayList<String>(ruleTypes.size());
            for (RuleType ruleType : ruleTypes) {
                ruleTypeNames.add(ruleType.getName());
            }
            rulesForm.initRuleTypeFinder(ruleTypeNames);
        }

        clearMessages(rulesForm);
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

        clearMessages(form);

        if (form.getRuleId() == null) {
            return handleError(form, "Rule ID is null", false);
        }

        if (StringUtils.isBlank(form.getRuleName())) {
            return handleError(form, "Rule name cannot be empty", false);
        }

        if (StringUtils.isBlank(form.getRuleLhs())) {
            return handleError(form, "Rule LHS cannot be empty", false);
        }

        if (StringUtils.isBlank(form.getRuleRhs())) {
            return handleError(form, "Rule RHS cannot be empty", false);
        }

        if (StringUtils.isBlank(form.getRuleType())) {
            return handleError(form, "Rule type is required", false);
        }

        try {
            Rule rule = new Rule();
            copyFormToRule(form, rule);
            brmPersistenceService.persistRule(rule);
            reloadRuleSets(form, false);
            setMessage(form, "Rule has been updated", false);
            logger.info("Updated Rule => \n" + rule);
        } catch (Exception e) {
            return handleError(form, e.getMessage(), false);
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form RulesForm
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=select")
    public ModelAndView select(@ModelAttribute("KualiForm") RulesForm form) {

        clearMessages(form);

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
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=edit")
    public ModelAndView edit(@ModelAttribute("KualiForm") RulesForm form,
                             @RequestParam("ruleSetName") String ruleSetName,
                             @RequestParam("ruleName") String ruleName) {
        initForm(form, ruleSetName, ruleName);
        return select(form);
    }

    /**
     * @param form RulesForm
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=checkRuleNameExistence")
    public ModelAndView checkRuleNameExistence(@ModelAttribute("KualiForm") RulesForm form) {

        clearMessages(form);

        Rule rule = form.getNewRule();
        if (rule == null) {
            return handleError(form, "Rule cannot be null", true);
        }

        String ruleName = rule.getName();

        if (StringUtils.isBlank(ruleName)) {
            return handleError(form, "Rule name cannot be empty", true);
        } else if (ruleExists(ruleName)) {
            return handleError(form, "Rule name '" + ruleName + "' already exists", true);
        }

        setMessage(form, "Rule name '" + ruleName + "' is available", true);

        return getUIFModelAndView(form);
    }

    /**
     * @param form RuleForm instance
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=add")
    public ModelAndView add(@ModelAttribute("KualiForm") RulesForm form) {

        clearMessages(form);

        Rule rule = form.getNewRule();
        if (rule == null) {
            return handleError(form, "Rule cannot be null", true);
        }

        String ruleName = rule.getName();

        if (StringUtils.isBlank(ruleName)) {

            return handleError(form, "Rule name cannot be empty", true);

        } else if (!ruleExists(ruleName)) {

            if (StringUtils.isBlank(rule.getLhs())) {
                return handleError(form, "Rule LHS cannot be empty", true);
            }

            if (StringUtils.isBlank(rule.getRhs())) {
                return handleError(form, "Rule RHS cannot be empty", true);
            }

            String ruleTypeName = form.getNewRuleType();
            if (StringUtils.isBlank(ruleTypeName)) {
                return handleError(form, "Rule type is required", true);
            }

            RuleType ruleType = brmPersistenceService.getRuleType(ruleTypeName);
            if (ruleType == null) {
                return handleError(form, "Rule type '" + ruleTypeName + "' does not exist", true);
            }

            rule.setType(ruleType);

            try {
                brmPersistenceService.persistRule(rule);
                reloadRuleSets(form, true);
                setMessage(form, "A new Rule has been created", true);
                logger.info("Added Rule => \n" + rule);
            } catch (Exception e) {
                return handleError(form, e.getMessage(), true);
            }

        } else {
            return handleError(form, "Rule with name = '" + ruleName + "' already exists", true);
        }

        return getUIFModelAndView(form);
    }

    private void copyRuleToForm(Rule rule, RulesForm form) {
        form.setRuleId(rule.getId());
        form.setRuleName(rule.getName());
        form.setDescription(rule.getDescription());
        Integer priority = rule.getPriority();
        form.setRulePriority(priority != null ? priority.toString() : "0");
        form.setRuleLhs(rule.getLhs());
        form.setRuleRhs(rule.getRhs());
        form.setRuleType(rule.getType().getName());
    }

    private void copyFormToRule(RulesForm form, Rule rule) {
        rule.setId(form.getRuleId());
        rule.setName(form.getRuleName());
        rule.setDescription(form.getDescription());
        String priority = form.getRulePriority();
        rule.setPriority(StringUtils.isNotBlank(priority) ? Integer.parseInt(priority.trim()) : 0);
        rule.setLhs(form.getRuleLhs());
        rule.setRhs(form.getRuleRhs());
        RuleType ruleType = brmPersistenceService.getRuleType(form.getRuleType());
        if (ruleType == null) {
            String errMsg = "Rule Type with name '" + form.getRuleType() + "' does not exist";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        rule.setType(ruleType);
    }

    private void reloadRuleSets(RulesForm form, boolean isNewRule) {
        String ruleSetName = form.getRuleSetName();
        if (StringUtils.isNotBlank(ruleSetName)) {
            brmService.reloadRuleSets(ruleSetName);
        } else {
            String ruleName = isNewRule ? form.getNewRule().getName() : form.getRuleName();
            List<String> ruleSetNames = brmPersistenceService.getRuleSetNamesByRuleNames(ruleName);
            if (CollectionUtils.isNotEmpty(ruleSetNames)) {
                brmService.reloadRuleSets(ruleSetNames.toArray(new String[ruleSetNames.size()]));
            }
        }
    }

}
