class ManualSocStateChangePage < BasePage

  # we navigate directly to this page because it does not have a direct-link in the portal or in ENR-home
  page_url "#{$test_site}/kr-krad/testStatePropagation?viewId=testStatePropagationView&pageId=aft-changeSocStatePage&methodToCall=start"

  wrapper_elements
  frame_element

  element(:change_soc_state_termCode) { |b| b.frm.text_field(name: "termCodeForSocStateChange") }
  element(:change_soc_state_newSocState) { |b| b.frm.text_field(name: "newSocStateForSocStateChange") }
  element(:change_soc_state_button) { |b| b.frm.button(text: "Change SOC State") }
  action(:change_soc_state) { |b| b.change_soc_state_button.click; b.loading.wait_while_present(60) }

end
