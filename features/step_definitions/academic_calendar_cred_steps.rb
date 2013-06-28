When /^I create an Academic Calendar$/ do
  @calendar = make AcademicCalendar
  @calendar.create
end

Then /^the Make Official button should become active$/ do
  on EditAcademicCalendar do |page|
    page.make_official_link.present?.should == true # TODO: Figure out why ".should_be enabled" does not work.
  end
end

When /^I search for the calendar$/ do
  @calendar.search
end

When /^I search for academic calendars$/ do
  @calendar = make AcademicCalendar, :name => "Academic Calendar"
  @calendar.search
end

When /^I search for holiday calendars$/ do
  @calendar = make HolidayCalendar, :name => "Holiday Calendar"
  @calendar.search
end

When /^I search for academic terms$/ do
  @term = make AcademicTerm, :term_name => "Term"
  @term.search
end

When /^I search for the Academic Calendar using (.*)$/ do |arg|
  search_terms = { :wildcards=>"*", :"partial name"=>@calendar.name[0..2] }
  visit Enrollment do |page|
    page.search_for_calendar_or_term
  end
  on CalendarSearch do |page|
    page.search_for "Academic Calendar", search_terms[arg.to_sym]

    while page.showing_up_to.to_i < page.total_results.to_i
      if page.results_list.include? @calendar.name
        break
      else
        page.next
      end
    end
  end
end

Then /^the calendar (.*) appear in search results$/ do |arg|
  on CalendarSearch do |page|
    if arg == "should"
      page.results_list.should include @calendar.name
    else
      begin
        page.results_list.should_not include @calendar.name
      rescue Watir::Exception::UnknownObjectException
        # Implication here is that there were no search results at all.
      end
    end
  end
end

When /^I make the calendar official$/ do
  @calendar.make_official
end

Then /^the calendar (.*) be set to Official$/ do |arg|
  on CalendarSearch do |page|
    if arg == "should"
      is_official = page.calendar_action_text(@calendar.name).include? "Delete"
      is_official.should == false
    else
      is_official = page.calendar_status(@calendar.name).include? "Delete"
      is_official.should == true
    end
  end
end

When /^I copy the Academic Calendar$/ do
  @calendar_copy = make AcademicCalendar
  @calendar_copy.copy_from @calendar.name
end

When /^I update the Academic Calendar$/ do
  @calendar.search
  on CalendarSearch do |page|
    page.edit @calendar.name
  end
  @calendar.name = random_alphanums.strip
  @calendar.start_date = "02/15/#{next_year[:year]}"
  @calendar.end_date = "07/06/#{next_year[:year] + 1}"
  on EditAcademicCalendar do |page|
    page.academic_calendar_name.set @calendar.name
    page.calendar_start_date.set @calendar.start_date
    page.calendar_end_date.set @calendar.end_date
    page.save
  end
end

When /^I delete the Academic Calendar draft$/ do
  on EditAcademicCalendar do |page|
    page.delete_draft
    page.confirm_delete
  end
end

Then /^the calendar should reflect the updates$/ do
  on CalendarSearch do |page|
    page.edit @calendar.name
  end
  on EditAcademicCalendar do |page|
    page.academic_calendar_name.value.should == @calendar.name
    page.calendar_start_date.value.should == @calendar.start_date
    page.calendar_end_date.value.should == @calendar.end_date
  end
end

When /^I add a (.*) term and save$/ do |term_type|
  on EditAcademicTerms do |page|
     page.go_to_term_tab
     @term = make AcademicTerm
     @term.create term_type
     page.go_to_cal_tab
  end
  on EditAcademicCalendar do |page|
    page.save
    raise "Page has errors" unless page.page_info_message
    if(page.page_info_message)
        (page.page_info_message_text =~ /has been saved successfully./).should_not == nil
    end
  end
end

Then /^I verify that the term added to the calendar$/ do
  @calendar.search
  on CalendarSearch do |page|
    page.edit @calendar.name
  end
  on EditAcademicTerms do |page|
    page.go_to_term_tab
    @term.verify
  end
end

And /^Make Official button for the term is enabled$/ do
  on EditAcademicTerms do |page|
    page.term_make_official_enabled(0).should == true
    page.term_make_official_button(0).should == 'Make Official'
  end
end

And /^I make the term official$/ do
  on EditAcademicTerms do |page|
    page.go_to_term_tab
    page.make_term_official(0)
  end
end

Then /^the term should be set to Official on edit$/ do
  @term.search
  on CalendarSearch do |page|
    page.edit @term.term_name
  end
  on EditAcademicTerms do |page|
    page.term_make_official_button(0).should == 'Update Official'
  end
end

