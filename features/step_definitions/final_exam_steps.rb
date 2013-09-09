When /^I change the final exam start date to be before the term start date and save$/ do
  @term = make AcademicTerm, :term_name => "Fall", :term_year => "2012"
  @term.change_exam_start_date "08/15/2012"
end

When /^I change the final exam end date to be after the term end date and save$/ do
  @term = make AcademicTerm, :term_name => "Fall", :term_year => "2012"
  @term.change_exam_end_date "12/20/2012"
end

When /^I add a final exam period within the dates of the fall term of the new academic calender and save$/ do
  @calendar = make AcademicCalendar
  @calendar.create

  @term = make AcademicTerm, :term_year => @calendar.year, :start_date=>"08/20/#{@calendar.year}", :end_date=>"12/10/#{@calendar.year}"
  @calendar.add_term @term

  @term.create_final_exam_period
end

When /^I copy a newly created academic calender that has a defined final exam period$/ do
  @source_calendar = make AcademicCalendar
  @source_calendar.create

  @term = make AcademicTerm, :term_year => @source_calendar.year, :start_date=>"09/20/#{@source_calendar.year}",
                             :end_date=>"12/10/#{@source_calendar.year}"
  @source_calendar.add_term @term

  @term.create_final_exam_period

  @calendar = make AcademicCalendar, :year => "#{@source_calendar.year.to_i + 1}"
  @calendar.copy_from @source_calendar.name
end

When /^I copy an existing academic calender that has a defined final exam period$/ do
  @source_calendar = make AcademicCalendar, :name => "2012-2013 Academic Calendar"

  @term = make AcademicTerm

  @calendar = make AcademicCalendar
  @calendar.copy_from @source_calendar.name
end

When /^I create a Course Offering from catalog with a final exam period$/ do
  @course_offering = make CourseOffering, :term => "201301", :course => "PHYS603"

  @course_offering.start_create_by_search
  on CreateCourseOffering do  |page|
    page.continue
  end

  on CreateCOFromCatalog do |page|
    @course_offering.suffix = random_alphanums(5).upcase if @course_offering.suffix == ""
    page.suffix.set @course_offering.suffix
    @course_offering.course = "#{@course_offering.course}#{@course_offering.suffix}"
  end
end

When /^I create and then edit a Course Offering from catalog with a final exam period$/ do
  @course_offering = make CourseOffering, :term => "201301", :course => "PHYS603"

  @course_offering.start_create_by_search
  on CreateCourseOffering do  |page|
    page.continue
  end

  on CreateCOFromCatalog do |page|
    @course_offering.suffix = random_alphanums(5).upcase if @course_offering.suffix == ""
    page.suffix.set @course_offering.suffix
    @course_offering.course = "#{@course_offering.course}#{@course_offering.suffix}"
    page.final_exam_option_alternate
    page.create_offering
  end

  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

Then /^a warning in the Final Exam section is displayed stating "([^"]*)"$/ do |exp_msg|
  on EditAcademicTerms do |page|
    page.get_exam_warning_message( @term.term_type).should match /#{exp_msg}/
  end
end

Then /^no warning in the Final Exam section is displayed$/ do
  on(EditAcademicTerms).exam_warning_message( @term.term_type).present?.should be_false
end

Then /^the final exam for the Fall Term is listed when I view the Academic Calendar$/ do
  @calendar.search

  on CalendarSearch do |page|
    page.view @calendar.name
  end

  on ViewAcademicTerms do |page|
    page.go_to_terms_tab
    page.open_term_section(@term.term_type)
    #TODO: Need to add IDs to html elements to be sure correct element is matched with the assertion below
    page.final_exam_section.text.should match /#{@term.start_date}/
    page.final_exam_section.text.should match /#{@term.end_date}/
  end
end

Then /^the exam start and end dates should be blank$/ do
  on EditAcademicTerms do |page|
    page.get_exam_start_date( @term.term_type).should == ""
    page.get_exam_end_date( @term.term_type).should == ""
  end
end

Then /^there should be no final exam period$/ do
  on EditAcademicTerms do |page|
    page.final_exam_section( @term.term_type).text.should match /Final Exam Period\nAdd Final Exam Period/
  end
end

Then /^the Final Exam Driver Activity value should change each time I choose another type of Final Exam$/ do
  on CreateCOFromCatalog do |page|
    page.final_exam_option_standard
    page.final_exam_driver_value.should == ""
    page.final_exam_option_alternate
    page.final_exam_driver_value.should == "Alternate exam for this offering"
    page.final_exam_option_none
    page.final_exam_driver_value.should == "No final exam for this offering"
    page.create_offering
  end
end

Then /^a warning about the FE on the Edit CO page is displayed stating "([^"]*)"$/ do |exp_msg|
  on CourseOfferingEdit do |page|
    page.delivery_assessment_warning.should match /#{exp_msg}/
  end
end