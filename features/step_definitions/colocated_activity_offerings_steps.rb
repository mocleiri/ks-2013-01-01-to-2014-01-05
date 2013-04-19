When /^I create "([2-9])" COs with an AO in each$/ do |number_of_cos_to_create|
  @colo_aos = []

  for i in 1..number_of_cos_to_create.to_i
    co = create CourseOffering, :create_by_copy => (make CourseOffering, :course => "ENGL211", :term => Rollover::MAIN_TEST_TERM_TARGET)
    ao = make ActivityOffering, :code => "A", :parent_course_offering => co
    @colo_aos << ao
  end
end

When /^I colocate multiple activities, selecting to "(share|separately manage)" enrollments$/ do |max_enrollment_flag|

  should_enrollment_be_shared_flag = true
  if max_enrollment_flag == 'separately manage'
    should_enrollment_be_shared_flag = false
  end

  # colocate the first AO to all the others
  @colo_aos[0].parent_course_offering.manage
  @colo_aos[0].edit :colocate_ao_list => @colo_aos[1, @colo_aos.length],
                    :colocate_shared_enrollment => should_enrollment_be_shared_flag,
                    :max_enrollment => 48
  @colo_aos[0].save
end

Then /^the activities indicate they are colocated$/ do

  @colo_aos[0].parent_course_offering.manage
  on ManageCourseOfferings do |page|
    colocated_tooltip_text = page.target_row('A')[1].image.alt.upcase

    # validate tooltip text contains each colo
    @colo_aos[1, @colo_aos.length].each do |other_ao|
      expected = other_ao.parent_course_offering.course.upcase + ' ' + other_ao.code.upcase
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

Then /^the first colocated AO is not colocated with any remaining AOs$/ do
  #pending

  # MFT has these steps which map to this step:
  #   1. Both Activity Offerings: A of CHEM131A and A of CHEM131B no longer have colocated relationship.
  #   2. Activity Offering: A of CHEM131A will have the RDLs in the colocation set which will be displayed in the edit AO: A of CHEM131A page
  #   3. Activity Offering: A of CHEM131B has no RDL left.
  #   4. to include validation of the CO-icons:
  #       the ones that stayed in the colo should still contain CO-icons (with appropriate tooltip-language);
  #       the one that broke away from the colo should no longer have a CO-icon
end

When /^I designate a valid term and Course Offering Code with a fully colocated AO$/ do
  co = create CourseOffering, :create_by_copy => (make CourseOffering, :course => "CHEM441", :term => "201208")
  @activity_offering = make ActivityOffering, :code => "A", :parent_course_offering => co
end

And /^I delete the fully colcated AO$/ do
  @activity_offering.parent_course_offering.manage
  on ManageCourseOfferings do |page|
    @activity_offering.parent_course_offering.delete_ao_list :code_list =>  page.codes_list
  end
end

Then /^The AO is successfully deleted$/ do
  @activity_offering.parent_course_offering.manage
  begin
    on(ManageCourseOfferings).codes_list # this line is broken
  rescue RuntimeError => e
    e.message.should include "error in activity_offering_results_table - no AOs"
  end
end


### CREATE DUMMY DATA
### This data should already exist in the DB, with an AO 'A' in each CO,
### and with the first CO's AO colocated to the other 2
When /^I create some dummy test data to speed up AFT development$/ do

  # populate an array with a bunch of COs that already exist in the DB
  @colo_aos = []

  # 201301 ENGL211G AO:A
  co = make CourseOffering, :term => '201301', :course => 'ENGL211G'
  ao = make ActivityOffering, :code => "A", :parent_course_offering => co
  @colo_aos << ao

  # 201301 ENGL211H AO:A
  co = make CourseOffering, :term => '201301', :course => 'ENGL211H'
  ao = make ActivityOffering, :code => "A", :parent_course_offering => co
  @colo_aos << ao

  # 201301 ENGL211I AO:A
  co = make CourseOffering, :term => '201301', :course => 'ENGL211I'
  ao = make ActivityOffering, :code => "A", :parent_course_offering => co
  @colo_aos << ao

end


