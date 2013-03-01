And /^I prepare Activity Offering data$/ do
  on ManageCourseOfferings do |page|
    @total_number=page.codes_list.count
    format = page.format.options[1].text
    page.add_ao format, 1
  end
end

Then /^the Activity Offering should be added to the list$/ do
  on ManageCourseOfferings do |page|
    new_total = page.codes_list.count
    new_total.should == @total_number + 1
  end
end