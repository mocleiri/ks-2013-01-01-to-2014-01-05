package org.kuali.student.core.organization.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.kim.api.identity.principal.EntityNamePrincipalName;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.web.controller.UifControllerBase;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.common.util.ContextBuilder;
import org.kuali.student.core.organization.ui.form.OrgPersonRelationInfoAdminSearchForm;
import org.kuali.student.core.organization.ui.form.model.OrgPersonRelationUIModel;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.class1.state.dto.StateInfo;
import org.kuali.student.r2.core.class1.state.service.StateService;
import org.kuali.student.r2.core.class1.type.dto.TypeInfo;
import org.kuali.student.r2.core.class1.type.service.TypeService;
import org.kuali.student.r2.core.constants.OrganizationServiceConstants;
import org.kuali.student.r2.core.constants.StateServiceConstants;
import org.kuali.student.r2.core.constants.TypeServiceConstants;
import org.kuali.student.r2.core.organization.dto.OrgInfo;
import org.kuali.student.r2.core.organization.dto.OrgPersonRelationInfo;
import org.kuali.student.r2.core.organization.service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/orgPersonRelationInfoAdminManage")
public class OrgPersonRelationInfoAdminSearchController extends UifControllerBase {
	private static final Logger LOG = Logger.getLogger(OrgPersonRelationInfoAdminSearchController.class);
	
	private transient OrganizationService organizationService;
	private transient TypeService typeService;
	private transient StateService stateService;
	
	{
		// Beanutils config
		java.util.Date defaultValue = null;        
		DateConverter converter = new DateConverter(defaultValue);        
		ConvertUtils.register(converter, java.util.Date.class);
        // config ends
	}
	
	List<OrgPersonRelationUIModel> results = new ArrayList<OrgPersonRelationUIModel>();
	
	protected UifFormBase createInitialForm(HttpServletRequest request) {
		return new OrgPersonRelationInfoAdminSearchForm();
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "methodToCall=start")
	public ModelAndView start(@ModelAttribute("KualiForm") UifFormBase form, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		OrgPersonRelationInfoAdminSearchForm orgPersonRelationInfoAdminSearchForm = (OrgPersonRelationInfoAdminSearchForm)form;
		
		return super.start(form, result, request, response);
	}
	
	@RequestMapping(params = "methodToCall=search")
	public ModelAndView search(@ModelAttribute("KualiForm") OrgPersonRelationInfoAdminSearchForm searchForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        String organizationName = searchForm.getKeywordSearch();
 
        resetForm(searchForm);
 
        QueryByCriteria.Builder qBuilder = QueryByCriteria.Builder.create();
        
        if (StringUtils.isNotBlank(organizationName) && !organizationName.isEmpty()) {
        	qBuilder.setPredicates(PredicateFactory.equal("longName",organizationName));
        	List<OrgInfo> orgInfos = this.getOrganizationService().searchForOrgs(qBuilder.build(), getContextInfo());
        	
        	if(orgInfos.size() != 0){
        		qBuilder.setPredicates(PredicateFactory.equal("orgId",orgInfos.get(0).getId()));
        	} else {
        		return getUIFModelAndView(searchForm, null);
        	}
        } else {
            qBuilder.setPredicates(PredicateFactory.like("orgId","*"));
        }
        
        try {
            List<OrgPersonRelationInfo> relations = this.getOrganizationService().searchForOrgPersonRelations(qBuilder.build(), getContextInfo());
            
            results.clear();
            
            for (OrgPersonRelationInfo orgPersonRelationInfo : relations) {
            	
            	OrgPersonRelationUIModel orgPersonUIModel = new OrgPersonRelationUIModel();
            	
            	BeanUtils.copyProperties(orgPersonUIModel, orgPersonRelationInfo);
            	
            	EntityNamePrincipalName principalName = null;
                
            	if (orgPersonRelationInfo.getPersonId() != null) {
                    principalName = KimApiServiceLocator.getIdentityService().getDefaultNamesForPrincipalId(orgPersonRelationInfo.getPersonId());
                }
                
            	String personName = (principalName != null  && principalName.getDefaultName() != null) ? principalName.getDefaultName().getCompositeName() : StringUtils.EMPTY;
            	
            	orgPersonUIModel.setPersonName(personName);
            	
            	OrgInfo orgInfo = this.getOrganizationService().getOrg(orgPersonRelationInfo.getOrgId(), getContextInfo());
            	
            	orgPersonUIModel.setOrgInfo(orgInfo);
            	
            	TypeInfo typeInfo = this.getTypeService().getType(orgPersonRelationInfo.getTypeKey(), getContextInfo());
            	
            	orgPersonUIModel.setTypeInfo(typeInfo);
            	
            	StateInfo stateInfo = new StateInfo();
            	
            	stateInfo = this.getStateService().getState(orgPersonRelationInfo.getStateKey(), getContextInfo());
            	
            	orgPersonUIModel.setStateInfo(stateInfo);
            	
            	results.add(orgPersonUIModel);
			}
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error Performing Search",e); //To change body of catch statement use File | Settings | File Templates.
        }
       
       searchForm.setOrgPersonRelationUIModel((ArrayList<OrgPersonRelationUIModel>) results);
 
       return getUIFModelAndView(searchForm, null);
	}
	@RequestMapping(params = "methodToCall=view")
	public ModelAndView view(@ModelAttribute("KualiForm") OrgPersonRelationInfoAdminSearchForm viewForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String orgPersonRelationId = viewForm.getActionParamaterValue("selectedOrgPersonRelationId");
		
		LOG.info("orgPersonRelationId " + orgPersonRelationId);
		
		LOG.info("Number of form contained relation : " + results.size());
		for(OrgPersonRelationUIModel relation : results){			
			if(orgPersonRelationId.equals(relation.getId())){
				LOG.info("match found");
				viewForm.setSelectedOrgPersonRelation(relation);
				break;
			}
		}
		return getUIFModelAndView(viewForm, "KS-OrgPersonRelationInfoDetail-View");
	}
	
