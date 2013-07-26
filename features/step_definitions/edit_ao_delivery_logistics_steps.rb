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


Then /^the AO's delivery logistics shows the new schedule in row (\d+)$/ do |row|
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit
  on ActivityOfferingMaintenance do |page|
    page.view_requested_delivery_logistics
    page.requested_logistics_table[row.to_i][1].text.gsub(/\s+/, "").should == @new_rdls.days
    page.requested_logistics_table[row.to_i][2].text.should == "#{@new_rdls.start_time} #{@new_rdls.start_time_ampm.upcase}"
    page.requested_logistics_table[row.to_i][3].text.should == "#{@new_rdls.end_time} #{@new_rdls.end_time_ampm.upcase}"
    page.requested_logistics_table[row.to_i][4].text.should == @new_rdls.facility
    page.requested_logistics_table[row.to_i][5].text.should == @new_rdls.room
  end
end

Then /^the AO's delivery logistics shows the new schedule as TBA in row (\d+)$/ do |row|
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit
  on ActivityOfferingMaintenance do |page|
    page.view_requested_delivery_logistics
    page.requested_logistics_table[row.to_i][0].text.should == "TBA"
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


