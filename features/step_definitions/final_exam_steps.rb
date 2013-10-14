When /^I change the final exam start date to be before the term start date and save$/ do
  @term = make AcademicTerm, :term_name => "Fall", :term_year => "2012"
  @term.change_exam_start_date "08/15/2012"
end

When /^I change the final exam end date to be after the term end date and save$/ do
  @term = make AcademicTerm, :term_name => "Fall", :term_year => "2012"
  @term.change_exam_end_date "12/20/2012"
end

When /^I add a final exam period within the dates of the fall term of the new academic calender and save$/ do
  @calendar = create AcademicCalendar

  @term = make AcademicTerm, :term_year => @calendar.year, :start_date=>"08/20/#{@calendar.year}",
               :end_date=>"12/10/#{@calendar.year}", :term_type => "Fall Term", :term_name => "Fall"
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
  @course_offering = create CourseOffering, :term => "201301", :course => "PHYS603", :defer_save => true
end

When /^I create and then edit a Course Offering from catalog with an alternate final exam period$/ do
  @course_offering = create CourseOffering, :term => "201301", :course => "PHYS603", :final_exam_type => "ALTERNATE"

  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I create a Course Offering from an existing course offering with no final exam period$/ do
  @course_offering = create CourseOffering, :term => "201301", :course => "CHEM277",
                          :final_exam_type => "NONE"

  @course_offering_copy = create CourseOffering, :term=> @course_offering.term , :create_from_existing => @course_offering
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I create a course offering for a subject with a standard final exam in my admin org$/ do
  @course_offering = make CourseOffering, :term=> "201301", :course => "ENGL304"
  @course_offering.start_create_by_search
end

When /^I edit a course offering with a standard final exm in my admin org$/ do
  @course_offering = make CourseOffering, :term=> "201301", :course=>"ENGL304"
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I create an Academic Calender and add an official term$/ do
  @calendar = create AcademicCalendar
  @term = make AcademicTerm, :term_year => @calendar.year
  @calendar.add_term(@term)
  @term.make_official
  @manage_soc = make ManageSoc, :term_code => @term.term_code
  @manage_soc.set_up_soc
end

When /^I create an Academic Calender and add an official Winter and Summer term that each has an exam period$/ do
  @calendar = create AcademicCalendar
  @calendar.make_official
  @term_winter = make AcademicTerm, :term_year => "#{@calendar.year.to_i + 1}", #:term_name => "Winter",
                      :term_code => "#{@calendar.year.to_i + 1}00", :start_date=>"01/01/#{@calendar.year.to_i + 1}",
                      :end_date=>"01/21/#{@calendar.year.to_i + 1}", :term_type=>"Winter Term"
  @term_summer = make AcademicTerm, :term_year => "#{@calendar.year.to_i + 1}", #:term_name => "Summer",
                      :term_code => "#{@calendar.year.to_i + 1}05", :start_date=>"03/10/#{@calendar.year.to_i + 1}",
                      :end_date=>"06/20/#{@calendar.year.to_i + 1}", :term_type=>"Summer 1"

  @calendar.add_term(@term_winter)
  @calendar.add_term(@term_summer)

  @term_winter.make_official
  @term_summer.make_official

  @manage_soc_winter = make ManageSoc, :term_code => @term_winter.term_code
  @manage_soc_winter.set_up_soc
  @manage_soc_winter.perform_manual_soc_state_change("open")

  @manage_soc_summer = make ManageSoc, :term_code => @term_summer.term_code
  @manage_soc_summer.set_up_soc
  @manage_soc_summer.perform_manual_soc_state_change("open")
end

When /^I publish the Winter term$/ do
  @manage_soc_winter.search
  @manage_soc_winter.change_action "Lock"
  on(ManageSocPage).go_action
  @manage_soc_winter.change_action "Schedule"
  on(ManageSocPage).go_action
  @manage_soc_winter.change_action "FinalEdit"
  on(ManageSocPage).go_action
  @manage_soc_winter.change_action "Publish"
