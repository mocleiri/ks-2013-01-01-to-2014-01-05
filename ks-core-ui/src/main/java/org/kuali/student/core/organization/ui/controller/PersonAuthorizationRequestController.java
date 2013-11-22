package org.kuali.student.core.organization.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.kim.api.identity.PersonService;
import org.kuali.rice.kim.impl.identity.PersonServiceImpl;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.web.controller.UifControllerBase;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.common.util.ContextBuilder;
import org.kuali.student.core.organization.ui.form.PersonAuthorizationRequestForm;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.core.constants.OrganizationServiceConstants;
import org.kuali.student.r2.core.constants.ProposalServiceConstants;
import org.kuali.student.r2.core.organization.service.OrganizationService;
import org.kuali.student.r2.core.proposal.dto.ProposalInfo;
import org.kuali.student.r2.core.proposal.service.ProposalService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/personAuthorizationRequest")
public class PersonAuthorizationRequestController extends UifControllerBase {
	private static final Logger LOG = Logger.getLogger(OrgPersonRelationInfoAdminSearchController.class);
	
	private transient ProposalService proposalService;
	private transient OrganizationService organizationService;
	private transient PersonService personService;
	
	protected UifFormBase createInitialForm(HttpServletRequest request) {
		return new PersonAuthorizationRequestForm();
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "methodToCall=start")
	public ModelAndView start(@ModelAttribute("KualiForm") UifFormBase form, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		PersonAuthorizationRequestForm personAuthorizationRequestForm = (PersonAuthorizationRequestForm)form;
		return super.start(form, result, request, response);
	}
	
	@RequestMapping(params = "methodToCall=search")
	public ModelAndView search(@ModelAttribute("KualiForm") PersonAuthorizationRequestForm searchForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
 
       return getUIFModelAndView(searchForm, null);
	}
	
	@RequestMapping(params = "methodToCall=submit")
	public ModelAndView submit(@ModelAttribute("KualiForm") PersonAuthorizationRequestForm submitForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KRADServiceLocatorWeb.getViewValidationService().validateView(submitForm);       
        
        if(!GlobalVariables.getMessageMap().hasErrors()){
        	ProposalInfo proposalInfo = submitForm.getProposalInfo();
        	String submittedForId = submitForm.getSubmittedForId();
        	List<String> personIds = new ArrayList<String>();
        	personIds.add(submittedForId);
        	String forOrganization = submitForm.getForOrganizationId();
        	List<String> organizationIds = new ArrayList<String>();
        	organizationIds.add(forOrganization);
        	
        	proposalInfo.setName("Authorization Request For " + getPersonName(submitForm.getSubmittedForId()));
        	proposalInfo.setProposerPerson(personIds);
//        	proposalInfo.setProposalReference(organizationIds);
                proposalInfo.setProposerOrg(organizationIds);
//        	proposalInfo.setProposalReferenceType(ProposalServiceConstants.PROPOSAL_TYPE_CURRICULUM_MANAGEMENT_USER_AUTHORIZATION_ADD_REQUEST);
        	proposalInfo.setTypeKey(ProposalServiceConstants.PROPOSAL_TYPE_CURRICULUM_MANAGEMENT_USER_AUTHORIZATION_ADD_REQUEST);
        	proposalInfo.setStateKey(ProposalServiceConstants.PROPOSAL_STATE_DRAFT);
        	
        	proposalInfo = getProposalService().createProposal(ProposalServiceConstants.PROPOSAL_TYPE_CURRICULUM_MANAGEMENT_USER_AUTHORIZATION_ADD_REQUEST, proposalInfo, getContextInfo());
        	
        	submitForm.setSubmittedBy(getPersonName(proposalInfo.getMeta().getCreateId()));
        	submitForm.setSubmittedForName(getPersonName(submitForm.getSubmittedForId()));
        	submitForm.setForOrganizationName(getOrgName(submitForm.getForOrganizationId()));
        	
        	return getUIFModelAndView(submitForm, "KS-Person-Auth-Request-Confirm-View");
        }
        return getUIFModelAndView(submitForm, null);
	}
	
	public void setProposalService(ProposalService proposalService)
	{
	    this.proposalService = proposalService;
	}
	
	public ProposalService getProposalService()
	{
		if (proposalService == null)
		{
			QName qname = new QName(ProposalServiceConstants.NAMESPACE,ProposalServiceConstants.SERVICE_NAME_LOCAL_PART);
			proposalService = (ProposalService) GlobalResourceLoader.getService(qname);
		}
		return this.proposalService;
	}
	
	public void setOrganizationService(OrganizationService organizationService)
	{
	    this.organizationService = organizationService;
	}
	
	public OrganizationService getOrganizationService()
	{
		if (organizationService == null)
		{
			QName qname = new QName(OrganizationServiceConstants.NAMESPACE,OrganizationServiceConstants.SERVICE_NAME_LOCAL_PART);
			organizationService = (OrganizationService) GlobalResourceLoader.getService(qname);
		}
		return this.organizationService;
	}
	
	public void setPersonService(PersonService personService)
	{
	    this.personService = personService;
	}
	
	protected PersonService getPersonService() {
        if(personService == null) {
        	personService = ((PersonServiceImpl) GlobalResourceLoader.getService(new QName("personService")));
        }
        return this.personService;
    }
	
	private ContextInfo getContextInfo() {
    	return ContextBuilder.loadContextInfo();
	}
	
	private String getOrgName(String orgId) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException{
		return getOrganizationService().getOrg(orgId, getContextInfo()).getLongName();
	}
	
	private String getPersonName(String principalId){
		return getPersonService().getPerson(principalId).getName();
	}
	
}