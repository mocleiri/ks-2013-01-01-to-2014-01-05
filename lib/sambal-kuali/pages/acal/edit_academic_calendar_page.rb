class EditAcademicCalendar < BasePage

  expected_element :header_calendar_name

  wrapper_elements
  frame_element

  element(:header_calendar_name) { |b| b.frm.div(class: "ks-unified-header ks-unified-header").h1.span}

  element(:page_validation_list_exists) { |b| b.frm.ul(id: "pageValidationList").exists?}
  element(:page_error_message_exists) { |b| b.frm.ul(id: "pageValidationList").li(class: "uif-errorMessageItem").exists?}
  element(:page_info_message) { |b| b.frm.ul(id: "pageValidationList").exists? and b.frm.ul(id: "pageValidationList").li(class: "uif-infoMessageItem").exists?}
  value(:page_info_message_text) { |b| b.frm.ul(id: "pageValidationList").li(class: "uif-infoMessageItem").text}
  action(:calendar_tab) { |b| b.frm.link(text: "Calendar").click }
  action(:terms_tab) { |b| b.frm.link(text: "Terms").click }
  
  element(:academic_calendar_name) { |b| b.frm.text_field(name: "academicCalendarInfo.name") }
  element(:calendar_start_date) { |b| b.frm.text_field(name: "academicCalendarInfo.startDate") }
  element(:calendar_end_date) { |b| b.frm.text_field(name: "academicCalendarInfo.endDate") }

  action(:event_toggle) { |b| b.frm.link(id: "acal-info-event_toggle").click; sleep 1 }

  element(:event_type) { |b| b.frm.select(name: "newCollectionLines['events'].eventTypeKey") }
  element(:event_start_date) { |b| b.frm.text_field(name: "newCollectionLines['events'].startDate") }
  element(:event_end_date) { |b| b.frm.text_field(name: "newCollectionLines['events'].endDate") }
  element(:event_start_time) { |b| b.frm.text_field(name: "newCollectionLines['events'].startTime") }
  element(:event_end_time) { |b| b.frm.text_field(name: "newCollectionLines['events'].endTime") }
  element(:event_start_ampm) { |b| b.frm.select(name: "newCollectionLines['events'].startTimeAmPm") }
  element(:event_end_ampm) { |b| b.frm.select(name: "newCollectionLines['events'].endTimeAmPm") }
  element(:all_day) { |b| b.frm.checkbox(name: "newCollectionLines['events'].allDay") }
  element(:date_range) { |b| b.frm.checkbox(name: "newCollectionLines['events'].dateRange") }
  element(:add_event) { |b| b.frm.link(id: "acal-info-event_add") }
  #element(:delete_event_0) { |b| b.frm.button(id: "acal-info-event_del_line0") } # Note that there can be multiple Deletes on the page (= to however many events have already been added)
  #element(:delete_event_1) { |b| b.frm.button(id: "acal-info-event_del_line1") }
  #element(:delete_event_2) { |b| b.frm.button(id: "acal-info-event_del_line2") }
  element(:acal_event_list_div) { |b| b.frm.div(id: "acal-info-event") }
  element(:acal_event_list_link) { |b| b.acal_event_list_div.link(text: "Events") }
  element(:calendar_events_table) { |b| b.acal_event_list_div.table }

  element(:make_official_link) { |b| b.frm.link(id: "acal_Official") }
  action(:make_official) { |b| b.make_official_link.click; b.loading.wait_while_present }

  def save
    sticky_footer_div.button(text: "Save").click
    loading.wait_while_present
    growl_div.wait_until_present
    raise "save was not successful - growl text #{growl_text}" unless growl_text.match /saved successfully/
    growl_div.div(class: "jGrowl-close").click
  end

  element(:sticky_footer_div) { |b| b.frm.div(class: "ks-uif-footer uif-stickyFooter uif-stickyButtonFooter") } # Persistent ID needed!

  action(:delete_draft) { |b| b.sticky_footer_div.link(text: "Delete Calendar Draft").click; b.loading.wait_while_present } # Persistent ID needed!
  action(:cancel) { |b| b.sticky_footer_div.link(text: "Cancel").click }

  ###### confirm make official dialog
  element(:make_official_dialog_div) { |b| b.frm.div(id: "KS-AcademicCalendar-ConfirmCalendarOfficial-Dialog") }
  action(:make_offical_confirm) { |b| b.make_official_dialog_div.radio(index: 0).click; b.loading.wait_while_present }
  action(:make_offical_cancel) { |b| b.make_official_dialog_div.radio(index: 1).click ; b.loading.wait_while_present}
  ########

  ###### confirm delete dialog
  element(:delete_dialog_div) { |b| b.frm.div(id: "KS-AcademicCalendar-ConfirmDelete-Dialog") }
  action(:confirm_delete) { |b| b.delete_dialog_div.radio(index: 0).click; b.loading.wait_while_present }
  action(:cancel_delete) { |b| b.delete_dialog_div.radio(index: 1).click ; b.loading.wait_while_present}
  ########

  element(:add_holiday_calendar_div) { |b| b.frm.div(id: "acal-holidays_disclosureContent") }
  element(:add_holiday_calendar_select) { |b| b.add_holiday_calendar_div.select }
  element(:add_holiday_calendar_button) { |b| b.add_holiday_calendar_div.button(id: "acal-holidays_add") }
  action(:add_holiday_calendar)  { |b| b.add_holiday_calendar_button.click; b.loading.wait_while_present }

  def edit_start_date(row, value); row.cells[EDIT_START_DATE_COL].text_field.set(value); end
  def edit_start_time(row, value); row.cells[EDIT_START_TIME_COL].text_field.set(value); end
  def edit_start_ampm(row, value); row.cells[EDIT_START_TIME_AMPM_COL].select.select(value.downcase); end
  def edit_end_date(row, value); row.cells[EDIT_END_DATE_COL].text_field.set(value); end
  def edit_end_time(row, value); row.cells[EDIT_END_TIME_COL].text_field.set(value); end
  def edit_end_ampm(row, value); row.cells[EDIT_END_TIME_AMPM_COL].select.select(value.downcase); end
  def clear_is_all_day(row); row.cells[EDIT_ALL_DAY_COL].checkbox.clear; end
  def set_is_all_day(row); row.cells[EDIT_ALL_DAY_COL].checkbox.set; end
  def clear_is_range(row); row.cells[EDIT_DATE_RANGE_COL].checkbox.clear; end
  def set_is_range(row); row.cells[EDIT_DATE_RANGE_COL].checkbox.set; end
  def delete(row); row.cells[EDIT_ACTION_COL].button(id: /acal-info-event_del_line*/).click; end

  #identify the row containing this event
  def target_event_row_in_edit(event_name)
    calendar_events_table.rows.each do |row|
      if row.cells[EDIT_EVENT_COL].text == event_name then
        return row
      end
    end
    return nil
  end

  EDIT_EVENT_COL = 0
  EDIT_START_DATE_COL = 1
  EDIT_START_TIME_COL = 2
  EDIT_START_TIME_AMPM_COL = 3
  EDIT_END_DATE_COL = 4
  EDIT_END_TIME_COL = 5
  EDIT_END_TIME_AMPM_COL = 6
  EDIT_ALL_DAY_COL = 7
  EDIT_DATE_RANGE_COL = 8
  EDIT_ACTION_COL = 9

  def holiday_cal_index_by_name(cal_name)
    add_holiday_calendar_div.link(text: /^#{cal_name}$/).id[/\d+(?=_toggle)/]
  end

  def delete_holiday_cal(cal_name)
    hcal_index = holiday_cal_index_by_name(cal_name)
    #            need persistent id:
    add_holiday_calendar_div.div(id: "u644_line#{hcal_index}").link(text: /Delete/).click
    loading.wait_while_present
  end

end