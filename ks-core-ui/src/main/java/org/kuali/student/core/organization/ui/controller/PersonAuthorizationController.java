package org.kuali.student.core.organization.ui.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.kuali.rice.core.api.criteria.Predicate;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kim.api.identity.PersonService;
import org.kuali.rice.kim.impl.identity.PersonServiceImpl;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.web.controller.UifControllerBase;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.common.util.ContextBuilder;
import org.kuali.student.core.organization.ui.form.PersonAuthorizationForm;
import org.kuali.student.core.organization.ui.form.model.ProposalInfoModel;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.MetaInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.core.class1.state.service.StateService;
import org.kuali.student.r2.core.class1.type.service.TypeService;
import org.kuali.student.r2.core.constants.OrganizationServiceConstants;
import org.kuali.student.r2.core.constants.ProposalServiceConstants;
import org.kuali.student.r2.core.constants.StateServiceConstants;
import org.kuali.student.r2.core.constants.TypeServiceConstants;
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
@RequestMapping(value = "/personAuthorization")
public class PersonAuthorizationController extends UifControllerBase {
	private static final Logger LOG = Logger.getLogger(OrgPersonRelationInfoAdminSearchController.class);
	
	private transient ProposalService proposalService;
	private transient OrganizationService organizationService;
	private transient PersonService personService;
	private transient StateService stateService;
	private transient TypeService typeService;
	
	List<ProposalInfoModel> uiProposals = new ArrayList<ProposalInfoModel>();
	
	{   
		// Beanutils config
		java.util.Date defaultValue = null;        
		DateConverter converter = new DateConverter(defaultValue);        
		ConvertUtils.register(converter, java.util.Date.class);
        // config ends
	}
	
	protected UifFormBase createInitialForm(HttpServletRequest request) {
		return new PersonAuthorizationForm();
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "methodToCall=start")
	public ModelAndView start(@ModelAttribute("KualiForm") UifFormBase form, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		PersonAuthorizationForm personAuthorizationForm = (PersonAuthorizationForm)form;
		personAuthorizationForm.setSubmittedByName(GlobalVariables.getUserSession().getPerson().getName());
		personAuthorizationForm.setProposalInfo(new ProposalInfo());
		personAuthorizationForm.getProposalInfo().setEffectiveDate(Calendar.getInstance().getTime());
		return super.start(form, result, request, response);
	}
	
