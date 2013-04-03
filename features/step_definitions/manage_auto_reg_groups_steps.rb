Given /^I manage a course offering$/ do
  #@course_offering = create CourseOfferingARG, :create_by_copy=>(make CourseOffering, :course=>"ENGL211", :term => Rollover::MAIN_TEST_TERM_TARGET)
  @course_offering = make CourseOffering, :course=>"CHEM237", :term => Rollover::MAIN_TEST_TERM_TARGET
  @course_offering.manage
  #puts "ao_list #{@course_offering.ao_list}"
end

Given /^I manage registration groups for (?:a|the) course offering$/ do
  #@course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"BSCI283", :term => Rollover::MAIN_TEST_TERM_TARGET)
  #@course_offering.manage_registration_groups
  @course_offering = make CourseOffering, :course=>"CHEM237", :term => Rollover::MAIN_TEST_TERM_TARGET
  @course_offering.manage
end

When /^I assign an activity offering to the cluster$/ do
  @ao_cluster.add_unassigned_aos
end

When /^I move a lab activity offering from the first activity offering cluster to the second activity offering cluster$/ do
  @ao_cluster = make ActivityOfferingCluster, :private_name => "CL 1019"
  @course_offering.activity_offering_cluster_list << @ao_cluster
  @ao_cluster2 = make ActivityOfferingCluster, :private_name => "new cluster"
  @course_offering.activity_offering_cluster_list << @ao_cluster2
  @ao_cluster.assigned_ao_list = ["A","B","D","E"]
  @ao_cluster2.assigned_ao_list = []
  #@ao_cluster2.move_ao_to_another_cluster("D",@ao_cluster)
end

Then /^the activity offering is shown as part of the cluster$/ do
  #validate all ao_clusters
  @course_offering.activity_offering_cluster_list.each do |cluster|
    on ManageCourseOfferings do |page|
      actual_aos = page.get_cluster_assigned_ao_list(cluster.private_name)
      actual_aos.sort.should == cluster.assigned_ao_list.sort
    end
  end
end


When /^I create a(?:n| new) activity offering cluster$/ do
  @ao_cluster = make ActivityOfferingCluster
  @course_offering.add_ao_cluster(@ao_cluster)
end

Given /^the default activity offering cluster is present$/ do
   on ManageCourseOfferings do |page|
     #page.view_by_clusters
     page.cluster_div_list.length.should == 3
   end
end

Given /^all activity offerings are assigned to the ARG cluster$/ do
  on ManageCourseOfferings do |page|
    page.cluster_div_list.each do |cluster|
      private_name = page.cluster_div_private_name(cluster)
      puts "private name: #{private_name}"
      puts "#{private_name} list: #{page.get_cluster_assigned_ao_list(private_name)}"
      page.view_cluster_reg_groups(private_name)
    end
  end
end

Given /^there are default registration groups for a course offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"BSCI215", :term=>Rollover::OPEN_SOC_TERM)
end

Given /^I have created an activity offering cluster and there are registration groups for a course offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"CHEM612", :term=>Rollover::OPEN_SOC_TERM)
  @course_offering.manage_registration_groups
  @ao_cluster = make ActivityOfferingCluster
  @course_offering.add_ao_cluster(@ao_cluster)
end

Given /^there are default registration groups for a catalog course offering$/ do
  @course_offering = make CourseOffering, :term=>Rollover::SOC_STATES_SOURCE_TERM, :course=>"BSCI425"
  @course_offering.manage
end


Given /^there is registration groups for a catalog course offering$/ do
  @course_offering = make CourseOffering, :term=>Rollover::SOC_STATES_SOURCE_TERM, :course=>"BSCI425"

end