#Scenario: Edit Activity Offering Information attributes
When /^I change Activity Offering Information attributes$/ do
  # Activity Code can not be saved. This is a bug
  # Modify Total Maximum Enrollment to 100

  person = make Personnel, :id => "admin", :affiliation => "Instructor", :inst_effort => 30
  @activity_offering.edit :course_url => "www.google.com", :personnel_list => [person]
end

Then /^I am able to submit the changes$/ do
  @activity_offering.save
end


And /^verify that the changes of Information attributes have persisted$/ do
  @course_offering.manage
  @activity_offering.edit
  #sleep 6
  on ActivityOfferingMaintenance do |page|
    page.total_maximum_enrollment.value.should == @activity_offering.max_enrollment
    pers_id = @activity_offering.personnel_list[0].id
    page.get_inst_effort(pers_id).should == @activity_offering.personnel_list[0].inst_effort.to_s
    page.get_affiliation(pers_id).should == @activity_offering.personnel_list[0].affiliation
    page.course_url.should == @activity_offering.course_url
    # clean up
    #page.total_maximum_enrollment.set @orig_enroll
    page.cancel
  end
end


#Scenario: Edit Activity Offering Personnel attributes
When /^I change Personnel attributes$/ do
  # H.ERICD, admin are ids can be used.

  @teaching_assistant = make Personnel
  @teaching_assistant.id = @added_person_id
  @teaching_assistant.affiliation = "Teaching Assistant"
  @teaching_assistant.inst_effort = @effort_num

  @teaching_assistant.add_personnel :id=> @added_person_id, :affiliation => "Teaching Assistant", :inst_effort => 30
end

And /^verify that the changes of the Personnel attributes have persisted$/ do

  @course_offering.manage
  @course_offering.edit_ao :ao_code =>  @orig_ao_code
  #Personnel row added the deletion should succeed
  on ActivityOfferingMaintenance do |page|
    page.delete_id(@added_person_id)
    page.submit
  end

end

#Scenario: Edit Miscellaneous Activity Offering attributes
When /^I change Miscellaneous Activity Offering attributes$/ do

  on ActivityOfferingMaintenance do |page|
    page.course_url.set  @misc_url
    page.requires_evaluation.set
    page.honors_flag.set
  end

end


And /^verify that the changes of Miscellaneous have persisted$/ do

  @course_offering.manage
  @course_offering.edit_ao :ao_code =>  @orig_ao_code
  on ActivityOfferingMaintenance do |page|
    page.course_url.value.should ==  @misc_url
    page.requires_evaluation.set? == true
    page.honors_flag.set? == true
    page.course_url.set ""
    page.requires_evaluation.clear
    page.honors_flag.clear
    page.submit
  end

end

Given /^I manage a given Course Offering$/ do
  #@course_offering = create CourseOffering, :create_by_copy => (make CourseOffering, :course=>"ENGL222")
  @course_offering = make CourseOffering, :course=>"ENGL222H"
  @course_offering.manage_and_init
end

Given /^I edit an Activity Offering$/ do
  @activity_offering = @course_offering.activity_offering_cluster_list[0].get_ao_obj_by_code("A")

  #@total_number = @course_offering.activity_offering_cluster_list[0].ao_list.count
  #@orig_ao_code = @course_offering.activity_offering_cluster_list[0].ao_list[@total_number-1].code
  #@added_person_id = "admin"
  #@effort_num = 30
  #@misc_url =
  #
  #@course_offering.edit_ao :ao_code =>  @orig_ao_code
end