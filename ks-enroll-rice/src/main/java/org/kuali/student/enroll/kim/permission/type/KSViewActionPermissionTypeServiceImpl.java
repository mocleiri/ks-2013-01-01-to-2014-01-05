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
 * Created by vgadiyak on 1/15/13
 */
package org.kuali.student.enroll.kim.permission.type;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.kim.api.KimConstants;
import org.kuali.rice.kim.api.permission.Permission;
import org.kuali.rice.kim.impl.permission.PermissionBo;
import org.kuali.rice.krad.kim.ViewActionPermissionTypeServiceImpl;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class //TODO ...
 *
 * @author Kuali Student Team
 */
public class KSViewActionPermissionTypeServiceImpl extends ViewActionPermissionTypeServiceImpl {

    @Override
    protected List<Permission> performPermissionMatches(Map<String, String> requestedDetails,
                                                        List<Permission> permissionsList) {
        List<Permission> matchedPermissions = super.performPermissionMatches(requestedDetails, permissionsList);
        return KSPermissionDetailsExpressionEvaluator.performPermissionMatches(requestedDetails, matchedPermissions);
    }
}
