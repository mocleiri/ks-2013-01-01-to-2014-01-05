package org.kuali.student.enrollment.class1.krms.controller;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.krad.uif.UifConstants;
import org.kuali.rice.krad.uif.UifParameters;
import org.kuali.rice.krad.uif.util.ObjectPropertyUtils;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.web.controller.UifControllerBase;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.enrollment.class1.krms.dto.RuleEditor;
import org.kuali.student.enrollment.class1.krms.form.AgendaManagementForm;
import org.kuali.student.enrollment.class1.krms.service.AgendaManagementViewHelperService;
import org.kuali.student.enrollment.class2.courseoffering.dto.ActivityOfferingWrapper;
import org.kuali.student.enrollment.class2.courseoffering.dto.CourseOfferingEditWrapper;
import org.kuali.student.enrollment.class2.courseoffering.dto.CourseOfferingListSectionWrapper;
import org.kuali.student.enrollment.class2.courseoffering.util.ActivityOfferingConstants;
import org.kuali.student.enrollment.class2.courseoffering.util.CourseOfferingConstants;
import org.kuali.student.enrollment.class2.courseoffering.util.CourseOfferingResourceLoader;
import org.kuali.student.enrollment.courseoffering.dto.ActivityOfferingInfo;
import org.kuali.student.enrollment.courseoffering.dto.CourseOfferingInfo;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingService;
import org.kuali.student.krms.KRMSConstants;
import org.kuali.student.r2.common.util.ContextUtils;
import org.kuali.student.r2.core.acal.dto.TermInfo;
import org.kuali.student.r2.core.class1.state.service.StateService;
import org.kuali.student.r2.core.class1.type.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping(value = "/agendaManagement")
public class AgendaManagementController extends UifControllerBase  {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(AgendaManagementController.class);

    private TypeService typeService;
    private StateService stateService;
    private AgendaManagementViewHelperService viewHelperService;

    @Override
    protected UifFormBase createInitialForm(HttpServletRequest request) {
        return new AgendaManagementForm();
    }

    @Override
    @RequestMapping(params = "methodToCall=start")
    public ModelAndView start(@ModelAttribute("KualiForm") UifFormBase form, @SuppressWarnings("unused") BindingResult result,
            @SuppressWarnings("unused") HttpServletRequest request, @SuppressWarnings("unused") HttpServletResponse response) {

        if (!(form instanceof AgendaManagementForm)){
            throw new RuntimeException("Form object passed into start method was not of expected type AgendaManagementForm. Got "+form.getClass().getSimpleName());
        }

        AgendaManagementForm theForm = (AgendaManagementForm) form;
        // set adminOrg to the form to temporarily overcome that we actually need page level authorization but not view
        // level authorization.
        String inputValue = request.getParameter("adminOrg");
        if ((inputValue != null) && !inputValue.isEmpty()){
            theForm.setAdminOrg(inputValue);
        }
        //clean up termCode, inputCode, and theCourseOffering value in the form to prevent the
        //side effect of the authorization.
        theForm.setTermCode(null);
        theForm.setInputCode(null);
        theForm.setTheCourseOffering(null);

        // check view authorization
        if (form.getView() != null) {
            String methodToCall = request.getParameter(KRADConstants.DISPATCH_REQUEST_PARAMETER);
            checkViewAuthorization(theForm, methodToCall);
            theForm.setEditAuthz(checkEditViewAuthz(theForm));
        }

        // check if the view is invoked within portal or not
        inputValue = request.getParameter("withinPortal");
        if ((inputValue != null) && !inputValue.isEmpty()){
            boolean withinPortal = Boolean.valueOf(request.getParameter("withinPortal"));
            theForm.setWithinPortal(withinPortal);
        }

        return getUIFModelAndView(theForm);
    }

