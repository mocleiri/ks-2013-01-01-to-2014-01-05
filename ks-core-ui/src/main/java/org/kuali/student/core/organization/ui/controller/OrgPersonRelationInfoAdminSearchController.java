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
	
	List<OrgPersonRelationUIModel> results = new ArrayList<OrgPersonRelationUIModel>();
	OrgInfo orgInfo = new OrgInfo();
	
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
		
		// Beanutils config
		java.util.Date defaultValue = null;
        
        DateConverter converter = new DateConverter(defaultValue);
        
        ConvertUtils.register(converter, java.util.Date.class);
        // config ends
		
        String organizationName = searchForm.getKeywordSearch();
 
        resetForm(searchForm);
 
        QueryByCriteria.Builder qBuilder = QueryByCriteria.Builder.create();
        
        if (StringUtils.isNotBlank(organizationName) && !organizationName.isEmpty()) {
        	qBuilder.setPredicates(PredicateFactory.equal("longName",organizationName));
        	List<OrgInfo> orgInfos = this.getOrganizationService().searchForOrgs(qBuilder.build(), getContextInfo());
        	
        	if(orgInfos.size() != 0){
        		BeanUtils.copyProperties(orgInfo, orgInfos.get(0));
        		qBuilder.setPredicates(PredicateFactory.equal("orgId",orgInfo.getId()));
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
            	
            	TypeInfo typeInfo = this.getTypeService().getType(orgPersonRelationInfo.getTypeKey(), getContextInfo());
            	
            	orgPersonUIModel.setTypeInfo(typeInfo);
            	
            	StateInfo stateInfo = new StateInfo();
            	
            	try{
            		stateInfo = this.getStateService().getState(orgPersonRelationInfo.getStateKey(), getContextInfo());            		
            	}catch(Exception e){
            		stateInfo.setName("State Key not found=" + orgPersonRelationInfo.getStateKey());
            	}
            	
            	orgPersonUIModel.setStateInfo(stateInfo);
            	
            	results.add(orgPersonUIModel);
			}
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error Performing Search",e); //To change body of catch statement use File | Settings | File Templates.
        }
 
       searchForm.setOrgInfo(orgInfo);
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
				viewForm.setOrgInfo(orgInfo);
				viewForm.setSelectedOrgPersonRelation(relation);
				break;
			}
		}
		return getUIFModelAndView(viewForm, "KS-OrgPersonRelationInfoDetail-View");
	}
	
	private void resetForm(OrgPersonRelationInfoAdminSearchForm searchForm) {
		searchForm.setOrgPersonRelationUIModel(new ArrayList<OrgPersonRelationUIModel>());
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