	@RequestMapping(params = "methodToCall=search")
	public ModelAndView search(@ModelAttribute("KualiForm") PersonAuthorizationForm searchForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {

		QueryByCriteria.Builder criteria = QueryByCriteria.Builder.create();
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(StringUtils.isNotBlank(searchForm.getSubmittedForName())){
			predicates.add(PredicateFactory.equal("keywordSearch",searchForm.getSubmittedForName()));			
		}
		if(StringUtils.isNotBlank(searchForm.getSubmittedByName()) && searchForm.getSubmittedByName().split(",").length == 2){
			predicates.add(PredicateFactory.equal("meta.createId",getPersonId(searchForm.getSubmittedByName())));
		}
		if(!searchForm.getRequestedSince().equalsIgnoreCase("All")){
			Calendar calendar = Calendar.getInstance();
			
			if(searchForm.getRequestedSince().equalsIgnoreCase("Day")){
				calendar.add(Calendar.DAY_OF_MONTH, -1);								
			} else if(searchForm.getRequestedSince().equalsIgnoreCase("Week")){
				calendar.add(Calendar.WEEK_OF_MONTH, -1);
			} else if(searchForm.getRequestedSince().equalsIgnoreCase("Month")){
				calendar.add(Calendar.MONTH, -1);
			} else if(searchForm.getRequestedSince().equalsIgnoreCase("Year")){
				calendar.add(Calendar.YEAR, -1);
			}
			LOG.info("Date is " + calendar.getTime());
			predicates.add(PredicateFactory.greaterThanOrEqual("meta.createTime",calendar.getTime()));
    	} 
		
		if(!predicates.isEmpty()){
			criteria.setPredicates(PredicateFactory.and(predicates.toArray(new Predicate[predicates.size()])));
		} else {
			criteria.setPredicates(PredicateFactory.and(PredicateFactory.equal("keywordSearch","*")));
		}
		
		List<ProposalInfo> proposals =  getProposalService().searchForProposals(criteria.build(), getContextInfo());
		uiProposals.clear();
		for(ProposalInfo proposal : proposals){
			ProposalInfoModel uiProposal = new ProposalInfoModel();
			BeanUtils.copyProperties(uiProposal, proposal);
			uiProposal.setSubmittedByName(getPersonName(proposal.getMeta().getCreateId()));
			uiProposal.setSubmittedForName(getPersonName(proposal.getProposerPerson().get(0)));
			uiProposal.setOrganizationName(getOrgName(proposal.getProposerOrg().get(0)));			
			uiProposal.setStateName(getStateService().getState(proposal.getStateKey(), getContextInfo()).getName());
			uiProposal.setTypeName(getTypeService().getType(proposal.getTypeKey(), getContextInfo()).getName());
			uiProposals.add(uiProposal);
		}
		
		searchForm.setProposals(uiProposals);
		
       return getUIFModelAndView(searchForm, null);
	}
	
	@RequestMapping(params = "methodToCall=view")
	public ModelAndView view(@ModelAttribute("KualiForm") PersonAuthorizationForm viewForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String proposalId = viewForm.getActionParamaterValue("proposalId");

		for(ProposalInfoModel proposal : uiProposals){			
			if(proposalId.equals(proposal.getId())){
				ProposalInfoModel copy = new ProposalInfoModel();
				BeanUtils.copyProperties(copy, proposal);
				viewForm.setProposalInfo(copy);
				viewForm.setSubmittedByName(proposal.getSubmittedByName());
				viewForm.setSubmittedForName(proposal.getSubmittedForName());
				viewForm.setForOrganizationName(proposal.getOrganizationName());
				viewForm.setStateName(proposal.getStateName());
				viewForm.setTypeName(proposal.getTypeName());
				break;
			}
		}
		return getUIFModelAndView(viewForm, "KS-Person-Auth-Response-View");
	}
	
	@RequestMapping(params = "methodToCall=cancel")
	public ModelAndView cancel(@ModelAttribute("KualiForm") UifFormBase uifForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		PersonAuthorizationForm viewForm = (PersonAuthorizationForm)uifForm;
		String returnViewName = viewForm.getActionParamaterValue("returnViewName");
		return getUIFModelAndView(viewForm, returnViewName);
	}
	
	@RequestMapping(params = "methodToCall=performApproval")
	public ModelAndView performApproval(@ModelAttribute("KualiForm") PersonAuthorizationForm submitForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String action = submitForm.getActionParamaterValue("action");
		
		KRADServiceLocatorWeb.getViewValidationService().validateView(submitForm);       
        
        if(!GlobalVariables.getMessageMap().hasErrors()){

        	ProposalInfo proposalInfo = submitForm.getProposalInfo();
        	
        	if(action.equalsIgnoreCase("clarification") && StringUtils.isBlank(proposalInfo.getRationale().getPlain())){
        		GlobalVariables.getMessageMap().putError("KS-Person-Auth-Response-View-Section", "unknownError","Please insert approval notes");
        		return getUIFModelAndView(submitForm, null);
        	}
        	
        	if(action.equalsIgnoreCase("approved")){
        		proposalInfo.setStateKey(ProposalServiceConstants.PROPOSAL_STATE_APPROVED);
        	}else if(action.equalsIgnoreCase("denied")){
        		proposalInfo.setStateKey(ProposalServiceConstants.PROPOSAL_STATE_NOT_APPROVED);
        	}else if(action.equalsIgnoreCase("clarification")){
        		proposalInfo.setStateKey(ProposalServiceConstants.PROPOSAL_STATE_SUBMITTED);
        	}
        	
        	proposalInfo = getProposalService().updateProposal(proposalInfo.getId(), proposalInfo, getContextInfo());
        	        	        	
        	GlobalVariables.getMessageMap().putInfo("KS-Person-Auth-Response-View", "databaseChnageSuccess");
        	
        	return getUIFModelAndView(submitForm, "KS-Person-Auth-Response-View");
        }
        return getUIFModelAndView(submitForm, null);
	}
	
	@RequestMapping(params = "methodToCall=submit")
	public ModelAndView submit(@ModelAttribute("KualiForm") PersonAuthorizationForm submitForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KRADServiceLocatorWeb.getViewValidationService().validateView(submitForm);       
        
        if(!GlobalVariables.getMessageMap().hasErrors()){
        	ProposalInfo proposalInfo = submitForm.getProposalInfo();
        	String submittedByName = submitForm.getSubmittedByName();
        	if(StringUtils.isBlank(submittedByName) || submittedByName.split(",").length != 2){
        		GlobalVariables.getMessageMap().putError("KS-Person-Auth-Request-Section", "unknownError","Please enter name without change.");
        		return getUIFModelAndView(submitForm, null);
        	}
        	proposalInfo.setMeta(new MetaInfo());
        	proposalInfo.getMeta().setCreateId(getPersonId(submittedByName));
        	String submittedForName = submitForm.getSubmittedForName();
        	if(StringUtils.isBlank(submittedForName) || submittedForName.split(",").length != 2){
        		GlobalVariables.getMessageMap().putError("KS-Person-Auth-Request-Section", "unknownError","Please enter name without change.");
        		return getUIFModelAndView(submitForm, null);
        	}
        	List<String> personIds = new ArrayList<String>();
        	personIds.add(getPersonId(submittedForName));
        	String forOrganization = submitForm.getForOrganizationId();
        	List<String> organizationIds = new ArrayList<String>();
        	organizationIds.add(forOrganization);
        	
        	proposalInfo.setName("Authorization Request For " + submittedForName);
        	proposalInfo.setProposerPerson(personIds);
            proposalInfo.setProposerOrg(organizationIds);
        	proposalInfo.setTypeKey(ProposalServiceConstants.PROPOSAL_TYPE_CURRICULUM_MANAGEMENT_USER_AUTHORIZATION_ADD_REQUEST);
        	proposalInfo.setStateKey(ProposalServiceConstants.PROPOSAL_STATE_DRAFT);
        	
        	proposalInfo = getProposalService().createProposal(ProposalServiceConstants.PROPOSAL_TYPE_CURRICULUM_MANAGEMENT_USER_AUTHORIZATION_ADD_REQUEST, proposalInfo, getContextInfo());
        	
        	submitForm.setProposalInfo(proposalInfo);
        	submitForm.setForOrganizationName(getOrgName(submitForm.getForOrganizationId()));
        	
        	GlobalVariables.getMessageMap().putInfo("KS-Person-Auth-Request-Confirm-View", "databaseChnageSuccess");
        	
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
	
	public StateService getStateService() {
		if (stateService == null)
		{
			QName qname = new QName(StateServiceConstants.NAMESPACE,StateServiceConstants.SERVICE_NAME_LOCAL_PART);
			stateService = (StateService) GlobalResourceLoader.getService(qname);
		}
		return this.stateService;
	}

	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}

	public TypeService getTypeService() {
		if (typeService == null)
		{
			QName qname = new QName(TypeServiceConstants.NAMESPACE,TypeServiceConstants.SERVICE_NAME_LOCAL_PART);
			typeService = (TypeService) GlobalResourceLoader.getService(qname);
		}
		return this.typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
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
	private String getPersonId(String personName){
		String personId = null;
		HashMap<String,String> criteriaMap = new HashMap<String,String>();		
		criteriaMap.put("firstName", personName.split(",")[1]);		
		List<Person> persons = getPersonService().findPeople(criteriaMap);
		criteriaMap.put("lastName", personName.split(",")[0]);
		persons = getPersonService().findPeople(criteriaMap);
		
		if(persons.size() > 1){
			personId = persons.get(0).getPrincipalId();
			LOG.info("More than one person of name " + personName);
		} else if(persons != null && persons.size() != 0) {
			personId = persons.get(0).getPrincipalId();
		} else {
			LOG.error("No Person Found, This should not happen." + personName);
		}
		return personId;
	}
	
}