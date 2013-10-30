And /^I am editing an AO with RDLs$/ do
  course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :term => "201208", :course=>"ENGL222")
  course_offering.manage_and_init
  @activity_offering = course_offering.get_ao_obj_by_code("A")
end

When /^I revise an AO's requested delivery logistics$/ do
  # capture the RDLs for editing
  @new_rdls = @activity_offering.requested_delivery_logistics_list[0]
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
  @new_rdls = @activity_offering.requested_delivery_logistics_list[0]

  # add new RDL row
  @activity_offering.edit
  @new_rdls.add :days => "TH", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => optional_field_facility, :room => optional_field_room
  # if entering an invalid combination, need to stay on page to see the error message, so skip the page submit
  @activity_offering.save unless optional_field == "times and room"
end

Then /^the AO's delivery logistics shows the new schedule$/ do
  # reload saved CO and AO data
  course_offering = make CourseOffering, :term => @activity_offering.parent_course_offering.term, :course => @activity_offering.parent_course_offering.course
  course_offering.manage_and_init
  @activity_offering = course_offering.get_ao_obj_by_code("A")
  @activity_offering.edit
  norm_st, norm_et = @new_rdls.normalize_start_and_end_times
  new_key = "#{@new_rdls.days}#{norm_st}#{@new_rdls.start_time_ampm.upcase}#{norm_et}#{@new_rdls.end_time_ampm.upcase}"

  row = (on ActivityOfferingMaintenance).target_rdl_row (new_key)
  row.should_not == nil
  row.cells[ActivityOfferingMaintenance::DAYS_COLUMN].text.delete(' ').should == @new_rdls.days
  row.cells[ActivityOfferingMaintenance::ST_TIME_COLUMN].text.should == "#{norm_st} #{@new_rdls.start_time_ampm.upcase}"
  row.cells[ActivityOfferingMaintenance::END_TIME_COLUMN].text.should == "#{norm_et} #{@new_rdls.end_time_ampm.upcase}"
  row.cells[ActivityOfferingMaintenance::FACILITY_COLUMN].text.should == @new_rdls.facility
  row.cells[ActivityOfferingMaintenance::ROOM_COLUMN].text.should == @new_rdls.room
end

Then /^the AO's delivery logistics shows the new schedule as TBA$/ do
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit

  rdl_list = @activity_offering.requested_delivery_logistics_list
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
  @new_rdls = @activity_offering.requested_delivery_logistics_list[0]
  # save original lookup key
  norm_st, norm_et = @new_rdls.normalize_start_and_end_times
  @orig_key = "#{@new_rdls.days}#{norm_st}#{@new_rdls.start_time_ampm.upcase}#{norm_et}#{@new_rdls.end_time_ampm.upcase}"
  @orig_rdls = @new_rdls
  # add new RDL row
  @activity_offering.edit
  @new_rdls.add :days => "TH", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"
  @activity_offering.save
end

When /^I add RDLs for an AO checking the TBA flag$/ do
  # capture the RDLs
  @new_rdls = @activity_offering.requested_delivery_logistics_list[0]
  # add new TBA RDL row
  @activity_offering.edit
  @new_rdls.add :tba => true
  @activity_offering.save
end

And /^I delete the original RDLs$/ do
  @activity_offering.parent_course_offering.manage
  @activity_offering.edit
  @orig_rdls.delete_rdl (@orig_key)
end

When /^I add (standard|ad hoc) RDLs for an AO$/ do |tsType|
  # capture the RDLs
  @new_rdls = @activity_offering.requested_delivery_logistics_list[0]
  # add new RDL row
  @activity_offering.edit
  if tsType=="standard"
    @new_rdls.add :std_ts => true, :days => "MWF", :start_time => "08:00", :start_time_ampm => "am", :end_time => "8:35", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"
  elsif tsType=="ad hoc"
    @new_rdls.add :std_ts => false, :days => "TH", :start_time => "8:21", :start_time_ampm => "pm", :end_time => "9:04", :end_time_ampm => "pm", :facility => "PHYS", :room => "4102"
  end
  @activity_offering.save
end