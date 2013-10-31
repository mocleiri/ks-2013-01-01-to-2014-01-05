package com.sigmasys.kuali.ksa.krad.controller.rules;

import com.sigmasys.kuali.ksa.krad.form.rules.RuleSetsForm;
import com.sigmasys.kuali.ksa.model.rule.Rule;
import com.sigmasys.kuali.ksa.model.rule.RuleSet;
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
import java.util.*;

/**
 * A controller for managing KSA rule sets.
 *
 * @author Michael Ivanov
 */
@Controller
@RequestMapping(value = "/ruleSetsView")
public class RuleSetsController extends AbstractRuleController {

    private static final Log logger = LogFactory.getLog(RuleSetsController.class);


    private boolean ruleSetExists(String ruleSetName) {
        return StringUtils.isNotBlank(ruleSetName) && brmPersistenceService.getRuleSet(ruleSetName) != null;
    }

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected RuleSetsForm createInitialForm(HttpServletRequest request) {
        RuleSetsForm ruleSetsForm = new RuleSetsForm();
        initForm(ruleSetsForm, request.getParameter("ruleSetName"));
        return ruleSetsForm;
    }

    protected void initForm(RuleSetsForm ruleSetsForm, String ruleSetName) {

        ruleSetsForm.initNameFinder(brmPersistenceService.getRuleSetNames());

        List<RuleType> ruleTypes = brmPersistenceService.getRuleTypes();
        if (ruleTypes != null) {
            List<String> ruleTypeNames = new ArrayList<String>(ruleTypes.size());
            for (RuleType ruleType : ruleTypes) {
                ruleTypeNames.add(ruleType.getName());
            }
            ruleSetsForm.initRuleTypeFinder(ruleTypeNames);
        }

        ruleSetsForm.setRuleSetName(StringUtils.isNotBlank(ruleSetName) ? ruleSetName : null);

        clearMessages(ruleSetsForm);

        ruleSetsForm.setRuleSetHeader("");

        ruleSetsForm.setRules(Collections.<Rule>emptyList());
    }


