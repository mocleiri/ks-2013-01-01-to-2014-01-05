package org.kuali.student.myplan.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.student.ap.framework.config.KsapFrameworkServiceLocator;
import org.kuali.student.ap.framework.context.support.DefaultKsapContext;
import org.kuali.student.myplan.academicplan.dto.LearningPlanInfo;
import org.kuali.student.myplan.academicplan.dto.PlanItemInfo;
import org.kuali.student.myplan.academicplan.infc.LearningPlan;
import org.kuali.student.myplan.academicplan.infc.PlanItem;
import org.kuali.student.myplan.academicplan.service.AcademicPlanServiceConstants;
import org.kuali.student.r2.common.dto.MetaInfo;
import org.kuali.student.r2.common.dto.RichTextInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.exceptions.AlreadyExistsException;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.lum.clu.CLUConstants;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ks-ap-test-context.xml" })
@TransactionConfiguration(transactionManager = "JtaTxManager", defaultRollback = true)
@Transactional
public class AcademicPlanServiceImplTest {

	@Before
	public void setUp() {
		DefaultKsapContext.before("student1");
	}

	@After
	public void tearDown() {
		DefaultKsapContext.after();
	}

	@Test(expected = DoesNotExistException.class)
	public void getUnknownLearningPlan() throws InvalidParameterException,
			MissingParameterException, DoesNotExistException,
			OperationFailedException {
		KsapFrameworkServiceLocator.getAcademicPlanService().getLearningPlan("unknown_plan",
				KsapFrameworkServiceLocator.getContext().getContextInfo());
	}

	@Test
	public void getLearningPlan() throws Throwable {
		String planId = "lp1";
		LearningPlan learningPlan = KsapFrameworkServiceLocator.getAcademicPlanService().getLearningPlan(planId,
				KsapFrameworkServiceLocator.getContext().getContextInfo());
		assertNotNull(learningPlan);
		assertEquals(planId, learningPlan.getId());
		assertEquals("student1", learningPlan.getStudentId());
		assertEquals("Student 1 Learning Plan 1", learningPlan.getDescr()
				.getPlain());
	}

	@Test
	public void getLearningPlans() throws Throwable {
		String studentId = "student1";
		List<LearningPlanInfo> learningPlans = null;
		learningPlans = KsapFrameworkServiceLocator.getAcademicPlanService().getLearningPlansForStudentByType(
				studentId,
				AcademicPlanServiceConstants.LEARNING_PLAN_TYPE_PLAN,
				KsapFrameworkServiceLocator.getContext().getContextInfo());
		assertNotNull(learningPlans);
		assertEquals(2, learningPlans.size());

		LearningPlan lp = learningPlans.get(0);
		assertEquals("lp1", lp.getId());

		lp = learningPlans.get(1);
		assertEquals("lp2", lp.getId());
	}

	@Test
	public void addLearningPlan() throws Throwable {
		LearningPlanInfo learningPlan = new LearningPlanInfo();
		learningPlan
				.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_TYPE_PLAN);
		learningPlan.setStudentId("student1");
		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Plan</span>";
		String planDesc = "My Plan";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		learningPlan.setDescr(desc);

		// Set meta data object.
		learningPlan.setMeta(new MetaInfo());

