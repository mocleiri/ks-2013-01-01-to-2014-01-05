When /^I create a Holiday Calendar$/ do
@holiday_calendar = create HolidayCalendar
end

Then /^The Make Official button of this Holiday Calendar should become active$/ do
  @holiday_calendar.search_and_edit_holiday_calendar
  on EditHolidayCalendar do |page|
    page.make_official_link.present?.should be_true
  end
end

When /^I search for the Holiday Calendar$/ do
  @holiday_calendar.search_holiday_calendar
end

When /^I make the Holiday Calendar official$/ do
  @holiday_calendar.search_and_edit_holiday_calendar
  on EditHolidayCalendar do |page|
    page.make_official
  end
end

When /^I search for the copied Holiday Calendar$/ do
  @copy_calendar.search_and_edit_holiday_calendar
end

When /^all holidays were copied successfully$/ do
  on EditHolidayCalendar do |page|
    i=2
    @copy_calendar.holiday_list.each do |holiday|
      holiday.type = page.holiday_table.rows[i].cells[EditHolidayCalendar::HOLIDAY_TYPE].text
      holiday.start_date = page.holiday_table.rows[i].cells[EditHolidayCalendar::START_DATE].text_field.value
      holiday.start_time = page.holiday_table.rows[i].cells[EditHolidayCalendar::START_TIME].text_field.value
      holiday.start_ampm = page.holiday_table.rows[i].cells[EditHolidayCalendar::START_AMPM].select_list.selected_options[0].value
      holiday.end_date = page.holiday_table.rows[i].cells[EditHolidayCalendar::END_DATE].text_field.value
      holiday.end_time = page.holiday_table.rows[i].cells[EditHolidayCalendar::END_TIME].text_field.value
      holiday.end_ampm = page.holiday_table.rows[i].cells[EditHolidayCalendar::END_AMPM].select_list.selected_options[0].value
      holiday.instructional = page.holiday_table.rows[i].cells[EditHolidayCalendar::INSTRUCTIONAL].checkbox.set?
      i+=1
    end
  end
end

When /^I create a holiday calendar by copying an existing calendar form search$/ do
  @copy_calendar = create HolidayCalendar, :create_by_copy_search =>(make HolidayCalendar, :name=>@holiday_calendar.name)
end

Then /^the holiday calendar (.*) appear in search results$/ do |arg|
  on CalendarSearch do |page|
    if arg == "should"
      page.results_list.should include @holiday_calendar.name
    else
      begin
        page.results_list.should_not include @holiday_calendar.name
      rescue Watir::Exception::UnknownObjectException
      end
    end
  end
end