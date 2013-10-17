/**
 * Copyright 2005-2013 The Kuali Foundation
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

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.krms.api.repository.proposition.PropositionType;
import org.kuali.rice.krms.api.repository.term.TermDefinition;
import org.kuali.rice.krms.api.repository.type.KrmsTypeDefinition;
import org.kuali.rice.krms.builder.ComponentBuilder;
import org.kuali.rice.krms.dto.ActionEditor;
import org.kuali.rice.krms.dto.PropositionEditor;
import org.kuali.rice.krms.dto.PropositionParameterEditor;
import org.kuali.rice.krms.dto.RuleEditor;
import org.kuali.rice.krms.dto.TermEditor;
import org.kuali.rice.krms.dto.TermParameterEditor;
import org.kuali.rice.krms.util.PropositionTreeUtil;
import org.kuali.student.common.util.ContextBuilder;
import org.kuali.student.enrollment.class1.krms.dto.FEPropositionEditor;
import org.kuali.student.enrollment.class1.krms.dto.FERuleEditor;
import org.kuali.student.enrollment.class2.courseoffering.util.CourseOfferingResourceLoader;
import org.kuali.student.lum.lu.ui.krms.service.impl.LURuleViewHelperServiceImpl;
import org.kuali.student.r2.common.util.date.DateFormatters;
import org.kuali.student.r2.core.constants.KSKRMSServiceConstants;
import org.kuali.student.r2.core.room.dto.BuildingInfo;
import org.kuali.student.r2.core.room.dto.RoomInfo;
import org.kuali.student.r2.core.room.service.RoomService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kuali Student Team
 */
public class FERuleViewHelperServiceImpl extends LURuleViewHelperServiceImpl {

    private RoomService roomService;

    /**
     * @return
     */
    @Override
    public Class<? extends PropositionEditor> getPropositionEditorClass() {
        return FEPropositionEditor.class;
    }

    @Override
    public void refreshInitTrees(RuleEditor rule) {

        if (rule == null) {
            return;
        }

        //Rebuild the trees
        rule.setEditTree(getEditTreeBuilder().buildTree(rule));
    }

    /**
     * Initializes the proposition, populating the type and terms.
     *
     * @param propositionEditor
     */
    protected void initPropositionEditor(PropositionEditor propositionEditor) {
        if (PropositionType.SIMPLE.getCode().equalsIgnoreCase(propositionEditor.getPropositionTypeCode())) {

            if (propositionEditor.getType() == null) {
                KrmsTypeDefinition type = this.getKrmsTypeRepositoryService().getTypeById(propositionEditor.getTypeId());
                propositionEditor.setType(type.getName());
            }

            ComponentBuilder builder = this.getTemplateRegistry().getComponentBuilderForType(propositionEditor.getType());
            if (builder != null) {
                Map<String, String> termParameters = this.getTermParameters(propositionEditor);
                builder.resolveTermParameters(propositionEditor, termParameters);
            }
        } else {
            for (PropositionEditor child : propositionEditor.getCompoundEditors()) {
                initPropositionEditor(child);
            }

        }
    }

    /**
     * Create TermEditor from the TermDefinition objects to be used in the ui and return a map of
     * the key and values of the term parameters.
     *
     * @param proposition
     * @return
     */
    protected Map<String, String> getTermParameters(PropositionEditor proposition) {

        Map<String, String> termParameters = new HashMap<String, String>();
        if (proposition.getTerm() == null) {
            PropositionParameterEditor termParameter = PropositionTreeUtil.getTermParameter(proposition.getParameters());
            if (termParameter != null) {
                String termId = termParameter.getValue();
                TermDefinition termDefinition = this.getTermRepositoryService().getTerm(termId);
                proposition.setTerm(new TermEditor(termDefinition));
            } else {
                return termParameters;
            }
        }

        for (TermParameterEditor parameter : proposition.getTerm().getEditorParameters()) {
            termParameters.put(parameter.getName(), parameter.getValue());
        }

        return termParameters;
    }

    public List<BuildingInfo> retrieveBuildingInfo(String buildingCode, boolean strictMatch) throws Exception {

        QueryByCriteria.Builder qbcBuilder = QueryByCriteria.Builder.create();
        if (!strictMatch) {
            buildingCode = StringUtils.upperCase(buildingCode) + "%";
        }
        qbcBuilder.setPredicates(PredicateFactory.like("buildingCode", buildingCode));

        QueryByCriteria criteria = qbcBuilder.build();

        List<BuildingInfo> b = getRoomService().searchForBuildings(criteria, createContextInfo());
        return b;
    }

