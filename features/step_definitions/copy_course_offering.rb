When /^the registration groups are not copied$/ do
  @course_offering_copy.activity_offering_cluster_list.each do |cluster|
       on ManageRegistrationGroups do |page|
         page.get_cluster_status_msg(cluster.private_name).strip.should  match /.*No Registration Groups Generated.*/
      end
   end
end

Then /^the registration groups are automatically generated$/ do
  @course_offering_copy.activity_offering_cluster_list.each do |cluster|
    on ManageRegistrationGroups do |page|
      page.get_cluster_status_msg(cluster.private_name).strip.should  match /.*All Registration Groups Generated.*/
    end
  end
end


Then /^the activity offering clusters? and assigned AOs are copied over with the course offering$/ do
  @course_offering_copy.manage_registration_groups({:cleanup_existing_clusters => false})

  on ManageRegistrationGroups do |page|
    clusters = page.cluster_div_list
    clusters.length.should == @course_offering_copy.activity_offering_cluster_list.length
  end

  @course_offering_copy.activity_offering_cluster_list.each do |cluster|
    cluster.assigned_ao_list.each do |ao_code|
      on ManageRegistrationGroups do |page|
        actual_aos = page.get_cluster_assigned_ao_list(cluster.private_name)
        actual_aos.sort.should == cluster.assigned_ao_list.sort
      end
    end
  end
end

Then /^I copy the course offering$/ do
  @course_offering_copy = create CourseOffering, :term=>Rollover::OPEN_SOC_TERM, :create_by_copy=>@course_offering
end

When /^I create a new course offering in a subsequent term by copying the catalog course offering$/ do
  @course_offering_copy = create CourseOffering, :term=> Rollover::FINAL_EDITS_SOC_TERM, :course => "BSCI425", :create_from_existing=>@course_offering
end
