When /^I run the State Propagation test$/ do
  go_to_state_propagation
  @state_propagation = make StatePropagation
  on StatePropagation do |page|
    page.perform_propagation_test
  end
end

Then /^all State Propagation test rows should have status pass$/ do
  on StatePropagation do |page|
    page.read_results_tables.should be_true
  end
end

When /^I manually change a given soc-state to "(Publishing|In Progress)"$/ do |newSocState|
  @manualSocStateChanger = make ManualSocStateChange
  @manualSocStateChanger.perform_manual_soc_state_change :new_soc_state=>newSocState
end

Then /^I verify that I cannot manage course offerings$/ do
  course_offering = make CourseOffering, :term => @manualSocStateChanger.term
  course_offering.search_by_subjectcode
  expected_errMsg = "Access to course offerings is not permitted while this term's Set of Courses (SOC) is"
  on(ManageCourseOfferings).first_msg.should match /.*#{Regexp.escape(expected_errMsg)}.*/
end

When /^I do some stuff$/ do


puts 'here'
sleep 30

end