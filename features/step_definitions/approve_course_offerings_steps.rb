When /^I create two new Course Offerings$/ do
  @course_offering_ENGL221 = create CourseOffering, :create_by_copy => (make CourseOffering, :term=> Rollover::MAIN_TEST_TERM_TARGET , :course => "ENGL221")
  @course_offering_ENGL202 = create CourseOffering, :create_by_copy => (make CourseOffering, :term=> Rollover::MAIN_TEST_TERM_TARGET, :course => "ENGL202")
end

Given /^I manage a course offering with offered and canceled activity offerings present$/ do
  @course_with_cancel_ao = make CourseOffering, :term=> "201208" , :course => "ENGL221"
  @course_with_cancel_ao.manage
  on ManageCourseOfferings do |page|
    @ao_offered_code1 = "A"
    page.ao_status(@ao_offered_code1).should == "Offered"
    page.copy(@ao_offered_code1)

    @ao_canceled_code = "B"
    page.ao_status(@ao_canceled_code).should == "Canceled"
    page.copy(@ao_canceled_code)
  end
end

Given /^I manage a course offering with a canceled activity offering present$/ do
  @course_with_cancel_ao = make CourseOffering, :term=> "201208" , :course => "ENGL221"
  @course_with_cancel_ao.manage
  on ManageCourseOfferings do |page|
    @ao_canceled_code2 = "B"
    page.ao_status(@ao_canceled_code2).should == "Canceled"
  end
end

Given /^I manage a course offering with a canceled activity offering present in draft SOC state$/ do
  @course_with_cancel_ao7 = make CourseOffering, :term=> "202000" , :course => "ENGL243"
  @course_with_cancel_ao7.manage
  on ManageCourseOfferings do |page|
    @ao_canceled_code9 = "A"
    page.ao_status(@ao_canceled_code9).should == "Canceled"
  end
end

Given /^I manage a course offering with multiple canceled activity offerings present in draft SOC state$/ do
  @course_with_cancel_ao8 = make CourseOffering, :term=> "202000" , :course => "ENGL243"
  @course_with_cancel_ao8.manage
  on ManageCourseOfferings do |page|
    @ao_canceled_code10 = "A"
    @ao_canceled_code11 = "B"
    #have to put these in canceled status for the test
    page.select_ao(@ao_canceled_code10)
    page.select_ao(@ao_canceled_code11)
    page.cancel_ao
    on(CancelActivityOffering).cancel_activity
    page.ao_status(@ao_canceled_code10).should == "Canceled"
  end
end

Given /^I manage a course offering with canceled and offered activity offerings present$/ do
  @course_with_cancel_offered_ao = make CourseOffering, :term=> "201208" , :course => "BSCI399"
  @course_with_cancel_offered_ao.manage
  on ManageCourseOfferings do |page|
    @ao_canceled_code3 = "BB"
    page.ao_status(@ao_canceled_code3).should == "Canceled"
    @ao_offered_code3 = "A"
    page.ao_status(@ao_offered_code3,).should == "Offered"
  end
end

Then /^the Cancel button is "([^"]*)"$/ do |cancel_button_state|
  on ManageCourseOfferings do |page|
    if cancel_button_state == "enabled"
      page.cancel_ao_button.enabled?.should be_true
    elsif cancel_button_state == "disabled"
      page.cancel_ao_button.enabled?.should be_false
    else
      raise 'Invalid button state. Allowed values are \'enabled\' and \'disabled\''
    end
  end
end

Then /^the Suspend button is "([^"]*)"$/ do |suspend_button_state|
  on ManageCourseOfferings do |page|
    if suspend_button_state == "enabled"
      page.suspend_ao_button.enabled?.should be_true
    elsif suspend_button_state == "disabled"
      page.suspend_ao_button.enabled?.should be_false
    else
      raise 'Invalid button state. Allowed values are \'enabled\' and \'disabled\''
    end
  end
end

Then /^the Reinstate button is "([^"]*)"$/ do |reinstate_button_state|
  on ManageCourseOfferings do |page|
    if reinstate_button_state == "enabled"
      page.reinstate_ao_button.enabled?.should be_true
    elsif reinstate_button_state == "disabled"
      page.reinstate_ao_button.enabled?.should be_false
    else
      raise 'Invalid button state. Allowed values are \'enabled\' and \'disabled\''
    end
  end