end

When /^I publish both terms in the Academic Calendar$/ do
  @manage_soc_winter.search
  @manage_soc_winter.change_action "Lock"
  on(ManageSocPage).go_action
  @manage_soc_winter.change_action "Schedule"
  on(ManageSocPage).go_action
  @manage_soc_winter.change_action "FinalEdit"
  on(ManageSocPage).go_action
  @manage_soc_winter.change_action "Publish"

  @manage_soc_summer.search
  @manage_soc_summer.change_action "Lock"
  on(ManageSocPage).go_action
  @manage_soc_summer.change_action "Schedule"
  on(ManageSocPage).go_action
  @manage_soc_summer.change_action "FinalEdit"
  on(ManageSocPage).go_action
  @manage_soc_summer.change_action "Publish"
end

When /^I create multiple Course Offerings each with a different Exam Offering in the new term$/ do
  @co_one = create CourseOffering, :term => @term.term_code, :course => "PHYS603",
                   :final_exam_type => "NONE"
  @co_two = create CourseOffering, :term => @term.term_code, :course => "PHYS603",
                   :final_exam_type => "ALTERNATE"
  @co_three = create CourseOffering, :term => @term.term_code, :course => "PHYS603",
                     :final_exam_driver => "Final Exam Per Activity Offering"

  delivery_format_list = []
  delivery_format_list << (make DeliveryFormat, :format => "Lecture", :grade_format => "Course Offering",
                                :final_exam_driver => "Course Offering")
  @co_four = create CourseOffering, :term => @term.term_code, :course => "PHYS603", @use_final_exam_matrix => false,
                    :delivery_format_list => delivery_format_list
end

When /^I create multiple Course Offerings each with a different Exam Driver in the new term$/ do
  @co_one = create CourseOffering, :term => @term.term_code, :course => "BSCI215"
  for i in 1..5
    @ao_one = @co_one.create_ao(make ActivityOffering, :format => "Lecture Only")
  end

  @co_two = create CourseOffering, :term => @term.term_code, :course => "ENGL301",
                     :final_exam_driver => "Final Exam Per Activity Offering"

  @co_three = create CourseOffering, :term => @term.term_code, :course => "PHYS272",
                     :final_exam_driver => "Final Exam Per Activity Offering"
  @ao_three = @co_three.create_ao(make ActivityOffering, :format => "Lecture Only")

  @co_four = create CourseOffering, :term => @term.term_code, :course => "CHEM611"
end

When /^I rollover the term to a new academic term that has no exam period$/ do
  @calendar_target = create AcademicCalendar, :year => @calendar.year.to_i + 1 #, :name => "TWj64w1q3e"
  @term_target = make AcademicTerm, :term_year => @calendar_target.year, :add_exam_period => false
  @calendar_target.add_term(@term_target)
  @term_target.make_official

  @manage_soc = make ManageSoc, :term_code => @term_target.term_code
  @manage_soc.set_up_soc

  @rollover = make Rollover, :target_term => @term_target.term_code ,
                   :source_term => @term.term_code,
                   :exp_success => false, :defer_continue_wo_exams => true
  @rollover.perform_rollover
end

When /^I rollover the term to a new academic term that has an exam period$/ do
  @calendar_target = create AcademicCalendar, :year => @calendar.year.to_i + 1
  @term_target = make AcademicTerm, :term_year => @calendar_target.year
  @calendar_target.add_term(@term_target)
  @term_target.make_official

  @manage_soc = make ManageSoc, :term_code => @term_target.term_code
  @manage_soc.set_up_soc

  @rollover = make Rollover, :target_term => @term_target.term_code ,
                   :source_term => @term.term_code,
                   :exp_success => false
  @rollover.perform_rollover
  @rollover.wait_for_rollover_to_complete
end