When /^I delete the Academic Term draft$/ do
  @term.search
  on CalendarSearch do |page|
    page.edit @term.term_name
  end
  on EditAcademicTerms do |page|
    page.go_to_term_tab
    page.delete_term(0)
    page.go_to_cal_tab
  end
  on EditAcademicCalendar do |page|
    page.save
    raise "Page has errors" unless page.page_info_message
    if(page.page_info_message)
      (page.page_info_message_text =~ /has been saved successfully./).should_not == nil
    end
  end
end

And /^the term should not appear in search results$/ do
  @term.search
  on CalendarSearch do |page|
    begin
      page.results_list.should_not include @calendar.name
    rescue Watir::Exception::UnknownObjectException
      # Implication here is that there were no search results at all.
    end
  end
end

Then /^I should be able to view the calendars$/ do
  on CalendarSearch do |page|
    begin
      # only check the visible rows of the table, and skip the header
      last_row = page.showing_up_to.to_i - 1
      page.results_table.rows[1..last_row].each do |row|
        row.link(text: "View").present?.should be_true
      end
    rescue Watir::Exception::UnknownObjectException
      # Means no search results on the page.
      raise "Page has no results to check"
    end
  end
end

And /^I should not be able to edit a calendar$/ do
  on CalendarSearch do |page|
    begin
      page.results_table.rows.each do |row|
        row.link(text: "Edit").present?.should be_false
      end
    rescue Watir::Exception::UnknownObjectException
      # Means no search results on the page.
      raise "Page has no results to check"
    end
  end
end

And /^I should not be able to copy a calendar$/ do
  on CalendarSearch do |page|
    begin
      page.results_table.rows.each do |row|
        row.link(text: "Copy").present?.should be_false
      end
    rescue Watir::Exception::UnknownObjectException
      # Means no search results on the page.
      raise "Page has no results to check"
    end
  end
end

Then /^I should be able to view the terms$/ do
  on CalendarSearch do |page|
    begin
      # only check the visible rows of the table, and skip the header
      last_row = page.showing_up_to.to_i - 1
      page.results_table.rows[1..last_row].each do |row|
        row.link(text: "View").present?.should be_true
      end
    rescue Watir::Exception::UnknownObjectException
      # Means no search results on the page.
      raise "Page has no results to check"
    end
  end
end

And /^I should not be able to edit a term$/ do
  on CalendarSearch do |page|
    begin
      page.results_table.rows.each do |row|
        row.link(text: "Edit").present?.should be_false
      end
    rescue Watir::Exception::UnknownObjectException
      # Means no search results on the page.
      raise "Page has no results to check"
    end
  end
end

When /^I add a new term to the Academic Calendar$/ do
  @term = make AcademicTerm
  @calendar.edit :terms => @term
end

Then /^the term is listed when I view the Academic Calendar$/ do
  @calendar.search

  on CalendarSearch do |page|
    page.edit @calendar.name
  end

  on ViewAcademicTerms do |page|
    puts page.target_term_div(@term.name)
  end
end
Given /^I debug the 2012-2013 Academic Calendar$/ do
  @calendar = make AcademicCalendar, :name => "2012-2013 Academic Calendar"
  @calendar.search
  @calendar.edit

end
When /^I debug the Winter Term$/ do
  @term = make AcademicTerm, :term_type=>AcademicTerm::WINTER_TERM_TYPE

  on EditAcademicTerms do |page|
    page.go_to_term_tab
    page.open_term_section(@term.term_type)
  end
  #@term.edit :key_date_group_list =>  Array.new(1){make KeyDateGroup}
end

When /^I debug the key date groups$/ do
  @key_date_group = create KeyDateGroup, :key_date_group_type=> KeyDateGroup::INSTRUCTIONAL_DATE_GROUP, :term_type =>@term.term_type
  #on EditAcademicTerms do |page|
  #  puts "exists #{page.key_date_group_exists?(@term.term_type, "Instructional Key Dates")}"
  #end
end

When /^I debug the key dates$/ do
  @key_date = create KeyDate, :key_date_type => "First Day of Classes", :start_date => (Date.today + 2).strftime("%m/%d/%Y"),:parent_key_date_group => @key_date_group
  #on EditAcademicTerms do |page|
  #  puts "exists #{page.key_date_exists?(@term.term_type, "Instructional", "Last Day of Classes")}"
  #end
end

When /^I add events to the Academic Calendar$/ do
  @calendar.search
  on CalendarSearch do |page|
    page.edit @calendar.name
  end
  on EditAcademicCalendar do |page|
    page.event_toggle
    wait_until { page.event_type.enabled? }
    page.event_type.select "Commencement - Seattle Campus"
    page.event_start_date.set "04/15/#{next_year[:year]}"
    page.event_end_date.set "05/15/#{next_year[:year] + 1}"
    page.event_start_time.set "07:30"
    page.event_end_time.set "09:00"
    page.event_start_ampm.select "pm"
    page.event_end_ampm.select "pm"
    page.all_day.clear
    page.date_range.set
    page.add_event.click
  end
end
