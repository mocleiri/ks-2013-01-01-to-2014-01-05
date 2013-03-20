#Scenario: Edit Activity Offering Information attributes
When /^I change Activity Offering Information attributes$/ do
  # Activity Code can not be saved. This is a bug
  # Modify Total Maximum Enrollment to 100
  @total_maximum_enrollment = 88
  on ActivityOfferingMaintenance do |page|
    @orig_enroll = page.total_maximum_enrollment.value.to_i
    page.total_maximum_enrollment.set @total_maximum_enrollment
    page.total_maximum_enrollment.fire_event "onchange"
  end
end

Then /^I am able to submit the changes$/ do
  on ActivityOfferingMaintenance do |page|
    page.submit
  end
end


And /^verify that the changes of Information attributes have persisted$/ do
  @course_offering.manage
  @course_offering.edit_ao :ao_code =>  @orig_ao_code
  sleep 6
  on ActivityOfferingMaintenance do |page|
    page.total_maximum_enrollment.value.to_i.should == @total_maximum_enrollment
    # clean up
    page.total_maximum_enrollment.set @orig_enroll
    page.submit
  end
end

#Scenario: Edit Activity Offering Requested Delivery Logistics
When /^I change Requested Delivery Logistics$/ do
  #TODO - there is an ActivityOffering data object method that does this
#  Facility code: ccc and room 1105  or CHM  and 124
  @requested_delivery_logistics = make DeliveryLogistics
  @requested_delivery_logistics.days =           "WF"
  @requested_delivery_logistics.start_time =     "9:00"
  @requested_delivery_logistics.start_time_ampm = "am"
  @requested_delivery_logistics.end_time =        "11:00"
  @requested_delivery_logistics.end_time_ampm =   "am"
  @requested_delivery_logistics.facility =        "CHM"
  @requested_delivery_logistics.room =            "124"

  on ActivityOfferingMaintenance do |page|
    page.revise_logistics
  end

  @requested_delivery_logistics.add_logistics_request
  @requested_delivery_logistics.save

end

And /^verify that the changes of ADL have persisted$/ do
  @course_offering.manage
  @course_offering.edit_ao :ao_code =>  @orig_ao_code
  on ActivityOfferingMaintenance do |page|
    page.revise_logistics
  end
  added_rdl = false
  num = @requested_delivery_logistics.rdl_row_numbers.table.rows.count

  if num > 2
    added_rdl = true
  end
  added_rdl.should == true

  puts(num)

  @requested_delivery_logistics.delete_rdl(num-2)

  on ActivityOfferingMaintenance do |page|
    page.submit
  end
end


#Scenario: Edit Activity Offering Personnel attributes
When /^I change Personnel attributes$/ do
  # H.ERICD, admin are ids can be used.

  @teaching_assistant = make Personnel
  @teaching_assistant.id = @added_person_id
  @teaching_assistant.affiliation = "Teaching Assistant"
  @teaching_assistant.inst_effort = @effort_num

  @teaching_assistant.add_personnel :id=> @added_person_id, :affiliation => "Teaching Assistant", :inst_effort => 30
end

And /^verify that the changes of the Personnel attributes have persisted$/ do

  @course_offering.manage
  @course_offering.edit_ao :ao_code =>  @orig_ao_code
  #Personnel row added the deletion should succeed
  on ActivityOfferingMaintenance do |page|
    page.delete_id(@added_person_id)
    page.submit
  end

end

#Scenario: Edit Miscellaneous Activity Offering attributes
When /^I change Miscellaneous Activity Offering attributes$/ do

  on ActivityOfferingMaintenance do |page|
    page.course_url.set  @misc_url
    page.requires_evaluation.set
    page.honors_flag.set
  end

end


And /^verify that the changes of Miscellaneous have persisted$/ do

  @course_offering.manage
  @course_offering.edit_ao :ao_code =>  @orig_ao_code
  on ActivityOfferingMaintenance do |page|
    page.course_url.value.should ==  @misc_url
    page.requires_evaluation.set? == true
    page.honors_flag.set? == true
    page.course_url.set ""
    page.requires_evaluation.clear
    page.honors_flag.clear
    page.submit
  end

end

Given /^I manage a given Course Offering$/ do
  @course_offering = make CourseOffering, :course=>"ENGL222"
  @course_offering.manage
end

Given /^I edit an Activity Offering$/ do
  @total_number = @course_offering.ao_list.count
  @orig_ao_code = @course_offering.ao_list[@total_number-1]
  @added_person_id = "admin"
  @effort_num = 30
  @misc_url = "www.google.com"

  @course_offering.edit_ao :ao_code =>  @orig_ao_code
end