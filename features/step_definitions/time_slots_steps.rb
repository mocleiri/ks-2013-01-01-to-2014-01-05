When /^I specify a Term Type (Fall - Full)$/ do |term_type|

  go_to_manage_time_slots

  on TimeSlotMaintenance do |page|
    test = ["Fall - Full", "Spring - Full"]
    page.select_time_slot_types(test)
    page.show_time_slots
  end

end

When /^I specify to Add Time Slot with Term Type (Fall - Full), Days ([MTWUFSU]+), Start time (\d{2}:\d{2}) (am|pm), End time (\d{2}:\d{2}) (am|pm)$/ do |term_type, days, start_time, start_time_am_pm, end_time, end_time_am_pm|

  puts term_type
  puts days
  puts start_time
  puts start_time_am_pm
  puts end_time
  puts end_time_am_pm

  on TimeSlotMaintenance do |page|
    page.initiate_add_time_slot
    page.add_time_slot_popup_field_termType.select term_type
    page.add_time_slot_popup_field_days.set days
    page.add_time_slot_popup_field_startTime.set start_time
    page.add_time_slot_popup_field_startTime_am_pm.select start_time_am_pm
    page.add_time_slot_popup_field_endTime.set end_time
    page.add_time_slot_popup_field_endTime_am_pm.select end_time_am_pm
    page.save_add_time_slot
  end

end






When /^I do some timeslot stuff$/ do

  go_to_manage_time_slots

  on TimeSlotMaintenance do |page|
    test = ["Fall - Full", "Spring - Full"]
    page.select_time_slot_types(test)
    page.show_time_slots

    row = page.time_slot_search_results_table[1]
    row[2].text == "Fall - Full"
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