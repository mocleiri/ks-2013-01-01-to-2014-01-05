When /^I create "([2-9])" COs with an AO in each$/ do |number_of_cos_to_create|
  reference_co_to_copy = make CourseOffering
  @array_of_cos = []
  for i in 1..number_of_cos_to_create.to_i
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

  puts 'here'
  sleep 10
  #pending

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

When /^I break colocation on the first colocated AO, "(supplying new|acknowledging retained)" max-enrollment$/ do |max_enrollment_flag|
  #pending

  # MFT has these steps which map to this step:
  #   1. On Manage Course Offering page, enter code for term, and course code: CHEM131
  #   2. Click the manage button of CO131B
  #   3. On manage CO131B page, click on the edit button to edit Activity Offering: A of CHEM131B
  #   4. On edit AO page, uncheck This activity is co-located checkbox
  #   5. A dialog to confirm this action is displayed.
  #   6. On the dialog, select to confirm to leave the colocation set
  #   7. supply max-enrollment (if max-enrollment is being shared)
  #       or that max-enrollment was retained (if max-enrollment is being separately managed)
  #   8. Click Submit to submit the changes for this AO.

end

Then /^the first colocated AO is not colocated with the remaining AO\(s\)$/ do
  #pending

  # MFT has these steps which map to this step:
  #   1. Both Activity Offerings: A of CHEM131A and A of CHEM131B no longer have colocated relationship.
  #   2. Activity Offering: A of CHEM131A will have the RDLs in the colocation set which will be displayed in the edit AO: A of CHEM131A page
  #   3. Activity Offering: A of CHEM131B has no RDL left.
  #   4. to include validation of the CO-icons:
  #       the ones that stayed in the colo should still contain CO-icons (with appropriate tooltip-language);
  #       the one that broke away from the colo should no longer have a CO-icon
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


### CREATE DUMMY DATA
When /^I create some dummy test data to speed up AFT development$/ do

  #pending

  # populate an array with a bunch of COs that already exist in the DB
  @array_of_cos = []

  # 201201 ENGL211 COLOTEST-1 AO:A
  co = make CourseOffering, :term => '201201', :course => 'ENGL211COLOTEST-1'
  @array_of_cos << co

  # 201201 ENGL211 COLOTEST-2 AO:A
  co = make CourseOffering, :term => '201201', :course => 'ENGL211COLOTEST-2'
  @array_of_cos << co

  # 201201 ENGL211 COLOTEST-3 AO:A
  co = make CourseOffering, :term => '201201', :course => 'ENGL211COLOTEST-3'
  @array_of_cos << co

end