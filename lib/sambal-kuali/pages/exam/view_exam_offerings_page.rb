class ViewExamOfferings < BasePage

  wrapper_elements
  frame_element

  element(:exam_offerings_page_section) { |b| b.frm.div(id: "viewExamOfferingsPage")}

  element(:canceled_table_header_text) { |b| b.exam_offerings_page_section.span( class: "uif-headerText-span").text}
  element(:canceled_eo_table) { |b| b.exam_offerings_page_section.div( class: "dataTables_wrapper").table}

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

  def eo_by_co_days
    eo_by_co_target_row.cells[CO_DAYS].text
  end

  def eo_by_co_st_time
    eo_by_co_target_row.cells[CO_ST_TIME].text
  end

  def eo_by_co_end_time
    eo_by_co_target_row.cells[CO_END_TIME].text
  end

  def eo_by_co_bldg
    eo_by_co_target_row.cells[CO_BLDG].text
  end

  def eo_by_co_room
    eo_by_co_target_row.cells[CO_ROOM].text
  end

  def count_no_of_eos_by_co
    row_count = 0
    eo_by_co_results_table.rows.each do |row|
      if row.text !~ /^Status.*$/ and row.text != ""
        row_count += 1
      end
    end
    return "#{row_count}"
  end

  ############## Activity Offering page for View Exam Offerings ####################
  element(:eo_by_ao_table_section) { |b| b.frm.div(id: "KS-CourseOfferingManagement-ExamOfferingByAOClustersSection")}
  value(:ao_table_header_text) { |b| b.eo_by_ao_table_section.span(class: "uif-headerText-span").text}

  AO_STATUS = 0
  AO_CODE = 1
  AO_TYPE = 2
  AO_DAYS = 3
  AO_ST_TIME = 4
  AO_END_TIME = 5
  AO_BLDG = 6
  AO_ROOM = 7

  def eo_by_ao_results_table(cluster_no)
    ao_table = eo_by_ao_table_section.div( :id => /ExamOfferingByAOTableSection_line#{cluster_no}/).table
    return ao_table unless !ao_table.exists?
  end

  def view_eo_by_ao(code)
    view_eo_by_ao_link(code).click
    loading.wait_while_present
  end

  def view_eo_by_ao_link(code)
    eo_by_ao_results_table.link(text: code)
  end

  def eo_by_ao_target_row(code, cluster_no)
    row = eo_by_ao_results_table(cluster_no).row(text: /\b#{Regexp.escape(code)}\b/)
    return row unless row.nil?
    raise "error in target_row: #{code} not found"
  end

  def eo_by_ao_status(code, cluster_no)
    eo_by_ao_target_row(code, cluster_no).cells[AO_STATUS].text
  end

  def eo_by_ao_type(code, cluster_no)
    eo_by_ao_target_row(code, cluster_no).cells[AO_TYPE].text
  end

  def eo_by_ao_days(code, cluster_no)
    eo_by_ao_target_row(code, cluster_no).cells[AO_DAYS].text
  end

  def eo_by_ao_st_time(code, cluster_no)
    eo_by_ao_target_row(code, cluster_no).cells[AO_ST_TIME].text
  end

  def eo_by_ao_end_time(code, cluster_no)
    eo_by_ao_target_row(code, cluster_no).cells[AO_END_TIME].text
  end

  def eo_by_ao_bldg(code, cluster_no)
    eo_by_ao_target_row(code, cluster_no).cells[AO_BLDG].text
  end

  def eo_by_ao_room(code, cluster_no)
    eo_by_ao_target_row(code, cluster_no).cells[AO_ROOM].text
  end

  #def count_no_of_eos_by_ao
  #  row_count = 0
  #  eo_by_ao_results_table.rows.each do |row|
  #    if row.cells[AO_CODE].text =~ /^[A-Z]$/
  #      row_count += 1
  #    end
  #  end
  #  return "#{row_count}"
  #end

  def return_array_of_ao_codes(cluster_no)
    array = []
    eo_by_ao_results_table(cluster_no).rows.each do |row|
      if row.cells[AO_CODE].text =~ /^[A-Z]$/
        array << row.cells[AO_CODE].text
      end
    end
    return array
  end
end