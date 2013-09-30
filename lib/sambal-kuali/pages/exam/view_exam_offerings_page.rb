class ViewExamOfferings < BasePage

  wrapper_elements
  frame_element

  element(:exam_offerings_page_section) { |b| b.frm.div(id: "viewExamOfferingsPage")}

  ############## Course Offering page for View Exam Offerings ####################
  element(:eo_by_co_table_section) { |b| b.frm.div(id: "KS-CourseOfferingManagement-ExamOfferingByCOTableSection")}
  value(:co_table_header_text) { |b| b.eo_by_co_table_section.span(class: "uif-headerText-span").text}

  CO_STATUS = 0
  CO_DAYS = 1
  CO_ST_TIME = 2
  CO_END_TIME = 3
  CO_BLDG = 4
  CO_ROOM = 5

  def eo_by_co_results_table
    return eo_by_co_table_section.table unless !eo_by_co_table_section.table.exists?
  end

  def eo_by_co_target_row
    row = eo_by_co_results_table.rows[1]
    return row unless row.nil?
  end

  def eo_by_co_status
    eo_by_co_target_row.cells[CO_STATUS].text
  end

  ############## Activity Offering page for View Exam Offerings ####################
  element(:eo_by_ao_table_section) { |b| b.frm.div(id: "KS-CourseOfferingManagement-ExamOfferingByAOTableSection")}
  value(:ao_table_header_text) { |b| b.eo_by_ao_table_section.span(class: "uif-headerText-span").text}

  AO_STATUS = 0
  AO_CODE = 1
  AO_DAYS = 2
  AO_ST_TIME = 3
  AO_END_TIME = 4
  AO_BLDG = 5
  AO_ROOM = 6

  def eo_by_ao_results_table
    return eo_by_ao_table_section.table unless !eo_by_ao_table_section.table.exists?
    end

  def view_eo_by_ao(code)
    view_eo_by_ao_link(code).click
    loading.wait_while_present
  end

  def view_eo_by_ao_link(code)
    eo_by_ao_results_table.link(text: code)
  end

  def eo_by_ao_target_row(code)
    row = eo_by_ao_results_table.row(text: /\b#{Regexp.escape(code)}\b/)
    return row unless row.nil?
    raise "error in target_row: #{code} not found"
  end

  def eo_by_ao_status(code)
    eo_by_ao_target_row(code).cells[AO_STATUS].text
  end
end