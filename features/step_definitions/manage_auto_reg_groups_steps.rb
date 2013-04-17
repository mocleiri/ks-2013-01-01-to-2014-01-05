Given /^I manage registration groups for (?:a|the) course offering$/ do
  #@course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"BSCI283", :term => Rollover::MAIN_TEST_TERM_TARGET)
  #@course_offering.manage_registration_groups
  @course_offering = make CourseOffering, :course=>"CHEM237", :term => Rollover::MAIN_TEST_TERM_TARGET
  @course_offering.manage
end

When /^I move an activity offering to the cluster$/ do
  @course_offering.activity_offering_cluster_list[0].move_ao_to_another_cluster("A",@course_offering.activity_offering_cluster_list[1])
end

When /^I move a lab activity offering from the first activity offering cluster to the second activity offering cluster$/ do
  @ao_cluster2.move_ao_to_another_cluster("D",@ao_cluster)
end

Then /^the activity offering is shown as part of the cluster$/ do
  #validate all ao_clusters
  @course_offering.activity_offering_cluster_list.each do |cluster|
    on ManageCourseOfferings do |page|
      actual_aos = page.get_cluster_assigned_ao_list(cluster.private_name)
      actual_aos.sort.should == cluster.ao_code_list.sort unless actual_aos == nil
    end
  end
end

Given /^I have created an additional activity offering cluster for a catalog course offering$/ do
  @course_offering = make CourseOffering, :term=>Rollover::SOC_STATES_SOURCE_TERM, :course=>"BSCI425"
  @course_offering.manage
  ao_cluster = make ActivityOfferingCluster
  @course_offering.add_ao_cluster(ao_cluster)
end



When /^I create a(?:n| new) activity offering cluster$/ do
  ao_cluster = make ActivityOfferingCluster
  @course_offering.add_ao_cluster(ao_cluster)
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

Given /^I have created an additional activity offering cluster for a course offering$/ do
  #@course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"CHEM612", :term=>Rollover::OPEN_SOC_TERM)
  @course_offering = make CourseOffering, :course=>"CHEM612B", :term=>Rollover::OPEN_SOC_TERM
  @course_offering.manage
  ao_cluster = make ActivityOfferingCluster
  @course_offering.add_ao_cluster(ao_cluster)
end

Given /^there are default registration groups for a catalog course offering$/ do
  @course_offering = make CourseOffering, :term=>Rollover::SOC_STATES_SOURCE_TERM, :course=>"BSCI425"
  @course_offering.manage
end


Given /^there is registration groups for a catalog course offering$/ do
  @course_offering = make CourseOffering, :term=>Rollover::SOC_STATES_SOURCE_TERM, :course=>"BSCI425"

end

When /^I try to create a second activity offering cluster with the same private name$/ do
  ao_cluster2 = make ActivityOfferingCluster, :private_name=>@course_offering.activity_offering_cluster_list.last.private_name
  ao_cluster2.create
end

Then /^a cluster error message appears stating "(.*?)"$/ do |errMsg|
  on ManageCourseOfferings do |page|
    page.first_msg.include? errMsg
  end
end

Then /^I try to rename the second activity offering cluster to the same private name as the first$/ do
    @course_offering.activity_offering_cluster_list.last.rename :private_name=> @course_offering.activity_offering_cluster_list.first.private_name
end
Then /^I remove the newly created cluster$/ do
  @course_offering.activity_offering_cluster_list.each do  |aoc|
   if aoc.private_name !=  @course_offering.activity_offering_cluster_list.first.private_name
    @course_offering.delete_ao_cluster(aoc)
   end
  end
end

Then /^the edit Activity Offering page is displayed$/ do
  on ActivityOfferingMaintenance do |page|
    page.mainpage_section.present?.should be_true
  end
end

When /^I return from the edit Activity Offering page$/ do
  on ActivityOfferingMaintenance do |page|
    page.cancel
  end
end

And /^I submit the Activity Offering changes$/ do
  on ActivityOfferingMaintenance do |page|
    page.submit
  end
end

Then /^the Manage Course Offerings page is displayed$/ do
  on ManageCourseOfferings do |page|
    page.term.present?.should be_true
  end
end

Given /^I manage registration groups for a new course offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"CHEM135", :term=>"201301")
  @course_offering.manage
end

Then /^the Activity Offerings are present in the cluster table$/ do
  @course_offering.activity_offering_cluster_list[0].ao_list.count.should > 0
end

When /^the corresponding number of registration groups for each cluster is correct$/ do
  on ManageCourseOfferings do |page|
    @course_offering.activity_offering_cluster_list.each do |cluster|

      if page.view_reg_groups_table(cluster.private_name).present? == false
      page.view_cluster_reg_groups(cluster.private_name)
      end
      page.get_cluster_reg_groups_list(cluster.private_name).length.should == cluster.ao_list.count{|x| x.activity_type == "Discussion"} * cluster.ao_list.count{|x| x.activity_type == "Lecture"}

    end
  end
end

When /^Move one lab and one lecture activity offering to the second cluster$/ do
  on ManageCourseOfferings do |page|
    @course_offering.activity_offering_cluster_list[0].move_ao_to_another_cluster("A", @course_offering.activity_offering_cluster_list[1])
    @course_offering.activity_offering_cluster_list[0].move_ao_to_another_cluster("J", @course_offering.activity_offering_cluster_list[1])
  end
end