When /^I have ensured that the Fall Term of the Calender is setup with a Final Exam Period$/ do
  @source_calendar = make AcademicCalendar, :name => "2012-2013 Academic Calendar", :year => "2012"
  @term = make AcademicTerm, :term_year => @source_calendar.year, :term_type => "Fall Term", :term_name => "Fall"
  @term.edit :exam_period => true
end

When /^I have ensured that the Spring Term of the Calender is setup with a Final Exam Period$/ do
  @source_calendar = make AcademicCalendar, :name => "2012-2013 Academic Calendar", :year => "2012"
  @term = make AcademicTerm, :term_year => "#{@source_calendar.year.to_i + 1}", :term_type => "Spring Term",
                             :term_name => "Spring"
  @term.edit :exam_period => true
end

When /^I view the Exam Offerings for a CO created from an existing CO with a standard final exam driven by Course Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL304")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                       :final_exam_driver => "Final Exam Per Course Offering"
  @activity_offering =  make ActivityOffering, :code => "A", :parent_course_offering => @course_offering
  @activity_offering.edit :send_to_scheduler => true, :defer_save => false

  @create_co = create CourseOffering, :term=> @course_offering.term, :create_from_existing => @course_offering

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO created from an existing CO with a standard final exam driven by Activity Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL305")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"
  @activity_offering =  make ActivityOffering, :code => "A", :parent_course_offering => @course_offering
  @activity_offering.edit :send_to_scheduler => true, :defer_save => false

  @create_co = create CourseOffering, :term=> @course_offering.term, :create_from_existing => @course_offering

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO created from an existing CO with multiple AOs and a standard final exam driven by Activity Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "HIST110")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"
  @activity_offering =  make ActivityOffering, :code => "A", :parent_course_offering => @course_offering
  @activity_offering.edit :send_to_scheduler => true, :defer_save => false

  @create_co = create CourseOffering, :term=> @course_offering.term, :create_from_existing => @course_offering

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO with two AOs and a standard final exam driven by Activity Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL201")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO with two new AOs and a standard final exam driven by Activity Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL201")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"
  @activity_offering = make ActivityOffering, :code => "A", :parent_course_offering => @course_offering
  @activity_offering.edit :send_to_scheduler => true, :defer_save => false

  @add_ao_one = @course_offering.create_ao(make ActivityOffering, :format => "Lecture Only")
  @add_ao_two = @course_offering.create_ao(make ActivityOffering, :format => "Lecture Only")

  @create_co = create CourseOffering, :term=> @course_offering.term, :create_from_existing => @course_offering
  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I create a CO with two new AOs and then view the Exam Offerings where the CO has a standard final exam driven by Activity Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL201")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"
  @activity_offering =  make ActivityOffering, :code => "A", :parent_course_offering => @course_offering
  @activity_offering.edit :send_to_scheduler => true, :defer_save => false

  @add_ao_one = @course_offering.create_ao(make ActivityOffering, :format => "Lecture Only")
  @add_ao_two = @course_offering.create_ao(make ActivityOffering, :format => "Lecture Only")

  @create_co = create CourseOffering, :term=> @course_offering.term, :create_from_existing => @course_offering

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO with a standard final exam driven by Course Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL304")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Course Offering"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO with a standard final exam driven by Activity Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL304")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for an open CO with a standard final exam driven by Activity Offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201301", :course => "ENGL304")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO where the Course Offering Standard FE is changed to No Final Exam$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL305")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Course Offering"

  @course_offering.exam_offerings_setup :final_exam_type => "No final exam or assessment"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO where the Activity Offering Standard FE is changed to Alternate Final Exam$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL304")
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"

  @course_offering.exam_offerings_setup :final_exam_type => "Alternate final assessment"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

