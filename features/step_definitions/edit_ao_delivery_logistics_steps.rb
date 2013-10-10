And /^I am editing an AO with RDLs$/ do
  course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :term => "201208", :course=>"ENGL222")
  course_offering.manage_and_init
  @activity_offering = course_offering.get_ao_obj_by_code("A")
end

When /^I revise an AO's requested delivery logistics$/ do
  # capture the RDLs for editing
  @new_rdls = @activity_offering.requested_delivery_logistics_list.values[0]
  # edit RDLs
  @activity_offering.edit
  @new_rdls.edit :days => "SU", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"
  @activity_offering.save
end

When /^I add RDLs for an AO specifying (times|times and facility|times and room) only$/ do |optional_field|

  # determine which optional-field the user wants
  case optional_field
    when "times and facility"
      optional_field_facility = "PHYS"
      optional_field_room = ""
    when "times and room"
      optional_field_facility = ""
      optional_field_room = "0152"
    else    # "times only"
      optional_field_facility = ""
      optional_field_room = ""
  end

  # capture the RDLs
  @new_rdls = @activity_offering.requested_delivery_logistics_list.values[0]

  # add new RDL row
  @activity_offering.edit
  @new_rdls.add :days => "TH", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => optional_field_facility, :room => optional_field_room
  # if entering an invalid combination, need to stay on page to see the error message, so skip the page submit
  @activity_offering.save unless optional_field == "times and room"
end

Then /^the AO's delivery logistics shows the new schedule$/ do
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit

  rdl_list = @activity_offering.requested_delivery_logistics_list.values
  rdl_list.each do |row|
    row.target_row_by_dl_key
    row.days.should == @new_rdls.days
    row.start_time.should == @new_rdls.start_time
    row.start_time_ampm.should == @new_rdls.start_time_ampm
    row.end_time.should == @new_rdls.end_time
    row.end_time_ampm.should == @new_rdls.end_time_ampm
    row.facility.should == @new_rdls.facility
    row.room.should == @new_rdls.room
  end
end

Then /^the AO's delivery logistics shows the new schedule as TBA$/ do
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit

  rdl_list = @activity_offering.requested_delivery_logistics_list.values
  rdl_list.each do |row|
    row.target_row_by_dl_key
    row.tba?.should == true
  end
end

Then /^an error message is displayed about the required RDL fields$/ do
  on ActivityOfferingMaintenance do |page|
    page.growl_text.should == "The form contains errors. Please correct these errors and try again."
    page.cancel
  end
end

When /^I add RDLs for an AO$/ do
  # capture the RDLs
  @new_rdls = @activity_offering.requested_delivery_logistics_list.values[0]
  # add new RDL row
  @activity_offering.edit
  @new_rdls.add :days => "TH", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"
  @activity_offering.save
end

When /^I add RDLs for an AO checking the TBA flag$/ do
  # capture the RDLs
  @new_rdls = @activity_offering.requested_delivery_logistics_list.values[0]
  # add new TBA RDL row
  @activity_offering.edit
  @new_rdls.add :tba => true
  @activity_offering.save
end

And /^I delete the original RDLs$/ do
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit
  on ActivityOfferingMaintenance do |page|
    page.view_requested_delivery_logistics
    page.delete_requested_delivery_logistics
  end
  @activity_offering.save
end

########################################################################################################################
### DUMMY DATA AND TESTING
#When /^I create dummy data to speed dev of edit-ao-delivery-logistics$/ do
#  course_offering = make CourseOffering, :term => "201208", :course => "ENGL222A"
#  course_offering.manage_and_init
#  @activity_offering = course_offering.activity_offering_cluster_list[0].get_ao_obj_by_code("A")
#end

