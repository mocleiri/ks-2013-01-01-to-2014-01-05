package com.sigmasys.kuali.ksa.krad.controller.rules;

import com.sigmasys.kuali.ksa.krad.controller.GenericSearchController;
import com.sigmasys.kuali.ksa.krad.form.rules.AbstractRuleViewModel;
import com.sigmasys.kuali.ksa.krad.form.rules.RuleSetsForm;
import com.sigmasys.kuali.ksa.model.rule.Rule;
import com.sigmasys.kuali.ksa.model.rule.RuleSet;
import com.sigmasys.kuali.ksa.model.rule.RuleType;
import com.sigmasys.kuali.ksa.service.brm.BrmPersistenceService;
import com.sigmasys.kuali.ksa.service.brm.BrmService;
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
import java.util.*;

/**
 * A controller for managing KSA rule sets.
 *
 * @author Michael Ivanov
 */
@Controller
@RequestMapping(value = "/ruleSetsView")
public class RuleSetsController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(RuleSetsController.class);


    @Autowired
    private BrmService brmService;

    @Autowired
    private BrmPersistenceService brmPersistenceService;


    private boolean ruleSetExists(String ruleSetName) {
        return StringUtils.isNotBlank(ruleSetName) && brmPersistenceService.getRuleSet(ruleSetName) != null;
    }


    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected RuleSetsForm createInitialForm(HttpServletRequest request) {
        return createInitialForm(request.getParameter("ruleSetName"));
    }

    protected RuleSetsForm createInitialForm(String ruleSetName) {

        RuleSetsForm ruleSetsForm = new RuleSetsForm();

        ruleSetsForm.initNameFinder(brmPersistenceService.getRuleSetNames());

        List<RuleType> ruleTypes = brmPersistenceService.getRuleTypes();
        if (ruleTypes != null) {
            List<String> ruleTypeNames = new ArrayList<String>(ruleTypes.size());
            for (RuleType ruleType : ruleTypes) {
                ruleTypeNames.add(ruleType.getName());
            }
            ruleSetsForm.initRuleTypeFinder(ruleTypeNames);
        }

        if (StringUtils.isNotBlank(ruleSetName)) {
            ruleSetsForm.setRuleSetName(ruleSetName);
        }

        ruleSetsForm.setAddStatusMessage("");
        ruleSetsForm.setEditStatusMessage("");

        return ruleSetsForm;

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

        // TODO

        return getUIFModelAndView(form);
    }

    /**
     * @param form RulesForm
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=select")
    public ModelAndView select(@ModelAttribute("KualiForm") RuleSetsForm form) {

        String ruleSetName = form.getRuleSetName();
        if (StringUtils.isBlank(ruleSetName)) {
            String errMsg = "Rule set name must be specified";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        RuleSet ruleSet = brmPersistenceService.getRuleSet(ruleSetName);
        if (ruleSet == null) {
            String errMsg = "Rule set specified by name '" + ruleSetName + "' does not exist";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
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
        form = createInitialForm(ruleSetName);
        return select(form);
    }

    /**
     * @param form RulesForm
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=checkRuleNameExistence")
    public ModelAndView checkRuleSetNameExistence(@ModelAttribute("KualiForm") RuleSetsForm form) {

        RuleSet ruleSet = form.getNewRuleSet();
        if (ruleSet == null) {
            return handleError(form, "Rule set cannot be null", true);
        }

        String ruleSetName = ruleSet.getName();

        if (StringUtils.isBlank(ruleSetName)) {
            return handleError(form, "Rule set name cannot be empty", true);
        } else if (ruleSetExists(ruleSetName)) {
            return handleError(form, "Rule set name '" + ruleSetName + "' already exists", true);
        }

        form.setAddStatusMessage("Rule set name '" + ruleSetName + "' is available");

        return getUIFModelAndView(form);
    }

    /**
     * @param form RuleForm instance
     * @return ModelAndView instance
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=add")
    public ModelAndView add(@ModelAttribute("KualiForm") RuleSetsForm form) {

        // TODO:

        return getUIFModelAndView(form);
    }

    private void copyRuleSetToForm(RuleSet ruleSet, RuleSetsForm form) {
        form.setRuleSetId(ruleSet.getId());
        form.setRuleSetName(ruleSet.getName());
        form.setRuleType(ruleSet.getType().getName());
        form.setDescription(ruleSet.getDescription());
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

    private ModelAndView handleError(AbstractRuleViewModel form, String errorMessage, boolean isNew) {
        logger.error(errorMessage);
        String htmlErrorMessage = "<font color='red'>" + errorMessage + "</font>";
        if (isNew) {
            form.setAddStatusMessage(htmlErrorMessage);
        } else {
            form.setEditStatusMessage(htmlErrorMessage);
        }
        return getUIFModelAndView(form);
    }

    private void reloadRuleSets(RuleSetsForm form, boolean isNew) {
        String ruleSetName = isNew ? form.getNewRuleSet().getName() : form.getRuleSetName();
        if (StringUtils.isNotBlank(ruleSetName)) {
            brmService.reloadRuleSets(ruleSetName);
        }
    }


}
