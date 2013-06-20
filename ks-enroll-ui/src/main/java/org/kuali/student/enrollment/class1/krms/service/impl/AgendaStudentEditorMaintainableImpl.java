/**
 * Copyright 2005-2012 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.enrollment.class1.krms.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ojb.broker.metadata.ClassNotPersistenceCapableException;
import org.kuali.rice.core.api.uif.DataType;
import org.kuali.rice.core.api.uif.RemotableAttributeField;
import org.kuali.rice.core.api.uif.RemotableTextInput;
import org.kuali.rice.core.api.util.tree.Node;
import org.kuali.rice.core.api.util.tree.Tree;
import org.kuali.rice.krad.bo.Note;
import org.kuali.rice.krad.bo.PersistableBusinessObject;
import org.kuali.rice.krad.maintenance.MaintainableImpl;
import org.kuali.rice.krad.maintenance.MaintenanceDocument;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.KRADServiceLocator;
import org.kuali.rice.krad.service.SequenceAccessorService;
import org.kuali.rice.krad.uif.container.CollectionGroup;
import org.kuali.rice.krad.uif.container.Container;
import org.kuali.rice.krad.uif.util.ObjectPropertyUtils;
import org.kuali.rice.krad.uif.view.View;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.web.form.MaintenanceDocumentForm;
import org.kuali.rice.krms.api.repository.term.TermResolverDefinition;
import org.kuali.rice.krms.api.repository.type.KrmsAttributeDefinition;
import org.kuali.rice.krms.impl.repository.ActionBo;
import org.kuali.rice.krms.impl.repository.AgendaBo;
import org.kuali.rice.krms.impl.repository.AgendaItemBo;
import org.kuali.rice.krms.impl.repository.ContextBoService;
import org.kuali.rice.krms.impl.repository.KrmsAttributeDefinitionService;
import org.kuali.rice.krms.impl.repository.KrmsRepositoryServiceLocator;
import org.kuali.rice.krms.impl.repository.PropositionBo;
import org.kuali.rice.krms.impl.repository.PropositionParameterBo;
import org.kuali.rice.krms.impl.repository.RuleBo;
import org.kuali.rice.krms.impl.repository.TermBo;
import org.kuali.rice.krms.impl.repository.TermParameterBo;
import org.kuali.rice.krms.impl.ui.KrmsMaintenanceConstants;
import org.kuali.rice.krms.impl.util.KrmsImplConstants;
import org.kuali.rice.krms.impl.util.KrmsRetriever;
import org.kuali.student.enrollment.class1.krms.dto.RuleEditorTreeNode;
import org.kuali.student.enrollment.class1.krms.dto.StudentAgendaEditor;
import org.kuali.student.enrollment.class1.krms.service.AgendaStudentEditorMaintainable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link org.kuali.rice.krad.maintenance.Maintainable} for the {@link org.kuali.rice.krms.impl.ui.AgendaEditor}
 *
 * @author Kuali Rice Team (rice.collab@kuali.org)
 *
 */
public class AgendaStudentEditorMaintainableImpl extends MaintainableImpl implements AgendaStudentEditorMaintainable{

    private static final long serialVersionUID = 1L;

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(AgendaStudentEditorMaintainableImpl.class);

    public static final String NEW_AGENDA_EDITOR_DOCUMENT_TEXT = "New Agenda Editor Document";

    private transient SequenceAccessorService sequenceAccessorService;

    private transient KrmsRetriever krmsRetriever = new KrmsRetriever();

    /**
     * @return the boService
     */
    public BusinessObjectService getBoService() {
        return KRADServiceLocator.getBusinessObjectService();
    }

    /**
     * return the contextBoService
     */
    private ContextBoService getContextBoService() {
        return KrmsRepositoryServiceLocator.getContextBoService();
    }

    public List<RemotableAttributeField> retrieveAgendaCustomAttributes(View view, Object model, Container container) {
        StudentAgendaEditor agendaEditor = getAgendaEditor(model);
        return krmsRetriever.retrieveAgendaCustomAttributes(agendaEditor);
    }

