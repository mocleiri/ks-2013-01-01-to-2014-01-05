When /^I log in as a Schedule Coordinator$/ do
  @performance_test = make PerformanceTest

  visit PortalMenu do |page|
    page.logout
    page.username_field.set "martha"
    page.password_field.set "martha"
    @performance_test.start
    page.login_button.click
    page.enrollment_home_link.wait_until_present
    @performance_test.end
  end

end

Then /^the transaction takes less than "([^"]*)" seconds$/ do |time_requirement|
  puts @performance_test.test_time.to_s
  @performance_test.test_time.should <= time_requirement.to_f
end

When /^I search for an Academic Calendar$/ do
  @performance_test = make PerformanceTest
  go_to_calendar_search
  on CalendarSearch do |page|
    page.search_for_select.select "Academic Calendar"
    page.name.set "2015-2016 Academic Calendar"
    page.year.set "2015"
    @performance_test.start
    page.search
    page.loading.wait_while_present
    @performance_test.end
  end
end

When /^I edit the Academic Calendar$/ do
  on CalendarSearch do |page|
    @performance_test.start
    page.edit  "2015-2016 Academic Calendar"
    @performance_test.end
  end
end

When /^I update a field and save the Academic Calendar$/ do
  on EditAcademicCalendar do |page|
    page.calendar_end_date.set "08/23/2015"
    @performance_test.start
    page.save
   # while page.alert.exists?
   #   page.alert.cancel
   # end
    @performance_test.end
  end
end

When /^I create a new Academic Calendar$/ do
  on EditAcademicCalendar do |page|
    page.academic_calendar_name.set random_alphanums.strip
    page.calendar_start_date.set "09/01/#{next_year[:year]}"
    page.calendar_end_date.set "06/25/#{next_year[:year] + 1}"
    @performance_test.start
    page.save
    @performance_test.end
  end
end

When /^I start a blank Academic Calendar$/ do
  @performance_test = make PerformanceTest
  go_to_academic_calendar
  on CreateAcadCalendar do |page|
    @performance_test.start
    page.start_blank_calendar
    @performance_test.end
  end
end

When /^I search for an Holiday Calendar$/ do
  @performance_test = make PerformanceTest
  go_to_calendar_search
  on CalendarSearch do |page|
    page.search_for_select.select "Holiday Calendar"
    page.name.set "2015-2016 Holiday Calendar"
    page.year.set "2015"
    @performance_test.start
    page.search
    page.loading.wait_while_present
    @performance_test.end
  end
end


When /^I edit the Holiday Calendar$/ do
  on CalendarSearch do |page|
    @performance_test.start
    page.edit  "2015-2016 Holiday Calendar"
    @performance_test.end
  end
end

When /^I update a field and save the Holiday Calendar$/ do
  on EditHolidayCalendar do |page|
    page.end_date.set "08/20/2016"
    @performance_test.start
    page.save
    @performance_test.end
  end
end

When /^I start a blank Holiday Calendar$/ do
  @performance_test = make PerformanceTest
  go_to_holiday_calendar
  on CreateHolidayCalendar do |page|
    @performance_test.start
    page.start_blank_calendar
    @performance_test.end
  end
end

When /^I create a new Holiday Calendar$/ do
  on EditHolidayCalendar do |page|
    page.calendar_name.set random_alphanums.strip
    page.start_date.set "09/01/#{next_year[:year]}"
    page.end_date.set "06/25/#{next_year[:year] + 1}"
    @performance_test.start
    page.save
    @performance_test.end
  end
end

When /^I search for an existing population$/ do
  @performance_test = make PerformanceTest
  go_to_manage_population
  on ManagePopulations do |page|
    page.keyword.set "Athlete"
    @performance_test.start
    page.search
    @performance_test.end
  end
end

When /^I edit the population$/ do
  on ManagePopulations do |page|
    @performance_test.start
    page.target_row("Athlete").link(text: "edit").click
    page.loading.wait_while_present
    @performance_test.end
  end
end

When /^I update a field and save the population$/ do
  on EditPopulation do |page|
    page.description.set "Members of Sports"
    @performance_test.start
    page.update
    @performance_test.end
  end
end

When /^I create a new populations$/ do
  @performance_test = make PerformanceTest
  go_to_manage_population
  on ManagePopulations do |page|
    @performance_test.start
    page.create_new
    @performance_test.end
  end
end

When /^I save the population$/ do
  on CreatePopulation do |page|
    page.name.set random_alphanums.strip
    page.description.set  random_alphanums.strip
    @performance_test.start
    page.create
    @performance_test.end
  end
end

When /^I search for a registration Window$/ do
  @performance_test = make PerformanceTest
  go_to_manage_reg_windows
  on RegistrationWindowsTermLookup do |page|
    page.term_type.select "Fall Term"
    page.year.set "2012"
    @performance_test.start
    page.search
    @performance_test.end
  end