		learningPlan
				.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ACTIVE_STATE_KEY);

		LearningPlanInfo newLearningPlan = KsapFrameworkServiceLocator.getAcademicPlanService()
				.createLearningPlan(learningPlan, KsapFrameworkServiceLocator
						.getContext().getContextInfo());

		assertNotNull(newLearningPlan);
		assertEquals(AcademicPlanServiceConstants.LEARNING_PLAN_TYPE_PLAN,
				newLearningPlan.getTypeKey());
		assertEquals("student1", newLearningPlan.getStudentId());
		assertEquals(formattedDesc, newLearningPlan.getDescr().getFormatted());
		assertEquals(planDesc, newLearningPlan.getDescr().getPlain());

		// Validate metadata was set.
		assertEquals("student1", newLearningPlan.getMeta().getCreateId());
		assertNotNull(newLearningPlan.getMeta().getCreateTime());
		assertEquals("student1", newLearningPlan.getMeta().getUpdateId());
		assertNotNull(newLearningPlan.getMeta().getUpdateTime());
	}

	@Test
	public void updateLearningPlanTimestamp() throws Throwable {

		// Create a new learning plan so that all the meta data is properly
		// initialized.
		LearningPlanInfo learningPlan = new LearningPlanInfo();
		learningPlan
				.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_TYPE_PLAN);
		learningPlan.setStudentId("student1");
		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Plan</span>";
		String planDesc = "My Plan";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		learningPlan.setDescr(desc);

		learningPlan
				.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ACTIVE_STATE_KEY);

		LearningPlanInfo plan = null;
		try {
			plan = KsapFrameworkServiceLocator.getAcademicPlanService().createLearningPlan(learningPlan,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}

		assertNotNull(plan);

		Date updated1 = plan.getMeta().getUpdateTime();
		assertNotNull(updated1);

		// FIXME: Implement state.
		plan.setStateKey("fixme");
		Thread.sleep(2000L);
		plan = KsapFrameworkServiceLocator.getAcademicPlanService().updateLearningPlan(plan.getId(), plan,
				KsapFrameworkServiceLocator.getContext().getContextInfo());
		Date updated2 = plan.getMeta().getUpdateTime();
		assertNotNull(updated2);

		assertFalse(updated1.equals(updated2));
	}

	@Test(expected = DoesNotExistException.class)
	public void deleteLearningPlan() throws Exception {
		String id = "lp1";

		// Make sure the plan exists and has some plan items.
		try {
			KsapFrameworkServiceLocator.getAcademicPlanService().getLearningPlan(id, KsapFrameworkServiceLocator
					.getContext().getContextInfo());
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}

		int itemCount = KsapFrameworkServiceLocator.getAcademicPlanService().getPlanItemsInPlan(id,
				KsapFrameworkServiceLocator.getContext().getContextInfo())
				.size();
		assertEquals(7, itemCount);

		// Delete the plan
		try {
			KsapFrameworkServiceLocator.getAcademicPlanService().deleteLearningPlan(id,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}

		// Make sure the plan items were cleaned up.
		itemCount = KsapFrameworkServiceLocator.getAcademicPlanService().getPlanItemsInPlan(id,
				KsapFrameworkServiceLocator.getContext().getContextInfo())
				.size();
		assertEquals(0, itemCount);

		try {
			KsapFrameworkServiceLocator.getAcademicPlanService().getLearningPlan(id, KsapFrameworkServiceLocator
					.getContext().getContextInfo());
		} catch (Exception e) {
			// Swallow anything but DoesNotExistException.
			if (e instanceof DoesNotExistException) {
				throw e;
			}
		}
	}

	@Test
	public void getPlanItemsByPlanIdByRefObjectIdByRefObjectType()
			throws InvalidParameterException, MissingParameterException,
			DoesNotExistException, OperationFailedException {

		String planId = "lp1";
		String refObjectId = "006476b5-18d8-4830-bbb6-2bb9e79600fb";
		String refObjectType = "kuali.lu.type.CreditCourse";

		List<PlanItemInfo> planItems = KsapFrameworkServiceLocator.getAcademicPlanService()
				.getPlanItemsInPlanByRefObjectIdByRefObjectType(planId,
						refObjectId, refObjectType, KsapFrameworkServiceLocator
								.getContext().getContextInfo());
		assertEquals(1, planItems.size());
		assertEquals(planId, planItems.get(0).getLearningPlanId());
		assertEquals(refObjectId, planItems.get(0).getRefObjectId());
		assertEquals(refObjectType, planItems.get(0).getRefObjectType());
	}

	@Test
	public void addAndGetPlanItemWishlist() throws Throwable {
		String planId = "lp1";

		// Create a new plan item.
		PlanItemInfo planItem = new PlanItemInfo();

		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Comment</span>";
		String planDesc = "My Comment";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		planItem.setDescr(desc);

		planItem.setLearningPlanId(planId);
		planItem.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_WISHLIST);
		String courseId = "c796aecc-7234-4482-993c-bf00b8088e84";
		String courseType = CLUConstants.CLU_TYPE_CREDIT_COURSE;

		planItem.setRefObjectId(courseId);
		planItem.setRefObjectType(courseType);

		// Type wishlist has no ATP associated with it so leave plan periods
		// null.

		planItem.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_ACTIVE_STATE_KEY);

		PlanItem newPlanItem = KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItem,
				KsapFrameworkServiceLocator.getContext().getContextInfo());
		assertNotNull(newPlanItem);
		assertNotNull(newPlanItem.getId());
		assertEquals(planId, newPlanItem.getLearningPlanId());
		assertEquals(formattedDesc, newPlanItem.getDescr().getFormatted());
		assertEquals(planDesc, newPlanItem.getDescr().getPlain());
		assertEquals(courseId, newPlanItem.getRefObjectId());
		assertEquals(courseType, newPlanItem.getRefObjectType());

		// Test getPlanItem
		PlanItem fetchedPlanItem = KsapFrameworkServiceLocator.getAcademicPlanService().getPlanItem(newPlanItem
				.getId(), KsapFrameworkServiceLocator.getContext()
				.getContextInfo());

		assertNotNull(fetchedPlanItem);
		assertNotNull(fetchedPlanItem.getId());
		assertEquals(planId, fetchedPlanItem.getLearningPlanId());
		assertEquals(formattedDesc, fetchedPlanItem.getDescr().getFormatted());
		assertEquals(planDesc, fetchedPlanItem.getDescr().getPlain());
		assertEquals(courseId, fetchedPlanItem.getRefObjectId());
		assertEquals(courseType, fetchedPlanItem.getRefObjectType());
	}

	@Test
	public void addAndGetPlanItemPlannedCourse() throws Throwable {
		String planId = "lp1";

		// Create a new plan item.
		PlanItemInfo planItem = new PlanItemInfo();

		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Comment</span>";
		String planDesc = "My Comment";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		planItem.setDescr(desc);

		planItem.setLearningPlanId(planId);
		planItem.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_PLANNED);

		// Set some ATP info since this is a planned course.
		List<String> planPeriods = new ArrayList<String>();
		planPeriods.add("20111");
		planPeriods.add("20114");
		planItem.setPlanPeriods(planPeriods);

		String courseId = "c796aecc-7234-4482-993c-bf00b8088e84";
		String courseType = CLUConstants.CLU_TYPE_CREDIT_COURSE;

		planItem.setRefObjectId(courseId);
		planItem.setRefObjectType(courseType);

		planItem.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_ACTIVE_STATE_KEY);

		// Verify the object returned by createPlanItem.
		PlanItem newPlanItem = KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItem,
				KsapFrameworkServiceLocator.getContext().getContextInfo());
		assertNotNull(newPlanItem);
		assertNotNull(newPlanItem.getId());
		assertEquals(planId, newPlanItem.getLearningPlanId());
		assertEquals(formattedDesc, newPlanItem.getDescr().getFormatted());
		assertEquals(planDesc, newPlanItem.getDescr().getPlain());
		assertEquals(courseId, newPlanItem.getRefObjectId());
		assertEquals(courseType, newPlanItem.getRefObjectType());

		assertEquals(2, newPlanItem.getPlanPeriods().size());

		// Verify the object returned by getPlanItem().
		PlanItem fetchedPlanItem = KsapFrameworkServiceLocator.getAcademicPlanService().getPlanItem(newPlanItem
				.getId(), KsapFrameworkServiceLocator.getContext()
				.getContextInfo());

		assertNotNull(fetchedPlanItem);
		assertNotNull(fetchedPlanItem.getId());
		assertEquals(planId, fetchedPlanItem.getLearningPlanId());
		assertEquals(formattedDesc, fetchedPlanItem.getDescr().getFormatted());
		assertEquals(planDesc, fetchedPlanItem.getDescr().getPlain());
		assertEquals(courseId, fetchedPlanItem.getRefObjectId());
		assertEquals(courseType, fetchedPlanItem.getRefObjectType());

		assertEquals(2, fetchedPlanItem.getPlanPeriods().size());
	}

	@Test
	public void updatePlanItemPlannedCoursePlanPeriods() throws Throwable {

		String planId = "lp1";

		// Create a new plan item.
		PlanItemInfo planItemInfo = new PlanItemInfo();

		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Comment</span>";
		String planDesc = "My Comment";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		planItemInfo.setDescr(desc);
		planItemInfo.setMeta(new MetaInfo());

		planItemInfo.setLearningPlanId(planId);

		// Set some ATP info since this is a planned course.
		List<String> planPeriods = new ArrayList<String>();
		planPeriods.add("20111");
		planPeriods.add("20114");
		planItemInfo.setPlanPeriods(planPeriods);

		String courseId = "c796aecc-7234-4482-993c-bf00b8088e84";
		String courseType = CLUConstants.CLU_TYPE_CREDIT_COURSE;

		planItemInfo.setRefObjectId(courseId);
		planItemInfo.setRefObjectType(courseType);

		planItemInfo
				.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_PLANNED);
		planItemInfo
				.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_ACTIVE_STATE_KEY);

		// Save the plan item
		PlanItemInfo newPlanItem = KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(
				planItemInfo, KsapFrameworkServiceLocator.getContext()
						.getContextInfo());
		String planItemId = newPlanItem.getId();

		// Verify the object returned by getPlanItem().
		PlanItemInfo fetchedPlanItem = KsapFrameworkServiceLocator.getAcademicPlanService().getPlanItem(
				planItemId, KsapFrameworkServiceLocator.getContext()
						.getContextInfo());

		assertNotNull(fetchedPlanItem);
		assertEquals(planItemId, fetchedPlanItem.getId());
		assertEquals(planId, fetchedPlanItem.getLearningPlanId());
		assertEquals(courseId, fetchedPlanItem.getRefObjectId());
		assertEquals(courseType, fetchedPlanItem.getRefObjectType());
		assertEquals(planItemInfo.getTypeKey(), fetchedPlanItem.getTypeKey());
		assertEquals(planItemInfo.getStateKey(), fetchedPlanItem.getStateKey());
		assertEquals(2, fetchedPlanItem.getPlanPeriods().size());
		assertEquals("student1", fetchedPlanItem.getMeta().getUpdateId());
		assertNotNull(fetchedPlanItem.getMeta().getUpdateTime());

		// Save meta data info.
		Date originalUpdateDate = newPlanItem.getMeta().getUpdateTime();

		// Update the plan item and save.
		fetchedPlanItem.getPlanPeriods().remove("20111");
		assertEquals(1, fetchedPlanItem.getPlanPeriods().size());

		PlanItemInfo updatedPlanItem = KsapFrameworkServiceLocator.getAcademicPlanService().updatePlanItem(
				planItemId, fetchedPlanItem, KsapFrameworkServiceLocator
						.getContext().getContextInfo());

		assertNotNull(updatedPlanItem);
		assertEquals(planItemId, updatedPlanItem.getId());
		assertEquals(planId, updatedPlanItem.getLearningPlanId());
		assertEquals(formattedDesc, updatedPlanItem.getDescr().getFormatted());
		assertEquals(planDesc, updatedPlanItem.getDescr().getPlain());
		assertEquals(courseId, updatedPlanItem.getRefObjectId());
		assertEquals(courseType, updatedPlanItem.getRefObjectType());
		assertEquals(1, updatedPlanItem.getPlanPeriods().size());
		assertTrue(updatedPlanItem.getPlanPeriods().contains("20114"));
		assertFalse(originalUpdateDate.equals(updatedPlanItem.getMeta()
				.getUpdateTime()));
	}

	@Test(expected = AlreadyExistsException.class)
	public void addPlannedCourseViolateUnqiueContraint()
			throws InvalidParameterException, DataValidationErrorException,
			MissingParameterException, AlreadyExistsException,
			PermissionDeniedException, OperationFailedException {
		String planId = "lp1";

		// Create a new plan item.
		PlanItemInfo planItem = new PlanItemInfo();

		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Comment</span>";
		String planDesc = "My Comment";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		planItem.setDescr(desc);

		planItem.setLearningPlanId(planId);
		planItem.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_PLANNED);

		// Set some ATP info since this is a planned course.
		List<String> planPeriods = new ArrayList<String>();
		planPeriods.add("20111");
		planPeriods.add("20114");
		planItem.setPlanPeriods(planPeriods);

		String courseId = "c796aecc-7234-4482-993c-bf00b8088e84";
		String courseType = CLUConstants.CLU_TYPE_CREDIT_COURSE;

		planItem.setRefObjectId(courseId);
		planItem.setRefObjectType(courseType);

		planItem.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_ACTIVE_STATE_KEY);

		KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItem,
				KsapFrameworkServiceLocator.getContext().getContextInfo());

		// Now violate the plan, type, course id uniqiue constraint by re-adding
		// the course.
		KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItem,
				KsapFrameworkServiceLocator.getContext().getContextInfo());
	}

	@Test
	public void addPlannedCourseWithoutPlanPeriod() throws Throwable {

		String planId = "lp1";

		// Create a new plan item.
		PlanItemInfo planItemInfo = new PlanItemInfo();

		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Comment</span>";
		String planDesc = "My Comment";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		planItemInfo.setDescr(desc);

		planItemInfo.setLearningPlanId(planId);

		// Don't set any plan periods. This should cause a validation error.

		String courseId = "02711400-c66d-4ecb-aca5-565118f167cf";
		String courseType = CLUConstants.CLU_TYPE_CREDIT_COURSE;

		planItemInfo.setRefObjectId(courseId);
		planItemInfo.setRefObjectType(courseType);

		planItemInfo
				.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_PLANNED);
		planItemInfo
				.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_ACTIVE_STATE_KEY);

		// Create the plan item
		try {
			KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItemInfo,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
			fail("A validation exception should have been thrown.");
		} catch (DataValidationErrorException e) {
			// OK
		}
	}

	@Test
	public void addPlanItemNullCourseType() throws Throwable {
		String planId = "lp1";

		PlanItemInfo planItem = new PlanItemInfo();

		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Comment</span>";
		String planDesc = "My Comment";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		planItem.setDescr(desc);

		planItem.setLearningPlanId(planId);
		planItem.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_WISHLIST);
		String courseId = "c796aecc-7234-4482-993c-bf00b8088e84";
		String courseType = null;

		planItem.setRefObjectId(courseId);
		planItem.setRefObjectType(courseType);
		planItem.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_ACTIVE_STATE_KEY);

		try {
			KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItem,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (DataValidationErrorException dvee) {
			dvee.printStackTrace();
			assertEquals(1, dvee.getValidationResults().size());
			ValidationResultInfo resultInfo = dvee.getValidationResults()
					.get(0);
			assertEquals("refObjectType", resultInfo.getElement());
			assertEquals("error.required", resultInfo.getMessage());
		}
	}

	@Test
	public void addPlanItemNullLearningPlan() throws Throwable {
		String planId = null;

		PlanItemInfo planItem = new PlanItemInfo();

		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Comment</span>";
		String planDesc = "My Comment";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		planItem.setDescr(desc);

		planItem.setLearningPlanId(planId);
		planItem.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_WISHLIST);

		String courseId = "c796aecc-7234-4482-993c-bf00b8088e84";
		String courseType = CLUConstants.CLU_TYPE_CREDIT_COURSE;

		planItem.setRefObjectId(courseId);
		planItem.setRefObjectType(courseType);
		planItem.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_ACTIVE_STATE_KEY);

		try {
			KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItem,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (DataValidationErrorException dvee) {
			dvee.printStackTrace();
			assertEquals(1, dvee.getValidationResults().size());
			ValidationResultInfo resultInfo = dvee.getValidationResults()
					.get(0);
			assertEquals("learningPlanId", resultInfo.getElement());
			assertEquals("error.required", resultInfo.getMessage());
		}
	}

	@Test
	public void addPlanItemNullCourseId() {
		String planId = "lp1";

		PlanItemInfo planItem = new PlanItemInfo();

		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Comment</span>";
		String planDesc = "My Comment";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		planItem.setDescr(desc);

		planItem.setLearningPlanId(planId);
		planItem.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_WISHLIST);
		String courseId = null;
		String courseType = CLUConstants.CLU_TYPE_CREDIT_COURSE;

		planItem.setRefObjectId(courseId);
		planItem.setRefObjectType(courseType);
		planItem.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_ACTIVE_STATE_KEY);

		try {
			KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItem,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (DataValidationErrorException dvee) {
			assertEquals(2, dvee.getValidationResults().size());
			ValidationResultInfo resultInfo = dvee.getValidationResults()
					.get(0);
			assertEquals("refObjectId", resultInfo.getElement());
			assertEquals("error.required", resultInfo.getMessage());
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void addPlanItemToSavedCoursesListWithDuplicateCourseId()
			throws Throwable {
		String planId = "lp1";

		// Create a new plan item.
		PlanItemInfo planItem = new PlanItemInfo();

		RichTextInfo desc = new RichTextInfo();
		String formattedDesc = "<span>My Comment</span>";
		String planDesc = "My Comment";
		desc.setFormatted(formattedDesc);
		desc.setPlain(planDesc);
		planItem.setDescr(desc);

		planItem.setLearningPlanId(planId);
		planItem.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_WISHLIST);
		String courseId = "c796aecc-7234-4482-993c-bf00b8088e84";
		String courseType = CLUConstants.CLU_TYPE_CREDIT_COURSE;

		planItem.setRefObjectId(courseId);
		planItem.setRefObjectType(courseType);

		planItem.setStateKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_ACTIVE_STATE_KEY);

		KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItem,
				KsapFrameworkServiceLocator.getContext().getContextInfo());

		// Make sure the item was saved.
		List<PlanItemInfo> savedCourses = KsapFrameworkServiceLocator.getAcademicPlanService()
				.getPlanItemsInPlan(planId, KsapFrameworkServiceLocator
						.getContext().getContextInfo());
		boolean exists = false;
		for (PlanItemInfo pii : savedCourses) {
			if (pii.getRefObjectId().equals(courseId)) {
				exists = true;
				break;
			}
		}

		if (!exists) {
			fail("Unable to retrieve plan item.");
		}

		try {
			// Make sure the id of the plan item isn't a factor.
			planItem.setId(null);
			KsapFrameworkServiceLocator.getAcademicPlanService().createPlanItem(planItem,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (AlreadyExistsException e) {
			return;
		} catch (Exception e) {
			// Do nothing.
			System.err.println();
		}

		fail("Was able to add a duplicate course id to saved courses list.");
	}

	@Test
	public void deletePlanItem() {
		String id = "lp1";

		// Make sure the plan exists and has some plan items.
		try {
			KsapFrameworkServiceLocator.getAcademicPlanService().getLearningPlan(id, KsapFrameworkServiceLocator
					.getContext().getContextInfo());
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}

		List<PlanItemInfo> planItems = null;
		try {
			planItems = KsapFrameworkServiceLocator.getAcademicPlanService().getPlanItemsInPlan(id,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
		assertEquals(7, planItems.size());

		// Delete a plan item.
		String planItemId = planItems.get(0).getId();
		try {
			KsapFrameworkServiceLocator.getAcademicPlanService().deletePlanItem(planItemId,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}

		// Make sure the plan items were cleaned up.
		int itemCount = 0;
		try {
			itemCount = KsapFrameworkServiceLocator.getAcademicPlanService().getPlanItemsInPlan(id,
					KsapFrameworkServiceLocator.getContext().getContextInfo())
					.size();
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
		assertEquals(6, itemCount);
	}

	@Test
	public void validatePlanItemForCourse() throws InvalidParameterException,
			MissingParameterException, AlreadyExistsException,
			DoesNotExistException, OperationFailedException {
		PlanItemInfo planItemInfo = new PlanItemInfo();
		planItemInfo.setRefObjectId("XX");
		planItemInfo.setTypeKey("YY");
		List<ValidationResultInfo> validationResultInfos = null;
		try {
			validationResultInfos = KsapFrameworkServiceLocator.getAcademicPlanService().validatePlanItem(
					"FULL_VALIDATION", planItemInfo,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
		assertEquals("error.required", validationResultInfos.get(0)
				.getMessage());
		assertEquals("refObjectType", validationResultInfos.get(0).getElement());
		assertEquals("error.required", validationResultInfos.get(1)
				.getMessage());
		assertEquals("learningPlanId", validationResultInfos.get(1)
				.getElement());
		assertEquals("error.required", validationResultInfos.get(2)
				.getMessage());
		assertEquals("stateKey", validationResultInfos.get(2).getElement());

		assertEquals("Could not find course with ID [XX].",
				validationResultInfos.get(3).getMessage());
		assertEquals("refObjectId", validationResultInfos.get(3).getElement());
	}

	@Test
	public void validatePlanItemForPlannedItem() throws Throwable {
		PlanItemInfo planItemInfo = new PlanItemInfo();
		planItemInfo.setRefObjectId("XX");
		planItemInfo.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_PLANNED);
		List<ValidationResultInfo> validationResultInfos = KsapFrameworkServiceLocator.getAcademicPlanService()
				.validatePlanItem("FULL_VALIDATION", planItemInfo,
						KsapFrameworkServiceLocator.getContext()
								.getContextInfo());
		assertEquals("error.required", validationResultInfos.get(0)
				.getMessage());
		assertEquals("refObjectType", validationResultInfos.get(0).getElement());
		assertEquals("error.required", validationResultInfos.get(1)
				.getMessage());
		assertEquals("learningPlanId", validationResultInfos.get(1)
				.getElement());
		assertEquals("error.required", validationResultInfos.get(2)
				.getMessage());
		assertEquals("stateKey", validationResultInfos.get(2).getElement());
		assertEquals("Could not find course with ID [XX].",
				validationResultInfos.get(3).getMessage());
		assertEquals("refObjectId", validationResultInfos.get(3).getElement());
		assertEquals(
				"Plan Item Type was ["+AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_PLANNED+"], but no plan periods were defined.",
				validationResultInfos.get(4).getMessage());
		assertEquals("typeKey", validationResultInfos.get(4).getElement());
	}

	@Test
	public void validatePlanItemForBackupPlanItem()
			throws InvalidParameterException, MissingParameterException,
			AlreadyExistsException, DoesNotExistException,
			OperationFailedException {
		PlanItemInfo planItemInfo = new PlanItemInfo();
		planItemInfo.setRefObjectId("XX");
		planItemInfo.setTypeKey(AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_BACKUP);
		List<ValidationResultInfo> validationResultInfos = KsapFrameworkServiceLocator
				.getAcademicPlanService()
				.validatePlanItem("FULL_VALIDATION", planItemInfo,
						KsapFrameworkServiceLocator.getContext()
								.getContextInfo());
		assertEquals("error.required", validationResultInfos.get(0)
				.getMessage());
		assertEquals("refObjectType", validationResultInfos.get(0).getElement());
		assertEquals("error.required", validationResultInfos.get(1)
				.getMessage());
		assertEquals("learningPlanId", validationResultInfos.get(1)
				.getElement());
		assertEquals("error.required", validationResultInfos.get(2)
				.getMessage());
		assertEquals("stateKey", validationResultInfos.get(2).getElement());
		assertEquals("Could not find course with ID [XX].",
				validationResultInfos.get(3).getMessage());
		assertEquals("refObjectId", validationResultInfos.get(3).getElement());
		assertEquals(
				"Plan Item Type was ["+AcademicPlanServiceConstants.LEARNING_PLAN_ITEM_TYPE_BACKUP+"], but no plan periods were defined.",
				validationResultInfos.get(4).getMessage());
		assertEquals("typeKey", validationResultInfos.get(4).getElement());
	}
}
