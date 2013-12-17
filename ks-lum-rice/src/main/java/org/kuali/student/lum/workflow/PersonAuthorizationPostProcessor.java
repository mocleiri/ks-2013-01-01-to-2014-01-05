package org.kuali.student.lum.workflow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kew.api.KewApiServiceLocator;
import org.kuali.rice.kew.api.WorkflowDocument;
import org.kuali.rice.kew.api.WorkflowDocumentFactory;
import org.kuali.rice.kew.api.action.ActionTaken;
import org.kuali.rice.kew.api.action.ActionType;
import org.kuali.rice.kew.api.document.WorkflowDocumentService;
import org.kuali.rice.kew.framework.postprocessor.ActionTakenEvent;
import org.kuali.rice.kew.framework.postprocessor.AfterProcessEvent;
import org.kuali.rice.kew.framework.postprocessor.BeforeProcessEvent;
import org.kuali.rice.kew.framework.postprocessor.DeleteEvent;
import org.kuali.rice.kew.framework.postprocessor.DocumentLockingEvent;
import org.kuali.rice.kew.framework.postprocessor.DocumentRouteLevelChange;
import org.kuali.rice.kew.framework.postprocessor.DocumentRouteStatusChange;
import org.kuali.rice.kew.framework.postprocessor.IDocumentEvent;
import org.kuali.rice.kew.framework.postprocessor.PostProcessor;
import org.kuali.rice.kew.framework.postprocessor.ProcessDocReport;
import org.kuali.rice.kim.api.identity.principal.Principal;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.rice.student.StudentWorkflowConstants;
import org.kuali.rice.student.bo.KualiStudentKimAttributes;
import org.kuali.student.r1.common.rice.StudentIdentityConstants;
import org.kuali.student.r1.core.proposal.ProposalConstants;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.util.ContextUtils;
import org.kuali.student.r2.core.constants.ProposalServiceConstants;
import org.kuali.student.r2.core.proposal.dto.ProposalInfo;
import org.kuali.student.r2.core.proposal.service.ProposalService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true, rollbackFor={Throwable.class})
public class PersonAuthorizationPostProcessor  implements PostProcessor{


	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(PersonAuthorizationPostProcessor.class);

    private ProposalService proposalService;  
    
    protected ProposalService getProposalService() {
        if (this.proposalService == null) {
            this.proposalService = (ProposalService) GlobalResourceLoader.getService(new QName("http://student.kuali.org/wsdl/proposal","ProposalService"));
        }
        return this.proposalService;
    }

    protected WorkflowDocumentService getWorkflowDocumentService() {
		return KewApiServiceLocator.getWorkflowDocumentService();
	}

	@Override
	public ProcessDocReport doRouteStatusChange(DocumentRouteStatusChange statusChangeEvent) throws Exception {
		boolean success = true;
		LOG.info("Route status is : " + statusChangeEvent.getNewRouteStatus());
		// if document is transitioning from INITIATED to SAVED then transaction prevents us from retrieving the proposal
        if (StringUtils.equals(KewApiConstants.ROUTE_HEADER_INITIATED_CD, statusChangeEvent.getOldRouteStatus()) && 
                StringUtils.equals(KewApiConstants.ROUTE_HEADER_SAVED_CD, statusChangeEvent.getNewRouteStatus())) {
            // assume the proposal status is already correct
           // do nothing
        } else {
            ProposalInfo proposalInfo = getProposalService().getProposalByWorkflowId(statusChangeEvent.getDocumentId(), ContextUtils.getContextInfo());
            
            // update the proposal state if the proposalState value is not null (allows for clearing of the state)
            String proposalState = getProposalStateForRouteStatus(proposalInfo.getState(), statusChangeEvent.getNewRouteStatus());
            updateProposal(statusChangeEvent, proposalState, proposalInfo);
            success = true;
        }
        return new ProcessDocReport(success);
	}

	@Override
	public ProcessDocReport doRouteLevelChange(
			DocumentRouteLevelChange levelChangeEvent) throws Exception {
		return new ProcessDocReport(true);
	}

	@Override
	public ProcessDocReport doDeleteRouteHeader(DeleteEvent event)
			throws Exception {
		return new ProcessDocReport(true);
	}

