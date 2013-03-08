package org.kuali.rice.krms.tree;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.kuali.rice.krms.api.repository.RuleManagementService;
import org.kuali.rice.krms.api.repository.language.NaturalLanguageUsage;
import org.kuali.rice.krms.api.repository.proposition.PropositionDefinition;
import org.kuali.rice.krms.api.repository.proposition.PropositionDefinitionContract;
import org.kuali.rice.krms.api.repository.rule.RuleDefinitionContract;
import org.kuali.student.enrollment.class1.krms.dto.PropositionEditor;
import org.kuali.student.enrollment.class1.krms.dto.RuleEditor;
import org.kuali.student.enrollment.class2.courseoffering.service.decorators.PermissionServiceConstants;
import org.kuali.student.krms.naturallanguage.util.KsKrmsConstants;

/**
 * Created with IntelliJ IDEA.
 * User: SW
 * Date: 2013/02/25
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractTreeBuilder implements TreeBuilder {

    private RuleManagementService ruleManagementService;

    private String usageId;

    protected String getNaturalLanguageUsageId(){
        if (usageId == null){
            NaturalLanguageUsage usage = this.getRuleManagementService().getNaturalLanguageUsageByNameAndNamespace(KsKrmsConstants.KRMS_NL_PREVIEW,
                    PermissionServiceConstants.KS_SYS_NAMESPACE);
            if (usage != null){
                usageId = usage.getId();
            }
        }
        return usageId;
    }

    public RuleManagementService getRuleManagementService() {
        return ruleManagementService;
    }

    public void setRuleManagementService(RuleManagementService ruleManagementService) {
        this.ruleManagementService = ruleManagementService;
    }

    protected String buildNodeLabel(RuleDefinitionContract rule, PropositionDefinitionContract prop){
        return StringEscapeUtils.escapeHtml(this.getDescription(prop));
    }

    protected String getDescription(PropositionDefinitionContract proposition) {
        if (proposition == null) {
            return StringUtils.EMPTY;
        }

        if (proposition.getTypeId() != null){
            PropositionDefinition.Builder propBuilder = PropositionDefinition.Builder.create(proposition);
            return this.getRuleManagementService().translateNaturalLanguageForProposition(this.getNaturalLanguageUsageId(), propBuilder.build(), "en");
        } else if (proposition.getDescription() != null){
            return proposition.getDescription();
        }

        return StringUtils.EMPTY;
    }

    protected String getPropositionPrefix(RuleEditor rule, PropositionEditor prop){
        if (rule == null){
            return StringUtils.EMPTY;
        }

        //Add the proposition with alpha code in the map if it doesn't already exist.
        if (null == prop.getKey()) {
            prop.setKey((String) rule.getAlpha().next());
        }

        //Build the prefix.
        return "<b>" + prop.getKey() + ".</b> ";
    }
}
