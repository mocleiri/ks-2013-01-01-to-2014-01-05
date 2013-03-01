Given /^I manage a single course offering$/ do
  @course_offering = make CourseOffering, :term=>"201605", :course=>"ENGL206"
  @course_offering.search_by_coursecode
end

When /^I click the "(.*?)" toolbar button$/ do |button|
  on(ManageCourseOfferings).click_toolbar_button(button)
end

Then /^the Activity Offering is in "(.*?)" state$/ do |state|
  on(ManageCourseOfferings).check_aos_status state, @new_ao_list
end

Then /^the Activity Offerings are in "(.*?)" state$/ do |state|
  on(ManageCourseOfferings).check_aos_status state, @new_ao_list
end

And /^the Course Offering is in Planned state$/ do
  @course_offering.search_by_subjectcode
  on ManageCourseOfferings do |page|
    page.ao_status(@course_offering.course, "Approved").should == false
  end
end

