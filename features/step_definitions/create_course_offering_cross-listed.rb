When /^I designate a valid term and cross-listed Catalog Course Code$/ do
  @suffix_with_cl = "AFT#{random_alphanums(2)}".upcase
  @suffix_without_cl = "NOCL"
  @source_term = "201201"
  @cross_listed_co_code = "WMST255"
  @catalogue_course_code = "ENGL250"
  #TODO - need to use appropriate course_offering 'create' method
  @course_offering = make CourseOffering, :course => @catalogue_course_code, :suffix => @suffix_with_cl, :delivery_format => "Lecture"
  @course_offering.start_create_by_search
end

And /^I create a Course Offering with selected cross-listed Catalog Course Code$/ do
  on CreateCourseOffering do  |page|
    page.suffix.set @suffix_with_cl
    @course = "#{@catalogue_course_code}#{@suffix_with_cl}"
    delivery_obj = make DeliveryFormat, :format=>"Lecture", :grade_format => "Course", :final_exam_driver => "Lecture"
    delivery_obj.select_random_delivery_formats
    page.cross_listed_co_check_box.click
    page.create_offering
  end
end

And /^the cross-listing is indicated for the (owner|alias) Course Offering$/ do |cluType|

  # build the appropriate CLU data-object (either owner or alias)
  @course_offering = make CourseOffering, :term => @source_term, :suffix => @suffix_with_cl
  if cluType == 'alias'
    @course_offering.course = @cross_listed_co_code
    @cross_listed_infoText_targetValue = @catalogue_course_code + @suffix_with_cl + " (Owner)"
  else #owner
    @course_offering.course = @catalogue_course_code
    @cross_listed_infoText_targetValue = @cross_listed_co_code + @suffix_with_cl
  end

  # navigate to the CLU-view
  @course_offering.go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set @course_offering.term
    page.input_code.set "#{@course_offering.course}#{@course_offering.suffix}"
    page.show
  end

  # validate cross-listing info-text (ie: "Crosslisted as: WMST255AUTO")
  on(ManageCourseOfferings).cross_listed_as_text.should == 'Crosslisted as: ' << @cross_listed_infoText_targetValue

end

And /^the copy-link is not showing for the alias$/ do

  @course_offering = make CourseOffering, :term=>@source_term, :course=>@cross_listed_co_code, :search_by_subj=>true
  @course_offering.search_by_subjectcode
  on(ManageCourseOfferings).copy_link(@course_offering.course).should_not be_present

end

And /^I create a Course Offering without selected cross-listed Catalog Course Code$/ do
  on CreateCourseOffering do  |page|
    page.suffix.set @suffix_without_cl
    @course = "#{@catalogue_course_code}#{@suffix_without_cl}"
    delivery_obj = make DeliveryFormat, :format=>"Lecture", :grade_format => "Course", :final_exam_driver => "Lecture"
    delivery_obj.select_random_delivery_formats
#    page.cross_listed_co_check_box.click  do not select the cross-listed CO
    page.create_offering
  end

end


Then /^the alias course does not exist$/ do
  @course_offering = make CourseOffering
  @course_offering.term=@source_term
  @course_offering.course=@course
  @course_offering.suffix=@suffix_without_cl
  @course_offering.manage

  expect_result = "Crosslisted as:"
  course_details = @course_offering.cross_listed_co_data(@course)
  cross_listed_in_page = course_details.include? expect_result
  cross_listed_in_page.should == false

end


And /^no cross-listing is indicated for the (.*?) course$/ do |cross_listed_as_owner|
  @course_offering = make CourseOffering
  @course_offering.term=@source_term
  @course_offering.course=@cross_listed_co_code
  @course_offering.suffix=""
  @course_offering.manage

  expect_result = @course
  course_details = @course_offering.cross_listed_co_data(@cross_listed_co_code)
  cross_listed_in_page = course_details.include? expect_result
  cross_listed_in_page.should == false

end
