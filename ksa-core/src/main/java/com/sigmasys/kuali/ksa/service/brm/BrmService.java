package com.sigmasys.kuali.ksa.service.brm;

import com.sigmasys.kuali.ksa.model.rule.RuleSet;


/**
 * Drools-based implementation of BrmService
 *
 * @author Michael Ivanov
 */
@SuppressWarnings("unchecked")
public interface BrmService {

    /**
     * Fires all rules from a Rule Set.
     *
     * @param ruleSetId  Rule Set ID
     * @param brmContext BRM context, van be any type
     * @return the modified BRM context
     */
    <T extends BrmContext> T fireRules(Long ruleSetId, T brmContext);

    /**
     * Fires all rules from a Rule Set.
     *
     * @param ruleSetName Rule Set Name
     * @param brmContext  BRM context, can be any type
     * @return the modified BRM context
     */
    <T extends BrmContext> T fireRules(String ruleSetName, T brmContext);

    /**
     * Validates a given rule set and throws InvalidRulesException if there are any errors.
     *
     * @param ruleSet Rule Set
     */
    void validateRuleSet(RuleSet ruleSet);

    /**
     * Reloads all rule sets and other BRM resources associated with them.
     */
    void reloadRuleSets();

    /**
     * Reloads rule sets (knowledge base) specified by names
     *
     * @param ruleSetNames Rule Set names
     */
    void reloadRuleSets(String... ruleSetNames);

}
