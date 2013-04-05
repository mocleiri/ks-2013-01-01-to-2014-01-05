class EditAgenda < BasePage

  expected_element :submit_btn

  wrapper_elements
  krms_frame_elements

  element(:edit_tree_section) { |b| b.frm.div(id: "RuleStudentEditorView-Tree_tree")}
  element(:logic_tab_section) { |b| b.frm.div(id: "u100383")}
  element(:preview_tree_section) { |b| b.frm.div(id: "u100419")}

  element(:background_div) { |b| b.frm.li(id: "u100200_node_0_parent_root")}
  element(:logic_tab) { |b| b.frm.a(:text => "Edit with Logic")}
  element(:logic_text) { |b| b.frm.textarea(id: "u100400_control")}

  element(:add_btn) { |b| b.frm.button(id: "u100151")}
  element(:group_btn) { |b| b.frm.button(id: "u100155")}
  element(:update_btn) { |b| b.frm.button(id: "update-button")}
  element(:submit_btn) { |b| b.frm.button(id: "u100013")}
end