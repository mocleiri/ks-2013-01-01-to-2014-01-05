package org.kuali.student.ap.framework.context;

import org.kuali.student.myplan.academicplan.service.AcademicPlanServiceConstants;
import org.kuali.student.r2.lum.clu.CLUConstants;

public class PlanConstants extends AcademicPlanServiceConstants {

	public static final String PARAM_COURSE_ID = "courseId";

	public static final int PLANNED_PLAN_ITEM_CAPACITY = 8;
	public static final int BACKUP_PLAN_ITEM_CAPACITY = 8;
	public static final int MAX_FUTURE_YEARS = 6;

	public static final String PLAN_ITEM_RESPONSE_PAGE_ID = "plan_item_action_response_page";
	public static final String PLAN_PAGE_ID = "planned_courses_detail_page";

	public static final String COURSE_TYPE = CLUConstants.CLU_TYPE_CREDIT_COURSE;
	public static final String SECTION_TYPE = "kuali.lu.type.CourseSection";

	// CRUD operations positive feedback.
	public static final String SUCCESS_KEY = "myplan.text.success";
	public static final String SUCCESS_KEY_PLANNED_ITEM_ADDED = "myplan.text.success.plannedCourseList.itemAdded";
	public static final String SUCCESS_KEY_PLANNED_ITEM_MOVED = "myplan.text.success.plannedCourseList.itemMoved";
	public static final String SUCCESS_KEY_PLANNED_ITEM_COPIED = "myplan.text.success.plannedCourseList.itemCopied";
	public static final String SUCCESS_KEY_PLANNED_ITEM_MARKED_BACKUP = "myplan.text.success.plannedCourseList.itemMarkedAsBackup";
	public static final String SUCCESS_KEY_PLANNED_ITEM_MARKED_PLANNED = "myplan.text.success.plannedCourseList.itemMarkedAsPlanned";

	public static final String SUCCESS_KEY_ITEM_DELETED = "myplan.text.success.itemDeleted";

	public static final String SUCCESS_KEY_SAVED_ITEM_ADDED = "myplan.text.success.savedCourseList.itemAdded";

	// CRUD error feedback
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

	public static final String ERROR_KEY_NO_STUDENT_PROXY_ID = "myplan.text.error.adviser.noStudentId";
	public static final String WARNING_STUDENT_CONTEXT_SWITCH = "myplan.text.warning.adviser.studentSwitch";

	/* Keys for storing info in the session. */
	public static final String SESSION_KEY_IS_ADVISER = "kuali.ap.authz.adviser";
	public static final String SESSION_KEY_STUDENT_ID = "kuali.ap.authn.studentId";
	public static final String SESSION_KEY_STUDENT_NAME = "kuali.ap.authn.studentName";

	public static final String TERM_ID_PREFIX = "kuali.atp.";
	public static final String FOCUS_ATP_ID_KEY = "focusAtpId";

	public static final String PLANNED_TYPE = "planned";
	public static final String BACKUP_TYPE = "backup";

	/* Query keys for getting the termInfos from the academic calender */
	public static final String PLANNING = "PLANNING";
	public static final String INPROGRESS = "INPROGRESS";
	public static final String PUBLISHED = "PUBLISHED";

	public static final String WITHDRAWN_GRADE = "W";

	/* Course Credit Types */
	public static final String RANGE = "-";
	public static final String MULTIPLE = ",";

	/**
	 * Names of javascript events that can be scheduled in response to the
	 * outcome of a plan item request.
	 */
	public static enum JS_EVENT_NAME {
		/* (atpId), type, courseId, courseCode, courseTitle, courseCredits */
		PLAN_ITEM_ADDED,
		/*
		 * (atpId), type, courseId, courseCode, courseTitle, sectionCode,
		 * primarySection, courseCredits
		 */
		SECTION_ITEM_ADDED,
		/* atpId, type, courseId */
		PLAN_ITEM_DELETED,
		/* atpId, courseId, sectionCode, primarySection, courseCredits */
		SECTION_ITEM_DELETED,
		/* atpId, newTotalCredits */
		UPDATE_NEW_TERM_TOTAL_CREDITS,
		/* atpId, oldTotalCredits */
		UPDATE_OLD_TERM_TOTAL_CREDITS
	}
}
