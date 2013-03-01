And /^I select an Activity Offering in Approved state$/ do
  #setup 1 approved ao
  on ManageCourseOfferings do |page|
    orig_ao_list = []
    page.codes_list.each { |code| orig_ao_list << code }

    format = page.format.options[1].text
    page.add_ao format, 1
    page.add_activity

    @new_ao_list =  orig_ao_list.to_set ^ page.codes_list.to_set
    page.select_aos(@new_ao_list)
    page.approve_activity
    page.select_aos(@new_ao_list)
  end
end


And /^I select multiple Activity Offerings in Approved state$/ do
  #setup 2 approved ao
  on ManageCourseOfferings do |page|
    orig_ao_list = []
    page.codes_list.each { |code| orig_ao_list << code }

    format = page.format.options[1].text
    page.add_ao format, 2
    page.add_activity

    @new_ao_list =  orig_ao_list.to_set ^ page.codes_list.to_set
    page.select_aos(@new_ao_list)
    page.approve_activity
    page.select_aos(@new_ao_list)
  end
end