#KSENROLL-9801
When /^When I view the Exam Offerings for a CO where the Course Offering No FE is changed to Standard Final Exam$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :term => "201208", :course => "ENGL304")
  @course_offering.exam_offerings_setup :final_exam_type => "No final exam or assessment"

  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver =>"Final Exam Per Course Offering"
  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings after changing the Final Exam Driver to Course Offering$/ do
  @course_offering.manage
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Course Offering"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings after changing the Final Exam Driver to Activity Offering$/ do
  @course_offering.manage
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings after updating the Final Exam to none$/ do
  @course_offering.manage
  @course_offering.exam_offerings_setup :final_exam_type => "No final exam or assessment"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO created from catalog with a standard final exam driven by Course Offering$/ do
  @course_offering = create CourseOffering, :term => "201208", :course => "ENGL304"
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Course Offering"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I view the Exam Offerings for a CO created from catalog with a standard final exam driven by Activity Offering$/ do
  @course_offering = create CourseOffering, :term => "201208", :course => "ENGL304"
  @course_offering.exam_offerings_setup :final_exam_type => "Standard final Exam",
                                        :final_exam_driver => "Final Exam Per Activity Offering",
                                        :final_exam_activity => "Lecture"

  on ManageCourseOfferings do |page|
    page.view_exam_offerings
  end
end

When /^I add an Exam Period to the term$/ do
  @term.edit :exam_period => true
end

When /^I choose to include the non-active days in the term's Exam Period$/ do
  @term.edit :exam_period => true, :include_non_active_days => true
end

When /^I edit a Thursday morning at eleven Standard Final Exam rule on the matrix$/ do
  @matrix = make FinalExamMatrix
  @matrix.edit :defer_save => true
end

When /^I edit the Fall Term Exam Period to have less days than the Final Exam Matrix days$/ do
  @new_term = make AcademicTerm, :term_year => @calendar.year, :start_date=>"08/20/#{@calendar.year}",
                   :end_date=>"12/10/#{@calendar.year}"
  @new_term.change_exam_start_date( "12/05/#{@calendar.year}")
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
    page.get_exam_start_date( @term.term_type).should match /#{@term.start_date}/
    page.get_exam_end_date( @term.term_type).should match /#{@term.end_date}/
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
    page.final_exam_driver_select "Final Exam Per Course Offering"
    page.final_exam_driver_value.should == "Course Offering"
    page.final_exam_driver_select "Final Exam Per Activity Offering"
    page.final_exam_driver_value.should == "Activity Offering"
    page.final_exam_option_alternate
    page.final_exam_driver_value.should == "Alternate exam for this offering"
    page.final_exam_option_none
    page.final_exam_driver_value.should == "No final exam for this offering"
    page.create_offering
  end
end

Then /^the option to specify a Final Exam Driver should only be available for a course offering with a Standard Final Exam$/ do
  on CreateCOFromCatalog do |page|
    page.final_exam_option_standard
    page.final_exam_driver_div.present?.should == true
    page.final_exam_option_alternate
    page.final_exam_driver_div.present?.should == false
    page.final_exam_option_none
    page.final_exam_driver_div.present?.should == false
    page.create_offering
  end
end

Then /^a warning about the FE on the Edit CO page is displayed stating "([^"]*)"$/ do |exp_msg|
  on CourseOfferingEdit do |page|
    page.delivery_assessment_warning.should match /#{exp_msg}/
  end
end

Then /^the status of the Final Exam Driver should change to indicate the driver chosen for the Standard Final Exam$/ do
  on CreateCOFromCatalog do |page|
    page.final_exam_option_standard
    page.final_exam_driver_select "Final Exam Per Activity Offering"
    page.final_exam_driver_value.should == "Activity Offering"
    page.final_exam_driver_select "Final Exam Per Course Offering"
    page.final_exam_driver_value.should == "Course Offering"
    page.create_offering
  end
end

Then /^I should be able to edit and update the Final Exam status$/ do
  on CourseOfferingEdit do |page|
    page.final_exam_option_none
    page.final_exam_driver_value_0.should == "No final exam for this offering"
    page.submit
  end
end

Then /^the exam period for the copied course offering should match that of the original$/ do
  on CourseOfferingEdit do |page|
    page.final_exam_driver_value.should == "No final exam for this offering"
  end
