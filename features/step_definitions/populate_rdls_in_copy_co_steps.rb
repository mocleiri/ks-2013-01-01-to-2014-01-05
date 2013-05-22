When /^I copy an CO with AOs that have ADLs to a new CO in the different term with RDLs in its AOs$/ do
  @source_course_offering = make CourseOffering, :term=> Rollover::SOC_STATES_SOURCE_TERM, :course => "ENGL222"
  @course_offering = create CourseOffering, :term=> Rollover::PUBLISHED_SOC_TERM , :create_from_existing => @source_course_offering
end

Then /^The new CO and AOs are Successfully created$/ do
  @course_offering.manage_and_init
  tgt_activity_offering = @course_offering.activity_offering_cluster_list[0].get_ao_obj_by_code("A")
  tgt_activity_offering.status.should == "Draft"
  tgt_activity_offering.requested_delivery_logistics_list.size.should_not == 0
end

And /^The ADLs are Successfully copied to RDLs in the new AOs of the newly created CO$/ do
  @source_course_offering.manage_and_init
  source_activity_offering = @source_course_offering.activity_offering_cluster_list[0].get_ao_obj_by_code("A")
  source_activity_offering.actual_delivery_logistics_list.size.should_not == 0

  #now navigate to course offering copy and validate RDLs
  @course_offering.manage
  @course_offering.edit_ao :ao_code => "A"

  on ActivityOfferingMaintenance do |page|
    page.actual_logistics_div.exists?.should == false  #should not be any ADLs
    page.requested_logistics_table.rows.size.should be > 2 #should be more than header/footer rows
    page.requested_logistics_table.rows[1..-2].each do |row|
      days = page.get_requested_logistics_days(row).delete(' ')
      start_time = page.get_requested_logistics_start_time(row).delete(' ')
      dl_key = "#{days}#{start_time}"
      #get the corresponding ADL by key
      adl = source_activity_offering.actual_delivery_logistics_list[dl_key]
      page.get_requested_logistics_days(row).delete(' ').should == adl.days
      page.get_requested_logistics_start_time(row).delete(' ').should == "#{adl.start_time}#{adl.start_time_ampm}"
      page.get_requested_logistics_end_time(row).delete(' ').should == "#{adl.end_time}#{adl.end_time_ampm}"
      page.get_requested_logistics_facility(row).should == adl.facility_long_name
      page.get_requested_logistics_room(row).should == adl.room
    end

  end
end

When /^I roll over an term to a new target term$/ do
  # Verify if the term was rolled over already
  @source_term = "201201"
  @target_term = "201401"
  @catalogue_course_code = "ENGL222"

  @rollover = make Rollover, :target_term => "201401" , :source_term => "201201"
  @rollover.perform_rollover
  @rollover.wait_for_rollover_to_complete
end

Then /^The COs and AOs in the previous term are Successfully rolled over to the target term$/ do
  @source_course_offering = make CourseOffering, :term=> "201201", :course => "ENGL222"
  @source_co_list = @source_course_offering.total_co_list("ENGL")

  @source_course_offering.manage_and_init

  @source_activity_offering = @source_course_offering.activity_offering_cluster_list[0].get_ao_obj_by_code("A")
  @source_activity_offering.edit

  on ActivityOfferingMaintenance do |page|
    page.view_requested_delivery_logistics
    @source_schedule_set = page.requested_logistics_table.rows[1].text.split(' ').to_set
  end

  @new_course_offering = make CourseOffering, :term=> "201401", :course => "ENGL222"
  @new_co_list = @new_course_offering.total_co_list("ENGL")

  @new_co_list.length == @source_co_list.length

  @new_course_offering.manage_and_init

  @new_activity_offering = @new_course_offering.activity_offering_cluster_list[0].get_ao_obj_by_code("A")
  @new_activity_offering.edit

  on ActivityOfferingMaintenance do |page|
    @new_schedule_set = page.requested_logistics_table.rows[1].text.split(' ').to_set
  end

end

And /^The ADLs are Successfully copied as RDLs to the rolled over AOs$/ do

  @source_schedule_set.delete? "Edit"
  @result_set = @source_schedule_set ^ @new_schedule_set

  if @result_set.length != 0
    raise "AO has no schedule copied: ao_code: @course_offering.ao_list[0]"
  end

end