    /**
     * Retrieve a list of {@link org.kuali.rice.core.api.uif.RemotableAttributeField}s for the parameters (if any) required by the resolver for
     * the selected term in the proposition that is under edit.
     */
    public List<RemotableAttributeField> retrieveTermParameters(View view, Object model, Container container) {

        List<RemotableAttributeField> results = new ArrayList<RemotableAttributeField>();

        StudentAgendaEditor agendaEditor = getAgendaEditor(model);

        // Figure out which rule is being edited
        RuleBo rule = agendaEditor.getAgendaItemLine().getRule();
        // Figure out which proposition is being edited
        Tree<RuleEditorTreeNode, String> propositionTree = rule.getPropositionTree();
        Node<RuleEditorTreeNode, String> editedPropositionNode = findEditedProposition(propositionTree.getRootElement());

        if (editedPropositionNode != null) {
            PropositionBo propositionBo = editedPropositionNode.getData().getProposition().getProposition();
            if (StringUtils.isEmpty(propositionBo.getCompoundOpCode()) && CollectionUtils.size(propositionBo.getParameters()) > 0) {
                // Get the term ID; if it is a new parameterized term, it will have a special prefix
                PropositionParameterBo param = propositionBo.getParameters().get(0);
                if (param.getValue().startsWith(KrmsImplConstants.PARAMETERIZED_TERM_PREFIX)) {
                    String termSpecId = param.getValue().substring(KrmsImplConstants.PARAMETERIZED_TERM_PREFIX.length());
                    TermResolverDefinition simplestResolver = getSimplestTermResolver(termSpecId, rule.getNamespace());

                    // Get the parameters and build RemotableAttributeFields
                    if (simplestResolver != null) {
                        List<String> parameterNames = new ArrayList<String>(simplestResolver.getParameterNames());
                        Collections.sort(parameterNames); // make param order deterministic

                        for (String parameterName : parameterNames) {
                            // TODO: also allow for DD parameters if there are matching type attributes
                            RemotableTextInput.Builder controlBuilder = RemotableTextInput.Builder.create();
                            controlBuilder.setSize(64);

                            RemotableAttributeField.Builder builder = RemotableAttributeField.Builder.create(parameterName);

                            builder.setRequired(true);
                            builder.setDataType(DataType.STRING);
                            builder.setControl(controlBuilder);
                            builder.setLongLabel(parameterName);
                            builder.setShortLabel(parameterName);
                            builder.setMinLength(Integer.valueOf(1));
                            builder.setMaxLength(Integer.valueOf(64));

                            results.add(builder.build());
                        }
                    }
                }
            }
        }

        return results;
    }

    /**
     * finds the term resolver with the fewest parameters that resolves the given term specification
     * @param termSpecId the id of the term specification
     * @param namespace the  namespace of the term specification
     * @return the simples {@link org.kuali.rice.krms.api.repository.term.TermResolverDefinition} found, or null if none was found
     */
    // public access so that AgendaEditorController can use it too
    public static TermResolverDefinition getSimplestTermResolver(String termSpecId,
            String namespace) {// Get the term resolver for the term spec

        List<TermResolverDefinition> resolvers =
                KrmsRepositoryServiceLocator.getTermBoService().findTermResolversByOutputId(termSpecId, namespace);

        TermResolverDefinition simplestResolver = null;

        for (TermResolverDefinition resolver : resolvers) {
            if (simplestResolver == null ||
                    simplestResolver.getParameterNames().size() < resolver.getParameterNames().size()) {
                simplestResolver = resolver;
            }
        }

        return simplestResolver;
    }

    /**
     * Find and return the node containing the proposition that is in currently in edit mode
     * @param node the node to start searching from (typically the root)
     * @return the node that is currently being edited, if any.  Otherwise, null.
     */
    private Node<RuleEditorTreeNode, String> findEditedProposition(Node<RuleEditorTreeNode, String> node) {
        Node<RuleEditorTreeNode, String> result = null;
        if (node.getData() != null && node.getData().getProposition() != null &&
                node.getData().getProposition().getProposition().getEditMode()) {
            result = node;
        } else {
            for (Node<RuleEditorTreeNode, String> child : node.getChildren()) {
                result = findEditedProposition(child);
                if (result != null) break;
            }
        }
        return result;
    }

