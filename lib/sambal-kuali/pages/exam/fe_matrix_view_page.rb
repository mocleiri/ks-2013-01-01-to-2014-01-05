class FEMatrixView < BasePage

  wrapper_elements
  frame_element

  element(:fe_agenda_view_page) { |b| b.frm.div( id: "KSFE-AgendaManagement-View")}
  element(:fe_agenda_maintenance_page) { |b| b.fe_agenda_view_page.div( id: "KSFE-AgendaMaintenance-Page")}

  element(:fe_matrix_criteria_section) { |b| b.fe_agenda_maintenance_page.div( id: "finalExamMatrixManagementCriteriaSection")}
  element(:term_type_select) { |b| b.fe_matrix_criteria_section.select( name: "document.newMaintainableObject.dataObject.termToUse")}

  COURSE_REQUIREMENTS = 0
  EXAM_DAY = 1
  EXAM_TIME = 2

  element(:standard_final_exam_section) { |b| b.fe_agenda_maintenance_page.div( id: "ruledefinitions_agenda0")}
  element(:standard_final_exam_table) { |b| b.standard_final_exam_section.table}
  action(:add_standard_fe_rule) { |b| b.standard_final_exam_section.a( text: "Add").click; loading.wait_while_present}

  def standard_fe_target_row( requirements)
    begin
      row = standard_final_exam_table.row(text: /^\b#{requirements}\b$/)
    rescue
      return nil
    end
    return row
  end

  def get_standard_fe_day( requirements)
    standard_fe_target_row( requirements).cells[EXAM_DAY].text
  end

  def get_standard_fe_time( requirements)
    standard_fe_target_row( requirements).cells[EXAM_TIME].text
  end

  def edit_standard( requirements)
    standard_fe_target_row( requirements).link(text: "Edit").click
    loading.wait_while_present
  end

  def delete_standard( requirements)
    standard_fe_target_row( requirements).link(text: "Delete").click
    loading.wait_while_present
  end

  element(:common_final_exam_section) { |b| b.fe_agenda_maintenance_page.div( id: "ruledefinitions_agenda1")}
  element(:common_final_exam_table) { |b| b.common_final_exam_section.table}
  action(:add_common_fe_rule) { |b| b.common_final_exam_section.a( text: "Add").click; loading.wait_while_present}

  def common_fe_target_row( requirements)
    begin
      row = common_final_exam_table.row(text: /^\b#{requirements}\b$/)
    rescue
      return nil
    end
    return row
  end

  def get_common_fe_day( requirements)
    common_fe_target_row( requirements).cells[EXAM_DAY].text
  end

  def get_common_fe_time( requirements)
    common_fe_target_row( requirements).cells[EXAM_TIME].text
  end

  def edit_common( requirements)
    common_fe_target_row( requirements).link(text: "Edit").click
    loading.wait_while_present
  end

  def delete_common( requirements)
    common_fe_target_row( requirements).link(text: "Delete").click
    loading.wait_while_present
  end
end