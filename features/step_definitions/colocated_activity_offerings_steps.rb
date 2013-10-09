When /^there is a course offering with a colocated activity offering$/ do
  @course_offering = make CourseOffering, :term => "201208", :course => "CHEM441"
  @course_offering.manage

  @activity_offering = make ActivityOffering, :code => "A", :parent_course_offering => @course_offering
  colocated_ao_parent = make CourseOffering, :course => "CHEM641", :term => "201208"
  colocated_ao = make ActivityOffering, :code => "A", :parent_course_offering => colocated_ao_parent
  @activity_offering.colocate_ao_list << colocated_ao
  on(ManageCourseOfferings).has_colo_icon(@activity_offering.code).should be_true
end

When /^I create "([2-9])" COs with an AO in each$/ do |number_of_cos_to_create|
  @colo_aos = []

  for i in 1..number_of_cos_to_create.to_i
    co = create CourseOffering, :create_by_copy => (make CourseOffering, :course => "ENGL255", :term => Rollover::MAIN_TEST_TERM_TARGET)
    ao = make ActivityOffering, :code => "A", :parent_course_offering => co
    @colo_aos << ao
  end
end

When /^I create three Course Offerings with colocated AOs in the new term$/ do
  @colo_aos = []

  for i in 1..3
    delivery_format_list = []
    delivery_format_list << (make DeliveryFormat, :format => "Lecture", :grade_format => "Course Offering", :final_exam_driver => "Lecture", :final_exam_activity => "Lecture")
    co = create CourseOffering, :course => "ENGL211", :term => @term.term_code, :delivery_format_list => delivery_format_list

    ao = create ActivityOffering, :parent_course_offering => co, :format => "Lecture Only", :activity_type => "Lecture"
    ao.save
    @colo_aos << ao
  end

  # colocate the first AO to all the others
  @colo_aos[0].parent_course_offering.manage
  @colo_aos[0].edit :colocate_ao_list => @colo_aos[1, @colo_aos.length],
                    :colocate_shared_enrollment => true,
                    :max_enrollment => 48
  @colo_aos[0].save
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
    colocated_tooltip_text = page.target_row('A')[1].image(src: /colocate_icon/).alt.upcase

    # validate tooltip text contains each colo
    @colo_aos[1, @colo_aos.length].each do |other_ao|
      expected = other_ao.parent_course_offering.course.upcase + ' ' + other_ao.code.upcase
      colocated_tooltip_text.should include expected
    end
  end

end

When /^I break colocation on the first colocated AO$/ do
  @colo_aos[0].parent_course_offering.manage
  @colo_aos[0].edit :break_colocation => true
  @colo_aos[0].save
end

Then /^the first colocated AO is not colocated with any remaining AOs$/ do

  # first AO should no indicate colocation
  @colo_aos[0].parent_course_offering.manage
  on ManageCourseOfferings do |page|
    page.target_row('A')[1].image.should_not be_present

    # validate should also include ensuring there are no DLs
  end

  # second AO should indicate colocation with all the remaining
  @colo_aos[1].parent_course_offering.manage
  on ManageCourseOfferings do |page|
    colocated_tooltip_text = page.target_row('A')[1].image(src: /colocate_icon/).alt.upcase

    # validate tooltip text contains each colo
    @colo_aos[2, @colo_aos.length].each do |other_ao|
      expected = other_ao.parent_course_offering.course.upcase + ' ' + other_ao.code.upcase
      colocated_tooltip_text.should include expected

      #validation should also include ensuring DLs still exist
    end
  end
end

When /^I designate a valid term and Course Offering Code with a fully colocated AO$/ do
  co = create CourseOffering, :create_by_copy => (make CourseOffering, :course => "CHEM441", :term => "201208")
  @activity_offering = make ActivityOffering, :code => "A", :parent_course_offering => co
end

And /^I delete the fully colocated AO$/ do
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

Then /^the activity offering in the course offering copy is added to the colocated set$/ do
  @course_offering_copy.manage

  on ManageCourseOfferings do |page|
    page.has_colo_icon(@activity_offering.code).should be_true

    colocated_tooltip_text = page.target_row(@activity_offering.code)[1].image(src: /colocate_icon/).alt.upcase

    # validate tooltip text contains each colo
    expected = @activity_offering.parent_course_offering.course.upcase + ' ' + @activity_offering.code.upcase
    colocated_tooltip_text.should include expected

    @activity_offering.colocate_ao_list.each do |colo_ao|
      expected = @activity_offering.parent_course_offering.course.upcase + ' ' + @activity_offering.code.upcase
      colocated_tooltip_text.should include expected
    end
    end

  end

Then /^the activity offering in the course offering copy is not colocated$/ do
  @course_offering_copy.manage
  on(ManageCourseOfferings).has_colo_icon(@activity_offering.code).should be_false
end

When /^I copy a colocated activity offering$/ do
  @activity_offering_copy = create ActivityOffering, :create_by_copy => true,
                                   :code => @colo_aos[0].code,
                                   :parent_course_offering => @colo_aos[0].parent_course_offering
end

Then /^the activity offering copy is added to the colocated set$/ do
  @activity_offering_copy.parent_course_offering.manage
  on ManageCourseOfferings do |page|
    page.has_colo_icon(@activity_offering_copy.code).should be_true

    colocated_tooltip_text = page.target_row(@activity_offering_copy.code)[1].image(src: /colocate_icon/).alt.upcase

    # validate tooltip text contains each colo
    @colo_aos.each do |other_ao|
      expected = other_ao.parent_course_offering.course.upcase + ' ' + other_ao.code.upcase
      colocated_tooltip_text.should include expected

    end
  end
end


### CREATE DUMMY DATA
### This data should already exist in the DB, with an AO 'A' in each CO,
### and with the first CO's AO colocated to the other 2
When /^I create some dummy test data to speed up AFT development$/ do

  # populate an array with a bunch of COs that already exist in the DB
  @colo_aos = []

  # 201301 ENGL211G AO:A
  co = make CourseOffering, :term => '201301', :course => 'ENGL211Q'
  ao = make ActivityOffering, :code => "A", :parent_course_offering => co
  @colo_aos << ao

  # 201301 ENGL211H AO:A
  co = make CourseOffering, :term => '201301', :course => 'ENGL211R'
  ao = make ActivityOffering, :code => "A", :parent_course_offering => co
  @colo_aos << ao

  # 201301 ENGL211I AO:A
  co = make CourseOffering, :term => '201301', :course => 'ENGL211S'
  ao = make ActivityOffering, :code => "A", :parent_course_offering => co
  @colo_aos << ao

end

Then /^the Activity Offerings are colocated in the rollover target$/ do
  @colo_aos_rollover = []

  for i in 0..2
    co = make CourseOffering, :course =>  @colo_aos[i].parent_course_offering.course,
              :term => @term_target.term_code
    ao = make ActivityOffering, :code => "A", :parent_course_offering => co
    @colo_aos_rollover << ao
  end

  @colo_aos_rollover[0].parent_course_offering.manage
  on ManageCourseOfferings do |page|
    colocated_tooltip_text = page.target_row('A')[1].image(src: /colocate_icon/).alt.upcase

    # validate tooltip text contains each colo
    @colo_aos_rollover[1, @colo_aos_rollover.length].each do |other_ao|
      expected = other_ao.parent_course_offering.course.upcase + ' ' + other_ao.code.upcase
      colocated_tooltip_text.should include expected
    end
  end

end



