/**
 * Copyright 2012 The Kuali Foundation Licensed under the
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
 *
 * Created by vgadiyak on 9/10/12
 */
package org.kuali.student.enrollment.class2.scheduleofclasses.service.impl;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.config.property.ConfigContext;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kim.api.identity.PersonService;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.rice.kim.impl.KIMPropertyConstants;
import org.kuali.rice.krad.uif.component.ReferenceCopy;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krms.api.KrmsConstants;
import org.kuali.rice.krms.api.repository.RuleManagementService;
import org.kuali.rice.krms.api.repository.reference.ReferenceObjectBinding;
import org.kuali.student.enrollment.class2.courseoffering.dto.ActivityOfferingClusterWrapper;
import org.kuali.student.enrollment.class2.courseoffering.dto.RegistrationGroupWrapper;
import org.kuali.student.enrollment.class2.courseoffering.service.decorators.PermissionServiceConstants;
import org.kuali.student.enrollment.class2.courseoffering.service.impl.CourseOfferingManagementViewHelperServiceImpl;
import org.kuali.student.enrollment.class2.courseoffering.util.CourseOfferingConstants;
import org.kuali.student.enrollment.class2.courseoffering.util.CourseOfferingResourceLoader;
import org.kuali.student.enrollment.class2.scheduleofclasses.dto.CourseOfferingDisplayWrapper;
import org.kuali.student.enrollment.class2.scheduleofclasses.form.ScheduleOfClassesSearchForm;
import org.kuali.student.enrollment.class2.scheduleofclasses.service.ScheduleOfClassesViewHelperService;
import org.kuali.student.enrollment.class2.scheduleofclasses.sort.KSComparator;
import org.kuali.student.enrollment.class2.scheduleofclasses.sort.KSComparatorChain;
import org.kuali.student.enrollment.class2.scheduleofclasses.sort.impl.ActivityOfferingCodeComparator;
import org.kuali.student.enrollment.class2.scheduleofclasses.sort.impl.ActivityOfferingTypeComparator;
import org.kuali.student.enrollment.class2.scheduleofclasses.util.ScheduleOfClassesConstants;
import org.kuali.student.enrollment.courseoffering.dto.CourseOfferingDisplayInfo;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingService;
import org.kuali.student.r2.common.constants.CommonServiceConstants;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.KeyNameInfo;
import org.kuali.student.r2.common.util.ContextUtils;
import org.kuali.student.r2.common.util.constants.CourseOfferingServiceConstants;
import org.kuali.student.r2.common.util.constants.LprServiceConstants;
import org.kuali.student.r2.common.util.constants.LuiServiceConstants;
import org.kuali.student.r2.common.util.date.DateFormatters;
import org.kuali.student.r2.core.acal.dto.TermInfo;
import org.kuali.student.r2.core.acal.service.AcademicCalendarService;
import org.kuali.student.r2.core.class1.type.service.TypeService;
import org.kuali.student.r2.core.constants.KSKRMSServiceConstants;
import org.kuali.student.r2.core.organization.service.OrganizationService;
import org.kuali.student.r2.core.scheduling.constants.SchedulingServiceConstants;
import org.kuali.student.r2.lum.util.constants.LrcServiceConstants;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * This class performs queries for scheduling of classes
 *
 * @author Kuali Student Team
 */
