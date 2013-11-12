And /^I am editing an AO with RDLs$/ do
  course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :term => "201208", :course=>"ENGL211")
  course_offering.manage_and_init
  @activity_offering = course_offering.get_ao_obj_by_code("A")
end

When /^I revise an AO's requested delivery logistics$/ do
  # capture the RDLs for editing
  #@new_rdls = @activity_offering.requested_delivery_logistics_list.values[0]
  # edit RDLs
  @activity_offering.edit
  orig_key = @activity_offering.requested_delivery_logistics_list.keys[0]
  @activity_offering.requested_delivery_logistics_list.values[0].edit :days => "SU", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am",
                                                                      :facility => "PHYS", :facility_long_name => "PHYS",:room => "4102"
  @activity_offering.requested_delivery_logistics_list["SU10:00AM"] = @activity_offering.requested_delivery_logistics_list.values[0]
  @activity_offering.requested_delivery_logistics_list.delete(orig_key)
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
  #@new_rdls =  @activity_offering.requested_delivery_logistics_list.values[0]

  # add new RDL row
  @activity_offering.edit
  dl_obj = create DeliveryLogistics, :days => "TH", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am",
                  :facility => optional_field_facility, :facility_long_name => optional_field_facility, :room => optional_field_room
  @activity_offering.requested_delivery_logistics_list[dl_obj.dl_key] = dl_obj
  # if entering an invalid combination, need to stay on page to see the error message, so skip the page submit
  @activity_offering.save unless optional_field == "times and room"
end

Then /^the AO's delivery logistics shows the new schedule$/ do
  # reload saved CO and AO data
  course_offering = make CourseOffering, :term => @activity_offering.parent_course_offering.term, :course => @activity_offering.parent_course_offering.course
  course_offering.manage
  #@activity_offering = course_offering.get_ao_obj_by_code("A")
  @activity_offering.edit
#  norm_st, norm_et = @new_rdls.normalize_start_and_end_times

  on ActivityOfferingMaintenance do |page|
    page.view_requested_delivery_logistics
    page.requested_logistics_table.rows.size.should be > 2 #should be more than header/footer rows
    page.requested_logistics_table.rows[1..-2].each do |row|
      days = page.get_requested_logistics_days(row).delete(' ')
      start_time = page.get_requested_logistics_start_time(row).delete(' ')
      dl_key = "#{days}#{start_time}"
      #get the corresponding ADL by key
      del_logisitics = @activity_offering.requested_delivery_logistics_list[dl_key]
      page.get_requested_logistics_days(row).delete(' ').should == del_logisitics.days
      page.get_requested_logistics_start_time(row).delete(' ').should == "#{del_logisitics.start_time}#{del_logisitics.start_time_ampm}"
      page.get_requested_logistics_end_time(row).delete(' ').should == "#{del_logisitics.end_time}#{del_logisitics.end_time_ampm}"
      page.get_requested_logistics_facility(row).should == del_logisitics.facility_long_name
      page.get_requested_logistics_room(row).should == del_logisitics.room
    end
    page.cancel
  end
end

Then /^the AO's delivery logistics shows the new schedule as TBA$/ do
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit

  del_logisitics = @activity_offering.requested_delivery_logistics_list[""]
  on ActivityOfferingMaintenance do |page|
    row = page.target_rdl_row("")
    isTBA = page.get_requested_logistics_tba(row) == "TBA"
    isTBA.should == del_logisitics.tba
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
  #@new_rdls = @activity_offering.requested_delivery_logistics_list[0]
  # save original lookup key
  #norm_st, norm_et = @new_rdls.normalize_start_and_end_times
  #@orig_key = "#{@new_rdls.days}#{norm_st}#{@new_rdls.start_time_ampm.upcase}#{norm_et}#{@new_rdls.end_time_ampm.upcase}"
  #@orig_rdls = @new_rdls
  # add new RDL row
  @activity_offering.edit
  dl_obj = create DeliveryLogistics, :days => "TH", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am",
                  :facility => "PHYS", :facility_long_name => "PHYS", :room => "4102"
  @activity_offering.requested_delivery_logistics_list[dl_obj.dl_key] = dl_obj
  @activity_offering.save
end

When /^I add RDLs for an AO checking the TBA flag$/ do
  # capture the RDLs
  #@new_rdls = @activity_offering.requested_delivery_logistics_list.values[0]
  # add new TBA RDL row
  @activity_offering.edit
  dl_obj = create DeliveryLogistics,  :tba => true, :days => "", :start_time => "", :start_time_ampm => "", :end_time => "", :end_time_ampm => ""
  @activity_offering.requested_delivery_logistics_list[dl_obj.dl_key] = dl_obj
  @activity_offering.save
end

And /^I delete the original RDLs$/ do
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit
  rdl_key = @activity_offering.requested_delivery_logistics_list.keys[0]
  @activity_offering.requested_delivery_logistics_list.values[0].delete_rdl
  @activity_offering.requested_delivery_logistics_list.delete(rdl_key)
  @activity_offering.save
end

When /^I add (standard|ad hoc) RDLs for an AO$/ do |tsType|
  # capture the RDLs
  #@activity_offering.requested_delivery_logistics_list.values[0]
  # add new RDL row
  @activity_offering.edit
  if tsType=="standard"
    dl_obj = create DeliveryLogistics, :std_ts => true, :days => "MWF", :start_time => "08:00", :start_time_ampm => "am", :end_time => "08:35", :end_time_ampm => "am",
                    :facility => "PHYS", :facility_long_name => "PHYS", :room => "4102"
    @activity_offering.requested_delivery_logistics_list[dl_obj.dl_key] = dl_obj
  elsif tsType=="ad hoc"
    dl_obj = create DeliveryLogistics, :std_ts => false, :days => "TH", :start_time => "08:21", :start_time_ampm => "pm", :end_time => "09:04", :end_time_ampm => "pm",
                    :facility => "PHYS", :facility_long_name => "PHYS", :room => "4102"
    @activity_offering.requested_delivery_logistics_list[dl_obj.dl_key] = dl_obj
  end
  @activity_offering.save
end