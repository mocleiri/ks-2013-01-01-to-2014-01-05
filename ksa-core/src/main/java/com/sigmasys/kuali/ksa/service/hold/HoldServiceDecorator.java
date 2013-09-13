package com.sigmasys.kuali.ksa.service.hold;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.kim.api.identity.IdentityService;
import org.kuali.rice.kim.api.identity.principal.Principal;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.student.enrollment.class1.hold.service.impl.HoldServiceImpl;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.exceptions.*;
import org.kuali.student.r2.core.hold.dto.AppliedHoldInfo;
import org.kuali.student.r2.core.hold.dto.HoldIssueInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * KSA-specific HoldService implementation.
 *
 * @author Michael Ivanov
 */
public class HoldServiceDecorator extends HoldServiceImpl implements HoldService {

    private static final Log logger = LogFactory.getLog(HoldServiceDecorator.class);

    @Override
    public AppliedHoldInfo createAppliedHold(String personId, String issueId, String holdTypeKey, AppliedHoldInfo holdInfo, ContextInfo context) throws DataValidationErrorException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        AppliedHoldInfo appliedHoldInfo = super.createAppliedHold(personId, issueId, holdTypeKey, holdInfo, context);
        getAppliedHoldDao().getEm().flush();
        return appliedHoldInfo;
    }

    @Override
    public AppliedHoldInfo updateAppliedHold(String holdId, AppliedHoldInfo holdInfo, ContextInfo context) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, VersionMismatchException {
        AppliedHoldInfo appliedHoldInfo = super.updateAppliedHold(holdId, holdInfo, context);
        getAppliedHoldDao().getEm().flush();
        return appliedHoldInfo;
    }

    @Override
    public AppliedHoldInfo releaseAppliedHold(String holdId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        AppliedHoldInfo appliedHoldInfo = super.releaseAppliedHold(holdId, context);
        getAppliedHoldDao().getEm().flush();
        return appliedHoldInfo;
    }

    @Override
    public StatusInfo deleteAppliedHold(String holdId, ContextInfo context) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        StatusInfo statusInfo = super.deleteAppliedHold(holdId, context);
        getAppliedHoldDao().getEm().flush();
        return statusInfo;
    }

    @Override
    public HoldIssueInfo createHoldIssue(String issueTypeKey, HoldIssueInfo issueInfo, ContextInfo context) throws DataValidationErrorException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        HoldIssueInfo holdIssueInfo = super.createHoldIssue(issueTypeKey, issueInfo, context);
        getHoldIssueDao().getEm().flush();
        return holdIssueInfo;
    }

    @Override
    public HoldIssueInfo updateHoldIssue(String issueId, HoldIssueInfo issueInfo, ContextInfo context) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, VersionMismatchException {
        HoldIssueInfo holdIssueInfo = super.updateHoldIssue(issueId, issueInfo, context);
        getHoldIssueDao().getEm().flush();
        return holdIssueInfo;
    }

    @Override
    public StatusInfo deleteHoldIssue(String issueId, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, DependentObjectsExistException {
        StatusInfo statusInfo = super.deleteHoldIssue(issueId, contextInfo);
        getHoldIssueDao().getEm().flush();
        return statusInfo;
    }

    /**
     * Retrieves HoldIssueInfo objects by User ID and ContextInfo.
     *
     * @param userId  User ID
     * @param context ContextInfo instance
     * @return list of HoldIssueInfo instances
     */
    @Override
    @Transactional(readOnly = true)
    public List<HoldIssueInfo> getHoldIssuesByUserId(String userId, ContextInfo context) {

        IdentityService identityService = KimApiServiceLocator.getIdentityService();
        if (identityService == null) {
            String errMsg = "IdentityService cannot be null";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        Principal principal = identityService.getPrincipalByPrincipalName(userId);
        if (principal == null) {
            String errMsg = "Principal '" + userId + "' does not exist";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        try {

            List<AppliedHoldInfo> appliedHolds = getAppliedHoldsByPerson(principal.getPrincipalId(), context);

            if (CollectionUtils.isNotEmpty(appliedHolds)) {

                Set<String> holdIssueIds = new HashSet<String>();

                for (AppliedHoldInfo appliedHold : appliedHolds) {
                    holdIssueIds.add(appliedHold.getHoldIssueId());
                }

                return getHoldIssuesByIds(new ArrayList<String>(holdIssueIds), context);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return Collections.emptyList();
    }

}
