class FEMatrixEdit < BasePage

  wrapper_elements
  frame_element

  element(:fe_agenda_view_page) { |b| b.frm.div( id: "KSFE-AgendaManagement-View")}
  element(:fe_rule_maintenance_page) { |b| b.fe_agenda_view_page.div( id: "KSFE-RuleMaintenance-Page")}

  element(:fe_rules_manage_section) { |b| b.fe_rule_maintenance_page.div( id: "KSFE-Rules-ManageSection")}
  element(:toolbar_section) { |b| b.fe_rules_manage_section.div( id: "KSFE-EditRule-ToolbarSection")}
  element(:expand_collapse_section) { |b| b.fe_rules_manage_section.div( id: "KRMS-RuleEditor-TreeExpandCollapse")}
  element(:rule_tree_section) { |b| b.fe_rules_manage_section.div( id: "KRMS-RuleEditor-TreeGroup")}
  element(:delivery_logistics_section) { |b| b.fe_rules_manage_section.div( id: "FinalExam-DeliveryLogistic-New-Section")}

  element(:add_statement_btn) { |b| b.toolbar_section.button( text: "Add Statement")}
  action(:add_statement) { |b| b.add_statement_btn.click; b.loading.wait_while_present}
  element(:edit_btn) { |b| b.toolbar_section.button( text: "Edit")}
  action(:edit) { |b| b.edit_btn.click; b.loading.wait_while_present}
  element(:move_up_btn) { |b| b.toolbar_section.button( text: "Move Up")}
  action(:move_up) { |b| b.move_up_btn.click; b.loading.wait_while_present}
  element(:move_down_btn) { |b| b.toolbar_section.button( text: "Move Down")}
  action(:move_down) { |b| b.move_down_btn.click; b.loading.wait_while_present}
  element(:delete_btn) { |b| b.toolbar_section.button( text: "Delete")}
  action(:delete) { |b| b.delete_btn.click; b.loading.wait_while_present}

  element(:fe_tba_checkbox) { |b| b.delivery_logistics_section.checkbox( id: "FinalExam_tba_control")}
  action(:fe_tba) { |b| b.fe_tba_checkbox.click}
  element(:fe_days_select) { |b| b.delivery_logistics_section.select( id: "FinalExam_days_control")}
  action(:fe_days) { |b| b.fe_days_select.select}
  element(:fe_starttime_input) { |b| b.delivery_logistics_section.text_field( id: "FinalExam_starttime_control")}
  action(:fe_starttime) { |b| b.fe_starttime_input.set}
  element(:fe_starttime_ampm_select) { |b| b.delivery_logistics_section.select( id: "FinalExam_starttime_ampm_control")}
  action(:fe_starttime_ampm) { |b| b.fe_starttime_ampm_select.select}
  element(:fe_endtime_input) { |b| b.delivery_logistics_section.text_field( id: "FinalExam_endtime_control")}
  action(:fe_endtime) { |b| b.fe_endtime_input.set}
  element(:fe_endtime_ampm_select) { |b| b.delivery_logistics_section.select( id: "FinalExam_endtime_ampm_control")}
  action(:fe_endtime_ampm) { |b| b.fe_endtime_ampm_select.select}

  element(:update_rule_btn) { |b| b.fe_rule_maintenance_page.button( id: "KSFE-UpdateRule-Button")}
  action(:update_rule) { |b| b.update_rule_btn.click}
  element(:cancel_rule_btn) { |b| b.fe_rule_maintenance_page.button( id: "KSFE-CancelRule-Button")}
  action(:cancel_rule) { |b| b.cancel_rule_btn.click}

end