class CreateHolidayCalendar < HolidayBase

  include Holidays

  wrapper_elements
  frame_element
  
  element(:calendar_name) { |b| b.frm.text_field(name: "holidayCalendarInfo.name") }
  #element(:organization) { |b| b.frm.select(name: "holidayCalendarInfo.adminOrgId") }
  element(:start_date) { |b| b.frm.text_field(name: "holidayCalendarInfo.startDate") }
  element(:end_date) { |b| b.frm.text_field(name: "holidayCalendarInfo.endDate") }
  element(:holiday_table) { |b| b.frm.div(id: "KS-HolidayCalendar-HolidaySection").table(class: "uif-tableCollectionLayout") }
  element(:start_blank_calendar_link) { |b| b.frm.link(text: "Start a blank calendar instead?")}

  action(:start_blank_calendar) { |b| b.start_blank_calendar_link.click; b.loading.wait_while_present }

end