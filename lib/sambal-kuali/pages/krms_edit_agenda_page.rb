class EditAgenda < BasePage

  expected_element :tree_section

  wrapper_elements
  krms_frame_element

  element(:tree_section) { |b| b.frm.div(id: "RuleStudentEditorView-Tree_tree")}
  element(:background_div) { |b| b.frm.li(id: "u100200_node_0_parent_root")}
  #element(:add_btn) { |b| b.frm.button(id: "u100194")}
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
end