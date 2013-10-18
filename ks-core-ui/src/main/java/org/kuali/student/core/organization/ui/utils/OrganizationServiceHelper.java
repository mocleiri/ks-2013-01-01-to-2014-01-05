package org.kuali.student.core.organization.ui.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.krad.uif.service.impl.ViewHelperServiceImpl;
import org.kuali.student.common.util.ContextBuilder;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.constants.OrganizationServiceConstants;
import org.kuali.student.r2.core.organization.dto.OrgInfo;
import org.kuali.student.r2.core.organization.service.OrganizationService;

public class OrganizationServiceHelper extends ViewHelperServiceImpl{
	private static final Logger LOG = Logger.getLogger(OrganizationServiceHelper.class);
	private transient OrganizationService organizationService;
	
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
	
	private ContextInfo getContextInfo() {
    	return ContextBuilder.loadContextInfo();
	}
	
	public List<OrgInfo> suggestOrganizationsByName(String orgPartialName) {
        List<OrgInfo> matchingOrgs = new ArrayList<OrgInfo>();
        QueryByCriteria.Builder qBuilder = QueryByCriteria.Builder.create();
        
        if(StringUtils.isNotEmpty(orgPartialName) && !StringUtils.isBlank(orgPartialName)){
        	if(!StringUtils.contains(orgPartialName, "*")){
        		orgPartialName = "*" + orgPartialName + "*";
        	} else {
        		if(!StringUtils.startsWith(orgPartialName, "*")){
        			orgPartialName = "*" + orgPartialName;
        		}
        		if(!StringUtils.endsWith(orgPartialName, "*")){
        			orgPartialName = orgPartialName + "*";
        		}
        	}
        } else {
        	orgPartialName = "*";
        }
        
        try
		{
        	qBuilder.setPredicates(PredicateFactory.like("longName", orgPartialName));
        	matchingOrgs = this.getOrganizationService().searchForOrgs(qBuilder.build(), getContextInfo()); 
		}
		catch (Exception ex) {
		    throw new RuntimeException(ex);
		}
        return matchingOrgs;
    }

}