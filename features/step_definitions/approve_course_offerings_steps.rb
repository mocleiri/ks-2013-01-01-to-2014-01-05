When /^I create two new Course Offerings$/ do
  @course_offering_ENGL221 = create CourseOffering, :create_by_copy => (make CourseOffering, :term=> "201505", :course => "ENGL221")
  @course_offering_ENGL101 = create CourseOffering, :create_by_copy => (make CourseOffering, :term=> "201505", :course => "ENGL101")
end

And /^I approve the two Course Offerings for scheduling$/ do
  @course_offering_ENGL221.search_by_subjectcode
  on ManageCourseOfferingList do |page|
#    page.select_cos([@course_offering_ENGL221.course])
    begin
      page.select_co(@course_offering_ENGL221.course.upcase)
      page.select_co(@course_offering_ENGL101.course.upcase)
      page.approve_course_offering
      page.approve_yes
    rescue Timeout::Error => e
      puts "rescued target_row edit"
    end
  end
end

When /^I manage a Course Offering$/ do
#to make each scenario independent, we make a new co
  @course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :term=> "201505", :course => "ENGL101")
end

And /^I approve the Course Offering for scheduling$/ do
  @course_offering.search_by_subjectcode
  on ManageCourseOfferingList do |page|
    page.select_co(@course_offering.course.upcase)
    page.approve_course_offering
    page.approve_yes
  end
end

And /^I approve selected Activity Offerings for scheduling$/ do
  @new_ao_list = ["A", "B"]
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.select_aos(@new_ao_list)
    page.approve_activity
  end
end

Then /^the Activity Offerings of these two COs should be in Approved state$/ do
  @course_offering_ENGL221.manage_and_init
  @new_cluster_list = @course_offering_ENGL221.activity_offering_cluster_list
  @ao_list = @new_cluster_list[0].ao_list
  for @ao in  @ao_list
    state = @course_offering_ENGL221.ao_status :inputs=>[@ao.code, "Approved"]
    state.should == "Approved"
  end
  @course_offering_ENGL101.manage_and_init
  @new_cluster_list = @course_offering_ENGL101.activity_offering_cluster_list
  @ao_list = @new_cluster_list[0].ao_list
  for @ao in  @ao_list
    state = @course_offering_ENGL101.ao_status :inputs=>[@ao.code, "Approved"]
    state.should == "Approved"
  end
end

Then /^the Activity Offerings should be in Approved state$/ do
  @course_offering.manage_and_init
  @new_cluster_list = @course_offering.activity_offering_cluster_list
  @ao_list = @new_cluster_list[0].ao_list
  for @ao in  @ao_list
    state = @course_offering.ao_status :inputs=>[@ao.code, "Approved"]
    state.should == "Approved"
  end
end

Then /^the selected Activity Offerings should be in Approved state$/ do
  @course_offering.manage_and_init
  @selected_ao_list = ["A", "B"]
  for code in @selected_ao_list
    state = @course_offering.ao_status :inputs=>[code, "Approved"]
    state.should == "Approved"
 end
end