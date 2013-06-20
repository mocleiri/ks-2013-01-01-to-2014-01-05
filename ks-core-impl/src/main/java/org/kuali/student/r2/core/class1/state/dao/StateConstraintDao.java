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
 * Created by chongzhu on 11/15/12
 */
package org.kuali.student.r2.core.class1.state.dao;

import org.kuali.student.r2.common.dao.GenericEntityDao;
import org.kuali.student.r2.core.class1.state.model.StateConstraintEntity;

import java.util.List;

/**
 * This class contains the methods to operate on StateConstraintEntity
 *
 * @author Kuali Student Team
 */
public class StateConstraintDao  extends GenericEntityDao<StateConstraintEntity> {
    public List<StateConstraintEntity> getStateConstraintIdsByType(String stateConstraintTypeKey) {
        return (List<StateConstraintEntity>) em.createQuery("from StateConstraintEntity sce where sce.typeKey = :stateConstraintTypeKey")
                .setParameter("typeKey", stateConstraintTypeKey)
                .getResultList();
    }
}
