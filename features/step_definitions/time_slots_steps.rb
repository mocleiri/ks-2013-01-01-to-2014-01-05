When /^I specify a Term Type (Fall - Full|Spring - Full|Fall - Full and Spring - Full)$/ do |term_type|
  term_type = term_type.split( ' and ')                       # convert natural-language to an array
  @time_slots = make TimeSlots, :term_types => term_type
  @time_slots.show_time_slots
end

When /^I specify to Add Time Slot with Term Type (Fall - Full), Days ([MTWUFSU]+), Start time (\d{2}:\d{2}) (am|pm), End time (\d{2}:\d{2}) (am|pm)$/ do |term_type, days, start_time, start_time_am_pm, end_time, end_time_am_pm|
  @time_slots.add_time_slot( make TimeSlots::TimeSlot, :term_type => term_type, :days => days, :start_time => start_time, :start_time_am_pm => start_time_am_pm, :end_time => end_time, :end_time_am_pm => end_time_am_pm )
end

Then /^changes are saved$/ do
  go_to_manage_time_slots
  on TimeSlotMaintenance do |page|

  end
end






When /^I do some timeslot stuff$/ do

  go_to_manage_time_slots

  on TimeSlotMaintenance do |page|
    test = ["Fall - Full"]
    page.select_time_slot_types(test)
    page.show_time_slots

    row = page.time_slot_search_results_table[1]
    row[2].text == "Fall - Full"
    row[3].text == "F"
    row[4].text == "10:00 PM"
    row[5].text == "10:50 PM"
  end


  sleep 10
  puts 'done'
end


###############################################################
###
### DRAFT REMNANTS -- DELETE ONCE DEV IS COMPLETE!
###
###############################################################

When /^I target a row in the timeslots result table then I can get it's code$/ do

  on TimeSlotMaintenance do |page|
    row = page.target_results_row("A")
    code = row[1].text
    puts 'found code -> ' + code
  end

end