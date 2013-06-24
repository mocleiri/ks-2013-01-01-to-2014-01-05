class ViewAcademicTerms < BasePage

  frame_element
  wrapper_elements

  action(:go_to_calendar_tab) { |b| b.frm.a(id: "ui-id-1").click; b.loading.wait_while_present}
  action(:go_to_terms_tab) { |b| b.frm.a(id: "ui-id-2").click; b.loading.wait_while_present}

  element(:acal_overview_div) { |b| b.frm.div(id: "KS-AcademicCalendar-Overview-WithoutTerms") }
  value(:acal_name) { |b| b.acal_overview_div.div(data_label: "Academic Calendar Name").span(index: 1).text }
  value(:acal_organization) { |b| b.acal_overview_div.div(data_label: "Organization").span(index: 1).text }
  value(:acal_start_date) { |b| b.acal_overview_div.div(data_label: "Start Date").span(index: 1).text }
  value(:acal_end_date) { |b| b.acal_overview_div.div(data_label: "End Date").span(index: 1).text }

  element(:term_info_div) { |b| b.frm.div(id: "acal-term") }

  def terms_div_list
    term_info_div.div(class: "uif-stackedCollectionLayout").divs(class: "uif-group uif-boxGroup uif-verticalBoxGroup uif-collectionItem uif-boxCollectionItem")
  end
  private :terms_div_list

  def target_term_div(term_name)
    terms_div_list.each do |div|
      if (div.cells[POPULATION_NAME].text =~ /\b#{name}\b/)
        return div
      end
    end
  end




end