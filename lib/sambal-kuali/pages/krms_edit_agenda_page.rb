class EditAgenda < BasePage

  expected_element :update_btn

  wrapper_elements
  krms_frame_elements

  element(:edit_tree_section) { |b| b.frm.div(id: "RuleStudentEditorView-Tree_tree")}
  element(:logic_tab_section) { |b| b.frm.div(id: "u438_boxLayout")}
  element(:preview_tree_section) { |b| b.frm.div(id: "u466")}

  element(:background_div) { |b| b.frm.li(:id => /^u\d+_node_0_parent_root$/)}
  element(:logic_tab) { |b| b.frm.a(:text => "Edit with Logic")}
  element(:logic_text) { |b| b.frm.textarea(name: "document.newMaintainableObject.dataObject.logicArea")}

  element(:add_btn) { |b| b.frm.button(id: "u198")}
  element(:group_btn) { |b| b.frm.button(id: "u202")}
  element(:update_btn) { |b| b.frm.button(id: "update-button")}
end