    /*
     * Method used to
     *  1) search to get TermInfo based on termCode. Only accept one valid TermInfo. If find more than one TermInfo or
     *  don't find any termInfo, log and report an error message.
     *  2) If the input is subject code, load all course offerings based on termId and subjectCode
     *  3) If the input is course offering code,
     *      a)find THE course offering based on termId and courseOfferingCode. If find more than one CO or don't find
     *        any CO, log and report an error message.
     *      b)load all activity offerings based on the courseOfferingId
     */
    @RequestMapping(params = "methodToCall=show")
    public ModelAndView show(@ModelAttribute("KualiForm") AgendaManagementForm theForm, @SuppressWarnings("unused") BindingResult result,
                             @SuppressWarnings("unused") HttpServletRequest request, @SuppressWarnings("unused") HttpServletResponse response) throws Exception {

        //First, find TermInfo based on termCode
        String termCode = theForm.getTermCode();
        List<TermInfo> termList = getViewHelperService(theForm).findTermByTermCode(termCode);

        if (termList != null && !termList.isEmpty()){
            if( termList.size() == 1) {
                // Get THE term
                theForm.setTermInfo(termList.get(0));
            } else {
                LOG.error("Error: Found more than one Term for term code: " + termCode);
                GlobalVariables.getMessageMap().putError("termCode", CourseOfferingConstants.COURSEOFFERING_MSG_ERROR_FOUND_MORE_THAN_ONE_TERM, termCode);
                theForm.clearCourseOfferingResultList();
                return getUIFModelAndView(theForm);
             }
        } else {
            LOG.error("Error: Can't find any Term for term code: " + termCode);
            GlobalVariables.getMessageMap().putError("termCode", CourseOfferingConstants.COURSEOFFERING_MSG_ERROR_NO_TERM_IS_FOUND, termCode);
            theForm.clearCourseOfferingResultList();
            return getUIFModelAndView(theForm);
        }

        //load all courseofferings based on subject Code
        String inputCode = theForm.getInputCode();
        if (inputCode != null && !inputCode.isEmpty()) {
            getViewHelperService(theForm).loadAgendasByTermAndCourseCode(theForm.getTermInfo().getId(), inputCode, theForm);
            /*if(!theForm.getCourseOfferingResultList().isEmpty()) {
                if (theForm.getCourseOfferingResultList().size() > 1) {
                    theForm.setSubjectCode(theForm.getCourseOfferingResultList().get(0).getSubjectArea());
                    // Pull out the first CO from the result list and then pull out the org ids from this CO
                    // and pass in the first one as the adminOrg
                    CourseOfferingInfo firstCO = getCourseOfferingService().getCourseOffering(theForm.getCourseOfferingResultList().get(0).getCourseOfferingId(), ContextUtils.createDefaultContextInfo());
                    List<String> orgIds = firstCO.getUnitsDeploymentOrgIds();
                    if(orgIds !=null && !orgIds.isEmpty()){
                        theForm.setAdminOrg(orgIds.get(0));
                    }
                    CourseOfferingInfo coToShow = getCourseOfferingService().getCourseOffering(theForm.getCourseOfferingResultList().get(0).getCourseOfferingId(), ContextUtils.createDefaultContextInfo());
                    theForm.setCourseOfferingCode(coToShow.getCourseOfferingCode());

                    // set the cross listed data
                    assignCrossListedInForm(theForm, coToShow);

                    //ToolbarUtil.processCoToolbarForDeptAdmin(theForm.getCourseOfferingResultList(), theForm);
                } else { // just one course offering is returned
                    CourseOfferingInfo coToShow = getCourseOfferingService().getCourseOffering(theForm.getCourseOfferingResultList().get(0).getCourseOfferingId(), ContextUtils.createDefaultContextInfo());
                    theForm.setCourseOfferingCode(coToShow.getCourseOfferingCode());
                    assignCrossListedInForm(theForm, coToShow);
                    return _prepareManageAOsModelAndView(theForm, coToShow);
                }
            } */
            //
            theForm.setEditAuthz(checkEditViewAuthz(theForm));
            if (GlobalVariables.getMessageMap().getErrorMessages().isEmpty()){
                return getUIFModelAndView(theForm, "manageAgendasPage");
            }else{
                return getUIFModelAndView(theForm, CourseOfferingConstants.SEARCH_PAGE);
            }
        } else {
            LOG.error("Error: Course Code search field can't be empty");
            GlobalVariables.getMessageMap().putError("inputCode", CourseOfferingConstants.COURSEOFFERING_MSG_ERROR_NO_COURSE_OFFERING_IS_FOUND, "Course Offering", inputCode, termCode);
            theForm.clearCourseOfferingResultList();

            return getUIFModelAndView(theForm);
        }
    }

