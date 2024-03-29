/*
 * Copyright 2012 The Kuali Foundation Licensed under the
 *  Educational Community License, Version 2.0 (the "License"); you may
 *  not use this file except in compliance with the License. You may
 *  obtain a copy of the License at
 *  
 *   http://www.osedu.org/licenses/ECL-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an "AS IS"
 *  BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 *  or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */

package org.kuali.student.r2.core.scheduling.infc;

import org.kuali.student.r2.common.infc.IdNamelessEntity;
import org.kuali.student.r2.common.infc.Status;

import java.util.Date;

/**
 * @Version 2.0
 * @Author Sri komandur@uw.edu
 */
public interface ScheduleBatchResp extends IdNamelessEntity{

    /**
     * Date when the batch was submitted
     * 
     * @name Submitted Date
     * @required
     */
    public Date getSubmittedDate();

    /**
     * Status message
     *
     * @name Status Message
     */
    public String getStatusMessage();

    /**
     * Overall status of the scheduling transaction
     * 
     * @name Status
     */
    public Status getFinalStatus();

}
