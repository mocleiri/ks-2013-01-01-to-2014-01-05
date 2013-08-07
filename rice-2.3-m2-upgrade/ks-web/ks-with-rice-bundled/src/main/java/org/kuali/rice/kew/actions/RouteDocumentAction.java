/**
 * Copyright 2005-2012 The Kuali Foundation
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
package org.kuali.rice.kew.actions;

import org.apache.log4j.MDC;
import org.kuali.rice.kew.actionrequest.ActionRequestValue;
import org.kuali.rice.kew.actiontaken.ActionTakenValue;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kew.api.exception.InvalidActionTakenException;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kew.engine.node.ProcessDefinitionBo;
import org.kuali.rice.kew.routeheader.DocumentRouteHeaderValue;
import org.kuali.rice.kew.service.KEWServiceLocator;
import org.kuali.rice.kim.api.identity.principal.PrincipalContract;

import java.sql.Timestamp;
import java.util.List;


/**
 * //TODO KSENROLL-5346 DELETE THIS ONCE KRAD IS UPGRADED!!!
 *
 * Action that puts the document in routing. For zero node paths this fixes a bug where the document was never saved
 * because it went straight to final skipping processed.
 *
 * @author Kuali Rice Team (rice.collab@kuali.org)
 *
 */
@Deprecated
//TODO KSENROLL-5346 DELETE THIS ONCE KRAD IS UPGRADED!!!
public class RouteDocumentAction extends ActionTakenEvent {
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(RouteDocumentAction.class);

    public RouteDocumentAction(DocumentRouteHeaderValue rh, PrincipalContract principal) {
        super(KewApiConstants.ACTION_TAKEN_COMPLETED_CD, rh, principal);
    }

    public RouteDocumentAction(DocumentRouteHeaderValue rh, PrincipalContract principal, String annotation) {
        super(KewApiConstants.ACTION_TAKEN_COMPLETED_CD, rh, principal, annotation);
    }

    /* (non-Javadoc)
     * @see org.kuali.rice.kew.actions.ActionTakenEvent#getActionPerformedCode()
     */
    @Override
    public String getActionPerformedCode() {
        return KewApiConstants.ACTION_TAKEN_ROUTED_CD;
    }

    /* (non-Javadoc)
     * @see org.kuali.rice.kew.actions.ActionTakenEvent#isActionCompatibleRequest(java.util.List)
     */
    @Override
    public String validateActionRules() {
    	// check state before checking kim
        if (!getRouteHeader().isValidActionToTake(getActionPerformedCode())) {
            return "Document is not in a state to be routed";
        }
    	if (! KEWServiceLocator.getDocumentTypePermissionService().canRoute(getPrincipal().getPrincipalId(), getRouteHeader())) {
    		return "User is not authorized to Route document";
    	}
        return "";
    }

    @Override
    public String validateActionRules(List<ActionRequestValue> actionRequests) {
    	return validateActionRules();
    }
    
    /**
     * Record the routing action. To route a document, it must be in the proper state. Previous requests and actions have no bearing on the outcome of this action, unless the
     * @throws org.kuali.rice.kew.api.exception.InvalidActionTakenException
     */
    public void recordAction() throws InvalidActionTakenException {
        MDC.put("docId", getRouteHeader().getDocumentId());
        updateSearchableAttributesIfPossible();

        LOG.debug("Routing document : " + annotation);

        LOG.debug("Checking to see if the action is legal");
        String errorMessage = validateActionRules();
        if (!org.apache.commons.lang.StringUtils.isEmpty(errorMessage)) {
            throw new InvalidActionTakenException(errorMessage);
        }


        // we want to check that the "RouteDocument" command is valid here, not the "Complete" command (which is in our Action's action taken code)
        LOG.debug("Record the routing action");
        ActionTakenValue actionTaken = saveActionTaken();

        //TODO this will get all pending AR's even if they haven't been in an action list... This seems bad
        List<ActionRequestValue> actionRequests = getActionRequestService().findPendingByDoc(getDocumentId());
        LOG.debug("Deactivate all pending action requests");
        // deactivate any requests for the user that routed the document.
        for (ActionRequestValue actionRequest : actionRequests)
        {
            // requests generated to the user who is routing the document should be deactivated
            if ((getPrincipal().getPrincipalId().equals(actionRequest.getPrincipalId())) && (actionRequest.isActive()))
            {
                getActionRequestService().deactivateRequest(actionTaken, actionRequest);
            }
            // requests generated by a save action should be deactivated
            else if (KewApiConstants.SAVED_REQUEST_RESPONSIBILITY_ID.equals(actionRequest.getResponsibilityId()))
            {
                getActionRequestService().deactivateRequest(actionTaken, actionRequest);
            }
        }

            notifyActionTaken(actionTaken);

            try {
                String oldStatus = getRouteHeader().getDocRouteStatus();
                getRouteHeader().markDocumentEnroute();
                
                if (((ProcessDefinitionBo)getRouteHeader().getDocumentType().getProcesses().get(0)).getInitialRouteNode() == null) {
                    getRouteHeader().setApprovedDate(new Timestamp(System.currentTimeMillis()));
                    getRouteHeader().markDocumentProcessed();

                    getRouteHeader().setRoutedByUserWorkflowId(getPrincipal().getPrincipalId());

                    String newStatus = getRouteHeader().getDocRouteStatus();
                    notifyStatusChange(newStatus, oldStatus);
                    KEWServiceLocator.getRouteHeaderService().saveRouteHeader(getRouteHeader());

                    getRouteHeader().markDocumentFinalized();
                }

                getRouteHeader().setRoutedByUserWorkflowId(getPrincipal().getPrincipalId());

                String newStatus = getRouteHeader().getDocRouteStatus();
                notifyStatusChange(newStatus, oldStatus);
                KEWServiceLocator.getRouteHeaderService().saveRouteHeader(getRouteHeader());
            } catch (WorkflowException ex) {
                LOG.warn(ex, ex);
	            throw new InvalidActionTakenException(ex.getMessage());
            }

    }
}