end

Then /^the option for the Use Final Exam Matrix should only be available for a course offering with a Standard Final Exam$/ do
  on CreateCOFromCatalog do |page|
    page.final_exam_option_standard
    page.use_exam_matrix_div.present?.should == true
    page.final_exam_option_alternate
    page.use_exam_matrix_div.present?.should == false
    page.final_exam_option_none
    page.use_exam_matrix_div.present?.should == false
    #page.create_offering
  end
end

Then /^I should not be able to update the status of the final exam period$/ do
  on CourseOfferingEdit do |page|
    page.final_exam_option_div.radio(value: "STANDARD").present?.should == false
    page.final_exam_option_div.radio(value: "ALTERNATE").present?.should == false
    page.final_exam_option_div.radio(value: "NONE").present?.should == false
    page.span( id: "finalExamType_control").text.should == "Standard final Exam"
    page.cancel
  end
end

Then /^I do not have access to the final exam status for the course offering from catalog$/ do
  on CreateCourseOffering do |page|
    page.choose_from_catalog
    page.continue
  end

  on CreateCOFromCatalog do |page|
    page.final_exam_option_div.radio(value: "STANDARD").present?.should == false
    page.final_exam_option_div.radio(value: "ALTERNATE").present?.should == false
    page.final_exam_option_div.radio(value: "NONE").present?.should == false
    page.span( id: "finalExamType_control").text.should == "Standard final Exam"
  end
end

Then /^all the exam settings and messages are retained after the rollover is completed$/ do
  #@co_one
  @test_co_one = make CourseOffering, :term => @term_target.term_code, :course => @co_one.course
  @test_co_one.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.delivery_assessment_warning.should == "Course exam data differs from Catalog."
    page.final_exam_driver_value_0.should == "No final exam for this offering"
  end
  #@co_two
  @test_co_two = make CourseOffering, :term => @term_target.term_code, :course => @co_two.course
  @test_co_two.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.delivery_assessment_warning.should == "Course exam data differs from Catalog."
    page.final_exam_driver_value_0.should == "Alternate exam for this offering"
  end
  #@co_three
  @test_co_three = make CourseOffering, :term => @term_target.term_code, :course => @co_three.course
  @test_co_three.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.final_exam_driver_value_0.should == "Activity Offering"
  end
  #@co_four
  @test_co_four = make CourseOffering, :term => @term_target.term_code, :course => @co_four.course
  @test_co_four.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.final_exam_driver_value_0.should == "Course Offering"
    #TODO: add assertion to check if use final exam matrix is checked or not
  end
end

Then /^all the Exam Offering's state and table by Exam Driver should be retained after the rollover is completed$/ do
  #@co_one
  @test_co_one = make CourseOffering, :term => @term_target.term_code, :course => @co_one.course
  @test_co_one.manage
  on(ManageCourseOfferings).view_exam_offerings
  on ViewExamOfferings do |page|
    page.co_table_header_text.should match /for Course Offering/
    page.eo_by_co_status.should match /Draft/
  end
  #@co_two
  @test_co_two = make CourseOffering, :term => @term_target.term_code, :course => @co_two.course
  @test_co_two.manage
  on(ManageCourseOfferings).view_exam_offerings
  on ViewExamOfferings do |page|
    page.ao_table_header.exists?.should == false
  end
  #@co_three
  @test_co_three = make CourseOffering, :term => @term_target.term_code, :course => @co_three.course
  @test_co_three.manage
  on(ManageCourseOfferings).view_exam_offerings
  on ViewExamOfferings do |page|
    page.eo_by_ao_status("A", 0).should match /Draft/
  end
  #@co_four
  @test_co_four = make CourseOffering, :term => @term_target.term_code, :course => @co_four.course
  @test_co_four.manage
  on(ManageCourseOfferings).view_exam_offerings
  on ViewExamOfferings do |page|
    page.co_table_header_text.should match /for Course Offering/
    page.eo_by_co_status.should match /Draft/
  end
