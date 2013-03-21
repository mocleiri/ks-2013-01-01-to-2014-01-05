When /^I create a Course Offering with Draft Activity Offerings$/ do
  #setup
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering)
  on ManageCourseOfferings do |page|
    page.target_row(@course_offering.course).link(text: "Manage").click
    page.ao_status("A", "Draft").should == true
  end
end

And /^I cancel the deletion of a Course Offering in Course Offering Code view$/ do

  @course_offering.search_by_subjectcode
  @course_offering.delete_co :code_list => [@course_offering.course], :should_confirm_delete=>false
end

And /^the Course Offering is not deleted$/ do
  #verify CO still exists
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.error_message_course_not_found.should_not be_present
  end
end

And /^I delete this Course Offering$/ do
  @course_offering.search_by_subjectcode
  #delete
  @course_offering.delete_co :code_list => [@course_offering.course], :should_confirm_delete=>true
end



And /^I cancel the deletion of a Course Offering in Subject Code view$/ do
  @course_offering.manage
  @course_offering.delete_co_with_link :should_confirm_delete=>false
end

And /^I delete this Course Offering in Subject Code view$/ do
  #setup
  @course_offering.manage
  #delete
  @course_offering.delete_co_with_link :should_confirm_delete=>true
end

Then /^the deleted course offering does not appear on the list of available Course Offerings$/ do
  #verify CO does not exist
  #verify CO still exists
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.error_message_course_not_found.should be_present
  end
end


When /^I create multiple Course Offerings with Draft Activity Offerings$/ do
  ['ENGL250','ENGL222','ENGL211'].each do |course_code|
    instance_variable_set("@course_offering_#{course_code}", (create CourseOffering, :create_by_copy=>(make CourseOffering, :course=> course_code)))
  end

  @co_code_list = [@course_offering_ENGL250.course, @course_offering_ENGL222.course, @course_offering_ENGL211.course]
end

And /^I cancel the deletion of the Course Offerings in Course Offering Code view$/ do
  @course_offering_ENGL250.search_by_subjectcode
  @course_offering_ENGL250.delete_co :code_list => @co_code_list, :should_confirm_delete=>false
end

And /^the Course Offerings are not deleted$/ do
  @co_code_list.each { |co_code| @course_offering_ENGL250.total_co_list('ENGL2').should include co_code }
end

And /^I delete these Course Offerings$/ do
  @course_offering_ENGL250.search_by_subjectcode
  @course_offering_ENGL250.delete_co :code_list => @co_code_list, :should_confirm_delete=>true
end


Then /^the deleted course offerings do not appear on the list of available Course Offerings$/ do
  @co_code_list.each { |co_code| @course_offering_ENGL250.total_co_list('ENGL2').should_not include co_code }
end