class ViewAcademicTerms < BasePage

  frame_element
  wrapper_elements

  action(:go_to_calendar_tab) { |b| b.frm.a(id: "ui-id-1").click; b.loading.wait_while_present}
  action(:go_to_terms_tab) { |b| b.frm.a(id: "ui-id-2").click; b.loading.wait_while_present}

  element(:acal_overview_div) { |b| b.frm.div(id: "KS-AcademicCalendar-Overview-WithoutTerms") }
  value(:acal_name) { |b| b.acal_overview_div.div(data_label: "Academic Calendar Name").span(index: 1).text }
  #value(:acal_organization) { |b| b.acal_overview_div.div(data_label: "Organization").span(index: 1).text }
  value(:acal_start_date) { |b| b.acal_overview_div.div(data_label: "Start Date").span(index: 1).text }
  value(:acal_end_date) { |b| b.acal_overview_div.div(data_label: "End Date").span(index: 1).text }

  element(:acal_term_list_div) { |b| b.frm.div(id: "acal-term") }

  def terms_div_list
    term_info_div.div(class: "uif-stackedCollectionLayout").divs(class: "uif-group uif-boxGroup uif-verticalBoxGroup uif-collectionItem uif-boxCollectionItem")
  end
  private :terms_div_list

  def term_index_by_term_type(term_type)
    acal_term_list_div.link(text: /^#{term_type}$/).id[/\d+(?=_toggle)/]
  end

  def open_term_section(term_type)
    link =  acal_term_list_div.link(text: "#{term_type}")
    if link.image.attribute_value("alt") == "collapse" then # expand means is already expanded
      link.click
    end
  end

  #def target_term_div(term_type)
  #  terms_div_list.each do |div|
  #    if (div.cells[POPULATION_NAME].text =~ /\b#{name}\b/)
  #      return div
  #    end
  #  end
  #end


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

  def term_instructional_days(term_type)
    index = term_index_by_term_type(term_type)
    acal_term_list_div.span(id: "term_instructional_days_line#{index}_control").text
  end

  def term_status(term_type)
    index = term_index_by_term_type(term_type)
    acal_term_list_div.span(class: /text-lozenge/, index: index.to_i).text
  end

  #date_group_type - instructional, registration
  def key_date_group_div(term_type, date_group_type)
    index = term_index_by_term_type(term_type)
    group_divs = acal_term_list_div.div(id: "acal-term-keydatesgroup_line#{index}").div(class: "uif-stackedCollectionLayout").divs(class: "uif-group uif-boxGroup uif-horizontalBoxGroup uif-collectionItem uif-boxCollectionItem")

    group_divs.each do |group_div |
      if (group_div.span(class: "uif-headerText-span").text.upcase ==  "#{date_group_type.upcase} KEY DATES") then
        return group_div
      end
    end
    return nil
  end



  KEY_DATE_TYPE_COL = 0
  KEY_DATE_START = 1
  KEY_DATE_END = 2

  def key_date_group_info_table(term_type, date_group_type)
    key_date_group_div(term_type, date_group_type).table
  end

  def target_key_date_row(term_type, date_group_type, key_date_type)
    row = key_date_group_info_table(term_type, date_group_type).row(text: /^\b#{key_date_type}\b$/)
  end

  def key_date_start(term_type, date_group_type, key_date_type)
    target_key_date_row(term_type, date_group_type, key_date_type).cells[KEY_DATE_START].text
  end

  def key_date_end(term_type, date_group_type, key_date_type)
    target_key_date_row.cells[KEY_DATE_END].text
  end
end