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
package org.kuali.student.enrollment.class1.krms.controller;

import org.kuali.rice.krad.uif.UifConstants;
import org.kuali.rice.krad.uif.UifParameters;
import org.kuali.rice.krad.web.form.DocumentFormBase;
import org.kuali.rice.krad.web.form.MaintenanceDocumentForm;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.rice.krms.controller.RuleEditorController;
import org.kuali.rice.krms.dto.PropositionEditor;
import org.kuali.rice.krms.dto.RuleEditor;
import org.kuali.rice.krms.util.AgendaUtilities;
import org.kuali.rice.krms.util.PropositionTreeUtil;
import org.kuali.student.enrollment.class1.krms.dto.CORuleManagementWrapper;
import org.kuali.student.enrollment.class1.krms.dto.CluSetInformation;
import org.kuali.student.enrollment.class1.krms.dto.CluSetRangeInformation;
import org.kuali.student.enrollment.class1.krms.dto.EnrolPropositionEditor;
import org.kuali.student.enrollment.class1.krms.dto.EnrolRuleEditor;
import org.kuali.student.enrollment.class1.krms.service.impl.EnrolRuleViewHelperServiceImpl;
import org.kuali.student.common.uif.util.KSControllerHelper;
import org.kuali.student.enrollment.class1.krms.util.CluSetRangeHelper;
import org.kuali.student.krms.KRMSConstants;
import org.kuali.student.r2.lum.clu.dto.MembershipQueryInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Override of RuleEditorController for Student
 *
 * @author Kuali Student Team
 */
public class EnrolRuleEditorController extends RuleEditorController {

    /**
     *
     * @param form
     * @param result
     * @param request
     * @param response
     * @return
     */
    @Override
    @RequestMapping(params = "methodToCall=route")
    public ModelAndView route(@ModelAttribute("KualiForm") DocumentFormBase form, BindingResult result,
                              HttpServletRequest request, HttpServletResponse response) {

        super.route(form, result, request, response);
        return back(form, result, request, response);
    }

    /**
     *
     * @param form
     * @param result
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "methodToCall=cancel")
    @Override
    public ModelAndView cancel(@ModelAttribute("KualiForm") UifFormBase form, BindingResult result,
                               HttpServletRequest request, HttpServletResponse response) {

        DocumentFormBase documentForm = (DocumentFormBase) form;
        performWorkflowAction(documentForm, UifConstants.WorkflowAction.CANCEL, false);

        return back(form,result,request,response);
    }

    /**
     *
     * @param form
     * @param result
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    @RequestMapping(params = "methodToCall=addRule")
    public ModelAndView addRule(@ModelAttribute("KualiForm") UifFormBase form, @SuppressWarnings("unused") BindingResult result,
                                @SuppressWarnings("unused") HttpServletRequest request, @SuppressWarnings("unused") HttpServletResponse response) throws Exception {

        //Clear the client state on new edit rule.
        form.getClientStateForSyncing().clear();
        MaintenanceDocumentForm document = (MaintenanceDocumentForm) form;

        RuleEditor ruleEditor = AgendaUtilities.getSelectedRuleEditor(document);
        EnrolRuleEditor enrolRuleEditor = new EnrolRuleEditor(ruleEditor.getKey(), true, ruleEditor.getRuleTypeInfo(), false);
        AgendaUtilities.getRuleWrapper(document).setRuleEditor(enrolRuleEditor);

        this.getViewHelper(form).refreshInitTrees(enrolRuleEditor);

        if(!form.getActionParameters().containsKey(UifParameters.NAVIGATE_TO_PAGE_ID)){
            form.getActionParameters().put(UifParameters.NAVIGATE_TO_PAGE_ID, "KRMS-RuleMaintenance-Page");
        }
        return super.navigate(form, result, request, response);
    }

    /**
     * Controller method used to display the lightbox with the list of courses in the selected range.
     *
     * @param form
     * @param result
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params="methodToCall=viewCourseRange")
    public ModelAndView viewCourseRange(@ModelAttribute("KualiForm") UifFormBase form, BindingResult result,
                                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dialog = "courseRangeLookup";

        MaintenanceDocumentForm document = (MaintenanceDocumentForm) form;
        CORuleManagementWrapper ruleWrapper = (CORuleManagementWrapper) document.getDocument().getNewMaintainableObject().getDataObject();
        EnrolPropositionEditor proposition = (EnrolPropositionEditor) PropositionTreeUtil.getProposition(ruleWrapper.getRuleEditor());

        String index = form.getActionParameters().get("selectedIndex");
        if ((proposition.getCluSet() != null) && (proposition.getCluSet().getCluSetRanges()!=null)){
            ruleWrapper.setClusInRange(proposition.getCluSet().getCluSetRanges().get(Integer.valueOf(index)).getClusInRange());
        }

        return showDialog(dialog, form, request, response);
     }

    /**
     * Controller method used to add a new course range to the list of course ranges.
     *
     * @param form
     * @param result
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "methodToCall=addRange")
    public ModelAndView addRange(@ModelAttribute("KualiForm") UifFormBase form, BindingResult result,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

        EnrolRuleEditor rule = (EnrolRuleEditor) getRuleEditor(form);
        EnrolPropositionEditor prop = (EnrolPropositionEditor) PropositionTreeUtil.getProposition(rule);

        if(prop.getCluSet()==null){
            prop.setCluSet(new CluSetInformation());
        }

        //Build the membershipquery
        CluSetRangeHelper rangeHelper = prop.getCluSet().getRangeHelper();
        MembershipQueryInfo membershipQueryInfo = rangeHelper.buildMembershipQuery();

        //Build the cluset range wrapper object
        CluSetRangeInformation cluSetRange = new CluSetRangeInformation();
        cluSetRange.setCluSetRangeLabel(rangeHelper.buildLabelFromQuery(membershipQueryInfo));
        cluSetRange.setMembershipQueryInfo(membershipQueryInfo);
        cluSetRange.setClusInRange(this.getViewHelper(form).getCoursesInRange(membershipQueryInfo));
        prop.getCluSet().getCluSetRanges().add(cluSetRange);

        //Reset range helper to clear values on screen.
        rangeHelper.reset();

        return getUIFModelAndView(form);
    }

    /**
     *
     * @param form
     * @return
     */
    protected EnrolRuleViewHelperServiceImpl getViewHelper(UifFormBase form) {
        return (EnrolRuleViewHelperServiceImpl) KSControllerHelper.getViewHelperService(form);
    }
}
