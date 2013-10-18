package org.kuali.student.ap.sb.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.kuali.student.ap.framework.config.KsapFrameworkServiceLocator;
import org.kuali.student.ap.framework.context.CourseHelper;
import org.kuali.student.ap.framework.context.PlanConstants;
import org.kuali.student.ap.sb.ScheduleBuildStrategy;
import org.kuali.student.ap.sb.ShoppingCartRequest;
import org.kuali.student.ap.sb.ShoppingCartRequestInfo;
import org.kuali.student.ap.sb.ShoppingCartStrategy;
import org.kuali.student.ap.sb.dto.ActivityOptionInfo;
import org.kuali.student.ap.sb.dto.CourseOptionInfo;
import org.kuali.student.ap.sb.infc.ActivityOption;
import org.kuali.student.ap.sb.infc.CourseOption;
import org.kuali.student.ap.sb.infc.SecondaryActivityOptions;
import org.kuali.student.enrollment.acal.dto.TermInfo;
import org.kuali.student.enrollment.acal.infc.Term;
import org.kuali.student.myplan.academicplan.infc.PlanItem;
import org.kuali.student.r2.common.infc.Attribute;

public class DefaultShoppingCartStrategy implements ShoppingCartStrategy,
		Serializable {

	private static final long serialVersionUID = -5919246688332396604L;

	@Override
	public boolean isCartAvailable(String termId, String campusCode) {
		return false;
	}

	@Override
	public List<CourseOption> getCourseOptionsForPlanItem(Term term,
			PlanItem planItem) {
		ScheduleBuildStrategy scheduleBuildStrategy = KsapFrameworkServiceLocator
				.getScheduleBuildStrategy();
		assert PlanConstants.COURSE_TYPE.equals(planItem.getRefObjectType());
		assert planItem.getPlanPeriods().contains(term.getId());

		List<CourseOption> courseOptions = scheduleBuildStrategy
				.getCourseOptions(
						Collections.singletonList(planItem.getRefObjectId()),
						term.getId());

		List<String> acodes = Collections.emptyList();
		for (Attribute attr : planItem.getAttributes())
			if (attr.getKey().equals("activityCode"))
				acodes = Arrays.asList(attr.getValue().split(","));

		for (CourseOption courseOption : courseOptions) {
			for (ActivityOption primaryActivityOption : courseOption
					.getActivityOptions()) {
				boolean selected = acodes.contains(primaryActivityOption
						.getRegistrationCode());
				if (selected) {
					((ActivityOptionInfo) primaryActivityOption)
							.setSelected(true);
					for (SecondaryActivityOptions secondaryOptions : primaryActivityOption
							.getSecondaryOptions())
						for (ActivityOption secondaryActivityOption : secondaryOptions
								.getActivityOptions())
							if (primaryActivityOption.isEnrollmentGroup())
								((ActivityOptionInfo) secondaryActivityOption)
										.setLockedIn(primaryActivityOption
												.isEnrollmentGroup());
							else if (acodes.contains(secondaryActivityOption
									.getRegistrationCode()))
								((ActivityOptionInfo) secondaryActivityOption)
										.setSelected(true);
				}
			}

			// The selected flag on the course option dictates whether we are
			// adding or removing from the shopping cart when passed to
			// createRequests() --
			// When item type is cart, the request will be to remove from the
			// cart. For other items types, the request will be to add.
			((CourseOptionInfo) courseOption).setSelected(!planItem
					.getTypeKey().equals(
							PlanConstants.LEARNING_PLAN_ITEM_TYPE_CART));
		}
		return courseOptions;
	}

	@Override
	public List<ShoppingCartRequest> createRequests(Term term,
			List<CourseOption> courseOptions) {
		CourseHelper courseHelper = KsapFrameworkServiceLocator
				.getCourseHelper();
		List<ShoppingCartRequest> requests = new ArrayList<ShoppingCartRequest>(
				courseOptions.size());
		for (CourseOption courseOption : courseOptions) {
			ShoppingCartRequestInfo cartRequest = new ShoppingCartRequestInfo();
			cartRequest.setTerm(new TermInfo(term));
			cartRequest.setCourse(courseHelper.getCourseInfo(courseOption
					.getCourseId()));
			cartRequest.setAddToCart(courseOption.isSelected());

			ActivityOption primary = null;
			int secondaryLength = 0;
			for (ActivityOption primaryActivityOption : courseOption
					.getActivityOptions()) {
				if (primary == null && primaryActivityOption.isSelected())
					primary = primaryActivityOption;
				List<SecondaryActivityOptions> secondaryOptions = primaryActivityOption
						.getSecondaryOptions();
				if (secondaryOptions != null)
					secondaryLength = Math.max(secondaryLength,
							secondaryOptions.size());
			}

			List<String> secondaryRegCodes = new ArrayList<String>(
					secondaryLength);
			if (primary != null) {
				cartRequest.setPrimaryRegistrationCode(primary
						.getRegistrationCode());

				for (SecondaryActivityOptions secondaryOption : primary
						.getSecondaryOptions()) {
					ActivityOption secondary = null;
					for (ActivityOption secondaryActivityOption : secondaryOption
							.getActivityOptions())
						if (secondary == null
								&& secondaryActivityOption.isSelected())
							secondary = secondaryActivityOption;
					if (secondary != null)
						secondaryRegCodes.add(secondary.getRegistrationCode());
				}
				cartRequest.setSecondaryRegistrationCodes(secondaryRegCodes);
			}

			requests.add(cartRequest);
		}
		return requests;
	}

	@Override
	public List<ShoppingCartRequest> processRequests(
			List<ShoppingCartRequest> requests) {
		throw new UnsupportedOperationException(
				"Not implemented in KS - override at the institution level");
	}

}
