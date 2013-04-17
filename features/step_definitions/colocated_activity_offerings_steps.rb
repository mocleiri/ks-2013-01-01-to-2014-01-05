When /^I create "([2-9])" COs with an AO in each$/ do |number_of_cos_to_create|
  reference_co_to_copy = make CourseOffering
  @array_of_cos = []
  for i in 1..number_of_cos_to_create.to_i
    puts "create " + i.to_s
    co = create CourseOffering, :create_by_copy=>reference_co_to_copy
    co.create_ao :ao_code => "A"
    @array_of_cos << co
  end
end

When /^I colocate multiple activities, selecting to "(share|separately manage)" enrollments$/ do |max_enrollment_flag|

  $should_enrollment_be_shared_flag = true
  if max_enrollment_flag == 'separately manage'
    $should_enrollment_be_shared_flag = false
  end

  # get a reference to the main CO where we are going to create the colo
  first_co = @array_of_cos[0]

  # get a reference to the rest of the COs (less the main CO)
  remaining_cos = []
  for i in 1..@array_of_cos.size
    remaining_cos << @array_of_cos[i]
  end

  # this is broke right now; waiting for fix from Mike W. to come in
  first_co.colocate :cos_to_colo => remaining_cos,
                    :should_enrollment_be_shared_flag => $should_enrollment_be_shared_flag,
                    :enrollment_size => 10

end

Then /^the activities indicate they are colocated$/ do

  # get a reference to the main CO where we are going to validate the colo
  first_co = @array_of_cos[0]

  # get a reference to the rest of the COs (less the main CO)
  remaining_cos = []
  for i in 1..@array_of_cos.size
    remaining_cos << @array_of_cos[i]
  end

  # this is broke right now; waiting for fix from Mike W. to come in
  first_co.manage
  on ManageCourseOfferings do |page|
    colocated_tooltip_text = page.target_row('A')[1].image.alt.upcase

    remaining_cos.each do |co|
      expected = co.course.upcase + ' ' + co.ao_list[0].upcase
      colocated_tooltip_text.should include expected
    end
  end

end

When(/^I designate a valid term and Course Offering Code with a fully colocated AO$/) do
  @course_offering = make CourseOffering, :course=>"CHEM441", :term=>"201208"
  @course_offering.manage
end

And(/^I delete the fully colcated AO$/) do
  on ManageCourseOfferings do |page|
    @course_offering.delete_ao_list :code_list =>  page.codes_list
  end
end

Then(/^The AO is successfully deleted$/) do
  @course_offering.manage
  begin
    on(ManageCourseOfferings).codes_list
  rescue RuntimeError => e
    e.message.should include "error in activity_offering_results_table - no AOs"
  end
end