    private ModelAndView _prepareManageAOsModelAndView(AgendaManagementForm theForm, CourseOfferingInfo coToShow) throws Exception {
        CourseOfferingEditWrapper wrapper = new CourseOfferingEditWrapper(coToShow);

        theForm.setCourseOfferingEditWrapper(wrapper);
        theForm.setTheCourseOffering(coToShow);
        //Pull out the org ids and pass in the first one as the adminOrg
        List<String> orgIds = coToShow.getUnitsDeploymentOrgIds();
        if(orgIds !=null && !orgIds.isEmpty()){
            theForm.setAdminOrg(orgIds.get(0));
        }
        theForm.setFormatIdForNewAO(null);
        theForm.setActivityIdForNewAO(null);
        theForm.setNoOfActivityOfferings(null);

        theForm.setEditAuthz(checkEditViewAuthz(theForm));

        //ToolbarUtil.processAoToolbarForDeptAdmin(theForm.getActivityWrapperList(), theForm);
        return getUIFModelAndView(theForm, CourseOfferingConstants.MANAGE_AO_PAGE);
    }

    /*
     * Method used to edit a selected CO or AO
     */
    @RequestMapping(params = "methodToCall=edit")
    public ModelAndView edit(@ModelAttribute("KualiForm") AgendaManagementForm theForm) throws Exception {

        Properties urlParameters = new Properties();
        Object selectedObject = _getSelectedObject(theForm, "edit");

        if (selectedObject instanceof CourseOfferingListSectionWrapper) {
            CourseOfferingListSectionWrapper coWrapper =  (CourseOfferingListSectionWrapper)selectedObject;
            CourseOfferingInfo courseOfferingInfo = getCourseOfferingService().getCourseOffering(coWrapper.getCourseOfferingId(), ContextUtils.createDefaultContextInfo());
            urlParameters = buildAgendaURLParameters(courseOfferingInfo, KRADConstants.Maintenance.METHOD_TO_CALL_EDIT);
            String controllerPath = KRMSConstants.WebPaths.RULE_STUDENT_EDITOR_PATH;
            return super.performRedirect(theForm,controllerPath, urlParameters);
        } else {
            throw new RuntimeException("Invalid type. Does not support for now");
        }
    }

    /*
     * Method used to view a CO or an AO
     */
    @RequestMapping(params = "methodToCall=view")
    public ModelAndView view(@ModelAttribute("KualiForm") AgendaManagementForm theForm, @SuppressWarnings("unused") BindingResult result,
                                      @SuppressWarnings("unused") HttpServletRequest request, @SuppressWarnings("unused") HttpServletResponse response) throws Exception {

        Properties urlParameters = new Properties();
        String controllerPath = "inquiry";
        Object selectedObject = _getSelectedObject(theForm, "view");

        if(selectedObject instanceof CourseOfferingInfo){
            urlParameters = buildAgendaURLParameters((CourseOfferingInfo) selectedObject, KRADConstants.START_METHOD);
        } else if(selectedObject instanceof ActivityOfferingWrapper) {
            ActivityOfferingWrapper aoWrapper = (ActivityOfferingWrapper)selectedObject;
            urlParameters.put(KRADConstants.DISPATCH_REQUEST_PARAMETER, KRADConstants.START_METHOD);
            urlParameters.put(ActivityOfferingConstants.ACTIVITYOFFERING_ID, aoWrapper.getAoInfo().getId());
            urlParameters.put(KRADConstants.DATA_OBJECT_CLASS_ATTRIBUTE, ActivityOfferingInfo.class.getName());
        } else {
            throw new RuntimeException("Invalid type. Does not support for now");
        }

        return super.performRedirect(theForm,controllerPath, urlParameters);
    }

    @RequestMapping(params = "methodToCall=createCourseOffering")
    public ModelAndView createCourseOffering(@ModelAttribute("KualiForm") AgendaManagementForm theForm, @SuppressWarnings("unused") BindingResult result,
                                             @SuppressWarnings("unused") HttpServletRequest request, @SuppressWarnings("unused") HttpServletResponse response) throws Exception {

        String termCode = theForm.getTermCode();

        Properties props = new Properties();
        props.put(KRADConstants.DISPATCH_REQUEST_PARAMETER, KRADConstants.START_METHOD);
        props.put("targetTermCode", termCode);
        props.put(KRADConstants.DATA_OBJECT_CLASS_ATTRIBUTE, "org.kuali.student.enrollment.class2.courseoffering.dto.CourseOfferingCreateWrapper");

         return super.performRedirect(theForm, "courseOffering", props);
    }

