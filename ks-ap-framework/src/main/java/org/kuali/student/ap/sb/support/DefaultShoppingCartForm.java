package org.kuali.student.ap.sb.support;

import java.util.List;

import org.kuali.student.ap.plan.support.AbstractPlanItemForm;
import org.kuali.student.ap.sb.ShoppingCartForm;
import org.kuali.student.ap.sb.ShoppingCartRequest;
import org.kuali.student.ap.sb.infc.CourseOption;

public class DefaultShoppingCartForm extends AbstractPlanItemForm implements ShoppingCartForm {

	private static final long serialVersionUID = 674405491584786921L;

	private String activityOfferingId;
	private String possibleScheduleId;

	private List<ShoppingCartRequest> shoppingCartRequests;
	private List<CourseOption> courseOptions;

	@Override
	public String getActivityOfferingId() {
		return activityOfferingId;
	}

	public void setActivityOfferingId(String activityOfferingId) {
		this.activityOfferingId = activityOfferingId;
	}

	@Override
	public String getPossibleScheduleId() {
		return possibleScheduleId;
	}

	public void setPossibleScheduleId(String possibleScheduleId) {
		this.possibleScheduleId = possibleScheduleId;
	}

	public List<ShoppingCartRequest> getShoppingCartRequests() {
		return shoppingCartRequests;
	}

	public void setShoppingCartRequests(List<ShoppingCartRequest> shoppingCartRequests) {
		this.shoppingCartRequests = shoppingCartRequests;
	}

	@Override
	public List<CourseOption> getCourseOptions() {
		return courseOptions;
	}

	public void setCourseOptions(List<CourseOption> courseOptions) {
		this.courseOptions = courseOptions;
	}

}
