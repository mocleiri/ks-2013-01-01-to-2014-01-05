class ManageCourseOfferings < BasePage

  #expected_title /Kuali :: Manage Course Offering/

  wrapper_elements
  frame_element
  validation_elements

  expected_element :term

  element(:error_message_course_not_found) { |b| b.frm.li(class: "uif-errorMessageItem") }

  element(:previous_course_link){ |b| b.frm.link(id: "u380") } # Persistent ID needed!
  element(:list_all_course_link){ |b| b.frm.link(id: "u383") } # Persistent ID needed!
  element(:next_course_link){ |b| b.frm.link(id: "u386") }     # Persistent ID needed!

  element(:term) { |b| b.frm.text_field(name: "termCode") }
  element(:course_offering_code) { |b| b.frm.radio(value: "courseOfferingCode") }
  element(:subject_code) { |b| b.frm.radio(value: "subjectCode") }
  element(:input_code) { |b| b.frm.text_field(name: "inputCode") }

  element(:manage_offering_links_div) { |b| b.frm.div(id: "KS-CourseOfferingManagement-CourseOfferingLinks")}
  element(:view_co_details_link) { |b| b.manage_offering_links_div.link(text: "View") }
  element(:edit_course_offering_link) { |b| b.frm.link(id: "edit_co")}
  action(:edit_course_offering) { |b| b.edit_course_offering_link.click; b.loading.wait_while_present(200) }
  action(:delete_course_offering_link) { |b| b.manage_offering_links_div.link(id: "ActivityOfferingResultSection-deleteOneCoWithLink") }
  action(:delete_course_offering) { |b| b.delete_course_offering_link.click; b.loading.wait_while_present }
  element(:manage_registration_groups_link) { |b| b.manage_offering_links_div.link(id: "manage_reg_group") }
  action(:manage_registration_groups) { |b| b.manage_registration_groups_link.click }

  action(:show) { |b| b.frm.button(text: "Show").click; sleep 2; b.loading.wait_while_present(180) }

  element(:ao_results_div) { |b| b.frm.div(id: "ActivityOfferingResultSection") }
  value(:course_title) { |b| b.ao_results_div.h3.text }
  #value(:cross_listed_as) { |b| b.frm.span(id: "u362_span").text }
  value(:cross_listed_as_text) { |b| b.frm.span(text: /Crosslisted as/).text }

  action(:select_all) { |b| b.frm.link(id: "KS-CourseOfferingManagement-SelectAll").click; b.loading.wait_while_present }

  #NB - CO Toolbar is not on this page - this one element is listed here to allow nagivation to single CO when a CO List is
  # not expected (ie search for ENGL206, returns ENGL206 and ENG206A)
  action(:create_co_button){ |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Add-CO")}

  element(:add_activity_button){ |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Add-AO") }
  action(:add_activity){ |b| b.add_activity_button.click; b.loading.wait_while_present}

  element(:add_activity_popup_div){ |b| b.frm.div(id: "KS-CourseOfferingManagement-AddActivityOfferingPopupForm") }
  element(:format) { |b| b.add_activity_popup_div.select(name: "formatIdForNewAO") }
  element(:activity_type) { |b| b.add_activity_popup_div.select(name: "activityIdForNewAO") }
  element(:quantity) { |b| b.add_activity_popup_div.text_field(name: "noOfActivityOfferings") }
  element(:add_button) { |b| b.add_activity_popup_div.button }
  action(:complete_add_activity) { |b| b.add_button.click; b.loading.wait_while_present }

  action(:draft_activity_button){ |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Draft-AO") }
  action(:draft_activity){ |b| b.draft_activity_button.click; b.loading.wait_while_present}

  element(:approve_activity_button){ |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Approve-AO")}
  action(:approve_activity){ |b| b.approve_activity_button.click; b.loading.wait_while_present}

  element(:delete_aos_button) { |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Delete-AO") }
  action(:delete_aos) { |b| b.delete_aos_button.click; b.loading.wait_while_present }

  def approve_co_confirm
    puts "exists? #{approve_co_popup_div.checkbox(index: 0).exists?}"
    approve_co_popup_div.checkbox(index: 0).click
    loading.wait_while_present(180)
  end

  def approve_co_cancel
    puts "exists? #{approve_co_popup_div.checkbox(index: 1).exists?}"
    approve_co_popup_div.checkbox(index: 1).click
    loading.wait_while_present(180)
  end
  AO_CODE = 1
  AO_STATUS = 2
  AO_TYPE = 3
  AO_FORMAT = 4
  AO_INSTRUCTOR = 5
  AO_MAX_ENR = 6

  element(:activity_offering_results_table) { |b| b.frm.table(class: "uif-tableCollectionLayout dataTable") } # Persistent ID needed!
  element(:selected_offering_actions) { |b| b.frm.select(name: "selectedOfferingAction") }

  action(:go) { |b| b.frm.button(text: "Go").click; b.loading.wait_while_present }

  def view_activity_offering(code)
    view_activity_offering_link(code).click
    loading.wait_while_present
  end

  def view_activity_offering_link(code)
    activity_offering_results_table.link(text: code)
  end

  def target_row(code)
#    activity_offering_results_table.row(text: /\b#{Regexp.escape(code)}\b/).wait_until_present(60)
    activity_offering_results_table.row(text: /\b#{Regexp.escape(code)}\b/)
  end

  def course_list_returned?(subject_code)
    activity_offering_results_table.row(text: /#{subject_code}/).exists?
  end

  def ao_db_id(code)
    target_row(code).cells[AO_CODE].link.attribute_value("href").scan(/aoInfo.id=(.*)&dataObjectClassName/)[0][0]
  end

  def ao_status(code)
    target_row(code).cells[AO_STATUS].text
  end

  def row_by_status(aostatus)
    activity_offering_results_table.row(text: /\b#{Regexp.escape(aostatus)}\b/)
  end


  def select_ao_by_status(aostatus)
    if row_by_status(aostatus).exists? then
      row_by_status(aostatus).checkbox.set
      return row_by_status(aostatus).cells[AO_CODE].text
    end
  end

  def copy_link(code)
    target_row(code).link(text: "Copy")
  end

  def copy(code)
    copy_link(code).click
    loading.wait_while_present
  end

  def edit_link(code)
      target_row(code).link(text: "Edit")
  end

  def edit(code)
    begin
      edit_link(code).click

      if browser.alert.exists?
        browser.alert.ok
      end

    rescue Timeout::Error => e
      puts "rescued target_row edit"
    end
    loading.wait_while_present(120)
  end

  def select_aos(code_list)
    for code in code_list
      if !target_row(code).nil?
        target_row(code).checkbox.set
      end
    end
  end

  def deselect_aos(code_list)
    for code in code_list
      if !target_row(code).nil?
        target_row(code).checkbox.clear
      end
    end
  end

  def select_ao(code)
      if !target_row(code).nil?
        target_row(code).checkbox.set
      end
  end

  def deselect_ao(code)
      if !target_row(code).nil?
        target_row(code).checkbox.clear
      end
  end

  def ao_status(code, status)
    retVal = false
    row_text = target_row(code).text

    if row_text.include? status
      retVal = true
    end
    retVal
  end

  def ao_schedule_data(aoCode)
     retVal = nil
     retVal = target_row(aoCode).text
  end

  def codes_list
    codes = []
    activity_offering_results_table.rows.each { |row| codes << row[AO_CODE].text }
    codes.delete_if { |code| code == "CODE" }
    codes.delete_if { |code| code.strip == "" }
    codes
  end

  def add_ao input_format, input_quantity
    format.select(input_format)
    loading.wait_while_present(120)
    activity_type.select(activity_type.options[1].text)
    quantity.set(input_quantity)
    add
  end

  #def cross_listed_as(crossListedCoCode)
  #
  #  course_title
  #end

  def check_all_ao_status(aoStatus)
    retVal = true
    activity_offering_results_table.rows.each {|row|
      if !(row[AO_STATUS].text.eql? aoStatus)
        retVal = false
        break
      end
    }
    retVal
  end

  def check_aos_status(aoStatus, aos)
    retVal = true
    aos.each { |code|
    if(!ao_status(code, aoStatus))
      retVal = false
      break
    end
    }
    retVal
  end

end