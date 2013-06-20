package org.kuali.student.enrollment.class2.courseoffering.service.impl;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.criteria.GenericQueryResults;
import org.kuali.rice.core.api.criteria.Predicate;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.student.common.util.UUIDHelper;
import org.kuali.student.enrollment.acal.dto.TermInfo;
import org.kuali.student.enrollment.acal.service.AcademicCalendarService;
import org.kuali.student.enrollment.class1.lui.model.LuiEntity;
import org.kuali.student.enrollment.class2.acal.service.assembler.TermAssembler;
import org.kuali.student.enrollment.class2.courseoffering.dao.ActivityOfferingClusterDao;
import org.kuali.student.enrollment.class2.courseoffering.dao.SeatPoolDefinitionDao;
import org.kuali.student.enrollment.class2.courseoffering.model.ActivityOfferingClusterAttributeEntity;
import org.kuali.student.enrollment.class2.courseoffering.model.ActivityOfferingClusterEntity;
import org.kuali.student.enrollment.class2.courseoffering.model.ActivityOfferingSetEntity;
import org.kuali.student.enrollment.class2.courseoffering.model.SeatPoolDefinitionEntity;
import org.kuali.student.enrollment.class2.courseoffering.service.CourseOfferingCodeGenerator;
import org.kuali.student.enrollment.class2.courseoffering.service.assembler.RegistrationGroupAssembler;
import org.kuali.student.enrollment.class2.courseoffering.service.decorators.R1CourseServiceHelper;
import org.kuali.student.enrollment.class2.courseoffering.service.transformer.*;
import org.kuali.student.enrollment.courseoffering.dto.*;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingService;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingServiceBusinessLogic;
import org.kuali.student.enrollment.courseofferingset.dto.SocRolloverResultItemInfo;
import org.kuali.student.enrollment.lpr.dto.LprInfo;
import org.kuali.student.enrollment.lpr.service.LprService;
import org.kuali.student.enrollment.lui.dto.LuiInfo;
import org.kuali.student.enrollment.lui.dto.LuiLuiRelationInfo;
import org.kuali.student.enrollment.lui.service.LuiService;
import org.kuali.student.r2.common.criteria.CriteriaLookupService;
import org.kuali.student.r2.common.dto.*;
import org.kuali.student.r2.common.exceptions.*;
import org.kuali.student.r2.common.infc.ValidationResult;
import org.kuali.student.r2.common.util.constants.CourseOfferingServiceConstants;
import org.kuali.student.r2.common.util.constants.LprServiceConstants;
import org.kuali.student.r2.common.util.constants.LuiServiceConstants;
import org.kuali.student.r2.core.atp.dto.AtpInfo;
import org.kuali.student.r2.core.atp.service.AtpService;
import org.kuali.student.r2.core.class1.state.service.StateService;
import org.kuali.student.r2.core.class1.type.dto.TypeInfo;
import org.kuali.student.r2.core.class1.type.service.TypeService;
import org.kuali.student.r2.core.constants.AtpServiceConstants;
import org.kuali.student.r2.core.constants.RoomServiceConstants;
import org.kuali.student.r2.core.room.service.RoomService;
import org.kuali.student.r2.core.scheduling.dto.ScheduleComponentInfo;
import org.kuali.student.r2.core.scheduling.dto.ScheduleInfo;
import org.kuali.student.r2.core.scheduling.dto.ScheduleRequestComponentInfo;
import org.kuali.student.r2.core.scheduling.dto.ScheduleRequestInfo;
import org.kuali.student.r2.core.scheduling.service.SchedulingService;
import org.kuali.student.r2.core.scheduling.util.SchedulingServiceUtil;
import org.kuali.student.r2.lum.course.dto.CourseInfo;
import org.kuali.student.r2.lum.course.dto.FormatInfo;
import org.kuali.student.r2.lum.course.service.CourseService;
import org.kuali.student.r2.lum.lrc.service.LRCService;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebParam;
import javax.xml.namespace.QName;
import java.text.SimpleDateFormat;
import java.util.*;


public class CourseOfferingServiceImpl implements CourseOfferingService {

    private LuiService luiService;
    private TypeService typeService;
    private CourseService courseService;
    private AcademicCalendarService acalService;
    private AtpService atpService;
    private RegistrationGroupAssembler registrationGroupAssembler;
    private StateService stateService;
    private LprService lprService;
    private CourseOfferingServiceBusinessLogic businessLogic;
    private TermAssembler termAssembler = null;
    private CourseOfferingCodeGenerator offeringCodeGenerator;
    private CourseOfferingTransformer courseOfferingTransformer;
    private SeatPoolDefinitionDao seatPoolDefinitionDao;
    private ActivityOfferingClusterDao activityOfferingClusterDao;
    private RegistrationGroupTransformer registrationGroupTransformer;
    private SchedulingService schedulingService;
    private LRCService lrcService;
    private CriteriaLookupService criteriaLookupService;
    private RoomService roomService;

    public CourseOfferingServiceBusinessLogic getBusinessLogic() {
        return businessLogic;
    }

