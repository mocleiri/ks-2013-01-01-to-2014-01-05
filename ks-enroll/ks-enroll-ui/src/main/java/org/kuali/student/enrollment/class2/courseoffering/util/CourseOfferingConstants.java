package org.kuali.student.enrollment.class2.courseoffering.util;

/**
 * Created by IntelliJ IDEA.
 * User: huangb
 * Date: 5/10/12
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class CourseOfferingConstants {
    //Attributes defined in CourseOfferingInfo
    public final static String COURSEOFFERING_ID = "id";
    public final static String COURSEOFFERING_TERM_ID = "termId";
    public final static String COURSEOFFERING_SUBJECT_AREA = "subjectArea";
    public final static String COURSEOFFERING_COURSE_OFFERING_CODE = "courseOfferingCode";
    public final static String ATP_CODE = "atpCode";
    public final static String ATP_ID = "atpId";

    // display name for 'Course' option in Grade Roster Level
    public final static String FORMAT_OFFERING_GRADE_ROSTER_LEVEL_COURSE_DISPLAY = "Course";

    //Attributes defined in SocRolloverResultInfo
    public final static String SOCROLLOVERRESULTINFO_ID = "id";
    public final static String SOCROLLOVERRESULTINFO_SOURCE_TERM_ID = "sourceTermId";
    public final static String SOCROLLOVERRESULTINFO_TARGET_TERM_ID = "targetTermId";

    //Attributes defined in SocRolloverResultItemInfo

    //Message keys
    public static final String COURSEOFFERING_MSG_ERROR_NO_TERM_IS_FOUND = "error.enroll.courseoffering.noTermIsFound";
    public static final String COURSEOFFERING_MSG_ERROR_FOUND_MORE_THAN_ONE_TERM = "error.enroll.courseoffering.findMoreThanOneTerm";
    public static final String COURSEOFFERING_MSG_ERROR_NO_COURSE_OFFERING_IS_FOUND = "error.enroll.courseoffering.noCourseOfferingIsFound";
    public static final String COURSEOFFERING_MSG_ERROR_FOUND_MORE_THAN_ONE_COURSE_OFFERING = "error.enroll.courseoffering.findMoreThanOneCourseOffering";
    public static final String COURSEOFFERING_MSG_ERROR_FOUND_NO_DRAFT_AO_SELECTED = "error.courseoffering.no.selected.AO";
    public static final String AO_NOT_DRAFT_FOR_DELETION_ERROR = "error.courseoffering.selected.aos.notdraft";
    public static final String COURSEOFFERING_MSG_ERROR_SELECTED_AO_TO_DELETE = "error.courseoffering.selected.AO.delete.confirmation";
    public static final String COURSEOFFERING_MSG_ERROR_CO_CANNOT_DELETE="error.courseoffering.selected.CO.delete.confirmation";
    public static final String COURSEOFFERING_INVALID_STATE_FOR_SELECTED_ACTION_ERROR = "error.courseoffering.invalid.state";

    public static final String ACTIVITY_OFFERING_SCHEDULING_ACTION = "Scheduling";
    public static final String ACTIVITY_OFFERING_DRAFT_ACTION = "Draft";
    public static final String ACTIVITY_OFFERING_DELETE_ACTION = "Delete";

    public static final String MANAGE_AO_PAGE = "manageActivityOfferingsPage";

    // Display text
    public static final String COURSEOFFERING_TEXT_STD_REG_OPTS_EMPTY = "None available";

}
