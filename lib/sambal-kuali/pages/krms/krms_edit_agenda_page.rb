class EditAgenda < BasePage

  expected_element :object_tab

  wrapper_elements
  krms_frame_elements

  element(:rule_maintenance_section) { |b| b.frm.div(id: "KRMS-RuleMaintenance-Page")}
  element(:edit_tree_section) { |b| b.frm.div(id: "RuleStudentEditorView-Tree_tree")}
  element(:logic_tab_section) { |b| b.frm.div(id: "u438_boxLayout")}
  element(:preview_tree_section) { |b| b.frm.div(id: "u466")}
  element(:compare_rule_section) { |b| b.frm.div(id: "compareRuleLightBox")}
  element(:preview_rule_section) { |b| b.frm.div(id: "KS-RulePreview-Links")}

  element(:background_div) { |b| b.frm.li(:id => /^u\d+_node_0_parent_root$/)}
  element(:logic_tab) { |b| b.frm.a(:text => "Edit Rule Logic")}
  element(:object_tab) { |b| b.frm.a(:text => "Edit Rule")}
  element(:logic_text) { |b| b.frm.textarea(name: "document.newMaintainableObject.dataObject.logicArea")}

  action(:add_btn) { |b| b.frm.button(:text => /Add Rule Statement/).when_present.click}
  action(:edit_btn) { |b| b.frm.button(:text => /Edit/).when_present.click}
  action(:group_btn) { |b| b.frm.button(:text => /Add Parent/).when_present.click}
  action(:update_rule_btn) { |b| b.frm.button(:text => /Update Rule/).when_present.click}
  action(:down_btn) { |b| b.frm.button(:text => /Move Down/).when_present.click}
  action(:up_btn) { |b| b.frm.button(:text => /Move Up/).when_present.click}
  action(:left_btn) { |b| b.frm.button(:text => /Move Left/).when_present.click}
  action(:right_btn) { |b| b.frm.button(:text => /Move Right/).when_present.click}
  action(:preview_btn) { |b| b.frm.button(:text => /Preview Change/).when_present.click}
  action(:copy_btn) { |b| b.frm.button(:text => /Copy/).when_present.click}
  action(:cut_btn) { |b| b.frm.button(:text => /Cut/).when_present.click}
  action(:paste_btn) { |b| b.frm.button(:text => /Paste/).when_present.click}
  action(:del_btn) { |b| b.frm.button(:text => /Delete/).when_present.click}
  action(:add_line_btn) { |b| b.frm.button(:text => /add/).when_present.click}

  action(:search_link) { |b| b.edit_tree_section.a(:text => /Advanced Search/).when_present.click}

  element(:course_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.courseInfo\.code/)}
  element(:free_text_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.termParameter/)}
  element(:courses_field) { |b| b.frm.text_field(:name => /.*editTree.*proposition\.cluSet\.clus\'\]\.code/)}

  element(:lookup_section) { |b| b.frm_popup.div(id: "CourseLookupView")}
  element(:lookup_results) { |b| b.frm_popup.div(id: "uLookupResults")}
  element(:lookup_course_title) { |b| b.frm_popup.text_field(name: "lookupCriteria[title]")}
  element(:lookup_course_code) { |b| b.frm_popup.text_field(name: "lookupCriteria[code]")}
  element(:lookup_description) { |b| b.frm_popup.text_field(name: "lookupCriteria[description]")}

  action(:lookup_search_button) { |b| b.frm_popup.button(id: "button_search").when_present.click}
end