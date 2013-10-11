class FEMatrixEdit < BasePage

  wrapper_elements
  frame_element

  element(:fe_agenda_view_page) { |b| b.frm.div( id: "KSFE-AgendaManagement-View")}
  element(:fe_rule_maintenance_page) { |b| b.fe_agenda_view_page.div( id: "KSFE-RuleMaintenance-Page")}

  element(:fe_rules_manage_section) { |b| b.fe_rule_maintenance_page.div( id: "KSFE-Rules-ManageSection")}
  element(:toolbar_section) { |b| b.fe_rules_manage_section.div( id: "KSFE-EditRule-ToolbarSection")}
  element(:expand_collapse_section) { |b| b.fe_rules_manage_section.div( id: "KRMS-RuleEditor-TreeExpandCollapse")}
end