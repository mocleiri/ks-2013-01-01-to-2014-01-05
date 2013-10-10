Given /^I create a Course Offering from catalog using the default waitlists option \(enabled\)$/ do
  @course_offering = create CourseOffering, :course => "ENGL300", :waitlists => true

  @course_offering.view_course_details
  on CourseOfferingInquiry do |page|
    page.waitlist_state.should be_true
    page.close
  end
end

Given /^I create a Course Offering from catalog using the waitlists option disabled$/ do
  @course_offering = create CourseOffering, :course => "ENGL300", :waitlist => false
end

Given /^there is an existing course offering with activity offerings that have waitlists enabled$/ do
  @course_offering = make CourseOffering, :course => "ENGL293"
  @activity_offering = make ActivityOffering, :parent_course_offering => @course_offering, :code => "A"
end

#Given /^I create a course and activity offering with waitlists enabled$/ do
#  step "I manage an activity offering with waitlists enabled"
#end

#I create a course and activity offering with waitlists enabled
#I manage an activity offering with waitlists enabled
Given /^I (?:manage|create)(?: a course)? and? activity offering with waitlists enabled$/ do
  @term = make AcademicTerm, :term_code => Rollover::MAIN_TEST_TERM_TARGET if @term.nil?

  @course_offering = create CourseOffering, :term => @term.term_code, :course => "ENGL300", :waitlists => true
  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering
  @activity_offering.save
end

Given /^I create a course and activity offering with waitlists disabled$/ do
  @term = make AcademicTerm, :term_code => Rollover::MAIN_TEST_TERM_TARGET if @term.nil?
  @course_offering_wl_disabled = create CourseOffering, :term => @term.term_code, :course => "ENGL300", :waitlist => false
  @activity_offering_wl_disabled = create ActivityOffering, :parent_course_offering => @course_offering_wl_disabled
  @activity_offering_wl_disabled.save
end

Given /^I (?:manage|create) an activity offering with the limit waitlist size set$/ do
  @course_offering = create CourseOffering, :course => "ENGL300", :waitlists => true
  waitlist_config = make Waitlist, :enabled => true, :limit_size => 30
  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering, :waitlist_config => waitlist_config
  @activity_offering.save

  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_max_size.should == "Limit to 30"
    page.close
  end
end

Given /^I manage an activity offering with waitlists processing type set to (.*)$/ do |processing_type|
  @course_offering = create CourseOffering, :course => "ENGL300", :waitlists => true
  waitlist_config = make Waitlist, :enabled => true, :type => processing_type
  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering, :waitlist_config => waitlist_config
  @activity_offering.save

  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_processing.should == processing_type
    page.close
  end
end

Given /^I can update the processing type to (.*)$/ do |processing_type|
  waitlist = @activity_offering.waitlist_config
  waitlist.type = processing_type
  @activity_offering.edit :waitlist_config => waitlist
  @activity_offering.save

  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_processing.should == processing_type
    page.close
  end
end

#When /^I make changes to the default waitlist configuration for one of the activity offerings$/ do
#  pending # express the regexp above with the code you wish you had
#end
Then /^I make changes to the default waitlist configuration.*activity offering/ do
  waitlist = @activity_offering.waitlist_config
  waitlist.enabled = true
  waitlist.type = "Manual"
  waitlist.limit_size = 10
  waitlist.allow_hold_list = true
  @activity_offering.edit :waitlist_config => waitlist
  @activity_offering.save
end

Then /^I set the limit waitlist size$/ do
  waitlist = @activity_offering.waitlist_config
  waitlist.enabled = true
  waitlist.limit_size = 25
  @activity_offering.edit :waitlist_config => waitlist
  @activity_offering.save
end

Then /^I remove the limit waitlist size$/ do
  waitlist = @activity_offering.waitlist_config
  waitlist.limit_size = 0
  @activity_offering.edit :waitlist_config => waitlist
  @activity_offering.save
end

Then /^I modify the limit waitlist size$/ do
  waitlist = @activity_offering.waitlist_config
  waitlist.limit_size = 50
  @activity_offering.edit :waitlist_config => waitlist
  @activity_offering.save
