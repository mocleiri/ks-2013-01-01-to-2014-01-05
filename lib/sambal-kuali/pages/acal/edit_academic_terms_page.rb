class EditAcademicTerms < BasePage

  wrapper_elements
  frame_element
  include CalendarStickyFooter

  action(:go_to_terms_tab) { |b| b.frm.a(href: "#KS-AcademicTerm-EditSection_tab").click; b.loading.wait_while_present}
  action(:go_to_cal_tab) { |b| b.frm.a(href: "#acal-info_tab").click; b.loading.wait_while_present}
  element(:term_type_add)  { |b| b.frm.select(id: "term_type_add_add_control") }
  element(:term_start_date_add)  { |b| b.frm.text_field(id: "term_start_date_add_add_control") }
  element(:term_end_date_add)  { |b| b.frm.text_field(id: "term_end_date_add_add_control") }

  action(:acal_term_add) { |b| b.frm.link(id: "acal-term_add").click; b.loading.wait_while_present }

  element(:acal_term_list_div) { |b| b.frm.div(id: "acal-term")  }

  action(:get_term_index) { |term_name, b| b.acal_term_list_div.text_field(value: "#{term_name}").name[/\d+/]}

  def term_index_by_term_type(term_type)
    acal_term_list_div.link(text: /^#{term_type}$/).wait_until_present
    acal_term_list_div.link(text: /^#{term_type}$/).id[/\d+(?=_toggle)/]
  end

  def term_section_div_list
    acal_term_list_div.divs(id: /^term_section_line\d+$/)
  end

  def open_term_section(term_type)
    link =  acal_term_list_div.link(text: "#{term_type}")
    if link.image(alt: "collapse").visible? then # collapse means collapsed
      link.click
    end
  end

  def open_term_section_by_index(term_index)
    link =  div.link(id: "term_section_line#{term_index}_toggle")
    if link.image(alt: "collapse").visible? then # collapse means collapsed
      link.click
    end
  end

  def term_validation_messages(term_type)
    term_index = term_index_by_term_type(term_type)
    acal_term_list_div.div(id: "term_section_line#{term_index}_disclosureContent").ul(class: "uif-validationMessagesList").lis
  end

  def delete_term(term_type)
    term_index = term_index_by_term_type(term_type)
    puts "term_index: #{term_index}"
    acal_term_list_div.div(id: "term_section_line#{term_index}").link(text: "Delete").click
    loading.wait_while_present
    delete_confirm
  end

  ###### confirm delete dialog
  element(:delete_dialog_div) { |b| b.frm.div(id: "KS-AcademicTerm-ConfirmDelete-Dialog") }
  action(:delete_confirm) { |b| b.delete_dialog_div.radio(index: 0).click; b.loading.wait_while_present }
  action(:delete_cancel) { |b| b.delete_dialog_div.radio(index: 1).click ; b.loading.wait_while_present}
  ########

  def make_term_official(term_type)
    term_index = term_index_by_term_type(term_type)
    acal_term_list_div.link(id: "term_official_line#{term_index}").click
    loading.wait_while_present
    make_offical_confirm
  end

  ###### confirm make official dialog
  element(:parent_make_official_div) { |b| b.frm.div(class: "fancybox-wrap fancybox-desktop fancybox-type-html fancybox-opened") }
  element(:make_official_calendar_dialog_div) { |b| b.frm.parent_make_official_div.div(id: /KS-AcademicCalendar-Confirm.*Official-Dialog/) }
  action(:make_offical_confirm) { |b| b.make_official_calendar_dialog_div.radio(index: 0).click; b.loading.wait_while_present }
  action(:make_offical_cancel) { |b| b.make_official_calendar_dialog_div.radio(index: 1).click ; b.loading.wait_while_present}
  ########

  def key_date_group_list_parent(term_type)
    term_index = term_index_by_term_type(term_type)
    acal_term_list_div.div(id: "acal-term-keydatesgroup_line#{term_index}").div(class: "uif-stackedCollectionLayout")
  end

  def key_date_validation_messages(term_type)
    term_index = term_index_by_term_type(term_type)
    acal_term_list_div.div(id: "acal-term-keydatesgroup_line#{term_index}").ul(class: "uif-validationMessagesList").lis
  end

  def key_date_group_div_list(term_type)
    key_date_group_list_parent(term_type).divs(class: "uif-collectionItem uif-boxCollectionItem")
  end

  def key_date_group_div(term_type, key_date_group_type)
    key_date_group_div_list(term_type).each do | div |
      if div.span(text: /#{key_date_group_type} Key Dates/ ).exists?
        return div
      end
    end
    return nil
  end

  def key_date_group_index(term_type, key_date_group_type)
    key_date_group_div_list(term_type).each do | div |
      if div.span(text: /#{key_date_group_type} Key Dates/ ).exists?
        return div.id[/\d+$/]
      end
    end
    return nil
  end

  def delete_key_date_group(term_type, key_date_group_type)
    key_date_group_div(term_type, key_date_group_type).button(id: /key_date_group_delete_button/).click
    loading.wait_while_present
  end
  #def key_date_group_exists?(term_type, key_date_group_type)
  #  key_date_group_div_list(term_type).each do | div |
  #    if div.span(text: /#{key_date_group_type.upcase} key dates/ ).exists?
  #      return true
  #    end
  #  end
  #  return false
  #end

  #action(:open_term_section_link) {| term_type, b | b.frm.link(text: /\b#{term_type}\b/) }
  value(:get_term_name) { |index, b|  b.frm.text_field(id: "term_end_date_#{index}").text }
  action(:term_official_button) { |index, b|  b.frm.text_field(id: "term_official_button_line#{index}").click; b.loading.wait_while_present}

  #def key_date_group_list(term_type)
  #
  #end

  action(:key_date_group_dropdown) { |index, b| b.frm.select(id: "key_date_group_type_line#{index}_add_control")}


  action(:key_date_group_add) { |index, b| b.frm.button(id: "acal-term-keydatesgroup_line#{index}_add").click; b.loading.wait_while_present}

  def key_date_exists?(term_type, key_date_group_type, key_date_type)
    key_date_group_div(term_type, key_date_group_type).table.rows[2..-2].each do | row |
      if row.cells[0].text == key_date_type
        return true
      end
    end
    return false
  end

  def key_date_target_row(term_type, key_date_group_type, key_date_type)
    key_date_group_div(term_type, key_date_group_type).table.rows[2..-2].each do | row |
      if row.cells[0].text == key_date_type
        return row
      end
    end
    return nil
  end



#  def add_key_date_add_row(term_index,key_date_group);  ;end

  #KeyDates
  action(:key_date_dropdown_addline) { |term_index, key_date_group_index, b| b.frm.select(name: "newCollectionLines['termWrapperList_#{term_index}_.keyDatesGroupWrappers_#{key_date_group_index}_.keydates'].keyDateType")}
  action(:key_date_start_date_addline) { |term_index, key_date_group_index, b| b.frm.text_field(name: "newCollectionLines['termWrapperList_#{term_index}_.keyDatesGroupWrappers_#{key_date_group_index}_.keydates'].startDate")}
  action(:key_date_end_date_addline) { |term_index, key_date_group_index, b| b.frm.text_field(name: "newCollectionLines['termWrapperList_#{term_index}_.keyDatesGroupWrappers_#{key_date_group_index}_.keydates'].endDate")}
  action(:key_date_starttime_addline) { |term_index, key_date_group_index, b| b.frm.text_field(name: "newCollectionLines['termWrapperList_#{term_index}_.keyDatesGroupWrappers_#{key_date_group_index}_.keydates'].startTime")}
  action(:key_date_endtime_addline) { |term_index, key_date_group_index, b| b.frm.text_field(name: "newCollectionLines['termWrapperList_#{term_index}_.keyDatesGroupWrappers_#{key_date_group_index}_.keydates'].endTime")}
  action(:key_date_starttimeampm_addline) { |term_index, key_date_group_index, b| b.frm.select(name: "newCollectionLines['termWrapperList_#{term_index}_.keyDatesGroupWrappers_#{key_date_group_index}_.keydates'].startTimeAmPm")}
  action(:key_date_endtimeampm_addline) { |term_index, key_date_group_index, b| b.frm.select(name: "newCollectionLines['termWrapperList_#{term_index}_.keyDatesGroupWrappers_#{key_date_group_index}_.keydates'].endTimeAmPm")}
  action(:key_date_allday_addline) { |term_index, key_date_group_index, b| b.frm.checkbox(name: "newCollectionLines['termWrapperList_#{term_index}_.keyDatesGroupWrappers_#{key_date_group_index}_.keydates'].allDay")}
  action(:key_date_daterange_addline) { |term_index, key_date_group_index, b| b.frm.checkbox(name: "newCollectionLines['termWrapperList_#{term_index}_.keyDatesGroupWrappers_#{key_date_group_index}_.keydates'].dateRange")}

  action(:key_date_add) { |term_index, key_date_group_index, b| b.frm.link(id: "acal-term-keydates_line#{term_index}_line#{key_date_group_index}_add").click; b.loading.wait_while_present}

  KEY_DATE_TYPE_COL = 0
  START_DATE_COL = 1
  START_TIME_COL = 2
  START_AMPM_COL = 3
  END_DATE_COL = 4
  END_TIME_COL = 5
  END_AMPM_COL = 6
  ACTION_COL = 7

  def edit_key_date_start_date(row, value); row.cells[START_DATE_COL].text_field.set(value); end
  def edit_key_date_start_time(row, value); row.cells[START_TIME_COL].text_field.set(value); end
  def edit_key_date_start_ampm(row, value); row.cells[START_AMPM_COL].select.select(value.downcase); end
  def edit_key_date_end_date(row, value); row.cells[END_DATE_COL].text_field.set(value); end
  def edit_key_date_end_time(row, value); row.cells[END_TIME_COL].text_field.set(value); end
  def edit_key_date_end_ampm(row, value); row.cells[END_AMPM_COL].select.select(value.downcase); end
  #def clear_key_date_is_all_day(row); row.cells[IS_ALL_DAY_COL].checkbox.clear; end
  #def set_key_date_is_all_day(row); row.cells[IS_ALL_DAY_COL].checkbox.set; end
  #def clear_key_date_is_range(row); row.cells[IS_DATE_RANGE_COL].checkbox.clear; end
  #def set_key_date_is_range(row); row.cells[IS_DATE_RANGE_COL].checkbox.set; end
  def delete_key_date(row); row.cells[ACTION_COL].link(text: "Delete").click; end

  def key_date_start_date(row); row.cells[START_DATE_COL].text_field.value; end
  def key_date_start_time(row); row.cells[START_TIME_COL].text_field.value; end
  def key_date_start_ampm(row)
    return "" unless row.cells[START_AMPM_COL].radio.present?
    if row.cells[START_AMPM_COL].radio.set? then
      return "am"
    else
      return "pm"
    end
  end
  def key_date_end_date(row); row.cells[END_DATE_COL].text_field.value; end
  def key_date_end_time(row); row.cells[END_TIME_COL].text_field.value; end
  def key_date_end_ampm(row)
    return "" unless row.cells[START_AMPM_COL].radio.present?
    if row.cells[START_AMPM_COL].radio.set? then
      return "am"
    else
      return "pm"
    end
  end
  #def key_date_is_all_day(row); row.cells[IS_ALL_DAY_COL].checkbox.checked?; end
  #def key_date_is_range(row); row.cells[IS_DATE_RANGE_COL].checkbox.checked?; end

  action(:get_term_type) { |term_index,b| b.frm.text_field(name: "termWrapperList[#{term_index}].name").value }
  action(:get_term_start_date) { |term_index,b| b.frm.text_field(name: "termWrapperList[#{term_index}].startDate").value }
  action(:get_term_end_date) { |term_index,b| b.frm.text_field(name: "termWrapperList[#{term_index}].endDate").value }

  action(:term_name_edit) { |term_index,b| b.frm.text_field(id: "term_name_line#{term_index}_control") }
  action(:term_start_date) { |term_index,b| b.frm.text_field(id: "term_start_date_line#{term_index}_control") }
  action(:term_end_date) { |term_index,b| b.frm.text_field(id: "term_end_date_line#{term_index}_control") }

  action(:key_date_exist) { |term_index, key_date_group_index, key_date_index, b| b.frm.div(id: "key_date_type_line#{term_index}_line#{key_date_group_index}_line#{key_date_index}").span(index: 0).exists?}

  action(:get_key_date_group_index) { |group_name, b| b.frm.div(text:"#{group_name}").span(index:0).id}

  #Final Exam
  def final_exam_section( term_type)
    term_index = term_index_by_term_type( term_type)
    section = acal_term_list_div.div( id: "acal-term-examdates_line#{term_index}")
  end

  def exam_start_date( term_type); final_exam_section( term_type).text_field( name: "termWrapperList[#{term_index_by_term_type( term_type)}].examdates[0].startDate"); end
  def exam_end_date( term_type); final_exam_section( term_type).text_field( name: "termWrapperList[#{term_index_by_term_type( term_type)}].examdates[0].endDate"); end
  def exam_delete_link( term_type); final_exam_section( term_type).a( id: "exam_period_delete_link_line#{term_index_by_term_type( term_type)}_line#{term_index_by_term_type( term_type)}"); end
  def add_exam_period_btn( term_type); final_exam_section( term_type).button( id: "acal-term-examdates-add_line#{term_index_by_term_type( term_type)}"); end
  def exam_error_message( term_type); final_exam_section( term_type).li( class: "uif-errorMessageItem"); end
  def exam_warning_message( term_type); final_exam_section( term_type).li( class: "uif-warningMessageItem"); end
  def exclude_saturday_toggle( term_type); final_exam_section( term_type).checkbox( id: "exclude_Saturday_line#{term_index_by_term_type( term_type)}_line#{term_index_by_term_type( term_type)}_control"); end
  def exclude_sunday_toggle( term_type); final_exam_section( term_type).checkbox( id: "exclude_Sunday_line#{term_index_by_term_type( term_type)}_line#{term_index_by_term_type( term_type)}_control"); end

  def set_exam_start_date( term_type, date)
    loading.wait_while_present
    exam_start_date( term_type).set date
  end

  def set_exam_end_date( term_type, date)
    loading.wait_while_present
    exam_end_date( term_type).set date
  end

  def get_exam_start_date( term_type)
    loading.wait_while_present
    exam_start_date( term_type).text
  end

  def get_exam_end_date( term_type)
    loading.wait_while_present
    exam_end_date( term_type).text
  end

  def exam_delete( term_type)
    loading.wait_while_present
    term_index = term_index_by_term_type( term_type)
    exam_delete_link( term_type).click
  end

  def add_exam_period( term_type)
    loading.wait_while_present
    term_index = term_index_by_term_type( term_type)
    add_exam_period_btn( term_type).click
  end

  def get_exam_error_message( term_type)
    loading.wait_while_present
    exam_error_message( term_type).text
  end

  def get_exam_warning_message( term_type)
    loading.wait_while_present
    exam_warning_message( term_type).text
  end

  def set_exclude_saturday_toggle( term_type)
    loading.wait_while_present
    exclude_saturday_toggle( term_type).click
  end

  def set_exclude_sunday_toggle( term_type)
    loading.wait_while_present
    exclude_sunday_toggle( term_type).click
  end
end