public class ScheduleOfClassesViewHelperServiceImpl extends CourseOfferingManagementViewHelperServiceImpl implements ScheduleOfClassesViewHelperService {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ScheduleOfClassesViewHelperServiceImpl.class);

    private OrganizationService organizationService;
    private AcademicCalendarService academicCalendarService;
    private TypeService typeService;
    private RuleManagementService ruleManagementService;
    @ReferenceCopy
    private KSComparatorChain activityComparatorChain;
    @ReferenceCopy
    private KSComparatorChain regGroupComparatorChain;

    public void loadCourseOfferingsByTermAndCourseCode(String termId, String courseCode, ScheduleOfClassesSearchForm form) throws Exception {

        ContextInfo contextInfo = ContextUtils.createDefaultContextInfo();

        // Building a query
        QueryByCriteria.Builder qbcBuilder = QueryByCriteria.Builder.create();
        qbcBuilder.setPredicates(PredicateFactory.and(
                PredicateFactory.like("courseOfferingCode", courseCode + "%"),
                PredicateFactory.equalIgnoreCase("atpId", termId)),
                PredicateFactory.equal("luiState", LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY));
        QueryByCriteria criteria = qbcBuilder.build();
        List<String> courseOfferingIds = getCourseOfferingService().searchForCourseOfferingIds(criteria, contextInfo);

        if (courseOfferingIds.size() > 0) {
            form.getCoDisplayWrapperList().clear();
            form.setCoDisplayWrapperList(getCourseOfferingDisplayWrappersByIds(courseOfferingIds, getCourseOfferingService(), getRuleManagementService(), contextInfo));
        } else {
            LOG.error("Error: Can't find any Course Offering for a Course Code: " + courseCode + " in term: " + termId);
            GlobalVariables.getMessageMap().putError("Term & courseCode", ScheduleOfClassesConstants.SOC_MSG_ERROR_NO_COURSE_OFFERING_IS_FOUND, "courseCode", courseCode, termId);
            form.getCoDisplayWrapperList().clear();
        }
    }

    @Override
    public void loadCourseOfferingsByTermAndInstructor(String termId, String instructorId, String instructorName, ScheduleOfClassesSearchForm form) throws Exception {

        ContextInfo contextInfo = ContextUtils.createDefaultContextInfo();

        // Search ID based on organizationName
        if (instructorId == null || instructorId.isEmpty()) {
            Map<String, String> searchCriteria = new HashMap<String, String>();
            searchCriteria.put(KIMPropertyConstants.Person.PRINCIPAL_NAME, instructorName);
            List<Person> instructors = getPersonService().findPeople(searchCriteria);
            //JIRA FIX : KSENROLL-8730 - Added NULL check
            int firstInstructor = 0;
            if (null==instructors || instructors.isEmpty()) {
                LOG.error("Error: Can't find any instructor for selected instructor in term: " + termId);
                GlobalVariables.getMessageMap().putError("Term & Instructor", ScheduleOfClassesConstants.SOC_MSG_ERROR_NO_COURSE_OFFERING_IS_FOUND, "instructor", instructorName, termId);
                form.getCoDisplayWrapperList().clear();
            } else if (instructors.size() > 1) {
                LOG.error("Error: There is more than one instructor with the same name in term: " + termId);
                GlobalVariables.getMessageMap().putError("Term & Instructor", ScheduleOfClassesConstants.SOC_MSG_ERROR_MULTIPLE_INSTRUCTOR_IS_FOUND, instructorName);
                instructorId = null;
                form.getCoDisplayWrapperList().clear();
            } else {
                instructorId = instructors.get(firstInstructor).getPrincipalId();
            }
        }

        if (instructorId != null) {
            //this is a cross service search between LPR and LUI, so it is inefficient (no join)
            //First get all the luiIds that the instructor is teaching
            //Only get active courses
            List<String> luiIds = getLprService().getLuiIdsByPersonAndTypeAndState(instructorId, LprServiceConstants.INSTRUCTOR_MAIN_TYPE_KEY, LprServiceConstants.ACTIVE_STATE_KEY, contextInfo);

            List<String> courseOfferingIds = null;

            if (luiIds != null && !luiIds.isEmpty()) {
                //Now find all the COs with Aos that are attached to that instructor.
                // Build a query
                QueryByCriteria.Builder qbcBuilder = QueryByCriteria.Builder.create();
                qbcBuilder.setPredicates(PredicateFactory.and(
                        PredicateFactory.in("aoid", luiIds.toArray()),
                        PredicateFactory.equalIgnoreCase("atpId", termId)),
                        PredicateFactory.equal("luiState", LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY));
                QueryByCriteria criteria = qbcBuilder.build();
                courseOfferingIds = getCourseOfferingService().searchForCourseOfferingIds(criteria, contextInfo);

                if (courseOfferingIds.size() > 0) {
                    form.getCoDisplayWrapperList().clear();
                    form.setCoDisplayWrapperList(getCourseOfferingDisplayWrappersByIds(courseOfferingIds, getCourseOfferingService(), getRuleManagementService(), contextInfo));
                }
            }

            //If nothing was found then error
            if (courseOfferingIds == null || courseOfferingIds.isEmpty()) {
                LOG.error("Error: Can't find any Course Offering for selected Instructor in term: " + termId);
                GlobalVariables.getMessageMap().putError("Term & Instructor", ScheduleOfClassesConstants.SOC_MSG_ERROR_NO_COURSE_OFFERING_IS_FOUND, "instructor", instructorId, termId);
                form.getCoDisplayWrapperList().clear();
            }
        }
    }

    public void loadCourseOfferingsByTermAndDepartment(String termId, String organizationId, String organizationName, ScheduleOfClassesSearchForm form) throws Exception {
        ContextInfo contextInfo = ContextUtils.createDefaultContextInfo();

        QueryByCriteria.Builder qbcBuilder = QueryByCriteria.Builder.create();

        // Search ID based on organizationName
        if (organizationId == null || organizationId.isEmpty()) {
            QueryByCriteria.Builder qBuilder = QueryByCriteria.Builder.create();
            qBuilder.setPredicates(PredicateFactory.equalIgnoreCase("longName", organizationName));
            QueryByCriteria query = qBuilder.build();
            OrganizationService organizationService = getOrganizationService();
            List<String> orgIDs = organizationService.searchForOrgIds(query, ContextUtils.createDefaultContextInfo());
            if (orgIDs.isEmpty()) {
                LOG.error("Error: Can't find any Department for selected Department in term: " + termId);
                GlobalVariables.getMessageMap().putError("Term & Department", ScheduleOfClassesConstants.SOC_MSG_ERROR_NO_COURSE_OFFERING_IS_FOUND, "department", organizationName, termId);
                form.getCoDisplayWrapperList().clear();
            } else if (orgIDs.size() > 1) {
                LOG.error("Error: There is more than one departments with the same long name in term: " + termId);
                GlobalVariables.getMessageMap().putError("Term & Department", ScheduleOfClassesConstants.SOC_MSG_ERROR_MULTIPLE_DEPARTMENT_IS_FOUND, organizationName);
                form.getCoDisplayWrapperList().clear();
            }
        } else {
            qbcBuilder.setPredicates(PredicateFactory.and(
                    PredicateFactory.equal("luiContentOwner", organizationId),
                    PredicateFactory.equal("atpId", termId),
                    PredicateFactory.equal("luiType", LuiServiceConstants.COURSE_OFFERING_TYPE_KEY),
                    PredicateFactory.equal("luiState", LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY)));
            QueryByCriteria criteria = qbcBuilder.build();
            List<String> courseOfferingIds = getCourseOfferingService().searchForCourseOfferingIds(criteria, contextInfo);

            if (courseOfferingIds.size() > 0) {
                form.getCoDisplayWrapperList().clear();
                form.setCoDisplayWrapperList(getCourseOfferingDisplayWrappersByIds(courseOfferingIds, getCourseOfferingService(), getRuleManagementService(), contextInfo));
            } else {            //If nothing was found then error
                LOG.error("Error: Can't find any Course Offering for selected Department in term: " + termId);
                GlobalVariables.getMessageMap().putError("Term & Department", ScheduleOfClassesConstants.SOC_MSG_ERROR_NO_COURSE_OFFERING_IS_FOUND, "department", organizationName, termId);
                form.getCoDisplayWrapperList().clear();
            }
        }
    }

    @Override
    public void loadCourseOfferingsByTitleAndDescription(String termId, String titleOrDescription, ScheduleOfClassesSearchForm form) throws Exception {
        ContextInfo contextInfo = ContextUtils.createDefaultContextInfo();

        QueryByCriteria.Builder qbcBuilder = QueryByCriteria.Builder.create();

        // Note: the longName is not in the luiEntity so we need to use the criteriaLookupService is used.
        // it is linked back to CourseOfferingCriteriaTransform and wired in the ks-enroll-context.xml
        qbcBuilder.setPredicates(PredicateFactory.and(
                PredicateFactory.equal("atpId", termId),
                PredicateFactory.equal("luiType", LuiServiceConstants.COURSE_OFFERING_TYPE_KEY),
                PredicateFactory.equal("luiState", LuiServiceConstants.LUI_CO_STATE_OFFERED_KEY),
                PredicateFactory.and(
                        PredicateFactory.or(
                                PredicateFactory.like("plain", "%" + titleOrDescription + "%"), // this is for the description
                                PredicateFactory.like("longName", titleOrDescription + "%")     // this is for the title
                        )
                )

        ));
        QueryByCriteria criteria = qbcBuilder.build();
        List<String> courseOfferingIds = getCourseOfferingService().searchForCourseOfferingIds(criteria, contextInfo);

        if (courseOfferingIds.size() > 0) {
            form.getCoDisplayWrapperList().clear();
            form.setCoDisplayWrapperList(getCourseOfferingDisplayWrappersByIds(courseOfferingIds, getCourseOfferingService(), getRuleManagementService(), contextInfo));
        } else {    //If nothing was found then error
            LOG.error("Error: Can't find any Course Offering for selected Department in term: " + termId);
            GlobalVariables.getMessageMap().putError("Title & Description", ScheduleOfClassesConstants.SOC_MSG_ERROR_NO_COURSE_OFFERING_IS_FOUND, "title or description", titleOrDescription, termId);
            form.getCoDisplayWrapperList().clear();
        }

    }

    protected static List<CourseOfferingDisplayWrapper> getCourseOfferingDisplayWrappersByIds(List<String> courseOfferingIds, CourseOfferingService courseOfferingService, RuleManagementService ruleManagementService, ContextInfo contextInfo) throws Exception {
        List<CourseOfferingDisplayWrapper> coDisplayWrapperList = new ArrayList<CourseOfferingDisplayWrapper>();

        if (courseOfferingIds.size() > 0) {

            String catalogUsageId = ruleManagementService.getNaturalLanguageUsageByNameAndNamespace(KSKRMSServiceConstants.KRMS_NL_TYPE_CATALOG, PermissionServiceConstants.KS_SYS_NAMESPACE).getId();

            List<CourseOfferingDisplayInfo> coDisplayInfoList = courseOfferingService.getCourseOfferingDisplaysByIds(courseOfferingIds, contextInfo);

            for (CourseOfferingDisplayInfo coDisplayInfo : coDisplayInfoList) {
                CourseOfferingDisplayWrapper coDisplayWrapper = new CourseOfferingDisplayWrapper();
                coDisplayWrapper.setCoDisplayInfo(coDisplayInfo);

                coDisplayWrapper.setRequisites(retrieveRequisites(coDisplayInfo.getId(), ruleManagementService, catalogUsageId));

                // Adding Information (icons)
                String information = "";
                if (coDisplayInfo.getIsHonorsOffering() != null && coDisplayInfo.getIsHonorsOffering()) {
                    information = "<img src=" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_HONORS_COURSE_IMG + " title=\"" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_HELP_HONORS_COURSE + "\"> ";
                }
                if (coDisplayInfo.getGradingOption() != null && coDisplayInfo.getGradingOption().getKey() != null
                        && coDisplayInfo.getGradingOption().getKey().equals(LrcServiceConstants.RESULT_GROUP_KEY_GRADE_SATISFACTORY)) {
                    information = information + "<img src=" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_GRADING_SATISFACTORY_IMG + " title=\"" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_HELP_GRADING_SATISFACTORY + "\"> ";
                } else if (coDisplayInfo.getGradingOption() != null && coDisplayInfo.getGradingOption().getKey() != null
                        && coDisplayInfo.getGradingOption().getKey().equals(LrcServiceConstants.RESULT_GROUP_KEY_GRADE_PERCENTAGE)) {
                    information = information + "<img src=" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_GRADING_PERCENT_IMG + " title=\"" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_HELP_GRADING_PERCENT + "\"> ";
                }
                if (!coDisplayInfo.getStudentRegistrationGradingOptions().isEmpty()) {
                    for (KeyNameInfo stuRegOption : coDisplayInfo.getStudentRegistrationGradingOptions()) {
                        if (stuRegOption.getKey().equals(LrcServiceConstants.RESULT_GROUP_KEY_GRADE_PASSFAIL)) {
                            information = information + "<img src=" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_STUREG_PASSFAIL_IMG + " title=\"" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_HELP_STUREG_PASSFAIL + "\">";
                        } else if (stuRegOption.getKey().equals(LrcServiceConstants.RESULT_GROUP_KEY_GRADE_AUDIT)) {
                            //FindBugs - it is fine as is
                            information = information + "<img src=" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_STUREG_AUDIT_IMG + " title=\"" + ScheduleOfClassesConstants.SOC_RESULT_PAGE_HELP_STUREG_AUDIT + "\">";
                        }
                    }
                }
                coDisplayWrapper.setInformation(information);

                coDisplayWrapperList.add(coDisplayWrapper);
            }

        }

        return coDisplayWrapperList;
    }

    public String getRequisitiesForCourseOffering(String coId){
        String catalogUsageId = ruleManagementService.getNaturalLanguageUsageByNameAndNamespace(KSKRMSServiceConstants.KRMS_NL_TYPE_CATALOG, PermissionServiceConstants.KS_SYS_NAMESPACE).getId();
        return retrieveRequisites(coId, ruleManagementService, catalogUsageId);
    }

    /**
     * Method to build the course offering requisites string for display
     *
     * @param courseOfferingId
     * @param ruleManagementService
     * @return Map of course offering requisites
     */
    protected static String retrieveRequisites(String courseOfferingId, RuleManagementService ruleManagementService, String usageId) {

        //Retrieve reference object bindings for course offering
        List<ReferenceObjectBinding> refObjectsBindings = ruleManagementService.findReferenceObjectBindingsByReferenceObject(CourseOfferingServiceConstants.REF_OBJECT_URI_COURSE_OFFERING, courseOfferingId);

        //Retrieve agenda's for course offering
        StringBuilder requisites = new StringBuilder();
        for (ReferenceObjectBinding referenceObjectBinding : refObjectsBindings) {
            requisites.append(ruleManagementService.translateNaturalLanguageForObject(usageId, "agenda", referenceObjectBinding.getKrmsObjectId(), "en"));
        }

        return requisites.toString();
    }

    private String millisToTime(Long milliseconds) {
        if (milliseconds == null) {
            return null;
        }
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(milliseconds);
        return DateFormatters.HOUR_MINUTE_AM_PM_TIME_FORMATTER.format(cal.getTime());

    }

    private OrganizationService getOrganizationService() {
        if (organizationService == null) {
            organizationService = (OrganizationService) GlobalResourceLoader.getService(new QName(CommonServiceConstants.REF_OBJECT_URI_GLOBAL_PREFIX + "organization", "OrganizationService"));
        }
        return organizationService;
    }

    public PersonService getPersonService() {
        return KimApiServiceLocator.getPersonService();
    }

    private AcademicCalendarService getAcademicCalendarService() {
        if (academicCalendarService == null) {
            academicCalendarService = CourseOfferingResourceLoader.loadAcademicCalendarService();
        }

        return academicCalendarService;
    }

    public TypeService getTypeService() {
        if (typeService == null) {
            typeService = CourseOfferingResourceLoader.loadTypeService();
        }
        return this.typeService;
    }

    public RuleManagementService getRuleManagementService() {
        if (ruleManagementService == null) {
            ruleManagementService = (RuleManagementService) GlobalResourceLoader.getService(new QName(KrmsConstants.Namespaces.KRMS_NAMESPACE_2_0, "ruleManagementService"));
        }
        return ruleManagementService;
    }

    private String convertIntoDaysDisplay(int day) {
        String dayOfWeek;
        switch (day) {
            case 1:
                dayOfWeek = SchedulingServiceConstants.SUNDAY_TIMESLOT_DISPLAY_DAY_CODE;
                break;
            case 2:
                dayOfWeek = SchedulingServiceConstants.MONDAY_TIMESLOT_DISPLAY_DAY_CODE;
                break;
            case 3:
                dayOfWeek = SchedulingServiceConstants.TUESDAY_TIMESLOT_DISPLAY_DAY_CODE;
                break;
            case 4:
                dayOfWeek = SchedulingServiceConstants.WEDNESDAY_TIMESLOT_DISPLAY_DAY_CODE;
                break;
            case 5:
                dayOfWeek = SchedulingServiceConstants.THURSDAY_TIMESLOT_DISPLAY_DAY_CODE;
                break;
            case 6:
                dayOfWeek = SchedulingServiceConstants.FRIDAY_TIMESLOT_DISPLAY_DAY_CODE;
                break;
            case 7:
                dayOfWeek = SchedulingServiceConstants.SATURDAY_TIMESLOT_DISPLAY_DAY_CODE;
                break;
            default:
                dayOfWeek = StringUtils.EMPTY;
        }
        // TODO implement TBA when service stores it.
        return dayOfWeek;
    }

    private String getDays(List<Integer> intList) {

        StringBuilder sb = new StringBuilder();
        if (intList == null) {
            return sb.toString();
        }

        for (Integer d : intList) {
            sb.append(convertIntoDaysDisplay(d));
        }

        return sb.toString();
    }

    public String getTermStartEndDate(TermInfo term) {
        // Return Term as String display like 'FALL 2020 (9/26/2020-12/26/2020)'
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder, Locale.US);
        String displayString = "";
        if (term != null) {
            String startDate = DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.format(term.getStartDate());
            String endDate = DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.format(term.getEndDate());
            formatter.format("%s - %s", startDate, endDate);
            displayString = stringBuilder.toString();
        }
        return displayString;
    }

    /**
     * Comparators to be executed on the AOs
     *
     * @param activityComparatorChain
     */
    public void setActivityComparatorChain(KSComparatorChain activityComparatorChain) {
        this.activityComparatorChain = activityComparatorChain;
    }

    /**
     * Returns the Comparator chain associated with the Acivity sorting
     *
     * @return activityComparatorChain
     */
    public KSComparatorChain getActivityComparatorChain() {
        return activityComparatorChain;
    }

    /**
     * Sorts regGroups by the comparators in the chain.
     *
     * @param regGroupWrappers
     */
    public void sortRegGroups(List<RegistrationGroupWrapper> regGroupWrappers){
        if (regGroupComparatorChain != null){
            regGroupComparatorChain.sort(regGroupWrappers);
        }
    }

    /**
     * Comparators to be executed on the AOs
     *
     * @param regGroupComparatorChain
     */
    public void setRegGroupComparatorChain(KSComparatorChain regGroupComparatorChain) {
        this.regGroupComparatorChain = regGroupComparatorChain;
    }

    /**
     * Sorts AOs by the comparators in the chain.
     *
     * @param form
     * @param coWrapper
     */
    public void sortActivityOfferings(ScheduleOfClassesSearchForm form,CourseOfferingDisplayWrapper coWrapper){
        if (form.getAoDisplayFormat() == ScheduleOfClassesSearchForm.AoDisplayFormat.FLAT){
           KSComparatorChain defaultComparator = new KSComparatorChain();
           List<KSComparator> comparators = new ArrayList<KSComparator>(2);
           comparators.add(new ActivityOfferingTypeComparator());
           comparators.add(new ActivityOfferingCodeComparator());
           defaultComparator.setComparators(comparators);
           defaultComparator.sort(coWrapper.getActivityWrapperList());
        } else if (form.getAoDisplayFormat() == ScheduleOfClassesSearchForm.AoDisplayFormat.CLUSTER){
           /**
            * Sort the AOs first by the type and then by institutionally configured list of comparators
            */
           for (ActivityOfferingClusterWrapper clusterWrapper : form.getClusterResultList()){
               if(clusterWrapper.getAoWrapperList().size() >1){
                   //Add the type sorting as first.
                   getActivityComparatorChain().addComparator(0,new ActivityOfferingTypeComparator());
                   activityComparatorChain.sort(clusterWrapper.getAoWrapperList());
               }
           }
        }
    }


    /**
     * This method returns the institutionally configured AO states to filter at the ui. If it's not
     * configured, by default, it returns offerred state.
     *
     * @return
     */
    public List<String> getAOStateFilter(){

        String allowedAOStates = ConfigContext.getCurrentContextConfig().getProperty(CourseOfferingConstants.CONFIG_PARAM_KEY_SCHOC_AO_STATES);
        List<String> aoStates;

        if ((allowedAOStates != null) && (!allowedAOStates.isEmpty())) {

            aoStates = Arrays.asList(allowedAOStates.split("\\s*,\\s*"));

            if (!Arrays.asList(LuiServiceConstants.ACTIVITY_OFFERING_LIFECYCLE_STATE_KEYS).containsAll(aoStates)) {
                String errorMessage = String.format("Error: invalid value for configuration parameter:  %s Value: %s",
                        CourseOfferingConstants.CONFIG_PARAM_KEY_SCHOC_AO_STATES, aoStates.toString());
                throw new RuntimeException(errorMessage);
            }

        } else {
            // If an institution does not customize valid AO states, then the default is AO Offered state
            aoStates = new ArrayList<String>();
            aoStates.add(LuiServiceConstants.LUI_AO_STATE_OFFERED_KEY);
        }

        return aoStates;
    }


    /**
     * This method returns the institutionally configured reg group states to filter at the ui. If it's not
     * configured, by default, it returns offerred, invalid and offered-invalid states.
     *
     * @return
     */
    public List<String> getRegGroupStateFilter(){

        String allowedRegGroupStates = ConfigContext.getCurrentContextConfig().getProperty(CourseOfferingConstants.CONFIG_PARAM_KEY_SCHOC_REG_GROUP_STATES);
        List<String> regGroupStates;

        if ((allowedRegGroupStates != null) && (!allowedRegGroupStates.isEmpty())) {
            regGroupStates = Arrays.asList(allowedRegGroupStates.split("\\s*,\\s*"));
            if (!Arrays.asList(LuiServiceConstants.REGISTRATION_GROUP_LIFECYCLE_KEY_STATES).containsAll(regGroupStates)) {
                String errorMessage = String.format("Error: invalid value for configuration parameter:  %s Value: %s",
                        CourseOfferingConstants.CONFIG_PARAM_KEY_SCHOC_REG_GROUP_STATES, regGroupStates.toString());
                throw new RuntimeException(errorMessage);
            }
        } else {
            /*
            If an institution does not customize valid RegGroup states, then the default is RegGroup Offered+Invalid+Offered-invalid state.
            Offered-invalid not yet available. So, we ignored for now but eventually that will be added.
             */
            regGroupStates = new ArrayList<String>(2);
            regGroupStates.add(LuiServiceConstants.REGISTRATION_GROUP_OFFERED_STATE_KEY);
            regGroupStates.add(LuiServiceConstants.REGISTRATION_GROUP_INVALID_STATE_KEY);
        }

        return regGroupStates;
    }
}