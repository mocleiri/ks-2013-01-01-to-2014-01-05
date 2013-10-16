package org.kuali.student.core.organization.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.krad.web.controller.UifControllerBase;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.common.util.ContextBuilder;
import org.kuali.student.core.organization.ui.form.OrgPersonRelationInfoAdminSearchForm;
import org.kuali.student.core.ui.admin.organization.OrgInfoAdminLookupableImpl;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.constants.OrganizationServiceConstants;
import org.kuali.student.r2.core.hold.dto.HoldIssueInfo;
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
@RequestMapping(value = "/orgPersonRelationInfoAdminSearch")
public class OrgPersonRelationInfoAdminSearchController extends UifControllerBase {
	private static final Logger LOG = Logger.getLogger(OrgPersonRelationInfoAdminSearchController.class);
	
	private transient OrganizationService organizationService;
	private ContextInfo contextInfo;
	
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
		List<OrgPersonRelationInfo> results = new ArrayList<OrgPersonRelationInfo>();
		 
        String orgId = searchForm.getOrgId();
 
        resetForm(searchForm);
 
        QueryByCriteria.Builder qBuilder = QueryByCriteria.Builder.create();
        if (StringUtils.isNotBlank(orgId) && !orgId.isEmpty()) {
        	qBuilder.setPredicates(PredicateFactory.equal("orgId",orgId));
        } else {
            qBuilder.setPredicates(PredicateFactory.like("orgId","*"));
        }
        try {
            organizationService = getOrganizationService();
 
            results = this.getOrganizationService().searchForOrgPersonRelations(qBuilder.build(), getContextInfo());
            
            LOG.info("Number of results for orgId :" + orgId + " is : " + results.size());
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error Performing Search",e); //To change body of catch statement use File | Settings | File Templates.
        }
 
       searchForm.setOrgPersonRelationInfo((ArrayList<OrgPersonRelationInfo>) results);
 
        return getUIFModelAndView(searchForm, null);
	}	
	
	private void resetForm(OrgPersonRelationInfoAdminSearchForm searchForm) {
		searchForm.setOrgPersonRelationInfo(new ArrayList<OrgPersonRelationInfo>());
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
}