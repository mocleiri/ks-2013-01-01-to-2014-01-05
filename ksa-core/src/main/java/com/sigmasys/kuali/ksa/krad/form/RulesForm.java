package com.sigmasys.kuali.ksa.krad.form;


import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This form contains the rules related entities and properties.
 *
 * @author Michael Ivanov
 */
public class RulesForm extends AbstractViewModel {

    private Long ruleId;
    private String ruleName;
    private String ruleSetName;
    private Integer rulePriority;
    private String ruleLhs;
    private String ruleRhs;
    private String ruleType;

    private String editStatusMessage;
    private String addStatusMessage;

    private final RuleNameFinder ruleNameFinder = new RuleNameFinder();

    private final static class RuleNameFinder extends KeyValuesBase {

        private List<KeyValue> keyValues = Collections.emptyList();

        protected void initValues(List<String> ruleNames) {
            keyValues = new ArrayList<KeyValue>(ruleNames.size());
            for (String ruleName : ruleNames) {
                keyValues.add(new ConcreteKeyValue(ruleName, ruleName));
            }
        }

        /**
         * This is an implementation of a key value finder, normally this would make a request to
         * a database to obtain the necessary values.
         *
         * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
         */
        @Override
        public List<KeyValue> getKeyValues() {
            return Collections.unmodifiableList(keyValues);
        }
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getRulePriority() {
        return rulePriority;
    }

    public void setRulePriority(Integer rulePriority) {
        this.rulePriority = rulePriority;
    }

    public String getRuleLhs() {
        return ruleLhs;
    }

    public void setRuleLhs(String ruleLhs) {
        this.ruleLhs = ruleLhs;
    }

    public String getRuleRhs() {
        return ruleRhs;
    }

    public void setRuleRhs(String ruleRhs) {
        this.ruleRhs = ruleRhs;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public void initRuleNameFinder(List<String> ruleSetNames) {
        ruleNameFinder.initValues(ruleSetNames);
    }

    public String getEditStatusMessage() {
        return editStatusMessage;
    }

    public void setEditStatusMessage(String editStatusMessage) {
        this.editStatusMessage = editStatusMessage;
    }

    public KeyValuesFinder getRuleNameFinder() {
        return ruleNameFinder;
    }

    public String getAddStatusMessage() {
        return addStatusMessage;
    }

    public void setAddStatusMessage(String addStatusMessage) {
        this.addStatusMessage = addStatusMessage;
    }

    public String getRuleSetName() {
        return ruleSetName;
    }

    public void setRuleSetName(String ruleSetName) {
        this.ruleSetName = ruleSetName;
    }
}
