/**
 * Copyright 2012 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
package org.kuali.student.cm.course.form;

import java.util.ArrayList;
import java.util.List;

import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.r2.core.proposal.dto.ProposalInfo;
import org.kuali.student.r2.lum.course.dto.CourseInfo;

/**
 * This is the helper class for CourseView
 * 
 * @author OpenCollab/rSmart KRAD CM Conversion Alliance!
 */

public class CourseForm extends UifFormBase {

	private static final long serialVersionUID = -988885314122936950L;
	
	private CourseInfo courseInfo;
	
	private ProposalInfo proposalInfo;
	
	private boolean audit;
	
	private boolean passFail;
	
	private List<CluInstructorInfoDisplay> instructorDisplays;
	
	private List<CourseJointInfoDisplay> courseJointDisplays;
	
	private List<ResultValuesGroupInfoDisplay> creditOptionsDisplay;
	
	private String finalExamStatus;
	
	private String finalExamRationale;
	
	private String comments;

	public CourseForm() {
		this.courseInfo = new CourseInfo();
		this.proposalInfo = new ProposalInfo();
		this.instructorDisplays = new ArrayList<CluInstructorInfoDisplay>();
		
		this.creditOptionsDisplay = new ArrayList<ResultValuesGroupInfoDisplay>();
		this.courseJointDisplays = new ArrayList<CourseJointInfoDisplay>();
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public ProposalInfo getProposalInfo() {
		return proposalInfo;
	}

	public void setProposalInfo(ProposalInfo proposalInfo) {
		this.proposalInfo = proposalInfo;
	}

	public List<CluInstructorInfoDisplay> getInstructorDisplays() {
		return instructorDisplays;
	}

	public void setInstructorDisplays(
			List<CluInstructorInfoDisplay> instructorDisplays) {
		this.instructorDisplays = instructorDisplays;
	}

    public boolean isAudit() {
        return audit;
    }

    public void setAudit(boolean audit) {
        this.audit = audit;
    }

    public boolean isPassFail() {
        return passFail;
    }

    public void setPassFail(boolean passFail) {
        this.passFail = passFail;
    }

    public List<ResultValuesGroupInfoDisplay> getCreditOptionsDisplay() {
        return creditOptionsDisplay;
    }

    public void setCreditOptionsDisplay(List<ResultValuesGroupInfoDisplay> creditOptionsDisplay) {
        this.creditOptionsDisplay = creditOptionsDisplay;
    }
    
    public List<CourseJointInfoDisplay> getCourseJointDisplays() {
        return courseJointDisplays;
    }

    public void setCourseJointDisplays(List<CourseJointInfoDisplay> courseJointDisplays) {
        this.courseJointDisplays = courseJointDisplays;
    }

    public String getFinalExamStatus() {
        return finalExamStatus;
    }
    
    public void setFinalExamStatus(String finalExamStatus) {
        this.finalExamStatus = finalExamStatus;
    }

    public String getFinalExamRationale() {
        return finalExamRationale;
    }

    public void setFinalExamRationale(String finalExamRationale) {
        this.finalExamRationale = finalExamRationale;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}