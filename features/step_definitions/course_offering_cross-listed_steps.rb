# note: this test has been code-reviewed here: https://fisheye.kuali.org/cru/ks-370
# additional notes about future-refactoring were left in this jira: https://jira.kuali.org/browse/KSENROLL-5895

When /^I designate a valid term and cross-listed Catalog Course Code$/ do
  @suffix_with_cl = "AFT#{random_alphanums(2)}".upcase
  @suffix_without_cl = "NOCL"
  @source_term = "201201"
  @cross_listed_co_code = "WMST255"
  @catalogue_course_code = "ENGL250"
  #TODO - need to use appropriate course_offering 'create' method
  @course_offering = make CourseOffering, :course => @catalogue_course_code, :suffix => @suffix_with_cl, :term => @source_term, :delivery_format => "Lecture"
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

When /^OLD I create a cross-listed Course Offering OLD$/ do
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

And /^OLD I delete the alias Course Offering OLD$/ do
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

Then /^the edit confirmation view (should|should not) indicate that a cross-listing exists$/ do |isCrosslisted|

  on CourseOfferingEdit do |page|
    if( isCrosslisted == 'should not')
      page.cross_listed_as_label.should_not be_present
    else
      page.cross_listed_as_label.should be_present
    end
  end

end


When /^I create a cross-listed Course Offering$/ do
  @cross_listed_co = create CourseOffering, :create_by_copy => (make CourseOffering, :course => "ENGL250", :term => Rollover::MAIN_TEST_TERM_SOURCE)
  @cross_listed_co.capture_crosslist_aliases
end


And /^I delete the alias Course Offering$/ do
  cross_listed_co_alias = make CourseOffering, :course => @cross_listed_co.cross_listed_codes[0],
                               :term => @cross_listed_co.term
  cross_listed_co_alias.manage
  cross_listed_co_alias.delete_co_with_link :code_list => [cross_listed_co_alias.course],
                                            :should_confirm_delete => true
end

Then /^the owner Course Offering and all it's aliases are deleted$/ do
  @cross_listed_co.manage
  on(ManageCourseOfferings).error_message_course_not_found.should be_present

  @cross_listed_co.cross_listed_codes.each do |code|
    cross_listed_co_alias = make CourseOffering, :course => code,
                                 :term => @cross_listed_co.term
    cross_listed_co_alias.manage
    on(ManageCourseOfferings).error_message_course_not_found.should be_present
  end

end


### CREATE DUMMY DATA
### This data should already exist in the DB, having been put in there manually
When /^I create some dummy test data to speed up AFT development for deleting crosslistings$/ do

  @cross_listed_co = make CourseOffering, :course => "ENGL250D", :term => Rollover::MAIN_TEST_TERM_SOURCE
  @cross_listed_co.cross_listed_codes = ["WMST255D"]

end