    /**
     * @param form RuleForm instance
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") RuleSetsForm form) {

        logger.debug("Page ID = " + form.getPageId());

        return getUIFModelAndView(form);
    }

    /**
     * @param form RuleForm instance
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=update")
    public ModelAndView update(@ModelAttribute("KualiForm") RuleSetsForm form) {

        clearMessages(form);

        if (form.getRuleSetId() == null) {
            return handleError(form, "Rule Set ID is null", false);
        }

        if (StringUtils.isBlank(form.getRuleSetName())) {
            return handleError(form, "Rule Set name cannot be empty", false);
        }

        if (StringUtils.isBlank(form.getRuleSetHeader())) {
            return handleError(form, "Rule Set header cannot be empty", false);
        }

        if (StringUtils.isBlank(form.getRuleType())) {
            return handleError(form, "Rule Set type is required", false);
        }

        try {
            RuleSet ruleSet = new RuleSet();
            copyFormToRuleSet(form, ruleSet);
            brmPersistenceService.persistRuleSet(ruleSet);
            brmService.reloadRuleSets(ruleSet.getName());
            setMessage(form, "Rule Set has been updated", false);
            logger.info("Updated Rule Set => \n" + ruleSet);
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
    public ModelAndView select(@ModelAttribute("KualiForm") RuleSetsForm form) {

        clearMessages(form);

        String ruleSetName = form.getRuleSetName();
        if (StringUtils.isBlank(ruleSetName)) {
            String errMsg = "Rule Set name must be specified";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        RuleSet ruleSet = brmPersistenceService.getRuleSet(ruleSetName);
        if (ruleSet == null) {
            String errMsg = "Rule Set specified by name '" + ruleSetName + "' does not exist";
            logger.error(errMsg);
            return handleError(form, errMsg, false);
        }

        copyRuleSetToForm(ruleSet, form);

        logger.info("Selected Rule Set => \n" + ruleSet);

        return getUIFModelAndView(form);
    }

    /**
     * @param form RulesForm
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=edit")
    public ModelAndView edit(@ModelAttribute("KualiForm") RuleSetsForm form,
                             @RequestParam("ruleSetName") String ruleSetName) {
        initForm(form, ruleSetName);
        return select(form);
    }

    /**
     * @param form RulesForm
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=removeRule")
    public ModelAndView removeRule(@ModelAttribute("KualiForm") RuleSetsForm form,
                                   @RequestParam("ruleSetName") String ruleSetName,
                                   @RequestParam("ruleName") String ruleName) {
        clearMessages(form);

        if (StringUtils.isBlank(ruleSetName)) {
            String errMsg = "'ruleSetName' request parameter is required";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        if (StringUtils.isBlank(ruleName)) {
            String errMsg = "'ruleName' request parameter is required";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        RuleSet ruleSet = brmPersistenceService.getRuleSet(ruleSetName);
        if (ruleSet == null) {
            String errMsg = "Rule Set with name '" + ruleSetName + " does not exist";
            return handleError(form, errMsg, false);
        }

        try {
            Set<Rule> rules = ruleSet.getRules();
            if (CollectionUtils.isNotEmpty(rules)) {
                Rule ruleToRemove = null;
                for (Rule rule : rules) {
                    if (ruleName.equals(rule.getName())) {
                        ruleToRemove = rule;
                        break;
                    }
                }
                if (ruleToRemove != null) {
                    rules.remove(ruleToRemove);
                    brmPersistenceService.persistRuleSet(ruleSet);
                    brmService.reloadRuleSets(ruleSetName);
                    form.setRuleSetName(ruleSetName);
                    select(form);
                    setMessage(form, "Rule '" + ruleName + "' has been removed from Rule Set '" + ruleSetName + "'", false);
                } else {
                    return handleError(form, "Rule '" + ruleName + "' has not been found in Rule Set '" + ruleSetName + "'", false);
                }
            }
        } catch (Exception e) {
            return handleError(form, e.getMessage(), false);
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form RulesForm
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=checkRuleNameExistence")
    public ModelAndView checkRuleSetNameExistence(@ModelAttribute("KualiForm") RuleSetsForm form) {

        clearMessages(form);

        RuleSet ruleSet = form.getNewRuleSet();
        if (ruleSet == null) {
            return handleError(form, "Rule Set cannot be null", true);
        }

        String ruleSetName = ruleSet.getName();

        if (StringUtils.isBlank(ruleSetName)) {
            return handleError(form, "Rule Set name cannot be empty", true);
        } else if (ruleSetExists(ruleSetName)) {
            return handleError(form, "Rule Set name '" + ruleSetName + "' already exists", true);
        }

        setMessage(form, "Rule Set name '" + ruleSetName + "' is available", true);

        return getUIFModelAndView(form);
    }

    /**
     * @param form RuleForm instance
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=add")
    public ModelAndView add(@ModelAttribute("KualiForm") RuleSetsForm form) {

        clearMessages(form);

        // TODO:

        return getUIFModelAndView(form);
    }

    private void copyRuleSetToForm(RuleSet ruleSet, RuleSetsForm form) {
        form.setRuleSetId(ruleSet.getId());
        form.setRuleSetName(ruleSet.getName());
        form.setRuleType(ruleSet.getType().getName());
        form.setDescription(ruleSet.getDescription());
        form.setRuleSetHeader(ruleSet.getHeader());
        Set<Rule> setOfRules = ruleSet.getRules();
        if (CollectionUtils.isNotEmpty(setOfRules)) {
            List<Rule> rules = new ArrayList<Rule>(ruleSet.getRules());
            Collections.sort(rules, new Comparator<Rule>() {
                @Override
                public int compare(Rule rule1, Rule rule2) {
                    return rule1.getName().compareToIgnoreCase(rule2.getName());
                }
            });
            form.setRules(rules);
        }

    }

    private void copyFormToRuleSet(RuleSetsForm form, RuleSet ruleSet) {
        ruleSet.setId(form.getRuleSetId());
        ruleSet.setName(form.getRuleSetName());
        ruleSet.setDescription(form.getDescription());
        ruleSet.setHeader(form.getRuleSetHeader());
        RuleType ruleType = brmPersistenceService.getRuleType(form.getRuleType());
        if (ruleType == null) {
            String errMsg = "Rule Type with name '" + form.getRuleType() + "' does not exist";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        ruleSet.setType(ruleType);
        List<Rule> listOfRules = form.getRules();
        if (CollectionUtils.isNotEmpty(listOfRules)) {
            Set<Rule> rules = new HashSet<Rule>(listOfRules);
            ruleSet.setRules(rules);
        }
    }

}