/**
 * Copyright 2010 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kuali.student.lum.program.client.requirements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.student.common.assembly.data.Metadata;
import org.kuali.student.common.ui.client.application.KSAsyncCallback;
import org.kuali.student.common.ui.client.configurable.mvc.SectionTitle;
import org.kuali.student.common.ui.client.configurable.mvc.views.VerticalSectionView;
import org.kuali.student.common.ui.client.mvc.Callback;
import org.kuali.student.common.ui.client.mvc.View;
import org.kuali.student.common.ui.client.service.MetadataRpcService;
import org.kuali.student.common.ui.client.service.MetadataRpcServiceAsync;
import org.kuali.student.common.ui.client.widgets.KSProgressIndicator;
import org.kuali.student.common.ui.client.widgets.buttongroups.ButtonEnumerations;
import org.kuali.student.common.ui.client.widgets.field.layout.button.ActionCancelGroup;
import org.kuali.student.common.ui.client.widgets.progress.BlockingTask;
import org.kuali.student.common.ui.client.widgets.progress.KSBlockingProgressIndicator;
import org.kuali.student.common.versionmanagement.dto.VersionDisplayInfo;
import org.kuali.student.core.statement.dto.*;
import org.kuali.student.core.statement.ui.client.widgets.rules.ReqCompEditWidget;
import org.kuali.student.core.statement.ui.client.widgets.rules.ReqComponentInfoUi;
import org.kuali.student.core.statement.ui.client.widgets.rules.RuleManageWidget;
import org.kuali.student.core.statement.ui.client.widgets.rules.RulesUtil;
import org.kuali.student.lum.common.client.widgets.*;
import org.kuali.student.lum.lu.dto.CluInfo;
import org.kuali.student.lum.program.client.properties.ProgramProperties;
import org.kuali.student.lum.program.client.rpc.StatementRpcService;
import org.kuali.student.lum.program.client.rpc.StatementRpcServiceAsync;
import org.kuali.student.lum.program.dto.ProgramRequirementInfo;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProgramRequirementsManageView extends VerticalSectionView {

    private StatementRpcServiceAsync statementRpcServiceAsync = GWT.create(StatementRpcService.class);
    private MetadataRpcServiceAsync metadataServiceAsync = GWT.create(MetadataRpcService.class);   

    protected static final String TEMLATE_LANGUAGE = "en";
    protected static final String RULEEDIT_TEMLATE = "KUALI.RULE";
    protected static final String RULEPREVIEW_TEMLATE = RULEEDIT_TEMLATE + ".PREVIEW";
    protected static final String COMPOSITION_TEMLATE = "KUALI.RULE.COMPOSITION";
    private static final String LU_NAMESPACE = "http://student.kuali.org/wsdl/lu";
    private static final String CLU_NAMESPACE_URI = "{" + LU_NAMESPACE + "}cluInfo";

    private ProgramRequirementsViewController parentController;

    //view's widgets
    private VerticalPanel layout = new VerticalPanel();
    private ReqCompEditWidget editReqCompWidget;
    private RuleManageWidget ruleManageWidget;
    private SimplePanel twiddlerPanel = new SimplePanel();
    private ActionCancelGroup actionCancelButtons = new ActionCancelGroup(ButtonEnumerations.SaveCancelEnum.SAVE, ButtonEnumerations.SaveCancelEnum.CANCEL);

    //view's data
    private StatementTreeViewInfo rule = null;
    private boolean isInitialized = false;
    private boolean isNewRule = false;
    private ReqComponentInfo editedReqCompInfo = null;
    private Integer internalProgReqID = null;
    private String originalReqCompNL;
    private String originalLogicExpression;

    //   private boolean isLocalDirty = false;
	private BlockingTask creatingRuleTask = new BlockingTask("Creating Rule");

    public ProgramRequirementsManageView(ProgramRequirementsViewController parentController, Enum<?> viewEnum, String name, String modelId) {
        super(viewEnum, name, modelId);
        this.parentController = parentController;
    }

    @Override
    public void beforeShow(final Callback<Boolean> onReadyCallback) {

        retrieveAndSetupReqCompTypes(); //TODO cache it for each statement type?
        if (!isInitialized) {
            setupHandlers();
            draw();
            isInitialized = true;
        }

        onReadyCallback.exec(true);
    }

    private void setupHandlers() {
        editReqCompWidget.setReqCompConfirmButtonClickCallback(actionButtonClickedReqCompCallback);
        editReqCompWidget.setNewReqCompSelectedCallbackCallback(newReqCompSelectedCallbackCallback);
        editReqCompWidget.setRetrieveCompositionTemplateCallback(retrieveCompositionTemplateCallback);
        editReqCompWidget.setRetrieveFieldsMetadataCallback(retrieveFieldsMetadataCallback);
        editReqCompWidget.setRetrieveCustomWidgetCallback(retrieveCustomWidgetCallback);
        ruleManageWidget.setReqCompEditButtonClickCallback(editReqCompCallback);
    }

    private void draw() {

        remove(layout);
        layout.clear();

        //STEP 1
        SectionTitle title = SectionTitle.generateH3Title(ProgramProperties.get().programRequirements_manageViewPageStep1Title());
        title.setStyleName("KS-Program-Requirements-Manage-Step-header1");  //make the header orange
        layout.add(title);

        layout.add(editReqCompWidget);

        //STEP 2
        title = SectionTitle.generateH3Title(ProgramProperties.get().programRequirements_manageViewPageStep2Title());
        title.setStyleName("KS-Program-Requirements-Manage-Step-header2");  //make the header orange
        layout.add(title);

        layout.add(ruleManageWidget);

        //add progressive indicator when rules are being simplified
        KSProgressIndicator twiddler = new KSProgressIndicator();
        twiddler.setVisible(false);
        twiddlerPanel.setWidget(twiddler);
        layout.add(twiddlerPanel);

        addWidget(layout);

        displaySaveButton();
    }

    private void displaySaveButton() {
        actionCancelButtons.addStyleName("KS-Program-Requirements-Save-Button");
        actionCancelButtons.addCallback(new Callback<ButtonEnumerations.ButtonEnum>(){
             @Override
            public void exec(final ButtonEnumerations.ButtonEnum result) {
                parentController.getView(ProgramRequirementsViewController.ProgramRequirementsViews.PREVIEW, new Callback<View>(){
                    @Override
                    public void exec(View preview) {
                        //update rules data model and summary view
                        if ((result == ButtonEnumerations.SaveCancelEnum.SAVE) && isDirty()) {
                            ProgramRequirementInfo affectedRule = ((ProgramRequirementsSummaryView) preview).getRules().updateRules(getRuleTree(), internalProgReqID, isNewRule());
                            ((ProgramRequirementsSummaryView) preview).updateRequirementWidgets(affectedRule);                            
                        }
                        isDirty = false;
                        parentController.showView(ProgramRequirementsViewController.ProgramRequirementsViews.PREVIEW);
                    }
                });
             }
        });
        addWidget(actionCancelButtons);
    }

    // called by requirement display widget when user wants to edit or add a sub-rule
    public void setRuleTree(StatementTreeViewInfo stmtTreeInfo, boolean newRuleFlag, Integer internalProgReqID) {

        if (!isInitialized) {
            editReqCompWidget = new ReqCompEditWidget(ProgramRequirementsSummaryView.NEW_REQ_COMP_ID);
            ruleManageWidget = new RuleManageWidget();
            ruleManageWidget.setReqCompEditButtonClickCallback(editReqCompCallback);
            ruleManageWidget.setRuleChangedButtonClickCallback(ruleChangedCallback);
        }

        this.internalProgReqID = internalProgReqID;
        editedReqCompInfo = null;
        rule = RulesUtil.clone(stmtTreeInfo);
        isNewRule = newRuleFlag;
        originalReqCompNL = getAllReqCompNLs();

        //update screen elements
        editReqCompWidget.setupNewReqComp();
        ruleManageWidget.redraw(rule, false);
       // originalLogicExpression = ruleManageWidget.getLogicExpression();
    }

    //retrieve the latest version from rule table widget and update the local copy
    public StatementTreeViewInfo getRuleTree() {
        rule = ruleManageWidget.getStatementTreeViewInfo();
        return rule;
    }

    public boolean isNewRule() {
        return isNewRule;
    }

    //called when user clicked on rule 'edit' link
    protected Callback<ReqComponentInfo> editReqCompCallback = new Callback<ReqComponentInfo>(){
        public void exec(ReqComponentInfo reqComp) {
            setEnabled(false);
            editReqCompWidget.setupExistingReqComp(reqComp);
            editedReqCompInfo = reqComp;
        }
    };

    protected Callback<Boolean> ruleChangedCallback = new Callback<Boolean>(){
        public void exec(Boolean ruleChanged) {
            actionCancelButtons.getButton(ButtonEnumerations.SaveCancelEnum.SAVE).setEnabled(ruleChanged);
        }
    };

    protected void setEnabled(boolean enabled) {
        ruleManageWidget.setEnabled(enabled);
        actionCancelButtons.getButton(ButtonEnumerations.SaveCancelEnum.SAVE).setEnabled(enabled);
    }

    @Override
    public boolean isDirty() {
        if (!isInitialized) {
            return false;
        }

        //TODO until we figure out how to detect changes, always return true
        return true;

        //first check logic expression
//        if (!ruleManageWidget.getLogicExpression().equals(originalLogicExpression)) {
//            return true;
//        }

        //next check NL for req. components
      //  if ((originalNL == null) && (rule.getNaturalLanguageTranslation() == null)) {
      //      return !ruleManageWidget.getLogicExpression().equals(originalLogicExpression);
      //  }
        //TODO how to check whether rule changed or not?
       // !(ruleManageWidget.getLogicExpression().equals(originalLogicExpression) && getAllReqCompNLs().equals(originalReqCompNL));
    }

    private String getAllReqCompNLs() {
    	StringBuilder NL = new StringBuilder();
        for (StatementTreeViewInfo tree : rule.getStatements()) {
            for (ReqComponentInfo reqComp : tree.getReqComponents()) {
                NL.append(reqComp.getNaturalLanguageTranslation());
            }
        }
        return NL.toString();
    }

    //called when user clicks 'Add Rule' or 'Update Rule' when editing a req. component
    protected Callback<ReqComponentInfoUi> actionButtonClickedReqCompCallback = new Callback<ReqComponentInfoUi>(){
        public void exec(final ReqComponentInfoUi reqComp) {

            editReqCompWidget.setupNewReqComp();
            setEnabled(true);

            //true if user cancel adding/editing req. component
            if (reqComp == null) {
                return;
            }

            KSBlockingProgressIndicator.addTask(creatingRuleTask);

            //1. update NL for the req. component
            statementRpcServiceAsync.translateReqComponentToNLs(reqComp, new String[]{RULEEDIT_TEMLATE,RULEPREVIEW_TEMLATE}, TEMLATE_LANGUAGE, new KSAsyncCallback<List<String>>() {
                public void handleFailure(Throwable caught) {
                    KSBlockingProgressIndicator.removeTask(creatingRuleTask);
                    Window.alert(caught.getMessage());
                    GWT.log("translateReqComponentToNL failed", caught);
               }

                public void onSuccess(final List<String> reqCompNL) {

                    reqComp.setNaturalLanguageTranslation(reqCompNL.get(0));
                    reqComp.setPreviewNaturalLanguageTranslation(reqCompNL.get(1));

                    //2. add / update req. component
                    rule = ruleManageWidget.getStatementTreeViewInfo();  //TODO ?

                    if (editedReqCompInfo == null) {  //add req. component
                        if (rule.getStatements() != null && !rule.getStatements().isEmpty()) {
                            StatementTreeViewInfo newStatementTreeViewInfo = new StatementTreeViewInfo();
                            newStatementTreeViewInfo.setId(ProgramRequirementsSummaryView.NEW_STMT_TREE_ID + Integer.toString(ProgramRequirementsSummaryView.tempStmtTreeID++));
                            newStatementTreeViewInfo.setOperator(rule.getStatements().get(0).getOperator());
                            newStatementTreeViewInfo.getReqComponents().add(reqComp);
                            rule.getStatements().add(newStatementTreeViewInfo);
                        } else {
                            rule.getReqComponents().add(reqComp);
                            //set default operator between req. components of the rule
                            if (rule.getOperator() == null) {
                                rule.setOperator(StatementOperatorTypeKey.AND);
                            }
                        }
                    } else {    //update req. component
                        editedReqCompInfo.setNaturalLanguageTranslation(reqComp.getNaturalLanguageTranslation());
                        editedReqCompInfo.setReqCompFields(reqComp.getReqCompFields());
                        editedReqCompInfo.setType(reqComp.getType());
                        editedReqCompInfo = null;  //de-reference from existing req. component
                    }

                    ruleManageWidget.redraw(rule, true);
                    KSBlockingProgressIndicator.removeTask(creatingRuleTask);
                }
            });
        }
    };

    //called when user selects a rule type in the editor
    protected Callback<ReqComponentInfo> newReqCompSelectedCallbackCallback = new Callback<ReqComponentInfo>(){
        public void exec(final ReqComponentInfo reqComp) {
            setEnabled(false);
        }
    };

    private void retrieveAndSetupReqCompTypes() {

        statementRpcServiceAsync.getReqComponentTypesForStatementType(rule.getType(), new KSAsyncCallback<List<ReqComponentTypeInfo>>() {
            public void handleFailure(Throwable cause) {
            	GWT.log("Failed to get req. component types for statement of type:" + rule.getType(), cause);
            	Window.alert("Failed to get req. component types for statement of type:" + rule.getType());
            }

            public void onSuccess(final List<ReqComponentTypeInfo> reqComponentTypeInfoList) {
                if (reqComponentTypeInfoList == null || reqComponentTypeInfoList.size() == 0) {
                    GWT.log("Missing Requirement Component Types", null);
                    Window.alert("Missing Requirement Component Types");
                    return;
                }
                editReqCompWidget.setReqCompList(reqComponentTypeInfoList);
                editReqCompWidget.setCustomWidgets(getCustomWidgets(reqComponentTypeInfoList));                
            }
        });
    }

    private Map<String, Widget> getCustomWidgets(List<ReqComponentTypeInfo> reqComponentTypeInfoList) {
        Map<String, Widget> customWidgets = new HashMap<String, Widget>();

        for (ReqComponentTypeInfo reqCompTypeInfo : reqComponentTypeInfoList) {
            for (ReqCompFieldTypeInfo fieldTypeInfo : reqCompTypeInfo.getReqCompFieldTypeInfos()) {
                if (RulesUtil.isGradeWidget(fieldTypeInfo.getId())) {
                    customWidgets.put("kuali.reqComponent.field.type.grade.id", new GradeWidget());
                } else if (RulesUtil.isCourseWidget(fieldTypeInfo.getId())) {

                    final CourseWidget courseWidget = new CourseWidget();
                    
                    courseWidget.addGetCluNameCallback(new Callback() {

                        @Override
                        public void exec(Object id) {

                            statementRpcServiceAsync.getCurrentVersion(CLU_NAMESPACE_URI, (String)id, new AsyncCallback<VersionDisplayInfo>() {
                                @Override
                                public void onFailure(Throwable throwable) {
                                    Window.alert(throwable.getMessage());
                                    GWT.log("Failed to retrieve clu for id: '" +  "'", throwable);
                                }

                                @Override
                                public void onSuccess(final VersionDisplayInfo versionInfo) {
                                    statementRpcServiceAsync.getClu(versionInfo.getId(), new AsyncCallback<CluInfo>() {
                                        @Override
                                        public void onFailure(Throwable throwable) {
                                            Window.alert(throwable.getMessage());
                                            GWT.log("Failed to retrieve clu", throwable);
                                        }

                                        @Override
                                        public void onSuccess(CluInfo cluInfo) {
                                            courseWidget.setLabelContent(cluInfo.getVersionInfo().getVersionIndId(), cluInfo.getOfficialIdentifier().getCode());
                                        }
                                    });
                                }
                            });


                        }
                    });

                    customWidgets.put("kuali.reqComponent.field.type.course.clu.id", courseWidget);
                } else if (RulesUtil.isProgramWidget(fieldTypeInfo.getId())) {
                    final ProgramWidget programWidget = new ProgramWidget();

                    programWidget.addGetCluNameCallback(new Callback() {

                        @Override
                        public void exec(Object id) {

                            statementRpcServiceAsync.getCurrentVersion(CLU_NAMESPACE_URI, (String)id, new AsyncCallback<VersionDisplayInfo>() {
                                @Override
                                public void onFailure(Throwable throwable) {
                                    Window.alert(throwable.getMessage());
                                    GWT.log("Failed to retrieve clu for id: '" +  "'", throwable);
                                }

                                @Override
                                public void onSuccess(final VersionDisplayInfo versionInfo) {
                                    statementRpcServiceAsync.getClu(versionInfo.getId(), new AsyncCallback<CluInfo>() {
                                        @Override
                                        public void onFailure(Throwable throwable) {
                                            Window.alert(throwable.getMessage());
                                            GWT.log("Failed to retrieve clu", throwable);
                                        }

                                        @Override
                                        public void onSuccess(CluInfo cluInfo) {
                                            programWidget.setLabelContent(cluInfo.getVersionInfo().getVersionIndId(), cluInfo.getOfficialIdentifier().getCode());
                                        }
                                    });
                                }
                            });
                        }
                    });

                    customWidgets.put("kuali.reqComponent.field.type.program.clu.id", programWidget);
                }
            }
        }
        return customWidgets;
    }

    //called when user selects a rule type in the rule editor
    protected Callback<ReqComponentInfo> retrieveCompositionTemplateCallback = new Callback<ReqComponentInfo>(){
        public void exec(final ReqComponentInfo reqComp) {
            statementRpcServiceAsync.translateReqComponentToNL(reqComp, COMPOSITION_TEMLATE, TEMLATE_LANGUAGE, new KSAsyncCallback<String>() {
                public void handleFailure(Throwable caught) {
                    Window.alert(caught.getMessage());
                    GWT.log("translateReqComponentToNL failed for req. comp. type: '" + reqComp.getType() + "'",caught);
                }

                public void onSuccess(final String compositionTemplate) {
                    editReqCompWidget.displayFieldsStart(compositionTemplate);
                }
            });
        }
    };

    protected Callback<List<String>> retrieveFieldsMetadataCallback = new Callback<List<String>>(){
        public void exec(final List<String> fieldTypes) {

            if (fieldTypes.contains("kuali.reqComponent.field.type.grade.id")) {
                fieldTypes.add("kuali.reqComponent.field.type.gradeType.id");
            }

            metadataServiceAsync.getMetadataList(ReqCompFieldInfo.class.getName(), fieldTypes, null, new KSAsyncCallback<List<Metadata>>() {
                public void handleFailure(Throwable caught) {
                    Window.alert(caught.getMessage());
                    GWT.log("getMetadataList failed for req. comp. types: '" + fieldTypes.toString() + "'",caught);
                }

                public void onSuccess(final List<Metadata> metadataList) {
                    editReqCompWidget.displayFieldsEnd(metadataList);
                }
            });
        }
    };

    protected Callback<String> retrieveCustomWidgetCallback = new Callback<String>(){
        public void exec(final String fieldType) {
            if (RulesUtil.isCluSetWidget(fieldType)) {
                String clusetType = "kuali.cluSet.type.Course";
                if (fieldType.toLowerCase().indexOf("program") > 0) {
                    clusetType = "kuali.cluSet.type.Program";
                }
                editReqCompWidget.displayCustomWidget(fieldType, new BuildCluSetWidget(new CluSetRetrieverImpl(), clusetType, false));
            }
        }
    };

    public Integer getInternalProgReqID() {
        return internalProgReqID;
    }
}
