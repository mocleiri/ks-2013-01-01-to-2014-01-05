When /^I attempt to edit an activity offering for a course offering in my admin org/ do
  @course_offering = make CourseOffering, :course=>"ENGL362" , :term=>@term_for_test
  @course_offering.manage
  @course_offering.edit_ao(:ao_code => "A")

  on ActivityOfferingMaintenance do |page|
    page.submit_button.enabled?.should == true
  end

end

Then /^I do not have access to add or edit seat pools$/ do
  on ActivityOfferingMaintenance do |page|
    page.add_pool_element.present?.should == false
  end
end

When /^I attempt to edit a course not in my admin org$/ do
  @course_offering = make CourseOffering, :course=>"CHEM611", :term=>@term_for_test
  @course_offering.search_by_coursecode
end

Then /^I do not have access to edit the course offering$/ do
  on ManageCourseOfferings do |page|
    page.ao_results_div.present?.should == true
    page.edit_course_offering_link.present?.should == false
  end
end

Then /^I do not have access to delete the listed course offering$/ do
  on ManageCourseOfferingList do |page|
    page.select_cos([@course_offering.course])
    page.delete_cos_button.enabled?.should be_false
    page.deselect_cos([@course_offering.course])
  end
end

Then /^I do not have access to approve the listed course offering$/ do
  on ManageCourseOfferingList do |page|
    page.select_cos([@course_offering.course])
    page.approve_course_offering_button.enabled?.should be_false
    page.deselect_cos([@course_offering.course])
  end
end

Then /^I do not have access to edit the listed course offering$/ do
  on ManageCourseOfferingList do |page|
    page.edit_link(@course_offering.course).present?.should be_false
  end
end

Then /^I do not have access to copy the listed course offering$/ do
  on ManageCourseOfferingList do |page|
    page.copy_link(@course_offering.course).present?.should be_false
  end
end

Then /^I do not have access to add course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.add_course_offering_button.present?.should be_false
  end
end

Then /^I do not have access to manage registration groups$/ do
  on ManageCourseOfferings do |page|
    page.manage_registration_groups_link.attribute_value("class").should match /disabled/
  end
end

Then /^an authorization error is displayed when I attempt to edit the course offering$/ do
  on ManageCourseOfferings do |page|
    page.auth_error.present?.should be_true
  end
end


When /^I manage course offerings for a course in my admin org$/ do
  @course_offering = make CourseOffering, :course=>"ENGL346", :term=>"201612"
  @course_offering.search_by_coursecode
end

When /^I manage a course offering for a subject code not in my admin org$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :course=>"CHEM611", :term=>@term_for_test
  @course_offering.manage
end


When /^I manage course offerings for a subject code not in my admin org$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :course=>"CHEM611", :term=>@term_for_test
  @course_offering.search_by_subjectcode
end

When /^I manage course offerings for a subject code in my admin org$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :course=>"ENGL206", :term=>@term_for_test
  @course_offering.search_by_subjectcode
end

When /^I manage a course offering in my admin org$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :course=>"ENGL222", :term=>@term_for_test
  @course_offering.manage
  @activity_offering = make ActivityOffering, :code=>"A"
end

When /^I manage course offerings for a subject code$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :course=>"CHEM611", :term=>@term_for_test
  @course_offering.search_by_subjectcode
end

When /^I manage a course offering$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :course=>"CHEM611", :term=>@term_for_test
  @course_offering.manage
  @activity_offering = make ActivityOffering, :code=>"A"
end

Then /^I have access to view course offering details$/ do
  on ManageCourseOfferingList do |page|
    page.view_course_offering_link(@course_offering.course).present?.should be_true
  end
end

Then /^I have access to manage course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.manage_link(@course_offering.course).present?.should be_true
  end
end

Then /^I have access to add new course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.create_course_offering_button.present?.should == true
  end
end

Then /^I have access to approve course offerings for scheduling$/ do
  on ManageCourseOfferingList do |page|
    page.select_cos([@course_offering.course])
    page.approve_course_offering_button.present?.should == true
  end
end

Then /^I have access to delete course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.select_cos([@course_offering.course])
    page.approve_course_offering_button.present?.should == true
  end
end

Then /^I have access to edit course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.edit_link(@course_offering.course).present?.should be_true
  end
end

Then /^I have access to copy course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.copy_link(@course_offering.course).present?.should be_true
  end
end