end

When /^I select an activity offering to work with in Offered status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_offered_code1)
  end
end

When /^I select the activity offering, which is in Offered status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_offered_code2)
  end
end

When /^I select the activity offering, which is in Draft status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_draft_code3)
  end
end

When /^I select the activity offering, which is in Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code4)
  end
end

When /^I deselect the activity offering, which is in Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.deselect_ao(@ao_canceled_code4)
  end
end

When /^I select the activity offering, which is in a Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code5)
  end
end

When /^I deselect the activity offering, which is in a Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.deselect_ao(@ao_canceled_code5)
  end
end

When /^I select the activity offering, which is Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code6)
  end
end

When /^I deselect the activity offering, which is Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.deselect_ao(@ao_canceled_code6)
  end
end

When /^I select the activity offering that is in Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code7)
  end
end

When /^I select the Canceled activity offerings$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code10)
    page.select_ao(@ao_canceled_code11)
  end
end

When /^I select the activity offering, which is a Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code9)
  end
end

When /^I deselect the activity offering that is in Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.deselect_ao(@ao_canceled_code7)
  end
end

When /^I select the activity offering that is in a Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code8)
  end
end

When /^I deselect the activity offering that is in a Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.deselect_ao(@ao_canceled_code8)
  end
end

Then /^I deselect the activity offering, which is in Draft status$/ do
  on ManageCourseOfferings do |page|
    page.deselect_ao(@ao_draft_code3)
  end
end

Then /^I deselect the Canceled activity offering$/ do
  on ManageCourseOfferings do |page|
    page.deselect_ao(@ao_canceled_code3)
  end
end

Then /^I deselect the Offered activity offering$/ do
  on ManageCourseOfferings do |page|
    page.deselect_ao(@ao_offered_code3)
  end
end

When /^I select the activity offering, which is in a Draft status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_draft_code4)
  end
end

Then /^I deselect the activity offering, which is in a Draft status$/ do
  on ManageCourseOfferings do |page|
    page.deselect_ao(@ao_draft_code4)
  end
end

When /^I select the activity offering, which is in approved status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_approved_code4)
  end
end

When /^I select the activity offering, which is in Approved status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_approved_code2)
  end
end

When /^I select the activity offering, which is in an Approved status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_approved_code3)
  end
end

When /^I select an activity offering to work with in Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code)
  end
end

When /^I select the Canceled activity offering$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code3)
  end
end

When /^I select the Offered activity offering$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_offered_code3)
  end
end

When /^I select an activity offering that is in Canceled status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_canceled_code2)
  end
end

When /^I select an activity offering to work with in Suspended status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_suspended_code)
  end
end

When /^I select an activity offering to work with in Approved status$/ do
  on ManageCourseOfferings do |page|
    page.select_ao(@ao_approved_code1)
  end
end

When /^I select the first activity offering in Draft status$/ do
  on ManageCourseOfferings do |page|
    @ao_draft_code1 = "C"
    page.ao_status(@ao_draft_code1).should == "Draft"
    page.select_ao(@ao_draft_code1)
  end
end

When /^I select the second activity offering in Draft status$/ do
  on ManageCourseOfferings do |page|
    @ao_draft_code2 = "D"
    page.ao_status(@ao_draft_code2).should == "Draft"
    page.select_ao(@ao_draft_code2)
  end
end

When /^I cancel the activity offering$/ do
  on(ManageCourseOfferings).cancel_ao
  on(CancelActivityOffering).cancel_activity
end

And /^I reinstate the activity offering$/ do
  on(ManageCourseOfferings).reinstate_ao
  on(ReinstateActivityOffering).reinstate_activity
end

When /^I suspend the activity offering$/ do
  on(ManageCourseOfferings).suspend_ao
  on(SuspendActivityOffering).suspend_activity
end

When /^I cancel the activity offering, verifying that one of the two selections is eligible for this action$/ do
  on(ManageCourseOfferings).cancel_ao
  on CancelActivityOffering do |page|
    page.warning_msg_present("1 activity offering(s) will be canceled").should == true
    page.warning_msg_present("1 activity offering(s) cannot be canceled (ineligible status)").should == true
    page.cancel_activity
  end