end

Then /^every CO's Exam Offerings should be copied to the new term by the rollover process$/ do
  #@co_one
  @test_co_one = make CourseOffering, :term => @term_target.term_code, :course => @co_one.course
  @test_co_one.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.delivery_assessment_warning.should == "Course exam data differs from Catalog."
    page.final_exam_driver_value_0.should == "No final exam for this offering"
  end
  #@co_two
  @test_co_two = make CourseOffering, :term => @term_target.term_code, :course => @co_two.course
  @test_co_two.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.delivery_assessment_warning.should == "Course exam data differs from Catalog."
    page.final_exam_driver_value_0.should == "Alternate exam for this offering"
  end
  #@co_three
  @test_co_three = make CourseOffering, :term => @term_target.term_code, :course => @co_three.course
  @test_co_three.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.final_exam_driver_value_0.should == "Activity Offering"
  end
  #@co_four
  @test_co_four = make CourseOffering, :term => @term_target.term_code, :course => @co_four.course
  @test_co_four.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.final_exam_driver_value_0.should == "Course Offering"
    #TODO: add assertion to check if use final exam matrix is checked or not
  end
end

Then /^there should be a Course Offering table that is in the ([^"]*) state$/ do |exp_state|
  on ViewExamOfferings do |page|
    page.co_table_header_text.should match /for Course Offering/
    page.eo_by_co_status.should match /#{exp_state}/
  end
end

Then /^the Course Offering table should only show that it is in the ([^"]*) state$/ do |exp_state|
  on ViewExamOfferings do |page|
    page.co_table_header_text.should match /for Course Offering/
    page.eo_by_co_status.should match /#{exp_state}/
    page.eo_by_co_days.should == ""
    page.eo_by_co_st_time.should == ""
    page.eo_by_co_end_time.should == ""
    page.eo_by_co_bldg.should == ""
    page.eo_by_co_room.should == ""
    page.count_no_of_eos_by_co.should == "1"
  end
end

Then /^there should be an Activity Offering table that is in the ([^"]*) state$/ do |exp_state|
  on ViewExamOfferings do |page|
    page.ao_table_header_text.should match /for Activity Offering/
    page.eo_by_ao_status("A").should match /#{exp_state}/
    page.eo_by_ao_status("C").should match /#{exp_state}/
    page.eo_by_ao_status("F").should match /#{exp_state}/
    page.eo_by_ao_status("J").should match /#{exp_state}/
  end
end

Then /^the default cluster's Activity Offering table should for all ([^"]*) Exam Offerings? only show that it is in the ([^"]*) state$/ do |no_of_aos,exp_state|
  on ViewExamOfferings do |page|
    #page.ao_table_header_text.should match /for Activity Offering/
    array = page.return_array_of_ao_codes
    array.each do |code|
      page.eo_by_ao_status(code).should match /#{exp_state}/
      page.eo_by_ao_days(code).should == ""
      page.eo_by_ao_st_time(code).should == ""
      page.eo_by_ao_end_time(code).should == ""
      page.eo_by_ao_bldg(code).should == ""
      page.eo_by_ao_room(code).should == ""
    end
    array.length.should == no_of_aos.to_i
  end
end

Then /^the leftover cluster's Activity Offering table should for all ([^"]*) Exam Offerings? only show that it is in the ([^"]*) state$/ do |no_of_aos,exp_state|
  on ViewExamOfferings do |page|
    #page.ao_table_header_text.should match /for Activity Offering/
    array = page.return_array_of_ao_codes("CL Leftovers")
    array.each do |code|
      page.eo_by_ao_status(code, "CL Leftovers").should match /#{exp_state}/
      page.eo_by_ao_days(code, "CL Leftovers").should == ""
      page.eo_by_ao_st_time(code, "CL Leftovers").should == ""
      page.eo_by_ao_end_time(code, "CL Leftovers").should == ""
      page.eo_by_ao_bldg(code, "CL Leftovers").should == ""
      page.eo_by_ao_room(code, "CL Leftovers").should == ""
    end
    array.length.should == no_of_aos.to_i
  end
end

Then /^there should be an Activity Offering table where all Exam Offerings is in the ([^"]*) state$/ do |exp_state|
  on ViewExamOfferings do |page|
    page.ao_table_header_text.should match /for Activity Offering/
    page.return_array_of_ao_codes.each do |code|
      page.eo_by_ao_status(code).should match /#{exp_state}/
    end
  end
end

Then /^there should be ([^"]*) Exam Offerings? by Activity Offering for the course$/ do |no_of_aos|
  on ViewExamOfferings do |page|
    array = page.return_array_of_ao_codes
    array.length.should == no_of_aos.to_i
  end
end

Then /^there should be 1 Exam Offering by Course Offering for the course$/ do
  on ViewExamOfferings do |page|
    array = page.return_array_of_ao_codes
    array.length.should == 1
  end
end

Then /^there should be no Standard Exam tables present$/ do
  on ViewExamOfferings do |page|
    page.exam_offerings_page_section.text.should_not match /^Exam Offerings for Course Offering/
    page.exam_offerings_page_section.text.should_not match /^Exam Offerings for Activity Offering/
  end
end

Then /^I expect a popup to appear with a displayed warning stating "([^"]*)"$/ do |exp_msg|
  on PerformRollover do |page|
    page.continue_wo_exams_dialog_div.visible?.should == true
    page.continue_wo_exams_dialog_div.text.should match /#{exp_msg}/
    page.continue_wo_exams_dialog_confirm
  end
end

Then /^the non-active days toggles should be selected by default$/ do
  on EditAcademicTerms do |page|
    page.exclude_saturday_toggle( @term.term_type).attribute_value('checked').should == "true"
    page.exclude_sunday_toggle( @term.term_type).attribute_value('checked').should == "true"
  end
end

Then /^the non-active days should still be included in the Exam Period when I return to view the term$/ do
  @term.search
  on(CalendarSearch).view @term.term_name
  on ViewAcademicTerms do |page|
    page.open_term_section(@term.term_type)
    page.get_exclude_saturday_value(@term.term_type).should == "false"
    page.get_exclude_sunday_value(@term.term_type).should == "false"
  end
end

Then /^the Canceled Exam Offering table should only show that it is in the ([^"]*) state$/ do |exp_msg|
  on ViewExamOfferings do |page|
    #page.canceled_table_header_text.should match /Canceled Exam Offering/
    page.canceled_eo_table.rows[1].cells[0].text.should == exp_msg
  end
end

Then /^there should be an Course Offering table header explaining that the Exam Offerings have been canceled$/ do
  on ViewExamOfferings do |page|
    page.exam_offerings_page_section.text.should match /Cancelled Exam Offerings for Course Offerings/
  end
end

Then /^there should be an Activity Offering table header explaining that the Exam Offerings have been canceled$/ do
  on ViewExamOfferings do |page|
    page.exam_offerings_page_section.text.should match /Cancelled Exam Offerings for Activity Offerings/
  end
end

Then /^there should be no Activity Offering table present$/ do
  on ViewExamOfferings do |page|
    page.ao_table_header.exists?.should == false
  end
end

Then /^I should be able to choose any one of Day 1 to 6 for the rule$/ do
 on FEMatrixEdit do |page|
   page.fe_days_select.option( value: "1").text.should == "Day 1"
   page.fe_days_select.option( value: "2").text.should == "Day 2"
   page.fe_days_select.option( value: "3").text.should == "Day 3"
   page.fe_days_select.option( value: "4").text.should == "Day 4"
   page.fe_days_select.option( value: "5").text.should == "Day 5"
   page.fe_days_select.option( value: "6").text.should == "Day 6"
 end
end