#Scenario: Edit Activity Offering Information attributes
Given /^I am editing the information attributes for an activity offering$/ do
  # Activity Code can not be saved. This is a bug
  # Modify Total Maximum Enrollment to 50
  @activity_offering.edit :course_url => "www.kuali.org", :max_enrollment => 50
end

And /^I submit the AO changes$/ do
  @activity_offering.save

  #validate the success-growl is being shown
  on ManageCourseOfferings do |page|
    sleep 2 #TODO: required by headless
    page.growltext.should == "Activity Offering modified."
  end
end

When /^I save the changes and remain on the Edit AO page$/ do
  @activity_offering.save_and_remain_on_page
end

Then /^the changes of Activity Offering attributes are persisted$/ do
  @course_offering.manage
  @activity_offering.edit
  on ActivityOfferingMaintenance do |page|
    page.total_maximum_enrollment.value.should == @activity_offering.max_enrollment.to_s
    page.course_url.value.should == @activity_offering.course_url
  end
end

Then /^the changes of information attributes (are|are not) persisted$/ do |are_are_not|
  @course_offering.manage
  @activity_offering.edit
  on ActivityOfferingMaintenance do |page|
    if are_are_not == "are"
      page.total_maximum_enrollment.value.should == @activity_offering.max_enrollment.to_s
      page.course_url.value.should == @activity_offering.course_url
    elsif are_are_not == "are not"
      page.total_maximum_enrollment.value.should_not == @activity_offering.max_enrollment.to_s
      page.course_url.value.should_not == @activity_offering.course_url
    end
  end
end

When /^I save the changes and jump to the (next|previous) AO$/  do |direction|
  on ActivityOfferingMaintenance do |page|
    if direction == "next"
      page.next_ao
      @expected_title = "#{@course_offering.course} - #{page.next_ao_text}"
    else
      page.prev_ao
      @expected_title = "#{@course_offering.course} - #{page.prev_ao_text}"
    end
    page.save_and_continue
  end
  puts "#{direction} = #{@expected_title}"
  on ActivityOfferingMaintenance do |page|
    puts "Expected: #{@expected_title}, Found: #{page.ao_header_text}"
    page.ao_header_text.should == @expected_title
  end
end

When /^I jump to the (next|previous) AO without saving the changes$/ do |direction|
  on ActivityOfferingMaintenance do |page|
    if direction == "next"
      page.next_ao
      @expected_title = page.next_ao_text
    else
      page.prev_ao
      @expected_title = page.prev_ao_text
    end
    page.continue_without_saving
  end
  puts "#{direction} = #{@expected_title}"
  on ActivityOfferingMaintenance do |page|
    puts "new next = #{page.next_ao_text}"
  end
end

When /^I jump to an arbitrary AO without saving the changes$/ do
  on ActivityOfferingMaintenance do |page|
    @target = "Discussion E"
    page.jump_to_ao(@target)
    page.continue_without_saving
  end
  @expected_title = "#{@course_offering.course} - #{@target}"
  on ActivityOfferingMaintenance do |page|
    puts "Expected: #{@expected_title}, Found: #{page.ao_header_text}"
    page.ao_header_text.should == @expected_title
  end
end

When /^I save the changes and jump to an arbitrary AO$/ do
  on ActivityOfferingMaintenance do |page|
    @target = "Discussion E"
    page.jump_to_ao(@target)
    page.save_and_continue
  end
  @expected_title = "#{@course_offering.course} - #{@target}"
  on ActivityOfferingMaintenance do |page|
    puts "Expected: #{@expected_title}, Found: #{page.ao_header_text}"
    page.ao_header_text.should == @expected_title
  end
end

When /^I jump to an arbitrary AO but cancel the change$/ do
  on ActivityOfferingMaintenance do |page|
    @target = "Discussion E"
    page.jump_to_ao(@target)
    page.cancel_save
  end
  @expected_title = "#{@course_offering.course} - #{@activity_offering.activity_type} #{@activity_offering.code}"
  on ActivityOfferingMaintenance do |page|
    puts "Expected: #{@expected_title}, Found: #{page.ao_header_text}"
    page.ao_header_text.should == @expected_title
  end

end
When /^I change Personnel attributes$/ do
  person = make Personnel, :id => "admin", :name => "admin, admin", :affiliation => "Instructor", :inst_effort => 30
  @activity_offering.edit :personnel_list => [person]
end

Then /^the changes of the Personnel attributes are persisted$/ do
  @course_offering.manage
  @activity_offering.edit
  on ActivityOfferingMaintenance do |page|
    page.personnel_id.value.should == @activity_offering.personnel_list[0].id
    page.personnel_effort.value.should == @activity_offering.personnel_list[0].inst_effort.to_s
    page.personnel_name.value.should == @activity_offering.personnel_list[0].name
  end
end

When /^I change Miscellaneous Activity Offering attributes$/ do
  @activity_offering.edit :requires_evaluation => !(@prev_req_ev), :honors_course => !(@prev_hon_flg)
end


Then /^the miscellaneous changes are persisted$/ do
  @course_offering.manage
  @activity_offering.edit
  on ActivityOfferingMaintenance do |page|
    page.requires_evaluation.set?.should_not == @prev_req_ev
    page.honors_flag.set?.should_not == @prev_hon_flg
  end
end

Given /^I manage a given Course Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :course=>"ENGL222")
  @course_offering.manage_and_init
end

# Get activity offering A and force flags to false, so we can be sure that setting them to true later is a valid test
Given /^I edit an Activity Offering$/ do
  @activity_offering = @course_offering.get_ao_obj_by_code("B")
  @prev_req_ev = @activity_offering.requires_evaluation
  @prev_hon_flg = @activity_offering.honors_course
end