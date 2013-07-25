class CreateCOFromExisting < BasePage

  wrapper_elements
  frame_element
  validation_elements

  expected_element :exclude_instructor_checkbox

  action(:create) { |b| b.frm.button(id: "ks-uif-primaryActionButton").click; b.loading.wait_while_present(120) }

  element(:exclude_cancelled_aos_checkbox) { |b| b.frm.label(text: /Exclude cancelled Activity Offerings/) }
  action(:select_exclude_cancelled_aos_checkbox) { |b| b.exclude_instructor_checkbox.wait_until_present; b.exclude_instructor_checkbox.click }

  element(:exclude_scheduling_checkbox) { |b| b.frm.label(text: /Exclude scheduling information/) }
  action(:select_exclude_sheduling_checkbox) { |b| b.exclude_instructor_checkbox.wait_until_present; b.exclude_instructor_checkbox.click }

  element(:exclude_instructor_checkbox) { |b| b.frm.label(text: /Exclude instructor information/) }
  action(:select_exclude_instructor_checkbox) { |b| b.exclude_instructor_checkbox.wait_until_present; b.exclude_instructor_checkbox.click }

  element(:course_offering_existing_table) { |b| b.frm.div(id: "KS-ExistingOffering-ListCOs").table() }

  #TODO just selects the first row - needs to be deprecated
  element(:course_offering_copy_element) {|b| b.frm.course_offering_existing_table.rows[1].cells[ACTIONS_COLUMN_CO].radio.click  }
  action(:course_offering_copy) {|b| b.course_offering_copy_element.click }

  ACTIONS_COLUMN = 0
  CO_CODE_COLUMN = 1
  OFFERED_TERM_COLUMN = 2

 def existing_co_target_row(term, course)
    course_offering_existing_table.row(text: /#{Regexp.escape(course)}[\S\s]#{Regexp.escape(term)}/)
  end

  def select_copy_for_existing_course(term, course)
    existing_co_target_row(term, course).cells[ACTIONS_COLUMN].radio.click
  end

end