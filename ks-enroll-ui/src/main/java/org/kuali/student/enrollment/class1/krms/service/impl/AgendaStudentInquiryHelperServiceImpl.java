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

import org.kuali.rice.core.api.uif.RemotableAttributeField;
import org.kuali.rice.kns.inquiry.KualiInquirableImpl;
import org.kuali.rice.krad.uif.container.Container;
import org.kuali.rice.krad.uif.view.View;
import org.kuali.rice.krad.web.form.InquiryForm;
import org.kuali.rice.krms.impl.repository.AgendaBo;
import org.kuali.rice.krms.impl.ui.AgendaEditor;
import org.kuali.rice.krms.impl.util.KrmsRetriever;

import java.util.List;
import java.util.Map;

/**
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public class AgendaStudentInquiryHelperServiceImpl extends KualiInquirableImpl {

    private transient KrmsRetriever krmsRetriever = new KrmsRetriever();

    @Override
    public AgendaEditor retrieveDataObject(Map fieldValues) {
        AgendaEditor agendaEditor = null;

        String agendaId = (String) fieldValues.get("id");
        AgendaBo agenda = getBusinessObjectService().findBySinglePrimaryKey(AgendaBo.class, agendaId);
        if (agenda != null) {
            agendaEditor = new AgendaEditor();
            agendaEditor.setAgenda(agenda);
            agendaEditor.setNamespace(agenda.getContext().getNamespace());
            agendaEditor.setContextName(agenda.getContext().getName());
            agendaEditor.setCustomAttributesMap(agenda.getAttributes());
        }

        return agendaEditor;
    }

    /**
     * Returns the AgendaEditor from the given InquiryForm
     * @param model InquiryFrom to retrieve the AgendaEditor from.
     * @return AgendaEditor retrieved from the given InquiryForm.
     */
    private AgendaEditor retrieveAgendaEditor(InquiryForm model) {
        InquiryForm inquiryForm = (InquiryForm)model;
        return (AgendaEditor)inquiryForm.getDataObject();
    }

    /**
     * Returns the Agenda's RemotableAttributeFields
     * @param view
     * @param model InquiryFrom to retrieve the AgendaEditor from.
     * @param container
     * @return List<RemotableAttributeField>
     */
    public List<RemotableAttributeField> retrieveAgendaCustomAttributes(View view, Object model, Container container) {
        AgendaEditor agendaEditor = retrieveAgendaEditor((InquiryForm) model);
        return krmsRetriever.retrieveAgendaCustomAttributes(agendaEditor);
    }


    /**
     * Returns the Rule RemotableAttributeFields. This only supports a single action within a rule.
     * @param view
     * @param model InquiryFrom to retrieve the AgendaEditor from.
     * @param container
     * @return List<RemotableAttributeField>
     */
    public List<RemotableAttributeField> retrieveRuleCustomAttributes(View view, Object model, Container container) {
        AgendaEditor agendaEditor = retrieveAgendaEditor((InquiryForm)model);
        return krmsRetriever.retrieveRuleCustomAttributes(agendaEditor);
    }


}
