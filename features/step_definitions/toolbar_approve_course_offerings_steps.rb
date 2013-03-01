And /^term contains COs in Draft state$/ do
  @course_offering = make CourseOffering, :term=>"201805", :course=>"ENGL206"
  @course_offering.search_by_subjectcode

  on ManageCourseOfferings do |page|
    page.ao_status("ENGL206", "Draft").should == true
    page.ao_status("ENGL222", "Draft").should == true
    page.ao_status("ENGL301", "Draft").should == true
  end
end

When /^I select a course offering containing at least one activity in Draft state$/ do
  on(ManageCourseOfferings).select_aos [@course_offering.course]
 end

And /^I cancel the action$/ do
  on ManageCourseOfferings do |page|
    page.approve_co_cancel
  end
end

Then /^the list of courses remains unchanged$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@course_offering.course, "Draft").should == true
  end
end

And /^Draft activity offerings remain in Draft state$/ do
  @course_offering.search_by_coursecode
  on ManageCourseOfferings do |page|
    page.ao_status("A", "Draft").should == true
  end
end

And /^I confirm the operation$/ do
  on ManageCourseOfferings do |page|
    page.approve_co_confirm
  end
end

Then /^the course offering is in Planned state$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@course_offering.course, "Planned").should == true
  end
 end

And /^its activity offerings are in Approved state$/ do
  @course_offering.search_by_coursecode
  on ManageCourseOfferings do |page|
    page.check_all_ao_status("Approved").should == true
  end
 end

When /^I select multiple course offerings each containing at least one activity in Draft state$/ do
  @course_offering_a = make CourseOffering, :term=>@course_offering.term, :course=>"ENGL222"
  @course_offering_b = make CourseOffering, :term=>@course_offering.term, :course=>"ENGL301"
  on(ManageCourseOfferings).select_aos [@course_offering_a.course, @course_offering_b.course]
end

Then /^the selected course offerings are in Planned state$/ do
  on ManageCourseOfferings do |page|
    page.ao_status(@course_offering_a.course, "Planned").should == true
    page.ao_status(@course_offering_b.course, "Planned").should == true
  end
end

And /^their activity offerings are in Approved state$/ do
  @course_offering_a.search_by_coursecode
  on ManageCourseOfferings do |page|
    page.check_all_ao_status("Approved").should == true
  end

  @course_offering_b.search_by_coursecode
  on ManageCourseOfferings do |page|
    page.check_all_ao_status("Approved").should == true
  end
end