    public List<RoomInfo> retrieveRoomInfo(String roomCode, String buildingCode, boolean strictMatch) throws Exception {

        int firstBuilding = 0;
        List<BuildingInfo> buildings = getRoomService().getBuildingsByBuildingCode(buildingCode, ContextBuilder.loadContextInfo());

        if (StringUtils.isBlank(roomCode)) {
            List<String> roomIds = getRoomService().getRoomIdsByBuilding(buildings.get(firstBuilding).getId(), ContextBuilder.loadContextInfo());
            return getRoomService().getRoomsByIds(roomIds, ContextBuilder.loadContextInfo());
        } else {
            return getRoomService().getRoomsByBuildingAndRoomCode(buildings.get(firstBuilding).getBuildingCode(), roomCode, ContextBuilder.loadContextInfo());
        }

    }

    public void rebuildActions(FERuleEditor ruleEditor) {
        try {
            ArrayList<ActionEditor> newActions = new ArrayList<ActionEditor>();
            ArrayList<ActionEditor> actions = (ArrayList<ActionEditor>) ruleEditor.getActions();
            for (ActionEditor action : actions) {
                Map<String, String> attributes = action.getAttributes();
                Map<String, String> newAttributes = new HashMap<String, String>();
                if (ruleEditor.getDay() != null) {
                    newAttributes.put(KSKRMSServiceConstants.ACTION_PARAMETER_TYPE_RDL_DAY, ruleEditor.getDay());
                }
                if (ruleEditor.isTba()) {
                    newAttributes.put(KSKRMSServiceConstants.ACTION_PARAMETER_TYPE_RDL_STARTTIME, Boolean.TRUE.toString());
                } else {
                    if (ruleEditor.getStartTime() != null) {
                        String startTimeAMPM = new StringBuilder(ruleEditor.getStartTime()).append(" ").append(ruleEditor.getStartTimeAMPM()).toString();
                        long startTimeMillis = this.parseTimeToMillis(startTimeAMPM);
                        String startTime = String.valueOf(startTimeMillis);
                        newAttributes.put(KSKRMSServiceConstants.ACTION_PARAMETER_TYPE_RDL_STARTTIME, startTime);
                    }
                    if (ruleEditor.getEndTime() != null) {
                        String endTimeAMPM = new StringBuilder(ruleEditor.getEndTime()).append(" ").append(ruleEditor.getEndTimeAMPM()).toString();
                        long endTimeMillis = this.parseTimeToMillis(endTimeAMPM);
                        String endTime = String.valueOf(endTimeMillis);
                        newAttributes.put(KSKRMSServiceConstants.ACTION_PARAMETER_TYPE_RDL_ENDTIME, endTime);
                    }
                    newAttributes.put(KSKRMSServiceConstants.ACTION_PARAMETER_TYPE_RDL_STARTTIME, Boolean.FALSE.toString());
                }

                if (ruleEditor.getBuilding().getBuildingCode() != null && !ruleEditor.getBuilding().getBuildingCode().isEmpty()) {
                    List<BuildingInfo> buildingInfos = new ArrayList<BuildingInfo>();
                    buildingInfos = retrieveBuildingInfo(ruleEditor.getBuilding().getBuildingCode(), true);
                    for (BuildingInfo buildingInfo : buildingInfos) {
                        if (buildingInfo.getBuildingCode().equals(ruleEditor.getBuilding().getBuildingCode())) {
                            newAttributes.put(KSKRMSServiceConstants.ACTION_PARAMETER_TYPE_RDL_FACILITY, buildingInfo.getId());
                            break;
                        }
                    }

                }
                if (ruleEditor.getRoom().getRoomCode() != null && !ruleEditor.getRoom().getRoomCode().isEmpty()) {

                    List<RoomInfo> roomInfos = new ArrayList<RoomInfo>();
                    roomInfos = retrieveRoomInfo(ruleEditor.getRoom().getRoomCode(), ruleEditor.getBuilding().getBuildingCode(), true);
                    for (RoomInfo roomInfo : roomInfos) {
                        if (roomInfo.getRoomCode().equals(ruleEditor.getRoom().getRoomCode())) {
                            newAttributes.put(KSKRMSServiceConstants.ACTION_PARAMETER_TYPE_RDL_ROOM, roomInfo.getId());
                            break;
                        }
                    }

                }
                action.setAttributes(newAttributes);
                action.setDescription(ruleEditor.getDescription());
                newActions.add(action);
            }
            ((ArrayList<ActionEditor>) ruleEditor.getActions()).clear();
            ((ArrayList<ActionEditor>) ruleEditor.getActions()).addAll(newActions);
            ((FERuleEditor) ruleEditor).getTimePeriodToDisplay();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected long parseTimeToMillis(final String time) throws ParseException {
        return DateFormatters.HOUR_MINUTE_AM_PM_TIME_FORMATTER.parse(time).getTime();
    }

    public RoomService getRoomService() {
        if (roomService == null) {
            roomService = CourseOfferingResourceLoader.loadRoomService();
        }
        return roomService;
    }

}