Then /^I have access to delete the course offering$/ do
  on ManageCourseOfferings do |page|
    page.delete_course_offering_link.present?.should be_true
  end
end

Then /^I have access to edit the course offering$/ do
  on ManageCourseOfferings do |page|
    page.edit_course_offering_link.present?.should be_true
  end
end

Then /^I have access to view the course offering details$/ do
  on ManageCourseOfferings do |page|
    page.view_co_details_link.present?.should be_true
  end
end

Then /^I have access to view the activity offering details$/ do
  on ManageCourseOfferings do |page|
    page.view_activity_offering_link(@activity_offering.code).present?.should be_true
  end
end

Then /^the next, previous and list all course offering links are enabled$/ do
  on ManageCourseOfferings do |page|
    page.previous_course_link.present?.should be_true
    page.list_all_course_link.present?.should be_true
    page.next_course_link.present?.should be_true
  end
end

Then /^I have access to add a new activity offering$/ do
  on ManageCourseOfferings do |page|
    page.add_activity_button.present?.should be_true
  end
end

Then /^I have access to delete an activity offering$/ do
  on ManageCourseOfferings do |page|
    page.select_aos([@activity_offering.code])
    page.delete_aos_button.present?.should be_true
    page.deselect_aos([@activity_offering.code])
  end
end

Then /^I have access to edit an activity offering$/ do
  on ManageCourseOfferings do |page|
    page.edit_link(@activity_offering.code).present?.should be_true
  end
end

Then /^I have access to copy activity offering$/ do
  on ManageCourseOfferings do |page|
    page.copy_link(@activity_offering.code).present?.should be_true
  end
end

Then /^I have access to manage registration groups$/ do
  on ManageCourseOfferings do |page|
    page.manage_registration_groups_link.present?.should be_true
  end
end

Then /^I do not have access to manage the course offering$/ do
  #on ManageCourseOfferingList do |page|
  #  page.target_row(@course_offering.course).link(text: "Manage").click
  #  page.loading.wait_while_present
  #end
  on ManageCourseOfferings do |page|
    page.auth_error.present?.should == true
  end
end

Then /^I do not have access to create the course offering$/ do
  on CreateCourseOffering do |page|
    page.auth_error.present?.should == true
  end
end

When /^I attempt to create a course not in my admin org$/ do
  @course_offering = make CourseOffering, :term=> @term_for_test, :course => "CHEM132"
  @course_offering.start_create_by_search
end

When /^I attempt to create a course in my admin org$/ do
  @course_offering = make CourseOffering, :term=> @term_for_test, :course => "ENGL310"
  @course_offering.start_create_by_search
end

Then /^I have access to create the course offering from catalog$/ do
  on CreateCourseOffering do |page|
    page.suffix.present?.should == true
  end
end
When /^I have access to create the course from an existing offering$/ do
  on CreateCourseOffering do |page|
    page.create_from_existing_offering_tab
    page.configure_course_offering_copy_element.present?.should == true
  end
end

When /^there is a "([^"]*)" course in my admin org/ do |costate|
  step "I am logged in as a Schedule Coordinator"
  @course_offering = make CourseOffering, :term=> @term_for_test, :course => "ENGL206"
  @course_offering.search_by_subjectcode
  @course_offering.check_for_course(costate)
  @newCO = @course_offering.course
  step "I am logged in as a Department Schedule Coordinator"
end

When /^there is a "([^"]*)" course present/ do |costate|
  step "I am logged in as a Schedule Coordinator"
  @course_offering = make CourseOffering, :term=> @term_for_test, :course => "ENGL206"
  @course_offering.search_by_subjectcode
  @course_offering.check_for_course(costate)
  @newCO = @course_offering.course
end

When /^I have access to delete an activity offering in a "([^"]*)" state for a course in my admin org$/ do |aostate|
  if @newCO
    @course_offering = make CourseOffering, :term=> @term_for_test, :course => @newCO
  else
    @course_offering = make CourseOffering, :term=> @term_for_test, :course => "ENGL206"
  end
  @course_offering.manage
  @course_offering.attempt_ao_delete_by_status(aostate).should == true
end

Then /^I have access to delete a course offering in a "([^"]*)" state for a course in my admin org$/ do |costate|
  @course_offering.search_by_subjectcode
  @course_offering.attempt_co_delete_by_status(costate).should == true
end