	@Override
	public ProcessDocReport doActionTaken(ActionTakenEvent event)
			throws Exception {
		boolean success = true;
        ActionTaken actionTaken = event.getActionTaken();
        String actionTakeCode = event.getActionTaken().getActionTaken().getCode();
		// on a save action we may not have access to the proposal object because the transaction may not have committed
		if (!StringUtils.equals(KewApiConstants.ROUTE_HEADER_SAVED_CD, actionTakeCode)) {
            ProposalInfo proposalInfo = getProposalService().getProposalByWorkflowId(event.getDocumentId().toString(), ContextUtils.getContextInfo());
            if (actionTaken == null) {
                throw new OperationFailedException("No action taken found for document id " + event.getDocumentId());
            }
    	    if (StringUtils.equals(KewApiConstants.ACTION_TAKEN_APPROVED, actionTakeCode)) {
    	        processApproveActionTaken(event, actionTaken, proposalInfo);
    	    } else if(StringUtils.equals(KewApiConstants.ACTION_TAKEN_DENIED, actionTakeCode)){
    	    	processDisApproveActionTaken(event, actionTaken, proposalInfo);
    	    } else if(StringUtils.equals(KewApiConstants.ACTION_TAKEN_COMPLETED, actionTakeCode)){
    	    	processClarificationActionTaken(event, actionTaken, proposalInfo);
    	    } else {
    	    	LOG.info("Action taken :" + actionTakeCode);
    	    }
		} 
        return new ProcessDocReport(success);
	}

	@Override
	public ProcessDocReport afterActionTaken(ActionType actionPerformed,
			ActionTakenEvent event) throws Exception {
		return new ProcessDocReport(Boolean.TRUE);
	}

	@Override
	public ProcessDocReport beforeProcess(BeforeProcessEvent processEvent)
			throws Exception {
		return new ProcessDocReport(true);
	}

	@Override
	public ProcessDocReport afterProcess(AfterProcessEvent processEvent)
			throws Exception {
		return new ProcessDocReport(true);
	}

	@Override
	public List<String> getDocumentIdsToLock(DocumentLockingEvent lockingEvent)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String getProposalStateForRouteStatus(String currentProposalState, String newWorkflowStatusCode) {
         
		LOG.info("newWorkflowStatusCode : " + newWorkflowStatusCode);
        if (StringUtils.equals(KewApiConstants.ROUTE_HEADER_SAVED_CD, newWorkflowStatusCode)) {
            return getProposalStateFromNewState(currentProposalState, ProposalServiceConstants.PROPOSAL_STATE_DRAFT);
        } else if (KewApiConstants.ROUTE_HEADER_ENROUTE_CD.equals(newWorkflowStatusCode)) {
            return getProposalStateFromNewState(currentProposalState, ProposalServiceConstants.PROPOSAL_STATE_SUBMITTED);
        } else if (KewApiConstants.ROUTE_HEADER_CANCEL_CD .equals(newWorkflowStatusCode)) {
            return getProposalStateFromNewState(currentProposalState, ProposalConstants.PROPOSAL_STATE_CANCELLED);
        } else if (KewApiConstants.ROUTE_HEADER_DISAPPROVED_CD.equals(newWorkflowStatusCode)) {
            return getProposalStateFromNewState(currentProposalState, ProposalServiceConstants.PROPOSAL_STATE_NOT_APPROVED);
        } else if (KewApiConstants.ROUTE_HEADER_PROCESSED_CD.equals(newWorkflowStatusCode)) {
            return getProposalStateFromNewState(currentProposalState, ProposalServiceConstants.PROPOSAL_STATE_APPROVED);
        } else if (KewApiConstants.ROUTE_HEADER_EXCEPTION_CD.equals(newWorkflowStatusCode)) {
            return getProposalStateFromNewState(currentProposalState, ProposalConstants.PROPOSAL_STATE_EXCEPTION);
        } else {
            // no status to set
            return null;
        }
    }
	protected String getProposalStateFromNewState(String currentProposalState, String newProposalState) {
        if (LOG.isInfoEnabled()) {
            LOG.info("current proposal state is '" + currentProposalState + "' and new proposal state will be '" + newProposalState + "'");
        }
        return getStateFromNewState(currentProposalState, newProposalState);
    }

    /**
     * Default behavior is to return the <code>newState</code> variable only if it differs from the
     * <code>currentState</code> value. Otherwise <code>null</code> will be returned.
     */
    protected String getStateFromNewState(String currentState, String newState) {
        if (StringUtils.equals(currentState, newState)) {
            if (LOG.isInfoEnabled()) {
                LOG.info("returning null as current state and new state are both '" + currentState + "'");
            }
            return null;
        }
        return newState;
    }
    
