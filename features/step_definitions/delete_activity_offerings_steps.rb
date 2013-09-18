When /^I create a Course Offering with (\d+) Activity Offerings$/ do |number_of_aos_to_create|
  @course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :course=>"CHEM401")
  @course_offering.manage_and_init
  @orig_number_aos = @course_offering.get_ao_list.count
  @activity_offering = make ActivityOffering, :format => "Lecture Only"
  @course_offering.create_list_aos :ao_object => @activity_offering, :number_aos_to_create=>number_of_aos_to_create
  @course_offering.manage_and_init
  @total_number =  @course_offering.get_ao_list.count
end



And /^I delete (\d+) Activity Offerings$/ do |number_of_aos_to_delete|
  @aos_to_delete = []
  @course_offering.get_ao_list[-(number_of_aos_to_delete.to_i)..-1].each do |ao|
    @aos_to_delete << ao.code
  end
  @course_offering.delete_ao_list :code_list => @aos_to_delete
end

Then /^the Course Offering should contain (\d+) Activity Offerings$/ do |expect_nbr_aos|
  @course_offering.manage_and_init
  (@course_offering.get_ao_list.count - @orig_number_aos).should == expect_nbr_aos.to_i
end

Then /^the (\d+) AOs are Successfully deleted$/ do |number_of_aos_deleted|
  @course_offering.manage_and_init
  @course_offering.get_ao_list.count.should == @total_number.to_i - number_of_aos_deleted.to_i
  ao_codes = []
  @course_offering.get_ao_list[0..@course_offering.get_ao_list.count].each do |ao|
    ao_codes << ao.code
  end
  for code in @aos_to_delete
    ao_codes.should_not include code
  end
end


When /^I designate a valid term and cross\-listed Course Offering Code$/ do
  @course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :course => "ENGL250")
  #@course_offering.manage_and_init
end

And /^I delete the AO with Draft state$/ do
  @course_offering.manage_and_init
  orig_total = @course_offering.get_ao_list.count
  @course_offering.create_ao(make ActivityOffering, :format => "Lecture Only")
  @course_offering.get_ao_list.count.should == orig_total + 1
  @total_number = @course_offering.get_ao_list.count
  @deleted_ao_codes = [@course_offering.get_ao_list[-1].code]
  confirm_message = @course_offering.delete_ao_list :code_list =>  @deleted_ao_codes
  expect_result = "Crosslisted as: WMST255"
  confirm_message.should include expect_result
end

Then /^The AO is Successfully deleted$/ do
  @course_offering.manage_and_init
  @course_offering.get_ao_list.count.should == @total_number - 1
  @course_offering.get_ao_list.should_not include @deleted_ao_codes
end
