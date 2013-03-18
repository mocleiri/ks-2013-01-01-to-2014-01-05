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

Then /^I have access to delete an activity offering in a "([^"]*)" state$/ do |aostate|
  @course_offering.manage
  @course_offering.attempt_ao_delete_by_status(aostate).should == true
end

Then /^I have access to delete a course offering in a "([^"]*)" state$/ do |costate|
  @course_offering.search_by_subjectcode
  @course_offering.attempt_co_delete_by_status(costate).should == true
end

Then /^I do not have access to delete an activity offering in a "([^"]*)" state$/ do |aostate|
  @course_offering.manage
  @course_offering.attempt_ao_delete_by_status(aostate).should == false
end

Then /^I do not have access to delete a course offering in a "([^"]*)" state$/ do |costate|
  @course_offering.search_by_subjectcode
  @course_offering.attempt_co_delete_by_status(costate).should be_false
end