end

Then /^I enable the allow hold list option$/ do
  waitlist = @activity_offering.waitlist_config
  waitlist.enabled = true
  waitlist.allow_hold_list = true
  @activity_offering.edit :waitlist_config => waitlist
  @activity_offering.save
end

Then /^I disable the allow hold list option$/ do
  waitlist = @activity_offering.waitlist_config
  waitlist.allow_hold_list = false
  @activity_offering.edit :waitlist_config => waitlist
  @activity_offering.save
end

Given /^I add two activity offerings$/ do
  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering
  @activity_offering.save
  @activity_offering2 = create ActivityOffering, :parent_course_offering => @course_offering
  @activity_offering2.save
end

Given /^I add an activity offering$/ do
  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering
  @activity_offering.save
end

Given /^the activity offerings have active waitlists and waitlists have the default configuration$/ do
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_true
    page.waitlists_allow_holds?.should be_false
    page.waitlists_processing.should == "Confirmation"
    page.waitlists_max_size.should == "Unlimited"
    page.close
  end

  on(ManageCourseOfferings).view_activity_offering(@activity_offering2.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_true
    page.waitlists_allow_holds?.should be_false
    page.waitlists_processing.should == "Confirmation"
    page.waitlists_max_size.should == "Unlimited"
    page.close
  end

  @activity_offering.edit
  on ActivityOfferingMaintenance do |page|
    page.waitlist_checkbox.set?.should be_true
    page.waitlist_confirmation_radio.set?.should be_true
    page.waitlist_limit_checkbox.set?.should be_false
    page.waitlist_allow_hold_checkbox.set?.should be_false
    page.cancel
  end

  @activity_offering2.edit
  on ActivityOfferingMaintenance do |page|
    page.waitlist_checkbox.set?.should be_true
    page.waitlist_confirmation_radio.set?.should be_true
    page.waitlist_limit_checkbox.set?.should be_false
    page.waitlist_allow_hold_checkbox.set?.should be_false
    page.cancel
  end

end

Given /^the waitlist option cannot be enabled for the activity offering$/ do
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_false
    page.close
  end

  @activity_offering.edit
  on ActivityOfferingMaintenance do |page|
    page.no_waitlists_msg.should == "Waitlists are deactivated for the Course Offering"
    page.cancel
  end
end

Given /^the limit waitlist size is successfully updated$/ do
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_true
    page.waitlists_max_size.should == @activity_offering.waitlist_config.waitlist_limit_str
    page.close
  end
end

Given /^the allow hold list option is successfully updated$/ do
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_true
    page.waitlists_allow_holds?.should == @activity_offering.waitlist_config.allow_hold_list
    page.close
  end
end

Given /^I re-enable the waitlists option for the activity offering the modified waitlist configuration is restored$/ do
  @activity_offering.edit

  on ActivityOfferingMaintenance do |page|
    page.waitlist_checkbox.set
    page.waitlist_processing_type.should == @activity_offering.waitlist_config.type
    page.waitlist_limit_checkbox.set?.should == @activity_offering.waitlist_config.limit_size > 0
    page.waitlist_limit.value.to_i.should == @activity_offering.waitlist_config.limit_size
    page.waitlist_allow_hold_checkbox.set?.should == @activity_offering.waitlist_config.allow_hold_list
    page.cancel
  end
end

Given /^I (?:can )?disable the waitlists option for the activity offering$/ do
  waitlist = @activity_offering.waitlist_config
  waitlist.enabled = false
  @activity_offering.edit :waitlist_config => waitlist
  @activity_offering.save

  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_false
    page.close
  end
end

Given /^the limit waitlist size is successfully updated to unlimited$/ do
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_max_size.should == "Unlimited"
    page.close
  end
end

Given /^I manage an activity offering with the waitlist allow hold list option enabled$/ do
  @course_offering = create CourseOffering, :course => "ENGL300", :waitlists => true
  waitlist_config = make Waitlist, :enabled => true, :allow_hold_list => true
  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering, :waitlist_config => waitlist_config
  @activity_offering.save

  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_allow_holds?.should == true
    page.close
  end
end


Given /^the waitlist enabled configuration is copied to the new course and activity offering in the target term$/ do
  @course_offering_copy = make CourseOffering, :course => @course_offering.course, :term => @term_target.term_code
  step "the waitlist configuration is copied to the new course and activity offering"
end
Given /^the waitlist configuration is copied to the new course and activity offering.*$/ do
  @course_offering_copy.view_course_details
  on CourseOfferingInquiry do |page|
    page.waitlist_state.should be_true
    page.close
  end

  @course_offering_copy.manage
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_true
    page.waitlists_allow_holds?.should == @activity_offering.waitlist_config.allow_hold_list
    page.waitlists_processing.should == @activity_offering.waitlist_config.type
    page.waitlists_max_size.should == @activity_offering.waitlist_config.waitlist_limit_str
    page.close
  end
end

Given /^the waitlist disabled configuration is copied to the course and activity offering in the target term$/ do
  @course_offering_copy = make CourseOffering, :course => @course_offering_wl_disabled.course, :term => @term_target.term_code

 step "the waitlists are disabled for the new course and activity offering"
end

Given /^the waitlists are disabled for the new course and activity offering$/ do
  @course_offering_copy.view_course_details
  on CourseOfferingInquiry do |page|
    page.waitlist_state.should be_false
    page.close
  end

  @course_offering_copy.manage
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_false
    page.close
  end
end

Given /^there are two other activity offering with waitlists enabled and no waitlist limit$/ do
  @other_aos = []
  ["ENGL416","ENGL420"].each do |co_code|
    course_offering = create CourseOffering, :course => co_code, :waitlists => true
    activity_offering = create ActivityOffering, :parent_course_offering => @course_offering
    activity_offering.save
    @other_aos << activity_offering
  end
end

When /^I colocate the activity offering with other two offerings and select shared maximum enrolment$/ do
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit :colocate_ao_list => @other_aos,
                    :colocate_shared_enrollment => true,
                    :max_enrollment => 48
  @activity_offering.save
end

Then /^all three activity offerings have the same waitlist limit size$/ do
  @activity_offering.parent_course_offering.manage
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_true
    page.waitlists_max_size.should == @activity_offering.waitlist_config.waitlist_limit_str
    page.close
  end

  @activity_offering.colocate_ao_list.each do |colo_ao|
    colo_ao.parent_course_offering.manage
    on(ManageCourseOfferings).view_activity_offering(colo_ao.code)

    on ActivityOfferingInquiry do |page|
      page.waitlists_active?.should be_true
      page.waitlists_max_size.should == colo_ao.waitlist_config.waitlist_limit_str
      page.close
    end
  end
end

Given /^I create three colocated activity offerings \(shared enrolment\) with waitlists enabled$/ do
  @term = make AcademicTerm, :term_code => Rollover::MAIN_TEST_TERM_TARGET if @term.nil?

  @course_offering = create CourseOffering, :course => "ENGL300", :waitlists => true, :term => @term.term_code
  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering
  @activity_offering.save

  @other_aos = []
  ["WMST300","WMST400"].each do |co_code|
    course_offering = create CourseOffering, :course => co_code, :waitlists => true, :term => @term.term_code
    activity_offering = create ActivityOffering, :parent_course_offering => course_offering
    activity_offering.save
    @other_aos << activity_offering
  end

  @activity_offering.parent_course_offering.manage
  @activity_offering.edit :colocate_ao_list => @other_aos,
                          :colocate_shared_enrollment => true,
                          :max_enrollment => 120
  @activity_offering.save

end

Then /^all three colocated activity offerings have the same waitlist configuration$/ do
  @activity_offering.parent_course_offering.manage
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_true
    page.waitlists_allow_holds?.should == @activity_offering.waitlist_config.allow_hold_list
    page.waitlists_processing.should == @activity_offering.waitlist_config.type
    page.waitlists_max_size.should == @activity_offering.waitlist_config.waitlist_limit_str
    page.close
  end

  @activity_offering.colocate_ao_list.each do |colo_ao|
    colo_ao.parent_course_offering.manage
    on(ManageCourseOfferings).view_activity_offering(colo_ao.code)

    on ActivityOfferingInquiry do |page|
      page.waitlists_active?.should be_true
      page.waitlists_allow_holds?.should == @activity_offering.waitlist_config.allow_hold_list
      page.waitlists_processing.should == @activity_offering.waitlist_config.type
      page.waitlists_max_size.should == @activity_offering.waitlist_config.waitlist_limit_str
      page.close
    end
  end
end

Given /^I make changes the default waitlist configuration for one of the activity offerings$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the waitlist configuration is copied to the new colocated activity offerings in the target term$/ do
  @activity_offering_target = @activity_offering
  @activity_offering_target.parent_course_offering.term = @term_target.term_code
  @activity_offering_target.parent_course_offering.manage
  on(ManageCourseOfferings).view_activity_offering(@activity_offering.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_true
    page.waitlists_allow_holds?.should == @activity_offering.waitlist_config.allow_hold_list
    page.waitlists_processing.should == @activity_offering.waitlist_config.type
    page.waitlists_max_size.should == @activity_offering.waitlist_config.waitlist_limit_str
    page.close
  end

  @activity_offering.colocate_ao_list.each do |colo_ao|
    colo_ao.parent_course_offering.manage
    on(ManageCourseOfferings).view_activity_offering(colo_ao.code)

    on ActivityOfferingInquiry do |page|
      page.waitlists_active?.should be_true
      page.waitlists_allow_holds?.should == @activity_offering.waitlist_config.allow_hold_list
      page.waitlists_processing.should == @activity_offering.waitlist_config.type
      page.waitlists_max_size.should == @activity_offering.waitlist_config.waitlist_limit_str
      page.close
    end
  end

end

Then /^the waitlist configuration is copied to the colocated activity offering in the course offering copy$/ do
  @activity_offering_copy = @activity_offering
  @activity_offering_copy.parent_course_offering = @course_offering_copy
  @activity_offering_copy.parent_course_offering.manage
  on(ManageCourseOfferings).view_activity_offering(@activity_offering_copy.code)

  on ActivityOfferingInquiry do |page|
    page.waitlists_active?.should be_true
    page.waitlists_allow_holds?.should == @activity_offering_copy.waitlist_config.allow_hold_list
    page.waitlists_processing.should == @activity_offering_copy.waitlist_config.type
    page.waitlists_max_size.should == @activity_offering_copy.waitlist_config.waitlist_limit_str
    page.close
  end

end

Given /^I make changes to activity offering waitlist configuration$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I copy one of the colocated activity offerings$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the waitlist configuration is copied to the new colocated activity offering$/ do
  pending # express the regexp above with the code you wish you had
end

Given /^there is an existing course offering with a colocated activity offering \(shared enrolment\) with waitlists enabled$/ do
  pending # express the regexp above with the code you wish you had
end


Then /^the new activity offering has the default waitlist configuration$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I delete one of the colocated activity offerings$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the remaining two activity offerings are no longer colocated$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the remaining two activity offerings still have the same waitlist configuration$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I delete one of the related course offerings$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the remaining activity offerings are still colocated$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I delete two of the related course offerings$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the remaining activity offering is no longer colocated$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the remaining activity offering still has the same waitlist configuration$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I break colocation on the first colocated activity offering$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the all three activity offerings still have the same waitlist configuration$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I change the waitlist configuration on the first activity offering$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the waitlist configuration for the two remaining colocated activity offerings is not changed$/ do
  pending # express the regexp above with the code you wish you had
end

Given /^I create two colocated activity offerings \(shared enrolment\) with waitlists enabled$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^both activity offering still have the same waitlist configuration$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the waitlists configuration for the second activity offering is not changed$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I deactivate waitlists at the course offering level for one of the activity offerings$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^waitlists is deactived for both activity offerings$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I add another activity offering to the colocated set$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I update the colocation settings to manage enrolments separately$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I update the waitlists configuration for one of the colocated activity offerings$/ do
  pending # express the regexp above with the code you wish you had
end
