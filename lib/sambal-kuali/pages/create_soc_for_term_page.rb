class CreateSocForTerm < BasePage

  wrapper_elements
  #frame_element

  #expected_element :term_code

  element(:frm) { |b| b.frame(id: /easyXDM/).frame(id: "iframeportlet") }

  element(:term_code){|b| b.frm.div(data_label: "Term").text_field }
  element(:submit) { |b| b.frm.button(text: "Go").click; b.loading.wait_while_present }
end