    /**
     * Get the AgendaEditor out of the MaintenanceDocumentForm's newMaintainableObject
     * @param model the MaintenanceDocumentForm
     * @return the AgendaEditor
     */
    private StudentAgendaEditor getAgendaEditor(Object model) {
        MaintenanceDocumentForm MaintenanceDocumentForm = (MaintenanceDocumentForm)model;
        return (StudentAgendaEditor)MaintenanceDocumentForm.getDocument().getNewMaintainableObject().getDataObject();
    }

    public List<RemotableAttributeField> retrieveRuleActionCustomAttributes(View view, Object model, Container container) {
        StudentAgendaEditor agendaEditor = getAgendaEditor((MaintenanceDocumentForm) model);
        return krmsRetriever.retrieveRuleActionCustomAttributes(agendaEditor);
    }

    /**
     *  This only supports a single action within a rule.
     */
    public List<RemotableAttributeField> retrieveRuleCustomAttributes(View view, Object model, Container container) {
        StudentAgendaEditor agendaEditor = getAgendaEditor((MaintenanceDocumentForm) model);
        return krmsRetriever.retrieveRuleCustomAttributes(agendaEditor);
    }

    @Override
    public Object retrieveObjectForEditOrCopy(MaintenanceDocument document, Map<String, String> dataObjectKeys) {
        Object dataObject = null;

        try {
            // Since the dataObject is a wrapper class we need to build it and populate with the agenda bo.
            StudentAgendaEditor agendaEditor = new StudentAgendaEditor();
            AgendaBo agenda = getLookupService().findObjectBySearch(((StudentAgendaEditor) getDataObject()).getAgenda().getClass(), dataObjectKeys);
            if (KRADConstants.MAINTENANCE_COPY_ACTION.equals(getMaintenanceAction())) {
                String dateTimeStamp = (new Date()).getTime() + "";
                String newAgendaName = AgendaItemBo.COPY_OF_TEXT + agenda.getName() + " " + dateTimeStamp;

                AgendaBo copiedAgenda = agenda.copyAgenda(newAgendaName, dateTimeStamp);

                document.getDocumentHeader().setDocumentDescription(NEW_AGENDA_EDITOR_DOCUMENT_TEXT);
                document.setFieldsClearedOnCopy(true);
                agendaEditor.setAgenda(copiedAgenda);
            } else {
                // set custom attributes map in AgendaEditor
                //                agendaEditor.setCustomAttributesMap(agenda.getAttributes());
                agendaEditor.setAgenda(agenda);
            }
            agendaEditor.setCustomAttributesMap(agenda.getAttributes());


            // set extra fields on AgendaEditor
            agendaEditor.setNamespace(agenda.getContext().getNamespace());
            agendaEditor.setContextName(agenda.getContext().getName());

            dataObject = agendaEditor;
        } catch (ClassNotPersistenceCapableException ex) {
            if (!document.getOldMaintainableObject().isExternalBusinessObject()) {
                throw new RuntimeException("Data Object Class: " + getDataObjectClass() +
                        " is not persistable and is not externalizable - configuration error");
            }
            // otherwise, let fall through
        }

        return dataObject;
    }

