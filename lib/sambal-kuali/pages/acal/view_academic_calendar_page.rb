class ViewAcademicCalendar < BasePage

  frame_element
  wrapper_elements

  action(:go_to_calendar_tab) { |b| b.frm.a(id: "ui-id-1").click; b.loading.wait_while_present}
  action(:go_to_terms_tab) { |b| b.frm.a(id: "ui-id-2").click; b.loading.wait_while_present}

  element(:acal_subsection_div) { |b| b.frm.div(id: "KS-AcademicCalendar-MetaSubSection") }
  value(:acal_name) { |b| b.acal_subsection_div.div(data_label: "Academic Calendar Name").span(index: 1).text }
  value(:acal_start_date) { |b| b.acal_subsection_div.div(data_label: "Start Date").span(index: 1).text }
  value(:acal_end_date) { |b| b.acal_subsection_div.div(data_label: "End Date").span(index: 1).text }

  element(:event_type) { |b| b.frm.select(name: "newCollectionLines['events'].eventTypeKey") }
  element(:event_start_date) { |b| b.frm.text_field(name: "newCollectionLines['events'].startDate") }
  element(:event_end_date) { |b| b.frm.text_field(name: "newCollectionLines['events'].endDate") }
  element(:event_start_time) { |b| b.frm.text_field(name: "newCollectionLines['events'].startTime") }
  element(:event_end_time) { |b| b.frm.text_field(name: "newCollectionLines['events'].endTime") }
  element(:event_start_ampm) { |b| b.frm.select(name: "newCollectionLines['events'].startTimeAmPm") }
  element(:event_end_ampm) { |b| b.frm.select(name: "newCollectionLines['events'].endTimeAmPm") }

  element(:acal_event_list_div) { |b| b.frm.div(id: "acal-info-event") }
  element(:acal_event_list_link) { |b| b.link(id: "acal-info-event_toggle") }
  element(:calendar_events_table) { |b| b.acal_event_list_div.table }
  element(:acal_holiday_div) { |b| b.frm.div(id: "acal-holidays") }
  element(:hcal_name_div) { |b| b.acal_holiday_div.div(data_label: "Holiday Calendar Name") }
  value(:hcal_name_text) { |b| b.hcal_name_div.span(index: 1).text }
  value(:hcal_start_date) { |b| b.acal_holiday_div.div(data_label: "Start Date").span(index: 1).text }
  value(:hcal_end_date) { |b| b.acal_holiday_div.div(data_label: "End Date").span(index: 1).text }

  def open_events_section()
    if acal_event_list_link.image(alt: "collapse").visible? then # collapse means collapsed
      acal_event_list_link.click
      sleep 1
    end
  end

  #identify the row containing this event
  def target_event_row_in_view(event_name)
    if calendar_events_table.exists?
      calendar_events_table.rows.each do |row|
        if row.cells[VIEW_EVENT_COL].text == event_name then
          return row
        end
      end
    end
    return nil
  end

  VIEW_EVENT_COL = 0
  VIEW_START_DATE_COL = 1
  VIEW_END_DATE_COL = 2

end
