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