end

Then /^the Offered activity offering is shown as canceled$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@ao_offered_code1).should == "Canceled"
  end
end

Then /^the Offered activity offering is displayed as canceled$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@ao_offered_code2).should == "Canceled"
  end
end

Then /^the Suspended activity offering is shown as canceled$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@ao_suspended_code).should == "Canceled"
  end
end

Then /^the Canceled activity offering is shown as draft$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@ao_canceled_code9).should == "Draft"
  end
end

Then /^the Canceled activity offerings are shown as draft$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@ao_canceled_code10).should == "Draft"
    page.ao_status(@ao_canceled_code11).should == "Draft"
  end
end

Then /^the Approved activity offering is shown as canceled$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@ao_approved_code1).should == "Canceled"
  end
end

Then /^the Approved activity offering is displayed as suspended$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@ao_approved_code4).should == "Suspended"
  end
end

Then /^the first Draft activity offering is shown as canceled$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@ao_draft_code1).should == "Canceled"
  end
end

Then /^the second Draft activity offering is shown as canceled$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@ao_draft_code2).should == "Canceled"
  end
end

Then /^the Course Offering is shown as Canceled$/ do
  on ManageCourseOfferings do |page1|
    page1.list_all_course_link.click
    on ManageCourseOfferingList do |page2|
      page2.co_status("ENGL221").should == "Canceled"
    end
  end
end

Given /^I manage a course offering with a suspended activity offering present$/ do
  @course_with_suspend_ao = make CourseOffering, :term=> "201208" , :course => "BSCI421"
  @course_with_suspend_ao.manage
  on ManageCourseOfferings do |page|
    @ao_suspended_code = "D"
    page.ao_status(@ao_suspended_code).should == "Suspended"
  end
end

Given /^I manage a course offering with an approved activity offering present$/ do
  @course_with_approve_ao = make CourseOffering, :term=> "201700" , :course => "ENGL243"
  @course_with_approve_ao.manage
  on ManageCourseOfferings do |page|
    @ao_approved_code1 = "A"
    page.ao_status(@ao_approved_code1).should == "Approved"
  end
end

Given /^I manage a course offering with an offered activity offering present$/ do
  @course_with_offered_ao = make CourseOffering, :term=> "201208" , :course => "ENGL402"
  @course_with_offered_ao.manage
  on ManageCourseOfferings do |page|
    @ao_offered_code2 = "A"
    page.ao_status(@ao_offered_code2).should == "Offered"
  end
end

Given /^I manage a course offering with a draft activity offering present in a draft SOC state$/ do
  @course_with_draft_ao1 = make CourseOffering, :term=> "202000" , :course => "ENGL362"
  @course_with_draft_ao1.manage
  on ManageCourseOfferings do |page|
    @ao_draft_code3 = "A"
    page.ao_status(@ao_draft_code3).should == "Draft"
  end
end

Given /^I manage a course offering with a draft activity offering present in an open SOC state$/ do
  @course_with_draft_ao2 = make CourseOffering, :term=> "201900" , :course => "ENGL362"
  @course_with_draft_ao2.manage
  on ManageCourseOfferings do |page|
    @ao_draft_code4 = "A"
    page.ao_status(@ao_draft_code4).should == "Draft"
  end
end

Given /^I manage a course offering with an approved activity offering present in a locked SOC state$/ do
  @course_with_approved_ao1 = make CourseOffering, :term=> "201800" , :course => "ENGL362"
  @course_with_approved_ao1.manage
  on ManageCourseOfferings do |page|
    @ao_approved_code2 = "A"
    page.ao_status(@ao_approved_code2).should == "Approved"
  end
end

Given /^I manage a course offering with an approved activity offering present in a final edits SOC state$/ do
  @course_with_approved_ao2 = make CourseOffering, :term=> "201700" , :course => "ENGL362"
  @course_with_approved_ao2.manage
  on ManageCourseOfferings do |page|
    @ao_approved_code4 = "A"
    page.ao_status(@ao_approved_code4).should == "Approved"
  end
