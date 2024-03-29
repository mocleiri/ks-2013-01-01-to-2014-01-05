/**
 * Copyright 2012 The Kuali Foundation Licensed under the
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
 * Created by Mezba Mahtab on 7/2/12
 */
package org.kuali.student.enrollment.test.util;

import org.kuali.student.r2.common.dto.EntityInfo;

import static org.junit.Assert.assertEquals;

/**
 * This class helps test key entities.
 *
 * @author Mezba Mahtab
 */
public class EntityInfoTester {
    public void check(EntityInfo expected, EntityInfo actual) {
        assertEquals(expected.getTypeKey(), actual.getTypeKey());
        assertEquals(expected.getStateKey(), actual.getStateKey());
        assertEquals(expected.getName(), actual.getName());
        new RichTextTester().check(expected.getDescr(), actual.getDescr());
    }
}
