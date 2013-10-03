package org.kuali.student.myplan.course.controller;

import edu.uw.kuali.student.myplan.util.CourseHelperImpl;
import org.apache.log4j.Logger;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.student.common.search.dto.SearchRequest;
import org.kuali.student.core.organization.dto.OrgInfo;
import org.kuali.student.lum.lu.service.LuService;
import org.kuali.student.lum.lu.service.LuServiceConstants;
import org.kuali.student.myplan.course.form.CourseSearchForm;
import org.kuali.student.myplan.course.util.CourseHelper;
import org.kuali.student.myplan.course.util.CourseSearchConstants;
import org.kuali.student.myplan.plan.util.AtpHelper;
import org.kuali.student.myplan.plan.util.OrgHelper;
import org.kuali.student.r2.core.organization.dto.OrgInfo;
import org.kuali.student.r2.core.search.dto.SearchRequestInfo;
import org.kuali.student.r2.lum.clu.service.CluService;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseSearchStrategy {
    private final Logger logger = Logger.getLogger(CourseSearchStrategy.class);

    private transient CluService luService;
    /*Remove the HashMap after enumeration service is in the ehcache and remove the hashmap occurance in this*/
    private HashMap<String, List<OrgInfo>> orgTypeCache;
    private HashMap<String, Map<String, String>> hashMap;

    private CourseHelper courseHelper;

    public HashMap<String, List<OrgInfo>> getOrgTypeCache() {
        if (this.orgTypeCache == null) {
            this.orgTypeCache = new HashMap<String, List<OrgInfo>>();
        }
        return this.orgTypeCache;
    }

    public void setOrgTypeCache(HashMap<String, List<OrgInfo>> orgTypeCache) {
        this.orgTypeCache = orgTypeCache;
    }

    public HashMap<String, Map<String, String>> getHashMap() {
        if (this.hashMap == null) {
            this.hashMap = new HashMap<String, Map<String, String>>();
        }
        return this.hashMap;
    }

    public void setHashMap(HashMap<String, Map<String, String>> hashMap) {
        this.hashMap = hashMap;
    }


    // TODO: Fetch these from the enumeration service, ala CourseDetailsInquiryHelperImpl.initializeCampusLocations
    public final static String NO_CAMPUS = "-1";


    public void addCampusParams(ArrayList<SearchRequest> requests, CourseSearchForm form) {
        List<String> str = form.getCampusSelect();
        String[] results = null;
        if (str != null) {
            results = str.toArray(new String[str.size()]);
        }

        List<OrgInfo> campusLocations = new ArrayList<OrgInfo>();
        if (!this.getOrgTypeCache().containsKey(CourseSearchConstants.CAMPUS_LOCATION_ORG_TYPE)) {
            campusLocations = OrgHelper.getOrgInfo(CourseSearchConstants.CAMPUS_LOCATION_ORG_TYPE, CourseSearchConstants.ORG_QUERY_SEARCH_BY_TYPE_REQUEST, CourseSearchConstants.ORG_TYPE_PARAM);
            this.getOrgTypeCache().put(CourseSearchConstants.CAMPUS_LOCATION_ORG_TYPE, campusLocations);
        } else {
            campusLocations = getOrgTypeCache().get(CourseSearchConstants.CAMPUS_LOCATION_ORG_TYPE);
        }

        String[] campus = new String[campusLocations.size()];
        for (int k = 0; k < campus.length; k++) {
            campus[k] = NO_CAMPUS;
        }
        if (results != null) {
            for (int i = 0; i < results.length; i++) {
                for (OrgInfo entry : campusLocations) {
                    if (results[i].equalsIgnoreCase(entry.getId())) {
                        campus[i] = results[i];
                        break;
                    }
                }
            }
        }
        //  Add the individual term items.
        for (SearchRequest request : requests) {
            for (int j = 0; j < campus.length; j++) {
                int count = j + 1;
                String campusKey = "campus" + count;
                request.addParam(campusKey, campus[j]);
            }
        }

    }


    public void addCampusParam(SearchRequest request, CourseSearchForm form) {
        List<String> str = form.getCampusSelect();
        String[] results = null;
        if (str != null) {
            results = str.toArray(new String[str.size()]);
        }
        List<OrgInfo> campusLocations = new ArrayList<OrgInfo>();
        if (!this.getOrgTypeCache().containsKey(CourseSearchConstants.CAMPUS_LOCATION_ORG_TYPE)) {
            campusLocations = OrgHelper.getOrgInfo(CourseSearchConstants.CAMPUS_LOCATION_ORG_TYPE, CourseSearchConstants.ORG_QUERY_SEARCH_BY_TYPE_REQUEST, CourseSearchConstants.ORG_TYPE_PARAM);
            this.getOrgTypeCache().put(CourseSearchConstants.CAMPUS_LOCATION_ORG_TYPE, campusLocations);
        } else {
            campusLocations = getOrgTypeCache().get(CourseSearchConstants.CAMPUS_LOCATION_ORG_TYPE);
        }

        String[] campus = new String[campusLocations.size()];
        for (int k = 0; k < campus.length; k++) {
            campus[k] = NO_CAMPUS;
        }
        if (results != null) {
            for (int i = 0; i < results.length; i++) {
                for (OrgInfo entry : campusLocations) {
                    if (results[i].equalsIgnoreCase(entry.getId())) {
                        campus[i] = results[i];
                        break;
                    }
                }
            }
        }
        for (int j = 0; j < campus.length; j++) {
            int count = j + 1;
            String campusKey = "campus" + count;
            request.addParam(campusKey, campus[j]);
        }

    }

    public void addDivisionSearches(List<String> divisions, List<String> codes, List<String> levels, List<SearchRequest> requests) {
        for (String division : divisions) {
            boolean needDivisionQuery = true;

            for (String code : codes) {
                needDivisionQuery = false;
                SearchRequest request = new SearchRequest("myplan.lu.search.divisionAndCode");
                request.addParam("division", division);
                request.addParam("code", code);
                requests.add(request);
            }

            for (String level : levels) {
                needDivisionQuery = false;

                // Converts "1XX" to "100"
                level = level.substring(0, 1) + "00";

                SearchRequest request = new SearchRequest("myplan.lu.search.divisionAndLevel");
                request.addParam("division", division);
                request.addParam("level", level);
                requests.add(request);
            }

            if (needDivisionQuery) {
                SearchRequest request = new SearchRequest("myplan.lu.search.division");
                request.addParam("division", division);
                requests.add(request);
            }
        }
    }

    public void addFullTextSearches(String query, List<SearchRequestInfo> requests) {
        List<QueryTokenizer.Token> tokens = QueryTokenizer.tokenize(query);

        for (QueryTokenizer.Token token : tokens) {
            String queryText = null;
            switch (token.rule) {
                case WORD:
                    queryText = token.value;
                    break;
                case QUOTED:
                    queryText = token.value;
                    queryText = queryText.substring(1, queryText.length() - 1);
                    break;
                default:
                    break;
            }
            SearchRequestInfo request = new SearchRequestInfo("myplan.lu.search.fulltext");
            request.addParam("queryText", queryText);
            requests.add(request);
        }
    }

    public List<SearchRequestInfo> queryToRequests(CourseSearchForm form)
            throws Exception {
        logger.info("Start Of Method queryToRequests in CourseSearchStrategy:" + System.currentTimeMillis());
        String query = form.getSearchQuery().toUpperCase();
        List<String> fullTextQueries = new ArrayList<String>();
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(query);
        while (m.find()) {
            fullTextQueries.add(m.group(1));
            query = query.replace("\"" + m.group(1) + "\"", "");
        }
        List<String> levels = QueryTokenizer.extractCourseLevels(query);
        for (String level : levels) {
            query = query.replace(level, "");
        }
        List<String> codes = QueryTokenizer.extractCourseCodes(query);
        for (String code : codes) {
            query = query.replace(code, "");
        }

        HashMap<String, String> divisionMap = getCourseHelper().fetchCourseDivisions();

        ArrayList<String> divisions = new ArrayList<String>();
        query = getCourseHelper().extractDivisions(divisionMap, query, divisions, false);


        ArrayList<SearchRequest> requests = new ArrayList<SearchRequest>();
        // Order is important, more exact search results appear at top of list
        addDivisionSearches(divisions, codes, levels, requests);
        for (String text : fullTextQueries) {
            SearchRequest request = new SearchRequest("myplan.lu.search.fulltext");
            request.addParam("queryText", text);
            requests.add(request);
        }
        addFullTextSearches(query, requests);
        addCampusParams(requests, form);
        ArrayList processedRequests = processRequests(requests, form);
        addVersionDateParam(processedRequests);
        return processedRequests;
    }

    /**
     * @param requests
     * @param form
     */
    //To process the Request with search key as division or full Text
    public ArrayList<SearchRequest> processRequests(ArrayList<SearchRequest> requests, CourseSearchForm form) {
        Map<String, String> subjects = null;
        int size = requests.size();

        for (int i = 0; i < size; i++) {
            if (requests.get(i).getSearchKey() != null) {
                if (requests.get(i).getSearchKey().equalsIgnoreCase("myplan.lu.search.division")) {
                    String queryText = (String) requests.get(i).getParams().get(0).getValue();
                    String key = (String) requests.get(i).getParams().get(0).getValue();
                    if (form.getSearchQuery().length() <= 2) {
                        break;
                    } else {
                        SearchRequest request0 = new SearchRequest("myplan.lu.search.title");
                        request0.addParam("queryText", queryText.trim());
                        addCampusParam(request0, form);
                        requests.add(request0);
                        if (!this.getHashMap().containsKey(CourseSearchConstants.SUBJECT_AREA)) {
                            subjects = OrgHelper.getSubjectAreas();
                            getHashMap().put(CourseSearchConstants.SUBJECT_AREA, subjects);

                        } else {
                            subjects = getHashMap().get(CourseSearchConstants.SUBJECT_AREA);
                        }
                        StringBuffer additionalDivisions = new StringBuffer();
                        if (subjects != null && subjects.size() > 0) {
                            //  Add the individual term items.
                            for (Map.Entry<String, String> entry : subjects.entrySet()) {
                                if (entry.getKey().trim().contains(key.trim())) {
                                    if (!entry.getKey().equalsIgnoreCase(queryText)) {
                                        additionalDivisions.append(entry.getKey() + ",");
                                    }
                                }
                            }
                        }
                        if (additionalDivisions.length() > 0) {
                            String div = additionalDivisions.substring(0, additionalDivisions.length() - 1);
                            SearchRequest request1 = new SearchRequest("myplan.lu.search.additionalDivision");
                            request1.addParam("divisions", div.trim());
                            addCampusParam(request1, form);
                            requests.add(request1);
                        }
                        SearchRequest request2 = new SearchRequest("myplan.lu.search.description");
                        request2.addParam("queryText", queryText.trim());
                        addCampusParam(request2, form);
                        requests.add(request2);

                    }

                }
                if (requests.get(i).getSearchKey().equalsIgnoreCase("myplan.lu.search.fulltext")) {
                    String key = (String) requests.get(i).getParams().get(0).getValue();
                    List<String> divisions = new ArrayList<String>();
                    if (key.length() <= 2) {
                        requests.get(i).getParams().get(0).setValue("null");
                        break;
                    } else {
                        if (key.length() > 2) {

                            if (!this.getHashMap().containsKey(CourseSearchConstants.SUBJECT_AREA)) {
                                subjects = OrgHelper.getSubjectAreas();
                                getHashMap().put(CourseSearchConstants.SUBJECT_AREA, subjects);

                            } else {
                                subjects = getHashMap().get(CourseSearchConstants.SUBJECT_AREA);
                            }

                            if (subjects != null && subjects.size() > 0) {
                                //  Look to see if the query text is present in any subject area descriptions
                                String divKey = key.trim().toUpperCase();
                                for (Map.Entry<String, String> entry : subjects.entrySet()) {
                                    if (entry.getValue().contains(divKey)) {
                                        divisions.add(entry.getKey());
                                    }
                                }
                            }
                            if (divisions.size() > 0) {
                                // Re-purpose the request for the first division
                                requests.get(i).setSearchKey("myplan.lu.search.division");
                                requests.get(i).getParams().get(0).setKey("division");
                                requests.get(i).getParams().get(0).setValue(divisions.get(0));

                                // Now add the rest of the divisions
                                for (int dItr = 1; dItr < divisions.size(); dItr++) {
                                    SearchRequest requestD = new SearchRequest("myplan.lu.search.division");
                                    requestD.addParam("division", divisions.get(dItr));
                                    addCampusParam(requestD, form);
                                    requests.add(requestD);
                                }

                                SearchRequest request1 = new SearchRequest("myplan.lu.search.title");
                                request1.addParam("queryText", key.trim());
                                addCampusParam(request1, form);
                                requests.add(request1);

                            } else {
                                // Re-purpose the request for title search
                                requests.get(i).setSearchKey("myplan.lu.search.title");
                            }

                            SearchRequest request2 = new SearchRequest("myplan.lu.search.description");
                            request2.addParam("queryText", key.trim());
                            addCampusParam(request2, form);
                            requests.add(request2);
                        }

                    }
                }
            }
        }
        ArrayList<SearchRequest> orderedRequests = new ArrayList<SearchRequest>();
        if (requests != null && requests.size() > 0) {
            ArrayList<SearchRequest> divisionAndLevelReq = new ArrayList<SearchRequest>();
            ArrayList<SearchRequest> divisionAndCodeReq = new ArrayList<SearchRequest>();
            ArrayList<SearchRequest> divisionReq = new ArrayList<SearchRequest>();
            ArrayList<SearchRequest> additionalDivisionReq = new ArrayList<SearchRequest>();
            ArrayList<SearchRequest> titleReq = new ArrayList<SearchRequest>();
            ArrayList<SearchRequest> descriptionReq = new ArrayList<SearchRequest>();
            ArrayList<SearchRequest> fullTextReq = new ArrayList<SearchRequest>();
            for (SearchRequest searchRequest : requests) {
                if (searchRequest.getSearchKey().equalsIgnoreCase("myplan.lu.search.divisionAndCode")) {
                    divisionAndCodeReq.add(searchRequest);
                } else if (searchRequest.getSearchKey().equalsIgnoreCase("myplan.lu.search.divisionAndLevel")) {
                    divisionAndLevelReq.add(searchRequest);
                } else if (searchRequest.getSearchKey().equalsIgnoreCase("myplan.lu.search.division")) {
                    divisionReq.add(searchRequest);
                } else if (searchRequest.getSearchKey().equalsIgnoreCase("myplan.lu.search.additionalDivision")) {
                    additionalDivisionReq.add(searchRequest);
                } else if (searchRequest.getSearchKey().equalsIgnoreCase("myplan.lu.search.title")) {
                    titleReq.add(searchRequest);
                } else if (searchRequest.getSearchKey().equalsIgnoreCase("myplan.lu.search.description")) {
                    descriptionReq.add(searchRequest);
                } else if (searchRequest.getSearchKey().equalsIgnoreCase("myplan.lu.search.fulltext")) {
                    fullTextReq.add(searchRequest);
                }
            }
            orderedRequests.addAll(divisionAndCodeReq);
            orderedRequests.addAll(divisionAndLevelReq);
            orderedRequests.addAll(divisionReq);
            orderedRequests.addAll(additionalDivisionReq);
            orderedRequests.addAll(titleReq);
            orderedRequests.addAll(descriptionReq);
            orderedRequests.addAll(fullTextReq);
        }
        return orderedRequests;
    }

    private void addVersionDateParam(List<SearchRequest> searchRequests) {
//        String currentTerm = null;
        String lastScheduledTerm = null;


//            currentTerm = AtpHelper.getCurrentAtpId();
        lastScheduledTerm = AtpHelper.getLastScheduledAtpId();
        for (SearchRequest searchRequest : searchRequests) {
            // TODO: Fix when version issue for course is addressed
//            searchRequest.addParam("currentTerm", currentTerm);
            searchRequest.addParam("lastScheduledTerm", lastScheduledTerm);
        }
    }


    //Note: here I am using r1 LuService implementation!!!
    protected LuService getLuService() {
        if (luService == null) {
            luService = (LuService) GlobalResourceLoader.getService(new QName(LuServiceConstants.LU_NAMESPACE, "LuService"));
        }
        return this.luService;
    }

    public void setLuService(LuService luService) {
        this.luService = luService;
    }

    public CourseHelper getCourseHelper() {
        if (courseHelper == null) {
            courseHelper = new CourseHelperImpl();
        }
        return courseHelper;
    }

    public void setCourseHelper(CourseHelper courseHelper) {
        this.courseHelper = courseHelper;
    }
}
