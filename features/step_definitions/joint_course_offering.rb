When /^I create joint Course Offerings$/ do

  # we need to update this once Mike commits his refactor later today
  @course_offering = create CourseOffering, :term => "201201", :course => "BSCI181", :delivery_format => "Lecture", :grade_format => "Lecture"
  @course_offering.create_ao :ao_code => "A"
  puts @course_offering.course + ' created'
end

And /^I can add activity offerings to the joint Course Offerings$/ do

  # first we build an ao, then we link it the co -- Mikes commit today will change this so wait and see
  #@activity_offering = create ActivityOffering
  #@activity_offering.save
  @course_offering.create_ao :ao_code => "A"
end

#REFACTOR THIS STEP NAME TO SOMETHING BETTER
Then /^we can see the aos in the co we made$/ do


  @course_offering.manage

  puts 'Im here'
  sleep 60

  #validate the CO had the AO

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