	@RequestMapping(params = "methodToCall=cancel")
	public ModelAndView cancel(@ModelAttribute("KualiForm") UifFormBase uifForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		OrgPersonRelationInfoAdminSearchForm viewForm = (OrgPersonRelationInfoAdminSearchForm)uifForm;
		String returnViewName = viewForm.getActionParamaterValue("returnViewName");
		return getUIFModelAndView(viewForm, returnViewName);
	}
	
	private void resetForm(OrgPersonRelationInfoAdminSearchForm searchForm) {
		searchForm.setOrgPersonRelationUIModel(new ArrayList<OrgPersonRelationUIModel>());
	}
	
	@RequestMapping(params = "methodToCall=save")
	public ModelAndView save(@ModelAttribute("KualiForm") OrgPersonRelationInfoAdminSearchForm createForm, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KRADServiceLocatorWeb.getViewValidationService().validateView(createForm);
		
		String selectedOrgPersonRelationId = createForm.getActionParamaterValue("selectedOrgPersonRelationId");
		
		QueryByCriteria.Builder qBuilder = QueryByCriteria.Builder.create();
		
		if(!GlobalVariables.getMessageMap().hasErrors()){
			
			OrgPersonRelationUIModel orgPersonRelationUi = createForm.getNewOrgPersonRelation();
			OrgPersonRelationInfo orgPersonRelationInfo = new OrgPersonRelationInfo();
			
			try{
				qBuilder.setPredicates(PredicateFactory.equal("longName",orgPersonRelationUi.getOrgId()));
	        	List<OrgInfo> orgInfos = this.getOrganizationService().searchForOrgs(qBuilder.build(), getContextInfo());
	        	orgPersonRelationUi.setOrgId(orgInfos.get(0).getId());
			}catch (Exception e){
				e.printStackTrace();
			}			
			
			BeanUtils.copyProperties(orgPersonRelationInfo, orgPersonRelationUi);
			
			if(orgPersonRelationInfo.getId() == null){
				OrgPersonRelationInfo orgPersonRelation = getOrganizationService().createOrgPersonRelation(orgPersonRelationInfo.getOrgId(), 
						orgPersonRelationInfo.getPersonId(), orgPersonRelationInfo.getTypeKey(), orgPersonRelationInfo, getContextInfo());
				
				OrgPersonRelationUIModel orgPersonUiModel = new OrgPersonRelationUIModel();
				BeanUtils.copyProperties(orgPersonUiModel, orgPersonRelation);
				createForm.setSelectedOrgPersonRelation(orgPersonUiModel);
				createForm.setNewOrgPersonRelation(null);
			} else {
				getOrganizationService().updateOrgPersonRelation(orgPersonRelationInfo.getId(), orgPersonRelationInfo, getContextInfo());
			}
		} else {
			return getUIFModelAndView(createForm);
		}
		
		return getUIFModelAndView(createForm, "KS-OrgPersonRelationInfoDetail-View");
	}
	
	@RequestMapping(params = "methodToCall=delete")
	public ModelAndView delete(@ModelAttribute("KualiForm") OrgPersonRelationInfoAdminSearchForm form, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String selectedOrgPersonRelationId = form.getActionParamaterValue("selectedOrgPersonRelationId");
		
		this.getOrganizationService().deleteOrgPersonRelation(selectedOrgPersonRelationId, getContextInfo());
		
		return getUIFModelAndView(form, "KS-OrgPersonRelationInfoSearch-View");
	}
	
	@RequestMapping(params = "methodToCall=copy")
	public ModelAndView copy(@ModelAttribute("KualiForm") OrgPersonRelationInfoAdminSearchForm form, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String selectedOrgPersonRelationId = form.getActionParamaterValue("selectedOrgPersonRelationId");
		
		OrgPersonRelationUIModel orgPersonRelationUi = form.getSelectedOrgPersonRelation();
		OrgPersonRelationUIModel newOrgPersonRelationUi = new OrgPersonRelationUIModel();
		
		BeanUtils.copyProperties(newOrgPersonRelationUi, orgPersonRelationUi);
		
		newOrgPersonRelationUi.setId(null);
		newOrgPersonRelationUi.setOrgId(orgPersonRelationUi.getOrgInfo().getLongName());
		
		form.setNewOrgPersonRelation(newOrgPersonRelationUi);
		
		return getUIFModelAndView(form, "KS-OrgPersonRelationInfoCreate-View");
	}
	
	private ContextInfo getContextInfo() {
    	return ContextBuilder.loadContextInfo();
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
	
	
}