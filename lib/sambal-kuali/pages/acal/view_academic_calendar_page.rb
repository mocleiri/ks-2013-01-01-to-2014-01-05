class ViewAcademicCalendar < BasePage

  frame_element
  wrapper_elements

  action(:go_to_calendar_tab) { |b| b.frm.a(id: "ui-id-1").click; b.loading.wait_while_present}
  action(:go_to_terms_tab) { |b| b.frm.a(id: "ui-id-2").click; b.loading.wait_while_present}

  element(:acal_overview_div) { |b| b.frm.div(id: "KS-AcademicCalendar-Overview-WithoutTerms") }
  value(:acal_name) { |b| b.acal_overview_div.div(data_label: "Academic Calendar Name").span(index: 1).text }
  value(:acal_start_date) { |b| b.acal_overview_div.div(data_label: "Start Date").span(index: 1).text }
  value(:acal_end_date) { |b| b.acal_overview_div.div(data_label: "End Date").span(index: 1).text }

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
  element(:acal_term_list_div) { |b| b.frm.div(id: "acal-term") }
  element(:acal_event_list_div) { |b| b.frm.div(id: "acal-info-event") }
  element(:acal_event_list_link) { |b| b.acal_event_list_div.link(text: "Events") }
  element(:calendar_events_table) { |b| b.acal_event_list_div.table }

  def terms_div_list
    term_info_div.div(class: "uif-stackedCollectionLayout").divs(class: "uif-group uif-boxGroup uif-verticalBoxGroup uif-collectionItem uif-boxCollectionItem")
  end
  private :terms_div_list

  def term_index_by_term_type(term_type)
    acal_term_list_div.link(text: /^#{term_type}$/).id[/\d+(?=_toggle)/]
  end

  def open_event_section
    link =  acal_event_list_link
    if link.image.attribute_value("alt") == "collapse" then # expand means is already expanded
      link.click
    end
  end


  def term_name(term_type)
    index = term_index_by_term_type(term_type)
    acal_term_list_div.span(id: "term_name_line#{index}_control").text
  end

  def term_code(term_type)
    index = term_index_by_term_type(term_type)
    acal_term_list_div.span(id: "term_code_line#{index}_control").text
  end

  def term_start_date(term_type)
    index = term_index_by_term_type(term_type)
    acal_term_list_div.span(id: "term_start_date_line#{index}_control").text
  end

  def term_end_date(term_type)
    index = term_index_by_term_type(term_type)
    acal_term_list_div.span(id: "term_end_date_line#{index}_control").text
  end

  def term_status(term_type)
    index = term_index_by_term_type(term_type)
    acal_term_list_div.span(class: /text-lozenge/, index: index.to_i).text
  end


  #identify the row containing this event
  def target_event_row(event_name)
    calendar_events_table.rows.each do |row|
      if row.cells[EVENT_COL].text == event_name then
        return row
      end
    end
    return nil
  end

  EVENT_COL = 0
  START_DATE_COL = 1
  END_DATE_COL = 2

  def check_start_end_date(row, start_date, end_date)
    calendar_events_table.row.cells[START_DATE_COL].text == start_date &&
        calendar_events_table.row.cells[END_DATE_COL].text == end_date
  end

end
