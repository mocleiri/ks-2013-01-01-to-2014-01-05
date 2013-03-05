package org.kuali.student.ap.framework.context;

import org.kuali.student.r2.common.dto.ContextInfo;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: Kamal
 * Date: 11/4/11
 * Time: 10:22 AM
 */
public class CourseSearchConstants {

    public static final String COURSE_SEARCH_PAGE = "course_search";

    public static final String COURSE_SEARCH_RESULT_PAGE = "course_search_result";

    //public static final String COURSE_SEARCH_EMPTY_RESULT_PAGE = "course_search_no_results";

    public static final String GEN_EDU_REQUIREMENTS_PREFIX = "course.genEdRequirement.";

    // Service Constants
    public static final String STATEMENT_SERVICE_NAMESPACE = "http://student.kuali.org/wsdl/statement";
    public static final String ENUM_SERVICE_NAMESPACE = "http://student.kuali.org/wsdl/enumerationmanagement";
    public static final String ORG_SERVICE_NAMESPACE = "http://student.kuali.org/wsdl/organization";

    //  Global context info for use in service methods which need caching, but don't use the context argument.
    @Deprecated
    public static final ContextInfo CONTEXT_INFO = new ContextInfo();
    //  Process key for use in service methods which need caching, but don't use the process key argument.
    public static final String PROCESS_KEY = "Null";

    public static final Pattern TERM_PATTERN = Pattern.compile("([a-zA-Z]+)[\\s]+[0-9][0-9]([0-9][0-9])");

    public static final Pattern ATP_REGEX = Pattern.compile("([0-9]{4})([1-4])");
    public static final String ATP_FORMAT = "%d%d";

    public static List<String> TERM_ID_LIST = Arrays.asList("winter", "spring", "summer i","summer ii",  "autumn");
    public static List<String> TERM_LABELS_LIST = Arrays.asList("Winter", "Spring", "Summer1","Summer2", "Fall");

    public static final String SUBJECT_AREA = "kuali.lu.subjectArea";

    public static final String CAMPUS_LOCATION = "kuali.org.College";

    public static final String SUBJECT_CODE = "kuali.org.SubjectCode";

    public static final String TIME_SCHEDULE_KEY = "TimeScheduleLinkAbbreviation";

    public static final String COURSE_OFFERING_INSTITUTE = "kuali.course.offering.institute";

    public static final String DEGREE_CREDIT_ID_SUFFIX = "kuali.creditType.credit.degree.";

    public static final String ORG_QUERY_SEARCH_BY_TYPE_REQUEST = "org.search.orgInfoByType";

    public static final String ORG_QUERY_SEARCH_SUBJECT_AREAS = "org.search.orgCurriculum";

    public static final String ORG_TYPE_PARAM = "org_queryParam_orgType";
    
    public static final String IS_ACADEMIC_CALENDER_SERVICE_UP = "isAcademicCalenderServiceRunning";

    public static final String IS_COURSE_OFFERING_SERVICE_UP = "isCourseOfferingServiceRunning";

    public static final String IS_ACADEMIC_RECORD_SERVICE_UP = "isAcademicRecordServiceRunning";
}