end

Given /^I manage a course offering with a canceled activity offering present in a published SOC state$/ do
  @course_with_cancel_ao2 = make CourseOffering, :term=> "201600" , :course => "ENGL243"
  @course_with_cancel_ao2.manage
  on ManageCourseOfferings do |page|
    @ao_canceled_code4 = "A"
    page.ao_status(@ao_canceled_code4).should == "Canceled"
  end
end

Given /^I manage a course offering with a canceled activity offering present in a draft SOC state$/ do
  @course_with_cancel_ao3 = make CourseOffering, :term=> "202000" , :course => "ENGL243"
  @course_with_cancel_ao3.manage
  on ManageCourseOfferings do |page|
    @ao_canceled_code5 = "A"
    page.ao_status(@ao_canceled_code5).should == "Canceled"
  end
end

Given /^I manage a course offering with a canceled activity offering present in an open SOC state$/ do
  @course_with_cancel_ao4 = make CourseOffering, :term=> "201900" , :course => "ENGL243"
  @course_with_cancel_ao4.manage
  on ManageCourseOfferings do |page|
    @ao_canceled_code6 = "A"
    page.ao_status(@ao_canceled_code6).should == "Canceled"
  end
end

Given /^I manage a course offering with a canceled activity offering present in a locked SOC state$/ do
  @course_with_cancel_ao5 = make CourseOffering, :term=> "201800" , :course => "ENGL243"
  @course_with_cancel_ao5.manage
  on ManageCourseOfferings do |page|
    @ao_canceled_code7 = "A"
    page.ao_status(@ao_canceled_code7).should == "Canceled"
  end
end

Given /^I manage a course offering with a canceled activity offering present in a final edits SOC state$/ do
  @course_with_cancel_ao6 = make CourseOffering, :term=> "201700" , :course => "ENGL243"
  @course_with_cancel_ao6.manage
  on ManageCourseOfferings do |page|
    @ao_canceled_code8 = "A"
    page.ao_status(@ao_canceled_code8).should == "Canceled"
  end
end

And /^actual delivery logistics for the Suspended activity offering are no longer shown$/ do
  on(ManageCourseOfferings).view_activity_offering("D")
  on ActivityOfferingInquiry do |page|
    page.actual_delivery_logistics.present?.should be_false
    page.close
  end
end

And /^actual delivery logistics for the Approved activity offering are no longer shown$/ do
  on(ManageCourseOfferings).view_activity_offering("A")
  on ActivityOfferingInquiry do |page|
    page.actual_delivery_logistics.present?.should be_false
    page.close
  end
end

And /^actual delivery logistics for the Approved activity offering are still shown$/ do
  on(ManageCourseOfferings).view_activity_offering("A")
  on ActivityOfferingInquiry do |page|
    page.actual_delivery_logistics.present?.should be_true
    page.close
  end
end

And /^requested delivery logistics are still shown and actual delivery logistics are not shown for the activity offering$/ do
  on(ManageCourseOfferings).view_activity_offering("A")
  on ActivityOfferingInquiry do |page|
    page.requested_delivery_logistics.present?.should be_true
    page.actual_delivery_logistics.present?.should be_false
    page.close
  end
end

And /^requested delivery logistics are still shown and actual delivery logistics are not shown for both activity offerings$/ do
  on(ManageCourseOfferings).view_activity_offering("A")
  on ActivityOfferingInquiry do |page|
    page.requested_delivery_logistics.present?.should be_true
    page.actual_delivery_logistics.present?.should be_false
    page.close
  end
  @course_with_cancel_ao8.manage
  on(ManageCourseOfferings).view_activity_offering("B")
  on ActivityOfferingInquiry do |page|
    page.requested_delivery_logistics.present?.should be_true
    page.actual_delivery_logistics.present?.should be_false
    page.close
  end
end

And /^the registration group is shown as canceled$/ do
  on ManageCourseOfferings do |page|
    page.view_all_reg_groups

  end
end

