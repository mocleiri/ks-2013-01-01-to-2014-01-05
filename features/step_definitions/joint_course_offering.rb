When /^I create joint Course Offerings$/ do
  pending # need to define :joint_select method in course_offering_object.rb
  @course_offering = create CourseOffering, :term=> Rollover::OPEN_SOC_TERM, :course => "BSCI181", :joint_select => "CHEM181", :grade_format => "Lab", :delivery_format => "Lab"
end

Then /^I can add activity offerings to the joint Course Offerings$/ do
  pending # express the regexp above with the code you wish you had
  on ManageCourseOfferings do |page|
    format = page.format.options[1].text
    page.add_ao format, 1
  end
end

When /^I attempt to delete a joint Course Offering$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^I can cancel the deletion$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^I can complete the deletion$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the Course Offering is deleted$/ do
  pending # express the regexp above with the code you wish you had
end

###################################################################################################################################
#STEPS BELOW THIS LINE ARE TESTS BY BRANDON -- JUST DELETE THEM!

When /^I setup my test$/ do

  @course_offering = make CourseOffering, :term=> Rollover::OPEN_SOC_TERM, :course => "BSCI181ANSNS"
  @course_offering.manage

  on ManageCourseOfferings do |page|
    page.edit('B')
  end

  on ActivityOfferingMaintenance do |page|
    page.select_colocated_checkbox
    page.colocated_co_input_field.value = 'CHEM181ABCD'
    page.colocated_ao_input_field.value = 'B'
    page.click_colocated_add_button
    page.colocated_shared_max_enrollment_input_field.value = '10'
    page.submit
  end

  puts 'end of this test step'
  sleep 60
end

#STEPS ABOVE THIS LINE ARE TESTS BY BRANDON -- JUST DELETE THEM!
###################################################################################################################################