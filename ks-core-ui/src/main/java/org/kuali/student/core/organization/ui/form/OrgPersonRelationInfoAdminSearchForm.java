package org.kuali.student.core.organization.ui.form;

import java.util.ArrayList;

import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.r2.core.organization.dto.OrgPersonRelationInfo;

public class OrgPersonRelationInfoAdminSearchForm extends UifFormBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4703388779356717776L;
	
	private String keywordSearch;
	private String orgId;
	private ArrayList<OrgPersonRelationInfo> orgPersonRelationInfo;

	public ArrayList<OrgPersonRelationInfo> getOrgPersonRelationInfo() {
		return orgPersonRelationInfo;
	}

	public void setOrgPersonRelationInfo(
			ArrayList<OrgPersonRelationInfo> orgPersonRelationInfo) {
		this.orgPersonRelationInfo = orgPersonRelationInfo;
	}

	public String getKeywordSearch() {
		return keywordSearch;
	}

	public void setKeywordSearch(String keywordSearch) {
		this.keywordSearch = keywordSearch;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	
}
