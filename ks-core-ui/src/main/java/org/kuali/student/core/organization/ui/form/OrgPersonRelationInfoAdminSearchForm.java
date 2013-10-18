package org.kuali.student.core.organization.ui.form;

import java.util.ArrayList;

import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.core.organization.ui.form.model.OrgPersonRelationUIModel;
import org.kuali.student.r2.core.organization.dto.OrgInfo;

public class OrgPersonRelationInfoAdminSearchForm extends UifFormBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4703388779356717776L;
	
	private String keywordSearch;
	private String orgId;
	private String selectedOrgPersonRelationId;
	private OrgPersonRelationUIModel selectedOrgPersonRelation;
	private OrgInfo orgInfo;
	private ArrayList<OrgPersonRelationUIModel> orgPersonRelationUIModel;

	public ArrayList<OrgPersonRelationUIModel> getOrgPersonRelationUIModel() {
		return orgPersonRelationUIModel;
	}

	public void setOrgPersonRelationUIModel(
			ArrayList<OrgPersonRelationUIModel> orgPersonRelationUIModel) {
		this.orgPersonRelationUIModel = orgPersonRelationUIModel;
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

	public String getSelectedOrgPersonRelationId() {
		return selectedOrgPersonRelationId;
	}

	public void setSelectedOrgPersonRelationId(String selectedOrgPersonRelationId) {
		this.selectedOrgPersonRelationId = selectedOrgPersonRelationId;
	}

	public OrgPersonRelationUIModel getSelectedOrgPersonRelation() {
		return selectedOrgPersonRelation;
	}

	public void setSelectedOrgPersonRelation(
			OrgPersonRelationUIModel selectedOrgPersonRelation) {
		this.selectedOrgPersonRelation = selectedOrgPersonRelation;
	}

	public OrgInfo getOrgInfo() {
		return orgInfo;
	}

	public void setOrgInfo(OrgInfo orgInfo) {
		this.orgInfo = orgInfo;
	}
	
	
	
	
}