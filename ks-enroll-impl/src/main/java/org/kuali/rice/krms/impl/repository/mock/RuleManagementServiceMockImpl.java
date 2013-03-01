/*
 * Copyright 2011 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may	obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.rice.krms.impl.repository.mock;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.exception.RiceIllegalArgumentException;
import org.kuali.rice.core.api.exception.RiceIllegalStateException;
import org.kuali.rice.krms.api.repository.RuleManagementService;
import org.kuali.rice.krms.api.repository.agenda.AgendaDefinition;
import org.kuali.rice.krms.api.repository.agenda.AgendaItemDefinition;
import org.kuali.rice.krms.api.repository.agenda.AgendaTreeDefinition;
import org.kuali.rice.krms.api.repository.context.ContextDefinition;
import org.kuali.rice.krms.api.repository.context.ContextSelectionCriteria;
import org.kuali.rice.krms.api.repository.language.NaturalLanguageTemplate;
import org.kuali.rice.krms.api.repository.language.NaturalLanguageUsage;
import org.kuali.rice.krms.api.repository.proposition.PropositionDefinition;
import org.kuali.rice.krms.api.repository.reference.ReferenceObjectBinding;
import org.kuali.rice.krms.api.repository.rule.RuleDefinition;
import org.kuali.student.common.mock.MockService;
import org.kuali.student.common.util.UUIDHelper;

public class RuleManagementServiceMockImpl implements MockService, RuleManagementService {
    // cache variable 
    // The LinkedHashMap is just so the values come back in a predictable order

    private Map<String, ReferenceObjectBinding> referenceObjectBindingMap = new LinkedHashMap<String, ReferenceObjectBinding>();
    private Map<String, AgendaDefinition> agendaMap = new LinkedHashMap<String, AgendaDefinition>();
    private Map<String, AgendaItemDefinition> agendaItemMap = new LinkedHashMap<String, AgendaItemDefinition>();
    private Map<String, RuleDefinition> ruleMap = new LinkedHashMap<String, RuleDefinition>();
    private Map<String, PropositionDefinition> propositionMap = new LinkedHashMap<String, PropositionDefinition>();
    private Map<String, NaturalLanguageUsage> naturalLanguageUsageMap = new LinkedHashMap<String, NaturalLanguageUsage>();
    private Map<String, ContextDefinition> contextMap = new LinkedHashMap<String, ContextDefinition>();
    private Map<String, NaturalLanguageTemplate> naturalLanguageTemplateMap = new LinkedHashMap<String, NaturalLanguageTemplate>();

    @Override
    public void clear() {
        this.referenceObjectBindingMap.clear();
        this.agendaMap.clear();
        this.agendaItemMap.clear();
        this.ruleMap.clear();
        this.propositionMap.clear();
        this.naturalLanguageUsageMap.clear();
        this.contextMap.clear();
        this.naturalLanguageTemplateMap.clear();
    }

    @Override
    public ReferenceObjectBinding createReferenceObjectBinding(ReferenceObjectBinding referenceObjectDefinition)
            throws RiceIllegalArgumentException {
        // CREATE
        ReferenceObjectBinding orig = this.getReferenceObjectBinding(referenceObjectDefinition.getId());
        if (orig != null) {
            throw new RiceIllegalArgumentException(referenceObjectDefinition.getId());
        }
        ReferenceObjectBinding.Builder copy = ReferenceObjectBinding.Builder.create(referenceObjectDefinition);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        referenceObjectDefinition = copy.build();
        referenceObjectBindingMap.put(referenceObjectDefinition.getId(), referenceObjectDefinition);
        return referenceObjectDefinition;
    }

    @Override
    public ReferenceObjectBinding getReferenceObjectBinding(String id)
            throws RiceIllegalArgumentException {
        // GET_BY_ID
        if (!this.referenceObjectBindingMap.containsKey(id)) {
            throw new RiceIllegalArgumentException(id);
        }
        return this.referenceObjectBindingMap.get(id);
    }

    @Override
    public List<ReferenceObjectBinding> getReferenceObjectBindings(List<String> ids)
            throws RiceIllegalArgumentException {
        // GET_BY_IDS
        List<ReferenceObjectBinding> list = new ArrayList<ReferenceObjectBinding>();
        for (String id : ids) {
            list.add(this.getReferenceObjectBinding(id));
        }
        return list;
    }

    @Override
    public List<ReferenceObjectBinding> findReferenceObjectBindingsByReferenceDiscriminatorType(String referenceObjectReferenceDiscriminatorType)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("findReferenceObjectBindingsByReferenceDiscriminatorType has not been implemented");
    }

    @Override
    public List<ReferenceObjectBinding> findReferenceObjectBindingsByKrmsDiscriminatorType(String referenceObjectKrmsDiscriminatorType)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("findReferenceObjectBindingsByKrmsDiscriminatorType has not been implemented");
    }

    @Override
    public List<ReferenceObjectBinding> findReferenceObjectBindingsByKrmsObject(String krmsObjectId)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("findReferenceObjectBindingsByKrmsObject has not been implemented");
    }

    @Override
    public void updateReferenceObjectBinding(ReferenceObjectBinding referenceObjectBindingDefinition)
            throws RiceIllegalArgumentException {
        // UPDATE
        ReferenceObjectBinding.Builder copy = ReferenceObjectBinding.Builder.create(referenceObjectBindingDefinition);
        ReferenceObjectBinding old = this.getReferenceObjectBinding(referenceObjectBindingDefinition.getId());
        if (!old.getVersionNumber().equals(copy.getVersionNumber())) {
            throw new RiceIllegalStateException("" + old.getVersionNumber());
        }
        copy.setVersionNumber(copy.getVersionNumber() + 1);
        referenceObjectBindingDefinition = copy.build();
        this.referenceObjectBindingMap.put(referenceObjectBindingDefinition.getId(), referenceObjectBindingDefinition);
        return;
    }

    @Override
    public void deleteReferenceObjectBinding(String id)
            throws RiceIllegalArgumentException {
        // DELETE
        if (this.referenceObjectBindingMap.remove(id) == null) {
            throw new RiceIllegalArgumentException(id);
        }
        return;
    }

    @Override
    public List<String> findReferenceObjectBindingIds(QueryByCriteria queryByCriteria)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("findReferenceObjectBindingIds has not been implemented");
    }

    @Override
    public AgendaDefinition createAgenda(AgendaDefinition agendaDefinition)
            throws RiceIllegalArgumentException {
        // CREATE
        AgendaDefinition orig = this.getAgenda(agendaDefinition.getId());
        if (orig != null) {
            throw new RiceIllegalArgumentException(agendaDefinition.getId() + "." + agendaDefinition.getName());
        }
        AgendaDefinition.Builder copy = AgendaDefinition.Builder.create(agendaDefinition);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        agendaDefinition = copy.build();
        agendaMap.put(agendaDefinition.getId(), agendaDefinition);
        return agendaDefinition;
    }

    @Override
    public AgendaDefinition getAgenda(String id)
            throws RiceIllegalArgumentException {
        // GET_BY_ID
        if (!this.agendaMap.containsKey(id)) {
            throw new RiceIllegalArgumentException(id);
        }
        return this.agendaMap.get(id);
    }

    @Override
    public List<AgendaDefinition> getAgendasByType(String typeId)
            throws RiceIllegalArgumentException {
        // GET_IDS_BY_TYPE
        List<AgendaDefinition> list = new ArrayList<AgendaDefinition>();
        for (AgendaDefinition info : agendaMap.values()) {
            if (typeId.equals(info.getTypeId())) {
                list.add(info);
            }
        }
        return list;
    }

    @Override
    public List<AgendaDefinition> getAgendasByContext(String contextId)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("getAgendasByContext has not been implemented");
    }

    @Override
    public List<AgendaDefinition> getAgendasByTypeAndContext(String typeId, String contextId)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("getAgendasByTypeAndContext has not been implemented");
    }

    @Override
    public void updateAgenda(AgendaDefinition agendaDefinition)
            throws RiceIllegalArgumentException {
        // UPDATE
        AgendaDefinition.Builder copy = AgendaDefinition.Builder.create(agendaDefinition);
        AgendaDefinition old = this.getAgenda(agendaDefinition.getId());
        if (!old.getVersionNumber().equals(copy.getVersionNumber())) {
            throw new RiceIllegalStateException("" + old.getVersionNumber());
        }
        copy.setVersionNumber(copy.getVersionNumber() + 1);
        agendaDefinition = copy.build();
        this.agendaMap.put(agendaDefinition.getId(), agendaDefinition);
        return;
    }

    @Override
    public void deleteAgenda(String id)
            throws RiceIllegalArgumentException {
        // DELETE
        if (this.agendaMap.remove(id) == null) {
            throw new RiceIllegalArgumentException(id);
        }
        return;
    }

    @Override
    public AgendaItemDefinition createAgendaItem(AgendaItemDefinition agendaItemDefinition)
            throws RiceIllegalArgumentException {
        // CREATE
        AgendaItemDefinition.Builder copy = AgendaItemDefinition.Builder.create(agendaItemDefinition);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        agendaItemDefinition = copy.build();
        agendaItemMap.put(agendaItemDefinition.getId(), agendaItemDefinition);
        return agendaItemDefinition;
    }

    @Override
    public AgendaItemDefinition getAgendaItem(String id)
            throws RiceIllegalArgumentException {
        // GET_BY_ID
        if (!this.agendaItemMap.containsKey(id)) {
            throw new RiceIllegalArgumentException(id);
        }
        return this.agendaItemMap.get(id);
    }

    @Override
    public List<AgendaItemDefinition> getAgendaItemsByType(String typeId)
            throws RiceIllegalArgumentException {
        // GET_IDS_BY_TYPE
        List<AgendaDefinition> agendas = this.getAgendasByType(typeId);
        List<AgendaItemDefinition> list = new ArrayList<AgendaItemDefinition>();
        for (AgendaDefinition agenda : agendas) {
            for (AgendaItemDefinition info : agendaItemMap.values()) {
                if (agenda.getId().equals(info.getAgendaId())) {
                    list.add(info);
                }
            }
        }
        return list;
    }

    @Override
    public List<AgendaItemDefinition> getAgendaItemsByContext(String contextId)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("getAgendaItemsByContext has not been implemented");
    }

    @Override
    public List<AgendaItemDefinition> getAgendaItemsByTypeAndContext(String typeId, String contextId)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("getAgendaItemsByTypeAndContext has not been implemented");
    }

    @Override
    public void updateAgendaItem(AgendaItemDefinition agendaItemDefinition)
            throws RiceIllegalArgumentException {
        // UPDATE
        AgendaItemDefinition.Builder copy = AgendaItemDefinition.Builder.create(agendaItemDefinition);
        AgendaItemDefinition old = this.getAgendaItem(agendaItemDefinition.getId());
        if (!old.getVersionNumber().equals(copy.getVersionNumber())) {
            throw new RiceIllegalStateException("" + old.getVersionNumber());
        }
        copy.setVersionNumber(copy.getVersionNumber() + 1);
        agendaItemDefinition = copy.build();
        this.agendaItemMap.put(agendaItemDefinition.getId(), agendaItemDefinition);
        return;
    }

    @Override
    public void deleteAgendaItem(String id)
            throws RiceIllegalArgumentException {
        // DELETE
        if (this.agendaItemMap.remove(id) == null) {
            throw new RiceIllegalArgumentException(id);
        }
        return;
    }

    @Override
    public RuleDefinition createRule(RuleDefinition ruleDefinition)
            throws RiceIllegalArgumentException {
        // CREATE
        RuleDefinition orig = this.getRule(ruleDefinition.getId());
        if (orig != null) {
            throw new RiceIllegalArgumentException(ruleDefinition.getId());
        }
        RuleDefinition.Builder copy = RuleDefinition.Builder.create(ruleDefinition);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        ruleDefinition = copy.build();
        ruleMap.put(ruleDefinition.getId(), ruleDefinition);
        return ruleDefinition;
    }

    @Override
    public RuleDefinition getRule(String ruleId) {
        // GET_BY_ID
        if (!this.ruleMap.containsKey(ruleId)) {
            throw new RiceIllegalArgumentException(ruleId);
        }
        return this.ruleMap.get(ruleId);
    }

    @Override
    public List<RuleDefinition> getRules(List<String> ruleIds) {
        // UNKNOWN
        throw new RiceIllegalArgumentException("getRules has not been implemented");
    }

    @Override
    public void updateRule(RuleDefinition ruleDefinition)
            throws RiceIllegalArgumentException {
        // UPDATE
        RuleDefinition.Builder copy = RuleDefinition.Builder.create(ruleDefinition);
        RuleDefinition old = this.getRule(ruleDefinition.getId());
        if (!old.getVersionNumber().equals(copy.getVersionNumber())) {
            throw new RiceIllegalStateException("" + old.getVersionNumber());
        }
        copy.setVersionNumber(copy.getVersionNumber() + 1);
        ruleDefinition = copy.build();
        this.ruleMap.put(ruleDefinition.getId(), ruleDefinition);
        return;
    }

    @Override
    public void deleteRule(String id)
            throws RiceIllegalArgumentException {
        // DELETE
        if (this.ruleMap.remove(id) == null) {
            throw new RiceIllegalArgumentException(id);
        }
        return;
    }

    @Override
    public PropositionDefinition createProposition(PropositionDefinition propositionDefinition)
            throws RiceIllegalArgumentException {
        // CREATE
        PropositionDefinition orig = this.getProposition(propositionDefinition.getId());
        if (orig != null) {
            throw new RiceIllegalArgumentException(propositionDefinition.getId());
        }
        PropositionDefinition.Builder copy = PropositionDefinition.Builder.create(propositionDefinition);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        propositionDefinition = copy.build();
        propositionMap.put(propositionDefinition.getId(), propositionDefinition);
        return propositionDefinition;
    }

    @Override
    public PropositionDefinition getProposition(String id)
            throws RiceIllegalArgumentException {
        // GET_BY_ID
        if (!this.propositionMap.containsKey(id)) {
            throw new RiceIllegalArgumentException(id);
        }
        return this.propositionMap.get(id);
    }

    @Override
    public Set<PropositionDefinition> getPropositionsByType(String typeId)
            throws RiceIllegalArgumentException {
        // GET_IDS_BY_TYPE
        Set<PropositionDefinition> set = new LinkedHashSet<PropositionDefinition>();
        for (PropositionDefinition info : propositionMap.values()) {
            if (typeId.equals(info.getTypeId())) {
                set.add(info);
            }
        }
        return set;
    }

    @Override
    public Set<PropositionDefinition> getPropositionsByRule(String ruleId)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("getPropositionsByRule has not been implemented");
    }

    @Override
    public void updateProposition(PropositionDefinition propositionDefinition)
            throws RiceIllegalArgumentException {
        // UPDATE
        PropositionDefinition.Builder copy = PropositionDefinition.Builder.create(propositionDefinition);
        PropositionDefinition old = this.getProposition(propositionDefinition.getId());
        if (!old.getVersionNumber().equals(copy.getVersionNumber())) {
            throw new RiceIllegalStateException("" + old.getVersionNumber());
        }
        copy.setVersionNumber(copy.getVersionNumber() + 1);
        propositionDefinition = copy.build();
        this.propositionMap.put(propositionDefinition.getId(), propositionDefinition);
        return;
    }

    @Override
    public void deleteProposition(String id)
            throws RiceIllegalArgumentException {
        // DELETE
        if (this.propositionMap.remove(id) == null) {
            throw new RiceIllegalArgumentException(id);
        }
        return;
    }

    @Override
    public NaturalLanguageUsage createNaturalLanguageUsage(NaturalLanguageUsage naturalLanguageUsage)
            throws RiceIllegalArgumentException {
        // CREATE
        NaturalLanguageUsage orig = this.getNaturalLanguageUsage(naturalLanguageUsage.getId());
        if (orig != null) {
            throw new RiceIllegalArgumentException(naturalLanguageUsage.getId());
        }
        NaturalLanguageUsage.Builder copy = NaturalLanguageUsage.Builder.create(naturalLanguageUsage);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        naturalLanguageUsage = copy.build();
        naturalLanguageUsageMap.put(naturalLanguageUsage.getId(), naturalLanguageUsage);
        return naturalLanguageUsage;
    }

    @Override
    public NaturalLanguageUsage getNaturalLanguageUsage(String id)
            throws RiceIllegalArgumentException {
        // GET_BY_ID
        if (!this.naturalLanguageUsageMap.containsKey(id)) {
            throw new RiceIllegalArgumentException(id);
        }
        return this.naturalLanguageUsageMap.get(id);
    }

    @Override
    public void updateNaturalLanguageUsage(NaturalLanguageUsage naturalLanguageUsage)
            throws RiceIllegalArgumentException {
        // UPDATE
        NaturalLanguageUsage.Builder copy = NaturalLanguageUsage.Builder.create(naturalLanguageUsage);
        NaturalLanguageUsage old = this.getNaturalLanguageUsage(naturalLanguageUsage.getId());
        if (!old.getVersionNumber().equals(copy.getVersionNumber())) {
            throw new RiceIllegalStateException("" + old.getVersionNumber());
        }
        copy.setVersionNumber(copy.getVersionNumber() + 1);
        naturalLanguageUsage = copy.build();
        this.naturalLanguageUsageMap.put(naturalLanguageUsage.getId(), naturalLanguageUsage);
        return;
    }

    @Override
    public void deleteNaturalLanguageUsage(String naturalLanguageUsageId)
            throws RiceIllegalArgumentException {
        // DELETE
        if (this.naturalLanguageUsageMap.remove(naturalLanguageUsageId) == null) {
            throw new RiceIllegalArgumentException(naturalLanguageUsageId);
        }
        return;
    }

    @Override
    public String getNaturalLanguageForType(String naturalLanguageUsageId, String typeId, String krmsObjectId, String languageCode)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("getNaturalLanguageForType has not been implemented");
    }

    @Override
    public String getNaturalLanguageForProposition(String naturalLanguageUsageId,
            PropositionDefinition propositionDefinintion, String languageCode)
            throws RiceIllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<NaturalLanguageUsage> getNaturalLanguageUsagesByNamespace(String namespace) throws RiceIllegalArgumentException {
        List<NaturalLanguageUsage> list = new ArrayList<NaturalLanguageUsage>();
        for (NaturalLanguageUsage info : naturalLanguageUsageMap.values()) {
            if (namespace.equals(info.getNamespace())) {
                list.add(info);
            }
        }
        return list;
    }

    @Override
    public ContextDefinition selectContext(ContextSelectionCriteria contextSelectionCriteria) throws RiceIllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AgendaTreeDefinition getAgendaTree(String agendaId) throws RiceIllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AgendaTreeDefinition> getAgendaTrees(List<String> agendaIds) throws RiceIllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ContextDefinition createContext(ContextDefinition contextDefinition)
            throws RiceIllegalArgumentException {
        // CREATE
        ContextDefinition orig = this.getContextByNameAndNamespace(contextDefinition.getName(), contextDefinition.getNamespace());
        if (orig != null) {
            throw new RiceIllegalArgumentException(contextDefinition.getNamespace() + "." + contextDefinition.getName());
        }
        ContextDefinition.Builder copy = ContextDefinition.Builder.create(contextDefinition);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        contextDefinition = copy.build();
        contextMap.put(contextDefinition.getId(), contextDefinition);
        return contextDefinition;
    }

    @Override
    public void updateContext(ContextDefinition contextDefinition)
            throws RiceIllegalArgumentException {
        // UPDATE
        ContextDefinition.Builder copy = ContextDefinition.Builder.create(contextDefinition);
        ContextDefinition old = this.getContext(contextDefinition.getId());
        if (!old.getVersionNumber().equals(copy.getVersionNumber())) {
            throw new RiceIllegalStateException("" + old.getVersionNumber());
        }
        copy.setVersionNumber(copy.getVersionNumber() + 1);
        contextDefinition = copy.build();
        this.contextMap.put(contextDefinition.getId(), contextDefinition);
        return;
    }

    @Override
    public void deleteContext(String id)
            throws RiceIllegalArgumentException {
        // DELETE
        if (this.contextMap.remove(id) == null) {
            throw new RiceIllegalArgumentException(id);
        }
        return;
    }

    @Override
    public ContextDefinition getContext(String id)
            throws RiceIllegalArgumentException {
        // GET_BY_ID
        if (!this.contextMap.containsKey(id)) {
            throw new RiceIllegalArgumentException(id);
        }
        return this.contextMap.get(id);
    }

    @Override
    public ContextDefinition getContextByNameAndNamespace(String name, String namespace)
            throws RiceIllegalArgumentException {
        // RICE_GET_BY_NAMESPACE_AND_NAME
        for (ContextDefinition info : contextMap.values()) {
            if (name.equals(info.getName())) {
                if (namespace.equals(info.getNamespace())) {
                    return ContextDefinition.Builder.create(info).build();
                }
            }
        }
        throw new RiceIllegalArgumentException();
    }

    @Override
    public NaturalLanguageTemplate createNaturalLanguageTemplate(NaturalLanguageTemplate naturalLanguageTemplate)
            throws RiceIllegalArgumentException {
        // CREATE
        NaturalLanguageTemplate orig = this.getNaturalLanguageTemplate(naturalLanguageTemplate.getId());
        if (orig != null) {
            throw new RiceIllegalArgumentException(naturalLanguageTemplate.getId());
        }
        NaturalLanguageTemplate.Builder copy = NaturalLanguageTemplate.Builder.create(naturalLanguageTemplate);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        naturalLanguageTemplate = copy.build();
        naturalLanguageTemplateMap.put(naturalLanguageTemplate.getId(), naturalLanguageTemplate);
        return naturalLanguageTemplate;
    }

    @Override
    public NaturalLanguageTemplate getNaturalLanguageTemplate(String naturalLanguageTemplateId)
            throws RiceIllegalArgumentException {
        // GET_BY_ID
        if (!this.naturalLanguageTemplateMap.containsKey(naturalLanguageTemplateId)) {
            throw new RiceIllegalArgumentException(naturalLanguageTemplateId);
        }
        return this.naturalLanguageTemplateMap.get(naturalLanguageTemplateId);
    }

    @Override
    public void updateNaturalLanguageTemplate(NaturalLanguageTemplate naturalLanguageTemplate)
            throws RiceIllegalArgumentException {
        // UPDATE
        NaturalLanguageTemplate.Builder copy = NaturalLanguageTemplate.Builder.create(naturalLanguageTemplate);
        NaturalLanguageTemplate old = this.getNaturalLanguageTemplate(naturalLanguageTemplate.getId());
        if (!old.getVersionNumber().equals(copy.getVersionNumber())) {
            throw new RiceIllegalStateException("" + old.getVersionNumber());
        }
        copy.setVersionNumber(copy.getVersionNumber() + 1);
        naturalLanguageTemplate = copy.build();
        this.naturalLanguageTemplateMap.put(naturalLanguageTemplate.getId(), naturalLanguageTemplate);
        return;
    }

    @Override
    public void deleteNaturalLanguageTemplate(String naturalLanguageTemplateId)
            throws RiceIllegalArgumentException {
        // DELETE
        if (this.naturalLanguageTemplateMap.remove(naturalLanguageTemplateId) == null) {
            throw new RiceIllegalArgumentException(naturalLanguageTemplateId);
        }
        return;
    }

    @Override
    public List<NaturalLanguageTemplate> findNaturalLanguageTemplatesByLanguageCode(String languageCode)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("findNaturalLanguageTemplatesByLanguageCode has not been implemented");
    }

    @Override
    public NaturalLanguageTemplate findNaturalLanguageTemplateByLanguageCodeTypeIdAndNluId(String languageCode, String typeId, String naturalLanguageUsageId)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("findNaturalLanguageTemplateByLanguageCodeTypeIdAndNluId has not been implemented");
    }

    @Override
    public List<NaturalLanguageTemplate> findNaturalLanguageTemplatesByNaturalLanguageUsage(String naturalLanguageUsageId)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("findNaturalLanguageTemplatesByNaturalLanguageUsage has not been implemented");
    }

    @Override
    public List<NaturalLanguageTemplate> findNaturalLanguageTemplatesByType(String typeId)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("findNaturalLanguageTemplatesByType has not been implemented");
    }

    @Override
    public List<NaturalLanguageTemplate> findNaturalLanguageTemplatesByTemplate(String template)
            throws RiceIllegalArgumentException {
        // UNKNOWN
        throw new RiceIllegalArgumentException("findNaturalLanguageTemplatesByTemplate has not been implemented");
    }
}
