class EditAgenda < BasePage

  expected_element :update_rule_btn

  wrapper_elements
  krms_frame_elements

  element(:edit_tree_section) { |b| b.frm.div(id: "RuleStudentEditorView-Tree_tree")}
  element(:logic_tab_section) { |b| b.frm.div(id: "u438_boxLayout")}
  element(:preview_tree_section) { |b| b.frm.div(id: "u466")}

  element(:background_div) { |b| b.frm.li(:id => /^u\d+_node_0_parent_root$/)}
  element(:logic_tab) { |b| b.frm.a(:text => "Edit Rule Logic")}
  element(:object_tab) { |b| b.frm.a(:text => "Edit Rule")}
  element(:logic_text) { |b| b.frm.textarea(name: "document.newMaintainableObject.dataObject.logicArea")}

  element(:add_btn) { |b| b.frm.button(:text => /Add Rule Statement/)}
  element(:group_btn) { |b| b.frm.button(:text => /Create Group/)}
  element(:update_rule_btn) { |b| b.frm.button(:text => /Update Rule/)}
  element(:down_btn) { |b| b.frm.button(:text => /Move Down/)}
  element(:up_btn) { |b| b.frm.button(:text => /Move Up/)}
  element(:left_btn) { |b| b.frm.button(:text => /Move Left/)}
  element(:right_btn) { |b| b.frm.button(:text => /Move Right/)}
  element(:preview_btn) { |b| b.frm.button(:text => /Preview Change/)}
  element(:copy_btn) { |b| b.frm.button(:text => /Copy/)}
  element(:cut_btn) { |b| b.frm.button(:text => /Cut/)}
  element(:paste_btn) { |b| b.frm.button(:text => /Paste/)}

  element(:course_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.courseInfo\.code/)}
  element(:free_text_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.termParameter/)}
end