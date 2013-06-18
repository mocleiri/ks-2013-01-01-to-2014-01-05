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
 * Created by Charles on 6/10/13
 */
package org.kuali.student.r2.core.acal.service.facade;

import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;

/**
 * We expect to replace the void
 *
 * @author Kuali Student Team
 */
public interface AcademicCalendarServiceFacade {
    /**
     * Changes the state of the term and any ancestor term official, as well as the calendar.
     * KSENROLL-7251
     * @param termId The term whose state is made official
     * @param contextInfo The context info
     */
    void makeTermOfficialCascaded(String termId, ContextInfo contextInfo)
            throws PermissionDeniedException, MissingParameterException, InvalidParameterException,
            OperationFailedException, DoesNotExistException;

    /**
     * Cascaded version of delete. This method will delete the given term and all its sub terms (if any sub term also has
     * sub terms, they will be deleted as well ) only if all the term/sub terms have the draft state. As long as there is
     * one term or sub term with the official state, none of the term or sub term in the tree will be deleted.
     * @param termId
     * @param context
     * @return the status of the operation. This must always be true.
     */
    StatusInfo deleteTermCascaded(String termId, ContextInfo context) throws
        DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException,
        PermissionDeniedException;

    /**
     * deleteCalendarCascaded
     * @param academicCalendarId ID for academic calendar
     * @param context
     */
    StatusInfo deleteCalendarCascaded(String academicCalendarId, ContextInfo context) throws
            DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException;
}
