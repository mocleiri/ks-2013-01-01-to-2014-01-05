package com.sigmasys.kuali.ksa.service.hold;

import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.hold.dto.HoldIssueInfo;

import java.util.List;

/**
 * KSA-specific HoldService interface inherited from KS's HoldService
 *
 * @author Michael Ivanov
 */
public interface HoldService extends org.kuali.student.r2.core.hold.service.HoldService {

    /**
     * Retrieves HoldIssueInfo objects by User ID and ContextInfo.
     *
     * @param userId  User ID
     * @param context ContextInfo instance
     * @return list of HoldIssueInfo instances
     */
    List<HoldIssueInfo> getHoldIssuesByUserId(String userId, ContextInfo context);

}
