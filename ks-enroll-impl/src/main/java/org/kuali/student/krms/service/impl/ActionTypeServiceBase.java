package org.kuali.student.krms.service.impl;

import org.kuali.rice.krms.api.repository.action.ActionDefinition;
import org.kuali.rice.krms.framework.engine.Action;
import org.kuali.rice.krms.framework.type.ActionTypeService;
import org.kuali.rice.krms.impl.type.KrmsTypeServiceBase;
import org.kuali.student.krms.action.RDLAction;
import org.kuali.student.r2.core.scheduling.service.SchedulingService;
import org.kuali.student.r2.core.scheduling.util.SchedulingServiceUtil;

/**
 * Created with IntelliJ IDEA.
 * User: SW Genis
 * Date: 2013/08/21
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActionTypeServiceBase extends KrmsTypeServiceBase implements ActionTypeService {

    public static final ActionTypeServiceBase defaultActionTypeService = new ActionTypeServiceBase();
    private static final String NAME_ATTRIBUTE = "name";

    @Override
    public Action loadAction(ActionDefinition actionDefinition) {
        return null;
    }

    protected Action buildRDLAction(ActionDefinition actionDefinition){
        return null;
    }

}