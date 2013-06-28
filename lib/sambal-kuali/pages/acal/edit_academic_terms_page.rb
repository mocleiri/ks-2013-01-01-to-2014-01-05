class EditAcademicTerms < BasePage


  wrapper_elements
  frame_element

  action(:go_to_term_tab) { |b| b.frm.a(href: "#KS-AcademicTerm-EditSection_tab").click; b.loading.wait_while_present}
  action(:go_to_cal_tab) { |b| b.frm.a(href: "#acal-info_tab").click; b.loading.wait_while_present}
  element(:term_type_add)  { |b| b.frm.select(id: "term_type_add_add_control") }
  element(:term_start_date_add)  { |b| b.frm.text_field(id: "term_start_date_add_add_control") }
  element(:term_end_date_add)  { |b| b.frm.text_field(id: "term_end_date_add_add_control") }
  element(:parent_term_select)  { |b| b.frm.select(id: "parent_term_type_add") }

  action(:acal_term_add) { |b| b.frm.button(id: "acal-term_add").click; b.loading.wait_while_present }

  element(:acal_term_list_div) { |b| b.frm.div(id: "acal-term")  }

  action(:get_term_index) { |term_name, b| b.acal_term_list_div.text_field(value: "#{term_name}").name[/\d+/]}

  def term_index_by_term_type(term_type)
    acal_term_list_div.link(text: /^#{term_type}$/).id[/\d+(?=_toggle)/]
  end

  def open_term_section(term_type)
    link =  acal_term_list_div.link(text: "#{term_type}")
    if link.image.attribute_value("alt") == "collapse" then # expand means is already expanded
      link.click
    end
  end

  #def open_keydates_section(term_type)
  #  open_term_section(term_type)
  #  term_index = term_index_by_term_type(term_type)
  #  puts "term_index #{term_index}"
  #  link = acal_term_list_div.link(id: "acal-term-keydatesgroup_line#{term_index}_toggle")
  #  if link.image.attribute_value("alt") == "collapse" then #/expand
  #    link.click
  #  end
  #end

  def key_date_group_list_parent(term_type)
    term_index = term_index_by_term_type(term_type)
    acal_term_list_div.div(id: "acal-term-keydatesgroup_line#{term_index}").div(class: "uif-stackedCollectionLayout")
  end

  def key_date_group_div_list(term_type)
    key_date_group_list_parent(term_type).divs(class: "uif-group uif-boxGroup uif-horizontalBoxGroup uif-collectionItem uif-boxCollectionItem")
  end

  def key_date_group_div(term_type, key_date_group_type)
    key_date_group_div_list(term_type).each do | div |
      if div.span(text: /#{key_date_group_type.upcase} KEY DATES/ ).exists?
        return div
      end
    end
    return nil
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
  IS_ALL_DAY_COL = 7
  IS_DATE_RANGE_COL = 8
  ACTION_COL = 9

  def edit_key_date_start_date(row, value); row.cells[START_DATE_COL].text_field.set(value); end
  def edit_key_date_start_time(row, value); row.cells[START_TIME_COL].text_field.set(value); end
  def edit_key_date_start_ampm(row, value); row.cells[START_AMPM_COL].select.select(value.downcase); end
  def edit_key_date_end_date(row, value); row.cells[END_DATE_COL].text_field.set(value); end
  def edit_key_date_end_time(row, value); row.cells[END_TIME_COL].text_field.set(value); end
  def edit_key_date_end_ampm(row, value); row.cells[END_AMPM_COL].select.select(value.downcase); end
  def clear_key_date_is_all_day(row); row.cells[IS_ALL_DAY_COL].checkbox.clear; end
  def set_key_date_is_all_day(row); row.cells[IS_ALL_DAY_COL].checkbox.set; end
  def clear_key_date_is_range(row); row.cells[IS_DATE_RANGE_COL].checkbox.clear; end
  def set_key_date_is_range(row); row.cells[IS_DATE_RANGE_COL].checkbox.set; end
  def delete_key_date(row); row.cells[ACTION_COL].link(text: "delete").click; end

  def key_date_start_date(row); row.cells[START_DATE_COL].text_field.value; end
  def key_date_start_time(row); row.cells[START_TIME_COL].text_field.value; end
  def key_date_start_ampm(row); row.cells[START_AMPM_COL].select.selected_options[0]; end
  def key_date_end_date(row); row.cells[END_DATE_COL].text_field.value; end
  def key_date_end_time(row); row.cells[END_TIME_COL].text_field.value; end
  def key_date_end_ampm(row); row.cells[END_AMPM_COL].select.selected_options[0]; end
  def key_date_is_all_day(row); row.cells[IS_ALL_DAY_COL].checkbox.checked?; end
  def key_date_is_range(row); row.cells[IS_DATE_RANGE_COL].checkbox.checked?; end



  #action(:key_date_type) { |term_index, key_date_group_index, key_date_index, b| b.frm.div(id: "key_date_type_line#{term_index}_line#{key_date_group_index}_line#{key_date_index}").span(index: 0).text}
  #action(:key_date_start_date) { |term_index, key_date_group_index, key_date_index, b| b.frm.text_field(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].startDate").value}
  #action(:key_date_end_date) { |term_index, key_date_group_index, key_date_index, b| b.frm.text_field(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].endDate").value}
  #action(:key_date_starttime) { |term_index, key_date_group_index, key_date_index, b| b.frm.text_field(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].startTime").value}
  #action(:key_date_endtime) { |term_index, key_date_group_index, key_date_index, b| b.frm.text_field(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].endTime").value}
  #action(:key_date_starttimeampm) { |term_index, key_date_group_index, key_date_index, b| b.frm.select(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].startTimeAmPm").value}
  #action(:key_date_endtimeampm) { |term_index, key_date_group_index, key_date_index, b| b.frm.select(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].endTimeAmPm").value}
  #action(:key_date_allday) { |term_index, key_date_group_index, key_date_index, b| b.frm.checkbox(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].allDay").checked?}
  #action(:key_date_daterange) { |term_index, key_date_group_index, key_date_index, b| b.frm.checkbox(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].dateRange").checked?}

  #action(:key_date_start_date_edit) { |term_index, key_date_group_index, key_date_index, b| b.frm.text_field(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].startDate")}
  #action(:key_date_end_date_edit) { |term_index, key_date_group_index, key_date_index, b| b.frm.text_field(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].endDate")}
  #action(:key_date_starttime_edit) { |term_index, key_date_group_index, key_date_index, b| b.frm.text_field(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].startTime")}
  #action(:key_date_endtime_edit) { |term_index, key_date_group_index, key_date_index, b| b.frm.text_field(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].endTime")}
  #action(:key_date_starttimeampm_edit) { |term_index, key_date_group_index, key_date_index, b| b.frm.select(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].startTimeAmPm")}
  #action(:key_date_endtimeampm_edit) { |term_index, key_date_group_index, key_date_index, b| b.frm.select(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].endTimeAmPm")}
  #action(:key_date_allday_edit) { |term_index, key_date_group_index, key_date_index, b| b.frm.checkbox(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].allDay")}
  #action(:key_date_daterange_edit) { |term_index, key_date_group_index, key_date_index, b| b.frm.checkbox(name: "termWrapperList[#{term_index}].keyDatesGroupWrappers[#{key_date_group_index}].keydates[#{key_date_index}].dateRange")}

  action(:get_term_type) { |term_index,b| b.frm.text_field(name: "termWrapperList[#{term_index}].name").value }
  action(:get_term_start_date) { |term_index,b| b.frm.text_field(name: "termWrapperList[#{term_index}].startDate").value }
  action(:get_term_end_date) { |term_index,b| b.frm.text_field(name: "termWrapperList[#{term_index}].endDate").value }

  action(:term_make_official_button) { |term_index,b| b.frm.button(id: "term_official_button_line#{term_index}").text}
  action(:term_make_official_enabled) { |term_index,b| b.frm.button(id: "term_official_button_line#{term_index}").enabled?}
  action(:make_term_official) { |term_index,b| b.frm.button(id: "term_official_button_line#{term_index}").click; b.loading.wait_while_present(300)}

  action(:key_date_exist) { |term_index, key_date_group_index, key_date_index, b| b.frm.div(id: "key_date_type_line#{term_index}_line#{key_date_group_index}_line#{key_date_index}").span(index: 0).exists?}

  action(:delete_term) { |term_index,b| b.frm.a(id: "term_delete_button_line#{term_index}").click; b.loading.wait_while_present}

  action(:get_key_date_group_index) { |group_name, b| b.frm.div(text:"#{group_name}").span(index:0).id}

  element(:sticky_footer_div) { |b| b.frm.div(class: "uif-footer uif-stickyFooter uif-stickyButtonFooter") } # Persistent ID needed!
  action(:save) { |b| b.sticky_footer_div.button(text: "Save").click; b.loading.wait_while_present } # Persistent ID needed!
  action(:cancel) { |b| b.sticky_footer_div.link(text: "Cancel").click }

end

