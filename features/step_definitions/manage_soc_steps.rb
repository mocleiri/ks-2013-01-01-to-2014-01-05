Given /^I manage SOC for a term$/ do
=begin
  @rollover = make Rollover, :source_term => "201205", :target_term => "202105"
  @rollover.perform_rollover
  @rollover.wait_for_rollover_to_complete
  @rollover.release_to_depts

  @course_offering = make CourseOffering, :course=>"ENGL245", :term=>"202105"
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.ao_from_first_cluster.set
    page.approve_activity
  end
=end
  @term_code = "202105"
  @co_code = "ENGL245"
  @manageSoc = make ManageSoc, :term_code => @term_code, :co_code => @co_code
end

Given /^I manage SOC for "(.*?)"$/ do |term_code|
  @manageSoc = make ManageSoc, :term_code =>term_code
end

When /^I (.*?) the SOC$/ do |newState|
  @manageSoc.search
  @manageSoc.change_action newState
end

Then /^I verify that (.*?) button is there for next action$/ do |nextState|
  @manageSoc.check_state_change_button_exists nextState
end

And /^I verify the related object state changes for (.*?) action$/ do |state|
  if state == 'Schedule'
    verify_schedule_state_changes
  elsif state == 'Publish'
    verify_publish_state_changes
  else
    raise 'Invalid state. Allowed values are \'Schedule\' and \'Publish\''
  end
end

def verify_schedule_state_changes
  @browser.goto "#{$test_site}/kr-krad/statusview/#{@term_code}/#{@co_code}"
  on StatusViewPage do |page|
    page.soc_state.should == 'Locked'
    page.soc_scheduling_state.should == 'Completed'
    (page.co_state =~ /Planned$/).should_not == nil
    page.approved_aos.each do |row|
      page.fo_state(row).should == 'Planned'
    end
  end
end

def verify_publish_state_changes
  @browser.goto "#{$test_site}/kr-krad/statusview/#{@term_code}/#{@co_code}"
  on StatusViewPage do |page|
    page.soc_state.should == 'Published'
    page.soc_scheduling_state.should == 'Completed'
    (page.co_state =~ /Offered/).should_not == nil
    page.offered_aos.each do |row|
      page.ao_state(row).should == 'Offered'
      page.fo_state(row).should == 'Offered'
    end
  end
end