package org.kuali.student.myplan.plan;

import org.kuali.student.lum.lu.LUConstants;
import org.kuali.student.myplan.academicplan.service.AcademicPlanServiceConstants;
import org.kuali.student.r2.common.dto.ContextInfo;

public class PlanConstants extends AcademicPlanServiceConstants {

    public static final String PARAM_COURSE_ID = "courseId";
    public static final String PARAM_OFFERINGS_FLAG = "loadActivityOffering";

    public static final int PLANNED_PLAN_ITEM_CAPACITY = 8;
    public static final int BACKUP_PLAN_ITEM_CAPACITY = 8;
    public static final int MAX_FUTURE_YEARS = 6;

    public static final String PLAN_ITEM_RESPONSE_PAGE_ID = "plan_item_action_response_page";
    public static final String PLAN_PAGE_ID = "planned_courses_detail_page";
    public static final String ACTION_MENU_PAGE_ID = "add_planned_course";

    public static final String COURSE_TYPE = LUConstants.CLU_TYPE_CREDIT_COURSE;
    public static final String SECTION_TYPE = "kuali.lui.type.activity.offering";
    public static final String PLACE_HOLDER_TYPE_GEN_ED = "kuali.uw.lu.genedreq";
    public static final String PLACE_HOLDER_TYPE = "uw.academicplan.placeholder";
    public static final String PLACE_HOLDER_TYPE_COURSE_LEVEL = " uw.cluset.type.course.level";

    public static final String GEN_EDU_ENUM_KEY = "kuali.uw.lu.genedreq";
    public static final String PLACE_HOLDER_ENUM_KEY = "uw.academicplan.placeholder";
    public static final String PLACE_HOLDER_OTHER_CODE = "uw.academicplan.placeholder.other";

    public static final String CODE_KEY_SEPARATOR = "\\|";


    // CRUD operations positive feedback.
    public static final String SUCCESS_KEY = "myplan.text.success";
    public static final String SUCCESS_KEY_PLANNED_ITEM_ADDED = "myplan.text.success.plannedCourseList.itemAdded";
    public static final String SUCCESS_KEY_PLANNED_ITEM_MOVED = "myplan.text.success.plannedCourseList.itemMoved";
    public static final String SUCCESS_KEY_PLANNED_ITEM_COPIED = "myplan.text.success.plannedCourseList.itemCopied";
    public static final String SUCCESS_KEY_PLANNED_ITEM_MARKED_BACKUP = "myplan.text.success.plannedCourseList.itemMarkedAsBackup";
    public static final String SUCCESS_KEY_PLANNED_ITEM_MARKED_PLANNED = "myplan.text.success.plannedCourseList.itemMarkedAsPlanned";

    public static final String SUCCESS_KEY_ITEM_DELETED = "myplan.text.success.itemDeleted";

    public static final String SUCCESS_KEY_SAVED_ITEM_ADDED = "myplan.text.success.savedCourseList.itemAdded";


    public static final String SUCCESS_KEY_UPDATED_ITEM = "myplan.text.success.quickAdd.itemUpdated";


    //  CRUD error feedback
    public static final String ERROR_KEY_PLANNED_ITEM_ALREADY_EXISTS = "myplan.text.error.plannedCourseList.itemAlreadyExists";
    public static final String ERROR_KEY_PLANNED_ITEM_CAPACITY_EXCEEDED = "myplan.text.error.plannedCourseList.plannedCapacityExceeded";
    public static final String ERROR_KEY_BACKUP_ITEM_CAPACITY_EXCEEDED = "myplan.text.error.plannedCourseList.backupCapacityExceeded";

    public static final String ERROR_KEY_HISTORICAL_ATP = "myplan.text.error.plannedCourseList.historicalAtp";

    public static final String ERROR_KEY_PAGE_RESET_REQUIRED = "myplan.text.error.pageResetRequired";

    public static final String ERROR_KEY_ADVISER_ACCESS = "myplan.text.error.adviserAccess";
    public static final String ERROR_KEY_ILLEGAL_ADVISER_ACCESS = "myplan.text.error.illegalAdviserAccess";
    public static final String ERROR_KEY_OPERATION_FAILED = "myplan.text.error.operationFailed";
    public static final String ERROR_KEY_UNKNOWN_COURSE = "myplan.text.error.unknownCourse";
    public static final String ERROR_KEY_UNKNOWN_PLAN_ITEM = "myplan.text.error.savedCoursesList.unknownPlanItem";
    public static final String ERROR_KEY_DATA_VALIDATION_ERROR = "myplan.text.error.dataValidationError";
    public static final String ERROR_KEY_DUPLICATE_PLAN = "myplan.text.error.savedCoursesList.duplicatePlan";
    public static final String ERROR_KEY_DUPLICATE_PLAN_ITEM = "myplan.text.error.savedCoursesList.duplicatePlanItem";
    public static final String ERROR_KEY_INVALID_PARAM = "myplan.text.error.invalidParameter";
    public static final String ERROR_KEY_MISSING_PARAM = "myplan.text.error.missingParameter";
    public static final String ERROR_KEY_PERMISSION_DENIED = "myplan.text.error.permissionDenied";
    public static final String ERROR_TECHNICAL_PROBLEMS = "myplan.text.error.technicalProblems";
    public static final String ERROR_PLAN_AUDIT_QUARTER_EMPTY = "myplan.text.error.planAuditQuarterEmpty";
    public static final String ERROR_PLAN_AUDIT_INVALID_QUARTER = "myplan.text.error.planAuditInvalidQuarter";

