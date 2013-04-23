When /^the registration groups are not copied$/ do
  @course_offering_copy.activity_offering_cluster_list.each do |cluster|
    on ManageRegistrationGroups do |page|
      page.get_cluster_status_msg(cluster.private_name).strip.should  match /.*No Registration Groups Generated.*/
    end
  end
end

Then /^the registration groups are automatically generated$/ do
  #TODO - implement using validation of reg group counts
  #@course_offering_copy.activity_offering_cluster_list.each do |cluster|
  #  on ManageCourseOfferings do |page|
  #    page.get_cluster_status_msg(cluster.private_name).strip.should  match /.*All Registration Groups Generated.*/
  #  end
  #end
end

Then /^the activity offering clusters? and assigned AOs are copied over with the course offering$/ do
  @course_offering_copy.manage

  on ManageCourseOfferings do |page|
    clusters = page.cluster_div_list
    clusters.length.should == @course_offering_copy.activity_offering_cluster_list.length
  end

  @course_offering_copy.activity_offering_cluster_list.each do |cluster|
    on ManageCourseOfferings do |page|
      actual_aos = page.get_cluster_assigned_ao_list(cluster.private_name)
      actual_aos.sort.should == cluster.ao_code_list.sort
    end
  end
end

Then /^the activity offering clusters?, assigned AOs and reg groups are rolled over with the course offering$/ do
  @course_offering_copy = make CourseOffering, :course=>@course_offering.course, :term=>Rollover::ROLLOVER_TEST_TERM_TARGET
  @course_offering_copy.manage

  on ManageCourseOfferings do |page|
    clusters = page.cluster_div_list
    clusters.length.should == @course_offering_copy.activity_offering_cluster_list.length
  end

  @course_offering_copy.activity_offering_cluster_list.each do |cluster|
    on ManageCourseOfferings do |page|
      actual_aos = page.get_cluster_assigned_ao_list(cluster.private_name)
      actual_aos.sort.should == cluster.ao_code_list.sort
    end
  end
end

Then /^I copy the course offering$/ do
  @course_offering_copy = create CourseOffering, :term=>Rollover::OPEN_SOC_TERM, :create_by_copy=>@course_offering
end

When /^I create a new course offering in a subsequent term by copying the catalog course offering$/ do
  @course_offering_copy = create CourseOffering, :term=> Rollover::FINAL_EDITS_SOC_TERM, :create_from_existing=>@course_offering
end
