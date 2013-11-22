package org.kuali.student.core.organization.ui.form;

import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.r2.core.proposal.dto.ProposalInfo;

public class PersonAuthorizationRequestForm extends UifFormBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6179171431175709924L;
	
	private ProposalInfo proposalInfo;
	
	private String submittedBy;
	
	private String submittedForName;
	
	private String submittedForId;
	
	private String forOrganizationName;
	
	private String forOrganizationId;

	public ProposalInfo getProposalInfo() {
		return proposalInfo;
	}

	public void setProposalInfo(ProposalInfo proposalInfo) {
		this.proposalInfo = proposalInfo;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
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

}