    public static final String ERROR_KEY_NO_STUDENT_PROXY_ID = "myplan.text.error.adviser.noStudentId";
    public static final String WARNING_STUDENT_CONTEXT_SWITCH = "myplan.text.warning.adviser.studentSwitch";

    public static final String COURSE_NOT_FOUND = "myplan.text.error.quickAdd.courseNotFound";
    public static final String CREDIT_REQUIRED = "myplan.text.error.quickAdd.creditRequired";
    public static final String NOTE_REQUIRED = "myplan.text.error.quickAdd.noteRequired";
    public static final String UPDATE_FAILED = "myplan.text.error.quickAdd.updateFailed";
    public static final String EMPTY_SEARCH = "myplan.text.error.quickAdd.emptySearch";
    public static final String ACCESS_DENIED = "myplan.text.error.permissionDenied";

    //  Global context info for use in service methods which need caching, but don't use the context argument.
    public static final ContextInfo CONTEXT_INFO = new ContextInfo();

    public static final String TERM_ID_PREFIX = "kuali.uw.atp.";
    public static final String FOCUS_ATP_ID_KEY = "focusAtpId";

    //  {atp} will be replaced by an ATP ID and {label} will be replaced with the link text at runtime.
    public static final String QUARTER_LINK = "<a href=\"/student/myplan/plan?methodToCall=start&viewId=PlannedCourses-FormView&focusAtpId={atpId}\">{label}</a>";

    public static final String PLANNED_TYPE = "planned";
    public static final String BACKUP_TYPE = "backup";

    public static final String GENERAL_TYPE = "general";
    public static final String COURSE_PLACEHOLDER_REGEX = "^[1-9](?i)XX$";
    public static final String PLACE_HOLDER_CREDIT = "PlaceHolderCredit";

    public static final String PLAN = " plan";
    public static final String BACKUP = " backup";

    public static final String MOVE_DIALOG_PAGE = "move_dialog_page";
    public static final String COPY_DIALOG_PAGE = "copy_dialog_page";
    public static final String DELETE_DIALOG_PAGE = "plan_item_delete_page";
    public static final String QUICK_ADD_DIALOG_PAGE = "quick_add_page";
    public static final String ADD_DIALOG_PAGE = "plan_item_add_page";

    /*Term Names Autumn,Winter,Spring,Summer*/
    public static final String TERM_1 = "Winter";
    public static final String TERM_2 = "Spring";
    public static final String TERM_3 = "Summer";
    public static final String TERM_4 = "Autumn";

    public static final String ATP_TERM_1 = "1";
    public static final String ATP_TERM_2 = "2";
    public static final String ATP_TERM_3 = "3";
    public static final String ATP_TERM_4 = "4";

    public static final String ACTIVE_STATE = "active";
    public static final String WITHDRAWN_STATE = "withdrawn";
    public static final String SUSPENDED_STATE = "suspended";
    public static final String WITHDRAWN_ALERT = "Section %s has been withdrawn. ";
    public static final String SUSPENDED_ALERT = "Section %s has been suspended. ";
    public static final String COURSE_NOT_SCHEDULE_ALERT = "%s is not scheduled for %s. ";


    /*Query keys for getting the termInfos from the academic calender*/
    public static final String PLANNING = "PLANNING";
    public static final String INPROGRESS = "INPROGRESS";
    public static final String PUBLISHED = "PUBLISHED";

    public static final String WITHDRAWN_GRADE = "W";

    /*Course Credit Types*/
    public static final String RANGE = "-";
    public static final String MULTIPLE = ",";


    /* Keys for storing info in the session. */
    public static final String SESSION_KEY_IS_ADVISER = "kuali.uw.authz.adviser";
    public static final String SESSION_KEY_STUDENT_ID = "kuali.uw.authn.studentId";
    public static final String SESSION_KEY_STUDENT_NAME = "kuali.uw.authn.studentName";
    public static final String SESSION_KEY_STUDENT_NUMBER = "kuali.uw.authn.studentNumber";

    /**
     * Names of javascript events that can be scheduled in response to the outcome of a plan item request.
     */
    public static enum JS_EVENT_NAME {
        /* (atpId), type, courseId, courseCode, courseTitle, courseCredits */
        PLAN_ITEM_ADDED,
        /* (atpId), type, courseId, courseCode, courseTitle, courseCredits */
        PLAN_ITEM_UPDATED,
        /*(atpId), type, courseId, courseCode, courseTitle, sectionCode, primarySection, courseCredits*/
        SECTION_ITEM_ADDED,
        /* atpId, type, courseId */
        PLAN_ITEM_DELETED,
        /*atpId, courseId, sectionCode, primarySection, courseCredits*/
        SECTION_ITEM_DELETED,
        /* atpId, newTotalCredits */
        UPDATE_NEW_TERM_TOTAL_CREDITS,
        /*atpId, oldTotalCredits*/
        UPDATE_OLD_TERM_TOTAL_CREDITS
    }
}
