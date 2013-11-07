package org.kuali.student.r2.core.class1.search;

import org.apache.commons.lang.StringUtils;
import org.kuali.student.enrollment.class1.lui.model.LuiEntity;
import org.kuali.student.r2.common.class1.search.SearchServiceAbstractHardwiredImplBase;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.util.RichTextHelper;
import org.kuali.student.r2.common.util.constants.LuiServiceConstants;
import org.kuali.student.r2.common.util.date.DateFormatters;
import org.kuali.student.r2.core.class1.type.dto.TypeInfo;
import org.kuali.student.r2.core.search.dto.SearchRequestInfo;
import org.kuali.student.r2.core.search.dto.SearchResultInfo;
import org.kuali.student.r2.core.search.dto.SearchResultRowInfo;
import org.kuali.student.r2.core.search.util.SearchRequestHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: gtaylor
 * Date: 3/11/13
 * Time: 12:56 PM
 *
 * This class is to be used to call ActivityOffering specific DB searches.
 */
public class ActivityOfferingSearchServiceImpl extends SearchServiceAbstractHardwiredImplBase {

    @Resource
    private EntityManager entityManager;

    private int maxInClauseElements = 100;

    public static final TypeInfo SCH_IDS_BY_AO_SEARCH_TYPE;
    public static final TypeInfo AOS_AND_CLUSTERS_BY_CO_ID_SEARCH_TYPE;
    public static final TypeInfo REG_GROUPS_BY_CO_ID_SEARCH_TYPE;
    public static final TypeInfo AOS_WO_CLUSTER_BY_FO_ID_SEARCH_TYPE;
    public static final TypeInfo AO_CODES_BY_CO_ID_SEARCH_TYPE;
    public static final TypeInfo AO_CODES_TYPES_BY_CO_ID_SEARCH_TYPE;
    public static final TypeInfo TERM_ID_BY_OFFERING_ID_SEARCH_TYPE;
    public static final TypeInfo TOTAL_MAX_SEATS_BY_AO_IDS_SEARCH_TYPE;
    public static final TypeInfo COLOCATED_AOS_BY_AO_IDS_SEARCH_TYPE;
    public static final TypeInfo FO_BY_CO_ID_SEARCH_TYPE;
    public static final TypeInfo RELATED_AO_TYPES_BY_CO_ID_SEARCH_TYPE;
    public static final TypeInfo AO_CLUSTER_COUNT_BY_FO_TYPE;
    public static final TypeInfo AO_ID_AND_TYPE_BY_FO_TYPE;
    public static final TypeInfo COLOCATED_AOIDS_BY_AO_IDS_SEARCH_TYPE;

    public static final String SCH_IDS_BY_AO_SEARCH_KEY = "kuali.search.type.lui.searchForScheduleIdsByAoId";
    public static final String AOS_AND_CLUSTERS_BY_CO_ID_SEARCH_KEY = "kuali.search.type.lui.searchForAOsAndClustersByCoId";
    public static final String REG_GROUPS_BY_CO_ID_SEARCH_KEY = "kuali.search.type.lui.searchForRegGroupsByCoId";
    public static final String AOS_WO_CLUSTER_BY_FO_ID_SEARCH_KEY = "kuali.search.type.lui.searchForAOsWithoutClusterByFormatId";
    public static final String COLOCATED_AOS_BY_AO_IDS_SEARCH_KEY = "kuali.search.type.lui.searchForAosByAoIds";
    public static final String COLOCATED_AOIDS_BY_AO_IDS_SEARCH_KEY = "kuali.search.type.lui.searchForColocatedAoIdsByAoIds";
    public static final String FO_BY_CO_ID_SEARCH_KEY = "kuali.search.type.lui.searchForFOByCoId";
    public static final String RELATED_AO_TYPES_BY_CO_ID_SEARCH_KEY = "kuali.search.type.lui.searchForRelatedAoTypesByCoId";
    public static final String AO_CODES_BY_CO_ID_SEARCH_KEY = "kuali.search.type.lui.searchForAoCodesByCoId";
    public static final String AO_CODES_TYPES_BY_CO_ID_SEARCH_KEY = "kuali.search.type.lui.searchForAoCodesAndTypesByCoId";
    public static final String TERM_ID_BY_OFFERING_ID_SEARCH_KEY = "kuali.search.type.lui.searchForTermIdByOfferingId";
    public static final String TOTAL_MAX_SEATS_BY_AO_IDS_SEARCH_KEY = "kuali.search.type.lui.searchForTotalMaxSeatsByAOIds";
    public static final String AO_CLUSTER_COUNT_BY_FO_SEARCH_KEY = "kuali.search.type.lui.getCountOfAOClustersByFO";
    public static final String AO_ID_AND_TYPE_BY_FO_SEARCH_KEY = "kuali.search.type.lui.getAoIdAndTypeByFoId";

    public static final String DEFAULT_EFFECTIVE_DATE = "01/01/2012";


    private static final int RESULTROW_AOID_OFFSET = 6;
    private static final int RESULTROW_SCHED_OFFSET = 9;

    public static final class SearchParameters {
        public static final String AO_ID = "id";
        public static final String CO_ID = "coId";
        public static final String OFFERING_ID = "offeringId";
        public static final String FO_ID = "foId";
        public static final String AO_IDS = "aoIds";
        public static final String AO_STATES = "aoStates";
        public static final String REGGROUP_STATES = "regGroupStates";
        public static final String FO_REL_TYPE = "foRelType";
    }