end

When /^I select all registration periods$/ do
  on RegistrationWindowsPeriodLookup do |page|
    page.period_id.select 'All Registration Periods for this Term'
    @performance_test.start
    page.show
    @performance_test.end
  end
end

When /^I add a registration window and save$/ do
  on RegistrationWindowsCreate do |page|
    page.period_key.select "Senior Registration"
    page.appointment_window_info_name.set "TestDate"
    page.assigned_population_name.set "Athlete"
    page.start_date.set "03/30/2012"
    page.start_time.set "10:00"
    page.start_time_am_pm.select "am"
    page.window_type_key.select "One Slot per Window"
    page.loading.wait_while_present
    page.add
    @performance_test.start
    page.save
    @performance_test.end
  end
end

When /^I search for a course by subject code$/ do
  @performance_test = make PerformanceTest
  go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set "201301"
    page.input_code.set "ENGL"
    @performance_test.start
    page.perf_show
    @performance_test.end
  end
end

When /^I search for a course by course code$/ do
  @performance_test = make PerformanceTest
  go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set "201301"
    page.input_code.set "ENGL101A"
    @performance_test.start
    page.perf_show
    @performance_test.end
  end
end

When /^I edit the course offering for performance$/ do
  on ManageCourseOfferings do |page|
    @performance_test.start
    page.edit_course_offering
    @performance_test.end
  end
end

When /^I save the course change$/ do
  on CourseOfferingEdit do |page|
    if page.waitlist_checkbox.set?
      page.waitlist_checkbox.clear
    else
      page.waitlist_checkbox.set
    end
    @performance_test.start
    page.submit
    @performance_test.end
  end
end

When /^I delete the course offering$/ do
  on ManageCourseOfferings do |page|
    page.delete_course_offering
  end
  on DeleteCourseOffering do |page|
    @performance_test.start
    page.confirm_delete
    @performance_test.end
  end
end


When /^I copy a course offering$/ do
  on CopyCourseOffering do |page|
    @performance_test.start
    page.create_copy
    @performance_test.end
  end
end

When /^I click copy for a course offering$/ do
  @performance_test = make PerformanceTest
  go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set "201301"
    page.input_code.set "ENGL101"
    page.perf_show
  end
  on ManageCourseOfferingList do |page|
    @performance_test.start
    page.copy "ENGL101"
    @performance_test.end
  end
end


When /^I create a basic course offering$/ do
  @performance_test = make PerformanceTest
  go_to_create_course_offerings
  on CreateCourseOffering do  |page|
    page.target_term.set "201301"
    page.catalogue_course_code.set "ENGL316"
    page.show
    page.suffix.set random_alphanums.strip
    page.add_random_delivery_format
    @performance_test.start
    page.create_offering
    @performance_test.end
  end
end


When /^I create a jointly defined course offering$/ do
  @performance_test = make PerformanceTest
  go_to_create_course_offerings
  on CreateCourseOffering do  |page|
    page.target_term.set "201301"
    page.catalogue_course_code.set "ENGL316"
    page.show
    page.suffix.set random_alphanums.strip
    page.create_new_joint_defined_course_row_1
    page.add_random_delivery_format
    @performance_test.start
    page.create_offering
    @performance_test.end
  end
end

When /^I edit an Activity Offering for performance$/ do
  @performance_test = make PerformanceTest
  go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set "201301"
    page.input_code.set "ENGL250"
    page.perf_show
    @performance_test.start
    page.edit "A"
    @performance_test.end
  end
end

When /^I copy an Activity Offering for performance$/ do
  @performance_test = make PerformanceTest
  go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set "201301"
    page.input_code.set "ENGL250"
    page.perf_show
    @performance_test.start
    page.copy "A"
    @performance_test.end
  end
end

When /^I add Delivery Logistics and save$/ do
  @performance_test = make PerformanceTest
  go_to_manage_course_offerings
  on ManageCourseOfferings do |page|
    page.term.set "201301"
    page.input_code.set "ENGL250"
    page.perf_show
    page.edit "A"
  end

  on ActivityOfferingMaintenance do |page|
    page.add_days.set "MWF"
    page.add_start_time.set "10:00"
    page.add_start_time_ampm.select "am"
    page.add_end_time.set "11:00"
    page.add_end_time_ampm.select "am"
    page.add_facility.set "IPT"
    page.add_room.set "1116"
    page.add_new_delivery_logistics
    @performance_test.start
    page.submit
    @performance_test.end
  end
end

When /^I search for a SOC$/ do
  @performance_test = make PerformanceTest
  go_to_manage_soc
  on ManageSocPage do |page|
    page.term_code.set "201301"
    @performance_test.start
    page.go_action
    @performance_test.end
  end
end

