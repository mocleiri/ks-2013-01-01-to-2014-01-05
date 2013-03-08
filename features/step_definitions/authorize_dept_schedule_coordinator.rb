When /^I attempt to edit an activity offering for a course offering in my department$/ do
  @course_offering = make CourseOffering, :course=>"ENGL362" , :term=>@term_for_test
  @course_offering.search_by_coursecode
  on ManageCourseOfferings do |page|
    page.edit("A")
  end
end

Then /^I do not have access to add or edit seat pools$/ do
  on ActivityOfferingMaintenance do |page|
    page.add_pool_element.present?.should == false
  end
end

When /^I attempt to edit a course not in my department$/ do
  @course_offering = make CourseOffering, :course=>"CHEM611", :term=>@term_for_test
  @course_offering.search_by_coursecode
end

Then /^I do not have access to edit the course offering$/ do
  on ManageCourseOfferings do |page|
    page.edit_offering_element.present?.should == false
  end
end

Then /^an authorization error is displayed when I attempt to edit the course offering$/ do
  on ManageCourseOfferings do |page|
    page.auth_error.present?.should == true
  end
end


When /^I manage course offerings for a course in my department$/ do
  @course_offering = make CourseOffering, :course=>"ENGL346", :term=>"201612"
  @course_offering.search_by_coursecode
end

When /^I manage course offerings for a subject code not in my department$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :course=>"CHEM611", :term=>@term_for_test
  @course_offering.search_by_subjectcode
end

When /^I manage course offerings for a subject code in my department$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :course=>"ENGL206", :term=>@term_for_test
  @course_offering.search_by_subjectcode
end

When /^I manage a course offering in my department$/ do
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

Then /^I can view course offering details$/ do
  on ManageCourseOfferingList do |page|
    page.view_course_offering_link(@course_offering.course).present?.should be_true
  end
end

Then /^I can manage the course offering$/ do
  on ManageCourseOfferingList do |page|
    page.manage_link(@course_offering.course).present?.should be_true
  end
end

Then /^I can add new course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.create_course_offering_button.present?.should == true
  end
end

Then /^I can approve course offerings for scheduling$/ do
  on ManageCourseOfferingList do |page|
    page.select_cos([@course_offering.course])
    page.approve_course_offering_button.present?.should == true
  end
end

Then /^I can delete course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.select_cos([@course_offering.course])
    page.approve_course_offering_button.present?.should == true
  end
end

Then /^I can edit course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.edit_link(@course_offering.course).present?.should be_true
  end
end

Then /^I can copy course offerings$/ do
  on ManageCourseOfferingList do |page|
    page.copy_link(@course_offering.course).present?.should be_true
  end
end

Then /^I can view the activity offering details$/ do
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

Then /^I can add a new activity offering$/ do
  on ManageCourseOfferings do |page|
    page.add_activity_button.present?.should be_true
  end
end

Then /^I can delete an activity offering$/ do
  on ManageCourseOfferings do |page|
    page.select_aos([@activity_offering.code])
    page.delete_aos_button.present?.should be_true
    page.deselect_aos([@activity_offering.code])
  end
end

Then /^I can edit an activity offering$/ do
  on ManageCourseOfferings do |page|
    page.edit_link(@activity_offering.code).present?.should be_true
  end
end

Then /^I can copy activity offering$/ do
  on ManageCourseOfferings do |page|
    page.copy_link(@activity_offering.code).present?.should be_true
  end
end

#Then /^$/ do
#  on ManageCourseOfferings do |page|
#    page.copy_link(@activity_offering.code).present?.should be_true
#  end
#end

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


When /^I attempt to create a course not in my department$/ do
  @course_offering = make CourseOffering, :term=> @term_for_test, :course => "CHEM132"
  @course_offering.start_create_by_search
end

When /^I attempt to create a course in my department$/ do
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

When /^there is a draft course in my department/ do
  step "I am logged in as a Schedule Coordinator"
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term=>@term_for_test, :course => "ENGL206")
  @newCO = @course_offering.course
  step "I am logged in as a Department Schedule Coordinator"
end

When /^I have access delete an activity offering in a "([^"]*)" state for a course in my department$/ do |aostate|
  if @newCO
  @course_offering = make CourseOffering, :term=> @term_for_test, :course => @newCO
  else
    @course_offering = make CourseOffering, :term=> @term_for_test, :course => "ENGL206"
  end
  @course_offering.manage
  @course_offering.attempt_ao_delete_by_status(aostate).should == true
end

When /^I copy and approve a course offering$/ do
  @course_offering = create CourseOffering, :term=>@term_for_test, :create_by_copy=>(make CourseOffering, :term=>@term_for_test, :course => "ENGL206")
  @course_offering.approve_course
end

Then /^I have access to delete a course offering in a "([^"]*)" state for a course in my department$/ do |costate|
  @course_offering.search_by_subjectcode
  @course_offering.attempt_co_delete_by_status(costate).should == true
end

Then /^I do not have access to view the activity offerings$/ do
  on ManageCourseOfferings do |page|
    page.auth_error.present?.should == true
  end
end

When /^I edit a course offering in my department$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :term => @term_for_test, :course=>"ENGL206"
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_offering
  end
end

When /^I attempt to edit a course offering in my department$/ do
  @term_for_test = Rollover::OPEN_SOC_TERM unless @term_for_test != nil
  @course_offering = make CourseOffering, :term => @term_for_test, :course=>"ENGL206"
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_offering_element.present?.should be_false
  end
end

Then /^I can edit the grading options$/ do
  on CourseOfferingEdit do |page|
    page.grading_option_letter.present?.should be_true
  end
end