    protected void updateProposal(IDocumentEvent iDocumentEvent, String proposalState, ProposalInfo proposalInfo) throws Exception {
        if (LOG.isInfoEnabled()) {
            LOG.info("Setting state '" + proposalState + "' on Proposal with docId='" + proposalInfo.getWorkflowId() + "' and proposalId='" + proposalInfo.getId() + "'");
        }
        boolean requiresSave = false;
        if (proposalState != null) {
            proposalInfo.setState(proposalState);
            requiresSave = true;
        }
        requiresSave |= preProcessProposalSave(iDocumentEvent, proposalInfo);
        if (requiresSave) {
            getProposalService().updateProposal(proposalInfo.getId(), proposalInfo, ContextUtils.getContextInfo());
        }
    }
    protected boolean preProcessProposalSave(IDocumentEvent iDocumentEvent, ProposalInfo proposalInfo) {
        return false;
    }
    protected String getPrincipalIdForSystemUser() {
        Principal principal = KimApiServiceLocator.getIdentityService().getPrincipalByPrincipalName(StudentIdentityConstants.SYSTEM_USER_PRINCIPAL_NAME);
        if (principal == null) {
            throw new RuntimeException("Cannot find Principal for principal name: " + StudentIdentityConstants.SYSTEM_USER_PRINCIPAL_NAME);
        }
        return principal.getPrincipalId();
    }
    
    protected void processApproveActionTaken(ActionTakenEvent actionTakenEvent, ActionTaken actionTaken, ProposalInfo proposalInfo) throws Exception {
        LOG.info("Action taken was 'Super User Disapprove' which is a 'Withdraw' in Kuali Student");
        LOG.info("Will set proposal state to '" + ProposalServiceConstants.PROPOSAL_STATE_APPROVED + "'");
        WorkflowDocument doc = WorkflowDocumentFactory.loadDocument(getPrincipalIdForSystemUser(), proposalInfo.getWorkflowId());
        addPersonToUserRole(proposalInfo.getProposerPerson().get(0), doc);
        LOG.info("Clearing EDIT permissions added via adhoc requests to principal id: " + actionTaken.getPrincipalId());
        updateProposal(actionTakenEvent, ProposalServiceConstants.PROPOSAL_STATE_APPROVED, proposalInfo);
	}
    protected void addPersonToUserRole(String principalId, WorkflowDocument doc) {
        Map<String,String> qualifications = new LinkedHashMap<String,String>();
        qualifications.put(KualiStudentKimAttributes.DOCUMENT_TYPE_NAME,doc.getDocumentTypeName());
        qualifications.put(KualiStudentKimAttributes.QUALIFICATION_DATA_ID,doc.getApplicationDocumentId());
        KimApiServiceLocator.getRoleService().assignPrincipalToRole(principalId, StudentWorkflowConstants.ROLE_NAME_ADHOC_EDIT_PERMISSIONS_ROLE_NAMESPACE, ProposalServiceConstants.ROLENAME_STUDENT_CM_USER, qualifications);
    }
    protected void processDisApproveActionTaken(ActionTakenEvent actionTakenEvent, ActionTaken actionTaken, ProposalInfo proposalInfo) throws Exception {
        LOG.info("Action taken was 'Super User Disapprove' which is a 'Withdraw' in Kuali Student");
        LOG.info("Will set proposal state to '" + ProposalServiceConstants.PROPOSAL_STATE_NOT_APPROVED + "'");
        updateProposal(actionTakenEvent, ProposalServiceConstants.PROPOSAL_STATE_NOT_APPROVED, proposalInfo);
	}
    protected void processClarificationActionTaken(ActionTakenEvent actionTakenEvent, ActionTaken actionTaken, ProposalInfo proposalInfo) throws Exception {
        LOG.info("Action taken was 'Super User Disapprove' which is a 'Withdraw' in Kuali Student");
        LOG.info("Will set proposal state to '" + ProposalServiceConstants.PROPOSAL_STATE_DRAFT + "'");
        updateProposal(actionTakenEvent, ProposalServiceConstants.PROPOSAL_STATE_DRAFT, proposalInfo);
	}
}