Then /^I do not have access to view the activity offerings$/ do
  on ManageCourseOfferings do |page|
    page.auth_error.present?.should == true
  end
end

When /^I edit a course offering in my admin org$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :term => @term_for_test, :course=>"ENGL206"
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I attempt to edit a course offering in my admin org$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :term => @term_for_test, :course=>"ENGL206"
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering_link.present?.should be_false
  end
end

When /^I edit an existing course offering$/ do
  @course_offering = make CourseOffering, :term => @term_for_test, :course=>"CHEM612"
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

Then /^I have access to edit the grading options$/ do
  on CourseOfferingEdit do |page|
    page.grading_option_div.radio.present?.should be_true
  end
end

Then /^I have access to edit the course code suffix$/ do
  on CourseOfferingEdit do |page|
    page.suffix.present?.should be_true
  end
end

Then /^I have access to edit the registration options$/ do
  on CourseOfferingEdit do |page|
    page.registration_opts_div.checkbox.enabled?.should be_true
  end
end

Then /^I have access to edit the credit type$/ do
  on CourseOfferingEdit do |page|
    page.credits.enabled?.should be_true
  end
end

Then /^I have access to edit the format type$/ do
  on CourseOfferingEdit do |page|
    page.select_format_type_add.enabled?.should be_true
    #page.select_grade_roster_level_add.enabled?.should be_true - need to select type first
    #page.delivery_format_add_element.enabled?.should be_true - need to select type first
  end
end

Then /^I have access to edit the waitlists flag$/ do
  on CourseOfferingEdit do |page|
    page.waitlist_checkbox.enabled?.should be_true
    page.waitlist_div.radio.enabled?.should be_true #waitlist level
    page.waitlist_select.enabled?.should be_true
  end
end

Then /^I have access to edit the affiliated personnel$/ do
  on CourseOfferingEdit do |page|
    page.add_personnel_button_element.enabled?.should be_true
  end
end

Then /^I have access to edit the administrating org$/ do
  on CourseOfferingEdit do |page|
    page.add_org_button.enabled?.should be_true
  end
end

Then /^I have access to edit the CO honors flag$/ do
  on CourseOfferingEdit do |page|
    page.honors_flag.enabled?.should be_true
  end
end

Then /^I do not have access to edit the final exam type$/ do
  on CourseOfferingEdit do |page|
    page.final_exam_option_div.radio.present?.should be_false
  end
end
#Then /^I have access to edit the $/ do
#  on CourseOfferingEdit do |page|
#    page..present?.should be_true
#  end
#end

Then /^I attempt to perform a rollover$/ do
  go_to_perform_rollover
end

Then /^I attempt to view rollover details$/ do
  go_to_rollover_details
end

When /^I do not have access to the page$/ do
  on ErrorPage do |page|
    page.error_401.should == true
  end
end

Then /^I have access to revise delivery logistics$/ do
  on ActivityOfferingMaintenance do |page|
    page.revise_actual_delivery_logistics
  end
  on ActivityOfferingLogistics do |page|
    page.cancel_element.present?.should == true
    page.cancel
  end
end

Then /^I do not have access to revise delivery logistics$/ do
  on ActivityOfferingMaintenance do |page|
    page.revise_actual_delivery_logistics_button.present?.should be_false
  end
end

Then /^I have access to edit the activity code$/ do
  on ActivityOfferingMaintenance do |page|
    page.activity_code.enabled?.should be_true
  end
end

Then /^I do not have access to edit the activity code$/ do
  on ActivityOfferingMaintenance do |page|
    page.activity_code.present?.should be_false
  end
end

Then /^I have access to edit total maximum enrollment$/ do
  on ActivityOfferingMaintenance do |page|
    page.total_maximum_enrollment.enabled?.should be_true
  end
end


Then /^I have access to add or edit affiliated personnel$/ do
  on ActivityOfferingMaintenance do |page|
    page.add_personnel_element.present?.should be_true
  end
end

Then /^I have access to edit the evaluation flag$/ do
  on ActivityOfferingMaintenance do |page|
    page.requires_evaluation.enabled?.should be_true
  end
end

Then /^I have access to edit the course url$/ do
  on ActivityOfferingMaintenance do |page|
    page.course_url.present?.should be_true
  end
end

Then /^I have access to edit the honors flag$/ do
  on ActivityOfferingMaintenance do |page|
    page.honors_flag.enabled?.should be_true
  end
end