    /**
     *  Returns the sequenceAssessorService
     * @return {@link org.kuali.rice.krad.service.SequenceAccessorService}
     */
    private SequenceAccessorService getSequenceAccessorService() {
        if ( sequenceAccessorService == null ) {
            sequenceAccessorService = KRADServiceLocator.getSequenceAccessorService();
        }
        return sequenceAccessorService;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void processAfterNew(MaintenanceDocument document, Map<String, String[]> requestParameters) {
        super.processAfterNew(document, requestParameters);
        document.getDocumentHeader().setDocumentDescription(NEW_AGENDA_EDITOR_DOCUMENT_TEXT);
    }

    @Override
    public void processAfterEdit(MaintenanceDocument document, Map<String, String[]> requestParameters) {
        super.processAfterEdit(document, requestParameters);
        document.getDocumentHeader().setDocumentDescription("Modify Agenda Editor Document");
    }

    @Override
    public void prepareForSave() {
        // set agenda attributes
        StudentAgendaEditor agendaEditor = (StudentAgendaEditor) getDataObject();
        agendaEditor.getAgenda().setAttributes(agendaEditor.getCustomAttributesMap());
    }

    @Override
    public void saveDataObject() {
        AgendaBo agendaBo = ((StudentAgendaEditor) getDataObject()).getAgenda();

        // handle saving new parameterized terms
        for (AgendaItemBo agendaItem : agendaBo.getItems()) {
            PropositionBo propositionBo = agendaItem.getRule().getProposition();
            if (propositionBo != null) {
                saveNewParameterizedTerms(propositionBo);
            }
        }

        if (agendaBo instanceof PersistableBusinessObject) {
            Map<String,String> primaryKeys = new HashMap<String, String>();
            primaryKeys.put("id", agendaBo.getId());
            AgendaBo blah = getBusinessObjectService().findByPrimaryKey(AgendaBo.class, primaryKeys);
            getBusinessObjectService().delete(blah);

            getBusinessObjectService().linkAndSave(agendaBo);
        } else {
            throw new RuntimeException(
                    "Cannot save object of type: " + agendaBo + " with business object service");
        }
    }

    /**
     * walk the proposition tree and save any new parameterized terms that are contained therein
     * @param propositionBo the root proposition from which to search
     */
    private void saveNewParameterizedTerms(PropositionBo propositionBo) {
        if (StringUtils.isBlank(propositionBo.getCompoundOpCode())) {
            // it is a simple proposition
             if (!propositionBo.getParameters().isEmpty() && propositionBo.getParameters().get(0).getValue().startsWith(KrmsImplConstants.PARAMETERIZED_TERM_PREFIX)) {
                String termId = propositionBo.getParameters().get(0).getValue();
                String termSpecId = termId.substring(KrmsImplConstants.PARAMETERIZED_TERM_PREFIX.length());
                // create new term
                TermBo newTerm = new TermBo();
                newTerm.setDescription(propositionBo.getNewTermDescription());
                newTerm.setSpecificationId(termSpecId);
                newTerm.setId(KRADServiceLocator.getSequenceAccessorService().getNextAvailableSequenceNumber(
                        KrmsMaintenanceConstants.Sequences.TERM_SPECIFICATION).toString());

                List<TermParameterBo> params = new ArrayList<TermParameterBo>();
                for (Map.Entry<String, String> entry : propositionBo.getTermParameters().entrySet()) {
                    TermParameterBo param = new TermParameterBo();
                    param.setTermId(newTerm.getId());
                    param.setName(entry.getKey());
                    param.setValue(entry.getValue());
                    param.setId(KRADServiceLocator.getSequenceAccessorService().getNextAvailableSequenceNumber(
                            KrmsMaintenanceConstants.Sequences.TERM_PARAMETER).toString());

                    params.add(param);
                }

                newTerm.setParameters(params);

                KRADServiceLocator.getBusinessObjectService().linkAndSave(newTerm);
                propositionBo.getParameters().get(0).setValue(newTerm.getId());
            }
        } else {
            // recurse
            for (PropositionBo childProp : propositionBo.getCompoundComponents()) {
                saveNewParameterizedTerms(childProp);
            }
        }
    }

    /**
     * Build a map from attribute name to attribute definition from all the defined attribute definitions for the
     * specified agenda type
     * @param agendaTypeId
     * @return
     */
    private Map<String, KrmsAttributeDefinition> buildAttributeDefinitionMap(String agendaTypeId) {
        KrmsAttributeDefinitionService attributeDefinitionService = KrmsRepositoryServiceLocator.getKrmsAttributeDefinitionService();

        // build a map from attribute name to definition
        Map<String, KrmsAttributeDefinition> attributeDefinitionMap = new HashMap<String, KrmsAttributeDefinition>();

        List<KrmsAttributeDefinition> attributeDefinitions =
                attributeDefinitionService.findAttributeDefinitionsByType(agendaTypeId);

        for (KrmsAttributeDefinition attributeDefinition : attributeDefinitions) {
            attributeDefinitionMap.put(attributeDefinition.getName(), attributeDefinition);
        }
        return attributeDefinitionMap;
    }

    @Override
    public boolean isOldDataObjectInDocument() {
        boolean isOldDataObjectInExistence = true;

        if (getDataObject() == null) {
            isOldDataObjectInExistence = false;
        } else {
            // dataObject contains a non persistable wrapper - use agenda from the wrapper object instead
            Map<String, ?> keyFieldValues = getDataObjectMetaDataService().getPrimaryKeyFieldValues(((StudentAgendaEditor) getDataObject()).getAgenda());
            for (Object keyValue : keyFieldValues.values()) {
                if (keyValue == null) {
                    isOldDataObjectInExistence = false;
                } else if ((keyValue instanceof String) && StringUtils.isBlank((String) keyValue)) {
                    isOldDataObjectInExistence = false;
                }

                if (!isOldDataObjectInExistence) {
                    break;
                }
            }
        }

        return isOldDataObjectInExistence;
    }

    // Since the dataObject is a wrapper class we need to return the agendaBo instead.
    @Override
    public Class getDataObjectClass() {
        return AgendaBo.class;
    }

    /**
     * In the case of edit maintenance adds a new blank line to the old side
     *
     * TODO: should this write some sort of missing message on the old side
     * instead?
     *
     * @see org.kuali.rice.krad.uif.service.impl.ViewHelperServiceImpl#processAfterAddLine(org.kuali.rice.krad.uif.view.View,
     *      org.kuali.rice.krad.uif.container.CollectionGroup, Object,
     *      Object)
     */
    @Override
    protected void processAfterAddLine(View view, CollectionGroup collectionGroup, Object model, Object addLine) {
        // Check for maintenance documents in edit but exclude notes
        if (model instanceof MaintenanceDocumentForm && KRADConstants.MAINTENANCE_EDIT_ACTION.equals(((MaintenanceDocumentForm)model).getMaintenanceAction()) && !(addLine instanceof Note)) {
            MaintenanceDocumentForm MaintenanceDocumentForm = (MaintenanceDocumentForm) model;
            MaintenanceDocument document = MaintenanceDocumentForm.getDocument();

            // Figure out which rule is being edited
            RuleBo rule = getAgendaEditor(model).getAgendaItemLine().getRule();
            // Figure out which proposition is being edited
            Tree<RuleEditorTreeNode, String> propositionTree = rule.getPropositionTree();
            Node<RuleEditorTreeNode, String> editedPropositionNode = findEditedProposition(propositionTree.getRootElement());

            // get the old object's collection
            Collection<Object> oldCollection = ObjectPropertyUtils
                    .getPropertyValue(editedPropositionNode.getData(),
                            collectionGroup.getPropertyName());

            try {
                Object blankLine = collectionGroup.getCollectionObjectClass().newInstance();
                //Add a blank line to the top of the collection
                if(oldCollection instanceof List){
                    ((List) oldCollection).add(0,blankLine);
                } else {
                    oldCollection.add(blankLine);
                }
            } catch (Exception e) {
                throw new RuntimeException("Unable to create new line instance for old maintenance object", e);
            }
        }
    }

    @Override
    protected void processBeforeAddLine(View view, CollectionGroup collectionGroup, Object model, Object addLine) {
        StudentAgendaEditor agendaEditor = getAgendaEditor(model);
        if (addLine instanceof ActionBo) {
            ((ActionBo) addLine).setNamespace(agendaEditor.getAgendaItemLine().getRule().getNamespace());
        }

        super.processBeforeAddLine(view, collectionGroup, model, addLine);
    }
}
