class TimeSlotMaintenance < BasePage

  wrapper_elements
  frame_element

  expected_title /Kuali :: Time Slots/

  element(:time_slot_type_selector_div) { |b| b.frm.div(id: "TimeSlotTypeSelect-Section") }
  element(:time_slot_type_selector_list) { |b| b.time_slot_type_selector_div.select_list }
  action(:show_time_slots) { |b| b.time_slot_type_selector_div.button(text: "Show Time Slots").click; b.loading.wait_while_present }

  element(:time_slot_toolbar_div) { |b| b.frm.div(id: "TimeSlotToolBar-Section") }
  element(:add_time_slot) { |b| b.time_slot_toolbar_div.button(text: "Add Time Slot").click }

  element(:time_slot_search_results_table) { |b| b.frm.div(id: "TimeSlotSearchResultsDisplayCheckBoxes").table() }

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

  def target_results_row(code)
    row = time_slot_search_results_table.row(text: /\b#{Regexp.escape(code)}\b/)
    return row unless row.nil?
    raise "error in target_time_slot_results_row: #{code} not found"
  end

end