package org.kuali.student.ap.framework.context.support;

import org.kuali.student.ap.framework.config.KsapFrameworkServiceLocator;
import org.kuali.student.ap.framework.context.CourseSearchConstants;
import org.kuali.student.ap.framework.context.EnrollmentStatusHelper;
import org.kuali.student.r2.core.search.dto.SearchRequestInfo;
import org.kuali.student.r2.core.search.dto.SearchResultInfo;
import org.kuali.student.r2.core.search.infc.SearchRequest;
import org.kuali.student.r2.core.search.infc.SearchResult;


import java.util.ArrayList;
import java.util.List;

public class DefaultEnrollmentStatusHelper implements EnrollmentStatusHelper {

    /**
     *
     * @param year
     * @param quarter
     * @param curric
     * @param num
     * @param sectionID
     * @return
     * @throws Exception
     */
    @Override
    public String[] populateEnrollmentFields(String year, String quarter, String curric, String num, String sectionID)
            throws Exception {

        String[] fields =  {"000","100","000"};

        return fields;
    }

    /**
     * Used to Split the course code into division and Code.
     * eg: "COM 243" is returned as CourseCode with division=COM and number=243 and section=null.
     * eg: "COM 243 A" is returned as CourseCode with division=COM , number=243 and section=A.
     *
     * @param courseCode
     * @return
     */
    @Override
    public CourseCode getCourseDivisionAndNumber(String courseCode) {
        String subject = null;
        String number = null;
        String section = null;
        if (courseCode.matches(CourseSearchConstants.FORMATTED_COURSE_CODE_REGEX)) {
            String[] splitStr = courseCode.toUpperCase().split(CourseSearchConstants.SPLIT_DIGITS_ALPHABETS);
            subject = splitStr[0].trim();
            number = splitStr[1].trim();
        } else if (courseCode.matches(CourseSearchConstants.COURSE_CODE_WITH_SECTION_REGEX)) {
            String[] splitStr = courseCode.toUpperCase().split(CourseSearchConstants.SPLIT_DIGITS_ALPHABETS);
            subject = splitStr[0].trim();
            number = splitStr[1].trim();
            section = splitStr[2].trim();
        } else if(courseCode.matches(CourseSearchConstants.UNFORMATTED_COURSE_CODE_REGEX)) {
            String[] splitStr = courseCode.toUpperCase().split(CourseSearchConstants.SPLIT_DIGITS_ALPHABETS);
            subject = splitStr[0].trim();
            number = splitStr[1].trim();
        }
        return new CourseCode(subject, number, section);
    }

    /**
     * Used to get the course Id for the given subject area and course number (CHEM, 120)
     *
     * @param subjectArea
     * @param number
     * @return
     */
    @Override
    public String getCourseId(String subjectArea, String number) {
        List<SearchRequest> requests = new ArrayList<SearchRequest>();
        SearchRequestInfo request = new SearchRequestInfo(CourseSearchConstants.COURSE_SEARCH_FOR_COURSE_ID);
        request.addParam(CourseSearchConstants.SEARCH_REQUEST_SUBJECT_PARAM, subjectArea);
        request.addParam(CourseSearchConstants.SEARCH_REQUEST_NUMBER_PARAM, number);
        request.addParam(CourseSearchConstants.SEARCH_REQUEST_LAST_SCHEDULED_PARAM, KsapFrameworkServiceLocator.getAtpHelper().getLastScheduledAtpId());
        requests.add(request);
        SearchResult searchResult = new SearchResultInfo();
        try {
            searchResult = KsapFrameworkServiceLocator.getCluService().search(request,KsapFrameworkServiceLocator.getContext().getContextInfo());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String courseId = null;
        if (searchResult.getRows().size() > 0) {
            courseId = searchResult.getRows().get(0).getCells().get(0).getValue();
        }
        return courseId;
    }

}