And /^the Suspended activity offering is no longer shown in the Schedule of Classes$/ do
  go_to_display_schedule_of_classes
  @schedule_of_classes = make ScheduleOfClasses, :term => "Fall 2012", :course_search_parm => "BSCI421", :exp_course_list => ["BSCI421"]
  @schedule_of_classes.display
  @schedule_of_classes.expand_course_details
  on DisplayScheduleOfClasses do |page|
    if !page.results_activities_table.exists?
      raise "activities table not found"
    else
      page.results_activities_table.rows[1..-1].each do |row|
        # check only rows with data in them
        row.cells[DisplayScheduleOfClasses::CODE_COL].text.should_not == "D"
      end
    end
  end
end

And /^the Course Offering is no longer shown in the Schedule of Classes$/ do
  course_code = "ENGL221"
  go_to_display_schedule_of_classes
  @schedule_of_classes = make ScheduleOfClasses, :term => "Fall 2012", :course_search_parm => course_code, :exp_course_list => [course_code]
  @schedule_of_classes.display
  on DisplayScheduleOfClasses do |page|
    # if the message (Cannot find any course offering...) is there, we're good; otherwise, check the table
    if !page.course_not_found_info_message_div.ul.exists?
      if page.get_results_course_list.include?(course_code)
        raise "course #{course_code} found in results table"
      end
    end
  end
end

And /^a suspended success message is displayed$/ do
  #validate the success-growl is being shown
  on ManageCourseOfferings do |page|
    sleep 2 #TODO: required by headless
    page.growl_text.should == "The selected activity offering was successfully suspended."
  end
end

And /^a resinstated success message is displayed$/ do
  #validate the success-growl is being shown
  on ManageCourseOfferings do |page|
    sleep 2 #TODO: required by headless
    page.growl_text.should == "The selected activity offering was successfully resinstated."
  end
end

And /^I approve the two Course Offerings for scheduling$/ do
  @course_offering_ENGL221.approve_co_list :co_obj_list => [@course_offering_ENGL221,@course_offering_ENGL202]
end

When /^I manage a Course Offering$/ do
#to make each scenario independent, we make a new co
  @course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :term=> Rollover::MAIN_TEST_TERM_TARGET, :course => "ENGL202")
end

And /^I approve the Course Offering for scheduling$/ do
  @course_offering.approve_co
end

And /^I approve selected Activity Offerings for scheduling$/ do
  @course_offering.manage_and_init
  @selected_ao_list =  @course_offering.activity_offering_cluster_list[0].ao_list[0..1]
  @course_offering.approve_ao_list(:ao_obj_list => @selected_ao_list)
end

And /^I approve the first Activity Offering for scheduling$/ do
  @course_offering.manage_and_init
  @selected_ao_list =  @course_offering.activity_offering_cluster_list[0].ao_list[0..0]
  @course_offering.approve_ao_list(:ao_obj_list => @selected_ao_list)
end

Then /^the Activity Offerings of these two COs should be in Approved state$/ do
  @course_offering_ENGL221.manage_and_init
  new_cluster_list = @course_offering_ENGL221.activity_offering_cluster_list
  ao_list = @course_offering_ENGL221.get_ao_list
  #ao_list = new_cluster_list[0].ao_list
  ao_list.each do |ao|
    on ManageCourseOfferings do |page|
      page.ao_status(ao.code).should == ActivityOffering::APPROVED_STATUS
    end
  end
  @course_offering_ENGL202.manage_and_init
  #new_cluster_list = @course_offering_ENGL202.activity_offering_cluster_list
  ao_list = @course_offering_ENGL202.get_ao_list
  ao_list.each do |ao|
    on ManageCourseOfferings do |page|
      page.ao_status(ao.code).should == ActivityOffering::APPROVED_STATUS
    end
  end
end

Then /^the Activity Offerings should be in Approved state$/ do
  @course_offering.manage_and_init
  @course_offering.get_ao_list.each do |ao|
    on ManageCourseOfferings do |page|
      page.ao_status(ao.code).should == ActivityOffering::APPROVED_STATUS
    end
  end
end

Then /^the selected Activity Offerings should be in Approved state$/ do
  @course_offering.manage
  @selected_ao_list.each do |ao|
    on ManageCourseOfferings do |page|
      page.ao_status(ao.code).should == ActivityOffering::APPROVED_STATUS
    end
  end
end