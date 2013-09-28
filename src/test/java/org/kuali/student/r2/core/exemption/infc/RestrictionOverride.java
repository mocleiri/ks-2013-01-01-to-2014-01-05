/**
 * Copyright 2004-2013 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.r2.core.exemption.infc;


/**
 * Information about a RestrictionOverride. A Restriction override
 * describes data related to ignoring a restriction defined in the
 * Hold service.
 *
 * @author tom
 * @since Tue Jun 14 14:22:34 EDT 2011
 */ 
public interface RestrictionOverride {

    /**
     * Name: Restriction Key
     * The key for the Restriction.
     */
    public String getRestrictionKey();
}
