class ManageCOAgendas < BasePage

  expected_element :submit_btn

  wrapper_elements
  krms_frame_elements

  element(:agenda_management_section) { |b| b.frm.div(id: "KRMS-AgendaMaintenance-Page")}
  element(:rule_edit_links) { |b| b.frm.div( id: "KRSM-RuleEdit-ActionLinks")}
  element(:rule_add_link) { |b| b.frm.div( id: "KRMS-RuleAdd-ActionLink")}
  element(:preview_tree) { |b| b.frm.div(id: "KRMS-PreviewTree-Group")}

  element(:submit_btn) { |b| b.frm.button(:text => /Save/)}
  element(:cancel_btn) { |b| b.frm.button(:text => /Cancel/)}
end