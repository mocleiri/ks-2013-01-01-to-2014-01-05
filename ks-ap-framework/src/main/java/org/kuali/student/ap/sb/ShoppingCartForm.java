package org.kuali.student.ap.sb;

import java.util.List;

import org.kuali.student.ap.plan.PlanItemForm;
import org.kuali.student.ap.sb.infc.CourseOption;

/**
 * Form for interacting with the shopping cart.
 * 
 * @author Mark Fyffe <mwfyffe@iu.edu>
 * @version 0.7.5
 */
public interface ShoppingCartForm extends PlanItemForm {

	/**
	 * Get the requested activity offering ID, if applicable.
	 * 
	 * @return The requested activity offering ID.
	 */
	String getActivityOfferingId();

	/**
	 * Get the course options for driving the shopping cart request.
	 * 
	 * @return The course options for driving the shopping cart request.
	 */
	List<CourseOption> getCourseOptions();

	/**
	 * Set the course options for driving the shopping cart request.
	 * 
	 * @param courseOptions
	 *            The course options for driving the shopping cart request.
	 */
	void setCourseOptions(List<CourseOption> courseOptions);

	/**
	 * Get the shopping cart request.
	 * 
	 * @return The shopping cart request.
	 */
	List<ShoppingCartRequest> getShoppingCartRequests();

	/**
	 * Populate the shopping cart request.
	 * 
	 * @param shoppingCartRequest
	 *            The shopping cart request.
	 */
	void setShoppingCartRequests(List<ShoppingCartRequest> shoppingCartRequest);

}
