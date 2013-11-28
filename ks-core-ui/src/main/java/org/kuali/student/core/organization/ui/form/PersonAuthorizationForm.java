package org.kuali.student.core.organization.ui.form;

import java.util.List;

import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.core.organization.ui.form.model.ProposalInfoModel;
import org.kuali.student.r2.core.proposal.dto.ProposalInfo;

public class PersonAuthorizationForm extends UifFormBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6179171431175709924L;
	
	private ProposalInfo proposalInfo;
	private String submittedByName;	
	private String submittedForName;	
	private String submittedForId;	
	private String forOrganizationName;	
	private String forOrganizationId;	
	private String requestedSince;
	
	private List<ProposalInfoModel> proposals;
	
	public ProposalInfo getProposalInfo() {
		return proposalInfo;
	}
	public void setProposalInfo(ProposalInfo proposalInfo) {
		this.proposalInfo = proposalInfo;
	}
	public String getSubmittedByName() {
		return submittedByName;
	}
	public void setSubmittedByName(String submittedByName) {
		this.submittedByName = submittedByName;
	}	
	public String getSubmittedForName() {
		return submittedForName;
	}
	public void setSubmittedForName(String submittedForName) {
		this.submittedForName = submittedForName;
	}
	public String getSubmittedForId() {
		return submittedForId;
	}
	public void setSubmittedForId(String submittedForId) {
		this.submittedForId = submittedForId;
	}
	public String getForOrganizationName() {
		return forOrganizationName;
	}
	public void setForOrganizationName(String forOrganizationName) {
		this.forOrganizationName = forOrganizationName;
	}
	public String getForOrganizationId() {
		return forOrganizationId;
	}
	public void setForOrganizationId(String forOrganizationId) {
		this.forOrganizationId = forOrganizationId;
	}
	public String getRequestedSince() {
		return requestedSince;
	}
	public void setRequestedSince(String requestedSince) {
		this.requestedSince = requestedSince;
	}
	public List<ProposalInfoModel> getProposals() {
		return proposals;
	}
	public void setProposals(List<ProposalInfoModel> proposals) {
		this.proposals = proposals;
	}
	
	

}