    /*
     * Method used to invoke the CO inquiry view from Manage Course Offering screen while search input is Course Offering
     * Code (04a screen)
     */
    @RequestMapping(params = "methodToCall=viewTheCO")
    public ModelAndView viewTheCO(@ModelAttribute("KualiForm") AgendaManagementForm theForm, @SuppressWarnings("unused") BindingResult result,
                                  @SuppressWarnings("unused") HttpServletRequest request, @SuppressWarnings("unused") HttpServletResponse response) throws Exception {

        CourseOfferingInfo theCourseOfferingInfo = theForm.getTheCourseOffering();
        Properties urlParameters = buildAgendaURLParameters(theCourseOfferingInfo, KRADConstants.START_METHOD);
        String controllerPath = "krmsRuleStudentEditor";
        return super.performRedirect(theForm, controllerPath, urlParameters);
    }

    private Properties buildAgendaURLParameters(CourseOfferingInfo courseOfferingInfo, String methodToCall){
        Properties props = new Properties();
        props.put(KRADConstants.DISPATCH_REQUEST_PARAMETER, methodToCall);
        props.put(KRADConstants.OVERRIDE_KEYS, "cluId");
        props.put("viewName", "AgendaWithRuleView");
        props.put("viewTypeName", "MAINTENANCE");
        props.put("cluId", "39b47c39-451a-4aff-9c87-47092e8627f0");
        props.put(KRADConstants.DATA_OBJECT_CLASS_ATTRIBUTE, RuleEditor.class.getName());
        props.put(UifConstants.UrlParams.SHOW_HOME, BooleanUtils.toStringTrueFalse(false));
        return props;
    }

    private Object _getSelectedObject(AgendaManagementForm theForm, String actionLink){
        String selectedCollectionPath = theForm.getActionParamaterValue(UifParameters.SELLECTED_COLLECTION_PATH);
        if (StringUtils.isBlank(selectedCollectionPath)) {
            throw new RuntimeException("Selected collection was not set for " + actionLink);
        }

        int selectedLineIndex = -1;
        String selectedLine = theForm.getActionParamaterValue(UifParameters.SELECTED_LINE_INDEX);
        if (StringUtils.isNotBlank(selectedLine)) {
            selectedLineIndex = Integer.parseInt(selectedLine);
        }

        if (selectedLineIndex == -1) {
            throw new RuntimeException("Selected line index was not set");
        }

        Collection<Object> collection = ObjectPropertyUtils.getPropertyValue(theForm, selectedCollectionPath);
        Object selectedObject;
        selectedObject = ((List<Object>) collection).get(selectedLineIndex);

        return selectedObject;
    }

    public AgendaManagementViewHelperService getViewHelperService(AgendaManagementForm theForm){

        if (viewHelperService == null) {
            if (theForm.getView().getViewHelperServiceClass() != null){
                viewHelperService = (AgendaManagementViewHelperService) theForm.getView().getViewHelperService();
            }else{
                viewHelperService= (AgendaManagementViewHelperService) theForm.getPostedView().getViewHelperService();
            }
        }

        return viewHelperService;
    }

    public TypeService getTypeService() {
        if(typeService == null) {
            typeService = CourseOfferingResourceLoader.loadTypeService();
        }
        return this.typeService;
    }

    public StateService getStateService() {
        if(stateService == null) {
            stateService = CourseOfferingResourceLoader.loadStateService();
        }
        return this.stateService;
    }

    public CourseOfferingService getCourseOfferingService() {
        return CourseOfferingResourceLoader.loadCourseOfferingService();
    }

    private boolean checkEditViewAuthz(AgendaManagementForm theForm){
        Person user = GlobalVariables.getUserSession().getPerson();
        return theForm.getView().getAuthorizer().canEditView(theForm.getView(),theForm,user);
    }

}