When /^I add (\d*) different time slots to a single term type$/ do |nbr|
  @time_slots = create TimeSlots
  @time_slots.add_unused_time_slots(nbr.to_i)
end

When /^I add a single time slot per 2 different term types$/ do
  term_types = [ "Fall - Full", "Spring - Full" ]
  @time_slots = create TimeSlots, :term_types => term_types
  @time_slots.add_unused_time_slots( term_types[0], 1 )
  @time_slots.add_unused_time_slots( term_types[1], 1 )
end

When /^I add a duplicate time slot$/ do
  @time_slots = create TimeSlots
  @time_slots.add_duplicate_time_slot(1000)
end

When /^I add a new time slot but omit the (start time|end time|days)$/ do |data_to_omit|
  time_slot = make TimeSlots::TimeSlot, :start_time => nil, :start_time_am_pm => nil
  @time_slots = create TimeSlots
  @time_slots.add_new_time_slot(time_slot)
end

Then /^the timeslots are saved$/ do
  @time_slots.show_time_slots
  @time_slots.new_time_slots.each do |time_slot|
    on TimeSlotMaintenance do |page|
      row = page.target_results_row time_slot.code
      row[TimeSlotMaintenance::TIME_SLOT_RESULTS_CODE].text == time_slot.code
      row[TimeSlotMaintenance::TIME_SLOT_RESULTS_TERM_TYPE].text == time_slot.term_type
      row[TimeSlotMaintenance::TIME_SLOT_RESULTS_DAYS].text == time_slot.days
      row[TimeSlotMaintenance::TIME_SLOT_RESULTS_START_TIME].text.split(' ')[0] == time_slot.start_time
      row[TimeSlotMaintenance::TIME_SLOT_RESULTS_START_TIME].text.split(' ')[1] == time_slot.start_time_am_pm
      row[TimeSlotMaintenance::TIME_SLOT_RESULTS_END_TIME].text.split(' ')[0] == time_slot.end_time
      row[TimeSlotMaintenance::TIME_SLOT_RESULTS_END_TIME].text.split(' ')[1] == time_slot.end_time_am_pm
    end
  end
end

Then /^an error message is displayed about the duplicate timeslot$/ do
  on(TimeSlotMaintenance).time_slot_error_message.text.should match /Timeslot already exists for .*/
end

Then /^an error is displayed about the missing data$/ do

end



###############################################################
###
### DRAFT REMNANTS -- DELETE ONCE DEV IS COMPLETE!
###
###############################################################

When /^I test some timeslot stuff$/ do



#  time = Time.now
#  puts time
#  puts time.hour
#  puts time.min
#
#  time = time + 60
#  puts time
#
#  time = Time.gm(2000,1,1,23,59,59)
#  puts time
#
#  time = time + 60
#  puts time


  @time_slots = create TimeSlots
  on TimeSlotMaintenance do |page|
    result = page.generate_unused_start_and_end_times
    puts "RESULT -> #{result}"
  end


end



When /^I target a row in the timeslots result table then I can get it's code$/ do

  on TimeSlotMaintenance do |page|
    row = page.target_results_row("A")
    code = row[1].text
    puts 'found code -> ' + code
  end

end

When /^I show time slots for a single term type$/  do
  @time_slots = create TimeSlots
end

When /^I? ?specify Term Type (.*)$/  do  |termType|
  pending
end

When /^I? ?specify Term Types (.*) and (.*)$/ do |termType1, termType2|
  pending
end

Then /^only time slots of that term type appear.?$/ do
  on TimeSlotMaintenance do |page|
    page.time_slot_search_results_table.rows[1..-2].each do |row|
      row.cells[TimeSlotMaintenance::TIME_SLOT_RESULTS_TERM_TYPE].text.should == @time_slots.term_types[0].to_s
    end
  end
end

When /^I? ?add a Time Slot with the chosen Term Type$/ do
  @time_slots.add_unused_time_slots(1)
end

When /^I? ?(.*) ?edit the (.*) ?Time Slot added above to be (.*), Days (M|T|W|H|F|S|U|blank), Start time (\d+:\d+ ?.*|blank), End time (\d+:\d+ ?.*|blank)$/ do |attempt, tsOrdinality, termType, days, startTime, endTime|
  pending
end


When /^I? ?attempt to (.*) the Time Slot added above$/ do |action|
  if action == "delete"
    code = @time_slots.new_time_slots[0].code
    @time_slots.delete(code)
  end
end

Then /^the (.*) ?Time Slot (is|is not) deleted.?$/  do |tsOrdinality, isIsNot|
  if tsOrdinality.nil? || tsOrdinality==""
    if isIsNot=="is"
      on TimeSlotMaintenance do |page|
        page.get_time_slot_code_list.should_not include @time_slots.new_time_slots[0].code
      end
    end
  end
end

When /^I? ?add an RDL using the (.*) ?Time Slot added above$/ do |tsOrdinality|
  pending
end

When /^I? ?attempt to delete both the Time Slots added above in the same action$/ do
  pending
end

Then /^(a|an error) message is displayed on the time slot page.?$/ do |msgType|
  pending
end

Then /^the Time Slot edits (are|are not) saved.$/ do |areAreNot|
  pending
end