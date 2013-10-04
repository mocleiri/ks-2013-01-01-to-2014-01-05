class TimeSlotMaintenance < BasePage

  wrapper_elements
  frame_element


  element(:time_slot_error_message) { |b| b.frm.div(id: "timeSlotPage").li(class: "uif-errorMessageItem") }

  element(:time_slot_type_selector_div) { |b| b.frm.div(id: "TimeSlotTypeSelect-Section") }
  element(:time_slot_type_selector_list) { |b| b.time_slot_type_selector_div.select_list }
  action(:show_time_slots) { |b| b.time_slot_type_selector_div.button(text: "Show Time Slots").click; b.loading.wait_while_present }

  element(:time_slot_toolbar_div) { |b| b.frm.div(id: "TimeSlotToolBar-Section") }
  action(:initiate_add_time_slot) { |b| b.time_slot_toolbar_div.button(text: "Add Time Slot").click }

  element(:add_time_slot_popup_field_termType) { |b| b.frm.div(id: "addOrEditTermKey").select_list }
  element(:add_time_slot_popup_field_days) { |b| b.frm.div(id: "addOrEditDays").text_field }
  element(:add_time_slot_popup_field_startTime) { |b| b.frm.div(id: "addOrEditStartTime").text_field }
  element(:add_time_slot_popup_field_startTime_am_pm) { |b| b.frm.div(id: "addOrEditStartTimeAmPm").select_list }
  element(:add_time_slot_popup_field_endTime) { |b| b.frm.div(id: "addOrEditEndTime").text_field }
  element(:add_time_slot_popup_field_endTime_am_pm) { |b| b.frm.div(id: "addOrEditEndTimeAmPm").select_list }
  action(:save_add_time_slot) { |b| b.frm.button(id: "addOrEdit_action").click; b.loading.wait_while_present }

  element(:time_slot_search_results_table) { |b| b.frm.div(id: "TimeSlotSearchResultsDisplayTable").table() }

  TIME_SLOT_RESULTS_SELECT = 0
  TIME_SLOT_RESULTS_CODE = 1
  TIME_SLOT_RESULTS_TERM_TYPE = 2
  TIME_SLOT_RESULTS_DAYS = 3
  TIME_SLOT_RESULTS_START_TIME = 4
  TIME_SLOT_RESULTS_END_TIME = 5
  TIME_SLOT_RESULTS_ACTIONS = 6

  def select_time_slot_types( array_of_time_slot_types_to_select )
    array_of_time_slot_types_to_select.each do |time_slot_type_to_select|
      time_slot_type_selector_list.select time_slot_type_to_select
    end
  end

  def get_time_slot_code_list
    time_slot_code_list = []
    time_slot_search_results_table.rows.each_with_index do |row, index|
      time_slot_code_list << row[TIME_SLOT_RESULTS_CODE].text unless index == 0 || index == time_slot_search_results_table.rows.length-1
    end
    time_slot_code_list
  end

  def target_results_row(code)
    row = time_slot_search_results_table.row(text: /\b#{Regexp.escape(code)}\b/)
    return row unless row.nil?
    raise "error in target_time_slot_results_row: #{code} not found"
  end

  def add_new_time_slot(new_time_slot)
    original_time_slots = time_slot_search_results_table.to_a

    initiate_add_time_slot
    add_time_slot_popup_field_termType.select new_time_slot.term_type
    add_time_slot_popup_field_days.set new_time_slot.days
    add_time_slot_popup_field_startTime.set new_time_slot.start_time
    add_time_slot_popup_field_startTime_am_pm.select new_time_slot.start_time_am_pm.downcase
    add_time_slot_popup_field_endTime.set new_time_slot.end_time
    add_time_slot_popup_field_endTime_am_pm.select new_time_slot.end_time_am_pm.downcase
    save_add_time_slot

    if time_slot_error_message.exists?
      raise "Error adding new time-slot -> " << time_slot_error_message.text
    end

    # return the newly-added timeslot-code
    newly_added_time_slot = time_slot_search_results_table.to_a - original_time_slots
    if newly_added_time_slot.length < 1
      raise "Unable to find newly-added time-slot in results table"
    elsif newly_added_time_slot.length > 1
      raise "Unexpectedly found more than 1 newly-added time-slot in results-table; found -> " << newly_added_time_slot.join(",")
    end
    newly_added_time_slot[0][TIME_SLOT_RESULTS_CODE]
  end

end