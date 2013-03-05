class EditAgenda < BasePage

  expected_element :submit_btn

  wrapper_elements
  krms_frame_element

  element(:edit_tree_section) { |b| b.frm.div(id: "RuleStudentEditorView-Tree_tree")}
  element(:logic_tab_section) { |b| b.frm.div(id: "u100383")}
  element(:preview_tree_section) { |b| b.frm.div(id: "u100419")}

  element(:background_div) { |b| b.frm.li(id: "u100200_node_0_parent_root")}
  #element(:prop_editor) { |b| b.frm.div(id: "u100243_node_2_parent_node_0_parent_root")}
  #element(:define_rule_two) { |b| b.frm.div(id: "u100251_node_2_parent_node_0_parent_root").span(class: "uif-headerText-span")}
  #element(:rule_dropdown) { |b| b.frm.select(id: "u100273_node_2_parent_node_0_parent_root_control")}
  #element(:course) { |b| b.frm.text_field(id: "u100447_node_2_parent_node_0_parent_root_control")}
  element(:logic_tab) { |b| b.frm.a(:text => "Edit with Logic")}
  element(:logic_text) { |b| b.logic_tab_section.textarea(id: "u100400_control")}

  element(:add_btn) { |b| b.frm.button(id: "u100151")}
  #element(:edit_btn) { |b| b.frm.button(id: "u100196")}
  #element(:group_btn) { |b| b.frm.button(id: "u100198")}
  #element(:mv_left_btn) { |b| b.frm.(id: "u100204")}
  #element(:mv_right_btn) { |b| b.frm.(id: "u100206")}
  #element(:mv_up_btn) { |b| b.frm.(id: "u100208")}
  #element(:mv_down_btn) { |b| b.frm.(id: "u100210")}
  #element(:copy_btn) { |b| b.frm.(id: "u100216")}
  #element(:cut_btn) { |b| b.frm.(id: "u100218")}
  #element(:paste_btn) { |b| b.frm.(id: "u100220")}
  #element(:del_btn) { |b| b.frm.(id: "u100222")}
  element(:update_btn) { |b| b.frm.button(id: "update-button")}
  element(:submit_btn) { |b| b.frm.button(id: "u100013")}
end