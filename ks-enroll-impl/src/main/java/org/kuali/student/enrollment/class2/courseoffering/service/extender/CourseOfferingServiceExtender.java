/**
 * Copyright 2013 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * Created by Charles on 11/12/13
 */
package org.kuali.student.enrollment.class2.courseoffering.service.extender;

import org.kuali.student.enrollment.courseoffering.dto.ActivityOfferingInfo;
import org.kuali.student.enrollment.courseoffering.dto.FormatOfferingInfo;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingService;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.exceptions.ReadOnlyException;

import java.util.List;
import java.util.Map;

/**
 * This adds additional API calls not found in CourseOfferingServiceImpl.  CourseOfferingServiceImpl can call into
 * these methods, as well as the app that can access the extender.  The purpose is to provide more efficient APIs
 * without altering the service contract.
 *
 * @author Kuali Student Team
 */
public interface CourseOfferingServiceExtender {
    public List<String> getActivityTypesForFormatId(String id, ContextInfo context)
            throws InvalidParameterException, MissingParameterException, PermissionDeniedException, OperationFailedException;

    public List<ValidationResultInfo> verifyRegistrationGroup(String registrationGroupId, ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException;

    List<ValidationResultInfo> verifyRegistrationGroup(List<String> aoIds, ContextInfo contextInfo)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException;

    /**
     * This method calls the search service to pull a list of AO Codes for a given CO. This is MUCH faster than
     * our old way of pulling the FULL ao objects, when we just need the code.
     *
     * @param courseOfferingId  The CourseOffering ID of the Course Offering that you want to return all AO codes for.
     * @param context  application contextInfo object
     * @return returns a Map<AO_ID, AO_CODE>
     * @throws OperationFailedException
     */
    Map<String, String> computeAoIdToAoCodeMapByCourseOffering(String courseOfferingId, ContextInfo context)
            throws OperationFailedException;

    /**
     * Long version of copyActivityOffering
     * @param sourceAo The AO to copy from
     * @param coService Handle to course offering service (awkward, but avoids circular references)
     * @param targetFo The target format offering
     * @param targetTermId The target term ID
     * @param context Context
     * @param optionKeys options used in Copy CO/rollover
     * @return the AO created
     */
    ActivityOfferingInfo copyActivityOffering(ActivityOfferingInfo sourceAo,
                                              CourseOfferingService coService,
                                              FormatOfferingInfo targetFo,
                                              String targetTermId,
                                              ContextInfo context,
                                              List<String> optionKeys)
            throws PermissionDeniedException, MissingParameterException, InvalidParameterException,
            OperationFailedException, DoesNotExistException, ReadOnlyException, DataValidationErrorException;

    /**
     * Used by CourseOfferingServiceImpl::copyActivityOffering
     * @param sourceAo The AO to copy from
     * @param coService Handle to course offering service (awkward, but avoids circular references)
     * @param context Context
     * @return The created AO
     */
    ActivityOfferingInfo copyActivityOffering(ActivityOfferingInfo sourceAo,
                                              CourseOfferingService coService,
                                              ContextInfo context)
        throws PermissionDeniedException, MissingParameterException, InvalidParameterException,
            OperationFailedException, DoesNotExistException, ReadOnlyException, DataValidationErrorException;

}