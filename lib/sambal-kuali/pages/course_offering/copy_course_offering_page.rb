class CopyCourseOffering < BasePage

  wrapper_elements
  frame_element

  expected_element :exclude_instructor_checkbox

  action(:create_copy) { |b| b.frm.button(id: "createFromCopy_btn").click; b.loading.wait_while_present(120) }

  element(:exclude_cancelled_aos_checkbox) { |b| b.frm.label(text: /Exclude cancelled Activity Offerings/) }
  action(:select_exclude_cancelled_aos_checkbox) { |b| b.exclude_instructor_checkbox.wait_until_present; b.exclude_instructor_checkbox.click }

  element(:exclude_scheduling_checkbox) { |b| b.frm.label(text: /Exclude scheduling information/) }
  action(:select_exclude_scheduling_checkbox) { |b| b.exclude_instructor_checkbox.wait_until_present; b.exclude_instructor_checkbox.click }

  element(:exclude_instructor_checkbox) { |b| b.frm.label(text: /Exclude instructor information/) }
  action(:select_exclude_instructor_checkbox) { |b| b.exclude_instructor_checkbox.wait_until_present; b.exclude_instructor_checkbox.click }


end