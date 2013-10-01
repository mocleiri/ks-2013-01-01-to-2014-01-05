When /^I do some timeslot stuff$/ do
  puts 'here!'

  go_to_manage_time_slots

  on TimeSlotMaintenance do |page|
    test = ["Two", "Three"]
    page.select_time_slot_types(test)
    page.show_time_slots

    row = page.target_results_row("A")
    code = row[1].text
    puts 'found code -> ' + code
  end

  sleep 10
  puts 'done'
end