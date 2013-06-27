class EditHolidayCalendar < HolidayBase

  include Holidays

  wrapper_elements
  frame_element

  expected_element :calendar_name

  element(:calendar_name) { |b| b.frm.div(data_label: "Holiday Calendar Name").text_field }
  element(:start_date) { |b| b.frm.div(data_label: "Start Date").text_field }
  element(:end_date) { |b| b.frm.div(data_label: "End Date").text_field }
  element(:holiday_table) { |b| b.frm.div(id: "KS-HolidayCalendar-HolidaySection").table(class: "uif-tableCollectionLayout") }

end