    public void setBusinessLogic(CourseOfferingServiceBusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    private void _deleteLprsByLui(String luiId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<LprInfo> lprs = lprService.getLprsByLui(luiId, context);
        for (LprInfo lpr : lprs) {
            StatusInfo status = lprService.deleteLpr(lpr.getId(), context);
            if (!status.getIsSuccess()) {
                throw new OperationFailedException("Error Deleting related LPR with id ( " + lpr.getId() + " ), given message was: " + status.getMessage());
            }
        }
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteCourseOfferingCascaded(String courseOfferingId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {

        //Cascade delete to the formats
        List<FormatOfferingInfo> fos = getFormatOfferingsByCourseOffering(courseOfferingId, context);
        for (FormatOfferingInfo fo : fos) {
            deleteFormatOfferingCascaded(fo.getId(), context);
        }

        // delete offering instructor lprs for the Course Offering
        _deleteLprsByLui(courseOfferingId, context);

        //TODO: Delete all attached other things (EnrollmentFees, org relations, etc.)

        //Delete the CO
        deleteCourseOffering(courseOfferingId, context);

        return new StatusInfo();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteFormatOfferingCascaded(String formatOfferingId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        // Delete dependent activity offerings
        List<ActivityOfferingInfo> aos = getActivityOfferingsByFormatOffering(formatOfferingId, context);
        for (ActivityOfferingInfo ao : aos) {
            deleteActivityOfferingCascaded(ao.getId(), context);
        }

        //TODO: Delete dependent RegistrationGroups

        // Delete the format offering
        try {
            deleteFormatOffering(formatOfferingId, context);
        } catch (DependentObjectsExistException e) {
            // Rethrow it for now
            throw new OperationFailedException(e.getMessage());
        }
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(true);
        return statusInfo;
    }


    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public RegistrationGroupInfo createRegistrationGroup(String formatOfferingId, String activityOfferingClusterId, String registrationGroupTypeKey, RegistrationGroupInfo registrationGroupInfo, @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, DataValidationErrorException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        FormatOfferingInfo fo = this.getFormatOffering(formatOfferingId, context);
        if (registrationGroupInfo.getTermId() != null) {
            if (!registrationGroupInfo.getTermId().equals(fo.getTermId())) {
                throw new InvalidParameterException(registrationGroupInfo.getTermId() + " term in the registration group does not match the one in the format offering " + fo.getTermId());
            }
        }
        registrationGroupInfo.setTermId(fo.getTermId());

        if (!registrationGroupTypeKey.equals(registrationGroupInfo.getTypeKey())) {
            throw new InvalidParameterException(registrationGroupTypeKey + " does not match the corresponding value in the object " + registrationGroupInfo.getTypeKey());
        }

        // get the course offering
        CourseOfferingInfo coInfo = this.getCourseOffering(registrationGroupInfo.getCourseOfferingId(), context);
        String coCode = coInfo.getCourseOfferingCode();
        if (coCode == null) {
            coCode = "NOCODE";
        }

        // TODO: Reg group code validation
        if (registrationGroupInfo.getName() == null) {
            // name stores the reg group code which is different from registration code
            throw new DataValidationErrorException("reg group code is null");
        }

        // copy to the lui
        LuiInfo lui = registrationGroupTransformer.rg2Lui(registrationGroupInfo, context);
        try {
            String cluId = lui.getCluId();
            String atpId = lui.getAtpId();
            String typeKey = lui.getTypeKey();
            lui = luiService.createLui(cluId, atpId, typeKey, lui, context);
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }

        // build the lui lui relation FO-RG
        LuiLuiRelationInfo luiLuiRelFoRg = new LuiLuiRelationInfo();
        luiLuiRelFoRg.setLuiId(formatOfferingId);
        luiLuiRelFoRg.setName("fo-rg-relation"); // TODO: This fixes a DB required field error--find more meaningful value.
        luiLuiRelFoRg.setRelatedLuiId(lui.getId());

        RichTextInfo descrFoRg = new RichTextInfo();
        descrFoRg.setPlain(coCode + "-FO-RG"); // Useful for debugging
        descrFoRg.setFormatted(coCode + "-FO-RG"); // Useful for debugging
        luiLuiRelFoRg.setDescr(descrFoRg);

        luiLuiRelFoRg.setTypeKey(LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_FO_TO_RG_TYPE_KEY);
        luiLuiRelFoRg.setStateKey(LuiServiceConstants.LUI_LUI_RELATION_ACTIVE_STATE_KEY);
        luiLuiRelFoRg.setEffectiveDate(new Date());
        try {
            luiService.createLuiLuiRelation(luiLuiRelFoRg.getLuiId(), luiLuiRelFoRg.getRelatedLuiId(), luiLuiRelFoRg.getTypeKey(), luiLuiRelFoRg, context);
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }

        // build the lui lui relation RG-AO
        for (String aoId : registrationGroupInfo.getActivityOfferingIds()) {
            LuiLuiRelationInfo luiLuiRelRgAo = new LuiLuiRelationInfo();
            luiLuiRelRgAo.setLuiId(lui.getId());
            luiLuiRelRgAo.setName("rg-ao-relation"); // TODO: This fixes a DB required field error--find more meaningful value.
            luiLuiRelRgAo.setRelatedLuiId(aoId);

            RichTextInfo descrRgAo = new RichTextInfo();
            descrRgAo.setPlain(coCode + "-RG-AO"); // Useful for debugging
            descrRgAo.setFormatted(coCode + "-RG-AO"); // Useful for debugging
            luiLuiRelRgAo.setDescr(descrRgAo);

            luiLuiRelRgAo.setTypeKey(LuiServiceConstants.LUI_LUI_RELATION_REGISTERED_FOR_VIA_RG_TO_AO_TYPE_KEY);
            luiLuiRelRgAo.setStateKey(LuiServiceConstants.LUI_LUI_RELATION_ACTIVE_STATE_KEY);
            luiLuiRelRgAo.setEffectiveDate(new Date());
            try {
                luiLuiRelRgAo = luiService.createLuiLuiRelation(luiLuiRelRgAo.getLuiId(), luiLuiRelRgAo.getRelatedLuiId(), luiLuiRelRgAo.getTypeKey(), luiLuiRelRgAo, context);
            } catch (Exception ex) {
                throw new OperationFailedException("unexpected", ex);
            }
        }

        // Everything saved to the DB, now return RG sent back by createLui and transformed by transformer back to caller
        RegistrationGroupInfo rgInfo = new RegistrationGroupInfo();
        rgInfo = registrationGroupTransformer.lui2Rg(lui, context);
        rgInfo.setCourseOfferingId(coInfo.getId());
        rgInfo.setRegistrationCode(registrationGroupInfo.getRegistrationCode());
        return rgInfo;
    }

    public RoomService getRoomService() {
        if (roomService == null){
            roomService = (RoomService)GlobalResourceLoader.getService(new QName(RoomServiceConstants.NAMESPACE,
                    RoomServiceConstants.SERVICE_NAME_LOCAL_PART));
        }
        return roomService;
    }

    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    public CriteriaLookupService getCriteriaLookupService() {
        return criteriaLookupService;
    }

    public void setCriteriaLookupService(CriteriaLookupService criteriaLookupService) {
        this.criteriaLookupService = criteriaLookupService;
    }

    public LuiService getLuiService() {
        return luiService;
    }

    public void setLuiService(LuiService luiService) {
        this.luiService = luiService;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public AcademicCalendarService getAcalService() {
        return acalService;
    }

    public void setAcalService(AcademicCalendarService acalService) {
        this.acalService = acalService;
    }

    public RegistrationGroupAssembler getRgAssembler() {
        return registrationGroupAssembler;
    }

    public void setRgAssembler(RegistrationGroupAssembler rgAssembler) {
        this.registrationGroupAssembler = rgAssembler;
    }

    public StateService getStateService() {
        return stateService;
    }

    public void setStateService(StateService stateService) {
        this.stateService = stateService;
    }

    public LprService getLprService() {
        return lprService;
    }

    public void setLprService(LprService lprService) {
        this.lprService = lprService;
    }

    public SeatPoolDefinitionDao getSeatPoolDefinitionDao() {
        return seatPoolDefinitionDao;
    }

    public void setSeatPoolDefinitionDao(SeatPoolDefinitionDao seatPoolDefinitionDao) {
        this.seatPoolDefinitionDao = seatPoolDefinitionDao;
    }

    public ActivityOfferingClusterDao getActivityOfferingClusterDao() {
        return activityOfferingClusterDao;
    }

    public void setActivityOfferingClusterDao(ActivityOfferingClusterDao activityOfferingClusterDao) {
        this.activityOfferingClusterDao = activityOfferingClusterDao;
    }

    @Override
    @Transactional(readOnly = true)
    public CourseOfferingInfo getCourseOffering(String courseOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        LuiInfo lui = luiService.getLui(courseOfferingId, context);
        CourseOfferingInfo co = new CourseOfferingInfo();

        //Associate instructors to the given CO
        courseOfferingTransformer.lui2CourseOffering(lui, co, context);
        courseOfferingTransformer.assembleInstructors(co, lui.getId(), context, getLprService());

        return co;
    }

    @Override
    @Transactional(readOnly = true)
    public CourseOfferingDisplayInfo getCourseOfferingDisplay(String courseOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        CourseOfferingInfo coInfo = getCourseOffering(courseOfferingId, context);
        CourseOfferingDisplayInfo displayInfo =
                CourseOfferingDisplayTransformer.co2coDisplay(coInfo, atpService, stateService, typeService, lrcService, context);

        return displayInfo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseOfferingDisplayInfo> getCourseOfferingDisplaysByIds(List<String> courseOfferingIds, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<CourseOfferingInfo> coList = getCourseOfferingsByIds(courseOfferingIds, context);
        List<CourseOfferingDisplayInfo> displayList = new ArrayList<CourseOfferingDisplayInfo>();
        if (coList != null) {
            for (CourseOfferingInfo coInfo: coList) {
                CourseOfferingDisplayInfo displayInfo =
                        CourseOfferingDisplayTransformer.co2coDisplay(coInfo, atpService, stateService, typeService, lrcService, context);
                displayList.add(displayInfo);
            }
        }
        return displayList;
    }

    @Override
    @Transactional(readOnly = true)
    public ActivityOfferingDisplayInfo getActivityOfferingDisplay(String activityOfferingId, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        ActivityOfferingInfo aoInfo = getActivityOffering(activityOfferingId, contextInfo);
        // TODO: Once scheduling service is wired in, replace null below
        ActivityOfferingDisplayInfo displayInfo =
                ActivityOfferingDisplayTransformer.ao2aoDisplay(aoInfo, schedulingService, stateService, typeService, contextInfo);
        return displayInfo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityOfferingDisplayInfo> getActivityOfferingDisplaysByIds(List<String> activityOfferingIds, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        // For now, just do it simply
        List<ActivityOfferingDisplayInfo> displayInfos = new ArrayList<ActivityOfferingDisplayInfo>();
        for (String id: activityOfferingIds) {
            ActivityOfferingDisplayInfo displayInfo = getActivityOfferingDisplay(id, contextInfo);
            displayInfos.add(displayInfo);
        }
        return displayInfos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityOfferingDisplayInfo> getActivityOfferingDisplaysForCourseOffering(String courseOfferingId, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        // Straight-forward implementation--might not be fully optimized
        List<ActivityOfferingInfo> aoInfos = getActivityOfferingsByCourseOffering(courseOfferingId, contextInfo);
        List<ActivityOfferingDisplayInfo> aoDisplayInfos = new ArrayList<ActivityOfferingDisplayInfo>();
        for (ActivityOfferingInfo aoInfo: aoInfos) {
            ActivityOfferingDisplayInfo aoDisplayInfo =
                    ActivityOfferingDisplayTransformer.ao2aoDisplay(aoInfo, schedulingService, stateService, typeService, contextInfo);
            aoDisplayInfos.add(aoDisplayInfo);
        }
        return aoDisplayInfos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseOfferingInfo> getCourseOfferingsByIds(List<String> courseOfferingIds, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {

        List<CourseOfferingInfo> results = new ArrayList<CourseOfferingInfo>();

        if(courseOfferingIds != null && !courseOfferingIds.isEmpty()){
            List<LuiInfo> luiInfos = getLuiService().getLuisByIds(courseOfferingIds, context);

            for (LuiInfo lui : luiInfos) {
                CourseOfferingInfo co = new CourseOfferingInfo();
                //Associate instructors to the given CO
                courseOfferingTransformer.lui2CourseOffering(lui, co, context);

                //TODO: assembleInstructors is not efficient. LPR needs a getLPRsByLuiIds
                courseOfferingTransformer.assembleInstructors(co, lui.getId(), context, getLprService());
                results.add(co);
            }
        }

        return results;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseOfferingInfo> getCourseOfferingsByCourse(String courseId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        List<String> luiIds = luiService.getLuiIdsByClu(courseId, context);
        List<CourseOfferingInfo> results = new ArrayList<CourseOfferingInfo>();
        for (String luiId : luiIds) {
            CourseOfferingInfo co = getCourseOffering(luiId, context);
            results.add(co);
        }
        return results;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseOfferingInfo> getCourseOfferingsByCourseAndTerm(String courseId, String termId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        // check the term is valid
        acalService.getTerm(termId, context);
        List<String> luiIds = luiService.getLuiIdsByAtpAndType(termId, LuiServiceConstants.COURSE_OFFERING_TYPE_KEY, context);
        List<CourseOfferingInfo> results = new ArrayList<CourseOfferingInfo>();

        for (String luiId : luiIds) {
            CourseOfferingInfo co = getCourseOffering(luiId, context);

            if (StringUtils.equals(co.getCourseId(), courseId)) {
                results.add(co);
            }
        }
        return results;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getCourseOfferingIdsByTerm(String termId, Boolean useIncludedTerm, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        this.acalService.getTerm(termId, context); // check term exists
        List<String> luiIds = luiService.getLuiIdsByAtpAndType(termId, LuiServiceConstants.COURSE_OFFERING_TYPE_KEY, context);
        return luiIds;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getCourseOfferingIdsByTermAndSubjectArea(String termId, String subjectArea, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {

        QueryByCriteria.Builder qbcBuilder = QueryByCriteria.Builder.create();
        qbcBuilder.setPredicates(PredicateFactory.equal("atpId", termId),
                PredicateFactory.equal("luiType", LuiServiceConstants.COURSE_OFFERING_TYPE_KEY),
                PredicateFactory.equalIgnoreCase("subjectArea", subjectArea));

        QueryByCriteria criteria = qbcBuilder.build();

        GenericQueryResults<LuiEntity> results = criteriaLookupService.lookup(LuiEntity.class, criteria);
        List<String> ids = new ArrayList<String>(results.getResults().size());
        for (LuiEntity lui : results.getResults()) {
            ids.add(lui.getId());
        }
        return ids;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseOfferingInfo> getCourseOfferingsByTermAndInstructor(String termId, String instructorId, ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<LprInfo> lprInfos = lprService.getLprsByPersonAndTypeForAtp(instructorId, termId, LprServiceConstants.INSTRUCTOR_MAIN_TYPE_KEY, context);
        List<CourseOfferingInfo> cos = new ArrayList<CourseOfferingInfo>();
        for (LprInfo lprInfo : lprInfos) {
            cos.add(getCourseOffering(lprInfo.getLuiId(), context));
        }
        return cos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getCourseOfferingIdsByTermAndUnitsContentOwner(String termId, String unitsContentOwnerId,
                                                                       ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        //TODO: use custom search
        List<String> luiIds = luiService.getLuiIdsByAtpAndType(termId, LuiServiceConstants.COURSE_OFFERING_TYPE_KEY, context);
        List<String> results = new ArrayList<String>();

        for (String luiId : luiIds) {
            CourseOfferingInfo co = getCourseOffering(luiId, context);

            if (co.getUnitsContentOwnerOrgIds().contains(unitsContentOwnerId)) {
                results.add(luiId);
            }
        }

        return results;

    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getCourseOfferingIdsByType(String typeKey, ContextInfo context) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new OperationFailedException("not implemented");
    }

    //TODO This method does not override anything why is it here?
    @Transactional(readOnly = true)
    public List<String> getCourseOfferingIdsByTermAndUnitContentOwner(String termKey, String unitOwnerId,
                                                                      ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new OperationFailedException("not implemented");
    }

    //TODO This method does not override anything why is it here?
    @Transactional(readOnly = true)
    public List<CourseOfferingInfo> getCourseOfferingsBySoc(String s, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new OperationFailedException("not implemented");
    }

    //TODO This method does not override anything why is it here?
    @Transactional(readOnly = true)
    public List<CourseOfferingInfo> getPublishedCourseOfferingsBySoc(String s, ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new OperationFailedException("not implemented");
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getValidCanonicalCourseToCourseOfferingOptionKeys(ContextInfo context) throws InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getValidRolloverOptionKeys(ContextInfo context) throws InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public SocRolloverResultItemInfo rolloverCourseOffering(String sourceCourseOfferingId, String targetTermId, List<String> optionKeys, ContextInfo context) throws AlreadyExistsException,
            DataValidationErrorException, DoesNotExistException, DataValidationErrorException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return this.businessLogic.rolloverCourseOffering(sourceCourseOfferingId, targetTermId, optionKeys, context);
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public CourseOfferingInfo createCourseOffering(String courseId, String termId, String courseOfferingTypeKey,
                                                   CourseOfferingInfo coInfo,
                                                   List<String> optionKeys, ContextInfo context)
            throws DoesNotExistException, DataValidationErrorException,
            InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException, ReadOnlyException {

        // validate params
        if (!courseId.equals(coInfo.getCourseId())) {
            throw new InvalidParameterException(courseId + " does not match the corresponding value in the object " + coInfo.getCourseId());
        }
        if (!termId.equals(coInfo.getTermId())) {
            throw new InvalidParameterException(termId + " does not match the corresponding value in the object " + coInfo.getTermId());
        }
        if (!courseOfferingTypeKey.equals(coInfo.getTypeKey())) {
            throw new InvalidParameterException(courseOfferingTypeKey + " does not match the corresponding value in the object " + coInfo.getTypeKey());
        }
        // check the term and course
        TermInfo term = acalService.getTerm(termId, context);
        CourseInfo courseInfo = _getCourse(courseId);
        // copy from canonical
        CourseOfferingTransformer coTransformer = new CourseOfferingTransformer();
        coTransformer.copyFromCanonical(courseInfo, coInfo, optionKeys, context);
        //generate internal suffix code
        List<CourseOfferingInfo> existingCourseOfferings = _findCourseOfferingsByTermAndCourseCode(term.getId(), courseInfo.getCode());
        String internalSufx = offeringCodeGenerator.generateCourseOfferingInternalCode(existingCourseOfferings);
        coInfo.setCourseNumberInternalSuffix(internalSufx);
        if (coInfo.getCourseNumberSuffix() != null && !coInfo.getCourseNumberSuffix().isEmpty()) {
            coInfo.setCourseOfferingCode(courseInfo.getCode() + coInfo.getCourseNumberSuffix());
        }
        if (optionKeys.contains(CourseOfferingServiceConstants.APPEND_COURSE_OFFERING_IN_SUFFIX_OPTION_KEY)) {
            coInfo.setCourseNumberSuffix(internalSufx);
            coInfo.setCourseOfferingCode(courseInfo.getCode() + internalSufx);
        }
        // copy to lui
        LuiInfo lui = new LuiInfo();
        coTransformer.courseOffering2Lui(coInfo, lui, context);
        // create it
        lui = luiService.createLui(courseId, termId, lui.getTypeKey(), lui, context);
        // transform it back to a course offering
        CourseOfferingInfo createdCo = new CourseOfferingInfo();
        new CourseOfferingTransformer().lui2CourseOffering(lui, createdCo, context);
        return createdCo;
    }

    private List<CourseOfferingInfo> _findCourseOfferingsByTermAndCourseCode(String termId, String courseCode)
            throws InvalidParameterException, MissingParameterException, PermissionDeniedException, OperationFailedException {
        List<CourseOfferingInfo> courseOfferings = new ArrayList<CourseOfferingInfo>();
        if (StringUtils.isNotBlank(courseCode) && StringUtils.isNotBlank(termId)) {
            QueryByCriteria.Builder qbcBuilder = QueryByCriteria.Builder.create();
            qbcBuilder.setPredicates(PredicateFactory.and(
                    PredicateFactory.like("courseOfferingCode", courseCode + "%"),
                    PredicateFactory.equalIgnoreCase("atpId", termId)));
            QueryByCriteria criteria = qbcBuilder.build();

            //Do search. In ideal case, returns one element, which is the desired CO.
            courseOfferings = searchForCourseOfferings(criteria, new ContextInfo());
        }
        return courseOfferings;
    }

    private CourseInfo _getCourse(String courseId) throws DoesNotExistException, OperationFailedException {
        R1CourseServiceHelper helper = new R1CourseServiceHelper(courseService, acalService);
        CourseInfo courseInfo = helper.getCourse(courseId);
        return courseInfo;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public CourseOfferingInfo updateCourseOffering(String courseOfferingId, CourseOfferingInfo coInfo, ContextInfo context)
            throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException,
            ReadOnlyException, VersionMismatchException {
        if (!courseOfferingId.equals(coInfo.getId())) {
            throw new InvalidParameterException(courseOfferingId + " does not match the corresponding value in the object " + coInfo.getId());
        }

        // get the backing lui
        LuiInfo lui = luiService.getLui(courseOfferingId, context);
        // copy fields and update
        courseOfferingTransformer.courseOffering2Lui(coInfo, lui, context);

        // Update lprs for offering instructors
        List<OfferingInstructorInfo> existingLprs = OfferingInstructorTransformer.lprs2Instructors(lprService.getLprsByLui(lui.getId(), context));
        // map existing lprs to their person id
        Map<String, OfferingInstructorInfo> existingPersonMap = new HashMap<String, OfferingInstructorInfo>(existingLprs.size());
        for (OfferingInstructorInfo info : existingLprs) {
            if (info.getStateKey() != null && info.getStateKey().equals(LprServiceConstants.DROPPED_STATE_KEY)) {
                continue;
            }
            existingPersonMap.put(info.getPersonId(), info);
        }

        List<OfferingInstructorInfo> createdInstructors = new ArrayList<OfferingInstructorInfo>();
        List<OfferingInstructorInfo> updatedInstructors = new ArrayList<OfferingInstructorInfo>();

        for (OfferingInstructorInfo instructor : coInfo.getInstructors()) {
            // if there is no id, it's a new Lpr
            if (instructor.getId() == null) {
                createdInstructors.add(instructor);
            }
            // if the Lpr already exists, update it
            else if (existingPersonMap.containsKey(instructor.getPersonId())) {
                updatedInstructors.add(instructor);
                // remove the found entry from the existing map, to build the list of existing lprs to delete
                existingPersonMap.remove(instructor.getPersonId());
            }
        }

        // the instructor objects remaining in the existing map should be marked for deletion,
        // since they were not found in the current list of instructors
        Collection<OfferingInstructorInfo> deletedInstructors = existingPersonMap.values();

        // create the new lprs
        List<LprInfo> createdLprs = OfferingInstructorTransformer.instructors2Lprs(lui, createdInstructors);
        for (LprInfo lprInfo : createdLprs) {
            lprService.createLpr(lprInfo.getPersonId(), lprInfo.getLuiId(), lprInfo.getTypeKey(), lprInfo, context);
        }

        // update existing lprs
        List<LprInfo> updatedLprs = OfferingInstructorTransformer.instructors2Lprs(lui, updatedInstructors);
        for (LprInfo lprInfo : updatedLprs) {
            lprService.updateLpr(lprInfo.getId(), lprInfo, context);
        }

        // delete removed lprs
        for (OfferingInstructorInfo instructorInfo : deletedInstructors) {
            lprService.deleteLpr(instructorInfo.getId(), context);
        }


        lui = luiService.updateLui(courseOfferingId, lui, context);
        // convert back to co and return
        CourseOfferingInfo co = new CourseOfferingInfo();
        courseOfferingTransformer.lui2CourseOffering(lui, co, context);
        return co;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public CourseOfferingInfo updateCourseOfferingFromCanonical(String courseOfferingId,
                                                                List<String> optionKeys,
                                                                ContextInfo context)
            throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException,
            VersionMismatchException {
        return this.businessLogic.updateCourseOfferingFromCanonical(courseOfferingId, optionKeys, context);
    }

    private void _processInstructors(String courseOfferingId, List<OfferingInstructorInfo> instructors, String atpId, ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, DataValidationErrorException, VersionMismatchException {

        List<String> currrentInstructors = lprService.getPersonIdsByLuiAndTypeAndState(courseOfferingId, LprServiceConstants.INSTRUCTOR_MAIN_TYPE_KEY,
                LprServiceConstants.ASSIGNED_STATE_KEY, context);


        if (instructors != null && !instructors.isEmpty()) {
            for (OfferingInstructorInfo instructor : instructors) {
                try {
                    if (currrentInstructors.contains(instructor.getPersonId())) {
                        LprInfo existingLpr = _getLpr(instructor.getPersonId(), courseOfferingId, context);
                        if (existingLpr != null) {
                            if (instructor.getPercentageEffort() != null) {
                                existingLpr.setCommitmentPercent("" + instructor.getPercentageEffort());
                            } else {
                                existingLpr.setCommitmentPercent(null);
                            }
                            lprService.updateLpr(existingLpr.getId(), existingLpr, context);
                            currrentInstructors.remove(instructor.getPersonId());
                        }
                    } else {
                        lprService.createLpr(instructor.getPersonId(), courseOfferingId, instructor.getTypeKey(), _getNewLpr(instructor, courseOfferingId), context);
                    }
                } catch (ReadOnlyException e) {
                    throw new OperationFailedException();
                }
            }
        }

        if (currrentInstructors != null && currrentInstructors.size() > 0) {
            if (atpId != null) {
                for (String instructorId : currrentInstructors) {
                    LprInfo lpr = _getLpr(instructorId, courseOfferingId, context);
                    if (lpr != null) {
                        lprService.deleteLpr(lpr.getId(), context);
                    }
                }
            }
        }
    }

    private LprInfo _getNewLpr(OfferingInstructorInfo instructor, String courseOfferingId) {
        LprInfo lpr = new LprInfo();
        lpr.setPersonId(instructor.getPersonId());
        if (instructor.getPercentageEffort() != null) {
            lpr.setCommitmentPercent("" + instructor.getPercentageEffort());
        } else {
            lpr.setCommitmentPercent(null);
        }
        lpr.setId(UUIDHelper.genStringUUID());
        lpr.setLuiId(courseOfferingId);
        lpr.setTypeKey(instructor.getTypeKey());
        lpr.setStateKey(instructor.getStateKey());
        return lpr;
    }

    private LprInfo _getLpr(String instructor, String courseOfferingId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        LprInfo lpr = null;
        List<LprInfo> lprs = lprService.getLprsByPersonAndLui(instructor, courseOfferingId, context);

        if (lprs != null && !lprs.isEmpty()) {
            for (LprInfo lpri : lprs) {
                if (lpri.getTypeKey().equals(LprServiceConstants.INSTRUCTOR_MAIN_TYPE_KEY)) {
                    lpr = lpri;
                }
            }
        }
        return lpr;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteCourseOffering(String courseOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        try {
            return luiService.deleteLui(courseOfferingId, context);
        } catch (DependentObjectsExistException e) {
            throw new OperationFailedException("Error deleting course offering", e);
        }
    }

    @Override
    public List<ValidationResultInfo> validateCourseOffering(String validationType, CourseOfferingInfo courseOfferingInfo,
                                                             ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException {
        return new ArrayList<ValidationResultInfo>();
    }

    @Override
    public List<ValidationResultInfo> validateCourseOfferingFromCanonical(CourseOfferingInfo courseOfferingInfo,
                                                                          List<String> optionKeys,
                                                                          ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException {
        return this.businessLogic.validateCourseOfferingFromCanonical(courseOfferingInfo, optionKeys, context);
    }

    @Override
    @Transactional(readOnly = true)
    public FormatOfferingInfo getFormatOffering(String formatOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {

        LuiInfo lui = luiService.getLui(formatOfferingId, context);
        FormatOfferingInfo fo = new FormatOfferingInfo();
        new FormatOfferingTransformer().lui2Format(lui, fo);
        LuiInfo coLui = this._findCourseOfferingLui(lui.getId(), context);
        fo.setCourseOfferingId(coLui.getId());
        return fo;
    }

    private LuiInfo _findCourseOfferingLui(String formatOfferingId, ContextInfo context)
            throws OperationFailedException {
        List<LuiInfo> rels;
        try {
            rels = luiService.getLuisByRelatedLuiAndRelationType(formatOfferingId,
                    LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_CO_TO_FO_TYPE_KEY, context);
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }
        for (LuiInfo lui : rels) {
            if (lui.getTypeKey().equals(LuiServiceConstants.COURSE_OFFERING_TYPE_KEY)) {
                return lui;
            }
        }
        throw new OperationFailedException("format offering is not associated with a course offering " + formatOfferingId + " among " + rels.size());
    }

    private LuiInfo _findFormatOfferingLui(String activityOfferingId, ContextInfo context)
            throws OperationFailedException {
        List<LuiInfo> rels;
        try {
            rels = luiService.getLuisByRelatedLuiAndRelationType(activityOfferingId, LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_FO_TO_AO_TYPE_KEY, context);
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }
        for (LuiInfo lui : rels) {
            if (LuiServiceConstants.isFormatOfferingTypeKey(lui.getTypeKey())) {
                return lui;
            }
        }
        throw new OperationFailedException("format offering is not associated with a course offering " + activityOfferingId + " among " + rels.size());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatOfferingInfo> getFormatOfferingsByCourseOffering(String courseOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {

        List<FormatOfferingInfo> formatOfferings = new ArrayList<FormatOfferingInfo>();

        // Find all related luis to the course Offering
        List<LuiInfo> luis = luiService.getRelatedLuisByLuiAndRelationType(courseOfferingId, LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_CO_TO_FO_TYPE_KEY, context);
        for (LuiInfo lui : luis) {
            // Filter out only course offerings (the relation type seems to vague to only hold format offerings)
            if (LuiServiceConstants.isFormatOfferingTypeKey(lui.getTypeKey())) {
                FormatOfferingInfo formatOffering = new FormatOfferingInfo();
                new FormatOfferingTransformer().lui2Format(lui, formatOffering);
                formatOffering.setCourseOfferingId(courseOfferingId);
                formatOfferings.add(formatOffering);
            }
        }
        return formatOfferings;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteFormatOffering(String formatOfferingId, ContextInfo context) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, DependentObjectsExistException {

        return luiService.deleteLui(formatOfferingId, context);

    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public FormatOfferingInfo updateFormatOffering(String formatOfferingId, FormatOfferingInfo formatOfferingInfo, ContextInfo context)
            throws DataValidationErrorException, DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        // get the existing
        LuiInfo lui = this.luiService.getLui(formatOfferingId, context);
        // transform and update
        new FormatOfferingTransformer().format2Lui(formatOfferingInfo, lui);
        lui = luiService.updateLui(formatOfferingId, lui, context);
        // rebuild the fo to return it
        FormatOfferingInfo fo = new FormatOfferingInfo();
        new FormatOfferingTransformer().lui2Format(lui, fo);
        LuiInfo coLui = this._findCourseOfferingLui(formatOfferingId, context);
        fo.setCourseOfferingId(coLui.getId());
        return fo;
    }

    @Override
    public List<ValidationResultInfo> validateFormatOffering(String validationType, FormatOfferingInfo formatOfferingInfo,
                                                             ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException {
        return new ArrayList<ValidationResultInfo>();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public FormatOfferingInfo createFormatOffering(String courseOfferingId, String formatId, String formatOfferingType, FormatOfferingInfo foInfo, ContextInfo context)
            throws DoesNotExistException, DataValidationErrorException,
            InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException, ReadOnlyException {

        // validate params
        if (!courseOfferingId.equals(foInfo.getCourseOfferingId())) {
            throw new InvalidParameterException(courseOfferingId + " does not match the corresponding value in the object " + foInfo.getCourseOfferingId());
        }
        if (!formatId.equals(foInfo.getFormatId())) {
            throw new InvalidParameterException(formatId + " does not match the corresponding value in the object " + foInfo.getFormatId());
        }
        if (!formatOfferingType.equals(foInfo.getTypeKey())) {
            throw new InvalidParameterException(formatOfferingType + " does not match the corresponding value in the object " + foInfo.getTypeKey());
        }
        // get the course offering
        CourseOfferingInfo co = this.getCourseOffering(courseOfferingId, context);
        if (foInfo.getTermId() != null) {
            if (!co.getTermId().equals(foInfo.getTermId())) {
                throw new InvalidParameterException(foInfo.getTermId() + " term in the format offering does not match the one in the course offering " + co.getTermId());
            }
        }
        foInfo.setTermId(co.getTermId());

        // get formatId out of the course
        CourseInfo course = this._getCourse(co.getCourseId()); // make sure it exists
        FormatInfo format = null;
        for (FormatInfo info : course.getFormats()) {
            if (info.getId().equals(formatId)) {
                format = info;
                break;
            }
        }
        if (format == null) {
            throw new DoesNotExistException(formatId);
        }
        // copy to lui
        LuiInfo lui = new LuiInfo();
        new FormatOfferingTransformer().format2Lui(foInfo, lui);

        try {
            lui = luiService.createLui(lui.getCluId(), lui.getAtpId(), lui.getTypeKey(), lui, context);
        } catch (Exception aee) {
            throw new OperationFailedException("Unexpected", aee);
        }
        // now connect it to the course offering lui
        LuiLuiRelationInfo luiRel = new LuiLuiRelationInfo();
        luiRel.setLuiId(courseOfferingId);
        luiRel.setName("co-fo-relation"); // TODO: This fixes a DB required field error--find more meaningful value.
        RichTextInfo descr = new RichTextInfo();
        String coCode = co.getCourseOfferingCode();
        if (coCode == null) {
            coCode = "NOCODE";
        }
        descr.setPlain(coCode + "-CO-FO"); // Useful for debugging
        descr.setFormatted(coCode + "-CO-FO"); // Useful for debugging
        luiRel.setDescr(descr);
        luiRel.setRelatedLuiId(lui.getId());
        luiRel.setStateKey(LuiServiceConstants.LUI_LUI_RELATION_ACTIVE_STATE_KEY);
        luiRel.setTypeKey(LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_CO_TO_FO_TYPE_KEY);
        luiRel.setEffectiveDate(new Date());
        try {
            luiRel = luiService.createLuiLuiRelation(luiRel.getLuiId(), luiRel.getRelatedLuiId(), luiRel.getTypeKey(), luiRel, context);
        } catch (Exception aee) {
            throw new OperationFailedException("Unexpected", aee);
        }
        // rebuild to return it
        FormatOfferingInfo formatOffering = new FormatOfferingInfo();
        new FormatOfferingTransformer().lui2Format(lui, formatOffering);
        formatOffering.setCourseOfferingId(luiRel.getLuiId());
        return formatOffering;
    }

    @Override
    public TypeInfo getActivityOfferingType(String activityOfferingTypeKey, ContextInfo context) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return typeService.getType(activityOfferingTypeKey, context);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeInfo> getActivityOfferingTypes(ContextInfo context) throws InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        try {
            return typeService.getTypesForGroupType(LuiServiceConstants.ACTIVITY_OFFERING_GROUP_TYPE_KEY, context);
        } catch (DoesNotExistException e) {
            throw new OperationFailedException("Invalid group type used to retrieve Activity Offering Types: " + LuiServiceConstants.ACTIVITY_OFFERING_GROUP_TYPE_KEY);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeInfo> getActivityOfferingTypesForActivityType(String activityTypeKey, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        return typeService.getAllowedTypesForType(activityTypeKey, context);
    }

    @Override
    @Transactional(readOnly = true)
    public ActivityOfferingInfo getActivityOffering(String activityOfferingId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        LuiInfo lui = luiService.getLui(activityOfferingId, context);
        ActivityOfferingInfo ao = new ActivityOfferingInfo();
        ActivityOfferingTransformer.lui2Activity(ao, lui, lprService, schedulingService, context);

        _populateActivityOfferingRelationships(ao, context);
        return ao;
    }

    private void _populateActivityOfferingRelationships(ActivityOfferingInfo ao, ContextInfo context) throws OperationFailedException, DoesNotExistException, InvalidParameterException, MissingParameterException, PermissionDeniedException {
        String foId = context.getAttributeValue("FOId");
        String foShortName;
        String coId;
        String coCode;
        String coLongName;

        //Pull values from the context so we don't have to look them up if they are known ahead of time
        if(foId == null){
            LuiInfo foLui = this._findFormatOfferingLui(ao.getId(), context);
            LuiInfo coLui = this._findCourseOfferingLui(foLui.getId(), context);
            foId = foLui.getId();
            foShortName = foLui.getOfficialIdentifier() == null ? null : foLui.getOfficialIdentifier().getShortName();
            coId = coLui.getId();
            coCode = coLui.getOfficialIdentifier().getCode();
            coLongName = coLui.getOfficialIdentifier().getLongName();
        }else{
            foShortName = context.getAttributeValue("FOShortName");
            coId = context.getAttributeValue("COId");
            coCode = context.getAttributeValue("COCode");
            coLongName = context.getAttributeValue("COLongName");
        }

        ao.setFormatOfferingId(foId);
        ao.setCourseOfferingId(coId);
        ao.setFormatOfferingName(foShortName);
        ao.setCourseOfferingCode(coCode);
        ao.setCourseOfferingTitle(coLongName);

        AtpInfo termAtp = getAtpService().getAtp(ao.getTermId(), context);
        ao.setTermCode(termAtp.getCode());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityOfferingInfo> getActivityOfferingsByIds(List<String> strings, ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        List<ActivityOfferingInfo> results = new ArrayList<ActivityOfferingInfo>();

        if(strings != null && !strings.isEmpty()){
            List<LuiInfo> luiInfos = getLuiService().getLuisByIds(strings, contextInfo);

            for (LuiInfo lui : luiInfos) {
                ActivityOfferingInfo ao = new ActivityOfferingInfo();
                ActivityOfferingTransformer.lui2Activity(ao, lui, lprService, schedulingService, contextInfo);
                _populateActivityOfferingRelationships(ao, contextInfo);
                results.add(ao);
            }
        }

        return results;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityOfferingInfo> getActivityOfferingsByCourseOffering(String courseOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException,
            PermissionDeniedException {

        List<ActivityOfferingInfo> list = new ArrayList<ActivityOfferingInfo>();
        List<FormatOfferingInfo> formats = this.getFormatOfferingsByCourseOffering(courseOfferingId, context);
        for (FormatOfferingInfo fo : formats) {
            List<ActivityOfferingInfo> activities = this.getActivityOfferingsByFormatOffering(fo.getId(), context);
            list.addAll(activities);
        }
        return list;
    }

    private boolean _isActivityType(String luiTypeKey, ContextInfo context) throws InvalidParameterException, MissingParameterException, DoesNotExistException, PermissionDeniedException, OperationFailedException {

        if (luiTypeKey == null) {
            return false;
        }

        if (luiTypeKey.startsWith(LuiServiceConstants.ACTIVITY_OFFERING_TYPE_KEY_PREFIX)) {

            List<TypeInfo> aoTypes = typeService.getTypesForGroupType(LuiServiceConstants.ACTIVITY_OFFERING_GROUP_TYPE_KEY, context);

            for (TypeInfo typeInfo : aoTypes) {
                if (typeInfo.getKey().equals(luiTypeKey)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityOfferingInfo> getActivityOfferingsByFormatOffering(String formatOfferingId, ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<ActivityOfferingInfo> activityOfferings = new ArrayList<ActivityOfferingInfo>();

        // Find all related luis to the course Offering
        List<LuiInfo> luis = luiService.getRelatedLuisByLuiAndRelationType(formatOfferingId, LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_FO_TO_AO_TYPE_KEY, contextInfo);
        for (LuiInfo lui : luis) {

            //Filter out only course offerings (the relation type seems to vague to only hold format offerings)
            if (_isActivityType(lui.getTypeKey(), contextInfo)) {
                ActivityOfferingInfo activityOffering = new ActivityOfferingInfo();
                ActivityOfferingTransformer.lui2Activity(activityOffering, lui, lprService, schedulingService, contextInfo);
                _populateActivityOfferingRelationships(activityOffering, contextInfo);
                activityOfferings.add(activityOffering);
            }
        }
        Collections.sort(activityOfferings, new Comparator<ActivityOfferingInfo>() {
            @Override
            public int compare(ActivityOfferingInfo o1, ActivityOfferingInfo o2) {
                if (o1.getActivityCode() == null) {
                    return 1;
                } else if (o2.getActivityCode() == null) {
                    return -1;
                } else {
                    return o1.getActivityCode().compareTo(o2.getActivityCode());
                }
            }
        });
        return activityOfferings;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityOfferingInfo> getActivityOfferingsWithoutClusterByFormatOffering(String formatOfferingId,
                                                                                         ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        // TODO: A naive implementation first so we can get some work done now.
        List<ActivityOfferingClusterInfo> clusters =
                getActivityOfferingClustersByFormatOffering(formatOfferingId, contextInfo);
        Set<String> aoIdsInClusters = new HashSet<String>();
        // For each cluster, find all AOs associated with it
        for (ActivityOfferingClusterInfo clusterInfo: clusters) {
            List<ActivityOfferingInfo> aoInfos = getActivityOfferingsByCluster(clusterInfo.getId(), contextInfo);
            for (ActivityOfferingInfo aoInfo: aoInfos) {
                // Add the ids to a set
                aoIdsInClusters.add(aoInfo.getId());
            }
        }
        List<ActivityOfferingInfo> aosNotInCluster = new ArrayList<ActivityOfferingInfo>();
        List<ActivityOfferingInfo> allAOs = getActivityOfferingsByFormatOffering(formatOfferingId, contextInfo);
        for (ActivityOfferingInfo aoInfo: allAOs) {
            if (!aoIdsInClusters.contains(aoInfo.getId())) { // if ID not in set, add the AO
                aosNotInCluster.add(aoInfo);
            }
        }
        return aosNotInCluster;
    }

    @Override
    public List<ActivityOfferingInfo> getActivityOfferingsByFormatOfferingWithoutRegGroup(String formatOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException();
    }


    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public ActivityOfferingInfo createActivityOffering(String formatOfferingId,
                                                       String activityId,
                                                       String activityOfferingTypeKey,
                                                       ActivityOfferingInfo aoInfo, ContextInfo context)
            throws DoesNotExistException, DataValidationErrorException,
            InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException,
            ReadOnlyException {

        // validate params
        if (!formatOfferingId.equals(aoInfo.getFormatOfferingId())) {
            throw new InvalidParameterException(formatOfferingId + " does not match the corresponding value in the object " + aoInfo.getFormatOfferingId());
        }
        if (!activityId.equals(aoInfo.getActivityId())) {
            throw new InvalidParameterException(activityId + " does not match the corresponding value in the object " + aoInfo.getActivityId());
        }
        if (!activityOfferingTypeKey.equals(aoInfo.getTypeKey())) {
            throw new InvalidParameterException(activityOfferingTypeKey + " does not match the corresponding value in the object " + aoInfo.getTypeKey());
        }


        // get the required objects checking they exist
        FormatOfferingInfo fo = this.getFormatOffering(formatOfferingId, context);
        CourseOfferingInfo co = this.getCourseOffering(fo.getCourseOfferingId(), context);
        if (aoInfo.getTermId() != null) {
            if (!aoInfo.getTermId().equals(fo.getTermId())) {
                throw new InvalidParameterException(aoInfo.getTermId() + " term in the activity offering does not match the one in the format offering " + fo.getTermId());
            }
        }
        aoInfo.setTermId(fo.getTermId());

        //AO Code generation logic

        //check that the passed in activity code does not already exist for that course offering
        List<ActivityOfferingInfo> existingAoInfos = getActivityOfferingsByCourseOffering(co.getId(), context);

        if (aoInfo.getActivityCode() == null) {
            //If there is no activity code, create a new one
            aoInfo.setActivityCode(offeringCodeGenerator.generateActivityOfferingCode(existingAoInfos));
        } else {
            for (ActivityOfferingInfo existingAoInfo : existingAoInfos) {
                if (aoInfo.getActivityCode().equals(existingAoInfo.getActivityCode())) {
                    throw new InvalidParameterException("Activity Offering Code '" + aoInfo.getActivityCode() + "' already exists for course code " + co.getCourseOfferingCode() + " term Id '" + co.getTermId() + "'");
                }
            }
        }

        // copy to the lui
        LuiInfo lui = new LuiInfo();
        ActivityOfferingTransformer.activity2Lui(aoInfo, lui);
        try {
            String cluId = lui.getCluId();
            String atpId = lui.getAtpId();
            String typeKey = lui.getTypeKey();
            lui = luiService.createLui(cluId, atpId, typeKey, lui, context);
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }

        // build LPR(s) for Offering Instructor
        List<LprInfo> lprs = OfferingInstructorTransformer.instructors2Lprs(lui, aoInfo.getInstructors());

        for (LprInfo lprInfo : lprs) {
            lprService.createLpr(lprInfo.getPersonId(), lprInfo.getLuiId(), lprInfo.getTypeKey(), lprInfo, context);
        }

        // now build the lui lui relation
        LuiLuiRelationInfo luiRel = new LuiLuiRelationInfo();
        luiRel.setLuiId(formatOfferingId);
        luiRel.setName("fo-ao-relation"); // TODO: This fixes a DB required field error--find more meaningful value.
        luiRel.setRelatedLuiId(lui.getId());
        RichTextInfo descr = new RichTextInfo();
        String coCode = aoInfo.getCourseOfferingCode();
        if (coCode == null) {
            coCode = "NOCODE";
        }
        descr.setPlain(coCode + "-FO-AO"); // Useful for debugging
        descr.setFormatted(coCode + "-FO-AO"); // Useful for debugging
        luiRel.setDescr(descr);
        luiRel.setTypeKey(LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_FO_TO_AO_TYPE_KEY);
        luiRel.setStateKey(LuiServiceConstants.LUI_LUI_RELATION_ACTIVE_STATE_KEY);
        luiRel.setEffectiveDate(new Date());
        try {
            luiRel = luiService.createLuiLuiRelation(luiRel.getLuiId(), luiRel.getRelatedLuiId(), luiRel.getTypeKey(), luiRel, context);
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }
        // Everything saved to the DB, now return AO sent back by createLui and transformed by transformer back to caller
        ActivityOfferingInfo ao = new ActivityOfferingInfo();
        ActivityOfferingTransformer.lui2Activity(ao, lui, lprService, schedulingService, context);
        ao.setFormatOfferingId(luiRel.getLuiId());
        ao.setCourseOfferingId(co.getId());
        ao.setFormatOfferingName(fo.getShortName());
        ao.setCourseOfferingCode(co.getCourseOfferingCode());
        ao.setCourseOfferingTitle(co.getCourseOfferingTitle());
        AtpService localAtpService = getAtpService();
        String aoTermId = ao.getTermId();
        AtpInfo termAtp = localAtpService.getAtp(aoTermId, context);
        ao.setTermCode(termAtp.getCode());
        return ao;

    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public ActivityOfferingInfo copyActivityOffering(String activityOfferingId, ContextInfo context) throws DoesNotExistException, DataValidationErrorException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        ActivityOfferingInfo sourceAO = getActivityOffering(activityOfferingId, context);
        ActivityOfferingInfo targetAO = new ActivityOfferingInfo(sourceAO);
        targetAO.setStateKey(LuiServiceConstants.LUI_AO_STATE_DRAFT_KEY);
        targetAO.setId(null);
        targetAO.setScheduleId(null);
        if (targetAO.getInstructors() != null && !targetAO.getInstructors().isEmpty()) {
            for (OfferingInstructorInfo inst : targetAO.getInstructors()) {
                inst.setId(null);
            }
        }
        targetAO.setActivityCode(null);
        targetAO = createActivityOffering(sourceAO.getFormatOfferingId(), sourceAO.getActivityId(), sourceAO.getTypeKey(), targetAO, context);

        // copy ADL from source AO to RDL in target AO
        if(sourceAO.getScheduleId() != null && !sourceAO.getScheduleId().isEmpty()) {
            // _RCO_rolloverScheduleToScheduleRequest(sourceAo, targetAo, context);
            ScheduleInfo sourceScheduleInfo = this.getSchedulingService().getSchedule(sourceAO.getScheduleId(), context);

            ScheduleRequestInfo targetScheduleRequest = SchedulingServiceUtil.scheduleToRequest(sourceScheduleInfo, getRoomService(), context);
            targetScheduleRequest.setRefObjectId(targetAO.getId());
            targetScheduleRequest.setRefObjectTypeKey(CourseOfferingServiceConstants.REF_OBJECT_URI_ACTIVITY_OFFERING);
            StringBuilder nameBuilder = new StringBuilder("Schedule reqeust for ");
            nameBuilder.append(targetAO.getCourseOfferingCode()).append(" - ").append(targetAO.getActivityCode());
            targetScheduleRequest.setName(nameBuilder.toString());
            targetScheduleRequest.setDescr(sourceScheduleInfo.getDescr());

            this.getSchedulingService().createScheduleRequest(targetScheduleRequest.getTypeKey(), targetScheduleRequest, context);
        }  else {
            // copy the source RDL to target RDL
            List<ScheduleRequestInfo> scheduleRequestInfoList =
                    getSchedulingService().getScheduleRequestsByRefObject(CourseOfferingServiceConstants.REF_OBJECT_URI_ACTIVITY_OFFERING, sourceAO.getId(), context);
            if (scheduleRequestInfoList != null && !scheduleRequestInfoList.isEmpty()) {
                for (ScheduleRequestInfo sourceRequestScheduleInfo : scheduleRequestInfoList) {
                    ScheduleRequestInfo targetScheduleRequest = SchedulingServiceUtil.scheduleRequestToScheduleRequest(sourceRequestScheduleInfo, context);
                    targetScheduleRequest.setRefObjectId(targetAO.getId());
                    targetScheduleRequest.setRefObjectTypeKey(CourseOfferingServiceConstants.REF_OBJECT_URI_ACTIVITY_OFFERING);
                    StringBuilder nameBuilder = new StringBuilder("Schedule reqeust for ");
                    nameBuilder.append(targetAO.getCourseOfferingCode()).append(" - ").append(targetAO.getActivityCode());
                    targetScheduleRequest.setName(nameBuilder.toString());
                    targetScheduleRequest.setDescr(sourceRequestScheduleInfo.getDescr());

                    this.getSchedulingService().createScheduleRequest(targetScheduleRequest.getTypeKey(), targetScheduleRequest, context);
                }
            }
        }

        try {
            List<SeatPoolDefinitionInfo> sourceSPList = getSeatPoolDefinitionsForActivityOffering(activityOfferingId, context);
            if (sourceSPList != null && !sourceSPList.isEmpty()) {
                for (SeatPoolDefinitionInfo sourceSP : sourceSPList) {
                    SeatPoolDefinitionInfo targetSP = new SeatPoolDefinitionInfo(sourceSP);
                    targetSP.setId(null);
                    targetSP.setTypeKey(LuiServiceConstants.SEATPOOL_LUI_CAPACITY_TYPE_KEY);
                    targetSP.setStateKey(LuiServiceConstants.LUI_CAPACITY_ACTIVE_STATE_KEY);
                    SeatPoolDefinitionInfo seatPoolCreated = this.createSeatPoolDefinition(targetSP, context);
                    this.addSeatPoolDefinitionToActivityOffering(seatPoolCreated.getId(), targetAO.getId(), context);

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Generate Registration Groups based on the copied AO
        //generateRegistrationGroupsForFormatOffering(targetAO.getFormatOfferingId(),context);

        return targetAO;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public List<ActivityOfferingInfo> generateActivityOfferings(String formatOfferingId, String activityOfferingType, Integer quantity, ContextInfo context) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new OperationFailedException("not implemented");
    }


    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public ActivityOfferingInfo updateActivityOffering(String activityOfferingId,
                                                       ActivityOfferingInfo activityOfferingInfo,
                                                       ContextInfo context)
            throws DataValidationErrorException,
            DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException,
            ReadOnlyException, VersionMismatchException {
        // validate params
        if (!activityOfferingId.equals(activityOfferingInfo.getId())) {
            throw new InvalidParameterException(activityOfferingId + " does not match the corresponding value in the object " + activityOfferingInfo.getId());
        }
        // get it
        LuiInfo lui = luiService.getLui(activityOfferingId, context);
        // TODO: check that the lui being updated is an activity not another kind of lui

        //Check that the lu code is unique. If it is a duplicate, do not change it
        List<ActivityOfferingInfo> existingAoInfos = getActivityOfferingsByCourseOffering(activityOfferingInfo.getCourseOfferingId(), context);
        boolean duplicateAoCode = false;
        for (ActivityOfferingInfo existingAoInfo : existingAoInfos) {
            if (activityOfferingInfo.getActivityCode().equals(existingAoInfo.getActivityCode())) {
                duplicateAoCode = true;
                break;
            }
        }
        if (!duplicateAoCode) {
            activityOfferingInfo.setActivityCode(lui.getOfficialIdentifier().getCode());
        }

        // copy to lui
        ActivityOfferingTransformer.activity2Lui(activityOfferingInfo, lui);

        // update lui
        lui = luiService.updateLui(activityOfferingId, lui, context);

        // Update lprs for offering instructors

        List<OfferingInstructorInfo> existingLprs = OfferingInstructorTransformer.lprs2Instructors(lprService.getLprsByLui(lui.getId(), context));
        // map existing lprs to their person id
        Map<String, OfferingInstructorInfo> existingPersonMap = new HashMap<String, OfferingInstructorInfo>(existingLprs.size());
        for (OfferingInstructorInfo info : existingLprs) {
            existingPersonMap.put(info.getPersonId(), info);
        }

        List<OfferingInstructorInfo> createdInstructors = new ArrayList<OfferingInstructorInfo>();
        List<OfferingInstructorInfo> updatedInstructors = new ArrayList<OfferingInstructorInfo>();

        for (OfferingInstructorInfo instructor : activityOfferingInfo.getInstructors()) {
            // if there is no id, it's a new Lpr
            if (instructor.getId() == null) {
                createdInstructors.add(instructor);
            }
            // if the Lpr already exists, update it
            else if (existingPersonMap.containsKey(instructor.getPersonId())) {
                updatedInstructors.add(instructor);
                // remove the found entry from the existing map, to build the list of existing lprs to delete
                existingPersonMap.remove(instructor.getPersonId());
            }
        }

        // the instructor objects remaining in the existing map should be marked for deletion,
        // since they were not found in the current list of instructors
        Collection<OfferingInstructorInfo> deletedInstructors = existingPersonMap.values();


        // create the new lprs
        List<LprInfo> createdLprs = OfferingInstructorTransformer.instructors2Lprs(lui, createdInstructors);
        for (LprInfo lprInfo : createdLprs) {
            lprService.createLpr(lprInfo.getPersonId(), lprInfo.getLuiId(), lprInfo.getTypeKey(), lprInfo, context);
        }

        // update existing lprs
        List<LprInfo> updatedLprs = OfferingInstructorTransformer.instructors2Lprs(lui, updatedInstructors);
        for (LprInfo lprInfo : updatedLprs) {
            lprService.updateLpr(lprInfo.getId(), lprInfo, context);
        }

        // delete removed lprs
        for (OfferingInstructorInfo instructorInfo : deletedInstructors) {
            lprService.deleteLpr(instructorInfo.getId(), context);
        }

        // rebuild activity to return it
        ActivityOfferingInfo ao = new ActivityOfferingInfo();
        ActivityOfferingTransformer.lui2Activity(ao, lui, lprService, schedulingService, context);
        FormatOfferingInfo foInfo = this.getFormatOffering(activityOfferingInfo.getFormatOfferingId(), context);
        CourseOfferingInfo coInfo = this.getCourseOffering(foInfo.getCourseOfferingId(), context);
        ao.setFormatOfferingId(foInfo.getId());
        ao.setCourseOfferingId(coInfo.getId());
        ao.setFormatOfferingName(foInfo.getName());
        ao.setCourseOfferingCode(coInfo.getCourseOfferingCode());
        ao.setCourseOfferingTitle(coInfo.getCourseOfferingTitle());
        AtpInfo termAtp = getAtpService().getAtp(ao.getTermId(), context);
        ao.setTermCode(termAtp.getCode());
        return ao;
    }


    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteActivityOffering(String activityOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {

        LuiInfo lui = luiService.getLui(activityOfferingId, context);

        if (!_checkTypeForActivityOfferingType(lui.getTypeKey(), context)) {
            throw new InvalidParameterException("Given lui id ( " + activityOfferingId + " ) is not an Activity Offering");
        }

        try {
            // delete offering instructor lprs for the Activity Offering
            _deleteLprsByLui(activityOfferingId, context);

            return luiService.deleteLui(activityOfferingId, context);
        } catch (DependentObjectsExistException e) {
            throw new OperationFailedException("Error deleting dependent objects", e);
        }
    }

    @Override
    @Transactional
    public StatusInfo deleteActivityOfferingCascaded(String activityOfferingId,
                                                     ContextInfo context) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {

        // get seat pools to delete
        List<SeatPoolDefinitionInfo> seatPools = getSeatPoolDefinitionsForActivityOffering(activityOfferingId, context);

        // remove seat pool reference  to AO then delete orphaned seat pool
        for (SeatPoolDefinitionInfo seatPool : seatPools) {
            removeSeatPoolDefinitionFromActivityOffering(seatPool.getId(), activityOfferingId, context);
            deleteSeatPoolDefinition(seatPool.getId(), context);
        }

        // Delete RGs attached to this AO
        List<RegistrationGroupInfo> regGroups = _getRegistrationGroupsByActivityOffering(activityOfferingId, context);
        if (regGroups != null && !regGroups.isEmpty()) {
            for (RegistrationGroupInfo regGroup : regGroups) {
                deleteRegistrationGroup(regGroup.getId(), context);
            }
        }

        // Delete the Activity offering
        return deleteActivityOffering(activityOfferingId, context);

    }


    /**
     * This implementation is the work-around for M5 that lacks an actual scheduler.
     * The schedule request that is bound to the Activity Offering is directly translated into an actual schedule,
     * which is persisted through the scheduling service.
     *
     * @param activityOfferingId Id of the Activity Offering to be scheduled.
     * @param contextInfo        Context information containing the principalId
     *                           and locale information about the caller of
     *                           service operation
     * @return a StatusInfo indicating the operation was successful
     * @throws DoesNotExistException
     * @throws InvalidParameterException
     * @throws MissingParameterException
     * @throws OperationFailedException
     * @throws PermissionDeniedException
     */
    @Override
    @Transactional
    public StatusInfo scheduleActivityOffering(String activityOfferingId,
                                               ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {

        ActivityOfferingInfo aoInfo = getActivityOffering(activityOfferingId, contextInfo);
        String toDeleteScheduleId = aoInfo.getScheduleId();

        // set the schedule id to null, will be persisted after creating new schedule
        aoInfo.setScheduleId(null);

        StatusInfo result = new StatusInfo();

        // find the schedule for this AO
        List<ScheduleRequestInfo> requests = schedulingService.getScheduleRequestsByRefObject(CourseOfferingServiceConstants.REF_OBJECT_URI_ACTIVITY_OFFERING, activityOfferingId, contextInfo);

        if(requests.isEmpty()) {
            result.setSuccess(true);
            result.setMessage("No scheduling requests were found");
        } else {
            // Should not be more than one request, grab the first one only
            ScheduleRequestInfo request = requests.get(0);
            // short cut the submission to the scheduler, and just translate requested delivery logistics to actual delivery logistics
            ScheduleInfo schedule = SchedulingServiceUtil.requestToSchedule(request);

            // set the term of the new schedule to the same term of the AO
            schedule.setAtpId(aoInfo.getTermId());

            // persist the new schedule
            ScheduleInfo persistedSchedule = null;
            try {
                persistedSchedule = schedulingService.createSchedule(schedule.getTypeKey(), schedule, contextInfo);
            } catch (Exception e) {
                throw new OperationFailedException("createSchedule failed due to the following uncaught exception: " + e.getClass().getSimpleName() + " " + e.getMessage(), e);
            }

            // set the id of the new schedule to the AO and update the entity
            aoInfo.setScheduleId(persistedSchedule.getId());

            result.setSuccess(true);
            result.setMessage("New Schedule Successfully created");
        }

        try {
            updateActivityOffering(aoInfo.getId(), aoInfo, contextInfo);
        } catch (Exception e) {
            throw new OperationFailedException("createSchedule failed due to the following uncaught exception: " + e.getClass().getSimpleName() + " " + e.getMessage(), e);
        }

        // if the activity offering has an existing schedule, delete that schedule
        if(StringUtils.isNotEmpty(toDeleteScheduleId)) {
            schedulingService.deleteSchedule(toDeleteScheduleId, contextInfo);
        }

        return result;
    }

    @Override
    public List<ValidationResultInfo> validateActivityOffering(String validationType,
                                                               ActivityOfferingInfo activityOfferingInfo, ContextInfo context)
            throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException {
        return new ArrayList<ValidationResultInfo>();
    }

    @Override
    public Float calculateInClassContactHoursForTerm(String activityOfferingId, ContextInfo context) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Float calculateOutofClassContactHoursForTerm(String activityOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Float calculateTotalContactHoursForTerm(String activityOfferingId, ContextInfo context) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional(readOnly = true)
    public RegistrationGroupInfo getRegistrationGroup(String registrationGroupId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        LuiInfo lui = luiService.getLui(registrationGroupId, context);
        if (lui == null) {
            throw new DoesNotExistException("registrationGroupId does not exist: " + registrationGroupId);
        }
        RegistrationGroupInfo rgInfo = registrationGroupTransformer.lui2Rg(lui, context);
        rgInfo.setCourseOfferingId(this.getFormatOffering(rgInfo.getFormatOfferingId(), context).getCourseOfferingId());

        return rgInfo;

    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistrationGroupInfo> getRegistrationGroupsByIds(List<String> registrationGroupsIds, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {

        List<RegistrationGroupInfo> regGroups = new ArrayList<RegistrationGroupInfo>();

        for (String registrationGroupId : registrationGroupsIds) {

            regGroups.add(registrationGroupAssembler.assemble(luiService.getLui(registrationGroupId, contextInfo), contextInfo));
        }

        return regGroups;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistrationGroupInfo> getRegistrationGroupsForCourseOffering(String courseOfferingId, ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        // TODO: implement LuiService.getLuiIdsByRelatedLuiAndRelationType and call it instead
        List<RegistrationGroupInfo> rgs = new ArrayList<RegistrationGroupInfo>();
        List<String> rgIds = new ArrayList<String>();
        List<LuiLuiRelationInfo> rels = luiService.getLuiLuiRelationsByLui(courseOfferingId, context);
        if (rels != null && !rels.isEmpty()) {
            for (LuiLuiRelationInfo rel : rels) {
                if (rel.getRelatedLuiId().equals(courseOfferingId)) {
                    if (rel.getTypeKey().equals(LuiServiceConstants.LUI_LUI_RELATION_REGISTEREDFORVIA_TYPE_KEY)) {
                        String luiId = rel.getLuiId();
                        LuiInfo lui = luiService.getLui(luiId, context);
                        if (lui != null && lui.getTypeKey().equals(LuiServiceConstants.REGISTRATION_GROUP_TYPE_KEY) && !rgIds.contains(luiId)) {
                            rgIds.add(luiId);
                            rgs.add(getRegistrationGroup(luiId, context));
                        }
                    }
                }
            }
        }

        return rgs;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistrationGroupInfo> getRegistrationGroupsWithActivityOfferings(List<String> activityOfferingIds,
                                                                                  ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    private List<RegistrationGroupInfo> _getRegistrationGroupsByActivityOffering(String activityOfferingId, ContextInfo context) throws InvalidParameterException, MissingParameterException, PermissionDeniedException, OperationFailedException, DoesNotExistException {
        List<RegistrationGroupInfo> regGroups = new ArrayList<RegistrationGroupInfo>();

        List<String> rgIds = luiService.getLuiIdsByRelatedLuiAndRelationType(activityOfferingId, LuiServiceConstants.LUI_LUI_RELATION_REGISTERED_FOR_VIA_RG_TO_AO_TYPE_KEY, context);
        if (rgIds != null && !rgIds.isEmpty()) {
            for (String rgId : rgIds) {
                RegistrationGroupInfo rgInfo = getRegistrationGroup(rgId, context);
                regGroups.add(rgInfo);
            }

            // Now sort based on reg group code order (alphabetical order works fine)
            // TODO: figure out how to write a compare method that makes sense given different code generators.
            Collections.sort(regGroups, new Comparator<RegistrationGroupInfo>() {
                @Override
                public int compare(RegistrationGroupInfo o1, RegistrationGroupInfo o2) {
                    if (o1 == null) {
                        return -1;
                    } else if (o2 == null) {
                        return 1;
                    } else {
                        // We assume <name> stores the registration group code as 4-digit string
                        return o1.getName().compareTo(o2.getName());
                    }
                }
            });
            return regGroups;
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistrationGroupInfo> getRegistrationGroupsByFormatOffering(String formatOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        List<RegistrationGroupInfo> regGroups = new ArrayList<RegistrationGroupInfo>();
        // Find all related luis to the format offering
        List<LuiInfo> luis = luiService.getRelatedLuisByLuiAndRelationType(formatOfferingId, LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_FO_TO_RG_TYPE_KEY, context);
        for (LuiInfo lui : luis) {
            if (LuiServiceConstants.REGISTRATION_GROUP_TYPE_KEY.equals(lui.getTypeKey())) {
                // Use service call getRegistrationGroup to do the work
                RegistrationGroupInfo rgInfo = getRegistrationGroup(lui.getId(), context);
                regGroups.add(rgInfo);
            } else {
                throw new InvalidParameterException("Invalid type for reg groups");
            }
        }
        // Now sort based on reg group code order (alphabetical order works fine)
        // TODO: figure out how to write a compare method that makes sense given different code generators.
        Collections.sort(regGroups, new Comparator<RegistrationGroupInfo>() {
            @Override
            public int compare(RegistrationGroupInfo o1, RegistrationGroupInfo o2) {
                if (o1 == null) {
                    return -1;
                } else if (o2 == null) {
                    return 1;
                } else {
                    // We assume <name> stores the registration group code as 4-digit string
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        return regGroups;
    }


    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo generateRegistrationGroupsForFormatOffering(String formatOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, DataValidationErrorException {
        try {
            return businessLogic.generateRegistrationGroupsForFormatOffering(formatOfferingId, context);
        } catch (DoesNotExistException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e) {
            throw new RuntimeException("Registration Groups generation has failed! ", e);
        }
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo generateRegistrationGroupsForCluster(String activityOfferingClusterId, ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, DataValidationErrorException {
        return businessLogic.generateRegistrationGroupsForCluster(activityOfferingClusterId, contextInfo);
    }

    private String _getTermKeyByCourseOffering(String courseOfferingId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        String termId = null;

        LuiInfo co = luiService.getLui(courseOfferingId, context);
        if (co != null) {
            termId = co.getAtpId();
        }

        return termId;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public RegistrationGroupInfo updateRegistrationGroup(String registrationGroupId, RegistrationGroupInfo registrationGroupInfo, ContextInfo context)
            throws DataValidationErrorException,
            DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException, VersionMismatchException {

        // validate params
        if (!registrationGroupId.equals(registrationGroupInfo.getId())) {
            throw new InvalidParameterException(registrationGroupId + " does not match the corresponding value in the object " + registrationGroupInfo.getId());
        }

        // get it
        LuiInfo lui = luiService.getLui(registrationGroupId, context);

        // Throw exception if a state change is attempted
        if (!registrationGroupInfo.getStateKey().equals(lui.getStateKey())) {
            throw new ReadOnlyException("state key can only be changed by calling updateRegistrationGroupState");
        }
        //TO DO: Check that the Registration code is unique within a CO. If it is a duplicate, do not change it

        Set<String> existingRelatedLuiIds = new HashSet<String>();
        Set<String> newRelatedLuiIds = new HashSet<String>(registrationGroupInfo.getActivityOfferingIds());

        //Update LLR
        List<LuiLuiRelationInfo> llrs = luiService.getLuiLuiRelationsByLui(registrationGroupId, context);
        for (LuiLuiRelationInfo llr : llrs) {
            if (registrationGroupId.equals(llr.getLuiId()) && LuiServiceConstants.LUI_LUI_RELATION_REGISTERED_FOR_VIA_RG_TO_AO_TYPE_KEY.equals(llr.getTypeKey())) {
                String relatedLuiId = llr.getRelatedLuiId();
                existingRelatedLuiIds.add(relatedLuiId);
                if (!newRelatedLuiIds.contains(relatedLuiId)) {
                    luiService.deleteLuiLuiRelation(llr.getId(), context);
                }
            } else if (registrationGroupId.equals(llr.getRelatedLuiId())
                    && LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_FO_TO_RG_TYPE_KEY.equals(llr.getTypeKey())
                    && !llr.getLuiId().equals(registrationGroupInfo.getFormatOfferingId())) {
                luiService.deleteLuiLuiRelation(llr.getId(), context);
                _createLuiLuiRelationForRegGroups(registrationGroupInfo.getFormatOfferingId(), registrationGroupId, LuiServiceConstants.LUI_LUI_RELATION_DELIVERED_VIA_FO_TO_RG_TYPE_KEY, context);
            }
        }
        // Create relations for added Activity Offerings or Course Offering
        for (String luiId : newRelatedLuiIds) {
            if (!existingRelatedLuiIds.contains(luiId)) {
                _createLuiLuiRelationForRegGroups(registrationGroupId, luiId, LuiServiceConstants.LUI_LUI_RELATION_REGISTERED_FOR_VIA_RG_TO_AO_TYPE_KEY, context);
            }
        }

        LuiInfo regGroupLui = registrationGroupTransformer.rg2Lui(registrationGroupInfo, context);
        LuiInfo updatedRegGroupLui = luiService.updateLui(regGroupLui.getId(), regGroupLui, context);

        // Everything saved to the DB, now return RG sent back by createLui and transformed by transformer back to caller
        RegistrationGroupInfo rgInfo = registrationGroupTransformer.lui2Rg(updatedRegGroupLui, context);
        rgInfo.setCourseOfferingId(registrationGroupInfo.getCourseOfferingId());
        rgInfo.setRegistrationCode(updatedRegGroupLui.getOfficialIdentifier().getCode());
        return rgInfo;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteRegistrationGroup(String registrationGroupId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        try {
            LuiInfo fetch = luiService.getLui(registrationGroupId, context);
            if (fetch == null) {
                throw new DoesNotExistException("Registration Group, " + registrationGroupId + ", does not exist");
            }
            // Make sure we have correct type before deleting
            if (!LuiServiceConstants.REGISTRATION_GROUP_TYPE_KEY.equals(fetch.getTypeKey())) {
                throw new InvalidParameterException("ID, " + registrationGroupId + ", does not have a registration group type");
            }
            return luiService.deleteLui(registrationGroupId, context);
        } catch (DependentObjectsExistException e) {
            throw new OperationFailedException("Could not delete LUI '" + registrationGroupId + "'", e);
        }
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteRegistrationGroupsByFormatOffering(String formatOfferingId, ContextInfo context)
            throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        // Quick verification
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(Boolean.TRUE);
        try {
            List<RegistrationGroupInfo> regGroups = getRegistrationGroupsByFormatOffering(formatOfferingId, context);
            for (RegistrationGroupInfo regGroup : regGroups) {
                deleteRegistrationGroup(regGroup.getId(), context);
            }
        } catch (Exception e) {
            statusInfo.setSuccess(Boolean.FALSE);
            statusInfo.setMessage(e.getMessage());
        }
        return statusInfo;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteGeneratedRegistrationGroupsByFormatOffering(String formatOfferingId, ContextInfo context)
            throws InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException {

        // Quick verification
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(Boolean.TRUE);
        try {
            List<RegistrationGroupInfo> regGroups = getRegistrationGroupsByFormatOffering(formatOfferingId, context);
            for (RegistrationGroupInfo regGroup : regGroups) {
                if (regGroup.getIsGenerated()) {
                    // Only delete reg groups that are generated
                    deleteRegistrationGroup(regGroup.getId(), context);
                }
            }
        } catch (Exception e) {
            statusInfo.setSuccess(Boolean.FALSE);
            statusInfo.setMessage(e.getMessage());
        }
        return statusInfo;
    }

    @Override
    public StatusInfo deleteRegistrationGroupsForCluster(String activityOfferingClusterId, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(Boolean.TRUE);
        try {
            ActivityOfferingClusterInfo aocInfo = getActivityOfferingCluster(activityOfferingClusterId, contextInfo);
            List<RegistrationGroupInfo> regGroups = getRegistrationGroupsByFormatOffering(aocInfo.getFormatOfferingId(), contextInfo);
            for (RegistrationGroupInfo rgInfo : regGroups){
                if (rgInfo.getActivityOfferingClusterId().equals(activityOfferingClusterId)) {
                    deleteRegistrationGroup(rgInfo.getId(),contextInfo);
                }
            }
        } catch (Exception e) {
            statusInfo.setSuccess(Boolean.FALSE);
            statusInfo.setMessage(e.getMessage());
        }
        return statusInfo;
    }

    @Override
    public List<ValidationResultInfo> verifyRegistrationGroup(String registrationGroupId, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException {
        throw new UnsupportedOperationException();
    }


    private List<String> _getTimeSlotIdsbyActivityOffering(String activityOfferingId, String deliveryLogisticsType, ContextInfo context) throws InvalidParameterException, MissingParameterException, DoesNotExistException, PermissionDeniedException, OperationFailedException {
        ActivityOfferingInfo aoInfo = getActivityOffering(activityOfferingId, context);
        List<String> timeSlotIds = new ArrayList<String>();

        if (deliveryLogisticsType.equals("actual")) {
            if (aoInfo.getScheduleId() != null && aoInfo.getScheduleId().length()>0) {
                ScheduleInfo scheduleInfo = getSchedulingService().getSchedule(aoInfo.getScheduleId(), context);
                if (scheduleInfo != null) {
                    List<ScheduleComponentInfo> scheduleComponentInfos = scheduleInfo.getScheduleComponents();
                    if (scheduleComponentInfos != null && !scheduleComponentInfos.isEmpty()) {
                        for (ScheduleComponentInfo scheduleComponentInfo : scheduleComponentInfos) {
                            if (scheduleComponentInfo.getTimeSlotIds() != null && !scheduleComponentInfo.getTimeSlotIds().isEmpty()) {
                                timeSlotIds.addAll(scheduleComponentInfo.getTimeSlotIds());
                            }
                        }
                    }
                }
            }
        } else if (deliveryLogisticsType.equals("requested")) {
            List<ScheduleRequestInfo> scheduleRequestInfos = getSchedulingService().getScheduleRequestsByRefObject(CourseOfferingServiceConstants.REF_OBJECT_URI_ACTIVITY_OFFERING,activityOfferingId,context);
            if (scheduleRequestInfos != null && !scheduleRequestInfos.isEmpty()) {
                for (ScheduleRequestInfo scheduleRequestInfo : scheduleRequestInfos) {
                    List<ScheduleRequestComponentInfo> scheduleRequestComponentInfos = scheduleRequestInfo.getScheduleRequestComponents();
                    if (scheduleRequestComponentInfos != null && !scheduleRequestComponentInfos.isEmpty()) {
                        for (ScheduleRequestComponentInfo scheduleRequestComponentInfo : scheduleRequestComponentInfos) {
                            if (scheduleRequestComponentInfo.getTimeSlotIds() != null && !scheduleRequestComponentInfo.getTimeSlotIds().isEmpty()) {
                                timeSlotIds.addAll(scheduleRequestComponentInfo.getTimeSlotIds());
                            }
                        }
                    }
                }
            }
        }

        return timeSlotIds;
    }

    // return: true - overlap; false - no overlap
    private boolean _checkTimeSlotsOverlap (List<String> timeSlotInfoList1, List<String> timeSlotInfoList2, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, DoesNotExistException, PermissionDeniedException, OperationFailedException {
        for (int i=0; i<timeSlotInfoList1.size(); i++) {
            for (int j=0; j<timeSlotInfoList2.size(); j++) {
                if (getSchedulingService().areTimeSlotsInConflict (timeSlotInfoList1.get(i), timeSlotInfoList2.get(j), contextInfo)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<ValidationResultInfo> validateRegistrationGroup(String validationType, String activityOfferingClusterId, String registrationGroupType,
                                                                RegistrationGroupInfo registrationGroupInfo, ContextInfo context) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException {

        List<ValidationResultInfo> validationResultInfos = new ArrayList<ValidationResultInfo>() ;
        ValidationResultInfo validationResultInfo = new ValidationResultInfo();

        List<String> aoIds = registrationGroupInfo.getActivityOfferingIds();
        Map<String, Map<String, List<String>>> aoTimeSlotMap = new HashMap<String, Map<String, List<String>>>(aoIds.size());

        try {
            if (aoIds != null && !aoIds.isEmpty() && aoIds.size() > 1) {
                //push the actual and requested timeslots associated with the AOs of the given RG into a map
                for (int i=0; i<aoIds.size(); i++) {
                    Map<String, List<String>> timeSlotMap = new HashMap<String, List<String>>();

                    // retrieve the actual time slots for given AO
                    List<String> timeSlotIdsActualForInsert = _getTimeSlotIdsbyActivityOffering(aoIds.get(i), "actual", context);
                    if (timeSlotIdsActualForInsert != null && !timeSlotIdsActualForInsert.isEmpty()) {
                        timeSlotMap.put("actual", timeSlotIdsActualForInsert);
                    }
                    // retrieve the requested time slots for given AO
                    List<String> timeSlotIdsRequestedForInsert = _getTimeSlotIdsbyActivityOffering(aoIds.get(i), "requested", context);
                    if (timeSlotIdsRequestedForInsert != null && !timeSlotIdsRequestedForInsert.isEmpty()) {
                        timeSlotMap.put("requested", timeSlotIdsRequestedForInsert);
                    }

                    aoTimeSlotMap.put(aoIds.get(i), timeSlotMap);
                }

                for (Map.Entry<String, Map<String, List<String>>> entry : aoTimeSlotMap.entrySet()) {
                    boolean hasTimeSlotAcutal = false, hasTimeSlotRequested = false;
                    List<String> timeSlotIdsActual = entry.getValue().get("actual");
                    List<String> timeSlotIdsRequested = entry.getValue().get("requested");

                    if (timeSlotIdsActual != null && !timeSlotIdsActual.isEmpty()) {
                        hasTimeSlotAcutal = true;
                    }
                    if (timeSlotIdsRequested != null && !timeSlotIdsRequested.isEmpty()) {
                        hasTimeSlotRequested = true;
                    }

                    if (hasTimeSlotAcutal == true || hasTimeSlotRequested == true) {
                        for (Map.Entry<String, Map<String, List<String>>> innerEntry : aoTimeSlotMap.entrySet()) {
                            boolean hasTimeSlotAcutalCompared = false, hasTimeSlotRequestedCompared = false;

                            if (!entry.getKey().equals(innerEntry.getKey())) {
                                List<String> timeSlotIdsComparedActual = innerEntry.getValue().get("actual");
                                List<String> timeSlotIdsComparedRequested = innerEntry.getValue().get("requested");
                                if (timeSlotIdsComparedActual != null && !timeSlotIdsComparedActual.isEmpty()) {
                                    hasTimeSlotAcutalCompared = true;
                                }
                                if (timeSlotIdsComparedRequested != null && !timeSlotIdsComparedRequested.isEmpty()) {
                                    hasTimeSlotRequestedCompared = true;
                                }

                                if (hasTimeSlotAcutalCompared == true || hasTimeSlotRequestedCompared == true) {
                                    if (hasTimeSlotAcutal != false  && hasTimeSlotAcutalCompared != false) {
                                        if (_checkTimeSlotsOverlap(timeSlotIdsActual, timeSlotIdsComparedActual, context)) {
                                            validationResultInfo.setLevel(ValidationResult.ErrorLevel.ERROR);
                                            validationResultInfo.setMessage("time conflict between AO: " + entry.getKey() + " and AO: " + innerEntry.getKey());
                                            validationResultInfos.add(validationResultInfo);
                                            registrationGroupInfo.setStateKey(LuiServiceConstants.REGISTRATION_GROUP_INVALID_STATE_KEY);

                                            updateRegistrationGroupState(registrationGroupInfo.getId(), LuiServiceConstants.REGISTRATION_GROUP_INVALID_STATE_KEY,context);
                                            return validationResultInfos;
                                        }
                                    } else if (hasTimeSlotAcutal != false && hasTimeSlotAcutalCompared == false && hasTimeSlotRequestedCompared != false) {
                                        if (_checkTimeSlotsOverlap(timeSlotIdsActual, timeSlotIdsComparedRequested, context)) {
                                            validationResultInfo.setLevel(ValidationResult.ErrorLevel.ERROR);
                                            validationResultInfo.setMessage("time conflict between AO: " + entry.getKey() + " and AO: " + innerEntry.getKey());
                                            validationResultInfos.add(validationResultInfo);
                                            registrationGroupInfo.setStateKey(LuiServiceConstants.REGISTRATION_GROUP_INVALID_STATE_KEY);

                                            updateRegistrationGroupState(registrationGroupInfo.getId(), LuiServiceConstants.REGISTRATION_GROUP_INVALID_STATE_KEY,context);
                                            return validationResultInfos;
                                        }
                                    } else if (hasTimeSlotAcutal == false && hasTimeSlotRequested != false && hasTimeSlotAcutalCompared != false) {
                                        if (_checkTimeSlotsOverlap(timeSlotIdsRequested, timeSlotIdsComparedActual, context)) {
                                            validationResultInfo.setLevel(ValidationResult.ErrorLevel.ERROR);
                                            validationResultInfo.setMessage("time conflict between AO: " + entry.getKey() + " and AO: " + innerEntry.getKey());
                                            validationResultInfos.add(validationResultInfo);
                                            registrationGroupInfo.setStateKey(LuiServiceConstants.REGISTRATION_GROUP_INVALID_STATE_KEY);

                                            updateRegistrationGroupState(registrationGroupInfo.getId(), LuiServiceConstants.REGISTRATION_GROUP_INVALID_STATE_KEY,context);
                                            return validationResultInfos;
                                        }
                                    } else if (hasTimeSlotAcutal == false && hasTimeSlotRequested != false && hasTimeSlotAcutalCompared == false && hasTimeSlotRequestedCompared != false) {
                                        if (_checkTimeSlotsOverlap(timeSlotIdsRequested, timeSlotIdsComparedRequested, context)) {
                                            validationResultInfo.setLevel(ValidationResult.ErrorLevel.ERROR);
                                            validationResultInfo.setMessage("time conflict between AO: " + entry.getKey() + " and AO: " + innerEntry.getKey());
                                            validationResultInfos.add(validationResultInfo);
                                            registrationGroupInfo.setStateKey(LuiServiceConstants.REGISTRATION_GROUP_INVALID_STATE_KEY);

                                            updateRegistrationGroupState(registrationGroupInfo.getId(), LuiServiceConstants.REGISTRATION_GROUP_INVALID_STATE_KEY,context);
                                            return validationResultInfos;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new OperationFailedException("unexpected", e);
        }

        validationResultInfo.setLevel(ValidationResult.ErrorLevel.OK);
        validationResultInfo.setMessage("No time conflict in the Registration Group");
        validationResultInfos.add(validationResultInfo);
        return validationResultInfos;


    }

    @Override
    @Transactional(readOnly = true)
    public ActivityOfferingClusterInfo getActivityOfferingCluster(String activityOfferingClusterId,
                                                                  ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {

        ActivityOfferingClusterEntity activityOfferingClusterEntity = activityOfferingClusterDao.find(activityOfferingClusterId);
        if (null == activityOfferingClusterEntity) {
            throw new DoesNotExistException(activityOfferingClusterId);
        }
        return activityOfferingClusterEntity.toDto();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityOfferingClusterInfo> getActivityOfferingClustersByFormatOffering(String formatOfferingId, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<ActivityOfferingClusterEntity> entities = activityOfferingClusterDao.getByFormatOffering(formatOfferingId);
        List<ActivityOfferingClusterInfo> list = new ArrayList<ActivityOfferingClusterInfo>(entities.size());
        for (ActivityOfferingClusterEntity entity : entities) {
            list.add(entity.toDto());
        }
        return list;
    }

    private Set<String> _verifyUniquenessOfAoTypes(ActivityOfferingClusterInfo clusterInfo) throws InvalidParameterException {
        Set<String> aoTypeSet = new HashSet<String>();
        if (clusterInfo.getActivityOfferingSets() == null) {
            return aoTypeSet;
        }
        int count = 0;
        // Check that each AO set has a non-null type and no two sets have the same AO type
        for (ActivityOfferingSetInfo setInfo: clusterInfo.getActivityOfferingSets()) {
            String aoType = setInfo.getActivityOfferingType();
            if (aoType == null) {
                throw new InvalidParameterException("Activity Offering Set has null AO type");
            }
            // Make sure you haven't seen this AO type before--if so, exception
            if (aoTypeSet.contains(aoType)) {
                throw new InvalidParameterException("AO type, " + aoType + ", appears more than once in AO set of AO cluster");
            }
            aoTypeSet.add(aoType);
        }
        return aoTypeSet;
    }

    private void _verifyClusterAoTypesMatchFoAoTypes(Set<String> clusterAoTypes, Set<String> foAoTypes,
                                                     ActivityOfferingClusterInfo clusterInfo,
                                                     String foId) throws InvalidParameterException {
        if (!clusterAoTypes.equals(foAoTypes)) {
            Set<String> aoTypeSetCopy = new HashSet<String>(clusterAoTypes);
            aoTypeSetCopy.removeAll(foAoTypes);
            if (!aoTypeSetCopy.isEmpty()) {
                // There are aoTypes in the cluster, which do not appear in the fo's ao types
                String error = "";
                for (String aoType: aoTypeSetCopy) {
                    error += aoType + " ";
                }
                error += "not valid AO types for FO (" + foId + ")";
                throw new InvalidParameterException(error);
            } else {
                // All cluster AO types exist in FO but some are missing, so fill in missing ones
                Set<String> missingAoTypes = new HashSet<String>(foAoTypes);
                missingAoTypes.removeAll(clusterAoTypes);
                for (String aoType: missingAoTypes) {
                    ActivityOfferingSetInfo setInfo = new ActivityOfferingSetInfo();
                    setInfo.setActivityOfferingType(aoType);
                    clusterInfo.getActivityOfferingSets().add(setInfo);
                }
            }
        }
    }

    private void _verifyAoIdsInCorrectAoSet(ActivityOfferingClusterInfo clusterInfo, ContextInfo contextInfo)
            throws InvalidParameterException, MissingParameterException, DoesNotExistException,
                   PermissionDeniedException, OperationFailedException {

        for (ActivityOfferingSetInfo setInfo: clusterInfo.getActivityOfferingSets()) {
            String aoType = setInfo.getActivityOfferingType();
            for (String aoId: setInfo.getActivityOfferingIds()) {
                LuiInfo lui = luiService.getLui(aoId, contextInfo);
                if (!lui.getTypeKey().equals(aoType)) {
                    throw new InvalidParameterException("AO (" + lui.getId() + ") does not match AOset's AoType, " + aoType);
                }
            }
        }
    }

    /**
     * Mostly throws InvalidParameterException if data validation fails.  If there are missing AOsets in the
     * cluster, this will fill them in as a side effect, provided nothing else is wrong.
     * @param foInfo Format offering info
     * @param clusterInfo AO cluster info
     * @param contextInfo Context
     */
    private void _verifyAOSetsInCluster(FormatOfferingInfo foInfo, ActivityOfferingClusterInfo clusterInfo,
                                        ContextInfo contextInfo)
            throws InvalidParameterException, MissingParameterException, DoesNotExistException,
                   OperationFailedException, PermissionDeniedException {
        // Make sure types are unique
        Set<String> clusterAoTypes = _verifyUniquenessOfAoTypes(clusterInfo);
        List<String> aoTypes = foInfo.getActivityOfferingTypeKeys();
        Set<String> foAoTypes = new HashSet<String>(aoTypes);
        if (foAoTypes.size() != aoTypes.size()) {
            // FOs should not have more than one AO type
            throw new InvalidParameterException("FO (" + foInfo.getId() + ") has AO types that appear more than once");
        }
        _verifyClusterAoTypesMatchFoAoTypes(clusterAoTypes, foAoTypes, clusterInfo, foInfo.getId());
        _verifyAoIdsInCorrectAoSet(clusterInfo, contextInfo);
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public ActivityOfferingClusterInfo createActivityOfferingCluster(String formatOfferingId,
                                                                     String activityOfferingClusterTypeKey,
                                                                     ActivityOfferingClusterInfo activityOfferingClusterInfo,
                                                                     ContextInfo contextInfo)
            throws DataValidationErrorException,
            DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            ReadOnlyException {

        // validate params
        if (!formatOfferingId.equals(activityOfferingClusterInfo.getFormatOfferingId())) {
            throw new InvalidParameterException(formatOfferingId + " does not match the corresponding value in the object " + activityOfferingClusterInfo.getFormatOfferingId());
        }
        if (!activityOfferingClusterTypeKey.equals(activityOfferingClusterInfo.getTypeKey())) {
            throw new InvalidParameterException(activityOfferingClusterTypeKey + " does not match the corresponding value in the object " + activityOfferingClusterInfo.getTypeKey());
        }
        // Make sure that there are as many AOSets as AO types in the FO
        FormatOfferingInfo foInfo = getFormatOffering(formatOfferingId, contextInfo);
        if (activityOfferingClusterInfo.getActivityOfferingSets() == null ||
                activityOfferingClusterInfo.getActivityOfferingSets().isEmpty()) {
            // If it's empty
            _createAOSets(foInfo, activityOfferingClusterInfo);
        } else {
            _verifyAOSetsInCluster(foInfo, activityOfferingClusterInfo, contextInfo);  // Throws exception if it fails to verify
        }
        // persist
        ActivityOfferingClusterEntity activityOfferingClusterEntity =
                new ActivityOfferingClusterEntity(activityOfferingClusterInfo);
        try {

            activityOfferingClusterEntity.setEntityCreated(contextInfo);
            //activityOfferingClusterEntity.setEntityUpdated(contextInfo);
            activityOfferingClusterDao.persist(activityOfferingClusterEntity);
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }

        return activityOfferingClusterEntity.toDto();
    }

    private void _createAOSets(FormatOfferingInfo foInfo, ActivityOfferingClusterInfo clusterInfo) {
        if (clusterInfo.getActivityOfferingSets() == null) {
            clusterInfo.setActivityOfferingSets(new ArrayList<ActivityOfferingSetInfo>());
        }
        List<ActivityOfferingSetInfo> setInfos = clusterInfo.getActivityOfferingSets();
        List<String> aoTypeKeys = foInfo.getActivityOfferingTypeKeys();
        if (aoTypeKeys != null) {
            for (String aoTypeKey: aoTypeKeys) {
                // Create an AOSetInfo
                ActivityOfferingSetInfo setInfo = new ActivityOfferingSetInfo();
                setInfo.setActivityOfferingType(aoTypeKey);
                setInfo.setActivityOfferingIds(new ArrayList<String>()); // leave it empty for now
                // Add it to the list
                setInfos.add(setInfo);
            }
        }
    }

    //validate each AO type has at least one AO in an FO. Right now, this validation may not be necessary because each AOC in an FO contains all the possible AO types that the FO has
    public  List<ValidationResultInfo> validateActivityOfferingForFormatOffering (String formatOfferingId, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException, PermissionDeniedException {

        List<ValidationResultInfo> validationResultInfos = new ArrayList<ValidationResultInfo>();
        ValidationResultInfo validationResultInfo = new ValidationResultInfo();
        FormatOfferingInfo fo = getFormatOffering(formatOfferingId, contextInfo);
        for (String aoTypeKey : fo.getActivityOfferingTypeKeys()) {
            Map<String, String> fieldValues = new HashMap<String, String>();
            fieldValues.put("aoTypeKey", aoTypeKey);
            QueryByCriteria qbc = _buildQueryByCriteria(fieldValues);
            List<ActivityOfferingInfo> activityOfferingInfos = searchForActivityOfferings(qbc, contextInfo);

            if (activityOfferingInfos == null || activityOfferingInfos.isEmpty()) {
                validationResultInfo.setLevel(ValidationResult.ErrorLevel.ERROR);
                validationResultInfos.add(validationResultInfo);
                return validationResultInfos;
            }
        }

        validationResultInfo.setLevel(ValidationResult.ErrorLevel.OK);
        validationResultInfos.add(validationResultInfo);
        return validationResultInfos;

    }

    private QueryByCriteria _buildQueryByCriteria(Map<String, String> fieldValues){
        String aoTypeKey = fieldValues.get("aoTypeKey");

        List<Predicate> predicates = new ArrayList<Predicate>();
        if (StringUtils.isNotBlank(aoTypeKey)) {
            predicates.add(PredicateFactory.equal("typeKey", aoTypeKey));

        }
        QueryByCriteria.Builder qbcBuilder = QueryByCriteria.Builder.create();
        qbcBuilder.setPredicates(predicates.toArray(new Predicate[predicates.size()]));
        QueryByCriteria qbc = qbcBuilder.build();

        return qbc;
    }

    @Override
    public List<ValidationResultInfo> validateActivityOfferingCluster(String validationTypeKey, String formatOfferingId,
                                                                      ActivityOfferingClusterInfo activityOfferingClusterInfo,
                                                                      ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException {

        List<ValidationResultInfo> validationResultInfos = new ArrayList<ValidationResultInfo>();
        ValidationResultInfo validationResultInfo = new ValidationResultInfo();

        try {
            ActivityOfferingClusterInfo aoCInfo = getActivityOfferingCluster(activityOfferingClusterInfo.getId(), contextInfo);
            List<ActivityOfferingSetInfo> aoSetInfos = aoCInfo.getActivityOfferingSets();

            Integer aoSetMaxEnrollNumber = 0;
            Map<String, Integer> aoSetMaxEnrollNumberMap = new HashMap<String, Integer>(aoSetInfos.size());

            for (ActivityOfferingSetInfo aoSetInfo : aoSetInfos ){
                for (String aoId : aoSetInfo.getActivityOfferingIds()) {
                    ActivityOfferingInfo aoInfo = getActivityOffering(aoId, contextInfo);
                    if (aoInfo != null &&  aoInfo.getMaximumEnrollment() != null) {
                        aoSetMaxEnrollNumber += aoInfo.getMaximumEnrollment();
                    }
                }

                if (!aoSetMaxEnrollNumberMap.isEmpty()) {
                    for (Integer tempAoSetMaxEnrollNumber : aoSetMaxEnrollNumberMap.values()) {
                        if (aoSetMaxEnrollNumber.compareTo(tempAoSetMaxEnrollNumber) != 0) {
                            //validationResultInfo.setError("");
                            validationResultInfo.setLevel(ValidationResult.ErrorLevel.ERROR);
                            validationResultInfo.setMessage("Sum of enrollment for each AO type is not equal");
                            validationResultInfos.add(validationResultInfo);

                            return validationResultInfos;

                        }
                    }
                }

                aoSetMaxEnrollNumberMap.put(aoSetInfo.getId(), aoSetMaxEnrollNumber);
                aoSetMaxEnrollNumber = 0;
            }
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }

        validationResultInfo.setLevel(ValidationResult.ErrorLevel.OK);
        validationResultInfo.setMessage("Sum of enrollment for each AO type is equal");
        validationResultInfos.add(validationResultInfo);
        return validationResultInfos;


    }

    @Override
    public AOClusterVerifyResultsInfo verifyActivityOfferingClusterForGeneration(String activityOfferingClusterId, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        AOClusterVerifyResultsInfo aoClusterVerifyResultsInfo = new AOClusterVerifyResultsInfo();
        List<ValidationResultInfo> validationResultInfos = new ArrayList<ValidationResultInfo>() ;
        ValidationResultInfo validationResultInfo = new ValidationResultInfo();

        try {
            ActivityOfferingClusterInfo aoCInfo = getActivityOfferingCluster(activityOfferingClusterId, contextInfo);
            List<ActivityOfferingSetInfo> aoSetInfos = aoCInfo.getActivityOfferingSets();

            for (ActivityOfferingSetInfo aoSetInfo : aoSetInfos ){
                List<String> aoIdList = aoSetInfo.getActivityOfferingIds();
                if (aoIdList == null || aoIdList.isEmpty()) {
                    //invalidValidationInfo.setError("");
                    validationResultInfo.setLevel(ValidationResult.ErrorLevel.ERROR);
                    validationResultInfo.setMessage("AO type: " + aoSetInfo.getActivityOfferingType() + " doesn't have AOs attached to it");
                    validationResultInfos.add(validationResultInfo);
                    aoClusterVerifyResultsInfo.setValidationResults(validationResultInfos);

                    return aoClusterVerifyResultsInfo;
                }
            }
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }

        validationResultInfo.setLevel(ValidationResult.ErrorLevel.OK);
        validationResultInfo.setMessage("Each AO type has AOs attached to it");
        validationResultInfos.add(validationResultInfo);
        aoClusterVerifyResultsInfo.setValidationResults(validationResultInfos);

        return aoClusterVerifyResultsInfo;

    }

    private void _uAOC_deleteRegGroupsWithAosNotInCluster(ActivityOfferingClusterInfo clusterInfo, ContextInfo contextInfo)
            throws InvalidParameterException, MissingParameterException, DoesNotExistException, PermissionDeniedException,
                   OperationFailedException {

        // Find all AO IDs in this cluster
        List<ActivityOfferingSetInfo> aoSetInfos = clusterInfo.getActivityOfferingSets();
        Set<String> aoIdsInCluster = new HashSet<String>();
        for (ActivityOfferingSetInfo setInfo: aoSetInfos) {
            //  Loop through and add all AO IDs from each of the sets
            aoIdsInCluster.addAll(setInfo.getActivityOfferingIds());
        }
        // For each reg group, look at its list of AO Ids.  If all of them are in the cluster, good.
        // If not, add into regGroupIdsToDelete
        List<RegistrationGroupInfo> regGroups =
                getRegistrationGroupsByActivityOfferingCluster(clusterInfo.getId(), contextInfo);
        List<String> regGroupIdsToDelete = new ArrayList<String>();
        for (RegistrationGroupInfo regGroup: regGroups) {
            List<String> regGroupAoIds = regGroup.getActivityOfferingIds();
            if (!aoIdsInCluster.containsAll(regGroupAoIds)) {
                // Didn't find all AOs from the reg group AO IDs
                regGroupIdsToDelete.add(regGroup.getId());
            }
        }
        // Delete the reg groups in the list
        for (String regGroupIdToDelete: regGroupIdsToDelete) {
            deleteRegistrationGroup(regGroupIdToDelete, contextInfo);
        }
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public ActivityOfferingClusterInfo updateActivityOfferingCluster(String formatOfferingId,
                                                                     String activityOfferingClusterId,
                                                                     ActivityOfferingClusterInfo activityOfferingClusterInfo,
                                                                     ContextInfo contextInfo)
            throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
                   MissingParameterException, OperationFailedException, PermissionDeniedException,
                   ReadOnlyException, VersionMismatchException {

        ActivityOfferingClusterEntity activityOfferingClusterEntity = activityOfferingClusterDao.find(activityOfferingClusterId);
        if (null != activityOfferingClusterEntity) {
            if (!activityOfferingClusterEntity.getActivityOfferingClusterState().equals(activityOfferingClusterInfo.getStateKey())) {
                throw new ReadOnlyException("state key can only be changed by calling updateActivityOfferingClusterState");
            }
            FormatOfferingInfo foInfo = getFormatOffering(formatOfferingId, contextInfo);
            _verifyAOSetsInCluster(foInfo, activityOfferingClusterInfo, contextInfo);

            List<Object> orphans = activityOfferingClusterEntity.fromDto(activityOfferingClusterInfo);
            // Delete any orphaned children
            for (Object orphan : orphans){
                activityOfferingClusterDao.getEm().remove(orphan);
            }
            activityOfferingClusterEntity.setEntityUpdated(contextInfo);
            ActivityOfferingClusterInfo merged = activityOfferingClusterDao.merge(activityOfferingClusterEntity).toDto();
            // Delete reg groups with AOs no longer in AO cluster (put here, in case merge fails--then, this code won't
            // run.
            _uAOC_deleteRegGroupsWithAosNotInCluster(merged, contextInfo);
            return merged;
        } else {
            throw new DoesNotExistException("No activityOfferingCluster has been found for activityOfferingClusterId=" + activityOfferingClusterId);
        }
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteActivityOfferingCluster(String activityOfferingClusterId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
                   OperationFailedException, PermissionDeniedException, DependentObjectsExistException {

        StatusInfo status = new StatusInfo();
        status.setSuccess(Boolean.TRUE);

        ActivityOfferingClusterEntity activityOfferingClusterEntity = activityOfferingClusterDao.find(activityOfferingClusterId);
        if (null != activityOfferingClusterEntity) {
            // Don't delete AOC if there are dependent RGs.
            List<RegistrationGroupInfo> rgInfos =
                    getRegistrationGroupsByActivityOfferingCluster(activityOfferingClusterId, context);
            if (rgInfos != null && !rgInfos.isEmpty()) {
                throw new DependentObjectsExistException("Activity offering cluster (id: " + activityOfferingClusterId + ") has attached reg groups");
            }
            // Delete attributes
            if (activityOfferingClusterEntity.getAttributes() != null) {
                for(ActivityOfferingClusterAttributeEntity attr:activityOfferingClusterEntity.getAttributes()) {
                    activityOfferingClusterDao.getEm().remove(attr);
                }
            }
            // Delete AOSets
            if (activityOfferingClusterEntity.getAoSets()!=null) {
                for (ActivityOfferingSetEntity aoSet:activityOfferingClusterEntity.getAoSets()) {
                    activityOfferingClusterDao.getEm().remove(aoSet);
                }
                activityOfferingClusterEntity.getAoSets().clear();
            }
            activityOfferingClusterDao.remove(activityOfferingClusterEntity);
        } else {
            throw new DoesNotExistException(activityOfferingClusterId);
        }
        return status;
    }

    @Override
    @Transactional(readOnly = true)
    public SeatPoolDefinitionInfo getSeatPoolDefinition(String seatPoolDefinitionId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
                   OperationFailedException, PermissionDeniedException {

        SeatPoolDefinitionEntity poolEntity = seatPoolDefinitionDao.find(seatPoolDefinitionId); // throws DoesNotExistException
        if (null == poolEntity) {
            throw new DoesNotExistException(seatPoolDefinitionId);
        }
        return poolEntity.toDto();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SeatPoolDefinitionInfo> getSeatPoolDefinitionsForActivityOffering(String activityOfferingId, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {

        List<SeatPoolDefinitionInfo> seatPoolDefinitionInfos = new ArrayList<SeatPoolDefinitionInfo>();
        if (StringUtils.isNotBlank(activityOfferingId)) {
            QueryByCriteria.Builder qbcBuilder = QueryByCriteria.Builder.create();
            qbcBuilder.setPredicates(
                    PredicateFactory.equalIgnoreCase("activityOfferingId", activityOfferingId));
            QueryByCriteria criteria = qbcBuilder.build();

            //Do search. In ideal case, returns one element, which is the desired SeatPool.
            seatPoolDefinitionInfos = searchForSeatpoolDefinitions(criteria, new ContextInfo());
            Collections.sort(seatPoolDefinitionInfos, new Comparator<SeatPoolDefinitionInfo>() {
                @Override
                public int compare(SeatPoolDefinitionInfo o1, SeatPoolDefinitionInfo o2) {
                    if (o1.getProcessingPriority() == null) {
                        return -1;
                    } else if (o2.getProcessingPriority() == null) {
                        return 1;
                    }
                    return o1.getProcessingPriority().compareTo(o2.getProcessingPriority());
                }
            });
        }
        return seatPoolDefinitionInfos;

    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public SeatPoolDefinitionInfo createSeatPoolDefinition(SeatPoolDefinitionInfo seatPoolDefinitionInfo, ContextInfo context)
            throws DataValidationErrorException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        SeatPoolDefinitionEntity poolEntity = new SeatPoolDefinitionEntity(seatPoolDefinitionInfo);
        try {

            poolEntity.setEntityCreated(context);
            poolEntity.setEntityUpdated(context);
            seatPoolDefinitionDao.persist(poolEntity);
        } catch (Exception ex) {
            throw new OperationFailedException("unexpected", ex);
        }
        return poolEntity.toDto();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public SeatPoolDefinitionInfo updateSeatPoolDefinition(String seatPoolDefinitionId,
                                                           SeatPoolDefinitionInfo seatPoolDefinitionInfo,
                                                           ContextInfo context)
            throws DataValidationErrorException,
            DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException,
            ReadOnlyException, ReadOnlyException, VersionMismatchException {
        SeatPoolDefinitionEntity seatPoolDefinitionEntity = seatPoolDefinitionDao.find(seatPoolDefinitionId);
        if (null != seatPoolDefinitionEntity) {
            seatPoolDefinitionEntity.fromDto(seatPoolDefinitionInfo);
            seatPoolDefinitionEntity.setEntityUpdated(context);
            return seatPoolDefinitionDao.merge(seatPoolDefinitionEntity).toDto();
        } else {
            throw new DoesNotExistException("No SeatPool found for seatPoolDefinitionId=" + seatPoolDefinitionId);
        }
    }


    /*
     SeatPoolDefinitionEntity spEntity = this.getSeatPoolDefinitionDao().find(seatPoolDefinitionId);

            if(spEntity == null){
                throw new DoesNotExistException("No Seatpool with id=" + seatPoolDefinitionId);
            }

            spEntity.fromDto(seatPoolDefinitionInfo);
            return seatPoolDefinitionDao.merge(spEntity).toDto();
     */

    @Override
    public List<ValidationResultInfo> validateSeatPoolDefinition(String validationTypeKey,
                                                                 SeatPoolDefinitionInfo seatPoolDefinitionInfo, ContextInfo context) throws DataValidationErrorException,
            DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, VersionMismatchException {
        // TODO: KSENROLL-2658
        return new ArrayList<ValidationResultInfo>();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteSeatPoolDefinition(String seatPoolDefinitionId, ContextInfo context) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        StatusInfo status = new StatusInfo();
        status.setSuccess(Boolean.TRUE);

        SeatPoolDefinitionEntity popEntity = seatPoolDefinitionDao.find(seatPoolDefinitionId);
        if (null != popEntity) {
            seatPoolDefinitionDao.remove(popEntity);
        } else {
            throw new DoesNotExistException(seatPoolDefinitionId);
        }
        return status;
    }


    /**
     * This method allows you to search for Course Offering Ids by Criteria. In order to make this search more usable it has been backed
     * by the "CriteriaLookupService". This service allows us to join accross entities. For example, you are able to pass in
     * "courseOfferingCode" with a value of "CHEM199" even though the code does no live on the LuiEntity (which backs Course Offerings).
     *
     * The CourseOfferingCriteriaTransformer is coded to wire in the additional database joins needed to complete the search.
     *
     * Please look in CourseOfferingCriteriaTransformer for a complete list of available mappings.
     *
     * @param criteria    the search criteria
     * @param context
     * @return
     * @throws InvalidParameterException
     * @throws MissingParameterException
     * @throws OperationFailedException
     * @throws PermissionDeniedException
     */
    @Override
    @Transactional(readOnly = true)
    public List<String> searchForCourseOfferingIds(QueryByCriteria criteria, ContextInfo context) throws InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        GenericQueryResults<LuiEntity> results = criteriaLookupService.lookup(LuiEntity.class, criteria);
        List<String> courseOfferingIds = new ArrayList<String>(results.getResults().size());
        for (LuiEntity lui : results.getResults()) {
            if (_checkTypeForCourseOfferingType(lui.getLuiType())) {
                courseOfferingIds.add(lui.getId());
            }
        }
        return courseOfferingIds;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseOfferingInfo> searchForCourseOfferings(QueryByCriteria criteria, ContextInfo context)
            throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {

        GenericQueryResults<LuiEntity> results = criteriaLookupService.lookup(LuiEntity.class, criteria);
        List<CourseOfferingInfo> courseOfferings = new ArrayList<CourseOfferingInfo>();
        for (LuiEntity lui : results.getResults()) {
            if (_checkTypeForCourseOfferingType(lui.getLuiType())) {
                CourseOfferingInfo co = new CourseOfferingInfo();
                //Associate instructors to the given CO
                courseOfferingTransformer.lui2CourseOffering(lui.toDto(), co, context);
                courseOfferingTransformer.assembleInstructors(co, lui.getId(), context, getLprService());
                courseOfferings.add(co);
            }
        }

        return courseOfferings;
    }

    private void _createLuiLuiRelationForRegGroups(String luiId, String relatedLuiId, String luLuRelationTypeKey, ContextInfo context) throws DataValidationErrorException,
            InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        try {
            LuiLuiRelationInfo luiRel = new LuiLuiRelationInfo();
            luiRel.setLuiId(luiId);
            luiRel.setRelatedLuiId(relatedLuiId);
            luiRel.setStateKey(LuiServiceConstants.LUI_LUI_RELATION_ACTIVE_STATE_KEY);
            luiRel.setEffectiveDate(new Date());
            try {
                luiService.createLuiLuiRelation(luiId, relatedLuiId, luLuRelationTypeKey, luiRel, context);
            } catch (ReadOnlyException roe) {
                throw new OperationFailedException("setting read only fields", roe);
            }
        } catch (CircularRelationshipException e) {
            throw new OperationFailedException();
        } catch (DoesNotExistException e) {
            throw new OperationFailedException();
        }
    }

    @Override
    public List<ActivityOfferingInfo> searchForActivityOfferings(QueryByCriteria criteria, ContextInfo context)
            throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        GenericQueryResults<LuiEntity> results = criteriaLookupService.lookup(LuiEntity.class, criteria);
        List<ActivityOfferingInfo> activityOfferingInfos = new ArrayList<ActivityOfferingInfo>(results.getResults().size());
        for (LuiEntity lui : results.getResults()) {
            try {
                if (_checkTypeForActivityOfferingType(lui.getLuiType(), context)) {
                    ActivityOfferingInfo ao = this.getActivityOffering(lui.getId(), context);
                    activityOfferingInfos.add(ao);
                }
            } catch (DoesNotExistException ex) {
                throw new OperationFailedException(lui.getId(), ex);
            }
        }
        return activityOfferingInfos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> searchForActivityOfferingIds(QueryByCriteria criteria, ContextInfo context) throws InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistrationGroupInfo> searchForRegistrationGroups(QueryByCriteria criteria, ContextInfo context)
            throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        GenericQueryResults<LuiEntity> results = criteriaLookupService.lookup(LuiEntity.class, criteria);

        List<RegistrationGroupInfo> regGroups = new ArrayList<RegistrationGroupInfo>();
        for (LuiEntity lui : results.getResults()) {
            if (_checkTypeForRegistrationGroupType(lui.getLuiType())) {
                RegistrationGroupInfo rgInfo = registrationGroupTransformer.lui2Rg(lui.toDto(), context);
                try {
                    rgInfo.setCourseOfferingId(this.getFormatOffering(rgInfo.getFormatOfferingId(), context).getCourseOfferingId());
                    regGroups.add(rgInfo); // Add the reg group
                } catch (DoesNotExistException ex) {
                    throw new OperationFailedException(rgInfo.getFormatOfferingId(), ex);
                }
            }
        }

        return regGroups;
    }

    private boolean _checkTypeForRegistrationGroupType(String typeKey) {
        return LuiServiceConstants.REGISTRATION_GROUP_TYPE_KEY.equals(typeKey);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> searchForRegistrationGroupIds(QueryByCriteria criteria, ContextInfo context) throws InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {

        GenericQueryResults<LuiEntity> results = criteriaLookupService.lookup(LuiEntity.class, criteria);
        List<String> registrationGroupIds = new ArrayList<String>(results.getResults().size());
        for (LuiEntity lui : results.getResults()) {
            if (_checkTypeForRegistrationGroupType(lui.getLuiType())) {
                registrationGroupIds.add(lui.getId());
            }
        }
        return registrationGroupIds;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SeatPoolDefinitionInfo> searchForSeatpoolDefinitions(QueryByCriteria criteria, ContextInfo context)
            throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {

        GenericQueryResults<SeatPoolDefinitionEntity> results = criteriaLookupService.lookup(SeatPoolDefinitionEntity.class, criteria);
        List<SeatPoolDefinitionInfo> seatPoolDefinitions = new ArrayList<SeatPoolDefinitionInfo>(results.getResults().size());
        for (SeatPoolDefinitionEntity seatPoolEntity : results.getResults()) {
            SeatPoolDefinitionInfo sp = seatPoolEntity.toDto();
            seatPoolDefinitions.add(sp);
        }
        return seatPoolDefinitions;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> searchForSeatpoolDefinitionIds(QueryByCriteria criteria, ContextInfo context) throws InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    private boolean _checkTypeForCourseOfferingType(String typeKey) {
        return typeKey.equals(LuiServiceConstants.COURSE_OFFERING_TYPE_KEY);
    }

    private boolean _checkTypeForActivityOfferingType(String typeKey, ContextInfo context) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<TypeInfo> types = getActivityOfferingTypes(context);
        return _checkTypeInTypes(typeKey, types);
    }

    private boolean _checkTypeInTypes(String typeKey, List<TypeInfo> types) {
        if (types != null && !types.isEmpty()) {
            for (TypeInfo type : types) {
                if (type.getKey().equals(typeKey)) {
                    return true;
                }
            }
        }

        return false;
    }

    public AtpService getAtpService() {
        if (atpService == null) {
            Object o = GlobalResourceLoader.getService(new QName(AtpServiceConstants.NAMESPACE,
                    AtpServiceConstants.SERVICE_NAME_LOCAL_PART));
            atpService = (AtpService) o;
        }
        return atpService;
    }

    public CourseOfferingTransformer getCourseOfferingTransformer() {
        return courseOfferingTransformer;
    }

    public void setCourseOfferingTransformer(CourseOfferingTransformer courseOfferingTransformer) {
        this.courseOfferingTransformer = courseOfferingTransformer;
    }

    public RegistrationGroupTransformer getRegistrationGroupTransformer() {
        return registrationGroupTransformer;
    }

    public void setRegistrationGroupTransformer(RegistrationGroupTransformer registrationGroupTransformer) {
        this.registrationGroupTransformer = registrationGroupTransformer;
    }

    public void setAtpService(AtpService atpService) {
        this.atpService = atpService;
    }

    public void setOfferingCodeGenerator(CourseOfferingCodeGenerator offeringCodeGenerator) {
        this.offeringCodeGenerator = offeringCodeGenerator;
    }


    public TermAssembler getTermAssembler() {
        if (termAssembler == null) {
            setTermAssembler(new TermAssembler());
        }
        return termAssembler;
    }

    public void setTermAssembler(TermAssembler termAssembler) {
        this.termAssembler = termAssembler;
    }


    @Override
    @Transactional(readOnly = true)
    public TypeInfo getCourseOfferingType(String courseOfferingTypeKey,
                                          ContextInfo context) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeInfo> getCourseOfferingTypes(ContextInfo context)
            throws InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeInfo> getInstructorTypesForCourseOfferingType(
            String courseOfferingTypeKey, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeInfo> getInstructorTypesForActivityOfferingType(
            String activityOfferingTypeKey, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public StatusInfo addSeatPoolDefinitionToActivityOffering(String seatPoolDefinitionId, String activityOfferingId,
                                                              ContextInfo contextInfo)
            throws AlreadyExistsException,
            DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        // should be supported by M4
        LuiInfo lui = luiService.getLui(activityOfferingId, contextInfo);
        if (lui == null) {
            throw new DoesNotExistException("Activity offering ID does not exist: " + activityOfferingId);
        }
        // The seat pool definition is connected only via the entity.  The DTO does not store the
        // activity offering ID.
        SeatPoolDefinitionEntity seatPoolEntity = seatPoolDefinitionDao.find(seatPoolDefinitionId);
        seatPoolEntity.setActivityOfferingId(activityOfferingId);
        seatPoolDefinitionDao.merge(seatPoolEntity);
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(Boolean.TRUE);
        return statusInfo;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo removeSeatPoolDefinitionFromActivityOffering(
            String seatPoolDefinitionId, String activityOfferingId,
            ContextInfo contextInfo) throws DoesNotExistException,
            InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        // should be supported in M4
        LuiInfo lui = luiService.getLui(activityOfferingId, contextInfo);
        if (lui == null) {
            throw new DoesNotExistException("Activity offering ID does not exist: " + activityOfferingId);
        }
        // The seat pool definition is connected only via the entity.  The DTO does not store the
        // activity offering ID.
        SeatPoolDefinitionEntity seatPoolEntity = seatPoolDefinitionDao.find(seatPoolDefinitionId);
        String fetchedId = seatPoolEntity.getActivityOfferingId();
        if (!fetchedId.equals(activityOfferingId)) {
            throw new InvalidParameterException("activityOfferingId does not match the one in seatpool: " + activityOfferingId);
        }
        seatPoolEntity.setActivityOfferingId(null); // Remove the activity offering ID.
        seatPoolDefinitionDao.merge(seatPoolEntity);
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(Boolean.TRUE);
        return statusInfo;
    }

    @Override
    public StatusInfo updateCourseOfferingState(
            @WebParam(name = "courseOfferingId") String courseOfferingId,
            @WebParam(name = "nextStateKey") String nextStateKey,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        //TODO validation and state lifecylce checks
        LuiInfo lui = luiService.getLui(courseOfferingId, contextInfo);
        lui.setStateKey(nextStateKey);
        try{
            luiService.updateLui(lui.getId(), lui, contextInfo);
        }catch(Exception e){
            throw new OperationFailedException("Failed to update State", e);
        }
        return new StatusInfo();
    }

    @Override
    public StatusInfo updateFormatOfferingState(
            @WebParam(name = "formatOfferingId") String formatOfferingId,
            @WebParam(name = "nextStateKey") String nextStateKey,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        //TODO validation and state lifecylce checks
        LuiInfo lui = luiService.getLui(formatOfferingId, contextInfo);
        lui.setStateKey(nextStateKey);
        try{
            luiService.updateLui(lui.getId(), lui, contextInfo);
        }catch(Exception e){
            throw new OperationFailedException("Failed to update State", e);
        }
        return new StatusInfo();
    }

    @Override
    public StatusInfo updateActivityOfferingState(
            String activityOfferingId,
            String nextStateKey,
            ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {

        //TODO validation and state lifecylce checks
        LuiInfo lui = luiService.getLui(activityOfferingId, contextInfo);
        lui.setStateKey(nextStateKey);
        try{
            luiService.updateLui(lui.getId(), lui, contextInfo);
        }catch(Exception e){
            throw new OperationFailedException("Failed to update State", e);
        }
        return new StatusInfo();
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo updateRegistrationGroupState(
            String registrationGroupId,
            String nextStateKey,
            ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {

        LuiInfo lui = luiService.getLui(registrationGroupId, contextInfo);
        lui.setStateKey(nextStateKey); // Only modify the state key, and nothing else
        boolean exceptionOccurred = false;
        String exceptionMessage = "None";
        try {
            luiService.updateLui(lui.getId(), lui, contextInfo);
        } catch (DataValidationErrorException e) {
            exceptionOccurred = true;
            exceptionMessage = e.getMessage();
        } catch (ReadOnlyException e) {
            exceptionOccurred = true;
            exceptionMessage = e.getMessage();
        } catch (VersionMismatchException e) {
            exceptionOccurred = true;
            exceptionMessage = e.getMessage();
        }
        if (exceptionOccurred) {
            throw new OperationFailedException(exceptionMessage);
        }
        StatusInfo status = new StatusInfo ();
        status.setSuccess(Boolean.TRUE);
        return status;
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo updateActivityOfferingClusterState(
            String activityOfferingClusterId,
            String nextStateKey,
            ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {

        ActivityOfferingClusterEntity entity = activityOfferingClusterDao.find(activityOfferingClusterId);
        if (entity == null) {
            throw new DoesNotExistException(activityOfferingClusterId);
        }
        // TODO: Is it OK if the state does not change?
        entity.setActivityOfferingClusterState(nextStateKey);
        this._logAOCStateChange(entity, contextInfo);
        entity.setEntityUpdated(contextInfo);
        activityOfferingClusterDao.merge(entity);
        StatusInfo status = new StatusInfo ();
        status.setSuccess(Boolean.TRUE);
        return status;
    }

    private void _logAOCStateChange(ActivityOfferingClusterEntity entity, ContextInfo contextInfo) {
        // add the state change to the log
        // TODO: consider changing this to a call to a real logging facility instead of stuffing it in the dynamic attributes
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date date = contextInfo.getCurrentDate();
        AttributeInfo attr = new AttributeInfo(entity.getActivityOfferingClusterState(), formatter.format(date));
        entity.getAttributes().add(new ActivityOfferingClusterAttributeEntity(attr, entity));
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo updateSeatPoolDefinitionState(
            @WebParam(name = "seatPoolDefinitionId") String seatPoolDefinitionId,
            @WebParam(name = "nextStateKey") String nextStateKey,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        throw new UnsupportedOperationException("To be Implemented in M5");
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistrationGroupInfo> getRegistrationGroupsByActivityOfferingCluster(
            String activityOfferingClusterId, ContextInfo contextInfo)
              throws DoesNotExistException, InvalidParameterException,
                     MissingParameterException, OperationFailedException,
                     PermissionDeniedException {

        ActivityOfferingClusterInfo aoCInfo = getActivityOfferingCluster(activityOfferingClusterId, contextInfo);
        List<RegistrationGroupInfo> regGroupsForAOC = new ArrayList<RegistrationGroupInfo>();
        List<RegistrationGroupInfo> regGroups = getRegistrationGroupsByFormatOffering(aoCInfo.getFormatOfferingId(),contextInfo);

        for (RegistrationGroupInfo regGroup : regGroups) {
            if (regGroup.getActivityOfferingClusterId().equals(activityOfferingClusterId)) {
                regGroupsForAOC.add(regGroup);
            }
        }

        return regGroupsForAOC;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityOfferingInfo> getActivityOfferingsByCluster(
            String activityOfferingClusterId,
            ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        List<String> aoIds = activityOfferingClusterDao.getActivityOfferingIdsByClusterId(activityOfferingClusterId);
        return getActivityOfferingsByIds(aoIds, contextInfo);
    }

    @Override
    @Transactional(readOnly = false, noRollbackFor = {DoesNotExistException.class}, rollbackFor = {Throwable.class})
    public StatusInfo deleteActivityOfferingClusterCascaded(
            String activityOfferingClusterId,
            ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException,
            PermissionDeniedException {

        List<RegistrationGroupInfo> rgInfos =
                getRegistrationGroupsByActivityOfferingCluster(activityOfferingClusterId, contextInfo);
        List<String> failedToDelete = new ArrayList<String>();
        for (RegistrationGroupInfo rgInfo: rgInfos) {
            String id = rgInfo.getId();
            try {
                // Delete as many as you can...
                StatusInfo statusInfo = deleteRegistrationGroup(id, contextInfo);
                if (!statusInfo.getIsSuccess()) {
                    failedToDelete.add(id);
                }
            } catch (Exception e) {
                failedToDelete.add(id);
            }
        }
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setSuccess(Boolean.TRUE);
        if (failedToDelete.isEmpty()) {
            try {
                // Call non-cascaded version
                deleteActivityOfferingCluster(activityOfferingClusterId, contextInfo);
            } catch (DependentObjectsExistException e) {
                statusInfo.setSuccess(Boolean.FALSE);
                statusInfo.setMessage("Dependent objects exist: " + e.getMessage());
            }
        } else {
            // Some reg groups still exist, so error.
            statusInfo.setSuccess(Boolean.FALSE);
            StringBuffer buffer = new StringBuffer("Failed to delete:");
            for (String str: failedToDelete) {
                buffer.append(" " + str);
            }
            statusInfo.setMessage(buffer.toString());
        }
        if (!statusInfo.getIsSuccess()) {
            // Only doing this because the mock impl appears to do this too.
            throw new OperationFailedException(statusInfo.getMessage());
        }
        return statusInfo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getActivityOfferingClustersIdsByFormatOffering(
            @WebParam(name = "formatOfferingId") String formatOfferingId,
            @WebParam(name = "contextInfo") ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException,
            PermissionDeniedException {
        List<ActivityOfferingClusterEntity> entities = activityOfferingClusterDao.getByFormatOffering(formatOfferingId);
        List<String> list = new ArrayList<String>(entities.size());
        for (ActivityOfferingClusterEntity entity : entities) {
            list.add(entity.getId());
        }
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> searchForActivityOfferingClusterIds(QueryByCriteria criteria, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        GenericQueryResults<ActivityOfferingClusterEntity> results = criteriaLookupService.lookup(ActivityOfferingClusterEntity.class, criteria);
        List<String> ids = new ArrayList<String>(results.getResults().size());
        for (ActivityOfferingClusterEntity activityOfferingClusterEntity : results.getResults()) {
            ids.add(activityOfferingClusterEntity.getId());
        }
        return ids;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityOfferingClusterInfo> searchForActivityOfferingClusters(QueryByCriteria criteria, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        GenericQueryResults<ActivityOfferingClusterEntity> results = criteriaLookupService.lookup(ActivityOfferingClusterEntity.class, criteria);
        List<ActivityOfferingClusterInfo> activityOfferingClusterInfos = new ArrayList<ActivityOfferingClusterInfo>(results.getResults().size());
        for (ActivityOfferingClusterEntity activityOfferingClusterEntity : results.getResults()) {
            ActivityOfferingClusterInfo aocInfo = activityOfferingClusterEntity.toDto();
            activityOfferingClusterInfos.add(aocInfo);
        }
        return activityOfferingClusterInfos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> searchForFormatOfferingIds(QueryByCriteria criteria, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        GenericQueryResults<LuiEntity> results = criteriaLookupService.lookup(LuiEntity.class, criteria);
        List<String> ids = new ArrayList<String>(results.getResults().size());
        for (LuiEntity lui : results.getResults()) {
            // TODO: instead change this so this apply this in the where clause as a transform to the criteria
            if (_checkTypeForFormatOfferingType(lui.getLuiType())) {
                ids.add(lui.getId());
            }
        }
        return ids;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatOfferingInfo> searchForFormatOfferings(QueryByCriteria criteria, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        GenericQueryResults<LuiEntity> results = criteriaLookupService.lookup(LuiEntity.class, criteria);
        List<FormatOfferingInfo> infos = new ArrayList<FormatOfferingInfo>(results.getResults().size());
        for (LuiEntity lui : results.getResults()) {
            try {
                // TODO: instead change this so this apply this in the where clause as a transform to the criteria
                if (_checkTypeForFormatOfferingType(lui.getLuiType())) {
                    FormatOfferingInfo co = this.getFormatOffering(lui.getId(), contextInfo);
                    infos.add(co);
                }
            } catch (DoesNotExistException ex) {
                throw new OperationFailedException(lui.getId(), ex);
            }
        }
        return infos;
    }

    private boolean _checkTypeForFormatOfferingType(String typeKey) {
        return typeKey.equals(LuiServiceConstants.FORMAT_OFFERING_TYPE_KEY);
    }

    public SchedulingService getSchedulingService() {
        return schedulingService;
    }

    public void setSchedulingService(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    public void setLrcService(LRCService lrcService) {
        this.lrcService = lrcService;
    }
}