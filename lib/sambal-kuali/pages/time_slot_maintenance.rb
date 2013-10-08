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

  action(:initiate_delete) { |b| b.time_slot_toolbar_div.button(text: "Delete").click }
  element(:delete_confirmation_dialog) { |b| b.frm.div(id: "deleteTimeSlotsConfirmationDialog") }
  action(:confirm_delete) { |b| b.delete_confirmation_dialog.radio(value: "Y").click; b.loading.wait_while_present }

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
    row = time_slot_search_results_table.row(text: /\b#{Regexp.escape(code.to_s)}\b/)
    return row unless row.nil?
    raise "error in target_time_slot_results_row: #{code} not found"
  end

  def add_new_time_slot(new_time_slot)
    original_time_slots = time_slot_search_results_table.to_a

    add_time_slot_without_validation(new_time_slot)

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

  def add_time_slot_without_validation(new_time_slot)
    initiate_add_time_slot
    add_time_slot_popup_field_termType.select new_time_slot.term_type
    add_time_slot_popup_field_days.set new_time_slot.days
    add_time_slot_popup_field_startTime.set new_time_slot.start_time
    add_time_slot_popup_field_startTime_am_pm.select new_time_slot.start_time_am_pm.downcase
    add_time_slot_popup_field_endTime.set new_time_slot.end_time
    add_time_slot_popup_field_endTime_am_pm.select new_time_slot.end_time_am_pm.downcase
    save_add_time_slot
  end

  def delete_time_slot (code)
    row = target_results_row(code)
    row.cells[TIME_SLOT_RESULTS_SELECT].checkbox.set
    initiate_delete
    sleep(1)
    confirm_delete
  end
  # note: current impl does not actually verify that the times returned are unused; it merely takes the start_time of
  # the last row in the table, and then returns a start_time 1min later and an end_time 5min after that
  #
  # ie: if the start_time in the last row is "02:00 PM" then this method will return -> [ "02:01 AM", "02:06AM"]
  def generate_unused_start_and_end_times

    # capture the start time from the last row in the table (as strings)
    table_array = time_slot_search_results_table.to_a
    last_row_start_time = table_array[table_array.length-2][TIME_SLOT_RESULTS_START_TIME]
    last_row_hour = last_row_start_time.split(" ")[0].split(":")[0]
    last_row_minute = last_row_start_time.split(" ")[0].split(":")[1]
    last_row_am_pm = last_row_start_time.split(" ")[1]

    # convert the hour to mil-time
    if last_row_am_pm == "PM"
      last_row_hour = last_row_hour.to_i + 12
      if last_row_hour > 23
        last_row_hour = 0
      end
    end

    # build the new times (year is required but unused) -> YYYY,MM,DD,HR,MIN,SEC)
    start_time = Time.local(2013, nil, nil, last_row_hour, last_row_minute, nil)
    start_time = start_time + (60 * 1)  #increments by 1 minute
    end_time = start_time + (60 * 5)    #increments by 5 minutes

    # START_TIME: convert back to strings
    return_start_time_hr = start_time.hour
    return_start_time_mn = start_time.min
    return_start_time_am_pm = "AM"
    if return_start_time_hr == 0
      return_start_time_hr = 12
    elsif return_start_time_hr > 12
      return_start_time_hr = return_start_time_hr - 12
      return_start_time_am_pm = "PM"
    end
    return_start_time_hr = return_start_time_hr.to_s
    if return_start_time_hr.length < 2
      return_start_time_hr = "0" << return_start_time_hr
    end
    return_start_time_mn = return_start_time_mn.to_s
    if return_start_time_mn.length < 2
      return_start_time_mn = "0" << return_start_time_mn
    end
    return_start_time = return_start_time_hr << ":" << return_start_time_mn << " " << return_start_time_am_pm

    # END_TIME: convert back to strings
    return_end_time_hr = end_time.hour
    return_end_time_mn = end_time.min
    return_end_time_am_pm = "AM"
    if return_end_time_hr == 0
      return_end_time_hr = 12
    elsif return_end_time_hr > 12
      return_end_time_hr = return_end_time_hr - 12
      return_end_time_am_pm = "PM"
    end
    return_end_time_hr = return_end_time_hr.to_s
    if return_end_time_hr.length < 2
      return_end_time_hr = "0" << return_end_time_hr
    end
    return_end_time_mn = return_end_time_mn.to_s
    if return_end_time_mn.length < 2
      return_end_time_mn = "0" << return_end_time_mn
    end
    return_end_time = return_end_time_hr << ":" << return_end_time_mn << " " << return_end_time_am_pm

    return [return_start_time, return_end_time]
  end

end