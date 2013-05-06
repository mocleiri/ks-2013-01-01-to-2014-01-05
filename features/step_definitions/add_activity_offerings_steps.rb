When /^I add an Activity Offering to an existing Course Offering$/ do
  course_offering = make CourseOffering, :course=>"CHEM277"
  course_offering.manage_and_init
  @new_ao = course_offering.create_ao(make ActivityOffering, :format => "Lecture/Lab")
end


Then /^the new Activity Offering is shown in the list of AOs$/ do
  on(ManageCourseOfferings).codes_list.should include(@new_ao.code)
end


When /^I copy an AO with "(Requested|Actual)" Delivery Logistics$/ do |delivery_logistics|

  # in ref-data this CO has ADLs but no RDLs (copy an ADL first if you need an RDL)
  course_offering = make CourseOffering, :course => "CHEM277"
  course_offering.manage_and_init

  # get AOs that match the desired DL-type
  all_aos = course_offering.activity_offering_cluster_list[0].ao_list
  target_status = "Draft"
  if delivery_logistics == "Actual"
    target_status = "Offered"
  end
  target_aos = course_offering.get_aos_by_status :aos => all_aos, :ao_status => target_status
  if target_aos.empty?
    case target_status
      when "Offered"
        raise "CO has no ADLs"
      else
        raise "CO has no RDLs"
    end
  end

  # copy the first AO that matches the desired DL-type
  @ao_source = target_aos[0]
  @ao_copy = create ActivityOffering, :create_by_copy => true,
                    :code => @ao_source.code,
                    :parent_course_offering => course_offering
end


Then /^the "(ADL|RDL)s" are successfully copied as RDLs in the new AO$/ do |source_delivery_logistics_type|

  # capture sched for source-AO
  ao_source_schedule = []
  @ao_source.parent_course_offering.manage
  @ao_source.edit
  on ActivityOfferingMaintenance do |page|
    if source_delivery_logistics_type == "ADL"
      ao_source_schedule = page.get_actual_delivery_logistics_data_as_array_of_sets
    else
      ao_source_schedule = page.get_requested_delivery_logistics_data_as_array_of_sets
    end
  end

  # capture sched for copy-AO
  ao_copy_schedule = []
  @ao_copy.parent_course_offering.manage
  @ao_copy.edit
  on ActivityOfferingMaintenance do |page|
    ao_copy_schedule = page.get_requested_delivery_logistics_data_as_array_of_sets
  end

  # verify that both AOs have same DL-*details* (validation of DL-*type* is handled in the capture-blocks just prior to this)
  diff = ao_source_schedule - ao_copy_schedule
  diff.should be_empty

end


### CREATE DUMMY DATA
### This data should already exist in the DB, having been put in there manually
#When /^I create some dummy test data to speed up AFT development for activity offerings$/ do
#  course_offering = make CourseOffering, :course => "CHEM277"
#  course_offering.manage_and_init

#  @ao_source = course_offering.activity_offering_cluster_list[0].get_ao_obj_by_code("D")
#  @ao_copy = course_offering.activity_offering_cluster_list[0].get_ao_obj_by_code("E")
#end





