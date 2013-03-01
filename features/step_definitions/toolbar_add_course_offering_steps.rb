When /^I manage a valid course offering$/ do
  @course_offering = make CourseOffering, :term=>"201605", :course=>"ENGL206"
  @course_offering.search_by_subjectcode
end

Then /^the term is retained in the term field on the Create Course Offering page$/ do
  on CreateCourseOffering do |page|
    page.target_term.value.should == @course_offering.term
  end
end


And /^I am able to create a Course Offering with this term$/ do
  on CreateCourseOffering do |page|
    page.catalogue_course_code.set @course_offering.course
    page.show
    @course_offering.create
  end
end