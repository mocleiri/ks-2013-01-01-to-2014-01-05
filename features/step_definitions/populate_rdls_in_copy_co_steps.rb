When /^I copy an CO with AOs that have ADLs to a new CO in the different term with RDLs in its AOs$/ do
  #TODO  use data object e.g. @course_offering = create CourseOffering, :term=> "201612", :course => "CHEM132", :create_from_existing=>(make CourseOffering, :term=> "201201", :course => "CHEM132")
  @course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :term=> "201205", :course => "ENGL221")
end

Then /^The new CO and AOs are Successfully created$/ do
  #get the new CO data and at lease one AO schedule
  @course_offering.manage_and_init
  @new_cluster_list = @course_offering.activity_offering_cluster_list
  @ao_list = @new_cluster_list[0].ao_list

  @new_total  = @ao_list.count
  @aos = [@ao_list[0]]
  @inputVals = [@aos, "Draft"]
  @aos_matched = @course_offering.ao_status(@inputVals)   #TODO: NB - ao_status method is updated
  if @aos_matched.length != 1
    raise "AO status is not Draft: ao_code: @course_offering.ao_list[0]"
  end
  @new_schedule = @course_offering.ao_schedule_data :ao_code =>  @ao_list[0].code
  #
  @new_schedule_set = @new_schedule.split(' ').to_set
  if @new_schedule_set.length < 7
    raise "AO has no schedule copied: ao_code: @course_offering.ao_list[0]"
  end

  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit('A')
  end

  on ActivityOfferingMaintenance do |page|
    page.view_requested_delivery_logistics
    page.requested_logistics_table.rows.count != 0
    @new_schedule_set = page.requested_logistics_table.rows[1].text.split(' ').to_set
  end

  #cleanup the newly copied CO
  #@course_offering.delete_co_with_link :should_confirm_delete => true

end

And /^The ADLs are Successfully copied to RDLs in the new AOs of the newly created CO$/ do
  @orig_course_offering = make CourseOffering, :term=> "201205", :course => "ENGL221"
  @orig_course_offering.suffix=""
  @orig_course_offering.manage_and_init

  @orig_activity_offering = @orig_course_offering.activity_offering_cluster_list[0].get_ao_obj_by_code("A")
  @orig_activity_offering.edit

  on ActivityOfferingMaintenance do |page|
    page.actual_logistics_div.exists? == false
    page.actual_logistics_table.exists? == false
    page.view_requested_delivery_logistics
    @orig_schedule_set = page.requested_logistics_table.rows[1].text.split(' ').to_set
  end

  if @new_schedule_set.length < 8
    raise "AO has no schedule copied: ao_code: @course_offering.ao_list[0]"
  end

  @result_set = @orig_schedule_set ^ @new_schedule_set
  if @result_set.length != 0
    raise "AO Schedule not copied properly."
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

Given /^I am creating a new course offering$/ do
  @source_term = "201201"
  @target_term = "201401"
  @catalogue_course_code = "ENGL222"
#  set target term and course code
  go_to_create_course_offerings
  on CreateCourseOffering do |page|
    page.target_term.set @target_term
    page.catalogue_course_code.set @catalogue_course_code
    page.show
  end
end

