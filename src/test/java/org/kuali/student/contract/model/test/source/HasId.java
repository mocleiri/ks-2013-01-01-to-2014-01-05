/**
 * Copyright 2004-2014 The Kuali Foundation
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
package org.kuali.student.contract.model.test.source;

/**
 *
 * @author nwright
 */
public interface HasId extends HasPrimaryKey {

    /**
     * The system assigned unique id to identify this Object.
     * Could be implemented as as sequence number or as a UUID.
     *
     * Attempts to set this value on creates should result in a ReadOnlyException being thrown
     *
     * An Id:<ul>
     * <li>An id is used when the actual value is unimportant and can therefore be a large hex value for example
     * <li>An id value might be 23b9ca9bd203df902
     * <li>An Id is never intended to be used directly by an end user.
     * <li>Ids are assumed to be of different values in different KS implementations
     * <li>Id values are generated by the service implementations
     * <li>Id values are never expected to be used in Configuration or Application code
     * </ul>
     * @name Unique Id
     * @readOnly
     * @required on update
     */
    public String getId();
}