    public static final class SearchResultColumns {
        public static final String SCHEDULE_ID = "scheduleId";
        public static final String FO_ID = "foId";
        public static final String FORMAT_ID = "formatId";
        public static final String FO_NAME = "foName";
        public static final String AOC_ID = "aocId";
        public static final String AOC_NAME = "aocName";
        public static final String AOC_PRIVATE_NAME = "aocPrivateName";
        public static final String AO_ID = "aoId";
        public static final String AO_TYPE = "aoType";
        public static final String AO_STATE = "aoState";
        public static final String AO_MAX_SEATS = "aoMaxSeats";
        public static final String AO_CODE = "aoCode";
        public static final String CO_CODE = "coCode";
        public static final String CO_ID = "coId";
        public static final String RG_NAME = "rgId";
        public static final String RG_ID = "rgName";
        public static final String RG_STATE = "rgState";
        public static final String ATP_ID = "atpId";
        public static final String TOTAL_MAX_SEATS = "totalMaxSeats";
        public static final String AO_CLUSTER_COUNT = "aoClusterCount";
    }

    static {
        TypeInfo info = new TypeInfo();
        info.setKey(SCH_IDS_BY_AO_SEARCH_KEY);
        info.setName("Activity Offering Search");
        info.setDescr(new RichTextHelper().fromPlain("Return search results for Activity Offerings"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        SCH_IDS_BY_AO_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(AOS_AND_CLUSTERS_BY_CO_ID_SEARCH_KEY);
        info.setName("Activity Offerings for CO Search");
        info.setDescr(new RichTextHelper().fromPlain("Return search results for Activity Offerings by CO ID"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        AOS_AND_CLUSTERS_BY_CO_ID_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(REG_GROUPS_BY_CO_ID_SEARCH_KEY);
        info.setName("Reg Groups for CO Search");
        info.setDescr(new RichTextHelper().fromPlain("Return search results for Reg Groups by CO ID"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        REG_GROUPS_BY_CO_ID_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(COLOCATED_AOS_BY_AO_IDS_SEARCH_KEY);
        info.setName("Colocated AOs Search");
        info.setDescr(new RichTextHelper().fromPlain("Return search results for Colocated AOs"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        COLOCATED_AOS_BY_AO_IDS_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(AOS_WO_CLUSTER_BY_FO_ID_SEARCH_KEY);
        info.setName("AOs without cluster by format offering search");
        info.setDescr(new RichTextHelper().fromPlain("Returns a list of AO Ids that are not assigned to a cluster"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        AOS_WO_CLUSTER_BY_FO_ID_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(FO_BY_CO_ID_SEARCH_KEY);
        info.setName("AOs without cluster by format offering search");
        info.setDescr(new RichTextHelper().fromPlain("Returns a list of AO Ids that are not assigned to a cluster"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        FO_BY_CO_ID_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(RELATED_AO_TYPES_BY_CO_ID_SEARCH_KEY);
        info.setName("Related AO Types for course offering");
        info.setDescr(new RichTextHelper().fromPlain("Returns a list of AO Types allowed for the FOs tied "));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        RELATED_AO_TYPES_BY_CO_ID_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(AO_CODES_BY_CO_ID_SEARCH_KEY);
        info.setName("AO codes for course offering id");
        info.setDescr(new RichTextHelper().fromPlain("Returns a list of AO codes for a given CO id"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        AO_CODES_BY_CO_ID_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(AO_CODES_TYPES_BY_CO_ID_SEARCH_KEY);
        info.setName("AO codes and types for course offering id");
        info.setDescr(new RichTextHelper().fromPlain("Returns a list of AO codes and types for a given CO id"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        AO_CODES_TYPES_BY_CO_ID_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(TERM_ID_BY_OFFERING_ID_SEARCH_KEY);
        info.setName("Term Id for offering id");
        info.setDescr(new RichTextHelper().fromPlain("Returns term id for a given offering id"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        TERM_ID_BY_OFFERING_ID_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(TOTAL_MAX_SEATS_BY_AO_IDS_SEARCH_KEY);
        info.setName("Total Max seats for AO Set id");
        info.setDescr(new RichTextHelper().fromPlain("Returns Total Max seats for AO Set id"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        TOTAL_MAX_SEATS_BY_AO_IDS_SEARCH_TYPE = info;

        info = new TypeInfo();
        info.setKey(AO_CLUSTER_COUNT_BY_FO_SEARCH_KEY);
        info.setName("get AO cluster count by Format offering");
        info.setDescr(new RichTextHelper().fromPlain("Returns the number of AO clusters for a particular Format Offering"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        AO_CLUSTER_COUNT_BY_FO_TYPE = info;

        info = new TypeInfo();
        info.setKey(AO_ID_AND_TYPE_BY_FO_SEARCH_KEY);
        info.setName("get AO ids and types by Format offering");
        info.setDescr(new RichTextHelper().fromPlain("Returns AO ids and types for a particular Format Offering"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        AO_ID_AND_TYPE_BY_FO_TYPE = info;

        info = new TypeInfo();
        info.setKey(COLOCATED_AOIDS_BY_AO_IDS_SEARCH_KEY);
        info.setName("get AO ids that are colocated");
        info.setDescr(new RichTextHelper().fromPlain("Returns AO ids that are colocated from a list of ao ids passed in"));
        info.setEffectiveDate(DateFormatters.MONTH_DAY_YEAR_DATE_FORMATTER.parse(DEFAULT_EFFECTIVE_DATE));

        COLOCATED_AOIDS_BY_AO_IDS_SEARCH_TYPE = info;
    }

    @Override
    public TypeInfo getSearchType() {
        return SCH_IDS_BY_AO_SEARCH_TYPE;
    }

    @Override
    public TypeInfo getSearchType(String searchTypeKey, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException {
        if (SCH_IDS_BY_AO_SEARCH_KEY.equals(searchTypeKey)) {
            return SCH_IDS_BY_AO_SEARCH_TYPE;
        }
        if (AOS_AND_CLUSTERS_BY_CO_ID_SEARCH_KEY.equals(searchTypeKey)) {
            return AOS_AND_CLUSTERS_BY_CO_ID_SEARCH_TYPE;
        }
        if (REG_GROUPS_BY_CO_ID_SEARCH_KEY.equals(searchTypeKey)) {
            return REG_GROUPS_BY_CO_ID_SEARCH_TYPE;
        }
        if (COLOCATED_AOS_BY_AO_IDS_SEARCH_KEY.equals(searchTypeKey)) {
            return COLOCATED_AOS_BY_AO_IDS_SEARCH_TYPE;
        }
        if (AOS_WO_CLUSTER_BY_FO_ID_SEARCH_KEY.equals(searchTypeKey)) {
            return AOS_WO_CLUSTER_BY_FO_ID_SEARCH_TYPE;
        }
        if (FO_BY_CO_ID_SEARCH_KEY.equals(searchTypeKey)) {
            return FO_BY_CO_ID_SEARCH_TYPE;
        }
        if (RELATED_AO_TYPES_BY_CO_ID_SEARCH_KEY.equals(searchTypeKey)) {
            return RELATED_AO_TYPES_BY_CO_ID_SEARCH_TYPE;
        }
        if (AO_CODES_BY_CO_ID_SEARCH_KEY.equals(searchTypeKey)) {
            return AO_CODES_BY_CO_ID_SEARCH_TYPE;
        }
        if (AO_CODES_TYPES_BY_CO_ID_SEARCH_KEY.equals(searchTypeKey)) {
            return AO_CODES_TYPES_BY_CO_ID_SEARCH_TYPE;
        }
        if (TERM_ID_BY_OFFERING_ID_SEARCH_KEY.equals(searchTypeKey)) {
            return AO_CODES_BY_CO_ID_SEARCH_TYPE;
        }
        if (TOTAL_MAX_SEATS_BY_AO_IDS_SEARCH_KEY.equals(searchTypeKey)) {
            return TOTAL_MAX_SEATS_BY_AO_IDS_SEARCH_TYPE;
        }
        if (AO_CLUSTER_COUNT_BY_FO_SEARCH_KEY.equals(searchTypeKey)) {
            return AO_CLUSTER_COUNT_BY_FO_TYPE;
        }
        if (AO_ID_AND_TYPE_BY_FO_SEARCH_KEY.equals(searchTypeKey)) {
            return AO_ID_AND_TYPE_BY_FO_TYPE;
        }
        if (COLOCATED_AOIDS_BY_AO_IDS_SEARCH_KEY.equals(searchTypeKey)) {
            return COLOCATED_AOIDS_BY_AO_IDS_SEARCH_TYPE;
        }
        throw new DoesNotExistException("No Search Type Found for key:"+searchTypeKey);
    }

    @Override
    public List<TypeInfo> getSearchTypes(ContextInfo contextInfo)
            throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException {
        return Arrays.asList(SCH_IDS_BY_AO_SEARCH_TYPE, AOS_AND_CLUSTERS_BY_CO_ID_SEARCH_TYPE,
                REG_GROUPS_BY_CO_ID_SEARCH_TYPE, AOS_WO_CLUSTER_BY_FO_ID_SEARCH_TYPE, COLOCATED_AOS_BY_AO_IDS_SEARCH_TYPE, FO_BY_CO_ID_SEARCH_TYPE,
                RELATED_AO_TYPES_BY_CO_ID_SEARCH_TYPE, AO_CODES_BY_CO_ID_SEARCH_TYPE, AO_CODES_TYPES_BY_CO_ID_SEARCH_TYPE, TERM_ID_BY_OFFERING_ID_SEARCH_TYPE,
                TOTAL_MAX_SEATS_BY_AO_IDS_SEARCH_TYPE, AO_CLUSTER_COUNT_BY_FO_TYPE, AO_ID_AND_TYPE_BY_FO_TYPE, COLOCATED_AOIDS_BY_AO_IDS_SEARCH_TYPE);
    }

    @Override
    @Transactional(readOnly = true)
    public SearchResultInfo search(SearchRequestInfo searchRequestInfo, ContextInfo contextInfo) throws MissingParameterException, OperationFailedException, PermissionDeniedException {

        if (SCH_IDS_BY_AO_SEARCH_TYPE.getKey().equals(searchRequestInfo.getSearchKey())) {
            return searchForScheduleIdsByAoId(searchRequestInfo);
        }
        else if (AOS_AND_CLUSTERS_BY_CO_ID_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForAOsAndClustersByCoId(searchRequestInfo);
        }
        else if (REG_GROUPS_BY_CO_ID_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForRegGroupsByCoId(searchRequestInfo);
        }
        else if (COLOCATED_AOS_BY_AO_IDS_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForAosByAoIds(searchRequestInfo);
        }
        else if (AOS_WO_CLUSTER_BY_FO_ID_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForAOsWithoutClusterByFormatOffering(searchRequestInfo);
        }
        else if (FO_BY_CO_ID_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForFOByCOId(searchRequestInfo);
        }
        else if (RELATED_AO_TYPES_BY_CO_ID_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForRelatedAoTypesByCoId(searchRequestInfo);
        }
        else if (AO_CODES_BY_CO_ID_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForAoCodesByCoId(searchRequestInfo);
        }
        else if (AO_CODES_TYPES_BY_CO_ID_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForAoCodesAndTypesByCoId(searchRequestInfo);
        }
        else if (TERM_ID_BY_OFFERING_ID_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForTermIdByOfferingId(searchRequestInfo);
        }
        else if (TOTAL_MAX_SEATS_BY_AO_IDS_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForTotalMaxSeatsByAOIds(searchRequestInfo);
        }
        else if (AO_CLUSTER_COUNT_BY_FO_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForAOClusterCountByFO(searchRequestInfo);
        }
        else if (AO_ID_AND_TYPE_BY_FO_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForAoIdAndTypeByFO(searchRequestInfo);
        }
        else if (COLOCATED_AOIDS_BY_AO_IDS_SEARCH_KEY.equals(searchRequestInfo.getSearchKey())){
            return searchForColocatedAoIdsByAoIds(searchRequestInfo);
        }
        else{
            throw new OperationFailedException("Unsupported search type: " + searchRequestInfo.getSearchKey());
        }
    }

    private SearchResultInfo searchForColocatedAoIdsByAoIds(SearchRequestInfo searchRequestInfo) {
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        List<String> aoIdsList = requestHelper.getParamAsList(SearchParameters.AO_IDS);

        boolean enableMaxIdFetch = false;
        if (!aoIdsList.isEmpty() && aoIdsList.size() > this.maxInClauseElements) {
            enableMaxIdFetch = true;
        }

        String queryStrStart =
                "SELECT DISTINCT srs1RefId FROM ScheduleRequestSetEntity srs1, " +
                        "    ScheduleRequestSetEntity srs2, " +
                        "    IN(srs1.refObjectIds) srs1RefId, " +
                        "    IN(srs2.refObjectIds) srs2RefId " +
                        "  WHERE srs1.id = srs2.id " +
                        "  AND srs1RefId != srs2RefId " +
                        "  AND ";
        String queryStrEnd = ")";
        String primaryKeyMemberName = "srs1RefId";

        TypedQuery<String> query = buildQuery(queryStrStart, queryStrEnd, primaryKeyMemberName, aoIdsList, enableMaxIdFetch, maxInClauseElements, String.class);
        List<String> results = query.getResultList();

        for(String result : results){
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.AO_ID, result);
            resultInfo.getRows().add(row);
        }

        return resultInfo;
    }

    private SearchResultInfo searchForTotalMaxSeatsByAOIds(SearchRequestInfo searchRequestInfo) {
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        List<String> aoIdsList = requestHelper.getParamAsList(SearchParameters.AO_IDS);

        boolean enableMaxIdFetch = false;
        if (!aoIdsList.isEmpty() && aoIdsList.size() > this.maxInClauseElements) {
            enableMaxIdFetch = true;
        }

        String queryStrStart =
                "SELECT SUM(ao.maxSeats)" +
                        "FROM LuiEntity ao " +
                        "WHERE ";
        String primaryKeyMemberName = "ao.id";

        TypedQuery<Long> query = buildQuery(queryStrStart, null, primaryKeyMemberName, aoIdsList, enableMaxIdFetch, maxInClauseElements, Long.class);
        List<Long> results = query.getResultList();

        for(Long result : results){
            SearchResultRowInfo row = new SearchResultRowInfo();
            if (result == null || result.equals("")) {
                row.addCell(SearchResultColumns.TOTAL_MAX_SEATS, "0");
            } else {
                row.addCell(SearchResultColumns.TOTAL_MAX_SEATS, result.toString());
            }
            resultInfo.getRows().add(row);
        }

        return resultInfo;
    }

    private SearchResultInfo searchForRelatedAoTypesByCoId(SearchRequestInfo searchRequestInfo) throws OperationFailedException {
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String coId = requestHelper.getParamAsString(SearchParameters.CO_ID);

        String queryStr =
            "SELECT co2fo.relatedLui.id," +
            "       relatedTypes " +
            "FROM LuiLuiRelationEntity co2fo," +
            "     IN(co2Fo.relatedLui.relatedLuiTypes) relatedTypes " +
            "WHERE co2fo.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.co2fo' " +
            "  AND co2fo.lui.id = :coId ";

        TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
        query.setParameter(SearchParameters.CO_ID, coId);       // After updating an oracle driver the List binding is causing massive problems
        List<Object[]> results = query.getResultList();

        for(Object[] resultRow : results){
            int i = 0;
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.FO_ID, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.AO_TYPE, (String)resultRow[i]);
            resultInfo.getRows().add(row);
        }

        return resultInfo;
    }

    /**
     * Finds a list of AO codes and Ids given a CO id.
     * @throws OperationFailedException 
     */
    private SearchResultInfo searchForAoCodesByCoId(SearchRequestInfo searchRequestInfo) throws OperationFailedException {
        SearchResultInfo resultInfo = new SearchResultInfo();
        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String coId = requestHelper.getParamAsString(SearchParameters.CO_ID);

        String queryStr =
                "SELECT luiId.lui.id, " +
                        "luiId.code " +
                "FROM  LuiIdentifierEntity luiId," +
                      "LuiLuiRelationEntity co2fo," +
                      "LuiLuiRelationEntity fo2ao " +
                "WHERE co2fo.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.co2fo' " +
                "  AND fo2ao.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.fo2ao' " +
                "  AND co2fo.lui.id = :coId " +
                "  AND co2fo.relatedLui.id = fo2ao.lui.id " +
                "  AND luiId.lui.id = fo2ao.relatedLui";

        TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
        query.setParameter(SearchParameters.CO_ID, coId);
        List<Object[]> results = query.getResultList();

        for(Object[] resultRow : results){
            int i = 0;
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.AO_ID, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.AO_CODE, (String)resultRow[i]);
            resultInfo.getRows().add(row);
        }
        return resultInfo;
    }

    private SearchResultInfo searchForAoCodesAndTypesByCoId(SearchRequestInfo searchRequestInfo) throws OperationFailedException {
        SearchResultInfo resultInfo = new SearchResultInfo();
        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String coId = requestHelper.getParamAsString(SearchParameters.CO_ID);

        String queryStr =
                "SELECT luiId.lui.id, " +
                        "luiId.code, " +
                        "luiId.lui.luiType " +
                        "FROM  LuiIdentifierEntity luiId," +
                        "LuiLuiRelationEntity co2fo," +
                        "LuiLuiRelationEntity fo2ao " +
                        "WHERE co2fo.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.co2fo' " +
                        "  AND fo2ao.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.fo2ao' " +
                        "  AND co2fo.lui.id = :coId " +
                        "  AND co2fo.relatedLui.id = fo2ao.lui.id " +
                        "  AND luiId.lui.id = fo2ao.relatedLui";

        TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
        query.setParameter(SearchParameters.CO_ID, coId);
        List<Object[]> results = query.getResultList();

        for(Object[] resultRow : results){
            int i = 0;
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.AO_ID, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.AO_CODE, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.AO_TYPE, (String)resultRow[i]);
            resultInfo.getRows().add(row);
        }
        return resultInfo;
    }

    private SearchResultInfo searchForAosByAoIds(SearchRequestInfo searchRequestInfo) {
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        List<String> aoIdsList = requestHelper.getParamAsList(SearchParameters.AO_IDS);
        List<String> aoStates = requestHelper.getParamAsList(SearchParameters.AO_STATES);
        String filterAOStates = "'" + StringUtils.join(aoStates, "','") + "'";

        boolean enableMaxIdFetch = false;
        if (!aoIdsList.isEmpty() && aoIdsList.size() > this.maxInClauseElements) {
            enableMaxIdFetch = true;
        }

        String queryStrStart =
                "SELECT aoMatchIds," +
                "       co_ident.code," +
                "       ao_ident.code " +
                "FROM ScheduleRequestSetEntity srs," +
                "     IN(srs.refObjectIds) aoMatchIds," +
                "     IN(srs.refObjectIds) aoIds," +
                "     LuiIdentifierEntity co_ident," +
                "     LuiIdentifierEntity ao_ident," +
                "     LuiLuiRelationEntity co2fo," +
                "     LuiLuiRelationEntity fo2ao, " +
                "     LuiEntity lui " +
                "WHERE co2fo.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.co2fo' " +
                "  AND fo2ao.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.fo2ao' " +
                "  AND co2fo.relatedLui.id = fo2ao.lui.id " +
                "  AND fo2ao.relatedLui.id = aoIds " +
                "  AND co2fo.lui.id = co_ident.lui.id " +
                "  AND aoIds = ao_ident.lui.id " +
                "  AND co_ident.type = 'kuali.lui.identifier.type.official' " +
                "  AND ao_ident.type = 'kuali.lui.identifier.type.official' " +
                "  AND lui.id = ao_ident.lui.id " +
                "  AND aoMatchIds != aoIds";

        if (aoStates != null && !aoStates.isEmpty()){
            queryStrStart = queryStrStart + " AND lui.luiState in (" + filterAOStates + ")";
        }

        queryStrStart = queryStrStart + " AND ";

        String queryStrEnd = ")";
        String primaryKeyMemberName = "aoMatchIds";

        TypedQuery<Object[]> query = buildQuery(queryStrStart, queryStrEnd, primaryKeyMemberName, aoIdsList, enableMaxIdFetch, maxInClauseElements, Object[].class);
        List<Object[]> results = query.getResultList();

        for(Object[] resultRow : results){
            int i = 0;
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.AO_ID, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.CO_CODE, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.AO_CODE, (String)resultRow[i]);
            resultInfo.getRows().add(row);
        }

        return resultInfo;
    }

    private SearchResultInfo searchForRegGroupsByCoId(SearchRequestInfo searchRequestInfo) throws OperationFailedException {
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String coId = requestHelper.getParamAsString(SearchParameters.CO_ID);
        List<String> regGroupStates = requestHelper.getParamAsList(SearchParameters.REGGROUP_STATES);

        String queryStr =
                "SELECT rg2ao.relatedLui.id," +
                "       rg2ao.lui.id," +
                "       rg2ao.lui.name," +
                "       rg2ao.lui.luiState " +
                "FROM LuiLuiRelationEntity co2fo," +
                "     LuiLuiRelationEntity fo2ao," +
                "     LuiLuiRelationEntity rg2ao " +
                "WHERE co2fo.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.co2fo' " +
                "  AND fo2ao.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.fo2ao' " +
                "  AND rg2ao.luiLuiRelationType = 'kuali.lui.lui.relation.type.registeredforvia.rg2ao' " +
                "  AND co2fo.lui.id = :coId " +
                "  AND co2fo.relatedLui.id = fo2ao.lui.id " +
                "  AND rg2ao.relatedLui.id = fo2ao.relatedLui.id ";

        if(regGroupStates != null && !regGroupStates.isEmpty()) {
            queryStr = queryStr + " AND rg2ao.lui.luiState IN(:regGroupStates)";
        }

        TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
        query.setParameter(SearchParameters.CO_ID, coId);
        if(regGroupStates != null && !regGroupStates.isEmpty()) {
            query.setParameter(SearchParameters.REGGROUP_STATES, regGroupStates);
        }
        List<Object[]> results = query.getResultList();

        for(Object[] resultRow : results){
            int i = 0;
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.AO_ID, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.RG_ID, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.RG_NAME, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.RG_STATE, (String)resultRow[i]);
            resultInfo.getRows().add(row);
        }

        return resultInfo;
    }

    /**
     *
     * @param searchRequestInfo   Contains an Activity Offering ID that we will use to find the scheduleIds
     * @return ScheduleIds
     * @throws MissingParameterException
     * @throws OperationFailedException
     * @throws PermissionDeniedException
     */
    protected SearchResultInfo searchForScheduleIdsByAoId(SearchRequestInfo searchRequestInfo) throws MissingParameterException, OperationFailedException, PermissionDeniedException {
        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);

        String aoId = requestHelper.getParamAsString(SearchParameters.AO_ID);

        if (aoId == null || aoId.isEmpty()){
            throw new RuntimeException("Activity Offering id is required");
        }

        LuiEntity entity = entityManager.find(LuiEntity.class, aoId.trim());
        List<String> results = new ArrayList<String>();
        if(entity != null && entity.getScheduleIds() != null) {
            results.addAll(entity.getScheduleIds());
        }
        SearchResultInfo resultInfo = new SearchResultInfo();

        for (String result : results) {
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.SCHEDULE_ID, result);
            resultInfo.getRows().add(row);
        }
        return resultInfo;
    }

    private SearchResultInfo searchForAOsAndClustersByCoId(SearchRequestInfo searchRequestInfo) throws OperationFailedException{
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String coId = requestHelper.getParamAsString(SearchParameters.CO_ID);
        List<String> aoStates = requestHelper.getParamAsList(SearchParameters.AO_STATES);
//TODO JPQL does not support on clauses in outer joins, so to accomplish this, we would need to update the entities
//        String queryStr =
//                "SELECT DISTINCT " +
//                "       fo.id," +
//                "       fo.name," +
//                "       clster.id," +
//                "       clster.name," +
//                "       clster.privateName," +
//                "       ao.id," +
//                "       ao.luiType," +
//                "       ao.luiState," +
//                "       ao.scheduleId," +
//                "       ao.maxSeats," +
//                "       aoIdent.code " +
//                "FROM LuiLuiRelationEntity co2fo " +
//                        "LEFT OUTER JOIN co2fo.relatedLui fo " +
//                        "LEFT OUTER JOIN ActivityOfferingClusterEntity clster ON (clster.formatOfferingId = fo.id)" +
//                        "LEFT OUTER JOIN clster.aoSets clsterSet " +
//                        "LEFT OUTER JOIN clsterSet.aoIds clst2ao " +
//                        "LEFT OUTER JOIN LuiEntity ao ON (ao.id = aocSetAoIds) " +
//                        "LEFT OUTER JOIN ao.identifiers aoIdent " +
//                "WHERE co2fo.lui.id = :coId " +
//                "  AND co2fo.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.co2fo' " +
//                "  AND clster.formatOfferingId = fo.id ";
////                "  AND aoIdent.type = 'kuali.lui.identifier.type.official'";

        String queryStr = "SELECT DISTINCT " +
                "    co2fo.RELATED_LUI_ID AS col_0_0_, " +
                "    fo.NAME              AS col_1_0_, " +
                "    fo.CLU_ID            AS col_2_0_, " +
                "    clster.ID            AS col_3_0_, " +
                "    clster.NAME          AS col_4_0_, " +
                "    clster.PRIVATE_NAME  AS col_5_0_, " +
                "    ao.ID                AS col_6_0_, " +
                "    ao.LUI_TYPE          AS col_7_0_, " +
                "    ao.LUI_STATE         AS col_8_0_, " +
                "    ao2sched.SCHED_ID    AS col_9_0_, " +
                "    ao.MAX_SEATS         AS col_10_0_, " +
                "    aoIdent.LUI_CD       AS col_11_0_, " +
                "    ao.ATP_ID            AS col_12_0_ " +
                "FROM " +
                "    KSEN_LUILUI_RELTN co2fo " +
                "LEFT OUTER JOIN " +
                "    KSEN_LUI fo " +
                "ON " +
                "    co2fo.RELATED_LUI_ID=fo.ID " +
                "LEFT OUTER JOIN " +
                "    KSEN_CO_AO_CLUSTER clster " +
                "ON " +
                "    co2fo.RELATED_LUI_ID=clster.FORMAT_OFFERING_ID " +
                "LEFT OUTER JOIN " +
                "    KSEN_CO_AO_CLUSTER_SET clsterSet " +
                "ON " +
                "    clster.ID=clsterSet.AO_CLUSTER_ID " +
                "LEFT OUTER JOIN " +
                "    KSEN_CO_AO_CLUSTER_SET_AO clst2ao " +
                "ON " +
                "    clsterSet.ID=clst2ao.AOC_SET_ID " +
                "LEFT OUTER JOIN " +
                "    KSEN_LUI ao " +
                "ON " +
                "    clst2ao.ACTIVITY_OFFERING_ID=ao.ID " +
                "LEFT OUTER JOIN " +
                "    KSEN_LUI_IDENT aoIdent " +
                "ON " +
                "    ao.ID=aoIdent.LUI_ID " +
                "LEFT OUTER JOIN" +
                "   KSEN_LUI_SCHEDULE ao2sched " +
                "ON " +

                "   ao2sched.LUI_ID = ao.ID " +
                "AND aoIdent.LUI_ID_TYPE='kuali.lui.identifier.type.official' " +
                "WHERE " +
                "    co2fo.LUI_ID= :coId " +
                "AND co2fo.LUILUI_RELTN_TYPE='kuali.lui.lui.relation.type.deliveredvia.co2fo'";

        if((aoStates != null) && !aoStates.isEmpty()) {
            queryStr = queryStr + " AND ao.LUI_STATE IN(:aoStates)";
        }

        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter(SearchParameters.CO_ID, coId);
        if((aoStates != null) && !aoStates.isEmpty()) {
            query.setParameter(SearchParameters.AO_STATES, aoStates);
        }
        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();

        Map<String, SearchResultRowInfo> aoMap = new HashMap<String, SearchResultRowInfo>();
        for(Object[] resultRow : results){
            int i = 0;
            String aoId = (String)resultRow[RESULTROW_AOID_OFFSET];

            SearchResultRowInfo row;
            if(aoId == null || (row = aoMap.get(aoId)) == null) {
                row = new SearchResultRowInfo();
                row.addCell(SearchResultColumns.FO_ID, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.FO_NAME, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.FORMAT_ID, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.AOC_ID, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.AOC_NAME, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.AOC_PRIVATE_NAME, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.AO_ID, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.AO_TYPE, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.AO_STATE, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.SCHEDULE_ID, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.AO_MAX_SEATS, resultRow[i]==null?null:resultRow[i].toString());
                i++; // increment from previous row
                row.addCell(SearchResultColumns.AO_CODE, (String)resultRow[i++]);
                row.addCell(SearchResultColumns.ATP_ID, resultRow[i]==null?null:resultRow[i].toString());
                resultInfo.getRows().add(row);
                aoMap.put(aoId, row);
            } else {
                row.addCell(SearchResultColumns.SCHEDULE_ID, (String)resultRow[RESULTROW_SCHED_OFFSET]);
            }
        }

        return resultInfo;
    }

    protected SearchResultInfo searchForAOsWithoutClusterByFormatOffering(SearchRequestInfo searchRequestInfo) throws OperationFailedException{
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String foId = requestHelper.getParamAsString(SearchParameters.FO_ID);

        String queryStr =
                "SELECT rel.relatedLui.id aoId " +
                        "FROM LuiLuiRelationEntity rel " +
                        "WHERE rel.lui.id = :foId " +
                        "  AND rel.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.fo2ao' " +
                        "  AND rel.relatedLui.id not in ( " +
                        "SELECT aocSetAoIds " +
                        "FROM ActivityOfferingClusterEntity aoc " +
                        "     IN(aoc.aoSets) aocSets, " +
                        "     IN(aocSets.aoIds) aocSetAoIds " +
                        "WHERE " +
                        "  aoc.formatOfferingId = :foId ) ";

        TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
        query.setParameter(SearchParameters.FO_ID, foId);
        List<Object[]> results = query.getResultList();

        for(Object[] resultRow : results){
            int i = 0;
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.AO_ID, (String)resultRow[i]);
            resultInfo.getRows().add(row);
        }

        return resultInfo;
    }

    protected SearchResultInfo searchForFOByCOId(SearchRequestInfo searchRequestInfo) throws OperationFailedException{
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String coId = requestHelper.getParamAsString(SearchParameters.CO_ID);

        String queryStr =
                "SELECT rel.relatedLui.id as foId, " +
                        "fo_lui.name as foName " +
                        "FROM LuiLuiRelationEntity rel, " +
                        "     LuiEntity fo_lui " +
                        "WHERE rel.lui.id = :coId " +
                        "  AND rel.luiLuiRelationType = 'kuali.lui.lui.relation.type.deliveredvia.co2fo' " +
                        "  AND rel.relatedLui.id = fo_lui.id";

        TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
        query.setParameter(SearchParameters.CO_ID, coId);
        List<Object[]> results = query.getResultList();

        for(Object[] resultRow : results){
            int i = 0;
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.FO_ID, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.FO_NAME, (String)resultRow[i]);
            resultInfo.getRows().add(row);
        }

        return resultInfo;
    }

    /**
     * Finds a list of AO codes and Ids given a CO id.
     * @throws OperationFailedException 
     */
    private SearchResultInfo searchForTermIdByOfferingId(SearchRequestInfo searchRequestInfo) throws OperationFailedException {
        SearchResultInfo resultInfo = new SearchResultInfo();
        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String offeringId = requestHelper.getParamAsString(SearchParameters.OFFERING_ID);

        String queryStr =
                "SELECT lui.atpId " +
                        "FROM  LuiEntity lui " +
                        "WHERE lui.id = :offeringId ";
        Query query = entityManager.createQuery(queryStr);
        query.setParameter(SearchParameters.OFFERING_ID, offeringId);
        String termId = (String)query.getResultList().get(0);
        SearchResultRowInfo row = new SearchResultRowInfo();
        row.addCell(SearchResultColumns.ATP_ID, termId);
        resultInfo.getRows().add(row);

        return resultInfo;
    }

    /**
     * This method will return a AO cluster count based on the FO Id passed in.
     *
     * This was made as a performance improvement.
     *
     * @param searchRequestInfo FO id search params
     * @return a AO cluster count
     * @throws OperationFailedException 
     */
    private SearchResultInfo searchForAOClusterCountByFO(SearchRequestInfo searchRequestInfo) throws OperationFailedException {
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String formatOfferingId = requestHelper.getParamAsString(SearchParameters.FO_ID);

        String queryStr =
                "select count(a.formatOfferingId) " +
                        "from ActivityOfferingClusterEntity a " +
                        "where a.formatOfferingId=:" + SearchParameters.FO_ID;

        TypedQuery<Long> query = entityManager.createQuery(queryStr, Long.class);
        query.setParameter(SearchParameters.FO_ID, formatOfferingId);
        List<Long> results = query.getResultList();

        for(Long result : results){
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.AO_CLUSTER_COUNT, result.toString());
            resultInfo.getRows().add(row);
        }

        return resultInfo;
    }

    /**
     * This method will return AO_ID, AO_TYPE  based on the FO Id passed in.
     *
     * This was made as a performance improvement.
     *
     * @param searchRequestInfo FO id search params
     * @return AO_ID, AO_TYPE
     * @throws OperationFailedException 
     */
    private SearchResultInfo searchForAoIdAndTypeByFO(SearchRequestInfo searchRequestInfo) throws OperationFailedException {
        SearchResultInfo resultInfo = new SearchResultInfo();

        SearchRequestHelper requestHelper = new SearchRequestHelper(searchRequestInfo);
        String formatOfferingId = requestHelper.getParamAsString(SearchParameters.FO_ID);

        String queryStr =
                "Select rel.relatedLui.id, rel.relatedLui.luiType from LuiLuiRelationEntity rel where rel.lui.id=:" + SearchParameters.FO_ID +
                        " AND rel.luiLuiRelationType=:" + SearchParameters.FO_REL_TYPE;

        TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
        query.setParameter(SearchParameters.FO_ID, formatOfferingId);
        query.setParameter(SearchParameters.FO_REL_TYPE, LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_FO_TO_AO_TYPE_KEY);
        List<Object[]> results = query.getResultList();

        for(Object[] resultRow : results){
            int i = 0;
            SearchResultRowInfo row = new SearchResultRowInfo();
            row.addCell(SearchResultColumns.AO_ID, (String)resultRow[i++]);
            row.addCell(SearchResultColumns.AO_TYPE, (String)resultRow[i]);
            resultInfo.getRows().add(row);
        }

        return resultInfo;
    }

    private static String commaString(List<String> items){
        return items.toString().replace("[", "'").replace("]", "'").replace(", ", "','");
    }

    // need this because Oracle has limitation of 4000 chars in string, and we may have more than that
    private TypedQuery buildQuery(String queryStrStart, String queryStrEnd, String primaryKeyMemberName, List<String> primaryKeys, boolean enableMaxIdFetch, int maxInClauseElements, Class resultClass) {

        TypedQuery queryRef;
        StringBuilder queryStringRef = new StringBuilder();
        queryStringRef.append(queryStrStart);

        if (!enableMaxIdFetch) {
            queryStringRef.append(primaryKeyMemberName).append(" IN (:ids)");
            queryRef = entityManager.createQuery(queryStringRef.toString(), resultClass);
            queryRef.setParameter("ids", primaryKeys);
        } else {
            //Max fetchh is enabled so break uip the where clause into multiple IN() clauses
            List<List<String>> brokenLists = new ArrayList<List<String>>();
            List<String> list = new ArrayList<String>();

            if (queryStrEnd != null && StringUtils.equals(queryStrEnd, ")")) {
                queryStringRef.append("(");
            }

            Iterator<String> itr = primaryKeys.iterator();
            for (int index = 0; itr.hasNext(); index++) {
                if ((index > 0) && (index % maxInClauseElements == 0)) {
                    brokenLists.add(list);
                    if (brokenLists.size() == 1) {
                        queryStringRef.append(primaryKeyMemberName).append(" IN (:ids1)");
                    } else {
                        queryStringRef.append(" OR ").append(primaryKeyMemberName).append(" IN (:ids").append(brokenLists.size()).append(")");
                    }
                    list = new ArrayList<String>();
                }
                list.add(itr.next());
            }
            if (!list.isEmpty()) {
                brokenLists.add(list);
                queryStringRef.append(" OR ").append(primaryKeyMemberName).append(" IN (:ids").append(brokenLists.size()).append(")");
            }

            if (queryStrEnd != null && !StringUtils.isBlank(queryStrEnd)) {
                queryStringRef.append(queryStrEnd);
            }

            queryRef = entityManager.createQuery(queryStringRef.toString(), resultClass);

            for (int i = 1; i <= brokenLists.size(); i++) {
                queryRef.setParameter("ids" + i, brokenLists.get(i - 1));
            }
        }

        return queryRef;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}