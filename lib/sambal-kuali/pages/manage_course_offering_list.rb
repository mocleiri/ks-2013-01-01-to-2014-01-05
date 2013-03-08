class ManageCourseOfferingList < BasePage

  wrapper_elements
  frame_element

  expected_element :subject_code

  element(:co_results_div) { |b| b.frm.div(id: "searchResultSection") }
  element(:subject_code) { |b| b.frm.co_results_div.h3.span() }

  action(:approve_subject_code_for_scheduling) { |b| b.frm.co_results_div.link(id: "KS-CourseOfferingManagement-ApproveSubj").click}

  element(:approve_course_offering_button) { |b| b.frm.co_results_div.button(id: "KS-CourseOfferingManagement-ToolBar-Approve-CO") }
  action(:approve_course_offering) { |b| b.approve_course_offering_button.click; b.loading.wait_while_present }

  element(:create_course_offering_button) { |b| b.frm.co_results_div.button(id: "KS-CourseOfferingManagement-ToolBar-Add-CO") }
  action(:create_course_offering) { |b| b.create_course_offering_element.click; b.loading.wait_while_present }

  element(:delete_cos_button) { |b|b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Delete-CO")}
  action(:delete_cos) { |b|b.delete_cos_button.click; b.loading.wait_while_present }

  element(:approve_dialog){|b| b.frm.div(id:"approveCODialog")}
  element(:approve_yes_element) { |b| b.approve_dialog.checkbox(index:0)}
  action(:approve_yes) { |b| b.approve_yes_element.click;b.loading.wait_while_present(300)}

  element(:no_button_element) { |b| b.approve_dialog.checkbox(index:1)}
  action(:no) { |b| b.no_button_element.click;b.loading.wait_while_present(300)}

  SELECT_COLUMN = 0
  CO_CODE_COLUMN = 1
  CO_STATUS_COLUMN = 2
  CO_TITLE_COLUMN = 3
  CO_CREDITS_COLUMN = 4
  CO_GRADING_COLUMN = 5
  ACTIONS_COLUMN = 6

  element(:course_offering_results_table) { |b| b.frm.div(id: "KS-CourseOfferingManagement-CourseOfferingListSection").table() }

  element(:selected_offering_actions) { |b| b.frm.select(id: "KS-CourseOfferingManagement-CourseOfferingActionSection-Select_control") }

  action(:go) { |b| b.frm.button(id: "KS-CourseOfferingManagement-CourseOfferingActionSection-Go").click}

  def go_click
     go
     @browser.alert.ok
     loading.wait_while_present
  end

  def approve_subject_code
    approve_subject_code_for_scheduling
    @browser.alert.ok
    loading.wait_while_present(600)
  end

  def view_course_offering_link(co_code)
    course_offering_results_table.link(text: co_code)
  end

  def view_course_offering(co_code)
    view_course_offering_link(co_code).click
    loading.wait_while_present
  end

  def target_row(co_code)
    course_offering_results_table.wait_until_present(60)
    course_offering_results_table.row(text: /\b#{Regexp.escape(co_code)}\b/)
  end

  def row_by_status(costatus)
    course_offering_results_table.row(text: /\b#{Regexp.escape(costatus)}\b/)
  end

  def select_co_by_status(costatus)
    if row_by_status(costatus).exists? then
      row_by_status(costatus).checkbox.set
      return row_by_status(costatus).cells[CO_CODE_COLUMN].text
    end
  end

  def copy(co_code)
    copy_link(co_code).click
    loading.wait_while_present(220)
  end

  def copy_link(co_code)
    target_row(co_code).link(text: "Copy")
  end

  def edit(co_code)
    edit_link(co_code).click
    loading.wait_while_present(120)
  end

  def edit_link(co_code)
    target_row(co_code).link(text: "Edit")
  end

  def manage_link(co_code)
    target_row(co_code).link(text: "Manage")
  end

  def manage(co_code)
    manage_link(co_code).click
    loading.wait_while_present(120)
  end

  def co_list
    co_codes = []
    course_offering_results_table.rows.each { |row| co_codes << row[CO_CODE_COLUMN].text }
    co_codes.delete_if { |co_code| co_code.strip == "" }
    co_codes
  end

  def select_cos(code_list)
    code_list.each do |code|
      target_row(code).checkbox.set
    end
  end

  def deselect_cos(code_list)
    code_list.each do |code|
      target_row(code).checkbox.clear
    end
  end

  def select_co(code)
    target_row(code).checkbox.set
  end

  def deselect_co(code)
    target_row(code).checkbox.clear
  end
end