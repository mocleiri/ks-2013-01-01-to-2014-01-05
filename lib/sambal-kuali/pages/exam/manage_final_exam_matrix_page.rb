class ManageFEMatrix < BasePage

  wrapper_elements
  frame_element

  element(:fe_search_page) { |b| b.frm.div( id: "finalExamMatrixManagementView")}
  element(:fe_matrix_criteria_section) { |b| b.fe_search_page.div( id: "finalExamMatrixManagementCriteriaSection")}

  element(:term_type_select) { |b| b.fe_matrix_criteria_section.select( name: "type.key")}
  action(:term_type) { |b| b.term_type_select.select}
  element(:show_btn) { |b| b.fe_matrix_criteria_section.button( text: "Show")}
  action(:show) { |b| b.show_btn.click; b.loading.wait_while_present}
end