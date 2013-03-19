When /^I create a cross-listed Course Offering$/ do
  @suffix_with_cl = "AFT#{random_alphanums(2)}".upcase
  @suffix_without_cl = "NOCL"
  @source_term = "201201"
  @cross_listed_co_code = "WMST255"
  @catalogue_course_code = "ENGL250"
  #TODO - need to use appropriate course_offering 'create' method
  @course_offering = make CourseOffering, :course => @catalogue_course_code, :suffix => @suffix_with_cl, :delivery_format => "Lecture"
  @course_offering.start_create_by_search
  on CreateCourseOffering do  |page|
    page.suffix.set @suffix_with_cl
    @course = "#{@catalogue_course_code}#{@suffix_with_cl}"
    delivery_obj = make DeliveryFormat, :format=>"Lecture", :grade_format => "Course", :final_exam_driver => "Lecture"
    delivery_obj.select_random_delivery_formats
    page.cross_listed_co_check_box.click
    page.create_offering
  end

end

When /^I create a Course Offering$/ do
  @suffix_with_cl = "AFT#{random_alphanums(2)}".upcase
  @suffix_without_cl = "NOCL"
  @source_term = "201201"
  @catalogue_course_code = "ENGL250"
  @cross_listed_co_code = "WMST255"
  #TODO - need to use appropriate course_offering 'create' method
  @course_offering = make CourseOffering, :course => @catalogue_course_code, :suffix => @suffix_with_cl, :delivery_format => "Lecture"
  @course_offering.start_create_by_search
  on CreateCourseOffering do  |page|
    page.suffix.set @suffix_with_cl
    @course = "#{@catalogue_course_code}#{@suffix_with_cl}"
    delivery_obj = make DeliveryFormat, :format=>"Lecture", :grade_format => "Course", :final_exam_driver => "Lecture"
    delivery_obj.select_random_delivery_formats
    page.create_offering
  end
end


And /^I edit the course offering to add alias$/ do
  @course_offering = make CourseOffering
  @course_offering.term=@source_term
  @course_offering.course="#{@catalogue_course_code}#{@suffix_with_cl}"
  @course_offering.search_by_subj=false
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.cross_listed_co_check_box.click
    page.submit
  end
end

And /^I delete the alias Course Offering$/ do
  @course = make CourseOffering

  @course_offering.go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set @source_term
    page.input_code.set "#{@cross_listed_co_code}#{@suffix_with_cl}"
    page.show
    page.delete_course_offering
  end

  on DeleteCourseOffering do |page|
    page.confirm_delete
  end

end

Then /^the deleted alias does not appear on the list of available Course Offerings$/ do

  @course_offering.go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set @source_term
    page.input_code.set "#{@cross_listed_co_code}#{@suffix_with_cl}"
    page.show

  end

end

And /^I remove a cross-listed Course Offering$/ do
  @course_offering = make CourseOffering
  @course_offering.term=@source_term
  @course_offering.course="#{@catalogue_course_code}#{@suffix_with_cl}"
  @course_offering.search_by_subj=false
  @course_offering.manage
  on ManageCourseOfferings do |page|
      page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.cross_listed_co_check_box.click
    page.submit
  end
end


And /^I manage the (owner|alias) Course Offering$/ do |cluType|

  if cluType == 'alias'
    @input_code_value = "#{@cross_listed_co_code}"
  else
    @input_code_value = "#{@catalogue_course_code}"
  end
  @input_code_value << "#{@suffix_with_cl}"

  @course_offering.go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set @source_term
    page.input_code.set @input_code_value
    page.show
  end

end

Then /^the 'course not found' message is displayed$/ do
  on ManageCourseOfferings do |page|
    page.error_message_course_not_found.should be_present
  end
end

Then /^the alias Course Offering does not exist$/ do
  on ManageCourseOfferings do |page|
    page.error_message_course_not_found.should be_present
  end
end

Then /^the owner course offering is not indicated as cross-listed with the alias CO$/ do
  @course_offering = make CourseOffering
  @course_offering.term=@source_term
  @course_offering.course="#{@catalogue_course_code}#{@suffix_with_cl}"
  @course_offering.search_by_subj=false
  @course_offering.manage

  expect_result = ""
  course_details = @course_offering.cross_listed_co_data(@course)
  cross_listed_in_page = course_details.include? expect_result
  cross_listed_in_page.should == true
end


Then /^the alias is indicated as cross-listed with the owner CO$/ do
  expect_result = "Crosslisted as: #{@catalogue_course_code}#{@suffix_with_cl} (Owner)"

  @course_offering.go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set @source_term
    page.input_code.set "#{@cross_listed_co_code}#{@suffix_with_cl}"
    page.show

    page.cross_listed_as_text.should == expect_result
    page.has_cross_listed_message("#{@catalogue_course_code}#{@suffix_with_cl} (Owner)").should == true
  end

end

Then /^the owner course offering is indicated as cross-listed with the alias CO$/ do

  expect_result = "Crosslisted as: #{@cross_listed_co_code}#{@suffix_with_cl}"

  @course_offering.go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set @source_term
    page.input_code.set "#{@catalogue_course_code}#{@suffix_with_cl}"
    page.show

    page.cross_listed_as_text.should == expect_result
    page.cross_listed_message_div.should_not be_present
  end
end