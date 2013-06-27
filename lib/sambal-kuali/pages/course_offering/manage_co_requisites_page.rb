class ManageCORequisites < BasePage

  expected_element :cancel_update_link

  wrapper_elements
  krms_frame_elements

  element(:rule_maintenance_section) { |b| b.frm.div(id: "KSCO-RuleMaintenance-Page")}
  element(:tab_section) { |b| b.frm.div(id: "KSCO-RuleEdit-TabSection_tabs")}
  element(:edit_tree_section) { |b| b.frm.div(id: "KRMS-RuleEditor-TreeGroup")}
  element(:logic_tab_section) { |b| b.frm.div(id: "KSCO-EditWithLogic-EditGroup")}
  element(:preview_tree_section) { |b| b.frm.div(id: "KSCO-LogicPreview-Tree")}
  element(:compare_rule_section) { |b| b.frm.div(id: "compareRuleLightBox")}
  element(:preview_rule_section) { |b| b.frm.div(id: "KSCO-RulePreview-ActionLinks")}

  element(:background_div) { |b| b.frm.li(:id => /^u\d+_node_0_parent_root$/)}
  element(:logic_tab) { |b| b.tab_section.a(:text => /Edit Rule Logic/)}
  element(:object_tab) { |b| b.tab_section.a(:text => /Edit Rule/)}
  element(:logic_text) { |b| b.tab_section.text_field(id: "KRMS-LogicArea-InputField_control")}

  action(:add_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-AddButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:edit_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-EditButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:group_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-GroupButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:down_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-DownButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:up_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-UpButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:left_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-LeftButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:right_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-RightButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:preview_btn) { |b| b.frm.button(:text => /Preview Change/).click; b.edit_loading.wait_while_present; b.loading.wait_while_present(60)}
  action(:copy_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-CopyButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:cut_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-CutButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:paste_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-PasteButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:del_btn) { |b| b.frm.button(id: "KRMS-RuleEditorView-DeleteButton").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:add_line_btn) { |b| b.frm.button(:text => /add/).click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:delete_line_btn) { |b| b.frm.button(:text => /delete/).click; b.edit_loading.wait_while_present; b.loading.wait_while_present}
  action(:update_rule_btn) { |b| b.frm.button(id: "update-button").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}

  element(:right_btn_element) { |b| b.frm.button(id: "KRMS-RuleEditorView-RightButton") }
  element(:cancel_update_link) { |b| b.frm.a(id: "cancel-button")}

  action(:search_link) { |b| b.edit_tree_section.a(:text => /Advanced Search/).click; b.edit_loading.wait_while_present; b.loading.wait_while_present}

  element(:rule_dropdown) { |b| b.edit_tree_section.select(:name => /.*editTree.*proposition.typeId/)}
  element(:multi_course_dropdown) { |b| b.edit_tree_section.select(:name => /.*editTree.*proposition.multipleCourseType/)}
  element(:course_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.courseInfo\.code/)}
  element(:free_text_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.termParameter/)}
  element(:courses_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.cluSet\.clus\'\]\.code/)}
  element(:integer_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.parameters\[1\]\.value/)}
  element(:grade_dropdown) { |b| b.frm.select(:name => /.*editTree.*proposition\.termParameter/)}
  element(:duration_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.duration/)}
  element(:duration_dropdown) { |b| b.frm.select(:name => /.*editTree.*proposition\.durationType/)}
  element(:program_dropdown) { |b| b.frm.select(:name => /.*editTree.*proposition\.programType/)}
  element(:term_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.termCode/)}
  element(:term_two_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.termCode2/)}

  element(:grade_fieldset) { |b| b.edit_tree_section.fieldset(:id => /KRMS-GradeScale-Field_node_\d+_parent_root_fieldset/)}

  element(:lookup_section) { |b| b.frm_popup.div(id: "CourseLookupView")}
  element(:lookup_results) { |b| b.frm_popup.div(id: "uLookupResults")}
  element(:lookup_course_title) { |b| b.frm_popup.text_field(name: "lookupCriteria[title]")}
  element(:lookup_course_code) { |b| b.frm_popup.text_field(name: "lookupCriteria[code]")}
  element(:lookup_description) { |b| b.frm_popup.text_field(name: "lookupCriteria[description]")}
  element(:lookup_set_name) { |b| b.frm_popup.text_field(name: "lookupCriteria[name]")}
  element(:lookup_class_standing) { |b| b.frm_popup.text_field(name: "lookupCriteria[keyword]")}
  action(:lookup_search_button) { |b| b.frm_popup.button(id: "button_search").click; b.edit_loading.wait_while_present; b.loading.wait_while_present}

  element(:info_message) { |b| b.rule_maintenance_section.li(class: "uif-infoMessageItem")}
  element(:edit_loading) { |b| b.rule_maintenance_section.image(alt: "Loading...") }
end